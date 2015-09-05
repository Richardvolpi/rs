#ifndef handle_h
#define handle_h

#include <windows.h>
#include "kfc_common_api.h"

// -------
// Handle
// -------
class KFC_COMMON_API THandle
{
private:
	union
	{
		HANDLE	m_hHandle;
		HWND	m_hWnd;
	};

public:
	THandle();

	THandle(HANDLE hSHandle);

	THandle(HWND hSWnd);
	
	~THandle() { Release(); }

	bool IsEmpty() const { return m_hHandle == NULL; }

	void Invalidate();

	void Release();

	void Allocate(HANDLE hSHandle);

	void Allocate(HWND hSWnd);

	void ReOwn(THandle& SHandle);

	HANDLE GetHandle() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return m_hHandle;
	}

	HWND GetWnd() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return (HWND)m_hHandle;
	}

	operator HANDLE () const { return GetHandle(); }

	operator HWND () const { return GetWnd(); }
};

#endif // handle_h