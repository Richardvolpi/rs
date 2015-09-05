// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   t.java


public class t
{

    public t(v v1, int i1)
    {
        q = -1;
        a = true;
        h = v1;
        l = i1;
        c = new boolean[i1];
        d = new boolean[i1];
        e = new boolean[i1];
        f = new boolean[i1];
        g = new boolean[i1];
        J = new int[i1];
        K = new int[i1];
        L = new int[i1];
        M = new int[i1];
        N = new int[i1];
        O = new int[i1];
        P = new int[i1];
        Q = new int[i1];
        R = new int[i1];
        S = new int[i1];
        T = new int[i1];
        i = new String[i1];
        j = new String[i1][];
        s = a(114, 114, 176);
        t = a(14, 14, 62);
        u = a(200, 208, 232);
        v = a(96, 129, 184);
        w = a(53, 95, 115);
        x = a(117, 142, 171);
        y = a(98, 122, 158);
        z = a(86, 100, 136);
        A = a(135, 146, 179);
        B = a(97, 112, 151);
        C = a(88, 102, 136);
        D = a(84, 93, 120);
    }

    public int a(int i1, int j1, int k1)
    {
        return v.b((F * i1) / 114, (G * j1) / 114, (H * k1) / 176);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        int i2 = v.z;
        m = i1;
        n = j1;
        p = l1;
        if(k1 != 0)
            o = k1;
        if(k1 == 1)
        {
            for(int j2 = 0; j2 < k; j2++)
            {
                if(c[j2] && P[j2] == 10 && m >= N[j2] && n >= O[j2] && m <= N[j2] + Q[j2] && n <= O[j2] + R[j2])
                    f[j2] = true;
                if(c[j2] && P[j2] == 14 && m >= N[j2] && n >= O[j2] && m <= N[j2] + Q[j2] && n <= O[j2] + R[j2])
                    L[j2] = 1 - L[j2];
            }

        }
        if(l1 == 1)
            r++;
        else
            r = 0;
        if(k1 == 1 || r > 20)
        {
            for(int k2 = 0; k2 < k; k2++)
                if(c[k2] && P[k2] == 15 && m >= N[k2] && n >= O[k2] && m <= N[k2] + Q[k2] && n <= O[k2] + R[k2])
                    f[k2] = true;

            r -= 5;
        }
    }

    public boolean a(int i1)
    {
        if(c[i1] && f[i1])
        {
            f[i1] = false;
            return true;
        } else
        {
            return false;
        }
    }

    public void b(int i1)
    {
        if(i1 == 0)
            return;
        if(q != -1 && i[q] != null && c[q])
        {
            int j1 = i[q].length();
            if(i1 == 8 && j1 > 0)
                i[q] = i[q].substring(0, j1 - 1);
            if((i1 == 10 || i1 == 13) && j1 > 0)
                f[q] = true;
            String s1 = U[0];
            if(j1 < S[q])
            {
                for(int k1 = 0; k1 < s1.length(); k1++)
                    if(i1 == s1.charAt(k1))
                        i[q] += (char)i1;

            }
            if(i1 == 9)
            {
                do
                    q = (q + 1) % k;
                while(P[q] != 5 && P[q] != 6);
                return;
            }
        }
    }

    public void a()
    {
        int i1 = v.z;
        for(int j1 = 0; j1 < k; j1++)
        {
            if(!c[j1])
                continue;
            if(P[j1] == 0)
            {
                a(j1, N[j1], O[j1], i[j1], T[j1]);
                continue;
            }
            if(P[j1] == 1)
            {
                a(j1, N[j1] - h.a(i[j1], T[j1]) / 2, O[j1], i[j1], T[j1]);
                continue;
            }
            if(P[j1] == 2)
            {
                b(N[j1], O[j1], Q[j1], R[j1]);
                continue;
            }
            if(P[j1] == 3)
            {
                c(N[j1], O[j1], Q[j1]);
                continue;
            }
            if(P[j1] == 4)
            {
                a(j1, N[j1], O[j1], Q[j1], R[j1], T[j1], j[j1], K[j1], J[j1]);
                continue;
            }
            if(P[j1] == 5 || P[j1] == 6)
            {
                a(j1, N[j1], O[j1], Q[j1], R[j1], i[j1], T[j1]);
                continue;
            }
            if(P[j1] == 7)
            {
                a(j1, N[j1], O[j1], T[j1], j[j1]);
                continue;
            }
            if(P[j1] == 8)
            {
                b(j1, N[j1], O[j1], T[j1], j[j1]);
                continue;
            }
            if(P[j1] == 9)
            {
                b(j1, N[j1], O[j1], Q[j1], R[j1], T[j1], j[j1], K[j1], J[j1]);
                continue;
            }
            if(P[j1] == 11)
            {
                c(N[j1], O[j1], Q[j1], R[j1]);
                continue;
            }
            if(P[j1] == 12)
            {
                b(N[j1], O[j1], T[j1]);
                continue;
            }
            if(P[j1] == 14)
                a(j1, N[j1], O[j1], Q[j1], R[j1]);
        }

        o = 0;
    }

    protected void a(int i1, int j1, int k1, int l1, int i2)
    {
        h.b(j1, k1, l1, i2, 0xffffff);
        h.b(j1, k1, l1, A);
        h.c(j1, k1, i2, A);
        h.b(j1, (k1 + i2) - 1, l1, D);
        h.c((j1 + l1) - 1, k1, i2, D);
        if(L[i1] == 1)
        {
            for(int j2 = 0; j2 < i2; j2++)
            {
                h.b(j1 + j2, k1 + j2, 1, 0);
                h.b((j1 + l1) - 1 - j2, k1 + j2, 1, 0);
            }

        }
    }

    protected void a(int i1, int j1, int k1, String s1, int l1)
    {
        int i2 = k1 + h.c(l1) / 3;
        b(i1, j1, i2, s1, l1);
    }

    protected void b(int i1, int j1, int k1, String s1, int l1)
    {
        int i2;
        if(g[i1])
            i2 = 0xffffff;
        else
            i2 = 0;
        h.c(s1, j1, k1, l1, i2);
    }

    protected void a(int i1, int j1, int k1, int l1, int i2, String s1, int j2)
    {
        int k2 = v.z;
        if(e[i1])
        {
            int l2 = s1.length();
            s1 = "";
            for(int j3 = 0; j3 < l2; j3++)
                s1 = s1 + "X";

        }
        if(P[i1] == 5)
        {
            if(o == 1 && m >= j1 && n >= k1 - i2 / 2 && m <= j1 + l1 && n <= k1 + i2 / 2)
                q = i1;
        } else
        if(P[i1] == 6)
        {
            if(o == 1 && m >= j1 - l1 / 2 && n >= k1 - i2 / 2 && m <= j1 + l1 / 2 && n <= k1 + i2 / 2)
                q = i1;
            j1 -= h.a(s1, j2) / 2;
        }
        if(q == i1)
            s1 = s1 + "*";
        int i3 = k1 + h.c(j2) / 3;
        b(i1, j1, i3, s1, j2);
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        int i2 = v.z;
        h.a(i1, j1, i1 + k1, j1 + l1);
        h.b(i1, j1, k1, l1, D, A);
        if(b)
        {
            for(int j2 = i1 - (j1 & 0x3f); j2 < i1 + k1; j2 += 128)
            {
                for(int k2 = j1 - (j1 & 0x1f); k2 < j1 + l1; k2 += 128)
                    h.d(j2, k2, 6 + E, 128);

            }

        }
        h.b(i1, j1, k1, A);
        h.b(i1 + 1, j1 + 1, k1 - 2, A);
        h.b(i1 + 2, j1 + 2, k1 - 4, B);
        h.c(i1, j1, l1, A);
        h.c(i1 + 1, j1 + 1, l1 - 2, A);
        h.c(i1 + 2, j1 + 2, l1 - 4, B);
        h.b(i1, (j1 + l1) - 1, k1, D);
        h.b(i1 + 1, (j1 + l1) - 2, k1 - 2, D);
        h.b(i1 + 2, (j1 + l1) - 3, k1 - 4, C);
        h.c((i1 + k1) - 1, j1, l1, D);
        h.c((i1 + k1) - 2, j1 + 1, l1 - 2, D);
        h.c((i1 + k1) - 3, j1 + 2, l1 - 4, C);
        h.b();
    }

    public void c(int i1, int j1, int k1, int l1)
    {
        h.b(i1, j1, k1, l1, 0);
        h.c(i1, j1, k1, l1, x);
        h.c(i1 + 1, j1 + 1, k1 - 2, l1 - 2, y);
        h.c(i1 + 2, j1 + 2, k1 - 4, l1 - 4, z);
        h.c(i1, j1, 2 + E);
        h.c((i1 + k1) - 7, j1, 3 + E);
        h.c(i1, (j1 + l1) - 7, 4 + E);
        h.c((i1 + k1) - 7, (j1 + l1) - 7, 5 + E);
    }

    protected void b(int i1, int j1, int k1)
    {
        h.c(i1, j1, k1);
    }

    protected void c(int i1, int j1, int k1)
    {
        h.b(i1, j1, k1, 0);
    }

    protected void a(int i1, int j1, int k1, int l1, int i2, int j2, String as[], 
            int k2, int l2)
    {
        int i3 = v.z;
        int j3 = i2 / h.c(j2);
        if(l2 > k2 - j3)
            l2 = k2 - j3;
        if(l2 < 0)
            l2 = 0;
        J[i1] = l2;
        if(j3 < k2)
        {
            int k3 = (j1 + l1) - 12;
            int i4 = ((i2 - 27) * j3) / k2;
            if(i4 < 6)
                i4 = 6;
            int k4 = ((i2 - 27 - i4) * l2) / (k2 - j3);
            if(p == 1 && m >= k3 && m <= k3 + 12)
            {
                if(n > k1 && n < k1 + 12 && l2 > 0)
                    l2--;
                if(n > (k1 + i2) - 12 && n < k1 + i2 && l2 < k2 - j3)
                    l2++;
                J[i1] = l2;
            }
            if(p == 1 && (m >= k3 && m <= k3 + 12 || m >= k3 - 12 && m <= k3 + 24 && d[i1]))
            {
                if(n > k1 + 12 && n < (k1 + i2) - 12)
                {
                    d[i1] = true;
                    int i5 = n - k1 - 12 - i4 / 2;
                    l2 = (i5 * k2) / (i2 - 24);
                    if(l2 > k2 - j3)
                        l2 = k2 - j3;
                    if(l2 < 0)
                        l2 = 0;
                    J[i1] = l2;
                }
            } else
            {
                d[i1] = false;
            }
            k4 = ((i2 - 27 - i4) * l2) / (k2 - j3);
            a(j1, k1, l1, i2, k4, i4);
        }
        int l3 = i2 - j3 * h.c(j2);
        int j4 = k1 + (h.c(j2) * 5) / 6 + l3 / 2;
        for(int l4 = l2; l4 < k2; l4++)
        {
            b(i1, j1 + 2, j4, as[l4], j2);
            j4 += h.c(j2) - I;
            if(j4 >= k1 + i2)
                return;
        }

    }

    protected void a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = (i1 + k1) - 12;
        h.c(k2, j1, 12, l1, 0);
        h.c(k2 + 1, j1 + 1, E);
        h.c(k2 + 1, (j1 + l1) - 12, 1 + E);
        h.b(k2, j1 + 13, 12, 0);
        h.b(k2, (j1 + l1) - 13, 12, 0);
        h.b(k2 + 1, j1 + 14, 11, l1 - 27, s, t);
        h.b(k2 + 3, i2 + j1 + 14, 7, j2, v);
        h.c(k2 + 2, i2 + j1 + 14, j2, u);
        h.c(k2 + 2 + 8, i2 + j1 + 14, j2, w);
    }

    protected void a(int i1, int j1, int k1, int l1, String as[])
    {
        int i2 = v.z;
        int j2 = 0;
        int k2 = as.length;
        for(int l2 = 0; l2 < k2; l2++)
        {
            j2 += h.a(as[l2], l1);
            if(l2 < k2 - 1)
                j2 += h.a(U[1], l1);
        }

        int i3 = j1 - j2 / 2;
        int j3 = k1 + h.c(l1) / 3;
        for(int k3 = 0; k3 < k2; k3++)
        {
            int l3;
            if(g[i1])
                l3 = 0xffffff;
            else
                l3 = 0;
            if(m >= i3 && m <= i3 + h.a(as[k3], l1) && n <= j3 && n > j3 - h.c(l1))
            {
                if(g[i1])
                    l3 = 0x808080;
                else
                    l3 = 0xffffff;
                if(o == 1)
                {
                    L[i1] = k3;
                    f[i1] = true;
                }
            }
            if(L[i1] == k3)
                if(g[i1])
                    l3 = 0xff0000;
                else
                    l3 = 0xc00000;
            h.c(as[k3], i3, j3, l1, l3);
            i3 += h.a(as[k3] + U[1], l1);
        }

    }

    protected void b(int i1, int j1, int k1, int l1, String as[])
    {
        int i2 = v.z;
        int j2 = as.length;
        int k2 = k1 - (h.c(l1) * (j2 - 1)) / 2;
        for(int l2 = 0; l2 < j2; l2++)
        {
            int i3;
            if(g[i1])
                i3 = 0xffffff;
            else
                i3 = 0;
            int j3 = h.a(as[l2], l1);
            if(m >= j1 - j3 / 2 && m <= j1 + j3 / 2 && n - 2 <= k2 && n - 2 > k2 - h.c(l1))
            {
                if(g[i1])
                    i3 = 0x808080;
                else
                    i3 = 0xffffff;
                if(o == 1)
                {
                    L[i1] = l2;
                    f[i1] = true;
                }
            }
            if(L[i1] == l2)
                if(g[i1])
                    i3 = 0xff0000;
                else
                    i3 = 0xc00000;
            h.c(as[l2], j1 - j3 / 2, k2, l1, i3);
            k2 += h.c(l1);
        }

    }

    protected void b(int i1, int j1, int k1, int l1, int i2, int j2, String as[], 
            int k2, int l2)
    {
        int j3;
        boolean flag;
label0:
        {
label1:
            {
                int i4;
label2:
                {
                    flag = v.R;
                    int i3 = v.z;
                    j3 = i2 / h.c(j2);
                    if(j3 >= k2)
                        break label1;
                    int k3 = (j1 + l1) - 12;
                    i4 = ((i2 - 27) * j3) / k2;
                    if(i4 < 6)
                        i4 = 6;
                    int k4 = ((i2 - 27 - i4) * l2) / (k2 - j3);
                    if(p == 1 && m >= k3 && m <= k3 + 12)
                    {
                        if(n > k1 && n < k1 + 12 && l2 > 0)
                            l2--;
                        if(n > (k1 + i2) - 12 && n < k1 + i2 && l2 < k2 - j3)
                            l2++;
                        J[i1] = l2;
                    }
                    if(p == 1 && (m >= k3 && m <= k3 + 12 || m >= k3 - 12 && m <= k3 + 24 && d[i1]))
                    {
                        if(n <= k1 + 12 || n >= (k1 + i2) - 12)
                            break label2;
                        d[i1] = true;
                        int j5 = n - k1 - 12 - i4 / 2;
                        l2 = (j5 * k2) / (i2 - 24);
                        if(l2 < 0)
                            l2 = 0;
                        if(l2 > k2 - j3)
                            l2 = k2 - j3;
                        J[i1] = l2;
                        if(!flag)
                            break label2;
                    }
                    d[i1] = false;
                }
                int l4 = ((i2 - 27 - i4) * l2) / (k2 - j3);
                a(j1, k1, l1, i2, l4, i4);
                if(!flag)
                    break label0;
            }
            l2 = 0;
            J[i1] = 0;
        }
        M[i1] = -1;
        int l3 = i2 - j3 * h.c(j2);
        int j4 = k1 + (h.c(j2) * 5) / 6 + l3 / 2;
        int i5 = l2;
label3:
        do
        {
            int k5;
label4:
            {
                if(i5 >= k2)
                    break label3;
                if(g[i1])
                {
                    k5 = 0xffffff;
                    if(!flag)
                        break label4;
                }
                k5 = 0;
            }
label5:
            {
label6:
                {
                    if(m < j1 + 2 || m > j1 + 2 + h.a(as[i5], j2) || n - 2 > j4 || n - 2 <= j4 - h.c(j2))
                        break label5;
                    if(g[i1])
                    {
                        k5 = 0x808080;
                        if(!flag)
                            break label6;
                    }
                    k5 = 0xffffff;
                }
                M[i1] = i5;
                if(o == 1)
                {
                    L[i1] = i5;
                    f[i1] = true;
                }
            }
            if(L[i1] == i5 && a)
                k5 = 0xff0000;
            h.c(as[i5], j1 + 2, j4, j2, k5);
            j4 += h.c(j2);
            if(j4 >= k1 + i2)
                return;
            i5++;
        } while(!flag);
    }

    public int a(int i1, int j1, String s1, int k1, boolean flag)
    {
        P[k] = 1;
        c[k] = true;
        f[k] = false;
        T[k] = k1;
        g[k] = flag;
        N[k] = i1;
        O[k] = j1;
        i[k] = s1;
        return k++;
    }

    public int d(int i1, int j1, int k1, int l1)
    {
        P[k] = 2;
        c[k] = true;
        f[k] = false;
        N[k] = i1 - k1 / 2;
        O[k] = j1 - l1 / 2;
        Q[k] = k1;
        R[k] = l1;
        return k++;
    }

    public int e(int i1, int j1, int k1, int l1)
    {
        P[k] = 11;
        c[k] = true;
        f[k] = false;
        N[k] = i1 - k1 / 2;
        O[k] = j1 - l1 / 2;
        Q[k] = k1;
        R[k] = l1;
        return k++;
    }

    public int d(int i1, int j1, int k1)
    {
        int l1 = h.B[k1];
        int i2 = h.C[k1];
        P[k] = 12;
        c[k] = true;
        f[k] = false;
        N[k] = i1 - l1 / 2;
        O[k] = j1 - i2 / 2;
        Q[k] = l1;
        R[k] = i2;
        T[k] = k1;
        return k++;
    }

    public int a(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag)
    {
        P[k] = 4;
        c[k] = true;
        f[k] = false;
        N[k] = i1;
        O[k] = j1;
        Q[k] = k1;
        R[k] = l1;
        g[k] = flag;
        T[k] = i2;
        S[k] = j2;
        K[k] = 0;
        J[k] = 0;
        j[k] = new String[j2];
        return k++;
    }

    public int a(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, 
            boolean flag1)
    {
        P[k] = 5;
        c[k] = true;
        e[k] = flag;
        f[k] = false;
        T[k] = i2;
        g[k] = flag1;
        N[k] = i1;
        O[k] = j1;
        Q[k] = k1;
        R[k] = l1;
        S[k] = j2;
        i[k] = "";
        return k++;
    }

    public int b(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag, 
            boolean flag1)
    {
        P[k] = 6;
        c[k] = true;
        e[k] = flag;
        f[k] = false;
        T[k] = i2;
        g[k] = flag1;
        N[k] = i1;
        O[k] = j1;
        Q[k] = k1;
        R[k] = l1;
        S[k] = j2;
        i[k] = "";
        return k++;
    }

    public int b(int i1, int j1, int k1, int l1, int i2, int j2, boolean flag)
    {
        P[k] = 9;
        c[k] = true;
        f[k] = false;
        T[k] = i2;
        g[k] = flag;
        N[k] = i1;
        O[k] = j1;
        Q[k] = k1;
        R[k] = l1;
        S[k] = j2;
        j[k] = new String[j2];
        K[k] = 0;
        J[k] = 0;
        L[k] = -1;
        M[k] = -1;
        return k++;
    }

    public int f(int i1, int j1, int k1, int l1)
    {
        P[k] = 10;
        c[k] = true;
        f[k] = false;
        N[k] = i1 - k1 / 2;
        O[k] = j1 - l1 / 2;
        Q[k] = k1;
        R[k] = l1;
        return k++;
    }

    public void c(int i1)
    {
        K[i1] = 0;
    }

    public void d(int i1)
    {
        J[i1] = 0;
        M[i1] = -1;
    }

    public void a(int i1, int j1, String s1)
    {
        j[i1][j1] = s1;
        if(j1 + 1 > K[i1])
            K[i1] = j1 + 1;
    }

    public void a(int i1, String s1, boolean flag)
    {
        int j1 = K[i1]++;
        if(j1 >= S[i1])
        {
            j1--;
            K[i1]--;
            for(int k1 = 0; k1 < j1; k1++)
                j[i1][k1] = j[i1][k1 + 1];

        }
        j[i1][j1] = s1;
        if(flag)
            J[i1] = 0xf423f;
    }

    public void a(int i1, String s1)
    {
        i[i1] = s1;
    }

    public String e(int i1)
    {
        if(i[i1] == null)
            return U[2];
        else
            return i[i1];
    }

    public void f(int i1)
    {
        c[i1] = true;
    }

    public void g(int i1)
    {
        c[i1] = false;
    }

    public void h(int i1)
    {
        q = i1;
    }

    public int i(int i1)
    {
        int j1 = M[i1];
        return j1;
    }

    public boolean a;
    public static boolean b;
    public boolean c[];
    public boolean d[];
    public boolean e[];
    public boolean f[];
    boolean g[];
    protected v h;
    String i[];
    String j[][];
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    int x;
    int y;
    int z;
    int A;
    int B;
    int C;
    int D;
    public static int E;
    public static int F;
    public static int G;
    public static int H;
    public static int I;
    public int J[];
    public int K[];
    public int L[];
    public int M[];
    int N[];
    int O[];
    int P[];
    int Q[];
    int R[];
    int S[];
    int T[];
    private static String U[];

    static 
    {
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 125;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i1;
_L10:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 108
    //                   0 88
    //                   1 93
    //                   2 98
    //                   3 103;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        byte0 = 0x49;
          goto _L8
_L5:
        byte0 = 79;
          goto _L8
_L6:
        byte0 = 108;
          goto _L8
_L7:
        byte0 = 29;
          goto _L8
_L3:
        byte0 = 3;
_L8:
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 125;
           goto _L9 _L2
_L9:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L10
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 49;
           goto _L11 _L1
_L11:
        JVM INSTR new #22  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        String as[] = new String[3];
        as[0] = "\b\r/YF\017\b$TI\002\003!SL\031\036>NW\034\031;EZ\023.\016~g,)\013uj#$\000pm&?\035op=:\032j{05\\,1z{Y+4qvM?\240mj2;)afAB>b\024\027@~ruK] 7cP3=fp0a#";
        as[1] = "io";
        as[2] = "':\000q";
        int i1;
        byte byte0;
        U = as;
        b = true;
        F = 114;
        G = 114;
        H = 176;
    }
}
