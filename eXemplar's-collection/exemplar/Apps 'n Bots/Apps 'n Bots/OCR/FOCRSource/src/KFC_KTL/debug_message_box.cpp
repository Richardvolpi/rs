#include "kfc_ktl_pch.h"
#include "debug_message_box.h"

#include "ktl_consts.h"

// ----------------
// Global routines
// ----------------
void DebugMessageBox(LPCTSTR pCaption, LPCTSTR pMessage)
{
	if(g_KTLConsts.m_bService)
	{
		TCHAR Buf[1024];

		_sntprintf(	Buf, sizeof(Buf) - 1,
						TEXT("\"%s\": \"%s\"\n"),
						pCaption ? pCaption : TEXT(""),
						pMessage ? pMessage : TEXT(""));

		OutputDebugString(Buf);
	}
	else if(g_KTLConsts.m_bConsole)
	{
		_ftprintf(	stderr,
						TEXT("\"%s\": \"%s\"\n"),
						pCaption ? pCaption : TEXT(""),
						pMessage ? pMessage : TEXT(""));
	}
	else
	{
		MessageBox(NULL, pMessage, pCaption, MB_OK | MB_ICONSTOP);
	}
}