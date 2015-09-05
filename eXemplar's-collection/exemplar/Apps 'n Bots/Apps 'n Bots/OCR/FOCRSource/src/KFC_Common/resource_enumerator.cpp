#include "kfc_common_pch.h"
#include "resource_enumerator.h"

// --------------------
// Resource enumerator
// --------------------
TResourceEnumerator::TResourceEnumerator(	HMODULE hModule,
											LPCTSTR pType)
{
	DEBUG_VERIFY(pType);

	m_IDs.Allocate(TArrayAllocation(64, 64));

	if(	!EnumResourceNames(hModule, pType, StaticEnumProc, (LPARAM)this)	&&
			GetLastError() != NO_ERROR										&&
			GetLastError() != ERROR_RESOURCE_TYPE_NOT_FOUND)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error enumerating resources"),
										GetLastError());
	}

	m_szPos = 0;
}

BOOL CALLBACK TResourceEnumerator::StaticEnumProc(	HMODULE	hModule,
													LPCTSTR	pType,
													LPTSTR	pName,
													LPARAM	lParam)
{
	DEBUG_VERIFY(lParam);

	((TResourceEnumerator*)lParam)->m_IDs.Add() = (size_t)pName;

	return TRUE;
}

TResourceEnumerator::operator bool () const
{
	return m_szPos < m_IDs.GetN();
}

TResourceEnumerator& TResourceEnumerator::operator ++ ()
{
	DEBUG_VERIFY(*this);

	m_szPos++;

	return *this;
}

size_t TResourceEnumerator::GetID() const
{
	DEBUG_VERIFY(*this);

	return m_IDs[m_szPos];
}