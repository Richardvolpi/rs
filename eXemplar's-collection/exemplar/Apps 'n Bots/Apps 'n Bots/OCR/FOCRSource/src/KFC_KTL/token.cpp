#include "kfc_ktl_pch.h"
#include "token.h"

// -------
// Tokens
// -------
KString TTokens::Process(const KString& String) const
{
	KString DstString;

	for(size_t szStart = 0 ; szStart < String.GetLength() ; )
	{
		// Scanning for the closest token starting at 'szStart'
		const TToken*	pClosestToken = NULL;
		size_t			szClosestTokenPos;

		for(size_t i = 0 ; i < GetN() ; i++)
		{
			const TToken& CurToken = GetDataRef(i);

			size_t szPos = String.Find(CurToken.m_SrcString, szStart);
			if(szPos == UINT_MAX)
				continue;

			if(	pClosestToken == NULL		||
				szPos < szClosestTokenPos	||
				szPos == szClosestTokenPos &&
					CurToken.m_SrcString.GetLength() >
						pClosestToken->m_SrcString.GetLength())
			{
				pClosestToken = &CurToken, szClosestTokenPos = szPos;
			}
		}
		
		if(pClosestToken == NULL) // no more tokens found
		{
			DstString += String.Mid(szStart); // adding leftovers
			break;
		}

		DstString += String.Mid(szStart, szClosestTokenPos - szStart); // adding pre-token part
		DstString += pClosestToken->m_DstString; // adding token replacement
		
		// Forwarding 'szStart' to the end of just substed token
		szStart = szClosestTokenPos + pClosestToken->m_SrcString.GetLength();
	}

	return DstString;
}

KString TTokens::ProcessEnumValue(	const KString&	String,
									LPCTSTR			pValueName) const
{
	for(size_t i = 0 ; i < GetN() ; i++)
	{
		const TToken& Token = GetDataRef(i);
		if(String == Token.m_SrcString)
			return Token.m_DstString;
	}

	REPORT_INVALID_VALUE;
}

// ------------------
// Tokens registerer
// ------------------
TTokensRegisterer::TTokensRegisterer()
{
	m_pTokens = NULL;
}

TTokensRegisterer::TTokensRegisterer(TTokens& STokens)
{
	m_pTokens = NULL;

	Allocate(STokens);
}

void TTokensRegisterer::Release()
{
	if(m_pTokens)
	{
#ifdef _DEBUG
		if(m_pTokens->GetN() < m_szNAdded)
		{
			SHOW_FAILURE_MESSAGE(TEXT("Tokens unregistration is greater that remaining."));
			exit(0);
		}
#endif // _DEBUG
		
		m_pTokens->Del(m_pTokens->GetN() - m_szNAdded, m_pTokens->GetN());

		m_pTokens = NULL;
	}
}

void TTokensRegisterer::Allocate(TTokens& STokens)
{
	Release();

	m_pTokens = &STokens;

	m_szNAdded = 0;
}

void TTokensRegisterer::Add(const KString& SSrcString, const KString& DstString)
{
	DEBUG_VERIFY_ALLOCATION;

	m_pTokens->Add().Set(SSrcString, DstString);
	
	m_szNAdded++;
}
