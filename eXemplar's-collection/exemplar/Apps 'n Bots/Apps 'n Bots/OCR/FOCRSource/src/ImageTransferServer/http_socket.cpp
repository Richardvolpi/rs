#include "server_pch.h"
#include "http_socket.h"

#include "server_device_globals.h"
#include "url.h"
#include "comdefs.h"

// ----------------
// Helper routines
// ----------------
static bool fnbrecv(SOCKET s, void* p, size_t l)
{
	byte* q = (byte*)p;

	while(l)
	{
		fd_set rset;
		FD_ZERO(&rset);
		FD_SET(s, &rset);

		fd_set eset;
		FD_ZERO(&eset);
		FD_SET(s, &eset);		

		int rl = recv(s, (char*)q, l, 0);

		if(rl <= 0)
		{
			if(WSAGetLastError() != WSAEWOULDBLOCK)
				return false;

			const timeval tm =
				{HTTP_TRANSFER_DELAY / 1000, HTTP_TRANSFER_DELAY % 1000 * 1000};

			if(select(0, &rset, NULL, &eset, &tm) < 1 || !FD_ISSET(s, &rset))
				return false;
		}
		else
		{
			q += rl, l -= rl;
		}
	}

	return true;
}

static bool fnbsend(SOCKET s, const void* p, size_t l)
{
	const byte* q = (const byte*)p;

	while(l)
	{
		fd_set wset;
		FD_ZERO(&wset);
		FD_SET(s, &wset);

		fd_set eset;
		FD_ZERO(&eset);
		FD_SET(s, &eset);		

		int sl = send(s, (const char*)q, l, 0);

		if(sl <= 0)
		{
			if(WSAGetLastError() != WSAEWOULDBLOCK)
				return false;

			const timeval tm =
				{HTTP_TRANSFER_DELAY / 1000, HTTP_TRANSFER_DELAY % 1000 * 1000};

			if(select(0, NULL, &wset, &eset, &tm) < 1 || FD_ISSET(s, &wset))
				return false;
		}
		else
		{
			q += sl, l -= sl;
		}
	}

	return true;
}

// ------------
// HTTP socket
// ------------
THTTPSocket::THTTPSocket()
{
	m_bAllocated = false;

	m_Socket = INVALID_SOCKET;

	m_bConnected = false;

	m_pSSL = NULL;

	m_bSSLConnected = false;
}

THTTPSocket::THTTPSocket(LPCTSTR pAddress, bool bSecure)
{
	m_bAllocated = false;

	m_Socket = INVALID_SOCKET;

	m_bConnected = false;

	m_pSSL = NULL;

	m_bSSLConnected = false;

	Allocate(pAddress, bSecure);
}

void THTTPSocket::Release()
{
	if(m_bSSLConnected)
		SSL_shutdown(m_pSSL), m_bSSLConnected = false;
	
	if(m_pSSL)
		SSL_free(m_pSSL), m_pSSL = NULL;

	if(m_bConnected)
		shutdown(m_Socket, SD_SEND), m_bConnected = false;

	if(m_Socket != INVALID_SOCKET)	
		closesocket(m_Socket), m_Socket = INVALID_SOCKET;
}

void THTTPSocket::Allocate(LPCTSTR pAddress, bool bSecure)
{
	Release();

	try
	{
		const HOSTENT* pHostent = gethostbyname(pAddress);

		if(pHostent == NULL)
			INITIATE_FAILURE;

		m_Socket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
		if(m_Socket == INVALID_SOCKET)
			INITIATE_FAILURE;

		DWORD	dwIP = *(DWORD*)pHostent->h_addr_list[0];
		WORD	wPort = htons(bSecure ? 443 : 80);

		sockaddr_in addr;
		memset(&addr, 0, sizeof(addr));

		addr.sin_family			= AF_INET;				
		addr.sin_addr.s_addr	= dwIP;
		addr.sin_port			= wPort;

		if(connect(m_Socket, (sockaddr*)&addr, sizeof(addr)))
		{
			if(WSAGetLastError() != WSAEWOULDBLOCK)
				INITIATE_FAILURE;

			const timeval tm =
				{HTTP_CONNECTION_DELAY / 1000, HTTP_CONNECTION_DELAY % 1000 * 1000};

			fd_set wset;
			FD_ZERO(&wset);
			FD_SET(m_Socket, &wset);

			fd_set eset;
			FD_ZERO(&eset);
			FD_SET(m_Socket, &eset);

			if(select(0, NULL, &wset, &eset, &tm) < 1 || !FD_ISSET(m_Socket, &wset))
				INITIATE_FAILURE;
		}

		m_bConnected = true;

		// Security
		if(bSecure)
		{
			m_pSSL = SSL_new(g_ServerDeviceGlobals.m_pSSLContext);

			if(m_pSSL == NULL)
				INITIATE_FAILURE;

			if(SSL_set_fd(m_pSSL, m_Socket) != 1)
				INITIATE_FAILURE;

			if(SSL_connect(m_pSSL) != 1)
				INITIATE_FAILURE;

			m_bSSLConnected = true;
		}

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

bool THTTPSocket::Receive(char& c)
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsSecure())
	{
		const int r = SSL_read(m_pSSL, &c, sizeof(c));

		if(r == 0)
			return false;

		if(r != 1)
			INITIATE_FAILURE;
	}
	else
	{
		const int r = recv(m_Socket, &c, sizeof(c), 0);

		if(r == 0)
			return false;

		if(r != 1)
			INITIATE_FAILURE;
	}

	return true;
}

void THTTPSocket::Send(char c)
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsSecure())
	{
		const int r = SSL_write(m_pSSL, &c, sizeof(c));

		if(r != 1)
			INITIATE_FAILURE;
	}
	else
	{
		const int r = send(m_Socket, &c, sizeof(c), 0);
		if(r != 1)
			INITIATE_FAILURE;
	}
}

bool THTTPSocket::ReceiveData(void* pData, size_t szLength)
{
	DEBUG_VERIFY_ALLOCATION;

	while(szLength)
	{
		char c;
		if(!Receive(c))
			return false;

		*(BYTE*)pData = c, pData = (BYTE*)pData + 1, szLength--;
	}

	return true;
}

void THTTPSocket::SendData(const void* pData, size_t szLength)
{
	DEBUG_VERIFY_ALLOCATION;

	while(szLength)
	{
		Send(*(const BYTE*)pData);

		pData = (const BYTE*)pData + 1, szLength--;
	}
}

static void GetTokens(const char* s, const char* del, KString*& pRTokens, size_t& szRN)
{
	szRN = 0;
	
	{
		char* ss = strdup(s);

		char* p;
		for(p = strtok(ss, del) ; p ; p = strtok(NULL, del))
			szRN++;

		free(ss);
	}

	pRTokens = new KString[szRN], szRN = 0;

	{
		char* ss = strdup(s);

		char* p;
		for(p = strtok(ss, del) ; p ; p = strtok(NULL, del))
			pRTokens[szRN++] = p;

		free(ss);
	}
}

void THTTPSocket::ReceiveHTTP(	THTTPHeaderCommands&	RCommands,
								THTTPBuffer&			RData)
{
	DEBUG_VERIFY_ALLOCATION;

	RCommands.Clear();

	// Receiving headers
	THTTPBuffer HeadersBuffer;

	{
		char lc[3] = {0, 0, 0};

		for(;;)
		{
			char c;
			if(!Receive(c))
				INITIATE_FAILURE;		

			HeadersBuffer.Add() = c;

			lc[0] = lc[1], lc[1] = lc[2], lc[2] = c;

			if(	lc[1] == '\n' && lc[2] == '\n' ||
				lc[0] == '\n' && lc[1]== '\r' && lc[2]=='\n')
			{
				break;
			}

		}

		HeadersBuffer.Add() = 0;
	}

	// Parsing headers
	{
		KString*	pHeaderLines;
		size_t		szNHeaderLines;

		GetTokens(	HeadersBuffer.GetDataPtr(),
					"\r\n",
					pHeaderLines,
					szNHeaderLines);

		size_t i;
		for(i = 0 ; i < szNHeaderLines ; i++)
		{
			if(i == 0)
				RCommands.m_Result = pHeaderLines[i];
			else
				ParseHTTPHeaderCommand(pHeaderLines[i], *RCommands.AddLast());
		}

		delete[] pHeaderLines;
	}

	// Processing headers for data length
	size_t	szDataLength;
	bool	bChunked = false;

	{
		THTTPHeaderCommands::TConstIterator Iter;

		size_t	szContentLength	= UINT_MAX;
		bool	bClose			= false;

		for(Iter = RCommands.GetFirst() ; Iter.IsValid() ; ++Iter)
		{
			if(!strcmpi(Iter->m_Command, "Content-length"))
			{
				szContentLength = atoi(Iter->m_Content);
			}
			else if(!strcmpi(Iter->m_Command, "Connection") &&
					!strcmpi(Iter->m_Content, "close"))
			{
				bClose = true;
			}					
			else if(!strcmpi(Iter->m_Command, "Transfer-encoding") &&
					!strcmpi(Iter->m_Content, "chunked"))
			{
				bChunked = true;
			}
		}

		if(szContentLength != UINT_MAX)
			szDataLength = szContentLength;
		else if(bClose)
			szDataLength = UINT_MAX;
		else
			szDataLength = 0;
	}

	// Receiving data
	if(bChunked)
	{
		char	pc[2];
		size_t	cl;
		char	c;
		bool	f;

		for(;;)
		{
			// Receiving chunk length
			pc[0] = pc[1] = 0;

			cl = 0, f = false;

			for(;;)
			{
				if(pc[0] == '\r' && pc[1] == '\n')
					break;

				if(!Receive(c))
					INITIATE_FAILURE;

				if(!f)
				{
					c = tolower(c);

					if(isdigit(c) || c >= 'a' && c <= 'f')
						cl <<= 4, cl |= isdigit(c) ? c - '0' : c - 'a' + 10;
					else
						f = true;
				}

				pc[0] = pc[1], pc[1] = c;
			}

			if(cl == 0)
				break;

			// Receiving chunk data
			for( ; cl ; cl--)
			{
				if(!Receive(c))
					INITIATE_FAILURE;

				RData.Add() = c;
			}

			// Skipping post-data <CR><LF>
			if(	(!Receive(c) || c != '\r') ||
				(!Receive(c) || c != '\n'))
			{
				INITIATE_FAILURE;
			}
		}
	}
	else
	{
		if(szDataLength == UINT_MAX)
		{
			for(;;)
			{
				char c;
				if(!Receive(c))
					break;

				RData.Add() = c;
			}
		}
		else
		{
			RData.Add(szDataLength);

			if(!ReceiveData(RData.GetDataPtr(), RData.GetN()))
				INITIATE_FAILURE;
		}
	}
}

void THTTPSocket::SendHTTP(	const THTTPHeaderCommands&	Commands,
							const THTTPBuffer&			Data)
{
	DEBUG_VERIFY_ALLOCATION;

	// Sending header
	{
		KString str;

		str = Commands.m_Result + "\r\n";
		SendData(str, str.GetLength());

		THTTPHeaderCommands::TConstIterator Iter;
		for(Iter = Commands.GetFirst() ; Iter.IsValid() ; ++Iter)
		{			
			str.Format(	"%s: %s\r\n",
							(LPCTSTR)Iter->m_Command,
							(LPCTSTR)Iter->m_Content);

			SendData(str, str.GetLength());
		}

		str = "\r\n";
		SendData(str, str.GetLength());
	}
	
	// Sending data
	SendData(Data.GetDataPtr(), Data.GetN());
}

void THTTPSocket::InitiateShutDown()
{
	DEBUG_VERIFY_ALLOCATION;

	if(IsSecure())
		SSL_shutdown(m_pSSL);

	shutdown(m_Socket, SD_SEND);
}

bool THTTPSocket::IsSecure() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_pSSL != NULL;
}

SOCKET THTTPSocket::GetSocket() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Socket;
}

// ----------------
// Global routines
// ---------------
KString SendSimpleHTTPRequest(LPCTSTR pURL)
{
	DEBUG_VERIFY(pURL);

	KString Result;

	KString Protocol, Address, Resource;
	SplitURL(pURL, Protocol, Address, Resource);

	if(!IsSupportedHTTPProtocol(Protocol))
		INITIATE_DEFINED_FAILURE(TEXT("Unsupported HTTP protocol."));

	THTTPSocket Socket(Address, !Protocol.CollateNoCase(TEXT("https")));		

	// Sending request
	{
		THTTPHeaderCommands	Commands;
		THTTPBuffer			Data;

		Commands.m_Result = (KString)TEXT("GET ") + Resource + TEXT(" HTTP/1.0");

		Socket.SendHTTP(Commands, Data);
	}

	// Receiving reply
	{
		THTTPHeaderCommands	Commands;
		THTTPBuffer			Data;

		Socket.ReceiveHTTP(Commands, Data);		

		Result.Allocate(Data.GetN());

		memcpy(Result.GetDataPtr(), Data.GetDataPtr(), Data.GetN());
	}

	return Result;
}