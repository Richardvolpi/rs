#include "kfc_common_pch.h"
#include "common_device_globals.h"

#include "common_consts.h"
#include "common_cfg.h"
#include "common_initials.h"
#include "common_tokens.h"
#include "module.h"

TCommonDeviceGlobals g_CommonDeviceGlobals;

// ----------------------
// Common device globals
// ----------------------
TCommonDeviceGlobals::TCommonDeviceGlobals() : TGlobals(TEXT("Common device globals"), 3)
{
	AddSubGlobals(g_CommonCfg);
	AddSubGlobals(g_CommonInitials);
	AddSubGlobals(g_CommonTokens);
}

void TCommonDeviceGlobals::OnUninitialize()
{
	m_MsgBoxesEvent.Release();

	m_COMInitializer.Release();
}

void TCommonDeviceGlobals::OnInitialize()
{
	m_COMInitializer.Allocate();

	m_MsgBoxesEvent.Allocate(true, true);
}