#ifndef ktl_tokens_h
#define ktl_tokens_h

#include "token.h"
#include "globals.h"
#include "kfc_ktl_api.h"

// -----------
// KTL tokens
// -----------
class KFC_KTL_API TKTLTokens : public TGlobals
{
private:
	void OnUninitialize	();
	void OnInitialize	();

public:
	TKTLTokens();
};

extern KFC_KTL_API TKTLTokens g_KTLTokens;

#endif // ktl_tokens_h
