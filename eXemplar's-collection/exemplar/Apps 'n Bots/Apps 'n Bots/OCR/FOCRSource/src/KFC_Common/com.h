#ifndef com_h
#define com_h

#include "kfc_common_api.h"

// Failsafe constants
#define WRONG_GUID_TEXT		TEXT("{WRONG_GUID}")
#define WRONG_CLSID_TEXT	TEXT("{WRONG_CLSID}")
#define WRONG_IID_TEXT		TEXT("{WRONG_IID}")

// ----------------
// COM initializer
// ----------------
class KFC_COMMON_API TCOMInitializer
{
private:
	bool m_bAllocated;

public:
	TCOMInitializer();

	TCOMInitializer(bool bAllocate);

	~TCOMInitializer() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate();	
};

// ----------------
// OLE initializer
// ----------------
class KFC_COMMON_API TOLEInitializer
{
private:
	bool m_bAllocated;

public:
	TOLEInitializer();

	~TOLEInitializer() { Release(); }

	bool IsEmpty() const { return !m_bAllocated; }

	void Release();

	void Allocate();
};

// --------------
// COM interface
// --------------
template <class InterfaceType>
class TCOMInterface
{
private:
	InterfaceType* m_pInterface;

public:
	TCOMInterface(	REFCLSID	rCLSID,
					REFIID		rIID,
					DWORD		dwContext = CLSCTX_INPROC_SERVER,
					IUnknown*	pUnkOuter = NULL);

	TCOMInterface(IUnknown* pInterface, REFIID rIID);

	TCOMInterface(IUnknown* pSInterface);

	virtual ~TCOMInterface() { m_pInterface->Release(); }

	InterfaceType* GetInterface() const { return m_pInterface; }

	InterfaceType* operator -> () const { return GetInterface(); }
};

template <class InterfaceType>
TCOMInterface<InterfaceType>::TCOMInterface(REFCLSID	rCLSID,
											REFIID		rIID,
											DWORD		dwContext,
											IUnknown*	pUnkOuter)
{
	HRESULT r;

	m_pInterface = NULL;
	if(r = CoCreateInstance(rCLSID, pUnkOuter, dwContext, rIID, (void**)&m_pInterface))
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error creating COM object instance,\r\n")		+
											TEXT("CLSID=")	+ KCLSIDToString(rCLSID)	+ TEXT(",\r\n")	+
											TEXT("IID=")	+ KIIDToString	(rIID)		+ TEXT("\r\n"),
										r);
	}
}

template <class InterfaceType>
TCOMInterface<InterfaceType>::TCOMInterface(IUnknown* pInterface, REFIID rIID)
{
	DEBUG_VERIFY(pInterface);

	HRESULT r;

	m_pInterface = NULL;
	if(r = pInterface->QueryInterface(rIID, (void**)&m_pInterface))
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error querying interface,\r\n")	+
											TEXT("IID=") + KIIDToString(rIID) + TEXT("\r\n"),
										r);
	}
}

template <class InterfaceType>
TCOMInterface<InterfaceType>::TCOMInterface(IUnknown* pSInterface)
{
	DEBUG_VERIFY(pInterface);

	m_pInterface = pSInterface;
}

// ----------------
// Global routines
// ----------------
KFC_COMMON_API GUID CreateGUID();

KFC_COMMON_API KString KGUIDToString	(REFGUID	rGUID);
KFC_COMMON_API KString KCLSIDToString	(REFCLSID	rCLSID);
KFC_COMMON_API KString KIIDToString		(REFIID		rIID);

#endif // com_h