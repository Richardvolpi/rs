#ifndef client_common_device_globals_h
#define client_common_device_globals_h

#include <KFC_KTL\globals.h>
#include <common\rsa_key.h>

// -----------------------------
// Client common device globals
// -----------------------------
class TClientCommonDeviceGlobals : public TGlobals
{
private:
	void OnUninitialize	();
	void OnInitialize	();

public:
	// Cypher
	HINSTANCE	m_hCertResInst;
	int			m_iCertResID;

	TRSAKey m_CertKey;


	TClientCommonDeviceGlobals();
};

extern TClientCommonDeviceGlobals g_ClientCommonDeviceGlobals;

#endif // client_common_device_globals_h