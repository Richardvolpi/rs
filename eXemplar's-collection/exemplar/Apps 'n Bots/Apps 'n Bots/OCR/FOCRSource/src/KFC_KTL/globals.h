#ifndef globals_h
#define globals_h

#include "basic_types.h"
#include "kstring.h"
#include "kfc_ktl_api.h"
#include "suspendable.h"
#include "varray.h"

// --------
// Globals
// --------
class KFC_KTL_API TGlobals : public TSuspendable
{
private:
	size_t m_szRefCount;

	bool m_bInitializing;

	KString m_Name;

	TValueArray<TGlobals*, true>	m_SubGlobals;
	size_t							m_szNSubGlobalsInitialized;


	void InternalInitialize		();
	void InternalUninitialize	();

protected:
	virtual void OnUninitialize	() = 0;
	virtual void OnInitialize	() = 0;

	virtual bool OnSuspend	() { return TSuspendable::OnSuspend	() && IsInitialized(); }
	virtual bool OnResume	() { return TSuspendable::OnResume	() && IsInitialized(); }

	virtual bool OnPreUpdate	() { return true; }
	virtual void OnUpdate		() {}
	virtual void OnPostUpdate	(bool bFailureRollBack) {}

	virtual bool OnPreRender	() const { return true; }
	virtual void OnRender		() const {}
	virtual void OnPostRender	(bool bFailureRollBack) const {}

	virtual void OnChangeMode() {}

	virtual void OnTerminate() {}

	void AddSubGlobals(TGlobals& Globals);

public:
	TGlobals(	LPCTSTR	pSName,
				size_t	szNSubGlobals = 0);

	~TGlobals();

	void UnInitialize	();
	void Initialize		();

	bool PreUpdate	() { DEBUG_VERIFY_INITIALIZATION; return OnPreUpdate(); }
	void Update		() { DEBUG_VERIFY_INITIALIZATION; OnUpdate(); }

	void PostUpdate	(bool bFailureRollBack)
	{
		DEBUG_VERIFY_INITIALIZATION;
		
		OnPostUpdate(bFailureRollBack);
	}

	bool PreRender	() const { DEBUG_VERIFY_INITIALIZATION; return OnPreRender(); }
	void Render		() const { DEBUG_VERIFY_INITIALIZATION; OnRender(); }

	void PostRender(bool bFailureRollBack)
	{
		DEBUG_VERIFY_INITIALIZATION;
		
		OnPostRender(bFailureRollBack);
	}
	
	void ChangeMode() { DEBUG_VERIFY_INITIALIZATION; OnChangeMode(); }

	void Terminate() { DEBUG_VERIFY_INITIALIZATION; OnTerminate(); }

	// ---------------- TRIVIALS ----------------
	const KString& GetName() const { return m_Name; }

	size_t GetRefCount() const { return m_szRefCount; }

	bool IsInitialized() const { return m_szRefCount > 0; }
};

// --------------------
// Globals initializer
// --------------------
class KFC_KTL_API TGlobalsInitializer
{
private:
	TGlobals* m_pGlobals;

public:
	TGlobalsInitializer();

	TGlobalsInitializer(TGlobals& SGlobals);

	~TGlobalsInitializer() { Release(); }
	
	bool IsEmpty() const { return m_pGlobals == NULL; }

	void Release();

	void Allocate(TGlobals& SGlobals);
	
	// ---------------- TRIVIALS ----------------
	TGlobals* GetGlobals() { return m_pGlobals; }
};

#endif // globals_h
