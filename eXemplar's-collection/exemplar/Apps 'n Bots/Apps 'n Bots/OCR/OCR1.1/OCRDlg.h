// OCRDlg.h : header file
//

#if !defined(AFX_OCRDLG_H__8AC1A9B1_E67A_458A_B76B_660370AB328D__INCLUDED_)
#define AFX_OCRDLG_H__8AC1A9B1_E67A_458A_B76B_660370AB328D__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// COCRDlg dialog

class COCRDlg : public CDialog
{
// Construction
public:
	BOOL CheckFileTime(const CString& strFile, BOOL& bNeedToConvert);
	COCRDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(COCRDlg)
	enum { IDD = IDD_OCR_DIALOG };
	CEdit	m_edTextFile;
	CEdit	m_edBitmapFile;
	CString	m_strBitmapFile;
	CString	m_strTextFile;
	BOOL	m_bSleep;
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(COCRDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL


// Implementation
protected:
	BOOL ConvertFile();
	BOOL StopSleep();
	BOOL StartSleep();

	HICON m_hIcon;
	FILETIME m_ftLastAccess;

	// Generated message map functions
	//{{AFX_MSG(COCRDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnBtnConvert();
	afx_msg void OnBtnBitmapSelect();
	afx_msg void OnBtnTextSelect();
	afx_msg void OnChSleep();
	afx_msg void OnTimer(UINT nIDEvent);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_OCRDLG_H__8AC1A9B1_E67A_458A_B76B_660370AB328D__INCLUDED_)
