#ifndef basic_bitypes_h
#define basic_bitypes_h

#include "basic_types.h"
#include "basic_wintypes.h"
#include "kstring.h"
#include "bounding.h"
#include "alignment.h"

// ------
// Point
// ------
template <class t>
struct TPoint
{
private:
	void WinCopy(const POINT& SPoint) { x = (t)SPoint.x, y = (t)SPoint.y; }
	
public:
	t x;
	t y;


	TPoint() {}

	TPoint(const TPoint<t>&	SPoint) : x(SPoint.x), y(SPoint.y) {}
	TPoint(const POINT& SPoint) { WinCopy(SPoint); }
	TPoint(t sx, t sy) : x(sx), y(sy) {}

	void Set(t sx, t sy) { x=sx, y=sy; }

	bool IsValid() const { return true; }
	
	TPoint<t>& operator = (const TPoint<t>& SPoint)
	{
		x = SPoint.x;
		y = SPoint.y;

		return *this;
	}

	TPoint<t>& operator = (const POINT& SPoint) { WinCopy(SPoint); return *this; }

	bool operator == (const TPoint<t>& SPoint) const
	{
		return	Compare(x, SPoint.x) == 0 &&
				Compare(y, SPoint.y) == 0;
	}
	
	bool operator != (const TPoint<t>& SPoint) const
	{
		return	Compare(x, SPoint.x) != 0 ||
				Compare(y, SPoint.y) != 0;
	}

	TPoint<t>& operator -= (const TPoint<t>& SPoint)
	{
		x -= SPoint.x;
		y -= SPoint.y;

		return *this;
	}

	TPoint<t>& operator += (const TPoint<t>& SPoint)
	{
		x += SPoint.x;
		y += SPoint.y;
		
		return *this;
	}

	TPoint<t>& operator *= (float fValue)
	{
		x *= fValue;
		y *= fValue;

		return *this;
	}

	TPoint<t>& operator /= (float fValue)
	{
		return *this *= (1.0f / fValue);
	}

	TPoint<t> operator - () const
	{
		return TPoint<t>(-x, -y);
	}

	TPoint<t> operator - (const TPoint<t>& SPoint) const
	{
		return TPoint<t>(x - SPoint.x, y - SPoint.y);
	}

	TPoint<t> operator + (const TPoint<t>& SPoint) const
	{
		return TPoint<t>(x + SPoint.x, y + SPoint.y);
	}
	
	TPoint<t> operator * (float fValue) const
	{
		return TPoint<t>((t)(x * fValue), (t)(y * fValue));
	}
	
	TPoint<t> operator / (float fValue) const
	{
		return *this * (1.0f / fValue);
	}

	operator POINT* () { return (POINT*)this; }
	operator const POINT* () const { return (const POINT*)this; }	

	bool IsNegative() const
	{
		return	Compare(x, (t)0) < 0 &&
				Compare(y, (t)0) < 0;
	}

	bool IsPositive() const
	{
		return	Compare(x, (t)0) > 0 &&
				Compare(y, (t)0) > 0;
	}

	operator KString () const
	{
		KString Ret;

		Ret += TEXT("(");
		Ret += x;
		Ret += TEXT(";");
		Ret += y;
		Ret += TEXT(")");

		return Ret;
	}
};

// -----
// Rect
// -----
template <class t>
struct TRect
{
private:
	void WinCopy(const RECT& SRect)
	{
		m_Left		= (t)SRect.left;
		m_Top		= (t)SRect.top;
		m_Right		= (t)SRect.right;
		m_Bottom	= (t)SRect.bottom;
	}

public:
	t m_Left;
	t m_Top;
	t m_Right;
	t m_Bottom;


	TRect() {}

	TRect(const TRect<t>& SRect) :
		m_Left	(SRect.m_Left),
		m_Top	(SRect.m_Top),
		m_Right	(SRect.m_Right),
		m_Bottom(SRect.m_Bottom) {}
		
	TRect(const RECT& SRect)
		{ WinCopy(SRect); }

	TRect(t SLeft, t STop, t SRight, t SBottom) :
		m_Left(SLeft), m_Top(STop), m_Right(SRight), m_Bottom(SBottom) {}

	TRect(const TPoint<t>& Point1, const TPoint<t>& Point2) :
		m_Left(Point1.x), m_Top(Point1.y), m_Right(Point2.x), m_Bottom(Point2.y)
	{
		OrientateRect(*this);
	}

	TRect<t>& Set(t SLeft, t STop, t SRight, t SBottom)
	{
		m_Left		= SLeft;
		m_Top		= STop;
		m_Right		= SRight;
		m_Bottom	= SBottom;

		return *this;
	}

	TRect<t>& Set(const TPoint<t>& p1, const TPoint<t>& p2)
	{
		m_Left		= p1.x;
		m_Top		= p1.y;
		m_Right		= p2.x;
		m_Bottom	= p2.y;

		return *this;
	}

	bool IsFlat() const
	{
		return	Compare(m_Left,	m_Right)	== 0 ||
				Compare(m_Top,	m_Bottom)	== 0;
	}

	bool IsPoint() const
	{
		return	Compare(m_Left,	m_Right)	== 0 &&
				Compare(m_Top,	m_Bottom)	== 0;
	}

	bool IsValid() const
	{
		return	Compare(m_Left,	m_Right)	< 0 &&
				Compare(m_Top,	m_Bottom)	< 0;
	}

	bool IsFlatValid() const
	{
		return	Compare(m_Left,	m_Right)	<= 0 &&
				Compare(m_Top,	m_Bottom)	<= 0;
	}

	void Invalidate() { m_Left = 0, m_Right = 0, m_Top = 0, m_Bottom = 0; }

	TRect<t>& operator = (const TRect<t>&SRect)
	{
		m_Left		= SRect.m_Left;
		m_Top		= SRect.m_Top;
		m_Right		= SRect.m_Right;
		m_Bottom	= SRect.m_Bottom;

		return *this;
	}

	TRect<t>& operator = (const RECT& SRect) { WinCopy(SRect); return *this; }

	bool operator == (const TRect<t>& SRect) const
	{
		return	Compare(m_Left,		SRect.m_Left)	== 0 &&
				Compare(m_Top,		SRect.m_Top)	== 0 &&
				Compare(m_Right,	SRect.m_Right)	== 0 &&
				Compare(m_Bottom,	SRect.m_Bottom)	== 0;
	}

	bool operator != (const TRect<t>& SRect) const
	{
		return	Compare(m_Left,		SRect.m_Left)	!= 0 ||
				Compare(m_Top,		SRect.m_Top)	!= 0 ||
				Compare(m_Right,	SRect.m_Right)	!= 0 ||
				Compare(m_Bottom,	SRect.m_Bottom)	!= 0;
	}

	TRect<t>& operator -= (const TRect<t>& SRect)
	{
		m_Left		-= SRect.m_Left;
		m_Top		-= SRect.m_Top;
		m_Right		-= SRect.m_Right;
		m_Bottom	-= SRect.m_Bottom;

		return *this;
	}

	TRect<t>& operator += (const TRect<t>& SRect)
	{
		m_Left		+= SRect.m_Left;
		m_Top		+= SRect.m_Top;
		m_Right		+= SRect.m_Right;
		m_Bottom	+= SRect.m_Bottom;

		return *this;
	}

	TRect<t>& operator *= (float fValue)
	{
		m_Left		*= fValue;
		m_Top		*= fValue;
		m_Right		*= fValue;
		m_Bottom	*= fValue;

		return *this;
	}

	TRect<t>& operator /= (float fValue)
	{
		return *this *= (1.0f / fValue);
	}

	TRect<t> operator - () const // deorients
	{
		return TRect<t>((t)-m_Left,
						(t)-m_Top,
						(t)-m_Right,
						(t)-m_Bottom);
	}

	TRect<t> operator - (const TRect<t>& SRect) const
	{
		return TRect<t>(m_Left		- SRect.m_Left,
						m_Top		- SRect.m_Top,
						m_Right		- SRect.m_Right,
						m_Bottom	- SRect.m_Bottom);
	}

	TRect<t> operator + (const TRect<t>& SRect) const
	{
		return TRect<t>(m_Left		+ SRect.m_Left,
						m_Top		+ SRect.m_Top,
						m_Right		+ SRect.m_Right,
						m_Bottom	+ SRect.m_Bottom);
	}

	TRect<t> operator * (float fValue) const
	{
		return TRect<t>((t)(m_Left		* fValue),
						(t)(m_Top		* fValue),
						(t)(m_Right		* fValue),
						(t)(m_Bottom	* fValue));
	}

	TRect<t> operator / (float fValue) const
	{
		return *this * (1.0f / fValue);
	}

	operator RECT*			()			{ return (RECT*)		this; }
	operator const RECT*	() const	{ return (const RECT*)	this; }

	bool IsNegative() const
	{
		return	Compare(m_Left,		(t)0) < 0 &&
				Compare(m_Top,		(t)0) < 0 &&
				Compare(m_Right,	(t)0) < 0 &&
				Compare(m_Bottom,	(t)0) < 0;
	}

	bool IsPositive() const
	{
		return	Compare(m_Left,		(t)0) > 0 &&
				Compare(m_Top,		(t)0) > 0 &&
				Compare(m_Right,	(t)0) > 0 &&
				Compare(m_Bottom,	(t)0) > 0;
	}

	t GetWidth	() const { return m_Right - m_Left; }
	t GetHeight	() const { return m_Bottom - m_Top; }

	t GetSquare() const { return GetWidth() * GetHeight(); }

	t GetCenterX() const { return (m_Left + m_Right) / 2; }
	t GetCenterY() const { return (m_Top + m_Bottom) / 2; }

	TPoint<t> GetCenter() const { return TPoint<t>(GetCenterX(), GetCenterY()); }

	operator KString () const
	{
		KString Ret;

		Ret += TEXT("[");
		Ret += m_Left;
		Ret += TEXT(";");
		Ret += m_Top;
		Ret += TEXT(" - ");
		Ret += m_Right;
		Ret += TEXT(";");
		Ret += m_Bottom;
		Ret += TEXT(")");

		return Ret;
	}
};

// -----
// Size
// -----
template <class t>
struct TSize
{
private:
	void WinCopy(const SIZE& SSize) { cx = (t)SSize.cx, cy = (t)SSize.cy; }

public:
	t cx;
	t cy;


	TSize() {}
	TSize(const TSize<t>& SSize) : cx(SSize.cx), cy(SSize.cy) {}
	TSize(const SIZE& SSize) { WinCopy(SSize); }
	TSize(t scx, t scy) : cx(scx), cy(scy) {}
	TSize(const TPoint<t>& Point1, const TPoint<t>& Point2) : cx(Point2.x - Point1.x), cy(Point2.y - Point1.y) {}
	TSize(const TRect<t>& Rect) : cx(Rect.m_Right - Rect.m_Left), cy(Rect.m_Bottom - Rect.m_Top) {}

	void Set(t scx, t scy) { cx=scx, cy=scy; }

	bool IsValid() const { return true; }

	bool IsFlat() const
	{
		return	Compare(cx, (t)0) == 0 ||
				Compare(cy, (t)0) == 0;
	}

	bool IsPoint() const
	{
		return	Compare(cx, (t)0) == 0 &&
				Compare(cy, (t)0) == 0;
	}

	t GetSquare() const { return cx * cy; }

	TSize<t>& operator = (const TSize<t>& SSize)
	{
		cx = SSize.cx;
		cy = SSize.cy;

		return *this;
	}

	TSize<t>& operator = (const SIZE& SSize)
		{ WinCopy(SSize); return *this; }

	TSize<t>& operator = (const TRect<t>& Rect)
	{
		cx = Rect.m_Right - Rect.m_Left;
		cy = Rect.m_Bottom - Rect.m_Top;

		return *this;
	}

	TSize<t>& operator -= (const TSize<t>& SSize)
	{
		cx -= SSize.cx;
		cy -= SSize.cy;

		return *this;
	}

	TSize<t>& operator += (const TSize<t>& SSize)
	{
		cx += SSize.cx;
		cy += SSize.cy;

		return *this;
	}

	TSize<t>& operator *= (float fValue)
	{
		cx *= fValue;
		cy *= fValue;

		return *this;
	}

	TSize<t>& operator /= (float fValue)
	{
		return *this *= (1.0f / fValue);
	}

	TSize<t> operator - () const
	{
		return TSize<t>(-cx, -cy);
	}

	TSize<t> operator - (const TSize<t>& SSize) const
	{
		return TSize<t>(cx - SSize.cx, cy - SSize.cy);
	}

	TSize<t> operator + (const TSize<t>& SSize) const
	{
		return TSize<t>(cx + SSize.cx, cy + SSize.cy);
	}

	TSize<t> operator * (float fValue) const
	{
		return TSize<t>((t)(cx * fValue), (t)(cy * fValue));
	}

	TSize<t> operator / (float fValue) const
	{
		return *this * (1.0f / fValue);;
	}

	// Warning: non-transitive comparisons
	bool operator == (const TSize<t>& SSize) const { return cx == SSize.cx && cy == SSize.cy; }
	bool operator != (const TSize<t>& SSize) const { return cx != SSize.cx || cy != SSize.cy; }

	operator SIZE*			() { return (SIZE*)			this; }
	operator const SIZE*	() { return (const SIZE*)	this; }	

	bool IsNegative() const
	{
		return	Compare(cx, (t)0) < 0 &&
				Compare(cy, (t)0) < 0;
	}

	bool IsFlatNegative() const
	{
		return	Compare(cx, (t)0) <= 0 &&
				Compare(cy, (t)0) <= 0;
	}

	bool IsPositive() const
	{
		return	Compare(cx, (t)0) > 0 &&
				Compare(cy, (t)0) > 0;
	}

	bool IsFlatPositive() const
	{
		return	Compare(cx, (t)0) >= 0 &&
				Compare(cy, (t)0) >= 0;
	}

	operator KString () const
	{
		KString Ret;

		Ret += TEXT("<");
		Ret += cx;
		Ret += TEXT(";");
		Ret += cy;
		Ret += TEXT(">");

		return Ret;
	}
};

// --------
// Segment
// --------
template <class t>
struct TSegment
{
	t m_First;
	t m_Last;

	
	TSegment() {}

	TSegment(const TSegment<t>& SSegment) :
		m_First	(SSegment.m_First),
		m_Last	(SSegment.m_Last) {}

	TSegment(t SFirst, t SLast) :
		m_First(SFirst), m_Last(SLast) {}

	void Set(t SFirst, t SLast) { m_First = SFirst, m_Last = SLast; }

	t GetLength() const { return m_Last - m_First; }

	bool IsValid() const { return Compare(m_First, m_Last) < 0; }

	bool IsFlatValid() const { return Compare(m_First, m_Last) <= 0; }

	bool IsFlat() const { return Compare(m_First, m_Last) == 0; }

	void Invalidate() { m_First = 0, m_Last = 0; }

	TSegment<t>& operator = (const TSegment<t>& SSegment)
	{
		m_First	= SSegment.m_First;
		m_Last	= SSegment.m_Last;
		
		return *this;
	}

	TSegment<t>& operator ++ ()
	{
		m_First++, m_Last++;
		return *this;
	}

	TSegment<t>& operator -- ()
	{
		m_First--, m_Last--;
		return *this;
	}

	TSegment<t>& operator -= (const TSegment<t>& SSegment)
	{
		m_First	-= SSegment.m_First;
		m_Last	-= SSegment.m_Last;

		return *this;
	}

	TSegment<t>& operator += (const TSegment<t>& SSegment)
	{
		m_First	+= SSegment.m_First;
		m_Last	+= SSegment.m_Last;

		return *this;
	}

	TSegment<t>& operator *= (float fValue)
	{
		m_First	*= fValue;
		m_Last	*= fValue;

		return *this;
	}

	TSegment<t>& operator /= (float fValue)
	{
		return *this *= (1.0f / fValue);
	}

	TSegment<t> operator - () const // deorients
	{
		return TSegment<t>((t)-m_First, (t)-m_Last);
	}

	TSegment<t> operator - (const TSegment<t>& SSegment) const
	{
		return TSegment<t>(	m_First	- SSegment.m_First,
							m_Last	- SSegment.m_Last);
	}

	TSegment<t> operator + (const TSegment<t>& SSegment) const
	{
		return TSegment<t>(	m_First	+ SSegment.m_First,
							m_Last	+ SSegment.m_Last);
	}

	TSegment<t> operator * (float fValue) const
	{
		return TSegment<t>(	(t)(m_First	* fValue),
							(t)(m_Last	* fValue));
	}

	TSegment<t> operator / (float fValue) const
	{
		return *this * (1.0f / fValue);
	}
	
	bool operator == (const TSegment<t>& SSegment) const
	{
		return	Compare(m_First,	SSegment.m_First)	== 0 &&
				Compare(m_Last,		SSegment.m_Last)	== 0;
	}

	bool operator != (const TSegment<t>& SSegment) const
	{
		return	Compare(m_First,	SSegment.m_First)	!= 0 ||
				Compare(m_Last,		SSegment.m_Last)	!= 0;
	}

	bool IsNegative() const
	{
		return	Compare(m_First,	(t)0) < 0 &&
				Compare(m_Last,		(t)0) < 0;
	}

	bool IsPositive() const
	{
		return	Compare(m_First,	(t)0) > 0 &&
				Compare(m_Last,		(t)0) > 0;
	}

	operator KString () const
	{
		KString Ret;

		Ret += TEXT("[");
		Ret += m_First;
		Ret += TEXT(";");
		Ret += m_Last;
		Ret += TEXT(")");

		return Ret;
	}
};

// -------------------
// Integer 64 structs
// -------------------
typedef TPoint	<__int64> I64POINT;
typedef TRect	<__int64> I64RECT;
typedef TSize	<__int64> I64SIZE;
typedef TSegment<__int64> I64SEGMENT;

// ----------------
// Integer structs
// ----------------
typedef TPoint	<int> IPOINT;
typedef TRect	<int> IRECT;
typedef TSize	<int> ISIZE;
typedef TSegment<int> ISEGMENT;

// --------------
// QWORD structs
// --------------
typedef TPoint	<QWORD> QWPOINT;
typedef TRect	<QWORD> QWRECT;
typedef TSize	<QWORD> QWSIZE;
typedef TSegment<QWORD> QWSEGMENT;

// ------------------
// Size type structs
// ------------------
typedef TPoint	<size_t> SZPOINT;
typedef TRect	<size_t> SZRECT;
typedef TSize	<size_t> SZSIZE;
typedef TSegment<size_t> SZSEGMENT;

// --------------
// Float structs
// --------------
typedef TPoint	<float> FPOINT;
typedef TRect	<float> FRECT;
typedef TSize	<float> FSIZE;
typedef TSegment<float> FSEGMENT;

// ---------------
// Double structs
// ---------------
typedef TPoint	<double> DPOINT;
typedef TRect	<double> DRECT;
typedef TSize	<double> DSIZE;
typedef TSegment<double> DSEGMENT;

// ------------------
// Alignment structs
// ------------------
typedef TPoint	<TAlignment> ALPOINT;
typedef TRect	<TAlignment> ALRECT;
typedef TSize	<TAlignment> ALSIZE;
typedef TSegment<TAlignment> ALSEGMENT;

// -------------
// Type structs
// -------------
typedef TPoint	<type_t> TPPOINT;
typedef TRect	<type_t> TPRECT;
typedef TSize	<type_t> TPSIZE;
typedef TSegment<type_t> TPSEGMENT;

// -------------
// Mode structs
// -------------
typedef TPoint	<mode_t> MDPOINT;
typedef TRect	<mode_t> MDRECT;
typedef TSize	<mode_t> MDSIZE;
typedef TSegment<mode_t> MDSEGMENT;

// -------------
// Flags structs
// -------------
typedef TPoint	<flags_t> FLPOINT;
typedef TRect	<flags_t> FLRECT;
typedef TSize	<flags_t> FLSIZE;
typedef TSegment<flags_t> FLSEGMENT;

// ----------------
// Global routines
// ----------------
template <class t>
inline bool HitsRect(const TPoint<t>& Point, const TRect<t>& Rect)
{
	return	Compare(Point.x, Rect.m_Left)	>= 0	&&
			Compare(Point.x, Rect.m_Right)	< 0		&&
			Compare(Point.y, Rect.m_Top)	>= 0	&&
			Compare(Point.y, Rect.m_Bottom)	< 0;
}

template <class t>
inline bool HitsRectBounds(const TPoint<t>& Point, const TRect<t>& Rect)
{
	return	Compare(Point.x, Rect.m_Left)	>= 0 &&
			Compare(Point.x, Rect.m_Right)	<= 0 &&
			Compare(Point.y, Rect.m_Top)	>= 0 &&
			Compare(Point.y, Rect.m_Bottom)	<= 0;
}

template <class t>
inline bool HitsSegment(const t& Value, const TSegment<t>& Segment)
{
	return	Compare(Value, Segment.m_First) >= 0 &&
			Compare(Value, Segment.m_Last)	< 0;
}

template <class t>
inline bool HitsSegmentBounds(const t& Value, const TSegment<t>& Segment)
{
	return	Compare(Value, Segment.m_First) >= 0 &&
			Compare(Value, Segment.m_Last)	<= 0;
}

template <class t, class ot>
inline TPoint<t>& ShiftPoint(TPoint<t>& Point, const TSize<ot>& Offset)
{
	Point.x += Offset.cx;
	Point.y += Offset.cy;

	return Point;
}

template <class t, class ot>
inline TRect<t>& ShiftRect(TRect<t>& Rect, const TSize<ot>& Offset)
{
	Rect.m_Left		+= Offset.cx;
	Rect.m_Top		+= Offset.cy;
	Rect.m_Right	+= Offset.cx;
	Rect.m_Bottom	+= Offset.cy;

	return Rect;
}

template <class t>
inline t& BoundValue(t& Value, const TSegment<t>& Segment)
{
	if(Compare(Value, Segment.m_First) < 0)
		Value = Segment.m_First;
	else if(Compare(Value, Segment.m_Last) > 0)
		Value = Segment.m_Last;
	
	return Value;
}

template <class t>
inline TPoint<t>& BoundPoint(TPoint<t>& Point, const TRect<t>& Rect)
{
	BoundValue(Point.x, TSegment<t>(Rect.m_Left, Rect.m_Right));
	BoundValue(Point.y, TSegment<t>(Rect.m_Top, Rect.m_Bottom));

	return Point;
}

template <class t>
inline TRect<t>& BoundRect(TRect<t>& Rect, const TRect<t>& Bound)
{
	TSegment<t> XSegment(Bound.m_Left,	Bound.m_Right);
	TSegment<t> YSegment(Bound.m_Top,	Bound.m_Bottom);

	BoundValue(Rect.m_Left,		XSegment);
	BoundValue(Rect.m_Top,		YSegment);
	BoundValue(Rect.m_Right,	XSegment);
	BoundValue(Rect.m_Bottom,	YSegment);

	return Rect;
}

template <class t>
inline t& ResizeValue(	const TSegment<t>&	SrcCoordsSegment,
						const TSegment<t>&	DstCoordsSegment,
						const t&			SrcValue,
						t&					RDstValue)
{
	t c = BOUNDC(SrcCoordsSegment.m_First, SrcCoordsSegment.m_Last, DstCoordsSegment.m_First, DstCoordsSegment.m_Last);

	RDstValue = BOUNDR(SrcValue, SrcCoordsSegment.m_First, DstCoordsSegment.m_First, c);

	return RDstValue;
}

template <class t>
inline t& ResizeValue(	const TSegment<t>&	SrcCoordsSegment,
						const TSegment<t>&	DstCoordsSegment,
						t&					Value)
{
	ResizeValue(SrcCoordsSegment, DstCoordsSegment, Value, Value);

	return Value;
}

template <class t>
inline TPoint<t>& ResizePoint(	const TRect<t>&		SrcCoordsRect,
								const TRect<t>&		DstCoordsRect,
								const TPoint<t>&	SrcPoint,
								TPoint<t>&			RDstPoint)
{
	if(SrcCoordsRect.IsValid() && DstCoordsRect.IsValid())
	{
		ResizeValue(TSegment<t>(SrcCoordsRect.m_Left, SrcCoordsRect.m_Right),
					TSegment<t>(DstCoordsRect.m_Left, DstCoordsRect.m_Right),
					SrcPoint.x,
					RDstPoint.x);

		ResizeValue(TSegment<t>(SrcCoordsRect.m_Top, SrcCoordsRect.m_Bottom),
					TSegment<t>(DstCoordsRect.m_Top, DstCoordsRect.m_Bottom),
					SrcPoint.y,
					RDstPoint.y);
	}
	else
	{
		RDstPoint.Set(0, 0);
	}

	return RDstPoint;
}

template <class t>
inline TPoint<t>& ResizePoint(	const TRect<t>&		SrcCoordsRect,
								const TRect<t>&		DstCoordsRect,
								TPoint<t>&			Point)
{
	ResizePoint(SrcCoordsRect, DstCoordsRect, Point, Point);

	return Point;
}

template <class t>
inline TSize<t>& ResizeSize(const TSize<t>& SrcCoordsSize,
							const TSize<t>& DstCoordsSize,
							const TSize<t>& SrcSize,
							TSize<t>&		RDstSize)
{
	if(!SrcCoordsSize.IsFlat())
	{
		RDstSize.cx = SrcSize.cx * DstCoordsSize.cx / SrcCoordsSize.cx;
		RDstSize.cy = SrcSize.cy * DstCoordsSize.cy / SrcCoordsSize.cy;
	}
	else
	{
		RDstSize.Set(0, 0);
	}

	return RDstSize;
}

template <class t>
inline TSize<t>& ResizeSize(const TSize<t>& SrcCoordsSize,
							const TSize<t>& DstCoordsSize,
							TSize<t>&		Size)
{
	ResizeSize(SrcCoordsSize, DstCoordsSize, Size, Size);

	return Size;
}

template <class t>
inline TRect<t>& ResizeRect(const TRect<t>&	SrcCoordsRect,
							const TRect<t>&	DstCoordsRect,
							const TRect<t>&	SrcRect,
							TRect<t>&		RDstRect)
{
	if(SrcCoordsRect.IsValid() && DstCoordsRect.IsValid() && SrcRect.IsValid())
	{
		t cx = BOUNDC(SrcCoordsRect.m_Left,	SrcCoordsRect.m_Right,	DstCoordsRect.m_Left,	DstCoordsRect.m_Right);
		t cy = BOUNDC(SrcCoordsRect.m_Top,	SrcCoordsRect.m_Bottom,	DstCoordsRect.m_Top,	DstCoordsRect.m_Bottom);

		RDstRect.m_Left		= BOUNDR(SrcRect.m_Left,	SrcCoordsRect.m_Left,	DstCoordsRect.m_Left,	cx);
		RDstRect.m_Top		= BOUNDR(SrcRect.m_Top,		SrcCoordsRect.m_Top,	DstCoordsRect.m_Top,	cy);
		RDstRect.m_Right	= BOUNDR(SrcRect.m_Right,	SrcCoordsRect.m_Left,	DstCoordsRect.m_Left,	cx);
		RDstRect.m_Bottom	= BOUNDR(SrcRect.m_Bottom,	SrcCoordsRect.m_Top,	DstCoordsRect.m_Top,	cy);
	}
	else
	{
		RDstRect.Invalidate();
	}

	return RDstRect;
}

template <class t>
inline TRect<t>& ResizeRect(const TRect<t>&	SrcCoordsRect,
							const TRect<t>&	DstCoordsRect,
							TRect<t>&		Rect)
{
	ResizeRect(SrcCoordsRect, DstCoordsRect, Rect, Rect);

	return Rect;
}

template <class t>
inline bool FitSize(const TSize<t>&	ParentSize,
					const TSize<t>&	DefaultClientSize,
					TSize<t>&		RClientSize,
					bool			bScaleIfSmaller = false)
{
	if(	!bScaleIfSmaller &&
		(	DefaultClientSize.cx <= ParentSize.cx &&
			DefaultClientSize.cy <= ParentSize.cy))
	{
		RClientSize = DefaultClientSize;
		return false;
	}

	if(ParentSize.cx * DefaultClientSize.cy <= ParentSize.cy * DefaultClientSize.cx)
	{
		 RClientSize.cx = ParentSize.cx;
		 RClientSize.cy = DefaultClientSize.cx ? RClientSize.cx * DefaultClientSize.cy / DefaultClientSize.cx : 0;
	}
	else
	{
		RClientSize.cy = ParentSize.cy;
		RClientSize.cx = DefaultClientSize.cy ? RClientSize.cy * DefaultClientSize.cx / DefaultClientSize.cy : 0;
	}

	return true;
}

template <class t>
inline bool FitRect(const TRect<t>&	ParentRect,
					const TSize<t>&	DefaultClientSize,
					TRect<t>&		RClientRect,
					bool			bScaleIfSmaller = false)
{
	TSize<t> ClientSize;

	bool bScale = FitSize(	TSize<t>(ParentRect),
							DefaultClientSize,
							ClientSize,
							bScaleIfSmaller);

	RClientRect.m_Left		= ParentRect.	m_Left	+ (ParentRect.m_Right	- ParentRect.m_Left	- ClientSize.cx) / 2;
	RClientRect.m_Top		= ParentRect.	m_Top	+ (ParentRect.m_Bottom	- ParentRect.m_Top	- ClientSize.cy) / 2;
	RClientRect.m_Right		= RClientRect.	m_Left	+ ClientSize.cx;
	RClientRect.m_Bottom	= RClientRect.	m_Top	+ ClientSize.cy;

	return bScale;
}

template <class t>
inline size_t SubtractRect(const TRect<t>& Rect, const TRect<t>& SubRect, TRect<t> ResRects[4])
{
	if(!Rect.IsValid())
		return 0;

	TRect<t> IntSubRect = SubRect;
	if(IntersectRect(IntSubRect, Rect) == 0)
	{
		ResRects[0] = Rect;
		return 1;
	}

	size_t szN = 0;

	ResRects[szN].m_Left	= Rect.m_Left;
	ResRects[szN].m_Top		= Rect.m_Top;
	ResRects[szN].m_Right	= Rect.m_Right;
	ResRects[szN].m_Bottom	= IntSubRect.m_Top;
	if(ResRects[szN].IsValid())
		szN++;

	ResRects[szN].m_Left	= Rect.m_Left;
	ResRects[szN].m_Top		= IntSubRect.m_Top;
	ResRects[szN].m_Right	= IntSubRect.m_Left;
	ResRects[szN].m_Bottom	= IntSubRect.m_Bottom;
	if(ResRects[szN].IsValid())
		szN++;

	ResRects[szN].m_Left	= IntSubRect.m_Right;
	ResRects[szN].m_Top		= IntSubRect.m_Top;
	ResRects[szN].m_Right	= Rect.m_Right;
	ResRects[szN].m_Bottom	= IntSubRect.m_Bottom;
	if(ResRects[szN].IsValid())
		szN++;

	ResRects[szN].m_Left	= Rect.m_Left;
	ResRects[szN].m_Top		= IntSubRect.m_Bottom;
	ResRects[szN].m_Right	= Rect.m_Right;
	ResRects[szN].m_Bottom	= Rect.m_Bottom;
	if(ResRects[szN].IsValid())
		szN++;

	return szN;
}

template <class t>
inline size_t IntersectRect(TRect<t>& Rect, const TRect<t>& Bound)
{
	if(!Rect.IsValid())
		return 0;
	
	if(!Bound.IsValid())
	{
		Rect.Invalidate();
		return 0;
	}

	if(Compare(Rect.m_Left, Bound.m_Left) < 0)
		Rect.m_Left = Bound.m_Left;

	if(Compare(Rect.m_Top, Bound.m_Top) < 0)
		Rect.m_Top = Bound.m_Top;

	if(Compare(Rect.m_Right, Bound.m_Right) > 0)
		Rect.m_Right = Bound.m_Right;

	if(Compare(Rect.m_Bottom, Bound.m_Bottom) > 0)
		Rect.m_Bottom = Bound.m_Bottom;

	return Rect.IsValid() ? 1 : 0;
}

template <class t>
inline TRect<t>& CoverRect(TRect<t>& Rect1, const TRect<t>& Rect2)
{
	if(Rect2.m_Left < Rect1.m_Left)
		Rect1.m_Left = Rect2.m_Left;

	if(Rect2.m_Top < Rect1.m_Top)
		Rect1.m_Top = Rect2.m_Top;

	if(Rect2.m_Right > Rect1.m_Right)
		Rect1.m_Right = Rect2.m_Right;

	if(Rect2.m_Bottom > Rect1.m_Bottom)
		Rect1.m_Bottom = Rect2.m_Bottom;

	return Rect1;
}

template <class t>
inline TRect<t>& LessenRect(TRect<t>& Rect, const TSize<t>& Offset)
{
	Rect.m_Left		+= Offset.cx;
	Rect.m_Top		+= Offset.cy;
	Rect.m_Right	-= Offset.cx;
	Rect.m_Bottom	-= Offset.cy;

	return Rect;
}

template <class t>
inline TRect<t>& OrientateRect(TRect<t>& Rect)
{
	t Temp;

	if(Compare(Rect.m_Left, Rect.m_Right) > 0)
		Temp = Rect.m_Left, Rect.m_Left = Rect.m_Right, Rect.m_Right = Temp;

	if(Compare(Rect.m_Top, Rect.m_Bottom) > 0)
		Temp = Rect.m_Top, Rect.m_Top = Rect.m_Bottom, Rect.m_Bottom = Temp;

	return Rect;
}

template <class t>
inline TRect<t>& DefaultizeRect(TRect<t>& Rect, const TSize<t>& MinSize)
{
	TSize<t> Size = Rect;

	if(GetAbs((Size.cx) < MinSize.cx))
		Rect.m_Right = Rect.m_Left + Sign1Dir(Size.cx, MinSize.cx);

	if(GetAbs(Size.cy) < MinSize.cy))
		Rect.m_Bottom = Rect.m_Top + Sign1Dir(Size.cy, MinSize.cy);

	return RECT;
}

template <class t>
inline bool RectsIntersect(const TRect<t>& Rect1, const TRect<t>& Rect2)
{
	return	Compare(Rect1.m_Top,	Rect2.m_Bottom)	< 0 &&
			Compare(Rect2.m_Top,	Rect1.m_Bottom)	< 0 &&
			Compare(Rect1.m_Left,	Rect2.m_Right)	< 0 &&
			Compare(Rect2.m_Left,	Rect1.m_Right)	< 0;
}

template <class t>
inline size_t WeldSegments(	TSegment<t>&		Segment,
							const TSegment<t>&	WeldSegment,
							TSegment<t>*		pSegment2 = NULL)
{
	if(!Segment.IsValid())
	{
		if(!WeldSegment.IsValid())
			return 0;

		Segment = WeldSegment;
		return 1;
	}
	
	if(!WeldSegment.IsValid())
		return 1;

	if(	Compare(Segment.m_First, WeldSegment.m_Last) > 0 ||
		Compare(Segment.m_Last, WeldSegment.m_First) < 0)
	{
		if(pSegment2)
			*pSegment2 = WeldSegment;

		return 2;
	}

	if(Compare(WeldSegment.m_First, Segment.m_First) < 0)
		Segment.m_First = WeldSegment.m_First;

	if(Compare(WeldSegment.m_Last, Segment.m_Last) > 0)
		Segment.m_Last = WeldSegment.m_Last;

	return 1;
}

template <class t>
inline size_t SubtractSegments(	TSegment<t>&		Segment,
								const TSegment<t>&	SubSegment,
								TSegment<t>*		pSegment2 = NULL)
{
	if(!Segment.IsValid())
		return 0;

	if(	!SubSegment.IsValid() ||
		(	Compare(Segment.m_Last, SubSegment.m_First) <= 0 ||
			Compare(Segment.m_First, SubSegment.m_Last) <= 0))
	{
		return 1;
	}

	if(	Compare(Segment.m_First,	SubSegment.m_First)	< 0 &&
		Compare(Segment.m_Last,		SubSegment.m_Last)	> 0)
	{
		if(pSegment2)
			pSegment2->m_First = SubSegment.m_Last, pSegment2->m_Last = Segment.m_Last;

		Segment.m_Last = SubSegment.m_First;
		
		return 2;
	}

	if(Compare(Segment.m_First, SubSegment.m_First) < 0)
		Segment.m_Last = SubSegment.m_First;
	else if(Compare(Segment.m_Last, SubSegment.m_Last) > 0)
		Segment.m_First = SubSegment.m_Last;
	else
		return 0;

	return 1;
}

template <class t>
inline size_t IntersectSegments(TSegment<t>&		Segment,
								const TSegment<t>&	IntSegment)
{
	if(!Segment.IsValid())
		return 0;

	if(	!IntSegment.IsValid() ||
		(	Compare(Segment.m_Last, IntSegment.m_First) <= 0 ||
			Compare(Segment.m_First, IntSegment.m_Last) >= 0))
	{
		return 0;
	}

	if(Compare(Segment.m_First, IntSegment.m_First) < 0)
		Segment.m_First = IntSegment.m_First;

	if(Compare(Segment.m_Last, IntSegment.m_Last) > 0)
		Segment.m_Last = IntSegment.m_Last;

	return 1;
}

template <class t>
inline bool DoSegmentsIntersect(TSegment<t>& Segment1, TSegment<t>& Segment2)
{
	return IntersectSegments(TSegment<t>(Segment1), Segment2) > 0;
}

// --------------------------
// Global alignment routines
// --------------------------
template <class t>
inline t Align(t Value, t Width, TAlignment Alignment)
{
	if(Alignment == ALIGNMENT_MIN)
		return Value;

	if(Alignment == ALIGNMENT_MID)
		return Width / 2;

	if(Alignment == ALIGNMENT_MAX)
		return Width - Value;

	INITIATE_FAILURE;
}

template <class t>
inline t Dealign(t Value, t Width, TAlignment Alignment)
{
	if(Alignment == ALIGNMENT_MIN)
		return Value;

	if(Alignment == ALIGNMENT_MID)
		return Value - Width / 2;

	if(Alignment == ALIGNMENT_MAX)
		return Value - Width;

	INITIATE_FAILURE;
}

template <class t>
inline t GetAlignedOrigin(	const TSegment<t>&	Segment,
							t					Width,
							TAlignment			Alignment)
{
	if(Alignment == ALIGNMENT_MIN)
		return Segment.m_First;

	if(Alignment == ALIGNMENT_MID)
		return (Segment.m_First + Segment.m_Last - Width) / 2;

	if(Alignment == ALIGNMENT_MAX)
		return Segment.m_Last - Width;

	INITIATE_FAILURE;
}

template <class t>
inline TPoint<t> GetAlignedOrigin(	const TRect<t>&	Rect,
									const TSize<t>	Size,
									const ALSIZE&	Alignment)
{
	return TPoint<t>(	GetAlignedOrigin(	TSegment<t>(Rect.m_Left, Rect.m_Right),
											Size.cx,
											Alignment.cx),
						GetAlignedOrigin(	TSegment<t>(Rect.m_Top, Rect.m_Bottom),
											Size.cy,
											Alignment.cy));
}

// -------------------------
// Global make-abs routines
// -------------------------
template <class t>
inline TPoint<t>& MakeAbs(TPoint<t>& Point)
{
	MakeAbs(Point.x);
	MakeAbs(Point.y);

	return Point;
}

template <class t>
inline TSize<t>& MakeAbs(TSize<t>& Size)
{
	MakeAbs(Size.cx);
	MakeAbs(Size.cy);

	return Size;
}

template <class t>
inline TRect<t>& MakeAbs(TRect<t>& Rect)
{
	MakeAbs(Rect.m_Left);
	MakeAbs(Rect.m_Top);
	MakeAbs(Rect.m_Right);
	MakeAbs(Rect.m_Bottom);

	return Rect;
}

template <class t>
inline TSegment<t>& MakeAbs(TSegment<t>& Segment)
{
	MakeAbs(Segment.m_First);
	MakeAbs(Segment.m_Last);

	return Segment;
}

// -------------------------
// Global round-up routines
// -------------------------
template <class t>
inline TPoint<t> RoundUp(TPoint<t>& Point)
{
	RoundUp(Point.x);
	RoundUp(Point.y);

	return Point;
}

template <class t>
inline TSize<t>& RoundUp(TSize<t>& Size)
{
	RoundUp(Size.cx);
	RoundUp(Size.cy);

	return Size;
}

template <class t>
inline TRect<t>& RoundUp(TRect<t>& Rect)
{
	RoundUp(Rect.m_Left);
	RoundUp(Rect.m_Top);
	RoundUp(Rect.m_Right);
	RoundUp(Rect.m_Bottom);

	return Rect;
}

template <class t>
inline TSegment<t>& RoundUp(TSegment<t>& Segment)
{
	RoundUp(Segment.m_First);
	RoundUp(Segment.m_Last);

	return Segment;
}

// ---------------------------
// Global transition routines
// ---------------------------
template <class t>
inline t& GenerateLinearTransition(	const t&	State1,
									const t&	State2,
									float		fTransition,
									t&			RState)
{
	return (((RState = State2) -= State1) *= fTransition) += State1;
}

// ------------------------
// Basic bitypes streaming
// ------------------------
template <class t>
inline TStream& operator >> (TStream& Stream, TPoint<t>& RPoint)
{
	return Stream >> RPoint.x >> RPoint.y;
}

template <class t>
inline TStream& operator << (TStream& Stream, const TPoint<t>& Point)
{
	return Stream << Point.x << Point.y;
}

template <class t>
inline TStream& operator >> (TStream& Stream, TRect<t>& RRect)
{
	return Stream >> RRect.m_Left >> RRect.m_Top >> RRect.m_Right >> RRect.m_Bottom;
}

template <class t>
inline TStream& operator << (TStream& Stream, const TRect<t>& Rect)
{
	return Stream << Rect.left << Rect.top << Rect.right << Rect.bottom;
}

template <class t>
inline TStream& operator >> (TStream& Stream, TSize<t>& RSize)
{
	return Stream >> RSize.cx >> RSize.cy;
}

template <class t>
inline TStream& operator << (TStream& Stream, const TSize<t>& Size)
{
	return Stream << Size.cx << Size.cy;
}

template <class t>
inline TStream& operator >> (TStream& Stream, TSegment<t>& RSegment)
{
	return Stream >> RSegment.m_First >> RSegment.m_Last;
}

template <class t>
inline TStream& operator << (TStream& Stream, const TSegment<t>& Segment)
{
	return Stream << Segment.m_First << Segment.m_Last;
}

// -----------------------
// Cross-type conversions
// -----------------------

// I64
template <class t>
inline I64POINT TO_I64(const TPoint<t>& Point)
{
	return I64POINT((__int64)Point.x, (__int64)Point.y);
}

template <class t>
inline I64RECT TO_I64(const TRect<t>& Rect)
{
	return I64RECT(	(__int64)Rect.m_Left,
					(__int64)Rect.m_Top,
					(__int64)Rect.m_Right,
					(__int64)Rect.m_Bottom);
}

template <class t>
inline I64SIZE TO_I64(const TSize<t>& Size)
{
	return I64SIZE((__int64)Size.cx, (__int64)Size.cy);
}

template <class t>
inline I64SEGMENT TO_I64(const TSegment<t>& Segment)
{
	return I64SEGMENT((__int64)Segment.m_First, (__int64)Segment.m_Last);
}

// I
template <class t>
inline IPOINT TO_I(const TPoint<t>& Point)
{
	return IPOINT((int)Point.x, (int)Point.y);
}

template <class t>
inline IRECT TO_I(const TRect<t>& Rect)
{
	return IRECT(	(int)Rect.m_Left,
					(int)Rect.m_Top,
					(int)Rect.m_Right,
					(int)Rect.m_Bottom);
}

template <class t>
inline ISIZE TO_I(const TSize<t>& Size)
{
	return ISIZE((int)Size.cx, (int)Size.cy);
}

template <class t>
inline ISEGMENT TO_I(const TSegment<t>& Segment)
{
	return ISEGMENT((int)Segment.m_First, (int)Segment.m_Last);
}

// QW
template <class t>
inline QWPOINT TO_QW(const TPoint<t>& Point)
{
	return QWPOINT((QWORD)Point.x, (QWORD)Point.y);
}

template <class t>
inline QWRECT TO_QW(const TRect<t>& Rect)
{
	return QWRECT(	(QWORD)Rect.m_Left,
					(QWORD)Rect.m_Top,
					(QWORD)Rect.m_Right,
					(QWORD)Rect.m_Bottom);
}

template <class t>
inline QWSIZE TO_QW(const TSize<t>& Size)
{
	return QWSIZE((QWORD)Size.cx, (QWORD)Size.cy);
}

template <class t>
inline QWSEGMENT TO_QW(const TSegment<t>& Segment)
{
	return QWSEGMENT((QWORD)Segment.m_First, (QWORD)Segment.m_Last);
}

// SZ
template <class t>
inline SZPOINT TO_SZ(const TPoint<t>& Point)
{
	return SZPOINT((size_t)Point.x, (size_t)Point.y);
}

template <class t>
inline SZRECT TO_SZ(const TRect<t>& Rect)
{
	return SZRECT(	(size_t)Rect.m_Left,
					(size_t)Rect.m_Top,
					(size_t)Rect.m_Right,
					(size_t)Rect.m_Bottom);
}

template <class t>
inline SZSIZE TO_SZ(const TSize<t>& Size)
{
	return SZSIZE((size_t)Size.cx, (size_t)Size.cy);
}

template <class t>
inline SZSEGMENT TO_SZ(const TSegment<t>& Segment)
{
	return SZSEGMENT((size_t)Segment.m_First, (size_t)Segment.m_Last);
}

// F
template <class t>
inline FPOINT TO_F(const TPoint<t>& Point)
{
	return FPOINT((float)Point.x, (float)Point.y);
}

template <class t>
inline FRECT TO_F(const TRect<t>& Rect)
{
	return FRECT(	(float)Rect.m_Left,
					(float)Rect.m_Top,
					(float)Rect.m_Right,
					(float)Rect.m_Bottom);
}

template <class t>
inline FSIZE TO_F(const TSize<t>& Size)
{
	return FSIZE((float)Size.cx, (float)Size.cy);
}

template <class t>
inline FSEGMENT TO_F(const TSegment<t>& Segment)
{
	return FSEGMENT((float)Segment.m_First, (float)Segment.m_Last);
}

// D
template <class t>
inline DPOINT TO_D(const TPoint<t>& Point)
{
	return DPOINT((double)Point.x, (double)Point.y);
}

template <class t>
inline DRECT TO_D(const TRect<t>& Rect)
{
	return DRECT(	(double)Rect.m_Left,
					(double)Rect.m_Top,
					(double)Rect.m_Right,
					(double)Rect.m_Bottom);
}

template <class t>
inline DSIZE TO_D(const TSize<t>& Size)
{
	return DSIZE((double)Size.cx, (double)Size.cy);
}

template <class t>
inline DSEGMENT TO_D(const TSegment<t>& Segment)
{
	return DSEGMENT((double)Segment.m_First, (double)Segment.m_Last);
}

// POINT
template <class t>
inline TPoint<t> TO_POINT(const TSize<t>& s)
{
	return TPoint<t>(s.cx, s.cy);
}

// SIZE
template <class t>
inline TSize<t> TO_SIZE(const TPoint<t>& s)
{
	return TSize<t>(s.x, s.y);
}

#endif // basic_bitypes_h