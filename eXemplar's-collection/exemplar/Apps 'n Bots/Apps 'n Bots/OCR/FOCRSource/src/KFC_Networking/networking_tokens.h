#ifndef networking_tokens_h
#define networking_tokens_h

#include <KFC_KTL\globals.h>
#include <KFC_KTL\token.h>
#include "kfc_networking_api.h"

// ------------------
// Networking tokens
// ------------------
class KFC_NETWORKING_API TNetworkingTokens : public TGlobals
{
private:
	void OnInitialize	();
	void OnUninitialize	();

public:
	TNetworkingTokens();
};

extern KFC_NETWORKING_API TNetworkingTokens g_NetworkingTokens;

#endif // networking_tokens_h
