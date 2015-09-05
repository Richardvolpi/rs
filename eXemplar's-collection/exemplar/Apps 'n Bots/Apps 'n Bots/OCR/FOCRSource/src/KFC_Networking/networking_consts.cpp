#include "kfc_networking_pch.h"
#include "networking_consts.h"

TNetworkingConsts g_NetworkingConsts;

// ------------------
// Networking consts
// ------------------
TNetworkingConsts::TNetworkingConsts()
{
	// Registry
	m_RegistryKeyName = TEXT("Networking\\");

	// Versions
	m_wWinSockVersion = MAKEWORD(2, 0);
}
