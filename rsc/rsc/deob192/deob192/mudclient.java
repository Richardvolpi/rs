// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:46:40 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public final class mudclient extends b
{

    public static final void main(String arg0[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.ccf = false;
        if(arg0.length > 0 && arg0[0].equals("members"))
            mudclient1.dek = true;
        if(arg0.length > 1)
            mudclient1.djn = arg0[1];
        if(arg0.length > 2)
            mudclient1.dka = Integer.parseInt(arg0[2]);
        mudclient1.ahm(mudclient1.cgn, mudclient1.cha + 11, "Runescape by Andrew Gower", false);
        mudclient1.ana = 10;
    }

    private final void bhf(String arg0, int arg1)
    {
        if(arg1 == 2 || arg1 == 4 || arg1 == 6)
        {
            for(; arg0.length() > 5 && arg0.charAt(0) == '@' && arg0.charAt(4) == '@'; arg0 = arg0.substring(5));
            int l = arg0.indexOf(":");
            if(l != -1)
            {
                String s1 = arg0.substring(0, l);
                long l1 = t.ang(s1);
                for(int j1 = 0; j1 < super.dkk; j1++)
                    if(super.dkl[j1] == l1)
                        return;

            }
        }
        if(arg1 == 2)
            arg0 = "@yel@" + arg0;
        if(arg1 == 3 || arg1 == 4)
            arg0 = "@whi@" + arg0;
        if(arg1 == 6)
            arg0 = "@cya@" + arg0;
        if(dcj != 0)
        {
            if(arg1 == 4 || arg1 == 3)
                dhh = 200;
            if(arg1 == 2 && dcj != 1)
                dhi = 200;
            if(arg1 == 5 && dcj != 2)
                dhj = 200;
            if(arg1 == 6 && dcj != 3)
                dhk = 200;
            if(arg1 == 3 && dcj != 0)
                dcj = 0;
            if(arg1 == 6 && dcj != 3 && dcj != 0)
                dcj = 0;
        }
        for(int i1 = 4; i1 > 0; i1--)
        {
            ckh[i1] = ckh[i1 - 1];
            cjg[i1] = cjg[i1 - 1];
        }

        ckh[0] = arg0;
        cjg[0] = 300;
        if(arg1 == 2)
            if(dce.aai[dcf] == dce.aaj[dcf] - 4)
                dce.acf(dcf, arg0, true);
            else
                dce.acf(dcf, arg0, false);
        if(arg1 == 5)
            if(dce.aai[dch] == dce.aaj[dch] - 4)
                dce.acf(dch, arg0, true);
            else
                dce.acf(dch, arg0, false);
        if(arg1 == 6)
        {
            if(dce.aai[dci] == dce.aaj[dci] - 4)
            {
                dce.acf(dci, arg0, true);
                return;
            }
            dce.acf(dci, arg0, false);
        }
    }

    private final void bhg()
    {
        cdg = 0;
        cnm = 0;
        dea = "";
        deb = "";
        chm = "Please enter a username:";
        chn = "*" + dea + "*";
        cmf = 0;
        cae = 0;
    }

    private static final String bhh(int arg0)
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

    private final void bhi()
    {
        bmf.egk = bil("maps" + w.bif + ".jag", "map", 70);
        if(dek)
            bmf.eib = bil("maps" + w.bif + ".mem", "members map", 75);
        bmf.egj = bil("land" + w.bif + ".jag", "landscape", 80);
        if(dek)
            bmf.eia = bil("land" + w.bif + ".mem", "members landscape", 85);
    }

    private final void bhj()
    {
        int l = 97;
        cgm.ban(86, 77, 340, 180, 0);
        cgm.bba(86, 77, 340, 180, 0xffffff);
        cgm.bdk("Warning! Proceed with caution", 256, l, 4, 0xff0000);
        l += 26;
        cgm.bdk("If you go much further north you will enter the", 256, l, 1, 0xffffff);
        l += 13;
        cgm.bdk("wilderness. This a very dangerous area where", 256, l, 1, 0xffffff);
        l += 13;
        cgm.bdk("other players can attack you!", 256, l, 1, 0xffffff);
        l += 22;
        cgm.bdk("The further north you go the more dangerous it", 256, l, 1, 0xffffff);
        l += 13;
        cgm.bdk("becomes, but the more treasure you will find.", 256, l, 1, 0xffffff);
        l += 22;
        cgm.bdk("In the wilderness an indicator at the bottom-right", 256, l, 1, 0xffffff);
        l += 13;
        cgm.bdk("of the screen will show the current level of danger", 256, l, 1, 0xffffff);
        l += 22;
        int i1 = 0xffffff;
        if(super.anc > l - 12 && super.anc <= l && super.anb > 181 && super.anb < 331)
            i1 = 0xff0000;
        cgm.bdk("Click here to close window", 256, l, 1, i1);
        if(cgl != 0)
        {
            if(super.anc > l - 12 && super.anc <= l && super.anb > 181 && super.anb < 331)
                cmm = 2;
            if(super.anb < 86 || super.anb > 426 || super.anc < 77 || super.anc > 257)
                cmm = 2;
            cgl = 0;
        }
    }

    final void bhk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        int l = e.ejh[arg4] + cka;
        int i1 = e.ejm[arg4];
        cgm.bdc(arg0, arg1, arg2, arg3, l, i1, 0, 0, false);
    }

    private final void bhl()
    {
        dgc = new h(cgm, 50);
        int l = 40;
        if(!dek)
        {
            dgc.abh(256, 200 + l, "Click on an option", 5, true);
            dgc.abi(156, 240 + l, 120, 35);
            dgc.abi(356, 240 + l, 120, 35);
            dgc.abh(156, 240 + l, "New User", 5, false);
            dgc.abh(356, 240 + l, "Existing User", 5, false);
            cfh = dgc.acb(156, 240 + l, 120, 35);
            cfi = dgc.acb(356, 240 + l, 120, 35);
        } else
        {
            dgc.abh(256, 200 + l, "Welcome to RuneScape", 4, true);
            dgc.abh(256, 215 + l, "You need a member account to use this server", 4, true);
            dgc.abi(256, 250 + l, 200, 35);
            dgc.abh(256, 250 + l, "Click here to login", 5, false);
            cfi = dgc.acb(256, 250 + l, 200, 35);
        }
        ckk = new h(cgm, 50);
        l = 230;
        if(ckm == 0)
        {
            ckk.abh(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            ckk.abh(256, l + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(ckm == 1)
        {
            ckk.abh(256, l + 8, "To create an account please click on the", 4, true);
            l += 20;
            ckk.abh(256, l + 8, "'create account' link below the game window", 4, true);
        } else
        {
            ckk.abh(256, l + 8, "To create an account please go back to the", 4, true);
            l += 20;
            ckk.abh(256, l + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
        l += 30;
        ckk.abi(256, l + 17, 150, 34);
        ckk.abh(256, l + 17, "Ok", 5, false);
        cla = ckk.acb(256, l + 17, 150, 34);
        bng = new h(cgm, 50);
        l = 230;
        clh = bng.abh(256, l - 10, "Please enter your username and password", 4, true);
        l += 28;
        bng.abi(140, l, 200, 40);
        bng.abh(140, l - 10, "Username:", 4, false);
        cli = bng.abn(140, l + 10, 200, 40, 4, 12, false, false);
        l += 47;
        bng.abi(190, l, 200, 40);
        bng.abh(190, l - 10, "Password:", 4, false);
        clj = bng.abn(190, l + 10, 200, 40, 4, 20, true, false);
        l -= 55;
        bng.abi(410, l, 120, 25);
        bng.abh(410, l, "Ok", 4, false);
        clk = bng.acb(410, l, 120, 25);
        l += 30;
        bng.abi(410, l, 120, 25);
        bng.abh(410, l, "Cancel", 4, false);
        cll = bng.acb(410, l, 120, 25);
        l += 30;
        bng.ack(cli);
    }

    public final Image bhm(int arg0, int arg1)
    {
        if(a.ald != null)
            return a.ald.createImage(arg0, arg1);
        if(link.dhm != null)
            return link.dhm.createImage(arg0, arg1);
        else
            return super.ajl(arg0, arg1);
    }

    private final void bhn()
    {
        byte abyte0[] = bil("media" + w.big + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            dff = true;
            return;
        }
        byte abyte1[] = t.ank("index.dat", 0, abyte0);
        cgm.bbi(cjm, t.ank("inv1.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 1, t.ank("inv2.dat", 0, abyte0), abyte1, 6);
        cgm.bbi(cjm + 9, t.ank("bubble.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 10, t.ank("runescape.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 11, t.ank("splat.dat", 0, abyte0), abyte1, 3);
        cgm.bbi(cjm + 14, t.ank("icon.dat", 0, abyte0), abyte1, 8);
        cgm.bbi(cjm + 22, t.ank("hbar.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 23, t.ank("hbar2.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 24, t.ank("compass.dat", 0, abyte0), abyte1, 1);
        cgm.bbi(cjm + 25, t.ank("buttons.dat", 0, abyte0), abyte1, 2);
        cgm.bbi(cjn, t.ank("scrollbar.dat", 0, abyte0), abyte1, 2);
        cgm.bbi(cjn + 2, t.ank("corners.dat", 0, abyte0), abyte1, 4);
        cgm.bbi(cjn + 6, t.ank("arrows.dat", 0, abyte0), abyte1, 2);
        cgm.bbi(ckb, t.ank("projectile.dat", 0, abyte0), abyte1, e.ejg);
        int l = e.enb;
        for(int i1 = 1; l > 0; i1++)
        {
            int j1 = l;
            l -= 30;
            if(j1 > 30)
                j1 = 30;
            cgm.bbi(cka + (i1 - 1) * 30, t.ank("objects" + i1 + ".dat", 0, abyte0), abyte1, j1);
        }

        cgm.bbl(cjm);
        cgm.bbl(cjm + 9);
        for(int k1 = 11; k1 <= 26; k1++)
            cgm.bbl(cjm + k1);

        for(int l1 = 0; l1 < e.ejg; l1++)
            cgm.bbl(ckb + l1);

        for(int i2 = 0; i2 < e.enb; i2++)
            cgm.bbl(cka + i2);

    }

    private final String bia(int arg0)
    {
        if(link.dhm != null)
            return link.cak(t.anf(arg0));
        else
            return t.anf(arg0);
    }

    private final void bib()
    {
        char c1 = '\u0190';
        char c2 = 'd';
        if(clc)
        {
            c2 = '\u01C2';
            c2 = '\u012C';
        }
        cgm.ban(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0);
        cgm.bba(256 - c1 / 2, 167 - c2 / 2, c1, c2, 0xffffff);
        cgm.bdl(cck, 256, (167 - c2 / 2) + 20, 1, 0xffffff, c1 - 40);
        int l = 157 + c2 / 2;
        int i1 = 0xffffff;
        if(super.anc > l - 12 && super.anc <= l && super.anb > 106 && super.anb < 406)
            i1 = 0xff0000;
        cgm.bdk("Click here to close window", 256, l, 1, i1);
        if(cgl == 1)
        {
            if(i1 == 0xff0000)
                daf = false;
            if((super.anb < 256 - c1 / 2 || super.anb > 256 + c1 / 2) && (super.anc < 167 - c2 / 2 || super.anc > 167 + c2 / 2))
                daf = false;
        }
        cgl = 0;
    }

    private final void bic()
    {
        cci = cbd;
        for(int l = 0; l < cbd; l++)
        {
            def[l] = cfb[l];
            deg[l] = cfc[l];
        }

        for(int i1 = 0; i1 < chg; i1++)
        {
            if(cci >= cnc)
                break;
            int j1 = chh[i1];
            boolean flag = false;
            for(int k1 = 0; k1 < cci; k1++)
            {
                if(def[k1] != j1)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                def[cci] = j1;
                deg[cci] = 0;
                cci++;
            }
        }

    }

    private final f bid(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(ddc[arg0] == null)
        {
            ddc[arg0] = new f();
            ddc[arg0].dmc = arg0;
        }
        f f1 = ddc[arg0];
        boolean flag = false;
        for(int l = 0; l < caf; l++)
        {
            if(cff[l].dmc != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.dmg = arg4;
            f1.dmj = arg3;
            int i1 = f1.dml;
            if(arg1 != f1.dmm[i1] || arg2 != f1.dmn[i1])
            {
                f1.dml = i1 = (i1 + 1) % 10;
                f1.dmm[i1] = arg1;
                f1.dmn[i1] = arg2;
            }
        } else
        {
            f1.dmc = arg0;
            f1.dmk = 0;
            f1.dml = 0;
            f1.dmm[0] = f1.dme = arg1;
            f1.dmn[0] = f1.dmf = arg2;
            f1.dmg = arg4;
            f1.dmj = f1.dmi = arg3;
            f1.dmh = 0;
        }
        cnf[cae++] = f1;
        return f1;
    }

    private final void bie(int arg0, int arg1, int arg2)
    {
        if(arg2 == 0)
        {
            bjj(ccm, ccn, arg0, arg1 - 1, arg0, arg1, false, true);
            return;
        }
        if(arg2 == 1)
        {
            bjj(ccm, ccn, arg0 - 1, arg1, arg0, arg1, false, true);
            return;
        } else
        {
            bjj(ccm, ccn, arg0, arg1, arg0, arg1, true, true);
            return;
        }
    }

    private final void bif()
    {
        if((cdk & 1) == 1 && caa(cdk))
            return;
        if((cdk & 1) == 0 && caa(cdk))
        {
            if(caa(cdk + 1 & 7))
            {
                cdk = cdk + 1 & 7;
                return;
            }
            if(caa(cdk + 7 & 7))
                cdk = cdk + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int l = 0; l < 7; l++)
        {
            if(!caa(cdk + ai[l] + 8 & 7))
                continue;
            cdk = cdk + ai[l] + 8 & 7;
            break;
        }

        if((cdk & 1) == 0 && caa(cdk))
        {
            if(caa(cdk + 1 & 7))
            {
                cdk = cdk + 1 & 7;
                return;
            }
            if(caa(cdk + 7 & 7))
                cdk = cdk + 7 & 7;
        }
    }

    protected final void ccn()
    {
        cij = 0;
        bhf("@cya@Sorry, you can't logout at the moment", 3);
    }

    private final void bih()
    {
        if(bmb > 1)
            bmb--;
        cbm();
        if(cij > 0)
            cij--;
        if(super.ali > 4500 && cfm == 0 && cij == 0)
        {
            super.ali -= 500;
            bkk();
            return;
        }
        if(ccl.dmi == 8 || ccl.dmi == 9)
            cfm = 500;
        if(cfm > 0)
            cfm--;
        if(cbj)
        {
            bjb();
            return;
        }
        for(int l = 0; l < cmf; l++)
        {
            f f1 = bln[l];
            int j1 = (f1.dml + 1) % 10;
            if(f1.dmk != j1)
            {
                int l1 = -1;
                int k3 = f1.dmk;
                int i5;
                if(k3 < j1)
                    i5 = j1 - k3;
                else
                    i5 = (10 + j1) - k3;
                int i6 = 4;
                if(i5 > 2)
                    i6 = (i5 - 1) * 4;
                if(f1.dmm[k3] - f1.dme > cdf * 3 || f1.dmn[k3] - f1.dmf > cdf * 3 || f1.dmm[k3] - f1.dme < -cdf * 3 || f1.dmn[k3] - f1.dmf < -cdf * 3 || i5 > 8)
                {
                    f1.dme = f1.dmm[k3];
                    f1.dmf = f1.dmn[k3];
                } else
                {
                    if(f1.dme < f1.dmm[k3])
                    {
                        f1.dme += i6;
                        f1.dmh++;
                        l1 = 2;
                    } else
                    if(f1.dme > f1.dmm[k3])
                    {
                        f1.dme -= i6;
                        f1.dmh++;
                        l1 = 6;
                    }
                    if(f1.dme - f1.dmm[k3] < i6 && f1.dme - f1.dmm[k3] > -i6)
                        f1.dme = f1.dmm[k3];
                    if(f1.dmf < f1.dmn[k3])
                    {
                        f1.dmf += i6;
                        f1.dmh++;
                        if(l1 == -1)
                            l1 = 4;
                        else
                        if(l1 == 2)
                            l1 = 3;
                        else
                            l1 = 5;
                    } else
                    if(f1.dmf > f1.dmn[k3])
                    {
                        f1.dmf -= i6;
                        f1.dmh++;
                        if(l1 == -1)
                            l1 = 0;
                        else
                        if(l1 == 2)
                            l1 = 1;
                        else
                            l1 = 7;
                    }
                    if(f1.dmf - f1.dmn[k3] < i6 && f1.dmf - f1.dmn[k3] > -i6)
                        f1.dmf = f1.dmn[k3];
                }
                if(l1 != -1)
                    f1.dmi = l1;
                if(f1.dme == f1.dmm[k3] && f1.dmf == f1.dmn[k3])
                    f1.dmk = (k3 + 1) % 10;
            } else
            {
                f1.dmi = f1.dmj;
            }
            if(f1.dnc > 0)
                f1.dnc--;
            if(f1.dne > 0)
                f1.dne--;
            if(f1.dni > 0)
                f1.dni--;
            if(cih > 0)
            {
                cih--;
                if(cih == 0)
                    bhf("You have been granted another life. Be more careful this time!", 3);
                if(cih == 0)
                    bhf("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int i1 = 0; i1 < cae; i1++)
        {
            f f2 = cnf[i1];
            int i2 = (f2.dml + 1) % 10;
            if(f2.dmk != i2)
            {
                int l3 = -1;
                int j5 = f2.dmk;
                int j6;
                if(j5 < i2)
                    j6 = i2 - j5;
                else
                    j6 = (10 + i2) - j5;
                int k6 = 4;
                if(j6 > 2)
                    k6 = (j6 - 1) * 4;
                if(f2.dmm[j5] - f2.dme > cdf * 3 || f2.dmn[j5] - f2.dmf > cdf * 3 || f2.dmm[j5] - f2.dme < -cdf * 3 || f2.dmn[j5] - f2.dmf < -cdf * 3 || j6 > 8)
                {
                    f2.dme = f2.dmm[j5];
                    f2.dmf = f2.dmn[j5];
                } else
                {
                    if(f2.dme < f2.dmm[j5])
                    {
                        f2.dme += k6;
                        f2.dmh++;
                        l3 = 2;
                    } else
                    if(f2.dme > f2.dmm[j5])
                    {
                        f2.dme -= k6;
                        f2.dmh++;
                        l3 = 6;
                    }
                    if(f2.dme - f2.dmm[j5] < k6 && f2.dme - f2.dmm[j5] > -k6)
                        f2.dme = f2.dmm[j5];
                    if(f2.dmf < f2.dmn[j5])
                    {
                        f2.dmf += k6;
                        f2.dmh++;
                        if(l3 == -1)
                            l3 = 4;
                        else
                        if(l3 == 2)
                            l3 = 3;
                        else
                            l3 = 5;
                    } else
                    if(f2.dmf > f2.dmn[j5])
                    {
                        f2.dmf -= k6;
                        f2.dmh++;
                        if(l3 == -1)
                            l3 = 0;
                        else
                        if(l3 == 2)
                            l3 = 1;
                        else
                            l3 = 7;
                    }
                    if(f2.dmf - f2.dmn[j5] < k6 && f2.dmf - f2.dmn[j5] > -k6)
                        f2.dmf = f2.dmn[j5];
                }
                if(l3 != -1)
                    f2.dmi = l3;
                if(f2.dme == f2.dmm[j5] && f2.dmf == f2.dmn[j5])
                    f2.dmk = (j5 + 1) % 10;
            } else
            {
                f2.dmi = f2.dmj;
                if(f2.dmg == 43)
                    f2.dmh++;
            }
            if(f2.dnc > 0)
                f2.dnc--;
            if(f2.dne > 0)
                f2.dne--;
            if(f2.dni > 0)
                f2.dni--;
        }

        if(cam != 2)
        {
            if(j.bdg > 0)
                bma++;
            if(j.bdh > 0)
                bma = 0;
            j.bdg = 0;
            j.bdh = 0;
        }
        for(int k1 = 0; k1 < cmf; k1++)
        {
            f f3 = bln[k1];
            if(f3.ead > 0)
                f3.ead--;
        }

        if(cji)
        {
            if(cbn - ccl.dme < -500 || cbn - ccl.dme > 500 || cca - ccl.dmf < -500 || cca - ccl.dmf > 500)
            {
                cbn = ccl.dme;
                cca = ccl.dmf;
            }
        } else
        {
            if(cbn - ccl.dme < -500 || cbn - ccl.dme > 500 || cca - ccl.dmf < -500 || cca - ccl.dmf > 500)
            {
                cbn = ccl.dme;
                cca = ccl.dmf;
            }
            if(cbn != ccl.dme)
                cbn += (ccl.dme - cbn) / (16 + (dba - 500) / 15);
            if(cca != ccl.dmf)
                cca += (ccl.dmf - cca) / (16 + (dba - 500) / 15);
            if(ceh)
            {
                int j2 = cdk * 32;
                int i4 = j2 - cii;
                byte byte0 = 1;
                if(i4 != 0)
                {
                    cdl++;
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
                    cii += ((cdl * i4 + 255) / 256) * byte0;
                    cii &= 0xff;
                } else
                {
                    cdl = 0;
                }
            }
        }
        if(bma > 20)
        {
            cml = false;
            bma = 0;
        }
        if(ddb)
        {
            if(super.anj.length() > 0)
                if(super.anj.equalsIgnoreCase("::lostcon") && !ccf)
                    super.dkd.bfi();
                else
                if(super.anj.equalsIgnoreCase("::closecon") && !ccf)
                {
                    cbj();
                } else
                {
                    super.dkd.bgl(226);
                    super.dkd.bgc(super.anj);
                    if(!cml)
                    {
                        super.dkd.bfj(0);
                        cml = true;
                    }
                    super.dkd.bgm();
                    super.ani = "";
                    super.anj = "";
                    cdc = "Please wait...";
                }
            if(super.ane == 1 && super.anc > 275 && super.anc < 310 && super.anb > 56 && super.anb < 456)
            {
                super.dkd.bgl(226);
                super.dkd.bgc("-null-");
                if(!cml)
                {
                    super.dkd.bfj(0);
                    cml = true;
                }
                super.dkd.bgm();
                super.ani = "";
                super.anj = "";
                cdc = "Please wait...";
            }
            super.ane = 0;
            return;
        }
        if(super.anc > cha - 4)
        {
            if(super.anb > 15 && super.anb < 96 && super.ane == 1)
                dcj = 0;
            if(super.anb > 110 && super.anb < 194 && super.ane == 1)
            {
                dcj = 1;
                dce.aai[dcf] = 0xf423f;
            }
            if(super.anb > 215 && super.anb < 295 && super.ane == 1)
            {
                dcj = 2;
                dce.aai[dch] = 0xf423f;
            }
            if(super.anb > 315 && super.anb < 395 && super.ane == 1)
            {
                dcj = 3;
                dce.aai[dci] = 0xf423f;
            }
            if(super.anb > 417 && super.anb < 497 && super.ane == 1)
            {
                cei = 1;
                bne = 0;
                super.ani = "";
                super.anj = "";
            }
            super.ane = 0;
            super.and = 0;
        }
        dce.aae(super.anb, super.anc, super.ane, super.and);
        if(dcj > 0 && super.anb >= 494 && super.anc >= cha - 66)
            super.ane = 0;
        if(dce.aaf(dcg))
        {
            String s1 = dce.ach(dcg);
            dce.acg(dcg, "");
            if(s1.startsWith("::"))
            {
                if(s1.equalsIgnoreCase("::closecon") && !ccf)
                    super.dkd.bfi();
                else
                if(s1.equalsIgnoreCase("::logout") && !ccf)
                    cbj();
                else
                if(s1.equalsIgnoreCase("::lostcon") && !ccf)
                    cbk();
                else
                    cci(s1.substring(2));
            } else
            {
                int j4 = v.aeh(s1);
                cch(v.aeh, j4);
                s1 = v.aeg(v.aeh, 0, j4);
                s1 = u.akl(s1);
                ccl.dnc = 150;
                ccl.dnb = s1;
                bhf(ccl.dmb + ": " + s1, 2);
            }
        }
        if(dcj == 0)
        {
            for(int k2 = 0; k2 < 5; k2++)
                if(cjg[k2] > 0)
                    cjg[k2]--;

        }
        if(cih != 0)
            super.ane = 0;
        if(chl || dad)
        {
            if(super.and != 0)
                ded++;
            else
                ded = 0;
            if(ded > 600)
                dee += 5000;
            else
            if(ded > 450)
                dee += 500;
            else
            if(ded > 300)
                dee += 50;
            else
            if(ded > 150)
                dee += 5;
            else
            if(ded > 50)
                dee++;
            else
            if(ded > 20 && (ded & 5) == 0)
                dee++;
        } else
        {
            ded = 0;
            dee = 0;
        }
        if(super.ane == 1)
            cgl = 1;
        else
        if(super.ane == 2)
            cgl = 2;
        cch.ced(super.anb, super.anc);
        super.ane = 0;
        if(ceh)
        {
            if(cdl == 0 || cji)
            {
                if(super.ami)
                {
                    cdk = cdk + 1 & 7;
                    super.ami = false;
                    if(!cld)
                    {
                        if((cdk & 1) == 0)
                            cdk = cdk + 1 & 7;
                        for(int l2 = 0; l2 < 8; l2++)
                        {
                            if(caa(cdk))
                                break;
                            cdk = cdk + 1 & 7;
                        }

                    }
                }
                if(super.amj)
                {
                    cdk = cdk + 7 & 7;
                    super.amj = false;
                    if(!cld)
                    {
                        if((cdk & 1) == 0)
                            cdk = cdk + 7 & 7;
                        for(int i3 = 0; i3 < 8; i3++)
                        {
                            if(caa(cdk))
                                break;
                            cdk = cdk + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.ami)
            cii = cii + 2 & 0xff;
        else
        if(super.amj)
            cii = cii - 2 & 0xff;
        if(cld && dba > 550)
            dba -= 4;
        else
        if(!cld && dba < 750)
            dba += 4;
        if(daa > 0)
            daa--;
        else
        if(daa < 0)
            daa++;
        cch.cgf(17);
        cag++;
        if(cag > 5)
        {
            cag = 0;
            ccb = (ccb + 1) % 3;
            ccc = (ccc + 1) % 4;
            ccd = (ccd + 1) % 5;
        }
        for(int j3 = 0; j3 < cfa; j3++)
        {
            int k4 = dgf[j3];
            int k5 = dgg[j3];
            if(k4 >= 0 && k5 >= 0 && k4 < 96 && k5 < 96 && dgh[j3] == 74)
                cec[j3].agb(1, 0, 0);
        }

        for(int l4 = 0; l4 < cad; l4++)
        {
            cge[l4]++;
            if(cge[l4] > 50)
            {
                cad--;
                for(int l5 = l4; l5 < cad; l5++)
                {
                    ddi[l5] = ddi[l5 + 1];
                    cgd[l5] = cgd[l5 + 1];
                    cge[l5] = cge[l5 + 1];
                    cfl[l5] = cfl[l5 + 1];
                }

            }
        }

    }

    public final URL bii()
    {
      try 
	{ 
	return new URL("http://www.runescape.com"); 
	} 
        catch(Exception e) {return null;} 
    }

    private final void bij()
    {
        super.ank = "";
        super.anl = "";
    }

    private final void bik()
    {
        if(cij != 0)
            bnb();
        else
        if(dcl)
            blj();
        else
        if(daf)
            bib();
        else
        if(cmm == 1)
            bhj();
        else
        if(blm && cfm == 0)
            bjm();
        else
        if(dha && cfm == 0)
            bjf();
        else
        if(cjj)
            bkd();
        else
        if(chl)
            bjl();
        else
        if(dem)
            bnn();
        else
        if(dad)
            bki();
        else
        if(cei == 1)
            bmm();
        else
        if(cei == 2)
            cab();
        else
        if(caj != 0)
        {
            ble();
        } else
        {
            if(clb)
                bkf();
            if(ccl.dmi == 8 || ccl.dmi == 9)
                blh();
            bkj();
            boolean flag = !clb && !cmd;
            if(flag)
                bna = 0;
            if(cam == 0 && flag)
                bnj();
            if(cam == 1)
                blb(flag);
            if(cam == 2)
                bli(flag);
            if(cam == 3)
                bnl(flag);
            if(cam == 4)
                blg(flag);
            if(cam == 5)
                bnd(flag);
            if(cam == 6)
                bnm(flag);
            if(!cmd && !clb)
                bkm();
            if(cmd && !clb)
                bkg();
        }
        cgl = 0;
    }

    protected final byte[] bil(String arg0, String arg1, int arg2)
    {
        if(!ccf)
            arg0 = "./Data/" + arg0;
        byte abyte0[] = link.cah(arg0);
        if(abyte0 != null)
        {
            int l = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int i1 = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int j1 = 0; j1 < abyte0.length - 6; j1++)
                abyte1[j1] = abyte0[j1 + 6];

            ajg(arg2, "Unpacking " + arg1);
            if(i1 != l)
            {
                byte abyte2[] = new byte[l];
                g.cba(abyte2, l, abyte1, i1, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.ajj(arg0, arg1, arg2);
        }
    }

    protected final int cdd()
    {
        return link.dhn;
    }

    private final void bin()
    {
        dce = new h(cgm, 10);
        dcf = dce.abl(5, 269, 502, 56, 1, 20, true);
        dcg = dce.abm(7, 324, 498, 14, 1, 80, false, true);
        dch = dce.abl(5, 269, 502, 56, 1, 20, true);
        dci = dce.abl(5, 269, 502, 56, 1, 20, true);
        dce.ack(dcg);
    }

    final void bja(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = cnf[arg4];
        int l = f1.dmi + (cii + 16) / 32 & 7;
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
        int j1 = i1 * 3 + dca[(f1.dmh / e.ekb[f1.dmg]) % 4];
        if(f1.dmi == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (e.ekd[f1.dmg] * arg6) / 100;
            j1 = i1 * 3 + ckj[(cmn / (e.ekc[f1.dmg] - 1)) % 8];
        } else
        if(f1.dmi == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (e.ekd[f1.dmg] * arg6) / 100;
            j1 = i1 * 3 + ceb[(cmn / e.ekc[f1.dmg]) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = cai[l][k1];
            int k2 = e.ekg[f1.dmg][l1];
            if(k2 >= 0)
            {
                int i3 = 0;
                int j3 = 0;
                int k3 = j1;
                if(flag && i1 >= 1 && i1 <= 3 && e.ema[k2] == 1)
                    k3 += 15;
                if(i1 != 5 || e.eln[k2] == 1)
                {
                    int l3 = k3 + e.emb[k2];
                    i3 = (i3 * arg2) / ((j) (cgm)).bcc[l3];
                    j3 = (j3 * arg3) / ((j) (cgm)).bcd[l3];
                    int i4 = (arg2 * ((j) (cgm)).bcc[l3]) / ((j) (cgm)).bcc[e.emb[k2]];
                    i3 -= (i4 - arg2) / 2;
                    int j4 = e.ell[k2];
                    int k4 = 0;
                    if(j4 == 1)
                    {
                        j4 = e.emh[f1.dmg];
                        k4 = e.emk[f1.dmg];
                    } else
                    if(j4 == 2)
                    {
                        j4 = e.emi[f1.dmg];
                        k4 = e.emk[f1.dmg];
                    } else
                    if(j4 == 3)
                    {
                        j4 = e.emj[f1.dmg];
                        k4 = e.emk[f1.dmg];
                    }
                    cgm.bdc(arg0 + i3, arg1 + j3, i4, arg3, l3, j4, k4, arg5, flag);
                }
            }
        }

        if(f1.dnc > 0)
        {
            dga[cna] = cgm.bee(f1.dnb, 1) / 2;
            if(dga[cna] > 150)
                dga[cna] = 150;
            dgb[cna] = (cgm.bee(f1.dnb, 1) / 300) * cgm.bec(1);
            dfm[cna] = arg0 + arg2 / 2;
            dfn[cna] = arg1;
            cnb[cna++] = f1.dnb;
        }
        if(f1.dmi == 8 || f1.dmi == 9 || f1.dni != 0)
        {
            if(f1.dni > 0)
            {
                int i2 = arg0;
                if(f1.dmi == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.dmi == 9)
                    i2 += (20 * arg6) / 100;
                int l2 = (f1.dng * 30) / f1.dnh;
                ddj[dck] = i2 + arg2 / 2;
                ddk[dck] = arg1;
                ddl[dck++] = l2;
            }
            if(f1.dni > 150)
            {
                int j2 = arg0;
                if(f1.dmi == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.dmi == 9)
                    j2 += (10 * arg6) / 100;
                cgm.bca((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, cjm + 12);
                cgm.bdk(String.valueOf(f1.dnf), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
    }

    private final void bjb()
    {
        dfg.aae(super.anb, super.anc, super.ane, super.and);
        if(dfg.aaf(dbb))
            do
                cik = ((cik - 1) + e.ekh) % e.ekh;
            while((e.elm[cik] & 3) != 1 || (e.elm[cik] & 4 * cjd) == 0);
        if(dfg.aaf(dbc))
            do
                cik = (cik + 1) % e.ekh;
            while((e.elm[cik] & 3) != 1 || (e.elm[cik] & 4 * cjd) == 0);
        if(dfg.aaf(dbd))
            cin = ((cin - 1) + ddh.length) % ddh.length;
        if(dfg.aaf(dbe))
            cin = (cin + 1) % ddh.length;
        if(dfg.aaf(dbf) || dfg.aaf(dbg))
        {
            for(cjd = 3 - cjd; (e.elm[cik] & 3) != 1 || (e.elm[cik] & 4 * cjd) == 0; cik = (cik + 1) % e.ekh);
            for(; (e.elm[cil] & 3) != 2 || (e.elm[cil] & 4 * cjd) == 0; cil = (cil + 1) % e.ekh);
        }
        if(dfg.aaf(dbh))
            cja = ((cja - 1) + dfl.length) % dfl.length;
        if(dfg.aaf(dbi))
            cja = (cja + 1) % dfl.length;
        if(dfg.aaf(dbj))
            cjc = ((cjc - 1) + dai.length) % dai.length;
        if(dfg.aaf(dbk))
            cjc = (cjc + 1) % dai.length;
        if(dfg.aaf(dbl))
            cjb = ((cjb - 1) + dfl.length) % dfl.length;
        if(dfg.aaf(dbm))
            cjb = (cjb + 1) % dfl.length;
        if(dfg.aaf(dbn))
        {
            super.dkd.bgl(94);
            super.dkd.bfj(cjd);
            super.dkd.bfj(cik);
            super.dkd.bfj(cil);
            super.dkd.bfj(cim);
            super.dkd.bfj(cin);
            super.dkd.bfj(cja);
            super.dkd.bfj(cjb);
            super.dkd.bfj(cjc);
            super.dkd.bgm();
            cgm.baj();
            cbj = false;
        }
    }

    private final void bjc(int arg0, int arg1, int arg2, int arg3, boolean arg4)
    {
        bjj(arg0, arg1, arg2, arg3, arg2, arg3, false, arg4);
    }

    final void bjd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        f f1 = bln[arg4];
        if(f1.dnm == 255)
            return;
        int l = f1.dmi + (cii + 16) / 32 & 7;
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
        int j1 = i1 * 3 + dca[(f1.dmh / 6) % 4];
        if(f1.dmi == 8)
        {
            i1 = 5;
            l = 2;
            flag = false;
            arg0 -= (5 * arg6) / 100;
            j1 = i1 * 3 + ckj[(cmn / 5) % 8];
        } else
        if(f1.dmi == 9)
        {
            i1 = 5;
            l = 2;
            flag = true;
            arg0 += (5 * arg6) / 100;
            j1 = i1 * 3 + ceb[(cmn / 6) % 8];
        }
        for(int k1 = 0; k1 < 12; k1++)
        {
            int l1 = cai[l][k1];
            int l2 = f1.dna[l1] - 1;
            if(l2 >= 0)
            {
                int k3 = 0;
                int i4 = 0;
                int j4 = j1;
                if(flag && i1 >= 1 && i1 <= 3)
                    if(e.ema[l2] == 1)
                        j4 += 15;
                    else
                    if(l1 == 4 && i1 == 1)
                    {
                        k3 = -22;
                        i4 = -3;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = -8;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    } else
                    if(l1 == 4 && i1 == 3)
                    {
                        k3 = 26;
                        i4 = -5;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 1)
                    {
                        k3 = 22;
                        i4 = 3;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 2)
                    {
                        k3 = 0;
                        i4 = 8;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    } else
                    if(l1 == 3 && i1 == 3)
                    {
                        k3 = -26;
                        i4 = 5;
                        j4 = i1 * 3 + dca[(2 + f1.dmh / 6) % 4];
                    }
                if(i1 != 5 || e.eln[l2] == 1)
                {
                    int k4 = j4 + e.emb[l2];
                    k3 = (k3 * arg2) / ((j) (cgm)).bcc[k4];
                    i4 = (i4 * arg3) / ((j) (cgm)).bcd[k4];
                    int l4 = (arg2 * ((j) (cgm)).bcc[k4]) / ((j) (cgm)).bcc[e.emb[l2]];
                    k3 -= (l4 - arg2) / 2;
                    int i5 = e.ell[l2];
                    int j5 = dai[f1.dnn];
                    if(i5 == 1)
                        i5 = ddh[f1.dnk];
                    else
                    if(i5 == 2)
                        i5 = dfl[f1.dnl];
                    else
                    if(i5 == 3)
                        i5 = dfl[f1.dnm];
                    cgm.bdc(arg0 + k3, arg1 + i4, l4, arg3, k4, i5, j5, arg5, flag);
                }
            }
        }

        if(f1.dnc > 0)
        {
            dga[cna] = cgm.bee(f1.dnb, 1) / 2;
            if(dga[cna] > 150)
                dga[cna] = 150;
            dgb[cna] = (cgm.bee(f1.dnb, 1) / 300) * cgm.bec(1);
            dfm[cna] = arg0 + arg2 / 2;
            dfn[cna] = arg1;
            cnb[cna++] = f1.dnb;
        }
        if(f1.dne > 0)
        {
            cgf[cfn] = arg0 + arg2 / 2;
            cgg[cfn] = arg1;
            cek[cfn] = arg6;
            cel[cfn++] = f1.dnd;
        }
        if(f1.dmi == 8 || f1.dmi == 9 || f1.dni != 0)
        {
            if(f1.dni > 0)
            {
                int i2 = arg0;
                if(f1.dmi == 8)
                    i2 -= (20 * arg6) / 100;
                else
                if(f1.dmi == 9)
                    i2 += (20 * arg6) / 100;
                int i3 = (f1.dng * 30) / f1.dnh;
                ddj[dck] = i2 + arg2 / 2;
                ddk[dck] = arg1;
                ddl[dck++] = i3;
            }
            if(f1.dni > 150)
            {
                int j2 = arg0;
                if(f1.dmi == 8)
                    j2 -= (10 * arg6) / 100;
                else
                if(f1.dmi == 9)
                    j2 += (10 * arg6) / 100;
                cgm.bca((j2 + arg2 / 2) - 12, (arg1 + arg3 / 2) - 12, cjm + 11);
                cgm.bdk(String.valueOf(f1.dnf), (j2 + arg2 / 2) - 1, arg1 + arg3 / 2 + 5, 3, 0xffffff);
            }
        }
        if(f1.eag == 1 && f1.dne == 0)
        {
            int k2 = arg5 + arg0 + arg2 / 2;
            if(f1.dmi == 8)
                k2 -= (20 * arg6) / 100;
            else
            if(f1.dmi == 9)
                k2 += (20 * arg6) / 100;
            int j3 = (16 * arg6) / 100;
            int l3 = (16 * arg6) / 100;
            cgm.bcb(k2 - j3 / 2, arg1 - l3 / 2 - (10 * arg6) / 100, j3, l3, cjm + 13);
        }
    }

    protected final void ccm()
    {
        bmb = 0;
        cnm = 0;
        cdg = 0;
        cij = 0;
    }

    private final void bjf()
    {
        if(cgl != 0)
        {
            cgl = 0;
            int l = super.anb - 52;
            int i1 = super.anc - 44;
            if(l >= 0 && i1 >= 12 && l < 408 && i1 < 246)
            {
                int j1 = 0;
                for(int l1 = 0; l1 < 5; l1++)
                {
                    for(int l2 = 0; l2 < 8; l2++)
                    {
                        int k3 = 7 + l2 * 49;
                        int k4 = 28 + l1 * 34;
                        if(l > k3 && l < k3 + 49 && i1 > k4 && i1 < k4 + 34 && bnj[j1] != -1)
                        {
                            cef = j1;
                            ceg = bnj[j1];
                        }
                        j1++;
                    }

                }

                if(cef >= 0)
                {
                    int i3 = bnj[cef];
                    if(i3 != -1)
                    {
                        if(bnk[cef] > 0 && l > 298 && i1 >= 204 && l < 408 && i1 <= 215)
                        {
                            int l3 = cmb + bnl[cef];
                            if(l3 < 10)
                                l3 = 10;
                            int l4 = (l3 * e.eji[i3]) / 100;
                            super.dkd.bgl(77);
                            super.dkd.bfn(bnj[cef]);
                            super.dkd.bgb(l4);
                            super.dkd.bgm();
                        }
                        if(bmc(i3) > 0 && l > 2 && i1 >= 229 && l < 112 && i1 <= 240)
                        {
                            int i4 = cma + bnl[cef];
                            if(i4 < 10)
                                i4 = 10;
                            int i5 = (i4 * e.eji[i3]) / 100;
                            super.dkd.bgl(237);
                            super.dkd.bfn(bnj[cef]);
                            super.dkd.bgb(i5);
                            super.dkd.bgm();
                        }
                    }
                }
            } else
            {
                super.dkd.bgl(24);
                super.dkd.bgm();
                dha = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        cgm.ban(byte0, byte1, 408, 12, 192);
        int k1 = 0x989898;
        cgm.bal(byte0, byte1 + 12, 408, 17, k1, 160);
        cgm.bal(byte0, byte1 + 29, 8, 170, k1, 160);
        cgm.bal(byte0 + 399, byte1 + 29, 9, 170, k1, 160);
        cgm.bal(byte0, byte1 + 199, 408, 47, k1, 160);
        cgm.bdm("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int i2 = 0xffffff;
        if(super.anb > byte0 + 320 && super.anc >= byte1 && super.anb < byte0 + 408 && super.anc < byte1 + 12)
            i2 = 0xff0000;
        cgm.bdj("Close window", byte0 + 406, byte1 + 10, 1, i2);
        cgm.bdm("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        cgm.bdm("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        cgm.bdm("Your money: " + bmc(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int j3 = 0xd0d0d0;
        int j4 = 0;
        for(int j5 = 0; j5 < 5; j5++)
        {
            for(int k5 = 0; k5 < 8; k5++)
            {
                int i6 = byte0 + 7 + k5 * 49;
                int l6 = byte1 + 28 + j5 * 34;
                if(cef == j4)
                    cgm.bal(i6, l6, 49, 34, 0xff0000, 160);
                else
                    cgm.bal(i6, l6, 49, 34, j3, 160);
                cgm.bba(i6, l6, 50, 35, 0);
                if(bnj[j4] != -1)
                {
                    cgm.bdc(i6, l6, 48, 32, cka + e.ejh[bnj[j4]], e.ejm[bnj[j4]], 0, 0, false);
                    cgm.bdm(String.valueOf(bnk[j4]), i6 + 1, l6 + 10, 1, 65280);
                    cgm.bdj(String.valueOf(bmc(bnj[j4])), i6 + 47, l6 + 10, 1, 65535);
                }
                j4++;
            }

        }

        cgm.bbb(byte0 + 5, byte1 + 222, 398, 0);
        if(cef == -1)
        {
            cgm.bdk("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int l5 = bnj[cef];
        if(l5 != -1)
        {
            if(bnk[cef] > 0)
            {
                int j6 = cmb + bnl[cef];
                if(j6 < 10)
                    j6 = 10;
                int i7 = (j6 * e.eji[l5]) / 100;
                cgm.bdm("Buy a new " + e.ekj[l5] + " for " + i7 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int j2 = 0xffffff;
                if(super.anb > byte0 + 298 && super.anc >= byte1 + 204 && super.anb < byte0 + 408 && super.anc <= byte1 + 215)
                    j2 = 0xff0000;
                cgm.bdj("Click here to buy", byte0 + 405, byte1 + 214, 3, j2);
            } else
            {
                cgm.bdk("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(bmc(l5) > 0)
            {
                int k6 = cma + bnl[cef];
                if(k6 < 10)
                    k6 = 10;
                int j7 = (k6 * e.eji[l5]) / 100;
                cgm.bdj("Sell your " + e.ekj[l5] + " for " + j7 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int k2 = 0xffffff;
                if(super.anb > byte0 + 2 && super.anc >= byte1 + 229 && super.anb < byte0 + 112 && super.anc <= byte1 + 240)
                    k2 = 0xff0000;
                cgm.bdm("Click here to sell", byte0 + 2, byte1 + 239, 3, k2);
                return;
            }
            cgm.bdk("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    protected final void bjg(Runnable arg0)
    {
        if(link.dhm != null)
        {
            link.caj(arg0);
            return;
        } else
        {
            Thread thread = new Thread(arg0);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void bjh()
    {
        cbj();
        blk();
        if(cne != null)
            cne.bfb();
    }

    private final void bji(int arg0)
    {
        int l = cfj[arg0];
        int i1 = cfk[arg0];
        int j1 = dfa[arg0];
        int k1 = dfb[arg0];
        int l1 = dfc[arg0];
        int i2 = bmg[arg0];
        if(i2 == 200)
        {
            bng(ccm, ccn, l, i1, true);
            super.dkd.bgl(115);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 210)
        {
            bng(ccm, ccn, l, i1, true);
            super.dkd.bgl(171);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 220)
        {
            bng(ccm, ccn, l, i1, true);
            super.dkd.bgl(205);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
        }
        if(i2 == 3200)
            bhf(e.ekk[j1], 3);
        if(i2 == 300)
        {
            bie(l, i1, j1);
            super.dkd.bgl(188);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfj(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 310)
        {
            bie(l, i1, j1);
            super.dkd.bgl(130);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfj(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 320)
        {
            bie(l, i1, j1);
            super.dkd.bgl(214);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfj(j1);
            super.dkd.bgm();
        }
        if(i2 == 2300)
        {
            bie(l, i1, j1);
            super.dkd.bgl(59);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfj(j1);
            super.dkd.bgm();
        }
        if(i2 == 3300)
            bhf(e.eng[j1], 3);
        if(i2 == 400)
        {
            bmb(l, i1, j1, k1);
            super.dkd.bgl(101);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(l1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 410)
        {
            bmb(l, i1, j1, k1);
            super.dkd.bgl(166);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(l1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 420)
        {
            bmb(l, i1, j1, k1);
            super.dkd.bgl(12);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bgm();
        }
        if(i2 == 2400)
        {
            bmb(l, i1, j1, k1);
            super.dkd.bgl(219);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bgm();
        }
        if(i2 == 3400)
            bhf(e.faj[j1], 3);
        if(i2 == 600)
        {
            super.dkd.bgl(252);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 610)
        {
            super.dkd.bgl(209);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 620)
        {
            super.dkd.bgl(64);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 630)
        {
            super.dkd.bgl(72);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 640)
        {
            super.dkd.bgl(20);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 650)
        {
            bmi = j1;
            cam = 0;
            bmj = e.ekj[chh[bmi]];
        }
        if(i2 == 660)
        {
            super.dkd.bgl(146);
            super.dkd.bfn(j1);
            super.dkd.bgm();
            bmi = -1;
            cam = 0;
            bhf("Dropping " + e.ekj[chh[j1]], 4);
        }
        if(i2 == 3600)
            bhf(e.ekk[j1], 3);
        if(i2 == 700)
        {
            int j2 = (l - 64) / cdf;
            int j4 = (i1 - 64) / cdf;
            bjc(ccm, ccn, j2, j4, true);
            super.dkd.bgl(29);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 710)
        {
            int k2 = (l - 64) / cdf;
            int k4 = (i1 - 64) / cdf;
            bjc(ccm, ccn, k2, k4, true);
            super.dkd.bgl(227);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 720)
        {
            int l2 = (l - 64) / cdf;
            int l4 = (i1 - 64) / cdf;
            bjc(ccm, ccn, l2, l4, true);
            super.dkd.bgl(102);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 725)
        {
            int i3 = (l - 64) / cdf;
            int i5 = (i1 - 64) / cdf;
            bjc(ccm, ccn, i3, i5, true);
            super.dkd.bgl(68);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 715 || i2 == 2715)
        {
            int j3 = (l - 64) / cdf;
            int j5 = (i1 - 64) / cdf;
            bjc(ccm, ccn, j3, j5, true);
            super.dkd.bgl(114);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 3700)
            bhf(e.eik[j1], 3);
        if(i2 == 800)
        {
            int k3 = (l - 64) / cdf;
            int k5 = (i1 - 64) / cdf;
            bjc(ccm, ccn, k3, k5, true);
            super.dkd.bgl(47);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 810)
        {
            int l3 = (l - 64) / cdf;
            int l5 = (i1 - 64) / cdf;
            bjc(ccm, ccn, l3, l5, true);
            super.dkd.bgl(86);
            super.dkd.bfn(j1);
            super.dkd.bfn(k1);
            super.dkd.bgm();
            bmi = -1;
        }
        if(i2 == 805 || i2 == 2805)
        {
            int i4 = (l - 64) / cdf;
            int i6 = (i1 - 64) / cdf;
            bjc(ccm, ccn, i4, i6, true);
            super.dkd.bgl(187);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 2806)
        {
            super.dkd.bgl(158);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 2810)
        {
            super.dkd.bgl(5);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 2820)
        {
            super.dkd.bgl(142);
            super.dkd.bfn(j1);
            super.dkd.bgm();
        }
        if(i2 == 900)
        {
            bjc(ccm, ccn, l, i1, true);
            super.dkd.bgl(123);
            super.dkd.bfn(l + cle);
            super.dkd.bfn(i1 + clf);
            super.dkd.bfn(j1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 920)
        {
            bjc(ccm, ccn, l, i1, false);
            if(daa == -24)
                daa = 24;
        }
        if(i2 == 1000)
        {
            super.dkd.bgl(180);
            super.dkd.bfn(j1);
            super.dkd.bgm();
            cdb = -1;
        }
        if(i2 == 4000)
        {
            bmi = -1;
            cdb = -1;
        }
    }

    private final boolean bjj(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = bmf.cjd(arg0, arg1, arg2, arg3, arg4, arg5, ced, cee, arg6);
        if(l == -1)
            if(arg7)
            {
                l = 1;
                ced[0] = arg2;
                cee[0] = arg3;
            } else
            {
                return false;
            }
        l--;
        arg0 = ced[l];
        arg1 = cee[l];
        l--;
        if(arg7)
            super.dkd.bgl(216);
        else
            super.dkd.bgl(154);
        super.dkd.bfn(arg0 + cle);
        super.dkd.bfn(arg1 + clf);
        if(arg7 && l == -1 && (arg0 + cle) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.dkd.bfj(ced[i1] - arg0);
            super.dkd.bfj(cee[i1] - arg1);
        }

        super.dkd.bgm();
        daa = -24;
        dab = super.anb;
        dac = super.anc;
        return true;
    }

    private final boolean bjk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        int l = bmf.cjd(arg0, arg1, arg2, arg3, arg4, arg5, ced, cee, arg6);
        if(l == -1)
            return false;
        l--;
        arg0 = ced[l];
        arg1 = cee[l];
        l--;
        if(arg7)
            super.dkd.bgl(216);
        else
            super.dkd.bgl(154);
        super.dkd.bfn(arg0 + cle);
        super.dkd.bfn(arg1 + clf);
        if(arg7 && l == -1 && (arg0 + cle) % 5 == 0)
            l = 0;
        for(int i1 = l; i1 >= 0 && i1 > l - 25; i1--)
        {
            super.dkd.bfj(ced[i1] - arg0);
            super.dkd.bfj(cee[i1] - arg1);
        }

        super.dkd.bgm();
        daa = -24;
        dab = super.anb;
        dac = super.anc;
        return true;
    }

    private final void bjl()
    {
        if(cgl != 0 && dee == 0)
            dee = 1;
        if(dee > 0)
        {
            int l = super.anb - 22;
            int i1 = super.anc - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < chg)
                    {
                        boolean flag = false;
                        int k2 = 0;
                        int j3 = chh[j1];
                        for(int j4 = 0; j4 < cmi; j4++)
                            if(cmj[j4] == j3)
                                if(e.ejj[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < dee; l4++)
                                    {
                                        if(cmk[j4] < chi[j1])
                                            cmk[j4]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(bmc(j3) <= k2)
                            flag = true;
                        if(e.ejn[j3] == 1)
                        {
                            bhf("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && cmi < 12)
                        {
                            cmj[cmi] = j3;
                            cmk[cmi] = 1;
                            cmi++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.dkd.bgl(138);
                            super.dkd.bfj(cmi);
                            for(int i5 = 0; i5 < cmi; i5++)
                            {
                                super.dkd.bfn(cmj[i5]);
                                super.dkd.bgb(cmk[i5]);
                            }

                            super.dkd.bgm();
                            bnb = false;
                            bnc = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 133)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < cmi)
                    {
                        int i2 = cmj[k1];
                        for(int l2 = 0; l2 < dee; l2++)
                        {
                            if(e.ejj[i2] == 0 && cmk[k1] > 1)
                            {
                                cmk[k1]--;
                                continue;
                            }
                            cmi--;
                            ded = 0;
                            for(int k3 = k1; k3 < cmi; k3++)
                            {
                                cmj[k3] = cmj[k3 + 1];
                                cmk[k3] = cmk[k3 + 1];
                            }

                            break;
                        }

                        super.dkd.bgl(138);
                        super.dkd.bfj(cmi);
                        for(int l3 = 0; l3 < cmi; l3++)
                        {
                            super.dkd.bfn(cmj[l3]);
                            super.dkd.bgb(cmk[l3]);
                        }

                        super.dkd.bgm();
                        bnb = false;
                        bnc = false;
                    }
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    bnc = true;
                    super.dkd.bgl(229);
                    super.dkd.bgm();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    chl = false;
                    super.dkd.bgl(124);
                    super.dkd.bgm();
                }
            } else
            if(cgl != 0)
            {
                chl = false;
                super.dkd.bgl(124);
                super.dkd.bgm();
            }
            cgl = 0;
            dee = 0;
        }
        if(!chl)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        cgm.ban(byte0, byte1, 468, 12, 192);
        int l1 = 0x989898;
        cgm.bal(byte0, byte1 + 12, 468, 18, l1, 160);
        cgm.bal(byte0, byte1 + 30, 8, 248, l1, 160);
        cgm.bal(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        cgm.bal(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        cgm.bal(byte0 + 8, byte1 + 133, 197, 22, l1, 160);
        cgm.bal(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        cgm.bal(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        cgm.bal(byte0 + 8, byte1 + 30, 197, 103, j2, 160);
        cgm.bal(byte0 + 8, byte1 + 155, 197, 103, j2, 160);
        cgm.bal(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 4; i3++)
            cgm.bbb(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 4; i4++)
            cgm.bbb(byte0 + 8, byte1 + 155 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            cgm.bbb(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                cgm.bbc(byte0 + 8 + j5 * 49, byte1 + 30, 103, 0);
            if(j5 < 5)
                cgm.bbc(byte0 + 8 + j5 * 49, byte1 + 155, 103, 0);
            cgm.bbc(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        cgm.bdm("Trading with: " + del, byte0 + 1, byte1 + 10, 1, 0xffffff);
        cgm.bdm("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        cgm.bdm("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        cgm.bdm("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!bnc)
            cgm.bca(byte0 + 217, byte1 + 238, cjm + 25);
        cgm.bca(byte0 + 394, byte1 + 238, cjm + 26);
        if(bnb)
        {
            cgm.bdk("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            cgm.bdk("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(bnc)
        {
            cgm.bdk("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            cgm.bdk("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < chg; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            cgm.bdc(l5, j6, 48, 32, cka + e.ejh[chh[k5]], e.ejm[chh[k5]], 0, 0, false);
            if(e.ejj[chh[k5]] == 0)
                cgm.bdm(String.valueOf(chi[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < cmi; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            cgm.bdc(k6, i7, 48, 32, cka + e.ejh[cmj[i6]], e.ejm[cmj[i6]], 0, 0, false);
            if(e.ejj[cmj[i6]] == 0)
                cgm.bdm(String.valueOf(cmk[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.anb > k6 && super.anb < k6 + 48 && super.anc > i7 && super.anc < i7 + 32)
                cgm.bdm(e.ekj[cmj[i6]] + ": @whi@" + e.ekk[cmj[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < cba; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 156 + byte1 + (l6 / 4) * 34;
            cgm.bdc(j7, k7, 48, 32, cka + e.ejh[cbb[l6]], e.ejm[cbb[l6]], 0, 0, false);
            if(e.ejj[cbb[l6]] == 0)
                cgm.bdm(String.valueOf(cbc[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.anb > j7 && super.anb < j7 + 48 && super.anc > k7 && super.anc < k7 + 32)
                cgm.bdm(e.ekj[cbb[l6]] + ": @whi@" + e.ekk[cbb[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void bjm()
    {
        char c1 = '\u0198';
        char c2 = '\u014E';
        if(dge > 0 && cci <= 48)
            dge = 0;
        if(dge > 1 && cci <= 96)
            dge = 1;
        if(dge > 2 && cci <= 144)
            dge = 2;
        if(bnm >= cci || bnm < 0)
            bnm = -1;
        if(bnm != -1 && def[bnm] != bnn)
        {
            bnm = -1;
            bnn = -2;
        }
        if(cgl != 0)
        {
            cgl = 0;
            int l = super.anb - (256 - c1 / 2);
            int j1 = super.anc - (170 - c2 / 2);
            if(l >= 0 && j1 >= 12 && l < 408 && j1 < 280)
            {
                int l1 = dge * 48;
                for(int k2 = 0; k2 < 6; k2++)
                {
                    for(int i3 = 0; i3 < 8; i3++)
                    {
                        int k7 = 7 + i3 * 49;
                        int i8 = 28 + k2 * 34;
                        if(l > k7 && l < k7 + 49 && j1 > i8 && j1 < i8 + 34 && l1 < cci && def[l1] != -1)
                        {
                            bnn = def[l1];
                            bnm = l1;
                        }
                        l1++;
                    }

                }

                l = 256 - c1 / 2;
                j1 = 170 - c2 / 2;
                int j3;
                if(bnm < 0)
                    j3 = -1;
                else
                    j3 = def[bnm];
                if(j3 != -1)
                {
                    int i2 = deg[bnm];
                    if(e.ejj[j3] == 1 && i2 > 1)
                        i2 = 1;
                    if(i2 >= 1 && super.anb >= l + 220 && super.anc >= j1 + 238 && super.anb < l + 250 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(1);
                        super.dkd.bgm();
                    }
                    if(i2 >= 5 && super.anb >= l + 250 && super.anc >= j1 + 238 && super.anb < l + 280 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(5);
                        super.dkd.bgm();
                    }
                    if(i2 >= 25 && super.anb >= l + 280 && super.anc >= j1 + 238 && super.anb < l + 305 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(25);
                        super.dkd.bgm();
                    }
                    if(i2 >= 100 && super.anb >= l + 305 && super.anc >= j1 + 238 && super.anb < l + 335 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(100);
                        super.dkd.bgm();
                    }
                    if(i2 >= 500 && super.anb >= l + 335 && super.anc >= j1 + 238 && super.anb < l + 368 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(500);
                        super.dkd.bgm();
                    }
                    if(i2 >= 2500 && super.anb >= l + 370 && super.anc >= j1 + 238 && super.anb < l + 400 && super.anc <= j1 + 249)
                    {
                        super.dkd.bgl(19);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(2500);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 1 && super.anb >= l + 220 && super.anc >= j1 + 263 && super.anb < l + 250 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(1);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 5 && super.anb >= l + 250 && super.anc >= j1 + 263 && super.anb < l + 280 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(5);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 25 && super.anb >= l + 280 && super.anc >= j1 + 263 && super.anb < l + 305 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(25);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 100 && super.anb >= l + 305 && super.anc >= j1 + 263 && super.anb < l + 335 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(100);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 500 && super.anb >= l + 335 && super.anc >= j1 + 263 && super.anb < l + 368 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(500);
                        super.dkd.bgm();
                    }
                    if(bmc(j3) >= 2500 && super.anb >= l + 370 && super.anc >= j1 + 263 && super.anb < l + 400 && super.anc <= j1 + 274)
                    {
                        super.dkd.bgl(251);
                        super.dkd.bfn(j3);
                        super.dkd.bfn(2500);
                        super.dkd.bgm();
                    }
                }
            } else
            if(cci > 48 && l >= 50 && l <= 115 && j1 <= 12)
                dge = 0;
            else
            if(cci > 48 && l >= 115 && l <= 180 && j1 <= 12)
                dge = 1;
            else
            if(cci > 96 && l >= 180 && l <= 245 && j1 <= 12)
                dge = 2;
            else
            if(cci > 144 && l >= 245 && l <= 310 && j1 <= 12)
            {
                dge = 3;
            } else
            {
                super.dkd.bgl(113);
                super.dkd.bgm();
                blm = false;
                return;
            }
        }
        int i1 = 256 - c1 / 2;
        int k1 = 170 - c2 / 2;
        cgm.ban(i1, k1, 408, 12, 192);
        int j2 = 0x989898;
        cgm.bal(i1, k1 + 12, 408, 17, j2, 160);
        cgm.bal(i1, k1 + 29, 8, 204, j2, 160);
        cgm.bal(i1 + 399, k1 + 29, 9, 204, j2, 160);
        cgm.bal(i1, k1 + 233, 408, 47, j2, 160);
        cgm.bdm("Bank", i1 + 1, k1 + 10, 1, 0xffffff);
        int l2 = 50;
        if(cci > 48)
        {
            int k3 = 0xffffff;
            if(dge == 0)
                k3 = 0xff0000;
            else
            if(super.anb > i1 + l2 && super.anc >= k1 && super.anb < i1 + l2 + 65 && super.anc < k1 + 12)
                k3 = 0xffff00;
            cgm.bdm("<page 1>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
            k3 = 0xffffff;
            if(dge == 1)
                k3 = 0xff0000;
            else
            if(super.anb > i1 + l2 && super.anc >= k1 && super.anb < i1 + l2 + 65 && super.anc < k1 + 12)
                k3 = 0xffff00;
            cgm.bdm("<page 2>", i1 + l2, k1 + 10, 1, k3);
            l2 += 65;
        }
        if(cci > 96)
        {
            int l3 = 0xffffff;
            if(dge == 2)
                l3 = 0xff0000;
            else
            if(super.anb > i1 + l2 && super.anc >= k1 && super.anb < i1 + l2 + 65 && super.anc < k1 + 12)
                l3 = 0xffff00;
            cgm.bdm("<page 3>", i1 + l2, k1 + 10, 1, l3);
            l2 += 65;
        }
        if(cci > 144)
        {
            int i4 = 0xffffff;
            if(dge == 3)
                i4 = 0xff0000;
            else
            if(super.anb > i1 + l2 && super.anc >= k1 && super.anb < i1 + l2 + 65 && super.anc < k1 + 12)
                i4 = 0xffff00;
            cgm.bdm("<page 4>", i1 + l2, k1 + 10, 1, i4);
            l2 += 65;
        }
        int j4 = 0xffffff;
        if(super.anb > i1 + 320 && super.anc >= k1 && super.anb < i1 + 408 && super.anc < k1 + 12)
            j4 = 0xff0000;
        cgm.bdj("Close window", i1 + 406, k1 + 10, 1, j4);
        cgm.bdm("Number in bank in green", i1 + 7, k1 + 24, 1, 65280);
        cgm.bdm("Number held in blue", i1 + 289, k1 + 24, 1, 65535);
        int l7 = 0xd0d0d0;
        int j8 = dge * 48;
        for(int l8 = 0; l8 < 6; l8++)
        {
            for(int i9 = 0; i9 < 8; i9++)
            {
                int k9 = i1 + 7 + i9 * 49;
                int l9 = k1 + 28 + l8 * 34;
                if(bnm == j8)
                    cgm.bal(k9, l9, 49, 34, 0xff0000, 160);
                else
                    cgm.bal(k9, l9, 49, 34, l7, 160);
                cgm.bba(k9, l9, 50, 35, 0);
                if(j8 < cci && def[j8] != -1)
                {
                    cgm.bdc(k9, l9, 48, 32, cka + e.ejh[def[j8]], e.ejm[def[j8]], 0, 0, false);
                    cgm.bdm(String.valueOf(deg[j8]), k9 + 1, l9 + 10, 1, 65280);
                    cgm.bdj(String.valueOf(bmc(def[j8])), k9 + 47, l9 + 29, 1, 65535);
                }
                j8++;
            }

        }

        cgm.bbb(i1 + 5, k1 + 256, 398, 0);
        if(bnm == -1)
        {
            cgm.bdk("Select an object to withdraw or deposit", i1 + 204, k1 + 248, 3, 0xffff00);
            return;
        }
        int j9;
        if(bnm < 0)
            j9 = -1;
        else
            j9 = def[bnm];
        if(j9 != -1)
        {
            int k8 = deg[bnm];
            if(e.ejj[j9] == 1 && k8 > 1)
                k8 = 1;
            if(k8 > 0)
            {
                cgm.bdm("Withdraw " + e.ekj[j9], i1 + 2, k1 + 248, 1, 0xffffff);
                int k4 = 0xffffff;
                if(super.anb >= i1 + 220 && super.anc >= k1 + 238 && super.anb < i1 + 250 && super.anc <= k1 + 249)
                    k4 = 0xff0000;
                cgm.bdm("One", i1 + 222, k1 + 248, 1, k4);
                if(k8 >= 5)
                {
                    int l4 = 0xffffff;
                    if(super.anb >= i1 + 250 && super.anc >= k1 + 238 && super.anb < i1 + 280 && super.anc <= k1 + 249)
                        l4 = 0xff0000;
                    cgm.bdm("Five", i1 + 252, k1 + 248, 1, l4);
                }
                if(k8 >= 25)
                {
                    int i5 = 0xffffff;
                    if(super.anb >= i1 + 280 && super.anc >= k1 + 238 && super.anb < i1 + 305 && super.anc <= k1 + 249)
                        i5 = 0xff0000;
                    cgm.bdm("25", i1 + 282, k1 + 248, 1, i5);
                }
                if(k8 >= 100)
                {
                    int j5 = 0xffffff;
                    if(super.anb >= i1 + 305 && super.anc >= k1 + 238 && super.anb < i1 + 335 && super.anc <= k1 + 249)
                        j5 = 0xff0000;
                    cgm.bdm("100", i1 + 307, k1 + 248, 1, j5);
                }
                if(k8 >= 500)
                {
                    int k5 = 0xffffff;
                    if(super.anb >= i1 + 335 && super.anc >= k1 + 238 && super.anb < i1 + 368 && super.anc <= k1 + 249)
                        k5 = 0xff0000;
                    cgm.bdm("500", i1 + 337, k1 + 248, 1, k5);
                }
                if(k8 >= 2500)
                {
                    int l5 = 0xffffff;
                    if(super.anb >= i1 + 370 && super.anc >= k1 + 238 && super.anb < i1 + 400 && super.anc <= k1 + 249)
                        l5 = 0xff0000;
                    cgm.bdm("2500", i1 + 370, k1 + 248, 1, l5);
                }
            }
            if(bmc(j9) > 0)
            {
                cgm.bdm("Deposit " + e.ekj[j9], i1 + 2, k1 + 273, 1, 0xffffff);
                int i6 = 0xffffff;
                if(super.anb >= i1 + 220 && super.anc >= k1 + 263 && super.anb < i1 + 250 && super.anc <= k1 + 274)
                    i6 = 0xff0000;
                cgm.bdm("One", i1 + 222, k1 + 273, 1, i6);
                if(bmc(j9) >= 5)
                {
                    int j6 = 0xffffff;
                    if(super.anb >= i1 + 250 && super.anc >= k1 + 263 && super.anb < i1 + 280 && super.anc <= k1 + 274)
                        j6 = 0xff0000;
                    cgm.bdm("Five", i1 + 252, k1 + 273, 1, j6);
                }
                if(bmc(j9) >= 25)
                {
                    int k6 = 0xffffff;
                    if(super.anb >= i1 + 280 && super.anc >= k1 + 263 && super.anb < i1 + 305 && super.anc <= k1 + 274)
                        k6 = 0xff0000;
                    cgm.bdm("25", i1 + 282, k1 + 273, 1, k6);
                }
                if(bmc(j9) >= 100)
                {
                    int l6 = 0xffffff;
                    if(super.anb >= i1 + 305 && super.anc >= k1 + 263 && super.anb < i1 + 335 && super.anc <= k1 + 274)
                        l6 = 0xff0000;
                    cgm.bdm("100", i1 + 307, k1 + 273, 1, l6);
                }
                if(bmc(j9) >= 500)
                {
                    int i7 = 0xffffff;
                    if(super.anb >= i1 + 335 && super.anc >= k1 + 263 && super.anb < i1 + 368 && super.anc <= k1 + 274)
                        i7 = 0xff0000;
                    cgm.bdm("500", i1 + 337, k1 + 273, 1, i7);
                }
                if(bmc(j9) >= 2500)
                {
                    int j7 = 0xffffff;
                    if(super.anb >= i1 + 370 && super.anc >= k1 + 263 && super.anb < i1 + 400 && super.anc <= k1 + 274)
                        j7 = 0xff0000;
                    cgm.bdm("2500", i1 + 370, k1 + 273, 1, j7);
                }
            }
        }
    }

    protected final void bjn()
    {
        if(can)
            return;
        if(cif)
            return;
        if(dff)
            return;
        try
        {
            cmn++;
            if(cdg == 0)
            {
                super.ali = 0;
                bnc();
            }
            if(cdg == 1)
            {
                super.ali++;
                bih();
            }
            super.ane = 0;
            super.ang = 0;
            cki++;
            if(cki > 500)
            {
                cki = 0;
                int l = (int)(Math.random() * 4D);
                if((l & 1) == 1)
                    cia += cib;
                if((l & 2) == 2)
                    caa += cab;
            }
            if(cia < -50)
                cib = 2;
            if(cia > 50)
                cib = -2;
            if(caa < -50)
                cab = 2;
            if(caa > 50)
                cab = -2;
            if(dhh > 0)
                dhh--;
            if(dhi > 0)
                dhi--;
            if(dhj > 0)
                dhj--;
            if(dhk > 0)
            {
                dhk--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            blk();
            cif = true;
        }
    }

    protected final void ccl()
    {
        bmb = 0;
        ckl = 0;
        cij = 0;
        cnm = 0;
        cdg = 1;
        bij();
        cgm.baj();
        cgm.bai(cjh, 0, 0);
        for(int l = 0; l < cfa; l++)
        {
            cch.cdk(cec[l]);
            bmf.chd(dgf[l], dgg[l], dgh[l]);
        }

        for(int i1 = 0; i1 < dae; i1++)
        {
            cch.cdk(cem[i1]);
            bmf.chn(ddm[i1], ddn[i1], cdd[i1], cde[i1]);
        }

        cfa = 0;
        dae = 0;
        dhg = 0;
        cmf = 0;
        for(int j1 = 0; j1 < 4000; j1++)
            cme[j1] = null;

        for(int k1 = 0; k1 < 500; k1++)
            bln[k1] = null;

        cae = 0;
        for(int l1 = 0; l1 < 5000; l1++)
            ddc[l1] = null;

        for(int i2 = 0; i2 < 500; i2++)
            cnf[i2] = null;

        for(int j2 = 0; j2 < 50; j2++)
            dgn[j2] = false;

        cgl = 0;
        super.ane = 0;
        super.and = 0;
        dha = false;
        blm = false;
        ddb = false;
    }

    private final void bkb()
    {
        try
        {
            cnk = bil("sounds" + w.bik + ".mem", "Sound effects", 90);
            cne = new d();
            return;
        }
        catch(Throwable throwable)
        {
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    private final void bkc()
    {
        int l = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        bmf.cin(byte0 * 48 + 23, byte1 * 48 + 23, l);
        bmf.cie(dda);
        char c1 = '\u2600';
        char c2 = '\u1900';
        char c3 = '\u044C';
        char c4 = '\u0378';
        cch.ean = 4100;
        cch.eba = 4100;
        cch.ebb = 1;
        cch.ebc = 4000;
        cch.cfk(c1, -bmf.cia(c1, c2), c2, 912, c4, 0, c3 * 2);
        cch.cem();
        cgm.bbe();
        cgm.bbe();
        cgm.ban(0, 0, 512, 6, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            cgm.bbf(0, i1, 0, i1, 512, 8);

        cgm.ban(0, 194, 512, 20, 0);
        for(int j1 = 6; j1 >= 1; j1--)
            cgm.bbf(0, j1, 0, 194 - j1, 512, 8);

        cgm.bca(15, 15, cjm + 10);
        cgm.bbn(cke, 0, 0, 512, 200);
        cgm.bbk(cke);
        c1 = '\u2400';
        c2 = '\u2400';
        c3 = '\u044C';
        c4 = '\u0378';
        cch.ean = 4100;
        cch.eba = 4100;
        cch.ebb = 1;
        cch.ebc = 4000;
        cch.cfk(c1, -bmf.cia(c1, c2), c2, 912, c4, 0, c3 * 2);
        cch.cem();
        cgm.bbe();
        cgm.bbe();
        cgm.ban(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            cgm.bbf(0, k1, 0, k1, 512, 8);

        cgm.ban(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            cgm.bbf(0, l1, 0, 194 - l1, 512, 8);

        cgm.bca(15, 15, cjm + 10);
        cgm.bbn(cke + 1, 0, 0, 512, 200);
        cgm.bbk(cke + 1);
        for(int i2 = 0; i2 < 64; i2++)
        {
            cch.cdk(bmf.ehf[0][i2]);
            cch.cdk(bmf.ehe[1][i2]);
            cch.cdk(bmf.ehf[1][i2]);
            cch.cdk(bmf.ehe[2][i2]);
            cch.cdk(bmf.ehf[2][i2]);
        }

        c1 = '\u2B80';
        c2 = '\u2880';
        c3 = '\u01F4';
        c4 = '\u0178';
        cch.ean = 4100;
        cch.eba = 4100;
        cch.ebb = 1;
        cch.ebc = 4000;
        cch.cfk(c1, -bmf.cia(c1, c2), c2, 912, c4, 0, c3 * 2);
        cch.cem();
        cgm.bbe();
        cgm.bbe();
        cgm.ban(0, 0, 512, 6, 0);
        for(int j2 = 6; j2 >= 1; j2--)
            cgm.bbf(0, j2, 0, j2, 512, 8);

        cgm.ban(0, 194, 512, 20, 0);
        for(int k2 = 6; k2 >= 1; k2--)
            cgm.bbf(0, k2, 0, 194, 512, 8);

        cgm.bca(15, 15, cjm + 10);
        cgm.bbn(cjm + 10, 0, 0, 512, 200);
        cgm.bbk(cjm + 10);
    }

    private final void bkd()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        cgm.ban(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        cgm.bal(byte0, byte1 + 16, 468, 246, l, 160);
        cgm.bdk("Please confirm your trade with @yel@" + t.anh(bmh), byte0 + 234, byte1 + 12, 1, 0xffffff);
        cgm.bdk("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < cga; i1++)
        {
            String s1 = e.ekj[cgb[i1]];
            if(e.ejj[cgb[i1]] == 0)
                s1 = s1 + " x " + bhh(cgc[i1]);
            cgm.bdk(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(cga == 0)
            cgm.bdk("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        cgm.bdk("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < dfh; j1++)
        {
            String s2 = e.ekj[dfi[j1]];
            if(e.ejj[dfi[j1]] == 0)
                s2 = s2 + " x " + bhh(dfj[j1]);
            cgm.bdk(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(dfh == 0)
            cgm.bdk("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        cgm.bdk("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        cgm.bdk("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        cgm.bdk("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!cjk)
        {
            cgm.bca((byte0 + 118) - 35, byte1 + 238, cjm + 25);
            cgm.bca((byte0 + 352) - 35, byte1 + 238, cjm + 26);
        } else
        {
            cgm.bdk("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(cgl == 1)
        {
            if(super.anb < byte0 || super.anc < byte1 || super.anb > byte0 + 468 || super.anc > byte1 + 262)
            {
                cjj = false;
                super.dkd.bgl(124);
                super.dkd.bgm();
            }
            if(super.anb >= (byte0 + 118) - 35 && super.anb <= byte0 + 118 + 70 && super.anc >= byte1 + 238 && super.anc <= byte1 + 238 + 21)
            {
                cjk = true;
                super.dkd.bgl(31);
                super.dkd.bgm();
            }
            if(super.anb >= (byte0 + 352) - 35 && super.anb <= byte0 + 353 + 70 && super.anc >= byte1 + 238 && super.anc <= byte1 + 238 + 21)
            {
                cjj = false;
                super.dkd.bgl(124);
                super.dkd.bgm();
            }
            cgl = 0;
        }
    }

    protected final void cda(int arg0, int arg1, byte arg2[])
    {
        try
        {
            if(arg0 == 115)
            {
                cmg = cmf;
                for(int l = 0; l < cmg; l++)
                    cfe[l] = bln[l];

                int l7 = 8;
                ccm = t.and(arg2, l7, 11);
                l7 += 11;
                ccn = t.and(arg2, l7, 13);
                l7 += 13;
                int i14 = t.and(arg2, l7, 4);
                l7 += 4;
                boolean flag1 = bmj(ccm, ccn);
                ccm -= cle;
                ccn -= clf;
                int i23 = ccm * cdf + 64;
                int i26 = ccn * cdf + 64;
                if(flag1)
                {
                    ccl.dml = 0;
                    ccl.dmk = 0;
                    ccl.dme = ccl.dmm[0] = i23;
                    ccl.dmf = ccl.dmn[0] = i26;
                }
                cmf = 0;
                ccl = bne(cda, i23, i26, i14);
                int j29 = t.and(arg2, l7, 8);
                l7 += 8;
                for(int i34 = 0; i34 < j29; i34++)
                {
                    f f4 = cfe[i34 + 1];
                    int i40 = t.and(arg2, l7, 1);
                    l7++;
                    if(i40 != 0)
                    {
                        int i42 = t.and(arg2, l7, 1);
                        l7++;
                        if(i42 == 0)
                        {
                            int j43 = t.and(arg2, l7, 3);
                            l7 += 3;
                            int j44 = f4.dml;
                            int i45 = f4.dmm[j44];
                            int j45 = f4.dmn[j44];
                            if(j43 == 2 || j43 == 1 || j43 == 3)
                                i45 += cdf;
                            if(j43 == 6 || j43 == 5 || j43 == 7)
                                i45 -= cdf;
                            if(j43 == 4 || j43 == 3 || j43 == 5)
                                j45 += cdf;
                            if(j43 == 0 || j43 == 1 || j43 == 7)
                                j45 -= cdf;
                            f4.dmj = j43;
                            f4.dml = j44 = (j44 + 1) % 10;
                            f4.dmm[j44] = i45;
                            f4.dmn[j44] = j45;
                        } else
                        {
                            int k43 = t.and(arg2, l7, 4);
                            if((k43 & 0xc) == 12)
                            {
                                l7 += 2;
                                continue;
                            }
                            f4.dmj = t.and(arg2, l7, 4);
                            l7 += 4;
                        }
                    }
                    bln[cmf++] = f4;
                }

                int k37 = 0;
                while(l7 + 24 < arg1 * 8) 
                {
                    int j40 = t.and(arg2, l7, 11);
                    l7 += 11;
                    int j42 = t.and(arg2, l7, 5);
                    l7 += 5;
                    if(j42 > 15)
                        j42 -= 32;
                    int l43 = t.and(arg2, l7, 5);
                    l7 += 5;
                    if(l43 > 15)
                        l43 -= 32;
                    int j14 = t.and(arg2, l7, 4);
                    l7 += 4;
                    int k44 = t.and(arg2, l7, 1);
                    l7++;
                    int j23 = (ccm + j42) * cdf + 64;
                    int j26 = (ccn + l43) * cdf + 64;
                    bne(j40, j23, j26, j14);
                    if(k44 == 0)
                        cfg[k37++] = j40;
                }
                if(k37 > 0)
                {
                    super.dkd.bgl(208);
                    super.dkd.bfn(k37);
                    for(int k40 = 0; k40 < k37; k40++)
                    {
                        f f5 = cme[cfg[k40]];
                        super.dkd.bfn(f5.dmc);
                        super.dkd.bfn(f5.dmd);
                    }

                    super.dkd.bgm();
                    k37 = 0;
                }
                return;
            }
            if(arg0 == 44)
            {
                for(int i1 = 1; i1 < arg1;)
                    if(t.aml(arg2[i1]) == 255)
                    {
                        int i8 = 0;
                        int k14 = ccm + arg2[i1 + 1] >> 3;
                        int j19 = ccn + arg2[i1 + 2] >> 3;
                        i1 += 3;
                        for(int k23 = 0; k23 < dhg; k23++)
                        {
                            int k26 = (cng[k23] >> 3) - k14;
                            int k29 = (cnh[k23] >> 3) - j19;
                            if(k26 != 0 || k29 != 0)
                            {
                                if(k23 != i8)
                                {
                                    cng[i8] = cng[k23];
                                    cnh[i8] = cnh[k23];
                                    cni[i8] = cni[k23];
                                    cnj[i8] = cnj[k23];
                                }
                                i8++;
                            }
                        }

                        dhg = i8;
                    } else
                    {
                        int j8 = t.amm(arg2, i1);
                        i1 += 2;
                        int l14 = ccm + arg2[i1++];
                        int k19 = ccn + arg2[i1++];
                        if((j8 & 0x8000) == 0)
                        {
                            cng[dhg] = l14;
                            cnh[dhg] = k19;
                            cni[dhg] = j8;
                            cnj[dhg] = 0;
                            for(int l23 = 0; l23 < cfa; l23++)
                            {
                                if(dgf[l23] != l14 || dgg[l23] != k19)
                                    continue;
                                cnj[dhg] = e.faa[dgh[l23]];
                                break;
                            }

                            dhg++;
                        } else
                        {
                            j8 &= 0x7fff;
                            int i24 = 0;
                            for(int l26 = 0; l26 < dhg; l26++)
                                if(cng[l26] != l14 || cnh[l26] != k19 || cni[l26] != j8)
                                {
                                    if(l26 != i24)
                                    {
                                        cng[i24] = cng[l26];
                                        cnh[i24] = cnh[l26];
                                        cni[i24] = cni[l26];
                                        cnj[i24] = cnj[l26];
                                    }
                                    i24++;
                                } else
                                {
                                    j8 = -123;
                                }

                            dhg = i24;
                        }
                    }

                return;
            }
            if(arg0 == 133)
            {
                for(int j1 = 1; j1 < arg1;)
                    if(t.aml(arg2[j1]) == 255)
                    {
                        int k8 = 0;
                        int i15 = ccm + arg2[j1 + 1] >> 3;
                        int l19 = ccn + arg2[j1 + 2] >> 3;
                        j1 += 3;
                        for(int j24 = 0; j24 < cfa; j24++)
                        {
                            int i27 = (dgf[j24] >> 3) - i15;
                            int l29 = (dgg[j24] >> 3) - l19;
                            if(i27 != 0 || l29 != 0)
                            {
                                if(j24 != k8)
                                {
                                    cec[k8] = cec[j24];
                                    cec[k8].agn = k8;
                                    dgf[k8] = dgf[j24];
                                    dgg[k8] = dgg[j24];
                                    dgh[k8] = dgh[j24];
                                    dgi[k8] = dgi[j24];
                                }
                                k8++;
                            } else
                            {
                                cch.cdk(cec[j24]);
                                bmf.chd(dgf[j24], dgg[j24], dgh[j24]);
                            }
                        }

                        cfa = k8;
                    } else
                    {
                        int l8 = t.amm(arg2, j1);
                        j1 += 2;
                        int j15 = ccm + arg2[j1++];
                        int i20 = ccn + arg2[j1++];
                        int k24 = 0;
                        for(int j27 = 0; j27 < cfa; j27++)
                            if(dgf[j27] != j15 || dgg[j27] != i20)
                            {
                                if(j27 != k24)
                                {
                                    cec[k24] = cec[j27];
                                    cec[k24].agn = k24;
                                    dgf[k24] = dgf[j27];
                                    dgg[k24] = dgg[j27];
                                    dgh[k24] = dgh[j27];
                                    dgi[k24] = dgi[j27];
                                }
                                k24++;
                            } else
                            {
                                cch.cdk(cec[j27]);
                                bmf.chd(dgf[j27], dgg[j27], dgh[j27]);
                            }

                        cfa = k24;
                        if(l8 != 60000)
                        {
                            int i30 = bmf.cjf(j15, i20);
                            int j34;
                            int l37;
                            if(i30 == 0 || i30 == 4)
                            {
                                j34 = e.enl[l8];
                                l37 = e.enm[l8];
                            } else
                            {
                                l37 = e.enl[l8];
                                j34 = e.enm[l8];
                            }
                            int l40 = ((j15 + j15 + j34) * cdf) / 2;
                            int k42 = ((i20 + i20 + l37) * cdf) / 2;
                            int i44 = e.enk[l8];
                            i l44 = dda[i44].ahc();
                            cch.cdj(l44);
                            l44.agn = cfa;
                            l44.agb(0, i30 * 32, 0);
                            l44.agd(l40, -bmf.cia(l40, k42), k42);
                            l44.afl(true, 48, 48, -50, -10, -50);
                            bmf.cij(j15, i20, l8);
                            if(l8 == 74)
                                l44.agd(0, -480, 0);
                            dgf[cfa] = j15;
                            dgg[cfa] = i20;
                            dgh[cfa] = l8;
                            dgi[cfa] = i30;
                            cec[cfa++] = l44;
                        }
                    }

                return;
            }
            if(arg0 == 184)
            {
                int k1 = 1;
                chg = arg2[k1++] & 0xff;
                for(int i9 = 0; i9 < chg; i9++)
                {
                    int k15 = t.amm(arg2, k1);
                    k1 += 2;
                    chh[i9] = k15 & 0x7fff;
                    chj[i9] = k15 / 32768;
                    if(e.ejj[k15 & 0x7fff] == 0)
                    {
                        chi[i9] = t.anc(arg2, k1);
                        if(chi[i9] >= 128)
                            k1 += 4;
                        else
                            k1++;
                    } else
                    {
                        chi[i9] = 1;
                    }
                }

                return;
            }
            if(arg0 == 99)
            {
                int l1 = t.amm(arg2, 1);
                int j9 = 3;
                for(int l15 = 0; l15 < l1; l15++)
                {
                    int j20 = t.amm(arg2, j9);
                    j9 += 2;
                    f f1 = cme[j20];
                    byte byte6 = arg2[j9];
                    j9++;
                    if(byte6 == 0)
                    {
                        int j30 = t.amm(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.dne = 150;
                            f1.dnd = j30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s3 = u.akl(v.aeg(arg2, j9, byte7));
                            boolean flag3 = false;
                            for(int i41 = 0; i41 < super.dkk; i41++)
                                if(super.dkl[i41] == f1.dma)
                                    flag3 = true;

                            if(!flag3)
                            {
                                f1.dnc = 150;
                                f1.dnb = s3;
                                bhf(f1.dmb + ": " + f1.dnb, 2);
                            }
                        }
                        j9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int k30 = t.aml(arg2[j9]);
                        j9++;
                        int k34 = t.aml(arg2[j9]);
                        j9++;
                        int i38 = t.aml(arg2[j9]);
                        j9++;
                        if(f1 != null)
                        {
                            f1.dnf = k30;
                            f1.dng = k34;
                            f1.dnh = i38;
                            f1.dni = 200;
                            if(f1 == ccl)
                            {
                                bnd[3] = k34;
                                ckg[3] = i38;
                                dcl = false;
                                daf = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int l30 = t.amm(arg2, j9);
                        j9 += 2;
                        int l34 = t.amm(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.eaa = l30;
                            f1.eac = l34;
                            f1.eab = -1;
                            f1.ead = cej;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int i31 = t.amm(arg2, j9);
                        j9 += 2;
                        int i35 = t.amm(arg2, j9);
                        j9 += 2;
                        if(f1 != null)
                        {
                            f1.eaa = i31;
                            f1.eab = i35;
                            f1.eac = -1;
                            f1.ead = cej;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(f1 != null)
                        {
                            f1.dmd = t.amm(arg2, j9);
                            j9 += 2;
                            f1.dma = t.ana(arg2, j9);
                            j9 += 8;
                            f1.dmb = t.anh(f1.dma);
                            int j31 = t.aml(arg2[j9]);
                            j9++;
                            for(int j35 = 0; j35 < j31; j35++)
                            {
                                f1.dna[j35] = t.aml(arg2[j9]);
                                j9++;
                            }

                            for(int j38 = j31; j38 < 12; j38++)
                                f1.dna[j38] = 0;

                            f1.dnk = arg2[j9++] & 0xff;
                            f1.dnl = arg2[j9++] & 0xff;
                            f1.dnm = arg2[j9++] & 0xff;
                            f1.dnn = arg2[j9++] & 0xff;
                            f1.dnj = arg2[j9++] & 0xff;
                            f1.eag = arg2[j9++] & 0xff;
                        } else
                        {
                            j9 += 14;
                            int k31 = t.aml(arg2[j9]);
                            j9 += k31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = arg2[j9];
                        j9++;
                        if(f1 != null)
                        {
                            String s4 = v.aeg(arg2, j9, byte8);
                            f1.dnc = 150;
                            f1.dnb = s4;
                            if(f1 == ccl)
                                bhf(f1.dmb + ": " + f1.dnb, 5);
                        }
                        j9 += byte8;
                    }
                }

                return;
            }
            if(arg0 == 247)
            {
                for(int i2 = 1; i2 < arg1;)
                    if(t.aml(arg2[i2]) == 255)
                    {
                        int k9 = 0;
                        int i16 = ccm + arg2[i2 + 1] >> 3;
                        int k20 = ccn + arg2[i2 + 2] >> 3;
                        i2 += 3;
                        for(int l24 = 0; l24 < dae; l24++)
                        {
                            int k27 = (ddm[l24] >> 3) - i16;
                            int l31 = (ddn[l24] >> 3) - k20;
                            if(k27 != 0 || l31 != 0)
                            {
                                if(l24 != k9)
                                {
                                    cem[k9] = cem[l24];
                                    cem[k9].agn = k9 + 10000;
                                    ddm[k9] = ddm[l24];
                                    ddn[k9] = ddn[l24];
                                    cdd[k9] = cdd[l24];
                                    cde[k9] = cde[l24];
                                }
                                k9++;
                            } else
                            {
                                cch.cdk(cem[l24]);
                                bmf.chn(ddm[l24], ddn[l24], cdd[l24], cde[l24]);
                            }
                        }

                        dae = k9;
                    } else
                    {
                        int l9 = t.amm(arg2, i2);
                        i2 += 2;
                        int j16 = ccm + arg2[i2++];
                        int l20 = ccn + arg2[i2++];
                        byte byte5 = arg2[i2++];
                        int l27 = 0;
                        for(int i32 = 0; i32 < dae; i32++)
                            if(ddm[i32] != j16 || ddn[i32] != l20 || cdd[i32] != byte5)
                            {
                                if(i32 != l27)
                                {
                                    cem[l27] = cem[i32];
                                    cem[l27].agn = l27 + 10000;
                                    ddm[l27] = ddm[i32];
                                    ddn[l27] = ddn[i32];
                                    cdd[l27] = cdd[i32];
                                    cde[l27] = cde[i32];
                                }
                                l27++;
                            } else
                            {
                                cch.cdk(cem[i32]);
                                bmf.chn(ddm[i32], ddn[i32], cdd[i32], cde[i32]);
                            }

                        dae = l27;
                        if(l9 != 65535)
                        {
                            bmf.chk(j16, l20, byte5, l9);
                            i k35 = bll(j16, l20, byte5, l9, dae);
                            cem[dae] = k35;
                            ddm[dae] = j16;
                            ddn[dae] = l20;
                            cde[dae] = l9;
                            cdd[dae++] = byte5;
                        }
                    }

                return;
            }
            if(arg0 == 171)
            {
                caf = cae;
                cae = 0;
                for(int j2 = 0; j2 < caf; j2++)
                    cff[j2] = cnf[j2];

                int i10 = 8;
                int k16 = t.and(arg2, i10, 8);
                i10 += 8;
                for(int i21 = 0; i21 < k16; i21++)
                {
                    f f2 = cff[i21];
                    int i28 = t.and(arg2, i10, 1);
                    i10++;
                    if(i28 != 0)
                    {
                        int j32 = t.and(arg2, i10, 1);
                        i10++;
                        if(j32 == 0)
                        {
                            int l35 = t.and(arg2, i10, 3);
                            i10 += 3;
                            int k38 = f2.dml;
                            int j41 = f2.dmm[k38];
                            int l42 = f2.dmn[k38];
                            if(l35 == 2 || l35 == 1 || l35 == 3)
                                j41 += cdf;
                            if(l35 == 6 || l35 == 5 || l35 == 7)
                                j41 -= cdf;
                            if(l35 == 4 || l35 == 3 || l35 == 5)
                                l42 += cdf;
                            if(l35 == 0 || l35 == 1 || l35 == 7)
                                l42 -= cdf;
                            f2.dmj = l35;
                            f2.dml = k38 = (k38 + 1) % 10;
                            f2.dmm[k38] = j41;
                            f2.dmn[k38] = l42;
                        } else
                        {
                            int i36 = t.and(arg2, i10, 4);
                            if((i36 & 0xc) == 12)
                            {
                                i10 += 2;
                                continue;
                            }
                            f2.dmj = t.and(arg2, i10, 4);
                            i10 += 4;
                        }
                    }
                    cnf[cae++] = f2;
                }

                while(i10 + 34 < arg1 * 8) 
                {
                    int i25 = t.and(arg2, i10, 12);
                    i10 += 12;
                    int j28 = t.and(arg2, i10, 5);
                    i10 += 5;
                    if(j28 > 15)
                        j28 -= 32;
                    int k32 = t.and(arg2, i10, 5);
                    i10 += 5;
                    if(k32 > 15)
                        k32 -= 32;
                    int j36 = t.and(arg2, i10, 4);
                    i10 += 4;
                    int l38 = (ccm + j28) * cdf + 64;
                    int k41 = (ccn + k32) * cdf + 64;
                    int i43 = t.and(arg2, i10, 10);
                    i10 += 10;
                    if(i43 >= e.emm)
                        i43 = 24;
                    bid(i25, l38, k41, j36, i43);
                }
                return;
            }
            if(arg0 == 13)
            {
                int k2 = t.amm(arg2, 1);
                int j10 = 3;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = t.amm(arg2, j10);
                    j10 += 2;
                    f f3 = ddc[j21];
                    int k28 = t.aml(arg2[j10]);
                    j10++;
                    if(k28 == 1)
                    {
                        int l32 = t.amm(arg2, j10);
                        j10 += 2;
                        byte byte9 = arg2[j10];
                        j10++;
                        if(f3 != null)
                        {
                            String s5 = v.aeg(arg2, j10, byte9);
                            f3.dnc = 150;
                            f3.dnb = s5;
                            if(l32 == ccl.dmc)
                                bhf("@yel@" + e.eij[f3.dmg] + ": " + f3.dnb, 5);
                        }
                        j10 += byte9;
                    } else
                    if(k28 == 2)
                    {
                        int i33 = t.aml(arg2[j10]);
                        j10++;
                        int k36 = t.aml(arg2[j10]);
                        j10++;
                        int i39 = t.aml(arg2[j10]);
                        j10++;
                        if(f3 != null)
                        {
                            f3.dnf = i33;
                            f3.dng = k36;
                            f3.dnh = i39;
                            f3.dni = 200;
                        }
                    }
                }

                return;
            }
            if(arg0 == 63)
            {
                clb = true;
                int l2 = t.aml(arg2[1]);
                cah = l2;
                int k10 = 2;
                for(int i17 = 0; i17 < l2; i17++)
                {
                    int k21 = t.aml(arg2[k10]);
                    k10++;
                    cnn[i17] = new String(arg2, k10, k21);
                    k10 += k21;
                }

                return;
            }
            if(arg0 == 159)
            {
                clb = false;
                return;
            }
            if(arg0 == 166)
            {
                bnf = true;
                cda = t.amm(arg2, 1);
                dgj = t.amm(arg2, 3);
                dgk = t.amm(arg2, 5);
                clg = t.amm(arg2, 7);
                dgl = t.amm(arg2, 9);
                dgk -= clg * dgl;
                return;
            }
            if(arg0 == 202)
            {
                int i3 = 1;
                for(int l10 = 0; l10 < 18; l10++)
                    bnd[l10] = t.aml(arg2[i3++]);

                for(int j17 = 0; j17 < 18; j17++)
                    ckg[j17] = t.aml(arg2[i3++]);

                for(int l21 = 0; l21 < 18; l21++)
                {
                    cac[l21] = t.amn(arg2, i3);
                    i3 += 4;
                }

                chk = t.aml(arg2[i3++]);
                return;
            }
            if(arg0 == 88)
            {
                for(int j3 = 0; j3 < 5; j3++)
                    chc[j3] = t.aml(arg2[1 + j3]);

                return;
            }
            if(arg0 == 162)
            {
                cih = 250;
                return;
            }
            if(arg0 == 192)
            {
                int k3 = (arg1 - 1) / 4;
                for(int i11 = 0; i11 < k3; i11++)
                {
                    int k17 = ccm + t.anb(arg2, 1 + i11 * 4) >> 3;
                    int i22 = ccn + t.anb(arg2, 3 + i11 * 4) >> 3;
                    int j25 = 0;
                    for(int l28 = 0; l28 < dhg; l28++)
                    {
                        int j33 = (cng[l28] >> 3) - k17;
                        int l36 = (cnh[l28] >> 3) - i22;
                        if(j33 != 0 || l36 != 0)
                        {
                            if(l28 != j25)
                            {
                                cng[j25] = cng[l28];
                                cnh[j25] = cnh[l28];
                                cni[j25] = cni[l28];
                                cnj[j25] = cnj[l28];
                            }
                            j25++;
                        }
                    }

                    dhg = j25;
                    j25 = 0;
                    for(int k33 = 0; k33 < cfa; k33++)
                    {
                        int i37 = (dgf[k33] >> 3) - k17;
                        int j39 = (dgg[k33] >> 3) - i22;
                        if(i37 != 0 || j39 != 0)
                        {
                            if(k33 != j25)
                            {
                                cec[j25] = cec[k33];
                                cec[j25].agn = j25;
                                dgf[j25] = dgf[k33];
                                dgg[j25] = dgg[k33];
                                dgh[j25] = dgh[k33];
                                dgi[j25] = dgi[k33];
                            }
                            j25++;
                        } else
                        {
                            cch.cdk(cec[k33]);
                            bmf.chd(dgf[k33], dgg[k33], dgh[k33]);
                        }
                    }

                    cfa = j25;
                    j25 = 0;
                    for(int j37 = 0; j37 < dae; j37++)
                    {
                        int k39 = (ddm[j37] >> 3) - k17;
                        int l41 = (ddn[j37] >> 3) - i22;
                        if(k39 != 0 || l41 != 0)
                        {
                            if(j37 != j25)
                            {
                                cem[j25] = cem[j37];
                                cem[j25].agn = j25 + 10000;
                                ddm[j25] = ddm[j37];
                                ddn[j25] = ddn[j37];
                                cdd[j25] = cdd[j37];
                                cde[j25] = cde[j37];
                            }
                            j25++;
                        } else
                        {
                            cch.cdk(cem[j37]);
                            bmf.chn(ddm[j37], ddn[j37], cdd[j37], cde[j37]);
                        }
                    }

                    dae = j25;
                }

                return;
            }
            if(arg0 == 87)
            {
                cbj = true;
                return;
            }
            if(arg0 == 96)
            {
                int l3 = t.amm(arg2, 1);
                if(cme[l3] != null)
                    del = cme[l3].dmb;
                chl = true;
                bnb = false;
                bnc = false;
                cmi = 0;
                cba = 0;
                return;
            }
            if(arg0 == 182)
            {
                chl = false;
                cjj = false;
                return;
            }
            if(arg0 == 36)
            {
                cba = arg2[1] & 0xff;
                int i4 = 2;
                for(int j11 = 0; j11 < cba; j11++)
                {
                    cbb[j11] = t.amm(arg2, i4);
                    i4 += 2;
                    cbc[j11] = t.amn(arg2, i4);
                    i4 += 4;
                }

                bnb = false;
                bnc = false;
                return;
            }
            if(arg0 == 248)
            {
                byte byte0 = arg2[1];
                if(byte0 == 1)
                {
                    bnb = true;
                    return;
                } else
                {
                    bnb = false;
                    return;
                }
            }
            if(arg0 == 178)
            {
                dha = true;
                int j4 = 1;
                int k11 = arg2[j4++] & 0xff;
                byte byte4 = arg2[j4++];
                cma = arg2[j4++] & 0xff;
                cmb = arg2[j4++] & 0xff;
                for(int j22 = 0; j22 < 40; j22++)
                    bnj[j22] = -1;

                for(int k25 = 0; k25 < k11; k25++)
                {
                    bnj[k25] = t.amm(arg2, j4);
                    j4 += 2;
                    bnk[k25] = t.amm(arg2, j4);
                    j4 += 2;
                    bnl[k25] = arg2[j4++];
                }

                if(byte4 == 1)
                {
                    int i29 = 39;
                    for(int l33 = 0; l33 < chg; l33++)
                    {
                        if(i29 < k11)
                            break;
                        boolean flag2 = false;
                        for(int l39 = 0; l39 < 40; l39++)
                        {
                            if(bnj[l39] != chh[l33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(chh[l33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            bnj[i29] = chh[l33] & 0x7fff;
                            bnk[i29] = 0;
                            bnl[i29] = 0;
                            i29--;
                        }
                    }

                }
                if(cef >= 0 && cef < 40 && bnj[cef] != ceg)
                {
                    cef = -1;
                    ceg = -2;
                }
                return;
            }
            if(arg0 == 79)
            {
                dha = false;
                return;
            }
            if(arg0 == 241)
            {
                byte byte1 = arg2[1];
                if(byte1 == 1)
                {
                    bnc = true;
                    return;
                } else
                {
                    bnc = false;
                    return;
                }
            }
            if(arg0 == 204)
            {
                ceh = t.aml(arg2[1]) == 1;
                ckf = t.aml(arg2[2]) == 1;
                cmc = t.aml(arg2[3]) == 1;
                return;
            }
            if(arg0 == 71)
            {
                for(int k4 = 0; k4 < arg1 - 1; k4++)
                {
                    boolean flag = arg2[k4 + 1] == 1;
                    if(!dgn[k4] && flag)
                        bkl("prayeron");
                    if(dgn[k4] && !flag)
                        bkl("prayeroff");
                    dgn[k4] = flag;
                }

                return;
            }
            if(arg0 == 98)
            {
                for(int l4 = 0; l4 < 50; l4++)
                    dan[l4] = arg2[l4 + 1] == 1;

                return;
            }
            if(arg0 == 183)
            {
                blm = true;
                int i5 = 1;
                cbd = arg2[i5++] & 0xff;
                cnc = arg2[i5++] & 0xff;
                for(int l11 = 0; l11 < cbd; l11++)
                {
                    cfb[l11] = t.amm(arg2, i5);
                    i5 += 2;
                    cfc[l11] = t.anc(arg2, i5);
                    if(cfc[l11] >= 128)
                        i5 += 4;
                    else
                        i5++;
                }

                bic();
                return;
            }
            if(arg0 == 118)
            {
                blm = false;
                return;
            }
            if(arg0 == 189)
            {
                int j5 = arg2[1] & 0xff;
                cac[j5] = t.amn(arg2, 2);
                return;
            }
            if(arg0 == 113)
            {
                int k5 = t.amm(arg2, 1);
                if(cme[k5] != null)
                    ccj = cme[k5].dmb;
                dad = true;
                dcb = 0;
                bmc = 0;
                dfd = false;
                dfe = false;
                daj = false;
                dak = false;
                dal = false;
                dam = false;
                return;
            }
            if(arg0 == 21)
            {
                dad = false;
                dem = false;
                return;
            }
            if(arg0 == 94)
            {
                cjj = true;
                cjk = false;
                chl = false;
                int l5 = 1;
                bmh = t.ana(arg2, l5);
                l5 += 8;
                dfh = arg2[l5++] & 0xff;
                for(int i12 = 0; i12 < dfh; i12++)
                {
                    dfi[i12] = t.amm(arg2, l5);
                    l5 += 2;
                    dfj[i12] = t.amn(arg2, l5);
                    l5 += 4;
                }

                cga = arg2[l5++] & 0xff;
                for(int l17 = 0; l17 < cga; l17++)
                {
                    cgb[l17] = t.amm(arg2, l5);
                    l5 += 2;
                    cgc[l17] = t.amn(arg2, l5);
                    l5 += 4;
                }

                return;
            }
            if(arg0 == 27)
            {
                bmc = arg2[1] & 0xff;
                int i6 = 2;
                for(int j12 = 0; j12 < bmc; j12++)
                {
                    bmd[j12] = t.amm(arg2, i6);
                    i6 += 2;
                    bme[j12] = t.amn(arg2, i6);
                    i6 += 4;
                }

                dfd = false;
                dfe = false;
                return;
            }
            if(arg0 == 203)
            {
                if(arg2[1] == 1)
                    daj = true;
                else
                    daj = false;
                if(arg2[2] == 1)
                    dak = true;
                else
                    dak = false;
                if(arg2[3] == 1)
                    dal = true;
                else
                    dal = false;
                if(arg2[4] == 1)
                    dam = true;
                else
                    dam = false;
                dfd = false;
                dfe = false;
                return;
            }
            if(arg0 == 92)
            {
                int j6 = 1;
                int k12 = arg2[j6++] & 0xff;
                int i18 = t.amm(arg2, j6);
                j6 += 2;
                int k22 = t.anc(arg2, j6);
                if(k22 >= 128)
                    j6 += 4;
                else
                    j6++;
                if(k22 == 0)
                {
                    cbd--;
                    for(int l25 = k12; l25 < cbd; l25++)
                    {
                        cfb[l25] = cfb[l25 + 1];
                        cfc[l25] = cfc[l25 + 1];
                    }

                } else
                {
                    cfb[k12] = i18;
                    cfc[k12] = k22;
                    if(k12 >= cbd)
                        cbd = k12 + 1;
                }
                bic();
                return;
            }
            if(arg0 == 157)
            {
                int k6 = 1;
                int l12 = 1;
                int j18 = arg2[k6++] & 0xff;
                int l22 = t.amm(arg2, k6);
                k6 += 2;
                if(e.ejj[l22 & 0x7fff] == 0)
                {
                    l12 = t.anc(arg2, k6);
                    if(l12 >= 128)
                        k6 += 4;
                    else
                        k6++;
                }
                chh[j18] = l22 & 0x7fff;
                chj[j18] = l22 / 32768;
                chi[j18] = l12;
                if(j18 >= chg)
                    chg = j18 + 1;
                return;
            }
            if(arg0 == 152)
            {
                int l6 = arg2[1] & 0xff;
                chg--;
                for(int i13 = l6; i13 < chg; i13++)
                {
                    chh[i13] = chh[i13 + 1];
                    chi[i13] = chi[i13 + 1];
                    chj[i13] = chj[i13 + 1];
                }

                return;
            }
            if(arg0 == 195)
            {
                int i7 = 1;
                int j13 = arg2[i7++] & 0xff;
                bnd[j13] = t.aml(arg2[i7++]);
                ckg[j13] = t.aml(arg2[i7++]);
                cac[j13] = t.amn(arg2, i7);
                i7 += 4;
                return;
            }
            if(arg0 == 131)
            {
                byte byte2 = arg2[1];
                if(byte2 == 1)
                {
                    dfd = true;
                    return;
                } else
                {
                    dfd = false;
                    return;
                }
            }
            if(arg0 == 105)
            {
                byte byte3 = arg2[1];
                if(byte3 == 1)
                {
                    dfe = true;
                    return;
                } else
                {
                    dfe = false;
                    return;
                }
            }
            if(arg0 == 243)
            {
                dem = true;
                den = false;
                dad = false;
                int j7 = 1;
                cdi = t.ana(arg2, j7);
                j7 += 8;
                deh = arg2[j7++] & 0xff;
                for(int k13 = 0; k13 < deh; k13++)
                {
                    dei[k13] = t.amm(arg2, j7);
                    j7 += 2;
                    dej[k13] = t.amn(arg2, j7);
                    j7 += 4;
                }

                cdm = arg2[j7++] & 0xff;
                for(int k18 = 0; k18 < cdm; k18++)
                {
                    cdn[k18] = t.amm(arg2, j7);
                    j7 += 2;
                    cea[k18] = t.amn(arg2, j7);
                    j7 += 4;
                }

                cbf = arg2[j7++] & 0xff;
                cbg = arg2[j7++] & 0xff;
                cbh = arg2[j7++] & 0xff;
                cbi = arg2[j7++] & 0xff;
                return;
            }
            if(arg0 == 179)
            {
                String s1 = new String(arg2, 1, arg1 - 1);
                bkl(s1);
                return;
            }
            if(arg0 == 52)
            {
                if(cad < 50)
                {
                    int k7 = arg2[1] & 0xff;
                    int l13 = arg2[2] + ccm;
                    int l18 = arg2[3] + ccn;
                    cfl[cad] = k7;
                    cge[cad] = 0;
                    ddi[cad] = l13;
                    cgd[cad] = l18;
                    cad++;
                }
                return;
            }
            if(arg0 == 124)
            {
                if(!dhc)
                {
                    cnd = t.amn(arg2, 1);
                    cdj = t.amm(arg2, 5);
                    cln = arg2[7] & 0xff;
                    dec = t.amm(arg2, 8);
                    dcl = true;
                    dhc = true;
                    dfk = null;
                }
                return;
            }
            if(arg0 == 141)
            {
                cck = new String(arg2, 1, arg1 - 1);
                daf = true;
                clc = false;
                return;
            }
            if(arg0 == 142)
            {
                cck = new String(arg2, 1, arg1 - 1);
                daf = true;
                clc = true;
                return;
            }
            if(arg0 == 128)
            {
                dag = t.amm(arg2, 1);
                return;
            }
            if(arg0 == 23)
            {
                if(!ddb)
                    dah = dag;
                ddb = true;
                super.ani = "";
                super.anj = "";
                cgm.bbj(ckc + 1, arg2);
                cdc = null;
                return;
            }
            if(arg0 == 83)
            {
                dah = t.amm(arg2, 1);
                return;
            }
            if(arg0 == 217)
            {
                ddb = false;
                return;
            }
            if(arg0 == 25)
            {
                cdc = "Incorrect - Please wait...";
                return;
            }
            if(arg0 == 37)
            {
                bmb = t.amm(arg2, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            if(cdh < 3)
            {
                super.dkd.bgl(137);
                super.dkd.bgc(runtimeexception.toString());
                super.dkd.bgm();
                super.dkd.bgl(137);
                super.dkd.bgc("p-type:" + arg0 + " p-size:" + arg1);
                super.dkd.bgm();
                super.dkd.bgl(137);
                super.dkd.bgc("rx:" + ccm + " ry:" + ccn + " num3l:" + cfa);
                super.dkd.bgm();
                String s2 = "";
                for(int i19 = 0; i19 < 80 && i19 < arg1; i19++)
                    s2 = s2 + arg2[i19] + " ";

                super.dkd.bgl(137);
                super.dkd.bgc(s2);
                super.dkd.bgm();
                cdh++;
            }
        }
    }

    private final void bkf()
    {
        if(cgl != 0)
        {
            for(int l = 0; l < cah; l++)
            {
                if(super.anb >= cgm.bee(cnn[l], 1) || super.anc <= l * 12 || super.anc >= 12 + l * 12)
                    continue;
                super.dkd.bgl(185);
                super.dkd.bfj(l);
                super.dkd.bgm();
                break;
            }

            cgl = 0;
            clb = false;
            return;
        }
        for(int i1 = 0; i1 < cah; i1++)
        {
            int j1 = 65535;
            if(super.anb < cgm.bee(cnn[i1], 1) && super.anc > i1 * 12 && super.anc < 12 + i1 * 12)
                j1 = 0xff0000;
            cgm.bdm(cnn[i1], 6, 12 + i1 * 12, 1, j1);
        }

    }

    private final void bkg()
    {
        if(cgl != 0)
        {
            for(int l = 0; l < bna; l++)
            {
                int j1 = bmk + 2;
                int l1 = bml + 27 + l * 15;
                if(super.anb <= j1 - 2 || super.anc <= l1 - 12 || super.anc >= l1 + 4 || super.anb >= (j1 - 3) + bmm)
                    continue;
                bji(cnl[l]);
                break;
            }

            cgl = 0;
            cmd = false;
            return;
        }
        if(super.anb < bmk - 10 || super.anc < bml - 10 || super.anb > bmk + bmm + 10 || super.anc > bml + bmn + 10)
        {
            cmd = false;
            return;
        }
        cgm.bal(bmk, bml, bmm, bmn, 0xd0d0d0, 160);
        cgm.bdm("Choose option", bmk + 2, bml + 12, 1, 65535);
        for(int i1 = 0; i1 < bna; i1++)
        {
            int k1 = bmk + 2;
            int i2 = bml + 27 + i1 * 15;
            int j2 = 0xffffff;
            if(super.anb > k1 - 2 && super.anc > i2 - 12 && super.anc < i2 + 4 && super.anb < (k1 - 3) + bmm)
                j2 = 0xffff00;
            cgm.bdm(cig[cnl[i1]] + " " + cen[cnl[i1]], k1, i2, 1, j2);
        }

    }

    private final boolean bkh(int arg0)
    {
        for(int l = 0; l < chg; l++)
            if(chh[l] == arg0 && chj[l] == 1)
                return true;

        return false;
    }

    private final void bki()
    {
        if(cgl != 0 && dee == 0)
            dee = 1;
        if(dee > 0)
        {
            int l = super.anb - 22;
            int i1 = super.anc - 36;
            if(l >= 0 && i1 >= 0 && l < 468 && i1 < 262)
            {
                if(l > 216 && i1 > 30 && l < 462 && i1 < 235)
                {
                    int j1 = (l - 217) / 49 + ((i1 - 31) / 34) * 5;
                    if(j1 >= 0 && j1 < chg)
                    {
                        boolean flag1 = false;
                        int k2 = 0;
                        int j3 = chh[j1];
                        for(int j4 = 0; j4 < dcb; j4++)
                            if(dcc[j4] == j3)
                                if(e.ejj[j3] == 0)
                                {
                                    for(int l4 = 0; l4 < dee; l4++)
                                    {
                                        if(dcd[j4] < chi[j1])
                                            dcd[j4]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    k2++;
                                }

                        if(bmc(j3) <= k2)
                            flag1 = true;
                        if(e.ejn[j3] == 1)
                        {
                            bhf("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && dcb < 8)
                        {
                            dcc[dcb] = j3;
                            dcd[dcb] = 1;
                            dcb++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.dkd.bgl(131);
                            super.dkd.bfj(dcb);
                            for(int i5 = 0; i5 < dcb; i5++)
                            {
                                super.dkd.bfn(dcc[i5]);
                                super.dkd.bgb(dcd[i5]);
                            }

                            super.dkd.bgm();
                            dfd = false;
                            dfe = false;
                        }
                    }
                }
                if(l > 8 && i1 > 30 && l < 205 && i1 < 129)
                {
                    int k1 = (l - 9) / 49 + ((i1 - 31) / 34) * 4;
                    if(k1 >= 0 && k1 < dcb)
                    {
                        int i2 = dcc[k1];
                        for(int l2 = 0; l2 < dee; l2++)
                        {
                            if(e.ejj[i2] == 0 && dcd[k1] > 1)
                            {
                                dcd[k1]--;
                                continue;
                            }
                            dcb--;
                            ded = 0;
                            for(int k3 = k1; k3 < dcb; k3++)
                            {
                                dcc[k3] = dcc[k3 + 1];
                                dcd[k3] = dcd[k3 + 1];
                            }

                            break;
                        }

                        super.dkd.bgl(131);
                        super.dkd.bfj(dcb);
                        for(int l3 = 0; l3 < dcb; l3++)
                        {
                            super.dkd.bfn(dcc[l3]);
                            super.dkd.bgb(dcd[l3]);
                        }

                        super.dkd.bgm();
                        dfd = false;
                        dfe = false;
                    }
                }
                boolean flag = false;
                if(l >= 93 && i1 >= 221 && l <= 104 && i1 <= 232)
                {
                    daj = !daj;
                    flag = true;
                }
                if(l >= 93 && i1 >= 240 && l <= 104 && i1 <= 251)
                {
                    dak = !dak;
                    flag = true;
                }
                if(l >= 191 && i1 >= 221 && l <= 202 && i1 <= 232)
                {
                    dal = !dal;
                    flag = true;
                }
                if(l >= 191 && i1 >= 240 && l <= 202 && i1 <= 251)
                {
                    dam = !dam;
                    flag = true;
                }
                if(flag)
                {
                    super.dkd.bgl(117);
                    super.dkd.bfj(daj ? 1 : 0);
                    super.dkd.bfj(dak ? 1 : 0);
                    super.dkd.bfj(dal ? 1 : 0);
                    super.dkd.bfj(dam ? 1 : 0);
                    super.dkd.bgm();
                    dfd = false;
                    dfe = false;
                }
                if(l >= 217 && i1 >= 238 && l <= 286 && i1 <= 259)
                {
                    dfe = true;
                    super.dkd.bgl(28);
                    super.dkd.bgm();
                }
                if(l >= 394 && i1 >= 238 && l < 463 && i1 < 259)
                {
                    dad = false;
                    super.dkd.bgl(234);
                    super.dkd.bgm();
                }
            } else
            if(cgl != 0)
            {
                dad = false;
                super.dkd.bgl(234);
                super.dkd.bgm();
            }
            cgl = 0;
            dee = 0;
        }
        if(!dad)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        cgm.ban(byte0, byte1, 468, 12, 0xc90b1d);
        int l1 = 0x989898;
        cgm.bal(byte0, byte1 + 12, 468, 18, l1, 160);
        cgm.bal(byte0, byte1 + 30, 8, 248, l1, 160);
        cgm.bal(byte0 + 205, byte1 + 30, 11, 248, l1, 160);
        cgm.bal(byte0 + 462, byte1 + 30, 6, 248, l1, 160);
        cgm.bal(byte0 + 8, byte1 + 99, 197, 24, l1, 160);
        cgm.bal(byte0 + 8, byte1 + 192, 197, 23, l1, 160);
        cgm.bal(byte0 + 8, byte1 + 258, 197, 20, l1, 160);
        cgm.bal(byte0 + 216, byte1 + 235, 246, 43, l1, 160);
        int j2 = 0xd0d0d0;
        cgm.bal(byte0 + 8, byte1 + 30, 197, 69, j2, 160);
        cgm.bal(byte0 + 8, byte1 + 123, 197, 69, j2, 160);
        cgm.bal(byte0 + 8, byte1 + 215, 197, 43, j2, 160);
        cgm.bal(byte0 + 216, byte1 + 30, 246, 205, j2, 160);
        for(int i3 = 0; i3 < 3; i3++)
            cgm.bbb(byte0 + 8, byte1 + 30 + i3 * 34, 197, 0);

        for(int i4 = 0; i4 < 3; i4++)
            cgm.bbb(byte0 + 8, byte1 + 123 + i4 * 34, 197, 0);

        for(int k4 = 0; k4 < 7; k4++)
            cgm.bbb(byte0 + 216, byte1 + 30 + k4 * 34, 246, 0);

        for(int j5 = 0; j5 < 6; j5++)
        {
            if(j5 < 5)
                cgm.bbc(byte0 + 8 + j5 * 49, byte1 + 30, 69, 0);
            if(j5 < 5)
                cgm.bbc(byte0 + 8 + j5 * 49, byte1 + 123, 69, 0);
            cgm.bbc(byte0 + 216 + j5 * 49, byte1 + 30, 205, 0);
        }

        cgm.bbb(byte0 + 8, byte1 + 215, 197, 0);
        cgm.bbb(byte0 + 8, byte1 + 257, 197, 0);
        cgm.bbc(byte0 + 8, byte1 + 215, 43, 0);
        cgm.bbc(byte0 + 204, byte1 + 215, 43, 0);
        cgm.bdm("Preparing to duel with: " + ccj, byte0 + 1, byte1 + 10, 1, 0xffffff);
        cgm.bdm("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        cgm.bdm("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        cgm.bdm("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        cgm.bdm("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        cgm.bdm("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        cgm.bdm("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        cgm.bdm("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        cgm.bdm("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        cgm.bba(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(daj)
            cgm.ban(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        cgm.bba(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dak)
            cgm.ban(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        cgm.bba(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(dal)
            cgm.ban(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        cgm.bba(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(dam)
            cgm.ban(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!dfe)
            cgm.bca(byte0 + 217, byte1 + 238, cjm + 25);
        cgm.bca(byte0 + 394, byte1 + 238, cjm + 26);
        if(dfd)
        {
            cgm.bdk("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            cgm.bdk("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(dfe)
        {
            cgm.bdk("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            cgm.bdk("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int k5 = 0; k5 < chg; k5++)
        {
            int l5 = 217 + byte0 + (k5 % 5) * 49;
            int j6 = 31 + byte1 + (k5 / 5) * 34;
            cgm.bdc(l5, j6, 48, 32, cka + e.ejh[chh[k5]], e.ejm[chh[k5]], 0, 0, false);
            if(e.ejj[chh[k5]] == 0)
                cgm.bdm(String.valueOf(chi[k5]), l5 + 1, j6 + 10, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < dcb; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int i7 = 31 + byte1 + (i6 / 4) * 34;
            cgm.bdc(k6, i7, 48, 32, cka + e.ejh[dcc[i6]], e.ejm[dcc[i6]], 0, 0, false);
            if(e.ejj[dcc[i6]] == 0)
                cgm.bdm(String.valueOf(dcd[i6]), k6 + 1, i7 + 10, 1, 0xffff00);
            if(super.anb > k6 && super.anb < k6 + 48 && super.anc > i7 && super.anc < i7 + 32)
                cgm.bdm(e.ekj[dcc[i6]] + ": @whi@" + e.ekk[dcc[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int l6 = 0; l6 < bmc; l6++)
        {
            int j7 = 9 + byte0 + (l6 % 4) * 49;
            int k7 = 124 + byte1 + (l6 / 4) * 34;
            cgm.bdc(j7, k7, 48, 32, cka + e.ejh[bmd[l6]], e.ejm[bmd[l6]], 0, 0, false);
            if(e.ejj[bmd[l6]] == 0)
                cgm.bdm(String.valueOf(bme[l6]), j7 + 1, k7 + 10, 1, 0xffff00);
            if(super.anb > j7 && super.anb < j7 + 48 && super.anc > k7 && super.anc < k7 + 32)
                cgm.bdm(e.ekj[bmd[l6]] + ": @whi@" + e.ekk[bmd[l6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    private final void bkj()
    {
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 && super.anc < 35)
            cam = 1;
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 - 33 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 33 && super.anc < 35)
        {
            cam = 2;
            cak = (int)(Math.random() * 13D) - 6;
            cal = (int)(Math.random() * 23D) - 11;
        }
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 - 66 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 66 && super.anc < 35)
            cam = 3;
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 - 99 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 99 && super.anc < 35)
            cam = 4;
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 - 132 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 132 && super.anc < 35)
            cam = 5;
        if(cam == 0 && super.anb >= ((j) (cgm)).ban - 35 - 165 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 165 && super.anc < 35)
            cam = 6;
        if(cam != 0 && super.anb >= ((j) (cgm)).ban - 35 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 && super.anc < 26)
            cam = 1;
        if(cam != 0 && cam != 2 && super.anb >= ((j) (cgm)).ban - 35 - 33 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 33 && super.anc < 26)
        {
            cam = 2;
            cak = (int)(Math.random() * 13D) - 6;
            cal = (int)(Math.random() * 23D) - 11;
        }
        if(cam != 0 && super.anb >= ((j) (cgm)).ban - 35 - 66 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 66 && super.anc < 26)
            cam = 3;
        if(cam != 0 && super.anb >= ((j) (cgm)).ban - 35 - 99 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 99 && super.anc < 26)
            cam = 4;
        if(cam != 0 && super.anb >= ((j) (cgm)).ban - 35 - 132 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 132 && super.anc < 26)
            cam = 5;
        if(cam != 0 && super.anb >= ((j) (cgm)).ban - 35 - 165 && super.anc >= 3 && super.anb < ((j) (cgm)).ban - 3 - 165 && super.anc < 26)
            cam = 6;
        if(cam == 1 && (super.anb < ((j) (cgm)).ban - 248 || super.anc > 36 + (bnh / 5) * 34))
            cam = 0;
        if(cam == 3 && (super.anb < ((j) (cgm)).ban - 199 || super.anc > 316))
            cam = 0;
        if((cam == 2 || cam == 4 || cam == 5) && (super.anb < ((j) (cgm)).ban - 199 || super.anc > 240))
            cam = 0;
        if(cam == 6 && (super.anb < ((j) (cgm)).ban - 199 || super.anc > 311))
            cam = 0;
    }

    private final void bkk()
    {
        if(cdg == 0)
            return;
        if(cfm > 450)
        {
            bhf("@cya@You can't logout during combat!", 3);
            return;
        }
        if(cfm > 0)
        {
            bhf("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.dkd.bgl(167);
            super.dkd.bgm();
            cij = 1000;
            return;
        }
    }

    private final void bkl(String arg0)
    {
        if(cne == null)
            return;
        if(cmc)
        {
            return;
        } else
        {
            cne.bfc(cnk, t.ani(arg0 + ".pcm", cnk), t.anj(arg0 + ".pcm", cnk));
            return;
        }
    }

    private final void bkm()
    {
        if(cdb >= 0 || bmi >= 0)
        {
            cig[bna] = "Cancel";
            cen[bna] = "";
            bmg[bna] = 4000;
            bna++;
        }
        for(int l = 0; l < bna; l++)
            cnl[l] = l;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int i1 = 0; i1 < bna - 1; i1++)
            {
                int k1 = cnl[i1];
                int i2 = cnl[i1 + 1];
                if(bmg[k1] > bmg[i2])
                {
                    cnl[i1] = i2;
                    cnl[i1 + 1] = k1;
                    flag = false;
                }
            }

        }

        if(bna > 20)
            bna = 20;
        if(bna > 0)
        {
            int j1 = -1;
            for(int l1 = 0; l1 < bna; l1++)
            {
                if(cen[cnl[l1]] == null || cen[cnl[l1]].length() <= 0)
                    continue;
                j1 = l1;
                break;
            }

            String s1 = null;
            if((bmi >= 0 || cdb >= 0) && bna == 1)
                s1 = "Choose a target";
            else
            if((bmi >= 0 || cdb >= 0) && bna > 1)
                s1 = "@whi@" + cig[cnl[0]] + " " + cen[cnl[0]];
            else
            if(j1 != -1)
                s1 = cen[cnl[j1]] + ": @whi@" + cig[cnl[0]];
            if(bna == 2 && s1 != null)
                s1 = s1 + "@whi@ / 1 more option";
            if(bna > 2 && s1 != null)
                s1 = s1 + "@whi@ / " + (bna - 1) + " more options";
            if(s1 != null)
                cgm.bdm(s1, 6, 14, 1, 0xffff00);
            if(!ckf && cgl == 1 || ckf && cgl == 1 && bna == 1)
            {
                bji(cnl[0]);
                cgl = 0;
                return;
            }
            if(!ckf && cgl == 2 || ckf && cgl == 1)
            {
                bmn = (bna + 1) * 15;
                bmm = cgm.bee("Choose option", 1) + 5;
                for(int j2 = 0; j2 < bna; j2++)
                {
                    int k2 = cgm.bee(cig[j2] + " " + cen[j2], 1) + 5;
                    if(k2 > bmm)
                        bmm = k2;
                }

                bmk = super.anb - bmm / 2;
                bml = super.anc - 7;
                cmd = true;
                if(bmk < 0)
                    bmk = 0;
                if(bml < 0)
                    bml = 0;
                if(bmk + bmm > 510)
                    bmk = 510 - bmm;
                if(bml + bmn > 315)
                    bml = 315 - bmn;
                cgl = 0;
            }
        }
    }

    protected final Socket bkn(String arg0, int arg1)
        throws IOException
    {
        if(link.dhm != null)
        {
            Socket socket = link.cai(arg1);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(ahn())
            socket1 = new Socket(InetAddress.getByName(bmd().getHost()), arg1);
        else
            socket1 = new Socket(InetAddress.getByName(arg0), arg1);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    private final void bla()
    {
        dhc = false;
        cgm.bcj = false;
        cgm.baj();
        if(cnm == 0 || cnm == 1 || cnm == 2 || cnm == 3)
        {
            int l = (cmn * 2) % 3072;
            if(l < 1024)
            {
                cgm.bca(0, 10, cke);
                if(l > 768)
                    cgm.bcc(0, 10, cke + 1, l - 768);
            } else
            if(l < 2048)
            {
                cgm.bca(0, 10, cke + 1);
                if(l > 1792)
                    cgm.bcc(0, 10, cjm + 10, l - 1792);
            } else
            {
                cgm.bca(0, 10, cjm + 10);
                if(l > 2816)
                    cgm.bcc(0, 10, cke, l - 2816);
            }
        }
        if(cnm == 0)
            dgc.aah();
        if(cnm == 1)
            ckk.aah();
        if(cnm == 2)
            bng.aah();
        cgm.bca(0, cha, cjm + 22);
        cgm.bai(cjh, 0, 0);
    }

    private final void blb(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 248;
        cgm.bca(l, 3, cjm + 1);
        for(int i1 = 0; i1 < bnh; i1++)
        {
            int j1 = l + (i1 % 5) * 49;
            int l1 = 36 + (i1 / 5) * 34;
            if(i1 < chg && chj[i1] == 1)
                cgm.bal(j1, l1, 49, 34, 0xff0000, 128);
            else
                cgm.bal(j1, l1, 49, 34, j.bbg(181, 181, 181), 128);
            if(i1 < chg)
            {
                cgm.bdc(j1, l1, 48, 32, cka + e.ejh[chh[i1]], e.ejm[chh[i1]], 0, 0, false);
                if(e.ejj[chh[i1]] == 0)
                    cgm.bdm(String.valueOf(chi[i1]), j1 + 1, l1 + 10, 1, 0xffff00);
            }
        }

        for(int k1 = 1; k1 <= 4; k1++)
            cgm.bbc(l + k1 * 49, 36, (bnh / 5) * 34, 0);

        for(int i2 = 1; i2 <= bnh / 5 - 1; i2++)
            cgm.bbb(l, 36 + i2 * 34, 245, 0);

        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 248);
        int j2 = super.anc - 36;
        if(l >= 0 && j2 >= 0 && l < 248 && j2 < (bnh / 5) * 34)
        {
            int k2 = l / 49 + (j2 / 34) * 5;
            if(k2 < chg)
            {
                int l2 = chh[k2];
                if(cdb >= 0)
                {
                    if(e.faf[cdb] == 3)
                    {
                        cig[bna] = "Cast " + e.elb[cdb] + " on";
                        cen[bna] = "@lre@" + e.ekj[l2];
                        bmg[bna] = 600;
                        dfa[bna] = k2;
                        dfb[bna] = cdb;
                        bna++;
                        return;
                    }
                } else
                {
                    if(bmi >= 0)
                    {
                        cig[bna] = "Use " + bmj + " with";
                        cen[bna] = "@lre@" + e.ekj[l2];
                        bmg[bna] = 610;
                        dfa[bna] = k2;
                        dfb[bna] = bmi;
                        bna++;
                        return;
                    }
                    if(chj[k2] == 1)
                    {
                        cig[bna] = "Remove";
                        cen[bna] = "@lre@" + e.ekj[l2];
                        bmg[bna] = 620;
                        dfa[bna] = k2;
                        bna++;
                    } else
                    if(e.ejl[l2] != 0)
                    {
                        if((e.ejl[l2] & 0x18) != 0)
                            cig[bna] = "Wield";
                        else
                            cig[bna] = "Wear";
                        cen[bna] = "@lre@" + e.ekj[l2];
                        bmg[bna] = 630;
                        dfa[bna] = k2;
                        bna++;
                    }
                    if(!e.ekl[l2].equals(""))
                    {
                        cig[bna] = e.ekl[l2];
                        cen[bna] = "@lre@" + e.ekj[l2];
                        bmg[bna] = 640;
                        dfa[bna] = k2;
                        bna++;
                    }
                    cig[bna] = "Use";
                    cen[bna] = "@lre@" + e.ekj[l2];
                    bmg[bna] = 650;
                    dfa[bna] = k2;
                    bna++;
                    cig[bna] = "Drop";
                    cen[bna] = "@lre@" + e.ekj[l2];
                    bmg[bna] = 660;
                    dfa[bna] = k2;
                    bna++;
                    cig[bna] = "Examine";
                    cen[bna] = "@lre@" + e.ekj[l2];
                    bmg[bna] = 3600;
                    dfa[bna] = l2;
                    bna++;
                }
            }
        }
    }

    private final void blc(int arg0, int arg1, int arg2)
    {
        cgm.bbd(arg0, arg1, arg2);
        cgm.bbd(arg0 - 1, arg1, arg2);
        cgm.bbd(arg0 + 1, arg1, arg2);
        cgm.bbd(arg0, arg1 - 1, arg2);
        cgm.bbd(arg0, arg1 + 1, arg2);
    }

    private final void bld()
    {
        byte abyte0[] = bil("config" + w.bie + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            dff = true;
            return;
        }
        e.cjn(abyte0, dek);
        byte abyte1[] = bil("filter" + w.bil + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            dff = true;
            return;
        } else
        {
            byte abyte2[] = t.ank("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = t.ank("badenc.txt", 0, abyte1);
            byte abyte4[] = t.ank("hostenc.txt", 0, abyte1);
            byte abyte5[] = t.ank("tldlist.txt", 0, abyte1);
            u.akf(new q(abyte2), new q(abyte3), new q(abyte4), new q(abyte5));
            return;
        }
    }

    private final void ble()
    {
        if(cgl != 0)
        {
            cgl = 0;
            if(caj == 1 && (super.anb < 106 || super.anc < 145 || super.anb > 406 || super.anc > 215))
            {
                caj = 0;
                return;
            }
            if(caj == 2 && (super.anb < 6 || super.anc < 145 || super.anb > 506 || super.anc > 215))
            {
                caj = 0;
                return;
            }
            if(caj == 3 && (super.anb < 106 || super.anc < 145 || super.anb > 406 || super.anc > 215))
            {
                caj = 0;
                return;
            }
            if(super.anb > 236 && super.anb < 276 && super.anc > 193 && super.anc < 213)
            {
                caj = 0;
                return;
            }
        }
        int l = 145;
        if(caj == 1)
        {
            cgm.ban(106, l, 300, 70, 0);
            cgm.bba(106, l, 300, 70, 0xffffff);
            l += 20;
            cgm.bdk("Enter name to add to friends list", 256, l, 4, 0xffffff);
            l += 20;
            cgm.bdk(super.ani + "*", 256, l, 4, 0xffffff);
            if(super.anj.length() > 0)
            {
                String s1 = super.anj.trim();
                super.ani = "";
                super.anj = "";
                caj = 0;
                if(s1.length() > 0 && t.ang(s1) != ccl.dma)
                    cce(s1);
            }
        }
        if(caj == 2)
        {
            cgm.ban(6, l, 500, 70, 0);
            cgm.bba(6, l, 500, 70, 0xffffff);
            l += 20;
            cgm.bdk("Enter message to send to " + t.anh(ddg), 256, l, 4, 0xffffff);
            l += 20;
            cgm.bdk(super.ank + "*", 256, l, 4, 0xffffff);
            if(super.anl.length() > 0)
            {
                String s2 = super.anl;
                super.ank = "";
                super.anl = "";
                caj = 0;
                int j1 = v.aeh(s2);
                ccg(ddg, v.aeh, j1);
                s2 = v.aeg(v.aeh, 0, j1);
                s2 = u.akl(s2);
                cdb("@pri@You tell " + t.anh(ddg) + ": " + s2);
            }
        }
        if(caj == 3)
        {
            cgm.ban(106, l, 300, 70, 0);
            cgm.bba(106, l, 300, 70, 0xffffff);
            l += 20;
            cgm.bdk("Enter name to add to ignore list", 256, l, 4, 0xffffff);
            l += 20;
            cgm.bdk(super.ani + "*", 256, l, 4, 0xffffff);
            if(super.anj.length() > 0)
            {
                String s3 = super.anj.trim();
                super.ani = "";
                super.anj = "";
                caj = 0;
                if(s3.length() > 0 && t.ang(s3) != ccl.dma)
                    ccc(s3);
            }
        }
        int i1 = 0xffffff;
        if(super.anb > 236 && super.anb < 276 && super.anc > 193 && super.anc < 213)
            i1 = 0xffff00;
        cgm.bdk("Cancel", 256, 208, 1, i1);
    }

    private final void blf(int arg0, String arg1)
    {
        int l = dgf[arg0];
        int i1 = dgg[arg0];
        int j1 = l - ccl.dme / 128;
        int k1 = i1 - ccl.dmf / 128;
        byte byte0 = 7;
        if(l >= 0 && i1 >= 0 && l < 96 && i1 < 96 && j1 > -byte0 && j1 < byte0 && k1 > -byte0 && k1 < byte0)
        {
            cch.cdk(cec[arg0]);
            int l1 = e.cji(arg1);
            i i2 = dda[l1].ahc();
            cch.cdj(i2);
            i2.afl(true, 48, 48, -50, -10, -50);
            i2.ahe(cec[arg0]);
            i2.agn = arg0;
            cec[arg0] = i2;
        }
    }

    private final void blg(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 199;
        int i1 = 36;
        cgm.bca(l - 49, 3, cjm + 4);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.bbg(160, 160, 160);
        if(chf == 0)
            j1 = j.bbg(220, 220, 220);
        else
            k1 = j.bbg(220, 220, 220);
        cgm.bal(l, i1, c1 / 2, 24, j1, 128);
        cgm.bal(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        cgm.bal(l, i1 + 24, c1, 90, j.bbg(220, 220, 220), 128);
        cgm.bal(l, i1 + 24 + 90, c1, c2 - 90 - 24, j.bbg(160, 160, 160), 128);
        cgm.bbb(l, i1 + 24, c1, 0);
        cgm.bbc(l + c1 / 2, i1, 24, 0);
        cgm.bbb(l, i1 + 113, c1, 0);
        cgm.bdk("Magic", l + c1 / 4, i1 + 16, 4, 0);
        cgm.bdk("Prayers", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(chf == 0)
        {
            chd.acc(che);
            int l1 = 0;
            for(int l2 = 0; l2 < e.enc; l2++)
            {
                String s1 = "@yel@";
                for(int k4 = 0; k4 < e.fae[l2]; k4++)
                {
                    int j5 = e.fag[l2][k4];
                    if(bni(j5, e.fah[l2][k4]))
                        continue;
                    s1 = "@whi@";
                    break;
                }

                int k5 = bnd[6];
                if(e.fad[l2] > k5)
                    s1 = "@bla@";
                chd.ace(che, l1++, s1 + "Level " + e.fad[l2] + ": " + e.elb[l2]);
            }

            chd.aah();
            int l3 = chd.acl(che);
            if(l3 != -1)
            {
                cgm.bdm("Level " + e.fad[l3] + ": " + e.elb[l3], l + 2, i1 + 124, 1, 0xffff00);
                cgm.bdm(e.elc[l3], l + 2, i1 + 136, 0, 0xffffff);
                for(int l4 = 0; l4 < e.fae[l3]; l4++)
                {
                    int l5 = e.fag[l3][l4];
                    cgm.bca(l + 2 + l4 * 44, i1 + 150, cka + e.ejh[l5]);
                    int i6 = bmc(l5);
                    int j6 = e.fah[l3][l4];
                    String s3 = "@red@";
                    if(bni(l5, j6))
                        s3 = "@gre@";
                    cgm.bdm(s3 + i6 + "/" + j6, l + 2 + l4 * 44, i1 + 150, 1, 0xffffff);
                }

            } else
            {
                cgm.bdm("Point at a spell for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(chf == 1)
        {
            chd.acc(che);
            int i2 = 0;
            for(int i3 = 0; i3 < e.eje; i3++)
            {
                String s2 = "@whi@";
                if(e.eke[i3] > ckg[5])
                    s2 = "@bla@";
                if(dgn[i3])
                    s2 = "@gre@";
                chd.ace(che, i2++, s2 + "Level " + e.eke[i3] + ": " + e.emc[i3]);
            }

            chd.aah();
            int i4 = chd.acl(che);
            if(i4 != -1)
            {
                cgm.bdk("Level " + e.eke[i4] + ": " + e.emc[i4], l + c1 / 2, i1 + 130, 1, 0xffff00);
                cgm.bdk(e.emd[i4], l + c1 / 2, i1 + 145, 0, 0xffffff);
                cgm.bdk("Drain rate: " + e.ekf[i4], l + c1 / 2, i1 + 160, 1, 0);
            } else
            {
                cgm.bdm("Point at a prayer for a description", l + 2, i1 + 124, 1, 0);
            }
        }
        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 199);
        i1 = super.anc - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            chd.aae(l + (((j) (cgm)).ban - 199), i1 + 36, super.ane, super.and);
            if(i1 <= 24 && cgl == 1)
                if(l < 98 && chf == 1)
                {
                    chf = 0;
                    chd.acd(che);
                } else
                if(l > 98 && chf == 0)
                {
                    chf = 1;
                    chd.acd(che);
                }
            if(cgl == 1 && chf == 0)
            {
                int j2 = chd.acl(che);
                if(j2 != -1)
                {
                    int j3 = bnd[6];
                    if(e.fad[j2] > j3)
                    {
                        bhf("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int j4;
                        for(j4 = 0; j4 < e.fae[j2]; j4++)
                        {
                            int i5 = e.fag[j2][j4];
                            if(bni(i5, e.fah[j2][j4]))
                                continue;
                            bhf("You don't have all the reagents you need for this spell", 3);
                            j4 = -1;
                            break;
                        }

                        if(j4 == e.fae[j2])
                        {
                            cdb = j2;
                            bmi = -1;
                        }
                    }
                }
            }
            if(cgl == 1 && chf == 1)
            {
                int k2 = chd.acl(che);
                if(k2 != -1)
                {
                    int k3 = ckg[5];
                    if(e.eke[k2] > k3)
                        bhf("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(bnd[5] == 0)
                        bhf("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(dgn[k2])
                    {
                        super.dkd.bgl(177);
                        super.dkd.bfj(k2);
                        super.dkd.bgm();
                        dgn[k2] = false;
                        bkl("prayeroff");
                    } else
                    {
                        super.dkd.bgl(150);
                        super.dkd.bfj(k2);
                        super.dkd.bgm();
                        dgn[k2] = true;
                        bkl("prayeron");
                    }
                }
            }
            cgl = 0;
        }
    }

    private final void blh()
    {
        byte byte0 = 7;
        byte byte1 = 15;
        char c1 = '\257';
        if(cgl != 0)
        {
            for(int l = 0; l < 5; l++)
            {
                if(l <= 0 || super.anb <= byte0 || super.anb >= byte0 + c1 || super.anc <= byte1 + l * 20 || super.anc >= byte1 + l * 20 + 20)
                    continue;
                ckl = l - 1;
                cgl = 0;
                super.dkd.bgl(165);
                super.dkd.bfj(ckl);
                super.dkd.bgm();
                break;
            }

        }
        for(int i1 = 0; i1 < 5; i1++)
        {
            if(i1 == ckl + 1)
                cgm.bal(byte0, byte1 + i1 * 20, c1, 20, j.bbg(255, 0, 0), 128);
            else
                cgm.bal(byte0, byte1 + i1 * 20, c1, 20, j.bbg(190, 190, 190), 128);
            cgm.bbb(byte0, byte1 + i1 * 20, c1, 0);
            cgm.bbb(byte0, byte1 + i1 * 20 + 20, c1, 0);
        }

        cgm.bdk("Select combat style", byte0 + c1 / 2, byte1 + 16, 3, 0xffffff);
        cgm.bdk("Controlled (+1 of each)", byte0 + c1 / 2, byte1 + 36, 3, 0);
        cgm.bdk("Aggressive (+3 strength)", byte0 + c1 / 2, byte1 + 56, 3, 0);
        cgm.bdk("Accurate   (+3 attack)", byte0 + c1 / 2, byte1 + 76, 3, 0);
        cgm.bdk("Defensive  (+3 defense)", byte0 + c1 / 2, byte1 + 96, 3, 0);
    }

    private final void bli(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 199;
        char c1 = '\234';
        char c3 = '\230';
        cgm.bca(l - 49, 3, cjm + 2);
        l += 40;
        cgm.ban(l, 36, c1, c3, 0);
        cgm.bag(l, 36, l + c1, 36 + c3);
        int j1 = 192 + cal;
        int l1 = cii + cak & 0xff;
        int j2 = ((ccl.dme - 6040) * 3 * j1) / 2048;
        int l3 = ((ccl.dmf - 6040) * 3 * j1) / 2048;
        int j5 = n.ebd[1024 - l1 * 4 & 0x3ff];
        int l5 = n.ebd[(1024 - l1 * 4 & 0x3ff) + 1024];
        int j6 = l3 * j5 + j2 * l5 >> 18;
        l3 = l3 * l5 - j2 * j5 >> 18;
        j2 = j6;
        cgm.bcm((l + c1 / 2) - j2, 36 + c3 / 2 + l3, cjm - 1, l1 + 64 & 0xff, j1);
        for(int l7 = 0; l7 < cfa; l7++)
        {
            int k2 = (((dgf[l7] * cdf + 64) - ccl.dme) * 3 * j1) / 2048;
            int i4 = (((dgg[l7] * cdf + 64) - ccl.dmf) * 3 * j1) / 2048;
            int k6 = i4 * j5 + k2 * l5 >> 18;
            i4 = i4 * l5 - k2 * j5 >> 18;
            k2 = k6;
            blc(l + c1 / 2 + k2, (36 + c3 / 2) - i4, 65535);
        }

        for(int i8 = 0; i8 < dhg; i8++)
        {
            int l2 = (((cng[i8] * cdf + 64) - ccl.dme) * 3 * j1) / 2048;
            int j4 = (((cnh[i8] * cdf + 64) - ccl.dmf) * 3 * j1) / 2048;
            int l6 = j4 * j5 + l2 * l5 >> 18;
            j4 = j4 * l5 - l2 * j5 >> 18;
            l2 = l6;
            blc(l + c1 / 2 + l2, (36 + c3 / 2) - j4, 0xff0000);
        }

        for(int j8 = 0; j8 < cae; j8++)
        {
            f f1 = cnf[j8];
            int i3 = ((f1.dme - ccl.dme) * 3 * j1) / 2048;
            int k4 = ((f1.dmf - ccl.dmf) * 3 * j1) / 2048;
            int i7 = k4 * j5 + i3 * l5 >> 18;
            k4 = k4 * l5 - i3 * j5 >> 18;
            i3 = i7;
            blc(l + c1 / 2 + i3, (36 + c3 / 2) - k4, 0xffff00);
        }

        for(int k8 = 0; k8 < cmf; k8++)
        {
            f f2 = bln[k8];
            int j3 = ((f2.dme - ccl.dme) * 3 * j1) / 2048;
            int l4 = ((f2.dmf - ccl.dmf) * 3 * j1) / 2048;
            int j7 = l4 * j5 + j3 * l5 >> 18;
            l4 = l4 * l5 - j3 * j5 >> 18;
            j3 = j7;
            int i9 = 0xffffff;
            for(int j9 = 0; j9 < super.dkh; j9++)
            {
                if(f2.dma != super.dki[j9] || super.dkj[j9] != 99)
                    continue;
                i9 = 65280;
                break;
            }

            blc(l + c1 / 2 + j3, (36 + c3 / 2) - l4, i9);
        }

        cgm.bak(l + c1 / 2, 36 + c3 / 2, 2, 0xffffff, 255);
        cgm.bcm(l + 19, 55, cjm + 24, cii + 128 & 0xff, 128);
        cgm.bag(0, 0, cgn, cha + 12);
        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 199);
        int l8 = super.anc - 36;
        if(l >= 40 && l8 >= 0 && l < 196 && l8 < 152)
        {
            char c2 = '\234';
            char c4 = '\230';
            int k1 = 192 + cal;
            int i2 = cii + cak & 0xff;
            int i1 = ((j) (cgm)).ban - 199;
            i1 += 40;
            int k3 = ((super.anb - (i1 + c2 / 2)) * 16384) / (3 * k1);
            int i5 = ((super.anc - (36 + c4 / 2)) * 16384) / (3 * k1);
            int k5 = n.ebd[1024 - i2 * 4 & 0x3ff];
            int i6 = n.ebd[(1024 - i2 * 4 & 0x3ff) + 1024];
            int k7 = i5 * k5 + k3 * i6 >> 15;
            i5 = i5 * i6 - k3 * k5 >> 15;
            k3 = k7;
            k3 += ccl.dme;
            i5 = ccl.dmf - i5;
            if(cgl == 1)
                bjc(ccm, ccn, k3 / 128, i5 / 128, false);
            cgl = 0;
        }
    }

    private final void blj()
    {
        int l = 65;
        if(cln != 201)
            l += 60;
        if(dec > 0)
            l += 60;
        if(cnd != 0)
            l += 45;
        int i1 = 167 - l / 2;
        cgm.ban(56, 167 - l / 2, 400, l, 0);
        cgm.bba(56, 167 - l / 2, 400, l, 0xffffff);
        i1 += 20;
        cgm.bdk("Welcome to RuneScape " + dea, 256, i1, 4, 0xffff00);
        i1 += 30;
        String s1;
        if(cdj == 0)
            s1 = "earlier today";
        else
        if(cdj == 1)
            s1 = "yesterday";
        else
            s1 = cdj + " days ago";
        if(cnd != 0)
        {
            cgm.bdk("You last logged in " + s1, 256, i1, 1, 0xffffff);
            i1 += 15;
            if(dfk == null)
                dfk = bia(cnd);
            cgm.bdk("from: " + dfk, 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(dec > 0)
        {
            int j1 = 0xffffff;
            cgm.bdk("Jagex staff will NEVER email you. We use the", 256, i1, 1, j1);
            i1 += 15;
            cgm.bdk("message-centre on this website instead.", 256, i1, 1, j1);
            i1 += 15;
            if(dec == 1)
                cgm.bdk("You have @yel@0@whi@ unread messages in your message-centre", 256, i1, 1, 0xffffff);
            else
                cgm.bdk("You have @gre@" + (dec - 1) + " unread messages @whi@in your message-centre", 256, i1, 1, 0xffffff);
            i1 += 15;
            i1 += 15;
        }
        if(cln != 201)
        {
            if(cln == 200)
            {
                cgm.bdk("You have not yet set any password recovery questions.", 256, i1, 1, 0xff8000);
                i1 += 15;
                cgm.bdk("We strongly recommend you do so now to secure your account.", 256, i1, 1, 0xff8000);
                i1 += 15;
                cgm.bdk("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            } else
            {
                String s2;
                if(cln == 0)
                    s2 = "Earlier today";
                else
                if(cln == 1)
                    s2 = "Yesterday";
                else
                    s2 = cln + " days ago";
                cgm.bdk(s2 + " you changed your recovery questions", 256, i1, 1, 0xff8000);
                i1 += 15;
                cgm.bdk("If you do not remember making this change then cancel it immediately", 256, i1, 1, 0xff8000);
                i1 += 15;
                cgm.bdk("Do this from the 'account management' area on our front webpage", 256, i1, 1, 0xff8000);
                i1 += 15;
            }
            i1 += 15;
        }
        int k1 = 0xffffff;
        if(super.anc > i1 - 12 && super.anc <= i1 && super.anb > 106 && super.anb < 406)
            k1 = 0xff0000;
        cgm.bdk("Click here to close window", 256, i1, 1, k1);
        if(cgl == 1)
        {
            if(k1 == 0xff0000)
                dcl = false;
            if((super.anb < 86 || super.anb > 426) && (super.anc < 167 - l / 2 || super.anc > 167 + l / 2))
                dcl = false;
        }
        cgl = 0;
    }

    private final void blk()
    {
        try
        {
            if(cgm != null)
            {
                cgm.bbh();
                cgm.bbf = null;
                cgm = null;
            }
            if(cch != null)
            {
                cch.cdl();
                cch = null;
            }
            dda = null;
            cec = null;
            cem = null;
            cme = null;
            bln = null;
            ddc = null;
            cnf = null;
            ccl = null;
            if(bmf != null)
            {
                bmf.ehi = null;
                bmf.ehe = null;
                bmf.ehf = null;
                bmf.eii = null;
                bmf = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private final i bll(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        int l = arg0;
        int i1 = arg1;
        int j1 = arg0;
        int k1 = arg1;
        int l1 = e.elh[arg3];
        int i2 = e.eli[arg3];
        int j2 = e.elg[arg3];
        i k2 = new i(4, 1);
        if(arg2 == 0)
            j1 = arg0 + 1;
        if(arg2 == 1)
            k1 = arg1 + 1;
        if(arg2 == 2)
        {
            l = arg0 + 1;
            k1 = arg1 + 1;
        }
        if(arg2 == 3)
        {
            j1 = arg0 + 1;
            k1 = arg1 + 1;
        }
        l *= cdf;
        i1 *= cdf;
        j1 *= cdf;
        k1 *= cdf;
        int l2 = k2.afg(l, -bmf.cia(l, i1), i1);
        int i3 = k2.afg(l, -bmf.cia(l, i1) - j2, i1);
        int j3 = k2.afg(j1, -bmf.cia(j1, k1) - j2, k1);
        int k3 = k2.afg(j1, -bmf.cia(j1, k1), k1);
        int ai[] = {
            l2, i3, j3, k3
        };
        k2.afi(4, ai, l1, i2);
        k2.afl(false, 60, 24, -50, -10, -50);
        if(arg0 >= 0 && arg1 >= 0 && arg0 < 96 && arg1 < 96)
            cch.cdj(k2);
        k2.agn = arg4 + 10000;
        return k2;
    }

    private final void blm()
    {
        cgm.bca(0, cha - 4, cjm + 23);
        int l = j.bbg(200, 200, 255);
        if(dcj == 0)
            l = j.bbg(255, 200, 50);
        if(dhh % 30 > 15)
            l = j.bbg(255, 50, 50);
        cgm.bdk("All messages", 54, cha + 6, 0, l);
        l = j.bbg(200, 200, 255);
        if(dcj == 1)
            l = j.bbg(255, 200, 50);
        if(dhi % 30 > 15)
            l = j.bbg(255, 50, 50);
        cgm.bdk("Chat history", 155, cha + 6, 0, l);
        l = j.bbg(200, 200, 255);
        if(dcj == 2)
            l = j.bbg(255, 200, 50);
        if(dhj % 30 > 15)
            l = j.bbg(255, 50, 50);
        cgm.bdk("Quest history", 255, cha + 6, 0, l);
        l = j.bbg(200, 200, 255);
        if(dcj == 3)
            l = j.bbg(255, 200, 50);
        if(dhk % 30 > 15)
            l = j.bbg(255, 50, 50);
        cgm.bdk("Private history", 355, cha + 6, 0, l);
        cgm.bdk("Report abuse", 457, cha + 6, 0, 0xffffff);
    }

    private final void bln()
    {
        byte abyte0[] = bil("textures" + w.bii + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            dff = true;
            return;
        }
        byte abyte1[] = t.ank("index.dat", 0, abyte0);
        cch.cgb(e.eml, 7, 11);
        for(int l = 0; l < e.eml; l++)
        {
            String s1 = e.ele[l];
            byte abyte2[] = t.ank(s1 + ".dat", 0, abyte0);
            cgm.bbi(ckc, abyte2, abyte1, 1);
            cgm.ban(0, 0, 128, 128, 0xff00ff);
            cgm.bca(0, 0, ckc);
            int i1 = ((j) (cgm)).bcc[ckc];
            String s2 = e.elf[l];
            if(s2 != null && s2.length() > 0)
            {
                byte abyte3[] = t.ank(s2 + ".dat", 0, abyte0);
                cgm.bbi(ckc, abyte3, abyte1, 1);
                cgm.bca(0, 0, ckc);
            }
            cgm.bbn(ckd + l, 0, 0, i1, i1);
            int j1 = i1 * i1;
            for(int k1 = 0; k1 < j1; k1++)
                if(((j) (cgm)).bbj[ckd + l][k1] == 65280)
                    ((j) (cgm)).bbj[ckd + l][k1] = 0xff00ff;

            cgm.bbk(ckd + l);
            cch.cgc(l, ((j) (cgm)).bbk[ckd + l], ((j) (cgm)).bbl[ckd + l], i1 / 64 - 1);
        }

    }

    public final String bma(String arg0)
    {
        if(link.dhm != null)
            return link.dhm.getParameter(arg0);
        else
            return super.getParameter(arg0);
    }

    private final void bmb(int arg0, int arg1, int arg2, int arg3)
    {
        int l;
        int i1;
        if(arg2 == 0 || arg2 == 4)
        {
            l = e.enl[arg3];
            i1 = e.enm[arg3];
        } else
        {
            i1 = e.enl[arg3];
            l = e.enm[arg3];
        }
        if(e.enn[arg3] == 2 || e.enn[arg3] == 3)
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
            bjj(ccm, ccn, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, false, true);
            return;
        } else
        {
            bjj(ccm, ccn, arg0, arg1, (arg0 + l) - 1, (arg1 + i1) - 1, true, true);
            return;
        }
    }

    private final int bmc(int arg0)
    {
        int l = 0;
        for(int i1 = 0; i1 < chg; i1++)
            if(chh[i1] == arg0)
                if(e.ejj[arg0] == 1)
                    l++;
                else
                    l += chi[i1];

        return l;
    }

    public final URL bmd()
    {
	try 
	{ 
	return new URL("http://" + super.djn + "/client2/"); 
	} 
	catch(Exception e) {return null;} 
    }

    protected final void cdb(String arg0)
    {
        if(arg0.startsWith("@bor@"))
        {
            bhf(arg0, 4);
            return;
        }
        if(arg0.startsWith("@que@"))
        {
            bhf("@whi@" + arg0, 5);
            return;
        }
        if(arg0.startsWith("@pri@"))
        {
            bhf(arg0, 6);
            return;
        } else
        {
            bhf(arg0, 3);
            return;
        }
    }

    protected final void bmf(int arg0)
    {
        if(cdg == 0)
        {
            if(cnm == 0)
                dgc.aag(arg0);
            if(cnm == 1)
                ckk.aag(arg0);
            if(cnm == 2)
                bng.aag(arg0);
        }
        if(cdg == 1)
        {
            if(cbj)
            {
                dfg.aag(arg0);
                return;
            }
            if(caj == 0 && cei == 0 && !ddb)
                dce.aag(arg0);
        }
    }

    protected final void cbk()
    {
        bmb = 0;
        if(cij != 0)
        {
            ccm();
            return;
        } else
        {
            super.cbk();
            return;
        }
    }

    private final void bmh()
    {
        if(cih != 0)
        {
            cgm.bbe();
            cgm.bdk("Oh dear! You are dead...", cgn / 2, cha / 2, 7, 0xff0000);
            blm();
            cgm.bai(cjh, 0, 0);
            return;
        }
        if(cbj)
        {
            bnk();
            return;
        }
        if(ddb)
        {
            cgm.bbe();
            if(Math.random() < 0.14999999999999999D)
                cgm.bdk("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                cgm.bdk("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            cgm.ban(cgn / 2 - 100, 160, 200, 40, 0);
            cgm.bdk("You are sleeping", cgn / 2, 50, 7, 0xffff00);
            cgm.bdk("Fatigue: " + (dah * 100) / 750 + "%", cgn / 2, 90, 7, 0xffff00);
            cgm.bdk("When you want to wake up just use your", cgn / 2, 140, 5, 0xffffff);
            cgm.bdk("keyboard to type the word in the box below", cgn / 2, 160, 5, 0xffffff);
            cgm.bdk(super.ani + "*", cgn / 2, 180, 5, 65535);
            if(cdc == null)
                cgm.bca(cgn / 2 - 127, 230, ckc + 1);
            else
                cgm.bdk(cdc, cgn / 2, 260, 5, 0xff0000);
            cgm.bba(cgn / 2 - 128, 229, 257, 42, 0xffffff);
            blm();
            cgm.bdk("If you can't read the word", cgn / 2, 290, 1, 0xffffff);
            cgm.bdk("@yel@click here@whi@ to get a different one", cgn / 2, 305, 1, 0xffffff);
            cgm.bai(cjh, 0, 0);
            return;
        }
        if(!bmf.ehm)
            return;
        for(int l = 0; l < 64; l++)
        {
            cch.cdk(bmf.ehf[dgm][l]);
            if(dgm == 0)
            {
                cch.cdk(bmf.ehe[1][l]);
                cch.cdk(bmf.ehf[1][l]);
                cch.cdk(bmf.ehe[2][l]);
                cch.cdk(bmf.ehf[2][l]);
            }
            cld = true;
            if(dgm == 0 && (bmf.ehj[ccl.dme / 128][ccl.dmf / 128] & 0x80) == 0)
            {
                cch.cdj(bmf.ehf[dgm][l]);
                if(dgm == 0)
                {
                    cch.cdj(bmf.ehe[1][l]);
                    cch.cdj(bmf.ehf[1][l]);
                    cch.cdj(bmf.ehe[2][l]);
                    cch.cdj(bmf.ehf[2][l]);
                }
                cld = false;
            }
        }

        if(ccb != cic)
        {
            cic = ccb;
            for(int i1 = 0; i1 < cfa; i1++)
            {
                if(dgh[i1] == 97)
                    blf(i1, "firea" + (ccb + 1));
                if(dgh[i1] == 274)
                    blf(i1, "fireplacea" + (ccb + 1));
                if(dgh[i1] == 1031)
                    blf(i1, "lightning" + (ccb + 1));
                if(dgh[i1] == 1036)
                    blf(i1, "firespell" + (ccb + 1));
                if(dgh[i1] == 1147)
                    blf(i1, "spellcharge" + (ccb + 1));
            }

        }
        if(ccc != cid)
        {
            cid = ccc;
            for(int j1 = 0; j1 < cfa; j1++)
            {
                if(dgh[j1] == 51)
                    blf(j1, "torcha" + (ccc + 1));
                if(dgh[j1] == 143)
                    blf(j1, "skulltorcha" + (ccc + 1));
            }

        }
        if(ccd != cie)
        {
            cie = ccd;
            for(int k1 = 0; k1 < cfa; k1++)
                if(dgh[k1] == 1142)
                    blf(k1, "clawspell" + (ccd + 1));

        }
        cch.cdn(cmh);
        cmh = 0;
        for(int l1 = 0; l1 < cmf; l1++)
        {
            f f1 = bln[l1];
            if(f1.dnm != 255)
            {
                int j2 = f1.dme;
                int l2 = f1.dmf;
                int j3 = -bmf.cia(j2, l2);
                int k4 = cch.cea(5000 + l1, j2, j3, l2, 145, 220, l1 + 10000);
                cmh++;
                if(f1 == ccl)
                    cch.ceb(k4);
                if(f1.dmi == 8)
                    cch.cec(k4, -30);
                if(f1.dmi == 9)
                    cch.cec(k4, 30);
            }
        }

        for(int i2 = 0; i2 < cmf; i2++)
        {
            f f2 = bln[i2];
            if(f2.ead > 0)
            {
                f f3 = null;
                if(f2.eac != -1)
                    f3 = ddc[f2.eac];
                else
                if(f2.eab != -1)
                    f3 = cme[f2.eab];
                if(f3 != null)
                {
                    int k3 = f2.dme;
                    int l4 = f2.dmf;
                    int k7 = -bmf.cia(k3, l4) - 110;
                    int k9 = f3.dme;
                    int j10 = f3.dmf;
                    int k10 = -bmf.cia(k9, j10) - e.emf[f3.dmg] / 2;
                    int l10 = (k3 * f2.ead + k9 * (cej - f2.ead)) / cej;
                    int i11 = (k7 * f2.ead + k10 * (cej - f2.ead)) / cej;
                    int j11 = (l4 * f2.ead + j10 * (cej - f2.ead)) / cej;
                    cch.cea(ckb + f2.eaa, l10, i11, j11, 32, 32, 0);
                    cmh++;
                }
            }
        }

        for(int k2 = 0; k2 < cae; k2++)
        {
            f f4 = cnf[k2];
            int l3 = f4.dme;
            int i5 = f4.dmf;
            int l7 = -bmf.cia(l3, i5);
            int l9 = cch.cea(20000 + k2, l3, l7, i5, e.eme[f4.dmg], e.emf[f4.dmg], k2 + 30000);
            cmh++;
            if(f4.dmi == 8)
                cch.cec(l9, -30);
            if(f4.dmi == 9)
                cch.cec(l9, 30);
        }

        for(int i3 = 0; i3 < dhg; i3++)
        {
            int i4 = cng[i3] * cdf + 64;
            int j5 = cnh[i3] * cdf + 64;
            cch.cea(40000 + cni[i3], i4, -bmf.cia(i4, j5) - cnj[i3], j5, 96, 64, i3 + 20000);
            cmh++;
        }

        for(int j4 = 0; j4 < cad; j4++)
        {
            int k5 = ddi[j4] * cdf + 64;
            int i8 = cgd[j4] * cdf + 64;
            int i10 = cfl[j4];
            if(i10 == 0)
            {
                cch.cea(50000 + j4, k5, -bmf.cia(k5, i8), i8, 128, 256, j4 + 50000);
                cmh++;
            }
            if(i10 == 1)
            {
                cch.cea(50000 + j4, k5, -bmf.cia(k5, i8), i8, 128, 64, j4 + 50000);
                cmh++;
            }
        }

        cgm.bcj = false;
        cgm.baj();
        cgm.bcj = super.anh;
        if(dgm == 3)
        {
            int l5 = 40 + (int)(Math.random() * 3D);
            int j8 = 40 + (int)(Math.random() * 7D);
            cch.cgi(l5, j8, -50, -10, -50);
        }
        cfn = 0;
        cna = 0;
        dck = 0;
        if(cji)
        {
            if(ceh && !cld)
            {
                int i6 = cdk;
                bif();
                if(cdk != i6)
                {
                    cbn = ccl.dme;
                    cca = ccl.dmf;
                }
            }
            cch.ean = 3000;
            cch.eba = 3000;
            cch.ebb = 1;
            cch.ebc = 2800;
            cii = cdk * 32;
            int j6 = cbn + cia;
            int k8 = cca + caa;
            cch.cfk(j6, -bmf.cia(j6, k8), k8, 912, cii * 4, 0, 2000);
        } else
        {
            if(ceh && !cld)
                bif();
            if(!super.anh)
            {
                cch.ean = 2400;
                cch.eba = 2400;
                cch.ebb = 1;
                cch.ebc = 2300;
            } else
            {
                cch.ean = 2200;
                cch.eba = 2200;
                cch.ebb = 1;
                cch.ebc = 2100;
            }
            int k6 = cbn + cia;
            int l8 = cca + caa;
            cch.cfk(k6, -bmf.cia(k6, l8), l8, 912, cii * 4, 0, dba * 2);
        }
        cch.cem();
        bmn();
        if(daa > 0)
            cgm.bca(dab - 8, dac - 8, cjm + 14 + (24 - daa) / 6);
        if(daa < 0)
            cgm.bca(dab - 8, dac - 8, cjm + 18 + (24 + daa) / 6);
        if(bmb != 0)
        {
            int l6 = bmb / 50;
            int i9 = l6 / 60;
            l6 %= 60;
            if(l6 < 10)
                cgm.bdk("System update in: " + i9 + ":0" + l6, 256, cha - 7, 1, 0xffff00);
            else
                cgm.bdk("System update in: " + i9 + ":" + l6, 256, cha - 7, 1, 0xffff00);
        }
        if(!bnf)
        {
            int i7 = 2203 - (ccn + dgk + clf);
            if(ccm + dgj + cle >= 2640)
                i7 = -50;
            if(i7 > 0)
            {
                int j9 = 1 + i7 / 6;
                cgm.bca(453, cha - 56, cjm + 13);
                cgm.bdk("Wilderness", 465, cha - 20, 1, 0xffff00);
                cgm.bdk("Level: " + j9, 465, cha - 7, 1, 0xffff00);
                if(cmm == 0)
                    cmm = 2;
            }
            if(cmm == 0 && i7 > -10 && i7 <= 0)
                cmm = 1;
        }
        if(dcj == 0)
        {
            for(int j7 = 0; j7 < 5; j7++)
                if(cjg[j7] > 0)
                {
                    String s1 = ckh[j7];
                    cgm.bdm(s1, 7, cha - 18 - j7 * 12, 1, 0xffff00);
                }

        }
        dce.acj(dcf);
        dce.acj(dch);
        dce.acj(dci);
        if(dcj == 1)
            dce.aci(dcf);
        else
        if(dcj == 2)
            dce.aci(dch);
        else
        if(dcj == 3)
            dce.aci(dci);
        h.ade = 2;
        dce.aah();
        h.ade = 0;
        cgm.bcc(((j) (cgm)).ban - 3 - 197, 3, cjm, 128);
        bik();
        cgm.bcm = false;
        blm();
        cgm.bai(cjh, 0, 0);
    }

    final void bmi(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        int l = cfl[arg4];
        int i1 = cge[arg4];
        if(l == 0)
        {
            int j1 = 255 + i1 * 5 * 256;
            cgm.bak(arg0 + arg2 / 2, arg1 + arg3 / 2, 20 + i1 * 2, j1, 255 - i1 * 5);
        }
        if(l == 1)
        {
            int k1 = 0xff0000 + i1 * 5 * 256;
            cgm.bak(arg0 + arg2 / 2, arg1 + arg3 / 2, 10 + i1, k1, 255 - i1 * 5);
        }
    }

    private final boolean bmj(int arg0, int arg1)
    {
        if(cih != 0)
        {
            bmf.ehm = false;
            return false;
        }
        bnf = false;
        arg0 += dgj;
        arg1 += dgk;
        if(dgm == clg && arg0 > cgh && arg0 < cgj && arg1 > cgi && arg1 < cgk)
        {
            bmf.ehm = true;
            return false;
        }
        cgm.bdk("Loading... Please wait", 256, 192, 1, 0xffffff);
        blm();
        cgm.bai(cjh, 0, 0);
        int l = cle;
        int i1 = clf;
        int j1 = (arg0 + 24) / 48;
        int k1 = (arg1 + 24) / 48;
        dgm = clg;
        cle = j1 * 48 - 48;
        clf = k1 * 48 - 48;
        cgh = j1 * 48 - 32;
        cgi = k1 * 48 - 32;
        cgj = j1 * 48 + 32;
        cgk = k1 * 48 + 32;
        bmf.cin(arg0, arg1, dgm);
        cle -= dgj;
        clf -= dgk;
        int l1 = cle - l;
        int i2 = clf - i1;
        for(int j2 = 0; j2 < cfa; j2++)
        {
            dgf[j2] -= l1;
            dgg[j2] -= i2;
            int k2 = dgf[j2];
            int i3 = dgg[j2];
            int l3 = dgh[j2];
            i k4 = cec[j2];
            try
            {
                int j5 = dgi[j2];
                int i6;
                int l6;
                if(j5 == 0 || j5 == 4)
                {
                    i6 = e.enl[l3];
                    l6 = e.enm[l3];
                } else
                {
                    l6 = e.enl[l3];
                    i6 = e.enm[l3];
                }
                int i7 = ((k2 + k2 + i6) * cdf) / 2;
                int j7 = ((i3 + i3 + l6) * cdf) / 2;
                if(k2 >= 0 && i3 >= 0 && k2 < 96 && i3 < 96)
                {
                    cch.cdj(k4);
                    k4.age(i7, -bmf.cia(i7, j7), j7);
                    bmf.cij(k2, i3, l3);
                    if(l3 == 74)
                        k4.agd(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + j2 + " obj:" + k4);
                runtimeexception.printStackTrace();
            }
        }

        for(int l2 = 0; l2 < dae; l2++)
        {
            ddm[l2] -= l1;
            ddn[l2] -= i2;
            int j3 = ddm[l2];
            int i4 = ddn[l2];
            int l4 = cde[l2];
            int k5 = cdd[l2];
            try
            {
                bmf.chk(j3, i4, k5, l4);
                i j6 = bll(j3, i4, k5, l4, l2);
                cem[l2] = j6;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.printStackTrace();
            }
        }

        for(int k3 = 0; k3 < dhg; k3++)
        {
            cng[k3] -= l1;
            cnh[k3] -= i2;
        }

        for(int j4 = 0; j4 < cmf; j4++)
        {
            f f1 = bln[j4];
            f1.dme -= l1 * cdf;
            f1.dmf -= i2 * cdf;
            for(int l5 = 0; l5 <= f1.dml; l5++)
            {
                f1.dmm[l5] -= l1 * cdf;
                f1.dmn[l5] -= i2 * cdf;
            }

        }

        for(int i5 = 0; i5 < cae; i5++)
        {
            f f2 = cnf[i5];
            f2.dme -= l1 * cdf;
            f2.dmf -= i2 * cdf;
            for(int k6 = 0; k6 <= f2.dml; k6++)
            {
                f2.dmm[k6] -= l1 * cdf;
                f2.dmn[k6] -= i2 * cdf;
            }

        }

        bmf.ehm = true;
        return true;
    }

    protected final void ccj(String arg0, String arg1)
    {
        if(cnm == 1)
            ckk.acg(ckn, arg0 + " " + arg1);
        if(cnm == 2)
            bng.acg(clh, arg0 + " " + arg1);
        chn = arg1;
        bla();
        aib();
    }

    private final void bml()
    {
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = bil("entity" + w.bij + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            dff = true;
            return;
        }
        abyte1 = t.ank("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(dek)
        {
            abyte2 = bil("entity" + w.bij + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                dff = true;
                return;
            }
            abyte3 = t.ank("index.dat", 0, abyte2);
        }
        int l = 0;
        cje = 0;
        cjf = cje;
label0:
        for(int i1 = 0; i1 < e.ekh; i1++)
        {
            String s1 = e.end[i1];
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(!e.end[j1].equalsIgnoreCase(s1))
                    continue;
                e.emb[i1] = e.emb[j1];
                continue label0;
            }

            byte abyte7[] = t.ank(s1 + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && dek)
            {
                abyte7 = t.ank(s1 + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                cgm.bbi(cjf, abyte7, abyte4, 15);
                l += 15;
                if(e.eln[i1] == 1)
                {
                    byte abyte8[] = t.ank(s1 + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && dek)
                    {
                        abyte8 = t.ank(s1 + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    cgm.bbi(cjf + 15, abyte8, abyte5, 3);
                    l += 3;
                }
                if(e.ema[i1] == 1)
                {
                    byte abyte9[] = t.ank(s1 + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && dek)
                    {
                        abyte9 = t.ank(s1 + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    cgm.bbi(cjf + 18, abyte9, abyte6, 9);
                    l += 9;
                }
                if(e.elm[i1] != 0)
                {
                    for(int k1 = cjf; k1 < cjf + 27; k1++)
                        cgm.bbl(k1);

                }
            }
            e.emb[i1] = cjf;
            cjf += 27;
        }

        System.out.println("Loaded: " + l + " frames of animation");
    }

    private final void bmm()
    {
        bne = 0;
        int l = 135;
        for(int i1 = 0; i1 < 12; i1++)
        {
            if(super.anb > 66 && super.anb < 446 && super.anc >= l - 12 && super.anc < l + 3)
                bne = i1 + 1;
            l += 14;
        }

        if(cgl != 0 && bne != 0)
        {
            cgl = 0;
            cei = 2;
            super.ani = "";
            super.anj = "";
            return;
        }
        l += 15;
        if(cgl != 0)
        {
            cgl = 0;
            if(super.anb < 56 || super.anc < 35 || super.anb > 456 || super.anc > 325)
            {
                cei = 0;
                return;
            }
            if(super.anb > 66 && super.anb < 446 && super.anc >= l - 15 && super.anc < l + 5)
            {
                cei = 0;
                return;
            }
        }
        cgm.ban(56, 35, 400, 290, 0);
        cgm.bba(56, 35, 400, 290, 0xffffff);
        l = 50;
        cgm.bdk("This form is for reporting players who are breaking our rules", 256, l, 1, 0xffffff);
        l += 15;
        cgm.bdk("Using it sends a snapshot of the last 60 secs of activity to us", 256, l, 1, 0xffffff);
        l += 15;
        cgm.bdk("If you misuse this form, you will be banned.", 256, l, 1, 0xff8000);
        l += 15;
        l += 10;
        cgm.bdk("First indicate which of our 12 rules is being broken. For a detailed", 256, l, 1, 0xffff00);
        l += 15;
        cgm.bdk("explanation of each rule please read the manual on our website.", 256, l, 1, 0xffff00);
        l += 15;
        int j1;
        if(bne == 1)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("1: Offensive language", 256, l, 1, j1);
        l += 14;
        if(bne == 2)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("2: Item scamming", 256, l, 1, j1);
        l += 14;
        if(bne == 3)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("3: Password scamming", 256, l, 1, j1);
        l += 14;
        if(bne == 4)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("4: Bug abuse", 256, l, 1, j1);
        l += 14;
        if(bne == 5)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("5: Jagex Staff impersonation", 256, l, 1, j1);
        l += 14;
        if(bne == 6)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("6: Account sharing/trading", 256, l, 1, j1);
        l += 14;
        if(bne == 7)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("7: Macroing", 256, l, 1, j1);
        l += 14;
        if(bne == 8)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("8: Mutiple logging in", 256, l, 1, j1);
        l += 14;
        if(bne == 9)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("9: Encouraging others to break rules", 256, l, 1, j1);
        l += 14;
        if(bne == 10)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("10: Misuse of customer support", 256, l, 1, j1);
        l += 14;
        if(bne == 11)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("11: Advertising / website", 256, l, 1, j1);
        l += 14;
        if(bne == 12)
        {
            cgm.bba(66, l - 12, 380, 15, 0xffffff);
            j1 = 0xff8000;
        } else
        {
            j1 = 0xffffff;
        }
        cgm.bdk("12: Real world item trading", 256, l, 1, j1);
        l += 14;
        l += 15;
        j1 = 0xffffff;
        if(super.anb > 196 && super.anb < 316 && super.anc > l - 15 && super.anc < l + 5)
            j1 = 0xffff00;
        cgm.bdk("Click here to cancel", 256, l, 1, j1);
    }

    private final void bmn()
    {
        for(int l = 0; l < cna; l++)
        {
            int i1 = cgm.bec(1);
            int k1 = dfm[l];
            int j2 = dfn[l];
            int i3 = dga[l];
            int l3 = dgb[l];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int l4 = 0; l4 < l; l4++)
                    if(j2 + l3 > dfn[l4] - i1 && j2 - i1 < dfn[l4] + dgb[l4] && k1 - i3 < dfm[l4] + dga[l4] && k1 + i3 > dfm[l4] - dga[l4] && dfn[l4] - i1 - l3 < j2)
                    {
                        j2 = dfn[l4] - i1 - l3;
                        flag = true;
                    }

            }
            dfn[l] = j2;
            cgm.bdl(cnb[l], k1, j2, 1, 0xffff00, 300);
        }

        for(int j1 = 0; j1 < cfn; j1++)
        {
            int l1 = cgf[j1];
            int k2 = cgg[j1];
            int j3 = cek[j1];
            int i4 = cel[j1];
            int k4 = (39 * j3) / 100;
            int i5 = (27 * j3) / 100;
            int j5 = k2 - i5;
            cgm.bcd(l1 - k4 / 2, j5, k4, i5, cjm + 9, 85);
            int k5 = (36 * j3) / 100;
            int l5 = (24 * j3) / 100;
            cgm.bdc(l1 - k5 / 2, (j5 + i5 / 2) - l5 / 2, k5, l5, e.ejh[i4] + cka, e.ejm[i4], 0, 0, false);
        }

        for(int i2 = 0; i2 < dck; i2++)
        {
            int l2 = ddj[i2];
            int k3 = ddk[i2];
            int j4 = ddl[i2];
            cgm.bal(l2 - 15, k3 - 3, j4, 5, 65280, 192);
            cgm.bal((l2 - 15) + j4, k3 - 3, 30 - j4, 5, 0xff0000, 192);
        }

    }

    private final void bna()
    {
        dfg = new h(cgm, 100);
        dfg.abh(256, 10, "Please design Your Character", 4, true);
        int l = 140;
        int i1 = 34;
        l += 116;
        i1 -= 10;
        dfg.abh(l - 55, i1 + 110, "Front", 3, true);
        dfg.abh(l, i1 + 110, "Side", 3, true);
        dfg.abh(l + 55, i1 + 110, "Back", 3, true);
        byte byte0 = 54;
        i1 += 145;
        dfg.abj(l - byte0, i1, 53, 41);
        dfg.abh(l - byte0, i1 - 8, "Head", 1, true);
        dfg.abh(l - byte0, i1 + 8, "Type", 1, true);
        dfg.abk(l - byte0 - 40, i1, h.ada + 7);
        dbb = dfg.acb(l - byte0 - 40, i1, 20, 20);
        dfg.abk((l - byte0) + 40, i1, h.ada + 6);
        dbc = dfg.acb((l - byte0) + 40, i1, 20, 20);
        dfg.abj(l + byte0, i1, 53, 41);
        dfg.abh(l + byte0, i1 - 8, "Hair", 1, true);
        dfg.abh(l + byte0, i1 + 8, "Color", 1, true);
        dfg.abk((l + byte0) - 40, i1, h.ada + 7);
        dbd = dfg.acb((l + byte0) - 40, i1, 20, 20);
        dfg.abk(l + byte0 + 40, i1, h.ada + 6);
        dbe = dfg.acb(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dfg.abj(l - byte0, i1, 53, 41);
        dfg.abh(l - byte0, i1, "Gender", 1, true);
        dfg.abk(l - byte0 - 40, i1, h.ada + 7);
        dbf = dfg.acb(l - byte0 - 40, i1, 20, 20);
        dfg.abk((l - byte0) + 40, i1, h.ada + 6);
        dbg = dfg.acb((l - byte0) + 40, i1, 20, 20);
        dfg.abj(l + byte0, i1, 53, 41);
        dfg.abh(l + byte0, i1 - 8, "Top", 1, true);
        dfg.abh(l + byte0, i1 + 8, "Color", 1, true);
        dfg.abk((l + byte0) - 40, i1, h.ada + 7);
        dbh = dfg.acb((l + byte0) - 40, i1, 20, 20);
        dfg.abk(l + byte0 + 40, i1, h.ada + 6);
        dbi = dfg.acb(l + byte0 + 40, i1, 20, 20);
        i1 += 50;
        dfg.abj(l - byte0, i1, 53, 41);
        dfg.abh(l - byte0, i1 - 8, "Skin", 1, true);
        dfg.abh(l - byte0, i1 + 8, "Color", 1, true);
        dfg.abk(l - byte0 - 40, i1, h.ada + 7);
        dbj = dfg.acb(l - byte0 - 40, i1, 20, 20);
        dfg.abk((l - byte0) + 40, i1, h.ada + 6);
        dbk = dfg.acb((l - byte0) + 40, i1, 20, 20);
        dfg.abj(l + byte0, i1, 53, 41);
        dfg.abh(l + byte0, i1 - 8, "Bottom", 1, true);
        dfg.abh(l + byte0, i1 + 8, "Color", 1, true);
        dfg.abk((l + byte0) - 40, i1, h.ada + 7);
        dbl = dfg.acb((l + byte0) - 40, i1, 20, 20);
        dfg.abk(l + byte0 + 40, i1, h.ada + 6);
        dbm = dfg.acb(l + byte0 + 40, i1, 20, 20);
        i1 += 82;
        i1 -= 35;
        dfg.abi(l, i1, 200, 30);
        dfg.abh(l, i1, "Accept", 4, false);
        dbn = dfg.acb(l, i1, 200, 30);
    }

    private final void bnb()
    {
        cgm.ban(126, 137, 260, 60, 0);
        cgm.bba(126, 137, 260, 60, 0xffffff);
        cgm.bdk("Logging out...", 256, 173, 5, 0xffffff);
    }

    private final void bnc()
    {
        if(super.dlf > 0)
            super.dlf--;
        if(cnm == 0)
        {
            dgc.aae(super.anb, super.anc, super.ane, super.and);
            if(dgc.aaf(cfh))
                cnm = 1;
            if(dgc.aaf(cfi))
            {
                cnm = 2;
                bng.acg(clh, "Please enter your username and password");
                bng.acg(cli, "");
                bng.acg(clj, "");
                bng.ack(cli);
                return;
            }
        } else
        if(cnm == 1)
        {
            ckk.aae(super.anb, super.anc, super.ane, super.and);
            if(ckk.aaf(cla))
            {
                cnm = 0;
                return;
            }
        } else
        if(cnm == 2)
        {
            bng.aae(super.anb, super.anc, super.ane, super.and);
            if(bng.aaf(cll))
                cnm = 0;
            if(bng.aaf(cli))
                bng.ack(clj);
            if(bng.aaf(clj) || bng.aaf(clk))
            {
                dea = bng.ach(cli);
                deb = bng.ach(clj);
                cbi(dea, deb, false);
            }
        }
    }

    private final void bnd(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 199;
        int i1 = 36;
        cgm.bca(l - 49, 3, cjm + 5);
        char c1 = '\304';
        char c2 = '\266';
        int k1;
        int j1 = k1 = j.bbg(160, 160, 160);
        if(ddf == 0)
            j1 = j.bbg(220, 220, 220);
        else
            k1 = j.bbg(220, 220, 220);
        cgm.bal(l, i1, c1 / 2, 24, j1, 128);
        cgm.bal(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        cgm.bal(l, i1 + 24, c1, c2 - 24, j.bbg(220, 220, 220), 128);
        cgm.bbb(l, i1 + 24, c1, 0);
        cgm.bbc(l + c1 / 2, i1, 24, 0);
        cgm.bbb(l, (i1 + c2) - 16, c1, 0);
        cgm.bdk("Friends", l + c1 / 4, i1 + 16, 4, 0);
        cgm.bdk("Ignore", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        ddd.acc(dde);
        if(ddf == 0)
        {
            for(int l1 = 0; l1 < super.dkh; l1++)
            {
                String s1;
                if(super.dkj[l1] == 99)
                    s1 = "@gre@";
                else
                if(super.dkj[l1] > 0)
                    s1 = "@yel@";
                else
                    s1 = "@red@";
                ddd.ace(dde, l1, s1 + t.anh(super.dki[l1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(ddf == 1)
        {
            for(int i2 = 0; i2 < super.dkk; i2++)
                ddd.ace(dde, i2, "@yel@" + t.anh(super.dkl[i2]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        ddd.aah();
        if(ddf == 0)
        {
            int j2 = ddd.acl(dde);
            if(j2 >= 0 && super.anb < 489)
            {
                if(super.anb > 429)
                    cgm.bdk("Click to remove " + t.anh(super.dki[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.dkj[j2] == 99)
                    cgm.bdk("Click to message " + t.anh(super.dki[j2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                if(super.dkj[j2] > 0)
                    cgm.bdk(t.anh(super.dki[j2]) + " is on world " + super.dkj[j2], l + c1 / 2, i1 + 35, 1, 0xffffff);
                else
                    cgm.bdk(t.anh(super.dki[j2]) + " is offline", l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                cgm.bdk("Click a name to send a message", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int j3;
            if(super.anb > l && super.anb < l + c1 && super.anc > (i1 + c2) - 16 && super.anc < i1 + c2)
                j3 = 0xffff00;
            else
                j3 = 0xffffff;
            cgm.bdk("Click here to add a friend", l + c1 / 2, (i1 + c2) - 3, 1, j3);
        }
        if(ddf == 1)
        {
            int k2 = ddd.acl(dde);
            if(k2 >= 0 && super.anb < 489 && super.anb > 429)
            {
                if(super.anb > 429)
                    cgm.bdk("Click to remove " + t.anh(super.dkl[k2]), l + c1 / 2, i1 + 35, 1, 0xffffff);
            } else
            {
                cgm.bdk("Blocking messages from:", l + c1 / 2, i1 + 35, 1, 0xffffff);
            }
            int k3;
            if(super.anb > l && super.anb < l + c1 && super.anc > (i1 + c2) - 16 && super.anc < i1 + c2)
                k3 = 0xffff00;
            else
                k3 = 0xffffff;
            cgm.bdk("Click here to add a name", l + c1 / 2, (i1 + c2) - 3, 1, k3);
        }
        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 199);
        i1 = super.anc - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 182)
        {
            ddd.aae(l + (((j) (cgm)).ban - 199), i1 + 36, super.ane, super.and);
            if(i1 <= 24 && cgl == 1)
                if(l < 98 && ddf == 1)
                {
                    ddf = 0;
                    ddd.acd(dde);
                } else
                if(l > 98 && ddf == 0)
                {
                    ddf = 1;
                    ddd.acd(dde);
                }
            if(cgl == 1 && ddf == 0)
            {
                int l2 = ddd.acl(dde);
                if(l2 >= 0 && super.anb < 489)
                    if(super.anb > 429)
                        ccf(super.dki[l2]);
                    else
                    if(super.dkj[l2] != 0)
                    {
                        caj = 2;
                        ddg = super.dki[l2];
                        super.ank = "";
                        super.anl = "";
                    }
            }
            if(cgl == 1 && ddf == 1)
            {
                int i3 = ddd.acl(dde);
                if(i3 >= 0 && super.anb < 489 && super.anb > 429)
                    ccd(super.dkl[i3]);
            }
            if(i1 > 166 && cgl == 1 && ddf == 0)
            {
                caj = 1;
                super.ani = "";
                super.anj = "";
            }
            if(i1 > 166 && cgl == 1 && ddf == 1)
            {
                caj = 3;
                super.ani = "";
                super.anj = "";
            }
            cgl = 0;
        }
    }

    private final f bne(int arg0, int arg1, int arg2, int arg3)
    {
        if(cme[arg0] == null)
        {
            cme[arg0] = new f();
            cme[arg0].dmc = arg0;
            cme[arg0].dmd = 0;
        }
        f f1 = cme[arg0];
        boolean flag = false;
        for(int l = 0; l < cmg; l++)
        {
            if(cfe[l].dmc != arg0)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            f1.dmj = arg3;
            int i1 = f1.dml;
            if(arg1 != f1.dmm[i1] || arg2 != f1.dmn[i1])
            {
                f1.dml = i1 = (i1 + 1) % 10;
                f1.dmm[i1] = arg1;
                f1.dmn[i1] = arg2;
            }
        } else
        {
            f1.dmc = arg0;
            f1.dmk = 0;
            f1.dml = 0;
            f1.dmm[0] = f1.dme = arg1;
            f1.dmn[0] = f1.dmf = arg2;
            f1.dmj = f1.dmi = arg3;
            f1.dmh = 0;
        }
        bln[cmf++] = f1;
        return f1;
    }

    public final Graphics bnf()
    {
        if(a.ald != null)
            return a.ald.ada();
        if(link.dhm != null)
            return link.dhm.getGraphics();
        else
            return super.ajk();
    }

    private final void bng(int arg0, int arg1, int arg2, int arg3, boolean arg4)
    {
        if(bjk(arg0, arg1, arg2, arg3, arg2, arg3, false, arg4))
        {
            return;
        } else
        {
            bjj(arg0, arg1, arg2, arg3, arg2, arg3, true, arg4);
            return;
        }
    }

    protected final void bnh()
    {
        if(ccf)
        {
            String s1 = bii().getHost().toLowerCase();
            if(!s1.endsWith("jagex.com") && !s1.endsWith("jagex.co.uk") && !s1.endsWith("runescape.com") && !s1.endsWith("runescape.co.uk") && !s1.endsWith("runescape.net") && !s1.endsWith("runescape.org") && !s1.endsWith("penguin") && !s1.endsWith("puffin"))
            {
                can = true;
                return;
            }
        }
        int l = 0;
        for(int i1 = 0; i1 < 99; i1++)
        {
            int j1 = i1 + 1;
            int l1 = (int)((double)j1 + 300D * Math.pow(2D, (double)j1 / 7D));
            l += l1;
            cce[i1] = l & 0xffffffc;
        }

        try
        {
            String s2 = bma("referid");
            ckm = 0;
        }
        catch(Exception _ex) { }
        try
        {
            String s3 = bma("member");
            int i2 = 0;
            if(i2 == 1)
                dek = true;
        }
        catch(Exception _ex) { }
        if(ccf)
            super.dka = 43594;
        super.alh = 0;
        b.djm = 1000;
        b.djl = w.bid;
        try
        {
            String s4 = bma("poff");
            int j2 = 0;
            super.dka += j2;
            System.out.println("Offset: " + j2);
        }
        catch(Exception _ex) { }
        bld();
        if(dff)
            return;
        cjm = 2000;
        cjn = cjm + 100;
        cka = cjn + 50;
        cke = cka + 1000;
        ckb = cke + 10;
        ckc = ckb + 50;
        ckd = ckc + 10;
        cjh = bnf();
        aia(50);
        cgm = new k(cgn, cha + 12, 4000, this);
        cgm.aaa = this;
        cgm.bag(0, 0, cgn, cha + 12);
        h.acn = false;
        h.ada = cjn;
        chd = new h(cgm, 5);
        int k1 = ((j) (cgm)).ban - 199;
        byte byte0 = 36;
        che = chd.aca(k1, byte0 + 24, 196, 90, 1, 500, true);
        ddd = new h(cgm, 5);
        dde = ddd.aca(k1, byte0 + 40, 196, 126, 1, 500, true);
        dhd = new h(cgm, 5);
        dhe = dhd.aca(k1, byte0 + 24, 196, 251, 1, 500, true);
        bhn();
        if(dff)
            return;
        bml();
        if(dff)
            return;
        cch = new n(cgm, 15000, 15000, 1000);
        cch.ceh(cgn / 2, cha / 2, cgn / 2, cha / 2, cgn, chb);
        cch.ean = 2400;
        cch.eba = 2400;
        cch.ebb = 1;
        cch.ebc = 2300;
        cch.cgh(-50, -10, -50);
        bmf = new x(cch, cgm);
        bmf.ehn = cjm;
        bln();
        if(dff)
            return;
        cad();
        if(dff)
            return;
        bhi();
        if(dff)
            return;
        if(dek)
            bkb();
        if(dff)
        {
            return;
        } else
        {
            ajg(100, "Starting game...");
            bin();
            bhl();
            bna();
            bhg();
            ahl();
            bkc();
            return;
        }
    }

    private final boolean bni(int arg0, int arg1)
    {
        if(arg0 == 31 && (bkh(197) || bkh(615) || bkh(682)))
            return true;
        if(arg0 == 32 && (bkh(102) || bkh(616) || bkh(683)))
            return true;
        if(arg0 == 33 && (bkh(101) || bkh(617) || bkh(684)))
            return true;
        if(arg0 == 34 && (bkh(103) || bkh(618) || bkh(685)))
            return true;
        return bmc(arg0) >= arg1;
    }

    private final void bnj()
    {
        int l = 2203 - (ccn + dgk + clf);
        if(ccm + dgj + cle >= 2640)
            l = -50;
        int i1 = -1;
        for(int j1 = 0; j1 < cfa; j1++)
            dgd[j1] = false;

        for(int k1 = 0; k1 < dae; k1++)
            dcm[k1] = false;

        int l1 = cch.cee();
        i ai[] = cch.ceg();
        int ai1[] = cch.cef();
        for(int i2 = 0; i2 < l1; i2++)
        {
            if(bna > 200)
                break;
            int j2 = ai1[i2];
            i l2 = ai[i2];
            if(l2.aha[j2] <= 65535 || l2.aha[j2] >= 0x30d40 && l2.aha[j2] <= 0x493e0)
                if(l2 == cch.eea)
                {
                    int i3 = l2.aha[j2] % 10000;
                    int l3 = l2.aha[j2] / 10000;
                    if(l3 == 1)
                    {
                        String s1 = "";
                        int k4 = 0;
                        if(ccl.dnj > 0 && bln[i3].dnj > 0)
                            k4 = ccl.dnj - bln[i3].dnj;
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
                        s1 = " " + s1 + "(level-" + bln[i3].dnj + ")";
                        if(cdb >= 0)
                        {
                            if(e.faf[cdb] == 1 || e.faf[cdb] == 2)
                            {
                                cig[bna] = "Cast " + e.elb[cdb] + " on";
                                cen[bna] = "@whi@" + bln[i3].dmb + s1;
                                bmg[bna] = 800;
                                cfj[bna] = bln[i3].dme;
                                cfk[bna] = bln[i3].dmf;
                                dfa[bna] = bln[i3].dmc;
                                dfb[bna] = cdb;
                                bna++;
                            }
                        } else
                        if(bmi >= 0)
                        {
                            cig[bna] = "Use " + bmj + " with";
                            cen[bna] = "@whi@" + bln[i3].dmb + s1;
                            bmg[bna] = 810;
                            cfj[bna] = bln[i3].dme;
                            cfk[bna] = bln[i3].dmf;
                            dfa[bna] = bln[i3].dmc;
                            dfb[bna] = bmi;
                            bna++;
                        } else
                        {
                            if(l > 0 && (bln[i3].dmf - 64) / cdf + dgk + clf < 2203)
                            {
                                cig[bna] = "Attack";
                                cen[bna] = "@whi@" + bln[i3].dmb + s1;
                                if(k4 >= 0 && k4 < 5)
                                    bmg[bna] = 805;
                                else
                                    bmg[bna] = 2805;
                                cfj[bna] = bln[i3].dme;
                                cfk[bna] = bln[i3].dmf;
                                dfa[bna] = bln[i3].dmc;
                                bna++;
                            } else
                            if(dek)
                            {
                                cig[bna] = "Duel with";
                                cen[bna] = "@whi@" + bln[i3].dmb + s1;
                                cfj[bna] = bln[i3].dme;
                                cfk[bna] = bln[i3].dmf;
                                bmg[bna] = 2806;
                                dfa[bna] = bln[i3].dmc;
                                bna++;
                            }
                            cig[bna] = "Trade with";
                            cen[bna] = "@whi@" + bln[i3].dmb + s1;
                            bmg[bna] = 2810;
                            dfa[bna] = bln[i3].dmc;
                            bna++;
                            cig[bna] = "Follow";
                            cen[bna] = "@whi@" + bln[i3].dmb + s1;
                            bmg[bna] = 2820;
                            dfa[bna] = bln[i3].dmc;
                            bna++;
                        }
                    } else
                    if(l3 == 2)
                    {
                        if(cdb >= 0)
                        {
                            if(e.faf[cdb] == 3)
                            {
                                cig[bna] = "Cast " + e.elb[cdb] + " on";
                                cen[bna] = "@lre@" + e.ekj[cni[i3]];
                                bmg[bna] = 200;
                                cfj[bna] = cng[i3];
                                cfk[bna] = cnh[i3];
                                dfa[bna] = cni[i3];
                                dfb[bna] = cdb;
                                bna++;
                            }
                        } else
                        if(bmi >= 0)
                        {
                            cig[bna] = "Use " + bmj + " with";
                            cen[bna] = "@lre@" + e.ekj[cni[i3]];
                            bmg[bna] = 210;
                            cfj[bna] = cng[i3];
                            cfk[bna] = cnh[i3];
                            dfa[bna] = cni[i3];
                            dfb[bna] = bmi;
                            bna++;
                        } else
                        {
                            cig[bna] = "Take";
                            cen[bna] = "@lre@" + e.ekj[cni[i3]];
                            bmg[bna] = 220;
                            cfj[bna] = cng[i3];
                            cfk[bna] = cnh[i3];
                            dfa[bna] = cni[i3];
                            bna++;
                            cig[bna] = "Examine";
                            cen[bna] = "@lre@" + e.ekj[cni[i3]];
                            bmg[bna] = 3200;
                            dfa[bna] = cni[i3];
                            bna++;
                        }
                    } else
                    if(l3 == 3)
                    {
                        String s2 = "";
                        int l4 = -1;
                        int i5 = cnf[i3].dmg;
                        if(e.ejc[i5] > 0)
                        {
                            int j5 = (e.eim[i5] + e.ejb[i5] + e.ein[i5] + e.eja[i5]) / 4;
                            int k5 = (ckg[0] + ckg[1] + ckg[2] + ckg[3] + 27) / 4;
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
                        if(cdb >= 0)
                        {
                            if(e.faf[cdb] == 2)
                            {
                                cig[bna] = "Cast " + e.elb[cdb] + " on";
                                cen[bna] = "@yel@" + e.eij[cnf[i3].dmg];
                                bmg[bna] = 700;
                                cfj[bna] = cnf[i3].dme;
                                cfk[bna] = cnf[i3].dmf;
                                dfa[bna] = cnf[i3].dmc;
                                dfb[bna] = cdb;
                                bna++;
                            }
                        } else
                        if(bmi >= 0)
                        {
                            cig[bna] = "Use " + bmj + " with";
                            cen[bna] = "@yel@" + e.eij[cnf[i3].dmg];
                            bmg[bna] = 710;
                            cfj[bna] = cnf[i3].dme;
                            cfk[bna] = cnf[i3].dmf;
                            dfa[bna] = cnf[i3].dmc;
                            dfb[bna] = bmi;
                            bna++;
                        } else
                        {
                            if(e.ejc[i5] > 0)
                            {
                                cig[bna] = "Attack";
                                cen[bna] = "@yel@" + e.eij[cnf[i3].dmg] + s2;
                                if(l4 >= 0)
                                    bmg[bna] = 715;
                                else
                                    bmg[bna] = 2715;
                                cfj[bna] = cnf[i3].dme;
                                cfk[bna] = cnf[i3].dmf;
                                dfa[bna] = cnf[i3].dmc;
                                bna++;
                            }
                            cig[bna] = "Talk-to";
                            cen[bna] = "@yel@" + e.eij[cnf[i3].dmg];
                            bmg[bna] = 720;
                            cfj[bna] = cnf[i3].dme;
                            cfk[bna] = cnf[i3].dmf;
                            dfa[bna] = cnf[i3].dmc;
                            bna++;
                            if(!e.eil[i5].equals(""))
                            {
                                cig[bna] = e.eil[i5];
                                cen[bna] = "@yel@" + e.eij[cnf[i3].dmg];
                                bmg[bna] = 725;
                                cfj[bna] = cnf[i3].dme;
                                cfk[bna] = cnf[i3].dmf;
                                dfa[bna] = cnf[i3].dmc;
                                bna++;
                            }
                            cig[bna] = "Examine";
                            cen[bna] = "@yel@" + e.eij[cnf[i3].dmg];
                            bmg[bna] = 3700;
                            dfa[bna] = cnf[i3].dmg;
                            bna++;
                        }
                    }
                } else
                if(l2 != null && l2.agn >= 10000)
                {
                    int j3 = l2.agn - 10000;
                    int i4 = cde[j3];
                    if(!dcm[j3])
                    {
                        if(cdb >= 0)
                        {
                            if(e.faf[cdb] == 4)
                            {
                                cig[bna] = "Cast " + e.elb[cdb] + " on";
                                cen[bna] = "@cya@" + e.enf[i4];
                                bmg[bna] = 300;
                                cfj[bna] = ddm[j3];
                                cfk[bna] = ddn[j3];
                                dfa[bna] = cdd[j3];
                                dfb[bna] = cdb;
                                bna++;
                            }
                        } else
                        if(bmi >= 0)
                        {
                            cig[bna] = "Use " + bmj + " with";
                            cen[bna] = "@cya@" + e.enf[i4];
                            bmg[bna] = 310;
                            cfj[bna] = ddm[j3];
                            cfk[bna] = ddn[j3];
                            dfa[bna] = cdd[j3];
                            dfb[bna] = bmi;
                            bna++;
                        } else
                        {
                            if(!e.enh[i4].equalsIgnoreCase("WalkTo"))
                            {
                                cig[bna] = e.enh[i4];
                                cen[bna] = "@cya@" + e.enf[i4];
                                bmg[bna] = 320;
                                cfj[bna] = ddm[j3];
                                cfk[bna] = ddn[j3];
                                dfa[bna] = cdd[j3];
                                bna++;
                            }
                            if(!e.eni[i4].equalsIgnoreCase("Examine"))
                            {
                                cig[bna] = e.eni[i4];
                                cen[bna] = "@cya@" + e.enf[i4];
                                bmg[bna] = 2300;
                                cfj[bna] = ddm[j3];
                                cfk[bna] = ddn[j3];
                                dfa[bna] = cdd[j3];
                                bna++;
                            }
                            cig[bna] = "Examine";
                            cen[bna] = "@cya@" + e.enf[i4];
                            bmg[bna] = 3300;
                            dfa[bna] = i4;
                            bna++;
                        }
                        dcm[j3] = true;
                    }
                } else
                if(l2 != null && l2.agn >= 0)
                {
                    int k3 = l2.agn;
                    int j4 = dgh[k3];
                    if(!dgd[k3])
                    {
                        if(cdb >= 0)
                        {
                            if(e.faf[cdb] == 5)
                            {
                                cig[bna] = "Cast " + e.elb[cdb] + " on";
                                cen[bna] = "@cya@" + e.fai[j4];
                                bmg[bna] = 400;
                                cfj[bna] = dgf[k3];
                                cfk[bna] = dgg[k3];
                                dfa[bna] = dgi[k3];
                                dfb[bna] = dgh[k3];
                                dfc[bna] = cdb;
                                bna++;
                            }
                        } else
                        if(bmi >= 0)
                        {
                            cig[bna] = "Use " + bmj + " with";
                            cen[bna] = "@cya@" + e.fai[j4];
                            bmg[bna] = 410;
                            cfj[bna] = dgf[k3];
                            cfk[bna] = dgg[k3];
                            dfa[bna] = dgi[k3];
                            dfb[bna] = dgh[k3];
                            dfc[bna] = bmi;
                            bna++;
                        } else
                        {
                            if(!e.fak[j4].equalsIgnoreCase("WalkTo"))
                            {
                                cig[bna] = e.fak[j4];
                                cen[bna] = "@cya@" + e.fai[j4];
                                bmg[bna] = 420;
                                cfj[bna] = dgf[k3];
                                cfk[bna] = dgg[k3];
                                dfa[bna] = dgi[k3];
                                dfb[bna] = dgh[k3];
                                bna++;
                            }
                            if(!e.fal[j4].equalsIgnoreCase("Examine"))
                            {
                                cig[bna] = e.fal[j4];
                                cen[bna] = "@cya@" + e.fai[j4];
                                bmg[bna] = 2400;
                                cfj[bna] = dgf[k3];
                                cfk[bna] = dgg[k3];
                                dfa[bna] = dgi[k3];
                                dfb[bna] = dgh[k3];
                                bna++;
                            }
                            cig[bna] = "Examine";
                            cen[bna] = "@cya@" + e.fai[j4];
                            bmg[bna] = 3400;
                            dfa[bna] = j4;
                            bna++;
                        }
                        dgd[k3] = true;
                    }
                } else
                {
                    if(j2 >= 0)
                        j2 = l2.aha[j2] - 0x30d40;
                    if(j2 >= 0)
                        i1 = j2;
                }
        }

        if(cdb >= 0 && e.faf[cdb] <= 1)
        {
            cig[bna] = "Cast " + e.elb[cdb] + " on self";
            cen[bna] = "";
            bmg[bna] = 1000;
            dfa[bna] = cdb;
            bna++;
        }
        if(i1 != -1)
        {
            int k2 = i1;
            if(cdb >= 0)
            {
                if(e.faf[cdb] == 6)
                {
                    cig[bna] = "Cast " + e.elb[cdb] + " on ground";
                    cen[bna] = "";
                    bmg[bna] = 900;
                    cfj[bna] = bmf.egl[k2];
                    cfk[bna] = bmf.eic[k2];
                    dfa[bna] = cdb;
                    bna++;
                    return;
                }
            } else
            if(bmi < 0)
            {
                cig[bna] = "Walk here";
                cen[bna] = "";
                bmg[bna] = 920;
                cfj[bna] = bmf.egl[k2];
                cfk[bna] = bmf.eic[k2];
                bna++;
            }
        }
    }

    private final void bnk()
    {
        cgm.bcj = false;
        cgm.baj();
        dfg.aah();
        int l = 140;
        int i1 = 50;
        l += 116;
        i1 -= 25;
        cgm.bce(l - 32 - 55, i1, 64, 102, e.emb[cim], dfl[cjb]);
        cgm.bdc(l - 32 - 55, i1, 64, 102, e.emb[cil], dfl[cja], dai[cjc], 0, false);
        cgm.bdc(l - 32 - 55, i1, 64, 102, e.emb[cik], ddh[cin], dai[cjc], 0, false);
        cgm.bce(l - 32, i1, 64, 102, e.emb[cim] + 6, dfl[cjb]);
        cgm.bdc(l - 32, i1, 64, 102, e.emb[cil] + 6, dfl[cja], dai[cjc], 0, false);
        cgm.bdc(l - 32, i1, 64, 102, e.emb[cik] + 6, ddh[cin], dai[cjc], 0, false);
        cgm.bce((l - 32) + 55, i1, 64, 102, e.emb[cim] + 12, dfl[cjb]);
        cgm.bdc((l - 32) + 55, i1, 64, 102, e.emb[cil] + 12, dfl[cja], dai[cjc], 0, false);
        cgm.bdc((l - 32) + 55, i1, 64, 102, e.emb[cik] + 12, ddh[cin], dai[cjc], 0, false);
        cgm.bca(0, cha, cjm + 22);
        cgm.bai(cjh, 0, 0);
    }

    private final void bnl(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 199;
        int i1 = 36;
        cgm.bca(l - 49, 3, cjm + 3);
        char c1 = '\304';
        char c2 = '\u0113';
        int k1;
        int j1 = k1 = j.bbg(160, 160, 160);
        if(dhf == 0)
            j1 = j.bbg(220, 220, 220);
        else
            k1 = j.bbg(220, 220, 220);
        cgm.bal(l, i1, c1 / 2, 24, j1, 128);
        cgm.bal(l + c1 / 2, i1, c1 / 2, 24, k1, 128);
        cgm.bal(l, i1 + 24, c1, c2 - 24, j.bbg(220, 220, 220), 128);
        cgm.bbb(l, i1 + 24, c1, 0);
        cgm.bbc(l + c1 / 2, i1, 24, 0);
        cgm.bdk("Stats", l + c1 / 4, i1 + 16, 4, 0);
        cgm.bdk("Quests", l + c1 / 4 + c1 / 2, i1 + 16, 4, 0);
        if(dhf == 0)
        {
            int l1 = 72;
            int j2 = -1;
            cgm.bdm("Skills", l + 5, l1, 3, 0xffff00);
            l1 += 13;
            for(int k2 = 0; k2 < 9; k2++)
            {
                int l2 = 0xffffff;
                if(super.anb > l + 3 && super.anc >= l1 - 11 && super.anc < l1 + 2 && super.anb < l + 90)
                {
                    l2 = 0xff0000;
                    j2 = k2;
                }
                cgm.bdm(bni[k2] + ":@yel@" + bnd[k2] + "/" + ckg[k2], l + 5, l1, 1, l2);
                l2 = 0xffffff;
                if(super.anb >= l + 90 && super.anc >= l1 - 13 - 11 && super.anc < (l1 - 13) + 2 && super.anb < l + 196)
                {
                    l2 = 0xff0000;
                    j2 = k2 + 9;
                }
                cgm.bdm(bni[k2 + 9] + ":@yel@" + bnd[k2 + 9] + "/" + ckg[k2 + 9], (l + c1 / 2) - 5, l1 - 13, 1, l2);
                l1 += 13;
            }

            cgm.bdm("Quest Points:@yel@" + chk, (l + c1 / 2) - 5, l1 - 13, 1, 0xffffff);
            l1 += 12;
            cgm.bdm("Fatigue: @yel@" + (dag * 100) / 750 + "%", l + 5, l1 - 13, 1, 0xffffff);
            l1 += 8;
            cgm.bdm("Equipment Status", l + 5, l1, 3, 0xffff00);
            l1 += 12;
            for(int i3 = 0; i3 < 3; i3++)
            {
                cgm.bdm(cjl[i3] + ":@yel@" + chc[i3], l + 5, l1, 1, 0xffffff);
                if(i3 < 2)
                    cgm.bdm(cjl[i3 + 3] + ":@yel@" + chc[i3 + 3], l + c1 / 2 + 25, l1, 1, 0xffffff);
                l1 += 13;
            }

            l1 += 6;
            cgm.bbb(l, l1 - 15, c1, 0);
            if(j2 != -1)
            {
                cgm.bdm(clm[j2] + " skill", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int j3 = cce[0];
                for(int l3 = 0; l3 < 98; l3++)
                    if(cac[j2] >= cce[l3])
                        j3 = cce[l3 + 1];

                cgm.bdm("Total xp: " + cac[j2] / 4, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                cgm.bdm("Next level at: " + j3 / 4, l + 5, l1, 1, 0xffffff);
            } else
            {
                cgm.bdm("Overall levels", l + 5, l1, 1, 0xffff00);
                l1 += 12;
                int k3 = 0;
                for(int i4 = 0; i4 < 18; i4++)
                    k3 += ckg[i4];

                cgm.bdm("Skill total: " + k3, l + 5, l1, 1, 0xffffff);
                l1 += 12;
                cgm.bdm("Combat level: " + ccl.dnj, l + 5, l1, 1, 0xffffff);
                l1 += 12;
            }
        }
        if(dhf == 1)
        {
            dhd.acc(dhe);
            dhd.ace(dhe, 0, "@whi@Quest-list (green=completed)");
            for(int i2 = 0; i2 < 50; i2++)
                dhd.ace(dhe, i2 + 1, (dan[i2] ? "@gre@" : "@red@") + cbe[i2]);

            dhd.aah();
        }
        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 199);
        i1 = super.anc - 36;
        if(l >= 0 && i1 >= 0 && l < c1 && i1 < c2)
        {
            if(dhf == 1)
                dhd.aae(l + (((j) (cgm)).ban - 199), i1 + 36, super.ane, super.and);
            if(i1 <= 24 && cgl == 1)
            {
                if(l < 98)
                {
                    dhf = 0;
                    return;
                }
                if(l > 98)
                    dhf = 1;
            }
        }
    }

    private final void bnm(boolean arg0)
    {
        int l = ((j) (cgm)).ban - 199;
        int i1 = 36;
        cgm.bca(l - 49, 3, cjm + 6);
        char c1 = '\304';
        cgm.bal(l, 36, c1, 65, j.bbg(181, 181, 181), 160);
        cgm.bal(l, 101, c1, 65, j.bbg(201, 201, 201), 160);
        cgm.bal(l, 166, c1, 95, j.bbg(181, 181, 181), 160);
        cgm.bal(l, 261, c1, 40, j.bbg(201, 201, 201), 160);
        int j1 = l + 3;
        int l1 = i1 + 15;
        cgm.bdm("Game options - click to toggle", j1, l1, 1, 0);
        l1 += 15;
        if(ceh)
            cgm.bdm("Camera angle mode - @gre@Auto", j1, l1, 1, 0xffffff);
        else
            cgm.bdm("Camera angle mode - @red@Manual", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(ckf)
            cgm.bdm("Mouse buttons - @red@One", j1, l1, 1, 0xffffff);
        else
            cgm.bdm("Mouse buttons - @gre@Two", j1, l1, 1, 0xffffff);
        l1 += 15;
        if(dek)
            if(cmc)
                cgm.bdm("Sound effects - @red@off", j1, l1, 1, 0xffffff);
            else
                cgm.bdm("Sound effects - @gre@on", j1, l1, 1, 0xffffff);
        l1 += 15;
        cgm.bdm("To change your contact details,", j1, l1, 0, 0xffffff);
        l1 += 15;
        cgm.bdm("password, recovery questions, etc..", j1, l1, 0, 0xffffff);
        l1 += 15;
        cgm.bdm("please select 'account management'", j1, l1, 0, 0xffffff);
        l1 += 15;
        if(ckm == 0)
            cgm.bdm("from the runescape.com front page", j1, l1, 0, 0xffffff);
        else
        if(ckm == 1)
            cgm.bdm("from the link below the gamewindow", j1, l1, 0, 0xffffff);
        else
            cgm.bdm("from the runescape front webpage", j1, l1, 0, 0xffffff);
        l1 += 15;
        l1 += 5;
        cgm.bdm("Privacy settings. Will be applied to", l + 3, l1, 1, 0);
        l1 += 15;
        cgm.bdm("all people not on your friends list", l + 3, l1, 1, 0);
        l1 += 15;
        if(super.dkm == 0)
            cgm.bdm("Block chat messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            cgm.bdm("Block chat messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.dkn == 0)
            cgm.bdm("Block private messages: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            cgm.bdm("Block private messages: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(super.dla == 0)
            cgm.bdm("Block trade requests: @red@<off>", l + 3, l1, 1, 0xffffff);
        else
            cgm.bdm("Block trade requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        if(dek)
            if(super.dlb == 0)
                cgm.bdm("Block duel requests: @red@<off>", l + 3, l1, 1, 0xffffff);
            else
                cgm.bdm("Block duel requests: @gre@<on>", l + 3, l1, 1, 0xffffff);
        l1 += 15;
        l1 += 5;
        cgm.bdm("Always logout when you finish", j1, l1, 1, 0);
        l1 += 15;
        int j2 = 0xffffff;
        if(super.anb > j1 && super.anb < j1 + c1 && super.anc > l1 - 12 && super.anc < l1 + 4)
            j2 = 0xffff00;
        cgm.bdm("Click here to logout", l + 3, l1, 1, j2);
        if(!arg0)
            return;
        l = super.anb - (((j) (cgm)).ban - 199);
        i1 = super.anc - 36;
        if(l >= 0 && i1 >= 0 && l < 196 && i1 < 265)
        {
            int k2 = ((j) (cgm)).ban - 199;
            byte byte0 = 36;
            char c2 = '\304';
            int k1 = k2 + 3;
            int i2 = byte0 + 30;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                ceh = !ceh;
                super.dkd.bgl(197);
                super.dkd.bfj(0);
                super.dkd.bfj(ceh ? 1 : 0);
                super.dkd.bgm();
            }
            i2 += 15;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                ckf = !ckf;
                super.dkd.bgl(197);
                super.dkd.bfj(2);
                super.dkd.bfj(ckf ? 1 : 0);
                super.dkd.bgm();
            }
            i2 += 15;
            if(dek && super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                cmc = !cmc;
                super.dkd.bgl(197);
                super.dkd.bfj(3);
                super.dkd.bfj(cmc ? 1 : 0);
                super.dkd.bgm();
            }
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            i2 += 15;
            boolean flag = false;
            i2 += 35;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                super.dkm = 1 - super.dkm;
                flag = true;
            }
            i2 += 15;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                super.dkn = 1 - super.dkn;
                flag = true;
            }
            i2 += 15;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                super.dla = 1 - super.dla;
                flag = true;
            }
            i2 += 15;
            if(dek && super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
            {
                super.dlb = 1 - super.dlb;
                flag = true;
            }
            i2 += 15;
            if(flag)
                ccb(super.dkm, super.dkn, super.dla, super.dlb);
            i2 += 20;
            if(super.anb > k1 && super.anb < k1 + c2 && super.anc > i2 - 12 && super.anc < i2 + 4 && cgl == 1)
                bkk();
            cgl = 0;
        }
    }

    private final void bnn()
    {
        byte byte0 = 22;
        byte byte1 = 36;
        cgm.ban(byte0, byte1, 468, 16, 192);
        int l = 0x989898;
        cgm.bal(byte0, byte1 + 16, 468, 246, l, 160);
        cgm.bdk("Please confirm your duel with @yel@" + t.anh(cdi), byte0 + 234, byte1 + 12, 1, 0xffffff);
        cgm.bdk("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int i1 = 0; i1 < cdm; i1++)
        {
            String s1 = e.ekj[cdn[i1]];
            if(e.ejj[cdn[i1]] == 0)
                s1 = s1 + " x " + bhh(cea[i1]);
            cgm.bdk(s1, byte0 + 117, byte1 + 42 + i1 * 12, 1, 0xffffff);
        }

        if(cdm == 0)
            cgm.bdk("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        cgm.bdk("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int j1 = 0; j1 < deh; j1++)
        {
            String s2 = e.ekj[dei[j1]];
            if(e.ejj[dei[j1]] == 0)
                s2 = s2 + " x " + bhh(dej[j1]);
            cgm.bdk(s2, byte0 + 351, byte1 + 42 + j1 * 12, 1, 0xffffff);
        }

        if(deh == 0)
            cgm.bdk("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(cbf == 0)
            cgm.bdk("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            cgm.bdk("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(cbg == 0)
            cgm.bdk("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            cgm.bdk("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(cbh == 0)
            cgm.bdk("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            cgm.bdk("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(cbi == 0)
            cgm.bdk("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            cgm.bdk("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        cgm.bdk("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!den)
        {
            cgm.bca((byte0 + 118) - 35, byte1 + 238, cjm + 25);
            cgm.bca((byte0 + 352) - 35, byte1 + 238, cjm + 26);
        } else
        {
            cgm.bdk("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(cgl == 1)
        {
            if(super.anb < byte0 || super.anc < byte1 || super.anb > byte0 + 468 || super.anc > byte1 + 262)
            {
                dem = false;
                super.dkd.bgl(124);
                super.dkd.bgm();
            }
            if(super.anb >= (byte0 + 118) - 35 && super.anb <= byte0 + 118 + 70 && super.anc >= byte1 + 238 && super.anc <= byte1 + 238 + 21)
            {
                den = true;
                super.dkd.bgl(168);
                super.dkd.bgm();
            }
            if(super.anb >= (byte0 + 352) - 35 && super.anb <= byte0 + 353 + 70 && super.anc >= byte1 + 238 && super.anc <= byte1 + 238 + 21)
            {
                dem = false;
                super.dkd.bgl(234);
                super.dkd.bgm();
            }
            cgl = 0;
        }
    }

    private final boolean caa(int arg0)
    {
        int l = ccl.dme / 128;
        int i1 = ccl.dmf / 128;
        for(int j1 = 2; j1 >= 1; j1--)
        {
            if(arg0 == 1 && ((bmf.ehj[l][i1 - j1] & 0x80) == 128 || (bmf.ehj[l - j1][i1] & 0x80) == 128 || (bmf.ehj[l - j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 3 && ((bmf.ehj[l][i1 + j1] & 0x80) == 128 || (bmf.ehj[l - j1][i1] & 0x80) == 128 || (bmf.ehj[l - j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 5 && ((bmf.ehj[l][i1 + j1] & 0x80) == 128 || (bmf.ehj[l + j1][i1] & 0x80) == 128 || (bmf.ehj[l + j1][i1 + j1] & 0x80) == 128))
                return false;
            if(arg0 == 7 && ((bmf.ehj[l][i1 - j1] & 0x80) == 128 || (bmf.ehj[l + j1][i1] & 0x80) == 128 || (bmf.ehj[l + j1][i1 - j1] & 0x80) == 128))
                return false;
            if(arg0 == 0 && (bmf.ehj[l][i1 - j1] & 0x80) == 128)
                return false;
            if(arg0 == 2 && (bmf.ehj[l - j1][i1] & 0x80) == 128)
                return false;
            if(arg0 == 4 && (bmf.ehj[l][i1 + j1] & 0x80) == 128)
                return false;
            if(arg0 == 6 && (bmf.ehj[l + j1][i1] & 0x80) == 128)
                return false;
        }

        return true;
    }

    private final void cab()
    {
        if(super.anj.length() > 0)
        {
            String s1 = super.anj.trim();
            super.ani = "";
            super.anj = "";
            if(s1.length() > 0)
            {
                long l1 = t.ang(s1);
                super.dkd.bgl(159);
                super.dkd.bgh(l1);
                super.dkd.bfj(bne);
                super.dkd.bfj(ccg ? 1 : 0);
                super.dkd.bgm();
            }
            cei = 0;
            return;
        }
        cgm.ban(56, 130, 400, 100, 0);
        cgm.bba(56, 130, 400, 100, 0xffffff);
        int l = 160;
        cgm.bdk("Now type the name of the offending player, and press enter", 256, l, 1, 0xffff00);
        l += 18;
        cgm.bdk("Name: " + super.ani + "*", 256, l, 4, 0xffffff);
        if(super.dlg > 0)
        {
            l = 207;
            if(ccg)
                cgm.bdk("Moderator option: Mute player for 48 hours: <ON>", 256, l, 1, 0xff8000);
            else
                cgm.bdk("Moderator option: Mute player for 48 hours: <OFF>", 256, l, 1, 0xffffff);
            if(super.anb > 106 && super.anb < 406 && super.anc > l - 13 && super.anc < l + 2 && cgl == 1)
            {
                cgl = 0;
                ccg = !ccg;
            }
        }
        l = 222;
        int i1 = 0xffffff;
        if(super.anb > 196 && super.anb < 316 && super.anc > l - 13 && super.anc < l + 2)
        {
            i1 = 0xffff00;
            if(cgl == 1)
            {
                cgl = 0;
                cei = 0;
            }
        }
        cgm.bdk("Click here to cancel", 256, l, 1, i1);
        if(cgl == 1 && (super.anb < 56 || super.anb > 456 || super.anc < 130 || super.anc > 230))
        {
            cgl = 0;
            cei = 0;
        }
    }

    protected final void cac()
    {
        if(dff)
        {
            Graphics g1 = bnf();
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
            aia(1);
            return;
        }
        if(can)
        {
            Graphics g2 = bnf();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - unable to load game!", 50, 50);
            g2.drawString("To play RuneScape make sure you play from", 50, 100);
            g2.drawString("http://www.runescape.com", 50, 150);
            aia(1);
            return;
        }
        if(cif)
        {
            Graphics g3 = bnf();
            g3.setColor(Color.black);
            g3.fillRect(0, 0, 512, 356);
            g3.setFont(new Font("Helvetica", 1, 20));
            g3.setColor(Color.white);
            g3.drawString("Error - out of memory!", 50, 50);
            g3.drawString("Close ALL unnecessary programs", 50, 100);
            g3.drawString("and windows before loading the game", 50, 150);
            g3.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            aia(1);
            return;
        }
        try
        {
            if(cdg == 0)
            {
                cgm.bcm = false;
                bla();
            }
            if(cdg == 1)
            {
                cgm.bcm = true;
                bmh();
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
            blk();
            cif = true;
        }
    }

    private final void cad()
    {
        e.cji("torcha2");
        e.cji("torcha3");
        e.cji("torcha4");
        e.cji("skulltorcha2");
        e.cji("skulltorcha3");
        e.cji("skulltorcha4");
        e.cji("firea2");
        e.cji("firea3");
        e.cji("fireplacea2");
        e.cji("fireplacea3");
        e.cji("firespell2");
        e.cji("firespell3");
        e.cji("lightning2");
        e.cji("lightning3");
        e.cji("clawspell2");
        e.cji("clawspell3");
        e.cji("clawspell4");
        e.cji("clawspell5");
        e.cji("spellcharge2");
        e.cji("spellcharge3");
        if(ahn())
        {
            byte abyte0[] = bil("models" + w.bih + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                dff = true;
                return;
            }
            for(int i1 = 0; i1 < e.emn; i1++)
            {
                int j1 = t.ani(e.ejf[i1] + ".ob3", abyte0);
                if(j1 != 0)
                    dda[i1] = new i(abyte0, j1, true);
                else
                    dda[i1] = new i(1, 1);
                if(e.ejf[i1].equals("giantcrystal"))
                    dda[i1].agm = true;
            }

            return;
        }
        ajg(70, "Loading 3d models");
        for(int l = 0; l < e.emn; l++)
        {
            dda[l] = new i("../gamedata/models/" + e.ejf[l] + ".ob2");
            if(e.ejf[l].equals("giantcrystal"))
                dda[l].agm = true;
        }

    }

    protected final void cae(int arg0, int arg1, int arg2)
    {
        cbl[cbk] = arg1;
        cbm[cbk] = arg2;
        cbk = cbk + 1 & 0x1fff;
        for(int l = 10; l < 4000; l++)
        {
            int i1 = cbk - l & 0x1fff;
            if(cbl[i1] == arg1 && cbm[i1] == arg2)
            {
                boolean flag = false;
                for(int j1 = 1; j1 < l; j1++)
                {
                    int k1 = cbk - j1 & 0x1fff;
                    int l1 = i1 - j1 & 0x1fff;
                    if(cbl[l1] != arg1 || cbm[l1] != arg2)
                        flag = true;
                    if(cbl[k1] != cbl[l1] || cbm[k1] != cbm[l1])
                        break;
                    if(j1 == l - 1 && flag && cfm == 0 && cij == 0)
                    {
                        bkk();
                        return;
                    }
                }

            }
        }

    }

    public mudclient()
    {
        blm = false;
        bln = new f[500];
        bmd = new int[8];
        bme = new int[8];
        bmg = new int[250];
        bmi = -1;
        bmj = "";
        bnb = false;
        bnc = false;
        bnd = new int[18];
        bnf = false;
        bnh = 30;
        bnj = new int[256];
        bnk = new int[256];
        bnl = new int[256];
        bnm = -1;
        bnn = -2;
        cab = 2;
        cac = new int[18];
        can = false;
        cbb = new int[14];
        cbc = new int[14];
        cbj = false;
        cbl = new int[8192];
        cbm = new int[8192];
        cce = new int[99];
        ccf = true;
        ccg = false;
        ccj = "";
        cck = "";
        ccl = new f();
        cda = -1;
        cdb = -1;
        cdd = new int[500];
        cde = new int[500];
        cdf = 128;
        cdk = 1;
        cdn = new int[8];
        cea = new int[8];
        cec = new i[1500];
        ced = new int[8000];
        cee = new int[8000];
        cef = -1;
        ceg = -2;
        ceh = true;
        cej = 40;
        cek = new int[50];
        cel = new int[50];
        cem = new i[500];
        cen = new String[250];
        cfb = new int[256];
        cfc = new int[256];
        cfd = "";
        cfe = new f[500];
        cff = new f[500];
        cfg = new int[500];
        cfj = new int[250];
        cfk = new int[250];
        cfl = new int[50];
        cgb = new int[14];
        cgc = new int[14];
        cgd = new int[50];
        cge = new int[50];
        cgf = new int[50];
        cgg = new int[50];
        cgn = 512;
        cha = 334;
        chb = 9;
        chc = new int[5];
        chh = new int[35];
        chi = new int[35];
        chj = new int[35];
        chl = false;
        chm = "";
        chn = "";
        cib = 2;
        cic = -1;
        cid = -1;
        cie = -1;
        cif = false;
        cig = new String[250];
        cii = 128;
        cil = 1;
        cim = 2;
        cin = 2;
        cja = 8;
        cjb = 14;
        cjd = 1;
        cjg = new int[5];
        cji = false;
        cjj = false;
        cjk = false;
        ckf = false;
        ckg = new int[18];
        ckh = new String[5];
        clb = false;
        clc = false;
        cld = false;
        clg = -1;
        cmc = false;
        cmd = false;
        cme = new f[4000];
        cmj = new int[14];
        cmk = new int[14];
        cml = true;
        cnb = new String[50];
        cnc = 48;
        cnf = new f[500];
        cng = new int[5000];
        cnh = new int[5000];
        cni = new int[5000];
        cnj = new int[5000];
        cnl = new int[250];
        cnn = new String[5];
        dad = false;
        daf = false;
        daj = false;
        dak = false;
        dal = false;
        dam = false;
        dan = new boolean[50];
        dba = 550;
        dcc = new int[8];
        dcd = new int[8];
        dcl = false;
        dcm = new boolean[500];
        dcn = 0xbc614e;
        dda = new i[1000];
        ddb = false;
        ddc = new f[5000];
        ddi = new int[50];
        ddj = new int[50];
        ddk = new int[50];
        ddl = new int[50];
        ddm = new int[500];
        ddn = new int[500];
        dea = "";
        deb = "";
        def = new int[256];
        deg = new int[256];
        dei = new int[8];
        dej = new int[8];
        dek = false;
        del = "";
        dem = false;
        den = false;
        dfa = new int[250];
        dfb = new int[250];
        dfc = new int[250];
        dfd = false;
        dfe = false;
        dff = false;
        dfi = new int[14];
        dfj = new int[14];
        dfm = new int[50];
        dfn = new int[50];
        dga = new int[50];
        dgb = new int[50];
        dgd = new boolean[1500];
        dgf = new int[1500];
        dgg = new int[1500];
        dgh = new int[1500];
        dgi = new int[1500];
        dgm = -1;
        dgn = new boolean[50];
        dha = false;
        dhb = "";
        dhc = false;
    }

    private final int bla = 250;
    private final int blb = 5;
    private final int blc = 50;
    private final int bld = 18;
    private final int ble = 500;
    private final int blf = 1500;
    private final int blg = 5000;
    private final int blh = 5000;
    private final int bli = 500;
    private final int blj = 4000;
    private final int blk = 500;
    private final int bll = 8000;
    private boolean blm;
    private f bln[];
    private int bma;
    private int bmb;
    private int bmc;
    private int bmd[];
    private int bme[];
    private x bmf;
    private int bmg[];
    private long bmh;
    private int bmi;
    String bmj;
    private int bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int bna;
    private boolean bnb;
    private boolean bnc;
    private int bnd[];
    private int bne;
    private boolean bnf;
    private h bng;
    private int bnh;
    private final String bni[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int bnj[];
    private int bnk[];
    private int bnl[];
    private int bnm;
    private int bnn;
    private int caa;
    private int cab;
    private int cac[];
    private int cad;
    private int cae;
    private int caf;
    private int cag;
    private int cah;
    private int cai[][] = {
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
    private int caj;
    private int cak;
    private int cal;
    private int cam;
    private boolean can;
    private int cba;
    private int cbb[];
    private int cbc[];
    private int cbd;
    private final String cbe[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    private int cbf;
    private int cbg;
    private int cbh;
    private int cbi;
    private boolean cbj;
    private int cbk;
    int cbl[];
    int cbm[];
    private int cbn;
    private int cca;
    private int ccb;
    private int ccc;
    private int ccd;
    private int cce[];
    private boolean ccf;
    private boolean ccg;
    private n cch;
    private int cci;
    private String ccj;
    private String cck;
    private f ccl;
    int ccm;
    int ccn;
    int cda;
    private int cdb;
    private String cdc;
    private int cdd[];
    private int cde[];
    private int cdf;
    private int cdg;
    private int cdh;
    private long cdi;
    private int cdj;
    private int cdk;
    private int cdl;
    private int cdm;
    private int cdn[];
    private int cea[];
    private int ceb[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    private i cec[];
    private int ced[];
    private int cee[];
    private int cef;
    private int ceg;
    private boolean ceh;
    private int cei;
    private int cej;
    private int cek[];
    private int cel[];
    private i cem[];
    private String cen[];
    private int cfa;
    private int cfb[];
    private int cfc[];
    private String cfd;
    private f cfe[];
    private f cff[];
    private int cfg[];
    private int cfh;
    private int cfi;
    private int cfj[];
    private int cfk[];
    private int cfl[];
    private int cfm;
    private int cfn;
    private int cga;
    private int cgb[];
    private int cgc[];
    private int cgd[];
    private int cge[];
    private int cgf[];
    private int cgg[];
    private int cgh;
    private int cgi;
    private int cgj;
    private int cgk;
    private int cgl;
    private k cgm;
    private int cgn;
    private int cha;
    private int chb;
    private int chc[];
    private h chd;
    int che;
    int chf;
    private int chg;
    private int chh[];
    private int chi[];
    private int chj[];
    private int chk;
    private boolean chl;
    private String chm;
    private String chn;
    private int cia;
    private int cib;
    private int cic;
    private int cid;
    private int cie;
    private boolean cif;
    private String cig[];
    private int cih;
    private int cii;
    private int cij;
    private int cik;
    private int cil;
    private int cim;
    private int cin;
    private int cja;
    private int cjb;
    private int cjc;
    private int cjd;
    private int cje;
    private int cjf;
    private int cjg[];
    private Graphics cjh;
    private boolean cji;
    private boolean cjj;
    private boolean cjk;
    private final String cjl[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    private int cjm;
    private int cjn;
    private int cka;
    private int ckb;
    private int ckc;
    private int ckd;
    private int cke;
    private boolean ckf;
    private int ckg[];
    private String ckh[];
    private int cki;
    private int ckj[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    private h ckk;
    private int ckl;
    private int ckm;
    private int ckn;
    private int cla;
    private boolean clb;
    private boolean clc;
    private boolean cld;
    private int cle;
    private int clf;
    private int clg;
    private int clh;
    private int cli;
    private int clj;
    private int clk;
    private int cll;
    private final String clm[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    private int cln;
    private int cma;
    private int cmb;
    private boolean cmc;
    private boolean cmd;
    private f cme[];
    private int cmf;
    private int cmg;
    private int cmh;
    private int cmi;
    private int cmj[];
    private int cmk[];
    private boolean cml;
    private int cmm;
    private int cmn;
    private int cna;
    String cnb[];
    private int cnc;
    private int cnd;
    private d cne;
    private f cnf[];
    private int cng[];
    private int cnh[];
    private int cni[];
    private int cnj[];
    private byte cnk[];
    private int cnl[];
    private int cnm;
    private String cnn[];
    private int daa;
    int dab;
    int dac;
    private boolean dad;
    private int dae;
    private boolean daf;
    private int dag;
    private int dah;
    private final int dai[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    private boolean daj;
    private boolean dak;
    private boolean dal;
    private boolean dam;
    private boolean dan[];
    private int dba;
    private int dbb;
    private int dbc;
    private int dbd;
    private int dbe;
    private int dbf;
    private int dbg;
    private int dbh;
    private int dbi;
    private int dbj;
    private int dbk;
    private int dbl;
    private int dbm;
    private int dbn;
    private int dca[] = {
        0, 1, 2, 1
    };
    private int dcb;
    private int dcc[];
    private int dcd[];
    private h dce;
    int dcf;
    int dcg;
    int dch;
    int dci;
    int dcj;
    private int dck;
    private boolean dcl;
    private boolean dcm[];
    private int dcn;
    private i dda[];
    private boolean ddb;
    private f ddc[];
    private h ddd;
    int dde;
    int ddf;
    long ddg;
    private final int ddh[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    private int ddi[];
    private int ddj[];
    private int ddk[];
    private int ddl[];
    private int ddm[];
    private int ddn[];
    private String dea;
    private String deb;
    private int dec;
    private int ded;
    private int dee;
    private int def[];
    private int deg[];
    private int deh;
    private int dei[];
    private int dej[];
    private boolean dek;
    private String del;
    private boolean dem;
    private boolean den;
    private int dfa[];
    private int dfb[];
    private int dfc[];
    private boolean dfd;
    private boolean dfe;
    private boolean dff;
    private h dfg;
    private int dfh;
    private int dfi[];
    private int dfj[];
    private String dfk;
    private final int dfl[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    private int dfm[];
    private int dfn[];
    private int dga[];
    private int dgb[];
    private h dgc;
    private boolean dgd[];
    private int dge;
    private int dgf[];
    private int dgg[];
    private int dgh[];
    private int dgi[];
    private int dgj;
    private int dgk;
    private int dgl;
    private int dgm;
    private boolean dgn[];
    private boolean dha;
    private String dhb;
    private boolean dhc;
    private h dhd;
    int dhe;
    int dhf;
    private int dhg;
    private int dhh;
    private int dhi;
    private int dhj;
    private int dhk;
    private final String dhl[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
}