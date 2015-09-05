#ifndef common_globals_h
#define common_globals_h

#include <KFC_KTL\module_globals.h>
#include "kfc_common_api.h"

// ---------------
// Common globals
// ---------------
class KFC_COMMON_API TCommonGlobals : public TModuleGlobals
{
public:
	TCommonGlobals();
};

extern KFC_COMMON_API TCommonGlobals g_CommonGlobals;

#endif // common_globals_h
