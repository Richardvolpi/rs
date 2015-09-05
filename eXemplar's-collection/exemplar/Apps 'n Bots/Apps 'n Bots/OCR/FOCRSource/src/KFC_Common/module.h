#ifndef module_h
#define module_h

#include "kfc_common_api.h"

// ----------------
// Global routines
// ----------------
KFC_COMMON_API HMODULE GetKModuleHandle(LPCTSTR pName = NULL);

KFC_COMMON_API KString GetKModuleFileName(HMODULE hModule = NULL);

#endif // module_h