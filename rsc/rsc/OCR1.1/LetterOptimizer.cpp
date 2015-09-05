// LetterOptimizer.cpp: implementation of the CLetterOptimizer class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "OCR.h"
#include "LetterOptimizer.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

INT CLetterOptimizer::dr8[8] = 
{-1, 0, 1, 1, 1, 0, -1, -1};

INT CLetterOptimizer::dc8[8] = 
{1, 1, 1, 0, -1, -1, -1, 0};


//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CLetterOptimizer::CLetterOptimizer()
{

}

CLetterOptimizer::~CLetterOptimizer()
{

}

void CLetterOptimizer::Optimize(CLetter &Letter)
{
	TransferLetterInTheCorner(Letter);
	EnlargeThinLetter(Letter);
	//FillSmallHoles(Letter);
	EnlargeSmall(Letter);
}


void CLetterOptimizer::TransferLetterInTheCorner(CLetter &Letter)
{
	INT rr = -1;
	INT r,c;
	for(r=0; r<40 && rr == -1; ++r)
		for(c=0; c<256 && rr == -1; ++c)
			if (Letter.m_Data[r][c])
				rr = r;

	if (rr == -1)
		return;

	Letter.m_W = Letter.m_SourceColLast - Letter.m_SourceColFirst + 1;

	for(r=rr; r<40; ++r)
		for(c=0; c<Letter.m_W; ++c)
			if (Letter.m_Data[r][c])
			{
				Letter.m_Data[r][c] = 0;
				Letter.m_Data[r-rr][c] = 1;

				Letter.m_H = r-rr+1;
			}

}

void CLetterOptimizer::EnlargeThinLetter(CLetter &Letter)
{
	if (Letter.m_PixelsCount / Letter.m_W >= 4)
		return;

	INT r,c,k,l;
	BOOL bFl;

	for(c=0; c<Letter.m_W; ++c)
		for(r=0; r<Letter.m_H; ++r)
			if (Letter.IsPixel(r, c))
			{
				bFl = FALSE;
				for(l=1;l<5 && !bFl;++l)
					for(k=-l; k<=l && !bFl; k++)
						if (Letter.IsPixel(r+l, c+k))
						{
							if (l>1)
								DrawLine(Letter, r, c, r+l, c+k);
							bFl = TRUE;
						}

				bFl = FALSE;
				for(l=1;l<5 && !bFl;++l)
					for(k=-l; k<=l && !bFl; k++)
						if (Letter.IsPixel(r+k, c+l))
						{
							if (l>1)
								DrawLine(Letter, r, c, r+k, c+l);
							bFl = TRUE;
						}

			}

}


void CLetterOptimizer::DrawLine(CLetter &Letter, INT r1, INT c1, INT r2, INT c2)
{
	if (r1 == r2) 
	{
		if (c1 > c2)
			c1 ^= c2, c2 ^= c1, c1 ^= c2;
		
		while (c1 <= c2) 
			SetPixel(Letter, r1, c1++);
		
		return;
	}
	
	if (c1 == c2) 
	{
		if (r1 > r2)
			r1 ^= r2, r2 ^= r1, r1 ^= r2;
		while (r1 <= r2) 
			SetPixel(Letter, r1++, c1);
		
		return;
	}
	
	INT x1 = c1, x2 = c2;
	INT y1 = r1, y2 = r2;
	
    INT Z = 0;
    INT kx, ky, max_dev, step_small;
	INT t;
	
    if (abs(x1-x2) >= abs(y1-y2)) 
	{     
		if (x1>x2) { 
			t = x1; x1 = x2; x2 = t;
			t = y1; y1 = y2; y2 = t;
		}

		kx = abs(y2-y1); 
		ky = x2-x1;

		step_small = (y1>y2) ? -1 : 1;
		max_dev = ky >> 1;
		while (x1<=x2) 
		{
			SetPixel(Letter, y1,x1);
			x1++;
			Z += kx;
			if (Z>max_dev) { y1 += step_small; Z -= ky; }
		}
    } else 
	{
		if (y1>y2) 
		{ 
			t = x1; x1 = x2; x2 = t;
			t = y1; y1 = y2; y2 = t;
		}

		kx = y2-y1; 
		ky = abs(x2-x1);

		step_small = (x1>x2) ? -1 : 1;
		max_dev = kx >> 1;
		while (y1<=y2) 
		{
			SetPixel(Letter, y1,x1);
			y1++;
			Z += ky;
			if (Z>max_dev) { x1 += step_small; Z -= kx; }
		}
    }

}

void CLetterOptimizer::SetPixel(CLetter &Letter, INT r, INT c)
{
	if (!Letter.m_Data[r][c])
	{
		Letter.m_Data[r][c] = 1;
		Letter.m_PixelsCount++;
	}
}

void CLetterOptimizer::FillSmallHoles(CLetter &Letter)
{
	INT r,c,k,l;
	BOOL bFl = TRUE;
	INT cnt;

	while (bFl)
	{
		bFl = FALSE;
		for(c=0; c<Letter.m_W; ++c)
			for(r=0; r<Letter.m_H; ++r)
				if (!Letter.IsPixel(r,c))
				{

					cnt=0;
					for(l=1; l<=2; ++l)
						for(k=0;k<8;++k)
							if (Letter.IsPixel(r+dr8[k],c+dc8[k]))
								++cnt;

					if (cnt>=18)
					{
						SetPixel(Letter, r,c);
						bFl = TRUE;
					}
				}
	}


}

void CLetterOptimizer::EnlargeSmall(CLetter &Letter)
{
	INT r,c;
	while (Letter.m_H < 15 && Letter.m_W < 15)
	{
		CLetter NewLetter;
		NewLetter.m_W = Letter.m_W * 2;
		NewLetter.m_H = Letter.m_H * 2;
		for(r=0; r<NewLetter.m_H; ++r)
			for(c=0; c<NewLetter.m_W; ++c)
				NewLetter.m_Data[r][c] = Letter.m_Data[r/2][c/2];

		NewLetter.m_PixelsCount = Letter.m_PixelsCount * 4;

		Letter = NewLetter;
	}
}

