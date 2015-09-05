#ifndef server_globals_h
#define server_globals_h

#include <KFC_KTL\module_globals.h>

// ---------------
// Server globals
// ---------------
class TServerGlobals : public TModuleGlobals
{
public:
	TServerGlobals();
};

extern TServerGlobals g_ServerGlobals;

#endif // server_globals_h