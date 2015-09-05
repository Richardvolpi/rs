#include "kfc_common_pch.h"
#include "service.h"

#include "delay_load.h"

// ---------------------
// Delay-load functions
// ---------------------

// CloseServiceHandle
typedef BOOL WINAPI TCloseServiceHandle(SC_HANDLE);

static TDelayLoadFunction<TCloseServiceHandle>
	DLCloseServiceHandle(	TEXT("Advapi32.dll"),
							TEXT("CloseServiceHandle"));

// OpenSCManager
typedef SC_HANDLE WINAPI TOpenSCManager(LPCTSTR, LPCTSTR, DWORD);

static TDelayLoadFunction<TOpenSCManager>
	DLOpenSCManager(TEXT("Advapi32.dll"),
					TEXT("OpenSCManager") UNICODE_POSTFIX);

// CreateService
typedef SC_HANDLE WINAPI TCreateService(SC_HANDLE,
										LPCTSTR,
										LPCTSTR,
										DWORD,
										DWORD,
										DWORD,
										DWORD,
										LPCTSTR,
										LPCTSTR,
										LPDWORD,
										LPCTSTR,
										LPCTSTR,
										LPCTSTR);

static TDelayLoadFunction<TCreateService>
	DLCreateService(TEXT("Advapi32.dll"),
					TEXT("CreateService") UNICODE_POSTFIX);


// OpenService
typedef SC_HANDLE WINAPI TOpenService(	SC_HANDLE,
										LPCTSTR,
										DWORD);

static TDelayLoadFunction<TOpenService>
	DLOpenService(	TEXT("Advapi32.dll"),
					TEXT("OpenService") UNICODE_POSTFIX);

// DeleteService
typedef BOOL WINAPI TDeleteService(SC_HANDLE);

static TDelayLoadFunction<TDeleteService>
	DLDeleteService(TEXT("Advapi32.dll"),
					TEXT("DeleteService"));

// StartService
typedef BOOL WINAPI TStartService(	SC_HANDLE,
									DWORD,
									LPCTSTR*);

static TDelayLoadFunction<TStartService>
	DLStartService(	TEXT("Advapi32.dll"),
					TEXT("StartService") UNICODE_POSTFIX);

// ControlService
typedef BOOL WINAPI TControlService(SC_HANDLE,
									DWORD,
									LPSERVICE_STATUS);

static TDelayLoadFunction<TControlService>
	DLControlService(	TEXT("Advapi32.dll"),
						TEXT("ControlService"));

// ----------------
// Service manager
// ----------------
TServiceManager::TServiceManager(flags_t flAutoOpenAccess)
{
	m_hManager = NULL;

	if(flAutoOpenAccess)
		Allocate(flAutoOpenAccess);
}

void TServiceManager::Release()
{
	if(m_hManager)
		DLCloseServiceHandle()(m_hManager), m_hManager = NULL;
}

void TServiceManager::Allocate(flags_t flAccess)
{
	Release();

	try
	{
		m_hManager = DLOpenSCManager()(NULL, NULL, flAccess);

		if(m_hManager == NULL)
		{
			INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error opening service manager"),
											GetLastError());
		}
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

SC_HANDLE TServiceManager::CreateService(	LPCTSTR pServiceName,
											LPCTSTR pDisplayName,
											LPCTSTR pFileName)
{
	DEBUG_VERIFY_ALLOCATION;

	const SC_HANDLE hService = DLCreateService()(	*this,
													pServiceName,
													pDisplayName,
													SERVICE_ALL_ACCESS,
													SERVICE_WIN32_OWN_PROCESS,
													SERVICE_AUTO_START,
													SERVICE_ERROR_NORMAL,
													pFileName,
													NULL,
													NULL,
													NULL,
													NULL,
													NULL);

	if(hService == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error creating service \"")	+
											pDisplayName							+
											TEXT("\""),
										GetLastError());
	}
	
	return hService;
}

SC_HANDLE TServiceManager::OpenService(	LPCTSTR pServiceName,
										flags_t flAccess)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(pServiceName);

	const SC_HANDLE hService = DLOpenService()(*this, pServiceName, flAccess);

	if(hService == NULL)
	{
		INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error opening service \"")	+
											pServiceName							+
											TEXT("\"."),
										GetLastError());
	}

	return hService;
}

void TServiceManager::DeleteService(SC_HANDLE hService, bool bSafe)
{
	DEBUG_VERIFY_ALLOCATION;

	DEBUG_VERIFY(hService);

	TService Service(hService);

	Service.Stop(true);

	Service.Invalidate();

	if(!DLDeleteService()(hService) && !bSafe)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error deleteing service"),
										GetLastError());
	}
}

SC_HANDLE TServiceManager::GetManager() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hManager;
}

// --------
// Service
// --------
TService::TService()
{
	Invalidate();
}

TService::TService(SC_HANDLE hSService)
{
	Invalidate();

	Allocate(hSService);
}

void TService::Invalidate()
{
	m_hService = NULL;
}

void TService::Release()
{
	if(m_hService)
		DLCloseServiceHandle()(m_hService), m_hService = NULL;
}

void TService::Allocate(SC_HANDLE hSService)
{
	Release();

	try
	{
		DEBUG_VERIFY(hSService);

		m_hService = hSService;
	}

	catch(...)
	{
		Release();
		throw 1;
	}
}

void TService::Start()
{
	DEBUG_VERIFY_ALLOCATION;

	if(!DLStartService()(*this, 0, NULL))
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error starting service"),
										GetLastError());
	}
}

void TService::Stop(bool bSafe)
{
	DEBUG_VERIFY_ALLOCATION;

	SERVICE_STATUS Status;
	if(!DLControlService()(*this, SERVICE_CONTROL_STOP, &Status) && !bSafe)
	{
		INITIATE_DEFINED_CODE_FAILURE(	TEXT("Error stopping service"),
										GetLastError());
	}
}

SC_HANDLE TService::GetService() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_hService;
}
