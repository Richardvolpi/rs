#include "kfc_ktl_pch.h"
#include "kstring.h"

#include <stdio.h>
#include <stdarg.h>
#include <stdlib.h>
#include <time.h>
#include "file_names.h"

// -------
// String
// -------
KString::KString(TCHAR c, size_t szNRepeats)
{
	Allocate(szNRepeats);
	
	if(sizeof(c) == 1)
	{
		memset(GetDataPtr(), c, szNRepeats * sizeof(c));
	}
	else
	{
		for(size_t i=0 ; i<szNRepeats ; i++)
			m_Chars[i] = c;
	}
}

KString::KString(LPCTSTR pStr, size_t szLength)
{
	Allocate(szLength);
	
	memcpy(GetDataPtr(), pStr, GetStreamCharsLength(szLength));
}

KString::KString(LPCTSTR pStr1, size_t szLength1, LPCTSTR pStr2, size_t szLength2)
{
	Allocate(szLength1 + szLength2);

	memcpy(GetDataPtr(), pStr1, GetStreamCharsLength(szLength1));
	memcpy(GetDataPtr(szLength1), pStr2, GetStreamCharsLength(szLength2));
}

void KString::Allocate(size_t szLength)
{
	szLength++;

	m_Chars.Allocate(	TArrayAllocation(	szLength <= STRING_ALLOCATION_START ?
												STRING_ALLOCATION_START :
												STRING_ALLOCATION_START +
													(szLength -
													STRING_ALLOCATION_START +
													STRING_ALLOCATION_DELTA - 1) /
													STRING_ALLOCATION_DELTA *
													STRING_ALLOCATION_DELTA,
											STRING_ALLOCATION_DELTA));

	m_Chars.Add(szLength);

	Terminate();
}

bool KString::IsSpecChar(TCHAR cChar)
{
	return	cChar == 0			||
			cChar == TEXT('\r') ||
			cChar == TEXT('\n') || 
			cChar == TEXT('\t');
}

TCHAR KString::ValueToAlphabet(size_t szValue)
{
	DEBUG_VERIFY(szValue < MAX_ALPHABET_RADIX);

	if(szValue < 10)
		return (TCHAR)(TEXT('0') + szValue);

	if(szValue < 10 + 26)
		return (TCHAR)(TEXT('A') + (szValue - 10));

	return (TCHAR)(TEXT('a') + (szValue - (10 + 26)));
}

size_t KString::AlphabetToValue(TCHAR cChar)
{
	if(_istdigit(cChar))
		return cChar - TEXT('0');

	if(_istupper(cChar))
		return cChar - TEXT('A') + 10;

	if(_istlower(cChar))
		return cChar - TEXT('a') + (10 + 26);

	return UINT_MAX;
}

size_t KString::GetNoSpecCharactersLength() const
{
	size_t szLength = 0;

	for(size_t i = 0 ; i < GetLength() ; i++)
		if(!IsSpecChar(m_Chars[i]))
			szLength++;
		
	return szLength;
}

void KString::Extend(size_t szLength)
{
	m_Chars.Add(szLength);

	Terminate();
}

void KString::Extend(LPCTSTR pSString, size_t szLength)
{
	size_t szOldLength = GetLength();

	Extend(szLength);

	memcpy(GetDataPtr(szOldLength), pSString, GetStreamCharsLength(szLength));
}

KString& KString::WriteInt64(__int64 iValue, bool bSeparate)
{
	if(!bSeparate)
		return *this = iValue;
	
	TCHAR Buf[128];

	// Preparing
	bool bNeg;
	if(iValue<0)
		iValue = -iValue, bNeg = true;
	else
		bNeg = false;

	size_t l = 0;

	// Writing digits
	if(bSeparate)
	{	
		size_t nd = 0;

		do
		{
			Buf[l++] = (TCHAR)(TEXT('0') + iValue % 10), iValue /= 10;
			if(++nd==3 && iValue)
				Buf[l++] = TEXT('\''), nd=0;

		}while(iValue);
	}
	else
	{
		do
		{
			Buf[l++] = (TCHAR)(TEXT('0') + iValue % 10), iValue /= 10;

		}while(iValue);
	}

	// Sign
	if(bNeg)
		Buf[l++] = TEXT('-');

	// Finishing
	Buf[l] = 0;
	
	// Reversing
	for(size_t i=(l>>1)-1 ; i!=UINT_MAX ; i--)
	{
		TCHAR t;
		t=Buf[i], Buf[i]=Buf[l-i-1], Buf[l-i-1]=t;
	}

	return *this = Buf; // +++ use internal known length allocator
}

KString& KString::Format(LPCTSTR pFormat, ...)
{
	va_list ArgList;
	va_start(ArgList, pFormat);

	TCHAR Buf[16384]; // !!!
	_vsntprintf(Buf, sizeof(Buf) - 1, pFormat, ArgList);

	va_end(ArgList);

	return *this = Buf; // +++ use internal known length allocator
}

KString& KString::FormatV(LPCTSTR pFormat, va_list ArgList)
{
	TCHAR Buf[16384]; // !!!
	_vsntprintf(Buf, sizeof(Buf) - 1, pFormat, ArgList);

	return *this = Buf; // +++ use internal known length allocator
}

KString KString::Formatted(LPCTSTR pFormat, ...)
{
	va_list ArgList;
	va_start(ArgList, pFormat);

	KString String;
	String.FormatV(pFormat, ArgList);

	va_end(ArgList);

	return String;
}

KString KString::FormattedV(LPCTSTR pFormat, va_list ArgList)
{
	KString String;
	String.FormatV(pFormat, ArgList);

	return String;
}

KString& KString::operator = (const KString& SString)
{
	if(&SString == this)
		return *this;

	m_Chars = SString.m_Chars;

	return *this;
}

KString& KString::operator = (LPCTSTR pSString)
{
	Allocate(_tcslen(pSString));

	memcpy(GetDataPtr(), pSString, GetStreamCharsLength());

	return *this;
}

KString& KString::operator = (__int64 iValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%I64d"), iValue);

	return *this = Buf;
}

KString& KString::operator = (float fValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.2f"), fValue);

	return *this = Buf; // +++ use smart assignment with length known from printf (oth. - too)
}

KString& KString::operator = (double dValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.4lf"), dValue);

	return *this = Buf; // +++ use smart assignment with length known from printf (oth. - too)
}

KString& KString::operator = (bool bValue)
{
	// +++ use smart assignment with length known from printf (oth. - too)
	return *this = (bValue ? TEXT("true") : TEXT("false"));
}

KString& KString::operator = (const void* pPtr)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%p"), pPtr);

	return *this = Buf;
}

KString& KString::operator = (TAlignment Alignment)
{
	if(Alignment == ALIGNMENT_MIN)
		return *this = TEXT("min");

	if(Alignment == ALIGNMENT_MID)
		return *this = TEXT("mid");

	if(Alignment == ALIGNMENT_MAX)
		return *this = TEXT("max");

	INITIATE_FAILURE;
}

KString KString::operator + (const KString& SString) const
{
	return KString(GetDataPtr(), GetLength(), SString, SString.GetLength());
}

KString KString::operator + (LPCTSTR pSString) const
{
	return KString(GetDataPtr(), GetLength(), pSString, _tcslen(pSString));
}

KString KString::operator + (TCHAR cChar) const
{
	return KString(GetDataPtr(), GetLength(), &cChar, 1);
}

KString KString::operator + (__int64 iValue) const
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%I64d"), iValue);

	return KString(GetDataPtr(), GetLength(), Buf, _tcslen(Buf));
}

KString KString::operator + (float fValue) const
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.2f"), fValue);

	return KString(GetDataPtr(), GetLength(), Buf, _tcslen(Buf));
};

KString KString::operator + (double dValue) const
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.4lf"), dValue);

	return KString(GetDataPtr(), GetLength(), Buf, _tcslen(Buf));
}

KString KString::operator + (bool bValue) const
{
	return bValue ?
				KString(GetDataPtr(), GetLength(), TEXT("true"),	4) :
				KString(GetDataPtr(), GetLength(), TEXT("false"),	5);
}

KString KString::operator + (const void* pPtr) const
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%p"), pPtr);

	return KString(GetDataPtr(), GetLength(), Buf, _tcslen(Buf));
}

KString KString::operator + (TAlignment Alignment) const
{
	if(Alignment == ALIGNMENT_MIN)
		return KString(GetDataPtr(), GetLength(), TEXT("min"), 3);

	if(Alignment == ALIGNMENT_MID)
		return KString(GetDataPtr(), GetLength(), TEXT("mid"), 3);

	if(Alignment == ALIGNMENT_MAX)
		return KString(GetDataPtr(), GetLength(), TEXT("max"), 3);

	INITIATE_FAILURE;
}

KString& KString::operator += (const KString& SString)
{
	if(&SString == this)
	{
		size_t szOldLength = GetLength();

		Extend(GetLength());

		memcpy(GetDataPtr() + szOldLength, GetDataPtr(), GetStreamCharsLength(szOldLength));
	}
	else
	{
		Extend(SString, SString.GetLength());
	}

	return *this;
}

KString& KString::operator += (LPCTSTR pSString)
{
	Extend(pSString, _tcslen(pSString));

	return *this;
}

KString& KString::operator += (TCHAR cChar)
{
	Extend(&cChar, 1);
	
	return *this;
}

KString& KString::operator += (__int64 iValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%I64d"), iValue);

	Extend(Buf, _tcslen(Buf));

	return *this;
}

KString& KString::operator += (float fValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.2f"), fValue);

	Extend(Buf, _tcslen(Buf));
	
	return *this;
}

KString& KString::operator += (double dValue)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%.4lf"), dValue);

	Extend(Buf, _tcslen(Buf));

	return *this;
}

KString& KString::operator += (bool bValue)
{
	if(bValue)
		Extend(TEXT("true"), 4);
	else
		Extend(TEXT("false"), 5);

	return *this;
}

KString& KString::operator += (const void* pPtr)
{
	TCHAR Buf[32];
	_stprintf(Buf, TEXT("%p"), pPtr);

	Extend(Buf, _tcslen(Buf));

	return *this;
}

KString& KString::operator += (TAlignment Alignment)
{
	if(Alignment == ALIGNMENT_MIN)
	{
		Extend(TEXT("min"), 3);
		return *this;
	}

	if(Alignment == ALIGNMENT_MID)
	{
		Extend(TEXT("mid"), 3);
		return *this;
	}

	if(Alignment == ALIGNMENT_MAX)
	{
		Extend(TEXT("max"), 3);
		return *this;
	}

	INITIATE_FAILURE;
}

KString KString::Lower() const
{
	KString String = *this;

	_tcslwr(String.GetDataPtr());

	return String;
}

KString KString::Upper() const
{
	KString String = *this;

	_tcsupr(String.GetDataPtr());

	return String;
}

size_t KString::Find(LPCTSTR pSString, size_t szStart) const
{
	DEBUG_VERIFY(szStart <= GetLength());

	LPCTSTR ptr = _tcsstr(GetDataPtr() + szStart, pSString);

	return ptr ? ptr - GetDataPtr() : UINT_MAX;
}

size_t KString::Find(TCHAR cChar, size_t szStart) const
{
	DEBUG_VERIFY(szStart <= GetLength());

	LPCTSTR ptr = _tcschr(GetDataPtr() + szStart, cChar);

	return ptr ? ptr - GetDataPtr() : UINT_MAX;
}

KString KString::Left(size_t szCount) const
{
	if(szCount > GetLength())
		throw 1;

	return KString(GetDataPtr(), szCount);
}

KString KString::Right(size_t szCount) const
{
	if(szCount > GetLength())
		throw 1;

	return KString(GetDataPtr() + (GetLength() - szCount), szCount);
}

KString KString::Mid(size_t szStart, size_t szCount) const
{
	if(szStart > GetLength())
		throw 1;

	if(szCount == UINT_MAX)
		szCount = GetLength() - szStart;

	if(szStart + szCount > GetLength())
		throw 1;

	return KString(GetDataPtr() + szStart, szCount);
}

KString& KString::SetLeft(size_t szCount) 
{
	if(szCount > GetLength())
		throw 1;

	m_Chars.Del(szCount, GetLength());

	return *this;
}

KString& KString::SetRight(size_t szCount)
{
	if(szCount > GetLength())
		throw 1;

	m_Chars.Del(0, GetLength() - szCount);

	return *this;
}

KString& KString::SetMid(size_t szStart, size_t szCount)
{
	if(szStart > GetLength())
		throw 1;

	if(szCount == UINT_MAX)
		szCount = GetLength() - szStart;

	if(szStart + szCount > GetLength())
		throw 1;

	return SetLeft(szStart + szCount).SetRight(szCount);

	return *this;
}

KString KString::TrimLeft() const
{
	size_t i;
	for(i = 0 ; _istspace(m_Chars[i]) ; i++);

	return Mid(i);
}

KString& KString::ToLower()
{
	_tcslwr(GetDataPtr());

	return *this;
}

KString& KString::ToUpper()
{
	_tcsupr(GetDataPtr());

	return *this;
}

KString KString::TrimRight() const
{
	size_t i;
	for(i = GetLength() - 1 ; i != UINT_MAX && _istspace(m_Chars[i]) ; i--);

	return Left(i + 1);
}

KString KString::Trim() const
{
	int i;
	for(i = 0 ; _istspace(m_Chars[i]) ; i++);

	int j;
	for(j = GetLength() - 1 ; j > i && _istspace(m_Chars[j]) ; j--);

	return Mid(i, j - i + 1);
}

KString KString::UnAccelerated() const
{
	KString String;

	for(size_t i = 0 ; i < GetLength() ; i++)
	{
		if(GetChar(i) == TEXT('&'))
			i++;

		String += GetChar(i);
	}

	return String;
}

KString KString::RNToN() const
{
	KString String;

	for(size_t i = 0 ; i < GetLength() ; i++)
	{
		if(GetChar(i) == TEXT('\r') && GetChar(i + 1) == TEXT('\n'))
			i++;

		String += GetChar(i);
	}

	return String;
}

KString KString::NToRN() const
{
	KString String;

	for(size_t i = 0 ; i < GetLength() ; i++)
	{
		if(GetChar(i) == TEXT('\n'))
			String += TEXT('\r');

		String += GetChar(i);
	}

	return String;
}

int KString::QSortFunctionCase(const void* p1, const void* p2)
{
	return ((KString*)p1)->Collate(*(KString*)p2);
}

int KString::QSortFunctionNoCase(const void* p1, const void* p2)
{
	return ((KString*)p1)->CollateNoCase(*(KString*)p2);
}

int KString::QSortFunctionNumeric(const void* p1, const void* p2)
{
	TCHAR	Buf[1024];
	size_t	szBufLen;
	int		v1, v2;
	size_t	i;

	const KString& String1 = *(KString*)p1;
	const KString& String2 = *(KString*)p2;

	// Fetching first value
	szBufLen = 0;
	for(i=0 ; i<String1.GetLength() ; i++)
		if(_istdigit(String1[i]))
			Buf[szBufLen++] = String1[i];

	Buf[szBufLen] = 0, v1 = _ttoi(Buf);

	// Fetching second value
	szBufLen = 0;
	for(i=0 ; i<String2.GetLength() ; i++)
		if(_istdigit(String2[i]))
			Buf[szBufLen++] = String2[i];

	Buf[szBufLen] = 0, v2 = _ttoi(Buf);

	// Comparing
	if(v1 < v2)
		return -1;

	if(v1 > v2)
		return 1;

	return QSortFunctionNoCase(p1, p2);
}

int KString::QSortFunctionFileNoCase(const void* p1, const void* p2)
{
	return QSortFunctionNoCase(GetFileName(*(KString*)p1), GetFileName(*(KString*)p2));
}

int KString::QSortFunctionFileNumeric(const void* p1, const void* p2)
{
	return QSortFunctionNumeric(GetFileName(*(KString*)p1), GetFileName(*(KString*)p2));
}

KString KString::CurrentDateString()
{
	time_t long_time;

	time(&long_time);

	TCHAR Buf[128];
	_tcsftime(	Buf,
				sizeof(Buf) - 1,
				TEXT("%Y-%m-%d"),
				localtime(&long_time));

	return Buf;
}

KString KString::CurrentTimeString()
{
	time_t long_time;

	time(&long_time);

	TCHAR Buf[128];

	_tcsftime(	Buf,
				sizeof(Buf) - 1,
				TEXT("%H:%M:%S"),
				localtime(&long_time));

	return Buf;
}

KString KString::DateTimeString(const KString& DateString,
								const KString& TimeString)
{
	return DateString + TEXT("  ") + TimeString;
}

KString KString::CurrentDateTimeString()
{
	return DateTimeString(CurrentDateString(), CurrentTimeString());
}

// ------------
// Ansi string
// ------------
TAnsiString::TAnsiString()
{
	AllocateAdd(1) = 0;
}

TAnsiString::TAnsiString(LPCSTR pAnsiString)
{
	const size_t szLength = strlen(pAnsiString);

	AllocateAdd(szLength + 1);

	memcpy(GetDataPtr(), pAnsiString, szLength * sizeof(CHAR));

	GetDataPtr()[szLength] = 0;
}

TAnsiString::TAnsiString(LPCWSTR pWideString)
{
	const size_t szLength = wcslen(pWideString);

	AllocateAdd(szLength + 1);

	WideCharToMultiByte(CP_ACP,
						0,
						pWideString,
						szLength,
						GetDataPtr(),
						szLength,
						NULL,
						NULL);

	GetDataPtr()[szLength] = 0;
}

// ------------
// Wide string
// ------------
TWideString::TWideString()
{
	AllocateAdd(1) = 0;
}

TWideString::TWideString(LPCSTR pAnsiString)
{
	const size_t szLength = strlen(pAnsiString);

	AllocateAdd(szLength + 1);

	MultiByteToWideChar(CP_ACP,
						0,
						pAnsiString,
						szLength,
						GetDataPtr(),
						szLength);

	GetDataPtr()[szLength] = 0;
}

TWideString::TWideString(LPCWSTR pWideString)
{
	const size_t szLength = wcslen(pWideString);

	AllocateAdd(szLength + 1);

	memcpy(GetDataPtr(), pWideString, szLength * sizeof(WCHAR));

	GetDataPtr()[szLength] = 0;
}

// ----------------
// Global routines
// ----------------
LPCTSTR NullString(LPCTSTR pString)
{
	return pString ? pString : TEXT("(null)");
}