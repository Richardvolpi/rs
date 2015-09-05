#include "client_common_pch.h"
#include "client_common_device_globals.h"

#include <KFC_Common\module_resource.h>
#include <KFC_Common\memory_stream.h>

TClientCommonDeviceGlobals g_ClientCommonDeviceGlobals;

// -----------------------------
// Client common device globals
// -----------------------------
TClientCommonDeviceGlobals::TClientCommonDeviceGlobals() :
	TGlobals(TEXT("Client common device globals"))
{
	m_hCertResInst	= NULL;
	m_iCertResID	= -1;
}

void TClientCommonDeviceGlobals::OnUninitialize()
{
	// Cypher
	{
		m_CertKey.Release();
	}
}

void TClientCommonDeviceGlobals::OnInitialize()
{
	// Cypher
	{
		DEBUG_VERIFY(m_hCertResInst && m_iCertResID >= 0);

		TModuleResource Resource(	m_hCertResInst,
									RT_RCDATA,
									MAKEINTRESOURCE(m_iCertResID));

		TMemoryStream Stream(TArrayAllocation(1024, 1024));

		Stream.StreamWrite(Resource.GetDataPtr(), Resource.GetSize());

		m_CertKey.LoadPublic(Stream);
	}
}