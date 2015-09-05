#ifndef debug_h
#define debug_h

#include "kfc_ktl_api.h"
#include "kstring.h"
#include "debug_message_box.h"

// -------
// Consts
// -------
extern KFC_KTL_API const bool g_bDebug;
extern KFC_KTL_API const bool g_bDevelop;

// ------------
// Thread name
// ------------
extern __declspec(thread) TCHAR g_ThreadName[1024];

// ----------------------
// Debug failure message
// ----------------------
KFC_KTL_API KString* GetDebugFailureMessage();

#define g_pDebugFailureMessage	(GetDebugFailureMessage())

#define EMPTY_DEBUG_FAILURE_MESSAGE				\
	do											\
	{											\
		if(g_pDebugFailureMessage)				\
			g_pDebugFailureMessage->Empty();	\
												\
	}while(false)								\

// ------------------
// Outer block guard
// ------------------
class KFC_KTL_API TOuterBlockGuard
{
public:
	TOuterBlockGuard();

	~TOuterBlockGuard();
};

// -----------
// Test block
// -----------
#define TEST_BLOCK_BEGIN				try { { EMPTY_DEBUG_FAILURE_MESSAGE; }
#define TEST_BLOCK_EXCEPTION_HANDLER	} catch(...) {
#define TEST_BLOCK_END					{ EMPTY_DEBUG_FAILURE_MESSAGE; } }

// -----------
// Safe block
// -----------
#define SAFE_BLOCK_BEGIN	\
	TEST_BLOCK_BEGIN		\
	{						\

#define SAFE_BLOCK_END					\
	}									\
	TEST_BLOCK_EXCEPTION_HANDLER		\
	{									\
		EMPTY_DEBUG_FAILURE_MESSAGE;	\
	}									\
	TEST_BLOCK_END						\

// -------------------
// Release safe block
// -------------------
#ifdef _DEBUG

	#define RELEASE_SAFE_BLOCK_BEGIN	{
	#define RELEASE_SAFE_BLOCK_END		}

#else // _DEBUG

	#define RELEASE_SAFE_BLOCK_BEGIN	SAFE_BLOCK_BEGIN
	#define RELEASE_SAFE_BLOCK_END		SAFE_BLOCK_END

#endif // _DEBUG

// ---------------------------
// Defined failure initiation
// ---------------------------
#define UPDATE_DEFINED_FAILURE(Text)						\
	do														\
	{														\
		if(g_pDebugFailureMessage)							\
		{													\
			if(!g_pDebugFailureMessage->IsEmpty())			\
				*g_pDebugFailureMessage += TEXT("\r\n");	\
															\
			*g_pDebugFailureMessage += (Text);				\
		}													\
															\
	}while(false)											\

#define INITIATE_DEFINED_FAILURE(Text)						\
	do														\
	{														\
		UPDATE_DEFINED_FAILURE(Text);						\
															\
		throw 1;											\
															\
	}while(false)											\

// --------------------------------
// Defined code failure initiation
// --------------------------------
#define INITIATE_DEFINED_CODE_FAILURE(Text, Code)																	\
	INITIATE_DEFINED_FAILURE((KString)(Text) + KString::Formatted(TEXT(" (error code: 0x%.8X)."), (size_t)(Code)));	\

// -------------------
// Failure initiation
// -------------------
#define INITIATE_FAILURE																							\
	INITIATE_DEFINED_FAILURE((KString)TEXT("Failure condition at: ") + TEXT(__FILE__) + TEXT(" , ") + __LINE__);	\

// --------
// KFC NOP
// --------
#define KFC_NOP do {} while(false)

// -----------------
// KFC verification
// -----------------
#define KFC_VERIFY(v)																											\
	do																															\
	{																															\
		if(!(v))																												\
			INITIATE_DEFINED_FAILURE((KString)TEXT("KFC verification failed at: ") + TEXT(__FILE__) + TEXT(" , ") + __LINE__);	\
																																\
	}while(false)																												\

// -------------------
// Debug verification
// -------------------
#ifdef _DEBUG

	#define DEBUG_VERIFY(v)		KFC_VERIFY(v)

#else // _DEBUG

	#define DEBUG_VERIFY(v)		KFC_NOP

#endif // _DEBUG

// -----------------------
// Evaluated verification
// -----------------------
#ifdef _DEBUG
		
	#define DEBUG_EVALUATE_VERIFY(v)	DEBUG_VERIFY(v)

#else //_DEBUG

	#define DEBUG_EVALUATE_VERIFY(v)	(v)

#endif // _DEBUG

// ----------------------------
// Initialization verification
// ----------------------------
#ifdef _DEBUG

	#define DEBUG_VERIFY_INITIALIZATION																								\
		do																															\
		{																															\
			if(!IsInitialized())																									\
				INITIATE_DEFINED_FAILURE((KString)TEXT("Globals are not initialized: ") + TEXT(__FILE__) + TEXT(" , ") + __LINE__);	\
																																	\
		}while(false)																												\

#else // _DEBUG
	
	#define DEBUG_VERIFY_INITIALIZATION

#endif // _DEBUG

// ------------------------
// Allocation verification
// ------------------------
#ifdef _DEBUG

	#define DEBUG_VERIFY_ALLOCATION																						\
		do																												\
		{																												\
			if(IsEmpty())																								\
				INITIATE_DEFINED_FAILURE((KString)TEXT("Object is empty: ") + TEXT(__FILE__) + TEXT(" , ") + __LINE__);	\
																														\
		}while(false)																									\

#else // _DEBUG
	
	#define DEBUG_VERIFY_ALLOCATION

#endif // _DEBUG

// ------------------------------
// Access validness verification
// ------------------------------
#ifdef _DEBUG

	#define DEBUG_VERIFY_VALIDNESS(TypeName)																			\
		do{																												\
			if(!IsValid())																								\
			{																											\
				INITIATE_DEFINED_FAILURE((KString)TEXT("Access to an object via invalid ") + (TypeName) + TEXT("."));	\
			}																											\
																														\
		}while(false)																									\

#else // _DEBUG

	#define DEBUG_VERIFY_VALIDNESS(TypeName)

#endif // _DEBUG

// --------------------
// Current thread name
// --------------------
inline KString GetCurrentThreadName()
{
	if(g_ThreadName[0])
		return g_ThreadName;

	return KString::Formatted(TEXT("ThreadID: %u"), GetCurrentThreadId());
}

// ---------------------
// Show failure message
// ---------------------
#ifdef _DEBUG

	#define SHOW_FAILURE_MESSAGE(Text)															\
		do																						\
		{																						\
			{																					\
				TDebugFileLocker Locker0;														\
																								\
				g_DebugFile <<	DFCC_EOL <<														\
								TEXT("-------- FAILURE MESSAGE (") <<							\
									GetCurrentThreadName() <<									\
								TEXT(") --------") <<											\
								DFCC_EOL;														\
																								\
				g_DebugFile << ((KString)Text).RNToN() << DFCC_EOL;								\
																								\
				g_DebugFile << TEXT("-------- END OF FAILURE MESSAGE --------") << DFCC_EOL;	\
			}																					\
																								\
			::DebugMessageBox(	(KString)TEXT("Error (") +										\
									GetCurrentThreadName() +									\
									TEXT(")"),													\
								(Text));														\
																								\
		}while(false)																			\

#else // _DEBUG

	#define SHOW_FAILURE_MESSAGE(Text)									\
		do																\
		{																\
			::DebugMessageBox(	(KString)TEXT("Error (") +				\
									GetCurrentThreadName() +			\
									TEXT(")"),							\
								(Text));								\
																		\
		}while(false)													\

#endif // _DEBUG

// ---------------------------
// Show debug failure message
// ---------------------------
#define SHOW_DEBUG_FAILURE_MESSAGE																		\
	do																									\
	{																									\
		if(g_pDebugFailureMessage)																		\
		{																								\
			if(g_pDebugFailureMessage->IsEmpty())														\
				UPDATE_DEFINED_FAILURE(TEXT("Unhandled exception detected."));							\
																										\
			SHOW_FAILURE_MESSAGE(*g_pDebugFailureMessage);												\
																										\
			g_pDebugFailureMessage->Empty();															\
		}																								\
		else																							\
		{																								\
			SHOW_FAILURE_MESSAGE(TEXT("Unknown error (debug subsytem was not allocated properly)."));	\
		}																								\
																										\
	}while(false)																						\

// ---------------------
// Globals failure text
// ---------------------
#define GLOBALS_FAILURE_TEXT(Text)																	\
	((KString)TEXT("\"") + (m_Name) + TEXT("\" (RefCount = ") + m_szRefCount + TEXT(") ") + (Text))	\

// ------------------------------
// Report incorrect value format
// ------------------------------
#define REPORT_INCORRECT_VALUE_FORMAT																					\
	INITIATE_DEFINED_FAILURE((KString)TEXT("Incorrect ") + pValueName + TEXT(" format (\"") + String + TEXT("\")."))	\

// ---------------------
// Report invalid value
// ---------------------
#define REPORT_INVALID_VALUE																				\
	INITIATE_DEFINED_FAILURE((KString)TEXT("Invalid ") + pValueName + TEXT(" (\"") + String + TEXT("\")."))	\

// ------------
// Outer block
// ------------
#define KFC_OUTER_BLOCK_BEGIN			\
	{									\
		TOuterBlockGuard _KFC_Guard0;	\
										\
		TEST_BLOCK_BEGIN				\
		{								\

#define KFC_OUTER_BLOCK_END				\
		}								\
		TEST_BLOCK_EXCEPTION_HANDLER	\
		{								\
			SHOW_DEBUG_FAILURE_MESSAGE;	\
		}								\
		TEST_BLOCK_END					\
	}									\

// ------------------
// Debug outer block
// ------------------
#ifdef _DEBUG
	#define DEBUG_OUTER_BLOCK_BEGIN		KFC_OUTER_BLOCK_BEGIN
	#define DEBUG_OUTER_BLOCK_END		KFC_OUTER_BLOCK_END
#else // _DEBUG
	#define DEBUG_OUTER_BLOCK_BEGIN		{
	#define DEBUG_OUTER_BLOCK_END		}
#endif // _DEBUG

#endif // debug_h
