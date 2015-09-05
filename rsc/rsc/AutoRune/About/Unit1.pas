unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, ExtCtrls;

type
  TForm1 = class(TForm)
    Image1: TImage;
    Label1: TLabel;
    Label2: TLabel;
    btnOK: TButton;
    Label3: TLabel;
    Bevel1: TBevel;
    Label4: TLabel;
    Label5: TLabel;
    procedure Label4Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.DFM}

procedure TForm1.Label4Click(Sender: TObject);
begin
  // shellexecute ar linku
end;

end.
