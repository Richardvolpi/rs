// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   u.java

import java.io.*;

public class u
{

    public u(int i1, int j1)
    {
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        a(i1, j1);
        Gb = new int[j1][1];
        for(int k1 = 0; k1 < j1; k1++)
            Gb[k1][0] = k1;

    }

    public u(int i1, int j1, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        e = flag;
        f = flag1;
        g = flag2;
        h = flag3;
        i = flag4;
        a(i1, j1);
    }

    public u(byte abyte0[], int i1, boolean flag)
    {
        boolean flag1 = v.R;
        super();
        int j1 = v.z;
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        int k1 = m.a(abyte0, i1);
        i1 += 2;
        int l1 = m.a(abyte0, i1);
        i1 += 2;
        a(k1, l1);
        Gb = new int[l1][1];
        int i2 = 0;
        do
        {
            if(i2 >= k1)
                break;
            tb[i2] = m.d(abyte0, i1);
            i1 += 2;
            i2++;
        } while(!flag1);
        i2 = 0;
        do
        {
            if(i2 >= k1)
                break;
            ub[i2] = m.d(abyte0, i1);
            i1 += 2;
            i2++;
        } while(!flag1);
        i2 = 0;
        do
        {
            if(i2 >= k1)
                break;
            vb[i2] = m.d(abyte0, i1);
            i1 += 2;
            i2++;
        } while(!flag1);
        m = k1;
        i2 = 0;
        do
        {
            if(i2 >= l1)
                break;
            gb[i2] = abyte0[i1++] & 0xff;
            i2++;
        } while(!flag1);
        i2 = 0;
        do
        {
            if(i2 >= l1)
                break;
            hb[i2] = m.d(abyte0, i1);
            i1 += 2;
            if(hb[i2] == 32767)
                hb[i2] = y;
            i2++;
        } while(!flag1);
        i2 = 0;
        do
        {
            if(i2 >= l1)
                break;
            ib[i2] = m.d(abyte0, i1);
            i1 += 2;
            if(ib[i2] == 32767)
                ib[i2] = y;
            i2++;
        } while(!flag1);
        i2 = 0;
label0:
        do
        {
label1:
            {
                if(i2 >= l1)
                    break label0;
                int j2 = abyte0[i1++] & 0xff;
                if(j2 == 0)
                {
                    lb[i2] = 0;
                    if(!flag1)
                        break label1;
                }
                lb[i2] = y;
            }
            i2++;
        } while(!flag1);
        i2 = 0;
        do
        {
            if(i2 >= l1)
                break;
            Fb[i2] = new int[gb[i2]];
            int k2 = 0;
label2:
            do
            {
label3:
                {
                    if(k2 >= gb[i2])
                        break label2;
                    if(k1 < 256)
                    {
                        Fb[i2][k2] = abyte0[i1++] & 0xff;
                        if(!flag1)
                            break label3;
                    }
                    Fb[i2][k2] = m.a(abyte0, i1);
                    i1 += 2;
                }
                k2++;
            } while(!flag1);
            i2++;
        } while(!flag1);
        n = l1;
        p = 1;
    }

    public u(String s1)
    {
        int i1 = v.z;
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        boolean flag = false;
        boolean flag1 = false;
        byte abyte0[] = null;
        try
        {
            java.io.InputStream inputstream = m.a(s1);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            abyte0 = new byte[3];
            Y = 0;
            Z = 0;
            for(int l1 = 0; l1 < 3; l1 += datainputstream.read(abyte0, l1, 3 - l1));
            int i2 = a(abyte0);
            abyte0 = new byte[i2];
            Y = 0;
            Z = 0;
            for(int j2 = 0; j2 < i2; j2 += datainputstream.read(abyte0, j2, i2 - j2));
            datainputstream.close();
        }
        catch(IOException ioexception)
        {
            m = 0;
            n = 0;
            return;
        }
        int j1 = a(abyte0);
        int k1 = a(abyte0);
        boolean flag2 = false;
        a(j1, k1);
        Gb = new int[k1][];
        for(int k2 = 0; k2 < j1; k2++)
        {
            int i3 = a(abyte0);
            int k3 = a(abyte0);
            int i4 = a(abyte0);
            a(i3, k3, i4);
        }

        for(int l2 = 0; l2 < k1; l2++)
        {
            int j3 = a(abyte0);
            int l3 = a(abyte0);
            int j4 = a(abyte0);
            int k4 = a(abyte0);
            W = a(abyte0);
            X = a(abyte0);
            int l4 = a(abyte0);
            int ai[] = new int[j3];
            for(int i5 = 0; i5 < j3; i5++)
                ai[i5] = a(abyte0);

            int ai1[] = new int[k4];
            for(int j5 = 0; j5 < k4; j5++)
                ai1[j5] = a(abyte0);

            int k5 = a(j3, ai, l3, j4);
            Gb[l2] = ai1;
            if(l4 == 0)
                lb[k5] = 0;
            else
                lb[k5] = y;
        }

        p = 1;
    }

    public u(u au[], int i1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        e = flag;
        f = flag1;
        g = flag2;
        h = flag3;
        a(au, i1, false);
    }

    public u(u au[], int i1)
    {
        p = 1;
        a = true;
        b = true;
        c = false;
        d = false;
        w = -1;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        x = 4;
        y = 0xbc614e;
        R = 0xbc614e;
        S = 180;
        T = 155;
        U = 95;
        V = 256;
        W = 512;
        X = 32;
        a(au, i1, true);
    }

    private void a(int i1, int j1)
    {
        tb = new int[i1];
        ub = new int[i1];
        vb = new int[i1];
        fb = new int[i1];
        j = new byte[i1];
        gb = new int[j1];
        Fb = new int[j1][];
        hb = new int[j1];
        ib = new int[j1];
        lb = new int[j1];
        kb = new int[j1];
        jb = new int[j1];
        if(!i)
        {
            ab = new int[i1];
            bb = new int[i1];
            cb = new int[i1];
            db = new int[i1];
            eb = new int[i1];
        }
        if(!h)
        {
            k = new byte[j1];
            pb = new int[j1];
        }
        if(e)
        {
            wb = tb;
            xb = ub;
            yb = vb;
        } else
        {
            wb = new int[i1];
            xb = new int[i1];
            yb = new int[i1];
        }
        if(!g || !f)
        {
            mb = new int[j1];
            nb = new int[j1];
            ob = new int[j1];
        }
        if(!f)
        {
            zb = new int[j1];
            Ab = new int[j1];
            Bb = new int[j1];
            Cb = new int[j1];
            Db = new int[j1];
            Eb = new int[j1];
        }
        n = 0;
        m = 0;
        z = i1;
        A = j1;
        B = C = D = 0;
        E = F = G = 0;
        H = I = J = 256;
        K = L = M = N = O = P = 256;
        Q = 0;
    }

    public void a()
    {
        ab = new int[m];
        bb = new int[m];
        cb = new int[m];
        db = new int[m];
        eb = new int[m];
    }

    public void b()
    {
        n = 0;
        m = 0;
    }

    public void b(int i1, int j1)
    {
        n -= i1;
        if(n < 0)
            n = 0;
        m -= j1;
        if(m < 0)
            m = 0;
    }

    public void a(u au[], int i1, boolean flag)
    {
        int j1 = v.z;
        int k1 = 0;
        int l1 = 0;
        for(int i2 = 0; i2 < i1; i2++)
        {
            k1 += au[i2].n;
            l1 += au[i2].m;
        }

        a(l1, k1);
        if(flag)
            Gb = new int[k1][];
        for(int j2 = 0; j2 < i1; j2++)
        {
            u u1 = au[j2];
            u1.h();
            X = u1.X;
            W = u1.W;
            S = u1.S;
            T = u1.T;
            U = u1.U;
            V = u1.V;
            for(int k2 = 0; k2 < u1.n; k2++)
            {
                int ai[] = new int[u1.gb[k2]];
                int ai1[] = u1.Fb[k2];
                for(int l2 = 0; l2 < u1.gb[k2]; l2++)
                    ai[l2] = a(u1.tb[ai1[l2]], u1.ub[ai1[l2]], u1.vb[ai1[l2]]);

                int i3 = a(u1.gb[k2], ai, u1.hb[k2], u1.ib[k2]);
                lb[i3] = u1.lb[k2];
                kb[i3] = u1.kb[k2];
                jb[i3] = u1.jb[k2];
                if(!flag)
                    continue;
                if(i1 > 1)
                {
                    Gb[i3] = new int[u1.Gb[k2].length + 1];
                    Gb[i3][0] = j2;
                    for(int j3 = 0; j3 < u1.Gb[k2].length; j3++)
                        Gb[i3][j3 + 1] = u1.Gb[k2][j3];

                    continue;
                }
                Gb[i3] = new int[u1.Gb[k2].length];
                for(int k3 = 0; k3 < u1.Gb[k2].length; k3++)
                    Gb[i3][k3] = u1.Gb[k2][k3];

            }

        }

        p = 1;
    }

    public int a(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < m; l1++)
            if(tb[l1] == i1 && ub[l1] == j1 && vb[l1] == k1)
                return l1;

        if(m >= z)
        {
            return -1;
        } else
        {
            tb[m] = i1;
            ub[m] = j1;
            vb[m] = k1;
            return m++;
        }
    }

    public int b(int i1, int j1, int k1)
    {
        if(m >= z)
        {
            return -1;
        } else
        {
            tb[m] = i1;
            ub[m] = j1;
            vb[m] = k1;
            return m++;
        }
    }

    public int a(int i1, int ai[], int j1, int k1)
    {
        if(n >= A)
        {
            return -1;
        } else
        {
            gb[n] = i1;
            Fb[n] = ai;
            hb[n] = j1;
            ib[n] = k1;
            p = 1;
            return n++;
        }
    }

    public u[] a(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            boolean flag)
    {
        int l2 = v.z;
        h();
        int ai[] = new int[j2];
        int ai1[] = new int[j2];
        for(int i3 = 0; i3 < j2; i3++)
        {
            ai[i3] = 0;
            ai1[i3] = 0;
        }

        for(int j3 = 0; j3 < n; j3++)
        {
            int k3 = 0;
            int k4 = 0;
            int i5 = gb[j3];
            int ai2[] = Fb[j3];
            for(int l5 = 0; l5 < i5; l5++)
            {
                k3 += tb[ai2[l5]];
                k4 += vb[ai2[l5]];
            }

            int i6 = k3 / (i5 * k1) + (k4 / (i5 * l1)) * i2;
            ai[i6] += i5;
            ai1[i6]++;
        }

        u au[] = new u[j2];
        for(int l3 = 0; l3 < j2; l3++)
        {
            if(ai[l3] > k2)
                ai[l3] = k2;
            au[l3] = new u(ai[l3], ai1[l3], true, true, true, flag, true);
            au[l3].W = W;
            au[l3].X = X;
        }

        for(int i4 = 0; i4 < n; i4++)
        {
            int l4 = 0;
            int j5 = 0;
            int k5 = gb[i4];
            int ai3[] = Fb[i4];
            for(int j6 = 0; j6 < k5; j6++)
            {
                l4 += tb[ai3[j6]];
                j5 += vb[ai3[j6]];
            }

            int k6 = l4 / (k5 * k1) + (j5 / (k5 * l1)) * i2;
            a(au[k6], ai3, k5, i4);
        }

        for(int j4 = 0; j4 < j2; j4++)
            au[j4].a();

        return au;
    }

    public void a(u u1, int ai[], int i1, int j1)
    {
        int ai1[] = new int[i1];
        for(int k1 = 0; k1 < i1; k1++)
        {
            int i2 = ai1[k1] = u1.a(tb[ai[k1]], ub[ai[k1]], vb[ai[k1]]);
            u1.fb[i2] = fb[ai[k1]];
            u1.j[i2] = j[ai[k1]];
        }

        int l1 = u1.a(i1, ai1, hb[j1], ib[j1]);
        if(!u1.h && !h)
            u1.pb[l1] = pb[j1];
        u1.lb[l1] = lb[j1];
        u1.kb[l1] = kb[j1];
        u1.jb[l1] = jb[j1];
    }

    public void a(boolean flag, int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = v.z;
        X = 256 - i1 * 4;
        W = (64 - j1) * 16 + 128;
        if(g)
            return;
        for(int k2 = 0; k2 < n; k2++)
            if(flag)
                lb[k2] = y;
            else
                lb[k2] = 0;

        S = k1;
        T = l1;
        U = i2;
        V = (int)Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
        e();
    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        X = 256 - i1 * 4;
        W = (64 - j1) * 16 + 128;
        if(g)
        {
            return;
        } else
        {
            S = k1;
            T = l1;
            U = i2;
            V = (int)Math.sqrt(k1 * k1 + l1 * l1 + i2 * i2);
            e();
            return;
        }
    }

    public void c(int i1, int j1, int k1)
    {
        if(g)
        {
            return;
        } else
        {
            S = i1;
            T = j1;
            U = k1;
            V = (int)Math.sqrt(i1 * i1 + j1 * j1 + k1 * k1);
            e();
            return;
        }
    }

    public void c(int i1, int j1)
    {
        j[i1] = (byte)j1;
    }

    public void d(int i1, int j1, int k1)
    {
        E = E + i1 & 0xff;
        F = F + j1 & 0xff;
        G = G + k1 & 0xff;
        c();
        p = 1;
    }

    public void e(int i1, int j1, int k1)
    {
        E = i1 & 0xff;
        F = j1 & 0xff;
        G = k1 & 0xff;
        c();
        p = 1;
    }

    public void f(int i1, int j1, int k1)
    {
        B += i1;
        C += j1;
        D += k1;
        c();
        p = 1;
    }

    public void g(int i1, int j1, int k1)
    {
        B = i1;
        C = j1;
        D = k1;
        c();
        p = 1;
    }

    private void c()
    {
        if(K != 256 || L != 256 || M != 256 || N != 256 || O != 256 || P != 256)
        {
            Q = 4;
            return;
        }
        if(H != 256 || I != 256 || J != 256)
        {
            Q = 3;
            return;
        }
        if(E != 0 || F != 0 || G != 0)
        {
            Q = 2;
            return;
        }
        if(B != 0 || C != 0 || D != 0)
        {
            Q = 1;
            return;
        } else
        {
            Q = 0;
            return;
        }
    }

    private void h(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < m; l1++)
        {
            wb[l1] += i1;
            xb[l1] += j1;
            yb[l1] += k1;
        }

    }

    private void i(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < m; l1++)
        {
            if(k1 != 0)
            {
                int i2 = qb[k1];
                int l2 = qb[k1 + 256];
                int k3 = xb[l1] * i2 + wb[l1] * l2 >> 15;
                xb[l1] = xb[l1] * l2 - wb[l1] * i2 >> 15;
                wb[l1] = k3;
            }
            if(i1 != 0)
            {
                int j2 = qb[i1];
                int i3 = qb[i1 + 256];
                int l3 = xb[l1] * i3 - yb[l1] * j2 >> 15;
                yb[l1] = xb[l1] * j2 + yb[l1] * i3 >> 15;
                xb[l1] = l3;
            }
            if(j1 != 0)
            {
                int k2 = qb[j1];
                int j3 = qb[j1 + 256];
                int i4 = yb[l1] * k2 + wb[l1] * j3 >> 15;
                yb[l1] = yb[l1] * j3 - wb[l1] * k2 >> 15;
                wb[l1] = i4;
            }
        }

    }

    private void a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        for(int k2 = 0; k2 < m; k2++)
        {
            if(i1 != 0)
                wb[k2] += xb[k2] * i1 >> 8;
            if(j1 != 0)
                yb[k2] += xb[k2] * j1 >> 8;
            if(k1 != 0)
                wb[k2] += yb[k2] * k1 >> 8;
            if(l1 != 0)
                xb[k2] += yb[k2] * l1 >> 8;
            if(i2 != 0)
                yb[k2] += wb[k2] * i2 >> 8;
            if(j2 != 0)
                xb[k2] += wb[k2] * j2 >> 8;
        }

    }

    private void j(int i1, int j1, int k1)
    {
        for(int l1 = 0; l1 < m; l1++)
        {
            wb[l1] = wb[l1] * i1 >> 8;
            xb[l1] = xb[l1] * j1 >> 8;
            yb[l1] = yb[l1] * k1 >> 8;
        }

    }

    private void d()
    {
        int i1 = v.z;
        q = s = u = 0xf423f;
        R = r = t = v = 0xfff0bdc1;
        for(int j1 = 0; j1 < n; j1++)
        {
            int ai[] = Fb[j1];
            int k1 = ai[0];
            int l1 = gb[j1];
            int i2;
            int j2 = i2 = wb[k1];
            int k2;
            int l2 = k2 = xb[k1];
            int i3;
            int j3 = i3 = yb[k1];
            for(int k3 = 0; k3 < l1; k3++)
            {
                int l3 = ai[k3];
                if(wb[l3] < i2)
                    i2 = wb[l3];
                else
                if(wb[l3] > j2)
                    j2 = wb[l3];
                if(xb[l3] < k2)
                    k2 = xb[l3];
                else
                if(xb[l3] > l2)
                    l2 = xb[l3];
                if(yb[l3] < i3)
                {
                    i3 = yb[l3];
                    continue;
                }
                if(yb[l3] > j3)
                    j3 = yb[l3];
            }

            if(!f)
            {
                zb[j1] = i2;
                Ab[j1] = j2;
                Bb[j1] = k2;
                Cb[j1] = l2;
                Db[j1] = i3;
                Eb[j1] = j3;
            }
            if(j2 - i2 > R)
                R = j2 - i2;
            if(l2 - k2 > R)
                R = l2 - k2;
            if(j3 - i3 > R)
                R = j3 - i3;
            if(i2 < q)
                q = i2;
            if(j2 > r)
                r = j2;
            if(k2 < s)
                s = k2;
            if(l2 > t)
                t = l2;
            if(i3 < u)
                u = i3;
            if(j3 > v)
                v = j3;
        }

    }

    public void e()
    {
        int i1 = v.z;
        if(g)
            return;
        int j1 = W * V >> 8;
        for(int k1 = 0; k1 < n; k1++)
            if(lb[k1] != y)
                lb[k1] = (mb[k1] * S + nb[k1] * T + ob[k1] * U) / j1;

        int ai[] = new int[m];
        int ai1[] = new int[m];
        int ai2[] = new int[m];
        int ai3[] = new int[m];
        for(int l1 = 0; l1 < m; l1++)
        {
            ai[l1] = 0;
            ai1[l1] = 0;
            ai2[l1] = 0;
            ai3[l1] = 0;
        }

        for(int i2 = 0; i2 < n; i2++)
        {
            if(lb[i2] != y)
                continue;
            for(int k2 = 0; k2 < gb[i2]; k2++)
            {
                int l2 = Fb[i2][k2];
                ai[l2] += mb[i2];
                ai1[l2] += nb[i2];
                ai2[l2] += ob[i2];
                ai3[l2]++;
            }

        }

        for(int j2 = 0; j2 < m; j2++)
            if(ai3[j2] > 0)
                fb[j2] = (ai[j2] * S + ai1[j2] * T + ai2[j2] * U) / (j1 * ai3[j2]);

    }

    public void f()
    {
        int i1 = v.z;
        if(g && f)
            return;
        for(int j1 = 0; j1 < n; j1++)
        {
            int ai[] = Fb[j1];
            int k1 = wb[ai[0]];
            int l1 = xb[ai[0]];
            int i2 = yb[ai[0]];
            int j2 = wb[ai[1]] - k1;
            int k2 = xb[ai[1]] - l1;
            int l2 = yb[ai[1]] - i2;
            int i3 = wb[ai[2]] - k1;
            int j3 = xb[ai[2]] - l1;
            int k3 = yb[ai[2]] - i2;
            int l3 = k2 * k3 - j3 * l2;
            int i4 = l2 * i3 - k3 * j2;
            int j4;
            for(j4 = j2 * j3 - i3 * k2; l3 > 8192 || i4 > 8192 || j4 > 8192 || l3 < -8192 || i4 < -8192 || j4 < -8192; j4 >>= 1)
            {
                l3 >>= 1;
                i4 >>= 1;
            }

            int k4 = (int)(256D * Math.sqrt(l3 * l3 + i4 * i4 + j4 * j4));
            if(k4 <= 0)
                k4 = 1;
            mb[j1] = (l3 * 0x10000) / k4;
            nb[j1] = (i4 * 0x10000) / k4;
            ob[j1] = (j4 * 65535) / k4;
            kb[j1] = -1;
        }

        e();
    }

    public void g()
    {
        int i1 = v.z;
        if(p == 2)
        {
            p = 0;
            for(int j1 = 0; j1 < m; j1++)
            {
                wb[j1] = tb[j1];
                xb[j1] = ub[j1];
                yb[j1] = vb[j1];
            }

            q = s = u = 0xff676981;
            R = r = t = v = 0x98967f;
            return;
        }
        if(p == 1)
        {
            p = 0;
            for(int k1 = 0; k1 < m; k1++)
            {
                wb[k1] = tb[k1];
                xb[k1] = ub[k1];
                yb[k1] = vb[k1];
            }

            if(Q >= 2)
                i(E, F, G);
            if(Q >= 3)
                j(H, I, J);
            if(Q >= 4)
                a(K, L, M, N, O, P);
            if(Q >= 1)
                h(B, C, D);
            d();
            f();
        }
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2)
    {
        int i3 = v.z;
        g();
        if(u > g.ab || v < g.Z || q > g.W || r < g.V || s > g.Y || t < g.X)
        {
            a = false;
            return;
        }
        a = true;
        int j3 = 0;
        int k3 = 0;
        int l3 = 0;
        int i4 = 0;
        int j4 = 0;
        int k4 = 0;
        if(j2 != 0)
        {
            j3 = rb[j2];
            k3 = rb[j2 + 1024];
        }
        if(i2 != 0)
        {
            j4 = rb[i2];
            k4 = rb[i2 + 1024];
        }
        if(l1 != 0)
        {
            l3 = rb[l1];
            i4 = rb[l1 + 1024];
        }
        for(int l4 = 0; l4 < m; l4++)
        {
            int i5 = wb[l4] - i1;
            int j5 = xb[l4] - j1;
            int k5 = yb[l4] - k1;
            if(j2 != 0)
            {
                int l5 = j5 * j3 + i5 * k3 >> 15;
                j5 = j5 * k3 - i5 * j3 >> 15;
                i5 = l5;
            }
            if(i2 != 0)
            {
                int i6 = k5 * j4 + i5 * k4 >> 15;
                k5 = k5 * k4 - i5 * j4 >> 15;
                i5 = i6;
            }
            if(l1 != 0)
            {
                int j6 = j5 * i4 - k5 * l3 >> 15;
                k5 = j5 * l3 + k5 * i4 >> 15;
                j5 = j6;
            }
            if(k5 >= l2)
                db[l4] = (i5 << k2) / k5;
            else
                db[l4] = i5 << k2;
            if(k5 >= l2)
                eb[l4] = (j5 << k2) / k5;
            else
                eb[l4] = j5 << k2;
            ab[l4] = i5;
            bb[l4] = j5;
            cb[l4] = k5;
        }

    }

    public void h()
    {
        g();
        for(int i1 = 0; i1 < m; i1++)
        {
            tb[i1] = wb[i1];
            ub[i1] = xb[i1];
            vb[i1] = yb[i1];
        }

        B = C = D = 0;
        E = F = G = 0;
        H = I = J = 256;
        K = L = M = N = O = P = 256;
        Q = 0;
    }

    public u i()
    {
        u au[] = new u[1];
        au[0] = this;
        u u1 = new u(au, 1);
        u1.o = o;
        u1.d = d;
        return u1;
    }

    public u a(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        u au[] = new u[1];
        au[0] = this;
        u u1 = new u(au, 1, flag, flag1, flag2, flag3);
        u1.o = o;
        return u1;
    }

    public void a(u u1)
    {
        E = u1.E;
        F = u1.F;
        G = u1.G;
        B = u1.B;
        C = u1.C;
        D = u1.D;
        c();
        p = 1;
    }

    public int a(byte abyte0[])
    {
        for(; abyte0[Y] == 10 || abyte0[Y] == 13; Y++);
        int i1 = sb[abyte0[Y++] & 0xff];
        int j1 = sb[abyte0[Y++] & 0xff];
        int k1 = sb[abyte0[Y++] & 0xff];
        int l1 = (i1 * 4096 + j1 * 64 + k1) - 0x20000;
        if(l1 == 0x1e240)
            l1 = y;
        return l1;
    }

    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    private boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public byte j[];
    public byte k[];
    private static byte l[];
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    private int x;
    private int y;
    public int z;
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
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    protected int W;
    protected int X;
    private int Y;
    private int Z;
    public int ab[];
    public int bb[];
    public int cb[];
    public int db[];
    public int eb[];
    public int fb[];
    public int gb[];
    public int hb[];
    public int ib[];
    public int jb[];
    public int kb[];
    public int lb[];
    public int mb[];
    public int nb[];
    public int ob[];
    public int pb[];
    private static int qb[];
    private static int rb[];
    private static int sb[];
    public int tb[];
    public int ub[];
    public int vb[];
    public int wb[];
    public int xb[];
    public int yb[];
    private int zb[];
    private int Ab[];
    private int Bb[];
    private int Cb[];
    private int Db[];
    private int Eb[];
    public int Fb[][];
    private int Gb[][];

    static 
    {
        qb = new int[512];
        rb = new int[2048];
        l = new byte[64];
        sb = new int[256];
        for(int i1 = 0; i1 < 256; i1++)
        {
            qb[i1] = (int)(Math.sin((double)i1 * 0.02454369D) * 32768D);
            qb[i1 + 256] = (int)(Math.cos((double)i1 * 0.02454369D) * 32768D);
        }

        for(int j1 = 0; j1 < 1024; j1++)
        {
            rb[j1] = (int)(Math.sin((double)j1 * 0.00613592315D) * 32768D);
            rb[j1 + 1024] = (int)(Math.cos((double)j1 * 0.00613592315D) * 32768D);
        }

        for(int k1 = 0; k1 < 10; k1++)
            l[k1] = (byte)(48 + k1);

        for(int l1 = 0; l1 < 26; l1++)
            l[l1 + 10] = (byte)(65 + l1);

        for(int i2 = 0; i2 < 26; i2++)
            l[i2 + 36] = (byte)(97 + i2);

        l[62] = -93;
        l[63] = 36;
        for(int j2 = 0; j2 < 10; j2++)
            sb[48 + j2] = j2;

        for(int k2 = 0; k2 < 26; k2++)
            sb[65 + k2] = k2 + 10;

        for(int l2 = 0; l2 < 26; l2++)
            sb[97 + l2] = l2 + 36;

        sb[163] = 62;
        sb[36] = 63;
    }
}
