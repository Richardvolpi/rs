unit RSCommands;

interface

function cmdBytes(Params: array of Integer; Num:Char):String;
function cmdWalk(Coords: array of Integer; Cmd: Char):String;
function CoordCommand(X, Y: Word; Num: Char):String;
function CoordWordCommand(X, Y: Word; ItemNum: Word; Num:Char):String;
function CoordByteCommand(X, Y: Word; b: Byte; Num:Char):String;
function WordCommand(X: Word; Num:Char):String;
function WordLongCommand(X: Word; Y: LongWord; Num: Char):String;
function NoParamCommand(Num: Char):String;
function WordWordCommand(X, Y: Word; Num: Char): String;
function WordWordByteWordCommand(W1, W2: Word; B: Byte; W3: Word; Num: Char):string;
function CoordWordWordCommand(X, Y: Word; A, ItemNum: Word; Num:Char):String;
function ByteCommand(X: Word; Num:Char):String;
function ParamsToString(Params: array of Integer):String;
function HexToStr(S:String):String;


implementation

Type WordC = Array[1..2]of Char;

function ParamsToString(Params: array of Integer):String;
var S:String;
    f: Integer;
Begin
  S:= '';
  If(Length(Params)>0)Then Begin
    For f:= 0 To Length(Params) -1 do begin
      S:= S + Char(Params[f]);
    end;
  End;
  result:= S;
End;


function HexToStr(S:String):String;
var f: Integer;
    S1: String;
const HexDigits = '123456789ABCDEF';
Begin
  S1:= '';
  for f:=1 to Length(S) Do Begin
    If S[f]<>' ' then S1:= S1 + S[f];
  End;
  S:= S1;
  S1:= '';
  for f:=1 To Length(S) div 2 do begin
    S1:= S1 + ' ';
    S1[Length(S1)]:= Chr(Pos(S[f*2-1], HexDigits));
    S1[Length(S1)]:= Chr(Ord(S1[Length(S1)]) shl 4);
    S1[Length(S1)]:= Chr(Ord(S1[Length(S1)]) or Pos(S[f*2], HexDigits));
  end;
  result:= S1;
End;


procedure CmdToEnd(var S:String);
var f:Integer;
    c: Char;
Begin
  For f:= Length(S) DownTo 2 Do Begin
    c:= S[f-1];
    S[f-1]:= S[f];
    S[f]:= c;
  End;
  S:= Chr(Length(S)) + S;
End;

function cmdWalk(Coords: array of Integer; Cmd: Char):String;
var S:String;
    W:WordC;
    f: Integer;
Begin
  S:= '';
  If(Length(Coords)>1)and(Length(Coords) mod 2 = 0)Then Begin
    S:= Cmd;
    W[1]:= Chr(Coords[0] shr 8);
    W[2]:= Chr(Coords[0] and $FF);
    S:= S + W[1] + W[2];
    W[1]:= Chr(Coords[1] shr 8);
    W[2]:= Chr(Coords[1] and $FF);
    S:= S + W[1] + W[2];
    For f:= 2 To Length(Coords) -1 do begin
      S:= S + Char(Shortint(Coords[f]));
    end;
    CmdToEnd(S);
  End;
  result:= S;
End;


function cmdBytes(Params: array of Integer; Num:Char):String;
var S:String;
    f: Integer;
Begin
  S:= Num;
  If(Length(Params)>0)Then Begin
    For f:= 0 To Length(Params) -1 do begin
      S:= S + Char(Params[f]);
    end;
    CmdToEnd(S);
  End;
  result:= S;
End;


function CoordCommand(X, Y: Word; Num: Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  S:= S + Chr(Y shr 8);
  S:= S + Chr(Y and $FF);
  CmdToEnd(S);
  result:= S;
end;

function WordLongCommand(X: Word; Y: LongWord; Num: Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  S:= S + Chr(Y shr 24);
  S:= S + Chr((Y shr 16) and $FF);
  S:= S + Chr((Y shr 8) and $FF);
  S:= S + Chr(Y and $FF);
  CmdToEnd(S);
  result:= S;
end;


function WordWordCommand(X, Y: Word; Num: Char): String;
Begin
  result:= CoordCommand(X, Y, Num);
End;

function CoordWordCommand(X, Y: Word; ItemNum: Word; Num:Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  S:= S + Chr(Y shr 8);
  S:= S + Chr(Y and $FF);
  S:= S + Chr(ItemNum shr 8);
  S:= S + Chr(ItemNum and $FF);
  CmdToEnd(S);
  result:= S;
end;

function WordWordByteWordCommand(W1, W2: Word; B: Byte; W3: Word; Num: Char):string;
var S: string;
begin
  S:= Num;
  S:= S + Chr(W1 shr 8);
  S:= S + Chr(W1 and $FF);
  S:= S + Chr(W2 shr 8);
  S:= S + Chr(W2 and $FF);
  S:= S + Chr(B);
  S:= S + Chr(W3 shr 8);
  S:= S + Chr(W3 and $FF);
  CmdToEnd(S);
  result:= S;
end;

function CoordByteCommand(X, Y: Word; b: Byte; Num:Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  S:= S + Chr(Y shr 8);
  S:= S + Chr(Y and $FF);
  S:= S + Chr(b);
  CmdToEnd(S);
  result:= S;
end;

function CoordWordWordCommand(X, Y: Word; A, ItemNum: Word; Num:Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  S:= S + Chr(Y shr 8);
  S:= S + Chr(Y and $FF);
  S:= S + Chr(A shr 8);
  S:= S + Chr(A and $FF);
  S:= S + Chr(ItemNum shr 8);
  S:= S + Chr(ItemNum and $FF);
  CmdToEnd(S);
  result:= S;
end;

function WordCommand(X: Word; Num:Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X shr 8);
  S:= S + Chr(X and $FF);
  CmdToEnd(S);
  result:= S;
end;

function ByteCommand(X: Word; Num:Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  S:= S + Chr(X and $FF);
  CmdToEnd(S);
  result:= S;
end;

function NoParamCommand(Num: Char):String;
var S:String;
begin
  S:= '';
  S:= Num;
  CmdToEnd(S);
  result:= S;
end;




end.
