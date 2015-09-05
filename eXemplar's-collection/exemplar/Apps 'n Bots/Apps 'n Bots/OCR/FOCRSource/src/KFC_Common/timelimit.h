#ifndef timelimit_h
#define timelimit_h

#include "kfc_common_api.h"

// -----------------
// Timelimit result
// -----------------
enum TTimeLimitResult
{
	TR_OK			= 1,
	TR_EXPIRED		= 2,
	TR_PRE_HACK		= 3,
	TR_POST_HACK	= 4,
	TR_FORCE_UINT	= UINT_MAX,
};

// ----------------
// Global routines
// ----------------
KFC_COMMON_API TTimeLimitResult GetTimeLimitResult(QWORD qwExpirationPeriod);

#endif // timelimit_h