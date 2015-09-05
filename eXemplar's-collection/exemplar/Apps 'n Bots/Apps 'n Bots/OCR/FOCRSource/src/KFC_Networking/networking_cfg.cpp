#include "kfc_networking_pch.h"
#include "networking_cfg.h"

#include <KFC_Common\common_consts.h>
#include "networking_consts.h"

TNetworkingCfg g_NetworkingCfg;

// ---------------
// Networking cfg
// ---------------
TNetworkingCfg::TNetworkingCfg() : TGlobals(TEXT("Networking cfg"), 0)
{
}

void TNetworkingCfg::OnUninitialize()
{
}

void TNetworkingCfg::OnInitialize()
{
	if(!g_CommonConsts.m_bSkipBasicCfgInitials)
		Load(), Save();
}

void TNetworkingCfg::LoadItems(KRegistryKey& Key)
{
}

void TNetworkingCfg::SaveItems(KRegistryKey& Key) const
{
}

void TNetworkingCfg::Load()
{
	TAssignmentsList::Load(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_NetworkingConsts.m_RegistryKeyName +
							g_CommonConsts.m_CfgRegistryKeyName);
}

void TNetworkingCfg::Save() const
{
	TAssignmentsList::Save(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_NetworkingConsts.m_RegistryKeyName +
							g_CommonConsts.m_CfgRegistryKeyName);
}
