#include "kfc_networking_pch.h"
#include "networking_device_globals.h"

#include "networking_consts.h"
#include "networking_cfg.h"
#include "networking_initials.h"
#include "networking_tokens.h"

TNetworkingDeviceGlobals g_NetworkingDeviceGlobals;

// --------------------------
// Networking device globals
// --------------------------
TNetworkingDeviceGlobals::TNetworkingDeviceGlobals() : TGlobals(TEXT("Networking device globals"), 3)
{
	AddSubGlobals(g_NetworkingCfg);
	AddSubGlobals(g_NetworkingInitials);
	AddSubGlobals(g_NetworkingTokens);

	m_bStarted = false;
}

void TNetworkingDeviceGlobals::OnUninitialize()
{
	// WSA
	if(m_bStarted)
		WSACleanup(), m_bStarted = false;
}

void TNetworkingDeviceGlobals::OnInitialize()
{
	// WSA
	if(WSAStartup(g_NetworkingConsts.m_wWinSockVersion, &m_WSAData))
	{
		INITIATE_DEFINED_FAILURE(TEXT("Unable to initialize networking."));
	}

	if(m_WSAData.wVersion != g_NetworkingConsts.m_wWinSockVersion)
	{
		INITIATE_DEFINED_FAILURE(TEXT("Unable to load desired version network system DLL."));
	}

	m_bStarted = true;
}

TIPAddress TNetworkingDeviceGlobals::ResolveHostName(const KString& Name)
{
	DEBUG_VERIFY_INITIALIZATION;

	const HOSTENT* pHostent = gethostbyname(TAnsiString(Name));

	if(pHostent == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error resolving host \"") +
											Name +
											TEXT("\""),
										WSAGetLastError());
	}

	if(pHostent->h_addrtype != AF_INET)
	{
		INITIATE_DEFINED_FAILURE(	(KString)TEXT("Invalid address type on resolving host \"") +
										Name +
										TEXT("\""));
	}

	try
	{
		return TIPAddress(*(const DWORD*)pHostent->h_addr_list[0]);
	}

	catch(...)
	{
		INITIATE_DEFINED_FAILURE(	(KString)TEXT("Invalid address contents on resolving host \"") +
										Name +
										TEXT("\""));
	}
}
