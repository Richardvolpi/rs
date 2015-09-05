#ifndef rgb_h
#define rgb_h

#include <KFC_KTL\basic_types.h>
#include "kfc_common_api.h"

#pragma warning( push )
#pragma warning( disable : 4244 ) 

class KFC_COMMON_API TRGB
{
public:
	int iR, iG, iB;


	TRGB() {}
	TRGB(int iSR,int iSG,int iSB) : iR(iSR), iG(iSG), iB(iSB) {}
	TRGB(const TRGB &srgb) : iR(srgb.iR), iG(srgb.iG), iB(srgb.iB) {}

	bool IsZero() { return !iR && !iG && !iB; }

	void SetZero() { iR = iG = iB = 0; }

	TRGB &set(int iSR,int iSG,int iSB) { iR=iSR, iG=iSG, iB=iSB; return *this; }

	// RGB converters
	TRGB &Set15bpp	(WORD	wC);
	TRGB &Set16bpp	(WORD	wC);
	TRGB &SetBPP	(WORD	wC, size_t szBPP)
		{ return szBPP==15 ? Set15bpp(wC) : Set16bpp(wC); }

	TRGB &Set32bpp		(DWORD	dwC);
	TRGB &SetWinColor	(DWORD	dwC);

	// BPP converters, components must be in range 0-255
	WORD Get15bpp	() const;
	WORD Get16bpp	() const;
	WORD GetBPP		(size_t	szBPP) const
		{ return szBPP==15 ? Get15bpp() : Get16bpp(); }

	DWORD Get32bpp		(BYTE	bAlpha = 0xFF) const;
	DWORD GetWinColor	() const;

	// BPP via 15 converters, components must be in range 0-255
	WORD Get15bpp_via15	() const;
	WORD Get16bpp_via15	() const;
	WORD GetBPP_via15	(size_t	szBPP) const
		{ return szBPP==15 ? Get15bpp_via15() : Get16bpp_via15(); }

	DWORD Get32bpp_via15	(BYTE	bAlpha = 0xFF) const;
	DWORD GetWinColor_via15	() const;

	// ------------------ OPERATORS -----------------------
	TRGB operator + (const TRGB &srgb)	{ return TRGB(iR+srgb.iR,	iG+srgb.iG,		iB+srgb.iB	); }
	TRGB operator - (const TRGB &srgb)	{ return TRGB(iR-srgb.iR,	iG-srgb.iG,		iB-srgb.iB	); }
	TRGB operator ~ ()					{ return TRGB((BYTE)~iR,	(BYTE)~iG,		(BYTE)~iB	); }
	TRGB operator * (double dK)			{ return TRGB((int)(iR*dK),	(int)(iG*dK),	(int)(iB*dK)); }
	TRGB operator / (double dK)			{ return *this * (1.0 / dK); }
	
	TRGB &operator += (const TRGB &srgb)	{ iR+=srgb.iR,	iG+=srgb.iG,	iB+=srgb.iB;	return *this; }
	TRGB &operator -= (const TRGB &srgb)	{ iR-=srgb.iR,	iG-=srgb.iG,	iB-=srgb.iB;	return *this; }
	TRGB &operator *= (double dK)			{ iR*=dK,		iG*=dK,			iB*=dK;			return *this; }
	TRGB &operator /= (double dK)			{ return *this /= (1.0 / dK); }
	
	bool operator == (const TRGB &srgb) const { return iR==srgb.iR && iG==srgb.iG && iB==srgb.iB; }
	bool operator != (const TRGB &srgb) const { return iR!=srgb.iR || iG!=srgb.iG || iB!=srgb.iB; }
};

#pragma warning( pop )

#endif // rgb_h
