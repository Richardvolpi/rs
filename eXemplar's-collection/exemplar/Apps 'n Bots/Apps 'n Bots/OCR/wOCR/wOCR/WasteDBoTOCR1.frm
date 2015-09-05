VERSION 5.00
Begin VB.Form WasteDBoTOCR1 
   Appearance      =   0  'Flat
   BackColor       =   &H00404040&
   BorderStyle     =   1  'Fixed Single
   Caption         =   "WasteDBoT - Word Processer"
   ClientHeight    =   1905
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   9135
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   1905
   ScaleWidth      =   9135
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame SLWordFrame 
      BackColor       =   &H00404040&
      Height          =   975
      Left            =   120
      TabIndex        =   14
      Top             =   0
      Width           =   4095
      Begin VB.PictureBox SLWord 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H80000005&
         BorderStyle     =   0  'None
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Left            =   120
         Picture         =   "WasteDBoTOCR1.frx":0000
         ScaleHeight     =   585
         ScaleMode       =   0  'User
         ScaleWidth      =   3825
         TabIndex        =   15
         Top             =   240
         Width           =   3825
      End
   End
   Begin VB.Frame Frame1 
      BackColor       =   &H00404040&
      Height          =   855
      Left            =   120
      TabIndex        =   12
      Top             =   960
      Width           =   4095
      Begin VB.PictureBox picModify 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   11
         Left            =   3480
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   19
         Top             =   120
         Width           =   585
      End
      Begin VB.CommandButton BTNRead 
         BackColor       =   &H8000000C&
         Caption         =   "Read Entire Word"
         Height          =   255
         Left            =   120
         Style           =   1  'Graphical
         TabIndex        =   13
         Top             =   240
         Width           =   3135
      End
      Begin VB.Label DaWord 
         Alignment       =   2  'Center
         BackStyle       =   0  'Transparent
         BeginProperty Font 
            Name            =   "MS Sans Serif"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FFFFFF&
         Height          =   255
         Left            =   120
         TabIndex        =   18
         Top             =   480
         Width           =   3135
      End
   End
   Begin VB.Frame Frame3 
      BackColor       =   &H00404040&
      Height          =   1695
      Left            =   4320
      TabIndex        =   0
      Top             =   120
      Width           =   4695
      Begin VB.TextBox Text1 
         Height          =   285
         Left            =   3720
         TabIndex        =   17
         Text            =   "HC.bmp"
         Top             =   960
         Width           =   615
      End
      Begin VB.CommandButton LOAD 
         Appearance      =   0  'Flat
         Caption         =   "LOAD"
         Height          =   195
         Left            =   3720
         TabIndex        =   16
         Top             =   1320
         Width           =   615
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   8
         Left            =   1560
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   11
         Top             =   960
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   3
         Left            =   2280
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   10
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   7
         Left            =   840
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   9
         Top             =   960
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   6
         Left            =   120
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   8
         Top             =   960
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   5
         Left            =   3720
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   7
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   4
         Left            =   3000
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   6
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   2
         Left            =   1560
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   5
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   1
         Left            =   840
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   4
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   0
         Left            =   120
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   3
         Top             =   240
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   9
         Left            =   2280
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   2
         Top             =   960
         Width           =   585
      End
      Begin VB.PictureBox Letter 
         Appearance      =   0  'Flat
         AutoRedraw      =   -1  'True
         BackColor       =   &H00FFFFFF&
         CausesValidation=   0   'False
         ClipControls    =   0   'False
         ForeColor       =   &H80000008&
         Height          =   585
         Index           =   10
         Left            =   3000
         ScaleHeight     =   555
         ScaleMode       =   0  'User
         ScaleWidth      =   555
         TabIndex        =   1
         Top             =   960
         Width           =   585
      End
   End
End
Attribute VB_Name = "WasteDBoTOCR1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Declare Function BitBlt Lib "gdi32" (ByVal hDestDC As Long, ByVal x As Long, ByVal Y As Long, ByVal nWidth As Long, ByVal nHeight As Long, ByVal hSrcDC As Long, ByVal xSrc As Long, ByVal ySrc As Long, ByVal dwRop As Long) As Long
Private Declare Function SetPixel Lib "gdi32" (ByVal hdc As Long, ByVal x As Long, ByVal Y As Long, ByVal crColor As Long) As Long
Private Declare Function GetPixel Lib "gdi32" (ByVal hdc As Long, ByVal x As Long, ByVal Y As Long) As Long
Private Declare Function SetStretchBltMode Lib "gdi32" (ByVal hdc As Long, ByVal hStretchMode As Long) As Long
Private Declare Function StretchBlt Lib "gdi32" (ByVal hdc As Long, ByVal x As Long, ByVal Y As Long, ByVal nWidth As Long, ByVal nHeight As Long, ByVal hSrcDC As Long, ByVal xSrc As Long, ByVal ySrc As Long, ByVal nSrcWidth As Long, ByVal nSrcHeight As Long, ByVal dwRop As Long) As Long
Const STRETCHMODE = vbPaletteModeNone
Dim LetterHigh(10) As Integer
Dim LetterLow(10) As Integer
Dim LetterStart(10) As Integer
Dim LetterEnd(10) As Integer
Dim LetterFound(10) As Boolean
Sub SplitLetters()
    Dim FoundLetter, LineBlank As Boolean
    Dim x, Y, dacount As Integer
    Dim last_x As Integer
    Dim top_x, top_y As Integer
    Dim bottom_x, bottom_y As Integer
    Dim i, j As Integer
    Dim Word As String
    For i = 0 To 10
    LetterFound(i) = False
    Letter(i).Cls
    Next i
    LineBlank = True
    FoundLetter = False
    dacount = -1
    For x = 0 To SLWord.ScaleWidth
        LineBlank = True
        For Y = 1 To SLWord.ScaleHeight
            If GetPixel(SLWord.hdc, x, Y) > 0 Then
                LineBlank = False
                FoundLetter = True
            End If
            DoEvents
        Next Y
        If LineBlank = True And FoundLetter = True Then
           dacount = Val(dacount) + 1
            Letter(dacount).Cls
            BitBlt Letter(dacount).hdc, 0, 0, x - last_x, SLWord.ScaleHeight, SLWord.hdc, last_x, 0, vbNotSrcCopy
            Letter(dacount).Refresh
            LetterFound(dacount) = True
            Letter(dacount).Visible = True
            last_x = x
            FoundLetter = False
             Call SetStretchBltMode(WasteDBoTOCR.userDrawArea.hdc, STRETCHMODE)
             WasteDBoTOCR.userDrawArea.Cls
             Call StretchBlt(WasteDBoTOCR.userDrawArea.hdc, 0, 0, 400, 400, Letter(dacount).hdc, 0, 0, Letter(dacount).Height / 4, Letter(dacount).Width / 4, vbSrcCopy)
             WasteDBoTOCR.userDrawArea.Refresh
             WasteDBoTOCR.userDrawArea.Refresh
             WasteDBoTOCR.GraspRawData
             Word = Word & WasteDBoTOCR.ReCogNitIon
             DaWord.Caption = UCase(Word)
        End If
        DoEvents
    Next x
End Sub
Private Sub BTNRead_Click()
SplitLetters
End Sub
Private Sub Form_QueryUnload(Cancel As Integer, UnloadMode As Integer)
End
End Sub
Private Sub Letter_Click(Index As Integer)
 Call SetStretchBltMode(WasteDBoTOCR.userDrawArea.hdc, STRETCHMODE)
 WasteDBoTOCR.userDrawArea.Cls
 Call StretchBlt(WasteDBoTOCR.userDrawArea.hdc, 0, 0, 400, 400, Letter(Index).hdc, 0, 0, Letter(Index).Height / 4, Letter(Index).Width / 4, vbSrcCopy)
 WasteDBoTOCR.userDrawArea.Refresh
 WasteDBoTOCR.GraspRawData
End Sub
Private Sub LOAD_Click()
On Error Resume Next
SLWord.Picture = LoadPicture(App.Path & "\HCS\" & Text1.Text)
LoadPicture
End Sub
