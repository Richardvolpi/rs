// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;

public class Applet_Sub1 extends Applet
    implements Runnable
{

    public Applet_Sub1()
    {
        anInt1 = 512;
        anInt2 = 384;
        anInt4 = 20;
        anInt5 = 1000;
        aLongArray6 = new long[10];
        anInt13 = 1;
        aBoolean15 = false;
        aString17 = "Loading";
        aFont18 = new Font("TimesRoman", 0, 15);
        aFont19 = new Font("Helvetica", 1, 13);
        aFont20 = new Font("Helvetica", 0, 12);
        aBoolean24 = false;
        aBoolean25 = false;
        aBoolean26 = false;
        aBoolean27 = false;
        aBoolean28 = false;
        aBoolean29 = false;
        aBoolean30 = false;
        aBoolean31 = false;
        anInt32 = 1;
        aBoolean39 = false;
        aString40 = "";
        aString41 = "";
        aString42 = "";
        aString43 = "";
    }

    public Image createImage(int i, int j)
    {
        if(aFrame_Sub1_7 != null)
            return aFrame_Sub1_7.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public final void destroy()
    {
        anInt9 = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception _ex) { }
        if(anInt9 == -1)
        {
            System.out.println("5 seconds expired, forcing kill");
            method12();
            if(aThread3 != null)
            {
                aThread3.stop();
                aThread3 = null;
            }
        }
    }

    public URL getCodeBase()
    {
        return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        return super.getDocumentBase();
    }

    public Graphics getGraphics()
    {
        if(aFrame_Sub1_7 != null)
            return aFrame_Sub1_7.getGraphics();
        else
            return super.getGraphics();
    }

    public String getParameter(String s)
    {
        return super.getParameter(s);
    }

    public final void init()
    {
        aBoolean8 = true;
        System.out.println("Started applet");
        anInt1 = 512;
        anInt2 = 344;
        anInt13 = 1;
        Class15.anURL554 = getCodeBase();
        method20(this);
    }

    public final synchronized boolean keyDown(Event event, int i)
    {
        int k = Class6.anInt352;
        method10(i);
        anInt37 = i;
        anInt38 = i;
        anInt12 = 0;
        if(i == 1006)
            aBoolean26 = true;
        if(i == 1007)
            aBoolean27 = true;
        if(i == 1004)
            aBoolean28 = true;
        if(i == 1005)
            aBoolean29 = true;
        if((char)i == ' ')
            aBoolean30 = true;
        if((char)i == 'n' || (char)i == 'm')
            aBoolean31 = true;
        if((char)i == 'N' || (char)i == 'M')
            aBoolean31 = true;
        if((char)i == '{')
            aBoolean24 = true;
        if((char)i == '}')
            aBoolean25 = true;
        if((char)i == '\u03F0')
            aBoolean39 = !aBoolean39;
        boolean flag = false;
        for(int j = 0; j < aString23.length(); j++)
        {
            if(i != aString23.charAt(j))
                continue;
            flag = true;
            break;
        }

        if(flag && aString40.length() < 20)
            aString40 += (char)i;
        if(flag && aString42.length() < 80)
            aString42 += (char)i;
        if(i == 8 && aString40.length() > 0)
            aString40 = aString40.substring(0, aString40.length() - 1);
        if(i == 8 && aString42.length() > 0)
            aString42 = aString42.substring(0, aString42.length() - 1);
        if(i == 10 || i == 13)
        {
            aString41 = aString40;
            aString43 = aString42;
        }
        return true;
    }

    public final synchronized boolean keyUp(Event event, int i)
    {
        anInt37 = 0;
        if(i == 1006)
            aBoolean26 = false;
        if(i == 1007)
            aBoolean27 = false;
        if(i == 1004)
            aBoolean28 = false;
        if(i == 1005)
            aBoolean29 = false;
        if((char)i == ' ')
            aBoolean30 = false;
        if((char)i == 'n' || (char)i == 'm')
            aBoolean31 = false;
        if((char)i == 'N' || (char)i == 'M')
            aBoolean31 = false;
        if((char)i == '{')
            aBoolean24 = false;
        if((char)i == '}')
            aBoolean25 = false;
        return true;
    }

    protected void method1()
    {
    }

    protected void method10(int i)
    {
    }

    protected void method11(int i, int j, int k)
    {
    }

    private final void method12()
    {
        anInt9 = -2;
        System.out.println("Closing program");
        method3();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception _ex) { }
        if(aFrame_Sub1_7 != null)
            aFrame_Sub1_7.dispose();
        if(!aBoolean8)
            System.exit(0);
    }

    private final void method13()
    {
        aGraphics22.setColor(Color.black);
        aGraphics22.fillRect(0, 0, anInt1, anInt2);
        byte abyte0[] = method18("jagex.jag", "Jagex library", 0);
        if(abyte0 == null)
        {
            return;
        } else
        {
            byte abyte1[] = Class15.method366("logo.tga", 0, abyte0);
            anImage21 = method17(abyte1);
            Class6.method252("h11p", 0, this);
            Class6.method252("h12b", 1, this);
            Class6.method252("h12p", 2, this);
            Class6.method252("h13b", 3, this);
            Class6.method252("h14b", 4, this);
            Class6.method252("h16b", 5, this);
            Class6.method252("h20b", 6, this);
            Class6.method252("h24b", 7, this);
            return;
        }
    }

    private final void method14(int i, String s)
    {
        try
        {
            int j = (anInt1 - 281) / 2;
            int k = (anInt2 - 148) / 2;
            aGraphics22.setColor(Color.black);
            aGraphics22.fillRect(0, 0, anInt1, anInt2);
            if(!aBoolean15)
                aGraphics22.drawImage(anImage21, j, k, this);
            j += 2;
            k += 90;
            anInt16 = i;
            aString17 = s;
            aGraphics22.setColor(new Color(132, 132, 132));
            if(aBoolean15)
                aGraphics22.setColor(new Color(220, 0, 0));
            aGraphics22.drawRect(j - 2, k - 2, 280, 23);
            aGraphics22.fillRect(j, k, (277 * i) / 100, 20);
            aGraphics22.setColor(new Color(198, 198, 198));
            if(aBoolean15)
                aGraphics22.setColor(new Color(255, 255, 255));
            method16(aGraphics22, s, aFont18, j + 138, k + 10);
            if(!aBoolean15)
            {
                method16(aGraphics22, "Created by JAGeX - visit www.jagex.com", aFont19, j + 138, k + 30);
                method16(aGraphics22, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont19, j + 138, k + 44);
            } else
            {
                aGraphics22.setColor(new Color(132, 132, 152));
                method16(aGraphics22, "\2512001-2002 Andrew Gower and Jagex Ltd", aFont20, j + 138, anInt2 - 20);
            }
            if(aString14 != null)
            {
                aGraphics22.setColor(Color.white);
                method16(aGraphics22, aString14, aFont19, j + 138, k - 120);
                return;
            }
        }
        catch(Exception _ex) { }
    }

    protected final void method15(int i, String s)
    {
        try
        {
            int j = (anInt1 - 281) / 2;
            int k = (anInt2 - 148) / 2;
            j += 2;
            k += 90;
            anInt16 = i;
            aString17 = s;
            int l = (277 * i) / 100;
            aGraphics22.setColor(new Color(132, 132, 132));
            if(aBoolean15)
                aGraphics22.setColor(new Color(220, 0, 0));
            aGraphics22.fillRect(j, k, l, 20);
            aGraphics22.setColor(Color.black);
            aGraphics22.fillRect(j + l, k, 277 - l, 20);
            aGraphics22.setColor(new Color(198, 198, 198));
            if(aBoolean15)
                aGraphics22.setColor(new Color(255, 255, 255));
            method16(aGraphics22, s, aFont18, j + 138, k + 10);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    protected final void method16(Graphics g, String s, Font font, int i, int j)
    {
        Object obj;
        if(aFrame_Sub1_7 == null)
            obj = this;
        else
            obj = aFrame_Sub1_7;
        FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
        fontmetrics.stringWidth(s);
        g.setFont(font);
        g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
    }

    private final Image method17(byte abyte0[])
    {
        int k1 = Class6.anInt352;
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

    protected byte[] method18(String s, String s1, int i)
    {
        int j = 0;
        int k = 0;
        byte abyte0[] = null;
        try
        {
            method15(i, "Loading " + s1 + " - 0%");
            java.io.InputStream inputstream = Class15.method351(s);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            j = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            method15(i, "Loading " + s1 + " - 5%");
            int l = 0;
            abyte0 = new byte[k];
            while(l < k) 
            {
                int i1 = k - l;
                if(i1 > 1000)
                    i1 = 1000;
                datainputstream.readFully(abyte0, l, i1);
                l += i1;
                method15(i, "Loading " + s1 + " - " + (5 + (l * 95) / k) + "%");
            }
            datainputstream.close();
        }
        catch(IOException _ex) { }
        method15(i, "Unpacking " + s1);
        if(k != j)
        {
            byte abyte1[] = new byte[j];
            Class3.method130(abyte1, j, abyte0, k, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    protected Socket method19(String s, int i)
        throws IOException
    {
        Socket socket;
        if(method7())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    protected synchronized void method2()
    {
    }

    protected void method20(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    protected void method3()
    {
    }

    protected synchronized void method4()
    {
    }

    protected void method5()
    {
    }

    protected final void method6(int i, int j, String s, boolean flag)
    {
        aBoolean8 = true;
        System.out.println("Started application");
        anInt1 = i;
        anInt2 = j;
        aFrame_Sub1_7 = new Frame_Sub1(this, i, j, s, flag, false);
        anInt13 = 1;
        aThread3 = new Thread(this);
        aThread3.start();
        aThread3.setPriority(1);
    }

    protected final boolean method7()
    {
        return aBoolean8;
    }

    protected final void method8(int i)
    {
        anInt4 = 1000 / i;
    }

    protected final void method9()
    {
        for(int i = 0; i < 10; i++)
            aLongArray6[i] = 0L;

    }

    public final synchronized boolean mouseDown(Event event, int i, int j)
    {
        anInt33 = i;
        anInt34 = j + anInt11;
        if(event.metaDown())
            anInt35 = 2;
        else
            anInt35 = 1;
        anInt36 = anInt35;
        anInt12 = 0;
        method11(anInt35, i, j);
        return true;
    }

    public final synchronized boolean mouseDrag(Event event, int i, int j)
    {
        anInt33 = i;
        anInt34 = j + anInt11;
        if(event.metaDown())
            anInt35 = 2;
        else
            anInt35 = 1;
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i, int j)
    {
        anInt33 = i;
        anInt34 = j + anInt11;
        anInt35 = 0;
        anInt12 = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i, int j)
    {
        anInt33 = i;
        anInt34 = j + anInt11;
        anInt35 = 0;
        return true;
    }

    public final void paint(Graphics g)
    {
        if(anInt13 == 2 && anImage21 != null)
        {
            method14(anInt16, aString17);
            return;
        }
        if(anInt13 == 0)
            method5();
    }

    public final void run()
    {
        int l2 = Class6.anInt352;
        if(anInt13 == 1)
        {
            anInt13 = 2;
            aGraphics22 = getGraphics();
            method13();
            method14(0, "Loading...");
            method1();
            anInt13 = 0;
        }
        int i = 0;
        int j = 256;
        int k = 1;
        int i1 = 0;
        for(int j1 = 0; j1 < 10; j1++)
            aLongArray6[j1] = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        while(anInt9 >= 0) 
        {
            if(anInt9 > 0)
            {
                anInt9--;
                if(anInt9 == 0)
                {
                    method12();
                    aThread3 = null;
                    return;
                }
            }
            int k1 = j;
            int i2 = k;
            j = 300;
            k = 1;
            long l1 = System.currentTimeMillis();
            if(aLongArray6[i] == 0L)
            {
                j = k1;
                k = i2;
            } else
            if(l1 > aLongArray6[i])
                j = (int)((long)(2560 * anInt4) / (l1 - aLongArray6[i]));
            if(j < 25)
                j = 25;
            if(j > 256)
            {
                j = 256;
                k = (int)((long)anInt4 - (l1 - aLongArray6[i]) / 10L);
                if(k < anInt32)
                    k = anInt32;
            }
            try
            {
                Thread.sleep(k);
            }
            catch(InterruptedException _ex) { }
            aLongArray6[i] = l1;
            i = (i + 1) % 10;
            if(k > 1)
            {
                for(int j2 = 0; j2 < 10; j2++)
                    if(aLongArray6[j2] != 0L)
                        aLongArray6[j2] += k;

            }
            int k2 = 0;
            while(i1 < 256) 
            {
                method2();
                i1 += j;
                if(++k2 > anInt5)
                {
                    i1 = 0;
                    anInt10 += 6;
                    if(anInt10 > 25)
                    {
                        anInt10 = 0;
                        aBoolean39 = true;
                    }
                    break;
                }
            }
            anInt10--;
            i1 &= 0xff;
            method4();
        }
        if(anInt9 == -1)
            method12();
        aThread3 = null;
    }

    public final void start()
    {
        if(anInt9 >= 0)
            anInt9 = 0;
    }

    public final void stop()
    {
        if(anInt9 >= 0)
            anInt9 = 4000 / anInt4;
    }

    public final void update(Graphics g)
    {
        paint(g);
    }

    private boolean aBoolean15;
    public boolean aBoolean24;
    public boolean aBoolean25;
    public boolean aBoolean26;
    public boolean aBoolean27;
    public boolean aBoolean28;
    public boolean aBoolean29;
    public boolean aBoolean30;
    public boolean aBoolean31;
    public boolean aBoolean39;
    private boolean aBoolean8;
    private Font aFont18;
    private Font aFont19;
    private Font aFont20;
    public static Frame_Sub1 aFrame_Sub1_7 = null;
    private Graphics aGraphics22;
    private long aLongArray6[];
    public String aString14;
    private String aString17;
    private static String aString23 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public String aString40;
    public String aString41;
    public String aString42;
    public String aString43;
    private Thread aThread3;
    private Image anImage21;
    private int anInt1;
    private int anInt10;
    public int anInt11;
    public int anInt12;
    public int anInt13;
    private int anInt16;
    private int anInt2;
    public int anInt32;
    public int anInt33;
    public int anInt34;
    public int anInt35;
    public int anInt36;
    public int anInt37;
    public int anInt38;
    private int anInt4;
    private int anInt5;
    private int anInt9;

}
