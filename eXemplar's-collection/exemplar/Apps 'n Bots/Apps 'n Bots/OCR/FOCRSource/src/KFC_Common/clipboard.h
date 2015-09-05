#ifndef clipboard_h
#define clipboard_h

// -----------------
// Clipboard opener
// -----------------
class KFC_COMMON_API TClipboardOpener
{
public:
	TClipboardOpener(HWND hWnd);

	~TClipboardOpener();
};

// ----------------
// Global routines
// ----------------
KFC_COMMON_API bool KGetClipboardData(	HWND	hWnd,
										UINT	uiFormat,
										void*&	pRData,
										size_t&	szRN);

KFC_COMMON_API void KSetClipboardData(	HWND		hWnd,
										UINT		uiFormat,
										const void*	pData,
										size_t		szN,
										bool		bClearFirst = true);

KFC_COMMON_API void KSetClipboardText(	HWND			hWnd,
										const KString&	Text,										
										bool			bClearFirst = true);

#endif // clipboard_h