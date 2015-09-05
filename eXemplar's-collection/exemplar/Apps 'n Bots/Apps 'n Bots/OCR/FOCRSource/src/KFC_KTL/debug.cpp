#include "kfc_ktl_pch.h"
#include "debug.h"

// -------
// Consts
// -------
#ifdef _DEBUG
	const bool g_bDebug = true;
#else //_DEBUG
	const bool g_bDebug = false;
#endif // _DEBUG

#ifdef _DEVELOP
	const bool g_bDevelop = true;
#else //_DEVELOP
	const bool g_bDevelop = false;
#endif // _DEVELOP

// ------------
// Thread name
// ------------
__declspec(thread) TCHAR g_ThreadName[1024] = TEXT("");

// ----------------------
// Debug failure message
// ----------------------
static __declspec(thread) KString* _g_pDebugFailureMessage = NULL;

static __declspec(thread) size_t g_szOuterBlockDepth = 0;

KString* GetDebugFailureMessage()
{
	return _g_pDebugFailureMessage;
}

// ------------------
// Outer block guard
// ------------------
TOuterBlockGuard::TOuterBlockGuard()
{
	if(g_szOuterBlockDepth++ == 0)
	{
		if(_g_pDebugFailureMessage == NULL)
			_g_pDebugFailureMessage = new KString;
	}
}

TOuterBlockGuard::~TOuterBlockGuard()
{
	if(g_szOuterBlockDepth == 0 || --g_szOuterBlockDepth == 0)
	{
		if(_g_pDebugFailureMessage)
			delete _g_pDebugFailureMessage, _g_pDebugFailureMessage = NULL;
	}
}