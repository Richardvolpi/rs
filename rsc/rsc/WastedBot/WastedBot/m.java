// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   m.java

import java.io.*;
import java.net.URL;

public class m
{

    public static InputStream a(String s1)
        throws IOException
    {
        Object obj;
        if(c == null)
        {
            obj = new BufferedInputStream(new FileInputStream(s1));
        } else
        {
            URL url = new URL(c, s1);
            obj = url.openStream();
        }
        return (InputStream)obj;
    }

    public static void a(String s1, byte abyte0[], int i)
        throws IOException
    {
        InputStream inputstream = a(s1);
        DataInputStream datainputstream = new DataInputStream(inputstream);
        try
        {
            datainputstream.readFully(abyte0, 0, i);
        }
        catch(EOFException eofexception) { }
        datainputstream.close();
    }

    public static int a(byte byte0)
    {
        return byte0 & 0xff;
    }

    public static int a(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 8) + (abyte0[i + 1] & 0xff);
    }

    public static int b(byte abyte0[], int i)
    {
        return ((abyte0[i] & 0xff) << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    public static long c(byte abyte0[], int i)
    {
        return (((long)b(abyte0, i) & 0xffffffffL) << 32) + ((long)b(abyte0, i + 4) & 0xffffffffL);
    }

    public static int d(byte abyte0[], int i)
    {
        int j = a(abyte0[i]) * 256 + a(abyte0[i + 1]);
        if(j > 32767)
            j -= 0x10000;
        return j;
    }

    public static int e(byte abyte0[], int i)
    {
        if((abyte0[i] & 0xff) < 128)
            return abyte0[i];
        else
            return ((abyte0[i] & 0xff) - 128 << 24) + ((abyte0[i + 1] & 0xff) << 16) + ((abyte0[i + 2] & 0xff) << 8) + (abyte0[i + 3] & 0xff);
    }

    public static int a(byte abyte0[], int i, int j)
    {
        int l = k.A;
        int i1 = i >> 3;
        int j1 = 8 - (i & 7);
        int k1 = 0;
        for(; j > j1; j1 = 8)
        {
            k1 += (abyte0[i1++] & b[j1]) << j - j1;
            j -= j1;
        }

        if(j == j1)
            k1 += abyte0[i1] & b[j1];
        else
            k1 += abyte0[i1] >> j1 - j & b[j];
        return k1;
    }

    public static String a(String s1, int i)
    {
        int j = k.A;
        String s2 = "";
        for(int l = 0; l < i; l++)
        {
            if(l >= s1.length())
            {
                s2 = s2 + " ";
                continue;
            }
            char c1 = s1.charAt(l);
            if(c1 >= 'a' && c1 <= 'z')
            {
                s2 = s2 + c1;
                continue;
            }
            if(c1 >= 'A' && c1 <= 'Z')
            {
                s2 = s2 + c1;
                continue;
            }
            if(c1 >= '0' && c1 <= '9')
                s2 = s2 + c1;
            else
                s2 = s2 + '_';
        }

        return s2;
    }

    public static long b(String s1)
    {
        int i = k.A;
        String s2 = "";
        for(int j = 0; j < s1.length(); j++)
        {
            char c1 = s1.charAt(j);
            if(c1 >= 'a' && c1 <= 'z')
            {
                s2 = s2 + c1;
                continue;
            }
            if(c1 >= 'A' && c1 <= 'Z')
            {
                s2 = s2 + (char)((c1 + 97) - 65);
                continue;
            }
            if(c1 >= '0' && c1 <= '9')
                s2 = s2 + c1;
            else
                s2 = s2 + ' ';
        }

        s2 = s2.trim();
        if(s2.length() > 12)
            s2 = s2.substring(0, 12);
        long l = 0L;
        for(int i1 = 0; i1 < s2.length(); i1++)
        {
            char c2 = s2.charAt(i1);
            l *= 37L;
            if(c2 >= 'a' && c2 <= 'z')
            {
                l += (1 + c2) - 97;
                continue;
            }
            if(c2 >= '0' && c2 <= '9')
                l += (27 + c2) - 48;
        }

        return l;
    }

    public static String a(long l)
    {
        int i = k.A;
        if(l < 0L)
            return z;
        String s1 = "";
        while(l != 0L) 
        {
            int j = (int)(l % 37L);
            l /= 37L;
            if(j == 0)
                s1 = " " + s1;
            else
            if(j < 27)
            {
                if(l % 37L == 0L)
                    s1 = (char)((j + 65) - 1) + s1;
                else
                    s1 = (char)((j + 97) - 1) + s1;
            } else
            {
                s1 = (char)((j + 48) - 27) + s1;
            }
        }
        return s1;
    }

    public static int a(String s1, byte abyte0[])
    {
        int i = k.A;
        int j = a(abyte0, 0);
        int l = 0;
        s1 = s1.toUpperCase();
        for(int i1 = 0; i1 < s1.length(); i1++)
            l = (l * 61 + s1.charAt(i1)) - 32;

        int j1 = 2 + j * 10;
        for(int k1 = 0; k1 < j; k1++)
        {
            int l1 = (abyte0[k1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[k1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 4] & 0xff) * 256 + (abyte0[k1 * 10 + 5] & 0xff);
            int i2 = (abyte0[k1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 10] & 0xff) * 256 + (abyte0[k1 * 10 + 11] & 0xff);
            if(l1 == l)
                return j1;
            j1 += i2;
        }

        return 0;
    }

    public static int b(String s1, byte abyte0[])
    {
        int i = k.A;
        int j = a(abyte0, 0);
        int l = 0;
        s1 = s1.toUpperCase();
        for(int i1 = 0; i1 < s1.length(); i1++)
            l = (l * 61 + s1.charAt(i1)) - 32;

        int j1 = 2 + j * 10;
        for(int k1 = 0; k1 < j; k1++)
        {
            int l1 = (abyte0[k1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[k1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 4] & 0xff) * 256 + (abyte0[k1 * 10 + 5] & 0xff);
            int i2 = (abyte0[k1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 7] & 0xff) * 256 + (abyte0[k1 * 10 + 8] & 0xff);
            int j2 = (abyte0[k1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 10] & 0xff) * 256 + (abyte0[k1 * 10 + 11] & 0xff);
            if(l1 == l)
                return i2;
            j1 += j2;
        }

        return 0;
    }

    public static byte[] a(String s1, int i, byte abyte0[])
    {
        return a(s1, i, abyte0, null);
    }

    public static byte[] a(String s1, int i, byte abyte0[], byte abyte1[])
    {
        boolean flag = v.R;
        int j = k.A;
        int l = (abyte0[0] & 0xff) * 256 + (abyte0[1] & 0xff);
        int i1 = 0;
        s1 = s1.toUpperCase();
        int j1 = 0;
        do
        {
            if(j1 >= s1.length())
                break;
            i1 = (i1 * 61 + s1.charAt(j1)) - 32;
            j1++;
        } while(!flag);
        j1 = 2 + l * 10;
        int k1 = 0;
label0:
        do
        {
            int j2;
label1:
            {
label2:
                {
                    if(k1 >= l)
                        break label0;
                    int l1 = (abyte0[k1 * 10 + 2] & 0xff) * 0x1000000 + (abyte0[k1 * 10 + 3] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 4] & 0xff) * 256 + (abyte0[k1 * 10 + 5] & 0xff);
                    int i2 = (abyte0[k1 * 10 + 6] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 7] & 0xff) * 256 + (abyte0[k1 * 10 + 8] & 0xff);
                    j2 = (abyte0[k1 * 10 + 9] & 0xff) * 0x10000 + (abyte0[k1 * 10 + 10] & 0xff) * 256 + (abyte0[k1 * 10 + 11] & 0xff);
                    if(l1 != i1)
                        break label1;
                    if(abyte1 == null)
                        abyte1 = new byte[i2 + i];
                    if(i2 != j2)
                    {
                        s.a(abyte1, i2, abyte0, j2, j1);
                        if(!flag)
                            break label2;
                    }
                    int k2 = 0;
                    do
                    {
                        if(k2 >= i2)
                            break;
                        abyte1[k2] = abyte0[j1 + k2];
                        k2++;
                    } while(!flag);
                }
                return abyte1;
            }
            j1 += j2;
            k1++;
        } while(!flag);
        return null;
    }

    public static boolean a;
    private static int b[];
    public static URL c;
    private static String z;

    static 
    {
        z = "D\035b\fND\027K\003C@\026";
        break MISSING_BLOCK_LABEL_123;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i % 5)
        {
        case 0: // '\0'
            byte0 = 0x2d;
            break;

        case 1: // '\001'
            byte0 = 115;
            break;

        case 2: // '\002'
            byte0 = 20;
            break;

        case 3: // '\003'
            byte0 = 109;
            break;

        default:
            byte0 = 34;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 26;
           goto _L5 _L1
_L5:
        JVM INSTR new #108 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        b = (new int[] {
            0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
            1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
            0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
            0x3fffffff, 0x7fffffff, -1
        });
        c = null;
    }
}
