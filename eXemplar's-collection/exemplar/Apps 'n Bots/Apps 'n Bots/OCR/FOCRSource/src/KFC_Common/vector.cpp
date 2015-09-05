#include "kfc_common_pch.h"
#include "vector.h"

#include "matrix.h"

// ---------
// Vector 3
// ---------
TVector3 TVector3::operator * (const TMatrix44& Matrix) const
{
	return TVector3(x * Matrix._11 + y * Matrix._21 + z * Matrix._31 + Matrix._41,
					y * Matrix._12 + y * Matrix._22 + z * Matrix._32 + Matrix._42,
					z * Matrix._13 + y * Matrix._23 + z * Matrix._33 + Matrix._43);
}

TVector3 TVector3::operator & (const TMatrix44& Matrix) const
{
	return TVector3(x * Matrix._11 + y * Matrix._21 + z * Matrix._31,
					y * Matrix._12 + y * Matrix._22 + z * Matrix._32,
					z * Matrix._13 + y * Matrix._23 + z * Matrix._33);
}
