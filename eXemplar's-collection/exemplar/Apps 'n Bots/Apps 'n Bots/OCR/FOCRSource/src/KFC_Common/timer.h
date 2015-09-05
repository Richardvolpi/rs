#ifndef timer_h
#define timer_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\suspendable.h>
#include "kfc_common_api.h"
#include "time_globals.h"

// Immediate time
#define IMMEDIATE_TIME	(1)

// ------
// Timer
// ------
class KFC_COMMON_API TTimer : public TSuspendable
{
private:
	bool m_bAllocated;

	QWORD	m_qwLastStartTime;
	QWORD	m_qwAccumulatedTime;
	float	m_fSpeedCoef;

	bool OnSuspend	();
	bool OnResume	();
		
public:
	TTimer();

	~TTimer() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate();

	void Reset(QWORD qwSStartTime = g_TimeGlobals.GetMSEC());

	void SetSpeedCoef(float fSSpeedCoef, QWORD qwCurTime = g_TimeGlobals.GetMSEC());

	QWORD GetElapsedTime(QWORD qwCurTime = g_TimeGlobals.GetMSEC()) const;

	operator size_t () const { return (size_t)GetElapsedTime(); }

	// ---------------- TRIVIALS ----------------
	QWORD GetLastStartTime	() const { return m_qwLastStartTime;	}
	QWORD GetAccumulatedTime() const { return m_qwAccumulatedTime;	}

	float GetSpeedCoef() const { return m_fSpeedCoef; }
};

#endif // timer_h
