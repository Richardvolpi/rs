// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class bbe
{

    public bbe(blm blm1, int i, int j, int k)
    {
        super();
        boolean flag = false;
        bbf = 50;
        bbg = new int[bbf];
        bbh = new int[bbf][256];
        bbk = 5;
        bbl = 1000;
        bbm = 1000;
        bbn = 20;
        bca = 10;
        bcd = false;
        bce = 1.1000000000000001D;
        bcf = 1;
        bcg = false;
        bck = 100;
        bcl = new cgc[bck];
        bcm = new int[bck];
        bcn = 512;
        bda = 256;
        bdb = 192;
        bdc = 256;
        bdd = 256;
        bde = 8;
        bdf = 4;
        bgc = new int[40];
        bgd = new int[40];
        bge = new int[40];
        bgf = new int[40];
        bgg = new int[40];
        bgh = new int[40];
        bgi = false;
        bfl = blm1;
        bda = blm1.bln / 2;
        bdb = blm1.bma / 2;
        bfm = blm1.bmf;
        bdm = 0;
        bdn = i;
        bea = new cgc[bdn];
        beb = new int[bdn];
        bec = 0;
        bed = new bki[j];
        for(int l = 0; l < j; l++)
            bed[l] = new bki();

        bee = 0;
        bem = new cgc(k * 2, k);
        bef = new int[k];
        bej = new int[k];
        bek = new int[k];
        beg = new int[k];
        beh = new int[k];
        bei = new int[k];
        bel = new int[k];
        if(bfj == null)
            bfj = new byte[17691];
        bdg = 0;
        bdh = 0;
        bdi = 0;
        bdj = 0;
        bdk = 0;
        bdl = 0;
        for(int i1 = 0; i1 < 256; i1++)
        {
            bcc[i1] = (int)(Math.sin((double)i1 * 0.02454369D) * 32768D);
            bcc[i1 + 256] = (int)(Math.cos((double)i1 * 0.02454369D) * 32768D);
        }

        for(int j1 = 0; j1 < 1024; j1++)
        {
            bcb[j1] = (int)(Math.sin((double)j1 * 0.00613592315D) * 32768D);
            bcb[j1 + 1024] = (int)(Math.cos((double)j1 * 0.00613592315D) * 32768D);
        }

    }

    public void bhd(cgc cgc1)
    {
        if(cgc1 == null)
            System.out.println("Warning tried to add null object!");
        if(bdm < bdn)
        {
            beb[bdm] = 0;
            bea[bdm++] = cgc1;
        }
    }

    public void bhe(cgc cgc1)
    {
        boolean flag = false;
        for(int i = 0; i < bdm; i++)
            if(bea[i] == cgc1)
            {
                bdm--;
                for(int j = i; j < bdm; j++)
                {
                    bea[j] = bea[j + 1];
                    beb[j] = beb[j + 1];
                }

            }

    }

    public void bhf()
    {
        bhg();
        for(int i = 0; i < bdm; i++)
            bea[i] = null;

        bdm = 0;
    }

    public void bhg()
    {
        bee = 0;
        bem.cmg();
    }

    public void bhh(int i)
    {
        bee -= i;
        bem.cmh(i, i * 2);
        if(bee < 0)
            bee = 0;
    }

    public int bhi(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        bef[bee] = i;
        beg[bee] = j;
        beh[bee] = k;
        bei[bee] = l;
        bej[bee] = i1;
        bek[bee] = j1;
        bel[bee] = 0;
        int l1 = bem.cmk(j, k, l);
        int i2 = bem.cmk(j, k - j1, l);
        int ai[] = {
            l1, i2
        };
        bem.cml(2, ai, 0, 0);
        bem.cih[bee] = k1;
        bem.cii[bee++] = 0;
        return bee - 1;
    }

    public void bhj(int i)
    {
        bem.cii[i] = 1;
    }

    public void bhk(int i, int j)
    {
        bel[i] = j;
    }

    public void bhl(int i, int j)
    {
        bch = i - bdc;
        bci = j;
        bcj = 0;
        bcg = true;
    }

    public int bhm()
    {
        return bcj;
    }

    public int[] bhn()
    {
        return bcm;
    }

    public cgc[] bia()
    {
        return bcl;
    }

    public void bib(int i, int j, int k, int l, int i1, int j1)
    {
        bda = k;
        bdb = l;
        bdc = i;
        bdd = j;
        bcn = i1;
        bde = j1;
        bfn = new fna[l + j];
        for(int k1 = 0; k1 < l + j; k1++)
            bfn[k1] = new fna();

    }

    private void bic(bki abki[], int i, int j)
    {
        if(i < j)
        {
            int k = i - 1;
            int l = j + 1;
            int i1 = (i + j) / 2;
            bki bki1 = abki[i1];
            abki[i1] = abki[i];
            abki[i] = bki1;
            int j1 = bki1.bld;
            while(k < l) 
            {
                do
                    l--;
                while(abki[l].bld < j1);
                do
                    k++;
                while(abki[k].bld > j1);
                if(k < l)
                {
                    bki bki2 = abki[k];
                    abki[k] = abki[l];
                    abki[l] = bki2;
                }
            }
            bic(abki, i, l);
            bic(abki, l + 1, j);
        }
    }

    public void bid(int i, bki abki[], int j)
    {
        boolean flag = false;
        for(int k = 0; k <= j; k++)
        {
            abki[k].blj = false;
            abki[k].blk = k;
            abki[k].bll = -1;
        }

        int l = 0;
        do
        {
            while(abki[l].blj) 
                l++;
            if(l == j)
                return;
            bki bki1 = abki[l];
            bki1.blj = true;
            int i1 = l;
            int j1 = l + i;
            if(j1 >= j)
                j1 = j - 1;
            for(int k1 = j1; k1 >= i1 + 1; k1--)
            {
                bki bki2 = abki[k1];
                if(bki1.bkj < bki2.bkl && bki2.bkj < bki1.bkl && bki1.bkk < bki2.bkm && bki2.bkk < bki1.bkm && bki1.blk != bki2.bll && !bjh(bki1, bki2) && bji(bki2, bki1))
                {
                    bie(abki, i1, k1);
                    if(abki[k1] != bki2)
                        k1++;
                    i1 = bhb;
                    bki2.bll = bki1.blk;
                }
            }

        } while(true);
    }

    public boolean bie(bki abki[], int i, int j)
    {
        boolean flag = false;
        do
        {
            bki bki1 = abki[i];
            for(int k = i + 1; k <= j; k++)
            {
                bki bki2 = abki[k];
                if(!bjh(bki2, bki1))
                    break;
                abki[i] = bki2;
                abki[k] = bki1;
                i = k;
                if(i == j)
                {
                    bhb = i;
                    bhc = i - 1;
                    return true;
                }
            }

            bki bki3 = abki[j];
            for(int l = j - 1; l >= i; l--)
            {
                bki bki4 = abki[l];
                if(!bjh(bki3, bki4))
                    break;
                abki[j] = bki4;
                abki[l] = bki3;
                j = l;
                if(i == j)
                {
                    bhb = j + 1;
                    bhc = j;
                    return true;
                }
            }

            if(i + 1 >= j)
            {
                bhb = i;
                bhc = j;
                return false;
            }
            if(!bie(abki, i + 1, j))
            {
                bhb = i;
                return false;
            }
            j = bhc;
        } while(true);
    }

    public void bif(int i, int j, int k)
    {
        int l = -bdj + 1024 & 0x3ff;
        int i1 = -bdk + 1024 & 0x3ff;
        int j1 = -bdl + 1024 & 0x3ff;
        if(j1 != 0)
        {
            int k1 = bcb[j1];
            int j2 = bcb[j1 + 1024];
            int i3 = j * k1 + i * j2 >> 15;
            j = j * j2 - i * k1 >> 15;
            i = i3;
        }
        if(l != 0)
        {
            int l1 = bcb[l];
            int k2 = bcb[l + 1024];
            int j3 = j * k2 - k * l1 >> 15;
            k = j * l1 + k * k2 >> 15;
            j = j3;
        }
        if(i1 != 0)
        {
            int i2 = bcb[i1];
            int l2 = bcb[i1 + 1024];
            int k3 = k * i2 + i * l2 >> 15;
            k = k * l2 - i * i2 >> 15;
            i = k3;
        }
        if(i < bgj)
            bgj = i;
        if(i > bgk)
            bgk = i;
        if(j < bgl)
            bgl = j;
        if(j > bgm)
            bgm = j;
        if(k < bgn)
            bgn = k;
        if(k > bha)
            bha = k;
    }

    public void big()
    {
        boolean flag1 = false;
        bgi = bfl.bnj;
        int i3 = bda * bbl >> bde;
        int j3 = bdb * bbl >> bde;
        bgj = 0;
        bgk = 0;
        bgl = 0;
        bgm = 0;
        bgn = 0;
        bha = 0;
        bif(-i3, -j3, bbl);
        bif(-i3, j3, bbl);
        bif(i3, -j3, bbl);
        bif(i3, j3, bbl);
        bif(-bda, -bdb, 0);
        bif(-bda, bdb, 0);
        bif(bda, -bdb, 0);
        bif(bda, bdb, 0);
        bgj += bdg;
        bgk += bdg;
        bgl += bdh;
        bgm += bdh;
        bgn += bdi;
        bha += bdi;
        bea[bdm] = bem;
        bem.chj = 2;
        for(int i = 0; i < bdm; i++)
            bea[i].dad(bdg, bdh, bdi, bdj, bdk, bdl, bde, bbk);

        bea[bdm].dad(bdg, bdh, bdi, bdj, bdk, bdl, bde, bbk);
        bec = 0;
        for(int k3 = 0; k3 < bdm; k3++)
        {
            cgc cgc1 = bea[k3];
            if(cgc1.chk)
            {
                for(int j = 0; j < cgc1.cgl; j++)
                {
                    int l3 = cgc1.cgm[j];
                    int ai1[] = cgc1.cgn[j];
                    boolean flag = false;
                    for(int k4 = 0; k4 < l3; k4++)
                    {
                        int i1 = cgc1.cgg[ai1[k4]];
                        if(i1 <= bbk || i1 >= bbl)
                            continue;
                        flag = true;
                        break;
                    }

                    if(flag)
                    {
                        int l1 = 0;
                        for(int k5 = 0; k5 < l3; k5++)
                        {
                            int j1 = cgc1.cgh[ai1[k5]];
                            if(j1 > -bda)
                                l1 |= 1;
                            if(j1 < bda)
                                l1 |= 2;
                            if(l1 == 3)
                                break;
                        }

                        if(l1 == 3)
                        {
                            int i2 = 0;
                            for(int l6 = 0; l6 < l3; l6++)
                            {
                                int k1 = cgc1.cgi[ai1[l6]];
                                if(k1 > -bdb)
                                    i2 |= 1;
                                if(k1 < bdb)
                                    i2 |= 2;
                                if(i2 == 3)
                                    break;
                            }

                            if(i2 == 3)
                            {
                                bki bki2 = bed[bec];
                                bki2.blb = cgc1;
                                bki2.blc = j;
                                bjf(bec);
                                int l8;
                                if(bki2.blh < 0)
                                    l8 = cgc1.cha[j];
                                else
                                    l8 = cgc1.chb[j];
                                if(l8 != 0xbc614e)
                                {
                                    int j2 = 0;
                                    for(int l9 = 0; l9 < l3; l9++)
                                        j2 += cgc1.cgg[ai1[l9]];

                                    int l2;
                                    bki2.bld = l2 = j2 / l3 + 0;
                                    bki2.bli = l8;
                                    bec++;
                                }
                            }
                        }
                    }
                }

            }
        }

        cgc cgc2 = bem;
        if(cgc2.chk)
        {
            for(int k = 0; k < cgc2.cgl; k++)
            {
                int ai[] = cgc2.cgn[k];
                int j4 = ai[0];
                int l4 = cgc2.cgh[j4];
                int l5 = cgc2.cgi[j4];
                int i7 = cgc2.cgg[j4];
                if(i7 > bbk && i7 < bbm)
                {
                    int i8 = (bej[k] << bde) / i7;
                    int i9 = (bek[k] << bde) / i7;
                    if(l4 - i8 / 2 <= bda && l4 + i8 / 2 >= -bda && l5 - i9 <= bdb && l5 >= -bdb)
                    {
                        bki bki3 = bed[bec];
                        bki3.blb = cgc2;
                        bki3.blc = k;
                        bjg(bec);
                        bki3.bld = (i7 + cgc2.cgg[ai[1]]) / 2;
                        bec++;
                    }
                }
            }

        }
        if(bec == 0)
            return;
        bbj = bec;
        bic(bed, 0, bec - 1);
        bid(100, bed, bec);
        for(int i4 = 0; i4 < bec; i4++)
        {
            bki bki1 = bed[i4];
            cgc cgc3 = bki1.blb;
            int l = bki1.blc;
            if(cgc3 == bem)
            {
                int ai2[] = cgc3.cgn[l];
                int i6 = ai2[0];
                int j7 = cgc3.cgh[i6];
                int j8 = cgc3.cgi[i6];
                int j9 = cgc3.cgg[i6];
                int i10 = (bej[l] << bde) / j9;
                int k10 = (bek[l] << bde) / j9;
                int i11 = j8 - cgc3.cgi[ai2[1]];
                int j11 = ((cgc3.cgh[ai2[1]] - j7) * i11) / k10;
                j11 = cgc3.cgh[ai2[1]] - j7;
                int l11 = j7 - i10 / 2;
                int j12 = (bdd + j8) - k10;
                bfl.cdj(l11 + bdc, j12, i10, k10, bef[l], j11, (256 << bde) / j9);
                if(bcg && bcj < bck)
                {
                    l11 += (bel[l] << bde) / j9;
                    if(bci >= j12 && bci <= j12 + k10 && bch >= l11 && bch <= l11 + i10 && !cgc3.cim && cgc3.cii[l] == 0)
                    {
                        bcl[bcj] = cgc3;
                        bcm[bcj] = l;
                        bcj++;
                    }
                }
            } else
            {
                int k8 = 0;
                int j10 = 0;
                int l10 = cgc3.cgm[l];
                int ai3[] = cgc3.cgn[l];
                if(cgc3.che[l] != 0xbc614e)
                    if(bki1.blh < 0)
                        j10 = cgc3.cmb - cgc3.che[l];
                    else
                        j10 = cgc3.cmb + cgc3.che[l];
                for(int k11 = 0; k11 < l10; k11++)
                {
                    int k2 = ai3[k11];
                    bgf[k11] = cgc3.cge[k2];
                    bgg[k11] = cgc3.cgf[k2];
                    bgh[k11] = cgc3.cgg[k2];
                    if(cgc3.che[l] == 0xbc614e)
                        if(bki1.blh < 0)
                            j10 = (cgc3.cmb - cgc3.cgj[k2]) + cgc3.cgk[k2];
                        else
                            j10 = cgc3.cmb + cgc3.cgj[k2] + cgc3.cgk[k2];
                    if(cgc3.cgg[k2] >= bbk)
                    {
                        bgc[k8] = cgc3.cgh[k2];
                        bgd[k8] = cgc3.cgi[k2];
                        bge[k8] = j10;
                        if(cgc3.cgg[k2] > bca)
                            bge[k8] += (cgc3.cgg[k2] - bca) / bbn;
                        k8++;
                    } else
                    {
                        int k9;
                        if(k11 == 0)
                            k9 = ai3[l10 - 1];
                        else
                            k9 = ai3[k11 - 1];
                        if(cgc3.cgg[k9] >= bbk)
                        {
                            int k7 = cgc3.cgg[k2] - cgc3.cgg[k9];
                            int i5 = cgc3.cge[k2] - ((cgc3.cge[k2] - cgc3.cge[k9]) * (cgc3.cgg[k2] - bbk)) / k7;
                            int j6 = cgc3.cgf[k2] - ((cgc3.cgf[k2] - cgc3.cgf[k9]) * (cgc3.cgg[k2] - bbk)) / k7;
                            bgc[k8] = (i5 << bde) / bbk;
                            bgd[k8] = (j6 << bde) / bbk;
                            bge[k8] = j10;
                            k8++;
                        }
                        if(k11 == l10 - 1)
                            k9 = ai3[0];
                        else
                            k9 = ai3[k11 + 1];
                        if(cgc3.cgg[k9] >= bbk)
                        {
                            int l7 = cgc3.cgg[k2] - cgc3.cgg[k9];
                            int j5 = cgc3.cge[k2] - ((cgc3.cge[k2] - cgc3.cge[k9]) * (cgc3.cgg[k2] - bbk)) / l7;
                            int k6 = cgc3.cgf[k2] - ((cgc3.cgf[k2] - cgc3.cgf[k9]) * (cgc3.cgg[k2] - bbk)) / l7;
                            bgc[k8] = (j5 << bde) / bbk;
                            bgd[k8] = (k6 << bde) / bbk;
                            bge[k8] = j10;
                            k8++;
                        }
                    }
                }

                for(int i12 = 0; i12 < l10; i12++)
                {
                    if(bge[i12] < 0)
                        bge[i12] = 0;
                    else
                    if(bge[i12] > 255)
                        bge[i12] = 255;
                    if(bki1.bli >= 0)
                        if(bfc[bki1.bli] == 1)
                            bge[i12] <<= 9;
                        else
                            bge[i12] <<= 6;
                }

                bih(0, 0, 0, 0, k8, bgc, bgd, bge, cgc3, l);
                if(bgb > bga)
                    bii(0, 0, l10, bgf, bgg, bgh, bki1.bli, cgc3);
            }
        }

        bcg = false;
    }

    private void bih(int i, int j, int k, int l, int i1, int ai[], int ai1[], 
            int ai2[], cgc cgc1, int j1)
    {
        boolean flag = false;
        if(i1 == 3)
        {
            int k1 = ai1[0] + bdd;
            int k2 = ai1[1] + bdd;
            int k3 = ai1[2] + bdd;
            int k4 = ai[0];
            int l5 = ai[1];
            int j7 = ai[2];
            int l8 = ai2[0];
            int j10 = ai2[1];
            int j11 = ai2[2];
            int j12 = (bdd + bdb) - 1;
            int l12 = 0;
            int j13 = 0;
            int l13 = 0;
            int j14 = 0;
            int l14 = 0xbc614e;
            int j15 = 0xff439eb2;
            if(k3 != k1)
            {
                j13 = (j7 - k4 << 8) / (k3 - k1);
                j14 = (j11 - l8 << 8) / (k3 - k1);
                if(k1 < k3)
                {
                    l12 = k4 << 8;
                    l13 = l8 << 8;
                    l14 = k1;
                    j15 = k3;
                } else
                {
                    l12 = j7 << 8;
                    l13 = j11 << 8;
                    l14 = k3;
                    j15 = k1;
                }
                if(l14 < 0)
                {
                    l12 -= j13 * l14;
                    l13 -= j14 * l14;
                    l14 = 0;
                }
                if(j15 > j12)
                    j15 = j12;
            }
            int l15 = 0;
            int j16 = 0;
            int l16 = 0;
            int j17 = 0;
            int l17 = 0xbc614e;
            int j18 = 0xff439eb2;
            if(k2 != k1)
            {
                j16 = (l5 - k4 << 8) / (k2 - k1);
                j17 = (j10 - l8 << 8) / (k2 - k1);
                if(k1 < k2)
                {
                    l15 = k4 << 8;
                    l16 = l8 << 8;
                    l17 = k1;
                    j18 = k2;
                } else
                {
                    l15 = l5 << 8;
                    l16 = j10 << 8;
                    l17 = k2;
                    j18 = k1;
                }
                if(l17 < 0)
                {
                    l15 -= j16 * l17;
                    l16 -= j17 * l17;
                    l17 = 0;
                }
                if(j18 > j12)
                    j18 = j12;
            }
            int l18 = 0;
            int j19 = 0;
            int l19 = 0;
            int j20 = 0;
            int l20 = 0xbc614e;
            int j21 = 0xff439eb2;
            if(k3 != k2)
            {
                j19 = (j7 - l5 << 8) / (k3 - k2);
                j20 = (j11 - j10 << 8) / (k3 - k2);
                if(k2 < k3)
                {
                    l18 = l5 << 8;
                    l19 = j10 << 8;
                    l20 = k2;
                    j21 = k3;
                } else
                {
                    l18 = j7 << 8;
                    l19 = j11 << 8;
                    l20 = k3;
                    j21 = k2;
                }
                if(l20 < 0)
                {
                    l18 -= j19 * l20;
                    l19 -= j20 * l20;
                    l20 = 0;
                }
                if(j21 > j12)
                    j21 = j12;
            }
            bga = l14;
            if(l17 < bga)
                bga = l17;
            if(l20 < bga)
                bga = l20;
            bgb = j15;
            if(j18 > bgb)
                bgb = j18;
            if(j21 > bgb)
                bgb = j21;
            int l21 = 0;
            for(k = bga; k < bgb; k++)
            {
                if(k >= l14 && k < j15)
                {
                    i = j = l12;
                    l = l21 = l13;
                    l12 += j13;
                    l13 += j14;
                } else
                {
                    i = 0xa0000;
                    j = 0xfff60000;
                }
                if(k >= l17 && k < j18)
                {
                    if(l15 < i)
                    {
                        i = l15;
                        l = l16;
                    }
                    if(l15 > j)
                    {
                        j = l15;
                        l21 = l16;
                    }
                    l15 += j16;
                    l16 += j17;
                }
                if(k >= l20 && k < j21)
                {
                    if(l18 < i)
                    {
                        i = l18;
                        l = l19;
                    }
                    if(l18 > j)
                    {
                        j = l18;
                        l21 = l19;
                    }
                    l18 += j19;
                    l19 += j20;
                }
                fna fna7 = bfn[k];
                fna7.fnb = i;
                fna7.fnc = j;
                fna7.fnd = l;
                fna7.fne = l21;
            }

            if(bga < bdd - bdb)
                bga = bdd - bdb;
        } else
        if(i1 == 4)
        {
            int l1 = ai1[0] + bdd;
            int l2 = ai1[1] + bdd;
            int l3 = ai1[2] + bdd;
            int l4 = ai1[3] + bdd;
            int i6 = ai[0];
            int k7 = ai[1];
            int i9 = ai[2];
            int k10 = ai[3];
            int k11 = ai2[0];
            int k12 = ai2[1];
            int i13 = ai2[2];
            int k13 = ai2[3];
            int i14 = (bdd + bdb) - 1;
            int k14 = 0;
            int i15 = 0;
            int k15 = 0;
            int i16 = 0;
            int k16 = 0xbc614e;
            int i17 = 0xff439eb2;
            if(l4 != l1)
            {
                i15 = (k10 - i6 << 8) / (l4 - l1);
                i16 = (k13 - k11 << 8) / (l4 - l1);
                if(l1 < l4)
                {
                    k14 = i6 << 8;
                    k15 = k11 << 8;
                    k16 = l1;
                    i17 = l4;
                } else
                {
                    k14 = k10 << 8;
                    k15 = k13 << 8;
                    k16 = l4;
                    i17 = l1;
                }
                if(k16 < 0)
                {
                    k14 -= i15 * k16;
                    k15 -= i16 * k16;
                    k16 = 0;
                }
                if(i17 > i14)
                    i17 = i14;
            }
            int k17 = 0;
            int i18 = 0;
            int k18 = 0;
            int i19 = 0;
            int k19 = 0xbc614e;
            int i20 = 0xff439eb2;
            if(l2 != l1)
            {
                i18 = (k7 - i6 << 8) / (l2 - l1);
                i19 = (k12 - k11 << 8) / (l2 - l1);
                if(l1 < l2)
                {
                    k17 = i6 << 8;
                    k18 = k11 << 8;
                    k19 = l1;
                    i20 = l2;
                } else
                {
                    k17 = k7 << 8;
                    k18 = k12 << 8;
                    k19 = l2;
                    i20 = l1;
                }
                if(k19 < 0)
                {
                    k17 -= i18 * k19;
                    k18 -= i19 * k19;
                    k19 = 0;
                }
                if(i20 > i14)
                    i20 = i14;
            }
            int k20 = 0;
            int i21 = 0;
            int k21 = 0;
            int i22 = 0;
            int j22 = 0xbc614e;
            int k22 = 0xff439eb2;
            if(l3 != l2)
            {
                i21 = (i9 - k7 << 8) / (l3 - l2);
                i22 = (i13 - k12 << 8) / (l3 - l2);
                if(l2 < l3)
                {
                    k20 = k7 << 8;
                    k21 = k12 << 8;
                    j22 = l2;
                    k22 = l3;
                } else
                {
                    k20 = i9 << 8;
                    k21 = i13 << 8;
                    j22 = l3;
                    k22 = l2;
                }
                if(j22 < 0)
                {
                    k20 -= i21 * j22;
                    k21 -= i22 * j22;
                    j22 = 0;
                }
                if(k22 > i14)
                    k22 = i14;
            }
            int l22 = 0;
            int i23 = 0;
            int j23 = 0;
            int k23 = 0;
            int l23 = 0xbc614e;
            int i24 = 0xff439eb2;
            if(l4 != l3)
            {
                i23 = (k10 - i9 << 8) / (l4 - l3);
                k23 = (k13 - i13 << 8) / (l4 - l3);
                if(l3 < l4)
                {
                    l22 = i9 << 8;
                    j23 = i13 << 8;
                    l23 = l3;
                    i24 = l4;
                } else
                {
                    l22 = k10 << 8;
                    j23 = k13 << 8;
                    l23 = l4;
                    i24 = l3;
                }
                if(l23 < 0)
                {
                    l22 -= i23 * l23;
                    j23 -= k23 * l23;
                    l23 = 0;
                }
                if(i24 > i14)
                    i24 = i14;
            }
            bga = k16;
            if(k19 < bga)
                bga = k19;
            if(j22 < bga)
                bga = j22;
            if(l23 < bga)
                bga = l23;
            bgb = i17;
            if(i20 > bgb)
                bgb = i20;
            if(k22 > bgb)
                bgb = k22;
            if(i24 > bgb)
                bgb = i24;
            int j24 = 0;
            for(k = bga; k < bgb; k++)
            {
                if(k >= k16 && k < i17)
                {
                    i = j = k14;
                    l = j24 = k15;
                    k14 += i15;
                    k15 += i16;
                } else
                {
                    i = 0xa0000;
                    j = 0xfff60000;
                }
                if(k >= k19 && k < i20)
                {
                    if(k17 < i)
                    {
                        i = k17;
                        l = k18;
                    }
                    if(k17 > j)
                    {
                        j = k17;
                        j24 = k18;
                    }
                    k17 += i18;
                    k18 += i19;
                }
                if(k >= j22 && k < k22)
                {
                    if(k20 < i)
                    {
                        i = k20;
                        l = k21;
                    }
                    if(k20 > j)
                    {
                        j = k20;
                        j24 = k21;
                    }
                    k20 += i21;
                    k21 += i22;
                }
                if(k >= l23 && k < i24)
                {
                    if(l22 < i)
                    {
                        i = l22;
                        l = j23;
                    }
                    if(l22 > j)
                    {
                        j = l22;
                        j24 = j23;
                    }
                    l22 += i23;
                    j23 += k23;
                }
                fna fna8 = bfn[k];
                fna8.fnb = i;
                fna8.fnc = j;
                fna8.fnd = l;
                fna8.fne = j24;
            }

            if(bga < bdd - bdb)
                bga = bdd - bdb;
        } else
        {
            bgb = bga = ai1[0] += bdd;
            for(k = 1; k < i1; k++)
            {
                int i2;
                if((i2 = ai1[k] += bdd) < bga)
                    bga = i2;
                else
                if(i2 > bgb)
                    bgb = i2;
            }

            if(bga < bdd - bdb)
                bga = bdd - bdb;
            if(bgb >= bdd + bdb)
                bgb = (bdd + bdb) - 1;
            if(bga >= bgb)
                return;
            for(k = bga; k < bgb; k++)
            {
                fna fna1 = bfn[k];
                fna1.fnb = 0xa0000;
                fna1.fnc = 0xfff60000;
            }

            int j2 = i1 - 1;
            int i3 = ai1[0];
            int i4 = ai1[j2];
            if(i3 < i4)
            {
                int i5 = ai[0] << 8;
                int j6 = (ai[j2] - ai[0] << 8) / (i4 - i3);
                int l7 = ai2[0] << 8;
                int j9 = (ai2[j2] - ai2[0] << 8) / (i4 - i3);
                if(i3 < 0)
                {
                    i5 -= j6 * i3;
                    l7 -= j9 * i3;
                    i3 = 0;
                }
                if(i4 > bgb)
                    i4 = bgb;
                for(k = i3; k <= i4; k++)
                {
                    fna fna3 = bfn[k];
                    fna3.fnb = fna3.fnc = i5;
                    fna3.fnd = fna3.fne = l7;
                    i5 += j6;
                    l7 += j9;
                }

            } else
            if(i3 > i4)
            {
                int j5 = ai[j2] << 8;
                int k6 = (ai[0] - ai[j2] << 8) / (i3 - i4);
                int i8 = ai2[j2] << 8;
                int k9 = (ai2[0] - ai2[j2] << 8) / (i3 - i4);
                if(i4 < 0)
                {
                    j5 -= k6 * i4;
                    i8 -= k9 * i4;
                    i4 = 0;
                }
                if(i3 > bgb)
                    i3 = bgb;
                for(k = i4; k <= i3; k++)
                {
                    fna fna4 = bfn[k];
                    fna4.fnb = fna4.fnc = j5;
                    fna4.fnd = fna4.fne = i8;
                    j5 += k6;
                    i8 += k9;
                }

            }
            for(k = 0; k < j2; k++)
            {
                int k5 = k + 1;
                int j3 = ai1[k];
                int j4 = ai1[k5];
                if(j3 < j4)
                {
                    int l6 = ai[k] << 8;
                    int j8 = (ai[k5] - ai[k] << 8) / (j4 - j3);
                    int l9 = ai2[k] << 8;
                    int l10 = (ai2[k5] - ai2[k] << 8) / (j4 - j3);
                    if(j3 < 0)
                    {
                        l6 -= j8 * j3;
                        l9 -= l10 * j3;
                        j3 = 0;
                    }
                    if(j4 > bgb)
                        j4 = bgb;
                    for(int l11 = j3; l11 <= j4; l11++)
                    {
                        fna fna5 = bfn[l11];
                        if(l6 < fna5.fnb)
                        {
                            fna5.fnb = l6;
                            fna5.fnd = l9;
                        }
                        if(l6 > fna5.fnc)
                        {
                            fna5.fnc = l6;
                            fna5.fne = l9;
                        }
                        l6 += j8;
                        l9 += l10;
                    }

                } else
                if(j3 > j4)
                {
                    int i7 = ai[k5] << 8;
                    int k8 = (ai[k] - ai[k5] << 8) / (j3 - j4);
                    int i10 = ai2[k5] << 8;
                    int i11 = (ai2[k] - ai2[k5] << 8) / (j3 - j4);
                    if(j4 < 0)
                    {
                        i7 -= k8 * j4;
                        i10 -= i11 * j4;
                        j4 = 0;
                    }
                    if(j3 > bgb)
                        j3 = bgb;
                    for(int i12 = j4; i12 <= j3; i12++)
                    {
                        fna fna6 = bfn[i12];
                        if(i7 < fna6.fnb)
                        {
                            fna6.fnb = i7;
                            fna6.fnd = i10;
                        }
                        if(i7 > fna6.fnc)
                        {
                            fna6.fnc = i7;
                            fna6.fne = i10;
                        }
                        i7 += k8;
                        i10 += i11;
                    }

                }
            }

            if(bga < bdd - bdb)
                bga = bdd - bdb;
        }
        if(bcg && bcj < bck && bci >= bga && bci < bgb)
        {
            fna fna2 = bfn[bci];
            if(bch >= fna2.fnb >> 8 && bch <= fna2.fnc >> 8 && fna2.fnb <= fna2.fnc && !cgc1.cim && cgc1.cii[j1] == 0)
            {
                bcl[bcj] = cgc1;
                bcm[bcj] = j1;
                bcj++;
            }
        }
    }

    private void bii(int i, int j, int k, int ai[], int ai1[], int ai2[], int l, 
            cgc cgc1)
    {
        boolean flag = false;
        if(l == -2)
            return;
        if(l >= 0)
        {
            if(l >= ben)
                l = 0;
            bjl(l);
            int i1 = ai[0];
            int k1 = ai1[0];
            int j2 = ai2[0];
            int i3 = i1 - ai[1];
            int k3 = k1 - ai1[1];
            int i4 = j2 - ai2[1];
            k--;
            int k5 = ai[k] - i1;
            int k6 = ai1[k] - k1;
            int k7 = ai2[k] - j2;
            if(bfc[l] == 1)
            {
                int k8 = k5 * k1 - k6 * i1 << 12;
                int j9 = k6 * j2 - k7 * k1 << (5 - bde) + 7 + 4;
                int l9 = k7 * i1 - k5 * j2 << (5 - bde) + 7;
                int j10 = i3 * k1 - k3 * i1 << 12;
                int l10 = k3 * j2 - i4 * k1 << (5 - bde) + 7 + 4;
                int j11 = i4 * i1 - i3 * j2 << (5 - bde) + 7;
                int l11 = k3 * k5 - i3 * k6 << 5;
                int j12 = i4 * k6 - k3 * k7 << (5 - bde) + 4;
                int l12 = i3 * k7 - i4 * k5 >> bde - 5;
                int j13 = j9 >> 4;
                int l13 = l10 >> 4;
                int j14 = j12 >> 4;
                int l14 = bga - bdd;
                int j15 = bcn;
                int l15 = bdc + bga * j15;
                byte byte1 = 1;
                k8 += l9 * l14;
                j10 += j11 * l14;
                l11 += l12 * l14;
                if(bgi)
                {
                    if((bga & 1) == 1)
                    {
                        bga++;
                        k8 += l9;
                        j10 += j11;
                        l11 += l12;
                        l15 += j15;
                    }
                    l9 <<= 1;
                    j11 <<= 1;
                    l12 <<= 1;
                    j15 <<= 1;
                    byte1 = 2;
                }
                if(!bff[l])
                {
                    for(i = bga; i < bgb; i += byte1)
                    {
                        fna fna3 = bfn[i];
                        j = fna3.fnb >> 8;
                        int j16 = fna3.fnc >> 8;
                        int j18 = j16 - j;
                        if(j18 <= 0)
                        {
                            k8 += l9;
                            j10 += j11;
                            l11 += l12;
                            l15 += j15;
                        } else
                        {
                            int j19 = fna3.fnd;
                            int j20 = (fna3.fne - j19) / j18;
                            if(j < -bda)
                            {
                                j19 += (-bda - j) * j20;
                                j = -bda;
                                j18 = j16 - j;
                            }
                            if(j16 > bda)
                            {
                                int k16 = bda;
                                j18 = k16 - j;
                            }
                            bij(bfm, bfe[l], 0, 0, k8 + j13 * j, j10 + l13 * j, l11 + j14 * j, j9, l10, j12, j18, l15 + j, j19, j20 << 2);
                            k8 += l9;
                            j10 += j11;
                            l11 += l12;
                            l15 += j15;
                        }
                    }

                    return;
                }
                for(i = bga; i < bgb; i += byte1)
                {
                    fna fna4 = bfn[i];
                    j = fna4.fnb >> 8;
                    int l16 = fna4.fnc >> 8;
                    int k18 = l16 - j;
                    if(k18 <= 0)
                    {
                        k8 += l9;
                        j10 += j11;
                        l11 += l12;
                        l15 += j15;
                    } else
                    {
                        int k19 = fna4.fnd;
                        int k20 = (fna4.fne - k19) / k18;
                        if(j < -bda)
                        {
                            k19 += (-bda - j) * k20;
                            j = -bda;
                            k18 = l16 - j;
                        }
                        if(l16 > bda)
                        {
                            int i17 = bda;
                            k18 = i17 - j;
                        }
                        bil(bfm, 0, 0, 0, bfe[l], k8 + j13 * j, j10 + l13 * j, l11 + j14 * j, j9, l10, j12, k18, l15 + j, k19, k20);
                        k8 += l9;
                        j10 += j11;
                        l11 += l12;
                        l15 += j15;
                    }
                }

                return;
            }
            int l8 = k5 * k1 - k6 * i1 << 11;
            int k9 = k6 * j2 - k7 * k1 << (5 - bde) + 6 + 4;
            int i10 = k7 * i1 - k5 * j2 << (5 - bde) + 6;
            int k10 = i3 * k1 - k3 * i1 << 11;
            int i11 = k3 * j2 - i4 * k1 << (5 - bde) + 6 + 4;
            int k11 = i4 * i1 - i3 * j2 << (5 - bde) + 6;
            int i12 = k3 * k5 - i3 * k6 << 5;
            int k12 = i4 * k6 - k3 * k7 << (5 - bde) + 4;
            int i13 = i3 * k7 - i4 * k5 >> bde - 5;
            int k13 = k9 >> 4;
            int i14 = i11 >> 4;
            int k14 = k12 >> 4;
            int i15 = bga - bdd;
            int k15 = bcn;
            int i16 = bdc + bga * k15;
            byte byte2 = 1;
            l8 += i10 * i15;
            k10 += k11 * i15;
            i12 += i13 * i15;
            if(bgi)
            {
                if((bga & 1) == 1)
                {
                    bga++;
                    l8 += i10;
                    k10 += k11;
                    i12 += i13;
                    i16 += k15;
                }
                i10 <<= 1;
                k11 <<= 1;
                i13 <<= 1;
                k15 <<= 1;
                byte2 = 2;
            }
            if(!bff[l])
            {
                for(i = bga; i < bgb; i += byte2)
                {
                    fna fna5 = bfn[i];
                    j = fna5.fnb >> 8;
                    int j17 = fna5.fnc >> 8;
                    int l18 = j17 - j;
                    if(l18 <= 0)
                    {
                        l8 += i10;
                        k10 += k11;
                        i12 += i13;
                        i16 += k15;
                    } else
                    {
                        int l19 = fna5.fnd;
                        int l20 = (fna5.fne - l19) / l18;
                        if(j < -bda)
                        {
                            l19 += (-bda - j) * l20;
                            j = -bda;
                            l18 = j17 - j;
                        }
                        if(j17 > bda)
                        {
                            int k17 = bda;
                            l18 = k17 - j;
                        }
                        bim(bfm, bfe[l], 0, 0, l8 + k13 * j, k10 + i14 * j, i12 + k14 * j, k9, i11, k12, l18, i16 + j, l19, l20);
                        l8 += i10;
                        k10 += k11;
                        i12 += i13;
                        i16 += k15;
                    }
                }

                return;
            }
            for(i = bga; i < bgb; i += byte2)
            {
                fna fna6 = bfn[i];
                j = fna6.fnb >> 8;
                int l17 = fna6.fnc >> 8;
                int i19 = l17 - j;
                if(i19 <= 0)
                {
                    l8 += i10;
                    k10 += k11;
                    i12 += i13;
                    i16 += k15;
                } else
                {
                    int i20 = fna6.fnd;
                    int i21 = (fna6.fne - i20) / i19;
                    if(j < -bda)
                    {
                        i20 += (-bda - j) * i21;
                        j = -bda;
                        i19 = l17 - j;
                    }
                    if(l17 > bda)
                    {
                        int i18 = bda;
                        i19 = i18 - j;
                    }
                    bja(bfm, 0, 0, 0, bfe[l], l8 + k13 * j, k10 + i14 * j, i12 + k14 * j, k9, i11, k12, i19, i16 + j, i20, i21);
                    l8 += i10;
                    k10 += k11;
                    i12 += i13;
                    i16 += k15;
                }
            }

            return;
        }
        for(int j1 = 0; j1 < bbf; j1++)
        {
            if(bbg[j1] == l)
            {
                bbi = bbh[j1];
                break;
            }
            if(j1 == bbf - 1)
            {
                int l1 = (int)(Math.random() * (double)bbf);
                bbg[l1] = l;
                l = -1 - l;
                int k2 = (l >> 10 & 0x1f) * 8;
                int j3 = (l >> 5 & 0x1f) * 8;
                int l3 = (l & 0x1f) * 8;
                for(int j4 = 0; j4 < 256; j4++)
                {
                    int l5 = j4 * j4;
                    int l6 = (k2 * l5) / 0x10000;
                    int l7 = (j3 * l5) / 0x10000;
                    int i9 = (l3 * l5) / 0x10000;
                    bbh[l1][255 - j4] = (l6 << 16) + (l7 << 8) + i9;
                }

                bbi = bbh[l1];
            }
        }

        int i2 = bcn;
        int l2 = bdc + bga * i2;
        byte byte0 = 1;
        if(bgi)
        {
            if((bga & 1) == 1)
            {
                bga++;
                l2 += i2;
            }
            i2 <<= 1;
            byte0 = 2;
        }
        if(cgc1.cif)
        {
            for(i = bga; i < bgb; i += byte0)
            {
                fna fna1 = bfn[i];
                j = fna1.fnb >> 8;
                int k4 = fna1.fnc >> 8;
                int i6 = k4 - j;
                if(i6 <= 0)
                {
                    l2 += i2;
                } else
                {
                    int i7 = fna1.fnd;
                    int i8 = (fna1.fne - i7) / i6;
                    if(j < -bda)
                    {
                        i7 += (-bda - j) * i8;
                        j = -bda;
                        i6 = k4 - j;
                    }
                    if(k4 > bda)
                    {
                        int l4 = bda;
                        i6 = l4 - j;
                    }
                    bjc(bfm, -i6, l2 + j, 0, bbi, i7, i8);
                    l2 += i2;
                }
            }

            return;
        }
        for(i = bga; i < bgb; i += byte0)
        {
            fna fna2 = bfn[i];
            j = fna2.fnb >> 8;
            int i5 = fna2.fnc >> 8;
            int j6 = i5 - j;
            if(j6 <= 0)
            {
                l2 += i2;
            } else
            {
                int j7 = fna2.fnd;
                int j8 = (fna2.fne - j7) / j6;
                if(j < -bda)
                {
                    j7 += (-bda - j) * j8;
                    j = -bda;
                    j6 = i5 - j;
                }
                if(i5 > bda)
                {
                    int j5 = bda;
                    j6 = j5 - j;
                }
                bjd(bfm, -j6, l2 + j, 0, bbi, j7, j8);
                l2 += i2;
            }
        }

    }

    private static void bij(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        boolean flag = false;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        int i4 = 0;
        if(i1 != 0)
        {
            i = k / i1 << 7;
            j = l / i1 << 7;
        }
        if(i < 0)
            i = 0;
        else
        if(i > 16256)
            i = 16256;
        k += j1;
        l += k1;
        i1 += l1;
        if(i1 != 0)
        {
            i3 = k / i1 << 7;
            j3 = l / i1 << 7;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 16256)
            i3 = 16256;
        int k3 = i3 - i >> 4;
        int l3 = j3 - j >> 4;
        for(int j4 = i2 >> 4; j4 > 0; j4--)
        {
            i += k2 & 0x600000;
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i = i3;
            j = j3;
            k += j1;
            l += k1;
            i1 += l1;
            if(i1 != 0)
            {
                i3 = k / i1 << 7;
                j3 = l / i1 << 7;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 16256)
                i3 = 16256;
            k3 = i3 - i >> 4;
            l3 = j3 - j >> 4;
        }

        for(int k4 = 0; k4 < (i2 & 0xf); k4++)
        {
            if((k4 & 3) == 0)
            {
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
            }
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
        }

    }

    private static void bik(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int i3;
        int j3;
        int i4;
        int l4;
label0:
        {
            l4 = blm.cam;
            if(i2 <= 0)
                return;
            i3 = 0;
            j3 = 0;
            i4 = 0;
            if(i1 != 0)
            {
                i = k / i1 << 7;
                j = l / i1 << 7;
            }
            if(i < 0)
            {
                i = 0;
                if(l4 == 0)
                    break label0;
            }
            if(i > 16256)
                i = 16256;
        }
label1:
        {
            k += j1;
            l += k1;
            i1 += l1;
            if(i1 != 0)
            {
                i3 = k / i1 << 7;
                j3 = l / i1 << 7;
            }
            if(i3 < 0)
            {
                i3 = 0;
                if(l4 == 0)
                    break label1;
            }
            if(i3 > 16256)
                i3 = 16256;
        }
        int k3 = i3 - i >> 4;
        int l3 = j3 - j >> 4;
        for(int j4 = i2 >> 4; j4 > 0; j4--)
        {
label2:
            {
                i += k2 & 0x600000;
                i4 = k2 >> 23;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
                i = i3;
                j = j3;
                k += j1;
                l += k1;
                i1 += l1;
                if(i1 != 0)
                {
                    i3 = k / i1 << 7;
                    j3 = l / i1 << 7;
                }
                if(i3 < 0)
                {
                    i3 = 0;
                    if(l4 == 0)
                        break label2;
                }
                if(i3 > 16256)
                    i3 = 16256;
            }
            k3 = i3 - i >> 4;
            l3 = j3 - j >> 4;
        }

        for(int k4 = 0; k4 < (i2 & 0xf); k4++)
        {
            if((k4 & 3) == 0)
            {
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
            }
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
        }

    }

    private static void bil(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        boolean flag = false;
        if(j2 <= 0)
            return;
        int j3 = 0;
        int k3 = 0;
        i3 <<= 2;
        if(j1 != 0)
        {
            j3 = l / j1 << 7;
            k3 = i1 / j1 << 7;
        }
        if(j3 < 0)
            j3 = 0;
        else
        if(j3 > 16256)
            j3 = 16256;
        for(int j4 = j2; j4 > 0; j4 -= 16)
        {
            l += k1;
            i1 += l1;
            j1 += i2;
            j = j3;
            k = k3;
            if(j1 != 0)
            {
                j3 = l / j1 << 7;
                k3 = i1 / j1 << 7;
            }
            if(j3 < 0)
                j3 = 0;
            else
            if(j3 > 16256)
                j3 = 16256;
            int l3 = j3 - j >> 4;
            int i4 = k3 - k >> 4;
            int k4 = l2 >> 23;
            j += l2 & 0x600000;
            l2 += i3;
            if(j4 < 16)
            {
                for(int l4 = 0; l4 < j4; l4++)
                {
                    if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                        ai[k2] = i;
                    k2++;
                    j += l3;
                    k += i4;
                    if((l4 & 3) == 3)
                    {
                        j = (j & 0x3fff) + (l2 & 0x600000);
                        k4 = l2 >> 23;
                        l2 += i3;
                    }
                }

            } else
            {
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
            }
        }

    }

    private static void bim(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        boolean flag = false;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        l2 <<= 2;
        if(i1 != 0)
        {
            i3 = k / i1 << 6;
            j3 = l / i1 << 6;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 4032)
            i3 = 4032;
        for(int i4 = i2; i4 > 0; i4 -= 16)
        {
            k += j1;
            l += k1;
            i1 += l1;
            i = i3;
            j = j3;
            if(i1 != 0)
            {
                i3 = k / i1 << 6;
                j3 = l / i1 << 6;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 4032)
                i3 = 4032;
            int k3 = i3 - i >> 4;
            int l3 = j3 - j >> 4;
            int j4 = k2 >> 20;
            i += k2 & 0xc0000;
            k2 += l2;
            if(i4 < 16)
            {
                for(int k4 = 0; k4 < i4; k4++)
                {
                    ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                    i += k3;
                    j += l3;
                    if((k4 & 3) == 3)
                    {
                        i = (i & 0xfff) + (k2 & 0xc0000);
                        j4 = k2 >> 20;
                        k2 += l2;
                    }
                }

            } else
            {
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
            }
        }

    }

    private static void bin(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int i3;
        int j3;
        int l4;
label0:
        {
            l4 = blm.cam;
            if(i2 <= 0)
                return;
            i3 = 0;
            j3 = 0;
            l2 <<= 2;
            if(i1 != 0)
            {
                i3 = k / i1 << 6;
                j3 = l / i1 << 6;
            }
            if(i3 < 0)
            {
                i3 = 0;
                if(l4 == 0)
                    break label0;
            }
            if(i3 > 4032)
                i3 = 4032;
        }
        for(int i4 = i2; i4 > 0; i4 -= 16)
        {
label1:
            {
                k += j1;
                l += k1;
                i1 += l1;
                i = i3;
                j = j3;
                if(i1 != 0)
                {
                    i3 = k / i1 << 6;
                    j3 = l / i1 << 6;
                }
                if(i3 < 0)
                {
                    i3 = 0;
                    if(l4 == 0)
                        break label1;
                }
                if(i3 > 4032)
                    i3 = 4032;
            }
            int k3 = i3 - i >> 4;
            int l3 = j3 - j >> 4;
            int j4 = k2 >> 20;
            i += k2 & 0xc0000;
            k2 += l2;
            if(i4 < 16)
            {
                for(int k4 = 0; k4 < i4; k4++)
                {
                    ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                    i += k3;
                    j += l3;
                    if((k4 & 3) == 3)
                    {
                        i = (i & 0xfff) + (k2 & 0xc0000);
                        j4 = k2 >> 20;
                        k2 += l2;
                    }
                }

                if(l4 == 0)
                    continue;
            }
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0xfff) + (k2 & 0xc0000);
            j4 = k2 >> 20;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0xfff) + (k2 & 0xc0000);
            j4 = k2 >> 20;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0xfff) + (k2 & 0xc0000);
            j4 = k2 >> 20;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
        }

    }

    private static void bja(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        boolean flag = false;
        if(j2 <= 0)
            return;
        int j3 = 0;
        int k3 = 0;
        i3 <<= 2;
        if(j1 != 0)
        {
            j3 = l / j1 << 6;
            k3 = i1 / j1 << 6;
        }
        if(j3 < 0)
            j3 = 0;
        else
        if(j3 > 4032)
            j3 = 4032;
        for(int j4 = j2; j4 > 0; j4 -= 16)
        {
            l += k1;
            i1 += l1;
            j1 += i2;
            j = j3;
            k = k3;
            if(j1 != 0)
            {
                j3 = l / j1 << 6;
                k3 = i1 / j1 << 6;
            }
            if(j3 < 0)
                j3 = 0;
            else
            if(j3 > 4032)
                j3 = 4032;
            int l3 = j3 - j >> 4;
            int i4 = k3 - k >> 4;
            int k4 = l2 >> 20;
            j += l2 & 0xc0000;
            l2 += i3;
            if(j4 < 16)
            {
                for(int l4 = 0; l4 < j4; l4++)
                {
                    if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                        ai[k2] = i;
                    k2++;
                    j += l3;
                    k += i4;
                    if((l4 & 3) == 3)
                    {
                        j = (j & 0xfff) + (l2 & 0xc0000);
                        k4 = l2 >> 20;
                        l2 += i3;
                    }
                }

            } else
            {
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
            }
        }

    }

    private static void bjb(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        int i2 = blm.cam;
        if(i >= 0)
            return;
        i1 <<= 1;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 8;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 8);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k;
            if((l1 & 1) == 1)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
            }
        }

    }

    private static void bjc(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        boolean flag = false;
        if(i >= 0)
            return;
        i1 <<= 2;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 16;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 16);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            if((l1 & 3) == 3)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
                l += i1;
            }
        }

    }

    private static void bjd(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        boolean flag = false;
        if(i >= 0)
            return;
        i1 <<= 2;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 16;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 16);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k;
            if((l1 & 3) == 3)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
            }
        }

    }

    public void bje(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        l &= 0x3ff;
        i1 &= 0x3ff;
        j1 &= 0x3ff;
        bdj = 1024 - l & 0x3ff;
        bdk = 1024 - i1 & 0x3ff;
        bdl = 1024 - j1 & 0x3ff;
        int l1 = 0;
        int i2 = 0;
        int j2 = k1;
        if(l != 0)
        {
            int k2 = bcb[l];
            int j3 = bcb[l + 1024];
            int i4 = 0 * j3 - j2 * k2 >> 15;
            j2 = 0 * k2 + j2 * j3 >> 15;
            i2 = i4;
        }
        if(i1 != 0)
        {
            int l2 = bcb[i1];
            int k3 = bcb[i1 + 1024];
            int j4 = j2 * l2 + 0 * k3 >> 15;
            j2 = j2 * k3 - 0 * l2 >> 15;
            l1 = j4;
        }
        if(j1 != 0)
        {
            int i3 = bcb[j1];
            int l3 = bcb[j1 + 1024];
            int k4 = i2 * i3 + l1 * l3 >> 15;
            i2 = i2 * l3 - l1 * i3 >> 15;
            l1 = k4;
        }
        bdg = i - l1;
        bdh = j - i2;
        bdi = k - j2;
    }

    private void bjf(int i)
    {
        boolean flag = false;
        bki bki1 = bed[i];
        cgc cgc1 = bki1.blb;
        int j = bki1.blc;
        int ai[] = cgc1.cgn[j];
        int k = cgc1.cgm[j];
        int l = cgc1.chd[j];
        int j1 = cgc1.cge[ai[0]];
        int k1 = cgc1.cgf[ai[0]];
        int l1 = cgc1.cgg[ai[0]];
        int i2 = cgc1.cge[ai[1]] - j1;
        int j2 = cgc1.cgf[ai[1]] - k1;
        int k2 = cgc1.cgg[ai[1]] - l1;
        int l2 = cgc1.cge[ai[2]] - j1;
        int i3 = cgc1.cgf[ai[2]] - k1;
        int j3 = cgc1.cgg[ai[2]] - l1;
        int k3 = j2 * j3 - i3 * k2;
        int l3 = k2 * l2 - j3 * i2;
        int i4 = i2 * i3 - l2 * j2;
        if(l == -1)
        {
            l = 0;
            for(; k3 > 25000 || l3 > 25000 || i4 > 25000 || k3 < -25000 || l3 < -25000 || i4 < -25000; i4 >>= 1)
            {
                l++;
                k3 >>= 1;
                l3 >>= 1;
            }

            cgc1.chd[j] = l;
            cgc1.chc[j] = (int)((double)bdf * Math.sqrt(k3 * k3 + l3 * l3 + i4 * i4));
        } else
        {
            k3 >>= l;
            l3 >>= l;
            i4 >>= l;
        }
        bki1.blh = j1 * k3 + k1 * l3 + l1 * i4;
        bki1.ble = k3;
        bki1.blf = l3;
        bki1.blg = i4;
        int j4 = cgc1.cgg[ai[0]];
        int k4 = j4;
        int l4 = cgc1.cgh[ai[0]];
        int i5 = l4;
        int j5 = cgc1.cgi[ai[0]];
        int k5 = j5;
        for(int l5 = 1; l5 < k; l5++)
        {
            int i1 = cgc1.cgg[ai[l5]];
            if(i1 > k4)
                k4 = i1;
            else
            if(i1 < j4)
                j4 = i1;
            i1 = cgc1.cgh[ai[l5]];
            if(i1 > i5)
                i5 = i1;
            else
            if(i1 < l4)
                l4 = i1;
            i1 = cgc1.cgi[ai[l5]];
            if(i1 > k5)
                k5 = i1;
            else
            if(i1 < j5)
                j5 = i1;
        }

        bki1.bkn = j4;
        bki1.bla = k4;
        bki1.bkj = l4;
        bki1.bkl = i5;
        bki1.bkk = j5;
        bki1.bkm = k5;
    }

    private void bjg(int i)
    {
        boolean flag3 = false;
        bki bki1 = bed[i];
        cgc cgc1 = bki1.blb;
        int j = bki1.blc;
        int ai[] = cgc1.cgn[j];
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = true;
        int l = cgc1.cge[ai[0]];
        int i1 = cgc1.cgf[ai[0]];
        int j1 = cgc1.cgg[ai[0]];
        cgc1.chc[j] = 1;
        cgc1.chd[j] = 0;
        bki1.blh = l * 0 + i1 * 0 + j1 * 1;
        bki1.ble = 0;
        bki1.blf = 0;
        bki1.blg = 1;
        int k1 = cgc1.cgg[ai[0]];
        int l1 = k1;
        int i2 = cgc1.cgh[ai[0]];
        int j2 = i2;
        if(cgc1.cgh[ai[1]] < i2)
            i2 = cgc1.cgh[ai[1]];
        else
            j2 = cgc1.cgh[ai[1]];
        int k2 = cgc1.cgi[ai[1]];
        int l2 = cgc1.cgi[ai[0]];
        int k = cgc1.cgg[ai[1]];
        if(k > l1)
            l1 = k;
        else
        if(k < k1)
            k1 = k;
        k = cgc1.cgh[ai[1]];
        if(k > j2)
            j2 = k;
        else
        if(k < i2)
            i2 = k;
        k = cgc1.cgi[ai[1]];
        if(k > l2)
            l2 = k;
        else
        if(k < k2)
            k2 = k;
        bki1.bkn = k1;
        bki1.bla = l1;
        bki1.bkj = i2 - 20;
        bki1.bkl = j2 + 20;
        bki1.bkk = k2;
        bki1.bkm = l2;
    }

    private boolean bjh(bki bki1, bki bki2)
    {
        boolean flag1 = false;
        if(bki1.bkj >= bki2.bkl)
            return true;
        if(bki2.bkj >= bki1.bkl)
            return true;
        if(bki1.bkk >= bki2.bkm)
            return true;
        if(bki2.bkk >= bki1.bkm)
            return true;
        if(bki1.bkn >= bki2.bla)
            return true;
        if(bki2.bkn > bki1.bla)
            return false;
        cgc cgc1 = bki1.blb;
        cgc cgc2 = bki2.blb;
        int i = bki1.blc;
        int j = bki2.blc;
        int ai[] = cgc1.cgn[i];
        int ai1[] = cgc2.cgn[j];
        int k = cgc1.cgm[i];
        int l = cgc2.cgm[j];
        int k2 = cgc2.cge[ai1[0]];
        int l2 = cgc2.cgf[ai1[0]];
        int i3 = cgc2.cgg[ai1[0]];
        int j3 = bki2.ble;
        int k3 = bki2.blf;
        int l3 = bki2.blg;
        int i4 = cgc2.chc[j];
        int j4 = bki2.blh;
        boolean flag = false;
        for(int k4 = 0; k4 < k; k4++)
        {
            int i1 = ai[k4];
            int i2 = (k2 - cgc1.cge[i1]) * j3 + (l2 - cgc1.cgf[i1]) * k3 + (i3 - cgc1.cgg[i1]) * l3;
            if((i2 >= -i4 || j4 >= 0) && (i2 <= i4 || j4 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        k2 = cgc1.cge[ai[0]];
        l2 = cgc1.cgf[ai[0]];
        i3 = cgc1.cgg[ai[0]];
        j3 = bki1.ble;
        k3 = bki1.blf;
        l3 = bki1.blg;
        i4 = cgc1.chc[i];
        j4 = bki1.blh;
        flag = false;
        for(int l4 = 0; l4 < l; l4++)
        {
            int j1 = ai1[l4];
            int j2 = (k2 - cgc2.cge[j1]) * j3 + (l2 - cgc2.cgf[j1]) * k3 + (i3 - cgc2.cgg[j1]) * l3;
            if((j2 >= -i4 || j4 <= 0) && (j2 <= i4 || j4 >= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        int ai2[];
        int ai3[];
        if(k == 2)
        {
            ai2 = new int[4];
            ai3 = new int[4];
            int i5 = ai[0];
            int k1 = ai[1];
            ai2[0] = cgc1.cgh[i5] - 20;
            ai2[1] = cgc1.cgh[k1] - 20;
            ai2[2] = cgc1.cgh[k1] + 20;
            ai2[3] = cgc1.cgh[i5] + 20;
            ai3[0] = ai3[3] = cgc1.cgi[i5];
            ai3[1] = ai3[2] = cgc1.cgi[k1];
        } else
        {
            ai2 = new int[k];
            ai3 = new int[k];
            for(int j5 = 0; j5 < k; j5++)
            {
                int i6 = ai[j5];
                ai2[j5] = cgc1.cgh[i6];
                ai3[j5] = cgc1.cgi[i6];
            }

        }
        int ai4[];
        int ai5[];
        if(l == 2)
        {
            ai4 = new int[4];
            ai5 = new int[4];
            int k5 = ai1[0];
            int l1 = ai1[1];
            ai4[0] = cgc2.cgh[k5] - 20;
            ai4[1] = cgc2.cgh[l1] - 20;
            ai4[2] = cgc2.cgh[l1] + 20;
            ai4[3] = cgc2.cgh[k5] + 20;
            ai5[0] = ai5[3] = cgc2.cgi[k5];
            ai5[1] = ai5[2] = cgc2.cgi[l1];
        } else
        {
            ai4 = new int[l];
            ai5 = new int[l];
            for(int l5 = 0; l5 < l; l5++)
            {
                int j6 = ai1[l5];
                ai4[l5] = cgc2.cgh[j6];
                ai5[l5] = cgc2.cgi[j6];
            }

        }
        return !bkh(ai2, ai3, ai4, ai5);
    }

    private boolean bji(bki bki1, bki bki2)
    {
        boolean flag1 = false;
        cgc cgc1 = bki1.blb;
        cgc cgc2 = bki2.blb;
        int i = bki1.blc;
        int j = bki2.blc;
        int ai[] = cgc1.cgn[i];
        int ai1[] = cgc2.cgn[j];
        int k = cgc1.cgm[i];
        int l = cgc2.cgm[j];
        int i2 = cgc2.cge[ai1[0]];
        int j2 = cgc2.cgf[ai1[0]];
        int k2 = cgc2.cgg[ai1[0]];
        int l2 = bki2.ble;
        int i3 = bki2.blf;
        int j3 = bki2.blg;
        int k3 = cgc2.chc[j];
        int l3 = bki2.blh;
        boolean flag = false;
        for(int i4 = 0; i4 < k; i4++)
        {
            int i1 = ai[i4];
            int k1 = (i2 - cgc1.cge[i1]) * l2 + (j2 - cgc1.cgf[i1]) * i3 + (k2 - cgc1.cgg[i1]) * j3;
            if((k1 >= -k3 || l3 >= 0) && (k1 <= k3 || l3 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        i2 = cgc1.cge[ai[0]];
        j2 = cgc1.cgf[ai[0]];
        k2 = cgc1.cgg[ai[0]];
        l2 = bki1.ble;
        i3 = bki1.blf;
        j3 = bki1.blg;
        k3 = cgc1.chc[i];
        l3 = bki1.blh;
        flag = false;
        for(int j4 = 0; j4 < l; j4++)
        {
            int j1 = ai1[j4];
            int l1 = (i2 - cgc2.cge[j1]) * l2 + (j2 - cgc2.cgf[j1]) * i3 + (k2 - cgc2.cgg[j1]) * j3;
            if((l1 >= -k3 || l3 <= 0) && (l1 <= k3 || l3 >= 0))
                continue;
            flag = true;
            break;
        }

        return !flag;
    }

    public void bjj(int i, int j, int k)
    {
        ben = i;
        bfa = new byte[i][];
        bfb = new int[i][];
        bfc = new int[i];
        bfd = new long[i];
        bff = new boolean[i];
        bfe = new int[i][];
        bfg = 0L;
        bfh = new int[j][];
        bfi = new int[k][];
    }

    public void bjk(int i, byte abyte0[], int ai[], int j)
    {
        bfa[i] = abyte0;
        bfb[i] = ai;
        bfc[i] = j;
        bfd[i] = 0L;
        bff[i] = false;
        bfe[i] = null;
        bjl(i);
    }

    public void bjl(int i)
    {
        boolean flag = false;
        if(i < 0)
            return;
        bfd[i] = bfg++;
        if(bfe[i] != null)
            return;
        if(bfc[i] == 0)
        {
            for(int j = 0; j < bfh.length; j++)
                if(bfh[j] == null)
                {
                    bfh[j] = new int[16384];
                    bfe[i] = bfh[j];
                    bjm(i);
                    return;
                }

            long l = 0x40000000L;
            int i1 = 0;
            for(int k1 = 0; k1 < ben; k1++)
                if(k1 != i && bfc[k1] == 0 && bfe[k1] != null && bfd[k1] < l)
                {
                    l = bfd[k1];
                    i1 = k1;
                }

            bfe[i] = bfe[i1];
            bfe[i1] = null;
            bjm(i);
            return;
        }
        for(int k = 0; k < bfi.length; k++)
            if(bfi[k] == null)
            {
                bfi[k] = new int[0x10000];
                bfe[i] = bfi[k];
                bjm(i);
                return;
            }

        long l1 = 0x40000000L;
        int j1 = 0;
        for(int i2 = 0; i2 < ben; i2++)
            if(i2 != i && bfc[i2] == 1 && bfe[i2] != null && bfd[i2] < l1)
            {
                l1 = bfd[i2];
                j1 = i2;
            }

        bfe[i] = bfe[j1];
        bfe[j1] = null;
        bjm(i);
    }

    private void bjm(int i)
    {
        boolean flag = false;
        char c;
        if(bfc[i] == 0)
            c = '@';
        else
            c = '\200';
        int ai[] = bfe[i];
        int j = 0;
        for(int k = 0; k < c; k++)
        {
            for(int l = 0; l < c; l++)
            {
                int j1 = bfb[i][bfa[i][l + k * c] & 0xff];
                j1 &= 0xf8f8ff;
                if(j1 == 0)
                    j1 = 1;
                else
                if(j1 == 0xf800ff)
                {
                    j1 = 0;
                    bff[i] = true;
                }
                ai[j++] = j1;
            }

        }

        for(int i1 = 0; i1 < j; i1++)
        {
            int k1 = ai[i1];
            ai[j + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
            ai[j * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
            ai[j * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
        }

    }

    public void bjn(int i)
    {
        boolean flag = false;
        if(bfe[i] == null)
            return;
        int ai[] = bfe[i];
        for(int j = 0; j < 64; j++)
        {
            int k = j + 4032;
            int l = ai[k];
            for(int j1 = 0; j1 < 63; j1++)
            {
                ai[k] = ai[k - 64];
                k -= 64;
            }

            bfe[i][k] = l;
        }

        char c = '\u1000';
        for(int i1 = 0; i1 < 4096; i1++)
        {
            int k1 = ai[i1];
            ai[4096 + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
            ai[8192 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
            ai[12288 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
        }

    }

    public int bka(int i)
    {
        if(i == 0xbc614e)
            return 0;
        bjl(i);
        if(i >= 0)
            return bfe[i][0];
        if(i < 0)
        {
            i = -(i + 1);
            int j = i >> 10 & 0x1f;
            int k = i >> 5 & 0x1f;
            int l = i & 0x1f;
            return (j << 19) + (k << 11) + (l << 3);
        } else
        {
            return 0;
        }
    }

    public void bkb(int i, int j, int k)
    {
        if(i == 0 && j == 0 && k == 0)
            i = 32;
        for(int l = 0; l < bdm; l++)
            bea[l].cnc(i, j, k);

    }

    public void bkc(int i, int j, int k, int l, int i1)
    {
        if(k == 0 && l == 0 && i1 == 0)
            k = 32;
        for(int j1 = 0; j1 < bdm; j1++)
            bea[j1].cnb(i, j, k, l, i1);

    }

    public static int bkd(int i, int j, int k)
    {
        return -1 - (i / 8) * 1024 - (j / 8) * 32 - k / 8;
    }

    public int bke(int i, int j, int k, int l, int i1)
    {
        if(l == j)
            return i;
        else
            return i + ((k - i) * (i1 - j)) / (l - j);
    }

    public boolean bkf(int i, int j, int k, int l, boolean flag)
    {
        if(flag && i <= k || i < k)
        {
            if(i > l)
                return true;
            if(j > k)
                return true;
            if(j > l)
                return true;
            return !flag;
        }
        if(i < l)
            return true;
        if(j < k)
            return true;
        if(j < l)
            return true;
        else
            return flag;
    }

    public boolean bkg(int i, int j, int k, boolean flag)
    {
        if(flag && i <= k || i < k)
        {
            if(j > k)
                return true;
            return !flag;
        }
        if(j < k)
            return true;
        else
            return flag;
    }

    public boolean bkh(int ai[], int ai1[], int ai2[], int ai3[])
    {
        boolean flag1 = false;
        int i = ai.length;
        int j = ai2.length;
        byte byte0 = 0;
        int i20;
        int k20 = i20 = ai1[0];
        int k = 0;
        int j20;
        int l20 = j20 = ai3[0];
        int i1 = 0;
        for(int i21 = 1; i21 < i; i21++)
            if(ai1[i21] < i20)
            {
                i20 = ai1[i21];
                k = i21;
            } else
            if(ai1[i21] > k20)
                k20 = ai1[i21];

        for(int j21 = 1; j21 < j; j21++)
            if(ai3[j21] < j20)
            {
                j20 = ai3[j21];
                i1 = j21;
            } else
            if(ai3[j21] > l20)
                l20 = ai3[j21];

        if(j20 >= k20)
            return false;
        if(i20 >= l20)
            return false;
        int l;
        int j1;
        boolean flag;
        if(ai1[k] < ai3[i1])
        {
            for(l = k; ai1[l] < ai3[i1]; l = (l + 1) % i);
            for(; ai1[k] < ai3[i1]; k = ((k - 1) + i) % i);
            int k1 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
            int k6 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
            int l10 = ai2[i1];
            flag = (k1 < l10) | (k6 < l10);
            if(bkg(k1, k6, l10, flag))
                return true;
            j1 = (i1 + 1) % j;
            i1 = ((i1 - 1) + j) % j;
            if(k == l)
                byte0 = 1;
        } else
        {
            for(j1 = i1; ai3[j1] < ai1[k]; j1 = (j1 + 1) % j);
            for(; ai3[i1] < ai1[k]; i1 = ((i1 - 1) + j) % j);
            int l1 = ai[k];
            int i11 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
            int l15 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
            flag = (l1 < i11) | (l1 < l15);
            if(bkg(i11, l15, l1, !flag))
                return true;
            l = (k + 1) % i;
            k = ((k - 1) + i) % i;
            if(i1 == j1)
                byte0 = 2;
        }
        while(byte0 == 0) 
            if(ai1[k] < ai1[l])
            {
                if(ai1[k] < ai3[i1])
                {
                    if(ai1[k] < ai3[j1])
                    {
                        int i2 = ai[k];
                        int l6 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
                        int j11 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                        int i16 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                        if(bkf(i2, l6, j11, i16, flag))
                            return true;
                        k = ((k - 1) + i) % i;
                        if(k == l)
                            byte0 = 1;
                    } else
                    {
                        int j2 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                        int i7 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                        int k11 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                        int j16 = ai2[j1];
                        if(bkf(j2, i7, k11, j16, flag))
                            return true;
                        j1 = (j1 + 1) % j;
                        if(i1 == j1)
                            byte0 = 2;
                    }
                } else
                if(ai3[i1] < ai3[j1])
                {
                    int k2 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                    int j7 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                    int l11 = ai2[i1];
                    int k16 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                    if(bkf(k2, j7, l11, k16, flag))
                        return true;
                    i1 = ((i1 - 1) + j) % j;
                    if(i1 == j1)
                        byte0 = 2;
                } else
                {
                    int l2 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                    int k7 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                    int i12 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                    int l16 = ai2[j1];
                    if(bkf(l2, k7, i12, l16, flag))
                        return true;
                    j1 = (j1 + 1) % j;
                    if(i1 == j1)
                        byte0 = 2;
                }
            } else
            if(ai1[l] < ai3[i1])
            {
                if(ai1[l] < ai3[j1])
                {
                    int i3 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                    int l7 = ai[l];
                    int j12 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                    int i17 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                    if(bkf(i3, l7, j12, i17, flag))
                        return true;
                    l = (l + 1) % i;
                    if(k == l)
                        byte0 = 1;
                } else
                {
                    int j3 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                    int i8 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                    int k12 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                    int j17 = ai2[j1];
                    if(bkf(j3, i8, k12, j17, flag))
                        return true;
                    j1 = (j1 + 1) % j;
                    if(i1 == j1)
                        byte0 = 2;
                }
            } else
            if(ai3[i1] < ai3[j1])
            {
                int k3 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                int j8 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                int l12 = ai2[i1];
                int k17 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                if(bkf(k3, j8, l12, k17, flag))
                    return true;
                i1 = ((i1 - 1) + j) % j;
                if(i1 == j1)
                    byte0 = 2;
            } else
            {
                int l3 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int k8 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int i13 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int l17 = ai2[j1];
                if(bkf(l3, k8, i13, l17, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 2;
            }
        while(byte0 == 1) 
            if(ai1[k] < ai3[i1])
            {
                if(ai1[k] < ai3[j1])
                {
                    int i4 = ai[k];
                    int j13 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                    int i18 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                    return bkg(j13, i18, i4, !flag);
                }
                int j4 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int l8 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int k13 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int j18 = ai2[j1];
                if(bkf(j4, l8, k13, j18, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 0;
            } else
            if(ai3[i1] < ai3[j1])
            {
                int k4 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                int i9 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                int l13 = ai2[i1];
                int k18 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                if(bkf(k4, i9, l13, k18, flag))
                    return true;
                i1 = ((i1 - 1) + j) % j;
                if(i1 == j1)
                    byte0 = 0;
            } else
            {
                int l4 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int j9 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int i14 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int l18 = ai2[j1];
                if(bkf(l4, j9, i14, l18, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 0;
            }
        while(byte0 == 2) 
            if(ai3[i1] < ai1[k])
            {
                if(ai3[i1] < ai1[l])
                {
                    int i5 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                    int k9 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                    int j14 = ai2[i1];
                    return bkg(i5, k9, j14, flag);
                }
                int j5 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                int l9 = ai[l];
                int k14 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                int i19 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                if(bkf(j5, l9, k14, i19, flag))
                    return true;
                l = (l + 1) % i;
                if(k == l)
                    byte0 = 0;
            } else
            if(ai1[k] < ai1[l])
            {
                int k5 = ai[k];
                int i10 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
                int l14 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                int j19 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                if(bkf(k5, i10, l14, j19, flag))
                    return true;
                k = ((k - 1) + i) % i;
                if(k == l)
                    byte0 = 0;
            } else
            {
                int l5 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                int j10 = ai[l];
                int i15 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                int k19 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                if(bkf(l5, j10, i15, k19, flag))
                    return true;
                l = (l + 1) % i;
                if(k == l)
                    byte0 = 0;
            }
        if(ai1[k] < ai3[i1])
        {
            int i6 = ai[k];
            int j15 = bke(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
            int l19 = bke(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
            return bkg(j15, l19, i6, !flag);
        }
        int j6 = bke(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
        int k10 = bke(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
        int k15 = ai2[i1];
        return bkg(j6, k10, k15, flag);
    }

    int bbf;
    int bbg[];
    int bbh[][];
    int bbi[];
    public int bbj;
    public int bbk;
    public int bbl;
    public int bbm;
    public int bbn;
    public int bca;
    public static int bcb[] = new int[2048];
    private static int bcc[] = new int[512];
    public boolean bcd;
    public double bce;
    public int bcf;
    private boolean bcg;
    private int bch;
    private int bci;
    private int bcj;
    private int bck;
    private cgc bcl[];
    private int bcm[];
    private int bcn;
    private int bda;
    private int bdb;
    private int bdc;
    private int bdd;
    private int bde;
    private int bdf;
    private int bdg;
    private int bdh;
    private int bdi;
    private int bdj;
    private int bdk;
    private int bdl;
    public int bdm;
    public int bdn;
    public cgc bea[];
    private int beb[];
    private int bec;
    private bki bed[];
    private int bee;
    private int bef[];
    private int beg[];
    private int beh[];
    private int bei[];
    private int bej[];
    private int bek[];
    private int bel[];
    public cgc bem;
    int ben;
    byte bfa[][];
    int bfb[][];
    int bfc[];
    long bfd[];
    int bfe[][];
    boolean bff[];
    private static long bfg;
    int bfh[][];
    int bfi[][];
    private static byte bfj[];
    private static int bfk[] = new int[256];
    blm bfl;
    public int bfm[];
    fna bfn[];
    int bga;
    int bgb;
    int bgc[];
    int bgd[];
    int bge[];
    int bgf[];
    int bgg[];
    int bgh[];
    boolean bgi;
    static int bgj;
    static int bgk;
    static int bgl;
    static int bgm;
    static int bgn;
    static int bha;
    int bhb;
    int bhc;

}
