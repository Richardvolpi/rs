#ifndef common_cfg_h
#define common_cfg_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\globals.h>
#include "kfc_common_api.h"
#include "assignments.h"

// -----------
// Common cfg
// -----------
class KFC_COMMON_API TCommonCfg :
	public TGlobals,
	public TAssignmentsList
{
private:
	void OnUninitialize	();
	void OnInitialize	();

	void LoadItems(KRegistryKey& Key);
	void SaveItems(KRegistryKey& Key) const;

public:
	TCommonCfg();

	void Load();
	void Save() const;
};

extern KFC_COMMON_API TCommonCfg g_CommonCfg;

#endif // common_cfg_h