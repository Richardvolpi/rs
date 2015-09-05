program RSparser;

uses
  Forms,
  MainForm in 'MainForm.pas' {Form1};

{$R *.RES}

begin
  Application.Initialize;
  Application.Title := 'RS applet code parser';
  Application.CreateForm(TForm1, Form1);
  Application.Run;
end.
