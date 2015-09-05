/*
 * BitmapConverter.java
 *
 * Created on September 25, 2003, 12:29 PM
 */

/**
 *
 * @author  harperart
 */
public class BitmapConverter
{
    final static String IrcSymbols = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{‚|}~„…†‡‰‹‘’“”•–—™›¢£¤¦§¨©ª«¬­®¯°±²³µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğñòóôõö÷øùúûüış";
    /** Creates a new instance of BitmapConverter */
    public BitmapConverter()
    {
    }
    public static String EncodeBitmapToString2(int[] pixles,int width,int height)
    {
        int x,y;
        boolean last,white;
        int count;
        String result= "";
        count = 0;
        last = false;
        for (y= 0; y < height-1;y++)
        {
            for (x= 0; x < width-1;x++)
            {
                if(x >= 255)
                    white = false;
                else if(pixles[x+y*255] == 0xFFFFFF)
                    white= true;
                else
                    white = false;
                if(count == 0 || white != last)
                {
                    if(count != 0)
                    {
                        if(last)
                            result += IrcSymbols.charAt(count);
                        else
                            result += IrcSymbols.charAt(count);
                    }
                    count= 1;
                }
                else
                {
                    count = count + 1;
                }
                if(count >= IrcSymbols.length())
                {
                    result += IrcSymbols.charAt(IrcSymbols.length()-1);
                    result += IrcSymbols.charAt(0);
                    count = 1;
                }
                last = white;
            }
        }
        return result;
    }
    public static void main(String[] argv)
    {
        int[] array = new int[255*40];
        //array[250] = 0xffffff;
        int i = 1;
        int j = 0;
        array[40] = 0xffffff;
        array[255+40] = 0xffffff;
        System.out.println(EncodeBitmapToString2(array, 256,40));
    }
}
