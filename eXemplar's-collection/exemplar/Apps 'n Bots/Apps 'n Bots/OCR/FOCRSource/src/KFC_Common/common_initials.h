#ifndef common_initials_h
#define common_initials_h

#include <KFC_KTL\globals.h>
#include "kfc_common_api.h"
#include "assignments.h"

// ----------------
// Common initials
// ----------------
class KFC_COMMON_API TCommonInitials :
	public TGlobals,
	public TAssignmentsList
{
private:
	void OnUninitialize	();
	void OnInitialize	();

	void LoadItems(KRegistryKey& Key);
	void SaveItems(KRegistryKey& Key) const;

public:
	TCommonInitials();

	void Load();
	void Save() const;
};

extern KFC_COMMON_API TCommonInitials g_CommonInitials;

#endif // common_initials_h
