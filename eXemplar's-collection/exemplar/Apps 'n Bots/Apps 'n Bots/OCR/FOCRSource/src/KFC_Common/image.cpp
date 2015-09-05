#include "kfc_common_pch.h"
#include "image.h"

#include <math.h>
#include <KFC_KTL\varray.h>
#include <KFC_KTL\file_names.h>
#include "file.h"
#include "rgb.h"
#include "bmp.h"
#include "tga.h"

// ------
// Image
// ------
TImage::TImage()
{
	m_bAllocated = false;
}

TImage::TImage(const SZSIZE& SSize)
{
	m_bAllocated = false;

	Allocate(SSize);
}

TImage::TImage(const KString& FileName, HANDLE hTerminator)
{
	m_bAllocated = false;

	Load(FileName, hTerminator);
}

void TImage::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		m_Pixels.Release();
	}
}

TImage& TImage::Allocate(const SZSIZE& SSize)
{
	if(!IsEmpty() && GetSize() == SSize)
		return *this;

	Release();

	try
	{
		DEBUG_VERIFY(!SSize.IsFlat());

		m_Size = SSize;

		m_Pixels.Allocate(m_Size);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}

	return *this;
}

TImage& TImage::CreateCropped(const TImage& SrcImage, const SZRECT& Rect)
{
	Release();

	try
	{
		DEBUG_VERIFY(!SrcImage.IsEmpty());

		DEBUG_VERIFY(Rect.IsValid());

		DEBUG_VERIFY(Rect.m_Right <= SrcImage.GetSize().cx && Rect.m_Bottom <= SrcImage.GetSize().cy);

		Allocate(Rect);

		const DWORD* pSrcData = SrcImage.GetDataPtr(SZPOINT(Rect.m_Left, Rect.m_Top));
		DWORD* pDstData = GetDataPtr();
		
		for(size_t y = Rect.m_Top ; y < Rect.m_Bottom ; y++)
		{
			memcpy(pDstData, pSrcData, m_Size.cx * sizeof(DWORD));
			pSrcData += SrcImage.GetSize().cx, pDstData += m_Size.cx;
		}
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
	
	return *this;
}

TImage& TImage::CreateResized(	const TImage&	SrcImage,
								const SZSIZE&	SSize,
								bool			bFilter,
								bool			bProportional)
{
	Release();

	try
	{
		DEBUG_VERIFY(!SrcImage.IsEmpty());

		double xc, yc;
		if(bProportional)
		{
			if(	(SSize.cy - 1) * (SrcImage.GetSize().cx - 1) <=
				(SSize.cx - 1) * (SrcImage.GetSize().cy - 1))
			{
				xc = yc = (double)(SrcImage.GetSize().cy - 1) / (SSize.cy - 1);
				Allocate(SZSIZE((size_t)((SrcImage.GetSize().cx - 1) / xc) + 1, SSize.cy));
			}
			else
			{
				xc = yc = (double)(SrcImage.GetSize().cx - 1) / (SSize.cx - 1);
				Allocate(SZSIZE(SSize.cx, (size_t)((SrcImage.GetSize().cy - 1) / yc) + 1));
			}
		}
		else
		{
			yc = (double)(SrcImage.GetSize().cy - 1) / (SSize.cy - 1);
			xc = (double)(SrcImage.GetSize().cx - 1) / (SSize.cx - 1);

			Allocate(SSize);
		}

		const DWORD* pSrcData = SrcImage.GetDataPtr();
		DWORD* pDstData = GetDataPtr();
				
		for(size_t y = 0 ; y < m_Size.cy ; y++)
		{
			size_t ty = (size_t)(y * yc + 0.5);

			for(size_t x = 0 ; x < m_Size.cx ; x++)
			{
				size_t tx = (size_t)(x * xc + 0.5);
				*pDstData++ = pSrcData[ty * SrcImage.GetSize().cx + tx];
			}
		}
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}

	return *this;
}

TImage& TImage::Clear()
{
	DEBUG_VERIFY_ALLOCATION;

	memset(GetDataPtr(), 0, m_Size.GetSquare() * sizeof(DWORD));

	return *this;
}

TImage& TImage::FillWhite()
{
	DEBUG_VERIFY_ALLOCATION;

	memset(GetDataPtr(), BYTE_MAX, m_Size.GetSquare() * sizeof(DWORD));

	return *this;
}

TImage& TImage::Fill(DWORD dwColor)
{
	DEBUG_VERIFY_ALLOCATION;

	DWORD* pData = GetDataPtr();

	for(size_t i = m_Size.GetSquare() ; i ; i--)
		*pData++ = dwColor;

	return *this;
}

TImage& TImage::BitBlit(const TImage&	SrcImage,
						const SZPOINT&	DstCoords,
						TBitBlitMode	Mode,
						const ALSIZE&	Alignment)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(!SrcImage.IsEmpty());

	// Setting temp coords
	SZPOINT TmpCoords(	Alignment.cx == ALIGNMENT_MID ? 0 : DstCoords.x,
						Alignment.cy == ALIGNMENT_MID ? 0 : DstCoords.y);
	
	// Checking source image to fit
	if(	TmpCoords.x + SrcImage.GetSize().cx > m_Size.cx ||
		TmpCoords.y + SrcImage.GetSize().cy > m_Size.cy)
	{
		INITIATE_FAILURE;
	}

	// Setting absolute X
	if(Alignment.cx == ALIGNMENT_MID)
		TmpCoords.x = (m_Size.cx - SrcImage.GetSize().cx) >> 1;
	else if(Alignment.cx == ALIGNMENT_MAX)
		TmpCoords.x = m_Size.cx - SrcImage.GetSize().cx - TmpCoords.x;

	// Setting absolute Y
	if(Alignment.cy == ALIGNMENT_MID)
		TmpCoords.y = (m_Size.cy - SrcImage.GetSize().cy) >> 1;
	else if(Alignment.cy == ALIGNMENT_MAX)
		TmpCoords.y = m_Size.cy - SrcImage.GetSize().cy - TmpCoords.y;

	// Alpha blitting
	const DWORD* pSrcData = SrcImage.GetDataPtr();
	DWORD* pDstData = GetDataPtr(TmpCoords);

	if(Mode == BBM_COPY)
	{
		for(size_t y = SrcImage.GetSize().cy ; y ; y--)
		{
			memcpy(pDstData, pSrcData, SrcImage.GetSize().cx * sizeof(DWORD));
			pSrcData += SrcImage.GetSize().cx;
			pDstData += m_Size.cx;
		}
	}
	else if(Mode == BBM_ALPHABLIT)
	{
		size_t szDstDelta = m_Size.cx - SrcImage.GetSize().cx;

		for(size_t y = SrcImage.GetSize().cy ; y ; y--)
		{
			for(size_t x = SrcImage.GetSize().cx ; x ; x--)
			{
				DWORD	SPixel = *pSrcData++; 
				DWORD&	DPixel = *pDstData++;

				TRGB SColor;
				SColor.Set32bpp(SPixel);
				
				TRGB DColor;
				DColor.Set32bpp(DPixel);

				BYTE bSAlpha = (BYTE)(SPixel >> 24);
				BYTE bDAlpha = (BYTE)(DPixel >> 24);

				double dAlpha = bSAlpha / 255.0;

				DColor *= 1.0 - dAlpha;
				SColor *= dAlpha;
				DColor += SColor;

				DPixel = DColor.Get32bpp((BYTE)(bDAlpha * (1.0 - dAlpha) + bSAlpha * dAlpha));
			}

			pDstData += szDstDelta;
		}
	}
	else if(Mode == BBM_ONLY_FULL_SRC_ALPHA_PIXELS)
	{
		size_t szDstDelta = m_Size.cx - SrcImage.GetSize().cx;

		for(size_t y = SrcImage.GetSize().cy ; y ; y--)
		{
			for(size_t x = SrcImage.GetSize().cx ; x ; x--)
			{
				DWORD	SPixel = *pSrcData++; 
				DWORD&	DPixel = *pDstData++;
				
				if((SPixel >> 24) == 0xFF)
					DPixel = SPixel;
			}

			pDstData += szDstDelta;
		}
	}
	else if(Mode == BBM_ONLY_FULL_DST_ALPHA_PIXELS)
	{
		size_t szDstDelta = m_Size.cx - SrcImage.GetSize().cx;

		for(size_t y = SrcImage.GetSize().cy ; y ; y--)
		{
			for(size_t x = SrcImage.GetSize().cx ; x ; x--)
			{
				DWORD	SPixel = *pSrcData++; 
				DWORD&	DPixel = *pDstData++;
				
				if((DPixel >> 24) == 0xFF)
					DPixel = SPixel;
			}

			pDstData += szDstDelta;
		}
	}
	else
	{
		INITIATE_FAILURE;
	}

	return *this;
}

void TImage::Load(const KString& FileName, HANDLE hTerminator)
{
	Release();

	if(!FileExists(FileName))
		INITIATE_DEFINED_FAILURE((KString)TEXT("Image file \"") + FileName + TEXT("\" not found."));

	try
	{
		KString Extension = GetFileExtension(FileName);

		if(Extension.CompareNoCase(TEXT("bmp"))==0)
			LoadAsBMP(FileName, hTerminator);
		else if(Extension.CompareNoCase(TEXT("tga"))==0)
			LoadAsTGA(FileName, hTerminator);
		else
			INITIATE_DEFINED_FAILURE((KString)TEXT("Unknown image file type \"") + FileName + TEXT("\"."));
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

void TImage::Save(const KString& FileName, int iQuality) const
{
	DEBUG_VERIFY_ALLOCATION;

	KString Extension = GetFileExtension(FileName);

	if(Extension.CompareNoCase(TEXT("bmp"))==0)
		SaveAsBMP(FileName);
	else if(Extension.CompareNoCase(TEXT("tga"))==0)
		SaveAsTGA(FileName);
	else
		INITIATE_DEFINED_FAILURE(TEXT("Unsupported image file extension on saving."));
}

void TImage::LoadAsBMP(const KString& FileName, HANDLE hTerminator)
{
	Release();

	try
	{
		TFile File(FileName, FOF_READ | FOF_SEEK);

		// Reading file header
		BITMAPFILEHEADER FileHeader;
		File >> FileHeader;
		
		// Checking file type
		LPCSTR pType = (char*)&FileHeader.bfType;
		if(pType[0] != 'B' || pType[1] != 'M')
			INITIATE_FAILURE;

		// Reading info header
		BITMAPINFOHEADER InfoHeader;
		File >> InfoHeader;
		
		// Checking compression
		if(InfoHeader.biCompression != BI_RGB)
			INITIATE_FAILURE;

		// Allocating
		Allocate(SZSIZE(InfoHeader.biWidth, InfoHeader.biHeight));

		// Settting NColors
		size_t szNColors = 0;
		if(InfoHeader.biBitCount < 16)
		{
			szNColors =	InfoHeader.biClrUsed ?
						InfoHeader.biClrUsed :
						(1 << InfoHeader.biBitCount);
		}

		// Setting bytes width
		size_t szBytesWidth = (m_Size.cx * InfoHeader.biBitCount + 7) >> 3;
		
		// Evaluating image size and pitch
		size_t szImageSize;
		size_t szPitch;

		if(InfoHeader.biSizeImage)
		{
			szImageSize	= InfoHeader.biSizeImage;
			szPitch		= szImageSize / m_Size.cy;
		}
		else
		{
			szPitch = szBytesWidth;

			// Paragraph alignment
			if(szPitch & 3)
				szPitch += 4 - (szPitch & 3);

			szImageSize = szPitch * m_Size.cy;
		}
		
		// Seeking to the pixel data
		File.Seek(sizeof(FileHeader) + InfoHeader.biSize);

		// Reading palette
		TValueArray<RGBQUAD, true> Palette;

		if(szNColors)
		{
			Palette.Allocate(szNColors), Palette.Add(szNColors);
			Palette.ReadItems(File);
		}

		// Read buffer
		TValueArray<BYTE, true> ReadBuf;
		ReadBuf.Allocate(szPitch * m_Size.cy), ReadBuf.Add(szPitch * m_Size.cy);
		ReadBuf.ReadItems(File);

		BYTE*	pSrc = ReadBuf.GetDataPtr() + szPitch * (m_Size.cy - 1);
		int		iReadBufDelta = -(int)(szBytesWidth + szPitch);

		DWORD* pDst = GetDataPtr();

		// Filling
		DWORD r, g, b;

		size_t x, y, i;
		size_t szIndex;

		if(InfoHeader.biBitCount == 1)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				i = 0;

				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				for(x = m_Size.cx ; x ; x--)
				{
					szIndex = (*pSrc & 0x80) >> 7;

					if(++i==8 || x==1)
						i=0, pSrc++;
					else
						*pSrc <<= 1;

					b = Palette[szIndex].rgbBlue;
					g = Palette[szIndex].rgbGreen	<< 8;
					r = Palette[szIndex].rgbRed		<< 16;

					*pDst++ = 0xFF000000 | r | g | b;						
				}

				pSrc += iReadBufDelta;
			}
		}
		else if(InfoHeader.biBitCount == 4)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				i = 0;

				for(x = m_Size.cx ; x ; x--)
				{
					szIndex = (*pSrc & 0xF0) >> 4;

					if(++i==2 || x==1)
						i=0, pSrc++;
					else
						*pSrc <<= 4;

					b = Palette[szIndex].rgbBlue;
					g = Palette[szIndex].rgbGreen	<< 8;
					r = Palette[szIndex].rgbRed		<< 16;

					*pDst++ = 0xFF000000 | r | g | b;
				}

				pSrc += iReadBufDelta;
			}
		}
		else if(InfoHeader.biBitCount == 8)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				for(x = m_Size.cx ; x ; x--)
				{
					BYTE bSrc = *pSrc++;
					
					b = Palette[bSrc].rgbBlue;
					g = Palette[bSrc].rgbGreen	<< 8;
					r = Palette[bSrc].rgbRed	<< 16;

					*pDst++ = 0xFF000000 | r | g | b;
				}

				pSrc += iReadBufDelta;
			}
		}
		else if(InfoHeader.biBitCount==16)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				for(x = m_Size.cx ; x ; x--)
				{
					WORD wSrc = *(WORD*)pSrc;
					pSrc += sizeof(WORD);

					b = wSrc & 0x001F;
					g = ((wSrc >> 5)	& 0x1F) << 8;
					r = ((wSrc >> 10)	& 0x1F) << 16;

					*pDst++ = 0xFF000000 | r | g | b;
				}

				pSrc += iReadBufDelta;
			}
		}
		else if(InfoHeader.biBitCount == 24)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				for(x = m_Size.cx ; x ; x--)
				{
					b = *pSrc++;
					g = *pSrc++ << 8;
					r = *pSrc++ << 16;

					*pDst++ = 0xFF000000 | r | g | b;
				}

				pSrc += iReadBufDelta;
			}
		}
		else if(InfoHeader.biBitCount == 32)
		{
			for(y = m_Size.cy ; y ; y--)
			{
				if(IsTerminated(hTerminator))
				{
					Release();
					return;
				}

				for(x = m_Size.cx ; x ; x--)
					*pDst++ = 0xFF000000 | *pSrc++;

				pSrc += iReadBufDelta;
			}
		}
		else
		{
			INITIATE_FAILURE;
		}
	}

	catch(...)
	{
		Release(true);
		INITIATE_DEFINED_FAILURE((KString)TEXT("\"") + FileName + TEXT("\" is not valid BMP file."));
	}
}

void TImage::LoadAsTGA(const KString& FileName, HANDLE hTerminator)
{
	Release();

	try
	{
		TFile File(FileName, FOF_BINARYREAD | FOF_SEEK);

		// Reading file head
		TGA_FILEHEAD fhead;
		File >> fhead;
		
		// Checking file type
		if(	fhead.bImageType != 2 &&
			fhead.bImageType != 10)
		{
			INITIATE_FAILURE;
		}

		if(fhead.bColorMapType)
			INITIATE_FAILURE;

		if(	fhead.bPixelDepth != 16 &&
			fhead.bPixelDepth != 24 &&
			fhead.bPixelDepth != 32)
		{
			INITIATE_FAILURE;
		}

		// Setting alpha presence (16bit only)
		bool bHasAlpha = (fhead.bImageDescription & 7) ? true : false;

		// Skipping image ID
		File.Seek(fhead.bIDLength, FSM_CURRENT);

		// Read bufffer
		TValueArray<BYTE, true> ReadBuffer;
		size_t szReadBufferSize = File.GetFilePos().m_szLength - File.Tell();
		ReadBuffer.Allocate(szReadBufferSize), ReadBuffer.Add(szReadBufferSize);

		// Loading image data into the buffer
		ReadBuffer.ReadItems(File);
		
		// Retrieving src data ptr
		const BYTE* pSrcData = ReadBuffer.GetDataPtr();

		// Loading image data
		Allocate(SZSIZE(fhead.wWidth, fhead.wHeight));

		DWORD *write = GetDataPtr(SZPOINT(0, m_Size.cy - 1));

		size_t szWriteDelta = fhead.wWidth << 1;

		size_t	x, y;
		DWORD	v;
		BYTE	rv;

		if(fhead.bImageType == 2) // no compression
		{
			if(fhead.bPixelDepth == 16)
			{
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}

					for(x = m_Size.cx ; x ; x--)
					{
						v = 0;
						rv = *pSrcData++;
						v |= (rv & 0x1F) << 3, v |= (rv & 0xE0) << 6;

						rv = *pSrcData++;
						v |= (rv & 0x03) << 14, v |= (rv & 0x7C) << 17;

						if(bHasAlpha && (rv & 0x80))
							v |= 0xFF000000;

						*write++ = v;
					}

					write -= szWriteDelta;
				}
			}
			else if(fhead.bPixelDepth == 24)
			{
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}

					for(x = m_Size.cx ; x ; x--)
					{
						v = 0xFF000000;

						v |= *pSrcData++;
						v |= *pSrcData++ << 8;
						v |= *pSrcData++ << 16;

						*write++ = v;
					}

					write -= szWriteDelta;
				}
			}
			else if(fhead.bPixelDepth == 32)
			{
				size_t szRowSizeBytes = m_Size.cx * sizeof(DWORD);
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}

					memcpy(write, pSrcData, szRowSizeBytes), pSrcData += szRowSizeBytes;
					write += m_Size.cx, write -= szWriteDelta;
				}
			}
		}
		else if(fhead.bImageType == 10) // compression
		{
			if(fhead.bPixelDepth == 16)
			{
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}
					
					for(x = m_Size.cx ; x ; )
					{
						BYTE bPref = *pSrcData++;
						
						if(bPref & 0x80)
						{
							bPref &= 0x7F , bPref++;

							v = 0;

							rv = *pSrcData++;
							v |= (rv & 0x1F) << 3, v |= (rv & 0xE0) << 6;

							rv = *pSrcData++;
							v |= (rv & 0x03) << 14, v |= (rv & 0x7C) << 17;

							if(bHasAlpha && (rv & 0x80))
								v |= 0xFF000000;

							for(BYTE j=bPref ; j ; j--,x--)
								*write++ = v;
						}
						else
						{
							bPref++;

							for(BYTE j=bPref ; j ; j--,x--)
							{
								v = 0;

								rv = *pSrcData++;
								v |= (rv & 0x1F) << 3, v |= (rv & 0xE0) << 6;

								rv = *pSrcData++;
								v |= (rv & 0x03) << 14, v |= (rv & 0x7C) << 17;

								if(bHasAlpha && (rv & 0x80))
									v |= 0xFF000000;

								*write++ = v;
							}
						}
					}

					write -= szWriteDelta;
				}
			}
			else if(fhead.bPixelDepth == 24)
			{
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}

					for(x = m_Size.cx ; x ; )
					{
						BYTE bPref = *pSrcData++;
						
						if(bPref & 0x80)
						{
							bPref &= 0x7F , bPref++;

							v = 0xFF000000;

							v |= *pSrcData++;
							v |= *pSrcData++ << 8;
							v |= *pSrcData++ << 16;

							for(BYTE j=bPref ; j ; j--,x--)
								*write++ = v;
						}
						else
						{
							bPref++;

							for(BYTE j=bPref ; j ; j--,x--)
							{
								v = 0xFF000000;

								v |= *pSrcData++;
								v |= *pSrcData++ << 8;
								v |= *pSrcData++ << 16;

								*write++ = v;
							}
						}
					}

					write -= szWriteDelta;
				}
			}
			else if(fhead.bPixelDepth == 32)
			{
				for(y = m_Size.cy ; y ; y--)
				{
					if(IsTerminated(hTerminator))
					{
						Release();
						return;
					}
					
					for(x = m_Size.cx ; x ; )
					{
						BYTE bPref = *pSrcData++;
						
						if(bPref & 0x80)
						{
							bPref &= 0x7F , bPref++;

							v = *pSrcData++;
							
							for(BYTE j=bPref ; j ; j--,x--)
								*write++ = v;
						}
						else
						{
							bPref++;

							size_t szStripSizeBytes = bPref * sizeof(DWORD);
							memcpy(write, pSrcData, szStripSizeBytes), pSrcData += szStripSizeBytes;
							write+=bPref, x-=bPref;
						}
					}

					write -= szWriteDelta;
				}
			}
		}
	}

	catch(...)
	{
		Release(true);
		INITIATE_DEFINED_FAILURE((KString)TEXT("\"") + FileName + TEXT("\" is not valid TGA file."));
	}
}

void TImage::SaveAsBMP(const KString& FileName) const
{
	DEBUG_VERIFY_ALLOCATION;

	TFile File(FileName, FOF_BINARYWRITE);

	// Data size
	size_t szRowBytesSize = m_Size.cx * 3;
	if(szRowBytesSize & 3) // 4-byte alignment
		szRowBytesSize |= 3, szRowBytesSize++;

	const size_t szDataSize = szRowBytesSize * m_Size.cy;

	// File header
	BITMAPFILEHEADER FileHead;

	((LPSTR)&FileHead.bfType)[0] = 'B';
	((LPSTR)&FileHead.bfType)[1] = 'M';

	FileHead.bfReserved1	= 0;
	FileHead.bfReserved2	= 0;
	FileHead.bfOffBits		= sizeof(BITMAPFILEHEADER) + sizeof(BITMAPINFOHEADER);
	FileHead.bfSize			= FileHead.bfOffBits + szDataSize;

	File << FileHead;

	// Info header
	BITMAPINFOHEADER InfoHead;
	
	InfoHead.biSize				= sizeof(InfoHead);
	InfoHead.biWidth			= m_Size.cx;
	InfoHead.biHeight			= m_Size.cy;
	InfoHead.biPlanes			= 1;
	InfoHead.biBitCount			= 24;
	InfoHead.biCompression		= BI_RGB;
	InfoHead.biSizeImage		= szDataSize;
	InfoHead.biXPelsPerMeter	= 2048;
	InfoHead.biYPelsPerMeter	= 2048;
	InfoHead.biClrUsed			= 0;
	InfoHead.biClrImportant		= 0;

	File << InfoHead;

	// Data
	TValueArray<BYTE, true> Data;
	Data.Allocate	(szDataSize);
	Data.Add		(szDataSize);

	const BYTE* pSrcData = (const BYTE*)GetDataPtr(SZPOINT(0, m_Size.cy - 1));

	BYTE* pDstData = Data.GetDataPtr();
	
	const size_t szSrcDelta = m_Size.cx << 3;
	const size_t szDstDelta = szRowBytesSize - (m_Size.cx * 3);

	for(size_t y = m_Size.cy ; y ; y--)
	{
		for(size_t x = m_Size.cx ; x ; x--)
		{
			*pDstData++ = *pSrcData++;	// red
			*pDstData++ = *pSrcData++;	// green
			*pDstData++ = *pSrcData++;	// blue
			pSrcData++;					// alpha;
		}

		pSrcData -= szSrcDelta;
		pDstData += szDstDelta;
	}

	Data.WriteItems(File);
}

void TImage::SaveAsTGA(const KString& FileName) const
{
	DEBUG_VERIFY_ALLOCATION;

	TFile File(FileName, FOF_BINARYWRITE);

	TGA_FILEHEAD fhead;

	fhead.bIDLength			= 0;
	fhead.bColorMapType		= 0;
	fhead.bImageType		= 2; // no compression
	fhead.wCMapStart		= 0;
	fhead.wCMapLength		= 0;
	fhead.bCMapDepth		= 0;
	fhead.wXOffset			= 0;
	fhead.wYOffset			= 0;
	fhead.wWidth			= (WORD)m_Size.cx;
	fhead.wHeight			= (WORD)m_Size.cy;
	fhead.bPixelDepth		= 32;
	fhead.bImageDescription	= 0x08; // 32bpp doesn't require this to be 0<x<8

	fhead.Save(File);

	const DWORD* pSrcData = GetDataPtr(SZPOINT(0, m_Size.cy - 1));
	for(size_t y = m_Size.cy ; y ; y--)
		File.Write(pSrcData, m_Size.cx * sizeof(DWORD)), pSrcData -= m_Size.cx;
}

DWORD TImage::GetPixel(const SZPOINT& Coords) const
{
	DEBUG_VERIFY_ALLOCATION;
	
	return m_Pixels.GetDataRef(Coords);
}

void TImage::SetPixel(const SZPOINT& Coords, DWORD dwColor)
{
	DEBUG_VERIFY_ALLOCATION;

	m_Pixels.GetDataRef(Coords) = dwColor;
}

DWORD* TImage::GetDataPtr(const SZPOINT& Coords)
{
	DEBUG_VERIFY_ALLOCATION;

	if(Coords.x >= m_Size.cx || Coords.y >= m_Size.cy)
		INITIATE_FAILURE;

	return m_Pixels.GetDataPtr(Coords);
}

const DWORD* TImage::GetDataPtr(const SZPOINT& Coords) const
{
	DEBUG_VERIFY_ALLOCATION;

	if(Coords.x >= m_Size.cx || Coords.y >= m_Size.cy)
		INITIATE_FAILURE;

	return m_Pixels.GetDataPtr(Coords);
}

DWORD* TImage::GetDataPtr()
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Pixels.GetDataPtr();
}

const DWORD* TImage::GetDataPtr() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_Pixels.GetDataPtr();
}

TStream& operator >> (TStream& Stream, TImage& RImage)
{
	SZSIZE Size;
	Stream >> Size;

	RImage.Allocate(Size);

	Stream.StreamRead(RImage.GetDataPtr(), Size.GetSquare() << 2);

	return Stream;
}

TStream& operator << (TStream& Stream, const TImage& Image)
{
	DEBUG_VERIFY(!Image.IsEmpty());

	Stream << Image.GetSize();

	Stream.StreamWrite(Image.GetDataPtr(), Image.GetSize().GetSquare() << 2);

	return Stream;
}
