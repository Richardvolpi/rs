#include "kfc_common_pch.h"
#include "critical_section.h"

// ------------------------
// Critical section locker
// ------------------------
TCriticalSectionLocker::TCriticalSectionLocker()
{
	m_pCriticalSection = NULL;
}

TCriticalSectionLocker::TCriticalSectionLocker(TCriticalSection& SCriticalSection)
{
	m_pCriticalSection = NULL;

	Allocate(SCriticalSection);
}

void TCriticalSectionLocker::Release()
{
	if(m_pCriticalSection)
		m_pCriticalSection->Unlock(), m_pCriticalSection = NULL;
}

void TCriticalSectionLocker::Allocate(TCriticalSection& SCriticalSetion)
{
	Release();

	try
	{
		SCriticalSetion.Lock();

		m_pCriticalSection = &SCriticalSetion;
	}
	
	catch(...)
	{
		Release();
		throw 1;
	}
}