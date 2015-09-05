#ifndef event_h
#define event_h

#include "kfc_common_api.h"

// ------
// Event
// ------
class KFC_COMMON_API TEvent
{
private:
	HANDLE m_hEvent;
	
public:
	TEvent();

	TEvent(bool bInitialState, bool bManualReset);

	~TEvent() { Release(); }

	bool IsEmpty() const { return m_hEvent == NULL; }

	void Release();

	void Allocate(bool bInitialState, bool bManualReset);

	void Set();
	
	void Reset();

	bool Wait(size_t szTimeOut = INFINITE);

	HANDLE GetEvent() const;

	operator HANDLE () const { return GetEvent(); }
};

#endif // event_h