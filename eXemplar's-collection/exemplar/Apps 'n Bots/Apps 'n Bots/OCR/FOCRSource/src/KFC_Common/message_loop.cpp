#include "kfc_common_pch.h"
#include "message_loop.h"

// ----------------
// Global routines
// ----------------
void RunMessageLoop()
{
	MSG Message;
	while(GetMessage(&Message, NULL, 0, 0))
		TranslateMessage(&Message), DispatchMessage(&Message);
}