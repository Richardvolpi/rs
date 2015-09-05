#ifndef rpc_message_registerer_h
#define rpc_message_registerer_h

#include <KFC_KTL\basic_types.h>
#include <KFC_KTL\basic_wintypes.h>
#include "kfc_common_api.h"

// -----------------------
// RPC message registerer
// -----------------------
class KFC_COMMON_API TRPCMessageRegisterer
{
private:
	KString m_Name;

	size_t m_szMessage;

public:
	TRPCMessageRegisterer();

	bool IsEmpty() const { return m_szMessage == UINT_MAX; }

	void Allocate(LPCTSTR pName);
	
	size_t GetMessage() const;

	operator size_t () const { return GetMessage(); }
};

#endif // rpc_message_registerer_h
