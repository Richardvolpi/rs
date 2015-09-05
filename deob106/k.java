// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import jagex.n;
import jagex.o;
import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;

// Referenced classes of package jagex.client:
//            d, i

public class k extends Applet
    implements Runnable
{

    public void lj()
    {
    }

    public synchronized void rj()
    {
    }

    public void yj()
    {
    }

    public synchronized void xj()
    {
    }

    public void gk()
    {
    }

    public final void hj(int j, int l, String s, boolean flag)
    {
        up = false;
        System.out.println("Started application");
        np = j;
        op = l;
        tp = new d(this, j, l, s, flag, false);
        zp = 1;
        pp = new Thread(this);
        pp.start();
        pp.setPriority(1);
    }

    public final boolean ek()
    {
        return up;
    }

    public final void tj(int j, int l, String s, boolean flag)
    {
        if(tp != null)
        {
            return;
        } else
        {
            np = j;
            op = l;
            tp = new d(this, j, l, s, flag, up);
            return;
        }
    }

    public final void ij(int j, int l)
    {
        if(tp == null)
        {
            return;
        } else
        {
            tp.resize(j, l);
            np = j;
            op = l;
            return;
        }
    }

    public final void kj(Image image)
    {
        if(tp == null)
        {
            return;
        } else
        {
            tp.setIconImage(image);
            return;
        }
    }

    public void ak(int j, int l)
    {
        ij(j, l);
    }

    public final Graphics getGraphics()
    {
        if(tp == null)
            return super.getGraphics();
        else
            return tp.getGraphics();
    }

    public final int sj()
    {
        return np;
    }

    public final int ck()
    {
        return op;
    }

    public final Image createImage(int j, int l)
    {
        if(tp == null)
            return super.createImage(j, l);
        else
            return tp.createImage(j, l);
    }

    public Frame wj()
    {
        return tp;
    }

    public final void zj(int j)
    {
        qp = 1000 / j;
    }

    public final void bk(int j)
    {
        rp = j;
    }

    public final void dk()
    {
        for(int j = 0; j < 10; j++)
            sp[j] = 0L;

    }

    public synchronized boolean keyDown(Event event, int j)
    {
        fk(j);
        wq = j;
        xq = j;
        yp = 0;
        if(j == 1006)
            lq = true;
        if(j == 1007)
            mq = true;
        if(j == 1004)
            nq = true;
        if(j == 1005)
            oq = true;
        if((char)j == ' ')
            pq = true;
        if((char)j == 'n' || (char)j == 'm')
            qq = true;
        if((char)j == 'N' || (char)j == 'M')
            qq = true;
        if((char)j == '{')
            jq = true;
        if((char)j == '}')
            kq = true;
        if((char)j == '\u03F0')
            yq = !yq;
        if((j >= 97 && j <= 122 || j >= 65 && j <= 90 || j >= 48 && j <= 57 || j == 32) && zq.length() < 20)
            zq += (char)j;
        if(j >= 32 && j <= 122 && br.length() < 80)
            br += (char)j;
        if(j == 8 && zq.length() > 0)
            zq = zq.substring(0, zq.length() - 1);
        if(j == 8 && br.length() > 0)
            br = br.substring(0, br.length() - 1);
        if(j == 10 || j == 13)
        {
            ar = zq;
            cr = br;
        }
        return true;
    }

    public void fk(int j)
    {
    }

    public synchronized boolean keyUp(Event event, int j)
    {
        wq = 0;
        if(j == 1006)
            lq = false;
        if(j == 1007)
            mq = false;
        if(j == 1004)
            nq = false;
        if(j == 1005)
            oq = false;
        if((char)j == ' ')
            pq = false;
        if((char)j == 'n' || (char)j == 'm')
            qq = false;
        if((char)j == 'N' || (char)j == 'M')
            qq = false;
        if((char)j == '{')
            jq = false;
        if((char)j == '}')
            kq = false;
        return true;
    }

    public synchronized boolean mouseMove(Event event, int j, int l)
    {
        sq = j;
        tq = l + xp;
        uq = 0;
        yp = 0;
        return true;
    }

    public synchronized boolean mouseUp(Event event, int j, int l)
    {
        sq = j;
        tq = l + xp;
        uq = 0;
        return true;
    }

    public synchronized boolean mouseDown(Event event, int j, int l)
    {
        sq = j;
        tq = l + xp;
        if(event.metaDown())
            uq = 2;
        else
            uq = 1;
        vq = uq;
        yp = 0;
        qj(uq, j, l);
        return true;
    }

    public void qj(int j, int l, int i1)
    {
    }

    public synchronized boolean mouseDrag(Event event, int j, int l)
    {
        sq = j;
        tq = l + xp;
        if(event.metaDown())
            uq = 2;
        else
            uq = 1;
        return true;
    }

    public final void init()
    {
        up = true;
        System.out.println("Started applet");
        np = size().width;
        op = size().height;
        zp = 1;
        o.qfb = getCodeBase();
        pp = new Thread(this);
        pp.start();
    }

    public final void start()
    {
        if(vp >= 0)
            vp = 0;
    }

    public final void stop()
    {
        if(vp >= 0)
            vp = 4000 / qp;
    }

    public final void destroy()
    {
        vp = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception _ex) { }
        if(vp == -1)
        {
            System.out.println("5 seconds expired, forcing kill");
            nj();
            if(pp != null)
            {
                pp.stop();
                pp = null;
            }
        }
    }

    public final void nj()
    {
        vp = -2;
        System.out.println("Closing program");
        yj();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(tp != null)
            tp.dispose();
        if(!up)
            System.exit(0);
    }

    public final void run()
    {
        if(zp == 1)
        {
            zp = 2;
            iq = getGraphics();
            pj();
            vj(0, "Loading...");
            lj();
            zp = 0;
        }
        int j = 0;
        int i1 = 256;
        int j1 = 1;
        int k1 = 0;
        for(int i2 = 0; i2 < 10; i2++)
            sp[i2] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while(vp >= 0) 
        {
            if(vp > 0)
            {
                vp--;
                if(vp == 0)
                {
                    nj();
                    pp = null;
                    return;
                }
            }
            int j2 = i1;
            int k2 = j1;
            i1 = 300;
            j1 = 1;
            long l1 = System.currentTimeMillis();
            if(sp[j] == 0L)
            {
                i1 = j2;
                j1 = k2;
            } else
            if(l1 > sp[j])
                i1 = (int)((long)(2560 * qp) / (l1 - sp[j]));
            if(i1 < 25)
                i1 = 25;
            if(i1 > 256)
            {
                i1 = 256;
                j1 = (int)((long)qp - (l1 - sp[j]) / 10L);
                if(j1 < rq)
                    j1 = rq;
            }
            try
            {
                Thread.sleep(j1);
            }
            catch(InterruptedException _ex) { }
            sp[j] = l1;
            j = (j + 1) % 10;
            if(j1 > 1)
            {
                for(int l2 = 0; l2 < 10; l2++)
                    if(sp[l2] != 0L)
                        sp[l2] += j1;

            }
            int i3 = 0;
            while(k1 < 256) 
            {
                rj();
                k1 += i1;
                if(++i3 > rp)
                {
                    k1 = 0;
                    wp += 6;
                    if(wp > 25)
                    {
                        wp = 0;
                        yq = true;
                    }
                    break;
                }
            }
            wp--;
            k1 &= 0xff;
            xj();
            dr = (1000 * i1) / (qp * 256);
            if(up && j == 0)
                showStatus("Fps:" + dr + "Del:" + j1);
            if(tp != null && (tp.c() != np || tp.d() != op))
                ak(tp.c(), tp.d());
        }
        if(vp == -1)
            nj();
        pp = null;
    }

    public final void update(Graphics g)
    {
        paint(g);
    }

    public final void paint(Graphics g)
    {
        if(zp == 2 && hq != null)
        {
            vj(cq, dq);
            return;
        }
        if(zp == 0)
            gk();
    }

    public void pj()
    {
        try
        {
            byte abyte0[] = o.pn("jagex.jag");
            byte abyte1[] = o.ln("logo.tga", 0, abyte0);
            hq = oj(abyte1);
            i.lf(o.ln("h11p.jf", 0, abyte0));
            i.lf(o.ln("h12b.jf", 0, abyte0));
            i.lf(o.ln("h12p.jf", 0, abyte0));
            i.lf(o.ln("h13b.jf", 0, abyte0));
            i.lf(o.ln("h14b.jf", 0, abyte0));
            i.lf(o.ln("h16b.jf", 0, abyte0));
            i.lf(o.ln("h20b.jf", 0, abyte0));
            i.lf(o.ln("h24b.jf", 0, abyte0));
            return;
        }
        catch(IOException _ex)
        {
            System.out.println("Error loading jagex.dat");
        }
    }

    public void vj(int j, String s)
    {
        int l = (np - 281) / 2;
        int i1 = (op - 148) / 2;
        iq.setColor(Color.black);
        iq.fillRect(0, 0, np, op);
        if(!bq)
            iq.drawImage(hq, l, i1, this);
        l += 2;
        i1 += 90;
        cq = j;
        dq = s;
        iq.setColor(new Color(132, 132, 132));
        if(bq)
            iq.setColor(new Color(220, 0, 0));
        iq.drawRect(l - 2, i1 - 2, 280, 23);
        iq.fillRect(l, i1, (277 * j) / 100, 20);
        iq.setColor(new Color(198, 198, 198));
        if(bq)
            iq.setColor(new Color(255, 255, 255));
        mj(iq, s, eq, l + 138, i1 + 10);
        if(!bq)
        {
            mj(iq, "Created by JAGeX - visit www.jagex.com", fq, l + 138, i1 + 30);
            mj(iq, "Copyright \2512000 Andrew Gower", fq, l + 138, i1 + 44);
        } else
        {
            iq.setColor(new Color(132, 132, 152));
            mj(iq, "Copyright \2512000 Andrew Gower", gq, l + 138, op - 20);
        }
        if(aq != null)
        {
            iq.setColor(Color.white);
            mj(iq, aq, fq, l + 138, i1 - 120);
        }
    }

    public void uj(int j, String s)
    {
        int l = (np - 281) / 2;
        int i1 = (op - 148) / 2;
        l += 2;
        i1 += 90;
        cq = j;
        dq = s;
        int j1 = (277 * j) / 100;
        iq.setColor(new Color(132, 132, 132));
        if(bq)
            iq.setColor(new Color(220, 0, 0));
        iq.fillRect(l, i1, j1, 20);
        iq.setColor(Color.black);
        iq.fillRect(l + j1, i1, 277 - j1, 20);
        iq.setColor(new Color(198, 198, 198));
        if(bq)
            iq.setColor(new Color(255, 255, 255));
        mj(iq, s, eq, l + 138, i1 + 10);
    }

    public void mj(Graphics g, String s, Font font, int j, int l)
    {
        Object obj;
        if(tp == null)
            obj = this;
        else
            obj = tp;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
        fontmetrics.stringWidth(s);
        g.setFont(font);
        g.drawString(s, j - fontmetrics.stringWidth(s) / 2, l + fontmetrics.getHeight() / 4);
    }

    public Image oj(byte abyte0[])
    {
        int j = abyte0[13] * 256 + abyte0[12];
        int l = abyte0[15] * 256 + abyte0[14];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        byte abyte3[] = new byte[256];
        for(int i1 = 0; i1 < 256; i1++)
        {
            abyte1[i1] = abyte0[20 + i1 * 3];
            abyte2[i1] = abyte0[19 + i1 * 3];
            abyte3[i1] = abyte0[18 + i1 * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
        byte abyte4[] = new byte[j * l];
        int j1 = 0;
        for(int k1 = l - 1; k1 >= 0; k1--)
        {
            for(int l1 = 0; l1 < j; l1++)
                abyte4[j1++] = abyte0[786 + l1 + k1 * j];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(j, l, indexcolormodel, abyte4, 0, j);
        Image image = createImage(memoryimagesource);
        return image;
    }

    public byte[] jj(String s, String s1, int j)
        throws IOException
    {
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        byte abyte0[] = null;
        while(l < 2) 
            try
            {
                uj(j, "Loading " + s1 + " - 0%");
                if(l == 1)
                    s = s.toUpperCase();
                java.io.InputStream inputstream = o.jn(s);
                DataInputStream datainputstream = new DataInputStream(inputstream);
                byte abyte2[] = new byte[6];
                datainputstream.readFully(abyte2, 0, 6);
                i1 = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
                j1 = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
                uj(j, "Loading " + s1 + " - 5%");
                int k1 = 0;
                abyte0 = new byte[j1];
                while(k1 < j1) 
                {
                    int l1 = j1 - k1;
                    if(l1 > 1000)
                        l1 = 1000;
                    datainputstream.readFully(abyte0, k1, l1);
                    k1 += l1;
                    uj(j, "Loading " + s1 + " - " + (5 + (k1 * 95) / j1) + "%");
                }
                l = 2;
                datainputstream.close();
            }
            catch(IOException _ex)
            {
                l++;
            }
        uj(j, "Unpacking " + s1);
        if(j1 != i1)
        {
            byte abyte1[] = new byte[i1];
            n.ik(abyte1, i1, abyte0, j1, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public k()
    {
        np = 512;
        op = 384;
        qp = 20;
        rp = 1000;
        sp = new long[10];
        zp = 1;
        bq = false;
        dq = "Loading";
        eq = new Font("TimesRoman", 0, 15);
        fq = new Font("Helvetica", 1, 13);
        gq = new Font("Helvetica", 0, 12);
        jq = false;
        kq = false;
        lq = false;
        mq = false;
        nq = false;
        oq = false;
        pq = false;
        qq = false;
        rq = 1;
        yq = false;
        zq = "";
        ar = "";
        br = "";
        cr = "";
    }

    private int np;
    private int op;
    private Thread pp;
    private int qp;
    private int rp;
    private long sp[];
    static d tp = null;
    private boolean up;
    private int vp;
    private int wp;
    public int xp;
    public int yp;
    public int zp;
    public String aq;
    private boolean bq;
    private int cq;
    private String dq;
    private Font eq;
    private Font fq;
    private Font gq;
    private Image hq;
    private Graphics iq;
    public boolean jq;
    public boolean kq;
    public boolean lq;
    public boolean mq;
    public boolean nq;
    public boolean oq;
    public boolean pq;
    public boolean qq;
    public int rq;
    public int sq;
    public int tq;
    public int uq;
    public int vq;
    public int wq;
    public int xq;
    public boolean yq;
    public String zq;
    public String ar;
    public String br;
    public String cr;
    public int dr;

}
