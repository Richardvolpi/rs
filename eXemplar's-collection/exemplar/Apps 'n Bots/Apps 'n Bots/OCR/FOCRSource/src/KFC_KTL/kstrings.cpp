#include "kfc_ktl_pch.h"
#include "kstrings.h"

// --------
// Strings
// --------
void KStrings::SplitString(	const KString&	String,
							LPCTSTR			pSplitter,
							bool			bAddEmpty,
							bool			bClearFirst)
{
	if(bClearFirst)
		Clear();

	const size_t szSplitterLength = _tcslen(pSplitter);

	size_t szPos = 0;
	for(;;)
	{
		size_t szOldPos = szPos;
		szPos = String.Find(pSplitter, szPos);
		if(szPos == UINT_MAX)
		{
			if(bAddEmpty || szOldPos < String.GetLength())
				*AddLast() = String.Mid(szOldPos);

			break;
		}

		if(bAddEmpty || szPos > szOldPos)
			*AddLast() = String.Mid(szOldPos, szPos - szOldPos), szPos += szSplitterLength;
	}
}

void KStrings::SplitToTokens(	const KString&	String,
								LPCTSTR			pDelimeters,
								bool			bClearFirst)
{
	if(bClearFirst)
		Clear();

	KString TempString = String;

	TCHAR *pToken;
	for(pToken = _tcstok(TempString.GetDataPtr(), pDelimeters) ;
		pToken ;
		pToken = _tcstok(NULL, pDelimeters))
	{
		*AddLast() = pToken;
	}
}

bool KStrings::HasString(const KString& String) const
{
	for(TConstIterator Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		if(Iter->Compare(String) == 0)
			return true;
	}

	return false;
}

bool KStrings::HasStringNoCase(const KString& String) const
{
	for(TConstIterator Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		if(Iter->CompareNoCase(String) == 0)
			return true;
	}

	return false;
}

KString KStrings::GenerateString(	LPCTSTR	pDelimeter,
									bool	bLastDelimeter) const
{
	KString String;

	for(TConstIterator Iter = GetFirst() ; Iter.IsValid() ; ++Iter)
	{
		String += *Iter;

		if(Iter != GetLast() || bLastDelimeter)
			String += pDelimeter;
	}

	return String;
}