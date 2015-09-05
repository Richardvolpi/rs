#ifndef _2d_math_h
#define _2d_math_h

#include "math_consts.h"

// ----------------
// Global routines
// ----------------
template <class t>
FPOINT GetFPOINT(const TPoint<t>& Point)
{
	return FPOINT(	(float)Point.x,
					(float)Point.y);
}

template <class t>
FRECT GetFRECT(const TRect<t>& Rect)
{
	return FRECT(	(float)Rect.m_Left,
					(float)Rect.m_Top,
					(float)Rect.m_Right,
					(float)Rect.m_Bottom);
}

template <class t>
FRECT GetFSIZE(const TSize<t>& Size)
{
	return FSIZE(	(float)Size.cx,
					(float)Size.cy);
}

template <class t>
FSEGMENT GetFSEGMENT(const TSegment<t>& Segment)
{
	return FSEGMENT(	(float)Segment.m_First,
						(float)Segment.m_Last);
}

template <class t>
inline t GetPointsDist2(const TPoint<t>& p1, const TPoint<t>& p2)
{
	const t dx = p1.x - p2.x;
	const t dy = p1.y - p2.y;

	return dx * dx + dy * dy;
}

template <class t>
inline void GetLineCoefs(const TPoint<t>& p1, const TPoint<t>& p2, t& a, t& b, t& c)
{
	a = p1.y - p2.y;
	b = p2.x - p1.x;
	c = p1.x * a + p1.y * b;
}

template <class t>
inline void GetOrtoLineCoefs(t a, t b, t c, t& a2, t& b2, t& c2, const TPoint<t>& p)
{
	a2 = -b;
	b2 = a;
	c2 = a2 * p.x + b2 * p.y;
}

bool SolveLinearEquations22(float a1, float b1, float c1,
							float a2, float b2, float c2,
							float& x, float& y);

KFC_COMMON_API float GetLineDist2(float a, float b, float c, const FPOINT& p);

KFC_COMMON_API float GetLineDist2(const FPOINT& lp1, const FPOINT& lp2, FPOINT& p);

KFC_COMMON_API float GetSegmentDist2(const FPOINT& sp1, const FPOINT& sp2, const FPOINT& p);

KFC_COMMON_API double GetAngle(double dx, double dy);

#endif // _2d_math_h