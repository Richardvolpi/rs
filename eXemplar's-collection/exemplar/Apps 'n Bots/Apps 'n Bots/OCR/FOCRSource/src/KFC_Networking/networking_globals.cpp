#include "kfc_networking_pch.h"
#include "networking_globals.h"

#include <KFC_KTL\ktl_globals.h>
#include <KFC_Common\common_globals.h>
#include "networking_cfg.h"
#include "networking_initials.h"
#include "networking_tokens.h"
#include "networking_device_globals.h"

TNetworkingGlobals g_NetworkingGlobals;

// -------------------
// Networking globals
// -------------------
TNetworkingGlobals::TNetworkingGlobals() : TModuleGlobals(TEXT("Networking globals"), 6)
{
	AddSubGlobals(g_KTLGlobals);
	AddSubGlobals(g_CommonGlobals);
	AddSubGlobals(g_NetworkingCfg);
	AddSubGlobals(g_NetworkingInitials);
	AddSubGlobals(g_NetworkingTokens);
	AddSubGlobals(g_NetworkingDeviceGlobals);
}
