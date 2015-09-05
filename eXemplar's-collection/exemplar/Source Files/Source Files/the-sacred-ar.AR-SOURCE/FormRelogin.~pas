unit FormRelogin;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, Buttons, ExtCtrls, Mask, RzEdit, RzCmboBx;

type
  TfrmRelogin = class(TForm)
    Panel2: TPanel;
    SpeedButton2: TSpeedButton;
    SpeedButton3: TSpeedButton;
    Panel1: TPanel;
    SpeedButton1: TSpeedButton;
    Label7: TLabel;
    chkAutoRelogin: TCheckBox;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    txtLogin: TRzEdit;
    txtPassword: TRzEdit;
    txtRetryTimes: TRzEdit;
    cmbRetryTime: TRzComboBox;
    procedure FormCreate(Sender: TObject);
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
    procedure txtLoginKeyPress(Sender: TObject; var Key: Char);
    procedure Panel1MouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmRelogin: TfrmRelogin;

implementation
uses Unit1;

{$R *.DFM}

procedure TfrmRelogin.FormCreate(Sender: TObject);
begin
  cmbRetryTime.ItemIndex:= 0;
end;

procedure TfrmRelogin.SpeedButton1Click(Sender: TObject);
begin
  ModalResult:= mrCancel;
end;

procedure TfrmRelogin.SpeedButton2Click(Sender: TObject);
begin
  RSUsername:= txtLogin.Text;
  RSPass:= txtPassword.Text;
  ReconnectAfterDisconnects:= chkAutoRelogin.Checked;
  Form1.TBItem16.Checked:= ReconnectAfterDisconnects;
  ReconnectTime:= StrToInt(cmbRetryTime.Items[cmbRetryTime.ItemIndex]);
  ReconnectTimes:= StrToInt(txtRetryTimes.Text);
  ModalResult:= mrOk;
end;

procedure TfrmRelogin.SpeedButton3Click(Sender: TObject);
begin
  ModalResult:= mrCancel;
end;

procedure TfrmRelogin.txtLoginKeyPress(Sender: TObject; var Key: Char);
begin
  if Key = #27 then ModalResult:= mrCancel;
  if Key = #13 then SpeedButton2Click(nil);
  if Key in [#13, #27] then Key:= #0;
end;

procedure TfrmRelogin.Panel1MouseDown(Sender: TObject;
  Button: TMouseButton; Shift: TShiftState; X, Y: Integer);
const
  sc_DragMove = $F012;
begin
  ReleaseCapture;
  Perform( wm_SysCommand, sc_DragMove, 0 );
end;

procedure TfrmRelogin.FormShow(Sender: TObject);
begin
  txtLogin.Text:= RSUsername;
  txtPassword.Text:= RSPass;
  chkAutoRelogin.Checked:= ReconnectAfterDisconnects;
  if(ReconnectTime > 0)Then cmbRetryTime.ItemIndex:= cmbRetryTime.IndexOf(IntToStr(ReconnectTime));
  if(ReconnectTimes > 0)Then txtRetryTimes.Text:= IntToStr(ReconnectTimes);
end;

end.
