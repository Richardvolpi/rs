VERSION 5.00
Object = "{F9043C88-F6F2-101A-A3C9-08002B2F49FB}#1.2#0"; "comdlg32.ocx"
Object = "{3B7C8863-D78F-101B-B9B5-04021C009402}#1.2#0"; "Richtx32.ocx"
Begin VB.Form Form1 
   AutoRedraw      =   -1  'True
   BackColor       =   &H00000080&
   BorderStyle     =   1  'Fixed Single
   Caption         =   "SbmRune v0.1 BETA"
   ClientHeight    =   7740
   ClientLeft      =   2160
   ClientTop       =   2190
   ClientWidth     =   9255
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   7740
   ScaleWidth      =   9255
   Begin VB.Timer Timer2 
      Interval        =   1
      Left            =   8280
      Top             =   7320
   End
   Begin VB.Timer Timer1 
      Interval        =   1
      Left            =   8760
      Top             =   7320
   End
   Begin RichTextLib.RichTextBox RichTextBox1 
      Height          =   135
      Left            =   9120
      TabIndex        =   13
      Top             =   0
      Visible         =   0   'False
      Width           =   135
      _ExtentX        =   238
      _ExtentY        =   238
      _Version        =   393217
      TextRTF         =   $"Form1.frx":0000
   End
   Begin MSComDlg.CommonDialog CommonDialog1 
      Left            =   0
      Top             =   7200
      _ExtentX        =   847
      _ExtentY        =   847
      _Version        =   393216
      Filter          =   "*.txt"
   End
   Begin VB.TextBox Text2 
      Appearance      =   0  'Flat
      BackColor       =   &H00000080&
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   6255
      Left            =   4680
      MultiLine       =   -1  'True
      ScrollBars      =   3  'Both
      TabIndex        =   12
      Top             =   960
      Width           =   4455
   End
   Begin VB.TextBox Text1 
      Appearance      =   0  'Flat
      BackColor       =   &H00000080&
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   6255
      Left            =   120
      MultiLine       =   -1  'True
      ScrollBars      =   3  'Both
      TabIndex        =   6
      Top             =   960
      Width           =   4455
   End
   Begin VB.ComboBox Combo1 
      BackColor       =   &H00000080&
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   315
      ItemData        =   "Form1.frx":0082
      Left            =   6120
      List            =   "Form1.frx":0098
      TabIndex        =   2
      Text            =   "Select World"
      Top             =   480
      Width           =   3015
   End
   Begin Project1.cpvButton cpvButton1 
      Height          =   315
      Left            =   3120
      TabIndex        =   0
      Top             =   480
      Width           =   2895
      _ExtentX        =   5106
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Logout"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton4 
      Height          =   315
      Left            =   120
      TabIndex        =   1
      Top             =   480
      Width           =   2895
      _ExtentX        =   5106
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Run bot"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton5 
      Height          =   315
      Left            =   120
      TabIndex        =   3
      Top             =   7320
      Width           =   2895
      _ExtentX        =   5106
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Run"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton6 
      Height          =   315
      Left            =   3120
      TabIndex        =   4
      Top             =   7320
      Width           =   2895
      _ExtentX        =   5106
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Stop"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton7 
      Height          =   315
      Left            =   120
      TabIndex        =   7
      Top             =   120
      Width           =   855
      _ExtentX        =   1508
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "File"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton8 
      Height          =   315
      Left            =   1080
      TabIndex        =   8
      Top             =   120
      Width           =   855
      _ExtentX        =   1508
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Edit"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton9 
      Height          =   315
      Left            =   2040
      TabIndex        =   9
      Top             =   120
      Width           =   855
      _ExtentX        =   1508
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Extra"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton10 
      Height          =   315
      Left            =   3960
      TabIndex        =   10
      Top             =   120
      Width           =   855
      _ExtentX        =   1508
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Help"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin Project1.cpvButton cpvButton2 
      Height          =   315
      Left            =   3000
      TabIndex        =   11
      Top             =   120
      Width           =   855
      _ExtentX        =   1508
      _ExtentY        =   556
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "View"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin VB.Label Label3 
      BackColor       =   &H00000080&
      Caption         =   "Coords: 0,0"
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   8.25
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFFF&
      Height          =   255
      Left            =   6720
      TabIndex        =   5
      Top             =   7380
      Width           =   2415
   End
   Begin VB.Line Line6 
      X1              =   9360
      X2              =   9360
      Y1              =   8520
      Y2              =   -120
   End
   Begin VB.Line Line3 
      X1              =   0
      X2              =   0
      Y1              =   8640
      Y2              =   0
   End
   Begin VB.Line Line2 
      X1              =   9360
      X2              =   9360
      Y1              =   -360
      Y2              =   7320
   End
   Begin VB.Menu mnuFile 
      Caption         =   "File"
      NegotiatePosition=   1  'Left
      Visible         =   0   'False
      Begin VB.Menu mnuNew 
         Caption         =   "New script"
      End
      Begin VB.Menu mnuOpen 
         Caption         =   "Open script"
      End
      Begin VB.Menu mnuSave 
         Caption         =   "Save script"
      End
      Begin VB.Menu mnuSep 
         Caption         =   "-"
      End
      Begin VB.Menu mnuExit 
         Caption         =   "Exit"
      End
   End
   Begin VB.Menu mnuEdit 
      Caption         =   "Edit"
      Visible         =   0   'False
      Begin VB.Menu mnuDebugClear 
         Caption         =   "Clear debug box"
      End
      Begin VB.Menu mnuSep5 
         Caption         =   "-"
      End
      Begin VB.Menu mnuSearch 
         Caption         =   "Search"
      End
      Begin VB.Menu mnuFAR 
         Caption         =   "Find and replace"
      End
      Begin VB.Menu mnuSep3 
         Caption         =   "-"
      End
      Begin VB.Menu mnuCut 
         Caption         =   "Cut"
      End
      Begin VB.Menu mnuCopy 
         Caption         =   "Copy"
      End
      Begin VB.Menu mnuPaste 
         Caption         =   "Paste"
      End
      Begin VB.Menu mnuDel 
         Caption         =   "Delete"
      End
   End
   Begin VB.Menu mnuExtra 
      Caption         =   "Extra"
      Visible         =   0   'False
      Begin VB.Menu mnuAuto 
         Caption         =   "AutoLogin"
         Checked         =   -1  'True
      End
      Begin VB.Menu mnuSep4 
         Caption         =   "-"
      End
      Begin VB.Menu mnuCommand 
         Caption         =   "Command List"
      End
      Begin VB.Menu mnuIDs 
         Caption         =   "NPC ID List"
      End
   End
   Begin VB.Menu mnuView 
      Caption         =   "View"
      Visible         =   0   'False
      Begin VB.Menu mnuScript 
         Caption         =   "Script Box"
         Checked         =   -1  'True
      End
      Begin VB.Menu mnuDebug 
         Caption         =   "Debug Box"
         Checked         =   -1  'True
      End
   End
   Begin VB.Menu mnuHelp 
      Caption         =   "Help"
      Visible         =   0   'False
      Begin VB.Menu mnuAbout 
         Caption         =   "About"
      End
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Combo1_Click()
Open "C:\SbmRune\Temp\tmpchtr4.tmp" For Output As #1
Print #1, Combo1.Text
Close #1
End Sub

Private Sub cpvButton1_Click()
Open "C:\SbmRune\Temp\tmpchtr1.tmp" For Output As #1
Print #1, "DO NOT DELETE THIS FILE"
Wait (1000)
Close #1
End Sub

Private Sub cpvButton10_Click()
PopupMenu mnuHelp, , 3980, 400
End Sub

Private Sub cpvButton2_Click()
PopupMenu mnuView, , 3020, 400
End Sub

Private Sub cpvButton5_Click()
Open "C:\SbmRune\Temp\tmpchtr2a.tmp" For Output As #1
Print #1, "DO NOT DELETE THIS FILE"
Close #1

Open "C:\SbmRune\Temp\tmpchtr2b.tmp" For Output As #1
Print #1, Text1.Text
Close #1
End Sub

Private Sub cpvButton6_Click()
Open "C:\SbmRune\Temp\tmpchtr3.tmp" For Output As #1
Print #1, "DO NOT DELETE THIS FILE"
Close #1
End Sub

Private Sub cpvButton7_Click()
PopupMenu mnuFile, , 140, 400
End Sub

Private Sub cpvButton8_Click()
PopupMenu mnuEdit, , 1100, 400
End Sub

Private Sub cpvButton9_Click()
PopupMenu mnuExtra, , 2060, 400
End Sub

Private Sub Form_Load()
Open "C:\SbmRune\Temp\tmpchtr6.tmp" For Output As #1
Print #1, "DO NOT DELETE THIS FILE"
Close #1
End Sub

Private Sub mnuAbout_Click()
Form2.Show
End Sub

Private Sub mnuAuto_Click()
If mnuAuto.Checked = False Then
mnuAuto.Checked = True
Open "C:\SbmRune\Temp\tmpchtr6.tmp" For Output As #1
Print #1, "DO NOT DELETE THIS FILE"
Close #1
Else
mnuAuto.Checked = False
Kill "C:\SbmRune\Temp\tmpchtr6.tmp"
End If
End Sub

Private Sub mnuCopy_Click()
Clipboard.SetText Text1.SelText
End Sub

Private Sub mnuCut_Click()
Clipboard.SetText Text1.SelText
Text1.SelText = ""
End Sub

Private Sub mnuDebug_Click()
If mnuDebug.Checked = False Then
mnuDebug.Checked = True
Else
mnuDebug.Checked = False
End If
Text2.Visible = mnuDebug.Checked
If Text1.Visible = False Then
Text2.Top = 960
Text2.Left = 120
Text2.Width = 9015
Text2.Height = 6255
Else
Text2.Top = 960
Text2.Left = 4680
Text2.Width = 4455
Text2.Height = 6255

Text1.Top = 960
Text1.Left = 120
Text1.Width = 4455
Text1.Height = 6255
End If

If Text2.Visible = False Then
Text1.Top = 960
Text1.Left = 120
Text1.Width = 9015
Text1.Height = 6255
End If
End Sub

Private Sub mnuDebugClear_Click()
If FileExistsWithDir("C:\SbmRune\Temp\tmpchtr5.tmp") Then
Kill "C:\SbmRune\Temp\tmpchtr5.tmp"
End If
Text2.Text = ""
End Sub

Private Sub mnuDel_Click()
Text1.SelText = ""
End Sub

Private Sub mnuExit_Click()
Unload Form1
End Sub

Private Sub mnuNew_Click()
Text1.Text = ""
End Sub

Private Sub mnuOpen_Click()
    With CommonDialog1
        .DialogTitle = "Open"
        .CancelError = False
        .Filter = "Text Files (*.TXT)|*.TXT|All Files (*.*)|*.*"
        .ShowOpen
    End With
    
RichTextBox1.LoadFile (CommonDialog1.filename)
Text1.Text = RichTextBox1.Text
End Sub

Private Sub mnuPaste_Click()
Text1.SelText = Clipboard.GetText
End Sub

Private Sub mnuSave_Click()
    Dim sFile As String

    With CommonDialog1
        .DialogTitle = "Save"
        .CancelError = False
        .Filter = "Text Files (*.TXT)|*.TXT|All Files (*.*)|*.*"
        .ShowSave

        sFile = .filename
    End With
    
Open sFile For Output As #1
Print #1, Text1
Close #1
End Sub

Private Sub mnuScript_Click()
If mnuScript.Checked = False Then
mnuScript.Checked = True
Else
mnuScript.Checked = False
End If
Text1.Visible = mnuScript.Checked
If Text2.Visible = False Then
Text1.Top = 960
Text1.Left = 120
Text1.Width = 9015
Text1.Height = 6255
Else
Text1.Top = 960
Text1.Left = 120
Text1.Width = 4455
Text1.Height = 6255

Text2.Top = 960
Text2.Left = 4680
Text2.Width = 4455
Text2.Height = 6255
End If

If Text1.Visible = False Then
Text2.Top = 960
Text2.Left = 120
Text2.Width = 9015
Text2.Height = 6255
End If
End Sub

Private Sub Timer1_Timer()
If FileExistsWithDir("C:\SbmRune\Temp\tmpchtr4.tmp") Then
If IsFileNotOpen("C:\SbmRune\Temp\tmpchtr4.tmp") Then
Open "C:\SbmRune\Temp\tmpchtr4.tmp" For Input As #1
Do While Not EOF(1)
Line Input #1, Data
Loop
Close #1

If Label3.Caption <> Data And Data <> "" Then
Label3.Caption = Data
End If

End If
End If
End Sub

Private Function FileExistsWithDir(ByVal filename As String)
Dim file_name As String

    On Error Resume Next
    file_name = Dir$(filename)
    FileExistsWithDir = (file_name <> "")
End Function
   Function IsFileNotOpen(filename As String)
       Dim filenum As Integer, errnum As Integer

       On Error Resume Next   ' Turn error checking off.
       filenum = FreeFile()   ' Get a free file number.
       ' Attempt to open the file and lock it.
       Open filename For Input Lock Read As #filenum
       Close filenum          ' Close the file.
       errnum = Err           ' Save the error number that occurred.
       On Error GoTo 0        ' Turn error checking back on.

       ' Check to see which error occurred.
       Select Case errnum

           ' No error occurred.
           ' File is NOT already open by another user.
           Case 0
               IsFileNotOpen = True

           ' Error number for "Permission Denied."
           ' File is already opened by another user.
           Case 70
               IsFileNotOpen = False

           ' Error number for "File is in use."
           ' File is already opened by another user.
           Case 55
               IsFileNotOpen = False

           ' Another error occurred.
           Case Else
               Error errnum
       End Select
   End Function


Private Sub Timer2_Timer()
If FileExistsWithDir("C:\SbmRune\Temp\tmpchtr5.tmp") Then
If IsFileNotOpen("C:\SbmRune\Temp\tmpchtr5.tmp") Then
Open "C:\SbmRune\Temp\tmpchtr5.tmp" For Input As #1
Do While Not EOF(1)
Line Input #1, Data
Loop
Close #1

If Data <> "" Then
Text2.Text = Text2.Text + vbCrLf + Data
End If

If IsFileNotOpen("C:\SbmRune\Temp\tmpchtr5.tmp") Then
'Kill "C:\SbmRune\Temp\tmpchtr5.tmp"
Else
' Nothing?
End If

End If
End If
End Sub
