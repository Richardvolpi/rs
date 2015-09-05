#ifndef networking_cfg_h
#define networking_cfg_h

#include <KFC_KTL\globals.h>
#include <KFC_Common\assignments.h>
#include "kfc_networking_api.h"

// ---------------
// Networking cfg
// ---------------
class KFC_NETWORKING_API TNetworkingCfg :
	public TGlobals,
	public TAssignmentsList
{
private:
	void OnUninitialize	();
	void OnInitialize	();

	void LoadItems(KRegistryKey& Key);
	void SaveItems(KRegistryKey& Key) const;

public:
	TNetworkingCfg();

	void Load();
	void Save() const;
};

extern KFC_NETWORKING_API TNetworkingCfg g_NetworkingCfg;

#endif // networking_cfg_h
