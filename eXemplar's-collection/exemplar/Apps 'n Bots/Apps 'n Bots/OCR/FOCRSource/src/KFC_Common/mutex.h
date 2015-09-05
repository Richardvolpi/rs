#ifndef mutex_h
#define mutex_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_bitypes.h>
#include <KFC_KTL\basic_wintypes.h>
#include "kfc_common_api.h"

// ------
// Mutex
// ------
class KFC_COMMON_API TMutex
{
private:
	HANDLE m_hMutex;

public:
	TMutex();

	~TMutex() { Release(); }

	bool IsEmpty() const { return m_hMutex == NULL; }

	void Release();

	bool Create(bool	bInitialOwnership,
				LPCTSTR	pName = NULL); // true if it is a mew mutex

	void Open(LPCTSTR pName);

	bool Lock	(size_t szTimeout = INFINITE);
	void Unlock	();

	HANDLE GetMutex() const;

	operator HANDLE () const { return GetMutex(); }
};

// -------------
// Mutex locker
// -------------
class KFC_COMMON_API TMutexLocker
{
private:
	TMutex* m_pMutex;

public:
	TMutexLocker();

	TMutexLocker(	TMutex&	SMutex,
					size_t	szTimeout = INFINITE);

	~TMutexLocker() { Release(); }

	bool IsEmtpy() const { return m_pMutex == NULL; }
	
	void Release();

	bool Allocate(	TMutex&	SMutex,
					size_t	szTimeout = INFINITE);

	// ---------------- TRIVALS ----------------
	TMutex& GetMutex() { return *m_pMutex; }
};

#endif // mutex_h
