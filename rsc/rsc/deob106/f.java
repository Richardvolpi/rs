// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex;

import java.io.*;
import java.math.BigInteger;
import java.net.*;

// Referenced classes of package jagex:
//            o

public class f
{

    public f(InputStream inputstream)
    {
        ud = false;
        xd = false;
        yd = "";
        qd = inputstream;
    }

    public f(Socket socket)
        throws IOException
    {
        ud = false;
        xd = false;
        yd = "";
        sd = socket;
        qd = socket.getInputStream();
        rd = socket.getOutputStream();
    }

    public f(String s)
        throws IOException
    {
        ud = false;
        xd = false;
        yd = "";
        qd = o.jn(s);
    }

    public f(byte abyte0[])
    {
        ud = false;
        xd = false;
        yd = "";
        vd = abyte0;
        wd = 0;
        ud = true;
    }

    public f(byte abyte0[], int i)
    {
        ud = false;
        xd = false;
        yd = "";
        vd = abyte0;
        wd = i;
        ud = true;
    }

    public f(int i)
        throws IOException
    {
        ud = false;
        xd = false;
        yd = "";
        td = new ServerSocket(i);
    }

    public f(String s, int i)
        throws IOException
    {
        ud = false;
        xd = false;
        yd = "";
        sd = new Socket(InetAddress.getByName(s), i);
        sd.setSoTimeout(10000);
        qd = sd.getInputStream();
        rd = sd.getOutputStream();
    }

    public void hb()
    {
        if(ud)
            return;
        try
        {
            if(td != null)
                td.close();
            if(sd != null)
                sd.close();
            if(qd != null)
                qd.close();
            if(rd != null)
                rd.close();
            oe = null;
            return;
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
    }

    public int mb()
        throws IOException
    {
        if(vd != null)
            return vd[wd++];
        if(ud)
            return 0;
        else
            return qd.read();
    }

    public int pb()
        throws IOException
    {
        return mb();
    }

    public int ob()
        throws IOException
    {
        int i = pb();
        int j = pb();
        return i * 256 + j;
    }

    public int nb()
        throws IOException
    {
        int i = ob();
        int j = ob();
        return i * 0x10000 + j;
    }

    public int tb()
        throws IOException
    {
        if(ud)
            return 0;
        else
            return qd.available();
    }

    public void yb(int i, byte abyte0[])
        throws IOException
    {
        if(ud)
            return;
        int j = 0;
        boolean flag = false;
        int k;
        for(; j < i; j += k)
            if((k = qd.read(abyte0, j, i - j)) <= 0)
                throw new IOException("EOF");

    }

    public String fc()
        throws IOException
    {
        String s = "";
        int i;
        for(i = mb(); i == 10 || i == 13; i = mb());
        for(; i != 10 && i != 13 && i != -1; i = mb())
            s = s + le[i];

        return s;
    }

    public void zb()
        throws IOException
    {
        for(int i = mb(); i != 61 && i != -1; i = mb());
    }

    public int gc()
        throws IOException
    {
        int i = 0;
        boolean flag = false;
        int j;
        for(j = mb(); j < 48 || j > 57;)
        {
            if(j == 45)
                flag = true;
            j = mb();
            if(j == -1)
                throw new IOException("Eof!");
        }

        for(; j >= 48 && j <= 57; j = mb())
            i = (i * 10 + j) - 48;

        if(flag)
            i = -i;
        return i;
    }

    public String ac()
        throws IOException
    {
        String s = "";
        boolean flag = false;
        int i;
        for(i = mb(); i < 32 || i == 44 || i == 59 || i == 61;)
        {
            i = mb();
            if(i == -1)
                throw new IOException("Eof!");
        }

        if(i == 34)
        {
            flag = true;
            i = mb();
        }
        for(; i != -1; i = mb())
        {
            if(!flag && (i == 44 || i == 61 || i == 59) || flag && i == 34)
                break;
            s = s + le[i];
        }

        return s;
    }

    public int lb()
        throws IOException
    {
        int i = 0;
        int j;
        for(j = mb(); (j < 48 || j > 57) && (j < 97 || j > 102) && (j < 65 || j > 70);)
        {
            j = mb();
            if(j == -1)
                throw new IOException("Eof!");
        }

        do
        {
            if(j >= 48 && j <= 57)
                i = (i * 16 + j) - 48;
            else
            if(j >= 97 && j <= 102)
            {
                i = (i * 16 + j + 10) - 97;
            } else
            {
                if(j < 65 || j > 70)
                    break;
                i = (i * 16 + j + 10) - 65;
            }
            j = mb();
        } while(true);
        return i;
    }

    public void xb(byte abyte0[], int i, int j, boolean flag)
        throws IOException
    {
    }

    public void kb(int i)
    {
        if(oe == null)
            oe = new byte[40000];
        oe[2] = (byte)i;
        me = 3;
        ne = 8;
        oe[3] = 0;
    }

    public void dc(int i)
    {
        oe[me++] = (byte)i;
    }

    public void cc(int i)
    {
        oe[me++] = (byte)(i >> 8);
        oe[me++] = (byte)i;
    }

    public void bc(int i)
    {
        oe[me++] = (byte)(i >> 24);
        oe[me++] = (byte)(i >> 16);
        oe[me++] = (byte)(i >> 8);
        oe[me++] = (byte)i;
    }

    public void wb(long l)
    {
        bc((int)(l >> 32));
        bc((int)(l & -1L));
    }

    public void sb(String s)
    {
        s.getBytes(0, s.length(), oe, me);
        me += s.length();
    }

    public void rb(int i, int j)
    {
        oe[j++] = (byte)(i >> 8);
        oe[j++] = (byte)i;
    }

    public void ec(byte abyte0[], int i, int j)
    {
        for(int k = 0; k < j; k++)
            oe[me++] = abyte0[i + k];

    }

    public void qb(long l, int i, BigInteger biginteger, BigInteger biginteger1)
    {
        byte abyte0[] = new byte[15];
        abyte0[0] = (byte)(int)(1.0D + Math.random() * 127D);
        abyte0[1] = (byte)(int)(Math.random() * 256D);
        abyte0[2] = (byte)(int)(Math.random() * 256D);
        o.co(abyte0, 3, i);
        o.on(abyte0, 7, l);
        BigInteger biginteger2 = new BigInteger(1, abyte0);
        BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
        byte abyte1[] = biginteger3.toByteArray();
        oe[me++] = (byte)abyte1.length;
        for(int j = 0; j < abyte1.length; j++)
            oe[me++] = abyte1[j];

    }

    public void ub(String s, int i, BigInteger biginteger, BigInteger biginteger1)
    {
        byte abyte0[] = s.getBytes();
        int j = abyte0.length;
        byte abyte1[] = new byte[15];
        for(int k = 0; k < j; k += 7)
        {
            abyte1[0] = (byte)(int)(1.0D + Math.random() * 127D);
            abyte1[1] = (byte)(int)(Math.random() * 256D);
            abyte1[2] = (byte)(int)(Math.random() * 256D);
            abyte1[3] = (byte)(int)(Math.random() * 256D);
            o.co(abyte1, 4, i);
            for(int l = 0; l < 7; l++)
                if(k + l < j)
                    abyte1[8 + l] = abyte0[k + l];
                else
                    abyte1[8 + l] = 32;

            BigInteger biginteger2 = new BigInteger(1, abyte1);
            BigInteger biginteger3 = biginteger2.modPow(biginteger, biginteger1);
            byte abyte2[] = biginteger3.toByteArray();
            oe[me++] = (byte)abyte2.length;
            for(int i1 = 0; i1 < abyte2.length; i1++)
                oe[me++] = abyte2[i1];

        }

    }

    public void ib()
    {
        if(ne != 8)
            me++;
        oe[0] = (byte)((me - 2) / 256);
        oe[1] = (byte)(me - 2 & 0xff);
        try
        {
            xb(oe, 0, me, true);
            return;
        }
        catch(IOException ioexception)
        {
            xd = true;
            yd = ioexception.getMessage();
            return;
        }
    }

    public void hc()
    {
        if(ne != 8)
            me++;
        oe[0] = (byte)((me - 2) / 256);
        oe[1] = (byte)(me - 2 & 0xff);
        try
        {
            xb(oe, 0, me, false);
            return;
        }
        catch(IOException ioexception)
        {
            xd = true;
            yd = ioexception.getMessage();
            return;
        }
    }

    public void vb()
        throws IOException
    {
        if(ne != 8)
            me++;
        oe[0] = (byte)((me - 2) / 256);
        oe[1] = (byte)(me - 2 & 0xff);
        xb(oe, 0, me, true);
    }

    public int jb(byte abyte0[])
    {
        try
        {
            re++;
            if(se > 0 && re > se)
            {
                xd = true;
                yd = "time-out";
                return 0;
            }
            if(qe == 0 && tb() >= 2)
            {
                qe = ob();
                re = 0;
            }
            if(qe > 0 && tb() >= qe)
            {
                yb(qe, abyte0);
                re = 0;
                int i = qe;
                qe = 0;
                return i;
            }
        }
        catch(IOException ioexception)
        {
            xd = true;
            yd = ioexception.getMessage();
        }
        return 0;
    }

    protected InputStream qd;
    protected OutputStream rd;
    protected Socket sd;
    protected ServerSocket td;
    protected boolean ud;
    protected byte vd[];
    int wd;
    public boolean xd;
    public String yd;
    final int zd = 61;
    final int ae = 59;
    final int be = 42;
    final int ce = 43;
    final int de = 44;
    final int ee = 45;
    final int fe = 46;
    final int ge = 47;
    final int he = 92;
    final int ie = 32;
    final int je = 124;
    final int ke = 34;
    static char le[];
    private static int me = 3;
    private static int ne = 8;
    private static byte oe[];
    private static int pe[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    private int qe;
    public int re;
    public int se;

    static 
    {
        le = new char[256];
        for(int i = 0; i < 256; i++)
            le[i] = (char)i;

        le[61] = '=';
        le[59] = ';';
        le[42] = '*';
        le[43] = '+';
        le[44] = ',';
        le[45] = '-';
        le[46] = '.';
        le[47] = '/';
        le[92] = '\\';
        le[124] = '|';
        le[33] = '!';
        le[34] = '"';
    }
}
