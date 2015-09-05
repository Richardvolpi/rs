// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import jagex.client.*;
import jagex.f;
import jagex.o;
import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.URL;

public class mudclient extends e
{

    public static void rm(String as[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.lt = false;
        mudclient1.hj(mudclient1.hu, mudclient1.iu + 22, "Runescape by Andrew Gower", false);
        mudclient1.rq = 10;
    }

    public void lj()
    {
        if(lt)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin.local") && !s1.endsWith("puffin.local") && !s1.endsWith("puffin") && !s1.endsWith("jagex.dnsalias.com"))
            {
                jt = true;
                return;
            }
        }
        v(et, ft);
        int i1 = 0;
        for(int j1 = 0; j1 < 99; j1++)
        {
            int k1 = j1 + 1;
            int i2 = (int)((double)k1 + 300D * Math.pow(2D, (double)k1 / 7D));
            i1 += i2;
            tx[j1] = i1;
        }

        super.vc = 43594;
        super.xp = -11;
        e.sc = 1000;
        e.rc = c.dc;
        try
        {
            String s2 = getParameter("poff");
            int j2 = Integer.parseInt(s2);
            super.vc += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        fl();
        lu = 2000;
        ku = lu + 100;
        pw = ku + 50;
        nu = pw + 300;
        au = getGraphics();
        zj(50);
        cu = new m(hu, iu + 12, 2600, this);
        cu.ns = this;
        cu.yf(0, 0, hu, iu + 12);
        g.hg = false;
        g.ig = ku;
        by = new g(cu, 5);
        int l1 = ((i) (cu)).xj - 199;
        byte byte0 = 36;
        cy = by.xc(l1, byte0 + 24, 196, 90, 1, 500, true);
        fy = new g(cu, 5);
        gy = fy.xc(l1, byte0 + 40, 196, 126, 1, 500, true);
        jy = new g(cu, 5);
        ky = jy.xc(l1, byte0 + 24, 196, 226, 1, 500, true);
        om();
        gm(true);
        bu = new j(cu, 15000, 15000, 1000);
        bu.ki(hu / 2, iu / 2, hu / 2, iu / 2, hu, ju);
        bu.jm = 2400;
        bu.km = 2400;
        bu.lm = 1;
        bu.mm = 2300;
        bu.ji(-50, -10, -50);
        wu = new p(bu, cu);
        wu.dgb = lu;
        hm();
        rl();
        gn();
        uj(100, "Starting game...");
        tl();
        dl();
        sl();
        bm();
        nl();
        al();
        gk();
        dm();
    }

    public void fl()
    {
        if(ek())
        {
            byte abyte0[] = null;
            try
            {
                abyte0 = jj("config" + c.ec + ".jag", "Configuration", 10);
            }
            catch(IOException ioexception)
            {
                System.out.println("Load error:" + ioexception);
            }
            r.xp(abyte0);
            return;
        } else
        {
            vj(10, "Loading configuration");
            r.fq();
            return;
        }
    }

    public void om()
    {
        if(ek())
        {
            byte abyte0[] = null;
            try
            {
                abyte0 = jj("media" + c.gc + ".jag", "2d graphics", 20);
            }
            catch(IOException ioexception)
            {
                System.out.println("Load error:" + ioexception);
            }
            cu.pg(abyte0, o.nn("inv1.tga", abyte0), lu, true, false);
            cu.ng(abyte0, o.nn("inv2.tga", abyte0), lu + 1, true, 1, 6, false);
            cu.pg(abyte0, o.nn("bubble.tga", abyte0), lu + 9, true, false);
            cu.pg(abyte0, o.nn("runescape.tga", abyte0), lu + 10, true, false);
            cu.ug(abyte0, o.nn("splat.tga", abyte0), lu + 11, true, 3, false);
            cu.ng(abyte0, o.nn("icon.tga", abyte0), lu + 14, true, 4, 2, false);
            cu.pg(abyte0, o.nn("hbar.tga", abyte0), lu + 22, false, false);
            cu.pg(abyte0, o.nn("hbar2.tga", abyte0), lu + 23, true, false);
            cu.pg(abyte0, o.nn("compass.tga", abyte0), lu + 24, true, false);
            cu.ug(abyte0, o.nn("scrollbar.tga", abyte0), ku, true, 2, false);
            cu.ug(abyte0, o.nn("corners.tga", abyte0), ku + 2, true, 4, false);
            cu.ug(abyte0, o.nn("arrows.tga", abyte0), ku + 6, true, 2, false);
            cu.ng(abyte0, o.nn("buttons.tga", abyte0), lu + 25, true, 1, 2, false);
            du = oj(o.ln("hbar.tga", 0, abyte0));
            int i1 = r.zhb;
            for(int k1 = 1; i1 > 0; k1++)
            {
                int i2 = i1;
                i1 -= 30;
                if(i2 > 30)
                    i2 = 30;
                cu.ng(abyte0, o.nn("objects" + k1 + ".tga", abyte0), pw + (k1 - 1) * 30, true, 10, (i2 + 9) / 10, false);
            }

            cu.ug(abyte0, o.nn("projectile.tga", abyte0), nu, true, r.mlb, false);
            return;
        }
        byte abyte1[] = new byte[0x186a0];
        uj(20, "Loading 2d graphics");
        try
        {
            o.in("../gamedata/media/inv1.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu, true, false);
            o.in("../gamedata/media/inv2.tga", abyte1, 0x186a0);
            cu.ng(abyte1, 0, lu + 1, true, 1, 6, false);
            o.in("../gamedata/media/bubble.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu + 9, true, false);
            o.in("../gamedata/media/runescape.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu + 10, true, false);
            o.in("../gamedata/media/splat.tga", abyte1, 0x186a0);
            cu.ug(abyte1, 0, lu + 11, true, 3, false);
            o.in("../gamedata/media/icon.tga", abyte1, 0x186a0);
            cu.ng(abyte1, 0, lu + 14, true, 4, 2, false);
            o.in("../gamedata/media/hbar.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu + 22, false, false);
            du = oj(abyte1);
            o.in("../gamedata/media/hbar2.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu + 23, true, false);
            o.in("../gamedata/media/compass.tga", abyte1, 0x186a0);
            cu.pg(abyte1, 0, lu + 24, true, false);
            o.in("../gamedata/media/scrollbar.tga", abyte1, 0x186a0);
            cu.ug(abyte1, 0, ku, true, 2, false);
            o.in("../gamedata/media/corners.tga", abyte1, 0x186a0);
            cu.ug(abyte1, 0, ku + 2, true, 4, false);
            o.in("../gamedata/media/arrows.tga", abyte1, 0x186a0);
            cu.ug(abyte1, 0, ku + 6, true, 2, false);
            o.in("../gamedata/media/buttons.tga", abyte1, 0x186a0);
            cu.ng(abyte1, 0, lu + 25, true, 1, 2, false);
            int j1 = r.zhb;
            for(int l1 = 1; j1 > 0; l1++)
            {
                int j2 = j1;
                j1 -= 30;
                if(j2 > 30)
                    j2 = 30;
                o.in("../gamedata/media/objects" + l1 + ".tga", abyte1, 0x186a0);
                cu.ng(abyte1, 0, pw + (l1 - 1) * 30, true, 10, (j2 + 9) / 10, false);
            }

            o.in("../gamedata/media/projectile.tga", abyte1, 0x186a0);
            cu.ug(abyte1, 0, nu, true, r.mlb, false);
            return;
        }
        catch(IOException _ex)
        {
            System.out.println("ERROR: in raw media loader");
        }
    }

    public void gm(boolean flag)
    {
        xeb = 0;
        yeb = xeb;
        byte abyte0[] = null;
        if(ek() && flag)
        {
            String s1 = "entity" + c.jc + ".jag";
            try
            {
                abyte0 = jj(s1, "people and monsters", 30);
            }
            catch(IOException ioexception)
            {
                System.out.println("Load error:" + ioexception);
            }
        } else
        {
            uj(30, "Loading people and monsters");
        }
        int i1 = 0;
label0:
        for(int j1 = 0; j1 < r.xjb; j1++)
        {
            String s2 = r.zjb[j1];
            for(int k1 = 0; k1 < j1; k1++)
            {
                if(!r.zjb[k1].equalsIgnoreCase(s2))
                    continue;
                r.ekb[j1] = r.ekb[k1];
                continue label0;
            }

            if(flag)
                if(ek())
                {
                    boolean flag1 = true;
                    if(r.bkb[j1] != 0)
                        flag1 = false;
                    cu.ug(o.ln(s2 + ".tga", 0, abyte0), 0, yeb, true, 15, flag1);
                    i1 += 15;
                    if(r.ckb[j1] == 1)
                    {
                        cu.ug(o.ln(s2 + "a.tga", 0, abyte0), 0, yeb + 15, true, 3, true);
                        i1 += 3;
                    }
                    if(r.dkb[j1] == 1)
                    {
                        cu.ug(o.ln(s2 + "f.tga", 0, abyte0), 0, yeb + 18, true, 9, true);
                        i1 += 9;
                    }
                } else
                {
                    try
                    {
                        byte abyte1[] = new byte[0x927c0];
                        o.in("../gamedata/entity/" + s2 + ".tga", abyte1, 0x927c0);
                        i1 += 15;
                        boolean flag2 = true;
                        if(r.bkb[j1] != 0)
                            flag2 = false;
                        cu.ug(abyte1, 0, yeb, true, 15, flag2);
                        if(r.ckb[j1] == 1)
                        {
                            o.in("../gamedata/entity/" + s2 + "a.tga", abyte1, 0x30d40);
                            i1 += 3;
                            cu.ug(abyte1, 0, yeb + 15, true, 3, true);
                        }
                        if(r.dkb[j1] == 1)
                        {
                            o.in("../gamedata/entity/" + s2 + "f.tga", abyte1, 0x30d40);
                            i1 += 9;
                            cu.ug(abyte1, 0, yeb + 18, true, 9, true);
                        }
                    }
                    catch(IOException _ex)
                    {
                        System.out.println("ERROR: in raw entity loader - no:" + j1 + " " + s2);
                    }
                }
            r.ekb[j1] = yeb;
            yeb += 27;
        }

        System.out.println("Loaded: " + i1 + " frames of animation");
    }

    public void hm()
    {
        if(ek())
        {
            bu.lh("textures" + c.ic + ".jag", 7, 11, 50, this);
            return;
        } else
        {
            uj(50, "Loading textures");
            bu.si("../gamedata/textures");
            return;
        }
    }

    public void rl()
    {
        r.vp("torcha2");
        r.vp("torcha3");
        r.vp("torcha4");
        r.vp("skulltorcha2");
        r.vp("skulltorcha3");
        r.vp("skulltorcha4");
        r.vp("firea2");
        r.vp("firea3");
        if(ek())
        {
            byte abyte0[] = null;
            try
            {
                abyte0 = jj("models" + c.hc + ".jag", "3d models", 70);
            }
            catch(IOException ioexception)
            {
                System.out.println("Load error:" + ioexception);
            }
            for(int j1 = 0; j1 < r.ymb; j1++)
            {
                int k1 = o.nn(r.zmb[j1] + ".ob3", abyte0);
                if(k1 != 0)
                    bx[j1] = new h(abyte0, k1, true);
                else
                    bx[j1] = new h(1, 1);
            }

            return;
        }
        uj(70, "Loading 3d models");
        for(int i1 = 0; i1 < r.ymb; i1++)
            bx[i1] = new h("../gamedata/models/" + r.zmb[i1] + ".ob2");

    }

    public void gn()
    {
        if(ek())
        {
            wu.lgb = null;
            try
            {
                wu.lgb = jj("maps" + c.fc + ".jag", "map", 90);
                return;
            }
            catch(IOException ioexception)
            {
                System.out.println("Load error:" + ioexception);
            }
            return;
        } else
        {
            wu.zfb = false;
            return;
        }
    }

    public void tl()
    {
        nz = new g(cu, 10);
        oz = nz.kc(5, 269, 502, 56, 1, 20, true);
        pz = nz.lc(7, 324, 498, 14, 1, 80, false, true);
        qz = nz.kc(5, 269, 502, 56, 1, 20, true);
        rz = nz.kc(5, 269, 502, 56, 1, 20, true);
        nz.uc(pz);
    }

    public void rj()
    {
        if(jt)
            return;
        if(kt)
            return;
        try
        {
            mt++;
            if(gu == 0)
            {
                super.yp = 0;
                ql();
            }
            if(gu == 1)
            {
                super.yp++;
                vm();
            }
            if(ht > 0)
                ht--;
            if(gt && ht == 0)
            {
                gt = false;
                super.yc.a();
                ht = 24;
            }
            super.vq = 0;
            super.xq = 0;
            zt++;
            if(zt > 500)
            {
                zt = 0;
                int i1 = (int)(Math.random() * 4D);
                if((i1 & 1) == 1)
                    vt += wt;
                if((i1 & 2) == 2)
                    xt += yt;
            }
            if(vt < -50)
                wt = 2;
            if(vt > 50)
                wt = -2;
            if(xt < -50)
                yt = 2;
            if(xt > 50)
                yt = -2;
            if(jz > 0)
                jz--;
            if(kz > 0)
                kz--;
            if(lz > 0)
                lz--;
            if(mz > 0)
            {
                mz--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            nm();
            kt = true;
        }
    }

    public void xj()
    {
        if(jt)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            zj(1);
            return;
        }
        if(kt)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("Close ALL unnecessary programs", 50, 100);
            g2.drawString("and windows before loading the game", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            zj(1);
            return;
        }
        try
        {
            if(gu == 0)
            {
                cu.al = false;
                wm();
            }
            if(gu == 1)
            {
                cu.al = true;
                hl();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            nm();
            kt = true;
        }
    }

    public void yj()
    {
        eb();
        nm();
    }

    public void nm()
    {
        try
        {
            if(cu != null)
            {
                cu.og();
                cu.dk = null;
                cu = null;
            }
            if(bu != null)
            {
                bu.zi();
                bu = null;
            }
            bx = null;
            ww = null;
            fx = null;
            yv = null;
            zv = null;
            jw = null;
            kw = null;
            bw = null;
            if(wu != null)
            {
                wu.chb = null;
                wu.dhb = null;
                wu.ehb = null;
                wu.fhb = null;
                wu = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public void gk()
    {
        au.drawImage(du, 0, 0, this);
    }

    public void fk(int i1)
    {
        if(gu == 0)
        {
            if(tbb == 0)
                ubb.vd(i1);
            if(tbb == 1)
                xbb.vd(i1);
            if(tbb == 2)
                gcb.vd(i1);
            if(tbb == 3)
                vdb.vd(i1);
        }
        if(gu == 1)
        {
            if(afb)
            {
                tcb.vd(i1);
                return;
            }
            if(jdb)
            {
                if(ndb == -1)
                    kdb.vd(i1);
                return;
            }
            if(lbb == 0 && kbb == 0)
                nz.vd(i1);
            if(lbb == 3 || lbb == 4 || lbb == 5)
                lbb = 0;
        }
    }

    public void qj(int i1, int j1, int k1)
    {
        tt[st] = j1;
        ut[st] = k1;
        st = st + 1 & 0x1fff;
        for(int l1 = 10; l1 < 4000; l1++)
        {
            int i2 = st - l1 & 0x1fff;
            if(tt[i2] == j1 && ut[i2] == k1)
            {
                boolean flag = false;
                for(int j2 = 1; j2 < l1; j2++)
                {
                    int k2 = st - j2 & 0x1fff;
                    int l2 = i2 - j2 & 0x1fff;
                    if(tt[l2] != j1 || ut[l2] != k1)
                        flag = true;
                    if(tt[k2] != tt[l2] || ut[k2] != ut[l2])
                        break;
                    if(j2 == l1 - 1 && flag && pbb == 0 && obb == 0)
                    {
                        trylogout();
                        return;
                    }
                }

            }
        }

    }

    public void wk()
    {
        super.yc.hc();
        gt = true;
        z();
    }

    public void al()
    {
        gu = 0;
        tbb = 0;
        rcb = "";
        scb = "";
        pcb = "Please enter a username:";
        qcb = "*" + rcb + "*";
        vv = 0;
        hw = 0;
    }

    public void em()
    {
        super.br = "";
        super.cr = "";
    }

    public void trylogout()
    {
        if(gu == 0)
            return;
        if(pbb > 450)
        {
            tk("@cya@You can't logout during combat!", 3);
            return;
        }
        if(pbb > 0)
        {
            tk("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.yc.kb(6);
            super.yc.ib();
            obb = 1000;
            return;
        }
    }

    public void bm()
    {
        kdb = new g(cu, 100);
        int i1 = 8;
        ldb = kdb.qd(256, i1, "@yel@Please provide 5 security questions in case you lose your password", 1, true);
        i1 += 22;
        kdb.qd(256, i1, "If you ever lose your password, you will need these to prove you own your account.", 1, true);
        i1 += 13;
        kdb.qd(256, i1, "Your answers are encrypted and are ONLY used for password recovery purposes.", 1, true);
        i1 += 22;
        kdb.qd(256, i1, "@ora@IMPORTANT:@whi@ To recover your password you must give the EXACT same answers you", 1, true);
        i1 += 13;
        kdb.qd(256, i1, "give here. If you think you might forget an answer, or someone else could guess the", 1, true);
        i1 += 13;
        kdb.qd(256, i1, "answer, then press the 'different question' button to get a better question.", 1, true);
        i1 += 35;
        for(int j1 = 0; j1 < 5; j1++)
        {
            kdb.hd(170, i1, 310, 30);
            tdb[j1] = "~:" + sdb[j1];
            odb[j1] = kdb.qd(170, i1 - 7, (j1 + 1) + ": " + pfb[sdb[j1]], 1, true);
            pdb[j1] = kdb.fd(170, i1 + 7, 310, 30, 1, 80, false, true);
            kdb.hd(370, i1, 80, 30);
            kdb.qd(370, i1 - 7, "Different", 1, true);
            kdb.qd(370, i1 + 7, "Question", 1, true);
            qdb[j1] = kdb.td(370, i1, 80, 30);
            kdb.hd(455, i1, 80, 30);
            kdb.qd(455, i1 - 7, "Enter own", 1, true);
            kdb.qd(455, i1 + 7, "Question", 1, true);
            rdb[j1] = kdb.td(455, i1, 80, 30);
            i1 += 35;
        }

        kdb.uc(pdb[0]);
        i1 += 10;
        kdb.hd(256, i1, 250, 30);
        kdb.qd(256, i1, "Click here when finished", 4, true);
        mdb = kdb.td(256, i1, 250, 30);
    }

    public void bl()
    {
        if(ndb != -1)
        {
            if(super.cr.length() > 0)
            {
                tdb[ndb] = super.cr;
                kdb.rd(odb[ndb], (ndb + 1) + ": " + tdb[ndb]);
                kdb.rd(pdb[ndb], "");
                ndb = -1;
            }
            return;
        }
        kdb.wd(super.sq, super.tq, super.vq, super.uq);
        for(int i1 = 0; i1 < 5; i1++)
            if(kdb.yd(qdb[i1]))
            {
                for(boolean flag = false; !flag;)
                {
                    sdb[i1] = (sdb[i1] + 1) % pfb.length;
                    flag = true;
                    for(int k1 = 0; k1 < 5; k1++)
                        if(k1 != i1 && sdb[k1] == sdb[i1])
                            flag = false;

                }

                tdb[i1] = "~:" + sdb[i1];
                kdb.rd(odb[i1], (i1 + 1) + ": " + pfb[sdb[i1]]);
                kdb.rd(pdb[i1], "");
            }

        for(int j1 = 0; j1 < 5; j1++)
            if(kdb.yd(rdb[j1]))
            {
                ndb = j1;
                super.br = "";
                super.cr = "";
            }

        if(kdb.yd(mdb))
        {
            for(int l1 = 0; l1 < 5; l1++)
            {
                String s1 = kdb.wc(pdb[l1]);
                if(s1 == null || s1.length() < 3)
                {
                    kdb.rd(ldb, "@yel@Please provide a longer answer to question: " + (l1 + 1));
                    return;
                }
            }

            for(int i2 = 0; i2 < 5; i2++)
            {
                String s2 = kdb.wc(pdb[i2]);
                for(int k2 = 0; k2 < i2; k2++)
                {
                    String s4 = kdb.wc(pdb[k2]);
                    if(s2.equalsIgnoreCase(s4))
                    {
                        kdb.rd(ldb, "@yel@Each question must have a different answer");
                        return;
                    }
                }

            }

            super.yc.kb(208);
            for(int j2 = 0; j2 < 5; j2++)
            {
                String s3 = tdb[j2];
                if(s3 == null || s3.length() == 0)
                    s3 = String.valueOf(j2 + 1);
                if(s3.length() > 50)
                    s3 = s3.substring(0, 50);
                super.yc.dc(s3.length());
                super.yc.sb(s3);
                super.yc.qb(o.vn(kdb.wc(pdb[j2])), super.od, et, ft);
            }

            super.yc.ib();
            for(int l2 = 0; l2 < 5; l2++)
            {
                sdb[l2] = l2;
                tdb[l2] = "~:" + sdb[l2];
                kdb.rd(pdb[l2], "");
                kdb.rd(odb[l2], (l2 + 1) + ": " + pfb[sdb[l2]]);
            }

            cu.sf();
            jdb = false;
        }
    }

    public void qk()
    {
        cu.wk = false;
        cu.sf();
        kdb.oc();
        if(ndb != -1)
        {
            int i1 = 150;
            cu.eg(26, i1, 460, 60, 0);
            cu.xf(26, i1, 460, 60, 0xffffff);
            i1 += 22;
            cu.ah("Please enter your question", 256, i1, 4, 0xffffff);
            i1 += 25;
            cu.ah(super.br + "*", 256, i1, 4, 0xffffff);
        }
        cu.eh(0, iu, lu + 22);
        cu.qf(au, 0, 11);
    }

    public void nl()
    {
        vdb = new g(cu, 100);
        int i1 = 10;
        wdb = vdb.qd(256, i1, "@yel@To prove this is your account please provide the answers to", 1, true);
        i1 += 15;
        xdb = vdb.qd(256, i1, "@yel@your security questions. You will then be able to reset your password", 1, true);
        i1 += 35;
        for(int j1 = 0; j1 < 5; j1++)
        {
            vdb.hd(256, i1, 410, 30);
            geb[j1] = vdb.qd(256, i1 - 7, (j1 + 1) + ": question?", 1, true);
            heb[j1] = vdb.fd(256, i1 + 7, 310, 30, 1, 80, true, true);
            i1 += 35;
        }

        vdb.uc(heb[0]);
        vdb.hd(256, i1, 410, 30);
        vdb.qd(256, i1 - 7, "If you know it, enter a previous password used on this account", 1, true);
        ydb = vdb.fd(256, i1 + 7, 310, 30, 1, 80, true, true);
        i1 += 35;
        vdb.hd(151, i1, 200, 30);
        vdb.qd(151, i1 - 7, "Choose a NEW password", 1, true);
        zdb = vdb.fd(146, i1 + 7, 200, 30, 1, 80, true, true);
        vdb.hd(361, i1, 200, 30);
        vdb.qd(361, i1 - 7, "Confirm new password", 1, true);
        aeb = vdb.fd(366, i1 + 7, 200, 30, 1, 80, true, true);
        i1 += 35;
        vdb.hd(201, i1, 100, 30);
        vdb.qd(201, i1, "Submit", 4, true);
        beb = vdb.td(201, i1, 100, 30);
        vdb.hd(311, i1, 100, 30);
        vdb.qd(311, i1, "Cancel", 4, true);
        ceb = vdb.td(311, i1, 100, 30);
    }

    public void sl()
    {
        tcb = new g(cu, 100);
        tcb.qd(256, 10, "Design Your Character", 4, true);
        char c1 = '\214';
        int i1 = 34;
        tcb.hd(c1, i1, 200, 25);
        tcb.qd(c1, i1, "Appearance", 4, false);
        i1 += 15;
        tcb.qd(c1 - 55, i1 + 110, "Front", 3, true);
        tcb.qd(c1, i1 + 110, "Side", 3, true);
        tcb.qd(c1 + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        tcb.qc(c1 - byte0, i1, 53, 41);
        tcb.qd(c1 - byte0, i1 - 8, "Head", 1, true);
        tcb.qd(c1 - byte0, i1 + 8, "Type", 1, true);
        tcb.sc(c1 - byte0 - 40, i1, g.ig + 7);
        ucb = tcb.td(c1 - byte0 - 40, i1, 20, 20);
        tcb.sc((c1 - byte0) + 40, i1, g.ig + 6);
        vcb = tcb.td((c1 - byte0) + 40, i1, 20, 20);
        tcb.qc(c1 + byte0, i1, 53, 41);
        tcb.qd(c1 + byte0, i1 - 8, "Hair", 1, true);
        tcb.qd(c1 + byte0, i1 + 8, "Color", 1, true);
        tcb.sc((c1 + byte0) - 40, i1, g.ig + 7);
        wcb = tcb.td((c1 + byte0) - 40, i1, 20, 20);
        tcb.sc(c1 + byte0 + 40, i1, g.ig + 6);
        xcb = tcb.td(c1 + byte0 + 40, i1, 20, 20);
        i1 += 50;
        tcb.qc(c1 - byte0, i1, 53, 41);
        tcb.qd(c1 - byte0, i1, "Gender", 1, true);
        tcb.sc(c1 - byte0 - 40, i1, g.ig + 7);
        ycb = tcb.td(c1 - byte0 - 40, i1, 20, 20);
        tcb.sc((c1 - byte0) + 40, i1, g.ig + 6);
        zcb = tcb.td((c1 - byte0) + 40, i1, 20, 20);
        tcb.qc(c1 + byte0, i1, 53, 41);
        tcb.qd(c1 + byte0, i1 - 8, "Top", 1, true);
        tcb.qd(c1 + byte0, i1 + 8, "Color", 1, true);
        tcb.sc((c1 + byte0) - 40, i1, g.ig + 7);
        adb = tcb.td((c1 + byte0) - 40, i1, 20, 20);
        tcb.sc(c1 + byte0 + 40, i1, g.ig + 6);
        bdb = tcb.td(c1 + byte0 + 40, i1, 20, 20);
        i1 += 50;
        tcb.qc(c1 - byte0, i1, 53, 41);
        tcb.qd(c1 - byte0, i1 - 8, "Skin", 1, true);
        tcb.qd(c1 - byte0, i1 + 8, "Color", 1, true);
        tcb.sc(c1 - byte0 - 40, i1, g.ig + 7);
        cdb = tcb.td(c1 - byte0 - 40, i1, 20, 20);
        tcb.sc((c1 - byte0) + 40, i1, g.ig + 6);
        ddb = tcb.td((c1 - byte0) + 40, i1, 20, 20);
        tcb.qc(c1 + byte0, i1, 53, 41);
        tcb.qd(c1 + byte0, i1 - 8, "Bottom", 1, true);
        tcb.qd(c1 + byte0, i1 + 8, "Color", 1, true);
        tcb.sc((c1 + byte0) - 40, i1, g.ig + 7);
        edb = tcb.td((c1 + byte0) - 40, i1, 20, 20);
        tcb.sc(c1 + byte0 + 40, i1, g.ig + 6);
        fdb = tcb.td(c1 + byte0 + 40, i1, 20, 20);
        c1 = '\u0174';
        i1 = 35;
        tcb.hd(c1, i1, 200, 25);
        tcb.qd(c1, i1, "Character Type", 4, false);
        i1 += 22;
        tcb.qd(c1, i1, "Each character type has different starting", 0, true);
        i1 += 13;
        tcb.qd(c1, i1, "bonuses. But the choice you make here", 0, true);
        i1 += 13;
        tcb.qd(c1, i1, "isn't permanent, and will change depending", 0, true);
        i1 += 13;
        tcb.qd(c1, i1, "on how you play the game.", 0, true);
        i1 += 73;
        tcb.qc(c1, i1, 215, 125);
        String as[] = {
            "Adventurer", "Warrior", "Wizard", "Ranger", "Miner"
        };
        hdb = tcb.jc(c1, i1 + 2, as, 3, true);
        i1 += 82;
        tcb.hd(c1, i1, 200, 30);
        tcb.qd(c1, i1, "Start Game", 4, false);
        gdb = tcb.td(c1, i1, 200, 30);
    }

    public void uk()
    {
        cu.wk = false;
        cu.sf();
        tcb.oc();
        char c1 = '\214';
        byte byte0 = 50;
        cu.sg(c1 - 32 - 55, byte0, 64, 102, r.ekb[dfb], jfb[gfb]);
        cu.cg(c1 - 32 - 55, byte0, 64, 102, r.ekb[cfb], jfb[ffb], lfb[hfb], 0, false);
        cu.cg(c1 - 32 - 55, byte0, 64, 102, r.ekb[bfb], kfb[efb], lfb[hfb], 0, false);
        cu.sg(c1 - 32, byte0, 64, 102, r.ekb[dfb] + 6, jfb[gfb]);
        cu.cg(c1 - 32, byte0, 64, 102, r.ekb[cfb] + 6, jfb[ffb], lfb[hfb], 0, false);
        cu.cg(c1 - 32, byte0, 64, 102, r.ekb[bfb] + 6, kfb[efb], lfb[hfb], 0, false);
        cu.sg((c1 - 32) + 55, byte0, 64, 102, r.ekb[dfb] + 12, jfb[gfb]);
        cu.cg((c1 - 32) + 55, byte0, 64, 102, r.ekb[cfb] + 12, jfb[ffb], lfb[hfb], 0, false);
        cu.cg((c1 - 32) + 55, byte0, 64, 102, r.ekb[bfb] + 12, kfb[efb], lfb[hfb], 0, false);
        cu.eh(0, iu, lu + 22);
        cu.qf(au, 0, 11);
    }

    public void el()
    {
        tcb.wd(super.sq, super.tq, super.vq, super.uq);
        if(tcb.yd(ucb))
            do
                bfb = ((bfb - 1) + r.xjb) % r.xjb;
            while((r.bkb[bfb] & 3) != 1 || (r.bkb[bfb] & 4 * ifb) == 0);
        if(tcb.yd(vcb))
            do
                bfb = (bfb + 1) % r.xjb;
            while((r.bkb[bfb] & 3) != 1 || (r.bkb[bfb] & 4 * ifb) == 0);
        if(tcb.yd(wcb))
            efb = ((efb - 1) + kfb.length) % kfb.length;
        if(tcb.yd(xcb))
            efb = (efb + 1) % kfb.length;
        if(tcb.yd(ycb) || tcb.yd(zcb))
        {
            for(ifb = 3 - ifb; (r.bkb[bfb] & 3) != 1 || (r.bkb[bfb] & 4 * ifb) == 0; bfb = (bfb + 1) % r.xjb);
            for(; (r.bkb[cfb] & 3) != 2 || (r.bkb[cfb] & 4 * ifb) == 0; cfb = (cfb + 1) % r.xjb);
        }
        if(tcb.yd(adb))
            ffb = ((ffb - 1) + jfb.length) % jfb.length;
        if(tcb.yd(bdb))
            ffb = (ffb + 1) % jfb.length;
        if(tcb.yd(cdb))
            hfb = ((hfb - 1) + lfb.length) % lfb.length;
        if(tcb.yd(ddb))
            hfb = (hfb + 1) % lfb.length;
        if(tcb.yd(edb))
            gfb = ((gfb - 1) + jfb.length) % jfb.length;
        if(tcb.yd(fdb))
            gfb = (gfb + 1) % jfb.length;
        if(tcb.yd(gdb))
        {
            super.yc.kb(236);
            super.yc.dc(ifb);
            super.yc.dc(bfb);
            super.yc.dc(cfb);
            super.yc.dc(dfb);
            super.yc.dc(efb);
            super.yc.dc(ffb);
            super.yc.dc(gfb);
            super.yc.dc(hfb);
            super.yc.dc(tcb.ad(hdb));
            super.yc.ib();
            cu.sf();
            afb = false;
        }
    }

    public void dl()
    {
        ubb = new g(cu, 50);
        int i1 = 40;
        ubb.qd(256, 200 + i1, "Click on an option", 5, true);
        ubb.hd(156, 240 + i1, 120, 35);
        ubb.hd(356, 240 + i1, 120, 35);
        ubb.qd(156, 240 + i1, "New User", 5, false);
        ubb.qd(356, 240 + i1, "Existing User", 5, false);
        vbb = ubb.td(156, 240 + i1, 120, 35);
        wbb = ubb.td(356, 240 + i1, 120, 35);
        xbb = new g(cu, 50);
        i1 = 70;
        ybb = xbb.qd(256, i1 + 8, "To create an account please enter all the requested details", 4, true);
        i1 += 25;
        xbb.hd(256, i1 + 17, 250, 34);
        xbb.qd(256, i1 + 8, "Choose a Username", 4, false);
        ccb = xbb.fd(256, i1 + 25, 200, 40, 4, 12, false, false);
        xbb.uc(ccb);
        i1 += 40;
        xbb.hd(141, i1 + 17, 220, 34);
        xbb.qd(141, i1 + 8, "Choose a Password", 4, false);
        dcb = xbb.fd(141, i1 + 25, 220, 40, 4, 20, true, false);
        xbb.hd(371, i1 + 17, 220, 34);
        xbb.qd(371, i1 + 8, "Confirm Password", 4, false);
        ecb = xbb.fd(371, i1 + 25, 220, 40, 4, 20, true, false);
        i1 += 40;
        i1 += 20;
        fcb = xbb.zc(60, i1, 14);
        xbb.rc(75, i1, "I have read and agree to the terms+conditions listed at:", 4, true);
        i1 += 15;
        xbb.qd(256, i1, "http://www.runescape.com/runeterms.html", 4, true);
        i1 += 20;
        xbb.hd(156, i1 + 17, 150, 34);
        xbb.qd(156, i1 + 17, "Submit", 5, false);
        bcb = xbb.td(156, i1 + 17, 150, 34);
        xbb.hd(356, i1 + 17, 150, 34);
        xbb.qd(356, i1 + 17, "Cancel", 5, false);
        acb = xbb.td(356, i1 + 17, 150, 34);
        gcb = new g(cu, 50);
        i1 = 230;
        hcb = gcb.qd(256, i1 - 10, "Please enter your username and password", 4, true);
        i1 += 28;
        gcb.hd(140, i1, 200, 40);
        gcb.qd(140, i1 - 10, "Username:", 4, false);
        icb = gcb.fd(140, i1 + 10, 200, 40, 4, 12, false, false);
        i1 += 47;
        gcb.hd(190, i1, 200, 40);
        gcb.qd(190, i1 - 10, "Password:", 4, false);
        jcb = gcb.fd(190, i1 + 10, 200, 40, 4, 20, true, false);
        i1 -= 55;
        gcb.hd(410, i1, 120, 25);
        gcb.qd(410, i1, "Ok", 4, false);
        kcb = gcb.td(410, i1, 120, 25);
        i1 += 30;
        gcb.hd(410, i1, 120, 25);
        gcb.qd(410, i1, "Cancel", 4, false);
        lcb = gcb.td(410, i1, 120, 25);
        i1 += 30;
        gcb.hd(410, i1, 160, 25);
        gcb.qd(410, i1, "I've lost my password", 4, false);
        mcb = gcb.td(410, i1, 160, 25);
        gcb.uc(icb);
    }

    public void wm()
    {
        cu.wk = false;
        cu.sf();
        if(tbb == 0 || tbb == 2)
        {
            int i1 = (mt * 2) % 3072;
            if(i1 < 1024)
            {
                cu.eh(0, 10, 2500);
                if(i1 > 768)
                    cu.wg(0, 10, 2501, i1 - 768);
            } else
            if(i1 < 2048)
            {
                cu.eh(0, 10, 2501);
                if(i1 > 1792)
                    cu.wg(0, 10, lu + 10, i1 - 1792);
            } else
            {
                cu.eh(0, 10, lu + 10);
                if(i1 > 2816)
                    cu.wg(0, 10, 2500, i1 - 2816);
            }
        }
        if(tbb == 0)
            ubb.oc();
        if(tbb == 1)
            xbb.oc();
        if(tbb == 2)
            gcb.oc();
        if(tbb == 3)
            vdb.oc();
        cu.eh(0, iu, lu + 22);
        cu.qf(au, 0, 11);
    }

    public void dm()
    {
        int i1 = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        wu.yo(byte0 * 48 + 23, byte1 * 48 + 23, i1);
        wu.ro(bx);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        bu.jm = 4100;
        bu.km = 4100;
        bu.lm = 1;
        bu.mm = 4000;
        bu.gi(c1, -wu.po(c1, c2), c2, 912, c4, 0, c3 * 2);
        bu.cj();
        cu.mf();
        cu.mf();
        cu.eg(0, 0, 512, 6, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            cu.yg(0, j1, 0, j1, 512, 8);

        cu.eg(0, 194, 512, 20, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            cu.yg(0, k1, 0, 194 - k1, 512, 8);

        cu.eh(15, 15, lu + 10);
        cu.bh(2500, 0, 0, 512, 200);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        bu.jm = 4100;
        bu.km = 4100;
        bu.lm = 1;
        bu.mm = 4000;
        bu.gi(c1, -wu.po(c1, c2), c2, 912, c4, 0, c3 * 2);
        bu.cj();
        cu.mf();
        cu.mf();
        cu.eg(0, 0, 512, 6, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            cu.yg(0, l1, 0, l1, 512, 8);

        cu.eg(0, 194, 512, 20, 0);
        for(int i2 = 6; i2 >= 1; i2--)
            cu.yg(0, i2, 0, 194 - i2, 512, 8);

        cu.eh(15, 15, lu + 10);
        cu.bh(2501, 0, 0, 512, 200);
        for(int j2 = 0; j2 < 64; j2++)
        {
            bu.fi(wu.ehb[0][j2]);
            bu.fi(wu.dhb[1][j2]);
            bu.fi(wu.ehb[1][j2]);
            bu.fi(wu.dhb[2][j2]);
            bu.fi(wu.ehb[2][j2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        bu.jm = 4100;
        bu.km = 4100;
        bu.lm = 1;
        bu.mm = 4000;
        bu.gi(c1, -wu.po(c1, c2), c2, 912, c4, 0, c3 * 2);
        bu.cj();
        cu.mf();
        cu.mf();
        cu.eg(0, 0, 512, 6, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            cu.yg(0, k2, 0, k2, 512, 8);

        cu.eg(0, 194, 512, 20, 0);
        for(int l2 = 6; l2 >= 1; l2--)
            cu.yg(0, l2, 0, 194, 512, 8);

        cu.eh(15, 15, lu + 10);
        cu.bh(lu + 10, 0, 0, 512, 200);
    }

    public void ql()
    {
        if(super.pd > 0)
            super.pd--;
        if(tbb == 0)
        {
            ubb.wd(super.sq, super.tq, super.vq, super.uq);
            if(ubb.yd(vbb))
            {
                tbb = 1;
                xbb.rd(ccb, "");
                xbb.rd(dcb, "");
                xbb.rd(ecb, "");
                xbb.uc(ccb);
                xbb.cd(fcb, 0);
                xbb.rd(ybb, "To create an account please enter all the requested details");
            }
            if(ubb.yd(wbb))
            {
                tbb = 2;
                gcb.rd(hcb, "Please enter your username and password");
                gcb.rd(icb, "");
                gcb.rd(jcb, "");
                gcb.uc(icb);
                return;
            }
        } else
        if(tbb == 1)
        {
            xbb.wd(super.sq, super.tq, super.vq, super.uq);
            if(xbb.yd(ccb))
                xbb.uc(dcb);
            if(xbb.yd(dcb))
                xbb.uc(ecb);
            if(xbb.yd(ecb))
                xbb.uc(ccb);
            if(xbb.yd(acb))
                tbb = 0;
            if(xbb.yd(bcb))
            {
                if(xbb.wc(ccb) == null || xbb.wc(ccb).length() == 0 || xbb.wc(dcb) == null || xbb.wc(dcb).length() == 0)
                {
                    xbb.rd(ybb, "@yel@Please fill in ALL requested information to continue!");
                    return;
                }
                if(!xbb.wc(dcb).equalsIgnoreCase(xbb.wc(ecb)))
                {
                    xbb.rd(ybb, "@yel@The two passwords entered are not the same as each other!");
                    return;
                }
                if(xbb.wc(dcb).length() < 5)
                {
                    xbb.rd(ybb, "@yel@Your password must be at least 5 letters long");
                    return;
                }
                if(xbb.ad(fcb) == 0)
                {
                    xbb.rd(ybb, "@yel@You must agree to the terms+conditions to continue");
                    return;
                } else
                {
                    xbb.rd(ybb, "Please wait... Creating new account");
                    wm();
                    dk();
                    String s1 = xbb.wc(ccb);
                    String s3 = xbb.wc(dcb);
                    p(s1, s3);
                    return;
                }
            }
        } else
        if(tbb == 2)
        {
            gcb.wd(super.sq, super.tq, super.vq, super.uq);
            if(gcb.yd(lcb))
                tbb = 0;
            if(gcb.yd(icb))
                gcb.uc(jcb);
            if(gcb.yd(jcb) || gcb.yd(kcb))
            {
                rcb = gcb.wc(icb);
                scb = gcb.wc(jcb);
                o(rcb, scb, false);
            }
            if(gcb.yd(mcb))
            {
                rcb = gcb.wc(icb);
                rcb = o._mthdo(rcb, 20);
                if(rcb.trim().length() == 0)
                {
                    gb("You must enter your username to recover your password", "");
                    return;
                }
                gb(e.qc[6], e.qc[7]);
                try
                {
                    if(ek())
                        super.yc = a.b(super.tc, this, super.vc);
                    else
                        super.yc = a.b(super.tc, null, super.vc);
                    super.yc.se = e.sc;
                    super.yc.nb();
                    super.yc.kb(4);
                    super.yc.wb(o.sn(rcb));
                    super.yc.vb();
                    super.yc.ob();
                    int i1 = super.yc.mb();
                    System.out.println("Getpq response: " + i1);
                    if(i1 == 0)
                    {
                        gb("Sorry, the recovery questions for this user have not been set", "");
                        return;
                    }
                    for(int j1 = 0; j1 < 5; j1++)
                    {
                        int k1 = super.yc.mb();
                        byte abyte0[] = new byte[5000];
                        super.yc.yb(k1, abyte0);
                        String s6 = new String(abyte0, 0, k1);
                        if(s6.startsWith("~:"))
                        {
                            s6 = s6.substring(2);
                            int j2 = 0;
                            try
                            {
                                j2 = Integer.parseInt(s6);
                            }
                            catch(Exception _ex) { }
                            s6 = pfb[j2];
                        }
                        vdb.rd(geb[j1], s6);
                    }

                    if(udb)
                    {
                        gb("Sorry, you have already attempted 1 recovery, try again later", "");
                        return;
                    }
                    tbb = 3;
                    vdb.rd(wdb, "@yel@To prove this is your account please provide the answers to");
                    vdb.rd(xdb, "@yel@your security questions. You will then be able to reset your password");
                    for(int l1 = 0; l1 < 5; l1++)
                        vdb.rd(heb[l1], "");

                    vdb.rd(ydb, "");
                    vdb.rd(zdb, "");
                    vdb.rd(aeb, "");
                    return;
                }
                catch(Exception _ex)
                {
                    gb(e.qc[12], e.qc[13]);
                }
                return;
            }
        } else
        if(tbb == 3)
        {
            vdb.wd(super.sq, super.tq, super.vq, super.uq);
            if(vdb.yd(beb))
            {
                String s2 = vdb.wc(zdb);
                String s4 = vdb.wc(aeb);
                if(!s2.equalsIgnoreCase(s4))
                {
                    gb("@yel@The two new passwords entered are not the same as each other!", "");
                    return;
                }
                if(s2.length() < 5)
                {
                    gb("@yel@Your new password must be at least 5 letters long", "");
                    return;
                }
                gb(e.qc[6], e.qc[7]);
                try
                {
                    if(ek())
                        super.yc = a.b(super.tc, this, super.vc);
                    else
                        super.yc = a.b(super.tc, null, super.vc);
                    super.yc.se = e.sc;
                    int i2 = super.yc.nb();
                    String s5 = o._mthdo(vdb.wc(ydb), 20);
                    String s7 = o._mthdo(vdb.wc(zdb), 20);
                    super.yc.kb(8);
                    super.yc.wb(o.sn(rcb));
                    super.yc.bc(f());
                    super.yc.ub(s5 + s7, i2, et, ft);
                    for(int k2 = 0; k2 < 5; k2++)
                        super.yc.qb(o.vn(vdb.wc(heb[k2])), i2, et, ft);

                    super.yc.vb();
                    super.yc.ob();
                    int l2 = super.yc.mb();
                    System.out.println("Recover response: " + l2);
                    if(l2 == 0)
                    {
                        tbb = 2;
                        gb("Sorry, recovery failed. You may try again in 1 hour", "");
                        udb = true;
                        return;
                    }
                    if(l2 == 1)
                    {
                        tbb = 2;
                        gb("Your pass has been reset. You may now use the new pass to login", "");
                        return;
                    } else
                    {
                        tbb = 2;
                        gb("Recovery failed! Attempts exceeded?", "");
                        return;
                    }
                }
                catch(Exception _ex)
                {
                    gb(e.qc[12], e.qc[13]);
                }
            }
            if(vdb.yd(ceb))
                tbb = 0;
        }
    }

    public void gb(String s1, String s2)
    {
        if(tbb == 1)
            xbb.rd(ybb, s1 + " " + s2);
        if(tbb == 2)
            gcb.rd(hcb, s1 + " " + s2);
        if(tbb == 3)
        {
            vdb.rd(wdb, s1);
            vdb.rd(xdb, s2);
        }
        qcb = s2;
        wm();
        dk();
    }

    public void n()
    {
        obb = 0;
        tk("@cya@Sorry, you can't logout at the moment", 3);
    }

    public void s()
    {
        if(obb != 0)
        {
            j();
            return;
        } else
        {
            super.s();
            return;
        }
    }

    public void j()
    {
        tbb = 0;
        gu = 0;
        obb = 0;
    }

    public void i()
    {
        jbb = 0;
        obb = 0;
        tbb = 0;
        gu = 1;
        em();
        cu.sf();
        cu.qf(au, 0, 11);
        for(int i1 = 0; i1 < vw; i1++)
        {
            bu.fi(ww[i1]);
            wu.gp(xw[i1], yw[i1], zw[i1]);
        }

        for(int j1 = 0; j1 < ex; j1++)
        {
            bu.fi(fx[j1]);
            wu.go(gx[j1], hx[j1], ix[j1], jx[j1]);
        }

        vw = 0;
        ex = 0;
        ow = 0;
        vv = 0;
        for(int k1 = 0; k1 < tv; k1++)
            yv[k1] = null;

        for(int l1 = 0; l1 < uv; l1++)
            zv[l1] = null;

        hw = 0;
        for(int i2 = 0; i2 < fw; i2++)
            jw[i2] = null;

        for(int j2 = 0; j2 < gw; j2++)
            kw[j2] = null;

        for(int k2 = 0; k2 < 50; k2++)
            py[k2] = false;

        ot = 0;
        super.vq = 0;
        super.uq = 0;
        sab = false;
        abb = false;
    }

    public void x()
    {
        String s1 = xbb.wc(ccb);
        String s2 = xbb.wc(dcb);
        tbb = 2;
        gcb.rd(hcb, "Please enter your username and password");
        gcb.rd(icb, s1);
        gcb.rd(jcb, s2);
        wm();
        dk();
        o(s1, s2, false);
    }

    public void vm()
    {
        m();
        if(obb > 0)
            obb--;
        if(super.yp > 4500 && pbb == 0 && obb == 0)
        {
            super.yp -= 500;
            trylogout();
            return;
        }
        if(bw.mr == 8 || bw.mr == 9)
            pbb = 500;
        if(pbb > 0)
            pbb--;
        if(afb)
        {
            el();
            return;
        }
        if(jdb)
        {
            bl();
            return;
        }
        for(int i1 = 0; i1 < vv; i1++)
        {
            l l1 = zv[i1];
            int k1 = (l1.pr + 1) % 10;
            if(l1.or != k1)
            {
                int j2 = -1;
                int k4 = l1.or;
                int l5;
                if(k4 < k1)
                    l5 = k1 - k4;
                else
                    l5 = (10 + k1) - k4;
                int k6 = 4;
                if(l5 > 2)
                    k6 = (l5 - 1) * 4;
                if(l1.qr[k4] - l1.ir > fu * 3 || l1.rr[k4] - l1.jr > fu * 3 || l1.qr[k4] - l1.ir < -fu * 3 || l1.rr[k4] - l1.jr < -fu * 3 || l5 > 8)
                {
                    l1.ir = l1.qr[k4];
                    l1.jr = l1.rr[k4];
                } else
                {
                    if(l1.ir < l1.qr[k4])
                    {
                        l1.ir += k6;
                        l1.lr++;
                        j2 = 2;
                    } else
                    if(l1.ir > l1.qr[k4])
                    {
                        l1.ir -= k6;
                        l1.lr++;
                        j2 = 6;
                    }
                    if(l1.ir - l1.qr[k4] < k6 && l1.ir - l1.qr[k4] > -k6)
                        l1.ir = l1.qr[k4];
                    if(l1.jr < l1.rr[k4])
                    {
                        l1.jr += k6;
                        l1.lr++;
                        if(j2 == -1)
                            j2 = 4;
                        else
                        if(j2 == 2)
                            j2 = 3;
                        else
                            j2 = 5;
                    } else
                    if(l1.jr > l1.rr[k4])
                    {
                        l1.jr -= k6;
                        l1.lr++;
                        if(j2 == -1)
                            j2 = 0;
                        else
                        if(j2 == 2)
                            j2 = 1;
                        else
                            j2 = 7;
                    }
                    if(l1.jr - l1.rr[k4] < k6 && l1.jr - l1.rr[k4] > -k6)
                        l1.jr = l1.rr[k4];
                }
                if(j2 != -1)
                    l1.mr = j2;
                if(l1.ir == l1.qr[k4] && l1.jr == l1.rr[k4])
                    l1.or = (k4 + 1) % 10;
            } else
            {
                l1.mr = l1.nr;
            }
            if(l1.ur > 0)
                l1.ur--;
            if(l1.wr > 0)
                l1.wr--;
            if(l1.as > 0)
                l1.as--;
            if(qbb > 0)
            {
                qbb--;
                if(qbb == 0)
                    tk("You have been granted another life. Be more careful this time!", 3);
                if(qbb == 0)
                    tk("You retain your skills. Unless you attacked another player recently,", 3);
                if(qbb == 0)
                    tk("you also keep your best 3 items. Everything else lands where you died.", 3);
            }
        }

        for(int j1 = 0; j1 < hw; j1++)
        {
            l l2 = kw[j1];
            int k2 = (l2.pr + 1) % 10;
            if(l2.or != k2)
            {
                int l4 = -1;
                int i6 = l2.or;
                int l6;
                if(i6 < k2)
                    l6 = k2 - i6;
                else
                    l6 = (10 + k2) - i6;
                int i7 = 4;
                if(l6 > 2)
                    i7 = (l6 - 1) * 4;
                if(l2.qr[i6] - l2.ir > fu * 3 || l2.rr[i6] - l2.jr > fu * 3 || l2.qr[i6] - l2.ir < -fu * 3 || l2.rr[i6] - l2.jr < -fu * 3 || l6 > 8)
                {
                    l2.ir = l2.qr[i6];
                    l2.jr = l2.rr[i6];
                } else
                {
                    if(l2.ir < l2.qr[i6])
                    {
                        l2.ir += i7;
                        l2.lr++;
                        l4 = 2;
                    } else
                    if(l2.ir > l2.qr[i6])
                    {
                        l2.ir -= i7;
                        l2.lr++;
                        l4 = 6;
                    }
                    if(l2.ir - l2.qr[i6] < i7 && l2.ir - l2.qr[i6] > -i7)
                        l2.ir = l2.qr[i6];
                    if(l2.jr < l2.rr[i6])
                    {
                        l2.jr += i7;
                        l2.lr++;
                        if(l4 == -1)
                            l4 = 4;
                        else
                        if(l4 == 2)
                            l4 = 3;
                        else
                            l4 = 5;
                    } else
                    if(l2.jr > l2.rr[i6])
                    {
                        l2.jr -= i7;
                        l2.lr++;
                        if(l4 == -1)
                            l4 = 0;
                        else
                        if(l4 == 2)
                            l4 = 1;
                        else
                            l4 = 7;
                    }
                    if(l2.jr - l2.rr[i6] < i7 && l2.jr - l2.rr[i6] > -i7)
                        l2.jr = l2.rr[i6];
                }
                if(l4 != -1)
                    l2.mr = l4;
                if(l2.ir == l2.qr[i6] && l2.jr == l2.rr[i6])
                    l2.or = (i6 + 1) % 10;
            } else
            {
                l2.mr = l2.nr;
            }
            if(l2.ur > 0)
                l2.ur--;
            if(l2.wr > 0)
                l2.wr--;
            if(l2.as > 0)
                l2.as--;
        }

        for(int i2 = 0; i2 < vv; i2++)
        {
            l l3 = zv[i2];
            if(l3.js > 0)
                l3.js--;
        }

        if(qy)
        {
            if(nv - bw.ir < -500 || nv - bw.ir > 500 || ov - bw.jr < -500 || ov - bw.jr > 500)
            {
                nv = bw.ir;
                ov = bw.jr;
            }
        } else
        {
            if(nv - bw.ir < -500 || nv - bw.ir > 500 || ov - bw.jr < -500 || ov - bw.jr > 500)
            {
                nv = bw.ir;
                ov = bw.jr;
            }
            if(nv != bw.ir)
                nv += (bw.ir - nv) / (16 + (lv - 500) / 15);
            if(ov != bw.jr)
                ov += (bw.jr - ov) / (16 + (lv - 500) / 15);
            if(ry)
            {
                int i3 = pv * 32;
                int i5 = i3 - rv;
                byte byte0 = 1;
                if(i5 != 0)
                {
                    qv++;
                    if(i5 > 128)
                    {
                        byte0 = -1;
                        i5 = 256 - i5;
                    } else
                    if(i5 > 0)
                        byte0 = 1;
                    else
                    if(i5 < -128)
                    {
                        byte0 = 1;
                        i5 = 256 + i5;
                    } else
                    if(i5 < 0)
                    {
                        byte0 = -1;
                        i5 = -i5;
                    }
                    rv += ((qv * i5 + 255) / 256) * byte0;
                    rv &= 0xff;
                } else
                {
                    qv = 0;
                }
            }
        }
        if(super.tq > iu - 4)
        {
            if(super.sq > 15 && super.sq < 96 && super.vq == 1)
                sz = 0;
            if(super.sq > 110 && super.sq < 194 && super.vq == 1)
            {
                sz = 1;
                nz.af[oz] = 0xf423f;
            }
            if(super.sq > 215 && super.sq < 295 && super.vq == 1)
            {
                sz = 2;
                nz.af[qz] = 0xf423f;
            }
            if(super.sq > 315 && super.sq < 395 && super.vq == 1)
            {
                sz = 3;
                nz.af[rz] = 0xf423f;
            }
            super.vq = 0;
            super.uq = 0;
        }
        nz.wd(super.sq, super.tq, super.vq, super.uq);
        if(sz > 0 && super.sq >= 494 && super.tq >= iu - 66)
            super.vq = 0;
        if(nz.yd(pz))
        {
            String s1 = nz.wc(pz);
            nz.rd(pz, "");
            if(s1.startsWith("admin:"))
            {
                if(s1.equalsIgnoreCase("admin:lostcon99") && !lt)
                    super.yc.hb();
                else
                if(s1.equalsIgnoreCase("admin:closecon99") && !lt)
                    eb();
                else
                    u(s1.substring(6));
            } else
            {
                int j5 = o.mn(s1);
                t(o.wfb, j5);
                s1 = o.qn(o.wfb, 0, j5, true);
                bw.ur = 150;
                bw.tr = s1;
                tk(bw.fr + ": " + s1, 2);
            }
        }
        if(sz == 0)
        {
            for(int j3 = 0; j3 < tz; j3++)
                if(vz[j3] > 0)
                    vz[j3]--;

        }
        if(qbb != 0)
            super.vq = 0;
        if(xz)
        {
            if(super.uq != 0)
                hab++;
            else
                hab = 0;
            if(hab > 300)
                iab += 50;
            else
            if(hab > 150)
                iab += 5;
            else
            if(hab > 50)
                iab++;
            else
            if(hab > 20 && (hab & 5) == 0)
                iab++;
        } else
        {
            hab = 0;
            iab = 0;
        }
        if(super.vq == 1)
            ot = 1;
        else
        if(super.vq == 2)
            ot = 2;
        bu.ci(super.sq, super.tq);
        super.vq = 0;
        if(ry)
        {
            if(qv == 0 || qy)
            {
                if(super.lq)
                {
                    pv = pv + 1 & 7;
                    super.lq = false;
                    if(!mv)
                    {
                        if((pv & 1) == 0)
                            pv = pv + 1 & 7;
                        for(int k3 = 0; k3 < 8; k3++)
                        {
                            if(lm(pv))
                                break;
                            pv = pv + 1 & 7;
                        }

                    }
                }
                if(super.mq)
                {
                    pv = pv + 7 & 7;
                    super.mq = false;
                    if(!mv)
                    {
                        if((pv & 1) == 0)
                            pv = pv + 7 & 7;
                        for(int i4 = 0; i4 < 8; i4++)
                        {
                            if(lm(pv))
                                break;
                            pv = pv + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.lq)
            rv = rv + 2 & 0xff;
        else
        if(super.mq)
            rv = rv - 2 & 0xff;
        if(mv && lv > 550)
            lv -= 4;
        else
        if(!mv && lv < 750)
            lv += 4;
        if(tu > 0)
            tu--;
        else
        if(tu < 0)
            tu++;
        bu.mi(17);
        ou++;
        if(ou > 5)
        {
            ou = 0;
            pu = pu + 1 & 3;
            qu = (qu + 1) % 3;
        }
        for(int j4 = 0; j4 < vw; j4++)
        {
            int k5 = xw[j4];
            int j6 = yw[j4];
            if(k5 >= 0 && j6 >= 0 && k5 < 96 && j6 < 96 && zw[j4] == 74)
                ww[j4].cf(1, 0, 0);
        }

    }

    public void tk(String s1, int i1)
    {
        if(i1 == 2 || i1 == 4 || i1 == 6)
        {
            for(; s1.length() > 5 && s1.charAt(0) == '@' && s1.charAt(4) == '@'; s1 = s1.substring(5));
            int j1 = s1.indexOf(":");
            if(j1 != -1)
            {
                String s2 = s1.substring(0, j1);
                long l1 = o.sn(s2);
                for(int i2 = 0; i2 < super.fd; i2++)
                    if(super.gd[i2] == l1)
                        return;

            }
        }
        if(i1 == 2)
            s1 = "@yel@" + s1;
        if(i1 == 3 || i1 == 4)
            s1 = "@whi@" + s1;
        if(i1 == 6)
            s1 = "@cya@" + s1;
        if(sz != 0)
        {
            if(i1 == 4 || i1 == 3)
                jz = 200;
            if(i1 == 2 && sz != 1)
                kz = 200;
            if(i1 == 5 && sz != 2)
                lz = 200;
            if(i1 == 6 && sz != 3)
                mz = 200;
            if(i1 == 3 && sz != 0)
                sz = 0;
            if(i1 == 6 && sz != 3 && sz != 0)
                sz = 0;
        }
        for(int k1 = tz - 1; k1 > 0; k1--)
        {
            uz[k1] = uz[k1 - 1];
            vz[k1] = vz[k1 - 1];
        }

        uz[0] = s1;
        vz[0] = 300;
        if(i1 == 2)
            if(nz.af[oz] == nz.bf[oz] - 4)
                nz.nc(oz, s1, true);
            else
                nz.nc(oz, s1, false);
        if(i1 == 5)
            if(nz.af[qz] == nz.bf[qz] - 4)
                nz.nc(qz, s1, true);
            else
                nz.nc(qz, s1, false);
        if(i1 == 6)
        {
            if(nz.af[rz] == nz.bf[rz] - 4)
            {
                nz.nc(rz, s1, true);
                return;
            }
            nz.nc(rz, s1, false);
        }
    }

    public void k(String s1)
    {
        if(s1.startsWith("@bor@"))
        {
            tk(s1, 4);
            return;
        }
        if(s1.startsWith("@que@"))
        {
            tk("@whi@" + s1, 5);
            return;
        }
        if(s1.startsWith("@pri@"))
        {
            tk(s1, 6);
            return;
        } else
        {
            tk(s1, 3);
            return;
        }
    }

    public l zk(int i1, int j1, int k1, int l1)
    {
        if(yv[i1] == null)
        {
            yv[i1] = new l();
            yv[i1].gr = i1;
            yv[i1].hr = 0;
        }
        l l2 = yv[i1];
        boolean flag = false;
        for(int i2 = 0; i2 < wv; i2++)
        {
            if(aw[i2].gr != i1)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            l2.nr = l1;
            int j2 = l2.pr;
            if(j1 != l2.qr[j2] || k1 != l2.rr[j2])
            {
                l2.pr = j2 = (j2 + 1) % 10;
                l2.qr[j2] = j1;
                l2.rr[j2] = k1;
            }
        } else
        {
            l2.gr = i1;
            l2.or = 0;
            l2.pr = 0;
            l2.qr[0] = l2.ir = j1;
            l2.rr[0] = l2.jr = k1;
            l2.nr = l2.mr = l1;
            l2.lr = 0;
        }
        zv[vv++] = l2;
        return l2;
    }

    public l tm(int i1, int j1, int k1, int l1, int i2)
    {
        if(jw[i1] == null)
        {
            jw[i1] = new l();
            jw[i1].gr = i1;
        }
        l l2 = jw[i1];
        boolean flag = false;
        for(int j2 = 0; j2 < iw; j2++)
        {
            if(lw[j2].gr != i1)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            l2.kr = i2;
            l2.nr = l1;
            int k2 = l2.pr;
            if(j1 != l2.qr[k2] || k1 != l2.rr[k2])
            {
                l2.pr = k2 = (k2 + 1) % 10;
                l2.qr[k2] = j1;
                l2.rr[k2] = k1;
            }
        } else
        {
            l2.gr = i1;
            l2.or = 0;
            l2.pr = 0;
            l2.qr[0] = l2.ir = j1;
            l2.rr[0] = l2.jr = k1;
            l2.kr = i2;
            l2.nr = l2.mr = l1;
            l2.lr = 0;
        }
        kw[hw++] = l2;
        return l2;
    }

    public void q(int i1, int j1, byte abyte0[])
    {
        try
        {
            if(i1 == 255)
            {
                wv = vv;
                for(int k1 = 0; k1 < wv; k1++)
                    aw[k1] = zv[k1];

                int l6 = 8;
                cw = o.un(abyte0, l6, 10);
                l6 += 10;
                dw = o.un(abyte0, l6, 12);
                l6 += 12;
                int k11 = o.un(abyte0, l6, 4);
                l6 += 4;
                boolean flag = xm(cw, dw);
                cw -= bv;
                dw -= cv;
                int j19 = cw * fu + 64;
                int k22 = dw * fu + 64;
                if(flag)
                {
                    bw.pr = 0;
                    bw.or = 0;
                    bw.ir = bw.qr[0] = j19;
                    bw.jr = bw.rr[0] = k22;
                }
                vv = 0;
                bw = zk(ew, j19, k22, k11);
                int j26 = o.un(abyte0, l6, 8);
                l6 += 8;
                for(int i31 = 0; i31 < j26; i31++)
                {
                    l l34 = aw[i31 + 1];
                    int i37 = o.un(abyte0, l6, 1);
                    l6++;
                    if(i37 != 0)
                    {
                        int i39 = o.un(abyte0, l6, 1);
                        l6++;
                        if(i39 == 0)
                        {
                            int k40 = o.un(abyte0, l6, 3);
                            l6 += 3;
                            int k41 = l34.pr;
                            int i42 = l34.qr[k41];
                            int j42 = l34.rr[k41];
                            if(k40 == 2 || k40 == 1 || k40 == 3)
                                i42 += fu;
                            if(k40 == 6 || k40 == 5 || k40 == 7)
                                i42 -= fu;
                            if(k40 == 4 || k40 == 3 || k40 == 5)
                                j42 += fu;
                            if(k40 == 0 || k40 == 1 || k40 == 7)
                                j42 -= fu;
                            l34.nr = k40;
                            l34.pr = k41 = (k41 + 1) % 10;
                            l34.qr[k41] = i42;
                            l34.rr[k41] = j42;
                        } else
                        {
                            int l40 = o.un(abyte0, l6, 4);
                            if((l40 & 0xc) == 12)
                            {
                                l6 += 2;
                                continue;
                            }
                            l34.nr = o.un(abyte0, l6, 4);
                            l6 += 4;
                        }
                    }
                    zv[vv++] = l34;
                }

                int j34 = 0;
                while(l6 + 24 < j1 * 8) 
                {
                    int j37 = o.un(abyte0, l6, 11);
                    l6 += 11;
                    int j39 = o.un(abyte0, l6, 5);
                    l6 += 5;
                    if(j39 > 15)
                        j39 -= 32;
                    int i41 = o.un(abyte0, l6, 5);
                    l6 += 5;
                    if(i41 > 15)
                        i41 -= 32;
                    int l11 = o.un(abyte0, l6, 4);
                    l6 += 4;
                    int l41 = o.un(abyte0, l6, 1);
                    l6++;
                    int k19 = (cw + j39) * fu + 64;
                    int i23 = (dw + i41) * fu + 64;
                    zk(j37, k19, i23, l11);
                    if(l41 == 0)
                        mw[j34++] = j37;
                }
                if(j34 > 0)
                {
                    super.yc.kb(254);
                    super.yc.cc(j34);
                    for(int k37 = 0; k37 < j34; k37++)
                    {
                        l l39 = yv[mw[k37]];
                        super.yc.cc(l39.gr);
                        super.yc.cc(l39.hr);
                    }

                    super.yc.ib();
                    j34 = 0;
                    return;
                }
            } else
            {
                if(i1 == 254)
                {
                    for(int l1 = 1; l1 < j1;)
                        if(o.wn(abyte0[l1]) == 255)
                        {
                            int i7 = 0;
                            int i12 = cw + abyte0[l1 + 1] >> 3;
                            int i16 = dw + abyte0[l1 + 2] >> 3;
                            l1 += 3;
                            for(int l19 = 0; l19 < ow; l19++)
                            {
                                int j23 = (qw[l19] >> 3) - i12;
                                int k26 = (rw[l19] >> 3) - i16;
                                if(j23 != 0 || k26 != 0)
                                {
                                    if(l19 != i7)
                                    {
                                        qw[i7] = qw[l19];
                                        rw[i7] = rw[l19];
                                        sw[i7] = sw[l19];
                                        tw[i7] = tw[l19];
                                    }
                                    i7++;
                                }
                            }

                            ow = i7;
                        } else
                        {
                            int j7 = o.zn(abyte0, l1);
                            l1 += 2;
                            int j12 = cw + abyte0[l1++];
                            int j16 = dw + abyte0[l1++];
                            if((j7 & 0x8000) == 0)
                            {
                                qw[ow] = j12;
                                rw[ow] = j16;
                                sw[ow] = j7;
                                tw[ow] = 0;
                                for(int i20 = 0; i20 < vw; i20++)
                                {
                                    if(xw[i20] != j12 || yw[i20] != j16)
                                        continue;
                                    tw[ow] = r.pkb[zw[i20]];
                                    break;
                                }

                                ow++;
                            } else
                            {
                                j7 &= 0x7fff;
                                int j20 = 0;
                                for(int k23 = 0; k23 < ow; k23++)
                                    if(qw[k23] != j12 || rw[k23] != j16 || sw[k23] != j7)
                                    {
                                        if(k23 != j20)
                                        {
                                            qw[j20] = qw[k23];
                                            rw[j20] = rw[k23];
                                            sw[j20] = sw[k23];
                                            tw[j20] = tw[k23];
                                        }
                                        j20++;
                                    } else
                                    {
                                        j7 = -123;
                                    }

                                ow = j20;
                            }
                        }

                    return;
                }
                if(i1 == 253)
                {
                    for(int i2 = 1; i2 < j1;)
                        if(o.wn(abyte0[i2]) == 255)
                        {
                            int k7 = 0;
                            int k12 = cw + abyte0[i2 + 1] >> 3;
                            int k16 = dw + abyte0[i2 + 2] >> 3;
                            i2 += 3;
                            for(int k20 = 0; k20 < vw; k20++)
                            {
                                int i24 = (xw[k20] >> 3) - k12;
                                int l26 = (yw[k20] >> 3) - k16;
                                if(i24 != 0 || l26 != 0)
                                {
                                    if(k20 != k7)
                                    {
                                        ww[k7] = ww[k20];
                                        ww[k7].th = k7;
                                        xw[k7] = xw[k20];
                                        yw[k7] = yw[k20];
                                        zw[k7] = zw[k20];
                                        ax[k7] = ax[k20];
                                    }
                                    k7++;
                                } else
                                {
                                    bu.fi(ww[k20]);
                                    wu.gp(xw[k20], yw[k20], zw[k20]);
                                }
                            }

                            vw = k7;
                        } else
                        {
                            int l7 = o.zn(abyte0, i2);
                            i2 += 2;
                            int l12 = cw + abyte0[i2++];
                            int l16 = dw + abyte0[i2++];
                            int l20 = 0;
                            for(int j24 = 0; j24 < vw; j24++)
                                if(xw[j24] != l12 || yw[j24] != l16)
                                {
                                    if(j24 != l20)
                                    {
                                        ww[l20] = ww[j24];
                                        ww[l20].th = l20;
                                        xw[l20] = xw[j24];
                                        yw[l20] = yw[j24];
                                        zw[l20] = zw[j24];
                                        ax[l20] = ax[j24];
                                    }
                                    l20++;
                                } else
                                {
                                    bu.fi(ww[j24]);
                                    wu.gp(xw[j24], yw[j24], zw[j24]);
                                }

                            vw = l20;
                            if(l7 != 60000)
                            {
                                int i27 = wu.jo(l12, l16);
                                int j31;
                                int k34;
                                if(i27 == 0 || i27 == 4)
                                {
                                    j31 = r.lkb[l7];
                                    k34 = r.mkb[l7];
                                } else
                                {
                                    k34 = r.lkb[l7];
                                    j31 = r.mkb[l7];
                                }
                                int l37 = ((l12 + l12 + j31) * fu) / 2;
                                int k39 = ((l16 + l16 + k34) * fu) / 2;
                                int j41 = r.kkb[l7];
                                h h2 = bx[j41].xe();
                                bu.bi(h2);
                                h2.th = vw;
                                h2.cf(0, i27 * 32, 0);
                                h2.ge(l37, -wu.po(l37, k39), k39);
                                h2.ze(true, 48, 48, -50, -10, -50);
                                wu.wo(l12, l16, l7);
                                if(l7 == 74)
                                    h2.ge(0, -480, 0);
                                xw[vw] = l12;
                                yw[vw] = l16;
                                zw[vw] = l7;
                                ax[vw] = i27;
                                ww[vw++] = h2;
                            }
                        }

                    return;
                }
                if(i1 == 252)
                {
                    int j2 = 1;
                    nx = abyte0[j2++] & 0xff;
                    for(int i8 = 0; i8 < nx; i8++)
                    {
                        int i13 = o.zn(abyte0, j2);
                        j2 += 2;
                        ox[i8] = i13 & 0x7fff;
                        qx[i8] = i13 / 32768;
                        if(r.gib[i13 & 0x7fff] == 0)
                        {
                            px[i8] = o.yn(abyte0, j2);
                            j2 += 4;
                        } else
                        {
                            px[i8] = 1;
                        }
                    }

                    return;
                }
                if(i1 == 250)
                {
                    int k2 = o.zn(abyte0, 1);
                    int j8 = 3;
                    for(int j13 = 0; j13 < k2; j13++)
                    {
                        int i17 = o.zn(abyte0, j8);
                        j8 += 2;
                        l l21 = yv[i17];
                        byte byte4 = abyte0[j8];
                        j8++;
                        if(byte4 == 0)
                        {
                            int j27 = o.zn(abyte0, j8);
                            j8 += 2;
                            if(l21 != null)
                            {
                                l21.wr = 150;
                                l21.vr = j27;
                            }
                        } else
                        if(byte4 == 1)
                        {
                            byte byte5 = abyte0[j8];
                            j8++;
                            if(l21 != null)
                            {
                                String s2 = o.qn(abyte0, j8, byte5, true);
                                boolean flag3 = false;
                                for(int i38 = 0; i38 < super.fd; i38++)
                                    if(super.gd[i38] == l21.er)
                                        flag3 = true;

                                if(!flag3)
                                {
                                    l21.ur = 150;
                                    l21.tr = s2;
                                    tk(l21.fr + ": " + l21.tr, 2);
                                }
                            }
                            j8 += byte5;
                        } else
                        if(byte4 == 2)
                        {
                            int k27 = o.wn(abyte0[j8]);
                            j8++;
                            int k31 = o.wn(abyte0[j8]);
                            j8++;
                            int i35 = o.wn(abyte0[j8]);
                            j8++;
                            if(l21 != null)
                            {
                                l21.xr = k27;
                                l21.yr = k31;
                                l21.zr = i35;
                                l21.as = 200;
                                if(l21 == bw)
                                {
                                    ux[3] = k31;
                                    vx[3] = i35;
                                }
                            }
                        } else
                        if(byte4 == 3)
                        {
                            int l27 = o.zn(abyte0, j8);
                            j8 += 2;
                            int l31 = o.zn(abyte0, j8);
                            j8 += 2;
                            if(l21 != null)
                            {
                                l21.gs = l27;
                                l21.is = l31;
                                l21.hs = -1;
                                l21.js = mu;
                            }
                        } else
                        if(byte4 == 4)
                        {
                            int i28 = o.zn(abyte0, j8);
                            j8 += 2;
                            int i32 = o.zn(abyte0, j8);
                            j8 += 2;
                            if(l21 != null)
                            {
                                l21.gs = i28;
                                l21.hs = i32;
                                l21.is = -1;
                                l21.js = mu;
                            }
                        } else
                        if(byte4 == 5)
                        {
                            if(l21 != null)
                            {
                                l21.hr = o.zn(abyte0, j8);
                                j8 += 2;
                                l21.er = o.rn(abyte0, j8);
                                j8 += 8;
                                l21.fr = o.xn(l21.er);
                                int j28 = o.wn(abyte0[j8]);
                                j8++;
                                for(int j32 = 0; j32 < j28; j32++)
                                {
                                    l21.sr[j32] = o.wn(abyte0[j8]);
                                    j8++;
                                }

                                for(int j35 = j28; j35 < 12; j35++)
                                    l21.sr[j35] = 0;

                                l21.cs = abyte0[j8++] & 0xff;
                                l21.ds = abyte0[j8++] & 0xff;
                                l21.es = abyte0[j8++] & 0xff;
                                l21.fs = abyte0[j8++] & 0xff;
                                l21.bs = abyte0[j8++] & 0xff;
                                l21.ms = abyte0[j8++] & 0xff;
                            } else
                            {
                                j8 += 14;
                                int k28 = o.wn(abyte0[j8]);
                                j8 += k28 + 1;
                            }
                        } else
                        if(byte4 == 6)
                        {
                            byte byte6 = abyte0[j8];
                            j8++;
                            if(l21 != null)
                            {
                                String s3 = o.qn(abyte0, j8, byte6, false);
                                l21.ur = 150;
                                l21.tr = s3;
                                if(l21 == bw)
                                    tk(l21.fr + ": " + l21.tr, 5);
                            }
                            j8 += byte6;
                        }
                    }

                    return;
                }
                if(i1 == 249)
                {
                    for(int l2 = 1; l2 < j1;)
                        if(o.wn(abyte0[l2]) == 255)
                        {
                            int k8 = 0;
                            int k13 = cw + abyte0[l2 + 1] >> 3;
                            int j17 = dw + abyte0[l2 + 2] >> 3;
                            l2 += 3;
                            for(int i21 = 0; i21 < ex; i21++)
                            {
                                int k24 = (gx[i21] >> 3) - k13;
                                int l28 = (hx[i21] >> 3) - j17;
                                if(k24 != 0 || l28 != 0)
                                {
                                    if(i21 != k8)
                                    {
                                        fx[k8] = fx[i21];
                                        fx[k8].th = k8 + 10000;
                                        gx[k8] = gx[i21];
                                        hx[k8] = hx[i21];
                                        ix[k8] = ix[i21];
                                        jx[k8] = jx[i21];
                                    }
                                    k8++;
                                } else
                                {
                                    bu.fi(fx[i21]);
                                    wu.go(gx[i21], hx[i21], ix[i21], jx[i21]);
                                }
                            }

                            ex = k8;
                        } else
                        {
                            int l8 = o.zn(abyte0, l2);
                            l2 += 2;
                            int l13 = cw + abyte0[l2++];
                            int k17 = dw + abyte0[l2++];
                            byte byte3 = abyte0[l2++];
                            int l24 = 0;
                            for(int i29 = 0; i29 < ex; i29++)
                                if(gx[i29] != l13 || hx[i29] != k17 || ix[i29] != byte3)
                                {
                                    if(i29 != l24)
                                    {
                                        fx[l24] = fx[i29];
                                        fx[l24].th = l24 + 10000;
                                        gx[l24] = gx[i29];
                                        hx[l24] = hx[i29];
                                        ix[l24] = ix[i29];
                                        jx[l24] = jx[i29];
                                    }
                                    l24++;
                                } else
                                {
                                    bu.fi(fx[i29]);
                                    wu.go(gx[i29], hx[i29], ix[i29], jx[i29]);
                                }

                            ex = l24;
                            if(l8 != 65535)
                            {
                                wu.ip(l13, k17, byte3, l8);
                                h h1 = km(l13, k17, byte3, l8, ex);
                                fx[ex] = h1;
                                gx[ex] = l13;
                                hx[ex] = k17;
                                jx[ex] = l8;
                                ix[ex++] = byte3;
                            }
                        }

                    return;
                }
                if(i1 == 248)
                {
                    iw = hw;
                    hw = 0;
                    for(int i3 = 0; i3 < iw; i3++)
                        lw[i3] = kw[i3];

                    int i9 = 8;
                    int i14 = o.un(abyte0, i9, 8);
                    i9 += 8;
                    for(int l17 = 0; l17 < i14; l17++)
                    {
                        l l22 = lw[l17];
                        int i25 = o.un(abyte0, i9, 1);
                        i9++;
                        if(i25 != 0)
                        {
                            int j29 = o.un(abyte0, i9, 1);
                            i9++;
                            if(j29 == 0)
                            {
                                int k32 = o.un(abyte0, i9, 3);
                                i9 += 3;
                                int k35 = l22.pr;
                                int j38 = l22.qr[k35];
                                int i40 = l22.rr[k35];
                                if(k32 == 2 || k32 == 1 || k32 == 3)
                                    j38 += fu;
                                if(k32 == 6 || k32 == 5 || k32 == 7)
                                    j38 -= fu;
                                if(k32 == 4 || k32 == 3 || k32 == 5)
                                    i40 += fu;
                                if(k32 == 0 || k32 == 1 || k32 == 7)
                                    i40 -= fu;
                                l22.nr = k32;
                                l22.pr = k35 = (k35 + 1) % 10;
                                l22.qr[k35] = j38;
                                l22.rr[k35] = i40;
                            } else
                            {
                                int l32 = o.un(abyte0, i9, 4);
                                if((l32 & 0xc) == 12)
                                {
                                    i9 += 2;
                                    continue;
                                }
                                l22.nr = o.un(abyte0, i9, 4);
                                i9 += 4;
                            }
                        }
                        kw[hw++] = l22;
                    }

                    while(i9 + 31 < j1 * 8) 
                    {
                        int j21 = o.un(abyte0, i9, 11);
                        i9 += 11;
                        int j25 = o.un(abyte0, i9, 5);
                        i9 += 5;
                        if(j25 > 15)
                            j25 -= 32;
                        int k29 = o.un(abyte0, i9, 5);
                        i9 += 5;
                        if(k29 > 15)
                            k29 -= 32;
                        int i33 = o.un(abyte0, i9, 4);
                        i9 += 4;
                        int l35 = (cw + j25) * fu + 64;
                        int k38 = (dw + k29) * fu + 64;
                        int j40 = o.un(abyte0, i9, 8);
                        i9 += 8;
                        if(j40 >= r.tib)
                            j40 = 24;
                        tm(j21, l35, k38, i33, j40);
                    }
                    return;
                }
                if(i1 == 247)
                {
                    int j3 = o.zn(abyte0, 1);
                    int j9 = 3;
                    for(int j14 = 0; j14 < j3; j14++)
                    {
                        int i18 = o.zn(abyte0, j9);
                        j9 += 2;
                        l l23 = jw[i18];
                        int k25 = o.wn(abyte0[j9]);
                        j9++;
                        if(k25 == 1)
                        {
                            int l29 = o.zn(abyte0, j9);
                            j9 += 2;
                            byte byte7 = abyte0[j9];
                            j9++;
                            if(l23 != null)
                            {
                                String s4 = o.qn(abyte0, j9, byte7, false);
                                l23.ur = 150;
                                l23.tr = s4;
                                if(l29 == bw.gr)
                                    tk("@yel@" + r.uib[l23.kr][0] + ": " + l23.tr, 5);
                            }
                            j9 += byte7;
                        } else
                        if(k25 == 2)
                        {
                            int i30 = o.wn(abyte0[j9]);
                            j9++;
                            int j33 = o.wn(abyte0[j9]);
                            j9++;
                            int i36 = o.wn(abyte0[j9]);
                            j9++;
                            if(l23 != null)
                            {
                                l23.xr = i30;
                                l23.yr = j33;
                                l23.zr = i36;
                                l23.as = 200;
                            }
                        }
                    }

                    return;
                }
                if(i1 == 246)
                {
                    gbb = true;
                    int k3 = o.wn(abyte0[1]);
                    hbb = k3;
                    int k9 = 2;
                    for(int k14 = 0; k14 < k3; k14++)
                    {
                        int j18 = o.wn(abyte0[k9]);
                        k9++;
                        ibb[k14] = new String(abyte0, k9, j18);
                        k9 += j18;
                    }

                    return;
                }
                if(i1 == 245)
                {
                    gbb = false;
                    return;
                }
                if(i1 == 244)
                {
                    sbb = true;
                    ew = o.zn(abyte0, 1);
                    xu = o.zn(abyte0, 3);
                    yu = o.zn(abyte0, 5);
                    dv = o.zn(abyte0, 7);
                    zu = o.zn(abyte0, 9);
                    yu -= dv * zu;
                    return;
                }
                if(i1 == 243)
                {
                    int l3 = 1;
                    for(int l9 = 0; l9 < 16; l9++)
                        ux[l9] = o.wn(abyte0[l3++]);

                    for(int l14 = 0; l14 < 16; l14++)
                        vx[l14] = o.wn(abyte0[l3++]);

                    for(int k18 = 0; k18 < 16; k18++)
                    {
                        wx[k18] = o.yn(abyte0, l3);
                        l3 += 4;
                    }

                    yx = o.wn(abyte0[l3++]);
                    return;
                }
                if(i1 == 242)
                {
                    for(int i4 = 0; i4 < 5; i4++)
                        xx[i4] = o.wn(abyte0[1 + i4]);

                    return;
                }
                if(i1 == 241)
                {
                    qbb = 250;
                    return;
                }
                if(i1 == 240)
                {
                    int j4 = (j1 - 1) / 4;
                    for(int i10 = 0; i10 < j4; i10++)
                    {
                        int i15 = cw + o.bo(abyte0, 1 + i10 * 4) >> 3;
                        int l18 = dw + o.bo(abyte0, 3 + i10 * 4) >> 3;
                        int k21 = 0;
                        for(int l25 = 0; l25 < ow; l25++)
                        {
                            int j30 = (qw[l25] >> 3) - i15;
                            int k33 = (rw[l25] >> 3) - l18;
                            if(j30 != 0 || k33 != 0)
                            {
                                if(l25 != k21)
                                {
                                    qw[k21] = qw[l25];
                                    rw[k21] = rw[l25];
                                    sw[k21] = sw[l25];
                                    tw[k21] = tw[l25];
                                }
                                k21++;
                            }
                        }

                        ow = k21;
                        k21 = 0;
                        for(int k30 = 0; k30 < vw; k30++)
                        {
                            int l33 = (xw[k30] >> 3) - i15;
                            int j36 = (yw[k30] >> 3) - l18;
                            if(l33 != 0 || j36 != 0)
                            {
                                if(k30 != k21)
                                {
                                    ww[k21] = ww[k30];
                                    ww[k21].th = k21;
                                    xw[k21] = xw[k30];
                                    yw[k21] = yw[k30];
                                    zw[k21] = zw[k30];
                                    ax[k21] = ax[k30];
                                }
                                k21++;
                            } else
                            {
                                bu.fi(ww[k30]);
                                wu.gp(xw[k30], yw[k30], zw[k30]);
                            }
                        }

                        vw = k21;
                        k21 = 0;
                        for(int i34 = 0; i34 < ex; i34++)
                        {
                            int k36 = (gx[i34] >> 3) - i15;
                            int l38 = (hx[i34] >> 3) - l18;
                            if(k36 != 0 || l38 != 0)
                            {
                                if(i34 != k21)
                                {
                                    fx[k21] = fx[i34];
                                    fx[k21].th = k21 + 10000;
                                    gx[k21] = gx[i34];
                                    hx[k21] = hx[i34];
                                    ix[k21] = ix[i34];
                                    jx[k21] = jx[i34];
                                }
                                k21++;
                            } else
                            {
                                bu.fi(fx[i34]);
                                wu.go(gx[i34], hx[i34], ix[i34], jx[i34]);
                            }
                        }

                        ex = k21;
                    }

                    return;
                }
                if(i1 == 239)
                {
                    afb = true;
                    return;
                }
                if(i1 == 238)
                {
                    int k4 = o.zn(abyte0, 1);
                    if(yv[k4] != null)
                        yz = yv[k4].fr;
                    xz = true;
                    fab = false;
                    gab = false;
                    zz = 0;
                    cab = 0;
                    return;
                }
                if(i1 == 237)
                {
                    xz = false;
                    kab = false;
                    return;
                }
                if(i1 == 236)
                {
                    cab = abyte0[1] & 0xff;
                    int l4 = 2;
                    for(int j10 = 0; j10 < cab; j10++)
                    {
                        dab[j10] = o.zn(abyte0, l4);
                        l4 += 2;
                        eab[j10] = o.yn(abyte0, l4);
                        l4 += 4;
                    }

                    fab = false;
                    gab = false;
                    return;
                }
                if(i1 == 235)
                {
                    byte byte0 = abyte0[1];
                    if(byte0 == 1)
                    {
                        fab = true;
                        return;
                    } else
                    {
                        fab = false;
                        return;
                    }
                }
                if(i1 == 234)
                {
                    sab = true;
                    int i5 = 1;
                    int k10 = abyte0[i5++] & 0xff;
                    byte byte2 = abyte0[i5++];
                    tab = abyte0[i5++] & 0xff;
                    uab = abyte0[i5++] & 0xff;
                    for(int i19 = 0; i19 < 40; i19++)
                        vab[i19] = -1;

                    for(int i22 = 0; i22 < k10; i22++)
                    {
                        vab[i22] = o.zn(abyte0, i5);
                        i5 += 2;
                        wab[i22] = o.zn(abyte0, i5);
                        i5 += 2;
                        xab[i22] = abyte0[i5++];
                    }

                    if(byte2 == 1)
                    {
                        int i26 = 39;
                        for(int l30 = 0; l30 < nx; l30++)
                        {
                            if(i26 < k10)
                                break;
                            boolean flag2 = false;
                            for(int l36 = 0; l36 < 40; l36++)
                            {
                                if(vab[l36] != ox[l30])
                                    continue;
                                flag2 = true;
                                break;
                            }

                            if(ox[l30] == 10)
                                flag2 = true;
                            if(!flag2)
                            {
                                vab[i26] = ox[l30] & 0x7fff;
                                wab[i26] = 0;
                                xab[i26] = 0;
                                i26--;
                            }
                        }

                    }
                    if(yab >= 0 && yab < 40 && vab[yab] != zab)
                    {
                        yab = -1;
                        zab = -2;
                        return;
                    }
                } else
                {
                    if(i1 == 233)
                    {
                        sab = false;
                        return;
                    }
                    if(i1 == 229)
                    {
                        byte byte1 = abyte0[1];
                        if(byte1 == 1)
                        {
                            gab = true;
                            return;
                        } else
                        {
                            gab = false;
                            return;
                        }
                    }
                    if(i1 == 228)
                    {
                        System.out.println("Got config");
                        ry = o.wn(abyte0[1]) == 1;
                        zy = o.wn(abyte0[2]) == 1;
                        return;
                    }
                    if(i1 == 227)
                    {
                        for(int j5 = 0; j5 < j1 - 1; j5++)
                            py[j5] = abyte0[j5 + 1] == 1;

                        return;
                    }
                    if(i1 == 226)
                    {
                        for(int k5 = 0; k5 < my; k5++)
                            oy[k5] = abyte0[k5 + 1] == 1;

                        return;
                    }
                    if(i1 == 224)
                    {
                        jdb = true;
                        for(int l5 = 0; l5 < 5; l5++)
                        {
                            sdb[l5] = l5;
                            tdb[l5] = "~:" + sdb[l5];
                            kdb.rd(pdb[l5], "");
                            kdb.rd(odb[l5], (l5 + 1) + ": " + pfb[sdb[l5]]);
                        }

                        return;
                    }
                    if(i1 == 222)
                    {
                        abb = true;
                        bbb = 0;
                        for(int i6 = 8; i6 + 9 < j1 * 8;)
                        {
                            cbb[bbb] = o.un(abyte0, i6, 10);
                            i6 += 10;
                            int l10 = o.un(abyte0, i6, 1);
                            i6++;
                            if(l10 == 0)
                            {
                                dbb[bbb] = o.un(abyte0, i6, 8);
                                i6 += 8;
                            } else
                            {
                                dbb[bbb] = o.un(abyte0, i6, 32);
                                i6 += 32;
                            }
                            bbb++;
                        }

                        for(int i11 = 0; i11 < nx; i11++)
                        {
                            if(bbb >= 48)
                                break;
                            int j15 = ox[i11];
                            boolean flag1 = false;
                            for(int j22 = 0; j22 < bbb; j22++)
                            {
                                if(cbb[j22] != j15)
                                    continue;
                                flag1 = true;
                                break;
                            }

                            if(!flag1)
                            {
                                cbb[bbb] = j15;
                                dbb[bbb] = 0;
                                bbb++;
                            }
                        }

                        return;
                    }
                    if(i1 == 221)
                    {
                        abb = false;
                        return;
                    }
                    if(i1 == 220)
                    {
                        int j6 = abyte0[1] & 0xff;
                        wx[j6] = o.yn(abyte0, 2);
                        return;
                    }
                    if(i1 == 219)
                    {
                        wz = true;
                        return;
                    }
                    if(i1 == 218)
                    {
                        wz = false;
                        return;
                    }
                    if(i1 == 217)
                    {
                        kab = true;
                        lab = false;
                        xz = false;
                        int k6 = 1;
                        jab = o.rn(abyte0, k6);
                        k6 += 8;
                        pab = abyte0[k6++] & 0xff;
                        for(int j11 = 0; j11 < pab; j11++)
                        {
                            qab[j11] = o.zn(abyte0, k6);
                            k6 += 2;
                            rab[j11] = o.yn(abyte0, k6);
                            k6 += 4;
                        }

                        mab = abyte0[k6++] & 0xff;
                        for(int k15 = 0; k15 < mab; k15++)
                        {
                            nab[k15] = o.zn(abyte0, k6);
                            k6 += 2;
                            oab[k15] = o.yn(abyte0, k6);
                            k6 += 4;
                        }

                    }
                }
            }
            return;
        }
        catch(RuntimeException runtimeexception)
        {
            if(it < 3)
            {
                super.yc.kb(17);
                super.yc.sb(runtimeexception.toString());
                wk();
                super.yc.kb(17);
                super.yc.sb("p-type:" + i1 + " p-size:" + j1);
                wk();
                super.yc.kb(17);
                super.yc.sb("rx:" + cw + " ry:" + dw + " num3l:" + vw);
                wk();
                String s1 = "";
                for(int l15 = 0; l15 < 80 && l15 < j1; l15++)
                    s1 = s1 + abyte0[l15] + " ";

                super.yc.kb(17);
                super.yc.sb(s1);
                wk();
                it++;
            }
        }
    }

    public boolean lm(int i1)
    {
        int j1 = bw.ir / 128;
        int k1 = bw.jr / 128;
        for(int l1 = 2; l1 >= 1; l1--)
        {
            if(i1 == 1 && ((wu.zgb[j1][k1 - l1] & 0x80) == 128 || (wu.zgb[j1 - l1][k1] & 0x80) == 128 || (wu.zgb[j1 - l1][k1 - l1] & 0x80) == 128))
                return false;
            if(i1 == 3 && ((wu.zgb[j1][k1 + l1] & 0x80) == 128 || (wu.zgb[j1 - l1][k1] & 0x80) == 128 || (wu.zgb[j1 - l1][k1 + l1] & 0x80) == 128))
                return false;
            if(i1 == 5 && ((wu.zgb[j1][k1 + l1] & 0x80) == 128 || (wu.zgb[j1 + l1][k1] & 0x80) == 128 || (wu.zgb[j1 + l1][k1 + l1] & 0x80) == 128))
                return false;
            if(i1 == 7 && ((wu.zgb[j1][k1 - l1] & 0x80) == 128 || (wu.zgb[j1 + l1][k1] & 0x80) == 128 || (wu.zgb[j1 + l1][k1 - l1] & 0x80) == 128))
                return false;
            if(i1 == 0 && (wu.zgb[j1][k1 - l1] & 0x80) == 128)
                return false;
            if(i1 == 2 && (wu.zgb[j1 - l1][k1] & 0x80) == 128)
                return false;
            if(i1 == 4 && (wu.zgb[j1][k1 + l1] & 0x80) == 128)
                return false;
            if(i1 == 6 && (wu.zgb[j1 + l1][k1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public void ul()
    {
        if((pv & 1) == 1 && lm(pv))
            return;
        if((pv & 1) == 0 && lm(pv))
        {
            if(lm(pv + 1 & 7))
            {
                pv = pv + 1 & 7;
                return;
            }
            if(lm(pv + 7 & 7))
                pv = pv + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i1 = 0; i1 < 7; i1++)
        {
            if(!lm(pv + ai[i1] + 8 & 7))
                continue;
            pv = pv + ai[i1] + 8 & 7;
            break;
        }

        if((pv & 1) == 0 && lm(pv))
        {
            if(lm(pv + 1 & 7))
            {
                pv = pv + 1 & 7;
                return;
            }
            if(lm(pv + 7 & 7))
                pv = pv + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public void hl()
    {
        if(qbb != 0)
        {
            cu.mf();
            cu.ah("Oh dear! You are dead...", hu / 2, iu / 2, 7, 0xff0000);
            jl();
            cu.qf(au, 0, 11);
            return;
        }
        if(afb)
        {
            uk();
            return;
        }
        if(jdb)
        {
            qk();
            return;
        }
        if(!wu.bhb)
            return;
        for(int i1 = 0; i1 < 64; i1++)
        {
            bu.fi(wu.ehb[av][i1]);
            if(av == 0)
            {
                bu.fi(wu.dhb[1][i1]);
                bu.fi(wu.ehb[1][i1]);
                bu.fi(wu.dhb[2][i1]);
                bu.fi(wu.ehb[2][i1]);
            }
            mv = true;
            if(av == 0 && (wu.zgb[bw.ir / 128][bw.jr / 128] & 0x80) == 0)
            {
                bu.bi(wu.ehb[av][i1]);
                if(av == 0)
                {
                    bu.bi(wu.dhb[1][i1]);
                    bu.bi(wu.ehb[1][i1]);
                    bu.bi(wu.dhb[2][i1]);
                    bu.bi(wu.ehb[2][i1]);
                }
                mv = false;
            }
        }

        if(pu != ru)
        {
            ru = pu;
            for(int j1 = 0; j1 < vw; j1++)
            {
                if(zw[j1] == 51)
                {
                    int i2 = xw[j1];
                    int j3 = yw[j1];
                    int k4 = i2 - bw.ir / 128;
                    int j6 = j3 - bw.jr / 128;
                    byte byte0 = 7;
                    if(i2 >= 0 && j3 >= 0 && i2 < 96 && j3 < 96 && k4 > -byte0 && k4 < byte0 && j6 > -byte0 && j6 < byte0)
                    {
                        bu.fi(ww[j1]);
                        String s2 = "torcha" + (pu + 1);
                        int j12 = r.vp(s2);
                        h h1 = bx[j12].xe();
                        bu.bi(h1);
                        h1.ze(true, 48, 48, -50, -10, -50);
                        h1.fe(ww[j1]);
                        h1.th = j1;
                        ww[j1] = h1;
                    }
                }
                if(zw[j1] == 143)
                {
                    int j2 = xw[j1];
                    int k3 = yw[j1];
                    int i5 = j2 - bw.ir / 128;
                    int k6 = k3 - bw.jr / 128;
                    byte byte1 = 7;
                    if(j2 >= 0 && k3 >= 0 && j2 < 96 && k3 < 96 && i5 > -byte1 && i5 < byte1 && k6 > -byte1 && k6 < byte1)
                    {
                        bu.fi(ww[j1]);
                        String s3 = "skulltorcha" + (pu + 1);
                        int k12 = r.vp(s3);
                        h h2 = bx[k12].xe();
                        bu.bi(h2);
                        h2.ze(true, 48, 48, -50, -10, -50);
                        h2.fe(ww[j1]);
                        h2.th = j1;
                        ww[j1] = h2;
                    }
                }
            }

        }
        if(qu != su)
        {
            su = qu;
            for(int k1 = 0; k1 < vw; k1++)
                if(zw[k1] == 97)
                {
                    int k2 = xw[k1];
                    int l3 = yw[k1];
                    int j5 = k2 - bw.ir / 128;
                    int i7 = l3 - bw.jr / 128;
                    byte byte2 = 9;
                    if(k2 >= 0 && l3 >= 0 && k2 < 96 && l3 < 96 && j5 > -byte2 && j5 < byte2 && i7 > -byte2 && i7 < byte2)
                    {
                        bu.fi(ww[k1]);
                        String s4 = "firea" + (qu + 1);
                        int l12 = r.vp(s4);
                        h h3 = bx[l12].xe();
                        bu.bi(h3);
                        h3.ze(true, 48, 48, -50, -10, -50);
                        h3.fe(ww[k1]);
                        h3.th = k1;
                        ww[k1] = h3;
                    }
                }

        }
        bu.qi(xv);
        xv = 0;
        for(int l1 = 0; l1 < vv; l1++)
        {
            l l2 = zv[l1];
            if(l2.es != 255)
            {
                int i4 = l2.ir;
                int k5 = l2.jr;
                int j7 = -wu.po(i4, k5);
                int l9 = bu.sh(5000 + l1, i4, j7, k5, 145, 220, l1 + 10000);
                xv++;
                if(l2 == bw)
                    bu.th(l9);
                if(l2.mr == 8)
                    bu.ui(l9, -30);
                if(l2.mr == 9)
                    bu.ui(l9, 30);
            }
        }

        for(int i3 = 0; i3 < vv; i3++)
        {
            l l4 = zv[i3];
            if(l4.js > 0)
            {
                l l5 = null;
                if(l4.is != -1)
                    l5 = jw[l4.is];
                else
                if(l4.hs != -1)
                    l5 = yv[l4.hs];
                if(l5 != null)
                {
                    int k7 = l4.ir;
                    int i10 = l4.jr;
                    int l11 = -wu.po(k7, i10) - 110;
                    int i13 = l5.ir;
                    int k13 = l5.jr;
                    int l13 = -wu.po(i13, k13) - r.rjb[l5.kr] / 2;
                    int i14 = (k7 * l4.js + i13 * (mu - l4.js)) / mu;
                    int j14 = (l11 * l4.js + l13 * (mu - l4.js)) / mu;
                    int k14 = (i10 * l4.js + k13 * (mu - l4.js)) / mu;
                    bu.sh(nu + l4.gs, i14, j14, k14, 32, 32, 0);
                    xv++;
                }
            }
        }

        for(int j4 = 0; j4 < hw; j4++)
        {
            l l6 = kw[j4];
            int l7 = l6.ir;
            int j10 = l6.jr;
            int i12 = -wu.po(l7, j10);
            int j13 = bu.sh(20000 + j4, l7, i12, j10, r.qjb[l6.kr], r.rjb[l6.kr], j4 + 30000);
            xv++;
            if(l6.mr == 8)
                bu.ui(j13, -30);
            if(l6.mr == 9)
                bu.ui(j13, 30);
        }

        for(int i6 = 0; i6 < ow; i6++)
        {
            int i8 = qw[i6] * fu + 64;
            int k10 = rw[i6] * fu + 64;
            bu.sh(40000 + sw[i6], i8, -wu.po(i8, k10) - tw[i6], k10, 96, 64, i6 + 20000);
            xv++;
        }

        cu.wk = false;
        cu.sf();
        cu.wk = super.yq;
        if(av == 3)
        {
            int j8 = 40 + (int)(Math.random() * 3D);
            int l10 = 40 + (int)(Math.random() * 7D);
            bu.fj(j8, l10, -50, -10, -50);
        }
        oeb = 0;
        ieb = 0;
        teb = 0;
        if(qy)
        {
            if(ry && !mv)
            {
                int k8 = pv;
                ul();
                if(pv != k8)
                {
                    nv = bw.ir;
                    ov = bw.jr;
                }
            }
            bu.jm = 3000;
            bu.km = 3000;
            bu.lm = 1;
            bu.mm = 2800;
            rv = pv * 32;
            int l8 = nv + vt;
            int i11 = ov + xt;
            bu.gi(l8, -wu.po(l8, i11), i11, 912, rv * 4, 0, 2000);
        } else
        {
            if(ry && !mv)
                ul();
            if(!super.yq)
            {
                bu.jm = 2400;
                bu.km = 2400;
                bu.lm = 1;
                bu.mm = 2300;
            } else
            {
                bu.jm = 2200;
                bu.km = 2200;
                bu.lm = 1;
                bu.mm = 2100;
            }
            int i9 = nv + vt;
            int j11 = ov + xt;
            bu.gi(i9, -wu.po(i9, j11), j11, 912, rv * 4, 0, lv * 2);
        }
        bu.cj();
        xl();
        if(tu > 0)
            cu.eh(uu - 8, vu - 8, lu + 14 + (24 - tu) / 6);
        if(tu < 0)
            cu.eh(uu - 8, vu - 8, lu + 18 + (24 + tu) / 6);
        if(!sbb)
        {
            int j9 = 2203 - (dw + yu + cv);
            if(j9 > 0)
            {
                int k11 = 1 + j9 / 6;
                cu.eh(453, iu - 56, lu + 13);
                cu.ah("Wilderness", 465, iu - 20, 1, 0xffff00);
                cu.ah("Level: " + k11, 465, iu - 7, 1, 0xffff00);
                if(rbb == 0)
                    rbb = 2;
            }
            if(rbb == 0 && j9 > -10 && j9 <= 0)
                rbb = 1;
        }
        if(sz == 0)
        {
            for(int k9 = 0; k9 < tz; k9++)
                if(vz[k9] > 0)
                {
                    String s1 = uz[k9];
                    cu.tf(s1, 7, iu - 18 - k9 * 12, 1, 0xffff00);
                }

        }
        nz.xd(oz);
        nz.xd(qz);
        nz.xd(rz);
        if(sz == 1)
            nz.ld(oz);
        else
        if(sz == 2)
            nz.ld(qz);
        else
        if(sz == 3)
            nz.ld(rz);
        g.mg = 2;
        nz.oc();
        g.mg = 0;
        cu.wg(((i) (cu)).xj - 3 - 197, 3, lu, 128);
        rk();
        cu.al = false;
        jl();
        cu.qf(au, 0, 11);
    }

    public void jl()
    {
        cu.eh(0, iu - 4, lu + 23);
        int i1 = jagex.client.i.qg(200, 200, 255);
        if(sz == 0)
            i1 = jagex.client.i.qg(255, 200, 50);
        if(jz % 30 > 15)
            i1 = jagex.client.i.qg(255, 50, 50);
        cu.ah("All messages", 54, iu + 6, 0, i1);
        i1 = jagex.client.i.qg(200, 200, 255);
        if(sz == 1)
            i1 = jagex.client.i.qg(255, 200, 50);
        if(kz % 30 > 15)
            i1 = jagex.client.i.qg(255, 50, 50);
        cu.ah("Chat history", 155, iu + 6, 0, i1);
        i1 = jagex.client.i.qg(200, 200, 255);
        if(sz == 2)
            i1 = jagex.client.i.qg(255, 200, 50);
        if(lz % 30 > 15)
            i1 = jagex.client.i.qg(255, 50, 50);
        cu.ah("Quest history", 255, iu + 6, 0, i1);
        i1 = jagex.client.i.qg(200, 200, 255);
        if(sz == 3)
            i1 = jagex.client.i.qg(255, 200, 50);
        if(mz % 30 > 15)
            i1 = jagex.client.i.qg(255, 50, 50);
        cu.ah("Private history", 355, iu + 6, 0, i1);
    }

    public void zm(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l2 = r.eib[i2] + pw;
        int i3 = r.qib[i2];
        cu.cg(i1, j1, k1, l1, l2, i3, 0, 0, false);
    }

    public void en(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        l l2 = kw[i2];
        int i3 = l2.mr + (rv + 16) / 32 & 7;
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
        int k3 = j3 * 3 + mfb[(l2.lr / r.sjb[l2.kr]) % 4];
        if(l2.mr == 8)
        {
            j3 = 5;
            byte byte0 = 2;
            flag = false;
            i1 -= (r.ujb[l2.kr] * k2) / 100;
            k3 = j3 * 3 + nfb[(mt / (r.tjb[l2.kr] - 1)) % 8];
        } else
        if(l2.mr == 9)
        {
            j3 = 5;
            byte byte1 = 2;
            flag = true;
            i1 += (r.ujb[l2.kr] * k2) / 100;
            k3 = j3 * 3 + ofb[(mt / r.tjb[l2.kr]) % 8];
        }
        for(int l3 = 0; l3 < 12; l3++)
        {
            int i4 = zeb[j3][l3];
            int l4 = r.ljb[l2.kr][i4];
            if(l4 >= 0)
            {
                int j5 = 0;
                int k5 = 0;
                int l5 = k3;
                if(flag && j3 >= 1 && j3 <= 3 && r.dkb[l4] == 1)
                    l5 += 15;
                if(j3 != 5 || r.ckb[l4] == 1)
                {
                    int i6 = l5 + r.ekb[l4];
                    j5 = (j5 * k1) / ((i) (cu)).ok[i6];
                    k5 = (k5 * l1) / ((i) (cu)).pk[i6];
                    int j6 = (k1 * ((i) (cu)).ok[i6]) / ((i) (cu)).ok[r.ekb[l4]];
                    j5 -= (j6 - k1) / 2;
                    int k6 = r.akb[l4];
                    int l6 = 0;
                    if(k6 == 1)
                    {
                        k6 = r.mjb[l2.kr];
                        l6 = r.pjb[l2.kr];
                    } else
                    if(k6 == 2)
                    {
                        k6 = r.njb[l2.kr];
                        l6 = r.pjb[l2.kr];
                    } else
                    if(k6 == 3)
                    {
                        k6 = r.ojb[l2.kr];
                        l6 = r.pjb[l2.kr];
                    }
                    cu.cg(i1 + j5, j1 + k5, j6, l1, i6, k6, l6, j2, flag);
                }
            }
        }

        if(l2.ur > 0)
        {
            meb[ieb] = cu.kf(l2.tr, 1) / 2;
            neb[ieb] = cu.tg(1);
            if(meb[ieb] > 300)
            {
                meb[ieb] = 300;
                neb[ieb] *= 2;
            }
            keb[ieb] = i1 + k1 / 2;
            leb[ieb] = j1;
            jeb[ieb++] = l2.tr;
        }
        if(l2.mr == 8 || l2.mr == 9 || l2.as != 0)
        {
            if(l2.as > 0)
            {
                int j4 = i1;
                if(l2.mr == 8)
                    j4 -= (20 * k2) / 100;
                else
                if(l2.mr == 9)
                    j4 += (20 * k2) / 100;
                int i5 = (l2.yr * 30) / l2.zr;
                ueb[teb] = j4 + k1 / 2;
                veb[teb] = j1;
                web[teb++] = i5;
            }
            if(l2.as > 150)
            {
                int k4 = i1;
                if(l2.mr == 8)
                    k4 -= (10 * k2) / 100;
                else
                if(l2.mr == 9)
                    k4 += (10 * k2) / 100;
                cu.eh((k4 + k1 / 2) - 12, (j1 + l1 / 2) - 12, lu + 12);
                cu.ah(String.valueOf(l2.xr), (k4 + k1 / 2) - 1, j1 + l1 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public void vl(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        l l2 = zv[i2];
        if(l2.es == 255)
            return;
        int i3 = l2.mr + (rv + 16) / 32 & 7;
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
        int k3 = j3 * 3 + mfb[(l2.lr / 6) % 4];
        if(l2.mr == 8)
        {
            j3 = 5;
            i3 = 2;
            flag = false;
            i1 -= (5 * k2) / 100;
            k3 = j3 * 3 + nfb[(mt / 5) % 8];
        } else
        if(l2.mr == 9)
        {
            j3 = 5;
            i3 = 2;
            flag = true;
            i1 += (5 * k2) / 100;
            k3 = j3 * 3 + ofb[(mt / 6) % 8];
        }
        for(int l3 = 0; l3 < 12; l3++)
        {
            int i4 = zeb[i3][l3];
            int i5 = l2.sr[i4] - 1;
            if(i5 >= 0)
            {
                int l5 = 0;
                int j6 = 0;
                int k6 = k3;
                if(flag && j3 >= 1 && j3 <= 3)
                    if(r.dkb[i5] == 1)
                        k6 += 15;
                    else
                    if(i4 == 4 && j3 == 1)
                    {
                        l5 = -22;
                        j6 = -3;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    } else
                    if(i4 == 4 && j3 == 2)
                    {
                        l5 = 0;
                        j6 = -8;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    } else
                    if(i4 == 4 && j3 == 3)
                    {
                        l5 = 26;
                        j6 = -5;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    } else
                    if(i4 == 3 && j3 == 1)
                    {
                        l5 = 22;
                        j6 = 3;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    } else
                    if(i4 == 3 && j3 == 2)
                    {
                        l5 = 0;
                        j6 = 8;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    } else
                    if(i4 == 3 && j3 == 3)
                    {
                        l5 = -26;
                        j6 = 5;
                        k6 = j3 * 3 + mfb[(2 + l2.lr / 6) % 4];
                    }
                if(j3 != 5 || r.ckb[i5] == 1)
                {
                    int l6 = k6 + r.ekb[i5];
                    l5 = (l5 * k1) / ((i) (cu)).ok[l6];
                    j6 = (j6 * l1) / ((i) (cu)).pk[l6];
                    int i7 = (k1 * ((i) (cu)).ok[l6]) / ((i) (cu)).ok[r.ekb[i5]];
                    l5 -= (i7 - k1) / 2;
                    int j7 = r.akb[i5];
                    int k7 = lfb[l2.fs];
                    if(j7 == 1)
                        j7 = kfb[l2.cs];
                    else
                    if(j7 == 2)
                        j7 = jfb[l2.ds];
                    else
                    if(j7 == 3)
                        j7 = jfb[l2.es];
                    cu.cg(i1 + l5, j1 + j6, i7, l1, l6, j7, k7, j2, flag);
                }
            }
        }

        if(l2.ur > 0)
        {
            meb[ieb] = cu.kf(l2.tr, 1) / 2;
            neb[ieb] = cu.tg(1);
            if(meb[ieb] > 300)
            {
                meb[ieb] = 300;
                neb[ieb] *= 2;
            }
            keb[ieb] = i1 + k1 / 2;
            leb[ieb] = j1;
            jeb[ieb++] = l2.tr;
        }
        if(l2.wr > 0)
        {
            peb[oeb] = i1 + k1 / 2;
            qeb[oeb] = j1;
            reb[oeb] = k2;
            seb[oeb++] = l2.vr;
        }
        if(l2.mr == 8 || l2.mr == 9 || l2.as != 0)
        {
            if(l2.as > 0)
            {
                int j4 = i1;
                if(l2.mr == 8)
                    j4 -= (20 * k2) / 100;
                else
                if(l2.mr == 9)
                    j4 += (20 * k2) / 100;
                int j5 = (l2.yr * 30) / l2.zr;
                ueb[teb] = j4 + k1 / 2;
                veb[teb] = j1;
                web[teb++] = j5;
            }
            if(l2.as > 150)
            {
                int k4 = i1;
                if(l2.mr == 8)
                    k4 -= (10 * k2) / 100;
                else
                if(l2.mr == 9)
                    k4 += (10 * k2) / 100;
                cu.eh((k4 + k1 / 2) - 12, (j1 + l1 / 2) - 12, lu + 11);
                cu.ah(String.valueOf(l2.xr), (k4 + k1 / 2) - 1, j1 + l1 / 2 + 5, 3, 0xffffff);
            }
        }
        if(l2.ms == 1 && l2.wr == 0)
        {
            int l4 = j2 + i1 + k1 / 2;
            if(l2.mr == 8)
                l4 -= (20 * k2) / 100;
            else
            if(l2.mr == 9)
                l4 += (20 * k2) / 100;
            int k5 = (16 * k2) / 100;
            int i6 = (16 * k2) / 100;
            cu.uf(l4 - k5 / 2, j1 - i6 / 2 - (10 * k2) / 100, k5, i6, lu + 13);
        }
    }

    public void xl()
    {
        for(int i1 = 0; i1 < ieb; i1++)
        {
            int j1 = keb[i1];
            int l1 = leb[i1];
            int k2 = meb[i1];
            int j3 = neb[i1];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int k4 = 0; k4 < i1; k4++)
                    if(l1 > leb[k4] - neb[k4] && l1 - j3 < leb[k4] && j1 - k2 < keb[k4] + meb[k4] && j1 + k2 > keb[k4] - meb[k4])
                    {
                        l1 = leb[k4] - j3;
                        flag = true;
                    }

            }
            leb[i1] = l1;
            cu.gh(jeb[i1], j1, l1, 1, 0xffff00, 300);
        }

        for(int k1 = 0; k1 < oeb; k1++)
        {
            int i2 = peb[k1];
            int l2 = qeb[k1];
            int k3 = reb[k1];
            int i4 = seb[k1];
            int l4 = (39 * k3) / 100;
            int i5 = (27 * k3) / 100;
            int j5 = l2 - i5;
            cu.vg(i2 - l4 / 2, j5, l4, i5, lu + 9, 85);
            int k5 = (36 * k3) / 100;
            int l5 = (24 * k3) / 100;
            cu.cg(i2 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, r.eib[i4] + pw, r.qib[i4], 0, 0, false);
        }

        for(int j2 = 0; j2 < teb; j2++)
        {
            int i3 = ueb[j2];
            int l3 = veb[j2];
            int j4 = web[j2];
            cu.ag(i3 - 15, l3 - 3, j4, 5, 65280, 192);
            cu.ag((i3 - 15) + j4, l3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    public int ol(int i1)
    {
        int j1 = 0;
        for(int k1 = 0; k1 < nx; k1++)
            if(ox[k1] == i1)
                if(r.gib[i1] == 1)
                    j1++;
                else
                    j1 += px[k1];

        return j1;
    }

    public boolean sm(int i1, int j1)
    {
        if(i1 == 31 && bn(197))
            return true;
        if(i1 == 32 && bn(102))
            return true;
        if(i1 == 33 && bn(101))
            return true;
        if(i1 == 34 && bn(103))
            return true;
        return ol(i1) >= j1;
    }

    public boolean bn(int i1)
    {
        for(int j1 = 0; j1 < nx; j1++)
            if(ox[j1] == i1 && qx[j1] == 1)
                return true;

        return false;
    }

    public void dn(int i1, int j1, int k1)
    {
        cu.rg(i1, j1, k1);
        cu.rg(i1 - 1, j1, k1);
        cu.rg(i1 + 1, j1, k1);
        cu.rg(i1, j1 - 1, k1);
        cu.rg(i1, j1 + 1, k1);
    }

    public void ll(int i1, int j1, int k1, int l1, boolean flag)
    {
        fm(i1, j1, k1, l1, k1, l1, false, flag);
    }

    public void pm(int i1, int j1, int k1, int l1, boolean flag)
    {
        if(fm(i1, j1, k1, l1, k1, l1, false, flag))
        {
            return;
        } else
        {
            fm(i1, j1, k1, l1, k1, l1, true, flag);
            return;
        }
    }

    public void vk(int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        if(k1 == 0 || k1 == 4)
        {
            i2 = r.lkb[l1];
            j2 = r.mkb[l1];
        } else
        {
            j2 = r.lkb[l1];
            i2 = r.mkb[l1];
        }
        if(r.nkb[l1] == 2 || r.nkb[l1] == 3)
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
            fm(cw, dw, i1, j1, (i1 + i2) - 1, (j1 + j2) - 1, false, true);
            return;
        } else
        {
            fm(cw, dw, i1, j1, (i1 + i2) - 1, (j1 + j2) - 1, true, true);
            return;
        }
    }

    public void il(int i1, int j1, int k1)
    {
        if(k1 == 0)
        {
            fm(cw, dw, i1, j1 - 1, i1, j1, false, true);
            return;
        }
        if(k1 == 1)
        {
            fm(cw, dw, i1 - 1, j1, i1, j1, false, true);
            return;
        } else
        {
            fm(cw, dw, i1, j1, i1, j1, true, true);
            return;
        }
    }

    public boolean fm(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, 
            boolean flag1)
    {
        int k2 = wu.io(i1, j1, k1, l1, i2, j2, qt, rt, flag);
        if(k2 == -1)
            return false;
        k2--;
        i1 = qt[k2];
        j1 = rt[k2];
        k2--;
        if(flag1)
            super.yc.kb(215);
        else
            super.yc.kb(255);
        super.yc.cc(i1 + bv);
        super.yc.cc(j1 + cv);
        for(int l2 = k2; l2 >= 0 && l2 > k2 - 25; l2--)
        {
            super.yc.dc(qt[l2] - i1);
            super.yc.dc(rt[l2] - j1);
        }

        wk();
        tu = -24;
        uu = super.sq;
        vu = super.tq;
        return true;
    }

    public boolean xm(int i1, int j1)
    {
        if(qbb != 0)
        {
            wu.bhb = false;
            return false;
        }
        sbb = false;
        i1 += xu;
        j1 += yu;
        if(av == dv && i1 > ev && i1 < gv && j1 > fv && j1 < hv)
        {
            wu.bhb = true;
            return false;
        }
        cu.ah("Loading... Please wait", 256, 192, 1, 0xffffff);
        jl();
        cu.qf(au, 0, 11);
        int k1 = bv;
        int l1 = cv;
        int i2 = (i1 + 24) / 48;
        int j2 = (j1 + 24) / 48;
        av = dv;
        bv = i2 * 48 - 48;
        cv = j2 * 48 - 48;
        ev = i2 * 48 - 32;
        fv = j2 * 48 - 32;
        gv = i2 * 48 + 32;
        hv = j2 * 48 + 32;
        wu.yo(i1, j1, av);
        bv -= xu;
        cv -= yu;
        int k2 = bv - k1;
        int l2 = cv - l1;
        for(int i3 = 0; i3 < vw; i3++)
        {
            xw[i3] -= k2;
            yw[i3] -= l2;
            int j3 = xw[i3];
            int l3 = yw[i3];
            int k4 = zw[i3];
            h h1 = ww[i3];
            try
            {
                int i6 = ax[i3];
                int i7;
                int k7;
                if(i6 == 0 || i6 == 4)
                {
                    i7 = r.lkb[k4];
                    k7 = r.mkb[k4];
                } else
                {
                    k7 = r.lkb[k4];
                    i7 = r.mkb[k4];
                }
                int l7 = ((j3 + j3 + i7) * fu) / 2;
                int i8 = ((l3 + l3 + k7) * fu) / 2;
                if(j3 >= 0 && l3 >= 0 && j3 < 96 && l3 < 96)
                {
                    bu.bi(h1);
                    h1.ne(l7, -wu.po(l7, i8), i8);
                    wu.wo(j3, l3, k4);
                    if(k4 == 74)
                        h1.ge(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i3 + " obj:" + h1);
                runtimeexception.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < ex; k3++)
        {
            gx[k3] -= k2;
            hx[k3] -= l2;
            int i4 = gx[k3];
            int l4 = hx[k3];
            int j5 = jx[k3];
            int j6 = ix[k3];
            try
            {
                wu.ip(i4, l4, j6, j5);
                h h2 = km(i4, l4, j6, j5, k3);
                fx[k3] = h2;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int j4 = 0; j4 < ow; j4++)
        {
            qw[j4] -= k2;
            rw[j4] -= l2;
        }

        for(int i5 = 0; i5 < vv; i5++)
        {
            l l5 = zv[i5];
            l5.ir -= k2 * fu;
            l5.jr -= l2 * fu;
            for(int k6 = 0; k6 <= l5.pr; k6++)
            {
                l5.qr[k6] -= k2 * fu;
                l5.rr[k6] -= l2 * fu;
            }

        }

        for(int k5 = 0; k5 < hw; k5++)
        {
            l l6 = kw[k5];
            l6.ir -= k2 * fu;
            l6.jr -= l2 * fu;
            for(int j7 = 0; j7 <= l6.pr; j7++)
            {
                l6.qr[j7] -= k2 * fu;
                l6.rr[j7] -= l2 * fu;
            }

        }

        wu.bhb = true;
        return true;
    }

    public h km(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = i1;
        int k2 = j1;
        int l2 = i1;
        int i3 = j1;
        int j3 = r.wkb[l1];
        int k3 = r.xkb[l1];
        int l3 = r.vkb[l1];
        h h1 = new h(4, 1);
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
        j2 *= fu;
        k2 *= fu;
        l2 *= fu;
        i3 *= fu;
        int i4 = h1.ve(j2, -wu.po(j2, k2), k2);
        int j4 = h1.ve(j2, -wu.po(j2, k2) - l3, k2);
        int k4 = h1.ve(l2, -wu.po(l2, i3) - l3, i3);
        int l4 = h1.ve(l2, -wu.po(l2, i3), i3);
        int ai[] = {
            i4, j4, k4, l4
        };
        h1.ue(4, ai, j3, k3);
        h1.ze(false, 60, 24, -50, -10, -50);
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96)
            bu.bi(h1);
        h1.th = i2 + 10000;
        return h1;
    }

    public void rk()
    {
        if(obb != 0)
            im();
        else
        if(rbb == 1)
            ym();
        else
        if(abb && pbb == 0)
            wl();
        else
        if(sab && pbb == 0)
            zl();
        else
        if(kab)
            mm();
        else
        if(xz)
            qm();
        else
        if(wz)
            fn();
        else
        if(lbb != 0)
            am();
        else
        if(kbb != 0)
        {
            sk();
        } else
        {
            if(gbb)
                pl();
            if(bw.as > 0)
                gl();
            cl();
            boolean flag = !gbb && !sy;
            if(flag)
                xy = 0;
            if(lx == 0 && flag)
                ml();
            if(lx == 1)
                cm(flag);
            if(lx == 2)
                yk(flag);
            if(lx == 3)
                yl(flag);
            if(lx == 4)
                cn(flag);
            if(lx == 5)
                xk(flag);
            if(lx == 6)
                an(flag);
            if(!sy && !gbb)
                kl();
            if(sy && !gbb)
                um();
        }
        ot = 0;
    }

    public void pl()
    {
        if(ot != 0)
        {
            for(int i1 = 0; i1 < hbb; i1++)
            {
                if(super.sq >= cu.kf(ibb[i1], 1) || super.tq <= i1 * 12 || super.tq >= 12 + i1 * 12)
                    continue;
                super.yc.kb(237);
                super.yc.dc(i1);
                wk();
                break;
            }

            ot = 0;
            gbb = false;
            return;
        }
        for(int j1 = 0; j1 < hbb; j1++)
        {
            int k1 = 65535;
            if(super.sq < cu.kf(ibb[j1], 1) && super.tq > j1 * 12 && super.tq < 12 + j1 * 12)
                k1 = 0xff0000;
            cu.tf(ibb[j1], 6, 12 + j1 * 12, 1, k1);
        }

    }

    public void gl()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(ot != 0)
        {
            for(int i1 = 0; i1 < 5; i1++)
            {
                if(i1 <= 0 || super.sq <= byte0 || super.sq >= byte0 + c1 || super.tq <= byte1 + i1 * 20 || super.tq >= byte1 + i1 * 20 + 20)
                    continue;
                jbb = i1 - 1;
                ot = 0;
                super.yc.kb(231);
                super.yc.dc(jbb);
                wk();
                break;
            }

        }
        for(int j1 = 0; j1 < 5; j1++)
        {
            if(j1 == jbb + 1)
                cu.ag(byte0, byte1 + j1 * 20, c1, 20, jagex.client.i.qg(255, 0, 0), 128);
            else
                cu.ag(byte0, byte1 + j1 * 20, c1, 20, jagex.client.i.qg(190, 190, 190), 128);
            cu.xg(byte0, byte1 + j1 * 20, c1, 0);
            cu.xg(byte0, byte1 + j1 * 20 + 20, c1, 0);
        }

        cu.ah("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        cu.ah("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        cu.ah("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        cu.ah("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        cu.ah("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    public void im()
    {
        cu.eg(126, 137, 260, 60, 0);
        cu.xf(126, 137, 260, 60, 0xffffff);
        cu.ah("Logging out...", 256, 173, 5, 0xffffff);
    }

    public void ym()
    {
        int i1 = 97;
        cu.eg(86, 77, 340, 180, 0);
        cu.xf(86, 77, 340, 180, 0xffffff);
        cu.ah("Warning! Proceed with caution", 256, i1, 4, 0xff0000);
        i1 += 26;
        cu.ah("If you go much further north you will enter the", 256, i1, 1, 0xffffff);
        i1 += 13;
        cu.ah("wilderness. This a very dangerous area where", 256, i1, 1, 0xffffff);
        i1 += 13;
        cu.ah("other players can attack you!", 256, i1, 1, 0xffffff);
        i1 += 22;
        cu.ah("The further north you go the more dangerous it", 256, i1, 1, 0xffffff);
        i1 += 13;
        cu.ah("becomes, but the more treasure you will find.", 256, i1, 1, 0xffffff);
        i1 += 22;
        cu.ah("In the wilderness an indicator at the bottom-right", 256, i1, 1, 0xffffff);
        i1 += 13;
        cu.ah("of the screen will show the current level of danger", 256, i1, 1, 0xffffff);
        i1 += 22;
        int j1 = 0xffffff;
        if(super.tq > i1 - 12 && super.tq <= i1 && super.sq > 181 && super.sq < 331)
            j1 = 0xff0000;
        cu.ah("Click here to close window", 256, i1, 1, j1);
        if(ot != 0)
        {
            if(super.tq > i1 - 12 && super.tq <= i1 && super.sq > 181 && super.sq < 331)
                rbb = 2;
            if(super.sq < 86 || super.sq > 426 || super.tq < 77 || super.tq > 257)
                rbb = 2;
            ot = 0;
        }
    }

    public void am()
    {
        if(ot != 0)
        {
            ot = 0;
            if(super.sq < 106 || super.tq < 150 || super.sq > 406 || super.tq > 210)
            {
                lbb = 0;
                return;
            }
        }
        int i1 = 150;
        cu.eg(106, i1, 300, 60, 0);
        cu.xf(106, i1, 300, 60, 0xffffff);
        i1 += 22;
        if(lbb == 6)
        {
            cu.ah("Please enter your current password", 256, i1, 4, 0xffffff);
            i1 += 25;
            String s1 = "*";
            for(int j1 = 0; j1 < super.zq.length(); j1++)
                s1 = "X" + s1;

            cu.ah(s1, 256, i1, 4, 0xffffff);
            if(super.ar.length() > 0)
            {
                mbb = super.ar;
                super.zq = "";
                super.ar = "";
                lbb = 1;
                return;
            }
        } else
        if(lbb == 1)
        {
            cu.ah("Please enter your new password", 256, i1, 4, 0xffffff);
            i1 += 25;
            String s2 = "*";
            for(int k1 = 0; k1 < super.zq.length(); k1++)
                s2 = "X" + s2;

            cu.ah(s2, 256, i1, 4, 0xffffff);
            if(super.ar.length() > 0)
            {
                nbb = super.ar;
                super.zq = "";
                super.ar = "";
                if(nbb.length() >= 5)
                {
                    lbb = 2;
                    return;
                } else
                {
                    lbb = 5;
                    return;
                }
            }
        } else
        if(lbb == 2)
        {
            cu.ah("Enter password again to confirm", 256, i1, 4, 0xffffff);
            i1 += 25;
            String s3 = "*";
            for(int l1 = 0; l1 < super.zq.length(); l1++)
                s3 = "X" + s3;

            cu.ah(s3, 256, i1, 4, 0xffffff);
            if(super.ar.length() > 0)
                if(super.ar.equalsIgnoreCase(nbb))
                {
                    lbb = 4;
                    bb(mbb, nbb);
                    return;
                } else
                {
                    lbb = 3;
                    return;
                }
        } else
        {
            if(lbb == 3)
            {
                cu.ah("Passwords do not match!", 256, i1, 4, 0xffffff);
                i1 += 25;
                cu.ah("Press any key to close", 256, i1, 4, 0xffffff);
                return;
            }
            if(lbb == 4)
            {
                cu.ah("Ok, your request has been sent", 256, i1, 4, 0xffffff);
                i1 += 25;
                cu.ah("Press any key to close", 256, i1, 4, 0xffffff);
                return;
            }
            if(lbb == 5)
            {
                cu.ah("Password must be at", 256, i1, 4, 0xffffff);
                i1 += 25;
                cu.ah("least 5 letters long", 256, i1, 4, 0xffffff);
            }
        }
    }

    public void sk()
    {
        if(ot != 0)
        {
            ot = 0;
            if(kbb == 1 && (super.sq < 106 || super.tq < 145 || super.sq > 406 || super.tq > 215))
            {
                kbb = 0;
                return;
            }
            if(kbb == 2 && (super.sq < 6 || super.tq < 145 || super.sq > 506 || super.tq > 215))
            {
                kbb = 0;
                return;
            }
            if(kbb == 3 && (super.sq < 106 || super.tq < 145 || super.sq > 406 || super.tq > 215))
            {
                kbb = 0;
                return;
            }
            if(super.sq > 236 && super.sq < 276 && super.tq > 193 && super.tq < 213)
            {
                kbb = 0;
                return;
            }
        }
        int i1 = 145;
        if(kbb == 1)
        {
            cu.eg(106, i1, 300, 70, 0);
            cu.xf(106, i1, 300, 70, 0xffffff);
            i1 += 20;
            cu.ah("Enter name to add to friends list", 256, i1, 4, 0xffffff);
            i1 += 20;
            cu.ah(super.zq + "*", 256, i1, 4, 0xffffff);
            if(super.ar.length() > 0)
            {
                String s1 = super.ar.trim();
                super.zq = "";
                super.ar = "";
                kbb = 0;
                if(s1.length() > 0 && o.sn(s1) != bw.er)
                    w(s1);
            }
        }
        if(kbb == 2)
        {
            cu.eg(6, i1, 500, 70, 0);
            cu.xf(6, i1, 500, 70, 0xffffff);
            i1 += 20;
            cu.ah("Enter message to send to " + o.xn(iy), 256, i1, 4, 0xffffff);
            i1 += 20;
            cu.ah(super.br + "*", 256, i1, 4, 0xffffff);
            if(super.cr.length() > 0)
            {
                String s2 = super.cr;
                super.br = "";
                super.cr = "";
                kbb = 0;
                int k1 = o.mn(s2);
                y(iy, o.wfb, k1);
                s2 = o.qn(o.wfb, 0, k1, true);
                k("@pri@You tell " + o.xn(iy) + ": " + s2);
            }
        }
        if(kbb == 3)
        {
            cu.eg(106, i1, 300, 70, 0);
            cu.xf(106, i1, 300, 70, 0xffffff);
            i1 += 20;
            cu.ah("Enter name to add to ignore list", 256, i1, 4, 0xffffff);
            i1 += 20;
            cu.ah(super.zq + "*", 256, i1, 4, 0xffffff);
            if(super.ar.length() > 0)
            {
                String s3 = super.ar.trim();
                super.zq = "";
                super.ar = "";
                kbb = 0;
                if(s3.length() > 0 && o.sn(s3) != bw.er)
                    cb(s3);
            }
        }
        int j1 = 0xffffff;
        if(super.sq > 236 && super.sq < 276 && super.tq > 193 && super.tq < 213)
            j1 = 0xffff00;
        cu.ah("Cancel", 256, 208, 1, j1);
    }

    public void wl()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(ebb >= bbb)
            ebb = -1;
        if(ebb >= 0 && ebb < 48 && cbb[ebb] != fbb)
        {
            ebb = -1;
            fbb = -2;
        }
        if(ot != 0)
        {
            ot = 0;
            int i1 = super.sq - (256 - c1 / 2);
            int k1 = super.tq - (170 - c2 / 2);
            if(i1 >= 0 && k1 >= 12 && i1 < 408 && k1 < 280)
            {
                int i2 = 0;
                for(int l2 = 0; l2 < 6; l2++)
                {
                    for(int j6 = 0; j6 < 8; j6++)
                    {
                        int i7 = 7 + j6 * 49;
                        int l7 = 28 + l2 * 34;
                        if(i1 > i7 && i1 < i7 + 49 && k1 > l7 && k1 < l7 + 34 && i2 < bbb && cbb[i2] != -1)
                        {
                            fbb = cbb[i2];
                            ebb = i2;
                        }
                        i2++;
                    }

                }

                i1 = 256 - c1 / 2;
                k1 = 170 - c2 / 2;
                int k6;
                if(ebb < 0)
                    k6 = -1;
                else
                    k6 = cbb[ebb];
                if(k6 != -1)
                {
                    int j2 = dbb[ebb];
                    if(r.gib[k6] == 1 && j2 > 1)
                        j2 = 1;
                    if(j2 >= 1 && super.sq >= i1 + 220 && super.tq >= k1 + 238 && super.sq < i1 + 250 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(1);
                        wk();
                    }
                    if(j2 >= 5 && super.sq >= i1 + 250 && super.tq >= k1 + 238 && super.sq < i1 + 280 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(5);
                        wk();
                    }
                    if(j2 >= 25 && super.sq >= i1 + 280 && super.tq >= k1 + 238 && super.sq < i1 + 305 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(25);
                        wk();
                    }
                    if(j2 >= 100 && super.sq >= i1 + 305 && super.tq >= k1 + 238 && super.sq < i1 + 335 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(100);
                        wk();
                    }
                    if(j2 >= 500 && super.sq >= i1 + 335 && super.tq >= k1 + 238 && super.sq < i1 + 368 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(500);
                        wk();
                    }
                    if(j2 >= 2500 && super.sq >= i1 + 370 && super.tq >= k1 + 238 && super.sq < i1 + 400 && super.tq <= k1 + 249)
                    {
                        super.yc.kb(206);
                        super.yc.cc(k6);
                        super.yc.cc(2500);
                        wk();
                    }
                    if(ol(k6) >= 1 && super.sq >= i1 + 220 && super.tq >= k1 + 263 && super.sq < i1 + 250 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(1);
                        wk();
                    }
                    if(ol(k6) >= 5 && super.sq >= i1 + 250 && super.tq >= k1 + 263 && super.sq < i1 + 280 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(5);
                        wk();
                    }
                    if(ol(k6) >= 25 && super.sq >= i1 + 280 && super.tq >= k1 + 263 && super.sq < i1 + 305 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(25);
                        wk();
                    }
                    if(ol(k6) >= 100 && super.sq >= i1 + 305 && super.tq >= k1 + 263 && super.sq < i1 + 335 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(100);
                        wk();
                    }
                    if(ol(k6) >= 500 && super.sq >= i1 + 335 && super.tq >= k1 + 263 && super.sq < i1 + 368 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(500);
                        wk();
                    }
                    if(ol(k6) >= 2500 && super.sq >= i1 + 370 && super.tq >= k1 + 263 && super.sq < i1 + 400 && super.tq <= k1 + 274)
                    {
                        super.yc.kb(205);
                        super.yc.cc(k6);
                        super.yc.cc(2500);
                        wk();
                    }
                }
            } else
            {
                super.yc.kb(207);
                wk();
                abb = false;
                return;
            }
        }
        int j1 = 256 - c1 / 2;
        int l1 = 170 - c2 / 2;
        cu.eg(j1, l1, 408, 12, 192);
        int k2 = 0x989898;
        cu.ag(j1, l1 + 12, 408, 17, k2, 160);
        cu.ag(j1, l1 + 29, 8, 204, k2, 160);
        cu.ag(j1 + 399, l1 + 29, 9, 204, k2, 160);
        cu.ag(j1, l1 + 233, 408, 47, k2, 160);
        cu.tf("Bank", j1 + 1, l1 + 10, 1, 0xffffff);
        int i3 = 0xffffff;
        if(super.sq > j1 + 320 && super.tq >= l1 && super.sq < j1 + 408 && super.tq < l1 + 12)
            i3 = 0xff0000;
        cu.fh("Close window", j1 + 406, l1 + 10, 1, i3);
        cu.tf("Number in bank in green", j1 + 7, l1 + 24, 1, 65280);
        cu.tf("Number held in blue", j1 + 289, l1 + 24, 1, 65535);
        int l6 = 0xd0d0d0;
        int j7 = 0;
        for(int i8 = 0; i8 < 6; i8++)
        {
            for(int j8 = 0; j8 < 8; j8++)
            {
                int l8 = j1 + 7 + j8 * 49;
                int i9 = l1 + 28 + i8 * 34;
                if(ebb == j7)
                    cu.ag(l8, i9, 49, 34, 0xff0000, 160);
                else
                    cu.ag(l8, i9, 49, 34, l6, 160);
                cu.xf(l8, i9, 50, 35, 0);
                if(j7 < bbb && cbb[j7] != -1)
                {
                    cu.cg(l8, i9, 48, 32, pw + r.eib[cbb[j7]], r.qib[cbb[j7]], 0, 0, false);
                    cu.tf(String.valueOf(dbb[j7]), l8 + 1, i9 + 10, 1, 65280);
                    cu.fh(String.valueOf(ol(cbb[j7])), l8 + 47, i9 + 29, 1, 65535);
                }
                j7++;
            }

        }

        cu.xg(j1 + 5, l1 + 256, 398, 0);
        if(ebb == -1)
        {
            cu.ah("Select an object to withdraw or deposit", j1 + 204, l1 + 248, 3, 0xffff00);
            return;
        }
        int k8;
        if(ebb < 0)
            k8 = -1;
        else
            k8 = cbb[ebb];
        if(k8 != -1)
        {
            int k7 = dbb[ebb];
            if(r.gib[k8] == 1 && k7 > 1)
                k7 = 1;
            if(k7 > 0)
            {
                cu.tf("Withdraw " + r.aib[k8][0], j1 + 2, l1 + 248, 1, 0xffffff);
                int j3 = 0xffffff;
                if(super.sq >= j1 + 220 && super.tq >= l1 + 238 && super.sq < j1 + 250 && super.tq <= l1 + 249)
                    j3 = 0xff0000;
                cu.tf("One", j1 + 222, l1 + 248, 1, j3);
                if(k7 >= 5)
                {
                    int k3 = 0xffffff;
                    if(super.sq >= j1 + 250 && super.tq >= l1 + 238 && super.sq < j1 + 280 && super.tq <= l1 + 249)
                        k3 = 0xff0000;
                    cu.tf("Five", j1 + 252, l1 + 248, 1, k3);
                }
                if(k7 >= 25)
                {
                    int l3 = 0xffffff;
                    if(super.sq >= j1 + 280 && super.tq >= l1 + 238 && super.sq < j1 + 305 && super.tq <= l1 + 249)
                        l3 = 0xff0000;
                    cu.tf("25", j1 + 282, l1 + 248, 1, l3);
                }
                if(k7 >= 100)
                {
                    int i4 = 0xffffff;
                    if(super.sq >= j1 + 305 && super.tq >= l1 + 238 && super.sq < j1 + 335 && super.tq <= l1 + 249)
                        i4 = 0xff0000;
                    cu.tf("100", j1 + 307, l1 + 248, 1, i4);
                }
                if(k7 >= 500)
                {
                    int j4 = 0xffffff;
                    if(super.sq >= j1 + 335 && super.tq >= l1 + 238 && super.sq < j1 + 368 && super.tq <= l1 + 249)
                        j4 = 0xff0000;
                    cu.tf("500", j1 + 337, l1 + 248, 1, j4);
                }
                if(k7 >= 2500)
                {
                    int k4 = 0xffffff;
                    if(super.sq >= j1 + 370 && super.tq >= l1 + 238 && super.sq < j1 + 400 && super.tq <= l1 + 249)
                        k4 = 0xff0000;
                    cu.tf("2500", j1 + 370, l1 + 248, 1, k4);
                }
            }
            if(ol(k8) > 0)
            {
                cu.tf("Deposit " + r.aib[k8][0], j1 + 2, l1 + 273, 1, 0xffffff);
                int l4 = 0xffffff;
                if(super.sq >= j1 + 220 && super.tq >= l1 + 263 && super.sq < j1 + 250 && super.tq <= l1 + 274)
                    l4 = 0xff0000;
                cu.tf("One", j1 + 222, l1 + 273, 1, l4);
                if(ol(k8) >= 5)
                {
                    int i5 = 0xffffff;
                    if(super.sq >= j1 + 250 && super.tq >= l1 + 263 && super.sq < j1 + 280 && super.tq <= l1 + 274)
                        i5 = 0xff0000;
                    cu.tf("Five", j1 + 252, l1 + 273, 1, i5);
                }
                if(ol(k8) >= 25)
                {
                    int j5 = 0xffffff;
                    if(super.sq >= j1 + 280 && super.tq >= l1 + 263 && super.sq < j1 + 305 && super.tq <= l1 + 274)
                        j5 = 0xff0000;
                    cu.tf("25", j1 + 282, l1 + 273, 1, j5);
                }
                if(ol(k8) >= 100)
                {
                    int k5 = 0xffffff;
                    if(super.sq >= j1 + 305 && super.tq >= l1 + 263 && super.sq < j1 + 335 && super.tq <= l1 + 274)
                        k5 = 0xff0000;
                    cu.tf("100", j1 + 307, l1 + 273, 1, k5);
                }
                if(ol(k8) >= 500)
                {
                    int l5 = 0xffffff;
                    if(super.sq >= j1 + 335 && super.tq >= l1 + 263 && super.sq < j1 + 368 && super.tq <= l1 + 274)
                        l5 = 0xff0000;
                    cu.tf("500", j1 + 337, l1 + 273, 1, l5);
                }
                if(ol(k8) >= 2500)
                {
                    int i6 = 0xffffff;
                    if(super.sq >= j1 + 370 && super.tq >= l1 + 263 && super.sq < j1 + 400 && super.tq <= l1 + 274)
                        i6 = 0xff0000;
                    cu.tf("2500", j1 + 370, l1 + 273, 1, i6);
                }
            }
        }
    }

    public void zl()
    {
        if(ot != 0)
        {
            ot = 0;
            int i1 = super.sq - 52;
            int j1 = super.tq - 44;
            if(i1 >= 0 && j1 >= 12 && i1 < 408 && j1 < 246)
            {
                int k1 = 0;
                for(int i2 = 0; i2 < 5; i2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int l3 = 7 + i3 * 49;
                        int l4 = 28 + i2 * 34;
                        if(i1 > l3 && i1 < l3 + 49 && j1 > l4 && j1 < l4 + 34 && vab[k1] != -1)
                        {
                            yab = k1;
                            zab = vab[k1];
                        }
                        k1++;
                    }

                }

                if(yab >= 0)
                {
                    int j3 = vab[yab];
                    if(j3 != -1)
                    {
                        if(wab[yab] > 0 && i1 > 298 && j1 >= 204 && i1 < 408 && j1 <= 215)
                        {
                            int i4 = uab + xab[yab];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * r.fib[j3]) / 100;
                            super.yc.kb(217);
                            super.yc.cc(vab[yab]);
                            super.yc.cc(i5);
                            wk();
                        }
                        if(ol(j3) > 0 && i1 > 2 && j1 >= 229 && i1 < 112 && j1 <= 240)
                        {
                            int j4 = tab + xab[yab];
                            if(j4 < 10)
                                j4 = 10;
                            int j5 = (j4 * r.fib[j3]) / 100;
                            super.yc.kb(216);
                            super.yc.cc(vab[yab]);
                            super.yc.cc(j5);
                            wk();
                        }
                    }
                }
            } else
            {
                super.yc.kb(218);
                wk();
                sab = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        cu.eg(byte0, byte1, 408, 12, 192);
        int l1 = 0x989898;
        cu.ag(byte0, byte1 + 12, 408, 17, l1, 160);
        cu.ag(byte0, byte1 + 29, 8, 170, l1, 160);
        cu.ag(byte0 + 399, byte1 + 29, 9, 170, l1, 160);
        cu.ag(byte0, byte1 + 199, 408, 47, l1, 160);
        cu.tf("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int j2 = 0xffffff;
        if(super.sq > byte0 + 320 && super.tq >= byte1 && super.sq < byte0 + 408 && super.tq < byte1 + 12)
            j2 = 0xff0000;
        cu.fh("Close window", byte0 + 406, byte1 + 10, 1, j2);
        cu.tf("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        cu.tf("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        cu.tf("Your money: " + ol(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int k3 = 0xd0d0d0;
        int k4 = 0;
        for(int k5 = 0; k5 < 5; k5++)
        {
            for(int l5 = 0; l5 < 8; l5++)
            {
                int j6 = byte0 + 7 + l5 * 49;
                int i7 = byte1 + 28 + k5 * 34;
                if(yab == k4)
                    cu.ag(j6, i7, 49, 34, 0xff0000, 160);
                else
                    cu.ag(j6, i7, 49, 34, k3, 160);
                cu.xf(j6, i7, 50, 35, 0);
                if(vab[k4] != -1)
                {
                    cu.cg(j6, i7, 48, 32, pw + r.eib[vab[k4]], r.qib[vab[k4]], 0, 0, false);
                    cu.tf(String.valueOf(wab[k4]), j6 + 1, i7 + 10, 1, 65280);
                    cu.fh(String.valueOf(ol(vab[k4])), j6 + 47, i7 + 10, 1, 65535);
                }
                k4++;
            }

        }

        cu.xg(byte0 + 5, byte1 + 222, 398, 0);
        if(yab == -1)
        {
            cu.ah("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int i6 = vab[yab];
        if(i6 != -1)
        {
            if(wab[yab] > 0)
            {
                int k6 = uab + xab[yab];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * r.fib[i6]) / 100;
                cu.tf("Buy a new " + r.aib[i6][0] + " for " + j7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.sq > byte0 + 298 && super.tq >= byte1 + 204 && super.sq < byte0 + 408 && super.tq <= byte1 + 215)
                    k2 = 0xff0000;
                cu.fh("Click here to buy", byte0 + 405, byte1 + 214, 3, k2);
            } else
            {
                cu.ah("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(ol(i6) > 0)
            {
                int l6 = tab + xab[yab];
                if(l6 < 10)
                    l6 = 10;
                int k7 = (l6 * r.fib[i6]) / 100;
                cu.fh("Sell your " + r.aib[i6][0] + " for " + k7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l2 = 0xffffff;
                if(super.sq > byte0 + 2 && super.tq >= byte1 + 229 && super.sq < byte0 + 112 && super.tq <= byte1 + 240)
                    l2 = 0xff0000;
                cu.tf("Click here to sell", byte0 + 2, byte1 + 239, 3, l2);
                return;
            }
            cu.ah("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    public void mm()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        cu.eg(byte0, byte1, 468, 16, 192);
        int i1 = 0x989898;
        cu.ag(byte0, byte1 + 16, 468, 246, i1, 160);
        cu.ah("Please confirm your trade with @yel@" + o.xn(jab), byte0 + 234, byte1 + 12, 1, 0xffffff);
        cu.ah("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < zz; j1++)
        {
            String s1 = r.aib[aab[j1]][0];
            if(r.gib[aab[j1]] == 0)
                s1 = s1 + " (" + bab[j1] + ")";
            cu.ah(s1, byte0 + 117, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(zz == 0)
            cu.ah("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        cu.ah("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k1 = 0; k1 < cab; k1++)
        {
            String s2 = r.aib[dab[k1]][0];
            if(r.gib[dab[k1]] == 0)
                s2 = s2 + " (" + eab[k1] + ")";
            cu.ah(s2, byte0 + 351, byte1 + 42 + k1 * 12, 1, 0xffffff);
        }

        if(cab == 0)
            cu.ah("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        cu.ah("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        cu.ah("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        cu.ah("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!lab)
        {
            cu.eh((byte0 + 118) - 35, byte1 + 238, lu + 25);
            cu.eh((byte0 + 352) - 35, byte1 + 238, lu + 26);
        } else
        {
            cu.ah("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(ot == 1)
        {
            if(super.sq < byte0 || super.tq < byte1 || super.sq > byte0 + 468 || super.tq > byte1 + 262)
            {
                kab = false;
                super.yc.kb(233);
                wk();
            }
            if(super.sq >= (byte0 + 118) - 35 && super.sq <= byte0 + 118 + 70 && super.tq >= byte1 + 238 && super.tq <= byte1 + 238 + 21)
            {
                lab = true;
                super.yc.kb(202);
                wk();
            }
            if(super.sq >= (byte0 + 352) - 35 && super.sq <= byte0 + 353 + 70 && super.tq >= byte1 + 238 && super.tq <= byte1 + 238 + 21)
            {
                kab = false;
                super.yc.kb(233);
                wk();
            }
            ot = 0;
        }
    }

    public void qm()
    {
        if(ot != 0 && iab == 0)
            iab = 1;
        if(iab > 0)
        {
            int i1 = super.sq - 22;
            int j1 = super.tq - 36;
            if(i1 >= 0 && j1 >= 0 && i1 < 468 && j1 < 262)
            {
                if(i1 > 216 && j1 > 30 && i1 < 462 && j1 < 235)
                {
                    int k1 = (i1 - 217) / 49 + ((j1 - 31) / 34) * 5;
                    if(k1 >= 0 && k1 < nx)
                    {
                        boolean flag = false;
                        int l2 = 0;
                        int k3 = ox[k1];
                        for(int k4 = 0; k4 < zz; k4++)
                            if(aab[k4] == k3)
                                if(r.gib[k3] == 0)
                                {
                                    for(int i5 = 0; i5 < iab; i5++)
                                    {
                                        if(bab[k4] < px[k1])
                                            bab[k4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    l2++;
                                }

                        if(ol(k3) <= l2)
                            flag = true;
                        if(!flag && zz < 12)
                        {
                            aab[zz] = k3;
                            bab[zz] = 1;
                            zz++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.yc.kb(234);
                            super.yc.dc(zz);
                            for(int j5 = 0; j5 < zz; j5++)
                            {
                                super.yc.cc(aab[j5]);
                                super.yc.bc(bab[j5]);
                            }

                            wk();
                            fab = false;
                            gab = false;
                        }
                    }
                }
                if(i1 > 8 && j1 > 30 && i1 < 205 && j1 < 133)
                {
                    int l1 = (i1 - 9) / 49 + ((j1 - 31) / 34) * 4;
                    if(l1 >= 0 && l1 < zz)
                    {
                        int j2 = aab[l1];
                        for(int i3 = 0; i3 < iab; i3++)
                        {
                            if(r.gib[j2] == 0 && bab[l1] > 1)
                            {
                                bab[l1]--;
                                continue;
                            }
                            zz--;
                            hab = 0;
                            for(int l3 = l1; l3 < zz; l3++)
                            {
                                aab[l3] = aab[l3 + 1];
                                bab[l3] = bab[l3 + 1];
                            }

                            break;
                        }

                        super.yc.kb(234);
                        super.yc.dc(zz);
                        for(int i4 = 0; i4 < zz; i4++)
                        {
                            super.yc.cc(aab[i4]);
                            super.yc.bc(bab[i4]);
                        }

                        wk();
                        fab = false;
                        gab = false;
                    }
                }
                if(i1 >= 217 && j1 >= 238 && i1 <= 286 && j1 <= 259)
                {
                    gab = true;
                    super.yc.kb(232);
                    wk();
                }
                if(i1 >= 394 && j1 >= 238 && i1 < 463 && j1 < 259)
                {
                    xz = false;
                    super.yc.kb(233);
                    wk();
                }
            } else
            if(ot != 0)
            {
                xz = false;
                super.yc.kb(233);
                wk();
            }
            ot = 0;
            iab = 0;
        }
        if(!xz)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        cu.eg(byte0, byte1, 468, 12, 192);
        int i2 = 0x989898;
        cu.ag(byte0, byte1 + 12, 468, 18, i2, 160);
        cu.ag(byte0, byte1 + 30, 8, 248, i2, 160);
        cu.ag(byte0 + 205, byte1 + 30, 11, 248, i2, 160);
        cu.ag(byte0 + 462, byte1 + 30, 6, 248, i2, 160);
        cu.ag(byte0 + 8, byte1 + 133, 197, 22, i2, 160);
        cu.ag(byte0 + 8, byte1 + 258, 197, 20, i2, 160);
        cu.ag(byte0 + 216, byte1 + 235, 246, 43, i2, 160);
        int k2 = 0xd0d0d0;
        cu.ag(byte0 + 8, byte1 + 30, 197, 103, k2, 160);
        cu.ag(byte0 + 8, byte1 + 155, 197, 103, k2, 160);
        cu.ag(byte0 + 216, byte1 + 30, 246, 205, k2, 160);
        for(int j3 = 0; j3 < 4; j3++)
            cu.xg(byte0 + 8, byte1 + 30 + j3 * 34, 197, 0);

        for(int j4 = 0; j4 < 4; j4++)
            cu.xg(byte0 + 8, byte1 + 155 + j4 * 34, 197, 0);

        for(int l4 = 0; l4 < 7; l4++)
            cu.xg(byte0 + 216, byte1 + 30 + l4 * 34, 246, 0);

        for(int k5 = 0; k5 < 6; k5++)
        {
            if(k5 < 5)
                cu.ch(byte0 + 8 + k5 * 49, byte1 + 30, 103, 0);
            if(k5 < 5)
                cu.ch(byte0 + 8 + k5 * 49, byte1 + 155, 103, 0);
            cu.ch(byte0 + 216 + k5 * 49, byte1 + 30, 205, 0);
        }

        cu.tf("Trading with: " + yz, byte0 + 1, byte1 + 10, 1, 0xffffff);
        cu.tf("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        cu.tf("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        cu.tf("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!gab)
            cu.eh(byte0 + 217, byte1 + 238, lu + 25);
        cu.eh(byte0 + 394, byte1 + 238, lu + 26);
        if(fab)
        {
            cu.ah("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            cu.ah("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(gab)
        {
            cu.ah("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            cu.ah("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l5 = 0; l5 < nx; l5++)
        {
            int i6 = 217 + byte0 + (l5 % 5) * 49;
            int k6 = 31 + byte1 + (l5 / 5) * 34;
            cu.cg(i6, k6, 48, 32, pw + r.eib[ox[l5]], r.qib[ox[l5]], 0, 0, false);
            if(r.gib[ox[l5]] == 0)
                cu.tf(String.valueOf(px[l5]), i6 + 1, k6 + 10, 1, 0xffff00);
        }

        for(int j6 = 0; j6 < zz; j6++)
        {
            int l6 = 9 + byte0 + (j6 % 4) * 49;
            int j7 = 31 + byte1 + (j6 / 4) * 34;
            cu.cg(l6, j7, 48, 32, pw + r.eib[aab[j6]], r.qib[aab[j6]], 0, 0, false);
            if(r.gib[aab[j6]] == 0)
                cu.tf(String.valueOf(bab[j6]), l6 + 1, j7 + 10, 1, 0xffff00);
            if(super.sq > l6 && super.sq < l6 + 48 && super.tq > j7 && super.tq < j7 + 32)
                cu.tf(r.aib[aab[j6]][0] + ": @whi@" + r.bib[aab[j6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i7 = 0; i7 < cab; i7++)
        {
            int k7 = 9 + byte0 + (i7 % 4) * 49;
            int l7 = 156 + byte1 + (i7 / 4) * 34;
            cu.cg(k7, l7, 48, 32, pw + r.eib[dab[i7]], r.qib[dab[i7]], 0, 0, false);
            if(r.gib[dab[i7]] == 0)
                cu.tf(String.valueOf(eab[i7]), k7 + 1, l7 + 10, 1, 0xffff00);
            if(super.sq > k7 && super.sq < k7 + 48 && super.tq > l7 && super.tq < l7 + 32)
                cu.tf(r.aib[dab[i7]][0] + ": @whi@" + r.bib[dab[i7]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public void fn()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        if(ot == 1)
        {
            if(super.sq <= byte0 || super.tq <= byte1 || super.sq >= byte0 + 468 || super.tq >= byte1 + 262)
            {
                wz = false;
                super.yc.kb(203);
                wk();
            }
            ot = 0;
        }
        cu.eg(byte0, byte1, 468, 12, 192);
        int i1 = 0x989898;
        cu.ag(byte0, byte1 + 12, 468, 250, i1, 160);
    }

    public void cl()
    {
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 && super.tq < 35)
            lx = 1;
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 - 33 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 33 && super.tq < 35)
            lx = 2;
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 - 66 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 66 && super.tq < 35)
            lx = 3;
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 - 99 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 99 && super.tq < 35)
            lx = 4;
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 - 132 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 132 && super.tq < 35)
            lx = 5;
        if(lx == 0 && super.sq >= ((i) (cu)).xj - 35 - 165 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 165 && super.tq < 35)
            lx = 6;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 && super.tq < 26)
            lx = 1;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 - 33 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 33 && super.tq < 26)
            lx = 2;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 - 66 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 66 && super.tq < 26)
            lx = 3;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 - 99 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 99 && super.tq < 26)
            lx = 4;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 - 132 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 132 && super.tq < 26)
            lx = 5;
        if(lx != 0 && super.sq >= ((i) (cu)).xj - 35 - 165 && super.tq >= 3 && super.sq < ((i) (cu)).xj - 3 - 165 && super.tq < 26)
            lx = 6;
        if(lx == 1 && (super.sq < ((i) (cu)).xj - 248 || super.tq > 36 + (mx / 5) * 34))
            lx = 0;
        if(lx == 3 && (super.sq < ((i) (cu)).xj - 199 || super.tq > 284))
            lx = 0;
        if((lx == 2 || lx == 4 || lx == 5) && (super.sq < ((i) (cu)).xj - 199 || super.tq > 240))
            lx = 0;
        if(lx == 6 && (super.sq < ((i) (cu)).xj - 199 || super.tq > 252))
            lx = 0;
    }

    public void cm(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 248;
        cu.eh(i1, 3, lu + 1);
        for(int j1 = 0; j1 < mx; j1++)
        {
            int k1 = i1 + (j1 % 5) * 49;
            int i2 = 36 + (j1 / 5) * 34;
            if(j1 < nx && qx[j1] == 1)
                cu.ag(k1, i2, 49, 34, 0xff0000, 128);
            else
                cu.ag(k1, i2, 49, 34, jagex.client.i.qg(181, 181, 181), 128);
            if(j1 < nx)
            {
                cu.cg(k1, i2, 48, 32, pw + r.eib[ox[j1]], r.qib[ox[j1]], 0, 0, false);
                if(r.gib[ox[j1]] == 0)
                    cu.tf(String.valueOf(px[j1]), k1 + 1, i2 + 10, 1, 0xffff00);
            }
        }

        for(int l1 = 1; l1 <= 4; l1++)
            cu.ch(i1 + l1 * 49, 36, (mx / 5) * 34, 0);

        for(int j2 = 1; j2 <= mx / 5 - 1; j2++)
            cu.xg(i1, 36 + j2 * 34, 245, 0);

        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 248);
        int k2 = super.tq - 36;
        if(i1 >= 0 && k2 >= 0 && i1 < 248 && k2 < (mx / 5) * 34)
        {
            int l2 = i1 / 49 + (k2 / 34) * 5;
            if(l2 < nx)
            {
                int i3 = ox[l2];
                if(ey >= 0)
                {
                    if(r.amb[ey] == 3)
                    {
                        bz[xy] = "Cast " + r.wlb[ey] + " on";
                        az[xy] = "@lre@" + r.aib[i3][0];
                        cz[xy] = 600;
                        fz[xy] = l2;
                        gz[xy] = ey;
                        xy++;
                        return;
                    }
                } else
                {
                    if(rx >= 0)
                    {
                        bz[xy] = "Use " + sx + " with";
                        az[xy] = "@lre@" + r.aib[i3][0];
                        cz[xy] = 610;
                        fz[xy] = l2;
                        gz[xy] = rx;
                        xy++;
                        return;
                    }
                    if(qx[l2] == 1)
                    {
                        bz[xy] = "Remove";
                        az[xy] = "@lre@" + r.aib[i3][0];
                        cz[xy] = 620;
                        fz[xy] = l2;
                        xy++;
                    } else
                    if(r.oib[i3] != 0)
                    {
                        if((r.oib[i3] & 0x18) != 0)
                            bz[xy] = "Wield";
                        else
                            bz[xy] = "Wear";
                        az[xy] = "@lre@" + r.aib[i3][0];
                        cz[xy] = 630;
                        fz[xy] = l2;
                        xy++;
                    }
                    if(!r.dib[i3].equals("_"))
                    {
                        bz[xy] = r.dib[i3];
                        az[xy] = "@lre@" + r.aib[i3][0];
                        cz[xy] = 640;
                        fz[xy] = l2;
                        xy++;
                    }
                    bz[xy] = "Use";
                    az[xy] = "@lre@" + r.aib[i3][0];
                    cz[xy] = 650;
                    fz[xy] = l2;
                    xy++;
                    bz[xy] = "Drop";
                    az[xy] = "@lre@" + r.aib[i3][0];
                    cz[xy] = 660;
                    fz[xy] = l2;
                    xy++;
                    bz[xy] = "Examine";
                    az[xy] = "@lre@" + r.aib[i3][0];
                    cz[xy] = 3600;
                    fz[xy] = i3;
                    xy++;
                }
            }
        }
    }

    public void yk(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 199;
        char c1 = '\234';
        char c3 = '\230';
        cu.eh(i1 - 49, 3, lu + 2);
        i1 += 40;
        cu.eg(i1, 36, c1, c3, 0);
        cu.yf(i1, 36, i1 + c1, 36 + c3);
        char c5 = '\300';
        int k1 = ((bw.ir - 6040) * 3 * c5) / 2048;
        int i3 = ((bw.jr - 6040) * 3 * c5) / 2048;
        int k4 = j.nm[1024 - rv * 4 & 0x3ff];
        int i5 = j.nm[(1024 - rv * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        cu.vf((i1 + c1 / 2) - k1, 36 + c3 / 2 + i3, lu - 1, rv + 64 & 0xff, c5);
        for(int i7 = 0; i7 < vw; i7++)
        {
            int l1 = (((xw[i7] * fu + 64) - bw.ir) * 3 * c5) / 2048;
            int j3 = (((yw[i7] * fu + 64) - bw.jr) * 3 * c5) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            dn(i1 + c1 / 2 + l1, (36 + c3 / 2) - j3, 65535);
        }

        for(int j7 = 0; j7 < ow; j7++)
        {
            int i2 = (((qw[j7] * fu + 64) - bw.ir) * 3 * c5) / 2048;
            int k3 = (((rw[j7] * fu + 64) - bw.jr) * 3 * c5) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            dn(i1 + c1 / 2 + i2, (36 + c3 / 2) - k3, 0xff0000);
        }

        for(int k7 = 0; k7 < hw; k7++)
        {
            l l7 = kw[k7];
            int j2 = ((l7.ir - bw.ir) * 3 * c5) / 2048;
            int l3 = ((l7.jr - bw.jr) * 3 * c5) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            dn(i1 + c1 / 2 + j2, (36 + c3 / 2) - l3, 0xffff00);
        }

        for(int i8 = 0; i8 < vv; i8++)
        {
            l l8 = zv[i8];
            int k2 = ((l8.ir - bw.ir) * 3 * c5) / 2048;
            int i4 = ((l8.jr - bw.jr) * 3 * c5) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int k8 = 0xffffff;
            for(int i9 = 0; i9 < super.cd; i9++)
            {
                if(l8.er != super.dd[i9] || super.ed[i9] != 10)
                    continue;
                k8 = 65280;
                break;
            }

            dn(i1 + c1 / 2 + k2, (36 + c3 / 2) - i4, k8);
        }

        cu.fg(i1 + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        cu.vf(i1 + 19, 55, lu + 24, rv + 128 & 0xff, 128);
        cu.yf(0, 0, hu, iu + 12);
        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 199);
        int j8 = super.tq - 36;
        if(i1 >= 40 && j8 >= 0 && i1 < 196 && j8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            char c6 = '\300';
            int j1 = ((i) (cu)).xj - 199;
            j1 += 40;
            int l2 = ((super.sq - (j1 + c2 / 2)) * 16384) / (3 * c6);
            int j4 = ((super.tq - (36 + c4 / 2)) * 16384) / (3 * c6);
            int l4 = j.nm[1024 - rv * 4 & 0x3ff];
            int j5 = j.nm[(1024 - rv * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += bw.ir;
            j4 = bw.jr - j4;
            if(ot == 1)
                ll(cw, dw, l2 / 128, j4 / 128, false);
            ot = 0;
        }
    }

    public void yl(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 199;
        int j1 = 36;
        cu.eh(i1 - 49, 3, lu + 3);
        char c1 = '\304';
        char c2 = '\372';
        int l1;
        int k1 = l1 = jagex.client.i.qg(160, 160, 160);
        if(ly == 0)
            k1 = jagex.client.i.qg(220, 220, 220);
        else
            l1 = jagex.client.i.qg(220, 220, 220);
        cu.ag(i1, j1, c1 / 2, 24, k1, 128);
        cu.ag(i1 + c1 / 2, j1, c1 / 2, 24, l1, 128);
        cu.ag(i1, j1 + 24, c1, c2 - 24, jagex.client.i.qg(220, 220, 220), 128);
        cu.xg(i1, j1 + 24, c1, 0);
        cu.ch(i1 + c1 / 2, j1, 24, 0);
        cu.ah("Stats", i1 + c1 / 4, j1 + 16, 4, 0);
        cu.ah("Quests", i1 + c1 / 4 + c1 / 2, j1 + 16, 4, 0);
        if(ly == 0)
        {
            int i2 = 72;
            int k2 = -1;
            cu.tf("Skills", i1 + 5, i2, 3, 0xffff00);
            i2 += 13;
            for(int l2 = 0; l2 < 8; l2++)
            {
                int i3 = 0xffffff;
                if(super.sq > i1 + 3 && super.tq >= i2 - 11 && super.tq < i2 + 2 && super.sq < i1 + 90)
                {
                    i3 = 0xff0000;
                    k2 = l2;
                }
                cu.tf(zx[l2] + ":@yel@" + ux[l2] + "/" + vx[l2], i1 + 5, i2, 1, i3);
                i3 = 0xffffff;
                if(super.sq >= i1 + 90 && super.tq >= i2 - 13 - 11 && super.tq < (i2 - 13) + 2 && super.sq < i1 + 196)
                {
                    i3 = 0xff0000;
                    k2 = l2 + 8;
                }
                cu.tf(zx[l2 + 8] + ":@yel@" + ux[l2 + 8] + "/" + vx[l2 + 8], (i1 + c1 / 2) - 8, i2 - 13, 1, i3);
                i2 += 13;
            }

            cu.tf("Quest Points:@yel@" + yx, (i1 + c1 / 2) - 8, i2 - 13, 1, 0xffffff);
            i2 += 8;
            cu.tf("Equipment Status", i1 + 5, i2, 3, 0xffff00);
            i2 += 12;
            for(int j3 = 0; j3 < 3; j3++)
            {
                cu.tf(ay[j3] + ":@yel@" + xx[j3], i1 + 5, i2, 1, 0xffffff);
                if(j3 < 2)
                    cu.tf(ay[j3 + 3] + ":@yel@" + xx[j3 + 3], i1 + c1 / 2 + 25, i2, 1, 0xffffff);
                i2 += 13;
            }

            i2 += 6;
            cu.xg(i1, i2 - 15, c1, 0);
            if(k2 != -1)
            {
                cu.tf(zx[k2] + " skill", i1 + 5, i2, 1, 0xffff00);
                i2 += 12;
                int k3 = tx[0];
                for(int i4 = 0; i4 < 98; i4++)
                    if(wx[k2] >= tx[i4])
                        k3 = tx[i4 + 1];

                cu.tf("Total xp: " + wx[k2] / 4, i1 + 5, i2, 1, 0xffffff);
                i2 += 12;
                cu.tf("Next level at: " + k3 / 4, i1 + 5, i2, 1, 0xffffff);
            } else
            {
                cu.tf("Overall levels", i1 + 5, i2, 1, 0xffff00);
                i2 += 12;
                int l3 = 0;
                for(int j4 = 0; j4 < 16; j4++)
                    l3 += vx[j4];

                cu.tf("Skill total: " + l3, i1 + 5, i2, 1, 0xffffff);
                i2 += 12;
                cu.tf("Combat level: " + bw.bs, i1 + 5, i2, 1, 0xffffff);
                i2 += 12;
            }
        }
        if(ly == 1)
        {
            jy.tc(ky);
            jy.kd(ky, 0, "@whi@Quest-list (green=completed)");
            for(int j2 = 0; j2 < my; j2++)
                jy.kd(ky, j2 + 1, (oy[j2] ? "@gre@" : "@red@") + ny[j2]);

            jy.oc();
        }
        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 199);
        j1 = super.tq - 36;
        if(i1 >= 0 && j1 >= 0 && i1 < c1 && j1 < c2)
        {
            if(ly == 1)
                jy.wd(i1 + (((i) (cu)).xj - 199), j1 + 36, super.vq, super.uq);
            if(j1 <= 24 && ot == 1)
            {
                if(i1 < 98)
                {
                    ly = 0;
                    return;
                }
                if(i1 > 98)
                    ly = 1;
            }
        }
    }

    public void cn(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 199;
        int j1 = 36;
        cu.eh(i1 - 49, 3, lu + 4);
        char c1 = '\304';
        char c2 = '\266';
        int l1;
        int k1 = l1 = jagex.client.i.qg(160, 160, 160);
        if(dy == 0)
            k1 = jagex.client.i.qg(220, 220, 220);
        else
            l1 = jagex.client.i.qg(220, 220, 220);
        cu.ag(i1, j1, c1 / 2, 24, k1, 128);
        cu.ag(i1 + c1 / 2, j1, c1 / 2, 24, l1, 128);
        cu.ag(i1, j1 + 24, c1, 90, jagex.client.i.qg(220, 220, 220), 128);
        cu.ag(i1, j1 + 24 + 90, c1, c2 - 90 - 24, jagex.client.i.qg(160, 160, 160), 128);
        cu.xg(i1, j1 + 24, c1, 0);
        cu.ch(i1 + c1 / 2, j1, 24, 0);
        cu.xg(i1, j1 + 113, c1, 0);
        cu.ah("Magic", i1 + c1 / 4, j1 + 16, 4, 0);
        cu.ah("Prayers", i1 + c1 / 4 + c1 / 2, j1 + 16, 4, 0);
        if(dy == 0)
        {
            by.tc(cy);
            int i2 = 0;
            for(int i3 = 0; i3 < r.vlb; i3++)
            {
                String s1 = "@yel@";
                for(int l4 = 0; l4 < r.zlb[i3]; l4++)
                {
                    int k5 = r.bmb[i3][l4];
                    if(sm(k5, r.cmb[i3][l4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int l5 = ux[6];
                if(r.ylb[i3] > l5)
                    s1 = "@bla@";
                by.kd(cy, i2++, s1 + "Level " + r.ylb[i3] + ": " + r.wlb[i3]);
            }

            by.oc();
            int i4 = by.pc(cy);
            if(i4 != -1)
            {
                cu.tf("Level " + r.ylb[i4] + ": " + r.wlb[i4], i1 + 2, j1 + 124, 1, 0xffff00);
                cu.tf(r.xlb[i4], i1 + 2, j1 + 136, 0, 0xffffff);
                for(int i5 = 0; i5 < r.zlb[i4]; i5++)
                {
                    int i6 = r.bmb[i4][i5];
                    cu.eh(i1 + 2 + i5 * 44, j1 + 150, pw + r.eib[i6]);
                    int j6 = ol(i6);
                    int k6 = r.cmb[i4][i5];
                    String s3 = "@red@";
                    if(sm(i6, k6))
                        s3 = "@gre@";
                    cu.tf(s3 + j6 + "/" + k6, i1 + 2 + i5 * 44, j1 + 150, 1, 0xffffff);
                }

            } else
            {
                cu.tf("Point at a spell for a description", i1 + 2, j1 + 124, 1, 0);
            }
        }
        if(dy == 1)
        {
            by.tc(cy);
            int j2 = 0;
            for(int j3 = 0; j3 < r.nmb; j3++)
            {
                String s2 = "@whi@";
                if(r.qmb[j3] > vx[5])
                    s2 = "@bla@";
                if(py[j3])
                    s2 = "@gre@";
                by.kd(cy, j2++, s2 + "Level " + r.qmb[j3] + ": " + r.omb[j3]);
            }

            by.oc();
            int j4 = by.pc(cy);
            if(j4 != -1)
            {
                cu.ah("Level " + r.qmb[j4] + ": " + r.omb[j4], i1 + c1 / 2, j1 + 130, 1, 0xffff00);
                cu.ah(r.pmb[j4], i1 + c1 / 2, j1 + 145, 0, 0xffffff);
                cu.ah("Drain rate: " + r.rmb[j4], i1 + c1 / 2, j1 + 160, 1, 0);
            } else
            {
                cu.tf("Point at a prayer for a description", i1 + 2, j1 + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 199);
        j1 = super.tq - 36;
        if(i1 >= 0 && j1 >= 0 && i1 < 196 && j1 < 182)
        {
            by.wd(i1 + (((i) (cu)).xj - 199), j1 + 36, super.vq, super.uq);
            if(j1 <= 24 && ot == 1)
                if(i1 < 98 && dy == 1)
                {
                    dy = 0;
                    by.gd(cy);
                } else
                if(i1 > 98 && dy == 0)
                {
                    dy = 1;
                    by.gd(cy);
                }
            if(ot == 1 && dy == 0)
            {
                int k2 = by.pc(cy);
                if(k2 != -1)
                {
                    int k3 = ux[6];
                    if(r.ylb[k2] > k3)
                    {
                        tk("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k4;
                        for(k4 = 0; k4 < r.zlb[k2]; k4++)
                        {
                            int j5 = r.bmb[k2][k4];
                            if(sm(j5, r.cmb[k2][k4]))
                                continue;
                            tk("You don't have all the reagents you need for this spell", 3);
                            k4 = -1;
                            break;
                        }

                        if(k4 == r.zlb[k2])
                        {
                            ey = k2;
                            rx = -1;
                        }
                    }
                }
            }
            if(ot == 1 && dy == 1)
            {
                int l2 = by.pc(cy);
                if(l2 != -1)
                {
                    int l3 = vx[5];
                    if(r.qmb[l2] > l3)
                        tk("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(ux[5] == 0)
                        tk("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(py[l2])
                    {
                        super.yc.kb(211);
                        super.yc.dc(l2);
                        super.yc.ib();
                        py[l2] = false;
                    } else
                    {
                        super.yc.kb(212);
                        super.yc.dc(l2);
                        super.yc.ib();
                        py[l2] = true;
                    }
                }
            }
            ot = 0;
        }
    }

    public void xk(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 199;
        int j1 = 36;
        cu.eh(i1 - 49, 3, lu + 5);
        char c1 = '\304';
        char c2 = '\266';
        int l1;
        int k1 = l1 = jagex.client.i.qg(160, 160, 160);
        if(hy == 0)
            k1 = jagex.client.i.qg(220, 220, 220);
        else
            l1 = jagex.client.i.qg(220, 220, 220);
        cu.ag(i1, j1, c1 / 2, 24, k1, 128);
        cu.ag(i1 + c1 / 2, j1, c1 / 2, 24, l1, 128);
        cu.ag(i1, j1 + 24, c1, c2 - 24, jagex.client.i.qg(220, 220, 220), 128);
        cu.xg(i1, j1 + 24, c1, 0);
        cu.ch(i1 + c1 / 2, j1, 24, 0);
        cu.xg(i1, (j1 + c2) - 16, c1, 0);
        cu.ah("Friends", i1 + c1 / 4, j1 + 16, 4, 0);
        cu.ah("Ignore", i1 + c1 / 4 + c1 / 2, j1 + 16, 4, 0);
        fy.tc(gy);
        if(hy == 0)
        {
            for(int i2 = 0; i2 < super.cd; i2++)
            {
                String s1;
                if(super.ed[i2] == 10)
                    s1 = "@gre@";
                else
                if(super.ed[i2] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                fy.kd(gy, i2, s1 + o.xn(super.dd[i2]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(hy == 1)
        {
            for(int j2 = 0; j2 < super.fd; j2++)
                fy.kd(gy, j2, "@yel@" + o.xn(super.gd[j2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        fy.oc();
        if(hy == 0)
        {
            int k2 = fy.pc(gy);
            if(k2 >= 0 && super.sq < 489)
            {
                if(super.sq > 429)
                    cu.ah("Click to remove " + o.xn(super.dd[k2]), i1 + c1 / 2, j1 + 35, 1, 0xffffff);
                else
                if(super.ed[k2] == 10)
                    cu.ah("Click to message " + o.xn(super.dd[k2]), i1 + c1 / 2, j1 + 35, 1, 0xffffff);
                else
                if(super.ed[k2] > 0)
                    cu.ah(o.xn(super.dd[k2]) + " is on world " + super.ed[k2], i1 + c1 / 2, j1 + 35, 1, 0xffffff);
                else
                    cu.ah(o.xn(super.dd[k2]) + " is offline", i1 + c1 / 2, j1 + 35, 1, 0xffffff);
            } else
            {
                cu.ah("Click a name to send a message", i1 + c1 / 2, j1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.sq > i1 && super.sq < i1 + c1 && super.tq > (j1 + c2) - 16 && super.tq < j1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            cu.ah("Click here to add a friend", i1 + c1 / 2, (j1 + c2) - 3, 1, k3);
        }
        if(hy == 1)
        {
            int l2 = fy.pc(gy);
            if(l2 >= 0 && super.sq < 489 && super.sq > 429)
            {
                if(super.sq > 429)
                    cu.ah("Click to remove " + o.xn(super.gd[l2]), i1 + c1 / 2, j1 + 35, 1, 0xffffff);
            } else
            {
                cu.ah("Blocking messages from:", i1 + c1 / 2, j1 + 35, 1, 0xffffff);
            }
            int l3;
            if(super.sq > i1 && super.sq < i1 + c1 && super.tq > (j1 + c2) - 16 && super.tq < j1 + c2)
                l3 = 0xffff00;
            else
                l3 = 0xffffff;
            cu.ah("Click here to add a name", i1 + c1 / 2, (j1 + c2) - 3, 1, l3);
        }
        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 199);
        j1 = super.tq - 36;
        if(i1 >= 0 && j1 >= 0 && i1 < 196 && j1 < 182)
        {
            fy.wd(i1 + (((i) (cu)).xj - 199), j1 + 36, super.vq, super.uq);
            if(j1 <= 24 && ot == 1)
                if(i1 < 98 && hy == 1)
                {
                    hy = 0;
                    fy.gd(gy);
                } else
                if(i1 > 98 && hy == 0)
                {
                    hy = 1;
                    fy.gd(gy);
                }
            if(ot == 1 && hy == 0)
            {
                int i3 = fy.pc(gy);
                if(i3 >= 0 && super.sq < 489)
                    if(super.sq > 429)
                        l(super.dd[i3]);
                    else
                    if(super.ed[i3] != 0)
                    {
                        kbb = 2;
                        iy = super.dd[i3];
                        super.br = "";
                        super.cr = "";
                    }
            }
            if(ot == 1 && hy == 1)
            {
                int j3 = fy.pc(gy);
                if(j3 >= 0 && super.sq < 489 && super.sq > 429)
                    r(super.gd[j3]);
            }
            if(j1 > 166 && ot == 1 && hy == 0)
            {
                kbb = 1;
                super.zq = "";
                super.ar = "";
            }
            if(j1 > 166 && ot == 1 && hy == 1)
            {
                kbb = 3;
                super.zq = "";
                super.ar = "";
            }
            ot = 0;
        }
    }

    public void an(boolean flag)
    {
        int i1 = ((i) (cu)).xj - 199;
        int j1 = 36;
        cu.eh(i1 - 49, 3, lu + 6);
        char c1 = '\304';
        cu.ag(i1, 36, c1, 75, jagex.client.i.qg(181, 181, 181), 160);
        cu.ag(i1, 111, c1, 105, jagex.client.i.qg(201, 2011, 201), 160);
        cu.ag(i1, 216, c1, 30, jagex.client.i.qg(181, 181, 181), 160);
        int k1 = i1 + 3;
        int i2 = j1 + 15;
        cu.tf("Game options - click to toggle", k1, i2, 1, 0);
        i2 += 15;
        if(ry)
            cu.tf("Camera angle mode - @gre@Auto", k1, i2, 1, 0xffffff);
        else
            cu.tf("Camera angle mode - @red@Manual", k1, i2, 1, 0xffffff);
        i2 += 15;
        if(zy)
            cu.tf("Mouse buttons - @red@One", k1, i2, 1, 0xffffff);
        else
            cu.tf("Mouse buttons - @gre@Two", k1, i2, 1, 0xffffff);
        i2 += 15;
        int k2 = 0xffffff;
        if(super.sq > k1 && super.sq < k1 + c1 && super.tq > i2 - 12 && super.tq < i2 + 4)
            k2 = 0xffff00;
        cu.tf("Change password", k1, i2, 1, k2);
        i2 += 15;
        i2 += 15;
        cu.tf("Privacy settings. Will be applied to", i1 + 3, i2, 1, 0);
        i2 += 15;
        cu.tf("all people not on your friends list", i1 + 3, i2, 1, 0);
        i2 += 15;
        if(super.hd == 0)
            cu.tf("Hide online-status: @red@<off>", i1 + 3, i2, 1, 0xffffff);
        else
            cu.tf("Hide online-status: @gre@<on>", i1 + 3, i2, 1, 0xffffff);
        i2 += 15;
        if(super.id == 0)
            cu.tf("Block chat messages: @red@<off>", i1 + 3, i2, 1, 0xffffff);
        else
            cu.tf("Block chat messages: @gre@<on>", i1 + 3, i2, 1, 0xffffff);
        i2 += 15;
        if(super.jd == 0)
            cu.tf("Block private messages: @red@<off>", i1 + 3, i2, 1, 0xffffff);
        else
            cu.tf("Block private messages: @gre@<on>", i1 + 3, i2, 1, 0xffffff);
        i2 += 15;
        if(super.kd == 0)
            cu.tf("Block trade requests: @red@<off>", i1 + 3, i2, 1, 0xffffff);
        else
            cu.tf("Block trade requests: @gre@<on>", i1 + 3, i2, 1, 0xffffff);
        i2 += 15;
        i2 += 15;
        k2 = 0xffffff;
        if(super.sq > k1 && super.sq < k1 + c1 && super.tq > i2 - 12 && super.tq < i2 + 4)
            k2 = 0xffff00;
        cu.tf("Click here to logout", i1 + 3, i2, 1, k2);
        if(!flag)
            return;
        i1 = super.sq - (((i) (cu)).xj - 199);
        j1 = super.tq - 36;
        if(i1 >= 0 && j1 >= 0 && i1 < 196 && j1 < 231)
        {
            int l2 = ((i) (cu)).xj - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int l1 = l2 + 3;
            int j2 = byte0 + 30;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                ry = !ry;
                super.yc.kb(213);
                super.yc.dc(0);
                super.yc.dc(ry ? 1 : 0);
                super.yc.ib();
            }
            j2 += 15;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                zy = !zy;
                super.yc.kb(213);
                super.yc.dc(2);
                super.yc.dc(zy ? 1 : 0);
                super.yc.ib();
            }
            j2 += 15;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                lbb = 6;
                super.zq = "";
                super.ar = "";
            }
            boolean flag1 = false;
            j2 += 60;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                super.hd = 1 - super.hd;
                flag1 = true;
            }
            j2 += 15;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                super.id = 1 - super.id;
                flag1 = true;
            }
            j2 += 15;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                super.jd = 1 - super.jd;
                flag1 = true;
            }
            j2 += 15;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
            {
                super.kd = 1 - super.kd;
                flag1 = true;
            }
            if(flag1)
                fb(super.hd, super.id, super.jd, super.kd, 0);
            j2 += 30;
            if(super.sq > l1 && super.sq < l1 + c2 && super.tq > j2 - 12 && super.tq < j2 + 4 && ot == 1)
                trylogout();
            ot = 0;
        }
    }

    public void ml()
    {
        int i1 = -1;
        for(int j1 = 0; j1 < vw; j1++)
            cx[j1] = false;

        for(int k1 = 0; k1 < ex; k1++)
            kx[k1] = false;

        int l1 = bu.yi();
        h ah[] = bu.vh();
        int ai[] = bu.ti();
        for(int i2 = 0; i2 < l1; i2++)
        {
            int j2 = ai[i2];
            h h1 = ah[i2];
            if(h1.uh[j2] <= 65535 || h1.uh[j2] >= 0x30d40 && h1.uh[j2] <= 0x493e0)
                if(h1 == bu.bo)
                {
                    int l2 = h1.uh[j2] % 10000;
                    int k3 = h1.uh[j2] / 10000;
                    if(k3 == 1)
                    {
                        String s1 = "";
                        int j4 = 0;
                        if(bw.bs > 0 && zv[l2].bs > 0)
                            j4 = bw.bs - zv[l2].bs;
                        if(j4 < 0)
                            s1 = "@or1@";
                        if(j4 < -3)
                            s1 = "@or2@";
                        if(j4 < -6)
                            s1 = "@or3@";
                        if(j4 < -9)
                            s1 = "@red@";
                        if(j4 > 0)
                            s1 = "@gr1@";
                        if(j4 > 3)
                            s1 = "@gr2@";
                        if(j4 > 6)
                            s1 = "@gr3@";
                        if(j4 > 9)
                            s1 = "@gre@";
                        s1 = " " + s1 + "(level-" + zv[l2].bs + ")";
                        if(ey >= 0)
                        {
                            if(r.amb[ey] == 1 || r.amb[ey] == 2 && dw < 2203)
                            {
                                bz[xy] = "Cast " + r.wlb[ey] + " on";
                                az[xy] = "@whi@" + zv[l2].fr;
                                cz[xy] = 800;
                                dz[xy] = zv[l2].ir;
                                ez[xy] = zv[l2].jr;
                                fz[xy] = zv[l2].gr;
                                gz[xy] = ey;
                                xy++;
                            }
                        } else
                        if(rx >= 0)
                        {
                            bz[xy] = "Use " + sx + " with";
                            az[xy] = "@whi@" + zv[l2].fr;
                            cz[xy] = 810;
                            dz[xy] = zv[l2].ir;
                            ez[xy] = zv[l2].jr;
                            fz[xy] = zv[l2].gr;
                            gz[xy] = rx;
                            xy++;
                        } else
                        {
                            if(dw + yu + cv < 2203 && (zv[l2].jr - 64) / fu + yu + cv < 2203)
                            {
                                bz[xy] = "Attack";
                                az[xy] = "@whi@" + zv[l2].fr + s1;
                                if(j4 >= 0 && j4 < 5)
                                    cz[xy] = 805;
                                else
                                    cz[xy] = 2805;
                                dz[xy] = zv[l2].ir;
                                ez[xy] = zv[l2].jr;
                                fz[xy] = zv[l2].gr;
                                xy++;
                            }
                            bz[xy] = "Trade with";
                            az[xy] = "@whi@" + zv[l2].fr;
                            cz[xy] = 2810;
                            fz[xy] = zv[l2].gr;
                            xy++;
                            bz[xy] = "Follow";
                            az[xy] = "@whi@" + zv[l2].fr;
                            cz[xy] = 2820;
                            fz[xy] = zv[l2].gr;
                            xy++;
                        }
                    } else
                    if(k3 == 2)
                    {
                        if(ey >= 0)
                        {
                            if(r.amb[ey] == 3)
                            {
                                bz[xy] = "Cast " + r.wlb[ey] + " on";
                                az[xy] = "@lre@" + r.aib[sw[l2]][0];
                                cz[xy] = 200;
                                dz[xy] = qw[l2];
                                ez[xy] = rw[l2];
                                fz[xy] = sw[l2];
                                gz[xy] = ey;
                                xy++;
                            }
                        } else
                        if(rx >= 0)
                        {
                            bz[xy] = "Use " + sx + " with";
                            az[xy] = "@lre@" + r.aib[sw[l2]][0];
                            cz[xy] = 210;
                            dz[xy] = qw[l2];
                            ez[xy] = rw[l2];
                            fz[xy] = sw[l2];
                            gz[xy] = rx;
                            xy++;
                        } else
                        {
                            bz[xy] = "Take";
                            az[xy] = "@lre@" + r.aib[sw[l2]][0];
                            cz[xy] = 220;
                            dz[xy] = qw[l2];
                            ez[xy] = rw[l2];
                            fz[xy] = sw[l2];
                            xy++;
                            bz[xy] = "Examine";
                            az[xy] = "@lre@" + r.aib[sw[l2]][0];
                            cz[xy] = 3200;
                            fz[xy] = sw[l2];
                            xy++;
                        }
                    } else
                    if(k3 == 3)
                    {
                        String s2 = "";
                        int k4 = -1;
                        int l4 = kw[l2].kr;
                        if(r.ajb[l4] > 0)
                        {
                            int i5 = (r.wib[l4] + r.zib[l4] + r.xib[l4] + r.yib[l4]) / 4;
                            int j5 = (vx[0] + vx[1] + vx[2] + vx[3] + 27) / 4;
                            k4 = j5 - i5;
                            s2 = "@yel@";
                            if(k4 < 0)
                                s2 = "@or1@";
                            if(k4 < -3)
                                s2 = "@or2@";
                            if(k4 < -6)
                                s2 = "@or3@";
                            if(k4 < -9)
                                s2 = "@red@";
                            if(k4 > 0)
                                s2 = "@gr1@";
                            if(k4 > 3)
                                s2 = "@gr2@";
                            if(k4 > 6)
                                s2 = "@gr3@";
                            if(k4 > 9)
                                s2 = "@gre@";
                            s2 = " " + s2 + "(level-" + i5 + ")";
                        }
                        if(ey >= 0)
                        {
                            if(r.amb[ey] == 2)
                            {
                                bz[xy] = "Cast " + r.wlb[ey] + " on";
                                az[xy] = "@yel@" + r.uib[kw[l2].kr][0];
                                cz[xy] = 700;
                                dz[xy] = kw[l2].ir;
                                ez[xy] = kw[l2].jr;
                                fz[xy] = kw[l2].gr;
                                gz[xy] = ey;
                                xy++;
                            }
                        } else
                        if(rx >= 0)
                        {
                            bz[xy] = "Use " + sx + " with";
                            az[xy] = "@yel@" + r.uib[kw[l2].kr][0];
                            cz[xy] = 710;
                            dz[xy] = kw[l2].ir;
                            ez[xy] = kw[l2].jr;
                            fz[xy] = kw[l2].gr;
                            gz[xy] = rx;
                            xy++;
                        } else
                        {
                            if(r.ajb[l4] > 0)
                            {
                                bz[xy] = "Attack";
                                az[xy] = "@yel@" + r.uib[kw[l2].kr][0] + s2;
                                if(k4 >= 0)
                                    cz[xy] = 715;
                                else
                                    cz[xy] = 2715;
                                dz[xy] = kw[l2].ir;
                                ez[xy] = kw[l2].jr;
                                fz[xy] = kw[l2].gr;
                                xy++;
                            }
                            bz[xy] = "Talk-to";
                            az[xy] = "@yel@" + r.uib[kw[l2].kr][0];
                            cz[xy] = 720;
                            dz[xy] = kw[l2].ir;
                            ez[xy] = kw[l2].jr;
                            fz[xy] = kw[l2].gr;
                            xy++;
                            bz[xy] = "Examine";
                            az[xy] = "@yel@" + r.uib[kw[l2].kr][0];
                            cz[xy] = 3700;
                            fz[xy] = kw[l2].kr;
                            xy++;
                        }
                    }
                } else
                if(h1 != null && h1.th >= 10000)
                {
                    int i3 = h1.th - 10000;
                    int l3 = jx[i3];
                    if(!kx[i3])
                    {
                        if(ey >= 0)
                        {
                            if(r.amb[ey] == 4)
                            {
                                bz[xy] = "Cast " + r.wlb[ey] + " on";
                                az[xy] = "@cya@" + r.rkb[l3][0];
                                cz[xy] = 300;
                                dz[xy] = gx[i3];
                                ez[xy] = hx[i3];
                                fz[xy] = ix[i3];
                                gz[xy] = ey;
                                xy++;
                            }
                        } else
                        if(rx >= 0)
                        {
                            bz[xy] = "Use " + sx + " with";
                            az[xy] = "@cya@" + r.rkb[l3][0];
                            cz[xy] = 310;
                            dz[xy] = gx[i3];
                            ez[xy] = hx[i3];
                            fz[xy] = ix[i3];
                            gz[xy] = rx;
                            xy++;
                        } else
                        {
                            if(!r.tkb[l3].equalsIgnoreCase("WalkTo"))
                            {
                                bz[xy] = r.tkb[l3];
                                az[xy] = "@cya@" + r.rkb[l3][0];
                                cz[xy] = 320;
                                dz[xy] = gx[i3];
                                ez[xy] = hx[i3];
                                fz[xy] = ix[i3];
                                xy++;
                            }
                            if(!r.ukb[l3].equalsIgnoreCase("Examine"))
                            {
                                bz[xy] = r.ukb[l3];
                                az[xy] = "@cya@" + r.rkb[l3][0];
                                cz[xy] = 2300;
                                dz[xy] = gx[i3];
                                ez[xy] = hx[i3];
                                fz[xy] = ix[i3];
                                xy++;
                            }
                            bz[xy] = "Examine";
                            az[xy] = "@cya@" + r.rkb[l3][0];
                            cz[xy] = 3300;
                            fz[xy] = l3;
                            xy++;
                        }
                        kx[i3] = true;
                    }
                } else
                if(h1 != null && h1.th >= 0)
                {
                    int j3 = h1.th;
                    int i4 = zw[j3];
                    if(!cx[j3])
                    {
                        if(ey >= 0)
                        {
                            if(r.amb[ey] == 5)
                            {
                                bz[xy] = "Cast " + r.wlb[ey] + " on";
                                az[xy] = "@cya@" + r.gkb[i4][0];
                                cz[xy] = 400;
                                dz[xy] = xw[j3];
                                ez[xy] = yw[j3];
                                fz[xy] = ax[j3];
                                gz[xy] = zw[j3];
                                hz[xy] = ey;
                                xy++;
                            }
                        } else
                        if(rx >= 0)
                        {
                            bz[xy] = "Use " + sx + " with";
                            az[xy] = "@cya@" + r.gkb[i4][0];
                            cz[xy] = 410;
                            dz[xy] = xw[j3];
                            ez[xy] = yw[j3];
                            fz[xy] = ax[j3];
                            gz[xy] = zw[j3];
                            hz[xy] = rx;
                            xy++;
                        } else
                        {
                            if(!r.ikb[i4].equalsIgnoreCase("WalkTo"))
                            {
                                bz[xy] = r.ikb[i4];
                                az[xy] = "@cya@" + r.gkb[i4][0];
                                cz[xy] = 420;
                                dz[xy] = xw[j3];
                                ez[xy] = yw[j3];
                                fz[xy] = ax[j3];
                                gz[xy] = zw[j3];
                                xy++;
                            }
                            if(!r.jkb[i4].equalsIgnoreCase("Examine"))
                            {
                                bz[xy] = r.jkb[i4];
                                az[xy] = "@cya@" + r.gkb[i4][0];
                                cz[xy] = 2400;
                                dz[xy] = xw[j3];
                                ez[xy] = yw[j3];
                                fz[xy] = ax[j3];
                                gz[xy] = zw[j3];
                                xy++;
                            }
                            bz[xy] = "Examine";
                            az[xy] = "@cya@" + r.gkb[i4][0];
                            cz[xy] = 3400;
                            fz[xy] = i4;
                            xy++;
                        }
                        cx[j3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = h1.uh[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(ey >= 0 && r.amb[ey] <= 1)
        {
            bz[xy] = "Cast " + r.wlb[ey] + " on self";
            az[xy] = "";
            cz[xy] = 1000;
            fz[xy] = ey;
            xy++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(ey >= 0)
            {
                if(r.amb[ey] == 6)
                {
                    bz[xy] = "Cast " + r.wlb[ey] + " on ground";
                    az[xy] = "";
                    cz[xy] = 900;
                    dz[xy] = wu.wgb[k2];
                    ez[xy] = wu.xgb[k2];
                    fz[xy] = ey;
                    xy++;
                    return;
                }
            } else
            if(rx < 0)
            {
                bz[xy] = "Walk here";
                az[xy] = "";
                cz[xy] = 920;
                dz[xy] = wu.wgb[k2];
                ez[xy] = wu.xgb[k2];
                xy++;
            }
        }
    }

    public void um()
    {
        if(ot != 0)
        {
            for(int i1 = 0; i1 < xy; i1++)
            {
                int k1 = ty + 2;
                int i2 = uy + 27 + i1 * 15;
                if(super.sq <= k1 - 2 || super.tq <= i2 - 12 || super.tq >= i2 + 4 || super.sq >= (k1 - 3) + vy)
                    continue;
                jm(iz[i1]);
                break;
            }

            ot = 0;
            sy = false;
            return;
        }
        if(super.sq < ty - 10 || super.tq < uy - 10 || super.sq > ty + vy + 10 || super.tq > uy + wy + 10)
        {
            sy = false;
            return;
        }
        cu.ag(ty, uy, vy, wy, 0xd0d0d0, 160);
        cu.tf("Choose option", ty + 2, uy + 12, 1, 65535);
        for(int j1 = 0; j1 < xy; j1++)
        {
            int l1 = ty + 2;
            int j2 = uy + 27 + j1 * 15;
            int k2 = 0xffffff;
            if(super.sq > l1 - 2 && super.tq > j2 - 12 && super.tq < j2 + 4 && super.sq < (l1 - 3) + vy)
                k2 = 0xffff00;
            cu.tf(bz[iz[j1]] + " " + az[iz[j1]], l1, j2, 1, k2);
        }

    }

    public void kl()
    {
        if(ey >= 0 || rx >= 0)
        {
            bz[xy] = "Cancel";
            az[xy] = "";
            cz[xy] = 4000;
            xy++;
        }
        for(int i1 = 0; i1 < xy; i1++)
            iz[i1] = i1;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j1 = 0; j1 < xy - 1; j1++)
            {
                int l1 = iz[j1];
                int j2 = iz[j1 + 1];
                if(cz[l1] > cz[j2])
                {
                    iz[j1] = j2;
                    iz[j1 + 1] = l1;
                    flag = false;
                }
            }

        }

        if(xy > 20)
            xy = 20;
        if(xy > 0)
        {
            int k1 = -1;
            for(int i2 = 0; i2 < xy; i2++)
            {
                if(az[iz[i2]] == null || az[iz[i2]].length() <= 0)
                    continue;
                k1 = i2;
                break;
            }

            String s1 = null;
            if((rx >= 0 || ey >= 0) && xy == 1)
                s1 = "Choose a target";
            else
            if((rx >= 0 || ey >= 0) && xy > 1)
                s1 = "@whi@" + bz[iz[0]] + " " + az[iz[0]];
            else
            if(k1 != -1)
                s1 = az[iz[k1]] + ": @whi@" + bz[iz[0]];
            if(xy == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(xy > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (xy - 1) + " more options";
            if(s1 != null)
                cu.tf(s1, 6, 14, 1, 0xffff00);
            if(!zy && ot == 1 || zy && ot == 1 && xy == 1)
            {
                jm(iz[0]);
                ot = 0;
                return;
            }
            if(!zy && ot == 2 || zy && ot == 1)
            {
                wy = (xy + 1) * 15;
                vy = cu.kf("Choose option", 1) + 5;
                for(int k2 = 0; k2 < xy; k2++)
                {
                    int l2 = cu.kf(bz[k2] + " " + az[k2], 1) + 5;
                    if(l2 > vy)
                        vy = l2;
                }

                ty = super.sq - vy / 2;
                uy = super.tq - 7;
                sy = true;
                if(ty < 0)
                    ty = 0;
                if(uy < 0)
                    uy = 0;
                if(ty + vy > 510)
                    ty = 510 - vy;
                if(uy + wy > 315)
                    uy = 315 - wy;
                ot = 0;
            }
        }
    }

    public void jm(int i1)
    {
        int j1 = dz[i1];
        int k1 = ez[i1];
        int l1 = fz[i1];
        int i2 = gz[i1];
        int j2 = hz[i1];
        int k2 = cz[i1];
        if(k2 == 200)
        {
            pm(cw, dw, j1, k1, true);
            super.yc.kb(224);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            ey = -1;
        }
        if(k2 == 210)
        {
            pm(cw, dw, j1, k1, true);
            super.yc.kb(250);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            rx = -1;
        }
        if(k2 == 220)
        {
            pm(cw, dw, j1, k1, true);
            super.yc.kb(252);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 3200)
            tk(r.bib[l1], 3);
        if(k2 == 300)
        {
            il(j1, k1, l1);
            super.yc.kb(223);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.dc(l1);
            super.yc.cc(i2);
            wk();
            ey = -1;
        }
        if(k2 == 310)
        {
            il(j1, k1, l1);
            super.yc.kb(239);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.dc(l1);
            super.yc.cc(i2);
            wk();
            rx = -1;
        }
        if(k2 == 320)
        {
            il(j1, k1, l1);
            super.yc.kb(238);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.dc(l1);
            wk();
        }
        if(k2 == 2300)
        {
            il(j1, k1, l1);
            super.yc.kb(229);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.dc(l1);
            wk();
        }
        if(k2 == 3300)
            tk(r.skb[l1], 3);
        if(k2 == 400)
        {
            vk(j1, k1, l1, i2);
            super.yc.kb(222);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(j2);
            wk();
            ey = -1;
        }
        if(k2 == 410)
        {
            vk(j1, k1, l1, i2);
            super.yc.kb(241);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(j2);
            wk();
            rx = -1;
        }
        if(k2 == 420)
        {
            vk(j1, k1, l1, i2);
            super.yc.kb(242);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            wk();
        }
        if(k2 == 2400)
        {
            vk(j1, k1, l1, i2);
            super.yc.kb(230);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            wk();
        }
        if(k2 == 3400)
            tk(r.hkb[l1], 3);
        if(k2 == 600)
        {
            super.yc.kb(220);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            ey = -1;
        }
        if(k2 == 610)
        {
            super.yc.kb(240);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            rx = -1;
        }
        if(k2 == 620)
        {
            super.yc.kb(248);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 630)
        {
            super.yc.kb(249);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 640)
        {
            super.yc.kb(246);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 650)
        {
            rx = l1;
            lx = 0;
            sx = r.aib[ox[rx]][0];
        }
        if(k2 == 660)
        {
            super.yc.kb(251);
            super.yc.cc(l1);
            wk();
            rx = -1;
            lx = 0;
            tk("Dropping " + r.aib[ox[l1]][0], 4);
        }
        if(k2 == 3600)
            tk(r.bib[l1], 3);
        if(k2 == 700)
        {
            int l2 = (j1 - 64) / fu;
            int k4 = (k1 - 64) / fu;
            ll(cw, dw, l2, k4, true);
            super.yc.kb(225);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            ey = -1;
        }
        if(k2 == 710)
        {
            int i3 = (j1 - 64) / fu;
            int l4 = (k1 - 64) / fu;
            ll(cw, dw, i3, l4, true);
            super.yc.kb(243);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            rx = -1;
        }
        if(k2 == 720)
        {
            int j3 = (j1 - 64) / fu;
            int i5 = (k1 - 64) / fu;
            ll(cw, dw, j3, i5, true);
            super.yc.kb(245);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 715 || k2 == 2715)
        {
            int k3 = (j1 - 64) / fu;
            int j5 = (k1 - 64) / fu;
            ll(cw, dw, k3, j5, true);
            super.yc.kb(244);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 3700)
            tk(r.vib[l1], 3);
        if(k2 == 800)
        {
            int l3 = (j1 - 64) / fu;
            int k5 = (k1 - 64) / fu;
            ll(cw, dw, l3, k5, true);
            super.yc.kb(226);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            ey = -1;
        }
        if(k2 == 810)
        {
            int i4 = (j1 - 64) / fu;
            int l5 = (k1 - 64) / fu;
            ll(cw, dw, i4, l5, true);
            super.yc.kb(219);
            super.yc.cc(l1);
            super.yc.cc(i2);
            wk();
            rx = -1;
        }
        if(k2 == 805 || k2 == 2805)
        {
            int j4 = (j1 - 64) / fu;
            int i6 = (k1 - 64) / fu;
            ll(cw, dw, j4, i6, true);
            super.yc.kb(228);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 2806)
        {
            super.yc.kb(204);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 2810)
        {
            super.yc.kb(235);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 2820)
        {
            super.yc.kb(214);
            super.yc.cc(l1);
            wk();
        }
        if(k2 == 900)
        {
            ll(cw, dw, j1, k1, true);
            super.yc.kb(221);
            super.yc.cc(j1 + bv);
            super.yc.cc(k1 + cv);
            super.yc.cc(l1);
            wk();
            ey = -1;
        }
        if(k2 == 920)
        {
            ll(cw, dw, j1, k1, false);
            if(tu == -24)
                tu = 24;
        }
        if(k2 == 1000)
        {
            super.yc.kb(227);
            super.yc.cc(l1);
            wk();
            ey = -1;
        }
        if(k2 == 4000)
        {
            rx = -1;
            ey = -1;
        }
    }

    public mudclient()
    {
        et = new BigInteger("18439792161837834709");
        ft = new BigInteger("192956484481579778191558061814292671521");
        gt = false;
        jt = false;
        kt = false;
        lt = true;
        nt = 0xbc614e;
        pt = 8000;
        qt = new int[pt];
        rt = new int[pt];
        tt = new int[8192];
        ut = new int[8192];
        wt = 2;
        yt = 2;
        fu = 128;
        hu = 512;
        iu = 334;
        ju = 9;
        mu = 40;
        ru = -1;
        su = -1;
        av = -1;
        dv = -1;
        lv = 550;
        mv = false;
        pv = 1;
        rv = 128;
        tv = 4000;
        uv = 500;
        yv = new l[tv];
        zv = new l[uv];
        aw = new l[uv];
        bw = new l();
        ew = -1;
        fw = 1500;
        gw = 500;
        jw = new l[fw];
        kw = new l[gw];
        lw = new l[gw];
        mw = new int[500];
        nw = 500;
        qw = new int[nw];
        rw = new int[nw];
        sw = new int[nw];
        tw = new int[nw];
        uw = 1500;
        ww = new h[uw];
        xw = new int[uw];
        yw = new int[uw];
        zw = new int[uw];
        ax = new int[uw];
        bx = new h[200];
        cx = new boolean[uw];
        dx = 500;
        fx = new h[dx];
        gx = new int[dx];
        hx = new int[dx];
        ix = new int[dx];
        jx = new int[dx];
        kx = new boolean[dx];
        mx = 30;
        ox = new int[35];
        px = new int[35];
        qx = new int[35];
        rx = -1;
        sx = "";
        tx = new int[99];
        ux = new int[16];
        vx = new int[16];
        wx = new int[16];
        xx = new int[5];
        ey = -1;
        my = 17;
        oy = new boolean[my];
        py = new boolean[50];
        qy = false;
        ry = true;
        sy = false;
        yy = 200;
        zy = false;
        az = new String[yy];
        bz = new String[yy];
        cz = new int[yy];
        dz = new int[yy];
        ez = new int[yy];
        fz = new int[yy];
        gz = new int[yy];
        hz = new int[yy];
        iz = new int[yy];
        tz = 5;
        uz = new String[tz];
        vz = new int[tz];
        wz = false;
        xz = false;
        yz = "";
        aab = new int[14];
        bab = new int[14];
        dab = new int[14];
        eab = new int[14];
        fab = false;
        gab = false;
        kab = false;
        lab = false;
        nab = new int[14];
        oab = new int[14];
        qab = new int[14];
        rab = new int[14];
        sab = false;
        vab = new int[256];
        wab = new int[256];
        xab = new int[256];
        yab = -1;
        zab = -2;
        abb = false;
        cbb = new int[256];
        dbb = new int[256];
        ebb = -1;
        fbb = -2;
        gbb = false;
        ibb = new String[5];
        mbb = "";
        nbb = "";
        sbb = false;
        pcb = "";
        qcb = "";
        rcb = "";
        scb = "";
        jdb = false;
        ndb = -1;
        odb = new int[5];
        pdb = new int[5];
        qdb = new int[5];
        rdb = new int[5];
        tdb = new String[5];
        udb = false;
        geb = new int[5];
        heb = new int[5];
        jeb = new String[50];
        keb = new int[50];
        leb = new int[50];
        meb = new int[50];
        neb = new int[50];
        peb = new int[50];
        qeb = new int[50];
        reb = new int[50];
        seb = new int[50];
        ueb = new int[50];
        veb = new int[50];
        web = new int[50];
        afb = false;
        cfb = 1;
        dfb = 2;
        efb = 2;
        ffb = 8;
        gfb = 14;
        ifb = 1;
    }

    public BigInteger et;
    public BigInteger ft;
    boolean gt;
    int ht;
    int it;
    boolean jt;
    boolean kt;
    public boolean lt;
    int mt;
    int nt;
    int ot;
    int pt;
    int qt[];
    int rt[];
    int st;
    int tt[];
    int ut[];
    int vt;
    int wt;
    int xt;
    int yt;
    int zt;
    Graphics au;
    j bu;
    m cu;
    Image du;
    int eu;
    int fu;
    int gu;
    int hu;
    int iu;
    int ju;
    int ku;
    int lu;
    int mu;
    int nu;
    int ou;
    int pu;
    int qu;
    int ru;
    int su;
    int tu;
    int uu;
    int vu;
    p wu;
    int xu;
    int yu;
    int zu;
    int av;
    int bv;
    int cv;
    int dv;
    int ev;
    int fv;
    int gv;
    int hv;
    int iv;
    int jv;
    int kv;
    int lv;
    boolean mv;
    int nv;
    int ov;
    int pv;
    int qv;
    int rv;
    int sv;
    int tv;
    int uv;
    int vv;
    int wv;
    int xv;
    l yv[];
    l zv[];
    l aw[];
    l bw;
    int cw;
    int dw;
    int ew;
    int fw;
    int gw;
    int hw;
    int iw;
    l jw[];
    l kw[];
    l lw[];
    int mw[];
    int nw;
    int ow;
    int pw;
    int qw[];
    int rw[];
    int sw[];
    int tw[];
    int uw;
    int vw;
    h ww[];
    int xw[];
    int yw[];
    int zw[];
    int ax[];
    h bx[];
    boolean cx[];
    int dx;
    int ex;
    h fx[];
    int gx[];
    int hx[];
    int ix[];
    int jx[];
    boolean kx[];
    int lx;
    int mx;
    int nx;
    int ox[];
    int px[];
    int qx[];
    int rx;
    String sx;
    int tx[];
    int ux[];
    int vx[];
    int wx[];
    int xx[];
    int yx;
    String zx[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw"
    };
    String ay[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    g by;
    int cy;
    int dy;
    int ey;
    g fy;
    int gy;
    int hy;
    long iy;
    g jy;
    int ky;
    int ly;
    int my;
    String ny[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer"
    };
    boolean oy[];
    boolean py[];
    boolean qy;
    boolean ry;
    boolean sy;
    int ty;
    int uy;
    int vy;
    int wy;
    int xy;
    int yy;
    boolean zy;
    String az[];
    String bz[];
    int cz[];
    int dz[];
    int ez[];
    int fz[];
    int gz[];
    int hz[];
    int iz[];
    int jz;
    int kz;
    int lz;
    int mz;
    g nz;
    int oz;
    int pz;
    int qz;
    int rz;
    int sz;
    int tz;
    String uz[];
    int vz[];
    boolean wz;
    boolean xz;
    String yz;
    int zz;
    int aab[];
    int bab[];
    int cab;
    int dab[];
    int eab[];
    boolean fab;
    boolean gab;
    int hab;
    int iab;
    long jab;
    boolean kab;
    boolean lab;
    int mab;
    int nab[];
    int oab[];
    int pab;
    int qab[];
    int rab[];
    boolean sab;
    int tab;
    int uab;
    int vab[];
    int wab[];
    int xab[];
    int yab;
    int zab;
    boolean abb;
    int bbb;
    int cbb[];
    int dbb[];
    int ebb;
    int fbb;
    boolean gbb;
    int hbb;
    String ibb[];
    int jbb;
    int kbb;
    int lbb;
    String mbb;
    String nbb;
    int obb;
    int pbb;
    int qbb;
    int rbb;
    boolean sbb;
    int tbb;
    g ubb;
    int vbb;
    int wbb;
    g xbb;
    int ybb;
    int zbb;
    int acb;
    int bcb;
    int ccb;
    int dcb;
    int ecb;
    int fcb;
    g gcb;
    int hcb;
    int icb;
    int jcb;
    int kcb;
    int lcb;
    int mcb;
    int ncb;
    int ocb;
    String pcb;
    String qcb;
    String rcb;
    String scb;
    g tcb;
    int ucb;
    int vcb;
    int wcb;
    int xcb;
    int ycb;
    int zcb;
    int adb;
    int bdb;
    int cdb;
    int ddb;
    int edb;
    int fdb;
    int gdb;
    int hdb;
    int idb;
    boolean jdb;
    g kdb;
    int ldb;
    int mdb;
    int ndb;
    int odb[];
    int pdb[];
    int qdb[];
    int rdb[];
    int sdb[] = {
        0, 1, 2, 3, 4
    };
    String tdb[];
    boolean udb;
    g vdb;
    int wdb;
    int xdb;
    int ydb;
    int zdb;
    int aeb;
    int beb;
    int ceb;
    int deb;
    int eeb;
    int feb;
    int geb[];
    int heb[];
    int ieb;
    String jeb[];
    int keb[];
    int leb[];
    int meb[];
    int neb[];
    int oeb;
    int peb[];
    int qeb[];
    int reb[];
    int seb[];
    int teb;
    int ueb[];
    int veb[];
    int web[];
    int xeb;
    int yeb;
    int zeb[][] = {
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
    boolean afb;
    int bfb;
    int cfb;
    int dfb;
    int efb;
    int ffb;
    int gfb;
    int hfb;
    int ifb;
    public int jfb[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int kfb[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int lfb[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    int mfb[] = {
        0, 1, 2, 1
    };
    int nfb[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    int ofb[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    String pfb[] = {
        "Where were you born?", "What was your first teacher's name?", "What is your father's middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mother's middle name?", "What was your first pet's name?", "What was the name of your first school?", "What is your mother's maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
