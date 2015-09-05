#include "kfc_common_pch.h"
#include "dll.h"

// ----
// DLL
// ----
TDLL::TDLL()
{
	m_bAllocated = false;

	m_hModule = NULL;
}

TDLL::TDLL(LPCTSTR pFileName)
{
	m_bAllocated = false;

	m_hModule = NULL;

	Allocate(pFileName);
}

TDLL::TDLL(HMODULE hSModule)
{
	m_bAllocated = false;

	m_hModule = NULL;

	Allocate(hSModule);
}

void TDLL::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		if(m_hModule)
			FreeLibrary(m_hModule), m_hModule = NULL;
	}
}

void TDLL::Allocate(LPCTSTR pFileName)
{
	Release();

	try
	{
		m_hModule = LoadLibrary(pFileName);

		if(m_hModule==NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error loading DLL \"") +
												pFileName +
												TEXT("\""),
											GetLastError());
		}

		m_bAllocated = true; 
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TDLL::Allocate(HMODULE hSModule)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSModule != NULL);
			
		m_hModule = hSModule;

		m_bAllocated = true;
	}
	
	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TDLL::ReOwn(TDLL& SDLL)
{
	Release();

	if(SDLL.IsEmpty())
		return;

	Allocate(SDLL.GetModule());

	SDLL.Invalidate();
}

void TDLL::Invalidate()
{
	DEBUG_VERIFY_ALLOCATION;

	m_hModule = NULL;

	Release();
}

void* TDLL::GetFunction(LPCSTR pFunctionName) const
{
	DEBUG_VERIFY_ALLOCATION;

	void* pAddress = GetProcAddress(m_hModule, pFunctionName);
	if(pAddress == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error retrieving \"") +
											pFunctionName +
											TEXT("\" from the DLL"),
										GetLastError());
	}

	return pAddress;
}

HMODULE TDLL::GetModule() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hModule;
}
