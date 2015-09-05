#include "kfc_common_pch.h"
#include "timer.h"

// ------
// Timer
// ------
TTimer::TTimer()
{
	m_bAllocated = false;
}

void TTimer::Release()
{
	m_bAllocated = false;
}

void TTimer::Allocate()
{
	Release();

	try
	{
		m_fSpeedCoef = 1.0f;

		ResetSuspendCount();

		m_bAllocated = true;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TTimer::Reset(QWORD qwSStartTime)
{
	DEBUG_VERIFY_ALLOCATION;

	m_qwLastStartTime = qwSStartTime;

	m_qwAccumulatedTime = 0;
}

void TTimer::SetSpeedCoef(float fSSpeedCoef, QWORD qwCurTime)
{
	DEBUG_VERIFY_ALLOCATION;

	m_qwAccumulatedTime = GetElapsedTime(qwCurTime), m_qwLastStartTime = qwCurTime;

	m_fSpeedCoef = fSSpeedCoef;
}

bool TTimer::OnSuspend()
{
	if(IsEmpty())
		return false;

	if(!TSuspendable::OnSuspend())
		return false;
	
	m_qwAccumulatedTime = GetElapsedTime(g_TimeGlobals.GetMSEC());

	return true;
}

bool TTimer::OnResume()
{
	DEBUG_VERIFY_ALLOCATION;

	if(!TSuspendable::OnResume())
		return false;

	m_qwLastStartTime = g_TimeGlobals.GetMSEC();

	return true;
}

QWORD TTimer::GetElapsedTime(QWORD qwCurTime) const
{
	DEBUG_VERIFY_ALLOCATION;

	QWORD qwElapsedTime = m_qwAccumulatedTime;

	if(!IsSuspended())
		qwElapsedTime += (QWORD)((__int64)(qwCurTime - m_qwLastStartTime) * m_fSpeedCoef);
	
	return qwElapsedTime;
}
