// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   b.java

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;

public class b extends a
{

    public b()
    {
        cb = "";
        db = "";
        eb = "";
        gb = 1;
        hb = new Random(1337L);
        tb = Mb[73];
        yb = 43594;
        pb = false;
        ub = "";
        vb = "";
        mb = new byte[5000];
        rb = new long[200];
        Kb = new int[200];
        sb = new long[50];
        Lb = new int[100];
    }

    public int a(int i, int i1)
    {
        return hb.nextInt((i1 + 1) - i) + i;
    }

    public void a(String s1, String s2, boolean flag)
    {
        boolean flag1;
        flag1 = v.R;
        int i = f.J;
        if(tb == null)
        {
            System.out.println(Mb[35]);
            return;
        }
        if(Gb > 0)
        {
            b(Mb[43], Mb[29]);
            ab.a(Mb[2]);
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception exception) { }
            b(Mb[46], Mb[18]);
            ab.a(Mb[36]);
            return;
        }
        ub = s1;
        s1 = m.a(s1, 20);
        vb = s2;
        s2 = m.a(s2, 20);
        if(s1.trim().length() == 0)
        {
            b(Mb[1], Mb[45]);
            ab.a(Mb[5]);
            return;
        }
        long l2;
label0:
        {
            if(flag)
            {
                a(Mb[24], Mb[11]);
                ab.a(Mb[53]);
                if(!flag1)
                    break label0;
            }
            b(Mb[43], Mb[29]);
            ab.a(Mb[2]);
        }
        nb = new l(a(tb, yb), this);
        nb.i = xb;
        long l1 = m.b(s1);
        nb.a(32);
        nb.f((int)(l1 >> 16 & 31L));
        nb.h();
        l2 = nb.c();
        qb = l2;
        if(l2 == 0L)
        {
            b(Mb[9], Mb[4]);
            ab.a(Mb[52]);
            return;
        }
        int k1;
        int i1;
        int ai[];
        j j1;
label1:
        {
            i1 = 0;
            try
            {
                if(j())
                {
                    String s3 = getParameter(Mb[12]);
                    if(s3.equals("1"))
                        i1 = 1;
                }
            }
            catch(Exception exception3) { }
            ib = a(0x989680, 0x5f5e0ff);
            ai = new int[4];
            ai[0] = (int)(Math.random() * 99999999D);
            ai[1] = (int)(Math.random() * 99999999D);
            ai[2] = (int)(l2 >> 32);
            ai[3] = (int)l2;
            j1 = new j(new byte[500]);
            j1.c = 0;
            j1.a(10);
            j1.b(ai[0]);
            j1.b(ai[1]);
            j1.b(ai[2]);
            j1.b(ai[3]);
            j1.b(ib);
            j1.a(s1);
            j1.a(s2);
            j1.a(kb, lb);
            nb.a(0);
            if(flag)
            {
                nb.f(1);
                if(!flag1)
                    break label1;
            }
            nb.f(0);
        }
        nb.e(wb);
        nb.f(i1);
        nb.a(j1.a, 0, j1.c);
        nb.h();
        nb.a(ai);
        k1 = nb.f();
        if(k1 == 25 || k1 == 0 || k1 == 1)
        {
            b(Mb[15], Mb[10]);
            ab.a(Mb[32]);
        }
        if(k1 == 25)
        {
            Hb = 1;
            zb = 0;
            p();
            return;
        }
        if(k1 == 0)
        {
            Hb = 0;
            zb = 0;
            p();
            return;
        }
        if(k1 == 1)
        {
            zb = 0;
            o();
            return;
        }
        if(flag)
        {
            s1 = "";
            s2 = "";
            q();
            return;
        }
        if(k1 == -1)
        {
            b(Mb[47], Mb[17]);
            ab.a(Mb[13]);
            return;
        }
        if(k1 == 3)
        {
            b(Mb[21], Mb[25]);
            ab.a(Mb[16]);
            return;
        }
        if(k1 == 4)
        {
            b(Mb[57], Mb[56]);
            ab.a(Mb[30]);
            return;
        }
        if(k1 == 5)
        {
            b(Mb[22], Mb[8]);
            ab.a(Mb[44]);
            return;
        }
        if(k1 == 6)
        {
            b(Mb[19], Mb[33]);
            ab.a(Mb[34]);
            ib = a(0x989680, 0x5f5e0ff);
            return;
        }
        if(k1 == 7)
        {
            b(Mb[42], Mb[50]);
            ab.a(Mb[28]);
            return;
        }
        if(k1 == 8)
        {
            b(Mb[47], Mb[41]);
            ab.a(Mb[51]);
            return;
        }
        if(k1 == 9)
        {
            b(Mb[47], Mb[3]);
            ab.a(Mb[51]);
            return;
        }
        if(k1 == 10)
        {
            b(Mb[23], Mb[56]);
            ab.a(Mb[31]);
            return;
        }
        if(k1 == 11)
        {
            b(Mb[55], Mb[40]);
            ab.a(Mb[49]);
            return;
        }
        if(k1 == 12)
        {
            b(Mb[37], Mb[40]);
            ab.a(Mb[49]);
            return;
        }
        if(k1 == 14)
        {
            b(Mb[48], Mb[7]);
            Gb = 1500;
            ab.a(Mb[36]);
            return;
        }
        if(k1 == 15)
        {
            b(Mb[26], Mb[54]);
            ab.a(Mb[14]);
            return;
        }
        if(k1 == 16)
        {
            b(Mb[6], Mb[39]);
            ab.a(Mb[13]);
            return;
        }
        if(k1 == 17)
        {
            b(Mb[27], Mb[60]);
            ab.a(Mb[13]);
            return;
        }
        if(k1 == 20)
        {
            b(Mb[20], Mb[7]);
            ab.a(Mb[13]);
            return;
        }
label2:
        {
            try
            {
                b(Mb[47], Mb[58]);
                ab.a(Mb[13]);
                return;
            }
            catch(Exception exception1)
            {
                System.out.println(String.valueOf(exception1));
            }
            if(zb > 0)
            {
                try
                {
                    Thread.sleep(5000L);
                }
                catch(Exception exception2) { }
                zb--;
                a(ub, vb, flag);
            }
            if(flag)
            {
                ub = "";
                vb = "";
                q();
                if(!flag1)
                    break label2;
            }
            b(Mb[59], Mb[38]);
        }
        return;
    }

    protected final void j()
    {
        ab.a(Mb[0]);
        fb = true;
        if(nb != null)
            try
            {
                nb.a(190);
                nb.h();
            }
            catch(IOException ioexception) { }
        ub = "";
        vb = "";
        q();
    }

    protected void l()
    {
        System.out.println(Mb[61]);
        zb = 10;
        a(ub, vb, true);
    }

    protected final void a(String s1, String s2)
    {
        Graphics g = getGraphics();
        Font font = new Font(Mb[75], 1, 15);
        char c1 = '\u0200';
        char c2 = '\u0158';
        g.setColor(Color.black);
        g.fillRect(c1 / 2 - 140, c2 / 2 - 25, 280, 50);
        g.setColor(Color.white);
        g.drawRect(c1 / 2 - 140, c2 / 2 - 25, 280, 50);
        a(g, s1, font, c1 / 2, c2 / 2 - 10);
        a(g, s2, font, c1 / 2, c2 / 2 + 10);
    }

    protected final void m()
    {
        long l1 = System.currentTimeMillis();
        if(nb.d())
            ob = l1;
        if(l1 - ob > 5000L)
        {
            ob = l1;
            nb.a(76);
            nb.i();
        }
        try
        {
            nb.d(20);
        }
        catch(IOException ioexception)
        {
            l();
            return;
        }
        if(!s())
            return;
        int i = nb.a(mb);
        if(i > 0)
            b(mb[0] & 0xff, i);
    }

    private final void b(int i, int i1)
    {
        int j1 = f.J;
        i = nb.c(i);
        if(i == 202)
        {
            String s1 = new String(mb, 1, i1 - 1);
            if(s1.indexOf(Mb[69]) != -1 && jb == 0)
                jb = 1;
            if(s1.indexOf(Mb[69]) != -1 && jb == 1)
                jb = 0;
            else
            if(s1.substring(s1.length() - 10, s1.length()).equalsIgnoreCase(Mb[72]))
                d(Mb[66]);
            else
                d(s1);
            char c1 = s1.charAt(0);
            char c2 = s1.charAt(4);
            if(c1 == '@' || c2 == '@')
                eb = Mb[65] + s1.substring(5, s1.length());
            else
                eb = Mb[65] + s1;
            ab.b(eb);
        }
        if(i == 178)
            j();
        if(i == 11)
        {
            r();
            return;
        }
        if(i == 174)
        {
            Ab = m.a(mb[1]);
            for(int k1 = 0; k1 < Ab; k1++)
            {
                rb[k1] = m.c(mb, 2 + k1 * 9);
                Kb[k1] = m.a(mb[10 + k1 * 9]);
            }

            n();
            return;
        }
        if(i == 101)
        {
            long l1 = m.c(mb, 1);
            int j2 = mb[9] & 0xff;
            for(int i3 = 0; i3 < Ab; i3++)
                if(rb[i3] == l1)
                {
                    if(Kb[i3] == 0 && j2 != 0)
                    {
                        d(Mb[67] + m.a(l1) + Mb[64]);
                        db = Mb[70] + m.a(l1);
                        ab.a(db);
                    }
                    if(Kb[i3] != 0 && j2 == 0)
                    {
                        d(Mb[67] + m.a(l1) + Mb[68]);
                        db = Mb[62] + m.a(l1);
                        ab.a(db);
                    }
                    Kb[i3] = j2;
                    i1 = 0;
                    n();
                    return;
                }

            rb[Ab] = l1;
            Kb[Ab] = j2;
            Ab++;
            n();
            return;
        }
        if(i == 144)
        {
            Bb = m.a(mb[1]);
            for(int i2 = 0; i2 < Bb; i2++)
                sb[i2] = m.c(mb, 2 + i2 * 8);

            return;
        }
        if(i == 148)
        {
            Cb = mb[1];
            Db = mb[2];
            Eb = mb[3];
            Fb = mb[4];
            return;
        }
        if(i == 193)
        {
            long l2 = m.c(mb, 1);
            int k2 = m.b(mb, 9);
            for(int j3 = 0; j3 < 100; j3++)
                if(Lb[j3] == k2)
                    return;

            Lb[Jb] = k2;
            Jb = (Jb + 1) % 100;
            String s2 = n.a(o.a(mb, 13, i1 - 13));
            d(Mb[67] + m.a(l2) + Mb[63] + s2);
            db = Mb[71] + m.a(l2) + ":" + s2;
            ab.b(db);
            return;
        } else
        {
            a(i, i1, mb);
            return;
        }
    }

    private final void n()
    {
        int i = f.J;
        for(boolean flag = true; flag;)
        {
            flag = false;
            int i1 = 0;
            while(i1 < Ab - 1) 
            {
                if(Kb[i1] < Kb[i1 + 1])
                {
                    int j1 = Kb[i1];
                    Kb[i1] = Kb[i1 + 1];
                    Kb[i1 + 1] = j1;
                    long l1 = rb[i1];
                    rb[i1] = rb[i1 + 1];
                    rb[i1 + 1] = l1;
                    flag = true;
                }
                i1++;
            }
        }

    }

    protected final void a(int i, int i1, int j1, int k1)
    {
        nb.a(191);
        nb.f(i);
        nb.f(i1);
        nb.f(j1);
        nb.f(k1);
        nb.i();
    }

    protected final void a(String s1)
    {
        long l1 = m.b(s1);
        nb.a(241);
        nb.a(l1);
        nb.i();
        for(int i = 0; i < Bb; i++)
            if(sb[i] == l1)
                return;

        if(Bb >= 50)
        {
            return;
        } else
        {
            sb[Bb++] = l1;
            return;
        }
    }

    protected final void a(long l1)
    {
        int i = f.J;
        nb.a(30);
        nb.a(l1);
        nb.i();
        for(int i1 = 0; i1 < Bb; i1++)
            if(sb[i1] == l1)
            {
                Bb--;
                for(int j1 = i1; j1 < Bb; j1++)
                    sb[j1] = sb[j1 + 1];

                return;
            }

    }

    protected final void b(String s1)
    {
        nb.a(204);
        nb.a(m.b(s1));
        nb.i();
        long l1 = m.b(s1);
        for(int i = 0; i < Ab; i++)
            if(rb[i] == l1)
                return;

        if(Ab >= 100)
        {
            return;
        } else
        {
            rb[Ab] = l1;
            Kb[Ab] = 0;
            Ab++;
            return;
        }
    }

    protected final void b(long l1)
    {
        int i = f.J;
        nb.a(179);
        nb.a(l1);
        nb.i();
        int i1 = 0;
        do
        {
            if(i1 >= Ab)
                break;
            if(rb[i1] == l1)
            {
                Ab--;
                for(int j1 = i1; j1 < Ab; j1++)
                {
                    rb[j1] = rb[j1 + 1];
                    Kb[j1] = Kb[j1 + 1];
                }

                break;
            }
            i1++;
        } while(true);
        d(Mb[67] + m.a(l1) + Mb[74]);
    }

    protected final void a(long l1, byte abyte0[], int i)
    {
        nb.a(225);
        nb.a(l1);
        nb.a(abyte0, 0, i);
        nb.i();
    }

    protected final void a(byte abyte0[], int i)
    {
        nb.a(40);
        nb.a(abyte0, 0, i);
        nb.i();
    }

    protected final void c(String s1)
    {
        nb.a(195);
        nb.a(s1);
        nb.i();
    }

    protected void b(String s1, String s2)
    {
    }

    protected void o()
    {
    }

    protected void p()
    {
    }

    protected void q()
    {
    }

    protected void r()
    {
    }

    protected void a(int i, int i1, byte abyte0[])
    {
    }

    protected void d(String s1)
    {
    }

    protected boolean s()
    {
        return true;
    }

    public String cb;
    public String db;
    public String eb;
    public boolean fb;
    public int gb;
    public Random hb;
    public int ib;
    public int jb;
    private static BigInteger kb;
    private static BigInteger lb;
    byte mb[];
    public l nb;
    long ob;
    public boolean pb;
    public long qb;
    public long rb[];
    public long sb[];
    public static String tb;
    String ub;
    String vb;
    public static int wb;
    public static int xb;
    public static int yb;
    int zb;
    public int Ab;
    public int Bb;
    public int Cb;
    public int Db;
    public int Eb;
    public int Fb;
    public int Gb;
    public int Hb;
    private final int Ib = 100;
    private int Jb;
    public int Kb[];
    private int Lb[];
    private static String Mb[];

    static 
    {
        String as[];
        as = new String[78];
        as[0] = "!3;-99\\/7/.9/1";
        as[1] = "4\023\tB\001\030\017\bB\t\003\b\031\020L\017\023\b\nL\f\\\t\021\t\037\022\035\017\t";
        as[2] = "!3;+\"M/(#>9";
        as[3] = "!\023\033\013\002\036\031\016\024\t\037\\\016\007\006\b\037\b\007\bM\017\031\021\037\004\023\022";
        as[4] = "=\020\031\003\037\b\\\b\020\025M\035\033\003\005\003\\\025\fL\f\\\032\007\033M\021\025\f\037";
        as[5] = "!3;+\"M151?";
        as[6] = "(\016\016\r\036MQ\\\f\003M\016\031\022\000\024\\\032\020\003\000\\\020\r\013\004\022\017\007\036\033\031\016L";
        as[7] = "=\020\031\003\037\b\\\b\020\025M\035\\\006\005\013\032\031\020\t\003\b\\\025\003\037\020\030";
        as[8] = "=\020\031\003\037\b\\\016\007\000\002\035\030B\030\005\025\017B\034\f\033\031";
        as[9] = "!\023\033\013\002M\017\031\020\032\b\016\\\r\n\013\020\025\f\tC";
        as[10] = ".\023\022\f\t\016\b\031\006L\031\023\\5\r\036\b\031&.\002(";
        as[11] = ",\b\b\007\001\035\b\025\f\013M\b\023B\036\bQ\031\021\030\f\036\020\013\037\005";
        as[12] = "\001\025\021\013\030^L";
        as[13] = "!3;+\"M9.0#?";
        as[14] = "!3;+\"M19/.(./";
        as[15] = "!\023\033\005\t\t\\\025\f@";
        as[16] = "!3;+\"M524-!58";
        as[17] = ">\031\016\024\t\037\\\b\013\001\b\030\\\r\031\031";
        as[18] = "=\020\031\003\037\b\\\b\020\025M\035\033\003\005\003\\\020\003\030\b\016";
        as[19] = "4\023\tB\001\f\005\\\r\002\001\005\\\027\037\b\\MB\017\005\035\016\003\017\031\031\016B\r\031\\\023\f\017\bR";
        as[20] = "(\016\016\r\036MQ\\\016\003\n\025\022\021\t\037\n\031\020L\000\025\017\017\r\031\037\024";
        as[21] = "$\022\n\003\000\004\030\\\027\037\b\016\022\003\001\b\\\023\020L\035\035\017\021\033\002\016\030L";
        as[22] = "9\024\031B\017\001\025\031\f\030M\024\035\021L\017\031\031\fL\030\f\030\003\030\b\030R";
        as[23] = "9\024\035\026L\030\017\031\020\002\f\021\031B\005\036\\\035\016\036\b\035\030\033L\004\022\\\027\037\bR";
        as[24] = ".\023\022\f\t\016\b\025\r\002M\020\023\021\030L\\,\016\t\f\017\031B\033\f\025\bLBC";
        as[25] = "9\016\005B\r\n\035\025\f@M\023\016B\017\037\031\035\026\tM\035\\\f\t\032\\\035\001\017\002\t\022\026";
        as[26] = "4\023\tB\002\b\031\030B\rM\021\031\017\016\b\016\017B\r\016\037\023\027\002\031";
        as[27] = "(\016\016\r\036MQ\\\004\r\004\020\031\006L\031\023\\\006\t\016\023\030\007L\035\016\023\004\005\001\031R";
        as[28] = "!3;+\"M3*'>,(('!=(";
        as[29] = ".\023\022\f\t\016\b\025\f\013M\b\023B\037\b\016\n\007\036";
        as[30] = "!3;+\"M=00),8%";
        as[31] = "!3;+\"M)/'>$2)1)";
        as[32] = "!3;+\"M/)!/(//";
        as[33] = "4\023\t\020L\004\fQ\003\b\t\016\031\021\037M\025\017B\r\001\016\031\003\b\024\\\025\fL\030\017\031";
        as[34] = "!3;+\"M5,+\"8/9";
        as[35] = "6B@?L=\020\031\003\037\b\\\017\007\000\b\037\bB\rM\017\031\020\032\b\016\\\004\036\002\021\\\026\004\b\\?\016\005\b\022\bC";
        as[36] = "!3;+\"M:). ";
        as[37] = ",\037\037\r\031\003\b\\\022\t\037\021\035\f\t\003\b\020\033L\t\025\017\003\016\001\031\030L";
        as[38] = ".\024\031\001\007M\025\022\026\t\037\022\031\026L\036\031\b\026\005\003\033\017B\003\037\\\b\020\025M\035\022\r\030\005\031\016B\033\002\016\020\006";
        as[39] = "=\020\031\003\037\b\\\b\020\025M\035\033\003\005\003";
        as[40] = ".\024\031\001\007M\005\023\027\036M\021\031\021\037\f\033\031B\005\003\036\023\032L\013\023\016B\b\b\b\035\013\000\036";
        as[41] = ">\031\016\024\t\037\\\016\007\006\b\037\b\007\bM\017\031\021\037\004\023\022";
        as[42] = "!\023\033\013\002M\035\b\026\t\000\f\b\021L\b\004\037\007\t\t\031\030C";
        as[43] = "=\020\031\003\037\b\\\013\003\005\031RRL";
        as[44] = "!3;+\"M),&-998";
        as[45] = "\f\022\030B\rM\f\035\021\037\032\023\016\006L@\\,\016\t\f\017\031B\030\037\005\\\003\013\f\025\022";
        as[46] = ">\023\016\020\025L\\(\n\tM\017\031\020\032\b\016\\\013\037M\037\t\020\036\b\022\b\016\025M\032\t\016\000C";
        as[47] = "(\016\016\r\036M\t\022\003\016\001\031\\\026\003M\020\023\005\005\003R";
        as[48] = ">\023\016\020\025L\\(\n\005\036\\\013\r\036\001\030\\\013\037M\037\t\020\036\b\022\b\016\025M\032\t\016\000C";
        as[49] = "!3;+\"M>=,\"(8";
        as[50] = "=\020\031\003\037\b\\\b\020\025M\035\033\003\005\003\\\025\fLX\\\021\013\002\030\b\031\021";
        as[51] = "!3;+\"M.9().(";
        as[52] = "!3;+\"M3:$ $29";
        as[53] = "!3;+\"M?3, \"/(";
        as[54] = "\031\023\\\016\003\n\025\022B\030\002\\\b\n\005\036\\\013\r\036\001\030";
        as[55] = ",\037\037\r\031\003\b\\\026\t\000\f\023\020\r\037\025\020\033L\t\025\017\003\016\001\031\030L";
        as[56] = ":\035\025\026L[L\\\021\t\016\023\022\006\037M\b\024\007\002M\016\031\026\036\024";
        as[57] = "9\024\035\026L\030\017\031\020\002\f\021\031B\005\036\\\035\016\036\b\035\030\033L\001\023\033\005\t\t\\\025\fB";
        as[58] = "8\022\016\007\017\002\033\022\013\037\b\030\\\020\t\036\f\023\f\037\b\\\037\r\b\b";
        as[59] = ">\023\016\020\025L\\)\f\r\017\020\031B\030\002\\\037\r\002\003\031\037\026B";
        as[60] = ".\023\022\026\r\016\b\\\001\031\036\b\023\017\t\037\\\017\027\034\035\023\016\026";
        as[61] = "!\023\017\026L\016\023\022\f\t\016\b\025\r\002";
        as[62] = "!=/6< \\0-+\")(B";
        as[63] = "-\037\005\003,M\b\031\016\000\036\\\005\r\0310\\";
        as[64] = "-\037\005\003,0\\\024\003\037M\020\023\005\013\b\030\\\013\002";
        as[65] = "*=1'L";
        as[66] = ":\031\020\001\003\000\031\\\026\003M+\035\021\030\b8>\r8L";
        as[67] = "-\f\016\013,-\037\005\003,6<\005\007\000-";
        as[68] = "-\037\005\003,0\\\024\003\037M\020\023\005\013\b\030\\\r\031\031";
        as[69] = "\036\b\035\f\b\004\022\033B\004\b\016\031";
        as[70] = "!=/6< \\0-+$2\\";
        as[71] = "!=/6< \\:0# \\";
        as[72] = "?\t\022\007\037\016\035\f\007M";
        as[73] = "_MKL]^DRQ]CNIR";
        as[74] = "-\037\005\003,0\\\024\003\037M\036\031\007\002M\016\031\017\003\033\031\030B\n\037\023\021B\025\002\t\016B\n\037\025\031\f\b\036\\\020\013\037\031";
        as[75] = "%\031\020\024\t\031\025\037\003";
        as[76] = "XDKUT[EE[[[MDVX[MIR^XNISU^KOZ^\\ONW_[HER\\]MH[]YKDQYTELS_[KLT\\YMLZXYHLUX_EKWT_M";
        as[77] = "ZMJPU]LIPY_NEUUULOP[[MDSZZEMP_]INU^TJOPU^MOPU\\NOP__HN[\\_OKZXTNJQY]MNRT_LK[[_DEV\\XOEPU]JIT_[INP_[OMT_[NMR\\]KNZTYMMZ^_ODU[_KMPX_KDT^ZKNP]TJKTYZKN[_[LLP^\\KD[";
        Mb = as;
        break MISSING_BLOCK_LABEL_819;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 798;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i % 5)
        {
        case 0: // '\0'
            byte0 = 0x6d;
            break;

        case 1: // '\001'
            byte0 = 124;
            break;

        case 2: // '\002'
            byte0 = 124;
            break;

        case 3: // '\003'
            byte0 = 98;
            break;

        default:
            byte0 = 108;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 798;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 722;
           goto _L5 _L1
_L5:
        JVM INSTR new #173 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        kb = new BigInteger(Mb[76]);
        lb = new BigInteger(Mb[77]);
        wb = 1;
    }
}
