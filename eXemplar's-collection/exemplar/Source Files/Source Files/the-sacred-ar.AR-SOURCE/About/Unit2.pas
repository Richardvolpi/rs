unit Unit2;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls;

type
  TMain = class(TForm)
    Button1: TButton;
    Button2: TButton;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Main: TMain;

implementation

uses Unit1, Unit3;

{$R *.DFM}

procedure TMain.Button1Click(Sender: TObject);
begin
  form1.showModal;
end;

procedure TMain.Button2Click(Sender: TObject);
begin
  form3.showModal;
end;

end.
