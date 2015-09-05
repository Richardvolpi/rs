#ifndef assignments_h
#define assignments_h

#include <KFC_KTL\kstring.h>
#include "kfc_common_api.h"
#include "registry.h"

// -----------------
// Assignments list
// -----------------
class KFC_COMMON_API TAssignmentsList
{
protected:
	virtual void LoadItems(KRegistryKey& Key) = 0;
	virtual void SaveItems(KRegistryKey& Key) const = 0;

public:
	virtual ~TAssignmentsList() { TAssignmentsList::Release(); }

	virtual void Release();

	virtual void Allocate(HWND hWnd);

	void Load(const KString& KeyName);
	void Save(const KString& KeyName) const;
};

#endif // assignments_h
