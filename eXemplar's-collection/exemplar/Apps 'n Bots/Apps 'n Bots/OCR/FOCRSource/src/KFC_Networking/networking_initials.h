#ifndef networking_initials_h
#define networking_initials_h

#include <KFC_KTL\globals.h>
#include <KFC_Common\assignments.h>
#include "kfc_networking_api.h"

// --------------------
// Networking initials
// --------------------
class KFC_NETWORKING_API TNetworkingInitials :
	public TGlobals,
	public TAssignmentsList
{
private:
	void OnUninitialize	();
	void OnInitialize	();

	void LoadItems(KRegistryKey& Key);
	void SaveItems(KRegistryKey& Key) const;

public:
	TNetworkingInitials();

	void Load();
	void Save() const;
};

extern KFC_NETWORKING_API TNetworkingInitials g_NetworkingInitials;

#endif // networking_initials_h
