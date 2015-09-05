#ifndef stream_h
#define stream_h

#include "kfc_ktl_api.h"

// ----------------------------------
// Stream read/write variable macros
// ----------------------------------
#define STREAM_READ_VAR(Stream, Var)	{ (Stream).StreamRead	(&(Var), sizeof(Var)); }
#define STREAM_WRITE_VAR(Stream, Var)	{ (Stream).StreamWrite	(&(Var), sizeof(Var)); }

// -------------------------------
// Stream read/write array macros
// -------------------------------
#define STREAM_READ_ARR(Stream, Arr, NumItems, ItemType)	{ (Stream).StreamRead	((Arr), (NumItems) * sizeof(ItemType)); }
#define STREAM_WRITE_ARR(Stream, Arr, NumItems, ItemType)	{ (Stream).StreamWrite	((Arr), (NumItems) * sizeof(ItemType)); }

// ----------------------------
// Basic streaming declaration
// ----------------------------
#define DECLARE_BASIC_STREAMING(Type)							\
	inline TStream& operator >> (TStream& Stream, Type& RValue)	\
	{															\
		STREAM_READ_VAR(Stream, RValue);						\
		return Stream;											\
	}															\
																\
	inline TStream& operator << (TStream& Stream, Type Value)	\
	{															\
		STREAM_WRITE_VAR(Stream, Value);						\
		return Stream;											\
	}															\

// ----------------------
// Streaming declaration
// ----------------------
#define DECLARE_STREAMING(Type)										\
	TStream& operator >> (TStream& Stream, Type&		RValue);	\
	TStream& operator << (TStream& Stream, const Type&	Value);		\

// --------------------------
// API streaming declaration
// --------------------------
#define DECLARE_API_STREAMING(API, Type)								\
	API TStream& operator >> (TStream& Stream, Type&		RValue);	\
	API TStream& operator << (TStream& Stream, const Type&	Value);		\

// ---------------------------
// Variable list streaming in
// ---------------------------
#define VARLIST_STREAMING_IN_BEGIN(Type)					\
	TStream& operator >> (TStream& Stream, Type& RValue)	\
	{														\
		TVariableList List;									\
															\
		Stream >> List;										\

#define VARLIST_IN_VAR(Name, DefaultValue, LocalNamePrefix)				\
	READ_VARIABLE(List, Name, DefaultValue, RValue.##LocalNamePrefix);	\

#define VARLIST_STREAMING_IN_END	return Stream; }
		
// ----------------------------
// Variable list streaming out
// ----------------------------
#define VARLIST_STREAMING_OUT_BEGIN(Type)						\
	TStream& operator << (TStream& Stream, const Type& Value)	\
	{															\
		TVariableList List;										\

#define VARLIST_OUT_VAR(Name, LocalNamePrefix)				\
	WRITE_VARIABLE(List, Name, Value##.LocalNamePrefix);	\

#define VARLIST_STREAMING_OUT_END	return Stream << List; }

// --------------------
// Struct streaming in
// --------------------
#define STRUCT_STREAMING_IN_BEGIN(Type)						\
	TStream& operator >> (TStream& Stream, Type& RValue)	\
	{														\
		return Stream										\

#define STRUCT_IN_VAR(Name)		>> RValue.Name

#define STRUCT_STREAMING_IN_END		;}

// ---------------------
// Struct streaming out
// ---------------------
#define STRUCT_STREAMING_OUT_BEGIN(Type)						\
	TStream& operator << (TStream& Stream, const Type& Value)	\
	{															\
		return Stream											\

#define STRUCT_OUT_VAR(Name)	<< Value.Name

#define STRUCT_STREAMING_OUT_END	;}

// -------
// Stream
// -------
class KFC_KTL_API TStream
{
public:
	virtual ~TStream() {}

	virtual void StreamRead	(void*			pRData,	size_t szLength) = 0;
	virtual void StreamWrite(const void*	pData,	size_t szLength) = 0;
};

#endif // stream_h