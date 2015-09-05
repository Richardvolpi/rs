#include "server_pch.h"
#include "process.h"

#include <KFC_Common\com.h>
#include <KFC_Common\memory_stream.h>
#include <KFC_Common\process.h>
#include <KFC_Networking\socket.h>
#include "server_device_globals.h"
#include <common\comdefs.h>
#include "authentication.h"
#include "ocr.h"

// -------------------
// Worker thread proc
// -------------------
UINT __stdcall WorkerThreadProc(void* pParam)
{
	KFC_OUTER_BLOCK_BEGIN
	SAFE_BLOCK_BEGIN
	{
		TCOMInitializer Initialier0;

		TRSAKey& ServerKey = g_ServerDeviceGlobals.m_ServerKey;

		TSocket DataSocket;
		TRSAKey ClientKey;

		// Initialization
		{		
			DataSocket.Allocate((SOCKET)pParam);
			
			DataSocket.m_szDelay = g_ServerDeviceGlobals.m_szSocketDelay;
		}

		// Handshake
		{
			TMemoryStream Stream(TArrayAllocation(1024, 1024));

			// Public key
			ServerKey.SavePublic(Stream);

			// Sending own public key
			DataSocket.Send(Stream.GetDataPtr(), Stream.GetN());

			// Signing own public key
			TRSABuffer Buffer;

			memcpy(&Buffer.Add(Stream.GetN()), Stream.GetDataPtr(), Stream.GetN());

			// Sending signed certificate
			g_ServerDeviceGlobals.m_CertKey.EncryptPrivate(Buffer, DataSocket);

			// Receiving client public key
			ClientKey.LoadPublic(DataSocket);
		}

		// Data exchange
		{
			KString Login, Password, IP;

			TValueArray<BYTE, true>	ImageBuffer;

			// Login/password
			{
				TMemoryStream InStream(TArrayAllocation(1024, 1024));

				{
					TRSABuffer RSABuffer;

					ServerKey.DecryptPrivate(DataSocket, RSABuffer);

					InStream.StreamWrite(RSABuffer.GetDataPtr(), RSABuffer.GetN());
				}

				// Retrieving login, password and image
				InStream >> Login >> Password >> IP;
			}

			// Authentication
			if(!Authenticate(Login, Password, IP))
				return 0;

			// Image
			{
				TMemoryStream InStream(TArrayAllocation(1024, 1024));

				TLinearKey ImageKey;

				// Receiving image linear key
				{
					TRSABuffer RSABuffer;

					ServerKey.DecryptPrivate(DataSocket, RSABuffer);

					TMemoryStream Stream(TArrayAllocation(1024, 1024));

					Stream.StreamWrite(RSABuffer.GetDataPtr(), RSABuffer.GetN());

					ImageKey.Load(Stream);
				}

				// Receiving linear encryption of the image
				{
					TRSABuffer RSABuffer;

					ImageKey.Decrypt(DataSocket, RSABuffer);

					InStream.StreamWrite(RSABuffer.GetDataPtr(), RSABuffer.GetN());
				}

				// Reading image file
				{
					size_t szFileLength;

					InStream >> szFileLength;

					InStream.StreamRead(&ImageBuffer.AllocateAdd(szFileLength), szFileLength);
				}
			}

			// OCR
			const KString OCRResult = GetOCRResult(ImageBuffer);
			
			// Replying
			TMemoryStream OutStream(TArrayAllocation(1024, 1024));

			OutStream << OCRResult;

			{
				TRSABuffer RSABuffer;

				memcpy(&RSABuffer.Add(OutStream.GetN()), OutStream.GetDataPtr(), OutStream.GetN());

				ClientKey.EncryptPublic(RSABuffer, DataSocket);
			}

			// Post-reply
			PostReply(Login, Password, IP);
		}
	}
	SAFE_BLOCK_END
	KFC_OUTER_BLOCK_END

	return 0;
}

// -----------------
// Main thread proc
// -----------------
UINT __stdcall MainThreadProc(void* pParam)
{
	KFC_OUTER_BLOCK_BEGIN
	{
		TSocket ListenerSocket;

		ListenerSocket.Allocate();

		ListenerSocket.Bind(TIPSocketAddress(0, g_ServerDeviceGlobals.m_szTCPPort));

		ListenerSocket.Listen();

		for(;;)
		{
			TSocket DataSocket;

			ListenerSocket.Accept(DataSocket);

			CloseHandle(StartThread(WorkerThreadProc, (void*)(SOCKET)DataSocket));

			DataSocket.Invalidate();
		}
	}
	KFC_OUTER_BLOCK_END

	return 0;
}

// ----------------
// Global routines
// ----------------
void RunMainThread()
{
	const HANDLE hMainThread = StartThread(MainThreadProc, NULL);

	DEBUG_EVALUATE_VERIFY(WaitForSingleObject(hMainThread, INFINITE) == WAIT_OBJECT_0);

	CloseHandle(hMainThread);
}