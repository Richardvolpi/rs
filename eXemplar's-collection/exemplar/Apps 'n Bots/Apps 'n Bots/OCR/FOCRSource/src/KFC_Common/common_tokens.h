#ifndef common_tokens_h
#define common_tokens_h

#include <KFC_KTL\globals.h>
#include <KFC_KTL\token.h>
#include "kfc_common_api.h"

#define FILENAME_TOKENS		(g_CommonTokens.m_FileNameTokens)

// --------------
// Common tokens
// --------------
class KFC_COMMON_API TCommonTokens : public TGlobals
{
private:
	TTokensRegisterer m_FileNameTokensRegisterer;


	void OnUninitialize	();
	void OnInitialize	();
	
public:
	TTokens m_FileNameTokens;
	
		
	TCommonTokens();
};

extern KFC_COMMON_API TCommonTokens g_CommonTokens;

#endif // common_tokens_h
