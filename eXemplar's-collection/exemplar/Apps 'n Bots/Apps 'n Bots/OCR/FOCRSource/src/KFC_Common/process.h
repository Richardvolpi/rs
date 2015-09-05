#ifndef process_h
#define process_h

#include "kfc_common_api.h"

// ------------
// Thread proc
// ------------
typedef UINT __stdcall TThreadProc(void* pParam);

// ----------------
// Global routines
// ----------------
KFC_COMMON_API HANDLE StartThread(	TThreadProc*	pThreadProc,
									void*			pParam,
									bool			bSuspended	= false,
									UINT*			pRID		= NULL);

KFC_COMMON_API DWORD StartProcess(	const KString& FileName,
									const KString& Params,
									const KString& FolderName);

KFC_COMMON_API void OpenDocument(LPCTSTR pName);

#endif // process_h