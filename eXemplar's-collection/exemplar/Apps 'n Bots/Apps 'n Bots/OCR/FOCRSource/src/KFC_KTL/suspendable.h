#ifndef suspendable_h
#define suspendable_h

#include "basic_types.h"
#include "kfc_ktl_api.h"

// Activation suspension modes
#define	ASM_NEVER		(0)
#define ASM_ALWAYS		(1)
#define ASM_DEFAULT		(2) // ASM_ALWAYS for fullscreen, ASM_NEVER for windowed

// ------------
// Suspendable
// ------------
class KFC_KTL_API TSuspendable
{
private:
	size_t m_szSuspendCount;

protected:
	virtual bool OnSuspend	();
	virtual bool OnResume	();

public:
	TSuspendable();

	void ResetSuspendCount(size_t szSSuspendCount = 0);

	bool SetSuspendCount(size_t szSSuspendCount);

	bool Suspend();
	bool Resume	();

	// ---------------- TRIVIALS ----------------
	size_t GetSuspendCount() const { return m_szSuspendCount; }

	bool IsSuspended() const { return m_szSuspendCount ? true : false; }
};

// ----------
// Suspender
// ----------
class KFC_KTL_API TSuspender
{
private:
	TSuspendable* m_pSuspendable;

public:
	TSuspender(TSuspendable& SSuspendable);

	~TSuspender();

	// ---------------- TRIVIALS ----------------
	TSuspendable* GetSuspendable() const { return m_pSuspendable; }

	bool HasSucceeded() const { return m_pSuspendable != NULL; }
};

#endif // suspendable_h
