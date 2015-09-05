VERSION 5.00
Begin VB.UserControl cpvButton 
   ClientHeight    =   8985
   ClientLeft      =   0
   ClientTop       =   0
   ClientWidth     =   11250
   ClipControls    =   0   'False
   DefaultCancel   =   -1  'True
   EditAtDesignTime=   -1  'True
   ScaleHeight     =   599
   ScaleMode       =   3  'Pixel
   ScaleWidth      =   750
   Begin VB.Timer OverTimer 
      Enabled         =   0   'False
      Interval        =   10
      Left            =   2040
      Top             =   1920
   End
End
Attribute VB_Name = "cpvButton"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = True
Attribute VB_PredeclaredId = False
Attribute VB_Exposed = False
Attribute VB_Ext_KEY = "PropPageWizardRun" ,"Yes"
'   #############################
'         cpvButton OCX 1.2
'
'         Carles P.V., 2001
'     Email: carles_pv@terra.es
'   #############################


'   Last modified 08/24/01

'   *New*: 1. Appearance modes:
'             0: StandardFlat = Standard button (Flat)
'             1: Standard3D   = Standard button  (3D)  [default]
'             2: CheckFlat    = Check button    (Flat)
'             3: Check3D      = Check button     (3D)
'
'          2. FlatOver property:
'             True/False. True = Flat effect only if mouse over
'
'          3. ShortCuts accepted


Option Explicit

'Enumerated Constants:
Public Enum JustifyConstants
            [JustifyLeft]
            [JustifyCenter]
            [JustifyRight]
End Enum

Public Enum AlignConstants
            [AlignNone]
            [AlignTop]
            [AlignBottom]
            [AlignLeft]
            [AlignRight]
End Enum

Public Enum ButtonAppearanceConstants
            [StandardFlat]
            [Standard3D]
            [CheckFlat]
            [Check3D]
End Enum

Public Enum ButtonStyleConstants
            [Standard]
            [Graphical]
End Enum

'Private variables:
Private g_HasFocus As Boolean
Private g_FocusRect As RECT

Private g_TextWithPicture As Boolean
Private g_TextRectUp As RECT, g_TextRectDown As RECT

Private g_3DInc As Integer

Private g_MouseDown As Boolean, g_MouseIn As Boolean
Private g_Button As Integer, g_Shift As Integer, g_X As Single, g_Y As Single

Private g_KeyPressed As Boolean

Private WithEvents g_Font As StdFont    'No more font problems
Attribute g_Font.VB_VarHelpID = -1

'Default Property Values:
Private Const m_def_Appearance = 1      'Standard3D
Private Const m_def_Checked = False     'Unchecked
Private Const m_def_CaptionAlign = 0    'AlignNone (Center)
Private Const m_def_CaptionJustify = 1  'JustifyCenter
Private Const m_def_FlatOver = False    'Flat effect always
Private Const m_def_Style = 0           'Standard3D
Private Const m_def_PictureTab = 0
Private Const m_def_ShowBorderOnFocus = True
Private Const m_def_ShowFocusRect = True
Private Const m_def_UseMaskColor = False

'Property Variables:
Private m_Appearance As ButtonAppearanceConstants
Private m_Checked As Boolean
Private m_Caption As String
Private m_CaptionAlign As AlignConstants
Private m_CaptionJustify As JustifyConstants
Private m_FlatOver As Boolean
Private m_Style As ButtonStyleConstants
Private m_ShowBorderOnFocus As Boolean
Private m_ShowFocusRect As Boolean
Private m_UseMaskColor As Boolean

Private m_Picture As StdPicture
Private m_PictureDown As StdPicture
Private m_PictureOver As StdPicture
Private m_PictureDisabled As StdPicture
Private m_PictureTab As Integer

Private g_Light As OLE_COLOR
Private g_Shadow As OLE_COLOR
Private g_HighLight As OLE_COLOR
Private g_DarkShadow As OLE_COLOR

'Event Declarations:
Public Event Click()
Public Event KeyDown(KeyCode As Integer, Shift As Integer)
Public Event KeyPress(KeyAscii As Integer)
Public Event KeyUp(KeyCode As Integer, Shift As Integer)
Public Event MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
Public Event MouseMove(Button As Integer, Shift As Integer, X As Single, Y As Single)
Public Event MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)
Public Event MouseIn(Shift As Integer)
Public Event MouseOut(Shift As Integer)







'################################################################################
'  Init / read / write properties
'################################################################################

Private Sub UserControl_InitProperties()

    m_Appearance = m_def_Appearance
    m_Checked = m_def_Checked
    m_Caption = Ambient.DisplayName
    m_CaptionAlign = m_def_CaptionAlign
    m_CaptionJustify = m_def_CaptionJustify
    m_FlatOver = m_def_FlatOver
    m_Style = m_def_Style
    m_ShowBorderOnFocus = m_def_ShowBorderOnFocus
    m_ShowFocusRect = m_def_ShowFocusRect
    m_UseMaskColor = m_def_UseMaskColor
    
    Set UserControl.Font = Ambient.Font
    Set g_Font = Ambient.Font
    
    Set m_Picture = LoadPicture("")
    Set m_PictureDisabled = LoadPicture("")
    Set m_PictureDown = LoadPicture("")
    Set m_PictureOver = LoadPicture("")
    m_PictureTab = m_def_PictureTab
    
    UserControl.BackColor = Ambient.BackColor
    Get3DButtonColors UserControl.BackColor
    
    AccessKeys = Mid(m_Caption, InStr(1, m_Caption, "&") + 1, 1)

End Sub

Private Sub UserControl_ReadProperties(PropBag As PropertyBag)

    m_Appearance = PropBag.ReadProperty("Appearance", m_def_Appearance)
    m_Checked = PropBag.ReadProperty("Checked", m_def_Checked)
    m_Caption = PropBag.ReadProperty("Caption", Ambient.DisplayName)
    m_CaptionAlign = PropBag.ReadProperty("CaptionAlign", m_def_CaptionAlign)
    m_CaptionJustify = PropBag.ReadProperty("CaptionJustify", m_def_CaptionJustify)
    m_FlatOver = PropBag.ReadProperty("FlatOver", m_def_FlatOver)
    m_Style = PropBag.ReadProperty("Style", m_def_Style)
    m_ShowFocusRect = PropBag.ReadProperty("ShowFocusRect", m_def_ShowFocusRect)
    m_ShowBorderOnFocus = PropBag.ReadProperty("ShowBorderOnFocus", m_def_ShowBorderOnFocus)
    m_UseMaskColor = PropBag.ReadProperty("UseMaskColor", m_def_UseMaskColor)
    
    Set UserControl.Font = PropBag.ReadProperty("Font", Ambient.Font)
    Set g_Font = PropBag.ReadProperty("Font", Ambient.Font)
    
    Set m_Picture = PropBag.ReadProperty("Picture", Nothing)
    Set m_PictureDisabled = PropBag.ReadProperty("PictureDisabled", Nothing)
    Set m_PictureDown = PropBag.ReadProperty("PictureDown", Nothing)
    Set m_PictureOver = PropBag.ReadProperty("PictureOver", Nothing)
    m_PictureTab = PropBag.ReadProperty("PictureTab", m_def_PictureTab)
    Set MouseIcon = PropBag.ReadProperty("MouseIcon", Nothing)
    
    UserControl.BackColor = PropBag.ReadProperty("ButtonColor", &H8000000F)
    Get3DButtonColors UserControl.BackColor
    UserControl.Enabled = PropBag.ReadProperty("Enabled", True)
    UserControl.ForeColor = PropBag.ReadProperty("FontColor", &H80000012)
    UserControl.MaskColor = PropBag.ReadProperty("MaskColor", &H8000000F)
    UserControl.MousePointer = PropBag.ReadProperty("MousePointer", 0)
    
    AccessKeys = Mid(m_Caption, InStr(1, m_Caption, "&") + 1, 1)
   
End Sub

Private Sub UserControl_WriteProperties(PropBag As PropertyBag)

    Call PropBag.WriteProperty("Appearance", m_Appearance, m_def_Appearance)
    Call PropBag.WriteProperty("ButtonColor", UserControl.BackColor, &H8000000F)
    Call PropBag.WriteProperty("Caption", m_Caption, Ambient.DisplayName)
    Call PropBag.WriteProperty("CaptionAlign", m_CaptionAlign, m_def_CaptionAlign)
    Call PropBag.WriteProperty("CaptionJustify", m_CaptionJustify, m_def_CaptionJustify)
    Call PropBag.WriteProperty("Checked", m_Checked, m_def_Checked)
    Call PropBag.WriteProperty("Enabled", UserControl.Enabled, True)
    Call PropBag.WriteProperty("FlatOver", m_FlatOver, m_def_FlatOver)
    Call PropBag.WriteProperty("Font", UserControl.Font, Ambient.Font)
    Call PropBag.WriteProperty("FontColor", UserControl.ForeColor, &H80000012)
    Call PropBag.WriteProperty("MaskColor", UserControl.MaskColor, &H8000000F)
    Call PropBag.WriteProperty("MouseIcon", MouseIcon, Nothing)
    Call PropBag.WriteProperty("MousePointer", UserControl.MousePointer, 0)
    Call PropBag.WriteProperty("Picture", m_Picture, Nothing)
    Call PropBag.WriteProperty("PictureDisabled", m_PictureDisabled, Nothing)
    Call PropBag.WriteProperty("PictureDown", m_PictureDown, Nothing)
    Call PropBag.WriteProperty("PictureOver", m_PictureOver, Nothing)
    Call PropBag.WriteProperty("PictureTab", m_PictureTab, m_def_PictureTab)
    Call PropBag.WriteProperty("ShowBorderOnFocus", m_ShowBorderOnFocus, m_def_ShowBorderOnFocus)
    Call PropBag.WriteProperty("ShowFocusRect", m_ShowFocusRect, m_def_ShowFocusRect)
    Call PropBag.WriteProperty("Style", m_Style, m_def_Style)
    Call PropBag.WriteProperty("UseMaskColor", m_UseMaskColor, m_def_UseMaskColor)
 
 End Sub

'################################################################################
'  'Ambient' control
'################################################################################

Private Sub UserControl_Initialize()

    Set g_Font = New StdFont
    
End Sub

Private Sub UserControl_AccessKeyPress(KeyAscii As Integer)

    If Not Me.Enabled Then Exit Sub
    
    If KeyAscii = 13 Or KeyAscii = 27 Then RaiseEvent Click 'Default / Cancel
    
    If AccessKeys > "" Then
    
        If KeyAscii = Asc(LCase(AccessKeys)) Or _
                      Asc(UCase(AccessKeys)) Then
                      
                      If m_Appearance > 1 Then
                         m_Checked = Not m_Checked
                         Refresh
                      End If
                      
                      RaiseEvent Click  'ShortCut
                      
        End If
        
    End If
    
End Sub

Private Sub UserControl_AmbientChanged(PropertyName As String)
    
    Refresh 'Extender.Default changed
    
End Sub

Private Sub UserControl_EnterFocus()
    
    g_HasFocus = True
    
    Refresh
    
End Sub

Private Sub UserControl_ExitFocus()
    
    g_HasFocus = False
    g_MouseDown = False
    
    Refresh
    
End Sub

Private Sub UserControl_Resize()

    'Minimum size = 10 x 10 pixels
    If ScaleWidth < 10 Then UserControl.Width = 150
    If ScaleHeight < 10 Then UserControl.Height = 150
    
    'Set focus rect:
    g_FocusRect.Left = 4
    g_FocusRect.Right = ScaleWidth - 4
    g_FocusRect.Top = 4
    g_FocusRect.Bottom = ScaleHeight - 4
 
    Refresh
    
End Sub

Public Sub Refresh()

    AutoRedraw = True
        
        UserControl.Cls
        InitTextRects
         
        'Check effect
        Dim Ret As Long
        Dim hBrush As Long
        
        If (m_Appearance > 1 And m_Checked) And Not g_MouseDown Then
             
             hBrush = CreateSolidBrush(RGB(207, 208, 207))
             Ret = DrawState(hdc, hBrush, AddressOf CallbackState, ScaleWidth, ScaleHeight, 0, 0, ScaleWidth, ScaleHeight, DST_COMPLEX Or DSS_UNION)
             Ret = DeleteObject(hBrush)
         
        End If
             
        'Draw picture
        If m_Style = 1 Then DrawPicture
         
        'Draw caption
        DrawCaption
            
        'Draw 3D/Flat color effect
        Draw3DEffect
            
        'Draw focus rect
        If g_HasFocus And m_ShowFocusRect Then DrawFocusRect hdc, g_FocusRect

     AutoRedraw = False
    
End Sub

Private Sub UserControl_Show()

    Refresh

End Sub

'################################################################################
'  Events
'################################################################################

Private Sub UserControl_DblClick()

    SetCapture hwnd 'Preseve hWnd on DblClick
    UserControl_MouseDown g_Button, g_Shift, g_X, g_Y

End Sub

Private Sub UserControl_KeyDown(KeyCode As Integer, Shift As Integer)
    
    If Not g_KeyPressed Then ' Not continuous clicking
                             ' If you want it, remove this filter
                             ' ... or create a new property
        Select Case KeyCode
        
            Case vbKeyReturn
                
                RaiseEvent Click
                
            Case vbKeySpace
            
                g_MouseDown = True
                Refresh
                
                RaiseEvent Click
            
        End Select
        
        g_KeyPressed = True
    
    End If

    RaiseEvent KeyDown(KeyCode, Shift)
    
End Sub

Private Sub UserControl_KeyPress(KeyAscii As Integer)

    RaiseEvent KeyPress(KeyAscii)
    
End Sub

Private Sub UserControl_KeyUp(KeyCode As Integer, Shift As Integer)

    If KeyCode = vbKeySpace Then
    
        g_MouseDown = False
        Refresh
            
    End If
  
    g_KeyPressed = False
  
    RaiseEvent KeyUp(KeyCode, Shift)
    
End Sub

Private Sub UserControl_MouseDown(Button As Integer, Shift As Integer, X As Single, Y As Single)
    
    g_Button = Button: g_Shift = Shift: g_X = X: g_Y = Y
        
    If Button <> vbRightButton Then
    
        g_MouseDown = True
        
        Refresh
        
    End If
    
    RaiseEvent MouseDown(Button, Shift, X, Y)
    
End Sub

Private Sub UserControl_MouseMove(Button As Integer, Shift As Integer, X As Single, Y As Single)
        
    If (X >= 0 And Y >= 0) And (X < ScaleWidth And Y < ScaleHeight) Then
    
        If g_MouseIn = False Then
            
            OverTimer.Enabled = True
            g_MouseIn = True
            
            RaiseEvent MouseIn(Shift)
            
            Refresh
            
        End If
   
    End If
   
    RaiseEvent MouseMove(Button, Shift, X, Y)
End Sub

Private Sub UserControl_MouseUp(Button As Integer, Shift As Integer, X As Single, Y As Single)

    g_MouseDown = False
    
    If Button <> vbRightButton Then
        
        If (X >= 0 And Y >= 0) And (X < ScaleWidth And Y < ScaleHeight) Then
            
            If m_Appearance > 1 Then m_Checked = Not m_Checked
            
            RaiseEvent Click
        
        End If
        
        Refresh
        
    End If
    
    RaiseEvent MouseUp(Button, Shift, X, Y)
    
End Sub


'################################################################################
'  Methods
'################################################################################

Public Sub ResetToDefaultColors()
    
    ButtonColor = vbButtonFace
    FontColor = vbButtonText

End Sub


'################################################################################
'  Properties
'################################################################################

'Appearance #####################################################################
Public Property Get Appearance() As ButtonAppearanceConstants

    Appearance = m_Appearance
    
End Property

Public Property Let Appearance(ByVal New_Appearance As ButtonAppearanceConstants)
    
    m_Appearance = New_Appearance
    PropertyChanged "Appearance"
    
    Refresh
    
End Property

'ButtonColor ####################################################################

Public Property Get ButtonColor() As OLE_COLOR

    ButtonColor = UserControl.BackColor
    
End Property

Public Property Let ButtonColor(ByVal New_ButtonColor As OLE_COLOR)
                
    UserControl.BackColor = New_ButtonColor
    PropertyChanged "ButtonColor"
    
    Get3DButtonColors New_ButtonColor
    Refresh
    
End Property

'Caption, CaptionAlign & CaptionJustify ##########################################
Public Property Get Caption() As String

    Caption = m_Caption
    
End Property

Public Property Let Caption(ByVal New_Caption As String)

    m_Caption = New_Caption
    PropertyChanged "Caption"
    
    AccessKeys = Mid(New_Caption, InStr(1, New_Caption, "&") + 1, 1)

    Refresh
    
End Property

Public Property Get CaptionAlign() As AlignConstants

    CaptionAlign = m_CaptionAlign
    
End Property

Public Property Let CaptionAlign(ByVal New_CaptionAlign As AlignConstants)

    m_CaptionAlign = New_CaptionAlign
    PropertyChanged "CaptionAlign"
    
    Refresh
    
End Property

Public Property Get CaptionJustify() As JustifyConstants

    CaptionJustify = m_CaptionJustify
    
End Property

Public Property Let CaptionJustify(ByVal New_CaptionJustify As JustifyConstants)

    m_CaptionJustify = New_CaptionJustify
    PropertyChanged "CaptionJustify"
    
    Refresh
    
End Property

'Checked ########################################################################
Public Property Get Checked() As Boolean

    Checked = m_Checked
    
End Property

Public Property Let Checked(ByVal New_Checked As Boolean)

    m_Checked = New_Checked
    PropertyChanged "Checked"
    
    Refresh
    
End Property

'Enabled ########################################################################
Public Property Get Enabled() As Boolean

    Enabled = UserControl.Enabled
    
End Property

Public Property Let Enabled(ByVal New_Enabled As Boolean)

    UserControl.Enabled() = New_Enabled
    PropertyChanged "Enabled"
    
    Refresh
    
End Property

'FlatOver #######################################################################
Public Property Get FlatOver() As Boolean

    FlatOver = m_FlatOver
    
End Property

Public Property Let FlatOver(ByVal New_FlatOver As Boolean)

    m_FlatOver = New_FlatOver
    PropertyChanged "FlatOver"
    
    Refresh
    
End Property

'Font ###########################################################################
Public Property Get Font() As Font
Attribute Font.VB_UserMemId = -512

    Set Font = g_Font
    
End Property

Public Property Set Font(ByVal New_Font As Font)

    With g_Font
    
        .Name = New_Font.Name
        .Size = New_Font.Size
        .Bold = New_Font.Bold
        .Italic = New_Font.Italic
        .Underline = New_Font.Underline
        .Strikethrough = New_Font.Strikethrough
        
    End With
    
    PropertyChanged "Font"
    
End Property

Private Sub g_Font_FontChanged(ByVal PropertyName As String)

    Set UserControl.Font = g_Font
    
    Refresh
    
End Sub

'FontColor ######################################################################
Public Property Get FontColor() As OLE_COLOR

    FontColor = UserControl.ForeColor
    
End Property

Public Property Let FontColor(ByVal New_FontColor As OLE_COLOR)

    UserControl.ForeColor = New_FontColor
    PropertyChanged "FontColor"
    
    Refresh
    
End Property

'hWnd ###########################################################################
Public Property Get hwnd() As Long

    hwnd = UserControl.hwnd

End Property

'MaskColor ######################################################################
Public Property Get MaskColor() As OLE_COLOR

    MaskColor = UserControl.MaskColor
    
End Property

Public Property Let MaskColor(ByVal New_MaskColor As OLE_COLOR)

    UserControl.MaskColor() = New_MaskColor
    PropertyChanged "MaskColor"
    
    Refresh
    
End Property

'MousePointer & MouseIcon #######################################################
Public Property Get MousePointer() As MousePointerConstants

    MousePointer = UserControl.MousePointer
    
End Property

Public Property Let MousePointer(ByVal New_MousePointer As MousePointerConstants)

    UserControl.MousePointer() = New_MousePointer
    PropertyChanged "MousePointer"
    
End Property

Public Property Get MouseIcon() As StdPicture

    Set MouseIcon = UserControl.MouseIcon
    
End Property

Public Property Set MouseIcon(ByVal New_MouseIcon As StdPicture)

    Set UserControl.MouseIcon = New_MouseIcon
    PropertyChanged "MouseIcon"
    
End Property

'Picture, PictureDisabled, PictureDown & PictureOver ############################
Public Property Get Picture() As StdPicture

    Set Picture = m_Picture
    
End Property

Public Property Set Picture(ByVal New_Picture As StdPicture)
    
    Set m_Picture = New_Picture
    PropertyChanged "Picture"
    
    Refresh
End Property

Public Property Get PictureDisabled() As StdPicture

    Set PictureDisabled = m_PictureDisabled
    
End Property

Public Property Set PictureDisabled(ByVal New_PictureDisabled As StdPicture)

    Set m_PictureDisabled = New_PictureDisabled
    PropertyChanged "PictureDisabled"
    
    Refresh
    
End Property

Public Property Get PictureDown() As StdPicture

    Set PictureDown = m_PictureDown
    
End Property

Public Property Set PictureDown(ByVal New_PictureDown As StdPicture)

    Set m_PictureDown = New_PictureDown
    PropertyChanged "PictureDown"
    
    Refresh
    
End Property

Public Property Get PictureOver() As StdPicture

    Set PictureOver = m_PictureOver
    
End Property

Public Property Set PictureOver(ByVal New_PictureOver As StdPicture)

    Set m_PictureOver = New_PictureOver
    PropertyChanged "PictureOver"
    
    Refresh
    
End Property

'PictureTab #####################################################################
Public Property Get PictureTab() As Integer

    PictureTab = m_PictureTab
    
End Property

Public Property Let PictureTab(ByVal New_PictureTab As Integer)
    
    If New_PictureTab < 0 Then New_PictureTab = 0
    
    m_PictureTab = New_PictureTab
    PropertyChanged "PictureTab"
    
    Refresh
    
End Property

'ShowBorderOnFocus & ShowFocusRect ##############################################
Public Property Get ShowBorderOnFocus() As Boolean

    ShowBorderOnFocus = m_ShowBorderOnFocus
    
End Property

Public Property Let ShowBorderOnFocus(ByVal New_ShowBorderOnFocus As Boolean)

    m_ShowBorderOnFocus = New_ShowBorderOnFocus
    PropertyChanged "ShowBorderOnFocus"
    
    Refresh
    
End Property

Public Property Get ShowFocusRect() As Boolean

    ShowFocusRect = m_ShowFocusRect
    
End Property

Public Property Let ShowFocusRect(ByVal New_ShowFocusRect As Boolean)

    m_ShowFocusRect = New_ShowFocusRect
    PropertyChanged "ShowFocusRect"
    
    Refresh
    
End Property

'Style ##########################################################################
Public Property Get Style() As ButtonStyleConstants

    Style = m_Style
    
End Property

Public Property Let Style(ByVal New_Style As ButtonStyleConstants)

    m_Style = New_Style
    PropertyChanged "Style"
    
    Refresh
    
End Property

'UseMaskColor ###################################################################
Public Property Get UseMaskColor() As Boolean

    UseMaskColor = m_UseMaskColor
    
End Property

Public Property Let UseMaskColor(ByVal New_UseMaskColor As Boolean)

    m_UseMaskColor = New_UseMaskColor
    PropertyChanged "UseMaskColor"
    Refresh
    
End Property





'                               *   *   *   *   *

'################################################################################
'  Private Subs
'################################################################################


'Get3DButtonColors ##############################################################
'                  Get Light, HighLight, Shadow and DarkShadow colors
'                  1. Get RGB values from button face color
'                  2. Translate to HSL values
'                  3. Take L value to get the different L's to get 3D colors
'                  4. Translate finally to the new RGB values

Private Sub Get3DButtonColors(Color As OLE_COLOR)
        
    Dim g_R As Long, g_G As Long, g_B As Long
    Dim H As Single, S As Single, L As Single
    Dim r As Long, g As Long, b As Long
    
    'If SystemColorConstant then get color:
    If Color < 0 Then Color = GetSysColor(Color And Not &H80000000)

    'Convert Long value to R,G,B values:
    g_R = (Color And &HFF&)
    g_G = (Color And &HFF00&) \ &H100&
    g_B = (Color And &HFF0000) \ &H10000
    
    'Get H,S,L values:
    RGBToHSL g_R, g_G, g_B, H, S, L
    
    'Get 3DColor values (on L)
    HSLToRGB H, S, L + (1 - L) / 8, r, g, b
        g_Light = RGB(r, g, b)
    HSLToRGB H, S, L + (1 - L) / 2, r, g, b
        g_HighLight = RGB(r, g, b)
    HSLToRGB H, S, L / 1.5, r, g, b
        g_Shadow = RGB(r, g, b)
    HSLToRGB H, S, L / 3.5, r, g, b
        g_DarkShadow = RGB(r, g, b)
    
End Sub

'DrawPicture ####################################################################
'            1. Get picture by actual state
'            2. If no image in actual state: take normal state picture
'               If no normal state picture: exit sub
'            3. Set picture position by align mode
'            4. Readjust drawed text left/right margins
'            5. If UseMaskColor = True draw picture with standard PaintPicture
'               If not case:
'                  a) BMP, DIB, GIF, JPG: TransparentBlt function
'                     (StdPicture not accepted -> CreateCompatibleDC)
'                  b) ICO, CUR:           DrawIconEx function
'                     (Transp. 'ability' included in this type)
'                  c) WMF, EMF:           Standard PaintPicture function
'                     (Transp. 'ability' included in this type)
'                  d) Invalid picture

Private Sub DrawPicture()

    Dim tmpPicture
    Set tmpPicture = New StdPicture
    Dim PosInc As Integer, PosX As Integer, PosY As Integer
    Dim W As Integer, H As Integer
    
    Dim hDCScreen As Long
    Dim hDCSrc As Long
    
    'Set tmpPicture by button state:
    If g_MouseDown Or (m_Appearance > 1 And m_Checked) And Me.Enabled Then
        'Mouse down
        Set tmpPicture = m_PictureDown: PosInc = 1
    ElseIf g_MouseIn Then
        'Mouse in (over)
        Set tmpPicture = m_PictureOver
    ElseIf Not Me.Enabled Then
        'Button disabled
        Set tmpPicture = m_PictureDisabled
        If (m_Appearance > 1 And m_Checked) Then PosInc = 1
    Else
        'Mouse out
        Set tmpPicture = m_Picture
    End If
    
    If tmpPicture Is Nothing Then
        If m_Picture Is Nothing Then
            'No picture
            Exit Sub
        Else
            'Use default picture for actual state
            Set tmpPicture = m_Picture
        End If
    End If
    
    If tmpPicture = 0 Then Exit Sub 'Filter if not initialized
    
    g_TextWithPicture = True        'We have a picture
    
    'Set drawed picture dimensions (cms to pixels)
    W = Int(tmpPicture.Width / 26.455)
    H = Int(tmpPicture.Height / 26.455)
    
    'Set drawed picture location
    Select Case m_CaptionAlign
    
        Dim MaxPicture As Integer
    
        Case 0 'None (center picture)
            PosX = Int((ScaleWidth - W) / 2) + PosInc
            PosY = Int((ScaleHeight - H) / 2) + PosInc
            
        Case 1 'Top
            If m_PictureTab + H > ScaleHeight Then MaxPicture = ScaleHeight - H Else MaxPicture = m_PictureTab
            PosX = Int((ScaleWidth - W) / 2) + PosInc
            PosY = (ScaleHeight - H) + PosInc - MaxPicture - 4
                
        Case 2 'Bottom
            If m_PictureTab + H > ScaleHeight Then MaxPicture = ScaleHeight - H Else MaxPicture = m_PictureTab
            PosX = Int((ScaleWidth - W) / 2) + PosInc
            PosY = PosInc + MaxPicture + 3
                  
        Case 3 'Left
            If m_PictureTab + W > ScaleWidth Then MaxPicture = ScaleWidth - W Else MaxPicture = m_PictureTab
            PosX = (ScaleWidth - W) + PosInc - MaxPicture - 4
            PosY = Int((ScaleHeight - H) / 2) + PosInc
        
        Case 4 'Right
            If m_PictureTab + W > ScaleWidth Then MaxPicture = ScaleWidth - W Else MaxPicture = m_PictureTab
            PosX = PosInc + MaxPicture + 3
            PosY = Int((ScaleHeight - H) / 2) + PosInc
        
    End Select
   
    'Readjust drawed text left/right margins:
    Select Case m_CaptionAlign
    
        Case 0, 1, 2
            'Nothing to do
        
        Case 3
            g_TextRectUp.Right = g_TextRectUp.Right - W
            g_TextRectDown.Right = g_TextRectDown.Right - W
            
        Case 4
            g_TextRectUp.Left = g_TextRectUp.Left + W
            g_TextRectDown.Left = g_TextRectDown.Left + W
            
    End Select

    If m_UseMaskColor Then
    
        Select Case tmpPicture.Type
           
            Case vbPicTypeBitmap        ' BMP, DIB, GIF, JPG
                
                hDCScreen = GetDC(0&)
                
                hDCSrc = CreateCompatibleDC(hDCScreen)
                         SelectObject hDCSrc, tmpPicture.handle
                
                '???: TransparentBlt turns to 0 nXOriginDst and nYOriginDst values
                '     If PosX or PosY < 0 -> The picture can't be centered
                
                TransparentBlt hdc, PosX, PosY, W, H, _
                               hDCSrc, 0, 0, W, H, MaskColor
    
                DeleteDC hDCSrc
                ReleaseDC 0&, hDCScreen
                
            Case vbPicTypeIcon          ' ICO, CUR
    
                DrawIconEx hdc, PosX, PosY, tmpPicture.handle, W, H, 0, 0, DI_NORMAL Or DI_DEFAULTSIZE
            
            Case vbPicTypeMetafile, _
                 vbPicTypeEMetafile     ' WMF, EMF
            
                PaintPicture tmpPicture, PosX, PosY
            
            Case Else                   ' Invalid picture
    
                Err.Raise 481
                
        End Select
    
    Else
        
        PaintPicture tmpPicture, PosX, PosY
        
    End If
        
End Sub

'DrawCaption ####################################################################
'            1. Define a temporary RECT (g_CR <Calculated Rect>)
'            2. Calc rect text dimensions (first DrawText call: DT_CALCRECT flag)
'               It works like this: Left/Right margins are not modified, only
'               Height, increasing Bottom value.
'            3. With new Height and g_TextRectDown/g_TextRectUp center these
'               rects in button.
'               Using g_TextRectDown/g_TextRectUp:
'                  a) Button enabled: draw text using ButtonColor
'                  b) Button disabled: draw text using button disabled colors

Private Sub DrawCaption()

    'Set dimensions and position of draw text rects:
    Dim Ret As Long
    Dim g_CR As RECT
        
    g_CR = g_TextRectDown 'Downed rect
    
        Ret = DrawText(hdc, m_Caption, -1, g_CR, DT_CALCRECT Or DT_WORDBREAK)
        
        If m_Style = 1 And g_TextWithPicture Then
            
            Select Case m_CaptionAlign
            
                Case 0, 3, 4
                    g_TextRectDown.Top = Int((ScaleHeight - (g_CR.Bottom - g_CR.Top)) / 2) + 1
                
                Case 1
                    g_TextRectDown.Top = g_CR.Top
                
                Case 2
                    g_TextRectDown.Top = ScaleHeight - (g_CR.Bottom - g_CR.Top) - 6 + 1
            
            End Select
            
        Else
        
            g_TextRectDown.Top = Int((ScaleHeight - (g_CR.Bottom - g_CR.Top)) / 2) + 1
            
        End If
        
    g_CR = g_TextRectUp   'Upped rect
    
        Ret = DrawText(hdc, m_Caption, -1, g_CR, DT_CALCRECT Or DT_WORDBREAK)
        
        If m_Style = 1 And g_TextWithPicture Then

            Select Case m_CaptionAlign
                
                Case 0, 3, 4
                    g_TextRectUp.Top = Int((ScaleHeight - (g_CR.Bottom - g_CR.Top)) / 2)
                
                Case 1
                    g_TextRectUp.Top = g_CR.Top
                
                Case 2
                    g_TextRectUp.Top = ScaleHeight - (g_CR.Bottom - g_CR.Top) - 6
            
            End Select
            
        Else
        
            g_TextRectUp.Top = Int((ScaleHeight - (g_CR.Bottom - g_CR.Top)) / 2)
            
        End If
        
    'Draw text:
    If Me.Enabled Then
        
        If g_MouseDown Or (m_Appearance > 1 And m_Checked) Then
            Ret = DrawText(hdc, m_Caption, -1, g_TextRectDown, DT_WORDBREAK Or m_CaptionJustify)
        Else
            Ret = DrawText(hdc, m_Caption, -1, g_TextRectUp, DT_WORDBREAK Or m_CaptionJustify)
        End If

    Else
    
        Dim g_tmpFontColor
        g_tmpFontColor = UserControl.ForeColor
        
        'Downed rect:
        UserControl.ForeColor = g_HighLight
        Ret = DrawText(hdc, m_Caption, -1, g_TextRectDown, DT_WORDBREAK Or m_CaptionJustify)
        'Upped rect:
        UserControl.ForeColor = g_Shadow
        Ret = DrawText(hdc, m_Caption, -1, g_TextRectUp, DT_WORDBREAK Or m_CaptionJustify)
        
        UserControl.ForeColor = g_tmpFontColor
    
    End If

End Sub

'Draw3DEffect ###################################################################
'             ...
              
Private Sub Draw3DEffect()

    Select Case m_Appearance
        
        Case 0, 2 'Flat
            
            If g_MouseDown Or (m_Appearance = 2 And m_Checked) Then
            
                Line (0, 0)-(ScaleWidth - 0, ScaleHeight - 0), g_Shadow, B
                Line (-1, -1)-(ScaleWidth - 1, ScaleHeight - 1), g_HighLight, B
            
            ElseIf g_MouseIn Or Not m_FlatOver Then
            
                Line (0, 0)-(ScaleWidth - 0, ScaleHeight - 0), g_HighLight, B
                Line (-1, -1)-(ScaleWidth - 1, ScaleHeight - 1), g_Shadow, B
            
            End If
    
        Case 1, 3 '3D
        
            'Set decrement for black border (Only on Standard3D mode):
            If (Extender.Default Or (g_HasFocus And m_ShowBorderOnFocus)) And _
                m_Appearance = 1 Then
                g_3DInc = 1
            Else
                g_3DInc = 0
            End If
            
            'Draw 3D effect
            If g_MouseDown Or (m_Appearance = 3 And m_Checked) Then
            
                Line (1 + g_3DInc, 1 + g_3DInc)-(ScaleWidth - 1 - g_3DInc, ScaleHeight - 1 - g_3DInc), g_Shadow, B
                Line (0 + g_3DInc, 0 + g_3DInc)-(ScaleWidth - 2 - g_3DInc, ScaleHeight - 2 - g_3DInc), g_Light, B
                Line (0 + g_3DInc, 0 + g_3DInc)-(ScaleWidth - 0 - g_3DInc, ScaleHeight - 0 - g_3DInc), g_DarkShadow, B
                Line (-1 + g_3DInc, -1 + g_3DInc)-(ScaleWidth - 1 - g_3DInc, ScaleHeight - 1 - g_3DInc), g_HighLight, B
            
            Else
            
                Line (1 + g_3DInc, 1 + g_3DInc)-(ScaleWidth - 1 - g_3DInc, ScaleHeight - 1 - g_3DInc), g_Light, B
                Line (0 + g_3DInc, 0 + g_3DInc)-(ScaleWidth - 2 - g_3DInc, ScaleHeight - 2 - g_3DInc), g_Shadow, B
                Line (0 + g_3DInc, 0 + g_3DInc)-(ScaleWidth - 0 - g_3DInc, ScaleHeight - 0 - g_3DInc), g_HighLight, B
                Line (-1 + g_3DInc, -1 + g_3DInc)-(ScaleWidth - 1 - g_3DInc, ScaleHeight - 1 - g_3DInc), g_DarkShadow, B
            
            End If
            
            'Draw black border:
            If ((g_HasFocus And m_ShowBorderOnFocus) Or Extender.Default) And _
                m_Appearance = 1 Then
                Line (0, 0)-(ScaleWidth - 1, ScaleHeight - 1), vbBlack, B
            End If
        
    End Select
    
End Sub

'InitTextRects ##################################################################
'              ...

Private Sub InitTextRects()
    
    g_TextRectUp.Left = 6
    g_TextRectUp.Right = ScaleWidth - 7
    g_TextRectUp.Top = 3
    g_TextRectUp.Bottom = ScaleHeight - 2
    
    g_TextRectDown.Left = 7
    g_TextRectDown.Right = ScaleWidth - 6
    g_TextRectDown.Top = 4
    g_TextRectDown.Bottom = ScaleHeight - 2

End Sub

'Timer ##########################################################################
'      Use of WindowFromPoint(X,Y) function
'      1. Get handle of actual absolute mouse position
'      2. If UserControl handle <> returned handle : Out of button
'         (See: Sub UserControl_MouseMove)

Private Sub OverTimer_Timer()
    
    Dim P As POINTAPI
    
    GetCursorPos P
    
    If hwnd <> WindowFromPoint(P.X, P.Y) Then
        
        OverTimer.Enabled = False
        
        g_MouseIn = False
        RaiseEvent MouseOut(g_Shift)

        Refresh                     'Refresh picture
        
        If g_MouseDown = True Then  'Resfresh state
            g_MouseDown = False
            Refresh
            g_MouseDown = True
        End If
        
    End If

End Sub
