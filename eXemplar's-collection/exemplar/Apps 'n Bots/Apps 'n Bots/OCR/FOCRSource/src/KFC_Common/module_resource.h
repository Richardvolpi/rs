#ifndef module_resource_h
#define module_resource_h

#include "module.h"

// ----------------
// Module resource
// ----------------
class KFC_COMMON_API TModuleResource
{
private:
	HMODULE m_hModule;

	HRSRC m_hResource;

public:
	TModuleResource();
	
	TModuleResource(HMODULE hSModule,
					LPCTSTR pType,
					LPCTSTR pName);

	~TModuleResource() { Release(); }

	bool IsEmpty() const { return m_hModule == NULL && m_hResource == NULL; }

	void Release();

	void Allocate(	HMODULE hSModule,
					LPCTSTR pType,
					LPCTSTR pName);

	size_t GetSize() const;

	const void* GetDataPtr() const;

	HRSRC GetResource() const;

	operator HRSRC () const { return GetResource(); }
};

#endif // module_resource_h