// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
import java.io.IOException;
public class hcg
{
    public void hej(int ai[])
    {
        hdn = new daj(ai);
        hea = new daj(ai);
    }
    public void ban()
    {
    }
    public int hek(byte abyte0[])
    {
        try
        {
            hci++;
            if(hcj > 0 && hci > hcj)
            {
                hed = true;
                hef = "time-out";
                hcj += hcj;
                return 0;
            }
            if(hch == 0 && bbb() >= 2)
            {
                hch = bba();
                if(hch >= 160)
                    hch = (hch - 160) * 256 + bba();
            }
            if(hch > 0 && bbb() >= hch)
            {
                if(hch >= 160)
                {
                    hel(hch, abyte0);
                } else
                {
                    abyte0[hch - 1] = (byte)bba();
                    if(hch > 1)
                        hel(hch - 1, abyte0);
                }
                int i = hch;
                hch = 0;
                hci = 0;
                return i;
            }
        }
        catch(IOException ioexception)
        {
            hed = true;
            hef = ioexception.getMessage();
        }
        return 0;
    }
    public void bbc(int i, int j, byte abyte0[])
        throws IOException
    {
    }
    public int bba()
        throws IOException
    {
        return 0;
    }
    public void hel(int i, byte abyte0[])
        throws IOException
    {
        bbc(i, 0, abyte0);
    }
    public void send()
    {
        if(hea != null)
        {
            int i = hcn[hck + 2] & 0xff;
            hcn[hck + 2] = (byte)(i + hea.dbc());
        }
        if(hcm != 8)
            hcl++;
        int j = hcl - hck - 2;
        if(j >= 160)
        {
            hcn[hck] = (byte)(160 + j / 256);
            hcn[hck + 1] = (byte)(j & 0xff);
        } else
        {
            hcn[hck] = (byte)j;
            hcl--;
            hcn[hck + 1] = hcn[hcl];
        }
        if(heh <= 10000)
        {
            int k = hcn[hck + 2] & 0xff;
            hec[k]++;
            heg[k] += hcl - hck;
        }
        hck = hcl;
    }
    public void hen(String s)
    {
        s.getBytes(0, s.length(), hcn, hcl);
        hcl += s.length();
    }
    public int hfa()
        throws IOException
    {
        return bba();
    }
    public void hfb()
        throws IOException
    {
        send();
        hfg(0);
    }
    public void id(int i)
    {
        if(hck > (heh * 4) / 5)
            try
            {
                hfg(0);
            }
            catch(IOException ioexception)
            {
                hed = true;
                hef = ioexception.getMessage();
            }
        if(hcn == null)
            hcn = new byte[heh];
        hcn[hck + 2] = (byte)i;
        hcn[hck + 3] = 0;
        hcl = hck + 3;
        hcm = 8;
    }
    public void hfd(byte abyte0[], int i, int j)
    {
        for(int k = 0; k < j; k++)
            hcn[hcl++] = abyte0[i + k];
    }
    public long hfe()
        throws IOException
    {
        long l = hfm();
        long l1 = hfm();
        long l2 = hfm();
        long l3 = hfm();
        return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
    }
    public void hff(long l)
    {
        hfi((int)(l >> 32));
        hfi((int)(l & -1L));
    }
    public int bbb()
        throws IOException
    {
        return 0;
    }
    public void hfg(int i)
        throws IOException
    {
        if(hed)
        {
            hck = 0;
            hcl = 3;
            hed = false;
            throw new IOException(hef);
        }
        hee++;
        if(hee < i)
            return;
        if(hck > 0)
        {
            hee = 0;
            bbd(hcn, 0, hck);
        }
        hck = 0;
        hcl = 3;
    }
    public boolean hfh()
    {
        return hck > 0;
    }
    public void hfi(int i)
    {
        hcn[hcl++] = (byte)(i >> 24);
        hcn[hcl++] = (byte)(i >> 16);
        hcn[hcl++] = (byte)(i >> 8);
        hcn[hcl++] = (byte)i;
    }
    public void var(int i)
    {
        hcn[hcl++] = (byte)i;
    }
    public int hfk(int i)
    {
        return i - hdn.dbc() & 0xff;
    }
    public void bbd(byte abyte0[], int i, int j)
        throws IOException
    {
    }
    public void cmd(int i)
    {
        hcn[hcl++] = (byte)(i >> 8);
        hcn[hcl++] = (byte)i;
    }
    public int hfm()
        throws IOException
    {
        int i = hfa();
        int j = hfa();
        return i * 256 + j;
    }
    public hcg()
    {
        super();
        boolean flag = false;
        hcl = 3;
        hcm = 8;
        hed = false;
        hef = "";
        heh = 5000;
    }
    protected int hch;
    public int hci;
    public int hcj;
    public int hck;
    private int hcl;
    private int hcm;
    public byte hcn[];
    private static int hda[] = {
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
        1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
        0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
        0x3fffffff, 0x7fffffff, -1
    };
    final int hdb = 61;
    final int hdc = 59;
    final int hdd = 42;
    final int hde = 43;
    final int hdf = 44;
    final int hdg = 45;
    final int hdh = 46;
    final int hdi = 47;
    final int hdj = 92;
    final int hdk = 32;
    final int hdl = 124;
    final int hdm = 34;
    public daj hdn;
    public daj hea;
    static char heb[];
    public static int hec[] = new int[256];
    protected boolean hed;
    protected int hee;
    protected String hef;
    public static int heg[] = new int[256];
    protected int heh;
    public static int hei;
    static 
    {
        heb = new char[256];
        for(int i = 0; i < 256; i++)
            heb[i] = (char)i;
        heb[61] = '=';
        heb[59] = ';';
        heb[42] = '*';
        heb[43] = '+';
        heb[44] = ',';
        heb[45] = '-';
        heb[46] = '.';
        heb[47] = '/';
        heb[92] = '\\';
        heb[124] = '|';
        heb[33] = '!';
        heb[34] = '"';
    }
}
