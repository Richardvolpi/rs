// ImageTransferClientDlg.cpp : implementation file
//

#include "stdafx.h"
#include "ImageTransferClient.h"
#include "ImageTransferClientDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

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
// CImageTransferClientDlg dialog

CImageTransferClientDlg::CImageTransferClientDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CImageTransferClientDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(CImageTransferClientDlg)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CImageTransferClientDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CImageTransferClientDlg)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CImageTransferClientDlg, CDialog)
	//{{AFX_MSG_MAP(CImageTransferClientDlg)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_WM_HELPINFO()
	ON_BN_CLICKED(IDC_TRANSFER_BUTTON, OnTransferButton)
	ON_BN_CLICKED(IDC_EXIT_BUTTON, OnExitButton)
	ON_WM_CLOSE()
	ON_BN_CLICKED(IDC_BROWSE_BUTTON, OnBrowseButton)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CImageTransferClientDlg message handlers

BOOL CImageTransferClientDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Add "About..." menu item to system menu.

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

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon
	
	// TODO: Add extra initialization here
	SetDlgItemText(IDC_ADDRESS_EDIT,	"localhost");
	SetDlgItemText(IDC_PORT_EDIT,		"34000");
	
	GetDlgItem(IDC_LOGIN_EDIT)->SetFocus();

	return FALSE;
}

void CImageTransferClientDlg::OnSysCommand(UINT nID, LPARAM lParam)
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

void CImageTransferClientDlg::OnPaint() 
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
HCURSOR CImageTransferClientDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

BOOL CImageTransferClientDlg::OnHelpInfo(HELPINFO* pHelpInfo) 
{
	return TRUE;
}

void CImageTransferClientDlg::OnClose() 
{
	if(MessageBox(	"Are you sure you want to exit",
					"Confirmation",
					MB_YESNO | MB_ICONQUESTION) != IDYES)
	{
		return;
	}

	EndDialog(IDCANCEL);
}

void CImageTransferClientDlg::OnExitButton()
{
	OnClose();
}

void CImageTransferClientDlg::OnBrowseButton() 
{
	CFileDialog Dialog(	TRUE,
						"bmp",
						"",
						OFN_FILEMUSTEXIST,
						"Bitmap files (*.bmp)|*.bmp||",
						this);

	if(Dialog.DoModal() != IDOK)
		return;

	SetDlgItemText(IDC_FILE_EDIT, Dialog.GetPathName());
}

void CImageTransferClientDlg::OnTransferButton()
{
	CString Address;
	CString Port;
	CString Login;
	CString Password;
	CString FileName;

	char Result[1024];

	GetDlgItemText(IDC_ADDRESS_EDIT,	Address);
	GetDlgItemText(IDC_PORT_EDIT,		Port);
	GetDlgItemText(IDC_LOGIN_EDIT,		Login);
	GetDlgItemText(IDC_PASSWORD_EDIT,	Password);
	GetDlgItemText(IDC_FILE_EDIT,		FileName);

	// !!!
	int ret = QueryImageServer(	Address,
								atoi(Port),
								Login,
								Password,
								FileName,
								Result,
								sizeof(Result),
								TRUE);

	switch(ret)
	{
	case CLNT_ERR_OK:
		MessageBox(	(CString)"Success, result string: \"" + Result + "\".",
					"Message",
					MB_OK | MB_ICONINFORMATION);

		return;

	case CLNT_ERR_INVALID_ARG:
		MessageBox(	"Invalid argument.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;

	case CLNT_ERR_FILE_NOT_FOUND:
		MessageBox(	"File not found.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;

	case CLNT_ERR_RESOLVE_HOST_FAILED:
		MessageBox(	"Error resolving server host name.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;

	case CLNT_ERR_UNABLE_TO_CONNECT:
		MessageBox(	"Error connecting the server.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;

	case CLNT_ERR_INVALID_SERVER_CERTIFICATE:
		MessageBox(	"Invalid server certificate.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;

	case CLNT_ERR_OTHER:
		MessageBox(	"Other server error. Probably bad login/password.",
					"Error",
					MB_OK | MB_ICONSTOP);

		return;
	}
}