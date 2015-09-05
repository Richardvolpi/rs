#include "kfc_common_pch.h"
#include "handle.h"

// -------
// Handle
// -------
THandle::THandle()
{
	Invalidate();
}

THandle::THandle(HANDLE hSHandle)
{
	Invalidate();

	Allocate(hSHandle);
}

THandle::THandle(HWND hSWnd)
{
	Invalidate();

	Allocate(hSWnd);
}

void THandle::Invalidate()
{
	m_hHandle = NULL;
}

void THandle::Release()
{
	if(m_hHandle && m_hHandle != INVALID_HANDLE_VALUE)
		CloseHandle(m_hHandle), Invalidate();
}

void THandle::Allocate(HANDLE hSHandle)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSHandle != NULL && hSHandle != INVALID_HANDLE_VALUE);

		m_hHandle = hSHandle;
	}
	
	catch(...)
	{
		Release();
		throw 1;
	}
}

void THandle::Allocate(HWND hSWnd)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSWnd != NULL);

		m_hWnd = hSWnd;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void THandle::ReOwn(THandle& SHandle)
{
	Release();

	if(SHandle.IsEmpty())
		return;

	m_hHandle = SHandle, SHandle.Invalidate();
}