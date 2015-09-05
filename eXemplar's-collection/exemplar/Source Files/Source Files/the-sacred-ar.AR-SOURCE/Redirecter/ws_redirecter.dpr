program ws_redirecter;

uses
  Forms,
  Unit1 in 'Unit1.pas' {Form1};

{$R *.RES}

begin
  Application.Initialize;
  Application.Title := 'Runescape Launcher';
  Application.CreateForm(TForm1, Form1);
  Application.Run;
end.
