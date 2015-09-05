#include "kfc_networking_pch.h"
#include "networking_tokens.h"

#include "networking_cfg.h"
#include "networking_initials.h"

TNetworkingTokens g_NetworkingTokens;

// ------------------
// Networking tokens
// ------------------
TNetworkingTokens::TNetworkingTokens() : TGlobals(TEXT("Networking tokens"), 2)
{
	AddSubGlobals(g_NetworkingCfg);
	AddSubGlobals(g_NetworkingInitials);
}

void TNetworkingTokens::OnInitialize()
{
}

void TNetworkingTokens::OnUninitialize()
{
}
