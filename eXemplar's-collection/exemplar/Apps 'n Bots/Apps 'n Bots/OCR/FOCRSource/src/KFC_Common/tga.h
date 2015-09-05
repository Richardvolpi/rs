#ifndef tga_h
#define tga_h

#include <KFC_KTL\basic_types.h>
#include "kfc_common_api.h"
#include "file.h"

// --------------
// TGA file head 
// --------------
struct KFC_COMMON_API TGA_FILEHEAD
{
	BYTE bIDLength;
	BYTE bColorMapType;
	BYTE bImageType;
	WORD wCMapStart;
	WORD wCMapLength;
	BYTE bCMapDepth;
	WORD wXOffset;
	WORD wYOffset;
	WORD wWidth;
	WORD wHeight;
	BYTE bPixelDepth;
	BYTE bImageDescription;


	void Load(TFile& File);
	void Save(TFile& File) const;
};

inline TFile& operator >> (TFile& File, TGA_FILEHEAD& RFileHead)
{
	RFileHead.Load(File);
	return File;
}

inline TFile& operator << (TFile& File, const TGA_FILEHEAD& FileHead)
{
	FileHead.Save(File);
	return File;
}

#endif // tga_h
