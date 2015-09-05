#include "kfc_common_pch.h"
#include "cmd_line.h"

// ----------------
// Global routines
// ----------------
void ParseCmdLine(	LPCTSTR		pCmdLine,
					KStrings&	RTokens,
					bool		bClearFirst)
{
	size_t i;

	if(bClearFirst)
		RTokens.Clear();

	KString	CurToken;
	bool	bInToken	= false;
	bool	bQuoted		= false;
	
	for(i = 0 ; pCmdLine[i] ; i++)
	{
		if(pCmdLine[i] == TEXT('"'))
		{
			if(bQuoted)
			{
				*RTokens.AddLast() = CurToken, CurToken.Empty();

				bInToken = false;

				bQuoted = false;
			}
			else
			{
				if(bInToken)
					*RTokens.AddLast() = CurToken, CurToken.Empty();

				bInToken = true;

				bQuoted = true;
			}
		}
		else
		{
			if(_istspace(pCmdLine[i]) && !bQuoted) // delimeter
			{
				if(bInToken)
					*RTokens.AddLast() = CurToken, CurToken.Empty();

				bInToken = false;
			}
			else // plain character
			{
				CurToken += pCmdLine[i];

				bInToken = true;
			}
		}
	}

	if(bInToken)
		*RTokens.AddLast() = CurToken;

	// Removing filename
	if(!RTokens.IsEmpty())
		RTokens.Del(RTokens.GetFirst());
}
