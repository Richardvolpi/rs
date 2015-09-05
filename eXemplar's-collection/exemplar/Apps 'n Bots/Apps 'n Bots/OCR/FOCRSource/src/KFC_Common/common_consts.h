#ifndef common_consts_h
#define common_consts_h

#include <KFC_KTL\consts.h>
#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\basic_wintypes.h> 
#include <KFC_KTL\kstring.h>
#include <KFC_KTL\array.h>
#include "kfc_common_api.h"

// --------------
// Common consts
// --------------
class KFC_COMMON_API TCommonConsts : public TConsts
{
public:
	// Behavior
	bool m_bStartFolderNeeded;
	bool m_bTimeGlobalsNeeded;

	// Strings
	size_t m_szTabSize;


	// Names and handles
	KString m_ApplicationGUIDString; // change for the real application

	// Files
	size_t m_szFileCopyBufferSize;

	// Filenames
	KString	m_TempFileNamePrefix;
	KString m_DefinitionsFolderName;
	
	// Global registry
	size_t	m_szRegistryKeyTimeout;
	KString	m_ApplicationRegistryKeyName; // change for the real applications
	KString m_CfgRegistryKeyName;
	KString m_InitialsRegistryKeyName;

	// Shareware timeout settings
	KString m_SharewareInstallTimeRegistryKeyName;		// required to set for sharewares
	KString m_SharewareLastStartTimeRegistryKeyName;	// required to set for sharewares
	KString m_SharewareJustInstalledRegistyKeyName;		// required to set for sharewares
	KString m_SharewareExpiredRegistryKeyName;			// required to set for sharewares
	UINT	m_uiSharewareNonExpiredValue;				// required to set for sharewares
	size_t	m_szSharewareTimeoutHours;					// required to set for sharewares
	
	// Min portion sizes
	size_t m_szDefaultCompoundInterpolatorMinPortionSize;
	size_t m_szDefaultMessageProcessorMinPortionSize;
	size_t m_szDefaultInterpolatorProcessorMinPortionSize;

	// Allocations
	TArrayAllocation m_DefaultInterpolatorFinishedMessageMapAllocation;

	// Timelimit
	KString m_FirstStartValueName;
	KString m_LastStartValueName;
	KString m_ExpiredValueName;
	KString m_HackedValueName;

	// Redundancy
	bool m_bSkipBasicCfgInitials;


	TCommonConsts();
};

extern KFC_COMMON_API TCommonConsts g_CommonConsts;

#endif // common_consts_h