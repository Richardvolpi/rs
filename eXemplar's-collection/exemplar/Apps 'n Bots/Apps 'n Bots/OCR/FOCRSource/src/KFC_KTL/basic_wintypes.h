#ifndef basic_wintypes_h
#define basic_wintypes_h

#include "win_inc.h"

#ifndef __AFX_H__
#include <mmreg.h>
#endif // __AFX_H

#include <tchar.h>
#include <ctype.h>

// Casts
#define LONG_REF_CAST(Value)	(*(LONG*)(&(Value)))

// -------------------------
// Basic wintypes streaming
// -------------------------
DECLARE_BASIC_STREAMING(FILETIME);
DECLARE_BASIC_STREAMING(SYSTEMTIME);

#endif // basic_wintypes_h
