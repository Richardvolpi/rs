// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import jagex.f;
import jagex.o;
import java.applet.Applet;
import java.awt.*;
import java.io.PrintStream;
import java.math.BigInteger;

// Referenced classes of package jagex.client:
//            k, a

public class e extends k
{

    public void v(BigInteger biginteger, BigInteger biginteger1)
    {
        md = biginteger;
        nd = biginteger1;
    }

    public int f()
    {
        try
        {
            String s1 = getParameter("ranseed");
            String s2 = s1.substring(0, 10);
            int i1 = Integer.parseInt(s2);
            if(i1 == 0x3ade68b1)
            {
                byte abyte0[] = new byte[4];
                jagex.o.in("uid.dat", abyte0, 4);
                i1 = jagex.o.yn(abyte0, 0);
            }
            return i1;
        }
        catch(Exception _ex)
        {
            return 0;
        }
    }

    public void o(String s1, String s2, boolean flag)
    {
        if(pd > 0)
        {
            gb(qc[6], qc[7]);
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            gb(qc[8], qc[9]);
            return;
        }
        try
        {
            wc = s1;
            s1 = jagex.o._mthdo(s1, 20);
            xc = s2;
            s2 = jagex.o._mthdo(s2, 20);
            if(s1.trim().length() == 0)
            {
                gb(qc[0], qc[1]);
                return;
            }
            if(flag)
                h(qc[2], qc[3]);
            else
                gb(qc[6], qc[7]);
            if(ek())
                yc = a.b(tc, this, vc);
            else
                yc = a.b(tc, null, vc);
            yc.se = sc;
            int i1 = yc.nb();
            od = i1;
            System.out.println("Session id: " + i1);
            if(flag)
                yc.kb(19);
            else
                yc.kb(0);
            yc.cc(rc);
            yc.wb(jagex.o.sn(s1));
            yc.ub(s2, i1, md, nd);
            yc.bc(f());
            yc.vb();
            yc.ob();
            int j1 = yc.mb();
            System.out.println("Login response: " + j1);
            if(j1 == 0)
            {
                ad = 0;
                i();
                return;
            }
            if(j1 == 1)
            {
                ad = 0;
                e();
                return;
            }
            if(flag)
            {
                s1 = "";
                s2 = "";
                j();
                return;
            }
            if(j1 == 3)
            {
                gb(qc[10], qc[11]);
                return;
            }
            if(j1 == 4)
            {
                gb(qc[4], qc[5]);
                return;
            }
            if(j1 == 5)
            {
                gb(qc[16], qc[17]);
                return;
            }
            if(j1 == 6)
            {
                gb(qc[18], qc[19]);
                return;
            }
            if(j1 == 7)
            {
                gb(qc[20], qc[21]);
                return;
            }
            if(j1 == 11)
            {
                gb(qc[22], qc[23]);
                return;
            }
            if(j1 == 12)
            {
                gb(qc[24], qc[25]);
                return;
            }
            if(j1 == 13)
            {
                gb(qc[14], qc[15]);
                return;
            }
            if(j1 == 14)
            {
                gb(qc[8], qc[9]);
                pd = 1500;
                return;
            } else
            {
                gb(qc[12], qc[13]);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        if(!ek())
            tc = uc;
        if(ad > 0)
        {
            try
            {
                Thread.sleep(5000L);
            }
            catch(Exception _ex) { }
            ad--;
            o(s1, s2, flag);
        }
        if(flag)
        {
            s1 = "";
            s2 = "";
            j();
        } else
        {
            gb(qc[12], qc[13]);
        }
    }

    public void eb()
    {
        if(yc != null)
        {
            yc.kb(1);
            yc.ib();
        }
        wc = "";
        xc = "";
        j();
    }

    public void s()
    {
        System.out.println("Lost connection");
        ad = 10;
        o(wc, xc, true);
    }

    public void h(String s1, String s2)
    {
        Graphics g1 = getGraphics();
        Font font = new Font("Helvetica", 1, 15);
        int i1 = sj();
        int j1 = ck();
        g1.setColor(Color.black);
        g1.fillRect(i1 / 2 - 140, j1 / 2 - 25, 280, 50);
        g1.setColor(Color.white);
        g1.drawRect(i1 / 2 - 140, j1 / 2 - 25, 280, 50);
        mj(g1, s1, font, i1 / 2, j1 / 2 - 10);
        mj(g1, s2, font, i1 / 2, j1 / 2 + 10);
    }

    public void p(String s1, String s2)
    {
        if(pd > 0)
        {
            gb(qc[6], qc[7]);
            try
            {
                Thread.sleep(2000L);
            }
            catch(Exception _ex) { }
            gb(qc[8], qc[9]);
            return;
        }
        try
        {
            s1 = jagex.o._mthdo(s1, 20);
            s2 = jagex.o._mthdo(s2, 20);
            gb(qc[6], qc[7]);
            if(ek())
                yc = a.b(tc, this, vc);
            else
                yc = a.b(tc, null, vc);
            int i1 = yc.nb();
            od = i1;
            System.out.println("Session id: " + i1);
            yc.kb(2);
            yc.cc(rc);
            yc.wb(jagex.o.sn(s1));
            yc.ub(s2, i1, md, nd);
            yc.bc(f());
            yc.ib();
            yc.ob();
            int j1 = yc.mb();
            yc.hb();
            System.out.println("Newplayer response: " + j1);
            if(j1 == 2)
            {
                x();
                return;
            }
            if(j1 == 3)
            {
                gb(qc[14], qc[15]);
                return;
            }
            if(j1 == 4)
            {
                gb(qc[4], qc[5]);
                return;
            }
            if(j1 == 5)
            {
                gb(qc[16], qc[17]);
                return;
            }
            if(j1 == 6)
            {
                gb(qc[18], qc[19]);
                return;
            }
            if(j1 == 7)
            {
                gb(qc[20], qc[21]);
                return;
            }
            if(j1 == 11)
            {
                gb(qc[22], qc[23]);
                return;
            }
            if(j1 == 12)
            {
                gb(qc[24], qc[25]);
                return;
            }
            if(j1 == 13)
            {
                gb(qc[14], qc[15]);
                return;
            }
            if(j1 == 14)
            {
                gb(qc[8], qc[9]);
                pd = 1500;
                return;
            } else
            {
                gb(qc[12], qc[13]);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(String.valueOf(exception));
        }
        gb(qc[12], qc[13]);
    }

    public void z()
    {
        bd = System.currentTimeMillis();
    }

    public void m()
    {
        long l1 = System.currentTimeMillis();
        if(l1 - bd > 5000L)
        {
            bd = l1;
            yc.kb(5);
            yc.ib();
        }
        if(!ab())
            return;
        if(((f) (yc)).xd)
        {
            s();
            return;
        }
        int i1 = yc.jb(zc);
        if(i1 > 0)
            g(zc[0] & 0xff, i1);
    }

    public void g(int i1, int j1)
    {
        if(i1 == 8)
        {
            String s1 = new String(zc, 1, j1 - 1);
            k(s1);
        }
        if(i1 == 9)
            eb();
        if(i1 == 10)
        {
            n();
            return;
        }
        if(i1 == 23)
        {
            cd = jagex.o.wn(zc[1]);
            for(int k1 = 0; k1 < cd; k1++)
            {
                dd[k1] = jagex.o.rn(zc, 2 + k1 * 9);
                ed[k1] = jagex.o.wn(zc[10 + k1 * 9]);
            }

            db();
            return;
        }
        if(i1 == 24)
        {
            long l1 = jagex.o.rn(zc, 1);
            int j2 = zc[9] & 0xff;
            for(int k2 = 0; k2 < cd; k2++)
                if(dd[k2] == l1)
                {
                    if(ed[k2] == 0 && j2 != 0)
                        k("@pri@" + jagex.o.xn(l1) + " has logged in");
                    if(ed[k2] != 0 && j2 == 0)
                        k("@pri@" + jagex.o.xn(l1) + " has logged out");
                    ed[k2] = j2;
                    j1 = 0;
                    db();
                    return;
                }

            dd[cd] = l1;
            ed[cd] = j2;
            cd++;
            k("@pri@" + jagex.o.xn(l1) + " has been added to your friends list");
            db();
            return;
        }
        if(i1 == 26)
        {
            fd = jagex.o.wn(zc[1]);
            for(int i2 = 0; i2 < fd; i2++)
                gd[i2] = jagex.o.rn(zc, 2 + i2 * 8);

            return;
        }
        if(i1 == 27)
        {
            hd = zc[1];
            id = zc[2];
            jd = zc[3];
            kd = zc[4];
            ld = zc[5];
            return;
        }
        if(i1 == 28)
        {
            long l2 = jagex.o.rn(zc, 1);
            String s2 = jagex.o.qn(zc, 9, j1 - 9, true);
            k("@pri@" + jagex.o.xn(l2) + ": tells you " + s2);
            return;
        } else
        {
            q(i1, j1, zc);
            return;
        }
    }

    public void db()
    {
        boolean flag = true;
        while(flag) 
        {
            flag = false;
            for(int i1 = 0; i1 < cd - 1; i1++)
                if(ed[i1] < ed[i1 + 1])
                {
                    int j1 = ed[i1];
                    ed[i1] = ed[i1 + 1];
                    ed[i1 + 1] = j1;
                    long l1 = dd[i1];
                    dd[i1] = dd[i1 + 1];
                    dd[i1 + 1] = l1;
                    flag = true;
                }

        }
    }

    public void bb(String s1, String s2)
    {
        s1 = jagex.o._mthdo(s1, 20);
        s2 = jagex.o._mthdo(s2, 20);
        yc.kb(25);
        yc.ub(s1 + s2, od, md, nd);
        yc.ib();
    }

    public void fb(int i1, int j1, int k1, int l1, int i2)
    {
        yc.kb(31);
        yc.dc(i1);
        yc.dc(j1);
        yc.dc(k1);
        yc.dc(l1);
        yc.dc(i2);
        yc.ib();
    }

    public void cb(String s1)
    {
        long l1 = jagex.o.sn(s1);
        yc.kb(29);
        yc.wb(l1);
        yc.ib();
        for(int i1 = 0; i1 < fd; i1++)
            if(gd[i1] == l1)
                return;

        if(fd >= 50)
        {
            return;
        } else
        {
            gd[fd++] = l1;
            return;
        }
    }

    public void r(long l1)
    {
        yc.kb(30);
        yc.wb(l1);
        yc.ib();
        for(int i1 = 0; i1 < fd; i1++)
            if(gd[i1] == l1)
            {
                fd--;
                for(int j1 = i1; j1 < fd; j1++)
                    gd[j1] = gd[j1 + 1];

                return;
            }

    }

    public void w(String s1)
    {
        yc.kb(26);
        yc.wb(jagex.o.sn(s1));
        yc.ib();
    }

    public void l(long l1)
    {
        yc.kb(27);
        yc.wb(l1);
        yc.ib();
        for(int i1 = 0; i1 < cd; i1++)
        {
            if(dd[i1] != l1)
                continue;
            cd--;
            for(int j1 = i1; j1 < cd; j1++)
            {
                dd[j1] = dd[j1 + 1];
                ed[j1] = ed[j1 + 1];
            }

            break;
        }

        k("@pri@" + jagex.o.xn(l1) + " has been removed from your friends list");
    }

    public void y(long l1, byte abyte0[], int i1)
    {
        yc.kb(28);
        yc.wb(l1);
        yc.ec(abyte0, 0, i1);
        yc.ib();
    }

    public void t(byte abyte0[], int i1)
    {
        yc.kb(3);
        yc.ec(abyte0, 0, i1);
        yc.ib();
        z();
    }

    public void u(String s1)
    {
        yc.kb(7);
        yc.sb(s1);
        yc.ib();
        z();
    }

    public void gb(String s1, String s2)
    {
    }

    public void e()
    {
    }

    public void i()
    {
    }

    public void j()
    {
    }

    public void n()
    {
    }

    public void x()
    {
    }

    public void q(int i1, int j1, byte abyte0[])
    {
    }

    public void k(String s1)
    {
    }

    public boolean ab()
    {
        return true;
    }

    public e()
    {
        tc = "127.0.0.1";
        uc = "66.28.11.53";
        vc = 43594;
        wc = "";
        xc = "";
        zc = new byte[5000];
        dd = new long[100];
        ed = new int[100];
        gd = new long[50];
    }

    public static String qc[];
    public static int rc = 1;
    public static int sc;
    public String tc;
    public String uc;
    public int vc;
    String wc;
    String xc;
    public a yc;
    byte zc[];
    int ad;
    long bd;
    public int cd;
    public long dd[];
    public int ed[];
    public int fd;
    public long gd[];
    public int hd;
    public int id;
    public int jd;
    public int kd;
    public int ld;
    public BigInteger md;
    public BigInteger nd;
    public int od;
    public int pd;

    static 
    {
        qc = new String[50];
        qc[0] = "You must enter both a username";
        qc[1] = "and a password - Please try again";
        qc[2] = "Connection lost! Please wait...";
        qc[3] = "Attempting to re-establish";
        qc[4] = "That username is already in use.";
        qc[5] = "Wait 60 seconds then retry";
        qc[6] = "Please wait...";
        qc[7] = "Connecting to server";
        qc[8] = "Sorry! The server is currently full.";
        qc[9] = "Please try again later";
        qc[10] = "Invalid username or password.";
        qc[11] = "Try again, or create a new account";
        qc[12] = "Sorry! Unable to connect to server.";
        qc[13] = "Check your internet settings";
        qc[14] = "Username already taken.";
        qc[15] = "Please choose another username";
        qc[16] = "The client has been updated.";
        qc[17] = "Please reload this page";
        qc[18] = "You may only use 1 character at once.";
        qc[19] = "Your ip-address is already in use";
        qc[20] = "Login attempts exceeded!";
        qc[21] = "Please try again in 5 minutes";
        qc[22] = "Account has been temporarily disabled";
        qc[23] = "for cheating or abuse";
        qc[24] = "Account has been permanently disabled";
        qc[25] = "for cheating or abuse";
    }
}
