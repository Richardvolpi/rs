#include "kfc_common_pch.h"
#include "mutex.h"

// ------
// Mutex
// ------
TMutex::TMutex()
{
	m_hMutex = NULL;
}

void TMutex::Release()
{
	if(m_hMutex)
		CloseHandle(m_hMutex), m_hMutex = NULL;
}

bool TMutex::Create(bool	bInitialOwnership,
					LPCTSTR	pName)
{
	Release();

	try
	{
		m_hMutex = CreateMutex(NULL, bInitialOwnership, pName);
		if(m_hMutex == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(TEXT("Error creating mutex"), GetLastError());
		}

		return GetLastError() != ERROR_ALREADY_EXISTS;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TMutex::Open(LPCTSTR pName)
{
	Release();

	DEBUG_VERIFY(pName != NULL);

	try
	{
		m_hMutex = OpenMutex(MUTEX_ALL_ACCESS, FALSE, pName);
		if(m_hMutex == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error opening mutex:\r\n\"") +
												pName +
												TEXT("\"\r\n"),
											GetLastError());
		}
	}

	catch(...)
	{		
		Release();
		throw 1;
	}
}

bool TMutex::Lock(size_t szTimeout)
{
	DEBUG_VERIFY_ALLOCATION;

	DWORD r = WaitForSingleObject(m_hMutex, szTimeout);

	if(r == WAIT_ABANDONED)
	{
		INITIATE_DEFINED_FAILURE(TEXT("Mutex was abandoned."));
	}

	if(r == WAIT_TIMEOUT)
		return false;

	if(r == WAIT_OBJECT_0)
		return true;

	INITIATE_DEFINED_CODE_FAILURE(TEXT("Unknown mutex wait result."), r);
}

void TMutex::Unlock()
{
	DEBUG_VERIFY_ALLOCATION;
	
	ReleaseMutex(m_hMutex);
}

HANDLE TMutex::GetMutex() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hMutex;
}

// -------------
// Mutex locker
// -------------
TMutexLocker::TMutexLocker()
{
	m_pMutex = NULL;
}

TMutexLocker::TMutexLocker(	TMutex&	SMutex,
							size_t	szTimeout)
{
	m_pMutex = NULL;

	Allocate(SMutex, szTimeout);
}

void TMutexLocker::Release()
{
	if(m_pMutex)
		m_pMutex->Unlock(), m_pMutex = NULL;
}

bool TMutexLocker::Allocate(TMutex&	SMutex,
							size_t	szTimeout)
{
	Release();

	DEBUG_VERIFY(!SMutex.IsEmpty());

	try
	{
		if(!SMutex.Lock(szTimeout))
			return false;

		m_pMutex = &SMutex;
		
		return true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}
