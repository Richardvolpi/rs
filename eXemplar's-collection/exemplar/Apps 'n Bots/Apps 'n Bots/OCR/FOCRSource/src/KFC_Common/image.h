#ifndef image_h
#define image_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\vmatrix.h>
#include <KFC_KTL\kstring.h>
#include <KFC_KTL\alignment.h>
#include "kfc_common_api.h"

// --------------
// Bit blit mode
// --------------
enum TBitBlitMode
{
	BBM_COPY						= 1,
	BBM_ALPHABLIT					= 2,
	BBM_ONLY_FULL_SRC_ALPHA_PIXELS	= 3,
	BBM_ONLY_FULL_DST_ALPHA_PIXELS	= 4,
	BBM_FORCE_UINT					= UINT_MAX,
};

// ------
// Image
// ------
class KFC_COMMON_API TImage
{
private:
	bool m_bAllocated;

	TValueMatrix<DWORD>	m_Pixels;
	SZSIZE				m_Size;


	void LoadAsBMP	(const KString& FilaName, HANDLE hTerminator);
	void LoadAsTGA	(const KString& FileName, HANDLE hTerminator);

	void SaveAsBMP	(const KString& FileName) const;
	void SaveAsTGA	(const KString& FileName) const;

public:
	TImage();

	TImage(const SZSIZE& SSize);

	TImage(const KString& FileName, HANDLE hTerminator);
	
	~TImage() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	TImage& Allocate(const SZSIZE& SSize);

	TImage& CreateCropped(const TImage& SrcImage, const SZRECT& Rect);

	TImage& CreateResized(	const TImage&	SrcImage,
							const SZSIZE&	SSize,
							bool			bFilter,
							bool			bProportional = true);

	TImage& Clear();

	TImage& FillWhite();
	
	TImage& Fill(DWORD dwColor);	

	TImage& BitBlit(const TImage&	SrcImage,
					const SZPOINT&	DstCoords,
					TBitBlitMode	Mode		= BBM_COPY,
					const ALSIZE&	Alignment	= ALSIZE(ALIGNMENT_MIN, ALIGNMENT_MIN));

	TImage& CreateFromFont(HFONT hFont);

	void Load(const KString& FileName, HANDLE hTerminator);

	void Save(const KString& FileName, int iQuality = 75) const;

	static size_t GetFileSize(const SZSIZE& Size)
		{ return (Size.cx * Size.cy) << 2; }

	DWORD GetPixel(const SZPOINT& Coords) const;

	void SetPixel(const SZPOINT& Coords, DWORD dwColor);

	DWORD*			GetDataPtr(const SZPOINT& Coords);
	const DWORD*	GetDataPtr(const SZPOINT& Coords) const;

	DWORD*			GetDataPtr();
	const DWORD*	GetDataPtr() const;

	// ------------------ TRIVIALS --------------------
	const SZSIZE& GetSize() const { return m_Size; }
};

DECLARE_API_STREAMING(KFC_COMMON_API, TImage);

// ----------------
// Global routines
// ----------------
inline bool IsTerminated(HANDLE hTerminator)
{
	return hTerminator && WaitForSingleObject(hTerminator, 0) == WAIT_OBJECT_0;
}

#endif // image_h
