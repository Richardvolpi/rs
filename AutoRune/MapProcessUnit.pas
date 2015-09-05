unit MapProcessUnit;

interface
uses GR32, Graphics, Windows;

type TLauk = array[1..40,1..40]of Word;
     TCoordCenters = array[1..40]of Integer;

const CompassColor : Cardinal = $2A190D; 
      ObjectColor : Cardinal  = $00FFFF;
      WaterColor : Cardinal   = $20407E;
      WallColor : Cardinal    = $606060;
      MountainColor : Cardinal   = $646464;
      BrownMountainColor : Cardinal = $703002;
      RoadColor : Cardinal    = $404040;


var
  MapBMP: TBitmap32;
  MapLauk: TLauk;
  colcount, linecount: Integer;

function ProcessMap: Boolean;
procedure CopyMinimap(Dest: TCanvas; Handle: Cardinal);

implementation

procedure CopyMinimap(Dest: TCanvas; Handle: Cardinal);
var DCDesk: HDC; // hDC of Desktop
begin

  {Get a desktop DC handle - handle of a display device context}
  DCDesk := GetWindowDC(Handle);

  {Copy to any canvas, here canvas of an image}
  BitBlt( Dest.Handle, 0, 0, 155, 151,
         DCDesk, 357, 78, SRCCOPY);


  {Release desktop DC handle}
  ReleaseDC(Handle, DCDesk);

end;

function SmallCross(B: TBitmap32; Col: TColor32; x,y: Integer): Boolean;
begin
  result:= False;
  if(B.PixelS[x,y] and $FFFFFF = Cardinal(Col))then
  begin
          if(x>0)and(x<B.Width - 1)and(y > 0)and(y < B.Height - 1)then
          begin
            if(B.Pixels[x,y] = B.Pixels[x-1,y])and
              (B.Pixels[x,y] = B.Pixels[x+1,y])and
              (B.Pixels[x,y] = B.Pixels[x,y-1])and
              (B.Pixels[x,y] = B.Pixels[x,y+1])then
            begin
              result:= True;
            end;
          end;
  end;
end;

procedure NewLines(var c: Integer; var lines: TCoordCenters; y: Integer; Force: Boolean; MovePrev: Boolean);
var counter: Extended;
    f, dist: Integer;
begin
  if(c<= High(lines))then
  begin
    counter:= lines[c];
    while(y - lines[c] > 5)and( c < High(lines)) do begin
      c:= c + 1;
      counter:= counter + 4.5;
      lines[c]:= Round(counter);
    end;
    if(Force)and(c < High(lines))then
    begin
      if(MovePrev)and(y - lines[c]<4)then
      begin
        dist:= y - lines[c];
        for f:= 1 to c do
        begin
          lines[f]:= lines[f] + dist;
        end;
      end else
      begin
        c:= c + 1;
        lines[c]:= y;
      end;

    end;
  end;  
end;

function FindIfColor(B: TBitmap32; x1, y1, x2, y2: Integer; Color: TColor32):boolean;
var x, y: Integer;
begin
//  Color:= ConvertColor(Color);
  result:= False;
  for x:= x1 to x2 do
  begin
    for y:= y1 to y2 do
    begin
      if(B.Pixels[x, y] and $FFFFFF = Color)then
      begin
        result:= True;
        Exit;
      end;
    end;
  end;
end;


function ProcessMap: Boolean;
var x, y, c: Integer;
    B1, B2: TBitmap32;
    B: Boolean;
    s: string;
    lines, cols: TCoordCenters;
begin
  FillChar(MapLauk, SizeOf(MapLauk), 0);
//M  Image2.Bitmap.Width:= Image1.Bitmap.Width;
//M  Image2.Bitmap.Height:= Image1.Bitmap.Height;
//  B1:= TBitmap32.Create;
//  B1.Width:= Image1.Bitmap.Width;
//  B1.Height:= Image1.Bitmap.Height;

//  Image1.Bitmap.DrawTo(B1);

  result:= False;
  B1:= MapBMP;
  B2:= TBitmap32.Create;
  B2.Width:= B1.Width;
  B2.Height:= B1.Height;
  B2.Canvas.Brush.Style:= bsSolid;
  B2.Canvas.Brush.Color:= clBlack;
  B2.FillRectS(0, 0, B2.Width, B2.Height, 0);
  //Check if we have the compass set up correctly
  B:= True;
  colcount:= 0;
  linecount:= 0;

  s:= 'Hor: ';
  B1.SaveToFile('c:\minimap.bmp');
  for x:= 15 to 25 do
  begin
    B:= B and ((B1.Pixels[x,20]) and $FFFFFF = CompassColor);
//    s:= s + IntToHex(B1.Pixels[x,20] and $FFFFFF,6) + ' ';
  end;
  s:= s + ' Ver: ';
  for y:= 15 to 25 do
  begin
    B:= B and ((B1.Pixels[20,y]) and $FFFFFF = CompassColor);
//    s:= s + IntToHex(B1.Pixels[20,y] and $FFFFFF,6) + ' ';
  end;
  if(not B)then
  begin
//    B1.SaveToFile(ExtractFilePath(Application.Exename) + 'failmap.bmp');
//    DebugAdd(s);
//    DebugAdd('Bad map saved as ' + ExtractFilePath(Application.Exename) + 'failmap.bmp');
//    DebugAdd('Window handle: ' + IntToStr(LastRSWindow));
    Exit;
  end;
//  DebugAdd('Before find horizontal');
  //Let's find all horizontal lines we can
  for y:= 1 to 40 do
  begin
    lines[y]:= -1;
  end;
  c:= 1;
  lines[c]:= 0;
  for y:= 0 to B1.Height-1 do
  begin
    for x:= 0 to B1.Width-1 do
    begin
      if(x >= 40) or (y >=40) then
      begin

        if(SmallCross(B1, ObjectColor, x, y)){or(SmallCross(B1, BWaterColor, x, y))}then
        begin
          B2.Pixel[x,y]:= B1.Pixel[x,y];
          if(c=0)or(lines[c] <> y)then
          begin
            //Fill in the missing lines using imagination
            if(c = 0)or(y - lines[c] <= 5)then
            begin
              if((c=0)or(y - lines[c] > 3))and(c<40)then
                c:= c + 1;
              lines[c]:= y;
            end else
            begin
              NewLines(c, lines, y, True, (c = 1));
            end;

          end;
        end;
      end;
    end;
  end;
  NewLines(c, lines, B1.Height - 1, False, False);
  linecount:= c;
//  DebugAdd('Before find vertical');
  //Let's find all vertical lines we can (columns)
  for x:= 1 to 40 do
  begin
    cols[x]:= -1;
  end;
  c:= 1;
  cols[c]:= 0;
  for x:= 0 to B1.Width-1 do
  begin
    for y:= 0 to B1.Height-1 do
    begin
      if(x >= 40) or (y >=40) then
      begin

        if(SmallCross(B1, ObjectColor, x, y)){or(SmallCross(B1, WaterColor, x, y))}then
        begin
          B2.Pixel[x,y]:= B1.Pixel[x,y];
          if(c=0)or(cols[c] <> x)then
          begin
            //Fill in the missing lines using imagination
            if(c = 0)or(x - cols[c] <= 5)then
            begin
              if((c=0)or(x - cols[c] > 3))and(c < 40)then
                c:= c + 1;
              cols[c]:= x;
            end else
            begin
              NewLines(c, cols, x, True, (c=1));
            end;
          end;
        end;
      end;
    end;
  end;
  NewLines(c, cols, B1.Width - 1, False, False);
  colcount:= c;
  //Now we have coordinate crosspoints


//  DebugAdd('Before Check Walls');
  //Check for walls
  //We don't care for the edge squares
  for x:= 2 to colcount-1 do
  begin
    for y:= 2 to linecount-1 do
    begin
      //water
      if(FindIfColor(B1, cols[x]-1,cols[y]-1,cols[x]+1,cols[y]+1, WaterColor))or
        (FindIfColor(B1, cols[x]-3,cols[y]-3,cols[x]+3,cols[y]+3, MountainColor))or
        (FindIfColor(B1, cols[x]-3,cols[y]-3,cols[x]+1,cols[y]+3, BrownMountainColor))then
      begin
        MapLauk[x,y]:= MapLauk[x,y] or $0800;
      end;
      if(FindIfColor(B1, cols[x]-1,cols[y]-1,cols[x]+1,cols[y]+1, RoadColor))then
      begin
        MapLauk[x,y]:= MapLauk[x,y] or $0200;
      end;
      if(MapLauk[x,y] and $8000 = 0)then //UpperWall
        if(FindIfColor(B1, cols[x]-2, lines[y]-3, cols[x]+2, lines[y]-1, WallColor))then
        begin
          MapLauk[x,y]:= MapLauk[x,y] or $8000;
          MapLauk[x,y-1]:= MapLauk[x,y-1] or $4000;
        end;
      if(MapLauk[x,y] and $4000 = 0)then //BottomWall
        if(FindIfColor(B1, cols[x]-2, lines[y], cols[x]+2, lines[y]+2, WallColor))then
        begin
          MapLauk[x,y]:= MapLauk[x,y] or $4000;
          MapLauk[x,y+1]:= MapLauk[x,y+1] or $8000;
        end;
      if(MapLauk[x,y] and $2000 = 0)then //RightWall
        if(FindIfColor(B1, cols[x], lines[y]-2, cols[x]+2, lines[y]+2, WallColor))then
        begin
          MapLauk[x,y]:= MapLauk[x,y] or $2000;
          MapLauk[x+1,y]:= MapLauk[x+1,y] or $1000;
        end;
      if(MapLauk[x,y] and $1000 = 0)then //LeftWall
        if(FindIfColor(B1, cols[x]-3, lines[y]-2, cols[x]-1, lines[y]+2, WallColor))then
        begin
          MapLauk[x,y]:= MapLauk[x,y] or $1000;
          MapLauk[x-1,y]:= MapLauk[x-1,y] or $2000;
        end;
    end;
  end;

  //Draw things, just because they're pretty
{  for y:= 1 to 40 do
  begin
    if(lines[y]<>-1)then
      B2.HorzLine(0, lines[y], B2.Width - 1, ObjectColor);
  end;
  for x:= 1 to 40 do
  begin
    if(cols[x]<>-1)then
      B2.VertLine(cols[x], 0, B2.Height - 1, ObjectColor);
  end; }
//  DebugAdd('Before obtain objects (linecount=' + IntToStr(linecount) + ', colcount=' + IntToStr(colcount));
  //Obtain coordinates of blue objects
  for x:= 1 to colcount do
  begin
    for y:= 1 to linecount do
    begin
      if(SmallCross(B1, ObjectColor, cols[x], lines[y]))then
      begin
        //B2.Pixel[cols[x], lines[y]]:= $0;
        if(x>0)and(x<=40)and(y>0)and(y<=40)then
          MapLauk[x,y]:= MapLauk[x,y] or $0100;
      end;
  {    if(MapLauk[x,y] and $8000=$8000)then
        B2.HorzLine(cols[x]-1, lines[y] - 1, cols[x]+1, $FFFFFF);
      if(MapLauk[x,y] and $4000=$4000)then
        B2.HorzLine(cols[x]-1, lines[y] + 1, cols[x]+1, $FFFFFF);
      if(MapLauk[x,y] and $2000=$2000)then
        B2.VertLine(cols[x]+1, lines[y] - 1, lines[y]+1, $FFFFFF);
      if(MapLauk[x,y] and $1000=$1000)then
        B2.VertLine(cols[x]-1, lines[y] - 1, lines[y]+1, $FFFFFF);
      if(MapLauk[x,y] and $0800=$0800)then
      begin
        B2.FillRectS(cols[x]-2,cols[y]-2,cols[x]+2,cols[y]+2,WaterColor);
      end; }
    end;
  end;
//  DebugAdd('Before free B2');

//M  B2.DrawTo(Image2.Bitmap);
//M  Image2.Invalidate;
//  B1.Free;
  B2.Assign(nil);
  B2.Free;
  result:= (linecount > 0) and (linecount < 40);

end;


begin

MapBMP:= TBitmap32.Create;
MapBMP.Width:= 155;
MapBMP.Height:= 151;

end.
 