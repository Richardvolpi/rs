import java.awt.*;
import java.io.*;
import java.awt.image.*;

public class BitmapWriter extends Component {
 //--- Private constants
 private final static int BITMAPFILEHEADER_SIZE = 14;
 private final static int BITMAPINFOHEADER_SIZE = 40;
 //--- Private Static variable declaration
 //--- Bitmap file header
 private static byte bitmapFileHeader [] = new byte [14];
 private static byte bfType [] = {'B', 'M'};
 private static int bfSize = 0;
 private static int bfReserved1 = 0;
 private static int bfReserved2 = 0;
 private static int bfOffBits = BITMAPFILEHEADER_SIZE + BITMAPINFOHEADER_SIZE;
 //--- Bitmap info header
 private static byte bitmapInfoHeader [] = new byte [40];
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
 //--- Bitmap raw data
 private static int bitmap [];
 //--- File section
 private static FileOutputStream fo;
 //--- Default constructor
 public static void saveBitmap (String parFilename, int[] parImage, int
parWidth, int parHeight) {
     try {
         fo = new FileOutputStream (parFilename);
         save (parImage, parWidth, parHeight);
         fo.close ();        
    }
    catch (Exception saveEx) {
       saveEx.printStackTrace ();
    }
 }
 /*
  *  The saveMethod is the main method of the process. This method
  *  will call the convertImage method to convert the memory image to
  *  a byte array; method writeBitmapFileHeader creates and writes
  *  the bitmap file header; writeBitmapInfoHeader creates the
  *  information header; and writeBitmap writes the image.
  *
  */
 private static void save (int[] parImage, int parWidth, int parHeight) {
     try {
       convertImage (parImage, parWidth, parHeight);
       writeBitmapFileHeader ();
       writeBitmapInfoHeader ();
       writeBitmap ();
    }
    catch (Exception saveEx) {
       saveEx.printStackTrace ();
    }
 }
 /*
  * convertImage converts the memory image to the bitmap format (BRG).
  * It also computes some information for the bitmap info header.
  *
  */
 private static boolean convertImage (int[] parImage, int parWidth, int parHeight) {
    int pad;
    bitmap = parImage;
    pad = (4 - ((parWidth * 3) % 4)) * parHeight;
    biSizeImage = ((parWidth * parHeight) * 3) + pad;
    bfSize = biSizeImage + BITMAPFILEHEADER_SIZE +
BITMAPINFOHEADER_SIZE;
    biWidth = parWidth;
    biHeight = parHeight;
    return (true);
 }
 /*
  * writeBitmap converts the image returned from the pixel grabber to
  * the format required. Remember: scan lines are inverted in
  * a bitmap file!
  *
  * Each scan line must be padded to an even 4-byte boundary.
  */
   private static void writeBitmap () {
     int size;
     int value;
     int j;
     int i;
     int rowCount;
     int rowIndex;
     int lastRowIndex;
     int pad;
     int padCount;
     byte rgb [] = new byte [3];
     size = (biWidth * biHeight) - 1;
     pad = 4 - ((biWidth * 3) % 4);
     if (pad == 4)   // <==== Bug correction
        pad = 0;     // <==== Bug correction
     rowCount = 1;
     padCount = 0;
     rowIndex = size - biWidth;
     lastRowIndex = rowIndex;
     try {
        for (j = 0; j < size; j++) {
           value = bitmap [rowIndex];
           rgb [0] = (byte) (value & 0xFF);
           rgb [1] = (byte) ((value >> 8) & 0xFF);
           rgb [2] = (byte) ((value >>  16) & 0xFF);
           fo.write (rgb);
           if (rowCount == biWidth) {
              padCount += pad;
              for (i = 1; i <= pad; i++) {
                 fo.write (0x00);
              }
              rowCount = 1;
              rowIndex = lastRowIndex - biWidth;
              lastRowIndex = rowIndex;
           }
           else
              rowCount++;
           rowIndex++;
        }
        //--- Update the size of the file
        bfSize += padCount - pad;
        biSizeImage += padCount - pad;
     }
     catch (Exception wb) {
        wb.printStackTrace ();
     }
  }  
 /*
  * writeBitmapFileHeader writes the bitmap file header to the file.
  *
  */
 private static void writeBitmapFileHeader () {
    try {
       fo.write (bfType);
       fo.write (intToDWord (bfSize));
       fo.write (intToWord (bfReserved1));
       fo.write (intToWord (bfReserved2));
       fo.write (intToDWord (bfOffBits));
    }
    catch (Exception wbfh) {
       wbfh.printStackTrace ();
    }
 }
 /*
  *
  * writeBitmapInfoHeader writes the bitmap information header
  * to the file.
  *
  */
 private static void writeBitmapInfoHeader () {
    try {
       fo.write (intToDWord (biSize));
       fo.write (intToDWord (biWidth));
       fo.write (intToDWord (biHeight));
       fo.write (intToWord (biPlanes));
       fo.write (intToWord (biBitCount));
       fo.write (intToDWord (biCompression));
       fo.write (intToDWord (biSizeImage));
       fo.write (intToDWord (biXPelsPerMeter));
       fo.write (intToDWord (biYPelsPerMeter));
       fo.write (intToDWord (biClrUsed));
       fo.write (intToDWord (biClrImportant));
    }
    catch (Exception wbih) {
       wbih.printStackTrace ();
    }
 }
 /*
  *
  * intToWord converts an int to a word, where the return
  * value is stored in a 2-byte array.
  *
  */
 private static byte [] intToWord (int parValue) {
    byte retValue [] = new byte [2];
    retValue [0] = (byte) (parValue & 0x00FF);
    retValue [1] = (byte) ((parValue >>  8) & 0x00FF);
    return (retValue);
 }
 /*
  *
  * intToDWord converts an int to a double word, where the return
  * value is stored in a 4-byte array.
  *
  */
 private static byte [] intToDWord (int parValue) {
    byte retValue [] = new byte [4];
    retValue [0] = (byte) (parValue & 0x00FF);
    retValue [1] = (byte) ((parValue >>  8) & 0x000000FF);
    retValue [2] = (byte) ((parValue >>  16) & 0x000000FF);
    retValue [3] = (byte) ((parValue >>  24) & 0x000000FF);
    return (retValue);
 }
}