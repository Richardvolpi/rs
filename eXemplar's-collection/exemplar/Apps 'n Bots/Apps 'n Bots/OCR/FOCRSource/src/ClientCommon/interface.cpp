#include "client_common_pch.h"
#include "interface.h"

#include <KFC_Common\file.h>
#include <KFC_Common\memory_stream.h>
#include <KFC_Common\module.h>
#include <KFC_Networking\networking_device_globals.h>
#include <KFC_Networking\socket.h>
#include <common\comdefs.h>
#include <common\rsa_key.h>
#include "client_common_globals.h"
#include "client_common_device_globals.h"

// ----------------
// Global routines
// ----------------
void InitializeTransfer(HINSTANCE	hCertResInst,
						int			iCertResID)
{
	KFC_OUTER_BLOCK_BEGIN
	{
		if(hCertResInst == NULL)
			hCertResInst = GetKModuleHandle();

		g_ClientCommonDeviceGlobals.m_hCertResInst	= hCertResInst;
		g_ClientCommonDeviceGlobals.m_iCertResID	= iCertResID;

		g_ClientCommonGlobals.Initialize();
	}
	KFC_OUTER_BLOCK_END
}

void ReleaseTransfer()
{
	KFC_OUTER_BLOCK_BEGIN
	{
		g_ClientCommonGlobals.UnInitialize();
	}
	KFC_OUTER_BLOCK_END
}

int QueryImageServer(	LPCTSTR	pServerAddress,
						DWORD	dwServerPort,
						LPCTSTR	pLogin,
						LPCTSTR	pPassword,
						LPCTSTR	pImageFileName,
						LPTSTR	pReplyBuffer,
						DWORD	dwReplyBufferLength,
						BOOL	bSilent)
{
	KFC_OUTER_BLOCK_BEGIN
	TEST_BLOCK_BEGIN
	{
		if(	pServerAddress	== NULL		||
			dwServerPort	>= 65536	||
			pLogin			== NULL		||
			pPassword		== NULL		||
			pImageFileName	== NULL		||
			pReplyBuffer	== NULL)
		{
			return CLNT_ERR_INVALID_ARG;
		}

		if(!FileExists(pImageFileName))
			return CLNT_ERR_FILE_NOT_FOUND;

		TIPAddress IPAddress;

		// Resolving IP
		TEST_BLOCK_BEGIN
		{
			IPAddress = g_NetworkingDeviceGlobals.ResolveHostName(pServerAddress);
		}
		TEST_BLOCK_EXCEPTION_HANDLER
		{
			return CLNT_ERR_RESOLVE_HOST_FAILED;
		}
		TEST_BLOCK_END

		TSocket DataSocket;
		TRSAKey ClientKey;
		TRSAKey ServerKey;

		DataSocket.Allocate();

		// Generating own key
		ClientKey.Generate(RSA_KEY_LENGTH);

		// Connecting the server
		TEST_BLOCK_BEGIN
		{
			DataSocket.Connect(TIPSocketAddress(IPAddress, dwServerPort));
		}
		TEST_BLOCK_EXCEPTION_HANDLER
		{
			return CLNT_ERR_UNABLE_TO_CONNECT;
		}
		TEST_BLOCK_END

		// Sending own key public part
		ClientKey.SavePublic(DataSocket);

		// Receiving server key public part (signed)
		{
			// Receiving
			ServerKey.LoadPublic(DataSocket);

			// Validating certificate signature
			TMemoryStream Stream(TArrayAllocation(1024, 1024));

			ServerKey.SavePublic(Stream);			

			TEST_BLOCK_BEGIN
			{
				TRSABuffer Buffer;

				g_ClientCommonDeviceGlobals.m_CertKey.DecryptPublic(DataSocket, Buffer);

				if(	Stream.GetN() != Buffer.GetN() ||
					memcmp(Stream.GetDataPtr(), Buffer.GetDataPtr(), Stream.GetN()))
				{
					INITIATE_DEFINED_FAILURE(TEXT("Server certificate mismatch."));
				}
			}
			TEST_BLOCK_EXCEPTION_HANDLER
			{
				return CLNT_ERR_INVALID_SERVER_CERTIFICATE;
			}
			TEST_BLOCK_END
		}

		// Sending request
		{
			KString IP;

			// Getting own IP
			{
				sockaddr_in addr;
				memset(&addr, 0, sizeof(addr)), addr.sin_family = AF_INET;

				int addr_len = sizeof(addr);
				getsockname(DataSocket, (sockaddr*)&addr, &addr_len);

				if(addr_len != sizeof(addr) || addr.sin_family != AF_INET)
					INITIATE_FAILURE;

				IP = TIPAddress(addr.sin_addr.s_addr);
			}

			// Login / password / IP
			{
				TMemoryStream Stream(TArrayAllocation(1024, 1024));

				Stream << KString(pLogin) << KString(pPassword) << IP;

				TRSABuffer RSABuffer;

				memcpy(&RSABuffer.Add(Stream.GetN()), Stream.GetDataPtr(), Stream.GetN());

				ServerKey.EncryptPublic(RSABuffer, DataSocket);
			}

			// Image
			{
				TLinearKey ImageKey;

				ImageKey.Generate(LINEAR_KEY_LENGTH);

				// Sending image linear key
				{
					TMemoryStream Stream(TArrayAllocation(1024, 1024));

					ImageKey.Save(Stream);

					TRSABuffer RSABuffer;

					memcpy(&RSABuffer.Add(Stream.GetN()), Stream.GetDataPtr(), Stream.GetN());

					ServerKey.EncryptPublic(RSABuffer, DataSocket);
				}

				// Encrypting file data using image linear key end sending it
				{
					TMemoryStream Stream(TArrayAllocation(1024, 1024));

					{
						TFile File(pImageFileName, FOF_BINARYREAD);

						const size_t szFileLength = File.GetLength();

						Stream << szFileLength;

						TValueArray<BYTE, true> Buffer;

						File.Read(&Buffer.AllocateAdd(szFileLength), szFileLength);

						Stream.StreamWrite(Buffer.GetDataPtr(), Buffer.GetN());
					}

					TRSABuffer RSABuffer;

					memcpy(&RSABuffer.Add(Stream.GetN()), Stream.GetDataPtr(), Stream.GetN());

					ImageKey.Encrypt(RSABuffer, DataSocket);
				}
			}
		}

		// Receiving reply
		{
			TRSABuffer RSABuffer;

			ClientKey.DecryptPrivate(DataSocket, RSABuffer);

			TMemoryStream Stream(TArrayAllocation(1024, 1024));

			Stream.StreamWrite(RSABuffer.GetDataPtr(), RSABuffer.GetN());

			KString Reply;

			Stream >> Reply;

			if(dwReplyBufferLength > 0)
			{
				memcpy(	pReplyBuffer,
						Reply.GetDataPtr(),
						Min(Reply.GetLength() + 1, (size_t)dwReplyBufferLength) *
							sizeof(pReplyBuffer[0]));

				pReplyBuffer[dwReplyBufferLength - 1] = 0;
			}
		}

		return CLNT_ERR_OK;
	}
	TEST_BLOCK_EXCEPTION_HANDLER
	{
		if(!bSilent)
			SHOW_DEBUG_FAILURE_MESSAGE;

		return CLNT_ERR_OTHER;
	}
	TEST_BLOCK_END
	KFC_OUTER_BLOCK_END

	return 0; // for no warning
}