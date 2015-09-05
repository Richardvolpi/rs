#ifndef networking_consts_h
#define networking_consts_h

#include <KFC_KTL\consts.h>
#include <KFC_KTL\kstring.h>
#include "kfc_networking_api.h"

// ------------------
// Networking consts
// ------------------
class KFC_NETWORKING_API TNetworkingConsts : public TConsts
{
public:
	TNetworkingConsts();

	// Versions
	WORD m_wWinSockVersion;
};

extern KFC_NETWORKING_API TNetworkingConsts g_NetworkingConsts;

#endif // networking_consts_h
