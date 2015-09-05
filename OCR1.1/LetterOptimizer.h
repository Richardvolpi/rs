// LetterOptimizer.h: interface for the CLetterOptimizer class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_LETTEROPTIMIZER_H__E20CD2E2_E915_4F29_92DF_2E0B093B8E8C__INCLUDED_)
#define AFX_LETTEROPTIMIZER_H__E20CD2E2_E915_4F29_92DF_2E0B093B8E8C__INCLUDED_

#include "BitmapConverter.h"

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CLetterOptimizer  
{
public:
	void SetPixel(CLetter& Letter, INT r, INT c);
	void DrawLine(CLetter& Letter, INT r1, INT c1, INT r2, INT c2);
	void Optimize(CLetter& Letter);
	CLetterOptimizer();
	virtual ~CLetterOptimizer();

protected:
	void EnlargeThinLetter(CLetter& Letter);
	void TransferLetterInTheCorner(CLetter& Letter);
	void EnlargeSmall(CLetter& Letter);

protected:
	void FillSmallHoles(CLetter& Letter);
	static INT dr8[8];
	static INT dc8[8];
};

#endif // !defined(AFX_LETTEROPTIMIZER_H__E20CD2E2_E915_4F29_92DF_2E0B093B8E8C__INCLUDED_)
