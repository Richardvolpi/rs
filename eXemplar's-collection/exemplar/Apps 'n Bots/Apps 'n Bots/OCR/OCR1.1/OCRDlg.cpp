// OCRDlg.cpp : implementation file
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

#define SLEEP_REFRESH_TIME 300

/////////////////////////////////////////////////////////////////////////////
// CAboutDlg dialog used for App About

class CAboutDlg : public CDialog
{
public:
	CAboutDlg();

// Dialog Data
	//{{AFX_DATA(CAboutDlg)
	enum { IDD = IDD_ABOUTBOX };
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CAboutDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	//{{AFX_MSG(CAboutDlg)
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialog(CAboutDlg::IDD)
{
	//{{AFX_DATA_INIT(CAboutDlg)
	//}}AFX_DATA_INIT
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CAboutDlg)
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialog)
	//{{AFX_MSG_MAP(CAboutDlg)
		// No message handlers
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COCRDlg dialog

COCRDlg::COCRDlg(CWnd* pParent /*=NULL*/)
	: CDialog(COCRDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(COCRDlg)
	m_strBitmapFile = _T("");
	m_strTextFile = _T("");
	m_bSleep = FALSE;
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void COCRDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(COCRDlg)
	DDX_Control(pDX, IDC_ED_TEXT, m_edTextFile);
	DDX_Control(pDX, IDC_ED_BITMAP, m_edBitmapFile);
	DDX_Text(pDX, IDC_ED_BITMAP, m_strBitmapFile);
	DDX_Text(pDX, IDC_ED_TEXT, m_strTextFile);
	DDX_Check(pDX, IDC_CH_SLEEP, m_bSleep);
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(COCRDlg, CDialog)
	//{{AFX_MSG_MAP(COCRDlg)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BTN_CONVERT, OnBtnConvert)
	ON_BN_CLICKED(IDC_BTN_BITMAP_SELECT, OnBtnBitmapSelect)
	ON_BN_CLICKED(IDC_BTN_TEXT_SELECT, OnBtnTextSelect)
	ON_BN_CLICKED(IDC_CH_SLEEP, OnChSleep)
	ON_WM_TIMER()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// COCRDlg message handlers

BOOL COCRDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Add "About..." menu item to system menu.

/*
	// IDM_ABOUTBOX must be in the system command range.
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		CString strAboutMenu;
		strAboutMenu.LoadString(IDS_ABOUTBOX);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

*/

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon

	// TODO: Add extra initialization here
	m_strBitmapFile = AfxGetApp()->GetProfileString("Strings", "BmpFile", "");
	m_strTextFile = AfxGetApp()->GetProfileString("Strings", "TxtFile", "");

	UpdateData(FALSE);
	
	return TRUE;  // return TRUE  unless you set the focus to a control
}

void COCRDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialog::OnSysCommand(nID, lParam);
	}
}

// If you add a minimize button to your dialog, you will need the code below
//  to draw the icon.  For MFC applications using the document/view model,
//  this is automatically done for you by the framework.

void COCRDlg::OnPaint() 
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, (WPARAM) dc.GetSafeHdc(), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR COCRDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

void COCRDlg::OnBtnConvert() 
{
	// TODO: Add your control notification handler code here
	UpdateData(TRUE);

	AfxGetApp()->WriteProfileString("Strings", "BmpFile", m_strBitmapFile);
	AfxGetApp()->WriteProfileString("Strings", "TxtFile", m_strTextFile);

	CBitmapConverter BitmapConverter;

	if (!BitmapConverter.LoadDataFromBitmap(m_strBitmapFile))
	{
		MessageBox("Error while reading BITMAP");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return;
	}

	if (!BitmapConverter.ConvertDataToText())
	{
		MessageBox("Error while parsing BITMAP");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return;
	}

	if (!BitmapConverter.SaveResultToFile(m_strTextFile))
	{
		MessageBox("Error while saving result");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return;
	}
}

void COCRDlg::OnBtnBitmapSelect() 
{
	// TODO: Add your control notification handler code here
	UpdateData(TRUE);

	CFileDialog dlg(TRUE, "bmp", m_strBitmapFile, OFN_FILEMUSTEXIST, 
		"Bitmap Files (*.bmp)|*.bmp||", this);

	if (dlg.DoModal() == IDOK)
	{
		m_strBitmapFile = dlg.GetPathName();
		UpdateData(FALSE);
	}
}



void COCRDlg::OnBtnTextSelect() 
{
	// TODO: Add your control notification handler code here
	UpdateData(TRUE);

	CFileDialog dlg(FALSE, "txt", m_strTextFile, OFN_NOREADONLYRETURN | OFN_PATHMUSTEXIST, 
		"Text Files (*.txt)|*.txt|All Files (*.*)|*.*||", this);

	if (dlg.DoModal() == IDOK)
	{
		m_strTextFile = dlg.GetPathName();
		UpdateData(FALSE);
	}
	
}

void COCRDlg::OnChSleep() 
{
	// TODO: Add your control notification handler code here
	UpdateData(TRUE);

	if (m_bSleep)
		StartSleep();
	else
		StopSleep();
	
}

BOOL COCRDlg::ConvertFile()
{
	UpdateData(TRUE);

	if (!m_bSleep)
	{
		StopSleep();
		return FALSE;
	}

	AfxGetApp()->WriteProfileString("Strings", "BmpFile", m_strBitmapFile);
	AfxGetApp()->WriteProfileString("Strings", "TxtFile", m_strTextFile);

	BOOL bNeedToConvert;
	if (!CheckFileTime(m_strBitmapFile, bNeedToConvert))
	{
		StopSleep();
		MessageBox("Error while reading BITMAP");
		MessageBox("Can't read file's attributes");
		return FALSE;
	}

	if (!bNeedToConvert)
		return TRUE;

	CBitmapConverter BitmapConverter;

	if (!BitmapConverter.LoadDataFromBitmap(m_strBitmapFile))
	{
		StopSleep();
		MessageBox("Error while reading BITMAP");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return FALSE;
	}

	if (!BitmapConverter.ConvertDataToText())
	{
		StopSleep();
		MessageBox("Error while parsing BITMAP");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return FALSE;
	}

	if (!BitmapConverter.SaveResultToFile(m_strTextFile))
	{
		StopSleep();
		MessageBox("Error while saving result");
		MessageBox(BitmapConverter.GetLastErrorStr());
		return FALSE;
	}

	return TRUE;

}

BOOL COCRDlg::StartSleep()
{
	UpdateData(TRUE);
	m_bSleep = TRUE;
	m_edBitmapFile.EnableWindow(FALSE);
	m_edTextFile.EnableWindow(FALSE);
	UpdateData(FALSE);

	ZeroMemory(&m_ftLastAccess, sizeof(m_ftLastAccess));
	if (!ConvertFile())
		return FALSE;

	SetTimer(IDT_SLEEP_TIMER, SLEEP_REFRESH_TIME, NULL);
	return TRUE;
}

BOOL COCRDlg::StopSleep()
{
	UpdateData(TRUE);
	m_bSleep = FALSE;
	m_edBitmapFile.EnableWindow(TRUE);
	m_edTextFile.EnableWindow(TRUE);
	UpdateData(FALSE);
	KillTimer(IDT_SLEEP_TIMER);

	return TRUE;
}

void COCRDlg::OnTimer(UINT nIDEvent) 
{
	// TODO: Add your message handler code here and/or call default
	if (nIDEvent == IDT_SLEEP_TIMER)
	{
		ConvertFile();
		return;
	}

	CDialog::OnTimer(nIDEvent);
}

BOOL COCRDlg::CheckFileTime(const CString &strFile, BOOL &bNeedToConvert)
{

	WIN32_FILE_ATTRIBUTE_DATA attrData;
	
	if (!GetFileAttributesEx(strFile, GetFileExInfoStandard, &attrData))
		return FALSE;

	bNeedToConvert = (CompareFileTime(&m_ftLastAccess, &attrData.ftLastWriteTime) < 0);
	m_ftLastAccess = attrData.ftLastWriteTime;

	return TRUE;
}
