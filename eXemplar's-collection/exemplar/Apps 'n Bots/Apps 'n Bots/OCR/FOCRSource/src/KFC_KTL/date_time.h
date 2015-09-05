#ifndef date_time_h
#define date_time_h

#include "basic_types.h"
#include "kstring.h"

// Second casters
#define MIN_SECS	(60)
#define HOUR_SECS	(60 * MIN_SECS)
#define DAY_SECS	(24 * HOUR_SECS)

// ----------
// Date time
// ----------
struct KFC_KTL_API TDateTime
{
	static const size_t m_MonthDays		[2][12];
	static const size_t m_TotalMonthDays[2][12];

	size_t m_szYear;
	size_t m_szMonth;
	size_t m_szDay;
	
	size_t m_szHour;
	size_t m_szMin;
	size_t m_szSec;


	TDateTime() { Invalidate(); }

	TDateTime(	size_t szSYear,
				size_t szSMonth,
				size_t szSDay,
				size_t szSHour,
				size_t szSMin,
				size_t szSSec)
	{
		Set(szSYear, szSMonth, szSDay, szSHour, szSMin, szSSec);
	}

	TDateTime& Set(	size_t szSYear,
					size_t szSMonth,
					size_t szSDay,
					size_t szSHour,
					size_t szSMin,
					size_t szSSec)
	{
		m_szYear	= szSYear;
		m_szMonth	= szSMonth;
		m_szDay		= szSDay;
		m_szHour	= szSHour;
		m_szMin		= szSMin;
		m_szSec		= szSSec;
		
		return *this;
	}

	bool IsValid() const;

	void Invalidate();

	TDateTime& GetCurrentLocal	();
	TDateTime& GetCurrentGlobal	();

	// Decreasing
	TDateTime& DecSec	(size_t szAmt = 1);
	TDateTime& DecMin	(size_t szAmt = 1);
	TDateTime& DecHour	(size_t szAmt = 1);
	TDateTime& DecDay	(size_t szAmt = 1);
	TDateTime& DecMonth	(size_t szAmt = 1);
	TDateTime& DecYear	(size_t szAmt = 1);

	// Increasing
	TDateTime& IncSec	(size_t szAmt = 1);
	TDateTime& IncMin	(size_t szAmt = 1);
	TDateTime& IncHour	(size_t szAmt = 1);
	TDateTime& IncDay	(size_t szAmt = 1);
	TDateTime& IncMonth	(size_t szAmt = 1);
	TDateTime& IncYear	(size_t szAmt = 1);	

	// Aligning
	TDateTime& AlignToSec	();
	TDateTime& AlignToMin	();
	TDateTime& AlignToHour	();
	TDateTime& AlignToDay	();
	TDateTime& AlignToMonth	();
	TDateTime& AlignToYear	();

	// Operators
	operator QWORD () const;

	operator KString () const;

	__int64 operator - (const TDateTime& dt) const
		{ return (__int64)((QWORD)*this - (QWORD)dt); }

	// Static helpers
	static bool IsLeapYear(size_t szYear)
	{
		DEBUG_VERIFY(szYear >= 1);

		return szYear % 400 == 0 || szYear % 4 == 0 && szYear % 100 != 0;
	}
	
	static size_t GetMonthDays(size_t szYear, size_t szMonth)
	{
		DEBUG_VERIFY(szYear >= 1);

		DEBUG_VERIFY(szMonth >= 1 && szMonth <= 12);

		return m_MonthDays[IsLeapYear(szYear) ? 1 : 0][szMonth - 1];
	}

	static size_t GetTotalMonthDaysBefore(size_t szYear, size_t szMonth)
	{
		DEBUG_VERIFY(szYear >= 1);

		DEBUG_VERIFY(szMonth >= 1 && szMonth <= 12);

		return m_TotalMonthDays[IsLeapYear(szYear) ? 1 : 0][szMonth - 1];
	}

	static size_t GetYearDays(size_t szYear)
	{
		DEBUG_VERIFY(szYear >= 1);

		return IsLeapYear(szYear) ? 366 : 365;
	}

	static size_t GetNumLeapYearsBefore(size_t szYear)
	{
		DEBUG_VERIFY(szYear >= 1);

		szYear--;

		return szYear / 4 - szYear / 100 + szYear / 400;
	}
	
	// Helpers
	bool IsLeapYear() const
		{ return IsLeapYear(m_szYear); }

	size_t GetMonthDays() const
		{ return GetMonthDays(m_szYear, m_szMonth); }

	size_t GetTotalMonthDaysBefore() const
		{ return GetTotalMonthDaysBefore(m_szYear, m_szMonth); }

	size_t GetYearDays() const
		{ return GetYearDays(m_szYear); }

	size_t GetNumLeapYearsBefore() const
		{ return GetNumLeapYearsBefore(m_szYear); }

	// Other
	static KString FormatTime(size_t szTime);
};

DECLARE_BASIC_STREAMING(TDateTime);

// ------------------
// Date time segment
// ------------------
typedef TSegment<TDateTime> DTSEGMENT;

// ----------------
// Global routines
// ----------------
inline __int64 GetDTSegmentLength(const DTSEGMENT& Segment)
{
	return Segment.m_Last - Segment.m_First;
}

inline int Compare(const TDateTime& dt1, const TDateTime& dt2)
{
	if(dt1.m_szYear != dt2.m_szYear)
		return (int)(dt1.m_szYear - dt2.m_szYear);

	if(dt1.m_szMonth != dt2.m_szMonth)
		return (int)(dt1.m_szMonth - dt2.m_szMonth);

	if(dt1.m_szDay != dt2.m_szDay)
		return (int)(dt1.m_szDay - dt2.m_szDay);

	if(dt1.m_szHour != dt2.m_szHour)
		return (int)(dt1.m_szHour - dt2.m_szHour);

	if(dt1.m_szMin != dt2.m_szMin)
		return (int)(dt1.m_szMin - dt2.m_szMin);

	if(dt1.m_szSec != dt2.m_szSec)
		return (int)(dt1.m_szSec - dt2.m_szSec);

	return 0;
}

KFC_KTL_API bool FromString(const KString& String, TDateTime& RDateTime);

#endif // date_time_h