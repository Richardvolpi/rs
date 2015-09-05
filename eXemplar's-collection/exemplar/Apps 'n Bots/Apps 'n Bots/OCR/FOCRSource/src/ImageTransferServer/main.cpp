#include "server_pch.h"

#include <KFC_Common\common_consts.h>
#include <KFC_Common\process.h>
#include "server_globals.h"
#include "process.h"

// ----------
// Main proc
// ----------
int WINAPI WinMain(	HINSTANCE	hInstance,
					HINSTANCE	hPrevInstance,
					LPSTR		lpCmdLine,
					int			nShowCmd)
{
	KFC_OUTER_BLOCK_BEGIN
	{
		// Initializing
		g_CommonConsts.m_ApplicationGUIDString =
			TEXT("{E38AFE98-408F-48d2-AB18-E8535ACE557E}");

		TGlobalsInitializer Initializer0(g_ServerGlobals);

		// Running
		RunMainThread();
	}
	KFC_OUTER_BLOCK_END

	return 0;
}