#include "server_pch.h"
#include "url.h"

// ----------------
// Global routines
// ----------------
void SplitURL(	KString		URL,
				KString&	RProtocol,
				KString&	RAddress,
				KString&	RResource)
{
	int i;

	URL = URL.Trim();

	RProtocol = TEXT("http");

	i = URL.Find(TEXT("://"));
	if(i >= 0)
	{
		RProtocol = URL.Left(i);
		URL = URL.Mid(i + 3);
	}

	i = URL.Find("/");
	if(i >= 0)
		RAddress = URL.Left(i), RResource = URL.Mid(i);
	else
		RAddress = URL, RResource = TEXT("/");
}

KString AssembleURL(LPCTSTR	pProtocol,
					LPCTSTR pAddress,
					LPCTSTR pResource)
{
	return	(KString)pProtocol	+
				TEXT("://")		+
				pAddress		+
				pResource;
}