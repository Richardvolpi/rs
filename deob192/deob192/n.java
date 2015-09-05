// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:49 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class n
{

    public n(j arg0, int arg1, int arg2, int arg3)
    {
        eah = 50;
        eai = new int[eah];
        eaj = new int[eah][256];
        eam = 5;
        ean = 1000;
        eba = 1000;
        ebb = 20;
        ebc = 10;
        ebf = false;
        ebg = 1.1000000000000001D;
        ebh = 1;
        ebi = false;
        ebm = 100;
        ebn = new i[ebm];
        eca = new int[ebm];
        ecb = 512;
        ecc = 256;
        ecd = 192;
        ece = 256;
        ecf = 256;
        ecg = 8;
        ech = 4;
        efe = new int[40];
        eff = new int[40];
        efg = new int[40];
        efh = new int[40];
        efi = new int[40];
        efj = new int[40];
        efk = false;
        een = arg0;
        ecc = arg0.ban / 2;
        ecd = arg0.bba / 2;
        efa = arg0.bbf;
        eda = 0;
        edb = arg1;
        edc = new i[edb];
        edd = new int[edb];
        ede = 0;
        edf = new l[arg2];
        for(int k = 0; k < arg2; k++)
            edf[k] = new l();

        edg = 0;
        eea = new i(arg3 * 2, arg3);
        edh = new int[arg3];
        edl = new int[arg3];
        edm = new int[arg3];
        edi = new int[arg3];
        edj = new int[arg3];
        edk = new int[arg3];
        edn = new int[arg3];
        if(eel == null)
            eel = new byte[17691];
        eci = 0;
        ecj = 0;
        eck = 0;
        ecl = 0;
        ecm = 0;
        ecn = 0;
        for(int i1 = 0; i1 < 256; i1++)
        {
            ebe[i1] = (int)(Math.sin((double)i1 * 0.02454369D) * 32768D);
            ebe[i1 + 256] = (int)(Math.cos((double)i1 * 0.02454369D) * 32768D);
        }

        for(int j1 = 0; j1 < 1024; j1++)
        {
            ebd[j1] = (int)(Math.sin((double)j1 * 0.00613592315D) * 32768D);
            ebd[j1 + 1024] = (int)(Math.cos((double)j1 * 0.00613592315D) * 32768D);
        }

    }

    public void cdj(i arg0)
    {
        if(arg0 == null)
            System.out.println("Warning tried to add null object!");
        if(eda < edb)
        {
            edd[eda] = 0;
            edc[eda++] = arg0;
        }
    }

    public void cdk(i arg0)
    {
        for(int k = 0; k < eda; k++)
            if(edc[k] == arg0)
            {
                eda--;
                for(int i1 = k; i1 < eda; i1++)
                {
                    edc[i1] = edc[i1 + 1];
                    edd[i1] = edd[i1 + 1];
                }

            }

    }

    public void cdl()
    {
        cdm();
        for(int k = 0; k < eda; k++)
            edc[k] = null;

        eda = 0;
    }

    public void cdm()
    {
        edg = 0;
        eea.aen();
    }

    public void cdn(int arg0)
    {
        edg -= arg0;
        eea.afa(arg0, arg0 * 2);
        if(edg < 0)
            edg = 0;
    }

    public int cea(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        edh[edg] = arg0;
        edi[edg] = arg1;
        edj[edg] = arg2;
        edk[edg] = arg3;
        edl[edg] = arg4;
        edm[edg] = arg5;
        edn[edg] = 0;
        int k = eea.afh(arg1, arg2, arg3);
        int i1 = eea.afh(arg1, arg2 - arg5, arg3);
        int ai[] = {
            k, i1
        };
        eea.afi(2, ai, 0, 0);
        eea.aha[edg] = arg6;
        eea.ahb[edg++] = 0;
        return edg - 1;
    }

    public void ceb(int arg0)
    {
        eea.ahb[arg0] = 1;
    }

    public void cec(int arg0, int arg1)
    {
        edn[arg0] = arg1;
    }

    public void ced(int arg0, int arg1)
    {
        ebj = arg0 - ece;
        ebk = arg1;
        ebl = 0;
        ebi = true;
    }

    public int cee()
    {
        return ebl;
    }

    public int[] cef()
    {
        return eca;
    }

    public i[] ceg()
    {
        return ebn;
    }

    public void ceh(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        ecc = arg2;
        ecd = arg3;
        ece = arg0;
        ecf = arg1;
        ecb = arg4;
        ecg = arg5;
        efb = new m[arg3 + arg1];
        for(int k = 0; k < arg3 + arg1; k++)
            efb[k] = new m();

    }

    private void cei(l arg0[], int arg1, int arg2)
    {
        if(arg1 < arg2)
        {
            int k = arg1 - 1;
            int i1 = arg2 + 1;
            int j1 = (arg1 + arg2) / 2;
            l l1 = arg0[j1];
            arg0[j1] = arg0[arg1];
            arg0[arg1] = l1;
            int k1 = l1.djc;
            while(k < i1) 
            {
                do
                    i1--;
                while(arg0[i1].djc < k1);
                do
                    k++;
                while(arg0[k].djc > k1);
                if(k < i1)
                {
                    l l2 = arg0[k];
                    arg0[k] = arg0[i1];
                    arg0[i1] = l2;
                }
            }
            cei(arg0, arg1, i1);
            cei(arg0, i1 + 1, arg2);
        }
    }

    public void cej(int arg0, l arg1[], int arg2)
    {
        for(int k = 0; k <= arg2; k++)
        {
            arg1[k].dji = false;
            arg1[k].djj = k;
            arg1[k].djk = -1;
        }

        int i1 = 0;
        do
        {
            while(arg1[i1].dji) 
                i1++;
            if(i1 == arg2)
                return;
            l l1 = arg1[i1];
            l1.dji = true;
            int j1 = i1;
            int k1 = i1 + arg0;
            if(k1 >= arg2)
                k1 = arg2 - 1;
            for(int i2 = k1; i2 >= j1 + 1; i2--)
            {
                l l2 = arg1[i2];
                if(l1.dii < l2.dik && l2.dii < l1.dik && l1.dij < l2.dil && l2.dij < l1.dil && l1.djj != l2.djk && !cfn(l1, l2) && cga(l2, l1))
                {
                    cek(arg1, j1, i2);
                    if(arg1[i2] != l2)
                        i2++;
                    j1 = egd;
                    l2.djk = l1.djj;
                }
            }

        } while(true);
    }

    public boolean cek(l arg0[], int arg1, int arg2)
    {
        do
        {
            l l1 = arg0[arg1];
            for(int k = arg1 + 1; k <= arg2; k++)
            {
                l l2 = arg0[k];
                if(!cfn(l2, l1))
                    break;
                arg0[arg1] = l2;
                arg0[k] = l1;
                arg1 = k;
                if(arg1 == arg2)
                {
                    egd = arg1;
                    ege = arg1 - 1;
                    return true;
                }
            }

            l l3 = arg0[arg2];
            for(int i1 = arg2 - 1; i1 >= arg1; i1--)
            {
                l l4 = arg0[i1];
                if(!cfn(l3, l4))
                    break;
                arg0[arg2] = l4;
                arg0[i1] = l3;
                arg2 = i1;
                if(arg1 == arg2)
                {
                    egd = arg2 + 1;
                    ege = arg2;
                    return true;
                }
            }

            if(arg1 + 1 >= arg2)
            {
                egd = arg1;
                ege = arg2;
                return false;
            }
            if(!cek(arg0, arg1 + 1, arg2))
            {
                egd = arg1;
                return false;
            }
            arg2 = ege;
        } while(true);
    }

    public void cel(int arg0, int arg1, int arg2)
    {
        int k = -ecl + 1024 & 0x3ff;
        int i1 = -ecm + 1024 & 0x3ff;
        int j1 = -ecn + 1024 & 0x3ff;
        if(j1 != 0)
        {
            int k1 = ebd[j1];
            int j2 = ebd[j1 + 1024];
            int i3 = arg1 * k1 + arg0 * j2 >> 15;
            arg1 = arg1 * j2 - arg0 * k1 >> 15;
            arg0 = i3;
        }
        if(k != 0)
        {
            int l1 = ebd[k];
            int k2 = ebd[k + 1024];
            int j3 = arg1 * k2 - arg2 * l1 >> 15;
            arg2 = arg1 * l1 + arg2 * k2 >> 15;
            arg1 = j3;
        }
        if(i1 != 0)
        {
            int i2 = ebd[i1];
            int l2 = ebd[i1 + 1024];
            int k3 = arg2 * i2 + arg0 * l2 >> 15;
            arg2 = arg2 * l2 - arg0 * i2 >> 15;
            arg0 = k3;
        }
        if(arg0 < efl)
            efl = arg0;
        if(arg0 > efm)
            efm = arg0;
        if(arg1 < efn)
            efn = arg1;
        if(arg1 > ega)
            ega = arg1;
        if(arg2 < egb)
            egb = arg2;
        if(arg2 > egc)
            egc = arg2;
    }

    public void cem()
    {
        efk = een.bcj;
        int k4 = ecc * ean >> ecg;
        int l4 = ecd * ean >> ecg;
        efl = 0;
        efm = 0;
        efn = 0;
        ega = 0;
        egb = 0;
        egc = 0;
        cel(-k4, -l4, ean);
        cel(-k4, l4, ean);
        cel(k4, -l4, ean);
        cel(k4, l4, ean);
        cel(-ecc, -ecd, 0);
        cel(-ecc, ecd, 0);
        cel(ecc, -ecd, 0);
        cel(ecc, ecd, 0);
        efl += eci;
        efm += eci;
        efn += ecj;
        ega += ecj;
        egb += eck;
        egc += eck;
        edc[eda] = eea;
        eea.agc = 2;
        for(int k1 = 0; k1 < eda; k1++)
            edc[k1].aha(eci, ecj, eck, ecl, ecm, ecn, ecg, eam);

        edc[eda].aha(eci, ecj, eck, ecl, ecm, ecn, ecg, eam);
        ede = 0;
        for(int i5 = 0; i5 < eda; i5++)
        {
            i k = edc[i5];
            if(k.agd)
            {
                for(int l1 = 0; l1 < k.afe; l1++)
                {
                    int j5 = k.aff[l1];
                    int ai1[] = k.afg[l1];
                    boolean flag = false;
                    for(int i6 = 0; i6 < j5; i6++)
                    {
                        int k2 = k.aen[ai1[i6]];
                        if(k2 <= eam || k2 >= ean)
                            continue;
                        flag = true;
                        break;
                    }

                    if(flag)
                    {
                        int j3 = 0;
                        for(int j7 = 0; j7 < j5; j7++)
                        {
                            int l2 = k.afa[ai1[j7]];
                            if(l2 > -ecc)
                                j3 |= 1;
                            if(l2 < ecc)
                                j3 |= 2;
                            if(j3 == 3)
                                break;
                        }

                        if(j3 == 3)
                        {
                            int k3 = 0;
                            for(int k8 = 0; k8 < j5; k8++)
                            {
                                int i3 = k.afb[ai1[k8]];
                                if(i3 > -ecd)
                                    k3 |= 1;
                                if(i3 < ecd)
                                    k3 |= 2;
                                if(k3 == 3)
                                    break;
                            }

                            if(k3 == 3)
                            {
                                l l9 = edf[ede];
                                l9.dja = k;
                                l9.djb = l1;
                                cfl(ede);
                                int l10;
                                if(l9.djg < 0)
                                    l10 = k.afh[l1];
                                else
                                    l10 = k.afi[l1];
                                if(l10 != 0xbc614e)
                                {
                                    int l3 = 0;
                                    for(int l11 = 0; l11 < j5; l11++)
                                        l3 += k.aen[ai1[l11]];

                                    int j4;
                                    l9.djc = j4 = l3 / j5 + k.agb;
                                    l9.djh = l10;
                                    ede++;
                                }
                            }
                        }
                    }
                }

            }
        }

        i i1 = eea;
        if(i1.agd)
        {
            for(int i2 = 0; i2 < i1.afe; i2++)
            {
                int ai[] = i1.afg[i2];
                int l5 = ai[0];
                int j6 = i1.afa[l5];
                int k7 = i1.afb[l5];
                int l8 = i1.aen[l5];
                if(l8 > eam && l8 < eba)
                {
                    int i10 = (edl[i2] << ecg) / l8;
                    int i11 = (edm[i2] << ecg) / l8;
                    if(j6 - i10 / 2 <= ecc && j6 + i10 / 2 >= -ecc && k7 - i11 <= ecd && k7 >= -ecd)
                    {
                        l l12 = edf[ede];
                        l12.dja = i1;
                        l12.djb = i2;
                        cfm(ede);
                        l12.djc = (l8 + i1.aen[ai[1]]) / 2;
                        ede++;
                    }
                }
            }

        }
        if(ede == 0)
            return;
        eal = ede;
        cei(edf, 0, ede - 1);
        cej(100, edf, ede);
        for(int k5 = 0; k5 < ede; k5++)
        {
            l l6 = edf[k5];
            i j1 = l6.dja;
            int j2 = l6.djb;
            if(j1 == eea)
            {
                int ai2[] = j1.afg[j2];
                int l7 = ai2[0];
                int i9 = j1.afa[l7];
                int j10 = j1.afb[l7];
                int j11 = j1.aen[l7];
                int i12 = (edl[j2] << ecg) / j11;
                int k12 = (edm[j2] << ecg) / j11;
                int j13 = j10 - j1.afb[ai2[1]];
                int k13 = ((j1.afa[ai2[1]] - i9) * j13) / k12;
                k13 = j1.afa[ai2[1]] - i9;
                int i14 = i9 - i12 / 2;
                int k14 = (ecf + j10) - k12;
                een.bdb(i14 + ece, k14, i12, k12, edh[j2], k13, (256 << ecg) / j11);
                if(ebi && ebl < ebm)
                {
                    i14 += (edn[j2] << ecg) / j11;
                    if(ebk >= k14 && ebk <= k14 + k12 && ebj >= i14 && ebj <= i14 + i12 && !j1.ahf && j1.ahb[j2] == 0)
                    {
                        ebn[ebl] = j1;
                        eca[ebl] = j2;
                        ebl++;
                    }
                }
            } else
            {
                int k10 = 0;
                int j12 = 0;
                int i13 = j1.aff[j2];
                int ai3[] = j1.afg[j2];
                if(j1.afl[j2] != 0xbc614e)
                    if(l6.djg < 0)
                        j12 = j1.aki - j1.afl[j2];
                    else
                        j12 = j1.aki + j1.afl[j2];
                for(int l13 = 0; l13 < i13; l13++)
                {
                    int i4 = ai3[l13];
                    efh[l13] = j1.ael[i4];
                    efi[l13] = j1.aem[i4];
                    efj[l13] = j1.aen[i4];
                    if(j1.afl[j2] == 0xbc614e)
                        if(l6.djg < 0)
                            j12 = (j1.aki - j1.afc[i4]) + j1.afd[i4];
                        else
                            j12 = j1.aki + j1.afc[i4] + j1.afd[i4];
                    if(j1.aen[i4] >= eam)
                    {
                        efe[k10] = j1.afa[i4];
                        eff[k10] = j1.afb[i4];
                        efg[k10] = j12;
                        if(j1.aen[i4] > ebc)
                            efg[k10] += (j1.aen[i4] - ebc) / ebb;
                        k10++;
                    } else
                    {
                        int k11;
                        if(l13 == 0)
                            k11 = ai3[i13 - 1];
                        else
                            k11 = ai3[l13 - 1];
                        if(j1.aen[k11] >= eam)
                        {
                            int j9 = j1.aen[i4] - j1.aen[k11];
                            int k6 = j1.ael[i4] - ((j1.ael[i4] - j1.ael[k11]) * (j1.aen[i4] - eam)) / j9;
                            int i8 = j1.aem[i4] - ((j1.aem[i4] - j1.aem[k11]) * (j1.aen[i4] - eam)) / j9;
                            efe[k10] = (k6 << ecg) / eam;
                            eff[k10] = (i8 << ecg) / eam;
                            efg[k10] = j12;
                            k10++;
                        }
                        if(l13 == i13 - 1)
                            k11 = ai3[0];
                        else
                            k11 = ai3[l13 + 1];
                        if(j1.aen[k11] >= eam)
                        {
                            int k9 = j1.aen[i4] - j1.aen[k11];
                            int i7 = j1.ael[i4] - ((j1.ael[i4] - j1.ael[k11]) * (j1.aen[i4] - eam)) / k9;
                            int j8 = j1.aem[i4] - ((j1.aem[i4] - j1.aem[k11]) * (j1.aen[i4] - eam)) / k9;
                            efe[k10] = (i7 << ecg) / eam;
                            eff[k10] = (j8 << ecg) / eam;
                            efg[k10] = j12;
                            k10++;
                        }
                    }
                }

                for(int j14 = 0; j14 < i13; j14++)
                {
                    if(efg[j14] < 0)
                        efg[j14] = 0;
                    else
                    if(efg[j14] > 255)
                        efg[j14] = 255;
                    if(l6.djh >= 0)
                        if(eee[l6.djh] == 1)
                            efg[j14] <<= 9;
                        else
                            efg[j14] <<= 6;
                }

                cen(0, 0, 0, 0, k10, efe, eff, efg, j1, j2);
                if(efd > efc)
                    cfa(0, 0, i13, efh, efi, efj, l6.djh, j1);
            }
        }

        ebi = false;
    }

    private void cen(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5[], int arg6[], 
            int arg7[], i arg8, int arg9)
    {
        if(arg4 == 3)
        {
            int k = arg6[0] + ecf;
            int l1 = arg6[1] + ecf;
            int l2 = arg6[2] + ecf;
            int l3 = arg5[0];
            int i5 = arg5[1];
            int k6 = arg5[2];
            int i8 = arg7[0];
            int k9 = arg7[1];
            int k10 = arg7[2];
            int k11 = (ecf + ecd) - 1;
            int i12 = 0;
            int k12 = 0;
            int i13 = 0;
            int k13 = 0;
            int i14 = 0xbc614e;
            int k14 = 0xff439eb2;
            if(l2 != k)
            {
                k12 = (k6 - l3 << 8) / (l2 - k);
                k13 = (k10 - i8 << 8) / (l2 - k);
                if(k < l2)
                {
                    i12 = l3 << 8;
                    i13 = i8 << 8;
                    i14 = k;
                    k14 = l2;
                } else
                {
                    i12 = k6 << 8;
                    i13 = k10 << 8;
                    i14 = l2;
                    k14 = k;
                }
                if(i14 < 0)
                {
                    i12 -= k12 * i14;
                    i13 -= k13 * i14;
                    i14 = 0;
                }
                if(k14 > k11)
                    k14 = k11;
            }
            int i15 = 0;
            int k15 = 0;
            int i16 = 0;
            int k16 = 0;
            int i17 = 0xbc614e;
            int k17 = 0xff439eb2;
            if(l1 != k)
            {
                k15 = (i5 - l3 << 8) / (l1 - k);
                k16 = (k9 - i8 << 8) / (l1 - k);
                if(k < l1)
                {
                    i15 = l3 << 8;
                    i16 = i8 << 8;
                    i17 = k;
                    k17 = l1;
                } else
                {
                    i15 = i5 << 8;
                    i16 = k9 << 8;
                    i17 = l1;
                    k17 = k;
                }
                if(i17 < 0)
                {
                    i15 -= k15 * i17;
                    i16 -= k16 * i17;
                    i17 = 0;
                }
                if(k17 > k11)
                    k17 = k11;
            }
            int i18 = 0;
            int k18 = 0;
            int i19 = 0;
            int k19 = 0;
            int i20 = 0xbc614e;
            int k20 = 0xff439eb2;
            if(l2 != l1)
            {
                k18 = (k6 - i5 << 8) / (l2 - l1);
                k19 = (k10 - k9 << 8) / (l2 - l1);
                if(l1 < l2)
                {
                    i18 = i5 << 8;
                    i19 = k9 << 8;
                    i20 = l1;
                    k20 = l2;
                } else
                {
                    i18 = k6 << 8;
                    i19 = k10 << 8;
                    i20 = l2;
                    k20 = l1;
                }
                if(i20 < 0)
                {
                    i18 -= k18 * i20;
                    i19 -= k19 * i20;
                    i20 = 0;
                }
                if(k20 > k11)
                    k20 = k11;
            }
            efc = i14;
            if(i17 < efc)
                efc = i17;
            if(i20 < efc)
                efc = i20;
            efd = k14;
            if(k17 > efd)
                efd = k17;
            if(k20 > efd)
                efd = k20;
            int i21 = 0;
            for(arg2 = efc; arg2 < efd; arg2++)
            {
                if(arg2 >= i14 && arg2 < k14)
                {
                    arg0 = arg1 = i12;
                    arg3 = i21 = i13;
                    i12 += k12;
                    i13 += k13;
                } else
                {
                    arg0 = 0xa0000;
                    arg1 = 0xfff60000;
                }
                if(arg2 >= i17 && arg2 < k17)
                {
                    if(i15 < arg0)
                    {
                        arg0 = i15;
                        arg3 = i16;
                    }
                    if(i15 > arg1)
                    {
                        arg1 = i15;
                        i21 = i16;
                    }
                    i15 += k15;
                    i16 += k16;
                }
                if(arg2 >= i20 && arg2 < k20)
                {
                    if(i18 < arg0)
                    {
                        arg0 = i18;
                        arg3 = i19;
                    }
                    if(i18 > arg1)
                    {
                        arg1 = i18;
                        i21 = i19;
                    }
                    i18 += k18;
                    i19 += k19;
                }
                m m7 = efb[arg2];
                m7.dlk = arg0;
                m7.dll = arg1;
                m7.dlm = arg3;
                m7.dln = i21;
            }

            if(efc < ecf - ecd)
                efc = ecf - ecd;
        } else
        if(arg4 == 4)
        {
            int i1 = arg6[0] + ecf;
            int i2 = arg6[1] + ecf;
            int i3 = arg6[2] + ecf;
            int i4 = arg6[3] + ecf;
            int j5 = arg5[0];
            int l6 = arg5[1];
            int j8 = arg5[2];
            int l9 = arg5[3];
            int l10 = arg7[0];
            int l11 = arg7[1];
            int j12 = arg7[2];
            int l12 = arg7[3];
            int j13 = (ecf + ecd) - 1;
            int l13 = 0;
            int j14 = 0;
            int l14 = 0;
            int j15 = 0;
            int l15 = 0xbc614e;
            int j16 = 0xff439eb2;
            if(i4 != i1)
            {
                j14 = (l9 - j5 << 8) / (i4 - i1);
                j15 = (l12 - l10 << 8) / (i4 - i1);
                if(i1 < i4)
                {
                    l13 = j5 << 8;
                    l14 = l10 << 8;
                    l15 = i1;
                    j16 = i4;
                } else
                {
                    l13 = l9 << 8;
                    l14 = l12 << 8;
                    l15 = i4;
                    j16 = i1;
                }
                if(l15 < 0)
                {
                    l13 -= j14 * l15;
                    l14 -= j15 * l15;
                    l15 = 0;
                }
                if(j16 > j13)
                    j16 = j13;
            }
            int l16 = 0;
            int j17 = 0;
            int l17 = 0;
            int j18 = 0;
            int l18 = 0xbc614e;
            int j19 = 0xff439eb2;
            if(i2 != i1)
            {
                j17 = (l6 - j5 << 8) / (i2 - i1);
                j18 = (l11 - l10 << 8) / (i2 - i1);
                if(i1 < i2)
                {
                    l16 = j5 << 8;
                    l17 = l10 << 8;
                    l18 = i1;
                    j19 = i2;
                } else
                {
                    l16 = l6 << 8;
                    l17 = l11 << 8;
                    l18 = i2;
                    j19 = i1;
                }
                if(l18 < 0)
                {
                    l16 -= j17 * l18;
                    l17 -= j18 * l18;
                    l18 = 0;
                }
                if(j19 > j13)
                    j19 = j13;
            }
            int l19 = 0;
            int j20 = 0;
            int l20 = 0;
            int j21 = 0;
            int k21 = 0xbc614e;
            int l21 = 0xff439eb2;
            if(i3 != i2)
            {
                j20 = (j8 - l6 << 8) / (i3 - i2);
                j21 = (j12 - l11 << 8) / (i3 - i2);
                if(i2 < i3)
                {
                    l19 = l6 << 8;
                    l20 = l11 << 8;
                    k21 = i2;
                    l21 = i3;
                } else
                {
                    l19 = j8 << 8;
                    l20 = j12 << 8;
                    k21 = i3;
                    l21 = i2;
                }
                if(k21 < 0)
                {
                    l19 -= j20 * k21;
                    l20 -= j21 * k21;
                    k21 = 0;
                }
                if(l21 > j13)
                    l21 = j13;
            }
            int i22 = 0;
            int j22 = 0;
            int k22 = 0;
            int l22 = 0;
            int i23 = 0xbc614e;
            int j23 = 0xff439eb2;
            if(i4 != i3)
            {
                j22 = (l9 - j8 << 8) / (i4 - i3);
                l22 = (l12 - j12 << 8) / (i4 - i3);
                if(i3 < i4)
                {
                    i22 = j8 << 8;
                    k22 = j12 << 8;
                    i23 = i3;
                    j23 = i4;
                } else
                {
                    i22 = l9 << 8;
                    k22 = l12 << 8;
                    i23 = i4;
                    j23 = i3;
                }
                if(i23 < 0)
                {
                    i22 -= j22 * i23;
                    k22 -= l22 * i23;
                    i23 = 0;
                }
                if(j23 > j13)
                    j23 = j13;
            }
            efc = l15;
            if(l18 < efc)
                efc = l18;
            if(k21 < efc)
                efc = k21;
            if(i23 < efc)
                efc = i23;
            efd = j16;
            if(j19 > efd)
                efd = j19;
            if(l21 > efd)
                efd = l21;
            if(j23 > efd)
                efd = j23;
            int k23 = 0;
            for(arg2 = efc; arg2 < efd; arg2++)
            {
                if(arg2 >= l15 && arg2 < j16)
                {
                    arg0 = arg1 = l13;
                    arg3 = k23 = l14;
                    l13 += j14;
                    l14 += j15;
                } else
                {
                    arg0 = 0xa0000;
                    arg1 = 0xfff60000;
                }
                if(arg2 >= l18 && arg2 < j19)
                {
                    if(l16 < arg0)
                    {
                        arg0 = l16;
                        arg3 = l17;
                    }
                    if(l16 > arg1)
                    {
                        arg1 = l16;
                        k23 = l17;
                    }
                    l16 += j17;
                    l17 += j18;
                }
                if(arg2 >= k21 && arg2 < l21)
                {
                    if(l19 < arg0)
                    {
                        arg0 = l19;
                        arg3 = l20;
                    }
                    if(l19 > arg1)
                    {
                        arg1 = l19;
                        k23 = l20;
                    }
                    l19 += j20;
                    l20 += j21;
                }
                if(arg2 >= i23 && arg2 < j23)
                {
                    if(i22 < arg0)
                    {
                        arg0 = i22;
                        arg3 = k22;
                    }
                    if(i22 > arg1)
                    {
                        arg1 = i22;
                        k23 = k22;
                    }
                    i22 += j22;
                    k22 += l22;
                }
                m m8 = efb[arg2];
                m8.dlk = arg0;
                m8.dll = arg1;
                m8.dlm = arg3;
                m8.dln = k23;
            }

            if(efc < ecf - ecd)
                efc = ecf - ecd;
        } else
        {
            efd = efc = arg6[0] += ecf;
            for(arg2 = 1; arg2 < arg4; arg2++)
            {
                int j1;
                if((j1 = arg6[arg2] += ecf) < efc)
                    efc = j1;
                else
                if(j1 > efd)
                    efd = j1;
            }

            if(efc < ecf - ecd)
                efc = ecf - ecd;
            if(efd >= ecf + ecd)
                efd = (ecf + ecd) - 1;
            if(efc >= efd)
                return;
            for(arg2 = efc; arg2 < efd; arg2++)
            {
                m m1 = efb[arg2];
                m1.dlk = 0xa0000;
                m1.dll = 0xfff60000;
            }

            int k1 = arg4 - 1;
            int j2 = arg6[0];
            int j3 = arg6[k1];
            if(j2 < j3)
            {
                int j4 = arg5[0] << 8;
                int k5 = (arg5[k1] - arg5[0] << 8) / (j3 - j2);
                int i7 = arg7[0] << 8;
                int k8 = (arg7[k1] - arg7[0] << 8) / (j3 - j2);
                if(j2 < 0)
                {
                    j4 -= k5 * j2;
                    i7 -= k8 * j2;
                    j2 = 0;
                }
                if(j3 > efd)
                    j3 = efd;
                for(arg2 = j2; arg2 <= j3; arg2++)
                {
                    m m3 = efb[arg2];
                    m3.dlk = m3.dll = j4;
                    m3.dlm = m3.dln = i7;
                    j4 += k5;
                    i7 += k8;
                }

            } else
            if(j2 > j3)
            {
                int k4 = arg5[k1] << 8;
                int l5 = (arg5[0] - arg5[k1] << 8) / (j2 - j3);
                int j7 = arg7[k1] << 8;
                int l8 = (arg7[0] - arg7[k1] << 8) / (j2 - j3);
                if(j3 < 0)
                {
                    k4 -= l5 * j3;
                    j7 -= l8 * j3;
                    j3 = 0;
                }
                if(j2 > efd)
                    j2 = efd;
                for(arg2 = j3; arg2 <= j2; arg2++)
                {
                    m m4 = efb[arg2];
                    m4.dlk = m4.dll = k4;
                    m4.dlm = m4.dln = j7;
                    k4 += l5;
                    j7 += l8;
                }

            }
            for(arg2 = 0; arg2 < k1; arg2++)
            {
                int l4 = arg2 + 1;
                int k2 = arg6[arg2];
                int k3 = arg6[l4];
                if(k2 < k3)
                {
                    int i6 = arg5[arg2] << 8;
                    int k7 = (arg5[l4] - arg5[arg2] << 8) / (k3 - k2);
                    int i9 = arg7[arg2] << 8;
                    int i10 = (arg7[l4] - arg7[arg2] << 8) / (k3 - k2);
                    if(k2 < 0)
                    {
                        i6 -= k7 * k2;
                        i9 -= i10 * k2;
                        k2 = 0;
                    }
                    if(k3 > efd)
                        k3 = efd;
                    for(int i11 = k2; i11 <= k3; i11++)
                    {
                        m m5 = efb[i11];
                        if(i6 < m5.dlk)
                        {
                            m5.dlk = i6;
                            m5.dlm = i9;
                        }
                        if(i6 > m5.dll)
                        {
                            m5.dll = i6;
                            m5.dln = i9;
                        }
                        i6 += k7;
                        i9 += i10;
                    }

                } else
                if(k2 > k3)
                {
                    int j6 = arg5[l4] << 8;
                    int l7 = (arg5[arg2] - arg5[l4] << 8) / (k2 - k3);
                    int j9 = arg7[l4] << 8;
                    int j10 = (arg7[arg2] - arg7[l4] << 8) / (k2 - k3);
                    if(k3 < 0)
                    {
                        j6 -= l7 * k3;
                        j9 -= j10 * k3;
                        k3 = 0;
                    }
                    if(k2 > efd)
                        k2 = efd;
                    for(int j11 = k3; j11 <= k2; j11++)
                    {
                        m m6 = efb[j11];
                        if(j6 < m6.dlk)
                        {
                            m6.dlk = j6;
                            m6.dlm = j9;
                        }
                        if(j6 > m6.dll)
                        {
                            m6.dll = j6;
                            m6.dln = j9;
                        }
                        j6 += l7;
                        j9 += j10;
                    }

                }
            }

            if(efc < ecf - ecd)
                efc = ecf - ecd;
        }
        if(ebi && ebl < ebm && ebk >= efc && ebk < efd)
        {
            m m2 = efb[ebk];
            if(ebj >= m2.dlk >> 8 && ebj <= m2.dll >> 8 && m2.dlk <= m2.dll && !arg8.ahf && arg8.ahb[arg9] == 0)
            {
                ebn[ebl] = arg8;
                eca[ebl] = arg9;
                ebl++;
            }
        }
    }

    private void cfa(int arg0, int arg1, int arg2, int arg3[], int arg4[], int arg5[], int arg6, 
            i arg7)
    {
        if(arg6 == -2)
            return;
        if(arg6 >= 0)
        {
            if(arg6 >= eeb)
                arg6 = 0;
            cgd(arg6);
            int k = arg3[0];
            int j1 = arg4[0];
            int i2 = arg5[0];
            int l2 = k - arg3[1];
            int j3 = j1 - arg4[1];
            int l3 = i2 - arg5[1];
            arg2--;
            int l5 = arg3[arg2] - k;
            int i7 = arg4[arg2] - j1;
            int j8 = arg5[arg2] - i2;
            if(eee[arg6] == 1)
            {
                int k9 = l5 * j1 - i7 * k << 12;
                int j10 = i7 * i2 - j8 * j1 << (5 - ecg) + 7 + 4;
                int l10 = j8 * k - l5 * i2 << (5 - ecg) + 7;
                int j11 = l2 * j1 - j3 * k << 12;
                int l11 = j3 * i2 - l3 * j1 << (5 - ecg) + 7 + 4;
                int j12 = l3 * k - l2 * i2 << (5 - ecg) + 7;
                int l12 = j3 * l5 - l2 * i7 << 5;
                int j13 = l3 * i7 - j3 * j8 << (5 - ecg) + 4;
                int l13 = l2 * j8 - l3 * l5 >> ecg - 5;
                int j14 = j10 >> 4;
                int l14 = l11 >> 4;
                int j15 = j13 >> 4;
                int l15 = efc - ecf;
                int j16 = ecb;
                int l16 = ece + efc * j16;
                byte byte1 = 1;
                k9 += l10 * l15;
                j11 += j12 * l15;
                l12 += l13 * l15;
                if(efk)
                {
                    if((efc & 1) == 1)
                    {
                        efc++;
                        k9 += l10;
                        j11 += j12;
                        l12 += l13;
                        l16 += j16;
                    }
                    l10 <<= 1;
                    j12 <<= 1;
                    l13 <<= 1;
                    j16 <<= 1;
                    byte1 = 2;
                }
                if(arg7.agl)
                {
                    for(arg0 = efc; arg0 < efd; arg0 += byte1)
                    {
                        m m4 = efb[arg0];
                        arg1 = m4.dlk >> 8;
                        int j17 = m4.dll >> 8;
                        int j20 = j17 - arg1;
                        if(j20 <= 0)
                        {
                            k9 += l10;
                            j11 += j12;
                            l12 += l13;
                            l16 += j16;
                        } else
                        {
                            int l21 = m4.dlm;
                            int j23 = (m4.dln - l21) / j20;
                            if(arg1 < -ecc)
                            {
                                l21 += (-ecc - arg1) * j23;
                                arg1 = -ecc;
                                j20 = j17 - arg1;
                            }
                            if(j17 > ecc)
                            {
                                int k17 = ecc;
                                j20 = k17 - arg1;
                            }
                            cfc(efa, eeg[arg6], 0, 0, k9 + j14 * arg1, j11 + l14 * arg1, l12 + j15 * arg1, j10, l11, j13, j20, l16 + arg1, l21, j23 << 2);
                            k9 += l10;
                            j11 += j12;
                            l12 += l13;
                            l16 += j16;
                        }
                    }

                    return;
                }
                if(!eeh[arg6])
                {
                    for(arg0 = efc; arg0 < efd; arg0 += byte1)
                    {
                        m m5 = efb[arg0];
                        arg1 = m5.dlk >> 8;
                        int l17 = m5.dll >> 8;
                        int k20 = l17 - arg1;
                        if(k20 <= 0)
                        {
                            k9 += l10;
                            j11 += j12;
                            l12 += l13;
                            l16 += j16;
                        } else
                        {
                            int i22 = m5.dlm;
                            int k23 = (m5.dln - i22) / k20;
                            if(arg1 < -ecc)
                            {
                                i22 += (-ecc - arg1) * k23;
                                arg1 = -ecc;
                                k20 = l17 - arg1;
                            }
                            if(l17 > ecc)
                            {
                                int i18 = ecc;
                                k20 = i18 - arg1;
                            }
                            cfb(efa, eeg[arg6], 0, 0, k9 + j14 * arg1, j11 + l14 * arg1, l12 + j15 * arg1, j10, l11, j13, k20, l16 + arg1, i22, k23 << 2);
                            k9 += l10;
                            j11 += j12;
                            l12 += l13;
                            l16 += j16;
                        }
                    }

                    return;
                }
                for(arg0 = efc; arg0 < efd; arg0 += byte1)
                {
                    m m6 = efb[arg0];
                    arg1 = m6.dlk >> 8;
                    int j18 = m6.dll >> 8;
                    int l20 = j18 - arg1;
                    if(l20 <= 0)
                    {
                        k9 += l10;
                        j11 += j12;
                        l12 += l13;
                        l16 += j16;
                    } else
                    {
                        int j22 = m6.dlm;
                        int l23 = (m6.dln - j22) / l20;
                        if(arg1 < -ecc)
                        {
                            j22 += (-ecc - arg1) * l23;
                            arg1 = -ecc;
                            l20 = j18 - arg1;
                        }
                        if(j18 > ecc)
                        {
                            int k18 = ecc;
                            l20 = k18 - arg1;
                        }
                        cfd(efa, 0, 0, 0, eeg[arg6], k9 + j14 * arg1, j11 + l14 * arg1, l12 + j15 * arg1, j10, l11, j13, l20, l16 + arg1, j22, l23);
                        k9 += l10;
                        j11 += j12;
                        l12 += l13;
                        l16 += j16;
                    }
                }

                return;
            }
            int l9 = l5 * j1 - i7 * k << 11;
            int k10 = i7 * i2 - j8 * j1 << (5 - ecg) + 6 + 4;
            int i11 = j8 * k - l5 * i2 << (5 - ecg) + 6;
            int k11 = l2 * j1 - j3 * k << 11;
            int i12 = j3 * i2 - l3 * j1 << (5 - ecg) + 6 + 4;
            int k12 = l3 * k - l2 * i2 << (5 - ecg) + 6;
            int i13 = j3 * l5 - l2 * i7 << 5;
            int k13 = l3 * i7 - j3 * j8 << (5 - ecg) + 4;
            int i14 = l2 * j8 - l3 * l5 >> ecg - 5;
            int k14 = k10 >> 4;
            int i15 = i12 >> 4;
            int k15 = k13 >> 4;
            int i16 = efc - ecf;
            int k16 = ecb;
            int i17 = ece + efc * k16;
            byte byte2 = 1;
            l9 += i11 * i16;
            k11 += k12 * i16;
            i13 += i14 * i16;
            if(efk)
            {
                if((efc & 1) == 1)
                {
                    efc++;
                    l9 += i11;
                    k11 += k12;
                    i13 += i14;
                    i17 += k16;
                }
                i11 <<= 1;
                k12 <<= 1;
                i14 <<= 1;
                k16 <<= 1;
                byte2 = 2;
            }
            if(arg7.agl)
            {
                for(arg0 = efc; arg0 < efd; arg0 += byte2)
                {
                    m m7 = efb[arg0];
                    arg1 = m7.dlk >> 8;
                    int l18 = m7.dll >> 8;
                    int i21 = l18 - arg1;
                    if(i21 <= 0)
                    {
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    } else
                    {
                        int k22 = m7.dlm;
                        int i24 = (m7.dln - k22) / i21;
                        if(arg1 < -ecc)
                        {
                            k22 += (-ecc - arg1) * i24;
                            arg1 = -ecc;
                            i21 = l18 - arg1;
                        }
                        if(l18 > ecc)
                        {
                            int i19 = ecc;
                            i21 = i19 - arg1;
                        }
                        cff(efa, eeg[arg6], 0, 0, l9 + k14 * arg1, k11 + i15 * arg1, i13 + k15 * arg1, k10, i12, k13, i21, i17 + arg1, k22, i24);
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    }
                }

                return;
            }
            if(!eeh[arg6])
            {
                for(arg0 = efc; arg0 < efd; arg0 += byte2)
                {
                    m m8 = efb[arg0];
                    arg1 = m8.dlk >> 8;
                    int j19 = m8.dll >> 8;
                    int j21 = j19 - arg1;
                    if(j21 <= 0)
                    {
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    } else
                    {
                        int l22 = m8.dlm;
                        int j24 = (m8.dln - l22) / j21;
                        if(arg1 < -ecc)
                        {
                            l22 += (-ecc - arg1) * j24;
                            arg1 = -ecc;
                            j21 = j19 - arg1;
                        }
                        if(j19 > ecc)
                        {
                            int k19 = ecc;
                            j21 = k19 - arg1;
                        }
                        cfe(efa, eeg[arg6], 0, 0, l9 + k14 * arg1, k11 + i15 * arg1, i13 + k15 * arg1, k10, i12, k13, j21, i17 + arg1, l22, j24);
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    }
                }

                return;
            }
            for(arg0 = efc; arg0 < efd; arg0 += byte2)
            {
                m m9 = efb[arg0];
                arg1 = m9.dlk >> 8;
                int l19 = m9.dll >> 8;
                int k21 = l19 - arg1;
                if(k21 <= 0)
                {
                    l9 += i11;
                    k11 += k12;
                    i13 += i14;
                    i17 += k16;
                } else
                {
                    int i23 = m9.dlm;
                    int k24 = (m9.dln - i23) / k21;
                    if(arg1 < -ecc)
                    {
                        i23 += (-ecc - arg1) * k24;
                        arg1 = -ecc;
                        k21 = l19 - arg1;
                    }
                    if(l19 > ecc)
                    {
                        int i20 = ecc;
                        k21 = i20 - arg1;
                    }
                    cfg(efa, 0, 0, 0, eeg[arg6], l9 + k14 * arg1, k11 + i15 * arg1, i13 + k15 * arg1, k10, i12, k13, k21, i17 + arg1, i23, k24);
                    l9 += i11;
                    k11 += k12;
                    i13 += i14;
                    i17 += k16;
                }
            }

            return;
        }
        for(int i1 = 0; i1 < eah; i1++)
        {
            if(eai[i1] == arg6)
            {
                eak = eaj[i1];
                break;
            }
            if(i1 == eah - 1)
            {
                int k1 = (int)(Math.random() * (double)eah);
                eai[k1] = arg6;
                arg6 = -1 - arg6;
                int j2 = (arg6 >> 10 & 0x1f) * 8;
                int i3 = (arg6 >> 5 & 0x1f) * 8;
                int k3 = (arg6 & 0x1f) * 8;
                for(int i4 = 0; i4 < 256; i4++)
                {
                    int i6 = i4 * i4;
                    int j7 = (j2 * i6) / 0x10000;
                    int k8 = (i3 * i6) / 0x10000;
                    int i10 = (k3 * i6) / 0x10000;
                    eaj[k1][255 - i4] = (j7 << 16) + (k8 << 8) + i10;
                }

                eak = eaj[k1];
            }
        }

        int l1 = ecb;
        int k2 = ece + efc * l1;
        byte byte0 = 1;
        if(efk)
        {
            if((efc & 1) == 1)
            {
                efc++;
                k2 += l1;
            }
            l1 <<= 1;
            byte0 = 2;
        }
        if(arg7.agm)
        {
            for(arg0 = efc; arg0 < efd; arg0 += byte0)
            {
                m m1 = efb[arg0];
                arg1 = m1.dlk >> 8;
                int j4 = m1.dll >> 8;
                int j6 = j4 - arg1;
                if(j6 <= 0)
                {
                    k2 += l1;
                } else
                {
                    int k7 = m1.dlm;
                    int l8 = (m1.dln - k7) / j6;
                    if(arg1 < -ecc)
                    {
                        k7 += (-ecc - arg1) * l8;
                        arg1 = -ecc;
                        j6 = j4 - arg1;
                    }
                    if(j4 > ecc)
                    {
                        int k4 = ecc;
                        j6 = k4 - arg1;
                    }
                    cfi(efa, -j6, k2 + arg1, 0, eak, k7, l8);
                    k2 += l1;
                }
            }

            return;
        }
        if(ebf)
        {
            for(arg0 = efc; arg0 < efd; arg0 += byte0)
            {
                m m2 = efb[arg0];
                arg1 = m2.dlk >> 8;
                int l4 = m2.dll >> 8;
                int k6 = l4 - arg1;
                if(k6 <= 0)
                {
                    k2 += l1;
                } else
                {
                    int l7 = m2.dlm;
                    int i9 = (m2.dln - l7) / k6;
                    if(arg1 < -ecc)
                    {
                        l7 += (-ecc - arg1) * i9;
                        arg1 = -ecc;
                        k6 = l4 - arg1;
                    }
                    if(l4 > ecc)
                    {
                        int i5 = ecc;
                        k6 = i5 - arg1;
                    }
                    cfh(efa, -k6, k2 + arg1, 0, eak, l7, i9);
                    k2 += l1;
                }
            }

            return;
        }
        for(arg0 = efc; arg0 < efd; arg0 += byte0)
        {
            m m3 = efb[arg0];
            arg1 = m3.dlk >> 8;
            int j5 = m3.dll >> 8;
            int l6 = j5 - arg1;
            if(l6 <= 0)
            {
                k2 += l1;
            } else
            {
                int i8 = m3.dlm;
                int j9 = (m3.dln - i8) / l6;
                if(arg1 < -ecc)
                {
                    i8 += (-ecc - arg1) * j9;
                    arg1 = -ecc;
                    l6 = j5 - arg1;
                }
                if(j5 > ecc)
                {
                    int k5 = ecc;
                    l6 = k5 - arg1;
                }
                cfj(efa, -l6, k2 + arg1, 0, eak, i8, j9);
                k2 += l1;
            }
        }

    }

    private static void cfb(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        if(arg10 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        int l1 = 0;
        if(arg6 != 0)
        {
            arg2 = arg4 / arg6 << 7;
            arg3 = arg5 / arg6 << 7;
        }
        if(arg2 < 0)
            arg2 = 0;
        else
        if(arg2 > 16256)
            arg2 = 16256;
        arg4 += arg7;
        arg5 += arg8;
        arg6 += arg9;
        if(arg6 != 0)
        {
            k = arg4 / arg6 << 7;
            i1 = arg5 / arg6 << 7;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 16256)
            k = 16256;
        int j1 = k - arg2 >> 4;
        int k1 = i1 - arg3 >> 4;
        for(int i2 = arg10 >> 4; i2 > 0; i2--)
        {
            arg2 += arg12 & 0x600000;
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 = k;
            arg3 = i1;
            arg4 += arg7;
            arg5 += arg8;
            arg6 += arg9;
            if(arg6 != 0)
            {
                k = arg4 / arg6 << 7;
                i1 = arg5 / arg6 << 7;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 16256)
                k = 16256;
            j1 = k - arg2 >> 4;
            k1 = i1 - arg3 >> 4;
        }

        for(int j2 = 0; j2 < (arg10 & 0xf); j2++)
        {
            if((j2 & 3) == 0)
            {
                arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
                l1 = arg12 >> 23;
                arg12 += arg13;
            }
            arg0[arg11++] = arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1;
            arg2 += j1;
            arg3 += k1;
        }

    }

    private static void cfc(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        if(arg10 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        int l1 = 0;
        if(arg6 != 0)
        {
            arg2 = arg4 / arg6 << 7;
            arg3 = arg5 / arg6 << 7;
        }
        if(arg2 < 0)
            arg2 = 0;
        else
        if(arg2 > 16256)
            arg2 = 16256;
        arg4 += arg7;
        arg5 += arg8;
        arg6 += arg9;
        if(arg6 != 0)
        {
            k = arg4 / arg6 << 7;
            i1 = arg5 / arg6 << 7;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 16256)
            k = 16256;
        int j1 = k - arg2 >> 4;
        int k1 = i1 - arg3 >> 4;
        for(int i2 = arg10 >> 4; i2 > 0; i2--)
        {
            arg2 += arg12 & 0x600000;
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
            l1 = arg12 >> 23;
            arg12 += arg13;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 = k;
            arg3 = i1;
            arg4 += arg7;
            arg5 += arg8;
            arg6 += arg9;
            if(arg6 != 0)
            {
                k = arg4 / arg6 << 7;
                i1 = arg5 / arg6 << 7;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 16256)
                k = 16256;
            j1 = k - arg2 >> 4;
            k1 = i1 - arg3 >> 4;
        }

        for(int j2 = 0; j2 < (arg10 & 0xf); j2++)
        {
            if((j2 & 3) == 0)
            {
                arg2 = (arg2 & 0x3fff) + (arg12 & 0x600000);
                l1 = arg12 >> 23;
                arg12 += arg13;
            }
            arg0[arg11++] = (arg1[(arg3 & 0x3f80) + (arg2 >> 7)] >>> l1) + (arg0[arg11] >> 1 & 0x7f7f7f);
            arg2 += j1;
            arg3 += k1;
        }

    }

    private static void cfd(int arg0[], int arg1, int arg2, int arg3, int arg4[], int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14)
    {
        if(arg11 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        arg14 <<= 2;
        if(arg7 != 0)
        {
            k = arg5 / arg7 << 7;
            i1 = arg6 / arg7 << 7;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 16256)
            k = 16256;
        for(int l1 = arg11; l1 > 0; l1 -= 16)
        {
            arg5 += arg8;
            arg6 += arg9;
            arg7 += arg10;
            arg2 = k;
            arg3 = i1;
            if(arg7 != 0)
            {
                k = arg5 / arg7 << 7;
                i1 = arg6 / arg7 << 7;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 16256)
                k = 16256;
            int j1 = k - arg2 >> 4;
            int k1 = i1 - arg3 >> 4;
            int i2 = arg13 >> 23;
            arg2 += arg13 & 0x600000;
            arg13 += arg14;
            if(l1 < 16)
            {
                for(int j2 = 0; j2 < l1; j2++)
                {
                    if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                        arg0[arg12] = arg1;
                    arg12++;
                    arg2 += j1;
                    arg3 += k1;
                    if((j2 & 3) == 3)
                    {
                        arg2 = (arg2 & 0x3fff) + (arg13 & 0x600000);
                        i2 = arg13 >> 23;
                        arg13 += arg14;
                    }
                }

            } else
            {
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0x3fff) + (arg13 & 0x600000);
                i2 = arg13 >> 23;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0x3fff) + (arg13 & 0x600000);
                i2 = arg13 >> 23;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0x3fff) + (arg13 & 0x600000);
                i2 = arg13 >> 23;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0x3f80) + (arg2 >> 7)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
            }
        }

    }

    private static void cfe(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        if(arg10 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        arg13 <<= 2;
        if(arg6 != 0)
        {
            k = arg4 / arg6 << 6;
            i1 = arg5 / arg6 << 6;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 4032)
            k = 4032;
        for(int l1 = arg10; l1 > 0; l1 -= 16)
        {
            arg4 += arg7;
            arg5 += arg8;
            arg6 += arg9;
            arg2 = k;
            arg3 = i1;
            if(arg6 != 0)
            {
                k = arg4 / arg6 << 6;
                i1 = arg5 / arg6 << 6;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 4032)
                k = 4032;
            int j1 = k - arg2 >> 4;
            int k1 = i1 - arg3 >> 4;
            int i2 = arg12 >> 20;
            arg2 += arg12 & 0xc0000;
            arg12 += arg13;
            if(l1 < 16)
            {
                for(int j2 = 0; j2 < l1; j2++)
                {
                    arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                    arg2 += j1;
                    arg3 += k1;
                    if((j2 & 3) == 3)
                    {
                        arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                        i2 = arg12 >> 20;
                        arg12 += arg13;
                    }
                }

            } else
            {
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2;
            }
        }

    }

    private static void cff(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        if(arg10 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        arg13 <<= 2;
        if(arg6 != 0)
        {
            k = arg4 / arg6 << 6;
            i1 = arg5 / arg6 << 6;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 4032)
            k = 4032;
        for(int l1 = arg10; l1 > 0; l1 -= 16)
        {
            arg4 += arg7;
            arg5 += arg8;
            arg6 += arg9;
            arg2 = k;
            arg3 = i1;
            if(arg6 != 0)
            {
                k = arg4 / arg6 << 6;
                i1 = arg5 / arg6 << 6;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 4032)
                k = 4032;
            int j1 = k - arg2 >> 4;
            int k1 = i1 - arg3 >> 4;
            int i2 = arg12 >> 20;
            arg2 += arg12 & 0xc0000;
            arg12 += arg13;
            if(l1 < 16)
            {
                for(int j2 = 0; j2 < l1; j2++)
                {
                    arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                    arg2 += j1;
                    arg3 += k1;
                    if((j2 & 3) == 3)
                    {
                        arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                        i2 = arg12 >> 20;
                        arg12 += arg13;
                    }
                }

            } else
            {
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg12 & 0xc0000);
                i2 = arg12 >> 20;
                arg12 += arg13;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
                arg2 += j1;
                arg3 += k1;
                arg0[arg11++] = (arg1[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) + (arg0[arg11] >> 1 & 0x7f7f7f);
            }
        }

    }

    private static void cfg(int arg0[], int arg1, int arg2, int arg3, int arg4[], int arg5, int arg6, int arg7, 
            int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14)
    {
        if(arg11 <= 0)
            return;
        int k = 0;
        int i1 = 0;
        arg14 <<= 2;
        if(arg7 != 0)
        {
            k = arg5 / arg7 << 6;
            i1 = arg6 / arg7 << 6;
        }
        if(k < 0)
            k = 0;
        else
        if(k > 4032)
            k = 4032;
        for(int l1 = arg11; l1 > 0; l1 -= 16)
        {
            arg5 += arg8;
            arg6 += arg9;
            arg7 += arg10;
            arg2 = k;
            arg3 = i1;
            if(arg7 != 0)
            {
                k = arg5 / arg7 << 6;
                i1 = arg6 / arg7 << 6;
            }
            if(k < 0)
                k = 0;
            else
            if(k > 4032)
                k = 4032;
            int j1 = k - arg2 >> 4;
            int k1 = i1 - arg3 >> 4;
            int i2 = arg13 >> 20;
            arg2 += arg13 & 0xc0000;
            arg13 += arg14;
            if(l1 < 16)
            {
                for(int j2 = 0; j2 < l1; j2++)
                {
                    if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                        arg0[arg12] = arg1;
                    arg12++;
                    arg2 += j1;
                    arg3 += k1;
                    if((j2 & 3) == 3)
                    {
                        arg2 = (arg2 & 0xfff) + (arg13 & 0xc0000);
                        i2 = arg13 >> 20;
                        arg13 += arg14;
                    }
                }

            } else
            {
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg13 & 0xc0000);
                i2 = arg13 >> 20;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg13 & 0xc0000);
                i2 = arg13 >> 20;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                arg2 = (arg2 & 0xfff) + (arg13 & 0xc0000);
                i2 = arg13 >> 20;
                arg13 += arg14;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
                arg2 += j1;
                arg3 += k1;
                if((arg1 = arg4[(arg3 & 0xfc0) + (arg2 >> 6)] >>> i2) != 0)
                    arg0[arg12] = arg1;
                arg12++;
            }
        }

    }

    private static void cfh(int arg0[], int arg1, int arg2, int arg3, int arg4[], int arg5, int arg6)
    {
        if(arg1 >= 0)
            return;
        arg6 <<= 1;
        arg3 = arg4[arg5 >> 8 & 0xff];
        arg5 += arg6;
        int k = arg1 / 8;
        for(int i1 = k; i1 < 0; i1++)
        {
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
        }

        k = -(arg1 % 8);
        for(int j1 = 0; j1 < k; j1++)
        {
            arg0[arg2++] = arg3;
            if((j1 & 1) == 1)
            {
                arg3 = arg4[arg5 >> 8 & 0xff];
                arg5 += arg6;
            }
        }

    }

    private static void cfi(int arg0[], int arg1, int arg2, int arg3, int arg4[], int arg5, int arg6)
    {
        if(arg1 >= 0)
            return;
        arg6 <<= 2;
        arg3 = arg4[arg5 >> 8 & 0xff];
        arg5 += arg6;
        int k = arg1 / 16;
        for(int i1 = k; i1 < 0; i1++)
        {
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
        }

        k = -(arg1 % 16);
        for(int j1 = 0; j1 < k; j1++)
        {
            arg0[arg2++] = arg3 + (arg0[arg2] >> 1 & 0x7f7f7f);
            if((j1 & 3) == 3)
            {
                arg3 = arg4[arg5 >> 8 & 0xff];
                arg5 += arg6;
                arg5 += arg6;
            }
        }

    }

    private static void cfj(int arg0[], int arg1, int arg2, int arg3, int arg4[], int arg5, int arg6)
    {
        if(arg1 >= 0)
            return;
        arg6 <<= 2;
        arg3 = arg4[arg5 >> 8 & 0xff];
        arg5 += arg6;
        int k = arg1 / 16;
        for(int i1 = k; i1 < 0; i1++)
        {
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg0[arg2++] = arg3;
            arg3 = arg4[arg5 >> 8 & 0xff];
            arg5 += arg6;
        }

        k = -(arg1 % 16);
        for(int j1 = 0; j1 < k; j1++)
        {
            arg0[arg2++] = arg3;
            if((j1 & 3) == 3)
            {
                arg3 = arg4[arg5 >> 8 & 0xff];
                arg5 += arg6;
            }
        }

    }

    public void cfk(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        arg3 &= 0x3ff;
        arg4 &= 0x3ff;
        arg5 &= 0x3ff;
        ecl = 1024 - arg3 & 0x3ff;
        ecm = 1024 - arg4 & 0x3ff;
        ecn = 1024 - arg5 & 0x3ff;
        int k = 0;
        int i1 = 0;
        int j1 = arg6;
        if(arg3 != 0)
        {
            int k1 = ebd[arg3];
            int j2 = ebd[arg3 + 1024];
            int i3 = i1 * j2 - j1 * k1 >> 15;
            j1 = i1 * k1 + j1 * j2 >> 15;
            i1 = i3;
        }
        if(arg4 != 0)
        {
            int l1 = ebd[arg4];
            int k2 = ebd[arg4 + 1024];
            int j3 = j1 * l1 + k * k2 >> 15;
            j1 = j1 * k2 - k * l1 >> 15;
            k = j3;
        }
        if(arg5 != 0)
        {
            int i2 = ebd[arg5];
            int l2 = ebd[arg5 + 1024];
            int k3 = i1 * i2 + k * l2 >> 15;
            i1 = i1 * l2 - k * i2 >> 15;
            k = k3;
        }
        eci = arg0 - k;
        ecj = arg1 - i1;
        eck = arg2 - j1;
    }

    private void cfl(int arg0)
    {
        l l1 = edf[arg0];
        i k = l1.dja;
        int i1 = l1.djb;
        int ai[] = k.afg[i1];
        int j1 = k.aff[i1];
        int k1 = k.afk[i1];
        int j2 = k.ael[ai[0]];
        int k2 = k.aem[ai[0]];
        int l2 = k.aen[ai[0]];
        int i3 = k.ael[ai[1]] - j2;
        int j3 = k.aem[ai[1]] - k2;
        int k3 = k.aen[ai[1]] - l2;
        int l3 = k.ael[ai[2]] - j2;
        int i4 = k.aem[ai[2]] - k2;
        int j4 = k.aen[ai[2]] - l2;
        int k4 = j3 * j4 - i4 * k3;
        int l4 = k3 * l3 - j4 * i3;
        int i5 = i3 * i4 - l3 * j3;
        if(k1 == -1)
        {
            k1 = 0;
            for(; k4 > 25000 || l4 > 25000 || i5 > 25000 || k4 < -25000 || l4 < -25000 || i5 < -25000; i5 >>= 1)
            {
                k1++;
                k4 >>= 1;
                l4 >>= 1;
            }

            k.afk[i1] = k1;
            k.afj[i1] = (int)((double)ech * Math.sqrt(k4 * k4 + l4 * l4 + i5 * i5));
        } else
        {
            k4 >>= k1;
            l4 >>= k1;
            i5 >>= k1;
        }
        l1.djg = j2 * k4 + k2 * l4 + l2 * i5;
        l1.djd = k4;
        l1.dje = l4;
        l1.djf = i5;
        int j5 = k.aen[ai[0]];
        int k5 = j5;
        int l5 = k.afa[ai[0]];
        int i6 = l5;
        int j6 = k.afb[ai[0]];
        int k6 = j6;
        for(int l6 = 1; l6 < j1; l6++)
        {
            int i2 = k.aen[ai[l6]];
            if(i2 > k5)
                k5 = i2;
            else
            if(i2 < j5)
                j5 = i2;
            i2 = k.afa[ai[l6]];
            if(i2 > i6)
                i6 = i2;
            else
            if(i2 < l5)
                l5 = i2;
            i2 = k.afb[ai[l6]];
            if(i2 > k6)
                k6 = i2;
            else
            if(i2 < j6)
                j6 = i2;
        }

        l1.dim = j5;
        l1.din = k5;
        l1.dii = l5;
        l1.dik = i6;
        l1.dij = j6;
        l1.dil = k6;
    }

    private void cfm(int arg0)
    {
        l l1 = edf[arg0];
        i k = l1.dja;
        int i1 = l1.djb;
        int ai[] = k.afg[i1];
        int k1 = 0;
        int i2 = 0;
        int j2 = 1;
        int k2 = k.ael[ai[0]];
        int l2 = k.aem[ai[0]];
        int i3 = k.aen[ai[0]];
        k.afj[i1] = 1;
        k.afk[i1] = 0;
        l1.djg = k2 * k1 + l2 * i2 + i3 * j2;
        l1.djd = k1;
        l1.dje = i2;
        l1.djf = j2;
        int j3 = k.aen[ai[0]];
        int k3 = j3;
        int l3 = k.afa[ai[0]];
        int i4 = l3;
        if(k.afa[ai[1]] < l3)
            l3 = k.afa[ai[1]];
        else
            i4 = k.afa[ai[1]];
        int j4 = k.afb[ai[1]];
        int k4 = k.afb[ai[0]];
        int j1 = k.aen[ai[1]];
        if(j1 > k3)
            k3 = j1;
        else
        if(j1 < j3)
            j3 = j1;
        j1 = k.afa[ai[1]];
        if(j1 > i4)
            i4 = j1;
        else
        if(j1 < l3)
            l3 = j1;
        j1 = k.afb[ai[1]];
        if(j1 > k4)
            k4 = j1;
        else
        if(j1 < j4)
            j4 = j1;
        l1.dim = j3;
        l1.din = k3;
        l1.dii = l3 - 20;
        l1.dik = i4 + 20;
        l1.dij = j4;
        l1.dil = k4;
    }

    private boolean cfn(l arg0, l arg1)
    {
        if(arg0.dii >= arg1.dik)
            return true;
        if(arg1.dii >= arg0.dik)
            return true;
        if(arg0.dij >= arg1.dil)
            return true;
        if(arg1.dij >= arg0.dil)
            return true;
        if(arg0.dim >= arg1.din)
            return true;
        if(arg1.dim > arg0.din)
            return false;
        i k = arg0.dja;
        i i1 = arg1.dja;
        int j1 = arg0.djb;
        int k1 = arg1.djb;
        int ai[] = k.afg[j1];
        int ai1[] = i1.afg[k1];
        int l1 = k.aff[j1];
        int i2 = i1.aff[k1];
        int l3 = i1.ael[ai1[0]];
        int i4 = i1.aem[ai1[0]];
        int j4 = i1.aen[ai1[0]];
        int k4 = arg1.djd;
        int l4 = arg1.dje;
        int i5 = arg1.djf;
        int j5 = i1.afj[k1];
        int k5 = arg1.djg;
        boolean flag = false;
        for(int l5 = 0; l5 < l1; l5++)
        {
            int j2 = ai[l5];
            int j3 = (l3 - k.ael[j2]) * k4 + (i4 - k.aem[j2]) * l4 + (j4 - k.aen[j2]) * i5;
            if((j3 >= -j5 || k5 >= 0) && (j3 <= j5 || k5 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        l3 = k.ael[ai[0]];
        i4 = k.aem[ai[0]];
        j4 = k.aen[ai[0]];
        k4 = arg0.djd;
        l4 = arg0.dje;
        i5 = arg0.djf;
        j5 = k.afj[j1];
        k5 = arg0.djg;
        flag = false;
        for(int i6 = 0; i6 < i2; i6++)
        {
            int k2 = ai1[i6];
            int k3 = (l3 - i1.ael[k2]) * k4 + (i4 - i1.aem[k2]) * l4 + (j4 - i1.aen[k2]) * i5;
            if((k3 >= -j5 || k5 <= 0) && (k3 <= j5 || k5 >= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        int ai2[];
        int ai3[];
        if(l1 == 2)
        {
            ai2 = new int[4];
            ai3 = new int[4];
            int j6 = ai[0];
            int l2 = ai[1];
            ai2[0] = k.afa[j6] - 20;
            ai2[1] = k.afa[l2] - 20;
            ai2[2] = k.afa[l2] + 20;
            ai2[3] = k.afa[j6] + 20;
            ai3[0] = ai3[3] = k.afb[j6];
            ai3[1] = ai3[2] = k.afb[l2];
        } else
        {
            ai2 = new int[l1];
            ai3 = new int[l1];
            for(int k6 = 0; k6 < l1; k6++)
            {
                int j7 = ai[k6];
                ai2[k6] = k.afa[j7];
                ai3[k6] = k.afb[j7];
            }

        }
        int ai4[];
        int ai5[];
        if(i2 == 2)
        {
            ai4 = new int[4];
            ai5 = new int[4];
            int l6 = ai1[0];
            int i3 = ai1[1];
            ai4[0] = i1.afa[l6] - 20;
            ai4[1] = i1.afa[i3] - 20;
            ai4[2] = i1.afa[i3] + 20;
            ai4[3] = i1.afa[l6] + 20;
            ai5[0] = ai5[3] = i1.afb[l6];
            ai5[1] = ai5[2] = i1.afb[i3];
        } else
        {
            ai4 = new int[i2];
            ai5 = new int[i2];
            for(int i7 = 0; i7 < i2; i7++)
            {
                int k7 = ai1[i7];
                ai4[i7] = i1.afa[k7];
                ai5[i7] = i1.afb[k7];
            }

        }
        return !cgn(ai2, ai3, ai4, ai5);
    }

    private boolean cga(l arg0, l arg1)
    {
        i k = arg0.dja;
        i i1 = arg1.dja;
        int j1 = arg0.djb;
        int k1 = arg1.djb;
        int ai[] = k.afg[j1];
        int ai1[] = i1.afg[k1];
        int l1 = k.aff[j1];
        int i2 = i1.aff[k1];
        int j3 = i1.ael[ai1[0]];
        int k3 = i1.aem[ai1[0]];
        int l3 = i1.aen[ai1[0]];
        int i4 = arg1.djd;
        int j4 = arg1.dje;
        int k4 = arg1.djf;
        int l4 = i1.afj[k1];
        int i5 = arg1.djg;
        boolean flag = false;
        for(int j5 = 0; j5 < l1; j5++)
        {
            int j2 = ai[j5];
            int l2 = (j3 - k.ael[j2]) * i4 + (k3 - k.aem[j2]) * j4 + (l3 - k.aen[j2]) * k4;
            if((l2 >= -l4 || i5 >= 0) && (l2 <= l4 || i5 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        j3 = k.ael[ai[0]];
        k3 = k.aem[ai[0]];
        l3 = k.aen[ai[0]];
        i4 = arg0.djd;
        j4 = arg0.dje;
        k4 = arg0.djf;
        l4 = k.afj[j1];
        i5 = arg0.djg;
        flag = false;
        for(int k5 = 0; k5 < i2; k5++)
        {
            int k2 = ai1[k5];
            int i3 = (j3 - i1.ael[k2]) * i4 + (k3 - i1.aem[k2]) * j4 + (l3 - i1.aen[k2]) * k4;
            if((i3 >= -l4 || i5 <= 0) && (i3 <= l4 || i5 >= 0))
                continue;
            flag = true;
            break;
        }

        return !flag;
    }

    public void cgb(int arg0, int arg1, int arg2)
    {
        eeb = arg0;
        eec = new byte[arg0][];
        eed = new int[arg0][];
        eee = new int[arg0];
        eef = new long[arg0];
        eeh = new boolean[arg0];
        eeg = new int[arg0][];
        eei = 0L;
        eej = new int[arg1][];
        eek = new int[arg2][];
    }

    public void cgc(int arg0, byte arg1[], int arg2[], int arg3)
    {
        eec[arg0] = arg1;
        eed[arg0] = arg2;
        eee[arg0] = arg3;
        eef[arg0] = 0L;
        eeh[arg0] = false;
        eeg[arg0] = null;
        cgd(arg0);
    }

    public void cgd(int arg0)
    {
        if(arg0 < 0)
            return;
        eef[arg0] = eei++;
        if(eeg[arg0] != null)
            return;
        if(eee[arg0] == 0)
        {
            for(int k = 0; k < eej.length; k++)
                if(eej[k] == null)
                {
                    eej[k] = new int[16384];
                    eeg[arg0] = eej[k];
                    cge(arg0);
                    return;
                }

            long l1 = 1L << 30;
            int j1 = 0;
            for(int i2 = 0; i2 < eeb; i2++)
                if(i2 != arg0 && eee[i2] == 0 && eeg[i2] != null && eef[i2] < l1)
                {
                    l1 = eef[i2];
                    j1 = i2;
                }

            eeg[arg0] = eeg[j1];
            eeg[j1] = null;
            cge(arg0);
            return;
        }
        for(int i1 = 0; i1 < eek.length; i1++)
            if(eek[i1] == null)
            {
                eek[i1] = new int[0x10000];
                eeg[arg0] = eek[i1];
                cge(arg0);
                return;
            }

        long l2 = 1L << 30;
        int k1 = 0;
        for(int j2 = 0; j2 < eeb; j2++)
            if(j2 != arg0 && eee[j2] == 1 && eeg[j2] != null && eef[j2] < l2)
            {
                l2 = eef[j2];
                k1 = j2;
            }

        eeg[arg0] = eeg[k1];
        eeg[k1] = null;
        cge(arg0);
    }

    private void cge(int arg0)
    {
        char c;
        if(eee[arg0] == 0)
            c = '@';
        else
            c = '\200';
        int ai[] = eeg[arg0];
        int k = 0;
        for(int i1 = 0; i1 < c; i1++)
        {
            for(int j1 = 0; j1 < c; j1++)
            {
                int l1 = eed[arg0][eec[arg0][j1 + i1 * c] & 0xff];
                l1 &= 0xf8f8ff;
                if(l1 == 0)
                    l1 = 1;
                else
                if(l1 == 0xf800ff)
                {
                    l1 = 0;
                    eeh[arg0] = true;
                }
                ai[k++] = l1;
            }

        }

        for(int k1 = 0; k1 < k; k1++)
        {
            int i2 = ai[k1];
            ai[k + k1] = i2 - (i2 >>> 3) & 0xf8f8ff;
            ai[k * 2 + k1] = i2 - (i2 >>> 2) & 0xf8f8ff;
            ai[k * 3 + k1] = i2 - (i2 >>> 2) - (i2 >>> 3) & 0xf8f8ff;
        }

    }

    public void cgf(int arg0)
    {
        if(eeg[arg0] == null)
            return;
        int ai[] = eeg[arg0];
        for(int k = 0; k < 64; k++)
        {
            int i1 = k + 4032;
            int j1 = ai[i1];
            for(int l1 = 0; l1 < 63; l1++)
            {
                ai[i1] = ai[i1 - 64];
                i1 -= 64;
            }

            eeg[arg0][i1] = j1;
        }

        char c = '\u1000';
        for(int k1 = 0; k1 < c; k1++)
        {
            int i2 = ai[k1];
            ai[c + k1] = i2 - (i2 >>> 3) & 0xf8f8ff;
            ai[c * 2 + k1] = i2 - (i2 >>> 2) & 0xf8f8ff;
            ai[c * 3 + k1] = i2 - (i2 >>> 2) - (i2 >>> 3) & 0xf8f8ff;
        }

    }

    public int cgg(int arg0)
    {
        if(arg0 == 0xbc614e)
            return 0;
        cgd(arg0);
        if(arg0 >= 0)
            return eeg[arg0][0];
        if(arg0 < 0)
        {
            arg0 = -(arg0 + 1);
            int k = arg0 >> 10 & 0x1f;
            int i1 = arg0 >> 5 & 0x1f;
            int j1 = arg0 & 0x1f;
            return (k << 19) + (i1 << 11) + (j1 << 3);
        } else
        {
            return 0;
        }
    }

    public void cgh(int arg0, int arg1, int arg2)
    {
        if(arg0 == 0 && arg1 == 0 && arg2 == 0)
            arg0 = 32;
        for(int k = 0; k < eda; k++)
            edc[k].afn(arg0, arg1, arg2);

    }

    public void cgi(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(arg2 == 0 && arg3 == 0 && arg4 == 0)
            arg2 = 32;
        for(int k = 0; k < eda; k++)
            edc[k].afm(arg0, arg1, arg2, arg3, arg4);

    }

    public static int cgj(int arg0, int arg1, int arg2)
    {
        return -1 - (arg0 / 8) * 1024 - (arg1 / 8) * 32 - arg2 / 8;
    }

    public int cgk(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(arg3 == arg1)
            return arg0;
        else
            return arg0 + ((arg2 - arg0) * (arg4 - arg1)) / (arg3 - arg1);
    }

    public boolean cgl(int arg0, int arg1, int arg2, int arg3, boolean arg4)
    {
        if(arg4 && arg0 <= arg2 || arg0 < arg2)
        {
            if(arg0 > arg3)
                return true;
            if(arg1 > arg2)
                return true;
            if(arg1 > arg3)
                return true;
            return !arg4;
        }
        if(arg0 < arg3)
            return true;
        if(arg1 < arg2)
            return true;
        if(arg1 < arg3)
            return true;
        else
            return arg4;
    }

    public boolean cgm(int arg0, int arg1, int arg2, boolean arg3)
    {
        if(arg3 && arg0 <= arg2 || arg0 < arg2)
        {
            if(arg1 > arg2)
                return true;
            return !arg3;
        }
        if(arg1 < arg2)
            return true;
        else
            return arg3;
    }

    public boolean cgn(int arg0[], int arg1[], int arg2[], int arg3[])
    {
        int k = arg0.length;
        int i1 = arg2.length;
        byte byte0 = 0;
        int l20;
        int j21 = l20 = arg1[0];
        int j1 = 0;
        int i21;
        int k21 = i21 = arg3[0];
        int l1 = 0;
        for(int l21 = 1; l21 < k; l21++)
            if(arg1[l21] < l20)
            {
                l20 = arg1[l21];
                j1 = l21;
            } else
            if(arg1[l21] > j21)
                j21 = arg1[l21];

        for(int i22 = 1; i22 < i1; i22++)
            if(arg3[i22] < i21)
            {
                i21 = arg3[i22];
                l1 = i22;
            } else
            if(arg3[i22] > k21)
                k21 = arg3[i22];

        if(i21 >= j21)
            return false;
        if(l20 >= k21)
            return false;
        int k1;
        int i2;
        boolean flag;
        if(arg1[j1] < arg3[l1])
        {
            for(k1 = j1; arg1[k1] < arg3[l1]; k1 = (k1 + 1) % k);
            for(; arg1[j1] < arg3[l1]; j1 = ((j1 - 1) + k) % k);
            int j2 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
            int j7 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
            int k11 = arg2[l1];
            flag = (j2 < k11) | (j7 < k11);
            if(cgm(j2, j7, k11, flag))
                return true;
            i2 = (l1 + 1) % i1;
            l1 = ((l1 - 1) + i1) % i1;
            if(j1 == k1)
                byte0 = 1;
        } else
        {
            for(i2 = l1; arg3[i2] < arg1[j1]; i2 = (i2 + 1) % i1);
            for(; arg3[l1] < arg1[j1]; l1 = ((l1 - 1) + i1) % i1);
            int k2 = arg0[j1];
            int l11 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[j1]);
            int k16 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[j1]);
            flag = (k2 < l11) | (k2 < k16);
            if(cgm(l11, k16, k2, !flag))
                return true;
            k1 = (j1 + 1) % k;
            j1 = ((j1 - 1) + k) % k;
            if(l1 == i2)
                byte0 = 2;
        }
        while(byte0 == 0) 
            if(arg1[j1] < arg1[k1])
            {
                if(arg1[j1] < arg3[l1])
                {
                    if(arg1[j1] < arg3[i2])
                    {
                        int l2 = arg0[j1];
                        int k7 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg1[j1]);
                        int i12 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[j1]);
                        int l16 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[j1]);
                        if(cgl(l2, k7, i12, l16, flag))
                            return true;
                        j1 = ((j1 - 1) + k) % k;
                        if(j1 == k1)
                            byte0 = 1;
                    } else
                    {
                        int i3 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                        int l7 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                        int j12 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                        int i17 = arg2[i2];
                        if(cgl(i3, l7, j12, i17, flag))
                            return true;
                        i2 = (i2 + 1) % i1;
                        if(l1 == i2)
                            byte0 = 2;
                    }
                } else
                if(arg3[l1] < arg3[i2])
                {
                    int j3 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
                    int i8 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
                    int k12 = arg2[l1];
                    int j17 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg3[l1]);
                    if(cgl(j3, i8, k12, j17, flag))
                        return true;
                    l1 = ((l1 - 1) + i1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                } else
                {
                    int k3 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                    int j8 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                    int l12 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                    int k17 = arg2[i2];
                    if(cgl(k3, j8, l12, k17, flag))
                        return true;
                    i2 = (i2 + 1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                }
            } else
            if(arg1[k1] < arg3[l1])
            {
                if(arg1[k1] < arg3[i2])
                {
                    int l3 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg1[k1]);
                    int k8 = arg0[k1];
                    int i13 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[k1]);
                    int l17 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[k1]);
                    if(cgl(l3, k8, i13, l17, flag))
                        return true;
                    k1 = (k1 + 1) % k;
                    if(j1 == k1)
                        byte0 = 1;
                } else
                {
                    int i4 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                    int l8 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                    int j13 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                    int i18 = arg2[i2];
                    if(cgl(i4, l8, j13, i18, flag))
                        return true;
                    i2 = (i2 + 1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                }
            } else
            if(arg3[l1] < arg3[i2])
            {
                int j4 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
                int i9 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
                int k13 = arg2[l1];
                int j18 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg3[l1]);
                if(cgl(j4, i9, k13, j18, flag))
                    return true;
                l1 = ((l1 - 1) + i1) % i1;
                if(l1 == i2)
                    byte0 = 2;
            } else
            {
                int k4 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                int j9 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                int l13 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                int k18 = arg2[i2];
                if(cgl(k4, j9, l13, k18, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 2;
            }
        while(byte0 == 1) 
            if(arg1[j1] < arg3[l1])
            {
                if(arg1[j1] < arg3[i2])
                {
                    int l4 = arg0[j1];
                    int i14 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[j1]);
                    int l18 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[j1]);
                    return cgm(i14, l18, l4, !flag);
                }
                int i5 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                int k9 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                int j14 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                int i19 = arg2[i2];
                if(cgl(i5, k9, j14, i19, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            } else
            if(arg3[l1] < arg3[i2])
            {
                int j5 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
                int l9 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
                int k14 = arg2[l1];
                int j19 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg3[l1]);
                if(cgl(j5, l9, k14, j19, flag))
                    return true;
                l1 = ((l1 - 1) + i1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            } else
            {
                int k5 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[i2]);
                int i10 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[i2]);
                int l14 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg3[i2]);
                int k19 = arg2[i2];
                if(cgl(k5, i10, l14, k19, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            }
        while(byte0 == 2) 
            if(arg3[l1] < arg1[j1])
            {
                if(arg3[l1] < arg1[k1])
                {
                    int l5 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
                    int j10 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
                    int i15 = arg2[l1];
                    return cgm(l5, j10, i15, flag);
                }
                int i6 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg1[k1]);
                int k10 = arg0[k1];
                int j15 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[k1]);
                int l19 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[k1]);
                if(cgl(i6, k10, j15, l19, flag))
                    return true;
                k1 = (k1 + 1) % k;
                if(j1 == k1)
                    byte0 = 0;
            } else
            if(arg1[j1] < arg1[k1])
            {
                int j6 = arg0[j1];
                int l10 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg1[j1]);
                int k15 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[j1]);
                int i20 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[j1]);
                if(cgl(j6, l10, k15, i20, flag))
                    return true;
                j1 = ((j1 - 1) + k) % k;
                if(j1 == k1)
                    byte0 = 0;
            } else
            {
                int k6 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg1[k1]);
                int i11 = arg0[k1];
                int l15 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[k1]);
                int j20 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[k1]);
                if(cgl(k6, i11, l15, j20, flag))
                    return true;
                k1 = (k1 + 1) % k;
                if(j1 == k1)
                    byte0 = 0;
            }
        if(arg1[j1] < arg3[l1])
        {
            int l6 = arg0[j1];
            int i16 = cgk(arg2[(l1 + 1) % i1], arg3[(l1 + 1) % i1], arg2[l1], arg3[l1], arg1[j1]);
            int k20 = cgk(arg2[((i2 - 1) + i1) % i1], arg3[((i2 - 1) + i1) % i1], arg2[i2], arg3[i2], arg1[j1]);
            return cgm(i16, k20, l6, !flag);
        }
        int i7 = cgk(arg0[(j1 + 1) % k], arg1[(j1 + 1) % k], arg0[j1], arg1[j1], arg3[l1]);
        int j11 = cgk(arg0[((k1 - 1) + k) % k], arg1[((k1 - 1) + k) % k], arg0[k1], arg1[k1], arg3[l1]);
        int j16 = arg2[l1];
        return cgm(i7, j11, j16, flag);
    }

    int eah;
    int eai[];
    int eaj[][];
    int eak[];
    public int eal;
    public int eam;
    public int ean;
    public int eba;
    public int ebb;
    public int ebc;
    public static int ebd[] = new int[2048];
    private static int ebe[] = new int[512];
    public boolean ebf;
    public double ebg;
    public int ebh;
    private boolean ebi;
    private int ebj;
    private int ebk;
    private int ebl;
    private int ebm;
    private i ebn[];
    private int eca[];
    private int ecb;
    private int ecc;
    private int ecd;
    private int ece;
    private int ecf;
    private int ecg;
    private int ech;
    private int eci;
    private int ecj;
    private int eck;
    private int ecl;
    private int ecm;
    private int ecn;
    public int eda;
    public int edb;
    public i edc[];
    private int edd[];
    private int ede;
    private l edf[];
    private int edg;
    private int edh[];
    private int edi[];
    private int edj[];
    private int edk[];
    private int edl[];
    private int edm[];
    private int edn[];
    public i eea;
    int eeb;
    byte eec[][];
    int eed[][];
    int eee[];
    long eef[];
    int eeg[][];
    boolean eeh[];
    private static long eei;
    int eej[][];
    int eek[][];
    private static byte eel[];
    private static int eem[] = new int[256];
    j een;
    public int efa[];
    m efb[];
    int efc;
    int efd;
    int efe[];
    int eff[];
    int efg[];
    int efh[];
    int efi[];
    int efj[];
    boolean efk;
    static int efl;
    static int efm;
    static int efn;
    static int ega;
    static int egb;
    static int egc;
    int egd;
    int ege;

}