Attribute VB_Name = "Module"
Option Explicit

Public Declare Function GetDC Lib "user32" _
                       (ByVal hwnd As Long) As Long
                       
Public Declare Function CreateCompatibleDC Lib "gdi32" _
                       (ByVal hdc As Long) As Long
                       
Public Declare Function ReleaseDC Lib "user32" _
                       (ByVal hwnd As Long, ByVal hdc As Long) As Long
                       
Public Declare Function DeleteDC Lib "gdi32" _
                       (ByVal hdc As Long) As Long
                       
Public Declare Function SelectObject Lib "gdi32" _
                       (ByVal hdc As Long, ByVal hObject As Long) As Long

Public Declare Function TransparentBlt Lib "msimg32" _
                       (ByVal hDCDst As Long, ByVal nXOriginDst As Long, _
                        ByVal nYOriginDst As Long, ByVal nWidthDst As Long, _
                        ByVal nHeightDst As Long, ByVal hDCSrc As Long, _
                        ByVal nXOriginSrc As Long, ByVal nYOriginSrc As Long, _
                        ByVal nWidthSrc As Long, ByVal nHeightSrc As Long, _
                        ByVal crTransparent As Long) As Long
                                          
Public Declare Function DrawIconEx Lib "user32" _
                       (ByVal hdc As Long, _
                        ByVal xLeft As Long, ByVal yTop As Long, _
                        ByVal hIcon As Long, _
                        ByVal cxWidth As Long, ByVal cyHeight As Long, _
                        ByVal istepIfAniCur As Long, _
                        ByVal hbrFlickerFreeDraw As Long, _
                        ByVal diFlags As Long) As Long
' DrawIconEx constants
Public Const DI_MASK = &H1
Public Const DI_IMAGE = &H2
Public Const DI_NORMAL = &H3
Public Const DI_COMPAT = &H4
Public Const DI_DEFAULTSIZE = &H8

Public Declare Function DrawText Lib "user32" Alias "DrawTextA" _
                       (ByVal hdc As Long, _
                        ByVal lpStr As String, ByVal nCount As Long, _
                        lpRect As RECT, _
                        ByVal wFormat As Long) As Long
' DrawText constants
Public Const DT_BOTTOM = &H8
Public Const DT_CALCRECT = &H400
Public Const DT_CENTER = &H1
Public Const DT_EXPANDTABS = &H40
Public Const DT_EXTERNALLEADING = &H200
Public Const DT_INTERNAL = &H1000
Public Const DT_LEFT = &H0
Public Const DT_NOCLIP = &H100
Public Const DT_NOPREFIX = &H800
Public Const DT_RIGHT = &H2
Public Const DT_SINGLELINE = &H20
Public Const DT_TABSTOP = &H80
Public Const DT_TOP = &H0
Public Const DT_VCENTER = &H4
Public Const DT_WORDBREAK = &H10

Public Declare Function SetCapture Lib "user32" _
                       (ByVal hwnd As Long) As Long
                       
Public Declare Function WindowFromPoint Lib "user32" _
                       (ByVal xPoint As Long, ByVal yPoint As Long) As Long
                       
Public Declare Function GetCursorPos Lib "user32" _
                       (lpPoint As POINTAPI) As Long

Public Type POINTAPI
    X As Long
    Y As Long
End Type


Public Declare Function GetSysColor Lib "user32" _
                       (ByVal nIndex As Long) As Long

Public Declare Function DrawFocusRect Lib "user32" _
                       (ByVal hdc As Long, _
                        lpRect As RECT) As Long

Public Type RECT
        Left As Long
        Top As Long
        Right As Long
        Bottom As Long
End Type

Public Declare Function CreateSolidBrush Lib "gdi32" _
                       (ByVal crColor As Long) As Long
                       
Public Declare Function FillRect Lib "user32" _
                       (ByVal hdc As Long, _
                        lpRect As RECT, _
                        ByVal hBrush As Long) As Long
                        
Public Declare Function DeleteObject Lib "gdi32" _
                       (ByVal hObject As Long) As Long
                       
Public Declare Function DrawState Lib "user32" Alias "DrawStateA" _
                       (ByVal hdc As Long, _
                        ByVal hBrush As Long, _
                        ByVal lpDrawStateProc As Long, _
                        ByVal lParam As Long, ByVal wParam As Long, _
                        ByVal n1 As Long, ByVal n2 As Long, ByVal n3 As Long, ByVal n4 As Long, ByVal un As Long) As Long
'DrawState constants
Public Const DSS_DISABLED = &H20
Public Const DSS_MONO = &H80
Public Const DSS_NORMAL = &H0
Public Const DSS_RIGHT = &H8000
Public Const DSS_UNION = &H10
Public Const DST_BITMAP = &H4
Public Const DST_COMPLEX = &H0
Public Const DST_ICON = &H3
Public Const DST_PREFIXTEXT = &H2
Public Const DST_TEXT = &H1




Public Function CallbackState(ByVal lval1 As Long, ByVal lval2 As Long, ByVal lval3 As Long, ByVal lval4 As Long, ByVal lval5 As Long) As Long
    
    Dim Ret
    Dim hBrush
    Dim R As RECT
    
    R.Left = 0
    R.Top = 0
    R.Right = lval4
    R.Bottom = lval5
    
    hBrush = CreateSolidBrush(RGB(0, 0, 0))
    Ret = FillRect(lval1, R, hBrush)
    Ret = DeleteObject(hBrush)
    
End Function


'——————————————————————————————————————————————————————————————————
' The next code has extracted from vbAccelerator:
' Hue Lightness and Saturation (HLS) Model and Manipulating Colours
' http://www.vbaccelerator.com/codelib/gfx/clrman1.htm
'——————————————————————————————————————————————————————————————————
' Use: convert RGB to HLS, and varying
' L value, reconvert new HLS to RGB
'——————————————————————————————————————————————————————————————————

Public Sub RGBToHSL(R As Long, G As Long, B As Long, _
                    H As Single, S As Single, L As Single)
    
    Dim Max As Single
    Dim Min As Single
    Dim Delta As Single
    Dim rR As Single, rG As Single, rB As Single

    rR = R / 255: rG = G / 255: rB = B / 255

    'Given:   RGB each in [0,1].
    'Desired: H in [0,360] and S in [0,1], except if S=0, then H=UNDEFINED.
    
    Max = Maximum(rR, rG, rB)
    Min = Minimum(rR, rG, rB)
    L = (Max + Min) / 2 'Lightness
        
    If Max = Min Then
    
        'Acrhomatic case:
        
        S = 0
        H = 0
    
    Else
    
        'Chromatic case:
        
        'First calculate the saturation
        
        If L <= 0.5 Then
            S = (Max - Min) / (Max + Min)
        Else
            S = (Max - Min) / (2 - Max - Min)
        End If
        
        'Next calculate the hue
        
        Delta = Max - Min
        
        If rR = Max Then
            H = (rG - rB) / Delta     'Resulting color is between yellow and magenta
        ElseIf rG = Max Then
            H = 2 + (rB - rR) / Delta 'Resulting color is between cyan and yellow
        ElseIf rB = Max Then
            H = 4 + (rR - rG) / Delta 'Resulting color is between magenta and cyan
        End If
        
      End If

End Sub

Public Sub HSLToRGB(H As Single, S As Single, L As Single, _
                    R As Long, G As Long, B As Long)
                    
    Dim rR As Single, rG As Single, rB As Single
    Dim Min As Single, Max As Single

    If S = 0 Then
    
        'Achromatic case:
        
        rR = L: rG = L: rB = L
        
    Else
    
        'Chromatic case:
        
        'Delta = Max-Min
        If L <= 0.5 Then
            'S = (Max - Min) / (Max + Min)
            'Get Min value:
            Min = L * (1 - S)
        Else
            'S = (Max - Min) / (2 - Max - Min)
            'Get Min value:
            Min = L - S * (1 - L)
        End If
        'Get the Max value
        Max = 2 * L - Min
      
        'Now depending on sector we can evaluate the H,L,S:
        If (H < 1) Then
        
            rR = Max
            
            If (H < 0) Then
                rG = Min
                rB = rG - H * (Max - Min)
            Else
                rB = Min
                rG = H * (Max - Min) + rB
            End If
            
        ElseIf (H < 3) Then
        
            rG = Max
            
            If (H < 2) Then
                rB = Min
                rR = rB - (H - 2) * (Max - Min)
            Else
                rR = Min
                rB = (H - 2) * (Max - Min) + rR
            End If
            
        Else
        
            rB = Max
            
            If (H < 4) Then
                rR = Min
                rG = rR - (H - 4) * (Max - Min)
            Else
                rG = Min
                rR = (H - 4) * (Max - Min) + rG
            End If
         
        End If
            
    End If
   
    R = rR * 255: G = rG * 255: B = rB * 255
   
End Sub

Private Function Maximum(rR As Single, rG As Single, rB As Single) As Single

    If (rR > rG) Then
    
        If (rR > rB) Then
            Maximum = rR
        Else
            Maximum = rB
        End If
        
    Else
    
        If (rB > rG) Then
            Maximum = rB
        Else
            Maximum = rG
        End If
        
    End If
   
End Function

Private Function Minimum(rR As Single, rG As Single, rB As Single) As Single
   
    If (rR < rG) Then
    
        If (rR < rB) Then
            Minimum = rR
        Else
            Minimum = rB
        End If
        
    Else
    
        If (rB < rG) Then
            Minimum = rB
        Else
            Minimum = rG
        End If
        
    End If
   
End Function








