#ifndef server_device_globals_h
#define server_device_globals_h

#include <KFC_KTL\globals.h>
#include <KFC_Common\dll.h>
#include <common\rsa_key.h>
#include "ocr.h"

// ----------------------
// Server device globals
// ----------------------
class TServerDeviceGlobals : public TGlobals
{
private:
	void OnUninitialize	();
	void OnInitialize	();

public:
	// SSL
	SSL_CTX* m_pSSLContext;

	// Cfg
	size_t m_szTCPPort;

	size_t m_szSocketDelay;

	KString m_AuthURL;
	KString m_PostReplyURL;
	KString m_AuthResultString;

	// Cypher
	TRSAKey m_ServerKey;

	TRSAKey m_CertKey;

	// OCR
	TDLL m_OCR_DLL;


	TServerDeviceGlobals();
};

extern TServerDeviceGlobals g_ServerDeviceGlobals;

#endif // server_device_globals_h