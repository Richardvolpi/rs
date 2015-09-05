// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.math.BigInteger;
import java.util.zip.CRC32;

public class Class13 {

    public Class13() {
    }

    public Class13(byte abyte0[]) {
        aByteArray520 = abyte0;
        anInt521 = 0;
    }

    public void method318(int i) {
        aByteArray520[anInt521++] = (byte)i;
    }

    public void method319(int i) {
        aByteArray520[anInt521++] = (byte)(i >> 24);
        aByteArray520[anInt521++] = (byte)(i >> 16);
        aByteArray520[anInt521++] = (byte)(i >> 8);
        aByteArray520[anInt521++] = (byte)i;
    }

    public void method320(String s) {
        s.getBytes(0, s.length(), aByteArray520, anInt521);
        anInt521 += s.length();
        aByteArray520[anInt521++] = 10;
    }

    public void method321(byte abyte0[], int i, int j) {
        for(int k = i; k < i + j; k++)
            aByteArray520[anInt521++] = abyte0[k];

    }

    public int method322() {
        return aByteArray520[anInt521++] & 0xff;
    }

    public int method323() {
        anInt521 += 2;
        return ((aByteArray520[anInt521 - 2] & 0xff) << 8) + (aByteArray520[anInt521 - 1] & 0xff);
    }

    public int method324() {
        anInt521 += 4;
        return ((aByteArray520[anInt521 - 4] & 0xff) << 24) + ((aByteArray520[anInt521 - 3] & 0xff) << 16) + ((aByteArray520[anInt521 - 2] & 0xff) << 8) + (aByteArray520[anInt521 - 1] & 0xff);
    }

    public void method325(byte abyte0[], int i, int j) {
        for(int k = i; k < i + j; k++)
            abyte0[k] = aByteArray520[anInt521++];

    }

    public void method326(BigInteger biginteger, BigInteger biginteger1) {
        int i = anInt521;
        anInt521 = 0;
        byte abyte0[] = new byte[i];
        method325(abyte0, 0, i);
        BigInteger biginteger2 = new BigInteger(abyte0);
        BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        anInt521 = 0;
        method318(abyte1.length);
        method321(abyte1, 0, abyte1.length);
    }

    public byte aByteArray520[];
    public int anInt521;
    public static CRC32 aCRC32_522 = new CRC32();
    public static int anIntArray523[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };

}
