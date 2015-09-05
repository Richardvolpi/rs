#ifndef url_h
#define url_h

// ----------------
// Global routines
// ----------------
void SplitURL(	KString		URL,
				KString&	RProtocol,
				KString&	RAddress,
				KString&	RResource);

KString AssembleURL(LPCTSTR	pProtocol,
					LPCTSTR pAddress,
					LPCTSTR pResource);

#endif // url_h