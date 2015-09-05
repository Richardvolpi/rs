#include "kfc_common_pch.h"
#include "common_consts.h"

TCommonConsts g_CommonConsts;

// --------------
// Common consts
// --------------
TCommonConsts::TCommonConsts()
{
	// Behavior
	m_bStartFolderNeeded = true;
	m_bTimeGlobalsNeeded = true;

	// Registry
	m_RegistryKeyName = TEXT("Common\\");	

	// Names and handles
	m_ApplicationGUIDString = TEXT("KFC{526741CB-9F13-4614-8E6B-34CA41174703}");

	// Strings
	m_szTabSize = 4;

	// Files
	m_szFileCopyBufferSize = 65536;

	// Filenames
	m_TempFileNamePrefix	= TEXT("Temp");
	m_DefinitionsFolderName	= TEXT("Definitions\\");
	
	// Global registry
	m_szRegistryKeyTimeout			= 500;
	m_ApplicationRegistryKeyName	= TEXT("Software\\ECCM Corp.\\KFC Defaults\\");
	m_CfgRegistryKeyName			= TEXT("Configuration\\");
	m_InitialsRegistryKeyName		= TEXT("Initials\\");

	// Min portion sizes	
	size_t m_szDefaultCompoundInterpolatorMinPortionSize	= 1024;
	size_t m_szDefaultMessageProcessorMinPortionSize		= 256;
	size_t m_szDefaultInterpolatorProcessorMinPortionSize	= 2048;

	// Allocations
	m_DefaultInterpolatorFinishedMessageMapAllocation.Set(64, 64);

	// Timelimit
#ifdef _DEBUG

	m_FirstStartValueName	= TEXT("FirstStart");
	m_LastStartValueName	= TEXT("LastStart");
	m_ExpiredValueName		= TEXT("Expired");
	m_HackedValueName		= TEXT("Hacked");

#else _DEBUG

	m_FirstStartValueName	= TEXT("{BDA8A2BD-9BCD-4234-B1DE-CD488255DF3B}");
	m_LastStartValueName	= TEXT("{D04C7236-F9B0-4f17-9A45-458A95E87530}");
	m_ExpiredValueName		= TEXT("{52D2C0E7-21EC-4b20-89A0-E1F0E670A63D}");
	m_HackedValueName		= TEXT("{4B93F146-2482-403a-9C22-7E5B7EB8A647}");

#endif // _DEBUG

	// Redundancy
	m_bSkipBasicCfgInitials = true;
}