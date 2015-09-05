#include "kfc_common_pch.h"
#include "rpc_message_registerer.h"

#include <KFC_KTL\win_inc.h>

// -----------------------
// RPC message registerer
// -----------------------
TRPCMessageRegisterer::TRPCMessageRegisterer()
{
	m_szMessage = UINT_MAX;
}

void TRPCMessageRegisterer::Allocate(LPCTSTR pName)
{
	DEBUG_VERIFY(pName);

	DEBUG_VERIFY(IsEmpty() || m_Name == pName);

	if(IsEmpty())
	{
		m_Name = pName;

		m_szMessage = RegisterWindowMessage(pName);
			
		if(m_szMessage == 0)
		{
			m_szMessage = UINT_MAX;

			INITIATE_DEFINED_CODE_FAILURE(	(KString)TEXT("Error registering window message \"") +
												pName +
												TEXT("\""),
											GetLastError());
		}
	}
}

size_t TRPCMessageRegisterer::GetMessage() const
{
	DEBUG_VERIFY_ALLOCATION;

	return m_szMessage;
}
