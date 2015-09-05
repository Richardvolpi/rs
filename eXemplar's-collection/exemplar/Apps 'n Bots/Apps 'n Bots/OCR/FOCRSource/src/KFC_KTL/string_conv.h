#ifndef kstring_conv_h
#define kstring_conv_h

#include <ctype.h>
#include "kstring.h"
#include "alignment.h"
#include "basic_types.h"
#include "basic_bitypes.h"

// -----------------------
// Enum string conversion
// -----------------------
#define DECLARE_ENUM_STRING_CONVERSION(Type, Min, Max)			\
	inline bool FromString(const KString& String, Type& RValue)	\
	{															\
		const SZSEGMENT Limits(Min, Max);						\
																\
		DEBUG_VERIFY(Limits.IsFlatValid());						\
																\
		DEBUG_VERIFY(sizeof(Type) == sizeof(UINT));				\
																\
		UINT uiValue;											\
		if(!FromString(String, uiValue))						\
			return false;										\
																\
		if(!HitsSegmentBounds(uiValue, Limits))					\
			return false;										\
																\
		RValue = (Type)uiValue;									\
																\
		return true;											\
	}															\

// ------------------
// String conversion
// ------------------
inline bool FromString(const KString& String, KString& RString)
{
	RString = String.Trim();

	return true;
}

// ----------------------
// Alignment conversions
// ----------------------
inline bool FromString(const KString& String, TAlignment& RAlignment)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(TempString == TEXT("min"))
	{
		RAlignment = ALIGNMENT_MIN;
		return true;
	}

	if(TempString == TEXT("mid"))
	{
		RAlignment = ALIGNMENT_MID;
		return true;
	}

	else if(TempString == TEXT("max"))
	{
		RAlignment = ALIGNMENT_MAX;
		return true;
	}
	
	return false;
}

// -------------------------------
// Basic types string convresions
// -------------------------------
inline bool FromString(const KString& String, QWORD& qwRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(TempString == TEXT("-1"))
	{
		qwRValue = QWORD_MAX;
	}
	else
	{
		qwRValue = 0;

		for(size_t i = 0 ; i < TempString.GetLength() ; i++)
		{
			if(!_istdigit(TempString[i]))
				return false;

			qwRValue *= 10, qwRValue += TempString[i] - TEXT('0');
		}
	}

	return true;
}

inline bool FromString(const KString& String, __int64& iRValue)
{
	const KString TempString = String.Trim();

	int sgn = 1;

	size_t i = 0;

	if(TempString[i] == TEXT('+'))
		i++;
	else if(TempString[i] == TEXT('-'))
		sgn = -1, i++;

	if(TempString[i] == 0) // empty or sign only
		return false;

	iRValue = 0;
	for( ; i < TempString.GetLength() ; i++)
	{
		if(!_istdigit(TempString[i]))
			return false;

		iRValue *= 10, iRValue += (TempString[i] - TEXT('0')) * sgn;
	}

	return true;
}

inline bool FromString(const KString& String, UINT& uiRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(TempString == TEXT("-1"))
	{
		uiRValue = UINT_MAX;
	}
	else
	{
		for(size_t i = 0 ; i < TempString.GetLength() ; i++)
		{
			if(!_istdigit(TempString[i]))
				return false;
		}

		if(_stscanf(TempString, TEXT("%u"), &uiRValue) != 1)
			return false;
	}

	return true;
}

inline bool FromString(const KString& String, int& iRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	for(size_t i = 0 ; i < TempString.GetLength() ; i++)
	{
		if(	!_istdigit(TempString[i]) &&
			(i > 0 ||
				TempString[0] != TEXT('+') &&
				TempString[0] != TEXT('-')))
		{
			return false;
		}
	}

	if(_stscanf(TempString, TEXT("%d"), &iRValue) != 1)
		return false;

	return true;
}

inline bool FromString(const KString& String, float& fRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(_stscanf(TempString, TEXT("%f"), &fRValue) != 1)
		return false;

	return true;
}

inline bool FromString(const KString& String, double& dRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(_stscanf(TempString, TEXT("%lf"), &dRValue) != 1)
		return false;

	return true;
}

inline bool FromString(const KString& String, bool& bRValue)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(TempString.CompareNoCase(TEXT("true")) == 0)
		bRValue = true;
	else if(TempString.CompareNoCase(TEXT("false")) == 0)
		bRValue = false;
	else
		return false;

	return true;
}

// ---------------------------------
// Basic bitypes string convresions
// ---------------------------------
template <class t>
inline bool FromString(const KString& String, TPoint<t>& RPoint)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(	TempString.GetLength() < 2 ||
		TempString[0] != TEXT('(') ||
		TempString[TempString.GetLength() - 1] != TEXT(')'))
	{
		return false;
	}

	size_t szPos = TempString.Find(TEXT(";"), 1);
	if(szPos == UINT_MAX)
		return false;

	if(	!FromString(TempString.Mid(1, szPos - 1).Trim(), RPoint.x) ||
		!FromString(TempString.Mid(szPos + 1, TempString.GetLength() - szPos - 2).Trim(), RPoint.y))
	{
		return false;
	}

	return true;
}

template <class t>
inline bool FromString(const KString& String, TRect<t>& RRect)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(	TempString.GetLength() < 2 ||
		TempString[0] != TEXT('[') ||
		TempString[TempString.GetLength() - 1] != TEXT(')'))
	{
		return false;
	}

	size_t szPos;

	szPos = TempString.Find(TEXT(" - "), 1);
	if(szPos == UINT_MAX)
		return false;

	KString Start	= TempString.Mid(1, szPos - 1).Trim();
	KString End		= TempString.Mid(szPos + 3, TempString.GetLength() - szPos - 4).Trim();

	// Start
	szPos = Start.Find(TEXT(";"));
	if(szPos == UINT_MAX)
		return false;

	if(	!FromString(Start.Left(szPos).Trim(), RRect.m_Left) ||
		!FromString(Start.Right(Start.GetLength() - szPos - 1).Trim(), RRect.m_Top))
	{
		return false;
	}

	// End
	szPos = End.Find(TEXT(";"));
	if(szPos == UINT_MAX)
		return false;

	if(	!FromString(End.Left(szPos).Trim(), RRect.m_Right) ||
		!FromString(End.Right(End.GetLength() - szPos - 1).Trim(), RRect.m_Bottom))
	{
		return false;
	}

	return true;
}

template <class t>
inline bool FromString(const KString& String, TSize<t>& RSize)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(	TempString.GetLength() < 2 ||
		TempString[0] != TEXT('<') ||
		TempString[TempString.GetLength() - 1] != TEXT('>'))
	{
		return false;
	}

	size_t szPos = TempString.Find(TEXT(";"), 1);
	if(szPos == UINT_MAX)
		return false;

	if(	!FromString(TempString.Mid(1, szPos - 1).Trim(), RSize.cx) ||
		!FromString(TempString.Mid(szPos + 1, TempString.GetLength() - szPos - 2).Trim(), RSize.cy))
	{
		return false;
	}

	return true;
}

template <class t>
inline bool FromString(const KString& String, TSegment<t>& RSegment)
{
	const KString TempString = String.Trim();

	if(TempString.IsEmpty())
		return false;

	if(	TempString.GetLength() < 2 ||
		TempString[0] != TEXT('[') ||
		TempString[TempString.GetLength() - 1] != TEXT(')'))
	{
		return false;
	}

	size_t szPos = TempString.Find(TEXT(";"), 1);
	if(szPos == UINT_MAX)
		return false;

	if(	!FromString(TempString.Mid(1, szPos - 1).Trim(), RSegment.m_First) ||
		!FromString(TempString.Mid(szPos + 1, TempString.GetLength() - szPos - 2).Trim(), RSegment.m_Last))
	{
		return false;
	}

	return true;
}

#endif // kstring_conv_h
