// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;

public class fjb extends Applet
    implements Runnable
{

    protected void ffc()
    {
    }

    protected synchronized void fdc()
    {
    }

    protected void fee()
    {
    }

    protected synchronized void fbl()
    {
    }

    protected void fmd()
    {
    }

    protected final void fme(int i, int j, String s, boolean flag)
    {
        fjj = true;
        System.out.println("Started application");
        fjc = i;
        fjd = j;
        fji = new ffg(this, i, j, s, flag, false);
        fka = 1;
        fje = new Thread(this);
        fje.start();
        fje.setPriority(1);
    }

    protected final boolean fmf()
    {
        return fjj;
    }

    protected final void fmg(int i)
    {
        fjf = 1000 / i;
    }

    protected final void fmh()
    {
        for(int i = 0; i < 10; i++)
            fjh[i] = 0L;

    }

    public final synchronized boolean keyDown(Event event, int i)
    {
        boolean flag1 = false;
        ffe(i);
        flk = i;
        fll = i;
        fjn = 0;
        if(i == 1006)
            fkn = true;
        if(i == 1007)
            fla = true;
        if(i == 1004)
            flb = true;
        if(i == 1005)
            flc = true;
        if((char)i == ' ')
            fld = true;
        if((char)i == 'n' || (char)i == 'm')
            fle = true;
        if((char)i == 'N' || (char)i == 'M')
            fle = true;
        if((char)i == '{')
            fkl = true;
        if((char)i == '}')
            fkm = true;
        if((char)i == '\u03F0')
            flm = !flm;
        boolean flag = false;
        for(int j = 0; j < fkk.length(); j++)
        {
            if(i != fkk.charAt(j))
                continue;
            flag = true;
            break;
        }

        if(flag && fln.length() < 20)
            fln += (char)i;
        if(flag && fmb.length() < 80)
            fmb += (char)i;
        if(i == 8 && fln.length() > 0)
            fln = fln.substring(0, fln.length() - 1);
        if(i == 8 && fmb.length() > 0)
            fmb = fmb.substring(0, fmb.length() - 1);
        if(i == 10 || i == 13)
        {
            fma = fln;
            fmc = fmb;
        }
        return true;
    }

    protected void ffe(int i)
    {
    }

    public final synchronized boolean keyUp(Event event, int i)
    {
        flk = 0;
        if(i == 1006)
            fkn = false;
        if(i == 1007)
            fla = false;
        if(i == 1004)
            flb = false;
        if(i == 1005)
            flc = false;
        if((char)i == ' ')
            fld = false;
        if((char)i == 'n' || (char)i == 'm')
            fle = false;
        if((char)i == 'N' || (char)i == 'M')
            fle = false;
        if((char)i == '{')
            fkl = false;
        if((char)i == '}')
            fkm = false;
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i, int j)
    {
        flg = i;
        flh = j + 0;
        fli = 0;
        fjn = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i, int j)
    {
        flg = i;
        flh = j + 0;
        fli = 0;
        return true;
    }

    public final synchronized boolean mouseDown(Event event, int i, int j)
    {
        flg = i;
        flh = j + 0;
        if(event.metaDown())
            fli = 2;
        else
            fli = 1;
        flj = fli;
        fjn = 0;
        fcm(fli, i, j);
        return true;
    }

    protected void fcm(int i, int j, int k)
    {
    }

    public final synchronized boolean mouseDrag(Event event, int i, int j)
    {
        flg = i;
        flh = j + 0;
        if(event.metaDown())
            fli = 2;
        else
            fli = 1;
        return true;
    }

    public final void init()
    {
        fjj = true;
        System.out.println("Started applet");
        fjc = 512;
        fjd = 344;
        fka = 1;
        fnf.fng = getCodeBase();
        fde(this);
    }

    public final void start()
    {
        if(fjk >= 0)
            fjk = 0;
    }

    public final void stop()
    {
        if(fjk >= 0)
            fjk = 4000 / fjf;
    }

    public final void destroy()
    {
        fjk = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception _ex) { }
        if(fjk == -1)
        {
            System.out.println("5 seconds expired, forcing kill");
            fmi();
            if(fje != null)
            {
                fje.stop();
                fje = null;
            }
        }
    }

    private final void fmi()
    {
        fjk = -2;
        System.out.println("Closing program");
        fee();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(fji != null)
            fji.dispose();
        if(!fjj)
            System.exit(0);
    }

    public final void run()
    {
        boolean flag = false;
        if(fka == 1)
        {
            fka = 2;
            fkj = getGraphics();
            fmj();
            fmk(0, "Loading...");
            ffc();
            fka = 0;
        }
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        for(int j1 = 0; j1 < 10; j1++)
            fjh[j1] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while(fjk >= 0) 
        {
            if(fjk > 0)
            {
                fjk--;
                if(fjk == 0)
                {
                    fmi();
                    fje = null;
                    return;
                }
            }
            int k1 = j;
            int i2 = k;
            j = 300;
            k = 1;
            long l1 = System.currentTimeMillis();
            if(fjh[i] == 0L)
            {
                j = k1;
                k = i2;
            } else
            if(l1 > fjh[i])
                j = (int)((long)(2560 * fjf) / (l1 - fjh[i]));
            if(j < 25)
                j = 25;
            if(j > 256)
            {
                j = 256;
                k = (int)((long)fjf - (l1 - fjh[i]) / 10L);
                if(k < flf)
                    k = flf;
            }
            try
            {
                Thread.sleep(k);
            }
            catch(InterruptedException _ex) { }
            fjh[i] = l1;
            i = (i + 1) % 10;
            if(k > 1)
            {
                for(int j2 = 0; j2 < 10; j2++)
                    if(fjh[j2] != 0L)
                        fjh[j2] += k;

            }
            int k2 = 0;
            while(i1 < 256) 
            {
                fdc();
                i1 += j;
                if(++k2 > fjg)
                {
                    i1 = 0;
                    fjl += 6;
                    if(fjl > 25)
                    {
                        fjl = 0;
                        flm = true;
                    }
                    break;
                }
            }
            fjl--;
            i1 &= 0xff;
            fbl();
        }
        if(fjk == -1)
            fmi();
        fje = null;
    }

    public final void update(Graphics g)
    {
        paint(g);
    }

    public final void paint(Graphics g)
    {
        if(fka == 2 && fki != null)
        {
            fmk(fkd, fke);
            return;
        }
        if(fka == 0)
            fmd();
    }


   private final void fmj()
     {
         fkj.setColor(Color.black);
 Toolkit toolkit = Toolkit.getDefaultToolkit();
             int jj = (fjc - 281) / 2;
             int kk = (fjd - 148) / 2;
 fki = toolkit.getImage(System.getProperty("user.dir") + "/data/sb.swf");
           fkj.drawImage(fki, jj, kk, this);
        {
            blm.ceb("h11p", 0, this);
            blm.ceb("h12b", 1, this);
            blm.ceb("h12p", 2, this);
            blm.ceb("h13b", 3, this);
            blm.ceb("h14b", 4, this);
            blm.ceb("h16b", 5, this);
            blm.ceb("h20b", 6, this);
            blm.ceb("h24b", 7, this);
        }
    }
  private final void fmk(int i, String s)
    {
        try
        {               
int j = (fjc - 281) / 2;
            int k = (fjd - 148) / 2;
           fkj.setColor(Color.black);
             fkj.fillRect(0, 0, fjc, fjd);
          fkj.drawImage(fki, j, k, this);
            j += 2;
            k += 90;
            fkd = i;
            fke = s;
            fkj.setColor(new Color(132, 132, 132));
            fkj.drawRect(j - 2, k - 2, 280, 23);
            fkj.fillRect(j, k, (277 * i) / 100, 20);
            fkj.setColor(new Color(198, 198, 198));
         fmm(fkj, s, fkf, j + 138, k + 10);
            fmm(fkj, "Created by Khain and antiyou", fkg, j + 138, k + 30);
            fmm(fkj, "\2512001-2002 RuinBot", fkg, j + 138, k + 44);

       }
        catch(Exception _ex) { }
    }


  protected final void fml(int i, String s)
    {
        try
        {       
 int j = (fjc - 281) / 2;
            int k = (fjd - 148) / 2;
            j += 2;
            k += 90;
            fkd = i;
            fke = s;
            int l = (277 * i) / 100;
            fkj.setColor(Color.blue);
            fkj.fillRect(j, k, l, 20);
            fkj.setColor(Color.black);
            fkj.fillRect(j + l, k, 277 - l, 20);
            fkj.setColor(Color.red);
            fmm(fkj, s, fkf, j + 138, k + 10);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    protected final void fmm(Graphics g, String s, Font font, int i, int j)
    {
        Object obj;
        if(fji == null)
            obj = this;
        else
            obj = fji;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
        fontmetrics.stringWidth(s);
        g.setFont(font);
        g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
    }

    private final Image fmn(byte abyte0[])
    {
        boolean flag = false;
        int i = abyte0[13] * 256 + abyte0[12];
        int j = abyte0[15] * 256 + abyte0[14];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        byte abyte3[] = new byte[256];
        for(int k = 0; k < 256; k++)
        {
            abyte1[k] = abyte0[20 + k * 3];
            abyte2[k] = abyte0[19 + k * 3];
            abyte3[k] = abyte0[18 + k * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
        byte abyte4[] = new byte[i * j];
        int l = 0;
        for(int i1 = j - 1; i1 >= 0; i1--)
        {
            for(int j1 = 0; j1 < i; j1++)
                abyte4[l++] = abyte0[786 + j1 + i1 * i];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(i, j, indexcolormodel, abyte4, 0, i);
        Image image = createImage(memoryimagesource);
        return image;
    }

    protected byte[] fbm(String s, String s1, int i)
    {
        System.out.println("Using default load");
        int j = 0;
        int k = 0;
        byte abyte0[] = null;
        try
        {
            fml(i, "Loading " + s1 + " - 0%");
            java.io.InputStream inputstream = fnf.fnj(s);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            j = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            fml(i, "Loading " + s1 + " - 5%");
            int l = 0;
            abyte0 = new byte[k];
            while(l < k) 
            {
                int i1 = k - l;
                if(i1 > 1000)
                    i1 = 1000;
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                fml(i, "Loading " + s1 + " - " + (5 + (l * 95) / k) + "%");
            }
            datainputstream.close();
        }
        catch(IOException _ex) { }
        fml(i, "Unpacking " + s1);
        if(k != j)
        {
            byte abyte1[] = new byte[j];
            gnd.gne(abyte1, j, abyte0, k, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public Graphics getGraphics()
    {
        if(fji != null)
            return fji.getGraphics();
        else
            return super.getGraphics();
    }

    public Image createImage(int i, int j)
    {
        if(fji != null)
            return fji.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public URL getCodeBase()
    {
        return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        return super.getDocumentBase();
    }

    public String getParameter(String s)
    {
        return super.getParameter(s);
    }

    protected Socket fbb(String s, int i)
        throws IOException
    {
        Socket socket;
        if(fmf())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void fde(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public fjb()
    {
        fjc = 512;
        fjd = 384;
        fjf = 20;
        fjg = 1000;
        fjh = new long[10];
        fka = 1;
        fkc = false;
        fke = "Loading";
        fkf = new Font("TimesRoman", 0, 15);
        fkg = new Font("Helvetica", 1, 13);
        fkh = new Font("Helvetica", 0, 12);
        fkl = false;
        fkm = false;
        fkn = false;
        fla = false;
        flb = false;
        flc = false;
        fld = false;
        fle = false;
        flf = 1;
        flm = false;
        fln = "";
        fma = "";
        fmb = "";
        fmc = "";
    }

    private int fjc;
    private int fjd;
    private Thread fje;
    private int fjf;
    private int fjg;
    private long fjh[];
    public static ffg fji = null;
    private boolean fjj;
    private int fjk;
    private int fjl;
    public int fjm;
    public int fjn;
    public int fka;
    public String fkb;
    private boolean fkc;
    private int fkd;
    private String fke;
    private Font fkf;
    private Font fkg;
    private Font fkh;
    private Image fki;
    private Graphics fkj;
    private static String fkk = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean fkl;
    public boolean fkm;
    public boolean fkn;
    public boolean fla;
    public boolean flb;
    public boolean flc;
    public boolean fld;
    public boolean fle;
    public int flf;
    public int flg;
    public int flh;
    public int fli;
    public int flj;
    public int flk;
    public int fll;
    public boolean flm;
    public String fln;
    public String fma;
    public String fmb;
    public String fmc;

}
