unit FormAuth;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, Buttons, ExtCtrls, RzButton, Mask, RzEdit;

type
  TfrmAuthorization = class(TForm)
    Panel2: TPanel;
    Panel1: TPanel;
    Image1: TImage;
    Label1: TLabel;
    Label2: TLabel;
    SpeedButton1: TSpeedButton;
    Label3: TLabel;
    txtUser: TRzEdit;
    txtPass: TRzEdit;
    SpeedButton2: TSpeedButton;
    SpeedButton3: TSpeedButton;
    procedure FormShow(Sender: TObject);
    procedure DragMouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
    procedure SpeedButton1Click(Sender: TObject);
    procedure SpeedButton3Click(Sender: TObject);
    procedure SpeedButton2Click(Sender: TObject);
    procedure txtUserKeyPress(Sender: TObject; var Key: Char);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmAuthorization: TfrmAuthorization;

implementation

{$R *.DFM}

procedure TfrmAuthorization.FormShow(Sender: TObject);
begin
  txtUser.SetFocus;
end;

procedure TfrmAuthorization.DragMouseDown(Sender: TObject;
  Button: TMouseButton; Shift: TShiftState; X, Y: Integer);
const
  sc_DragMove = $F012;
begin
  ReleaseCapture;
  Perform( wm_SysCommand, sc_DragMove, 0 );
end;

procedure TfrmAuthorization.SpeedButton1Click(Sender: TObject);
begin
  ModalResult:= mrCancel;
end;

procedure TfrmAuthorization.SpeedButton3Click(Sender: TObject);
begin
  ModalResult:= mrCancel;
end;

procedure TfrmAuthorization.SpeedButton2Click(Sender: TObject);
begin
  ModalResult:= mrOK;
end;

procedure TfrmAuthorization.txtUserKeyPress(Sender: TObject;
  var Key: Char);
begin
  if Key = #27 then ModalResult:= mrCancel;
  if Key = #13 then ModalResult:= mrOK;
  if Key in [#13, #27] then Key:= #0;
end;

end.
