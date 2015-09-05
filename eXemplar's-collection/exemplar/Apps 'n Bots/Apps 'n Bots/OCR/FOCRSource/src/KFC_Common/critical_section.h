#ifndef critical_section_h
#define critical_section_h

#include <KFC_KTL\win_inc.h>
#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\basic_wintypes.h>
#include "kfc_common_api.h"

// -----------------
// Critical section
// -----------------
class KFC_COMMON_API TCriticalSection
{
private:	
	mutable CRITICAL_SECTION m_CriticalSection;

public:
	TCriticalSection() { InitializeCriticalSection(&m_CriticalSection); }

	~TCriticalSection() { DeleteCriticalSection(&m_CriticalSection); }

	void Lock	() { EnterCriticalSection(&m_CriticalSection); }
	void Unlock	() { LeaveCriticalSection(&m_CriticalSection); }

	CRITICAL_SECTION* GetCriticalSection() const { return &m_CriticalSection; }

	operator CRITICAL_SECTION* () const { return GetCriticalSection(); }
};

// ------------------------
// Critical section locker
// ------------------------
class KFC_COMMON_API TCriticalSectionLocker
{
private:
	TCriticalSection* m_pCriticalSection;

public:
	TCriticalSectionLocker();

	TCriticalSectionLocker(TCriticalSection& SCriticalSection);

	~TCriticalSectionLocker() { Release(); }

	bool IsEmpty() const { return m_pCriticalSection == NULL; }

	void Release();

	void Allocate(TCriticalSection& SCriticalSection);

	// ---------------- TRIVIALS ----------------
	TCriticalSection& GetCriticalSection() { return *m_pCriticalSection; }
};

#endif // critical_section_h
