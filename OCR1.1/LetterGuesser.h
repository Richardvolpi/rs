// LetterGuesser.h: interface for the CLetterGuesser class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_LETTERGUESSER_H__00363F41_00DB_4D36_AE06_81297CC1DA77__INCLUDED_)
#define AFX_LETTERGUESSER_H__00363F41_00DB_4D36_AE06_81297CC1DA77__INCLUDED_

#include "BitmapConverter.h"

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

struct CGuessLetter : public CLetter
{
	CGuessLetter() {}
		
	CGuessLetter(const CLetter& Letter)
	{
		::CopyMemory(m_Data, Letter.m_Data, sizeof(m_Data));

		m_SourceColFirst = Letter.m_SourceColFirst;
		m_SourceColLast = Letter.m_SourceColLast;
		m_W = Letter.m_W;
		m_H = Letter.m_H;
		m_PixelsCount = Letter.m_PixelsCount;

		m_MainWhiteColor = 0;
		m_MainWhitePixels = 0;

		m_MainBlackColor = 0;
		m_MainBlackPixels = 0;
	}
		
	BYTE m_MainWhiteColor;
	INT m_MainWhitePixels;

	BYTE m_MainBlackColor;
	INT m_MainBlackPixels;
};

class CLetterGuesser  
{
public:
	void ReorderResult();
	void AddGuess(INT ind, DOUBLE val);
	void MakeGuess();
	void GuessLetter(CLetter& Letter, CGuess& Guess);
	CLetterGuesser();
	virtual ~CLetterGuesser();

protected:
	void Guess1();
	void Guess2();
	void Guess3();
	void Guess4();
	void Guess5();
	void Guess6();
	void Guess7();
	void Guess8();
	void Guess9();

	void Guess10();
	void Guess11();
	void Guess12();
	void Guess13();
	void Guess14();
	void Guess15();

	void Guess16();
	void Guess17();
	void Guess18();
	void Guess19();
	void Guess20();


	
protected:
	void PaintArea(INT r, INT c, BYTE color);
	void MakeMap(BYTE color);
	void PaintLetter();
	DOUBLE GetAverageH(BYTE ind1, BYTE ind2);
	INT GetMaxDsH(INT ind1, INT ind2);
	INT GetDifferenceH(INT ind1, INT ind2);
	INT GetDifferenceEndsH(INT ind1, INT ind2);

	void GetRangeH(INT& r1, INT& r2);
	void GetRangeV(INT& c1, INT& c2);

	INT GetUpFlow(INT ind1, INT ind2);
	INT GetDownFlow(INT ind1, INT ind2);
	INT GetLeftFlow(INT ind1, INT ind2);
	INT GetRightFlow(INT ind1, INT ind2);

protected:
	CGuessLetter m_Letter;

	static INT dr8[8];
	static INT dc8[8];

	CGuess m_Guess;

	BYTE m_VMapCount[256];
	BYTE m_VMap[256][40*2];

	BYTE m_HMapCount[40];
	BYTE m_HMap[40][256*2];

	BYTE m_color;

	INT m_ru;
	INT m_rd;
	INT m_cl;
	INT m_cr;

	INT m_UpFlow;
	INT m_DownFlow;
	INT m_LeftFlow;
	INT m_RightFlow;

private:
	INT m_d[256];


};

#endif // !defined(AFX_LETTERGUESSER_H__00363F41_00DB_4D36_AE06_81297CC1DA77__INCLUDED_)
