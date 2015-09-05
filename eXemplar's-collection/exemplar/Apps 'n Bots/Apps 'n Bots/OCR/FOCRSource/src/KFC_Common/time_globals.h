#ifndef time_globals_h
#define time_globals_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\globals.h>
#include "kfc_common_api.h"

// -------------
// Time globals
// -------------
struct KFC_COMMON_API TTimeGlobals : public TGlobals
{
private:
	QWORD m_qwFrequency;

	QWORD m_qwLastStartTime;
	QWORD m_qwAccumulatedTime;	
	

	void OnInitialize	();
	void OnUninitialize	();

	bool OnSuspend	();
	bool OnResume	();

public:
	TTimeGlobals();

	QWORD GetMSEC() const;	

	static QWORD GetSystemTimerFrequency();

	static QWORD GetSystemTimerValue(QWORD qwFrequency);

	// ---------------- TRIVIALS ----------------
	QWORD GetFrequency() const { return m_qwFrequency; }
};

extern KFC_COMMON_API TTimeGlobals g_TimeGlobals;

#endif // time_globals_h
