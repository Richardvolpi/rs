#ifndef ktl_globals_h
#define ktl_globals_h

#include "module_globals.h"
#include "kfc_ktl_api.h"

// ------------
// KTL globals
// ------------
class KFC_KTL_API TKTLGlobals : public TModuleGlobals
{
public:
	TKTLGlobals();
};

extern KFC_KTL_API TKTLGlobals g_KTLGlobals;

#endif // ktl_globals_h
