#ifndef kfc_mem_h
#define kfc_mem_h

#include "basic_types.h"
#include "debug.h"
#include "kfc_ktl_api.h"

// ----------------
// Global routines
// ----------------
KFC_KTL_API void* kfc_malloc(size_t szSize);

KFC_KTL_API void* kfc_calloc(size_t szNum, size_t szSize);

KFC_KTL_API void* kfc_realloc(void* pData, size_t szSize);

KFC_KTL_API void kfc_free(void* pData);

#endif // kfc_mem_h