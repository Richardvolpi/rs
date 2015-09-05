// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   g.java

import java.io.PrintStream;

public class g
{

    public g(v v1, int i1, int j1, int k1)
    {
        int l1 = v.z;
        p = 50;
        db = new int[p];
        zb = new int[p][256];
        r = 5;
        s = 1000;
        t = 1000;
        u = 20;
        v = 10;
        a = false;
        m = 1.1000000000000001D;
        w = 1;
        b = false;
        A = 100;
        g = new u[A];
        hb = new int[A];
        B = 512;
        C = 256;
        D = 192;
        E = 256;
        F = 256;
        G = 8;
        H = 4;
        tb = new int[40];
        ub = new int[40];
        vb = new int[40];
        wb = new int[40];
        xb = new int[40];
        yb = new int[40];
        c = false;
        j = v1;
        C = v1.m / 2;
        D = v1.n / 2;
        sb = v1.A;
        O = 0;
        P = i1;
        h = new u[P];
        ib = new int[P];
        Q = 0;
        k = new x[j1];
        for(int i2 = 0; i2 < j1; i2++)
            k[i2] = new x();

        R = 0;
        i = new u(k1 * 2, k1);
        jb = new int[k1];
        nb = new int[k1];
        ob = new int[k1];
        kb = new int[k1];
        lb = new int[k1];
        mb = new int[k1];
        pb = new int[k1];
        if(e == null)
            e = new byte[17691];
        I = 0;
        J = 0;
        K = 0;
        L = 0;
        M = 0;
        N = 0;
        for(int j2 = 0; j2 < 256; j2++)
        {
            gb[j2] = (int)(Math.sin((double)j2 * 0.02454369D) * 32768D);
            gb[j2 + 256] = (int)(Math.cos((double)j2 * 0.02454369D) * 32768D);
        }

        for(int k2 = 0; k2 < 1024; k2++)
        {
            fb[k2] = (int)(Math.sin((double)k2 * 0.00613592315D) * 32768D);
            fb[k2 + 1024] = (int)(Math.cos((double)k2 * 0.00613592315D) * 32768D);
        }

        if(m.a)
            v.z = ++l1;
    }

    public void a(u u1)
    {
        if(u1 == null)
            System.out.println(Eb);
        if(O < P)
        {
            ib[O] = 0;
            h[O++] = u1;
        }
    }

    public void b(u u1)
    {
        int i1 = v.z;
        for(int j1 = 0; j1 < O; j1++)
        {
            if(h[j1] != u1)
                continue;
            O--;
            for(int k1 = j1; k1 < O; k1++)
            {
                h[k1] = h[k1 + 1];
                ib[k1] = ib[k1 + 1];
            }

        }

    }

    public void a()
    {
        b();
        for(int i1 = 0; i1 < O; i1++)
            h[i1] = null;

        O = 0;
    }

    public void b()
    {
        R = 0;
        i.b();
    }

    public void a(int i1)
    {
        R -= i1;
        i.b(i1, i1 * 2);
        if(R < 0)
            R = 0;
    }

    public int a(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        jb[R] = i1;
        kb[R] = j1;
        lb[R] = k1;
        mb[R] = l1;
        nb[R] = i2;
        ob[R] = j2;
        pb[R] = 0;
        int l2 = i.b(j1, k1, l1);
        int i3 = i.b(j1, k1 - j2, l1);
        int ai[] = {
            l2, i3
        };
        i.a(2, ai, 0, 0);
        i.pb[R] = k2;
        i.k[R++] = 0;
        return R - 1;
    }

    public void b(int i1)
    {
        i.k[i1] = 1;
    }

    public void a(int i1, int j1)
    {
        pb[i1] = j1;
    }

    public void b(int i1, int j1)
    {
        x = i1 - E;
        y = j1;
        z = 0;
        b = true;
    }

    public int c()
    {
        return z;
    }

    public int[] d()
    {
        return hb;
    }

    public u[] e()
    {
        return g;
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        C = k1;
        D = l1;
        E = i1;
        F = j1;
        B = i2;
        G = j2;
        l = new z[l1 + j1];
        for(int k2 = 0; k2 < l1 + j1; k2++)
            l[k2] = new z();

    }

    private void a(x ax[], int i1, int j1)
    {
        if(i1 < j1)
        {
            int k1 = i1 - 1;
            int l1 = j1 + 1;
            int i2 = (i1 + j1) / 2;
            x x1 = ax[i2];
            ax[i2] = ax[i1];
            ax[i1] = x1;
            int j2 = x1.j;
            do
            {
                if(k1 >= l1)
                    break;
                do
                    l1--;
                while(ax[l1].j < j2);
                do
                    k1++;
                while(ax[k1].j > j2);
                if(k1 < l1)
                {
                    x x2 = ax[k1];
                    ax[k1] = ax[l1];
                    ax[l1] = x2;
                }
            } while(true);
            a(ax, i1, l1);
            a(ax, l1 + 1, j1);
        }
    }

    public void a(int i1, x ax[], int j1)
    {
        int k1 = v.z;
        for(int l1 = 0; l1 <= j1; l1++)
        {
            ax[l1].a = false;
            ax[l1].p = l1;
            ax[l1].q = -1;
        }

        do
        {
            int i2;
            for(i2 = 0; ax[i2].a; i2++);
            if(i2 == j1)
                return;
            x x1 = ax[i2];
            x1.a = true;
            int j2 = i2;
            int k2 = i2 + i1;
            if(k2 >= j1)
                k2 = j1 - 1;
            int l2 = k2;
            while(l2 >= j2 + 1) 
            {
                x x2 = ax[l2];
                if(x1.c < x2.e && x2.c < x1.e && x1.d < x2.f && x2.d < x1.f && x1.p != x2.q && !a(x1, x2) && b(x2, x1))
                {
                    b(ax, j2, l2);
                    if(ax[l2] != x2)
                        l2++;
                    j2 = bb;
                    x2.q = x1.p;
                }
                l2--;
            }
        } while(true);
    }

    public boolean b(x ax[], int i1, int j1)
    {
        int k1 = v.z;
        do
        {
            x x1 = ax[i1];
            int l1 = i1 + 1;
            do
            {
                if(l1 > j1)
                    break;
                x x3 = ax[l1];
                if(!a(x3, x1))
                    break;
                ax[i1] = x3;
                ax[l1] = x1;
                i1 = l1;
                if(i1 == j1)
                {
                    bb = i1;
                    cb = i1 - 1;
                    return true;
                }
                l1++;
            } while(true);
            x x2 = ax[j1];
            int i2 = j1 - 1;
            do
            {
                if(i2 < i1)
                    break;
                x x4 = ax[i2];
                if(!a(x2, x4))
                    break;
                ax[j1] = x4;
                ax[i2] = x2;
                j1 = i2;
                if(i1 == j1)
                {
                    bb = j1 + 1;
                    cb = j1;
                    return true;
                }
                i2--;
            } while(true);
            if(i1 + 1 >= j1)
            {
                bb = i1;
                cb = j1;
                return false;
            }
            if(!b(ax, i1 + 1, j1))
            {
                bb = i1;
                return false;
            }
            j1 = cb;
        } while(true);
    }

    public void a(int i1, int j1, int k1)
    {
        int l1 = -L + 1024 & 0x3ff;
        int i2 = -M + 1024 & 0x3ff;
        int j2 = -N + 1024 & 0x3ff;
        if(j2 != 0)
        {
            int k2 = fb[j2];
            int j3 = fb[j2 + 1024];
            int i4 = j1 * k2 + i1 * j3 >> 15;
            j1 = j1 * j3 - i1 * k2 >> 15;
            i1 = i4;
        }
        if(l1 != 0)
        {
            int l2 = fb[l1];
            int k3 = fb[l1 + 1024];
            int j4 = j1 * k3 - k1 * l2 >> 15;
            k1 = j1 * l2 + k1 * k3 >> 15;
            j1 = j4;
        }
        if(i2 != 0)
        {
            int i3 = fb[i2];
            int l3 = fb[i2 + 1024];
            int k4 = k1 * i3 + i1 * l3 >> 15;
            k1 = k1 * l3 - i1 * i3 >> 15;
            i1 = k4;
        }
        if(i1 < V)
            V = i1;
        if(i1 > W)
            W = i1;
        if(j1 < X)
            X = j1;
        if(j1 > Y)
            Y = j1;
        if(k1 < Z)
            Z = k1;
        if(k1 > ab)
            ab = k1;
    }

    public void f()
    {
        int i1 = v.z;
        c = j.b;
        int j1 = C * s >> G;
        int k1 = D * s >> G;
        V = 0;
        W = 0;
        X = 0;
        Y = 0;
        Z = 0;
        ab = 0;
        a(-j1, -k1, s);
        a(-j1, k1, s);
        a(j1, -k1, s);
        a(j1, k1, s);
        a(-C, -D, 0);
        a(-C, D, 0);
        a(C, -D, 0);
        a(C, D, 0);
        V += I;
        W += I;
        X += J;
        Y += J;
        Z += K;
        ab += K;
        h[O] = i;
        i.p = 2;
        for(int l1 = 0; l1 < O; l1++)
            h[l1].a(I, J, K, L, M, N, G, r);

        h[O].a(I, J, K, L, M, N, G, r);
        Q = 0;
        for(int i2 = 0; i2 < O; i2++)
        {
            u u2 = h[i2];
            if(!u2.a)
                continue;
            for(int l2 = 0; l2 < u2.n; l2++)
            {
                int i3 = u2.gb[l2];
                int ai1[] = u2.Fb[l2];
                boolean flag = false;
                int k4 = 0;
                do
                {
                    if(k4 >= i3)
                        break;
                    int k5 = u2.cb[ai1[k4]];
                    if(k5 > r && k5 < s)
                    {
                        flag = true;
                        break;
                    }
                    k4++;
                } while(true);
                if(!flag)
                    continue;
                k4 = 0;
                int l5 = 0;
                do
                {
                    if(l5 >= i3)
                        break;
                    int l6 = u2.db[ai1[l5]];
                    if(l6 > -C)
                        k4 |= 1;
                    if(l6 < C)
                        k4 |= 2;
                    if(k4 == 3)
                        break;
                    l5++;
                } while(true);
                if(k4 != 3)
                    continue;
                l5 = 0;
                int i7 = 0;
                do
                {
                    if(i7 >= i3)
                        break;
                    int l7 = u2.eb[ai1[i7]];
                    if(l7 > -D)
                        l5 |= 1;
                    if(l7 < D)
                        l5 |= 2;
                    if(l5 == 3)
                        break;
                    i7++;
                } while(true);
                if(l5 != 3)
                    continue;
                x x2 = k[Q];
                x2.b = u2;
                x2.i = l2;
                c(Q);
                int i8;
                if(x2.n < 0)
                    i8 = u2.hb[l2];
                else
                    i8 = u2.ib[l2];
                if(i8 == 0xbc614e)
                    continue;
                int i9 = 0;
                for(int l9 = 0; l9 < i3; l9++)
                    i9 += u2.cb[ai1[l9]];

                int i10;
                x2.j = i10 = i9 / i3 + u2.o;
                x2.o = i8;
                Q++;
            }

        }

        u u1 = i;
        if(u1.a)
        {
            for(int j2 = 0; j2 < u1.n; j2++)
            {
                int ai[] = u1.Fb[j2];
                int j3 = ai[0];
                int k3 = u1.db[j3];
                int i4 = u1.eb[j3];
                int l4 = u1.cb[j3];
                if(l4 <= r || l4 >= t)
                    continue;
                int i6 = (nb[j2] << G) / l4;
                int j7 = (ob[j2] << G) / l4;
                if(k3 - i6 / 2 <= C && k3 + i6 / 2 >= -C && i4 - j7 <= D && i4 >= -D)
                {
                    x x3 = k[Q];
                    x3.b = u1;
                    x3.i = j2;
                    d(Q);
                    x3.j = (l4 + u1.cb[ai[1]]) / 2;
                    Q++;
                }
            }

        }
        if(Q == 0)
            return;
        q = Q;
        a(k, 0, Q - 1);
        a(100, k, Q);
        for(int k2 = 0; k2 < Q; k2++)
        {
            x x1 = k[k2];
            u u3 = x1.b;
            int l3 = x1.i;
            if(u3 == i)
            {
                int ai2[] = u3.Fb[l3];
                int i5 = ai2[0];
                int j6 = u3.db[i5];
                int k7 = u3.eb[i5];
                int j8 = u3.cb[i5];
                int j9 = (nb[l3] << G) / j8;
                int j10 = (ob[l3] << G) / j8;
                int l10 = k7 - u3.eb[ai2[1]];
                int k11 = ((u3.db[ai2[1]] - j6) * l10) / j10;
                k11 = u3.db[ai2[1]] - j6;
                int j12 = j6 - j9 / 2;
                int i13 = (F + k7) - j10;
                j.a(j12 + E, i13, j9, j10, jb[l3], k11, (256 << G) / j8);
                if(!b || z >= A)
                    continue;
                j12 += (pb[l3] << G) / j8;
                if(y >= i13 && y <= i13 + j10 && x >= j12 && x <= j12 + j9 && !u3.h && u3.k[l3] == 0)
                {
                    g[z] = u3;
                    hb[z] = l3;
                    z++;
                }
                continue;
            }
            int j4 = 0;
            int j5 = 0;
            int k6 = u3.gb[l3];
            int ai3[] = u3.Fb[l3];
            if(u3.lb[l3] != 0xbc614e)
                if(x1.n < 0)
                    j5 = u3.X - u3.lb[l3];
                else
                    j5 = u3.X + u3.lb[l3];
            for(int k8 = 0; k8 < k6; k8++)
            {
                int k9 = ai3[k8];
                wb[k8] = u3.ab[k9];
                xb[k8] = u3.bb[k9];
                yb[k8] = u3.cb[k9];
                if(u3.lb[l3] == 0xbc614e)
                    if(x1.n < 0)
                        j5 = (u3.X - u3.fb[k9]) + u3.j[k9];
                    else
                        j5 = u3.X + u3.fb[k9] + u3.j[k9];
                if(u3.cb[k9] >= r)
                {
                    tb[j4] = u3.db[k9];
                    ub[j4] = u3.eb[k9];
                    vb[j4] = j5;
                    if(u3.cb[k9] > v)
                        vb[j4] += (u3.cb[k9] - v) / u;
                    j4++;
                    continue;
                }
                int k10;
                if(k8 == 0)
                    k10 = ai3[k6 - 1];
                else
                    k10 = ai3[k8 - 1];
                if(u3.cb[k10] >= r)
                {
                    int i11 = u3.cb[k9] - u3.cb[k10];
                    int l11 = u3.ab[k9] - ((u3.ab[k9] - u3.ab[k10]) * (u3.cb[k9] - r)) / i11;
                    int k12 = u3.bb[k9] - ((u3.bb[k9] - u3.bb[k10]) * (u3.cb[k9] - r)) / i11;
                    tb[j4] = (l11 << G) / r;
                    ub[j4] = (k12 << G) / r;
                    vb[j4] = j5;
                    j4++;
                }
                if(k8 == k6 - 1)
                    k10 = ai3[0];
                else
                    k10 = ai3[k8 + 1];
                if(u3.cb[k10] >= r)
                {
                    int j11 = u3.cb[k9] - u3.cb[k10];
                    int i12 = u3.ab[k9] - ((u3.ab[k9] - u3.ab[k10]) * (u3.cb[k9] - r)) / j11;
                    int l12 = u3.bb[k9] - ((u3.bb[k9] - u3.bb[k10]) * (u3.cb[k9] - r)) / j11;
                    tb[j4] = (i12 << G) / r;
                    ub[j4] = (l12 << G) / r;
                    vb[j4] = j5;
                    j4++;
                }
            }

            for(int l8 = 0; l8 < k6; l8++)
            {
                if(vb[l8] < 0)
                    vb[l8] = 0;
                else
                if(vb[l8] > 255)
                    vb[l8] = 255;
                if(x1.o < 0)
                    continue;
                if(qb[x1.o] == 1)
                    vb[l8] <<= 9;
                else
                    vb[l8] <<= 6;
            }

            a(0, 0, 0, 0, j4, tb, ub, vb, u3, l3);
            if(U > T)
                a(0, 0, k6, wb, xb, yb, x1.o, u3);
        }

        b = false;
    }

    private void a(int i1, int j1, int k1, int l1, int i2, int ai[], int ai1[], 
            int ai2[], u u1, int j2)
    {
        int k2 = v.z;
        if(i2 == 3)
        {
            int l2 = ai1[0] + F;
            int l3 = ai1[1] + F;
            int k4 = ai1[2] + F;
            int j5 = ai[0];
            int k6 = ai[1];
            int l7 = ai[2];
            int i9 = ai2[0];
            int k10 = ai2[1];
            int k11 = ai2[2];
            int k12 = (F + D) - 1;
            int k13 = 0;
            int k14 = 0;
            int i15 = 0;
            int k15 = 0;
            int i16 = 0xbc614e;
            int k16 = 0xff439eb2;
            if(k4 != l2)
            {
                k14 = (l7 - j5 << 8) / (k4 - l2);
                k15 = (k11 - i9 << 8) / (k4 - l2);
                if(l2 < k4)
                {
                    k13 = j5 << 8;
                    i15 = i9 << 8;
                    i16 = l2;
                    k16 = k4;
                } else
                {
                    k13 = l7 << 8;
                    i15 = k11 << 8;
                    i16 = k4;
                    k16 = l2;
                }
                if(i16 < 0)
                {
                    k13 -= k14 * i16;
                    i15 -= k15 * i16;
                    i16 = 0;
                }
                if(k16 > k12)
                    k16 = k12;
            }
            int i17 = 0;
            int k17 = 0;
            int i18 = 0;
            int k18 = 0;
            int i19 = 0xbc614e;
            int k19 = 0xff439eb2;
            if(l3 != l2)
            {
                k17 = (k6 - j5 << 8) / (l3 - l2);
                k18 = (k10 - i9 << 8) / (l3 - l2);
                if(l2 < l3)
                {
                    i17 = j5 << 8;
                    i18 = i9 << 8;
                    i19 = l2;
                    k19 = l3;
                } else
                {
                    i17 = k6 << 8;
                    i18 = k10 << 8;
                    i19 = l3;
                    k19 = l2;
                }
                if(i19 < 0)
                {
                    i17 -= k17 * i19;
                    i18 -= k18 * i19;
                    i19 = 0;
                }
                if(k19 > k12)
                    k19 = k12;
            }
            int i20 = 0;
            int k20 = 0;
            int i21 = 0;
            int k21 = 0;
            int i22 = 0xbc614e;
            int k22 = 0xff439eb2;
            if(k4 != l3)
            {
                k20 = (l7 - k6 << 8) / (k4 - l3);
                k21 = (k11 - k10 << 8) / (k4 - l3);
                if(l3 < k4)
                {
                    i20 = k6 << 8;
                    i21 = k10 << 8;
                    i22 = l3;
                    k22 = k4;
                } else
                {
                    i20 = l7 << 8;
                    i21 = k11 << 8;
                    i22 = k4;
                    k22 = l3;
                }
                if(i22 < 0)
                {
                    i20 -= k20 * i22;
                    i21 -= k21 * i22;
                    i22 = 0;
                }
                if(k22 > k12)
                    k22 = k12;
            }
            T = i16;
            if(i19 < T)
                T = i19;
            if(i22 < T)
                T = i22;
            U = k16;
            if(k19 > U)
                U = k19;
            if(k22 > U)
                U = k22;
            int i23 = 0;
            for(k1 = T; k1 < U; k1++)
            {
                if(k1 >= i16 && k1 < k16)
                {
                    i1 = j1 = k13;
                    l1 = i23 = i15;
                    k13 += k14;
                    i15 += k15;
                } else
                {
                    i1 = 0xa0000;
                    j1 = 0xfff60000;
                }
                if(k1 >= i19 && k1 < k19)
                {
                    if(i17 < i1)
                    {
                        i1 = i17;
                        l1 = i18;
                    }
                    if(i17 > j1)
                    {
                        j1 = i17;
                        i23 = i18;
                    }
                    i17 += k17;
                    i18 += k18;
                }
                if(k1 >= i22 && k1 < k22)
                {
                    if(i20 < i1)
                    {
                        i1 = i20;
                        l1 = i21;
                    }
                    if(i20 > j1)
                    {
                        j1 = i20;
                        i23 = i21;
                    }
                    i20 += k20;
                    i21 += k21;
                }
                z z7 = l[k1];
                z7.a = i1;
                z7.b = j1;
                z7.c = l1;
                z7.d = i23;
            }

            if(T < F - D)
                T = F - D;
        } else
        if(i2 == 4)
        {
            int i3 = ai1[0] + F;
            int i4 = ai1[1] + F;
            int l4 = ai1[2] + F;
            int k5 = ai1[3] + F;
            int l6 = ai[0];
            int i8 = ai[1];
            int j9 = ai[2];
            int l10 = ai[3];
            int l11 = ai2[0];
            int l12 = ai2[1];
            int l13 = ai2[2];
            int l14 = ai2[3];
            int j15 = (F + D) - 1;
            int l15 = 0;
            int j16 = 0;
            int l16 = 0;
            int j17 = 0;
            int l17 = 0xbc614e;
            int j18 = 0xff439eb2;
            if(k5 != i3)
            {
                j16 = (l10 - l6 << 8) / (k5 - i3);
                j17 = (l14 - l11 << 8) / (k5 - i3);
                if(i3 < k5)
                {
                    l15 = l6 << 8;
                    l16 = l11 << 8;
                    l17 = i3;
                    j18 = k5;
                } else
                {
                    l15 = l10 << 8;
                    l16 = l14 << 8;
                    l17 = k5;
                    j18 = i3;
                }
                if(l17 < 0)
                {
                    l15 -= j16 * l17;
                    l16 -= j17 * l17;
                    l17 = 0;
                }
                if(j18 > j15)
                    j18 = j15;
            }
            int l18 = 0;
            int j19 = 0;
            int l19 = 0;
            int j20 = 0;
            int l20 = 0xbc614e;
            int j21 = 0xff439eb2;
            if(i4 != i3)
            {
                j19 = (i8 - l6 << 8) / (i4 - i3);
                j20 = (l12 - l11 << 8) / (i4 - i3);
                if(i3 < i4)
                {
                    l18 = l6 << 8;
                    l19 = l11 << 8;
                    l20 = i3;
                    j21 = i4;
                } else
                {
                    l18 = i8 << 8;
                    l19 = l12 << 8;
                    l20 = i4;
                    j21 = i3;
                }
                if(l20 < 0)
                {
                    l18 -= j19 * l20;
                    l19 -= j20 * l20;
                    l20 = 0;
                }
                if(j21 > j15)
                    j21 = j15;
            }
            int l21 = 0;
            int j22 = 0;
            int l22 = 0;
            int j23 = 0;
            int k23 = 0xbc614e;
            int l23 = 0xff439eb2;
            if(l4 != i4)
            {
                j22 = (j9 - i8 << 8) / (l4 - i4);
                j23 = (l13 - l12 << 8) / (l4 - i4);
                if(i4 < l4)
                {
                    l21 = i8 << 8;
                    l22 = l12 << 8;
                    k23 = i4;
                    l23 = l4;
                } else
                {
                    l21 = j9 << 8;
                    l22 = l13 << 8;
                    k23 = l4;
                    l23 = i4;
                }
                if(k23 < 0)
                {
                    l21 -= j22 * k23;
                    l22 -= j23 * k23;
                    k23 = 0;
                }
                if(l23 > j15)
                    l23 = j15;
            }
            int i24 = 0;
            int j24 = 0;
            int k24 = 0;
            int l24 = 0;
            int i25 = 0xbc614e;
            int j25 = 0xff439eb2;
            if(k5 != l4)
            {
                j24 = (l10 - j9 << 8) / (k5 - l4);
                l24 = (l14 - l13 << 8) / (k5 - l4);
                if(l4 < k5)
                {
                    i24 = j9 << 8;
                    k24 = l13 << 8;
                    i25 = l4;
                    j25 = k5;
                } else
                {
                    i24 = l10 << 8;
                    k24 = l14 << 8;
                    i25 = k5;
                    j25 = l4;
                }
                if(i25 < 0)
                {
                    i24 -= j24 * i25;
                    k24 -= l24 * i25;
                    i25 = 0;
                }
                if(j25 > j15)
                    j25 = j15;
            }
            T = l17;
            if(l20 < T)
                T = l20;
            if(k23 < T)
                T = k23;
            if(i25 < T)
                T = i25;
            U = j18;
            if(j21 > U)
                U = j21;
            if(l23 > U)
                U = l23;
            if(j25 > U)
                U = j25;
            int k25 = 0;
            for(k1 = T; k1 < U; k1++)
            {
                if(k1 >= l17 && k1 < j18)
                {
                    i1 = j1 = l15;
                    l1 = k25 = l16;
                    l15 += j16;
                    l16 += j17;
                } else
                {
                    i1 = 0xa0000;
                    j1 = 0xfff60000;
                }
                if(k1 >= l20 && k1 < j21)
                {
                    if(l18 < i1)
                    {
                        i1 = l18;
                        l1 = l19;
                    }
                    if(l18 > j1)
                    {
                        j1 = l18;
                        k25 = l19;
                    }
                    l18 += j19;
                    l19 += j20;
                }
                if(k1 >= k23 && k1 < l23)
                {
                    if(l21 < i1)
                    {
                        i1 = l21;
                        l1 = l22;
                    }
                    if(l21 > j1)
                    {
                        j1 = l21;
                        k25 = l22;
                    }
                    l21 += j22;
                    l22 += j23;
                }
                if(k1 >= i25 && k1 < j25)
                {
                    if(i24 < i1)
                    {
                        i1 = i24;
                        l1 = k24;
                    }
                    if(i24 > j1)
                    {
                        j1 = i24;
                        k25 = k24;
                    }
                    i24 += j24;
                    k24 += l24;
                }
                z z8 = l[k1];
                z8.a = i1;
                z8.b = j1;
                z8.c = l1;
                z8.d = k25;
            }

            if(T < F - D)
                T = F - D;
        } else
        {
            U = T = ai1[0] += F;
            for(k1 = 1; k1 < i2; k1++)
            {
                int j3;
                if((j3 = ai1[k1] += F) < T)
                {
                    T = j3;
                    continue;
                }
                if(j3 > U)
                    U = j3;
            }

            if(T < F - D)
                T = F - D;
            if(U >= F + D)
                U = (F + D) - 1;
            if(T >= U)
                return;
            for(k1 = T; k1 < U; k1++)
            {
                z z1 = l[k1];
                z1.a = 0xa0000;
                z1.b = 0xfff60000;
            }

            int k3 = i2 - 1;
            int j4 = ai1[0];
            int i5 = ai1[k3];
            if(j4 < i5)
            {
                int l5 = ai[0] << 8;
                int i7 = (ai[k3] - ai[0] << 8) / (i5 - j4);
                int j8 = ai2[0] << 8;
                int k9 = (ai2[k3] - ai2[0] << 8) / (i5 - j4);
                if(j4 < 0)
                {
                    l5 -= i7 * j4;
                    j8 -= k9 * j4;
                    j4 = 0;
                }
                if(i5 > U)
                    i5 = U;
                for(k1 = j4; k1 <= i5; k1++)
                {
                    z z3 = l[k1];
                    z3.a = z3.b = l5;
                    z3.c = z3.d = j8;
                    l5 += i7;
                    j8 += k9;
                }

            } else
            if(j4 > i5)
            {
                int i6 = ai[k3] << 8;
                int j7 = (ai[0] - ai[k3] << 8) / (j4 - i5);
                int k8 = ai2[k3] << 8;
                int l9 = (ai2[0] - ai2[k3] << 8) / (j4 - i5);
                if(i5 < 0)
                {
                    i6 -= j7 * i5;
                    k8 -= l9 * i5;
                    i5 = 0;
                }
                if(j4 > U)
                    j4 = U;
                for(k1 = i5; k1 <= j4; k1++)
                {
                    z z4 = l[k1];
                    z4.a = z4.b = i6;
                    z4.c = z4.d = k8;
                    i6 += j7;
                    k8 += l9;
                }

            }
label0:
            for(k1 = 0; k1 < k3; k1++)
            {
                int j6 = k1 + 1;
                int k7 = ai1[k1];
                int l8 = ai1[j6];
                if(k7 < l8)
                {
                    int i10 = ai[k1] << 8;
                    int i11 = (ai[j6] - ai[k1] << 8) / (l8 - k7);
                    int i12 = ai2[k1] << 8;
                    int i13 = (ai2[j6] - ai2[k1] << 8) / (l8 - k7);
                    if(k7 < 0)
                    {
                        i10 -= i11 * k7;
                        i12 -= i13 * k7;
                        k7 = 0;
                    }
                    if(l8 > U)
                        l8 = U;
                    int i14 = k7;
                    do
                    {
                        if(i14 > l8)
                            continue label0;
                        z z5 = l[i14];
                        if(i10 < z5.a)
                        {
                            z5.a = i10;
                            z5.c = i12;
                        }
                        if(i10 > z5.b)
                        {
                            z5.b = i10;
                            z5.d = i12;
                        }
                        i10 += i11;
                        i12 += i13;
                        i14++;
                    } while(true);
                }
                if(k7 <= l8)
                    continue;
                int j10 = ai[j6] << 8;
                int j11 = (ai[k1] - ai[j6] << 8) / (k7 - l8);
                int j12 = ai2[j6] << 8;
                int j13 = (ai2[k1] - ai2[j6] << 8) / (k7 - l8);
                if(l8 < 0)
                {
                    j10 -= j11 * l8;
                    j12 -= j13 * l8;
                    l8 = 0;
                }
                if(k7 > U)
                    k7 = U;
                int j14 = l8;
                do
                {
                    if(j14 > k7)
                        continue label0;
                    z z6 = l[j14];
                    if(j10 < z6.a)
                    {
                        z6.a = j10;
                        z6.c = j12;
                    }
                    if(j10 > z6.b)
                    {
                        z6.b = j10;
                        z6.d = j12;
                    }
                    j10 += j11;
                    j12 += j13;
                    j14++;
                } while(true);
            }

            if(T < F - D)
                T = F - D;
        }
        if(b && z < A && y >= T && y < U)
        {
            z z2 = l[y];
            if(x >= z2.a >> 8 && x <= z2.b >> 8 && z2.a <= z2.b && !u1.h && u1.k[j2] == 0)
            {
                g[z] = u1;
                hb[z] = j2;
                z++;
            }
        }
    }

    private void a(int i1, int j1, int k1, int ai[], int ai1[], int ai2[], int l1, 
            u u1)
    {
        int i2 = v.z;
        if(l1 == -2)
            return;
        if(l1 >= 0)
        {
            if(l1 >= S)
                l1 = 0;
            e(l1);
            int j2 = ai[0];
            int i3 = ai1[0];
            int l3 = ai2[0];
            int j4 = j2 - ai[1];
            int l4 = i3 - ai1[1];
            int i6 = l3 - ai2[1];
            k1--;
            int j7 = ai[k1] - j2;
            int k8 = ai1[k1] - i3;
            int l9 = ai2[k1] - l3;
            if(qb[l1] == 1)
            {
                int i11 = j7 * i3 - k8 * j2 << 12;
                int l11 = k8 * l3 - l9 * i3 << (5 - G) + 7 + 4;
                int j12 = l9 * j2 - j7 * l3 << (5 - G) + 7;
                int l12 = j4 * i3 - l4 * j2 << 12;
                int j13 = l4 * l3 - i6 * i3 << (5 - G) + 7 + 4;
                int l13 = i6 * j2 - j4 * l3 << (5 - G) + 7;
                int j14 = l4 * j7 - j4 * k8 << 5;
                int l14 = i6 * k8 - l4 * l9 << (5 - G) + 4;
                int j15 = j4 * l9 - i6 * j7 >> G - 5;
                int l15 = l11 >> 4;
                int j16 = j13 >> 4;
                int l16 = l14 >> 4;
                int j17 = T - F;
                int l17 = B;
                int j18 = E + T * l17;
                byte byte1 = 1;
                i11 += j12 * j17;
                l12 += l13 * j17;
                j14 += j15 * j17;
                if(c)
                {
                    if((T & 1) == 1)
                    {
                        T++;
                        i11 += j12;
                        l12 += l13;
                        j14 += j15;
                        j18 += l17;
                    }
                    j12 <<= 1;
                    l13 <<= 1;
                    j15 <<= 1;
                    l17 <<= 1;
                    byte1 = 2;
                }
                if(u1.c)
                {
                    for(i1 = T; i1 < U; i1 += byte1)
                    {
                        z z4 = l[i1];
                        j1 = z4.a >> 8;
                        int l18 = z4.b >> 8;
                        int j20 = l18 - j1;
                        if(j20 <= 0)
                        {
                            i11 += j12;
                            l12 += l13;
                            j14 += j15;
                            j18 += l17;
                            continue;
                        }
                        int l21 = z4.c;
                        int j23 = (z4.d - l21) / j20;
                        if(j1 < -C)
                        {
                            l21 += (-C - j1) * j23;
                            j1 = -C;
                            j20 = l18 - j1;
                        }
                        if(l18 > C)
                        {
                            int l24 = C;
                            j20 = l24 - j1;
                        }
                        b(sb, Bb[l1], 0, 0, i11 + l15 * j1, l12 + j16 * j1, j14 + l16 * j1, l11, j13, l14, j20, j18 + j1, l21, j23 << 2);
                        i11 += j12;
                        l12 += l13;
                        j14 += j15;
                        j18 += l17;
                    }

                    return;
                }
                if(!d[l1])
                {
                    for(i1 = T; i1 < U; i1 += byte1)
                    {
                        z z5 = l[i1];
                        j1 = z5.a >> 8;
                        int i19 = z5.b >> 8;
                        int k20 = i19 - j1;
                        if(k20 <= 0)
                        {
                            i11 += j12;
                            l12 += l13;
                            j14 += j15;
                            j18 += l17;
                            continue;
                        }
                        int i22 = z5.c;
                        int k23 = (z5.d - i22) / k20;
                        if(j1 < -C)
                        {
                            i22 += (-C - j1) * k23;
                            j1 = -C;
                            k20 = i19 - j1;
                        }
                        if(i19 > C)
                        {
                            int i25 = C;
                            k20 = i25 - j1;
                        }
                        a(sb, Bb[l1], 0, 0, i11 + l15 * j1, l12 + j16 * j1, j14 + l16 * j1, l11, j13, l14, k20, j18 + j1, i22, k23 << 2);
                        i11 += j12;
                        l12 += l13;
                        j14 += j15;
                        j18 += l17;
                    }

                    return;
                }
                for(i1 = T; i1 < U; i1 += byte1)
                {
                    z z6 = l[i1];
                    j1 = z6.a >> 8;
                    int j19 = z6.b >> 8;
                    int l20 = j19 - j1;
                    if(l20 <= 0)
                    {
                        i11 += j12;
                        l12 += l13;
                        j14 += j15;
                        j18 += l17;
                        continue;
                    }
                    int j22 = z6.c;
                    int l23 = (z6.d - j22) / l20;
                    if(j1 < -C)
                    {
                        j22 += (-C - j1) * l23;
                        j1 = -C;
                        l20 = j19 - j1;
                    }
                    if(j19 > C)
                    {
                        int j25 = C;
                        l20 = j25 - j1;
                    }
                    a(sb, 0, 0, 0, Bb[l1], i11 + l15 * j1, l12 + j16 * j1, j14 + l16 * j1, l11, j13, l14, l20, j18 + j1, j22, l23);
                    i11 += j12;
                    l12 += l13;
                    j14 += j15;
                    j18 += l17;
                }

                return;
            }
            int j11 = j7 * i3 - k8 * j2 << 11;
            int i12 = k8 * l3 - l9 * i3 << (5 - G) + 6 + 4;
            int k12 = l9 * j2 - j7 * l3 << (5 - G) + 6;
            int i13 = j4 * i3 - l4 * j2 << 11;
            int k13 = l4 * l3 - i6 * i3 << (5 - G) + 6 + 4;
            int i14 = i6 * j2 - j4 * l3 << (5 - G) + 6;
            int k14 = l4 * j7 - j4 * k8 << 5;
            int i15 = i6 * k8 - l4 * l9 << (5 - G) + 4;
            int k15 = j4 * l9 - i6 * j7 >> G - 5;
            int i16 = i12 >> 4;
            int k16 = k13 >> 4;
            int i17 = i15 >> 4;
            int k17 = T - F;
            int i18 = B;
            int k18 = E + T * i18;
            byte byte2 = 1;
            j11 += k12 * k17;
            i13 += i14 * k17;
            k14 += k15 * k17;
            if(c)
            {
                if((T & 1) == 1)
                {
                    T++;
                    j11 += k12;
                    i13 += i14;
                    k14 += k15;
                    k18 += i18;
                }
                k12 <<= 1;
                i14 <<= 1;
                k15 <<= 1;
                i18 <<= 1;
                byte2 = 2;
            }
            if(u1.c)
            {
                for(i1 = T; i1 < U; i1 += byte2)
                {
                    z z7 = l[i1];
                    j1 = z7.a >> 8;
                    int k19 = z7.b >> 8;
                    int i21 = k19 - j1;
                    if(i21 <= 0)
                    {
                        j11 += k12;
                        i13 += i14;
                        k14 += k15;
                        k18 += i18;
                        continue;
                    }
                    int k22 = z7.c;
                    int i24 = (z7.d - k22) / i21;
                    if(j1 < -C)
                    {
                        k22 += (-C - j1) * i24;
                        j1 = -C;
                        i21 = k19 - j1;
                    }
                    if(k19 > C)
                    {
                        int k25 = C;
                        i21 = k25 - j1;
                    }
                    d(sb, Bb[l1], 0, 0, j11 + i16 * j1, i13 + k16 * j1, k14 + i17 * j1, i12, k13, i15, i21, k18 + j1, k22, i24);
                    j11 += k12;
                    i13 += i14;
                    k14 += k15;
                    k18 += i18;
                }

                return;
            }
            if(!d[l1])
            {
                for(i1 = T; i1 < U; i1 += byte2)
                {
                    z z8 = l[i1];
                    j1 = z8.a >> 8;
                    int l19 = z8.b >> 8;
                    int j21 = l19 - j1;
                    if(j21 <= 0)
                    {
                        j11 += k12;
                        i13 += i14;
                        k14 += k15;
                        k18 += i18;
                        continue;
                    }
                    int l22 = z8.c;
                    int j24 = (z8.d - l22) / j21;
                    if(j1 < -C)
                    {
                        l22 += (-C - j1) * j24;
                        j1 = -C;
                        j21 = l19 - j1;
                    }
                    if(l19 > C)
                    {
                        int l25 = C;
                        j21 = l25 - j1;
                    }
                    c(sb, Bb[l1], 0, 0, j11 + i16 * j1, i13 + k16 * j1, k14 + i17 * j1, i12, k13, i15, j21, k18 + j1, l22, j24);
                    j11 += k12;
                    i13 += i14;
                    k14 += k15;
                    k18 += i18;
                }

                return;
            }
            for(i1 = T; i1 < U; i1 += byte2)
            {
                z z9 = l[i1];
                j1 = z9.a >> 8;
                int i20 = z9.b >> 8;
                int k21 = i20 - j1;
                if(k21 <= 0)
                {
                    j11 += k12;
                    i13 += i14;
                    k14 += k15;
                    k18 += i18;
                    continue;
                }
                int i23 = z9.c;
                int k24 = (z9.d - i23) / k21;
                if(j1 < -C)
                {
                    i23 += (-C - j1) * k24;
                    j1 = -C;
                    k21 = i20 - j1;
                }
                if(i20 > C)
                {
                    int i26 = C;
                    k21 = i26 - j1;
                }
                b(sb, 0, 0, 0, Bb[l1], j11 + i16 * j1, i13 + k16 * j1, k14 + i17 * j1, i12, k13, i15, k21, k18 + j1, i23, k24);
                j11 += k12;
                i13 += i14;
                k14 += k15;
                k18 += i18;
            }

            return;
        }
        for(int k2 = 0; k2 < p; k2++)
        {
            if(db[k2] == l1)
            {
                eb = zb[k2];
                break;
            }
            if(k2 != p - 1)
                continue;
            int j3 = (int)(Math.random() * (double)p);
            db[j3] = l1;
            l1 = -1 - l1;
            int i4 = (l1 >> 10 & 0x1f) * 8;
            int k4 = (l1 >> 5 & 0x1f) * 8;
            int i5 = (l1 & 0x1f) * 8;
            for(int j6 = 0; j6 < 256; j6++)
            {
                int k7 = j6 * j6;
                int l8 = (i4 * k7) / 0x10000;
                int i10 = (k4 * k7) / 0x10000;
                int k11 = (i5 * k7) / 0x10000;
                zb[j3][255 - j6] = (l8 << 16) + (i10 << 8) + k11;
            }

            eb = zb[j3];
        }

        int l2 = B;
        int k3 = E + T * l2;
        byte byte0 = 1;
        if(c)
        {
            if((T & 1) == 1)
            {
                T++;
                k3 += l2;
            }
            l2 <<= 1;
            byte0 = 2;
        }
        if(u1.d)
        {
            for(i1 = T; i1 < U; i1 += byte0)
            {
                z z1 = l[i1];
                j1 = z1.a >> 8;
                int j5 = z1.b >> 8;
                int k6 = j5 - j1;
                if(k6 <= 0)
                {
                    k3 += l2;
                    continue;
                }
                int l7 = z1.c;
                int i9 = (z1.d - l7) / k6;
                if(j1 < -C)
                {
                    l7 += (-C - j1) * i9;
                    j1 = -C;
                    k6 = j5 - j1;
                }
                if(j5 > C)
                {
                    int j10 = C;
                    k6 = j10 - j1;
                }
                b(sb, -k6, k3 + j1, 0, eb, l7, i9);
                k3 += l2;
            }

            return;
        }
        if(a)
        {
            for(i1 = T; i1 < U; i1 += byte0)
            {
                z z2 = l[i1];
                j1 = z2.a >> 8;
                int k5 = z2.b >> 8;
                int l6 = k5 - j1;
                if(l6 <= 0)
                {
                    k3 += l2;
                    continue;
                }
                int i8 = z2.c;
                int j9 = (z2.d - i8) / l6;
                if(j1 < -C)
                {
                    i8 += (-C - j1) * j9;
                    j1 = -C;
                    l6 = k5 - j1;
                }
                if(k5 > C)
                {
                    int k10 = C;
                    l6 = k10 - j1;
                }
                a(sb, -l6, k3 + j1, 0, eb, i8, j9);
                k3 += l2;
            }

            return;
        }
        for(i1 = T; i1 < U; i1 += byte0)
        {
            z z3 = l[i1];
            j1 = z3.a >> 8;
            int l5 = z3.b >> 8;
            int i7 = l5 - j1;
            if(i7 <= 0)
            {
                k3 += l2;
                continue;
            }
            int j8 = z3.c;
            int k9 = (z3.d - j8) / i7;
            if(j1 < -C)
            {
                j8 += (-C - j1) * k9;
                j1 = -C;
                i7 = l5 - j1;
            }
            if(l5 > C)
            {
                int l10 = C;
                i7 = l10 - j1;
            }
            c(sb, -i7, k3 + j1, 0, eb, j8, k9);
            k3 += l2;
        }

    }

    private static void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = v.z;
        if(i3 <= 0)
            return;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        if(i2 != 0)
        {
            i1 = k1 / i2 << 7;
            j1 = l1 / i2 << 7;
        }
        if(i1 < 0)
            i1 = 0;
        else
        if(i1 > 16256)
            i1 = 16256;
        k1 += j2;
        l1 += k2;
        i2 += l2;
        if(i2 != 0)
        {
            j4 = k1 / i2 << 7;
            k4 = l1 / i2 << 7;
        }
        if(j4 < 0)
            j4 = 0;
        else
        if(j4 > 16256)
            j4 = 16256;
        int i5 = j4 - i1 >> 4;
        int j5 = k4 - j1 >> 4;
        for(int k5 = i3 >> 4; k5 > 0; k5--)
        {
            i1 += k3 & 0x600000;
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 = j4;
            j1 = k4;
            k1 += j2;
            l1 += k2;
            i2 += l2;
            if(i2 != 0)
            {
                j4 = k1 / i2 << 7;
                k4 = l1 / i2 << 7;
            }
            if(j4 < 0)
                j4 = 0;
            else
            if(j4 > 16256)
                j4 = 16256;
            i5 = j4 - i1 >> 4;
            j5 = k4 - j1 >> 4;
        }

        for(int l5 = 0; l5 < (i3 & 0xf); l5++)
        {
            if((l5 & 3) == 0)
            {
                i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                l4 = k3 >> 23;
                k3 += l3;
            }
            ai[j3++] = ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4;
            i1 += i5;
            j1 += j5;
        }

    }

    private static void b(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = v.z;
        if(i3 <= 0)
            return;
        int j4 = 0;
        int k4 = 0;
        int l4 = 0;
        if(i2 != 0)
        {
            i1 = k1 / i2 << 7;
            j1 = l1 / i2 << 7;
        }
        if(i1 < 0)
            i1 = 0;
        else
        if(i1 > 16256)
            i1 = 16256;
        k1 += j2;
        l1 += k2;
        i2 += l2;
        if(i2 != 0)
        {
            j4 = k1 / i2 << 7;
            k4 = l1 / i2 << 7;
        }
        if(j4 < 0)
            j4 = 0;
        else
        if(j4 > 16256)
            j4 = 16256;
        int i5 = j4 - i1 >> 4;
        int j5 = k4 - j1 >> 4;
        for(int k5 = i3 >> 4; k5 > 0; k5--)
        {
            i1 += k3 & 0x600000;
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0x3fff) + (k3 & 0x600000);
            l4 = k3 >> 23;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 = j4;
            j1 = k4;
            k1 += j2;
            l1 += k2;
            i2 += l2;
            if(i2 != 0)
            {
                j4 = k1 / i2 << 7;
                k4 = l1 / i2 << 7;
            }
            if(j4 < 0)
                j4 = 0;
            else
            if(j4 > 16256)
                j4 = 16256;
            i5 = j4 - i1 >> 4;
            j5 = k4 - j1 >> 4;
        }

        for(int l5 = 0; l5 < (i3 & 0xf); l5++)
        {
            if((l5 & 3) == 0)
            {
                i1 = (i1 & 0x3fff) + (k3 & 0x600000);
                l4 = k3 >> 23;
                k3 += l3;
            }
            ai[j3++] = (ai1[(j1 & 0x3f80) + (i1 >> 7)] >>> l4) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
        }

    }

    private static void a(int ai[], int i1, int j1, int k1, int ai1[], int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3, int i4)
    {
        int j4 = v.z;
        if(j3 <= 0)
            return;
        int k4 = 0;
        int l4 = 0;
        i4 <<= 2;
        if(j2 != 0)
        {
            k4 = l1 / j2 << 7;
            l4 = i2 / j2 << 7;
        }
        if(k4 < 0)
            k4 = 0;
        else
        if(k4 > 16256)
            k4 = 16256;
label0:
        for(int i5 = j3; i5 > 0; i5 -= 16)
        {
            l1 += k2;
            i2 += l2;
            j2 += i3;
            j1 = k4;
            k1 = l4;
            if(j2 != 0)
            {
                k4 = l1 / j2 << 7;
                l4 = i2 / j2 << 7;
            }
            if(k4 < 0)
                k4 = 0;
            else
            if(k4 > 16256)
                k4 = 16256;
            int j5 = k4 - j1 >> 4;
            int k5 = l4 - k1 >> 4;
            int l5 = l3 >> 23;
            j1 += l3 & 0x600000;
            l3 += i4;
            if(i5 < 16)
            {
                int i6 = 0;
                do
                {
                    if(i6 >= i5)
                        continue label0;
                    if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                        ai[k3] = i1;
                    k3++;
                    j1 += j5;
                    k1 += k5;
                    if((i6 & 3) == 3)
                    {
                        j1 = (j1 & 0x3fff) + (l3 & 0x600000);
                        l5 = l3 >> 23;
                        l3 += i4;
                    }
                    i6++;
                } while(true);
            }
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0x3fff) + (l3 & 0x600000);
            l5 = l3 >> 23;
            l3 += i4;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0x3fff) + (l3 & 0x600000);
            l5 = l3 >> 23;
            l3 += i4;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0x3fff) + (l3 & 0x600000);
            l5 = l3 >> 23;
            l3 += i4;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0x3f80) + (j1 >> 7)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
        }

    }

    private static void c(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = v.z;
        if(i3 <= 0)
            return;
        int j4 = 0;
        int k4 = 0;
        l3 <<= 2;
        if(i2 != 0)
        {
            j4 = k1 / i2 << 6;
            k4 = l1 / i2 << 6;
        }
        if(j4 < 0)
            j4 = 0;
        else
        if(j4 > 4032)
            j4 = 4032;
label0:
        for(int l4 = i3; l4 > 0; l4 -= 16)
        {
            k1 += j2;
            l1 += k2;
            i2 += l2;
            i1 = j4;
            j1 = k4;
            if(i2 != 0)
            {
                j4 = k1 / i2 << 6;
                k4 = l1 / i2 << 6;
            }
            if(j4 < 0)
                j4 = 0;
            else
            if(j4 > 4032)
                j4 = 4032;
            int i5 = j4 - i1 >> 4;
            int j5 = k4 - j1 >> 4;
            int k5 = k3 >> 20;
            i1 += k3 & 0xc0000;
            k3 += l3;
            if(l4 < 16)
            {
                int l5 = 0;
                do
                {
                    if(l5 >= l4)
                        continue label0;
                    ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
                    i1 += i5;
                    j1 += j5;
                    if((l5 & 3) == 3)
                    {
                        i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                        k5 = k3 >> 20;
                        k3 += l3;
                    }
                    l5++;
                } while(true);
            }
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
            i1 += i5;
            j1 += j5;
            ai[j3++] = ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5;
        }

    }

    private static void d(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = v.z;
        if(i3 <= 0)
            return;
        int j4 = 0;
        int k4 = 0;
        l3 <<= 2;
        if(i2 != 0)
        {
            j4 = k1 / i2 << 6;
            k4 = l1 / i2 << 6;
        }
        if(j4 < 0)
            j4 = 0;
        else
        if(j4 > 4032)
            j4 = 4032;
label0:
        for(int l4 = i3; l4 > 0; l4 -= 16)
        {
            k1 += j2;
            l1 += k2;
            i2 += l2;
            i1 = j4;
            j1 = k4;
            if(i2 != 0)
            {
                j4 = k1 / i2 << 6;
                k4 = l1 / i2 << 6;
            }
            if(j4 < 0)
                j4 = 0;
            else
            if(j4 > 4032)
                j4 = 4032;
            int i5 = j4 - i1 >> 4;
            int j5 = k4 - j1 >> 4;
            int k5 = k3 >> 20;
            i1 += k3 & 0xc0000;
            k3 += l3;
            if(l4 < 16)
            {
                int l5 = 0;
                do
                {
                    if(l5 >= l4)
                        continue label0;
                    ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
                    i1 += i5;
                    j1 += j5;
                    if((l5 & 3) == 3)
                    {
                        i1 = (i1 & 0xfff) + (k3 & 0xc0000);
                        k5 = k3 >> 20;
                        k3 += l3;
                    }
                    l5++;
                } while(true);
            }
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            i1 = (i1 & 0xfff) + (k3 & 0xc0000);
            k5 = k3 >> 20;
            k3 += l3;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
            i1 += i5;
            j1 += j5;
            ai[j3++] = (ai1[(j1 & 0xfc0) + (i1 >> 6)] >>> k5) + (ai[j3] >> 1 & 0x7f7f7f);
        }

    }

    private static void b(int ai[], int i1, int j1, int k1, int ai1[], int l1, int i2, int j2, 
            int k2, int l2, int i3, int j3, int k3, int l3, int i4)
    {
        int j4 = v.z;
        if(j3 <= 0)
            return;
        int k4 = 0;
        int l4 = 0;
        i4 <<= 2;
        if(j2 != 0)
        {
            k4 = l1 / j2 << 6;
            l4 = i2 / j2 << 6;
        }
        if(k4 < 0)
            k4 = 0;
        else
        if(k4 > 4032)
            k4 = 4032;
label0:
        for(int i5 = j3; i5 > 0; i5 -= 16)
        {
            l1 += k2;
            i2 += l2;
            j2 += i3;
            j1 = k4;
            k1 = l4;
            if(j2 != 0)
            {
                k4 = l1 / j2 << 6;
                l4 = i2 / j2 << 6;
            }
            if(k4 < 0)
                k4 = 0;
            else
            if(k4 > 4032)
                k4 = 4032;
            int j5 = k4 - j1 >> 4;
            int k5 = l4 - k1 >> 4;
            int l5 = l3 >> 20;
            j1 += l3 & 0xc0000;
            l3 += i4;
            if(i5 < 16)
            {
                int i6 = 0;
                do
                {
                    if(i6 >= i5)
                        continue label0;
                    if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                        ai[k3] = i1;
                    k3++;
                    j1 += j5;
                    k1 += k5;
                    if((i6 & 3) == 3)
                    {
                        j1 = (j1 & 0xfff) + (l3 & 0xc0000);
                        l5 = l3 >> 20;
                        l3 += i4;
                    }
                    i6++;
                } while(true);
            }
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0xfff) + (l3 & 0xc0000);
            l5 = l3 >> 20;
            l3 += i4;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0xfff) + (l3 & 0xc0000);
            l5 = l3 >> 20;
            l3 += i4;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            j1 = (j1 & 0xfff) + (l3 & 0xc0000);
            l5 = l3 >> 20;
            l3 += i4;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
            j1 += j5;
            k1 += k5;
            if((i1 = ai1[(k1 & 0xfc0) + (j1 >> 6)] >>> l5) != 0)
                ai[k3] = i1;
            k3++;
        }

    }

    private static void a(int ai[], int i1, int j1, int k1, int ai1[], int l1, int i2)
    {
        int j2 = v.z;
        if(i1 >= 0)
            return;
        i2 <<= 1;
        k1 = ai1[l1 >> 8 & 0xff];
        l1 += i2;
        int k2 = i1 / 8;
        for(int l2 = k2; l2 < 0; l2++)
        {
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
        }

        k2 = -(i1 % 8);
        for(int i3 = 0; i3 < k2; i3++)
        {
            ai[j1++] = k1;
            if((i3 & 1) == 1)
            {
                k1 = ai1[l1 >> 8 & 0xff];
                l1 += i2;
            }
        }

    }

    private static void b(int ai[], int i1, int j1, int k1, int ai1[], int l1, int i2)
    {
        int j2 = v.z;
        if(i1 >= 0)
            return;
        i2 <<= 2;
        k1 = ai1[l1 >> 8 & 0xff];
        l1 += i2;
        int k2 = i1 / 16;
        for(int l2 = k2; l2 < 0; l2++)
        {
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
        }

        k2 = -(i1 % 16);
        for(int i3 = 0; i3 < k2; i3++)
        {
            ai[j1++] = k1 + (ai[j1] >> 1 & 0x7f7f7f);
            if((i3 & 3) == 3)
            {
                k1 = ai1[l1 >> 8 & 0xff];
                l1 += i2;
                l1 += i2;
            }
        }

    }

    private static void c(int ai[], int i1, int j1, int k1, int ai1[], int l1, int i2)
    {
        int j2 = v.z;
        if(i1 >= 0)
            return;
        i2 <<= 2;
        k1 = ai1[l1 >> 8 & 0xff];
        l1 += i2;
        int k2 = i1 / 16;
        for(int l2 = k2; l2 < 0; l2++)
        {
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            ai[j1++] = k1;
            k1 = ai1[l1 >> 8 & 0xff];
            l1 += i2;
        }

        k2 = -(i1 % 16);
        for(int i3 = 0; i3 < k2; i3++)
        {
            ai[j1++] = k1;
            if((i3 & 3) == 3)
            {
                k1 = ai1[l1 >> 8 & 0xff];
                l1 += i2;
            }
        }

    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        l1 &= 0x3ff;
        i2 &= 0x3ff;
        j2 &= 0x3ff;
        L = 1024 - l1 & 0x3ff;
        M = 1024 - i2 & 0x3ff;
        N = 1024 - j2 & 0x3ff;
        int l2 = 0;
        int i3 = 0;
        int j3 = k2;
        if(l1 != 0)
        {
            int k3 = fb[l1];
            int j4 = fb[l1 + 1024];
            int i5 = i3 * j4 - j3 * k3 >> 15;
            j3 = i3 * k3 + j3 * j4 >> 15;
            i3 = i5;
        }
        if(i2 != 0)
        {
            int l3 = fb[i2];
            int k4 = fb[i2 + 1024];
            int j5 = j3 * l3 + l2 * k4 >> 15;
            j3 = j3 * k4 - l2 * l3 >> 15;
            l2 = j5;
        }
        if(j2 != 0)
        {
            int i4 = fb[j2];
            int l4 = fb[j2 + 1024];
            int k5 = i3 * i4 + l2 * l4 >> 15;
            i3 = i3 * l4 - l2 * i4 >> 15;
            l2 = k5;
        }
        I = i1 - l2;
        J = j1 - i3;
        K = k1 - j3;
    }

    private void c(int i1)
    {
        int j1 = v.z;
        x x1 = k[i1];
        u u1 = x1.b;
        int k1 = x1.i;
        int ai[] = u1.Fb[k1];
        int l1 = u1.gb[k1];
        int i2 = u1.kb[k1];
        int j2 = u1.ab[ai[0]];
        int k2 = u1.bb[ai[0]];
        int l2 = u1.cb[ai[0]];
        int i3 = u1.ab[ai[1]] - j2;
        int j3 = u1.bb[ai[1]] - k2;
        int k3 = u1.cb[ai[1]] - l2;
        int l3 = u1.ab[ai[2]] - j2;
        int i4 = u1.bb[ai[2]] - k2;
        int j4 = u1.cb[ai[2]] - l2;
        int k4 = j3 * j4 - i4 * k3;
        int l4 = k3 * l3 - j4 * i3;
        int i5 = i3 * i4 - l3 * j3;
        if(i2 == -1)
        {
            i2 = 0;
            for(; k4 > 25000 || l4 > 25000 || i5 > 25000 || k4 < -25000 || l4 < -25000 || i5 < -25000; i5 >>= 1)
            {
                i2++;
                k4 >>= 1;
                l4 >>= 1;
            }

            u1.kb[k1] = i2;
            u1.jb[k1] = (int)((double)H * Math.sqrt(k4 * k4 + l4 * l4 + i5 * i5));
        } else
        {
            k4 >>= i2;
            l4 >>= i2;
            i5 >>= i2;
        }
        x1.n = j2 * k4 + k2 * l4 + l2 * i5;
        x1.k = k4;
        x1.l = l4;
        x1.m = i5;
        int j5 = u1.cb[ai[0]];
        int k5 = j5;
        int l5 = u1.db[ai[0]];
        int i6 = l5;
        int j6 = u1.eb[ai[0]];
        int k6 = j6;
        for(int l6 = 1; l6 < l1; l6++)
        {
            int i7 = u1.cb[ai[l6]];
            if(i7 > k5)
                k5 = i7;
            else
            if(i7 < j5)
                j5 = i7;
            i7 = u1.db[ai[l6]];
            if(i7 > i6)
                i6 = i7;
            else
            if(i7 < l5)
                l5 = i7;
            i7 = u1.eb[ai[l6]];
            if(i7 > k6)
            {
                k6 = i7;
                continue;
            }
            if(i7 < j6)
                j6 = i7;
        }

        x1.g = j5;
        x1.h = k5;
        x1.c = l5;
        x1.e = i6;
        x1.d = j6;
        x1.f = k6;
    }

    private void d(int i1)
    {
        int j1 = v.z;
        x x1 = k[i1];
        u u1 = x1.b;
        int k1 = x1.i;
        int ai[] = u1.Fb[k1];
        int l1 = 0;
        int i2 = 0;
        int j2 = 1;
        int k2 = u1.ab[ai[0]];
        int l2 = u1.bb[ai[0]];
        int i3 = u1.cb[ai[0]];
        u1.jb[k1] = 1;
        u1.kb[k1] = 0;
        x1.n = k2 * l1 + l2 * i2 + i3 * j2;
        x1.k = l1;
        x1.l = i2;
        x1.m = j2;
        int j3 = u1.cb[ai[0]];
        int k3 = j3;
        int l3 = u1.db[ai[0]];
        int i4 = l3;
        if(u1.db[ai[1]] < l3)
            l3 = u1.db[ai[1]];
        else
            i4 = u1.db[ai[1]];
        int j4 = u1.eb[ai[1]];
        int k4 = u1.eb[ai[0]];
        int l4 = u1.cb[ai[1]];
        if(l4 > k3)
            k3 = l4;
        else
        if(l4 < j3)
            j3 = l4;
        l4 = u1.db[ai[1]];
        if(l4 > i4)
            i4 = l4;
        else
        if(l4 < l3)
            l3 = l4;
        l4 = u1.eb[ai[1]];
        if(l4 > k4)
            k4 = l4;
        else
        if(l4 < j4)
            j4 = l4;
        x1.g = j3;
        x1.h = k3;
        x1.c = l3 - 20;
        x1.e = i4 + 20;
        x1.d = j4;
        x1.f = k4;
    }

    private boolean a(x x1, x x2)
    {
        int i1 = v.z;
        if(x1.c >= x2.e)
            return true;
        if(x2.c >= x1.e)
            return true;
        if(x1.d >= x2.f)
            return true;
        if(x2.d >= x1.f)
            return true;
        if(x1.g >= x2.h)
            return true;
        if(x2.g > x1.h)
            return false;
        u u1 = x1.b;
        u u2 = x2.b;
        int j1 = x1.i;
        int k1 = x2.i;
        int ai[] = u1.Fb[j1];
        int ai1[] = u2.Fb[k1];
        int l1 = u1.gb[j1];
        int i2 = u2.gb[k1];
        int j2 = u2.ab[ai1[0]];
        int k2 = u2.bb[ai1[0]];
        int l2 = u2.cb[ai1[0]];
        int i3 = x2.k;
        int j3 = x2.l;
        int k3 = x2.m;
        int l3 = u2.jb[k1];
        int i4 = x2.n;
        boolean flag = false;
        int j4 = 0;
        do
        {
            if(j4 >= l1)
                break;
            int k4 = ai[j4];
            int i5 = (j2 - u1.ab[k4]) * i3 + (k2 - u1.bb[k4]) * j3 + (l2 - u1.cb[k4]) * k3;
            if(i5 < -l3 && i4 < 0 || i5 > l3 && i4 > 0)
            {
                flag = true;
                break;
            }
            j4++;
        } while(true);
        if(!flag)
            return true;
        j2 = u1.ab[ai[0]];
        k2 = u1.bb[ai[0]];
        l2 = u1.cb[ai[0]];
        i3 = x1.k;
        j3 = x1.l;
        k3 = x1.m;
        l3 = u1.jb[j1];
        i4 = x1.n;
        flag = false;
        j4 = 0;
        do
        {
            if(j4 >= i2)
                break;
            int l4 = ai1[j4];
            int j5 = (j2 - u2.ab[l4]) * i3 + (k2 - u2.bb[l4]) * j3 + (l2 - u2.cb[l4]) * k3;
            if(j5 < -l3 && i4 > 0 || j5 > l3 && i4 < 0)
            {
                flag = true;
                break;
            }
            j4++;
        } while(true);
        if(!flag)
            return true;
        int ai2[];
        int ai3[];
        if(l1 == 2)
        {
            ai2 = new int[4];
            ai3 = new int[4];
            int k5 = ai[0];
            int i6 = ai[1];
            ai2[0] = u1.db[k5] - 20;
            ai2[1] = u1.db[i6] - 20;
            ai2[2] = u1.db[i6] + 20;
            ai2[3] = u1.db[k5] + 20;
            ai3[0] = ai3[3] = u1.eb[k5];
            ai3[1] = ai3[2] = u1.eb[i6];
        } else
        {
            ai2 = new int[l1];
            ai3 = new int[l1];
            for(int l5 = 0; l5 < l1; l5++)
            {
                int j6 = ai[l5];
                ai2[l5] = u1.db[j6];
                ai3[l5] = u1.eb[j6];
            }

        }
        int ai4[];
        int ai5[];
        if(i2 == 2)
        {
            ai4 = new int[4];
            ai5 = new int[4];
            int k6 = ai1[0];
            int i7 = ai1[1];
            ai4[0] = u2.db[k6] - 20;
            ai4[1] = u2.db[i7] - 20;
            ai4[2] = u2.db[i7] + 20;
            ai4[3] = u2.db[k6] + 20;
            ai5[0] = ai5[3] = u2.eb[k6];
            ai5[1] = ai5[2] = u2.eb[i7];
        } else
        {
            ai4 = new int[i2];
            ai5 = new int[i2];
            for(int l6 = 0; l6 < i2; l6++)
            {
                int j7 = ai1[l6];
                ai4[l6] = u2.db[j7];
                ai5[l6] = u2.eb[j7];
            }

        }
        return !a(ai2, ai3, ai4, ai5);
    }

    private boolean b(x x1, x x2)
    {
        int i1 = v.z;
        u u1 = x1.b;
        u u2 = x2.b;
        int j1 = x1.i;
        int k1 = x2.i;
        int ai[] = u1.Fb[j1];
        int ai1[] = u2.Fb[k1];
        int l1 = u1.gb[j1];
        int i2 = u2.gb[k1];
        int j2 = u2.ab[ai1[0]];
        int k2 = u2.bb[ai1[0]];
        int l2 = u2.cb[ai1[0]];
        int i3 = x2.k;
        int j3 = x2.l;
        int k3 = x2.m;
        int l3 = u2.jb[k1];
        int i4 = x2.n;
        boolean flag = false;
        int j4 = 0;
        do
        {
            if(j4 >= l1)
                break;
            int k4 = ai[j4];
            int i5 = (j2 - u1.ab[k4]) * i3 + (k2 - u1.bb[k4]) * j3 + (l2 - u1.cb[k4]) * k3;
            if(i5 < -l3 && i4 < 0 || i5 > l3 && i4 > 0)
            {
                flag = true;
                break;
            }
            j4++;
        } while(true);
        if(!flag)
            return true;
        j2 = u1.ab[ai[0]];
        k2 = u1.bb[ai[0]];
        l2 = u1.cb[ai[0]];
        i3 = x1.k;
        j3 = x1.l;
        k3 = x1.m;
        l3 = u1.jb[j1];
        i4 = x1.n;
        flag = false;
        j4 = 0;
        do
        {
            if(j4 >= i2)
                break;
            int l4 = ai1[j4];
            int j5 = (j2 - u2.ab[l4]) * i3 + (k2 - u2.bb[l4]) * j3 + (l2 - u2.cb[l4]) * k3;
            if(j5 < -l3 && i4 > 0 || j5 > l3 && i4 < 0)
            {
                flag = true;
                break;
            }
            j4++;
        } while(true);
        return !flag;
    }

    public void b(int i1, int j1, int k1)
    {
        S = i1;
        f = new byte[i1][];
        Ab = new int[i1][];
        qb = new int[i1];
        o = new long[i1];
        d = new boolean[i1];
        Bb = new int[i1][];
        n = 0L;
        Cb = new int[j1][];
        Db = new int[k1][];
    }

    public void a(int i1, byte abyte0[], int ai[], int j1)
    {
        f[i1] = abyte0;
        Ab[i1] = ai;
        qb[i1] = j1;
        o[i1] = 0L;
        d[i1] = false;
        Bb[i1] = null;
        e(i1);
    }

    public void e(int i1)
    {
        int j1 = v.z;
        if(i1 < 0)
            return;
        o[i1] = n++;
        if(Bb[i1] != null)
            return;
        if(qb[i1] == 0)
        {
            for(int k1 = 0; k1 < Cb.length; k1++)
                if(Cb[k1] == null)
                {
                    Cb[k1] = new int[16384];
                    Bb[i1] = Cb[k1];
                    f(i1);
                    return;
                }

            long l1 = 0x40000000L;
            int j2 = 0;
            for(int i3 = 0; i3 < S; i3++)
                if(i3 != i1 && qb[i3] == 0 && Bb[i3] != null && o[i3] < l1)
                {
                    l1 = o[i3];
                    j2 = i3;
                }

            Bb[i1] = Bb[j2];
            Bb[j2] = null;
            f(i1);
            return;
        }
        for(int i2 = 0; i2 < Db.length; i2++)
            if(Db[i2] == null)
            {
                Db[i2] = new int[0x10000];
                Bb[i1] = Db[i2];
                f(i1);
                return;
            }

        long l2 = 0x40000000L;
        int k2 = 0;
        for(int j3 = 0; j3 < S; j3++)
            if(j3 != i1 && qb[j3] == 1 && Bb[j3] != null && o[j3] < l2)
            {
                l2 = o[j3];
                k2 = j3;
            }

        Bb[i1] = Bb[k2];
        Bb[k2] = null;
        f(i1);
    }

    private void f(int i1)
    {
        int j1 = v.z;
        char c1;
        if(qb[i1] == 0)
            c1 = '@';
        else
            c1 = '\200';
        int ai[] = Bb[i1];
        int k1 = 0;
        for(int l1 = 0; l1 < c1; l1++)
        {
            for(int j2 = 0; j2 < c1; j2++)
            {
                int l2 = Ab[i1][f[i1][j2 + l1 * c1] & 0xff];
                l2 &= 0xf8f8ff;
                if(l2 == 0)
                    l2 = 1;
                else
                if(l2 == 0xf800ff)
                {
                    l2 = 0;
                    d[i1] = true;
                }
                ai[k1++] = l2;
            }

        }

        for(int i2 = 0; i2 < k1; i2++)
        {
            int k2 = ai[i2];
            ai[k1 + i2] = k2 - (k2 >>> 3) & 0xf8f8ff;
            ai[k1 * 2 + i2] = k2 - (k2 >>> 2) & 0xf8f8ff;
            ai[k1 * 3 + i2] = k2 - (k2 >>> 2) - (k2 >>> 3) & 0xf8f8ff;
        }

    }

    public void g(int i1)
    {
        int j1 = v.z;
        if(Bb[i1] == null)
            return;
        int ai[] = Bb[i1];
        for(int k1 = 0; k1 < 64; k1++)
        {
            int l1 = k1 + 4032;
            int j2 = ai[l1];
            for(int l2 = 0; l2 < 63; l2++)
            {
                ai[l1] = ai[l1 - 64];
                l1 -= 64;
            }

            Bb[i1][l1] = j2;
        }

        char c1 = '\u1000';
        for(int i2 = 0; i2 < c1; i2++)
        {
            int k2 = ai[i2];
            ai[c1 + i2] = k2 - (k2 >>> 3) & 0xf8f8ff;
            ai[c1 * 2 + i2] = k2 - (k2 >>> 2) & 0xf8f8ff;
            ai[c1 * 3 + i2] = k2 - (k2 >>> 2) - (k2 >>> 3) & 0xf8f8ff;
        }

    }

    public int h(int i1)
    {
        if(i1 == 0xbc614e)
            return 0;
        e(i1);
        if(i1 >= 0)
            return Bb[i1][0];
        if(i1 < 0)
        {
            i1 = -(i1 + 1);
            int j1 = i1 >> 10 & 0x1f;
            int k1 = i1 >> 5 & 0x1f;
            int l1 = i1 & 0x1f;
            return (j1 << 19) + (k1 << 11) + (l1 << 3);
        } else
        {
            return 0;
        }
    }

    public void c(int i1, int j1, int k1)
    {
        if(i1 == 0 && j1 == 0 && k1 == 0)
            i1 = 32;
        for(int l1 = 0; l1 < O; l1++)
            h[l1].c(i1, j1, k1);

    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        if(k1 == 0 && l1 == 0 && i2 == 0)
            k1 = 32;
        for(int j2 = 0; j2 < O; j2++)
            h[j2].a(i1, j1, k1, l1, i2);

    }

    public static int d(int i1, int j1, int k1)
    {
        return -1 - (i1 / 8) * 1024 - (j1 / 8) * 32 - k1 / 8;
    }

    public int b(int i1, int j1, int k1, int l1, int i2)
    {
        if(l1 == j1)
            return i1;
        else
            return i1 + ((k1 - i1) * (i2 - j1)) / (l1 - j1);
    }

    public boolean a(int i1, int j1, int k1, int l1, boolean flag)
    {
        if(flag && i1 <= k1 || i1 < k1)
        {
            if(i1 > l1)
                return true;
            if(j1 > k1)
                return true;
            if(j1 > l1)
                return true;
            else
                return !flag;
        }
        if(i1 < l1)
            return true;
        if(j1 < k1)
            return true;
        if(j1 < l1)
            return true;
        else
            return flag;
    }

    public boolean a(int i1, int j1, int k1, boolean flag)
    {
        if(flag && i1 <= k1 || i1 < k1)
            if(j1 > k1)
                return true;
            else
                return !flag;
        if(j1 < k1)
            return true;
        else
            return flag;
    }

    public boolean a(int ai[], int ai1[], int ai2[], int ai3[])
    {
        boolean flag1 = v.R;
        int i1 = v.z;
        int j1 = ai.length;
        int k1 = ai2.length;
        byte byte0 = 0;
        int l1;
        int i2 = l1 = ai1[0];
        int j2 = 0;
        int k2;
        int l2 = k2 = ai3[0];
        int i3 = 0;
        int j3 = 1;
label0:
        do
        {
label1:
            {
                if(j3 >= j1)
                    break label0;
                if(ai1[j3] < l1)
                {
                    l1 = ai1[j3];
                    j2 = j3;
                    if(!flag1)
                        break label1;
                }
                if(ai1[j3] > i2)
                    i2 = ai1[j3];
            }
            j3++;
        } while(!flag1);
        j3 = 1;
label2:
        do
        {
label3:
            {
                if(j3 >= k1)
                    break label2;
                if(ai3[j3] < k2)
                {
                    k2 = ai3[j3];
                    i3 = j3;
                    if(!flag1)
                        break label3;
                }
                if(ai3[j3] > l2)
                    l2 = ai3[j3];
            }
            j3++;
        } while(!flag1);
        int k3;
        boolean flag;
label4:
        {
            if(k2 >= i2)
                return false;
            if(l1 >= l2)
                return false;
            if(ai1[j2] < ai3[i3])
            {
                j3 = j2;
                do
                {
                    if(ai1[j3] >= ai3[i3])
                        break;
                    j3 = (j3 + 1) % j1;
                } while(!flag1);
                do
                {
                    if(ai1[j2] >= ai3[i3])
                        break;
                    j2 = ((j2 - 1) + j1) % j1;
                } while(!flag1);
                int l3 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
                int l8 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
                int l13 = ai2[i3];
                flag = (l3 < l13) | (l8 < l13);
                if(a(l3, l8, l13, flag))
                    return true;
                k3 = (i3 + 1) % k1;
                i3 = ((i3 - 1) + k1) % k1;
                if(j2 != j3)
                    break label4;
                byte0 = 1;
                if(!flag1)
                    break label4;
            }
            k3 = i3;
            do
            {
                if(ai3[k3] >= ai1[j2])
                    break;
                k3 = (k3 + 1) % k1;
            } while(!flag1);
            do
            {
                if(ai3[i3] >= ai1[j2])
                    break;
                i3 = ((i3 - 1) + k1) % k1;
            } while(!flag1);
            int i4 = ai[j2];
            int i9 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j2]);
            int i14 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j2]);
            flag = (i4 < i9) | (i4 < i14);
            if(a(i9, i14, i4, !flag))
                return true;
            j3 = (j2 + 1) % j1;
            j2 = ((j2 - 1) + j1) % j1;
            if(i3 == k3)
                byte0 = 2;
        }
label5:
        do
        {
            do
            {
label6:
                do
                {
                    do
                    {
label7:
                        do
                        {
                            do
                            {
label8:
                                do
                                {
                                    do
                                    {
label9:
                                        do
                                        {
                                            do
                                            {
label10:
                                                do
                                                {
                                                    do
                                                    {
label11:
                                                        do
                                                        {
                                                            do
                                                            {
label12:
                                                                do
                                                                {
                                                                    do
                                                                    {
                                                                        if(byte0 != 0)
                                                                            break label5;
                                                                        if(ai1[j2] >= ai1[j3])
                                                                            break label9;
                                                                        if(ai1[j2] >= ai3[i3])
                                                                            break label11;
                                                                        if(ai1[j2] >= ai3[k3])
                                                                            break label12;
                                                                        int j4 = ai[j2];
                                                                        int j9 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai1[j2]);
                                                                        int j14 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j2]);
                                                                        int l18 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j2]);
                                                                        if(a(j4, j9, j14, l18, flag))
                                                                            return true;
                                                                        j2 = ((j2 - 1) + j1) % j1;
                                                                    } while(j2 != j3);
                                                                    byte0 = 1;
                                                                } while(!flag1);
                                                                int k4 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                                                                int k9 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                                                                int k14 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                                                                int i19 = ai2[k3];
                                                                if(a(k4, k9, k14, i19, flag))
                                                                    return true;
                                                                k3 = (k3 + 1) % k1;
                                                            } while(i3 != k3);
                                                            byte0 = 2;
                                                        } while(!flag1);
                                                        if(ai3[i3] >= ai3[k3])
                                                            break label10;
                                                        int l4 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
                                                        int l9 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
                                                        int l14 = ai2[i3];
                                                        int j19 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai3[i3]);
                                                        if(a(l4, l9, l14, j19, flag))
                                                            return true;
                                                        i3 = ((i3 - 1) + k1) % k1;
                                                    } while(i3 != k3);
                                                    byte0 = 2;
                                                } while(!flag1);
                                                int i5 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                                                int i10 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                                                int i15 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                                                int k19 = ai2[k3];
                                                if(a(i5, i10, i15, k19, flag))
                                                    return true;
                                                k3 = (k3 + 1) % k1;
                                            } while(i3 != k3);
                                            byte0 = 2;
                                        } while(!flag1);
                                        if(ai1[j3] >= ai3[i3])
                                            break label7;
                                        if(ai1[j3] >= ai3[k3])
                                            break label8;
                                        int j5 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai1[j3]);
                                        int j10 = ai[j3];
                                        int j15 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j3]);
                                        int l19 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j3]);
                                        if(a(j5, j10, j15, l19, flag))
                                            return true;
                                        j3 = (j3 + 1) % j1;
                                    } while(j2 != j3);
                                    byte0 = 1;
                                } while(!flag1);
                                int k5 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                                int k10 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                                int k15 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                                int i20 = ai2[k3];
                                if(a(k5, k10, k15, i20, flag))
                                    return true;
                                k3 = (k3 + 1) % k1;
                            } while(i3 != k3);
                            byte0 = 2;
                        } while(!flag1);
                        if(ai3[i3] >= ai3[k3])
                            break label6;
                        int l5 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
                        int l10 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
                        int l15 = ai2[i3];
                        int j20 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai3[i3]);
                        if(a(l5, l10, l15, j20, flag))
                            return true;
                        i3 = ((i3 - 1) + k1) % k1;
                    } while(i3 != k3);
                    byte0 = 2;
                } while(!flag1);
                int i6 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                int i11 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                int i16 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                int k20 = ai2[k3];
                if(a(i6, i11, i16, k20, flag))
                    return true;
                k3 = (k3 + 1) % k1;
            } while(i3 != k3);
            byte0 = 2;
        } while(!flag1);
label13:
        do
        {
            do
            {
label14:
                do
                {
                    do
                    {
label15:
                        do
                        {
                            do
                            {
                                if(byte0 != 1)
                                    break label13;
                                if(ai1[j2] >= ai3[i3])
                                    break label15;
                                if(ai1[j2] < ai3[k3])
                                {
                                    int j6 = ai[j2];
                                    int j11 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j2]);
                                    int j16 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j2]);
                                    return a(j11, j16, j6, !flag);
                                }
                                int k6 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                                int k11 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                                int k16 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                                int l20 = ai2[k3];
                                if(a(k6, k11, k16, l20, flag))
                                    return true;
                                k3 = (k3 + 1) % k1;
                            } while(i3 != k3);
                            byte0 = 0;
                        } while(!flag1);
                        if(ai3[i3] >= ai3[k3])
                            break label14;
                        int l6 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
                        int l11 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
                        int l16 = ai2[i3];
                        int i21 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai3[i3]);
                        if(a(l6, l11, l16, i21, flag))
                            return true;
                        i3 = ((i3 - 1) + k1) % k1;
                    } while(i3 != k3);
                    byte0 = 0;
                } while(!flag1);
                int i7 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[k3]);
                int i12 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[k3]);
                int i17 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai3[k3]);
                int j21 = ai2[k3];
                if(a(i7, i12, i17, j21, flag))
                    return true;
                k3 = (k3 + 1) % k1;
            } while(i3 != k3);
            byte0 = 0;
        } while(!flag1);
label16:
        do
        {
            do
            {
label17:
                do
                {
                    do
                    {
label18:
                        do
                        {
                            do
                            {
                                if(byte0 != 2)
                                    break label16;
                                if(ai3[i3] >= ai1[j2])
                                    break label18;
                                if(ai3[i3] < ai1[j3])
                                {
                                    int j7 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
                                    int j12 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
                                    int j17 = ai2[i3];
                                    return a(j7, j12, j17, flag);
                                }
                                int k7 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai1[j3]);
                                int k12 = ai[j3];
                                int k17 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j3]);
                                int k21 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j3]);
                                if(a(k7, k12, k17, k21, flag))
                                    return true;
                                j3 = (j3 + 1) % j1;
                            } while(j2 != j3);
                            byte0 = 0;
                        } while(!flag1);
                        if(ai1[j2] >= ai1[j3])
                            break label17;
                        int l7 = ai[j2];
                        int l12 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai1[j2]);
                        int l17 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j2]);
                        int l21 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j2]);
                        if(a(l7, l12, l17, l21, flag))
                            return true;
                        j2 = ((j2 - 1) + j1) % j1;
                    } while(j2 != j3);
                    byte0 = 0;
                } while(!flag1);
                int i8 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai1[j3]);
                int i13 = ai[j3];
                int i18 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j3]);
                int i22 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j3]);
                if(a(i8, i13, i18, i22, flag))
                    return true;
                j3 = (j3 + 1) % j1;
            } while(j2 != j3);
            byte0 = 0;
        } while(!flag1);
        if(ai1[j2] < ai3[i3])
        {
            int j8 = ai[j2];
            int j13 = b(ai2[(i3 + 1) % k1], ai3[(i3 + 1) % k1], ai2[i3], ai3[i3], ai1[j2]);
            int j18 = b(ai2[((k3 - 1) + k1) % k1], ai3[((k3 - 1) + k1) % k1], ai2[k3], ai3[k3], ai1[j2]);
            return a(j13, j18, j8, !flag);
        } else
        {
            int k8 = b(ai[(j2 + 1) % j1], ai1[(j2 + 1) % j1], ai[j2], ai1[j2], ai3[i3]);
            int k13 = b(ai[((j3 - 1) + j1) % j1], ai1[((j3 - 1) + j1) % j1], ai[j3], ai1[j3], ai3[i3]);
            int k18 = ai2[i3];
            return a(k8, k13, k18, flag);
        }
    }

    public boolean a;
    private boolean b;
    boolean c;
    boolean d[];
    private static byte e[];
    byte f[][];
    private u g[];
    public u h[];
    public u i;
    v j;
    private x k[];
    z l[];
    public double m;
    private static long n;
    long o[];
    int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    private int x;
    private int y;
    private int z;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    public int O;
    public int P;
    private int Q;
    private int R;
    int S;
    int T;
    int U;
    static int V;
    static int W;
    static int X;
    static int Y;
    static int Z;
    static int ab;
    int bb;
    int cb;
    int db[];
    int eb[];
    public static int fb[];
    private static int gb[];
    private int hb[];
    private int ib[];
    private int jb[];
    private int kb[];
    private int lb[];
    private int mb[];
    private int nb[];
    private int ob[];
    private int pb[];
    int qb[];
    private static int rb[];
    public int sb[];
    int tb[];
    int ub[];
    int vb[];
    int wb[];
    int xb[];
    int yb[];
    int zb[][];
    int Ab[][];
    int Bb[][];
    int Cb[][];
    int Db[][];
    private static String Eb;

    static 
    {
        Eb = "}X^=dD^\f'\177C\\HsyE\031M7i\nWY?a\nVN9hIM\r";
        break MISSING_BLOCK_LABEL_123;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i1;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i1 % 5)
        {
        case 0: // '\0'
            byte0 = 0x2a;
            break;

        case 1: // '\001'
            byte0 = 57;
            break;

        case 2: // '\002'
            byte0 = 44;
            break;

        case 3: // '\003'
            byte0 = 83;
            break;

        default:
            byte0 = 13;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 26;
           goto _L5 _L1
_L5:
        JVM INSTR new #510 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        fb = new int[2048];
        gb = new int[512];
        rb = new int[256];
    }
}
