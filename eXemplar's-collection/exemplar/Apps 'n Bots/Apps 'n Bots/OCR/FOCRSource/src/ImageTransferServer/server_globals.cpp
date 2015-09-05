#include "server_pch.h"
#include "server_globals.h"

#include <KFC_KTL\ktl_globals.h>
#include <KFC_Common\common_globals.h>
#include <KFC_Networking\networking_globals.h>
#include "server_device_globals.h"

TServerGlobals g_ServerGlobals;

// ---------------
// Server globals
// ---------------
TServerGlobals::TServerGlobals() : TModuleGlobals(TEXT("Server globals"), 4)
{
	AddSubGlobals(g_KTLGlobals);
	AddSubGlobals(g_CommonGlobals);
	AddSubGlobals(g_NetworkingGlobals);
	AddSubGlobals(g_ServerDeviceGlobals);
}