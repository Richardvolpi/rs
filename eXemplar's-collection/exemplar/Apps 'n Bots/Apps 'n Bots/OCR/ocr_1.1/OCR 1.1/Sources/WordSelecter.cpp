// WordSelecter.cpp: implementation of the CWordSelecter class.
//
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "OCR.h"
#include "WordSelecter.h"

#include <math.h>

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

CWordSelecter::CWordSelecter()
{

}

CWordSelecter::~CWordSelecter()
{

}


BOOL CWordSelecter::SelectWord(INT nLength, CGuess* Guesses, CString& strResult)
{
	CString strDictPath;
	strDictPath.LoadString(IDS_DICT_PATH);

	
	CFile fileDict;
	if (!fileDict.Open(strDictPath, CFile::modeRead | CFile::shareDenyWrite))
	{
		m_strLastError = "Can't open dictionary file";
		return FALSE;
	}

	CArchive arDict(&fileDict, CArchive::load);

	DOUBLE bestVal = -1;
	DOUBLE curVal;
	INT i;

	strResult = "";
	for(i=0; i<nLength; ++i)
		strResult += '?';

	CString strWord;
	while (arDict.ReadString(strWord))
	{
		if (strWord.GetLength() != nLength)
			continue;

		strWord.MakeLower();

		curVal = 0;

		for(i=0; i<nLength; ++i)
		{
			CHAR ch = strWord.GetAt(i);
			if (ch < 'a' || ch > 'z')
			{
				curVal = -2;
				break;
			}
			curVal += pow(Guesses[i].m_Guess[ch-'a'], 2);
			//curVal += Guesses[i].m_Guess[ch-'a'];
		}

		if (curVal > bestVal)
		{
			bestVal = curVal;
			strResult = strWord;
		}
	}

	arDict.Close();
	fileDict.Close();

	return TRUE;
}
