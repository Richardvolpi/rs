unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    Button1: TButton;
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;
  inst : THandle;
  loadModel : procedure (filename: PChar) stdcall ;
  getString : procedure (filename: PChar; result: PChar) stdcall;
  loadDictionary : procedure (filename: PChar) stdcall;
  wrdStorage: array[1..32] of char;
  word : PChar;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
begin
  word := @wrdStorage[1];
  inst := LoadLibrary('ocrdll.dll');
  if (inst > 32) then begin
    loadModel := GetProcAddress(inst, 'loadModel');
    getString := GetProcAddress(inst, 'getString');
    loadDictionary := GetProcAddress(inst, 'loadDictionary');


    loadModel('model.txt');
    loadDictionary('wrds.txt');
    getString('G:\OCR project #2\2\HC0\1.BMP',word);
    word[0] := 'a';
  end else begin
    showmessage('error loading DLL');
  end;
end;

end.
 