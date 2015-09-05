// BitmapConverter.h: interface for the CBitmapConverter class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_BITMAPCONVERTER_H__E812639D_BA69_4AE1_B2C6_BA7B9FB8B2C7__INCLUDED_)
#define AFX_BITMAPCONVERTER_H__E812639D_BA69_4AE1_B2C6_BA7B9FB8B2C7__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

struct CLetter
{
	BYTE m_Data[40][256];
	BYTE m_SourceColFirst, m_SourceColLast;
	BYTE m_W, m_H;
	INT m_PixelsCount;

	inline BOOL IsInRange(INT r, INT c) { return r>=0 && r<m_H && c>=0 && c<m_W; }
	inline BOOL IsPixel(INT r, INT c) { return IsInRange(r,c) && m_Data[r][c]; }
};

#define GUESS_COUNT 26

struct CGuess
{
	static CHAR m_cGuessResults[GUESS_COUNT];
	DOUBLE m_Guess[GUESS_COUNT];	//Probability
	INT m_Result[GUESS_COUNT];		//Order in increasing order of probability
};


class CBitmapConverter  
{
public:
	BOOL ConvertDataToText();
	BOOL LoadDataFromBitmap(const CString& strFile);
	BOOL SaveResultToFile(const CString& strFile);
	CBitmapConverter();
	virtual ~CBitmapConverter();

	CString GetLastErrorStr() { return m_strLastError; };

protected:
	void SplitBigLetters();
	void MergeSmallLetters();
	void MergeWithNextLetter(INT ind);
	BOOL ConvertDataToLetters();
	BOOL SaveDataToTextFile(const CString& strFile, BYTE* pData, BOOL bRewrite = TRUE, INT H = -1, INT W = -1);
	BOOL SaveTextToFile(const CString& strFile, const CString& strText, BOOL bRewrite = TRUE);
	void OptimizeLetters();
	BOOL SplitBigLetter(INT ind);

#ifdef _DEBUG
	CString ConvertLetterToDebugText(INT ind);
#endif


protected:
	void ConvertLettersToText();
	CString m_strLastError;

	BYTE m_Data[40][256];

	INT m_LettersCount;
	CLetter m_Letters[40];

	CGuess m_Guess[40];

	CString m_strResultString;

#ifdef _DEBUG
	CString m_strDebugFile;
#endif
};

#endif // !defined(AFX_BITMAPCONVERTER_H__E812639D_BA69_4AE1_B2C6_BA7B9FB8B2C7__INCLUDED_)
