#include "server_pch.h"
#include "server_device_globals.h"

#include <KFC_Common\startup_globals.h>
#include <KFC_Common\structured_info.h>
#include <KFC_Common\pow2.h>
#include <KFC_Common\module_resource.h>
#include <KFC_Common\memory_stream.h>
#include <common\comdefs.h>
#include "url.h"
#include "http_socket.h"
#include "ocr.h"
#include "comdefs.h"

#include "resource.h"

TServerDeviceGlobals g_ServerDeviceGlobals;

// ----------------------
// Server device globals
// ----------------------
TServerDeviceGlobals::TServerDeviceGlobals() : TGlobals(TEXT("Server globals"))
{
	m_szTCPPort = 0;

	m_szSocketDelay = INFINITE;

	m_pSSLContext = NULL;
}

void TServerDeviceGlobals::OnUninitialize()
{
	// OCR
	{
		m_OCR_DLL.Release();
	}

	// Cypher
	{
		m_CertKey.Release();

		m_ServerKey.Release();
	}

	// SSL
	{
		if(m_pSSLContext)
			SSL_CTX_free(m_pSSLContext), m_pSSLContext = NULL;
	}
}

void TServerDeviceGlobals::OnInitialize()
{
	// SSL
	{
		SSL_load_error_strings();

		SSL_library_init();

		srand(time(0));

		m_pSSLContext = SSL_CTX_new(SSLv23_client_method());

		if(m_pSSLContext == NULL)
			INITIATE_DEFINED_FAILURE(TEXT("Error creating SSL context."));
	}

	// Cfg
	{
		TStructuredInfo Info(CFG_FILENAME);

		// Networking
		{
			TInfoNodeConstIterator Node =
				Info.GetNode(Info.GetRootNode(), TEXT("Networking"));

			ReadUINT(	Node->GetParameterValue(TEXT("Port")),
						m_szTCPPort,
						TEXT("network port"));

			ReadUINT(	Node->GetParameterValue(TEXT("SocketDelay")),
						m_szSocketDelay,
						TEXT("socket delay"));
		}

		// Authentication
		{
			TInfoNodeConstIterator Node =
				Info.GetNode(Info.GetRootNode(), TEXT("Authentication"));

			m_AuthURL = Node->GetParameterValue(TEXT("AuthURL"));
			
			m_PostReplyURL = Node->GetParameterValue(TEXT("PostReplyURL"));

			m_AuthResultString = Node->GetParameterValue(TEXT("AuthResultString"));

			KString Protocol, Address, Resource;

			SplitURL(m_AuthURL, Protocol, Address, Resource);

			if(!IsSupportedHTTPProtocol(Protocol))
				INITIATE_DEFINED_FAILURE(TEXT("Unsupported authorization URL protocol."));

			SplitURL(m_PostReplyURL, Protocol, Address, Resource);

			if(!IsSupportedHTTPProtocol(Protocol))
				INITIATE_DEFINED_FAILURE(TEXT("Unsupported post-reply URL protocol."));
		}
	}

	// Cypher
	{
		m_ServerKey.Generate(RSA_KEY_LENGTH);

		TModuleResource Resource(	GetKModuleHandle(),
									RT_RCDATA,
									MAKEINTRESOURCE(IDR_DATA1));

		TMemoryStream Stream(TArrayAllocation(1024, 1024));

		Stream.StreamWrite(Resource.GetDataPtr(), Resource.GetSize());

		m_CertKey.LoadAll(Stream);
	}

	// OCR
	{
		// Loading DLL
		m_OCR_DLL.Allocate(g_StartUpGlobals.m_StartFolder + OCR_DLL_FILENAME);

		// Getting functions
		g_pLoadDictionary =
			(TLoadDictionary*)m_OCR_DLL.GetFunction("loadDictionary");

		g_pLoadModel =
			(TLoadModel*)m_OCR_DLL.GetFunction("loadModel");

		g_pGetString =
			(TGetString*)m_OCR_DLL.GetFunction("getString");

		// Initializing library
		g_pLoadDictionary(g_StartUpGlobals.m_StartFolder + "dict.txt");

		g_pLoadModel(g_StartUpGlobals.m_StartFolder + "model.txt");
	}
}