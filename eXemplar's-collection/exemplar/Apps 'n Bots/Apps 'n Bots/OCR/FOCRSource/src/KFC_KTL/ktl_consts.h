#ifndef ktl_consts_h
#define ktl_consts_h

#include "basic_types.h"
#include "basic_bitypes.h"
#include "kfc_ktl_api.h"
#include "array.h"
#include "consts.h"
#include "stacked_storage.h"

// -----------
// KTL consts
// -----------
class KFC_KTL_API TKTLConsts : public TConsts
{
public:
	bool m_bConsole;
	bool m_bService;

	TArrayAllocation m_DefaultStackedStoragePortionsAllocation;


	TKTLConsts();
};

extern KFC_KTL_API TKTLConsts g_KTLConsts;

#endif // ktl_consts_h