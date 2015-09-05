#ifndef networking_device_globals_h
#define networking_device_globals_h

#include "winsock_inc.h"
#include <KFC_KTL\globals.h>
#include <KFC_KTL\varray.h>
#include "kfc_networking_api.h"
#include "socket.h"

// --------------------------
// Networking device globals
// --------------------------
class KFC_NETWORKING_API TNetworkingDeviceGlobals : public TGlobals
{
private:
	bool m_bStarted;

	// WSA
	WSADATA m_WSAData;


	void OnUninitialize	();
	void OnInitialize	();

public:
	TNetworkingDeviceGlobals();

	TIPAddress ResolveHostName(const KString& Name);

	// ---------------- TRIVIALS ----------------
	const WSADATA& GetWSAData() const { return m_WSAData; }
};

extern KFC_NETWORKING_API TNetworkingDeviceGlobals g_NetworkingDeviceGlobals;

#endif // networking_device_globals_h
