// OCR.h : main header file for the OCR application
//

#if !defined(AFX_OCR_H__6F909080_29C2_48AC_9942_7ADDF3B40FE7__INCLUDED_)
#define AFX_OCR_H__6F909080_29C2_48AC_9942_7ADDF3B40FE7__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// COCRApp:
// See OCR.cpp for the implementation of this class
//

class COCRApp : public CWinApp
{
public:
	void SilentConvert(const CString& strBitmapFile, const CString& strTextFile);
	COCRApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COCRApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(COCRApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OCR_H__6F909080_29C2_48AC_9942_7ADDF3B40FE7__INCLUDED_)
