// LetterGuesser.cpp: implementation of the CLetterGuesser class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "OCR.h"
#include "LetterGuesser.h"

#include <math.h>
#include <algorithm>

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

INT CLetterGuesser::dr8[8] = 
{-1, 0, 1, 1, 1, 0, -1, -1};

INT CLetterGuesser::dc8[8] = 
{1, 1, 1, 0, -1, -1, -1, 0};


//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CLetterGuesser::CLetterGuesser()
{

}

CLetterGuesser::~CLetterGuesser()
{

}

void CLetterGuesser::GuessLetter(CLetter &Letter, CGuess &Guess)
{
	m_Letter = CGuessLetter(Letter);
	PaintLetter();
	::ZeroMemory(&m_Guess, sizeof(CGuess));
/*
	MakeMap(m_Letter.m_MainBlackColor);
	MakeGuess();
*/
	MakeMap(m_Letter.m_MainWhiteColor);
	MakeGuess();

/*
	if (m_Letter.m_MainBlackPixels >= 50)
	{
		MakeMap(m_Letter.m_MainBlackColor);
		MakeGuess();
	}
*/


	ReorderResult();

	Guess = m_Guess;
}

void CLetterGuesser::PaintLetter()
{
	INT r,c;
	BYTE CurCL = 3;
	//0,1 - reserved
	//2 - background

	//FillBackground
	for(c=0; c<m_Letter.m_W; ++c)
	{
		if (m_Letter.m_Data[0][c] == 0)
			PaintArea(0, c, 2);

		if (m_Letter.m_Data[m_Letter.m_H-1][c] == 0)
			PaintArea(m_Letter.m_H-1, c, 2);
	}

	for(r=0; r<m_Letter.m_H; ++r)
	{
		if (m_Letter.m_Data[r][0] == 0)
			PaintArea(r, 0, 2);

		if (m_Letter.m_Data[r][m_Letter.m_W-1] == 0)
			PaintArea(r, m_Letter.m_W-1, 2);
	}

	m_Letter.m_MainWhiteColor = 1;
	m_Letter.m_MainWhitePixels = m_Letter.m_PixelsCount;

	m_Letter.m_MainBlackColor = 0;
	m_Letter.m_MainBlackPixels = 0;
	for(r=0; r<m_Letter.m_H; ++r)
		for(c=0; c<m_Letter.m_W; ++c)
			if (m_Letter.m_Data[r][c] == 0)
				m_Letter.m_MainBlackPixels++;
/*
	for(c=0; c<m_Letter.m_W; ++c)
		for(r=0; r<m_Letter.m_H; ++r)
			if (m_Letter.m_Data[r][c] <= 1)
				PaintArea(r, c, CurCL++);
*/
}

void CLetterGuesser::PaintArea(INT r, INT c, BYTE color)
{
	static INT q[255*40];
	INT head = 0, tail = 0;

	//Old color
	BYTE oc = m_Letter.m_Data[r][c];

	//Init queue
	q[tail++] = r*m_Letter.m_W + c;
	m_Letter.m_Data[r][c] = color;

	INT nPixels = 0;
	INT l,k;
	INT rr,cc;
	while (head<tail)
	{
		r = q[head]/m_Letter.m_W;
		c = q[head]%m_Letter.m_W;
		head++;

		for(l=1; l<=1; ++l)
			for(k=0; k<8; ++k)
			{
				rr = r + l*dr8[k];
				cc = c + l*dc8[k];
				if (m_Letter.IsInRange(rr, cc) && m_Letter.m_Data[rr][cc] == oc)
				{
					m_Letter.m_Data[rr][cc] = color;
					q[tail++] = rr*m_Letter.m_W + cc;
					nPixels++;
				}
			}
	}

	if (color != 2)
	{
		if (oc == 0 && nPixels > m_Letter.m_MainBlackPixels)
		{
			m_Letter.m_MainBlackPixels = nPixels;
			m_Letter.m_MainBlackColor = color;
		}
		if (oc == 1 && nPixels > m_Letter.m_MainWhitePixels)
		{
			m_Letter.m_MainWhitePixels = nPixels;
			m_Letter.m_MainWhiteColor = color;
		}
	}
}

void CLetterGuesser::MakeMap(BYTE color)
{
	m_color = color;

	INT r,c;
	INT lst;
	for(c=0; c<m_Letter.m_W; ++c)
	{
		m_VMapCount[c] = 0;
		lst = -1;
		for(r=0; r<m_Letter.m_H; ++r)
			if (m_Letter.m_Data[r][c] == color)
			{
				if (lst == -1)
				{
					m_VMap[c][m_VMapCount[c]*2] = r;
					lst = r;
				}
				else
					if (r-lst <= 3)
						lst = r;
					else
					{
						m_VMap[c][m_VMapCount[c]*2+1] = lst;
						m_VMapCount[c]++;
						m_VMap[c][m_VMapCount[c]*2] = r;
						lst = r;
					}
			}

		if (lst != -1)
		{
			m_VMap[c][m_VMapCount[c]*2+1] = lst;
			m_VMapCount[c]++;
		}

	}

	for(r=0; r<m_Letter.m_H; ++r)
	{
		m_HMapCount[r] = 0;
		lst = -1;
		for(c=0; c<m_Letter.m_W; ++c)
			if (m_Letter.m_Data[r][c] == color)
			{
				if (lst == -1)
				{
					m_HMap[r][m_HMapCount[r]*2] = c;
					lst = c;
				}
				else
					if (c-lst <= 3)
						lst = c;
					else
					{
						m_HMap[r][m_HMapCount[r]*2+1] = lst;
						m_HMapCount[r]++;
						m_HMap[r][m_HMapCount[r]*2] = c;
						lst = c;
					}
			}

		if (lst != -1)
		{
			m_HMap[r][m_HMapCount[r]*2+1] = lst;
			m_HMapCount[r]++;
		}

	}

	GetRangeH(m_ru, m_rd);
	GetRangeV(m_cl, m_cr);

	m_UpFlow = GetUpFlow(m_ru, m_rd);
	m_DownFlow = GetDownFlow(m_ru, m_rd);
	m_LeftFlow = GetLeftFlow(m_cl, m_cr);
	m_RightFlow = GetRightFlow(m_cl, m_cr);
}

void CLetterGuesser::MakeGuess()
{
	Guess1();
	Guess2();
	Guess3();
	Guess4();
	Guess5();
	Guess6();
	Guess7();
	Guess8();
	Guess9();
	Guess10();
	Guess11();
	Guess12();
	Guess13();
	Guess14();
	Guess15();
	Guess16();
	Guess17();
	Guess18();
	Guess19();
	Guess20();
}

void CLetterGuesser::AddGuess(INT ind, DOUBLE val)
{
	m_Guess.m_Guess[ind] = m_Guess.m_Guess[ind] + val - m_Guess.m_Guess[ind]*val;
}

void CLetterGuesser::ReorderResult()
{
	INT i,j;
	for (i=0; i<GUESS_COUNT; ++i)
		m_Guess.m_Result[i] = i;

	for (i=0; i<GUESS_COUNT; ++i)
		for (j=i+1; j<GUESS_COUNT; ++j)
			if (m_Guess.m_Guess[m_Guess.m_Result[i]] < m_Guess.m_Guess[m_Guess.m_Result[j]])
			{
				m_Guess.m_Result[i] ^= m_Guess.m_Result[j];
				m_Guess.m_Result[j] ^= m_Guess.m_Result[i];
				m_Guess.m_Result[i] ^= m_Guess.m_Result[j];
			}
}

DOUBLE CLetterGuesser::GetAverageH(BYTE ind1, BYTE ind2)
{
	static INT p[255];
	INT tp = 0;

	INT i;
	for(i=ind1; i<ind2; ++i)
		p[tp++] = m_HMap[i][(m_HMapCount[i]-1)*2+1] - m_HMap[i][0] + 1;

	std::sort(&p[0], &p[tp]);

	INT i1 = 0;
	INT i2 = tp - 1;
	INT md;

	while (i1<i2 && p[i2] - p[i1] > 5)
	{
		md = (i1 + i2)/2;

		if (p[md] - p[i1] >= p[i2] - p[md])
			++i1;
		else
			--i2;

	}


	INT SumL = 0;
	for(i=i1; i<=i2; ++i)
		SumL += p[i];

	DOUBLE AvrL = (SumL / (i2 - i1 + 1));

	return AvrL;
}

INT CLetterGuesser::GetMaxDsH(INT ind1, INT ind2)
{
/*
	INT res = -1;
	INT i;
	for(i=ind1; i<ind2; ++i)
		if (m_HMap[i][(m_HMapCount[i]-1)*2+1] - m_HMap[i][0] + 1 > res)
			res = m_HMap[i][(m_HMapCount[i]-1)*2+1] - m_HMap[i][0] + 1;
*/
	INT res = -1;
	INT i,l;
	for(i=ind1; i<ind2; ++i)
	{
		l = m_HMap[i][0];
		if (i > ind1)
			l = min(l, m_HMap[i-1][0]);
		if (i < ind2 - 1)
			l = min(l, m_HMap[i+1][0]);

		res = max(res, m_HMap[i][(m_HMapCount[i]-1)*2+1] - l + 1);
	}

	return res;

}

INT CLetterGuesser::GetDifferenceH(INT ind1, INT ind2)
{
	INT res = 0;
	INT i;
/*
	for(i=0; i<m_Letter.m_W; ++i)
	{
		BOOL fl1 = (m_Letter.m_Data[ind1][i] == m_color);
		BOOL fl2 = (m_Letter.m_Data[ind2][i] == m_color);
		if (fl1 != fl2)
			++res;
	}
*/
	for(i=1; i<m_Letter.m_W-1; ++i)
	{
		BOOL f10 = (m_Letter.m_Data[ind1][i-1] == m_color);
		BOOL f11 = (m_Letter.m_Data[ind1][i] == m_color);
		BOOL f12 = (m_Letter.m_Data[ind1][i+1] == m_color);
		BOOL f20 = (m_Letter.m_Data[ind2][i-1] == m_color);
		BOOL f21 = (m_Letter.m_Data[ind2][i] == m_color);
		BOOL f22 = (m_Letter.m_Data[ind2][i+1] == m_color);
		if (f10 != f20 && f11 != f21 && f12 != f22)
			++res;
	}

	return res;
}

INT CLetterGuesser::GetDifferenceEndsH(INT ind1, INT ind2)
{
	INT res = 0;
	res = abs(m_HMap[ind1][0] - m_HMap[ind2][0]) + 
		abs(m_HMap[ind1][m_HMapCount[ind1]*2-1] - m_HMap[ind2][m_HMapCount[ind2]*2-1]);

	return res;
}

void CLetterGuesser::GetRangeH(INT& r1, INT& r2)
{
	INT r;
	r1 = r2 = -1;
	for(r=0; r<m_Letter.m_H; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			if (r1 == -1)
				r1 = r;
			r2 = r;
		}
	}
}

void CLetterGuesser::GetRangeV(INT& c1, INT& c2)
{
	INT c;
	c1 = c2 = -1;
	for(c=0; c<m_Letter.m_W; ++c)
	{
		if (m_VMapCount[c] >= 1)
		{
			if (c1 == -1)
				c1 = c;
			c2 = c;
		}
	}

}

/*
INT CLetterGuesser::GetUpFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT r, r1;
	BOOL bFl;
	INT c,i;

	for(c=1; c<m_Letter.m_W-1; ++c)
	{
		r1 = -1;
		for(r = ind1, bFl = FALSE; r<=ind2 && !bFl; ++r)
		{
			if (r1 == -1 && c >= m_HMap[r][0] - 1 && c <= m_HMap[r][m_HMapCount[r]*2-1] + 1)
				r1 = r;

			for (i=0; i<m_HMapCount[r] && !bFl; ++i)
				if (c >= m_HMap[r][i*2] - 1 && c <= m_HMap[r][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < r - r1)
			res = r - r1;
	}

	return res - 1;
}

INT CLetterGuesser::GetDownFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT r, r1;
	BOOL bFl;
	INT c,i;

	for(c=1; c<m_Letter.m_W-1; ++c)
	{
		r1 = -1;
		for(r = ind2, bFl = FALSE; r>=ind1 && !bFl; --r)
		{
			if (r1 == -1 && c >= m_HMap[r][0] - 1 && c<=m_HMap[r][m_HMapCount[r]*2-1] + 1)
				r1 = r;

			for (i=0; i<m_HMapCount[r] && !bFl; ++i)
				if (c >= m_HMap[r][i*2] - 1 && c <= m_HMap[r][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < r1 - r)
			res = r1 - r;
	}

	return res - 1;
}

INT CLetterGuesser::GetLeftFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT c, c1;
	BOOL bFl;
	INT r,i;

	for(r=1; r<m_Letter.m_H-1; ++r)
	{
		c1 = -1;
		for(c = ind1, bFl = FALSE; c<=ind2 && !bFl; ++c)
		{
			if (c1 == -1 && r >= m_VMap[c][0] - 1 && r<=m_VMap[c][m_VMapCount[c]*2-1] + 1)
				c1 = c;

			for (i=0; i<m_VMapCount[c] && !bFl; ++i)
				if (r >= m_VMap[c][i*2] - 1 && r <= m_VMap[c][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < c - c1)
			res = c - c1;
	}

	return res - 1;
}

INT CLetterGuesser::GetRightFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT c, c1;
	BOOL bFl;
	INT r,i;

	for(r=1; r<m_Letter.m_H-1; ++r)
	{
		c1 = -1;
		for(c = ind2, bFl = FALSE; c>=ind1 && !bFl; --c)
		{
			if (c1 == -1 && r >= m_VMap[c][0] - 1 && r<=m_VMap[c][m_VMapCount[c]*2-1] + 1)
				c1 = c;

			for (i=0; i<m_VMapCount[c] && !bFl; ++i)
				if (r >= m_VMap[c][i*2] - 1 && r <= m_VMap[c][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < c1 - c)
			res = c1 - c;
	}

	return res - 1;
}
*/

INT CLetterGuesser::GetUpFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT r, r1;
	BOOL bFl;
	INT c,i;

	for(c=1; c<m_Letter.m_W-1; ++c)
	{
		r1 = -1;
		for(r = ind1, bFl = FALSE; r<=ind2 && !bFl; ++r)
		{
			if (r1 == -1 && c >= m_HMap[r][0] && c <= m_HMap[r][m_HMapCount[r]*2-1] + 1)
				r1 = r;

			for (i=0; i<m_HMapCount[r] && !bFl; ++i)
				if (c >= m_HMap[r][i*2] && c <= m_HMap[r][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < r - r1)
			res = r - r1;
	}

	return res - 1;
}

INT CLetterGuesser::GetDownFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT r, r1;
	BOOL bFl;
	INT c,i;

	for(c=1; c<m_Letter.m_W-1; ++c)
	{
		r1 = -1;
		for(r = ind2, bFl = FALSE; r>=ind1 && !bFl; --r)
		{
			if (r1 == -1 && c >= m_HMap[r][0] && c<=m_HMap[r][m_HMapCount[r]*2-1] + 1)
				r1 = r;

			for (i=0; i<m_HMapCount[r] && !bFl; ++i)
				if (c >= m_HMap[r][i*2] && c <= m_HMap[r][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < r1 - r)
			res = r1 - r;
	}

	return res - 1;
}

INT CLetterGuesser::GetLeftFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT c, c1;
	BOOL bFl;
	INT r,i;

	for(r=1; r<m_Letter.m_H-1; ++r)
	{
		c1 = -1;
		for(c = ind1, bFl = FALSE; c<=ind2 && !bFl; ++c)
		{
			if (c1 == -1 && r >= m_VMap[c][0] && r<=m_VMap[c][m_VMapCount[c]*2-1] + 1)
				c1 = c;

			for (i=0; i<m_VMapCount[c] && !bFl; ++i)
				if (r >= m_VMap[c][i*2] && r <= m_VMap[c][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < c - c1)
			res = c - c1;
	}

	return res - 1;
}

INT CLetterGuesser::GetRightFlow(INT ind1, INT ind2)
{
	INT res = 0;

	INT c, c1;
	BOOL bFl;
	INT r,i;

	for(r=1; r<m_Letter.m_H-1; ++r)
	{
		c1 = -1;
		for(c = ind2, bFl = FALSE; c>=ind1 && !bFl; --c)
		{
			if (c1 == -1 && r >= m_VMap[c][0] && r<=m_VMap[c][m_VMapCount[c]*2-1] + 1)
				c1 = c;

			for (i=0; i<m_VMapCount[c] && !bFl; ++i)
				if (r >= m_VMap[c][i*2] && r <= m_VMap[c][i*2+1] + 1)
					bFl = TRUE;
		}

		if (bFl && res < c1 - c)
			res = c1 - c;
	}

	return res - 1;
}






//I, J, Z
void CLetterGuesser::Guess1()
{

	INT r,c;

	for(r=m_ru; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_RightFlow >= 2 * (m_cr - m_cl + 1) /3)
		return;

	if (m_LeftFlow >= 2 * (m_cr - m_cl + 1) /3)
		return;


	DOUBLE AvrL = GetAverageH(m_ru, m_rd+1);

	if (AvrL > 10.0)
		return;

	INT nUp = 0;
	INT nDown = 0;

	for(r=m_ru; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

		DOUBLE df = fabs(m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrL);

		if (df > 3.0 || m_HMapCount[r] > 1)
		{
			if (r < m_ru + (m_rd - m_ru) / 3)
				nUp++;
			else
			if (r > m_ru + 2 * (m_rd - m_ru) / 3)
				nDown++;
			else
			{
				res -= 0.1;

				if (m_HMapCount[r] > 1)
					res -= 0.1;
			}
		}
	}

	if (res < 0.45)
		return;

	AddGuess('i'-'a', res);
	AddGuess('j'-'a', res);
	AddGuess('z'-'a', res);
}

//T
/*
void CLetterGuesser::Guess2()
{
	INT r,c;

	for(r=m_ru; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}

	INT rr = m_ru + 1*(m_rd-m_ru+1)/3;

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;


	DOUBLE AvrL = GetAverageH(rr, m_rd+1);

	if (AvrL > 10.0)
		return;

	INT nUp = 0;
	INT nDown = 0;

	for(r=rr; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

		DOUBLE df = fabs(m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrL);

		if (df > 3.0)
		{
			res -= 0.1;
			if (m_HMapCount[r] > 1)
				res -= 0.1;
		}

	}

	for(r=m_ru; r<rr; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

	}

	DOUBLE Head = GetMaxDsH(m_ru, rr);

	if (Head < AvrL + 3.0)
		return;

	if (res < 0.45)
		return;

	AddGuess('t'-'a', res);
}
*/

//T
void CLetterGuesser::Guess2()
{
	INT r,c;

	for(r=m_ru; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	INT mx = 0;
	INT mn = 255;
	INT ll;
	for(r=m_ru; r<=m_rd; ++r)
	{
		ll = m_HMap[r][0];

		if (r > m_ru && ll > m_HMap[r-1][0])
			ll = m_HMap[r-1][0];
		if (r < m_rd && ll > m_HMap[r+1][0])
			ll = m_HMap[r+1][0];

		m_d[r] = m_HMap[r][(m_HMapCount[r]-1)*2+1] - ll + 1;
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	INT l = (mx + 2*mn) / 3 + 1;

	r = m_ru;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	if (r > m_ru + (m_rd - m_ru + 1) / 3)
		return;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	if (r > m_ru + 2 * (m_rd - m_ru + 1) / 3)
		return;

	l = (2*mx + mn) / 3 + 1;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('t'-'a', res);
}


//L
void CLetterGuesser::Guess3()
{
	INT r,c;

	for(r=m_ru; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}


	INT rr = m_ru + 2*(m_rd-m_ru)/3;

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	DOUBLE AvrL = GetAverageH(m_ru, rr+1);

	if (AvrL > 10.0)
		return;

	INT nUp = 0;
	INT nDown = 0;

	for(r=m_ru; r<=rr; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

		DOUBLE df = fabs(m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrL);

		if (df > 3.0)
		{
			res -= 0.1;
			if (m_HMapCount[r] > 1)
				res -= 2.0;
		}
	}

	for(r=rr+1; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}
	}

	DOUBLE Bottom = GetMaxDsH(rr+1, m_rd+1);

	if (Bottom < AvrL + 3.0)
		return;

	if (res < 0.45)
		return;

	AddGuess('l'-'a', res);
}


//O, D, Q
void CLetterGuesser::Guess4()
{
	INT r;

	INT rr1 = m_ru + (m_rd-m_ru)/2;
	INT rr2 = m_ru + (m_rd-m_ru)/2;

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	if (m_HMapCount[m_ru] != 1)
		return;

	INT df;
	r=m_ru + 1;
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		if (r >= m_ru + 2)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > rr1)
		return;

	if (m_HMapCount[r] != 2)
	{
		if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
			!(r<m_rd-1 && m_HMapCount[r+2] == 2))
			return;
	}

	++r;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}
		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < rr2)
		res -= 0.1;
	if (r <= rr1)
		return;

	if (m_HMapCount[r] != 1)
		return;

	df = GetDifferenceEndsH(r, r-1);
	if (r <= m_rd - 2 && df > 5)
		res -= 0.1;

	++r;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		++r;
	}

	if (res < 0.45)
		return;

	AddGuess('q'-'a', res);
	if (r < m_rd - (m_rd - m_ru)/4)
		res -= 0.2;

	if (res < 0.45)
		return;

	AddGuess('o'-'a', res);
	AddGuess('d'-'a', res);
}

//V, U, Y
void CLetterGuesser::Guess5()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_UpFlow < 4)
		res -= 0.1;

	if (m_UpFlow < 2)
		return;


	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;


	INT df;
	r=m_ru;
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1))
				break;
		}

		if (r > m_ru)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}


	INT rr1 = m_ru + (m_rd - m_ru) / 3;

	if (r >= rr1)
		return;

	if (m_HMapCount[r] != 2)
	{
		if (!(r<m_rd && m_HMapCount[r+1] == 2))
			return;
	}

	++r;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2))
				break;
		}
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	INT rr2 = r;

	if (m_HMapCount[r] != 1)
		return;

	df = GetDifferenceEndsH(r, r-1);
	if (df > 5)
		res -= 0.2;

	if (df > 10)
		return;

	++r;

	INT c;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1] && r == rr2 + 1; ++c)
			if (m_Letter.m_Data[r][c] != m_color)
				rr2 = r;

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;


	if (rr2 <= m_ru + 3 * (m_rd - m_ru + 1) / 4)
	{
		AddGuess('v'-'a', res - 0.2);
		AddGuess('u'-'a', res - 0.2);
		AddGuess('y'-'a', res);
	}
	else
	{
		AddGuess('v'-'a', res);
		AddGuess('u'-'a', res);
		AddGuess('y'-'a', res - 0.2);
	}
}

//C, G
void CLetterGuesser::Guess6()
{
	INT r;

	DOUBLE res = 1.0;
	DOUBLE resG = 0.0;
	DOUBLE resC = 0.0;


	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow < 3)
		return;

	if (m_RightFlow < 5)
		res -= 0.1;


	INT df;
	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r == m_ru)
		return;

	if (r > m_rd)
	{
		AddGuess('c'-'a', res + resC);
		return;
	}

	if (m_HMapCount[r] != 2)
	{
		if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
			!(r<m_rd-1 && m_HMapCount[r+2] == 2))
			return;
	}

	++r;

	//2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (m_HMapCount[r] != 1)
		return;

	df = GetDifferenceEndsH(r, r-1);
	if (df < 5)
		res -= 0.2;

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r > m_rd)
	{
		AddGuess('c'-'a', res + resC);
		return;
	}

	if (m_HMapCount[r] != 2)
		return;

	df = GetDifferenceEndsH(r, r-1);
	if (df < 5)
		resC -= 0.2;

	++r;

	//4
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}


	if (r <= m_rd - 2)
	{
		if (m_HMapCount[r] != 1)
			return;

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
	}

	++r;


	//5
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		++r;
	}


	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('c'-'a', res + resC);
	AddGuess('g'-'a', res + resG);
}

//H, N
void CLetterGuesser::Guess7()
{
	INT r;

	DOUBLE res = 1.0;
	DOUBLE resN = 0.0;
	DOUBLE resH = 0.0;

	if (m_DownFlow < 2)
		res -= 1.0;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	INT df;

	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1))
				break;
		}

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > m_rd)
		return;

	++r;

	//2.1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	INT n1 = 0;
	INT n3 = 0;

	++r;

	//2.2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 3 && m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && (m_HMapCount[r+1] == 3 || m_HMapCount[r+1] == 1)) &&
				!(r<m_rd-1 && (m_HMapCount[r+2] == 3 || m_HMapCount[r+2] == 1)))
				break;
		}
		if (m_HMapCount[r] == 1)
			++n1;
		else
			++n3;

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	if (r > m_rd || m_HMapCount[r] != 2)
		n1 = n3 = 0;

	++r;

	//2.3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	if (n1 > n3)
		resN -= 0.2;
	if (n1 > n3)
		resH -= 0.2;

	if (res + resN > 0.45)
		AddGuess('n'-'a', res + resN);

	if (res + resH > 0.45)
		AddGuess('h'-'a', res + resH);
}



//P
void CLetterGuesser::Guess8()
{

	INT r,c;
	INT rr = m_ru + 2 * (m_rd - m_ru) / 3;

	BOOL bFl = FALSE;
	for(r=m_ru; r<=rr && !bFl; ++r)
	{
		if (m_HMapCount[r] > 1)
			bFl = TRUE;
		else
		{
			for (c = m_HMap[r][0] + 1; c < m_HMap[r][m_HMapCount[r]*2-1] && !bFl; ++c)
				if (m_Letter.m_Data[r][c] != m_color)
					bFl = TRUE;
		}
	}

	if (!bFl)
		return;

	for(r=rr+1; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	DOUBLE AvrLDown = GetAverageH(rr+1, m_rd+1);

	if (AvrLDown > 10.0)
		return;

	INT nB = 0;
	for(r=m_ru; r<=rr; ++r)
	{
		DOUBLE df = m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrLDown;

		if (df >= 3.0)
			++nB;
	}

	if (nB < (rr-m_ru+1) / 2)
		return;

	for(r=rr+1; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

		DOUBLE df = fabs(m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrLDown);

		if (df > 3.0 || m_HMapCount[r] > 1)
		{
			res -= 0.1;

			if (m_HMapCount[r] > 1)
				res -= 0.1;
		}
	}

	if (res < 0.45)
		return;

	AddGuess('p'-'a', res);

}

//R
void CLetterGuesser::Guess9()
{

	INT r,c;

	INT rr = m_ru + 2 * (m_rd -  m_ru) / 3;

	for(r=rr+1; r<=m_rd; ++r)
	{
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
				if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
					return;
		}
	}

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	INT n1 = 0;
	DOUBLE df;
	for(r = m_ru + 3; r<=m_rd - 2; ++r)
	{
		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			++n1;
	}

	if (n1 > 1)
		res -= (n1 - 1) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('r'-'a', res);
}


/*
//R
void CLetterGuesser::Guess9()
{
	INT r;

	INT rr1 = m_ru + (m_rd-m_ru)/3;
	INT rr2 = m_ru + 2*(m_rd-m_ru)/3;

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow < 2)
		return;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	if (m_HMapCount[m_ru] != 1)
		return;

	INT df;
	r=m_ru + 1;
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		if (r >= m_ru + 2)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > rr1)
		return;

	if (m_HMapCount[r] != 2)
	{
		if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
			!(r<m_rd-1 && m_HMapCount[r+2] == 2))
			return;
	}

	++r;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}
		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < rr2)
		res -= 0.1;
	if (r <= rr1)
		return;

	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 1))
				break;
		}

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		++r;
	}

	if (res < 0.45)
		return;

	AddGuess('r'-'a', res);
}
*/


//B
void CLetterGuesser::Guess10()
{
	INT r;

	INT rr1 = m_ru + (m_rd-m_ru)/3;
	INT rr2 = m_ru + 2*(m_rd-m_ru)/3;

	DOUBLE res = 1.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	if (m_HMapCount[m_ru] != 1)
		return;

	INT df;
	r=m_ru + 1;
	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1))
				break;
		}

		if (r >= m_ru + 2)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > rr1)
		return;

	//2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] < 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] >= 2))
				break;
		}
		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}


	if (r < rr1)
		return;

	if (r < rr2)
	{
		//3
		while (r<=m_rd)
		{
			if (m_HMapCount[r] != 1)
			{
				if (!(r<m_rd && m_HMapCount[r+1] == 1))
					break;
			}
			
			df = GetDifferenceEndsH(r, r-1);
			if (r <= m_rd - 2 && df > 5)
				res -= 0.1;
			++r;
		}
		
		//4
		while (r<=m_rd)
		{
			if (m_HMapCount[r] < 2)
			{
				if (!(r<m_rd && m_HMapCount[r+1] >= 2))
					break;
			}
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			++r;
		}

	}

	//5
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 1))
				break;
		}

		df = GetDifferenceEndsH(r, r-1);
		if (r <= m_rd - 2 && df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('b'-'a', res);
}


//A
void CLetterGuesser::Guess11()
{
	INT r;

	DOUBLE res = 1.0;


	if (m_DownFlow < 2)
		return;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	INT df;

	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > m_rd)
		return;

	//2.1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;
	INT n1 = 0;
	INT n3 = 0;

	//2.2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 3 && m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && (m_HMapCount[r+1] == 3 || m_HMapCount[r+1] == 1)) &&
				!(r<m_rd-1 && (m_HMapCount[r+2] == 3 || m_HMapCount[r+2] == 1)))
				break;
		}
		if (m_HMapCount[r] == 1)
			++n1;
		else
			++n3;

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	if (r > m_rd || m_HMapCount[r] != 2)
		n1 = n3 = 0;

	++r;

	//2.3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('a'-'a', res);
}


//S
void CLetterGuesser::Guess12()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_LeftFlow < 2)
		return;

	if (m_RightFlow < 2)
		return;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	INT mn,mx;
	INT l;

	INT rr1 = m_ru + (m_rd - m_ru) / 3;
	INT rr2 = m_ru + (m_rd - m_ru) / 2;
	INT rr3 = m_ru + 2 * (m_rd - m_ru) / 3;

	//Left
	mn = 256;
	mx = 0;
	for(r=m_ru; r<=m_rd; ++r)
	{
		m_d[r] = m_HMap[r][0];
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	l = (mx + mn) / 2;

	r = m_ru;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	if (r < rr1)
		return;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	//Right
	mn = 256;
	mx = 0;
	l=0;
	for(r=m_ru; r<=m_rd; ++r)
	{
		m_d[r] = m_Letter.m_W - m_HMap[r][m_HMapCount[r]*2 - 1];
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	l = (mx + mn) / 2;

	r = m_ru;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	if (r > rr3)
		return;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('s'-'a', res);
}


//E
void CLetterGuesser::Guess13()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_RightFlow < 2)
		return;

	if (m_RightFlow < 4)
		res -= 0.2;

	INT mx = 0;
	INT mn = 255;
	INT ll;
	for(r=m_ru; r<=m_rd; ++r)
	{
		ll = m_HMap[r][0];

		if (r > m_ru && ll > m_HMap[r-1][0])
			ll = m_HMap[r-1][0];
		if (r < m_rd && ll > m_HMap[r+1][0])
			ll = m_HMap[r+1][0];

		m_d[r] = m_HMap[r][(m_HMapCount[r]-1)*2+1] - ll + 1;
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	INT l = (mx + 2*mn) / 3 + 1;

	r = m_ru;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	if (r > m_rd)
		return;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('e'-'a', res);
}

//F
void CLetterGuesser::Guess14()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_UpFlow >= 3)
		res -= (m_UpFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;

	if (m_RightFlow < 2)
		return;

	if (m_RightFlow < 4)
		res -= 0.1;

	INT mx = 0;
	INT mn = 255;
	for(r=m_ru; r<=m_rd; ++r)
	{
		m_d[r] = m_HMap[r][(m_HMapCount[r]-1)*2+1];// - m_HMap[r][0] + 1;
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	INT l = (mx + 2*mn) / 3 + 1;

	r = m_ru;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	if (r > m_ru + 2 * (m_rd - m_ru) / 3)
		return;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('f'-'a', res);
}


//K
void CLetterGuesser::Guess15()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_UpFlow < 2)
		return;

	if (m_UpFlow < 4)
		res -= 0.1;

	if (m_DownFlow < 2)
		return;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	INT df;

	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > m_rd)
		return;

	++r;

	//2.1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	INT n1 = 0;
	INT n3 = 0;

	++r;

	//2.2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 3 && m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && (m_HMapCount[r+1] == 3 || m_HMapCount[r+1] == 1)) &&
				!(r<m_rd-1 && (m_HMapCount[r+2] == 3 || m_HMapCount[r+2] == 1)))
				break;
		}
		if (m_HMapCount[r] == 1)
			++n1;
		else
			++n3;

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	if (n3 > 2)
		return;

	if (r > m_rd || m_HMapCount[r] != 2)
		n1 = n3 = 0;

	++r;

	//2.3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('k'-'a', res);
}


//X
void CLetterGuesser::Guess16()
{
	DOUBLE res = 1.0;

	if (m_UpFlow < 2)
		return;

	if (m_UpFlow < 4)
		res -= 0.1;

	if (m_DownFlow < 2)
		return;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_LeftFlow < 2)
		return;

	if (m_LeftFlow < 4)
		res -= 0.1;

	if (m_RightFlow < 2)
		return;

	if (m_RightFlow < 4)
		res -= 0.1;

	if (res < 0.45)
		return;

	AddGuess('x'-'a', res);
}

//M
void CLetterGuesser::Guess17()
{
	INT r;

	DOUBLE res = 1.0;


	if (m_DownFlow < 2)
		return;

	if (m_DownFlow < 4)
		res -= 0.1;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	INT df;

	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > m_rd)
		return;

	++r;

	//2.1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	INT n1 = 0;
	INT n3 = 0;

	++r;

	//2.2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 3 && m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && (m_HMapCount[r+1] == 3 || m_HMapCount[r+1] == 1)) &&
				!(r<m_rd-1 && (m_HMapCount[r+2] == 3 || m_HMapCount[r+2] == 1)))
				break;
		}
		if (m_HMapCount[r] == 1)
			++n1;
		else
			++n3;

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	if (r > m_rd || m_HMapCount[r] != 2)
		n1 = n3 = 0;

	++r;

	//2.3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('m'-'a', res);
}

//W
void CLetterGuesser::Guess18()
{
	INT r;

	DOUBLE res = 1.0;


	if (m_UpFlow < 2)
		return;

	if (m_UpFlow < 4)
		res -= 0.1;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	INT df;

	r=m_ru;

	//1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		if (r > m_ru + 1)
		{
			df = GetDifferenceEndsH(r, r-1);
			if (df > 5)
				res -= 0.1;
			df = GetDifferenceH(r, r-1);
			if (df > 5)
				res -= 0.1;
		}
		++r;
	}

	if (r > m_rd)
		return;

	++r;

	//2.1
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	INT n1 = 0;
	INT n3 = 0;

	++r;

	//2.2
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 3 && m_HMapCount[r] != 1)
		{
			if (!(r<m_rd && (m_HMapCount[r+1] == 3 || m_HMapCount[r+1] == 1)) &&
				!(r<m_rd-1 && (m_HMapCount[r+2] == 3 || m_HMapCount[r+2] == 1)))
				break;
		}
		if (m_HMapCount[r] == 1)
			++n1;
		else
			++n3;

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	if (r > m_rd || m_HMapCount[r] != 2)
		n1 = n3 = 0;

	++r;

	//2.3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 2)
		{
			if (!(r<m_rd && m_HMapCount[r+1] == 2) &&
				!(r<m_rd-1 && m_HMapCount[r+2] == 2))
				break;
		}

		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;

		++r;
	}

	++r;

	//3
	while (r<=m_rd)
	{
		if (m_HMapCount[r] != 1)
				break;

		df = GetDifferenceEndsH(r, r-1);
		if (df > 5)
			res -= 0.1;
		df = GetDifferenceH(r, r-1);
		if (df > 5)
			res -= 0.1;
		++r;
	}

	if (r < m_rd - 2)
		return;

	if (res < 0.45)
		return;

	AddGuess('w'-'a', res);
}

//L
void CLetterGuesser::Guess19()
{
	INT r;

	DOUBLE res = 1.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_DownFlow >= 3)
		res -= (m_DownFlow - 3) / 10.0;


	INT mx = 0;
	INT mn = 255;
	for(r=m_ru; r<=m_rd; ++r)
	{
		m_d[r] = m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1;
		mx = max(mx, m_d[r]);
		mn = min(mn, m_d[r]);
	}

	INT l = (mx + mn) / 2;

	r = m_ru;

	while (r<m_rd && (m_d[r] <= l || m_d[r+1] <= l)) 
		++r;

	if (r < m_ru + (m_rd - m_ru) / 3)
		return;

	if (r > m_rd - 2)
		return;

	while (r<=m_rd && m_d[r] > l) 
		++r;

	while (r<=m_rd && m_d[r] <= l) 
		++r;

	res -= (m_rd - (r - 1)) / 10.0;

	if (res < 0.45)
		return;

	AddGuess('l'-'a', res);
}


//H, N (second)
void CLetterGuesser::Guess20()
{

	INT r,c;
	INT n1 = 0;

	for(r=m_ru; r<=m_rd; ++r)
	{
		m_d[r] = 0;
		if (m_HMapCount[r] >= 1)
		{
			for (c = m_HMap[r][0]; c < m_HMap[r][m_HMapCount[r]*2 - 1]; ++c)
			{
				//if (m_Letter.m_Data[r][c] != 2 && m_Letter.m_Data[r][c] != m_color)
				//	return;
				if (m_Letter.m_Data[r][c] != m_color)
					m_d[r] = 1;
			}
		}
		if (m_d[r] == 1)
			++n1;
	}

	if (n1 < 2 * (m_rd - m_ru + 1) / 3)
		return;

	DOUBLE res = 1.0;

	if (m_LeftFlow >= 3)
		res -= (m_LeftFlow - 3) / 10.0;

	if (m_RightFlow >= 3)
		res -= (m_RightFlow - 3) / 10.0;

	DOUBLE AvrL = GetAverageH(m_ru, m_rd+1);

	for(r=m_ru + 2; r<=m_rd - 2; ++r)
	{
		if (m_HMapCount[r] < 1)
		{
			res -= 0.1;
			continue;
		}

		DOUBLE df = fabs(m_HMap[r][(m_HMapCount[r]-1)*2+1] - m_HMap[r][0] + 1 - AvrL);

		if (df > 3.0)
			res -= 0.1;
	}

	if (res < 0.45)
		return;

	AddGuess('h'-'a', res);
	AddGuess('n'-'a', res);
}
