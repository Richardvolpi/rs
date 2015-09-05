 

import java.io.IOException;

public class Class14
{

    public Class14()
    {
        super();
        int i = anInt553;
        anInt528 = 3;
        anInt529 = 8;
        anInt548 = 5000;
        aBoolean551 = false;
        aString552 = "";
        if(Class15.aBoolean556)
            anInt553 = ++i;
    }

    public void method328(int ai[])
    {
        aClass12_544 = new Class12(ai);
        aClass12_545 = new Class12(ai);
    }

    public void method329()
    {
    }

    public int method330()
        throws IOException
    {
        return method338();
    }

    public void packetID(int i)
    {
        if(anInt527 > (anInt548 * 4) / 5)
            try
            {
                method341(0);
            }
            catch(IOException ioexception)
            {
                aBoolean551 = true;
                aString552 = ioexception.getMessage();
            }
        if(aByteArray530 == null)
            aByteArray530 = new byte[anInt548];
        aByteArray530[anInt527 + 2] = (byte)i;
        aByteArray530[anInt527 + 3] = 0;
        anInt528 = anInt527 + 3;
        anInt529 = 8;
    }

    public void method332(int i)
    {
        aByteArray530[anInt528++] = (byte)(i >> 24);
        aByteArray530[anInt528++] = (byte)(i >> 16);
        aByteArray530[anInt528++] = (byte)(i >> 8);
        aByteArray530[anInt528++] = (byte)i;
    }

    public long method333()
        throws IOException
    {
        long l = method339();
        long l1 = method339();
        long l2 = method339();
        long l3 = method339();
        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }

    public int method334(byte abyte0[])
    {
        try
        {
            anInt525++;
            if(anInt526 > 0 && anInt525 > anInt526)
            {
                aBoolean551 = true;
                aString552 = "time-out";
                anInt526 += anInt526;
                return 0;
            }
            if(anInt524 == 0 && method337() >= 2)
            {
                anInt524 = method338();
                if(anInt524 >= 160)
                    anInt524 = (anInt524 - 160) * 256 + method338();
            }
            if(anInt524 > 0 && method337() >= anInt524)
            {
                if(anInt524 >= 160)
                {
                    method349(anInt524, abyte0);
                } else
                {
                    abyte0[anInt524 - 1] = (byte)method338();
                    if(anInt524 > 1)
                        method349(anInt524 - 1, abyte0);
                }
                int i = anInt524;
                anInt524 = 0;
                anInt525 = 0;
                return i;
            }
        }
        catch(IOException ioexception)
        {
            aBoolean551 = true;
            aString552 = ioexception.getMessage();
        }
        return 0;
    }

    public boolean method335()
    {
        return anInt527 > 0;
    }

    public void method336(byte abyte0[], int i, int j)
    {
        for(int k = 0; k < j; k++)
            aByteArray530[anInt528++] = abyte0[i + k];

    }

    public int method337()
        throws IOException
    {
        return 0;
    }

    public int method338()
        throws IOException
    {
        return 0;
    }

    public int method339()
        throws IOException
    {
        int i = method330();
        int j = method330();
        return i * 256 + j;
    }

    public int method340(int i)
    {
        return i - aClass12_544.method316() & 0xff;
    }

    public void method341(int i)
        throws IOException
    {
        if(aBoolean551)
        {
            anInt527 = 0;
            anInt528 = 3;
            aBoolean551 = false;
            throw new IOException(aString552);
        }
        anInt549++;
        if(anInt549 < i)
            return;
        if(anInt527 > 0)
        {
            anInt549 = 0;
            method345(aByteArray530, 0, anInt527);
        }
        anInt527 = 0;
        anInt528 = 3;
    }

    public void method342(long l)
    {
        method332((int)(l >> 32));
        method332((int)(l & -1L));
    }

    public void variables343(int i)
    {
        aByteArray530[anInt528++] = (byte)(i >> 8);
        aByteArray530[anInt528++] = (byte)i;
    }

    public void method344()
        throws IOException
    {
        sendpacket();
        method341(0);
    }

    public void method345(byte abyte0[], int i, int j)
        throws IOException
    {
    }

    public void sendpacket()
    {
        if(aClass12_545 != null)
        {
            int i = aByteArray530[anInt527 + 2] & 0xff;
            aByteArray530[anInt527 + 2] = (byte)(i + aClass12_545.method316());
        }
        if(anInt529 != 8)
            anInt528++;
        int j = anInt528 - anInt527 - 2;
        if(j >= 160)
        {
            aByteArray530[anInt527] = (byte)(160 + j / 256);
            aByteArray530[anInt527 + 1] = (byte)(j & 0xff);
        } else
        {
            aByteArray530[anInt527] = (byte)j;
            anInt528--;
            aByteArray530[anInt527 + 1] = aByteArray530[anInt528];
        }
        if(anInt548 <= 10000)
        {
            int k = aByteArray530[anInt527 + 2] & 0xff;
            anIntArray547[k]++;
            anIntArray550[k] += anInt528 - anInt527;
        }
        anInt527 = anInt528;
    }

    public void method347(String s)
    {
        s.getBytes(0, s.length(), aByteArray530, anInt528);
        anInt528 += s.length();
    }

    public void variables348(int i)
    {
        aByteArray530[anInt528++] = (byte)i;
    }

    public void method349(int i, byte abyte0[])
        throws IOException
    {
        method350(i, 0, abyte0);
    }

    public void method350(int i, int j, byte abyte0[])
        throws IOException
    {
    }

    protected boolean aBoolean551;
    public byte aByteArray530[];
    static char aCharArray546[];
    public Class12 aClass12_544;
    public Class12 aClass12_545;
    protected String aString552;
    protected int anInt524;
    public int anInt525;
    public int anInt526;
    public int anInt527;
    private int anInt528;
    private int anInt529;
    final int anInt532 = 61;
    final int anInt533 = 59;
    final int anInt534 = 42;
    final int anInt535 = 43;
    final int anInt536 = 44;
    final int anInt537 = 45;
    final int anInt538 = 46;
    final int anInt539 = 47;
    final int anInt540 = 92;
    final int anInt541 = 32;
    final int anInt542 = 124;
    final int anInt543 = 34;
    protected int anInt548;
    protected int anInt549;
    public static int anInt553;
    private static int anIntArray531[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    public static int anIntArray547[] = new int[256];
    public static int anIntArray550[] = new int[256];

    static 
    {
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
