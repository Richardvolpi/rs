#include "kfc_ktl_pch.h"
#include "ktl_consts.h"

TKTLConsts g_KTLConsts;

// -----------
// KTL consts
// -----------
TKTLConsts::TKTLConsts()
{
	m_bConsole = false;
	m_bService = false;

	m_DefaultStackedStoragePortionsAllocation.Set(64, 64);
}