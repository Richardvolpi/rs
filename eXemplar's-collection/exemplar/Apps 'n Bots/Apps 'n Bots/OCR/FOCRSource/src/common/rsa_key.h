#ifndef rsa_key_h
#define rsa_key_h

#include "helpers.h"

// -----------
// RSA buffer
// -----------
class TRSABuffer : public TValueArray<BYTE, true>
{
public:
	TRSABuffer();
};

// --------
// RSA key
// --------
class TRSAKey
{
private:
	RSA* m_pRSA;

	bool m_bHasPrivate;

public:
	TRSAKey();

	~TRSAKey()
		{ Release(); }

	bool IsEmpty() const
		{ return m_pRSA == NULL; }

	void Release();

	// Allocation
	void Generate(size_t szLength);

	void LoadAll(TStream& Stream);

	void LoadPublic(TStream& Stream);

	// Storage
	void SaveAll(TStream& Stream) const;

	void SavePublic(TStream& Stream) const;

	// Cypher
	void EncryptPublic	(const TRSABuffer& Data, TStream& Stream) const;
	void EncryptPrivate	(const TRSABuffer& Data, TStream& Stream) const;

	void DecryptPublic	(TStream& Stream, TRSABuffer& RData) const;	
	void DecryptPrivate	(TStream& Stream, TRSABuffer& RData) const;

	// Other
	RSA* GetRSA() const
		{ DEBUG_VERIFY_ALLOCATION; return m_pRSA; }

	operator RSA* () const
		{ return GetRSA(); }
};

// -----------
// Linear key
// -----------
class TLinearKey
{
private:
	TValueArray<BYTE, true> m_Key;
	
public:
	TLinearKey();

	~TLinearKey()
		{ Release(); }
	
	bool IsEmpty() const
		{ return m_Key.IsEmpty(); }

	void Release();

	void Generate(size_t szLength);

	void Load(TStream& Stream);

	void Save(TStream& Stream) const;

	void Encrypt(const TRSABuffer& Data, TStream& Stream) const;

	void Decrypt(TStream& Stream, TRSABuffer& RData) const;
};

#endif // rsa_key_h