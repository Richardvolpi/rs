// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   mudclient.java

import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class mudclient extends b
{

    public String a(int i1)
    {
        int j1 = f.J;
        return f.k[i1];
    }

    public String b(int i1)
    {
        for(int j1 = 0; j1 < xg; j1++)
            if(Ke[j1].e == i1)
                return Ke[j1].c;

        return null;
    }

    public void s()
    {
        if(G() == 0 && Oc != null)
        {
            super.nb.a(60);
            super.nb.a(Oc);
            if(!oe)
            {
                super.nb.f(0);
                oe = true;
            }
            super.nb.i();
            Oc = null;
        }
    }

    public void a(int i1, int j1)
    {
        ak[0] = 320;
        jk[0] = i1 - Qg;
        kk[0] = j1 - Rg;
        fb(0);
        B();
    }

    public boolean b(int i1, int j1)
    {
        for(int k1 = 0; k1 < Yg; k1++)
            if(Fj[k1] == 2 && H(k1) + Qg == i1 && I(k1) + Rg == j1)
                return true;

        return false;
    }

    public void c(int i1, int j1)
    {
        super.nb.a(116);
        super.nb.f(i1);
        super.nb.e(i1);
        super.nb.b(j1);
        super.nb.i();
        wk[Oi] = i1;
        xk[Oi] = j1;
        Oi++;
        ue = false;
        ve = false;
    }

    public void d(int i1, int j1)
    {
        boolean flag = false;
        for(int l1 = 0; l1 < wk.length; l1++)
            if(wk[l1] == i1)
            {
                Oi = l1;
                int k1 = xk[l1];
                super.nb.a(116);
                super.nb.f(i1);
                super.nb.e(i1);
                super.nb.b(k1 - j1);
                super.nb.i();
                wk[l1] = i1;
                xk[l1] = k1 - j1;
                ue = false;
                ve = false;
            }

    }

    public int a(String s1)
    {
        int ai1[] = new int[E()];
        int ai2[] = new int[E()];
        int ai3[] = new int[E()];
        int i1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d1 = 9999999D;
        int j1 = -1;
        for(int k1 = 0; k1 < E(); k1++)
            if(Fe[k1].c == s1 && Fe[k1].k != 8 && Fe[k1].k != 9)
            {
                ai1[i1] = (Fe[k1].g - 64) / Ci;
                ai2[i1] = (Fe[k1].h - 64) / Ci;
                ai3[i1] = k1;
                i1++;
            }

        try
        {
            for(int l1 = 0; l1 <= i1; l1++)
                if(Fe[ai3[l1]].c == s1)
                {
                    int i2 = Math.abs(Math.abs(Ri) - Math.abs(ai1[l1]));
                    int j2 = Math.abs(Math.abs(Si) - Math.abs(ai2[l1]));
                    if(i2 == 0 || j2 == 0)
                    {
                        if((double)(i2 + j2) < d1)
                        {
                            d1 = i2 + j2;
                            j1 = ai3[l1];
                        }
                    } else
                    if((double)(i2 + j2) * 0.5D < d1)
                    {
                        d1 = (double)(i2 + j2) * 0.5D;
                        j1 = ai3[l1];
                    }
                }

        }
        catch(Exception exception) { }
        if(j1 > -1 && j1 < E())
            return j1;
        else
            return -1;
    }

    public int c(int i1)
    {
        for(int j1 = 0; j1 < lj.length; j1++)
            if(lj[j1] == i1 && j1 != yc)
            {
                yc = j1;
                return j1;
            }

        return -1;
    }

    public void d(int i1)
    {
        for(int j1 = 0; j1 < lj.length; j1++)
            if(lj[j1] == i1)
            {
                Ig = j1;
                ki = 0;
                gf = f.d[lj[j1]];
            }

    }

    public void e(int i1, int j1)
    {
        t(i1);
        ak[0] = 610;
        Oj[0] = j1;
        Pj[0] = i1;
        fb(0);
    }

    public void f(int i1, int j1)
    {
        int k1 = c(i1);
        int l1 = c(j1);
        d(k1);
        ak[0] = 610;
        Oj[0] = l1;
        Pj[0] = k1;
        fb(0);
    }

    public void e(int i1)
    {
        int j1 = f.J;
        int k1 = di + wj[i1];
        if(k1 < 10)
            k1 = 10;
        int l1 = (k1 * f.kb[uj[i1]]) / 100;
        super.nb.a(157);
        super.nb.e(uj[i1]);
        super.nb.b(l1);
        super.nb.i();
    }

    public void f(int i1)
    {
        int j1 = i(i1);
        int k1 = f.J;
        int l1 = di + wj[j1];
        if(l1 < 10)
            l1 = 10;
        int i2 = (l1 * f.kb[i1]) / 100;
        super.nb.a(157);
        super.nb.e(uj[j1]);
        super.nb.b(i2);
        super.nb.i();
    }

    public void g(int i1)
    {
        int j1 = f.J;
        int k1 = ci + wj[i1];
        if(k1 < 10)
            k1 = 10;
        int l1 = (k1 * f.kb[uj[i1]]) / 100;
        super.nb.a(211);
        super.nb.e(uj[i1]);
        super.nb.b(l1);
        super.nb.i();
    }

    public void h(int i1)
    {
        int j1 = i(i1);
        int k1 = f.J;
        int l1 = ci + wj[j1];
        if(l1 < 10)
            l1 = 10;
        int i2 = (l1 * f.kb[i1]) / 100;
        super.nb.a(211);
        super.nb.e(uj[j1]);
        super.nb.b(i2);
        super.nb.i();
    }

    public int i(int i1)
    {
        for(int j1 = 0; j1 <= wj.length; j1++)
            if(uj[j1] == i1)
                return j1;

        return -1;
    }

    public int a(int i1, int j1)
    {
        return Mb.nextInt((j1 + 1) - i1) + i1;
    }

    public int j(int i1)
    {
        for(int j1 = 0; j1 < Jj.length; j1++)
        {
            int k1 = Jj[j1];
            if(k1 == i1)
                return Hj[j1] + Qg;
        }

        return -1;
    }

    public int k(int i1)
    {
        for(int j1 = 0; j1 < Jj.length; j1++)
        {
            int k1 = Jj[j1];
            if(k1 == i1)
                return Ij[j1] + Rg;
        }

        return -1;
    }

    public boolean a(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < lh; l1++)
            if(Jj[l1] == i1 && j(l1) == j1 && k(l1) == k1)
                return true;

        return false;
    }

    public int l(int i1)
    {
        for(int j1 = 0; j1 < lh; j1++)
            if(Jj[j1] == i1 && n(i1) == j(j1) && o(i1) == k(j1))
                return j1;

        return -1;
    }

    public void m(int i1)
    {
        int j1 = l(i1);
        super.nb.a(104);
        super.nb.e(Hj[j1]);
        super.nb.e(Ij[j1]);
        super.nb.e(j1);
        super.nb.e(i1);
        super.nb.i();
    }

    public int n(int i1)
    {
        int j1 = 1;
        byte byte0 = 50;
        int k1 = C();
        int l1 = D();
        if(a(i1, k1, l1))
            return k1;
        for(int i2 = 1; i2 <= byte0; i2++)
        {
            for(int j2 = 1; j2 <= i2; j2++)
            {
                k1 += j1;
                if(a(i1, k1, l1))
                    return k1;
            }

            for(int k2 = 1; k2 <= i2; k2++)
            {
                l1 += j1;
                if(a(i1, k1, l1))
                    return k1;
            }

            j1 = 0 - j1;
        }

        return -1;
    }

    public int o(int i1)
    {
        int j1 = 1;
        byte byte0 = 50;
        int k1 = C();
        int l1 = D();
        if(a(i1, k1, l1))
            return l1;
        for(int i2 = 1; i2 <= byte0; i2++)
        {
            for(int j2 = 1; j2 <= i2; j2++)
            {
                k1 += j1;
                if(a(i1, k1, l1))
                    return l1;
            }

            for(int k2 = 1; k2 <= i2; k2++)
            {
                l1 += j1;
                if(a(i1, k1, l1))
                    return l1;
            }

            j1 = 0 - j1;
        }

        return -1;
    }

    public int p(int i1)
    {
        return nk[i1];
    }

    public int q(int i1)
    {
        int j1 = f.J;
        int k1 = 0;
        for(int l1 = 0; l1 < mk.length; l1++)
            if(mk[l1] == i1)
                k1 = nk[l1];

        return k1;
    }

    public int r(int i1)
    {
        return db(lj[i1]);
    }

    public void g(int i1, int j1)
    {
        s(i1);
        ak[0] = 800;
        Oj[0] = Ke[j1].e;
        Pj[0] = fh;
        fb(0);
    }

    public void s(int i1)
    {
        fh = i1;
        ki = 0;
    }

    public void t(int i1)
    {
        Ig = i1;
        ki = 0;
        gf = f.d[lj[i1]];
    }

    public void h(int i1, int j1)
    {
        t(i1);
        for(int k1 = 0; k1 < Fj.length; k1++)
        {
            int l1 = Fj[k1];
            if(l1 == j1)
            {
                ak[0] = 410;
                jk[0] = Dj[k1];
                kk[0] = Ej[k1];
                Oj[0] = Gj[k1];
                Pj[0] = Fj[k1];
                Qj[0] = i1;
                fb(0);
                B();
            }
        }

    }

    public void t()
    {
        ve = true;
        super.nb.a(38);
        super.nb.i();
    }

    public void u()
    {
        Rd = true;
        super.nb.a(65);
        super.nb.i();
    }

    public void v()
    {
        Qd = false;
        super.nb.a(178);
        super.nb.i();
    }

    public void w()
    {
        Pd = true;
        super.nb.a(245);
        super.nb.i();
    }

    public void x()
    {
        fe = true;
        super.nb.a(24);
        super.nb.i();
    }

    public void y()
    {
        ee = false;
        super.nb.a(82);
        super.nb.i();
    }

    public void e(String s1)
    {
        int i1 = o.a(s1);
        a(o.a, i1);
        s1 = o.a(o.a, 0, i1);
        s1 = n.a(s1);
        Le.o = 150;
        Le.d = s1;
        a(Dk[62] + Le.c + Dk[61] + s1, 2);
    }

    public void u(int i1)
    {
        int j1 = 0;
        do
        {
            if(j1 >= lj.length)
                break;
            if(lj[j1] == i1)
            {
                super.nb.a(170);
                super.nb.e(j1);
                super.nb.i();
                break;
            }
            j1++;
        } while(true);
    }

    public void remove(int i1)
    {
        super.nb.a(170);
        super.nb.e(i1);
        super.nb.i();
    }

    public void v(int i1)
    {
        int j1 = 0;
        do
        {
            if(j1 >= lj.length)
                break;
            if(lj[j1] == i1)
            {
                super.nb.a(12);
                super.nb.e(j1);
                super.nb.i();
                break;
            }
            j1++;
        } while(true);
    }

    public void w(int i1)
    {
        super.nb.a(12);
        super.nb.e(i1);
        super.nb.i();
    }

    public void x(int i1)
    {
        for(int j1 = 0; j1 < lj.length; j1++)
            if(lj[j1] == i1)
            {
                super.nb.a(196);
                super.nb.e(j1);
                super.nb.i();
                Ig = -1;
                ki = 0;
            }

    }

    public void y(int i1)
    {
        super.nb.a(196);
        super.nb.e(i1);
        super.nb.i();
        Ig = -1;
        ki = 0;
    }

    public void z(int i1)
    {
        super.nb.a(36);
        super.nb.e(i1);
        super.nb.i();
    }

    public void A(int i1)
    {
        super.nb.a(89);
        super.nb.e(i1);
        super.nb.i();
    }

    public void B(int i1)
    {
        super.nb.a(250);
        super.nb.e(i1);
        super.nb.i();
    }

    public void C(int i1)
    {
        super.nb.a(210);
        super.nb.e(i1);
        super.nb.i();
    }

    public int f(String s1)
    {
        for(int i1 = 0; i1 < xg; i1++)
            if(Ke[i1].c != null && Ke[i1].c.equalsIgnoreCase(s1))
                return Ke[i1].e;

        return -1;
    }

    public void D(int i1)
    {
        ak[0] = 720;
        jk[0] = Fe[i1].g;
        kk[0] = Fe[i1].h;
        Oj[0] = Fe[i1].e;
        ki = 0;
        fb(0);
        B();
    }

    public void g(String s1)
    {
        int i1 = 0;
        do
        {
            if(i1 >= E())
                break;
            String s2 = f.k[Fe[i1].i];
            if(s2.equalsIgnoreCase(s1))
            {
                D(i1);
                break;
            }
            i1++;
        } while(true);
    }

    public void a(byte abyte0[])
    {
        int i1 = 1;
        byte byte0 = 0;
        byte abyte1[] = new byte[10200];
        int j1;
        for(j1 = 0; j1 < 255;)
        {
            int k1 = abyte0[i1++] & 0xff;
            for(int i2 = 0; i2 < k1; i2++)
                abyte1[j1++] = byte0;

            byte0 = (byte)(255 - byte0);
        }

label0:
        for(int l1 = 1; l1 < 40; l1++)
        {
            int j2 = 0;
            do
            {
                if(j2 >= 255)
                    continue label0;
                int k2 = abyte0[i1++] & 0xff;
                for(int l2 = 0; l2 < k2; l2++)
                {
                    abyte1[j1] = abyte1[j1 - 255];
                    j1++;
                    j2++;
                }

                if(j2 < 255)
                {
                    abyte1[j1] = (byte)(255 - abyte1[j1 - 255]);
                    j1++;
                    j2++;
                }
            } while(true);
        }

        System.out.println(Dk[742]);
        a(Dk[743], abyte1);
    }

    public void a(String s1, byte abyte0[])
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s1);
            fileoutputstream.write(66);
            fileoutputstream.write(77);
            int i1 = 1342;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 62;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 256;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(255);
            fileoutputstream.write(0);
            int j1 = 9945;
            for(int k1 = 0; k1 < 40; k1++)
            {
                for(int l1 = 0; l1 < 32; l1++)
                {
                    byte byte0 = 0;
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        byte0 = (byte)(2 * byte0);
                        if(l1 == 31 && i2 == 7)
                            continue;
                        if(abyte0[j1] != 0)
                            byte0++;
                        j1++;
                    }

                    fileoutputstream.write(byte0);
                }

                j1 -= 510;
            }

            fileoutputstream.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(Dk[741]);
        }
    }

    public int a(char c1, String s1)
    {
        return s1.indexOf(c1) + 1;
    }

    public String a(int i1, int j1, String s1)
    {
        String s2 = "";
        for(int k1 = i1 - 1; k1 < j1; k1++)
            s2 = s2 + s1.charAt(k1);

        return s2;
    }

    public void z()
    {
        int i1 = oc.get(10);
        int j1 = oc.get(12);
        int k1 = oc.get(13);
        String s1 = "" + i1;
        String s2 = "" + j1;
        String s3 = "" + k1;
        if(j1 < 10)
            s2 = "0" + j1;
        if(i1 < 10)
            s1 = "0" + i1;
        if(k1 < 10)
            s3 = "0" + k1;
        Wb = Dk[254] + s1 + Dk[253] + s2 + Dk[253] + s3 + Dk[252];
    }

    public void A()
    {
        if(Tc)
            try
            {
                a(Xb, Yb, false);
                System.out.println(Dk[720] + super.ib);
                if(pc != -1)
                {
                    ab(pc);
                    d(Dk[721] + pc);
                } else
                {
                    ab(1);
                }
            }
            catch(Exception exception)
            {
                System.out.println(Dk[718]);
            }
        else
            System.out.println(Dk[719]);
    }

    public void E(int i1)
    {
        if(Tc)
            if(i1 == 51)
            {
                b.tb = Dk[562];
                b.yb = 43594;
                re = false;
                System.out.println(Dk[558]);
            } else
            if(i1 == 52)
            {
                b.tb = Dk[562];
                b.yb = 43595;
                re = true;
                System.out.println(Dk[556]);
            } else
            if(i1 == 53)
            {
                b.tb = Dk[557];
                b.yb = 43594;
                re = false;
                System.out.println(Dk[564]);
            } else
            if(i1 == 54)
            {
                b.tb = Dk[557];
                b.yb = 43595;
                re = true;
                System.out.println(Dk[563]);
            } else
            if(i1 == 55)
            {
                b.tb = Dk[560];
                b.yb = 43594;
                re = false;
                System.out.println(Dk[561]);
            } else
            if(i1 == 56)
            {
                b.tb = Dk[560];
                b.yb = 43595;
                re = true;
                System.out.println(Dk[559]);
            } else
            {
                b.tb = Dk[562];
                b.yb = 43594;
                re = false;
                System.out.println(Dk[558]);
            }
    }

    public void F(int i1)
    {
        super.nb.a(203);
        super.nb.f(i1);
        super.nb.i();
        ie = false;
        System.out.println(Dk[712] + i1 + ")");
        ab.a(Dk[57]);
    }

    public void i(int i1, int j1)
    {
        super.nb.a(83);
        super.nb.e(i1);
        super.nb.e(j1);
        super.nb.i();
    }

    public void j(int i1, int j1)
    {
        super.nb.a(145);
        super.nb.e(i1);
        super.nb.e(j1);
        super.nb.i();
    }

    public void B()
    {
        super.N = 0;
    }

    public void b(int i1, int j1, int k1)
    {
        ak[0] = 220;
        jk[0] = i1 - Qg;
        kk[0] = j1 - Rg;
        Oj[0] = k1;
        fb(0);
        B();
    }

    public void h(String s1)
    {
        int i1 = f.J;
        String s2 = "";
        for(int j1 = 0; j1 < Jj.length; j1++)
        {
            s2 = f.d[Jj[j1]];
            if(s2.equalsIgnoreCase(s1))
            {
                ak[0] = 220;
                jk[0] = Hj[j1];
                kk[0] = Ij[j1];
                Oj[0] = Jj[j1];
                fb(0);
                B();
                return;
            }
        }

        if(s2 == null)
            System.out.println(Dk[474]);
    }

    public void G(int i1)
    {
        for(int j1 = 0; j1 < Jj.length; j1++)
        {
            int k1 = Jj[j1];
            if(k1 == i1)
            {
                ak[0] = 220;
                jk[0] = Hj[j1];
                kk[0] = Ij[j1];
                Oj[0] = Jj[j1];
                fb(0);
                B();
            }
        }

    }

    public int H(int i1)
    {
        for(int j1 = 0; j1 < Yg; j1++)
        {
            int k1 = Fj[j1];
            if(k1 == i1)
                return Dj[j1] + Qg;
        }

        return -1;
    }

    public int I(int i1)
    {
        for(int j1 = 0; j1 < Yg; j1++)
        {
            int k1 = Fj[j1];
            if(k1 == i1)
                return Ej[j1] + Rg;
        }

        return -1;
    }

    public boolean c(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < Yg; l1++)
            if(Fj[l1] == i1 && H(l1) + Qg == j1 && I(l1) + Rg == k1)
                return true;

        return false;
    }

    public int J(int i1)
    {
        for(int j1 = 0; j1 < Yg; j1++)
            if(Fj[j1] == i1 && K(i1) == H(j1) && L(i1) == I(j1))
                return j1;

        return -1;
    }

    public int K(int i1)
    {
        int j1 = 1;
        byte byte0 = 50;
        int k1 = C();
        int l1 = D();
        if(c(i1, k1, l1))
            return k1;
        for(int i2 = 1; i2 <= byte0; i2++)
        {
            for(int j2 = 1; j2 <= i2; j2++)
            {
                k1 += j1;
                if(c(i1, k1, l1))
                    return k1;
            }

            for(int k2 = 1; k2 <= i2; k2++)
            {
                l1 += j1;
                if(c(i1, k1, l1))
                    return k1;
            }

            j1 = 0 - j1;
        }

        return -1;
    }

    public int L(int i1)
    {
        int j1 = 1;
        byte byte0 = 50;
        int k1 = C();
        int l1 = D();
        if(c(i1, k1, l1))
            return l1;
        for(int i2 = 1; i2 <= byte0; i2++)
        {
            for(int j2 = 1; j2 <= i2; j2++)
            {
                k1 += j1;
                if(c(i1, k1, l1))
                    return l1;
            }

            for(int k2 = 1; k2 <= i2; k2++)
            {
                l1 += j1;
                if(c(i1, k1, l1))
                    return l1;
            }

            j1 = 0 - j1;
        }

        return -1;
    }

    public void M(int i1)
    {
        int j1 = 0;
        do
        {
            if(j1 >= Yg)
                break;
            int k1 = Fj[j1];
            if(k1 == i1)
            {
                ak[0] = 420;
                jk[0] = Dj[j1];
                kk[0] = Ej[j1];
                Oj[0] = Gj[j1];
                Pj[0] = Fj[j1];
                fb(0);
                B();
                break;
            }
            j1++;
        } while(true);
    }

    public void N(int i1)
    {
        ak[0] = 2400;
        jk[0] = Dj[i1];
        kk[0] = Ej[i1];
        Oj[0] = Gj[i1];
        Pj[0] = Fj[i1];
        fb(0);
        B();
    }

    public void O(int i1)
    {
        ak[0] = 420;
        jk[0] = Dj[i1];
        kk[0] = Ej[i1];
        Oj[0] = Gj[i1];
        Pj[0] = Fj[i1];
        fb(0);
        B();
    }

    public void k(int i1, int j1)
    {
        ak[0] = 420;
        jk[0] = i1 - Qg;
        kk[0] = j1 - Rg;
        fb(0);
        B();
    }

    public void P(int i1)
    {
        for(int j1 = 0; j1 < Fj.length; j1++)
        {
            int k1 = Fj[j1];
            if(k1 == i1)
            {
                ak[0] = 2400;
                jk[0] = Dj[j1];
                kk[0] = Ej[j1];
                Oj[0] = Gj[j1];
                Pj[0] = Fj[j1];
                fb(0);
                B();
                System.out.println(Dk[207] + (Dj[j1] + Qg) + "," + (Ej[j1] + Rg) + "," + Gj[j1] + "," + Fj[j1] + ")");
            }
        }

    }

    public void Q(int i1)
    {
        ak[0] = 220;
        jk[0] = Hj[i1];
        kk[0] = Ij[i1];
        Oj[0] = Jj[i1];
        fb(0);
        B();
    }

    public int R(int i1)
    {
        int ai1[] = new int[1500];
        int ai2[] = new int[1500];
        int ai3[] = new int[1500];
        int j1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d1 = 9999999D;
        int k1 = -1;
        for(int l1 = 0; l1 < 1500; l1++)
            if(Jj[l1] == i1)
            {
                ai1[j1] = Hj[l1];
                ai2[j1] = Ij[l1];
                ai3[j1] = l1;
                j1++;
            }

        try
        {
            for(int i2 = 0; i2 <= j1; i2++)
                if(Jj[ai3[i2]] == i1)
                {
                    int j2 = Math.abs(Math.abs(Ri) - Math.abs(ai1[i2]));
                    int k2 = Math.abs(Math.abs(Si) - Math.abs(ai2[i2]));
                    if(j2 == 0 || k2 == 0)
                    {
                        if((double)(j2 + k2) < d1)
                        {
                            d1 = j2 + k2;
                            k1 = ai3[i2];
                        }
                    } else
                    if((double)(j2 + k2) * 0.5D < d1)
                    {
                        d1 = (double)(j2 + k2) * 0.5D;
                        k1 = ai3[i2];
                    }
                }

        }
        catch(Exception exception) { }
        if(k1 > -1 && k1 <= 1500)
            return k1;
        else
            return -1;
    }

    public int S(int i1)
    {
        int ai1[] = new int[Fj.length];
        int ai2[] = new int[Fj.length];
        int ai3[] = new int[Fj.length];
        int j1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d1 = 9999999D;
        int k1 = -1;
        for(int l1 = 0; l1 < Fj.length; l1++)
            if(Fj[l1] == i1)
            {
                ai1[j1] = Dj[l1];
                ai2[j1] = Ej[l1];
                ai3[j1] = l1;
                j1++;
            }

        try
        {
            for(int i2 = 0; i2 <= j1; i2++)
                if(Fj[ai3[i2]] == i1)
                {
                    int j2 = Math.abs(Math.abs(Ri) - Math.abs(ai1[i2]));
                    int k2 = Math.abs(Math.abs(Si) - Math.abs(ai2[i2]));
                    if(j2 == 0 || k2 == 0)
                    {
                        if((double)(j2 + k2) < d1)
                        {
                            d1 = j2 + k2;
                            k1 = ai3[i2];
                        }
                    } else
                    if((double)(j2 + k2) * 0.5D < d1)
                    {
                        d1 = (double)(j2 + k2) * 0.5D;
                        k1 = ai3[i2];
                    }
                }

        }
        catch(Exception exception) { }
        if(k1 > -1)
            return k1;
        else
            return -1;
    }

    public void T(int i1)
    {
        super.nb.a(164);
        super.nb.e(i1);
        super.nb.i();
        ze[i1] = false;
        k(Dk[51]);
    }

    public void U(int i1)
    {
        super.nb.a(17);
        super.nb.e(i1);
        super.nb.i();
        ze[i1] = true;
        k(Dk[60]);
    }

    public int C()
    {
        return Ri + Qg;
    }

    public int D()
    {
        return Si + Rg;
    }

    public void V(int i1)
    {
        for(int j1 = 0; j1 < lj.length; j1++)
            if(lj[j1] == i1)
            {
                super.nb.a(219);
                super.nb.e(j1);
                super.nb.i();
                return;
            }

    }

    public void W(int i1)
    {
        if(i1 > 0)
        {
            ak[0] = 725;
            jk[0] = Fe[i1].g;
            kk[0] = Fe[i1].h;
            Oj[0] = Fe[i1].e;
            fb(0);
            B();
        }
    }

    public void X(int i1)
    {
        int j1 = Z(i1);
        ak[0] = 720;
        jk[0] = Fe[j1].g;
        kk[0] = Fe[j1].h;
        Oj[0] = Fe[j1].e;
        ki = 0;
        fb(0);
        B();
    }

    public void l(int i1, int j1)
    {
        Sc = true;
        zf[0] = Dk[263];
        sf[0] = "";
        ak[0] = 920;
        jk[0] = i1 - Qg;
        kk[0] = j1 - Rg;
        ak[0] = 920;
        fb(0);
        System.out.println(Dk[7] + i1 + "," + j1 + ")");
    }

    public void Y(int i1)
    {
        if(i1 > 0)
        {
            ak[0] = 715;
            jk[0] = Fe[i1].g;
            kk[0] = Fe[i1].h;
            Oj[0] = Fe[i1].e;
            fb(0);
        }
    }

    public int Z(int i1)
    {
        int ai1[] = new int[E()];
        int ai2[] = new int[E()];
        int ai3[] = new int[E()];
        int j1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        double d1 = 9999999D;
        int k1 = -1;
        for(int l1 = 0; l1 < E(); l1++)
            if(Fe[l1].i == i1 && Fe[l1].k != 8 && Fe[l1].k != 9)
            {
                ai1[j1] = (Fe[l1].g - 64) / Ci;
                ai2[j1] = (Fe[l1].h - 64) / Ci;
                ai3[j1] = l1;
                j1++;
            }

        try
        {
            for(int i2 = 0; i2 <= j1; i2++)
                if(Fe[ai3[i2]].i == i1)
                {
                    int j2 = Math.abs(Math.abs(Ri) - Math.abs(ai1[i2]));
                    int k2 = Math.abs(Math.abs(Si) - Math.abs(ai2[i2]));
                    if(j2 == 0 || k2 == 0)
                    {
                        if((double)(j2 + k2) < d1)
                        {
                            d1 = j2 + k2;
                            k1 = ai3[i2];
                        }
                    } else
                    if((double)(j2 + k2) * 0.5D < d1)
                    {
                        d1 = (double)(j2 + k2) * 0.5D;
                        k1 = ai3[i2];
                    }
                }

        }
        catch(Exception exception) { }
        if(k1 > -1 && k1 < E())
            return k1;
        else
            return -1;
    }

    public int E()
    {
        return hi;
    }

    public boolean F()
    {
        return Le.k == 8 || Le.k == 9;
    }

    public int G()
    {
        return (Wh * 100) / 750;
    }

    public void ab(int i1)
    {
        hh = 0;
        Cg = i1;
        super.nb.a(119);
        super.nb.f(Cg);
        super.nb.i();
        if(!Cc)
            Ic = i1;
        System.out.println(Dk[722] + i1 + ")");
    }

    public mudclient()
    {
        Mb = new Random(1337L);
        Nb = Toolkit.getDefaultToolkit();
        Ob = new File(Dk[96]);
        Pb = 1004;
        Qb = 1005;
        Rb = 1002;
        Sb = 1003;
        Xb = "";
        Yb = "";
        Zb = "";
        ac = false;
        bc = false;
        cc = false;
        dc = false;
        ec = false;
        fc = false;
        gc = false;
        hc = false;
        ic = false;
        jc = false;
        mc = true;
        nc = true;
        oc = new GregorianCalendar();
        pc = -1;
        qc = 101;
        rc = "";
        sc = "";
        tc = "";
        uc = false;
        vc = 1;
        wc = 1;
        xc = 1;
        Cc = false;
        Dc = -1;
        Ec = 0;
        Fc = false;
        Gc = 0;
        Hc = 0;
        Ic = -1;
        Jc = -1;
        Kc = -1;
        Oc = null;
        Qc = -1;
        Rc = -1;
        Sc = false;
        Tc = false;
        Uc = false;
        rf = (new String[] {
            Dk[125], Dk[142], Dk[152], Dk[99], Dk[85], Dk[68], Dk[106], Dk[134], Dk[139], Dk[93], 
            Dk[122], Dk[70], Dk[74], Dk[72], Dk[155], Dk[147], Dk[66], Dk[136]
        });
        uf = (new String[] {
            Dk[125], Dk[142], Dk[152], Dk[99], Dk[85], Dk[68], Dk[106], Dk[134], Dk[120], Dk[93], 
            Dk[122], Dk[70], Dk[74], Dk[72], Dk[155], Dk[147], Dk[66], Dk[136]
        });
        xf = (new String[] {
            Dk[94], Dk[109], Dk[65], Dk[150], Dk[112], Dk[115], Dk[86], Dk[73], Dk[81], Dk[133], 
            Dk[130], Dk[151], Dk[78], Dk[92], Dk[121], Dk[108], Dk[113], Dk[80], Dk[137], Dk[101], 
            Dk[100], Dk[82], Dk[118], Dk[135], Dk[146], Dk[119], Dk[131], Dk[124], Dk[64], Dk[145], 
            Dk[104], Dk[116], Dk[71], Dk[90], Dk[128], Dk[79], Dk[140], Dk[69], Dk[105], Dk[144], 
            Dk[123], Dk[83], Dk[89], Dk[95], Dk[91], Dk[148], Dk[110], Dk[88], Dk[129], Dk[97]
        });
        yf = (new String[] {
            Dk[77], Dk[154], Dk[132], Dk[106], Dk[68]
        });
        Af = (new String[] {
            Dk[84], Dk[126], Dk[141], Dk[76], Dk[117], Dk[156], Dk[75], Dk[98], Dk[143], Dk[103], 
            Dk[107], Dk[102], Dk[149], Dk[114], Dk[111], Dk[138], Dk[127], Dk[67]
        });
        Bf = 1;
        Cf = 912;
        Ef = 250;
        Ff = 5;
        Gf = 50;
        Hf = 18;
        If = 500;
        Jf = 1500;
        Kf = 5000;
        Lf = 5000;
        Mf = 500;
        Nf = 4000;
        Of = 500;
        Pf = 8000;
        int i1 = f.J;
        ri = 1;
        Hd = 512;
        Id = 384;
        Vc = true;
        ye = new boolean[1500];
        dj = new int[8];
        ej = new int[8];
        Nd = false;
        Od = false;
        Pd = false;
        Qd = false;
        Rd = false;
        Sd = false;
        Ld = true;
        Uf = 512;
        Vf = 334;
        Wf = 9;
        ze = new boolean[50];
        Td = false;
        cf = "";
        df = "";
        Xf = 550;
        fj = new int[99];
        gj = new int[50];
        hj = new int[50];
        ij = new int[50];
        jj = new int[20];
        kj = new int[20];
        og = 30;
        lj = new int[35];
        mj = new int[35];
        nj = new int[35];
        oj = new int[18];
        Ae = new boolean[50];
        Ud = false;
        Vd = false;
        Wd = false;
        Xd = false;
        Yd = false;
        pj = new int[50];
        qj = new int[50];
        Zd = false;
        sj = new int[18];
        tg = 128;
        tj = new int[50];
        ef = "";
        ff = "";
        uj = new int[256];
        vj = new int[256];
        wj = new int[256];
        xj = new int[500];
        yj = new int[500];
        ae = false;
        zj = new int[500];
        Aj = new int[500];
        be = false;
        Bj = new int[50];
        Cj = new int[50];
        Dj = new int[1500];
        Ej = new int[1500];
        Fj = new int[1500];
        Gj = new int[1500];
        Ig = -1;
        gf = "";
        ce = false;
        Fe = new r[500];
        sf = new String[250];
        Hj = new int[5000];
        Ij = new int[5000];
        Jj = new int[5000];
        Kj = new int[5000];
        tf = new String[5];
        Ue = new u[500];
        Sg = -1;
        Lj = new int[8];
        Mj = new int[8];
        de = false;
        hf = "";
        Nj = new int[5];
        ee = false;
        fe = false;
        Oj = new int[250];
        Pj = new int[250];
        Qj = new int[250];
        eh = -1;
        ge = false;
        fh = -1;
        Ve = new u[1500];
        Rj = new int[500];
        Sj = new int[256];
        Tj = new int[256];
        vf = new String[50];
        Ge = new r[500];
        jf = "";
        Uj = new int[18];
        Be = new boolean[500];
        ph = -1;
        qh = -2;
        Xj = new int[20];
        Yj = new int[20];
        lf = "";
        he = false;
        ie = false;
        je = false;
        ke = false;
        le = false;
        mf = "";
        nf = "";
        me = false;
        Mh = 1;
        Nh = 2;
        Oh = 2;
        Ph = 8;
        Qh = 14;
        Sh = 1;
        ne = false;
        oe = true;
        Zj = new int[50];
        ak = new int[250];
        ck = new int[20];
        dk = new int[20];
        pe = false;
        He = new r[4000];
        Zh = 2;
        ai = 40;
        fi = -1;
        gi = -2;
        qe = false;
        fk = new int[8];
        gk = new int[8];
        wf = new String[5];
        re = true;
        li = 48;
        se = false;
        ni = -1;
        oi = -1;
        pi = -1;
        te = false;
        Ie = new r[500];
        hk = new int[50];
        ik = new int[5];
        jk = new int[250];
        kk = new int[250];
        yi = 1;
        ue = false;
        ve = false;
        Ci = 128;
        mk = new int[256];
        nk = new int[256];
        Je = new r[5000];
        ok = new int[8];
        pk = new int[8];
        qk = new int[8000];
        rk = new int[8000];
        sk = new int[50];
        tk = new int[50];
        uk = new int[50];
        vk = new int[50];
        wk = new int[20];
        xk = new int[20];
        yk = new int[50];
        Qi = 2;
        Le = new r();
        Ti = -1;
        we = true;
        zk = new int[8192];
        Ak = new int[8192];
        Ke = new r[500];
        Bk = new int[250];
        zf = new String[250];
        xe = false;
        We = new u[1000];
        bj = 0xbc614e;
        System.out.println(Dk[87]);
        System.out.println(Dk[153]);
        System.out.println(Dk[87]);
        lc = true;
        a.b();
    }

    public Image createImage(int i1, int j1)
    {
        if(!super.j)
        {
            if(a.y != null)
                return a.y.createImage(i1, j1);
            if(y.f != null)
                return y.f.createImage(i1, j1);
            else
                return super.createImage(i1, j1);
        } else
        {
            return null;
        }
    }

    public URL getCodeBase()
    {
        if(y.f != null)
            return y.f.getCodeBase();
        else
            return super.getCodeBase();
    }

    public URL getDocumentBase()
    {
        if(y.f != null)
            return y.f.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public Graphics getGraphics()
    {
        if(!super.j)
        {
            if(a.y != null)
                return a.y.getGraphics();
            if(y.f != null)
                return y.f.getGraphics();
            else
                return super.getGraphics();
        } else
        {
            return null;
        }
    }

    public String getParameter(String s1)
    {
        if(y.f != null)
            return y.f.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    public void c()
    {
        String s1;
        if(we)
            s1 = getDocumentBase().getHost().toLowerCase();
        int i1 = 0;
        for(int j1 = 0; j1 < 99; j1++)
        {
            int l1 = j1 + 1;
            int k2 = (int)((double)l1 + 300D * Math.pow(2D, (double)l1 / 7D));
            i1 += k2;
            fj[j1] = i1 & 0xffffffc;
        }

        try
        {
            String s2 = getParameter(Dk[791]);
            ug = Integer.parseInt(s2);
        }
        catch(Exception exception) { }
        try
        {
            String s3 = getParameter(Dk[788]);
            int i2 = Integer.parseInt(s3);
            if(i2 == 1)
                re = true;
        }
        catch(Exception exception1) { }
        if(we)
            b.yb = 43594;
        super.M = 0;
        b.xb = 1000;
        b.wb = p.b;
        try
        {
            String s4 = getParameter(Dk[792]);
            int j2 = Integer.parseInt(s4);
            b.yb += j2;
            System.out.println(Dk[790] + j2);
        }
        catch(Exception exception2) { }
        jb();
        if(te)
            return;
        Ei = 2000;
        Fi = Ei + 100;
        Gi = Fi + 50;
        Ki = Gi + 1000;
        Hi = Ki + 10;
        Ii = Hi + 50;
        Ji = Ii + 10;
        Ye = getGraphics();
        b(50);
        Xe = new w(Uf, Vf + 12, 4000, this);
        Xe.S = this;
        Xe.a(0, 0, Uf, Vf + 12);
        t.b = false;
        t.E = Fi;
        Pe = new t(Xe, 5);
        int k1 = ((v) (Xe)).m - 199;
        byte byte0 = 36;
        Zg = Pe.b(k1, byte0 + 24, 196, 90, 1, 500, true);
        Te = new t(Xe, 5);
        si = Te.b(k1, byte0 + 40, 196, 126, 1, 500, true);
        Qe = new t(Xe, 5);
        mh = Qe.b(k1, byte0 + 24, 196, 251, 1, 500, true);
        R();
        if(te)
            return;
        qb();
        if(te)
            return;
        De = new g(Xe, 15000, 15000, 1000);
        De.a(Uf / 2, Vf / 2, Uf / 2, Vf / 2, Uf, Wf);
        De.s = 2400;
        De.t = 2400;
        De.u = 1;
        De.v = 2300;
        De.c(-50, -10, -50);
        Ee = new q(De, Xe);
        Ee.w = Ei;
        M();
        if(te)
            return;
        cb();
        if(te)
            return;
        xb();
        if(te)
            return;
        if(re)
            J();
        if(te)
        {
            return;
        } else
        {
            b(100, Dk[789]);
            wb();
            X();
            Z();
            V();
            i();
            lb();
            return;
        }
    }

    public static void i(String s1)
    {
        pf = s1;
        pf = s1;
        qf = true;
        qf = true;
    }

    public void j(String s1)
    {
        boolean flag = v.R;
label0:
        {
            int i1 = f.J;
            if(!Tc)
            {
                Tc = true;
                System.out.println(Dk[354]);
            }
            if(s1.length() > 0)
            {
                Tc = true;
                if(!flag)
                    break label0;
            }
            s1 = s1 + " ";
        }
        if(!s1.equalsIgnoreCase(Dk[351]))
            break MISSING_BLOCK_LABEL_306;
        File file;
        BufferedWriter bufferedwriter;
        file = new File(Dk[385]);
        bufferedwriter = null;
        bufferedwriter = new BufferedWriter(new FileWriter(file));
        int l36 = 0;
        do
        {
            if(l36 >= f.k.length)
                break;
            int k16 = (f.V[l36] + f.Y[l36] + f.W[l36] + f.X[l36]) / 4;
            bufferedwriter.write(Dk[429] + l36 + Dk[434] + f.k[l36] + Dk[473] + k16 + Dk[436] + f.l[l36] + Dk[469]);
            l36++;
        } while(!flag);
        if(bufferedwriter != null)
            bufferedwriter.close();
        break MISSING_BLOCK_LABEL_11593;
        Exception exception74;
        exception74;
        if(bufferedwriter != null)
            bufferedwriter.close();
        throw exception74;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        if(!flag)
            break MISSING_BLOCK_LABEL_11593;
        if(s1.equalsIgnoreCase(Dk[439]))
        {
            try
            {
                System.out.println(Dk[397]);
                y();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[369]))
        {
            try
            {
                System.out.println(Dk[300]);
                x();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[437]))
        {
            try
            {
                System.out.println(Dk[470]);
                w();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[382]))
        {
            try
            {
                System.out.println(Dk[316]);
                v();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[345]))
        {
            try
            {
                System.out.println(Dk[406]);
                u();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[330]))
        {
            try
            {
                System.out.println(Dk[449]);
                t();
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[396]))
        {
            try
            {
                Zd = true;
                System.out.println(Dk[372]);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[380]))
        {
            try
            {
                Lc = new gb(this);
                System.out.println(Dk[467]);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.equalsIgnoreCase(Dk[448]))
        {
            try
            {
                Zd = false;
                System.out.println(Dk[50]);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[435]))
        {
            try
            {
                int j1 = a(' ', s1);
                int l16 = a(',', s1);
                int k29 = Integer.parseInt(s1.substring(j1, l16 - 1));
                String s14 = rf[k29];
                int i41 = sj[k29];
                int j43 = Uj[k29];
                if(s1.substring(l16, s1.length()).equalsIgnoreCase("C"))
                {
                    ab.a(Dk[451] + s14 + " " + i41);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[317] + s14 + " " + j43);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int j1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[366]))
        {
            try
            {
                int k1 = a(' ', s1);
                int i17 = Integer.parseInt(s1.substring(k1, s1.length()));
                String s11 = a(i17);
                if(s11 != null)
                {
                    ab.b(Dk[348] + s11);
                    System.out.println(Dk[357] + s11 + ")");
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                System.out.println(Dk[335]);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int k1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[328]))
        {
            try
            {
                int l1 = a(' ', s1);
                int j17 = Integer.parseInt(s1.substring(l1, s1.length()));
                String s12 = b(j17);
                if(s12 != null)
                {
                    ab.b(Dk[310] + s12);
                    System.out.println(Dk[392] + s12 + ")");
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                System.out.println(Dk[335]);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int l1)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[344]))
        {
            try
            {
                int i2 = a(' ', s1);
                String s10 = s1.substring(i2, s1.length());
                int l29 = a(s10);
                if(l29 != -1)
                    Y(l29);
                System.out.println(Dk[381] + s10 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int i2)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[299]))
        {
            try
            {
                int j2 = a(' ', s1);
                int k17 = Integer.parseInt(s1.substring(j2, s1.length()));
                i(k17);
                System.out.println(Dk[431] + k17 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int j2)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[443]))
        {
            try
            {
                int k2 = a(' ', s1);
                int l17 = Integer.parseInt(s1.substring(k2, s1.length()));
                e(l17);
                System.out.println(Dk[312] + l17 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int k2)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[450]))
        {
            try
            {
                int l2 = a(' ', s1);
                int i18 = Integer.parseInt(s1.substring(l2, s1.length()));
                f(i18);
                System.out.println(Dk[433] + i18 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int l2)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[329]))
        {
            try
            {
                int i3 = a(' ', s1);
                int j18 = Integer.parseInt(s1.substring(i3, s1.length()));
                g(j18);
                System.out.println(Dk[389] + j18 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int i3)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[468]))
        {
            try
            {
                int j3 = a(' ', s1);
                int k18 = Integer.parseInt(s1.substring(j3, s1.length()));
                h(k18);
                System.out.println(Dk[464] + k18 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int j3)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[387]))
        {
            try
            {
                ab.a(Dk[458] + Zf);
                break MISSING_BLOCK_LABEL_11593;
            }
            // Misplaced declaration of an exception variable
            catch(int j3)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(!s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[342]))
            break MISSING_BLOCK_LABEL_2239;
label1:
        {
            int k3 = a(' ', s1);
            int l18 = Integer.parseInt(s1.substring(k3, s1.length()));
            if(l18 < 0 || l18 > 100)
            {
                qc = 101;
                if(!flag)
                    break label1;
            }
            qc = l18;
        }
        d(Dk[325] + qc + ".");
        break MISSING_BLOCK_LABEL_11593;
        k3;
        System.out.println(Dk[404]);
        if(!flag)
            break MISSING_BLOCK_LABEL_11593;
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[346]))
        {
            try
            {
                int l3 = a(' ', s1);
                int i19 = Integer.parseInt(s1.substring(l3, s1.length()));
                int i30 = R(i19);
                if(i30 > -1 && i30 <= 1500)
                    Q(i30);
                System.out.println(Dk[447] + i30 + "," + Hj[i30] + "," + Ij[i30] + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception2)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[394]))
        {
            try
            {
                int i4 = a(' ', s1);
                int j19 = Integer.parseInt(s1.substring(i4, s1.length()));
                if(j19 > -1)
                    m(j19);
                System.out.println(Dk[447] + j19 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception3)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[367]))
        {
            try
            {
                int j4 = a(' ', s1);
                int k19 = Integer.parseInt(s1.substring(j4, s1.length()));
                int j30 = J(k19);
                if(j30 > -1)
                {
                    O(j30);
                    System.out.println(Dk[349] + j30 + ")");
                }
                System.out.println(Dk[349] + k19 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception4)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[438]))
        {
            try
            {
                int k4 = a(' ', s1);
                int l19 = Integer.parseInt(s1.substring(k4, s1.length()));
                int k30 = J(l19);
                if(k30 > -1)
                    N(k30);
                System.out.println(Dk[403] + l19 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception5)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[356]))
        {
            try
            {
                int l4 = a(' ', s1);
                int i20 = Integer.parseInt(s1.substring(l4, s1.length()));
                int l30 = q(i20);
                if(l30 < 1)
                {
                    ab.a(Dk[409]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[338] + l30);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception6)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[440]))
        {
            try
            {
                int i5 = a(' ', s1);
                int j20 = Integer.parseInt(s1.substring(i5, s1.length()));
                int i31 = p(j20);
                if(i31 < 1)
                {
                    ab.a(Dk[377]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[318] + i31);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception7)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[445]))
        {
            try
            {
                int j5 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(j5 != -1)
                {
                    ab(j5);
                    System.out.println(Dk[405] + j5 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception8)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[362]))
        {
            try
            {
                int k5 = a(' ', s1);
                int k20 = Integer.parseInt(s1.substring(k5, s1.length()));
                int j31 = r(k20);
                if(j31 < 1)
                {
                    ab.a(Dk[359]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[347] + j31);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception9)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[353]))
        {
            try
            {
                int l5 = a(' ', s1);
                int l20 = Integer.parseInt(s1.substring(l5, s1.length()));
                int k31 = db(l20);
                if(k31 < 1)
                {
                    ab.a(Dk[412]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[427] + k31);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception10)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[333]))
        {
            try
            {
                int i6 = a(' ', s1);
                int i21 = Integer.parseInt(s1.substring(i6, s1.length()));
                int l31 = J(i21);
                if(l31 == -1)
                {
                    ab.a(Dk[417]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[368]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception11)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[413]))
        {
            try
            {
                int j6 = a(' ', s1);
                int j21 = Integer.parseInt(s1.substring(j6, s1.length()));
                int i32 = Z(j21);
                if(i32 == -1)
                {
                    ab.a(Dk[355]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[472]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception12)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[336]))
        {
            try
            {
                if(F())
                {
                    ab.a(Dk[327]);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[326]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception13)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[352]))
        {
            try
            {
                ab.a(Dk[414] + Cg);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception14)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[439]))
        {
            try
            {
                System.out.println(Dk[397]);
                y();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception15)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[369]))
        {
            try
            {
                System.out.println(Dk[300]);
                x();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception16)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[437]))
        {
            try
            {
                System.out.println(Dk[470]);
                w();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception17)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[382]))
        {
            try
            {
                System.out.println(Dk[316]);
                v();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception18)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[345]))
        {
            try
            {
                System.out.println(Dk[406]);
                u();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception19)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[330]))
        {
            try
            {
                System.out.println(Dk[449]);
                t();
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception20)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[313]))
        {
            try
            {
                System.out.println(Dk[459] + s1.substring(a(' ', s1), s1.length()) + Dk[441]);
                Oc = s1.substring(a(' ', s1), s1.length());
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception21)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[410]))
        {
            try
            {
                String s2 = s1.substring(a(' ', s1), s1.length());
                d(s2);
                System.out.println(Dk[307] + s2 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception22)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[305]))
        {
            try
            {
                String s3 = s1.substring(a(' ', s1), s1.length());
                e(s3);
                System.out.println(Dk[332] + s3 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception23)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[343]))
        {
            try
            {
                String s4 = s1.substring(a(' ', s1), s1.length());
                g(s4);
                System.out.println(Dk[401] + s4 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception24)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[378]))
        {
            try
            {
                int k6 = a(' ', s1);
                int k21 = a(',', s1);
                int j32 = Integer.parseInt(s1.substring(k6, k21 - 1));
                int i37 = Integer.parseInt(s1.substring(k21, s1.length()));
                if(j32 != -1 && i37 != -1)
                {
                    d(j32, i37);
                    System.out.println(Dk[303] + j32 + "," + i37 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception25)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[384]))
        {
            try
            {
                int l6 = a(' ', s1);
                int l21 = a(',', s1);
                int k32 = Integer.parseInt(s1.substring(l6, l21 - 1));
                int j37 = Integer.parseInt(s1.substring(l21, s1.length()));
                if(k32 != -1 && j37 != -1)
                {
                    Qc = k32;
                    Rc = j37;
                    Pc = new hb(this);
                    System.out.println(Dk[460] + k32 + "," + j37 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception26)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[319]))
        {
            try
            {
                int i7 = a(' ', s1);
                int i22 = a(',', s1);
                int l32 = Integer.parseInt(s1.substring(i7, i22 - 1));
                int k37 = Integer.parseInt(s1.substring(i22, s1.length()));
                if(l32 != -1 && k37 != -1)
                {
                    c(l32, k37);
                    System.out.println(Dk[373] + l32 + "," + k37 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception27)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[408]))
        {
            try
            {
                int j7 = a(' ', s1);
                int j22 = a(',', s1);
                int i33 = Integer.parseInt(s1.substring(j7, j22 - 1));
                int l37 = Integer.parseInt(s1.substring(j22, s1.length()));
                if(i33 != -1 && l37 != -1)
                {
                    j(i33, l37);
                    System.out.println(Dk[304] + i33 + "," + l37 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception28)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[374]))
        {
            try
            {
                int k7 = a(' ', s1);
                int k22 = a(',', s1);
                int j33 = Integer.parseInt(s1.substring(k7, k22 - 1));
                int i38 = Integer.parseInt(s1.substring(k22, s1.length()));
                if(j33 != -1 && i38 != -1)
                {
                    i(j33, i38);
                    System.out.println(Dk[331] + j33 + "," + i38 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception29)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[341]))
        {
            try
            {
                int l7 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(l7 != -1)
                {
                    C(l7);
                    System.out.println(Dk[13] + l7 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception30)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[432]))
        {
            try
            {
                String s5 = s1.substring(a(' ', s1), s1.length());
                int l22 = f(s5);
                if(l22 != -1)
                {
                    C(l22);
                    System.out.println(Dk[13] + s5 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception31)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[383]))
        {
            try
            {
                int i8 = a(' ', s1);
                int i23 = a(',', s1);
                int k33 = Integer.parseInt(s1.substring(a(' ', s1), a(',', s1) - 1));
                int j38 = Integer.parseInt(s1.substring(a(',', s1), s1.length()));
                if(j38 != -1 && k33 != -1)
                {
                    g(k33, j38);
                    System.out.println(Dk[398] + k33 + "," + j38 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception32)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[386]))
        {
            try
            {
                int j8 = a(' ', s1);
                int j23 = a(',', s1);
                int l33 = Integer.parseInt(s1.substring(a(' ', s1), a(',', s1) - 1));
                String s15 = s1.substring(a(',', s1), s1.length());
                int j41 = f(s15);
                if(j41 != -1)
                {
                    g(l33, j41);
                    System.out.println(Dk[398] + l33 + "," + s15 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception33)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[308]))
        {
            try
            {
                String s6 = s1.substring(a(' ', s1), s1.length());
                int k23 = f(s6);
                if(k23 != -1)
                {
                    z(k23);
                    System.out.println(Dk[25] + s6 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception34)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[425]))
        {
            try
            {
                String s7 = s1.substring(a(' ', s1), s1.length());
                int l23 = f(s7);
                if(l23 != -1)
                {
                    A(l23);
                    System.out.println(Dk[33] + s7 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception35)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[461]))
        {
            try
            {
                String s8 = s1.substring(a(' ', s1), s1.length());
                int i24 = f(s8);
                if(i24 != -1)
                {
                    B(i24);
                    System.out.println(Dk[21] + s8 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception36)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[388]))
        {
            try
            {
                int k8 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(k8 != -1)
                {
                    u(k8);
                    System.out.println(Dk[444] + k8 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception37)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[391]))
        {
            try
            {
                int l8 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(l8 != -1)
                {
                    remove(l8);
                    System.out.println(Dk[40] + l8 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception38)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[455]))
        {
            try
            {
                int i9 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(i9 != -1)
                {
                    v(i9);
                    System.out.println(Dk[322] + i9 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception39)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[463]))
        {
            try
            {
                int j9 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(j9 != -1)
                {
                    w(j9);
                    System.out.println(Dk[31] + j9 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception40)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[424]))
        {
            try
            {
                int k9 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(k9 != -1)
                {
                    x(k9);
                    System.out.println(Dk[337] + k9 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception41)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[323]))
        {
            try
            {
                int l9 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(l9 != -1)
                {
                    y(l9);
                    System.out.println(Dk[31] + l9 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception42)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[370]))
        {
            try
            {
                String s9 = s1.substring(a(' ', s1), s1.length());
                h(s9);
                System.out.println(Dk[420] + s9 + ")");
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception43)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[358]))
        {
            try
            {
                int i10 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(i10 != -1)
                {
                    G(i10);
                    System.out.println(Dk[41] + i10 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception44)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[457]))
        {
            try
            {
                int j10 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(j10 != -1)
                {
                    int j24 = S(j10);
                    if(j24 != -1)
                    {
                        O(j24);
                        System.out.println(Dk[419] + j10 + ")");
                    }
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception45)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[471]))
        {
            try
            {
                int k10 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(k10 != -1)
                {
                    M(k10);
                    System.out.println(Dk[207] + k10 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception46)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[339]))
        {
            try
            {
                int l10 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(l10 != -1)
                {
                    int k24 = S(l10);
                    N(k24);
                    System.out.println(Dk[426] + l10 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception47)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[466]))
        {
            try
            {
                int i11 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(i11 != -1)
                {
                    P(i11);
                    System.out.println(Dk[301] + i11 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception48)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[340]))
        {
            try
            {
                int j11 = a(' ', s1);
                int l24 = a(',', s1);
                int i34 = s1.lastIndexOf(',');
                int k38 = Integer.parseInt(s1.substring(j11, l24 - 1));
                int k41 = Integer.parseInt(s1.substring(l24, i34 - 1));
                int k43 = Integer.parseInt(s1.substring(i34 + 1, s1.length()));
                if(k38 != -1 && k41 != -1 && k43 != -1)
                {
                    b(k38, k41, k43);
                    System.out.println(Dk[421] + k38 + "," + k41 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception49)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[361]))
        {
            try
            {
                int k11 = a(' ', s1);
                int i25 = a(',', s1);
                int j34 = Integer.parseInt(s1.substring(k11, i25 - 1));
                int l38 = Integer.parseInt(s1.substring(i25, s1.length()));
                if(j34 != -1 && l38 != -1)
                {
                    k(j34, l38);
                    System.out.println(Dk[411] + j34 + "," + l38 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception50)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[306]))
        {
            try
            {
                int l11 = a(' ', s1);
                int j25 = a(',', s1);
                int k34 = Integer.parseInt(s1.substring(l11, j25 - 1));
                int i39 = Integer.parseInt(s1.substring(j25, s1.length()));
                if(k34 != -1 && i39 != -1)
                {
                    h(k34, i39);
                    System.out.println(Dk[334] + k34 + "," + i39 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception51)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[379]))
        {
            try
            {
                int i12 = a(' ', s1);
                int k25 = a(',', s1);
                int l34 = Integer.parseInt(s1.substring(i12, k25 - 1));
                int j39 = Integer.parseInt(s1.substring(k25, s1.length()));
                if(l34 != -1 && j39 != -1)
                {
                    k(l34, j39);
                    System.out.println(Dk[399] + l34 + "," + j39 + ")");
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception52)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[324]))
        {
            try
            {
                int j12 = a(' ', s1);
                int l25 = a(',', s1);
                int i35 = Integer.parseInt(s1.substring(j12, l25 - 1));
                int k39 = fj[0];
                int l41 = 0;
                do
                {
                    if(l41 >= 98)
                        break;
                    if(oj[i35] >= fj[l41])
                        k39 = fj[l41 + 1];
                    l41++;
                } while(!flag);
                String s16 = rf[i35];
                int l43 = oj[i35] / 4;
                int j44 = k39 / 4;
                if(s1.substring(l25, s1.length()).equalsIgnoreCase("C"))
                {
                    ab.a(Dk[360] + l43);
                    System.out.println(Dk[393] + s16 + Dk[390] + l43);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                ab.a(Dk[454] + j44);
                System.out.println(Dk[418] + s16 + Dk[365] + j44);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception53)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[321]))
        {
            try
            {
                d(Dk[376] + s1.substring(5, s1.length()));
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception54)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[462]))
        {
            try
            {
                tg = 128;
                Xf = 700;
                Cf = 912;
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception55)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[350]))
        {
            try
            {
                j();
                mc = true;
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception56)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[309]))
        {
            try
            {
                int k12 = Integer.parseInt(s1.substring(a(' ', s1), s1.length()));
                if(k12 == 51 || k12 == 52 || k12 == 53 || k12 == 54 || k12 == 55 || k12 == 56)
                {
                    E(k12);
                    if(!flag)
                        break MISSING_BLOCK_LABEL_11593;
                }
                System.out.println(Dk[456]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception57)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, s1.indexOf(' ')).equalsIgnoreCase(Dk[430]))
        {
            try
            {
                int l12 = s1.indexOf(' ');
                int i26 = a(',', s1);
                if(l12 != 0 && i26 != 0)
                {
                    Xb = s1.substring(l12 + 1, i26 - 1);
                    Yb = a(i26 + 1, s1.length(), s1);
                    A();
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception58)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[415]))
        {
            try
            {
                int i13 = a(' ', s1);
                int j26 = s1.indexOf(',');
                String s13 = s1.substring(j26 + 1, s1.length());
                int l39 = s13.indexOf(',') + j26 + 1;
                int i42 = s1.lastIndexOf(',');
                if(i13 != -1 && j26 != -1 && l39 != -1 && i42 != -1)
                {
                    int i44 = Integer.parseInt(s1.substring(i13, j26));
                    int k44 = Integer.parseInt(s1.substring(j26 + 1, l39));
                    int i45 = Integer.parseInt(s1.substring(l39 + 1, i42));
                    int j45 = Integer.parseInt(s1.substring(i42 + 1, s1.length()));
                    int k45 = a(i44, i45);
                    int l45 = a(k44, j45);
                    System.out.println(Dk[311] + k45 + "," + l45 + ")");
                    l(k45, l45);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception59)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[302]))
        {
            try
            {
                int j13 = a(' ', s1);
                int k26 = a(',', s1);
                int j35 = a(',', s1);
                if(j13 != 0 && k26 != 0 && j35 != 0)
                {
                    int i40 = Integer.parseInt(a(j13 + 1, k26 - 1, s1));
                    int j42 = Integer.parseInt(a(j35 + 1, s1.length(), s1));
                    f(i40, j42);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception60)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[314]))
        {
            try
            {
                int k13 = a(' ', s1);
                int l26 = a(',', s1);
                int k35 = a(',', s1);
                if(k13 != 0 && l26 != 0 && k35 != 0)
                {
                    int j40 = Integer.parseInt(a(k13 + 1, l26 - 1, s1));
                    int k42 = Integer.parseInt(a(k35 + 1, s1.length(), s1));
                    e(j40, k42);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception61)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[400]))
        {
            try
            {
                int l13 = a(' ', s1);
                int i27 = a(',', s1);
                int l35 = a(',', s1);
                if(l13 != 0 && i27 != 0 && l35 != 0)
                {
                    int k40 = Integer.parseInt(a(l13 + 1, i27 - 1, s1));
                    int l42 = Integer.parseInt(a(l35 + 1, s1.length(), s1));
                    l(k40, l42);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception62)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[407]))
        {
            try
            {
                int i14 = a(' ', s1);
                if(i14 != 0)
                {
                    int j27 = Integer.parseInt(a(i14 + 1, s1.length(), s1));
                    V(j27);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception63)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[465]))
        {
            try
            {
                int j14 = a(' ', s1);
                if(j14 != 0)
                {
                    int k27 = Integer.parseInt(a(j14 + 1, s1.length(), s1));
                    U(k27);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception64)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[315]))
        {
            try
            {
                int k14 = a(' ', s1);
                if(k14 != 0)
                {
                    int l27 = Integer.parseInt(a(k14 + 1, s1.length(), s1));
                    T(l27);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception65)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[422]))
        {
            try
            {
                int l14 = a(' ', s1);
                if(l14 != 0)
                {
                    int i28 = Integer.parseInt(a(l14 + 1, s1.length(), s1));
                    int i36 = Z(i28);
                    Y(i36);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception66)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[371]))
        {
            try
            {
                int i15 = a(' ', s1);
                if(i15 != 0)
                {
                    int j28 = Integer.parseInt(a(i15 + 1, s1.length(), s1));
                    if(j28 != -1)
                        M(j28);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception67)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[364]))
        {
            try
            {
                int j15 = a(' ', s1);
                if(j15 != 0)
                {
                    int k28 = Integer.parseInt(a(j15 + 1, s1.length(), s1));
                    int j36 = Z(k28);
                    if(j36 != -1)
                        W(j36);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception68)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[298]))
        {
            try
            {
                ne = true;
                System.out.println(Dk[320]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception69)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[363]))
        {
            try
            {
                ne = false;
                System.out.println(Dk[63]);
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception70)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[453]))
        {
            try
            {
                int k15 = a(' ', s1);
                if(k15 != 0)
                {
                    int l28 = Integer.parseInt(a(k15 + 1, s1.length(), s1));
                    if(l28 != -1)
                        X(l28);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception71)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[446]))
        {
            try
            {
                int l15 = a(' ', s1);
                if(l15 != 0)
                {
                    int i29 = Integer.parseInt(a(l15 + 1, s1.length(), s1));
                    F(i29);
                }
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception72)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 2).equalsIgnoreCase(Dk[402]))
        {
            int i16 = a(' ', s1);
            if(i16 == 0)
                break MISSING_BLOCK_LABEL_11593;
            int j29 = a(',', s1);
            int k36 = a(':', s1);
            if(j29 != 0)
                if(k36 == 0);
            int l40 = Integer.parseInt(s1.substring(i16, j29 - 1));
            int i43 = Integer.parseInt(s1.substring(j29, k36 - 1));
            String s17 = s1.substring(k36, s1.length());
            int l44 = Integer.parseInt(s1.substring(4, i16 - 1));
            if(l44 == 1)
            {
                Xc = true;
                pd = l40;
                qd = i43;
                gd = s17;
            }
            if(l44 == 2)
            {
                Yc = true;
                rd = l40;
                sd = i43;
                hd = s17;
            }
            if(l44 == 3)
            {
                Zc = true;
                td = l40;
                ud = i43;
                id = s17;
            }
            if(l44 == 4)
            {
                ad = true;
                vd = l40;
                wd = i43;
                jd = s17;
            }
            if(l44 == 5)
            {
                bd = true;
                xd = l40;
                yd = i43;
                kd = s17;
            }
            if(l44 == 6)
            {
                cd = true;
                zd = l40;
                Ad = i43;
                ld = s17;
            }
            if(l44 == 7)
            {
                dd = true;
                Bd = l40;
                Cd = i43;
                md = s17;
            }
            if(l44 == 8)
            {
                ed = true;
                Dd = l40;
                Ed = i43;
                nd = s17;
            }
            if(l44 != 9)
                break MISSING_BLOCK_LABEL_11593;
            fd = true;
            Fd = l40;
            Gd = i43;
            od = s17;
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[375]))
        {
            int j16 = a(' ', s1);
            if(j16 == 0)
                break MISSING_BLOCK_LABEL_11593;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("1"))
                Xc = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("2"))
                Yc = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("3"))
                Zc = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("4"))
                ad = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("5"))
                bd = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("6"))
                cd = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("7"))
                dd = false;
            if(s1.substring(j16, s1.length()).equalsIgnoreCase("8"))
                ed = false;
            if(!s1.substring(j16, s1.length()).equalsIgnoreCase("9"))
                break MISSING_BLOCK_LABEL_11593;
            fd = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[423]))
        {
            try
            {
                Md = true;
                break MISSING_BLOCK_LABEL_11593;
            }
            catch(Exception exception73)
            {
                System.out.println(Dk[404]);
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        if(s1.substring(0, a(' ', s1) - 1).equalsIgnoreCase(Dk[416]))
        {
            if(s1.substring(6, 9).equalsIgnoreCase(Dk[395]))
            {
                d(Dk[428]);
                if(!flag)
                    break MISSING_BLOCK_LABEL_11593;
            }
            d(Dk[442]);
            Xc = false;
            Yc = false;
            Zc = false;
            ad = false;
            bd = false;
            cd = false;
            dd = false;
            ed = false;
            fd = false;
            Md = false;
            if(!flag)
                break MISSING_BLOCK_LABEL_11593;
        }
        System.out.println(Dk[452] + s1 + "]");
        break MISSING_BLOCK_LABEL_11593;
        Exception exception;
        exception;
        exception.printStackTrace();
    }

    public synchronized boolean keyUp(Event event, int i1)
    {
        if(i1 == 1001)
            ic = false;
        if(i1 == 1000)
            jc = false;
        if(i1 == 1)
            ec = false;
        if(i1 == 4)
            fc = false;
        if(i1 == 19)
            gc = false;
        if(i1 == 23)
            hc = false;
        if(i1 == Sb)
            dc = false;
        if(i1 == Rb)
            cc = false;
        if(i1 == Pb)
            bc = false;
        if(i1 == Qb)
            ac = false;
        return super.keyUp(event, i1);
    }

    public synchronized boolean keyDown(Event event, int i1)
    {
        if(i1 == 1019)
        {
            if(qc < 101)
                qc++;
            d(Dk[717] + qc);
        }
        if(i1 == 1018)
        {
            if(qc > 0)
                qc--;
            d(Dk[717] + qc);
        }
        if(i1 == 1010)
            if(!super.j)
            {
                d(Dk[714]);
                super.j = true;
                Xe.a = true;
            } else
            {
                super.j = false;
                Xe.a = false;
                d(Dk[716]);
            }
        if(i1 == 1022)
            if(super.g)
            {
                super.g = false;
                d(Dk[713]);
            } else
            {
                super.g = true;
                d(Dk[715]);
            }
        if(i1 == 1001)
            ic = true;
        if(i1 == 1000)
            jc = true;
        if(i1 == 1)
            ec = true;
        if(i1 == 4)
            fc = true;
        if(i1 == 19)
            gc = true;
        if(i1 == 23)
            hc = true;
        if(i1 == 27)
            j();
        if(i1 == Sb)
            dc = true;
        if(i1 == Rb)
            cc = true;
        if(i1 == Pb)
            bc = true;
        if(i1 == Qb)
            ac = true;
        return super.keyDown(event, i1);
    }

    public void a(int i1)
    {
        if(i1 == 1017)
            if(Cc)
            {
                Cc = false;
                Ic = -1;
                d(Dk[671]);
            } else
            if(Dc != -1)
            {
                Ic = Cg;
                Cc = true;
                d(Dk[672]);
                Bc = new eb(this);
            } else
            {
                d(Dk[670]);
            }
        if(Di == 0)
        {
            if(Zf == 0)
                Se.b(i1);
            if(Zf == 1)
                Me.b(i1);
            if(Zf == 2)
                Ne.b(i1);
        }
        if(Di == 1)
        {
            if(xe)
            {
                Re.b(i1);
                return;
            }
            if(vi == 0 && Vi == 0 && !me)
                Oe.b(i1);
        }
    }

    public void H()
    {
        int i1 = f.J;
        byte byte0 = 22;
        byte byte1 = 36;
        Xe.b(byte0, byte1, 468, 16, 192);
        int j1 = 0x989898;
        Xe.a(byte0, byte1 + 16, 468, 246, j1, 160);
        Xe.b(Dk[579] + m.a(af), byte0 + 234, byte1 + 12, 1, 0xffffff);
        Xe.b(Dk[580], byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int k1 = 0; k1 < Qf; k1++)
        {
            String s1 = f.d[dj[k1]];
            if(f.lb[dj[k1]] == 0)
                s1 = s1 + Dk[519] + cb(ej[k1]);
            Xe.b(s1, byte0 + 117, byte1 + 42 + k1 * 12, 1, 0xffffff);
        }

        if(Qf == 0)
            Xe.b(Dk[518], byte0 + 117, byte1 + 42, 1, 0xffffff);
        Xe.b(Dk[582], byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int l1 = 0; l1 < Tg; l1++)
        {
            String s2 = f.d[Lj[l1]];
            if(f.lb[Lj[l1]] == 0)
                s2 = s2 + Dk[519] + cb(Mj[l1]);
            Xe.b(s2, byte0 + 351, byte1 + 42 + l1 * 12, 1, 0xffffff);
        }

        if(Tg == 0)
            Xe.b(Dk[518], byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(Wi == 0)
            Xe.b(Dk[585], byte0 + 234, byte1 + 180, 1, 65280);
        else
            Xe.b(Dk[581], byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(Xi == 0)
            Xe.b(Dk[589], byte0 + 234, byte1 + 192, 1, 65280);
        else
            Xe.b(Dk[586], byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(Yi == 0)
            Xe.b(Dk[584], byte0 + 234, byte1 + 204, 1, 65280);
        else
            Xe.b(Dk[587], byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(Zi == 0)
            Xe.b(Dk[578], byte0 + 234, byte1 + 216, 1, 65280);
        else
            Xe.b(Dk[583], byte0 + 234, byte1 + 216, 1, 0xff0000);
        Xe.b(Dk[588], byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!fe)
        {
            Xe.c((byte0 + 118) - 35, byte1 + 238, Ei + 25);
            Xe.c((byte0 + 352) - 35, byte1 + 238, Ei + 26);
        } else
        {
            Xe.b(Dk[521], byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(hh == 1)
        {
            if(super.S < byte0 || super.T < byte1 || super.S > byte0 + 468 || super.T > byte1 + 262)
            {
                ee = false;
                super.nb.a(178);
                super.nb.i();
            }
            if(super.S >= (byte0 + 118) - 35 && super.S <= byte0 + 118 + 70 && super.T >= byte1 + 238 && super.T <= byte1 + 238 + 21)
            {
                fe = true;
                super.nb.a(24);
                super.nb.i();
            }
            if(super.S >= (byte0 + 352) - 35 && super.S <= byte0 + 353 + 70 && super.T >= byte1 + 238 && super.T <= byte1 + 238 + 21)
            {
                ee = false;
                super.nb.a(82);
                super.nb.i();
            }
            hh = 0;
        }
    }

    public void I()
    {
        int i1 = f.J;
        for(int j1 = 0; j1 < kh; j1++)
        {
            int i2 = Xe.c(1);
            int l2 = sk[j1];
            int k3 = tk[j1];
            int j4 = uk[j1];
            int l4 = vk[j1];
            for(boolean flag = true; flag;)
            {
                flag = false;
                int k5 = 0;
                while(k5 < j1) 
                {
                    if(k3 + l4 > tk[k5] - i2 && k3 - i2 < tk[k5] + vk[k5] && l2 - j4 < sk[k5] + uk[k5] && l2 + j4 > sk[k5] - uk[k5] && tk[k5] - i2 - l4 < k3)
                    {
                        k3 = tk[k5] - i2 - l4;
                        flag = true;
                    }
                    k5++;
                }
            }

            tk[j1] = k3;
            Xe.a(vf[j1], l2, k3, 1, 0xffff00, 300);
        }

        for(int k1 = 0; k1 < Li; k1++)
        {
            int j2 = Bj[k1];
            int i3 = Cj[k1];
            int l3 = pj[k1];
            int k4 = qj[k1];
            int i5 = (39 * l3) / 100;
            int j5 = (27 * l3) / 100;
            int l5 = i3 - j5;
            Xe.d(j2 - i5 / 2, l5, i5, j5, Ei + 9, 85);
            int i6 = (36 * l3) / 100;
            int j6 = (24 * l3) / 100;
            Xe.a(j2 - i6 / 2, (l5 + j5 / 2) - j6 / 2, i6, j6, f.jb[k4] + Gi, f.ob[k4], 0, 0, false);
        }

        for(int l1 = 0; l1 < Jg; l1++)
        {
            int k2 = gj[l1];
            int j3 = hj[l1];
            int i4 = ij[l1];
            Xe.a(k2 - 15, j3 - 3, i4, 5, 65280, 192);
            Xe.a((k2 - 15) + i4, j3 - 3, 30 - i4, 5, 0xff0000, 192);
        }

    }

    public void J()
    {
        try
        {
            Ce = a(Dk[282] + p.i + Dk[283], Dk[280], 90);
            Df = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println(Dk[281] + throwable);
        }
    }

    public void a(boolean flag)
    {
        if(Si + Rg <= 427)
            kc = true;
        if(Si + Rg > 427)
            kc = false;
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 199;
        char c1 = '\234';
        char c2 = '\230';
        Xe.c(j1 - 49, 3, Ei + 2);
        j1 += 40;
        Xe.b(j1, 36, c1, c2, 0);
        Xe.a(j1, 36, j1 + c1, 36 + c2);
        int k1 = 192 + xc;
        int l1 = tg + Ch & 0xff;
        int i2 = ((Le.g - 6040) * 3 * k1) / 2048;
        int j2 = ((Le.h - 6040) * 3 * k1) / 2048;
        int k2 = g.fb[1024 - l1 * 4 & 0x3ff];
        int l2 = g.fb[(1024 - l1 * 4 & 0x3ff) + 1024];
        int i3 = j2 * k2 + i2 * l2 >> 18;
        j2 = j2 * l2 - i2 * k2 >> 18;
        i2 = i3;
        Xe.g((j1 + c1 / 2) - i2, 36 + c2 / 2 + j2, Ei - 1, l1 + 64 & 0xff, k1);
        for(int j3 = 0; j3 < Yg; j3++)
        {
            int k4 = (((Dj[j3] * Ci + 64) - Le.g) * 3 * k1) / 2048;
            int i5 = (((Ej[j3] * Ci + 64) - Le.h) * 3 * k1) / 2048;
            int i6 = i5 * k2 + k4 * l2 >> 18;
            i5 = i5 * l2 - k4 * k2 >> 18;
            k4 = i6;
            if(kc)
                e(j1 + c1 / 2 + k4, (36 + c2 / 2) - i5, 0x8b7355);
            else
                e(j1 + c1 / 2 + k4, (36 + c2 / 2) - i5, 65535);
        }

        for(int k3 = 0; k3 < lh; k3++)
        {
            int l4 = (((Hj[k3] * Ci + 64) - Le.g) * 3 * k1) / 2048;
            int j5 = (((Ij[k3] * Ci + 64) - Le.h) * 3 * k1) / 2048;
            int j6 = j5 * k2 + l4 * l2 >> 18;
            j5 = j5 * l2 - l4 * k2 >> 18;
            l4 = j6;
            if(kc)
                e(j1 + c1 / 2 + l4, (36 + c2 / 2) - j5, 255);
            else
                e(j1 + c1 / 2 + l4, (36 + c2 / 2) - j5, 0xff0000);
        }

        for(int l3 = 0; l3 < hi; l3++)
        {
            r r1 = Fe[l3];
            int k5 = ((r1.g - Le.g) * 3 * k1) / 2048;
            int k6 = ((r1.h - Le.h) * 3 * k1) / 2048;
            int j7 = k6 * k2 + k5 * l2 >> 18;
            k6 = k6 * l2 - k5 * k2 >> 18;
            k5 = j7;
            if(kc)
                e(j1 + c1 / 2 + k5, (36 + c2 / 2) - k6, 0xd15fee);
            else
                e(j1 + c1 / 2 + k5, (36 + c2 / 2) - k6, 0xffff00);
        }

        for(int i4 = 0; i4 < xg; i4++)
        {
            r r2 = Ke[i4];
            int l5 = ((r2.g - Le.g) * 3 * k1) / 2048;
            int l6 = ((r2.h - Le.h) * 3 * k1) / 2048;
            int k7 = l6 * k2 + l5 * l2 >> 18;
            l6 = l6 * l2 - l5 * k2 >> 18;
            l5 = k7;
            int i8 = 0xffffff;
            if(kc)
            {
                int k8 = Le.v - r2.v;
                if(k8 == 0)
                    i8 = 0xffff00;
                if(k8 > 0)
                    i8 = 0xc0ff00;
                if(k8 > 3)
                    i8 = 0x80ff00;
                if(k8 > 6)
                    i8 = 0x40ff00;
                if(k8 > 10)
                    i8 = 65280;
                if(k8 < 0)
                    i8 = 0xffb000;
                if(k8 < -3)
                    i8 = 0xff7000;
                if(k8 < -6)
                    i8 = 0xff3000;
                if(k8 < -9)
                    i8 = 0xff0000;
                if(k8 > 1 + (2203 - (Si + ch + Rg)) / 6)
                    i8 = 0x555555;
                if(r2.v - Le.v > 1 + (2203 - (Si + ch + Rg)) / 6)
                    i8 = 0x555555;
            }
            int l8 = 0;
            do
            {
                if(l8 >= super.Ab)
                    break;
                if(r2.b == super.rb[l8] && super.Kb[l8] == 99)
                {
                    if(kc)
                        i8 = 0xffffff;
                    else
                        i8 = 65280;
                    break;
                }
                l8++;
            } while(true);
            if(kc)
            {
                if(Le.v - r2.v <= 1 + (2203 - (Si + ch + Rg)) / 6 && r2.v - Le.v <= 1 + (2203 - (Si + ch + Rg)) / 6)
                    e(j1 + c1 / 2 + l5, (36 + c2 / 2) - l6, i8);
            } else
            {
                e(j1 + c1 / 2 + l5, (36 + c2 / 2) - l6, i8);
            }
        }

        Xe.a(j1 + c1 / 2, 36 + c2 / 2, 2, 0xffffff, 255);
        Xe.g(j1 + 19, 55, Ei + 24, tg + 128 & 0xff, 128);
        Xe.a(0, 0, Uf, Vf + 12);
        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 199);
        int j4 = super.T - 36;
        if(j1 >= 40 && j4 >= 0 && j1 < 196 && j4 < 152)
        {
            char c3 = '\234';
            char c4 = '\230';
            int i7 = 192 + xc;
            int l7 = tg + Ch & 0xff;
            int j8 = ((v) (Xe)).m - 199;
            j8 += 40;
            int i9 = ((super.S - (j8 + c3 / 2)) * 16384) / (3 * i7);
            int j9 = ((super.T - (36 + c4 / 2)) * 16384) / (3 * i7);
            int k9 = g.fb[1024 - l7 * 4 & 0x3ff];
            int l9 = g.fb[(1024 - l7 * 4 & 0x3ff) + 1024];
            int i10 = j9 * k9 + i9 * l9 >> 15;
            j9 = j9 * l9 - i9 * k9 >> 15;
            i9 = i10;
            i9 += Le.g;
            j9 = Le.h - j9;
            if(hh == 1)
                b(Ri, Si, i9 / 128, j9 / 128, false);
            hh = 0;
        }
    }

    public boolean m(int i1, int j1)
    {
        if(i1 == 31 && (eb(197) || eb(615) || eb(682)))
            return true;
        if(i1 == 32 && (eb(102) || eb(616) || eb(683)))
            return true;
        if(i1 == 33 && (eb(101) || eb(617) || eb(684)))
            return true;
        if(i1 == 34 && (eb(103) || eb(618) || eb(685)))
            return true;
        else
            return db(i1) >= j1;
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        if(k1 == 0 || k1 == 4)
        {
            i2 = f.sb[l1];
            j2 = f.tb[l1];
        } else
        {
            j2 = f.sb[l1];
            i2 = f.tb[l1];
        }
        if(f.ub[l1] == 2 || f.ub[l1] == 3)
        {
            if(k1 == 0)
            {
                i1--;
                i2++;
            }
            if(k1 == 2)
                j2++;
            if(k1 == 4)
                i2++;
            if(k1 == 6)
            {
                j1--;
                j2++;
            }
            a(Ri, Si, i1, j1, (i1 + i2) - 1, (j1 + j2) - 1, false, true);
            return;
        } else
        {
            a(Ri, Si, i1, j1, (i1 + i2) - 1, (j1 + j2) - 1, true, true);
            return;
        }
    }

    public u a(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = i1;
        int k2 = j1;
        int l2 = i1;
        int i3 = j1;
        int j3 = f.xb[l1];
        int k3 = f.yb[l1];
        int l3 = f.wb[l1];
        u u1 = new u(4, 1);
        if(k1 == 0)
            l2 = i1 + 1;
        if(k1 == 1)
            i3 = j1 + 1;
        if(k1 == 2)
        {
            j2 = i1 + 1;
            i3 = j1 + 1;
        }
        if(k1 == 3)
        {
            l2 = i1 + 1;
            i3 = j1 + 1;
        }
        j2 *= Ci;
        k2 *= Ci;
        l2 *= Ci;
        i3 *= Ci;
        int i4 = u1.a(j2, -Ee.g(j2, k2), k2);
        int j4 = u1.a(j2, -Ee.g(j2, k2) - l3, k2);
        int k4 = u1.a(l2, -Ee.g(l2, i3) - l3, i3);
        int l4 = u1.a(l2, -Ee.g(l2, i3), i3);
        int ai1[] = {
            i4, j4, k4, l4
        };
        u1.a(4, ai1, j3, k3);
        u1.a(false, 60, 24, -50, -10, -50);
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96)
            De.a(u1);
        u1.w = i2 + 10000;
        return u1;
    }

    public r b(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = f.J;
        if(Je[i1] == null)
        {
            Je[i1] = new r();
            Je[i1].e = i1;
        }
        r r1 = Je[i1];
        boolean flag = false;
        int k2 = 0;
        do
        {
            if(k2 >= ii)
                break;
            if(Ge[k2].e == i1)
            {
                flag = true;
                break;
            }
            k2++;
        } while(true);
        if(flag)
        {
            r1.i = i2;
            r1.l = l1;
            int l2 = r1.n;
            if(j1 != r1.G[l2] || k1 != r1.H[l2])
            {
                r1.n = l2 = (l2 + 1) % 10;
                r1.G[l2] = j1;
                r1.H[l2] = k1;
            }
        } else
        {
            r1.e = i1;
            r1.m = 0;
            r1.n = 0;
            r1.G[0] = r1.g = j1;
            r1.H[0] = r1.h = k1;
            r1.i = i2;
            r1.l = r1.k = l1;
            r1.j = 0;
        }
        Fe[hi++] = r1;
        return r1;
    }

    public void K()
    {
        int i1 = f.J;
        if(aj != 0)
        {
            Xe.d();
            Xe.b(Dk[644], Uf / 2, Vf / 2, 7, 0xff0000);
            fb();
            Xe.a(Ye, 0, 0);
            return;
        }
        if((Xh * 100) / 750 == 0 && Oc != null)
        {
            super.nb.a(60);
            super.nb.a(Oc);
            if(!oe)
            {
                super.nb.f(0);
                oe = true;
            }
            super.nb.i();
            System.out.println(Dk[633] + Oc);
            Oc = null;
        }
        if(xe)
        {
            ab();
            return;
        }
        if(me)
        {
            if(qf)
            {
                j(pf);
                qf = false;
            }
            Xe.d();
            s();
            if(G() == 0 && Oc != null)
            {
                super.nb.a(60);
                super.nb.a(Oc);
                if(!oe)
                {
                    super.nb.f(0);
                    oe = true;
                }
                super.nb.i();
                System.out.println(Dk[634] + Oc);
                Oc = null;
            }
            if(Math.random() < 0.14999999999999999D)
                Xe.b(Dk[654], (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                Xe.b(Dk[654], 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            Xe.b(Uf / 2 - 100, 160, 200, 40, 0);
            Xe.b(Dk[666], Uf / 2, 25, 7, 0xffff00);
            Xe.b(Dk[653] + (Xh * 100) / 750 + "%", Uf / 2, 66, 7, 0xffff00);
            Xe.b(Dk[658], Uf / 2, 115, 5, 0xffffff);
            Xe.b(Dk[642], Uf / 2, 135, 5, 0xffffff);
            Xe.b(super.E + "*", Uf / 2, 155, 5, 65535);
            if(kf == null)
                Xe.c(Uf / 2 - 127, 205, Ii + 1);
            else
                Xe.b(kf, Uf / 2, 235, 5, 0xff0000);
            Xe.c(Uf / 2 - 128, 205, 257, 42, 0xffffff);
            fb();
            Xe.b(Dk[656], Uf / 2, 290, 1, 0xffffff);
            Xe.b(Dk[661], Uf / 2, 305, 1, 0xffffff);
            Xe.a(Ye, 0, 0);
            return;
        }
        if(Wc)
        {
            if(qf)
            {
                j(pf);
                qf = false;
            }
            int j1 = Uf / 2 - 40;
            byte byte0 = 36;
            char c1 = '\304';
            byte byte1 = 36;
            char c2 = '\304';
            int i11 = Uf / 2 - 40;
            char c3 = '\u0122';
            int k12 = 0xffffff;
            int i13 = byte0 + 260;
            int k13 = j1 + 3;
            Xe.d();
            Xe.b(Uf / 2 - 100, 160, 200, 40, 0);
            Xe.b(Dk[636], Uf / 2, 50, 7, 0xffff00);
            if(super.S > i11 && super.S < i11 + c2 && super.T > c3 - 12 && super.T < c3 + 4)
                k12 = 0xff0000;
            Xe.b(Dk[657], Uf / 2, 290, 5, k12);
            Xe.a(Ye, 0, 0);
            if(super.S > k13 && super.S < k13 + c1 && super.T > i13 - 12 && super.T < i13 + 4 && hh == 1)
            {
                Wc = !Wc;
                if(Wc)
                    d(Dk[170]);
                else
                    d(Dk[187]);
                hh = 0;
            } else
            if(hh > 0)
                hh = 0;
            return;
        }
        if(!Ee.c)
            return;
        for(int k1 = 0; k1 < 64; k1++)
        {
            De.b(Ee.q[eh][k1]);
            if(eh == 0)
            {
                De.b(Ee.r[1][k1]);
                De.b(Ee.q[1][k1]);
                De.b(Ee.r[2][k1]);
                De.b(Ee.q[2][k1]);
            }
            de = true;
            if(eh != 0 || (Ee.F[Le.g / 128][Le.h / 128] & 0x80) != 0)
                continue;
            De.a(Ee.q[eh][k1]);
            if(eh == 0)
            {
                De.a(Ee.r[1][k1]);
                De.a(Ee.q[1][k1]);
                De.a(Ee.r[2][k1]);
                De.a(Ee.q[2][k1]);
            }
            de = false;
        }

        if(sh != ni)
        {
            ni = sh;
            for(int l1 = 0; l1 < Yg; l1++)
            {
                if(Fj[l1] == 97)
                    c(l1, Dk[643] + (sh + 1));
                if(Fj[l1] == 274)
                    c(l1, Dk[663] + (sh + 1));
                if(Fj[l1] == 1031)
                    c(l1, Dk[645] + (sh + 1));
                if(Fj[l1] == 1036)
                    c(l1, Dk[637] + (sh + 1));
                if(Fj[l1] == 1147)
                    c(l1, Dk[669] + (sh + 1));
            }

        }
        if(th != oi)
        {
            oi = th;
            for(int i2 = 0; i2 < Yg; i2++)
            {
                if(Fj[i2] == 51)
                    c(i2, Dk[659] + (th + 1));
                if(Fj[i2] == 143)
                    c(i2, Dk[648] + (th + 1));
            }

        }
        if(uh != pi)
        {
            pi = uh;
            for(int j2 = 0; j2 < Yg; j2++)
                if(Fj[j2] == 1142)
                    c(j2, Dk[668] + (uh + 1));

        }
        De.a(zg);
        zg = 0;
        for(int k2 = 0; k2 < xg; k2++)
        {
            r r1 = Ke[k2];
            if(r1.y == 255)
                continue;
            int j7 = r1.g;
            int k8 = r1.h;
            int l9 = -Ee.g(j7, k8);
            int j11 = De.a(5000 + k2, j7, l9, k8, 145, 220, k2 + 10000);
            zg++;
            if(r1 == Le)
                De.b(j11);
            if(r1.k == 8)
                De.a(j11, -30);
            if(r1.k == 9)
                De.a(j11, 30);
        }

        for(int l2 = 0; l2 < xg; l2++)
        {
            r r2 = Ke[l2];
            if(r2.D <= 0)
                continue;
            r r4 = null;
            if(r2.C != -1)
                r4 = Je[r2.C];
            else
            if(r2.B != -1)
                r4 = He[r2.B];
            if(r4 != null)
            {
                int l8 = r2.g;
                int i10 = r2.h;
                int k11 = -Ee.g(l8, i10) - 110;
                int j12 = r4.g;
                int l12 = r4.h;
                int j13 = -Ee.g(j12, l12) - f.R[r4.i] / 2;
                int l13 = (l8 * r2.D + j12 * (ai - r2.D)) / ai;
                int i14 = (k11 * r2.D + j13 * (ai - r2.D)) / ai;
                int j14 = (i10 * r2.D + l12 * (ai - r2.D)) / ai;
                De.a(Hi + r2.A, l13, i14, j14, 32, 32, 0);
                zg++;
            }
        }

        for(int i3 = 0; i3 < hi; i3++)
        {
            r r3 = Fe[i3];
            int k7 = r3.g;
            int i9 = r3.h;
            int j10 = -Ee.g(k7, i9);
            int l11 = De.a(20000 + i3, k7, j10, i9, f.Q[r3.i], f.R[r3.i], i3 + 30000);
            zg++;
            if(r3.k == 8)
                De.a(l11, -30);
            if(r3.k == 9)
                De.a(l11, 30);
        }

        for(int j3 = 0; j3 < lh; j3++)
        {
            int k5 = Hj[j3] * Ci + 64;
            int l7 = Ij[j3] * Ci + 64;
            De.a(40000 + Jj[j3], k5, -Ee.g(k5, l7) - Kj[j3], l7, 96, 64, j3 + 20000);
            zg++;
        }

        for(int k3 = 0; k3 < oh; k3++)
        {
            int l5 = Zj[k3] * Ci + 64;
            int i8 = hk[k3] * Ci + 64;
            int j9 = tj[k3];
            if(j9 == 0)
            {
                De.a(50000 + k3, l5, -Ee.g(l5, i8), i8, 128, 256, k3 + 50000);
                zg++;
            }
            if(j9 == 1)
            {
                De.a(50000 + k3, l5, -Ee.g(l5, i8), i8, 128, 64, k3 + 50000);
                zg++;
            }
        }

        Xe.b = false;
        Xe.c();
        Xe.b = super.t;
        if(eh == 3)
        {
            int l3 = 40 + (int)(Math.random() * 3D);
            int i6 = 40 + (int)(Math.random() * 7D);
            De.a(l3, i6, -50, -10, -50);
        }
        Li = 0;
        kh = 0;
        Jg = 0;
        if(be)
        {
            if(Sd && !de)
            {
                int i4 = yi;
                mb();
                if(yi != i4)
                {
                    qg = Le.g;
                    rg = Le.h;
                }
            }
            De.s = 3000;
            De.t = 3000;
            De.u = 1;
            De.v = 2800;
            tg = yi * 32;
            int j4 = qg + Yh;
            int j6 = rg + Pi;
            De.b(j4, -Ee.g(j4, j6), j6, Cf, tg * 4, 0, 2000);
        } else
        {
            if(Sd && !de)
                mb();
            if(Ld)
            {
                if(!super.t)
                {
                    De.s = 2400;
                    De.t = 2400;
                    De.u = 1;
                    De.v = 2300;
                } else
                {
                    De.s = 2200;
                    De.t = 2200;
                    De.u = 1;
                    De.v = 2100;
                }
            } else
            if(!super.t)
            {
                De.s = 50000;
                De.t = 50000;
                De.u = 1;
                De.v = 50000;
            } else
            {
                De.s = 50000;
                De.t = 50000;
                De.u = 1;
                De.v = 50000;
            }
            int k4 = qg + vc;
            int k6 = rg + wc;
            De.b(k4, -Ee.g(k4, k6), k6, Cf, tg * 4, 0, Xf * 2);
        }
        De.f();
        I();
        if(Rf > 0)
            Xe.c(Sf - 8, Tf - 8, Ei + 14 + (24 - Rf) / 6);
        if(Rf < 0)
            Xe.c(Sf - 8, Tf - 8, Ei + 18 + (24 + Rf) / 6);
        if(Bg != 0)
        {
            int l4 = Bg / 50;
            int l6 = l4 / 60;
            l4 %= 60;
            if(l4 < 10)
                Xe.b(Dk[647] + l6 + Dk[640] + l4, 256, Vf - 7, 1, 0xffff00);
            else
                Xe.b(Dk[647] + l6 + ":" + l4, 256, Vf - 7, 1, 0xffff00);
        }
        if(nc)
            Xe.b("(" + super.S + ":" + super.T + ")", 256, Vf - 7, 1, 65280);
        if(Cc)
        {
            int i5 = (oj[2] - Gc) / 3;
            if(Ic == 0)
                i5 = ((oj[0] + oj[1] + oj[2]) - Gc) / 3;
            if(Ic == 1)
                i5 = (oj[2] - Gc) / 3;
            if(Ic == 2)
                i5 = (oj[0] - Gc) / 3;
            if(Ic == 3)
                i5 = (oj[1] - Gc) / 3;
            if(Ic == 0)
                Xe.b(Dk[664] + f.k[Dc] + Dk[662] + Ic + Dk[665] + Dk[639] + i5 + Dk[646], 256, Vf - 7, 1, 65280);
            if(Ic == 1)
                Xe.b(Dk[664] + f.k[Dc] + Dk[662] + Ic + Dk[665] + Dk[639] + i5 + Dk[641], 256, Vf - 7, 1, 65280);
            if(Ic == 2)
                Xe.b(Dk[664] + f.k[Dc] + Dk[662] + Ic + Dk[665] + Dk[639] + i5 + Dk[660], 256, Vf - 7, 1, 65280);
            if(Ic == 3)
                Xe.b(Dk[664] + f.k[Dc] + Dk[662] + Ic + Dk[665] + Dk[639] + i5 + Dk[667], 256, Vf - 7, 1, 65280);
        }
        s();
        if(Cg != Ic && Ic != -1)
        {
            ab(Ic);
            d(Dk[650]);
        }
        if((super.j || ((v) (Xe)).a) && hh > 0)
            hh = 0;
        if(G() >= qc && db(1263) > 0 && !uc)
        {
            V(1263);
            d(Dk[649]);
        }
        z();
        int j5 = jk[0] + Qg;
        int i7 = kk[0] + Rg;
        if(j5 != Jd)
        {
            Jd = j5;
            if(i7 != Kd)
            {
                Kd = i7;
                ab.b(Dk[651] + j5 + " " + i7);
            }
        }
        int j8 = C();
        int k9 = D();
        if(j8 != Jd)
        {
            Jd = j8;
            if(k9 != Kd)
            {
                Kd = k9;
                ab.b(Dk[652] + j8 + " " + k9);
            }
        }
        if(qf)
        {
            j(pf);
            qf = false;
        }
        if(Xc)
            Xe.b(gd, pd, qd, 1, 0xffff00);
        if(Yc)
            Xe.b(hd, rd, sd, 1, 0xffff00);
        if(Zc)
            Xe.b(id, td, ud, 1, 0xffff00);
        if(ad)
            Xe.b(jd, vd, wd, 1, 0xffff00);
        if(bd)
            Xe.b(kd, xd, yd, 1, 0xffff00);
        if(cd)
            Xe.b(ld, zd, Ad, 1, 0xffff00);
        if(dd)
            Xe.b(md, Bd, Cd, 1, 0xffff00);
        if(ed)
            Xe.b(nd, Dd, Ed, 1, 0xffff00);
        if(fd)
            Xe.b(od, Fd, Gd, 1, 0xffff00);
        if(!Ud)
        {
            int k10 = 2203 - (Si + ch + Rg);
            if(Ri + bh + Qg >= 2640)
                k10 = -50;
            if(k10 > 0)
            {
                int i12 = 1 + k10 / 6;
                Xe.c(453, Vf - 56, Ei + 13);
                Xe.b(Dk[635], 465, Vf - 20, 1, 0xffff00);
                Xe.b(Dk[638] + i12 + Dk[655], 465, Vf - 7, 1, 0xffff00);
                if(sg == 0)
                    sg = 2;
            }
            if(sg == 0 && k10 > -10 && k10 <= 0)
                sg = 1;
        }
        if(Og == 0)
        {
            for(int l10 = 0; l10 < 5; l10++)
                if(ik[l10] > 0)
                {
                    String s1 = tf[l10];
                    Xe.c(s1, 7, Vf - 18 - l10 * 12, 1, 0xffff00);
                }

        }
        Oe.g(Kg);
        Oe.g(Mg);
        Oe.g(Ng);
        if(Og == 1)
            Oe.f(Kg);
        else
        if(Og == 2)
            Oe.f(Mg);
        else
        if(Og == 3)
            Oe.f(Ng);
        t.I = 2;
        Oe.a();
        t.I = 0;
        Xe.d(((v) (Xe)).m - 3 - 197, 3, Ei, 128);
        db();
        Xe.c = false;
        fb();
        Xe.a(Ye, 0, 0);
    }

    void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = tj[i2];
        int i3 = yk[i2];
        if(l2 == 0)
        {
            int j3 = 255 + i3 * 5 * 256;
            Xe.a(i1 + k1 / 2, j1 + l1 / 2, 20 + i3 * 2, j3, 255 - i3 * 5);
        }
        if(l2 == 1)
        {
            int k3 = 0xff0000 + i3 * 5 * 256;
            Xe.a(i1 + k1 / 2, j1 + l1 / 2, 10 + i3, k3, 255 - i3 * 5);
        }
    }

    public void a(int i1, int j1, int k1)
    {
        int l1 = f.J;
        zk[Ui] = j1;
        Ak[Ui] = k1;
        Ui = Ui + 1 & 0x1fff;
label0:
        for(int i2 = 10; i2 < 4000; i2++)
        {
            int j2 = Ui - i2 & 0x1fff;
            if(zk[j2] != j1 || Ak[j2] != k1)
                continue;
            boolean flag = false;
            int k2 = 1;
            do
            {
                if(k2 >= i2)
                    continue label0;
                int l2 = Ui - k2 & 0x1fff;
                int i3 = j2 - k2 & 0x1fff;
                if(zk[i3] != j1 || Ak[i3] != k1)
                    flag = true;
                if(zk[l2] != zk[i3] || Ak[l2] != Ak[i3])
                    continue label0;
                if(k2 == i2 - 1 && flag && Kh == 0 && Ag == 0)
                {
                    hb();
                    return;
                }
                k2++;
            } while(true);
        }

    }

    public void L()
    {
        int i1 = f.J;
        if(hh != 0)
        {
            int j1 = 0;
            do
            {
                if(j1 >= Hg)
                    break;
                int l1 = Dg + 2;
                int j2 = Eg + 27 + j1 * 15;
                if(super.S > l1 - 2 && super.T > j2 - 12 && super.T < j2 + 4 && super.S < (l1 - 3) + Fg)
                {
                    fb(Bk[j1]);
                    break;
                }
                j1++;
            } while(true);
            hh = 0;
            ke = false;
            return;
        }
        if(super.S < Dg - 10 || super.T < Eg - 10 || super.S > Dg + Fg + 10 || super.T > Eg + Gg + 10)
        {
            ke = false;
            return;
        }
        Xe.a(Dg, Eg, Fg, Gg, 0xd0d0d0, 160);
        Xe.c(Dk[6], Dg + 2, Eg + 12, 1, 65535);
        for(int k1 = 0; k1 < Hg; k1++)
        {
            int i2 = Dg + 2;
            int k2 = Eg + 27 + k1 * 15;
            int l2 = 0xffffff;
            if(super.S > i2 - 2 && super.T > k2 - 12 && super.T < k2 + 4 && super.S < (i2 - 3) + Fg)
                l2 = 0xffff00;
            Xe.c(zf[Bk[k1]] + " " + sf[Bk[k1]], i2, k2, 1, l2);
        }

    }

    public void d(int i1, int j1, int k1)
    {
        if(k1 == 0)
        {
            a(Ri, Si, i1, j1 - 1, i1, j1, false, true);
            return;
        }
        if(k1 == 1)
        {
            a(Ri, Si, i1 - 1, j1, i1, j1, false, true);
            return;
        } else
        {
            a(Ri, Si, i1, j1, i1, j1, true, true);
            return;
        }
    }

    public boolean bb(int i1)
    {
        int j1 = Le.g / 128;
        int k1 = Le.h / 128;
        for(int l1 = 2; l1 >= 1; l1--)
        {
            if(i1 == 1 && ((Ee.F[j1][k1 - l1] & 0x80) == 128 || (Ee.F[j1 - l1][k1] & 0x80) == 128 || (Ee.F[j1 - l1][k1 - l1] & 0x80) == 128))
                return false;
            if(i1 == 3 && ((Ee.F[j1][k1 + l1] & 0x80) == 128 || (Ee.F[j1 - l1][k1] & 0x80) == 128 || (Ee.F[j1 - l1][k1 + l1] & 0x80) == 128))
                return false;
            if(i1 == 5 && ((Ee.F[j1][k1 + l1] & 0x80) == 128 || (Ee.F[j1 + l1][k1] & 0x80) == 128 || (Ee.F[j1 + l1][k1 + l1] & 0x80) == 128))
                return false;
            if(i1 == 7 && ((Ee.F[j1][k1 - l1] & 0x80) == 128 || (Ee.F[j1 + l1][k1] & 0x80) == 128 || (Ee.F[j1 + l1][k1 - l1] & 0x80) == 128))
                return false;
            if(i1 == 0 && (Ee.F[j1][k1 - l1] & 0x80) == 128)
                return false;
            if(i1 == 2 && (Ee.F[j1 - l1][k1] & 0x80) == 128)
                return false;
            if(i1 == 4 && (Ee.F[j1][k1 + l1] & 0x80) == 128)
                return false;
            if(i1 == 6 && (Ee.F[j1 + l1][k1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public void M()
    {
        int i1 = f.J;
        byte abyte0[] = a(Dk[537] + p.g + Dk[497], Dk[536], 50);
        if(abyte0 == null)
        {
            te = true;
            return;
        }
        byte abyte1[] = m.a(Dk[507], 0, abyte0);
        De.b(f.K, 7, 11);
        for(int j1 = 0; j1 < f.K; j1++)
        {
            String s1 = f.p[j1];
            byte abyte2[] = m.a(s1 + Dk[510], 0, abyte0);
            Xe.a(Ii, abyte2, abyte1, 1);
            Xe.b(0, 0, 128, 128, 0xff00ff);
            Xe.c(0, 0, Ii);
            int k1 = ((v) (Xe)).F[Ii];
            String s2 = f.q[j1];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = m.a(s2 + Dk[510], 0, abyte0);
                Xe.a(Ii, abyte3, abyte1, 1);
                Xe.c(0, 0, Ii);
            }
            Xe.e(Ji + j1, 0, 0, k1, k1);
            int l1 = k1 * k1;
            for(int i2 = 0; i2 < l1; i2++)
                if(((v) (Xe)).P[Ji + j1][i2] == 65280)
                    ((v) (Xe)).P[Ji + j1][i2] = 0xff00ff;

            Xe.a(Ji + j1);
            De.a(j1, ((v) (Xe)).g[Ji + j1], ((v) (Xe)).Q[Ji + j1], k1 / 64 - 1);
        }

    }

    public void N()
    {
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 && super.T < 35)
            ki = 1;
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 - 33 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 33 && super.T < 35)
        {
            ki = 2;
            Ch = (int)(Math.random() * 0.0D) - 0;
            Dh = (int)(Math.random() * 0.0D) - 0;
        }
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 - 66 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 66 && super.T < 35)
            ki = 3;
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 - 99 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 99 && super.T < 35)
            ki = 4;
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 - 132 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 132 && super.T < 35)
            ki = 5;
        if(ki == 0 && super.S >= ((v) (Xe)).m - 35 - 165 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 165 && super.T < 35)
            ki = 6;
        if(ki != 0 && super.S >= ((v) (Xe)).m - 35 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 && super.T < 26)
            ki = 1;
        if(ki != 0 && ki != 2 && super.S >= ((v) (Xe)).m - 35 - 33 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 33 && super.T < 26)
        {
            ki = 2;
            Ch = (int)(Math.random() * 0.0D) - 0;
            Dh = (int)(Math.random() * 0.0D) - 0;
        }
        if(ki != 0 && super.S >= ((v) (Xe)).m - 35 - 66 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 66 && super.T < 26)
            ki = 3;
        if(ki != 0 && super.S >= ((v) (Xe)).m - 35 - 99 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 99 && super.T < 26)
            ki = 4;
        if(ki != 0 && super.S >= ((v) (Xe)).m - 35 - 132 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 132 && super.T < 26)
            ki = 5;
        if(ki != 0 && super.S >= ((v) (Xe)).m - 35 - 165 && super.T >= 3 && super.S < ((v) (Xe)).m - 3 - 165 && super.T < 26)
            ki = 6;
        if(ki == 1 && (super.S < ((v) (Xe)).m - 248 || super.T > 36 + (og / 5) * 34))
            ki = 0;
        if(ki == 3 && (super.S < ((v) (Xe)).m - 199 || super.T > 316))
            ki = 0;
        if((ki == 2 || ki == 4 || ki == 5) && (super.S < ((v) (Xe)).m - 199 || super.T > 240))
            ki = 0;
        if(ki == 6 && (super.S < ((v) (Xe)).m - 199 || super.T > 311))
            ki = 0;
    }

    public void b(boolean flag)
    {
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 199;
        int k1 = 36;
        Xe.c(j1 - 49, 3, Ei + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int l1;
        int i2 = l1 = v.b(100, 100, 100);
        if(nh == 0)
            i2 = v.b(190, 190, 190);
        else
            l1 = v.b(190, 190, 190);
        Xe.a(j1, k1, c1 / 2, 24, i2, 128);
        Xe.a(j1 + c1 / 2, k1, c1 / 2, 24, l1, 128);
        Xe.a(j1, k1 + 24, c1, c2 - 24, v.b(100, 100, 100), 128);
        Xe.b(j1, k1 + 24, c1, 0);
        Xe.c(j1 + c1 / 2, k1, 24, 0);
        Xe.b(Dk[775], j1 + c1 / 4, k1 + 16, 4, 0);
        Xe.b(Dk[781], j1 + c1 / 4 + c1 / 2, k1 + 16, 4, 0);
        if(nh == 0)
        {
            int j2 = 72;
            int l2 = -1;
            Xe.c(Dk[771], j1 + 5, j2, 3, 0xffff00);
            j2 += 13;
            for(int i3 = 0; i3 < 9; i3++)
            {
                int i4 = 0xffffff;
                if(super.S > j1 + 3 && super.T >= j2 - 11 && super.T < j2 + 2 && super.S < j1 + 90)
                {
                    i4 = 0xff0000;
                    l2 = i3;
                }
                Xe.c(rf[i3] + Dk[780] + sj[i3] + Dk[787] + Uj[i3], j1 + 5, j2, 1, i4);
                i4 = 0xffffff;
                if(super.S >= j1 + 90 && super.T >= j2 - 13 - 11 && super.T < (j2 - 13) + 2 && super.S < j1 + 196)
                {
                    i4 = 0xff0000;
                    l2 = i3 + 9;
                }
                Xe.c(rf[i3 + 9] + Dk[780] + sj[i3 + 9] + Dk[787] + Uj[i3 + 9], (j1 + c1 / 2) - 5, j2 - 13, 1, i4);
                j2 += 13;
            }

            Xe.c(Dk[774] + cj + Dk[782], (j1 + c1 / 2) - 5, j2 - 13, 1, 0xffffff);
            j2 += 12;
            Xe.c(Dk[776] + (Wh * 100) / 750 + Dk[783], j1 + 5, j2 - 13, 1, 0xffffff);
            j2 += 8;
            Xe.c(Dk[772], j1 + 5, j2, 3, 0xffff00);
            j2 += 12;
            for(int j3 = 0; j3 < 3; j3++)
            {
                Xe.c(yf[j3] + Dk[777] + Nj[j3] + Dk[782], j1 + 5, j2, 1, 0xffffff);
                if(j3 < 2)
                    Xe.c(yf[j3 + 3] + Dk[777] + Nj[j3 + 3] + Dk[782], j1 + c1 / 2 + 25, j2, 1, 0xffffff);
                j2 += 13;
            }

            j2 += 6;
            Xe.b(j1, j2 - 15, c1, 0);
            if(l2 != -1)
            {
                Xe.c(Dk[221] + uf[l2] + Dk[784], j1 + 5, j2, 1, 0xffff00);
                j2 += 12;
                int k3 = fj[0];
                for(int j4 = 0; j4 < 98; j4++)
                    if(oj[l2] >= fj[j4])
                        k3 = fj[j4 + 1];

                Xe.c(Dk[786] + oj[l2] / 4 + Dk[782], j1 + 5, j2, 1, 0xffffff);
                j2 += 12;
                Xe.c(Dk[778] + k3 / 4 + Dk[782], j1 + 5, j2, 1, 0xffffff);
            } else
            {
                Xe.c(Dk[773], j1 + 5, j2, 1, 0xffff00);
                j2 += 12;
                int l3 = 0;
                for(int k4 = 0; k4 < 18; k4++)
                    l3 += Uj[k4];

                Xe.c(Dk[785] + l3 + Dk[782], j1 + 5, j2, 1, 0xffffff);
                j2 += 12;
                Xe.c(Dk[779] + Le.v + Dk[782], j1 + 5, j2, 1, 0xffffff);
                j2 += 12;
            }
        }
        if(nh == 1)
        {
            Qe.c(mh);
            Qe.a(mh, 0, Dk[770]);
            for(int k2 = 0; k2 < 50; k2++)
                Qe.a(mh, k2 + 1, (Ae[k2] ? Dk[211] : Dk[220]) + xf[k2]);

            Qe.a();
        }
        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 199);
        k1 = super.T - 36;
        if(j1 >= 0 && k1 >= 0 && j1 < c1 && k1 < c2)
        {
            if(nh == 1)
                Qe.a(j1 + (((v) (Xe)).m - 199), k1 + 36, super.V, super.U);
            if(k1 <= 24 && hh == 1)
            {
                if(j1 < 98)
                {
                    nh = 0;
                    return;
                }
                if(j1 > 98)
                    nh = 1;
            }
        }
    }

    public void O()
    {
        int i1 = f.J;
        Eh = 0;
        int j1 = 135;
        for(int k1 = 0; k1 < 12; k1++)
        {
            if(super.S > 66 && super.S < 446 && super.T >= j1 - 12 && super.T < j1 + 3)
                Eh = k1 + 1;
            j1 += 14;
        }

        if(hh != 0 && Eh != 0)
        {
            hh = 0;
            Vi = 2;
            super.E = "";
            super.F = "";
            return;
        }
        j1 += 15;
        if(hh != 0)
        {
            hh = 0;
            if(super.S < 56 || super.T < 35 || super.S > 456 || super.T > 325)
            {
                Vi = 0;
                return;
            }
            if(super.S > 66 && super.S < 446 && super.T >= j1 - 15 && super.T < j1 + 5)
            {
                Vi = 0;
                return;
            }
        }
        Xe.b(56, 35, 400, 290, 0);
        Xe.c(56, 35, 400, 290, 0xffffff);
        j1 = 50;
        Xe.b(Dk[246], 256, j1, 1, 0xffffff);
        j1 += 15;
        Xe.b(Dk[251], 256, j1, 1, 0xffffff);
        j1 += 15;
        Xe.b(Dk[249], 256, j1, 1, 0xff8000);
        j1 += 15;
        j1 += 10;
        Xe.b(Dk[242], 256, j1, 1, 0xffff00);
        j1 += 15;
        Xe.b(Dk[244], 256, j1, 1, 0xffff00);
        j1 += 15;
        int l1;
        if(Eh == 1)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[235], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 2)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[245], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 3)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[237], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 4)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[240], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 5)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[236], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 6)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[239], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 7)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[243], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 8)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[234], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 9)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[250], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 10)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[241], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 11)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[248], 256, j1, 1, l1);
        j1 += 14;
        if(Eh == 12)
        {
            Xe.c(66, j1 - 12, 380, 15, 0xffffff);
            l1 = 0xff8000;
        } else
        {
            l1 = 0xffffff;
        }
        Xe.b(Dk[238], 256, j1, 1, l1);
        j1 += 14;
        j1 += 15;
        l1 = 0xffffff;
        if(super.S > 196 && super.S < 316 && super.T > j1 - 15 && super.T < j1 + 5)
            l1 = 0xffff00;
        Xe.b(Dk[247], 256, j1, 1, l1);
    }

    public void P()
    {
        int i1 = f.J;
        if(hh != 0)
        {
            hh = 0;
            int j1 = super.S - 52;
            int k1 = super.T - 44;
            if(j1 >= 0 && k1 >= 12 && j1 < 408 && k1 < 246)
            {
                int l1 = 0;
                for(int j2 = 0; j2 < 5; j2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int i4 = 7 + i3 * 49;
                        int i5 = 28 + j2 * 34;
                        if(j1 > i4 && j1 < i4 + 49 && k1 > i5 && k1 < i5 + 34 && uj[l1] != -1)
                        {
                            fi = l1;
                            gi = uj[l1];
                        }
                        l1++;
                    }

                }

                if(fi >= 0)
                {
                    int k2 = uj[fi];
                    if(k2 != -1)
                    {
                        if(vj[fi] > 0 && j1 > 298 && k1 >= 204 && j1 < 408 && k1 <= 215)
                        {
                            int j3 = di + wj[fi];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * f.kb[k2]) / 100;
                            super.nb.a(157);
                            super.nb.e(uj[fi]);
                            super.nb.b(j4);
                            super.nb.i();
                            System.out.println(Dk[312] + uj[fi] + "," + j4 + ")");
                        }
                        if(db(k2) > 0 && j1 > 2 && k1 >= 229 && j1 < 112 && k1 <= 240)
                        {
                            int k3 = ci + wj[fi];
                            if(k3 < 10)
                                k3 = 10;
                            int k4 = (k3 * f.kb[k2]) / 100;
                            super.nb.a(211);
                            super.nb.e(uj[fi]);
                            super.nb.b(k4);
                            super.nb.i();
                            System.out.println(Dk[389] + uj[fi] + "," + k4 + ")");
                        }
                    }
                }
            } else
            {
                super.nb.a(56);
                super.nb.i();
                Zd = false;
                System.out.println(Dk[50]);
                ab.a(Dk[58]);
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        Xe.b(byte0, byte1, 408, 12, 192);
        int i2 = 0x989898;
        Xe.a(byte0, byte1 + 12, 408, 17, i2, 160);
        Xe.a(byte0, byte1 + 29, 8, 170, i2, 160);
        Xe.a(byte0 + 399, byte1 + 29, 9, 170, i2, 160);
        Xe.a(byte0, byte1 + 199, 408, 47, i2, 160);
        Xe.c(Dk[622], byte0 + 1, byte1 + 10, 1, 0xffffff);
        int l2 = 0xffffff;
        if(super.S > byte0 + 320 && super.T >= byte1 && super.S < byte0 + 408 && super.T < byte1 + 12)
            l2 = 0xff0000;
        Xe.a(Dk[628], byte0 + 406, byte1 + 10, 1, l2);
        Xe.c(Dk[630], byte0 + 2, byte1 + 24, 1, 65280);
        Xe.c(Dk[629], byte0 + 135, byte1 + 24, 1, 65535);
        Xe.c(Dk[626] + db(10) + Dk[617], byte0 + 280, byte1 + 24, 1, 0xffff00);
        int l3 = 0xd0d0d0;
        int l4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int l5 = 0; l5 < 8; l5++)
            {
                int k6 = byte0 + 7 + l5 * 49;
                int j7 = byte1 + 28 + j5 * 34;
                if(fi == l4)
                    Xe.a(k6, j7, 49, 34, 0xff0000, 160);
                else
                    Xe.a(k6, j7, 49, 34, l3, 160);
                Xe.c(k6, j7, 50, 35, 0);
                if(uj[l4] != -1)
                {
                    Xe.a(k6, j7, 48, 32, Gi + f.jb[uj[l4]], f.ob[uj[l4]], 0, 0, false);
                    Xe.c(String.valueOf(vj[l4]), k6 + 1, j7 + 10, 1, 65280);
                    Xe.a(String.valueOf(db(uj[l4])), k6 + 47, j7 + 10, 1, 65535);
                }
                l4++;
            }

        }

        Xe.b(byte0 + 5, byte1 + 222, 398, 0);
        if(fi == -1)
        {
            Xe.b(Dk[619], byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int k5 = uj[fi];
        if(k5 != -1)
        {
            if(vj[fi] > 0)
            {
                int i6 = di + wj[fi];
                if(i6 < 10)
                    i6 = 10;
                int l6 = (i6 * f.kb[k5]) / 100;
                Xe.c(Dk[625] + f.d[k5] + Dk[623] + l6 + Dk[617], byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k7 = 0xffffff;
                if(super.S > byte0 + 298 && super.T >= byte1 + 204 && super.S < byte0 + 408 && super.T <= byte1 + 215)
                    k7 = 0xff0000;
                Xe.a(Dk[627], byte0 + 405, byte1 + 214, 3, k7);
            } else
            {
                Xe.b(Dk[620], byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(db(k5) > 0)
            {
                int j6 = ci + wj[fi];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * f.kb[k5]) / 100;
                Xe.a(Dk[624] + f.d[k5] + Dk[623] + i7 + Dk[617], byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l7 = 0xffffff;
                if(super.S > byte0 + 2 && super.T >= byte1 + 229 && super.S < byte0 + 112 && super.T <= byte1 + 240)
                    l7 = 0xff0000;
                Xe.c(Dk[618], byte0 + 2, byte1 + 239, 3, l7);
                return;
            }
            Xe.b(Dk[621], byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    public void a(String s1, int i1)
    {
        z();
        oc = new GregorianCalendar();
        int j1 = f.J;
        if(i1 == 2 || i1 == 4 || i1 == 6)
        {
            for(; s1.length() > 5 && s1.charAt(0) == '@' && s1.charAt(4) == '@'; s1 = s1.substring(5));
            int k1 = s1.indexOf(":");
            if(k1 != -1)
            {
                String s2 = s1.substring(0, k1);
                long l2 = m.b(s2);
                for(int i2 = 0; i2 < super.Bb; i2++)
                    if(super.sb[i2] == l2)
                        return;

            }
        }
        if(i1 == 2)
            s1 = Wb + " " + Dk[221] + s1;
        if(i1 == 3 || i1 == 4)
            s1 = Wb + " " + Dk[222] + s1;
        if(i1 == 5)
            s1 = Wb + " " + " " + s1;
        if(i1 == 6)
            s1 = Wb + " " + Dk[257] + s1;
        if(Og != 0)
        {
            if(i1 == 4 || i1 == 3)
                Ug = 200;
            if(i1 == 2 && Og != 1)
                Vg = 200;
            if(i1 == 5 && Og != 2)
                Wg = 200;
            if(i1 == 6 && Og != 3)
                Xg = 200;
            if(i1 == 3 && Og != 0)
                Og = 0;
            if(i1 == 6 && Og != 3 && Og != 0)
                Og = 0;
        }
        for(int l1 = 4; l1 > 0; l1--)
        {
            tf[l1] = tf[l1 - 1];
            ik[l1] = ik[l1 - 1];
        }

        tf[0] = s1;
        ik[0] = 300;
        if(i1 == 2)
            if(Oe.J[Kg] == Oe.K[Kg] - 4)
                Oe.a(Kg, s1, true);
            else
                Oe.a(Kg, s1, false);
        if(i1 == 5)
            if(Oe.J[Mg] == Oe.K[Mg] - 4)
                Oe.a(Mg, s1, true);
            else
                Oe.a(Mg, s1, false);
        if(i1 == 6)
        {
            if(Oe.J[Ng] == Oe.K[Ng] - 4)
            {
                Oe.a(Ng, s1, true);
                return;
            }
            Oe.a(Ng, s1, false);
        }
    }

    void b(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = f.jb[i2] + Gi;
        int i3 = f.ob[i2];
        Xe.a(i1, j1, k1, l1, l2, i3, 0, 0, false);
    }

    public void Q()
    {
        int i1 = f.J;
        Re.a(super.S, super.T, super.V, super.U);
        if(Re.a(bg))
            do
                Lh = ((Lh - 1) + f.F) % f.F;
            while((f.Cb[Lh] & 3) != 1 || (f.Cb[Lh] & 4 * Sh) == 0);
        if(Re.a(cg))
            do
                Lh = (Lh + 1) % f.F;
            while((f.Cb[Lh] & 3) != 1 || (f.Cb[Lh] & 4 * Sh) == 0);
        if(Re.a(dg))
            Oh = ((Oh - 1) + bk.length) % bk.length;
        if(Re.a(eg))
            Oh = (Oh + 1) % bk.length;
        if(Re.a(fg) || Re.a(gg))
        {
            for(Sh = 3 - Sh; (f.Cb[Lh] & 3) != 1 || (f.Cb[Lh] & 4 * Sh) == 0; Lh = (Lh + 1) % f.F);
            for(; (f.Cb[Mh] & 3) != 2 || (f.Cb[Mh] & 4 * Sh) == 0; Mh = (Mh + 1) % f.F);
        }
        if(Re.a(hg))
            Ph = ((Ph - 1) + Wj.length) % Wj.length;
        if(Re.a(ig))
            Ph = (Ph + 1) % Wj.length;
        if(Re.a(jg))
            Rh = ((Rh - 1) + Vj.length) % Vj.length;
        if(Re.a(kg))
            Rh = (Rh + 1) % Vj.length;
        if(Re.a(lg))
            Qh = ((Qh - 1) + Wj.length) % Wj.length;
        if(Re.a(mg))
            Qh = (Qh + 1) % Wj.length;
        if(Re.a(ng))
        {
            super.nb.a(16);
            super.nb.f(Sh);
            super.nb.f(Lh);
            super.nb.f(Mh);
            super.nb.f(Nh);
            super.nb.f(Oh);
            super.nb.f(Ph);
            super.nb.f(Qh);
            super.nb.f(Rh);
            super.nb.i();
            Xe.c();
            xe = false;
        }
    }

    public void R()
    {
        int i1 = f.J;
        byte abyte0[] = a(Dk[501] + p.e + Dk[497], Dk[502], 20);
        if(abyte0 == null)
        {
            te = true;
            return;
        }
        byte abyte1[] = m.a(Dk[507], 0, abyte0);
        Xe.a(Ei, m.a(Dk[505], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 1, m.a(Dk[513], 0, abyte0), abyte1, 6);
        Xe.a(Ei + 9, m.a(Dk[504], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 10, m.a(Dk[496], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 11, m.a(Dk[512], 0, abyte0), abyte1, 3);
        Xe.a(Ei + 14, m.a(Dk[506], 0, abyte0), abyte1, 8);
        Xe.a(Ei + 22, m.a(Dk[500], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 23, m.a(Dk[509], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 24, m.a(Dk[511], 0, abyte0), abyte1, 1);
        Xe.a(Ei + 25, m.a(Dk[495], 0, abyte0), abyte1, 2);
        Xe.a(Fi, m.a(Dk[503], 0, abyte0), abyte1, 2);
        Xe.a(Fi + 2, m.a(Dk[494], 0, abyte0), abyte1, 4);
        Xe.a(Fi + 6, m.a(Dk[499], 0, abyte0), abyte1, 2);
        Xe.a(Hi, m.a(Dk[508], 0, abyte0), abyte1, f.B);
        int j1 = f.O;
        for(int k1 = 1; j1 > 0; k1++)
        {
            int k2 = j1;
            j1 -= 30;
            if(k2 > 30)
                k2 = 30;
            Xe.a(Gi + (k1 - 1) * 30, m.a(Dk[498] + k1 + Dk[510], 0, abyte0), abyte1, k2);
        }

        Xe.b(Ei);
        Xe.b(Ei + 9);
        for(int l1 = 11; l1 <= 26; l1++)
            Xe.b(Ei + l1);

        for(int i2 = 0; i2 < f.B; i2++)
            Xe.b(Hi + i2);

        for(int j2 = 0; j2 < f.O; j2++)
            Xe.b(Gi + j2);

    }

    public byte[] a(String s1, String s2, int i1)
    {
        if(!we)
            s1 = Dk[632] + s1;
        byte abyte0[] = y.a(s1);
        if(abyte0 != null)
        {
            int j1 = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l1 = 0; l1 < abyte0.length - 6; l1++)
                abyte1[l1] = abyte0[l1 + 6];

            b(i1, Dk[631] + s2);
            if(k1 != j1)
            {
                byte abyte2[] = new byte[j1];
                s.a(abyte2, j1, abyte1, k1, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.a(s1, s2, i1);
        }
    }

    public Socket a(String s1, int i1)
        throws IOException
    {
        if(y.f != null)
        {
            Socket socket = y.a(i1);
            return socket;
        } else
        {
            Socket socket1 = new Socket(InetAddress.getByName(s1), i1);
            socket1.setSoTimeout(30000);
            socket1.setTcpNoDelay(true);
            return socket1;
        }
    }

    public void f()
    {
        if(Nd)
            return;
        if(pe)
            return;
        if(te)
            return;
        try
        {
            mi++;
            if(Di == 0)
            {
                super.N = 0;
                Y();
            }
            if(Di == 1)
            {
                super.N++;
                ob();
            }
            super.V = 0;
            super.X = 0;
            ei++;
            if(ei > 500)
            {
                ei = 0;
                int i1 = (int)(Math.random() * 4D);
                if((i1 & 1) == 1)
                    Yh += Zh;
                if((i1 & 2) == 2)
                    Pi += Qi;
            }
            if(Yh < -50)
                Zh = 2;
            if(Yh > 50)
                Zh = -2;
            if(Pi < -50)
                Qi = 2;
            if(Pi > 50)
                Qi = -2;
            if(Ug > 0)
                Ug--;
            if(Vg > 0)
                Vg--;
            if(Wg > 0)
                Wg--;
            if(Xg > 0)
            {
                Xg--;
                return;
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            pb();
            pe = true;
        }
    }

    public void a(Runnable runnable)
    {
        if(y.f != null)
        {
            y.a(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    public void l()
    {
        Bg = 0;
        if(Ag != 0)
        {
            q();
            return;
        } else
        {
            super.l();
            return;
        }
    }

    public void g()
    {
        j();
        mc = true;
        pb();
        if(Df != null)
            Df.a();
    }

    public void b(String s1, String s2)
    {
        if(Zf == 1)
            Me.a(vg, s1 + " " + s2);
        if(Zf == 2)
            Ne.a(Fh, s1 + " " + s2);
        nf = s2;
        gb();
        k();
    }

    public void p()
    {
        int i1 = f.J;
        Bg = 0;
        ab(1);
        Ag = 0;
        Zf = 0;
        Di = 1;
        eb();
        Xe.c();
        Xe.a(Ye, 0, 0);
        for(int j1 = 0; j1 < Yg; j1++)
        {
            De.b(Ve[j1]);
            Ee.i(Dj[j1], Ej[j1], Fj[j1]);
        }

        for(int k1 = 0; k1 < Bh; k1++)
        {
            De.b(Ue[k1]);
            Ee.d(zj[k1], Aj[k1], xj[k1], yj[k1]);
        }

        Yg = 0;
        Bh = 0;
        lh = 0;
        xg = 0;
        for(int l1 = 0; l1 < 4000; l1++)
            He[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            Ke[i2] = null;

        hi = 0;
        for(int j2 = 0; j2 < 5000; j2++)
            Je[j2] = null;

        for(int k2 = 0; k2 < 500; k2++)
            Fe[k2] = null;

        for(int l2 = 0; l2 < 50; l2++)
            ze[l2] = false;

        hh = 0;
        super.V = 0;
        super.U = 0;
        Zd = false;
        ne = false;
        me = false;
        super.Ab = 0;
    }

    public void q()
    {
        Bg = 0;
        Zf = 0;
        Di = 0;
        Ag = 0;
    }

    public void h()
    {
        if(te)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font(Dk[491], 1, 16));
            g1.setColor(Color.yellow);
            int i1 = 35;
            g1.drawString(Dk[487], 30, i1);
            i1 += 50;
            g1.setColor(Color.white);
            g1.drawString(Dk[488], 30, i1);
            i1 += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font(Dk[491], 1, 12));
            g1.drawString(Dk[481], 30, i1);
            i1 += 30;
            g1.drawString(Dk[489], 30, i1);
            i1 += 30;
            g1.drawString(Dk[493], 30, i1);
            i1 += 30;
            g1.drawString(Dk[479], 30, i1);
            i1 += 30;
            g1.drawString(Dk[480], 30, i1);
            b(1);
            return;
        }
        if(Nd)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font(Dk[491], 1, 20));
            g2.setColor(Color.white);
            g2.drawString(Dk[484], 50, 50);
            g2.drawString(Dk[485], 50, 100);
            g2.drawString(Dk[483], 50, 150);
            b(1);
            return;
        }
        if(pe)
        {
            Graphics g3 = getGraphics();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font(Dk[491], 1, 20));
            g3.setColor(Color.white);
            g3.drawString(Dk[486], 50, 50);
            g3.drawString(Dk[492], 50, 100);
            g3.drawString(Dk[490], 50, 150);
            g3.drawString(Dk[482], 50, 200);
            b(1);
            return;
        }
        try
        {
            if(Di == 0)
            {
                Xe.c = false;
                gb();
            }
            if(Di == 1)
            {
                Xe.c = true;
                K();
                return;
            }
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            pb();
            pe = true;
        }
    }

    public void r()
    {
        Ag = 0;
        a(Dk[515], 3);
        ab.a(Dk[514]);
    }

    public void a(int i1, int j1, byte abyte0[])
    {
        int k1 = f.J;
        if(i1 == 18)
        {
            yg = xg;
            for(int l1 = 0; l1 < yg; l1++)
                Ie[l1] = Ke[l1];

            int i2 = 8;
            Ri = m.a(abyte0, i2, 11);
            i2 += 11;
            Si = m.a(abyte0, i2, 13);
            i2 += 13;
            int i6 = m.a(abyte0, i2, 4);
            i2 += 4;
            boolean flag1 = n(Ri, Si);
            Ri -= Qg;
            Si -= Rg;
            int i14 = Ri * Ci + 64;
            int j17 = Si * Ci + 64;
            if(flag1)
            {
                Le.n = 0;
                Le.m = 0;
                Le.g = Le.G[0] = i14;
                Le.h = Le.H[0] = j17;
            }
            xg = 0;
            Le = c(Ti, i14, j17, i6);
            int i20 = m.a(abyte0, i2, 8);
            i2 += 8;
            for(int k23 = 0; k23 < i20; k23++)
            {
                r r4 = Ie[k23 + 1];
                int k32 = m.a(abyte0, i2, 1);
                i2++;
                if(k32 != 0)
                {
                    int j34 = m.a(abyte0, i2, 1);
                    i2++;
                    if(j34 == 0)
                    {
                        int k35 = m.a(abyte0, i2, 3);
                        i2 += 3;
                        int k36 = r4.n;
                        int i37 = r4.G[k36];
                        int k37 = r4.H[k36];
                        if(k35 == 2 || k35 == 1 || k35 == 3)
                            i37 += Ci;
                        if(k35 == 6 || k35 == 5 || k35 == 7)
                            i37 -= Ci;
                        if(k35 == 4 || k35 == 3 || k35 == 5)
                            k37 += Ci;
                        if(k35 == 0 || k35 == 1 || k35 == 7)
                            k37 -= Ci;
                        r4.l = k35;
                        r4.n = k36 = (k36 + 1) % 10;
                        r4.G[k36] = i37;
                        r4.H[k36] = k37;
                    } else
                    {
                        int l35 = m.a(abyte0, i2, 4);
                        if((l35 & 0xc) == 12)
                        {
                            i2 += 2;
                            continue;
                        }
                        r4.l = m.a(abyte0, i2, 4);
                        i2 += 4;
                    }
                }
                Ke[xg++] = r4;
            }

            int l23 = 0;
            do
            {
                if(i2 + 24 >= j1 * 8)
                    break;
                int i29 = m.a(abyte0, i2, 11);
                i2 += 11;
                int l32 = m.a(abyte0, i2, 5);
                i2 += 5;
                if(l32 > 15)
                    l32 -= 32;
                int k34 = m.a(abyte0, i2, 5);
                i2 += 5;
                if(k34 > 15)
                    k34 -= 32;
                int i36 = m.a(abyte0, i2, 4);
                i2 += 4;
                int l36 = m.a(abyte0, i2, 1);
                i2++;
                int j37 = (Ri + l32) * Ci + 64;
                int l37 = (Si + k34) * Ci + 64;
                c(i29, j37, l37, i36);
                if(l36 == 0)
                    Rj[l23++] = i29;
            } while(true);
            if(l23 > 0)
            {
                super.nb.a(118);
                super.nb.e(l23);
                for(int j29 = 0; j29 < l23; j29++)
                {
                    r r5 = He[Rj[j29]];
                    super.nb.e(r5.e);
                    super.nb.e(r5.f);
                }

                super.nb.i();
                l23 = 0;
            }
            return;
        }
        if(i1 == 181)
        {
            for(int j2 = 1; j2 < j1;)
                if(m.a(abyte0[j2]) == 255)
                {
                    int j6 = 0;
                    int k10 = Ri + abyte0[j2 + 1] >> 3;
                    int j14 = Si + abyte0[j2 + 2] >> 3;
                    j2 += 3;
                    for(int k17 = 0; k17 < lh; k17++)
                    {
                        int j20 = (Hj[k17] >> 3) - k10;
                        int i24 = (Ij[k17] >> 3) - j14;
                        if(j20 == 0 && i24 == 0)
                            continue;
                        if(k17 != j6)
                        {
                            Hj[j6] = Hj[k17];
                            Ij[j6] = Ij[k17];
                            Jj[j6] = Jj[k17];
                            Kj[j6] = Kj[k17];
                        }
                        j6++;
                    }

                    lh = j6;
                } else
                {
                    int k6 = m.a(abyte0, j2);
                    j2 += 2;
                    int l10 = Ri + abyte0[j2++];
                    int k14 = Si + abyte0[j2++];
                    if((k6 & 0x8000) == 0)
                    {
                        Hj[lh] = l10;
                        Ij[lh] = k14;
                        Jj[lh] = k6;
                        Kj[lh] = 0;
                        int l17 = 0;
                        do
                        {
                            if(l17 >= Yg)
                                break;
                            if(Dj[l17] == l10 && Ej[l17] == k14)
                            {
                                Kj[lh] = f.vb[Fj[l17]];
                                break;
                            }
                            l17++;
                        } while(true);
                        lh++;
                    } else
                    {
                        k6 &= 0x7fff;
                        int i18 = 0;
                        for(int k20 = 0; k20 < lh; k20++)
                            if(Hj[k20] != l10 || Ij[k20] != k14 || Jj[k20] != k6)
                            {
                                if(k20 != i18)
                                {
                                    Hj[i18] = Hj[k20];
                                    Ij[i18] = Ij[k20];
                                    Jj[i18] = Jj[k20];
                                    Kj[i18] = Kj[k20];
                                }
                                i18++;
                            } else
                            {
                                k6 = -123;
                            }

                        lh = i18;
                    }
                }

            return;
        }
        if(i1 == 238)
        {
            int k2 = 1;
            do
            {
                if(k2 >= j1)
                    break;
                if(m.a(abyte0[k2]) == 255)
                {
                    int l6 = 0;
                    int i11 = Ri + abyte0[k2 + 1] >> 3;
                    int l14 = Si + abyte0[k2 + 2] >> 3;
                    k2 += 3;
                    for(int j18 = 0; j18 < Yg; j18++)
                    {
                        int l20 = (Dj[j18] >> 3) - i11;
                        int j24 = (Ej[j18] >> 3) - l14;
                        if(l20 != 0 || j24 != 0)
                        {
                            if(j18 != l6)
                            {
                                Ve[l6] = Ve[j18];
                                Ve[l6].w = l6;
                                Dj[l6] = Dj[j18];
                                Ej[l6] = Ej[j18];
                                Fj[l6] = Fj[j18];
                                Gj[l6] = Gj[j18];
                            }
                            l6++;
                        } else
                        {
                            De.b(Ve[j18]);
                            Ee.i(Dj[j18], Ej[j18], Fj[j18]);
                        }
                    }

                    Yg = l6;
                } else
                {
                    int i7 = m.a(abyte0, k2);
                    k2 += 2;
                    int j11 = Ri + abyte0[k2++];
                    int i15 = Si + abyte0[k2++];
                    int k18 = 0;
                    for(int i21 = 0; i21 < Yg; i21++)
                        if(Dj[i21] != j11 || Ej[i21] != i15)
                        {
                            if(i21 != k18)
                            {
                                Ve[k18] = Ve[i21];
                                Ve[k18].w = k18;
                                Dj[k18] = Dj[i21];
                                Ej[k18] = Ej[i21];
                                Fj[k18] = Fj[i21];
                                Gj[k18] = Gj[i21];
                            }
                            k18++;
                        } else
                        {
                            De.b(Ve[i21]);
                            Ee.i(Dj[i21], Ej[i21], Fj[i21]);
                        }

                    Yg = k18;
                    if(i7 != 60000)
                    {
                        int j21 = Ee.a(j11, i15);
                        int k24;
                        int k29;
                        if(j21 == 0 || j21 == 4)
                        {
                            k24 = f.sb[i7];
                            k29 = f.tb[i7];
                        } else
                        {
                            k29 = f.sb[i7];
                            k24 = f.tb[i7];
                        }
                        int i33 = ((j11 + j11 + k24) * Ci) / 2;
                        int l34 = ((i15 + i15 + k29) * Ci) / 2;
                        int j36 = f.rb[i7];
                        u u2 = We[j36].i();
                        De.a(u2);
                        u2.w = Yg;
                        u2.d(0, j21 * 32, 0);
                        u2.f(i33, -Ee.g(i33, l34), l34);
                        u2.a(true, 48, 48, -50, -10, -50);
                        Ee.a(j11, i15, i7);
                        if(i7 == 74)
                            u2.f(0, -480, 0);
                        Dj[Yg] = j11;
                        Ej[Yg] = i15;
                        Fj[Yg] = i7;
                        Gj[Yg] = j21;
                        Ve[Yg++] = u2;
                    }
                }
            } while(true);
            return;
        }
        if(i1 == 171)
        {
            int l2 = 1;
            pg = abyte0[l2++] & 0xff;
            for(int j7 = 0; j7 < pg; j7++)
            {
                int k11 = m.a(abyte0, l2);
                l2 += 2;
                lj[j7] = k11 & 0x7fff;
                nj[j7] = k11 / 32768;
                if(f.lb[k11 & 0x7fff] == 0)
                {
                    mj[j7] = m.e(abyte0, l2);
                    if(mj[j7] >= 128)
                        l2 += 4;
                    else
                        l2++;
                } else
                {
                    mj[j7] = 1;
                }
            }

            return;
        }
        if(i1 == 139)
        {
            int i3 = m.a(abyte0, 1);
            int k7 = 3;
            for(int l11 = 0; l11 < i3; l11++)
            {
                int j15 = m.a(abyte0, k7);
                k7 += 2;
                r r2 = He[j15];
                byte byte2 = abyte0[k7];
                k7++;
                if(byte2 == 0)
                {
                    int l24 = m.a(abyte0, k7);
                    k7 += 2;
                    if(r2 != null)
                    {
                        r2.q = 150;
                        r2.p = l24;
                    }
                    continue;
                }
                if(byte2 == 1)
                {
                    byte byte3 = abyte0[k7];
                    k7++;
                    if(r2 != null)
                    {
                        String s2 = n.a(o.a(abyte0, k7, byte3));
                        boolean flag3 = false;
                        for(int i35 = 0; i35 < super.Bb; i35++)
                            if(super.sb[i35] == r2.b)
                                flag3 = true;

                        if(!flag3)
                        {
                            r2.o = 150;
                            r2.d = s2;
                            a(Dk[62] + r2.c + Dk[61] + r2.d, 2);
                            sc = Dk[55] + r2.c + ":" + s2;
                            ab.b(sc);
                        }
                    }
                    k7 += byte3;
                    continue;
                }
                if(byte2 == 2)
                {
                    int i25 = m.a(abyte0[k7]);
                    k7++;
                    int l29 = m.a(abyte0[k7]);
                    k7++;
                    int j33 = m.a(abyte0[k7]);
                    k7++;
                    if(r2 == null)
                        continue;
                    r2.r = i25;
                    r2.s = l29;
                    r2.t = j33;
                    r2.u = 200;
                    if(r2 == Le)
                    {
                        sj[3] = l29;
                        Uj[3] = j33;
                        qe = false;
                        ae = false;
                    }
                    continue;
                }
                if(byte2 == 3)
                {
                    int j25 = m.a(abyte0, k7);
                    k7 += 2;
                    int i30 = m.a(abyte0, k7);
                    k7 += 2;
                    if(r2 != null)
                    {
                        r2.A = j25;
                        r2.C = i30;
                        r2.B = -1;
                        r2.D = ai;
                    }
                    continue;
                }
                if(byte2 == 4)
                {
                    int k25 = m.a(abyte0, k7);
                    k7 += 2;
                    int j30 = m.a(abyte0, k7);
                    k7 += 2;
                    if(r2 != null)
                    {
                        r2.A = k25;
                        r2.B = j30;
                        r2.C = -1;
                        r2.D = ai;
                    }
                    continue;
                }
                if(byte2 == 5)
                {
                    if(r2 != null)
                    {
                        r2.f = m.a(abyte0, k7);
                        k7 += 2;
                        r2.b = m.c(abyte0, k7);
                        k7 += 8;
                        r2.c = m.a(r2.b);
                        int l25 = m.a(abyte0[k7]);
                        k7++;
                        for(int k30 = 0; k30 < l25; k30++)
                        {
                            r2.I[k30] = m.a(abyte0[k7]);
                            k7++;
                        }

                        for(int l30 = l25; l30 < 12; l30++)
                            r2.I[l30] = 0;

                        r2.w = abyte0[k7++] & 0xff;
                        r2.x = abyte0[k7++] & 0xff;
                        r2.y = abyte0[k7++] & 0xff;
                        r2.z = abyte0[k7++] & 0xff;
                        r2.v = abyte0[k7++] & 0xff;
                        r2.F = abyte0[k7++] & 0xff;
                    } else
                    {
                        k7 += 14;
                        int i26 = m.a(abyte0[k7]);
                        k7 += i26 + 1;
                    }
                    continue;
                }
                if(byte2 != 6)
                    continue;
                byte byte4 = abyte0[k7];
                k7++;
                if(r2 != null)
                {
                    String s3 = o.a(abyte0, k7, byte4);
                    r2.o = 150;
                    r2.d = s3;
                    if(r2 == Le)
                    {
                        a(Dk[62] + r2.c + Dk[61] + r2.d, 5);
                        rc = Dk[56] + r2.c + ":" + s3;
                        ab.b(rc);
                    }
                }
                k7 += byte4;
            }

            return;
        }
        if(i1 == 29)
        {
            int j3 = 1;
            do
            {
                if(j3 >= j1)
                    break;
                if(m.a(abyte0[j3]) == 255)
                {
                    int l7 = 0;
                    int i12 = Ri + abyte0[j3 + 1] >> 3;
                    int k15 = Si + abyte0[j3 + 2] >> 3;
                    j3 += 3;
                    for(int l18 = 0; l18 < Bh; l18++)
                    {
                        int k21 = (zj[l18] >> 3) - i12;
                        int j26 = (Aj[l18] >> 3) - k15;
                        if(k21 != 0 || j26 != 0)
                        {
                            if(l18 != l7)
                            {
                                Ue[l7] = Ue[l18];
                                Ue[l7].w = l7 + 10000;
                                zj[l7] = zj[l18];
                                Aj[l7] = Aj[l18];
                                xj[l7] = xj[l18];
                                yj[l7] = yj[l18];
                            }
                            l7++;
                        } else
                        {
                            De.b(Ue[l18]);
                            Ee.d(zj[l18], Aj[l18], xj[l18], yj[l18]);
                        }
                    }

                    Bh = l7;
                } else
                {
                    int i8 = m.a(abyte0, j3);
                    j3 += 2;
                    int j12 = Ri + abyte0[j3++];
                    int l15 = Si + abyte0[j3++];
                    byte byte1 = abyte0[j3++];
                    int l21 = 0;
                    for(int k26 = 0; k26 < Bh; k26++)
                        if(zj[k26] != j12 || Aj[k26] != l15 || xj[k26] != byte1)
                        {
                            if(k26 != l21)
                            {
                                Ue[l21] = Ue[k26];
                                Ue[l21].w = l21 + 10000;
                                zj[l21] = zj[k26];
                                Aj[l21] = Aj[k26];
                                xj[l21] = xj[k26];
                                yj[l21] = yj[k26];
                            }
                            l21++;
                        } else
                        {
                            De.b(Ue[k26]);
                            Ee.d(zj[k26], Aj[k26], xj[k26], yj[k26]);
                        }

                    Bh = l21;
                    if(i8 != 65535)
                    {
                        Ee.b(j12, l15, byte1, i8);
                        u u1 = a(j12, l15, byte1, i8, Bh);
                        Ue[Bh] = u1;
                        zj[Bh] = j12;
                        Aj[Bh] = l15;
                        yj[Bh] = i8;
                        xj[Bh++] = byte1;
                    }
                }
            } while(true);
            return;
        }
        if(i1 == 152)
        {
            ii = hi;
            hi = 0;
            for(int k3 = 0; k3 < ii; k3++)
                Ge[k3] = Fe[k3];

            int l3 = 8;
            int j8 = m.a(abyte0, l3, 8);
            l3 += 8;
            for(int k12 = 0; k12 < j8; k12++)
            {
                r r1 = Ge[k12];
                int i19 = m.a(abyte0, l3, 1);
                l3++;
                if(i19 != 0)
                {
                    int i22 = m.a(abyte0, l3, 1);
                    l3++;
                    if(i22 == 0)
                    {
                        int l26 = m.a(abyte0, l3, 3);
                        l3 += 3;
                        int i31 = r1.n;
                        int k33 = r1.G[i31];
                        int j35 = r1.H[i31];
                        if(l26 == 2 || l26 == 1 || l26 == 3)
                            k33 += Ci;
                        if(l26 == 6 || l26 == 5 || l26 == 7)
                            k33 -= Ci;
                        if(l26 == 4 || l26 == 3 || l26 == 5)
                            j35 += Ci;
                        if(l26 == 0 || l26 == 1 || l26 == 7)
                            j35 -= Ci;
                        r1.l = l26;
                        r1.n = i31 = (i31 + 1) % 10;
                        r1.G[i31] = k33;
                        r1.H[i31] = j35;
                    } else
                    {
                        int i27 = m.a(abyte0, l3, 4);
                        if((i27 & 0xc) == 12)
                        {
                            l3 += 2;
                            continue;
                        }
                        r1.l = m.a(abyte0, l3, 4);
                        l3 += 4;
                    }
                }
                Fe[hi++] = r1;
            }

            while(l3 + 34 < j1 * 8) 
            {
                int l12 = m.a(abyte0, l3, 12);
                l3 += 12;
                int i16 = m.a(abyte0, l3, 5);
                l3 += 5;
                if(i16 > 15)
                    i16 -= 32;
                int j19 = m.a(abyte0, l3, 5);
                l3 += 5;
                if(j19 > 15)
                    j19 -= 32;
                int j22 = m.a(abyte0, l3, 4);
                l3 += 4;
                int j27 = (Ri + i16) * Ci + 64;
                int j31 = (Si + j19) * Ci + 64;
                int l33 = m.a(abyte0, l3, 10);
                l3 += 10;
                if(l33 >= f.E)
                    l33 = 24;
                b(l12, j27, j31, j22, l33);
            }
            return;
        }
        if(i1 == 159)
        {
            int i4 = m.a(abyte0, 1);
            int k8 = 3;
            for(int i13 = 0; i13 < i4; i13++)
            {
                int j16 = m.a(abyte0, k8);
                k8 += 2;
                r r3 = Je[j16];
                int k22 = m.a(abyte0[k8]);
                k8++;
                if(k22 == 1)
                {
                    int k27 = m.a(abyte0, k8);
                    k8 += 2;
                    byte byte5 = abyte0[k8];
                    k8++;
                    if(r3 != null)
                    {
                        String s4 = o.a(abyte0, k8, byte5);
                        r3.o = 150;
                        r3.d = s4;
                        if(k27 == Le.e)
                        {
                            a(Dk[62] + f.k[r3.i] + Dk[61] + r3.d, 5);
                            tc = Dk[48] + f.k[r3.i] + ":" + s4;
                            ab.b(tc);
                        }
                    }
                    k8 += byte5;
                    continue;
                }
                if(k22 != 2)
                    continue;
                int l27 = m.a(abyte0[k8]);
                k8++;
                int k31 = m.a(abyte0[k8]);
                k8++;
                int i34 = m.a(abyte0[k8]);
                k8++;
                if(r3 != null)
                {
                    r3.r = l27;
                    r3.s = k31;
                    r3.t = i34;
                    r3.u = 200;
                }
            }

            return;
        }
        if(i1 == 55)
        {
            ie = true;
            ab.a(Dk[53]);
            int j4 = m.a(abyte0[1]);
            ui = j4;
            int l8 = 2;
            for(int j13 = 0; j13 < j4; j13++)
            {
                int k16 = m.a(abyte0[l8]);
                l8++;
                wf[j13] = new String(abyte0, l8, k16);
                l8 += k16;
            }

            return;
        }
        if(i1 == 93)
        {
            ie = false;
            ab.a(Dk[57]);
            return;
        }
        if(i1 == 167)
        {
            Ud = true;
            Ti = m.a(abyte0, 1);
            bh = m.a(abyte0, 3);
            ch = m.a(abyte0, 5);
            Sg = m.a(abyte0, 7);
            dh = m.a(abyte0, 9);
            ch -= Sg * dh;
            return;
        }
        if(i1 == 205)
        {
            int k4 = 1;
            for(int i9 = 0; i9 < 18; i9++)
                sj[i9] = m.a(abyte0[k4++]);

            for(int j9 = 0; j9 < 18; j9++)
                Uj[j9] = m.a(abyte0[k4++]);

            for(int k9 = 0; k9 < 18; k9++)
            {
                oj[k9] = m.b(abyte0, k4);
                k4 += 4;
            }

            cj = m.a(abyte0[k4++]);
            return;
        }
        if(i1 == 79)
        {
            for(int l4 = 0; l4 < 5; l4++)
                Nj[l4] = m.a(abyte0[1 + l4]);

            return;
        }
        if(i1 == 72)
        {
            aj = 250;
            return;
        }
        if(i1 == 246)
        {
            int i5 = (j1 - 1) / 4;
            for(int l9 = 0; l9 < i5; l9++)
            {
                int k13 = Ri + m.d(abyte0, 1 + l9 * 4) >> 3;
                int l16 = Si + m.d(abyte0, 3 + l9 * 4) >> 3;
                int k19 = 0;
                for(int l22 = 0; l22 < lh; l22++)
                {
                    int i28 = (Hj[l22] >> 3) - k13;
                    int l31 = (Ij[l22] >> 3) - l16;
                    if(i28 == 0 && l31 == 0)
                        continue;
                    if(l22 != k19)
                    {
                        Hj[k19] = Hj[l22];
                        Ij[k19] = Ij[l22];
                        Jj[k19] = Jj[l22];
                        Kj[k19] = Kj[l22];
                    }
                    k19++;
                }

                lh = k19;
                k19 = 0;
                for(int i23 = 0; i23 < Yg; i23++)
                {
                    int j28 = (Dj[i23] >> 3) - k13;
                    int i32 = (Ej[i23] >> 3) - l16;
                    if(j28 != 0 || i32 != 0)
                    {
                        if(i23 != k19)
                        {
                            Ve[k19] = Ve[i23];
                            Ve[k19].w = k19;
                            Dj[k19] = Dj[i23];
                            Ej[k19] = Ej[i23];
                            Fj[k19] = Fj[i23];
                            Gj[k19] = Gj[i23];
                        }
                        k19++;
                    } else
                    {
                        De.b(Ve[i23]);
                        Ee.i(Dj[i23], Ej[i23], Fj[i23]);
                    }
                }

                Yg = k19;
                k19 = 0;
                for(int j23 = 0; j23 < Bh; j23++)
                {
                    int k28 = (zj[j23] >> 3) - k13;
                    int j32 = (Aj[j23] >> 3) - l16;
                    if(k28 != 0 || j32 != 0)
                    {
                        if(j23 != k19)
                        {
                            Ue[k19] = Ue[j23];
                            Ue[k19].w = k19 + 10000;
                            zj[k19] = zj[j23];
                            Aj[k19] = Aj[j23];
                            xj[k19] = xj[j23];
                            yj[k19] = yj[j23];
                        }
                        k19++;
                    } else
                    {
                        De.b(Ue[j23]);
                        Ee.d(zj[j23], Aj[j23], xj[j23], yj[j23]);
                    }
                }

                Bh = k19;
            }

            return;
        }
        if(i1 == 237)
        {
            xe = true;
            return;
        }
        if(i1 == 240)
        {
            int j5 = m.a(abyte0, 1);
            if(He[j5] != null)
                df = He[j5].c;
            le = true;
            ue = false;
            ve = false;
            Oi = 0;
            Uh = 0;
            return;
        }
        if(i1 == 3)
        {
            le = false;
            Qd = false;
            return;
        }
        if(i1 == 245)
        {
            Uh = abyte0[1] & 0xff;
            int k5 = 2;
            for(int i10 = 0; i10 < Uh; i10++)
            {
                ck[i10] = m.a(abyte0, k5);
                k5 += 2;
                dk[i10] = m.b(abyte0, k5);
                k5 += 4;
            }

            ue = false;
            ve = false;
            return;
        }
        if(i1 != 207)
            break MISSING_BLOCK_LABEL_5906;
        byte byte0 = abyte0[1];
        if(byte0 == 1)
        {
            ue = true;
            return;
        }
        int l5;
        String s1;
        int j10;
        boolean flag;
        int l13;
        int i17;
        int l19;
        boolean flag2;
        int l28;
        try
        {
            ue = false;
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            if(wi >= 3);
        }
        break MISSING_BLOCK_LABEL_8392;
        if(i1 == 153)
        {
            Zd = true;
            ab.a(Dk[54]);
            l5 = 1;
            j10 = abyte0[l5++] & 0xff;
            l13 = abyte0[l5++];
            ci = abyte0[l5++] & 0xff;
            di = abyte0[l5++] & 0xff;
            for(i17 = 0; i17 < 40; i17++)
                uj[i17] = -1;

            for(i17 = 0; i17 < j10; i17++)
            {
                uj[i17] = m.a(abyte0, l5);
                l5 += 2;
                vj[i17] = m.a(abyte0, l5);
                l5 += 2;
                wj[i17] = abyte0[l5++];
            }

            if(l13 == 1)
            {
                i17 = 39;
                for(l19 = 0; l19 < pg && i17 >= j10; l19++)
                {
                    flag2 = false;
                    l28 = 0;
                    do
                    {
                        if(l28 >= 40)
                            break;
                        if(uj[l28] == lj[l19])
                        {
                            flag2 = true;
                            break;
                        }
                        l28++;
                    } while(true);
                    if(lj[l19] == 10)
                        flag2 = true;
                    if(!flag2)
                    {
                        uj[i17] = lj[l19] & 0x7fff;
                        vj[i17] = 0;
                        wj[i17] = 0;
                        i17--;
                    }
                }

            }
            if(fi >= 0 && fi < 40 && uj[fi] != gi)
            {
                fi = -1;
                gi = -2;
            }
            return;
        }
        if(i1 == 243)
        {
            Zd = false;
            System.out.println(Dk[50]);
            ab.a(Dk[58]);
            return;
        }
        if(i1 != 118)
            break MISSING_BLOCK_LABEL_6315;
        l5 = abyte0[1];
        if(l5 == 1)
        {
            ve = true;
            return;
        }
        ve = false;
        return;
        if(i1 == 105)
        {
            Sd = m.a(abyte0[1]) == 1;
            ce = m.a(abyte0[2]) == 1;
            je = m.a(abyte0[3]) == 1;
            return;
        }
        if(i1 == 140)
        {
            for(l5 = 0; l5 < j1 - 1; l5++)
            {
                flag = abyte0[l5 + 1] == 1;
                if(!ze[l5] && flag)
                    k(Dk[60]);
                if(ze[l5] && !flag)
                    k(Dk[51]);
                ze[l5] = flag;
            }

            return;
        }
        if(i1 == 164)
        {
            for(l5 = 0; l5 < 50; l5++)
                Ae[l5] = abyte0[l5 + 1] == 1;

            return;
        }
        if(i1 == 120)
        {
            ne = true;
            ab.a(Dk[47]);
            l5 = 1;
            xi = abyte0[l5++] & 0xff;
            li = abyte0[l5++] & 0xff;
            for(flag = false; flag < xi; flag++)
            {
                Sj[flag] = m.a(abyte0, l5);
                l5 += 2;
                Tj[flag] = m.e(abyte0, l5);
                if(Tj[flag] >= 128)
                    l5 += 4;
                else
                    l5++;
            }

            ib();
            return;
        }
        if(i1 == 226)
        {
            ne = false;
            System.out.println(Dk[63]);
            ab.a(Dk[52]);
            return;
        }
        if(i1 == 108)
        {
            l5 = abyte0[1] & 0xff;
            oj[l5] = m.b(abyte0, 2);
            return;
        }
        if(i1 == 23)
        {
            l5 = m.a(abyte0, 1);
            if(He[l5] != null)
                jf = He[l5].c;
            se = true;
            ji = 0;
            Mi = 0;
            Od = false;
            Pd = false;
            Vd = false;
            Wd = false;
            Xd = false;
            Yd = false;
            return;
        }
        if(i1 == 10)
        {
            se = false;
            ee = false;
            return;
        }
        if(i1 == 13)
        {
            Qd = true;
            Rd = false;
            le = false;
            l5 = 1;
            Ze = m.c(abyte0, l5);
            l5 += 8;
            ag = abyte0[l5++] & 0xff;
            for(flag = false; flag < ag; flag++)
            {
                jj[flag] = m.a(abyte0, l5);
                l5 += 2;
                kj[flag] = m.b(abyte0, l5);
                l5 += 4;
            }

            rh = abyte0[l5++] & 0xff;
            for(flag = false; flag < rh; flag++)
            {
                Xj[flag] = m.a(abyte0, l5);
                l5 += 2;
                Yj[flag] = m.b(abyte0, l5);
                l5 += 4;
            }

            return;
        }
        if(i1 == 75)
        {
            Mi = abyte0[1] & 0xff;
            l5 = 2;
            for(flag = false; flag < Mi; flag++)
            {
                ok[flag] = m.a(abyte0, l5);
                l5 += 2;
                pk[flag] = m.b(abyte0, l5);
                l5 += 4;
            }

            Od = false;
            Pd = false;
            return;
        }
        if(i1 == 119)
        {
            if(abyte0[1] == 1)
                Vd = true;
            else
                Vd = false;
            if(abyte0[2] == 1)
                Wd = true;
            else
                Wd = false;
            if(abyte0[3] == 1)
                Xd = true;
            else
                Xd = false;
            if(abyte0[4] == 1)
                Yd = true;
            else
                Yd = false;
            Od = false;
            Pd = false;
            return;
        }
        if(i1 == 172)
        {
            l5 = 1;
            flag = abyte0[l5++] & 0xff;
            l13 = m.a(abyte0, l5);
            l5 += 2;
            i17 = m.e(abyte0, l5);
            if(i17 >= 128)
                l5 += 4;
            else
                l5++;
            if(i17 == 0)
            {
                xi--;
                for(l19 = ((flag) ? 1 : 0); l19 < xi; l19++)
                {
                    Sj[l19] = Sj[l19 + 1];
                    Tj[l19] = Tj[l19 + 1];
                }

            } else
            {
                Sj[flag] = l13;
                Tj[flag] = i17;
                if(flag >= xi)
                    xi = flag + 1;
            }
            ib();
            return;
        }
        if(i1 == 242)
        {
            l5 = 1;
            flag = true;
            l13 = abyte0[l5++] & 0xff;
            i17 = m.a(abyte0, l5);
            l5 += 2;
            if(f.lb[i17 & 0x7fff] == 0)
            {
                flag = m.e(abyte0, l5);
                if(flag >= 128)
                    l5 += 4;
                else
                    l5++;
            }
            lj[l13] = i17 & 0x7fff;
            nj[l13] = i17 / 32768;
            mj[l13] = ((flag) ? 1 : 0);
            if(l13 >= pg)
                pg = l13 + 1;
            return;
        }
        if(i1 == 104)
        {
            l5 = abyte0[1] & 0xff;
            pg--;
            for(flag = l5; flag < pg; flag++)
            {
                lj[flag] = lj[flag + 1];
                mj[flag] = mj[flag + 1];
                nj[flag] = nj[flag + 1];
            }

            return;
        }
        if(i1 == 99)
        {
            l5 = 1;
            flag = abyte0[l5++] & 0xff;
            sj[flag] = m.a(abyte0[l5++]);
            Uj[flag] = m.a(abyte0[l5++]);
            oj[flag] = m.b(abyte0, l5);
            l5 += 4;
            return;
        }
        if(i1 != 210)
            break MISSING_BLOCK_LABEL_7650;
        l5 = abyte0[1];
        if(l5 == 1)
        {
            Od = true;
            return;
        }
        Od = false;
        return;
        if(i1 != 235)
            break MISSING_BLOCK_LABEL_7680;
        l5 = abyte0[1];
        if(l5 == 1)
        {
            Pd = true;
            return;
        }
        Pd = false;
        return;
        if(i1 == 255)
        {
            ee = true;
            fe = false;
            se = false;
            l5 = 1;
            af = m.c(abyte0, l5);
            l5 += 8;
            Tg = abyte0[l5++] & 0xff;
            for(flag = false; flag < Tg; flag++)
            {
                Lj[flag] = m.a(abyte0, l5);
                l5 += 2;
                Mj[flag] = m.b(abyte0, l5);
                l5 += 4;
            }

            Qf = abyte0[l5++] & 0xff;
            for(flag = false; flag < Qf; flag++)
            {
                dj[flag] = m.a(abyte0, l5);
                l5 += 2;
                ej[flag] = m.b(abyte0, l5);
                l5 += 4;
            }

            Wi = abyte0[l5++] & 0xff;
            Xi = abyte0[l5++] & 0xff;
            Yi = abyte0[l5++] & 0xff;
            Zi = abyte0[l5++] & 0xff;
            return;
        }
        if(i1 == 250)
        {
            s1 = new String(abyte0, 1, j1 - 1);
            k(s1);
            return;
        }
        if(i1 == 252)
        {
            if(oh < 50)
            {
                s1 = abyte0[1] & 0xff;
                flag = abyte0[2] + Ri;
                l13 = abyte0[3] + Si;
                tj[oh] = s1;
                yk[oh] = 0;
                Zj[oh] = ((flag) ? 1 : 0);
                hk[oh] = l13;
                oh++;
            }
            return;
        }
        if(i1 == 176)
        {
            if(!he)
            {
                Pg = m.b(abyte0, 1);
                bi = m.a(abyte0, 5);
                Yf = abyte0[7] & 0xff;
                qi = m.a(abyte0, 8);
                qe = true;
                ab.a(Dk[59] + ef);
                he = true;
                of = null;
            }
            return;
        }
        if(i1 == 146)
        {
            cf = new String(abyte0, 1, j1 - 1);
            ae = true;
            Td = false;
            return;
        }
        if(i1 == 138)
        {
            cf = new String(abyte0, 1, j1 - 1);
            ae = true;
            Td = true;
            return;
        }
        if(i1 == 84)
        {
            Wh = m.a(abyte0, 1);
            return;
        }
        if(i1 == 51)
        {
            if(!me)
                Xh = Wh;
            me = true;
            super.E = "";
            super.F = "";
            Xe.a(Ii + 1, abyte0);
            kf = null;
            a(abyte0);
            ab.a(Dk[49]);
            Fc = true;
            return;
        }
        if(i1 == 21)
        {
            Xh = m.a(abyte0, 1);
            return;
        }
        if(i1 == 125)
        {
            me = false;
            ab.a(Dk[45]);
            Fc = false;
            uc = false;
            return;
        }
        if(i1 == 127)
        {
            kf = Dk[46];
            return;
        }
        if(i1 == 113)
        {
            Bg = m.a(abyte0, 1) * 32;
            return;
        }
    }

    public void d(String s1)
    {
        if(s1.startsWith(Dk[751]))
        {
            a(s1, 4);
            return;
        }
        if(s1.startsWith(Dk[376]))
        {
            a(Dk[750] + s1, 5);
            return;
        }
        if(s1.startsWith(Dk[748]))
        {
            a(Dk[222] + s1, 6);
            return;
        }
        if(s1.startsWith(Dk[749]))
        {
            a(s1, 6);
            return;
        } else
        {
            a(s1, 3);
            return;
        }
    }

    public static void main(String args[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.we = false;
        if(args.length > 0 && args[0].equals(Dk[554]))
            mudclient1.re = true;
        if(args.length > 1)
        {
            mudclient _tmp = mudclient1;
            b.tb = args[1];
        }
        if(args.length > 2)
        {
            mudclient _tmp1 = mudclient1;
            b.yb = Integer.parseInt(args[2]);
        }
        mudclient1.a(mudclient1.Uf, mudclient1.Vf + 11, Dk[555], false);
        mudclient1.R = 10;
    }

    public void S()
    {
        int i1 = f.J;
        if(hh != 0)
        {
            int j1 = 0;
            do
            {
                if(j1 >= ui)
                    break;
                if(super.S < Xe.a(wf[j1], 1) && super.T > j1 * 12 && super.T < 12 + j1 * 12)
                {
                    super.nb.a(203);
                    super.nb.f(j1);
                    super.nb.i();
                    System.out.println(Dk[712] + j1 + ")");
                    break;
                }
                j1++;
            } while(true);
            hh = 0;
            ie = false;
            ab.a(Dk[57]);
            return;
        }
        for(int k1 = 0; k1 < ui; k1++)
        {
            int l1 = 65535;
            if(super.S < Xe.a(wf[k1], 1) && super.T > k1 * 12 && super.T < 12 + k1 * 12)
                l1 = 0xff0000;
            Xe.c(wf[k1], 6, 12 + k1 * 12, 1, l1);
        }

    }

    public void T()
    {
        if(super.F.length() > 0)
        {
            String s1 = super.F.trim();
            super.E = "";
            super.F = "";
            if(s1.length() > 0)
            {
                long l1 = m.b(s1);
                super.nb.a(180);
                super.nb.a(l1);
                super.nb.f(Eh);
                super.nb.f(ge ? 1 : 0);
                super.nb.i();
            }
            Vi = 0;
            return;
        }
        Xe.b(56, 130, 400, 100, 0);
        Xe.c(56, 130, 400, 100, 0xffffff);
        int i1 = 160;
        Xe.b(Dk[476], 256, i1, 1, 0xffff00);
        i1 += 18;
        Xe.b(Dk[478] + super.E + "*", 256, i1, 4, 0xffffff);
        if(super.Hb > 0)
        {
            i1 = 207;
            if(ge)
                Xe.b(Dk[477], 256, i1, 1, 0xff8000);
            else
                Xe.b(Dk[475], 256, i1, 1, 0xffffff);
            if(super.S > 106 && super.S < 406 && super.T > i1 - 13 && super.T < i1 + 2 && hh == 1)
            {
                hh = 0;
                ge = !ge;
            }
        }
        i1 = 222;
        int j1 = 0xffffff;
        if(super.S > 196 && super.S < 316 && super.T > i1 - 13 && super.T < i1 + 2)
        {
            j1 = 0xffff00;
            if(hh == 1)
            {
                hh = 0;
                Vi = 0;
            }
        }
        Xe.b(Dk[247], 256, i1, 1, j1);
        if(hh == 1 && (super.S < 56 || super.S > 456 || super.T < 130 || super.T > 230))
        {
            hh = 0;
            Vi = 0;
        }
    }

    public static String cb(int i1)
    {
        int j1 = f.J;
        String s1 = String.valueOf(i1);
        for(int k1 = s1.length() - 3; k1 > 0; k1 -= 3)
            s1 = s1.substring(0, k1) + "," + s1.substring(k1);

        if(s1.length() > 8)
            s1 = Dk[211] + s1.substring(0, s1.length() - 8) + Dk[739] + s1 + ")";
        else
        if(s1.length() > 4)
            s1 = Dk[257] + s1.substring(0, s1.length() - 4) + Dk[740] + s1 + ")";
        return s1;
    }

    public void U()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(Td)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        Xe.b(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        Xe.c(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        Xe.a(cf, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int i1 = 157 + c2 / 2;
        int j1 = 0xffffff;
        if(super.T > i1 - 12 && super.T <= i1 && super.S > 106 && super.S < 406)
            j1 = 0xff0000;
        Xe.b(Dk[565], 256, i1, 1, j1);
        if(hh == 1)
        {
            if(j1 == 0xff0000)
                ae = false;
            if((super.S < 256 - c1 / 2 || super.S > 256 + c1 / 2) && (super.T < 167 - c2 / 2 || super.T > 167 + c2 / 2))
                ae = false;
        }
        hh = 0;
    }

    public void V()
    {
        Di = 0;
        Zf = 0;
        ef = "";
        ff = "";
        mf = Dk[553];
        nf = "*" + ef + "*";
        xg = 0;
        hi = 0;
    }

    public void W()
    {
        int i1 = f.J;
        if(hh != 0 && jh == 0)
            jh = 1;
        if(jh > 0)
        {
            int j1 = super.S - 22;
            int k1 = super.T - 36;
            if(j1 >= 0 && k1 >= 0 && j1 < 468 && k1 < 262)
            {
                if(j1 > 216 && k1 > 30 && j1 < 462 && k1 < 235)
                {
                    int l1 = (j1 - 217) / 49 + ((k1 - 31) / 34) * 5;
                    if(l1 >= 0 && l1 < pg)
                    {
                        boolean flag = false;
                        int i3 = 0;
                        int k5 = lj[l1];
label0:
                        for(int l6 = 0; l6 < Oi; l6++)
                        {
                            if(wk[l6] != k5)
                                continue;
                            if(f.lb[k5] == 0)
                            {
                                int i8 = 0;
                                do
                                {
                                    if(i8 >= jh)
                                        continue label0;
                                    if(xk[l6] < mj[l1])
                                        xk[l6]++;
                                    flag = true;
                                    i8++;
                                } while(true);
                            }
                            i3++;
                        }

                        if(db(k5) <= i3)
                            flag = true;
                        if(f.pb[k5] == 1)
                        {
                            a(Dk[528], 3);
                            flag = true;
                        }
                        if(!flag && Oi < 12)
                        {
                            wk[Oi] = k5;
                            xk[Oi] = 1;
                            Oi++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.nb.a(116);
                            super.nb.f(Oi);
                            for(int i7 = 0; i7 < Oi; i7++)
                            {
                                super.nb.e(wk[i7]);
                                super.nb.b(xk[i7]);
                            }

                            super.nb.i();
                            ue = false;
                            ve = false;
                        }
                    }
                }
                if(j1 > 8 && k1 > 30 && j1 < 205 && k1 < 133)
                {
                    int i2 = (j1 - 9) / 49 + ((k1 - 31) / 34) * 4;
                    if(i2 >= 0 && i2 < Oi)
                    {
                        int k2 = wk[i2];
                        int j3 = 0;
                        do
                        {
                            if(j3 >= jh)
                                break;
                            if(f.lb[k2] == 0 && xk[i2] > 1)
                            {
                                xk[i2]--;
                            } else
                            {
                                Oi--;
                                ih = 0;
                                for(int l5 = i2; l5 < Oi; l5++)
                                {
                                    wk[l5] = wk[l5 + 1];
                                    xk[l5] = xk[l5 + 1];
                                }

                                break;
                            }
                            j3++;
                        } while(true);
                        super.nb.a(116);
                        super.nb.f(Oi);
                        for(int k3 = 0; k3 < Oi; k3++)
                        {
                            super.nb.e(wk[k3]);
                            super.nb.b(xk[k3]);
                        }

                        super.nb.i();
                        ue = false;
                        ve = false;
                    }
                }
                if(j1 >= 217 && k1 >= 238 && j1 <= 286 && k1 <= 259)
                {
                    ve = true;
                    super.nb.a(38);
                    System.out.println(Dk[449]);
                    super.nb.i();
                }
                if(j1 >= 394 && k1 >= 238 && j1 < 463 && k1 < 259)
                {
                    le = false;
                    super.nb.a(178);
                    System.out.println(Dk[316]);
                    super.nb.i();
                }
            } else
            if(hh != 0)
            {
                le = false;
                super.nb.a(178);
                System.out.println(Dk[316]);
                super.nb.i();
            }
            hh = 0;
            jh = 0;
        }
        if(!le)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        Xe.b(byte0, byte1, 468, 12, 192);
        int j2 = 0x989898;
        Xe.a(byte0, byte1 + 12, 468, 18, j2, 160);
        Xe.a(byte0, byte1 + 30, 8, 248, j2, 160);
        Xe.a(byte0 + 205, byte1 + 30, 11, 248, j2, 160);
        Xe.a(byte0 + 462, byte1 + 30, 6, 248, j2, 160);
        Xe.a(byte0 + 8, byte1 + 133, 197, 22, j2, 160);
        Xe.a(byte0 + 8, byte1 + 258, 197, 20, j2, 160);
        Xe.a(byte0 + 216, byte1 + 235, 246, 43, j2, 160);
        int l2 = 0xd0d0d0;
        Xe.a(byte0 + 8, byte1 + 30, 197, 103, l2, 160);
        Xe.a(byte0 + 8, byte1 + 155, 197, 103, l2, 160);
        Xe.a(byte0 + 216, byte1 + 30, 246, 205, l2, 160);
        for(int l3 = 0; l3 < 4; l3++)
            Xe.b(byte0 + 8, byte1 + 30 + l3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            Xe.b(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int j4 = 0; j4 < 7; j4++)
            Xe.b(byte0 + 216, byte1 + 30 + j4 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                Xe.c(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
            if(k4 < 5)
                Xe.c(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
            Xe.c(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        Xe.c(Dk[527] + df, byte0 + 1, byte1 + 10, 1, 0xffffff);
        Xe.c(Dk[526], byte0 + 9, byte1 + 27, 4, 0xffffff);
        Xe.c(Dk[525], byte0 + 9, byte1 + 152, 4, 0xffffff);
        Xe.c(Dk[284], byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!ve)
            Xe.c(byte0 + 217, byte1 + 238, Ei + 25);
        Xe.c(byte0 + 394, byte1 + 238, Ei + 26);
        if(ue)
        {
            Xe.b(Dk[296], byte0 + 341, byte1 + 246, 1, 0xffffff);
            Xe.b(Dk[295], byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(ve)
        {
            Xe.b(Dk[294], byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            Xe.b(Dk[285], byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < pg; l4++)
        {
            int i6 = 217 + byte0 + (l4 % 5) * 49;
            int j7 = 31 + byte1 + (l4 / 5) * 34;
            Xe.a(i6, j7, 48, 32, Gi + f.jb[lj[l4]], f.ob[lj[l4]], 0, 0, false);
            if(f.lb[lj[l4]] == 0)
                Xe.c(String.valueOf(mj[l4]), i6 + 1, j7 + 10, 1, 0xffff00);
        }

        for(int i5 = 0; i5 < Oi; i5++)
        {
            int j6 = 9 + byte0 + (i5 % 4) * 49;
            int k7 = 31 + byte1 + (i5 / 4) * 34;
            Xe.a(j6, k7, 48, 32, Gi + f.jb[wk[i5]], f.ob[wk[i5]], 0, 0, false);
            if(f.lb[wk[i5]] == 0)
                Xe.c(String.valueOf(xk[i5]), j6 + 1, k7 + 10, 1, 0xffff00);
            if(super.S > j6 && super.S < j6 + 48 && super.T > k7 && super.T < k7 + 32)
                Xe.c(f.d[wk[i5]] + Dk[529] + f.e[wk[i5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < Uh; j5++)
        {
            int k6 = 9 + byte0 + (j5 % 4) * 49;
            int l7 = 156 + byte1 + (j5 / 4) * 34;
            Xe.a(k6, l7, 48, 32, Gi + f.jb[ck[j5]], f.ob[ck[j5]], 0, 0, false);
            if(f.lb[ck[j5]] == 0)
                Xe.c(String.valueOf(dk[j5]), k6 + 1, l7 + 10, 1, 0xffff00);
            if(super.S > k6 && super.S < k6 + 48 && super.T > l7 && super.T < l7 + 32)
                Xe.c(f.d[ck[j5]] + Dk[529] + f.e[ck[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void X()
    {
        int i1 = f.J;
        Se = new t(Xe, 50);
        int j1 = 40;
        if(!re)
        {
            Se.a(256, 190 + j1, Dk[732], 5, true);
            Se.a(256, 207 + j1, Dk[728], 4, true);
            Se.a(256, 280 + j1, Dk[733], 4, true);
            Se.d(156, 240 + j1, 120, 35);
            Se.d(356, 240 + j1, 120, 35);
            Se.a(156, 240 + j1, Dk[725], 5, false);
            Se.a(356, 240 + j1, Dk[727], 5, false);
            zh = Se.f(156, 240 + j1, 120, 35);
            Ah = Se.f(356, 240 + j1, 120, 35);
        } else
        {
            Se.a(256, 200 + j1, Dk[6], 4, true);
            Se.a(256, 215 + j1, Dk[729], 4, true);
            Se.d(256, 290, 180, 35);
            Se.a(256, 290, Dk[735], 4, false);
            Ah = Se.f(256, 250 + j1, 200, 35);
        }
        Me = new t(Xe, 50);
        j1 = 230;
        if(ug == 0)
        {
            Me.a(256, j1 + 8, Dk[736], 4, true);
            j1 += 20;
            Me.a(256, j1 + 8, Dk[738], 4, true);
        }
        j1 += 20;
        Me.a(256, j1 + 8, Dk[730], 4, true);
        j1 += 30;
        Me.d(256, j1 + 17, 150, 34);
        Me.a(256, j1 + 17, Dk[731], 5, false);
        wg = Me.f(256, j1 + 17, 150, 34);
        Ne = new t(Xe, 50);
        j1 = 230;
        Fh = Ne.a(256, j1 - 10, Dk[706], 4, true);
        j1 += 28;
        Ne.d(140, j1, 200, 40);
        Ne.a(140, j1 - 10, Dk[737], 4, false);
        Gh = Ne.b(140, j1 + 10, 200, 40, 4, 12, false, false);
        j1 += 47;
        Ne.d(190, j1, 200, 40);
        Ne.a(190, j1 - 10, Dk[726], 4, false);
        Hh = Ne.b(190, j1 + 10, 200, 40, 4, 20, true, false);
        j1 -= 55;
        Ne.d(410, j1, 120, 25);
        Ne.a(410, j1, Dk[731], 4, false);
        Ih = Ne.f(410, j1, 120, 25);
        j1 += 30;
        Ne.d(410, j1, 120, 25);
        Ne.a(410, j1, Dk[160], 4, false);
        Jh = Ne.f(410, j1, 120, 25);
        j1 += 30;
        Ne.d(410, 310, 120, 25);
        Ne.a(390, 310, Dk[734], 4, false);
        Tb = Ne.b(430, 310, 120, 25, 4, 2, false, false);
        Ne.h(Gh);
    }

    public void c(boolean flag)
    {
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 199;
        int k1 = 36;
        Xe.c(j1 - 49, 3, Ei + 4);
        char c1 = '\304';
        char c2 = '\266';
        int l1;
        int i2 = l1 = v.b(160, 160, 160);
        if(ah == 0)
            i2 = v.b(220, 220, 220);
        else
            l1 = v.b(220, 220, 220);
        Xe.a(j1, k1, c1 / 2, 24, i2, 128);
        Xe.a(j1 + c1 / 2, k1, c1 / 2, 24, l1, 128);
        Xe.a(j1, k1 + 24, c1, 90, v.b(190, 190, 190), 128);
        Xe.a(j1, k1 + 24 + 90, c1, c2 - 90 - 24, v.b(100, 100, 100), 128);
        Xe.b(j1, k1 + 24, c1, 0);
        Xe.c(j1 + c1 / 2, k1, 24, 0);
        Xe.b(j1, k1 + 113, c1, 0);
        Xe.b(Dk[106], j1 + c1 / 4, k1 + 16, 4, 0);
        Xe.b(Dk[215], j1 + c1 / 4 + c1 / 2, k1 + 16, 4, 0);
        if(ah == 0)
        {
            Pe.c(Zg);
            int j2 = 0;
            for(int j3 = 0; j3 < f.C; j3++)
            {
                String s1 = Dk[221];
                int j5 = 0;
                do
                {
                    if(j5 >= f.Jb[j3])
                        break;
                    int i6 = f.Nb[j3][j5];
                    if(!m(i6, f.Lb[j3][j5]))
                    {
                        s1 = Dk[222];
                        break;
                    }
                    j5++;
                } while(true);
                j5 = sj[6];
                if(f.Ib[j3] > j5)
                    s1 = Dk[208];
                Pe.a(Zg, j2++, s1 + Dk[210] + f.Ib[j3] + Dk[216] + f.h[j3]);
            }

            Pe.a();
            int k3 = Pe.i(Zg);
            if(k3 != -1)
            {
                Xe.c(Dk[210] + f.Ib[k3] + Dk[216] + f.h[k3], j1 + 2, k1 + 124, 1, 0xffff00);
                Xe.c(f.i[k3], j1 + 2, k1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < f.Jb[k3]; l4++)
                {
                    int k5 = f.Nb[k3][l4];
                    Xe.c(j1 + 2 + l4 * 44, k1 + 150, Gi + f.jb[k5]);
                    int j6 = db(k5);
                    int k6 = f.Lb[k3][l4];
                    String s3 = Dk[220];
                    if(m(k5, k6))
                        s3 = Dk[211];
                    Xe.c(s3 + j6 + "/" + k6, j1 + 2 + l4 * 44, k1 + 150, 1, 0xffffff);
                }

            } else
            {
                Xe.c(Dk[219], j1 + 2, k1 + 124, 1, 0);
            }
        }
        if(ah == 1)
        {
            Pe.c(Zg);
            int k2 = 0;
            for(int l3 = 0; l3 < f.P; l3++)
            {
                String s2 = Dk[222];
                if(f.Gb[l3] > Uj[5])
                    s2 = Dk[208];
                if(ze[l3])
                    s2 = Dk[211];
                Pe.a(Zg, k2++, s2 + Dk[210] + f.Gb[l3] + Dk[216] + f.n[l3]);
            }

            Pe.a();
            int i4 = Pe.i(Zg);
            if(i4 != -1)
            {
                Xe.b(Dk[210] + f.Gb[i4] + Dk[216] + f.n[i4], j1 + c1 / 2, k1 + 130, 1, 0xffff00);
                Xe.b(f.o[i4], j1 + c1 / 2, k1 + 145, 0, 0xffffff);
                Xe.b(Dk[209] + f.Hb[i4], j1 + c1 / 2, k1 + 160, 1, 0);
            } else
            {
                Xe.c(Dk[218], j1 + 2, k1 + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 199);
        k1 = super.T - 36;
        if(j1 >= 0 && k1 >= 0 && j1 < 196 && k1 < 182)
        {
            Pe.a(j1 + (((v) (Xe)).m - 199), k1 + 36, super.V, super.U);
            if(k1 <= 24 && hh == 1)
                if(j1 < 98 && ah == 1)
                {
                    ah = 0;
                    Pe.d(Zg);
                } else
                if(j1 > 98 && ah == 0)
                {
                    ah = 1;
                    Pe.d(Zg);
                }
            if(hh == 1 && ah == 0)
            {
                int l2 = Pe.i(Zg);
                if(l2 != -1)
                {
                    int j4 = sj[6];
                    if(f.Ib[l2] > j4)
                    {
                        a(Dk[214], 3);
                    } else
                    {
                        int i5 = 0;
                        do
                        {
                            if(i5 >= f.Jb[l2])
                                break;
                            int l5 = f.Nb[l2][i5];
                            if(!m(l5, f.Lb[l2][i5]))
                            {
                                a(Dk[212], 3);
                                i5 = -1;
                                break;
                            }
                            i5++;
                        } while(true);
                        if(i5 == f.Jb[l2])
                        {
                            fh = l2;
                            Ig = -1;
                        }
                    }
                }
            }
            if(hh == 1 && ah == 1)
            {
                int i3 = Pe.i(Zg);
                if(i3 != -1)
                {
                    int k4 = Uj[5];
                    if(f.Gb[i3] > k4)
                        a(Dk[217], 3);
                    else
                    if(sj[5] == 0)
                        a(Dk[213], 3);
                    else
                    if(ze[i3])
                    {
                        super.nb.a(164);
                        super.nb.f(i3);
                        super.nb.i();
                        ze[i3] = false;
                        k(Dk[51]);
                    } else
                    {
                        super.nb.a(17);
                        super.nb.f(i3);
                        super.nb.i();
                        ze[i3] = true;
                        k(Dk[60]);
                    }
                }
            }
            hh = 0;
        }
    }

    public void a(int i1, int j1, int k1, int l1, boolean flag)
    {
        if(b(i1, j1, k1, l1, k1, l1, false, flag))
        {
            return;
        } else
        {
            a(i1, j1, k1, l1, k1, l1, true, flag);
            return;
        }
    }

    public void d(boolean flag)
    {
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 248;
        Xe.c(j1, 3, Ei + 1);
        for(int k1 = 0; k1 < og; k1++)
        {
            int k2 = j1 + (k1 % 5) * 49;
            int i3 = 36 + (k1 / 5) * 34;
            if(k1 < pg && nj[k1] == 1)
                Xe.a(k2, i3, 49, 34, 0xff0000, 128);
            else
                Xe.a(k2, i3, 49, 34, v.b(181, 181, 181), 128);
            if(k1 >= pg)
                continue;
            Xe.a(k2, i3, 48, 32, Gi + f.jb[lj[k1]], f.ob[lj[k1]], 0, 0, false);
            if(f.lb[lj[k1]] == 0)
                Xe.c(String.valueOf(mj[k1]), k2 + 1, i3 + 10, 1, 0xffff00);
        }

        for(int l1 = 1; l1 <= 4; l1++)
            Xe.c(j1 + l1 * 49, 36, (og / 5) * 34, 0);

        for(int i2 = 1; i2 <= og / 5 - 1; i2++)
            Xe.b(j1, 36 + i2 * 34, 245, 0);

        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 248);
        int j2 = super.T - 36;
        if(j1 >= 0 && j2 >= 0 && j1 < 248 && j2 < (og / 5) * 34)
        {
            int l2 = j1 / 49 + (j2 / 34) * 5;
            if(l2 < pg)
            {
                int j3 = lj[l2];
                if(fh >= 0)
                {
                    if(f.Kb[fh] == 3)
                    {
                        zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                        sf[Hg] = Dk[267] + f.d[j3];
                        ak[Hg] = 600;
                        Oj[Hg] = l2;
                        Pj[Hg] = fh;
                        Hg++;
                        return;
                    }
                } else
                {
                    if(Ig >= 0)
                    {
                        zf[Hg] = Dk[261] + Ig + Dk[264];
                        sf[Hg] = Dk[267] + f.d[j3];
                        ak[Hg] = 610;
                        Oj[Hg] = l2;
                        Pj[Hg] = Ig;
                        Hg++;
                        return;
                    }
                    if(nj[l2] == 1)
                    {
                        zf[Hg] = Dk[577];
                        sf[Hg] = Dk[267] + f.d[j3];
                        ak[Hg] = 620;
                        Oj[Hg] = l2;
                        Hg++;
                    } else
                    if(f.nb[j3] != 0)
                    {
                        if((f.nb[j3] & 0x18) != 0)
                            zf[Hg] = Dk[463];
                        else
                            zf[Hg] = Dk[576];
                        sf[Hg] = Dk[267] + f.d[j3];
                        ak[Hg] = 630;
                        Oj[Hg] = l2;
                        Hg++;
                    }
                    if(!f.f[j3].equals(""))
                    {
                        zf[Hg] = f.f[j3];
                        sf[Hg] = Dk[267] + f.d[j3];
                        ak[Hg] = 640;
                        Oj[Hg] = l2;
                        Hg++;
                    }
                    zf[Hg] = Dk[575];
                    sf[Hg] = Dk[267] + f.d[j3];
                    ak[Hg] = 650;
                    Oj[Hg] = l2;
                    Hg++;
                    zf[Hg] = Dk[574];
                    sf[Hg] = Dk[267] + f.d[j3];
                    ak[Hg] = 660;
                    Oj[Hg] = l2;
                    Hg++;
                    zf[Hg] = Dk[269];
                    sf[Hg] = Dk[267] + f.d[j3];
                    ak[Hg] = 3600;
                    Oj[Hg] = j3;
                    Hg++;
                }
            }
        }
    }

    public void Y()
    {
        if(qf)
        {
            j(pf);
            qf = false;
        }
        if(super.Gb > 0)
            super.Gb--;
        if(Zf == 0)
        {
            Se.a(super.S, super.T, super.V, super.U);
            if(Se.a(zh))
                Zf = 1;
            if(Se.a(Ah))
            {
                Zf = 2;
                Ne.a(Fh, Dk[706]);
                Ne.a(Gh, "");
                Ne.a(Tb, "");
                Ne.a(Hh, "");
                Ne.h(Gh);
                return;
            }
        } else
        if(Zf == 1)
        {
            Me.a(super.S, super.T, super.V, super.U);
            if(Me.a(wg))
            {
                Zf = 0;
                return;
            }
        } else
        if(Zf == 2)
        {
            Ne.a(super.S, super.T, super.V, super.U);
            if(Ne.a(Jh))
                Zf = 0;
            if(Ne.a(Gh))
                Ne.h(Hh);
            if(Ne.a(Hh))
                Ne.h(Tb);
            if(Ne.a(Tb) || Ne.a(Ih))
            {
                ef = Ne.e(Gh);
                Xb = Ne.e(Gh);
                ff = Ne.e(Hh);
                Yb = Ne.e(Hh);
                Vb = Ne.e(Tb);
                if(Vb.equals(Dk[709]) || Vb.equals(Dk[705]) || Vb.equals(Dk[704]) || Vb.equals(Dk[708]) || Vb.equals(Dk[711]) || Vb.equals(Dk[710]))
                {
                    E(Integer.parseInt(Vb));
                    A();
                } else
                {
                    b(Dk[707], "");
                }
            }
        }
    }

    public int db(int i1)
    {
        int j1 = f.J;
        int k1 = 0;
        for(int l1 = 0; l1 < pg; l1++)
        {
            if(lj[l1] != i1)
                continue;
            if(f.lb[i1] == 1)
                k1++;
            else
                k1 += mj[l1];
        }

        return k1;
    }

    public void Z()
    {
        Re = new t(Xe, 100);
        Re.a(256, 10, Dk[766], 4, true);
        int i1 = 140;
        int j1 = 34;
        i1 += 116;
        j1 -= 10;
        Re.a(i1 - 55, j1 + 110, Dk[759], 3, true);
        Re.a(i1, j1 + 110, Dk[757], 3, true);
        Re.a(i1 + 55, j1 + 110, Dk[765], 3, true);
        byte byte0 = 54;
        j1 += 145;
        Re.e(i1 - byte0, j1, 53, 41);
        Re.a(i1 - byte0, j1 - 8, Dk[762], 1, true);
        Re.a(i1 - byte0, j1 + 8, Dk[758], 1, true);
        Re.d(i1 - byte0 - 40, j1, t.E + 7);
        bg = Re.f(i1 - byte0 - 40, j1, 20, 20);
        Re.d((i1 - byte0) + 40, j1, t.E + 6);
        cg = Re.f((i1 - byte0) + 40, j1, 20, 20);
        Re.e(i1 + byte0, j1, 53, 41);
        Re.a(i1 + byte0, j1 - 8, Dk[760], 1, true);
        Re.a(i1 + byte0, j1 + 8, Dk[767], 1, true);
        Re.d((i1 + byte0) - 40, j1, t.E + 7);
        dg = Re.f((i1 + byte0) - 40, j1, 20, 20);
        Re.d(i1 + byte0 + 40, j1, t.E + 6);
        eg = Re.f(i1 + byte0 + 40, j1, 20, 20);
        j1 += 50;
        Re.e(i1 - byte0, j1, 53, 41);
        Re.a(i1 - byte0, j1, Dk[763], 1, true);
        Re.d(i1 - byte0 - 40, j1, t.E + 7);
        fg = Re.f(i1 - byte0 - 40, j1, 20, 20);
        Re.d((i1 - byte0) + 40, j1, t.E + 6);
        gg = Re.f((i1 - byte0) + 40, j1, 20, 20);
        Re.e(i1 + byte0, j1, 53, 41);
        Re.a(i1 + byte0, j1 - 8, Dk[761], 1, true);
        Re.a(i1 + byte0, j1 + 8, Dk[767], 1, true);
        Re.d((i1 + byte0) - 40, j1, t.E + 7);
        hg = Re.f((i1 + byte0) - 40, j1, 20, 20);
        Re.d(i1 + byte0 + 40, j1, t.E + 6);
        ig = Re.f(i1 + byte0 + 40, j1, 20, 20);
        j1 += 50;
        Re.e(i1 - byte0, j1, 53, 41);
        Re.a(i1 - byte0, j1 - 8, Dk[768], 1, true);
        Re.a(i1 - byte0, j1 + 8, Dk[767], 1, true);
        Re.d(i1 - byte0 - 40, j1, t.E + 7);
        jg = Re.f(i1 - byte0 - 40, j1, 20, 20);
        Re.d((i1 - byte0) + 40, j1, t.E + 6);
        kg = Re.f((i1 - byte0) + 40, j1, 20, 20);
        Re.e(i1 + byte0, j1, 53, 41);
        Re.a(i1 + byte0, j1 - 8, Dk[769], 1, true);
        Re.a(i1 + byte0, j1 + 8, Dk[767], 1, true);
        Re.d((i1 + byte0) - 40, j1, t.E + 7);
        lg = Re.f((i1 + byte0) - 40, j1, 20, 20);
        Re.d(i1 + byte0 + 40, j1, t.E + 6);
        mg = Re.f(i1 + byte0 + 40, j1, 20, 20);
        j1 += 82;
        j1 -= 35;
        Re.d(i1, j1, 200, 30);
        Re.a(i1, j1, Dk[764], 4, false);
        ng = Re.f(i1, j1, 200, 30);
    }

    public void e(boolean flag)
    {
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 199;
        int k1 = 36;
        Xe.c(j1 - 49, 3, Ei + 6);
        char c1 = '\304';
        Xe.a(j1, 36, c1, 65, v.b(100, 100, 100), 160);
        Xe.a(j1, 101, c1, 65, v.b(100, 100, 100), 160);
        Xe.a(j1, 166, c1, 95, v.b(100, 100, 100), 160);
        Xe.a(j1, 261, c1, 40, v.b(100, 100, 100), 160);
        int l1 = j1 + 3;
        int i2 = k1 + 15;
        Xe.c(Dk[182], l1, i2, 1, 0);
        i2 += 15;
        int j2 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            j2 = 0xff0000;
        if(lc)
            Xe.c(Dk[166], l1, i2, 1, j2);
        else
            Xe.c(Dk[195], l1, i2, 1, j2);
        i2 += 15;
        int k2 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            k2 = 0xff0000;
        if(Ld)
            Xe.c(Dk[164], l1, i2, 1, k2);
        else
            Xe.c(Dk[199], l1, i2, 1, k2);
        i2 += 15;
        int l2 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            l2 = 0xff0000;
        if(Vc)
            Xe.c(Dk[200], l1, i2, 1, l2);
        else
            Xe.c(Dk[184], l1, i2, 1, l2);
        i2 += 15;
        int i3 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            i3 = 0xff0000;
        if(Wc)
            Xe.c(Dk[197], l1, i2, 1, i3);
        else
            Xe.c(Dk[173], l1, i2, 1, i3);
        i2 += 5;
        Xe.c("", l1, i2, 0, 0xffffff);
        i2 += 15;
        Xe.c(Dk[196], l1, i2, 1, 0xffffff);
        i2 += 15;
        int j3 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            j3 = 0xff0000;
        Xe.c(Dk[172], l1, i2, 1, j3);
        i2 += 15;
        int k3 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            k3 = 0xff0000;
        Xe.c(Dk[176], l1, i2, 1, k3);
        i2 += 15;
        int l3 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            l3 = 0xff0000;
        Xe.c(Dk[183], l1, i2, 1, l3);
        Xe.c("", j1 + 3, i2, 1, 0);
        i2 += 15;
        Xe.c(Dk[191], j1 + 3, i2, 1, 0);
        i2 += 15;
        int i4 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            i4 = 0xff0000;
        if(super.Cb == 0)
            Xe.c(Dk[193], j1 + 3, i2, 1, i4);
        else
            Xe.c(Dk[169], j1 + 3, i2, 1, i4);
        i2 += 15;
        int j4 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            j4 = 0xff0000;
        if(super.Db == 0)
            Xe.c(Dk[165], j1 + 3, i2, 1, j4);
        else
            Xe.c(Dk[180], j1 + 3, i2, 1, j4);
        i2 += 15;
        int k4 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            k4 = 0xff0000;
        if(super.Eb == 0)
            Xe.c(Dk[192], j1 + 3, i2, 1, k4);
        else
            Xe.c(Dk[167], j1 + 3, i2, 1, k4);
        i2 += 15;
        int l4 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            l4 = 0xff0000;
        if(super.Fb == 0)
            Xe.c(Dk[175], j1 + 3, i2, 1, l4);
        else
            Xe.c(Dk[178], j1 + 3, i2, 1, l4);
        i2 += 15;
        i2 += 15;
        Xe.c(Dk[174], l1, i2, 1, 0);
        i2 += 15;
        int i5 = 0xffffff;
        if(super.S > l1 && super.S < l1 + c1 && super.T > i2 - 12 && super.T < i2 + 4)
            i5 = 0xff0000;
        Xe.c(Dk[190], j1 + 3, i2, 1, i5);
        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 199);
        k1 = super.T - 36;
        if(j1 >= 0 && k1 >= 0 && j1 < 196 && k1 < 265)
        {
            int j5 = ((v) (Xe)).m - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k5 = j5 + 3;
            int l5 = byte0 + 30;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                lc = !lc;
                if(lc)
                    d(Dk[189]);
                else
                    d(Dk[188]);
                super.nb.a(66);
                super.nb.f(0);
                super.nb.f(Sd ? 1 : 0);
                super.nb.i();
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                Ld = !Ld;
                if(Ld)
                    d(Dk[186]);
                else
                    d(Dk[198]);
                super.nb.a(66);
                super.nb.f(2);
                super.nb.f(ce ? 1 : 0);
                super.nb.i();
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                Vc = !Vc;
                if(Vc)
                    d(Dk[185]);
                else
                    d(Dk[168]);
                super.nb.a(66);
                super.nb.f(3);
                super.nb.f(je ? 1 : 0);
                super.nb.i();
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                Wc = !Wc;
                if(Wc)
                    d(Dk[170]);
                else
                    d(Dk[187]);
            }
            l5 += 15;
            l5 += 15;
            l5 += 5;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                tg = 128;
                Xf = 700;
                Cf = 912;
                d(Dk[177]);
                ab.a(Dk[171]);
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                d(Dk[179]);
                super.Cb = 0;
                super.Db = 0;
                super.Eb = 0;
                super.Fb = 0;
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                d(Dk[194]);
                ab.a(Dk[181]);
            }
            boolean flag1 = false;
            l5 += 25;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                super.Cb = 1 - super.Cb;
                flag1 = true;
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                super.Db = 1 - super.Db;
                flag1 = true;
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                super.Eb = 1 - super.Eb;
                flag1 = true;
            }
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
            {
                super.Fb = 1 - super.Fb;
                flag1 = true;
            }
            l5 += 15;
            if(flag1)
                a(super.Cb, super.Db, super.Eb, super.Fb);
            l5 += 15;
            l5 += 15;
            if(super.S > k5 && super.S < k5 + c2 && super.T > l5 - 12 && super.T < l5 + 4 && hh == 1)
                hb();
            hh = 0;
        }
    }

    public void ab()
    {
        Xe.b = false;
        Xe.c();
        Re.a();
        int i1 = 140;
        int j1 = 50;
        i1 += 116;
        j1 -= 25;
        Xe.e(i1 - 32 - 55, j1, 64, 102, f.Fb[Nh], Wj[Qh]);
        Xe.a(i1 - 32 - 55, j1, 64, 102, f.Fb[Mh], Wj[Ph], Vj[Rh], 0, false);
        Xe.a(i1 - 32 - 55, j1, 64, 102, f.Fb[Lh], bk[Oh], Vj[Rh], 0, false);
        Xe.e(i1 - 32, j1, 64, 102, f.Fb[Nh] + 6, Wj[Qh]);
        Xe.a(i1 - 32, j1, 64, 102, f.Fb[Mh] + 6, Wj[Ph], Vj[Rh], 0, false);
        Xe.a(i1 - 32, j1, 64, 102, f.Fb[Lh] + 6, bk[Oh], Vj[Rh], 0, false);
        Xe.e((i1 - 32) + 55, j1, 64, 102, f.Fb[Nh] + 12, Wj[Qh]);
        Xe.a((i1 - 32) + 55, j1, 64, 102, f.Fb[Mh] + 12, Wj[Ph], Vj[Rh], 0, false);
        Xe.a((i1 - 32) + 55, j1, 64, 102, f.Fb[Lh] + 12, bk[Oh], Vj[Rh], 0, false);
        Xe.c(0, Vf, Ei + 22);
        Xe.a(Ye, 0, 0);
    }

    public void bb()
    {
        int i1 = f.J;
        int j1 = 2203 - (Si + ch + Rg);
        if(Ri + bh + Qg >= 2640)
            j1 = -50;
        int k1 = -1;
        for(int l1 = 0; l1 < Yg; l1++)
            ye[l1] = false;

        for(int i2 = 0; i2 < Bh; i2++)
            Be[i2] = false;

        int j2 = De.c();
        u au[] = De.e();
        int ai1[] = De.d();
        for(int k2 = 0; k2 < j2 && Hg <= 200; k2++)
        {
            int i3 = ai1[k2];
            u u1 = au[k2];
            if(u1.pb[i3] > 65535 && (u1.pb[i3] < 0x30d40 || u1.pb[i3] > 0x493e0))
                continue;
            if(u1 == De.i)
            {
                int j3 = u1.pb[i3] % 10000;
                int i4 = u1.pb[i3] / 10000;
                if(i4 == 1)
                {
                    String s1 = "";
                    int l4 = 0;
                    if(Le.v > 0 && Ke[j3].v > 0)
                        l4 = Le.v - Ke[j3].v;
                    if(l4 < 0)
                        s1 = Dk[258];
                    if(l4 < -3)
                        s1 = Dk[277];
                    if(l4 < -6)
                        s1 = Dk[259];
                    if(l4 < -9)
                        s1 = Dk[220];
                    if(l4 > 0)
                        s1 = Dk[270];
                    if(l4 > 3)
                        s1 = Dk[256];
                    if(l4 > 6)
                        s1 = Dk[272];
                    if(l4 > 9)
                        s1 = Dk[211];
                    s1 = " " + s1 + Dk[273] + Ke[j3].v + ")";
                    if(fh >= 0)
                    {
                        if(f.Kb[fh] == 1 || f.Kb[fh] == 2)
                        {
                            zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                            sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                            ak[Hg] = 800;
                            jk[Hg] = Ke[j3].g;
                            kk[Hg] = Ke[j3].h;
                            Oj[Hg] = Ke[j3].e;
                            Pj[Hg] = fh;
                            Hg++;
                        }
                        continue;
                    }
                    if(Ig >= 0)
                    {
                        zf[Hg] = Dk[261] + Ig + Dk[264];
                        sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                        ak[Hg] = 810;
                        jk[Hg] = Ke[j3].g;
                        kk[Hg] = Ke[j3].h;
                        Oj[Hg] = Ke[j3].e;
                        Pj[Hg] = Ig;
                        Hg++;
                        continue;
                    }
                    if(j1 > 0 && (Ke[j3].h - 64) / Ci + ch + Rg < 2203)
                    {
                        zf[Hg] = Dk[125];
                        sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                        if(!lc)
                        {
                            if(l4 >= 0 && l4 < 5)
                                ak[Hg] = 805;
                            else
                                ak[Hg] = 2805;
                        } else
                        if(lc)
                            if(l4 >= 0 && l4 < 5)
                                ak[Hg] = 805;
                            else
                                ak[Hg] = 805;
                        jk[Hg] = Ke[j3].g;
                        kk[Hg] = Ke[j3].h;
                        Oj[Hg] = Ke[j3].e;
                        Hg++;
                    } else
                    if(re)
                    {
                        zf[Hg] = Dk[274];
                        sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                        jk[Hg] = Ke[j3].g;
                        kk[Hg] = Ke[j3].h;
                        ak[Hg] = 2806;
                        Oj[Hg] = Ke[j3].e;
                        Hg++;
                    }
                    zf[Hg] = Dk[268];
                    sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                    ak[Hg] = 2810;
                    Oj[Hg] = Ke[j3].e;
                    Hg++;
                    zf[Hg] = Dk[255];
                    sf[Hg] = Dk[222] + Ke[j3].c + "[" + j3 + "]" + s1;
                    ak[Hg] = 2820;
                    Oj[Hg] = Ke[j3].e;
                    Hg++;
                    zf[Hg] = Dk[275];
                    sf[Hg] = Dk[222] + Ke[j3].c + s1;
                    ak[Hg] = 9999;
                    Oj[Hg] = Ke[j3].e;
                    Hg++;
                    continue;
                }
                if(i4 == 2)
                {
                    if(fh >= 0)
                    {
                        if(f.Kb[fh] == 3)
                        {
                            zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                            sf[Hg] = Dk[267] + f.d[Jj[j3]];
                            ak[Hg] = 200;
                            jk[Hg] = Hj[j3];
                            kk[Hg] = Ij[j3];
                            Oj[Hg] = Jj[j3];
                            Pj[Hg] = fh;
                            Hg++;
                        }
                        continue;
                    }
                    if(Ig >= 0)
                    {
                        zf[Hg] = Dk[261] + Ig + Dk[264];
                        sf[Hg] = Dk[267] + f.d[Jj[j3]] + "[" + j3 + "]";
                        ak[Hg] = 210;
                        jk[Hg] = Hj[j3];
                        kk[Hg] = Ij[j3];
                        Oj[Hg] = Jj[j3];
                        Pj[Hg] = Ig;
                        Hg++;
                    } else
                    {
                        zf[Hg] = Dk[279];
                        sf[Hg] = Dk[267] + f.d[Jj[j3]] + "[" + j3 + "]";
                        ak[Hg] = 220;
                        jk[Hg] = Hj[j3];
                        kk[Hg] = Ij[j3];
                        Oj[Hg] = Jj[j3];
                        Hg++;
                        zf[Hg] = Dk[269];
                        sf[Hg] = Dk[267] + f.d[Jj[j3]] + "[" + j3 + "]";
                        ak[Hg] = 3200;
                        Oj[Hg] = Jj[j3];
                        Hg++;
                    }
                    continue;
                }
                if(i4 != 3)
                    continue;
                String s2 = "";
                int i5 = -1;
                int j5 = Fe[j3].i;
                if(f.Z[j5] > 0)
                {
                    int k5 = (f.V[j5] + f.Y[j5] + f.W[j5] + f.X[j5]) / 4;
                    int l5 = (Uj[0] + Uj[1] + Uj[2] + Uj[3] + 27) / 4;
                    i5 = l5 - k5;
                    s2 = Dk[221];
                    if(i5 < 0)
                        s2 = Dk[258];
                    if(i5 < -3)
                        s2 = Dk[277];
                    if(i5 < -6)
                        s2 = Dk[259];
                    if(i5 < -9)
                        s2 = Dk[220];
                    if(i5 > 0)
                        s2 = Dk[270];
                    if(i5 > 3)
                        s2 = Dk[256];
                    if(i5 > 6)
                        s2 = Dk[272];
                    if(i5 > 9)
                        s2 = Dk[211];
                    s2 = " " + s2 + Dk[273] + k5 + ")";
                }
                if(fh >= 0)
                {
                    if(f.Kb[fh] == 2)
                    {
                        zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                        sf[Hg] = Dk[221] + f.k[Fe[j3].i];
                        ak[Hg] = 700;
                        jk[Hg] = Fe[j3].g;
                        kk[Hg] = Fe[j3].h;
                        Oj[Hg] = Fe[j3].e;
                        Pj[Hg] = fh;
                        Hg++;
                    }
                    continue;
                }
                if(Ig >= 0)
                {
                    zf[Hg] = Dk[261] + Ig + Dk[264];
                    sf[Hg] = Dk[221] + f.k[Fe[j3].i];
                    ak[Hg] = 710;
                    jk[Hg] = Fe[j3].g;
                    kk[Hg] = Fe[j3].h;
                    Oj[Hg] = Fe[j3].e;
                    Pj[Hg] = Ig;
                    Hg++;
                    continue;
                }
                if(f.Z[j5] > 0)
                {
                    zf[Hg] = Dk[125];
                    sf[Hg] = Dk[221] + f.k[Fe[j3].i] + s2 + Dk[278] + Fe[j3].i + "]";
                    if(!lc)
                    {
                        if(i5 >= 0)
                            ak[Hg] = 715;
                        else
                            ak[Hg] = 2715;
                    } else
                    if(lc)
                        if(i5 >= 0)
                            ak[Hg] = 715;
                        else
                            ak[Hg] = 715;
                    jk[Hg] = Fe[j3].g;
                    kk[Hg] = Fe[j3].h;
                    Oj[Hg] = Fe[j3].e;
                    Hg++;
                }
                zf[Hg] = Dk[265];
                sf[Hg] = Dk[221] + f.k[Fe[j3].i] + Dk[278] + Fe[j3].i + "]";
                ak[Hg] = 720;
                jk[Hg] = Fe[j3].g;
                kk[Hg] = Fe[j3].h;
                Oj[Hg] = Fe[j3].e;
                Hg++;
                if(!f.m[j5].equals(""))
                {
                    zf[Hg] = f.m[j5];
                    sf[Hg] = Dk[221] + f.k[Fe[j3].i];
                    ak[Hg] = 725;
                    jk[Hg] = Fe[j3].g;
                    kk[Hg] = Fe[j3].h;
                    Oj[Hg] = Fe[j3].e;
                    Hg++;
                }
                zf[Hg] = Dk[269];
                sf[Hg] = Dk[221] + f.k[Fe[j3].i] + Dk[278] + Fe[j3].i + "]";
                ak[Hg] = 3700;
                Oj[Hg] = Fe[j3].i;
                Hg++;
                zf[Hg] = Dk[275];
                sf[Hg] = Dk[221] + f.k[Fe[j3].i] + Dk[278] + Fe[j3].i + "]";
                ak[Hg] = 4300;
                Oj[Hg] = Fe[j3].i;
                Hg++;
                continue;
            }
            if(u1 != null && u1.w >= 10000)
            {
                int k3 = u1.w - 10000;
                int j4 = yj[k3];
                if(Be[k3])
                    continue;
                if(fh >= 0)
                {
                    if(f.Kb[fh] == 4)
                    {
                        zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                        sf[Hg] = Dk[257] + f.r[j4];
                        ak[Hg] = 300;
                        jk[Hg] = zj[k3];
                        kk[Hg] = Aj[k3];
                        Oj[Hg] = xj[k3];
                        Pj[Hg] = fh;
                        Hg++;
                    }
                } else
                if(Ig >= 0)
                {
                    zf[Hg] = Dk[261] + Ig + Dk[264];
                    sf[Hg] = Dk[257] + f.r[j4];
                    ak[Hg] = 310;
                    jk[Hg] = zj[k3];
                    kk[Hg] = Aj[k3];
                    Oj[Hg] = xj[k3];
                    Pj[Hg] = Ig;
                    Hg++;
                } else
                {
                    if(!f.t[j4].equalsIgnoreCase(Dk[262]))
                    {
                        zf[Hg] = f.t[j4];
                        sf[Hg] = Dk[257] + f.r[j4] + "[" + j4 + "]" + "[" + k3 + "]";
                        ak[Hg] = 320;
                        jk[Hg] = zj[k3];
                        kk[Hg] = Aj[k3];
                        Oj[Hg] = xj[k3];
                        Hg++;
                    }
                    if(!f.u[j4].equalsIgnoreCase(Dk[269]))
                    {
                        zf[Hg] = f.u[j4];
                        sf[Hg] = Dk[257] + f.r[j4] + "[" + j4 + "]" + "[" + k3 + "]";
                        ak[Hg] = 2300;
                        jk[Hg] = zj[k3];
                        kk[Hg] = Aj[k3];
                        Oj[Hg] = xj[k3];
                        Hg++;
                    }
                    zf[Hg] = Dk[269];
                    sf[Hg] = Dk[257] + f.r[j4] + "[" + j4 + "]";
                    ak[Hg] = 3300;
                    Oj[Hg] = j4;
                    Hg++;
                }
                Be[k3] = true;
                continue;
            }
            if(u1 != null && u1.w >= 0)
            {
                int l3 = u1.w;
                int k4 = Fj[l3];
                Ub = Fj[u1.w];
                if(ye[l3])
                    continue;
                if(fh >= 0)
                {
                    if(f.Kb[fh] == 5)
                    {
                        zf[Hg] = Dk[276] + f.h[fh] + Dk[266];
                        sf[Hg] = Dk[257] + f.w[k4] + "[" + k4 + "]" + "[" + l3 + "]";
                        ak[Hg] = 400;
                        jk[Hg] = Dj[l3];
                        kk[Hg] = Ej[l3];
                        Oj[Hg] = Gj[l3];
                        Pj[Hg] = Fj[l3];
                        Qj[Hg] = fh;
                        Hg++;
                    }
                } else
                if(Ig >= 0)
                {
                    zf[Hg] = Dk[261] + Ig + Dk[264];
                    sf[Hg] = Dk[257] + f.w[k4] + "[" + k4 + "]" + "[" + l3 + "]";
                    ak[Hg] = 410;
                    jk[Hg] = Dj[l3];
                    kk[Hg] = Ej[l3];
                    Oj[Hg] = Gj[l3];
                    Pj[Hg] = Fj[l3];
                    Qj[Hg] = Ig;
                    Hg++;
                } else
                {
                    if(!f.y[k4].equalsIgnoreCase(Dk[262]))
                    {
                        zf[Hg] = f.y[k4];
                        sf[Hg] = Dk[257] + f.w[k4] + "[" + k4 + "]" + "[" + l3 + "]";
                        ak[Hg] = 420;
                        jk[Hg] = Dj[l3];
                        kk[Hg] = Ej[l3];
                        Oj[Hg] = Gj[l3];
                        Pj[Hg] = Fj[l3];
                        Hg++;
                    }
                    if(!f.z[k4].equalsIgnoreCase(Dk[269]))
                    {
                        zf[Hg] = f.z[k4];
                        sf[Hg] = Dk[257] + f.w[k4] + "[" + k4 + "]" + "[" + l3 + "]";
                        ak[Hg] = 2400;
                        jk[Hg] = Dj[l3];
                        kk[Hg] = Ej[l3];
                        Oj[Hg] = Gj[l3];
                        Pj[Hg] = Fj[l3];
                        Hg++;
                    }
                    zf[Hg] = Dk[269];
                    sf[Hg] = Dk[257] + f.w[k4] + "[" + k4 + "]" + "[" + l3 + "]";
                    ak[Hg] = 3400;
                    Oj[Hg] = k4;
                    Hg++;
                }
                ye[l3] = true;
                continue;
            }
            if(i3 >= 0)
                i3 = u1.pb[i3] - 0x30d40;
            if(i3 >= 0)
                k1 = i3;
        }

        if(fh >= 0 && f.Kb[fh] <= 1)
        {
            zf[Hg] = Dk[276] + f.h[fh] + Dk[260];
            sf[Hg] = "";
            ak[Hg] = 1000;
            Oj[Hg] = fh;
            Hg++;
        }
        if(k1 != -1)
        {
            int l2 = k1;
            if(fh >= 0)
            {
                if(f.Kb[fh] == 6)
                {
                    zf[Hg] = Dk[276] + f.h[fh] + Dk[271];
                    sf[Hg] = "";
                    ak[Hg] = 900;
                    jk[Hg] = Ee.B[l2];
                    kk[Hg] = Ee.z[l2];
                    Oj[Hg] = fh;
                    Hg++;
                    return;
                }
            } else
            if(Ig < 0)
            {
                zf[Hg] = Dk[263];
                sf[Hg] = "";
                ak[Hg] = 920;
                jk[Hg] = Ee.B[l2];
                kk[Hg] = Ee.z[l2];
                zc = Ee.B[l2];
                Ac = Ee.z[l2];
                Hg++;
            }
        }
    }

    public void cb()
    {
        int i1 = f.J;
        f.a(Dk[616]);
        f.a(Dk[600]);
        f.a(Dk[597]);
        f.a(Dk[595]);
        f.a(Dk[615]);
        f.a(Dk[603]);
        f.a(Dk[593]);
        f.a(Dk[599]);
        f.a(Dk[601]);
        f.a(Dk[590]);
        f.a(Dk[612]);
        f.a(Dk[610]);
        f.a(Dk[596]);
        f.a(Dk[592]);
        f.a(Dk[602]);
        f.a(Dk[614]);
        f.a(Dk[608]);
        f.a(Dk[609]);
        f.a(Dk[594]);
        f.a(Dk[604]);
        if(j())
        {
            byte abyte0[] = a(Dk[607] + p.f + Dk[497], Dk[606], 60);
            if(abyte0 == null)
            {
                te = true;
                return;
            }
            for(int k1 = 0; k1 < f.M; k1++)
            {
                int l1 = m.a(f.j[k1] + Dk[611], abyte0);
                if(l1 != 0)
                    We[k1] = new u(abyte0, l1, true);
                else
                    We[k1] = new u(1, 1);
                if(f.j[k1].equals(Dk[591]))
                    We[k1].d = true;
            }

            return;
        }
        b(70, Dk[598]);
        for(int j1 = 0; j1 < f.M; j1++)
        {
            We[j1] = new u(Dk[613] + f.j[j1] + Dk[605]);
            if(f.j[j1].equals(Dk[591]))
                We[j1].d = true;
        }

    }

    public void db()
    {
        int i1 = f.J;
        if(Ag != 0)
            sb();
        else
            Bf = 1;
        if(ae)
            U();
        else
        if(ne && Kh == 0)
            nb();
        else
        if(Zd && Kh == 0)
            P();
        else
        if(Qd)
            vb();
        else
        if(le)
            W();
        else
        if(ee)
            H();
        else
        if(se)
            rb();
        else
        if(Vi == 1)
            O();
        else
        if(Vi == 2)
            T();
        else
        if(vi != 0)
        {
            kb();
        } else
        {
            if(ie)
                S();
            if(Vc)
                tb();
            if(Le.k == 8 || Le.k == 9)
                tb();
            N();
            boolean flag = !ie && !ke;
            if(flag)
                Hg = 0;
            if(ki == 0 && flag)
                bb();
            if(ki == 1)
                d(flag);
            if(ki == 2)
                a(flag);
            if(ki == 3)
                b(flag);
            if(ki == 4)
                c(flag);
            if(ki == 5)
                f(flag);
            if(ki == 6)
                e(flag);
            if(!ke && !ie)
                ub();
            if(ke && !ie)
                L();
        }
        hh = 0;
    }

    public void eb()
    {
        super.G = "";
        super.H = "";
    }

    void c(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = f.J;
        r r1 = Fe[i2];
        int i3 = r1.k + (tg + 16) / 32 & 7;
        boolean flag = false;
        int j3 = i3;
        if(j3 == 5)
        {
            j3 = 3;
            flag = true;
        } else
        if(j3 == 6)
        {
            j3 = 2;
            flag = true;
        } else
        if(j3 == 7)
        {
            j3 = 1;
            flag = true;
        }
        int k3 = j3 * 3 + rj[(r1.j / f.S[r1.i]) % 4];
        if(r1.k == 8)
        {
            j3 = 5;
            i3 = 2;
            flag = false;
            i1 -= (f.U[r1.i] * k2) / 100;
            k3 = j3 * 3 + lk[(mi / (f.T[r1.i] - 1)) % 8];
        } else
        if(r1.k == 9)
        {
            j3 = 5;
            i3 = 2;
            flag = true;
            i1 += (f.U[r1.i] * k2) / 100;
            k3 = j3 * 3 + ek[(mi / f.T[r1.i]) % 8];
        }
        for(int l3 = 0; l3 < 12; l3++)
        {
            int k4 = Ck[i3][l3];
            int i5 = f.Mb[r1.i][k4];
            if(i5 < 0)
                continue;
            int j5 = 0;
            int k5 = 0;
            int l5 = k3;
            if(flag && j3 >= 1 && j3 <= 3 && f.Eb[i5] == 1)
                l5 += 15;
            if(j3 == 5 && f.Db[i5] != 1)
                continue;
            int i6 = l5 + f.Fb[i5];
            j5 = (j5 * k1) / ((v) (Xe)).F[i6];
            k5 = (k5 * l1) / ((v) (Xe)).G[i6];
            int j6 = (k1 * ((v) (Xe)).F[i6]) / ((v) (Xe)).F[f.Fb[i5]];
            j5 -= (j6 - k1) / 2;
            int k6 = f.Bb[i5];
            int l6 = 0;
            if(k6 == 1)
            {
                k6 = f.cb[r1.i];
                l6 = f.fb[r1.i];
            } else
            if(k6 == 2)
            {
                k6 = f.db[r1.i];
                l6 = f.fb[r1.i];
            } else
            if(k6 == 3)
            {
                k6 = f.eb[r1.i];
                l6 = f.fb[r1.i];
            }
            Xe.a(i1 + j5, j1 + k5, j6, l1, i6, k6, l6, j2, flag);
        }

        if(r1.o > 0)
        {
            uk[kh] = Xe.a(r1.d, 1) / 2;
            if(uk[kh] > 150)
                uk[kh] = 150;
            vk[kh] = (Xe.a(r1.d, 1) / 300) * Xe.c(1);
            sk[kh] = i1 + k1 / 2;
            tk[kh] = j1;
            vf[kh++] = r1.d;
        }
        if(r1.k == 8 || r1.k == 9 || r1.u != 0)
        {
            if(r1.u > 0)
            {
                int i4 = i1;
                if(r1.k == 8)
                    i4 -= (20 * k2) / 100;
                else
                if(r1.k == 9)
                    i4 += (20 * k2) / 100;
                int l4 = (r1.s * 30) / r1.t;
                gj[Jg] = i4 + k1 / 2;
                hj[Jg] = j1;
                ij[Jg++] = l4;
            }
            if(r1.u > 150)
            {
                int j4 = i1;
                if(r1.k == 8)
                    j4 -= (10 * k2) / 100;
                else
                if(r1.k == 9)
                    j4 += (10 * k2) / 100;
                Xe.c((j4 + k1 / 2) - 12, (j1 + l1 / 2) - 12, Ei + 12);
                Xe.b(String.valueOf(r1.r), (j4 + k1 / 2) - 1, j1 + l1 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public void fb()
    {
        Xe.c(0, Vf - 4, Ei + 23);
        int i1 = v.b(200, 200, 255);
        if(Og == 0)
            i1 = v.b(255, 200, 50);
        if(Ug % 30 > 15)
            i1 = v.b(255, 50, 50);
        Xe.b(Dk[3], 54, Vf + 6, 0, i1);
        i1 = v.b(200, 200, 255);
        if(Og == 1)
            i1 = v.b(255, 200, 50);
        if(Vg % 30 > 15)
            i1 = v.b(255, 50, 50);
        Xe.b(Dk[1], 155, Vf + 6, 0, i1);
        i1 = v.b(200, 200, 255);
        if(Og == 2)
            i1 = v.b(255, 200, 50);
        if(Wg % 30 > 15)
            i1 = v.b(255, 50, 50);
        Xe.b(Dk[4], 255, Vf + 6, 0, i1);
        i1 = v.b(200, 200, 255);
        if(Og == 3)
            i1 = v.b(255, 200, 50);
        if(Xg % 30 > 15)
            i1 = v.b(255, 50, 50);
        Xe.b(Dk[2], 355, Vf + 6, 0, i1);
        Xe.b(Dk[0], 457, Vf + 6, 0, 0xffffff);
    }

    public void gb()
    {
        int i1 = f.J;
        he = false;
        Xe.b = false;
        Xe.c();
        if(Zf == 0 || Zf == 1 || Zf == 2 || Zf == 3)
        {
            int j1 = (mi * 2) % 3072;
            if(j1 < 1024)
            {
                Xe.c(0, 10, Ki);
                if(j1 > 768)
                    Xe.d(0, 10, Ki + 1, j1 - 768);
            } else
            if(j1 < 2048)
            {
                Xe.c(0, 10, Ki + 1);
                if(j1 > 1792)
                    Xe.d(0, 10, Ei + 10, j1 - 1792);
            } else
            {
                Xe.c(0, 10, Ei + 10);
                if(j1 > 2816)
                    Xe.d(0, 10, Ki, j1 - 2816);
            }
        }
        if(Zf == 0)
        {
            if(Bf != 0)
            {
                ab.a(Dk[5]);
                Bf = 0;
            }
            Se.a();
        } else
        {
            Bf = 1;
        }
        if(Zf == 1)
            Me.a();
        if(Zf == 2)
            Ne.a();
        Xe.c(0, Vf, Ei + 22);
        Xe.a(Ye, 0, 0);
    }

    public void hb()
    {
        if(Di == 0)
            return;
        if(Kh > 450)
        {
            a(Dk[724], 3);
            ab.a(Dk[514]);
            return;
        }
        if(Kh > 0)
        {
            a(Dk[723], 3);
            ab.a(Dk[514]);
            return;
        } else
        {
            super.nb.a(168);
            super.nb.i();
            Ag = 1000;
            return;
        }
    }

    public void ib()
    {
        int i1 = f.J;
        Vh = xi;
        for(int j1 = 0; j1 < xi; j1++)
        {
            mk[j1] = Sj[j1];
            nk[j1] = Tj[j1];
        }

        for(int k1 = 0; k1 < pg && Vh < li; k1++)
        {
            int l1 = lj[k1];
            boolean flag = false;
            int i2 = 0;
            do
            {
                if(i2 >= Vh)
                    break;
                if(mk[i2] == l1)
                {
                    flag = true;
                    break;
                }
                i2++;
            } while(true);
            if(!flag)
            {
                mk[Vh] = l1;
                nk[Vh] = 0;
                Vh++;
            }
        }

    }

    public void jb()
    {
        byte abyte0[] = a(Dk[568] + p.c + Dk[497], Dk[570], 10);
        if(abyte0 == null)
        {
            te = true;
            return;
        }
        f.a(abyte0, re);
        byte abyte1[] = a(Dk[571] + p.j + Dk[497], Dk[567], 15);
        if(abyte1 == null)
        {
            te = true;
            return;
        } else
        {
            byte abyte2[] = m.a(Dk[569], 0, abyte1);
            byte abyte3[] = m.a(Dk[573], 0, abyte1);
            byte abyte4[] = m.a(Dk[572], 0, abyte1);
            byte abyte5[] = m.a(Dk[566], 0, abyte1);
            n.a(new j(abyte2), new j(abyte3), new j(abyte4), new j(abyte5));
            return;
        }
    }

    public void e(int i1, int j1, int k1)
    {
        Xe.a(i1, j1, k1);
        Xe.a(i1 - 1, j1, k1);
        Xe.a(i1 + 1, j1, k1);
        Xe.a(i1, j1 - 1, k1);
        Xe.a(i1, j1 + 1, k1);
    }

    public void kb()
    {
        if(hh != 0)
        {
            hh = 0;
            if(vi == 1 && (super.S < 106 || super.T < 145 || super.S > 406 || super.T > 215))
            {
                vi = 0;
                return;
            }
            if(vi == 2 && (super.S < 6 || super.T < 145 || super.S > 506 || super.T > 215))
            {
                vi = 0;
                return;
            }
            if(vi == 3 && (super.S < 106 || super.T < 145 || super.S > 406 || super.T > 215))
            {
                vi = 0;
                return;
            }
            if(super.S > 236 && super.S < 276 && super.T > 193 && super.T < 213)
            {
                vi = 0;
                return;
            }
        }
        int i1 = 145;
        if(vi == 1)
        {
            Xe.b(106, i1, 300, 70, 0);
            Xe.c(106, i1, 300, 70, 0xffffff);
            i1 += 20;
            Xe.b(Dk[158], 256, i1, 4, 0xffffff);
            i1 += 20;
            Xe.b(super.E + "*", 256, i1, 4, 0xffffff);
            if(super.F.length() > 0)
            {
                String s1 = super.F.trim();
                super.E = "";
                super.F = "";
                vi = 0;
                if(s1.length() > 0 && m.b(s1) != Le.b)
                    b(s1);
            }
        }
        if(vi == 2)
        {
            Xe.b(6, i1, 500, 70, 0);
            Xe.c(6, i1, 500, 70, 0xffffff);
            i1 += 20;
            Xe.b(Dk[163] + m.a(bf), 256, i1, 4, 0xffffff);
            i1 += 20;
            Xe.b(super.G + "*", 256, i1, 4, 0xffffff);
            if(super.H.length() > 0)
            {
                String s2 = super.H;
                super.G = "";
                super.H = "";
                vi = 0;
                int k1 = o.a(s2);
                a(bf, o.a, k1);
                s2 = o.a(o.a, 0, k1);
                s2 = n.a(s2);
                d(Dk[159] + m.a(bf) + Dk[162] + s2);
                super.db = Dk[161] + m.a(bf) + ":" + s2;
                ab.b(super.db);
            }
        }
        if(vi == 3)
        {
            Xe.b(106, i1, 300, 70, 0);
            Xe.c(106, i1, 300, 70, 0xffffff);
            i1 += 20;
            Xe.b(Dk[157], 256, i1, 4, 0xffffff);
            i1 += 20;
            Xe.b(super.E + "*", 256, i1, 4, 0xffffff);
            if(super.F.length() > 0)
            {
                String s3 = super.F.trim();
                super.E = "";
                super.F = "";
                vi = 0;
                if(s3.length() > 0 && m.b(s3) != Le.b)
                    a(s3);
            }
        }
        int j1 = 0xffffff;
        if(super.S > 236 && super.S < 276 && super.T > 193 && super.T < 213)
            j1 = 0xffff00;
        Xe.b(Dk[160], 256, 208, 1, j1);
    }

    public r c(int i1, int j1, int k1, int l1)
    {
        int i2 = f.J;
        if(He[i1] == null)
        {
            He[i1] = new r();
            He[i1].e = i1;
            He[i1].f = 0;
        }
        r r1 = He[i1];
        boolean flag = false;
        int j2 = 0;
        do
        {
            if(j2 >= yg)
                break;
            if(Ie[j2].e == i1)
            {
                flag = true;
                break;
            }
            j2++;
        } while(true);
        if(flag)
        {
            r1.l = l1;
            int k2 = r1.n;
            if(j1 != r1.G[k2] || k1 != r1.H[k2])
            {
                r1.n = k2 = (k2 + 1) % 10;
                r1.G[k2] = j1;
                r1.H[k2] = k1;
            }
        } else
        {
            r1.e = i1;
            r1.m = 0;
            r1.n = 0;
            r1.G[0] = r1.g = j1;
            r1.H[0] = r1.h = k1;
            r1.l = r1.k = l1;
            r1.j = 0;
        }
        Ke[xg++] = r1;
        return r1;
    }

    public void lb()
    {
        int i1 = f.J;
        int j1 = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        Ee.d(byte0 * 48 + 23, byte1 * 48 + 23, j1);
        Ee.a(We);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        De.s = 4100;
        De.t = 4100;
        De.u = 1;
        De.v = 4000;
        De.b(c1, -Ee.g(c1, c2), c2, 912, c4, 0, c3 * 2);
        De.f();
        Xe.d();
        Xe.d();
        Xe.b(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            Xe.c(0, k1, 0, k1, 512, 8);

        Xe.b(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            Xe.c(0, l1, 0, 194 - l1, 512, 8);

        Xe.c(15, 15, Ei + 10);
        Xe.e(Ki, 0, 0, 512, 200);
        Xe.a(Ki);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        De.s = 4100;
        De.t = 4100;
        De.u = 1;
        De.v = 4000;
        De.b(c1, -Ee.g(c1, c2), c2, 912, c4, 0, c3 * 2);
        De.f();
        Xe.d();
        Xe.d();
        Xe.b(0, 0, 512, 6, 0);
        for(int i2 = 6; i2 >= 1; i2--)
            Xe.c(0, i2, 0, i2, 512, 8);

        Xe.b(0, 194, 512, 20, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            Xe.c(0, j2, 0, 194 - j2, 512, 8);

        Xe.c(15, 15, Ei + 10);
        Xe.e(Ki + 1, 0, 0, 512, 200);
        Xe.a(Ki + 1);
        for(int k2 = 0; k2 < 64; k2++)
        {
            De.b(Ee.q[0][k2]);
            De.b(Ee.r[1][k2]);
            De.b(Ee.q[1][k2]);
            De.b(Ee.r[2][k2]);
            De.b(Ee.q[2][k2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        De.s = 4100;
        De.t = 4100;
        De.u = 1;
        De.v = 4000;
        De.b(c1, -Ee.g(c1, c2), c2, 912, c4, 0, c3 * 2);
        De.f();
        Xe.d();
        Xe.d();
        Xe.b(0, 0, 512, 6, 0);
        for(int l2 = 6; l2 >= 1; l2--)
            Xe.c(0, l2, 0, l2, 512, 8);

        Xe.b(0, 194, 512, 20, 0);
        for(int i3 = 6; i3 >= 1; i3--)
            Xe.c(0, i3, 0, 194, 512, 8);

        Xe.c(15, 15, Ei + 10);
        Xe.e(Ei + 10, 0, 0, 512, 200);
        Xe.a(Ei + 10);
    }

    public void mb()
    {
        int i1 = f.J;
        if((yi & 1) == 1 && bb(yi))
            return;
        if((yi & 1) == 0 && bb(yi))
        {
            if(bb(yi + 1 & 7))
            {
                yi = yi + 1 & 7;
                return;
            }
            if(bb(yi + 7 & 7))
                yi = yi + 7 & 7;
            return;
        }
        int ai1[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        int j1 = 0;
        do
        {
            if(j1 >= 7)
                break;
            if(bb(yi + ai1[j1] + 8 & 7))
            {
                yi = yi + ai1[j1] + 8 & 7;
                break;
            }
            j1++;
        } while(true);
        if((yi & 1) == 0 && bb(yi))
        {
            if(bb(yi + 1 & 7))
            {
                yi = yi + 1 & 7;
                return;
            }
            if(bb(yi + 7 & 7))
                yi = yi + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public boolean eb(int i1)
    {
        for(int j1 = 0; j1 < pg; j1++)
            if(lj[j1] == i1 && nj[j1] == 1)
                return true;

        return false;
    }

    public void f(boolean flag)
    {
        int i1 = f.J;
        int j1 = ((v) (Xe)).m - 199;
        int k1 = 36;
        Xe.c(j1 - 49, 3, Ei + 5);
        char c1 = '\304';
        char c2 = '\266';
        int l1;
        int i2 = l1 = v.b(160, 160, 160);
        if(ti == 0)
            i2 = v.b(220, 220, 220);
        else
            l1 = v.b(220, 220, 220);
        Xe.a(j1, k1, c1 / 2, 24, i2, 128);
        Xe.a(j1 + c1 / 2, k1, c1 / 2, 24, l1, 128);
        Xe.a(j1, k1 + 24, c1, c2 - 24, v.b(220, 220, 220), 128);
        Xe.b(j1, k1 + 24, c1, 0);
        Xe.c(j1 + c1 / 2, k1, 24, 0);
        Xe.b(j1, (k1 + c2) - 16, c1, 0);
        Xe.b(Dk[228], j1 + c1 / 4, k1 + 16, 4, 0);
        Xe.b(Dk[230], j1 + c1 / 4 + c1 / 2, k1 + 16, 4, 0);
        Te.c(si);
        if(ti == 0)
        {
            for(int j2 = 0; j2 < super.Ab; j2++)
            {
                String s1;
                if(super.Kb[j2] == 99)
                    s1 = Dk[211];
                else
                if(super.Kb[j2] > 0)
                    s1 = Dk[221];
                else
                    s1 = Dk[220];
                Te.a(si, j2, s1 + m.a(super.rb[j2]) + Dk[226]);
            }

        }
        if(ti == 1)
        {
            for(int k2 = 0; k2 < super.Bb; k2++)
                Te.a(si, k2, Dk[221] + m.a(super.sb[k2]) + Dk[226]);

        }
        Te.a();
        if(ti == 0)
        {
            int l2 = Te.i(si);
            if(l2 >= 0 && super.S < 489)
            {
                if(super.S > 429)
                    Xe.b(Dk[229] + m.a(super.rb[l2]), j1 + c1 / 2, k1 + 35, 1, 0xffffff);
                else
                if(super.Kb[l2] == 99)
                    Xe.b(Dk[233] + m.a(super.rb[l2]), j1 + c1 / 2, k1 + 35, 1, 0xffffff);
                else
                if(super.Kb[l2] > 0)
                    Xe.b(m.a(super.rb[l2]) + Dk[223] + super.Kb[l2], j1 + c1 / 2, k1 + 35, 1, 0xffffff);
                else
                    Xe.b(m.a(super.rb[l2]) + Dk[232], j1 + c1 / 2, k1 + 35, 1, 0xffffff);
            } else
            {
                Xe.b(Dk[225], j1 + c1 / 2, k1 + 35, 1, 0xffffff);
            }
            int l3;
            if(super.S > j1 && super.S < j1 + c1 && super.T > (k1 + c2) - 16 && super.T < k1 + c2)
                l3 = 0xffff00;
            else
                l3 = 0xffffff;
            Xe.b(Dk[224], j1 + c1 / 2, (k1 + c2) - 3, 1, l3);
        }
        if(ti == 1)
        {
            int i3 = Te.i(si);
            if(i3 >= 0 && super.S < 489 && super.S > 429)
            {
                if(super.S > 429)
                    Xe.b(Dk[229] + m.a(super.sb[i3]), j1 + c1 / 2, k1 + 35, 1, 0xffffff);
            } else
            {
                Xe.b(Dk[231], j1 + c1 / 2, k1 + 35, 1, 0xffffff);
            }
            int i4;
            if(super.S > j1 && super.S < j1 + c1 && super.T > (k1 + c2) - 16 && super.T < k1 + c2)
                i4 = 0xffff00;
            else
                i4 = 0xffffff;
            Xe.b(Dk[227], j1 + c1 / 2, (k1 + c2) - 3, 1, i4);
        }
        if(!flag)
            return;
        j1 = super.S - (((v) (Xe)).m - 199);
        k1 = super.T - 36;
        if(j1 >= 0 && k1 >= 0 && j1 < 196 && k1 < 182)
        {
            Te.a(j1 + (((v) (Xe)).m - 199), k1 + 36, super.V, super.U);
            if(k1 <= 24 && hh == 1)
                if(j1 < 98 && ti == 1)
                {
                    ti = 0;
                    Te.d(si);
                } else
                if(j1 > 98 && ti == 0)
                {
                    ti = 1;
                    Te.d(si);
                }
            if(hh == 1 && ti == 0)
            {
                int j3 = Te.i(si);
                if(j3 >= 0 && super.S < 489)
                    if(super.S > 429)
                        b(super.rb[j3]);
                    else
                    if(super.Kb[j3] != 0)
                    {
                        vi = 2;
                        bf = super.rb[j3];
                        super.G = "";
                        super.H = "";
                    }
            }
            if(hh == 1 && ti == 1)
            {
                int k3 = Te.i(si);
                if(k3 >= 0 && super.S < 489 && super.S > 429)
                    a(super.sb[k3]);
            }
            if(k1 > 166 && hh == 1 && ti == 0)
            {
                vi = 1;
                super.E = "";
                super.F = "";
            }
            if(k1 > 166 && hh == 1 && ti == 1)
            {
                vi = 3;
                super.E = "";
                super.F = "";
            }
            hh = 0;
        }
    }

    public void nb()
    {
        int i1 = f.J;
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(gh > 0 && Vh <= 48)
            gh = 0;
        if(gh > 1 && Vh <= 96)
            gh = 1;
        if(gh > 2 && Vh <= 144)
            gh = 2;
        if(ph >= Vh || ph < 0)
            ph = -1;
        if(ph != -1 && mk[ph] != qh)
        {
            ph = -1;
            qh = -2;
        }
        if(hh != 0)
        {
            hh = 0;
            int j1 = super.S - (256 - c1 / 2);
            int l1 = super.T - (170 - c2 / 2);
            if(j1 >= 0 && l1 >= 12 && j1 < 408 && l1 < 280)
            {
                int j2 = gh * 48;
                for(int l2 = 0; l2 < 6; l2++)
                {
                    for(int k3 = 0; k3 < 8; k3++)
                    {
                        int i5 = 7 + k3 * 49;
                        int k5 = 28 + l2 * 34;
                        if(j1 > i5 && j1 < i5 + 49 && l1 > k5 && l1 < k5 + 34 && j2 < Vh && mk[j2] != -1)
                        {
                            qh = mk[j2];
                            ph = j2;
                        }
                        j2++;
                    }

                }

                j1 = 256 - c1 / 2;
                l1 = 170 - c2 / 2;
                int i3;
                if(ph < 0)
                    i3 = -1;
                else
                    i3 = mk[ph];
                if(i3 != -1)
                {
                    int l3 = nk[ph];
                    if(f.lb[i3] == 1 && l3 > 1)
                        l3 = 1;
                    if(l3 >= 1 && super.S >= j1 + 190 && super.T >= l1 + 238 && super.S < j1 + 220 && super.T <= l1 + 249)
                    {
                        Kc = i3;
                        Nc = new ib(this);
                        System.out.println(Dk[692] + i3 + ")");
                    }
                    if(l3 >= 1 && super.S >= j1 + 220 && super.T >= l1 + 238 && super.S < j1 + 250 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(1);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[679]);
                    }
                    if(l3 >= 5 && super.S >= j1 + 250 && super.T >= l1 + 238 && super.S < j1 + 280 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(5);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[682]);
                    }
                    if(l3 >= 25 && super.S >= j1 + 280 && super.T >= l1 + 238 && super.S < j1 + 305 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(25);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[687]);
                    }
                    if(l3 >= 100 && super.S >= j1 + 305 && super.T >= l1 + 238 && super.S < j1 + 335 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(100);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[686]);
                    }
                    if(l3 >= 500 && super.S >= j1 + 335 && super.T >= l1 + 238 && super.S < j1 + 368 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(500);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[695]);
                    }
                    if(l3 >= 2500 && super.S >= j1 + 370 && super.T >= l1 + 238 && super.S < j1 + 400 && super.T <= l1 + 249)
                    {
                        super.nb.a(83);
                        super.nb.e(i3);
                        super.nb.e(2500);
                        super.nb.i();
                        System.out.println(Dk[331] + i3 + "," + Dk[698]);
                    }
                    if(db(i3) >= 1 && super.S >= j1 + 190 && super.T >= l1 + 263 && super.S < j1 + 220 && super.T <= l1 + 274)
                    {
                        Jc = i3;
                        Mc = new fb(this);
                        System.out.println(Dk[693] + i3 + ")");
                    }
                    if(db(i3) >= 1 && super.S >= j1 + 220 && super.T >= l1 + 263 && super.S < j1 + 250 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(1);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[679]);
                    }
                    if(db(i3) >= 5 && super.S >= j1 + 250 && super.T >= l1 + 263 && super.S < j1 + 280 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(5);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[682]);
                    }
                    if(db(i3) >= 25 && super.S >= j1 + 280 && super.T >= l1 + 263 && super.S < j1 + 305 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(25);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[687]);
                    }
                    if(db(i3) >= 100 && super.S >= j1 + 305 && super.T >= l1 + 263 && super.S < j1 + 335 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(100);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[686]);
                    }
                    if(db(i3) >= 500 && super.S >= j1 + 335 && super.T >= l1 + 263 && super.S < j1 + 368 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(500);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[695]);
                    }
                    if(db(i3) >= 2500 && super.S >= j1 + 370 && super.T >= l1 + 263 && super.S < j1 + 400 && super.T <= l1 + 274)
                    {
                        super.nb.a(145);
                        super.nb.e(i3);
                        super.nb.e(2500);
                        super.nb.i();
                        System.out.println(Dk[304] + i3 + "," + Dk[698]);
                    }
                }
            } else
            if(Vh > 48 && j1 >= 50 && j1 <= 115 && l1 <= 12)
                gh = 0;
            else
            if(Vh > 48 && j1 >= 115 && j1 <= 180 && l1 <= 12)
                gh = 1;
            else
            if(Vh > 96 && j1 >= 180 && j1 <= 245 && l1 <= 12)
                gh = 2;
            else
            if(Vh > 144 && j1 >= 245 && j1 <= 310 && l1 <= 12)
            {
                gh = 3;
            } else
            {
                super.nb.a(50);
                super.nb.i();
                ne = false;
                System.out.println(Dk[63]);
                return;
            }
        }
        int k1 = 256 - c1 / 2;
        int i2 = 170 - c2 / 2;
        Xe.b(k1, i2, 408, 12, 192);
        int k2 = 0x989898;
        Xe.a(k1, i2 + 12, 408, 17, k2, 160);
        Xe.a(k1, i2 + 29, 8, 204, k2, 160);
        Xe.a(k1 + 399, i2 + 29, 9, 204, k2, 160);
        Xe.a(k1, i2 + 233, 408, 47, k2, 160);
        Xe.c(Dk[699], k1 + 1, i2 + 10, 1, 0xffffff);
        int j3 = 50;
        if(Vh > 48)
        {
            int i4 = 0xffffff;
            if(gh == 0)
                i4 = 0xff0000;
            else
            if(super.S > k1 + j3 && super.T >= i2 && super.S < k1 + j3 + 65 && super.T < i2 + 12)
                i4 = 0xffff00;
            Xe.c(Dk[690], k1 + j3, i2 + 10, 1, i4);
            j3 += 65;
            i4 = 0xffffff;
            if(gh == 1)
                i4 = 0xff0000;
            else
            if(super.S > k1 + j3 && super.T >= i2 && super.S < k1 + j3 + 65 && super.T < i2 + 12)
                i4 = 0xffff00;
            Xe.c(Dk[697], k1 + j3, i2 + 10, 1, i4);
            j3 += 65;
        }
        if(Vh > 96)
        {
            int j4 = 0xffffff;
            if(gh == 2)
                j4 = 0xff0000;
            else
            if(super.S > k1 + j3 && super.T >= i2 && super.S < k1 + j3 + 65 && super.T < i2 + 12)
                j4 = 0xffff00;
            Xe.c(Dk[696], k1 + j3, i2 + 10, 1, j4);
            j3 += 65;
        }
        if(Vh > 144)
        {
            int k4 = 0xffffff;
            if(gh == 3)
                k4 = 0xff0000;
            else
            if(super.S > k1 + j3 && super.T >= i2 && super.S < k1 + j3 + 65 && super.T < i2 + 12)
                k4 = 0xffff00;
            Xe.c(Dk[688], k1 + j3, i2 + 10, 1, k4);
            j3 += 65;
        }
        int l4 = 0xffffff;
        if(super.S > k1 + 320 && super.T >= i2 && super.S < k1 + 408 && super.T < i2 + 12)
            l4 = 0xff0000;
        Xe.a(Dk[628], k1 + 406, i2 + 10, 1, l4);
        Xe.c(Dk[684], k1 + 7, i2 + 24, 1, 65280);
        Xe.c(Dk[702], k1 + 289, i2 + 24, 1, 65535);
        int j5 = 0xd0d0d0;
        int l5 = gh * 48;
        for(int i6 = 0; i6 < 6; i6++)
        {
            for(int k6 = 0; k6 < 8; k6++)
            {
                int i7 = k1 + 7 + k6 * 49;
                int l7 = i2 + 28 + i6 * 34;
                if(ph == l5)
                    Xe.a(i7, l7, 49, 34, 0xff0000, 160);
                else
                    Xe.a(i7, l7, 49, 34, j5, 160);
                Xe.c(i7, l7, 50, 35, 0);
                if(l5 < Vh && mk[l5] != -1)
                {
                    Xe.a(i7, l7, 48, 32, Gi + f.jb[mk[l5]], f.ob[mk[l5]], 0, 0, false);
                    Xe.c(String.valueOf(nk[l5]), i7 + 1, l7 + 10, 1, 65280);
                    Xe.a(String.valueOf(db(mk[l5])), i7 + 47, l7 + 29, 1, 65535);
                }
                l5++;
            }

        }

        Xe.b(k1 + 5, i2 + 256, 398, 0);
        if(ph == -1)
        {
            Xe.b(Dk[700], k1 + 204, i2 + 248, 3, 0xffff00);
            return;
        }
        int j6;
        if(ph < 0)
            j6 = -1;
        else
            j6 = mk[ph];
        if(j6 != -1)
        {
            int l6 = nk[ph];
            if(f.lb[j6] == 1 && l6 > 1)
                l6 = 1;
            if(l6 > 0)
            {
                Xe.c(Dk[685] + f.d[j6], k1 + 2, i2 + 248, 1, 0xffffff);
                int j7 = 0xffffff;
                if(super.S >= k1 + 190 && super.T >= i2 + 238 && super.S < k1 + 220 && super.T <= i2 + 249)
                    j7 = 0xff0000;
                Xe.c(Dk[681], k1 + 192, i2 + 248, 1, j7);
                int i8 = 0xffffff;
                if(super.S >= k1 + 220 && super.T >= i2 + 238 && super.S < k1 + 250 && super.T <= i2 + 249)
                    i8 = 0xff0000;
                Xe.c(Dk[694], k1 + 222, i2 + 248, 1, i8);
                if(l6 >= 5)
                {
                    int k8 = 0xffffff;
                    if(super.S >= k1 + 250 && super.T >= i2 + 238 && super.S < k1 + 280 && super.T <= i2 + 249)
                        k8 = 0xff0000;
                    Xe.c(Dk[680], k1 + 252, i2 + 248, 1, k8);
                }
                if(l6 >= 25)
                {
                    int l8 = 0xffffff;
                    if(super.S >= k1 + 280 && super.T >= i2 + 238 && super.S < k1 + 305 && super.T <= i2 + 249)
                        l8 = 0xff0000;
                    Xe.c(Dk[683], k1 + 282, i2 + 248, 1, l8);
                }
                if(l6 >= 100)
                {
                    int i9 = 0xffffff;
                    if(super.S >= k1 + 305 && super.T >= i2 + 238 && super.S < k1 + 335 && super.T <= i2 + 249)
                        i9 = 0xff0000;
                    Xe.c(Dk[701], k1 + 307, i2 + 248, 1, i9);
                }
                if(l6 >= 500)
                {
                    int j9 = 0xffffff;
                    if(super.S >= k1 + 335 && super.T >= i2 + 238 && super.S < k1 + 368 && super.T <= i2 + 249)
                        j9 = 0xff0000;
                    Xe.c(Dk[691], k1 + 337, i2 + 248, 1, j9);
                }
                if(l6 >= 2500)
                {
                    int k9 = 0xffffff;
                    if(super.S >= k1 + 370 && super.T >= i2 + 238 && super.S < k1 + 400 && super.T <= i2 + 249)
                        k9 = 0xff0000;
                    Xe.c(Dk[703], k1 + 370, i2 + 248, 1, k9);
                }
            }
            if(db(j6) > 0)
            {
                Xe.c(Dk[689] + f.d[j6], k1 + 2, i2 + 273, 1, 0xffffff);
                int k7 = 0xffffff;
                if(super.S >= k1 + 190 && super.T >= i2 + 263 && super.S < k1 + 220 && super.T <= i2 + 274)
                    k7 = 0xff0000;
                Xe.c(Dk[681], k1 + 192, i2 + 273, 1, k7);
                int j8 = 0xffffff;
                if(super.S >= k1 + 220 && super.T >= i2 + 263 && super.S < k1 + 250 && super.T <= i2 + 274)
                    j8 = 0xff0000;
                Xe.c(Dk[694], k1 + 222, i2 + 273, 1, j8);
                if(db(j6) >= 5)
                {
                    int l9 = 0xffffff;
                    if(super.S >= k1 + 250 && super.T >= i2 + 263 && super.S < k1 + 280 && super.T <= i2 + 274)
                        l9 = 0xff0000;
                    Xe.c(Dk[680], k1 + 252, i2 + 273, 1, l9);
                }
                if(db(j6) >= 25)
                {
                    int i10 = 0xffffff;
                    if(super.S >= k1 + 280 && super.T >= i2 + 263 && super.S < k1 + 305 && super.T <= i2 + 274)
                        i10 = 0xff0000;
                    Xe.c(Dk[683], k1 + 282, i2 + 273, 1, i10);
                }
                if(db(j6) >= 100)
                {
                    int j10 = 0xffffff;
                    if(super.S >= k1 + 305 && super.T >= i2 + 263 && super.S < k1 + 335 && super.T <= i2 + 274)
                        j10 = 0xff0000;
                    Xe.c(Dk[701], k1 + 307, i2 + 273, 1, j10);
                }
                if(db(j6) >= 500)
                {
                    int k10 = 0xffffff;
                    if(super.S >= k1 + 335 && super.T >= i2 + 263 && super.S < k1 + 368 && super.T <= i2 + 274)
                        k10 = 0xff0000;
                    Xe.c(Dk[691], k1 + 337, i2 + 273, 1, k10);
                }
                if(db(j6) >= 2500)
                {
                    int l10 = 0xffffff;
                    if(super.S >= k1 + 370 && super.T >= i2 + 263 && super.S < k1 + 400 && super.T <= i2 + 274)
                        l10 = 0xff0000;
                    Xe.c(Dk[703], k1 + 370, i2 + 273, 1, l10);
                }
            }
        }
    }

    public void ob()
    {
        int i1 = f.J;
        if(Bg > 1)
            Bg--;
        m();
        if(Ag > 0)
            Ag--;
        if(super.N > 4500 && Kh == 0 && Ag == 0 && !Cc)
        {
            if(super.jb == 0)
            {
                b(C(), D() - 1, 0);
                super.jb = 1;
                return;
            }
            if(super.jb == 1)
            {
                b(C(), D() + 1, 0);
                super.jb = 0;
                return;
            }
        }
        if(Le.k == 8 || Le.k == 9)
            Kh = 500;
        if(Kh > 0)
            Kh--;
        if(xe)
        {
            Q();
            return;
        }
        for(int j1 = 0; j1 < xg; j1++)
        {
            r r1 = Ke[j1];
            int k4 = (r1.n + 1) % 10;
            if(r1.m != k4)
            {
                int j5 = -1;
                int l5 = r1.m;
                int j6;
                if(l5 < k4)
                    j6 = k4 - l5;
                else
                    j6 = (10 + k4) - l5;
                int l6 = 4;
                if(j6 > 2)
                    l6 = (j6 - 1) * 4;
                if(r1.G[l5] - r1.g > Ci * 3 || r1.H[l5] - r1.h > Ci * 3 || r1.G[l5] - r1.g < -Ci * 3 || r1.H[l5] - r1.h < -Ci * 3 || j6 > 8)
                {
                    r1.g = r1.G[l5];
                    r1.h = r1.H[l5];
                } else
                {
                    if(r1.g < r1.G[l5])
                    {
                        r1.g += l6;
                        r1.j++;
                        j5 = 2;
                    } else
                    if(r1.g > r1.G[l5])
                    {
                        r1.g -= l6;
                        r1.j++;
                        j5 = 6;
                    }
                    if(r1.g - r1.G[l5] < l6 && r1.g - r1.G[l5] > -l6)
                        r1.g = r1.G[l5];
                    if(r1.h < r1.H[l5])
                    {
                        r1.h += l6;
                        r1.j++;
                        if(j5 == -1)
                            j5 = 4;
                        else
                        if(j5 == 2)
                            j5 = 3;
                        else
                            j5 = 5;
                    } else
                    if(r1.h > r1.H[l5])
                    {
                        r1.h -= l6;
                        r1.j++;
                        if(j5 == -1)
                            j5 = 0;
                        else
                        if(j5 == 2)
                            j5 = 1;
                        else
                            j5 = 7;
                    }
                    if(r1.h - r1.H[l5] < l6 && r1.h - r1.H[l5] > -l6)
                        r1.h = r1.H[l5];
                }
                if(j5 != -1)
                    r1.k = j5;
                if(r1.g == r1.G[l5] && r1.h == r1.H[l5])
                    r1.m = (l5 + 1) % 10;
            } else
            {
                r1.k = r1.l;
            }
            if(r1.o > 0)
                r1.o--;
            if(r1.q > 0)
                r1.q--;
            if(r1.u > 0)
                r1.u--;
            if(aj <= 0)
                continue;
            aj--;
            if(aj == 0)
                a(Dk[549], 3);
            if(aj == 0)
                a(Dk[545], 3);
        }

        for(int k1 = 0; k1 < hi; k1++)
        {
            r r2 = Fe[k1];
            int l4 = (r2.n + 1) % 10;
            if(r2.m != l4)
            {
                int k5 = -1;
                int i6 = r2.m;
                int k6;
                if(i6 < l4)
                    k6 = l4 - i6;
                else
                    k6 = (10 + l4) - i6;
                int i7 = 4;
                if(k6 > 2)
                    i7 = (k6 - 1) * 4;
                if(r2.G[i6] - r2.g > Ci * 3 || r2.H[i6] - r2.h > Ci * 3 || r2.G[i6] - r2.g < -Ci * 3 || r2.H[i6] - r2.h < -Ci * 3 || k6 > 8)
                {
                    r2.g = r2.G[i6];
                    r2.h = r2.H[i6];
                } else
                {
                    if(r2.g < r2.G[i6])
                    {
                        r2.g += i7;
                        r2.j++;
                        k5 = 2;
                    } else
                    if(r2.g > r2.G[i6])
                    {
                        r2.g -= i7;
                        r2.j++;
                        k5 = 6;
                    }
                    if(r2.g - r2.G[i6] < i7 && r2.g - r2.G[i6] > -i7)
                        r2.g = r2.G[i6];
                    if(r2.h < r2.H[i6])
                    {
                        r2.h += i7;
                        r2.j++;
                        if(k5 == -1)
                            k5 = 4;
                        else
                        if(k5 == 2)
                            k5 = 3;
                        else
                            k5 = 5;
                    } else
                    if(r2.h > r2.H[i6])
                    {
                        r2.h -= i7;
                        r2.j++;
                        if(k5 == -1)
                            k5 = 0;
                        else
                        if(k5 == 2)
                            k5 = 1;
                        else
                            k5 = 7;
                    }
                    if(r2.h - r2.H[i6] < i7 && r2.h - r2.H[i6] > -i7)
                        r2.h = r2.H[i6];
                }
                if(k5 != -1)
                    r2.k = k5;
                if(r2.g == r2.G[i6] && r2.h == r2.H[i6])
                    r2.m = (i6 + 1) % 10;
            } else
            {
                r2.k = r2.l;
                if(r2.i == 43)
                    r2.j++;
            }
            if(r2.o > 0)
                r2.o--;
            if(r2.q > 0)
                r2.q--;
            if(r2.u > 0)
                r2.u--;
        }

        if(ki != 2)
        {
            if(v.v > 0)
                Th++;
            if(v.w > 0)
                Th = 0;
            v.v = 0;
            v.w = 0;
        }
        for(int l1 = 0; l1 < xg; l1++)
        {
            r r3 = Ke[l1];
            if(r3.D > 0)
                r3.D--;
        }

        if(be)
        {
            if(qg - Le.g < -500 || qg - Le.g > 500 || rg - Le.h < -500 || rg - Le.h > 500)
            {
                qg = Le.g;
                rg = Le.h;
            }
        } else
        {
            if(qg - Le.g < -500 || qg - Le.g > 500 || rg - Le.h < -500 || rg - Le.h > 500)
            {
                qg = Le.g;
                rg = Le.h;
            }
            if(qg != Le.g)
                qg += (Le.g - qg) / (16 + (Xf - 500) / 15);
            if(rg != Le.h)
                rg += (Le.h - rg) / (16 + (Xf - 500) / 15);
            if(Sd)
            {
                int i2 = yi * 32;
                int k3 = i2 - tg;
                byte byte0 = 1;
                if(k3 != 0)
                {
                    zi++;
                    if(k3 > 128)
                    {
                        byte0 = -1;
                        k3 = 256 - k3;
                    } else
                    if(k3 > 0)
                        byte0 = 1;
                    else
                    if(k3 < -128)
                    {
                        byte0 = 1;
                        k3 = 256 + k3;
                    } else
                    if(k3 < 0)
                    {
                        byte0 = -1;
                        k3 = -k3;
                    }
                    tg += ((zi * k3 + 255) / 256) * byte0;
                    tg &= 0xff;
                } else
                {
                    zi = 0;
                }
            }
        }
        if(Th > 20)
        {
            oe = false;
            Th = 0;
        }
        if(me)
        {
            if(super.F.length() > 0)
                if(super.F.equalsIgnoreCase(Dk[551]) && !we)
                    super.nb.a();
                else
                if(super.F.equalsIgnoreCase(Dk[544]) && !we)
                {
                    j();
                    mc = true;
                } else
                {
                    super.nb.a(60);
                    super.nb.a(super.F);
                    if(!oe)
                    {
                        super.nb.f(0);
                        oe = true;
                    }
                    super.nb.i();
                    super.E = "";
                    super.F = "";
                    kf = Dk[543];
                }
            if(super.V == 1 && super.T > 275 && super.T < 310 && super.S > 56 && super.S < 456)
            {
                super.nb.a(60);
                super.nb.a(Dk[542]);
                if(!oe)
                {
                    super.nb.f(0);
                    oe = true;
                }
                super.nb.i();
                super.E = "";
                super.F = "";
                kf = Dk[543];
            }
            super.V = 0;
            return;
        }
        if(super.T > Vf - 4)
        {
            if(super.S > 15 && super.S < 96 && super.V == 1)
                Og = 0;
            if(super.S > 110 && super.S < 194 && super.V == 1)
            {
                Og = 1;
                Oe.J[Kg] = 0xf423f;
            }
            if(super.S > 215 && super.S < 295 && super.V == 1)
            {
                Og = 2;
                Oe.J[Mg] = 0xf423f;
            }
            if(super.S > 315 && super.S < 395 && super.V == 1)
            {
                Og = 3;
                Oe.J[Ng] = 0xf423f;
            }
            if(super.S > 417 && super.S < 497 && super.V == 1)
                d(Dk[539]);
            super.V = 0;
            super.U = 0;
        }
        Oe.a(super.S, super.T, super.V, super.U);
        if(Og > 0 && super.S >= 494 && super.T >= Vf - 66)
            super.V = 0;
        if(Oe.a(Lg))
        {
            String s1 = Oe.e(Lg);
            Oe.a(Lg, "");
            if(s1.startsWith(Dk[548]))
            {
                if(s1.equalsIgnoreCase(Dk[544]) && !we)
                    super.nb.a();
                else
                if(s1.equalsIgnoreCase(Dk[547]) && !we)
                {
                    j();
                    mc = true;
                } else
                if(s1.equalsIgnoreCase(Dk[551]) && !we)
                    l();
                else
                    c(s1.substring(2));
            } else
            if(s1.startsWith("/"))
            {
                if(s1.equalsIgnoreCase(Dk[541]))
                {
                    j();
                    E(51);
                    A();
                }
                if(s1.equalsIgnoreCase(Dk[540]))
                {
                    j();
                    E(52);
                    A();
                }
                if(s1.equalsIgnoreCase(Dk[538]))
                {
                    j();
                    E(53);
                    A();
                }
                if(s1.equalsIgnoreCase(Dk[546]))
                {
                    j();
                    E(54);
                    A();
                }
                if(s1.equalsIgnoreCase(Dk[550]))
                {
                    j();
                    E(55);
                    A();
                }
                if(s1.equalsIgnoreCase(Dk[552]))
                {
                    j();
                    E(56);
                    A();
                }
            } else
            {
                int l3 = o.a(s1);
                a(o.a, l3);
                s1 = o.a(o.a, 0, l3);
                s1 = n.a(s1);
                Le.o = 150;
                Le.d = s1;
                a(Dk[62] + Le.c + Dk[61] + s1, 2);
                rc = Dk[56] + Le.c + ":" + s1;
                ab.b(rc);
            }
        }
        if(Og == 0)
        {
            for(int j2 = 0; j2 < 5; j2++)
                if(ik[j2] > 0)
                    ik[j2]--;

        }
        if(aj != 0)
            super.V = 0;
        if(le || se)
        {
            if(super.U != 0)
                ih++;
            else
                ih = 0;
            if(ih > 600)
                jh += 5000;
            else
            if(ih > 450)
                jh += 500;
            else
            if(ih > 300)
                jh += 50;
            else
            if(ih > 150)
                jh += 5;
            else
            if(ih > 50)
                jh++;
            else
            if(ih > 20 && (ih & 5) == 0)
                jh++;
        } else
        {
            ih = 0;
            jh = 0;
        }
        if(super.V == 1)
            hh = 1;
        else
        if(super.V == 2)
            hh = 2;
        De.b(super.S, super.T);
        super.V = 0;
        if(Sd)
        {
            if(zi == 0 || be)
            {
                if(super.n)
                {
                    yi = yi + 1 & 7;
                    super.n = false;
                    if(!de)
                    {
                        if((yi & 1) == 0)
                            yi = yi + 1 & 7;
                        for(int k2 = 0; k2 < 8 && !bb(yi); k2++)
                            yi = yi + 1 & 7;

                    }
                }
                if(super.o)
                {
                    yi = yi + 7 & 7;
                    super.o = false;
                    if(!de)
                    {
                        if((yi & 1) == 0)
                            yi = yi + 7 & 7;
                        for(int l2 = 0; l2 < 8 && !bb(yi); l2++)
                            yi = yi + 7 & 7;

                    }
                }
            }
        } else
        if(super.n)
            tg = tg + 2 & 0xff;
        else
        if(super.o)
            tg = tg - 2 & 0xff;
        if(dc && cc)
            Cf += 3;
        if(dc)
            Cf += 3;
        if(cc)
            Cf -= 3;
        if(ac && bc && !super.g && Xf < 4500)
            Xf += 10;
        if(ac && !super.g && Xf < 4500)
            Xf += 10;
        if(bc && !super.g && Xf > 150)
            Xf -= 10;
        if(super.h)
            vc += 20;
        if(super.i)
            vc -= 20;
        if(ac && super.g)
            wc += 20;
        if(bc && super.g)
            wc -= 20;
        if(bc && ac && super.g)
            wc -= 10;
        if(super.h && super.i)
            vc -= 10;
        if(ic)
            xc += 10;
        if(jc)
            xc -= 10;
        if(ic && jc)
            xc -= 5;
        if(Rf > 0)
            Rf--;
        else
        if(Rf < 0)
            Rf++;
        De.g(17);
        Ni++;
        if(Ni > 5)
        {
            Ni = 0;
            sh = (sh + 1) % 3;
            th = (th + 1) % 4;
            uh = (uh + 1) % 5;
        }
        for(int i3 = 0; i3 < Yg; i3++)
        {
            int i4 = Dj[i3];
            int i5 = Ej[i3];
            if(i4 >= 0 && i5 >= 0 && i4 < 96 && i5 < 96 && Fj[i3] == 74)
                Ve[i3].d(1, 0, 0);
        }

        for(int j3 = 0; j3 < oh; j3++)
        {
            yk[j3]++;
            if(yk[j3] <= 50)
                continue;
            oh--;
            for(int j4 = j3; j4 < oh; j4++)
            {
                Zj[j4] = Zj[j4 + 1];
                hk[j4] = hk[j4 + 1];
                yk[j4] = yk[j4 + 1];
                tj[j4] = tj[j4 + 1];
            }

        }

    }

    public boolean a(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, 
            boolean flag1)
    {
        int k2 = f.J;
        int l2 = Ee.a(i1, j1, k1, l1, i2, j2, qk, rk, flag);
        if(l2 == -1)
            if(flag1)
            {
                l2 = 1;
                qk[0] = k1;
                rk[0] = l1;
            } else
            {
                return false;
            }
        l2--;
        i1 = qk[l2];
        j1 = rk[l2];
        l2--;
        if(flag1)
            super.nb.a(230);
        else
            super.nb.a(21);
        super.nb.e(i1 + Qg);
        super.nb.e(j1 + Rg);
        if(flag1 && l2 == -1 && (i1 + Qg) % 5 == 0)
            l2 = 0;
        for(int i3 = l2; i3 >= 0 && i3 > l2 - 25; i3--)
        {
            super.nb.f(qk[i3] - i1);
            super.nb.f(rk[i3] - j1);
        }

        super.nb.i();
        Rf = -24;
        Sf = super.S;
        Tf = super.T;
        return true;
    }

    public boolean b(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, 
            boolean flag1)
    {
        int k2 = f.J;
        int l2 = Ee.a(i1, j1, k1, l1, i2, j2, qk, rk, flag);
        if(l2 == -1)
            return false;
        l2--;
        i1 = qk[l2];
        j1 = rk[l2];
        l2--;
        if(flag1)
            super.nb.a(230);
        else
            super.nb.a(21);
        super.nb.e(i1 + Qg);
        super.nb.e(j1 + Rg);
        if(flag1 && l2 == -1 && (i1 + Qg) % 5 == 0)
            l2 = 0;
        for(int i3 = l2; i3 >= 0 && i3 > l2 - 25; i3--)
        {
            super.nb.f(qk[i3] - i1);
            super.nb.f(rk[i3] - j1);
        }

        super.nb.i();
        Rf = -24;
        Sf = super.S;
        Tf = super.T;
        return true;
    }

    public void pb()
    {
        try
        {
            if(Xe != null)
            {
                Xe.e();
                Xe.A = null;
                Xe = null;
            }
            if(De != null)
            {
                De.a();
                De = null;
            }
            We = null;
            Ve = null;
            Ue = null;
            He = null;
            Ke = null;
            Je = null;
            Fe = null;
            Le = null;
            if(Ee != null)
            {
                Ee.p = null;
                Ee.r = (u[][])null;
                Ee.q = (u[][])null;
                Ee.s = null;
                Ee = null;
            }
            System.gc();
            return;
        }
        catch(Exception exception)
        {
            return;
        }
    }

    public void qb()
    {
        int i1 = f.J;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = a(Dk[755] + p.h + Dk[497], Dk[753], 30);
        if(abyte0 == null)
        {
            te = true;
            return;
        }
        abyte1 = m.a(Dk[507], 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(re)
        {
            abyte2 = a(Dk[755] + p.h + Dk[283], Dk[754], 45);
            if(abyte2 == null)
            {
                te = true;
                return;
            }
            abyte3 = m.a(Dk[507], 0, abyte2);
        }
        int j1 = 0;
        Ai = 0;
        Bi = Ai;
label0:
        for(int k1 = 0; k1 < f.F; k1++)
        {
            String s1 = f.v[k1];
            for(int l1 = 0; l1 < k1; l1++)
                if(f.v[l1].equalsIgnoreCase(s1))
                {
                    f.Fb[k1] = f.Fb[l1];
                    continue label0;
                }

            byte abyte4[] = m.a(s1 + Dk[510], 0, abyte0);
            byte abyte5[] = abyte1;
            if(abyte4 == null && re)
            {
                abyte4 = m.a(s1 + Dk[510], 0, abyte2);
                abyte5 = abyte3;
            }
            if(abyte4 != null)
            {
                Xe.a(Bi, abyte4, abyte5, 15);
                j1 += 15;
                if(f.Db[k1] == 1)
                {
                    byte abyte6[] = m.a(s1 + Dk[752], 0, abyte0);
                    byte abyte8[] = abyte1;
                    if(abyte6 == null && re)
                    {
                        abyte6 = m.a(s1 + Dk[752], 0, abyte2);
                        abyte8 = abyte3;
                    }
                    Xe.a(Bi + 15, abyte6, abyte8, 3);
                    j1 += 3;
                }
                if(f.Eb[k1] == 1)
                {
                    byte abyte7[] = m.a(s1 + Dk[756], 0, abyte0);
                    byte abyte9[] = abyte1;
                    if(abyte7 == null && re)
                    {
                        abyte7 = m.a(s1 + Dk[756], 0, abyte2);
                        abyte9 = abyte3;
                    }
                    Xe.a(Bi + 18, abyte7, abyte9, 9);
                    j1 += 9;
                }
                if(f.Cb[k1] != 0)
                {
                    for(int i2 = Bi; i2 < Bi + 27; i2++)
                        Xe.b(i2);

                }
            }
            f.Fb[k1] = Bi;
            Bi += 27;
        }

    }

    public void rb()
    {
        int i1 = f.J;
        if(hh != 0 && jh == 0)
            jh = 1;
        if(jh > 0)
        {
            int j1 = super.S - 22;
            int k1 = super.T - 36;
            if(j1 >= 0 && k1 >= 0 && j1 < 468 && k1 < 262)
            {
                if(j1 > 216 && k1 > 30 && j1 < 462 && k1 < 235)
                {
                    int l1 = (j1 - 217) / 49 + ((k1 - 31) / 34) * 5;
                    if(l1 >= 0 && l1 < pg)
                    {
                        boolean flag1 = false;
                        int i3 = 0;
                        int k5 = lj[l1];
label0:
                        for(int l6 = 0; l6 < ji; l6++)
                        {
                            if(fk[l6] != k5)
                                continue;
                            if(f.lb[k5] == 0)
                            {
                                int i8 = 0;
                                do
                                {
                                    if(i8 >= jh)
                                        continue label0;
                                    if(gk[l6] < mj[l1])
                                        gk[l6]++;
                                    flag1 = true;
                                    i8++;
                                } while(true);
                            }
                            i3++;
                        }

                        if(db(k5) <= i3)
                            flag1 = true;
                        if(f.pb[k5] == 1)
                        {
                            a(Dk[293], 3);
                            flag1 = true;
                        }
                        if(!flag1 && ji < 8)
                        {
                            fk[ji] = k5;
                            gk[ji] = 1;
                            ji++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.nb.a(154);
                            super.nb.f(ji);
                            for(int i7 = 0; i7 < ji; i7++)
                            {
                                super.nb.e(fk[i7]);
                                super.nb.b(gk[i7]);
                            }

                            super.nb.i();
                            Od = false;
                            Pd = false;
                        }
                    }
                }
                if(j1 > 8 && k1 > 30 && j1 < 205 && k1 < 129)
                {
                    int i2 = (j1 - 9) / 49 + ((k1 - 31) / 34) * 4;
                    if(i2 >= 0 && i2 < ji)
                    {
                        int k2 = fk[i2];
                        int j3 = 0;
                        do
                        {
                            if(j3 >= jh)
                                break;
                            if(f.lb[k2] == 0 && gk[i2] > 1)
                            {
                                gk[i2]--;
                            } else
                            {
                                ji--;
                                ih = 0;
                                for(int l5 = i2; l5 < ji; l5++)
                                {
                                    fk[l5] = fk[l5 + 1];
                                    gk[l5] = gk[l5 + 1];
                                }

                                break;
                            }
                            j3++;
                        } while(true);
                        super.nb.a(154);
                        super.nb.f(ji);
                        for(int k3 = 0; k3 < ji; k3++)
                        {
                            super.nb.e(fk[k3]);
                            super.nb.b(gk[k3]);
                        }

                        super.nb.i();
                        Od = false;
                        Pd = false;
                    }
                }
                boolean flag = false;
                if(j1 >= 93 && k1 >= 221 && j1 <= 104 && k1 <= 232)
                {
                    Vd = !Vd;
                    flag = true;
                }
                if(j1 >= 93 && k1 >= 240 && j1 <= 104 && k1 <= 251)
                {
                    Wd = !Wd;
                    flag = true;
                }
                if(j1 >= 191 && k1 >= 221 && j1 <= 202 && k1 <= 232)
                {
                    Xd = !Xd;
                    flag = true;
                }
                if(j1 >= 191 && k1 >= 240 && j1 <= 202 && k1 <= 251)
                {
                    Yd = !Yd;
                    flag = true;
                }
                if(flag)
                {
                    super.nb.a(10);
                    super.nb.f(Vd ? 1 : 0);
                    super.nb.f(Wd ? 1 : 0);
                    super.nb.f(Xd ? 1 : 0);
                    super.nb.f(Yd ? 1 : 0);
                    super.nb.i();
                    Od = false;
                    Pd = false;
                }
                if(j1 >= 217 && k1 >= 238 && j1 <= 286 && k1 <= 259)
                {
                    Pd = true;
                    super.nb.a(245);
                    super.nb.i();
                }
                if(j1 >= 394 && k1 >= 238 && j1 < 463 && k1 < 259)
                {
                    se = false;
                    super.nb.a(82);
                    super.nb.i();
                }
            } else
            if(hh != 0)
            {
                se = false;
                super.nb.a(82);
                super.nb.i();
            }
            hh = 0;
            jh = 0;
        }
        if(!se)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        Xe.b(byte0, byte1, 468, 12, 0xc90b1d);
        int j2 = 0x989898;
        Xe.a(byte0, byte1 + 12, 468, 18, j2, 160);
        Xe.a(byte0, byte1 + 30, 8, 248, j2, 160);
        Xe.a(byte0 + 205, byte1 + 30, 11, 248, j2, 160);
        Xe.a(byte0 + 462, byte1 + 30, 6, 248, j2, 160);
        Xe.a(byte0 + 8, byte1 + 99, 197, 24, j2, 160);
        Xe.a(byte0 + 8, byte1 + 192, 197, 23, j2, 160);
        Xe.a(byte0 + 8, byte1 + 258, 197, 20, j2, 160);
        Xe.a(byte0 + 216, byte1 + 235, 246, 43, j2, 160);
        int l2 = 0xd0d0d0;
        Xe.a(byte0 + 8, byte1 + 30, 197, 69, l2, 160);
        Xe.a(byte0 + 8, byte1 + 123, 197, 69, l2, 160);
        Xe.a(byte0 + 8, byte1 + 215, 197, 43, l2, 160);
        Xe.a(byte0 + 216, byte1 + 30, 246, 205, l2, 160);
        for(int l3 = 0; l3 < 3; l3++)
            Xe.b(byte0 + 8, byte1 + 30 + l3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            Xe.b(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int j4 = 0; j4 < 7; j4++)
            Xe.b(byte0 + 216, byte1 + 30 + j4 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                Xe.c(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
            if(k4 < 5)
                Xe.c(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
            Xe.c(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        Xe.b(byte0 + 8, byte1 + 215, 197, 0);
        Xe.b(byte0 + 8, byte1 + 257, 197, 0);
        Xe.c(byte0 + 8, byte1 + 215, 43, 0);
        Xe.c(byte0 + 204, byte1 + 215, 43, 0);
        Xe.c(Dk[297] + jf, byte0 + 1, byte1 + 10, 1, 0xffffff);
        Xe.c(Dk[287], byte0 + 9, byte1 + 27, 4, 0xffffff);
        Xe.c(Dk[291], byte0 + 9, byte1 + 120, 4, 0xffffff);
        Xe.c(Dk[286], byte0 + 9, byte1 + 212, 4, 0xffffff);
        Xe.c(Dk[284], byte0 + 216, byte1 + 27, 4, 0xffffff);
        Xe.c(Dk[292], byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        Xe.c(Dk[288], byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        Xe.c(Dk[290], byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        Xe.c(Dk[289], byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        Xe.c(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(Vd)
            Xe.b(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        Xe.c(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(Wd)
            Xe.b(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        Xe.c(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(Xd)
            Xe.b(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        Xe.c(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(Yd)
            Xe.b(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!Pd)
            Xe.c(byte0 + 217, byte1 + 238, Ei + 25);
        Xe.c(byte0 + 394, byte1 + 238, Ei + 26);
        if(Od)
        {
            Xe.b(Dk[296], byte0 + 341, byte1 + 246, 1, 0xffffff);
            Xe.b(Dk[295], byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(Pd)
        {
            Xe.b(Dk[294], byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            Xe.b(Dk[285], byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < pg; l4++)
        {
            int i6 = 217 + byte0 + (l4 % 5) * 49;
            int j7 = 31 + byte1 + (l4 / 5) * 34;
            Xe.a(i6, j7, 48, 32, Gi + f.jb[lj[l4]], f.ob[lj[l4]], 0, 0, false);
            if(f.lb[lj[l4]] == 0)
                Xe.c(String.valueOf(mj[l4]), i6 + 1, j7 + 10, 1, 0xffff00);
        }

        for(int i5 = 0; i5 < ji; i5++)
        {
            int j6 = 9 + byte0 + (i5 % 4) * 49;
            int k7 = 31 + byte1 + (i5 / 4) * 34;
            Xe.a(j6, k7, 48, 32, Gi + f.jb[fk[i5]], f.ob[fk[i5]], 0, 0, false);
            if(f.lb[fk[i5]] == 0)
                Xe.c(String.valueOf(gk[i5]), j6 + 1, k7 + 10, 1, 0xffff00);
            if(super.S > j6 && super.S < j6 + 48 && super.T > k7 && super.T < k7 + 32)
                Xe.c(Dk[62] + f.d[fk[i5]] + Dk[61] + f.e[fk[i5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < Mi; j5++)
        {
            int k6 = 9 + byte0 + (j5 % 4) * 49;
            int l7 = 124 + byte1 + (j5 / 4) * 34;
            Xe.a(k6, l7, 48, 32, Gi + f.jb[ok[j5]], f.ob[ok[j5]], 0, 0, false);
            if(f.lb[ok[j5]] == 0)
                Xe.c(String.valueOf(pk[j5]), k6 + 1, l7 + 10, 1, 0xffff00);
            if(super.S > k6 && super.S < k6 + 48 && super.T > l7 && super.T < l7 + 32)
                Xe.c(Dk[62] + f.d[ok[j5]] + Dk[61] + f.e[ok[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void sb()
    {
        Xe.b(126, 137, 260, 60, 0);
        Xe.c(126, 137, 260, 60, 0xffffff);
        Xe.b(Dk[201], 256, 173, 5, 0xffffff);
    }

    public void c(int i1, String s1)
    {
        int j1 = Dj[i1];
        int k1 = Ej[i1];
        int l1 = j1 - Le.g / 128;
        int i2 = k1 - Le.h / 128;
        byte byte0 = 7;
        if(j1 >= 0 && k1 >= 0 && j1 < 96 && k1 < 96 && l1 > -byte0 && l1 < byte0 && i2 > -byte0 && i2 < byte0)
        {
            De.b(Ve[i1]);
            int j2 = f.a(s1);
            u u1 = We[j2].i();
            De.a(u1);
            u1.a(true, 48, 48, -50, -10, -50);
            u1.a(Ve[i1]);
            u1.w = i1;
            Ve[i1] = u1;
        }
    }

    public void tb()
    {
        int i1 = f.J;
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(hh != 0)
        {
            int j1 = 0;
            do
            {
                if(j1 >= 5)
                    break;
                if(j1 > 0 && super.S > 7 && super.S < 100 && super.T > byte1 + j1 * 20 && super.T < byte1 + j1 * 20 + 20)
                {
                    Cg = j1 - 1;
                    pc = j1 - 1;
                    if(!Cc)
                        Ic = j1 - 1;
                    hh = 0;
                    super.nb.a(119);
                    super.nb.f(Cg);
                    super.nb.i();
                    System.out.println(Dk[722] + Cg + ")");
                    break;
                }
                j1++;
            } while(true);
        }
        for(int k1 = 1; k1 < 5; k1++)
        {
            if(k1 == Cg + 1)
                Xe.a(byte0, byte1 + k1 * 20, 90, 20, v.b(190, 190, 190), 88);
            else
                Xe.a(byte0, byte1 + k1 * 20, 90, 20, v.b(100, 100, 100), 88);
            Xe.b(byte0, byte1 + k1 * 20, 90, 0);
            Xe.b(byte0, byte1 + k1 * 20 + 20, 90, 0);
        }

        Xe.b(Dk[746], 50, byte1 + 36, 3, 0);
        Xe.b(Dk[745], 50, byte1 + 56, 3, 0);
        Xe.b(Dk[744], 50, byte1 + 76, 3, 0);
        Xe.b(Dk[747], 50, byte1 + 96, 3, 0);
    }

    public void ub()
    {
        int i1 = f.J;
        if(fh >= 0 || Ig >= 0)
        {
            zf[Hg] = Dk[160];
            sf[Hg] = "";
            ak[Hg] = 4000;
            Hg++;
        }
        for(int j1 = 0; j1 < Hg; j1++)
            Bk[j1] = j1;

        boolean flag = false;
        while(!flag) 
        {
            flag = true;
            int l1 = 0;
            while(l1 < Hg - 1) 
            {
                int j2 = Bk[l1];
                int l2 = Bk[l1 + 1];
                if(ak[j2] > ak[l2])
                {
                    Bk[l1] = l2;
                    Bk[l1 + 1] = j2;
                    flag = false;
                }
                l1++;
            }
        }
        if(Hg > 20)
            Hg = 20;
        if(Hg > 0)
        {
            int k1 = -1;
            int i2 = 0;
            do
            {
                if(i2 >= Hg)
                    break;
                if(sf[Bk[i2]] != null && sf[Bk[i2]].length() > 0)
                {
                    k1 = i2;
                    break;
                }
                i2++;
            } while(true);
            String s1 = null;
            if((Ig >= 0 || fh >= 0) && Hg == 1)
                s1 = Dk[533];
            else
            if((Ig >= 0 || fh >= 0) && Hg > 1)
                s1 = Dk[222] + zf[Bk[0]] + " " + sf[Bk[0]];
            else
            if(k1 != -1)
                s1 = sf[Bk[k1]] + Dk[529] + zf[Bk[0]];
            if(Hg == 2 && s1 != null)
                s1 = s1 + Dk[535];
            if(Hg > 2 && s1 != null)
                s1 = s1 + Dk[534] + (Hg - 1) + Dk[531];
            if(s1 != null)
                Xe.c(s1, 6, 14, 1, 0xffff00);
            if(!ce && hh == 1 || ce && hh == 1 && Hg == 1)
            {
                fb(Bk[0]);
                hh = 0;
                return;
            }
            if(!ce && hh == 2 || ce && hh == 1)
            {
                Gg = (Hg + 1) * 15;
                Fg = Xe.a(Dk[532], 1) + 5;
                for(int k2 = 0; k2 < Hg; k2++)
                {
                    int i3 = Xe.a(zf[k2] + " " + sf[k2], 1) + 5;
                    if(i3 > Fg)
                        Fg = i3;
                }

                Dg = super.S - Fg / 2;
                Eg = super.T - 7;
                ke = true;
                if(Dg < 0)
                    Dg = 0;
                if(Eg < 0)
                    Eg = 0;
                if(Dg + Fg > 510)
                    Dg = 510 - Fg;
                if(Eg + Gg > 315)
                    Eg = 315 - Gg;
                hh = 0;
            }
        }
    }

    public void vb()
    {
        int i1 = f.J;
        byte byte0 = 22;
        byte byte1 = 36;
        Xe.b(byte0, byte1, 468, 16, 192);
        int j1 = 0x989898;
        Xe.a(byte0, byte1 + 16, 468, 246, j1, 160);
        Xe.b(Dk[523] + m.a(Ze), byte0 + 234, byte1 + 12, 1, 0xffffff);
        Xe.b(Dk[517], byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int k1 = 0; k1 < rh; k1++)
        {
            String s1 = f.d[Xj[k1]];
            if(f.lb[Xj[k1]] == 0)
                s1 = s1 + Dk[519] + cb(Yj[k1]);
            Xe.b(s1, byte0 + 117, byte1 + 42 + k1 * 12, 1, 0xffffff);
        }

        if(rh == 0)
            Xe.b(Dk[518], byte0 + 117, byte1 + 42, 1, 0xffffff);
        Xe.b(Dk[516], byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int l1 = 0; l1 < ag; l1++)
        {
            String s2 = f.d[jj[l1]];
            if(f.lb[jj[l1]] == 0)
                s2 = s2 + Dk[519] + cb(kj[l1]);
            Xe.b(s2, byte0 + 351, byte1 + 42 + l1 * 12, 1, 0xffffff);
        }

        if(ag == 0)
            Xe.b(Dk[518], byte0 + 351, byte1 + 42, 1, 0xffffff);
        Xe.b(Dk[520], byte0 + 234, byte1 + 200, 4, 65535);
        Xe.b(Dk[524], byte0 + 234, byte1 + 215, 1, 0xffffff);
        Xe.b(Dk[522], byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!Rd)
        {
            Xe.c((byte0 + 118) - 35, byte1 + 238, Ei + 25);
            Xe.c((byte0 + 352) - 35, byte1 + 238, Ei + 26);
        } else
        {
            Xe.b(Dk[521], byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(hh == 1)
        {
            if(super.S < byte0 || super.T < byte1 || super.S > byte0 + 468 || super.T > byte1 + 262)
            {
                Qd = false;
                super.nb.a(178);
                super.nb.i();
            }
            if(super.S >= (byte0 + 118) - 35 && super.S <= byte0 + 118 + 70 && super.T >= byte1 + 238 && super.T <= byte1 + 238 + 21)
            {
                Rd = true;
                super.nb.a(65);
                super.nb.i();
            }
            if(super.S >= (byte0 + 352) - 35 && super.S <= byte0 + 353 + 70 && super.T >= byte1 + 238 && super.T <= byte1 + 238 + 21)
            {
                Qd = false;
                super.nb.a(178);
                super.nb.i();
            }
            hh = 0;
        }
    }

    public void fb(int i1)
    {
        int j1 = jk[i1];
        int k1 = kk[i1];
        int l1 = Oj[i1];
        int i2 = Pj[i1];
        int j2 = Qj[i1];
        int k2 = ak[i1];
        if(k2 == 200)
        {
            a(Ri, Si, j1, k1, true);
            super.nb.a(31);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[29] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 210)
        {
            a(Ri, Si, j1, k1, true);
            super.nb.a(70);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            Ig = -1;
            System.out.println(Dk[11] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 220)
        {
            a(Ri, Si, j1, k1, true);
            super.nb.a(104);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            System.out.println(Dk[41] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 3200)
        {
            a(f.e[l1], 3);
            System.out.println(Dk[19] + l1 + ")");
        }
        if(k2 == 300)
        {
            d(j1, k1, l1);
            super.nb.a(48);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.f(l1);
            super.nb.e(i2);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[16] + i2 + "," + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 310)
        {
            d(j1, k1, l1);
            super.nb.a(167);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.f(l1);
            super.nb.e(i2);
            super.nb.i();
            Ig = -1;
            System.out.println(Dk[39] + i2 + "," + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 320)
        {
            d(j1, k1, l1);
            super.nb.a(114);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.f(l1);
            super.nb.i();
            System.out.println(Dk[34] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 2300)
        {
            d(j1, k1, l1);
            super.nb.a(163);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.f(l1);
            super.nb.i();
            System.out.println(Dk[12] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 3300)
        {
            a(f.s[l1], 3);
            System.out.println(Dk[19] + l1 + ")");
        }
        if(k2 == 400)
        {
            b(j1, k1, l1, i2);
            super.nb.a(14);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(j2);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[42] + j2 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 410)
        {
            b(j1, k1, l1, i2);
            super.nb.a(153);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(j2);
            super.nb.i();
            System.out.println(Dk[39] + j2 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
            Ig = -1;
        }
        if(k2 == 420)
        {
            b(j1, k1, l1, i2);
            super.nb.a(90);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.i();
            System.out.println(Dk[22] + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 2400)
        {
            b(j1, k1, l1, i2);
            super.nb.a(227);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.i();
            System.out.println(Dk[43] + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 3400)
        {
            a(f.x[l1], 3);
            System.out.println(Dk[19] + l1 + ")");
        }
        if(k2 == 600)
        {
            super.nb.a(159);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            System.out.println(Dk[10] + i2 + "," + l1 + ")");
            fh = -1;
        }
        if(k2 == 610)
        {
            super.nb.a(172);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            System.out.println(Dk[36] + i2 + "," + l1 + ")");
            Ig = -1;
        }
        if(k2 == 620)
        {
            super.nb.a(170);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[40] + l1 + ")");
        }
        if(k2 == 630)
        {
            super.nb.a(12);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[30] + l1 + ")");
        }
        if(k2 == 640)
        {
            super.nb.a(219);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[20] + l1 + ")");
        }
        if(k2 == 650)
        {
            Ig = l1;
            ki = 0;
            gf = f.d[lj[Ig]];
            System.out.println(Dk[24] + l1 + ")");
        }
        if(k2 == 660)
        {
            super.nb.a(196);
            super.nb.e(l1);
            super.nb.i();
            Ig = -1;
            ki = 0;
            System.out.println(Dk[31] + l1 + ")");
        }
        if(k2 == 3600)
        {
            a(f.e[l1], 3);
            System.out.println(Dk[19] + l1 + ")");
        }
        if(k2 == 700)
        {
            int l2 = (j1 - 64) / Ci;
            int l4 = (k1 - 64) / Ci;
            b(Ri, Si, l2, l4, true);
            super.nb.a(49);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[35] + i2 + "," + l1 + ")");
        }
        if(k2 == 710)
        {
            int i3 = (j1 - 64) / Ci;
            int i5 = (k1 - 64) / Ci;
            b(Ri, Si, i3, i5, true);
            super.nb.a(160);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            Ig = -1;
            System.out.println(Dk[26] + i2 + "," + l1 + ")");
        }
        if(k2 == 720)
        {
            int j3 = (j1 - 64) / Ci;
            int j5 = (k1 - 64) / Ci;
            b(Ri, Si, j3, j5, true);
            super.nb.a(7);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[38] + l1 + ")");
        }
        if(k2 == 725)
        {
            int k3 = (j1 - 64) / Ci;
            int k5 = (k1 - 64) / Ci;
            b(Ri, Si, k3, k5, true);
            super.nb.a(151);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[9] + l1 + ")");
        }
        if(k2 == 715 || k2 == 2715)
        {
            int l3 = (j1 - 64) / Ci;
            int l5 = (k1 - 64) / Ci;
            b(Ri, Si, l3, l5, true);
            super.nb.a(47);
            super.nb.e(l1);
            super.nb.i();
            if(!Cc)
                System.out.println(Dk[37] + l1 + ")");
        }
        if(k2 == 3700)
        {
            a(f.l[l1], 3);
            System.out.println(Dk[27] + l1 + ")");
        }
        if(k2 == 4300)
        {
            System.out.println(Dk[17] + l1 + ")");
            ab.a(Dk[14] + l1);
            Dc = l1;
            Md = false;
        }
        if(k2 == 800)
        {
            int i4 = (j1 - 64) / Ci;
            int i6 = (k1 - 64) / Ci;
            b(Ri, Si, i4, i6, true);
            super.nb.a(169);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[23] + i2 + "," + l1 + ")");
        }
        if(k2 == 810)
        {
            int j4 = (j1 - 64) / Ci;
            int j6 = (k1 - 64) / Ci;
            b(Ri, Si, j4, j6, true);
            super.nb.a(177);
            super.nb.e(l1);
            super.nb.e(i2);
            super.nb.i();
            Ig = -1;
            System.out.println(Dk[8] + i2 + "," + l1 + ")");
        }
        if(k2 == 805 || k2 == 2805)
        {
            int k4 = (j1 - 64) / Ci;
            int k6 = (k1 - 64) / Ci;
            b(Ri, Si, k4, k6, true);
            super.nb.a(210);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[13] + l1 + ")");
        }
        if(k2 == 2806)
        {
            super.nb.a(89);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[33] + l1 + ")");
        }
        if(k2 == 2810)
        {
            super.nb.a(250);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[21] + l1 + ")");
        }
        if(k2 == 2820)
        {
            super.nb.a(36);
            super.nb.e(l1);
            super.nb.i();
            System.out.println(Dk[25] + l1 + ")");
        }
        if(k2 == 9999)
        {
            System.out.println(Dk[28] + l1 + ")");
            ab.a(Dk[44] + l1);
        }
        if(k2 == 900)
        {
            b(Ri, Si, j1, k1, true);
            super.nb.a(220);
            super.nb.e(j1 + Qg);
            super.nb.e(k1 + Rg);
            super.nb.e(l1);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[32] + l1 + "," + (j1 + Qg) + "," + (k1 + Rg) + ")");
        }
        if(k2 == 920)
        {
            b(Ri, Si, j1, k1, false);
            if(Rf == -24)
                Rf = 24;
            if(!Sc)
                System.out.println(Dk[7] + (zc + Qg) + "," + (Ac + Rg) + ")");
            Sc = false;
        }
        if(k2 == 1000)
        {
            super.nb.a(156);
            super.nb.e(l1);
            super.nb.i();
            fh = -1;
            System.out.println(Dk[18] + l1 + ")");
        }
        if(k2 == 4000)
        {
            Ig = -1;
            fh = -1;
            System.out.println(Dk[15]);
        }
    }

    public void wb()
    {
        Oe = new t(Xe, 10);
        Kg = Oe.a(5, 269, 502, 56, 1, 20, true);
        Lg = Oe.a(7, 324, 498, 14, 1, 80, false, true);
        Mg = Oe.a(5, 269, 502, 56, 1, 20, true);
        Ng = Oe.a(5, 269, 502, 56, 1, 20, true);
        Oe.h(Lg);
    }

    public void xb()
    {
        Ee.e = a(Dk[674] + p.d + Dk[497], Dk[678], 70);
        if(re)
            Ee.g = a(Dk[674] + p.d + Dk[283], Dk[675], 75);
        Ee.d = a(Dk[676] + p.d + Dk[497], Dk[677], 80);
        if(re)
            Ee.f = a(Dk[676] + p.d + Dk[283], Dk[673], 85);
    }

    void d(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = f.J;
        r r1 = Ke[i2];
        if(r1.y == 255)
            return;
        int i3 = r1.k + (tg + 16) / 32 & 7;
        boolean flag = false;
        int j3 = i3;
        if(j3 == 5)
        {
            j3 = 3;
            flag = true;
        } else
        if(j3 == 6)
        {
            j3 = 2;
            flag = true;
        } else
        if(j3 == 7)
        {
            j3 = 1;
            flag = true;
        }
        int k3 = j3 * 3 + rj[(r1.j / 6) % 4];
        if(r1.k == 8)
        {
            j3 = 5;
            i3 = 2;
            flag = false;
            i1 -= (5 * k2) / 100;
            k3 = j3 * 3 + lk[(mi / 5) % 8];
        } else
        if(r1.k == 9)
        {
            j3 = 5;
            i3 = 2;
            flag = true;
            i1 += (5 * k2) / 100;
            k3 = j3 * 3 + ek[(mi / 6) % 8];
        }
        for(int l3 = 0; l3 < 12; l3++)
        {
            int l4 = Ck[i3][l3];
            int k5 = r1.I[l4] - 1;
            if(k5 < 0)
                continue;
            int i6 = 0;
            int j6 = 0;
            int k6 = k3;
            if(flag && j3 >= 1 && j3 <= 3)
                if(f.Eb[k5] == 1)
                    k6 += 15;
                else
                if(l4 == 4 && j3 == 1)
                {
                    i6 = -22;
                    j6 = -3;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                } else
                if(l4 == 4 && j3 == 2)
                {
                    i6 = 0;
                    j6 = -8;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                } else
                if(l4 == 4 && j3 == 3)
                {
                    i6 = 26;
                    j6 = -5;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                } else
                if(l4 == 3 && j3 == 1)
                {
                    i6 = 22;
                    j6 = 3;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                } else
                if(l4 == 3 && j3 == 2)
                {
                    i6 = 0;
                    j6 = 8;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                } else
                if(l4 == 3 && j3 == 3)
                {
                    i6 = -26;
                    j6 = 5;
                    k6 = j3 * 3 + rj[(2 + r1.j / 6) % 4];
                }
            if(j3 == 5 && f.Db[k5] != 1)
                continue;
            int l6 = k6 + f.Fb[k5];
            i6 = (i6 * k1) / ((v) (Xe)).F[l6];
            j6 = (j6 * l1) / ((v) (Xe)).G[l6];
            int i7 = (k1 * ((v) (Xe)).F[l6]) / ((v) (Xe)).F[f.Fb[k5]];
            i6 -= (i7 - k1) / 2;
            int j7 = f.Bb[k5];
            int k7 = Vj[r1.z];
            if(j7 == 1)
                j7 = bk[r1.w];
            else
            if(j7 == 2)
                j7 = Wj[r1.x];
            else
            if(j7 == 3)
                j7 = Wj[r1.y];
            Xe.a(i1 + i6, j1 + j6, i7, l1, l6, j7, k7, j2, flag);
        }

        if(r1.o > 0)
        {
            uk[kh] = Xe.a(r1.d, 1) / 2;
            if(uk[kh] > 150)
                uk[kh] = 150;
            vk[kh] = (Xe.a(r1.d, 1) / 300) * Xe.c(1);
            sk[kh] = i1 + k1 / 2;
            tk[kh] = j1;
            vf[kh++] = r1.d;
        }
        if(r1.q > 0)
        {
            Bj[Li] = i1 + k1 / 2;
            Cj[Li] = j1;
            pj[Li] = k2;
            qj[Li++] = r1.p;
        }
        if(r1.k == 8 || r1.k == 9 || r1.u != 0)
        {
            if(r1.u > 0)
            {
                int i4 = i1;
                if(r1.k == 8)
                    i4 -= (20 * k2) / 100;
                else
                if(r1.k == 9)
                    i4 += (20 * k2) / 100;
                int i5 = (r1.s * 30) / r1.t;
                gj[Jg] = i4 + k1 / 2;
                hj[Jg] = j1;
                ij[Jg++] = i5;
            }
            if(r1.u > 150)
            {
                int j4 = i1;
                if(r1.k == 8)
                    j4 -= (10 * k2) / 100;
                else
                if(r1.k == 9)
                    j4 += (10 * k2) / 100;
                Xe.c((j4 + k1 / 2) - 12, (j1 + l1 / 2) - 12, Ei + 11);
                Xe.b(String.valueOf(r1.r), (j4 + k1 / 2) - 1, j1 + l1 / 2 + 5, 3, 0xffffff);
            }
        }
        if(r1.F == 1 && r1.q == 0)
        {
            int k4 = j2 + i1 + k1 / 2;
            if(r1.k == 8)
                k4 -= (20 * k2) / 100;
            else
            if(r1.k == 9)
                k4 += (20 * k2) / 100;
            int j5 = (16 * k2) / 100;
            int l5 = (16 * k2) / 100;
            Xe.f(k4 - j5 / 2, j1 - l5 / 2 - (10 * k2) / 100, j5, l5, Ei + 13);
        }
    }

    public void k(String s1)
    {
        if(Df == null)
            return;
        if(je)
        {
            return;
        } else
        {
            Df.a(Ce, m.a(s1 + Dk[530], Ce), m.b(s1 + Dk[530], Ce));
            return;
        }
    }

    public boolean n(int i1, int j1)
    {
        int k1 = f.J;
        if(aj != 0)
        {
            Ee.c = false;
            return false;
        }
        Ud = false;
        i1 += bh;
        j1 += ch;
        if(eh == Sg && i1 > vh && i1 < xh && j1 > wh && j1 < yh)
        {
            Ee.c = true;
            return false;
        }
        Xe.b(Dk[202], 256, 192, 1, 0xffffff);
        fb();
        Xe.a(Ye, 0, 0);
        int l1 = Qg;
        int i2 = Rg;
        int j2 = (i1 + 24) / 48;
        int k2 = (j1 + 24) / 48;
        eh = Sg;
        Qg = j2 * 48 - 48;
        Rg = k2 * 48 - 48;
        vh = j2 * 48 - 32;
        wh = k2 * 48 - 32;
        xh = j2 * 48 + 32;
        yh = k2 * 48 + 32;
        Ee.d(i1, j1, eh);
        Qg -= bh;
        Rg -= ch;
        int l2 = Qg - l1;
        int i3 = Rg - i2;
        for(int j3 = 0; j3 < Yg;)
        {
            Dj[j3] -= l2;
            Ej[j3] -= i3;
            int k4 = Dj[j3];
            int i5 = Ej[j3];
            int i6 = Fj[j3];
            u u1 = Ve[j3];
            try
            {
                int l6 = Gj[j3];
                int i7;
                int j7;
                if(l6 == 0 || l6 == 4)
                {
                    i7 = f.sb[i6];
                    j7 = f.tb[i6];
                } else
                {
                    j7 = f.sb[i6];
                    i7 = f.tb[i6];
                }
                int k7 = ((k4 + k4 + i7) * Ci) / 2;
                int l7 = ((i5 + i5 + j7) * Ci) / 2;
                if(k4 < 0 || i5 < 0 || k4 >= 96 || i5 >= 96)
                    continue;
                De.a(u1);
                u1.g(k7, -Ee.g(k7, l7), l7);
                Ee.a(k4, i5, i6);
                if(i6 == 74)
                    u1.f(0, -480, 0);
                continue;
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println(Dk[204] + runtimeexception.getMessage());
                System.out.println(Dk[203] + j3 + Dk[206] + u1);
                runtimeexception.printStackTrace();
                j3++;
            }
        }

        for(int k3 = 0; k3 < Bh;)
        {
            zj[k3] -= l2;
            Aj[k3] -= i3;
            int l4 = zj[k3];
            int j5 = Aj[k3];
            int j6 = yj[k3];
            int k6 = xj[k3];
            try
            {
                Ee.b(l4, j5, k6, j6);
                u u2 = a(l4, j5, k6, j6, k3);
                Ue[k3] = u2;
                continue;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println(Dk[205] + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
                k3++;
            }
        }

        for(int l3 = 0; l3 < lh; l3++)
        {
            Hj[l3] -= l2;
            Ij[l3] -= i3;
        }

        for(int i4 = 0; i4 < xg; i4++)
        {
            r r1 = Ke[i4];
            r1.g -= l2 * Ci;
            r1.h -= i3 * Ci;
            for(int k5 = 0; k5 <= r1.n; k5++)
            {
                r1.G[k5] -= l2 * Ci;
                r1.H[k5] -= i3 * Ci;
            }

        }

        for(int j4 = 0; j4 < hi; j4++)
        {
            r r2 = Fe[j4];
            r2.g -= l2 * Ci;
            r2.h -= i3 * Ci;
            for(int l5 = 0; l5 <= r2.n; l5++)
            {
                r2.G[l5] -= l2 * Ci;
                r2.H[l5] -= i3 * Ci;
            }

        }

        Ee.c = true;
        return true;
    }

    public void b(int i1, int j1, int k1, int l1, boolean flag)
    {
        a(i1, j1, k1, l1, k1, l1, false, flag);
    }

    public Random Mb;
    Toolkit Nb;
    public File Ob;
    public int Pb;
    public int Qb;
    public int Rb;
    public int Sb;
    public int Tb;
    public int Ub;
    public String Vb;
    public String Wb;
    public String Xb;
    public String Yb;
    public String Zb;
    public boolean ac;
    public boolean bc;
    public boolean cc;
    public boolean dc;
    public boolean ec;
    public boolean fc;
    public boolean gc;
    public boolean hc;
    public boolean ic;
    public boolean jc;
    public boolean kc;
    public boolean lc;
    public boolean mc;
    public boolean nc;
    public Calendar oc;
    public int pc;
    public int qc;
    public String rc;
    public String sc;
    public String tc;
    public boolean uc;
    public int vc;
    public int wc;
    public int xc;
    public int yc;
    public int zc;
    public int Ac;
    public eb Bc;
    public boolean Cc;
    public int Dc;
    public int Ec;
    public boolean Fc;
    public int Gc;
    public int Hc;
    public int Ic;
    public int Jc;
    public int Kc;
    public gb Lc;
    public fb Mc;
    public ib Nc;
    public String Oc;
    public hb Pc;
    public int Qc;
    public int Rc;
    public boolean Sc;
    public boolean Tc;
    public boolean Uc;
    public boolean Vc;
    public boolean Wc;
    public boolean Xc;
    public boolean Yc;
    public boolean Zc;
    public boolean ad;
    public boolean bd;
    public boolean cd;
    public boolean dd;
    public boolean ed;
    public boolean fd;
    public String gd;
    public String hd;
    public String id;
    public String jd;
    public String kd;
    public String ld;
    public String md;
    public String nd;
    public String od;
    public int pd;
    public int qd;
    public int rd;
    public int sd;
    public int td;
    public int ud;
    public int vd;
    public int wd;
    public int xd;
    public int yd;
    public int zd;
    public int Ad;
    public int Bd;
    public int Cd;
    public int Dd;
    public int Ed;
    public int Fd;
    public int Gd;
    public int Hd;
    public int Id;
    public int Jd;
    public int Kd;
    public boolean Ld;
    public boolean Md;
    public boolean Nd;
    public boolean Od;
    public boolean Pd;
    public boolean Qd;
    public boolean Rd;
    public boolean Sd;
    public boolean Td;
    public boolean Ud;
    public boolean Vd;
    public boolean Wd;
    public boolean Xd;
    public boolean Yd;
    public boolean Zd;
    public boolean ae;
    public boolean be;
    public boolean ce;
    public boolean de;
    public boolean ee;
    public boolean fe;
    public boolean ge;
    public boolean he;
    public boolean ie;
    public boolean je;
    public boolean ke;
    public boolean le;
    public boolean me;
    public boolean ne;
    public boolean oe;
    public boolean pe;
    public boolean qe;
    public boolean re;
    public boolean se;
    public boolean te;
    public boolean ue;
    public boolean ve;
    public boolean we;
    public boolean xe;
    public boolean ye[];
    public boolean ze[];
    public boolean Ae[];
    public boolean Be[];
    public byte Ce[];
    public g De;
    public q Ee;
    public r Fe[];
    public r Ge[];
    public r He[];
    public r Ie[];
    public r Je[];
    public r Ke[];
    public r Le;
    public t Me;
    public t Ne;
    public t Oe;
    public t Pe;
    public t Qe;
    public t Re;
    public t Se;
    public t Te;
    public u Ue[];
    public u Ve[];
    public u We[];
    public w Xe;
    public Graphics Ye;
    public long Ze;
    public long af;
    long bf;
    public String cf;
    public String df;
    public String ef;
    public String ff;
    String gf;
    public String hf;
    public String jf;
    public String kf;
    public String lf;
    public String mf;
    public String nf;
    public String of;
    public static String pf;
    public static boolean qf;
    public String rf[];
    public String sf[];
    public String tf[];
    public String uf[];
    String vf[];
    public String wf[];
    public String xf[];
    public String yf[];
    public String zf[];
    public String Af[];
    public int Bf;
    public int Cf;
    public d Df;
    public int Ef;
    public int Ff;
    public int Gf;
    public int Hf;
    public int If;
    public int Jf;
    public int Kf;
    public int Lf;
    public int Mf;
    public int Nf;
    public int Of;
    public int Pf;
    public int Qf;
    public int Rf;
    int Sf;
    int Tf;
    public int Uf;
    public int Vf;
    public int Wf;
    public int Xf;
    public int Yf;
    public int Zf;
    public int ag;
    public int bg;
    public int cg;
    public int dg;
    public int eg;
    public int fg;
    public int gg;
    public int hg;
    public int ig;
    public int jg;
    public int kg;
    public int lg;
    public int mg;
    public int ng;
    public int og;
    public int pg;
    public int qg;
    public int rg;
    public int sg;
    public int tg;
    public int ug;
    public int vg;
    public int wg;
    public int xg;
    public int yg;
    public int zg;
    public int Ag;
    public int Bg;
    public int Cg;
    public int Dg;
    public int Eg;
    public int Fg;
    public int Gg;
    public int Hg;
    public int Ig;
    public int Jg;
    int Kg;
    int Lg;
    int Mg;
    int Ng;
    int Og;
    public int Pg;
    public int Qg;
    public int Rg;
    public int Sg;
    public int Tg;
    public int Ug;
    public int Vg;
    public int Wg;
    public int Xg;
    public int Yg;
    int Zg;
    int ah;
    public int bh;
    public int ch;
    public int dh;
    public int eh;
    public int fh;
    public int gh;
    public int hh;
    public int ih;
    public int jh;
    public int kh;
    public int lh;
    int mh;
    int nh;
    public int oh;
    public int ph;
    public int qh;
    public int rh;
    public int sh;
    public int th;
    public int uh;
    public int vh;
    public int wh;
    public int xh;
    public int yh;
    public int zh;
    public int Ah;
    public int Bh;
    public int Ch;
    public int Dh;
    public int Eh;
    public int Fh;
    public int Gh;
    public int Hh;
    public int Ih;
    public int Jh;
    public int Kh;
    public int Lh;
    public int Mh;
    public int Nh;
    public int Oh;
    public int Ph;
    public int Qh;
    public int Rh;
    public int Sh;
    public int Th;
    public int Uh;
    public int Vh;
    public int Wh;
    public int Xh;
    public int Yh;
    public int Zh;
    public int ai;
    public int bi;
    public int ci;
    public int di;
    public int ei;
    public int fi;
    public int gi;
    public int hi;
    public int ii;
    public int ji;
    public int ki;
    public int li;
    public int mi;
    public int ni;
    public int oi;
    public int pi;
    public int qi;
    public int ri;
    int si;
    int ti;
    public int ui;
    public int vi;
    public int wi;
    public int xi;
    public int yi;
    public int zi;
    public int Ai;
    public int Bi;
    public int Ci;
    public int Di;
    public int Ei;
    public int Fi;
    public int Gi;
    public int Hi;
    public int Ii;
    public int Ji;
    public int Ki;
    public int Li;
    public int Mi;
    public int Ni;
    public int Oi;
    public int Pi;
    public int Qi;
    int Ri;
    int Si;
    int Ti;
    public int Ui;
    public int Vi;
    public int Wi;
    public int Xi;
    public int Yi;
    public int Zi;
    public int aj;
    public int bj;
    public int cj;
    public int dj[];
    public int ej[];
    public int fj[];
    public int gj[];
    public int hj[];
    public int ij[];
    public int jj[];
    public int kj[];
    public int lj[];
    public int mj[];
    public int nj[];
    public int oj[];
    public int pj[];
    public int qj[];
    public int rj[] = {
        0, 1, 2, 1
    };
    public int sj[];
    public int tj[];
    public int uj[];
    public int vj[];
    public int wj[];
    public int xj[];
    public int yj[];
    public int zj[];
    public int Aj[];
    public int Bj[];
    public int Cj[];
    public int Dj[];
    public int Ej[];
    public int Fj[];
    public int Gj[];
    public int Hj[];
    public int Ij[];
    public int Jj[];
    public int Kj[];
    public int Lj[];
    public int Mj[];
    public int Nj[];
    public int Oj[];
    public int Pj[];
    public int Qj[];
    public int Rj[];
    public int Sj[];
    public int Tj[];
    public int Uj[];
    public int Vj[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public int Wj[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int Xj[];
    public int Yj[];
    public int Zj[];
    public int ak[];
    public int bk[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int ck[];
    public int dk[];
    public int ek[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int fk[];
    public int gk[];
    public int hk[];
    public int ik[];
    public int jk[];
    public int kk[];
    public int lk[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public int mk[];
    public int nk[];
    public int ok[];
    public int pk[];
    public int qk[];
    public int rk[];
    public int sk[];
    public int tk[];
    public int uk[];
    public int vk[];
    public int wk[];
    public int xk[];
    public int yk[];
    int zk[];
    int Ak[];
    public int Bk[];
    public int Ck[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };
    private static String Dk[];

    static 
    {
        String as[];
        as = new String[793];
        as[0] = "%\001X.06@i5\001";
        as[1] = "1\bJ.u\032\tX.:\000\031";
        as[2] = "\"\022B,4\006\005\013\022<\001\024D(,";
        as[3] = "3\fGz8\027\023X;2\027\023";
        as[4] = "#\025N)!R(B)!\035\022R";
        as[5] = ">/l\025\000&@f\037\033'";
        as[6] = "%\001X.06\"D\016";
        as[7] = "%\001G1\001\035H";
        as[8] = "'\023N\023!\027\r|3!\0320G;,\027\022\003";
        as[9] = "&\bN3#\027.{\031}";
        as[10] = "1\001X.\032\034)_?8Z";
        as[11] = "'\023N\023!\027\rd4\022\000\017^41;\024N7}";
        as[12] = "=\002A?6\006#D78\023\016O\033gZ";
        as[13] = "3\024_;6\0310G;,\027\022\003";
        as[14] = "!%g\024\0051@";
        as[15] = "1\001E90\036H\002";
        as[16] = "1\001X.\032\034/I00\021\024\032r";
        as[17] = "!\005G?6\006.{\031}";
        as[18] = "1\001X.\032\0343N63Z";
        as[19] = "7\030J7<\034\005\003";
        as[20] = ";\024N7\026\035\rF;;\026H";
        as[21] = "&\022J>0\"\fJ#0\000H";
        as[22] = "=\002A?6\006#D78\023\016O\030}";
        as[23] = "1\001X.\032\0340G;,\027\022\003";
        as[24] = "'\023Nr";
        as[25] = "4\017G6:\0050G;,\027\022\003";
        as[26] = "'\023N\023!\027\rd4\033\"#\003";
        as[27] = "7\030J7<\034\005e\n\026Z";
        as[28] = "!\005G?6\0060G;,\027\022\003";
        as[29] = "1\001X.\032\034'Y5 \034\004b.0\037H";
        as[30] = "%\tN61Z";
        as[31] = "6\022D*}";
        as[32] = "1\001X.\032\034'Y5 \034\004\003";
        as[33] = "6\025N6\005\036\001R?'Z";
        as[34] = "=\002A?6\006#D78\023\016O\033}";
        as[35] = "1\001X.\032\034.{\031}";
        as[36] = "'\023N\023!\027\r|3!\032)_?8Z";
        as[37] = "3\024_;6\031.{\031}";
        as[38] = "&\001G1\001\035.{\031}";
        as[39] = "'\023N\023!\027\rd4\032\020\nN9!Z";
        as[40] = " \005F5#\027H";
        as[41] = "&\001@?}";
        as[42] = "1\001X.\032\034/I00\021\024\003";
        as[43] = "=\002A?6\006#D78\023\016O\030gZ";
        as[44] = "!%g\n\03139n\bu";
        as[45] = "!,n\037\005;.lze";
        as[46] = ";\016H5'\000\005H.{\\N\013(0\006\022R";
        as[47] = "0!e\021\002;.o\025\002RQ";
        as[48] = "<0h\031\03534\013";
        as[49] = "!,n\037\005;.lzd";
        as[50] = "1\fD)0!\bD*}[";
        as[51] = "\002\022J#0\000\017M<";
        as[52] = "0!e\021\002;.o\025\002RP";
        as[53] = "3.x\r\020 -n\024\000RQ";
        as[54] = "!(d\n\002;.o\025\002RQ";
        as[55] = "\",j\003\020 #c\033\001R";
        as[56] = "?9h\022\024&@";
        as[57] = "3.x\r\020 -n\024\000RP";
        as[58] = "!(d\n\002;.o\025\002RP";
        as[59] = "'3n\bu";
        as[60] = "\002\022J#0\000\017E";
        as[61] = "/@";
        as[62] = "2\031N6\025)";
        as[63] = "1\fD)00\001E1}[";
        as[64] = "1\fD9>R\024D-0\000@\00370\037\002N(&[";
        as[65] = "6\005F5;R\023G;,\027\022";
        as[66] = "3\007B6<\006\031";
        as[67] = "%\bJ.u\033\023\013#:\007\022\013<4\004\017^(<\006\005\0137:\004\tNe";
        as[68] = "\"\022J#0\0";
        as[69] = "0\tD24\b\001Y>uZ\rN77\027\022Xs";
        as[70] = "4\tY?8\023\013B42";
        as[71] = "&\bNz\035\023\032N?9R#^6!RHF?8\020\005Y)|";
        as[72] = "!\rB.=\033\016L";
        as[73] = ";\r[z6\023\024H20\0";
        as[74] = "1\022J<!\033\016L";
        as[75] = "%\bJ.u\005\001Xz,\035\025Yz3\033\022X.u\002\005_)u\034\001F?j";
        as[76] = "%\bDz\"\023\023\013#:\007\022\013<<\000\023_z7\027\023_z3\000\tN41M";
        as[77] = "3\022F5 \0";
        as[78] = "!\bB?9\026@D<u3\022Y;#";
        as[79] = "!\005Jz\006\036\025Lz}\037\005F80\000\023\002";
        as[80] = "%\t_9=U\023\0132:\007\023Nz}\037\005F80\000\023\002";
        as[81] = "\"\tY;!\027GXz!\000\005J) \000\005";
        as[82] = "?\005Y6<\034GXz6\000\031X.4\036@\00370\037\002N(&[";
        as[83] = "'\016O?'\025\022D/;\026@[;&\001@\00370\037\002N(&[";
        as[84] = "%\bN(0R\027N(0R\031D/u\020\017Y4j";
        as[85] = " \001E=0\026";
        as[86] = "7\022E?&\006@_20R\003C36\031\005E";
        as[87] = "VM\006wx_M\006wx_M\006wx_M\006wx_M\006wx_M\006wx_M\006~";
        as[88] = "6\tL)<\006\005\013r8\027\rI?'\001I";
        as[89] = "=\002X?'\004\001_5'\013@Z/0\001\024\013r8\027\rI?'\001I";
        as[90] = "!\bN?%R(N(1\027\022\013r8\027\rI?'\001I";
        as[91] = "%\001_9=\006\017\\?'RHF?8\020\005Y)|";
        as[92] = "&\bNz>\034\tL2!U\023\013)\"\035\022O";
        as[93] = "4\fN.6\032\tE=";
        as[94] = "0\fJ9>R\013E32\032\024\f)u\024\017Y.'\027\023X";
        as[95] = "&\017^(<\001\024\013.'\023\020\013r8\027\rI?'\001I";
        as[96] = "\001\f\\5'\026N_\"!";
        as[97] = ">\005L?;\026GXz\004\007\005X.uZ\rN77\027\022Xs";
        as[98] = "%\bJ.u\005\001Xz!\032\005\01344\037\005\01353R\031D/'R\006B(&\006@X9=\035\017Ge";
        as[99] = ":\t_)";
        as[100] = "6\022^31\033\003\013(<\006\025J6uZ\rN77\027\022Xs";
        as[101] = ":\005Y5r\001@Z/0\001\024\013r8\027\rI?'\001I";
        as[102] = "%\bDz<\001@R5 \000@M;#\035\025Y3!\027@J9!\035\022\004;6\006\022N)&M";
        as[103] = "%\bDz\"\023\023\013#:\007\022\013<<\000\023_z7\035\031M(<\027\016Ou2\033\022G<'\033\005E>j";
        as[104] = "4\tL2!R!Y?;\023@\00370\037\002N(&[";
        as[105] = "8\025E=9\027@[5!\033\017Ez}\037\005F80\000\023\002";
        as[106] = "?\001L36";
        as[107] = "%\bJ.u\005\001Xz!\032\005\013<<\000\023_z6\035\r[/!\027\022\013=4\037\005\013#:\007@[/'\021\bJ)0\026_";
        as[108] = "%\t_9=U\023\013*:\006\tD4";
        as[109] = "1\017D1r\001@J)&\033\023_;;\006";
        as[110] = "?\025Y>0\000@f#&\006\005Y#uZ\rN77\027\022Xs";
        as[111] = "%\bDz<\001@R5 \000@M;#\035\025Y3!\027@H;'\006\017D4u\021\bJ(4\021\024N(j";
        as[112] = "&\bNz'\027\023_60\001\023\013==\035\023_";
        as[113] = "6\022J=:\034@X64\013\005Y";
        as[114] = "%\bDz<\001@R5 \000@M;#\035\025Y3!\027@F/&\033\003B;;M";
        as[115] = "5\017I6<\034@O3%\036\017F;6\013";
        as[116] = "&\022N?u5\016D70R6B69\023\007Nz}\037\005F80\000\023\002";
        as[117] = "%\bJ.u\033\023\013#:\007\022\013<4\004\017^(<\006\005\013,4\021\001_3:\034@X*:\006_";
        as[118] = "!\003D(%\033\017Ez6\023\024H20\000@\00370\037\002N(&[";
        as[119] = "4\tX2<\034\007\0139:\034\024N)!RHF?8\020\005Y)|";
        as[120] = "%\017D>6\007\024_3;\025";
        as[121] = "$\001F*<\000\005\013)9\023\031N(";
        as[122] = "4\tX2<\034\007";
        as[123] = "!\bB6:R\026B69\023\007Nz}\037\005F80\000\023\002";
        as[124] = "&\005F*9\027@D<u;\013D,uZ\rN77\027\022Xs";
        as[125] = "3\024_;6\031";
        as[126] = "%\bJ.u\005\001Xz,\035\025Yz3\033\022X.u\006\005J9=\027\022Xz;\023\rNe";
        as[127] = "%\bJ.u\033\023\013#:\007\022\013<4\004\017^(<\006\005\013<:\035\004\024";
        as[128] = "\"\fJ= \027@h3!\013@\00370\037\002N(&[";
        as[129] = "5\005Y.'\007\004N}&R#J.uZ\rN77\027\022Xs";
        as[130] = " \017F?:RF\013\020 \036\tN.";
        as[131] = "?\017E1r\001@M(<\027\016Oz}\037\005F80\000\023\002";
        as[132] = "%\005J*:\0340D-0\0";
        as[133] = "\"\022B46\027@j6<R\022N)6\007\005";
        as[134] = "1\017D1<\034\007";
        as[135] = "4\001F39\013@H(0\001\024\013r8\027\rI?'\001I";
        as[136] = "&\bB?#\033\016L";
        as[137] = ">\017X.u\021\t_#uZ\rN77\027\022Xs";
        as[138] = "%\bJ.u\033\023\013#:\007\022\013<4\004\017^(<\006\005\0138:\035\013\024";
        as[139] = "%\017D>6\007\024";
        as[140] = "%\001_?'\024\001G6u\003\025N)!RHF?8\020\005Y)|";
        as[141] = "%\bJ.u\033\023\013#:\007\022\013<4\006\bN(&R\rB>1\036\005\01344\037\005\024";
        as[142] = "6\005M?;\001\005";
        as[143] = "%\bJ.u\033\023\013#:\007\022\0137:\006\bN(&R\rJ31\027\016\01344\037\005\024";
        as[144] = "5\022J41R\024Y?0RHF?8\020\005Y)|";
        as[145] = "&\bNz\035\035\fRz\022\000\001B6uZ\rN77\027\022Xs";
        as[146] = "&\022B84\036@_5!\027\r\013r8\027\rI?'\001I";
        as[147] = ":\005Y89\023\027";
        as[148] = "6\027J(3R#J4;\035\016\013r8\027\rI?'\001I";
        as[149] = "%\bDz<\001@R5 \000@M;#\035\025Y3!\027@J/!\032\017Ye";
        as[150] = "6\017Y36U\023\013+ \027\023_";
        as[151] = "!\bN?%R\023C?4\000\005Y";
        as[152] = "!\024Y?;\025\024C";
        as[153] = "\0167J)!\027$i5\001RQ\005ju_@{24\006\005\013|u>\017Y7&\020\031\013&";
        as[154] = "%\005J*:\034!B7";
        as[155] = "?\tE3;\025";
        as[156] = "%\bJ.u\033\023\013#:\007\022\0137:\006\bN(&R\rB>1\036\005\01344\037\005\024";
        as[157] = "7\016_?'R\016J70R\024Dz4\026\004\013.:R\tL4:\000\005\0136<\001\024";
        as[158] = "7\016_?'R\016J70R\024Dz4\026\004\013.:R\006Y30\034\004Xz9\033\023_";
        as[159] = "2\020Y3\0252\003R;\025+\017^z!\027\fGz\0162\031N6\025R";
        as[160] = "1\001E90\036";
        as[161] = ">!x\016\005?@\177\025u";
        as[162] = "2\003R;\025/@";
        as[163] = "7\016_?'R\rN)&\023\007Nz!\035@X?;\026@_5u";
        as[164] = "4\017Lz\032\024@|;'R;k='\027 d4\025\005\bB\032\b";
        as[165] = "0\fD9>R\020Y3#\023\024Nz8\027\023X;2\027\023\013\001\025\000\005O\032\032\024\006k-=\033 v";
        as[166] = ">\005M.u1\fB9>R!_.4\021\013\013\001\025\025\022N\032\032\034 \\2<2=";
        as[167] = "0\fD9>R\024Y;1\027@Y?$\007\005X.&R;k='\027 d4\025\005\bB\032\b";
        as[168] = "2\002D.\0254\tL2!R-D>0R6B)<\020\fNzxR$B)4\020\fN>";
        as[169] = "0\fD9>R\003C;!R\rN)&\023\007N)u) L(02/E\032\"\032\tk\007";
        as[170] = "2\002D.\025:\tO?u5\022J*=\033\003XzxR%E;7\036\005O";
        as[171] = "1-oz\023;8f\033\005";
        as[172] = "4\tSz\030\023\020\013\n0\000\006N9!R.D(!\032";
        as[173] = ":\tO?u5\022J*=\033\003Xz\0162\022N>\025=\006M\032\"\032\tk\007";
        as[174] = ">\017L5 \006@B<u\034\017_z4\007\024D3;\025";
        as[175] = "0\fD9>R\004^?9R\022N+ \027\023_)u) Y?12/M<\025\005\bB\032\b";
        as[176] = "4\tSz\005\000\t];6\013@x?!\006\tE=&";
        as[177] = "2\002D.\025?\001[z\023\033\030N>";
        as[178] = "0\fD9>R\004^?9R\022N+ \027\023_)u) L(02/E\032\"\032\tk\007";
        as[179] = "2\002D.\025\"\022B,4\021\031\013)0\006\024B42\001@M3-\027\004";
        as[180] = "0\fD9>R\020Y3#\023\024Nz8\027\023X;2\027\023\013\001\025\025\022N\032\032\034 \\2<2=";
        as[181] = "1-oz\006&/{\t\026 ){\016";
        as[182] = "2\031N6\025%\001X.06\"D\016u!\005_.<\034\007X";
        as[183] = "!\024D*u1\025Y(0\034\024\013\t6\000\t[.";
        as[184] = "4\tL2!R-D>0R6B)<\020\fNz\0162\022N>\025=\006M\032\"\032\tk\007";
        as[185] = "2\002D.\0254\tL2!R-D>0R6B)<\020\fNzxR%E;7\036\005O";
        as[186] = "2\002D.\0254\017Lz\032\024@|;'RM\013\037;\023\002G?1";
        as[187] = "2\002D.\025:\tO?u5\022J*=\033\003XzxR$B)4\020\fN>";
        as[188] = "2\002D.\025>\005M.u\021\fB9>R\001_.4\021\013\013wu6\tX;7\036\005O";
        as[189] = "2\002D.\025>\005M.u\021\fB9>R\001_.4\021\013\013wu7\016J89\027\004";
        as[190] = "1\fB9>R\bN(0R\024Dz9\035\007D/!";
        as[191] = "2\031N6\025\"\022B,4\021\031\013\t0\006\024B42\001";
        as[192] = "0\fD9>R\024Y;1\027@Y?$\007\005X.&R;k(0\026 d<32\027C3\025/";
        as[193] = "0\fD9>R\003C;!R\rN)&\023\007N)u) Y?12/M<\025\005\bB\032\b";
        as[194] = "2\002D.\025!\024D*%\033\016Lz\002\023\023_?\021R\"D\016u!\003Y3%\006";
        as[195] = ">\005M.u1\fB9>R!_.4\021\013\013\001\025\000\005O\032\032\024\006k-=\033 v";
        as[196] = "2\031N6\0251\017F74\034\004X";
        as[197] = ":\tO?u5\022J*=\033\003Xz\0162\007Y?\025=\016k-=\033 v";
        as[198] = "2\002D.\0254\017Lz\032\024@|;'RM\013\036<\001\001I60\026";
        as[199] = "4\017Lz\032\024@|;'R;k(0\026 d<32\027C3\025/";
        as[200] = "4\tL2!R-D>0R6B)<\020\fNz\0162\007Y?\025=\016k-=\033 v";
        as[201] = ">\017L=<\034\007\0135 \006N\005t";
        as[202] = ">\017J><\034\007\005t{R0G?4\001\005\013-4\033\024";
        as[203] = "\033Z";
        as[204] = ">\017Hz\020\000\022D(oR";
        as[205] = "0\017^41R%Y(:\000Z\013";
        as[206] = "R\017I0o";
        as[207] = "3\003_3:\034H";
        as[208] = "2\002G;\025";
        as[209] = "6\022J3;R\022J.0H@";
        as[210] = ">\005]?9R";
        as[211] = "2\007Y?\025";
        as[212] = "+\017^z1\035\016\f.u\032\001]?u\023\fGz!\032\005\013(0\023\007N4!\001@R5 R\016N?1R\006D(u\006\bB)u\001\020N69";
        as[213] = "+\017^z=\023\026Nz'\007\016\0135 \006@D<u\002\022J#0\000@[5<\034\024Xtu \005_/'\034@_5u\023@H2 \000\003Cz!\035@Y?6\032\001Y=0";
        as[214] = "+\017^(u\037\001L36R\001I39\033\024Rz<\001@E5!R\bB==R\005E5 \025\b\013<:\000@_2<\001@X*0\036\f";
        as[215] = "\"\022J#0\000\023";
        as[216] = "H@";
        as[217] = "+\017^(u\002\022J#0\000@J8<\036\t_#u\033\023\0134:\006@C32\032@N4:\007\007Cz3\035\022\013.=\033\023\013*'\023\031N(";
        as[218] = "\"\017B4!R\001_z4R\020Y;,\027\022\013<:\000@Jz1\027\023H(<\002\024B5;";
        as[219] = "\"\017B4!R\001_z4R\023[?9\036@M5'R\001\013>0\001\003Y3%\006\tD4";
        as[220] = "2\022N>\025";
        as[221] = "2\031N6\025";
        as[222] = "2\027C3\025";
        as[223] = "R\tXz:\034@\\5'\036\004\013";
        as[224] = "1\fB9>R\bN(0R\024Dz4\026\004\013;u\024\022B?;\026";
        as[225] = "1\fB9>R\001\01344\037\005\013.:R\023N41R\001\01370\001\023J=0";
        as[226] = "\fT\030c+2\027C3\025 \005F5#\027@\013zuR@\013zu%7|\r\002%7|\r\002";
        as[227] = "1\fB9>R\bN(0R\024Dz4\026\004\013;u\034\001F?";
        as[228] = "4\022B?;\026\023";
        as[229] = "1\fB9>R\024Dz'\027\rD,0R";
        as[230] = ";\007E5'\027";
        as[231] = "0\fD9>\033\016Lz8\027\023X;2\027\023\013<'\035\r\021";
        as[232] = "R\tXz:\024\006G3;\027";
        as[233] = "1\fB9>R\024Dz8\027\023X;2\027@";
        as[234] = "JZ\013\027 \006\t[60R\fD=2\033\016Lz<\034";
        as[235] = "CZ\013\0253\024\005E)<\004\005\01364\034\007^;2\027";
        as[236] = "GZ\013\0204\025\005Sz\006\006\001M<u\033\r[?'\001\017E;!\033\017E";
        as[237] = "AZ\013\n4\001\023\\5'\026@X94\037\rB42";
        as[238] = "CR\021z\007\027\001Gz\"\035\022G>u\033\024N7u\006\022J><\034\007";
        as[239] = "DZ\013\0336\021\017^4!R\023C;'\033\016Lu!\000\001O3;\025";
        as[240] = "FZ\013\030 \025@J8 \001\005";
        as[241] = "CP\021z\030\033\023^)0R\017Mz6\007\023_58\027\022\013) \002\020D(!";
        as[242] = "4\tY)!R\tE><\021\001_?u\005\bB9=R\017Mz:\007\022\013kgR\022^60\001@B)u\020\005B42R\002Y5>\027\016\005z\023\035\022\013;u\026\005_;<\036\005O";
        as[243] = "EZ\013\0274\021\022D3;\025";
        as[244] = "\027\030[64\034\001_3:\034@D<u\027\001H2u\000\025G?u\002\fN;&\027@Y?4\026@_20R\rJ4 \023\f\0135;R\017^(u\005\005I)<\006\005\005";
        as[245] = "@Z\013\023!\027\r\013)6\023\rF3;\025";
        as[246] = "&\bB)u\024\017Y7u\033\023\013<:\000@Y?%\035\022_3;\025@[64\013\005Y)u\005\bDz4\000\005\0138'\027\001@3;\025@D/'R\022^60\001";
        as[247] = "1\fB9>R\bN(0R\024Dz6\023\016H?9";
        as[248] = "CQ\021z\024\026\026N(!\033\023B42RO\013-0\020\023B.0";
        as[249] = ";\006\013#:\007@F3&\007\023Nz!\032\tXz3\035\022Fvu\013\017^z\"\033\fGz7\027@I;;\034\005Ot";
        as[250] = "KZ\013\037;\021\017^(4\025\tE=u\035\024C?'\001@_5u\020\022N;>R\022^60\001";
        as[251] = "'\023B42R\t_z&\027\016O)u\023@X44\002\023C5!R\017Mz!\032\005\01364\001\024\013leR\023N9&R\017Mz4\021\024B,<\006\031\013.:R\025X";
        as[252] = "2\007Y?\025/ \\2<2";
        as[253] = "2\007Y?\025H \\2<2";
        as[254] = "2\007Y?\025) \\2<2";
        as[255] = "4\017G6:\005";
        as[256] = "2\007Yh\025";
        as[257] = "2\003R;\025";
        as[258] = "2\017Yk\025";
        as[259] = "2\017Yi\025";
        as[260] = "R\017Ez&\027\fM";
        as[261] = "'\023Nz";
        as[262] = "%\001G1\001\035";
        as[263] = "%\001G1u\032\005Y?";
        as[264] = "R\027B.=";
        as[265] = "&\001G1x\006\017";
        as[266] = "R\017E";
        as[267] = "2\fY?\025";
        as[268] = "&\022J>0R\027B.=";
        as[269] = "7\030J7<\034\005";
        as[270] = "2\007Yk\025";
        as[271] = "R\017Ez2\000\017^41";
        as[272] = "2\007Yi\025";
        as[273] = "Z\fN,0\036M";
        as[274] = "6\025N6u\005\t_2";
        as[275] = "!\005G?6\006";
        as[276] = "1\001X.u";
        as[277] = "2\017Yh\025";
        as[278] = "R;";
        as[279] = "&\001@?";
        as[280] = "!\017^41R\005M<0\021\024X";
        as[281] = "'\016J89\027@_5u\033\016B.u\001\017^41\001Z";
        as[282] = "\001\017^41\001";
        as[283] = "\\\rN7";
        as[284] = "+\017^(u;\016]?;\006\017Y#";
        as[285] = "\035\024C?'R\020G;,\027\022";
        as[286] = "6\025N6u=\020_3:\034\023";
        as[287] = "+\017^(u!\024J10";
        as[288] = "<\017\01374\025\tH";
        as[289] = "<\017\013-0\023\020D4&";
        as[290] = "<\017\013*'\023\031N(";
        as[291] = "=\020[5;\027\016_}&R3_;>\027";
        as[292] = "<\017\013(0\006\022N;!\033\016L";
        as[293] = "&\bB)u\035\002A?6\006@H;;\034\017_z7\027@J>1\027\004\013.:R\001\013> \027\f\01353\024\005Y";
        as[294] = "%\001B.<\034\007\013<:\0";
        as[295] = "\032\001Xz4\021\003N*!\027\004";
        as[296] = "=\024C?'R\020G;,\027\022";
        as[297] = "\"\022N*4\000\tE=u\006\017\013> \027\f\013-<\006\b\021z";
        as[298] = "\001\bD-7\023\016@";
        as[299] = "\001\005G?6\006\023C5%\033\024N7";
        as[300] = "3\003H?%\006$^?9@H\002";
        as[301] = "3\003_3:\034R\003";
        as[302] = "'3n\023\0017-b\036\0346";
        as[303] = "\"\017[\016'\023\004Nr";
        as[304] = "6\005[5&\033\024\003";
        as[305] = "1(j\016";
        as[306] = "\023\024D8?\005\t_2";
        as[307] = "6\005I/2 3\003";
        as[308] = "\024\017G6:\005\016J70";
        as[309] = "!%\177\t\020 6";
        as[310] = "\",j\003\020 )oh\033;#`z";
        as[311] = "%\001G1\001\0352J41\035\rG#}";
        as[312] = "0\025R\023!\027\r\003";
        as[313] = "\001\f\\5'\026";
        as[314] = "'3n\023\0017-{\025\006\"/x";
        as[315] = "\"2j\003\0324&";
        as[316] = "6\005H6<\034\005\177(4\026\005\003s";
        as[317] = "&3\177\033\001R";
        as[318] = "0!e\021\026=5e\016u";
        as[319] = "\002\025_.'\023\004N";
        as[320] = "!\bD-\027\023\016@r|";
        as[321] = "0/\177\031";
        as[322] = "%\tN61;$\003";
        as[323] = "\026\022D*";
        as[324] = "5%\177\002\005";
        as[325] = "2\"d\016\025!\fN?%\006\bY?&\032@X?!R\024DzxR";
        as[326] = ";.h\025\0300!\177ze";
        as[327] = ";.h\025\0300!\177zd";
        as[328] = "\002\fJ#0\000\tOh;\033\003@";
        as[329] = "\001\005G6<\006\005F";
        as[330] = "\023\003H?%\006\024Y;1\027Q";
        as[331] = "%\t_21\000\001\\r";
        as[332] = "1\bJ.}";
        as[333] = "\033\023D8?<\005J(";
        as[334] = "\023\024d8?\027\003_\r<\006\b\003";
        as[335] = "<\017_z\023\035\025E>";
        as[336] = "\033\016H58\020\001_";
        as[337] = "6\022D*\0346H";
        as[338] = "0!e\021\026=5e\016\0346@";
        as[339] = "\023\003_40\023\022\031";
        as[340] = "\006\001@?4\006";
        as[341] = "\023\024_*9\023\031N(";
        as[342] = "\001\fN?%\006\bY?&\032";
        as[343] = "\006\001G1;\023\rN";
        as[344] = "\023\024_;6\031\016[97\013\016J70";
        as[345] = "\023\003H?%\006\024Y;1\027R";
        as[346] = "\033\024N7!\023\013N";
        as[347] = ";.}\031\032'.\177z";
        as[348] = "<0h\023\021@.b\031\036R";
        as[349] = "3\003_3:\034.N;'\027\023_\0257\030H";
        as[350] = ">/l\025\000&";
        as[351] = "\026\025F*;\002\003B>";
        as[352] = "\025\005_<8\035\004N";
        as[353] = ";.}\031\032'.\177\023\021";
        as[354] = ")^\027\007u%\001X.06\"D\016u$\005Y)<\035\016\013\031:\000\022N9!";
        as[355] = ";3e\n\026<%j\buB";
        as[356] = "0!e\021\026=5e\016\0346";
        as[357] = "<0h\023\021@.J70Z";
        as[358] = "\006\001@?";
        as[359] = ";.}\031\032'.\177ze";
        as[360] = "18{z";
        as[361] = "\023\024D8?\023\024";
        as[362] = ";.}\031\032'.\177";
        as[363] = "\021\fD)0\020\001E1";
        as[364] = "\006\bB?#\027";
        as[365] = "R\f]6u";
        as[366] = "\034\020H31@\016B9>";
        as[367] = "\023\003_3:\034\016N;'\027\023_57\030\tO";
        as[368] = ";3d\030\037<%j\buC";
        as[369] = "\023\003H?%\006\004^?9@";
        as[370] = "\006\001@?;\023\rN";
        as[371] = "\023\024D8";
        as[372] = "!\bD-\006\032\017[r|";
        as[373] = "\"\025_\016'\023\004Nr";
        as[374] = "\005\t_21\000\001\\";
        as[375] = "64s\016";
        as[376] = "2\002D.\025";
        as[377] = "0!e\021\026=5e\016uB";
        as[378] = "\002\017[.'\023\004N";
        as[379] = "\037\tE?";
        as[380] = "\026\005[5&\033\024N,0\000\031_2<\034\007";
        as[381] = "3\024_;6\031.J70Z";
        as[382] = "\026\005H6<\034\005_(4\026\005";
        as[383] = "\037\001L?";
        as[384] = "\035\020N41\035\017Y33\021\fD)0\026";
        as[385] = "\\<E*6\\\024S.";
        as[386] = "\037\001L?;\023\rN";
        as[387] = "\001\024J.0";
        as[388] = "\000\005F5#\027)o";
        as[389] = "!\005G6\034\006\005Fr";
        as[390] = "R8{z";
        as[391] = "\000\005F5#\027";
        as[392] = "\"\fJ#0\000)oh\033\023\rNr";
        as[393] = "1\025Y(0\034\024\013";
        as[394] = "\006\001@?;\027\001Y?&\006\t_?8";
        as[395] = " 5e";
        as[396] = "\001\bD-&\032\017[";
        as[397] = "6\005H6<\034\005o/0\036H\002";
        as[398] = "?\001L?\005\036\001R?'Z";
        as[399] = "?\tE?}";
        as[400] = "%!g\021\001=";
        as[401] = "&\001G1\001\035.{\031\027\013.J70Z";
        as[402] = "14s\016";
        as[403] = "3\003_3:\034.N;'\027\023_\0257\030R\003";
        as[404] = "7\022Y5'";
        as[405] = "!\005_\034<\025\b_\027:\026\005\003";
        as[406] = "3\003H?%\0064Y;1\027R\003s";
        as[407] = "'3n\023\0017-b\036";
        as[408] = "\026\005[5&\033\024";
        as[409] = "0!e\021\026=5e\016\0346@\033";
        as[410] = "6%i\017\022 3";
        as[411] = "3\024d8?\027\003_\033!Z";
        as[412] = ";.}\031\032'.\177\023\021RP";
        as[413] = "\033\023e\n\026<\005J(";
        as[414] = "4-d\036\020R";
        as[415] = "\000\001E>:\037\027J6>";
        as[416] = "!#y\023\005&";
        as[417] = ";3d\030\037<%j\buB";
        as[418] = "*0\013<:\000@";
        as[419] = "3\003_3:\034.N;'\027\023_r";
        as[420] = "&\001@?\033\023\rNr";
        as[421] = "&\001@?\034\006\005F\033!Z";
        as[422] = "34\177";
        as[423] = "5%\177\024\0051";
        as[424] = "\026\022D*<\026";
        as[425] = "\026\025N6;\023\rN";
        as[426] = "3\003_3:\034.N;'\027\023_h}";
        as[427] = ";.}\031\032'.\177\023\021R";
        as[428] = "2\002D.\025!\003Y3%\006@y/;\034\tE=";
        as[429] = "\t@b\036uO@";
        as[430] = ">/l\023\033";
        as[431] = "!\005G?6\0063C5%;\024N7}";
        as[432] = "\023\024_44\037\005";
        as[433] = "0\025R\023!\027\rb\036}";
        as[434] = "R\035\013!u<!f\037uO@\f";
        as[435] = "5%\177\t";
        as[436] = "R\035\013!u6%x\031\007;0\177\023\032<@\026z";
        as[437] = "\023\003H?%\006\004^?9C";
        as[438] = "\023\003_3:\034\016N;'\027\023_57\030\tOh";
        as[439] = "\026\005H6<\034\005O/0\036";
        as[440] = "0!e\021\026=5e\016";
        as[441] = "R2N;1R\006Y58R3G-:\000\004\005.-\006";
        as[442] = "2\002D.\025!\003Y3%\006@x.:\002\020N>";
        as[443] = "\020\025R3!\027\r";
        as[444] = "\000\005F5#\027)or";
        as[445] = "\001\005_<8\035\004N";
        as[446] = "\023\016X";
        as[447] = "&\001@?\033\027\001Y?&\006)_?8Z";
        as[448] = "\021\fD)0\001\bD*";
        as[449] = "3\003H?%\0064Y;1\027Q\003s";
        as[450] = "\020\025R3!\027\rB>";
        as[451] = "13\177\033\001R";
        as[452] = ")^\027\007u'\016Y?6\035\007E3/\027\004\013\001";
        as[453] = "\006\001G1";
        as[454] = "&8{z";
        as[455] = "%\tN61;$";
        as[456] = ";\016];9\033\004\013\t0\000\026N(uZU\032zxRU\035z:\034\fRz'\027\024J(1[";
        as[457] = "\023\003_40\023\022";
        as[458] = "!4j\016\020R";
        as[459] = "!\fN?%R7D(1R";
        as[460] = "=\020N4\021\035\017Y\02331\fD)0\026H";
        as[461] = "\006\022J>0\034\001F?";
        as[462] = "4)s";
        as[463] = "%\tN61";
        as[464] = "!\005G6\034\006\005F\023\021Z";
        as[465] = "\"2j\003\032<";
        as[466] = "\023\003_h";
        as[467] = "6\005[5&\033\024n,0\000\031_2<\034\007\003s";
        as[468] = "\001\005G6<\006\005F31";
        as[469] = "R\035!";
        as[470] = "3\003H?%\006$^?9CH\002";
        as[471] = "\023\003_";
        as[472] = ";3e\n\026<%j\buC";
        as[473] = "U@Vz.R#d\027\02734\013gu";
        as[474] = "<\017\013\023!\027\r\013\030,R4C;!R.J70R&D/;\026";
        as[475] = "?\017O?'\023\024D(u\035\020_3:\034Z\013\027 \006\005\013*9\023\031N(u\024\017YzaJ@C5 \000\023\021zi=&md";
        as[476] = "<\017\\z!\013\020Nz!\032\005\01344\037\005\01353R\024C?u\035\006M?;\026\tE=u\002\fJ#0\000L\013;;\026@[(0\001\023\013?;\006\005Y";
        as[477] = "?\017O?'\023\024D(u\035\020_3:\034Z\013\027 \006\005\013*9\023\031N(u\024\017YzaJ@C5 \000\023\021zi=.\025";
        as[478] = "<\001F?oR";
        as[479] = "FZ\013\016'\013@Y?7\035\017_3;\025@R5 \000@H58\002\025_?'";
        as[480] = "GZ\013\016'\013@^)<\034\007\013;;\035\024C?'R\nJ,4";
        as[481] = "CZ\013\0274\031\005\013) \000\005\013#:\007@C;#\027@^4%\023\003@?1R\004J.4\\\032B*u\006\017\013.=\027@Y32\032\024\013><\0";
        as[482] = " \025E?\006\021\001[?u\034\005N>&R\001I5 \006@\037b8\027\007\01353R\023[;'\027@y\033\030";
        as[483] = "\032\024_*o]O\\-\"\\\022^40\001\003J*0\\\003D7";
        as[484] = "7\022Y5'RM\013/;\023\002G?u\006\017\0136:\023\004\013=4\037\005\n";
        as[485] = "&\017\013*9\023\031\013\b \034\005x94\002\005\01374\031\005\013) \000\005\013#:\007@[64\013@M(:\037";
        as[486] = "7\022Y5'RM\0135 \006@D<u\037\005F5'\013A";
        as[487] = "!\017Y(,^@J4u\027\022Y5'R\bJ)u\035\003H/'\027\004\013-=\033\fX.u\036\017J><\034\007\013\r4\001\024N\036\027\0354";
        as[488] = "&\022Rz!\032\005\013<:\036\fD-<\034\007\021";
        as[489] = "@Z\013\0274\031\005\013) \000\005\013#:\007@C;#\027@O;!\023NQ3%\\N\005";
        as[490] = "\037\025H2u\037\017Y?u\002\017\\?'\024\025Gt{\\N";
        as[491] = ":\005G,0\006\tH;";
        as[492] = ";@X/2\025\005X.u\025\005_.<\034\007\013;u\034\005\\z6\035\r[/!\027\022";
        as[493] = "AZ\013\016'\013@^)<\034\007\013;u\026\tM<0\000\005E.u\025\001F?x\005\017Y61";
        as[494] = "\021\017Y40\000\023\005>4\006";
        as[495] = "\020\025_.:\034\023\005>4\006";
        as[496] = "\000\025E?&\021\001[?{\026\001_";
        as[497] = "\\\nJ=";
        as[498] = "\035\002A?6\006\023";
        as[499] = "\023\022Y5\"\001NO;!";
        as[500] = "\032\002J({\026\001_";
        as[501] = "\037\005O34";
        as[502] = "@\004\013='\023\020C36\001";
        as[503] = "\001\003Y59\036\002J({\026\001_";
        as[504] = "\020\025I89\027NO;!";
        as[505] = "\033\016]k{\026\001_";
        as[506] = "\033\003D4{\026\001_";
        as[507] = "\033\016O?-\\\004J.";
        as[508] = "\002\022D00\021\024B60\\\004J.";
        as[509] = "\032\002J(g\\\004J.";
        as[510] = "\\\004J.";
        as[511] = "\021\017F*4\001\023\005>4\006";
        as[512] = "\001\020G;!\\\004J.";
        as[513] = "\033\016]h{\026\001_";
        as[514] = ">/l\025\000&@i\026\0321+";
        as[515] = "2\003R;\025!\017Y(,^@R5 R\003J4r\006@G52\035\025_z4\006@_20R\rD70\034\024";
        as[516] = ";\016\013(0\006\025Y4u\013\017^z\"\033\fGz'\027\003N3#\027Z";
        as[517] = "+\017^z4\000\005\013;7\035\025_z!\035@L3#\027Z";
        as[518] = "<\017_2<\034\007\n";
        as[519] = "R\030\013";
        as[520] = "3\022Nz,\035\025\013) \000\005\013#:\007@\\;;\006@_5u\026\017\013.=\033\023\024";
        as[521] = "%\001B.<\034\007\013<:\000@D.=\027\022\013*9\023\031N({\\N";
        as[522] = " \005F?8\020\005Yz!\032\001_z;\035\024\013;9\036@[64\013\005Y)u\023\022Nz!\000\025X.\"\035\022_2,";
        as[523] = "\"\fN;&\027@H5;\024\tY7u\013\017^(u\006\022J>0R\027B.=R R?92";
        as[524] = "&\bN(0R\tXz\033=@|\033\fR\024Dz'\027\026N(&\027@Jz!\000\001O?u\033\006\013#:\007@H24\034\007Nz,\035\025Yz8\033\016Ot";
        as[525] = "=\020[5;\027\016_}&R/M<0\0";
        as[526] = "+\017^(u=\006M?'";
        as[527] = "&\022J><\034\007\013-<\006\b\021z";
        as[528] = "&\bB)u\035\002A?6\006@H;;\034\017_z7\027@_(4\026\005Oz\"\033\024Cz:\006\bN(u\002\fJ#0\000\023";
        as[529] = "H@k-=\033 ";
        as[530] = "\\\020H7";
        as[531] = "R\rD(0R\017[.<\035\016X";
        as[532] = "1\bD5&\027@D*!\033\017E";
        as[533] = "1\bD5&\027@Jz!\023\022L?!";
        as[534] = "2\027C3\025RO\013";
        as[535] = "2\027C3\025RO\013ku\037\017Y?u\035\020_3:\034";
        as[536] = "&\005S. \000\005X";
        as[537] = "\006\005S. \000\005X";
        as[538] = "]U\030";
        as[539] = "2\002D.\025%\001X.06\"D\016u1\bJ.u1\fB9>\027\004\013wu<\017_z3\033\016B)=\027\004\013rx\\M\002";
        as[540] = "]U\031";
        as[541] = "]U\032";
        as[542] = "_\016^69_";
        as[543] = "\"\fN;&\027@\\;<\006N\005t";
        as[544] = "HZH6:\001\005H5;";
        as[545] = "2\022N>\025+\017^z'\027\024J3;R\031D/'R\023@39\036\023\007z4\036\024C5 \025\b\013#:\007@G5&\027@R5 \000@D8?\027\003_)";
        as[546] = "]U\037";
        as[547] = "HZG52\035\025_";
        as[548] = "HZ";
        as[549] = "2\022N>\025+\017^z=\023\026Nz1\033\005Ovu\026\017E}!R\002G;8\027@F?{\\N\0133!\001@R5 \000@D-;R\006J/9\006";
        as[550] = "]U\036";
        as[551] = "HZG5&\006\003D4";
        as[552] = "]U\035";
        as[553] = "\"\fN;&\027@N4!\027\022\013;u\007\023N(;\023\rN`";
        as[554] = "\037\005F80\000\023";
        as[555] = "%\001X.06\"D\016u\020\031\013\n=\023\024NzsR,D(8\001\002R";
        as[556] = ")^\027\007u!\005Y,0\000@\036h";
        as[557] = "@P\022tgAW\005h`CN\031j";
        as[558] = ")^\027\007u!\005Y,0\000@\036k";
        as[559] = ")^\027\007u!\005Y,0\000@\036l";
        as[560] = "DY\005hg\\Q\036b{@S\035";
        as[561] = ")^\027\007u!\005Y,0\000@\036o";
        as[562] = "@Q\034tdAX\005id\\R\036j";
        as[563] = ")^\027\007u!\005Y,0\000@\036n";
        as[564] = ")^\027\007u!\005Y,0\000@\036i";
        as[565] = "1\fB9>R\bN(0R\024Dz6\036\017X?u\005\tE>:\005";
        as[566] = "\006\fO6<\001\024\005.-\006";
        as[567] = "1\bJ.u\001\031X.0\037";
        as[568] = "\021\017E<<\025";
        as[569] = "\024\022J=8\027\016_)0\034\003\005.-\006";
        as[570] = "1\017E<<\025\025Y;!\033\017E";
        as[571] = "\024\tG.0\0";
        as[572] = "\032\017X.0\034\003\005.-\006";
        as[573] = "\020\001O?;\021N_\"!";
        as[574] = "6\022D*";
        as[575] = "'\023N";
        as[576] = "%\005J(";
        as[577] = " \005F5#\027";
        as[578] = "%\005J*:\034\023\01374\013@I?u\007\023N>";
        as[579] = "\"\fN;&\027@H5;\024\tY7u\013\017^(u\026\025N6u\005\t_2u2\031N6\025";
        as[580] = "+\017^(u\001\024J10H";
        as[581] = "<\017\013(0\006\022N;!R\tXz%\035\023X37\036\005\n";
        as[582] = "+\017^(u\035\020[5;\027\016_}&R\023_;>\027Z";
        as[583] = "%\005J*:\034\023\01394\034\016D.u\020\005\013/&\027\004";
        as[584] = "\"\022J#0\000@F;,R\002Nz \001\005O";
        as[585] = "+\017^z6\023\016\013(0\006\022N;!R\006Y58R\024C3&R\004^?9";
        as[586] = "?\001L36R\003J4;\035\024\01380R\025X?1";
        as[587] = "\"\022J#0\000@H;;\034\017_z7\027@^)0\026";
        as[588] = ";\006\013#:\007@J(0R\023^(0R\003G36\031@\f\0336\021\005[.rR\024Dz7\027\007B4u\006\bNz1\007\005G";
        as[589] = "?\001L36R\rJ#u\020\005\013/&\027\004";
        as[590] = "\024\tY?%\036\001H?4A";
        as[591] = "\025\tJ4!\021\022R)!\023\f";
        as[592] = "\036\tL2!\034\tE=f";
        as[593] = "\024\tY?4@";
        as[594] = "\001\020N69\021\bJ(2\027R";
        as[595] = "\001\013^69\006\017Y9=\023R";
        as[596] = "\036\tL2!\034\tE=g";
        as[597] = "\006\017Y9=\023T";
        as[598] = ">\017J><\034\007\013i1R\rD>0\036\023";
        as[599] = "\024\tY?4A";
        as[600] = "\006\017Y9=\023S";
        as[601] = "\024\tY?%\036\001H?4@";
        as[602] = "\021\fJ-&\002\005G6g";
        as[603] = "\001\013^69\006\017Y9=\023T";
        as[604] = "\001\020N69\021\bJ(2\027S";
        as[605] = "\\\017Ih";
        as[606] = "A\004\0137:\026\005G)";
        as[607] = "\037\017O?9\001";
        as[608] = "\021\fJ-&\002\005G6a";
        as[609] = "\021\fJ-&\002\005G6`";
        as[610] = "\024\tY?&\002\005G6f";
        as[611] = "\\\017Ii";
        as[612] = "\024\tY?&\002\005G6g";
        as[613] = "\\N\004=4\037\005O;!\023OF51\027\fXu";
        as[614] = "\021\fJ-&\002\005G6f";
        as[615] = "\001\013^69\006\017Y9=\023S";
        as[616] = "\006\017Y9=\023R";
        as[617] = "\025\020";
        as[618] = "1\fB9>R\bN(0R\024Dz&\027\fG";
        as[619] = "!\005G?6\006@J4u\035\002A?6\006@_5u\020\025Rz:\000@X?9\036";
        as[620] = "&\bB)u\033\024N7u\033\023\0134:\006@H/'\000\005E.9\013@J,4\033\fJ89\027@_5u\020\025R";
        as[621] = "+\017^z1\035@E5!R\bJ,0R\001E#u\035\006\013.=\033\023\0133!\027\r\013.:R\023N69";
        as[622] = "0\025R3;\025@J41R\023N69\033\016Lz<\006\005F)";
        as[623] = "R\006D(u";
        as[624] = "!\005G6u\013\017^(u";
        as[625] = "0\025Rz4R\016N-u";
        as[626] = "+\017^(u\037\017E?,H@";
        as[627] = "1\fB9>R\bN(0R\024Dz7\007\031";
        as[628] = "1\fD)0R\027B41\035\027";
        as[629] = "<\025F80\000@R5 R\017\\4u\033\016\01389\007\005";
        as[630] = "!\bD*&R\023_56\031@B4u\025\022N?;";
        as[631] = "'\016[;6\031\tE=u";
        as[632] = "\\Oo;!\023O";
        as[633] = "&\031[3;\025@|5'\026@\021z";
        as[634] = "!\005E><\034\007\013\r:\000\004\021z";
        as[635] = "2\004Y?\025) \\2<27B61\027\022E?&\001 O(02=";
        as[636] = "2\002G/\025%\001X.06@i5\001RM\013\n=\023\024Nz~R,D(8\001\002R";
        as[637] = "\024\tY?&\002\005G6";
        as[638] = "2\004Y?\025) \\2<2,N,0\036@";
        as[639] = "*0\013\0354\033\016N>oR L(02";
        as[640] = "HP";
        as[641] = "R \\2<2\017Ez\025\025\022N\032\006\006\022N42\006\bk5'C \013'k";
        as[642] = "\031\005R8:\023\022Oz!\035@_#%\027@_20R\027D(1R\tEz!\032\005\0138:\n@I?9\035\027";
        as[643] = "\024\tY?4";
        as[644] = "=\b\013>0\023\022\nz\f\035\025\013;'\027@O?4\026N\005t";
        as[645] = "\036\tL2!\034\tE=";
        as[646] = "R \\2<2\017Ez\025\025\022N\032\024\006\024J9>^@o?3\027\016X?uT@x.'\027\016L.=2\017Yk\025R\035\025";
        as[647] = "!\031X.0\037@^*1\023\024Nz<\034Z\013";
        as[648] = "\001\013^69\006\017Y9=\023";
        as[649] = "2\"d\016\0254\001_32\007\005\0139'\035\023X?1R\023G?0\0024C(0\001\b\013wu\001\fN?%\033\016Lt{\\";
        as[650] = "2\002D.\0254\tS3;\025@m32\032\024F51\027@_5u>\017H10\026-D>0";
        as[651] = "2-d\017\00670d\tu";
        as[652] = "2-r\n\032!@";
        as[653] = "4\001_32\007\005\021z";
        as[654] = "(:q";
        as[655] = "2\004Y?\025/";
        as[656] = ";\006\013#:\007@H;;U\024\013(0\023\004\013.=\027@\\5'\026";
        as[657] = "5\022J*=\033\003Xz\025\013\005G\032\016=\016v";
        as[658] = "%\bN4u\013\017^z\"\023\016_z!\035@\\;>\027@^*u\030\025X.u\007\023Nz,\035\025Y";
        as[659] = "\006\017Y9=\023";
        as[660] = "R \\2<2\017Ez\025\025\022N\032\024\006\024J9>2\017Yk\025R\035\025";
        as[661] = "2\031N6\025\021\fB9>R\bN(02\027C3\025R\024Dz2\027\024\013;u\026\tM<0\000\005E.u\035\016N";
        as[662] = "RM\013\032\"\032\tk\034<\025\b_7:\026\005\021z\025\025\022N\032";
        as[663] = "\024\tY?%\036\001H?4";
        as[664] = "2\017Yk\025R\\Pz\025\005\bB\032\023\033\007C.<\034\007\021z\025\025\022N\032";
        as[665] = "R@k-=\033 \006zu";
        as[666] = "+\017^z4\000\005\013)9\027\005[3;\025";
        as[667] = "R \\2<2\017Ez\025\025\022N\032\021\027\006N4&\027 D(d2@Vd";
        as[668] = "\021\fJ-&\002\005G6";
        as[669] = "\001\020N69\021\bJ(2\027";
        as[670] = "2\002D.\025<\017\013\024\0051@X?9\027\003_?1^@Y32\032\024\01399\033\003@z4\034\004\0139=\035\017X?u\023\016\0134%\021N";
        as[671] = "2\002D.\0253\025_53\033\007C.0\000@d<3";
        as[672] = "2\002D.\0253\025_53\033\007C.0\000@d4";
        as[673] = "\037\005F80\000\023\01364\034\004X94\002\005";
        as[674] = "\037\001[)";
        as[675] = "\037\005F80\000\023\01374\002";
        as[676] = "\036\001E>";
        as[677] = "\036\001E>&\021\001[?";
        as[678] = "\037\001[";
        as[679] = "CI";
        as[680] = "4\t]?";
        as[681] = "3,g";
        as[682] = "GI";
        as[683] = "@U";
        as[684] = "<\025F80\000@B4u\020\001E1u\033\016\013='\027\005E";
        as[685] = "%\t_21\000\001\\z";
        as[686] = "CP\033s";
        as[687] = "@U\002";
        as[688] = "N\020J=0RT\025";
        as[689] = "6\005[5&\033\024\013";
        as[690] = "N\020J=0RQ\025";
        as[691] = "GP\033";
        as[692] = "%\t_21\000\001\\\0339\036H";
        as[693] = "6\005[5&\033\024j69Z";
        as[694] = "=\016N";
        as[695] = "GP\033s";
        as[696] = "N\020J=0RS\025";
        as[697] = "N\020J=0RR\025";
        as[698] = "@U\033j|";
        as[699] = "0\001E1";
        as[700] = "!\005G?6\006@J4u\035\002A?6\006@_5u\005\t_21\000\001\\z:\000@O?%\035\023B.";
        as[701] = "CP\033";
        as[702] = "<\025F80\000@C?9\026@B4u\020\f^?";
        as[703] = "@U\033j";
        as[704] = "GS";
        as[705] = "GR";
        as[706] = "\"\fN;&\027@N4!\027\022\013#:\007\022\013/&\027\022E;8\027@J41R\020J)&\005\017Y>";
        as[707] = ";\016];9\033\004\013\t0\000\026N(";
        as[708] = "GT";
        as[709] = "GQ";
        as[710] = "GV";
        as[711] = "GU";
        as[712] = "3\016X-0\000H";
        as[713] = "1\001[)u=\006M";
        as[714] = "5\022J*=\033\003Xz\032\024\006";
        as[715] = "1\001[)u=\016";
        as[716] = "5\022J*=\033\003Xz\032\034";
        as[717] = "2\002D.\025!\fN?%R4C(0\001\bC59\026@X?!R\024Dz";
        as[718] = "1\017E40\021\024B5;R%Y(:\000A";
        as[719] = "+\017^z;\027\005Oz!\035@I?u\021\017E40\021\024N>u\006\017\013.=\027@|;&\006\005o\030:&@j*%\036\tH;!\033\017Ez!\035@G52\033\016\005";
        as[720] = ")^\027\007u')oz";
        as[721] = "2\002D.\025!\005_.<\034\007\013\034<\025\b_7:\026\005\013.:R";
        as[722] = "4\tL2!?\017O?}";
        as[723] = "2\003R;\025+\017^z6\023\016\f.u\036\017L5 \006@M5'RQ\033z&\027\003D41\001@J<!\027\022\0139:\037\002J.";
        as[724] = "2\003R;\025+\017^z6\023\016\f.u\036\017L5 \006@O/'\033\016Lz6\035\rI;!S";
        as[725] = ";\016M5'\037\001_3:\034";
        as[726] = "\"\001X)\"\035\022O`";
        as[727] = ">\017Lz<\034";
        as[728] = "\"\bJ.0R\017Mz\002\023\023_?1R#D>0\000\023\013\023;\021";
        as[729] = ">\017Y7&\020\031\013|u\"\bJ.0";
        as[730] = "+\017^z8\007\023_z=\023\026Nz\002\023\023_?\0210\017\177t0\n\005\013( \034\016B42";
        as[731] = "=\013";
        as[732] = "%\001X.06\"D\016uCN\033zoH@a;#\023@h6<\027\016_";
        as[733] = "1\bD5&\027@R5 \000@X?'\004\005Yz3\000\017Fz!\032\005\013\0319\033\005E.";
        as[734] = "%\017Y61H";
        as[735] = ">\017L3;";
        as[736] = "%\001X.06\"D\016uCN\033zxR0C;!\027";
        as[737] = "'\023N(;\023\rN`";
        as[738] = "&\bB)u\033\023\013.=\027@A;#\023@H6<\027\016_z3\035\022\013}\002\023\023_?\0210\017\177}";
        as[739] = "R\rB69\033\017Ez\025\005\bB\032}";
        as[740] = "9@k-=\033 \003";
        as[741] = "78h\037\005&)d\024";
        as[742] = "%\022B.<\034\007\013\022\026\\\"f\n";
        as[743] = ":#\005\030\030\"";
        as[744] = "3\024@z}YS\002";
        as[745] = "!\024Yz}YS\002";
        as[746] = "3\fGz}YQ\002";
        as[747] = "6\005Mz}YS\002";
        as[748] = "2\021^?\025";
        as[749] = "2\020Y3\025";
        as[750] = "2\004Y?\025) Y?127J)!\027$i5\0012\004Y?\025/@k-=\033 ";
        as[751] = "2\002D(\025";
        as[752] = "\023NO;!";
        as[753] = "\002\005D*9\027@J41R\rD4&\006\005Y)";
        as[754] = "\037\005F80\000@L(4\002\bB9&";
        as[755] = "\027\016_3!\013";
        as[756] = "\024NO;!";
        as[757] = "!\tO?";
        as[758] = "&\031[?";
        as[759] = "4\022D4!";
        as[760] = ":\001B(";
        as[761] = "&\017[";
        as[762] = ":\005J>";
        as[763] = "5\005E>0\0";
        as[764] = "3\003H?%\006";
        as[765] = "0\001H1";
        as[766] = "\"\fN;&\027@O?&\033\007Ez\f\035\025Yz\026\032\001Y;6\006\005Y";
        as[767] = "1\017G5'";
        as[768] = "!\013B4";
        as[769] = "0\017_.:\037";
        as[770] = "2\027C3\025#\025N)!_\fB)!RHL(0\027\016\0269:\037\020G?!\027\004\002";
        as[771] = "!\013B69\001";
        as[772] = "7\021^3%\037\005E.u\021\rI)!\023\024^)";
        as[773] = "=\026N(4\036\f\01360\004\005G)";
        as[774] = "#\025N)!R0D3;\006\023\013\001\025\013\005G\032";
        as[775] = "!\024J.&";
        as[776] = "4\001_32\007\005\013\001\025\013\005G\032";
        as[777] = "R;k#0\036 ";
        as[778] = "<\005S.u\036\005]?9R\001_z\0162\031N6\025";
        as[779] = "1\017F84\006@G?#\027\f\013\001\025\013\005G\032";
        as[780] = "R R?92";
        as[781] = "#\025N)!\001";
        as[782] = "2\027C3\025/";
        as[783] = "W \\2<2=";
        as[784] = "2\027C3\025R\023@39\036";
        as[785] = "!\013B69R\024D.4\036@p\032,\027\fk";
        as[786] = "&\017_;9R\030[z\0162\031N6\025";
        as[787] = "2\022N>\025] R?92";
        as[788] = "\037\005F80\0";
        as[789] = "!\024J(!\033\016Lz2\023\rNt{\\";
        as[790] = "=\006M)0\006Z\013";
        as[791] = "\000\005M?'\033\004";
        as[792] = "\002\017M<";
        Dk = as;
        break MISSING_BLOCK_LABEL_8671;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 8650;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i1;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i1 % 5)
        {
        case 0: // '\0'
            byte0 = 0x72;
            break;

        case 1: // '\001'
            byte0 = 96;
            break;

        case 2: // '\002'
            byte0 = 43;
            break;

        case 3: // '\003'
            byte0 = 90;
            break;

        default:
            byte0 = 85;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 8650;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 8574;
           goto _L5 _L1
_L5:
        JVM INSTR new #248 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
