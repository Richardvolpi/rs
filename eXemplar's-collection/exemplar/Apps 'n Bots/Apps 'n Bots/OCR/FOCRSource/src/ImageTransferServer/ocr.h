#ifndef ocr_h
#define ocr_h

// --------------
// OCR functions
// --------------
typedef void __stdcall TLoadModel		(const char* pFileName);
typedef void __stdcall TLoadDictionary	(const char* pFileName);
typedef void __stdcall TGetString		(const char* pFileName, char* pRResult);

extern TLoadModel*		g_pLoadModel;
extern TLoadDictionary*	g_pLoadDictionary;
extern TGetString*		g_pGetString;

// ----------------
// Global routines
// ----------------
KString GetOCRResult(const TValueArray<BYTE, true>& ImageBuffer);

#endif // ocr_h