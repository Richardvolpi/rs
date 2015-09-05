// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import jagex.f;
import jagex.o;
import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package jagex.client:
//            h, s, q, k, 
//            i, a

public class j
{

    public j(i l, int i1, int j1, int k1)
    {
        dm = 50;
        em = new int[dm];
        fm = new int[dm][256];
        im = 5;
        jm = 1000;
        km = 1000;
        lm = 20;
        mm = 10;
        pm = false;
        qm = 1.1000000000000001D;
        rm = 1;
        sm = false;
        wm = 100;
        xm = new h[wm];
        ym = new int[wm];
        zm = 512;
        an = 256;
        bn = 192;
        cn = 256;
        dn = 256;
        en = 8;
        fn = 4;
        yo = new int[40];
        zo = new int[40];
        ap = new int[40];
        bp = new int[40];
        cp = new int[40];
        dp = new int[40];
        ep = false;
        to = l;
        an = l.xj / 2;
        bn = l.yj / 2;
        uo = l.dk;
        mn = 0;
        nn = i1;
        on = new h[nn];
        pn = new int[nn];
        qn = 0;
        rn = new q[j1];
        for(int l1 = 0; l1 < j1; l1++)
            rn[l1] = new q();

        tn = 0;
        bo = new h(k1 * 2, k1);
        un = new int[k1];
        yn = new int[k1];
        zn = new int[k1];
        vn = new int[k1];
        wn = new int[k1];
        xn = new int[k1];
        ao = new int[k1];
        if(ro == null)
            ro = new byte[17691];
        gn = 0;
        hn = 0;
        in = 0;
        jn = 0;
        kn = 0;
        ln = 0;
        for(int i2 = 0; i2 < 256; i2++)
        {
            om[i2] = (int)(Math.sin((double)i2 * 0.02454369D) * 32768D);
            om[i2 + 256] = (int)(Math.cos((double)i2 * 0.02454369D) * 32768D);
        }

        for(int j2 = 0; j2 < 1024; j2++)
        {
            nm[j2] = (int)(Math.sin((double)j2 * 0.00613592315D) * 32768D);
            nm[j2 + 1024] = (int)(Math.cos((double)j2 * 0.00613592315D) * 32768D);
        }

    }

    public void bi(h h1)
    {
        if(mn < nn)
        {
            pn[mn] = 0;
            on[mn++] = h1;
        }
    }

    public void fi(h h1)
    {
        for(int l = 0; l < mn; l++)
            if(on[l] == h1)
            {
                mn--;
                for(int i1 = l; i1 < mn; i1++)
                {
                    on[i1] = on[i1 + 1];
                    pn[i1] = pn[i1 + 1];
                }

            }

    }

    public void zi()
    {
        hi();
        for(int l = 0; l < mn; l++)
            on[l] = null;

        mn = 0;
    }

    public void hi()
    {
        tn = 0;
        bo.ef();
    }

    public void qi(int l)
    {
        tn -= l;
        bo.se(l, l * 2);
        if(tn < 0)
            tn = 0;
    }

    public int ej(int l, int i1, int j1, int k1, int l1, int i2)
    {
        un[tn] = l;
        vn[tn] = i1;
        wn[tn] = j1;
        xn[tn] = k1;
        yn[tn] = l1;
        zn[tn] = i2;
        ao[tn] = 0;
        int j2 = bo.ke(i1, j1, k1);
        int k2 = bo.ke(i1, j1 - i2, k1);
        int ai1[] = {
            j2, k2
        };
        bo.ue(2, ai1, 0, 0);
        bo.vh[tn++] = 0;
        return tn - 1;
    }

    public int sh(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        un[tn] = l;
        vn[tn] = i1;
        wn[tn] = j1;
        xn[tn] = k1;
        yn[tn] = l1;
        zn[tn] = i2;
        ao[tn] = 0;
        int k2 = bo.ke(i1, j1, k1);
        int l2 = bo.ke(i1, j1 - i2, k1);
        int ai1[] = {
            k2, l2
        };
        bo.ue(2, ai1, 0, 0);
        bo.uh[tn] = j2;
        bo.vh[tn++] = 0;
        return tn - 1;
    }

    public void th(int l)
    {
        bo.vh[l] = 1;
    }

    public void ui(int l, int i1)
    {
        ao[l] = i1;
    }

    public void ci(int l, int i1)
    {
        tm = l - cn;
        um = i1;
        vm = 0;
        sm = true;
    }

    public int yi()
    {
        return vm;
    }

    public int[] ti()
    {
        return ym;
    }

    public h[] vh()
    {
        return xm;
    }

    public void ki(int l, int i1, int j1, int k1, int l1, int i2)
    {
        an = j1;
        bn = k1;
        cn = l;
        dn = i1;
        zm = l1;
        en = i2;
        vo = new s[k1 + i1];
        for(int j2 = 0; j2 < k1 + i1; j2++)
            vo[j2] = new s();

    }

    private void xh(q aq[], int l, int i1)
    {
        if(l < i1)
        {
            int j1 = l - 1;
            int k1 = i1 + 1;
            int l1 = (l + i1) / 2;
            q q1 = aq[l1];
            aq[l1] = aq[l];
            aq[l] = q1;
            int i2 = q1.ohb;
            while(j1 < k1) 
            {
                do
                    k1--;
                while(aq[k1].ohb < i2);
                do
                    j1++;
                while(aq[j1].ohb > i2);
                if(j1 < k1)
                {
                    q q2 = aq[j1];
                    aq[j1] = aq[k1];
                    aq[k1] = q2;
                }
            }
            xh(aq, l, k1);
            xh(aq, k1 + 1, i1);
        }
    }

    public void oh(int l, q aq[], int i1)
    {
        for(int j1 = 0; j1 <= i1; j1++)
        {
            aq[j1].uhb = false;
            aq[j1].vhb = j1;
            aq[j1].whb = -1;
        }

        int k1 = 0;
        do
        {
            while(aq[k1].uhb) 
                k1++;
            if(k1 == i1)
                return;
            q q1 = aq[k1];
            q1.uhb = true;
            int l1 = k1;
            int i2 = k1 + l;
            if(i2 >= i1)
                i2 = i1 - 1;
            for(int j2 = i2; j2 >= l1 + 1; j2--)
            {
                q q2 = aq[j2];
                if(q1.ghb < q2.ihb && q2.ghb < q1.ihb && q1.hhb < q2.jhb && q2.hhb < q1.jhb && q1.vhb != q2.whb && !ph(q1, q2) && nh(q2, q1))
                {
                    bj(aq, l1, j2);
                    if(aq[j2] != q2)
                        j2++;
                    l1 = lp;
                    q2.whb = q1.vhb;
                }
            }

        } while(true);
    }

    public boolean bj(q aq[], int l, int i1)
    {
        do
        {
            q q1 = aq[l];
            for(int j1 = l + 1; j1 <= i1; j1++)
            {
                q q2 = aq[j1];
                if(!ph(q2, q1))
                    break;
                aq[l] = q2;
                aq[j1] = q1;
                l = j1;
                if(l == i1)
                {
                    lp = l;
                    mp = l - 1;
                    return true;
                }
            }

            q q3 = aq[i1];
            for(int k1 = i1 - 1; k1 >= l; k1--)
            {
                q q4 = aq[k1];
                if(!ph(q3, q4))
                    break;
                aq[i1] = q4;
                aq[k1] = q3;
                i1 = k1;
                if(l == i1)
                {
                    lp = i1 + 1;
                    mp = i1;
                    return true;
                }
            }

            if(l + 1 >= i1)
            {
                lp = l;
                mp = i1;
                return false;
            }
            if(!bj(aq, l + 1, i1))
            {
                lp = l;
                return false;
            }
            i1 = mp;
        } while(true);
    }

    public void xi(int l, int i1, int j1)
    {
        int k1 = -jn + 1024 & 0x3ff;
        int l1 = -kn + 1024 & 0x3ff;
        int i2 = -ln + 1024 & 0x3ff;
        if(i2 != 0)
        {
            int j2 = nm[i2];
            int i3 = nm[i2 + 1024];
            int l3 = i1 * j2 + l * i3 >> 15;
            i1 = i1 * i3 - l * j2 >> 15;
            l = l3;
        }
        if(k1 != 0)
        {
            int k2 = nm[k1];
            int j3 = nm[k1 + 1024];
            int i4 = i1 * j3 - j1 * k2 >> 15;
            j1 = i1 * k2 + j1 * j3 >> 15;
            i1 = i4;
        }
        if(l1 != 0)
        {
            int l2 = nm[l1];
            int k3 = nm[l1 + 1024];
            int j4 = j1 * l2 + l * k3 >> 15;
            j1 = j1 * k3 - l * l2 >> 15;
            l = j4;
        }
        if(l < fp)
            fp = l;
        if(l > gp)
            gp = l;
        if(i1 < hp)
            hp = i1;
        if(i1 > ip)
            ip = i1;
        if(j1 < jp)
            jp = j1;
        if(j1 > kp)
            kp = j1;
    }

    public void cj()
    {
        ep = to.wk;
        int l3 = an * jm >> en;
        int i4 = bn * jm >> en;
        fp = 0;
        gp = 0;
        hp = 0;
        ip = 0;
        jp = 0;
        kp = 0;
        xi(-l3, -i4, jm);
        xi(-l3, i4, jm);
        xi(l3, -i4, jm);
        xi(l3, i4, jm);
        xi(-an, -bn, 0);
        xi(-an, bn, 0);
        xi(an, -bn, 0);
        xi(an, bn, 0);
        fp += gn;
        gp += gn;
        hp += hn;
        ip += hn;
        jp += in;
        kp += in;
        on[mn] = bo;
        bo.ih = 2;
        for(int l = 0; l < mn; l++)
            on[l].oe(gn, hn, in, jn, kn, ln, en, im);

        on[mn].oe(gn, hn, in, jn, kn, ln, en, im);
        qn = 0;
        for(int j4 = 0; j4 < mn; j4++)
        {
            h h1 = on[j4];
            if(h1.jh)
            {
                for(int i1 = 0; i1 < h1.vg; i1++)
                {
                    int k4 = h1.wg[i1];
                    int ai2[] = h1.xg[i1];
                    boolean flag = false;
                    for(int j5 = 0; j5 < k4; j5++)
                    {
                        int l1 = h1.qg[ai2[j5]];
                        if(l1 <= im || l1 >= jm)
                            continue;
                        flag = true;
                        break;
                    }

                    if(flag)
                    {
                        int k2 = 0;
                        for(int j6 = 0; j6 < k4; j6++)
                        {
                            int i2 = h1.rg[ai2[j6]];
                            if(i2 > -an)
                                k2 |= 1;
                            if(i2 < an)
                                k2 |= 2;
                            if(k2 == 3)
                                break;
                        }

                        if(k2 == 3)
                        {
                            int l2 = 0;
                            for(int k7 = 0; k7 < k4; k7++)
                            {
                                int j2 = h1.sg[ai2[k7]];
                                if(j2 > -bn)
                                    l2 |= 1;
                                if(j2 < bn)
                                    l2 |= 2;
                                if(l2 == 3)
                                    break;
                            }

                            if(l2 == 3)
                            {
                                q q2 = rn[qn];
                                q2.mhb = h1;
                                q2.nhb = i1;
                                dj(qn);
                                int k9;
                                if(q2.shb < 0)
                                    k9 = h1.yg[i1];
                                else
                                    k9 = h1.zg[i1];
                                if(k9 != 0xbc614e)
                                {
                                    int i3 = 0;
                                    for(int k10 = 0; k10 < k4; k10++)
                                        i3 += h1.qg[ai2[k10]];

                                    int k3;
                                    q2.ohb = k3 = i3 / k4 + h1.hh;
                                    q2.thb = k9;
                                    qn++;
                                }
                            }
                        }
                    }
                }

            }
        }

        h h2 = bo;
        if(h2.jh)
        {
            for(int j1 = 0; j1 < h2.vg; j1++)
            {
                int ai1[] = h2.xg[j1];
                int i5 = ai1[0];
                int k5 = h2.rg[i5];
                int k6 = h2.sg[i5];
                int l7 = h2.qg[i5];
                if(l7 > im && l7 < km)
                {
                    int l8 = (yn[j1] << en) / l7;
                    int l9 = (zn[j1] << en) / l7;
                    if(k5 - l8 / 2 <= an && k5 + l8 / 2 >= -an && k6 - l9 <= bn && k6 >= -bn)
                    {
                        q q3 = rn[qn];
                        q3.mhb = h2;
                        q3.nhb = j1;
                        gj(qn);
                        q3.ohb = (l7 + h2.qg[ai1[1]]) / 2;
                        qn++;
                    }
                }
            }

        }
        if(qn == 0)
            return;
        hm = qn;
        xh(rn, cm, qn - 1);
        oh(100, rn, qn);
        for(int l4 = 0; l4 < qn; l4++)
        {
            q q1 = rn[l4];
            h h3 = q1.mhb;
            int k1 = q1.nhb;
            if(h3 == bo)
            {
                int ai3[] = h3.xg[k1];
                int l6 = ai3[0];
                int i8 = h3.rg[l6];
                int i9 = h3.sg[l6];
                int i10 = h3.qg[l6];
                int l10 = (yn[k1] << en) / i10;
                int j11 = (zn[k1] << en) / i10;
                int l11 = i9 - h3.sg[ai3[1]];
                int i12 = ((h3.rg[ai3[1]] - i8) * l11) / j11;
                i12 = h3.rg[ai3[1]] - i8;
                int k12 = i8 - l10 / 2;
                int i13 = (dn + i9) - j11;
                to.jg(k12 + cn, i13, l10, j11, un[k1], i12, (256 << en) / i10);
                if(sm && vm < wm)
                {
                    k12 += (ao[k1] << en) / i10;
                    if(um >= i13 && um <= i13 + j11 && tm >= k12 && tm <= k12 + l10 && !h3.zh && h3.vh[k1] == 0)
                    {
                        xm[vm] = h3;
                        ym[vm] = k1;
                        vm++;
                    }
                }
            } else
            {
                int j9 = 0;
                int i11 = 0;
                int k11 = h3.wg[k1];
                int ai4[] = h3.xg[k1];
                if(h3.ch[k1] != 0xbc614e)
                    if(q1.shb < 0)
                        i11 = h3.sj - h3.ch[k1];
                    else
                        i11 = h3.sj + h3.ch[k1];
                for(int j12 = 0; j12 < k11; j12++)
                {
                    int j3 = ai4[j12];
                    bp[j12] = h3.og[j3];
                    cp[j12] = h3.pg[j3];
                    dp[j12] = h3.qg[j3];
                    if(h3.ch[k1] == 0xbc614e)
                        if(q1.shb < 0)
                            i11 = (h3.sj - h3.tg[j3]) + h3.ug[j3];
                        else
                            i11 = h3.sj + h3.tg[j3] + h3.ug[j3];
                    if(h3.qg[j3] >= im)
                    {
                        yo[j9] = h3.rg[j3];
                        zo[j9] = h3.sg[j3];
                        ap[j9] = i11;
                        if(h3.qg[j3] > mm)
                            ap[j9] += (h3.qg[j3] - mm) / lm;
                        j9++;
                    } else
                    {
                        int j10;
                        if(j12 == 0)
                            j10 = ai4[k11 - 1];
                        else
                            j10 = ai4[j12 - 1];
                        if(h3.qg[j10] >= im)
                        {
                            int j8 = h3.qg[j3] - h3.qg[j10];
                            int l5 = h3.og[j3] - ((h3.og[j3] - h3.og[j10]) * (h3.qg[j3] - im)) / j8;
                            int i7 = h3.pg[j3] - ((h3.pg[j3] - h3.pg[j10]) * (h3.qg[j3] - im)) / j8;
                            yo[j9] = (l5 << en) / im;
                            zo[j9] = (i7 << en) / im;
                            ap[j9] = i11;
                            j9++;
                        }
                        if(j12 == k11 - 1)
                            j10 = ai4[0];
                        else
                            j10 = ai4[j12 + 1];
                        if(h3.qg[j10] >= im)
                        {
                            int k8 = h3.qg[j3] - h3.qg[j10];
                            int i6 = h3.og[j3] - ((h3.og[j3] - h3.og[j10]) * (h3.qg[j3] - im)) / k8;
                            int j7 = h3.pg[j3] - ((h3.pg[j3] - h3.pg[j10]) * (h3.qg[j3] - im)) / k8;
                            yo[j9] = (i6 << en) / im;
                            zo[j9] = (j7 << en) / im;
                            ap[j9] = i11;
                            j9++;
                        }
                    }
                }

                for(int l12 = 0; l12 < k11; l12++)
                {
                    if(ap[l12] < 0)
                        ap[l12] = 0;
                    else
                    if(ap[l12] > 255)
                        ap[l12] = 255;
                    if(q1.thb >= 0)
                        if(jo[q1.thb] == 1)
                            ap[l12] <<= 9;
                        else
                            ap[l12] <<= 6;
                }

                mh(cm, cm, cm, cm, j9, yo, zo, ap, h3, k1);
                if(xo > wo)
                    wh(cm, cm, k11, bp, cp, dp, q1.thb, h3);
            }
        }

        sm = false;
    }

    private void mh(int l, int i1, int j1, int k1, int l1, int ai1[], int ai2[], 
            int ai3[], h h1, int i2)
    {
        if(l1 == 3)
        {
            int j2 = ai2[0] + dn;
            int j3 = ai2[1] + dn;
            int j4 = ai2[2] + dn;
            int j5 = ai1[0];
            int k6 = ai1[1];
            int i8 = ai1[2];
            int k9 = ai3[0];
            int i11 = ai3[1];
            int i12 = ai3[2];
            int i13 = (dn + bn) - 1;
            int k13 = 0;
            int i14 = 0;
            int k14 = 0;
            int i15 = 0;
            int k15 = 0xbc614e;
            int i16 = 0xff439eb2;
            if(j4 != j2)
            {
                i14 = (i8 - j5 << 8) / (j4 - j2);
                i15 = (i12 - k9 << 8) / (j4 - j2);
                if(j2 < j4)
                {
                    k13 = j5 << 8;
                    k14 = k9 << 8;
                    k15 = j2;
                    i16 = j4;
                } else
                {
                    k13 = i8 << 8;
                    k14 = i12 << 8;
                    k15 = j4;
                    i16 = j2;
                }
                if(k15 < 0)
                {
                    k13 -= i14 * k15;
                    k14 -= i15 * k15;
                    k15 = 0;
                }
                if(i16 > i13)
                    i16 = i13;
            }
            int k16 = 0;
            int i17 = 0;
            int k17 = 0;
            int i18 = 0;
            int k18 = 0xbc614e;
            int i19 = 0xff439eb2;
            if(j3 != j2)
            {
                i17 = (k6 - j5 << 8) / (j3 - j2);
                i18 = (i11 - k9 << 8) / (j3 - j2);
                if(j2 < j3)
                {
                    k16 = j5 << 8;
                    k17 = k9 << 8;
                    k18 = j2;
                    i19 = j3;
                } else
                {
                    k16 = k6 << 8;
                    k17 = i11 << 8;
                    k18 = j3;
                    i19 = j2;
                }
                if(k18 < 0)
                {
                    k16 -= i17 * k18;
                    k17 -= i18 * k18;
                    k18 = 0;
                }
                if(i19 > i13)
                    i19 = i13;
            }
            int k19 = 0;
            int i20 = 0;
            int k20 = 0;
            int i21 = 0;
            int k21 = 0xbc614e;
            int i22 = 0xff439eb2;
            if(j4 != j3)
            {
                i20 = (i8 - k6 << 8) / (j4 - j3);
                i21 = (i12 - i11 << 8) / (j4 - j3);
                if(j3 < j4)
                {
                    k19 = k6 << 8;
                    k20 = i11 << 8;
                    k21 = j3;
                    i22 = j4;
                } else
                {
                    k19 = i8 << 8;
                    k20 = i12 << 8;
                    k21 = j4;
                    i22 = j3;
                }
                if(k21 < 0)
                {
                    k19 -= i20 * k21;
                    k20 -= i21 * k21;
                    k21 = 0;
                }
                if(i22 > i13)
                    i22 = i13;
            }
            wo = k15;
            if(k18 < wo)
                wo = k18;
            if(k21 < wo)
                wo = k21;
            xo = i16;
            if(i19 > xo)
                xo = i19;
            if(i22 > xo)
                xo = i22;
            int k22 = 0;
            for(j1 = wo; j1 < xo; j1++)
            {
                if(j1 >= k15 && j1 < i16)
                {
                    l = i1 = k13;
                    k1 = k22 = k14;
                    k13 += i14;
                    k14 += i15;
                } else
                {
                    l = 0xa0000;
                    i1 = 0xfff60000;
                }
                if(j1 >= k18 && j1 < i19)
                {
                    if(k16 < l)
                    {
                        l = k16;
                        k1 = k17;
                    }
                    if(k16 > i1)
                    {
                        i1 = k16;
                        k22 = k17;
                    }
                    k16 += i17;
                    k17 += i18;
                }
                if(j1 >= k21 && j1 < i22)
                {
                    if(k19 < l)
                    {
                        l = k19;
                        k1 = k20;
                    }
                    if(k19 > i1)
                    {
                        i1 = k19;
                        k22 = k20;
                    }
                    k19 += i20;
                    k20 += i21;
                }
                s s7 = vo[j1];
                s7.anb = l;
                s7.bnb = i1;
                s7.cnb = k1;
                s7.dnb = k22;
            }

            if(wo < dn - bn)
                wo = dn - bn;
        } else
        if(l1 == 4)
        {
            int k2 = ai2[0] + dn;
            int k3 = ai2[1] + dn;
            int k4 = ai2[2] + dn;
            int k5 = ai2[3] + dn;
            int l6 = ai1[0];
            int j8 = ai1[1];
            int l9 = ai1[2];
            int j11 = ai1[3];
            int j12 = ai3[0];
            int j13 = ai3[1];
            int l13 = ai3[2];
            int j14 = ai3[3];
            int l14 = (dn + bn) - 1;
            int j15 = 0;
            int l15 = 0;
            int j16 = 0;
            int l16 = 0;
            int j17 = 0xbc614e;
            int l17 = 0xff439eb2;
            if(k5 != k2)
            {
                l15 = (j11 - l6 << 8) / (k5 - k2);
                l16 = (j14 - j12 << 8) / (k5 - k2);
                if(k2 < k5)
                {
                    j15 = l6 << 8;
                    j16 = j12 << 8;
                    j17 = k2;
                    l17 = k5;
                } else
                {
                    j15 = j11 << 8;
                    j16 = j14 << 8;
                    j17 = k5;
                    l17 = k2;
                }
                if(j17 < 0)
                {
                    j15 -= l15 * j17;
                    j16 -= l16 * j17;
                    j17 = 0;
                }
                if(l17 > l14)
                    l17 = l14;
            }
            int j18 = 0;
            int l18 = 0;
            int j19 = 0;
            int l19 = 0;
            int j20 = 0xbc614e;
            int l20 = 0xff439eb2;
            if(k3 != k2)
            {
                l18 = (j8 - l6 << 8) / (k3 - k2);
                l19 = (j13 - j12 << 8) / (k3 - k2);
                if(k2 < k3)
                {
                    j18 = l6 << 8;
                    j19 = j12 << 8;
                    j20 = k2;
                    l20 = k3;
                } else
                {
                    j18 = j8 << 8;
                    j19 = j13 << 8;
                    j20 = k3;
                    l20 = k2;
                }
                if(j20 < 0)
                {
                    j18 -= l18 * j20;
                    j19 -= l19 * j20;
                    j20 = 0;
                }
                if(l20 > l14)
                    l20 = l14;
            }
            int j21 = 0;
            int l21 = 0;
            int j22 = 0;
            int l22 = 0;
            int i23 = 0xbc614e;
            int j23 = 0xff439eb2;
            if(k4 != k3)
            {
                l21 = (l9 - j8 << 8) / (k4 - k3);
                l22 = (l13 - j13 << 8) / (k4 - k3);
                if(k3 < k4)
                {
                    j21 = j8 << 8;
                    j22 = j13 << 8;
                    i23 = k3;
                    j23 = k4;
                } else
                {
                    j21 = l9 << 8;
                    j22 = l13 << 8;
                    i23 = k4;
                    j23 = k3;
                }
                if(i23 < 0)
                {
                    j21 -= l21 * i23;
                    j22 -= l22 * i23;
                    i23 = 0;
                }
                if(j23 > l14)
                    j23 = l14;
            }
            int k23 = 0;
            int l23 = 0;
            int i24 = 0;
            int j24 = 0;
            int k24 = 0xbc614e;
            int l24 = 0xff439eb2;
            if(k5 != k4)
            {
                l23 = (j11 - l9 << 8) / (k5 - k4);
                j24 = (j14 - l13 << 8) / (k5 - k4);
                if(k4 < k5)
                {
                    k23 = l9 << 8;
                    i24 = l13 << 8;
                    k24 = k4;
                    l24 = k5;
                } else
                {
                    k23 = j11 << 8;
                    i24 = j14 << 8;
                    k24 = k5;
                    l24 = k4;
                }
                if(k24 < 0)
                {
                    k23 -= l23 * k24;
                    i24 -= j24 * k24;
                    k24 = 0;
                }
                if(l24 > l14)
                    l24 = l14;
            }
            wo = j17;
            if(j20 < wo)
                wo = j20;
            if(i23 < wo)
                wo = i23;
            if(k24 < wo)
                wo = k24;
            xo = l17;
            if(l20 > xo)
                xo = l20;
            if(j23 > xo)
                xo = j23;
            if(l24 > xo)
                xo = l24;
            int i25 = 0;
            for(j1 = wo; j1 < xo; j1++)
            {
                if(j1 >= j17 && j1 < l17)
                {
                    l = i1 = j15;
                    k1 = i25 = j16;
                    j15 += l15;
                    j16 += l16;
                } else
                {
                    l = 0xa0000;
                    i1 = 0xfff60000;
                }
                if(j1 >= j20 && j1 < l20)
                {
                    if(j18 < l)
                    {
                        l = j18;
                        k1 = j19;
                    }
                    if(j18 > i1)
                    {
                        i1 = j18;
                        i25 = j19;
                    }
                    j18 += l18;
                    j19 += l19;
                }
                if(j1 >= i23 && j1 < j23)
                {
                    if(j21 < l)
                    {
                        l = j21;
                        k1 = j22;
                    }
                    if(j21 > i1)
                    {
                        i1 = j21;
                        i25 = j22;
                    }
                    j21 += l21;
                    j22 += l22;
                }
                if(j1 >= k24 && j1 < l24)
                {
                    if(k23 < l)
                    {
                        l = k23;
                        k1 = i24;
                    }
                    if(k23 > i1)
                    {
                        i1 = k23;
                        i25 = i24;
                    }
                    k23 += l23;
                    i24 += j24;
                }
                s s8 = vo[j1];
                s8.anb = l;
                s8.bnb = i1;
                s8.cnb = k1;
                s8.dnb = i25;
            }

            if(wo < dn - bn)
                wo = dn - bn;
        } else
        {
            xo = wo = ai2[0] += dn;
            for(j1 = 1; j1 < l1; j1++)
            {
                int l2;
                if((l2 = ai2[j1] += dn) < wo)
                    wo = l2;
                else
                if(l2 > xo)
                    xo = l2;
            }

            if(wo < dn - bn)
                wo = dn - bn;
            if(xo >= dn + bn)
                xo = (dn + bn) - 1;
            if(wo >= xo)
                return;
            for(j1 = wo; j1 < xo; j1++)
            {
                s s1 = vo[j1];
                s1.anb = 0xa0000;
                s1.bnb = 0xfff60000;
            }

            int i3 = l1 - 1;
            int l3 = ai2[0];
            int l4 = ai2[i3];
            if(l3 < l4)
            {
                int l5 = ai1[0] << 8;
                int i7 = (ai1[i3] - ai1[0] << 8) / (l4 - l3);
                int k8 = ai3[0] << 8;
                int i10 = (ai3[i3] - ai3[0] << 8) / (l4 - l3);
                if(l3 < 0)
                {
                    l5 -= i7 * l3;
                    k8 -= i10 * l3;
                    l3 = 0;
                }
                if(l4 > xo)
                    l4 = xo;
                for(j1 = l3; j1 <= l4; j1++)
                {
                    s s3 = vo[j1];
                    s3.anb = s3.bnb = l5;
                    s3.cnb = s3.dnb = k8;
                    l5 += i7;
                    k8 += i10;
                }

            } else
            if(l3 > l4)
            {
                int i6 = ai1[i3] << 8;
                int j7 = (ai1[0] - ai1[i3] << 8) / (l3 - l4);
                int l8 = ai3[i3] << 8;
                int j10 = (ai3[0] - ai3[i3] << 8) / (l3 - l4);
                if(l4 < 0)
                {
                    i6 -= j7 * l4;
                    l8 -= j10 * l4;
                    l4 = 0;
                }
                if(l3 > xo)
                    l3 = xo;
                for(j1 = l4; j1 <= l3; j1++)
                {
                    s s4 = vo[j1];
                    s4.anb = s4.bnb = i6;
                    s4.cnb = s4.dnb = l8;
                    i6 += j7;
                    l8 += j10;
                }

            }
            for(j1 = 0; j1 < i3; j1++)
            {
                int j6 = j1 + 1;
                int i4 = ai2[j1];
                int i5 = ai2[j6];
                if(i4 < i5)
                {
                    int k7 = ai1[j1] << 8;
                    int i9 = (ai1[j6] - ai1[j1] << 8) / (i5 - i4);
                    int k10 = ai3[j1] << 8;
                    int k11 = (ai3[j6] - ai3[j1] << 8) / (i5 - i4);
                    if(i4 < 0)
                    {
                        k7 -= i9 * i4;
                        k10 -= k11 * i4;
                        i4 = 0;
                    }
                    if(i5 > xo)
                        i5 = xo;
                    for(int k12 = i4; k12 <= i5; k12++)
                    {
                        s s5 = vo[k12];
                        if(k7 < s5.anb)
                        {
                            s5.anb = k7;
                            s5.cnb = k10;
                        }
                        if(k7 > s5.bnb)
                        {
                            s5.bnb = k7;
                            s5.dnb = k10;
                        }
                        k7 += i9;
                        k10 += k11;
                    }

                } else
                if(i4 > i5)
                {
                    int l7 = ai1[j6] << 8;
                    int j9 = (ai1[j1] - ai1[j6] << 8) / (i4 - i5);
                    int l10 = ai3[j6] << 8;
                    int l11 = (ai3[j1] - ai3[j6] << 8) / (i4 - i5);
                    if(i5 < 0)
                    {
                        l7 -= j9 * i5;
                        l10 -= l11 * i5;
                        i5 = 0;
                    }
                    if(i4 > xo)
                        i4 = xo;
                    for(int l12 = i5; l12 <= i4; l12++)
                    {
                        s s6 = vo[l12];
                        if(l7 < s6.anb)
                        {
                            s6.anb = l7;
                            s6.cnb = l10;
                        }
                        if(l7 > s6.bnb)
                        {
                            s6.bnb = l7;
                            s6.dnb = l10;
                        }
                        l7 += j9;
                        l10 += l11;
                    }

                }
            }

            if(wo < dn - bn)
                wo = dn - bn;
        }
        if(sm && vm < wm && um >= wo && um < xo)
        {
            s s2 = vo[um];
            if(tm >= s2.anb >> 8 && tm <= s2.bnb >> 8 && s2.anb <= s2.bnb && !h1.zh && h1.vh[i2] == 0)
            {
                xm[vm] = h1;
                ym[vm] = i2;
                vm++;
            }
        }
    }

    private void wh(int l, int i1, int j1, int ai1[], int ai2[], int ai3[], int k1, 
            h h1)
    {
        if(k1 >= 0)
        {
            if(k1 >= go)
                k1 = 0;
            ri(k1);
            int l1 = ai1[0];
            int j2 = ai2[0];
            int i3 = ai3[0];
            int l3 = l1 - ai1[1];
            int j4 = j2 - ai2[1];
            int l4 = i3 - ai3[1];
            j1--;
            int l6 = ai1[j1] - l1;
            int i8 = ai2[j1] - j2;
            int j9 = ai3[j1] - i3;
            if(jo[k1] == 1)
            {
                int k10 = l6 * j2 - i8 * l1 << 12;
                int j11 = i8 * i3 - j9 * j2 << (5 - en) + 7 + 4;
                int l11 = j9 * l1 - l6 * i3 << (5 - en) + 7;
                int j12 = l3 * j2 - j4 * l1 << 12;
                int l12 = j4 * i3 - l4 * j2 << (5 - en) + 7 + 4;
                int j13 = l4 * l1 - l3 * i3 << (5 - en) + 7;
                int l13 = j4 * l6 - l3 * i8 << 5;
                int j14 = l4 * i8 - j4 * j9 << (5 - en) + 4;
                int l14 = l3 * j9 - l4 * l6 >> en - 5;
                int j15 = j11 >> 4;
                int l15 = l12 >> 4;
                int j16 = j14 >> 4;
                int l16 = wo - dn;
                int j17 = zm;
                int l17 = cn + wo * j17;
                byte byte1 = 1;
                k10 += l11 * l16;
                j12 += j13 * l16;
                l13 += l14 * l16;
                if(ep)
                {
                    if((wo & 1) == 1)
                    {
                        wo++;
                        k10 += l11;
                        j12 += j13;
                        l13 += l14;
                        l17 += j17;
                    }
                    l11 <<= 1;
                    j13 <<= 1;
                    l14 <<= 1;
                    j17 <<= 1;
                    byte1 = 2;
                }
                if(h1.rh)
                {
                    for(l = wo; l < xo; l += byte1)
                    {
                        s s4 = vo[l];
                        i1 = s4.anb >> 8;
                        int j18 = s4.bnb >> 8;
                        int j21 = j18 - i1;
                        if(j21 <= 0)
                        {
                            k10 += l11;
                            j12 += j13;
                            l13 += l14;
                            l17 += j17;
                        } else
                        {
                            int l22 = s4.cnb;
                            int j24 = (s4.dnb - l22) / j21;
                            if(i1 < -an)
                            {
                                l22 += (-an - i1) * j24;
                                i1 = -an;
                                j21 = j18 - i1;
                            }
                            if(j18 > an)
                            {
                                int k18 = an;
                                j21 = k18 - i1;
                            }
                            vi(uo, mo[k1], cm, cm, k10 + j15 * i1, j12 + l15 * i1, l13 + j16 * i1, j11, l12, j14, j21, l17 + i1, l22, j24 << 2);
                            k10 += l11;
                            j12 += j13;
                            l13 += l14;
                            l17 += j17;
                        }
                    }

                    return;
                }
                if(!lo[k1])
                {
                    for(l = wo; l < xo; l += byte1)
                    {
                        s s5 = vo[l];
                        i1 = s5.anb >> 8;
                        int l18 = s5.bnb >> 8;
                        int k21 = l18 - i1;
                        if(k21 <= 0)
                        {
                            k10 += l11;
                            j12 += j13;
                            l13 += l14;
                            l17 += j17;
                        } else
                        {
                            int i23 = s5.cnb;
                            int k24 = (s5.dnb - i23) / k21;
                            if(i1 < -an)
                            {
                                i23 += (-an - i1) * k24;
                                i1 = -an;
                                k21 = l18 - i1;
                            }
                            if(l18 > an)
                            {
                                int i19 = an;
                                k21 = i19 - i1;
                            }
                            ai(uo, mo[k1], cm, cm, k10 + j15 * i1, j12 + l15 * i1, l13 + j16 * i1, j11, l12, j14, k21, l17 + i1, i23, k24 << 2);
                            k10 += l11;
                            j12 += j13;
                            l13 += l14;
                            l17 += j17;
                        }
                    }

                    return;
                }
                for(l = wo; l < xo; l += byte1)
                {
                    s s6 = vo[l];
                    i1 = s6.anb >> 8;
                    int j19 = s6.bnb >> 8;
                    int l21 = j19 - i1;
                    if(l21 <= 0)
                    {
                        k10 += l11;
                        j12 += j13;
                        l13 += l14;
                        l17 += j17;
                    } else
                    {
                        int j23 = s6.cnb;
                        int l24 = (s6.dnb - j23) / l21;
                        if(i1 < -an)
                        {
                            j23 += (-an - i1) * l24;
                            i1 = -an;
                            l21 = j19 - i1;
                        }
                        if(j19 > an)
                        {
                            int k19 = an;
                            l21 = k19 - i1;
                        }
                        oi(uo, cm, cm, cm, mo[k1], k10 + j15 * i1, j12 + l15 * i1, l13 + j16 * i1, j11, l12, j14, l21, l17 + i1, j23, l24);
                        k10 += l11;
                        j12 += j13;
                        l13 += l14;
                        l17 += j17;
                    }
                }

                return;
            }
            int l10 = l6 * j2 - i8 * l1 << 11;
            int k11 = i8 * i3 - j9 * j2 << (5 - en) + 6 + 4;
            int i12 = j9 * l1 - l6 * i3 << (5 - en) + 6;
            int k12 = l3 * j2 - j4 * l1 << 11;
            int i13 = j4 * i3 - l4 * j2 << (5 - en) + 6 + 4;
            int k13 = l4 * l1 - l3 * i3 << (5 - en) + 6;
            int i14 = j4 * l6 - l3 * i8 << 5;
            int k14 = l4 * i8 - j4 * j9 << (5 - en) + 4;
            int i15 = l3 * j9 - l4 * l6 >> en - 5;
            int k15 = k11 >> 4;
            int i16 = i13 >> 4;
            int k16 = k14 >> 4;
            int i17 = wo - dn;
            int k17 = zm;
            int i18 = cn + wo * k17;
            byte byte2 = 1;
            l10 += i12 * i17;
            k12 += k13 * i17;
            i14 += i15 * i17;
            if(ep)
            {
                if((wo & 1) == 1)
                {
                    wo++;
                    l10 += i12;
                    k12 += k13;
                    i14 += i15;
                    i18 += k17;
                }
                i12 <<= 1;
                k13 <<= 1;
                i15 <<= 1;
                k17 <<= 1;
                byte2 = 2;
            }
            if(h1.rh)
            {
                for(l = wo; l < xo; l += byte2)
                {
                    s s7 = vo[l];
                    i1 = s7.anb >> 8;
                    int l19 = s7.bnb >> 8;
                    int i22 = l19 - i1;
                    if(i22 <= 0)
                    {
                        l10 += i12;
                        k12 += k13;
                        i14 += i15;
                        i18 += k17;
                    } else
                    {
                        int k23 = s7.cnb;
                        int i25 = (s7.dnb - k23) / i22;
                        if(i1 < -an)
                        {
                            k23 += (-an - i1) * i25;
                            i1 = -an;
                            i22 = l19 - i1;
                        }
                        if(l19 > an)
                        {
                            int i20 = an;
                            i22 = i20 - i1;
                        }
                        di(uo, mo[k1], cm, cm, l10 + k15 * i1, k12 + i16 * i1, i14 + k16 * i1, k11, i13, k14, i22, i18 + i1, k23, i25);
                        l10 += i12;
                        k12 += k13;
                        i14 += i15;
                        i18 += k17;
                    }
                }

                return;
            }
            if(!lo[k1])
            {
                for(l = wo; l < xo; l += byte2)
                {
                    s s8 = vo[l];
                    i1 = s8.anb >> 8;
                    int j20 = s8.bnb >> 8;
                    int j22 = j20 - i1;
                    if(j22 <= 0)
                    {
                        l10 += i12;
                        k12 += k13;
                        i14 += i15;
                        i18 += k17;
                    } else
                    {
                        int l23 = s8.cnb;
                        int j25 = (s8.dnb - l23) / j22;
                        if(i1 < -an)
                        {
                            l23 += (-an - i1) * j25;
                            i1 = -an;
                            j22 = j20 - i1;
                        }
                        if(j20 > an)
                        {
                            int k20 = an;
                            j22 = k20 - i1;
                        }
                        wi(uo, mo[k1], cm, cm, l10 + k15 * i1, k12 + i16 * i1, i14 + k16 * i1, k11, i13, k14, j22, i18 + i1, l23, j25);
                        l10 += i12;
                        k12 += k13;
                        i14 += i15;
                        i18 += k17;
                    }
                }

                return;
            }
            for(l = wo; l < xo; l += byte2)
            {
                s s9 = vo[l];
                i1 = s9.anb >> 8;
                int l20 = s9.bnb >> 8;
                int k22 = l20 - i1;
                if(k22 <= 0)
                {
                    l10 += i12;
                    k12 += k13;
                    i14 += i15;
                    i18 += k17;
                } else
                {
                    int i24 = s9.cnb;
                    int k25 = (s9.dnb - i24) / k22;
                    if(i1 < -an)
                    {
                        i24 += (-an - i1) * k25;
                        i1 = -an;
                        k22 = l20 - i1;
                    }
                    if(l20 > an)
                    {
                        int i21 = an;
                        k22 = i21 - i1;
                    }
                    zh(uo, cm, cm, cm, mo[k1], l10 + k15 * i1, k12 + i16 * i1, i14 + k16 * i1, k11, i13, k14, k22, i18 + i1, i24, k25);
                    l10 += i12;
                    k12 += k13;
                    i14 += i15;
                    i18 += k17;
                }
            }

            return;
        }
        for(int i2 = 0; i2 < dm; i2++)
        {
            if(em[i2] == k1)
            {
                gm = fm[i2];
                break;
            }
            if(i2 == dm - 1)
            {
                int k2 = (int)(Math.random() * (double)dm);
                em[k2] = k1;
                k1 = -1 - k1;
                int j3 = (k1 >> 10 & 0x1f) * 8;
                int i4 = (k1 >> 5 & 0x1f) * 8;
                int k4 = (k1 & 0x1f) * 8;
                for(int i5 = 0; i5 < 256; i5++)
                {
                    int i7 = i5 * i5;
                    int j8 = (j3 * i7) / 0x10000;
                    int k9 = (i4 * i7) / 0x10000;
                    int i11 = (k4 * i7) / 0x10000;
                    fm[k2][255 - i5] = (j8 << 16) + (k9 << 8) + i11;
                }

                gm = fm[k2];
            }
        }

        int l2 = zm;
        int k3 = cn + wo * l2;
        byte byte0 = 1;
        if(ep)
        {
            if((wo & 1) == 1)
            {
                wo++;
                k3 += l2;
            }
            l2 <<= 1;
            byte0 = 2;
        }
        if(h1.sh)
        {
            for(l = wo; l < xo; l += byte0)
            {
                s s1 = vo[l];
                i1 = s1.anb >> 8;
                int j5 = s1.bnb >> 8;
                int j7 = j5 - i1;
                if(j7 <= 0)
                {
                    k3 += l2;
                } else
                {
                    int k8 = s1.cnb;
                    int l9 = (s1.dnb - k8) / j7;
                    if(i1 < -an)
                    {
                        k8 += (-an - i1) * l9;
                        i1 = -an;
                        j7 = j5 - i1;
                    }
                    if(j5 > an)
                    {
                        int k5 = an;
                        j7 = k5 - i1;
                    }
                    ni(uo, -j7, k3 + i1, cm, gm, k8, l9);
                    k3 += l2;
                }
            }

            return;
        }
        if(pm)
        {
            for(l = wo; l < xo; l += byte0)
            {
                s s2 = vo[l];
                i1 = s2.anb >> 8;
                int l5 = s2.bnb >> 8;
                int k7 = l5 - i1;
                if(k7 <= 0)
                {
                    k3 += l2;
                } else
                {
                    int l8 = s2.cnb;
                    int i10 = (s2.dnb - l8) / k7;
                    if(i1 < -an)
                    {
                        l8 += (-an - i1) * i10;
                        i1 = -an;
                        k7 = l5 - i1;
                    }
                    if(l5 > an)
                    {
                        int i6 = an;
                        k7 = i6 - i1;
                    }
                    qh(uo, -k7, k3 + i1, cm, gm, l8, i10);
                    k3 += l2;
                }
            }

            return;
        }
        for(l = wo; l < xo; l += byte0)
        {
            s s3 = vo[l];
            i1 = s3.anb >> 8;
            int j6 = s3.bnb >> 8;
            int l7 = j6 - i1;
            if(l7 <= 0)
            {
                k3 += l2;
            } else
            {
                int i9 = s3.cnb;
                int j10 = (s3.dnb - i9) / l7;
                if(i1 < -an)
                {
                    i9 += (-an - i1) * j10;
                    i1 = -an;
                    l7 = j6 - i1;
                }
                if(j6 > an)
                {
                    int k6 = an;
                    l7 = k6 - i1;
                }
                ei(uo, -l7, k3 + i1, cm, gm, i9, j10);
                k3 += l2;
            }
        }

    }

    private static void ai(int ai1[], int ai2[], int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3)
    {
        if(l2 <= 0)
            return;
        int l3 = 0;
        int i4 = 0;
        int l4 = 0;
        if(l1 != 0)
        {
            l = j1 / l1 << 7;
            i1 = k1 / l1 << 7;
        }
        if(l < 0)
            l = 0;
        else
        if(l > 16256)
            l = 16256;
        j1 += i2;
        k1 += j2;
        l1 += k2;
        if(l1 != 0)
        {
            l3 = j1 / l1 << 7;
            i4 = k1 / l1 << 7;
        }
        if(l3 < 0)
            l3 = 0;
        else
        if(l3 > 16256)
            l3 = 16256;
        int j4 = l3 - l >> 4;
        int k4 = i4 - i1 >> 4;
        for(int i5 = l2 >> 4; i5 > 0; i5--)
        {
            l += j3 & 0x600000;
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l = l3;
            i1 = i4;
            j1 += i2;
            k1 += j2;
            l1 += k2;
            if(l1 != 0)
            {
                l3 = j1 / l1 << 7;
                i4 = k1 / l1 << 7;
            }
            if(l3 < 0)
                l3 = 0;
            else
            if(l3 > 16256)
                l3 = 16256;
            j4 = l3 - l >> 4;
            k4 = i4 - i1 >> 4;
        }

        for(int j5 = 0; j5 < (l2 & 0xf); j5++)
        {
            if((j5 & 3) == 0)
            {
                l = (l & 0x3fff) + (j3 & 0x600000);
                l4 = j3 >> 23;
                j3 += k3;
            }
            ai1[i3++] = ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4;
            l += j4;
            i1 += k4;
        }

    }

    private static void vi(int ai1[], int ai2[], int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3)
    {
        if(l2 <= 0)
            return;
        int l3 = 0;
        int i4 = 0;
        int l4 = 0;
        if(l1 != 0)
        {
            l = j1 / l1 << 7;
            i1 = k1 / l1 << 7;
        }
        if(l < 0)
            l = 0;
        else
        if(l > 16256)
            l = 16256;
        j1 += i2;
        k1 += j2;
        l1 += k2;
        if(l1 != 0)
        {
            l3 = j1 / l1 << 7;
            i4 = k1 / l1 << 7;
        }
        if(l3 < 0)
            l3 = 0;
        else
        if(l3 > 16256)
            l3 = 16256;
        int j4 = l3 - l >> 4;
        int k4 = i4 - i1 >> 4;
        for(int i5 = l2 >> 4; i5 > 0; i5--)
        {
            l += j3 & 0x600000;
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            l = (l & 0x3fff) + (j3 & 0x600000);
            l4 = j3 >> 23;
            j3 += k3;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l = l3;
            i1 = i4;
            j1 += i2;
            k1 += j2;
            l1 += k2;
            if(l1 != 0)
            {
                l3 = j1 / l1 << 7;
                i4 = k1 / l1 << 7;
            }
            if(l3 < 0)
                l3 = 0;
            else
            if(l3 > 16256)
                l3 = 16256;
            j4 = l3 - l >> 4;
            k4 = i4 - i1 >> 4;
        }

        for(int j5 = 0; j5 < (l2 & 0xf); j5++)
        {
            if((j5 & 3) == 0)
            {
                l = (l & 0x3fff) + (j3 & 0x600000);
                l4 = j3 >> 23;
                j3 += k3;
            }
            ai1[i3++] = (ai2[(i1 & 0x3f80) + (l >> 7)] >>> l4) + (ai1[i3] >> 1 & 0x7f7f7f);
            l += j4;
            i1 += k4;
        }

    }

    private static void oi(int ai1[], int l, int i1, int j1, int ai2[], int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3)
    {
        if(i3 <= 0)
            return;
        int i4 = 0;
        int j4 = 0;
        l3 <<= 2;
        if(i2 != 0)
        {
            i4 = k1 / i2 << 7;
            j4 = l1 / i2 << 7;
        }
        if(i4 < 0)
            i4 = 0;
        else
        if(i4 > 16256)
            i4 = 16256;
        for(int i5 = i3; i5 > 0; i5 -= 16)
        {
            k1 += j2;
            l1 += k2;
            i2 += l2;
            i1 = i4;
            j1 = j4;
            if(i2 != 0)
            {
                i4 = k1 / i2 << 7;
                j4 = l1 / i2 << 7;
            }
            if(i4 < 0)
                i4 = 0;
            else
            if(i4 > 16256)
                i4 = 16256;
            int k4 = i4 - i1 >> 4;
            int l4 = j4 - j1 >> 4;
            int j5 = k3 >> 23;
            i1 += k3 & 0x600000;
            k3 += l3;
            if(i5 < 16)
            {
                for(int k5 = 0; k5 < i5; k5++)
                {
                    if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                        ai1[j3] = l;
                    j3++;
                    i1 += k4;
                    j1 += l4;
                    if((k5 & 3) == 3)
                    {
                        i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                        j5 = k3 >> 23;
                        k3 += l3;
                    }
                }

            } else
            {
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                j5 = k3 >> 23;
                k3 += l3;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                j5 = k3 >> 23;
                k3 += l3;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                j5 = k3 >> 23;
                k3 += l3;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0x3f80) + (i1 >> 7)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
            }
        }

    }

    private static void wi(int ai1[], int ai2[], int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3)
    {
        if(l2 <= 0)
            return;
        int l3 = 0;
        int i4 = 0;
        k3 <<= 2;
        if(l1 != 0)
        {
            l3 = j1 / l1 << 6;
            i4 = k1 / l1 << 6;
        }
        if(l3 < 0)
            l3 = 0;
        else
        if(l3 > 4032)
            l3 = 4032;
        for(int l4 = l2; l4 > 0; l4 -= 16)
        {
            j1 += i2;
            k1 += j2;
            l1 += k2;
            l = l3;
            i1 = i4;
            if(l1 != 0)
            {
                l3 = j1 / l1 << 6;
                i4 = k1 / l1 << 6;
            }
            if(l3 < 0)
                l3 = 0;
            else
            if(l3 > 4032)
                l3 = 4032;
            int j4 = l3 - l >> 4;
            int k4 = i4 - i1 >> 4;
            int i5 = j3 >> 20;
            l += j3 & 0xc0000;
            j3 += k3;
            if(l4 < 16)
            {
                for(int j5 = 0; j5 < l4; j5++)
                {
                    ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                    l += j4;
                    i1 += k4;
                    if((j5 & 3) == 3)
                    {
                        l = (l & 0xfff) + (j3 & 0xc0000);
                        i5 = j3 >> 20;
                        j3 += k3;
                    }
                }

            } else
            {
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
                l += j4;
                i1 += k4;
                ai1[i3++] = ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5;
            }
        }

    }

    private static void di(int ai1[], int ai2[], int l, int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3)
    {
        if(l2 <= 0)
            return;
        int l3 = 0;
        int i4 = 0;
        k3 <<= 2;
        if(l1 != 0)
        {
            l3 = j1 / l1 << 6;
            i4 = k1 / l1 << 6;
        }
        if(l3 < 0)
            l3 = 0;
        else
        if(l3 > 4032)
            l3 = 4032;
        for(int l4 = l2; l4 > 0; l4 -= 16)
        {
            j1 += i2;
            k1 += j2;
            l1 += k2;
            l = l3;
            i1 = i4;
            if(l1 != 0)
            {
                l3 = j1 / l1 << 6;
                i4 = k1 / l1 << 6;
            }
            if(l3 < 0)
                l3 = 0;
            else
            if(l3 > 4032)
                l3 = 4032;
            int j4 = l3 - l >> 4;
            int k4 = i4 - i1 >> 4;
            int i5 = j3 >> 20;
            l += j3 & 0xc0000;
            j3 += k3;
            if(l4 < 16)
            {
                for(int j5 = 0; j5 < l4; j5++)
                {
                    ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                    l += j4;
                    i1 += k4;
                    if((j5 & 3) == 3)
                    {
                        l = (l & 0xfff) + (j3 & 0xc0000);
                        i5 = j3 >> 20;
                        j3 += k3;
                    }
                }

            } else
            {
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                l = (l & 0xfff) + (j3 & 0xc0000);
                i5 = j3 >> 20;
                j3 += k3;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
                l += j4;
                i1 += k4;
                ai1[i3++] = (ai2[(i1 & 0xfc0) + (l >> 6)] >>> i5) + (ai1[i3] >> 1 & 0x7f7f7f);
            }
        }

    }

    private static void zh(int ai1[], int l, int i1, int j1, int ai2[], int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3)
    {
        if(i3 <= 0)
            return;
        int i4 = 0;
        int j4 = 0;
        l3 <<= 2;
        if(i2 != 0)
        {
            i4 = k1 / i2 << 6;
            j4 = l1 / i2 << 6;
        }
        if(i4 < 0)
            i4 = 0;
        else
        if(i4 > 4032)
            i4 = 4032;
        for(int i5 = i3; i5 > 0; i5 -= 16)
        {
            k1 += j2;
            l1 += k2;
            i2 += l2;
            i1 = i4;
            j1 = j4;
            if(i2 != 0)
            {
                i4 = k1 / i2 << 6;
                j4 = l1 / i2 << 6;
            }
            if(i4 < 0)
                i4 = 0;
            else
            if(i4 > 4032)
                i4 = 4032;
            int k4 = i4 - i1 >> 4;
            int l4 = j4 - j1 >> 4;
            int j5 = k3 >> 20;
            i1 += k3 & 0xc0000;
            k3 += l3;
            if(i5 < 16)
            {
                for(int k5 = 0; k5 < i5; k5++)
                {
                    if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                        ai1[j3] = l;
                    j3++;
                    i1 += k4;
                    j1 += l4;
                    if((k5 & 3) == 3)
                    {
                        i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                        j5 = k3 >> 20;
                        k3 += l3;
                    }
                }

            } else
            {
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                j5 = k3 >> 20;
                k3 += l3;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                j5 = k3 >> 20;
                k3 += l3;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                j5 = k3 >> 20;
                k3 += l3;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
                i1 += k4;
                j1 += l4;
                if((l = ai2[(j1 & 0xfc0) + (i1 >> 6)] >>> j5) != 0)
                    ai1[j3] = l;
                j3++;
            }
        }

    }

    private static void qh(int ai1[], int l, int i1, int j1, int ai2[], int k1, int l1)
    {
        if(l >= 0)
            return;
        l1 <<= 1;
        j1 = ai2[k1 >> 8 & 0xff];
        k1 += l1;
        int i2 = l / 8;
        for(int j2 = i2; j2 < 0; j2++)
        {
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
        }

        i2 = -(l % 8);
        for(int k2 = 0; k2 < i2; k2++)
        {
            ai1[i1++] = j1;
            if((k2 & 1) == 1)
            {
                j1 = ai2[k1 >> 8 & 0xff];
                k1 += l1;
            }
        }

    }

    private static void ni(int ai1[], int l, int i1, int j1, int ai2[], int k1, int l1)
    {
        if(l >= 0)
            return;
        l1 <<= 2;
        j1 = ai2[k1 >> 8 & 0xff];
        k1 += l1;
        int i2 = l / 16;
        for(int j2 = i2; j2 < 0; j2++)
        {
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
        }

        i2 = -(l % 16);
        for(int k2 = 0; k2 < i2; k2++)
        {
            ai1[i1++] = j1 + (ai1[i1] >> 1 & 0x7f7f7f);
            if((k2 & 3) == 3)
            {
                j1 = ai2[k1 >> 8 & 0xff];
                k1 += l1;
                k1 += l1;
            }
        }

    }

    private static void ei(int ai1[], int l, int i1, int j1, int ai2[], int k1, int l1)
    {
        if(l >= 0)
            return;
        l1 <<= 2;
        j1 = ai2[k1 >> 8 & 0xff];
        k1 += l1;
        int i2 = l / 16;
        for(int j2 = i2; j2 < 0; j2++)
        {
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            ai1[i1++] = j1;
            j1 = ai2[k1 >> 8 & 0xff];
            k1 += l1;
        }

        i2 = -(l % 16);
        for(int k2 = 0; k2 < i2; k2++)
        {
            ai1[i1++] = j1;
            if((k2 & 3) == 3)
            {
                j1 = ai2[k1 >> 8 & 0xff];
                k1 += l1;
            }
        }

    }

    public void gi(int l, int i1, int j1, int k1, int l1, int i2, int j2)
    {
        k1 &= 0x3ff;
        l1 &= 0x3ff;
        i2 &= 0x3ff;
        jn = 1024 - k1 & 0x3ff;
        kn = 1024 - l1 & 0x3ff;
        ln = 1024 - i2 & 0x3ff;
        int k2 = 0;
        int l2 = 0;
        int i3 = j2;
        if(k1 != 0)
        {
            int j3 = nm[k1];
            int i4 = nm[k1 + 1024];
            int l4 = l2 * i4 - i3 * j3 >> 15;
            i3 = l2 * j3 + i3 * i4 >> 15;
            l2 = l4;
        }
        if(l1 != 0)
        {
            int k3 = nm[l1];
            int j4 = nm[l1 + 1024];
            int i5 = i3 * k3 + k2 * j4 >> 15;
            i3 = i3 * j4 - k2 * k3 >> 15;
            k2 = i5;
        }
        if(i2 != 0)
        {
            int l3 = nm[i2];
            int k4 = nm[i2 + 1024];
            int j5 = l2 * l3 + k2 * k4 >> 15;
            l2 = l2 * k4 - k2 * l3 >> 15;
            k2 = j5;
        }
        gn = l - k2;
        hn = i1 - l2;
        in = j1 - i3;
    }

    private void dj(int l)
    {
        q q1 = rn[l];
        h h1 = q1.mhb;
        int i1 = q1.nhb;
        int ai1[] = h1.xg[i1];
        int j1 = h1.wg[i1];
        int k1 = h1.bh[i1];
        int i2 = h1.og[ai1[0]];
        int j2 = h1.pg[ai1[0]];
        int k2 = h1.qg[ai1[0]];
        int l2 = h1.og[ai1[1]] - i2;
        int i3 = h1.pg[ai1[1]] - j2;
        int j3 = h1.qg[ai1[1]] - k2;
        int k3 = h1.og[ai1[2]] - i2;
        int l3 = h1.pg[ai1[2]] - j2;
        int i4 = h1.qg[ai1[2]] - k2;
        int j4 = i3 * i4 - l3 * j3;
        int k4 = j3 * k3 - i4 * l2;
        int l4 = l2 * l3 - k3 * i3;
        if(k1 == -1)
        {
            k1 = 0;
            for(; j4 > 25000 || k4 > 25000 || l4 > 25000 || j4 < -25000 || k4 < -25000 || l4 < -25000; l4 >>= 1)
            {
                k1++;
                j4 >>= 1;
                k4 >>= 1;
            }

            h1.bh[i1] = k1;
            h1.ah[i1] = (int)((double)fn * Math.sqrt(j4 * j4 + k4 * k4 + l4 * l4));
        } else
        {
            j4 >>= k1;
            k4 >>= k1;
            l4 >>= k1;
        }
        q1.shb = i2 * j4 + j2 * k4 + k2 * l4;
        q1.phb = j4;
        q1.qhb = k4;
        q1.rhb = l4;
        int i5 = h1.qg[ai1[0]];
        int j5 = i5;
        int k5 = h1.rg[ai1[0]];
        int l5 = k5;
        int i6 = h1.sg[ai1[0]];
        int j6 = i6;
        for(int k6 = 1; k6 < j1; k6++)
        {
            int l1 = h1.qg[ai1[k6]];
            if(l1 > j5)
                j5 = l1;
            else
            if(l1 < i5)
                i5 = l1;
            l1 = h1.rg[ai1[k6]];
            if(l1 > l5)
                l5 = l1;
            else
            if(l1 < k5)
                k5 = l1;
            l1 = h1.sg[ai1[k6]];
            if(l1 > j6)
                j6 = l1;
            else
            if(l1 < i6)
                i6 = l1;
        }

        q1.khb = i5;
        q1.lhb = j5;
        q1.ghb = k5;
        q1.ihb = l5;
        q1.hhb = i6;
        q1.jhb = j6;
    }

    private void gj(int l)
    {
        q q1 = rn[l];
        h h1 = q1.mhb;
        int i1 = q1.nhb;
        int ai1[] = h1.xg[i1];
        int k1 = 0;
        int l1 = 0;
        int i2 = 1;
        int j2 = h1.og[ai1[0]];
        int k2 = h1.pg[ai1[0]];
        int l2 = h1.qg[ai1[0]];
        h1.ah[i1] = 1;
        h1.bh[i1] = 0;
        q1.shb = j2 * k1 + k2 * l1 + l2 * i2;
        q1.phb = k1;
        q1.qhb = l1;
        q1.rhb = i2;
        int i3 = h1.qg[ai1[0]];
        int j3 = i3;
        int k3 = h1.rg[ai1[0]];
        int l3 = k3;
        if(h1.rg[ai1[1]] < k3)
            k3 = h1.rg[ai1[1]];
        else
            l3 = h1.rg[ai1[1]];
        int i4 = h1.sg[ai1[1]];
        int j4 = h1.sg[ai1[0]];
        int j1 = h1.qg[ai1[1]];
        if(j1 > j3)
            j3 = j1;
        else
        if(j1 < i3)
            i3 = j1;
        j1 = h1.rg[ai1[1]];
        if(j1 > l3)
            l3 = j1;
        else
        if(j1 < k3)
            k3 = j1;
        j1 = h1.sg[ai1[1]];
        if(j1 > j4)
            j4 = j1;
        else
        if(j1 < i4)
            i4 = j1;
        q1.khb = i3;
        q1.lhb = j3;
        q1.ghb = k3 - 20;
        q1.ihb = l3 + 20;
        q1.hhb = i4;
        q1.jhb = j4;
    }

    private boolean ph(q q1, q q2)
    {
        if(q1.ghb >= q2.ihb)
            return true;
        if(q2.ghb >= q1.ihb)
            return true;
        if(q1.hhb >= q2.jhb)
            return true;
        if(q2.hhb >= q1.jhb)
            return true;
        if(q1.khb >= q2.lhb)
            return true;
        if(q2.khb > q1.lhb)
            return false;
        h h1 = q1.mhb;
        h h2 = q2.mhb;
        int l = q1.nhb;
        int i1 = q2.nhb;
        int ai1[] = h1.xg[l];
        int ai2[] = h2.xg[i1];
        int j1 = h1.wg[l];
        int k1 = h2.wg[i1];
        int j3 = h2.og[ai2[0]];
        int k3 = h2.pg[ai2[0]];
        int l3 = h2.qg[ai2[0]];
        int i4 = q2.phb;
        int j4 = q2.qhb;
        int k4 = q2.rhb;
        int l4 = h2.ah[i1];
        int i5 = q2.shb;
        boolean flag = false;
        for(int j5 = 0; j5 < j1; j5++)
        {
            int l1 = ai1[j5];
            int l2 = (j3 - h1.og[l1]) * i4 + (k3 - h1.pg[l1]) * j4 + (l3 - h1.qg[l1]) * k4;
            if((l2 >= -l4 || i5 >= 0) && (l2 <= l4 || i5 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        j3 = h1.og[ai1[0]];
        k3 = h1.pg[ai1[0]];
        l3 = h1.qg[ai1[0]];
        i4 = q1.phb;
        j4 = q1.qhb;
        k4 = q1.rhb;
        l4 = h1.ah[l];
        i5 = q1.shb;
        flag = false;
        for(int k5 = 0; k5 < k1; k5++)
        {
            int i2 = ai2[k5];
            int i3 = (j3 - h2.og[i2]) * i4 + (k3 - h2.pg[i2]) * j4 + (l3 - h2.qg[i2]) * k4;
            if((i3 >= -l4 || i5 <= 0) && (i3 <= l4 || i5 >= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        int ai3[];
        int ai4[];
        if(j1 == 2)
        {
            ai3 = new int[4];
            ai4 = new int[4];
            int l5 = ai1[0];
            int j2 = ai1[1];
            ai3[0] = h1.rg[l5] - 20;
            ai3[1] = h1.rg[j2] - 20;
            ai3[2] = h1.rg[j2] + 20;
            ai3[3] = h1.rg[l5] + 20;
            ai4[0] = ai4[3] = h1.sg[l5];
            ai4[1] = ai4[2] = h1.sg[j2];
        } else
        {
            ai3 = new int[j1];
            ai4 = new int[j1];
            for(int i6 = 0; i6 < j1; i6++)
            {
                int l6 = ai1[i6];
                ai3[i6] = h1.rg[l6];
                ai4[i6] = h1.sg[l6];
            }

        }
        int ai5[];
        int ai6[];
        if(k1 == 2)
        {
            ai5 = new int[4];
            ai6 = new int[4];
            int j6 = ai2[0];
            int k2 = ai2[1];
            ai5[0] = h2.rg[j6] - 20;
            ai5[1] = h2.rg[k2] - 20;
            ai5[2] = h2.rg[k2] + 20;
            ai5[3] = h2.rg[j6] + 20;
            ai6[0] = ai6[3] = h2.sg[j6];
            ai6[1] = ai6[2] = h2.sg[k2];
        } else
        {
            ai5 = new int[k1];
            ai6 = new int[k1];
            for(int k6 = 0; k6 < k1; k6++)
            {
                int i7 = ai2[k6];
                ai5[k6] = h2.rg[i7];
                ai6[k6] = h2.sg[i7];
            }

        }
        return !rh(ai3, ai4, ai5, ai6);
    }

    private boolean nh(q q1, q q2)
    {
        h h1 = q1.mhb;
        h h2 = q2.mhb;
        int l = q1.nhb;
        int i1 = q2.nhb;
        int ai1[] = h1.xg[l];
        int ai2[] = h2.xg[i1];
        int j1 = h1.wg[l];
        int k1 = h2.wg[i1];
        int l2 = h2.og[ai2[0]];
        int i3 = h2.pg[ai2[0]];
        int j3 = h2.qg[ai2[0]];
        int k3 = q2.phb;
        int l3 = q2.qhb;
        int i4 = q2.rhb;
        int j4 = h2.ah[i1];
        int k4 = q2.shb;
        boolean flag = false;
        for(int l4 = 0; l4 < j1; l4++)
        {
            int l1 = ai1[l4];
            int j2 = (l2 - h1.og[l1]) * k3 + (i3 - h1.pg[l1]) * l3 + (j3 - h1.qg[l1]) * i4;
            if((j2 >= -j4 || k4 >= 0) && (j2 <= j4 || k4 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        l2 = h1.og[ai1[0]];
        i3 = h1.pg[ai1[0]];
        j3 = h1.qg[ai1[0]];
        k3 = q1.phb;
        l3 = q1.qhb;
        i4 = q1.rhb;
        j4 = h1.ah[l];
        k4 = q1.shb;
        flag = false;
        for(int i5 = 0; i5 < k1; i5++)
        {
            int i2 = ai2[i5];
            int k2 = (l2 - h2.og[i2]) * k3 + (i3 - h2.pg[i2]) * l3 + (j3 - h2.qg[i2]) * i4;
            if((k2 >= -j4 || k4 <= 0) && (k2 <= j4 || k4 >= 0))
                continue;
            flag = true;
            break;
        }

        return !flag;
    }

    public void lh(String s1, int l, int i1, int j1, k k1)
    {
        try
        {
            oo = k1.jj(s1, "textures", j1);
            byte abyte0[] = o.ln("textures.txt", 0, oo);
            a a1 = new a(abyte0);
            a1.zb();
            go = a1.gc();
            ho = new String[go];
            lo = new boolean[go];
            ko = new long[go];
            io = new int[go];
            jo = new int[go];
            mo = new int[go][];
            for(int l1 = 0; l1 < go; l1++)
            {
                a1.zb();
                ho[l1] = a1.ac();
                io[l1] = a1.lb();
                jo[l1] = a1.gc();
                lo[l1] = false;
                mo[l1] = null;
                ko[l1] = 0L;
            }

            no = 0L;
            po = new int[l][];
            qo = new int[i1][];
            for(int i2 = 0; i2 < go; i2++)
                ri(i2);

            return;
        }
        catch(IOException _ex)
        {
            System.out.println("Error loading texture set");
        }
    }

    public void mi(int l)
    {
        if(mo[l] == null)
            return;
        int ai1[] = mo[l];
        for(int i1 = 0; i1 < 64; i1++)
        {
            int j1 = i1 + 4032;
            int k1 = ai1[j1];
            for(int i2 = 0; i2 < 63; i2++)
            {
                ai1[j1] = ai1[j1 - 64];
                j1 -= 64;
            }

            mo[l][j1] = k1;
        }

        char c = '\u1000';
        for(int l1 = 0; l1 < c; l1++)
        {
            int j2 = ai1[l1];
            ai1[c + l1] = j2 - (j2 >>> 3) & 0xf8f8ff;
            ai1[c * 2 + l1] = j2 - (j2 >>> 2) & 0xf8f8ff;
            ai1[c * 3 + l1] = j2 - (j2 >>> 2) - (j2 >>> 3) & 0xf8f8ff;
        }

    }

    public void ri(int l)
    {
        if(l < 0)
            return;
        ko[l] = no++;
        if(mo[l] != null)
            return;
        if(jo[l] == 0)
        {
            for(int i1 = 0; i1 < po.length; i1++)
                if(po[i1] == null)
                {
                    po[i1] = new int[16384];
                    mo[l] = po[i1];
                    o.eo(ho[l] + ".tga", 0, oo, ro);
                    pi(l);
                    return;
                }

            long l1 = 1L << 30;
            int k1 = 0;
            for(int j2 = 0; j2 < go; j2++)
                if(j2 != l && jo[j2] == 0 && mo[j2] != null && ko[j2] < l1)
                {
                    l1 = ko[j2];
                    k1 = j2;
                }

            mo[l] = mo[k1];
            mo[k1] = null;
            o.eo(ho[l] + ".tga", 0, oo, ro);
            pi(l);
            return;
        }
        for(int j1 = 0; j1 < qo.length; j1++)
            if(qo[j1] == null)
            {
                qo[j1] = new int[0x10000];
                mo[l] = qo[j1];
                o.eo(ho[l] + ".tga", 0, oo, ro);
                pi(l);
                return;
            }

        long l2 = 1L << 30;
        int i2 = 0;
        for(int k2 = 0; k2 < go; k2++)
            if(k2 != l && jo[k2] == 1 && mo[k2] != null && ko[k2] < l2)
            {
                l2 = ko[k2];
                i2 = k2;
            }

        mo[l] = mo[i2];
        mo[i2] = null;
        o.eo(ho[l] + ".tga", 0, oo, ro);
        pi(l);
    }

    public void si(String s1)
    {
        try
        {
            a a1 = new a(s1 + "/textures.txt");
            a1.zb();
            go = a1.gc();
            ho = new String[go];
            lo = new boolean[go];
            ko = new long[go];
            io = new int[go];
            jo = new int[go];
            mo = new int[go][];
            for(int l = 0; l < go; l++)
            {
                a1.zb();
                ho[l] = a1.ac();
                io[l] = a1.lb();
                jo[l] = a1.gc();
                lo[l] = false;
            }

            a1.hb();
            for(int i1 = 0; i1 < go; i1++)
            {
                char c;
                if(jo[i1] == 0)
                    c = '\u151B';
                else
                    c = '\u451B';
                char c1;
                if(jo[i1] == 0)
                    c1 = '@';
                else
                    c1 = '\200';
                mo[i1] = new int[c1 * c1 * 4];
                o.in(s1 + "/" + ho[i1] + ".tga", ro, c);
                pi(i1);
            }

            return;
        }
        catch(IOException _ex)
        {
            System.out.println("Error loading texture set");
        }
    }

    private void pi(int l)
    {
        char c;
        if(jo[l] == 0)
            c = '@';
        else
            c = '\200';
        int ai1[] = mo[l];
        int i1 = 0;
        for(int j1 = 0; j1 < 256; j1++)
            so[j1] = ((ro[20 + j1 * 3] & 0xff) << 16) + ((ro[19 + j1 * 3] & 0xff) << 8) + (ro[18 + j1 * 3] & 0xff);

        for(int k1 = c - 1; k1 >= 0; k1--)
        {
            for(int l1 = 0; l1 < c; l1++)
            {
                int j2 = so[ro[786 + l1 + k1 * c] & 0xff];
                if(j2 != 0xff00ff && io[l] != 0)
                {
                    int l2 = j2 >> 16 & 0xff;
                    int i3 = j2 >> 8 & 0xff;
                    int j3 = j2 & 0xff;
                    if(l2 == i3 && i3 == j3)
                    {
                        int k3 = io[l] >> 16 & 0xff;
                        int l3 = io[l] >> 8 & 0xff;
                        int i4 = io[l] & 0xff;
                        j2 = ((l2 * k3 >> 8) << 16) + ((i3 * l3 >> 8) << 8) + (j3 * i4 >> 8);
                    }
                }
                j2 &= 0xf8f8ff;
                if(j2 == 0)
                    j2 = 1;
                else
                if(j2 == 0xf800ff)
                {
                    j2 = 0;
                    lo[l] = true;
                }
                ai1[i1++] = j2;
            }

        }

        for(int i2 = 0; i2 < i1; i2++)
        {
            int k2 = ai1[i2];
            ai1[i1 + i2] = k2 - (k2 >>> 3) & 0xf8f8ff;
            ai1[i1 * 2 + i2] = k2 - (k2 >>> 2) & 0xf8f8ff;
            ai1[i1 * 3 + i2] = k2 - (k2 >>> 2) - (k2 >>> 3) & 0xf8f8ff;
        }

    }

    public int aj(int l)
    {
        if(l == 0xbc614e)
            return 0;
        ri(l);
        if(l >= 0)
            return mo[l][0];
        if(l < 0)
        {
            l = -(l + 1);
            int i1 = l >> 10 & 0x1f;
            int j1 = l >> 5 & 0x1f;
            int k1 = l & 0x1f;
            return (i1 << 19) + (j1 << 11) + (k1 << 3);
        } else
        {
            return 0;
        }
    }

    public void ji(int l, int i1, int j1)
    {
        if(l == 0 && i1 == 0 && j1 == 0)
            l = 32;
        for(int k1 = 0; k1 < mn; k1++)
            on[k1].ff(l, i1, j1);

    }

    public void fj(int l, int i1, int j1, int k1, int l1)
    {
        if(j1 == 0 && k1 == 0 && l1 == 0)
            j1 = 32;
        for(int i2 = 0; i2 < mn; i2++)
            on[i2].ie(l, i1, j1, k1, l1);

    }

    public static int li(int l, int i1, int j1)
    {
        return -1 - (l / 8) * 1024 - (i1 / 8) * 32 - j1 / 8;
    }

    public int uh(int l, int i1, int j1, int k1, int l1)
    {
        if(k1 == i1)
            return l;
        else
            return l + ((j1 - l) * (l1 - i1)) / (k1 - i1);
    }

    public boolean ii(int l, int i1, int j1, int k1, boolean flag)
    {
        if(flag && l <= j1 || l < j1)
        {
            if(l > k1)
                return true;
            if(i1 > j1)
                return true;
            if(i1 > k1)
                return true;
            return !flag;
        }
        if(l < k1)
            return true;
        if(i1 < j1)
            return true;
        if(i1 < k1)
            return true;
        else
            return flag;
    }

    public boolean yh(int l, int i1, int j1, boolean flag)
    {
        if(flag && l <= j1 || l < j1)
        {
            if(i1 > j1)
                return true;
            return !flag;
        }
        if(i1 < j1)
            return true;
        else
            return flag;
    }

    public boolean rh(int ai1[], int ai2[], int ai3[], int ai4[])
    {
        int l = ai1.length;
        int i1 = ai3.length;
        byte byte0 = 0;
        int l20;
        int j21 = l20 = ai2[0];
        int j1 = 0;
        int i21;
        int k21 = i21 = ai4[0];
        int l1 = 0;
        for(int l21 = 1; l21 < l; l21++)
            if(ai2[l21] < l20)
            {
                l20 = ai2[l21];
                j1 = l21;
            } else
            if(ai2[l21] > j21)
                j21 = ai2[l21];

        for(int i22 = 1; i22 < i1; i22++)
            if(ai4[i22] < i21)
            {
                i21 = ai4[i22];
                l1 = i22;
            } else
            if(ai4[i22] > k21)
                k21 = ai4[i22];

        if(i21 >= j21)
            return false;
        if(l20 >= k21)
            return false;
        int k1;
        int i2;
        boolean flag;
        if(ai2[j1] < ai4[l1])
        {
            for(k1 = j1; ai2[k1] < ai4[l1]; k1 = (k1 + 1) % l);
            for(; ai2[j1] < ai4[l1]; j1 = ((j1 - 1) + l) % l);
            int j2 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
            int j7 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
            int k11 = ai3[l1];
            flag = (j2 < k11) | (j7 < k11);
            if(yh(j2, j7, k11, flag))
                return true;
            i2 = (l1 + 1) % i1;
            l1 = ((l1 - 1) + i1) % i1;
            if(j1 == k1)
                byte0 = 1;
        } else
        {
            for(i2 = l1; ai4[i2] < ai2[j1]; i2 = (i2 + 1) % i1);
            for(; ai4[l1] < ai2[j1]; l1 = ((l1 - 1) + i1) % i1);
            int k2 = ai1[j1];
            int l11 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[j1]);
            int k16 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[j1]);
            flag = (k2 < l11) | (k2 < k16);
            if(yh(l11, k16, k2, !flag))
                return true;
            k1 = (j1 + 1) % l;
            j1 = ((j1 - 1) + l) % l;
            if(l1 == i2)
                byte0 = 2;
        }
        while(byte0 == 0) 
            if(ai2[j1] < ai2[k1])
            {
                if(ai2[j1] < ai4[l1])
                {
                    if(ai2[j1] < ai4[i2])
                    {
                        int l2 = ai1[j1];
                        int k7 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai2[j1]);
                        int i12 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[j1]);
                        int l16 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[j1]);
                        if(ii(l2, k7, i12, l16, flag))
                            return true;
                        j1 = ((j1 - 1) + l) % l;
                        if(j1 == k1)
                            byte0 = 1;
                    } else
                    {
                        int i3 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                        int l7 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                        int j12 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                        int i17 = ai3[i2];
                        if(ii(i3, l7, j12, i17, flag))
                            return true;
                        i2 = (i2 + 1) % i1;
                        if(l1 == i2)
                            byte0 = 2;
                    }
                } else
                if(ai4[l1] < ai4[i2])
                {
                    int j3 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
                    int i8 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
                    int k12 = ai3[l1];
                    int j17 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai4[l1]);
                    if(ii(j3, i8, k12, j17, flag))
                        return true;
                    l1 = ((l1 - 1) + i1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                } else
                {
                    int k3 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                    int j8 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                    int l12 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                    int k17 = ai3[i2];
                    if(ii(k3, j8, l12, k17, flag))
                        return true;
                    i2 = (i2 + 1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                }
            } else
            if(ai2[k1] < ai4[l1])
            {
                if(ai2[k1] < ai4[i2])
                {
                    int l3 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai2[k1]);
                    int k8 = ai1[k1];
                    int i13 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[k1]);
                    int l17 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[k1]);
                    if(ii(l3, k8, i13, l17, flag))
                        return true;
                    k1 = (k1 + 1) % l;
                    if(j1 == k1)
                        byte0 = 1;
                } else
                {
                    int i4 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                    int l8 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                    int j13 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                    int i18 = ai3[i2];
                    if(ii(i4, l8, j13, i18, flag))
                        return true;
                    i2 = (i2 + 1) % i1;
                    if(l1 == i2)
                        byte0 = 2;
                }
            } else
            if(ai4[l1] < ai4[i2])
            {
                int j4 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
                int i9 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
                int k13 = ai3[l1];
                int j18 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai4[l1]);
                if(ii(j4, i9, k13, j18, flag))
                    return true;
                l1 = ((l1 - 1) + i1) % i1;
                if(l1 == i2)
                    byte0 = 2;
            } else
            {
                int k4 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                int j9 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                int l13 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                int k18 = ai3[i2];
                if(ii(k4, j9, l13, k18, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 2;
            }
        while(byte0 == 1) 
            if(ai2[j1] < ai4[l1])
            {
                if(ai2[j1] < ai4[i2])
                {
                    int l4 = ai1[j1];
                    int i14 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[j1]);
                    int l18 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[j1]);
                    return yh(i14, l18, l4, !flag);
                }
                int i5 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                int k9 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                int j14 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                int i19 = ai3[i2];
                if(ii(i5, k9, j14, i19, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            } else
            if(ai4[l1] < ai4[i2])
            {
                int j5 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
                int l9 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
                int k14 = ai3[l1];
                int j19 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai4[l1]);
                if(ii(j5, l9, k14, j19, flag))
                    return true;
                l1 = ((l1 - 1) + i1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            } else
            {
                int k5 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[i2]);
                int i10 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[i2]);
                int l14 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai4[i2]);
                int k19 = ai3[i2];
                if(ii(k5, i10, l14, k19, flag))
                    return true;
                i2 = (i2 + 1) % i1;
                if(l1 == i2)
                    byte0 = 0;
            }
        while(byte0 == 2) 
            if(ai4[l1] < ai2[j1])
            {
                if(ai4[l1] < ai2[k1])
                {
                    int l5 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
                    int j10 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
                    int i15 = ai3[l1];
                    return yh(l5, j10, i15, flag);
                }
                int i6 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai2[k1]);
                int k10 = ai1[k1];
                int j15 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[k1]);
                int l19 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[k1]);
                if(ii(i6, k10, j15, l19, flag))
                    return true;
                k1 = (k1 + 1) % l;
                if(j1 == k1)
                    byte0 = 0;
            } else
            if(ai2[j1] < ai2[k1])
            {
                int j6 = ai1[j1];
                int l10 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai2[j1]);
                int k15 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[j1]);
                int i20 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[j1]);
                if(ii(j6, l10, k15, i20, flag))
                    return true;
                j1 = ((j1 - 1) + l) % l;
                if(j1 == k1)
                    byte0 = 0;
            } else
            {
                int k6 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai2[k1]);
                int i11 = ai1[k1];
                int l15 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[k1]);
                int j20 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[k1]);
                if(ii(k6, i11, l15, j20, flag))
                    return true;
                k1 = (k1 + 1) % l;
                if(j1 == k1)
                    byte0 = 0;
            }
        if(ai2[j1] < ai4[l1])
        {
            int l6 = ai1[j1];
            int i16 = uh(ai3[(l1 + 1) % i1], ai4[(l1 + 1) % i1], ai3[l1], ai4[l1], ai2[j1]);
            int k20 = uh(ai3[((i2 - 1) + i1) % i1], ai4[((i2 - 1) + i1) % i1], ai3[i2], ai4[i2], ai2[j1]);
            return yh(i16, k20, l6, !flag);
        }
        int i7 = uh(ai1[(j1 + 1) % l], ai2[(j1 + 1) % l], ai1[j1], ai2[j1], ai4[l1]);
        int j11 = uh(ai1[((k1 - 1) + l) % l], ai2[((k1 - 1) + l) % l], ai1[k1], ai2[k1], ai4[l1]);
        int j16 = ai3[l1];
        return yh(i7, j11, j16, flag);
    }

    int cm;
    int dm;
    int em[];
    int fm[][];
    int gm[];
    public int hm;
    public int im;
    public int jm;
    public int km;
    public int lm;
    public int mm;
    public static int nm[] = new int[2048];
    private static int om[] = new int[512];
    public boolean pm;
    public double qm;
    public int rm;
    private boolean sm;
    private int tm;
    private int um;
    private int vm;
    private int wm;
    private h xm[];
    private int ym[];
    private int zm;
    private int an;
    private int bn;
    private int cn;
    private int dn;
    private int en;
    private int fn;
    private int gn;
    private int hn;
    private int in;
    private int jn;
    private int kn;
    private int ln;
    private int mn;
    private int nn;
    private h on[];
    private int pn[];
    private int qn;
    private q rn[];
    private int sn;
    private int tn;
    private int un[];
    private int vn[];
    private int wn[];
    private int xn[];
    private int yn[];
    private int zn[];
    private int ao[];
    public h bo;
    private static final int co = 16;
    private static final int _flddo = 4;
    private static final int eo = 5;
    private static final int fo = 0xbc614e;
    int go;
    String ho[];
    int io[];
    int jo[];
    long ko[];
    boolean lo[];
    int mo[][];
    private static long no;
    byte oo[];
    int po[][];
    int qo[][];
    private static byte ro[];
    private static int so[] = new int[256];
    i to;
    public int uo[];
    s vo[];
    int wo;
    int xo;
    int yo[];
    int zo[];
    int ap[];
    int bp[];
    int cp[];
    int dp[];
    boolean ep;
    static int fp;
    static int gp;
    static int hp;
    static int ip;
    static int jp;
    static int kp;
    int lp;
    int mp;

}
