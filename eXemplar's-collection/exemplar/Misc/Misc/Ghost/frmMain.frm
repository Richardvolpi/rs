VERSION 5.00
Begin VB.Form frmMain 
   BorderStyle     =   1  'Fixed Single
   Caption         =   "Ghost[ By RegeX ]"
   ClientHeight    =   9675
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   12225
   Icon            =   "frmMain.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   9675
   ScaleWidth      =   12225
   StartUpPosition =   2  'CenterScreen
   Begin VB.Timer timerPlay 
      Enabled         =   0   'False
      Interval        =   100
      Left            =   10680
      Top             =   9000
   End
   Begin VB.Timer timer100ms 
      Interval        =   100
      Left            =   11160
      Top             =   9000
   End
   Begin VB.Timer timer5Sec 
      Index           =   0
      Interval        =   2000
      Left            =   11640
      Top             =   9000
   End
   Begin VB.Frame Frame2 
      Caption         =   "Game 'Window'"
      Height          =   8055
      Left            =   120
      TabIndex        =   1
      Top             =   840
      Width           =   12015
   End
   Begin VB.Frame Frame1 
      Caption         =   "Functions"
      Height          =   615
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   12015
      Begin VB.Image icoTarget 
         Height          =   240
         Left            =   240
         Picture         =   "frmMain.frx":4F0A
         ToolTipText     =   "Drag this over the Runescape applet to enable it"
         Top             =   240
         Width           =   240
      End
   End
   Begin VB.Label lblMousePos 
      Height          =   255
      Left            =   7320
      TabIndex        =   7
      Top             =   9000
      Width           =   1815
   End
   Begin VB.Label Label3 
      Caption         =   "Mouse Position:"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   5640
      TabIndex        =   6
      Top             =   9000
      Width           =   1575
   End
   Begin VB.Label lblStatus 
      Caption         =   "Application intialized"
      Height          =   255
      Left            =   1800
      TabIndex        =   5
      Top             =   9360
      Width           =   3495
   End
   Begin VB.Label Label2 
      Caption         =   "Status:"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   840
      TabIndex        =   4
      Top             =   9360
      Width           =   855
   End
   Begin VB.Label lblHandle 
      Caption         =   "0"
      Height          =   255
      Left            =   1800
      TabIndex        =   3
      Top             =   9000
      Width           =   975
   End
   Begin VB.Label Label1 
      Caption         =   "Window handle:"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   120
      TabIndex        =   2
      Top             =   9000
      Width           =   1575
   End
End
Attribute VB_Name = "frmMain"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
':::: Keep our Application Clean ::::'
Option Explicit

':::: Declarations ::::'
Private Declare Function CreateRectRgn Lib "gdi32" (ByVal X1 As Long, ByVal Y1 As Long, ByVal X2 As Long, ByVal Y2 As Long) As Long
Private Declare Function CreateEllipticRgn Lib "gdi32" (ByVal X1 As Long, ByVal Y1 As Long, ByVal X2 As Long, ByVal Y2 As Long) As Long
Private Declare Function CombineRgn Lib "gdi32" (ByVal hDestRgn As Long, ByVal hSrcRgn1 As Long, ByVal hSrcRgn2 As Long, ByVal nCombineMode As Long) As Long
Private Declare Function SetWindowRgn Lib "user32" (ByVal hwnd As Long, ByVal hRgn As Long, ByVal bRedraw As Long) As Long
Private Declare Function GetDC Lib "user32" (ByVal hwnd As Long) As Long
Private Declare Function GetPixel Lib "gdi32" (ByVal hdc As Long, ByVal x As Long, ByVal y As Long) As Long
Private Declare Function GetCursorPos Lib "user32" (lpPoint As POINTAPI) As Long
Private Declare Function WindowFromPoint Lib "user32" (ByVal xPoint As Long, ByVal yPoint As Long) As Long
Private Declare Function GetWindowPlacement Lib "user32" (ByVal hwnd As Long, lpwndpl As WINDOWPLACEMENT) As Long
Private Declare Function GetWindowRect Lib "user32" (ByVal hwnd As Long, lpRect As RECT) As Long
Private Declare Function SetWindowPos Lib "user32" _
         (ByVal hwnd As Long, ByVal hWndInsertAfter As Long, ByVal x As Long, ByVal y As Long, _
          ByVal cx As Long, ByVal cy As Long, ByVal wFlags As Long) As Long
Const HWND_TOPMOST = -1
Const SWP_NOMOVE = &H2
Const SWP_NOSIZE = &H1
Private Type POINTAPI
  x As Long
  y As Long
End Type
Private Type RECT
    Left As Long
    Top As Long
    Right As Long
    Bottom As Long
End Type
Private Type WINDOWPLACEMENT
    Length As Long
    flags As Long
    showCmd As Long
    ptMinPosition As POINTAPI
    ptMaxPosition As POINTAPI
    rcNormalPosition As RECT
End Type
Dim appletHandle As Long
':::: End Declerations ::::'

':::: Form Initialized ::::'
Private Sub Form_Load()
  Me.Caption = "Ghost [" & App.Path & "]"
  SetWindowPos Me.hwnd, HWND_TOPMOST, 0, 0, 0, 0, SWP_NOMOVE Or SWP_NOSIZE
End Sub
':::: End Form Initialization ::::'

':::: Form being resized ::::'
Private Sub Form_Resize()
  Const RGN_DIFF = 4
  Dim outer_rgn As Long
  Dim inner_rgn As Long
  Dim combined_rgn As Long
  Dim wid As Single
  Dim hgt As Single
  Dim border_width As Single
  Dim title_height As Single

  If WindowState = vbMinimized Then Exit Sub
    
  wid = ScaleX(Width, vbTwips, vbPixels)
  hgt = ScaleY(Height, vbTwips, vbPixels)
  outer_rgn = CreateRectRgn(0, 0, wid, hgt)
    
  border_width = (wid - ScaleWidth) / 2
  title_height = hgt - border_width - ScaleHeight
  inner_rgn = CreateRectRgn(30, 100, 30 + 765, 100 + 503)
  combined_rgn = CreateRectRgn(0, 0, 0, 0)
  CombineRgn combined_rgn, outer_rgn, _
  inner_rgn, RGN_DIFF
  SetWindowRgn hwnd, combined_rgn, True
End Sub
':::: End form being resized ::::'


':::: MouseOver on the target ::::'
Private Sub icoTarget_MouseMove(Button As Integer, Shift As Integer, x As Single, y As Single)
  lblStatus.Caption = "Drag this over the Runescape applet to select it"
End Sub


':::: Selecting new applet ::::'
Private Sub icoTarget_MouseUp(Button As Integer, Shift As Integer, x As Single, y As Single)
  Dim mousePoint As POINTAPI
  lblStatus.Caption = "Selecting new applet"
  GetCursorPos mousePoint
  appletHandle = WindowFromPoint(mousePoint.x, mousePoint.y)
  lblHandle.Caption = appletHandle
  timerPlay.Enabled = True
End Sub

':::: 100ms timer run ::::'
Private Sub timer100ms_Timer()
  Dim mouse As POINTAPI
  GetCursorPos mouse
  lblMousePos.Caption = mouse.x & "," & mouse.y
End Sub

':::: 5 second timer run ::::'
Private Sub timer5Sec_Timer(Index As Integer)
  lblStatus.Caption = "Ready"
End Sub

':::: Timer for when window is visible ::::'
Private Sub timerPlay_Timer()
  Dim pos As RECT
  GetWindowRect appletHandle, pos
  Me.Left = pos.Left
  Me.Top = pos.Top
End Sub
