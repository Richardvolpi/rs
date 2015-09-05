#include "kfc_common_pch.h"
#include "common_initials.h"

#include "common_consts.h"

TCommonInitials g_CommonInitials;

// ----------------
// Common initials
// ----------------
TCommonInitials::TCommonInitials() : TGlobals(TEXT("Common initials"), 0)
{
}

void TCommonInitials::OnUninitialize()
{
}

void TCommonInitials::OnInitialize()
{
	if(!g_CommonConsts.m_bSkipBasicCfgInitials)
		Load(), Save();
}

void TCommonInitials::LoadItems(KRegistryKey& Key)
{
}

void TCommonInitials::SaveItems(KRegistryKey& Key) const
{
}

void TCommonInitials::Load()
{
	TAssignmentsList::Load(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_CommonConsts.m_RegistryKeyName +
							g_CommonConsts.m_InitialsRegistryKeyName);
}

void TCommonInitials::Save() const
{
	TAssignmentsList::Save(	g_CommonConsts.m_ApplicationRegistryKeyName +
							g_CommonConsts.m_RegistryKeyName +
							g_CommonConsts.m_InitialsRegistryKeyName);
}
