#ifndef kfc_ktl_pch_h
#define kfc_ktl_pch_h

#pragma warning( disable : 4251 4275 4284 4786)

#ifdef _DEBUG
	#define _DEVELOP
#endif // _DEBUG

#include <tchar.h>
#include <stddef.h>
#include <stdarg.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <time.h>
#include <process.h>
#include "win_inc.h"
#include "postfixes.h"
#include "data_alignment.h"
#include "kfc_mem.h"
#include "stream.h"
#include "variable_list.h"
#include "placement_allocation.h"
#include "basic_types.h"
#include "basic_bitypes.h"
#include "basic_wintypes.h"
#include "kstring.h"
#include "debug.h"
#include "debug_file.h"
#include "kstrings.h"
#include "string_conv.h"
#include "object_pointer.h"
#include "flag_setter.h"
#include "vmatrix.h"
#include "rects.h"
#include "vlist.h"
#include "plist.h"
#include "vtree.h"
#include "ptree.h"

#include "kfc_ktl_api.h"

#endif // kfc_ktl_pch_h
