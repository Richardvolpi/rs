// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;


// Referenced classes of package jagex.client:
//            i

public class g
{

    public g(i j, int k)
    {
        sf = -1;
        gg = true;
        te = j;
        ve = k;
        we = new boolean[k];
        xe = new boolean[k];
        ye = new boolean[k];
        ze = new boolean[k];
        ef = new boolean[k];
        af = new int[k];
        bf = new int[k];
        cf = new int[k];
        df = new int[k];
        ff = new int[k];
        gf = new int[k];
        hf = new int[k];
        _fldif = new int[k];
        jf = new int[k];
        kf = new int[k];
        lf = new int[k];
        mf = new String[k];
        nf = new String[k][];
        uf = dd(114, 114, 176);
        vf = dd(14, 14, 62);
        wf = dd(200, 208, 232);
        xf = dd(96, 129, 184);
        yf = dd(53, 95, 115);
        zf = dd(117, 142, 171);
        ag = dd(98, 122, 158);
        bg = dd(86, 100, 136);
        cg = dd(135, 146, 179);
        dg = dd(97, 112, 151);
        eg = dd(88, 102, 136);
        fg = dd(84, 93, 120);
    }

    public int dd(int j, int k, int l)
    {
        return i.qg((jg * j) / 114, (kg * k) / 114, (lg * l) / 176);
    }

    public void ud()
    {
        qf = 0;
    }

    public void wd(int j, int k, int l, int i1)
    {
        of = j;
        pf = k;
        rf = i1;
        if(l != 0)
            qf = l;
        if(l == 1)
        {
            for(int j1 = 0; j1 < ue; j1++)
            {
                if(we[j1] && hf[j1] == 10 && of >= ff[j1] && pf >= gf[j1] && of <= ff[j1] + _fldif[j1] && pf <= gf[j1] + jf[j1])
                    ze[j1] = true;
                if(we[j1] && hf[j1] == 14 && of >= ff[j1] && pf >= gf[j1] && of <= ff[j1] + _fldif[j1] && pf <= gf[j1] + jf[j1])
                    cf[j1] = 1 - cf[j1];
            }

        }
        if(i1 == 1)
            tf++;
        else
            tf = 0;
        if(l == 1 || tf > 20)
        {
            for(int k1 = 0; k1 < ue; k1++)
                if(we[k1] && hf[k1] == 15 && of >= ff[k1] && pf >= gf[k1] && of <= ff[k1] + _fldif[k1] && pf <= gf[k1] + jf[k1])
                    ze[k1] = true;

            tf -= 5;
        }
    }

    public boolean yd(int j)
    {
        if(we[j] && ze[j])
        {
            ze[j] = false;
            return true;
        } else
        {
            return false;
        }
    }

    public void vd(int j)
    {
        if(j == 0)
            return;
        if(sf != -1 && mf[sf] != null && we[sf])
        {
            int k = mf[sf].length();
            if(j == 8 && k > 0)
                mf[sf] = mf[sf].substring(0, k - 1);
            if((j == 10 || j == 13) && k > 0)
                ze[sf] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(k < kf[sf])
            {
                for(int l = 0; l < s.length(); l++)
                    if(j == s.charAt(l))
                        mf[sf] += (char)j;

            }
            if(j == 9)
            {
                do
                    sf = (sf + 1) % ue;
                while(hf[sf] != 5 && hf[sf] != 6);
                return;
            }
        }
    }

    public void oc()
    {
        for(int j = 0; j < ue; j++)
            if(we[j])
                if(hf[j] == 0)
                    nd(j, ff[j], gf[j], mf[j], lf[j]);
                else
                if(hf[j] == 1)
                    nd(j, ff[j] - te.kf(mf[j], lf[j]) / 2, gf[j], mf[j], lf[j]);
                else
                if(hf[j] == 2)
                    od(ff[j], gf[j], _fldif[j], jf[j]);
                else
                if(hf[j] == 3)
                    bd(ff[j], gf[j], _fldif[j]);
                else
                if(hf[j] == 4)
                    jd(j, ff[j], gf[j], _fldif[j], jf[j], lf[j], nf[j], bf[j], af[j]);
                else
                if(hf[j] == 5 || hf[j] == 6)
                    yc(j, ff[j], gf[j], _fldif[j], jf[j], mf[j], lf[j]);
                else
                if(hf[j] == 7)
                    vc(j, ff[j], gf[j], lf[j], nf[j]);
                else
                if(hf[j] == 8)
                    ic(j, ff[j], gf[j], lf[j], nf[j]);
                else
                if(hf[j] == 9)
                    mc(j, ff[j], gf[j], _fldif[j], jf[j], lf[j], nf[j], bf[j], af[j]);
                else
                if(hf[j] == 11)
                    md(ff[j], gf[j], _fldif[j], jf[j]);
                else
                if(hf[j] == 12)
                    ed(ff[j], gf[j], lf[j]);
                else
                if(hf[j] == 14)
                    id(j, ff[j], gf[j], _fldif[j], jf[j]);

        qf = 0;
    }

    protected void id(int j, int k, int l, int i1, int j1)
    {
        te.eg(k, l, i1, j1, 0xffffff);
        te.xg(k, l, i1, cg);
        te.ch(k, l, j1, cg);
        te.xg(k, (l + j1) - 1, i1, fg);
        te.ch((k + i1) - 1, l, j1, fg);
        if(cf[j] == 1)
        {
            for(int k1 = 0; k1 < j1; k1++)
            {
                te.xg(k + k1, l + k1, 1, 0);
                te.xg((k + i1) - 1 - k1, l + k1, 1, 0);
            }

        }
    }

    protected void nd(int j, int k, int l, String s, int i1)
    {
        int j1 = l + te.tg(i1) / 3;
        pd(j, k, j1, s, i1);
    }

    protected void pd(int j, int k, int l, String s, int i1)
    {
        int j1;
        if(ef[j])
            j1 = 0xffffff;
        else
            j1 = 0;
        te.tf(s, k, l, i1, j1);
    }

    protected void yc(int j, int k, int l, int i1, int j1, String s, int k1)
    {
        if(ye[j])
        {
            int l1 = s.length();
            s = "";
            for(int j2 = 0; j2 < l1; j2++)
                s = s + "X";

        }
        if(hf[j] == 5)
        {
            if(qf == 1 && of >= k && pf >= l - j1 / 2 && of <= k + i1 && pf <= l + j1 / 2)
                sf = j;
        } else
        if(hf[j] == 6)
        {
            if(qf == 1 && of >= k - i1 / 2 && pf >= l - j1 / 2 && of <= k + i1 / 2 && pf <= l + j1 / 2)
                sf = j;
            k -= te.kf(s, k1) / 2;
        }
        if(sf == j)
            s = s + "*";
        int i2 = l + te.tg(k1) / 3;
        pd(j, k, i2, s, k1);
    }

    public void od(int j, int k, int l, int i1)
    {
        te.yf(j, k, j + l, k + i1);
        te.mg(j, k, l, i1, fg, cg);
        if(hg)
        {
            for(int j1 = j - (k & 0x3f); j1 < j + l; j1 += 128)
            {
                for(int k1 = k - (k & 0x1f); k1 < k + i1; k1 += 128)
                    te.wg(j1, k1, 6 + ig, 128);

            }

        }
        te.xg(j, k, l, cg);
        te.xg(j + 1, k + 1, l - 2, cg);
        te.xg(j + 2, k + 2, l - 4, dg);
        te.ch(j, k, i1, cg);
        te.ch(j + 1, k + 1, i1 - 2, cg);
        te.ch(j + 2, k + 2, i1 - 4, dg);
        te.xg(j, (k + i1) - 1, l, fg);
        te.xg(j + 1, (k + i1) - 2, l - 2, fg);
        te.xg(j + 2, (k + i1) - 3, l - 4, eg);
        te.ch((j + l) - 1, k, i1, fg);
        te.ch((j + l) - 2, k + 1, i1 - 2, fg);
        te.ch((j + l) - 3, k + 2, i1 - 4, eg);
        te.zf();
    }

    public void md(int j, int k, int l, int i1)
    {
        te.eg(j, k, l, i1, 0);
        te.xf(j, k, l, i1, zf);
        te.xf(j + 1, k + 1, l - 2, i1 - 2, ag);
        te.xf(j + 2, k + 2, l - 4, i1 - 4, bg);
        te.eh(j, k, 2 + ig);
        te.eh((j + l) - 7, k, 3 + ig);
        te.eh(j, (k + i1) - 7, 4 + ig);
        te.eh((j + l) - 7, (k + i1) - 7, 5 + ig);
    }

    protected void ed(int j, int k, int l)
    {
        te.eh(j, k, l);
    }

    protected void bd(int j, int k, int l)
    {
        te.xg(j, k, l, 0);
    }

    protected void jd(int j, int k, int l, int i1, int j1, int k1, String as[], 
            int l1, int i2)
    {
        int j2 = j1 / te.tg(k1);
        if(i2 > l1 - j2)
            i2 = l1 - j2;
        if(i2 < 0)
            i2 = 0;
        af[j] = i2;
        if(j2 < l1)
        {
            int k2 = (k + i1) - 12;
            int i3 = ((j1 - 27) * j2) / l1;
            if(i3 < 6)
                i3 = 6;
            int k3 = ((j1 - 27 - i3) * i2) / (l1 - j2);
            if(rf == 1 && of >= k2 && of <= k2 + 12)
            {
                if(pf > l && pf < l + 12 && i2 > 0)
                    i2--;
                if(pf > (l + j1) - 12 && pf < l + j1 && i2 < l1 - j2)
                    i2++;
                af[j] = i2;
            }
            if(rf == 1 && (of >= k2 && of <= k2 + 12 || of >= k2 - 12 && of <= k2 + 24 && xe[j]))
            {
                if(pf > l + 12 && pf < (l + j1) - 12)
                {
                    xe[j] = true;
                    int i4 = pf - l - 12 - i3 / 2;
                    i2 = (i4 * l1) / (j1 - 24);
                    if(i2 > l1 - j2)
                        i2 = l1 - j2;
                    if(i2 < 0)
                        i2 = 0;
                    af[j] = i2;
                }
            } else
            {
                xe[j] = false;
            }
            k3 = ((j1 - 27 - i3) * i2) / (l1 - j2);
            sd(k, l, i1, j1, k3, i3);
        }
        int l2 = j1 - j2 * te.tg(k1);
        int j3 = l + (te.tg(k1) * 5) / 6 + l2 / 2;
        for(int l3 = i2; l3 < l1; l3++)
        {
            pd(j, k + 2, j3, as[l3], k1);
            j3 += te.tg(k1) - mg;
            if(j3 >= l + j1)
                return;
        }

    }

    protected void sd(int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = (j + l) - 12;
        te.xf(l1, k, 12, i1, 0);
        te.eh(l1 + 1, k + 1, ig);
        te.eh(l1 + 1, (k + i1) - 12, 1 + ig);
        te.xg(l1, k + 13, 12, 0);
        te.xg(l1, (k + i1) - 13, 12, 0);
        te.mg(l1 + 1, k + 14, 11, i1 - 27, uf, vf);
        te.eg(l1 + 3, j1 + k + 14, 7, k1, xf);
        te.ch(l1 + 2, j1 + k + 14, k1, wf);
        te.ch(l1 + 2 + 8, j1 + k + 14, k1, yf);
    }

    protected void vc(int j, int k, int l, int i1, String as[])
    {
        int j1 = 0;
        int k1 = as.length;
        for(int l1 = 0; l1 < k1; l1++)
        {
            j1 += te.kf(as[l1], i1);
            if(l1 < k1 - 1)
                j1 += te.kf("  ", i1);
        }

        int i2 = k - j1 / 2;
        int j2 = l + te.tg(i1) / 3;
        for(int k2 = 0; k2 < k1; k2++)
        {
            int l2;
            if(ef[j])
                l2 = 0xffffff;
            else
                l2 = 0;
            if(of >= i2 && of <= i2 + te.kf(as[k2], i1) && pf <= j2 && pf > j2 - te.tg(i1))
            {
                if(ef[j])
                    l2 = 0x808080;
                else
                    l2 = 0xffffff;
                if(qf == 1)
                {
                    cf[j] = k2;
                    ze[j] = true;
                }
            }
            if(cf[j] == k2)
                if(ef[j])
                    l2 = 0xff0000;
                else
                    l2 = 0xc00000;
            te.tf(as[k2], i2, j2, i1, l2);
            i2 += te.kf(as[k2] + "  ", i1);
        }

    }

    protected void ic(int j, int k, int l, int i1, String as[])
    {
        int j1 = as.length;
        int k1 = l - (te.tg(i1) * (j1 - 1)) / 2;
        for(int l1 = 0; l1 < j1; l1++)
        {
            int i2;
            if(ef[j])
                i2 = 0xffffff;
            else
                i2 = 0;
            int j2 = te.kf(as[l1], i1);
            if(of >= k - j2 / 2 && of <= k + j2 / 2 && pf - 2 <= k1 && pf - 2 > k1 - te.tg(i1))
            {
                if(ef[j])
                    i2 = 0x808080;
                else
                    i2 = 0xffffff;
                if(qf == 1)
                {
                    cf[j] = l1;
                    ze[j] = true;
                }
            }
            if(cf[j] == l1)
                if(ef[j])
                    i2 = 0xff0000;
                else
                    i2 = 0xc00000;
            te.tf(as[l1], k - j2 / 2, k1, i1, i2);
            k1 += te.tg(i1);
        }

    }

    protected void mc(int j, int k, int l, int i1, int j1, int k1, String as[], 
            int l1, int i2)
    {
        int j2 = j1 / te.tg(k1);
        if(j2 < l1)
        {
            int k2 = (k + i1) - 12;
            int i3 = ((j1 - 27) * j2) / l1;
            if(i3 < 6)
                i3 = 6;
            int k3 = ((j1 - 27 - i3) * i2) / (l1 - j2);
            if(rf == 1 && of >= k2 && of <= k2 + 12)
            {
                if(pf > l && pf < l + 12 && i2 > 0)
                    i2--;
                if(pf > (l + j1) - 12 && pf < l + j1 && i2 < l1 - j2)
                    i2++;
                af[j] = i2;
            }
            if(rf == 1 && (of >= k2 && of <= k2 + 12 || of >= k2 - 12 && of <= k2 + 24 && xe[j]))
            {
                if(pf > l + 12 && pf < (l + j1) - 12)
                {
                    xe[j] = true;
                    int i4 = pf - l - 12 - i3 / 2;
                    i2 = (i4 * l1) / (j1 - 24);
                    if(i2 < 0)
                        i2 = 0;
                    if(i2 > l1 - j2)
                        i2 = l1 - j2;
                    af[j] = i2;
                }
            } else
            {
                xe[j] = false;
            }
            k3 = ((j1 - 27 - i3) * i2) / (l1 - j2);
            sd(k, l, i1, j1, k3, i3);
        } else
        {
            i2 = 0;
            af[j] = 0;
        }
        df[j] = -1;
        int l2 = j1 - j2 * te.tg(k1);
        int j3 = l + (te.tg(k1) * 5) / 6 + l2 / 2;
        for(int l3 = i2; l3 < l1; l3++)
        {
            int j4;
            if(ef[j])
                j4 = 0xffffff;
            else
                j4 = 0;
            if(of >= k + 2 && of <= k + 2 + te.kf(as[l3], k1) && pf - 2 <= j3 && pf - 2 > j3 - te.tg(k1))
            {
                if(ef[j])
                    j4 = 0x808080;
                else
                    j4 = 0xffffff;
                df[j] = l3;
                if(qf == 1)
                {
                    cf[j] = l3;
                    ze[j] = true;
                }
            }
            if(cf[j] == l3 && gg)
                j4 = 0xff0000;
            te.tf(as[l3], k + 2, j3, k1, j4);
            j3 += te.tg(k1);
            if(j3 >= l + j1)
                return;
        }

    }

    public int rc(int j, int k, String s, int l, boolean flag)
    {
        hf[ue] = 0;
        we[ue] = true;
        ze[ue] = false;
        lf[ue] = l;
        ef[ue] = flag;
        ff[ue] = j;
        gf[ue] = k;
        mf[ue] = s;
        return ue++;
    }

    public int qd(int j, int k, String s, int l, boolean flag)
    {
        hf[ue] = 1;
        we[ue] = true;
        ze[ue] = false;
        lf[ue] = l;
        ef[ue] = flag;
        ff[ue] = j;
        gf[ue] = k;
        mf[ue] = s;
        return ue++;
    }

    public int hd(int j, int k, int l, int i1)
    {
        hf[ue] = 2;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j - l / 2;
        gf[ue] = k - i1 / 2;
        _fldif[ue] = l;
        jf[ue] = i1;
        return ue++;
    }

    public int qc(int j, int k, int l, int i1)
    {
        hf[ue] = 11;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j - l / 2;
        gf[ue] = k - i1 / 2;
        _fldif[ue] = l;
        jf[ue] = i1;
        return ue++;
    }

    public int sc(int j, int k, int l)
    {
        int i1 = te.kk[l];
        int j1 = te.lk[l];
        hf[ue] = 12;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j - i1 / 2;
        gf[ue] = k - j1 / 2;
        _fldif[ue] = i1;
        jf[ue] = j1;
        lf[ue] = l;
        return ue++;
    }

    public int kc(int j, int k, int l, int i1, int j1, int k1, boolean flag)
    {
        hf[ue] = 4;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j;
        gf[ue] = k;
        _fldif[ue] = l;
        jf[ue] = i1;
        ef[ue] = flag;
        lf[ue] = j1;
        kf[ue] = k1;
        bf[ue] = 0;
        af[ue] = 0;
        nf[ue] = new String[k1];
        return ue++;
    }

    public int lc(int j, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1)
    {
        hf[ue] = 5;
        we[ue] = true;
        ye[ue] = flag;
        ze[ue] = false;
        lf[ue] = j1;
        ef[ue] = flag1;
        ff[ue] = j;
        gf[ue] = k;
        _fldif[ue] = l;
        jf[ue] = i1;
        kf[ue] = k1;
        mf[ue] = "";
        return ue++;
    }

    public int fd(int j, int k, int l, int i1, int j1, int k1, boolean flag, 
            boolean flag1)
    {
        hf[ue] = 6;
        we[ue] = true;
        ye[ue] = flag;
        ze[ue] = false;
        lf[ue] = j1;
        ef[ue] = flag1;
        ff[ue] = j;
        gf[ue] = k;
        _fldif[ue] = l;
        jf[ue] = i1;
        kf[ue] = k1;
        mf[ue] = "";
        return ue++;
    }

    public int jc(int j, int k, String as[], int l, boolean flag)
    {
        hf[ue] = 8;
        we[ue] = true;
        ze[ue] = false;
        lf[ue] = l;
        ef[ue] = flag;
        ff[ue] = j;
        gf[ue] = k;
        nf[ue] = as;
        cf[ue] = 0;
        return ue++;
    }

    public int xc(int j, int k, int l, int i1, int j1, int k1, boolean flag)
    {
        hf[ue] = 9;
        we[ue] = true;
        ze[ue] = false;
        lf[ue] = j1;
        ef[ue] = flag;
        ff[ue] = j;
        gf[ue] = k;
        _fldif[ue] = l;
        jf[ue] = i1;
        kf[ue] = k1;
        nf[ue] = new String[k1];
        bf[ue] = 0;
        af[ue] = 0;
        cf[ue] = -1;
        df[ue] = -1;
        return ue++;
    }

    public int td(int j, int k, int l, int i1)
    {
        hf[ue] = 10;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j - l / 2;
        gf[ue] = k - i1 / 2;
        _fldif[ue] = l;
        jf[ue] = i1;
        return ue++;
    }

    public int zc(int j, int k, int l)
    {
        hf[ue] = 14;
        we[ue] = true;
        ze[ue] = false;
        ff[ue] = j - l / 2;
        gf[ue] = k - l / 2;
        _fldif[ue] = l;
        jf[ue] = l;
        return ue++;
    }

    public void tc(int j)
    {
        bf[j] = 0;
    }

    public void gd(int j)
    {
        af[j] = 0;
        df[j] = -1;
    }

    public void kd(int j, int k, String s)
    {
        nf[j][k] = s;
        if(k + 1 > bf[j])
            bf[j] = k + 1;
    }

    public void nc(int j, String s, boolean flag)
    {
        int k = bf[j]++;
        if(k >= kf[j])
        {
            k--;
            bf[j]--;
            for(int l = 0; l < k; l++)
                nf[j][l] = nf[j][l + 1];

        }
        nf[j][k] = s;
        if(flag)
            af[j] = 0xf423f;
    }

    public void rd(int j, String s)
    {
        mf[j] = s;
    }

    public String wc(int j)
    {
        if(mf[j] == null)
            return "null";
        else
            return mf[j];
    }

    public void ld(int j)
    {
        we[j] = true;
    }

    public void xd(int j)
    {
        we[j] = false;
    }

    public void uc(int j)
    {
        sf = j;
    }

    public int ad(int j)
    {
        return cf[j];
    }

    public int pc(int j)
    {
        int k = df[j];
        return k;
    }

    public void cd(int j, int k)
    {
        cf[j] = k;
    }

    protected i te;
    int ue;
    int ve;
    public boolean we[];
    public boolean xe[];
    public boolean ye[];
    public boolean ze[];
    public int af[];
    public int bf[];
    public int cf[];
    public int df[];
    boolean ef[];
    int ff[];
    int gf[];
    int hf[];
    int _fldif[];
    int jf[];
    int kf[];
    int lf[];
    String mf[];
    String nf[][];
    int of;
    int pf;
    int qf;
    int rf;
    int sf;
    int tf;
    int uf;
    int vf;
    int wf;
    int xf;
    int yf;
    int zf;
    int ag;
    int bg;
    int cg;
    int dg;
    int eg;
    int fg;
    public boolean gg;
    public static boolean hg = true;
    public static int ig;
    public static int jg = 114;
    public static int kg = 114;
    public static int lg = 176;
    public static int mg;

}
