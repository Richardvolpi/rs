// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public final class mudclient extends aaa
{
int styleCnt = 0;
public int fog;

    public static final void main(String args[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.dmc = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.ech = true;
        if(args.length > 1)
            mudclient1.aad = args[1];
        if(args.length > 2)
            mudclient1.aae = Integer.parseInt(args[2]);
        mudclient1.fme(mudclient1.elh, mudclient1.eli + 11, "Runescape by Andrew Gower", false);
        mudclient1.flf = 10;
    }

    private final void enf(boolean flag)
    {
        boolean flag2 = false;
        int i = ((blm) (dng)).bln - 199;
        int j = 36;
        dng.cci(i - 49, 3, dkn + 6);
        char c = '\304';
        dng.cbf(i, 36, 196, 65, 0xb5b5b5, 160);
        dng.cbf(i, 101, 196, 65, 0xc9c9c9, 160);
        dng.cbf(i, 166, 196, 95, 0xb5b5b5, 160);
        dng.cbf(i, 261, 196, 40, 0xc9c9c9, 160);
        int k = i + 3;
        int i1 = 51;
        dng.ceg("Game options - click to toggle", k, 51, 1, 0);
        i1 += 15;
        if(ecg)
            dng.ceg("Camera angle mode - @ora@Auto", k, 66, 1, 0xffffff);
        else
            dng.ceg("Camera angle mode - @red@Manual", k, 66, 1, 0xffffff);
        i1 += 15;
        if(dfl)
            dng.ceg("Mouse buttons - @red@One", k, 81, 1, 0xffffff);
        else
            dng.ceg("Mouse buttons - @gre@Two", k, 81, 1, 0xffffff);
        i1 += 15;
        if(dgh)
		if(dgh)
                dng.ceg("Sound effects - @red@off", k, 96, 1, 0xffffff);
            else
                dng.ceg("Sound effects - @gre@on", k, 96, 1, 0xffffff);
        i1 += 15;
        dng.ceg("@ran@You are using Teh_Bot", k, 111, 0, 0xffffff);
        i1 += 15;
        dng.ceg("@blu@This bot is designed to be a ", k, 126, 0, 0xffffff);
        i1 += 15;
        dng.ceg("@blu@community bot, feel free to", k, 141, 0, 0xffffff);
        i1 += 15;
        if(deb == 0)
            dng.ceg("@blu@edit the enclosed mudclient source", k, 156, 0, 0xffffff);
        else
        if(deb == 1)
            dng.ceg("", k, 156, 0, 0xffffff);
        else
            dng.ceg("", k, 156, 0, 0xffffff);
        i1 += 15;
        i1 += 5;
        dng.ceg("Privacy settings. Will be applied to", i + 3, 176, 1, 0);
        i1 += 15;
        dng.ceg("all people not on your friends list", i + 3, 191, 1, 0);
        i1 += 15;
        if(super.abc == 0)
            dng.ceg("Block chat messages: @red@<off>", i + 3, 206, 1, 0xffffff);
        else
            dng.ceg("Block chat messages: @gre@<on>", i + 3, 206, 1, 0xffffff);
        i1 += 15;
        if(super.abd == 0)
            dng.ceg("Block private messages: @red@<off>", i + 3, 221, 1, 0xffffff);
        else
            dng.ceg("Block private messages: @gre@<on>", i + 3, 221, 1, 0xffffff);
        i1 += 15;
        if(super.abe == 0)
            dng.ceg("Block trade requests: @red@<off>", i + 3, 236, 1, 0xffffff);
        else
            dng.ceg("Block trade requests: @gre@<on>", i + 3, 236, 1, 0xffffff);
        i1 += 15;
        if(ech)
            if(super.abf == 0)
                dng.ceg("Block duel requests: @red@<off>", i + 3, 251, 1, 0xffffff);
            else
                dng.ceg("Block duel requests: @gre@<on>", i + 3, 251, 1, 0xffffff);
        i1 += 15;
        i1 += 5;
        dng.ceg("Always logout when you finish", k, 271, 1, 0);
        i1 += 15;
        int k1 = 0xffffff;
        if(super.flg > k && super.flg < k + 196 && super.flh > 274 && super.flh < 290)
            k1 = 0xffff00;
        dng.ceg("Click here to logout", i + 3, 286, 1, k1);
        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((blm) (dng)).bln - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = 66;
            if(super.flg > l && super.flg < l + 196 && super.flh > 54 && super.flh < 70 && ddk == 1)
            {
                ecg = !ecg;
                super.aah.hfc(19);
                super.aah.hfj(0);
                super.aah.hfj(ecg ? 1 : 0);
                super.aah.hem();
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 69 && super.flh < 85 && ddk == 1)
            {
                dfl = !dfl;
                super.aah.hfc(19);
                super.aah.hfj(2);
                super.aah.hfj(dfl ? 1 : 0);
                super.aah.hem();
            }
            j1 += 15;
            if(ech && super.flg > l && super.flg < l + 196 && super.flh > 84 && super.flh < 100 && ddk == 1)
            {
                dgh = !dgh;
                super.aah.hfc(19);
                super.aah.hfj(3);
                super.aah.hfj(dgh ? 1 : 0);
                super.aah.hem();
            }
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            boolean flag1 = false;
            j1 += 35;
            if(super.flg > l && super.flg < l + 196 && super.flh > 194 && super.flh < 210 && ddk == 1)
            {
                super.abc = 1 - super.abc;
                flag1 = true;
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 209 && super.flh < 225 && ddk == 1)
            {
                super.abd = 1 - super.abd;
                flag1 = true;
            }
            j1 += 15;
            if(super.flg > l && super.flg < l + 196 && super.flh > 224 && super.flh < 240 && ddk == 1)
            {
                super.abe = 1 - super.abe;
                flag1 = true;
            }
            j1 += 15;
            if(ech && super.flg > l && super.flg < l + 196 && super.flh > 239 && super.flh < 255 && ddk == 1)
            {
                super.abf = 1 - super.abf;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                ach(super.abc, super.abd, super.abe, super.abf);
            j1 += 20;
            if(super.flg > l && super.flg < l + 196 && super.flh > 274 && super.flh < 290 && ddk == 1)
                fdc();
            ddk = 0;
        }
    }

    protected final void adh(String s)//display message method
    {
        if(s.startsWith("@bor@"))
        {
            enl(s, 4);
            return;
        }
        if(s.startsWith("@que@"))
        {
            enl("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            enl(s, 6);
            return;
        } else
        {
            enl(s, 3);
            return;
        }

    }

    private final void eng()
    {
        dng.bnj = false;
        dng.cbd();
        eij.gfj();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        dng.ccm(169, 25, 64, 102, ahd.akb[deg], eak[dej]);
        dng.cdk(169, 25, 64, 102, ahd.akb[def], eak[dei], ecn[dek], 0, false);
        dng.cdk(169, 25, 64, 102, ahd.akb[dee], ehj[deh], ecn[dek], 0, false);
        dng.ccm(224, 25, 64, 102, ahd.akb[deg] + 6, eak[dej]);
        dng.cdk(224, 25, 64, 102, ahd.akb[def] + 6, eak[dei], ecn[dek], 0, false);
        dng.cdk(224, 25, 64, 102, ahd.akb[dee] + 6, ehj[deh], ecn[dek], 0, false);
        dng.ccm(279, 25, 64, 102, ahd.akb[deg] + 12, eak[dej]);
        dng.cdk(279, 25, 64, 102, ahd.akb[def] + 12, eak[dei], ecn[dek], 0, false);
        dng.cdk(279, 25, 64, 102, ahd.akb[dee] + 12, ehj[deh], ecn[dek], 0, false);
        dng.cci(0, eli, dkn + 22);
        dng.cbc(dil, 0, 0);
    }

    private final void enh()
    {
        int i = 97;
        dng.cbh(86, 77, 340, 180, 0);
        dng.cbi(86, 77, 340, 180, 0xffffff);
        dng.cee("Warning! Proceed with caution", 256, 97, 4, 0xff0000);
        i += 26;
        dng.cee("***Remember everyone in the wilderness***", 256, 123, 1, 0xffffff);
        i += 13;
        dng.cee("        ***is a lefty to you***          ", 256, 136, 1, 0xffffff);
        i += 13;
        dng.cee("", 256, 149, 1, 0xffffff);
        i += 22;
        dng.cee("", 256, 171, 1, 0xffffff);
        i += 13;
        dng.cee("", 256, 184, 1, 0xffffff);
        i += 22;
        dng.cee("", 256, 206, 1, 0xffffff);
        i += 13;
        dng.cee("", 256, 219, 1, 0xffffff);
        i += 22;
        int j = 0xffffff;
        if(super.flh > 229 && super.flh <= 241 && super.flg > 181 && super.flg < 331)
            j = 0xff0000;
        dng.cee("Click here to close window", 256, 241, 1, j);
        if(ddk != 0)
        {
            if(super.flh > 229 && super.flh <= 241 && super.flg > 181 && super.flg < 331)
                emn = 2;
            if(super.flg < 86 || super.flg > 426 || super.flh < 77 || super.flh > 257)
                emn = 2;
            ddk = 0;
        }
    }

    protected final int adj()
    {
        return 0;
    }

    protected final void eni()
    {
        acb();
        feg();
        if(dnl != null)
            dnl.gie();
    }

    private final void enj(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dng)).bln - 199;
        int j = 36;
        dng.cci(i - 49, 3, dkn + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xa0a0a0;
        if(ekc == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        dng.cbf(i, 36, 98, 24, k, 128);
        dng.cbf(i + 98, 36, 98, 24, l, 128);
        dng.cbf(i, 60, 196, 158, 0xdcdcdc, 128);
        dng.cbj(i, 60, 196, 0);
        dng.cbk(i + 98, 36, 24, 0);
        dng.cbj(i, 202, 196, 0);
        dng.cee("Friends", i + 49, 52, 4, 0);
        dng.cee("Ignore", i + 49 + 98, 52, 4, 0);
        eka.ghe(ekb);
        if(ekc == 0)
        {
            for(int i1 = 0; i1 < super.aal; i1++)
            {
                String s;
                if(super.aan[i1] == 99)
                    s = "@gre@";
                else
                if(super.aan[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                eka.ghg(ekb, i1, s + fnf.gah(super.aam[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ekc == 1)
        {
            for(int j1 = 0; j1 < super.aba; j1++)
                eka.ghg(ekb, j1, "@yel@" + fnf.gah(super.abb[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        eka.gfj();
        if(ekc == 0)
        {
            int k1 = eka.ghn(ekb);
            if(k1 >= 0 && super.flg < 489)
            {
                if(super.flg > 429)
                    dng.cee("Click to remove " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffffff);
                else
                if(super.aan[k1] == 99)
                    dng.cee("Click to message " + fnf.gah(super.aam[k1]), i + 98, 71, 1, 0xffffff);
                else
                if(super.aan[k1] > 0)
                    dng.cee(fnf.gah(super.aam[k1]) + " is on world " + super.aan[k1], i + 98, 71, 1, 0xffffff);
                else
                    dng.cee(fnf.gah(super.aam[k1]) + " is offline", i + 98, 71, 1, 0xffffff);
            } else
            {
                dng.cee("Click a name to send a message", i + 98, 71, 1, 0xffffff);
            }
            int k2;
            if(super.flg > i && super.flg < i + 196 && super.flh > 202 && super.flh < 218)
                k2 = 0xffff00;
            else
                k2 = 0xffffff;
            dng.cee("Click here to add a friend", i + 98, 215, 1, k2);
        }
        if(ekc == 1)
        {
            int l1 = eka.ghn(ekb);
            if(l1 >= 0 && super.flg < 489 && super.flg > 429)
            {
                if(super.flg > 429)
                    dng.cee("Click to remove " + fnf.gah(super.abb[l1]), i + 98, 71, 1, 0xffffff);
            } else
            {
                dng.cee("Blocking messages from:", i + 98, 71, 1, 0xffffff);
            }
            int l2;
            if(super.flg > i && super.flg < i + 196 && super.flh > 202 && super.flh < 218)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            dng.cee("Click here to add a name", i + 98, 215, 1, l2);
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            eka.gfg(i + (((blm) (dng)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && ddk == 1)
                if(i < 98 && ekc == 1)
                {
                    ekc = 0;
                    eka.ghf(ekb);
                } else
                if(i > 98 && ekc == 0)
                {
                    ekc = 1;
                    eka.ghf(ekb);
                }
            if(ddk == 1 && ekc == 0)
            {
                int i2 = eka.ghn(ekb);
                if(i2 >= 0 && super.flg < 489)
                    if(super.flg > 429)
                        acl(super.aam[i2]);
                    else
                    if(super.aan[i2] != 0)
                    {
                        djc = 2;
                        ekd = super.aam[i2];
                        super.fmb = "";
                        super.fmc = "";
                    }
            }
            if(ddk == 1 && ekc == 1)
            {
                int j2 = eka.ghn(ekb);
                if(j2 >= 0 && super.flg < 489 && super.flg > 429)
                    acj(super.abb[j2]);
            }
            if(j > 166 && ddk == 1 && ekc == 0)
            {
                djc = 1;
                super.fln = "";
                super.fma = "";
            }
            if(j > 166 && ddk == 1 && ekc == 1)
            {
                djc = 3;
                super.fln = "";
                super.fma = "";
            }
            ddk = 0;
        }
    }

    public final Graphics getGraphics()
    {
        if(fjb.fji != null)
            return fjb.fji.getGraphics();
        else
            return super.getGraphics();
    }

    private final void enk()
    {
        boolean flag = false;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = faf("entity" + cff.cfn + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        abyte1 = fnf.gak("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(ech)
        {
            abyte2 = faf("entity" + cff.cfn + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                egd = true;
                return;
            }
            abyte3 = fnf.gak("index.dat", 0, abyte2);
        }
        int i = 0;
        eig = 0;
        eih = 0;
label0:
        for(int j = 0; j < ahd.all; j++)
        {
            String s = ahd.alk[j];
            for(int k = 0; k < j; k++)
            {
                if(!ahd.alk[k].equalsIgnoreCase(s))
                    continue;
                ahd.akb[j] = ahd.akb[k];
                continue label0;
            }

            byte abyte7[] = fnf.gak(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && ech)
            {
                abyte7 = fnf.gak(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                dng.ccc(eih, abyte7, abyte4, 15);
                i += 15;
                if(ahd.ajn[j] == 1)
                {
                    byte abyte8[] = fnf.gak(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && ech)
                    {
                        abyte8 = fnf.gak(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    dng.ccc(eih + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(ahd.aka[j] == 1)
                {
                    byte abyte9[] = fnf.gak(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && ech)
                    {
                        abyte9 = fnf.gak(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    dng.ccc(eih + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(ahd.ajm[j] != 0)
                {
                    for(int l = eih; l < eih + 27; l++)
                        dng.ccf(l);

                }
            }
            ahd.akb[j] = eih;
            eih += 27;
        }

        System.out.println("Loaded: " + i + " frames of animation");
    }

    private final void enl(String s, int i)
    {
        boolean flag = false;
        if(i == 2 || i == 4 || i == 6)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int j = s.indexOf(":");
            if(j != -1)
            {
                String s1 = s.substring(0, j);
                long l = fnf.gag(s1);
                for(int i1 = 0; i1 < super.aba; i1++)
                    if(super.abb[i1] == l)
                        return;

            }
        }
        if(i == 2)
            s = "@yel@" + s;
        if(i == 3 || i == 4)
            s = "@whi@" + s;
        if(i == 6)
            s = "@cya@" + s;
        if(een != 0)
        {
            if(i == 4 || i == 3)
                eki = 200;
            if(i == 2 && een != 1)
                ekj = 200;
            if(i == 5 && een != 2)
                ekk = 200;
            if(i == 6 && een != 3)
                ekl = 200;
            if(i == 3 && een != 0)
                een = 0;
            if(i == 6 && een != 3 && een != 0)
                een = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            dgm[k] = dgm[k - 1];
            die[k] = die[k - 1];
        }

        dgm[0] = s;
        die[0] = 300;
        if(i == 2)
            if(eei.gci[eej] == eei.gcj[eej] - 4)
                eei.ghh(eej, s, true);
            else
                eei.ghh(eej, s, false);
        if(i == 5)
            if(eei.gci[eel] == eei.gcj[eel] - 4)
                eei.ghh(eel, s, true);
            else
                eei.ghh(eel, s, false);
        if(i == 6)
        {
            if(eei.gci[eem] == eei.gcj[eem] - 4)
            {
                eei.ghh(eem, s, true);
                return;
            }
            eei.ghh(eem, s, false);
        }
    }

    private final void enm()
    {
        eei = new gca(dng, 10);
        eej = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eek = eei.gha(7, 324, 498, 14, 1, 80, false, true);
        eel = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eem = eei.ggn(5, 269, 502, 56, 1, 20, true);
        eei.ghm(eek);
    }

    private final void enn()
    {
        boolean flag = false;
        eij.gfg(super.flg, super.flh, super.flj, super.fli);
        if(eij.gfh(ebb))
            do
                dee = ((dee - 1) + ahd.all) % ahd.all;
            while((ahd.ajm[dee] & 3) != 1 || (ahd.ajm[dee] & 4 * del) == 0);
        if(eij.gfh(ebc))
            do
                dee = (dee + 1) % ahd.all;
            while((ahd.ajm[dee] & 3) != 1 || (ahd.ajm[dee] & 4 * del) == 0);
        if(eij.gfh(ebd))
            deh = ((deh - 1) + ehj.length) % ehj.length;
        if(eij.gfh(ebe))
            deh = (deh + 1) % ehj.length;
        if(eij.gfh(ebf) || eij.gfh(ebg))
        {
            for(del = 3 - del; (ahd.ajm[dee] & 3) != 1 || (ahd.ajm[dee] & 4 * del) == 0; dee = (dee + 1) % ahd.all);
            for(; (ahd.ajm[def] & 3) != 2 || (ahd.ajm[def] & 4 * del) == 0; def = (def + 1) % ahd.all);
        }
        if(eij.gfh(ebh))
            dei = ((dei - 1) + eak.length) % eak.length;
        if(eij.gfh(ebi))
            dei = (dei + 1) % eak.length;
        if(eij.gfh(ebj))
            dek = ((dek - 1) + ecn.length) % ecn.length;
        if(eij.gfh(ebk))
            dek = (dek + 1) % ecn.length;
        if(eij.gfh(ebl))
            dej = ((dej - 1) + eak.length) % eak.length;
        if(eij.gfh(ebm))
            dej = (dej + 1) % eak.length;
        if(eij.gfh(ebn))
        {
            super.aah.hfc(167);
            super.aah.hfj(del);
            super.aah.hfj(dee);
            super.aah.hfj(def);
            super.aah.hfj(deg);
            super.aah.hfj(deh);
            super.aah.hfj(dei);
            super.aah.hfj(dej);
            super.aah.hfj(dek);
            super.aah.hem();
            dng.cbd();
            edf = false;
        }
    }

    private final void faa()
    {
        boolean flag = false;
        if(ecf > 1)
            ecf--;
        ace();
        if(dmm > 0)
            dmm--;
        if(super.fjn > 4500 && edj == 0 && dmm == 0)
        {
            super.fjn -= 500;
            fdc();
            return;
        }
        if(ejk.hah == 8 || ejk.hah == 9)
            edj = 500;
        if(edj > 0)
            edj--;
        if(edf)
        {
            enn();
            return;
        }
        for(int i = 0; i < dka; i++)
        {
            gnm gnm1 = eml[i];
            int k = (gnm1.hak + 1) % 10;
            if(gnm1.haj != k)
            {
                int i1 = -1;
                int l2 = gnm1.haj;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(gnm1.hal[l2] - gnm1.had > eic * 3 || gnm1.ham[l2] - gnm1.hae > eic * 3 || gnm1.hal[l2] - gnm1.had < -eic * 3 || gnm1.ham[l2] - gnm1.hae < -eic * 3 || j4 > 8)
                {
                    gnm1.had = gnm1.hal[l2];
                    gnm1.hae = gnm1.ham[l2];
                } else
                {
                    if(gnm1.had < gnm1.hal[l2])
                    {
                        gnm1.had += j5;
                        gnm1.hag++;
                        i1 = 2;
                    } else
                    if(gnm1.had > gnm1.hal[l2])
                    {
                        gnm1.had -= j5;
                        gnm1.hag++;
                        i1 = 6;
                    }
                    if(gnm1.had - gnm1.hal[l2] < j5 && gnm1.had - gnm1.hal[l2] > -j5)
                        gnm1.had = gnm1.hal[l2];
                    if(gnm1.hae < gnm1.ham[l2])
                    {
                        gnm1.hae += j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(gnm1.hae > gnm1.ham[l2])
                    {
                        gnm1.hae -= j5;
                        gnm1.hag++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(gnm1.hae - gnm1.ham[l2] < j5 && gnm1.hae - gnm1.ham[l2] > -j5)
                        gnm1.hae = gnm1.ham[l2];
                }
                if(i1 != -1)
                    gnm1.hah = i1;
                if(gnm1.had == gnm1.hal[l2] && gnm1.hae == gnm1.ham[l2])
                    gnm1.haj = (l2 + 1) % 10;
            } else
            {
                gnm1.hah = gnm1.hai;
            }
            if(gnm1.hbb > 0)
                gnm1.hbb--;
            if(gnm1.hbd > 0)
                gnm1.hbd--;
            if(gnm1.hbh > 0)
                gnm1.hbh--;
            if(ecj > 0)
            {
                ecj--;
                if(ecj == 0)
                    enl("Welcome to Lumbridge", 3);
                if(ecj == 0)
                    enl("", 3);
            }
        }

        for(int j = 0; j < ehd; j++)
        {
            gnm gnm2 = dif[j];
            int j1 = (gnm2.hak + 1) % 10;
            if(gnm2.haj != j1)
            {
                int i3 = -1;
                int k4 = gnm2.haj;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(gnm2.hal[k4] - gnm2.had > eic * 3 || gnm2.ham[k4] - gnm2.hae > eic * 3 || gnm2.hal[k4] - gnm2.had < -eic * 3 || gnm2.ham[k4] - gnm2.hae < -eic * 3 || k5 > 8)
                {
                    gnm2.had = gnm2.hal[k4];
                    gnm2.hae = gnm2.ham[k4];
                } else
                {
                    if(gnm2.had < gnm2.hal[k4])
                    {
                        gnm2.had += l5;
                        gnm2.hag++;
                        i3 = 2;
                    } else
                    if(gnm2.had > gnm2.hal[k4])
                    {
                        gnm2.had -= l5;
                        gnm2.hag++;
                        i3 = 6;
                    }
                    if(gnm2.had - gnm2.hal[k4] < l5 && gnm2.had - gnm2.hal[k4] > -l5)
                        gnm2.had = gnm2.hal[k4];
                    if(gnm2.hae < gnm2.ham[k4])
                    {
                        gnm2.hae += l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(gnm2.hae > gnm2.ham[k4])
                    {
                        gnm2.hae -= l5;
                        gnm2.hag++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(gnm2.hae - gnm2.ham[k4] < l5 && gnm2.hae - gnm2.ham[k4] > -l5)
                        gnm2.hae = gnm2.ham[k4];
                }
                if(i3 != -1)
                    gnm2.hah = i3;
                if(gnm2.had == gnm2.hal[k4] && gnm2.hae == gnm2.ham[k4])
                    gnm2.haj = (k4 + 1) % 10;
            } else
            {
                gnm2.hah = gnm2.hai;
                if(gnm2.haf == 43)
                    gnm2.hag++;
            }
            if(gnm2.hbb > 0)
                gnm2.hbb--;
            if(gnm2.hbd > 0)
                gnm2.hbd--;
            if(gnm2.hbh > 0)
                gnm2.hbh--;
        }

        if(egh != 2)
        {
            if(blm.cag > 0)
                dmj++;
            if(blm.cah > 0)
                dmj = 0;
            blm.cag = 0;
            blm.cah = 0;
        }
        for(int l = 0; l < dka; l++)
        {
            gnm gnm3 = eml[l];
            if(gnm3.hcc > 0)
                gnm3.hcc--;
        }

        if(dkj - ejk.had < -500 || dkj - ejk.had > 500 || dkk - ejk.hae < -500 || dkk - ejk.hae > 500)
        {
            dkj = ejk.had;
            dkk = ejk.hae;
        }
        if(dkj != ejk.had)
            dkj += (ejk.had - dkj) / (16 + (dhe - 500) / 15);
        if(dkk != ejk.hae)
            dkk += (ejk.hae - dkk) / (16 + (dhe - 500) / 15);
        if(ecg)
        {
            int k1 = dim * 32;
            int j3 = k1 - dml;
            byte byte0 = 1;
            if(j3 != 0)
            {
                din++;
                if(j3 > 128)
                {
                    byte0 = -1;
                    j3 = 256 - j3;
                } else
                if(j3 > 0)
                    byte0 = 1;
                else
                if(j3 < -128)
                {
                    byte0 = 1;
                    j3 = 256 + j3;
                } else
                if(j3 < 0)
                {
                    byte0 = -1;
                    j3 = -j3;
                }
                dml += ((din * j3 + 255) / 256) * byte0;
                dml &= 0xff;
            } else
            {
                din = 0;
            }
        }
        if(dmj > 20)
        {
            dlg = false;
            dmj = 0;
        }
        if(ddj)
        {
            if(super.fma.length() > 0)
                if(super.fma.equalsIgnoreCase("::lostcon") && !dmc)
                    super.aah.ban();
                else
                if(super.fma.equalsIgnoreCase("::closecon") && !dmc)
                {
                    acb();
                } else
                {
                    super.aah.hfc(156);
                    super.aah.hen(super.fma);
                    if(!dlg)
                    {
                        super.aah.hfj(0);
                        dlg = true;
                    }
                    super.aah.hem();
                    super.fln = "";
                    super.fma = "";
                    dia = "Please wait...";
                }
            if(super.flj == 1 && super.flh > 275 && super.flh < 310 && super.flg > 56 && super.flg < 456)
            {
                super.aah.hfc(156);
                super.aah.hen("-null-");
                if(!dlg)
                {
                    super.aah.hfj(0);
                    dlg = true;
                }
                super.aah.hem();
                super.fln = "";
                super.fma = "";
                dia = "Please wait...";
            }
            super.flj = 0;
            return;
        }
        if(super.flh > eli - 4)
        {
            if(super.flg > 15 && super.flg < 96 && super.flj == 1)
                een = 0;
            if(super.flg > 110 && super.flg < 194 && super.flj == 1)
            {
                een = 1;
                eei.gci[eej] = 0xf423f;
            }
            if(super.flg > 215 && super.flg < 295 && super.flj == 1)
            {
                een = 2;
                eei.gci[eel] = 0xf423f;
            }
            if(super.flg > 315 && super.flg < 395 && super.flj == 1)
            {
                een = 3;
                eei.gci[eem] = 0xf423f;
            }
            if(super.flg > 417 && super.flg < 497 && super.flj == 1)
            {
                egm = 1;
                eac = 0;
                super.fln = "";
                super.fma = "";
            }
            super.flj = 0;
            super.fli = 0;
        }
        eei.gfg(super.flg, super.flh, super.flj, super.fli);
        if(een > 0 && super.flg >= 494 && super.flh >= eli - 66)
            super.flj = 0;
        if(eei.gfh(eek))
        {
      		
		String s = eei.ghj(eek);
            eei.ghi(eek, "");
            if(s.startsWith("/"))//system
            {
                if(s.equalsIgnoreCase("/closecon"))
                super.aah.ban();
		else
                if(s.equalsIgnoreCase("/logout"))
		logout();
		else
                if(s.equalsIgnoreCase("/lostcon"))
		acc();
		else
                if(s.equalsIgnoreCase("/fixmap"))
		fixmap();
		else
		if(s.equalsIgnoreCase("/unzoom"))
		unzoom();
		else
		if(s.equalsIgnoreCase("/showbank"))
		bankshow();
		else
		if(s.equalsIgnoreCase("/set controlled"))
		eff = 0;
		else
		if(s.equalsIgnoreCase("/set strength"))
		eff = 1;
		else
		if(s.equalsIgnoreCase("/set attack"))
		eff = 2;
		else
		if(s.equalsIgnoreCase("/set defense"))
		eff = 3;
		super.aah.hfc(134);
		super.aah.hfj(eff);
		super.aah.hem();


		
		
		
		


	    } else
            {
                int k3 = cen.cfe(s);
                acn(cen.cfa, k3);
                s = cen.cfd(cen.cfa, 0, k3);
                s = ffn.fhe(s);
                ejk.hbb = 150;
                ejk.hba = s;
                enl(ejk.haa + ": " + s, 2);
            }
        }
        if(een == 0)
        {
            for(int l1 = 0; l1 < 5; l1++)
                if(die[l1] > 0)
                    die[l1]--;

        }
        if(ecj != 0)
            super.flj = 0;
        if(dmk || eeb)
        {
            if(super.fli != 0)
                eck++;
            else
                eck = 0;
            if(eck > 600)
                ecl += 5000;
            else
            if(eck > 450)
                ecl += 500;
            else
            if(eck > 300)
                ecl += 50;
            else
            if(eck > 150)
                ecl += 5;
            else
            if(eck > 50)
                ecl++;
            else
            if(eck > 20 && (eck & 5) == 0)
                ecl++;
        } else
        {
            eck = 0;
            ecl = 0;
        }
        if(super.flj == 1)
            ddk = 1;
        else
        if(super.flj == 2)
            ddk = 2;
        egn.bhl(super.flg, super.flh);
        super.flj = 0;
        if(ecg)
        {
            if(din == 0)
            {
                if(super.fkn)
                {
                    dim = dim + 1 & 7;
                    super.fkn = false;
                    if(!edm)
                    {
                        if((dim & 1) == 0)
                            dim = dim + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            if(ffa(dim))
                                break;
                            dim = dim + 1 & 7;
                        }

                    }
                }
                if(super.fla)
                {
                    dim = dim + 7 & 7;
                    super.fla = false;
                    if(!edm)
                    {
                        if((dim & 1) == 0)
                            dim = dim + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            if(ffa(dim))
                                break;
                            dim = dim + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fkn)
            dml = dml + 2 & 0xff;
        else
        if(super.fla)
            dml = dml - 2 & 0xff;
        if(edm && dhe > 550)
            dhe -= 4;
        else
        if(!edm && dhe < 750)
            dhe += 4;
        if(efg > 0)
            efg--;
        else
        if(efg < 0)
            efg++;
        egn.bjn(17);
        ein++;
        if(ein > 5)
        {
            ein = 0;
            efj = (efj + 1) % 3;
            efk = (efk + 1) % 4;
            efl = (efl + 1) % 5;
        }
        for(int k2 = 0; k2 < eif; k2++)
        {
            int l3 = ekn[k2];
            int l4 = ela[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && elb[k2] == 74)
                emm[k2].cne(1, 0, 0);
        }

        for(int i4 = 0; i4 < ede; i4++)
        {
            eba[i4]++;
            if(eba[i4] > 50)
            {
                ede--;
                for(int i5 = i4; i5 < ede; i5++)
                {
                    dga[i5] = dga[i5 + 1];
                    ehi[i5] = ehi[i5 + 1];
                    eba[i5] = eba[i5 + 1];
                    ejf[i5] = ejf[i5 + 1];
                }

            }
        }

    }
	
	
	 
	public void logout()
	{
	adh("@gre@Teh_Bot:@ran@logging out...");	
	
try
{
     Thread.sleep(400); 
} catch (InterruptedException exception) {}
	acb();
	}	
	public void bankshow()
	{
	adh("@gre@Teh_Bot:@ran@showing bank...");
	showbank(true);
	}
	
	public void unzoom()
	{
	adh("@gre@Teh_Bot:@ran@unzooming...");
	dhe = 750;
	}

	public void fixmap()
	{
	adh("@gre@Teh_Bot:@ran@fixing map...");
	dml = 128;
	}
	

    private final void fab()
    {
        try
        {
            ejj = faf("sounds" + cff.cga + ".mem", "Sound effects", 90);
            dnl = new gia();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void fac()
    {
        boolean flag1 = false;
        ecm = ehk;
        for(int i = 0; i < ehk; i++)
        {
            dhm[i] = eag[i];
            dhn[i] = eah[i];
        }

        for(int j = 0; j < ena; j++)
        {
            if(ecm >= elf)
                break;
            int k = enb[j];
            boolean flag = false;
            for(int l = 0; l < ecm; l++)
            {
                if(dhm[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                dhm[ecm] = k;
                dhn[ecm] = 0;
                ecm++;
            }
        }

    }

    private final void fad()
    {
        boolean flag = false;
        byte abyte0[] = faf("media" + cff.cfk + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        dng.ccc(dkn, fnf.gak("inv1.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 1, fnf.gak("inv2.dat", 0, abyte0), abyte1, 6);
        dng.ccc(dkn + 9, fnf.gak("bubble.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 10, fnf.gak("runescape.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 11, fnf.gak("splat.dat", 0, abyte0), abyte1, 3);
        dng.ccc(dkn + 14, fnf.gak("icon.dat", 0, abyte0), abyte1, 8);
        dng.ccc(dkn + 22, fnf.gak("hbar.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 23, fnf.gak("hbar2.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 24, fnf.gak("compass.dat", 0, abyte0), abyte1, 1);
        dng.ccc(dkn + 25, fnf.gak("buttons.dat", 0, abyte0), abyte1, 2);
        dng.ccc(dla, fnf.gak("scrollbar.dat", 0, abyte0), abyte1, 2);
        dng.ccc(dla + 2, fnf.gak("corners.dat", 0, abyte0), abyte1, 4);
        dng.ccc(dla + 6, fnf.gak("arrows.dat", 0, abyte0), abyte1, 2);
        dng.ccc(dlc, fnf.gak("projectile.dat", 0, abyte0), abyte1, ahd.alf);
        int i = ahd.alj;
        for(int j = 1; i > 0; j++)
        {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            dng.ccc(dlb + (j - 1) * 30, fnf.gak("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }

        dng.ccf(dkn);
        dng.ccf(dkn + 9);
        for(int l = 11; l <= 26; l++)
            dng.ccf(dkn + l);

        for(int i1 = 0; i1 < ahd.alf; i1++)
            dng.ccf(dlc + i1);

        for(int j1 = 0; j1 < ahd.alj; j1++)
            dng.ccf(dlb + j1);

    }

    private final void fae()
    {
        boolean flag = false;
        if(ddk != 0)
        {
            ddk = 0;
            int i = super.flg - 52;
            int j = super.flh - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && efm[k] != -1)
                        {
                            dhc = k;
                            dhd = efm[k];
                        }
                        k++;
                    }

                }

                if(dhc >= 0)
                {
                    int j2 = efm[dhc];
                    if(j2 != -1)
                    {
                        if(efn[dhc] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = efc + ega[dhc];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * ahd.aje[j2]) / 100;
                            super.aah.hfc(37);
                            super.aah.hfl(efm[dhc]);
                            super.aah.hfi(i4);
                            super.aah.hem();
                        }
                        if(fdm(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = efb + ega[dhc];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * ahd.aje[j2]) / 100;
                            super.aah.hfc(21);
                            super.aah.hfl(efm[dhc]);
                            super.aah.hfi(j4);
                            super.aah.hem();
                        }
                    }
                }
            } else
            {
                super.aah.hfc(210);
                super.aah.hem();
                eec = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        dng.cbh(52, 44, 408, 12, 192);
        int l = 0x989898;
        dng.cbf(52, 56, 408, 17, 0x989898, 160);
        dng.cbf(52, 73, 8, 170, 0x989898, 160);
        dng.cbf(451, 73, 9, 170, 0x989898, 160);
        dng.cbf(52, 243, 408, 47, 0x989898, 160);
        dng.ceg("Buying and selling items", 53, 54, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.flg > 372 && super.flh >= 44 && super.flg < 460 && super.flh < 56)
            j1 = 0xff0000;
        dng.ced("Close window", 458, 54, 1, j1);
        dng.ceg("Shops stock in green", 54, 68, 1, 65280);
        dng.ceg("Number you own in blue", 187, 68, 1, 65535);
        dng.ceg("Your money: " + fdm(10) + "gp", 332, 68, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = 59 + l4 * 49;
                int i6 = 72 + k4 * 34;
                if(dhc == k3)
                    dng.cbf(j5, i6, 49, 34, 0xff0000, 160);
                else
                    dng.cbf(j5, i6, 49, 34, 0xd0d0d0, 160);
                dng.cbi(j5, i6, 50, 35, 0);
                if(efm[k3] != -1)
                {
                    dng.cdk(j5, i6, 48, 32, dlb + ahd.ajd[efm[k3]], ahd.aji[efm[k3]], 0, 0, false);
                    dng.ceg(String.valueOf(efn[k3]), j5 + 1, i6 + 10, 1, 65280);
                    dng.ced(String.valueOf(fdm(efm[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }

        }

        dng.cbj(57, 266, 398, 0);
        if(dhc == -1)
        {
            dng.cee("Select an object to buy or sell", 256, 258, 3, 0xffff00);
            return;
        }
        int i5 = efm[dhc];
        if(i5 != -1)
        {
            if(efn[dhc] > 0)
            {
                int k5 = efc + ega[dhc];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * ahd.aje[i5]) / 100;
                dng.ceg("Buy a new " + ahd.amb[i5] + " for " + j6 + "gp", 54, 258, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.flg > 350 && super.flh >= 248 && super.flg < 460 && super.flh <= 259)
                    k1 = 0xff0000;
                dng.ced("Click here to buy", 457, 258, 3, k1);
            } else
            {
                dng.cee("This item is not currently available to buy", 256, 258, 3, 0xffff00);
            }
            if(fdm(i5) > 0)
            {
                int l5 = efb + ega[dhc];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * ahd.aje[i5]) / 100;
                dng.ced("Sell your " + ahd.amb[i5] + " for " + k6 + "gp", 457, 283, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.flg > 54 && super.flh >= 273 && super.flg < 164 && super.flh <= 284)
                    l1 = 0xff0000;
                dng.ceg("Click here to sell", 54, 283, 3, l1);
                return;
            }
            dng.cee("You do not have any of this item to sell", 256, 283, 3, 0xffff00);
        }
    }

    protected final byte[] faf(String s, String s1, int i)
    {
        if(!dmc)
            s = "../release/" + s;
        byte abyte0[] = gam.gbk(s);
        if(abyte0 != null)
        {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            fml(i, "Unpacking " + s1);
            if(k != j)
            {
                byte abyte2[] = new byte[j];
                gnd.gne(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.faf(s, s1, i);
        }
    }

    private final void fag()
    {
        boolean flag = false;
        eac = 0;
        int i = 135;
        for(int j = 0; j < 12; j++)
        {
            if(super.flg > 66 && super.flg < 446 && super.flh >= i - 12 && super.flh < i + 3)
                eac = j + 1;
            i += 14;
        }

        if(ddk != 0 && eac != 0)
        {
            ddk = 0;
            egm = 2;
            super.fln = "";
            super.fma = "";
            return;
        }
        i += 15;
        if(ddk != 0)
        {
            ddk = 0;
            if(super.flg < 56 || super.flh < 35 || super.flg > 456 || super.flh > 325)
            {
                egm = 0;
                return;
            }
            if(super.flg > 66 && super.flg < 446 && super.flh >= i - 15 && super.flh < i + 5)
            {
                egm = 0;
                return;
            }
        }
        dng.cbh(56, 35, 400, 290, 0);
        dng.cbi(56, 35, 400, 290, 0xffffff);
        i = 50;
        dng.cee("This form is for reporting players who are breaking our rules", 256, 50, 1, 0xffffff);
        i += 15;
        dng.cee("Using it sends a snapshot of the last 60 secs of activity to us", 256, 65, 1, 0xffffff);
        i += 15;
        dng.cee("If you misuse this form, you will be banned.", 256, 80, 1, 0xff8000);
        i += 15;
        i += 10;
        dng.cee("First indicate which of our 12 rules is being broken. For a detailed", 256, 105, 1, 0xffff00);
        i += 15;
        dng.cee("explanation of each rule please read the manual on our website.", 256, 120, 1, 0xffff00);
        i += 15;
        int k;
        if(eac == 1)
        {
            dng.cbi(66, 123, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("1: Offensive language", 256, 135, 1, k);
        i += 14;
        if(eac == 2)
        {
            dng.cbi(66, 137, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("2: Item scamming", 256, 149, 1, k);
        i += 14;
        if(eac == 3)
        {
            dng.cbi(66, 151, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("3: Password scamming", 256, 163, 1, k);
        i += 14;
        if(eac == 4)
        {
            dng.cbi(66, 165, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("4: Bug abuse", 256, 177, 1, k);
        i += 14;
        if(eac == 5)
        {
            dng.cbi(66, 179, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("5: Jagex Staff impersonation", 256, 191, 1, k);
        i += 14;
        if(eac == 6)
        {
            dng.cbi(66, 193, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("6: Account sharing/trading", 256, 205, 1, k);
        i += 14;
        if(eac == 7)
        {
            dng.cbi(66, 207, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("7: Macroing", 256, 219, 1, k);
        i += 14;
        if(eac == 8)
        {
            dng.cbi(66, 221, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("8: Mutiple logging in", 256, 233, 1, k);
        i += 14;
        if(eac == 9)
        {
            dng.cbi(66, 235, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("9: Encouraging others to break rules", 256, 247, 1, k);
        i += 14;
        if(eac == 10)
        {
            dng.cbi(66, 249, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("10: Misuse of customer support", 256, 261, 1, k);
        i += 14;
        if(eac == 11)
        {
            dng.cbi(66, 263, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("11: Advertising / website", 256, 275, 1, k);
        i += 14;
        if(eac == 12)
        {
            dng.cbi(66, 277, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        dng.cee("12: Real world item trading", 256, 289, 1, k);
        i += 14;
        i += 15;
        k = 0xffffff;
        if(super.flg > 196 && super.flg < 316 && super.flh > 303 && super.flh < 323)
            k = 0xffff00;
        dng.cee("Click here to cancel", 256, 318, 1, k);
    }

    private final cgc fah(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = ahd.akd[l];
        int k2 = ahd.ake[l];
        int l2 = ahd.akc[l];
        cgc cgc1 = new cgc(4, 1);
        if(k == 0)
            l1 = i + 1;
        if(k == 1)
            i2 = j + 1;
        if(k == 2)
        {
            j1 = i + 1;
            i2 = j + 1;
        }
        if(k == 3)
        {
            l1 = i + 1;
            i2 = j + 1;
        }
        j1 *= eic;
        k1 *= eic;
        l1 *= eic;
        i2 *= eic;
        int i3 = cgc1.cmj(j1, -dlm.gnb(j1, k1), k1);
        int j3 = cgc1.cmj(j1, -dlm.gnb(j1, k1) - l2, k1);
        int k3 = cgc1.cmj(l1, -dlm.gnb(l1, i2) - l2, i2);
        int l3 = cgc1.cmj(l1, -dlm.gnb(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        cgc1.cml(4, ai, j2, k2);
        cgc1.cna(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            egn.bhd(cgc1);
        cgc1.cig = i1 + 10000;
        return cgc1;
    }

    private final void fai()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        dng.cbh(22, 36, 468, 16, 192);
        int i = 0x989898;
        dng.cbf(22, 52, 468, 246, 0x989898, 160);
        dng.cee("Please confirm your duel with @yel@" + fnf.gah(ekh), 256, 48, 1, 0xffffff);
        dng.cee("Your stake:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < dkd; j++)
        {
            String s = ahd.amb[dke[j]];
            if(ahd.ajf[dke[j]] == 0)
                s = s + " x " + fal(dkf[j]);
            dng.cee(s, 139, 78 + j * 12, 1, 0xffffff);
        }

        if(dkd == 0)
            dng.cee("Nothing!", 139, 78, 1, 0xffffff);
        dng.cee("Your opponent's stake:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < ead; k++)
        {
            String s1 = ahd.amb[eae[k]];
            if(ahd.ajf[eae[k]] == 0)
                s1 = s1 + " x " + fal(eaf[k]);
            dng.cee(s1, 373, 78 + k * 12, 1, 0xffffff);
        }

        if(ead == 0)
            dng.cee("Nothing!", 373, 78, 1, 0xffffff);
        if(dhg == 0)
            dng.cee("You can retreat from this duel", 256, 216, 1, 65280);
        else
            dng.cee("No retreat is possible!", 256, 216, 1, 0xff0000);
        if(dhh == 0)
            dng.cee("Magic may be used", 256, 228, 1, 65280);
        else
            dng.cee("Magic cannot be used", 256, 228, 1, 0xff0000);
        if(dhi == 0)
            dng.cee("Prayer may be used", 256, 240, 1, 65280);
        else
            dng.cee("Prayer cannot be used", 256, 240, 1, 0xff0000);
        if(dhj == 0)
            dng.cee("Weapons may be used", 256, 252, 1, 65280);
        else
            dng.cee("Weapons cannot be used", 256, 252, 1, 0xff0000);
        dng.cee("If you are sure click 'Accept' to begin the duel", 256, 266, 1, 0xffffff);
        if(!dkm)
        {
            dng.cci(105, 274, dkn + 25);
            dng.cci(339, 274, dkn + 26);
        } else
        {
            dng.cee("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(ddk == 1)
        {
            if(super.flg < 22 || super.flh < 36 || super.flg > 490 || super.flh > 298)
            {
                dkl = false;
                super.aah.hfc(255);
                super.aah.hem();
            }
            if(super.flg >= 105 && super.flg <= 210 && super.flh >= 274 && super.flh <= 295)
            {
                dkm = true;
                super.aah.hfc(87);
                super.aah.hem();
            }
            if(super.flg >= 339 && super.flg <= 445 && super.flh >= 274 && super.flh <= 295)
            {
                dkl = false;
                super.aah.hfc(191);
                super.aah.hem();
            }
            ddk = 0;
        }
    }

    private final void faj(int i, int j, int k, int l, boolean flag)
    {
        fce(i, j, k, l, k, l, false, flag);
    }

    private final void fak()
    {
        boolean flag = false;
        byte abyte0[] = faf("textures" + cff.cfm + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        byte abyte1[] = fnf.gak("index.dat", 0, abyte0);
        egn.bjj(ahd.amm, 7, 11);
        for(int i = 0; i < ahd.amm; i++)
        {
            String s = ahd.amf[i];
            byte abyte2[] = fnf.gak(s + ".dat", 0, abyte0);
            dng.ccc(dld, abyte2, abyte1, 1);
            dng.cbh(0, 0, 128, 128, 0xff00ff);
            dng.cci(0, 0, dld);
            int j = ((blm) (dng)).bnc[dld];
            String s1 = ahd.amg[i];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = fnf.gak(s1 + ".dat", 0, abyte0);
                dng.ccc(dld, abyte3, abyte1, 1);
                dng.cci(0, 0, dld);
            }
            dng.cch(dle + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((blm) (dng)).bmj[dle + i][l] == 65280)
                    ((blm) (dng)).bmj[dle + i][l] = 0xff00ff;

            dng.cce(dle + i);
            egn.bjk(i, ((blm) (dng)).bmk[dle + i], ((blm) (dng)).bml[dle + i], j / 64 - 1);
        }

    }

    private static final String fal(int i)
    {
        boolean flag = false;
        String s = String.valueOf(i);
        for(int j = s.length() - 3; j > 0; j -= 3)
            s = s.substring(0, j) + "," + s.substring(j);

        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }

    final void fam(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag3 = false;
        gnm gnm1 = dif[i1];
        int l1 = gnm1.hah + (dml + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + dhf[(gnm1.hag / ahd.aif[gnm1.haf]) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (ahd.aih[gnm1.haf] * k1) / 100;
            j2 = 15 + eai[(ean / (ahd.aig[gnm1.haf] - 1)) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (ahd.aih[gnm1.haf] * k1) / 100;
            j2 = 15 + emi[(ean / ahd.aig[gnm1.haf]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = eha[l1][k2];
            int k3 = ahd.aja[gnm1.haf][l2];
            if(k3 >= 0)
            {
                boolean flag1 = false;
                boolean flag2 = false;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && ahd.aka[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || ahd.ajn[k3] == 1)
                {
                    int l4 = k4 + ahd.akb[k3];
                    int i4 = (0 * k) / ((blm) (dng)).bnc[l4];
                    int j4 = (0 * l) / ((blm) (dng)).bnd[l4];
                    int i5 = (k * ((blm) (dng)).bnc[l4]) / ((blm) (dng)).bnc[ahd.akb[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = ahd.ajl[k3];
                    int k5 = 0;
                    if(j5 == 1)
                    {
                        j5 = ahd.anc[gnm1.haf];
                        k5 = ahd.anf[gnm1.haf];
                    } else
                    if(j5 == 2)
                    {
                        j5 = ahd.and[gnm1.haf];
                        k5 = ahd.anf[gnm1.haf];
                    } else
                    if(j5 == 3)
                    {
                        j5 = ahd.ane[gnm1.haf];
                        k5 = ahd.anf[gnm1.haf];
                    }
                    dng.cdk(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }

        if(gnm1.hbb > 0)
        {
            dii[ejd] = dng.cem(gnm1.hba, 1) / 2;
            if(dii[ejd] > 150)
                dii[ejd] = 150;
            dij[ejd] = (dng.cem(gnm1.hba, 1) / 300) * dng.cek(1);
            dig[ejd] = i + k / 2;
            dih[ejd] = j;
            eje[ejd++] = gnm1.hba;
        }
        if(gnm1.hah == 8 || gnm1.hah == 9 || gnm1.hbh != 0)
        {
            if(gnm1.hbh > 0)
            {
                int i3 = i;
                if(gnm1.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (gnm1.hbf * 30) / gnm1.hbg;
                eke[dhl] = i3 + k / 2;
                ekf[dhl] = j;
                ekg[dhl++] = l3;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                dng.cci((j3 + k / 2) - 12, (j + l / 2) - 12, dkn + 12);
                dng.cee(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void fan()
    {
        boolean flag1 = false;
        for(int i = 0; i < ejd; i++)
        {
            int j = dng.cek(1);
            int l = dig[i];
            int k1 = dih[i];
            int j2 = dii[i];
            int i3 = dij[i];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > dih[i4] - j && k1 - j < dih[i4] + dij[i4] && l - j2 < dig[i4] + dii[i4] && l + j2 > dig[i4] - dii[i4] && dih[i4] - j - i3 < k1)
                    {
                        k1 = dih[i4] - j - i3;
                        flag = true;
                    }

            }
            dih[i] = k1;
            dng.cef(eje[i], l, k1, 1, 0xffff00, 300);
        }

        for(int k = 0; k < ehc; k++)
        {
            int i1 = edk[k];
            int l1 = edl[k];
            int k2 = djd[k];
            int j3 = dje[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            dng.ccl(i1 - l3 / 2, k4, l3, j4, dkn + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            dng.cdk(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, ahd.ajd[j3] + dlb, ahd.aji[j3], 0, 0, false);
        }

        for(int j1 = 0; j1 < dhl; j1++)
        {
            int i2 = eke[j1];
            int l2 = ekf[j1];
            int k3 = ekg[j1];
            dng.cbf(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            dng.cbf((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        }

    }

    final void fba(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = ejf[i1];
        int i2 = eba[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            dng.cbe(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xff0000 + i2 * 5 * 256;
            dng.cbe(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    protected final Socket fbb(String s, int i)
        throws IOException
    {
        Socket socket;
        if(fmf())
            socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        return socket;
    }

    private final void fbc()
    {
        boolean flag = false;
        if(ddk != 0)
        {
            for(int i = 0; i < emc; i++)
            {
                int k = elm + 2;
                int i1 = eln + 27 + i * 15;
                if(super.flg <= k - 2 || super.flh <= i1 - 12 || super.flh >= i1 + 4 || super.flg >= (k - 3) + ema)
                    continue;
                feb(dmd[i]);
                break;
            }

            ddk = 0;
            dgi = false;
            return;
        }
        if(super.flg < elm - 10 || super.flh < eln - 10 || super.flg > elm + ema + 10 || super.flh > eln + emb + 10)
        {
            dgi = false;
            return;
        }
        dng.cbf(elm, eln, ema, emb, 0xd0d0d0, 160);
        dng.ceg("Choose option", elm + 2, eln + 12, 1, 65535);
        for(int j = 0; j < emc; j++)
        {
            int l = elm + 2;
            int j1 = eln + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.flg > l - 2 && super.flh > j1 - 12 && super.flh < j1 + 4 && super.flg < (l - 3) + ema)
                k1 = 0xffff00;
            dng.ceg(ehb[dmd[j]] + " " + eii[dmd[j]], l, j1, 1, k1);
        }

    }

    private final void fbd(int i, int j, int k)
    {
        dng.cbl(i, j, k);
        dng.cbl(i - 1, j, k);
        dng.cbl(i + 1, j, k);
        dng.cbl(i, j - 1, k);
        dng.cbl(i, j + 1, k);
    }

    private final void fbe()
    {
        dng.cbh(126, 137, 260, 60, 0);
        dng.cbi(126, 137, 260, 60, 0xffffff);
        dng.cee("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void fbf()
    {
        boolean flag = false;
        dln = new gca(dng, 50);
        int i = 40;
        if(!ech)
        {
            dln.ggj(256, 240, "@ran@Welcome to Teh_Bot!", 5, true);
            dln.ggk(156, 280, 120, 35);
            dln.ggk(356, 280, 120, 35);
            dln.ggj(156, 280, "New User", 5, false);
            dln.ggj(356, 280, "Existing User", 5, false);
            djj = dln.ghd(156, 280, 120, 35);
            djk = dln.ghd(356, 280, 120, 35);
        } else
        {
            dln.ggj(256, 240, "Welcome to Teh_Bot", 4, true);
            dln.ggj(256, 255, "You need a member account to use this server", 4, true);
            dln.ggk(256, 290, 200, 35);
            dln.ggj(256, 290, "Click here to login", 5, false);
            djk = dln.ghd(256, 290, 200, 35);
        }
        dni = new gca(dng, 50);
        i = 230;
        if(deb == 0)
        {
            dni.ggj(256, 238, "To create an account please go back to the", 4, true);
            i += 20;
            dni.ggj(256, 258, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(deb == 1)
        {
            dni.ggj(256, 238, "To create an account please click on the", 4, true);
            i += 20;
            dni.ggj(256, 258, "'create account' link below the game window", 4, true);
        } else
        {
            dni.ggj(256, 238, "To create an account please go back to the", 4, true);
            i += 20;
            dni.ggj(256, 258, "runescape front webpage and choose 'create account'", 4, true);
        }
        i += 30;
        dni.ggk(256, 297, 150, 34);
        dni.ggj(256, 297, "Login", 5, false);
        ded = dni.ghd(256, 297, 150, 34);
        djl = new gca(dng, 50);
        i = 230;
        dfg = djl.ggj(256, 220, "Please enter your username and password", 4, true);
        i += 28;
        djl.ggk(140, 258, 200, 40);
        djl.ggj(140, 248, "Username:", 4, false);
        dfh = djl.ghb(140, 268, 200, 40, 4, 12, false, false);
        i += 47;
        djl.ggk(190, 305, 200, 40);
        djl.ggj(190, 295, "Password:", 4, false);
        dfi = djl.ghb(190, 315, 200, 40, 4, 20, true, false);
        i -= 55;
        djl.ggk(410, 250, 120, 25);
        djl.ggj(410, 250, "Login", 4, false);
        dfj = djl.ghd(410, 250, 120, 25);
        i += 30;
        djl.ggk(410, 280, 120, 25);
        djl.ggj(410, 280, "Cancel", 4, false);
        dfk = djl.ghd(410, 280, 120, 25);
        i += 30;
        djl.ghm(dfh);
    }

    private final void fbg(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dng)).bln - 199;
        int j = 36;
        dng.cci(i - 49, 3, dkn + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = 0xa0a0a0;
        if(eib == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        dng.cbf(i, 36, 98, 24, k, 128);
        dng.cbf(i + 98, 36, 98, 24, l, 128);
        dng.cbf(i, 60, 196, 90, 0xdcdcdc, 128);
        dng.cbf(i, 150, 196, 68, 0xa0a0a0, 128);
        dng.cbj(i, 60, 196, 0);
        dng.cbk(i + 98, 36, 24, 0);
        dng.cbj(i, 149, 196, 0);
        dng.cee("Magic", i + 49, 52, 4, 0);
        dng.cee("Prayers", i + 49 + 98, 52, 4, 0);
        if(eib == 0)
        {
            ehn.ghe(eia);
            int i1 = 0;
            for(int i2 = 0; i2 < ahd.aii; i2++)
            {
                String s = "@yel@";
                for(int l3 = 0; l3 < ahd.ahf[i2]; l3++)
                {
                    int k4 = ahd.ahh[i2][l3];
                    if(ffd(k4, ahd.ahi[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }

                int l4 = eie[6];
                if(ahd.ahe[i2] > l4)
                    s = "@bla@";
                ehn.ghg(eia, i1++, s + "Level " + ahd.ahe[i2] + ": " + ahd.aij[i2]);
            }

            ehn.gfj();
            int i3 = ehn.ghn(eia);
            if(i3 != -1)
            {
                dng.ceg("Level " + ahd.ahe[i3] + ": " + ahd.aij[i3], i + 2, 160, 1, 0xffff00);
                dng.ceg(ahd.aik[i3], i + 2, 172, 0, 0xffffff);
                for(int i4 = 0; i4 < ahd.ahf[i3]; i4++)
                {
                    int i5 = ahd.ahh[i3][i4];
                    dng.cci(i + 2 + i4 * 44, 186, dlb + ahd.ajd[i5]);
                    int j5 = fdm(i5);
                    int k5 = ahd.ahi[i3][i4];
                    String s2 = "@red@";
                    if(ffd(i5, k5))
                        s2 = "@gre@";
                    dng.ceg(s2 + j5 + "/" + k5, i + 2 + i4 * 44, 186, 1, 0xffffff);
                }

            } else
            {
                dng.ceg("Point at a spell for a description", i + 2, 160, 1, 0);
            }
        }
        if(eib == 1)
        {
            ehn.ghe(eia);
            int j1 = 0;
            for(int j2 = 0; j2 < ahd.ajb; j2++)
            {
                String s1 = "@whi@";
                if(ahd.aim[j2] > dnk[5])
                    s1 = "@bla@";
                if(djb[j2])
                    s1 = "@gre@";
                ehn.ghg(eia, j1++, s1 + "Level " + ahd.aim[j2] + ": " + ahd.aia[j2]);
            }

            ehn.gfj();
            int j3 = ehn.ghn(eia);
            if(j3 != -1)
            {
                dng.cee("Level " + ahd.aim[j3] + ": " + ahd.aia[j3], i + 98, 166, 1, 0xffff00);
                dng.cee(ahd.aib[j3], i + 98, 181, 0, 0xffffff);
                dng.cee("Drain rate: " + ahd.ain[j3], i + 98, 196, 1, 0);
            } else
            {
                dng.ceg("Point at a prayer for a description", i + 2, 160, 1, 0);
            }
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            ehn.gfg(i + (((blm) (dng)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && ddk == 1)
                if(i < 98 && eib == 1)
                {
                    eib = 0;
                    ehn.ghf(eia);
                } else
                if(i > 98 && eib == 0)
                {
                    eib = 1;
                    ehn.ghf(eia);
                }
            if(ddk == 1 && eib == 0)
            {
                int k1 = ehn.ghn(eia);
                if(k1 != -1)
                {
                    int k2 = eie[6];
                    if(ahd.ahe[k1] > k2)
                    {
                        enl("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k3;
                        for(k3 = 0; k3 < ahd.ahf[k1]; k3++)
                        {
                            int j4 = ahd.ahh[k1][k3];
                            if(ffd(j4, ahd.ahi[k1][k3]))
                                continue;
                            enl("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }

                        if(k3 == ahd.ahf[k1])
                        {
                            eca = k1;
                            dgb = -1;
                        }
                    }
                }
            }
            if(ddk == 1 && eib == 1)
            {
                int l1 = ehn.ghn(eia);
                if(l1 != -1)
                {
                    int l2 = dnk[5];
                    if(ahd.aim[l1] > l2)
                        enl("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(eie[5] == 0)
                        enl("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(djb[l1])
                    {
                        super.aah.hfc(122);
                        super.aah.hfj(l1);
                        super.aah.hem();
                        djb[l1] = false;
                        fbm("prayeroff");
                    } else
                    {
                        super.aah.hfc(187);
                        super.aah.hfj(l1);
                        super.aah.hem();
                        djb[l1] = true;
                        fbm("prayeron");
                    }
                }
            }
            ddk = 0;
        }
    }

    public final URL getCodeBase()
    {
        return super.getCodeBase();
    }

    private final void fbh()
    {
        if(ddk != 0)
        {
            ddk = 0;
            if(djc == 1 && (super.flg < 106 || super.flh < 145 || super.flg > 406 || super.flh > 215))
            {
                djc = 0;
                return;
            }
            if(djc == 2 && (super.flg < 6 || super.flh < 145 || super.flg > 506 || super.flh > 215))
            {
                djc = 0;
                return;
            }
            if(djc == 3 && (super.flg < 106 || super.flh < 145 || super.flg > 406 || super.flh > 215))
            {
                djc = 0;
                return;
            }
            if(super.flg > 236 && super.flg < 276 && super.flh > 193 && super.flh < 213)
            {
                djc = 0;
                return;
            }
        }
        int i = 145;
        if(djc == 1)
        {
            dng.cbh(106, 145, 300, 70, 0);
            dng.cbi(106, 145, 300, 70, 0xffffff);
            i += 20;
            dng.cee("Enter name to add to friends list", 256, 165, 4, 0xffffff);
            i += 20;
            dng.cee(super.fln + "*", 256, 185, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s = super.fma.trim();
                super.fln = "";
                super.fma = "";
                djc = 0;
                if(s.length() > 0 && fnf.gag(s) != ejk.gnn)
                    ack(s);
            }
        }
        if(djc == 2)
        {
            dng.cbh(6, i, 500, 70, 0);
            dng.cbi(6, i, 500, 70, 0xffffff);
            i += 20;
            dng.cee("Enter message to send to " + fnf.gah(ekd), 256, i, 4, 0xffffff);
            i += 20;
            dng.cee(super.fmb + "*", 256, i, 4, 0xffffff);
            if(super.fmc.length() > 0)
            {
                String s1 = super.fmc;
                super.fmb = "";
                super.fmc = "";
                djc = 0;
                int k = cen.cfe(s1);
                acm(ekd, cen.cfa, k);
                s1 = cen.cfd(cen.cfa, 0, k);
                s1 = ffn.fhe(s1);
                adh("@pri@You tell " + fnf.gah(ekd) + ": " + s1);
            }
        }
        if(djc == 3)
        {
            dng.cbh(106, i, 300, 70, 0);
            dng.cbi(106, i, 300, 70, 0xffffff);
            i += 20;
            dng.cee("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            dng.cee(super.fln + "*", 256, i, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s2 = super.fma.trim();
                super.fln = "";
                super.fma = "";
                djc = 0;
                if(s2.length() > 0 && fnf.gag(s2) != ejk.gnn)
                    aci(s2);
            }
        }
        int j = 0xffffff;
        if(super.flg > 236 && super.flg < 276 && super.flh > 193 && super.flh < 213)
            j = 0xffff00;
        dng.cee("Cancel", 256, 208, 1, j);
    }

    private final void fbi()
    {
        boolean flag = false;
        if(ddk != 0)
        {
            for(int i = 0; i < ddl; i++)
            {
                if(super.flg >= dng.cem(ece[i], 1) || super.flh <= i * 12 || super.flh >= 12 + i * 12)
                    continue;
                super.aah.hfc(163);
                super.aah.hfj(i);
                super.aah.hem();
                break;
            }

            ddk = 0;
            dhk = false;
            return;
        }
        for(int j = 0; j < ddl; j++)
        {
            int k = 65535;
            if(super.flg < dng.cem(ece[j], 1) && super.flh > j * 12 && super.flh < 12 + j * 12)
                k = 0xff0000;
            dng.ceg(ece[j], 6, 12 + j * 12, 1, k);
        }

    }

    private final void fbj()
    {{
        boolean flag = false;
        int i = 65;
        if(efd != 201)
            i += 60;
        if(dnc > 0)
            i += 60;
        if(elk != 0)
            i += 45;
        int j = 167 - i / 2;
        dng.cbh(56, 167 - i / 2, 400, i, 0);
        dng.cbi(56, 167 - i / 2, 400, i, 0xffffff);
        j += 20;
        dng.cee("@red@Welcome to Teh_Bot " + eld, 256, j, 4, 0xffff00);
        j += 30;
        String s;
        if(dik == 0)
            s = "earlier today";
        else
        if(dik == 1)
            s = "yesterday";
        else
            s = dik + " days ago";
        if(elk != 0)
        {
            dng.cee("You last logged in " + s, 256, j, 1, 0xffffff);
            j += 15;
            if(edn == null)
                edn = fde(elk);
            dng.cee("from: " + edn, 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(dnc > 0)
        {
            int k = 0xffffff;
            dng.cee("Jagex staff will NEVER email you. We use the", 256, j, 1, 0xffffff);
            j += 15;
            dng.cee("message-centre on this website instead.", 256, j, 1, 0xffffff);
            j += 15;
            if(dnc == 1)
                dng.cee("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
            else
                dng.cee("You have @gre@" + (dnc - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(efd != 201)
        {
            if(efd == 200)
            {
                dng.cee("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
                j += 15;
                dng.cee("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
                j += 15;
                dng.cee("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            } else
            {
                String s1;
                if(efd == 0)
                    s1 = "Earlier today";
                else
                if(efd == 1)
                    s1 = "Yesterday";
                else
                    s1 = efd + " days ago";
                dng.cee(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
                j += 15;
                dng.cee("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
                j += 15;
                dng.cee("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            }
            j += 15;
        }
        int l = 0xffffff;
        if(super.flh > j - 12 && super.flh <= j && super.flg > 106 && super.flg < 406)
            l = 0xff0000;
        dng.cee("Click here to close window", 256, j, 1, l);
        if(ddk == 1)
        {
            if(l == 0xff0000)
                dha = false;
            if((super.flg < 86 || super.flg > 426) && (super.flh < 167 - i / 2 || super.flh > 167 + i / 2))
                dha = false;
        }
        ddk = 0;
    }
}

    private final void fbk()
    {
        boolean flag2 = false;
        if(ddk != 0 && ecl == 0)
            ecl = 1;
        if(ecl > 0)
        {
            int i = super.flg - 22;
            int j = super.flh - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < ena)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = enb[k];
                        for(int k3 = 0; k3 < dme; k3++)
                            if(dmf[k3] == k2)
                                if(ahd.ajf[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ecl; i4++)
                                    {
                                        if(dmg[k3] < enc[k])
                                            dmg[k3]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(fdm(k2) <= l1)
                            flag1 = true;
                        if(ahd.ajj[k2] == 1)
                        {
                            enl("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && dme < 8)
                        {
                            dmf[dme] = k2;
                            dmg[dme] = 1;
                            dme++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aah.hfc(253);
                            super.aah.hfj(dme);
                            for(int j4 = 0; j4 < dme; j4++)
                            {
                                super.aah.hfl(dmf[j4]);
                                super.aah.hfi(dmg[j4]);
                            }

                            super.aah.hem();
                            dma = false;
                            dmb = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < dme)
                    {
                        int j1 = dmf[l];
                        for(int i2 = 0; i2 < ecl; i2++)
                        {
                            if(ahd.ajf[j1] == 0 && dmg[l] > 1)
                            {
                                dmg[l]--;
                                continue;
                            }
                            dme--;
                            eck = 0;
                            for(int l2 = l; l2 < dme; l2++)
                            {
                                dmf[l2] = dmf[l2 + 1];
                                dmg[l2] = dmg[l2 + 1];
                            }

                            break;
                        }

                        super.aah.hfc(253);
                        super.aah.hfj(dme);
                        for(int i3 = 0; i3 < dme; i3++)
                        {
                            super.aah.hfl(dmf[i3]);
                            super.aah.hfi(dmg[i3]);
                        }

                        super.aah.hem();
                        dma = false;
                        dmb = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232)
                {
                    dem = !dem;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251)
                {
                    den = !den;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232)
                {
                    dfa = !dfa;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251)
                {
                    dfb = !dfb;
                    flag = true;
                }
                if(flag)
                {
                    super.aah.hfc(234);
                    super.aah.hfj(dem ? 1 : 0);
                    super.aah.hfj(den ? 1 : 0);
                    super.aah.hfj(dfa ? 1 : 0);
                    super.aah.hfj(dfb ? 1 : 0);
                    super.aah.hem();
                    dma = false;
                    dmb = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    dmb = true;
                    super.aah.hfc(50);
                    super.aah.hem();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    eeb = false;
                    super.aah.hfc(191);
                    super.aah.hem();
                }
            } else
            if(ddk != 0)
            {
                eeb = false;
                super.aah.hfc(191);
                super.aah.hem();
            }
            ddk = 0;
            ecl = 0;
        }
        if(!eeb)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dng.cbh(22, 36, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        dng.cbf(22, 48, 468, 18, 0x989898, 160);
        dng.cbf(22, 66, 8, 248, 0x989898, 160);
        dng.cbf(227, 66, 11, 248, 0x989898, 160);
        dng.cbf(484, 66, 6, 248, 0x989898, 160);
        dng.cbf(30, 135, 197, 24, 0x989898, 160);
        dng.cbf(30, 228, 197, 23, 0x989898, 160);
        dng.cbf(30, 294, 197, 20, 0x989898, 160);
        dng.cbf(238, 271, 246, 43, 0x989898, 160);
        int k1 = 0xd0d0d0;
        dng.cbf(30, 66, 197, 69, 0xd0d0d0, 160);
        dng.cbf(30, 159, 197, 69, 0xd0d0d0, 160);
        dng.cbf(30, 251, 197, 43, 0xd0d0d0, 160);
        dng.cbf(238, 66, 246, 205, 0xd0d0d0, 160);
        for(int j2 = 0; j2 < 3; j2++)
            dng.cbj(30, 66 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 3; j3++)
            dng.cbj(30, 159 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            dng.cbj(238, 66 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                dng.cbk(30 + k4 * 49, 66, 69, 0);
            if(k4 < 5)
                dng.cbk(30 + k4 * 49, 159, 69, 0);
            dng.cbk(238 + k4 * 49, 66, 205, 0);
        }

        dng.cbj(30, 251, 197, 0);
        dng.cbj(30, 293, 197, 0);
        dng.cbk(30, 251, 43, 0);
        dng.cbk(226, 251, 43, 0);
        dng.ceg("Preparing to duel with: " + dfn, 23, 46, 1, 0xffffff);
        dng.ceg("Your Stake", 31, 63, 4, 0xffffff);
        dng.ceg("Opponent's Stake", 31, 156, 4, 0xffffff);
        dng.ceg("Duel Options", 31, 248, 4, 0xffffff);
        dng.ceg("Your Inventory", 238, 63, 4, 0xffffff);
        dng.ceg("No retreating", 31, 267, 3, 0xffff00);
        dng.ceg("No magic", 31, 286, 3, 0xffff00);
        dng.ceg("No prayer", 132, 267, 3, 0xffff00);
        dng.ceg("No weapons", 132, 286, 3, 0xffff00);
        dng.cbi(115, 257, 11, 11, 0xffff00);
        if(dem)
            dng.cbh(117, 259, 7, 7, 0xffff00);
        dng.cbi(115, 276, 11, 11, 0xffff00);
        if(den)
            dng.cbh(117, 278, 7, 7, 0xffff00);
        dng.cbi(213, 257, 11, 11, 0xffff00);
        if(dfa)
            dng.cbh(215, 259, 7, 7, 0xffff00);
        dng.cbi(213, 276, 11, 11, 0xffff00);
        if(dfb)
            dng.cbh(215, 278, 7, 7, 0xffff00);
        if(!dmb)
            dng.cci(239, 274, dkn + 25);
        dng.cci(416, 274, dkn + 26);
        if(dma)
        {
            dng.cee("Other player", 363, 282, 1, 0xffffff);
            dng.cee("has accepted", 363, 292, 1, 0xffffff);
        }
        if(dmb)
        {
            dng.cee("Waiting for", 274, 282, 1, 0xffffff);
            dng.cee("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < ena; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            dng.cdk(i5, k5, 48, 32, dlb + ahd.ajd[enb[l4]], ahd.aji[enb[l4]], 0, 0, false);
            if(ahd.ajf[enb[l4]] == 0)
                dng.ceg(String.valueOf(enc[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < dme; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            dng.cdk(l5, j6, 48, 32, dlb + ahd.ajd[dmf[j5]], ahd.aji[dmf[j5]], 0, 0, false);
            if(ahd.ajf[dmf[j5]] == 0)
                dng.ceg(String.valueOf(dmg[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.flg > l5 && super.flg < l5 + 48 && super.flh > j6 && super.flh < j6 + 32)
                dng.ceg(ahd.amb[dmf[j5]] + ": @whi@" + ahd.amc[dmf[j5]], 30, 309, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < ecb; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 160 + (i6 / 4) * 34;
            dng.cdk(k6, l6, 48, 32, dlb + ahd.ajd[ecc[i6]], ahd.aji[ecc[i6]], 0, 0, false);
            if(ahd.ajf[ecc[i6]] == 0)
                dng.ceg(String.valueOf(ecd[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.flg > k6 && super.flg < k6 + 48 && super.flh > l6 && super.flh < l6 + 32)
                dng.ceg(ahd.amb[ecc[i6]] + ": @whi@" + ahd.amc[ecc[i6]], 30, 309, 1, 0xffff00);
        }

    }

    final void fbl(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        boolean flag1 = false;
        gnm gnm1 = eml[i1];
        if(gnm1.hbl == 255)
            return;
        int l1 = gnm1.hah + (dml + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + dhf[(gnm1.hag / 6) % 4];
        if(gnm1.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = 15 + eai[(ean / 5) % 8];
        } else
        if(gnm1.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = 15 + emi[(ean / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = eha[l1][k2];
            int l3 = gnm1.han[l2] - 1;
            if(l3 >= 0)
            {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(ahd.aka[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1)
                    {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3)
                    {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1)
                    {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3)
                    {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + dhf[(2 + gnm1.hag / 6) % 4];
                    }
                if(i2 != 5 || ahd.ajn[l3] == 1)
                {
                    int k5 = j5 + ahd.akb[l3];
                    k4 = (k4 * k) / ((blm) (dng)).bnc[k5];
                    i5 = (i5 * l) / ((blm) (dng)).bnd[k5];
                    int l5 = (k * ((blm) (dng)).bnc[k5]) / ((blm) (dng)).bnc[ahd.akb[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = ahd.ajl[l3];
                    int j6 = ecn[gnm1.hbm];
                    if(i6 == 1)
                        i6 = ehj[gnm1.hbj];
                    else
                    if(i6 == 2)
                        i6 = eak[gnm1.hbk];
                    else
                    if(i6 == 3)
                        i6 = eak[gnm1.hbl];
                    dng.cdk(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }

        if(gnm1.hbb > 0)
        {
            dii[ejd] = dng.cem(gnm1.hba, 1) / 2;
            if(dii[ejd] > 150)
                dii[ejd] = 150;
            dij[ejd] = (dng.cem(gnm1.hba, 1) / 300) * dng.cek(1);
            dig[ejd] = i + k / 2;
            dih[ejd] = j;
            eje[ejd++] = gnm1.hba;
        }
        if(gnm1.hbd > 0)
        {
            edk[ehc] = i + k / 2;
            edl[ehc] = j;
            djd[ehc] = k1;
            dje[ehc++] = gnm1.hbc;
        }
        if(gnm1.hah == 8 || gnm1.hah == 9 || gnm1.hbh != 0)
        {
            if(gnm1.hbh > 0)
            {
                int i3 = i;
                if(gnm1.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (gnm1.hbf * 30) / gnm1.hbg;
                eke[dhl] = i3 + k / 2;
                ekf[dhl] = j;
                ekg[dhl++] = i4;
            }
            if(gnm1.hbh > 150)
            {
                int j3 = i;
                if(gnm1.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(gnm1.hah == 9)
                    j3 += (10 * k1) / 100;
                dng.cci((j3 + k / 2) - 12, (j + l / 2) - 12, dkn + 11);
                dng.cee(String.valueOf(gnm1.hbe), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(gnm1.hcf == 1 && gnm1.hbd == 0)
        {
            int k3 = j1 + i + k / 2;
            if(gnm1.hah == 8)
                k3 -= (20 * k1) / 100;
            else
            if(gnm1.hah == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            dng.ccj(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, dkn + 13);
        }
    }

    private final void fbm(String s)
    {
        if(dnl == null)
            return;
        if(dgh)
        {
            return;
        } else
        {
            dnl.gif(ejj, fnf.gai(s + ".pcm", ejj), fnf.gaj(s + ".pcm", ejj));
            return;
        }
    }

    private final void fbn()
    {
        dlm.gje = faf("maps" + cff.cfj + ".jag", "map", 70);
        if(ech)
            dlm.gjj = faf("maps" + cff.cfj + ".mem", "members map", 75);
        dlm.gjd = faf("land" + cff.cfj + ".jag", "landscape", 80);
        if(ech)
            dlm.gji = faf("land" + cff.cfj + ".mem", "members landscape", 85);
    }

    private final void fca()
    {
        boolean flag = false;
        int i = 2203 - (ejm + edb + dna);
        if(ejl + eda + dmn >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < eif; k++)
            ddi[k] = false;

        for(int l = 0; l < eim; l++)
            dja[l] = false;

        int i1 = egn.bhm();
        cgc acgc[] = egn.bia();
        int ai[] = egn.bhn();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(emc > 200)
                break;
            int k1 = ai[j1];
            cgc cgc1 = acgc[j1];
            if(cgc1.cih[k1] <= 65535 || cgc1.cih[k1] >= 0x30d40 && cgc1.cih[k1] <= 0x493e0)
                if(cgc1 == egn.bem)
                {
                    int i2 = cgc1.cih[k1] % 10000;
                    int l2 = cgc1.cih[k1] / 10000;
                    if(l2 == 1)
                    {
                        String s = "";
                        int k3 = 0;
                        if(ejk.hbi > 0 && eml[i2].hbi > 0)
                            k3 = ejk.hbi - eml[i2].hbi;
                        if(k3 < 0)
                            s = "@or1@";
                        if(k3 < -3)
                            s = "@or2@";
                        if(k3 < -6)
                            s = "@or3@";
                        if(k3 < -9)
                            s = "@red@";
                        if(k3 > 0)
                            s = "@gr1@";
                        if(k3 > 3)
                            s = "@gr2@";
                        if(k3 > 6)
                            s = "@gr3@";
                        if(k3 > 9)
                            s = "@gre@";
                        s = " " + s + "(level-" + eml[i2].hbi + ")";
                        if(eca >= 0)
                        {
                            if(ahd.ahg[eca] == 1 || ahd.ahg[eca] == 2)
                            {
                                ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                                eii[emc] = "@whi@" + eml[i2].haa + s;
                                dne[emc] = 800;
                                eef[emc] = eml[i2].had;
                                eeg[emc] = eml[i2].hae;
                                edg[emc] = eml[i2].hab;
                                edh[emc] = eca;
                                emc++;
                            }
                        } else
                        if(dgb >= 0)
                        {
                            ehb[emc] = "Use " + dgc + " with";
                            eii[emc] = "@whi@" + eml[i2].haa + s;
                            dne[emc] = 810;
                            eef[emc] = eml[i2].had;
                            eeg[emc] = eml[i2].hae;
                            edg[emc] = eml[i2].hab;
                            edh[emc] = dgb;
                            emc++;
                        } else
                        {
                            if(i > 0 && (eml[i2].hae - 64) / eic + edb + dna < 2203)
                            {
                                ehb[emc] = "Attack";
                                eii[emc] = "@gre@" + eml[i2].haa + s;
                                if(k3 >= 0 && k3 < 5)
                                    dne[emc] = 805;
                                else
                                    dne[emc] = 805;
                                eef[emc] = eml[i2].had;
                                eeg[emc] = eml[i2].hae;
                                edg[emc] = eml[i2].hab;
                                emc++;
                            } else
                            if(ech)
                            {
                                ehb[emc] = "Duel with";
                                eii[emc] = "@gre@" + eml[i2].haa + s;
                                eef[emc] = eml[i2].had;
                                eeg[emc] = eml[i2].hae;
                                dne[emc] = 2806;
                                edg[emc] = eml[i2].hab;
                                emc++;
                            }
                            ehb[emc] = "Trade with";
                            eii[emc] = "@gre@" + eml[i2].haa + s;
                            dne[emc] = 2810;
                            edg[emc] = eml[i2].hab;
                            emc++;
                            ehb[emc] = "Follow";
                            eii[emc] = "@gre@" + eml[i2].haa + s;
                            dne[emc] = 2820;
                            edg[emc] = eml[i2].hab;
                            emc++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(eca >= 0)
                        {
                            if(ahd.ahg[eca] == 3)
                            {
                                ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                                eii[emc] = "@lre@" + ahd.amb[djh[i2]];
                                dne[emc] = 200;
                                eef[emc] = djf[i2];
                                eeg[emc] = djg[i2];
                                edg[emc] = djh[i2];
                                edh[emc] = eca;
                                emc++;
                            }
                        } else
                        if(dgb >= 0)
                        {
                            ehb[emc] = "Use " + dgc + " with";
                            eii[emc] = "@lre@" + ahd.amb[djh[i2]];
                            dne[emc] = 210;
                            eef[emc] = djf[i2];
                            eeg[emc] = djg[i2];
                            edg[emc] = djh[i2];
                            edh[emc] = dgb;
                            emc++;
                        } else
                        {
                            ehb[emc] = "Take";
                            eii[emc] = "@lre@" + ahd.amb[djh[i2]];
                            dne[emc] = 220;
                            eef[emc] = djf[i2];
                            eeg[emc] = djg[i2];
                            edg[emc] = djh[i2];
                            emc++;
                            ehb[emc] = "Examine";
                            eii[emc] = "@lre@" + ahd.amb[djh[i2]];
                            dne[emc] = 3200;
                            edg[emc] = djh[i2];
                            emc++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = dif[i2].haf;
                        if(ahd.ahn[i4] > 0)
                        {
                            int j4 = (ahd.ahj[i4] + ahd.ahm[i4] + ahd.ahk[i4] + ahd.ahl[i4]) / 4;
                            int k4 = (dnk[0] + dnk[1] + dnk[2] + dnk[3] + 27) / 4;
                            l3 = k4 - j4;
                            s1 = "@yel@";
                            if(l3 < 0)
                                s1 = "@or1@";
                            if(l3 < -3)
                                s1 = "@or2@";
                            if(l3 < -6)
                                s1 = "@or3@";
                            if(l3 < -9)
                                s1 = "@red@";
                            if(l3 > 0)
                                s1 = "@gr1@";
                            if(l3 > 3)
                                s1 = "@gr2@";
                            if(l3 > 6)
                                s1 = "@gr3@";
                            if(l3 > 9)
                                s1 = "@gre@";
                            s1 = " " + s1 + "(level-" + j4 + ")";
                        }
                        if(eca >= 0)
                        {
                            if(ahd.ahg[eca] == 2)
                            {
                                ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                                eii[emc] = "@yel@" + ahd.amn[dif[i2].haf];
                                dne[emc] = 700;
                                eef[emc] = dif[i2].had;
                                eeg[emc] = dif[i2].hae;
                                edg[emc] = dif[i2].hab;
                                edh[emc] = eca;
                                emc++;
                            }
                        } else
                        if(dgb >= 0)
                        {
                            ehb[emc] = "Use " + dgc + " with";
                            eii[emc] = "@yel@" + ahd.amn[dif[i2].haf];
                            dne[emc] = 710;
                            eef[emc] = dif[i2].had;
                            eeg[emc] = dif[i2].hae;
                            edg[emc] = dif[i2].hab;
                            edh[emc] = dgb;
                            emc++;
                        } else
                        {
                            if(ahd.ahn[i4] > 0)
                            {
                                ehb[emc] = "Attack";
                                eii[emc] = "@red@" + ahd.amn[dif[i2].haf] + s1;
                                if(l3 >= 0)
                                    dne[emc] = 715;
                                else
                                    dne[emc] = 715;
                                eef[emc] = dif[i2].had;
                                eeg[emc] = dif[i2].hae;
                                edg[emc] = dif[i2].hab;
                                emc++;
                            }
                            ehb[emc] = "Talk-to";
                            eii[emc] = "@red@" + ahd.amn[dif[i2].haf];
                            dne[emc] = 720;
                            eef[emc] = dif[i2].had;
                            eeg[emc] = dif[i2].hae;
                            edg[emc] = dif[i2].hab;
                            emc++;
                            if(!ahd.anb[i4].equals(""))
                            {
                                ehb[emc] = ahd.anb[i4];
                                eii[emc] = "@red@" + ahd.amn[dif[i2].haf];
                                dne[emc] = 725;
                                eef[emc] = dif[i2].had;
                                eeg[emc] = dif[i2].hae;
                                edg[emc] = dif[i2].hab;
                                emc++;
                            }
                            ehb[emc] = "Examine";
                            eii[emc] = "@red@" + ahd.amn[dif[i2].haf];
                            dne[emc] = 3700;
                            edg[emc] = dif[i2].haf;
                            emc++;
                        }
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 10000)
                {
                    int j2 = cgc1.cig - 10000;
                    int i3 = emh[j2];
                    if(!dja[j2])
                    {
                        if(eca >= 0)
                        {
                            if(ahd.ahg[eca] == 4)
                            {
                                ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                                eii[emc] = "@cya@" + ahd.akl[i3];
                                dne[emc] = 300;
                                eef[emc] = ddm[j2];
                                eeg[emc] = ddn[j2];
                                edg[emc] = emg[j2];
                                edh[emc] = eca;
                                emc++;
                            }
                        } else
                        if(dgb >= 0)
                        {
                            ehb[emc] = "Use " + dgc + " with";
                            eii[emc] = "@cya@" + ahd.akl[i3];
                            dne[emc] = 310;
                            eef[emc] = ddm[j2];
                            eeg[emc] = ddn[j2];
                            edg[emc] = emg[j2];
                            edh[emc] = dgb;
                            emc++;
                        } else
                        {
                            if(!ahd.akn[i3].equalsIgnoreCase("WalkTo"))
                            {
                                ehb[emc] = ahd.akn[i3];
                                eii[emc] = "@cya@" + ahd.akl[i3];
                                dne[emc] = 320;
                                eef[emc] = ddm[j2];
                                eeg[emc] = ddn[j2];
                                edg[emc] = emg[j2];
                                emc++;
                            }
                            if(!ahd.ala[i3].equalsIgnoreCase("Examine"))
                            {
                                ehb[emc] = ahd.ala[i3];
                                eii[emc] = "@cya@" + ahd.akl[i3];
                                dne[emc] = 2300;
                                eef[emc] = ddm[j2];
                                eeg[emc] = ddn[j2];
                                edg[emc] = emg[j2];
                                emc++;
                            }
                            ehb[emc] = "Examine";
                            eii[emc] = "@cya@" + ahd.akl[i3];
                            dne[emc] = 3300;
                            edg[emc] = i3;
                            emc++;
                        }
                        dja[j2] = true;
                    }
                } else
                if(cgc1 != null && cgc1.cig >= 0)
                {
                    int k2 = cgc1.cig;
                    int j3 = elb[k2];
                    if(!ddi[k2])
                    {
                        if(eca >= 0)
                        {
                            if(ahd.ahg[eca] == 5)
                            {
                                ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                                eii[emc] = "@cya@" + ahd.akh[j3];
                                dne[emc] = 400;
                                eef[emc] = ekn[k2];
                                eeg[emc] = ela[k2];
                                edg[emc] = elc[k2];
                                edh[emc] = elb[k2];
                                edi[emc] = eca;
                                emc++;
                            }
                        } else
                        if(dgb >= 0)
                        {
                            ehb[emc] = "Use " + dgc + " with";
                            eii[emc] = "@cya@" + ahd.akh[j3];
                            dne[emc] = 410;
                            eef[emc] = ekn[k2];
                            eeg[emc] = ela[k2];
                            edg[emc] = elc[k2];
                            edh[emc] = elb[k2];
                            edi[emc] = dgb;
                            emc++;
                        } else
                        {
                            if(!ahd.akj[j3].equalsIgnoreCase("WalkTo"))
                            {
                                ehb[emc] = ahd.akj[j3];
                                eii[emc] = "@cya@" + ahd.akh[j3];
                                dne[emc] = 420;
                                eef[emc] = ekn[k2];
                                eeg[emc] = ela[k2];
                                edg[emc] = elc[k2];
                                edh[emc] = elb[k2];
                                emc++;
                            }
                            if(!ahd.akk[j3].equalsIgnoreCase("Examine"))
                            {
                                ehb[emc] = ahd.akk[j3];
                                eii[emc] = "@cya@" + ahd.akh[j3];
                                dne[emc] = 2400;
                                eef[emc] = ekn[k2];
                                eeg[emc] = ela[k2];
                                edg[emc] = elc[k2];
                                edh[emc] = elb[k2];
                                emc++;
                            }
                            ehb[emc] = "Examine";
                            eii[emc] = "@cya@" + ahd.akh[j3];
                            dne[emc] = 3400;
                            edg[emc] = j3;
                            emc++;
                        }
                        ddi[k2] = true;
                    }
                } else
                {
                    if(k1 >= 0)
                        k1 = cgc1.cih[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(eca >= 0 && ahd.ahg[eca] <= 1)
        {
            ehb[emc] = "Cast " + ahd.aij[eca] + " on self";
            eii[emc] = "";
            dne[emc] = 1000;
            edg[emc] = eca;
            emc++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(eca >= 0)
            {
                if(ahd.ahg[eca] == 6)
                {
                    ehb[emc] = "Cast " + ahd.aij[eca] + " on ground";
                    eii[emc] = "";
                    dne[emc] = 900;
                    eef[emc] = dlm.gjn[l1];
                    eeg[emc] = dlm.gjh[l1];
                    edg[emc] = eca;
                    emc++;
                    return;
                }
            } else
            if(dgb < 0)
            {
                ehb[emc] = "Walk here";
                eii[emc] = "";
                dne[emc] = 920;
                eef[emc] = dlm.gjn[l1];
                eeg[emc] = dlm.gjh[l1];
                emc++;
            }
        }
    }

    protected final void adf()
    {
        dmm = 0;
        enl("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void fcb()
    {
        boolean flag = false;
        if((dim & 1) == 1 && ffa(dim))
            return;
        if((dim & 1) == 0 && ffa(dim))
        {
            if(ffa(dim + 1 & 7))
            {
                dim = dim + 1 & 7;
                return;
            }
            if(ffa(dim + 7 & 7))
                dim = dim + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++)
        {
            if(!ffa(dim + ai[i] + 8 & 7))
                continue;
            dim = dim + ai[i] + 8 & 7;
            break;
        }

        if((dim & 1) == 0 && ffa(dim))
        {
            if(ffa(dim + 1 & 7))
            {
                dim = dim + 1 & 7;
                return;
            }
            if(ffa(dim + 7 & 7))
                dim = dim + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    private final void fcc(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = ahd.ami[l];
            j1 = ahd.amj[l];
        } else
        {
            j1 = ahd.ami[l];
            i1 = ahd.amj[l];
        }
        if(ahd.amk[l] == 2 || ahd.amk[l] == 3)
        {
            if(k == 0)
            {
                i--;
                i1++;
            }
            if(k == 2)
                j1++;
            if(k == 4)
                i1++;
            if(k == 6)
            {
                j--;
                j1++;
            }
            fce(ejl, ejm, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            fce(ejl, ejm, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    private final void fcd()
    {
        eij = new gca(dng, 100);
        eij.ggj(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        eij.ggj(201, 134, "Front", 3, true);
        eij.ggj(256, 134, "Side", 3, true);
        eij.ggj(311, 134, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        eij.ggl(202, 169, 53, 41);
        eij.ggj(202, 161, "Head", 1, true);
        eij.ggj(202, 177, "Type", 1, true);
        eij.ggm(162, 169, gca.gfa + 7);
        ebb = eij.ghd(162, 169, 20, 20);
        eij.ggm(242, 169, gca.gfa + 6);
        ebc = eij.ghd(242, 169, 20, 20);
        eij.ggl(310, 169, 53, 41);
        eij.ggj(310, 161, "Hair", 1, true);
        eij.ggj(310, 177, "Color", 1, true);
        eij.ggm(270, 169, gca.gfa + 7);
        ebd = eij.ghd(270, 169, 20, 20);
        eij.ggm(350, 169, gca.gfa + 6);
        ebe = eij.ghd(350, 169, 20, 20);
        j += 50;
        eij.ggl(202, 219, 53, 41);
        eij.ggj(202, 219, "Gender", 1, true);
        eij.ggm(162, 219, gca.gfa + 7);
        ebf = eij.ghd(162, 219, 20, 20);
        eij.ggm(242, 219, gca.gfa + 6);
        ebg = eij.ghd(242, 219, 20, 20);
        eij.ggl(310, 219, 53, 41);
        eij.ggj(310, 211, "Top", 1, true);
        eij.ggj(310, 227, "Color", 1, true);
        eij.ggm(270, 219, gca.gfa + 7);
        ebh = eij.ghd(270, 219, 20, 20);
        eij.ggm(350, 219, gca.gfa + 6);
        ebi = eij.ghd(350, 219, 20, 20);
        j += 50;
        eij.ggl(202, 269, 53, 41);
        eij.ggj(202, 261, "Skin", 1, true);
        eij.ggj(202, 277, "Color", 1, true);
        eij.ggm(162, 269, gca.gfa + 7);
        ebj = eij.ghd(162, 269, 20, 20);
        eij.ggm(242, 269, gca.gfa + 6);
        ebk = eij.ghd(242, 269, 20, 20);
        eij.ggl(310, 269, 53, 41);
        eij.ggj(310, 261, "Bottom", 1, true);
        eij.ggj(310, 277, "Color", 1, true);
        eij.ggm(270, 269, gca.gfa + 7);
        ebl = eij.ghd(270, 269, 20, 20);
        eij.ggm(350, 269, gca.gfa + 6);
        ebm = eij.ghd(350, 269, 20, 20);
        j += 82;
        j -= 35;
        eij.ggk(256, 316, 200, 30);
        eij.ggj(256, 316, "Accept", 4, false);
        ebn = eij.ghd(256, 316, 200, 30);
    }

    private final boolean fce(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = dlm.gln(i, j, k, l, i1, j1, dmh, dmi, flag);
        if(k1 == -1)
            if(flag1)
            {
                k1 = 1;
                dmh[0] = k;
                dmi[0] = l;
            } else
            {
                return false;
            }
        k1--;
        i = dmh[k1];
        j = dmi[k1];
        k1--;
        if(flag1)
            super.aah.hfc(135);
        else
            super.aah.hfc(209);
        super.aah.hfl(i + dmn);
        super.aah.hfl(j + dna);
        if(flag1 && k1 == -1 && (i + dmn) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aah.hfj(dmh[l1] - i);
            super.aah.hfj(dmi[l1] - j);
        }

        super.aah.hem();
        efg = -24;
        efh = super.flg;
        efi = super.flh;
        return true;
    }

    private final boolean fcf(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        boolean flag2 = false;
        int k1 = dlm.gln(i, j, k, l, i1, j1, dmh, dmi, flag);
        if(k1 == -1)
            return false;
        k1--;
        i = dmh[k1];
        j = dmi[k1];
        k1--;
        if(flag1)
            super.aah.hfc(135);
        else
            super.aah.hfc(209);
        super.aah.hfl(i + dmn);
        super.aah.hfl(j + dna);
        if(flag1 && k1 == -1 && (i + dmn) % 5 == 0)
            k1 = 0;
        for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
        {
            super.aah.hfj(dmh[l1] - i);
            super.aah.hfj(dmi[l1] - j);
        }

        super.aah.hem();
        efg = -24;
        efh = super.flg;
        efi = super.flh;
        return true;
    }

    private final void fcg()
    {
        boolean flag1 = false;
        if(dmm != 0){
            fbe();
	if autologin=true aca(eld, ele, false);
	else autologin = false}
       	else
        if(dgn)
            fed();
        else
        if(dgn)
            fed();
        else
        if(emn == 1)
            enh();
        else
        if(dnf && edj == 0)
            fdg();
        else
        if(eec && edj == 0)
            fae();
        else
        if(dfd)
            fcj();
        else
        if(dmk)
            fck();
        else
        if(dkl)
            fai();
        else
        if(eeb)
            fbk();
        else
        if(egm == 1)
            fag();
        else
        if(egm == 2)
            fdd();
        else
        if(djc != 0)
        {
            fbh();
        } else
        {
            if(dhk)
                fbi();
            if(ejk.hah == 8 || ejk.hah == 9)
                fee();
            fec();
            boolean flag = !dhk && !dgi;
            if(flag)
                emc = 0;
            if(egh == 0 && flag)
                fca();
            if(egh == 1)
                fdf(flag);
            if(egh == 2)
                ffe(flag);
            if(egh == 3)
                fdl(flag);
            if(egh == 4)
                fbg(flag);
            if(egh == 5)
                enj(flag);
            if(egh == 6)
                enf(flag);
            if(!dgi && !dhk)
                fen();
            if(dgi && !dhk)
                fbc();
        }
        ddk = 0;
    }

    private final void fch()
    {
        boolean flag = false;
        egc = false;
        dng.bnj = false;
        dng.cbd();
        if(eed == 0 || eed == 1 || eed == 2 || eed == 3)
        {
            int i = (ean * 2) % 3072;
            if(i < 1024)
            {
                dng.cci(0, 10, dlf);
                if(i > 768)
                    dng.cck(0, 10, dlf + 1, i - 768);
            } else
            if(i < 2048)
            {
                dng.cci(0, 10, dlf + 1);
                if(i > 1792)
                    dng.cck(0, 10, dkn + 10, i - 1792);
            } else
            {
                dng.cci(0, 10, dkn + 10);
                if(i > 2816)
                    dng.cck(0, 10, dlf, i - 2816);
            }
        }
        if(eed == 0)
            dln.gfj();
        if(eed == 1)
            dni.gfj();
        if(eed == 2)
            djl.gfj();
        dng.cci(0, eli, dkn + 22);
        dng.cbc(dil, 0, 0);
    }

    protected final void adg(int i, int j, byte abyte0[])
    {
        boolean flag4 = false;
        try
        {
            if(i == 255)
            {
                dkb = dka;
                for(int k = 0; k < dkb; k++)
                    did[k] = eml[k];

                int k7 = 8;
                ejl = fnf.gad(abyte0, 8, 11);
                k7 += 11;
                ejm = fnf.gad(abyte0, 19, 13);
                k7 += 13;
                int l13 = fnf.gad(abyte0, 32, 4);
                k7 += 4;
                boolean flag1 = fej(ejl, ejm);
                ejl -= dmn;
                ejm -= dna;
                int l22 = ejl * eic + 64;
                int l25 = ejm * eic + 64;
                if(flag1)
                {
                    ejk.hak = 0;
                    ejk.haj = 0;
                    ejk.had = ejk.hal[0] = l22;
                    ejk.hae = ejk.ham[0] = l25;
                }
                dka = 0;
                ejk = fdn(ejn, l22, l25, l13);
                int i29 = fnf.gad(abyte0, 36, 8);
                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++)
                {
                    gnm gnm4 = did[l33 + 1];
                    int k39 = fnf.gad(abyte0, k7, 1);
                    k7++;
                    if(k39 != 0)
                    {
                        int k41 = fnf.gad(abyte0, k7, 1);
                        k7++;
                        if(k41 == 0)
                        {
                            int l42 = fnf.gad(abyte0, k7, 3);
                            k7 += 3;
                            int l43 = gnm4.hak;
                            int j44 = gnm4.hal[l43];
                            int k44 = gnm4.ham[l43];
                            if(l42 == 2 || l42 == 1 || l42 == 3)
                                j44 += eic;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= eic;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += eic;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= eic;
                            gnm4.hai = l42;
                            gnm4.hak = l43 = (l43 + 1) % 10;
                            gnm4.hal[l43] = j44;
                            gnm4.ham[l43] = k44;
                        } else
                        {
                            int i43 = fnf.gad(abyte0, k7, 4);
                            if((i43 & 0xc) == 12)
                            {
                                k7 += 2;
                                continue;
                            }
                            gnm4.hai = fnf.gad(abyte0, k7, 4);
                            k7 += 4;
                        }
                    }
                    eml[dka++] = gnm4;
                }

                int i37 = 0;
                while(k7 + 24 < j * 8) 
                {
                    int l39 = fnf.gad(abyte0, k7, 11);
                    k7 += 11;
                    int l41 = fnf.gad(abyte0, k7, 5);
                    k7 += 5;
                    if(l41 > 15)
                        l41 -= 32;
                    int j43 = fnf.gad(abyte0, k7, 5);
                    k7 += 5;
                    if(j43 > 15)
                        j43 -= 32;
                    int i14 = fnf.gad(abyte0, k7, 4);
                    k7 += 4;
                    int i44 = fnf.gad(abyte0, k7, 1);
                    k7++;
                    int i23 = (ejl + l41) * eic + 64;
                    int i26 = (ejm + j43) * eic + 64;
                    fdn(l39, i23, i26, i14);
                    if(i44 == 0)
                        dff[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.aah.hfc(148);
                    super.aah.hfl(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        gnm gnm5 = ekm[dff[i40]];
                        super.aah.hfl(gnm5.hab);
                        super.aah.hfl(gnm5.hac);
                    }

                    super.aah.hem();
                    i37 = 0;
                }
                return;
            }
            if(i == 16)
            {
                for(int l = 1; l < j;)
                    if(fnf.fnl(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = ejl + abyte0[l + 1] >> 3;
                        int i19 = ejm + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < dfc; j23++)
                        {
                            int j26 = (djf[j23] >> 3) - j14;
                            int j29 = (djg[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    djf[l7] = djf[j23];
                                    djg[l7] = djg[j23];
                                    djh[l7] = djh[j23];
                                    dji[l7] = dji[j23];
                                }
                                l7++;
                            }
                        }

                        dfc = l7;
                    } else
                    {
                        int i8 = fnf.fnm(abyte0, l);
                        l += 2;
                        int k14 = ejl + abyte0[l++];
                        int j19 = ejm + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            djf[dfc] = k14;
                            djg[dfc] = j19;
                            djh[dfc] = i8;
                            dji[dfc] = 0;
                            for(int k23 = 0; k23 < eif; k23++)
                            {
                                if(ekn[k23] != k14 || ela[k23] != j19)
                                    continue;
                                dji[dfc] = ahd.aml[elb[k23]];
                                break;
                            }

                            dfc++;
                        } else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < dfc; k26++)
                                if(djf[k26] != k14 || djg[k26] != j19 || djh[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        djf[l23] = djf[k26];
                                        djg[l23] = djg[k26];
                                        djh[l23] = djh[k26];
                                        dji[l23] = dji[k26];
                                    }
                                    l23++;
                                } else
                                {
                                    i8 = -123;
                                }

                            dfc = l23;
                        }
                    }

                return;
            }
            if(i == 122)
            {
                for(int i1 = 1; i1 < j;)
                    if(fnf.fnl(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = ejl + abyte0[i1 + 1] >> 3;
                        int k19 = ejm + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < eif; i24++)
                        {
                            int l26 = (ekn[i24] >> 3) - l14;
                            int k29 = (ela[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    emm[j8] = emm[i24];
                                    emm[j8].cig = j8;
                                    ekn[j8] = ekn[i24];
                                    ela[j8] = ela[i24];
                                    elb[j8] = elb[i24];
                                    elc[j8] = elc[i24];
                                }
                                j8++;
                            } else
                            {
                                egn.bhe(emm[i24]);
                                dlm.gmm(ekn[i24], ela[i24], elb[i24]);
                            }
                        }

                        eif = j8;
                    } else
                    {
                        int k8 = fnf.fnm(abyte0, i1);
                        i1 += 2;
                        int i15 = ejl + abyte0[i1++];
                        int l19 = ejm + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < eif; i27++)
                            if(ekn[i27] != i15 || ela[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    emm[j24] = emm[i27];
                                    emm[j24].cig = j24;
                                    ekn[j24] = ekn[i27];
                                    ela[j24] = ela[i27];
                                    elb[j24] = elb[i27];
                                    elc[j24] = elc[i27];
                                }
                                j24++;
                            } else
                            {
                                egn.bhe(emm[i27]);
                                dlm.gmm(ekn[i27], ela[i27], elb[i27]);
                            }

                        eif = j24;
                        if(k8 != 60000)
                        {
                            int l29 = dlm.glg(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = ahd.ami[k8];
                                j37 = ahd.amj[k8];
                            } else
                            {
                                j37 = ahd.ami[k8];
                                i34 = ahd.amj[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * eic) / 2;
                            int i42 = ((l19 + l19 + j37) * eic) / 2;
                            int k43 = ahd.amh[k8];
                            cgc cgc2 = eaj[k43].daf();
                            egn.bhd(cgc2);
                            cgc2.cig = eif;
                            cgc2.cne(0, l29 * 32, 0);
                            cgc2.cng(j40, -dlm.gnb(j40, i42), i42);
                            cgc2.cna(true, 48, 48, -50, -10, -50);
                            dlm.glc(i15, l19, k8);
                            if(k8 == 74)
                                cgc2.cng(0, -480, 0);
                            ekn[eif] = i15;
                            ela[eif] = l19;
                            elb[eif] = k8;
                            elc[eif] = l29;
                            emm[eif++] = cgc2;
                        }
                    }

                return;
            }
            if(i == 99)
            {
                int j1 = 1;
                j1++;
                ena = abyte0[1] & 0xff;
                for(int l8 = 0; l8 < ena; l8++)
                {
                    int j15 = fnf.fnm(abyte0, j1);
                    j1 += 2;
                    enb[l8] = j15 & 0x7fff;
                    end[l8] = j15 / 32768;
                    if(ahd.ajf[j15 & 0x7fff] == 0)
                    {
                        enc[l8] = fnf.gac(abyte0, j1);
                        if(enc[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else
                    {
                        enc[l8] = 1;
                    }
                }

                return;
            }
            if(i == 106)
            {
                int k1 = fnf.fnm(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++)
                {
                    int i20 = fnf.fnm(abyte0, i9);
                    i9 += 2;
                    gnm gnm1 = ekm[i20];
                    byte byte6 = abyte0[i9];
                    i9++;
                    if(byte6 == 0)
                    {
                        int i30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbd = 150;
                            gnm1.hbc = i30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(gnm1 != null)
                        {
                            String s2 = ffn.fhe(cen.cfd(abyte0, i9, byte7));
                            boolean flag3 = false;
                            for(int k40 = 0; k40 < super.aba; k40++)
                                if(super.abb[k40] == gnm1.gnn)
                                    flag3 = true;

                            if(!flag3)
                            {
                                gnm1.hbb = 150;
                                gnm1.hba = s2;
                                enl(gnm1.haa + ": " + gnm1.hba, 2);
                            }
                        }
                        i9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int j30 = fnf.fnl(abyte0[i9]);
                        i9++;
                        int j34 = fnf.fnl(abyte0[i9]);
                        i9++;
                        int k37 = fnf.fnl(abyte0[i9]);
                        i9++;
                        if(gnm1 != null)
                        {
                            gnm1.hbe = j30;
                            gnm1.hbf = j34;
                            gnm1.hbg = k37;
                            gnm1.hbh = 200;
                            if(gnm1 == ejk)
                            {
                                eie[3] = j34;
                                dnk[3] = k37;
                                dha = false;
                                dgn = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int k30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        int k34 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbn = k30;
                            gnm1.hcb = k34;
                            gnm1.hca = -1;
                            gnm1.hcc = ehm;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int l30 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        int l34 = fnf.fnm(abyte0, i9);
                        i9 += 2;
                        if(gnm1 != null)
                        {
                            gnm1.hbn = l30;
                            gnm1.hca = l34;
                            gnm1.hcb = -1;
                            gnm1.hcc = ehm;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(gnm1 != null)
                        {
                            gnm1.hac = fnf.fnm(abyte0, i9);
                            i9 += 2;
                            gnm1.gnn = fnf.gaa(abyte0, i9);
                            i9 += 8;
                            gnm1.haa = fnf.gah(gnm1.gnn);
                            int i31 = fnf.fnl(abyte0[i9]);
                            i9++;
                            for(int i35 = 0; i35 < i31; i35++)
                            {
                                gnm1.han[i35] = fnf.fnl(abyte0[i9]);
                                i9++;
                            }

                            for(int l37 = i31; l37 < 12; l37++)
                                gnm1.han[l37] = 0;

                            gnm1.hbj = abyte0[i9++] & 0xff;
                            gnm1.hbk = abyte0[i9++] & 0xff;
                            gnm1.hbl = abyte0[i9++] & 0xff;
                            gnm1.hbm = abyte0[i9++] & 0xff;
                            gnm1.hbi = abyte0[i9++] & 0xff;
                            gnm1.hcf = abyte0[i9++] & 0xff;
                        } else
                        {
                            i9 += 14;
                            int j31 = fnf.fnl(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(gnm1 != null)
                        {
                            String s3 = cen.cfd(abyte0, i9, byte8);
                            gnm1.hbb = 150;
                            gnm1.hba = s3;
                            if(gnm1 == ejk)
                                enl(gnm1.haa + ": " + gnm1.hba, 5);
                        }
                        i9 += byte8;
                    }
                }

                return;
            }
            if(i == 118)
            {
                for(int l1 = 1; l1 < j;)
                    if(fnf.fnl(abyte0[l1]) == 255)
                    {
                        int j9 = 0;
                        int l15 = ejl + abyte0[l1 + 1] >> 3;
                        int j20 = ejm + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < eim; k24++)
                        {
                            int j27 = (ddm[k24] >> 3) - l15;
                            int k31 = (ddn[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0)
                            {
                                if(k24 != j9)
                                {
                                    emf[j9] = emf[k24];
                                    emf[j9].cig = j9 + 10000;
                                    ddm[j9] = ddm[k24];
                                    ddn[j9] = ddn[k24];
                                    emg[j9] = emg[k24];
                                    emh[j9] = emh[k24];
                                }
                                j9++;
                            } else
                            {
                                egn.bhe(emf[k24]);
                                dlm.gle(ddm[k24], ddn[k24], emg[k24], emh[k24]);
                            }
                        }

                        eim = j9;
                    } else
                    {
                        int k9 = fnf.fnm(abyte0, l1);
                        l1 += 2;
                        int i16 = ejl + abyte0[l1++];
                        int k20 = ejm + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < eim; l31++)
                            if(ddm[l31] != i16 || ddn[l31] != k20 || emg[l31] != byte5)
                            {
                                if(l31 != k27)
                                {
                                    emf[k27] = emf[l31];
                                    emf[k27].cig = k27 + 10000;
                                    ddm[k27] = ddm[l31];
                                    ddn[k27] = ddn[l31];
                                    emg[k27] = emg[l31];
                                    emh[k27] = emh[l31];
                                }
                                k27++;
                            } else
                            {
                                egn.bhe(emf[l31]);
                                dlm.gle(ddm[l31], ddn[l31], emg[l31], emh[l31]);
                            }

                        eim = k27;
                        if(k9 != 65535)
                        {
                            dlm.gli(i16, k20, byte5, k9);
                            cgc cgc1 = fah(i16, k20, byte5, k9, eim);
                            emf[eim] = cgc1;
                            ddm[eim] = i16;
                            ddn[eim] = k20;
                            emh[eim] = k9;
                            emg[eim++] = byte5;
                        }
                    }

                return;
            }
            if(i == 234)
            {
                ehe = ehd;
                ehd = 0;
                for(int i2 = 0; i2 < ehe; i2++)
                    dnj[i2] = dif[i2];

                int l9 = 8;
                int j16 = fnf.gad(abyte0, 8, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++)
                {
                    gnm gnm2 = dnj[l20];
                    int l27 = fnf.gad(abyte0, l9, 1);
                    l9++;
                    if(l27 != 0)
                    {
                        int i32 = fnf.gad(abyte0, l9, 1);
                        l9++;
                        if(i32 == 0)
                        {
                            int j35 = fnf.gad(abyte0, l9, 3);
                            l9 += 3;
                            int i38 = gnm2.hak;
                            int l40 = gnm2.hal[i38];
                            int j42 = gnm2.ham[i38];
                            if(j35 == 2 || j35 == 1 || j35 == 3)
                                l40 += eic;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= eic;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += eic;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= eic;
                            gnm2.hai = j35;
                            gnm2.hak = i38 = (i38 + 1) % 10;
                            gnm2.hal[i38] = l40;
                            gnm2.ham[i38] = j42;
                        } else
                        {
                            int k35 = fnf.gad(abyte0, l9, 4);
                            if((k35 & 0xc) == 12)
                            {
                                l9 += 2;
                                continue;
                            }
                            gnm2.hai = fnf.gad(abyte0, l9, 4);
                            l9 += 4;
                        }
                    }
                    dif[ehd++] = gnm2;
                }

                while(l9 + 34 < j * 8) 
                {
                    int l24 = fnf.gad(abyte0, l9, 12);
                    l9 += 12;
                    int i28 = fnf.gad(abyte0, l9, 5);
                    l9 += 5;
                    if(i28 > 15)
                        i28 -= 32;
                    int j32 = fnf.gad(abyte0, l9, 5);
                    l9 += 5;
                    if(j32 > 15)
                        j32 -= 32;
                    int l35 = fnf.gad(abyte0, l9, 4);
                    l9 += 4;
                    int j38 = (ejl + i28) * eic + 64;
                    int i41 = (ejm + j32) * eic + 64;
                    int k42 = fnf.gad(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= ahd.ang)
                        k42 = 24;
                    feh(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 65)
            {
                int j2 = fnf.fnm(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++)
                {
                    int i21 = fnf.fnm(abyte0, i10);
                    i10 += 2;
                    gnm gnm3 = eab[i21];
                    int j28 = fnf.fnl(abyte0[i10]);
                    i10++;
                    if(j28 == 1)
                    {
                        int k32 = fnf.fnm(abyte0, i10);
                        i10 += 2;
                        byte byte9 = abyte0[i10];
                        i10++;
                        if(gnm3 != null)
                        {
                            String s4 = cen.cfd(abyte0, i10, byte9);
                            gnm3.hbb = 150;
                            gnm3.hba = s4;
                            if(k32 == ejk.hab)
                                enl("@yel@" + ahd.amn[gnm3.haf] + ": " + gnm3.hba, 5);
                        }
                        i10 += byte9;
                    } else
                    if(j28 == 2)
                    {
                        int l32 = fnf.fnl(abyte0[i10]);
                        i10++;
                        int i36 = fnf.fnl(abyte0[i10]);
                        i10++;
                        int k38 = fnf.fnl(abyte0[i10]);
                        i10++;
                        if(gnm3 != null)
                        {
                            gnm3.hbe = l32;
                            gnm3.hbf = i36;
                            gnm3.hbg = k38;
                            gnm3.hbh = 200;
                        }
                    }
                }

                return;
            }
            if(i == 108)
            {
                dhk = true;
                int k2 = fnf.fnl(abyte0[1]);
                ddl = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = fnf.fnl(abyte0[j10]);
                    j10++;
                    ece[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }

                return;
            }
            if(i == 150)
            {
                dhk = false;
                return;
            }
            if(i == 102)
            {
                dea = true;
                ejn = fnf.fnm(abyte0, 1);
                eda = fnf.fnm(abyte0, 3);
                edb = fnf.fnm(abyte0, 5);
                dnb = fnf.fnm(abyte0, 7);
                edc = fnf.fnm(abyte0, 9);
                edb -= dnb * edc;
                return;
            }
            if(i == 178)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    eie[k10] = fnf.fnl(abyte0[l2++]);

                for(int i17 = 0; i17 < 18; i17++)
                    dnk[i17] = fnf.fnl(abyte0[l2++]);

                for(int k21 = 0; k21 < 18; k21++)
                {
                    dnh[k21] = fnf.fnn(abyte0, l2);
                    l2 += 4;
                }

                dic = fnf.fnl(abyte0[l2++]);
                return;
            }
            if(i == 193)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    efe[i3] = fnf.fnl(abyte0[1 + i3]);

                return;
            }
            if(i == 92)
            {
                ecj = 250;
                return;
            }
            if(i == 75)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = ejl + fnf.gab(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = ejm + fnf.gab(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < dfc; k28++)
                    {
                        int i33 = (djf[k28] >> 3) - j17;
                        int j36 = (djg[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                djf[i25] = djf[k28];
                                djg[i25] = djg[k28];
                                djh[i25] = djh[k28];
                                dji[i25] = dji[k28];
                            }
                            i25++;
                        }
                    }

                    dfc = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < eif; j33++)
                    {
                        int k36 = (ekn[j33] >> 3) - j17;
                        int l38 = (ela[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                emm[i25] = emm[j33];
                                emm[i25].cig = i25;
                                ekn[i25] = ekn[j33];
                                ela[i25] = ela[j33];
                                elb[i25] = elb[j33];
                                elc[i25] = elc[j33];
                            }
                            i25++;
                        } else
                        {
                            egn.bhe(emm[j33]);
                            dlm.gmm(ekn[j33], ela[j33], elb[j33]);
                        }
                    }

                    eif = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < eim; l36++)
                    {
                        int i39 = (ddm[l36] >> 3) - j17;
                        int j41 = (ddn[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0)
                        {
                            if(l36 != i25)
                            {
                                emf[i25] = emf[l36];
                                emf[i25].cig = i25 + 10000;
                                ddm[i25] = ddm[l36];
                                ddn[i25] = ddn[l36];
                                emg[i25] = emg[l36];
                                emh[i25] = emh[l36];
                            }
                            i25++;
                        } else
                        {
                            egn.bhe(emf[l36]);
                            dlm.gle(ddm[l36], ddn[l36], emg[l36], emh[l36]);
                        }
                    }

                    eim = i25;
                }

                return;
            }
            if(i == 11)
            {
                edf = true;
                return;
            }
            if(i == 223)
            {
                int k3 = fnf.fnm(abyte0, 1);
                if(ekm[k3] != null)
                    dnm = ekm[k3].haa;
                dmk = true;
                eal = false;
                eam = false;
                dkg = 0;
                dlh = 0;
                return;
            }
            if(i == 27)
            {
                dmk = false;
                dfd = false;
                return;
            }
            if(i == 232)
            {
                dlh = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < dlh; i11++)
                {
                    dli[i11] = fnf.fnm(abyte0, l3);
                    l3 += 2;
                    dlj[i11] = fnf.fnn(abyte0, l3);
                    l3 += 4;
                }

                eal = false;
                eam = false;
                return;
            }
            if(i == 59)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
                    eal = true;
                    return;
                } else
                {
                    eal = false;
                    return;
                }
            }
            if(i == 83)
            {
                eec = true;
                int i4 = 1;
                i4++;
                int j11 = abyte0[1] & 0xff;
                i4++;
                byte byte4 = abyte0[2];
                i4++;
                efb = abyte0[3] & 0xff;
                i4++;
                efc = abyte0[4] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    efm[i22] = -1;

                for(int j25 = 0; j25 < j11; j25++)
                {
                    efm[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    efn[j25] = fnf.fnm(abyte0, i4);
                    i4 += 2;
                    ega[j25] = abyte0[i4++];
                }

                if(byte4 == 1)
                {
                    int l28 = 39;
                    for(int k33 = 0; k33 < ena; k33++)
                    {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++)
                        {
                            if(efm[j39] != enb[k33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(enb[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            efm[l28] = enb[k33] & 0x7fff;
                            efn[l28] = 0;
                            ega[l28] = 0;
                            l28--;
                        }
                    }

                }
                if(dhc >= 0 && dhc < 40 && efm[dhc] != dhd)
                {
                    dhc = -1;
                    dhd = -2;
                }
                return;
            }
            if(i == 90)
            {
                eec = false;
                return;
            }
            if(i == 125)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    eam = true;
                    return;
                } else
                {
                    eam = false;
                    return;
                }
            }
            if(i == 151)
            {
                ecg = fnf.fnl(abyte0[1]) == 1;
                dfl = fnf.fnl(abyte0[2]) == 1;
                dgh = fnf.fnl(abyte0[3]) == 1;
                return;
            }
            if(i == 84)
            {
                for(int j4 = 0; j4 < j - 1; j4++)
                {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!djb[j4] && flag)
                        fbm("prayeron");
                    if(djb[j4] && !flag)
                        fbm("prayeroff");
                    djb[j4] = flag;
                }

                return;
            }
            if(i == 71)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    dfm[k4] = abyte0[k4 + 1] == 1;

                return;
            }
            if(i == 39)
            {
                dnf = true;
                int l4 = 1;
                l4++;
                ehk = abyte0[1] & 0xff;
                l4++;
                elf = abyte0[2] & 0xff;
                for(int k11 = 0; k11 < ehk; k11++)
                {
                    eag[k11] = fnf.fnm(abyte0, l4);
                    l4 += 2;
                    eah[k11] = fnf.gac(abyte0, l4);
                    if(eah[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }

                fac();
                return;
            }
            if(i == 196)
            {
                dnf = false;
                return;
            }
            if(i == 174)
            {
                int i5 = abyte0[1] & 0xff;
                dnh[i5] = fnf.fnn(abyte0, 2);
                return;
            }
            if(i == 233)
            {
                int j5 = fnf.fnm(abyte0, 1);
                if(ekm[j5] != null)
                    dfn = ekm[j5].haa;
                eeb = true;
                dme = 0;
                ecb = 0;
                dma = false;
                dmb = false;
                dem = false;
                den = false;
                dfa = false;
                dfb = false;
                return;
            }
            if(i == 111)
            {
                eeb = false;
                dkl = false;
                return;
            }
            if(i == 67)
            {
                dfd = true;
                dfe = false;
                dmk = false;
                int k5 = 1;
                dhb = fnf.gaa(abyte0, 1);
                k5 += 8;
                k5++;
                ege = abyte0[9] & 0xff;
                for(int l11 = 0; l11 < ege; l11++)
                {
                    egf[l11] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    egg[l11] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }

                egi = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < egi; k17++)
                {
                    egj[k17] = fnf.fnm(abyte0, k5);
                    k5 += 2;
                    egk[k17] = fnf.fnn(abyte0, k5);
                    k5 += 4;
                }

                return;
            }
            if(i == 198)
            {
                ecb = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < ecb; i12++)
                {
                    ecc[i12] = fnf.fnm(abyte0, l5);
                    l5 += 2;
                    ecd[i12] = fnf.fnn(abyte0, l5);
                    l5 += 4;
                }

                dma = false;
                dmb = false;
                return;
            }
            if(i == 180)
            {
                if(abyte0[1] == 1)
                    dem = true;
                else
                    dem = false;
                if(abyte0[2] == 1)
                    den = true;
                else
                    den = false;
                if(abyte0[3] == 1)
                    dfa = true;
                else
                    dfa = false;
                if(abyte0[4] == 1)
                    dfb = true;
                else
                    dfb = false;
                dma = false;
                dmb = false;
                return;
            }
            if(i == 17)
            {
                int i6 = 1;
                i6++;
                int j12 = abyte0[1] & 0xff;
                int l17 = fnf.fnm(abyte0, 2);
                i6 += 2;
                int j22 = fnf.gac(abyte0, 4);
                if(j22 >= 128)
                    i6 += 4;
                else
                    i6++;
                if(j22 == 0)
                {
                    ehk--;
                    for(int k25 = j12; k25 < ehk; k25++)
                    {
                        eag[k25] = eag[k25 + 1];
                        eah[k25] = eah[k25 + 1];
                    }

                } else
                {
                    eag[j12] = l17;
                    eah[j12] = j22;
                    if(j12 >= ehk)
                        ehk = j12 + 1;
                }
                fac();
                return;
            }
            if(i == 173)
            {
                int j6 = 1;
                int k12 = 1;
                j6++;
                int i18 = abyte0[1] & 0xff;
                int k22 = fnf.fnm(abyte0, 2);
                j6 += 2;
                if(ahd.ajf[k22 & 0x7fff] == 0)
                {
                    k12 = fnf.gac(abyte0, 4);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                enb[i18] = k22 & 0x7fff;
                end[i18] = k22 / 32768;
                enc[i18] = k12;
                if(i18 >= ena)
                    ena = i18 + 1;
                return;
            }
            if(i == 145)
            {
                int k6 = abyte0[1] & 0xff;
                ena--;
                for(int l12 = k6; l12 < ena; l12++)
                {
                    enb[l12] = enb[l12 + 1];
                    enc[l12] = enc[l12 + 1];
                    end[l12] = end[l12 + 1];
                }

                return;
            }
            if(i == 129)
            {
                int l6 = 1;
                l6++;
                int i13 = abyte0[1] & 0xff;
                l6++;
                eie[i13] = fnf.fnl(abyte0[2]);
                l6++;
                dnk[i13] = fnf.fnl(abyte0[3]);
                dnh[i13] = fnf.fnn(abyte0, 4);
                l6 += 4;
                return;
            }
            if(i == 78)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    dma = true;
                    return;
                } else
                {
                    dma = false;
                    return;
                }
            }
            if(i == 130)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    dmb = true;
                    return;
                } else
                {
                    dmb = false;
                    return;
                }
            }
            if(i == 47)
            {
                dkl = true;
                dkm = false;
                eeb = false;
                int i7 = 1;
                ekh = fnf.gaa(abyte0, 1);
                i7 += 8;
                i7++;
                ead = abyte0[9] & 0xff;
                for(int j13 = 0; j13 < ead; j13++)
                {
                    eae[j13] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    eaf[j13] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }

                dkd = abyte0[i7++] & 0xff;
                for(int j18 = 0; j18 < dkd; j18++)
                {
                    dke[j18] = fnf.fnm(abyte0, i7);
                    i7 += 2;
                    dkf[j18] = fnf.fnn(abyte0, i7);
                    i7 += 4;
                }

                dhg = abyte0[i7++] & 0xff;
                dhh = abyte0[i7++] & 0xff;
                dhi = abyte0[i7++] & 0xff;
                dhj = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 8)
            {
                String s = new String(abyte0, 1, j - 1);
                fbm(s);
                return;
            }
            if(i == 219)
            {
                if(ede < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + ejl;
                    int k18 = abyte0[3] + ejm;
                    ejf[ede] = j7;
                    eba[ede] = 0;
                    dga[ede] = k13;
                    ehi[ede] = k18;
                    ede++;
                }
                return;
            }
            if(i == 152)
            {
                if(!egc)
                {
                    elk = fnf.fnn(abyte0, 1);
                    dik = fnf.fnm(abyte0, 5);
                    efd = abyte0[7] & 0xff;
                    dnc = fnf.fnm(abyte0, 8);
                    dha = true;
                    egc = true;
                    edn = null;
                }
                return;
            }
            if(i == 128)
            {
                ddf = new String(abyte0, 1, j - 1);
                dgn = true;
                eeh = false;
                return;
            }
            if(i == 77)
            {
                ddf = new String(abyte0, 1, j - 1);
                dgn = true;
                eeh = true;
                return;
            }
            if(i == 149)
            {
                eja = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 253)
            {
                if(!ddj)
                    ejb = eja;
                ddj = true;
                super.fln = "";
                super.fma = "";
                dng.ccd(dld + 1, abyte0);
                dia = null;
                return;
            }
            if(i == 138)
            {
                ejb = fnf.fnm(abyte0, 1);
                return;
            }
            if(i == 109)
            {
                ddj = false;
                return;
            }
            if(i == 61)
            {
                dia = "Incorrect - Please wait...";
                return;
            }
            if(i == 190)
            {
                ecf = fnf.fnm(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(dnd < 3)
            {
                super.aah.hfc(206);
                super.aah.hen(runtimeexception.toString());
                super.aah.hem();
                super.aah.hfc(206);
                super.aah.hen("p-type:" + i + " p-size:" + j);
                super.aah.hem();
                super.aah.hfc(206);
                super.aah.hen("rx:" + ejl + " ry:" + ejm + " num3l:" + eif);
                super.aah.hem();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";

                super.aah.hfc(206);
                super.aah.hen(s1);
                super.aah.hem();
                dnd++;
            }
        }
    }

    protected final void fci(Runnable runnable)
    {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    private final void fcj()
    {
        boolean flag = false;
        byte byte0 = 22;
        byte byte1 = 36;
        dng.cbh(22, 36, 468, 16, 192);
        int i = 0x989898;
        dng.cbf(22, 52, 468, 246, 0x989898, 160);
        dng.cee("Please confirm your trade with @yel@" + fnf.gah(dhb), 256, 48, 1, 0xffffff);
        dng.cee("You are about to give:", 139, 66, 1, 0xffff00);
        for(int j = 0; j < egi; j++)
        {
            String s = ahd.amb[egj[j]];
            if(ahd.ajf[egj[j]] == 0)
                s = s + " x " + fal(egk[j]);
            dng.cee(s, 139, 78 + j * 12, 1, 0xffffff);
        }

        if(egi == 0)
            dng.cee("Nothing!", 139, 78, 1, 0xffffff);
        dng.cee("In return you will receive:", 373, 66, 1, 0xffff00);
        for(int k = 0; k < ege; k++)
        {
            String s1 = ahd.amb[egf[k]];
            if(ahd.ajf[egf[k]] == 0)
                s1 = s1 + " x " + fal(egg[k]);
            dng.cee(s1, 373, 78 + k * 12, 1, 0xffffff);
        }

        if(ege == 0)
            dng.cee("Nothing!", 373, 78, 1, 0xffffff);
        dng.cee("Are you sure you want to do this?", 256, 236, 4, 65535);
        dng.cee("There is NO WAY to reverse a trade if you change your mind.", 256, 251, 1, 0xffffff);
        dng.cee("Remember that not all players are trustworthy", 256, 266, 1, 0xffffff);
        if(!dfe)
        {
            dng.cci(105, 274, dkn + 25);
            dng.cci(339, 274, dkn + 26);
        } else
        {
            dng.cee("Waiting for other player...", 256, 286, 1, 0xffff00);
        }
        if(ddk == 1)
        {
            if(super.flg < 22 || super.flh < 36 || super.flg > 490 || super.flh > 298)
            {
                dfd = false;
                super.aah.hfc(255);
                super.aah.hem();
            }
            if(super.flg >= 105 && super.flg <= 210 && super.flh >= 274 && super.flh <= 295)
            {
                dfe = true;
                super.aah.hfc(47);
                super.aah.hem();
            }
            if(super.flg >= 339 && super.flg <= 445 && super.flh >= 274 && super.flh <= 295)
            {
                dfd = false;
                super.aah.hfc(255);
                super.aah.hem();
            }
            ddk = 0;
        }
    }

    private final void fck()
    {
        boolean flag1 = false;
        if(ddk != 0 && ecl == 0)
            ecl = 1;
        if(ecl > 0)
        {
            int i = super.flg - 22;
            int j = super.flh - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < ena)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = enb[k];
                        for(int k3 = 0; k3 < dkg; k3++)
                            if(dkh[k3] == k2)
                                if(ahd.ajf[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < ecl; i4++)
                                    {
                                        if(dki[k3] < enc[k])
                                            dki[k3]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(fdm(k2) <= l1)
                            flag = true;
                        if(ahd.ajj[k2] == 1)
                        {
                            enl("This object cannot be traded with other players", 3);
                            flag = false;
                        }
                        if(!flag && dkg < 12)
                        {
                            dkh[dkg] = k2;
                            dki[dkg] = 1;
                            dkg++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aah.hfc(124);
                            super.aah.hfj(dkg);
                            for(int j4 = 0; j4 < dkg; j4++)
                            {
                                super.aah.hfl(dkh[j4]);
                                super.aah.hfi(dki[j4]);
                            }

                            super.aah.hem();
                            eal = false;
                            eam = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < dkg)
                    {
                        int j1 = dkh[l];
                        for(int i2 = 0; i2 < ecl; i2++)
                        {
                            if(ahd.ajf[j1] == 0 && dki[l] > 1)
                            {
                                dki[l]--;
                                continue;
                            }
                            dkg--;
                            eck = 0;
                            for(int l2 = l; l2 < dkg; l2++)
                            {
                                dkh[l2] = dkh[l2 + 1];
                                dki[l2] = dki[l2 + 1];
                            }

                            break;
                        }

                        super.aah.hfc(124);
                        super.aah.hfj(dkg);
                        for(int i3 = 0; i3 < dkg; i3++)
                        {
                            super.aah.hfl(dkh[i3]);
                            super.aah.hfi(dki[i3]);
                        }

                        super.aah.hem();
                        eal = false;
                        eam = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    eam = true;
                    super.aah.hfc(239);
                    super.aah.hem();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    dmk = false;
                    super.aah.hfc(255);
                    super.aah.hem();
                }
            } else
            if(ddk != 0)
            {
                dmk = false;
                super.aah.hfc(255);
                super.aah.hem();
            }
            ddk = 0;
            ecl = 0;
        }
        if(!dmk)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dng.cbh(22, 36, 468, 12, 192);
        int i1 = 0x989898;
        dng.cbf(22, 48, 468, 18, 0x989898, 160);
        dng.cbf(22, 66, 8, 248, 0x989898, 160);
        dng.cbf(227, 66, 11, 248, 0x989898, 160);
        dng.cbf(484, 66, 6, 248, 0x989898, 160);
        dng.cbf(30, 169, 197, 22, 0x989898, 160);
        dng.cbf(30, 294, 197, 20, 0x989898, 160);
        dng.cbf(238, 271, 246, 43, 0x989898, 160);
        int k1 = 0xd0d0d0;
        dng.cbf(30, 66, 197, 103, 0xd0d0d0, 160);
        dng.cbf(30, 191, 197, 103, 0xd0d0d0, 160);
        dng.cbf(238, 66, 246, 205, 0xd0d0d0, 160);
        for(int j2 = 0; j2 < 4; j2++)
            dng.cbj(30, 66 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 4; j3++)
            dng.cbj(30, 191 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            dng.cbj(238, 66 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                dng.cbk(30 + k4 * 49, 66, 103, 0);
            if(k4 < 5)
                dng.cbk(30 + k4 * 49, 191, 103, 0);
            dng.cbk(238 + k4 * 49, 66, 205, 0);
        }

        dng.ceg("Trading with: " + dnm, 23, 46, 1, 0xffffff);
        dng.ceg("Your Offer", 31, 63, 4, 0xffffff);
        dng.ceg("Opponent's Offer", 31, 188, 4, 0xffffff);
        dng.ceg("Your Inventory", 238, 63, 4, 0xffffff);
        if(!eam)
            dng.cci(239, 274, dkn + 25);
        dng.cci(416, 274, dkn + 26);
        if(eal)
        {
            dng.cee("Other player", 363, 282, 1, 0xffffff);
            dng.cee("has accepted", 363, 292, 1, 0xffffff);
        }
        if(eam)
        {
            dng.cee("Waiting for", 274, 282, 1, 0xffffff);
            dng.cee("other player", 274, 292, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < ena; l4++)
        {
            int i5 = 239 + (l4 % 5) * 49;
            int k5 = 67 + (l4 / 5) * 34;
            dng.cdk(i5, k5, 48, 32, dlb + ahd.ajd[enb[l4]], ahd.aji[enb[l4]], 0, 0, false);
            if(ahd.ajf[enb[l4]] == 0)
                dng.ceg(String.valueOf(enc[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < dkg; j5++)
        {
            int l5 = 31 + (j5 % 4) * 49;
            int j6 = 67 + (j5 / 4) * 34;
            dng.cdk(l5, j6, 48, 32, dlb + ahd.ajd[dkh[j5]], ahd.aji[dkh[j5]], 0, 0, false);
            if(ahd.ajf[dkh[j5]] == 0)
                dng.ceg(String.valueOf(dki[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.flg > l5 && super.flg < l5 + 48 && super.flh > j6 && super.flh < j6 + 32)
                dng.ceg(ahd.amb[dkh[j5]] + ": @whi@" + ahd.amc[dkh[j5]], 30, 309, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dlh; i6++)
        {
            int k6 = 31 + (i6 % 4) * 49;
            int l6 = 192 + (i6 / 4) * 34;
            dng.cdk(k6, l6, 48, 32, dlb + ahd.ajd[dli[i6]], ahd.aji[dli[i6]], 0, 0, false);
            if(ahd.ajf[dli[i6]] == 0)
                dng.ceg(String.valueOf(dlj[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.flg > k6 && super.flg < k6 + 48 && super.flh > l6 && super.flh < l6 + 32)
                dng.ceg(ahd.amb[dli[i6]] + ": @whi@" + ahd.amc[dli[i6]], 30, 309, 1, 0xffff00);
        }

    }

    private final void fcl()
    {
        dng.cci(0, eli - 4, dkn + 23);
        int i = 0xc8c8ff;
        if(een == 0)
            i = 0xffc832;
        if(eki % 30 > 15)
            i = 0xff3232;
        dng.cee("All messages", 54, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 1)
            i = 0xffc832;
        if(ekj % 30 > 15)
            i = 0xff3232;
        dng.cee("Chat history", 155, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 2)
            i = 0xffc832;
        if(ekk % 30 > 15)
            i = 0xff3232;
        dng.cee("Quest history", 255, eli + 6, 0, i);
        i = 0xc8c8ff;
        if(een == 3)
            i = 0xffc832;
        if(ekl % 30 > 15)
            i = 0xff3232;
        dng.cee("Private history", 355, eli + 6, 0, i);
        dng.cee("Report abuse", 457, eli + 6, 0, 0xffffff);
    }

    private final void fcm()
    {
        super.fmb = "";
        super.fmc = "";
    }

    protected final void fcn()
    {
        if(egd)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Verdana", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, 35);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, 85);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, 135);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, 165);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, 195);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, 225);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, 255);
            fmg(1);
            return;
        }
        if(dib)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            fmg(1);
            return;
        }
        if(ell)
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
            fmg(1);
            return;
        }
        try
        {
            if(eid == 0)
            {
                dng.bnm = false;
                fch();
            }
            if(eid == 1)
            {
                dng.bnm = true;
                fdh();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            feg();
            ell = true;
        }
    }

 public void showbank(boolean show)
 {
 dnf = show;
 }

    protected final void fda(int i)//keypress method
    {
        if(eid == 0)
        {
            if(eed == 0)
                dln.gfi(i);
            if(eed == 1)
                dni.gfi(i);
            if(eed == 2)
                djl.gfi(i);
        }
        if(eid == 1)
        {
            if(edf)
            {
                eij.gfi(i);
                return;
            }
            if(djc == 0 && egm == 0 && !ddj)
                eei.gfi(i);
        }



if(i == 1004 && dhe < 4500) { 
             dhe +=15;
}
if(i == 1005 && dhe > 250) {
             dhe -= 15;
}
}


    protected final void fdb()
    {
        if(dmc)
        {
            String s = getDocumentBase().getHost().toLowerCase();
            if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin"))
            {
                
            }
        }
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            djm[j] = i & 0xffffffc;
        }

        try
        {
            String s1 = getParameter("referid");
            deb = Integer.parseInt(s1);
        }
        catch(Exception _ex) { }
        try
        {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                ech = true;
        }
        catch(Exception _ex) { }
        if(dmc)
            super.aae = 43594;
        super.fjm = 0;
        aaa.aac = 1000;
        aaa.aab = cff.cfh;
        try
        {
            String s3 = getParameter("poff");
            int k1 = Integer.parseInt(s3);
            super.aae += k1;
            System.out.println("Offset: " + k1);
        }
        catch(Exception _ex) { }
        fea();
        if(egd)
            return;
        dkn = 2000;
        dla = dkn + 100;
        dlb = dla + 50;
        dlf = dlb + 1000;
        dlc = dlf + 10;
        dld = dlc + 50;
        dle = dld + 10;
        dil = getGraphics();
        fmg(50);
        dng = new dbf(elh, eli + 12, 4000, this);
        dng.dbg = this;
        dng.cba(0, 0, elh, eli + 12);
        gca.gen = false;
        gca.gfa = dla;
        ehn = new gca(dng, 5);
        int l = ((blm) (dng)).bln - 199;
        byte byte0 = 36;
        eia = ehn.ghc(l, 60, 196, 90, 1, 500, true);
        eka = new gca(dng, 5);
        ekb = eka.ghc(l, 76, 196, 126, 1, 500, true);
        ejg = new gca(dng, 5);
        ejh = ejg.ghc(l, 60, 196, 251, 1, 500, true);
        fad();
        if(egd)
            return;
        enk();
        if(egd)
            return;
        egn = new bbe(dng, 15000, 15000, 1000);
        egn.bib(elh / 2, eli / 2, elh / 2, eli / 2, elh, elj);
         egn.bbl = 99999;
        egn.bbm = 99999;
        egn.bbn = 1;
        egn.bca = 99999;
        egn.bkb(-50, -10, -50);
        dlm = new gig(egn, dng);
        dlm.gij = dkn;
        fak();
        if(egd)
            return;
        fek();
        if(egd)
            return;
        fbn();
        if(egd)
            return;
        if(ech)
            fab();
        if(egd)
        {
            return;
        } else
        {
            fml(100, "Starting game...");
            enm();
            fbf();
            fcd();
            ffc();
            fmd();
            fem();
            return;
        }
    }

    private final void fdc()
    {
        if(eid == 0)
            return;
        if(edj > 450)
        {
            enl("@cya@You can't logout during combat!", 3);
            return;
        }
        if(edj > 0)
        {
            enl("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aah.hfc(39);
            super.aah.hem();
            dmm = 1000;
            return;
        }
    }

    private final void fdd()
    {
        if(super.fma.length() > 0)
        {
            String s = super.fma.trim();
            super.fln = "";
            super.fma = "";
            if(s.length() > 0)
            {
                long l = fnf.gag(s);
                super.aah.hfc(76);
                super.aah.hff(l);
                super.aah.hfj(eac);
                super.aah.hfj(ejc ? 1 : 0);
                super.aah.hem();
            }
            egm = 0;
            return;
        }
        dng.cbh(56, 130, 400, 100, 0);
        dng.cbi(56, 130, 400, 100, 0xffffff);
        int i = 160;
        dng.cee("Now type the name of the offending player, and press enter", 256, 160, 1, 0xffff00);
        i += 18;
        dng.cee("Name: " + super.fln + "*", 256, 178, 4, 0xffffff);
        if(super.abk > 0)
        {
            i = 207;
            if(ejc)
                dng.cee("Moderator option: Mute player for 48 hours: <ON>", 256, 207, 1, 0xff8000);
            else
                dng.cee("Moderator option: Mute player for 48 hours: <OFF>", 256, 207, 1, 0xffffff);
            if(super.flg > 106 && super.flg < 406 && super.flh > 194 && super.flh < 209 && ddk == 1)
            {
                ddk = 0;
                ejc = !ejc;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.flg > 196 && super.flg < 316 && super.flh > 209 && super.flh < 224)
        {
            j = 0xffff00;
            if(ddk == 1)
            {
                ddk = 0;
                egm = 0;
            }
        }
        dng.cee("Click here to cancel", 256, 222, 1, j);
        if(ddk == 1 && (super.flg < 56 || super.flg > 456 || super.flh < 130 || super.flh > 230))
        {
            ddk = 0;
            egm = 0;
        }
    }

    private final String fde(int i)
    {
        return fnf.gaf(i);
    }

    private final void fdf(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dng)).bln - 248;
        dng.cci(i, 3, dkn + 1);
        for(int j = 0; j < egl; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < ena && end[j] == 1)
                dng.cbf(k, i1, 49, 34, 0xff0000, 128);
            else
                dng.cbf(k, i1, 49, 34, 0xb5b5b5, 128);
            if(j < ena)
            {
                dng.cdk(k, i1, 48, 32, dlb + ahd.ajd[enb[j]], ahd.aji[enb[j]], 0, 0, false);
                if(ahd.ajf[enb[j]] == 0)
                    dng.ceg(String.valueOf(enc[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }

        for(int l = 1; l <= 4; l++)
            dng.cbk(i + l * 49, 36, (egl / 5) * 34, 0);

        for(int j1 = 1; j1 <= egl / 5 - 1; j1++)
            dng.cbj(i, 36 + j1 * 34, 245, 0);

        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 248);
        int k1 = super.flh - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (egl / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < ena)
            {
                int i2 = enb[l1];
                if(eca >= 0)
                {
                    if(ahd.ahg[eca] == 3)
                    {
                        ehb[emc] = "Cast " + ahd.aij[eca] + " on";
                        eii[emc] = "@lre@" + ahd.amb[i2];
                        dne[emc] = 600;
                        edg[emc] = l1;
                        edh[emc] = eca;
                        emc++;
                        return;
                    }
                } else
                {
                    if(dgb >= 0)
                    {
                        ehb[emc] = "Use " + dgc + " with";
                        eii[emc] = "@lre@" + ahd.amb[i2];
                        dne[emc] = 610;
                        edg[emc] = l1;
                        edh[emc] = dgb;
                        emc++;
                        return;
                    }
                    if(end[l1] == 1)
                    {
                        ehb[emc] = "Remove";
                        eii[emc] = "@lre@" + ahd.amb[i2];
                        dne[emc] = 620;
                        edg[emc] = l1;
                        emc++;
                    } else
                    if(ahd.ajh[i2] != 0)
                    {
                        if((ahd.ajh[i2] & 0x18) != 0)
                            ehb[emc] = "Wield";
                        else
                            ehb[emc] = "Wear";
                        eii[emc] = "@lre@" + ahd.amb[i2];
                        dne[emc] = 630;
                        edg[emc] = l1;
                        emc++;
                    }
                    if(!ahd.amd[i2].equals(""))
                    {
                        ehb[emc] = ahd.amd[i2];
                        eii[emc] = "@lre@" + ahd.amb[i2];
                        dne[emc] = 640;
                        edg[emc] = l1;
                        emc++;
                    }
                    ehb[emc] = "Use";
                    eii[emc] = "@lre@" + ahd.amb[i2];
                    dne[emc] = 650;
                    edg[emc] = l1;
                    emc++;
                    ehb[emc] = "Drop";
                    eii[emc] = "@lre@" + ahd.amb[i2];
                    dne[emc] = 660;
                    edg[emc] = l1;
                    emc++;
                    ehb[emc] = "Examine";
                    eii[emc] = "@lre@" + ahd.amb[i2];
                    dne[emc] = 3600;
                    edg[emc] = i2;
                    emc++;
                }
            }
        }
    }

    private final void fdg()
    {
        boolean flag = false;
        char c = '\u0198';
        char c1 = '\u014E';
        if(eea > 0 && ecm <= 48)
            eea = 0;
        if(eea > 1 && ecm <= 96)
            eea = 1;
        if(eea > 2 && ecm <= 144)
            eea = 2;
        if(eik >= ecm || eik < 0)
            eik = -1;
        if(eik != -1 && dhm[eik] != eil)
        {
            eik = -1;
            eil = -2;
        }
        if(ddk != 0)
        {
            ddk = 0;
            int i = super.flg - 52;
            int j = super.flh - 3;
            if(i >= 0 && j >= 12 && i < 408 && j < 280)
            {
                int k = eea * 48;
                for(int j1 = 0; j1 < 6; j1++)
                {
                    for(int l1 = 0; l1 < 8; l1++)
                    {
                        int j6 = 7 + l1 * 49;
                        int l6 = 28 + j1 * 34;
                        if(i > j6 && i < j6 + 49 && j > l6 && j < l6 + 34 && k < ecm && dhm[k] != -1)
                        {
                            eil = dhm[k];
                            eik = k;
                        }
                        k++;
                    }

                }

                i = 52;
                j = 3;
                int i2;
                if(eik < 0)
                    i2 = -1;
                else
                    i2 = dhm[eik];
                if(i2 != -1)
                {
                    int l = dhn[eik];
                    if(ahd.ajf[i2] == 1 && l > 1)
                        l = 1;
                    if(l >= 1 && super.flg >= 272 && super.flh >= 241 && super.flg < 302 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(1);
                        super.aah.hem();
                    }
                    if(l >= 5 && super.flg >= 302 && super.flh >= 241 && super.flg < 332 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(5);
                        super.aah.hem();
                    }
                    if(l >= 25 && super.flg >= 332 && super.flh >= 241 && super.flg < 357 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(25);
                        super.aah.hem();
                    }
                    if(l >= 100 && super.flg >= 357 && super.flh >= 241 && super.flg < 387 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(100);
                        super.aah.hem();
                    }
                    if(l >= 500 && super.flg >= 387 && super.flh >= 241 && super.flg < 420 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(500);
                        super.aah.hem();
                    }
                    if(l >= 2500 && super.flg >= 422 && super.flh >= 241 && super.flg < 452 && super.flh <= 252)
                    {
                        super.aah.hfc(32);
                        super.aah.hfl(i2);
                        super.aah.hfl(2500);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 1 && super.flg >= 272 && super.flh >= 266 && super.flg < 302 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(1);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 5 && super.flg >= 302 && super.flh >= 266 && super.flg < 332 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(5);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 25 && super.flg >= 332 && super.flh >= 266 && super.flg < 357 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(25);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 100 && super.flg >= 357 && super.flh >= 266 && super.flg < 387 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(100);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 500 && super.flg >= 387 && super.flh >= 266 && super.flg < 420 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(500);
                        super.aah.hem();
                    }
                    if(fdm(i2) >= 2500 && super.flg >= 422 && super.flh >= 266 && super.flg < 452 && super.flh <= 277)
                    {
                        super.aah.hfc(177);
                        super.aah.hfl(i2);
                        super.aah.hfl(2500);
                        super.aah.hem();
                    }
                }
            } else
            if(ecm > 48 && i >= 50 && i <= 115 && j <= 12)
                eea = 0;
            else
            if(ecm > 48 && i >= 115 && i <= 180 && j <= 12)
                eea = 1;
            else
            if(ecm > 96 && i >= 180 && i <= 245 && j <= 12)
                eea = 2;
            else
            if(ecm > 144 && i >= 245 && i <= 310 && j <= 12)
            {
                eea = 3;
            } else
            {
                super.aah.hfc(251);
                super.aah.hem();
                dnf = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 3;
        dng.cbh(52, 3, 408, 12, 192);
        int i1 = 0x989898;
        dng.cbf(52, 15, 408, 17, 0x989898, 160);
        dng.cbf(52, 32, 8, 204, 0x989898, 160);
        dng.cbf(451, 32, 9, 204, 0x989898, 160);
        dng.cbf(52, 236, 408, 47, 0x989898, 160);
        dng.ceg("Bank", 53, 13, 1, 0xffffff);
        int k1 = 50;
        if(ecm > 48)
        {
            int j2 = 0xffffff;
            if(eea == 0)
                j2 = 0xff0000;
            else
            if(super.flg > 102 && super.flh >= 3 && super.flg < 167 && super.flh < 15)
                j2 = 0xffff00;
            dng.ceg("<page 1>", 102, 13, 1, j2);
            k1 += 65;
            j2 = 0xffffff;
            if(eea == 1)
                j2 = 0xff0000;
            else
            if(super.flg > 167 && super.flh >= 3 && super.flg < 232 && super.flh < 15)
                j2 = 0xffff00;
            dng.ceg("<page 2>", 167, 13, 1, j2);
            k1 += 65;
        }
        if(ecm > 96)
        {
            int k2 = 0xffffff;
            if(eea == 2)
                k2 = 0xff0000;
            else
            if(super.flg > 52 + k1 && super.flh >= 3 && super.flg < 52 + k1 + 65 && super.flh < 15)
                k2 = 0xffff00;
            dng.ceg("<page 3>", 52 + k1, 13, 1, k2);
            k1 += 65;
        }
        if(ecm > 144)
        {
            int l2 = 0xffffff;
            if(eea == 3)
                l2 = 0xff0000;
            else
            if(super.flg > 52 + k1 && super.flh >= 3 && super.flg < 52 + k1 + 65 && super.flh < 15)
                l2 = 0xffff00;
            dng.ceg("<page 4>", 52 + k1, 13, 1, l2);
            k1 += 65;
        }
        int i3 = 0xffffff;
        if(super.flg > 372 && super.flh >= 3 && super.flg < 460 && super.flh < 15)
            i3 = 0xff0000;
        dng.ced("Close window", 458, 13, 1, i3);
        dng.ceg("Number in bank in green", 59, 27, 1, 65280);
        dng.ceg("Number held in blue", 341, 27, 1, 65535);
        int k6 = 0xd0d0d0;
        int i7 = eea * 48;
        for(int k7 = 0; k7 < 6; k7++)
        {
            for(int l7 = 0; l7 < 8; l7++)
            {
                int j8 = 59 + l7 * 49;
                int k8 = 31 + k7 * 34;
                if(eik == i7)
                    dng.cbf(j8, k8, 49, 34, 0xff0000, 160);
                else
                    dng.cbf(j8, k8, 49, 34, 0xd0d0d0, 160);
                dng.cbi(j8, k8, 50, 35, 0);
                if(i7 < ecm && dhm[i7] != -1)
                {
                    dng.cdk(j8, k8, 48, 32, dlb + ahd.ajd[dhm[i7]], ahd.aji[dhm[i7]], 0, 0, false);
                    dng.ceg(String.valueOf(dhn[i7]), j8 + 1, k8 + 10, 1, 65280);
                    dng.ced(String.valueOf(fdm(dhm[i7])), j8 + 47, k8 + 29, 1, 65535);
                }
                i7++;
            }

        }

        dng.cbj(57, 259, 398, 0);
        if(eik == -1)
        {
            dng.cee("Select an object to withdraw or deposit", 256, 251, 3, 0xffff00);
            return;
        }
        int i8;
        if(eik < 0)
            i8 = -1;
        else
            i8 = dhm[eik];
        if(i8 != -1)
        {
            int j7 = dhn[eik];
            if(ahd.ajf[i8] == 1 && j7 > 1)
                j7 = 1;
            if(j7 > 0)
            {
                dng.ceg("Withdraw " + ahd.amb[i8], 54, 251, 1, 0xffffff);
                int j3 = 0xffffff;
                if(super.flg >= 272 && super.flh >= 241 && super.flg < 302 && super.flh <= 252)
                    j3 = 0xff0000;
                dng.ceg("One", 274, 251, 1, j3);
                if(j7 >= 5)
                {
                    int k3 = 0xffffff;
                    if(super.flg >= 302 && super.flh >= 241 && super.flg < 332 && super.flh <= 252)
                        k3 = 0xff0000;
                    dng.ceg("Five", 304, 251, 1, k3);
                }
                if(j7 >= 25)
                {
                    int l3 = 0xffffff;
                    if(super.flg >= 332 && super.flh >= 241 && super.flg < 357 && super.flh <= 252)
                        l3 = 0xff0000;
                    dng.ceg("25", 334, 251, 1, l3);
                }
                if(j7 >= 100)
                {
                    int i4 = 0xffffff;
                    if(super.flg >= 357 && super.flh >= 241 && super.flg < 387 && super.flh <= 252)
                        i4 = 0xff0000;
                    dng.ceg("100", 359, 251, 1, i4);
                }
                if(j7 >= 500)
                {
                    int j4 = 0xffffff;
                    if(super.flg >= 387 && super.flh >= 241 && super.flg < 420 && super.flh <= 252)
                        j4 = 0xff0000;
                    dng.ceg("500", 389, 251, 1, j4);
                }
                if(j7 >= 2500)
                {
                    int k4 = 0xffffff;
                    if(super.flg >= 422 && super.flh >= 241 && super.flg < 452 && super.flh <= 252)
                        k4 = 0xff0000;
                    dng.ceg("2500", 422, 251, 1, k4);
                }
            }
            if(fdm(i8) > 0)
            {
                dng.ceg("Deposit " + ahd.amb[i8], 54, 276, 1, 0xffffff);
                int l4 = 0xffffff;
                if(super.flg >= 272 && super.flh >= 266 && super.flg < 302 && super.flh <= 277)
                    l4 = 0xff0000;
                dng.ceg("One", 274, 276, 1, l4);
                if(fdm(i8) >= 5)
                {
                    int i5 = 0xffffff;
                    if(super.flg >= 302 && super.flh >= 266 && super.flg < 332 && super.flh <= 277)
                        i5 = 0xff0000;
                    dng.ceg("Five", 304, 276, 1, i5);
                }
                if(fdm(i8) >= 25)
                {
                    int j5 = 0xffffff;
                    if(super.flg >= 332 && super.flh >= 266 && super.flg < 357 && super.flh <= 277)
                        j5 = 0xff0000;
                    dng.ceg("25", 334, 276, 1, j5);
                }
                if(fdm(i8) >= 100)
                {
                    int k5 = 0xffffff;
                    if(super.flg >= 357 && super.flh >= 266 && super.flg < 387 && super.flh <= 277)
                        k5 = 0xff0000;
                    dng.ceg("100", 359, 276, 1, k5);
                }
                if(fdm(i8) >= 500)
                {
                    int l5 = 0xffffff;
                    if(super.flg >= 387 && super.flh >= 266 && super.flg < 420 && super.flh <= 277)
                        l5 = 0xff0000;
                    dng.ceg("500", 389, 276, 1, l5);
                }
                if(fdm(i8) >= 2500)
                {
                    int i6 = 0xffffff;
                    if(super.flg >= 422 && super.flh >= 266 && super.flg < 452 && super.flh <= 277)
                        i6 = 0xff0000;
                    dng.ceg("2500", 422, 276, 1, i6);
                }
            }
        }
    }

    private final void fdh()
    {
        boolean flag = false;
        if(ecj != 0)
        {
            dng.cbm();
            dng.cee("@ran@Oh dear you are dead...", elh / 2, eli / 2, 7, 0xff0000);
            fcl();
            dng.cbc(dil, 0, 0);
            return;
        }
        if(edf)
        {
            eng();
            return;
        }
        if(ddj)
        {
            dng.cbm();
            if(Math.random() < 0.14999999999999999D)
                dng.cee("Teh Bot", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                dng.cee("Teh Bot", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            dng.cbh(elh / 2 - 100, 160, 200, 40, 0);
            dng.cee("You are sleeping", elh / 2, 50, 7, 0xffff00);
            dng.cee("Fatigue: " + (ejb * 100) / 750 + "%", elh / 2, 90, 7, 0xffff00);
            dng.cee("When you want to wake up just use your", elh / 2, 140, 5, 0xffffff);
            dng.cee("keyboard to type the word in the box below", elh / 2, 160, 5, 0xffffff);
            dng.cee(super.fln + "*", elh / 2, 180, 5, 65535);
            if(dia == null)
                dng.cci(elh / 2 - 127, 230, dld + 1);
            else
                dng.cee(dia, elh / 2, 260, 5, 0xff0000);
            dng.cbi(elh / 2 - 128, 229, 257, 42, 0xffffff);
            fcl();
            dng.cee("If you can't read the word", elh / 2, 290, 1, 0xffffff);
            dng.cee("@yel@click here@whi@ to get a different one", elh / 2, 305, 1, 0xffffff);
            dng.cbc(dil, 0, 0);
            return;
        }
        if(!dlm.gkg)
            return;
        for(int i = 0; i < 64; i++)
        {
            egn.bhe(dlm.gkd[edd][i]);
            if(edd == 0)
            {
                egn.bhe(dlm.gjb[1][i]);
                egn.bhe(dlm.gkd[1][i]);
                egn.bhe(dlm.gjb[2][i]);
                egn.bhe(dlm.gkd[2][i]);
            }
            edm = true;
            if(edd == 0 && (dlm.gka[ejk.had / 128][ejk.hae / 128] & 0x80) == 0)
            {
                egn.bhd(dlm.gkd[edd][i]);
                if(edd == 0)
                {
                    egn.bhd(dlm.gjb[1][i]);
                    egn.bhd(dlm.gkd[1][i]);
                    egn.bhd(dlm.gjb[2][i]);
                    egn.bhd(dlm.gkd[2][i]);
                }
                edm = false;
            }
        }

        if(efj != dgj)
        {
            dgj = efj;
            for(int j = 0; j < eif; j++)
            {
                if(elb[j] == 97)
                    ffb(j, "firea" + (efj + 1));
                if(elb[j] == 274)
                    ffb(j, "fireplacea" + (efj + 1));
                if(elb[j] == 1031)
                    ffb(j, "lightning" + (efj + 1));
                if(elb[j] == 1036)
                    ffb(j, "firespell" + (efj + 1));
                if(elb[j] == 1147)
                    ffb(j, "spellcharge" + (efj + 1));
            }

        }
        if(efk != dgk)
        {
            dgk = efk;
            for(int k = 0; k < eif; k++)
            {
                if(elb[k] == 51)
                    ffb(k, "torcha" + (efk + 1));
                if(elb[k] == 143)
                    ffb(k, "skulltorcha" + (efk + 1));
            }

        }
        if(efl != dgl)
        {
            dgl = efl;
            for(int l = 0; l < eif; l++)
                if(elb[l] == 1142)
                    ffb(l, "clawspell" + (efl + 1));

        }
        egn.bhh(dkc);
        dkc = 0;
        for(int i1 = 0; i1 < dka; i1++)
        {
            gnm gnm1 = eml[i1];
            if(gnm1.hbl != 255)
            {
                int k1 = gnm1.had;
                int i2 = gnm1.hae;
                int k2 = -dlm.gnb(k1, i2);
                int l3 = egn.bhi(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                dkc++;
                if(gnm1 == ejk)
                    egn.bhj(l3);
                if(gnm1.hah == 8)
                    egn.bhk(l3, -30);
                if(gnm1.hah == 9)
                    egn.bhk(l3, 30);
            }
        }

        for(int j1 = 0; j1 < dka; j1++)
        {
            gnm gnm2 = eml[j1];
            if(gnm2.hcc > 0)
            {
                gnm gnm3 = null;
                if(gnm2.hcb != -1)
                    gnm3 = eab[gnm2.hcb];
                else
                if(gnm2.hca != -1)
                    gnm3 = ekm[gnm2.hca];
                if(gnm3 != null)
                {
                    int l2 = gnm2.had;
                    int i4 = gnm2.hae;
                    int j6 = -dlm.gnb(l2, i4) - 110;
                    int i8 = gnm3.had;
                    int l8 = gnm3.hae;
                    int i9 = -dlm.gnb(i8, l8) - ahd.aie[gnm3.haf] / 2;
                    int j9 = (l2 * gnm2.hcc + i8 * (ehm - gnm2.hcc)) / ehm;
                    int k9 = (j6 * gnm2.hcc + i9 * (ehm - gnm2.hcc)) / ehm;
                    int l9 = (i4 * gnm2.hcc + l8 * (ehm - gnm2.hcc)) / ehm;
                    egn.bhi(dlc + gnm2.hbn, j9, k9, l9, 32, 32, 0);
                    dkc++;
                }
            }
        }

        for(int l1 = 0; l1 < ehd; l1++)
        {
            gnm gnm4 = dif[l1];
            int i3 = gnm4.had;
            int j4 = gnm4.hae;
            int k6 = -dlm.gnb(i3, j4);
            int j8 = egn.bhi(20000 + l1, i3, k6, j4, ahd.aid[gnm4.haf], ahd.aie[gnm4.haf], l1 + 30000);
            dkc++;
            if(gnm4.hah == 8)
                egn.bhk(j8, -30);
            if(gnm4.hah == 9)
                egn.bhk(j8, 30);
        }

        for(int j2 = 0; j2 < dfc; j2++)
        {
            int j3 = djf[j2] * eic + 64;
            int k4 = djg[j2] * eic + 64;
            egn.bhi(40000 + djh[j2], j3, -dlm.gnb(j3, k4) - dji[j2], k4, 96, 64, j2 + 20000);
            dkc++;
        }

        for(int k3 = 0; k3 < ede; k3++)
        {
            int l4 = dga[k3] * eic + 64;
            int l6 = ehi[k3] * eic + 64;
            int k8 = ejf[k3];
            if(k8 == 0)
            {
                egn.bhi(50000 + k3, l4, -dlm.gnb(l4, l6), l6, 128, 256, k3 + 50000);
                dkc++;
            }
            if(k8 == 1)
            {
                egn.bhi(50000 + k3, l4, -dlm.gnb(l4, l6), l6, 128, 64, k3 + 50000);
                dkc++;
            }
        }

        dng.bnj = false;
        dng.cbd();
        dng.bnj = super.flm;
        if(edd == 3)
        {
            int i5 = 40 + (int)(Math.random() * 3D);
            int i7 = 40 + (int)(Math.random() * 7D);
            egn.bkc(i5, i7, -50, -10, -50);
        }
        ehc = 0;
        ejd = 0;
        dhl = 0;
        if(ecg && !edm)
            fcb();
        if(!super.flm)
        {
            egn.bbl = 99999;
            egn.bbm = 99999;
            egn.bbn = 1;
            egn.bca = 99999;
        } else
        {
            egn.bbl = 99999;
            egn.bbm = 99999;
            egn.bbn = 1;
            egn.bca = 99999;
        }
        int j5 = dkj + emd;
        int j7 = dkk + dlk;
        egn.bje(j5, -dlm.gnb(j5, j7), j7, 912, dml * 4, 0, dhe * 2);
        egn.big();
        fan();
        if(efg > 0)
            dng.cci(efh - 8, efi - 8, dkn + 14 + (24 - efg) / 6);
        if(efg < 0)
            dng.cci(efh - 8, efi - 8, dkn + 18 + (24 + efg) / 6);
        if(ecf != 0)
        {
            int k5 = ecf / 50;
            int k7 = k5 / 60;
            k5 %= 60;
            if(k5 < 10)
                dng.cee("System update in: " + k7 + ":0" + k5, 256, eli - 7, 1, 0xffff00);
            else
                dng.cee("System update in: " + k7 + ":" + k5, 256, eli - 7, 1, 0xffff00);
        }
        if(!dea)
        {
            int l5 = 2203 - (ejm + edb + dna);
            if(ejl + eda + dmn >= 2640)
                l5 = -50;
            if(l5 > 0)
            {
                int l7 = 1 + l5 / 6;
                dng.cci(453, eli - 56, dkn + 13);
                dng.cee("Wilderness", 465, eli - 20, 1, 0xffff00);
                dng.cee("Level: " + l7, 465, eli - 7, 1, 0xffff00);
                if(emn == 0)
                    emn = 2;
            }
            if(emn == 0 && l5 > -10 && l5 <= 0)
                emn = 1;
        }
        if(een == 0)
        {
            for(int i6 = 0; i6 < 5; i6++)
                if(die[i6] > 0)
                {
                    String s = dgm[i6];
                    dng.ceg(s, 7, eli - 18 - i6 * 12, 1, 0xffff00);
                }

        }
        eei.ghl(eej);
        eei.ghl(eel);
        eei.ghl(eem);
        if(een == 1)
            eei.ghk(eej);
        else
        if(een == 2)
            eei.ghk(eel);
        else
        if(een == 3)
            eei.ghk(eem);
        gca.gfe = 2;
        eei.gfj();
        gca.gfe = 0;
        dng.cck(((blm) (dng)).bln - 3 - 197, 3, dkn, 128);
        fcg();
        dng.bnm = false;
        fcl();
        dng.cbc(dil, 0, 0);
    }

    protected final void fdi()
    {
        if(dib)
            return;
        if(ell)
            return;
        if(egd)
            return;
        try
        {
            ean++;
            if(eid == 0)
            {
                super.fjn = 0;
                fef();
            }
            if(eid == 1)
            {
                super.fjn++;
                faa();
            }
            super.flj = 0;
            super.fll = 0;
            efa++;
            if(efa > 500)
            {
                efa = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    emd += eme;
                if((i & 2) == 2)
                    dlk += dll;
            }
            if(emd < -50)
                eme = 2;
            if(emd > 50)
                eme = -2;
            if(dlk < -50)
                dll = 2;
            if(dlk > 50)
                dll = -2;
            if(eki > 0)
                eki--;
            if(ekj > 0)
                ekj--;
            if(ekk > 0)
                ekk--;
            if(ekl > 0)
            {
                ekl--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            feg();
            ell = true;
        }
    }

    protected final void ade()
    {
        ecf = 0;
        eed = 0;
        eid = 0;
        dmm = 0;
    }

    private final boolean fdj(int i)
    {
        for(int j = 0; j < ena; j++)
            if(enb[j] == i && end[j] == 1)
                return true;

        return false;
    }

    final void fdk(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = ahd.ajd[i1] + dlb;
        int i2 = ahd.aji[i1];
        dng.cdk(i, j, k, l, l1, i2, 0, 0, false);
    }

    private final void fdl(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dng)).bln - 199;
        int j = 36;
        dng.cci(i - 49, 3, dkn + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = 0xa0a0a0;
        if(eji == 0)
            k = 0xdcdcdc;
        else
            l = 0xdcdcdc;
        dng.cbf(i, 36, 98, 24, k, 128);
        dng.cbf(i + 98, 36, 98, 24, l, 128);
        dng.cbf(i, 60, 196, 251, 0xdcdcdc, 128);
        dng.cbj(i, 60, 196, 0);
        dng.cbk(i + 98, 36, 24, 0);
        dng.cee("Stats", i + 49, 52, 4, 0);
        dng.cee("Quests", i + 49 + 98, 52, 4, 0);
        if(eji == 0)
        {
            int i1 = 72;
            int k1 = -1;
            dng.ceg("Skills", i + 5, 72, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = 0xffffff;
                if(super.flg > i + 3 && super.flh >= i1 - 11 && super.flh < i1 + 2 && super.flg < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                dng.ceg(emk[l1] + ":@yel@" + eie[l1] + "/" + dnk[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.flg >= i + 90 && super.flh >= i1 - 13 - 11 && super.flh < (i1 - 13) + 2 && super.flg < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                dng.ceg(emk[l1 + 9] + ":@yel@" + eie[l1 + 9] + "/" + dnk[l1 + 9], (i + 98) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }

            dng.ceg("Quest Points:@yel@" + dic, (i + 98) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            dng.ceg("Fatigue: @bla@" + (eja * 100) / 750 + "@bla@%", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            dng.ceg("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                dng.ceg(djn[j2] + ":@yel@" + efe[j2], i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    dng.ceg(djn[j2 + 3] + ":@yel@" + efe[j2 + 3], i + 98 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }

            i1 += 6;
            dng.cbj(i, i1 - 15, 196, 0);
            if(k1 != -1)
            {
                dng.ceg(ehl[k1] + " skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = djm[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(dnh[k1] >= djm[i3])
                        k2 = djm[i3 + 1];

                dng.ceg("Total xp: " + dnh[k1] / 4, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                dng.ceg("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
            } else
            {
                dng.ceg("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += dnk[j3];

                dng.ceg("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                dng.ceg("@cya@Combat level: " + ejk.hbi, i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(eji == 1)
        {
            ejg.ghe(ejh);
            ejg.ghg(ejh, 0, "@whi@Quest-list (green=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                ejg.ghg(ejh, j1 + 1, (dfm[j1] ? "@gre@" : "@red@") + elg[j1]);

            ejg.gfj();
        }
        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 199);
        j = super.flh - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 275)
        {
            if(eji == 1)
                ejg.gfg(i + (((blm) (dng)).bln - 199), j + 36, super.flj, super.fli);
            if(j <= 24 && ddk == 1)
            {
                if(i < 98)
                {
                    eji = 0;
                    return;
                }
                if(i > 98)
                    eji = 1;
            }
        }
    }

    private final int fdm(int i)
    {
        boolean flag = false;
        int j = 0;
        for(int k = 0; k < ena; k++)
            if(enb[k] == i)
                if(ahd.ajf[i] == 1)
                    j++;
                else
                    j += enc[k];

        return j;
    }

    protected final void acc()
    {
        ecf = 0;
        if(dmm != 0)
        {
            ade();
            return;
        } else
        {
            super.acc();
            return;
        }
    }

    private final gnm fdn(int i, int j, int k, int l)
    {
        boolean flag1 = false;
        if(ekm[i] == null)
        {
            ekm[i] = new gnm();
            ekm[i].hab = i;
            ekm[i].hac = 0;
        }
        gnm gnm1 = ekm[i];
        boolean flag = false;
        for(int i1 = 0; i1 < dkb; i1++)
        {
            if(did[i1].hab != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            gnm1.hai = l;
            int j1 = gnm1.hak;
            if(j != gnm1.hal[j1] || k != gnm1.ham[j1])
            {
                gnm1.hak = j1 = (j1 + 1) % 10;
                gnm1.hal[j1] = j;
                gnm1.ham[j1] = k;
            }
        } else
        {
            gnm1.hab = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.had = j;
            gnm1.ham[0] = gnm1.hae = k;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        eml[dka++] = gnm1;
        return gnm1;
    }

    private final void fea()
    {
        byte abyte0[] = faf("config" + cff.cfi + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            egd = true;
            return;
        }
        ahd.bad(abyte0, ech);
        byte abyte1[] = faf("filter" + cff.cgb + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            egd = true;
            return;
        } else
        {
            byte abyte2[] = fnf.gak("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = fnf.gak("badenc.txt", 0, abyte1);
            byte abyte4[] = fnf.gak("hostenc.txt", 0, abyte1);
            byte abyte5[] = fnf.gak("tldlist.txt", 0, abyte1);
            ffn.fgm(new dbh(abyte2), new dbh(abyte3), new dbh(abyte4), new dbh(abyte5));
            return;
        }
    }

    private final void feb(int i)
    {
        int j = eef[i];
        int k = eeg[i];
        int l = edg[i];
        int i1 = edh[i];
        int j1 = edi[i];
        int k1 = dne[i];
        if(k1 == 200)
        {
            fel(ejl, ejm, j, k, true);
            super.aah.hfc(204);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 210)
        {
            fel(ejl, ejm, j, k, true);
            super.aah.hfc(83);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 220)
        {
            fel(ejl, ejm, j, k, true);
            super.aah.hfc(80);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
        }
        if(k1 == 3200)
            enl(ahd.amc[l], 3);
        if(k1 == 300)
        {
            fff(j, k, l);
            super.aah.hfc(121);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfj(l);
            super.aah.hfl(i1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 310)
        {
            fff(j, k, l);
            super.aah.hfc(97);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfj(l);
            super.aah.hfl(i1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 320)
        {
            fff(j, k, l);
            super.aah.hfc(46);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfj(l);
            super.aah.hem();
        }
        if(k1 == 2300)
        {
            fff(j, k, l);
            super.aah.hfc(112);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfj(l);
            super.aah.hem();
        }
        if(k1 == 3300)
            enl(ahd.akm[l], 3);
        if(k1 == 400)
        {
            fcc(j, k, l, i1);
            super.aah.hfc(136);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(j1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 410)
        {
            fcc(j, k, l, i1);
            super.aah.hfc(34);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(j1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 420)
        {
            fcc(j, k, l, i1);
            super.aah.hfc(48);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hem();
        }
        if(k1 == 2400)
        {
            fcc(j, k, l, i1);
            super.aah.hfc(199);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hem();
        }
        if(k1 == 3400)
            enl(ahd.aki[l], 3);
        if(k1 == 600)
        {
            super.aah.hfc(155);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 610)
        {
            super.aah.hfc(150);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 620)
        {
            super.aah.hfc(154);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 630)
        {
            super.aah.hfc(14);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 640)
        {
            super.aah.hfc(241);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 650)
        {
            dgb = l;
            egh = 0;
            dgc = ahd.amb[enb[dgb]];
        }
        if(k1 == 660)
        {
            super.aah.hfc(236);
            super.aah.hfl(l);
            super.aah.hem();
            dgb = -1;
            egh = 0;
            enl("Dropping " + ahd.amb[enb[l]], 4);
        }
        if(k1 == 3600)
            enl(ahd.amc[l], 3);
        if(k1 == 700)
        {
            int l1 = (j - 64) / eic;
            int l3 = (k - 64) / eic;
            faj(ejl, ejm, l1, l3, true);
            super.aah.hfc(129);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 710)
        {
            int i2 = (j - 64) / eic;
            int i4 = (k - 64) / eic;
            faj(ejl, ejm, i2, i4, true);
            super.aah.hfc(115);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 720)
        {
            int j2 = (j - 64) / eic;
            int j4 = (k - 64) / eic;
            faj(ejl, ejm, j2, j4, true);
            super.aah.hfc(62);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 725)
        {
            int k2 = (j - 64) / eic;
            int k4 = (k - 64) / eic;
            faj(ejl, ejm, k2, k4, true);
            super.aah.hfc(225);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 715 || k1 == 2715)
	
        {
            int l2 = (j - 64) / eic;
            int l4 = (k - 64) / eic;
            faj(ejl, ejm, l2, l4, true);
            super.aah.hfc(220);
            super.aah.hfl(l);
            super.aah.hem();

}
        if(k1 == 3700)
            enl(ahd.ana[l], 3);
        if(k1 == 800)
        {
            int i3 = (j - 64) / eic;
            int i5 = (k - 64) / eic;
            faj(ejl, ejm, i3, i5, true);
            super.aah.hfc(5);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 810)
        {
            int j3 = (j - 64) / eic;
            int j5 = (k - 64) / eic;
            faj(ejl, ejm, j3, j5, true);
            super.aah.hfc(54);
            super.aah.hfl(l);
            super.aah.hfl(i1);
            super.aah.hem();
            dgb = -1;
        }
        if(k1 == 805 || k1 == 2805)
	
	
        {
            int k3 = (j - 64) / eic;
            int k5 = (k - 64) / eic;
            faj(ejl, ejm, k3, k5, true);
            super.aah.hfc(77);
            super.aah.hfl(l);
            super.aah.hem();
        

}
        if(k1 == 2806)
        {
            super.aah.hfc(250);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 2810)
        {
            super.aah.hfc(73);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 2820)
        {
            super.aah.hfc(72);
            super.aah.hfl(l);
            super.aah.hem();
        }
        if(k1 == 900)
        {
            faj(ejl, ejm, j, k, true);
            super.aah.hfc(22);
            super.aah.hfl(j + dmn);
            super.aah.hfl(k + dna);
            super.aah.hfl(l);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 920)
        {
            faj(ejl, ejm, j, k, false);
            if(efg == -24)
                efg = 24;
        }
        if(k1 == 1000)
        {
            super.aah.hfc(196);
            super.aah.hfl(l);
            super.aah.hem();
            eca = -1;
        }
        if(k1 == 4000)
        {
            dgb = -1;
            eca = -1;
        }
    }

    private final void fec()
    {
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 && super.flh < 35)
            egh = 1;
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 - 33 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 33 && super.flh < 35)
        {
            egh = 2;
            ddg = (int)(Math.random() * 13D) - 6;
            ddh = (int)(Math.random() * 23D) - 11;
        }
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 - 66 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 66 && super.flh < 35)
            egh = 3;
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 - 99 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 99 && super.flh < 35)
            egh = 4;
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 - 132 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 132 && super.flh < 35)
            egh = 5;
        if(egh == 0 && super.flg >= ((blm) (dng)).bln - 35 - 165 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 165 && super.flh < 35)
            egh = 6;
        if(egh != 0 && super.flg >= ((blm) (dng)).bln - 35 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 && super.flh < 26)
            egh = 1;
        if(egh != 0 && egh != 2 && super.flg >= ((blm) (dng)).bln - 35 - 33 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 33 && super.flh < 26)
        {
            egh = 2;
            ddg = (int)(Math.random() * 13D) - 6;
            ddh = (int)(Math.random() * 23D) - 11;
        }
        if(egh != 0 && super.flg >= ((blm) (dng)).bln - 35 - 66 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 66 && super.flh < 26)
            egh = 3;
        if(egh != 0 && super.flg >= ((blm) (dng)).bln - 35 - 99 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 99 && super.flh < 26)
            egh = 4;
        if(egh != 0 && super.flg >= ((blm) (dng)).bln - 35 - 132 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 132 && super.flh < 26)
            egh = 5;
        if(egh != 0 && super.flg >= ((blm) (dng)).bln - 35 - 165 && super.flh >= 3 && super.flg < ((blm) (dng)).bln - 3 - 165 && super.flh < 26)
            egh = 6;
        if(egh == 1 && (super.flg < ((blm) (dng)).bln - 248 || super.flh > 36 + (egl / 5) * 34))
            egh = 0;
        if(egh == 3 && (super.flg < ((blm) (dng)).bln - 199 || super.flh > 316))
            egh = 0;
        if((egh == 2 || egh == 4 || egh == 5) && (super.flg < ((blm) (dng)).bln - 199 || super.flh > 240))
            egh = 0;
        if(egh == 6 && (super.flg < ((blm) (dng)).bln - 199 || super.flh > 311))
            egh = 0;
    }

    private final void fed()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(eeh)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        dng.cbh(56, 167 - c1 / 2, 400, c1, 0);
        dng.cbi(56, 167 - c1 / 2, 400, c1, 0xffffff);
        dng.cef(ddf, 256, (167 - c1 / 2) + 20, 1, 0xffffff, 360);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.flh > i - 12 && super.flh <= i && super.flg > 106 && super.flg < 406)
            j = 0xff0000;
        dng.cee("Click here to close window", 256, i, 1, j);
        if(ddk == 1)
        {
            if(j == 0xff0000)
                dgn = false;
            if((super.flg < 56 || super.flg > 456) && (super.flh < 167 - c1 / 2 || super.flh > 167 + c1 / 2))
                dgn = false;
        }
        ddk = 0;
    }

    private final void fee()
    {
        boolean flag = false;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(ddk != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.flg <= 7 || super.flg >= 182 || super.flh <= 15 + i * 20 || super.flh >= 15 + i * 20 + 20)
                    continue;
                eff = i - 1;
                ddk = 0;
                super.aah.hfc(134);
                super.aah.hfj(eff);
                super.aah.hem();
                break;
            }

        }
        for(int j = 0; j < 5; j++)
        {
            if(j == eff + 1)
                dng.cbf(7, 15 + j * 20, 175, 20, 0xff0000, 128);
            else
                dng.cbf(7, 15 + j * 20, 175, 20, 0xbebebe, 128);
            dng.cbj(7, 15 + j * 20, 175, 0);
            dng.cbj(7, 15 + j * 20 + 20, 175, 0);
        }

        dng.cee("Select combat style", 94, 31, 3, 0xffffff);
        dng.cee("@gre@Controlled ", 94, 51, 3, 0);
        dng.cee("@gre@Strength ", 94, 71, 3, 0);
        dng.cee("@gre@Attack  ", 94, 91, 3, 0);
        dng.cee("@gre@Defense  ", 94, 111, 3, 0);
    }

    private final void fef()
    {
        if(super.abj > 0)
            super.abj--;
        if(eed == 0)
        {
            dln.gfg(super.flg, super.flh, super.flj, super.fli);
            if(dln.gfh(djj))
                eed = 1;
            if(dln.gfh(djk))
            {
                eed = 2;
                djl.ghi(dfg, "@whi@Please enter your username and password");
                djl.ghi(dfh, "");
                djl.ghi(dfi, "");
                djl.ghm(dfh);
                return;
            }
        } else
        if(eed == 1)
        {
            dni.gfg(super.flg, super.flh, super.flj, super.fli);
            if(dni.gfh(ded))
            {
                eed = 0;
                return;
            }
        } else
        if(eed == 2)
        {
            djl.gfg(super.flg, super.flh, super.flj, super.fli);
            if(djl.gfh(dfk))
                eed = 0;
            if(djl.gfh(dfh))
                djl.ghm(dfi);
            if(djl.gfh(dfi) || djl.gfh(dfj))
            {
                eld = djl.ghj(dfh);
                ele = djl.ghj(dfi);
                aca(eld, ele, false);
            }
        }
    }

    private final void feg()
    {
        try
        {
            if(dng != null)
            {
                dng.ccb();
                dng.bmf = null;
                dng = null;
            }
            if(egn != null)
            {
                egn.bhf();
                egn = null;
            }
            eaj = null;
            emm = null;
            emf = null;
            ekm = null;
            eml = null;
            eab = null;
            dif = null;
            ejk = null;
            if(dlm != null)
            {
                dlm.gja = null;
                dlm.gjb = null;
                dlm.gkd = null;
                dlm.gke = null;
                dlm = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    protected final void add()
    {
        boolean flag = false;
        ecf = 0;
        eff = 0;
	super.aah.hfc(134);
	super.aah.hfj(eff);
	super.aah.hem();
	dmm = 0;
        eed = 0;
        eid = 1;
        fcm();
        dng.cbd();
        dng.cbc(dil, 0, 0);
        for(int i = 0; i < eif; i++)
        {
            egn.bhe(emm[i]);
            dlm.gmm(ekn[i], ela[i], elb[i]);
        }

        for(int j = 0; j < eim; j++)
        {
            egn.bhe(emf[j]);
            dlm.gle(ddm[j], ddn[j], emg[j], emh[j]);
        }

        eif = 0;
        eim = 0;
        dfc = 0;
        dka = 0;
        for(int k = 0; k < 4000; k++)
            ekm[k] = null;

        for(int l = 0; l < 500; l++)
            eml[l] = null;

        ehd = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            eab[i1] = null;

        for(int j1 = 0; j1 < 500; j1++)
            dif[j1] = null;

        for(int k1 = 0; k1 < 50; k1++)
            djb[k1] = false;

        ddk = 0;
        super.flj = 0;
        super.fli = 0;
        eec = false;
        dnf = false;
        ddj = false;
    }

    private final gnm feh(int i, int j, int k, int l, int i1)
    {
        boolean flag1 = false;
        if(eab[i] == null)
        {
            eab[i] = new gnm();
            eab[i].hab = i;
        }
        gnm gnm1 = eab[i];
        boolean flag = false;
        for(int j1 = 0; j1 < ehe; j1++)
        {
            if(dnj[j1].hab != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            gnm1.haf = i1;
            gnm1.hai = l;
            int k1 = gnm1.hak;
            if(j != gnm1.hal[k1] || k != gnm1.ham[k1])
            {
                gnm1.hak = k1 = (k1 + 1) % 10;
                gnm1.hal[k1] = j;
                gnm1.ham[k1] = k;
            }
        } else
        {
            gnm1.hab = i;
            gnm1.haj = 0;
            gnm1.hak = 0;
            gnm1.hal[0] = gnm1.had = j;
            gnm1.ham[0] = gnm1.hae = k;
            gnm1.haf = i1;
            gnm1.hai = gnm1.hah = l;
            gnm1.hag = 0;
        }
        dif[ehd++] = gnm1;
        return gnm1;
    }

    protected final void adb(String s, String s1)
    {
        if(eed == 1)
            dni.ghi(0, s + " " + s1);
        if(eed == 2)
            djl.ghi(dfg, s + " " + s1);
        eaa = s1;
        fch();
        fmh();
    }

    protected final void fei(int i, int j, int k)
    {
        boolean flag1 = false;
        ehg[ehf] = j;
        ehh[ehf] = k;
        ehf = ehf + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = ehf - l & 0x1fff;
            if(ehg[i1] == j && ehh[i1] == k)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = ehf - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(ehg[l1] != j || ehh[l1] != k)
                        flag = true;
                    if(ehg[k1] != ehg[l1] || ehh[k1] != ehh[l1])
                        break;
                    if(j1 == l - 1 && flag && edj == 0 && dmm == 0)
                    {
                        fdc();
                        return;
                    }
                }

            }
        }

    }

    private final boolean fej(int i, int j)
    {
        boolean flag = false;
        if(ecj != 0)
        {
            dlm.gkg = false;
            return false;
        }
        dea = false;
        i += eda;
        j += edb;
        if(edd == dnb && i > dgd && i < dgf && j > dge && j < dgg)
        {
            dlm.gkg = true;
            return false;
        }
        dng.cee("Loading... Please wait", 256, 192, 1, 0xffffff);
        fcl();
        dng.cbc(dil, 0, 0);
        int k = dmn;
        int l = dna;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        edd = dnb;
        dmn = i1 * 48 - 48;
        dna = j1 * 48 - 48;
        dgd = i1 * 48 - 32;
        dge = j1 * 48 - 32;
        dgf = i1 * 48 + 32;
        dgg = j1 * 48 + 32;
        dlm.gmc(i, j, edd);
        dmn -= eda;
        dna -= edb;
        int k1 = dmn - k;
        int l1 = dna - l;
        for(int i2 = 0; i2 < eif; i2++)
        {
            ekn[i2] -= k1;
            ela[i2] -= l1;
            int j2 = ekn[i2];
            int l2 = ela[i2];
            int k3 = elb[i2];
            cgc cgc1 = emm[i2];
            try
            {
                int l4 = elc[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4)
                {
                    k5 = ahd.ami[k3];
                    i6 = ahd.amj[k3];
                } else
                {
                    i6 = ahd.ami[k3];
                    k5 = ahd.amj[k3];
                }
                int j6 = ((j2 + j2 + k5) * eic) / 2;
                int k6 = ((l2 + l2 + i6) * eic) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96)
                {
                    egn.bhd(cgc1);
                    cgc1.cnh(j6, -dlm.gnb(j6, k6), k6);
                    dlm.glc(j2, l2, k3);
                    if(k3 == 74)
                        cgc1.cng(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i2 + " obj:" + cgc1);
                runtimeexception.printStackTrace();
            }
        }

        for(int k2 = 0; k2 < eim; k2++)
        {
            ddm[k2] -= k1;
            ddn[k2] -= l1;
            int i3 = ddm[k2];
            int l3 = ddn[k2];
            int j4 = emh[k2];
            int i5 = emg[k2];
            try
            {
                dlm.gli(i3, l3, i5, j4);
                cgc cgc2 = fah(i3, l3, i5, j4, k2);
                emf[k2] = cgc2;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int j3 = 0; j3 < dfc; j3++)
        {
            djf[j3] -= k1;
            djg[j3] -= l1;
        }

        for(int i4 = 0; i4 < dka; i4++)
        {
            gnm gnm1 = eml[i4];
            gnm1.had -= k1 * eic;
            gnm1.hae -= l1 * eic;
            for(int j5 = 0; j5 <= gnm1.hak; j5++)
            {
                gnm1.hal[j5] -= k1 * eic;
                gnm1.ham[j5] -= l1 * eic;
            }

        }

        for(int k4 = 0; k4 < ehd; k4++)
        {
            gnm gnm2 = dif[k4];
            gnm2.had -= k1 * eic;
            gnm2.hae -= l1 * eic;
            for(int l5 = 0; l5 <= gnm2.hak; l5++)
            {
                gnm2.hal[l5] -= k1 * eic;
                gnm2.ham[l5] -= l1 * eic;
            }

        }

        dlm.gkg = true;
        return true;
    }

    private final void fek()
    {
        boolean flag = false;
        ahd.anm("torcha2");
        ahd.anm("torcha3");
        ahd.anm("torcha4");
        ahd.anm("skulltorcha2");
        ahd.anm("skulltorcha3");
        ahd.anm("skulltorcha4");
        ahd.anm("firea2");
        ahd.anm("firea3");
        ahd.anm("fireplacea2");
        ahd.anm("fireplacea3");
        ahd.anm("firespell2");
        ahd.anm("firespell3");
        ahd.anm("lightning2");
        ahd.anm("lightning3");
        ahd.anm("clawspell2");
        ahd.anm("clawspell3");
        ahd.anm("clawspell4");
        ahd.anm("clawspell5");
        ahd.anm("spellcharge2");
        ahd.anm("spellcharge3");
        if(fmf())
        {
            byte abyte0[] = faf("models" + cff.cfl + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                egd = true;
                return;
            }
            for(int j = 0; j < ahd.ail; j++)
            {
                int k = fnf.gai(ahd.alm[j] + ".ob3", abyte0);
                if(k != 0)
                    eaj[j] = new cgc(abyte0, k, true);
                else
                    eaj[j] = new cgc(1, 1);
                if(ahd.alm[j].equals("giantcrystal"))
                    eaj[j].cif = true;
            }

            return;
        }
        fml(70, "Loading 3d models");
        for(int i = 0; i < ahd.ail; i++)
        {
            eaj[i] = new cgc("../gamedata/models/" + ahd.alm[i] + ".ob2");
            if(ahd.alm[i].equals("giantcrystal"))
                eaj[i].cif = true;
        }

    }

    private final void fel(int i, int j, int k, int l, boolean flag)
    {
        if(fcf(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            fce(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    private final void fem()
    {
        boolean flag1 = false;
        boolean flag = false;
        byte byte0 = 50;
        byte byte1 = 50;
        dlm.gmc(2423, 2423, 0);
        dlm.gmh(eaj);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(9728, -dlm.gnb(9728, 6400), 6400, 912, 888, 0, 2200);
        egn.big();
        dng.cbm();
        dng.cbm();
        dng.cbh(0, 0, 512, 6, 0);
        for(int i = 6; i >= 1; i--)
            dng.cbn(0, i, 0, i, 512, 8);

        dng.cbh(0, 194, 512, 20, 0);
        for(int j = 6; j >= 1; j--)
            dng.cbn(0, j, 0, 194 - j, 512, 8);

        dng.cci(15, 15, dkn + 10);
        dng.cch(dlf, 0, 0, 512, 200);
        dng.cce(dlf);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(9216, -dlm.gnb(9216, 9216), 9216, 912, 888, 0, 2200);
        egn.big();
        dng.cbm();
        dng.cbm();
        dng.cbh(0, 0, 512, 6, 0);
        for(int k = 6; k >= 1; k--)
            dng.cbn(0, k, 0, k, 512, 8);

        dng.cbh(0, 194, 512, 20, 0);
        for(int l = 6; l >= 1; l--)
            dng.cbn(0, l, 0, 194 - l, 512, 8);

        dng.cci(15, 15, dkn + 10);
        dng.cch(dlf + 1, 0, 0, 512, 200);
        dng.cce(dlf + 1);
        for(int i1 = 0; i1 < 64; i1++)
        {
            egn.bhe(dlm.gkd[0][i1]);
            egn.bhe(dlm.gjb[1][i1]);
            egn.bhe(dlm.gkd[1][i1]);
            egn.bhe(dlm.gjb[2][i1]);
            egn.bhe(dlm.gkd[2][i1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
        egn.bbl = 4100;
        egn.bbm = 4100;
        egn.bbn = 1;
        egn.bca = 4000;
        egn.bje(11136, -dlm.gnb(11136, 10368), 10368, 912, 376, 0, 1000);
        egn.big();
        dng.cbm();
        dng.cbm();
        dng.cbh(0, 0, 512, 6, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            dng.cbn(0, j1, 0, j1, 512, 8);

        dng.cbh(0, 194, 512, 20, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            dng.cbn(0, k1, 0, 194, 512, 8);

        dng.cci(15, 15, dkn + 10);
        dng.cch(dkn + 10, 0, 0, 512, 200);
        dng.cce(dkn + 10);
    }

    private final void fen()
    {
        boolean flag1 = false;
        if(eca >= 0 || dgb >= 0)
        {
            ehb[emc] = "Cancel";
            eii[emc] = "";
            dne[emc] = 4000;
            emc++;
        }
        for(int i = 0; i < emc; i++)
            dmd[i] = i;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < emc - 1; j++)
            {
                int l = dmd[j];
                int j1 = dmd[j + 1];
                if(dne[l] > dne[j1])
                {
                    dmd[j] = j1;
                    dmd[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(emc > 20)
            emc = 20;
        if(emc > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < emc; i1++)
            {
                if(eii[dmd[i1]] == null || eii[dmd[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((dgb >= 0 || eca >= 0) && emc == 1)
                s = "Choose a target";
            else
            if((dgb >= 0 || eca >= 0) && emc > 1)
                s = "@whi@" + ehb[dmd[0]] + " " + eii[dmd[0]];
            else
            if(k != -1)
                s = eii[dmd[k]] + ": @whi@" + ehb[dmd[0]];
            if(emc == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(emc > 2 && s != null)
                s = s + "@whi@ / " + (emc - 1) + " more options";
            if(s != null)
                dng.ceg(s, 6, 14, 1, 0xffff00);
            if(!dfl && ddk == 1 || dfl && ddk == 1 && emc == 1)
            {
                feb(dmd[0]);
                ddk = 0;
                return;
            }
            if(!dfl && ddk == 2 || dfl && ddk == 1)
            {
                emb = (emc + 1) * 15;
                ema = dng.cem("Choose option", 1) + 5;
                for(int k1 = 0; k1 < emc; k1++)
                {
                    int l1 = dng.cem(ehb[k1] + " " + eii[k1], 1) + 5;
                    if(l1 > ema)
                        ema = l1;
                }

                elm = super.flg - ema / 2;
                eln = super.flh - 7;
                dgi = true;
                if(elm < 0)
                    elm = 0;
                if(eln < 0)
                    eln = 0;
                if(elm + ema > 510)
                    elm = 510 - ema;
                if(eln + emb > 315)
                    eln = 315 - emb;
                ddk = 0;
            }
        }
    }

    private final boolean ffa(int i)
    {
        int j = ejk.had / 128;
        int k = ejk.hae / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((dlm.gka[j][k - l] & 0x80) == 128 || (dlm.gka[j - l][k] & 0x80) == 128 || (dlm.gka[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((dlm.gka[j][k + l] & 0x80) == 128 || (dlm.gka[j - l][k] & 0x80) == 128 || (dlm.gka[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((dlm.gka[j][k + l] & 0x80) == 128 || (dlm.gka[j + l][k] & 0x80) == 128 || (dlm.gka[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((dlm.gka[j][k - l] & 0x80) == 128 || (dlm.gka[j + l][k] & 0x80) == 128 || (dlm.gka[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (dlm.gka[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (dlm.gka[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (dlm.gka[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (dlm.gka[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void ffb(int i, String s)
    {
        int j = ekn[i];
        int k = ela[i];
        int l = j - ejk.had / 128;
        int i1 = k - ejk.hae / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -7 && l < 7 && i1 > -7 && i1 < 7)
        {
            egn.bhe(emm[i]);
            int j1 = ahd.anm(s);
            cgc cgc1 = eaj[j1].daf();
            egn.bhd(cgc1);
            cgc1.cna(true, 48, 48, -50, -10, -50);
            cgc1.dah(emm[i]);
            cgc1.cig = i;
            emm[i] = cgc1;
        }
    }

    public final Image createImage(int i, int j)
    {
        if(fjb.fji != null)
            return fjb.fji.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    private final void ffc()
    {
        eid = 0;
        eed = 0;
        eld = "";
        ele = "";
        dnn = "Please enter a username:";
        eaa = "*" + eld + "*";
        dka = 0;
        ehd = 0;
    }

    private final boolean ffd(int i, int j)
    {
        if(i == 31 && (fdj(197) || fdj(615) || fdj(682)))
            return true;
        if(i == 32 && (fdj(102) || fdj(616) || fdj(683)))
            return true;
        if(i == 33 && (fdj(101) || fdj(617) || fdj(684)))
            return true;
        if(i == 34 && (fdj(103) || fdj(618) || fdj(685)))
            return true;
        return fdm(i) >= j;
    }

    public final URL getDocumentBase()
    {
        return super.getDocumentBase();
    }

    public final String getParameter(String s)
    {
        return super.getParameter(s);
    }

    private final void ffe(boolean flag)
    {
        boolean flag1 = false;
        int i = ((blm) (dng)).bln - 199;
        char c = '\234';
        char c2 = '\230';
        dng.cci(i - 49, 3, dkn + 2);
        i += 40;
        dng.cbh(i, 36, 156, 152, 0);
        dng.cba(i, 36, i + 156, 188);
        int k = 192 + ddh;
        int i1 = dml + ddg & 0xff;
        int k1 = ((ejk.had - 6040) * 3 * k) / 2048;
        int i3 = ((ejk.hae - 6040) * 3 * k) / 2048;
        int k4 = bbe.bcb[1024 - i1 * 4 & 0x3ff];
        int i5 = bbe.bcb[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        dng.cdg((i + 78) - k1, 112 + i3, dkn - 1, i1 + 64 & 0xff, k);
        for(int i7 = 0; i7 < eif; i7++)
        {
            int l1 = (((ekn[i7] * eic + 64) - ejk.had) * 3 * k) / 2048;
            int j3 = (((ela[i7] * eic + 64) - ejk.hae) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            fbd(i + 78 + l1, 112 - j3, 65535);
        }

        for(int j7 = 0; j7 < dfc; j7++)
        {
            int i2 = (((djf[j7] * eic + 64) - ejk.had) * 3 * k) / 2048;
            int k3 = (((djg[j7] * eic + 64) - ejk.hae) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            fbd(i + 78 + i2, 112 - k3, 0xff0000);
        }

        for(int k7 = 0; k7 < ehd; k7++)
        {
            gnm gnm1 = dif[k7];
            int j2 = ((gnm1.had - ejk.had) * 3 * k) / 2048;
            int l3 = ((gnm1.hae - ejk.hae) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            fbd(i + 78 + j2, 112 - l3, 0xffff00);
        }

        for(int l7 = 0; l7 < dka; l7++)
        {
            gnm gnm2 = eml[l7];
            int k2 = ((gnm2.had - ejk.had) * 3 * k) / 2048;
            int i4 = ((gnm2.hae - ejk.hae) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;
            for(int k8 = 0; k8 < super.aal; k8++)
            {
                if(gnm2.gnn != super.aam[k8] || super.aan[k8] != 99)
                    continue;
                j8 = 65280;
                break;
            }

            fbd(i + 78 + k2, 112 - i4, j8);
        }

        dng.cbe(i + 78, 112, 2, 0xffffff, 255);
        dng.cdg(i + 19, 55, dkn + 24, dml + 128 & 0xff, 128);
        dng.cba(0, 0, elh, eli + 12);
        if(!flag)
            return;
        i = super.flg - (((blm) (dng)).bln - 199);
        int i8 = super.flh - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152)
        {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + ddh;
            int j1 = dml + ddg & 0xff;
            int j = ((blm) (dng)).bln - 199;
            j += 40;
            int l2 = ((super.flg - (j + 78)) * 16384) / (3 * l);
            int j4 = ((super.flh - 112) * 16384) / (3 * l);
            int l4 = bbe.bcb[1024 - j1 * 4 & 0x3ff];
            int j5 = bbe.bcb[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += ejk.had;
            j4 = ejk.hae - j4;
            if(ddk == 1)
                faj(ejl, ejm, l2 / 128, j4 / 128, false);
            ddk = 0;
        }
    }

    private final void fff(int i, int j, int k)
    {
        if(k == 0)
        {
            fce(ejl, ejm, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            fce(ejl, ejm, i - 1, j, i, j, false, true);
            return;
        } else
        {
            fce(ejl, ejm, i, j, i, j, true, true);
            return;
        }
    }

    public mudclient()
    {
        super();
        boolean flag = false;
	
        ddf = "";
        ddi = new boolean[1500];
        ddj = false;
        ddm = new int[500];
        ddn = new int[500];
        dea = false;
        def = 1;
        deg = 2;
        deh = 2;
        dei = 8;
        dej = 14;
        del = 1;
        dem = false;
        den = false;
        dfa = false;
        dfb = false;
        dfd = false;
        dfe = false;
        dff = new int[500];
        dfl = false;
        dfm = new boolean[50];
        dfn = "";
        dga = new int[50];
        dgb = -1;
        dgc = "";
        dgh = false;
        dgi = false;
        dgj = -1;
        dgk = -1;
        dgl = -1;
        dgm = new String[5];
        dgn = false;
        dha = false;
        dhc = -1;
        dhd = -2;
        dhe = 550;
        dhk = false;
        dhm = new int[256];
        dhn = new int[256];
        dib = false;
        did = new gnm[500];
        die = new int[5];
        dif = new gnm[500];
        dig = new int[50];
        dih = new int[50];
        dii = new int[50];
        dij = new int[50];
        dim = 1;
        dja = new boolean[500];
        djb = new boolean[50];
        djd = new int[50];
        dje = new int[50];
        djf = new int[5000];
        djg = new int[5000];
        djh = new int[5000];
        dji = new int[5000];
        djm = new int[99];
        dke = new int[8];
        dkf = new int[8];
        dkh = new int[14];
        dki = new int[14];
        dkl = false;
        dkm = false;
        dlg = true;
        dli = new int[14];
        dlj = new int[14];
        dll = 2;
        dma = false;
        dmb = false;
        dmc = true;
        dmd = new int[250];
        dmf = new int[8];
        dmg = new int[8];
        dmh = new int[8000];
        dmi = new int[8000];
        dmk = false;
        dml = 128;
        dnb = -1;
        dne = new int[250];
        dnf = false;
        dnh = new int[18];
        dnj = new gnm[500];
        dnk = new int[18];
        dnm = "";
        dnn = "";
        eaa = "";
        eab = new gnm[5000];
        eae = new int[8];
        eaf = new int[8];
        eag = new int[256];
        eah = new int[256];
        eaj = new cgc[1000];
        eal = false;
        eam = false;
        eba = new int[50];
        eca = -1;
        ecc = new int[8];
        ecd = new int[8];
        ece = new String[5];
        ecg = true;
        ech = false;
        eci = "";
        edd = -1;
        edf = false;
        edg = new int[250];
        edh = new int[250];
        edi = new int[250];
        edk = new int[50];
        edl = new int[50];
        edm = false;
        eeb = false;
        eec = false;
        eee = false;
        eef = new int[250];
        eeg = new int[250];
        eeh = false;
        efe = new int[5];
        efm = new int[256];
        efn = new int[256];
        ega = new int[256];
        egb = "";
        egc = false;
        egd = false;
        egf = new int[14];
        egg = new int[14];
        egj = new int[14];
        egk = new int[14];
        egl = 30;
        ehb = new String[250];
        ehg = new int[8192];
        ehh = new int[8192];
        ehi = new int[50];
        ehm = 40;
        eic = 128;
        eie = new int[18];
        eii = new String[250];
        eik = -1;
        eil = -2;
        ejc = false;
        eje = new String[50];
        ejf = new int[50];
        ejk = new gnm();
        ejn = -1;
        eke = new int[50];
        ekf = new int[50];
        ekg = new int[50];
        ekm = new gnm[4000];
        ekn = new int[1500];
        ela = new int[1500];
        elb = new int[1500];
        elc = new int[1500];
        eld = "";
        ele = "";
        elf = 48;
        elh = 512;
        eli = 334;
        elj = 9;
        ell = false;
        eme = 2;
        emf = new cgc[500];
        emg = new int[500];
        emh = new int[500];
        emj = 0xbc614e;
        eml = new gnm[500];
        emm = new cgc[1500];
        enb = new int[35];
        enc = new int[35];
        end = new int[35];
    }
	
    private final int dch = 250;
    private final int dci = 5;
    private final int dcj = 50;
    private final int dck = 18;
    private final int dcl = 500;
    private final int dcm = 1500;
    private final int dcn = 5000;
    private final int dda = 5000;
    private final int ddb = 500;
    private final int ddc = 4000;
    private final int ddd = 500;
    private final int dde = 8000;
    private String ddf;
    private int ddg;
    private int ddh;
    private boolean ddi[];
    private boolean ddj;
    private int ddk;
    private int ddl;
    private int ddm[];
    private int ddn[];
    private boolean dea;
    private int deb;
    private int dec;
    private int ded;
    private int dee;
    private int def;
    private int deg;
    private int deh;
    private int dei;
    private int dej;
    private int dek;
    private int del;
    private boolean dem;
    private boolean den;
    private boolean dfa;
    private boolean dfb;
    private int dfc;
    private boolean dfd;
    private boolean dfe;
    private int dff[];
    private int dfg;
    private int dfh;
    private int dfi;
    private int dfj;
    private int dfk;
    private boolean dfl;
    private boolean dfm[];
    private String dfn;
    private int dga[];
    private int dgb;
    String dgc;
    private int dgd;
    private int dge;
    private int dgf;
    private int dgg;
    private boolean dgh;
    private boolean dgi;
    private int dgj;
    private int dgk;
    private int dgl;
    private String dgm[];
    private boolean dgn;
    private boolean dha;
    private long dhb;
    private int dhc;
    private int dhd;
    private int dhe;
    private int dhf[] = {
        0, 1, 2, 1
    };
    private int dhg;
    private int dhh;
    private int dhi;
    private int dhj;
    private boolean dhk;
    private int dhl;
    private int dhm[];
    private int dhn[];
    private String dia;
    private boolean dib;
    private int dic;
    private gnm did[];
    private int die[];
    private gnm dif[];
    private int dig[];
    private int dih[];
    private int dii[];
    private int dij[];
    private int dik;
    private Graphics dil;
    private int dim;
    private int din;
    private boolean dja[];
    private boolean djb[];
    private int djc;
    private int djd[];
    private int dje[];
    private int djf[];
    private int djg[];
    private int djh[];
    private int dji[];
    private int djj;
    private int djk;
    private gca djl;
    private int djm[];
    private final String djn[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int dka;
    private int dkb;
    private int dkc;
    private int dkd;
    private int dke[];
    private int dkf[];
    private int dkg;
    private int dkh[];
    private int dki[];
    private int dkj;
    private int dkk;
    private boolean dkl;
    private boolean dkm;
    private int dkn;
    private int dla;
    private int dlb;
    private int dlc;
    private int dld;
    private int dle;
    private int dlf;
    private boolean dlg;
    private int dlh;
    private int dli[];
    private int dlj[];
    private int dlk;
    private int dll;
    private gig dlm;
    private gca dln;
    private boolean dma;
    private boolean dmb;
    private boolean dmc;
    private int dmd[];
    private int dme;
    private int dmf[];
    private int dmg[];
    private int dmh[];
    private int dmi[];
    private int dmj;
    private boolean dmk;
    private int dml;
    private int dmm;
    private int dmn;
    private int dna;
    private int dnb;
    private int dnc;
    private int dnd;
    private int dne[];
    private boolean dnf;
    private dbf dng;
    private int dnh[];
    private gca dni;
    private gnm dnj[];
    private int dnk[];
    private gia dnl;
    private String dnm;
    private String dnn;
    private String eaa;
    private gnm eab[];
    private int eac;
    private int ead;
    private int eae[];
    private int eaf[];
    private int eag[];
    private int eah[];
    private int eai[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private cgc eaj[];
    private final int eak[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private boolean eal;
    private boolean eam;
    private int ean;
    private int eba[];
    private int ebb;
    private int ebc;
    private int ebd;
    private int ebe;
    private int ebf;
    private int ebg;
    private int ebh;
    private int ebi;
    private int ebj;
    private int ebk;
    private int ebl;
    private int ebm;
    private int ebn;
    private int eca;
    private int ecb;
    private int ecc[];
    private int ecd[];
    private String ece[];
    private int ecf;
    private boolean ecg;
    private boolean ech;
    private String eci;
    private int ecj;
    private int eck;
    private int ecl;
    private int ecm;
    private final int ecn[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private int eda;
    private int edb;
    private int edc;
    private int edd;
    private int ede;
    private boolean edf;
    private int edg[];
    private int edh[];
    private int edi[];
    private int edj;
    private int edk[];
    private int edl[];
    private boolean edm;
    private String edn;
    private int eea;
    private boolean eeb;
    private boolean eec;
    private int eed;
    private boolean eee;
    private int eef[];
    private int eeg[];
    private boolean eeh;
    private gca eei;
    int eej;
    int eek;
    int eel;
    int eem;
    int een;
    private int efa;
    private int efb;
    private int efc;
    private int efd;
    private int efe[];
    private int eff;
    private int efg;
    int efh;
    int efi;
    private int efj;
    private int efk;
    private int efl;
    private int efm[];
    private int efn[];
    private int ega[];
    private String egb;
    private boolean egc;
    private boolean egd;
    private int ege;
    private int egf[];
    private int egg[];
    private int egh;
    private int egi;
    private int egj[];
    private int egk[];
    private int egl;
    private int egm;
    private bbe egn;
    private int eha[][] = {
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
    private String ehb[];
    private int ehc;
    private int ehd;
    private int ehe;
    private int ehf;
    int ehg[];
    int ehh[];
    private int ehi[];
    private final int ehj[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private int ehk;
    private final String ehl[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int ehm;
    private gca ehn;
    int eia;
    int eib;
    private int eic;
    private int eid;
    private int eie[];
    private int eif;
    private int eig;
    private int eih;
    private String eii[];
    private gca eij;
    private int eik;
    private int eil;
    private int eim;
    private int ein;
    private int eja;
    private int ejb;
    private boolean ejc;
    private int ejd;
    String eje[];
    private int ejf[];
    private gca ejg;
    int ejh;
    int eji;
    private byte ejj[];
    private gnm ejk;
    int ejl;
    int ejm;
    int ejn;
    private gca eka;
    int ekb;
    int ekc;
    long ekd;
    private int eke[];
    private int ekf[];
    private int ekg[];
    private long ekh;
    private int eki;
    private int ekj;
    private int ekk;
    private int ekl;
    private gnm ekm[];
    private int ekn[];
    private int ela[];
    private int elb[];
    private int elc[];
    private String eld;
    private String ele;
    private int elf;
    private final String elg[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private int elh;
    private int eli;
    private int elj;
    private int elk;
    private boolean ell;
    private int elm;
    private int eln;
    private int ema;
    private int emb;
    private int emc;
    private int emd;
    private int eme;
    private cgc emf[];
    private int emg[];
    private int emh[];
    private int emi[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private int emj;
    private final String emk[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private gnm eml[];
    private cgc emm[];
    private int emn;
    private int ena;
    private int enb[];
    private int enc[];
    private int end[];
    private final String ene[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
