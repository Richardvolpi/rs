// ImageTransferClient.h : main header file for the IMAGETRANSFERCLIENT application
//

#if !defined(AFX_IMAGETRANSFERCLIENT_H__BCD907D9_551D_45F5_91A2_FF554FF62BB7__INCLUDED_)
#define AFX_IMAGETRANSFERCLIENT_H__BCD907D9_551D_45F5_91A2_FF554FF62BB7__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"		// main symbols

/////////////////////////////////////////////////////////////////////////////
// CImageTransferClientApp:
// See ImageTransferClient.cpp for the implementation of this class
//

class CImageTransferClientApp : public CWinApp
{
public:
	CImageTransferClientApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CImageTransferClientApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation

	//{{AFX_MSG(CImageTransferClientApp)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_IMAGETRANSFERCLIENT_H__BCD907D9_551D_45F5_91A2_FF554FF62BB7__INCLUDED_)
