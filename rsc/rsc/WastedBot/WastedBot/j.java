// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   j.java

import java.math.BigInteger;
import java.util.zip.CRC32;

public class j
{

    private j()
    {
    }

    public j(byte abyte0[])
    {
        a = abyte0;
        c = 0;
    }

    public void a(int i)
    {
        a[c++] = (byte)i;
    }

    public void b(int i)
    {
        a[c++] = (byte)(i >> 24);
        a[c++] = (byte)(i >> 16);
        a[c++] = (byte)(i >> 8);
        a[c++] = (byte)i;
    }

    public void a(String s)
    {
        s.getBytes(0, s.length(), a, c);
        c += s.length();
        a[c++] = 10;
    }

    public void a(byte abyte0[], int i, int k)
    {
        int l = i;
        do
        {
            if(l >= i + k)
                break;
            a[c++] = abyte0[l];
            l++;
        } while(!v.R);
    }

    public int a()
    {
        return a[c++] & 0xff;
    }

    public int b()
    {
        c += 2;
        return ((a[c - 2] & 0xff) << 8) + (a[c - 1] & 0xff);
    }

    public int c()
    {
        c += 4;
        return ((a[c - 4] & 0xff) << 24) + ((a[c - 3] & 0xff) << 16) + ((a[c - 2] & 0xff) << 8) + (a[c - 1] & 0xff);
    }

    public void b(byte abyte0[], int i, int k)
    {
        int l = i;
        do
        {
            if(l >= i + k)
                break;
            abyte0[l] = a[c++];
            l++;
        } while(!v.R);
    }

    public void a(BigInteger biginteger, BigInteger biginteger1)
    {
        int i = c;
        c = 0;
        byte abyte0[] = new byte[i];
        b(abyte0, 0, i);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        c = 0;
        a(abyte1.length);
        a(abyte1, 0, abyte1.length);
    }

    public byte a[];
    static CRC32 b = new CRC32();
    public int c;
    private static final int d[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };

}
