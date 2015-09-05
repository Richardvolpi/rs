#ifndef kstrings_h
#define kstrings_h

#include "kfc_ktl_api.h"
#include "vlist.h"
#include "kstring.h"

// --------
// Strings
// --------
class KFC_KTL_API KStrings : public TValueList<KString>
{
public:
	KStrings() {}

	KStrings(const KStrings& SStrings) : TValueList<KString>(SStrings) {}
	
	void SplitString(	const KString&	String,
						LPCTSTR			pSplitter,
						bool			bAddEmpty	= false,
						bool			bClearFirst	= true);

	void SplitToTokens(	const KString&	String,
						LPCTSTR			pDelimeters,
						bool			bClearFirst = true);

	bool HasString(const KString& String) const;

	bool HasStringNoCase(const KString& String) const;

	KString GenerateString(	LPCTSTR	pDelimeter,
							bool	bLastDelimeter = false) const;
};

DECLARE_LIST_STREAMING(KStrings);

#endif // kstrings_h
