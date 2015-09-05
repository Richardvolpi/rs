unit Unit3;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, RzLabel, ExtCtrls, Buttons, ShellAPI;

type
  TForm3 = class(TForm)
    Panel2: TPanel;
    Panel1: TPanel;
    Image1: TImage;
    RzLabel1: TRzLabel;
    RzLabel2: TRzLabel;
    Label3: TLabel;
    Label5: TLabel;
    Label4: TLabel;
    SpeedButton3: TSpeedButton;
    Label1: TLabel;
    Label2: TLabel;
    Label6: TLabel;
    procedure SpeedButton1Click(Sender: TObject);
    procedure FormKeyDown(Sender: TObject; var Key: Word;
      Shift: TShiftState);
    procedure DragMouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; X, Y: Integer);
    procedure Label4Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form3: TForm3;

implementation

{$R *.DFM}

procedure TForm3.SpeedButton1Click(Sender: TObject);
begin
  ModalResult:= mrCancel;
end;

procedure TForm3.FormKeyDown(Sender: TObject; var Key: Word;
  Shift: TShiftState);
begin
  if Key = VK_ESCAPE then ModalResult:= mrCancel;
end;

procedure TForm3.DragMouseDown(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; X, Y: Integer);
const
  sc_DragMove = $F012;
begin
  ReleaseCapture;
  Perform( wm_SysCommand, sc_DragMove, 0 );
end;

procedure TForm3.Label4Click(Sender: TObject);
begin
  ShellExecute(Handle, nil, 'mailto:aivars@serveris.lv', '', '', SW_SHOWNORMAL);
end;

end.
