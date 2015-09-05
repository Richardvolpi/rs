// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   a.java

import java.applet.Applet;
import java.awt.*;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.net.*;

public class a extends Applet
    implements Runnable
{

    public a()
    {
        c = Toolkit.getDefaultToolkit();
        f = true;
        g = false;
        h = false;
        i = false;
        j = false;
        d = c.getImage(System.getProperty(cb[23]) + cb[20]);
        e = c.getImage(System.getProperty(cb[23]) + cb[21]);
        K = 512;
        Q = 384;
        Y = 20;
        Z = 1000;
        A = new long[10];
        O = 1;
        k = false;
        C = cb[22];
        v = new Font(cb[25], 0, 15);
        w = new Font(cb[24], 1, 13);
        x = new Font(cb[24], 0, 12);
        l = false;
        m = false;
        n = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        R = 1;
        t = false;
        E = "";
        F = "";
        G = "";
        H = "";
    }

    public static void a()
    {
        (new cb(null)).start();
        (new db(null)).start();
    }

    public static void b()
    {
        a();
    }

    public Image createImage(int i1, int j1)
    {
        if(!j)
        {
            if(y != null)
                return y.createImage(i1, j1);
            else
                return super.createImage(i1, j1);
        } else
        {
            return null;
        }
    }

    public final void destroy()
    {
        ab = -1;
        try
        {
            Thread.sleep(5000L);
        }
        catch(Exception exception) { }
        if(ab == -1)
        {
            System.out.println(cb[26]);
            d();
            if(I != null)
            {
                I.stop();
                I = null;
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
        if(y != null)
            return y.getGraphics();
        else
            return super.getGraphics();
    }

    public String getParameter(String s1)
    {
        return super.getParameter(s1);
    }

    public final void init()
    {
        u = true;
        K = 512;
        Q = 344;
        O = 1;
        m.c = getCodeBase();
        a(this);
    }

    public synchronized boolean keyDown(Event event, int i1)
    {
        boolean flag1 = v.R;
        int j1 = v.z;
        a(i1);
        W = i1;
        X = i1;
        N = 0;
        if(i1 == 1006 && g)
            h = true;
        if(i1 == 1007 && g)
            i = true;
        if(i1 == 1006 && !g)
            n = true;
        if(i1 == 1007 && !g)
            o = true;
        if(i1 == 1004)
            p = true;
        if(i1 == 1005)
            q = true;
        if((char)i1 == ' ')
            r = true;
        if((char)i1 == 'n' || (char)i1 == 'm')
            s = true;
        if((char)i1 == 'N' || (char)i1 == 'M')
            s = true;
        if((char)i1 == '{')
            l = true;
        if((char)i1 == '}')
            m = true;
        if((char)i1 == '\u03F0')
            t = !t;
        boolean flag = false;
        int k1 = 0;
        do
        {
            if(k1 >= D.length())
                break;
            if(i1 == D.charAt(k1) || flag1)
            {
                flag = true;
                if(!flag1)
                    break;
            }
            k1++;
        } while(!flag1);
        if(flag && E.length() < 20)
            E += (char)i1;
        if(flag && G.length() < 80)
            G += (char)i1;
        if(i1 == 8 && E.length() > 0)
            E = E.substring(0, E.length() - 1);
        if(i1 == 8 && G.length() > 0)
            G = G.substring(0, G.length() - 1);
        if(i1 == 10 || i1 == 13)
        {
            F = E;
            H = G;
        }
        return true;
    }

    public synchronized boolean keyUp(Event event, int i1)
    {
        W = 0;
        if(i1 == 1006 && g)
            h = false;
        if(i1 == 1007 && g)
            i = false;
        if(i1 == 1006 && !g)
            n = false;
        if(i1 == 1007 && !g)
            o = false;
        if(i1 == 1004)
            p = false;
        if(i1 == 1005)
            q = false;
        if((char)i1 == ' ')
            r = false;
        if((char)i1 == 'n' || (char)i1 == 'm')
            s = false;
        if((char)i1 == 'N' || (char)i1 == 'M')
            s = false;
        if((char)i1 == '{')
            l = false;
        if((char)i1 == '}')
            m = false;
        return true;
    }

    protected void c()
    {
    }

    protected void a(int i1)
    {
    }

    protected void a(int i1, int j1, int k1)
    {
    }

    private final void d()
    {
        ab = -2;
        g();
        try
        {
            Thread.sleep(1000L);
        }
        catch(Exception exception) { }
        if(y != null)
            y.dispose();
        if(!u)
            System.exit(0);
    }

    private final void e()
    {
        z.setColor(Color.black);
        z.fillRect(0, 0, K, Q);
        byte abyte0[] = a(cb[7], cb[10], 0);
        if(abyte0 == null)
        {
            return;
        } else
        {
            byte abyte1[] = m.a(cb[0], 0, abyte0);
            J = a(abyte1);
            v.a(cb[4], 0, this);
            v.a(cb[8], 1, this);
            v.a(cb[3], 2, this);
            v.a(cb[2], 3, this);
            v.a(cb[5], 4, this);
            v.a(cb[9], 5, this);
            v.a(cb[6], 6, this);
            v.a(cb[1], 7, this);
            return;
        }
    }

    private final void a(int i1, String s1)
    {
        try
        {
            int j1 = (K - 281) / 2;
            int k1 = (Q - 148) / 2;
            z.drawImage(d, 0, 0, this);
            z.setColor(Color.black);
            z.drawImage(d, 0, 0, this);
            z.fillRect(0, 0, K, Q);
            z.drawImage(d, 0, 0, this);
            j1 += 2;
            k1 += 90;
            P = i1;
            C = s1;
            z.setColor(new Color(15, 41, 11));
            if(k)
                z.setColor(new Color(26, 56, 20));
            z.drawRect(j1 - 2, k1 - 2, 280, 23);
            z.fillRect(j1, k1, (277 * i1) / 100, 20);
            z.setColor(new Color(15, 105, 11));
            if(k)
                z.setColor(new Color(255, 255, 255));
            a(z, s1, v, j1 + 138, k1 + 10);
            if(!k)
            {
                a(z, cb[13], w, j1 + 138, k1 + 30);
            } else
            {
                z.setColor(new Color(132, 132, 152));
                a(z, cb[12], x, j1 + 138, Q - 20);
            }
            if(B != null)
            {
                z.setColor(Color.white);
                a(z, B, w, j1 + 138, k1 - 120);
                return;
            }
        }
        catch(Exception exception) { }
    }

    protected final void b(int i1, String s1)
    {
        try
        {
            int j1 = (K - 281) / 2;
            int k1 = (Q - 148) / 2;
            j1 += 2;
            k1 += 90;
            P = i1;
            C = s1;
            int l1 = (277 * i1) / 100;
            z.setColor(new Color(15, 95, 11));
            if(k)
                z.setColor(new Color(15, 41, 11));
            z.fillRect(j1, k1, l1, 20);
            z.setColor(Color.black);
            z.fillRect(j1 + l1, k1, 277 - l1, 20);
            z.setColor(new Color(15, 41, 11));
            if(k)
                z.setColor(new Color(255, 255, 255));
            a(z, s1, v, j1 + 138, k1 + 10);
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    protected final void a(Graphics g1, String s1, Font font, int i1, int j1)
    {
        Object obj;
        if(y == null)
            obj = this;
        else
            obj = y;
        FontMetrics fontmetrics = ((Component)obj).getFontMetrics(font);
        fontmetrics.stringWidth(s1);
        g1.setFont(font);
        g1.drawString(s1, i1 - fontmetrics.stringWidth(s1) / 2, j1 + fontmetrics.getHeight() / 4);
    }

    private final Image a(byte abyte0[])
    {
        int i1 = v.z;
        int j1 = abyte0[13] * 256 + abyte0[12];
        int k1 = abyte0[15] * 256 + abyte0[14];
        byte abyte1[] = new byte[256];
        byte abyte2[] = new byte[256];
        byte abyte3[] = new byte[256];
        for(int l1 = 0; l1 < 256; l1++)
        {
            abyte1[l1] = abyte0[20 + l1 * 3];
            abyte2[l1] = abyte0[19 + l1 * 3];
            abyte3[l1] = abyte0[18 + l1 * 3];
        }

        IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
        byte abyte4[] = new byte[j1 * k1];
        int i2 = 0;
        for(int j2 = k1 - 1; j2 >= 0; j2--)
        {
            for(int k2 = 0; k2 < j1; k2++)
                abyte4[i2++] = abyte0[786 + k2 + j2 * j1];

        }

        MemoryImageSource memoryimagesource = new MemoryImageSource(j1, k1, indexcolormodel, abyte4, 0, j1);
        Image image = createImage(memoryimagesource);
        return image;
    }

    protected byte[] a(String s1, String s2, int i1)
    {
        int j1 = 0;
        int k1 = 0;
        byte abyte0[] = null;
        try
        {
            b(i1, cb[17] + s2 + cb[19]);
            java.io.InputStream inputstream = m.a(s1);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            byte abyte2[] = new byte[6];
            datainputstream.readFully(abyte2, 0, 6);
            j1 = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
            k1 = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
            b(i1, cb[14] + s2 + cb[15]);
            int l1 = 0;
            abyte0 = new byte[k1];
            while(l1 < k1) 
            {
                int i2 = k1 - l1;
                if(i2 > 1000)
                    i2 = 1000;
                datainputstream.readFully(abyte0, l1, i2);
                l1 += i2;
                b(i1, cb[14] + s2 + cb[16] + (5 + (l1 * 95) / k1) + "%");
                z.drawImage(d, j1 - 60, k1, this);
            }
            datainputstream.close();
        }
        catch(IOException ioexception) { }
        b(i1, cb[18] + s2 + "]");
        if(f)
            z.drawImage(d, j1 - 60, k1, this);
        if(k1 != j1)
        {
            byte abyte1[] = new byte[j1];
            s.a(abyte1, j1, abyte0, k1, 0);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    protected Socket a(String s1, int i1)
        throws IOException
    {
        Socket socket;
        socket = new Socket(InetAddress.getByName(s1), i1);
        socket.setTcpNoDelay(true);
        return socket;
        Exception exception;
        exception;
        System.out.println(cb[11]);
        return null;
    }

    protected synchronized void f()
    {
    }

    protected void a(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    protected void g()
    {
    }

    protected synchronized void h()
    {
    }

    protected void i()
    {
    }

    protected final void a(int i1, int j1, String s1, boolean flag)
    {
        u = true;
        K = i1;
        Q = j1;
        y = new c(this, i1, j1, s1, flag, false);
        O = 1;
        I = new Thread(this);
        I.start();
        I.setPriority(1);
    }

    protected final boolean j()
    {
        return u;
    }

    protected final void b(int i1)
    {
        Y = 1000 / i1;
    }

    protected final void k()
    {
        for(int i1 = 0; i1 < 10; i1++)
            A[i1] = 0L;

    }

    public final synchronized boolean mouseDown(Event event, int i1, int j1)
    {
        S = i1;
        T = j1 + M;
        if(event.metaDown())
            U = 2;
        else
            U = 1;
        V = U;
        N = 0;
        a(U, i1, j1);
        return true;
    }

    public final synchronized boolean mouseDrag(Event event, int i1, int j1)
    {
        S = i1;
        T = j1 + M;
        if(event.metaDown())
            U = 2;
        else
            U = 1;
        return true;
    }

    public final synchronized boolean mouseMove(Event event, int i1, int j1)
    {
        S = i1;
        T = j1 + M;
        U = 0;
        N = 0;
        return true;
    }

    public final synchronized boolean mouseUp(Event event, int i1, int j1)
    {
        S = i1;
        T = j1 + M;
        U = 0;
        return true;
    }

    public final void paint(Graphics g1)
    {
        if(!j)
        {
            if(O == 2 && J != null)
            {
                a(P, C);
                return;
            }
            if(O == 0)
                i();
        } else
        {
            return;
        }
    }

    public final void run()
    {
        int i1 = v.z;
        if(O == 1)
        {
            O = 2;
            z = getGraphics();
            e();
            a(0, cb[27]);
            c();
            O = 0;
        }
        int j1 = 0;
        int k1 = 256;
        int l1 = 1;
        int i2 = 0;
        for(int j2 = 0; j2 < 10; j2++)
            A[j2] = System.currentTimeMillis();

        long l2 = System.currentTimeMillis();
        while(ab >= 0) 
        {
            if(ab > 0)
            {
                ab--;
                if(ab == 0)
                {
                    d();
                    I = null;
                    return;
                }
            }
            int k2 = k1;
            int i3 = l1;
            k1 = 300;
            l1 = 1;
            long l3 = System.currentTimeMillis();
            if(A[j1] == 0L)
            {
                k1 = k2;
                l1 = i3;
            } else
            if(l3 > A[j1])
                k1 = (int)((long)(2560 * Y) / (l3 - A[j1]));
            if(k1 < 25)
                k1 = 25;
            if(k1 > 256)
            {
                k1 = 256;
                l1 = (int)((long)Y - (l3 - A[j1]) / 10L);
                if(l1 < R)
                    l1 = R;
            }
            try
            {
                Thread.sleep(l1);
            }
            catch(InterruptedException interruptedexception) { }
            A[j1] = l3;
            j1 = (j1 + 1) % 10;
            if(l1 > 1)
            {
                for(int j3 = 0; j3 < 10; j3++)
                    if(A[j3] != 0L)
                        A[j3] += l1;

            }
            int k3 = 0;
            do
            {
                if(i2 >= 256)
                    break;
                f();
                i2 += k1;
                if(++k3 <= Z)
                    continue;
                i2 = 0;
                L += 6;
                if(L > 25)
                {
                    L = 0;
                    t = true;
                }
                break;
            } while(true);
            L--;
            i2 &= 0xff;
            h();
        }
        if(ab == -1)
            d();
        I = null;
    }

    public final void start()
    {
        if(ab >= 0)
            ab = 0;
    }

    public final void stop()
    {
        if(ab >= 0)
            ab = 4000 / Y;
    }

    public final void update(Graphics g1)
    {
        if(!j)
            paint(g1);
        else
            return;
    }

    private static char[] z(String s1)
    {
        char ac[] = s1.toCharArray();
        ac;
        ac;
_L4:
        JVM INSTR arraylength .length;
        JVM INSTR dup_x1 ;
        2;
        JVM INSTR icmpge 24;
           goto _L1 _L2
_L1:
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        JVM INSTR ifeq 5;
           goto _L3 _L4
_L3:
        0;
        JVM INSTR dup_x2 ;
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        5;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
_L2:
        return;
    }

    private static String z(char ac[])
    {
        ac;
        ac.length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 85;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i1;
_L10:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        i1 % 5;
        byte byte0;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 48
    //                   1 53
    //                   2 58
    //                   3 63;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        byte0 = 0x49;
          goto _L8
_L5:
        byte0 = 29;
          goto _L8
_L6:
        byte0 = 96;
          goto _L8
_L7:
        byte0 = 70;
          goto _L8
_L3:
        byte0 = 5;
_L8:
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 85;
           goto _L9 _L2
_L9:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L10
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 12;
           goto _L11 _L1
_L11:
        JVM INSTR new #378 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        return;
    }

    static ab a;
    static bb b;
    Toolkit c;
    public Image d;
    public Image e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    private boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    private boolean u;
    private Font v;
    private Font w;
    private Font x;
    public static c y = null;
    public Graphics z;
    private long A[];
    public String B;
    private String C;
    private static String D = z(z("\b_#\002@\017Z(\017O\002Q-\bJ\031L2\025Q\034K7\036\\\023|\002%a,{\007.l#v\f+k&m\0214v=h\0261}0gPw7z)Up2q$Ad\246m8>`/a4M\0318bF\033\033xr'G\006&71\\h;f\"<:%"));
    public String E;
    public String F;
    public String G;
    public String H;
    private Thread I;
    private Image J;
    public int K;
    private int L;
    public int M;
    public int N;
    public int O;
    private int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    private int Y;
    private int Z;
    private int ab;
    public static int bb;
    private static String cb[];

    static 
    {
        String as[] = new String[28];
        as[0] = "%r\007)+=z\001";
        as[1] = "!/T$";
        as[2] = "!,S$";
        as[3] = "!,R6";
        as[4] = "!,Q6";
        as[5] = "!,T$";
        as[6] = "!/P$";
        as[7] = "#|\007#}gw\001!";
        as[8] = "!,R$";
        as[9] = "!,V$";
        as[10] = "\003|\007#}iq\t$w(o\031";
        as[11] = "\032r\003-`=X\030%`9i\t)kiT\016fD9m\f#q\026N\025$4";
        as[12] = "\340=0.d=x";
        as[13] = "+d@\026m(i\005fd'y@\nj;p\023$|i";
        as[14] = "\005r\001\"l'z@";
        as[15] = "i0@s ";
        as[16] = "i0@";
        as[17] = "\005r\001\"l'z@\035";
        as[18] = "\034s\020'f\"t\016!%\022";
        as[19] = "\024=Pc";
        as[20] = "fy\0012dfq\017!jgj\002 ";
        as[21] = "fy\0012df\177\024(4gj\002 ";
        as[22] = "\005r\001\"l'z";
        as[23] = "<n\0054+-t\022";
        as[24] = "\001x\f0`=t\003'";
        as[25] = "\035t\r#v\033r\r'k";
        as[26] = "|=\023#f&s\0045%,e\020/w,yLfc&o\003/k.=\013/i%";
        as[27] = z(z("\005r\001\"l'zNh+"));
        cb = as;
    }
}
