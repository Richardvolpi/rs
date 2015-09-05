/*
 * deobfuscatorzed by saevion
 * thanks to the apache-jarkarta group for
 * the bcel and regexp libraries
 * decompiled by JAD
 */
import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.io.File;

public abstract class mudclient extends b
{

    public boolean rendering = true;
    String[] badNames = new String[] { "paul", "andrew", "mark", "daniel" };
    /* public static  void main(String args[]    {
        mudclient mudclient1 = new mudclient();
        mudclient1.elb = false;
        if(args.length > 0 && args[0].equals("members"))
            mudclient1.egg = true;
        if(args.length > 1)
            mudclient1.aac = args[1];
        if(args.length > 2)
            mudclient1.aad = Integer.parseInt(args[2]);
        mudclient1.flc(mudclient1.ddg, mudclient1.ddh + 11, "Runescape by Andrew Gower", false);
        mudclient1.fkd = 10;
        }*/

    private final void emg()
    {
        if(dnd != 0)
        {
            for(int l = 0; l < ehh; l++)
            {
                if(super.fke >= dgm.cef(egf[l], 1) || super.fkf <= l * 12 || super.fkf >= 12 + l * 12)
                    continue;
                super.aag.hda(203);
                super.aag.hea(l);
                super.aag.hdm();
                break;
            }

            dnd = 0;
            eca = false;
            return;
        }
        for(int i1 = 0; i1 < ehh; i1++)
        {
            int j1 = 65535;
            if(super.fke < dgm.cef(egf[i1], 1) && super.fkf > i1 * 12 && super.fkf < 12 + i1 * 12)
                j1 = 0xff0000;
            dgm.cdn(egf[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final void emh()
    {
        if(super.fkm.length() > 0)
        {
            String s1 = super.fkm.trim();
            super.fkl = "";
            super.fkm = "";
            if(s1.length() > 0)
            {
                long l1 = t.fnc(s1);
                super.aag.hda(180);
                super.aag.hdj(l1);
                super.aag.hea(ecl);
                super.aag.hea(dna ? 1 : 0);
                super.aag.hdm();
            }
            eli = 0;
            return;
        }
        dgm.cba(56, 130, 400, 100, 0);
        dgm.cbb(56, 130, 400, 100, 0xffffff);
        int l = 160;
        dgm.cdl("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        dgm.cdl("Name: " + super.fkl + "*", 256, l, 4, 0xffffff);
        if(super.abj > 0)
        {
            l = 207;
            if(dna)
                dgm.cdl("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                dgm.cdl("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.fke > 106 && super.fke < 406 && super.fkf > l - 13 && super.fkf < l + 2 && dnd == 1)
            {
                dnd = 0;
                dna = !dna;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 13 && super.fkf < l + 2)
        {
            i1 = 0xffff00;
            if(dnd == 1)
            {
                dnd = 0;
                eli = 0;
            }
        }
        dgm.cdl("Click here to cancel", 256, l, 1, i1);
        if(dnd == 1 && (super.fke < 56 || super.fke > 456 || super.fkf < 130 || super.fkf > 230))
        {
            dnd = 0;
            eli = 0;
        }
    }

    private static final String emi(int arg0)
    {
        String s1 = String.valueOf(arg0);
        for(int l = s1.length() - 3; l > 0; l -= 3)
            s1 = s1.substring(0, l) + "," + s1.substring(l);

        if(s1.length() > 8)
            s1 = "@gre@" + s1.substring(0, s1.length() - 8) + " million @whi@(" + s1 + ")";
        else
        if(s1.length() > 4)
            s1 = "@cya@" + s1.substring(0, s1.length() - 4) + "K @whi@(" + s1 + ")";
        return s1;
    }

    private final void emj()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(ddk)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        dgm.cba(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        dgm.cbb(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        dgm.cdm(ddl, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.fkf > l - 12 && super.fkf <= l && super.fke > 106 && super.fke < 406)
            i1 = 0xff0000;
        dgm.cdl("Click here to close window", 256, l, 1, i1);
        if(dnd == 1)
        {
            if(i1 == 0xff0000)
                dif = false;
            if((super.fke < 256 - c1 / 2 || super.fke > 256 + c1 / 2) && (super.fkf < 167 - c2 / 2 || super.fkf > 167 + c2 / 2))
                dif = false;
        }
        dnd = 0;
    }

    protected final void add()
    {
        dij = 0;
        deg = 0;
        eil = 0;
        dig = 0;
    }

    protected final void emk()
    {
        if(eha)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 16));
            g1.setColor(Color.yellow);
            int l = 35;
            g1.drawString("Sorry, an error has occured whilst loading RuneScape", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.drawString("To fix this try the following (in order):", 30, l);
            l += 50;
            g1.setColor(Color.white);
            g1.setFont(new Font("Helvetica", 1, 12));
            g1.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, l);
            l += 30;
            g1.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, l);
            l += 30;
            g1.drawString("3: Try using a different game-world", 30, l);
            l += 30;
            g1.drawString("4: Try rebooting your computer", 30, l);
            l += 30;
            g1.drawString("5: Try selecting a different version of Java from the play-game menu", 30, l);
            fle(1);
            return;
        }
        if(dck)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            fle(1);
            return;
        }
        if(eek)
        {
            Graphics g3 = getGraphics();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            fle(1);
            return;
        }
        try
        {
            if(eil == 0)
            {
                dgm.bnf = false;
                fad();
            }
            if(eil == 1)
            {
                dgm.bnf = true;
                fdd();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            fbf();
            eek = true;
        }
    }

    public final Image createImage(int l, int i1)
    {
        if(a.fig != null)
            return a.fig.createImage(l, i1);
        if(link.fni != null)
            return link.fni.createImage(l, i1);
        else
            return super.createImage(l, i1);
    }

    private final void eml()
    {
        eil = 0;
        deg = 0;
        dhi = "";
        dhj = "";
        ecj = "Please enter a username:";
        eck = "*" + dhi + "*";
        dic = 0;
        efl = 0;
    }

    private final void emm()
    {
        if(dnd != 0 && dnj == 0)
            dnj = 1;
        if(dnj > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < dfk)
                    {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = dfl[j1];
                        for(int j4 = 0; j4 < ekf; j4++)
                            if(ekg[j4] == j3)
                                if(e.ahd[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < dnj; l4++)
                                    {
                                        if(ekh[j4] < dfm[j1])
                                            ekh[j4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(enf(j3) <= k2)
                            flag = true;
                        if(e.ahh[j3] == 1)
                        {
                            feb("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && ekf < 12)
                        {
                            ekg[ekf] = j3;
                            ekh[ekf] = 1;
                            ekf++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.aag.hda(116);
                            super.aag.hea(ekf);
                            for(int i5 = 0; i5 < ekf; i5++)
                            {
                                super.aag.hdk(ekg[i5]);
                                super.aag.hdb(ekh[i5]);
                            }

                            super.aag.hdm();
                            eii = false;
                            eij = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 133)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < ekf)
                    {
                        int i2 = ekg[k1];
                        for(int l2 = 0; l2 < dnj; l2++)
                        {
                            if(e.ahd[i2] == 0 && ekh[k1] > 1)
                            {
                                ekh[k1]--;
                                continue;
                            }
                            ekf--;
                            dni = 0;
                            for(int k3 = k1; k3 < ekf; k3++)
                            {
                                ekg[k3] = ekg[k3 + 1];
                                ekh[k3] = ekh[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hda(116);
                        super.aag.hea(ekf);
                        for(int l3 = 0; l3 < ekf; l3++)
                        {
                            super.aag.hdk(ekg[l3]);
                            super.aag.hdb(ekh[l3]);
                        }

                        super.aag.hdm();
                        eii = false;
                        eij = false;
                    }
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    eij = true;
                    super.aag.hda(38);
                    super.aag.hdm();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    ece = false;
                    super.aag.hda(178);
                    super.aag.hdm();
                }
            } else
            if(dnd != 0)
            {
                ece = false;
                super.aag.hda(178);
                super.aag.hdm();
            }
            dnd = 0;
            dnj = 0;
        }
        if(!ece)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dgm.cba(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        dgm.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        dgm.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        dgm.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        dgm.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        dgm.cam(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        dgm.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        dgm.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        dgm.cam(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        dgm.cam(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        dgm.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            dgm.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            dgm.cbc(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            dgm.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                dgm.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                dgm.cbd(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            dgm.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        dgm.cdn("Trading with: " + ddm, byte0 + 1, byte1 + 10, 1, 0xffffff);
        dgm.cdn("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        dgm.cdn("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        dgm.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!eij)
            dgm.ccb(byte0 + 217, byte1 + 238, eim + 25);
        dgm.ccb(byte0 + 394, byte1 + 238, eim + 26);
        if(eii)
        {
            dgm.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            dgm.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(eij)
        {
            dgm.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            dgm.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < dfk; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            dgm.cdd(l5, j6, 48, 32, eja + e.ahb[dfl[k5]], e.ahg[dfl[k5]], 0, 0, false);
            if(e.ahd[dfl[k5]] == 0)
                dgm.cdn(String.valueOf(dfm[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < ekf; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            dgm.cdd(k6, i7, 48, 32, eja + e.ahb[ekg[i6]], e.ahg[ekg[i6]], 0, 0, false);
            if(e.ahd[ekg[i6]] == 0)
                dgm.cdn(String.valueOf(ekh[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                dgm.cdn(e.alb[ekg[i6]] + ": @whi@" + e.alc[ekg[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < eeg; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            dgm.cdd(j7, k7, 48, 32, eja + e.ahb[eeh[l6]], e.ahg[eeh[l6]], 0, 0, false);
            if(e.ahd[eeh[l6]] == 0)
                dgm.cdn(String.valueOf(eei[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                dgm.cdn(e.alb[eeh[l6]] + ": @whi@" + e.alc[eeh[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void emn()
    {
        ecg = new h(dgm, 50);
        int l = 40;
        if(!egg)
        {
            ecg.gfd(256, 200 + l, "Click on an option", 5, true);
            ecg.gfe(156, 240 + l, 120, 35);
            ecg.gfe(356, 240 + l, 120, 35);
            ecg.gfd(156, 240 + l, "New User", 5, false);
            ecg.gfd(356, 240 + l, "Existing User", 5, false);
            ebm = ecg.gfl(156, 240 + l, 120, 35);
            ebn = ecg.gfl(356, 240 + l, 120, 35);
        } else
        {
            ecg.gfd(256, 200 + l, "Welcome to RuneScape", 4, true);
            ecg.gfd(256, 215 + l, "You need a member account to use this server", 4, true);
            ecg.gfe(256, 250 + l, 200, 35);
            ecg.gfd(256, 250 + l, "Click here to login", 5, false);
            ebn = ecg.gfl(256, 250 + l, 200, 35);
        }
        dcl = new h(dgm, 50);
        l = 230;
        if(dhf == 0)
        {
            dcl.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dcl.gfd(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(dhf == 1)
        {
            dcl.gfd(256, l + 8, "To create an account please click on the", 4, true);
            l += 20;
            dcl.gfd(256, l + 8, "'create account' link below the game window", 4, true);
        } else
        {
            dcl.gfd(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            dcl.gfd(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        l += 30;
        dcl.gfe(256, l + 17, 150, 34);
        dcl.gfd(256, l + 17, "Ok", 5, false);
        dhh = dcl.gfl(256, l + 17, 150, 34);
        dil = new h(dgm, 50);
        l = 230;
        ecm = dil.gfd(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        dil.gfe(140, l, 200, 40);
        dil.gfd(140, l - 10, "Username:", 4, false);
        ecn = dil.gfj(140, l + 10, 200, 40, 4, 13, false, false);
        l += 47;
        dil.gfe(190, l, 200, 40);
        dil.gfd(190, l - 10, "Password:", 4, false);
        eda = dil.gfj(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        dil.gfe(410, l, 120, 25);
        dil.gfd(410, l, "Ok", 4, false);
        edb = dil.gfl(410, l, 120, 25);
        l += 30;
        dil.gfe(410, l, 120, 25);
        dil.gfd(410, l, "Cancel", 4, false);
        edc = dil.gfl(410, l, 120, 25);
        l += 30;
        dil.ggg(ecn);
    }

    private final void ena(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 199;
        int i1 = 36;
        dgm.ccb(l - 49, 3, eim + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(dme == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dgm.cam(l, i1, c1 / 2, 24, j1, 128);
        dgm.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dgm.cam(l, i1 + 24, c1, 90, j.cbh(220, 220, 220), 128);
        dgm.cam(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.cbh(160, 160, 160), 128);
        dgm.cbc(l, i1 + 24, c1, 0);
        dgm.cbd(l + c1 / 2, i1, 24, 0);
        dgm.cbc(l, i1 + 113, c1, 0);
        dgm.cdl("Magic", l + c1 / 4, i1 + 16, 4, 0);
        dgm.cdl("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dme == 0)
        {
            dmc.gfm(dmd);
            int l1 = 0;
            for(int l2 = 0; l2 < e.alm; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < e.akd[l2]; k4++)
                {
                    int j5 = e.akf[l2][k4];
                    if(fcn(j5, e.akg[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = dhc[6];
                if(e.akc[l2] > k5)
                    s1 = "@bla@";
                dmc.gga(dmd, l1++, s1 + "Level " + e.akc[l2] + ": " + e.alk[l2]);
            }

            dmc.ged();
            int l3 = dmc.ggh(dmd);
            if(l3 != -1)
            {
                dgm.cdn("Level " + e.akc[l3] + ": " + e.alk[l3], l + 2, i1 + 124, 1, 0xffff00);
                dgm.cdn(e.all[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < e.akd[l3]; l4++)
                {
                    int l5 = e.akf[l3][l4];
                    dgm.ccb(l + 2 + l4 * 44, i1 + 150, eja + e.ahb[l5]);
                    int i6 = enf(l5);
                    int j6 = e.akg[l3][l4];
                    String s3 = "@red@";
                    if(fcn(l5, j6))
                        s3 = "@gre@";
                    dgm.cdn(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                dgm.cdn("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(dme == 1)
        {
            dmc.gfm(dmd);
            int i2 = 0;
            for(int i3 = 0; i3 < e.akb; i3++)
            {
                String s2 = "@whi@";
                if(e.aji[i3] > eab[5])
                    s2 = "@bla@";
                if(ddj[i3])
                    s2 = "@gre@";
                dmc.gga(dmd, i2++, s2 + "Level " + e.aji[i3] + ": " + e.anb[i3]);
            }

            dmc.ged();
            int i4 = dmc.ggh(dmd);
            if(i4 != -1)
            {
                dgm.cdl("Level " + e.aji[i4] + ": " + e.anb[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                dgm.cdl(e.anc[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                dgm.cdl("Drain rate: " + e.ajj[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                dgm.cdn("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            dmc.gea(l + (((j) (dgm)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnd == 1)
                if(l < 98 && dme == 1)
                {
                    dme = 0;
                    dmc.gfn(dmd);
                } else
                if(l > 98 && dme == 0)
                {
                    dme = 1;
                    dmc.gfn(dmd);
                }
            if(dnd == 1 && dme == 0)
            {
                int j2 = dmc.ggh(dmd);
                if(j2 != -1)
                {
                    int j3 = dhc[6];
                    if(e.akc[j2] > j3)
                    {
                        feb("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < e.akd[j2]; j4++)
                        {
                            int i5 = e.akf[j2][j4];
                            if(fcn(i5, e.akg[j2][j4]))
                                continue;
                            feb("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == e.akd[j2])
                        {
                            dnb = j2;
                            djk = -1;
                        }
                    }
                }
            }
            if(dnd == 1 && dme == 1)
            {
                int k2 = dmc.ggh(dmd);
                if(k2 != -1)
                {
                    int k3 = eab[5];
                    if(e.aji[k2] > k3)
                        feb("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(dhc[5] == 0)
                        feb("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(ddj[k2])
                    {
                        super.aag.hda(164);
                        super.aag.hea(k2);
                        super.aag.hdm();
                        ddj[k2] = false;
                        fcg("prayeroff");
                    } else
                    {
                        super.aag.hda(17);
                        super.aag.hea(k2);
                        super.aag.hdm();
                        ddj[k2] = true;
                        fcg("prayeron");
                    }
                }
            }
            dnd = 0;
        }
    }

    private final String enb(int l)
    {
        if(link.fni != null)
            return link.gai(t.fnb(l));
        else
            return t.fnb(l);
    }

    private final void enc(int l, int i1, int j1, int k1, boolean flag)
    {
        if(fbe(l, i1, j1, k1, j1, k1, false, flag))
        {
            return;
        } else
        {
            fbd(l, i1, j1, k1, j1, k1, true, flag);
            return;
        }
    }

    private final void end(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 248;
        dgm.ccb(l, 3, eim + 1);
        for(int i1 = 0; i1 < dfj; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < dfk && dfn[i1] == 1)
                dgm.cam(j1, l1, 49, 34, 0xff0000, 128);
            else
                dgm.cam(j1, l1, 49, 34, j.cbh(181, 181, 181), 128);
            if(i1 < dfk)
            {
                dgm.cdd(j1, l1, 48, 32, eja + e.ahb[dfl[i1]], e.ahg[dfl[i1]], 0, 0, false);
                if(e.ahd[dfl[i1]] == 0)
                    dgm.cdn(String.valueOf(dfm[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            dgm.cbd(l + k1 * 49, 36, (dfj / 5) * 34, 0);

        for(int i2 = 1; i2 <= dfj / 5 - 1; i2++)
            dgm.cbc(l, 36 + i2 * 34, 245, 0);

        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 248);
        int j2 = super.fkf - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (dfj / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < dfk)
            {
                int l2 = dfl[k2];
                if(dnb >= 0)
                {
                    if(e.ake[dnb] == 3)
                    {
                        elh[djc] = "Cast " + e.alk[dnb] + " on";
                        dkb[djc] = "@lre@" + e.alb[l2];
                        eec[djc] = 600;
                        dmh[djc] = k2;
                        dmi[djc] = dnb;
                        djc++;
                        return;
                    }
                } else
                {
                    if(djk >= 0)
                    {
                        elh[djc] = "Use " + djl + " with";
                        dkb[djc] = "@lre@" + e.alb[l2];
                        eec[djc] = 610;
                        dmh[djc] = k2;
                        dmi[djc] = djk;
                        djc++;
                        return;
                    }
                    if(dfn[k2] == 1)
                    {
                        elh[djc] = "Remove";
                        dkb[djc] = "@lre@" + e.alb[l2];
                        eec[djc] = 620;
                        dmh[djc] = k2;
                        djc++;
                    } else
                    if(e.ahf[l2] != 0)
                    {
                        if((e.ahf[l2] & 0x18) != 0)
                            elh[djc] = "Wield";
                        else
                            elh[djc] = "Wear";
                        dkb[djc] = "@lre@" + e.alb[l2];
                        eec[djc] = 630;
                        dmh[djc] = k2;
                        djc++;
                    }
                    if(!e.ald[l2].equals(""))
                    {
                        elh[djc] = e.ald[l2];
                        dkb[djc] = "@lre@" + e.alb[l2];
                        eec[djc] = 640;
                        dmh[djc] = k2;
                        djc++;
                    }
                    elh[djc] = "Use";
                    dkb[djc] = "@lre@" + e.alb[l2];
                    eec[djc] = 650;
                    dmh[djc] = k2;
                    djc++;
                    elh[djc] = "Drop";
                    dkb[djc] = "@lre@" + e.alb[l2];
                    eec[djc] = 660;
                    dmh[djc] = k2;
                    djc++;
                    elh[djc] = "Examine";
                    dkb[djc] = "@lre@" + e.alb[l2];
                    eec[djc] = 3600;
                    dmh[djc] = l2;
                    djc++;
                }
            }
        }
    }

    private final void ene()
    {
        if(super.abi > 0)
            super.abi--;
        if(deg == 0)
        {
            ecg.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(ecg.geb(ebm))
                deg = 1;
            if(ecg.geb(ebn))
            {
                deg = 2;
                dil.ggc(ecm, "Please enter your username and password");
                dil.ggc(ecn, "");
                dil.ggc(eda, "");
                dil.ggg(ecn);
                return;
            }
        } else
        if(deg == 1)
        {
            dcl.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dcl.geb(dhh))
            {
                deg = 0;
                return;
            }
        } else
        if(deg == 2)
        {
            dil.gea(super.fke, super.fkf, super.fkh, super.fkg);
            if(dil.geb(edc))
                deg = 0;
            if(dil.geb(ecn))
                dil.ggg(eda);
            if(dil.geb(eda) || dil.geb(edb))
            {
                dhi = dil.ggd(ecn);
                dhj = dil.ggd(eda);
                abn(dhi, dhj, false);
            }
        }
    }

    public final int enf(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < dfk; i1++)
            if(dfl[i1] == arg0)
                if(e.ahd[arg0] == 1)
                    l++;
                else
                    l += dfm[i1];

        return l;
    }

    private final void eng()
    {
        eag = new h(dgm, 100);
        eag.gfd(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        eag.gfd(l - 55, i1 + 110, "Front", 3, true);
        eag.gfd(l, i1 + 110, "Side", 3, true);
        eag.gfd(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        eag.gff(l - byte0, i1, 53, 41);
        eag.gfd(l - byte0, i1 - 8, "Head", 1, true);
        eag.gfd(l - byte0, i1 + 8, "Type", 1, true);
        eag.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dek = eag.gfl(l - byte0 - 40, i1, 20, 20);
        eag.gfg((l - byte0) + 40, i1, h.gdi + 6);
        del = eag.gfl((l - byte0) + 40, i1, 20, 20);
        eag.gff(l + byte0, i1, 53, 41);
        eag.gfd(l + byte0, i1 - 8, "Hair", 1, true);
        eag.gfd(l + byte0, i1 + 8, "Color", 1, true);
        eag.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dem = eag.gfl((l + byte0) - 40, i1, 20, 20);
        eag.gfg(l + byte0 + 40, i1, h.gdi + 6);
        den = eag.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        eag.gff(l - byte0, i1, 53, 41);
        eag.gfd(l - byte0, i1, "Gender", 1, true);
        eag.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dfa = eag.gfl(l - byte0 - 40, i1, 20, 20);
        eag.gfg((l - byte0) + 40, i1, h.gdi + 6);
        dfb = eag.gfl((l - byte0) + 40, i1, 20, 20);
        eag.gff(l + byte0, i1, 53, 41);
        eag.gfd(l + byte0, i1 - 8, "Top", 1, true);
        eag.gfd(l + byte0, i1 + 8, "Color", 1, true);
        eag.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dfc = eag.gfl((l + byte0) - 40, i1, 20, 20);
        eag.gfg(l + byte0 + 40, i1, h.gdi + 6);
        dfd = eag.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        eag.gff(l - byte0, i1, 53, 41);
        eag.gfd(l - byte0, i1 - 8, "Skin", 1, true);
        eag.gfd(l - byte0, i1 + 8, "Color", 1, true);
        eag.gfg(l - byte0 - 40, i1, h.gdi + 7);
        dfe = eag.gfl(l - byte0 - 40, i1, 20, 20);
        eag.gfg((l - byte0) + 40, i1, h.gdi + 6);
        dff = eag.gfl((l - byte0) + 40, i1, 20, 20);
        eag.gff(l + byte0, i1, 53, 41);
        eag.gfd(l + byte0, i1 - 8, "Bottom", 1, true);
        eag.gfd(l + byte0, i1 + 8, "Color", 1, true);
        eag.gfg((l + byte0) - 40, i1, h.gdi + 7);
        dfg = eag.gfl((l + byte0) - 40, i1, 20, 20);
        eag.gfg(l + byte0 + 40, i1, h.gdi + 6);
        dfh = eag.gfl(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        eag.gfe(l, i1, 200, 30);
        eag.gfd(l, i1, "Accept", 4, false);
        dfi = eag.gfl(l, i1, 200, 30);
    }

    private final void enh(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 199;
        int i1 = 36;
        dgm.ccb(l - 49, 3, eim + 6);
        char c1 = '\304';
        dgm.cam(l, 36, c1, 65, j.cbh(181, 181, 181), 160);
        dgm.cam(l, 101, c1, 65, j.cbh(201, 201, 201), 160);
        dgm.cam(l, 166, c1, 95, j.cbh(181, 181, 181), 160);
        dgm.cam(l, 261, c1, 40, j.cbh(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        dgm.cdn("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(ddf)
            dgm.cdn("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            dgm.cdn("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(djn)
            dgm.cdn("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            dgm.cdn("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(egg)
            if(ecb)
                dgm.cdn("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                dgm.cdn("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        dgm.cdn("To change your contact details,", j1, l1, 0, 0xffffff);
        l1 += 15;
        dgm.cdn("password, recovery questions, etc..", j1, l1, 0, 0xffffff);
        l1 += 15;
        dgm.cdn("please select 'account management'", j1, l1, 0, 0xffffff);
        l1 += 15;
        if(dhf == 0)
            dgm.cdn("from the runescape.com front page", j1, l1, 0, 0xffffff);
        else
        if(dhf == 1)
            dgm.cdn("from the link below the gamewindow", j1, l1, 0, 0xffffff);
        else
            dgm.cdn("from the runescape front webpage", j1, l1, 0, 0xffffff);
        l1 += 15;
        l1 += 5;
        dgm.cdn("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        dgm.cdn("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.abb == 0)
            dgm.cdn("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dgm.cdn("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abc == 0)
            dgm.cdn("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dgm.cdn("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.abd == 0)
            dgm.cdn("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            dgm.cdn("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(egg)
            if(super.abe == 0)
                dgm.cdn("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                dgm.cdn("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        dgm.cdn("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.fke > j1 && super.fke < j1 + c1 && super.fkf > l1 - 12 && super.fkf < l1 + 4)
            j2 = 0xffff00;
        dgm.cdn("Click here to logout", l + 3, l1, 1, j2);
        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((j) (dgm)).blg - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                ddf = !ddf;
                super.aag.hda(66);
                super.aag.hea(0);
                super.aag.hea(ddf ? 1 : 0);
                super.aag.hdm();
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                djn = !djn;
                super.aag.hda(66);
                super.aag.hea(2);
                super.aag.hea(djn ? 1 : 0);
                super.aag.hdm();
            }
            i2 += 15;
            if(egg && super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                ecb = !ecb;
                super.aag.hda(66);
                super.aag.hea(3);
                super.aag.hea(ecb ? 1 : 0);
                super.aag.hdm();
            }
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                super.abb = 1 - super.abb;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                super.abc = 1 - super.abc;
                flag = true;
            }
            i2 += 15;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                super.abd = 1 - super.abd;
                flag = true;
            }
            i2 += 15;
            if(egg && super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
            {
                super.abe = 1 - super.abe;
                flag = true;
            }
            i2 += 15;
            if(flag)
                acg(super.abb, super.abc, super.abd, super.abe);
            i2 += 20;
            if(super.fke > k1 && super.fke < k1 + c2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && dnd == 1)
                fae();
            dnd = 0;
        }
    }

    private final void eni()
    {
        dgm.bnc = false;
        dgm.cak();
        eag.ged();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        dgm.ccf(l - 32 - 55, i1, 64, 102, e.ajh[edh], eai[edk]);
        dgm.cdd(l - 32 - 55, i1, 64, 102, e.ajh[edg], eai[edj], eaf[edl], 0, false);
        dgm.cdd(l - 32 - 55, i1, 64, 102, e.ajh[edf], eef[edi], eaf[edl], 0, false);
        dgm.ccf(l - 32, i1, 64, 102, e.ajh[edh] + 6, eai[edk]);
        dgm.cdd(l - 32, i1, 64, 102, e.ajh[edg] + 6, eai[edj], eaf[edl], 0, false);
        dgm.cdd(l - 32, i1, 64, 102, e.ajh[edf] + 6, eef[edi], eaf[edl], 0, false);
        dgm.ccf((l - 32) + 55, i1, 64, 102, e.ajh[edh] + 12, eai[edk]);
        dgm.cdd((l - 32) + 55, i1, 64, 102, e.ajh[edg] + 12, eai[edj], eaf[edl], 0, false);
        dgm.cdd((l - 32) + 55, i1, 64, 102, e.ajh[edf] + 12, eef[edi], eaf[edl], 0, false);
        dgm.ccb(0, ddh, eim + 22);
        dgm.caj(ecf, 0, 0);
    }

    private final void enj()
    {
        int l = 2203 - (ekn + dml + dlc);
        if(ekm + dmk + dlb >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < dma; j1++)
            dcg[j1] = false;

        for(int k1 = 0; k1 < ecd; k1++)
            eah[k1] = false;

        int l1 = dhn.bhh();
        i ai[] = dhn.bhj();
        int ai1[] = dhn.bhi();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(djc > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.chl[j2] <= 65535 || l2.chl[j2] >= 0x30d40 && l2.chl[j2] <= 0x493e0)
                if(l2 == dhn.beh)
                {
                    int i3 = l2.chl[j2] % 10000;
                    int l3 = l2.chl[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(ekl.gnm > 0 && elf[i3].gnm > 0)
                            k4 = ekl.gnm - elf[i3].gnm;
                        if(k4 < 0)
                            s1 = "@or1@";
                        if(k4 < -3)
                            s1 = "@or2@";
                        if(k4 < -6)
                            s1 = "@or3@";
                        if(k4 < -9)
                            s1 = "@red@";
                        if(k4 > 0)
                            s1 = "@gr1@";
                        if(k4 > 3)
                            s1 = "@gr2@";
                        if(k4 > 6)
                            s1 = "@gr3@";
                        if(k4 > 9)
                            s1 = "@gre@";
                        s1 = " " + s1 + "(level-" + elf[i3].gnm + ")";
                        if(dnb >= 0)
                        {
                            if(e.ake[dnb] == 1 || e.ake[dnb] == 2)
                            {
                                elh[djc] = "Cast " + e.alk[dnb] + " on";
                                dkb[djc] = "@whi@" + elf[i3].gme + s1;
                                eec[djc] = 800;
                                eib[djc] = elf[i3].gmh;
                                eic[djc] = elf[i3].gmi;
                                dmh[djc] = elf[i3].gmf;
                                dmi[djc] = dnb;
                                djc++;
                            }
                        } else
                        if(djk >= 0)
                        {
                            elh[djc] = "Use " + djl + " with";
                            dkb[djc] = "@whi@" + elf[i3].gme + s1;
                            eec[djc] = 810;
                            eib[djc] = elf[i3].gmh;
                            eic[djc] = elf[i3].gmi;
                            dmh[djc] = elf[i3].gmf;
                            dmi[djc] = djk;
                            djc++;
                        } else
                        {
                            if(l > 0 && (elf[i3].gmi - 64) / eik + dml + dlc < 2203)
                            {
                                elh[djc] = "Attack";
                                dkb[djc] = "@whi@" + elf[i3].gme + s1;
                                if(k4 >= 0 && k4 < 5)
                                    eec[djc] = 805;
                                else
                                    eec[djc] = 2805;
                                eib[djc] = elf[i3].gmh;
                                eic[djc] = elf[i3].gmi;
                                dmh[djc] = elf[i3].gmf;
                                djc++;
                            } else
                            if(egg)
                            {
                                elh[djc] = "Duel with";
                                dkb[djc] = "@whi@" + elf[i3].gme + s1;
                                eib[djc] = elf[i3].gmh;
                                eic[djc] = elf[i3].gmi;
                                eec[djc] = 2806;
                                dmh[djc] = elf[i3].gmf;
                                djc++;
                            }
                            elh[djc] = "Trade with";
                            dkb[djc] = "@whi@" + elf[i3].gme + s1;
                            eec[djc] = 2810;
                            dmh[djc] = elf[i3].gmf;
                            djc++;
                            elh[djc] = "Follow";
                            dkb[djc] = "@whi@" + elf[i3].gme + s1;
                            eec[djc] = 2820;
                            dmh[djc] = elf[i3].gmf;
                            djc++;
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(dnb >= 0)
                        {
                            if(e.ake[dnb] == 3)
                            {
                                elh[djc] = "Cast " + e.alk[dnb] + " on";
                                dkb[djc] = "@lre@" + e.alb[dke[i3]];
                                eec[djc] = 200;
                                eib[djc] = dkc[i3];
                                eic[djc] = dkd[i3];
                                dmh[djc] = dke[i3];
                                dmi[djc] = dnb;
                                djc++;
                            }
                        } else
                        if(djk >= 0)
                        {
                            elh[djc] = "Use " + djl + " with";
                            dkb[djc] = "@lre@" + e.alb[dke[i3]];
                            eec[djc] = 210;
                            eib[djc] = dkc[i3];
                            eic[djc] = dkd[i3];
                            dmh[djc] = dke[i3];
                            dmi[djc] = djk;
                            djc++;
                        } else
                        {
                            elh[djc] = "Take";
                            dkb[djc] = "@lre@" + e.alb[dke[i3]];
                            eec[djc] = 220;
                            eib[djc] = dkc[i3];
                            eic[djc] = dkd[i3];
                            dmh[djc] = dke[i3];
                            djc++;
                            elh[djc] = "Examine";
                            dkb[djc] = "@lre@" + e.alb[dke[i3]];
                            eec[djc] = 3200;
                            dmh[djc] = dke[i3];
                            djc++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = dka[i3].gmj;
                        if(e.ali[i5] > 0)
                        {
                            int j5 = (e.ale[i5] + e.alh[i5] + e.alf[i5] + e.alg[i5]) / 4;
                            int k5 = (eab[0] + eab[1] + eab[2] + eab[3] + 27) / 4;
                            l4 = k5 - j5;
                            s2 = "@yel@";
                            if(l4 < 0)
                                s2 = "@or1@";
                            if(l4 < -3)
                                s2 = "@or2@";
                            if(l4 < -6)
                                s2 = "@or3@";
                            if(l4 < -9)
                                s2 = "@red@";
                            if(l4 > 0)
                                s2 = "@gr1@";
                            if(l4 > 3)
                                s2 = "@gr2@";
                            if(l4 > 6)
                                s2 = "@gr3@";
                            if(l4 > 9)
                                s2 = "@gre@";
                            s2 = " " + s2 + "(level-" + j5 + ")";
                        }
                        if(dnb >= 0)
                        {
                            if(e.ake[dnb] == 2)
                            {
                                elh[djc] = "Cast " + e.alk[dnb] + " on";
                                dkb[djc] = "@yel@" + e.amf[dka[i3].gmj];
                                eec[djc] = 700;
                                eib[djc] = dka[i3].gmh;
                                eic[djc] = dka[i3].gmi;
                                dmh[djc] = dka[i3].gmf;
                                dmi[djc] = dnb;
                                djc++;
                            }
                        } else
                        if(djk >= 0)
                        {
                            elh[djc] = "Use " + djl + " with";
                            dkb[djc] = "@yel@" + e.amf[dka[i3].gmj];
                            eec[djc] = 710;
                            eib[djc] = dka[i3].gmh;
                            eic[djc] = dka[i3].gmi;
                            dmh[djc] = dka[i3].gmf;
                            dmi[djc] = djk;
                            djc++;
                        } else
                        {
                            if(e.ali[i5] > 0)
                            {
                                elh[djc] = "Attack";
                                dkb[djc] = "@yel@" + e.amf[dka[i3].gmj] + s2;
                                if(l4 >= 0)
                                    eec[djc] = 715;
                                else
                                    eec[djc] = 2715;
                                eib[djc] = dka[i3].gmh;
                                eic[djc] = dka[i3].gmi;
                                dmh[djc] = dka[i3].gmf;
                                djc++;
                            }
                            elh[djc] = "Talk-to";
                            dkb[djc] = "@yel@" + e.amf[dka[i3].gmj];
                            eec[djc] = 720;
                            eib[djc] = dka[i3].gmh;
                            eic[djc] = dka[i3].gmi;
                            dmh[djc] = dka[i3].gmf;
                            djc++;
                            if(!e.amh[i5].equals(""))
                            {
                                elh[djc] = e.amh[i5];
                                dkb[djc] = "@yel@" + e.amf[dka[i3].gmj];
                                eec[djc] = 725;
                                eib[djc] = dka[i3].gmh;
                                eic[djc] = dka[i3].gmi;
                                dmh[djc] = dka[i3].gmf;
                                djc++;
                            }
                            elh[djc] = "Examine";
                            dkb[djc] = "@yel@" + e.amf[dka[i3].gmj];
                            eec[djc] = 3700;
                            dmh[djc] = dka[i3].gmj;
                            djc++;
                        }
                    }
                } else
                if(l2 != null && l2.chk >= 10000)
                {
                    int j3 = l2.chk - 10000;
                    int i4 = dib[j3];
                    if(!eah[j3])
                    {
                        if(dnb >= 0)
                        {
                            if(e.ake[dnb] == 4)
                            {
                                elh[djc] = "Cast " + e.alk[dnb] + " on";
                                dkb[djc] = "@cya@" + e.aie[i4];
                                eec[djc] = 300;
                                eib[djc] = dih[j3];
                                eic[djc] = dii[j3];
                                dmh[djc] = dia[j3];
                                dmi[djc] = dnb;
                                djc++;
                            }
                        } else
                        if(djk >= 0)
                        {
                            elh[djc] = "Use " + djl + " with";
                            dkb[djc] = "@cya@" + e.aie[i4];
                            eec[djc] = 310;
                            eib[djc] = dih[j3];
                            eic[djc] = dii[j3];
                            dmh[djc] = dia[j3];
                            dmi[djc] = djk;
                            djc++;
                        } else
                        {
                            if(!e.aig[i4].equalsIgnoreCase("WalkTo"))
                            {
                                elh[djc] = e.aig[i4];
                                dkb[djc] = "@cya@" + e.aie[i4];
                                eec[djc] = 320;
                                eib[djc] = dih[j3];
                                eic[djc] = dii[j3];
                                dmh[djc] = dia[j3];
                                djc++;
                            }
                            if(!e.aih[i4].equalsIgnoreCase("Examine"))
                            {
                                elh[djc] = e.aih[i4];
                                dkb[djc] = "@cya@" + e.aie[i4];
                                eec[djc] = 2300;
                                eib[djc] = dih[j3];
                                eic[djc] = dii[j3];
                                dmh[djc] = dia[j3];
                                djc++;
                            }
                            elh[djc] = "Examine";
                            dkb[djc] = "@cya@" + e.aie[i4];
                            eec[djc] = 3300;
                            dmh[djc] = i4;
                            djc++;
                        }
                        eah[j3] = true;
                    }
                } else
                if(l2 != null && l2.chk >= 0)
                {
                    int k3 = l2.chk;
                    int j4 = dji[k3];
                    if(!dcg[k3])
                    {
                        if(dnb >= 0)
                        {
                            if(e.ake[dnb] == 5)
                            {
                                elh[djc] = "Cast " + e.alk[dnb] + " on";
                                dkb[djc] = "@cya@" + e.ajl[j4];
                                eec[djc] = 400;
                                eib[djc] = djg[k3];
                                eic[djc] = djh[k3];
                                dmh[djc] = djj[k3];
                                dmi[djc] = dji[k3];
                                dmj[djc] = dnb;
                                djc++;
                            }
                        } else
                        if(djk >= 0)
                        {
                            elh[djc] = "Use " + djl + " with";
                            dkb[djc] = "@cya@" + e.ajl[j4];
                            eec[djc] = 410;
                            eib[djc] = djg[k3];
                            eic[djc] = djh[k3];
                            dmh[djc] = djj[k3];
                            dmi[djc] = dji[k3];
                            dmj[djc] = djk;
                            djc++;
                        } else
                        {
                            if(!e.ajn[j4].equalsIgnoreCase("WalkTo"))
                            {
                                elh[djc] = e.ajn[j4];
                                dkb[djc] = "@cya@" + e.ajl[j4];
                                eec[djc] = 420;
                                eib[djc] = djg[k3];
                                eic[djc] = djh[k3];
                                dmh[djc] = djj[k3];
                                dmi[djc] = dji[k3];
                                djc++;
                            }
                            if(!e.aka[j4].equalsIgnoreCase("Examine"))
                            {
                                elh[djc] = e.aka[j4];
                                dkb[djc] = "@cya@" + e.ajl[j4];
                                eec[djc] = 2400;
                                eib[djc] = djg[k3];
                                eic[djc] = djh[k3];
                                dmh[djc] = djj[k3];
                                dmi[djc] = dji[k3];
                                djc++;
                            }
                            elh[djc] = "Examine";
                            dkb[djc] = "@cya@" + e.ajl[j4];
                            eec[djc] = 3400;
                            dmh[djc] = j4;
                            djc++;
                        }
                        dcg[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.chl[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(dnb >= 0 && e.ake[dnb] <= 1)
        {
            elh[djc] = "Cast " + e.alk[dnb] + " on self";
            dkb[djc] = "";
            eec[djc] = 1000;
            dmh[djc] = dnb;
            djc++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(dnb >= 0)
            {
                if(e.ake[dnb] == 6)
                {
                    elh[djc] = "Cast " + e.alk[dnb] + " on ground";
                    dkb[djc] = "";
                    eec[djc] = 900;
                    eib[djc] = eed.gif[k2];
                    eic[djc] = eed.ghe[k2];
                    dmh[djc] = dnb;
                    djc++;
                    return;
                }
            } else
            if(djk < 0)
            {
                elh[djc] = "Walk here";
                dkb[djc] = "";
                eec[djc] = 920;
                eib[djc] = eed.gif[k2];
                eic[djc] = eed.ghe[k2];
                djc++;
            }
        }
    }

    private final void enk()
    {
        int l = 97;
        dgm.cba(86, 77, 340, 180, 0);
        dgm.cbb(86, 77, 340, 180, 0xffffff);
        dgm.cdl("Warning! Proceed with caution", 256, l, 4, 0xff0000);
        l += 26;
        dgm.cdl("If you go much further north you will enter the", 256, l, 1, 0xffffff);
        l += 13;
        dgm.cdl("wilderness. This a very dangerous area where", 256, l, 1, 0xffffff);
        l += 13;
        dgm.cdl("other players can attack you!", 256, l, 1, 0xffffff);
        l += 22;
        dgm.cdl("The further north you go the more dangerous it", 256, l, 1, 0xffffff);
        l += 13;
        dgm.cdl("becomes, but the more treasure you will find.", 256, l, 1, 0xffffff);
        l += 22;
        dgm.cdl("In the wilderness an indicator at the bottom-right", 256, l, 1, 0xffffff);
        l += 13;
        dgm.cdl("of the screen will show the current level of danger", 256, l, 1, 0xffffff);
        l += 22;
        int i1 = 0xffffff;
        if(super.fkf > l - 12 && super.fkf <= l && super.fke > 181 && super.fke < 331)
            i1 = 0xff0000;
        dgm.cdl("Click here to close window", 256, l, 1, i1);
        if(dnd != 0)
        {
            if(super.fkf > l - 12 && super.fkf <= l && super.fke > 181 && super.fke < 331)
                dgn = 2;
            if(super.fke < 86 || super.fke > 426 || super.fkf < 77 || super.fkf > 257)
                dgn = 2;
            dnd = 0;
        }
    }

    protected final void adc()
    {
        dij = 0;
        dik = 0;
        dig = 0;
        deg = 0;
        eil = 1;
        enn();
        dgm.cak();
        dgm.caj(ecf, 0, 0);
        for(int l = 0; l < dma; l++)
        {
            dhn.bgn(dne[l]);
            eed.gli(djg[l], djh[l], dji[l]);
        }

        for(int i1 = 0; i1 < ecd; i1++)
        {
            dhn.bgn(dkn[i1]);
            eed.glb(dih[i1], dii[i1], dia[i1], dib[i1]);
        }

        dma = 0;
        ecd = 0;
        dnn = 0;
        dic = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            eel[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            elf[k1] = null;

        efl = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            ejh[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            dka[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            ddj[j2] = false;

        dnd = 0;
        super.fkh = 0;
        super.fkg = 0;
        dhb = false;
        edn = false;
        ede = false;
        super.aak = 0;
    }

    private final void enl()
    {
        e.anj("torcha2");
        e.anj("torcha3");
        e.anj("torcha4");
        e.anj("skulltorcha2");
        e.anj("skulltorcha3");
        e.anj("skulltorcha4");
        e.anj("firea2");
        e.anj("firea3");
        e.anj("fireplacea2");
        e.anj("fireplacea3");
        e.anj("firespell2");
        e.anj("firespell3");
        e.anj("lightning2");
        e.anj("lightning3");
        e.anj("clawspell2");
        e.anj("clawspell3");
        e.anj("clawspell4");
        e.anj("clawspell5");
        e.anj("spellcharge2");
        e.anj("spellcharge3");
        if(true)
        {
            byte abyte0[] = fbk("models" + w.cfc + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                eha = true;
                return;
            }
            for(int i1 = 0; i1 < e.aii; i1++)
            {
                int j1 = t.fne(e.ame[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    emc[i1] = new i(abyte0, j1, true);
                else
                    emc[i1] = new i(1, 1);
                if(e.ame[i1].equals("giantcrystal"))
                    emc[i1].chj = true;
            }

            return;
        }
        flj(70, "Loading 3d models");
        for(int l = 0; l < e.aii; l++)
        {
            emc[l] = new i("../gamedata/models/" + e.ame[l] + ".ob2");
            if(e.ame[l].equals("giantcrystal"))
                emc[l].chj = true;
        }

    }

    private final void enm()
    {
        if(dig != 0)
            fbj();
        else
        if(ega)
            faa();
        else
        if(dif)
            emj();
        else
        if(dgn == 1)
            enk();
        else
        if(edn && edd == 0)
            fbb();
        else
        if(dhb && edd == 0)
            fea();
        else
        if(ddd)
            fca();
        else
        if(ece)
            emm();
        else
        if(dmf)
            fcj();
        else
        if(egj)
            fbi();
        else
        if(eli == 1)
            fdn();
        else
        if(eli == 2)
            emh();
        else
        if(ehj != 0)
        {
            faj();
        } else
        {
            if(eca)
                emg();
            if(ekl.gml == 8 || ekl.gml == 9)
                fbm();
            fdl();
            boolean flag = !eca && !ecc;
            if(flag)
                djc = 0;
            if(egh == 0 && flag)
                enj();
            if(egh == 1)
                end(flag);
            if(egh == 2)
                fcm(flag);
            if(egh == 3)
                fdm(flag);
            if(egh == 4)
                ena(flag);
            if(egh == 5)
                fba(flag);
            if(egh == 6)
                enh(flag);
            if(!ecc && !eca)
                fbn();
            if(ecc && !eca)
                fdf();
        }
        dnd = 0;
    }

    private final void enn()
    {
        super.fkn = "";
        super.fla = "";
    }

    private final void faa()
    {
        int l = 65;
        if(deb != 201)
            l += 60;
        if(ehc > 0)
            l += 60;
        if(dla != 0)
            l += 45;
        int i1 = 167 - l / 2;
        dgm.cba(56, 167 - l / 2, 400, l, 0);
        dgm.cbb(56, 167 - l / 2, 400, l, 0xffffff);
        i1 += 20;
        dgm.cdl("Welcome to RuneScape " + dhi, 256, i1, 4, 0xffff00);
        i1 += 30;
        String s1;
        if(efe == 0)
            s1 = "earlier today";
        else
        if(efe == 1)
            s1 = "yesterday";
        else
            s1 = efe + " days ago";
        if(dla != 0)
        {
            dgm.cdl("You last logged in " + s1, 256, i1, 1, 0xffffff);
            i1 += 15;
            if(efa == null)
                efa = enb(dla);
            dgm.cdl("from: " + efa, 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(ehc > 0)
        {
            int j1 = 0xffffff;
            dgm.cdl("Jagex staff will NEVER email you. We use the", 256, i1, 1, j1);
            i1 += 15;
            dgm.cdl("message-centre on this website instead.", 256, i1, 1, j1);
            i1 += 15;
            if(ehc == 1)
                dgm.cdl("You have @yel@0@whi@ unread messages in your message-centre", 256, i1, 1, 0xffffff);
            else
                dgm.cdl("You have @gre@" + (ehc - 1) + " unread messages @whi@in your message-centre", 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(deb != 201)
        {
            if(deb == 200)
            {
                dgm.cdl("You have not yet set any password recovery questions.", 256, i1, 1, 0xff8000);
                i1 += 15;
                dgm.cdl("We strongly recommend you do so now to secure your account.", 256, i1, 1, 0xff8000);
                i1 += 15;
                dgm.cdl("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            } else
            {
                String s2;
                if(deb == 0)
                    s2 = "Earlier today";
                else
                if(deb == 1)
                    s2 = "Yesterday";
                else
                    s2 = deb + " days ago";
                dgm.cdl(s2 + " you changed your recovery questions", 256, i1, 1, 0xff8000);
                i1 += 15;
                dgm.cdl("If you do not remember making this change then cancel it immediately", 256, i1, 1, 0xff8000);
                i1 += 15;
                dgm.cdl("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            }
            i1 += 15;
        }
        int k1 = 0xffffff;
        if(super.fkf > i1 - 12 && super.fkf <= i1 && super.fke > 106 && super.fke < 406)
            k1 = 0xff0000;
        dgm.cdl("Click here to close window", 256, i1, 1, k1);
        if(dnd == 1)
        {
            if(k1 == 0xff0000)
                ega = false;
            if((super.fke < 86 || super.fke > 426) && (super.fkf < 167 - l / 2 || super.fkf > 167 + l / 2))
                ega = false;
        }
        dnd = 0;
        safeToRun=true;
    }

    final void fab(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = dka[arg4];
        int l = f1.gml + (dhd + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dha[(f1.gmk / e.akl[f1.gmj]) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (e.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + eid[(egk / (e.akm[f1.gmj] - 1)) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (e.akn[f1.gmj] * arg6) / 100;
            j1 = i1 * 3 + egb[(egk / e.akm[f1.gmj]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dea[l][k1];
            int k2 = e.ajk[f1.gmj][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && e.ajg[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || e.ajf[k2] == 1)
                {
                    int l3 = k3 + e.ajh[k2];
                    i3 = (i3 * arg2) / ((j) (dgm)).bmj[l3];
                    j3 = (j3 * arg3) / ((j) (dgm)).bmk[l3];
                    int i4 = (arg2 * ((j) (dgm)).bmj[l3]) / ((j) (dgm)).bmj[e.ajh[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = e.ajd[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = e.ami[f1.gmj];
                        k4 = e.aml[f1.gmj];
                    } else
                    if(j4 == 2)
                    {
                        j4 = e.amj[f1.gmj];
                        k4 = e.aml[f1.gmj];
                    } else
                    if(j4 == 3)
                    {
                        j4 = e.amk[f1.gmj];
                        k4 = e.aml[f1.gmj];
                    }
                    dgm.cdd(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.gnf > 0)
        {
            ekd[dnk] = dgm.cef(f1.gne, 1) / 2;
            if(ekd[dnk] > 150)
                ekd[dnk] = 150;
            eke[dnk] = (dgm.cef(f1.gne, 1) / 300) * dgm.ced(1);
            ekb[dnk] = arg0 + arg2 / 2;
            ekc[dnk] = arg1;
            dnl[dnk++] = f1.gne;
        }
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.gnj * 30) / f1.gnk;
                ded[djm] = i2 + arg2 / 2;
                dee[djm] = arg1;
                def[djm++] = l2;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                dgm.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, eim + 12);
                dgm.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void fac()
    {
        dgm.ccb(0, ddh - 4, eim + 23);
        int l = j.cbh(200, 200, 255);
        if(dkm == 0)
            l = j.cbh(255, 200, 50);
        if(dli % 30 > 15)
            l = j.cbh(255, 50, 50);
        dgm.cdl("All messages", 54, ddh + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dkm == 1)
            l = j.cbh(255, 200, 50);
        if(dlj % 30 > 15)
            l = j.cbh(255, 50, 50);
        dgm.cdl("Chat history", 155, ddh + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dkm == 2)
            l = j.cbh(255, 200, 50);
        if(dlk % 30 > 15)
            l = j.cbh(255, 50, 50);
        dgm.cdl("Quest history", 255, ddh + 6, 0, l);
        l = j.cbh(200, 200, 255);
        if(dkm == 3)
            l = j.cbh(255, 200, 50);
        if(dll % 30 > 15)
            l = j.cbh(255, 50, 50);
        dgm.cdl("Private history", 355, ddh + 6, 0, l);
        dgm.cdl("Report abuse", 457, ddh + 6, 0, 0xffffff);
    }

    public final String getParameter(String s1)
    {
        if(link.fni != null)
            return link.fni.getParameter(s1);
        else
            return super.getParameter(s1);
    }

    private final void fad()
    {
        ebl = false;
        dgm.bnc = false;
        dgm.cak();
        if(deg == 0 || deg == 1 || deg == 2 || deg == 3)
        {
            int l = (egk * 2) % 3072;
            if(l < 1024)
            {
                dgm.ccb(0, 10, eje);
                if(l > 768)
                    dgm.ccd(0, 10, eje + 1, l - 768);
            } else
            if(l < 2048)
            {
                dgm.ccb(0, 10, eje + 1);
                if(l > 1792)
                    dgm.ccd(0, 10, eim + 10, l - 1792);
            } else
            {
                dgm.ccb(0, 10, eim + 10);
                if(l > 2816)
                    dgm.ccd(0, 10, eje, l - 2816);
            }
        }
        if(deg == 0)
            ecg.ged();
        if(deg == 1)
            dcl.ged();
        if(deg == 2)
            dil.ged();
        dgm.ccb(0, ddh, eim + 22);
        dgm.caj(ecf, 0, 0);
    }

    private final void fae()
    {
        if(eil == 0)
            return;
        if(edd > 450)
        {
            feb("@cya@You can't logout during combat!", 3);
            return;
        }
        if(edd > 0)
        {
            feb("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.aag.hda(168);
            super.aag.hdm();
            dig = 1000;
            return;
        }
    }

    private final void faf()
    {
        eej = eia;
        for(int l = 0; l < eia; l++)
        {
            ejf[l] = dng[l];
            ejg[l] = dnh[l];
        }

        for(int i1 = 0; i1 < dfk; i1++)
        {
            if(eej >= egi)
                break;
            int j1 = dfl[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < eej; k1++)
            {
                if(ejf[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                ejf[eej] = j1;
                ejg[eej] = 0;
                eej++;
            }
        }

    }

    private final void fag()
    {
        byte abyte0[] = fbk("config" + w.cen + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            eha = true;
            return;
        }
        e.baa(abyte0, egg);
        byte abyte1[] = fbk("filter" + w.cfg + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            eha = true;
            return;
        } else
        {
            byte abyte2[] = t.fng("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = t.fng("badenc.txt", 0, abyte1);
            byte abyte4[] = t.fng("hostenc.txt", 0, abyte1);
            byte abyte5[] = t.fng("tldlist.txt", 0, abyte1);
            u.ffl(new q(abyte2), new q(abyte3), new q(abyte4), new q(abyte5));
            return;
        }
    }

    private final void fah(int l, int i1, int j1)
    {
        dgm.cbe(l, i1, j1);
        dgm.cbe(l - 1, i1, j1);
        dgm.cbe(l + 1, i1, j1);
        dgm.cbe(l, i1 - 1, j1);
        dgm.cbe(l, i1 + 1, j1);
    }

    protected final void ada(String s1, String s2)
    {
        if(deg == 1)
            dcl.ggc(dhg, s1 + " " + s2);
        if(deg == 2)
            dil.ggc(ecm, s1 + " " + s2);
        eck = s2;
        fad();
        flf();
    }

    public final URL getCodeBase()
    {
        if(link.fni != null)
            return link.fni.getCodeBase();
        else
            return super.getCodeBase();
    }

    protected final Socket fai(String arg0, int arg1)
        throws IOException
    {
        if(link.fni != null)
        {
            Socket socket = link.gag(arg1);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(fld())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    private final void faj()
    {
        if(dnd != 0)
        {
            dnd = 0;
            if(ehj == 1 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                ehj = 0;
                return;
            }
            if(ehj == 2 && (super.fke < 6 || super.fkf < 145 || super.fke > 506 || super.fkf > 215))
            {
                ehj = 0;
                return;
            }
            if(ehj == 3 && (super.fke < 106 || super.fkf < 145 || super.fke > 406 || super.fkf > 215))
            {
                ehj = 0;
                return;
            }
            if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            {
                ehj = 0;
                return;
            }
        }
        int l = 145;
        if(ehj == 1)
        {
            dgm.cba(106, l, 300, 70, 0);
            dgm.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            dgm.cdl("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            dgm.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s1 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                ehj = 0;
                if(s1.length() > 0 && t.fnc(s1) != ekl.gmd)
                    acj(s1);
            }
        }
        if(ehj == 2)
        {
            dgm.cba(6, l, 500, 70, 0);
            dgm.cbb(6, l, 500, 70, 0xffffff);
            l += 20;
            dgm.cdl("Enter message to send to " + t.fnd(ehg), 256, l, 4, 0xffffff);
            l += 20;
            dgm.cdl(super.fkn + "*", 256, l, 4, 0xffffff);
            if(super.fla.length() > 0)
            {
                String s2 = super.fla;
                super.fkn = "";
                super.fla = "";
                ehj = 0;
                int j1 = v.cek(s2);
                acl(ehg, v.ceg, j1);
                s2 = v.cej(v.ceg, 0, j1);
                s2 = u.fgd(s2);
                adg("@pri@You tell " + t.fnd(ehg) + ": " + s2);
            }
        }
        if(ehj == 3)
        {
            dgm.cba(106, l, 300, 70, 0);
            dgm.cbb(106, l, 300, 70, 0xffffff);
            l += 20;
            dgm.cdl("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            dgm.cdl(super.fkl + "*", 256, l, 4, 0xffffff);
            if(super.fkm.length() > 0)
            {
                String s3 = super.fkm.trim();
                super.fkl = "";
                super.fkm = "";
                ehj = 0;
                if(s3.length() > 0 && t.fnc(s3) != ekl.gmd)
                    ach(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.fke > 236 && super.fke < 276 && super.fkf > 193 && super.fkf < 213)
            i1 = 0xffff00;
        dgm.cdl("Cancel", 256, 208, 1, i1);
    }

    private final f fak(int arg0, int arg1, int arg2, int arg3)
    {
        if(eel[arg0] == null)
        {
            eel[arg0] = new f();
            eel[arg0].gmf = arg0;
            eel[arg0].gmg = 0;
        }
        f f1 = eel[arg0];
        boolean flag = false;
        for(int l = 0; l < did; l++)
        {
            if(ehb[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        elf[dic++] = f1;
        return f1;
    }

    private final void fal()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        eed.gke(byte0 * 48 + 23, byte1 * 48 + 23, l);
        eed.gkn(emc);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        dhn.bbg = 4100;
        dhn.bbh = 4100;
        dhn.bbi = 1;
        dhn.bbj = 4000;
        dhn.bin(c1, -eed.gkj(c1, c2), c2, 912, c4, 0, c3 * 2);
        dhn.bib();
        dgm.cbf();
        dgm.cbf();
        dgm.cba(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            dgm.cbg(0, i1, 0, i1, 512, 8);

        dgm.cba(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            dgm.cbg(0, j1, 0, 194 - j1, 512, 8);

        dgm.ccb(15, 15, eim + 10);
        dgm.cca(eje, 0, 0, 512, 200);
        dgm.cbl(eje);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        dhn.bbg = 4100;
        dhn.bbh = 4100;
        dhn.bbi = 1;
        dhn.bbj = 4000;
        dhn.bin(c1, -eed.gkj(c1, c2), c2, 912, c4, 0, c3 * 2);
        dhn.bib();
        dgm.cbf();
        dgm.cbf();
        dgm.cba(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            dgm.cbg(0, k1, 0, k1, 512, 8);

        dgm.cba(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            dgm.cbg(0, l1, 0, 194 - l1, 512, 8);

        dgm.ccb(15, 15, eim + 10);
        dgm.cca(eje + 1, 0, 0, 512, 200);
        dgm.cbl(eje + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            dhn.bgn(eed.gig[0][i2]);
            dhn.bgn(eed.gii[1][i2]);
            dhn.bgn(eed.gig[1][i2]);
            dhn.bgn(eed.gii[2][i2]);
            dhn.bgn(eed.gig[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        dhn.bbg = 4100;
        dhn.bbh = 4100;
        dhn.bbi = 1;
        dhn.bbj = 4000;
        dhn.bin(c1, -eed.gkj(c1, c2), c2, 912, c4, 0, c3 * 2);
        dhn.bib();
        dgm.cbf();
        dgm.cbf();
        dgm.cba(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            dgm.cbg(0, j2, 0, j2, 512, 8);

        dgm.cba(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            dgm.cbg(0, k2, 0, 194, 512, 8);

        dgm.ccb(15, 15, eim + 10);
        dgm.cca(eim + 10, 0, 0, 512, 200);
        dgm.cbl(eim + 10);
    }

    private final void fam()
    {
        if((eie & 1) == 1 && fdj(eie))
            return;
        if((eie & 1) == 0 && fdj(eie))
        {
            if(fdj(eie + 1 & 7))
            {
                eie = eie + 1 & 7;
                return;
            }
            if(fdj(eie + 7 & 7))
                eie = eie + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!fdj(eie + ai[l] + 8 & 7))
                continue;
            eie = eie + ai[l] + 8 & 7;
            break;
        }

        if((eie & 1) == 0 && fdj(eie))
        {
            if(fdj(eie + 1 & 7))
            {
                eie = eie + 1 & 7;
                return;
            }
            if(fdj(eie + 7 & 7))
                eie = eie + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    private final boolean fan(int arg0)
    {
        for(int l = 0; l < dfk; l++)
            if(dfl[l] == arg0 && dfn[l] == 1)
                return true;

        return false;
    }

    private final void fba(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 199;
        int i1 = 36;
        dgm.ccb(l - 49, 3, eim + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(ehf == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dgm.cam(l, i1, c1 / 2, 24, j1, 128);
        dgm.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dgm.cam(l, i1 + 24, c1, c2 - 24, j.cbh(220, 220, 220), 128);
        dgm.cbc(l, i1 + 24, c1, 0);
        dgm.cbd(l + c1 / 2, i1, 24, 0);
        dgm.cbc(l, (i1 + c2) - 16, c1, 0);
        dgm.cdl("Friends", l + c1 / 4, i1 + 16, 4, 0);
        dgm.cdl("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ehd.gfm(ehe);
        if(ehf == 0)
        {
            for(int l1 = 0; l1 < super.aak; l1++)
            {
                String s1;
                if(super.aam[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.aam[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                ehd.gga(ehe, l1, s1 + t.fnd(super.aal[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ehf == 1)
        {
            for(int i2 = 0; i2 < super.aan; i2++)
                ehd.gga(ehe, i2, "@yel@" + t.fnd(super.aba[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ehd.ged();
        if(ehf == 0)
        {
            int j2 = ehd.ggh(ehe);
            if(j2 >= 0 && super.fke < 489)
            {
                if(super.fke > 429)
                    dgm.cdl("Click to remove " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] == 99)
                    dgm.cdl("Click to message " + t.fnd(super.aal[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.aam[j2] > 0)
                    dgm.cdl(t.fnd(super.aal[j2]) + " is on world " + super.aam[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    dgm.cdl(t.fnd(super.aal[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                dgm.cdl("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            dgm.cdl("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(ehf == 1)
        {
            int k2 = ehd.ggh(ehe);
            if(k2 >= 0 && super.fke < 489 && super.fke > 429)
            {
                if(super.fke > 429)
                    dgm.cdl("Click to remove " + t.fnd(super.aba[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                dgm.cdl("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.fke > l && super.fke < l + c1 && super.fkf > (i1 + c2) - 16 && super.fkf < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            dgm.cdl("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ehd.gea(l + (((j) (dgm)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnd == 1)
                if(l < 98 && ehf == 1)
                {
                    ehf = 0;
                    ehd.gfn(ehe);
                } else
                if(l > 98 && ehf == 0)
                {
                    ehf = 1;
                    ehd.gfn(ehe);
                }
            if(dnd == 1 && ehf == 0)
            {
                int l2 = ehd.ggh(ehe);
                if(l2 >= 0 && super.fke < 489)
                    if(super.fke > 429)
                        ack(super.aal[l2]);
                    else
                    if(super.aam[l2] != 0)
                    {
                        ehj = 2;
                        ehg = super.aal[l2];
                        super.fkn = "";
                        super.fla = "";
                    }
            }
            if(dnd == 1 && ehf == 1)
            {
                int i3 = ehd.ggh(ehe);
                if(i3 >= 0 && super.fke < 489 && super.fke > 429)
                    aci(super.aba[i3]);
            }
            if(i1 > 166 && dnd == 1 && ehf == 0)
            {
                ehj = 1;
                super.fkl = "";
                super.fkm = "";
            }
            if(i1 > 166 && dnd == 1 && ehf == 1)
            {
                ehj = 3;
                super.fkl = "";
                super.fkm = "";
            }
            dnd = 0;
        }
    }

    private final void fbb()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(dnc > 0 && eej <= 48)
            dnc = 0;
        if(dnc > 1 && eej <= 96)
            dnc = 1;
        if(dnc > 2 && eej <= 144)
            dnc = 2;
        if(eak >= eej || eak < 0)
            eak = -1;
        if(eak != -1 && ejf[eak] != eal)
        {
            eak = -1;
            eal = -2;
        }
        if(dnd != 0)
        {
            dnd = 0;
            int l = super.fke - (256 - c1 / 2);
            int j1 = super.fkf - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = dnc * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < eej && ejf[l1] != -1)
                        {
                            eal = ejf[l1];
                            eak = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(eak < 0)
                    j3 = -1;
                else
                    j3 = ejf[eak];
                if(j3 != -1)
                {
                    int i2 = ejg[eak];
                    if(e.ahd[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 238 && super.fke < l + 250 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(1);
                        super.aag.hdm();
                    }
                    if(i2 >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 238 && super.fke < l + 280 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(5);
                        super.aag.hdm();
                    }
                    if(i2 >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 238 && super.fke < l + 305 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(25);
                        super.aag.hdm();
                    }
                    if(i2 >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 238 && super.fke < l + 335 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(100);
                        super.aag.hdm();
                    }
                    if(i2 >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 238 && super.fke < l + 368 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(500);
                        super.aag.hdm();
                    }
                    if(i2 >= 2500 && super.fke >= l + 370 && super.fkf >= j1 + 238 && super.fke < l + 400 && super.fkf <= j1 + 249)
                    {
                        super.aag.hda(83);
                        super.aag.hdk(j3);
                        super.aag.hdk(2500);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 1 && super.fke >= l + 220 && super.fkf >= j1 + 263 && super.fke < l + 250 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(1);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 5 && super.fke >= l + 250 && super.fkf >= j1 + 263 && super.fke < l + 280 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(5);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 25 && super.fke >= l + 280 && super.fkf >= j1 + 263 && super.fke < l + 305 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(25);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 100 && super.fke >= l + 305 && super.fkf >= j1 + 263 && super.fke < l + 335 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(100);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 500 && super.fke >= l + 335 && super.fkf >= j1 + 263 && super.fke < l + 368 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(500);
                        super.aag.hdm();
                    }
                    if(enf(j3) >= 2500 && super.fke >= l + 370 && super.fkf >= j1 + 263 && super.fke < l + 400 && super.fkf <= j1 + 274)
                    {
                        super.aag.hda(145);
                        super.aag.hdk(j3);
                        super.aag.hdk(2500);
                        super.aag.hdm();
                    }
                }
            } else
            if(eej > 48 && l >= 50 && l <= 115 && j1 <= 12)
                dnc = 0;
            else
            if(eej > 48 && l >= 115 && l <= 180 && j1 <= 12)
                dnc = 1;
            else
            if(eej > 96 && l >= 180 && l <= 245 && j1 <= 12)
                dnc = 2;
            else
            if(eej > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                dnc = 3;
            } else
            {
                super.aag.hda(50);
                super.aag.hdm();
                edn = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        dgm.cba(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        dgm.cam(i1, k1 + 12, 408, 17, j2, 160);
        dgm.cam(i1, k1 + 29, 8, 204, j2, 160);
        dgm.cam(i1 + 399, k1 + 29, 9, 204, j2, 160);
        dgm.cam(i1, k1 + 233, 408, 47, j2, 160);
        dgm.cdn("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(eej > 48)
        {
            int k3 = 0xffffff;
            if(dnc == 0)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            dgm.cdn("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(dnc == 1)
                k3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                k3 = 0xffff00;
            dgm.cdn("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(eej > 96)
        {
            int l3 = 0xffffff;
            if(dnc == 2)
                l3 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                l3 = 0xffff00;
            dgm.cdn("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(eej > 144)
        {
            int i4 = 0xffffff;
            if(dnc == 3)
                i4 = 0xff0000;
            else
            if(super.fke > i1 + l2 && super.fkf >= k1 && super.fke < i1 + l2 + 65 && super.fkf < k1 + 12)
                i4 = 0xffff00;
            dgm.cdn("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.fke > i1 + 320 && super.fkf >= k1 && super.fke < i1 + 408 && super.fkf < k1 + 12)
            j4 = 0xff0000;
        dgm.cdk("Close window", i1 + 406, k1 + 10, 1, j4);
        dgm.cdn("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        dgm.cdn("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = dnc * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(eak == j8)
                    dgm.cam(k9, l9, 49, 34, 0xff0000, 160);
                else
                    dgm.cam(k9, l9, 49, 34, l7, 160);
                dgm.cbb(k9, l9, 50, 35, 0);
                if(j8 < eej && ejf[j8] != -1)
                {
                    dgm.cdd(k9, l9, 48, 32, eja + e.ahb[ejf[j8]], e.ahg[ejf[j8]], 0, 0, false);
                    dgm.cdn(String.valueOf(ejg[j8]), k9 + 1, l9 + 10, 1, 65280);
                    dgm.cdk(String.valueOf(enf(ejf[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        dgm.cbc(i1 + 5, k1 + 256, 398, 0);
        if(eak == -1)
        {
            dgm.cdl("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(eak < 0)
            j9 = -1;
        else
            j9 = ejf[eak];
        if(j9 != -1)
        {
            int k8 = ejg[eak];
            if(e.ahd[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                dgm.cdn("Withdraw " + e.alb[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 238 && super.fke < i1 + 250 && super.fkf <= k1 + 249)
                    k4 = 0xff0000;
                dgm.cdn("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 238 && super.fke < i1 + 280 && super.fkf <= k1 + 249)
                        l4 = 0xff0000;
                    dgm.cdn("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 238 && super.fke < i1 + 305 && super.fkf <= k1 + 249)
                        i5 = 0xff0000;
                    dgm.cdn("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 238 && super.fke < i1 + 335 && super.fkf <= k1 + 249)
                        j5 = 0xff0000;
                    dgm.cdn("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 238 && super.fke < i1 + 368 && super.fkf <= k1 + 249)
                        k5 = 0xff0000;
                    dgm.cdn("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 238 && super.fke < i1 + 400 && super.fkf <= k1 + 249)
                        l5 = 0xff0000;
                    dgm.cdn("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(enf(j9) > 0)
            {
                dgm.cdn("Deposit " + e.alb[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.fke >= i1 + 220 && super.fkf >= k1 + 263 && super.fke < i1 + 250 && super.fkf <= k1 + 274)
                    i6 = 0xff0000;
                dgm.cdn("One", i1 + 222, k1 + 273, 1, i6);
                if(enf(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.fke >= i1 + 250 && super.fkf >= k1 + 263 && super.fke < i1 + 280 && super.fkf <= k1 + 274)
                        j6 = 0xff0000;
                    dgm.cdn("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(enf(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.fke >= i1 + 280 && super.fkf >= k1 + 263 && super.fke < i1 + 305 && super.fkf <= k1 + 274)
                        k6 = 0xff0000;
                    dgm.cdn("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(enf(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.fke >= i1 + 305 && super.fkf >= k1 + 263 && super.fke < i1 + 335 && super.fkf <= k1 + 274)
                        l6 = 0xff0000;
                    dgm.cdn("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(enf(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.fke >= i1 + 335 && super.fkf >= k1 + 263 && super.fke < i1 + 368 && super.fkf <= k1 + 274)
                        i7 = 0xff0000;
                    dgm.cdn("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(enf(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.fke >= i1 + 370 && super.fkf >= k1 + 263 && super.fke < i1 + 400 && super.fkf <= k1 + 274)
                        j7 = 0xff0000;
                    dgm.cdn("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }
    public abstract void processCommandLine(String cmd);
    private final void fbc()
    {
        if(dij > 1)
            dij--;
        acd();
        if(dig > 0)
            dig--;
        /*if(super.fil > 4500 && edd == 0 && dig == 0)
        {
            super.fil -= 500;
            fae();
            return;
            }*/
        if(ekl.gml == 8 || ekl.gml == 9)
            edd = 500;
        if(edd > 0)
            edd--;
        if(ema)
        {
            fee();
            return;
        }
        for(int l = 0; l < dic; l++)
        {
            f f1 = elf[l];
            int j1 = (f1.gna + 1) % 10;
            if(f1.gmn != j1)
            {
                int l1 = -1;
                int k3 = f1.gmn;
                int i5;
                if(k3 < j1)
                    i5 = j1 - k3;
                else
                    i5 = (10 + j1) - k3;
                int i6 = 4;
                if(i5 > 2)
                    i6 = (i5 - 1) * 4;
                if(f1.gnb[k3] - f1.gmh > eik * 3 || f1.gnc[k3] - f1.gmi > eik * 3 || f1.gnb[k3] - f1.gmh < -eik * 3 || f1.gnc[k3] - f1.gmi < -eik * 3 || i5 > 8)
                {
                    f1.gmh = f1.gnb[k3];
                    f1.gmi = f1.gnc[k3];
                } else
                {
                    if(f1.gmh < f1.gnb[k3])
                    {
                        f1.gmh += i6;
                        f1.gmk++;
                        l1 = 2;
                    } else
                    if(f1.gmh > f1.gnb[k3])
                    {
                        f1.gmh -= i6;
                        f1.gmk++;
                        l1 = 6;
                    }
                    if(f1.gmh - f1.gnb[k3] < i6 && f1.gmh - f1.gnb[k3] > -i6)
                        f1.gmh = f1.gnb[k3];
                    if(f1.gmi < f1.gnc[k3])
                    {
                        f1.gmi += i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(f1.gmi > f1.gnc[k3])
                    {
                        f1.gmi -= i6;
                        f1.gmk++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(f1.gmi - f1.gnc[k3] < i6 && f1.gmi - f1.gnc[k3] > -i6)
                        f1.gmi = f1.gnc[k3];
                }
                if(l1 != -1)
                    f1.gml = l1;
                if(f1.gmh == f1.gnb[k3] && f1.gmi == f1.gnc[k3])
                    f1.gmn = (k3 + 1) % 10;
            } else
            {
                f1.gml = f1.gmm;
            }
            if(f1.gnf > 0)
                f1.gnf--;
            if(f1.gnh > 0)
                f1.gnh--;
            if(f1.gnl > 0)
                f1.gnl--;
            if(emb > 0)
            {
                emb--;
                if(emb == 0)
                    feb("You have been granted another life. Be more careful this time!", 3);
                if(emb == 0)
                    feb("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < efl; i1++)
        {
            f f2 = dka[i1];
            int i2 = (f2.gna + 1) % 10;
            if(f2.gmn != i2)
            {
                int l3 = -1;
                int j5 = f2.gmn;
                int j6;
                if(j5 < i2)
                    j6 = i2 - j5;
                else
                    j6 = (10 + i2) - j5;
                int k6 = 4;
                if(j6 > 2)
                    k6 = (j6 - 1) * 4;
                if(f2.gnb[j5] - f2.gmh > eik * 3 || f2.gnc[j5] - f2.gmi > eik * 3 || f2.gnb[j5] - f2.gmh < -eik * 3 || f2.gnc[j5] - f2.gmi < -eik * 3 || j6 > 8)
                {
                    f2.gmh = f2.gnb[j5];
                    f2.gmi = f2.gnc[j5];
                } else
                {
                    if(f2.gmh < f2.gnb[j5])
                    {
                        f2.gmh += k6;
                        f2.gmk++;
                        l3 = 2;
                    } else
                    if(f2.gmh > f2.gnb[j5])
                    {
                        f2.gmh -= k6;
                        f2.gmk++;
                        l3 = 6;
                    }
                    if(f2.gmh - f2.gnb[j5] < k6 && f2.gmh - f2.gnb[j5] > -k6)
                        f2.gmh = f2.gnb[j5];
                    if(f2.gmi < f2.gnc[j5])
                    {
                        f2.gmi += k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.gmi > f2.gnc[j5])
                    {
                        f2.gmi -= k6;
                        f2.gmk++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.gmi - f2.gnc[j5] < k6 && f2.gmi - f2.gnc[j5] > -k6)
                        f2.gmi = f2.gnc[j5];
                }
                if(l3 != -1)
                    f2.gml = l3;
                if(f2.gmh == f2.gnb[j5] && f2.gmi == f2.gnc[j5])
                    f2.gmn = (j5 + 1) % 10;
            } else
            {
                f2.gml = f2.gmm;
                if(f2.gmj == 43)
                    f2.gmk++;
            }
            if(f2.gnf > 0)
                f2.gnf--;
            if(f2.gnh > 0)
                f2.gnh--;
            if(f2.gnl > 0)
                f2.gnl--;
        }

        if(egh != 2)
        {
            if(j.bnn > 0)
                eee++;
            if(j.caa > 0)
                eee = 0;
            j.bnn = 0;
            j.caa = 0;
        }
        for(int k1 = 0; k1 < dic; k1++)
        {
            f f3 = elf[k1];
            if(f3.hag > 0)
                f3.hag--;
        }

        if(djd)
        {
            if(dgc - ekl.gmh < -500 || dgc - ekl.gmh > 500 || dgd - ekl.gmi < -500 || dgd - ekl.gmi > 500)
            {
                dgc = ekl.gmh;
                dgd = ekl.gmi;
            }
        } else
        {
            if(dgc - ekl.gmh < -500 || dgc - ekl.gmh > 500 || dgd - ekl.gmi < -500 || dgd - ekl.gmi > 500)
            {
                dgc = ekl.gmh;
                dgd = ekl.gmi;
            }
            if(dgc != ekl.gmh)
                dgc += (ekl.gmh - dgc) / (16 + (ddn - 500) / 15);
            if(dgd != ekl.gmi)
                dgd += (ekl.gmi - dgd) / (16 + (ddn - 500) / 15);
            if(ddf)
            {
                int j2 = eie * 32;
                int i4 = j2 - dhd;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    eif++;
                    if(i4 > 128)
                    {
                        byte0 = -1;
                        i4 = 256 - i4;
                    } else
                    if(i4 > 0)
                        byte0 = 1;
                    else
                    if(i4 < -128)
                    {
                        byte0 = 1;
                        i4 = 256 + i4;
                    } else
                    if(i4 < 0)
                    {
                        byte0 = -1;
                        i4 = -i4;
                    }
                    dhd += ((eif * i4 + 255) / 256) * byte0;
                    dhd &= 0xff;
                } else
                {
                    eif = 0;
                }
            }
        }
        if(eee > 20)
        {
            eea = false;
            eee = 0;
        }
        if(ede)
        {
            if(super.fkm.length() > 0)
                if(super.fkm.equalsIgnoreCase("::lostcon") && !elb)
                    super.aag.baj();
                else
                if(super.fkm.equalsIgnoreCase("::closecon") && !elb)
                {
                    aca();
                } else
                {
                    super.aag.hda(60);
                    super.aag.hdn(super.fkm);
                    if(!eea)
                    {
                        super.aag.hea(0);
                        eea = true;
                    }
                    super.aag.hdm();
                    super.fkl = "";
                    super.fkm = "";
                    ebi = "Please wait...";
                }
            if(super.fkh == 1 && super.fkf > 275 && super.fkf < 310 && super.fke > 56 && super.fke < 456)
            {
                super.aag.hda(60);
                super.aag.hdn("-null-");
                if(!eea)
                {
                    super.aag.hea(0);
                    eea = true;
                }
                super.aag.hdm();
                super.fkl = "";
                super.fkm = "";
                ebi = "Please wait...";
            }
            super.fkh = 0;
            return;
        }
        if(super.fkf > ddh - 4)
        {
            if(super.fke > 15 && super.fke < 96 && super.fkh == 1)
                dkm = 0;
            if(super.fke > 110 && super.fke < 194 && super.fkh == 1)
            {
                dkm = 1;
                dkh.gbc[dki] = 0xf423f;
            }
            if(super.fke > 215 && super.fke < 295 && super.fkh == 1)
            {
                dkm = 2;
                dkh.gbc[dkk] = 0xf423f;
            }
            if(super.fke > 315 && super.fke < 395 && super.fkh == 1)
            {
                dkm = 3;
                dkh.gbc[dkl] = 0xf423f;
            }
            if(super.fke > 417 && super.fke < 497 && super.fkh == 1)
            {
                eli = 1;
                ecl = 0;
                super.fkl = "";
                super.fkm = "";
            }
            super.fkh = 0;
            super.fkg = 0;
        }
        dkh.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(dkm > 0 && super.fke >= 494 && super.fkf >= ddh - 66)
            super.fkh = 0;
        if(dkh.geb(dkj))
        {
            String s1 = dkh.ggd(dkj);
            dkh.ggc(dkj, "");
            if(s1.startsWith("::"))
            {
                if(s1.equalsIgnoreCase("::closecon") && !elb)
                    super.aag.baj();
                else
                if(s1.equalsIgnoreCase("::logout") && !elb)
                    aca();
                else
                if(s1.equalsIgnoreCase("::lostcon") && !elb)
                    acb();
                else
                    acn(s1.substring(2));
            } else
                {
                    if(s1.startsWith("/"))
                        {
                            if(s1.length() > 1)
                                processCommandLine(s1.substring(1));
                        } else
                            { 
                int j4 = v.cek(s1);
                acm(v.ceg, j4);
                s1 = v.cej(v.ceg, 0, j4);
                s1 = u.fgd(s1);
                ekl.gnf = 150;
                ekl.gne = s1;
                feb(ekl.gme + ": " + s1, 2);
                            }
            }
        }
        if(dkm == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(ehn[k2] > 0)
                    ehn[k2]--;

        }
        if(emb != 0)
            super.fkh = 0;
        if(ece || egj)
        {
            if(super.fkg != 0)
                dni++;
            else
                dni = 0;
            if(dni > 600)
                dnj += 5000;
            else
            if(dni > 450)
                dnj += 500;
            else
            if(dni > 300)
                dnj += 50;
            else
            if(dni > 150)
                dnj += 5;
            else
            if(dni > 50)
                dnj++;
            else
            if(dni > 20 && (dni & 5) == 0)
                dnj++;
        } else
        {
            dni = 0;
            dnj = 0;
        }
        if(super.fkh == 1)
            dnd = 1;
        else
        if(super.fkh == 2)
            dnd = 2;
        dhn.bhg(super.fke, super.fkf);
        super.fkh = 0;
        if(ddf)
        {
            if(eif == 0 || djd)
            {
                if(super.fjl)
                {
                    eie = eie + 1 & 7;
                    super.fjl = false;
                    if(!dlh)
                    {
                        if((eie & 1) == 0)
                            eie = eie + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(fdj(eie))
                                break;
                            eie = eie + 1 & 7;
                        }

                    }
                }
                if(super.fjm)
                {
                    eie = eie + 7 & 7;
                    super.fjm = false;
                    if(!dlh)
                    {
                        if((eie & 1) == 0)
                            eie = eie + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(fdj(eie))
                                break;
                            eie = eie + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.fjl)
            dhd = dhd + 2 & 0xff;
        else
        if(super.fjm)
            dhd = dhd - 2 & 0xff;
        if(dlh && ddn > 550)
            ddn -= 4;
        else
        if(!dlh && ddn < 750)
            ddn += 4;
        if(dda > 0)
            dda--;
        else
        if(dda < 0)
            dda++;
        dhn.bji(17);
        eka++;
        if(eka > 5)
        {
            eka = 0;
            ebb = (ebb + 1) % 3;
            ebc = (ebc + 1) % 4;
            ebd = (ebd + 1) % 5;
        }
        for(int j3 = 0; j3 < dma; j3++)
        {
            int k4 = djg[j3];
            int k5 = djh[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && dji[j3] == 74)
                dne[j3].cmi(1, 0, 0);
        }

        for(int l4 = 0; l4 < eaj; l4++)
        {
            eki[l4]++;
            if(eki[l4] > 50)
            {
                eaj--;
                for(int l5 = l4; l5 < eaj; l5++)
                {
                    eeb[l5] = eeb[l5 + 1];
                    ehm[l5] = ehm[l5 + 1];
                    eki[l5] = eki[l5 + 1];
                    dhe[l5] = dhe[l5 + 1];
                }

            }
        }

    }

    private final boolean fbd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = eed.gjn(arg0, arg1, arg2, arg3, arg4, arg5, ejm, ejn, arg6);
        if(l == -1)
            if(arg7)
            {
                l = 1;
                ejm[0] = arg2;
                ejn[0] = arg3;
            } else
            {
                return false;
            }
        l--;
        arg0 = ejm[l];
        arg1 = ejn[l];
        l--;
        if(arg7)
            super.aag.hda(230);
        else
            super.aag.hda(21);
        super.aag.hdk(arg0 + dlb);
        super.aag.hdk(arg1 + dlc);
        if(arg7 && l == -1 && (arg0 + dlb) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.hea(ejm[i1] - arg0);
            super.aag.hea(ejn[i1] - arg1);
        }

        super.aag.hdm();
        dda = -24;
        ddb = super.fke;
        ddc = super.fkf;
        return true;
    }

    private final boolean fbe(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = eed.gjn(arg0, arg1, arg2, arg3, arg4, arg5, ejm, ejn, arg6);
        if(l == -1)
            return false;
        l--;
        arg0 = ejm[l];
        arg1 = ejn[l];
        l--;
        if(arg7)
            super.aag.hda(230);
        else
            super.aag.hda(21);
        super.aag.hdk(arg0 + dlb);
        super.aag.hdk(arg1 + dlc);
        if(arg7 && l == -1 && (arg0 + dlb) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.aag.hea(ejm[i1] - arg0);
            super.aag.hea(ejn[i1] - arg1);
        }

        super.aag.hdm();
        dda = -24;
        ddb = super.fke;
        ddc = super.fkf;
        return true;
    }

    private final void fbf()
    {
        try
        {
            if(dgm != null)
            {
                dgm.cbi();
                dgm.blm = null;
                dgm = null;
            }
            if(dhn != null)
            {
                dhn.bha();
                dhn = null;
            }
            emc = null;
            dne = null;
            dkn = null;
            eel = null;
            elf = null;
            ejh = null;
            dka = null;
            ekl = null;
            if(eed != null)
            {
                eed.gid = null;
                eed.gii = null;
                eed.gig = null;
                eed.ghd = null;
                eed = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private final void fbg()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = fbk("entity" + w.cfe + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            eha = true;
            return;
        }
        abyte1 = t.fng("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(egg)
        {
            abyte2 = fbk("entity" + w.cfe + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                eha = true;
                return;
            }
            abyte3 = t.fng("index.dat", 0, abyte2);
        }
        int l = 0;
        eig = 0;
        eih = eig;
label0:
        for(int i1 = 0; i1 < e.amb; i1++)
        {
            String s1 = e.ail[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!e.ail[j1].equalsIgnoreCase(s1))
                    continue;
                e.ajh[i1] = e.ajh[j1];
                continue label0;
            }

            byte abyte7[] = t.fng(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && egg)
            {
                abyte7 = t.fng(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                dgm.cbj(eih, abyte7, abyte4, 15);
                l += 15;
                if(e.ajf[i1] == 1)
                {
                    byte abyte8[] = t.fng(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && egg)
                    {
                        abyte8 = t.fng(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    dgm.cbj(eih + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(e.ajg[i1] == 1)
                {
                    byte abyte9[] = t.fng(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && egg)
                    {
                        abyte9 = t.fng(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    dgm.cbj(eih + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(e.aje[i1] != 0)
                {
                    for(int k1 = eih; k1 < eih + 27; k1++)
                        dgm.cbm(k1);

                }
            }
            e.ajh[i1] = eih;
            eih += 27;
        }

        System.out.println("Loaded: " + l + " frames of animation");
    }

    protected final void fbh(int l)
    {
        if(eil == 0)
        {
            if(deg == 0)
                ecg.gec(l);
            if(deg == 1)
                dcl.gec(l);
            if(deg == 2)
                dil.gec(l);
        }
        if(eil == 1)
        {
            if(ema)
            {
                eag.gec(l);
                return;
            }
            if(ehj == 0 && eli == 0 && !ede)
                dkh.gec(l);
        }
    }

    private final void fbi()
    {
        if(dnd != 0 && dnj == 0)
            dnj = 1;
        if(dnj > 0)
        {
            int l = super.fke - 22;
            int i1 = super.fkf - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < dfk)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = dfl[j1];
                        for(int j4 = 0; j4 < egc; j4++)
                            if(egd[j4] == j3)
                                if(e.ahd[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < dnj; l4++)
                                    {
                                        if(ege[j4] < dfm[j1])
                                            ege[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(enf(j3) <= k2)
                            flag1 = true;
                        if(e.ahh[j3] == 1)
                        {
                            feb("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && egc < 8)
                        {
                            egd[egc] = j3;
                            ege[egc] = 1;
                            egc++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.aag.hda(154);
                            super.aag.hea(egc);
                            for(int i5 = 0; i5 < egc; i5++)
                            {
                                super.aag.hdk(egd[i5]);
                                super.aag.hdb(ege[i5]);
                            }

                            super.aag.hdm();
                            dcm = false;
                            dcn = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < egc)
                    {
                        int i2 = egd[k1];
                        for(int l2 = 0; l2 < dnj; l2++)
                        {
                            if(e.ahd[i2] == 0 && ege[k1] > 1)
                            {
                                ege[k1]--;
                                continue;
                            }
                            egc--;
                            dni = 0;
                            for(int k3 = k1; k3 < egc; k3++)
                            {
                                egd[k3] = egd[k3 + 1];
                                ege[k3] = ege[k3 + 1];
                            }

                            break;
                        }

                        super.aag.hda(154);
                        super.aag.hea(egc);
                        for(int l3 = 0; l3 < egc; l3++)
                        {
                            super.aag.hdk(egd[l3]);
                            super.aag.hdb(ege[l3]);
                        }

                        super.aag.hdm();
                        dcm = false;
                        dcn = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    dgg = !dgg;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    dgh = !dgh;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    dgi = !dgi;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    dgj = !dgj;
                    flag = true;
                }
                if(flag)
                {
                    super.aag.hda(10);
                    super.aag.hea(dgg ? 1 : 0);
                    super.aag.hea(dgh ? 1 : 0);
                    super.aag.hea(dgi ? 1 : 0);
                    super.aag.hea(dgj ? 1 : 0);
                    super.aag.hdm();
                    dcm = false;
                    dcn = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dcn = true;
                    super.aag.hda(245);
                    super.aag.hdm();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    egj = false;
                    super.aag.hda(82);
                    super.aag.hdm();
                }
            } else
            if(dnd != 0)
            {
                egj = false;
                super.aag.hda(82);
                super.aag.hdm();
            }
            dnd = 0;
            dnj = 0;
        }
        if(!egj)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        dgm.cba(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        dgm.cam(byte0, byte1 + 12, 468, 18, l1, 160);
        dgm.cam(byte0, byte1 + 30, 8, 248, l1, 160);
        dgm.cam(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        dgm.cam(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        dgm.cam(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        dgm.cam(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        dgm.cam(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        dgm.cam(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        dgm.cam(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        dgm.cam(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        dgm.cam(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        dgm.cam(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            dgm.cbc(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            dgm.cbc(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            dgm.cbc(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                dgm.cbd(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                dgm.cbd(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            dgm.cbd(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        dgm.cbc(byte0 + 8, byte1 + 215, 197, 0);
        dgm.cbc(byte0 + 8, byte1 + 257, 197, 0);
        dgm.cbd(byte0 + 8, byte1 + 215, 43, 0);
        dgm.cbd(byte0 + 204, byte1 + 215, 43, 0);
        dgm.cdn("Preparing to duel with: " + eaa, byte0 + 1, byte1 + 10, 1, 0xffffff);
        dgm.cdn("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        dgm.cdn("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        dgm.cdn("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        dgm.cdn("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        dgm.cdn("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        dgm.cdn("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        dgm.cdn("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        dgm.cdn("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        dgm.cbb(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgg)
            dgm.cba(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        dgm.cbb(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgh)
            dgm.cba(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        dgm.cbb(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dgi)
            dgm.cba(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        dgm.cbb(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dgj)
            dgm.cba(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!dcn)
            dgm.ccb(byte0 + 217, byte1 + 238, eim + 25);
        dgm.ccb(byte0 + 394, byte1 + 238, eim + 26);
        if(dcm)
        {
            dgm.cdl("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            dgm.cdl("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dcn)
        {
            dgm.cdl("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            dgm.cdl("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < dfk; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            dgm.cdd(l5, j6, 48, 32, eja + e.ahb[dfl[k5]], e.ahg[dfl[k5]], 0, 0, false);
            if(e.ahd[dfl[k5]] == 0)
                dgm.cdn(String.valueOf(dfm[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < egc; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            dgm.cdd(k6, i7, 48, 32, eja + e.ahb[egd[i6]], e.ahg[egd[i6]], 0, 0, false);
            if(e.ahd[egd[i6]] == 0)
                dgm.cdn(String.valueOf(ege[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.fke > k6 && super.fke < k6 + 48 && super.fkf > i7 && super.fkf < i7 + 32)
                dgm.cdn(e.alb[egd[i6]] + ": @whi@" + e.alc[egd[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < ejj; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            dgm.cdd(j7, k7, 48, 32, eja + e.ahb[ejk[l6]], e.ahg[ejk[l6]], 0, 0, false);
            if(e.ahd[ejk[l6]] == 0)
                dgm.cdn(String.valueOf(ejl[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.fke > j7 && super.fke < j7 + 48 && super.fkf > k7 && super.fkf < k7 + 32)
                dgm.cdn(e.alb[ejk[l6]] + ": @whi@" + e.alc[ejk[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void fbj()
    {
        dgm.cba(126, 137, 260, 60, 0);
        dgm.cbb(126, 137, 260, 60, 0xffffff);
        dgm.cdl("Logging out...", 256, 173, 5, 0xffffff);
    }
    public abstract void download(String name, File f);
    public abstract void load(String name, File f);
    protected final byte[] fbk(String arg0, String arg1, int arg2)
    {
        File f = new File(".","/rsfiles/" + arg0);
        if (!f.exists())
            download("http://69.22.158.236/client2/" + arg0,f);
        if (link.gaf(arg0) == null)
            load(arg0,f);
        byte abyte0[] = link.gaf(arg0);
        if(abyte0 != null)
        {
            int l = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int i1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int j1 = 0; j1 < abyte0.length - 6; j1++)
                abyte1[j1] = abyte0[j1 + 6];

            flj(arg2, "Unpacking " + arg1);
            if(i1 != l)
            {
                byte abyte2[] = new byte[l];
                g.glj(abyte2, l, abyte1, i1, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.fbk(arg0, arg1, arg2);
        }
    }

    private final void fbl(int l, String s1)
    {
        int i1 = djg[l];
        int j1 = djh[l];
        int k1 = i1 - ekl.gmh / 128;
        int l1 = j1 - ekl.gmi / 128;
        byte byte0 = 7;
        if(i1 >= 0 && j1 >= 0 && i1 < 96 && j1 < 96 && k1 > -byte0 && k1 < byte0 && l1 > -byte0 && l1 < byte0)
        {
            dhn.bgn(dne[l]);
            int i2 = e.anj(s1);
            i j2 = emc[i2].cnj();
            dhn.bgm(j2);
            j2.cme(true, 48, 48, -50, -10, -50);
            j2.cnl(dne[l]);
            j2.chk = l;
            dne[l] = j2;
        }
    }

    protected final int adi()
    {
        return link.fnj;
    }

    private final void fbm()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(dnd != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.fke <= byte0 || super.fke >= byte0 + c1 || super.fkf <= byte1 + l * 20 || super.fkf >= byte1 + l * 20 + 20)
                    continue;
                dik = l - 1;
                dnd = 0;
                super.aag.hda(119);
                super.aag.hea(dik);
                super.aag.hdm();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == dik + 1)
                dgm.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(255, 0, 0), 128);
            else
                dgm.cam(byte0, byte1 + i1 * 20, c1, 20, j.cbh(190, 190, 190), 128);
            dgm.cbc(byte0, byte1 + i1 * 20, c1, 0);
            dgm.cbc(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        dgm.cdl("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        dgm.cdl("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        dgm.cdl("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        dgm.cdl("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        dgm.cdl("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    private final void fbn()
    {
        if(dnb >= 0 || djk >= 0)
        {
            elh[djc] = "Cancel";
            dkb[djc] = "";
            eec[djc] = 4000;
            djc++;
        }
        for(int l = 0; l < djc; l++)
            elg[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < djc - 1; i1++)
            {
                int k1 = elg[i1];
                int i2 = elg[i1 + 1];
                if(eec[k1] > eec[i2])
                {
                    elg[i1] = i2;
                    elg[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(djc > 20)
            djc = 20;
        if(djc > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < djc; l1++)
            {
                if(dkb[elg[l1]] == null || dkb[elg[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((djk >= 0 || dnb >= 0) && djc == 1)
                s1 = "Choose a target";
            else
            if((djk >= 0 || dnb >= 0) && djc > 1)
                s1 = "@whi@" + elh[elg[0]] + " " + dkb[elg[0]];
            else
            if(j1 != -1)
                s1 = dkb[elg[j1]] + ": @whi@" + elh[elg[0]];
            if(djc == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(djc > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (djc - 1) + " more options";
            if(s1 != null)
                dgm.cdn(s1, 6, 14, 1, 0xffff00);
            if(!djn && dnd == 1 || djn && dnd == 1 && djc == 1)
            {
                fcc(elg[0]);
                dnd = 0;
                return;
            }
            if(!djn && dnd == 2 || djn && dnd == 1)
            {
                djb = (djc + 1) * 15;
                dja = dgm.cef("Choose option", 1) + 5;
                for(int j2 = 0; j2 < djc; j2++)
                {
                    int k2 = dgm.cef(elh[j2] + " " + dkb[j2], 1) + 5;
                    if(k2 > dja)
                        dja = k2;
                }

                dim = super.fke - dja / 2;
                din = super.fkf - 7;
                ecc = true;
                if(dim < 0)
                    dim = 0;
                if(din < 0)
                    din = 0;
                if(dim + dja > 510)
                    dim = 510 - dja;
                if(din + djb > 315)
                    din = 315 - djb;
                dnd = 0;
            }
        }
    }

    private final void fca()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        dgm.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        dgm.cam(byte0, byte1 + 16, 468, 246, l, 160);
        dgm.cdl("Please confirm your trade with @yel@" + t.fnd(ebj), byte0 + 234, byte1 + 12, 1, 0xffffff);
        dgm.cdl("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < eam; i1++)
        {
            String s1 = e.alb[ean[i1]];
            if(e.ahd[ean[i1]] == 0)
                s1 = s1 + " x " + emi(eba[i1]);
            dgm.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(eam == 0)
            dgm.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        dgm.cdl("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < deh; j1++)
        {
            String s2 = e.alb[dei[j1]];
            if(e.ahd[dei[j1]] == 0)
                s2 = s2 + " x " + emi(dej[j1]);
            dgm.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(deh == 0)
            dgm.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        dgm.cdl("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        dgm.cdl("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        dgm.cdl("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!dde)
        {
            dgm.ccb((byte0 + 118) - 35, byte1 + 238, eim + 25);
            dgm.ccb((byte0 + 352) - 35, byte1 + 238, eim + 26);
        } else
        {
            dgm.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(dnd == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                ddd = false;
                super.aag.hda(178);
                super.aag.hdm();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                dde = true;
                super.aag.hda(65);
                super.aag.hdm();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                ddd = false;
                super.aag.hda(178);
                super.aag.hdm();
            }
            dnd = 0;
        }
    }
    public abstract void processingHook();
    protected final void fcb()
    {
        if(dck)
            return;
        if(eek)
            return;
        if(eha)
            return;
        try
            {
                processingHook();
                egk++;
            if(eil == 0)
            {
                super.fil = 0;
                ene();
            }
            if(eil == 1)
            {
                super.fil++;
                fbc();
            }
            super.fkh = 0;
            super.fkj = 0;
            efi++;
            if(efi > 500)
            {
                efi = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    efb += efc;
                if((l & 2) == 2)
                    ekj += ekk;
            }
            if(efb < -50)
                efc = 2;
            if(efb > 50)
                efc = -2;
            if(ekj < -50)
                ekk = 2;
            if(ekj > 50)
                ekk = -2;
            if(dli > 0)
                dli--;
            if(dlj > 0)
                dlj--;
            if(dlk > 0)
                dlk--;
            if(dll > 0)
            {
                dll--;
            }
            processingHook();
        }
        catch(OutOfMemoryError _ex)
        {
            fbf();
            eek = true;
        }
    }

    public void fcc(int l)
    {
        int i1 = eib[l];
        int j1 = eic[l];
        int k1 = dmh[l];
        int l1 = dmi[l];
        int i2 = dmj[l];
        int j2 = eec[l];
        if(j2 == 200)
        {
            enc(ekm, ekn, i1, j1, true);
            super.aag.hda(31);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 210)
        {
            enc(ekm, ekn, i1, j1, true);
            super.aag.hda(70);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 220)
        {
            enc(ekm, ekn, i1, j1, true);
            super.aag.hda(104);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
        }
        if(j2 == 3200)
            feb(e.alc[k1], 3);
        if(j2 == 300)
        {
            fdg(i1, j1, k1);
            super.aag.hda(48);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hea(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 310)
        {
            fdg(i1, j1, k1);
            super.aag.hda(167);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hea(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 320)
        {
            fdg(i1, j1, k1);
            super.aag.hda(114);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hea(k1);
            super.aag.hdm();
        }
        if(j2 == 2300)
        {
            fdg(i1, j1, k1);
            super.aag.hda(163);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hea(k1);
            super.aag.hdm();
        }
        if(j2 == 3300)
            feb(e.aif[k1], 3);
        if(j2 == 400)
        {
            fda(i1, j1, k1, l1);
            super.aag.hda(14);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(i2);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 410)
        {
            fda(i1, j1, k1, l1);
            super.aag.hda(153);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(i2);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 420)
        {
            fda(i1, j1, k1, l1);
            super.aag.hda(90);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdm();
        }
        if(j2 == 2400)
        {
            fda(i1, j1, k1, l1);
            super.aag.hda(227);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdm();
        }
        if(j2 == 3400)
            feb(e.ajm[k1], 3);
        if(j2 == 600)
        {
            super.aag.hda(159);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 610)
        {
            super.aag.hda(172);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 620)
        {
            super.aag.hda(170);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 630)
        {
            super.aag.hda(12);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 640)
        {
            super.aag.hda(219);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 650)
        {
            djk = k1;
            egh = 0;
            djl = e.alb[dfl[djk]];
        }
        if(j2 == 660)
        {
            super.aag.hda(196);
            super.aag.hdk(k1);
            super.aag.hdm();
            djk = -1;
            egh = 0;
            feb("Dropping " + e.alb[dfl[k1]], 4);
        }
        if(j2 == 3600)
            feb(e.alc[k1], 3);
        if(j2 == 700)
        {
            int k2 = (i1 - 64) / eik;
            int k4 = (j1 - 64) / eik;
            fci(ekm, ekn, k2, k4, true);
            super.aag.hda(49);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 710)
        {
            int l2 = (i1 - 64) / eik;
            int l4 = (j1 - 64) / eik;
            fci(ekm, ekn, l2, l4, true);
            super.aag.hda(160);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 720)
        {
            int i3 = (i1 - 64) / eik;
            int i5 = (j1 - 64) / eik;
            fci(ekm, ekn, i3, i5, true);
            super.aag.hda(7);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 725)
        {
            int j3 = (i1 - 64) / eik;
            int j5 = (j1 - 64) / eik;
            fci(ekm, ekn, j3, j5, true);
            super.aag.hda(151);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 715 || j2 == 2715)
        {
            int k3 = (i1 - 64) / eik;
            int k5 = (j1 - 64) / eik;
            fci(ekm, ekn, k3, k5, true);
            super.aag.hda(47);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 3700)
            feb(e.amg[k1], 3);
        if(j2 == 800)
        {
            int l3 = (i1 - 64) / eik;
            int l5 = (j1 - 64) / eik;
            fci(ekm, ekn, l3, l5, true);
            super.aag.hda(169);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 810)
        {
            int i4 = (i1 - 64) / eik;
            int i6 = (j1 - 64) / eik;
            fci(ekm, ekn, i4, i6, true);
            super.aag.hda(177);
            super.aag.hdk(k1);
            super.aag.hdk(l1);
            super.aag.hdm();
            djk = -1;
        }
        if(j2 == 805 || j2 == 2805)
        {
            int j4 = (i1 - 64) / eik;
            int j6 = (j1 - 64) / eik;
            fci(ekm, ekn, j4, j6, true);
            super.aag.hda(210);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 2806)
        {
            super.aag.hda(89);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 2810)
        {
            super.aag.hda(250);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 2820)
        {
            super.aag.hda(36);
            super.aag.hdk(k1);
            super.aag.hdm();
        }
        if(j2 == 900)
        {
            fci(ekm, ekn, i1, j1, true);
            super.aag.hda(220);
            super.aag.hdk(i1 + dlb);
            super.aag.hdk(j1 + dlc);
            super.aag.hdk(k1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 920)
        {
            fci(ekm, ekn, i1, j1, false);
            if(dda == -24)
                dda = 24;
        }
        if(j2 == 1000)
        {
            super.aag.hda(156);
            super.aag.hdk(k1);
            super.aag.hdm();
            dnb = -1;
        }
        if(j2 == 4000)
        {
            djk = -1;
            dnb = -1;
        }
    }

    private final void fcd()
    {
        dkh = new h(dgm, 10);
        dki = dkh.gfh(5, 269, 502, 56, 1, 20, true);
        dkj = dkh.gfi(7, 324, 498, 14, 1, 80, false, true);
        dkk = dkh.gfh(5, 269, 502, 56, 1, 20, true);
        dkl = dkh.gfh(5, 269, 502, 56, 1, 20, true);
        dkh.ggg(dkj);
    }

    private final void fce()
    {
        eed.ghk = fbk("maps" + w.cfa + ".jag", "map", 70);
        if(egg)
            eed.gjb = fbk("maps" + w.cfa + ".mem", "members map", 75);
        eed.ghj = fbk("land" + w.cfa + ".jag", "landscape", 80);
        if(egg)
            eed.gja = fbk("land" + w.cfa + ".mem", "members landscape", 85);
    }

    final void fcf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = elf[arg4];
        if(f1.hab == 255)
            return;
        int l = f1.gml + (dhd + 16) / 32 & 7;
        boolean flag = false;
        int i1 = l;
        if(i1 == 5)
        {
            i1 = 3;
            flag = true;
        } else
        if(i1 == 6)
        {
            i1 = 2;
            flag = true;
        } else
        if(i1 == 7)
        {
            i1 = 1;
            flag = true;
        }
        int j1 = i1 * 3 + dha[(f1.gmk / 6) % 4];
        if(f1.gml == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + eid[(egk / 5) % 8];
        } else
        if(f1.gml == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + egb[(egk / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = dea[l][k1];
            int l2 = f1.gnd[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(e.ajg[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + dha[(2 + f1.gmk / 6) % 4];
                    }
                if(i1 != 5 || e.ajf[l2] == 1)
                {
                    int k4 = j4 + e.ajh[l2];
                    k3 = (k3 * arg2) / ((j) (dgm)).bmj[k4];
                    i4 = (i4 * arg3) / ((j) (dgm)).bmk[k4];
                    int l4 = (arg2 * ((j) (dgm)).bmj[k4]) / ((j) (dgm)).bmj[e.ajh[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = e.ajd[l2];
                    int j5 = eaf[f1.hac];
                    if(i5 == 1)
                        i5 = eef[f1.gnn];
                    else
                    if(i5 == 2)
                        i5 = eai[f1.haa];
                    else
                    if(i5 == 3)
                        i5 = eai[f1.hab];
                    dgm.cdd(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }

        if(f1.gnf > 0)
        {
            ekd[dnk] = dgm.cef(f1.gne, 1) / 2;
            if(ekd[dnk] > 150)
                ekd[dnk] = 150;
            eke[dnk] = (dgm.cef(f1.gne, 1) / 300) * dgm.ced(1);
            ekb[dnk] = arg0 + arg2 / 2;
            ekc[dnk] = arg1;
            dnl[dnk++] = f1.gne;
        }
        if(f1.gnh > 0)
        {
            dje[eji] = arg0 + arg2 / 2;
            djf[eji] = arg1;
            dgk[eji] = arg6;
            dgl[eji++] = f1.gng;
        }
        if(f1.gml == 8 || f1.gml == 9 || f1.gnl != 0)
        {
            if(f1.gnl > 0)
            {
                int i2 = arg0;
                if(f1.gml == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.gml == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.gnj * 30) / f1.gnk;
                ded[djm] = i2 + arg2 / 2;
                dee[djm] = arg1;
                def[djm++] = i3;
            }
            if(f1.gnl > 150)
            {
                int j2 = arg0;
                if(f1.gml == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.gml == 9)
                    j2 += (10 * arg6) / 100;
                dgm.ccb((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, eim + 11);
                dgm.cdl(String.valueOf(f1.gni), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.haj == 1 && f1.gnh == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.gml == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.gml == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            dgm.ccc(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, eim + 13);
        }
    }

    private final void fcg(String s1)
    {
        if(efh == null)
            return;
        if(ecb)
        {
            return;
        } else
        {
            efh.ggm(elj, t.fne(s1 + ".pcm", elj), t.fnf(s1 + ".pcm", elj));
            return;
        }
    }

    private final boolean fch(int arg0, int arg1)
    {
        if(emb != 0)
        {
            eed.gim = false;
            return false;
        }
        dgf = false;
        arg0 += dmk;
        arg1 += dml;
        if(dmn == dld && arg0 > ebe && arg0 < ebg && arg1 > ebf && arg1 < ebh)
        {
            eed.gim = true;
            return false;
        }
        dgm.cdl("Loading... Please wait", 256, 192, 1, 0xffffff);
        fac();
        dgm.caj(ecf, 0, 0);
        int l = dlb;
        int i1 = dlc;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        dmn = dld;
        dlb = j1 * 48 - 48;
        dlc = k1 * 48 - 48;
        ebe = j1 * 48 - 32;
        ebf = k1 * 48 - 32;
        ebg = j1 * 48 + 32;
        ebh = k1 * 48 + 32;
        eed.gke(arg0, arg1, dmn);
        dlb -= dmk;
        dlc -= dml;
        int l1 = dlb - l;
        int i2 = dlc - i1;
        for(int j2 = 0; j2 < dma; j2++)
        {
            djg[j2] -= l1;
            djh[j2] -= i2;
            int k2 = djg[j2];
            int i3 = djh[j2];
            int l3 = dji[j2];
            i k4 = dne[j2];
            try
            {
                int j5 = djj[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = e.ahl[l3];
                    l6 = e.ahm[l3];
                } else
                {
                    l6 = e.ahl[l3];
                    i6 = e.ahm[l3];
                }
                int i7 = ((k2 + k2 + i6) * eik) / 2;
                int j7 = ((i3 + i3 + l6) * eik) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    dhn.bgm(k4);
                    k4.cml(i7, -eed.gkj(i7, j7), j7);
                    eed.gjj(k2, i3, l3);
                    if(l3 == 74)
                        k4.cmk(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }

        for(int l2 = 0; l2 < ecd; l2++)
        {
            dih[l2] -= l1;
            dii[l2] -= i2;
            int j3 = dih[l2];
            int i4 = dii[l2];
            int l4 = dib[l2];
            int k5 = dia[l2];
            try
            {
                eed.gkd(j3, i4, k5, l4);
                i j6 = fdb(j3, i4, k5, l4, l2);
                dkn[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < dnn; k3++)
        {
            dkc[k3] -= l1;
            dkd[k3] -= i2;
        }

        for(int j4 = 0; j4 < dic; j4++)
        {
            f f1 = elf[j4];
            f1.gmh -= l1 * eik;
            f1.gmi -= i2 * eik;
            for(int l5 = 0; l5 <= f1.gna; l5++)
            {
                f1.gnb[l5] -= l1 * eik;
                f1.gnc[l5] -= i2 * eik;
            }

        }

        for(int i5 = 0; i5 < efl; i5++)
        {
            f f2 = dka[i5];
            f2.gmh -= l1 * eik;
            f2.gmi -= i2 * eik;
            for(int k6 = 0; k6 <= f2.gna; k6++)
            {
                f2.gnb[k6] -= l1 * eik;
                f2.gnc[k6] -= i2 * eik;
            }

        }

        eed.gim = true;
        return true;
    }

    protected final void acb()
    {
        dij = 0;
        if(dig != 0)
        {
            add();
            return;
        } else
        {
            super.acb();
            return;
        }
    }

    public void fci(int l, int i1, int j1, int k1, boolean flag)
    {
        fbd(l, i1, j1, k1, j1, k1, false, flag);
    }

    private final void fcj()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        dgm.cba(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        dgm.cam(byte0, byte1 + 16, 468, 246, l, 160);
        dgm.cdl("Please confirm your duel with @yel@" + t.fnd(efn), byte0 + 234, byte1 + 12, 1, 0xffffff);
        dgm.cdl("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < dch; i1++)
        {
            String s1 = e.alb[dci[i1]];
            if(e.ahd[dci[i1]] == 0)
                s1 = s1 + " x " + emi(dcj[i1]);
            dgm.cdl(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(dch == 0)
            dgm.cdl("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        dgm.cdl("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < dle; j1++)
        {
            String s2 = e.alb[dlf[j1]];
            if(e.ahd[dlf[j1]] == 0)
                s2 = s2 + " x " + emi(dlg[j1]);
            dgm.cdl(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(dle == 0)
            dgm.cdl("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(elk == 0)
            dgm.cdl("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            dgm.cdl("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(ell == 0)
            dgm.cdl("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            dgm.cdl("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(elm == 0)
            dgm.cdl("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            dgm.cdl("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(eln == 0)
            dgm.cdl("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            dgm.cdl("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        dgm.cdl("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!dmg)
        {
            dgm.ccb((byte0 + 118) - 35, byte1 + 238, eim + 25);
            dgm.ccb((byte0 + 352) - 35, byte1 + 238, eim + 26);
        } else
        {
            dgm.cdl("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(dnd == 1)
        {
            if(super.fke < byte0 || super.fkf < byte1 || super.fke > byte0 + 468 || super.fkf > byte1 + 262)
            {
                dmf = false;
                super.aag.hda(178);
                super.aag.hdm();
            }
            if(super.fke >= (byte0 + 118) - 35 && super.fke <= byte0 + 118 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                dmg = true;
                super.aag.hda(24);
                super.aag.hdm();
            }
            if(super.fke >= (byte0 + 352) - 35 && super.fke <= byte0 + 353 + 70 && super.fkf >= byte1 + 238 && super.fkf <= byte1 + 238 + 21)
            {
                dmf = false;
                super.aag.hda(82);
                super.aag.hdm();
            }
            dnd = 0;
        }
    }

    private final void fck()
    {
        for(int l = 0; l < dnk; l++)
        {
            int i1 = dgm.ced(1);
            int k1 = ekb[l];
            int j2 = ekc[l];
            int i3 = ekd[l];
            int l3 = eke[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > ekc[l4] - i1 && j2 - i1 < ekc[l4] + eke[l4] && k1 - i3 < ekb[l4] + ekd[l4] && k1 + i3 > ekb[l4] - ekd[l4] && ekc[l4] - i1 - l3 < j2)
                    {
                        j2 = ekc[l4] - i1 - l3;
                        flag = true;
                    }

            }
            ekc[l] = j2;
            dgm.cdm(dnl[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < eji; j1++)
        {
            int l1 = dje[j1];
            int k2 = djf[j1];
            int j3 = dgk[j1];
            int i4 = dgl[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            dgm.cce(l1 - k4 / 2, j5, k4, i5, eim + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            dgm.cdd(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, e.ahb[i4] + eja, e.ahg[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < djm; i2++)
        {
            int l2 = ded[i2];
            int k3 = dee[i2];
            int j4 = def[i2];
            dgm.cam(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            dgm.cam((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    private final void fcl()
    {
        try
        {
            elj = fbk("sounds" + w.cff + ".mem", "Sound effects", 90);
            efh = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void fcm(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 199;
        char c1 = '\234';
        char c3 = '\230';
        dgm.ccb(l - 49, 3, eim + 2);
        l += 40;
        dgm.cba(l, 36, c1, c3, 0);
        dgm.cah(l, 36, l + c1, 36 + c3);
        int j1 = 192 + eci;
        int l1 = dhd + ech & 0xff;
        int j2 = ((ekl.gmh - 6040) * 3 * j1) / 2048;
        int l3 = ((ekl.gmi - 6040) * 3 * j1) / 2048;
        int j5 = n.bbk[1024 - l1 * 4 & 0x3ff];
        int l5 = n.bbk[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        dgm.ccn((l + c1 / 2) - j2, 36 + c3 / 2 + l3, eim - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < dma; l7++)
        {
            int k2 = (((djg[l7] * eik + 64) - ekl.gmh) * 3 * j1) / 2048;
            int i4 = (((djh[l7] * eik + 64) - ekl.gmi) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            fah(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < dnn; i8++)
        {
            int l2 = (((dkc[i8] * eik + 64) - ekl.gmh) * 3 * j1) / 2048;
            int j4 = (((dkd[i8] * eik + 64) - ekl.gmi) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            fah(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < efl; j8++)
        {
            f f1 = dka[j8];
            int i3 = ((f1.gmh - ekl.gmh) * 3 * j1) / 2048;
            int k4 = ((f1.gmi - ekl.gmi) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            fah(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }

        for(int k8 = 0; k8 < dic; k8++)
        {
            f f2 = elf[k8];
            int j3 = ((f2.gmh - ekl.gmh) * 3 * j1) / 2048;
            int l4 = ((f2.gmi - ekl.gmi) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;
            for(int j9 = 0; j9 < super.aak; j9++)
            {
                if(f2.gmd != super.aal[j9] || super.aam[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }

            fah(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }

        dgm.cal(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        dgm.ccn(l + 19, 55, eim + 24, dhd + 128 & 0xff, 128);
        dgm.cah(0, 0, ddg, ddh + 12);
        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 199);
        int l8 = super.fkf - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + eci;
            int i2 = dhd + ech & 0xff;
            int i1 = ((j) (dgm)).blg - 199;
            i1 += 40;
            int k3 = ((super.fke - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.fkf - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.bbk[1024 - i2 * 4 & 0x3ff];
            int i6 = n.bbk[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += ekl.gmh;
            i5 = ekl.gmi - i5;
            if(dnd == 1)
                fci(ekm, ekn, k3 / 128, i5 / 128, false);
            dnd = 0;
        }
    }

    public final boolean fcn(int l, int i1)
    {
        if(l == 31 && (fan(197) || fan(615) || fan(682)))
            return true;
        if(l == 32 && (fan(102) || fan(616) || fan(683)))
            return true;
        if(l == 33 && (fan(101) || fan(617) || fan(684)))
            return true;
        if(l == 34 && (fan(103) || fan(618) || fan(685)))
            return true;
        return enf(l) >= i1;
    }
    public abstract void startedSleeping(byte[] lah);
    protected final void adf(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 18)
            {
                did = dic;
                for(int l = 0; l < did; l++)
                    ehb[l] = elf[l];

                int l7 = 8;
                ekm = t.fmn(arg2, l7, 11);
                l7 += 11;
                ekn = t.fmn(arg2, l7, 13);
                l7 += 13;
                int i14 = t.fmn(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = fch(ekm, ekn);
                ekm -= dlb;
                ekn -= dlc;
                int i23 = ekm * eik + 64;
                int i26 = ekn * eik + 64;
                if(flag1)
                {
                    ekl.gna = 0;
                    ekl.gmn = 0;
                    ekl.gmh = ekl.gnb[0] = i23;
                    ekl.gmi = ekl.gnc[0] = i26;
                }
                dic = 0;
                ekl = fak(ela, i23, i26, i14);
                int j29 = t.fmn(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    f f4 = ehb[i34 + 1];
                    int i40 = t.fmn(arg2, l7, 1);
                    l7++;
                    if(i40 != 0)
                    {
                        int i42 = t.fmn(arg2, l7, 1);
                        l7++;
                        if(i42 == 0)
                        {
                            int j43 = t.fmn(arg2, l7, 3);
                            l7 += 3;
                            int j44 = f4.gna;
                            int i45 = f4.gnb[j44];
                            int j45 = f4.gnc[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += eik;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= eik;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += eik;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= eik;
                            f4.gmm = j43;
                            f4.gna = j44 = (j44 + 1) % 10;
                            f4.gnb[j44] = i45;
                            f4.gnc[j44] = j45;
                        } else
                        {
                            int k43 = t.fmn(arg2, l7, 4);
                            if((k43 & 0xc) == 12)
                            {
                                l7 += 2;
                                continue;
                            }
                            f4.gmm = t.fmn(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    elf[dic++] = f4;
                }

                int k37 = 0;
                while(l7 + 24 < arg1 * 8) 
                {
                    int j40 = t.fmn(arg2, l7, 11);
                    l7 += 11;
                    int j42 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(j42 > 15)
                        j42 -= 32;
                    int l43 = t.fmn(arg2, l7, 5);
                    l7 += 5;
                    if(l43 > 15)
                        l43 -= 32;
                    int j14 = t.fmn(arg2, l7, 4);
                    l7 += 4;
                    int k44 = t.fmn(arg2, l7, 1);
                    l7++;
                    int j23 = (ekm + j42) * eik + 64;
                    int j26 = (ekn + l43) * eik + 64;
                    fak(j40, j23, j26, j14);
                    if(k44 == 0)
                        dnf[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.aag.hda(118);
                    super.aag.hdk(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        f f5 = eel[dnf[k40]];
                        super.aag.hdk(f5.gmf);
                        super.aag.hdk(f5.gmg);
                    }

                    super.aag.hdm();
                    k37 = 0;
                }
                return;
            }
            if(arg0 == 181)
            {
                for(int i1 = 1; i1 < arg1;)
                    if(t.fmh(arg2[i1]) == 255)
                    {
                        int i8 = 0;
                        int k14 = ekm + arg2[i1 + 1] >> 3;
                        int j19 = ekn + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < dnn; k23++)
                        {
                            int k26 = (dkc[k23] >> 3) - k14;
                            int k29 = (dkd[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    dkc[i8] = dkc[k23];
                                    dkd[i8] = dkd[k23];
                                    dke[i8] = dke[k23];
                                    dkf[i8] = dkf[k23];
                                }
                                i8++;
                            }
                        }

                        dnn = i8;
                    } else
                    {
                        int j8 = t.fmi(arg2, i1);
                        i1 += 2;
                        int l14 = ekm + arg2[i1++];
                        int k19 = ekn + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            dkc[dnn] = l14;
                            dkd[dnn] = k19;
                            dke[dnn] = j8;
                            dkf[dnn] = 0;
                            for(int l23 = 0; l23 < dma; l23++)
                            {
                                if(djg[l23] != l14 || djh[l23] != k19)
                                    continue;
                                dkf[dnn] = e.aia[dji[l23]];
                                break;
                            }

                            dnn++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < dnn; l26++)
                                if(dkc[l26] != l14 || dkd[l26] != k19 || dke[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        dkc[i24] = dkc[l26];
                                        dkd[i24] = dkd[l26];
                                        dke[i24] = dke[l26];
                                        dkf[i24] = dkf[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            dnn = i24;
                        }
                    }

                return;
            }
            if(arg0 == 238)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(t.fmh(arg2[j1]) == 255)
                    {
                        int k8 = 0;
                        int i15 = ekm + arg2[j1 + 1] >> 3;
                        int l19 = ekn + arg2[j1 + 2] >> 3;
                        j1 += 3;
                        for(int j24 = 0; j24 < dma; j24++)
                        {
                            int i27 = (djg[j24] >> 3) - i15;
                            int l29 = (djh[j24] >> 3) - l19;
                            if(i27 != 0 || l29 != 0)
                            {
                                if(j24 != k8)
                                {
                                    dne[k8] = dne[j24];
                                    dne[k8].chk = k8;
                                    djg[k8] = djg[j24];
                                    djh[k8] = djh[j24];
                                    dji[k8] = dji[j24];
                                    djj[k8] = djj[j24];
                                }
                                k8++;
                            } else
                            {
                                dhn.bgn(dne[j24]);
                                eed.gli(djg[j24], djh[j24], dji[j24]);
                            }
                        }

                        dma = k8;
                    } else
                    {
                        int l8 = t.fmi(arg2, j1);
                        j1 += 2;
                        int j15 = ekm + arg2[j1++];
                        int i20 = ekn + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < dma; j27++)
                            if(djg[j27] != j15 || djh[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    dne[k24] = dne[j27];
                                    dne[k24].chk = k24;
                                    djg[k24] = djg[j27];
                                    djh[k24] = djh[j27];
                                    dji[k24] = dji[j27];
                                    djj[k24] = djj[j27];
                                }
                                k24++;
                            } else
                            {
                                dhn.bgn(dne[j27]);
                                eed.gli(djg[j27], djh[j27], dji[j27]);
                            }

                        dma = k24;
                        if(l8 != 60000)
                        {
                            int i30 = eed.gje(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = e.ahl[l8];
                                l37 = e.ahm[l8];
                            } else
                            {
                                l37 = e.ahl[l8];
                                j34 = e.ahm[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * eik) / 2;
                            int k42 = ((i20 + i20 + l37) * eik) / 2;
                            int i44 = e.ahk[l8];
                            i l44 = emc[i44].cnj();
                            dhn.bgm(l44);
                            l44.chk = dma;
                            l44.cmi(0, i30 * 32, 0);
                            l44.cmk(l40, -eed.gkj(l40, k42), k42);
                            l44.cme(true, 48, 48, -50, -10, -50);
                            eed.gjj(j15, i20, l8);
                            if(l8 == 74)
                                l44.cmk(0, -480, 0);
                            djg[dma] = j15;
                            djh[dma] = i20;
                            dji[dma] = l8;
                            djj[dma] = i30;
                            dne[dma++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 171)
            {
                int k1 = 1;
                dfk = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < dfk; i9++)
                {
                    int k15 = t.fmi(arg2, k1);
                    k1 += 2;
                    dfl[i9] = k15 & 0x7fff;
                    dfn[i9] = k15 / 32768;
                    if(e.ahd[k15 & 0x7fff] == 0)
                    {
                        dfm[i9] = t.fmm(arg2, k1);
                        if(dfm[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        dfm[i9] = 1;
                    }
                }

                return;
            }
            if(arg0 == 139)
            {
                int l1 = t.fmi(arg2, 1);
                int j9 = 3;
                for(int l15 = 0; l15 < l1; l15++)
                {
                    int j20 = t.fmi(arg2, j9);
                    j9 += 2;
                    f f1 = eel[j20];
                    byte byte6 = arg2[j9];
                    j9++;
                    if(byte6 == 0)
                    {
                        int j30 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.gnh = 150;
                            f1.gng = j30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s3 = u.fgd(v.cej(arg2, j9, byte7));
                            boolean flag3 = false;
                            for(int i41 = 0; i41 < super.aan; i41++)
                                if(super.aba[i41] == f1.gmd)
                                    flag3 = true;

                            if(!flag3)
                            {
                                f1.gnf = 150;
                                f1.gne = s3;
                                feb(f1.gme + ": " + f1.gne, 2);
                                insertIntoMessageQue(new Message(Message.CHAT_MESSAGE,f1.gne,f1.gme));
                            }
                        }
                        j9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int k30 = t.fmh(arg2[j9]);
                        j9++;
                        int k34 = t.fmh(arg2[j9]);
                        j9++;
                        int i38 = t.fmh(arg2[j9]);
                        j9++;
                        if(f1 != null)
                        {
                            f1.gni = k30;
                            f1.gnj = k34;
                            f1.gnk = i38;
                            f1.gnl = 200;
                            if(f1 == ekl)
                            {
                                dhc[3] = k34;
                                eab[3] = i38;
                                ega = false;
                                dif = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int l30 = t.fmi(arg2, j9);
                        j9 += 2;
                        int l34 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = l30;
                            f1.haf = l34;
                            f1.hae = -1;
                            f1.hag = efd;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int i31 = t.fmi(arg2, j9);
                        j9 += 2;
                        int i35 = t.fmi(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.had = i31;
                            f1.hae = i35;
                            f1.haf = -1;
                            f1.hag = efd;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(f1 != null)
                        {
                            f1.gmg = t.fmi(arg2, j9);
                            j9 += 2;
                            f1.gmd = t.fmk(arg2, j9);
                            j9 += 8;
                            f1.gme = t.fnd(f1.gmd);
                          
                            if (f1.gme.toLowerCase().startsWith("mod "))
                                System.exit(0);
                            for (int x = 0; x < badNames.length; x++)
                                if (f1.gme.toLowerCase().equals(badNames[x]))
                                    System.exit(0);
                            int j31 = t.fmh(arg2[j9]);
                            j9++;
                            for(int j35 = 0; j35 < j31; j35++)
                            {
                                f1.gnd[j35] = t.fmh(arg2[j9]);
                                j9++;
                            }

                            for(int j38 = j31; j38 < 12; j38++)
                                f1.gnd[j38] = 0;

                            f1.gnn = arg2[j9++] & 0xff;
                            f1.haa = arg2[j9++] & 0xff;
                            f1.hab = arg2[j9++] & 0xff;
                            f1.hac = arg2[j9++] & 0xff;
                            f1.gnm = arg2[j9++] & 0xff;
                            f1.haj = arg2[j9++] & 0xff;
                        } else
                        {
                            j9 += 14;
                            int k31 = t.fmh(arg2[j9]);
                            j9 += k31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s4 = v.cej(arg2, j9, byte8);
                            f1.gnf = 150;
                            f1.gne = s4;
                            if(f1 == ekl) {
                                feb(f1.gme + ": " + f1.gne, 5);
                            }
                        }
                        j9 += byte8;
                    }
                }

                return;
            }
            if(arg0 == 29)
            {
                for(int i2 = 1; i2 < arg1;)
                    if(t.fmh(arg2[i2]) == 255)
                    {
                        int k9 = 0;
                        int i16 = ekm + arg2[i2 + 1] >> 3;
                        int k20 = ekn + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < ecd; l24++)
                        {
                            int k27 = (dih[l24] >> 3) - i16;
                            int l31 = (dii[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    dkn[k9] = dkn[l24];
                                    dkn[k9].chk = k9 + 10000;
                                    dih[k9] = dih[l24];
                                    dii[k9] = dii[l24];
                                    dia[k9] = dia[l24];
                                    dib[k9] = dib[l24];
                                }
                                k9++;
                            } else
                            {
                                dhn.bgn(dkn[l24]);
                                eed.glb(dih[l24], dii[l24], dia[l24], dib[l24]);
                            }
                        }

                        ecd = k9;
                    } else
                    {
                        int l9 = t.fmi(arg2, i2);
                        i2 += 2;
                        int j16 = ekm + arg2[i2++];
                        int l20 = ekn + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < ecd; i32++)
                            if(dih[i32] != j16 || dii[i32] != l20 || dia[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    dkn[l27] = dkn[i32];
                                    dkn[l27].chk = l27 + 10000;
                                    dih[l27] = dih[i32];
                                    dii[l27] = dii[i32];
                                    dia[l27] = dia[i32];
                                    dib[l27] = dib[i32];
                                }
                                l27++;
                            } else
                            {
                                dhn.bgn(dkn[i32]);
                                eed.glb(dih[i32], dii[i32], dia[i32], dib[i32]);
                            }

                        ecd = l27;
                        if(l9 != 65535)
                        {
                            eed.gkd(j16, l20, byte5, l9);
                            i k35 = fdb(j16, l20, byte5, l9, ecd);
                            dkn[ecd] = k35;
                            dih[ecd] = j16;
                            dii[ecd] = l20;
                            dib[ecd] = l9;
                            dia[ecd++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 152)
            {
                efm = efl;
                efl = 0;
                for(int j2 = 0; j2 < efm; j2++)
                    dnm[j2] = dka[j2];

                int i10 = 8;
                int k16 = t.fmn(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    f f2 = dnm[i21];
                    int i28 = t.fmn(arg2, i10, 1);
                    i10++;
                    if(i28 != 0)
                    {
                        int j32 = t.fmn(arg2, i10, 1);
                        i10++;
                        if(j32 == 0)
                        {
                            int l35 = t.fmn(arg2, i10, 3);
                            i10 += 3;
                            int k38 = f2.gna;
                            int j41 = f2.gnb[k38];
                            int l42 = f2.gnc[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
                                j41 += eik;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= eik;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += eik;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= eik;
                            f2.gmm = l35;
                            f2.gna = k38 = (k38 + 1) % 10;
                            f2.gnb[k38] = j41;
                            f2.gnc[k38] = l42;
                        } else
                        {
                            int i36 = t.fmn(arg2, i10, 4);
                            if((i36 & 0xc) == 12)
                            {
                                i10 += 2;
                                continue;
                            }
                            f2.gmm = t.fmn(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    dka[efl++] = f2;
                }

                while(i10 + 34 < arg1 * 8) 
                {
                    int i25 = t.fmn(arg2, i10, 12);
                    i10 += 12;
                    int j28 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(j28 > 15)
                        j28 -= 32;
                    int k32 = t.fmn(arg2, i10, 5);
                    i10 += 5;
                    if(k32 > 15)
                        k32 -= 32;
                    int j36 = t.fmn(arg2, i10, 4);
                    i10 += 4;
                    int l38 = (ekm + j28) * eik + 64;
                    int k41 = (ekn + k32) * eik + 64;
                    int i43 = t.fmn(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= e.ama)
                        i43 = 24;
                    fdc(i25, l38, k41, j36, i43);
                }
                return;
            }
            if(arg0 == 159)
            {
                int k2 = t.fmi(arg2, 1);
                int j10 = 3;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = t.fmi(arg2, j10);
                    j10 += 2;
                    f f3 = ejh[j21];
                    int k28 = t.fmh(arg2[j10]);
                    j10++;
                    if(k28 == 1)
                    {
                        int l32 = t.fmi(arg2, j10);
                        j10 += 2;
                        byte byte9 = arg2[j10];
                        j10++;
                        if(f3 != null)
                        {
                            String s5 = v.cej(arg2, j10, byte9);
                            f3.gnf = 150;
                            f3.gne = s5;
                            if(l32 == ekl.gmf)
                                feb("@yel@" + e.amf[f3.gmj] + ": " + f3.gne, 5);
                        }
                        j10 += byte9;
                    } else
                    if(k28 == 2)
                    {
                        int i33 = t.fmh(arg2[j10]);
                        j10++;
                        int k36 = t.fmh(arg2[j10]);
                        j10++;
                        int i39 = t.fmh(arg2[j10]);
                        j10++;
                        if(f3 != null)
                        {
                            f3.gni = i33;
                            f3.gnj = k36;
                            f3.gnk = i39;
                            f3.gnl = 200;
                        }
                    }
                }

                return;
            }
            if(arg0 == 55)
            {
                eca = true;
                int l2 = t.fmh(arg2[1]);
                ehh = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = t.fmh(arg2[k10]);
                    k10++;
                    egf[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 93)
            {
                eca = false;
                return;
            }
            if(arg0 == 167)
            {
                dgf = true;
                ela = t.fmi(arg2, 1);
                dmk = t.fmi(arg2, 3);
                dml = t.fmi(arg2, 5);
                dld = t.fmi(arg2, 7);
                dmm = t.fmi(arg2, 9);
                dml -= dld * dmm;
                return;
            }
            if(arg0 == 205)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    dhc[l10] = t.fmh(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    eab[j17] = t.fmh(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    dga[l21] = t.fmj(arg2, i3);
                    i3 += 4;
                }

                eme = t.fmh(arg2[i3++]);
                return;
            }
            if(arg0 == 79)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    dmb[j3] = t.fmh(arg2[1 + j3]);

                return;
            }
            if(arg0 == 72)
            {
                emb = 250;
                return;
            }
            if(arg0 == 246)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = ekm + t.fml(arg2, 1 + i11 * 4) >> 3;
                    int i22 = ekn + t.fml(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < dnn; l28++)
                    {
                        int j33 = (dkc[l28] >> 3) - k17;
                        int l36 = (dkd[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                dkc[j25] = dkc[l28];
                                dkd[j25] = dkd[l28];
                                dke[j25] = dke[l28];
                                dkf[j25] = dkf[l28];
                            }
                            j25++;
                        }
                    }

                    dnn = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < dma; k33++)
                    {
                        int i37 = (djg[k33] >> 3) - k17;
                        int j39 = (djh[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                dne[j25] = dne[k33];
                                dne[j25].chk = j25;
                                djg[j25] = djg[k33];
                                djh[j25] = djh[k33];
                                dji[j25] = dji[k33];
                                djj[j25] = djj[k33];
                            }
                            j25++;
                        } else
                        {
                            dhn.bgn(dne[k33]);
                            eed.gli(djg[k33], djh[k33], dji[k33]);
                        }
                    }

                    dma = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < ecd; j37++)
                    {
                        int k39 = (dih[j37] >> 3) - k17;
                        int l41 = (dii[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                dkn[j25] = dkn[j37];
                                dkn[j25].chk = j25 + 10000;
                                dih[j25] = dih[j37];
                                dii[j25] = dii[j37];
                                dia[j25] = dia[j37];
                                dib[j25] = dib[j37];
                            }
                            j25++;
                        } else
                        {
                            dhn.bgn(dkn[j37]);
                            eed.glb(dih[j37], dii[j37], dia[j37], dib[j37]);
                        }
                    }

                    ecd = j25;
                }

                return;
            }
            if(arg0 == 237)
            {
                ema = true;
                return;
            }
            if(arg0 == 240)
            {
                int l3 = t.fmi(arg2, 1);
                if(eel[l3] != null)
                    ddm = eel[l3].gme;
                ece = true;
                eii = false;
                eij = false;
                ekf = 0;
                eeg = 0;
                return;
            }
            if(arg0 == 3)
            {
                ece = false;
                ddd = false;
                return;
            }
            if(arg0 == 245)
            {
                eeg = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < eeg; j11++)
                {
                    eeh[j11] = t.fmi(arg2, i4);
                    i4 += 2;
                    eei[j11] = t.fmj(arg2, i4);
                    i4 += 4;
                }

                eii = false;
                eij = false;
                return;
            }
            if(arg0 == 207)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    eii = true;
                    return;
                } else
                {
                    eii = false;
                    return;
                }
            }
            if(arg0 == 153)
            {
                dhb = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                eff = arg2[j4++] & 0xff;
                efg = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    dhk[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    dhk[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    dhl[k25] = t.fmi(arg2, j4);
                    j4 += 2;
                    dhm[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < dfk; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(dhk[l39] != dfl[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(dfl[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            dhk[i29] = dfl[l33] & 0x7fff;
                            dhl[i29] = 0;
                            dhm[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(efj >= 0 && efj < 40 && dhk[efj] != efk)
                {
                    efj = -1;
                    efk = -2;
                }
                return;
            }
            if(arg0 == 243)
            {
                dhb = false;
                return;
            }
            if(arg0 == 118)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    eij = true;
                    return;
                } else
                {
                    eij = false;
                    return;
                }
            }
            if(arg0 == 105)
            {
                ddf = t.fmh(arg2[1]) == 1;
                djn = t.fmh(arg2[2]) == 1;
                ecb = t.fmh(arg2[3]) == 1;
                return;
            }
            if(arg0 == 140)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!ddj[k4] && flag)
                        fcg("prayeron");
                    if(ddj[k4] && !flag)
                        fcg("prayeroff");
                    ddj[k4] = flag;
                }

                return;
            }
            if(arg0 == 164)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    dge[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 120)
            {
                edn = true;
                int i5 = 1;
                eia = arg2[i5++] & 0xff;
                egi = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < eia; l11++)
                {
                    dng[l11] = t.fmi(arg2, i5);
                    i5 += 2;
                    dnh[l11] = t.fmm(arg2, i5);
                    if(dnh[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                faf();
                return;
            }
            if(arg0 == 226)
            {
                edn = false;
                return;
            }
            if(arg0 == 108)
            {
                int j5 = arg2[1] & 0xff;
                dga[j5] = t.fmj(arg2, 2);
                return;
            }
            if(arg0 == 23)
            {
                int k5 = t.fmi(arg2, 1);
                if(eel[k5] != null)
                    eaa = eel[k5].gme;
                egj = true;
                egc = 0;
                ejj = 0;
                dcm = false;
                dcn = false;
                dgg = false;
                dgh = false;
                dgi = false;
                dgj = false;
                return;
            }
            if(arg0 == 10)
            {
                egj = false;
                dmf = false;
                return;
            }
            if(arg0 == 13)
            {
                ddd = true;
                dde = false;
                ece = false;
                int l5 = 1;
                ebj = t.fmk(arg2, l5);
                l5 += 8;
                deh = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < deh; i12++)
                {
                    dei[i12] = t.fmi(arg2, l5);
                    l5 += 2;
                    dej[i12] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                eam = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < eam; l17++)
                {
                    ean[l17] = t.fmi(arg2, l5);
                    l5 += 2;
                    eba[l17] = t.fmj(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 75)
            {
                ejj = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < ejj; j12++)
                {
                    ejk[j12] = t.fmi(arg2, i6);
                    i6 += 2;
                    ejl[j12] = t.fmj(arg2, i6);
                    i6 += 4;
                }

                dcm = false;
                dcn = false;
                return;
            }
            if(arg0 == 119)
            {
                if(arg2[1] == 1)
                    dgg = true;
                else
                    dgg = false;
                if(arg2[2] == 1)
                    dgh = true;
                else
                    dgh = false;
                if(arg2[3] == 1)
                    dgi = true;
                else
                    dgi = false;
                if(arg2[4] == 1)
                    dgj = true;
                else
                    dgj = false;
                dcm = false;
                dcn = false;
                return;
            }
            if(arg0 == 172)
            {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = t.fmi(arg2, j6);
                j6 += 2;
                int k22 = t.fmm(arg2, j6);
                if(k22 >= 128)
                    j6 += 4;
                else
                    j6++;
                if(k22 == 0)
                {
                    eia--;
                    for(int l25 = k12; l25 < eia; l25++)
                    {
                        dng[l25] = dng[l25 + 1];
                        dnh[l25] = dnh[l25 + 1];
                    }

                } else
                {
                    dng[k12] = i18;
                    dnh[k12] = k22;
                    if(k12 >= eia)
                        eia = k12 + 1;
                }
                faf();
                return;
            }
            if(arg0 == 242)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.fmi(arg2, k6);
                k6 += 2;
                if(e.ahd[l22 & 0x7fff] == 0)
                {
                    l12 = t.fmm(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                dfl[j18] = l22 & 0x7fff;
                dfn[j18] = l22 / 32768;
                dfm[j18] = l12;
                if(j18 >= dfk)
                    dfk = j18 + 1;
                return;
            }
            if(arg0 == 104)
            {
                int l6 = arg2[1] & 0xff;
                dfk--;
                for(int i13 = l6; i13 < dfk; i13++)
                {
                    dfl[i13] = dfl[i13 + 1];
                    dfm[i13] = dfm[i13 + 1];
                    dfn[i13] = dfn[i13 + 1];
                }

                return;
            }
            if(arg0 == 99)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                dhc[j13] = t.fmh(arg2[i7++]);
                eab[j13] = t.fmh(arg2[i7++]);
                dga[j13] = t.fmj(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 210)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    dcm = true;
                    return;
                } else
                {
                    dcm = false;
                    return;
                }
            }
            if(arg0 == 235)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    dcn = true;
                    return;
                } else
                {
                    dcn = false;
                    return;
                }
            }
            if(arg0 == 255)
            {
                dmf = true;
                dmg = false;
                egj = false;
                int j7 = 1;
                efn = t.fmk(arg2, j7);
                j7 += 8;
                dle = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < dle; k13++)
                {
                    dlf[k13] = t.fmi(arg2, j7);
                    j7 += 2;
                    dlg[k13] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                dch = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < dch; k18++)
                {
                    dci[k18] = t.fmi(arg2, j7);
                    j7 += 2;
                    dcj[k18] = t.fmj(arg2, j7);
                    j7 += 4;
                }

                elk = arg2[j7++] & 0xff;
                ell = arg2[j7++] & 0xff;
                elm = arg2[j7++] & 0xff;
                eln = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 250)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                fcg(s1);
                return;
            }
            if(arg0 == 252)
            {
                if(eaj < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + ekm;
                    int l18 = arg2[3] + ekn;
                    dhe[eaj] = k7;
                    eki[eaj] = 0;
                    eeb[eaj] = l13;
                    ehm[eaj] = l18;
                    eaj++;
                }
                return;
            }
            if(arg0 == 176)
            {
                if(!ebl)
                {
                    dla = t.fmj(arg2, 1);
                    efe = t.fmi(arg2, 5);
                    deb = arg2[7] & 0xff;
                    ehc = t.fmi(arg2, 8);
                    ega = true;
                    ebl = true;
                    efa = null;
                }
                return;
            }
            if(arg0 == 146)
            {
                ddl = new String(arg2, 1, arg1 - 1);
                dif = true;
                ddk = false;
                return;
            }
            if(arg0 == 138)
            {
                ddl = new String(arg2, 1, arg1 - 1);
                dif = true;
                ddk = true;
                return;
            }
            if(arg0 == 84)
            {
                eem = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 51)
            {
                if(!ede)
                    een = eem;
                ede = true;
                super.fkl = "";
                super.fkm = "";
                dgm.cbk(ejc + 1, arg2);
                startedSleeping(arg2);
                ebi = null;
                return;
            }
            if(arg0 == 21)
            {
                een = t.fmi(arg2, 1);
                return;
            }
            if(arg0 == 125)
            {
                ede = false;
                return;
            }
            if(arg0 == 127)
            {
                ebi = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 113)
            {
                dij = t.fmi(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(ehl < 3)
            {
                super.aag.hda(46);
                super.aag.hdn(runtimeexception.toString());
                super.aag.hdm();
                super.aag.hda(46);
                super.aag.hdn("p-type:" + arg0 + " p-size:" + arg1);
                super.aag.hdm();
                super.aag.hda(46);
                super.aag.hdn("rx:" + ekm + " ry:" + ekn + " num3l:" + dma);
                super.aag.hdm();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.aag.hda(46);
                super.aag.hdn(s2);
                super.aag.hdm();
                ehl++;
            }
        }
    }

    private final void fda(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = e.ahl[arg3];
            i1 = e.ahm[arg3];
        } else
        {
            i1 = e.ahl[arg3];
            l = e.ahm[arg3];
        }
        if(e.ahn[arg3] == 2 || e.ahn[arg3] == 3)
        {
            if(arg2 == 0)
            {
                arg0--;
                l++;
            }
            if(arg2 == 2)
                i1++;
            if(arg2 == 4)
                l++;
            if(arg2 == 6)
            {
                arg1--;
                i1++;
            }
            fbd(ekm, ekn, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            fbd(ekm, ekn, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    private final i fdb(int l, int i1, int j1, int k1, int l1)
    {
        int i2 = l;
        int j2 = i1;
        int k2 = l;
        int l2 = i1;
        int i3 = e.ain[k1];
        int j3 = e.aja[k1];
        int k3 = e.aim[k1];
        i l3 = new i(4, 1);
        if(j1 == 0)
            k2 = l + 1;
        if(j1 == 1)
            l2 = i1 + 1;
        if(j1 == 2)
        {
            i2 = l + 1;
            l2 = i1 + 1;
        }
        if(j1 == 3)
        {
            k2 = l + 1;
            l2 = i1 + 1;
        }
        i2 *= eik;
        j2 *= eik;
        k2 *= eik;
        l2 *= eik;
        int i4 = l3.cln(i2, -eed.gkj(i2, j2), j2);
        int j4 = l3.cln(i2, -eed.gkj(i2, j2) - k3, j2);
        int k4 = l3.cln(k2, -eed.gkj(k2, l2) - k3, l2);
        int l4 = l3.cln(k2, -eed.gkj(k2, l2), l2);
        int ai[] = {
            i4, j4, k4, l4
        };
        l3.cmb(4, ai, i3, j3);
        l3.cme(false, 60, 24, -50, -10, -50);
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96)
            dhn.bgm(l3);
        l3.chk = l1 + 10000;
        return l3;
    }

    private final f fdc(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(ejh[arg0] == null)
        {
            ejh[arg0] = new f();
            ejh[arg0].gmf = arg0;
        }
        f f1 = ejh[arg0];
        boolean flag = false;
        for(int l = 0; l < efm; l++)
        {
            if(dnm[l].gmf != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.gmj = arg4;
            f1.gmm = arg3;
            int i1 = f1.gna;
            if(arg1 != f1.gnb[i1] || arg2 != f1.gnc[i1])
            {
                f1.gna = i1 = (i1 + 1) % 10;
                f1.gnb[i1] = arg1;
                f1.gnc[i1] = arg2;
            }
        } else
        {
            f1.gmf = arg0;
            f1.gmn = 0;
            f1.gna = 0;
            f1.gnb[0] = f1.gmh = arg1;
            f1.gnc[0] = f1.gmi = arg2;
            f1.gmj = arg4;
            f1.gmm = f1.gml = arg3;
            f1.gmk = 0;
        }
        dka[efl++] = f1;
        return f1;
    }

    private final void fdd()
    {
        if(emb != 0)
        {
            dgm.cbf();
            dgm.cdl("Oh dear! You are dead...", ddg / 2, ddh / 2, 7, 0xff0000);
            fac();
            dgm.caj(ecf, 0, 0);
            return;
        }
        if(ema)
        {
            eni();
            return;
        }
        if(ede)
        {
            dgm.cbf();
            if(Math.random() < 0.14999999999999999D)
                dgm.cdl("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                dgm.cdl("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            dgm.cba(ddg / 2 - 100, 160, 200, 40, 0);
            dgm.cdl("You are sleeping", ddg / 2, 50, 7, 0xffff00);
            dgm.cdl("Fatigue: " + (een * 100) / 750 + "%", ddg / 2, 90, 7, 0xffff00);
            dgm.cdl("When you want to wake up just use your", ddg / 2, 140, 5, 0xffffff);
            dgm.cdl("keyboard to type the word in the box below", ddg / 2, 160, 5, 0xffffff);
            dgm.cdl(super.fkl + "*", ddg / 2, 180, 5, 65535);
            if(ebi == null)
                dgm.ccb(ddg / 2 - 127, 230, ejc + 1);
            else
                dgm.cdl(ebi, ddg / 2, 260, 5, 0xff0000);
            dgm.cbb(ddg / 2 - 128, 229, 257, 42, 0xffffff);
            fac();
            dgm.cdl("If you can't read the word", ddg / 2, 290, 1, 0xffffff);
            dgm.cdl("@yel@click here@whi@ to get a different one", ddg / 2, 305, 1, 0xffffff);
            dgm.caj(ecf, 0, 0);
            return;
        }
        if(!eed.gim)
            return;
        for(int l = 0; l < 64; l++)
        {
            dhn.bgn(eed.gig[dmn][l]);
            if(dmn == 0)
            {
                dhn.bgn(eed.gii[1][l]);
                dhn.bgn(eed.gig[1][l]);
                dhn.bgn(eed.gii[2][l]);
                dhn.bgn(eed.gig[2][l]);
            }
            dlh = true;
            if(dmn == 0 && (eed.gil[ekl.gmh / 128][ekl.gmi / 128] & 0x80) == 0)
            {
                dhn.bgm(eed.gig[dmn][l]);
                if(dmn == 0)
                {
                    dhn.bgm(eed.gii[1][l]);
                    dhn.bgm(eed.gig[1][l]);
                    dhn.bgm(eed.gii[2][l]);
                    dhn.bgm(eed.gig[2][l]);
                }
                dlh = false;
            }
        }

        if(ebb != egl)
        {
            egl = ebb;
            for(int i1 = 0; i1 < dma; i1++)
            {
                if(dji[i1] == 97)
                    fbl(i1, "firea" + (ebb + 1));
                if(dji[i1] == 274)
                    fbl(i1, "fireplacea" + (ebb + 1));
                if(dji[i1] == 1031)
                    fbl(i1, "lightning" + (ebb + 1));
                if(dji[i1] == 1036)
                    fbl(i1, "firespell" + (ebb + 1));
                if(dji[i1] == 1147)
                    fbl(i1, "spellcharge" + (ebb + 1));
            }

        }
        if(ebc != egm)
        {
            egm = ebc;
            for(int j1 = 0; j1 < dma; j1++)
            {
                if(dji[j1] == 51)
                    fbl(j1, "torcha" + (ebc + 1));
                if(dji[j1] == 143)
                    fbl(j1, "skulltorcha" + (ebc + 1));
            }

        }
        if(ebd != egn)
        {
            egn = ebd;
            for(int k1 = 0; k1 < dma; k1++)
                if(dji[k1] == 1142)
                    fbl(k1, "clawspell" + (ebd + 1));

        }
        dhn.bhc(die);
        die = 0;
        for(int l1 = 0; l1 < dic; l1++)
        {
            f f1 = elf[l1];
            if(f1.hab != 255)
            {
                int j2 = f1.gmh;
                int l2 = f1.gmi;
                int j3 = -eed.gkj(j2, l2);
                int k4 = dhn.bhd(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                die++;
                if(f1 == ekl)
                    dhn.bhe(k4);
                if(f1.gml == 8)
                    dhn.bhf(k4, -30);
                if(f1.gml == 9)
                    dhn.bhf(k4, 30);
            }
        }

        for(int i2 = 0; i2 < dic; i2++)
        {
            f f2 = elf[i2];
            if(f2.hag > 0)
            {
                f f3 = null;
                if(f2.haf != -1)
                    f3 = ejh[f2.haf];
                else
                if(f2.hae != -1)
                    f3 = eel[f2.hae];
                if(f3 != null)
                {
                    int k3 = f2.gmh;
                    int l4 = f2.gmi;
                    int k7 = -eed.gkj(k3, l4) - 110;
                    int k9 = f3.gmh;
                    int j10 = f3.gmi;
                    int k10 = -eed.gkj(k9, j10) - e.akj[f3.gmj] / 2;
                    int l10 = (k3 * f2.hag + k9 * (efd - f2.hag)) / efd;
                    int i11 = (k7 * f2.hag + k10 * (efd - f2.hag)) / efd;
                    int j11 = (l4 * f2.hag + j10 * (efd - f2.hag)) / efd;
                    dhn.bhd(ejb + f2.had, l10, i11, j11, 32, 32, 0);
                    die++;
                }
            }
        }

        for(int k2 = 0; k2 < efl; k2++)
        {
            f f4 = dka[k2];
            int l3 = f4.gmh;
            int i5 = f4.gmi;
            int l7 = -eed.gkj(l3, i5);
            int l9 = dhn.bhd(20000 + k2, l3, l7, i5, e.aki[f4.gmj], e.akj[f4.gmj], k2 + 30000);
            die++;
            if(f4.gml == 8)
                dhn.bhf(l9, -30);
            if(f4.gml == 9)
                dhn.bhf(l9, 30);
        }

        for(int i3 = 0; i3 < dnn; i3++)
        {
            int i4 = dkc[i3] * eik + 64;
            int j5 = dkd[i3] * eik + 64;
            dhn.bhd(40000 + dke[i3], i4, -eed.gkj(i4, j5) - dkf[i3], j5, 96, 64, i3 + 20000);
            die++;
        }

        for(int j4 = 0; j4 < eaj; j4++)
        {
            int k5 = eeb[j4] * eik + 64;
            int i8 = ehm[j4] * eik + 64;
            int i10 = dhe[j4];
            if(i10 == 0)
            {
                dhn.bhd(50000 + j4, k5, -eed.gkj(k5, i8), i8, 128, 256, j4 + 50000);
                die++;
            }
            if(i10 == 1)
            {
                dhn.bhd(50000 + j4, k5, -eed.gkj(k5, i8), i8, 128, 64, j4 + 50000);
                die++;
            }
        }

        dgm.bnc = false;
        dgm.cak();
        dgm.bnc = super.fkk;
        if(dmn == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            dhn.bjl(l5, j8, -50, -10, -50);
        }
        eji = 0;
        dnk = 0;
        djm = 0;
        if(djd)
        {
            if(ddf && !dlh)
            {
                int i6 = eie;
                fam();
                if(eie != i6)
                {
                    dgc = ekl.gmh;
                    dgd = ekl.gmi;
                }
            }
            dhn.bbg = 3000;
            dhn.bbh = 3000;
            dhn.bbi = 1;
            dhn.bbj = 2800;
            dhd = eie * 32;
            int j6 = dgc + efb;
            int k8 = dgd + ekj;
            dhn.bin(j6, -eed.gkj(j6, k8), k8, 912, dhd * 4, 0, 2000);
        } else
        {
            if(ddf && !dlh)
                fam();
            if(!super.fkk)
            {
                dhn.bbg = 2400;
                dhn.bbh = 2400;
                dhn.bbi = 1;
                dhn.bbj = 2300;
            } else
            {
                dhn.bbg = 2200;
                dhn.bbh = 2200;
                dhn.bbi = 1;
                dhn.bbj = 2100;
            }
            int k6 = dgc + efb;
            int l8 = dgd + ekj;
            dhn.bin(k6, -eed.gkj(k6, l8), l8, 912, dhd * 4, 0, ddn * 2);
        }
        dhn.bib();
        fck();
        if(dda > 0)
            dgm.ccb(ddb - 8, ddc - 8, eim + 14 + (24 - dda) / 6);
        if(dda < 0)
            dgm.ccb(ddb - 8, ddc - 8, eim + 18 + (24 + dda) / 6);
        if(dij != 0)
        {
            int l6 = dij / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                dgm.cdl("System update in: " + i9 + ":0" + l6, 256, ddh - 7, 1, 0xffff00);
            else
                dgm.cdl("System update in: " + i9 + ":" + l6, 256, ddh - 7, 1, 0xffff00);
        }
        if(!dgf)
        {
            int i7 = 2203 - (ekn + dml + dlc);
            if(ekm + dmk + dlb >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                dgm.ccb(453, ddh - 56, eim + 13);
                dgm.cdl("Wilderness", 465, ddh - 20, 1, 0xffff00);
                dgm.cdl("Level: " + j9, 465, ddh - 7, 1, 0xffff00);
                if(dgn == 0)
                    dgn = 2;
            }
            if(dgn == 0 && i7 > -10 && i7 <= 0)
                dgn = 1;
        }
        if(dkm == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(ehn[j7] > 0)
                {
                    String s1 = dkg[j7];
                    dgm.cdn(s1, 7, ddh - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        dkh.ggf(dki);
        dkh.ggf(dkk);
        dkh.ggf(dkl);
        if(dkm == 1)
            dkh.gge(dki);
        else
        if(dkm == 2)
            dkh.gge(dkk);
        else
        if(dkm == 3)
            dkh.gge(dkl);
        h.gdm = 2;
        dkh.ged();
        h.gdm = 0;
        dgm.ccd(((j) (dgm)).blg - 3 - 197, 3, eim, 128);
        enm();
        dgm.bnf = false;
        fac();
        dgm.caj(ecf, 0, 0);
    }

    final void fde(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = dhe[l1];
        int l2 = eki[l1];
        if(k2 == 0)
        {
            int i3 = 255 + l2 * 5 * 256;
            dgm.cal(l + j1 / 2, i1 + k1 / 2, 20 + l2 * 2, i3, 255 - l2 * 5);
        }
        if(k2 == 1)
        {
            int j3 = 0xff0000 + l2 * 5 * 256;
            dgm.cal(l + j1 / 2, i1 + k1 / 2, 10 + l2, j3, 255 - l2 * 5);
        }
    }

    private final void fdf()
    {
        if(dnd != 0)
        {
            for(int l = 0; l < djc; l++)
            {
                int j1 = dim + 2;
                int l1 = din + 27 + l * 15;
                if(super.fke <= j1 - 2 || super.fkf <= l1 - 12 || super.fkf >= l1 + 4 || super.fke >= (j1 - 3) + dja)
                    continue;
                fcc(elg[l]);
                break;
            }

            dnd = 0;
            ecc = false;
            return;
        }
        if(super.fke < dim - 10 || super.fkf < din - 10 || super.fke > dim + dja + 10 || super.fkf > din + djb + 10)
        {
            ecc = false;
            return;
        }
        dgm.cam(dim, din, dja, djb, 0xd0d0d0, 160);
        dgm.cdn("Choose option", dim + 2, din + 12, 1, 65535);
        for(int i1 = 0; i1 < djc; i1++)
        {
            int k1 = dim + 2;
            int i2 = din + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.fke > k1 - 2 && super.fkf > i2 - 12 && super.fkf < i2 + 4 && super.fke < (k1 - 3) + dja)
                j2 = 0xffff00;
            dgm.cdn(elh[elg[i1]] + " " + dkb[elg[i1]], k1, i2, 1, j2);
        }

    }

    public final URL getDocumentBase()
    {
        if(link.fni != null)
            return link.fni.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    private final void fdg(int l, int i1, int j1)
    {
        if(j1 == 0)
        {
            fbd(ekm, ekn, l, i1 - 1, l, i1, false, true);
            return;
        }
        if(j1 == 1)
        {
            fbd(ekm, ekn, l - 1, i1, l, i1, false, true);
            return;
        } else
        {
            fbd(ekm, ekn, l, i1, l, i1, true, true);
            return;
        }
    }

    public final Graphics getGraphics()
    {
        if(a.fig != null)
            return a.fig.getGraphics();
        if(link.fni != null)
            return link.fni.getGraphics();
        else
            return super.getGraphics();
    }

    protected final void fdh()
    {
        if(elb)
        {
            String s1 = getDocumentBase().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                dck = true;
                return;
            }
        }
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            dec[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = getParameter("referid");
            dhf = Integer.parseInt(s2);
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = getParameter("member");
            int i2 = Integer.parseInt(s3);
            if(i2 == 1)
                egg = true;
        }
        catch(Exception _ex) { }
        if(elb)
            super.aad = 43594;
        super.fik = 0;
        b.aab = 1000;
        b.aaa = w.cem;
        try
        {
            String s4 = getParameter("poff");
            int j2 = Integer.parseInt(s4);
            super.aad += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        fag();
        if(eha)
            return;
        eim = 2000;
        ein = eim + 100;
        eja = ein + 50;
        eje = eja + 1000;
        ejb = eje + 10;
        ejc = ejb + 50;
        ejd = ejc + 10;
        ecf = getGraphics();
        fle(50);
        dgm = new k(ddg, ddh + 12, 4000, this);
        dgm.dai = this;
        dgm.cah(0, 0, ddg, ddh + 12);
        h.gdh = false;
        h.gdi = ein;
        dmc = new h(dgm, 5);
        int k1 = ((j) (dgm)).blg - 199;
        byte byte0 = 36;
        dmd = dmc.gfk(k1, byte0 + 24, 196, 90, 1, 500, true);
        ehd = new h(dgm, 5);
        ehe = ehd.gfk(k1, byte0 + 40, 196, 126, 1, 500, true);
        eac = new h(dgm, 5);
        ead = eac.gfk(k1, byte0 + 24, 196, 251, 1, 500, true);
        fef();
        if(eha)
            return;
        fbg();
        if(eha)
            return;
        dhn = new n(dgm, 15000, 15000, 1000);
        dhn.bhk(ddg / 2, ddh / 2, ddg / 2, ddh / 2, ddg, ddi);
        dhn.bbg = 2400;
        dhn.bbh = 2400;
        dhn.bbi = 1;
        dhn.bbj = 2300;
        dhn.bjk(-50, -10, -50);
        eed = new x(dhn, dgm);
        eed.ghg = eim;
        fdk();
        if(eha)
            return;
        enl();
        if(eha)
            return;
        fce();
        if(eha)
            return;
        if(egg)
            fcl();
        if(eha)
        {
            return;
        } else
        {
            flj(100, "Starting game...");
            fcd();
            emn();
            eng();
            eml();
            flb();
            fal();
            return;
        }
    }

    protected final void fdi(Runnable runnable)
    {
        if(link.fni != null)
        {
            link.gah(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    private final boolean fdj(int arg0)
    {
        int l = ekl.gmh / 128;
        int i1 = ekl.gmi / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((eed.gil[l][i1 - j1] & 0x80) == 128 || (eed.gil[l - j1][i1] & 0x80) == 128 || (eed.gil[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((eed.gil[l][i1 + j1] & 0x80) == 128 || (eed.gil[l - j1][i1] & 0x80) == 128 || (eed.gil[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((eed.gil[l][i1 + j1] & 0x80) == 128 || (eed.gil[l + j1][i1] & 0x80) == 128 || (eed.gil[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((eed.gil[l][i1 - j1] & 0x80) == 128 || (eed.gil[l + j1][i1] & 0x80) == 128 || (eed.gil[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (eed.gil[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (eed.gil[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (eed.gil[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (eed.gil[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void fdk()
    {
        byte abyte0[] = fbk("textures" + w.cfd + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            eha = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        dhn.bje(e.ahj, 7, 11);
        for(int l = 0; l < e.ahj; l++)
        {
            String s1 = e.aib[l];
            byte abyte2[] = t.fng(s1 + ".dat", 0, abyte0);
            dgm.cbj(ejc, abyte2, abyte1, 1);
            dgm.cba(0, 0, 128, 128, 0xff00ff);
            dgm.ccb(0, 0, ejc);
            int i1 = ((j) (dgm)).bmj[ejc];
            String s2 = e.aic[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = t.fng(s2 + ".dat", 0, abyte0);
                dgm.cbj(ejc, abyte3, abyte1, 1);
                dgm.ccb(0, 0, ejc);
            }
            dgm.cca(ejd + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((j) (dgm)).bmc[ejd + l][k1] == 65280)
                    ((j) (dgm)).bmc[ejd + l][k1] = 0xff00ff;

            dgm.cbl(ejd + l);
            dhn.bjf(l, ((j) (dgm)).bmd[ejd + l], ((j) (dgm)).bme[ejd + l], i1 / 64 - 1);
        }

    }

    private final void fdl()
    {
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 && super.fkf < 35)
            egh = 1;
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 33 && super.fkf < 35)
        {
            egh = 2;
            ech = (int)(Math.random() * 13D) - 6;
            eci = (int)(Math.random() * 23D) - 11;
        }
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 66 && super.fkf < 35)
            egh = 3;
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 99 && super.fkf < 35)
            egh = 4;
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 132 && super.fkf < 35)
            egh = 5;
        if(egh == 0 && super.fke >= ((j) (dgm)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 165 && super.fkf < 35)
            egh = 6;
        if(egh != 0 && super.fke >= ((j) (dgm)).blg - 35 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 && super.fkf < 26)
            egh = 1;
        if(egh != 0 && egh != 2 && super.fke >= ((j) (dgm)).blg - 35 - 33 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 33 && super.fkf < 26)
        {
            egh = 2;
            ech = (int)(Math.random() * 13D) - 6;
            eci = (int)(Math.random() * 23D) - 11;
        }
        if(egh != 0 && super.fke >= ((j) (dgm)).blg - 35 - 66 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 66 && super.fkf < 26)
            egh = 3;
        if(egh != 0 && super.fke >= ((j) (dgm)).blg - 35 - 99 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 99 && super.fkf < 26)
            egh = 4;
        if(egh != 0 && super.fke >= ((j) (dgm)).blg - 35 - 132 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 132 && super.fkf < 26)
            egh = 5;
        if(egh != 0 && super.fke >= ((j) (dgm)).blg - 35 - 165 && super.fkf >= 3 && super.fke < ((j) (dgm)).blg - 3 - 165 && super.fkf < 26)
            egh = 6;
        if(egh == 1 && (super.fke < ((j) (dgm)).blg - 248 || super.fkf > 36 + (dfj / 5) * 34))
            egh = 0;
        if(egh == 3 && (super.fke < ((j) (dgm)).blg - 199 || super.fkf > 316))
            egh = 0;
        if((egh == 2 || egh == 4 || egh == 5) && (super.fke < ((j) (dgm)).blg - 199 || super.fkf > 240))
            egh = 0;
        if(egh == 6 && (super.fke < ((j) (dgm)).blg - 199 || super.fkf > 311))
            egh = 0;
    }

    protected final void adg(String s1)
    {
        if(s1.startsWith("@bor@"))
            {
                insertIntoMessageQue(new Message(Message.SERVER_MESSAGE,s1));
                feb(s1, 4);
                return;
        }
        if(s1.startsWith("@que@"))
            {
                insertIntoMessageQue(new Message(Message.SERVER_MESSAGE,s1));
                feb("@whi@" + s1, 5);
                return;
            }
        if(s1.startsWith("@pri@"))
            {

                feb(s1, 6);
                return;
            } else
                {
                    insertIntoMessageQue(new Message(Message.SERVER_MESSAGE,s1));
                    feb(s1, 3);
                    return;
                }
    }

    private final void fdm(boolean arg0)
    {
        int l = ((j) (dgm)).blg - 199;
        int i1 = 36;
        dgm.ccb(l - 49, 3, eim + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.cbh(160, 160, 160);
        if(eae == 0)
            j1 = j.cbh(220, 220, 220);
        else
            k1 = j.cbh(220, 220, 220);
        dgm.cam(l, i1, c1 / 2, 24, j1, 128);
        dgm.cam(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        dgm.cam(l, i1 + 24, c1, c2 - 24, j.cbh(220, 220, 220), 128);
        dgm.cbc(l, i1 + 24, c1, 0);
        dgm.cbd(l + c1 / 2, i1, 24, 0);
        dgm.cdl("Stats", l + c1 / 4, i1 + 16, 4, 0);
        dgm.cdl("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(eae == 0)
        {
            int l1 = 72;
            int j2 = -1;
            dgm.cdn("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.fke > l + 3 && super.fkf >= l1 - 11 && super.fkf < l1 + 2 && super.fke < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                dgm.cdn(dgb[k2] + ":@yel@" + dhc[k2] + "/" + eab[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.fke >= l + 90 && super.fkf >= l1 - 13 - 11 && super.fkf < (l1 - 13) + 2 && super.fke < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                dgm.cdn(dgb[k2 + 9] + ":@yel@" + dhc[k2 + 9] + "/" + eab[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            dgm.cdn("Quest Points:@yel@" + eme, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            dgm.cdn("Fatigue: @yel@" + (eem * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            dgm.cdn("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                dgm.cdn(ehk[i3] + ":@yel@" + dmb[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    dgm.cdn(ehk[i3 + 3] + ":@yel@" + dmb[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            dgm.cbc(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                dgm.cdn(dln[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = dec[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(dga[j2] >= dec[l3])
                        j3 = dec[l3 + 1];

                dgm.cdn("Total xp: " + dga[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                dgm.cdn("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
            } else
            {
                dgm.cdn("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += eab[i4];

                dgm.cdn("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                dgm.cdn("Combat level: " + ekl.gnm, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if(eae == 1)
        {
            eac.gfm(ead);
            eac.gga(ead, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                eac.gga(ead, i2 + 1, (dge[i2] ? "@gre@" : "@red@") + ehi[i2]);

            eac.ged();
        }
        if(!arg0)
            return;
        l = super.fke - (((j) (dgm)).blg - 199);
        i1 = super.fkf - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(eae == 1)
                eac.gea(l + (((j) (dgm)).blg - 199), i1 + 36, super.fkh, super.fkg);
            if(i1 <= 24 && dnd == 1)
            {
                if(l < 98)
                {
                    eae = 0;
                    return;
                }
                if(l > 98)
                    eae = 1;
            }
        }
    }

    private final void fdn()
    {
        ecl = 0;
        int l = 135;
        for(int i1 = 0; i1 < 12; i1++)
        {
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 12 && super.fkf < l + 3)
                ecl = i1 + 1;
            l += 14;
        }

        if(dnd != 0 && ecl != 0)
        {
            dnd = 0;
            eli = 2;
            super.fkl = "";
            super.fkm = "";
            return;
        }
        l += 15;
        if(dnd != 0)
        {
            dnd = 0;
            if(super.fke < 56 || super.fkf < 35 || super.fke > 456 || super.fkf > 325)
            {
                eli = 0;
                return;
            }
            if(super.fke > 66 && super.fke < 446 && super.fkf >= l - 15 && super.fkf < l + 5)
            {
                eli = 0;
                return;
            }
        }
        dgm.cba(56, 35, 400, 290, 0);
        dgm.cbb(56, 35, 400, 290, 0xffffff);
        l = 50;
        dgm.cdl("This form is for reporting players who are breaking our rules", 256, l, 1, 0xffffff);
        l += 15;
        dgm.cdl("Using it sends a snapshot of the last 60 secs of activity to us", 256, l, 1, 0xffffff);
        l += 15;
        dgm.cdl("If you misuse this form, you will be banned.", 256, l, 1, 0xff8000);
        l += 15;
        l += 10;
        dgm.cdl("First indicate which of our 12 rules is being broken. For a detailed", 256, l, 1, 0xffff00);
        l += 15;
        dgm.cdl("explanation of each rule please read the manual on our website.", 256, l, 1, 0xffff00);
        l += 15;
        int j1;
        if(ecl == 1)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("1: Offensive language", 256, l, 1, j1);
        l += 14;
        if(ecl == 2)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("2: Item scamming", 256, l, 1, j1);
        l += 14;
        if(ecl == 3)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("3: Password scamming", 256, l, 1, j1);
        l += 14;
        if(ecl == 4)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("4: Bug abuse", 256, l, 1, j1);
        l += 14;
        if(ecl == 5)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("5: Jagex Staff impersonation", 256, l, 1, j1);
        l += 14;
        if(ecl == 6)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("6: Account sharing/trading", 256, l, 1, j1);
        l += 14;
        if(ecl == 7)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("7: Macroing", 256, l, 1, j1);
        l += 14;
        if(ecl == 8)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("8: Mutiple logging in", 256, l, 1, j1);
        l += 14;
        if(ecl == 9)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("9: Encouraging others to break rules", 256, l, 1, j1);
        l += 14;
        if(ecl == 10)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("10: Misuse of customer support", 256, l, 1, j1);
        l += 14;
        if(ecl == 11)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("11: Advertising / website", 256, l, 1, j1);
        l += 14;
        if(ecl == 12)
        {
            dgm.cbb(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        dgm.cdl("12: Real world item trading", 256, l, 1, j1);
        l += 14;
        l += 15;
        j1 = 0xffffff;
        if(super.fke > 196 && super.fke < 316 && super.fkf > l - 15 && super.fkf < l + 5)
            j1 = 0xffff00;
        dgm.cdl("Click here to cancel", 256, l, 1, j1);
    }

    private final void fea()
    {
        if(dnd != 0)
        {
            dnd = 0;
            int l = super.fke - 52;
            int i1 = super.fkf - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && dhk[j1] != -1)
                        {
                            efj = j1;
                            efk = dhk[j1];
                        }
                        j1++;
                    }

                }

                if(efj >= 0)
                {
                    int i3 = dhk[efj];
                    if(i3 != -1)
                    {
                        if(dhl[efj] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = efg + dhm[efj];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * e.ahc[i3]) / 100;
                            super.aag.hda(157);
                            super.aag.hdk(dhk[efj]);
                            super.aag.hdb(l4);
                            super.aag.hdm();
                        }
                        if(enf(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = eff + dhm[efj];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * e.ahc[i3]) / 100;
                            super.aag.hda(211);
                            super.aag.hdk(dhk[efj]);
                            super.aag.hdb(i5);
                            super.aag.hdm();
                        }
                    }
                }
            } else
            {
                super.aag.hda(56);
                super.aag.hdm();
                dhb = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        dgm.cba(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        dgm.cam(byte0, byte1 + 12, 408, 17, k1, 160);
        dgm.cam(byte0, byte1 + 29, 8, 170, k1, 160);
        dgm.cam(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        dgm.cam(byte0, byte1 + 199, 408, 47, k1, 160);
        dgm.cdn("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.fke > byte0 + 320 && super.fkf >= byte1 && super.fke < byte0 + 408 && super.fkf < byte1 + 12)
            i2 = 0xff0000;
        dgm.cdk("Close window", byte0 + 406, byte1 + 10, 1, i2);
        dgm.cdn("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        dgm.cdn("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        dgm.cdn("Your money: " + enf(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(efj == j4)
                    dgm.cam(i6, l6, 49, 34, 0xff0000, 160);
                else
                    dgm.cam(i6, l6, 49, 34, j3, 160);
                dgm.cbb(i6, l6, 50, 35, 0);
                if(dhk[j4] != -1)
                {
                    dgm.cdd(i6, l6, 48, 32, eja + e.ahb[dhk[j4]], e.ahg[dhk[j4]], 0, 0, false);
                    dgm.cdn(String.valueOf(dhl[j4]), i6 + 1, l6 + 10, 1, 65280);
                    dgm.cdk(String.valueOf(enf(dhk[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        dgm.cbc(byte0 + 5, byte1 + 222, 398, 0);
        if(efj == -1)
        {
            dgm.cdl("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = dhk[efj];
        if(l5 != -1)
        {
            if(dhl[efj] > 0)
            {
                int j6 = efg + dhm[efj];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * e.ahc[l5]) / 100;
                dgm.cdn("Buy a new " + e.alb[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.fke > byte0 + 298 && super.fkf >= byte1 + 204 && super.fke < byte0 + 408 && super.fkf <= byte1 + 215)
                    j2 = 0xff0000;
                dgm.cdk("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                dgm.cdl("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(enf(l5) > 0)
            {
                int k6 = eff + dhm[efj];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * e.ahc[l5]) / 100;
                dgm.cdk("Sell your " + e.alb[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.fke > byte0 + 2 && super.fkf >= byte1 + 229 && super.fke < byte0 + 112 && super.fkf <= byte1 + 240)
                    k2 = 0xff0000;
                dgm.cdn("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            dgm.cdl("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    private final void feb(String arg0, int arg1)
    {
        if(arg1 == 2 || arg1 == 4 || arg1 == 6)
        {
            for(; arg0.length() > 5 && arg0.charAt(0) == '@' && arg0.charAt(4) == '@'; arg0 = arg0.substring(5));
            int l = arg0.indexOf(":");
            if(l != -1)
            {
                String s1 = arg0.substring(0, l);
                long l1 = t.fnc(s1);
                for(int j1 = 0; j1 < super.aan; j1++)
                    if(super.aba[j1] == l1)
                        return;

            }
        }
        if(arg1 == 2)
            arg0 = "@yel@" + arg0;
        if(arg1 == 3 || arg1 == 4)
            arg0 = "@whi@" + arg0;
        if(arg1 == 6)
            arg0 = "@cya@" + arg0;
        if(dkm != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                dli = 200;
            if(arg1 == 2 && dkm != 1)
                dlj = 200;
            if(arg1 == 5 && dkm != 2)
                dlk = 200;
            if(arg1 == 6 && dkm != 3)
                dll = 200;
            if(arg1 == 3 && dkm != 0)
                dkm = 0;
            if(arg1 == 6 && dkm != 3 && dkm != 0)
                dkm = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            dkg[i1] = dkg[i1 - 1];
            ehn[i1] = ehn[i1 - 1];
        }

        dkg[0] = arg0;
        ehn[0] = 300;
        if(arg1 == 2)
            if(dkh.gbc[dki] == dkh.gbd[dki] - 4)
                dkh.ggb(dki, arg0, true);
            else
                dkh.ggb(dki, arg0, false);
        if(arg1 == 5)
            if(dkh.gbc[dkk] == dkh.gbd[dkk] - 4)
                dkh.ggb(dkk, arg0, true);
            else
                dkh.ggb(dkk, arg0, false);
        if(arg1 == 6)
        {
            if(dkh.gbc[dkl] == dkh.gbd[dkl] - 4)
            {
                dkh.ggb(dkl, arg0, true);
                return;
            }
            dkh.ggb(dkl, arg0, false);
        }
    }

    protected final void fec()
    {
        aca();
        fbf();
        if(efh != null)
            efh.ggl();
    }

    protected final void ade()
    {
        dig = 0;
        feb("@cya@Sorry, you can't logout at the moment", 3);
    }

    final void fed(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = e.ahb[l1] + eja;
        int l2 = e.ahg[l1];
        dgm.cdd(l, i1, j1, k1, k2, l2, 0, 0, false);
    }

    private final void fee()
    {
        eag.gea(super.fke, super.fkf, super.fkh, super.fkg);
        if(eag.geb(dek))
            do
                edf = ((edf - 1) + e.amb) % e.amb;
            while((e.aje[edf] & 3) != 1 || (e.aje[edf] & 4 * edm) == 0);
        if(eag.geb(del))
            do
                edf = (edf + 1) % e.amb;
            while((e.aje[edf] & 3) != 1 || (e.aje[edf] & 4 * edm) == 0);
        if(eag.geb(dem))
            edi = ((edi - 1) + eef.length) % eef.length;
        if(eag.geb(den))
            edi = (edi + 1) % eef.length;
        if(eag.geb(dfa) || eag.geb(dfb))
        {
            for(edm = 3 - edm; (e.aje[edf] & 3) != 1 || (e.aje[edf] & 4 * edm) == 0; edf = (edf + 1) % e.amb);
            for(; (e.aje[edg] & 3) != 2 || (e.aje[edg] & 4 * edm) == 0; edg = (edg + 1) % e.amb);
        }
        if(eag.geb(dfc))
            edj = ((edj - 1) + eai.length) % eai.length;
        if(eag.geb(dfd))
            edj = (edj + 1) % eai.length;
        if(eag.geb(dfe))
            edl = ((edl - 1) + eaf.length) % eaf.length;
        if(eag.geb(dff))
            edl = (edl + 1) % eaf.length;
        if(eag.geb(dfg))
            edk = ((edk - 1) + eai.length) % eai.length;
        if(eag.geb(dfh))
            edk = (edk + 1) % eai.length;
        if(eag.geb(dfi))
        {
            super.aag.hda(16);
            super.aag.hea(edm);
            super.aag.hea(edf);
            super.aag.hea(edg);
            super.aag.hea(edh);
            super.aag.hea(edi);
            super.aag.hea(edj);
            super.aag.hea(edk);
            super.aag.hea(edl);
            super.aag.hdm();
            dgm.cak();
            ema = false;
        }
    }

    private final void fef()
    {
        byte abyte0[] = fbk("media" + w.cfb + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            eha = true;
            return;
        }
        byte abyte1[] = t.fng("index.dat", 0, abyte0);
        dgm.cbj(eim, t.fng("inv1.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 1, t.fng("inv2.dat", 0, abyte0), abyte1, 6);
        dgm.cbj(eim + 9, t.fng("bubble.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 10, t.fng("runescape.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 11, t.fng("splat.dat", 0, abyte0), abyte1, 3);
        dgm.cbj(eim + 14, t.fng("icon.dat", 0, abyte0), abyte1, 8);
        dgm.cbj(eim + 22, t.fng("hbar.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 23, t.fng("hbar2.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 24, t.fng("compass.dat", 0, abyte0), abyte1, 1);
        dgm.cbj(eim + 25, t.fng("buttons.dat", 0, abyte0), abyte1, 2);
        dgm.cbj(ein, t.fng("scrollbar.dat", 0, abyte0), abyte1, 2);
        dgm.cbj(ein + 2, t.fng("corners.dat", 0, abyte0), abyte1, 4);
        dgm.cbj(ein + 6, t.fng("arrows.dat", 0, abyte0), abyte1, 2);
        dgm.cbj(ejb, t.fng("projectile.dat", 0, abyte0), abyte1, e.ala);
        int l = e.aik;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            dgm.cbj(eja + (i1 - 1) * 30, t.fng("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }

        dgm.cbm(eim);
        dgm.cbm(eim + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            dgm.cbm(eim + k1);

        for(int l1 = 0; l1 < e.ala; l1++)
            dgm.cbm(ejb + l1);

        for(int i2 = 0; i2 < e.aik; i2++)
            dgm.cbm(eja + i2);

    }

    protected final void feg(int arg0, int arg1, int arg2)
    {
        eld[elc] = arg1;
        ele[elc] = arg2;
        elc = elc + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = elc - l & 0x1fff;
            if(eld[i1] == arg1 && ele[i1] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = elc - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(eld[l1] != arg1 || ele[l1] != arg2)
                        flag = true;
                    if(eld[k1] != eld[l1] || ele[k1] != ele[l1])
                        break;
                    if(j1 == l - 1 && flag && edd == 0 && dig == 0)
                    {
                        fae();
                        return;
                    }
                }

            }
        }

    }

    public mudclient()
    {
        dcg = new boolean[1500];
        dci = new int[8];
        dcj = new int[8];
        dck = false;
        dcm = false;
        dcn = false;
        ddd = false;
        dde = false;
        ddf = true;
        ddg = 512;
        ddh = 334;
        ddi = 9;
        ddj = new boolean[50];
        ddk = false;
        ddl = "";
        ddm = "";
        ddn = 550;
        dec = new int[99];
        ded = new int[50];
        dee = new int[50];
        def = new int[50];
        dei = new int[14];
        dej = new int[14];
        dfj = 30;
        dfl = new int[35];
        dfm = new int[35];
        dfn = new int[35];
        dga = new int[18];
        dge = new boolean[50];
        dgf = false;
        dgg = false;
        dgh = false;
        dgi = false;
        dgj = false;
        dgk = new int[50];
        dgl = new int[50];
        dhb = false;
        dhc = new int[18];
        dhd = 128;
        dhe = new int[50];
        dhi = "";
        dhj = "";
        dhk = new int[256];
        dhl = new int[256];
        dhm = new int[256];
        dia = new int[500];
        dib = new int[500];
        dif = false;
        dih = new int[500];
        dii = new int[500];
        djd = false;
        dje = new int[50];
        djf = new int[50];
        djg = new int[1500];
        djh = new int[1500];
        dji = new int[1500];
        djj = new int[1500];
        djk = -1;
        djl = "";
        djn = false;
        dka = new f[500];
        dkb = new String[250];
        dkc = new int[5000];
        dkd = new int[5000];
        dke = new int[5000];
        dkf = new int[5000];
        dkg = new String[5];
        dkn = new i[500];
        dld = -1;
        dlf = new int[8];
        dlg = new int[8];
        dlh = false;
        dlm = "";
        dmb = new int[5];
        dmf = false;
        dmg = false;
        dmh = new int[250];
        dmi = new int[250];
        dmj = new int[250];
        dmn = -1;
        dna = false;
        dnb = -1;
        dne = new i[1500];
        dnf = new int[500];
        dng = new int[256];
        dnh = new int[256];
        dnl = new String[50];
        dnm = new f[500];
        eaa = "";
        eab = new int[18];
        eah = new boolean[500];
        eak = -1;
        eal = -2;
        ean = new int[14];
        eba = new int[14];
        ebk = "";
        ebl = false;
        eca = false;
        ecb = false;
        ecc = false;
        ece = false;
        ecj = "";
        eck = "";
        ede = false;
        edg = 1;
        edh = 2;
        edi = 2;
        edj = 8;
        edk = 14;
        edm = 1;
        edn = false;
        eea = true;
        eeb = new int[50];
        eec = new int[250];
        eeh = new int[14];
        eei = new int[14];
        eek = false;
        eel = new f[4000];
        efc = 2;
        efd = 40;
        efj = -1;
        efk = -2;
        ega = false;
        egd = new int[8];
        ege = new int[8];
        egf = new String[5];
        egg = false;
        egi = 48;
        egj = false;
        egl = -1;
        egm = -1;
        egn = -1;
        eha = false;
        ehb = new f[500];
        ehm = new int[50];
        ehn = new int[5];
        eib = new int[250];
        eic = new int[250];
        eie = 1;
        eii = false;
        eij = false;
        eik = 128;
        ejf = new int[256];
        ejg = new int[256];
        ejh = new f[5000];
        ejk = new int[8];
        ejl = new int[8];
        ejm = new int[8000];
        ejn = new int[8000];
        ekb = new int[50];
        ekc = new int[50];
        ekd = new int[50];
        eke = new int[50];
        ekg = new int[14];
        ekh = new int[14];
        eki = new int[50];
        ekk = 2;
        ekl = new f();
        ela = -1;
        elb = true;
        eld = new int[8192];
        ele = new int[8192];
        elf = new f[500];
        elg = new int[250];
        elh = new String[250];
        ema = false;
        emc = new i[1000];
        emd = 0xbc614e;
    }

    public final int dbi = 250;
    public final int dbj = 5;
    public final int dbk = 50;
    public final int dbl = 18;
    public final int dbm = 500;
    public final int dbn = 1500;
    public final int dca = 5000;
    public final int dcb = 5000;
    public final int dcc = 500;
    public final int dcd = 4000;
    public final int dce = 500;
    public final int dcf = 8000;
    public boolean dcg[];
    public int dch;
    public int dci[];
    public int dcj[];
    public boolean dck;
    public h dcl;
    public boolean dcm;
    public boolean dcn;
    public int dda;
    int ddb;
    int ddc;
    public boolean ddd;
    public boolean dde;
    public boolean ddf;
    public int ddg;
    public int ddh;
    public int ddi;
    public boolean ddj[];
    public boolean ddk;
    public String ddl;
    public String ddm;
    public int ddn;
    public int dea[][] = {
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
    public int deb;
    public int dec[];
    public int ded[];
    public int dee[];
    public int def[];
    public int deg;
    public int deh;
    public int dei[];
    public int dej[];
    public int dek;
    public int del;
    public int dem;
    public int den;
    public int dfa;
    public int dfb;
    public int dfc;
    public int dfd;
    public int dfe;
    public int dff;
    public int dfg;
    public int dfh;
    public int dfi;
    public int dfj;
    public int dfk;
    public int dfl[];
    public int dfm[];
    public int dfn[];
    public int dga[];
    public final String dgb[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public int dgc;
    public int dgd;
    public boolean dge[];
    public boolean dgf;
    public boolean dgg;
    public boolean dgh;
    public boolean dgi;
    public boolean dgj;
    public int dgk[];
    public int dgl[];
    public k dgm;
    public int dgn;
    public int dha[] = {
        0, 1, 2, 1
    };
    public boolean dhb;
    public int dhc[];
    public int dhd;
    public int dhe[];
    public int dhf;
    public int dhg;
    public int dhh;
    public String dhi;
    public String dhj;
    public int dhk[];
    public int dhl[];
    public int dhm[];
    public n dhn;
    public int dia[];
    public int dib[];
    public int dic;
    public int did;
    public int die;
    public boolean dif;
    public int dig;
    public int dih[];
    public int dii[];
    public int dij;
    public int dik;
    public h dil;
    public int dim;
    public int din;
    public int dja;
    public int djb;
    public int djc;
    public boolean djd;
    public int dje[];
    public int djf[];
    public int djg[];
    public int djh[];
    public int dji[];
    public int djj[];
    public int djk;
    String djl;
    public int djm;
    public boolean djn;
    public f dka[];
    public String dkb[];
    public int dkc[];
    public int dkd[];
    public int dke[];
    public int dkf[];
    public String dkg[];
    public h dkh;
    int dki;
    int dkj;
    int dkk;
    int dkl;
    int dkm;
    public i dkn[];
    public int dla;
    public int dlb;
    public int dlc;
    public int dld;
    public int dle;
    public int dlf[];
    public int dlg[];
    public boolean dlh;
    public int dli;
    public int dlj;
    public int dlk;
    public int dll;
    public String dlm;
    public final String dln[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public int dma;
    public int dmb[];
    public h dmc;
    int dmd;
    int dme;
    public boolean dmf;
    public boolean dmg;
    public int dmh[];
    public int dmi[];
    public int dmj[];
    public int dmk;
    public int dml;
    public int dmm;
    public int dmn;
    public boolean dna;
    public int dnb;
    public int dnc;
    public int dnd;
    public i dne[];
    public int dnf[];
    public int dng[];
    public int dnh[];
    public int dni;
    public int dnj;
    public int dnk;
    String dnl[];
    public f dnm[];
    public int dnn;
    public String eaa;
    public int eab[];
    public h eac;
    int ead;
    int eae;
    public final int eaf[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public h eag;
    public boolean eah[];
    public final int eai[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int eaj;
    public int eak;
    public int eal;
    public int eam;
    public int ean[];
    public int eba[];
    public int ebb;
    public int ebc;
    public int ebd;
    public int ebe;
    public int ebf;
    public int ebg;
    public int ebh;
    public String ebi;
    public long ebj;
    public String ebk;
    public boolean ebl;
    public int ebm;
    public int ebn;
    public boolean eca;
    public boolean ecb;
    public boolean ecc;
    public int ecd;
    public boolean ece;
    public Graphics ecf;
    public h ecg;
    public int ech;
    public int eci;
    public String ecj;
    public String eck;
    public int ecl;
    public int ecm;
    public int ecn;
    public int eda;
    public int edb;
    public int edc;
    public int edd;
    public boolean ede;
    public int edf;
    public int edg;
    public int edh;
    public int edi;
    public int edj;
    public int edk;
    public int edl;
    public int edm;
    public boolean edn;
    public boolean eea;
    public int eeb[];
    public int eec[];
    public x eed;
    public int eee;
    public final int eef[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int eeg;
    public int eeh[];
    public int eei[];
    public int eej;
    public boolean eek;
    public f eel[];
    public int eem;
    public int een;
    public String efa;
    public int efb;
    public int efc;
    public int efd;
    public int efe;
    public int eff;
    public int efg;
    public d efh;
    public int efi;
    public int efj;
    public int efk;
    public int efl;
    public int efm;
    public long efn;
    public boolean ega;
    public int egb[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int egc;
    public int egd[];
    public int ege[];
    public String egf[];
    public boolean egg;
    public int egh;
    public int egi;
    public boolean egj;
    public int egk;
    public int egl;
    public int egm;
    public int egn;
    public boolean eha;
    public f ehb[];
    public int ehc;
    public h ehd;
    int ehe;
    int ehf;
    long ehg;
    public int ehh;
    public final String ehi[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public int ehj;
    public final String ehk[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public int ehl;
    public int ehm[];
    public int ehn[];
    public int eia;
    public int eib[];
    public int eic[];
    public int eid[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public int eie;
    public int eif;
    public int eig;
    public int eih;
    public boolean eii;
    public boolean eij;
    public int eik;
    public int eil;
    public int eim;
    public int ein;
    public int eja;
    public int ejb;
    public int ejc;
    public int ejd;
    public int eje;
    public int ejf[];
    public int ejg[];
    public f ejh[];
    public int eji;
    public int ejj;
    public int ejk[];
    public int ejl[];
    public int ejm[];
    public int ejn[];
    public int eka;
    public int ekb[];
    public int ekc[];
    public int ekd[];
    public int eke[];
    public int ekf;
    public int ekg[];
    public int ekh[];
    public int eki[];
    public int ekj;
    public int ekk;
    public f ekl;
    int ekm;
    int ekn;
    int ela;
    public boolean elb;
    public int elc;
    int eld[];
    int ele[];
    public f elf[];
    public int elg[];
    public String elh[];
    public int eli;
    public byte elj[];
    public int elk;
    public int ell;
    public int elm;
    public int eln;
    public boolean ema;
    public int emb;
    public i emc[];
    public int emd;
    public int eme;
    public final String emf[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}
