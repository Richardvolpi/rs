// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.*;

public class cgc
{

    public cgc(int i, int j)
    {
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        cme(i, j);
        cka = new int[j][1];
        for(int k = 0; k < j; k++)
            cka[k][0] = k;

    }

    public cgc(int i, int j, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        cij = flag;
        cik = flag1;
        cil = flag2;
        cim = flag3;
        cin = flag4;
        cme(i, j);
    }

    private void cme(int i, int j)
    {
        cjh = new int[i];
        cji = new int[i];
        cjj = new int[i];
        cgj = new int[i];
        cgk = new byte[i];
        cgm = new int[j];
        cgn = new int[j][];
        cha = new int[j];
        chb = new int[j];
        che = new int[j];
        chd = new int[j];
        chc = new int[j];
        if(!cin)
        {
            cge = new int[i];
            cgf = new int[i];
            cgg = new int[i];
            cgh = new int[i];
            cgi = new int[i];
        }
        if(!cim)
        {
            cii = new byte[j];
            cih = new int[j];
        }
        if(cij)
        {
            cjk = cjh;
            cjl = cji;
            cjm = cjj;
        } else
        {
            cjk = new int[i];
            cjl = new int[i];
            cjm = new int[i];
        }
        if(!cil || !cik)
        {
            chf = new int[j];
            chg = new int[j];
            chh = new int[j];
        }
        if(!cik)
        {
            ckb = new int[j];
            ckc = new int[j];
            ckd = new int[j];
            cke = new int[j];
            ckf = new int[j];
            ckg = new int[j];
        }
        cgl = 0;
        cgd = 0;
        cjg = i;
        cjn = j;
        ckh = cki = ckj = 0;
        ckk = ckl = ckm = 0;
        ckn = cla = clb = 256;
        clc = cld = cle = clf = clg = clh = 256;
        cli = 0;
    }

    public void cmf()
    {
        cge = new int[cgd];
        cgf = new int[cgd];
        cgg = new int[cgd];
        cgh = new int[cgd];
        cgi = new int[cgd];
    }

    public void cmg()
    {
        cgl = 0;
        cgd = 0;
    }

    public void cmh(int i, int j)
    {
        cgl -= i;
        if(cgl < 0)
            cgl = 0;
        cgd -= j;
        if(cgd < 0)
            cgd = 0;
    }

    public cgc(byte abyte0[], int i, boolean flag)
    {
        super();
        boolean flag1 = false;
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        int j = fnf.fnm(abyte0, i);
        i += 2;
        int k = fnf.fnm(abyte0, i);
        i += 2;
        cme(j, k);
        cka = new int[k][1];
        for(int l = 0; l < j; l++)
        {
            cjh[l] = fnf.gab(abyte0, i);
            i += 2;
        }

        for(int i1 = 0; i1 < j; i1++)
        {
            cji[i1] = fnf.gab(abyte0, i);
            i += 2;
        }

        for(int j1 = 0; j1 < j; j1++)
        {
            cjj[j1] = fnf.gab(abyte0, i);
            i += 2;
        }

        cgd = j;
        for(int k1 = 0; k1 < k; k1++)
            cgm[k1] = abyte0[i++] & 0xff;

        for(int l1 = 0; l1 < k; l1++)
        {
            cha[l1] = fnf.gab(abyte0, i);
            i += 2;
            if(cha[l1] == 32767)
                cha[l1] = cjf;
        }

        for(int i2 = 0; i2 < k; i2++)
        {
            chb[i2] = fnf.gab(abyte0, i);
            i += 2;
            if(chb[i2] == 32767)
                chb[i2] = cjf;
        }

        for(int j2 = 0; j2 < k; j2++)
        {
            int k2 = abyte0[i++] & 0xff;
            if(k2 == 0)
                che[j2] = 0;
            else
                che[j2] = cjf;
        }

        for(int l2 = 0; l2 < k; l2++)
        {
            cgn[l2] = new int[cgm[l2]];
            for(int i3 = 0; i3 < cgm[l2]; i3++)
                if(j < 256)
                {
                    cgn[l2][i3] = abyte0[i++] & 0xff;
                } else
                {
                    cgn[l2][i3] = fnf.fnm(abyte0, i);
                    i += 2;
                }

        }

        cgl = k;
        chj = 1;
    }

    public cgc(String s)
    {
        super();
        boolean flag3 = false;
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        boolean flag = false;
        boolean flag1 = false;
        byte abyte0[] = null;
        try
        {
            java.io.InputStream inputstream = fnf.fnj(s);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            abyte0 = new byte[3];
            cmc = 0;
            cmd = 0;
            for(int i = 0; i < 3; i += datainputstream.read(abyte0, i, 3 - i));
            int k = dai(abyte0);
            abyte0 = new byte[k];
            cmc = 0;
            cmd = 0;
            for(int j = 0; j < k; j += datainputstream.read(abyte0, j, k - j));
            datainputstream.close();
        }
        catch(IOException _ex)
        {
            cgd = 0;
            cgl = 0;
            return;
        }
        int l = dai(abyte0);
        int i1 = dai(abyte0);
        boolean flag2 = false;
        cme(l, i1);
        cka = new int[i1][];
        for(int j3 = 0; j3 < l; j3++)
        {
            int j1 = dai(abyte0);
            int k1 = dai(abyte0);
            int l1 = dai(abyte0);
            cmj(j1, k1, l1);
        }

        for(int k3 = 0; k3 < i1; k3++)
        {
            int i2 = dai(abyte0);
            int j2 = dai(abyte0);
            int k2 = dai(abyte0);
            int l2 = dai(abyte0);
            cma = dai(abyte0);
            cmb = dai(abyte0);
            int i3 = dai(abyte0);
            int ai[] = new int[i2];
            for(int l3 = 0; l3 < i2; l3++)
                ai[l3] = dai(abyte0);

            int ai1[] = new int[l2];
            for(int i4 = 0; i4 < l2; i4++)
                ai1[i4] = dai(abyte0);

            int j4 = cml(i2, ai, j2, k2);
            cka[k3] = ai1;
            if(i3 == 0)
                che[j4] = 0;
            else
                che[j4] = cjf;
        }

        chj = 1;
    }

    public cgc(cgc acgc[], int i, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        cij = flag;
        cik = flag1;
        cil = flag2;
        cim = flag3;
        cmi(acgc, i, false);
    }

    public cgc(cgc acgc[], int i)
    {
        chj = 1;
        chk = true;
        cid = true;
        cie = false;
        cif = false;
        cig = -1;
        cij = false;
        cik = false;
        cil = false;
        cim = false;
        cin = false;
        cje = 4;
        cjf = 0xbc614e;
        clj = 0xbc614e;
        clk = 180;
        cll = 155;
        clm = 95;
        cln = 256;
        cma = 512;
        cmb = 32;
        cmi(acgc, i, true);
    }

    public void cmi(cgc acgc[], int i, boolean flag)
    {
        boolean flag1 = false;
        int j = 0;
        int k = 0;
        for(int l = 0; l < i; l++)
        {
            j += acgc[l].cgl;
            k += acgc[l].cgd;
        }

        cme(k, j);
        if(flag)
            cka = new int[j][];
        for(int i1 = 0; i1 < i; i1++)
        {
            cgc cgc1 = acgc[i1];
            cgc1.dae();
            cmb = cgc1.cmb;
            cma = cgc1.cma;
            clk = cgc1.clk;
            cll = cgc1.cll;
            clm = cgc1.clm;
            cln = cgc1.cln;
            for(int j1 = 0; j1 < cgc1.cgl; j1++)
            {
                int ai[] = new int[cgc1.cgm[j1]];
                int ai1[] = cgc1.cgn[j1];
                for(int k1 = 0; k1 < cgc1.cgm[j1]; k1++)
                    ai[k1] = cmj(cgc1.cjh[ai1[k1]], cgc1.cji[ai1[k1]], cgc1.cjj[ai1[k1]]);

                int l1 = cml(cgc1.cgm[j1], ai, cgc1.cha[j1], cgc1.chb[j1]);
                che[l1] = cgc1.che[j1];
                chd[l1] = cgc1.chd[j1];
                chc[l1] = cgc1.chc[j1];
                if(flag)
                    if(i > 1)
                    {
                        cka[l1] = new int[cgc1.cka[j1].length + 1];
                        cka[l1][0] = i1;
                        for(int i2 = 0; i2 < cgc1.cka[j1].length; i2++)
                            cka[l1][i2 + 1] = cgc1.cka[j1][i2];

                    } else
                    {
                        cka[l1] = new int[cgc1.cka[j1].length];
                        for(int j2 = 0; j2 < cgc1.cka[j1].length; j2++)
                            cka[l1][j2] = cgc1.cka[j1][j2];

                    }
            }

        }

        chj = 1;
    }

    public int cmj(int i, int j, int k)
    {
        for(int l = 0; l < cgd; l++)
            if(cjh[l] == i && cji[l] == j && cjj[l] == k)
                return l;

        if(cgd >= cjg)
        {
            return -1;
        } else
        {
            cjh[cgd] = i;
            cji[cgd] = j;
            cjj[cgd] = k;
            return cgd++;
        }
    }

    public int cmk(int i, int j, int k)
    {
        if(cgd >= cjg)
        {
            return -1;
        } else
        {
            cjh[cgd] = i;
            cji[cgd] = j;
            cjj[cgd] = k;
            return cgd++;
        }
    }

    public int cml(int i, int ai[], int j, int k)
    {
        if(cgl >= cjn)
        {
            return -1;
        } else
        {
            cgm[cgl] = i;
            cgn[cgl] = ai;
            cha[cgl] = j;
            chb[cgl] = k;
            chj = 1;
            return cgl++;
        }
    }

    public cgc[] cmm(int i, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag)
    {
        boolean flag1 = false;
        dae();
        int ai[] = new int[j1];
        int ai1[] = new int[j1];
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[l1] = 0;
            ai1[l1] = 0;
        }

        for(int i2 = 0; i2 < cgl; i2++)
        {
            int j2 = 0;
            int k2 = 0;
            int i3 = cgm[i2];
            int ai2[] = cgn[i2];
            for(int i4 = 0; i4 < i3; i4++)
            {
                j2 += cjh[ai2[i4]];
                k2 += cjj[ai2[i4]];
            }

            int k4 = j2 / (i3 * k) + (k2 / (i3 * l)) * i1;
            ai[k4] += i3;
            ai1[k4]++;
        }

        cgc acgc[] = new cgc[j1];
        for(int l2 = 0; l2 < j1; l2++)
        {
            if(ai[l2] > k1)
                ai[l2] = k1;
            acgc[l2] = new cgc(ai[l2], ai1[l2], true, true, true, flag, true);
            acgc[l2].cma = cma;
            acgc[l2].cmb = cmb;
        }

        for(int j3 = 0; j3 < cgl; j3++)
        {
            int k3 = 0;
            int j4 = 0;
            int l4 = cgm[j3];
            int ai3[] = cgn[j3];
            for(int i5 = 0; i5 < l4; i5++)
            {
                k3 += cjh[ai3[i5]];
                j4 += cjj[ai3[i5]];
            }

            int j5 = k3 / (l4 * k) + (j4 / (l4 * l)) * i1;
            cmn(acgc[j5], ai3, l4, j3);
        }

        for(int l3 = 0; l3 < j1; l3++)
            acgc[l3].cmf();

        return acgc;
    }

    public void cmn(cgc cgc1, int ai[], int i, int j)
    {
        int ai1[] = new int[i];
        for(int k = 0; k < i; k++)
        {
            int l = ai1[k] = cgc1.cmj(cjh[ai[k]], cji[ai[k]], cjj[ai[k]]);
            cgc1.cgj[l] = cgj[ai[k]];
            cgc1.cgk[l] = cgk[ai[k]];
        }

        int i1 = cgc1.cml(i, ai1, cha[j], chb[j]);
        if(!cgc1.cim && !cim)
            cgc1.cih[i1] = cih[j];
        cgc1.che[i1] = che[j];
        cgc1.chd[i1] = chd[j];
        cgc1.chc[i1] = chc[j];
    }

    public void cna(boolean flag, int i, int j, int k, int l, int i1)
    {
        boolean flag1 = false;
        cmb = 256 - i * 4;
        cma = (64 - j) * 16 + 128;
        if(cil)
            return;
        for(int j1 = 0; j1 < cgl; j1++)
            if(flag)
                che[j1] = cjf;
            else
                che[j1] = 0;

        clk = k;
        cll = l;
        clm = i1;
        cln = (int)Math.sqrt(k * k + l * l + i1 * i1);
        daa();
    }

    public void cnb(int i, int j, int k, int l, int i1)
    {
        cmb = 256 - i * 4;
        cma = (64 - j) * 16 + 128;
        if(cil)
        {
            return;
        } else
        {
            clk = k;
            cll = l;
            clm = i1;
            cln = (int)Math.sqrt(k * k + l * l + i1 * i1);
            daa();
            return;
        }
    }

    public void cnc(int i, int j, int k)
    {
        if(cil)
        {
            return;
        } else
        {
            clk = i;
            cll = j;
            clm = k;
            cln = (int)Math.sqrt(i * i + j * j + k * k);
            daa();
            return;
        }
    }

    public void cnd(int i, int j)
    {
        cgk[i] = (byte)j;
    }

    public void cne(int i, int j, int k)
    {
        ckk = ckk + i & 0xff;
        ckl = ckl + j & 0xff;
        ckm = ckm + k & 0xff;
        cni();
        chj = 1;
    }

    public void cnf(int i, int j, int k)
    {
        ckk = i & 0xff;
        ckl = j & 0xff;
        ckm = k & 0xff;
        cni();
        chj = 1;
    }

    public void cng(int i, int j, int k)
    {
        ckh += i;
        cki += j;
        ckj += k;
        cni();
        chj = 1;
    }

    public void cnh(int i, int j, int k)
    {
        ckh = i;
        cki = j;
        ckj = k;
        cni();
        chj = 1;
    }

    private void cni()
    {
        if(clc != 256 || cld != 256 || cle != 256 || clf != 256 || clg != 256 || clh != 256)
        {
            cli = 4;
            return;
        }
        if(ckn != 256 || cla != 256 || clb != 256)
        {
            cli = 3;
            return;
        }
        if(ckk != 0 || ckl != 0 || ckm != 0)
        {
            cli = 2;
            return;
        }
        if(ckh != 0 || cki != 0 || ckj != 0)
        {
            cli = 1;
            return;
        } else
        {
            cli = 0;
            return;
        }
    }

    private void cnj(int i, int j, int k)
    {
        for(int l = 0; l < cgd; l++)
        {
            cjk[l] += i;
            cjl[l] += j;
            cjm[l] += k;
        }

    }

    private void cnk(int i, int j, int k)
    {
        for(int i3 = 0; i3 < cgd; i3++)
        {
            if(k != 0)
            {
                int l = cja[k];
                int k1 = cja[k + 256];
                int j2 = cjl[i3] * l + cjk[i3] * k1 >> 15;
                cjl[i3] = cjl[i3] * k1 - cjk[i3] * l >> 15;
                cjk[i3] = j2;
            }
            if(i != 0)
            {
                int i1 = cja[i];
                int l1 = cja[i + 256];
                int k2 = cjl[i3] * l1 - cjm[i3] * i1 >> 15;
                cjm[i3] = cjl[i3] * i1 + cjm[i3] * l1 >> 15;
                cjl[i3] = k2;
            }
            if(j != 0)
            {
                int j1 = cja[j];
                int i2 = cja[j + 256];
                int l2 = cjm[i3] * j1 + cjk[i3] * i2 >> 15;
                cjm[i3] = cjm[i3] * i2 - cjk[i3] * j1 >> 15;
                cjk[i3] = l2;
            }
        }

    }

    private void cnl(int i, int j, int k, int l, int i1, int j1)
    {
        for(int k1 = 0; k1 < cgd; k1++)
        {
            if(i != 0)
                cjk[k1] += cjl[k1] * i >> 8;
            if(j != 0)
                cjm[k1] += cjl[k1] * j >> 8;
            if(k != 0)
                cjk[k1] += cjm[k1] * k >> 8;
            if(l != 0)
                cjl[k1] += cjm[k1] * l >> 8;
            if(i1 != 0)
                cjm[k1] += cjk[k1] * i1 >> 8;
            if(j1 != 0)
                cjl[k1] += cjk[k1] * j1 >> 8;
        }

    }

    private void cnm(int i, int j, int k)
    {
        for(int l = 0; l < cgd; l++)
        {
            cjk[l] = cjk[l] * i >> 8;
            cjl[l] = cjl[l] * j >> 8;
            cjm[l] = cjm[l] * k >> 8;
        }

    }

    private void cnn()
    {
        boolean flag = false;
        chl = chn = cib = 0xf423f;
        clj = chm = cia = cic = 0xfff0bdc1;
        for(int i = 0; i < cgl; i++)
        {
            int ai[] = cgn[i];
            int k = ai[0];
            int i1 = cgm[i];
            int j1;
            int k1 = j1 = cjk[k];
            int l1;
            int i2 = l1 = cjl[k];
            int j2;
            int k2 = j2 = cjm[k];
            for(int j = 0; j < i1; j++)
            {
                int l = ai[j];
                if(cjk[l] < j1)
                    j1 = cjk[l];
                else
                if(cjk[l] > k1)
                    k1 = cjk[l];
                if(cjl[l] < l1)
                    l1 = cjl[l];
                else
                if(cjl[l] > i2)
                    i2 = cjl[l];
                if(cjm[l] < j2)
                    j2 = cjm[l];
                else
                if(cjm[l] > k2)
                    k2 = cjm[l];
            }

            if(!cik)
            {
                ckb[i] = j1;
                ckc[i] = k1;
                ckd[i] = l1;
                cke[i] = i2;
                ckf[i] = j2;
                ckg[i] = k2;
            }
            if(k1 - j1 > clj)
                clj = k1 - j1;
            if(i2 - l1 > clj)
                clj = i2 - l1;
            if(k2 - j2 > clj)
                clj = k2 - j2;
            if(j1 < chl)
                chl = j1;
            if(k1 > chm)
                chm = k1;
            if(l1 < chn)
                chn = l1;
            if(i2 > cia)
                cia = i2;
            if(j2 < cib)
                cib = j2;
            if(k2 > cic)
                cic = k2;
        }

    }

    public void daa()
    {
        boolean flag = false;
        if(cil)
            return;
        int i = cma * cln >> 8;
        for(int j = 0; j < cgl; j++)
            if(che[j] != cjf)
                che[j] = (chf[j] * clk + chg[j] * cll + chh[j] * clm) / i;

        int ai[] = new int[cgd];
        int ai1[] = new int[cgd];
        int ai2[] = new int[cgd];
        int ai3[] = new int[cgd];
        for(int k = 0; k < cgd; k++)
        {
            ai[k] = 0;
            ai1[k] = 0;
            ai2[k] = 0;
            ai3[k] = 0;
        }

        for(int l = 0; l < cgl; l++)
            if(che[l] == cjf)
            {
                for(int i1 = 0; i1 < cgm[l]; i1++)
                {
                    int k1 = cgn[l][i1];
                    ai[k1] += chf[l];
                    ai1[k1] += chg[l];
                    ai2[k1] += chh[l];
                    ai3[k1]++;
                }

            }

        for(int j1 = 0; j1 < cgd; j1++)
            if(ai3[j1] > 0)
                cgj[j1] = (ai[j1] * clk + ai1[j1] * cll + ai2[j1] * clm) / (i * ai3[j1]);

    }

    public void dab()
    {
        boolean flag = false;
        if(cil && cik)
            return;
        for(int i = 0; i < cgl; i++)
        {
            int ai[] = cgn[i];
            int j = cjk[ai[0]];
            int k = cjl[ai[0]];
            int l = cjm[ai[0]];
            int i1 = cjk[ai[1]] - j;
            int j1 = cjl[ai[1]] - k;
            int k1 = cjm[ai[1]] - l;
            int l1 = cjk[ai[2]] - j;
            int i2 = cjl[ai[2]] - k;
            int j2 = cjm[ai[2]] - l;
            int k2 = j1 * j2 - i2 * k1;
            int l2 = k1 * l1 - j2 * i1;
            int i3;
            for(i3 = i1 * i2 - l1 * j1; k2 > 8192 || l2 > 8192 || i3 > 8192 || k2 < -8192 || l2 < -8192 || i3 < -8192; i3 >>= 1)
            {
                k2 >>= 1;
                l2 >>= 1;
            }

            int j3 = (int)(256D * Math.sqrt(k2 * k2 + l2 * l2 + i3 * i3));
            if(j3 <= 0)
                j3 = 1;
            chf[i] = (k2 * 0x10000) / j3;
            chg[i] = (l2 * 0x10000) / j3;
            chh[i] = (i3 * 65535) / j3;
            chd[i] = -1;
        }

        daa();
    }

    public void dac()
    {
        boolean flag = false;
        if(chj == 2)
        {
            chj = 0;
            for(int i = 0; i < cgd; i++)
            {
                cjk[i] = cjh[i];
                cjl[i] = cji[i];
                cjm[i] = cjj[i];
            }

            chl = chn = cib = 0xff676981;
            clj = chm = cia = cic = 0x98967f;
            return;
        }
        if(chj == 1)
        {
            chj = 0;
            for(int j = 0; j < cgd; j++)
            {
                cjk[j] = cjh[j];
                cjl[j] = cji[j];
                cjm[j] = cjj[j];
            }

            if(cli >= 2)
                cnk(ckk, ckl, ckm);
            if(cli >= 3)
                cnm(ckn, cla, clb);
            if(cli >= 4)
                cnl(clc, cld, cle, clf, clg, clh);
            if(cli >= 1)
                cnj(ckh, cki, ckj);
            cnn();
            dab();
        }
    }

    public void dad(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        boolean flag = false;
        dac();
        if(cib > bbe.bha || cic < bbe.bgn || chl > bbe.bgk || chm < bbe.bgj || chn > bbe.bgm || cia < bbe.bgl)
        {
            chk = false;
            return;
        }
        chk = true;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        if(j1 != 0)
        {
            l2 = cjb[j1];
            i3 = cjb[j1 + 1024];
        }
        if(i1 != 0)
        {
            l3 = cjb[i1];
            i4 = cjb[i1 + 1024];
        }
        if(l != 0)
        {
            j3 = cjb[l];
            k3 = cjb[l + 1024];
        }
        for(int j4 = 0; j4 < cgd; j4++)
        {
            int k4 = cjk[j4] - i;
            int l4 = cjl[j4] - j;
            int i5 = cjm[j4] - k;
            if(j1 != 0)
            {
                int i2 = l4 * l2 + k4 * i3 >> 15;
                l4 = l4 * i3 - k4 * l2 >> 15;
                k4 = i2;
            }
            if(i1 != 0)
            {
                int j2 = i5 * l3 + k4 * i4 >> 15;
                i5 = i5 * i4 - k4 * l3 >> 15;
                k4 = j2;
            }
            if(l != 0)
            {
                int k2 = l4 * k3 - i5 * j3 >> 15;
                i5 = l4 * j3 + i5 * k3 >> 15;
                l4 = k2;
            }
            if(i5 >= l1)
                cgh[j4] = (k4 << k1) / i5;
            else
                cgh[j4] = k4 << k1;
            if(i5 >= l1)
                cgi[j4] = (l4 << k1) / i5;
            else
                cgi[j4] = l4 << k1;
            cge[j4] = k4;
            cgf[j4] = l4;
            cgg[j4] = i5;
        }

    }

    public void dae()
    {
        dac();
        for(int i = 0; i < cgd; i++)
        {
            cjh[i] = cjk[i];
            cji[i] = cjl[i];
            cjj[i] = cjm[i];
        }

        ckh = cki = ckj = 0;
        ckk = ckl = ckm = 0;
        ckn = cla = clb = 256;
        clc = cld = cle = clf = clg = clh = 256;
        cli = 0;
    }

    public cgc daf()
    {
        cgc acgc[] = new cgc[1];
        acgc[0] = this;
        cgc cgc1 = new cgc(acgc, 1);
        cgc1.chi = 0;
        cgc1.cif = cif;
        return cgc1;
    }

    public cgc dag(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        cgc acgc[] = new cgc[1];
        acgc[0] = this;
        cgc cgc1 = new cgc(acgc, 1, flag, flag1, flag2, flag3);
        cgc1.chi = 0;
        return cgc1;
    }

    public void dah(cgc cgc1)
    {
        ckk = cgc1.ckk;
        ckl = cgc1.ckl;
        ckm = cgc1.ckm;
        ckh = cgc1.ckh;
        cki = cgc1.cki;
        ckj = cgc1.ckj;
        cni();
        chj = 1;
    }

    public int dai(byte abyte0[])
    {
        for(; abyte0[cmc] == 10 || abyte0[cmc] == 13; cmc++);
        int i = cjd[abyte0[cmc++] & 0xff];
        int j = cjd[abyte0[cmc++] & 0xff];
        int k = cjd[abyte0[cmc++] & 0xff];
        int l = (i * 4096 + j * 64 + k) - 0x20000;
        if(l == 0x1e240)
            l = cjf;
        return l;
    }

    public int cgd;
    public int cge[];
    public int cgf[];
    public int cgg[];
    public int cgh[];
    public int cgi[];
    public int cgj[];
    public byte cgk[];
    public int cgl;
    public int cgm[];
    public int cgn[][];
    public int cha[];
    public int chb[];
    public int chc[];
    public int chd[];
    public int che[];
    public int chf[];
    public int chg[];
    public int chh[];
    public int chi;
    public int chj;
    public boolean chk;
    public int chl;
    public int chm;
    public int chn;
    public int cia;
    public int cib;
    public int cic;
    public boolean cid;
    public boolean cie;
    public boolean cif;
    public int cig;
    public int cih[];
    public byte cii[];
    private boolean cij;
    public boolean cik;
    public boolean cil;
    public boolean cim;
    public boolean cin;
    private static int cja[];
    private static int cjb[];
    private static byte cjc[];
    private static int cjd[];
    private int cje;
    private int cjf;
    public int cjg;
    public int cjh[];
    public int cji[];
    public int cjj[];
    public int cjk[];
    public int cjl[];
    public int cjm[];
    private int cjn;
    private int cka[][];
    private int ckb[];
    private int ckc[];
    private int ckd[];
    private int cke[];
    private int ckf[];
    private int ckg[];
    private int ckh;
    private int cki;
    private int ckj;
    private int ckk;
    private int ckl;
    private int ckm;
    private int ckn;
    private int cla;
    private int clb;
    private int clc;
    private int cld;
    private int cle;
    private int clf;
    private int clg;
    private int clh;
    private int cli;
    private int clj;
    private int clk;
    private int cll;
    private int clm;
    private int cln;
    protected int cma;
    protected int cmb;
    private int cmc;
    private int cmd;

    static 
    {
        cja = new int[512];
        cjb = new int[2048];
        cjc = new byte[64];
        cjd = new int[256];
        for(int i = 0; i < 256; i++)
        {
            cja[i] = (int)(Math.sin((double)i * 0.02454369D) * 32768D);
            cja[i + 256] = (int)(Math.cos((double)i * 0.02454369D) * 32768D);
        }

        for(int j = 0; j < 1024; j++)
        {
            cjb[j] = (int)(Math.sin((double)j * 0.00613592315D) * 32768D);
            cjb[j + 1024] = (int)(Math.cos((double)j * 0.00613592315D) * 32768D);
        }

        for(int k = 0; k < 10; k++)
            cjc[k] = (byte)(48 + k);

        for(int l = 0; l < 26; l++)
            cjc[l + 10] = (byte)(65 + l);

        for(int i1 = 0; i1 < 26; i1++)
            cjc[i1 + 36] = (byte)(97 + i1);

        cjc[62] = -93;
        cjc[63] = 36;
        for(int j1 = 0; j1 < 10; j1++)
            cjd[48 + j1] = j1;

        for(int k1 = 0; k1 < 26; k1++)
            cjd[65 + k1] = k1 + 10;

        for(int l1 = 0; l1 < 26; l1++)
            cjd[97 + l1] = l1 + 36;

        cjd[163] = 62;
        cjd[36] = 63;
    }
}
