// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   q.java

import java.io.IOException;

public class q
{

    public q(g g1, v v1)
    {
        int i1 = f.J;
        h = new byte[4][2304];
        C = new int[96][96];
        z = new int[18432];
        a = false;
        w = 750;
        i = new byte[4][2304];
        j = new byte[4][2304];
        D = new int[4][2304];
        b = true;
        A = new int[256];
        k = new byte[4][2304];
        p = new u[64];
        E = new int[96][96];
        B = new int[18432];
        q = new u[4][64];
        l = new byte[4][2304];
        r = new u[4][64];
        F = new int[96][96];
        c = false;
        m = new byte[4][2304];
        n = new byte[4][2304];
        o = g1;
        t = v1;
        for(int j1 = 0; j1 < 64; j1++)
            A[j1] = g.d(255 - j1 * 4, 255 - (int)((double)j1 * 1.75D), 255 - j1 * 4);

        for(int k1 = 0; k1 < 64; k1++)
            A[k1 + 64] = g.d(k1 * 3, 144, 0);

        for(int l1 = 0; l1 < 64; l1++)
            A[l1 + 128] = g.d(192 - (int)((double)l1 * 1.5D), 144 - (int)((double)l1 * 1.5D), 0);

        for(int i2 = 0; i2 < 64; i2++)
            A[i2 + 192] = g.d(96 - (int)((double)i2 * 1.5D), 48 + (int)((double)i2 * 1.5D), 0);

    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        u u1 = p[i1 + j1 * 8];
        for(int j2 = 0; j2 < u1.m; j2++)
            if(u1.tb[j2] == k1 * 128 && u1.vb[j2] == l1 * 128)
            {
                u1.c(j2, i2);
                return;
            }

    }

    public int a(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return m[byte0][i1 * 48 + j1];
    }

    public boolean b(int i1, int j1)
    {
        return e(i1, j1) > 0 || e(i1 - 1, j1) > 0 || e(i1 - 1, j1 - 1) > 0 || e(i1, j1 - 1) > 0;
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        int i2 = f.J;
        if(i1 < 1 || j1 < 1 || i1 + k1 >= 96 || j1 + l1 >= 96)
            return;
        for(int j2 = i1; j2 <= i1 + k1; j2++)
        {
            for(int k2 = j1; k2 <= j1 + l1; k2++)
                if((k(j2, k2) & 0x63) != 0 || (k(j2 - 1, k2) & 0x59) != 0 || (k(j2, k2 - 1) & 0x56) != 0 || (k(j2 - 1, k2 - 1) & 0x6c) != 0)
                    h(j2, k2, 35);
                else
                    h(j2, k2, 0);

        }

    }

    public int c(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return (i[byte0][i1 * 48 + j1] & 0xff) * 3;
    }

    public int d(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return l[byte0][i1 * 48 + j1] & 0xff;
    }

    public void a(int i1, int j1, int k1)
    {
        int l1 = f.J;
        if(i1 < 0 || j1 < 0 || i1 >= 95 || j1 >= 95)
            return;
        if(f.ub[k1] == 1 || f.ub[k1] == 2)
        {
            int i2 = a(i1, j1);
            int j2;
            int k2;
            if(i2 == 0 || i2 == 4)
            {
                j2 = f.sb[k1];
                k2 = f.tb[k1];
            } else
            {
                k2 = f.sb[k1];
                j2 = f.tb[k1];
            }
            for(int l2 = i1; l2 < i1 + j2; l2++)
            {
                for(int i3 = j1; i3 < j1 + k2; i3++)
                {
                    if(f.ub[k1] == 1)
                    {
                        F[l2][i3] |= 0x40;
                        continue;
                    }
                    if(i2 == 0)
                    {
                        F[l2][i3] |= 2;
                        if(l2 > 0)
                            b(l2 - 1, i3, 8);
                        continue;
                    }
                    if(i2 == 2)
                    {
                        F[l2][i3] |= 4;
                        if(i3 < 95)
                            b(l2, i3 + 1, 1);
                        continue;
                    }
                    if(i2 == 4)
                    {
                        F[l2][i3] |= 8;
                        if(l2 < 95)
                            b(l2 + 1, i3, 2);
                        continue;
                    }
                    if(i2 != 6)
                        continue;
                    F[l2][i3] |= 1;
                    if(i3 > 0)
                        b(l2, i3 - 1, 4);
                }

            }

            a(i1, j1, j2, k2);
        }
    }

    public void a()
    {
        int i1 = f.J;
        if(b)
            o.a();
        for(int j1 = 0; j1 < 64; j1++)
        {
            p[j1] = null;
            for(int k1 = 0; k1 < 4; k1++)
                r[k1][j1] = null;

            for(int l1 = 0; l1 < 4; l1++)
                q[l1][j1] = null;

        }

        System.gc();
    }

    public void b(int i1, int j1, int k1)
    {
        F[i1][j1] |= k1;
    }

    public void c(int i1, int j1, int k1)
    {
        F[i1][j1] &= 65535 - k1;
    }

    public int a(int i1, int j1, int k1, int l1, int i2, int j2, int ai[], 
            int ai1[], boolean flag)
    {
        int k2 = f.J;
        for(int l2 = 0; l2 < 96; l2++)
        {
            for(int j3 = 0; j3 < 96; j3++)
                C[l2][j3] = 0;

        }

        int i3 = 0;
        int k3 = 0;
        int l3 = i1;
        int i4 = j1;
        C[i1][j1] = 99;
        ai[i3] = i1;
        ai1[i3++] = j1;
        int j4 = ai.length;
        boolean flag1 = false;
        do
        {
            if(k3 == i3)
                break;
            l3 = ai[k3];
            i4 = ai1[k3];
            k3 = (k3 + 1) % j4;
            if(l3 >= k1 && l3 <= i2 && i4 >= l1 && i4 <= j2)
            {
                flag1 = true;
                break;
            }
            if(flag)
            {
                if(l3 > 0 && l3 - 1 >= k1 && l3 - 1 <= i2 && i4 >= l1 && i4 <= j2 && (F[l3 - 1][i4] & 8) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(l3 < 95 && l3 + 1 >= k1 && l3 + 1 <= i2 && i4 >= l1 && i4 <= j2 && (F[l3 + 1][i4] & 2) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(i4 > 0 && l3 >= k1 && l3 <= i2 && i4 - 1 >= l1 && i4 - 1 <= j2 && (F[l3][i4 - 1] & 4) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(i4 < 95 && l3 >= k1 && l3 <= i2 && i4 + 1 >= l1 && i4 + 1 <= j2 && (F[l3][i4 + 1] & 1) == 0)
                {
                    flag1 = true;
                    break;
                }
            }
            if(l3 > 0 && C[l3 - 1][i4] == 0 && (F[l3 - 1][i4] & 0x78) == 0)
            {
                ai[i3] = l3 - 1;
                ai1[i3] = i4;
                i3 = (i3 + 1) % j4;
                C[l3 - 1][i4] = 2;
            }
            if(l3 < 95 && C[l3 + 1][i4] == 0 && (F[l3 + 1][i4] & 0x72) == 0)
            {
                ai[i3] = l3 + 1;
                ai1[i3] = i4;
                i3 = (i3 + 1) % j4;
                C[l3 + 1][i4] = 8;
            }
            if(i4 > 0 && C[l3][i4 - 1] == 0 && (F[l3][i4 - 1] & 0x74) == 0)
            {
                ai[i3] = l3;
                ai1[i3] = i4 - 1;
                i3 = (i3 + 1) % j4;
                C[l3][i4 - 1] = 1;
            }
            if(i4 < 95 && C[l3][i4 + 1] == 0 && (F[l3][i4 + 1] & 0x71) == 0)
            {
                ai[i3] = l3;
                ai1[i3] = i4 + 1;
                i3 = (i3 + 1) % j4;
                C[l3][i4 + 1] = 4;
            }
            if(l3 > 0 && i4 > 0 && (F[l3][i4 - 1] & 0x74) == 0 && (F[l3 - 1][i4] & 0x78) == 0 && (F[l3 - 1][i4 - 1] & 0x7c) == 0 && C[l3 - 1][i4 - 1] == 0)
            {
                ai[i3] = l3 - 1;
                ai1[i3] = i4 - 1;
                i3 = (i3 + 1) % j4;
                C[l3 - 1][i4 - 1] = 3;
            }
            if(l3 < 95 && i4 > 0 && (F[l3][i4 - 1] & 0x74) == 0 && (F[l3 + 1][i4] & 0x72) == 0 && (F[l3 + 1][i4 - 1] & 0x76) == 0 && C[l3 + 1][i4 - 1] == 0)
            {
                ai[i3] = l3 + 1;
                ai1[i3] = i4 - 1;
                i3 = (i3 + 1) % j4;
                C[l3 + 1][i4 - 1] = 9;
            }
            if(l3 > 0 && i4 < 95 && (F[l3][i4 + 1] & 0x71) == 0 && (F[l3 - 1][i4] & 0x78) == 0 && (F[l3 - 1][i4 + 1] & 0x79) == 0 && C[l3 - 1][i4 + 1] == 0)
            {
                ai[i3] = l3 - 1;
                ai1[i3] = i4 + 1;
                i3 = (i3 + 1) % j4;
                C[l3 - 1][i4 + 1] = 6;
            }
            if(l3 < 95 && i4 < 95 && (F[l3][i4 + 1] & 0x71) == 0 && (F[l3 + 1][i4] & 0x72) == 0 && (F[l3 + 1][i4 + 1] & 0x73) == 0 && C[l3 + 1][i4 + 1] == 0)
            {
                ai[i3] = l3 + 1;
                ai1[i3] = i4 + 1;
                i3 = (i3 + 1) % j4;
                C[l3 + 1][i4 + 1] = 12;
            }
        } while(true);
        if(!flag1)
            return -1;
        k3 = 0;
        ai[k3] = l3;
        ai1[k3++] = i4;
        int k4;
        for(int l4 = k4 = C[l3][i4]; l3 != i1 || i4 != j1; l4 = C[l3][i4])
        {
            if(l4 != k4)
            {
                k4 = l4;
                ai[k3] = l3;
                ai1[k3++] = i4;
            }
            if((l4 & 2) != 0)
                l3++;
            else
            if((l4 & 8) != 0)
                l3--;
            if((l4 & 1) != 0)
            {
                i4++;
                continue;
            }
            if((l4 & 4) != 0)
                i4--;
        }

        return k3;
    }

    public void b(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = i1 * 3;
        int k2 = j1 * 3;
        int l2 = o.h(l1);
        int i3 = o.h(i2);
        l2 = l2 >> 1 & 0x7f7f7f;
        i3 = i3 >> 1 & 0x7f7f7f;
        if(k1 == 0)
        {
            t.b(j2, k2, 3, l2);
            t.b(j2, k2 + 1, 2, l2);
            t.b(j2, k2 + 2, 1, l2);
            t.b(j2 + 2, k2 + 1, 1, i3);
            t.b(j2 + 1, k2 + 2, 2, i3);
            return;
        }
        if(k1 == 1)
        {
            t.b(j2, k2, 3, i3);
            t.b(j2 + 1, k2 + 1, 2, i3);
            t.b(j2 + 2, k2 + 2, 1, i3);
            t.b(j2, k2 + 1, 1, l2);
            t.b(j2, k2 + 2, 2, l2);
        }
    }

    public void a(int i1, int j1, int k1, boolean flag)
    {
        boolean flag2;
label0:
        {
            flag2 = v.R;
            int l1 = f.J;
            int i2 = (i1 + 24) / 48;
            int j2 = (j1 + 24) / 48;
            c(i2 - 1, j2 - 1, k1, 0);
            c(i2, j2 - 1, k1, 1);
            c(i2 - 1, j2, k1, 2);
            c(i2, j2, k1, 3);
            b();
            if(s == null)
                s = new u(18688, 18688, true, true, false, false, true);
            if(!flag)
                break label0;
            t.c();
            int k2 = 0;
            do
            {
                if(k2 >= 96)
                    break;
                int i3 = 0;
                do
                {
                    if(i3 >= 96)
                        break;
                    F[k2][i3] = 0;
                    i3++;
                } while(!flag2);
                k2++;
            } while(!flag2);
            u u1 = s;
            u1.b();
            int j3 = 0;
            do
            {
                if(j3 >= 96)
                    break;
                int l3 = 0;
                do
                {
                    if(l3 >= 96)
                        break;
                    int i6 = -c(j3, l3);
                    if(f(j3, l3, k1) > 0 && f.hb[f(j3, l3, k1) - 1] == 4)
                        i6 = 0;
                    if(f(j3 - 1, l3, k1) > 0 && f.hb[f(j3 - 1, l3, k1) - 1] == 4)
                        i6 = 0;
                    if(f(j3, l3 - 1, k1) > 0 && f.hb[f(j3, l3 - 1, k1) - 1] == 4)
                        i6 = 0;
                    if(f(j3 - 1, l3 - 1, k1) > 0 && f.hb[f(j3 - 1, l3 - 1, k1) - 1] == 4)
                        i6 = 0;
                    int l8 = u1.a(j3 * 128, i6, l3 * 128);
                    int i11 = (int)(Math.random() * 10D) - 5;
                    u1.c(l8, i11);
                    l3++;
                } while(!flag2);
                j3++;
            } while(!flag2);
            j3 = 0;
            do
            {
                if(j3 >= 95)
                    break;
                int i4 = 0;
label1:
                do
                {
                    int i9;
                    int j11;
                    int j15;
label2:
                    {
                        int j17;
label3:
                        {
                            if(i4 >= 95)
                                break label1;
                            int j6 = h(j3, i4);
                            i9 = A[j6];
                            j11 = i9;
                            int j13 = i9;
                            j15 = 0;
                            if(k1 == 1 || k1 == 2)
                            {
                                i9 = 0xbc614e;
                                j11 = 0xbc614e;
                                j13 = 0xbc614e;
                            }
                            if(f(j3, i4, k1) <= 0)
                                break label2;
                            j17 = f(j3, i4, k1);
                            int j18 = f.hb[j17 - 1];
                            int j20 = e(j3, i4, k1);
                            i9 = j11 = f.gb[j17 - 1];
                            if(j18 == 4)
                            {
                                i9 = 1;
                                j11 = 1;
                                if(j17 == 12)
                                {
                                    i9 = 31;
                                    j11 = 31;
                                }
                            }
                            if(j18 == 5)
                            {
                                if(j(j3, i4) <= 0 || j(j3, i4) >= 24000)
                                    break label3;
                                if(e(j3 - 1, i4, k1, j13) != 0xbc614e && e(j3, i4 - 1, k1, j13) != 0xbc614e)
                                {
                                    i9 = e(j3 - 1, i4, k1, j13);
                                    j15 = 0;
                                    if(!flag2)
                                        break label3;
                                }
                                if(e(j3 + 1, i4, k1, j13) != 0xbc614e && e(j3, i4 + 1, k1, j13) != 0xbc614e)
                                {
                                    j11 = e(j3 + 1, i4, k1, j13);
                                    j15 = 0;
                                    if(!flag2)
                                        break label3;
                                }
                                if(e(j3 + 1, i4, k1, j13) != 0xbc614e && e(j3, i4 - 1, k1, j13) != 0xbc614e)
                                {
                                    j11 = e(j3 + 1, i4, k1, j13);
                                    j15 = 1;
                                    if(!flag2)
                                        break label3;
                                }
                                if(e(j3 - 1, i4, k1, j13) == 0xbc614e || e(j3, i4 + 1, k1, j13) == 0xbc614e)
                                    break label3;
                                i9 = e(j3 - 1, i4, k1, j13);
                                j15 = 1;
                                if(!flag2)
                                    break label3;
                            }
                            if(j18 == 2 && (j(j3, i4) <= 0 || j(j3, i4) >= 24000))
                                break label3;
                            if(e(j3 - 1, i4, k1) != j20 && e(j3, i4 - 1, k1) != j20)
                            {
                                i9 = j13;
                                j15 = 0;
                                if(!flag2)
                                    break label3;
                            }
                            if(e(j3 + 1, i4, k1) != j20 && e(j3, i4 + 1, k1) != j20)
                            {
                                j11 = j13;
                                j15 = 0;
                                if(!flag2)
                                    break label3;
                            }
                            if(e(j3 + 1, i4, k1) != j20 && e(j3, i4 - 1, k1) != j20)
                            {
                                j11 = j13;
                                j15 = 1;
                                if(!flag2)
                                    break label3;
                            }
                            if(e(j3 - 1, i4, k1) != j20 && e(j3, i4 + 1, k1) != j20)
                            {
                                i9 = j13;
                                j15 = 1;
                            }
                        }
                        if(f.ib[j17 - 1] != 0)
                            F[j3][i4] |= 0x40;
                        if(f.hb[j17 - 1] == 2)
                            F[j3][i4] |= 0x80;
                    }
label4:
                    {
                        b(j3, i4, j15, i9, j11);
                        int k17 = ((c(j3 + 1, i4 + 1) - c(j3 + 1, i4)) + c(j3, i4 + 1)) - c(j3, i4);
                        if(i9 != j11 || k17 != 0)
                        {
                            int ai5[] = new int[3];
                            int ai7[] = new int[3];
                            if(j15 == 0)
                            {
                                if(i9 != 0xbc614e)
                                {
                                    ai5[0] = i4 + j3 * 96 + 96;
                                    ai5[1] = i4 + j3 * 96;
                                    ai5[2] = i4 + j3 * 96 + 1;
                                    int j21 = u1.a(3, ai5, 0xbc614e, i9);
                                    B[j21] = j3;
                                    z[j21] = i4;
                                    u1.pb[j21] = 0x30d40 + j21;
                                }
                                if(j11 == 0xbc614e)
                                    break label4;
                                ai7[0] = i4 + j3 * 96 + 1;
                                ai7[1] = i4 + j3 * 96 + 96 + 1;
                                ai7[2] = i4 + j3 * 96 + 96;
                                int k21 = u1.a(3, ai7, 0xbc614e, j11);
                                B[k21] = j3;
                                z[k21] = i4;
                                u1.pb[k21] = 0x30d40 + k21;
                                if(!flag2)
                                    break label4;
                            }
                            if(i9 != 0xbc614e)
                            {
                                ai5[0] = i4 + j3 * 96 + 1;
                                ai5[1] = i4 + j3 * 96 + 96 + 1;
                                ai5[2] = i4 + j3 * 96;
                                int l21 = u1.a(3, ai5, 0xbc614e, i9);
                                B[l21] = j3;
                                z[l21] = i4;
                                u1.pb[l21] = 0x30d40 + l21;
                            }
                            if(j11 == 0xbc614e)
                                break label4;
                            ai7[0] = i4 + j3 * 96 + 96;
                            ai7[1] = i4 + j3 * 96;
                            ai7[2] = i4 + j3 * 96 + 96 + 1;
                            int i22 = u1.a(3, ai7, 0xbc614e, j11);
                            B[i22] = j3;
                            z[i22] = i4;
                            u1.pb[i22] = 0x30d40 + i22;
                            if(!flag2)
                                break label4;
                        }
                        if(i9 != 0xbc614e)
                        {
                            int ai6[] = new int[4];
                            ai6[0] = i4 + j3 * 96 + 96;
                            ai6[1] = i4 + j3 * 96;
                            ai6[2] = i4 + j3 * 96 + 1;
                            ai6[3] = i4 + j3 * 96 + 96 + 1;
                            int k20 = u1.a(4, ai6, 0xbc614e, i9);
                            B[k20] = j3;
                            z[k20] = i4;
                            u1.pb[k20] = 0x30d40 + k20;
                        }
                    }
                    i4++;
                } while(!flag2);
                j3++;
            } while(!flag2);
            j3 = 1;
            do
            {
                if(j3 >= 95)
                    break;
                int j4 = 1;
label5:
                do
                {
label6:
                    {
                        if(j4 >= 95)
                            break label5;
                        if(f(j3, j4, k1) > 0 && f.hb[f(j3, j4, k1) - 1] == 4)
                        {
                            int k6 = f.gb[f(j3, j4, k1) - 1];
                            int j9 = u1.a(j3 * 128, -c(j3, j4), j4 * 128);
                            int k11 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4), j4 * 128);
                            int k13 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4 + 1), (j4 + 1) * 128);
                            int k15 = u1.a(j3 * 128, -c(j3, j4 + 1), (j4 + 1) * 128);
                            int ai[] = {
                                j9, k11, k13, k15
                            };
                            int k18 = u1.a(4, ai, k6, 0xbc614e);
                            B[k18] = j3;
                            z[k18] = j4;
                            u1.pb[k18] = 0x30d40 + k18;
                            b(j3, j4, 0, k6, k6);
                            if(!flag2)
                                break label6;
                        }
                        if(f(j3, j4, k1) == 0 || f.hb[f(j3, j4, k1) - 1] != 3)
                        {
                            if(f(j3, j4 + 1, k1) > 0 && f.hb[f(j3, j4 + 1, k1) - 1] == 4)
                            {
                                int l6 = f.gb[f(j3, j4 + 1, k1) - 1];
                                int k9 = u1.a(j3 * 128, -c(j3, j4), j4 * 128);
                                int l11 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4), j4 * 128);
                                int l13 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4 + 1), (j4 + 1) * 128);
                                int l15 = u1.a(j3 * 128, -c(j3, j4 + 1), (j4 + 1) * 128);
                                int ai1[] = {
                                    k9, l11, l13, l15
                                };
                                int l18 = u1.a(4, ai1, l6, 0xbc614e);
                                B[l18] = j3;
                                z[l18] = j4;
                                u1.pb[l18] = 0x30d40 + l18;
                                b(j3, j4, 0, l6, l6);
                            }
                            if(f(j3, j4 - 1, k1) > 0 && f.hb[f(j3, j4 - 1, k1) - 1] == 4)
                            {
                                int i7 = f.gb[f(j3, j4 - 1, k1) - 1];
                                int l9 = u1.a(j3 * 128, -c(j3, j4), j4 * 128);
                                int i12 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4), j4 * 128);
                                int i14 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4 + 1), (j4 + 1) * 128);
                                int i16 = u1.a(j3 * 128, -c(j3, j4 + 1), (j4 + 1) * 128);
                                int ai2[] = {
                                    l9, i12, i14, i16
                                };
                                int i19 = u1.a(4, ai2, i7, 0xbc614e);
                                B[i19] = j3;
                                z[i19] = j4;
                                u1.pb[i19] = 0x30d40 + i19;
                                b(j3, j4, 0, i7, i7);
                            }
                            if(f(j3 + 1, j4, k1) > 0 && f.hb[f(j3 + 1, j4, k1) - 1] == 4)
                            {
                                int j7 = f.gb[f(j3 + 1, j4, k1) - 1];
                                int i10 = u1.a(j3 * 128, -c(j3, j4), j4 * 128);
                                int j12 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4), j4 * 128);
                                int j14 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4 + 1), (j4 + 1) * 128);
                                int j16 = u1.a(j3 * 128, -c(j3, j4 + 1), (j4 + 1) * 128);
                                int ai3[] = {
                                    i10, j12, j14, j16
                                };
                                int j19 = u1.a(4, ai3, j7, 0xbc614e);
                                B[j19] = j3;
                                z[j19] = j4;
                                u1.pb[j19] = 0x30d40 + j19;
                                b(j3, j4, 0, j7, j7);
                            }
                            if(f(j3 - 1, j4, k1) > 0 && f.hb[f(j3 - 1, j4, k1) - 1] == 4)
                            {
                                int k7 = f.gb[f(j3 - 1, j4, k1) - 1];
                                int j10 = u1.a(j3 * 128, -c(j3, j4), j4 * 128);
                                int k12 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4), j4 * 128);
                                int k14 = u1.a((j3 + 1) * 128, -c(j3 + 1, j4 + 1), (j4 + 1) * 128);
                                int k16 = u1.a(j3 * 128, -c(j3, j4 + 1), (j4 + 1) * 128);
                                int ai4[] = {
                                    j10, k12, k14, k16
                                };
                                int k19 = u1.a(4, ai4, k7, 0xbc614e);
                                B[k19] = j3;
                                z[k19] = j4;
                                u1.pb[k19] = 0x30d40 + k19;
                                b(j3, j4, 0, k7, k7);
                            }
                        }
                    }
                    j4++;
                } while(!flag2);
                j3++;
            } while(!flag2);
            u1.a(true, 40, 48, -50, -10, -50);
            p = s.a(0, 0, 1536, 1536, 8, 64, 233, false);
            j3 = 0;
            do
            {
                if(j3 >= 64)
                    break;
                o.a(p[j3]);
                j3++;
            } while(!flag2);
            j3 = 0;
            do
            {
                if(j3 >= 96)
                    break;
                int k4 = 0;
                do
                {
                    if(k4 >= 96)
                        break;
                    E[j3][k4] = c(j3, k4);
                    k4++;
                } while(!flag2);
                j3++;
            } while(!flag2);
        }
        s.b();
        int l2 = 0x606060;
        int k3 = 0;
        do
        {
            if(k3 >= 95)
                break;
            int l4 = 0;
            do
            {
                if(l4 >= 95)
                    break;
                int l7 = d(k3, l4);
                if(l7 > 0 && (f.Ab[l7 - 1] == 0 || a))
                {
                    a(s, l7 - 1, k3, l4, k3 + 1, l4);
                    if(flag && f.zb[l7 - 1] != 0)
                    {
                        F[k3][l4] |= 1;
                        if(l4 > 0)
                            b(k3, l4 - 1, 4);
                    }
                    if(flag)
                        t.b(k3 * 3, l4 * 3, 3, l2);
                }
                l7 = i(k3, l4);
                if(l7 > 0 && (f.Ab[l7 - 1] == 0 || a))
                {
                    a(s, l7 - 1, k3, l4, k3, l4 + 1);
                    if(flag && f.zb[l7 - 1] != 0)
                    {
                        F[k3][l4] |= 2;
                        if(k3 > 0)
                            b(k3 - 1, l4, 8);
                    }
                    if(flag)
                        t.c(k3 * 3, l4 * 3, 3, l2);
                }
                l7 = j(k3, l4);
                if(l7 > 0 && l7 < 12000 && (f.Ab[l7 - 1] == 0 || a))
                {
                    a(s, l7 - 1, k3, l4, k3 + 1, l4 + 1);
                    if(flag && f.zb[l7 - 1] != 0)
                        F[k3][l4] |= 0x20;
                    if(flag)
                    {
                        t.a(k3 * 3, l4 * 3, l2);
                        t.a(k3 * 3 + 1, l4 * 3 + 1, l2);
                        t.a(k3 * 3 + 2, l4 * 3 + 2, l2);
                    }
                }
                if(l7 > 12000 && l7 < 24000 && (f.Ab[l7 - 12001] == 0 || a))
                {
                    a(s, l7 - 12001, k3 + 1, l4, k3, l4 + 1);
                    if(flag && f.zb[l7 - 12001] != 0)
                        F[k3][l4] |= 0x10;
                    if(flag)
                    {
                        t.a(k3 * 3 + 2, l4 * 3, l2);
                        t.a(k3 * 3 + 1, l4 * 3 + 1, l2);
                        t.a(k3 * 3, l4 * 3 + 2, l2);
                    }
                }
                l4++;
            } while(!flag2);
            k3++;
        } while(!flag2);
        if(flag)
            t.d(w - 1, 0, 0, 285, 285);
        s.a(false, 60, 24, -50, -10, -50);
        r[k1] = s.a(0, 0, 1536, 1536, 8, 64, 338, true);
        k3 = 0;
        do
        {
            if(k3 >= 64)
                break;
            o.a(r[k1][k3]);
            k3++;
        } while(!flag2);
        k3 = 0;
        do
        {
            if(k3 >= 95)
                break;
            int i5 = 0;
            do
            {
                if(i5 >= 95)
                    break;
                int i8 = d(k3, i5);
                if(i8 > 0)
                    c(i8 - 1, k3, i5, k3 + 1, i5);
                i8 = i(k3, i5);
                if(i8 > 0)
                    c(i8 - 1, k3, i5, k3, i5 + 1);
                i8 = j(k3, i5);
                if(i8 > 0 && i8 < 12000)
                    c(i8 - 1, k3, i5, k3 + 1, i5 + 1);
                if(i8 > 12000 && i8 < 24000)
                    c(i8 - 12001, k3 + 1, i5, k3, i5 + 1);
                i5++;
            } while(!flag2);
            k3++;
        } while(!flag2);
        k3 = 1;
        do
        {
            if(k3 >= 95)
                break;
            int j5 = 1;
label7:
            do
            {
label8:
                {
                    int l14;
                    int l16;
                    int l17;
                    int l19;
                    int l20;
                    int j22;
                    int l22;
                    int l23;
                    int j24;
                    int l24;
label9:
                    {
                        if(j5 >= 95)
                            break label7;
                        int j8 = e(k3, j5);
                        if(j8 <= 0)
                            break label8;
                        int k10 = k3;
                        int l12 = j5;
                        l14 = k3 + 1;
                        l16 = j5;
                        l17 = k3 + 1;
                        l19 = j5 + 1;
                        l20 = k3;
                        j22 = j5 + 1;
                        l22 = 0;
                        int j23 = E[k10][l12];
                        l23 = E[l14][l16];
                        j24 = E[l17][l19];
                        l24 = E[l20][j22];
                        if(j23 > 0x13880)
                            j23 -= 0x13880;
                        if(l23 > 0x13880)
                            l23 -= 0x13880;
                        if(j24 > 0x13880)
                            j24 -= 0x13880;
                        if(l24 > 0x13880)
                            l24 -= 0x13880;
                        if(j23 > l22)
                            l22 = j23;
                        if(l23 > l22)
                            l22 = l23;
                        if(j24 > l22)
                            l22 = j24;
                        if(l24 > l22)
                            l22 = l24;
                        if(l22 >= 0x13880)
                            l22 -= 0x13880;
                        if(j23 < 0x13880)
                        {
                            E[k10][l12] = l22;
                            if(!flag2)
                                break label9;
                        }
                        E[k10][l12] -= 0x13880;
                    }
label10:
                    {
                        if(l23 < 0x13880)
                        {
                            E[l14][l16] = l22;
                            if(!flag2)
                                break label10;
                        }
                        E[l14][l16] -= 0x13880;
                    }
label11:
                    {
                        if(j24 < 0x13880)
                        {
                            E[l17][l19] = l22;
                            if(!flag2)
                                break label11;
                        }
                        E[l17][l19] -= 0x13880;
                    }
                    if(l24 < 0x13880)
                    {
                        E[l20][j22] = l22;
                        if(!flag2)
                            break label8;
                    }
                    E[l20][j22] -= 0x13880;
                }
                j5++;
            } while(!flag2);
            k3++;
        } while(!flag2);
        s.b();
        k3 = 1;
        do
        {
            if(k3 >= 95)
                break;
            int k5 = 1;
label12:
            do
            {
label13:
                {
                    if(k5 >= 95)
                        break label12;
                    int k8 = e(k3, k5);
                    if(k8 <= 0)
                        break label13;
                    int l10 = k3;
                    int i13 = k5;
                    int i15 = k3 + 1;
                    int i17 = k5;
                    int i18 = k3 + 1;
                    int i20 = k5 + 1;
                    int i21 = k3;
                    int k22 = k5 + 1;
                    int i23 = k3 * 128;
                    int k23 = k5 * 128;
                    int i24 = i23 + 128;
                    int k24 = k23 + 128;
                    int i25 = i23;
                    int j25 = k23;
                    int k25 = i24;
                    int l25 = k24;
                    int i26 = E[l10][i13];
                    int j26 = E[i15][i17];
                    int k26 = E[i18][i20];
                    int l26 = E[i21][k22];
                    int i27 = f.ab[k8 - 1];
                    if(f(l10, i13) && i26 < 0x13880)
                    {
                        i26 += i27 + 0x13880;
                        E[l10][i13] = i26;
                    }
                    if(f(i15, i17) && j26 < 0x13880)
                    {
                        j26 += i27 + 0x13880;
                        E[i15][i17] = j26;
                    }
                    if(f(i18, i20) && k26 < 0x13880)
                    {
                        k26 += i27 + 0x13880;
                        E[i18][i20] = k26;
                    }
                    if(f(i21, k22) && l26 < 0x13880)
                    {
                        l26 += i27 + 0x13880;
                        E[i21][k22] = l26;
                    }
                    if(i26 >= 0x13880)
                        i26 -= 0x13880;
                    if(j26 >= 0x13880)
                        j26 -= 0x13880;
                    if(k26 >= 0x13880)
                        k26 -= 0x13880;
                    if(l26 >= 0x13880)
                        l26 -= 0x13880;
                    byte byte0 = 16;
                    if(!b(l10 - 1, i13))
                        i23 -= byte0;
                    if(!b(l10 + 1, i13))
                        i23 += byte0;
                    if(!b(l10, i13 - 1))
                        k23 -= byte0;
                    if(!b(l10, i13 + 1))
                        k23 += byte0;
                    if(!b(i15 - 1, i17))
                        i24 -= byte0;
                    if(!b(i15 + 1, i17))
                        i24 += byte0;
                    if(!b(i15, i17 - 1))
                        j25 -= byte0;
                    if(!b(i15, i17 + 1))
                        j25 += byte0;
                    if(!b(i18 - 1, i20))
                        k25 -= byte0;
                    if(!b(i18 + 1, i20))
                        k25 += byte0;
                    if(!b(i18, i20 - 1))
                        k24 -= byte0;
                    if(!b(i18, i20 + 1))
                        k24 += byte0;
                    if(!b(i21 - 1, k22))
                        i25 -= byte0;
                    if(!b(i21 + 1, k22))
                        i25 += byte0;
                    if(!b(i21, k22 - 1))
                        l25 -= byte0;
                    if(!b(i21, k22 + 1))
                        l25 += byte0;
                    k8 = f.bb[k8 - 1];
                    i26 = -i26;
                    j26 = -j26;
                    k26 = -k26;
                    l26 = -l26;
                    if(j(k3, k5) > 12000 && j(k3, k5) < 24000 && e(k3 - 1, k5 - 1) == 0)
                    {
                        int ai8[] = new int[3];
                        ai8[0] = s.a(k25, k26, k24);
                        ai8[1] = s.a(i25, l26, l25);
                        ai8[2] = s.a(i24, j26, j25);
                        s.a(3, ai8, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    if(j(k3, k5) > 12000 && j(k3, k5) < 24000 && e(k3 + 1, k5 + 1) == 0)
                    {
                        int ai9[] = new int[3];
                        ai9[0] = s.a(i23, i26, k23);
                        ai9[1] = s.a(i24, j26, j25);
                        ai9[2] = s.a(i25, l26, l25);
                        s.a(3, ai9, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    if(j(k3, k5) > 0 && j(k3, k5) < 12000 && e(k3 + 1, k5 - 1) == 0)
                    {
                        int ai10[] = new int[3];
                        ai10[0] = s.a(i25, l26, l25);
                        ai10[1] = s.a(i23, i26, k23);
                        ai10[2] = s.a(k25, k26, k24);
                        s.a(3, ai10, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    if(j(k3, k5) > 0 && j(k3, k5) < 12000 && e(k3 - 1, k5 + 1) == 0)
                    {
                        int ai11[] = new int[3];
                        ai11[0] = s.a(i24, j26, j25);
                        ai11[1] = s.a(k25, k26, k24);
                        ai11[2] = s.a(i23, i26, k23);
                        s.a(3, ai11, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    if(i26 == j26 && k26 == l26)
                    {
                        int ai12[] = new int[4];
                        ai12[0] = s.a(i23, i26, k23);
                        ai12[1] = s.a(i24, j26, j25);
                        ai12[2] = s.a(k25, k26, k24);
                        ai12[3] = s.a(i25, l26, l25);
                        s.a(4, ai12, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    if(i26 == l26 && j26 == k26)
                    {
                        int ai13[] = new int[4];
                        ai13[0] = s.a(i25, l26, l25);
                        ai13[1] = s.a(i23, i26, k23);
                        ai13[2] = s.a(i24, j26, j25);
                        ai13[3] = s.a(k25, k26, k24);
                        s.a(4, ai13, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    boolean flag1 = true;
                    if(e(k3 - 1, k5 - 1) > 0)
                        flag1 = false;
                    if(e(k3 + 1, k5 + 1) > 0)
                        flag1 = false;
                    if(!flag1)
                    {
                        int ai14[] = new int[3];
                        ai14[0] = s.a(i24, j26, j25);
                        ai14[1] = s.a(k25, k26, k24);
                        ai14[2] = s.a(i23, i26, k23);
                        s.a(3, ai14, k8, 0xbc614e);
                        int ai16[] = new int[3];
                        ai16[0] = s.a(i25, l26, l25);
                        ai16[1] = s.a(i23, i26, k23);
                        ai16[2] = s.a(k25, k26, k24);
                        s.a(3, ai16, k8, 0xbc614e);
                        if(!flag2)
                            break label13;
                    }
                    int ai15[] = new int[3];
                    ai15[0] = s.a(i23, i26, k23);
                    ai15[1] = s.a(i24, j26, j25);
                    ai15[2] = s.a(i25, l26, l25);
                    s.a(3, ai15, k8, 0xbc614e);
                    int ai17[] = new int[3];
                    ai17[0] = s.a(k25, k26, k24);
                    ai17[1] = s.a(i25, l26, l25);
                    ai17[2] = s.a(i24, j26, j25);
                    s.a(3, ai17, k8, 0xbc614e);
                }
                k5++;
            } while(!flag2);
            k3++;
        } while(!flag2);
        s.a(true, 50, 50, -50, -10, -50);
        q[k1] = s.a(0, 0, 1536, 1536, 8, 64, 169, true);
        k3 = 0;
        do
        {
            if(k3 >= 64)
                break;
            o.a(q[k1][k3]);
            k3++;
        } while(!flag2);
        if(q[k1][0] == null)
            throw new RuntimeException(G[5]);
        k3 = 0;
        do
        {
            if(k3 >= 96)
                break;
            int l5 = 0;
            do
            {
                if(l5 >= 96)
                    break;
                if(E[k3][l5] >= 0x13880)
                    E[k3][l5] -= 0x13880;
                l5++;
            } while(!flag2);
            k3++;
        } while(!flag2);
    }

    public int e(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return h[byte0][i1 * 48 + j1];
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        int i2 = f.J;
        if(i1 < 0 || j1 < 0 || i1 >= 95 || j1 >= 95)
            return;
        if(f.zb[l1] == 1)
        {
            if(k1 == 0)
            {
                F[i1][j1] |= 1;
                if(j1 > 0)
                    b(i1, j1 - 1, 4);
            } else
            if(k1 == 1)
            {
                F[i1][j1] |= 2;
                if(i1 > 0)
                    b(i1 - 1, j1, 8);
            } else
            if(k1 == 2)
                F[i1][j1] |= 0x10;
            else
            if(k1 == 3)
                F[i1][j1] |= 0x20;
            a(i1, j1, 1, 1);
        }
    }

    public void d(int i1, int j1, int k1)
    {
        a();
        int l1 = (i1 + 24) / 48;
        int i2 = (j1 + 24) / 48;
        a(i1, j1, k1, true);
        if(k1 == 0)
        {
            a(i1, j1, 1, false);
            a(i1, j1, 2, false);
            c(l1 - 1, i2 - 1, k1, 0);
            c(l1, i2 - 1, k1, 1);
            c(l1 - 1, i2, k1, 2);
            c(l1, i2, k1, 3);
            b();
        }
    }

    public boolean f(int i1, int j1)
    {
        return e(i1, j1) > 0 && e(i1 - 1, j1) > 0 && e(i1 - 1, j1 - 1) > 0 && e(i1, j1 - 1) > 0;
    }

    public void c(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = f.wb[i1];
        if(E[j1][k1] < 0x13880)
            E[j1][k1] += 0x13880 + j2;
        if(E[l1][i2] < 0x13880)
            E[l1][i2] += 0x13880 + j2;
    }

    public int e(int i1, int j1, int k1)
    {
        int l1 = f(i1, j1, k1);
        if(l1 == 0)
        {
            return -1;
        } else
        {
            int i2 = f.hb[l1 - 1];
            return i2 == 2 ? 1 : 0;
        }
    }

    public int f(int i1, int j1, int k1)
    {
        int l1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return n[byte0][i1 * 48 + j1] & 0xff;
    }

    public int g(int i1, int j1)
    {
        int k1 = i1 >> 7;
        int l1 = j1 >> 7;
        int i2 = i1 & 0x7f;
        int j2 = j1 & 0x7f;
        if(k1 < 0 || l1 < 0 || k1 >= 95 || l1 >= 95)
            return 0;
        int k2;
        int l2;
        int i3;
        if(i2 <= 128 - j2)
        {
            k2 = c(k1, l1);
            l2 = c(k1 + 1, l1) - k2;
            i3 = c(k1, l1 + 1) - k2;
        } else
        {
            k2 = c(k1 + 1, l1 + 1);
            l2 = c(k1, l1 + 1) - k2;
            i3 = c(k1 + 1, l1) - k2;
            i2 = 128 - i2;
            j2 = 128 - j2;
        }
        int j3 = k2 + (l2 * i2) / 128 + (i3 * j2) / 128;
        return j3;
    }

    public void g(int i1, int j1, int k1)
    {
        int l1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        n[byte0][i1 * 48 + j1] = (byte)k1;
    }

    public int h(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return k[byte0][i1 * 48 + j1] & 0xff;
    }

    public void c(int i1, int j1, int k1, int l1)
    {
        int i2 = f.J;
        String s1 = "m" + k1 + i1 / 10 + i1 % 10 + j1 / 10 + j1 % 10;
        byte abyte1[];
        int j3;
        int j5;
        int j7;
        try
        {
            if(d != null)
            {
                byte abyte0[] = m.a(s1 + G[2], 0, d);
                if(abyte0 == null && f != null)
                    abyte0 = m.a(s1 + G[2], 0, f);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int k2 = 0;
                    int k3 = 0;
                    int k5 = 0;
                    do
                    {
                        if(k5 >= 2304)
                            break;
                        int k7 = abyte0[k2++] & 0xff;
                        if(k7 < 128)
                        {
                            i[l1][k5++] = (byte)k7;
                            k3 = k7;
                        }
                        if(k7 >= 128)
                        {
                            int k9 = 0;
                            while(k9 < k7 - 128) 
                            {
                                i[l1][k5++] = (byte)k3;
                                k9++;
                            }
                        }
                    } while(true);
                    k3 = 64;
                    for(k5 = 0; k5 < 48; k5++)
                    {
                        for(int l7 = 0; l7 < 48; l7++)
                        {
                            k3 = i[l1][l7 * 48 + k5] + k3 & 0x7f;
                            i[l1][l7 * 48 + k5] = (byte)(k3 * 2);
                        }

                    }

                    k3 = 0;
                    k5 = 0;
                    do
                    {
                        if(k5 >= 2304)
                            break;
                        int i8 = abyte0[k2++] & 0xff;
                        if(i8 < 128)
                        {
                            k[l1][k5++] = (byte)i8;
                            k3 = i8;
                        }
                        if(i8 >= 128)
                        {
                            int l9 = 0;
                            while(l9 < i8 - 128) 
                            {
                                k[l1][k5++] = (byte)k3;
                                l9++;
                            }
                        }
                    } while(true);
                    k3 = 35;
                    for(int l5 = 0; l5 < 48; l5++)
                    {
                        for(int j8 = 0; j8 < 48; j8++)
                        {
                            k3 = k[l1][j8 * 48 + l5] + k3 & 0x7f;
                            k[l1][j8 * 48 + l5] = (byte)(k3 * 2);
                        }

                    }

                } else
                {
                    for(int l2 = 0; l2 < 2304; l2++)
                    {
                        i[l1][l2] = 0;
                        k[l1][l2] = 0;
                    }

                }
                abyte0 = m.a(s1 + G[0], 0, e);
                if(abyte0 == null && g != null)
                    abyte0 = m.a(s1 + G[0], 0, g);
                if(abyte0 == null || abyte0.length == 0)
                    throw new IOException();
                int i3 = 0;
                for(int l3 = 0; l3 < 2304; l3++)
                    j[l1][l3] = abyte0[i3++];

                for(int i4 = 0; i4 < 2304; i4++)
                    l[l1][i4] = abyte0[i3++];

                for(int j4 = 0; j4 < 2304; j4++)
                    D[l1][j4] = abyte0[i3++] & 0xff;

                for(int k4 = 0; k4 < 2304; k4++)
                {
                    int i6 = abyte0[i3++] & 0xff;
                    if(i6 > 0)
                        D[l1][k4] = i6 + 12000;
                }

                for(int l4 = 0; l4 < 2304;)
                {
                    int j6 = abyte0[i3++] & 0xff;
                    if(j6 < 128)
                    {
                        h[l1][l4++] = (byte)j6;
                    } else
                    {
                        int k8 = 0;
                        while(k8 < j6 - 128) 
                        {
                            h[l1][l4++] = 0;
                            k8++;
                        }
                    }
                }

                int i5 = 0;
                for(int k6 = 0; k6 < 2304;)
                {
                    int l8 = abyte0[i3++] & 0xff;
                    if(l8 < 128)
                    {
                        n[l1][k6++] = (byte)l8;
                        i5 = l8;
                    } else
                    {
                        int i10 = 0;
                        while(i10 < l8 - 128) 
                        {
                            n[l1][k6++] = (byte)i5;
                            i10++;
                        }
                    }
                }

                for(int l6 = 0; l6 < 2304;)
                {
                    int i9 = abyte0[i3++] & 0xff;
                    if(i9 < 128)
                    {
                        m[l1][l6++] = (byte)i9;
                    } else
                    {
                        int j10 = 0;
                        while(j10 < i9 - 128) 
                        {
                            m[l1][l6++] = 0;
                            j10++;
                        }
                    }
                }

                abyte0 = m.a(s1 + G[4], 0, e);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int i7 = 0;
                    for(int j9 = 0; j9 < 2304;)
                    {
                        int k10 = abyte0[i7++] & 0xff;
                        if(k10 < 128)
                            D[l1][j9++] = k10 + 48000;
                        else
                            j9 += k10 - 128;
                    }

                    return;
                }
                break MISSING_BLOCK_LABEL_1577;
            }
        }
        catch(IOException ioexception)
        {
            for(int j2 = 0; j2 < 2304; j2++)
            {
                i[l1][j2] = 0;
                k[l1][j2] = 0;
                j[l1][j2] = 0;
                l[l1][j2] = 0;
                D[l1][j2] = 0;
                h[l1][j2] = 0;
                n[l1][j2] = 0;
                if(k1 == 0)
                    n[l1][j2] = -6;
                if(k1 == 3)
                    n[l1][j2] = 8;
                m[l1][j2] = 0;
            }

            return;
        }
        abyte1 = new byte[20736];
        m.a(G[1] + s1 + G[3], abyte1, 20736);
        j3 = 0;
        j5 = 0;
        for(j7 = 0; j7 < 2304; j7++)
        {
            j3 = j3 + abyte1[j5++] & 0xff;
            i[l1][j7] = (byte)j3;
        }

        j3 = 0;
        for(j7 = 0; j7 < 2304; j7++)
        {
            j3 = j3 + abyte1[j5++] & 0xff;
            k[l1][j7] = (byte)j3;
        }

        for(j7 = 0; j7 < 2304; j7++)
            j[l1][j7] = abyte1[j5++];

        for(j7 = 0; j7 < 2304; j7++)
            l[l1][j7] = abyte1[j5++];

        for(j7 = 0; j7 < 2304; j7++)
        {
            D[l1][j7] = (abyte1[j5] & 0xff) * 256 + (abyte1[j5 + 1] & 0xff);
            j5 += 2;
        }

        for(j7 = 0; j7 < 2304; j7++)
            h[l1][j7] = abyte1[j5++];

        for(j7 = 0; j7 < 2304; j7++)
            n[l1][j7] = abyte1[j5++];

        for(j7 = 0; j7 < 2304; j7++)
            m[l1][j7] = abyte1[j5++];

    }

    public void a(u au[])
    {
        int i1 = f.J;
        for(int j1 = 0; j1 < 94; j1++)
        {
label0:
            for(int k1 = 0; k1 < 94; k1++)
            {
                if(j(j1, k1) <= 48000 || j(j1, k1) >= 60000)
                    continue;
                int l1 = j(j1, k1) - 48001;
                int i2 = a(j1, k1);
                int j2;
                int k2;
                if(i2 == 0 || i2 == 4)
                {
                    j2 = f.sb[l1];
                    k2 = f.tb[l1];
                } else
                {
                    k2 = f.sb[l1];
                    j2 = f.tb[l1];
                }
                a(j1, k1, l1);
                u u1 = au[f.rb[l1]].a(false, true, false, false);
                int l2 = ((j1 + j1 + j2) * 128) / 2;
                int i3 = ((k1 + k1 + k2) * 128) / 2;
                u1.f(l2, -g(l2, i3), i3);
                u1.e(0, a(j1, k1) * 32, 0);
                o.a(u1);
                u1.a(48, 48, -50, -10, -50);
                if(j2 <= 1 && k2 <= 1)
                    continue;
                int j3 = j1;
                do
                {
                    if(j3 >= j1 + j2)
                        continue label0;
                    for(int k3 = k1; k3 < k1 + k2; k3++)
                    {
                        if(j3 <= j1 && k3 <= k1 || j(j3, k3) - 48001 != l1)
                            continue;
                        int l3 = j3;
                        int i4 = k3;
                        byte byte0 = 0;
                        if(l3 >= 48 && i4 < 48)
                        {
                            byte0 = 1;
                            l3 -= 48;
                        } else
                        if(l3 < 48 && i4 >= 48)
                        {
                            byte0 = 2;
                            i4 -= 48;
                        } else
                        if(l3 >= 48 && i4 >= 48)
                        {
                            byte0 = 3;
                            l3 -= 48;
                            i4 -= 48;
                        }
                        D[byte0][l3 * 48 + i4] = 0;
                    }

                    j3++;
                } while(true);
            }

        }

    }

    public void h(int i1, int j1, int k1)
    {
        int l1 = i1 / 12;
        int i2 = j1 / 12;
        int j2 = (i1 - 1) / 12;
        int k2 = (j1 - 1) / 12;
        a(l1, i2, i1, j1, k1);
        if(l1 != j2)
            a(j2, i2, i1, j1, k1);
        if(i2 != k2)
            a(l1, k2, i1, j1, k1);
        if(l1 != j2 && i2 != k2)
            a(j2, k2, i1, j1, k1);
    }

    public void d(int i1, int j1, int k1, int l1)
    {
        int i2 = f.J;
        if(i1 < 0 || j1 < 0 || i1 >= 95 || j1 >= 95)
            return;
        if(f.zb[l1] == 1)
        {
            if(k1 == 0)
            {
                F[i1][j1] &= 0xfffe;
                if(j1 > 0)
                    c(i1, j1 - 1, 4);
            } else
            if(k1 == 1)
            {
                F[i1][j1] &= 0xfffd;
                if(i1 > 0)
                    c(i1 - 1, j1, 8);
            } else
            if(k1 == 2)
                F[i1][j1] &= 0xffef;
            else
            if(k1 == 3)
                F[i1][j1] &= 0xffdf;
            a(i1, j1, 1, 1);
        }
    }

    public void b()
    {
        int i1 = f.J;
        for(int j1 = 0; j1 < 96; j1++)
        {
            for(int k1 = 0; k1 < 96; k1++)
            {
                if(f(j1, k1, 0) != 250)
                    continue;
                if(j1 == 47 && f(j1 + 1, k1, 0) != 250 && f(j1 + 1, k1, 0) != 2)
                {
                    g(j1, k1, 9);
                    continue;
                }
                if(k1 == 47 && f(j1, k1 + 1, 0) != 250 && f(j1, k1 + 1, 0) != 2)
                    g(j1, k1, 9);
                else
                    g(j1, k1, 2);
            }

        }

    }

    public int i(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return j[byte0][i1 * 48 + j1] & 0xff;
    }

    public int j(int i1, int j1)
    {
        int k1 = f.J;
        if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
            return 0;
        byte byte0 = 0;
        if(i1 >= 48 && j1 < 48)
        {
            byte0 = 1;
            i1 -= 48;
        } else
        if(i1 < 48 && j1 >= 48)
        {
            byte0 = 2;
            j1 -= 48;
        } else
        if(i1 >= 48 && j1 >= 48)
        {
            byte0 = 3;
            i1 -= 48;
            j1 -= 48;
        }
        return D[byte0][i1 * 48 + j1];
    }

    public int e(int i1, int j1, int k1, int l1)
    {
        int i2 = f(i1, j1, k1);
        if(i2 == 0)
            return l1;
        else
            return f.gb[i2 - 1];
    }

    public void a(u u1, int i1, int j1, int k1, int l1, int i2)
    {
        h(j1, k1, 40);
        h(l1, i2, 40);
        int j2 = f.wb[i1];
        int k2 = f.xb[i1];
        int l2 = f.yb[i1];
        int i3 = j1 * 128;
        int j3 = k1 * 128;
        int k3 = l1 * 128;
        int l3 = i2 * 128;
        int i4 = u1.a(i3, -E[j1][k1], j3);
        int j4 = u1.a(i3, -E[j1][k1] - j2, j3);
        int k4 = u1.a(k3, -E[l1][i2] - j2, l3);
        int l4 = u1.a(k3, -E[l1][i2], l3);
        int ai[] = {
            i4, j4, k4, l4
        };
        int i5 = u1.a(4, ai, k2, l2);
        if(f.Ab[i1] == 5)
        {
            u1.pb[i5] = 30000 + i1;
            return;
        } else
        {
            u1.pb[i5] = 0;
            return;
        }
    }

    public int k(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= 96 || j1 >= 96)
            return 0;
        else
            return F[i1][j1];
    }

    public void i(int i1, int j1, int k1)
    {
        int l1 = f.J;
        if(i1 < 0 || j1 < 0 || i1 >= 95 || j1 >= 95)
            return;
        if(f.ub[k1] == 1 || f.ub[k1] == 2)
        {
            int i2 = a(i1, j1);
            int j2;
            int k2;
            if(i2 == 0 || i2 == 4)
            {
                j2 = f.sb[k1];
                k2 = f.tb[k1];
            } else
            {
                k2 = f.sb[k1];
                j2 = f.tb[k1];
            }
            for(int l2 = i1; l2 < i1 + j2; l2++)
            {
                for(int i3 = j1; i3 < j1 + k2; i3++)
                {
                    if(f.ub[k1] == 1)
                    {
                        F[l2][i3] &= 0xffbf;
                        continue;
                    }
                    if(i2 == 0)
                    {
                        F[l2][i3] &= 0xfffd;
                        if(l2 > 0)
                            c(l2 - 1, i3, 8);
                        continue;
                    }
                    if(i2 == 2)
                    {
                        F[l2][i3] &= 0xfffb;
                        if(i3 < 95)
                            c(l2, i3 + 1, 1);
                        continue;
                    }
                    if(i2 == 4)
                    {
                        F[l2][i3] &= 0xfff7;
                        if(l2 < 95)
                            c(l2 + 1, i3, 2);
                        continue;
                    }
                    if(i2 != 6)
                        continue;
                    F[l2][i3] &= 0xfffe;
                    if(i3 > 0)
                        c(l2, i3 - 1, 4);
                }

            }

            a(i1, j1, j2, k2);
        }
    }

    boolean a;
    boolean b;
    boolean c;
    byte d[];
    byte e[];
    byte f[];
    byte g[];
    byte h[][];
    byte i[][];
    byte j[][];
    byte k[][];
    byte l[][];
    byte m[][];
    byte n[][];
    g o;
    u p[];
    u q[][];
    u r[][];
    u s;
    v t;
    final int u = 96;
    final int v = 96;
    int w;
    final int x = 0xbc614e;
    final int y = 128;
    int z[];
    int A[];
    int B[];
    int C[][];
    int D[][];
    int E[][];
    int F[][];
    private static String G[];

    static 
    {
        String as[];
        as = new String[6];
        as[0] = "8\027\177\037";
        as[1] = "8]1\f3{\026z\n&w\\s\n\"e\\";
        as[2] = "8\033{\002";
        as[3] = "8\031s";
        as[4] = "8\037q\b";
        as[5] = "x\006r\007rd\034q\rs";
        G = as;
        break MISSING_BLOCK_LABEL_171;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 150;
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
            byte0 = 0x16;
            break;

        case 1: // '\001'
            byte0 = 115;
            break;

        case 2: // '\002'
            byte0 = 30;
            break;

        case 3: // '\003'
            byte0 = 107;
            break;

        default:
            byte0 = 82;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 150;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 74;
           goto _L5 _L1
_L5:
        JVM INSTR new #375 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
