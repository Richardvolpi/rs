#ifndef socket_h
#define socket_h

#include "winsock_inc.h"
#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\basic_wintypes.h>
#include <KFC_KTL\kstring.h>
#include "kfc_networking_api.h"

// Socket waiting flags
#define SWF_READING		(0x0001)
#define SWF_WRITING		(0x0002)
#define SWF_EXCEPTION	(0x0004)

// -----------
// IP address
// -----------
struct KFC_NETWORKING_API TIPAddress
{
	DWORD m_dwAddress;


	TIPAddress() { Invalidate(); }

	TIPAddress(DWORD dwSAddress) { m_dwAddress = dwSAddress; }

	TIPAddress(	size_t szV1,
				size_t szV2,
				size_t szV3,
				size_t szV4)
	{
		Set(szV1, szV2, szV3, szV4);
	}

	bool IsValid() const { return m_dwAddress && m_dwAddress != UINT_MAX; }

	void Invalidate() { m_dwAddress = UINT_MAX; };

	TIPAddress& Set(size_t szV1,
					size_t szV2,
					size_t szV3,
					size_t szV4);

	operator in_addr* () { return (in_addr*)this; }

	operator const in_addr* () const { return (const in_addr*)this; }

	operator DWORD () const { return m_dwAddress; }

	operator KString () const;

	TIPAddress& operator = (DWORD dwIP)
	{
		m_dwAddress = dwIP;

		return *this;
	}

	bool operator == (const TIPAddress& SAddress) const
		{ return m_dwAddress == SAddress.m_dwAddress; }

	bool operator != (const TIPAddress& SAddress) const
		{ return m_dwAddress != SAddress.m_dwAddress; }
};

// ------------------
// IP socket address
// ------------------
struct KFC_NETWORKING_API TIPSocketAddress
{
private:
	short m_sFamily;

public:
	WORD		m_usPort;
	TIPAddress	m_Address;

private:
	BYTE m_PadZero[8];

public:
	TIPSocketAddress() : m_sFamily(AF_INET)
	{
		memset(m_PadZero, 0, sizeof(m_PadZero));

		Invalidate();
	}

	TIPSocketAddress(	const TIPAddress&	SAddress,
						size_t				szSPort) : m_sFamily(AF_INET)
	{
		memset(m_PadZero, 0, sizeof(m_PadZero));

		Set(SAddress, szSPort);		
	}

	TIPSocketAddress(	size_t szV1,
						size_t szV2,
						size_t szV3,
						size_t szV4,
						size_t szSPort) : m_sFamily(AF_INET)
	{
		memset(m_PadZero, 0, sizeof(m_PadZero));

		Set(szV1, szV2, szV3, szV4, szSPort);
	}

	void Invalidate() { m_usPort = USHRT_MAX, m_Address.Invalidate(); }

	TIPSocketAddress& Set(	const TIPAddress&	SAddress,
							size_t				szSPort);
	
	TIPSocketAddress& Set(	size_t szV1,
							size_t szV2,
							size_t szV3,
							size_t szV4,
							size_t szSPort);

	operator sockaddr* () { return (sockaddr*)this; }
	
	operator const sockaddr* () const { return (const sockaddr*)this; }

	operator sockaddr_in* () { return (sockaddr_in*)this; }
	
	operator const sockaddr_in* () const { return (const sockaddr_in*)this; }

	operator KString() const;

	bool operator == (const TIPSocketAddress& SAddress) const
	{
		// Assuming 'AF_INET' for both addresses
		return	m_usPort	== SAddress.m_usPort &&
				m_Address	== SAddress.m_Address;
	}

	bool operator != (const TIPSocketAddress& SAddress) const
	{
		// Assuming 'AF_INET' for both addresses
		return	m_usPort	!= SAddress.m_usPort ||
				m_Address	!= SAddress.m_Address;
	}

	// ---------------- TRIVIALS ----------------
	SHORT GetFamily() const { return m_sFamily; }
};

// -------
// Socket
// -------
class KFC_NETWORKING_API TSocket : public TStream
{
private:
	bool m_bAllocated;

	SOCKET m_Socket;

	bool m_bBinded;
	bool m_bListening;
	bool m_bConnected;

public:
	size_t m_szDelay;


	TSocket();

	~TSocket() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	short	sAddressFamily	= AF_INET,
					type_t	tpType			= SOCK_STREAM,
					size_t	szProtocol		= IPPROTO_TCP);

	void AllowBroadcast(bool bAllow = true);

	void Allocate(SOCKET SSocket);

	void ReOwn(TSocket& SSocket);

	void Invalidate();

	void Bind(const TIPSocketAddress& Address);

	void Listen(size_t szMaxConnections = SOMAXCONN);

	void Accept(TSocket& RSocket);

	void Connect(const TIPSocketAddress& Address);

	size_t ReceiveFrom(	void*				pRData,
						size_t				szLength,
						TIPSocketAddress*	pRFromAddress	= NULL,
						bool				bPeek			= false);

	size_t ReceiveAvailable(void*	pRData,
							size_t	szLength,
							bool	bPeek = false);

	void Receive(	void*	pRData,
					size_t	szLength,
					bool	bPeek = false);

	void SendTo(const TIPSocketAddress&	ToAddress,
				void*					pData,
				size_t					szLength);

	size_t SendAvailable(	const void*	pData,
							size_t		szLength);	

	void Send(	const void*	pData,
				size_t		szLength);

	flags_t WaitForEvent(flags_t flFlags, size_t szTimeout = INFINITE);

	SOCKET GetSocket() const;

	operator SOCKET () const { return GetSocket(); }

	void StreamRead(void* pRData, size_t szLength)
		{ Receive(pRData, szLength); }

	void StreamWrite(const void* pData, size_t szLength)
		{ Send(pData, szLength); }

	// ---------------- TRIVIALS ----------------
	bool IsBinded	() const { return m_bBinded;	}
	bool IsListening() const { return m_bListening;	}
	bool IsConnected() const { return m_bConnected;	}
};

// ------------------------
// Client socket connector
// ------------------------
class KFC_NETWORKING_API TClientSocketConnector
{
private:
	TSocket* m_pSocket;

public:
	TClientSocketConnector(	TSocket&				SSocket,
							const TIPSocketAddress&	Address);

	~TClientSocketConnector();

	// ---------------- TRIVIALS ----------------
	TSocket& GetSocket() { return *m_pSocket; }
};

// ------------------------
// Server socket connector
// ------------------------
class KFC_NETWORKING_API TServerSocketConnector
{
private:
	TSocket* m_pSocket;

public:
	TServerSocketConnector(	TSocket& SSocket,
							TSocket& ListenerSocket);

	~TServerSocketConnector();

	// ---------------- TRIVIALS ----------------
	TSocket& GetSocket() { return *m_pSocket; }
};

// ----------------
// Global routines
// ----------------
KFC_NETWORKING_API bool FromString(const KString& String, TIPAddress&		RAddress);
KFC_NETWORKING_API bool FromString(const KString& String, TIPSocketAddress&	RAddress);

#endif // socket_h
