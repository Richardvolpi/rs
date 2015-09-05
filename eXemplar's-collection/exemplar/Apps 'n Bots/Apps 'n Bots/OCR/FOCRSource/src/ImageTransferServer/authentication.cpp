#include "server_pch.h"
#include "authentication.h"

#include <KFC_KTL\token.h>
#include "server_device_globals.h"
#include "http_socket.h"

// ----------------
// Global routines
// ----------------
bool Authenticate(	const KString& Login,
					const KString& Password,
					const KString& IP)
{
	SAFE_BLOCK_BEGIN
	{
		TTokens Tokens(3);

		Tokens.Add().Set(TEXT("[login]"),		Login);
		Tokens.Add().Set(TEXT("[password]"),	Password);
		Tokens.Add().Set(TEXT("[ip]"),			IP);

		return	g_ServerDeviceGlobals.m_AuthResultString ==
					(SendSimpleHTTPRequest(Tokens.Process(g_ServerDeviceGlobals.m_AuthURL)));
	}
	SAFE_BLOCK_END

	return false;
}

void PostReply(	const KString& Login,
				const KString& Password,
				const KString& IP)
{
	SAFE_BLOCK_BEGIN
	{
		TTokens Tokens(3);

		Tokens.Add().Set(TEXT("[login]"),		Login);
		Tokens.Add().Set(TEXT("[password]"),	Password);
		Tokens.Add().Set(TEXT("[ip]"),			IP);

		SendSimpleHTTPRequest(Tokens.Process(g_ServerDeviceGlobals.m_PostReplyURL));
	}
	SAFE_BLOCK_END
}