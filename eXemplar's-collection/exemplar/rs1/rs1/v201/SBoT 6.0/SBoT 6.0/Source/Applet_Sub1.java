// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/21/2004 6:52:20 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Applet_Sub1.java

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
        fln = "";
        fma = "";
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
        catch(Exception exception)
        {
            exception.toString();
        }
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
        fnf.gameServer = getCodeBase();
        method20(this);
    }

    public synchronized boolean keyDown(Event event, int i)
    {
        int j = Class6.anInt352;
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
        int k = 0;
        do
        {
            if(k >= aString23.length())
                break;
            if(i == aString23.charAt(k))
            {
                flag = true;
                break;
            }
            k++;
        } while(true);
        if(flag && fln.length() < 20)
            fln += (char)i;
        if(flag && aString42.length() < 80)
            aString42 += (char)i;
        if(i == 8 && fln.length() > 0)
            fln = fln.substring(0, fln.length() - 1);
        if(i == 8 && aString42.length() > 0)
            aString42 = aString42.substring(0, aString42.length() - 1);
        if(i == 10 || i == 13)
        {
            fma = fln;
            aString43 = aString42;
        }
        return true;
    }

    public synchronized boolean keyUp(Event event, int i)
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

    public final void method12()
    {
        anInt9 = -2;
        System.out.println("Closing program");
        method3();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception exception)
        {
            exception.toString();
        }
        if(aFrame_Sub1_7 != null)
            aFrame_Sub1_7.dispose();
        if(!aBoolean8)
            System.exit(0);
    }

    public final void method13()
    {
        aGraphics22.setColor(Color.black);
        aGraphics22.fillRect(0, 0, anInt1, anInt2);
        byte abyte0[] = method18("jagex.jag", "Jagex library", 0);
        if(abyte0 == null)
        {
            return;
        } else
        {
            byte abyte1[] = fnf.method366("logo.tga", 0, abyte0);
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

    public final void method14(int i, String s)
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
        catch(Exception exception)
        {
            exception.toString();
        }
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
        catch(Exception exception)
        {
            exception.toString();
        }
    }

    protected final void method16(Graphics g, String s, Font font, int i, int j)
    {
        Object obj;
        if(aFrame_Sub1_7 == null)
            obj = this;
        else
            obj = aFrame_Sub1_7;
        FontMetrics fontmetrics = ((Component)obj).getFontMetrics(font);
        fontmetrics.stringWidth(s);
        g.setFont(font);
        g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
    }

    public final Image method17(byte abyte0[])
    {
        int i = Class6.anInt352;
        int j = abyte0[13] * 256 + abyte0[12];
        int k = abyte0[15] * 256 + abyte0[14];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        byte abyte3[] = new byte[256];
        for(int l = 0; l < 256; l++)
        {
            abyte1[l] = abyte0[20 + l * 3];
            abyte2[l] = abyte0[19 + l * 3];
            abyte3[l] = abyte0[18 + l * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
        byte abyte4[] = new byte[j * k];
        int i1 = 0;
        for(int j1 = k - 1; j1 >= 0; j1--)
        {
            for(int k1 = 0; k1 < j; k1++)
                abyte4[i1++] = abyte0[786 + k1 + j1 * j];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(j, k, indexcolormodel, abyte4, 0, j);
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
            java.io.InputStream inputstream = fnf.method351(s);
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
        catch(IOException ioexception)
        {
            ioexception.toString();
        }
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
        aBoolean8 = false;
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
        int i = Class6.anInt352;
        if(anInt13 == 1)
        {
            anInt13 = 2;
            aGraphics22 = getGraphics();
            method13();
            method14(0, "Loading...");
            method1();
            anInt13 = 0;
        }
        int j = 0;
        int k = 256;
        int l = 1;
        int i1 = 0;
        for(int j1 = 0; j1 < 10; j1++)
            aLongArray6[j1] = System.currentTimeMillis();

        long l1 = System.currentTimeMillis();
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
            int k1 = k;
            int i2 = l;
            k = 300;
            l = 1;
            long l2 = System.currentTimeMillis();
            if(aLongArray6[j] == 0L)
            {
                k = k1;
                l = i2;
            } else
            if(l2 > aLongArray6[j])
                k = (int)((long)(2560 * anInt4) / (l2 - aLongArray6[j]));
            if(k < 25)
                k = 25;
            if(k > 256)
            {
                k = 256;
                l = (int)((long)anInt4 - (l2 - aLongArray6[j]) / 10L);
                if(l < anInt32)
                    l = anInt32;
            }
            try
            {
                Thread.sleep(l);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.toString();
            }
            aLongArray6[j] = l2;
            j = (j + 1) % 10;
            if(l > 1)
            {
                for(int j2 = 0; j2 < 10; j2++)
                    if(aLongArray6[j2] != 0L)
                        aLongArray6[j2] += l;

            }
            int k2 = 0;
            do
            {
                if(i1 >= 256)
                    break;
                method2();
                i1 += k;
                if(++k2 <= anInt5)
                    continue;
                i1 = 0;
                anInt10 += 6;
                if(anInt10 > 25)
                {
                    anInt10 = 0;
                    aBoolean39 = true;
                }
                break;
            } while(true);
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

    public boolean aBoolean15;
    public boolean aBoolean24;
    public boolean aBoolean25;
    public boolean aBoolean26;
    public boolean aBoolean27;
    public boolean aBoolean28;
    public boolean aBoolean29;
    public boolean aBoolean30;
    public boolean aBoolean31;
    public boolean aBoolean39;
    public boolean aBoolean8;
    public Font aFont18;
    public Font aFont19;
    public Font aFont20;
    public static Frame_Sub1 aFrame_Sub1_7 = null;
    public Graphics aGraphics22;
    public long aLongArray6[];
    public String aString14;
    public String aString17;
    public static String aString23 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
    public String fln;
    public String fma;
    public String aString42;
    public String aString43;
    public Thread aThread3;
    public Image anImage21;
    public int anInt1;
    public int anInt10;
    public int anInt11;
    public int anInt12;
    public int anInt13;
    public int anInt16;
    public int anInt2;
    public int anInt32;
    public int anInt33;
    public int anInt34;
    public int anInt35;
    public int anInt36;
    public int anInt37;
    public int anInt38;
    public int anInt4;
    public int anInt5;
    public int anInt9;

}