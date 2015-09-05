#ifndef module_globals_h
#define module_globals_h

#include "globals.h"
#include "kfc_ktl_api.h"

// ---------------
// Module globals
// ---------------
class KFC_KTL_API TModuleGlobals : public TGlobals
{
private:
	void OnUninitialize	() {}
	void OnInitialize	() {}

public:
	TModuleGlobals(	LPCTSTR	pSName,
					size_t	szNSubGlobals = 0) :

		TGlobals(	pSName,
					szNSubGlobals) {}
};

#endif // module_globals_h
