#include "kfc_ktl_pch.h"
#include "date_time.h"

// ----------
// Date time
// ----------
const size_t TDateTime::m_MonthDays[2][12] = {	{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
												{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

const size_t TDateTime::m_TotalMonthDays[2][12] = {	{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334},
													{0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335}};

bool TDateTime::IsValid() const
{
	return	m_szYear	>= 1 &&
			m_szMonth	>= 1 && m_szMonth	<= 12 &&
			m_szDay		>= 1 && m_szDay		<= GetMonthDays() &&
			m_szHour	>= 0 && m_szHour	<= 23 &&
			m_szMin		>= 0 && m_szMin		<= 59 &&
			m_szSec		>= 0 && m_szSec		<= 59;
}

void TDateTime::Invalidate()
{
	memset(this, 0, sizeof(*this));
}

TDateTime& TDateTime::GetCurrentLocal()
{
	SYSTEMTIME LocalTime;
	GetLocalTime(&LocalTime);

	m_szYear	= LocalTime.wYear;
	m_szMonth	= LocalTime.wMonth;
	m_szDay		= LocalTime.wDay;

	m_szHour	= LocalTime.wHour;
	m_szMin		= LocalTime.wMinute;
	m_szSec		= LocalTime.wSecond;

	return *this;
}

TDateTime& TDateTime::GetCurrentGlobal()
{
	SYSTEMTIME LocalTime;
	GetSystemTime(&LocalTime);

	m_szYear	= LocalTime.wYear;
	m_szMonth	= LocalTime.wMonth;
	m_szDay		= LocalTime.wDay;

	m_szHour	= LocalTime.wHour;
	m_szMin		= LocalTime.wMinute;
	m_szSec		= LocalTime.wSecond;

	return *this;
}

// Decreasing
TDateTime& TDateTime::DecSec(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(--m_szSec == UINT_MAX)
			DecMin(), m_szSec = 59;
	}

	return *this;
}

TDateTime& TDateTime::DecMin(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(--m_szMin == UINT_MAX)
			DecHour(), m_szMin = 59;
	}

	return *this;
}

TDateTime& TDateTime::DecHour(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(--m_szHour == UINT_MAX)
			DecDay(), m_szHour = 23;
	}

	return *this;
}

TDateTime& TDateTime::DecDay(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(--m_szDay == 0)
			DecMonth(), m_szDay = GetMonthDays();
	}

	return *this;
}

TDateTime& TDateTime::DecMonth(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(--m_szMonth == 0)
			DecYear(), m_szMonth = 12;
	}
	
	return *this;
}

TDateTime& TDateTime::DecYear(size_t szAmt)
{
	m_szYear -= szAmt;

	return *this;
}

// Increasing
TDateTime& TDateTime::IncSec(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(++m_szSec == 60)
			IncMin(), m_szSec = 0;
	}

	return *this;
}

TDateTime& TDateTime::IncMin(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(++m_szMin == 60)
			IncHour(), m_szMin = 0;
	}

	return *this;
}

TDateTime& TDateTime::IncHour(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(++m_szHour == 24)
			IncDay(), m_szHour = 0;
	}

	return *this;
}

TDateTime& TDateTime::IncDay(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(++m_szDay == GetMonthDays() + 1)
			IncMonth(), m_szDay = 1;
	}

	return *this;
}

TDateTime& TDateTime::IncMonth(size_t szAmt)
{
	for( ; szAmt ; szAmt--)
	{
		if(++m_szMonth == 13)
			IncYear(), m_szMonth = 1;
	}

	return *this;
}

TDateTime& TDateTime::IncYear(size_t szAmt)
{
	m_szYear += szAmt;

	return *this;
}

// Aligning
TDateTime& TDateTime::AlignToSec()
{
	return *this;
}

TDateTime& TDateTime::AlignToMin()
{
	m_szSec = 0, AlignToSec();

	return *this;
}

TDateTime& TDateTime::AlignToHour()
{
	m_szMin = 0, AlignToMin();

	return *this;
}

TDateTime& TDateTime::AlignToDay()
{
	m_szHour = 0, AlignToHour();

	return *this;
}

TDateTime& TDateTime::AlignToMonth()
{
	m_szDay = 1, AlignToDay();

	return *this;
}

TDateTime& TDateTime::AlignToYear()
{
	m_szMonth = 1, AlignToMonth();

	return *this;
}

// Operators
TDateTime::operator QWORD () const
{
	return ((((QWORD)(m_szYear - 1) * 365 + GetNumLeapYearsBefore() +
				GetTotalMonthDaysBefore() +
					(m_szDay - 1)) * 24 +
						m_szHour) * 60 +
							m_szMin) * 60 +
								m_szSec;
}

TDateTime::operator KString () const
{
	return KString::Formatted(	TEXT("%u %u %u %u %u %u"),
									m_szYear,
									m_szMonth,
									m_szDay,
									m_szHour,
									m_szMin,
									m_szSec);
}

// Other
KString TDateTime::FormatTime(size_t szTime)
{
	return KString::Formatted(	TEXT("%.2u:%.2u:%.2u"),
									(szTime / 3600),
									(szTime % 3600) / 60,
									(szTime) % 60);
}

// ----------------
// Global routines
// ----------------
bool FromString(const KString& String, TDateTime& RDateTime)
{
	const KString& TrimmedString = String.Trim();

	if(_stscanf(TrimmedString,
				TEXT("%u %u %u %u %u %u"),
					&RDateTime.m_szYear,
					&RDateTime.m_szMonth,
					&RDateTime.m_szDay,
					&RDateTime.m_szHour,
					&RDateTime.m_szMin,
					&RDateTime.m_szSec) != 6)
	{
		return false;
	}
	
	return RDateTime.IsValid();
}
