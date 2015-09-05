#include "kfc_common_pch.h"
#include "global_mem.h"

// -----------
// Global mem
// -----------
TGlobalMem::TGlobalMem()
{	
	Invalidate();
}

TGlobalMem::TGlobalMem(HANDLE hSMem)
{
	Invalidate();

	Allocate(hSMem);
}

TGlobalMem::TGlobalMem(size_t szSize, flags_t flFlags)
{
	Invalidate();

	Allocate(szSize, flFlags);
}

void TGlobalMem::Invalidate()
{
	m_bAllocated = false;

	m_hMem = NULL;
}

void TGlobalMem::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		if(m_hMem)
			GlobalFree(m_hMem), m_hMem = NULL;
	}
}

void TGlobalMem::Allocate(HANDLE hSMem)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSMem);

		m_hMem = hSMem;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TGlobalMem::Allocate(size_t szSize, flags_t flFlags)
{
	Release();

	try
	{
		Allocate(GlobalAlloc(flFlags, szSize));

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TGlobalMem::ReOwn(TGlobalMem& SGlobalMem)
{
	Release();

	if(SGlobalMem.IsEmpty())
		return;

	m_hMem = SGlobalMem.m_hMem;

	SGlobalMem.Invalidate();

	m_bAllocated = true;
}

size_t TGlobalMem::GetSize() const
{
	DEBUG_VERIFY_ALLOCATION;

	return GlobalSize(*this);
}

void TGlobalMem::Lock(void*& pRData)
{
	DEBUG_VERIFY_ALLOCATION;

	pRData = GlobalLock(m_hMem);

	if(pRData == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error locking global mem"),
										GetLastError());
	}
}

void TGlobalMem::Unlock()
{
	DEBUG_VERIFY_ALLOCATION;

	GlobalUnlock(m_hMem);
}

// ------------------
// Global mem locker
// ------------------
TGlobalMemLocker::TGlobalMemLocker(TGlobalMem& SGlobalMem, void*& pRData)
{
	DEBUG_VERIFY(!SGlobalMem.IsEmpty());

	(m_pGlobalMem = &SGlobalMem)->Lock(pRData);
}

TGlobalMemLocker::~TGlobalMemLocker()
{
	if(m_pGlobalMem && !m_pGlobalMem->IsEmpty())
		m_pGlobalMem->Unlock();
}
