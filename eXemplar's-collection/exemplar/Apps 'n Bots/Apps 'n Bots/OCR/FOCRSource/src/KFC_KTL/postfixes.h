#ifndef postfixes_h
#define postfixes_h

// ---------------
// Perm postfixes
// ---------------
#define DEBUG_POSTFIX_PERM		TEXT("Debug")
#define RELEASE_POSTFIX_PERM	TEXT("")

#define ANSI_POSTFIX_PERM		TEXT("A")
#define UNICODE_POSTFIX_PERM	TEXT("W")

// --------------
// Debug postfix
// --------------
#ifdef _DEBUG
	#define DEBUG_POSTFIX	DEBUG_POSTFIX_PERM
#else // _DEBUG
	#define DEBUG_POSTFIX	RELEASE_POSTFIX_PERM
#endif // _DEBUG

// ----------------
// Unicode postfix
// ----------------
#ifdef _UNICODE
	#define UNICODE_POSTFIX		UNICODE_POSTFIX_PERM
#else // _UNICODE
	#define UNICODE_POSTFIX		ANSI_POSTFIX_PERM
#endif // _UNICODE

#endif // postfixes_h