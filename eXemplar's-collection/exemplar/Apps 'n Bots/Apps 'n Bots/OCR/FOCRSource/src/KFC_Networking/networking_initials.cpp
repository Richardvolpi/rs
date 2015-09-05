#include "kfc_networking_pch.h"
#include "networking_initials.h"

#include <KFC_Common\common_consts.h>
#include "networking_consts.h"

TNetworkingInitials g_NetworkingInitials;

// --------------------
// Networking initials
// --------------------
TNetworkingInitials::TNetworkingInitials() : TGlobals(TEXT("Networking initials"), 0)
{
}

void TNetworkingInitials::OnUninitialize()
{
}

void TNetworkingInitials::OnInitialize()
{
	if(!g_CommonConsts.m_bSkipBasicCfgInitials)
		Load(), Save();
}

void TNetworkingInitials::LoadItems(KRegistryKey& Key)
{
}

void TNetworkingInitials::SaveItems(KRegistryKey& Key) const
{
}

void TNetworkingInitials::Load()
{
	TAssignmentsList::Load(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_NetworkingConsts.m_RegistryKeyName +
							g_CommonConsts.m_InitialsRegistryKeyName);
}

void TNetworkingInitials::Save() const
{
	TAssignmentsList::Save(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_NetworkingConsts.m_RegistryKeyName +
							g_CommonConsts.m_InitialsRegistryKeyName);
}
