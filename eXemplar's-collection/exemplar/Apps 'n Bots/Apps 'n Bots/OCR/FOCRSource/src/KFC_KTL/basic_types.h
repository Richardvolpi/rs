#ifndef basic_types_h
#define basic_types_h

#include <stddef.h>
#include <limits.h>
#include <math.h>
#include "basic_wintypes.h"
#include "stream.h"

// Own limits
#define BYTE_MAX	((BYTE)	0xFF)
#define WORD_MAX	((WORD)	0xFFFF)
#define DWORD_MAX	((DWORD)0xFFFFFFFF)
#define QWORD_MAX	((QWORD)0xFFFFFFFFFFFFFFFF)

// Thresholds
#define FLOAT_THRESHOLD		(1e-4)
#define DOUBLE_THRESHOLD	(1e-8)

// Equality operator speed defs
#define IMPLEMENT_INEQUALITY(Type)			\
	bool operator != (const Type& Value)	\
	{										\
		return !(*this == Value);			\
	}										\

// MakeAbs speed-defs
#define DECLARE_SIGNED_MAKEABS(Type)	\
	inline Type& MakeAbs(Type& Value)	\
	{									\
		if(Value < 0)					\
			Value = -Value;				\
										\
		return Value;					\
	}									\

#define DECLARE_UNSIGNED_MAKEABS(Type)	\
	inline Type& MakeAbs(Type& Value)	\
	{									\
		return Value;					\
	}									\

// Round-up speed-defs
#define DECLARE_INTEGER_ROUNDUP(Type)	\
	inline Type& RoundUp(Type& Value)	\
	{									\
		return Value;					\
	}									\

// -----------
// QWORD type
// -----------
typedef unsigned __int64 QWORD;

// ----------
// Size type
// ----------
#define SIZE_T_PTR_IN(Size,		Type)	((Type*)&(Size))
#define SIZE_T_PTR_OUT(Size,	Type)	((Size) = 0, (Type*)&(Size))
#define SIZE_T_PTR_INOUT(Size,	Type)	((Type*)&(Size))

// -----------
// Flags type
// -----------
typedef unsigned int flags_t;

#define FLAGS_T_PTR_IN(Flags,		Type)	((Type*)&(Flags))
#define FLAGS_T_PTR_OUT(Flags,		Type)	((Flags) = 0, (Type*)&(Flags))
#define FLAGS_T_PTR_INOUT(Flags,	Type)	((Type*)&(Flags))

// ----------
// Type type
// ----------
typedef unsigned int type_t;

#define TYPE_T_PTR_IN(Type,		TType)	((TType*)&(Type))
#define TYPE_T_PTR_OUT(Type,	TType)	((Type) = 0, (TType*)&(Type))
#define TYPE_T_PTR_INOUT(Type,	TType)	((TType*)&(Type))

// ----------
// Mode type
// ----------
typedef unsigned int mode_t;

#define MODE_T_PTR_IN(Mode,		TType)	((TType*)&(Mode))
#define MODE_T_PTR_OUT(Mode,	TType)	((Mode) = 0, (TType*)&(Mode))
#define MODE_T_PTR_INOUT(Mode,	TType)	((TType*)&(Mode))

// ------------------------
// Global service routines
// ------------------------
inline bool ToggleBool(bool& bValue)
{
	return bValue = !bValue;
}

// ---------------------------
// Global comparison routines
// ---------------------------
inline int Compare(__int64 iValue1, __int64 iValue2)
{
	return iValue1 == iValue2 ? 0 : (iValue1 < iValue2 ? -1 : 1);
}

inline int Compare(int iValue1, int iValue2)
{
	return iValue1 == iValue2 ? 0 : (iValue1 < iValue2 ? -1 : 1);
}

inline int Compare(QWORD qwValue1, QWORD qwValue2)
{
	return qwValue1 == qwValue2 ? 0 : (qwValue1 < qwValue2 ? -1 : 1);
}

inline int Compare(UINT uiValue1, UINT uiValue2)
{
	return uiValue1 == uiValue2 ? 0 : (uiValue1 < uiValue2 ? -1 : 1);
}

inline int Compare(float fValue1, float fValue2)
{
	return fabsf(fValue1 - fValue2) < FLOAT_THRESHOLD ? 0 : (fValue1 < fValue2 ? -1 : 1);
}

inline int Compare(double dValue1, double dValue2)
{
	return fabs(dValue1 - dValue2) < DOUBLE_THRESHOLD ? 0 : (dValue1 < dValue2 ? -1 : 1);
}

inline int Compare(TCHAR cChar1, TCHAR cChar2)
{
	return cChar1 == cChar2 ? 0 : (cChar1 < cChar2 ? -1 : 1);
}

inline int Compare(bool bValue1, bool bValue2)
{
	return bValue1 ? (bValue2 ? 0 : -1) : (bValue2 ? 1 : 0);
}

inline int Compare(BYTE bValue1, BYTE bValue2)
{
	return bValue1 == bValue2 ? 0 : (bValue1 < bValue2 ? -1 : 1);
}

inline int Compare(const FILETIME& ftValue1, const FILETIME& ftValue2)
{
	const int v = CompareFileTime(&ftValue1, &ftValue2);

	return v == 0 ? 0 : v < 0 ? -1 : 1;
}

// ---------------------
// Global sign routines
// ---------------------
template <class t>
inline int Sign(const t& Value)
{
	return Compare(Value, 0);
}

template <class t>
inline int Sign1(const t& Value)
{
	const int iCmp = Compare(Value, (t)0);
	return iCmp ? iCmp : 1;
}

template <class t>
inline t SignDir(const t& Value, const t& Direction)
{
	return Value * (t)Sign(Direction);
}

template <class t>
inline t Sign1Dir(const t& Value, const t& Direction)
{
	return Value * (t)Sign1(Direction);
}

// --------------------
// Global abs routines
// --------------------
DECLARE_SIGNED_MAKEABS(__int64);
DECLARE_SIGNED_MAKEABS(long);
DECLARE_SIGNED_MAKEABS(int);
DECLARE_SIGNED_MAKEABS(short);
DECLARE_SIGNED_MAKEABS(char);

DECLARE_UNSIGNED_MAKEABS(unsigned __int64);
DECLARE_UNSIGNED_MAKEABS(unsigned long);
DECLARE_UNSIGNED_MAKEABS(unsigned int);
DECLARE_UNSIGNED_MAKEABS(unsigned short);
DECLARE_UNSIGNED_MAKEABS(unsigned char);

DECLARE_SIGNED_MAKEABS(float);
DECLARE_SIGNED_MAKEABS(double);

template <class t>
inline t GetAbs(const t& Value)
{
	return MakeAbs(t(Value));
}

// -------------------------
// Global round-up routines
// -------------------------
DECLARE_INTEGER_ROUNDUP(__int64);
DECLARE_INTEGER_ROUNDUP(long);
DECLARE_INTEGER_ROUNDUP(int);
DECLARE_INTEGER_ROUNDUP(short);
DECLARE_INTEGER_ROUNDUP(char);

DECLARE_INTEGER_ROUNDUP(unsigned __int64);
DECLARE_INTEGER_ROUNDUP(unsigned long);
DECLARE_INTEGER_ROUNDUP(unsigned int);
DECLARE_INTEGER_ROUNDUP(unsigned short);
DECLARE_INTEGER_ROUNDUP(unsigned char);

inline float& RoundUp(float& fValue)
{
	return fValue = floorf(fValue + 0.5f);
}

inline double& RoundUp(double& dValue)
{
	return dValue = floor(dValue + 0.5);
}

template <class t>
inline t GetRounded(const t& Value)
{
	return RoundUp(t(Value));
}

// ----------------------------
// Global bind-to-int routines
// ----------------------------
template <class t>
t& BindToInt(t& Value)
{
	const t Rounded = GetRounded(Value);
	if(Compare(Value, Rounded) == 0)
		Value = Rounded;

	return Value;
}

template <class t>
t GetBindedToInt(const t& Value)
{
	return BindToInt(t(Value));
}

// ---------------------------------------------
// Global min/max functions (up to 4 arguments)
// ---------------------------------------------
template <class t>
inline t Min(t a, t b)
{
	return Compare(a, b) <= 0 ? a : b;
}

template <class t>
inline t Min(t a, t b, t c)
{
	return Min(Min(a, b), c);
}

template <class t>
inline t Min(t a, t b, t c, t d)
{
	return Min(Min(Min(a, b), c), d);
}

template <class t>
inline t Max(t a, t b)
{
	return Compare(a, b) >= 0 ? a : b;
}

template <class t>
inline t Max(t a, t b, t c)
{
	return Max(Max(a, b), c);
}

template <class t>
inline t Max(t a, t b, t c, t d)
{
	return Max(Max(Max(a, b), c), d);
}

// ----------------------
// Basic types streaming
// ----------------------
DECLARE_BASIC_STREAMING(__int64);
DECLARE_BASIC_STREAMING(long);
DECLARE_BASIC_STREAMING(int);
DECLARE_BASIC_STREAMING(short)
DECLARE_BASIC_STREAMING(char);

DECLARE_BASIC_STREAMING(unsigned __int64);
DECLARE_BASIC_STREAMING(unsigned long);
DECLARE_BASIC_STREAMING(unsigned int);
DECLARE_BASIC_STREAMING(unsigned short)
DECLARE_BASIC_STREAMING(unsigned char);

DECLARE_BASIC_STREAMING(double);
DECLARE_BASIC_STREAMING(float);

DECLARE_BASIC_STREAMING(bool);

#endif // basic_types_h
