#ifndef global_mem_h
#define global_mem_h

#include "kfc_common_api.h"

// -----------
// Global mem
// -----------
class KFC_COMMON_API TGlobalMem
{
private:
	bool m_bAllocated;

	HGLOBAL m_hMem;
	
public:
	TGlobalMem();

	TGlobalMem(HANDLE hSMem);

	TGlobalMem(size_t szSize, flags_t flFlags);

	~TGlobalMem() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Invalidate();

	void Release(bool bFromAllocatorException = false);

	void Allocate(HANDLE hSMem);

	void Allocate(size_t szSize, flags_t flFlags);	

	void ReOwn(TGlobalMem& SGlobalMem);

	size_t GetSize() const;
	
	void Lock	(void*& pRData);
	void Unlock	();

	HGLOBAL GetMem() const
	{
		DEBUG_VERIFY_ALLOCATION;

		return m_hMem;
	}

	operator HGLOBAL () const { return GetMem(); }
};

// ------------------
// Global mem locker
// ------------------
class KFC_COMMON_API TGlobalMemLocker
{
private:
	TGlobalMem* m_pGlobalMem;

public:
	TGlobalMemLocker(TGlobalMem& SGlobalMem, void*& pRData);

	~TGlobalMemLocker();

	// ---------------- TRIVIALS ----------------
	TGlobalMem& GetGlobalMem() const { return *m_pGlobalMem; }
};

#endif // global_mem_h