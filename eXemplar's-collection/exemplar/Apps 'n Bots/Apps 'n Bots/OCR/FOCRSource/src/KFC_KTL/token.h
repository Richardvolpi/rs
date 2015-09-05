#ifndef token_h
#define token_h

#include "kstring.h"
#include "varray.h"
#include "kfc_ktl_api.h"

// ------
// Token
// ------
struct KFC_KTL_API TToken
{
	KString m_SrcString;
	KString m_DstString;


	TToken() {}

	TToken(const KString& SSrcString, const KString& SDstString) :
		m_SrcString(SSrcString), m_DstString(SDstString) {}

	void Set(const KString& SSrcString, const KString& SDstString)
	{
		m_SrcString = SSrcString;
		m_DstString = SDstString;
	}
};

// -------
// Tokens
// -------
class KFC_KTL_API TTokens : public TValueArray<TToken>
{
public:
	TTokens() {}

	TTokens(const TTokens& STokens) : TValueArray<TToken>(STokens) {}

	TTokens(const TArrayAllocation& SAllocation) : TValueArray<TToken>(SAllocation) {}

	KString Process(const KString& String) const;

	KString ProcessEnumValue(	const KString&	String,
								LPCTSTR			pValueName) const;

	TTokens& operator = (const TTokens& STokens)
	{
		(TValueArray<TToken>&)*this = STokens;

		return *this;
	}
};

// ------------------
// Tokens registerer
// ------------------
class KFC_KTL_API TTokensRegisterer
{
private:
	TTokens* m_pTokens;

	size_t m_szNAdded;

public:
	TTokensRegisterer();

	TTokensRegisterer(TTokens& STokens);

	~TTokensRegisterer() { Release(); }

	bool IsEmpty() const { return m_pTokens == NULL; }

	void Release();

	void Allocate(TTokens& STokens);

	void Add(const KString& SrcString, const KString& DstString);

	// ---------------- TRIVALS ----------------
	TTokens* GetTokens() { return m_pTokens; }

	size_t GetNAdded() const { return m_szNAdded; }
};

#endif // token_h