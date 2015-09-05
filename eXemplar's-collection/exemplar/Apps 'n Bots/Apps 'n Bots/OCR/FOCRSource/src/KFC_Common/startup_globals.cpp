#include "kfc_common_pch.h"
#include "startup_globals.h"

#include <KFC_KTL\ktl_consts.h>
#include <KFC_KTL\file_names.h>
#include "module.h"
#include "cmd_line.h"

TStartUpGlobals g_StartUpGlobals;

// -----------------
// Start-up globals
// -----------------
TStartUpGlobals::TStartUpGlobals() : TGlobals(TEXT("Start-up globals"), 0)
{
}

void TStartUpGlobals::OnUninitialize()
{
	// Parameters
	m_Parameters.Clear();

	// Folders
	m_DesktopFolder.			Empty();
	m_StartMenuProgramsFolder.	Empty();
	m_ProgramFilesFolder.		Empty();
	m_TempFolder.				Empty();
	m_SystemFolder.				Empty();
	m_WindowsFolder.			Empty();
	m_StartFolder.				Empty();

	// Files
	m_StartFile.Empty();

	// COM
	m_COMInitializer.Release();
}

void TStartUpGlobals::OnInitialize()
{
	TCHAR	Buf[1024];
	size_t	szLength;

	// COM
	m_COMInitializer.Allocate();

	// Start folder
	m_StartFolder = GetFilePath(GetKModuleFileName(NULL));
	
	// Windows folder
	szLength = GetWindowsDirectory(Buf, sizeof(Buf) - 1);
	if(szLength == 0)
	{
		INITIATE_DEFINED_CODE_FAILURE(TEXT("Error fetching windows folder"), GetLastError());
	}

	Buf[szLength] = 0, m_WindowsFolder = SlashedFolderName(Buf);

	// System folder
	szLength = GetSystemDirectory(Buf, sizeof(Buf) - 1);
	if(szLength == 0)
	{
		INITIATE_DEFINED_CODE_FAILURE(TEXT("Error fetching system folder"), GetLastError());
	}

	Buf[szLength] = 0, m_SystemFolder = SlashedFolderName(Buf);

	// Temp folder
	szLength = GetTempPath(sizeof(Buf) - 1, Buf);
	if(szLength == 0)
	{
		INITIATE_DEFINED_CODE_FAILURE(TEXT("Error fetching temp folder"), GetLastError());
	}

	Buf[szLength] = 0, m_TempFolder = SlashedFolderName(Buf);

	// Program files folder
	{
		const LPCTSTR pEnv = _tgetenv(TEXT("ProgramFiles"));

		m_ProgramFilesFolder =	pEnv ?
									SlashedFolderName(pEnv) :
									m_WindowsFolder.Left(3) + TEXT("Program Files\\");
	}

	// Start menu programs folder
	{
		TCHAR Buf[MAX_PATH];
		SHGetSpecialFolderPath(NULL, Buf, CSIDL_STARTMENU, TRUE);

		m_StartMenuProgramsFolder = SlashedFolderName(Buf) + TEXT("Programs\\");
	}

	// Desktop folder
	{
		TCHAR Buf[MAX_PATH];
		SHGetSpecialFolderPath(NULL, Buf, CSIDL_DESKTOP, TRUE);

		m_DesktopFolder = SlashedFolderName(Buf);
	}

	// Parameters
	ParseCmdLine(GetCommandLine(), m_Parameters);
}
