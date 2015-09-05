#ifndef array_h
#define array_h

#include "basic_types.h"

// C array defs
#define ARRAY_SIZE(Arr)		(sizeof(Arr) / sizeof((Arr)[0]))

// ----------------
// Array streaming
// ----------------
#define DECLARE_ARRAY_STREAMING(Type, szAllocationDelta)				\
	inline TStream& operator >> (TStream& Stream, Type& RArray)			\
	{																	\
		size_t szN;														\
		Stream >> szN;													\
																		\
		RArray.Allocate(TArrayAllocation(szN, szAllocationDelta));		\
		RArray.Add(szN);												\
																		\
		RArray.ReadItems(Stream);										\
																		\
		return Stream;													\
	}																	\
																		\
	inline TStream& operator << (TStream& Stream, const Type& Array)	\
	{																	\
		Stream << Array.GetN();											\
																		\
		Array.WriteItems(Stream);										\
																		\
		return Stream;													\
	}																	\

// -----------------------------
// Preallocated array streaming
// -----------------------------
#define DECLARE_PREALLOCATED_ARRAY_STREAMING(Type)						\
	inline TStream& operator >> (TStream& Stream, Type& RArray)			\
	{																	\
		RArray.Clear();													\
																		\
		size_t szN;														\
		Stream >> szN;													\
																		\
		RArray.Add(szN);												\
																		\
		RArray.ReadItems(Stream);										\
																		\
		return Stream;													\
	}																	\
																		\
	inline TStream& operator << (TStream& Stream, const Type& Array)	\
	{																	\
		Stream << Array.GetN();											\
																		\
		Array.WriteItems(Stream);										\
																		\
		return Stream;													\
	}																	\

// -----------------
// Array allocation
// -----------------
struct TArrayAllocation
{
	size_t m_szStart;
	size_t m_szDelta;


	TArrayAllocation() { Invalidate(); }

	TArrayAllocation(size_t szSStart) :
		m_szStart(szSStart), m_szDelta(0) {}

	TArrayAllocation(size_t szSStart, size_t szSDelta) :
		m_szStart(szSStart), m_szDelta(szSDelta) {}

	bool IsValid() const { return m_szStart != UINT_MAX && m_szDelta != UINT_MAX; }

	void Invalidate()
	{
		m_szStart = UINT_MAX;
		m_szDelta = UINT_MAX;
	}

	void Set(size_t szSStart)
	{
		m_szStart = szSStart;
		m_szDelta = 0;
	}

	void Set(size_t szSStart, size_t szSDelta)
	{
		m_szStart = szSStart;
		m_szDelta = szSDelta;
	}

	bool IsFixed() const { return m_szDelta == 0; }
};

#endif // array_h
