/* deobfuscatorzed by saevion
 * 
 * <3 to:
 *  jakarta-BCEL    <http://jakarta.apache.org/bcel/index.html>
 *  jakarta-regexp  <http://jakarta.apache.org/regexp/index.html>
 *  jad             <http://kpdus.tripod.com/jad.html>
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;

public class a extends Applet
    implements Runnable
{

    protected void enj()
    {
    }

    protected synchronized void enm()
    {
    }

    protected void ena()
    {
    }

    protected synchronized void fbd()
    {
    }

    protected void flb()
    {
    }

    protected final void flc(int i, int k, String s, boolean flag)
    {
        fih = true;
        fia = i;
        fib = k;
        fig = new c(this, i, k, s, flag, false);
        fim = 1;
        fic = new Thread(this);
        fic.start();
        fic.setPriority(1);
    }

    protected final boolean fld()
    {
        return fih;
    }

    protected final void fle(int i)
    {
        fid = 1000 / i;
    }

    protected final void flf()
    {
        for(int i = 0; i < 10; i++)
            fif[i] = 0L;

    }

    public final synchronized boolean keyDown(Event arg0, int arg1)
    {
        fcf(arg1);
        fki = arg1;
        fkj = arg1;
        fil = 0;
        if(arg1 == 1006)
            fjl = true;
        if(arg1 == 1007)
            fjm = true;
        if(arg1 == 1004)
            fjn = true;
        if(arg1 == 1005)
            fka = true;
        if((char)arg1 == ' ')
            fkb = true;
        if((char)arg1 == 'n' || (char)arg1 == 'm')
            fkc = true;
        if((char)arg1 == 'N' || (char)arg1 == 'M')
            fkc = true;
        if((char)arg1 == '{')
            fjj = true;
        if((char)arg1 == '}')
            fjk = true;
        if((char)arg1 == '\u03F0')
            fkk = !fkk;
        boolean flag = false;
        for(int i = 0; i < fji.length(); i++)
        {
            if(arg1 != fji.charAt(i))
                continue;
            flag = true;
            break;
        }

        if(flag && fkl.length() < 20)
            fkl += (char)arg1;
        if(flag && fkn.length() < 80)
            fkn += (char)arg1;
        if(arg1 == 8 && fkl.length() > 0)
            fkl = fkl.substring(0, fkl.length() - 1);
        if(arg1 == 8 && fkn.length() > 0)
            fkn = fkn.substring(0, fkn.length() - 1);
        if(arg1 == 10 || arg1 == 13)
        {
            fkm = fkl;
            fla = fkn;
        }
        return true;
    }

    protected void fcf(int i)
    {
    }

    public final synchronized boolean keyUp(Event event, int i)
    {
        fki = 0;
        if(i == 1006)
            fjl = false;
        if(i == 1007)
            fjm = false;
        if(i == 1004)
            fjn = false;
        if(i == 1005)
            fka = false;
        if((char)i == ' ')
            fkb = false;
        if((char)i == 'n' || (char)i == 'm')
            fkc = false;
        if((char)i == 'N' || (char)i == 'M')
            fkc = false;
        if((char)i == '{')
            fjj = false;
        if((char)i == '}')
            fjk = false;
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i, int k)
    {
        fke = i;
        fkf = k + fik;
        fkg = 0;
        fil = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i, int k)
    {
        fke = i;
        fkf = k + fik;
        fkg = 0;
        return true;
    }

    public final synchronized boolean mouseDown(Event arg0, int arg1, int arg2)
    {
        fke = arg1;
        fkf = arg2 + fik;
        if(arg0.metaDown())
            fkg = 2;
        else
            fkg = 1;
        fkh = fkg;
        fil = 0;
        fbm(fkg, arg1, arg2);
        return true;
    }

    protected void fbm(int i, int k, int l)
    {
    }

    public final synchronized boolean mouseDrag(Event arg0, int arg1, int arg2)
    {
        fke = arg1;
        fkf = arg2 + fik;
        if(arg0.metaDown())
            fkg = 2;
        else
            fkg = 1;
        return true;
    }

    public final void init()
    {
        fih = true;
        fia = 512;
        fib = 344;
        fim = 1;
        t.fmc = getCodeBase();
        ene(this);
    }

    public final void start()
    {
        if(fii >= 0)
            fii = 0;
    }

    public final void stop()
    {
        if(fii >= 0)
            fii = 4000 / fid;
    }

    public final void destroy()
    {
        fii = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception _ex) { }
        if(fii == -1)
        {
            System.out.println("5 seconds expired, forcing kill");
            flg();
            if(fic != null)
            {
                fic.stop();
                fic = null;
            }
        }
    }

    private final void flg()
    {
        fii = -2;
        System.out.println("Closing program");
        ena();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(fig != null)
            fig.dispose();
        if(!fih)
            System.exit(0);
    }

    public final void run()
    {
        if(fim == 1)
        {
            fim = 2;
            fjh = getGraphics();
            flh();
            fli(0, "Loading...");
            enj();
            fim = 0;
        }
        int i = 0;
        int k = 256;
        int i1 = 1;
        int j1 = 0;
        for(int k1 = 0; k1 < 10; k1++)
            fif[k1] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while(fii >= 0) 
        {
            if(fii > 0)
            {
                fii--;
                if(fii == 0)
                {
                    flg();
                    fic = null;
                    return;
                }
            }
            int i2 = k;
            int j2 = i1;
            k = 300;
            i1 = 1;
            long l1 = System.currentTimeMillis();
            if(fif[i] == 0L)
            {
                k = i2;
                i1 = j2;
            } else
            if(l1 > fif[i])
                k = (int)((long)(2560 * fid) / (l1 - fif[i]));
            if(k < 25)
                k = 25;
            if(k > 256)
            {
                k = 256;
                i1 = (int)((long)fid - (l1 - fif[i]) / 10L);
                if(i1 < fkd)
                    i1 = fkd;
            }
            try
            {
                Thread.sleep(i1);
            }
            catch(InterruptedException _ex) { }
            fif[i] = l1;
            i = (i + 1) % 10;
            if(i1 > 1)
            {
                for(int k2 = 0; k2 < 10; k2++)
                    if(fif[k2] != 0L)
                        fif[k2] += i1;

            }
            int l2 = 0;
            while(j1 < 256) 
            {
                enm();
                j1 += k;
                if(++l2 > fie)
                {
                    j1 = 0;
                    fij += 6;
                    if(fij > 25)
                    {
                        fij = 0;
                        fkk = true;
                    }
                    break;
                }
            }
            fij--;
            j1 &= 0xff;
            fbd();
        }
        if(fii == -1)
            flg();
        fic = null;
    }

    public final void update(Graphics g1)
    {
        paint(g1);
    }

    public final void paint(Graphics g1)
    {
        if(fim == 2 && fjg != null)
        {
            fli(fjb, fjc);
            return;
        }
        if(fim == 0)
            flb();
    }

    private final void flh()
    {
        fjh.setColor(Color.black);
        fjh.fillRect(0, 0, fia, fib);
        byte abyte0[] = fcb("jagex.jag", "Jagex library", 0);
        if(abyte0 == null)
        {
            return;
        } else
        {
            byte abyte1[] = t.fng("logo.tga", 0, abyte0);
            fjg = fll(abyte1);
            j.cdi("h11p", 0, this);
            j.cdi("h12b", 1, this);
            j.cdi("h12p", 2, this);
            j.cdi("h13b", 3, this);
            j.cdi("h14b", 4, this);
            j.cdi("h16b", 5, this);
            j.cdi("h20b", 6, this);
            j.cdi("h24b", 7, this);
            return;
        }
    }

    private final void fli(int arg0, String arg1)
    {
        try
        {
            int i = (fia - 281) / 2;
            int k = (fib - 148) / 2;
            fjh.setColor(Color.black);
            fjh.fillRect(0, 0, fia, fib);
            if(!fja)
                fjh.drawImage(fjg, i, k, this);
            i += 2;
            k += 90;
            fjb = arg0;
            fjc = arg1;
            fjh.setColor(new Color(132, 132, 132));
            if(fja)
                fjh.setColor(new Color(220, 0, 0));
            fjh.drawRect(i - 2, k - 2, 280, 23);
            fjh.fillRect(i, k, (277 * arg0) / 100, 20);
            fjh.setColor(new Color(198, 198, 198));
            if(fja)
                fjh.setColor(new Color(255, 255, 255));
            flk(fjh, arg1, fjd, i + 138, k + 10);
            if(!fja)
            {
                flk(fjh, "Created by Cyberman - visit www.deathaura.mypunbb.com", fje, i + 138, k + 30);
            } else
            {
                fjh.setColor(new Color(132, 132, 152));
                flk(fjh, "\2512001-2002 Andrew Gower and Jagex Ltd", fjf, i + 138, fib - 20);
            }
            if(fin != null)
            {
                fjh.setColor(Color.white);
                flk(fjh, fin, fje, i + 138, k - 120);
                return;
            }
        }
        catch(Exception _ex) { }
    }

    protected final void flj(int i, String s)
    {
        try
        {
            int k = (fia - 281) / 2;
            int l = (fib - 148) / 2;
            k += 2;
            l += 90;
            fjb = i;
            fjc = s;
            int i1 = (277 * i) / 100;
            fjh.setColor(new Color(132, 132, 132));
            if(fja)
                fjh.setColor(new Color(220, 0, 0));
            fjh.fillRect(k, l, i1, 20);
            fjh.setColor(Color.black);
            fjh.fillRect(k + i1, l, 277 - i1, 20);
            fjh.setColor(new Color(198, 198, 198));
            if(fja)
                fjh.setColor(new Color(255, 255, 255));
            flk(fjh, s, fjd, k + 138, l + 10);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    protected final void flk(Graphics arg0, String arg1, Font arg2, int arg3, int arg4)
    {
        Object obj;
        if(fig == null)
            obj = this;
        else
            obj = fig;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(arg2);
        fontmetrics.stringWidth(arg1);
        arg0.setFont(arg2);
        arg0.drawString(arg1, arg3 - fontmetrics.stringWidth(arg1) / 2, arg4 + fontmetrics.getHeight() / 4);
    }

    private final Image fll(byte arg0[])
    {
        int i = arg0[13] * 256 + arg0[12];
        int k = arg0[15] * 256 + arg0[14];
        byte abyte0[] = new byte[256];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        for(int l = 0; l < 256; l++)
        {
            abyte0[l] = arg0[20 + l * 3];
            abyte1[l] = arg0[19 + l * 3];
            abyte2[l] = arg0[18 + l * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte0, abyte1, abyte2);
        byte abyte3[] = new byte[i * k];
        int i1 = 0;
        for(int j1 = k - 1; j1 >= 0; j1--)
        {
            for(int k1 = 0; k1 < i; k1++)
                abyte3[i1++] = arg0[786 + k1 + j1 * i];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(i, k, indexcolormodel, abyte3, 0, i);
        Image image = createImage(memoryimagesource);
        return image;
    }

    protected byte[] fcb(String arg0, String arg1, int arg2)
    {
        int i = 0;
        int k = 0;
        byte abyte0[] = null;
        try
        {
            flj(arg2, "Loading " + arg1 + " - 0%");
            java.io.InputStream inputstream = t.fmf(arg0);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            i = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            flj(arg2, "Loading " + arg1 + " - 5%");
            int l = 0;
            abyte0 = new byte[k];
            while(l < k) 
            {
                int i1 = k - l;
                if(i1 > 1000)
                    i1 = 1000;
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                flj(arg2, "Loading " + arg1 + " - " + (5 + (l * 95) / k) + "%");
            }
            datainputstream.close();
        }
        catch(IOException _ex) { }
        flj(arg2, "Unpacking " + arg1);
        if(k != i)
        {
            byte abyte1[] = new byte[i];
            g.glj(abyte1, i, abyte0, k, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public Graphics getGraphics()
    {
        if(fig != null)
            return fig.getGraphics();
        else
            return super.getGraphics();
    }

    public Image createImage(int i, int k)
    {
        if(fig != null)
            return fig.createImage(i, k);
        else
            return super.createImage(i, k);
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

    protected Socket enb(String arg0, int arg1)
        throws IOException
    {
        Socket socket;
        if(fld())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket = new Socket(InetAddress.getByName(arg0), arg1);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void ene(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public a()
    {
        fia = 512;
        fib = 384;
        fid = 20;
        fie = 1000;
        fif = new long[10];
        fim = 1;
        fja = false;
        fjc = "Loading";
        fjd = new Font("TimesRoman", 0, 15);
        fje = new Font("Helvetica", 1, 13);
        fjf = new Font("Helvetica", 0, 12);
        fjj = false;
        fjk = false;
        fjl = false;
        fjm = false;
        fjn = false;
        fka = false;
        fkb = false;
        fkc = false;
        fkd = 1;
        fkk = false;
        fkl = "";
        fkm = "";
        fkn = "";
        fla = "";
    }

    private int fia;
    private int fib;
    private Thread fic;
    private int fid;
    private int fie;
    private long fif[];
    public static c fig = null;
    private boolean fih;
    private int fii;
    private int fij;
    public int fik;
    public int fil;
    public int fim;
    public String fin;
    private boolean fja;
    private int fjb;
    private String fjc;
    private Font fjd;
    private Font fje;
    private Font fjf;
    private Image fjg;
    private Graphics fjh;
    private static String fji = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean fjj;
    public boolean fjk;
    public boolean fjl;
    public boolean fjm;
    public boolean fjn;
    public boolean fka;
    public boolean fkb;
    public boolean fkc;
    public int fkd;
    public int fke;
    public int fkf;
    public int fkg;
    public int fkh;
    public int fki;
    public int fkj;
    public boolean fkk;
    public String fkl;
    public String fkm;
    public String fkn;
    public String fla;

}
