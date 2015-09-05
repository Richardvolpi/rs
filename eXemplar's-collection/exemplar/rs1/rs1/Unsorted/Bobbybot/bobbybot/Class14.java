// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.io.IOException;

public class Class14 {

    public void method327(int ai[]) {
        aClass12_544 = new Class12(ai);
        aClass12_545 = new Class12(ai);
    }

    public void method328() {
    }

    public void method329(int i, byte abyte0[]) throws IOException {
        method339(i, 0, abyte0);
    }

    public void method330() {
        if(aClass12_545 != null) {
            int i = aByteArray530[anInt527 + 2] & 0xff;
            aByteArray530[anInt527 + 2] = (byte)(i + aClass12_545.method315());
        }
        if(anInt529 != 8)
            anInt528++;
        int j = anInt528 - anInt527 - 2;
        if(j >= 160) {
            aByteArray530[anInt527] = (byte)(160 + j / 256);
            aByteArray530[anInt527 + 1] = (byte)(j & 0xff);
        } else {
            aByteArray530[anInt527] = (byte)j;
            anInt528--;
            aByteArray530[anInt527 + 1] = aByteArray530[anInt528];
        }
        if(anInt549 <= 10000) {
            int k = aByteArray530[anInt527 + 2] & 0xff;
            anIntArray547[k]++;
            anIntArray551[k] += anInt528 - anInt527;
        }
        anInt527 = anInt528;
    }

    public void method331(int i) {
        aByteArray530[anInt528++] = (byte)i;
    }

    public int method332(int i) {
        return i - aClass12_544.method315() & 0xff;
    }

    public void method333(long l) {
        method334((int)(l >> 32));
        method334((int)(l & -1L));
    }

    public void method334(int i) {
        aByteArray530[anInt528++] = (byte)(i >> 24);
        aByteArray530[anInt528++] = (byte)(i >> 16);
        aByteArray530[anInt528++] = (byte)(i >> 8);
        aByteArray530[anInt528++] = (byte)i;
    }

    public boolean method335() {
        return anInt527 > 0;
    }

    public void method336(int i) {
        aByteArray530[anInt528++] = (byte)(i >> 8);
        aByteArray530[anInt528++] = (byte)i;
    }

    public int method337() throws IOException {
        return method349();
    }

    public int method338(byte abyte0[]) {
        try {
            anInt525++;
            if(anInt526 > 0 && anInt525 > anInt526) {
                aBoolean552 = true;
                aString548 = "time-out";
                anInt526 += anInt526;
                return 0;
            }
            if(anInt524 == 0 && method340() >= 2) {
                anInt524 = method349();
                if(anInt524 >= 160)
                    anInt524 = (anInt524 - 160) * 256 + method349();
            }
            if(anInt524 > 0 && method340() >= anInt524) {
                if(anInt524 >= 160) {
                    method329(anInt524, abyte0);
                } else {
                    abyte0[anInt524 - 1] = (byte)method349();
                    if(anInt524 > 1)
                        method329(anInt524 - 1, abyte0);
                }
                int i = anInt524;
                anInt524 = 0;
                anInt525 = 0;
                return i;
            }
        }
        catch(IOException ioexception) {
            aBoolean552 = true;
            aString548 = ioexception.getMessage();
        }
        return 0;
    }

    public void method339(int i, int j, byte abyte0[]) throws IOException {
    }

    public int method340() throws IOException {
        return 0;
    }

    public void method341() throws IOException {
        method330();
        method345(0);
    }

    public long method342() throws IOException {
        long l = method343();
        long l1 = method343();
        long l2 = method343();
        long l3 = method343();
        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }

    public int method343() throws IOException {
        int i = method337();
        int j = method337();
        return i * 256 + j;
    }

    public void method344(byte abyte0[], int i, int j) {
        for(int k = 0; k < j; k++)
            aByteArray530[anInt528++] = abyte0[i + k];

    }

    public void method345(int i) throws IOException {
        if(aBoolean552) {
            anInt527 = 0;
            anInt528 = 3;
            aBoolean552 = false;
            throw new IOException(aString548);
        }
        anInt550++;
        if(anInt550 < i)
            return;
        if(anInt527 > 0) {
            anInt550 = 0;
            method347(aByteArray530, 0, anInt527);
        }
        anInt527 = 0;
        anInt528 = 3;
    }

    public void method346(String s) {
        s.getBytes(0, s.length(), aByteArray530, anInt528);
        anInt528 += s.length();
    }

    public void method347(byte abyte0[], int i, int j) throws IOException {
    }

    public void method348(int i) {
        if(anInt527 > (anInt549 * 4) / 5)
            try {
                method345(0);
            }
            catch(IOException ioexception) {
                aBoolean552 = true;
                aString548 = ioexception.getMessage();
            }
        if(aByteArray530 == null)
            aByteArray530 = new byte[anInt549];
        aByteArray530[anInt527 + 2] = (byte)i;
        aByteArray530[anInt527 + 3] = 0;
        anInt528 = anInt527 + 3;
        anInt529 = 8;
    }

    public int method349() throws IOException {
        return 0;
    }

    public Class14() {
        anInt528 = 3;
        anInt529 = 8;
        anInt532 = 61;
        anInt533 = 59;
        anInt534 = 42;
        anInt535 = 43;
        anInt536 = 44;
        anInt537 = 45;
        anInt538 = 46;
        anInt539 = 47;
        anInt540 = 92;
        anInt541 = 32;
        anInt542 = 124;
        anInt543 = 34;
        aString548 = "";
        anInt549 = 5000;
        aBoolean552 = false;
    }

    public int anInt524;
    public int anInt525;
    public int anInt526;
    public int anInt527;
    public int anInt528;
    public int anInt529;
    public byte aByteArray530[];
    public static int anIntArray531[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    public int anInt532 = 61;
    public int anInt533 = 59;
    public int anInt534 = 42;
    public int anInt535 = 43;
    public int anInt536 = 44;
    public int anInt537 = 45;
    public int anInt538 = 46;
    public int anInt539 = 47;
    public int anInt540 = 92;
    public int anInt541 = 32;
    public int anInt542 = 124;
    public int anInt543 = 34;
    public Class12 aClass12_544;
    public Class12 aClass12_545;
    public static char aCharArray546[];
    public static int anIntArray547[] = new int[256];
    public String aString548;
    public int anInt549;
    public int anInt550;
    public static int anIntArray551[] = new int[256];
    public boolean aBoolean552;
    public static int anInt553;

    static  {
        aCharArray546 = new char[256];
        for(int i = 0; i < 256; i++)
            aCharArray546[i] = (char)i;

        aCharArray546[61] = '=';
        aCharArray546[59] = ';';
        aCharArray546[42] = '*';
        aCharArray546[43] = '+';
        aCharArray546[44] = ',';
        aCharArray546[45] = '-';
        aCharArray546[46] = '.';
        aCharArray546[47] = '/';
        aCharArray546[92] = '\\';
        aCharArray546[124] = '|';
        aCharArray546[33] = '!';
        aCharArray546[34] = '"';
    }
}
