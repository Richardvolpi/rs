#ifndef hooks_h
#define hooks_h

#include "dll.h"
#include "kfc_common_api.h"

// ---------------
// Hook installer
// ---------------
class KFC_COMMON_API THookInstaller
{
private:
	bool m_bAllocated;

	HHOOK m_hHook;

public:
	THookInstaller();

	~THookInstaller() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(	int			iType,
					const TDLL&	DLL,
					LPCSTR		pFunctionName,
					DWORD		dwThreadID = 0);

	HHOOK GetHook() const;

	operator HHOOK () const { return GetHook(); }
};

#endif // hooks_h