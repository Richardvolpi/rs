#ifndef kstring_h
#define kstring_h

#include <stdio.h>
#include <string.h>
#include <tchar.h>
#include "win_inc.h"
#include "kfc_ktl_api.h"
#include "basic_types.h"
#include "alignment.h"
#include "basic_wintypes.h"
#include "varray.h"

// String allocation parameters
#define STRING_ALLOCATION_START		(128)
#define STRING_ALLOCATION_DELTA		(256)

// Alphabet limitations
#define MAX_ALPHABET_RADIX	(10 + 26 + 26) // '0'-'9', 'A'-'Z', 'a'-'z'

// Declarations
class TAnsiString;
class TWideString;

// -------
// String
// -------
class KFC_KTL_API KString
{
private:
	TValueArray<TCHAR, true> m_Chars;
	
public:
	KString() { Empty(); }

	KString(const KString& SString) : m_Chars(SString.m_Chars) {}

	KString(LPCTSTR pStr) { *this = pStr; }

	KString(LPCTSTR pStr,	size_t szLength);
	KString(LPCTSTR pStr1,	size_t szLength1, LPCTSTR pStr2, size_t szLength2);

	KString(TCHAR c, size_t szNRepeats = 1);

	KString(__int64	iValue,		bool bSeparate = false) { WriteInt64(iValue,	bSeparate); }
	KString(QWORD   qwValue,	bool bSeparate = false) { WriteInt64((__int64)qwValue, bSeparate); }
	KString(int		iValue,		bool bSeparate = false) { WriteInt64(iValue,	bSeparate); }
	KString(UINT	uiValue,	bool bSeparate = false) { WriteInt64(uiValue == UINT_MAX ? (__int64)-1 : (__int64)uiValue, bSeparate); }

	KString(float		fValue)	{ *this = fValue;	}
	KString(double		dValue)	{ *this = dValue;	}
	KString(bool		bValue)	{ *this = bValue;	}
	KString(const void*	pPtr)	{ *this = pPtr;		}

	KString(TAlignment Alignment) { *this = Alignment; }

	void Allocate(size_t szLength);

	void Empty() { Allocate(0); }

	size_t GetLength() const { return m_Chars.GetN() - 1; }

	static bool IsSpecChar(TCHAR cChar);
	
	static TCHAR	ValueToAlphabet(size_t	szValue);
	static size_t	AlphabetToValue(TCHAR	cChar);

	size_t GetNoSpecCharactersLength() const;

	bool IsEmpty() const { return GetLength() == 0; }

	void Terminate() { m_Chars[GetLength()] = 0; }

	void Extend(size_t	szLength);
	void Extend(LPCTSTR pSString, size_t szLength);

	KString& WriteInt64(__int64 iValue, bool bSeparate = false);

	KString& Format	(LPCTSTR pFormat, ...);
	KString& FormatV(LPCTSTR pFormat, va_list ArgList);

	static KString Formatted	(LPCTSTR pFormat, ...);
	static KString FormattedV	(LPCTSTR pFormat, va_list ArgList);

	static size_t GetStreamCharsLength		(size_t szLength) { return szLength * sizeof(TCHAR);						}
	static size_t GetStreamTermCharsLength	(size_t szLength) { return GetStreamCharsLength(szLength + 1);				}
	static size_t GetStreamTotalLength		(size_t szLength) { return sizeof(size_t) + GetStreamCharsLength(szLength);	}

	size_t GetStreamCharsLength		() const { return GetStreamCharsLength		(GetLength()); }
	size_t GetStreamTermCharsLength	() const { return GetStreamTermCharsLength	(GetLength()); }
	size_t GetStreamTotalLength		() const { return GetStreamTotalLength		(GetLength()); }

	KString& operator = (const KString&	SString);
	KString& operator = (LPCTSTR		pSString);
	KString& operator = (TCHAR			cChar);
	KString& operator = (__int64		iValue);
	KString& operator = (QWORD			qwValue)	{ return *this = (__int64)qwValue;	}
	KString& operator = (int			iValue)		{ return *this = (__int64)iValue;	}
	KString& operator = (UINT			uiValue)	{ return *this = uiValue == UINT_MAX ? (__int64)-1 : (__int64)uiValue; }
	KString& operator = (float			fValue);
	KString& operator = (double			dValue);
	KString& operator = (bool			bValue);
	KString& operator = (const void*	pPtr);
	KString& operator = (TAlignment		Alignment);

	KString operator + (const KString&	SString)	const;
	KString operator + (LPCTSTR			pSString)	const;
	KString operator + (TCHAR			cChar)		const;
	KString operator + (__int64			iValue)		const;
	KString operator + (QWORD			qwValue)	const { return *this + (__int64)qwValue;	}
	KString operator + (int				iValue)		const { return *this + (__int64)iValue;		}
	KString operator + (UINT			uiValue)	const { return *this + (__int64)(uiValue == UINT_MAX ? (__int64)-1 : (__int64)uiValue); }
	KString operator + (float			fValue)		const;
	KString operator + (double			dValue)		const;
	KString operator + (bool			bValue)		const;
	KString operator + (const void*		pPtr)		const;
	KString operator + (TAlignment		Alignment)	const;

	KString& operator += (const KString&	SString);
	KString& operator += (LPCTSTR			pSString);
	KString& operator += (TCHAR				cChar);
	KString& operator += (__int64			iValue);
	KString& operator += (QWORD				qwValue)	{ return *this += (__int64)qwValue;	}
	KString& operator += (int				iValue)		{ return *this += (__int64)iValue;	}
	KString& operator += (UINT				uiValue)	{ return *this += (__int64)(uiValue == UINT_MAX ? (__int64)-1 : (__int64)uiValue); }
	KString& operator += (float				fValue);
	KString& operator += (double			dValue);
	KString& operator += (bool				bValue); 
	KString& operator += (const void*		pPtr);
	KString& operator += (TAlignment		Alignment);

	LPTSTR	GetDataPtr(size_t szIndex = 0)			{ return m_Chars.GetDataPtr(szIndex); }
	LPCTSTR	GetDataPtr(size_t szIndex = 0) const	{ return m_Chars.GetDataPtr(szIndex); }
	
	TCHAR GetChar(size_t szIndex) const { return m_Chars[szIndex]; }

	void SetChar(size_t szIndex, TCHAR c) { m_Chars[szIndex] = c; }

	KString Lower() const;
	KString Upper() const;

	size_t Find(LPCTSTR	pSString,	size_t szStart = 0) const;
	size_t Find(TCHAR	cChar,		size_t szStart = 0) const;

	size_t FindNoCase(LPCTSTR pSString, size_t szStart = 0) const
		{ return Lower().Find(KString(pSString).Lower(), szStart); }

	size_t FindNoCase(TCHAR cChar, size_t szStart = 0) const
		{ return Lower().Find(_totlower(cChar)); }
	
	KString Left	(size_t szCount) const;
	KString Right	(size_t szCount) const;
	KString Mid		(size_t szStart, size_t szCount = UINT_MAX) const;

	KString& SetLeft	(size_t szCount);
	KString& SetRight	(size_t szCount);
	KString& SetMid		(size_t szStart, size_t szCount = UINT_MAX);

	int CompareStart(const KString& SString) const
		{ return _tcsncoll(*this, SString, SString.GetLength()); }

	int CompareStartNoCase(const KString& SString) const
		{ return _tcsnicoll(*this, SString, SString.GetLength()); }

	bool DoesStart(const KString& SString) const
		{ return CompareStart(SString) == 0; }

	bool DoesStartNoCase(const KString& SString) const
		{ return CompareStartNoCase(SString) == 0; }

	KString TrimLeft	() const;
	KString TrimRight	() const;
	KString Trim		() const;

	KString& ToLower();
	KString& ToUpper();

	KString UnAccelerated() const;
	
	KString RNToN() const;
	KString NToRN() const;

	int Compare			(LPCTSTR pSString) const { return Sign(_tcscmp	(GetDataPtr(), pSString)); }
	int CompareNoCase	(LPCTSTR pSString) const { return Sign(_tcsicmp	(GetDataPtr(), pSString)); }

	int Collate			(LPCTSTR pSString) const { return Sign(_tcscoll	(GetDataPtr(), pSString)); }
	int CollateNoCase	(LPCTSTR pSString) const { return Sign(_tcsicoll(GetDataPtr(), pSString)); }

	bool operator == (const KString& SString) const { return GetLength() == SString.GetLength() && Collate(SString) == 0; }
	bool operator != (const KString& SString) const { return GetLength() != SString.GetLength() || Collate(SString) != 0; }

	bool operator <		(LPCTSTR pSString) const { return Collate(pSString) <	0; }
	bool operator >		(LPCTSTR pSString) const { return Collate(pSString) >	0; }
	bool operator <=	(LPCTSTR pSString) const { return Collate(pSString) <=	0; }
	bool operator >=	(LPCTSTR pSString) const { return Collate(pSString) >=	0; }
	bool operator ==	(LPCTSTR pSString) const { return Collate(pSString) ==	0; }
	bool operator !=	(LPCTSTR pSString) const { return Collate(pSString) !=	0; }
	
	static int QSortFunctionCase		(const void* p1, const void* p2);
	static int QSortFunctionNoCase		(const void* p1, const void* p2);
	static int QSortFunctionNumeric		(const void* p1, const void* p2);
	static int QSortFunctionFileNoCase	(const void* p1, const void* p2);
	static int QSortFunctionFileNumeric	(const void* p1, const void* p2);

	static KString CurrentDateString();
	static KString CurrentTimeString();

	static KString DateTimeString(	const KString& DateString,
									const KString& TimeString);

	static KString CurrentDateTimeString();

	operator LPCTSTR () const { return GetDataPtr(); }
};

inline int Compare(const KString& String1, const KString& String2)
	{ return String1.Collate(String2); }

inline bool operator < (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) > 0; }

inline bool operator > (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) < 0; }

inline bool operator <= (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) >= 0; }

inline bool operator >= (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) <= 0; }

inline bool operator == (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) == 0; }

inline bool operator != (LPCTSTR pString1, const KString& String2)
	{ return String2.Collate(pString1) != 0; }

// ------------
// Ansi string
// ------------
class KFC_KTL_API TAnsiString : public TValueArray<CHAR, true>
{
public:
	TAnsiString();

	TAnsiString(LPCSTR	pAnsiString);
	TAnsiString(LPCWSTR	pWideString);

	size_t GetLength() const { return GetN() - 1; }

	operator LPSTR	()			{ return GetDataPtr(); }
	operator LPCSTR	() const	{ return GetDataPtr(); }
};

inline int Compare(const TAnsiString& String1, const TAnsiString& String2)
{
	return strcoll(String1, String2);
}

// ansi-ansi
inline bool operator == (const TAnsiString& String1, const TAnsiString& String2)
{
	return	String1.GetLength() == String2.GetLength() &&
				strcoll(String1, String2) == 0;
}

inline bool operator != (const TAnsiString& String1, const TAnsiString& String2)
{
	return	String1.GetLength() != String2.GetLength() ||
				strcoll(String1, String2) != 0;
}

inline bool operator < (const TAnsiString& String1, const TAnsiString& String2)
{
	return Compare(String1, String2) < 0;
}

inline bool operator > (const TAnsiString& String1, const TAnsiString& String2)
{
	return Compare(String1, String2) > 0;
}

inline bool operator <= (const TAnsiString& String1, const TAnsiString& String2)
{
	return Compare(String1, String2) <= 0;
}

inline bool operator >= (const TAnsiString& String1, const TAnsiString& String2)
{
	return Compare(String1, String2) >= 0;
}

// ansi-s
inline bool operator == (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) == 0;
}

inline bool operator != (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) != 0;
}

inline bool operator < (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) < 0;
}

inline bool operator > (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) > 0;
}

inline bool operator <= (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) <= 0;
}

inline bool operator >= (const TAnsiString& String1, LPCSTR pString2)
{
	return strcoll(String1, pString2) >= 0;
}

// s-ansi
inline bool operator == (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) == 0;
}

inline bool operator != (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) != 0;
}

inline bool operator < (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) < 0;
}

inline bool operator > (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) > 0;
}

inline bool operator <= (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) <= 0;
}

inline bool operator >= (LPCSTR pString1, const TAnsiString& String2)
{
	return strcoll(pString1, String2) >= 0;
}

// ------------
// Wide string
// ------------
class KFC_KTL_API TWideString : public TValueArray<WCHAR, true>
{
public:
	TWideString();

	TWideString(LPCSTR	pAnsiString);
	TWideString(LPCWSTR	pWideString);

	size_t GetLength() const { return GetN() - 1; }

	operator LPWSTR	()			{ return GetDataPtr(); }
	operator LPCWSTR() const	{ return GetDataPtr(); }
};

inline int Compare(const TWideString& String1, const TWideString& String2)
{
	return wcscoll(String1, String2);
}

// wide-wide
inline bool operator == (const TWideString& String1, const TWideString& String2)
{
	return	String1.GetLength() == String2.GetLength() &&
				wcscoll(String1, String2) == 0;
}

inline bool operator != (const TWideString& String1, const TWideString& String2)
{
	return	String1.GetLength() != String2.GetLength() ||
				wcscoll(String1, String2) != 0;
}

inline bool operator < (const TWideString& String1, const TWideString& String2)
{
	return Compare(String1, String2) < 0;
}

inline bool operator > (const TWideString& String1, const TWideString& String2)
{
	return Compare(String1, String2) > 0;
}

inline bool operator <= (const TWideString& String1, const TWideString& String2)
{
	return Compare(String1, String2) <= 0;
}

inline bool operator >= (const TWideString& String1, const TWideString& String2)
{
	return Compare(String1, String2) >= 0;
}

// side-s
inline bool operator == (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) == 0;
}

inline bool operator != (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) != 0;
}

inline bool operator < (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) < 0;
}

inline bool operator > (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) > 0;
}

inline bool operator <= (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) <= 0;
}

inline bool operator >= (const TWideString& String1, LPCWSTR pString2)
{
	return wcscoll(String1, pString2) >= 0;
}

// s-wide
inline bool operator == (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) == 0;
}

inline bool operator != (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) != 0;
}

inline bool operator < (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) < 0;
}

inline bool operator > (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) > 0;
}

inline bool operator <= (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) <= 0;
}

inline bool operator >= (LPCWSTR pString1, const TWideString& String2)
{
	return wcscoll(pString1, String2) >= 0;
}

// ---------------
// Default string
// ---------------
#ifdef _UNICODE
	typedef TWideString TDefaultString;
#else // _UNICODE
	typedef TAnsiString TDefaultString;
#endif // _UNICODE

// def-k
inline bool operator == (const TDefaultString& String1, const KString& String2)
{
	return	String1.GetLength() == String2.GetLength() &&
				(LPCTSTR)String1 == String2;
}

inline bool operator != (const TDefaultString& String1, const KString& String2)
{
	return	String1.GetLength() != String2.GetLength() ||
				(LPCTSTR)String1 != String2;
}

inline bool operator < (const TDefaultString& String1, const KString& String2)
{
	return (LPCTSTR)String1 < String2;
}

inline bool operator > (const TDefaultString& String1, const KString& String2)
{
	return (LPCTSTR)String1 > String2;
}

inline bool operator <= (const TDefaultString& String1, const KString& String2)
{
	return (LPCTSTR)String1 <= String2;
}

inline bool operator >= (const TDefaultString& String1, const KString& String2)
{
	return (LPCTSTR)String1 >= String2;
}

// k-def
inline bool operator == (const KString& String1, const TDefaultString& String2)
{
	return String1.GetLength() == String2.GetLength() && String1 == (LPCTSTR)String2;
}

inline bool operator != (const KString& String1, const TDefaultString& String2)
{
	return String1.GetLength() != String2.GetLength() || String1 != (LPCTSTR)String2;
}

inline bool operator < (const KString& String1, const TDefaultString& String2)
{
	return String1 < (LPCTSTR)String2;
}

inline bool operator > (const KString& String1, const TDefaultString& String2)
{
	return String1 > (LPCTSTR)String2;
}

inline bool operator <= (const KString& String1, const TDefaultString& String2)
{
	return String1 <= (LPCTSTR)String2;
}

inline bool operator >= (const KString& String1, const TDefaultString& String2)
{
	return String1 >= (LPCTSTR)String2;
}

// -----------------
// String streaming
// -----------------
inline TStream& operator >> (TStream& Stream, KString& RString)
{
	size_t szLength;
	Stream >> szLength;
	
	RString.Allocate(szLength);
	
	STREAM_READ_ARR(Stream, RString.GetDataPtr(), szLength, TCHAR);
	
	return Stream;
}

inline TStream& operator << (TStream& Stream, const KString& String)
{
	Stream << String.GetLength();
	
	STREAM_WRITE_ARR(Stream, String.GetDataPtr(), String.GetStreamCharsLength(), TCHAR);
	
	return Stream;
}

inline TStream& operator << (TStream& Stream, const TCHAR* pString)
{
	const size_t szLength = _tcslen(pString);

	Stream << szLength;

	STREAM_WRITE_ARR(Stream, pString, szLength, TCHAR);

	return Stream;
}

// ----------------
// Global routines
// ----------------
KFC_KTL_API LPCTSTR NullString(LPCTSTR pString);

#endif // kstring_h
