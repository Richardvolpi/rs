VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00000080&
   BorderStyle     =   3  'Fixed Dialog
   Caption         =   "About"
   ClientHeight    =   1230
   ClientLeft      =   4815
   ClientTop       =   5490
   ClientWidth     =   4050
   LinkTopic       =   "Form2"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   1230
   ScaleWidth      =   4050
   ShowInTaskbar   =   0   'False
   Begin Project1.cpvButton cpvButton1 
      Height          =   375
      Left            =   480
      TabIndex        =   1
      Top             =   720
      Width           =   2895
      _ExtentX        =   5106
      _ExtentY        =   661
      Appearance      =   0
      ButtonColor     =   128
      Caption         =   "Close"
      FlatOver        =   -1  'True
      BeginProperty Font {0BE35203-8F91-11CE-9DE3-00AA004BB851} 
         Name            =   "Verdana"
         Size            =   9.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      FontColor       =   -2147483634
   End
   Begin VB.Label Label1 
      BackStyle       =   0  'Transparent
      Caption         =   "SbmRune v0.1 BETA By Sbm007.... "
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H8000000E&
      Height          =   375
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   3975
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub cpvButton1_Click()
Unload Me
End Sub
