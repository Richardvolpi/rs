// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:05 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.IOException;

public class r
{

    public void bfh(int arg0[])
    {
        bke = new p(arg0);
        bkf = new p(arg0);
    }

    public void bfi()
    {
    }

    public void bfj(int arg0)
    {
        bje[bjc++] = (byte)arg0;
    }

    public void bfk(int i, int j, byte abyte0[])
        throws IOException
    {
    }

    public int bfl()
        throws IOException
    {
        return 0;
    }

    public void bfm(int arg0, byte arg1[])
        throws IOException
    {
        bfk(arg0, 0, arg1);
    }

    public void bfn(int arg0)
    {
        bje[bjc++] = (byte)(arg0 >> 8);
        bje[bjc++] = (byte)arg0;
    }

    public int bga()
        throws IOException
    {
        return 0;
    }

    public void bgb(int arg0)
    {
        bje[bjc++] = (byte)(arg0 >> 24);
        bje[bjc++] = (byte)(arg0 >> 16);
        bje[bjc++] = (byte)(arg0 >> 8);
        bje[bjc++] = (byte)arg0;
    }

    public void bgc(String arg0)
    {
        arg0.getBytes(0, arg0.length(), bje, bjc);
        bjc += arg0.length();
    }

    public boolean bgd()
    {
        return bjb > 0;
    }

    public int bge(byte arg0[])
    {
        try
        {
            bin++;
            if(bja > 0 && bin > bja)
            {
                bkl = true;
                bkk = "time-out";
                bja += bja;
                return 0;
            }
            if(bim == 0 && bga() >= 2)
            {
                bim = bfl();
                if(bim >= 160)
                    bim = (bim - 160) * 256 + bfl();
            }
            if(bim > 0 && bga() >= bim)
            {
                if(bim >= 160)
                {
                    bfm(bim, arg0);
                } else
                {
                    arg0[bim - 1] = (byte)bfl();
                    if(bim > 1)
                        bfm(bim - 1, arg0);
                }
                int i = bim;
                bim = 0;
                bin = 0;
                return i;
            }
        }
        catch(IOException ioexception)
        {
            bkl = true;
            bkk = ioexception.getMessage();
        }
        return 0;
    }

    public void bgf()
        throws IOException
    {
        bgm();
        bgi(0);
    }

    public void bgg(byte abyte0[], int i, int j)
        throws IOException
    {
    }

    public void bgh(long arg0)
    {
        bgb((int)(arg0 >> 32));
        bgb((int)(arg0 & -1L));
    }

    public void bgi(int arg0)
        throws IOException
    {
        if(bkl)
        {
            bjb = 0;
            bjc = 3;
            bkl = false;
            throw new IOException(bkk);
        }
        bkj++;
        if(bkj < arg0)
            return;
        if(bjb > 0)
        {
            bkj = 0;
            bgg(bje, 0, bjb);
        }
        bjb = 0;
        bjc = 3;
    }

    public int bgj()
        throws IOException
    {
        int i = bhb();
        int j = bhb();
        return i * 256 + j;
    }

    public int bgk(int arg0)
    {
        return arg0 - bke.adf() & 0xff;
    }

    public void bgl(int arg0)
    {
        if(bjb > (bkm * 4) / 5)
            try
            {
                bgi(0);
            }
            catch(IOException ioexception)
            {
                bkl = true;
                bkk = ioexception.getMessage();
            }
        if(bje == null)
            bje = new byte[bkm];
        bje[bjb + 2] = (byte)arg0;
        bje[bjb + 3] = 0;
        bjc = bjb + 3;
        bjd = 8;
    }

    public void bgm()
    {
        if(bkf != null)
        {
            int i = bje[bjb + 2] & 0xff;
            bje[bjb + 2] = (byte)(i + bkf.adf());
        }
        if(bjd != 8)
            bjc++;
        int j = bjc - bjb - 2;
        if(j >= 160)
        {
            bje[bjb] = (byte)(160 + j / 256);
            bje[bjb + 1] = (byte)(j & 0xff);
        } else
        {
            bje[bjb] = (byte)j;
            bjc--;
            bje[bjb + 1] = bje[bjc];
        }
        if(bkm <= 10000)
        {
            int k = bje[bjb + 2] & 0xff;
            bkh[k]++;
            bki[k] += bjc - bjb;
        }
        bjb = bjc;
    }

    public void bgn(byte arg0[], int arg1, int arg2)
    {
        for(int i = 0; i < arg2; i++)
            bje[bjc++] = arg0[arg1 + i];

    }

    public long bha()
        throws IOException
    {
        long l = bgj();
        long l1 = bgj();
        long l2 = bgj();
        long l3 = bgj();
        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }

    public int bhb()
        throws IOException
    {
        return bfl();
    }

    public r()
    {
        bjc = 3;
        bjd = 8;
        bkk = "";
        bkl = false;
        bkm = 5000;
    }

    protected int bim;
    public int bin;
    public int bja;
    public int bjb;
    private int bjc;
    private int bjd;
    public byte bje[];
    private static int bjf[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    final int bjg = 61;
    final int bjh = 59;
    final int bji = 42;
    final int bjj = 43;
    final int bjk = 44;
    final int bjl = 45;
    final int bjm = 46;
    final int bjn = 47;
    final int bka = 92;
    final int bkb = 32;
    final int bkc = 124;
    final int bkd = 34;
    public p bke;
    public p bkf;
    static char bkg[];
    public static int bkh[] = new int[256];
    public static int bki[] = new int[256];
    protected int bkj;
    protected String bkk;
    protected boolean bkl;
    protected int bkm;
    public static int bkn;

    static 
    {
        bkg = new char[256];
        for(int i = 0; i < 256; i++)
            bkg[i] = (char)i;

        bkg[61] = '=';
        bkg[59] = ';';
        bkg[42] = '*';
        bkg[43] = '+';
        bkg[44] = ',';
        bkg[45] = '-';
        bkg[46] = '.';
        bkg[47] = '/';
        bkg[92] = '\\';
        bkg[124] = '|';
        bkg[33] = '!';
        bkg[34] = '"';
    }
}