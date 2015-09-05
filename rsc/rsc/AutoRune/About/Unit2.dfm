object Main: TMain
  Left = 214
  Top = 107
  BorderStyle = bsDialog
  Caption = 'Test'
  ClientHeight = 122
  ClientWidth = 123
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Button1: TButton
    Left = 24
    Top = 24
    Width = 75
    Height = 25
    Caption = 'A'
    TabOrder = 0
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 24
    Top = 64
    Width = 75
    Height = 25
    Caption = 'B'
    TabOrder = 1
    OnClick = Button2Click
  end
end
