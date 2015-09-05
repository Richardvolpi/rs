#ifndef networking_globals_h
#define networking_globals_h

#include <KFC_KTL\module_globals.h>
#include "kfc_networking_api.h"

// -------------------
// Networking globals
// -------------------
class KFC_NETWORKING_API TNetworkingGlobals : public TModuleGlobals
{
public:
	TNetworkingGlobals();
};

extern KFC_NETWORKING_API TNetworkingGlobals g_NetworkingGlobals;

#endif // networking_globals_h
