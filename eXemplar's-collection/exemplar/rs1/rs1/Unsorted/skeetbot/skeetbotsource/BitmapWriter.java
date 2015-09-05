import java.awt.*;
import java.io.*;
import java.awt.image.*;

public class BitmapWriter extends Component
{
  private final static int BITMAPFILEHEADER_SIZE = 14;
  private final static int BITMAPINFOHEADER_SIZE = 40;
  private static byte bitmapFileHeader[] = new byte[14];
  private static byte bfType[] = {'B','M'};
  private static int bfSize = 0;
  private static int bfReserved1 = 0;
  private static int bfReserved2 = 0;
  private static int bfOffBits = BITMAPFILEHEADER_SIZE + BITMAPINFOHEADER_SIZE;
  private static byte bitmapInfoHeader[] = new byte[40];
  private static int biSize = BITMAPINFOHEADER_SIZE;
  private static int biWidth = 255;
  private static int biHeight = 40;
  private static int biPlanes = 1;
  private static int biBitCount = 24;
  private static int biCompression = 0;
  private static int biSizeImage = 0x030000;
  private static int biXPelsPerMeter = 0x0;
  private static int biYPelsPerMeter = 0x0;
  private static int biClrUsed = 0;
  private static int biClrImportant = 0;
  private static int bitmap[];
  private static FileOutputStream fo;
  
  public static void saveBitmap(String parFilename,int[] parImage,int parWidth,int parHeight)
  {
    try
    {
      fo = new FileOutputStream(parFilename);
      save(parImage,parWidth,parHeight);
      fo.close();
    }
    catch(Exception saveEx){saveEx.printStackTrace();}
  }

  private static void save(int[] parImage,int parWidth,int parHeight)
  {
    try
    {
      int pad;
      bitmap = parImage;
      pad = (4 - ((parWidth * 3) % 4)) * parHeight;
      biSizeImage = ((parWidth * parHeight) * 3) + pad;
      bfSize = biSizeImage + BITMAPFILEHEADER_SIZE + BITMAPINFOHEADER_SIZE;
      biWidth = parWidth;
      biHeight = parHeight;
      try
      {
        fo.write(bfType);
        fo.write(intToDWord(bfSize));
        fo.write(intToWord(bfReserved1));
        fo.write(intToWord(bfReserved2));
        fo.write(intToDWord(bfOffBits));
        fo.write(intToDWord(biSize));
        fo.write(intToDWord(biWidth));
        fo.write(intToDWord(biHeight));
        fo.write(intToWord(biPlanes));
        fo.write(intToWord(biBitCount));
        fo.write(intToDWord(biCompression));
        fo.write(intToDWord(biSizeImage));
        fo.write(intToDWord(biXPelsPerMeter));
        fo.write(intToDWord(biYPelsPerMeter));
        fo.write(intToDWord(biClrUsed));
        fo.write(intToDWord(biClrImportant));
      }
      catch(Exception wbih){wbih.printStackTrace();}
      writeBitmap();
    }
    catch(Exception saveEx){saveEx.printStackTrace();}
  }

  private static void writeBitmap()
  {
    int size;
    int value;
    int j;
    int i;
    int rowCount;
    int rowIndex;
    int lastRowIndex;
    int pad;
    int padCount;
    byte rgb[] = new byte[3];
    size = (biWidth * biHeight) - 1;
    pad = 4 - ((biWidth * 3) % 4);
    if(pad == 4)
      pad = 0;
    rowCount = 1;
    padCount = 0;
    rowIndex = size - biWidth;
    lastRowIndex = rowIndex;
    try
    {
      for(j = 0; j < size; j++)
      {
        value = bitmap [rowIndex];
        rgb[0] = (byte)(value & 0xFF);
        rgb[1] = (byte)((value >> 8) & 0xFF);
        rgb[2] = (byte)((value >>  16) & 0xFF);
        fo.write(rgb);
        if(rowCount == biWidth)
        {
          padCount += pad;
          for(i = 1; i <= pad; i++)
            fo.write(0x00);
            rowCount = 1;
            rowIndex = lastRowIndex - biWidth;
            lastRowIndex = rowIndex;
        }
        else
          rowCount++;
        rowIndex++;
      }
      bfSize += padCount - pad;
      biSizeImage += padCount - pad;
    }
    catch(Exception wb){wb.printStackTrace();}
  }  

  private static byte[] intToWord(int parValue)
  {
    byte retValue[] = new byte[2];
    retValue [0] = (byte)(parValue & 0x00FF);
    retValue [1] = (byte)((parValue >>  8) & 0x00FF);
    return(retValue);
  }

  private static byte[] intToDWord(int parValue)
  {
    byte retValue[] = new byte [4];
    retValue[0] = (byte)(parValue & 0x00FF);
    retValue[1] = (byte)((parValue >>  8) & 0x000000FF);
    retValue[2] = (byte)((parValue >>  16) & 0x000000FF);
    retValue[3] = (byte)((parValue >>  24) & 0x000000FF);
    return(retValue);
  }
}