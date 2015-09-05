#ifndef globals_collector_h
#define globals_collector_h

#include "suspendable.h"
#include "globals.h"
#include "varray.h"
#include "kfc_ktl_api.h"

// ------------------
// Globals collector
// ------------------
class KFC_KTL_API TGlobalsCollector : public TSuspendable
{
private:
	TValueArray<TGlobals*, true> m_GlobalsList;

	bool OnSuspend	();
	bool OnResume	();
	
	bool PreUpdate();

	void PostUpdate(size_t	szStartIndex,
					bool	bFailureRollBack);

	bool PreRender() const;

	void PostRender(size_t	szStartIndex,
					bool	bFailureRollBack) const;

public:
	TGlobalsCollector();

	~TGlobalsCollector();

	void RegisterGlobals	(TGlobals* pGlobals);
	void UnregisterGlobals	(TGlobals* pGlobals);

	bool Update();
	bool Render() const;

	void ChangeMode();

	void Terminate();
};

extern KFC_KTL_API TGlobalsCollector g_GlobalsCollector;

#endif // globals_collector_h
