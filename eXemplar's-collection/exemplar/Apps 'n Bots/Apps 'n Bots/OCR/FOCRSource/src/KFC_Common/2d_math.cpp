#include "kfc_common_pch.h"
#include "2d_math.h"

// ----------------
// Global routines
// ----------------
bool SolveLinearEquations22(float a1, float b1, float c1,
							float a2, float b2, float c2,
							float& x, float& y)
{
	const float d = a1 * b2 - a2 * b1;
	if(Compare(d, 0.0f) == 0)
		return false;

	const float d1 = c1 * b2 - c2 * b1;
	const float d2 = a1 * c2 - a2 * c1;

	x = d1 / d;
	y = d2 / d;

	return true;
}

float GetLineDist2(float a, float b, float c, const FPOINT& p)
{
	const float d = a * p.x + b * p.y - c;

	DEBUG_VERIFY(Compare(d, 0.0f));

	return (d * d) / (a * a + b * b);
}

float GetLineDist2(const FPOINT& lp1, const FPOINT& lp2, FPOINT& p)
{
	float a, b, c;
	GetLineCoefs(lp1, lp2, a, b, c);

	return GetLineDist2(a, b, c, p);
}

float GetSegmentDist2(const FPOINT& sp1, const FPOINT& sp2, const FPOINT& p)
{
	// End-points distances
	float d = Min(GetPointsDist2(sp1, p), GetPointsDist2(sp2, p));

	// Middle-poitn distance
	float a1, b1, c1;
	GetLineCoefs(sp1, sp2, a1, b1, c1);

	float a2, b2, c2;
	GetOrtoLineCoefs(a1, b1, c1, a2, b2, c2, p);

	float x, y;
	DEBUG_EVALUATE_VERIFY(SolveLinearEquations22(a1, b1, c1, a2, b2, c2, x, y));	

	if(	Compare(x, Min(sp1.x, sp2.x)) >= 0 &&
		Compare(x, Max(sp1.x, sp2.x)) <= 0 &&
		Compare(y, Min(sp1.y, sp2.y)) >= 0 &&
		Compare(y, Max(sp1.y, sp2.y)) <= 0) // on the segment
	{
		const float dd = GetPointsDist2(p, FPOINT(x, y));
		if(dd < d)
			d = dd;
	}

	return d;
}

double GetAngle(double dx, double dy)
{
	if(Compare(dx, 0.0) == 0)
	{
		if(Compare(dy, 0.0) == 0)
			return 0.0;

		return Compare(dy, 0.0) < 0 ? g_PI * 1.5 : g_PI * 0.5;
	}

	if(Compare(dx, 0.0) < 0)
		return g_PI + atan(dy / dx);

	return Compare(dy, 0.0) < 0 ? g_PI * 2.0 + atan(dy / dx) : atan(dy / dx);
}