#ifndef http_socket_h
#define http_socket_h

#include "http.h"

// ------------
// HTTP buffer
// ------------
class THTTPBuffer : public TValueArray<char, true>
{
public:
	THTTPBuffer()
	{
		Allocate(TArrayAllocation(1024, 1024));
	}
};

// ------------
// HTTP socket
// ------------
class THTTPSocket
{
private:
	bool m_bAllocated;

	SOCKET m_Socket;

	bool m_bConnected;

	SSL* m_pSSL;

	bool m_bSSLConnected;

public:
	THTTPSocket();

	THTTPSocket(LPCTSTR pAddress, bool bSecure);

	~THTTPSocket()
		{ Release(); }

	bool IsEmpty() const
		{ return !m_bAllocated; }

	void Release();

	void Allocate(LPCTSTR pAddress, bool bSecure);

	bool Receive(char& c);

	void Send(char c);

	bool ReceiveData(void* pData, size_t szLength);

	void SendData(const void* pData, size_t szLength);

	void ReceiveHTTP(	THTTPHeaderCommands&	RCommands,
						THTTPBuffer&			RData);

	void SendHTTP(	const THTTPHeaderCommands&	Commands,
					const THTTPBuffer&			Data);

	void InitiateShutDown();

	bool IsSecure() const;

	SOCKET GetSocket() const;

	operator SOCKET () const { return GetSocket(); }
};

// ----------------
// Global routines
// ---------------
KString SendSimpleHTTPRequest(LPCTSTR pURL);

#endif // http_socket_h
