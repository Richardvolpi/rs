#ifndef startup_globals_h
#define startup_globals_h

#include <KFC_KTL\globals.h>
#include "com.h"

// -----------------
// Start-up globals
// -----------------
class KFC_COMMON_API TStartUpGlobals : public TGlobals
{
private:
	TCOMInitializer m_COMInitializer;


	void OnInitialize	();
	void OnUninitialize	();

public:
	// Files
	KString m_StartFile;

	// Folders
	KString m_StartFolder;
	KString m_WindowsFolder;
	KString m_SystemFolder;
	KString m_TempFolder;
	KString m_ProgramFilesFolder;
	KString m_StartMenuProgramsFolder;
	KString m_DesktopFolder;

	// Parameters
	KStrings m_Parameters;


	TStartUpGlobals();
};

extern KFC_COMMON_API TStartUpGlobals g_StartUpGlobals;

#endif // startup_globals_h
