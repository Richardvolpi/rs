#include "kfc_ktl_pch.h"
#include "ktl_tokens.h"

TKTLTokens g_KTLTokens;

// -----------
// KTL tokens
// -----------
TKTLTokens::TKTLTokens() : TGlobals(TEXT("KTL tokens"), 0)
{
}

void TKTLTokens::OnUninitialize()
{
}

void TKTLTokens::OnInitialize()
{
}
