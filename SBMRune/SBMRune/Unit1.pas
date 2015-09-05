unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ExtCtrls, StdCtrls, CheckLst, Buttons;

type
  TForm1 = class(TForm)
    Panel2: TPanel;
    Panel1: TPanel;
    Image1: TImage;
    SpeedButton1: TSpeedButton;
    Label7: TLabel;
    SpeedButton2: TSpeedButton;
    StateButton: TSpeedButton;
    Notebook1: TNotebook;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    SpeedButton3: TSpeedButton;
    SpeedButton4: TSpeedButton;
    SpeedButton7: TSpeedButton;
    SpeedButton8: TSpeedButton;
    SpeedButton10: TSpeedButton;
    btnSendKeys: TSpeedButton;
    SpeedButton11: TSpeedButton;
    btnItems: TSpeedButton;
    btnHats: TSpeedButton;
    SpeedButton5: TSpeedButton;
    SpeedButton6: TSpeedButton;
    chkShowData: TCheckBox;
    chkClientSend: TCheckBox;
    Panel5: TPanel;
    lstFilter: TCheckListBox;
    ServerHosts: TListBox;
    ServerPorts: TListBox;
    CheckBox1: TCheckBox;
    btnOpen: TButton;
    Panel6: TPanel;
    Panel4: TPanel;
    txtDebug: TMemo;
    Panel9: TPanel;
    btnRun: TSpeedButton;
    btnPause: TSpeedButton;
    btnStop: TSpeedButton;
    btnClear: TSpeedButton;
    Label6: TLabel;
    btnLaunchRS: TSpeedButton;
    SpeedButton9: TSpeedButton;
    procedure SpeedButton1Click(Sender: TObject);
    procedure StateButtonClick(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.SpeedButton1Click(Sender: TObject);
begin
 Close;
end;

procedure TForm1.StateButtonClick(Sender: TObject);
begin
  if Self.WindowState = wsMaximized then
    ShowWindow(Handle, SW_RESTORE)
  else
    ShowWindow(Handle, SW_MAXIMIZE);
  if Self.WindowState = wsMaximized then StateButton.Caption:= '2' else StateButton.Caption:= '1';
end;

procedure TForm1.SpeedButton2Click(Sender: TObject);
begin
  Application.Minimize;
end;

end.
