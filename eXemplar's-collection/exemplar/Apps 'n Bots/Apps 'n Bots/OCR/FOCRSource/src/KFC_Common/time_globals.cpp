#include "kfc_common_pch.h"
#include "time_globals.h"

#include <KFC_KTL\win_inc.h>
#include "common_consts.h"

TTimeGlobals g_TimeGlobals;

// -------------
// Time globals
// -------------
TTimeGlobals::TTimeGlobals() : TGlobals(TEXT("Time globals"), 0)
{
}

void TTimeGlobals::OnUninitialize()
{
}

void TTimeGlobals::OnInitialize()
{
	if(!g_CommonConsts.m_bTimeGlobalsNeeded)
		return;

	m_qwFrequency = GetSystemTimerFrequency();

	m_qwLastStartTime = GetSystemTimerValue(m_qwFrequency);

	m_qwAccumulatedTime = 0;
}

bool TTimeGlobals::OnSuspend()
{
	if(!TGlobals::OnSuspend())
		return false;

	m_qwAccumulatedTime = GetMSEC();

	return true;
}

bool TTimeGlobals::OnResume()
{
	if(!TGlobals::OnSuspend())
		return false;

	m_qwLastStartTime = GetSystemTimerValue(m_qwFrequency);

	return true;
}

QWORD TTimeGlobals::GetMSEC() const
{
	DEBUG_VERIFY(IsInitialized());

	QWORD qwElapsedTime = m_qwAccumulatedTime;

	if(!IsSuspended())
		qwElapsedTime += GetSystemTimerValue(m_qwFrequency) - m_qwLastStartTime;

	return qwElapsedTime;
}

QWORD TTimeGlobals::GetSystemTimerFrequency()
{
	LARGE_INTEGER Frequency;
	if(QueryPerformanceFrequency(&Frequency) == 0)
		INITIATE_DEFINED_FAILURE(TEXT("Error retrieving system timer frequency."));

	return Frequency.QuadPart;
}

QWORD TTimeGlobals::GetSystemTimerValue(QWORD qwFrequency)
{
	LARGE_INTEGER Count;
	if(QueryPerformanceCounter(&Count) == 0)
		INITIATE_DEFINED_FAILURE(TEXT("Error getting system timer value."));

	return Count.QuadPart * 1000 / qwFrequency;
}
