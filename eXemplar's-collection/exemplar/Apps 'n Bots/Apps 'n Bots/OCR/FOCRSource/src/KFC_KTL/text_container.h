#ifndef text_container_h
#define text_container_h

#include "kfc_ktl_api.h"

class KString;

// ---------------
// Text container
// ---------------
class KFC_KTL_API TTextContainer
{
public:
	virtual KString GetText(bool* pRSuccess = NULL) const = 0;

	virtual bool SetText(const KString& Text) = 0;
};

#endif // text_container_h