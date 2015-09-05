#ifndef helpers_h
#define helpers_h

// ----------------
// Global routines
// ----------------
BIGNUM* Load_RSA_BIGNUM(TStream& Stream);

void Save_RSA_BIGNUM(const BIGNUM* pBN, TStream& Stream);

#endif // helpers_h