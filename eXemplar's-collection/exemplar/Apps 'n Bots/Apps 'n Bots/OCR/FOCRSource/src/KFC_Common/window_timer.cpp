#include "kfc_common_pch.h"
#include "window_timer.h"

#include <KFC_KTL\win_inc.h>

// -------------
// Window timer
// -------------
TWindowTimer::TWindowTimer()
{
	m_bAllocated = false;
}

void TWindowTimer::Release(bool bFromAllocatorException)
{
	if(m_bAllocated || bFromAllocatorException)
	{
		m_bAllocated = false;

		KillTimer(m_hWnd, m_szTimerID);
	}
}

void TWindowTimer::Allocate(HWND		hSWnd,
							size_t		szTimeout,
							size_t		szSEventID,
							TIMERPROC	pTimerProc)
{
	Release();

	try
	{
		m_hWnd		= hSWnd;
		m_szEventID	= szSEventID;

		m_szTimerID = SetTimer(m_hWnd, m_szEventID, szTimeout, pTimerProc);

		m_bAllocated = true;
	}

	catch(...)
	{
		Release(true);
		throw 1;
	}
}

size_t TWindowTimer::GetTimerID() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_szTimerID;
}
