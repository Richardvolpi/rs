object frmRelogin: TfrmRelogin
  Left = 548
  Top = 224
  BorderStyle = bsNone
  Caption = 'Automatic Log In'
  ClientHeight = 243
  ClientWidth = 299
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnCreate = FormCreate
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Panel2: TPanel
    Left = 0
    Top = 0
    Width = 299
    Height = 243
    Align = alClient
    Color = 12704960
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    object SpeedButton2: TSpeedButton
      Left = 73
      Top = 206
      Width = 73
      Height = 25
      Caption = 'OK'
      Flat = True
      Font.Charset = DEFAULT_CHARSET
      Font.Color = 16384
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsBold]
      ParentFont = False
      OnClick = SpeedButton2Click
    end
    object SpeedButton3: TSpeedButton
      Left = 153
      Top = 206
      Width = 73
      Height = 25
      Caption = 'Cancel'
      Flat = True
      Font.Charset = DEFAULT_CHARSET
      Font.Color = 16384
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = [fsBold]
      ParentFont = False
      OnClick = SpeedButton3Click
    end
    object Label1: TLabel
      Left = 16
      Top = 76
      Width = 52
      Height = 13
      Caption = 'Username:'
    end
    object Label2: TLabel
      Left = 16
      Top = 108
      Width = 50
      Height = 13
      Caption = 'Password:'
    end
    object Label3: TLabel
      Left = 16
      Top = 140
      Width = 54
      Height = 13
      Caption = 'Retry after'
    end
    object Label4: TLabel
      Left = 136
      Top = 140
      Width = 37
      Height = 13
      Caption = 'minutes'
    end
    object Label5: TLabel
      Left = 16
      Top = 172
      Width = 27
      Height = 13
      Caption = 'Retry'
    end
    object Label6: TLabel
      Left = 136
      Top = 172
      Width = 25
      Height = 13
      Caption = 'times'
    end
    object Panel1: TPanel
      Left = 1
      Top = 1
      Width = 297
      Height = 34
      Align = alTop
      BevelOuter = bvNone
      Color = clGreen
      TabOrder = 0
      OnMouseDown = Panel1MouseDown
      object SpeedButton1: TSpeedButton
        Left = 266
        Top = 3
        Width = 28
        Height = 28
        Anchors = [akTop, akRight]
        Caption = 'r'
        Flat = True
        Font.Charset = DEFAULT_CHARSET
        Font.Color = 12704960
        Font.Height = -11
        Font.Name = 'Marlett'
        Font.Style = []
        ParentFont = False
        OnClick = SpeedButton1Click
      end
      object Label7: TLabel
        Left = 8
        Top = 7
        Width = 140
        Height = 19
        Caption = 'Automatic Log In'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = 12704960
        Font.Height = -16
        Font.Name = 'Tahoma'
        Font.Style = [fsBold]
        ParentFont = False
        OnMouseDown = Panel1MouseDown
      end
    end
    object chkAutoRelogin: TCheckBox
      Left = 16
      Top = 48
      Width = 225
      Height = 17
      Caption = 'Log in after disconnects'
      TabOrder = 1
      OnKeyPress = txtLoginKeyPress
    end
    object txtLogin: TRzEdit
      Left = 80
      Top = 72
      Width = 201
      Height = 21
      FrameColor = clGreen
      FrameFlat = True
      FrameFlatStyle = fsFlat
      FrameFocusStyle = fsFlat
      FrameVisible = True
      TabOrder = 2
      OnKeyPress = txtLoginKeyPress
    end
    object txtPassword: TRzEdit
      Left = 80
      Top = 104
      Width = 201
      Height = 21
      FrameColor = clGreen
      FrameFlat = True
      FrameFlatStyle = fsFlat
      FrameFocusStyle = fsFlat
      FrameVisible = True
      PasswordChar = '*'
      TabOrder = 3
      OnKeyPress = txtLoginKeyPress
    end
    object txtRetryTimes: TRzEdit
      Left = 80
      Top = 168
      Width = 49
      Height = 21
      FrameColor = clGreen
      FrameFlat = True
      FrameFlatStyle = fsFlat
      FrameFocusStyle = fsFlat
      FrameVisible = True
      MaxLength = 2
      TabOrder = 4
      Text = '5'
      OnKeyPress = txtLoginKeyPress
    end
    object cmbRetryTime: TRzComboBox
      Left = 80
      Top = 136
      Width = 49
      Height = 21
      Ctl3D = False
      FrameColor = clGreen
      FrameFlat = True
      FrameFlatStyle = fsFlat
      FrameFocusStyle = fsFlat
      FrameVisible = True
      ItemHeight = 13
      ParentCtl3D = False
      TabOrder = 5
      OnKeyPress = txtLoginKeyPress
      Items.Strings = (
        '1'
        '2'
        '3'
        '5'
        '10'
        '20'
        '30'
        '60'
        '120')
    end
  end
end
