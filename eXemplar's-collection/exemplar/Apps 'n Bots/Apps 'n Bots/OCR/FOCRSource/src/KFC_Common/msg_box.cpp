#include "kfc_common_pch.h"
#include "msg_box.h"

#include "common_device_globals.h"

// ---------------
// Msg box params
// ---------------
int TMsgBoxParams::Spawn() const
{
	return MessageBox(m_hWnd, m_Text, m_Caption, m_tpType);
}

// ----------------
// Global routines
// ----------------
static unsigned __stdcall MsgBoxThreadProc(void* pParam)
{
	const TMsgBoxParams LocalParams = *(const TMsgBoxParams*)pParam;

	g_CommonDeviceGlobals.m_MsgBoxesEvent.Set();

	LocalParams.Spawn();

	return 0;
}

void ThreadedMessageBox(const TMsgBoxParams& Params)
{
	g_CommonDeviceGlobals.m_MsgBoxesEvent.Reset();

	UINT uiThread;
	if(_beginthreadex(NULL, 0, MsgBoxThreadProc, (void*)&Params, 0, &uiThread) == 0)
	{
		INITIATE_DEFINED_FAILURE(TEXT("Error starting threaded message box thread."));
	}

	g_CommonDeviceGlobals.m_MsgBoxesEvent.Wait();
}