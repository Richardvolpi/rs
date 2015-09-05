#include "kfc_common_pch.h"
#include "module.h"

// ----------------
// Global routines
// ----------------
HMODULE GetKModuleHandle(LPCTSTR pName)
{
	const HMODULE hModule = GetModuleHandle(pName);

	if(hModule == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error getting module handle for \"") +
											NullString(pName) +
											TEXT("\""),
										GetLastError());
	}

	return hModule;
}

KString GetKModuleFileName(HMODULE hModule)
{
	TCHAR Buffer[1024];

	if(!GetModuleFileName(hModule, Buffer, sizeof(Buffer) - 1))
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error getting module filename"),
										GetLastError());
	}

	return Buffer;
}