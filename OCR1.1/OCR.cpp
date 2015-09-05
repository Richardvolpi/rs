// OCR.cpp : Defines the class behaviors for the application.
//

#include "stdafx.h"
#include "OCR.h"
#include "OCRDlg.h"

#include "BitmapConverter.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// COCRApp

BEGIN_MESSAGE_MAP(COCRApp, CWinApp)
	//{{AFX_MSG_MAP(COCRApp)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG
	ON_COMMAND(ID_HELP, CWinApp::OnHelp)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COCRApp construction

COCRApp::COCRApp()
{
	// TODO: add construction code here,
	// Place all significant initialization in InitInstance
}

/////////////////////////////////////////////////////////////////////////////
// The one and only COCRApp object

COCRApp theApp;

/////////////////////////////////////////////////////////////////////////////
// COCRApp initialization

BOOL COCRApp::InitInstance()
{
	AfxEnableControlContainer();

	// Standard initialization
	// If you are not using these features and wish to reduce the size
	//  of your final executable, you should remove from the following
	//  the specific initialization routines you do not need.

#ifdef _AFXDLL
	Enable3dControls();			// Call this when using MFC in a shared DLL
#else
	Enable3dControlsStatic();	// Call this when linking to MFC statically
#endif

	CString strCommandLine = m_lpCmdLine;
	CString strParams[2];
	INT nParams = 0;

	while (strCommandLine != "" && nParams < 2)
	{
		INT ps = strCommandLine.Find(' ');
		if (ps != -1)
		{
			strParams[nParams++] = strCommandLine.Left(ps);
			strCommandLine.Delete(0, ps + 1);
			strCommandLine.TrimLeft();
		}
		else
		{
			strParams[nParams++] = strCommandLine;
			strCommandLine = "";
		}
			
	}

	if (nParams == 2)
	{
		SilentConvert(strParams[0], strParams[1]);
		return FALSE;
	}

	COCRDlg dlg;
	m_pMainWnd = &dlg;
	int nResponse = dlg.DoModal();
	if (nResponse == IDOK)
	{
		// TODO: Place code here to handle when the dialog is
		//  dismissed with OK
	}
	else if (nResponse == IDCANCEL)
	{
		// TODO: Place code here to handle when the dialog is
		//  dismissed with Cancel
	}

	// Since the dialog has been closed, return FALSE so that we exit the
	//  application, rather than start the application's message pump.
	return FALSE;
}

void COCRApp::SilentConvert(const CString& strBitmapFile, const CString& strTextFile)
{
	CBitmapConverter BitmapConverter;

	if (!BitmapConverter.LoadDataFromBitmap(strBitmapFile))
		return;

	if (!BitmapConverter.ConvertDataToText())
		return;

	if (!BitmapConverter.SaveResultToFile(strTextFile))
		return;

}
