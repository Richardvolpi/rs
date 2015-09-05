#ifndef client_common_globals_h
#define client_common_globals_h

#include <KFC_KTL\module_globals.h>

// ----------------------
// Client common globals
// ----------------------
class TClientCommonGlobals : public TModuleGlobals
{
public:
	TClientCommonGlobals();
};

extern TClientCommonGlobals g_ClientCommonGlobals;

#endif // client_common_globals_h