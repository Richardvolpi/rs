#include "common_pch.h"
#include "rsa_key.h"

#include <KFC_Common\pow2.h>

// -----------
// RSA buffer
// -----------
TRSABuffer::TRSABuffer()
{
	Allocate(TArrayAllocation(1024, 1024));
}

// --------
// RSA key
// --------
TRSAKey::TRSAKey()
{
	m_pRSA = NULL;

	m_bHasPrivate = false;
}

void TRSAKey::Release()
{
	if(m_pRSA)
		RSA_free(m_pRSA), m_pRSA = NULL;

	m_bHasPrivate = false;
}

// Allocation
void TRSAKey::Generate(size_t szLength)
{
	Release();

	try
	{
		DEBUG_VERIFY(IsPow2(szLength));

		m_pRSA = RSA_generate_key(szLength, 65537, NULL, NULL);

		if(m_pRSA == NULL)
			INITIATE_DEFINED_FAILURE(TEXT("Error generating RSA key pair."));

		m_bHasPrivate = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TRSAKey::LoadAll(TStream& Stream)
{
	Release();

	try
	{
		m_pRSA = RSA_new();

		if(m_pRSA == NULL)
			INITIATE_DEFINED_FAILURE(TEXT("Error creating RSA key pair placeholder."));

		m_pRSA->n = Load_RSA_BIGNUM(Stream);
		m_pRSA->e = Load_RSA_BIGNUM(Stream);
		m_pRSA->d = Load_RSA_BIGNUM(Stream);
		m_pRSA->p = Load_RSA_BIGNUM(Stream);
		m_pRSA->q = Load_RSA_BIGNUM(Stream);

		m_bHasPrivate = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TRSAKey::LoadPublic(TStream& Stream)
{
	Release();

	try
	{
		m_pRSA = RSA_new();

		if(m_pRSA == NULL)
			INITIATE_DEFINED_FAILURE(TEXT("Error creating RSA public key placeholder."));

		m_pRSA->n = Load_RSA_BIGNUM(Stream);
		m_pRSA->e = Load_RSA_BIGNUM(Stream);
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

// Storage
void TRSAKey::SaveAll(TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(m_bHasPrivate);

	Save_RSA_BIGNUM(m_pRSA->n, Stream);
	Save_RSA_BIGNUM(m_pRSA->e, Stream);
	Save_RSA_BIGNUM(m_pRSA->d, Stream);
	Save_RSA_BIGNUM(m_pRSA->p, Stream);
	Save_RSA_BIGNUM(m_pRSA->q, Stream);
}

void TRSAKey::SavePublic(TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	Save_RSA_BIGNUM(m_pRSA->n, Stream);
	Save_RSA_BIGNUM(m_pRSA->e, Stream);
}

// Cypher
void TRSAKey::EncryptPublic(const TRSABuffer& Data, TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	const size_t szRSASize = RSA_size(*this);

	DEBUG_VERIFY(szRSASize > 12);

	TValueArray<BYTE, true> DstBuffer;
	DstBuffer.AllocateAdd(szRSASize);

	size_t szOffset;

	for(szOffset = 0 ; szOffset < Data.GetN() ; )
	{
		const size_t szCurDataChunkSize =
			Min(szRSASize - 12, Data.GetN() - szOffset);

		const int iCurCypherChunkSize =
			RSA_public_encrypt(	szCurDataChunkSize,
								Data.GetDataPtr(szOffset),
								DstBuffer.GetDataPtr(),
								*this,
								RSA_PKCS1_PADDING);
		
		if(iCurCypherChunkSize < 0)
			INITIATE_DEFINED_FAILURE(TEXT("RSA public key encryption failed."));
		
		Stream << iCurCypherChunkSize;

		Stream.StreamWrite(DstBuffer.GetDataPtr(), iCurCypherChunkSize);

		szOffset += szCurDataChunkSize;
	}

	Stream << UINT_MAX;
}

void TRSAKey::EncryptPrivate(const TRSABuffer& Data, TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(m_bHasPrivate);

	const size_t szRSASize = RSA_size(*this);

	DEBUG_VERIFY(szRSASize > 12);

	TValueArray<BYTE, true> DstBuffer;
	DstBuffer.AllocateAdd(szRSASize);

	size_t szOffset;

	for(szOffset = 0 ; szOffset < Data.GetN() ; )
	{
		const size_t szCurDataChunkSize =
			Min(szRSASize - 12, Data.GetN() - szOffset);

		const int iCurCypherChunkSize =
			RSA_private_encrypt(szCurDataChunkSize,
								Data.GetDataPtr(szOffset),
								DstBuffer.GetDataPtr(),
								*this,
								RSA_PKCS1_PADDING);

		if(iCurCypherChunkSize < 0)
			INITIATE_DEFINED_FAILURE(TEXT("RSA private key encryption failed."));

		Stream << iCurCypherChunkSize;

		Stream.StreamWrite(DstBuffer.GetDataPtr(), iCurCypherChunkSize);

		szOffset += szCurDataChunkSize;
	}

	Stream << UINT_MAX;
}

void TRSAKey::DecryptPublic(TStream& Stream, TRSABuffer& RData) const
{
	DEBUG_VERIFY_ALLOCATION;

	const size_t szRSASize = RSA_size(*this);

	RData.Clear();

	TValueArray<BYTE, true> SrcBuffer;
	SrcBuffer.AllocateAdd(szRSASize);

	TValueArray<BYTE, true> DstBuffer;
	DstBuffer.AllocateAdd(szRSASize);

	for(;;)
	{
		size_t szCurCypherChunkSize;

		Stream >> szCurCypherChunkSize;

		if(szCurCypherChunkSize == UINT_MAX)
			break;

		if(szCurCypherChunkSize > SrcBuffer.GetN())
			INITIATE_DEFINED_FAILURE(TEXT("Malformed private cyphertext received."));

		Stream.StreamRead(SrcBuffer.GetDataPtr(), szCurCypherChunkSize);

		const int iCurDataChunkSize =
			RSA_public_decrypt(	szCurCypherChunkSize,
								SrcBuffer.GetDataPtr(),
								DstBuffer.GetDataPtr(),
								*this,
								RSA_PKCS1_PADDING);

		if(iCurDataChunkSize < 0)
			INITIATE_DEFINED_FAILURE(TEXT("RSA public key decryption failed."));

		memcpy(&RData.Add(iCurDataChunkSize), DstBuffer.GetDataPtr(), iCurDataChunkSize);
	}
}

void TRSAKey::DecryptPrivate(TStream& Stream, TRSABuffer& RData) const
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(m_bHasPrivate);

	const size_t szRSASize = RSA_size(*this);

	RData.Clear();

	TValueArray<BYTE, true> SrcBuffer;
	SrcBuffer.AllocateAdd(szRSASize);

	TValueArray<BYTE, true> DstBuffer;
	DstBuffer.AllocateAdd(szRSASize);

	for(;;)
	{
		size_t szCurCypherChunkSize;

		Stream >> szCurCypherChunkSize;

		if(szCurCypherChunkSize == UINT_MAX)
			break;

		if(szCurCypherChunkSize > SrcBuffer.GetN())
			INITIATE_DEFINED_FAILURE(TEXT("Malformed public cyphertext received."));

		Stream.StreamRead(SrcBuffer.GetDataPtr(), szCurCypherChunkSize);

		const int iCurDataChunkSize =
			RSA_private_decrypt(szCurCypherChunkSize,
								SrcBuffer.GetDataPtr(),
								DstBuffer.GetDataPtr(),
								*this,
								RSA_PKCS1_PADDING);

		if(iCurDataChunkSize < 0)
			INITIATE_DEFINED_FAILURE(TEXT("RSA private key decryption failed."));

		memcpy(&RData.Add(iCurDataChunkSize), DstBuffer.GetDataPtr(), iCurDataChunkSize);
	}
}

// -----------
// Linear key
// -----------
TLinearKey::TLinearKey()
{
}

void TLinearKey::Release()
{
	m_Key.Release();
}

void TLinearKey::Generate(size_t szLength)
{
	Release();

	try
	{
		DEBUG_VERIFY(szLength > 0);

		m_Key.AllocateAdd(szLength);

		size_t i;
		for(i = 0 ; i < m_Key.GetN() ; i++)
			m_Key[i] = rand() & 0xFF;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TLinearKey::Load(TStream& Stream)
{
	Release();

	try
	{
		size_t szLength;

		Stream >> szLength;

		if(szLength == 0)
			INITIATE_DEFINED_FAILURE(TEXT("Invalid linear key received."));

		m_Key.AllocateAdd(szLength);

		Stream.StreamRead(m_Key.GetDataPtr(), m_Key.GetN());
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TLinearKey::Save(TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	Stream << m_Key.GetN();

	Stream.StreamWrite(m_Key.GetDataPtr(), m_Key.GetN());
}

void TLinearKey::Encrypt(const TRSABuffer& Data, TStream& Stream) const
{
	DEBUG_VERIFY_ALLOCATION;

	TRSABuffer DstData;

	memcpy(&DstData.Add(Data.GetN()), Data.GetDataPtr(), Data.GetN());

	size_t i, j;

	// Key pass
	for(i = 0, j = 0 ; i < DstData.GetN() ; i++)
	{
		DstData[i] ^= m_Key[j];

		if(++j == m_Key.GetN())
			j = 0;
	}

	if(DstData.GetN() > 1)
	{
		// Merge passes
		BYTE bCur = 0;

		for(i = 4 ; i ; i--)
		{
			for(j = 0 ; j < DstData.GetN() ; j++)
				bCur ^= DstData[j], DstData[j] = bCur;
		}
	}

	Stream << DstData.GetN();

	Stream.StreamWrite(DstData.GetDataPtr(), DstData.GetN());
}

void TLinearKey::Decrypt(TStream& Stream, TRSABuffer& RData) const
{
	DEBUG_VERIFY_ALLOCATION;

	RData.Clear();

	size_t szLength;

	Stream >> szLength;

	Stream.StreamRead(&RData.Add(szLength), szLength);

	size_t i, j;

	if(RData.GetN() > 1)
	{
		// Merge passes
		for(i = 4 ; i ; i--)
		{
			for(j = RData.GetN() - 1 ; j != UINT_MAX ; j--)
				RData[j] ^= RData[j > 0 ? j - 1 : RData.GetN() - 1];
		}

		RData[0] ^= RData[RData.GetN() - 1];
	}

	// Key pass
	for(i = 0, j = 0 ; i < RData.GetN() ; i++)
	{
		RData[i] ^= m_Key[j];

		if(++j == m_Key.GetN())
			j = 0;
	}
}