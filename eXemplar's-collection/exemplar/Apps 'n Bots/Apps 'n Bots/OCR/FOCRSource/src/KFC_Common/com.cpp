#include "kfc_common_pch.h"
#include "com.h"

#include <KFC_KTL\win_inc.h>
#include <KFC_KTL\basic_wintypes.h>

// ----------------
// COM initializer
// ----------------
TCOMInitializer::TCOMInitializer()
{
	m_bAllocated = false;
}

TCOMInitializer::TCOMInitializer(bool bAllocate)
{
	m_bAllocated = false;

	if(bAllocate)
		Allocate();
}

void TCOMInitializer::Release()
{
	if(m_bAllocated)
	{
		m_bAllocated = false;

		CoUninitialize();
	}
}

void TCOMInitializer::Allocate()
{
	Release();

	try
	{
		HRESULT r = CoInitialize(NULL);
		if(r != S_OK && r != S_FALSE)
			INITIATE_FAILURE;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

// ----------------
// OLE initializer
// ----------------
TOLEInitializer::TOLEInitializer()
{
	m_bAllocated = false;
}

void TOLEInitializer::Release()
{
	if(m_bAllocated)
	{
		m_bAllocated = false;

		OleUninitialize();
	}
}

void TOLEInitializer::Allocate()
{
	Release();

	try
	{
		HRESULT r = OleInitialize(NULL);
		if(r != S_OK && r != S_FALSE)
			INITIATE_FAILURE;

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

// ----------------
// Global routines
// ----------------
GUID CreateGUID()
{
	GUID Guid;
	DEBUG_EVALUATE_VERIFY(CoCreateGuid(&Guid) == S_OK);

	return Guid;
}

KString KGUIDToString(REFCLSID rGUID)
{
	OLECHAR Buf[2048];

	Buf[StringFromGUID2(rGUID, Buf, sizeof(Buf) - 1)] = 0;

	if(Buf[0] == 0)
		return WRONG_GUID_TEXT;

	return (LPCTSTR)TDefaultString(Buf);
}

KString KCLSIDToString(REFCLSID rCLSID)
{
	LPOLESTR pBuf = NULL;

	if(StringFromCLSID(rCLSID, &pBuf))
		return WRONG_CLSID_TEXT;

	TDefaultString Ret = pBuf;

	CoTaskMemFree(pBuf);

	return (LPCTSTR)Ret;
}

KString KIIDToString(REFIID rIID)
{
	LPOLESTR pBuf = NULL;

	if(StringFromIID(rIID, &pBuf))
		return WRONG_IID_TEXT;

	TDefaultString Ret = pBuf;

	CoTaskMemFree(pBuf);

	return (LPCTSTR)Ret;
}