#include "kfc_common_pch.h"
#include "clipboard.h"

#include "global_mem.h"

// -----------------
// Clipboard opener
// -----------------
TClipboardOpener::TClipboardOpener(HWND hWnd)
{
	if(!OpenClipboard(hWnd))
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error opening clipboard"),
										GetLastError());
	}
}

TClipboardOpener::~TClipboardOpener()
{
	CloseClipboard();
}

// ----------------
// Global routines
// ----------------
bool KGetClipboardData(	HWND	hWnd,
						UINT	uiFormat,
						void*&	pRData,
						size_t&	szRN)
{
	TClipboardOpener Opener0(hWnd);
	
	if(!IsClipboardFormatAvailable(uiFormat))
		return false;

	{
		TGlobalMem Mem(GetClipboardData(uiFormat));

		{
			void* pMemData;

			TGlobalMemLocker Locker0(Mem, pMemData);

			pRData = kfc_malloc(szRN = Mem.GetSize());

			memcpy(pRData, pMemData, szRN);
		}

		Mem.Invalidate();
	}

	return true;
}

void KSetClipboardData(	HWND		hWnd,
						UINT		uiFormat,
						const void*	pData,
						size_t		szN,
						bool		bClearFirst)
{
	// Allocating global memory
	TGlobalMem Mem(szN, GMEM_MOVEABLE);

	// Copying text into the global memory
	{
		void* pMemData;

		TGlobalMemLocker Locker0(Mem, pMemData);

		memcpy(pMemData, pData, szN);
	}
	
	// Accessing the clipboard
	{
		// Opening the clipboard
		TClipboardOpener Opener0(hWnd);

		// Clearing the clipboard
		if(bClearFirst)
		{
			if(!EmptyClipboard())
			{
				INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error emptying clipboard."),
												GetLastError());
			}
		}

		// Setting clipboard data
		HANDLE hData = SetClipboardData(uiFormat, Mem);

		if(hData == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error setting clipboard text data."),
											GetLastError());
		}

		Mem.Invalidate();
	}
}

void KSetClipboardText(	HWND			hWnd,
						const KString&	Text,
						bool			bClearFirst)
{
	KSetClipboardData(	hWnd,
						CF_TEXT,
						Text.GetDataPtr(),
						Text.GetStreamTermCharsLength(),
						bClearFirst);
}