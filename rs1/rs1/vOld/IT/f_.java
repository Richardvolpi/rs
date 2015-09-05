// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/3/2003 8:22:40 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 

import a.a.f;
import a.a.g;
import a.a.j;
import java.io.IOException;

public class f
{

    boolean a;
    boolean b;
    g c;
    j d;
    int e;
    final int f = 0xbc614e;
    final int g = 128;
    int h[];
    byte i[];
    byte j[];
    byte k[];
    byte l[];
    byte m[][];
    byte n[][];
    byte o[][];
    byte p[][];
    byte q[][];
    byte r[][];
    byte s[][];
    int t[][];
    int u;
    int v;
    int w[];
    int x[];
    int y[][];
    int z[][];
    int A[][];
    boolean B;
    f C[];
    f D[][];
    f E[][];
    f F;

    public f(j j1, g g1)
    {
        int i1;
        int j2;
        j2 = b.bN;
        super();
        a = false;
        b = true;
        e = 750;
        f = 0xbc614e;
        g = 128;
        h = new int[256];
        m = new byte[4][2304];
        n = new byte[4][2304];
        o = new byte[4][2304];
        p = new byte[4][2304];
        q = new byte[4][2304];
        r = new byte[4][2304];
        s = new byte[4][2304];
        t = new int[4][2304];
        u = 96;
        v = 96;
        w = new int[u * v * 2];
        x = new int[u * v * 2];
        y = new int[u][v];
        z = new int[u][v];
        A = new int[u][v];
        B = false;
        C = new f[64];
        D = new f[4][64];
        E = new f[4][64];
        d = j1;
        c = g1;
        i1 = 0;
        if(j2 == 0) goto _L2; else goto _L1
_L1:
        h[i1] = a.a.j.d(255 - i1 * 4, 255 - (int)((double)i1 * 1.75D), 255 - i1 * 4);
        i1++;
_L2:
        if(i1 < 64) goto _L1; else goto _L3
_L3:
        int k1 = 0;
        if(j2 == 0) goto _L5; else goto _L4
_L4:
        h[k1 + 64] = a.a.j.d(k1 * 3, 144, 0);
        k1++;
_L5:
        if(k1 < 64) goto _L4; else goto _L6
_L6:
        int l1 = 0;
        if(j2 == 0) goto _L8; else goto _L7
_L7:
        h[l1 + 128] = a.a.j.d(192 - (int)((double)l1 * 1.5D), 144 - (int)((double)l1 * 1.5D), 0);
        l1++;
_L8:
        if(l1 < 64) goto _L7; else goto _L9
_L9:
        int i2 = 0;
        if(j2 == 0) goto _L11; else goto _L10
_L10:
        h[i2 + 192] = a.a.j.d(96 - (int)((double)i2 * 1.5D), 48 + (int)((double)i2 * 1.5D), 0);
        i2++;
_L11:
        if(i2 >= 64)
            return;
        if(true) goto _L10; else goto _L12
_L12:
    }

    public int a(int i1, int j1, int k1, int l1, int i2, int j2, int ai[], //called from muclient.a(int,int,int,int,int,int,boolean,boolean)
            int ai1[], boolean flag)
    {
        int k2;
        int k4;
        k4 = b.bN;
        k2 = 0;
        if(k4 == 0) goto _L2; else goto _L1
_L1:
        int l2 = 0;
        if(k4 == 0) goto _L4; else goto _L3
_L3:
        y[k2][l2] = 0;
        l2++;
_L4:
        if(l2 < v) goto _L3; else goto _L5
_L5:
        k2++;
_L2:
        if(k2 < u) goto _L1; else goto _L6
_L6:
        int i3;
        int j3;
        int k3;
        int l3;
        boolean flag1;
        l2 = 0;
        i3 = 0;
        j3 = i1;
        k3 = j1;
        y[i1][j1] = 99;
        ai[l2] = i1;
        ai1[l2++] = j1;
        l3 = ai.length;
        flag1 = false;
        if(k4 == 0) goto _L8; else goto _L7
_L7:
        j3 = ai[i3];
        k3 = ai1[i3];
        i3 = (i3 + 1) % l3;
        if(j3 >= k1 && j3 <= i2 && k3 >= l1 && k3 <= j2)
        {
            flag1 = true;
            if(k4 == 0)
                break; /* Loop/switch isn't completed */
        }
        if(flag)
        {
            if(j3 > 0 && j3 - 1 >= k1 && j3 - 1 <= i2 && k3 >= l1 && k3 <= j2 && (z[j3 - 1][k3] & 8) == 0)
            {
                flag1 = true;
                if(k4 == 0)
                    break; /* Loop/switch isn't completed */
            }
            if(j3 < u - 1 && j3 + 1 >= k1 && j3 + 1 <= i2 && k3 >= l1 && k3 <= j2 && (z[j3 + 1][k3] & 2) == 0)
            {
                flag1 = true;
                if(k4 == 0)
                    break; /* Loop/switch isn't completed */
            }
            if(k3 > 0 && j3 >= k1 && j3 <= i2 && k3 - 1 >= l1 && k3 - 1 <= j2 && (z[j3][k3 - 1] & 4) == 0)
            {
                flag1 = true;
                if(k4 == 0)
                    break; /* Loop/switch isn't completed */
            }
            if(k3 < v - 1 && j3 >= k1 && j3 <= i2 && k3 + 1 >= l1 && k3 + 1 <= j2 && (z[j3][k3 + 1] & 1) == 0)
            {
                flag1 = true;
                if(k4 == 0)
                    break; /* Loop/switch isn't completed */
            }
        }
        if(j3 > 0 && y[j3 - 1][k3] == 0 && (z[j3 - 1][k3] & 0x78) == 0)
        {
            ai[l2] = j3 - 1;
            ai1[l2] = k3;
            l2 = (l2 + 1) % l3;
            y[j3 - 1][k3] = 2;
        }
        if(j3 < u - 1 && y[j3 + 1][k3] == 0 && (z[j3 + 1][k3] & 0x72) == 0)
        {
            ai[l2] = j3 + 1;
            ai1[l2] = k3;
            l2 = (l2 + 1) % l3;
            y[j3 + 1][k3] = 8;
        }
        if(k3 > 0 && y[j3][k3 - 1] == 0 && (z[j3][k3 - 1] & 0x74) == 0)
        {
            ai[l2] = j3;
            ai1[l2] = k3 - 1;
            l2 = (l2 + 1) % l3;
            y[j3][k3 - 1] = 1;
        }
        if(k3 < v - 1 && y[j3][k3 + 1] == 0 && (z[j3][k3 + 1] & 0x71) == 0)
        {
            ai[l2] = j3;
            ai1[l2] = k3 + 1;
            l2 = (l2 + 1) % l3;
            y[j3][k3 + 1] = 4;
        }
        if(j3 > 0 && k3 > 0 && (z[j3][k3 - 1] & 0x74) == 0 && (z[j3 - 1][k3] & 0x78) == 0 && (z[j3 - 1][k3 - 1] & 0x7c) == 0 && y[j3 - 1][k3 - 1] == 0)
        {
            ai[l2] = j3 - 1;
            ai1[l2] = k3 - 1;
            l2 = (l2 + 1) % l3;
            y[j3 - 1][k3 - 1] = 3;
        }
        if(j3 < u - 1 && k3 > 0 && (z[j3][k3 - 1] & 0x74) == 0 && (z[j3 + 1][k3] & 0x72) == 0 && (z[j3 + 1][k3 - 1] & 0x76) == 0 && y[j3 + 1][k3 - 1] == 0)
        {
            ai[l2] = j3 + 1;
            ai1[l2] = k3 - 1;
            l2 = (l2 + 1) % l3;
            y[j3 + 1][k3 - 1] = 9;
        }
        if(j3 > 0 && k3 < v - 1 && (z[j3][k3 + 1] & 0x71) == 0 && (z[j3 - 1][k3] & 0x78) == 0 && (z[j3 - 1][k3 + 1] & 0x79) == 0 && y[j3 - 1][k3 + 1] == 0)
        {
            ai[l2] = j3 - 1;
            ai1[l2] = k3 + 1;
            l2 = (l2 + 1) % l3;
            y[j3 - 1][k3 + 1] = 6;
        }
        if(j3 < u - 1 && k3 < v - 1 && (z[j3][k3 + 1] & 0x71) == 0 && (z[j3 + 1][k3] & 0x72) == 0 && (z[j3 + 1][k3 + 1] & 0x73) == 0 && y[j3 + 1][k3 + 1] == 0)
        {
            ai[l2] = j3 + 1;
            ai1[l2] = k3 + 1;
            l2 = (l2 + 1) % l3;
            y[j3 + 1][k3 + 1] = 12;
        }
_L8:
        if(i3 != l2) goto _L7; else goto _L9
_L9:
        int i4;
        int j4;
        if(!flag1)
            return -1;
        i3 = 0;
        ai[i3] = j3;
        ai1[i3++] = k3;
        i4 = j4 = y[j3][k3];
        if(k4 == 0) goto _L11; else goto _L10
_L10:
label0:
        {
            if(i4 != j4)
            {
                j4 = i4;
                ai[i3] = j3;
                ai1[i3++] = k3;
            }
            if((i4 & 2) != 0)
            {
                j3++;
                if(k4 == 0)
                    break label0;
            }
            if((i4 & 8) != 0)
                j3--;
        }
        if((i4 & 1) != 0)
        {
            k3++;
            if(k4 == 0)
                continue;
        }
        if((i4 & 4) != 0)
            k3--;
        i4 = y[j3][k3];
_L11:
        if(j3 == i1 && k3 == j1)
            return i3;
        if(true) goto _L10; else goto _L12
_L12:
    }

    public void a(int i1, int j1, int k1)
    {
        z[i1][j1] |= k1;
    }

    public void b(int i1, int j1, int k1)
    {
        z[i1][j1] &= 65535 - k1;
    }

    public void a(int i1, int j1, int k1, int l1)
    {
label0:
        {
label1:
            {
                int i2 = b.bN;
                if(i1 < 0 || j1 < 0 || i1 >= u - 1 || j1 >= v - 1)
                    return;
                if(b.bi[l1] != 1)
                    break label0;
                if(k1 == 0)
                {
                    z[i1][j1] |= 1;
                    if(j1 <= 0)
                        break label1;
                    a(i1, j1 - 1, 4);
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 1)
                {
                    z[i1][j1] |= 2;
                    if(i1 <= 0)
                        break label1;
                    a(i1 - 1, j1, 8);
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 2)
                {
                    z[i1][j1] |= 0x10;
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 3)
                    z[i1][j1] |= 0x20;
            }
            c(i1, j1, 1, 1);
        }
    }

    public void b(int i1, int j1, int k1, int l1)
    {
label0:
        {
label1:
            {
                int i2 = b.bN;
                if(i1 < 0 || j1 < 0 || i1 >= u - 1 || j1 >= v - 1)
                    return;
                if(b.bi[l1] != 1)
                    break label0;
                if(k1 == 0)
                {
                    z[i1][j1] &= 0xfffe;
                    if(j1 <= 0)
                        break label1;
                    b(i1, j1 - 1, 4);
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 1)
                {
                    z[i1][j1] &= 0xfffd;
                    if(i1 <= 0)
                        break label1;
                    b(i1 - 1, j1, 8);
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 2)
                {
                    z[i1][j1] &= 0xffef;
                    if(i2 == 0)
                        break label1;
                }
                if(k1 == 3)
                    z[i1][j1] &= 0xffdf;
            }
            c(i1, j1, 1, 1);
        }
    }

    public void c(int i1, int j1, int k1)
    {
        int l1;
        int i2;
        int j2;
        int k2;
        int i3;
label0:
        {
            i3 = b.bN;
            if(i1 < 0 || j1 < 0 || i1 >= u - 1 || j1 >= v - 1)
                return;
            if(b.Y[k1] != 1 && b.Y[k1] != 2)
                break MISSING_BLOCK_LABEL_356;
            l1 = g(i1, j1);
            if(l1 == 0 || l1 == 4)
            {
                i2 = b.W[k1];
                j2 = b.X[k1];
                if(i3 == 0)
                    break label0;
            }
            j2 = b.W[k1];
            i2 = b.X[k1];
        }
        k2 = i1;
        if(i3 == 0) goto _L2; else goto _L1
_L1:
        int l2 = j1;
        if(i3 == 0) goto _L4; else goto _L3
_L3:
        if(b.Y[k1] == 1)
        {
            z[k2][l2] |= 0x40;
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 0)
        {
            z[k2][l2] |= 2;
            if(k2 <= 0)
                continue; /* Loop/switch isn't completed */
            a(k2 - 1, l2, 8);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 2)
        {
            z[k2][l2] |= 4;
            if(l2 >= v - 1)
                continue; /* Loop/switch isn't completed */
            a(k2, l2 + 1, 1);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 4)
        {
            z[k2][l2] |= 8;
            if(k2 >= u - 1)
                continue; /* Loop/switch isn't completed */
            a(k2 + 1, l2, 2);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 6)
        {
            z[k2][l2] |= 1;
            if(l2 > 0)
                a(k2, l2 - 1, 4);
        }
        l2++;
_L4:
        if(l2 < j1 + j2) goto _L3; else goto _L5
_L5:
        k2++;
_L2:
        if(k2 < i1 + i2) goto _L1; else goto _L6
_L6:
        c(i1, j1, i2, j2);
    }

    public void d(int i1, int j1, int k1)
    {
        int l1;
        int i2;
        int j2;
        int k2;
        int i3;
label0:
        {
            i3 = b.bN;
            if(i1 < 0 || j1 < 0 || i1 >= u - 1 || j1 >= v - 1)
                return;
            if(b.Y[k1] != 1 && b.Y[k1] != 2)
                break MISSING_BLOCK_LABEL_359;
            l1 = g(i1, j1);
            if(l1 == 0 || l1 == 4)
            {
                i2 = b.W[k1];
                j2 = b.X[k1];
                if(i3 == 0)
                    break label0;
            }
            j2 = b.W[k1];
            i2 = b.X[k1];
        }
        k2 = i1;
        if(i3 == 0) goto _L2; else goto _L1
_L1:
        int l2 = j1;
        if(i3 == 0) goto _L4; else goto _L3
_L3:
        if(b.Y[k1] == 1)
        {
            z[k2][l2] &= 0xffbf;
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 0)
        {
            z[k2][l2] &= 0xfffd;
            if(k2 <= 0)
                continue; /* Loop/switch isn't completed */
            b(k2 - 1, l2, 8);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 2)
        {
            z[k2][l2] &= 0xfffb;
            if(l2 >= v - 1)
                continue; /* Loop/switch isn't completed */
            b(k2, l2 + 1, 1);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 4)
        {
            z[k2][l2] &= 0xfff7;
            if(k2 >= u - 1)
                continue; /* Loop/switch isn't completed */
            b(k2 + 1, l2, 2);
            if(i3 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l1 == 6)
        {
            z[k2][l2] &= 0xfffe;
            if(l2 > 0)
                b(k2, l2 - 1, 4);
        }
        l2++;
_L4:
        if(l2 < j1 + j2) goto _L3; else goto _L5
_L5:
        k2++;
_L2:
        if(k2 < i1 + i2) goto _L1; else goto _L6
_L6:
        c(i1, j1, i2, j2);
    }

    public void c(int i1, int j1, int k1, int l1)
    {
        int i2;
        int k2;
        k2 = b.bN;
        if(i1 < 1 || j1 < 1 || i1 + k1 >= u || j1 + l1 >= v)
            return;
        i2 = i1;
        if(k2 == 0) goto _L2; else goto _L1
_L1:
        int j2 = j1;
        if(k2 == 0) goto _L4; else goto _L3
_L3:
        if((a(i2, j2) & 0x63) != 0 || (a(i2 - 1, j2) & 0x59) != 0 || (a(i2, j2 - 1) & 0x56) != 0 || (a(i2 - 1, j2 - 1) & 0x6c) != 0)
        {
            e(i2, j2, 35);
            if(k2 == 0)
                continue; /* Loop/switch isn't completed */
        }
        e(i2, j2, 0);
        j2++;
_L4:
        if(j2 <= j1 + l1) goto _L3; else goto _L5
_L5:
        i2++;
_L2:
        if(i2 > i1 + k1)
            return;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void e(int i1, int j1, int k1)
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

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        f f1;
        int j2;
        f1 = C[i1 + j1 * 8];
        j2 = 0;
        if(b.bN == 0) goto _L2; else goto _L1
_L1:
        if(f1.U[j2] == k1 * 128 && f1.W[j2] == l1 * 128)
        {
            f1.c(j2, i2);
            return;
        }
        j2++;
_L2:
        if(j2 >= f1.a)
            return;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int a(int i1, int j1)
    {
        if(i1 < 0 || j1 < 0 || i1 >= u || j1 >= v)
            return 0;
        else
            return z[i1][j1];
    }

    public int b(int i1, int j1)
    {
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
label0:
        {
            int k1 = i1 >> 7;
            int l1 = j1 >> 7;
            i2 = i1 & 0x7f;
            j2 = j1 & 0x7f;
            if(k1 < 0 || l1 < 0 || k1 >= u - 1 || l1 >= v - 1)
                return 0;
            if(i2 <= 128 - j2)
            {
                k2 = c(k1, l1);
                l2 = c(k1 + 1, l1) - k2;
                i3 = c(k1, l1 + 1) - k2;
                if(b.bN == 0)
                    break label0;
            }
            k2 = c(k1 + 1, l1 + 1);
            l2 = c(k1, l1 + 1) - k2;
            i3 = c(k1 + 1, l1) - k2;
            i2 = 128 - i2;
            j2 = 128 - j2;
        }
        int j3 = k2 + (l2 * i2) / 128 + (i3 * j2) / 128;
        return j3;
    }

    public int c(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return (m[byte0][i1 * 48 + j1] & 0xff) * 3;
    }

    public int d(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return n[byte0][i1 * 48 + j1] & 0xff;
    }

    public int f(int i1, int j1, int k1)
    {
        byte byte0;
label0:
        {
            int l1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(l1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(l1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return r[byte0][i1 * 48 + j1] & 0xff;
    }

    public void g(int i1, int j1, int k1)
    {
        byte byte0;
label0:
        {
            int l1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(l1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(l1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        r[byte0][i1 * 48 + j1] = (byte)k1;
    }

    public int h(int i1, int j1, int k1)
    {
        int l1 = f(i1, j1, k1);
        if(l1 == 0)
            return -1;
        int i2 = b.bp[l1 - 1];
        return i2 != 2 ? 0 : 1;
    }

    public int d(int i1, int j1, int k1, int l1)
    {
        int i2 = f(i1, j1, k1);
        if(i2 == 0)
            return l1;
        else
            return b.bo[i2 - 1];
    }

    public int e(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return t[byte0][i1 * 48 + j1];
    }

    public int f(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return q[byte0][i1 * 48 + j1];
    }

    public int g(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return s[byte0][i1 * 48 + j1];
    }

    public boolean h(int i1, int j1)
    {
        return f(i1, j1) > 0 || f(i1 - 1, j1) > 0 || f(i1 - 1, j1 - 1) > 0 || f(i1, j1 - 1) > 0;
    }

    public boolean i(int i1, int j1)
    {
        return f(i1, j1) > 0 && f(i1 - 1, j1) > 0 && f(i1 - 1, j1 - 1) > 0 && f(i1, j1 - 1) > 0;
    }

    public int j(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return p[byte0][i1 * 48 + j1] & 0xff;
    }

    public int k(int i1, int j1)
    {
        byte byte0;
label0:
        {
            int k1 = b.bN;
            if(i1 < 0 || i1 >= 96 || j1 < 0 || j1 >= 96)
                return 0;
            byte0 = 0;
            if(i1 >= 48 && j1 < 48)
            {
                byte0 = 1;
                i1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 < 48 && j1 >= 48)
            {
                byte0 = 2;
                j1 -= 48;
                if(k1 == 0)
                    break label0;
            }
            if(i1 >= 48 && j1 >= 48)
            {
                byte0 = 3;
                i1 -= 48;
                j1 -= 48;
            }
        }
        return o[byte0][i1 * 48 + j1] & 0xff;
    }

    public void e(int i1, int j1, int k1, int l1)
    {
        String s1;
        int j5;
        j5 = b.bN;
        s1 = "m" + k1 + i1 / 10 + i1 % 10 + j1 / 10 + j1 % 10;
        if(i == null) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        abyte0 = a.f.a(s1 + ".hei", 0, i);
        if(abyte0 == null && k != null)
            abyte0 = a.f.a(s1 + ".hei", 0, k);
        if(abyte0 == null || abyte0.length <= 0) goto _L4; else goto _L3
_L3:
        int j2;
        int k2;
        int l2;
        j2 = 0;
        k2 = 0;
        l2 = 0;
        if(j5 == 0) goto _L6; else goto _L5
_L5:
        int i3;
        int j3;
        i3 = abyte0[j2++] & 0xff;
        if(i3 < 128)
        {
            m[l1][l2++] = (byte)i3;
            k2 = i3;
        }
        if(i3 < 128)
            continue; /* Loop/switch isn't completed */
        j3 = 0;
        if(j5 == 0) goto _L8; else goto _L7
_L7:
        m[l1][l2++] = (byte)k2;
        j3++;
_L8:
        if(j3 < i3 - 128) goto _L7; else goto _L6
_L6:
        if(l2 < 2304) goto _L5; else goto _L9
_L9:
        k2 = 64;
        i3 = 0;
        if(j5 == 0) goto _L11; else goto _L10
_L10:
        j3 = 0;
        if(j5 == 0) goto _L13; else goto _L12
_L12:
        k2 = m[l1][j3 * 48 + i3] + k2 & 0x7f;
        m[l1][j3 * 48 + i3] = (byte)(k2 * 2);
        j3++;
_L13:
        if(j3 < 48) goto _L12; else goto _L14
_L14:
        i3++;
_L11:
        if(i3 < 48) goto _L10; else goto _L15
_L15:
        k2 = 0;
        j3 = 0;
        if(j5 == 0) goto _L17; else goto _L16
_L16:
        int k3;
        int l3;
        k3 = abyte0[j2++] & 0xff;
        if(k3 < 128)
        {
            n[l1][j3++] = (byte)k3;
            k2 = k3;
        }
        if(k3 < 128)
            continue; /* Loop/switch isn't completed */
        l3 = 0;
        if(j5 == 0) goto _L19; else goto _L18
_L18:
        n[l1][j3++] = (byte)k2;
        l3++;
_L19:
        if(l3 < k3 - 128) goto _L18; else goto _L17
_L17:
        if(j3 < 2304) goto _L16; else goto _L20
_L20:
        k2 = 35;
        k3 = 0;
        if(j5 == 0) goto _L22; else goto _L21
_L21:
        l3 = 0;
        if(j5 == 0) goto _L24; else goto _L23
_L23:
        k2 = n[l1][l3 * 48 + k3] + k2 & 0x7f;
        n[l1][l3 * 48 + k3] = (byte)(k2 * 2);
        l3++;
_L24:
        if(l3 < 48) goto _L23; else goto _L25
_L25:
        k3++;
_L22:
        if(k3 < 48) goto _L21; else goto _L26
_L26:
        if(j5 == 0) goto _L27; else goto _L4
_L4:
        j2 = 0;
        if(j5 == 0) goto _L29; else goto _L28
_L28:
        m[l1][j2] = 0;
        n[l1][j2] = 0;
        j2++;
_L29:
        if(j2 < 2304) goto _L28; else goto _L27
_L27:
        abyte0 = a.f.a(s1 + ".dat", 0, j);
        if(abyte0 == null && l != null)
            abyte0 = a.f.a(s1 + ".dat", 0, l);
        if(abyte0 == null || abyte0.length == 0)
            throw new IOException();
        j2 = 0;
        k2 = 0;
        if(j5 == 0) goto _L31; else goto _L30
_L30:
        o[l1][k2] = abyte0[j2++];
        k2++;
_L31:
        if(k2 < 2304) goto _L30; else goto _L32
_L32:
        l2 = 0;
        if(j5 == 0) goto _L34; else goto _L33
_L33:
        p[l1][l2] = abyte0[j2++];
        l2++;
_L34:
        if(l2 < 2304) goto _L33; else goto _L35
_L35:
        i3 = 0;
        if(j5 == 0) goto _L37; else goto _L36
_L36:
        t[l1][i3] = abyte0[j2++] & 0xff;
        i3++;
_L37:
        if(i3 < 2304) goto _L36; else goto _L38
_L38:
        j3 = 0;
        if(j5 == 0) goto _L40; else goto _L39
_L39:
        k3 = abyte0[j2++] & 0xff;
        if(k3 > 0)
            t[l1][j3] = k3 + 12000;
        j3++;
_L40:
        if(j3 < 2304) goto _L39; else goto _L41
_L41:
        k3 = 0;
        if(j5 == 0) goto _L43; else goto _L42
_L42:
        int i4;
        l3 = abyte0[j2++] & 0xff;
        if(l3 < 128)
        {
            q[l1][k3++] = (byte)l3;
            if(j5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        i4 = 0;
        if(j5 == 0) goto _L45; else goto _L44
_L44:
        q[l1][k3++] = 0;
        i4++;
_L45:
        if(i4 < l3 - 128) goto _L44; else goto _L43
_L43:
        if(k3 < 2304) goto _L42; else goto _L46
_L46:
        l3 = 0;
        i4 = 0;
        if(j5 == 0) goto _L48; else goto _L47
_L47:
        int j4;
        int k4;
        j4 = abyte0[j2++] & 0xff;
        if(j4 < 128)
        {
            r[l1][i4++] = (byte)j4;
            l3 = j4;
            if(j5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        k4 = 0;
        if(j5 == 0) goto _L50; else goto _L49
_L49:
        r[l1][i4++] = (byte)l3;
        k4++;
_L50:
        if(k4 < j4 - 128) goto _L49; else goto _L48
_L48:
        if(i4 < 2304) goto _L47; else goto _L51
_L51:
        j4 = 0;
        if(j5 == 0) goto _L53; else goto _L52
_L52:
        int l4;
        k4 = abyte0[j2++] & 0xff;
        if(k4 < 128)
        {
            s[l1][j4++] = (byte)k4;
            if(j5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        l4 = 0;
        if(j5 == 0) goto _L55; else goto _L54
_L54:
        s[l1][j4++] = 0;
        l4++;
_L55:
        if(l4 < k4 - 128) goto _L54; else goto _L53
_L53:
        if(j4 < 2304) goto _L52; else goto _L56
_L56:
        abyte0 = a.f.a(s1 + ".loc", 0, j);
        if(abyte0 == null || abyte0.length <= 0) goto _L58; else goto _L57
_L57:
        j2 = 0;
        k4 = 0;
        if(j5 == 0) goto _L60; else goto _L59
_L59:
        int i5 = abyte0[j2++] & 0xff;
        if(i5 < 128)
        {
            t[l1][k4++] = i5 + 48000;
            if(j5 == 0)
                continue; /* Loop/switch isn't completed */
        }
        k4 += i5 - 128;
_L60:
        if(k4 < 2304) goto _L59; else goto _L61
_L61:
        return;
_L2:
        abyte0 = new byte[20736];
        a.f.a("../gamedata/maps/" + s1 + ".jm", abyte0, 20736);
        j2 = 0;
        k2 = 0;
        l2 = 0;
        if(j5 == 0) goto _L63; else goto _L62
_L62:
        j2 = j2 + abyte0[k2++] & 0xff;
        m[l1][l2] = (byte)j2;
        l2++;
_L63:
        if(l2 < 2304) goto _L62; else goto _L64
_L64:
        j2 = 0;
        i3 = 0;
        if(j5 == 0) goto _L66; else goto _L65
_L65:
        j2 = j2 + abyte0[k2++] & 0xff;
        n[l1][i3] = (byte)j2;
        i3++;
_L66:
        if(i3 < 2304) goto _L65; else goto _L67
_L67:
        j3 = 0;
        if(j5 == 0) goto _L69; else goto _L68
_L68:
        o[l1][j3] = abyte0[k2++];
        j3++;
_L69:
        if(j3 < 2304) goto _L68; else goto _L70
_L70:
        k3 = 0;
        if(j5 == 0) goto _L72; else goto _L71
_L71:
        p[l1][k3] = abyte0[k2++];
        k3++;
_L72:
        if(k3 < 2304) goto _L71; else goto _L73
_L73:
        l3 = 0;
        if(j5 == 0) goto _L75; else goto _L74
_L74:
        t[l1][l3] = (abyte0[k2] & 0xff) * 256 + (abyte0[k2 + 1] & 0xff);
        k2 += 2;
        l3++;
_L75:
        if(l3 < 2304) goto _L74; else goto _L76
_L76:
        i4 = 0;
        if(j5 == 0) goto _L78; else goto _L77
_L77:
        q[l1][i4] = abyte0[k2++];
        i4++;
_L78:
        if(i4 < 2304) goto _L77; else goto _L79
_L79:
        j4 = 0;
        if(j5 == 0) goto _L81; else goto _L80
_L80:
        r[l1][j4] = abyte0[k2++];
        j4++;
_L81:
        if(j4 < 2304) goto _L80; else goto _L82
_L82:
        k4 = 0;
        if(j5 == 0) goto _L84; else goto _L83
_L83:
        s[l1][k4] = abyte0[k2++];
        k4++;
_L84:
        if(k4 < 2304) goto _L83; else goto _L58
_L58:
        return;
        JVM INSTR pop ;
        int i2 = 0;
        if(j5 == 0) goto _L86; else goto _L85
_L85:
        m[l1][i2] = 0;
        n[l1][i2] = 0;
        o[l1][i2] = 0;
        p[l1][i2] = 0;
        t[l1][i2] = 0;
        q[l1][i2] = 0;
        r[l1][i2] = 0;
        if(k1 == 0)
            r[l1][i2] = -6;
        if(k1 == 3)
            r[l1][i2] = 8;
        s[l1][i2] = 0;
        i2++;
_L86:
        if(i2 >= 2304)
            return;
        if(true) goto _L85; else goto _L87
_L87:
    }

    public void a()
    {
        int i1;
        int l1;
        l1 = b.bN;
        if(b)
            d.a();
        i1 = 0;
        if(l1 == 0) goto _L2; else goto _L1
_L1:
        int j1;
        C[i1] = null;
        j1 = 0;
        if(l1 == 0) goto _L4; else goto _L3
_L3:
        D[j1][i1] = null;
        j1++;
_L4:
        if(j1 < 4) goto _L3; else goto _L5
_L5:
        int k1 = 0;
        if(l1 == 0) goto _L7; else goto _L6
_L6:
        E[k1][i1] = null;
        k1++;
_L7:
        if(k1 < 4) goto _L6; else goto _L8
_L8:
        i1++;
_L2:
        if(i1 >= 64)
        {
            System.gc();
            return;
        }
        if(true) goto _L1; else goto _L9
_L9:
    }

    public void i(int i1, int j1, int k1)
    {
        a();
        int l1 = (i1 + 24) / 48;
        int i2 = (j1 + 24) / 48;
        a(i1, j1, k1, true);
        if(k1 == 0)
        {
            a(i1, j1, 1, false);
            a(i1, j1, 2, false);
            e(l1 - 1, i2 - 1, k1, 0);
            e(l1, i2 - 1, k1, 1);
            e(l1 - 1, i2, k1, 2);
            e(l1, i2, k1, 3);
            b();
        }
    }

    public void b()
    {
        int i1;
        int k1;
        k1 = b.bN;
        i1 = 0;
        if(k1 == 0) goto _L2; else goto _L1
_L1:
        int j1 = 0;
        if(k1 == 0) goto _L4; else goto _L3
_L3:
        if(f(i1, j1, 0) != 250)
            continue; /* Loop/switch isn't completed */
        if(i1 == 47 && f(i1 + 1, j1, 0) != 250 && f(i1 + 1, j1, 0) != 2)
        {
            g(i1, j1, 9);
            if(k1 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(j1 == 47 && f(i1, j1 + 1, 0) != 250 && f(i1, j1 + 1, 0) != 2)
        {
            g(i1, j1, 9);
            if(k1 == 0)
                continue; /* Loop/switch isn't completed */
        }
        g(i1, j1, 2);
        j1++;
_L4:
        if(j1 < 96) goto _L3; else goto _L5
_L5:
        i1++;
_L2:
        if(i1 >= 96)
            return;
        if(true) goto _L1; else goto _L6
_L6:
    }

    public void b(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = i1 * 3;
        int k2 = j1 * 3;
        int l2 = d.h(l1);
        int i3 = d.h(i2);
        l2 = l2 >> 1 & 0x7f7f7f;
        i3 = i3 >> 1 & 0x7f7f7f;
        if(k1 == 0)
        {
            c.b(j2, k2, 3, l2);
            c.b(j2, k2 + 1, 2, l2);
            c.b(j2, k2 + 2, 1, l2);
            c.b(j2 + 2, k2 + 1, 1, i3);
            c.b(j2 + 1, k2 + 2, 2, i3);
            return;
        }
        if(k1 == 1)
        {
            c.b(j2, k2, 3, i3);
            c.b(j2 + 1, k2 + 1, 2, i3);
            c.b(j2 + 2, k2 + 2, 1, i3);
            c.b(j2, k2 + 1, 1, l2);
            c.b(j2, k2 + 2, 2, l2);
        }
    }

    public void a(int i1, int j1, int k1, boolean flag)
    {
        int j24;
        j24 = b.bN;
        int l1 = (i1 + 24) / 48;
        int i2 = (j1 + 24) / 48;
        e(l1 - 1, i2 - 1, k1, 0);
        e(l1, i2 - 1, k1, 1);
        e(l1 - 1, i2, k1, 2);
        e(l1, i2, k1, 3);
        b();
        if(F == null)
            F = new f(u * v * 2 + 256, u * v * 2 + 256, true, true, false, false, true);
        if(!flag) goto _L2; else goto _L1
_L1:
        int j2;
        c.c();
        j2 = 0;
        if(j24 == 0) goto _L4; else goto _L3
_L3:
        int k2 = 0;
        if(j24 == 0) goto _L6; else goto _L5
_L5:
        z[j2][k2] = 0;
        k2++;
_L6:
        if(k2 < 96) goto _L5; else goto _L7
_L7:
        j2++;
_L4:
        if(j2 < 96) goto _L3; else goto _L8
_L8:
        f f1;
        int l2;
        f1 = F;
        f1.b();
        l2 = 0;
        if(j24 == 0) goto _L10; else goto _L9
_L9:
        int i3 = 0;
        if(j24 == 0) goto _L12; else goto _L11
_L11:
        int j3 = -c(l2, i3);
        if(f(l2, i3, k1) > 0 && b.bp[f(l2, i3, k1) - 1] == 4)
            j3 = 0;
        if(f(l2 - 1, i3, k1) > 0 && b.bp[f(l2 - 1, i3, k1) - 1] == 4)
            j3 = 0;
        if(f(l2, i3 - 1, k1) > 0 && b.bp[f(l2, i3 - 1, k1) - 1] == 4)
            j3 = 0;
        if(f(l2 - 1, i3 - 1, k1) > 0 && b.bp[f(l2 - 1, i3 - 1, k1) - 1] == 4)
            j3 = 0;
        int l3 = f1.a(l2 * 128, j3, i3 * 128);
        int k4 = (int)(Math.random() * 10D) - 5;
        f1.c(l3, k4);
        i3++;
_L12:
        if(i3 < 96) goto _L11; else goto _L13
_L13:
        l2++;
_L10:
        if(l2 < 96) goto _L9; else goto _L14
_L14:
        i3 = 0;
        if(j24 == 0) goto _L16; else goto _L15
_L15:
        int k3 = 0;
        if(j24 == 0) goto _L18; else goto _L17
_L17:
        int l4;
        int k6;
        int k10;
label0:
        {
            int k12;
label1:
            {
                int i4 = d(i3, k3);
                l4 = h[i4];
                k6 = l4;
                int j8 = l4;
                k10 = 0;
                if(k1 == 1 || k1 == 2)
                {
                    l4 = 0xbc614e;
                    k6 = 0xbc614e;
                    j8 = 0xbc614e;
                }
                if(f(i3, k3, k1) <= 0)
                    break label0;
                k12 = f(i3, k3, k1);
                i4 = b.bp[k12 - 1];
                int l14 = h(i3, k3, k1);
                l4 = k6 = b.bo[k12 - 1];
                if(i4 == 4)
                {
                    l4 = 1;
                    k6 = 1;
                    if(k12 == 12)
                    {
                        l4 = 31;
                        k6 = 31;
                    }
                }
                if(i4 == 5)
                {
                    if(e(i3, k3) <= 0 || e(i3, k3) >= 24000)
                        break label1;
                    if(d(i3 - 1, k3, k1, j8) != 0xbc614e && d(i3, k3 - 1, k1, j8) != 0xbc614e)
                    {
                        l4 = d(i3 - 1, k3, k1, j8);
                        k10 = 0;
                        if(j24 == 0)
                            break label1;
                    }
                    if(d(i3 + 1, k3, k1, j8) != 0xbc614e && d(i3, k3 + 1, k1, j8) != 0xbc614e)
                    {
                        k6 = d(i3 + 1, k3, k1, j8);
                        k10 = 0;
                        if(j24 == 0)
                            break label1;
                    }
                    if(d(i3 + 1, k3, k1, j8) != 0xbc614e && d(i3, k3 - 1, k1, j8) != 0xbc614e)
                    {
                        k6 = d(i3 + 1, k3, k1, j8);
                        k10 = 1;
                        if(j24 == 0)
                            break label1;
                    }
                    if(d(i3 - 1, k3, k1, j8) == 0xbc614e || d(i3, k3 + 1, k1, j8) == 0xbc614e)
                        break label1;
                    l4 = d(i3 - 1, k3, k1, j8);
                    k10 = 1;
                    if(j24 == 0)
                        break label1;
                }
                if(i4 == 2 && (e(i3, k3) <= 0 || e(i3, k3) >= 24000))
                    break label1;
                if(h(i3 - 1, k3, k1) != l14 && h(i3, k3 - 1, k1) != l14)
                {
                    l4 = j8;
                    k10 = 0;
                    if(j24 == 0)
                        break label1;
                }
                if(h(i3 + 1, k3, k1) != l14 && h(i3, k3 + 1, k1) != l14)
                {
                    k6 = j8;
                    k10 = 0;
                    if(j24 == 0)
                        break label1;
                }
                if(h(i3 + 1, k3, k1) != l14 && h(i3, k3 - 1, k1) != l14)
                {
                    k6 = j8;
                    k10 = 1;
                    if(j24 == 0)
                        break label1;
                }
                if(h(i3 - 1, k3, k1) != l14 && h(i3, k3 + 1, k1) != l14)
                {
                    l4 = j8;
                    k10 = 1;
                }
            }
            if(b.bq[k12 - 1] != 0)
                z[i3][k3] |= 0x40;
            if(b.bp[k12 - 1] == 2)
                z[i3][k3] |= 0x80;
        }
        b(i3, k3, k10, l4, k6);
        int l12 = ((c(i3 + 1, k3 + 1) - c(i3 + 1, k3)) + c(i3, k3 + 1)) - c(i3, k3);
        if(l4 != k6 || l12 != 0)
        {
            int ai[] = new int[3];
            int ai7[] = new int[3];
            if(k10 == 0)
            {
                if(l4 != 0xbc614e)
                {
                    ai[0] = k3 + i3 * u + u;
                    ai[1] = k3 + i3 * u;
                    ai[2] = k3 + i3 * u + 1;
                    int k17 = f1.a(3, ai, 0xbc614e, l4);
                    w[k17] = i3;
                    x[k17] = k3;
                    f1.G[k17] = 0x30d40 + k17;
                }
                if(k6 == 0xbc614e)
                    continue; /* Loop/switch isn't completed */
                ai7[0] = k3 + i3 * u + 1;
                ai7[1] = k3 + i3 * u + u + 1;
                ai7[2] = k3 + i3 * u + u;
                int l17 = f1.a(3, ai7, 0xbc614e, k6);
                w[l17] = i3;
                x[l17] = k3;
                f1.G[l17] = 0x30d40 + l17;
                if(j24 == 0)
                    continue; /* Loop/switch isn't completed */
            }
            if(l4 != 0xbc614e)
            {
                ai[0] = k3 + i3 * u + 1;
                ai[1] = k3 + i3 * u + u + 1;
                ai[2] = k3 + i3 * u;
                int i18 = f1.a(3, ai, 0xbc614e, l4);
                w[i18] = i3;
                x[i18] = k3;
                f1.G[i18] = 0x30d40 + i18;
            }
            if(k6 == 0xbc614e)
                continue; /* Loop/switch isn't completed */
            ai7[0] = k3 + i3 * u + u;
            ai7[1] = k3 + i3 * u;
            ai7[2] = k3 + i3 * u + u + 1;
            int j18 = f1.a(3, ai7, 0xbc614e, k6);
            w[j18] = i3;
            x[j18] = k3;
            f1.G[j18] = 0x30d40 + j18;
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(l4 != 0xbc614e)
        {
            int ai1[] = new int[4];
            ai1[0] = k3 + i3 * u + u;
            ai1[1] = k3 + i3 * u;
            ai1[2] = k3 + i3 * u + 1;
            ai1[3] = k3 + i3 * u + u + 1;
            int k15 = f1.a(4, ai1, 0xbc614e, l4);
            w[k15] = i3;
            x[k15] = k3;
            f1.G[k15] = 0x30d40 + k15;
        }
        k3++;
_L18:
        if(k3 < 95) goto _L17; else goto _L19
_L19:
        i3++;
_L16:
        if(i3 < 95) goto _L15; else goto _L20
_L20:
        k3 = 1;
        if(j24 == 0) goto _L22; else goto _L21
_L21:
        int j4 = 1;
        if(j24 == 0) goto _L24; else goto _L23
_L23:
        if(f(k3, j4, k1) > 0 && b.bp[f(k3, j4, k1) - 1] == 4)
        {
            int i5 = b.bo[f(k3, j4, k1) - 1];
            int l6 = f1.a(k3 * 128, -c(k3, j4), j4 * 128);
            int k8 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4), j4 * 128);
            int l10 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4 + 1), (j4 + 1) * 128);
            int i13 = f1.a(k3 * 128, -c(k3, j4 + 1), (j4 + 1) * 128);
            int ai2[] = {
                l6, k8, l10, i13
            };
            int l15 = f1.a(4, ai2, i5, 0xbc614e);
            w[l15] = k3;
            x[l15] = j4;
            f1.G[l15] = 0x30d40 + l15;
            b(k3, j4, 0, i5, i5);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(f(k3, j4, k1) == 0 || b.bp[f(k3, j4, k1) - 1] != 3)
        {
            if(f(k3, j4 + 1, k1) > 0 && b.bp[f(k3, j4 + 1, k1) - 1] == 4)
            {
                int j5 = b.bo[f(k3, j4 + 1, k1) - 1];
                int i7 = f1.a(k3 * 128, -c(k3, j4), j4 * 128);
                int l8 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4), j4 * 128);
                int i11 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4 + 1), (j4 + 1) * 128);
                int j13 = f1.a(k3 * 128, -c(k3, j4 + 1), (j4 + 1) * 128);
                int ai3[] = {
                    i7, l8, i11, j13
                };
                int i16 = f1.a(4, ai3, j5, 0xbc614e);
                w[i16] = k3;
                x[i16] = j4;
                f1.G[i16] = 0x30d40 + i16;
                b(k3, j4, 0, j5, j5);
            }
            if(f(k3, j4 - 1, k1) > 0 && b.bp[f(k3, j4 - 1, k1) - 1] == 4)
            {
                int k5 = b.bo[f(k3, j4 - 1, k1) - 1];
                int j7 = f1.a(k3 * 128, -c(k3, j4), j4 * 128);
                int i9 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4), j4 * 128);
                int j11 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4 + 1), (j4 + 1) * 128);
                int k13 = f1.a(k3 * 128, -c(k3, j4 + 1), (j4 + 1) * 128);
                int ai4[] = {
                    j7, i9, j11, k13
                };
                int j16 = f1.a(4, ai4, k5, 0xbc614e);
                w[j16] = k3;
                x[j16] = j4;
                f1.G[j16] = 0x30d40 + j16;
                b(k3, j4, 0, k5, k5);
            }
            if(f(k3 + 1, j4, k1) > 0 && b.bp[f(k3 + 1, j4, k1) - 1] == 4)
            {
                int l5 = b.bo[f(k3 + 1, j4, k1) - 1];
                int k7 = f1.a(k3 * 128, -c(k3, j4), j4 * 128);
                int j9 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4), j4 * 128);
                int k11 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4 + 1), (j4 + 1) * 128);
                int l13 = f1.a(k3 * 128, -c(k3, j4 + 1), (j4 + 1) * 128);
                int ai5[] = {
                    k7, j9, k11, l13
                };
                int k16 = f1.a(4, ai5, l5, 0xbc614e);
                w[k16] = k3;
                x[k16] = j4;
                f1.G[k16] = 0x30d40 + k16;
                b(k3, j4, 0, l5, l5);
            }
            if(f(k3 - 1, j4, k1) > 0 && b.bp[f(k3 - 1, j4, k1) - 1] == 4)
            {
                int i6 = b.bo[f(k3 - 1, j4, k1) - 1];
                int l7 = f1.a(k3 * 128, -c(k3, j4), j4 * 128);
                int k9 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4), j4 * 128);
                int l11 = f1.a((k3 + 1) * 128, -c(k3 + 1, j4 + 1), (j4 + 1) * 128);
                int i14 = f1.a(k3 * 128, -c(k3, j4 + 1), (j4 + 1) * 128);
                int ai6[] = {
                    l7, k9, l11, i14
                };
                int l16 = f1.a(4, ai6, i6, 0xbc614e);
                w[l16] = k3;
                x[l16] = j4;
                f1.G[l16] = 0x30d40 + l16;
                b(k3, j4, 0, i6, i6);
            }
        }
        j4++;
_L24:
        if(j4 < 95) goto _L23; else goto _L25
_L25:
        k3++;
_L22:
        if(k3 < 95) goto _L21; else goto _L26
_L26:
        f1.a(true, 40, 48, -50, -10, -50);
        C = F.a(0, 0, 1536, 1536, 8, 64, 233, false);
        j4 = 0;
        if(j24 == 0) goto _L28; else goto _L27
_L27:
        d.a(C[j4]);
        j4++;
_L28:
        if(j4 < 64) goto _L27; else goto _L29
_L29:
        int j6 = 0;
        if(j24 == 0) goto _L31; else goto _L30
_L30:
        int i8 = 0;
        if(j24 == 0) goto _L33; else goto _L32
_L32:
        A[j6][i8] = c(j6, i8);
        i8++;
_L33:
        if(i8 < 96) goto _L32; else goto _L34
_L34:
        j6++;
_L31:
        if(j6 < 96) goto _L30; else goto _L2
_L2:
        F.b();
        j2 = 0x606060;
        f1 = 0;
        if(j24 == 0) goto _L36; else goto _L35
_L35:
        l2 = 0;
        if(j24 == 0) goto _L38; else goto _L37
_L37:
        i3 = j(f1, l2);
        if(i3 > 0 && (b.bj[i3 - 1] == 0 || a))
        {
            a(F, i3 - 1, f1, l2, f1 + 1, l2);
            if(flag && b.bi[i3 - 1] != 0)
            {
                z[f1][l2] |= 1;
                if(l2 > 0)
                    a(f1, l2 - 1, 4);
            }
            if(flag)
                c.b(f1 * 3, l2 * 3, 3, j2);
        }
        i3 = k(f1, l2);
        if(i3 > 0 && (b.bj[i3 - 1] == 0 || a))
        {
            a(F, i3 - 1, f1, l2, f1, l2 + 1);
            if(flag && b.bi[i3 - 1] != 0)
            {
                z[f1][l2] |= 2;
                if(f1 > 0)
                    a(f1 - 1, l2, 8);
            }
            if(flag)
                c.c(f1 * 3, l2 * 3, 3, j2);
        }
        i3 = e(f1, l2);
        if(i3 > 0 && i3 < 12000 && (b.bj[i3 - 1] == 0 || a))
        {
            a(F, i3 - 1, f1, l2, f1 + 1, l2 + 1);
            if(flag && b.bi[i3 - 1] != 0)
                z[f1][l2] |= 0x20;
            if(flag)
            {
                c.a(f1 * 3, l2 * 3, j2);
                c.a(f1 * 3 + 1, l2 * 3 + 1, j2);
                c.a(f1 * 3 + 2, l2 * 3 + 2, j2);
            }
        }
        if(i3 > 12000 && i3 < 24000 && (b.bj[i3 - 12001] == 0 || a))
        {
            a(F, i3 - 12001, f1 + 1, l2, f1, l2 + 1);
            if(flag && b.bi[i3 - 12001] != 0)
                z[f1][l2] |= 0x10;
            if(flag)
            {
                c.a(f1 * 3 + 2, l2 * 3, j2);
                c.a(f1 * 3 + 1, l2 * 3 + 1, j2);
                c.a(f1 * 3, l2 * 3 + 2, j2);
            }
        }
        l2++;
_L38:
        if(l2 < 95) goto _L37; else goto _L39
_L39:
        f1++;
_L36:
        if(f1 < 95) goto _L35; else goto _L40
_L40:
        if(flag)
            c.d(e - 1, 0, 0, 285, 285);
        F.a(false, 60, 24, -50, -10, -50);
        D[k1] = F.a(0, 0, 1536, 1536, 8, 64, 338, true);
        l2 = 0;
        if(j24 == 0) goto _L42; else goto _L41
_L41:
        d.a(D[k1][l2]);
        l2++;
_L42:
        if(l2 < 64) goto _L41; else goto _L43
_L43:
        i3 = 0;
        if(j24 == 0) goto _L45; else goto _L44
_L44:
        k3 = 0;
        if(j24 == 0) goto _L47; else goto _L46
_L46:
        j4 = j(i3, k3);
        if(j4 > 0)
            c(j4 - 1, i3, k3, i3 + 1, k3);
        j4 = k(i3, k3);
        if(j4 > 0)
            c(j4 - 1, i3, k3, i3, k3 + 1);
        j4 = e(i3, k3);
        if(j4 > 0 && j4 < 12000)
            c(j4 - 1, i3, k3, i3 + 1, k3 + 1);
        if(j4 > 12000 && j4 < 24000)
            c(j4 - 12001, i3 + 1, k3, i3, k3 + 1);
        k3++;
_L47:
        if(k3 < 95) goto _L46; else goto _L48
_L48:
        i3++;
_L45:
        if(i3 < 95) goto _L44; else goto _L49
_L49:
        k3 = 1;
        if(j24 == 0) goto _L51; else goto _L50
_L50:
        j4 = 1;
        if(j24 == 0) goto _L53; else goto _L52
_L52:
        int i12;
        int j14;
        int i15;
        int i17;
        int k18;
        int i19;
        int k19;
        int k20;
        int i21;
        int k21;
label2:
        {
            j6 = f(k3, j4);
            if(j6 <= 0)
                continue; /* Loop/switch isn't completed */
            i8 = k3;
            int l9 = j4;
            i12 = k3 + 1;
            j14 = j4;
            i15 = k3 + 1;
            i17 = j4 + 1;
            k18 = k3;
            i19 = j4 + 1;
            k19 = 0;
            int i20 = A[i8][l9];
            k20 = A[i12][j14];
            i21 = A[i15][i17];
            k21 = A[k18][i19];
            if(i20 > 0x13880)
                i20 -= 0x13880;
            if(k20 > 0x13880)
                k20 -= 0x13880;
            if(i21 > 0x13880)
                i21 -= 0x13880;
            if(k21 > 0x13880)
                k21 -= 0x13880;
            if(i20 > k19)
                k19 = i20;
            if(k20 > k19)
                k19 = k20;
            if(i21 > k19)
                k19 = i21;
            if(k21 > k19)
                k19 = k21;
            if(k19 >= 0x13880)
                k19 -= 0x13880;
            if(i20 < 0x13880)
            {
                A[i8][l9] = k19;
                if(j24 == 0)
                    break label2;
            }
            A[i8][l9] -= 0x13880;
        }
label3:
        {
            if(k20 < 0x13880)
            {
                A[i12][j14] = k19;
                if(j24 == 0)
                    break label3;
            }
            A[i12][j14] -= 0x13880;
        }
label4:
        {
            if(i21 < 0x13880)
            {
                A[i15][i17] = k19;
                if(j24 == 0)
                    break label4;
            }
            A[i15][i17] -= 0x13880;
        }
        if(k21 < 0x13880)
        {
            A[k18][i19] = k19;
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        A[k18][i19] -= 0x13880;
        j4++;
_L53:
        if(j4 < 95) goto _L52; else goto _L54
_L54:
        k3++;
_L51:
        if(k3 < 95) goto _L50; else goto _L55
_L55:
        F.b();
        j4 = 1;
        if(j24 == 0) goto _L57; else goto _L56
_L56:
        j6 = 1;
        if(j24 == 0) goto _L59; else goto _L58
_L58:
        i8 = f(j4, j6);
        if(i8 <= 0)
            continue; /* Loop/switch isn't completed */
        int i10 = j4;
        int j12 = j6;
        int k14 = j4 + 1;
        int j15 = j6;
        int j17 = j4 + 1;
        int l18 = j6 + 1;
        int j19 = j4;
        int l19 = j6 + 1;
        int j20 = j4 * 128;
        int l20 = j6 * 128;
        int j21 = j20 + 128;
        int l21 = l20 + 128;
        int i22 = j20;
        int j22 = l20;
        int k22 = j21;
        int l22 = l21;
        int i23 = A[i10][j12];
        int j23 = A[k14][j15];
        int k23 = A[j17][l18];
        int l23 = A[j19][l19];
        int i24 = b.bl[i8 - 1];
        if(i(i10, j12) && i23 < 0x13880)
        {
            i23 += i24 + 0x13880;
            A[i10][j12] = i23;
        }
        if(i(k14, j15) && j23 < 0x13880)
        {
            j23 += i24 + 0x13880;
            A[k14][j15] = j23;
        }
        if(i(j17, l18) && k23 < 0x13880)
        {
            k23 += i24 + 0x13880;
            A[j17][l18] = k23;
        }
        if(i(j19, l19) && l23 < 0x13880)
        {
            l23 += i24 + 0x13880;
            A[j19][l19] = l23;
        }
        if(i23 >= 0x13880)
            i23 -= 0x13880;
        if(j23 >= 0x13880)
            j23 -= 0x13880;
        if(k23 >= 0x13880)
            k23 -= 0x13880;
        if(l23 >= 0x13880)
            l23 -= 0x13880;
        byte byte0 = 16;
        if(!h(i10 - 1, j12))
            j20 -= byte0;
        if(!h(i10 + 1, j12))
            j20 += byte0;
        if(!h(i10, j12 - 1))
            l20 -= byte0;
        if(!h(i10, j12 + 1))
            l20 += byte0;
        if(!h(k14 - 1, j15))
            j21 -= byte0;
        if(!h(k14 + 1, j15))
            j21 += byte0;
        if(!h(k14, j15 - 1))
            j22 -= byte0;
        if(!h(k14, j15 + 1))
            j22 += byte0;
        if(!h(j17 - 1, l18))
            k22 -= byte0;
        if(!h(j17 + 1, l18))
            k22 += byte0;
        if(!h(j17, l18 - 1))
            l21 -= byte0;
        if(!h(j17, l18 + 1))
            l21 += byte0;
        if(!h(j19 - 1, l19))
            i22 -= byte0;
        if(!h(j19 + 1, l19))
            i22 += byte0;
        if(!h(j19, l19 - 1))
            l22 -= byte0;
        if(!h(j19, l19 + 1))
            l22 += byte0;
        i8 = b.bm[i8 - 1];
        i23 = -i23;
        j23 = -j23;
        k23 = -k23;
        l23 = -l23;
        if(e(j4, j6) > 12000 && e(j4, j6) < 24000 && f(j4 - 1, j6 - 1) == 0)
        {
            int ai8[] = new int[3];
            ai8[0] = F.a(k22, k23, l21);
            ai8[1] = F.a(i22, l23, l22);
            ai8[2] = F.a(j21, j23, j22);
            F.a(3, ai8, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(e(j4, j6) > 12000 && e(j4, j6) < 24000 && f(j4 + 1, j6 + 1) == 0)
        {
            int ai9[] = new int[3];
            ai9[0] = F.a(j20, i23, l20);
            ai9[1] = F.a(j21, j23, j22);
            ai9[2] = F.a(i22, l23, l22);
            F.a(3, ai9, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(e(j4, j6) > 0 && e(j4, j6) < 12000 && f(j4 + 1, j6 - 1) == 0)
        {
            int ai10[] = new int[3];
            ai10[0] = F.a(i22, l23, l22);
            ai10[1] = F.a(j20, i23, l20);
            ai10[2] = F.a(k22, k23, l21);
            F.a(3, ai10, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(e(j4, j6) > 0 && e(j4, j6) < 12000 && f(j4 - 1, j6 + 1) == 0)
        {
            int ai11[] = new int[3];
            ai11[0] = F.a(j21, j23, j22);
            ai11[1] = F.a(k22, k23, l21);
            ai11[2] = F.a(j20, i23, l20);
            F.a(3, ai11, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(i23 == j23 && k23 == l23)
        {
            int ai12[] = new int[4];
            ai12[0] = F.a(j20, i23, l20);
            ai12[1] = F.a(j21, j23, j22);
            ai12[2] = F.a(k22, k23, l21);
            ai12[3] = F.a(i22, l23, l22);
            F.a(4, ai12, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        if(i23 == l23 && j23 == k23)
        {
            int ai13[] = new int[4];
            ai13[0] = F.a(i22, l23, l22);
            ai13[1] = F.a(j20, i23, l20);
            ai13[2] = F.a(j21, j23, j22);
            ai13[3] = F.a(k22, k23, l21);
            F.a(4, ai13, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = true;
        if(f(j4 - 1, j6 - 1) > 0)
            flag1 = false;
        if(f(j4 + 1, j6 + 1) > 0)
            flag1 = false;
        if(!flag1)
        {
            int ai14[] = new int[3];
            ai14[0] = F.a(j21, j23, j22);
            ai14[1] = F.a(k22, k23, l21);
            ai14[2] = F.a(j20, i23, l20);
            F.a(3, ai14, i8, 0xbc614e);
            int ai16[] = new int[3];
            ai16[0] = F.a(i22, l23, l22);
            ai16[1] = F.a(j20, i23, l20);
            ai16[2] = F.a(k22, k23, l21);
            F.a(3, ai16, i8, 0xbc614e);
            if(j24 == 0)
                continue; /* Loop/switch isn't completed */
        }
        int ai15[] = new int[3];
        ai15[0] = F.a(j20, i23, l20);
        ai15[1] = F.a(j21, j23, j22);
        ai15[2] = F.a(i22, l23, l22);
        F.a(3, ai15, i8, 0xbc614e);
        int ai17[] = new int[3];
        ai17[0] = F.a(k22, k23, l21);
        ai17[1] = F.a(i22, l23, l22);
        ai17[2] = F.a(j21, j23, j22);
        F.a(3, ai17, i8, 0xbc614e);
        j6++;
_L59:
        if(j6 < 95) goto _L58; else goto _L60
_L60:
        j4++;
_L57:
        if(j4 < 95) goto _L56; else goto _L61
_L61:
        F.a(true, 50, 50, -50, -10, -50);
        E[k1] = F.a(0, 0, 1536, 1536, 8, 64, 169, true);
        j6 = 0;
        if(j24 == 0) goto _L63; else goto _L62
_L62:
        d.a(E[k1][j6]);
        j6++;
_L63:
        if(j6 < 64) goto _L62; else goto _L64
_L64:
        if(E[k1][0] == null)
            throw new RuntimeException("null roof!");
        i8 = 0;
        if(j24 == 0) goto _L66; else goto _L65
_L65:
        int j10 = 0;
        if(j24 == 0) goto _L68; else goto _L67
_L67:
        if(A[i8][j10] >= 0x13880)
            A[i8][j10] -= 0x13880;
        j10++;
_L68:
        if(j10 < 96) goto _L67; else goto _L69
_L69:
        i8++;
_L66:
        if(i8 >= 96)
            return;
        if(true) goto _L65; else goto _L70
_L70:
    }

    public void a(f af[])
    {
        int i1;
        int i4;
        i4 = b.bN;
        i1 = 0;
        if(i4 == 0) goto _L2; else goto _L1
_L1:
        int j1 = 0;
        if(i4 == 0) goto _L4; else goto _L3
_L3:
        int k1;
        int i2;
        int j2;
        int k3;
label0:
        {
            if(e(i1, j1) <= 48000 || e(i1, j1) >= 60000)
                continue; /* Loop/switch isn't completed */
            k1 = e(i1, j1) - 48001;
            int l1 = g(i1, j1);
            if(l1 == 0 || l1 == 4)
            {
                i2 = b.W[k1];
                j2 = b.X[k1];
                if(i4 == 0)
                    break label0;
            }
            j2 = b.W[k1];
            i2 = b.X[k1];
        }
        c(i1, j1, k1);
        f f1 = af[b.V[k1]].a(false, true, false, false);
        int k2 = ((i1 + i1 + i2) * 128) / 2;
        int i3 = ((j1 + j1 + j2) * 128) / 2;
        f1.f(k2, -b(k2, i3), i3);
        f1.e(0, g(i1, j1) * 32, 0);
        d.a(f1);
        f1.a(48, 48, -50, -10, -50);
        if(i2 <= 1 && j2 <= 1)
            continue; /* Loop/switch isn't completed */
        k3 = i1;
        if(i4 == 0) goto _L6; else goto _L5
_L5:
        int l3 = j1;
        if(i4 == 0) goto _L8; else goto _L7
_L7:
        int l2;
        int j3;
        byte byte0;
label1:
        {
            if(k3 <= i1 && l3 <= j1 || e(k3, l3) - 48001 != k1)
                continue; /* Loop/switch isn't completed */
            l2 = k3;
            j3 = l3;
            byte0 = 0;
            if(l2 >= 48 && j3 < 48)
            {
                byte0 = 1;
                l2 -= 48;
                if(i4 == 0)
                    break label1;
            }
            if(l2 < 48 && j3 >= 48)
            {
                byte0 = 2;
                j3 -= 48;
                if(i4 == 0)
                    break label1;
            }
            if(l2 >= 48 && j3 >= 48)
            {
                byte0 = 3;
                l2 -= 48;
                j3 -= 48;
            }
        }
        t[byte0][l2 * 48 + j3] = 0;
        l3++;
_L8:
        if(l3 < j1 + j2) goto _L7; else goto _L9
_L9:
        k3++;
_L6:
        if(k3 < i1 + i2) goto _L5; else goto _L10
_L10:
        j1++;
_L4:
        if(j1 < v - 2) goto _L3; else goto _L11
_L11:
        i1++;
_L2:
        if(i1 >= u - 2)
            return;
        if(true) goto _L1; else goto _L12
_L12:
    }

    public void a(f f1, int i1, int j1, int k1, int l1, int i2)
    {
        e(j1, k1, 40);
        e(l1, i2, 40);
        int j2 = b.bf[i1];
        int k2 = b.bg[i1];
        int l2 = b.bh[i1];
        int i3 = j1 * 128;
        int j3 = k1 * 128;
        int k3 = l1 * 128;
        int l3 = i2 * 128;
        int i4 = f1.a(i3, -A[j1][k1], j3);
        int j4 = f1.a(i3, -A[j1][k1] - j2, j3);
        int k4 = f1.a(k3, -A[l1][i2] - j2, l3);
        int l4 = f1.a(k3, -A[l1][i2], l3);
        int ai[] = {
            i4, j4, k4, l4
        };
        int i5 = f1.a(4, ai, k2, l2);
        if(b.bj[i1] == 5)
        {
            f1.G[i5] = 30000 + i1;
            return;
        } else
        {
            f1.G[i5] = 0;
            return;
        }
    }

    public void c(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = b.bf[i1];
        if(A[j1][k1] < 0x13880)
            A[j1][k1] += 0x13880 + j2;
        if(A[l1][i2] < 0x13880)
            A[l1][i2] += 0x13880 + j2;
    }
}