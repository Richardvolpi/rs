unit osutils;

interface

uses Windows;

Const
    cOsUnknown              : Integer = -1;
    cOsWin95                : Integer =  0; 
    cOsWin98                : Integer =  1; 
    cOsWin98SE              : Integer =  2; 
    cOsWinME                : Integer =  3; 
    cOsWinNT                : Integer =  4; 
    cOsWin2000              : Integer =  5; 
    cOsWhistler             : Integer =  6;

    SECURITY_NT_AUTHORITY: TSIDIdentifierAuthority =  (Value: (0, 0, 0, 0, 0, 5));
    SECURITY_BUILTIN_DOMAIN_RID = $00000020;
    DOMAIN_ALIAS_RID_ADMINS     = $00000220;

    function GetOSVersion : Integer; 
    function GetOSName( OSCode : Integer ) : String;
    function IsAdmin: boolean;

implementation

Function GetOSVersion : Integer; 
Var 
    osVerInfo          : TOSVersionInfo; 
    majorVer, minorVer : Integer; 
Begin
//    Result := cOsUnknown;
    osVerInfo.dwOSVersionInfoSize := SizeOf( TOSVersionInfo ); 
    If ( GetVersionEx( osVerInfo ) ) Then Begin 
        majorVer := osVerInfo.dwMajorVersion; 
        minorVer := osVerInfo.dwMinorVersion; 
        Case ( osVerInfo.dwPlatformId ) Of 
            VER_PLATFORM_WIN32_NT : { Windows NT/2000 } 
                Begin 
                    If ( majorVer <= 4 ) Then 
                        Result := cOsWinNT 
                    Else 
                        If ( ( majorVer = 5 ) And ( minorVer= 0 ) ) Then 
                            Result := cOsWin2000 
                        Else 
                            If ( ( majorVer = 5) And ( minorVer = 1 ) ) Then 
                                Result := cOsWhistler 
                            Else 
                                Result := cOsUnknown; 
                End; 
            VER_PLATFORM_WIN32_WINDOWS :  { Windows 9x/ME } 
                Begin 
                    If ( ( majorVer = 4 ) And ( minorVer = 0 ) ) Then 
                        Result := cOsWin95 
                    Else If ( ( majorVer = 4 ) And ( minorVer = 10 ) ) Then Begin 
                        If ( osVerInfo.szCSDVersion[ 1 ] = 'A' ) Then 
                            Result := cOsWin98SE 
                        Else 
                            Result := cOsWin98; 
                    End Else If ( ( majorVer = 4) And ( minorVer = 90 ) ) Then 
                        Result := cOsWinME 
                    Else 
                        Result := cOsUnknown; 
                End; 
        Else 
            Result := cOsUnknown; 
        End; 
    End Else 
        Result := cOsUnknown; 
End; 

Function GetOSName( OSCode : Integer ) : String; 
Begin 
    If ( OSCode = cOsUnknown ) Then 
        Result := '(sconosciuto)' 
    Else If ( OSCode = cOsWin95 ) Then 
        Result := 'Microsoft Windows 95' 
    Else If ( OSCode = cOsWin98 ) Then 
        Result := 'Microsoft Windows 98' 
    Else If ( OSCode = cOsWin98SE ) Then 
        Result := 'Microsoft Windows 98 Second Edition' 
    Else If ( OSCode = cOsWinME ) Then 
        Result := 'Microsoft Windows Millennium Edition' 
    Else If ( OSCode = cOsWinNT ) Then 
        Result := 'Microsoft Windows New Technology' 
    Else If ( OSCode = cOsWin2000 ) Then 
        Result := 'Microsoft Windows 2000 / NT 5' 
    Else 
        Result := 'Microsoft Windows'; 
End;

function IsAdmin: Boolean;
var 
  hAccessToken: THandle; 
  ptgGroups: PTokenGroups; 
  dwInfoBufferSize: DWORD; 
  psidAdministrators: PSID; 
  x: Integer; 
  bSuccess: BOOL; 
begin 
  Result := False; 
  bSuccess := OpenThreadToken(GetCurrentThread, TOKEN_QUERY, True, 
    hAccessToken); 
  if not bSuccess then 
  begin 
    if GetLastError = ERROR_NO_TOKEN then 
    bSuccess := OpenProcessToken(GetCurrentProcess, TOKEN_QUERY, 
      hAccessToken); 
  end; 
  if bSuccess then 
  begin 
    GetMem(ptgGroups, 1024); 
    bSuccess := GetTokenInformation(hAccessToken, TokenGroups, 
      ptgGroups, 1024, dwInfoBufferSize); 
    CloseHandle(hAccessToken); 
    if bSuccess then 
    begin 
      AllocateAndInitializeSid(SECURITY_NT_AUTHORITY, 2, 
        SECURITY_BUILTIN_DOMAIN_RID, DOMAIN_ALIAS_RID_ADMINS, 
        0, 0, 0, 0, 0, 0, psidAdministrators); 
      {$R-} 
      for x := 0 to ptgGroups.GroupCount - 1 do 
        if EqualSid(psidAdministrators, ptgGroups.Groups[x].Sid) then 
        begin 
          Result := True; 
          Break; 
        end; 
      {$R+} 
      FreeSid(psidAdministrators); 
    end; 
    FreeMem(ptgGroups); 
  end; 
end; 


end.


