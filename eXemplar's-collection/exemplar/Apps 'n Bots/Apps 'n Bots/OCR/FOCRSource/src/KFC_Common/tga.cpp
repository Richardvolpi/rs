#include "kfc_common_pch.h"
#include "tga.h"

// --------------
// TGA file head
// --------------
void TGA_FILEHEAD::Load(TFile& File)
{
	File >> bIDLength;
	File >> bColorMapType;
	File >> bImageType;
	File >> wCMapStart	>> wCMapLength >> bCMapDepth;
	File >> wXOffset	>> wYOffset;
	File >> wWidth		>> wHeight;
	File >> bPixelDepth;
	File >> bImageDescription;
}

void TGA_FILEHEAD::Save(TFile& File) const
{
	File << bIDLength;
	File << bColorMapType;
	File << bImageType;
	File << wCMapStart	<< wCMapLength << bCMapDepth;
	File << wXOffset	<< wYOffset;
	File << wWidth		<< wHeight;
	File << bPixelDepth;
	File << bImageDescription;
}
