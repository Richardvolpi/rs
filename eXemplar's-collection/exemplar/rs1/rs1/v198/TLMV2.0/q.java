/*
 * deobfuscatorzed by saevion
 * thanks to the apache-jarkarta group for
 * the bcel and regexp libraries
 * decompiled by JAD
 */

import java.math.BigInteger;
import java.util.zip.CRC32;

public class q
{

    private q()
    {
    }

    public q(byte abyte0[])
    {
        daj = abyte0;
        dak = 0;
    }

    public void dan(int i)
    {
        daj[dak++] = (byte)i;
    }

    public void dba(int i)
    {
        daj[dak++] = (byte)(i >> 24);
        daj[dak++] = (byte)(i >> 16);
        daj[dak++] = (byte)(i >> 8);
        daj[dak++] = (byte)i;
    }

    public void dbb(String s)
    {
        s.getBytes(0, s.length(), daj, dak);
        dak += s.length();
        daj[dak++] = 10;
    }

    public void dbc(byte arg0[], int arg1, int arg2)
    {
        for(int i = arg1; i < arg1 + arg2; i++)
            daj[dak++] = arg0[i];

    }

    public int dbd()
    {
        return daj[dak++] & 0xff;
    }

    public int dbe()
    {
        dak += 2;
        return ((daj[dak - 2] & 0xff) << 8) + (daj[dak - 1] & 0xff);
    }

    public int dbf()
    {
        dak += 4;
        return ((daj[dak - 4] & 0xff) << 24) + ((daj[dak - 3] & 0xff) << 16) + ((daj[dak - 2] & 0xff) << 8) + (daj[dak - 1] & 0xff);
    }

    public void dbg(byte arg0[], int arg1, int arg2)
    {
        for(int i = arg1; i < arg1 + arg2; i++)
            arg0[i] = daj[dak++];

    }

    public void dbh(BigInteger biginteger, BigInteger biginteger1)
    {
        int i = dak;
        dak = 0;
        byte abyte0[] = new byte[i];
        dbg(abyte0, 0, i);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        dak = 0;
        dan(abyte1.length);
        dbc(abyte1, 0, abyte1.length);
    }

    public byte daj[];
    public int dak;
    static CRC32 dal = new CRC32();
    private static final int dam[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };

}
