#include "kfc_ktl_pch.h"
#include "ktl_globals.h"

#include "ktl_tokens.h"

TKTLGlobals g_KTLGlobals;

// ------------
// KTL globals
// ------------
TKTLGlobals::TKTLGlobals() : TModuleGlobals(TEXT("KTL globals"), 1)
{
	AddSubGlobals(g_KTLTokens);
}
