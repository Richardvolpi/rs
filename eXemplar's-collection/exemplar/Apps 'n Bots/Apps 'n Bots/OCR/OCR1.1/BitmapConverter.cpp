// BitmapConverter.cpp: implementation of the CBitmapConverter class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "OCR.h"
#include "BitmapConverter.h"
#include "LetterOptimizer.h"
#include "LetterGuesser.h"
#include "WordSelecter.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

CHAR CGuess::m_cGuessResults[GUESS_COUNT] = 
{
'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
'u', 'v', 'w', 'x', 'y', 'z'
};


//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CBitmapConverter::CBitmapConverter()
{

}

CBitmapConverter::~CBitmapConverter()
{

}


BOOL CBitmapConverter::LoadDataFromBitmap(const CString &strFile)
{
	HBITMAP hBMP = (HBITMAP)::LoadImage(NULL, strFile, IMAGE_BITMAP, NULL, NULL, LR_LOADFROMFILE | LR_MONOCHROME);

	if (hBMP == NULL)
	{
		m_strLastError = "Can't read bmp file";
		return FALSE;
	}

	BITMAP bm;
	GetObject( hBMP, sizeof(BITMAP), &bm );	// get bitmap attributes

	if (bm.bmWidth != 256 || bm.bmHeight != 40)
	{
		m_strLastError = "Incorrect bmp file";
		DeleteObject(hBMP);
		return FALSE;
	}

	CDC dcBmp;
	dcBmp.CreateCompatibleDC(CDC::FromHandle(GetDC(NULL)));	//Creates a memory device context for the bitmap
	dcBmp.SelectObject(hBMP);			//selects the bitmap in the device context

	INT i;
	for (i=0; i<40*256; ++i)
		m_Data[i/256][i%256] = (dcBmp.GetPixel(i%256, i/256) == 0 ? 0 : 1);

#ifdef _DEBUG
	m_strDebugFile = strFile;
	INT ps = strFile.ReverseFind('\\');
	m_strDebugFile = "Log\\" + strFile.Right(strFile.GetLength() - ps - 1) + ".log";
	SaveDataToTextFile(m_strDebugFile, (BYTE*)m_Data);
#endif

	return TRUE;
}

BOOL CBitmapConverter::SaveDataToTextFile(const CString &strFile, BYTE* pData, BOOL bRewrite /*= TRUE*/, INT H /*= -1*/, INT W /*= -1*/)
{
	CFile fileLog;
	if (!fileLog.Open(strFile, CFile::modeWrite | CFile::modeCreate | (bRewrite ? 0 : CFile::modeNoTruncate) ))
		return FALSE;

	if (!bRewrite)
	{
		fileLog.SeekToEnd();
		fileLog.Write("\r\n****************************************\r\n\r\n", 46);
	}
	
	INT i;
	for (i=0; i<40*256; ++i)
	{
		INT r = i/256;
		INT c = i%256;
		if ((H == -1 || r < H) &&
			(W == -1 || c < W))
		{
			BYTE btChar = '0' + pData[i];
			fileLog.Write(&btChar, 1);
		}
		if ((H == -1 || r < H) && i%256 == 255)
			fileLog.Write("\r\n", 2);
	}
	fileLog.Close();

	return TRUE;
}

BOOL CBitmapConverter::SaveResultToFile(const CString& strFile)
{
	return SaveTextToFile(strFile, m_strResultString, TRUE);
}


BOOL CBitmapConverter::ConvertDataToText()
{
	ConvertDataToLetters();
	ConvertLettersToText();

	CWordSelecter WordSelecter;

	if (!WordSelecter.SelectWord(m_LettersCount, m_Guess, m_strResultString))
	{
		m_strLastError = WordSelecter.GetLastErrorStr();
		return FALSE;
	}

#ifdef _DEBUG
	INT debugI;
	for(debugI=0; debugI<m_LettersCount; ++debugI)
	{
		SaveDataToTextFile(m_strDebugFile, (BYTE*)m_Letters[debugI].m_Data, FALSE, m_Letters[debugI].m_H, m_Letters[debugI].m_W);
		SaveTextToFile(m_strDebugFile, ConvertLetterToDebugText(debugI), FALSE);
	}

	SaveTextToFile(m_strDebugFile, m_strResultString, FALSE);
#endif

	
	return TRUE;
}

BOOL CBitmapConverter::SaveTextToFile(const CString& strFile, const CString& strText, BOOL bRewrite/* = TRUE*/)
{
	CFile file;

	if (!file.Open(strFile, CFile::modeWrite | CFile::modeCreate | (bRewrite ? 0 : CFile::modeNoTruncate) ))
	{
		if (bRewrite)
			m_strLastError = "Can't create text file";
		return FALSE;
	}

	if (!bRewrite)
		file.SeekToEnd();

	file.Write((LPCSTR)strText, strText.GetLength());
	file.Close();

	return TRUE;
}

BOOL CBitmapConverter::ConvertDataToLetters()
{
	m_LettersCount = 0;

	CLetter* pCurLetter = NULL;
	INT LstCol = -10;
	INT r,c;
	for(c=0; c<256; ++c)
		for(r=0; r<40; ++r)
			if (m_Data[r][c])
			{
				if (!pCurLetter || (c - LstCol > 1))
				{
					pCurLetter = &m_Letters[m_LettersCount];
					m_LettersCount++;
					ZeroMemory(pCurLetter, sizeof(CLetter));
					pCurLetter->m_SourceColFirst = c;
				}

				pCurLetter->m_Data[r][c - pCurLetter->m_SourceColFirst] = 1;
				LstCol = c;
				pCurLetter->m_SourceColLast = c;
				pCurLetter->m_PixelsCount++;
			}


	MergeSmallLetters();
	SplitBigLetters();
	
	OptimizeLetters();

	return TRUE;
}

void CBitmapConverter::MergeWithNextLetter(INT ind)
{
	if (ind >= m_LettersCount - 1)
		return;

	INT r,c;
	for(c=0; c<256; ++c)
		for(r=0; r<40; ++r)
			if (m_Letters[ind+1].m_Data[r][c])
			{
				m_Letters[ind].m_Data[r][c + m_Letters[ind+1].m_SourceColFirst - m_Letters[ind].m_SourceColFirst] = 1;
				m_Letters[ind].m_PixelsCount++;
				m_Letters[ind].m_SourceColLast = c + m_Letters[ind+1].m_SourceColFirst;
			}

	::MoveMemory(&m_Letters[ind+1], &m_Letters[ind+2], (m_LettersCount - ind - 2) * sizeof(CLetter));

	m_LettersCount--;
}

void CBitmapConverter::MergeSmallLetters()
{
	INT i=0;
	while (i<m_LettersCount)
	{
		if (m_Letters[i].m_PixelsCount < 20)
		{
			if (i==0)
			{
				MergeWithNextLetter(i);
				continue;
			}

			if (i==m_LettersCount - 1)
			{
				MergeWithNextLetter(i-1);
				continue;
			}

			if (m_Letters[i-1].m_PixelsCount < m_Letters[i+1].m_PixelsCount)
				MergeWithNextLetter(i-1);
			else
				MergeWithNextLetter(i);

			continue;
		}
		++i;
	}
}

void CBitmapConverter::SplitBigLetters()
{
	INT i=0;
	while (i<m_LettersCount)
	{
		if (m_Letters[i].m_SourceColLast - m_Letters[i].m_SourceColFirst > 40)
		{
			if (SplitBigLetter(i))
				continue;
		}
		++i;
	}

}

BOOL CBitmapConverter::SplitBigLetter(INT ind)
{
	INT CurPixels = 0;
	INT cc = -1;
	INT MinPts = 45, CurPts;
	INT r,c;
	for(c=m_Letters[ind].m_SourceColFirst; c<=m_Letters[ind].m_SourceColLast; ++c)
	{
		CurPts = 0;
		for(r=0; r<40; ++r)
			if (m_Letters[ind].m_Data[r][c - m_Letters[ind].m_SourceColFirst])
			{
				++CurPts;
				++CurPixels;
			}

		if (c >= m_Letters[ind].m_SourceColFirst + 15 && c <= m_Letters[ind].m_SourceColLast - 15 &&
			CurPts <= 10 && CurPts < MinPts)
		{
			MinPts = CurPts;

			INT lf = CurPixels;
			INT rf = m_Letters[ind].m_PixelsCount - CurPixels + CurPts;

			if (rf * (c - m_Letters[ind].m_SourceColFirst + 1) > lf * (m_Letters[ind].m_SourceColLast - c + 1))
				cc = c + 1;
			else
				cc = c;
		}

	}

	if (cc == -1)
		return FALSE;

	::MoveMemory(&m_Letters[ind+2], &m_Letters[ind+1], (m_LettersCount - ind - 1) * sizeof(CLetter));
	m_LettersCount++;

	CLetter& l1 = m_Letters[ind];
	CLetter& l2 = m_Letters[ind+1];

	ZeroMemory(&l2, sizeof(CLetter));

	l2.m_SourceColFirst = cc;
	l2.m_SourceColLast = l1.m_SourceColLast;
	l1.m_SourceColLast = cc - 1;

	for(c=cc; c<=l2.m_SourceColLast; ++c)
		for(r=0; r<40; ++r)
			if (l1.m_Data[r][c - l1.m_SourceColFirst])
			{
				l1.m_Data[r][c - l1.m_SourceColFirst] = 0;
				l2.m_Data[r][c - l2.m_SourceColFirst] = 1;
				l1.m_PixelsCount--;
				l2.m_PixelsCount++;
			}

	return TRUE;
}

void CBitmapConverter::OptimizeLetters()
{
	CLetterOptimizer LetterOptimizer;

	INT i;
	for (i=0; i<m_LettersCount; ++i)
		LetterOptimizer.Optimize(m_Letters[i]);
}

void CBitmapConverter::ConvertLettersToText()
{
	CLetterGuesser LetterGuesser;

	m_strResultString = "";
	INT i;
	for (i=0; i<m_LettersCount; ++i)
		LetterGuesser.GuessLetter(m_Letters[i], m_Guess[i]);
}

#ifdef _DEBUG
CString CBitmapConverter::ConvertLetterToDebugText(INT ind)
{
	CString strResult;
	CString strGuess;
	INT j=0;
	while (j<GUESS_COUNT)
	{
		if (m_Guess[ind].m_Guess[m_Guess[ind].m_Result[j]] >= 0.3)
		{
			strGuess.Format("%c %f\r\n", 
				m_Guess[ind].m_cGuessResults[m_Guess[ind].m_Result[j]],
				m_Guess[ind].m_Guess[m_Guess[ind].m_Result[j]]);
			
			strResult += strGuess;
			++j;
		}
		else
			break;
	}

	return strResult;
}
#endif


