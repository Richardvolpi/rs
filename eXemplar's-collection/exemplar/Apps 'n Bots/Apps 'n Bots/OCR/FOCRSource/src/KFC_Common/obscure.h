#ifndef obscure_h
#define obscure_h

#include "kfc_common_api.h"
#include "registry.h"

// ----------------
// Global routines
// ----------------
KFC_COMMON_API void RandomRegistryScan(KRegistryKey& Key, size_t szTimes);

KFC_COMMON_API DWORD GetVolumeSerialNumber();

KFC_COMMON_API DWORD MultiplyBits(DWORD dwValue, const DWORD Matrix[32]);

#endif // obscure_h