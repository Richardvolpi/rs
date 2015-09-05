#ifndef hex_h
#define hex_h

#include "kfc_ktl_api.h"

// ----------------
// Global routines
// ----------------
KFC_KTL_API TCHAR HexToChar(size_t szValue);

KFC_KTL_API size_t CharToHex(TCHAR cChar);

#endif // hex_h