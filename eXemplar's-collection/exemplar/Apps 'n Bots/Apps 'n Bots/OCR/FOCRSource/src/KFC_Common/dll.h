#ifndef dll_h
#define dll_h

#include <KFC_KTL\basic_wintypes.h>
#include "kfc_common_api.h"

// ----
// DLL
// ----
class KFC_COMMON_API TDLL
{
private:
	bool m_bAllocated;

	HMODULE m_hModule;

public:
	TDLL();

	TDLL(LPCTSTR pFileName);

	TDLL(HMODULE hSModule);
	
	~TDLL() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release(bool bFromAllocatorException = false);

	void Allocate(LPCTSTR pFileName);

	void Allocate(HMODULE hSModule);

	void ReOwn(TDLL& SDLL);

	void Invalidate();

	void* GetFunction(LPCSTR pFunctionName) const;	

	HMODULE GetModule() const;

	operator HMODULE () const { return m_hModule; }	
};

#endif // dll_h
