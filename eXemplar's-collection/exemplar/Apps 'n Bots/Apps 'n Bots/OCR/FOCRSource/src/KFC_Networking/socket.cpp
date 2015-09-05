#include "kfc_networking_pch.h"
#include "socket.h"

// -----------
// IP address
// -----------
TIPAddress& TIPAddress::Set(size_t szV1,
							size_t szV2,
							size_t szV3,
							size_t szV4)
{
	DEBUG_VERIFY(szV1 < 256 && szV2 < 256 && szV3 < 256 && szV4 < 256);

	m_dwAddress = htonl((szV1 << 24) | (szV2 << 16) | (szV3 << 8) | szV4);

	return *this;
}

TIPAddress::operator KString () const
{
	const DWORD dwValue = ntohl(m_dwAddress);

	return KString::Formatted(	TEXT("%u.%u.%u.%u"),
									(dwValue >> 24),
									(dwValue >> 16)	& 0xFF,
									(dwValue >> 8)	& 0xFF,
									(dwValue)		& 0xFF);
}

// ------------------
// IP socket address
// ------------------
TIPSocketAddress& TIPSocketAddress::Set(const TIPAddress&	SAddress,
										size_t				szSPort)
{
	DEBUG_VERIFY(szSPort < 65536);

	m_Address = SAddress;

	m_usPort = htons((USHORT)szSPort);

	return *this;
}

TIPSocketAddress& TIPSocketAddress::Set(size_t szV1,
										size_t szV2,
										size_t szV3,
										size_t szV4,
										size_t szSPort)
{
	DEBUG_VERIFY(szSPort < 65536);

	m_Address.Set(szV1, szV2, szV3, szV4);

	m_usPort = htons((USHORT)szSPort);
	
	return *this;
}

TIPSocketAddress::operator KString () const
{
	return (KString)m_Address + TEXT(":") + (size_t)ntohs((USHORT)m_usPort);
}

// -------
// Socket
// -------
TSocket::TSocket()
{
	m_bAllocated = false;

	m_Socket = INVALID_SOCKET;
}

void TSocket::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		if(m_Socket != INVALID_SOCKET)
		{
			if(m_bConnected)
				shutdown(m_Socket, SD_BOTH);
			
			closesocket(m_Socket), m_Socket = INVALID_SOCKET;
		}
	}
}

void TSocket::Allocate(	short	sAddressFamily,
						type_t	tpType,
						size_t	szProtocol)
{
	Release();

	try
	{
		m_Socket = socket(sAddressFamily, tpType, szProtocol);

		if(m_Socket == INVALID_SOCKET)
		{
			INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error creating network socket."),
											WSAGetLastError());
		}		

		m_bBinded		= false;
		m_bListening	= false;
		m_bConnected	= false;

		m_szDelay = UINT_MAX;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TSocket::Allocate(SOCKET SSocket)
{
	Release();

	try
	{
		DEBUG_VERIFY(SSocket != INVALID_SOCKET);		

		m_Socket = SSocket;

		m_bBinded		= false;
		m_bListening	= false;
		m_bConnected	= true;

		m_szDelay = UINT_MAX;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TSocket::AllowBroadcast(bool bAllow)
{
	DEBUG_VERIFY_ALLOCATION;

	const BOOL bValue = bAllow ? TRUE : FALSE;
	if(setsockopt(m_Socket, SOL_SOCKET, SO_BROADCAST, (const char*)&bValue, sizeof(bValue)))
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error setting socket broadcast parameter."),
										WSAGetLastError());
	}
}

void TSocket::ReOwn(TSocket& SSocket)
{
	Release();

	if(SSocket.IsEmpty())
		return;

	Allocate(SSocket.GetSocket());

	SSocket.Invalidate();
}

void TSocket::Invalidate()
{
	m_Socket = INVALID_SOCKET;

	Release();
}

void TSocket::Bind(const TIPSocketAddress& Address)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!IsBinded());

	if(bind(*this, Address, sizeof(Address)) == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(TEXT("Error binding network socket"), WSAGetLastError());
	}

	m_bBinded = true;
}

void TSocket::Listen(size_t szMaxConnections)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsBinded() && !IsListening());

	if(listen(*this, szMaxConnections) == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(TEXT("Error setting up a listening network socket"), WSAGetLastError());
	}

	m_bListening = true;
}

void TSocket::Accept(TSocket& RSocket)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(IsListening());

	SOCKET Socket = accept(*this, NULL, NULL);
	if(Socket == INVALID_SOCKET)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error accepting network socket connection"),
										WSAGetLastError());
	}

	RSocket.Allocate(Socket);
}

void TSocket::Connect(const TIPSocketAddress& Address)
{
	DEBUG_VERIFY_ALLOCATION;
	
	DEBUG_VERIFY(!IsConnected());

	if(connect(*this, Address, sizeof(Address)) == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error connecting network socket"),
										WSAGetLastError());
	}

	m_bConnected = true;
}

size_t TSocket::ReceiveFrom(void*				pRData,
							size_t				szLength,
							TIPSocketAddress*	pRFromAddress,
							bool				bPeek)
{
	DEBUG_VERIFY_ALLOCATION;

	int iFromAddressSize = sizeof(*pRFromAddress);
	const size_t szReceived = recvfrom(	*this,
										(char*)pRData,
										szLength,
										bPeek ? MSG_PEEK : 0,
										(sockaddr*)pRFromAddress,
										pRFromAddress ? &iFromAddressSize : NULL);

	if(szReceived == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error reading available from the network socket"),
										WSAGetLastError());
	}

	if(pRFromAddress && pRFromAddress->GetFamily() != AF_INET)
	{
		INITIATE_DEFINED_FAILURE(TEXT("Invalid network socket peer address family."));
	}

	return szReceived;
}

size_t TSocket::ReceiveAvailable(	void*	pRData,
									size_t	szLength,
									bool	bPeek)
{
	DEBUG_VERIFY_ALLOCATION;

	if(szLength == 0)
		return 0;

	if(WaitForEvent(SWF_READING| SWF_EXCEPTION, m_szDelay) != SWF_READING)
		INITIATE_DEFINED_FAILURE(TEXT("Error waiting for data receive."));

	const size_t szReceived = recv(	*this,
									(char*)pRData,
									szLength,
									bPeek ? MSG_PEEK : 0);

	if(szReceived == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error receiving data throught the network socket"),
										WSAGetLastError());
	}

	if(szReceived == 0)
	{
		INITIATE_DEFINED_FAILURE(TEXT("Network socket was gracefully closed on receiving."));
	}

	return szReceived;
}

void TSocket::Receive(	void*	pRData,
						size_t	szLength,
						bool	bPeek)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(szLength == 0 || pRData);

	while(szLength > 0)
	{
		const size_t szReceived = ReceiveAvailable(pRData, szLength, bPeek);
		pRData = (BYTE*)pRData + szReceived, szLength -= szReceived;
	}
}

size_t TSocket::SendAvailable(	const void*	pData,
								size_t		szLength)
{
	DEBUG_VERIFY_ALLOCATION;
	
	if(szLength == 0)
		return 0;

	if(WaitForEvent(SWF_WRITING | SWF_EXCEPTION, m_szDelay) != SWF_WRITING)
		INITIATE_DEFINED_FAILURE(TEXT("Error waiting for data send."));
	
	const size_t szSent = send(*this, (const char*)pData, szLength, 0);
	
	if(szSent == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error sending data through the network socket"),
										WSAGetLastError());
	}
	
	return szSent;
}

void TSocket::SendTo(	const TIPSocketAddress&	ToAddress,
						void*					pData,
						size_t					szLength)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(szLength == 0 || pData);

	int r;

	if((r = sendto(	*this,
				(const char*)pData,
				szLength,
				0,
				(const sockaddr*)&ToAddress,
				sizeof(ToAddress))) != (int)szLength)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error sending complete datagram."),
										WSAGetLastError());
	}
}

void TSocket::Send(	const void*	pData,
					size_t		szLength)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(szLength == 0 || pData);

	while(szLength > 0)
	{
		const size_t szSent = SendAvailable(pData, szLength);
		pData = (const BYTE*)pData + szSent, szLength -= szSent;
	}
}

flags_t TSocket::WaitForEvent(flags_t flFlags, size_t szTimeout)
{
	DEBUG_VERIFY_ALLOCATION;

	fd_set ReadingSet;
	FD_ZERO(&ReadingSet);
	FD_SET(m_Socket, &ReadingSet);

	fd_set WritingSet;
	FD_ZERO(&WritingSet);
	FD_SET(m_Socket, &WritingSet);

	fd_set ExceptionSet;
	FD_ZERO(&ExceptionSet);
	FD_SET(m_Socket, &ExceptionSet);

	timeval TimeVal;

	if(szTimeout != INFINITE)
		TimeVal.tv_sec = szTimeout / 1000, TimeVal.tv_usec = (szTimeout % 1000) * 1000;

	const int r = select(	0,
							flFlags & SWF_READING	? &ReadingSet	: NULL,
							flFlags & SWF_WRITING	? &WritingSet	: NULL,
							flFlags & SWF_EXCEPTION	? &ExceptionSet	: NULL,
							szTimeout == INFINITE ? NULL : &TimeVal);

	if(r == SOCKET_ERROR)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error waiting on socket for receiving."),
										WSAGetLastError());
	}

	if((flFlags & SWF_READING) && !FD_ISSET(m_Socket, &ReadingSet))
		flFlags &= ~SWF_READING;

	if((flFlags & SWF_WRITING) && !FD_ISSET(m_Socket, &WritingSet))
		flFlags &= ~SWF_WRITING;

	if((flFlags & SWF_EXCEPTION) && !FD_ISSET(m_Socket, &ExceptionSet))
		flFlags &= ~SWF_EXCEPTION;

	return flFlags;
}

SOCKET TSocket::GetSocket() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Socket;
}

// ------------------------
// Client socket connector
// ------------------------
TClientSocketConnector::TClientSocketConnector(	TSocket&				SSocket,
												const TIPSocketAddress&	Address)
{
	DEBUG_VERIFY(!SSocket.IsEmpty());

	SSocket.Connect(Address), m_pSocket = &SSocket;
}
	
TClientSocketConnector::~TClientSocketConnector()
{
	m_pSocket->Release();
}

// ------------------------
// Server socket connector
// ------------------------
TServerSocketConnector::TServerSocketConnector(	TSocket& SSocket,
												TSocket& ListenerSocket)
{
	DEBUG_VERIFY(!ListenerSocket.IsEmpty());

	DEBUG_VERIFY(ListenerSocket.IsListening());

	ListenerSocket.Accept(SSocket), m_pSocket = &SSocket;
}
	
TServerSocketConnector::~TServerSocketConnector()
{
	m_pSocket->Release();
}

// ----------------
// Global routines
// ----------------
bool FromString(const KString& String, TIPAddress& RAddress)
{
	const KString TrimmedString = String.Trim();

	size_t szV1, szV2, szV3, szV4;
	if(_stscanf(TrimmedString, TEXT("%u.%u.%u.%u"), &szV1, &szV2, &szV3, &szV4) != 4)
		return false;

	if(szV1 >= 256 || szV2 >= 256 || szV3 >= 256 || szV4 >= 256)
		return false;

	RAddress.Set(szV1, szV2, szV3, szV4);

	return true;
}

bool FromString(const KString& String, TIPSocketAddress& RAddress)
{
	const KString& TrimmedString = String.Trim();

	size_t szV1, szV2, szV3, szV4, szPort;
	if(_stscanf(TrimmedString, TEXT("%u.%u.%u.%u:%u"), &szV1, &szV2, &szV3, &szV4, &szPort) != 5)
		return false;

	if(szV1 >= 256 || szV2 >= 256 || szV3 >= 256 || szV4 >= 256 || szPort >= 65536)
		return false;

	RAddress.Set(szV1, szV2, szV3, szV4, szPort);

	return true;
}
