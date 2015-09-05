#include "kfc_common_pch.h"
#include "common_cfg.h"

#include <limits.h>
#include <KFC_KTL\win_inc.h>
#include "common_consts.h"

TCommonCfg g_CommonCfg;

// -----------
// Common cfg
// -----------
TCommonCfg::TCommonCfg() : TGlobals(TEXT("Common cfg"))
{
}

void TCommonCfg::OnUninitialize()
{
}

void TCommonCfg::OnInitialize()
{
	if(!g_CommonConsts.m_bSkipBasicCfgInitials)
		Load(), Save();
}

void TCommonCfg::LoadItems(KRegistryKey& Key)
{	
}

void TCommonCfg::SaveItems(KRegistryKey& Key) const
{	
}

void TCommonCfg::Load()
{
	TAssignmentsList::Load(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_CommonConsts.m_RegistryKeyName +
							g_CommonConsts.m_CfgRegistryKeyName);
}

void TCommonCfg::Save() const
{
	TAssignmentsList::Save(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_CommonConsts.m_RegistryKeyName +
							g_CommonConsts.m_CfgRegistryKeyName);
}