// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.math.BigInteger;
import java.util.zip.CRC32;

public class dbh
{

    private dbh()
    {
    }

    public dbh(byte abyte0[])
    {
        dbi = abyte0;
        dbj = 0;
    }

    public void dbm(int i)
    {
        dbi[dbj++] = (byte)i;
    }

    public void dbn(int i)
    {
        dbi[dbj++] = (byte)(i >> 24);
        dbi[dbj++] = (byte)(i >> 16);
        dbi[dbj++] = (byte)(i >> 8);
        dbi[dbj++] = (byte)i;
    }

    public void dca(String s)
    {
        s.getBytes(0, s.length(), dbi, dbj);
        dbj += s.length();
        dbi[dbj++] = 10;
    }

    public void dcb(byte abyte0[], int i, int j)
    {
        for(int k = i; k < i + j; k++)
            dbi[dbj++] = abyte0[k];

    }

    public int dcc()
    {
        return dbi[dbj++] & 0xff;
    }

    public int dcd()
    {
        dbj += 2;
        return ((dbi[dbj - 2] & 0xff) << 8) + (dbi[dbj - 1] & 0xff);
    }

    public int dce()
    {
        dbj += 4;
        return ((dbi[dbj - 4] & 0xff) << 24) + ((dbi[dbj - 3] & 0xff) << 16) + ((dbi[dbj - 2] & 0xff) << 8) + (dbi[dbj - 1] & 0xff);
    }

    public void dcf(byte abyte0[], int i, int j)
    {
        for(int k = i; k < i + j; k++)
            abyte0[k] = dbi[dbj++];

    }

    public void dcg(BigInteger biginteger, BigInteger biginteger1)
    {
        int i = dbj;
        dbj = 0;
        byte abyte0[] = new byte[i];
        dcf(abyte0, 0, i);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        dbj = 0;
        dbm(abyte1.length);
        dcb(abyte1, 0, abyte1.length);
    }

    public byte dbi[];
    public int dbj;
    static CRC32 dbk = new CRC32();
    private static final int dbl[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };

}
