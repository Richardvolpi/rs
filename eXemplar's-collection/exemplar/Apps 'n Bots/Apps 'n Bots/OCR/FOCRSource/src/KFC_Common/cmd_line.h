#ifndef cmd_line_h
#define cmd_line_h

#include "kfc_common_api.h"

// ----------------
// Global routines
// ----------------
KFC_COMMON_API void ParseCmdLine(	LPCTSTR		pCmdLine,
									KStrings&	RTokens,
									bool		bClearFirst = true);

#endif //cmd_line_h