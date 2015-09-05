// WordSelecter.h: interface for the CWordSelecter class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_WORDSELECTER_H__04D83248_260A_4890_87DB_C3CB3A9DDEA3__INCLUDED_)
#define AFX_WORDSELECTER_H__04D83248_260A_4890_87DB_C3CB3A9DDEA3__INCLUDED_

#include "BitmapConverter.h"

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

class CWordSelecter  
{
public:
	CWordSelecter();
	virtual ~CWordSelecter();

	BOOL SelectWord(INT nLength, CGuess* Guesses, CString& strResult);

public:
	CString GetLastErrorStr() { return m_strLastError; };

protected:
	CString m_strLastError;
};

#endif // !defined(AFX_WORDSELECTER_H__04D83248_260A_4890_87DB_C3CB3A9DDEA3__INCLUDED_)
