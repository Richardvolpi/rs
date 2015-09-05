unit MainForm;
{$R+}

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  StdCtrls, shlobj, FileCtrl, ShellAPI;

type
  TForm1 = class(TForm)
    lstFiles: TMemo;
    Button1: TButton;
    txtTemp: TMemo;
    txtReport: TMemo;
    Button2: TButton;
    Button3: TButton;
    Button4: TButton;
    Button5: TButton;
    Button6: TButton;
    txtDummyVars: TMemo;
    Button7: TButton;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
    procedure Button4Click(Sender: TObject);
    procedure Button5Click(Sender: TObject);
    procedure Button6Click(Sender: TObject);
    procedure Button7Click(Sender: TObject);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

  TStringArray = array of string;

   

var
  Form1: TForm1;
  DefaultDir: string;

function BrowseForFolder(const browseTitle: String;
    const initialFolder: String = ''): String;
var lg_StartFolder: String;


implementation

{$R *.DFM}


//////////////////////////////////////////////////////////////////////////
// Call back function used to set the initial browse directory.
//////////////////////////////////////////////////////////////////////////
function BrowseForFolderCallBack(Wnd: HWND; uMsg: UINT;
        lParam, lpData: LPARAM): Integer stdcall;
begin
    if uMsg = BFFM_INITIALIZED then
        SendMessage(Wnd,BFFM_SETSELECTION, 1,
            Integer(@lg_StartFolder[1]));
    result := 0;
end;
//////////////////////////////////////////////////////////////////////////
// This function allows the user to browse for a folder
//
// Arguments:-
//    browseTitle : The title to display on the browse dialog.
//  initialFolder : Optional argument. Use to specify the folder initially
//                  selected when the dialog opens.
//
// Returns: The empty string if no folder was selected (i.e. if the user
//          clicked cancel), otherwise the full folder path.
//////////////////////////////////////////////////////////////////////////
function BrowseForFolder(const browseTitle: String;
        const initialFolder: String =''): String;
var
    browse_info: TBrowseInfo;
    folder: array[0..MAX_PATH] of char;
    find_context: PItemIDList;
begin
    FillChar(browse_info,SizeOf(browse_info),#0);
    lg_StartFolder := initialFolder;
    browse_info.pszDisplayName := @folder[0];
    browse_info.lpszTitle := PChar(browseTitle);
    browse_info.ulFlags := BIF_RETURNONLYFSDIRS;
    browse_info.lpfn := BrowseForFolderCallBack;
    find_context := SHBrowseForFolder(browse_info);
    if Assigned(find_context) then
    begin
        if SHGetPathFromIDList(find_context,folder) then
            result := folder
        else
            result := '';
    end
    else
        result := '';
end;



procedure ListAllFiles(Path, Extension1, Extension2: string);
var R: TSearchRec;
begin
  Path:= IncludeTrailingBackslash(Path);
  if(FindFirst(Path + '*.*', faAnyFile, R) = 0)then
  begin
    while(FindNext(R) = 0)do
    begin
      if(R.Attr and faDirectory = faDirectory)and(R.Name<>'.')and(R.Name<>'..')then
      begin
        ListAllFiles(Path + R.Name, Extension1, Extension2)
      end else
      begin
        if(ExtractFileExt(R.Name) = Extension1)or(ExtractFileExt(R.Name) = Extension2)then
          Form1.lstFiles.Lines.Add(Path + R.Name);
      end;

    end;
  end;
  FindClose(R);
end;

procedure ListAllDirs(Path, S: string);
var R: TSearchRec;
begin
  Path:= IncludeTrailingBackslash(Path);
  if(FindFirst(Path + '*.*', faAnyFile, R) = 0)then
  begin
    while(FindNext(R) = 0)do
    begin
      if(R.Attr and faDirectory = faDirectory)and(R.Name<>'.')and(R.Name<>'..')then
      begin
        if(S = '    ')then
          Form1.txtReport.Lines.Add('====' + R.Name)
        else
          Form1.txtReport.Lines.Add(S + R.Name);
        ListAllDirs(Path + R.Name, S + '    ')
      end else
      begin
      end;

    end;
  end;
  FindClose(R);
end;

procedure GetClassMethods(L: TStrings; var a: TStringArray);
var
  f: Integer;
  s: string;
begin
  a:= nil;
  for f:= 0 to L.Count - 1 do
  begin
    s:= trim(L[f]);
    if(Copy(s,1,12) = '@signature "')then
    begin
//      sig:= Copy(s,13,Length(s)-13);
//      DebugTextAdd(s);
    end;
  end;
end;


procedure TForm1.Button1Click(Sender: TObject);
var S, S1: string;
    f, x, f1: Integer;
begin
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.java', '.jad');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
      try
        txtTemp.Lines.LoadFromFile(lstFiles.Lines[f]);
        txtReport.Lines.Add('====[file]===' + ExtractFileName(lstFiles.Lines[f]));
        for x:= 0 to txtTemp.Lines.Count - 1 do
        begin
          S:= Trim(txtTemp.Lines[x]);
          f1:= pos('Y.a(', S);
          if(f1 > 0)then

//          if(pos('FihopY', S) > 0)then
          begin
            f1:= f1 + 4;
            S1:= Copy(S, f1, Length(S)-1-f1);
              f1:= Pos(',', S1);
              try
                if(StrToIntDef(Copy(S1,1,f1-1),-23347)<>-23347)or(StrToIntDef(Copy(S1,f1,Length(S1)),-23347)<>-23347)then
                  txtReport.Lines.Add('      '+S)
              except
              end;  
//            else
  //            txtReport.Lines.Add('      '+S+Trim(txtTemp.Lines[x+1]));

          end;
        end;
      except
      end;
    end;
  end;
end;

procedure TForm1.Button2Click(Sender: TObject);
var S, NewFileName: string;
    f: Integer;
begin
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.class', '.class');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
     NewFileName:= ChangeFileExt(lstFiles.Lines[f],'.j');
     ShellExecute(Handle, nil, 'C:\Aivars\rs\disassemble_c.bat', PChar(lstFiles.Lines[f]+' '+NewFileName),nil,SW_SHOWNORMAL);

     //ShellExecute(Handle, nil, 'C:\RS\deobfuscator_handmade\lcc\deobfus.exe', PChar(lstFiles.Lines[f]),nil,SW_SHOWNORMAL);
     txtReport.Lines.Add('Decompiled:' + lstFiles.Lines[f]);
     txtReport.Repaint;
     Sleep(200);
    end;
  end;
end;

function ExtractExtendClass(Line: string): string;
var f, x: Integer;
    s, s1: string;
begin
  result:= '';
  s:= '';
  s1:= '';
  if(Line <> '')then
  begin
    if(Line[Length(Line)] = '{')then
    begin
      for f:= Length(Line) - 2 downto 1 do
      begin
        s:= Line[f] + s;
        x:= f;
        if(Line[f] = ' ')then
          break;
      end;
      if(x > 7)then
      begin
        for f:= x - 1 downto 1 do
        begin
          s1:= Line[f] + s1;
          x:= f;
          if(Line[f] = ' ')then
            break;
        end;
        if(trim(s1) = 'extends')then
          result:= Trim(s);
      end;
    end;
  end;
end;

function LastParam(S: string): string;
var f: Integer;
begin
  result:= '';
  for f:= Length(S) downto 1 do
  begin
    if(S[f] = ' ')then
      break
    else
      result:= S[f] + result;
  end;
end;

function ChangeLastParam(S, NewParam: string): string;
var f: Integer;
begin
  result:= '';
  for f:= Length(S) downto 1 do
  begin
    if(S[f] = ' ')then
    begin
      Delete(S, f+1, Length(S));
      S:= S + NewParam;
      result:= S;
      break;
    end else
      result:= S[f] + result;
  end;
end;


function LastFieldName(S: string): string;
var f: Integer;
begin
  result:= '';
  for f:= Length(S) downto 1 do
  begin
    if(S[f] = ' ')or(S[f] = '.')then
      break
    else
      result:= S[f] + result;
  end;
end;

function TabsRSpaces(s: string): string;
var
  f: Integer;
begin
  for f:= 1 to Length(s) do
    if(s[f] = #9)then
      s[f]:= ' ';
  result:= s;
end;

function LeaveAllAfter(s: string; c: char; var Before: string): string;
var
  f: Integer;
  b: boolean;
begin
  b:= false;
  result:= '';
  Before:= '';
  for f:=1 to Length(s) do
  begin
    if(b)then
      result:= result + s[f]
    else
      Before:= Before + s[f]; 
    if(s[f] = c)then
      b:= true;
  end;

end;

function IIndexOf(SL: TStrings; const S: string): Integer;
begin
  for Result := 0 to SL.Count - 1 do
    if SL[Result] = S then Exit;
  Result := -1;
end;

function CanFindIn(SL: TStrings; const S: string): Boolean;
var
  f: Integer;
begin
  Result:= False;
  for f:= 0 to SL.Count do
  begin
    if(Pos(SL[f], S)>0)then
      Result:= True;
  end;
end;



procedure TForm1.Button3Click(Sender: TObject);
var S, Line, Param, Field, LastLine: string;
    i, f, x: Integer;
    Boo: TStrings;
    Lbl: string;
    NextLine: string;
    Vars, BadLines: TStrings;
    counts, counts2, counts3: array of Integer;
begin
  Vars:= TStringList.Create;
  BadLines:= TStringList.Create;
  counts:= nil;
  counts2:= nil;
  counts3:= nil;
  txtTemp.Visible:= False;
  Boo:= TStringList.Create;
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.j', '.j');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
      txtReport.Lines.Add('=== Processing: ' + lstFiles.Lines[f]);
      txtReport.Repaint;
      Boo.LoadFromFile(lstFiles.Lines[f]);
      for x:= 0 to Boo.Count-1 do
      begin
        LastLine:= Line;
        Line:= TabsRSpaces(Boo[x]);
        Line:= Trim(Line);
        NextLine:= '';
        if(x < Boo.Count - 1)then
        begin
          NextLine:= Trim(TabsRSpaces(Boo[x+1]));
        end;
        //get rid of label
        if(Copy(Line, 1, 2) = '_L')and(Line[3] >= '0')and(Line[3] <= '9')then
        begin
          Line:= LeaveAllAfter(Line, ':', Lbl);
          Line:= Trim(Line); 
        end;
        Param:= LastParam(Line);
        Field:= LastFieldName(Line);

        if(Copy(Line, 1, 11) = '@getstatic ')and(LastLine[Length(LastLine)] = '{'){and(Copy(LastLine, 1, 14) = '.limit locals ')}then
        begin
          s:= Trim(Copy(Line, 11, Length(Line)));
          i:= IIndexOf(Vars, s);
          if(i < 0)then
          begin
            Vars.Add(s);
            BadLines.Add('');
            SetLength(Counts, Length(Counts) + 1);
            Counts[Length(Counts)-1]:= 1;
            SetLength(Counts2, Length(Counts2) + 1);
            Counts2[Length(Counts2)-1]:= 0;
            SetLength(Counts3, Length(Counts3) + 1);
            Counts3[Length(Counts3)-1]:= 0;
          end else
          begin
            Counts[i]:= Counts[i] + 1;
          end;
          txtReport.Lines.Add(Line);
          txtReport.Repaint;
        end else
        if(Copy(Line, 1, 11) = '@getstatic ')and(Copy(NextLine, 1, 6) = '@ifeq '){and(Copy(LastLine, 1, 14) = '.limit locals ')}then
        begin
          s:= Trim(Copy(Line, 11, Length(Line)));
          i:= IIndexOf(Vars, s);
          if(i >= 0)then
          begin
            Counts3[i]:= Counts3[i] + 1;
          end;
        end else
        begin
          if(Copy(Line, 1, 10) = '@putfield ')or
          (Copy(Line, 1, 10) = '@getfield ')or
          (Copy(Line, 1, 11) = '@putstatic ')or
          (Copy(Line, 1, 11) = '@getstatic ')then
          begin
            s:= Trim(Copy(Line, 11, Length(Line)));
            i:= IIndexOf(Vars, s);
            if(i >= 0)then
            begin
              Counts2[i]:= Counts2[i] + 1;
              BadLines[i]:= BadLines[i] + '[' + LastLine + ',' + Line + ',' + NextLine + ']';
            end;
          end;
        end;
      end;
      Boo.SaveToFile(lstFiles.Lines[f]);
    end;
  end;
  txtTemp.Visible:= True;
  txtTemp.Lines.Assign(Boo);
  Boo.Free;
  txtReport.Lines.Add('----------------');
  s:= '';
  txtDummyVars.Lines.Clear;
  for f:= 0 to Vars.Count-1 do
  begin
    txtReport.Lines.Add(Vars[f] + ' - ' + IntToStr(Counts[f])+'/' + IntToStr(Counts2[f])+'/' + IntToStr(Counts3[f])+ ' ' + BadLines[f]);
    if((Copy(Vars[f],1,4) = 'int ')or(Copy(Vars[f],1,8) = 'boolean '))and
      (Counts[f]+Counts[3] > 1)and(Counts2[f] = 1)then
      begin
        if(s <> '')then s:= s + ', ';
        s:= s + Vars[f];
        txtDummyVars.Lines.Add(Vars[f]);
      end;
  end;
  txtReport.Lines.Add('');
  txtReport.Lines.add(s);
  Vars.Free;
end;


function GetField(Line: string; var f: Integer): string;
begin
  result:= '';
  case Line[f] of
    '[': begin
           result:= 'a';
           f:= f + 1;
           GetField(Line, f);
         end;
    'I', 'Z', 'B', 'S', 'C': result:= 'i';
    'L': begin
           result:= 'a';
           while Line[f]<>';' do
             f:= f + 1;
         end;
    'J': result:= 'l';
    'F': result:= 'f';
    'D': result:= 'd';
    'V': result:= 'v';
    '(', ')': result:= '';
  end;
  f:= f + 1;
end;

procedure ParseParam(var Meth, Field: string; Line: string);
var
  IsMeth: boolean;
  f: Integer;
  s: string;
begin
  IsMeth:= False;
  f:= 1;
  while(f <= Length(Line))do
  begin
    if(Line[f] = '(')then
    begin
      IsMeth:= True;
    end;
    s:= GetField(Line, f);
    if(IsMeth)then
      Meth:= Meth + s
    else
      Field:= Field + s;
  end;
end;

function ExtractFieldName(Line: string): string;
var f: Integer;
begin
  f:= Length(Line) - 1;
  result:= '';
  while(Line[f] <> ' ')do
  begin
    result:= Line[f] + result;
    f:= f - 1;
  end;
end;

function ExtractMethName(Line: string): string;
var f: Integer;
begin
  f:= Length(Line);
  while(Line[f] <> '(')do
  begin
    f:= f - 1;
  end;
  f:= f - 1;
  result:= '';
  while(Line[f] <> ' ')do
  begin
    result:= Line[f] + result;
    f:= f - 1;
  end;
end;

function ChangeMethName(Line, NewName: string): string;
var f: Integer;
begin
  f:= Length(Line);
  while(Line[f] <> '(')do
  begin
    f:= f - 1;
  end;
  f:= f - 1;
  result:= '';
  while(Line[f] <> ' ')do
  begin
    result:= Line[f] + result;
    f:= f - 1;
  end;
  Delete(Line, f + 1, Length(result));
  Insert(NewName, Line, f + 1);
  result:= Line;
end;

function ExtractMethClass(Line: string): string;
var f: Integer;
begin
  Line:= ExtractMethName(Line);
  f:= 1;
  result:= '';
  repeat
    result:= result + Line[f];
    f:= f + 1;
  until(Line[f] = '.')or(f > Length(Line));
  if(f > Length(Line))then
    result:= '';
end;

function ExtractFieldClass(Line: string): string;
var f: Integer;
begin
  f:= 1;
  result:= '';
  repeat
    result:= result + Line[f];
    f:= f + 1;
  until(Line[f] = '.')or(f > Length(Line));
  if(f > Length(Line))then
    result:= '';
end;

function ExtractMethDef(Line, ClassName: string): string;
var f: Integer;
begin
  Line:=' ' + Line;
  f:= Length(Line);
  //params
  while(Line[f] <> '(')do
  begin
    f:= f - 1;
  end;
  f:= f - 1;
  //name
  while(Line[f] <> ' ')do
  begin
    f:= f - 1;
  end;
  Insert(ClassName + '.', Line, f + 1);
  f:= f - 1;
  try
    //return type
    while(Line[f] <> ' ')do
    begin
      f:= f - 1;
    end;
    f:= f + 1;
    //def
    result:= '';
    while(Line[f-1]<>')')do
    begin
      result:= result + Line[f];
      f:= f + 1;
    end;
  except
    Form1.txtReport.Lines.Add('Baga, line=' + Line);
  end;
end;

procedure TForm1.Button4Click(Sender: TObject);
var S, NextLine, Line, Param, Field, LastLine, L, Dir, Extendclass: string;
    Meth: string;
    f, x: Integer;
    Boo: TStrings;
    SearchSlot, PutStaticSearch: string;
    Lbl, LastLbl: string;
    HelpClassStaticClasses, Meths, Fields, MethNames, FieldNames, MethDefs: TStrings;
    ClassName: string;
    LastDeleteLine1, LastDeleteLine2, State: Integer;
begin
  //int e.Nb     int r.D   int j.P

  txtTemp.Visible:= False;
  Boo:= TStringList.Create;
  HelpClassStaticClasses:= TStringList.Create;
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  Dir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.j', '.j');
    Meths:= TStringList.Create;
    MethDefs:= TStringList.Create;
    MethNames:= TStringList.Create;

    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
      txtReport.Lines.Add('=== Processing: ' + lstFiles.Lines[f]);
      txtReport.Repaint;
      Boo.LoadFromFile(lstFiles.Lines[f]);
      LastDeleteLine1:= 0;
      LastDeleteLine2:= 0;
      for x:= 0 to Boo.Count-1 do
      begin
        LastLine:= Line;
        LastLbl:= Lbl;
        Lbl:= '';
        Line:= TabsRSpaces(Boo[x]);
        Line:= Trim(Line);
        //get rid of label
        if(Copy(Line, 1, 2) = '_L')and(Line[3] >= '0')and(Line[3] <= '9')then
        begin
          Line:= LeaveAllAfter(Line, ':', Lbl);
          Line:= Trim(Line);
        end;
        Param:= LastParam(Line);
        Field:= LastFieldName(Line);
        if(Line = '}')or((LastLine<>'')and(LastLine[Length(LastLine)] = '{')) then
        begin
        //ok it's weird, but removing them makes JAD confused about try..except
        //so I'm commenting this for now
       {   if(LastDeleteLine1 <> 0)then
            Boo[LastDeleteLine1]:= '';
          if(LastDeleteLine2 <> 0)then
            Boo[LastDeleteLine2]:= '';}
          SearchSlot:= ' ';
          PutStaticSearch:= ' ';
          LastDeleteLine1:= 0;
          LastDeleteLine2:= 0;
        end;
        if(Copy(Line, 1, 6) = '@ifeq ')and(LastLine = SearchSlot)then
        begin
          txtReport.Lines.Add('Deleting: ' + LastLine + ' / ' + Line);
          txtReport.Repaint;
          L:= Line;
          Line[2]:= 'g';
          Line[3]:= 'o';
          Line[4]:= 't';
          Line[5]:= 'o';
          Boo[x]:= Lbl + ' ' + Line;
          Line:= L;
          Boo[x-1]:= LastLbl + ' @nop';
        end;
        if(Line = PutStaticSearch)then
        begin
          LastDeleteLine1:= 0;
          LastDeleteLine2:= 0;
        end;
        if(CanFindIn(txtDummyVars.Lines, LastLine))then
        //if(Pos('int j.P', LastLine)>0)or(Pos('int e.Nb', LastLine)>0)or(Pos('int r.D', LastLine)>0)then
        //int a.H, boolean dc.c, boolean eb.Ob,
        //boolean jc.o, int fb.w, boolean kb.D,
        //int mc.u, int db.g, boolean zb.z
{        if(Pos('int a.H', LastLine)>0)or(Pos('boolean dc.c', LastLine)>0)
        or(Pos('boolean eb.Ob', LastLine)>0)
        or(Pos('boolean jc.o', LastLine)>0)or(Pos('int fb.w', LastLine)>0)
        or(Pos('boolean kb.D', LastLine)>0)or(Pos('int mc.u', LastLine)>0)
        or(Pos('int db.g', LastLine)>0)or(Pos('boolean zb.z', LastLine)>0)then}
        begin
          if(Copy(LastLine, 1, 11) = '@getstatic ')and(Copy(Line, 1, 6) = '@ifeq ')then
          begin
            txtReport.Lines.Add('Deleting: ' + LastLine + ' / ' + Line);
            txtReport.Repaint;
            Boo[x-1]:= LastLbl + ' @nop';
            L:= Line;
            Line[2]:= 'g';
            Line[3]:= 'o';
            Line[4]:= 't';
            Line[5]:= 'o';
            Boo[x]:= Lbl + ' ' + Line;
            Line:= L;
          end;
          if(Copy(LastLine, 1, 11) = '@getstatic ')and(Copy(Line, 1, 7) = '@istore')then
          begin

            SearchSlot:= '@iload' + Copy(Line, 8, 7);
            PutStaticSearch:= '@putstatic' + Copy(LastLine, 11, Length(LastLine));
            //txtReport.Lines.Add('Deleting: ' + LastLine + ' / ' + Line);
            //txtReport.Repaint;
            //Boo[x]:= '';
            //Boo[x-1]:= '';
            LastDeleteLine1:= x;
            LastDeleteLine2:= x-1;
          end;
        end;
      end;
      (*Fields:= TStringList.Create;
      FieldNames:= TStringList.Create;
      ClassName:= ExtractFileName(lstFiles.Lines[f]);
      x:= 1;
      while(ClassName[x]<>'.')and(x<=Length(ClassName))do
        x:= x + 1;
      ClassName:= Copy(ClassName, 1, x - 1);
      HelpClassStaticClasses.Add(ClassName);
      for x:= 0 to Boo.Count - 1 do
      begin
        LastLine:= Line;
        LastLbl:= Lbl;
        Lbl:= '';
        Line:= TabsRSpaces(Boo[x]);
        Line:= Trim(Line);
        //get rid of label
        if(Copy(Line, 1, 2) = '_L')and(Line[3] >= '0')and(Line[3] <= '9')then
        begin
          Line:= LeaveAllAfter(Line, ':', Lbl);
          Line:= Trim(Line);
        end;
        NextLine:= '';
        if(x < Boo.Count - 1)then
        begin
          NextLine:= Trim(TabsRSpaces(Boo[x+1]));
        end;
        Param:= LastParam(Line);
        Field:= LastFieldName(Line);
        if(Copy(Line, 1, 11) = '@signature ')then
        begin
          Param:= Copy(Param, 2, Length(Param) - 2);
          Meth:= '';
          Field:= '';
          ParseParam(Meth, Field, Line);
          if(Meth <> '')then
          begin
            Meths.Add(Meth);
            MethNames.Add(ExtractMethName(NextLine));
            MethDefs.Add(ExtractMethDef(NextLine, ClassName));

          end else
          begin
            Fields.Add(Field);
            FieldNames.Add(ExtractFieldName(NextLine));
          end;

        end;
      end;

      //look for method calls
      x:= 0;
      while x <= Boo.Count - 1 do
      begin
        LastLine:= Line;
        LastLbl:= Lbl;
        Lbl:= '';
        Line:= TabsRSpaces(Boo[x]);
        Line:= Trim(Line);
        //get rid of label
        if(Copy(Line, 1, 2) = '_L')and(Line[3] >= '0')and(Line[3] <= '9')then
        begin
          Line:= LeaveAllAfter(Line, ':', Lbl);
          Line:= Trim(Line);
        end;
        NextLine:= '';
        if(x < Boo.Count - 1)then
        begin
          NextLine:= Trim(TabsRSpaces(Boo[x+1]));
        end;
        Param:= LastParam(Line);
        Field:= LastFieldName(Line);
        if(Copy(Line, 1, 11) = '@getstatic ')or
          (Copy(Line, 1, 11) = '@putstatic ')then
        begin
          s:= ExtractFieldClass(Param);
          if(FieldNames.IndexOf(s) >= 0)and(s <> ClassName)then
          begin
//            @getstatic	u helpclass.static_u
//        	@pop
//        	@getstatic	int u.d
            //Boo.Insert(x, '@getstatic	'+s+' helpclass.static_'+s);
            //Boo.Insert(x + 1, '@pop');
            Line:= ChangeLastParam(Line, 'static_' + Param);
            Boo[x]:= Line;
            txtReport.Lines.Add(Line);
            //x:= x + 2;
          end;
        end;
        if(Copy(Line, 1, 14) = '@invokestatic ')then
        begin
          Param:= Trim(Copy(Line, 16, Length(Line)));
          s:= ExtractMethClass(Param);
          if(FieldNames.IndexOf(s) >= 0)and(s <> ClassName)then
          begin
            //field name matches class name
            Line:= ChangeMethName(Line, 'static_' + ExtractMethName(Line));
            Boo[x]:= Line;
            txtReport.Lines.Add(Line);
          end;
        end;
        if(Copy(Line, 1, 15) = '@invokevirtual ')or
          (Copy(Line, 1, 15) = '@invokespecial ')then
        begin
          Param:= Trim(Copy(Line, 16, Length(Line)));
          s:= ExtractMethClass(Param);
          if(FieldNames.IndexOf(s) >= 0)and(s <> ClassName)then
          begin //field name matches class name
            //create procedure in helpclass
            txtReport.Lines.Add(Line);
          end;
        end;
        x:= x + 1;
      end;
      Fields.Free;
      FieldNames.Free;*)
      //move super() to the first line
      Extendclass := '';
      State:= 0;
      for x:= 0 to Boo.Count - 1 do
      begin
        LastLine:= Line;
        LastLbl:= Lbl;
        Lbl:= '';
        Line:= TabsRSpaces(Boo[x]);
        Line:= Trim(Line);
        //get rid of label
        if(Copy(Line, 1, 2) = '_L')and(Line[3] >= '0')and(Line[3] <= '9')then
        begin
          Line:= LeaveAllAfter(Line, ':', Lbl);
          Line:= Trim(Line);
        end;
        Param:= LastParam(Line);
        Field:= LastFieldName(Line);
        if(Extendclass = '')then
          Extendclass:= ExtractExtendClass(Line)
        else
        begin
          if(State = 0)then
          begin
            if(Field = '{')then
              State:= 1;
          end else if(State = 1)then
          begin
            if(Copy(Line, 1, 10) = '@getstatic')then
              State:= 2
            else
              State:= 0;
          end else if(State = 2)then
          begin
            if(Copy(Line, 1, 7) = '@istore')then
              State:= 3
            else
              State:= 0;
          end else if(State = 3)then
          begin
            if(Copy(Line, 1, 6) = '@aload')and(Field = '0')then
              State:= 4
            else
              State:= 0;
          end else if(State = 4)then
          begin
            State:= 0;
            L:= Extendclass + '.<init>()';
            if(Copy(Line, 1, 14) = '@invokespecial')and(Copy(Line, Length(Line) - Length(L) + 1, Length(L)) = L)then
            begin
              //change lines so that call to super() is the first thing in the thing
              txtReport.Lines.Add('Moving line: ' + Line);
              Boo.Move(x - 1, x - 3);
              Boo.Move(x, x - 2);
            end;
          end;
        end;
      end;

      Boo.SaveToFile(lstFiles.Lines[f]);

    end;

    Meths.Free;
    MethDefs.Free;
    MethNames.Free;

  end;
  //create helpclass
  Boo.Clear;
  Boo.Add('//Helpclass created with deobfuscator by Kaitnieks');
  Boo.Add('public class helpclass extends java.lang.Object {');
  for f:= 0 to HelpClassStaticClasses.Count - 1 do
  begin
    Boo.Add('public static '+HelpClassStaticClasses[f]+' static_'+HelpClassStaticClasses[f]+';')
  end;
  Boo.Add('public void <init>() {');
  Boo.Add('      	@aload		0');
  Boo.Add('      	@invokespecial	void java.lang.Object.<init>()');
  Boo.Add('      	@return');
  Boo.Add('  }');

  Boo.Add('}');
  Boo.SaveToFile(Dir + '\helpclass.j');
  txtTemp.Visible:= True;
  //txtTemp.Lines.Assign(Boo);
  Boo.Free;
  HelpClassStaticClasses.Free;

end;

procedure TForm1.Button5Click(Sender: TObject);
var S, NewFileName: string;
    f: Integer;
begin
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.j', '.j');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
     NewFileName:= ChangeFileExt(lstFiles.Lines[f],'.class');
     ShellExecute(Handle, nil, 'C:\Aivars\rs\assemble_c.bat', PChar(lstFiles.Lines[f]+' '+ExtractShortPathName(ExtractFilePath(NewFileName))),nil,SW_SHOWNORMAL);
//     ShellExecute(Handle, nil, 'D:\PROGRA~1\IBM\CFParse\bin\asm.bat', PChar('-d '+S+' '+lstFiles.Lines[f]),nil,SW_SHOWNORMAL);
//     txtReport.Lines.Add('-o '+NewFileName+' '+lstFiles.Lines[f]);
     txtReport.Lines.Add('Compiled:' + lstFiles.Lines[f]);
     txtReport.Repaint;
     Sleep(400);
    end;
  end;
end;

procedure TForm1.Button6Click(Sender: TObject);
var S: string;
begin
  S:= BrowseForFolder('.j', '.j');
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
//    ListAllFiles(S, '');
  end;
end;

procedure TForm1.Button7Click(Sender: TObject);
var S, NewFileName, Path: string;
    f: Integer;
begin
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.class', '.class');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
     Path:= IncludeTrailingBackslash(ExtractShortPathName(ExtractFilePath(lstFiles.Lines[f])));
     //Application.MessageBox(PChar('-d' + Path + ' -o -s java ' + Path + lstFiles.Lines[f]),'saggas',0);
     ShellExecute(Handle, nil, 'C:\Aivars\rs\jad.exe', PChar('-d' + Path + ' -o -s java ' + lstFiles.Lines[f]),nil,SW_SHOWNORMAL);

     //ShellExecute(Handle, nil, 'C:\RS\deobfuscator_handmade\lcc\deobfus.exe', PChar(lstFiles.Lines[f]),nil,SW_SHOWNORMAL);
     txtReport.Lines.Add('Decompiled:' + lstFiles.Lines[f]);
     txtReport.Repaint;
    end;
  end;
end;

procedure TForm1.FormCreate(Sender: TObject);
begin                     
  DefaultDir:= 'c:\Aivars\rs';
end;

end.
procedure TForm1.Button6Click(Sender: TObject);
begin
  S:= BrowseForFolder('', DefaultDir);
  DefaultDir:= S;
  if(DirectoryExists(S))then
  begin
    Form1.lstFiles.Clear;
    ListAllFiles(S, '.j', '.j');
    for f:= 0 to lstFiles.Lines.Count - 1 do
    begin
    end;
  end;
end;


