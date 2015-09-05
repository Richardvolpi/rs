// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:30 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.IOException;

public class x
{

    public void chb(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        int k = e.elg[arg0];
        if(ehc[arg1][arg2] < 0x13880)
            ehc[arg1][arg2] += 0x13880 + k;
        if(ehc[arg3][arg4] < 0x13880)
            ehc[arg3][arg4] += 0x13880 + k;
    }

    public int chc(int arg0, int arg1, int arg2)
    {
        int k = chm(arg0, arg1, arg2);
        if(k == 0)
            return -1;
        int l = e.ekn[k - 1];
        return l != 2 ? 0 : 1;
    }

    public void chd(int arg0, int arg1, int arg2)
    {
        if(arg0 < 0 || arg1 < 0 || arg0 >= 95 || arg1 >= 95)
            return;
        if(e.enn[arg2] == 1 || e.enn[arg2] == 2)
        {
            int k = cjf(arg0, arg1);
            int l;
            int i1;
            if(k == 0 || k == 4)
            {
                l = e.enl[arg2];
                i1 = e.enm[arg2];
            } else
            {
                i1 = e.enl[arg2];
                l = e.enm[arg2];
            }
            for(int j1 = arg0; j1 < arg0 + l; j1++)
            {
                for(int k1 = arg1; k1 < arg1 + i1; k1++)
                    if(e.enn[arg2] == 1)
                        ehj[j1][k1] &= 0xffbf;
                    else
                    if(k == 0)
                    {
                        ehj[j1][k1] &= 0xfffd;
                        if(j1 > 0)
                            cih(j1 - 1, k1, 8);
                    } else
                    if(k == 2)
                    {
                        ehj[j1][k1] &= 0xfffb;
                        if(k1 < 95)
                            cih(j1, k1 + 1, 1);
                    } else
                    if(k == 4)
                    {
                        ehj[j1][k1] &= 0xfff7;
                        if(j1 < 95)
                            cih(j1 + 1, k1, 2);
                    } else
                    if(k == 6)
                    {
                        ehj[j1][k1] &= 0xfffe;
                        if(k1 > 0)
                            cih(j1, k1 - 1, 4);
                    }

            }

            chl(arg0, arg1, l, i1);
        }
    }

    public void che(i arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        chh(arg2, arg3, 40);
        chh(arg4, arg5, 40);
        int k = e.elg[arg1];
        int l = e.elh[arg1];
        int i1 = e.eli[arg1];
        int j1 = arg2 * 128;
        int k1 = arg3 * 128;
        int l1 = arg4 * 128;
        int i2 = arg5 * 128;
        int j2 = arg0.afg(j1, -ehc[arg2][arg3], k1);
        int k2 = arg0.afg(j1, -ehc[arg2][arg3] - k, k1);
        int l2 = arg0.afg(l1, -ehc[arg4][arg5] - k, i2);
        int i3 = arg0.afg(l1, -ehc[arg4][arg5], i2);
        int ai[] = {
            j2, k2, l2, i3
        };
        int j3 = arg0.afi(4, ai, l, i1);
        if(e.elk[arg1] == 5)
        {
            arg0.aha[j3] = 30000 + arg1;
            return;
        } else
        {
            arg0.aha[j3] = 0;
            return;
        }
    }

    public void chf(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        int k = arg0 * 3;
        int l = arg1 * 3;
        int i1 = egi.cgg(arg3);
        int j1 = egi.cgg(arg4);
        i1 = i1 >> 1 & 0x7f7f7f;
        j1 = j1 >> 1 & 0x7f7f7f;
        if(arg2 == 0)
        {
            egh.bbb(k, l, 3, i1);
            egh.bbb(k, l + 1, 2, i1);
            egh.bbb(k, l + 2, 1, i1);
            egh.bbb(k + 2, l + 1, 1, j1);
            egh.bbb(k + 1, l + 2, 2, j1);
            return;
        }
        if(arg2 == 1)
        {
            egh.bbb(k, l, 3, j1);
            egh.bbb(k + 1, l + 1, 2, j1);
            egh.bbb(k + 2, l + 2, 1, j1);
            egh.bbb(k, l + 1, 1, i1);
            egh.bbb(k, l + 2, 2, i1);
        }
    }

    public boolean chg(int arg0, int arg1)
    {
        return cig(arg0, arg1) > 0 || cig(arg0 - 1, arg1) > 0 || cig(arg0 - 1, arg1 - 1) > 0 || cig(arg0, arg1 - 1) > 0;
    }

    public void chh(int arg0, int arg1, int arg2)
    {
        int k = arg0 / 12;
        int l = arg1 / 12;
        int i1 = (arg0 - 1) / 12;
        int j1 = (arg1 - 1) / 12;
        cjb(k, l, arg0, arg1, arg2);
        if(k != i1)
            cjb(i1, l, arg0, arg1, arg2);
        if(l != j1)
            cjb(k, j1, arg0, arg1, arg2);
        if(k != i1 && l != j1)
            cjb(i1, j1, arg0, arg1, arg2);
    }

    public int chi(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehb[byte0][arg0 * 48 + arg1] & 0xff;
    }

    public int chj(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehk[byte0][arg0 * 48 + arg1] & 0xff;
    }

    public void chk(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg0 < 0 || arg1 < 0 || arg0 >= 95 || arg1 >= 95)
            return;
        if(e.elj[arg3] == 1)
        {
            if(arg2 == 0)
            {
                ehj[arg0][arg1] |= 1;
                if(arg1 > 0)
                    cib(arg0, arg1 - 1, 4);
            } else
            if(arg2 == 1)
            {
                ehj[arg0][arg1] |= 2;
                if(arg0 > 0)
                    cib(arg0 - 1, arg1, 8);
            } else
            if(arg2 == 2)
                ehj[arg0][arg1] |= 0x10;
            else
            if(arg2 == 3)
                ehj[arg0][arg1] |= 0x20;
            chl(arg0, arg1, 1, 1);
        }
    }

    public void chl(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg0 < 1 || arg1 < 1 || arg0 + arg2 >= 96 || arg1 + arg3 >= 96)
            return;
        for(int k = arg0; k <= arg0 + arg2; k++)
        {
            for(int l = arg1; l <= arg1 + arg3; l++)
                if((cjc(k, l) & 0x63) != 0 || (cjc(k - 1, l) & 0x59) != 0 || (cjc(k, l - 1) & 0x56) != 0 || (cjc(k - 1, l - 1) & 0x6c) != 0)
                    chh(k, l, 35);
                else
                    chh(k, l, 0);

        }

    }

    public int chm(int arg0, int arg1, int arg2)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehl[byte0][arg0 * 48 + arg1] & 0xff;
    }

    public void chn(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg0 < 0 || arg1 < 0 || arg0 >= 95 || arg1 >= 95)
            return;
        if(e.elj[arg3] == 1)
        {
            if(arg2 == 0)
            {
                ehj[arg0][arg1] &= 0xfffe;
                if(arg1 > 0)
                    cih(arg0, arg1 - 1, 4);
            } else
            if(arg2 == 1)
            {
                ehj[arg0][arg1] &= 0xfffd;
                if(arg0 > 0)
                    cih(arg0 - 1, arg1, 8);
            } else
            if(arg2 == 2)
                ehj[arg0][arg1] &= 0xffef;
            else
            if(arg2 == 3)
                ehj[arg0][arg1] &= 0xffdf;
            chl(arg0, arg1, 1, 1);
        }
    }

    public int cia(int arg0, int arg1)
    {
        int k = arg0 >> 7;
        int l = arg1 >> 7;
        int i1 = arg0 & 0x7f;
        int j1 = arg1 & 0x7f;
        if(k < 0 || l < 0 || k >= 95 || l >= 95)
            return 0;
        int k1;
        int l1;
        int i2;
        if(i1 <= 128 - j1)
        {
            k1 = cii(k, l);
            l1 = cii(k + 1, l) - k1;
            i2 = cii(k, l + 1) - k1;
        } else
        {
            k1 = cii(k + 1, l + 1);
            l1 = cii(k, l + 1) - k1;
            i2 = cii(k + 1, l) - k1;
            i1 = 128 - i1;
            j1 = 128 - j1;
        }
        int j2 = k1 + (l1 * i1) / 128 + (i2 * j1) / 128;
        return j2;
    }

    public void cib(int arg0, int arg1, int arg2)
    {
        ehj[arg0][arg1] |= arg2;
    }

    public int cic(int arg0, int arg1, int arg2, int arg3)
    {
        int k = chm(arg0, arg1, arg2);
        if(k == 0)
            return arg3;
        else
            return e.ekm[k - 1];
    }

    public boolean cid(int arg0, int arg1)
    {
        return cig(arg0, arg1) > 0 && cig(arg0 - 1, arg1) > 0 && cig(arg0 - 1, arg1 - 1) > 0 && cig(arg0, arg1 - 1) > 0;
    }

    public void cie(i arg0[])
    {
        for(int k = 0; k < 94; k++)
        {
            for(int l = 0; l < 94; l++)
                if(cje(k, l) > 48000 && cje(k, l) < 60000)
                {
                    int i1 = cje(k, l) - 48001;
                    int j1 = cjf(k, l);
                    int k1;
                    int l1;
                    if(j1 == 0 || j1 == 4)
                    {
                        k1 = e.enl[i1];
                        l1 = e.enm[i1];
                    } else
                    {
                        l1 = e.enl[i1];
                        k1 = e.enm[i1];
                    }
                    cij(k, l, i1);
                    i i2 = arg0[e.enk[i1]].ahd(false, true, false, false);
                    int j2 = ((k + k + k1) * 128) / 2;
                    int l2 = ((l + l + l1) * 128) / 2;
                    i2.agd(j2, -cia(j2, l2), l2);
                    i2.agc(0, cjf(k, l) * 32, 0);
                    egi.cdj(i2);
                    i2.afm(48, 48, -50, -10, -50);
                    if(k1 > 1 || l1 > 1)
                    {
                        for(int j3 = k; j3 < k + k1; j3++)
                        {
                            for(int k3 = l; k3 < l + l1; k3++)
                                if((j3 > k || k3 > l) && cje(j3, k3) - 48001 == i1)
                                {
                                    int k2 = j3;
                                    int i3 = k3;
                                    byte byte0 = 0;
                                    if(k2 >= 48 && i3 < 48)
                                    {
                                        byte0 = 1;
                                        k2 -= 48;
                                    } else
                                    if(k2 < 48 && i3 >= 48)
                                    {
                                        byte0 = 2;
                                        i3 -= 48;
                                    } else
                                    if(k2 >= 48 && i3 >= 48)
                                    {
                                        byte0 = 3;
                                        k2 -= 48;
                                        i3 -= 48;
                                    }
                                    ehh[byte0][k2 * 48 + i3] = 0;
                                }

                        }

                    }
                }

        }

    }

    public void cif()
    {
        for(int k = 0; k < 96; k++)
        {
            for(int l = 0; l < 96; l++)
                if(chm(k, l, 0) == 250)
                    if(k == 47 && chm(k + 1, l, 0) != 250 && chm(k + 1, l, 0) != 2)
                        cja(k, l, 9);
                    else
                    if(l == 47 && chm(k, l + 1, 0) != 250 && chm(k, l + 1, 0) != 2)
                        cja(k, l, 9);
                    else
                        cja(k, l, 2);

        }

    }

    public int cig(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehg[byte0][arg0 * 48 + arg1];
    }

    public void cih(int arg0, int arg1, int arg2)
    {
        ehj[arg0][arg1] &= 65535 - arg2;
    }

    public int cii(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return (eie[byte0][arg0 * 48 + arg1] & 0xff) * 3;
    }

    public void cij(int arg0, int arg1, int arg2)
    {
        if(arg0 < 0 || arg1 < 0 || arg0 >= 95 || arg1 >= 95)
            return;
        if(e.enn[arg2] == 1 || e.enn[arg2] == 2)
        {
            int k = cjf(arg0, arg1);
            int l;
            int i1;
            if(k == 0 || k == 4)
            {
                l = e.enl[arg2];
                i1 = e.enm[arg2];
            } else
            {
                i1 = e.enl[arg2];
                l = e.enm[arg2];
            }
            for(int j1 = arg0; j1 < arg0 + l; j1++)
            {
                for(int k1 = arg1; k1 < arg1 + i1; k1++)
                    if(e.enn[arg2] == 1)
                        ehj[j1][k1] |= 0x40;
                    else
                    if(k == 0)
                    {
                        ehj[j1][k1] |= 2;
                        if(j1 > 0)
                            cib(j1 - 1, k1, 8);
                    } else
                    if(k == 2)
                    {
                        ehj[j1][k1] |= 4;
                        if(k1 < 95)
                            cib(j1, k1 + 1, 1);
                    } else
                    if(k == 4)
                    {
                        ehj[j1][k1] |= 8;
                        if(j1 < 95)
                            cib(j1 + 1, k1, 2);
                    } else
                    if(k == 6)
                    {
                        ehj[j1][k1] |= 1;
                        if(k1 > 0)
                            cib(j1, k1 - 1, 4);
                    }

            }

            chl(arg0, arg1, l, i1);
        }
    }

    public void cik()
    {
        if(eih)
            egi.cdl();
        for(int k = 0; k < 64; k++)
        {
            ehi[k] = null;
            for(int l = 0; l < 4; l++)
                ehe[l][k] = null;

            for(int i1 = 0; i1 < 4; i1++)
                ehf[i1][k] = null;

        }

        System.gc();
    }

    public void cil(int arg0, int arg1, int arg2, int arg3)
    {
        String s = "m" + arg2 + arg0 / 10 + arg0 % 10 + arg1 / 10 + arg1 % 10;
        int k;
        try
        {
            if(egj != null)
            {
                byte abyte0[] = t.ank(s + ".hei", 0, egj);
                if(abyte0 == null && eia != null)
                    abyte0 = t.ank(s + ".hei", 0, eia);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int l = 0;
                    int i2 = 0;
                    for(int l2 = 0; l2 < 2304;)
                    {
                        int k3 = abyte0[l++] & 0xff;
                        if(k3 < 128)
                        {
                            eie[arg3][l2++] = (byte)k3;
                            i2 = k3;
                        }
                        if(k3 >= 128)
                        {
                            for(int k4 = 0; k4 < k3 - 128; k4++)
                                eie[arg3][l2++] = (byte)i2;

                        }
                    }

                    i2 = 64;
                    for(int l3 = 0; l3 < 48; l3++)
                    {
                        for(int l4 = 0; l4 < 48; l4++)
                        {
                            i2 = eie[arg3][l4 * 48 + l3] + i2 & 0x7f;
                            eie[arg3][l4 * 48 + l3] = (byte)(i2 * 2);
                        }

                    }

                    i2 = 0;
                    for(int i5 = 0; i5 < 2304;)
                    {
                        int l5 = abyte0[l++] & 0xff;
                        if(l5 < 128)
                        {
                            ehk[arg3][i5++] = (byte)l5;
                            i2 = l5;
                        }
                        if(l5 >= 128)
                        {
                            for(int i7 = 0; i7 < l5 - 128; i7++)
                                ehk[arg3][i5++] = (byte)i2;

                        }
                    }

                    i2 = 35;
                    for(int i6 = 0; i6 < 48; i6++)
                    {
                        for(int j7 = 0; j7 < 48; j7++)
                        {
                            i2 = ehk[arg3][j7 * 48 + i6] + i2 & 0x7f;
                            ehk[arg3][j7 * 48 + i6] = (byte)(i2 * 2);
                        }

                    }

                } else
                {
                    for(int i1 = 0; i1 < 2304; i1++)
                    {
                        eie[arg3][i1] = 0;
                        ehk[arg3][i1] = 0;
                    }

                }
                abyte0 = t.ank(s + ".dat", 0, egk);
                if(abyte0 == null && eib != null)
                    abyte0 = t.ank(s + ".dat", 0, eib);
                if(abyte0 == null || abyte0.length == 0)
                    throw new IOException();
                int j1 = 0;
                for(int j2 = 0; j2 < 2304; j2++)
                    eid[arg3][j2] = abyte0[j1++];

                for(int i3 = 0; i3 < 2304; i3++)
                    ehb[arg3][i3] = abyte0[j1++];

                for(int i4 = 0; i4 < 2304; i4++)
                    ehh[arg3][i4] = abyte0[j1++] & 0xff;

                for(int j5 = 0; j5 < 2304; j5++)
                {
                    int j6 = abyte0[j1++] & 0xff;
                    if(j6 > 0)
                        ehh[arg3][j5] = j6 + 12000;
                }

                for(int k6 = 0; k6 < 2304;)
                {
                    int k7 = abyte0[j1++] & 0xff;
                    if(k7 < 128)
                    {
                        ehg[arg3][k6++] = (byte)k7;
                    } else
                    {
                        for(int j8 = 0; j8 < k7 - 128; j8++)
                            ehg[arg3][k6++] = 0;

                    }
                }

                int l7 = 0;
                for(int k8 = 0; k8 < 2304;)
                {
                    int i9 = abyte0[j1++] & 0xff;
                    if(i9 < 128)
                    {
                        ehl[arg3][k8++] = (byte)i9;
                        l7 = i9;
                    } else
                    {
                        for(int l9 = 0; l9 < i9 - 128; l9++)
                            ehl[arg3][k8++] = (byte)l7;

                    }
                }

                for(int j9 = 0; j9 < 2304;)
                {
                    int i10 = abyte0[j1++] & 0xff;
                    if(i10 < 128)
                    {
                        ehd[arg3][j9++] = (byte)i10;
                    } else
                    {
                        for(int l10 = 0; l10 < i10 - 128; l10++)
                            ehd[arg3][j9++] = 0;

                    }
                }

                abyte0 = t.ank(s + ".loc", 0, egk);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int k1 = 0;
                    for(int j10 = 0; j10 < 2304;)
                    {
                        int i11 = abyte0[k1++] & 0xff;
                        if(i11 < 128)
                            ehh[arg3][j10++] = i11 + 48000;
                        else
                            j10 += i11 - 128;
                    }

                    return;
                }
            } else
            {
                byte abyte1[] = new byte[20736];
                t.amk("../gamedata/maps/" + s + ".jm", abyte1, 20736);
                int l1 = 0;
                int k2 = 0;
                for(int j3 = 0; j3 < 2304; j3++)
                {
                    l1 = l1 + abyte1[k2++] & 0xff;
                    eie[arg3][j3] = (byte)l1;
                }

                l1 = 0;
                for(int j4 = 0; j4 < 2304; j4++)
                {
                    l1 = l1 + abyte1[k2++] & 0xff;
                    ehk[arg3][j4] = (byte)l1;
                }

                for(int k5 = 0; k5 < 2304; k5++)
                    eid[arg3][k5] = abyte1[k2++];

                for(int l6 = 0; l6 < 2304; l6++)
                    ehb[arg3][l6] = abyte1[k2++];

                for(int i8 = 0; i8 < 2304; i8++)
                {
                    ehh[arg3][i8] = (abyte1[k2] & 0xff) * 256 + (abyte1[k2 + 1] & 0xff);
                    k2 += 2;
                }

                for(int l8 = 0; l8 < 2304; l8++)
                    ehg[arg3][l8] = abyte1[k2++];

                for(int k9 = 0; k9 < 2304; k9++)
                    ehl[arg3][k9] = abyte1[k2++];

                for(int k10 = 0; k10 < 2304; k10++)
                    ehd[arg3][k10] = abyte1[k2++];

            }
            return;
        }
        catch(IOException _ex)
        {
            k = 0;
        }
        for(; k < 2304; k++)
        {
            eie[arg3][k] = 0;
            ehk[arg3][k] = 0;
            eid[arg3][k] = 0;
            ehb[arg3][k] = 0;
            ehh[arg3][k] = 0;
            ehg[arg3][k] = 0;
            ehl[arg3][k] = 0;
            if(arg2 == 0)
                ehl[arg3][k] = -6;
            if(arg2 == 3)
                ehl[arg3][k] = 8;
            ehd[arg3][k] = 0;
        }

    }

    public void cim(int arg0, int arg1, int arg2, boolean arg3)
    {
        int k = (arg0 + 24) / 48;
        int l = (arg1 + 24) / 48;
        cil(k - 1, l - 1, arg2, 0);
        cil(k, l - 1, arg2, 1);
        cil(k - 1, l, arg2, 2);
        cil(k, l, arg2, 3);
        cif();
        if(eii == null)
            eii = new i(18688, 18688, true, true, false, false, true);
        if(arg3)
        {
            egh.baj();
            for(int i1 = 0; i1 < 96; i1++)
            {
                for(int k1 = 0; k1 < 96; k1++)
                    ehj[i1][k1] = 0;

            }

            i l1 = eii;
            l1.aen();
            for(int j2 = 0; j2 < 96; j2++)
            {
                for(int i3 = 0; i3 < 96; i3++)
                {
                    int i4 = -cii(j2, i3);
                    if(chm(j2, i3, arg2) > 0 && e.ekn[chm(j2, i3, arg2) - 1] == 4)
                        i4 = 0;
                    if(chm(j2 - 1, i3, arg2) > 0 && e.ekn[chm(j2 - 1, i3, arg2) - 1] == 4)
                        i4 = 0;
                    if(chm(j2, i3 - 1, arg2) > 0 && e.ekn[chm(j2, i3 - 1, arg2) - 1] == 4)
                        i4 = 0;
                    if(chm(j2 - 1, i3 - 1, arg2) > 0 && e.ekn[chm(j2 - 1, i3 - 1, arg2) - 1] == 4)
                        i4 = 0;
                    int j5 = l1.afg(j2 * 128, i4, i3 * 128);
                    int j7 = (int)(Math.random() * 10D) - 5;
                    l1.aga(j5, j7);
                }

            }

            for(int j3 = 0; j3 < 95; j3++)
            {
                for(int j4 = 0; j4 < 95; j4++)
                {
                    int k5 = chj(j3, j4);
                    int k7 = egm[k5];
                    int i10 = k7;
                    int k12 = k7;
                    int l14 = 0;
                    if(arg2 == 1 || arg2 == 2)
                    {
                        k7 = 0xbc614e;
                        i10 = 0xbc614e;
                        k12 = 0xbc614e;
                    }
                    if(chm(j3, j4, arg2) > 0)
                    {
                        int l16 = chm(j3, j4, arg2);
                        int l5 = e.ekn[l16 - 1];
                        int i19 = chc(j3, j4, arg2);
                        k7 = i10 = e.ekm[l16 - 1];
                        if(l5 == 4)
                        {
                            k7 = 1;
                            i10 = 1;
                            if(l16 == 12)
                            {
                                k7 = 31;
                                i10 = 31;
                            }
                        }
                        if(l5 == 5)
                        {
                            if(cje(j3, j4) > 0 && cje(j3, j4) < 24000)
                                if(cic(j3 - 1, j4, arg2, k12) != 0xbc614e && cic(j3, j4 - 1, arg2, k12) != 0xbc614e)
                                {
                                    k7 = cic(j3 - 1, j4, arg2, k12);
                                    l14 = 0;
                                } else
                                if(cic(j3 + 1, j4, arg2, k12) != 0xbc614e && cic(j3, j4 + 1, arg2, k12) != 0xbc614e)
                                {
                                    i10 = cic(j3 + 1, j4, arg2, k12);
                                    l14 = 0;
                                } else
                                if(cic(j3 + 1, j4, arg2, k12) != 0xbc614e && cic(j3, j4 - 1, arg2, k12) != 0xbc614e)
                                {
                                    i10 = cic(j3 + 1, j4, arg2, k12);
                                    l14 = 1;
                                } else
                                if(cic(j3 - 1, j4, arg2, k12) != 0xbc614e && cic(j3, j4 + 1, arg2, k12) != 0xbc614e)
                                {
                                    k7 = cic(j3 - 1, j4, arg2, k12);
                                    l14 = 1;
                                }
                        } else
                        if(l5 != 2 || cje(j3, j4) > 0 && cje(j3, j4) < 24000)
                            if(chc(j3 - 1, j4, arg2) != i19 && chc(j3, j4 - 1, arg2) != i19)
                            {
                                k7 = k12;
                                l14 = 0;
                            } else
                            if(chc(j3 + 1, j4, arg2) != i19 && chc(j3, j4 + 1, arg2) != i19)
                            {
                                i10 = k12;
                                l14 = 0;
                            } else
                            if(chc(j3 + 1, j4, arg2) != i19 && chc(j3, j4 - 1, arg2) != i19)
                            {
                                i10 = k12;
                                l14 = 1;
                            } else
                            if(chc(j3 - 1, j4, arg2) != i19 && chc(j3, j4 + 1, arg2) != i19)
                            {
                                k7 = k12;
                                l14 = 1;
                            }
                        if(e.ela[l16 - 1] != 0)
                            ehj[j3][j4] |= 0x40;
                        if(e.ekn[l16 - 1] == 2)
                            ehj[j3][j4] |= 0x80;
                    }
                    chf(j3, j4, l14, k7, i10);
                    int i17 = ((cii(j3 + 1, j4 + 1) - cii(j3 + 1, j4)) + cii(j3, j4 + 1)) - cii(j3, j4);
                    if(k7 != i10 || i17 != 0)
                    {
                        int ai[] = new int[3];
                        int ai7[] = new int[3];
                        if(l14 == 0)
                        {
                            if(k7 != 0xbc614e)
                            {
                                ai[0] = j4 + j3 * 96 + 96;
                                ai[1] = j4 + j3 * 96;
                                ai[2] = j4 + j3 * 96 + 1;
                                int l21 = l1.afi(3, ai, 0xbc614e, k7);
                                egl[l21] = j3;
                                eic[l21] = j4;
                                l1.aha[l21] = 0x30d40 + l21;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 1;
                                ai7[1] = j4 + j3 * 96 + 96 + 1;
                                ai7[2] = j4 + j3 * 96 + 96;
                                int i22 = l1.afi(3, ai7, 0xbc614e, i10);
                                egl[i22] = j3;
                                eic[i22] = j4;
                                l1.aha[i22] = 0x30d40 + i22;
                            }
                        } else
                        {
                            if(k7 != 0xbc614e)
                            {
                                ai[0] = j4 + j3 * 96 + 1;
                                ai[1] = j4 + j3 * 96 + 96 + 1;
                                ai[2] = j4 + j3 * 96;
                                int j22 = l1.afi(3, ai, 0xbc614e, k7);
                                egl[j22] = j3;
                                eic[j22] = j4;
                                l1.aha[j22] = 0x30d40 + j22;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 96;
                                ai7[1] = j4 + j3 * 96;
                                ai7[2] = j4 + j3 * 96 + 96 + 1;
                                int k22 = l1.afi(3, ai7, 0xbc614e, i10);
                                egl[k22] = j3;
                                eic[k22] = j4;
                                l1.aha[k22] = 0x30d40 + k22;
                            }
                        }
                    } else
                    if(k7 != 0xbc614e)
                    {
                        int ai1[] = new int[4];
                        ai1[0] = j4 + j3 * 96 + 96;
                        ai1[1] = j4 + j3 * 96;
                        ai1[2] = j4 + j3 * 96 + 1;
                        ai1[3] = j4 + j3 * 96 + 96 + 1;
                        int l19 = l1.afi(4, ai1, 0xbc614e, k7);
                        egl[l19] = j3;
                        eic[l19] = j4;
                        l1.aha[l19] = 0x30d40 + l19;
                    }
                }

            }

            for(int k4 = 1; k4 < 95; k4++)
            {
                for(int i6 = 1; i6 < 95; i6++)
                    if(chm(k4, i6, arg2) > 0 && e.ekn[chm(k4, i6, arg2) - 1] == 4)
                    {
                        int l7 = e.ekm[chm(k4, i6, arg2) - 1];
                        int j10 = l1.afg(k4 * 128, -cii(k4, i6), i6 * 128);
                        int l12 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6), i6 * 128);
                        int i15 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6 + 1), (i6 + 1) * 128);
                        int j17 = l1.afg(k4 * 128, -cii(k4, i6 + 1), (i6 + 1) * 128);
                        int ai2[] = {
                            j10, l12, i15, j17
                        };
                        int i20 = l1.afi(4, ai2, l7, 0xbc614e);
                        egl[i20] = k4;
                        eic[i20] = i6;
                        l1.aha[i20] = 0x30d40 + i20;
                        chf(k4, i6, 0, l7, l7);
                    } else
                    if(chm(k4, i6, arg2) == 0 || e.ekn[chm(k4, i6, arg2) - 1] != 3)
                    {
                        if(chm(k4, i6 + 1, arg2) > 0 && e.ekn[chm(k4, i6 + 1, arg2) - 1] == 4)
                        {
                            int i8 = e.ekm[chm(k4, i6 + 1, arg2) - 1];
                            int k10 = l1.afg(k4 * 128, -cii(k4, i6), i6 * 128);
                            int i13 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6), i6 * 128);
                            int j15 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int k17 = l1.afg(k4 * 128, -cii(k4, i6 + 1), (i6 + 1) * 128);
                            int ai3[] = {
                                k10, i13, j15, k17
                            };
                            int j20 = l1.afi(4, ai3, i8, 0xbc614e);
                            egl[j20] = k4;
                            eic[j20] = i6;
                            l1.aha[j20] = 0x30d40 + j20;
                            chf(k4, i6, 0, i8, i8);
                        }
                        if(chm(k4, i6 - 1, arg2) > 0 && e.ekn[chm(k4, i6 - 1, arg2) - 1] == 4)
                        {
                            int j8 = e.ekm[chm(k4, i6 - 1, arg2) - 1];
                            int l10 = l1.afg(k4 * 128, -cii(k4, i6), i6 * 128);
                            int j13 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6), i6 * 128);
                            int k15 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int l17 = l1.afg(k4 * 128, -cii(k4, i6 + 1), (i6 + 1) * 128);
                            int ai4[] = {
                                l10, j13, k15, l17
                            };
                            int k20 = l1.afi(4, ai4, j8, 0xbc614e);
                            egl[k20] = k4;
                            eic[k20] = i6;
                            l1.aha[k20] = 0x30d40 + k20;
                            chf(k4, i6, 0, j8, j8);
                        }
                        if(chm(k4 + 1, i6, arg2) > 0 && e.ekn[chm(k4 + 1, i6, arg2) - 1] == 4)
                        {
                            int k8 = e.ekm[chm(k4 + 1, i6, arg2) - 1];
                            int i11 = l1.afg(k4 * 128, -cii(k4, i6), i6 * 128);
                            int k13 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6), i6 * 128);
                            int l15 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int i18 = l1.afg(k4 * 128, -cii(k4, i6 + 1), (i6 + 1) * 128);
                            int ai5[] = {
                                i11, k13, l15, i18
                            };
                            int l20 = l1.afi(4, ai5, k8, 0xbc614e);
                            egl[l20] = k4;
                            eic[l20] = i6;
                            l1.aha[l20] = 0x30d40 + l20;
                            chf(k4, i6, 0, k8, k8);
                        }
                        if(chm(k4 - 1, i6, arg2) > 0 && e.ekn[chm(k4 - 1, i6, arg2) - 1] == 4)
                        {
                            int l8 = e.ekm[chm(k4 - 1, i6, arg2) - 1];
                            int j11 = l1.afg(k4 * 128, -cii(k4, i6), i6 * 128);
                            int l13 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6), i6 * 128);
                            int i16 = l1.afg((k4 + 1) * 128, -cii(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int j18 = l1.afg(k4 * 128, -cii(k4, i6 + 1), (i6 + 1) * 128);
                            int ai6[] = {
                                j11, l13, i16, j18
                            };
                            int i21 = l1.afi(4, ai6, l8, 0xbc614e);
                            egl[i21] = k4;
                            eic[i21] = i6;
                            l1.aha[i21] = 0x30d40 + i21;
                            chf(k4, i6, 0, l8, l8);
                        }
                    }

            }

            l1.afl(true, 40, 48, -50, -10, -50);
            ehi = eii.afj(0, 0, 1536, 1536, 8, 64, 233, false);
            for(int j6 = 0; j6 < 64; j6++)
                egi.cdj(ehi[j6]);

            for(int i9 = 0; i9 < 96; i9++)
            {
                for(int k11 = 0; k11 < 96; k11++)
                    ehc[i9][k11] = cii(i9, k11);

            }

        }
        eii.aen();
        int j1 = 0x606060;
        for(int i2 = 0; i2 < 95; i2++)
        {
            for(int k2 = 0; k2 < 95; k2++)
            {
                int k3 = chi(i2, k2);
                if(k3 > 0 && (e.elk[k3 - 1] == 0 || eig))
                {
                    che(eii, k3 - 1, i2, k2, i2 + 1, k2);
                    if(arg3 && e.elj[k3 - 1] != 0)
                    {
                        ehj[i2][k2] |= 1;
                        if(k2 > 0)
                            cib(i2, k2 - 1, 4);
                    }
                    if(arg3)
                        egh.bbb(i2 * 3, k2 * 3, 3, j1);
                }
                k3 = cjg(i2, k2);
                if(k3 > 0 && (e.elk[k3 - 1] == 0 || eig))
                {
                    che(eii, k3 - 1, i2, k2, i2, k2 + 1);
                    if(arg3 && e.elj[k3 - 1] != 0)
                    {
                        ehj[i2][k2] |= 2;
                        if(i2 > 0)
                            cib(i2 - 1, k2, 8);
                    }
                    if(arg3)
                        egh.bbc(i2 * 3, k2 * 3, 3, j1);
                }
                k3 = cje(i2, k2);
                if(k3 > 0 && k3 < 12000 && (e.elk[k3 - 1] == 0 || eig))
                {
                    che(eii, k3 - 1, i2, k2, i2 + 1, k2 + 1);
                    if(arg3 && e.elj[k3 - 1] != 0)
                        ehj[i2][k2] |= 0x20;
                    if(arg3)
                    {
                        egh.bbd(i2 * 3, k2 * 3, j1);
                        egh.bbd(i2 * 3 + 1, k2 * 3 + 1, j1);
                        egh.bbd(i2 * 3 + 2, k2 * 3 + 2, j1);
                    }
                }
                if(k3 > 12000 && k3 < 24000 && (e.elk[k3 - 12001] == 0 || eig))
                {
                    che(eii, k3 - 12001, i2 + 1, k2, i2, k2 + 1);
                    if(arg3 && e.elj[k3 - 12001] != 0)
                        ehj[i2][k2] |= 0x10;
                    if(arg3)
                    {
                        egh.bbd(i2 * 3 + 2, k2 * 3, j1);
                        egh.bbd(i2 * 3 + 1, k2 * 3 + 1, j1);
                        egh.bbd(i2 * 3, k2 * 3 + 2, j1);
                    }
                }
            }

        }

        if(arg3)
            egh.bbm(ehn - 1, 0, 0, 285, 285);
        eii.afl(false, 60, 24, -50, -10, -50);
        ehe[arg2] = eii.afj(0, 0, 1536, 1536, 8, 64, 338, true);
        for(int l2 = 0; l2 < 64; l2++)
            egi.cdj(ehe[arg2][l2]);

        for(int l3 = 0; l3 < 95; l3++)
        {
            for(int l4 = 0; l4 < 95; l4++)
            {
                int k6 = chi(l3, l4);
                if(k6 > 0)
                    chb(k6 - 1, l3, l4, l3 + 1, l4);
                k6 = cjg(l3, l4);
                if(k6 > 0)
                    chb(k6 - 1, l3, l4, l3, l4 + 1);
                k6 = cje(l3, l4);
                if(k6 > 0 && k6 < 12000)
                    chb(k6 - 1, l3, l4, l3 + 1, l4 + 1);
                if(k6 > 12000 && k6 < 24000)
                    chb(k6 - 12001, l3 + 1, l4, l3, l4 + 1);
            }

        }

        for(int i5 = 1; i5 < 95; i5++)
        {
            for(int l6 = 1; l6 < 95; l6++)
            {
                int j9 = cig(i5, l6);
                if(j9 > 0)
                {
                    int l11 = i5;
                    int i14 = l6;
                    int j16 = i5 + 1;
                    int k18 = l6;
                    int j19 = i5 + 1;
                    int j21 = l6 + 1;
                    int l22 = i5;
                    int j23 = l6 + 1;
                    int l23 = 0;
                    int j24 = ehc[l11][i14];
                    int l24 = ehc[j16][k18];
                    int j25 = ehc[j19][j21];
                    int l25 = ehc[l22][j23];
                    if(j24 > 0x13880)
                        j24 -= 0x13880;
                    if(l24 > 0x13880)
                        l24 -= 0x13880;
                    if(j25 > 0x13880)
                        j25 -= 0x13880;
                    if(l25 > 0x13880)
                        l25 -= 0x13880;
                    if(j24 > l23)
                        l23 = j24;
                    if(l24 > l23)
                        l23 = l24;
                    if(j25 > l23)
                        l23 = j25;
                    if(l25 > l23)
                        l23 = l25;
                    if(l23 >= 0x13880)
                        l23 -= 0x13880;
                    if(j24 < 0x13880)
                        ehc[l11][i14] = l23;
                    else
                        ehc[l11][i14] -= 0x13880;
                    if(l24 < 0x13880)
                        ehc[j16][k18] = l23;
                    else
                        ehc[j16][k18] -= 0x13880;
                    if(j25 < 0x13880)
                        ehc[j19][j21] = l23;
                    else
                        ehc[j19][j21] -= 0x13880;
                    if(l25 < 0x13880)
                        ehc[l22][j23] = l23;
                    else
                        ehc[l22][j23] -= 0x13880;
                }
            }

        }

        eii.aen();
        for(int i7 = 1; i7 < 95; i7++)
        {
            for(int k9 = 1; k9 < 95; k9++)
            {
                int i12 = cig(i7, k9);
                if(i12 > 0)
                {
                    int j14 = i7;
                    int k16 = k9;
                    int l18 = i7 + 1;
                    int k19 = k9;
                    int k21 = i7 + 1;
                    int i23 = k9 + 1;
                    int k23 = i7;
                    int i24 = k9 + 1;
                    int k24 = i7 * 128;
                    int i25 = k9 * 128;
                    int k25 = k24 + 128;
                    int i26 = i25 + 128;
                    int j26 = k24;
                    int k26 = i25;
                    int l26 = k25;
                    int i27 = i26;
                    int j27 = ehc[j14][k16];
                    int k27 = ehc[l18][k19];
                    int l27 = ehc[k21][i23];
                    int i28 = ehc[k23][i24];
                    int j28 = e.fab[i12 - 1];
                    if(cid(j14, k16) && j27 < 0x13880)
                    {
                        j27 += j28 + 0x13880;
                        ehc[j14][k16] = j27;
                    }
                    if(cid(l18, k19) && k27 < 0x13880)
                    {
                        k27 += j28 + 0x13880;
                        ehc[l18][k19] = k27;
                    }
                    if(cid(k21, i23) && l27 < 0x13880)
                    {
                        l27 += j28 + 0x13880;
                        ehc[k21][i23] = l27;
                    }
                    if(cid(k23, i24) && i28 < 0x13880)
                    {
                        i28 += j28 + 0x13880;
                        ehc[k23][i24] = i28;
                    }
                    if(j27 >= 0x13880)
                        j27 -= 0x13880;
                    if(k27 >= 0x13880)
                        k27 -= 0x13880;
                    if(l27 >= 0x13880)
                        l27 -= 0x13880;
                    if(i28 >= 0x13880)
                        i28 -= 0x13880;
                    byte byte0 = 16;
                    if(!chg(j14 - 1, k16))
                        k24 -= byte0;
                    if(!chg(j14 + 1, k16))
                        k24 += byte0;
                    if(!chg(j14, k16 - 1))
                        i25 -= byte0;
                    if(!chg(j14, k16 + 1))
                        i25 += byte0;
                    if(!chg(l18 - 1, k19))
                        k25 -= byte0;
                    if(!chg(l18 + 1, k19))
                        k25 += byte0;
                    if(!chg(l18, k19 - 1))
                        k26 -= byte0;
                    if(!chg(l18, k19 + 1))
                        k26 += byte0;
                    if(!chg(k21 - 1, i23))
                        l26 -= byte0;
                    if(!chg(k21 + 1, i23))
                        l26 += byte0;
                    if(!chg(k21, i23 - 1))
                        i26 -= byte0;
                    if(!chg(k21, i23 + 1))
                        i26 += byte0;
                    if(!chg(k23 - 1, i24))
                        j26 -= byte0;
                    if(!chg(k23 + 1, i24))
                        j26 += byte0;
                    if(!chg(k23, i24 - 1))
                        i27 -= byte0;
                    if(!chg(k23, i24 + 1))
                        i27 += byte0;
                    i12 = e.fac[i12 - 1];
                    j27 = -j27;
                    k27 = -k27;
                    l27 = -l27;
                    i28 = -i28;
                    if(cje(i7, k9) > 12000 && cje(i7, k9) < 24000 && cig(i7 - 1, k9 - 1) == 0)
                    {
                        int ai8[] = new int[3];
                        ai8[0] = eii.afg(l26, l27, i26);
                        ai8[1] = eii.afg(j26, i28, i27);
                        ai8[2] = eii.afg(k25, k27, k26);
                        eii.afi(3, ai8, i12, 0xbc614e);
                    } else
                    if(cje(i7, k9) > 12000 && cje(i7, k9) < 24000 && cig(i7 + 1, k9 + 1) == 0)
                    {
                        int ai9[] = new int[3];
                        ai9[0] = eii.afg(k24, j27, i25);
                        ai9[1] = eii.afg(k25, k27, k26);
                        ai9[2] = eii.afg(j26, i28, i27);
                        eii.afi(3, ai9, i12, 0xbc614e);
                    } else
                    if(cje(i7, k9) > 0 && cje(i7, k9) < 12000 && cig(i7 + 1, k9 - 1) == 0)
                    {
                        int ai10[] = new int[3];
                        ai10[0] = eii.afg(j26, i28, i27);
                        ai10[1] = eii.afg(k24, j27, i25);
                        ai10[2] = eii.afg(l26, l27, i26);
                        eii.afi(3, ai10, i12, 0xbc614e);
                    } else
                    if(cje(i7, k9) > 0 && cje(i7, k9) < 12000 && cig(i7 - 1, k9 + 1) == 0)
                    {
                        int ai11[] = new int[3];
                        ai11[0] = eii.afg(k25, k27, k26);
                        ai11[1] = eii.afg(l26, l27, i26);
                        ai11[2] = eii.afg(k24, j27, i25);
                        eii.afi(3, ai11, i12, 0xbc614e);
                    } else
                    if(j27 == k27 && l27 == i28)
                    {
                        int ai12[] = new int[4];
                        ai12[0] = eii.afg(k24, j27, i25);
                        ai12[1] = eii.afg(k25, k27, k26);
                        ai12[2] = eii.afg(l26, l27, i26);
                        ai12[3] = eii.afg(j26, i28, i27);
                        eii.afi(4, ai12, i12, 0xbc614e);
                    } else
                    if(j27 == i28 && k27 == l27)
                    {
                        int ai13[] = new int[4];
                        ai13[0] = eii.afg(j26, i28, i27);
                        ai13[1] = eii.afg(k24, j27, i25);
                        ai13[2] = eii.afg(k25, k27, k26);
                        ai13[3] = eii.afg(l26, l27, i26);
                        eii.afi(4, ai13, i12, 0xbc614e);
                    } else
                    {
                        boolean flag = true;
                        if(cig(i7 - 1, k9 - 1) > 0)
                            flag = false;
                        if(cig(i7 + 1, k9 + 1) > 0)
                            flag = false;
                        if(!flag)
                        {
                            int ai14[] = new int[3];
                            ai14[0] = eii.afg(k25, k27, k26);
                            ai14[1] = eii.afg(l26, l27, i26);
                            ai14[2] = eii.afg(k24, j27, i25);
                            eii.afi(3, ai14, i12, 0xbc614e);
                            int ai16[] = new int[3];
                            ai16[0] = eii.afg(j26, i28, i27);
                            ai16[1] = eii.afg(k24, j27, i25);
                            ai16[2] = eii.afg(l26, l27, i26);
                            eii.afi(3, ai16, i12, 0xbc614e);
                        } else
                        {
                            int ai15[] = new int[3];
                            ai15[0] = eii.afg(k24, j27, i25);
                            ai15[1] = eii.afg(k25, k27, k26);
                            ai15[2] = eii.afg(j26, i28, i27);
                            eii.afi(3, ai15, i12, 0xbc614e);
                            int ai17[] = new int[3];
                            ai17[0] = eii.afg(l26, l27, i26);
                            ai17[1] = eii.afg(j26, i28, i27);
                            ai17[2] = eii.afg(k25, k27, k26);
                            eii.afi(3, ai17, i12, 0xbc614e);
                        }
                    }
                }
            }

        }

        eii.afl(true, 50, 50, -50, -10, -50);
        ehf[arg2] = eii.afj(0, 0, 1536, 1536, 8, 64, 169, true);
        for(int l9 = 0; l9 < 64; l9++)
            egi.cdj(ehf[arg2][l9]);

        if(ehf[arg2][0] == null)
            throw new RuntimeException("null roof!");
        for(int j12 = 0; j12 < 96; j12++)
        {
            for(int k14 = 0; k14 < 96; k14++)
                if(ehc[j12][k14] >= 0x13880)
                    ehc[j12][k14] -= 0x13880;

        }

    }

    public void cin(int arg0, int arg1, int arg2)
    {
        cik();
        int k = (arg0 + 24) / 48;
        int l = (arg1 + 24) / 48;
        cim(arg0, arg1, arg2, true);
        if(arg2 == 0)
        {
            cim(arg0, arg1, 1, false);
            cim(arg0, arg1, 2, false);
            cil(k - 1, l - 1, arg2, 0);
            cil(k, l - 1, arg2, 1);
            cil(k - 1, l, arg2, 2);
            cil(k, l, arg2, 3);
            cif();
        }
    }

    public void cja(int arg0, int arg1, int arg2)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        ehl[byte0][arg0 * 48 + arg1] = (byte)arg2;
    }

    public void cjb(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        i k = ehi[arg0 + arg1 * 8];
        for(int l = 0; l < k.aek; l++)
            if(k.aia[l] == arg2 * 128 && k.aic[l] == arg3 * 128)
            {
                k.aga(l, arg4);
                return;
            }

    }

    public int cjc(int arg0, int arg1)
    {
        if(arg0 < 0 || arg1 < 0 || arg0 >= 96 || arg1 >= 96)
            return 0;
        else
            return ehj[arg0][arg1];
    }

    public int cjd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6[], 
            int arg7[], boolean arg8)
    {
        for(int k = 0; k < 96; k++)
        {
            for(int l = 0; l < 96; l++)
                eif[k][l] = 0;

        }

        int i1 = 0;
        int j1 = 0;
        int k1 = arg0;
        int l1 = arg1;
        eif[arg0][arg1] = 99;
        arg6[i1] = arg0;
        arg7[i1++] = arg1;
        int i2 = arg6.length;
        boolean flag = false;
        while(j1 != i1) 
        {
            k1 = arg6[j1];
            l1 = arg7[j1];
            j1 = (j1 + 1) % i2;
            if(k1 >= arg2 && k1 <= arg4 && l1 >= arg3 && l1 <= arg5)
            {
                flag = true;
                break;
            }
            if(arg8)
            {
                if(k1 > 0 && k1 - 1 >= arg2 && k1 - 1 <= arg4 && l1 >= arg3 && l1 <= arg5 && (ehj[k1 - 1][l1] & 8) == 0)
                {
                    flag = true;
                    break;
                }
                if(k1 < 95 && k1 + 1 >= arg2 && k1 + 1 <= arg4 && l1 >= arg3 && l1 <= arg5 && (ehj[k1 + 1][l1] & 2) == 0)
                {
                    flag = true;
                    break;
                }
                if(l1 > 0 && k1 >= arg2 && k1 <= arg4 && l1 - 1 >= arg3 && l1 - 1 <= arg5 && (ehj[k1][l1 - 1] & 4) == 0)
                {
                    flag = true;
                    break;
                }
                if(l1 < 95 && k1 >= arg2 && k1 <= arg4 && l1 + 1 >= arg3 && l1 + 1 <= arg5 && (ehj[k1][l1 + 1] & 1) == 0)
                {
                    flag = true;
                    break;
                }
            }
            if(k1 > 0 && eif[k1 - 1][l1] == 0 && (ehj[k1 - 1][l1] & 0x78) == 0)
            {
                arg6[i1] = k1 - 1;
                arg7[i1] = l1;
                i1 = (i1 + 1) % i2;
                eif[k1 - 1][l1] = 2;
            }
            if(k1 < 95 && eif[k1 + 1][l1] == 0 && (ehj[k1 + 1][l1] & 0x72) == 0)
            {
                arg6[i1] = k1 + 1;
                arg7[i1] = l1;
                i1 = (i1 + 1) % i2;
                eif[k1 + 1][l1] = 8;
            }
            if(l1 > 0 && eif[k1][l1 - 1] == 0 && (ehj[k1][l1 - 1] & 0x74) == 0)
            {
                arg6[i1] = k1;
                arg7[i1] = l1 - 1;
                i1 = (i1 + 1) % i2;
                eif[k1][l1 - 1] = 1;
            }
            if(l1 < 95 && eif[k1][l1 + 1] == 0 && (ehj[k1][l1 + 1] & 0x71) == 0)
            {
                arg6[i1] = k1;
                arg7[i1] = l1 + 1;
                i1 = (i1 + 1) % i2;
                eif[k1][l1 + 1] = 4;
            }
            if(k1 > 0 && l1 > 0 && (ehj[k1][l1 - 1] & 0x74) == 0 && (ehj[k1 - 1][l1] & 0x78) == 0 && (ehj[k1 - 1][l1 - 1] & 0x7c) == 0 && eif[k1 - 1][l1 - 1] == 0)
            {
                arg6[i1] = k1 - 1;
                arg7[i1] = l1 - 1;
                i1 = (i1 + 1) % i2;
                eif[k1 - 1][l1 - 1] = 3;
            }
            if(k1 < 95 && l1 > 0 && (ehj[k1][l1 - 1] & 0x74) == 0 && (ehj[k1 + 1][l1] & 0x72) == 0 && (ehj[k1 + 1][l1 - 1] & 0x76) == 0 && eif[k1 + 1][l1 - 1] == 0)
            {
                arg6[i1] = k1 + 1;
                arg7[i1] = l1 - 1;
                i1 = (i1 + 1) % i2;
                eif[k1 + 1][l1 - 1] = 9;
            }
            if(k1 > 0 && l1 < 95 && (ehj[k1][l1 + 1] & 0x71) == 0 && (ehj[k1 - 1][l1] & 0x78) == 0 && (ehj[k1 - 1][l1 + 1] & 0x79) == 0 && eif[k1 - 1][l1 + 1] == 0)
            {
                arg6[i1] = k1 - 1;
                arg7[i1] = l1 + 1;
                i1 = (i1 + 1) % i2;
                eif[k1 - 1][l1 + 1] = 6;
            }
            if(k1 < 95 && l1 < 95 && (ehj[k1][l1 + 1] & 0x71) == 0 && (ehj[k1 + 1][l1] & 0x72) == 0 && (ehj[k1 + 1][l1 + 1] & 0x73) == 0 && eif[k1 + 1][l1 + 1] == 0)
            {
                arg6[i1] = k1 + 1;
                arg7[i1] = l1 + 1;
                i1 = (i1 + 1) % i2;
                eif[k1 + 1][l1 + 1] = 12;
            }
        }
        if(!flag)
            return -1;
        j1 = 0;
        arg6[j1] = k1;
        arg7[j1++] = l1;
        int k2;
        for(int j2 = k2 = eif[k1][l1]; k1 != arg0 || l1 != arg1; j2 = eif[k1][l1])
        {
            if(j2 != k2)
            {
                k2 = j2;
                arg6[j1] = k1;
                arg7[j1++] = l1;
            }
            if((j2 & 2) != 0)
                k1++;
            else
            if((j2 & 8) != 0)
                k1--;
            if((j2 & 1) != 0)
                l1++;
            else
            if((j2 & 4) != 0)
                l1--;
        }

        return j1;
    }

    public int cje(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehh[byte0][arg0 * 48 + arg1];
    }

    public int cjf(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return ehd[byte0][arg0 * 48 + arg1];
    }

    public int cjg(int arg0, int arg1)
    {
        if(arg0 < 0 || arg0 >= 96 || arg1 < 0 || arg1 >= 96)
            return 0;
        byte byte0 = 0;
        if(arg0 >= 48 && arg1 < 48)
        {
            byte0 = 1;
            arg0 -= 48;
        } else
        if(arg0 < 48 && arg1 >= 48)
        {
            byte0 = 2;
            arg1 -= 48;
        } else
        if(arg0 >= 48 && arg1 >= 48)
        {
            byte0 = 3;
            arg0 -= 48;
            arg1 -= 48;
        }
        return eid[byte0][arg0 * 48 + arg1] & 0xff;
    }

    public x(n arg0, j arg1)
    {
        egl = new int[18432];
        egm = new int[256];
        ehb = new byte[4][2304];
        ehc = new int[96][96];
        ehd = new byte[4][2304];
        ehe = new i[4][64];
        ehf = new i[4][64];
        ehg = new byte[4][2304];
        ehh = new int[4][2304];
        ehi = new i[64];
        ehj = new int[96][96];
        ehk = new byte[4][2304];
        ehl = new byte[4][2304];
        ehm = false;
        ehn = 750;
        eic = new int[18432];
        eid = new byte[4][2304];
        eie = new byte[4][2304];
        eif = new int[96][96];
        eig = false;
        eih = true;
        egi = arg0;
        egh = arg1;
        for(int k = 0; k < 64; k++)
            egm[k] = n.cgj(255 - k * 4, 255 - (int)((double)k * 1.75D), 255 - k * 4);

        for(int l = 0; l < 64; l++)
            egm[l + 64] = n.cgj(l * 3, 144, 0);

        for(int i1 = 0; i1 < 64; i1++)
            egm[i1 + 128] = n.cgj(192 - (int)((double)i1 * 1.5D), 144 - (int)((double)i1 * 1.5D), 0);

        for(int j1 = 0; j1 < 64; j1++)
            egm[j1 + 192] = n.cgj(96 - (int)((double)j1 * 1.5D), 48 + (int)((double)j1 * 1.5D), 0);

    }

    final int egf = 96;
    final int egg = 96;
    j egh;
    n egi;
    byte egj[];
    byte egk[];
    int egl[];
    int egm[];
    final int egn = 0xbc614e;
    final int eha = 128;
    byte ehb[][];
    int ehc[][];
    byte ehd[][];
    i ehe[][];
    i ehf[][];
    byte ehg[][];
    int ehh[][];
    i ehi[];
    int ehj[][];
    byte ehk[][];
    byte ehl[][];
    boolean ehm;
    int ehn;
    byte eia[];
    byte eib[];
    int eic[];
    byte eid[][];
    byte eie[][];
    int eif[][];
    boolean eig;
    boolean eih;
    i eii;
}