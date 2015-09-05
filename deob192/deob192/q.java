// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:02 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.math.BigInteger;
import java.util.zip.CRC32;

public class q
{

    private q()
    {
    }

    public q(byte arg0[])
    {
        aed = arg0;
        aee = 0;
    }

    public void adk(int arg0)
    {
        aed[aee++] = (byte)arg0;
    }

    public void adl(int arg0)
    {
        aed[aee++] = (byte)(arg0 >> 24);
        aed[aee++] = (byte)(arg0 >> 16);
        aed[aee++] = (byte)(arg0 >> 8);
        aed[aee++] = (byte)arg0;
    }

    public void adm(String arg0)
    {
        arg0.getBytes(0, arg0.length(), aed, aee);
        aee += arg0.length();
        aed[aee++] = 10;
    }

    public void adn(byte arg0[], int arg1, int arg2)
    {
        for(int i = arg1; i < arg1 + arg2; i++)
            aed[aee++] = arg0[i];

    }

    public int aea()
    {
        return aed[aee++] & 0xff;
    }

    public int aeb()
    {
        aee += 2;
        return ((aed[aee - 2] & 0xff) << 8) + (aed[aee - 1] & 0xff);
    }

    public int aec()
    {
        aee += 4;
        return ((aed[aee - 4] & 0xff) << 24) + ((aed[aee - 3] & 0xff) << 16) + ((aed[aee - 2] & 0xff) << 8) + (aed[aee - 1] & 0xff);
    }

    public void aed(byte arg0[], int arg1, int arg2)
    {
        for(int i = arg1; i < arg1 + arg2; i++)
            arg0[i] = aed[aee++];

    }

    public void aee(BigInteger arg0, BigInteger arg1)
    {
        int i = aee;
        aee = 0;
        byte abyte0[] = new byte[i];
        aed(abyte0, 0, i);
        BigInteger biginteger = new BigInteger(abyte0);
        BigInteger biginteger1 = biginteger.modPow(arg0, arg1);
        byte abyte1[] = biginteger1.toByteArray();
        aee = 0;
        adk(abyte1.length);
        adn(abyte1, 0, abyte1.length);
    }

    public byte aed[];
    public int aee;
    static CRC32 aef = new CRC32();
    private static final int aeg[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };

}