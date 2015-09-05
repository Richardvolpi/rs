unit MapForm;

interface

uses
  Windows, Messages, SysUtils, Classes, Graphics, Controls, Forms, Dialogs,
  GR32_Image, ExtCtrls, Unit1, GR32_Layers, RSCommands;

type
  TfrmMap = class(TForm)
    Timer1: TTimer;
    MapImage: TImage32;
    procedure FormCreate(Sender: TObject);
    procedure Timer1Timer(Sender: TObject);
    procedure MapImageMouseDown(Sender: TObject; Button: TMouseButton;
      Shift: TShiftState; PelX, PelY: Integer; Layer: TCustomLayer);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmMap: TfrmMap;
  DistNums: BigWordArray;
  MapPath: TPointArray;

implementation

{$R *.DFM}

procedure TfrmMap.FormCreate(Sender: TObject);
begin
  MapImage.Bitmap.Width:= 160;
  MapImage.Bitmap.Height:= 160;
end;

procedure TfrmMap.Timer1Timer(Sender: TObject);
var
  f,x,y: Integer;
begin
  for x:= MyX+XShift - 79 to MyX+XShift + 79 do
  begin
    for y:= MyY+YShift - 79 to MyY+YShift + 79 do
    begin
      if((x > High(BigMap))or(x < Low(BigMap)))or
        ((y > High(BigMap[x]))or(y < Low(BigMap[x])))or
        (BigMap[x,y] = 0)
      then
      begin
        MapImage.Bitmap.PixelS[159 - (x - (MyX+XShift) + 79), y - (MyY+YShift) + 79]:= $808080;
      end else
      if(BigMap[x,y] = $FF)then
      begin
        MapImage.Bitmap.PixelS[159 - (x - (MyX+XShift) + 79), y - (MyY+YShift) + 79]:= $0;
      end else
      begin
        MapImage.Bitmap.PixelS[159 - (x - (MyX+XShift) + 79), y - (MyY+YShift) + 79]:= $FFFFFF;
      end;
    end;
  end;
  //Draw path
  for f:= 0 to Length(MapPath)-1 do
  begin
    x:= MapPath[f].x;
    y:= MapPath[f].y;
    MapImage.Bitmap.PixelS[159 - (x - MyX + 79), y - MyY + 79]:= $4444FF;
  end;
  MapImage.Bitmap.PixelS[80,79]:= $FF0000;
  MapImage.Invalidate;
end;

procedure TfrmMap.MapImageMouseDown(Sender: TObject; Button: TMouseButton;
  Shift: TShiftState; PelX, PelY: Integer; Layer: TCustomLayer);
var
  x, y: Integer;
  A: TIntegerArray;
begin
  //
  x:= 159 - pelX + MyX+XShift - 78;
  y:= MyY+YShift + pelY - 75;
  FillBigMapWithDistanceNumbers(BigMap, DistNums, MyX+XShift, MyY+YShift, x, y, 200);
  MakePath(DistNums, MapPath, MyX+XShift, MyY+YShift);
  MakeMoveToCoordList(MapPath, A);
  If(LastClient<>nil)Then Begin
    ///EEE LastClient.Write( EncryptCommandForServerF(cmdWalk(A,#$C2)));
    LastClient.Write( cmdWalk(A,#$C2));
  End;
end;

end.
