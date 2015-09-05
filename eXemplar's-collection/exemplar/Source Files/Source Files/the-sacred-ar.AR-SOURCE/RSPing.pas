unit RSPing;
interface
uses
  Classes, IdBaseComponent, IdException, IdComponent, IdTCPConnection,
   sysutils, Windows, idHTTP;

type
  TVarsThread = class(TThread)
  private
    FHTTP: TidHTTP;
  protected
    procedure Execute; override;
  public
    Link: string;
    Params: string;
    constructor Create(l, p: string);
  end;


type
  TPingThread = class(TThread)
  private
    { Private declarations }
  idClient : TidHTTP;
    FPort: integer;
    FServerIP: String;
    FStatus: String;
    FKill: Boolean;
//    FOwner: TComponent;
    FThreadID: Integer;
    FSendString: String;
    FAllRecData: String;
    FUser, FPass, FVers, FCPU: String;
    FCommand: String;
    FPos: String;
    procedure SetfPort(const Value: integer);
    procedure SetServerIP(const Value: String);
    procedure SetStatus(const Value: String);
    procedure SetKill(const Value: Boolean);
    procedure SetThreadID(const Value: Integer);
    procedure SetSendString(const Value: String);
  protected
    procedure Execute; override;
  Published
  Property ThreadID : Integer read FThreadID write SetThreadID;
  Property Kill :Boolean read FKill write SetKill;
  Property ServerIP : String read FServerIP write SetServerIP;
  Property Status : String read FStatus write SetStatus;
  Property Port : integer read FPort write SetfPort;
  Property SendString : String read FSendString write SetSendString;
  Property AllRecData : String read FAllRecData;
  Property AutorizationName: String write FUser;
  Property AutorizationPass: String write FPass;
  Property BotVers: String write FVers;
  Property CPUID: String write FCPU;
  Property Command: String read FCommand write FCommand;
  Property Pos: String read FPos write FPos;
  end;




implementation
{We include IdGlobal because Delphi 4 does not have FreeAndNil.  For D4
IdGlobal has an IFDEF'ed FreeAndNil procedure that is compiled if Delphi 4 is
used.}
uses IdGlobal, Unit1;
{ TClientThread }


//News thread
constructor TVarsThread.Create(l, p: string);
begin
  Link:= l;
  Params:= p;
  FreeOnTerminate := True;
  inherited Create(False);
end;


procedure TVarsThread.Execute;
var
  List: TStringList;
  s: string;
begin
  //
  FHTTP:= TidHTTP.Create(nil);
  List:= TStringList.Create;
  try
  try
    s:= FHTTP.Get(Link + Params);
    LastServerResponse:= s;
    //if(s<>'')then
    //  DebugTextAdd(s);
  finally
    FHTTP.Free;
    List.Free;
  end;
  except
    DebugTextAdd('HTTPGet failed');
  end;
end;



procedure TPingThread.Execute;
begin

try
idClient := TIdHTTP.Create(nil);

FAllRecData := '';
try
with idClient do
begin
  While FKill = false do
  begin
        try
          If(FCommand = '')Then Begin
            fStatus:= idClient.Get('http://'+MyServerName+'/AutoRune/?n=1&p=1&user='+FUser+'&pass='+FPass+'&v='+FVers+'&pos='+FPos+'&c=' + FCPU);
          End Else Begin
            fStatus:= idClient.Get('http://'+MyServerName+'/AutoRune/?n=1&p=1&user='+FUser+'&pass='+FPass+'&v='+FVers+'&pos='+FPos+'&c=' + FCPU + '&cmd=' + FCommand);
            FCommand:= '';
          End;
        except
          on E:Exception do
          begin
            fStatus := 'error';
          end;
        end;
        
        Windows.Sleep(180000);
  end;

  Terminate;
end;

except
on e : exception do
FStatus := E.Message;
end;

finally
if assigned(idClient) then FreeAndNil(idClient);
end;
end;


procedure TPingThread.SetfPort(const Value: integer);
begin
  FPort := Value;
end;

procedure TPingThread.SetKill(const Value: Boolean);
begin
  FKill := Value;
end;



procedure TPingThread.SetSendString(const Value: String);
begin
  FSendString := Value;
end;

procedure TPingThread.SetServerIP(const Value: String);
begin
  FServerIP := Value;
end;

procedure TPingThread.SetStatus(const Value: String);
begin
  FStatus := Value;
end;

procedure TPingThread.SetThreadID(const Value: Integer);
begin
  FThreadID := Value;
end;

end.


 