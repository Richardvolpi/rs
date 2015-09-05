import java.io.*;
import java.net.URL;

public class Convert {

    public static InputStream OpenInputStream(String arg0)throws IOException
    {
        Object obj = new BufferedInputStream(new FileInputStream(arg0));
        return ((InputStream) (obj));
    }

    public static int process(int k, int i1, int j1)
    {
        return -1 - (k / 8) * 1024 - (i1 / 8) * 32 - j1 / 8;
    }

    public static int extractInt(byte byte0)
    {
        return byte0 & 0xff;
    }

    public static int extractIntFrom(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 8) + (abyte0[i + 1] & 0xff);
    }

    public static int extractLongFrom(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    public static long extractLong(byte bytes[], int length)
    {
        return (((long)extractLongFrom(bytes, length) & 0xffffffffL) << 32) + ((long)extractLongFrom(bytes, length + 4) & 0xffffffffL);
    }

    public static int extractIntProc(byte abyte0[], int i)
    {
        int j = extractInt(abyte0[i]) * 256 + extractInt(abyte0[i + 1]);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public static int extractIntSelect(byte abyte0[], int i)
    {
        if((abyte0[i] & 0xff) < 128)
            return abyte0[i];
        else
            return ((abyte0[i] & 0xff) - 128 << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    public static int extractIntBounds(byte arg0[], int arg1, int arg2)
    {
        int i = arg1 >> 3;
        int j = 8 - (arg1 & 7);
        int k = 0;
        for(; arg2 > j; j = 8)
        {
            k += (arg0[i++] & fmd[j]) << arg2 - j;
            arg2 -= j;
        }
        if(arg2 == j)
            k += arg0[i] & fmd[j];
        else
            k += arg0[i] >> j - arg2 & fmd[arg2];
        return k;
    }

    public static String fillOut(String toFill, int fillTo) {
        String s = "";
        for(int i = 0; i < fillTo; i++) {
            if(i >= toFill.length())
                s = s + " ";
            else {
                char c = toFill.charAt(i);
                if(c >= 'a' && c <= 'z')
                    s = s + c;
                else if(c >= 'A' && c <= 'Z')
                    s = s + c;
                else if(c >= '0' && c <= '9')
                    s = s + c;
                else
                    s = s + '_';
            }
        }
        return s;
    }

    public static long PlayerNameToLong(String user) {
        String s = "";
        for(int i = 0; i < user.length(); i++) {
            char c = user.charAt(i);
            if(c >= 'a' && c <= 'z')
                s = s + c;
            else if(c >= 'A' && c <= 'Z')
                s = s + (char)((c + 97) - 65);
            else if(c >= '0' && c <= '9')
                s = s + c;
            else
                s = s + ' ';
        }
        s = s.trim();
        if(s.length() > 12)
            s = s.substring(0, 12);
        long l = 0L;
        for(int j = 0; j < s.length(); j++) {
            char c1 = s.charAt(j);
            l *= 37L;
            if(c1 >= 'a' && c1 <= 'z')
                l += (1 + c1) - 97;
            else if(c1 >= '0' && c1 <= '9')
                l += (27 + c1) - 48;
        }
        return l;
    }

    public static String PlayerLongToName(long arg0)
    {
        if(arg0 < 0L)
            return "invalid_name";
        String s = "";
        while(arg0 != 0L) 
        {
            int i = (int)(arg0 % 37L);
            arg0 /= 37L;
            if(i == 0)
                s = " " + s;
            else if(i < 27)
            {
                if(arg0 % 37L == 0L)
                    s = (char)((i + 65) - 1) + s;
                else
                    s = (char)((i + 97) - 1) + s;
            }
            else
                s = (char)((i + 48) - 27) + s;
        }
        return s;
    }

    public static int fne(String arg0, byte arg1[])
    {
        int i = extractIntFrom(arg1, 0);
        int j = 0;
        arg0 = arg0.toUpperCase();
        for(int k = 0; k < arg0.length(); k++)
            j = (j * 61 + arg0.charAt(k)) - 32;
        int l = 2 + i * 10;
        for(int i1 = 0; i1 < i; i1++)
        {
            int j1 = (arg1[i1 * 10 + 2] & 0xff) * 0x1000000 + (arg1[i1 * 10 + 3] & 0xff) * 0x10000 + (arg1[i1 * 10 + 4] & 0xff) * 256 + (arg1[i1 * 10 + 5] & 0xff);
            int k1 = (arg1[i1 * 10 + 9] & 0xff) * 0x10000 + (arg1[i1 * 10 + 10] & 0xff) * 256 + (arg1[i1 * 10 + 11] & 0xff);
            if(j1 == j)
                return l;
            l += k1;
        }
        return 0;
    }

    public static int fnf(String arg0, byte arg1[])
    {
        int i = extractIntFrom(arg1, 0);
        int j = 0;
        arg0 = arg0.toUpperCase();
        for(int k = 0; k < arg0.length(); k++)
            j = (j * 61 + arg0.charAt(k)) - 32;
        int l = 2 + i * 10;
        for(int i1 = 0; i1 < i; i1++)
        {
            int j1 = (arg1[i1 * 10 + 2] & 0xff) * 0x1000000 + (arg1[i1 * 10 + 3] & 0xff) * 0x10000 + (arg1[i1 * 10 + 4] & 0xff) * 256 + (arg1[i1 * 10 + 5] & 0xff);
            int k1 = (arg1[i1 * 10 + 6] & 0xff) * 0x10000 + (arg1[i1 * 10 + 7] & 0xff) * 256 + (arg1[i1 * 10 + 8] & 0xff);
            int l1 = (arg1[i1 * 10 + 9] & 0xff) * 0x10000 + (arg1[i1 * 10 + 10] & 0xff) * 256 + (arg1[i1 * 10 + 11] & 0xff);
            if(j1 == j)
                return k1;
            l += l1;
        }
        return 0;
    }

    public static byte[] Extract(String s, int i, byte abyte0[])
    {
        return Extract(s, i, abyte0, null);
    }

    public static byte[] Extract(String arg0, int arg1, byte arg2[], byte arg3[])
    {
        int i = (arg2[0] & 0xff) * 256 + (arg2[1] & 0xff);
        int j = 0;
        arg0 = arg0.toUpperCase();
        for(int k = 0; k < arg0.length(); k++)
            j = (j * 61 + arg0.charAt(k)) - 32;
        int l = 2 + i * 10;
        for(int i1 = 0; i1 < i; i1++)
        {
            int j1 = (arg2[i1 * 10 + 2] & 0xff) * 0x1000000 + (arg2[i1 * 10 + 3] & 0xff) * 0x10000 + (arg2[i1 * 10 + 4] & 0xff) * 256 + (arg2[i1 * 10 + 5] & 0xff);
            int k1 = (arg2[i1 * 10 + 6] & 0xff) * 0x10000 + (arg2[i1 * 10 + 7] & 0xff) * 256 + (arg2[i1 * 10 + 8] & 0xff);
            int l1 = (arg2[i1 * 10 + 9] & 0xff) * 0x10000 + (arg2[i1 * 10 + 10] & 0xff) * 256 + (arg2[i1 * 10 + 11] & 0xff);
            if(j1 == j)
            {
                if(arg3 == null)
                    arg3 = new byte[k1 + arg1];
                if(k1 != l1)
                    g.glj(arg3, k1, arg2, l1, l);
                else
                {
                    for(int i2 = 0; i2 < k1; i2++)
                        arg3[i2] = arg2[l + i2];
                }
                return arg3;
            }
            l += l1;
        }
        return null;
    }

    public static String extractString(byte arg0[], int arg1, int arg2)
    {
        try
        {
            int i = 0;
            int j = -1;
            for(int k = 0; k < arg2; k++)
            {
                int l = arg0[arg1++] & 0xff;
                int i1 = l >> 4 & 0xf;
                if(j == -1)
                {
                    if(i1 < 13)
                        ceh[i++] = cei[i1];
                    else
                        j = i1;
                }
                else
                {
                    ceh[i++] = cei[((j << 4) + i1) - 195];
                    j = -1;
                }
                i1 = l & 0xf;
                if(j == -1)
                {
                    if(i1 < 13)
                        ceh[i++] = cei[i1];
                    else
                        j = i1;
                }
                else
                {
                    ceh[i++] = cei[((j << 4) + i1) - 195];
                    j = -1;
                }
            }
            boolean flag = true;
            for(int j1 = 0; j1 < i; j1++)
            {
                char c = ceh[j1];
                if(j1 > 4 && c == '@')
                    ceh[j1] = ' ';
                if(c == '%')
                    ceh[j1] = ' ';
                if(flag && c >= 'a' && c <= 'z')
                {
                    ceh[j1] += '\uFFE0';
                    flag = false;
                }
                if(c == '.' || c == '!')
                    flag = true;
            }
            return new String(ceh, 0, i);
        }
        catch(Exception e){return ".";}
    }

    public static int cek(String arg0)
    {
        if(arg0.length() > 80)
            arg0 = arg0.substring(0, 80);
        arg0 = arg0.toLowerCase();
        int i = 0;
        int j = -1;
        for(int k = 0; k < arg0.length(); k++)
        {
            char c = arg0.charAt(k);
            int l = 0;
            for(int i1 = 0; i1 < cei.length; i1++)
            {
                if(c != cei[i1])
                    continue;
                l = i1;
                break;
            }
            if(l > 12)
                l += 195;
            if(j == -1)
            {
                if(l < 13)
                    j = l;
                else
                    ceg[i++] = (byte)l;
            }
            else if(l < 13)
            {
                ceg[i++] = (byte)((j << 4) + l);
                j = -1;
            }
            else
            {
                ceg[i++] = (byte)((j << 4) + (l >> 4));
                j = l & 0xf;
            }
        }
        if(j != -1)
            ceg[i++] = (byte)(j << 4);
        return i;
    }

    public static byte ceg[] = new byte[100];
    public static char ceh[] = new char[100];
    private static char cei[] = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', 
        '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243', '$', '%', '"', '[', ']'};
    private static int fmd[] = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff,
    0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, -1};
    public static boolean fme;
}
