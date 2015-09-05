#include "kfc_common_pch.h"
#include "rgb.h"

TRGB &TRGB::Set15bpp(WORD wC)
{
	iR = (wC&0x7C00) >> 7;
	iG = (wC&0x03E0) >> 2;
	iB = (wC&0x001F) << 3;

	return *this;
}

TRGB &TRGB::Set16bpp(WORD wC)
{
	iR = (wC&0xFC00) >> 8;
	iG = (wC&0x07E0) >> 3;
	iB = (wC&0x001F) << 3;

	return *this;
}

TRGB &TRGB::Set32bpp(DWORD dwC)
{
	iR = (dwC&0x00FF0000) >> 16;
	iG = (dwC&0x0000FF00) >> 8;
	iB = (dwC&0x000000FF);

	return *this;
}

TRGB &TRGB::SetWinColor(DWORD dwC)
{
	iR = (dwC & 0xFF);
	iG = (dwC >> 8)		& 0xFF;
	iB = (dwC >> 16)	& 0xFF;

	return *this;
}

WORD TRGB::Get15bpp() const
{
	return (WORD)(iB >> 3) | (WORD)((iG >> 3) << 5) | (WORD)((iR >> 3) << 10);
}

WORD TRGB::Get16bpp() const
{
	return (WORD)(iB >> 3) | (WORD)((iG >> 2) << 5) | (WORD)((iR >> 3) << 11);
}

DWORD TRGB::Get32bpp(BYTE bAlpha) const
{
	return iB | (iG << 8) | (iR << 16) | (bAlpha << 24);
}

DWORD TRGB::GetWinColor() const
{
	return (iB << 16) | (iG << 8) | iR;
}

WORD TRGB::Get15bpp_via15() const
{
	return (WORD)(iB >> 3) | (WORD)((iG >> 3) << 5) | (WORD)((iR >> 3) << 10);
}

WORD TRGB::Get16bpp_via15() const
{
	return (WORD)(iB >> 3) | (WORD)((iG >> 3) << 6) | (WORD)((iR >> 3) << 11);
}

DWORD TRGB::Get32bpp_via15(BYTE bAlpha) const
{
	return (iB >> 3) | ((iG >> 3) << 11) | ((iR >> 3) << 19) | (bAlpha << 24);
}

DWORD TRGB::GetWinColor_via15() const
{
	return ((iB >> 3) << 19) | ((iG >> 3) << 11) | (iR >> 3);
}
