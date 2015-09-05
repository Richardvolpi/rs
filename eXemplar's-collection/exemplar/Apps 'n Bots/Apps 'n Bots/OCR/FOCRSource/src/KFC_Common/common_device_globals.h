#ifndef common_device_globals_h
#define common_device_globals_h

#include <KFC_KTL\globals.h>
#include "kfc_common_api.h"

#include "msg_box.h"
#include "event.h"
#include "com.h"

// ----------------------
// Common device globals
// ----------------------
class KFC_COMMON_API TCommonDeviceGlobals : public TGlobals
{
private:
	TCOMInitializer m_COMInitializer;


	void OnUninitialize	();
	void OnInitialize	();

public:
	TEvent m_MsgBoxesEvent;

	TCommonDeviceGlobals();
};

extern KFC_COMMON_API TCommonDeviceGlobals g_CommonDeviceGlobals;

#endif // common_device_globals_h