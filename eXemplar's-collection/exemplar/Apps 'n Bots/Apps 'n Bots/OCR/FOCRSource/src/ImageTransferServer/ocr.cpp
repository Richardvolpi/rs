#include "server_pch.h"
#include "ocr.h"

#include <KFC_Common\startup_globals.h>
#include <KFC_Common\com.h>
#include <KFC_Common\file.h>
#include "comdefs.h"

// --------------
// OCR functions
// --------------
TLoadModel*			g_pLoadModel		= NULL;
TLoadDictionary*	g_pLoadDictionary	= NULL;
TGetString*			g_pGetString		= NULL;

// ----------------
// Global routines
// ----------------
KString GetOCRResult(const TValueArray<BYTE, true>& ImageBuffer)
{
	const KString FileName =
		g_StartUpGlobals.m_StartFolder	+
		TEMP_FOLDERAME					+
		KGUIDToString(CreateGUID())		+
		TEXT(".bmp");

	TFile File(FileName, FOF_BINARYWRITE);

	File.Write(ImageBuffer.GetDataPtr(), ImageBuffer.GetN());

	File.m_bRemoveOnRelease = true;

	File.Close();

	char* pBuffer = (char*)calloc(32768, 1);

	SAFE_BLOCK_BEGIN
	{
		g_pGetString(FileName, pBuffer);
	}
	SAFE_BLOCK_END

	KString Result = pBuffer;

	free(pBuffer);

	return Result;
}