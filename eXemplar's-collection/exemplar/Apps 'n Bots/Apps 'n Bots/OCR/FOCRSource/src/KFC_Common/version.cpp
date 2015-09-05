#include "kfc_common_pch.h"
#include "version.h"

// ----------------
// Global routines
// ----------------
int CompareVersions(const KString& Version1,
					const KString& Version2)
{
	KStrings Version1Parts;
	KStrings Version2Parts;

	// Getting version tokens
	Version1Parts.SplitToTokens(Version1, TEXT("."));
	Version2Parts.SplitToTokens(Version2, TEXT("."));

	KStrings::TConstIterator Iter1, Iter2;

	int iDif;

	// Comparing tokens left-to-right against each other
	for(Iter1 = Version1Parts.GetFirst(), Iter2 = Version2Parts.GetFirst() ;
		Iter1.IsValid() && Iter2.IsValid() ;
		++Iter1, ++Iter2)
	{
		// Integer value comparison
		if(_istdigit((*Iter1)[0]) && _istdigit((*Iter2)[0]))
		{
			if(iDif = Sign(_ttoi(*Iter1) - _ttoi(*Iter2)))
				return iDif;
		}
				
		// String value comparison
		if(iDif = Sign(Iter1->CompareNoCase(*Iter2)))
			return iDif;
	}

	if(iDif = Sign((int)Iter1.IsValid() - (int)Iter2.IsValid())) // version tokens length comparison
		return iDif;

	return 0;
}

bool IsWindowsNT()
{
	OSVERSIONINFO ovi;
	memset(&ovi, 0, sizeof(ovi)), ovi.dwOSVersionInfoSize = sizeof(ovi);

	GetVersionEx(&ovi);

	return ovi.dwPlatformId == VER_PLATFORM_WIN32_NT;
}