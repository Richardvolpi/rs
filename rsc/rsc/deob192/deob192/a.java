// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:47:20 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;

public class a extends Applet
    implements Runnable
{

    protected void ahh()
    {
    }

    protected synchronized void ahi()
    {
    }

    protected void ahj()
    {
    }

    protected synchronized void ahk()
    {
    }

    protected void ahl()
    {
    }

    protected final void ahm(int arg0, int arg1, String arg2, boolean arg3)
    {
        ale = true;
        System.out.println("Started application");
        akl = arg0;
        akm = arg1;
        ald = new c(this, arg0, arg1, arg2, arg3, false);
        alj = 1;
        akn = new Thread(this);
        akn.start();
        akn.setPriority(1);
    }

    protected final boolean ahn()
    {
        return ale;
    }

    protected final void aia(int arg0)
    {
        ala = 1000 / arg0;
    }

    protected final void aib()
    {
        for(int i = 0; i < 10; i++)
            alc[i] = 0L;

    }

    public final synchronized boolean aic(Event arg0, int arg1)
    {
        aid(arg1);
        anf = arg1;
        ang = arg1;
        ali = 0;
        if(arg1 == 1006)
            ami = true;
        if(arg1 == 1007)
            amj = true;
        if(arg1 == 1004)
            amk = true;
        if(arg1 == 1005)
            aml = true;
        if((char)arg1 == ' ')
            amm = true;
        if((char)arg1 == 'n' || (char)arg1 == 'm')
            amn = true;
        if((char)arg1 == 'N' || (char)arg1 == 'M')
            amn = true;
        if((char)arg1 == '{')
            amg = true;
        if((char)arg1 == '}')
            amh = true;
        if((char)arg1 == '\u03F0')
            anh = !anh;
        boolean flag = false;
        for(int i = 0; i < amf.length(); i++)
        {
            if(arg1 != amf.charAt(i))
                continue;
            flag = true;
            break;
        }

        if(flag && ani.length() < 20)
            ani += (char)arg1;
        if(flag && ank.length() < 80)
            ank += (char)arg1;
        if(arg1 == 8 && ani.length() > 0)
            ani = ani.substring(0, ani.length() - 1);
        if(arg1 == 8 && ank.length() > 0)
            ank = ank.substring(0, ank.length() - 1);
        if(arg1 == 10 || arg1 == 13)
        {
            anj = ani;
            anl = ank;
        }
        return true;
    }

    protected void aid(int i)
    {
    }

    public final synchronized boolean aie(Event arg0, int arg1)
    {
        anf = 0;
        if(arg1 == 1006)
            ami = false;
        if(arg1 == 1007)
            amj = false;
        if(arg1 == 1004)
            amk = false;
        if(arg1 == 1005)
            aml = false;
        if((char)arg1 == ' ')
            amm = false;
        if((char)arg1 == 'n' || (char)arg1 == 'm')
            amn = false;
        if((char)arg1 == 'N' || (char)arg1 == 'M')
            amn = false;
        if((char)arg1 == '{')
            amg = false;
        if((char)arg1 == '}')
            amh = false;
        return true;
    }

    public final synchronized boolean aif(Event arg0, int arg1, int arg2)
    {
        anb = arg1;
        anc = arg2 + alh;
        and = 0;
        ali = 0;
        return true;
    }

    public final synchronized boolean aig(Event arg0, int arg1, int arg2)
    {
        anb = arg1;
        anc = arg2 + alh;
        and = 0;
        return true;
    }

    public final synchronized boolean aih(Event arg0, int arg1, int arg2)
    {
        anb = arg1;
        anc = arg2 + alh;
        if(arg0.metaDown())
            and = 2;
        else
            and = 1;
        ane = and;
        ali = 0;
        aii(and, arg1, arg2);
        return true;
    }

    protected void aii(int i, int k, int l)
    {
    }

    public final synchronized boolean aij(Event arg0, int arg1, int arg2)
    {
        anb = arg1;
        anc = arg2 + alh;
        if(arg0.metaDown())
            and = 2;
        else
            and = 1;
        return true;
    }

    public final void init()
    {
        ale = true;
        System.out.println("Started applet");
        akl = 512;
        akm = 344;
        alj = 1;
        t.bak = getCodeBase();
        akc(this);
    }

    public final void start()
    {
        if(alf >= 0)
            alf = 0;
    }

    public final void stop()
    {
        if(alf >= 0)
            alf = 4000 / ala;
    }

    public final void destroy()
    {
        alf = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception _ex) { }
        if(alf == -1)
        {
            System.out.println("5 seconds expired, forcing kill");
            aja();
            if(akn != null)
            {
                akn.stop();
                akn = null;
            }
        }
    }

    private final void aja()
    {
        alf = -2;
        System.out.println("Closing program");
        ahj();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(ald != null)
            ald.dispose();
        if(!ale)
            System.exit(0);
    }

    public final void run()
    {
        if(alj == 1)
        {
            alj = 2;
            ame = ajk();
            aje();
            ajf(0, "Loading...");
            ahh();
            alj = 0;
        }
        int i = 0;
        int k = 256;
        int i1 = 1;
        int j1 = 0;
        for(int k1 = 0; k1 < 10; k1++)
            alc[k1] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while(alf >= 0) 
        {
            if(alf > 0)
            {
                alf--;
                if(alf == 0)
                {
                    aja();
                    akn = null;
                    return;
                }
            }
            int i2 = k;
            int j2 = i1;
            k = 300;
            i1 = 1;
            long l1 = System.currentTimeMillis();
            if(alc[i] == 0L)
            {
                k = i2;
                i1 = j2;
            } else
            if(l1 > alc[i])
                k = (int)((long)(2560 * ala) / (l1 - alc[i]));
            if(k < 25)
                k = 25;
            if(k > 256)
            {
                k = 256;
                i1 = (int)((long)ala - (l1 - alc[i]) / 10L);
                if(i1 < ana)
                    i1 = ana;
            }
            try
            {
                Thread.sleep(i1);
            }
            catch(InterruptedException _ex) { }
            alc[i] = l1;
            i = (i + 1) % 10;
            if(i1 > 1)
            {
                for(int k2 = 0; k2 < 10; k2++)
                    if(alc[k2] != 0L)
                        alc[k2] += i1;

            }
            int l2 = 0;
            while(j1 < 256) 
            {
                ahi();
                j1 += k;
                if(++l2 > alb)
                {
                    j1 = 0;
                    alg += 6;
                    if(alg > 25)
                    {
                        alg = 0;
                        anh = true;
                    }
                    break;
                }
            }
            alg--;
            j1 &= 0xff;
            ahk();
        }
        if(alf == -1)
            aja();
        akn = null;
    }

    public final void ajc(Graphics arg0)
    {
        ajd(arg0);
    }

    public final void ajd(Graphics arg0)
    {
        if(alj == 2 && amd != null)
        {
            ajf(alm, aln);
            return;
        }
        if(alj == 0)
            ahl();
    }

    private final void aje()
    {
        ame.setColor(Color.black);
        ame.fillRect(0, 0, akl, akm);
        byte abyte0[] = ajj("jagex.jag", "Jagex library", 0);
        if(abyte0 == null)
        {
            return;
        } else
        {
            byte abyte1[] = t.ank("logo.tga", 0, abyte0);
            amd = aji(abyte1);
            j.bdh("h11p", 0, this);
            j.bdh("h12b", 1, this);
            j.bdh("h12p", 2, this);
            j.bdh("h13b", 3, this);
            j.bdh("h14b", 4, this);
            j.bdh("h16b", 5, this);
            j.bdh("h20b", 6, this);
            j.bdh("h24b", 7, this);
            return;
        }
    }

    private final void ajf(int arg0, String arg1)
    {
        try
        {
            int i = (akl - 281) / 2;
            int k = (akm - 148) / 2;
            ame.setColor(Color.black);
            ame.fillRect(0, 0, akl, akm);
            if(!all)
                ame.drawImage(amd, i, k, this);
            i += 2;
            k += 90;
            alm = arg0;
            aln = arg1;
            ame.setColor(new Color(132, 132, 132));
            if(all)
                ame.setColor(new Color(220, 0, 0));
            ame.drawRect(i - 2, k - 2, 280, 23);
            ame.fillRect(i, k, (277 * arg0) / 100, 20);
            ame.setColor(new Color(198, 198, 198));
            if(all)
                ame.setColor(new Color(255, 255, 255));
            ajh(ame, arg1, ama, i + 138, k + 10);
            if(!all)
            {
                ajh(ame, "Created by JAGeX - visit www.jagex.com", amb, i + 138, k + 30);
                ajh(ame, "\2512001-2002 Andrew Gower and Jagex Ltd", amb, i + 138, k + 44);
            } else
            {
                ame.setColor(new Color(132, 132, 152));
                ajh(ame, "\2512001-2002 Andrew Gower and Jagex Ltd", amc, i + 138, akm - 20);
            }
            if(alk != null)
            {
                ame.setColor(Color.white);
                ajh(ame, alk, amb, i + 138, k - 120);
                return;
            }
        }
        catch(Exception _ex) { }
    }

    protected final void ajg(int arg0, String arg1)
    {
        try
        {
            int i = (akl - 281) / 2;
            int k = (akm - 148) / 2;
            i += 2;
            k += 90;
            alm = arg0;
            aln = arg1;
            int l = (277 * arg0) / 100;
            ame.setColor(new Color(132, 132, 132));
            if(all)
                ame.setColor(new Color(220, 0, 0));
            ame.fillRect(i, k, l, 20);
            ame.setColor(Color.black);
            ame.fillRect(i + l, k, 277 - l, 20);
            ame.setColor(new Color(198, 198, 198));
            if(all)
                ame.setColor(new Color(255, 255, 255));
            ajh(ame, arg1, ama, i + 138, k + 10);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    protected final void ajh(Graphics arg0, String arg1, Font arg2, int arg3, int arg4)
    {
        Object obj;
        if(ald == null)
            obj = this;
        else
            obj = ald;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(arg2);
        fontmetrics.stringWidth(arg1);
        arg0.setFont(arg2);
        arg0.drawString(arg1, arg3 - fontmetrics.stringWidth(arg1) / 2, arg4 + fontmetrics.getHeight() / 4);
    }

    private final Image aji(byte arg0[])
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

    protected byte[] ajj(String arg0, String arg1, int arg2)
    {
        System.out.println("Using default load");
        int i = 0;
        int k = 0;
        byte abyte0[] = null;
        try
        {
            ajg(arg2, "Loading " + arg1 + " - 0%");
            java.io.InputStream inputstream = t.amj(arg0);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            i = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            ajg(arg2, "Loading " + arg1 + " - 5%");
            int l = 0;
            abyte0 = new byte[k];
            while(l < k) 
            {
                int i1 = k - l;
                if(i1 > 1000)
                    i1 = 1000;
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                ajg(arg2, "Loading " + arg1 + " - " + (5 + (l * 95) / k) + "%");
            }
            datainputstream.close();
        }
        catch(IOException _ex) { }
        ajg(arg2, "Unpacking " + arg1);
        if(k != i)
        {
            byte abyte1[] = new byte[i];
            g.cba(abyte1, i, abyte0, k, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public Graphics ajk()
    {
        if(ald != null)
            return ald.ada();
        else
            return super.getGraphics();
    }

    public Image ajl(int arg0, int arg1)
    {
        if(ald != null)
            return ald.createImage(arg0, arg1);
        else
            return super.createImage(arg0, arg1);
    }

    public URL getCodeBase()
    {
        return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        return super.getDocumentBase();
    }

    public String getParameter(String arg0)
    {
        return super.getParameter(arg0);
    }

    protected Socket akb(String arg0, int arg1)
        throws IOException
    {
        Socket socket;
        if(ahn())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket = new Socket(InetAddress.getByName(arg0), arg1);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected void akc(Runnable arg0)
    {
        Thread thread = new Thread(arg0);
        thread.setDaemon(true);
        thread.start();
    }

    public a()
    {
        akl = 512;
        akm = 384;
        ala = 20;
        alb = 1000;
        alc = new long[10];
        alj = 1;
        all = false;
        aln = "Loading";
        ama = new Font("TimesRoman", 0, 15);
        amb = new Font("Helvetica", 1, 13);
        amc = new Font("Helvetica", 0, 12);
        amg = false;
        amh = false;
        ami = false;
        amj = false;
        amk = false;
        aml = false;
        amm = false;
        amn = false;
        ana = 1;
        anh = false;
        ani = "";
        anj = "";
        ank = "";
        anl = "";
    }

    private int akl;
    private int akm;
    private Thread akn;
    private int ala;
    private int alb;
    private long alc[];
    public static c ald = null;
    private boolean ale;
    private int alf;
    private int alg;
    public int alh;
    public int ali;
    public int alj;
    public String alk;
    private boolean all;
    private int alm;
    private String aln;
    private Font ama;
    private Font amb;
    private Font amc;
    private Image amd;
    private Graphics ame;
    private static String amf = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public boolean amg;
    public boolean amh;
    public boolean ami;
    public boolean amj;
    public boolean amk;
    public boolean aml;
    public boolean amm;
    public boolean amn;
    public int ana;
    public int anb;
    public int anc;
    public int and;
    public int ane;
    public int anf;
    public int ang;
    public boolean anh;
    public String ani;
    public String anj;
    public String ank;
    public String anl;

}