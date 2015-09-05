#include "kfc_common_pch.h"
#include "process.h"

#include <KFC_KTL\file_names.h>

// ----------------
// Global routines
// ----------------
HANDLE StartThread(	TThreadProc*	pThreadProc,
					void*			pParam,
					bool			bSuspended,
					UINT*			pRID)
{
	flags_t flFlags = 0;

	if(bSuspended)
		flFlags |= CREATE_SUSPENDED;

	UINT uiID;
	HANDLE hThread = (HANDLE)_beginthreadex(NULL, 0, pThreadProc, pParam, flFlags, &uiID);

	if(pRID)
		*pRID = uiID;

	if(hThread == INVALID_HANDLE_VALUE)
		INITIATE_DEFINED_FAILURE(TEXT("Error starting new thread."));

	return hThread;
}

DWORD StartProcess(	const KString& FileName,
					const KString& Params,
					const KString& FolderName)
{
	STARTUPINFO StartUpInfo;
	memset(&StartUpInfo, 0, sizeof(StartUpInfo));
	StartUpInfo.cb = sizeof(StartUpInfo);

	PROCESS_INFORMATION ProcessInfo;
	memset(&ProcessInfo, 0, sizeof(ProcessInfo));

	if(!CreateProcess(	FileName,
						KString::Formatted(	TEXT("\"%s\" %s"),
												(LPCTSTR)FileName,
												(LPCTSTR)Params).GetDataPtr(),
						NULL,
						NULL,
						FALSE,
						0,
						NULL,
						FolderName,
						&StartUpInfo,
						&ProcessInfo))
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error starting process: \"") +
											FileName +
											TEXT("\""),
										GetLastError());
	}

	CloseHandle(ProcessInfo.hThread), CloseHandle(ProcessInfo.hProcess);

	return ProcessInfo.dwProcessId;
}

void OpenDocument(LPCTSTR pName)
{
	ShellExecute(	NULL,
					TEXT("open"),
					pName,
					NULL,
					GetFilePath(pName),
					SW_SHOWMAXIMIZED);
}