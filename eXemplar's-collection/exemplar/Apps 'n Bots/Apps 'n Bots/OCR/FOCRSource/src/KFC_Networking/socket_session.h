#ifndef server_session_h
#define server_session_h

#include <KFC_KTL\date_time.h>
#include "socket.h"

#define END_SOCKET_SESSION_CMD_ID	(0)

// ---------------------
// Server command entry
// ---------------------
template <class HostClassType>
struct TServerCommandEntry
{
	typedef bool (HostClassType::*THandler)(TSocket&			Socket,
											const TDateTime&	CurDT,
											size_t				szID);

	size_t		m_szID;
	THandler	m_pHandler;


	bool IsValid() const;

	TServerCommandEntry();

	TServerCommandEntry(size_t szSID, THandler pSHandler);

	void Set(size_t szSID, THandler pSHandler);

	bool Handle(HostClassType*		pObject,
				TSocket&			Socket,
				const TDateTime&	CurDT,
				size_t				szID) const;
};

template <class HostClassType>
TServerCommandEntry<HostClassType>::TServerCommandEntry()
{
	m_szID		= UINT_MAX;
	m_pHandler	= NULL;
}

template <class HostClassType>
TServerCommandEntry<HostClassType>::TServerCommandEntry(size_t szSID, THandler pSHandler)
{
	Set(szSID, pSHandler);
}

template <class HostClassType>
bool TServerCommandEntry<HostClassType>::IsValid() const
{
	return	m_szID		!= UINT_MAX &&
			m_szID		!= END_SOCKET_SESSION_CMD_ID &&
			m_pHandler;
}

template <class HostClassType>
void TServerCommandEntry<HostClassType>::Set(size_t szSID, THandler pSHandler)
{
	DEBUG_VERIFY(szSID != UINT_MAX && szSID != END_SOCKET_SESSION_CMD_ID);

	DEBUG_VERIFY(pSHandler);

	m_szID		= szSID;
	m_pHandler	= pSHandler;
}

template <class HostClassType>
bool TServerCommandEntry<HostClassType>::Handle(HostClassType*		pObject,
												TSocket&			Socket,
												const TDateTime&	CurDT,
												size_t				szID) const
{
	DEBUG_VERIFY(pObject);
	
	return (pObject->*m_pHandler)(Socket, CurDT, szID);
}

// ---------------
// Server session
// ---------------
template <class HostClassType>
class TServerSession
{
public:
	typedef TServerCommandEntry<HostClassType> TCommandEntry;

	typedef TValueArray<TCommandEntry, true> TCommandEntries;

private:
	bool m_bAllocated;

	HostClassType*			m_pObject;	
	const TCommandEntries*	m_pCommandEntries;
	TCommandEntry::THandler	m_pDefaultHandler;

public:
	TServerSession();

	TServerSession(	HostClassType&			SObject,
					const TCommandEntries&	SCommandEntries,
					TCommandEntry::THandler	pSDefaultHandler = NULL);

	~TServerSession() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	HostClassType&			SObject,
					const TCommandEntries&	SCommandEntries,
					TCommandEntry::THandler	pSDefaultHandler = NULL);

	void ProcessCommand(TSocket& Socket, size_t szID);

	void RunCommandLoop(TSocket& Socket);
};

template <class HostClassType>
TServerSession<HostClassType>::TServerSession()
{
	m_bAllocated = false;

	m_pObject			= NULL;
	m_pCommandEntries	= NULL;
	m_pDefaultHandler	= NULL;
}

template <class HostClassType>
TServerSession<HostClassType>::TServerSession(	HostClassType&			SObject,
												const TCommandEntries&	SCommandEntries,
												TCommandEntry::THandler	pSDefaultHandler)
{
	m_bAllocated = false;
	
	m_pObject			= NULL;
	m_pCommandEntries	= NULL;
	m_pDefaultHandler	= NULL;
	
	Allocate(SObject, SCommandEntries, pSDefaultHandler);
}

template <class HostClassType>
void TServerSession<HostClassType>::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;
		
		m_pCommandEntries = NULL;
	}
}

template <class HostClassType>
void TServerSession<HostClassType>::Allocate(	HostClassType&			SObject,
												const TCommandEntries&	SCommandEntries,
												TCommandEntry::THandler	pSDefaultHandler)
{
	Release();

	try
	{
		// Command entries check-up
#ifdef _DEBUG

		size_t i, j;
		for(i = 0 ; i < SCommandEntries.GetN() ; i++)
		{
			if(!SCommandEntries[i].IsValid())
			{
				INITIATE_DEFINED_FAILURE("Server session command entries contains an invalid item(s)");
			}

			for(j = i + 1 ; j < SCommandEntries.GetN() ; j++)
			{
				if(SCommandEntries[i].m_szID == SCommandEntries[j].m_szID)
				{
					INITIATE_DEFINED_FAILURE("Server session command entries contains equal-ID items.");
				}
			}
		}

#endif // _DEBUG

		m_pObject			= &SObject;
		m_pCommandEntries	= &SCommandEntries;
		m_pDefaultHandler	= pSDefaultHandler;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

template <class HostClassType>
void TServerSession<HostClassType>::ProcessCommand(TSocket& Socket, size_t szID)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!Socket.IsEmpty());
	
	DEBUG_VERIFY(Socket.IsConnected());

	DEBUG_VERIFY(szID != UINT_MAX && szID != END_SOCKET_SESSION_CMD_ID);

	TDateTime CurDT;
	CurDT.GetCurrent();

	for(size_t i = 0 ; i < m_pCommandEntries->GetN() ; i++)
	{
		const TCommandEntry& CommandEntry = (*m_pCommandEntries)[i];
		
		if(CommandEntry.m_szID == szID)
		{
			if(!CommandEntry.Handle(m_pObject, Socket, CurDT, szID))
			{
				INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Server socket session failed to handle command %.8X using specified handler"), szID));
			}
			
			break;
		}
	}
	
	if(i == m_pCommandEntries->GetN())
	{
		if(	m_pDefaultHandler == NULL ||
			!(m_pObject->*m_pDefaultHandler)(Socket, CurDT, szID))
		{
			INITIATE_DEFINED_FAILURE(KString::Formatted(TEXT("Server socket session failed to handle command %.8X using default handler"), szID));
		}
	}
}

template <class HostClassType>
void TServerSession<HostClassType>::RunCommandLoop(TSocket& Socket)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!Socket.IsEmpty());

	DEBUG_VERIFY(Socket.IsConnected());

	for(;;)
	{
		size_t szID;
		Socket >> szID;

		if(szID == END_SOCKET_SESSION_CMD_ID)
			break;
		
		ProcessCommand(Socket, szID);
	}
}

// ---------------
// Client session
// ---------------
class KFC_NETWORKING_API TClientSession
{
private:
	bool m_bAllocated;

	TSocket* m_pSocket;

public:
	TClientSession();

	TClientSession(TSocket& SSocket);

	~TClientSession() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(TSocket& SSocket);
	
	// ---------------- TRIVIALS ----------------
	TSocket& GetSocket() { return *m_pSocket; }
};

#endif // server_session_h