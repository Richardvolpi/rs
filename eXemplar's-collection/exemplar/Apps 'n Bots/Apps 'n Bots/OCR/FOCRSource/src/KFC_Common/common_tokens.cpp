#include "kfc_common_pch.h"
#include "common_tokens.h"

#include "common_consts.h"
#include "common_cfg.h"
#include "common_initials.h"
#include "startup_globals.h"

TCommonTokens g_CommonTokens;

// --------------
// Common tokens
// --------------
TCommonTokens::TCommonTokens() : TGlobals(TEXT("Common tokens"), 3)
{
	AddSubGlobals(g_CommonCfg);
	AddSubGlobals(g_CommonInitials);
	AddSubGlobals(g_StartUpGlobals);
}

void TCommonTokens::OnUninitialize()
{
	m_FileNameTokensRegisterer.Release();

	m_FileNameTokens.Release();
}

void TCommonTokens::OnInitialize()
{
	m_FileNameTokens.Allocate(TArrayAllocation(128, 128));

	// --- Filename tokens ---
	m_FileNameTokensRegisterer.Allocate(FILENAME_TOKENS);

	m_FileNameTokensRegisterer.Add(TEXT("[TempFileNamePrefix]"),	g_CommonConsts.m_TempFileNamePrefix);
	m_FileNameTokensRegisterer.Add(TEXT("[DefinitionsFolder]"),		g_CommonConsts.m_DefinitionsFolderName);
	m_FileNameTokensRegisterer.Add(TEXT("[StartFolder]"),			g_StartUpGlobals.m_StartFolder);
	m_FileNameTokensRegisterer.Add(TEXT("[WindowsFolder]"),			g_StartUpGlobals.m_WindowsFolder);
	m_FileNameTokensRegisterer.Add(TEXT("[SystemFolder]"),			g_StartUpGlobals.m_SystemFolder);
	m_FileNameTokensRegisterer.Add(TEXT("[TempFolder]"),			g_StartUpGlobals.m_TempFolder);
}
