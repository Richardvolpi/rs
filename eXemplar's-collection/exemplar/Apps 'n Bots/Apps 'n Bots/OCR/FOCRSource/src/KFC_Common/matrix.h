#ifndef matrix_h
#define matrix_h

#include "vector.h"

// -----------
// Matrix 4x4
// -----------
struct TMatrix44
{
	union
	{
		struct
		{
			float _11, _12, _13, _14;
			float _21, _22, _23, _24;
			float _31, _32, _33, _34;
			float _41, _42, _43, _44;
		};

		float v[4][4];
	};

	TMatrix44() {}

	TMatrix44(const TMatrix44& SMatrix)
		{ memcpy(v, SMatrix.v, sizeof(v)); }

	TMatrix44(	float s_11, float s_12, float s_13, float s_14,
				float s_21, float s_22, float s_23, float s_24,
				float s_31, float s_32, float s_33, float s_34,
				float s_41, float s_42, float s_43, float s_44) :	_11(s_11), _12(s_12), _13(s_13), _14(s_14),
																	_21(s_21), _22(s_22), _23(s_23), _24(s_24),
																	_31(s_31), _32(s_32), _33(s_33), _34(s_34),
																	_41(s_41), _42(s_42), _43(s_43), _44(s_44) {}
	
	TMatrix44& SetZero()
	{
		memset(v, 0, sizeof(v));
		return *this;
	}

	TMatrix44& SetIdentity()
	{
		_11=1.0f, _12=0.0f, _13=0.0f, _14=0.0f;
		_21=0.0f, _22=1.0f, _23=0.0f, _24=0.0f;
		_31=0.0f, _32=0.0f, _33=1.0f, _34=0.0f;
		_41=0.0f, _42=0.0f, _43=0.0f, _44=1.0f;
		
		return *this;
	}

	TMatrix44& SetTranslation(const TVector3& Vector)
	{
		_11=1.0f, _12=0.0f, _13=0.0f, _14=0.0f;
		_21=0.0f, _22=1.0f, _23=0.0f, _24=0.0f;
		_31=0.0f, _32=0.0f, _33=1.0f, _34=0.0f;
		_41=Vector.x, _42=Vector.y, _43=Vector.z, _44=1.0f;

		return *this;
	}

	TMatrix44& SetScale(const TVector3& Vector)
	{
		_11=Vector.x, _12=0.0f, _13=0.0f, _14=0.0f;
		_21=0.0f, _22=Vector.y, _23=0.0f, _24=0.0f;
		_31=0.0f, _32=0.0f, _33=Vector.z, _34=0.0f;
		_41=0.0f, _42=0.0f, _43=0.0f, _44=1.0f;

		return *this;
	}

	TMatrix44& SetRotateX(float fAngle)
	{
		const float cs = cosf(fAngle);
		const float sn = sinf(fAngle);

		_11 = 1.0f, _12 = 0.0f, _13 = 0.0f, _14 = 0.0f;
		_21 = 0.0f, _22 =   cs, _23 =  -sn, _24 = 0.0f;
		_31 = 0.0f, _32 =   sn, _33 =   cs, _34 = 0.0f;
		_41 = 0.0f, _42 = 0.0f,	_43 = 0.0f, _44 = 1.0f;
		
		return *this;
	}

	TMatrix44& SetRotateY(float fAngle)
	{
		const float cs = cosf(fAngle);
		const float sn = sinf(fAngle);

		_11 =   cs, _12 = 0.0f, _13 =   sn, _14 = 0.0f;
		_21 = 0.0f, _22 = 1.0f, _23 = 0.0f, _24 = 0.0f;
		_31 =  -sn, _32 = 0.0f, _33 =   cs, _34 = 0.0f;
		_41 = 0.0f, _42 = 0.0f, _43 = 0.0f, _44 = 1.0f;
		
		return *this;
	}

	TMatrix44& SetRotateZ(float fAngle)
	{
		const float cs = cosf(fAngle);
		const float sn = sinf(fAngle);

		_11 =   cs, _12 =  -sn, _13 = 0.0f, _14 = 0.0f;
		_21 =   sn, _22 =   cs, _23 = 0.0f, _24 = 0.0f;
		_31 = 0.0f, _32 = 0.0f, _33 = 1.0f, _34 = 0.0f;
		_41 = 0.0f, _42 = 0.0f, _43 = 0.0f, _44 = 1.0f;

		return *this;
	}

	TMatrix44& SetBassis(	const TVector3& BassisX,
							const TVector3& BassisY,
							const TVector3& BassisZ,
							const TVector3* pOffset = NULL)
	{
		_11 = BassisX.x, _12 = BassisX.y, _13 = BassisX.z, _14 = 0.0f;
		_21 = BassisY.x, _22 = BassisY.y, _23 = BassisY.z, _24 = 0.0f;
		_31 = BassisZ.x, _32 = BassisZ.y, _33 = BassisZ.z, _34 = 0.0f;

		if(pOffset)
			_41 = pOffset->x, _42 = pOffset->y, _43 = pOffset->z;
		else
			_41 = 0.0f, _42 = 0.0f, _43 = 0.0f;
		
		_44 = 1.0f;

		return *this;
	}

	// Const operators
	TMatrix44 operator + (const TMatrix44& SMatrix) const
		{ return TMatrix44(	_11 + SMatrix._11, _12 + SMatrix._12, _13 + SMatrix._13, _14 + SMatrix._14,
							_21 + SMatrix._21, _22 + SMatrix._22, _23 + SMatrix._23, _24 + SMatrix._24,
							_31 + SMatrix._31, _32 + SMatrix._32, _33 + SMatrix._33, _34 + SMatrix._34,
							_41 + SMatrix._41, _42 + SMatrix._42, _43 + SMatrix._43, _44 + SMatrix._44); }

	TMatrix44 operator - (const TMatrix44& SMatrix) const
		{ return TMatrix44(	_11 - SMatrix._11, _12 - SMatrix._12, _13 - SMatrix._13, _14 - SMatrix._14,
							_21 - SMatrix._21, _22 - SMatrix._22, _23 - SMatrix._23, _24 - SMatrix._24,
							_31 - SMatrix._31, _32 - SMatrix._32, _33 - SMatrix._33, _34 - SMatrix._34,
							_41 - SMatrix._41, _42 - SMatrix._42, _43 - SMatrix._43, _44 - SMatrix._44); }

	TMatrix44 operator + (const TVector3& Vector) const
	{
		return TMatrix44(	_11, _12, _13, _14,
							_21, _22, _23, _24,
							_31, _32, _33, _34,
							_41 + Vector.x, _42 + Vector.y, _43 + Vector.z, _44);
	}

	TMatrix44 operator - (const TVector3& Vector) const
	{
		return TMatrix44(	_11, _12, _13, _14,
							_21, _22, _23, _24,
							_31, _32, _33, _34,
							_41 - Vector.x, _42 - Vector.y, _43 - Vector.z, _44);
	}

	TMatrix44 operator * (const TMatrix44& SMatrix) const
	{
		return TMatrix44(	_11 * SMatrix._11 + _12 * SMatrix._21 + _13 * SMatrix._31 + _14 * SMatrix._41,
							_11 * SMatrix._12 + _12 * SMatrix._22 + _13 * SMatrix._32 + _14 * SMatrix._42,
							_11 * SMatrix._13 + _12 * SMatrix._23 + _13 * SMatrix._33 + _14 * SMatrix._43,
							_11 * SMatrix._14 + _12 * SMatrix._24 + _13 * SMatrix._34 + _14 * SMatrix._44,
							
							_21 * SMatrix._11 + _22 * SMatrix._21 + _23 * SMatrix._31 + _24 * SMatrix._41,
							_21 * SMatrix._12 + _22 * SMatrix._22 + _23 * SMatrix._32 + _24 * SMatrix._42,
							_21 * SMatrix._13 + _22 * SMatrix._23 + _23 * SMatrix._33 + _24 * SMatrix._43,
							_21 * SMatrix._14 + _22 * SMatrix._24 + _23 * SMatrix._34 + _24 * SMatrix._44,

							_31 * SMatrix._11 + _32 * SMatrix._21 + _33 * SMatrix._31 + _34 * SMatrix._41,
							_31 * SMatrix._12 + _32 * SMatrix._22 + _33 * SMatrix._32 + _34 * SMatrix._42,
							_31 * SMatrix._13 + _32 * SMatrix._23 + _33 * SMatrix._33 + _34 * SMatrix._43,
							_31 * SMatrix._14 + _32 * SMatrix._24 + _33 * SMatrix._34 + _34 * SMatrix._44,

							_41 * SMatrix._11 + _42 * SMatrix._21 + _43 * SMatrix._31 + _44 * SMatrix._41,
							_41 * SMatrix._12 + _42 * SMatrix._22 + _43 * SMatrix._32 + _44 * SMatrix._42,
							_41 * SMatrix._13 + _42 * SMatrix._23 + _43 * SMatrix._33 + _44 * SMatrix._43,
							_41 * SMatrix._14 + _42 * SMatrix._24 + _43 * SMatrix._34 + _44 * SMatrix._44);
	}

	TMatrix44 operator & (const TMatrix44& SMatrix) const
	{
		return TMatrix44(	_11 * SMatrix._11 + _12 * SMatrix._21 + _13 * SMatrix._31,
							_11 * SMatrix._12 + _12 * SMatrix._22 + _13 * SMatrix._32,
							_11 * SMatrix._13 + _12 * SMatrix._23 + _13 * SMatrix._33,
							_14,
							
							_21 * SMatrix._11 + _22 * SMatrix._21 + _23 * SMatrix._31,
							_21 * SMatrix._12 + _22 * SMatrix._22 + _23 * SMatrix._32,
							_21 * SMatrix._13 + _22 * SMatrix._23 + _23 * SMatrix._33,
							_24,

							_31 * SMatrix._11 + _32 * SMatrix._21 + _33 * SMatrix._31,
							_31 * SMatrix._12 + _32 * SMatrix._22 + _33 * SMatrix._32,
							_31 * SMatrix._13 + _32 * SMatrix._23 + _33 * SMatrix._33,
							_34,

							_41, _42, _43, _44);
	}

	TMatrix44 operator * (const TVector3& Vector) const
	{
		return TMatrix44(	_11 * Vector.x, _12, _13, _14,
							_21, _22 * Vector.y, _23, _24,
							_31, _32, _33 * Vector.z, _34,
							_41, _42, _43, _44);
	}

	// Non-const operators
	TMatrix44& operator += (const TMatrix44& SMatrix)
		{	_11 += SMatrix._11, _12 += SMatrix._12, _13 += SMatrix._13, _14 += SMatrix._14;
			_21 += SMatrix._21, _22 += SMatrix._22, _23 += SMatrix._23, _24 += SMatrix._24;
			_31 += SMatrix._31, _32 += SMatrix._32, _33 += SMatrix._33, _34 += SMatrix._34;
			_41 += SMatrix._41, _42 += SMatrix._42, _43 += SMatrix._43, _44 += SMatrix._44;
			return *this; }

	TMatrix44& operator -= (const TMatrix44& SMatrix)
		{	_11 -= SMatrix._11, _12 -= SMatrix._12, _13 -= SMatrix._13, _14 -= SMatrix._14;
			_21 -= SMatrix._21, _22 -= SMatrix._22, _23 -= SMatrix._23, _24 -= SMatrix._24;
			_31 -= SMatrix._31, _32 -= SMatrix._32, _33 -= SMatrix._33, _34 -= SMatrix._34;
			_41 -= SMatrix._41, _42 -= SMatrix._42, _43 -= SMatrix._43, _44 -= SMatrix._44;
			return *this; }

	TMatrix44& operator += (const TVector3& Vector)
		{ _41 += Vector.x, _42 += Vector.y, _43 += Vector.z; return *this; }

	TMatrix44& operator -= (const TVector3& Vector)
		{ _41 -= Vector.x, _42 -= Vector.y, _43 -= Vector.z; return *this; }

	TMatrix44& operator *= (const TMatrix44& SMatrix)
		{ return *this = *this * SMatrix; }

	TMatrix44& operator &= (const TMatrix44& SMatrix)
		{ return *this = *this & SMatrix; }

	TMatrix44& operator *= (const TVector3& Vector)
		{ _11 *= Vector.x, _22 *= Vector.y, _33 *= Vector.z; return *this; }

	// Comparison operators
	bool operator == (const TMatrix44& SMatrix) const
		{ return memcmp(v, SMatrix.v, sizeof(v)) ? false : true; }

	bool operator != (const TMatrix44& SMatrix) const
		{ return memcmp(v, SMatrix.v, sizeof(v)) ? true : false; }
};

inline TDebugFile& operator << (TDebugFile& DebugFile, const TMatrix44& Matrix)
{
	DebugFile << Matrix._11 << TEXT(" ") << Matrix._12 << TEXT(" ") << Matrix._13 << TEXT(" ") << Matrix._14 << DFCC_EOL;
	DebugFile << Matrix._21 << TEXT(" ") << Matrix._22 << TEXT(" ") << Matrix._23 << TEXT(" ") << Matrix._24 << DFCC_EOL;
	DebugFile << Matrix._31 << TEXT(" ") << Matrix._32 << TEXT(" ") << Matrix._33 << TEXT(" ") << Matrix._34 << DFCC_EOL;
	DebugFile << Matrix._41 << TEXT(" ") << Matrix._42 << TEXT(" ") << Matrix._43 << TEXT(" ") << Matrix._44 << DFCC_EOL;

	return DebugFile;
}

#endif // matrix_h
