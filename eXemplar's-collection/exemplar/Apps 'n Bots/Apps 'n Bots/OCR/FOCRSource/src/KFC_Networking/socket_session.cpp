#include "kfc_networking_pch.h"
#include "socket_session.h"

// ---------------
// Client session
// ---------------
TClientSession::TClientSession()
{
	m_bAllocated = false;

	m_pSocket = NULL;
}
	
TClientSession::TClientSession(TSocket& SSocket)
{
	m_bAllocated = false;

	m_pSocket = NULL;

	Allocate(SSocket);
}
	
void TClientSession::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		if(	!bFromAllocatorException &&
			m_pSocket && !m_pSocket->IsEmpty() && m_pSocket->IsConnected())
		{
			try { *m_pSocket << END_SOCKET_SESSION_CMD_ID; } catch(... ) {}
		}
	}
}
	
void TClientSession::Allocate(TSocket& SSocket)
{
	Release();

	try
	{
		DEBUG_VERIFY(!SSocket.IsEmpty());

		DEBUG_VERIFY(SSocket.IsConnected());

		m_pSocket = &SSocket;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}
