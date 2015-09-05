// ocrdll.cpp : Defines the entry point for the DLL application.
//

#include "stdafx.h"

#include <windows.h>

float *probs[256];

BOOL APIENTRY DllMain( HANDLE hModule, 
                       DWORD  ul_reason_for_call, 
                       LPVOID lpReserved
					 )
{
	int i;
	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
		{
			for (i = 0; i < 256; i++)
			{
				probs[i] = NULL;
			}
			break;
		}
	case DLL_THREAD_ATTACH:
	case DLL_THREAD_DETACH:
	case DLL_PROCESS_DETACH:
		{
/*
			for (i = 0;i < 256; i++)
			{
				if (probs[i] != NULL) delete probs[i];
			}
*/
		}
		break;
	}
    return TRUE;
}



