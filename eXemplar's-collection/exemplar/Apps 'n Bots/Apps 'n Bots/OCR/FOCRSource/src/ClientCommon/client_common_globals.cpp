#include "client_common_pch.h"
#include "client_common_globals.h"

#include <KFC_KTL\ktl_globals.h>
#include <KFC_Common\common_globals.h>
#include <KFC_Networking\networking_globals.h>
#include "client_common_device_globals.h"

TClientCommonGlobals g_ClientCommonGlobals;

// ----------------------
// Client common globals
// ----------------------
TClientCommonGlobals::TClientCommonGlobals() : TModuleGlobals(TEXT("Client common globals"), 4)
{
	AddSubGlobals(g_KTLGlobals);
	AddSubGlobals(g_CommonGlobals);
	AddSubGlobals(g_NetworkingGlobals);
	AddSubGlobals(g_ClientCommonDeviceGlobals);
}