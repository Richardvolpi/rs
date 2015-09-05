// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex;

import java.io.*;
import java.net.URL;

// Referenced classes of package jagex:
//            n

public class o
{

    public static InputStream jn(String s)
        throws IOException
    {
        Object obj;
        if(qfb == null)
        {
            obj = new FileInputStream(s);
        } else
        {
            URL url = new URL(qfb, s);
            obj = url.openStream();
        }
        return ((InputStream) (obj));
    }

    public static void in(String s, byte abyte0[], int i)
        throws IOException
    {
        InputStream inputstream = jn(s);
        DataInputStream datainputstream = new DataInputStream(inputstream);
        try
        {
            datainputstream.readFully(abyte0, 0, i);
        }
        catch(EOFException _ex) { }
        datainputstream.close();
    }

    public static void co(byte abyte0[], int i, int j)
    {
        abyte0[i] = (byte)(j >> 24);
        abyte0[i + 1] = (byte)(j >> 16);
        abyte0[i + 2] = (byte)(j >> 8);
        abyte0[i + 3] = (byte)j;
    }

    public static void on(byte abyte0[], int i, long l)
    {
        abyte0[i] = (byte)(int)(l >> 56);
        abyte0[i + 1] = (byte)(int)(l >> 48);
        abyte0[i + 2] = (byte)(int)(l >> 40);
        abyte0[i + 3] = (byte)(int)(l >> 32);
        abyte0[i + 4] = (byte)(int)(l >> 24);
        abyte0[i + 5] = (byte)(int)(l >> 16);
        abyte0[i + 6] = (byte)(int)(l >> 8);
        abyte0[i + 7] = (byte)(int)l;
    }

    public static int wn(byte byte0)
    {
        return byte0 & 0xff;
    }

    public static int zn(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 8) + (abyte0[i + 1] & 0xff);
    }

    public static int yn(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    public static long rn(byte abyte0[], int i)
    {
        return (((long)yn(abyte0, i) & 0xffffffffL) << 32) + ((long)yn(abyte0, i + 4) & 0xffffffffL);
    }

    public static int bo(byte abyte0[], int i)
    {
        int j = wn(abyte0[i]) * 256 + wn(abyte0[i + 1]);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public static int un(byte abyte0[], int i, int j)
    {
        int k = i >> 3;
        int l = 8 - (i & 7);
        int i1 = 0;
        for(; j > l; l = 8)
        {
            i1 += (abyte0[k++] & rfb[l]) << j - l;
            j -= l;
        }

        if(j == l)
            i1 += abyte0[k] & rfb[l];
        else
            i1 += abyte0[k] >> l - j & rfb[j];
        return i1;
    }

    public static String _mthdo(String s, int i)
    {
        String s1 = "";
        for(int j = 0; j < i; j++)
            if(j >= s.length())
            {
                s1 = s1 + " ";
            } else
            {
                char c = s.charAt(j);
                if(c >= 'a' && c <= 'z')
                    s1 = s1 + c;
                else
                if(c >= 'A' && c <= 'Z')
                    s1 = s1 + c;
                else
                if(c >= '0' && c <= '9')
                    s1 = s1 + c;
                else
                    s1 = s1 + '_';
            }

        return s1;
    }

    public static long vn(String s)
    {
        s = s.trim();
        s = s.toLowerCase();
        long l = 0L;
        int i = 0;
        for(int j = 0; j < s.length(); j++)
        {
            char c = s.charAt(j);
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
            {
                char c1 = c;
                l = l * 47L * (l - (long)(c1 * 6) - (long)(i * 7));
                l += (c1 - 32) + i * c1;
                i++;
            }
        }

        return l;
    }

    public static long sn(String s)
    {
        String s1 = "";
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z')
                s1 = s1 + c;
            else
            if(c >= 'A' && c <= 'Z')
                s1 = s1 + (char)((c + 97) - 65);
            else
            if(c >= '0' && c <= '9')
                s1 = s1 + c;
            else
                s1 = s1 + ' ';
        }

        s1 = s1.trim();
        if(s1.length() > 12)
            s1 = s1.substring(0, 12);
        long l = 0L;
        for(int j = 0; j < s1.length(); j++)
        {
            char c1 = s1.charAt(j);
            l *= 37L;
            if(c1 >= 'a' && c1 <= 'z')
                l += (1 + c1) - 97;
            else
            if(c1 >= '0' && c1 <= '9')
                l += (27 + c1) - 48;
        }

        return l;
    }

    public static String xn(long l)
    {
        String s = "";
        while(l != 0L) 
        {
            int i = (int)(l % 37L);
            l /= 37L;
            if(i == 0)
                s = " " + s;
            else
            if(i < 27)
            {
                if(l % 37L == 0L)
                    s = (char)((i + 65) - 1) + s;
                else
                    s = (char)((i + 97) - 1) + s;
            } else
            {
                s = (char)((i + 48) - 27) + s;
            }
        }
        return s;
    }

    public static byte[] pn(String s)
        throws IOException
    {
        int i = 0;
        int j = 0;
        int k = 0;
        byte abyte0[] = null;
        while(i < 2) 
            try
            {
                if(i == 1)
                    s = s.toUpperCase();
                InputStream inputstream = jn(s);
                DataInputStream datainputstream = new DataInputStream(inputstream);
                byte abyte2[] = new byte[6];
                datainputstream.readFully(abyte2, 0, 6);
                j = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
                k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
                int l = 0;
                abyte0 = new byte[k];
                int i1;
                for(; l < k; l += i1)
                {
                    i1 = k - l;
                    if(i1 > 1000)
                        i1 = 1000;
                    datainputstream.readFully(abyte0, l, i1);
                }

                i = 2;
                datainputstream.close();
            }
            catch(IOException _ex)
            {
                i++;
            }
        if(k != j)
        {
            byte abyte1[] = new byte[j];
            n.ik(abyte1, j, abyte0, k, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public static int nn(String s, byte abyte0[])
    {
        int i = zn(abyte0, 0);
        int j = 0;
        s = s.toUpperCase();
        for(int k = 0; k < s.length(); k++)
            j = (j * 61 + s.charAt(k)) - 32;

        int l = 2 + i * 10;
        for(int i1 = 0; i1 < i; i1++)
        {
            int j1 = (abyte0[i1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[i1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 4] & 0xff) * 256 + (abyte0[i1 * 10 + 5] & 0xff);
            int k1 = (abyte0[i1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[i1 * 10 + 10] & 0xff) * 256 + (abyte0[i1 * 10 + 11] & 0xff);
            if(j1 == j)
                return l;
            l += k1;
        }

        return 0;
    }

    public static byte[] eo(String s, int i, byte abyte0[], byte abyte1[])
    {
        int j = abyte0[0] * 256 + abyte0[1];
        int k = 0;
        s = s.toUpperCase();
        for(int l = 0; l < s.length(); l++)
            k = (k * 61 + s.charAt(l)) - 32;

        int i1 = 2 + j * 10;
        for(int j1 = 0; j1 < j; j1++)
        {
            int k1 = (abyte0[j1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[j1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 4] & 0xff) * 256 + (abyte0[j1 * 10 + 5] & 0xff);
            int l1 = (abyte0[j1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 7] & 0xff) * 256 + (abyte0[j1 * 10 + 8] & 0xff);
            int i2 = (abyte0[j1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 10] & 0xff) * 256 + (abyte0[j1 * 10 + 11] & 0xff);
            if(k1 == k)
            {
                if(l1 != i2)
                {
                    n.ik(abyte1, l1, abyte0, i2, i1);
                } else
                {
                    for(int j2 = 0; j2 < l1; j2++)
                        abyte1[j2] = abyte0[i1 + j2];

                }
                return abyte1;
            }
            i1 += i2;
        }

        return null;
    }

    public static byte[] ln(String s, int i, byte abyte0[])
    {
        int j = zn(abyte0, 0);
        int k = 0;
        s = s.toUpperCase();
        for(int l = 0; l < s.length(); l++)
            k = (k * 61 + s.charAt(l)) - 32;

        int i1 = 2 + j * 10;
        for(int j1 = 0; j1 < j; j1++)
        {
            int k1 = (abyte0[j1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[j1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 4] & 0xff) * 256 + (abyte0[j1 * 10 + 5] & 0xff);
            int l1 = (abyte0[j1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 7] & 0xff) * 256 + (abyte0[j1 * 10 + 8] & 0xff);
            int i2 = (abyte0[j1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[j1 * 10 + 10] & 0xff) * 256 + (abyte0[j1 * 10 + 11] & 0xff);
            if(k1 == k)
            {
                byte abyte1[] = new byte[l1 + i];
                if(l1 != i2)
                {
                    n.ik(abyte1, l1, abyte0, i2, i1);
                } else
                {
                    for(int j2 = 0; j2 < l1; j2++)
                        abyte1[j2] = abyte0[i1 + j2];

                }
                return abyte1;
            }
            i1 += i2;
        }

        return null;
    }

    public static int mn(String s)
    {
        int i = 0;
        try
        {
            if(s.length() > 80)
                s = s.substring(0, 80);
            s = s.toLowerCase() + " ";
            if(s.startsWith("@red@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 0;
                s = s.substring(5);
            }
            if(s.startsWith("@gre@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 1;
                s = s.substring(5);
            }
            if(s.startsWith("@blu@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 2;
                s = s.substring(5);
            }
            if(s.startsWith("@cya@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 3;
                s = s.substring(5);
            }
            if(s.startsWith("@ran@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 4;
                s = s.substring(5);
            }
            if(s.startsWith("@whi@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 5;
                s = s.substring(5);
            }
            if(s.startsWith("@bla@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 6;
                s = s.substring(5);
            }
            if(s.startsWith("@ora@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 7;
                s = s.substring(5);
            }
            if(s.startsWith("@yel@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 8;
                s = s.substring(5);
            }
            if(s.startsWith("@mag@"))
            {
                wfb[i++] = -1;
                wfb[i++] = 9;
                s = s.substring(5);
            }
            String s1 = "";
            for(int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);
                if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '\'')
                {
                    s1 = s1 + c;
                } else
                {
                    int k = ao(c);
                    if(s1.length() > 0)
                    {
                        for(int l = 0; l < ufb; l++)
                        {
                            if(!s1.equals(vfb[l]))
                                continue;
                            if(k == 36 && l < 165)
                            {
                                wfb[i++] = (byte)(l + 90);
                                k = -1;
                            } else
                            if(k == 36)
                            {
                                wfb[i++] = (byte)(l / 256 + 50);
                                wfb[i++] = (byte)(l & 0xff);
                                k = -1;
                            } else
                            {
                                wfb[i++] = (byte)(l / 256 + 70);
                                wfb[i++] = (byte)(l & 0xff);
                            }
                            s1 = "";
                            break;
                        }

                    }
                    for(int i1 = 0; i1 < s1.length(); i1++)
                        wfb[i++] = (byte)ao(s1.charAt(i1));

                    s1 = "";
                    if(k != -1 && j < s.length() - 1)
                        wfb[i++] = (byte)k;
                }
            }

        }
        catch(Exception _ex) { }
        return i;
    }

    private static int ao(char c)
    {
        if(c >= 'a' && c <= 'z')
            return c - 97;
        if(c >= '0' && c <= '9')
            return (c + 26) - 48;
        if(c == ' ')
            return 36;
        if(c == '!')
            return 37;
        if(c == '?')
            return 38;
        if(c == '.')
            return 39;
        if(c == ',')
            return 40;
        if(c == ':')
            return 41;
        if(c == ';')
            return 42;
        if(c == '(')
            return 43;
        if(c == ')')
            return 44;
        if(c == '-')
            return 45;
        if(c == '&')
            return 46;
        if(c == '*')
            return 47;
        if(c == '\\')
            return 48;
        return c != '\'' ? 36 : 49;
    }

    public static String qn(byte abyte0[], int i, int j, boolean flag)
    {
        try
        {
            String s = "";
            String s1 = "";
            for(int k = i; k < i + j; k++)
            {
                int l = abyte0[k] & 0xff;
                if(l < 50)
                    s = s + yfb[l];
                else
                if(l < 70)
                {
                    k++;
                    s = s + vfb[(l - 50) * 256 + (abyte0[k] & 0xff)] + " ";
                } else
                if(l < 90)
                {
                    k++;
                    s = s + vfb[(l - 70) * 256 + (abyte0[k] & 0xff)];
                } else
                if(l < 255)
                {
                    s = s + vfb[l - 90] + " ";
                } else
                {
                    k++;
                    int i1 = abyte0[k] & 0xff;
                    if(i1 == 0)
                        s1 = "@red@";
                    if(i1 == 1)
                        s1 = "@gre@";
                    if(i1 == 2)
                        s1 = "@blu@";
                    if(i1 == 3)
                        s1 = "@cya@";
                    if(i1 == 4)
                        s1 = "@ran@";
                    if(i1 == 5)
                        s1 = "@whi@";
                    if(i1 == 6)
                        s1 = "@bla@";
                    if(i1 == 7)
                        s1 = "@ora@";
                    if(i1 == 8)
                        s1 = "@yel@";
                    if(i1 == 9)
                        s1 = "@mag@";
                }
            }

            if(flag)
            {
                for(int j1 = 0; j1 < 2; j1++)
                {
                    String s3 = s;
                    s = kn(s);
                    if(s.equals(s3))
                        break;
                }

            }
            if(s.length() > 80)
                s = s.substring(0, 80);
            s = s.toLowerCase();
            String s2 = s1;
            boolean flag1 = true;
            for(int k1 = 0; k1 < s.length(); k1++)
            {
                char c = s.charAt(k1);
                if(c >= 'a' && c <= 'z' && flag1)
                {
                    flag1 = false;
                    c = (char)((c + 65) - 97);
                }
                if(c == '.' || c == '!' || c == '?')
                    flag1 = true;
                s2 = s2 + c;
            }

            return s2;
        }
        catch(Exception _ex)
        {
            return "eep!";
        }
    }

    private static String kn(String s)
    {
        try
        {
            int i = s.length();
            s.toLowerCase().getChars(0, i, xfb, 0);
            for(int j = 0; j < i; j++)
            {
                char c = xfb[j];
                for(int k = 0; k < sfb; k++)
                {
                    String s1 = tfb[k];
                    char c1 = s1.charAt(0);
                    if(hn(c1, c, 0))
                    {
                        int l = 1;
                        int i1 = s1.length();
                        char c2 = s1.charAt(1);
                        int j1 = 0;
                        if(i1 >= 6)
                            j1 = 1;
                        for(int k1 = j + 1; k1 < i; k1++)
                        {
                            char c3 = xfb[k1];
                            if(hn(c2, c3, i1))
                            {
                                if(++l >= i1)
                                {
                                    boolean flag = false;
                                    for(int l1 = j; l1 <= k1; l1++)
                                    {
                                        if(s.charAt(l1) < 'A' || s.charAt(l1) > 'Z')
                                            continue;
                                        flag = true;
                                        break;
                                    }

                                    if(flag)
                                    {
                                        String s2 = "";
                                        for(int i2 = 0; i2 < s.length(); i2++)
                                            if(i2 >= j && i2 <= k1)
                                                s2 = s2 + "*";
                                            else
                                                s2 = s2 + s.charAt(i2);

                                        s = s2;
                                    }
                                    break;
                                }
                                c1 = c2;
                                c2 = s1.charAt(l);
                                continue;
                            }
                            if(!tn(c1, c3, i1) && --j1 < 0)
                                break;
                        }

                    }
                }

            }

            return s;
        }
        catch(Exception _ex)
        {
            return "wibble!";
        }
    }

    private static boolean hn(char c, char c1, int i)
    {
        if(c == c1)
            return true;
        if(c == 'i' && (c1 == 'y' || c1 == '1' || c1 == '!' || c1 == ':' || c1 == ';'))
            return true;
        if(c == 's' && (c1 == '5' || c1 == 'z'))
            return true;
        if(c == 'e' && c1 == '3')
            return true;
        if(c == 'a' && c1 == '4')
            return true;
        if(c == 'o' && (c1 == '0' || c1 == '*'))
            return true;
        if(c == 'u' && c1 == 'v')
            return true;
        if(c == 'c' && (c1 == '(' || c1 == 'k'))
            return true;
        if(c == 'k' && (c1 == '(' || c1 == 'c'))
            return true;
        if(c == 'w' && c1 == 'v')
            return true;
        return i >= 4 && c == 'i' && c1 == 'l';
    }

    private static boolean tn(char c, char c1, int i)
    {
        if(c == c1)
            return true;
        if(c1 < 'a' || c1 > 'u' && c1 != 'y')
            return true;
        if(c == 'i' && c1 == 'y')
            return true;
        if(c == 'c' && c1 == 'k')
            return true;
        if(c == 'k' && c1 == 'c')
            return true;
        return i >= 5 && (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') && (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u' || c1 == 'y');
    }

    public o()
    {
    }

    public static URL qfb = null;
    private static int rfb[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    public static int sfb = 1;
    public static String tfb[] = {
        "bum"
    };
    public static int ufb = 1;
    public static String vfb[] = {
        "hello"
    };
    public static byte wfb[] = new byte[200];
    static char xfb[] = new char[1000];
    private static char yfb[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', 
        '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', 
        ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\''
    };

}
