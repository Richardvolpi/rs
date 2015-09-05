#ifndef vector_h
#define vector_h

#include <math.h>
#include "kfc_Common_api.h"

struct TMatrix44;

// ---------
// Vector 3
// ---------
struct TVector3
{
	union
	{
		struct
		{
			float x, y, z;
		};
		
		float v[3];
	};

	TVector3() {}

	TVector3(const TVector3& SVector) : x(SVector.x), y(SVector.y), z(SVector.z) {}

	TVector3(float sx, float sy, float sz) : x(sx), y(sy), z(sz) {}

	TVector3(float sxyz) : x(sxyz), y(sxyz), z(sxyz) {}

	TVector3& SetZero()
	{
		x=0.0f, y=0.0f, z=0.0f;
		return *this;
	}

	TVector3& Set(float sx, float sy, float sz)
	{
		x=sx, y=sy, z=sz;
		return *this;
	}

	TVector3& SetXAxis(float sx = 1.0f)
	{
		x=sx, y=0.0f, z=0.0f;
		return *this;
	}

	TVector3& SetYAxis(float sy = 1.0f)
	{
		x=0.0f, y=sy, z=0.0f;
		return *this;
	}

	TVector3& SetZAxis(float sz = 1.0f)
	{
		x=0.0f, y=0.0f, z=sz;
		return *this;
	}

	float GetLengthSquare	() const { return x*x + y*y + z*z;			}
	float GetLength			() const { return sqrtf(GetLengthSquare());	}

	TVector3 Normalized() const { return TVector3(*this) /= GetLength(); }
	
	void Normalize() { *this /= GetLength(); }
	
	// Const operators
	TVector3 operator + (const TVector3& SVector) const
		{ return TVector3(x + SVector.x, y + SVector.y, z + SVector.z); }

	TVector3 operator - (const TVector3& SVector) const
		{ return TVector3(x - SVector.x, y - SVector.y, z - SVector.z); }

	float operator & (const TVector3& SVector) const
		{ return x * SVector.x + y * SVector.y + z * SVector.z; }
	
	TVector3 operator * (const TVector3& SVector) const
		{ return TVector3(	y * SVector.z - z * SVector.y,
							z * SVector.x - x * SVector.z,
							x * SVector.y - y * SVector.x); }

	TVector3 operator * (float c) const
		{ return TVector3(x * c, y * c, z * c); }

	TVector3 operator / (float c) const
		{ return *this * (1.0f / c); }

	KFC_COMMON_API TVector3 operator * (const TMatrix44& Matrix) const;

	KFC_COMMON_API TVector3 operator & (const TMatrix44& Matrix) const;

	TVector3& operator = (const TVector3& SVector)
		{ x=SVector.x, y=SVector.y, z=SVector.z; return *this; }

	// Non-const operators
	TVector3& operator += (const TVector3& SVector)
		{ x += SVector.x, y += SVector.y, z += SVector.z; return *this; }

	TVector3& operator -= (const TVector3& SVector)
		{ x -= SVector.x, y -= SVector.y, z -= SVector.z; return *this; }

	TVector3& operator *= (const TVector3& SVector)
		{ return *this = *this * SVector; }

	TVector3& operator *= (float c)
		{ x *= c, y *= c, z *= c; return *this; }

	TVector3& operator /= (float c)
		{ return *this *= (1.0f / c); }

	TVector3& operator *= (const TMatrix44& Matrix)
		{ return *this = *this * Matrix; }

	TVector3& operator &= (const TMatrix44& Matrix)
		{ return *this = *this & Matrix; }

	// Comparison operators
	bool operator == (const TVector3& SVector) const
		{ return x==SVector.x && y==SVector.y && z==SVector.z; }

	bool operator != (const TVector3& SVector) const
		{ return x!=SVector.x || y!=SVector.y || z!=SVector.z; }
};

// Debug operators
inline TDebugFile& operator << (TDebugFile& DebugFile, const TVector3& Vector)
{
	return	DebugFile	<< TEXT("(") <<
			Vector.x	<< TEXT(";") <<
			Vector.y	<< TEXT(";") <<
			Vector.z	<< TEXT(")");
}

#endif // vector_h
