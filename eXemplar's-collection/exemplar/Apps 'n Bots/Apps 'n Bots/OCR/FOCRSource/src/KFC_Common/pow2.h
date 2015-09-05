#ifndef pow2_h
#define pow2_h

#include <KFC_KTL\basic_types.h>
#include "kfc_common_api.h"

KFC_COMMON_API size_t HighestBit1	(UINT uiValue);
KFC_COMMON_API size_t LowestBit1	(UINT uiValue);

KFC_COMMON_API bool IsPow2(UINT uiValue);

KFC_COMMON_API UINT MaxPow2LessEq	(UINT uiValue);
KFC_COMMON_API UINT MinPow2GreaterEq(UINT uiValue);

#endif // pow2_h
