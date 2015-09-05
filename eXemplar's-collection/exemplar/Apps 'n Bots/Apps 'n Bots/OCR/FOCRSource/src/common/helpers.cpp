#include "common_pch.h"
#include "helpers.h"

// ----------------
// Global routines
// ----------------
BIGNUM* Load_RSA_BIGNUM(TStream& Stream)
{
	size_t szN;
	Stream >> szN;

	TValueArray<BYTE, true> Buffer;

	Stream.StreamRead(&Buffer.AllocateAdd(szN), szN);

	BIGNUM* pBN = BN_bin2bn(Buffer.GetDataPtr(), Buffer.GetN(), NULL);

	DEBUG_VERIFY(pBN);

	return pBN;
}

void Save_RSA_BIGNUM(const BIGNUM* pBN, TStream& Stream)
{
	DEBUG_VERIFY(pBN);

	const size_t szN = BN_num_bytes(pBN);

	Stream << szN;

	TValueArray<BYTE, true> Buffer;

	BN_bn2bin(pBN, &Buffer.AllocateAdd(szN));

	Stream.StreamWrite(Buffer.GetDataPtr(), Buffer.GetN());
}