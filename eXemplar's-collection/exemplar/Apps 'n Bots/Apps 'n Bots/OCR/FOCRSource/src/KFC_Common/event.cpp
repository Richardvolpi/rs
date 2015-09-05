#include "kfc_common_pch.h"
#include "event.h"

// ------
// Event
// ------
TEvent::TEvent()
{
	m_hEvent = NULL;
}

TEvent::TEvent(bool bInitialState, bool bManualReset)
{
	m_hEvent = NULL;

	Allocate(bInitialState, bManualReset);
}

void TEvent::Release()
{
	if(m_hEvent)
		CloseHandle(m_hEvent), m_hEvent = NULL;
}

void TEvent::Allocate(bool bInitialState, bool bManualReset)
{
	Release();
	
	try
	{
		m_hEvent = CreateEvent(	NULL,
								bManualReset	? TRUE : FALSE,
								bInitialState	? TRUE : FALSE,
								NULL);

		if(m_hEvent == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error creating event"),
											GetLastError());
		}
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TEvent::Set()
{
	DEBUG_VERIFY_ALLOCATION;

	SetEvent(m_hEvent);
}

void TEvent::Reset()
{
	DEBUG_VERIFY_ALLOCATION;

	ResetEvent(m_hEvent);
}

HANDLE TEvent::GetEvent() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hEvent;
}

bool TEvent::Wait(size_t szTimeOut)
{
	return WaitForSingleObject(m_hEvent, szTimeOut) == WAIT_OBJECT_0;
}