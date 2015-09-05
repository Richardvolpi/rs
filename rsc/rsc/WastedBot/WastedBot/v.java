// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   v.java

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;

public class v
    implements ImageProducer, ImageObserver
{

    public v(int i1, int j1, int k1, Component component)
    {
        a = false;
        b = false;
        c = false;
        j = component;
        s = j1;
        u = i1;
        p = m = i1;
        q = n = j1;
        o = i1 * j1;
        A = new int[i1 * j1];
        P = new int[k1][];
        d = new boolean[k1];
        g = new byte[k1][];
        Q = new int[k1][];
        B = new int[k1];
        C = new int[k1];
        F = new int[k1];
        G = new int[k1];
        D = new int[k1];
        E = new int[k1];
        if(i1 > 1 && j1 > 1 && component != null)
        {
            i = new DirectColorModel(32, 0xff0000, 65280, 255);
            int l1 = m * n;
            for(int i2 = 0; i2 < l1; i2++)
                A[i2] = 0;

            k = component.createImage(this);
            a();
            component.prepareImage(k, component);
            a();
            component.prepareImage(k, component);
            a();
            component.prepareImage(k, component);
        }
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        l = imageconsumer;
        imageconsumer.setDimensions(m, n);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(i);
        imageconsumer.setHints(14);
    }

    public boolean imageUpdate(Image image, int i1, int j1, int k1, int l1, int i2)
    {
        return true;
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return l == imageconsumer;
    }

    public synchronized void a()
    {
        if(!a)
        {
            if(l == null)
            {
                return;
            } else
            {
                l.setPixels(0, 0, m, n, i, A, 0, m);
                l.imageComplete(2);
                return;
            }
        } else
        {
            return;
        }
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if(i1 < 0)
            i1 = 0;
        if(j1 < 0)
            j1 = 0;
        if(k1 > m)
            k1 = m;
        if(l1 > n)
            l1 = n;
        t = i1;
        r = j1;
        u = k1;
        s = l1;
    }

    public void b()
    {
        t = 0;
        r = 0;
        u = m;
        s = n;
    }

    public void a(Graphics g1, int i1, int j1)
    {
        a();
        g1.drawImage(k, i1, j1, this);
    }

    public void c()
    {
        int i1 = z;
        int j1 = m * n;
        if(!b)
        {
            for(int k1 = 0; k1 < j1; k1++)
                A[k1] = 0;

            return;
        }
        int l1 = 0;
        for(int i2 = -n; i2 < 0; i2 += 2)
        {
            for(int j2 = -m; j2 < 0; j2++)
                A[l1++] = 0;

            l1 += m;
        }

    }

    public void a(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = z;
        int k2 = 256 - i2;
        int l2 = (l1 >> 16 & 0xff) * i2;
        int i3 = (l1 >> 8 & 0xff) * i2;
        int j3 = (l1 & 0xff) * i2;
        int k3 = j1 - k1;
        if(k3 < 0)
            k3 = 0;
        int l3 = j1 + k1;
        if(l3 >= n)
            l3 = n - 1;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            if((k3 & 1) != 0)
                k3++;
        }
        for(int i4 = k3; i4 <= l3; i4 += byte0)
        {
            int j4 = i4 - j1;
            int k4 = (int)Math.sqrt(k1 * k1 - j4 * j4);
            int l4 = i1 - k4;
            if(l4 < 0)
                l4 = 0;
            int i5 = i1 + k4;
            if(i5 >= m)
                i5 = m - 1;
            int j5 = l4 + i4 * m;
            for(int k5 = l4; k5 <= i5; k5++)
            {
                int l5 = (A[j5] >> 16 & 0xff) * k2;
                int i6 = (A[j5] >> 8 & 0xff) * k2;
                int j6 = (A[j5] & 0xff) * k2;
                int k6 = ((l2 + l5 >> 8) << 16) + ((i3 + i6 >> 8) << 8) + (j3 + j6 >> 8);
                A[j5++] = k6;
            }

        }

    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = z;
        if(i1 < t)
        {
            k1 -= t - i1;
            i1 = t;
        }
        if(j1 < r)
        {
            l1 -= r - j1;
            j1 = r;
        }
        if(i1 + k1 > u)
            k1 = u - i1;
        if(j1 + l1 > s)
            l1 = s - j1;
        int l2 = 256 - j2;
        int i3 = (i2 >> 16 & 0xff) * j2;
        int j3 = (i2 >> 8 & 0xff) * j2;
        int k3 = (i2 & 0xff) * j2;
        int l3 = m - k1;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            l3 += m;
            if((j1 & 1) != 0)
            {
                j1++;
                l1--;
            }
        }
        int i4 = i1 + j1 * m;
        for(int j4 = 0; j4 < l1; j4 += byte0)
        {
            for(int k4 = -k1; k4 < 0; k4++)
            {
                int l4 = (A[i4] >> 16 & 0xff) * l2;
                int i5 = (A[i4] >> 8 & 0xff) * l2;
                int j5 = (A[i4] & 0xff) * l2;
                int k5 = ((i3 + l4 >> 8) << 16) + ((j3 + i5 >> 8) << 8) + (k3 + j5 >> 8);
                A[i4++] = k5;
            }

            i4 += l3;
        }

    }

    public void b(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = z;
        if(i1 < t)
        {
            k1 -= t - i1;
            i1 = t;
        }
        if(i1 + k1 > u)
            k1 = u - i1;
        int l2 = j2 >> 16 & 0xff;
        int i3 = j2 >> 8 & 0xff;
        int j3 = j2 & 0xff;
        int k3 = i2 >> 16 & 0xff;
        int l3 = i2 >> 8 & 0xff;
        int i4 = i2 & 0xff;
        int j4 = m - k1;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            j4 += m;
            if((j1 & 1) != 0)
            {
                j1++;
                l1--;
            }
        }
        int k4 = i1 + j1 * m;
        for(int l4 = 0; l4 < l1; l4 += byte0)
            if(l4 + j1 >= r && l4 + j1 < s)
            {
                int i5 = ((l2 * l4 + k3 * (l1 - l4)) / l1 << 16) + ((i3 * l4 + l3 * (l1 - l4)) / l1 << 8) + (j3 * l4 + i4 * (l1 - l4)) / l1;
                for(int j5 = -k1; j5 < 0; j5++)
                    A[k4++] = i5;

                k4 += j4;
            } else
            {
                k4 += m;
            }

    }

    public void b(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = z;
        if(i1 < t)
        {
            k1 -= t - i1;
            i1 = t;
        }
        if(j1 < r)
        {
            l1 -= r - j1;
            j1 = r;
        }
        if(i1 + k1 > u)
            k1 = u - i1;
        if(j1 + l1 > s)
            l1 = s - j1;
        int k2 = m - k1;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            k2 += m;
            if((j1 & 1) != 0)
            {
                j1++;
                l1--;
            }
        }
        int l2 = i1 + j1 * m;
        for(int i3 = -l1; i3 < 0; i3 += byte0)
        {
            for(int j3 = -k1; j3 < 0; j3++)
                A[l2++] = i2;

            l2 += k2;
        }

    }

    public void c(int i1, int j1, int k1, int l1, int i2)
    {
        b(i1, j1, k1, i2);
        b(i1, (j1 + l1) - 1, k1, i2);
        c(i1, j1, l1, i2);
        c((i1 + k1) - 1, j1, l1, i2);
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        if(j1 < r || j1 >= s)
            return;
        if(i1 < t)
        {
            k1 -= t - i1;
            i1 = t;
        }
        if(i1 + k1 > u)
            k1 = u - i1;
        int i2 = i1 + j1 * m;
        for(int j2 = 0; j2 < k1; j2++)
            A[i2 + j2] = l1;

    }

    public void c(int i1, int j1, int k1, int l1)
    {
        if(i1 < t || i1 >= u)
            return;
        if(j1 < r)
        {
            k1 -= r - j1;
            j1 = r;
        }
        if(j1 + k1 > u)
            k1 = s - j1;
        int i2 = i1 + j1 * m;
        for(int j2 = 0; j2 < k1; j2++)
            A[i2 + j2 * m] = l1;

    }

    public void a(int i1, int j1, int k1)
    {
        if(i1 < t || j1 < r || i1 >= u || j1 >= s)
        {
            return;
        } else
        {
            A[i1 + j1 * m] = k1;
            return;
        }
    }

    public void d()
    {
        int i1 = m * n;
        for(int j1 = 0; j1 < i1; j1++)
        {
            int k1 = A[j1] & 0xffffff;
            A[j1] = (k1 >>> 1 & 0x7f7f7f) + (k1 >>> 2 & 0x3f3f3f) + (k1 >>> 3 & 0x1f1f1f) + (k1 >>> 4 & 0xf0f0f);
        }

    }

    public void c(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        int k2 = z;
        for(int l2 = k1; l2 < k1 + i2; l2++)
        {
            for(int i3 = l1; i3 < l1 + j2; i3++)
            {
                int j3 = 0;
                int k3 = 0;
                int l3 = 0;
                int i4 = 0;
                for(int j4 = l2 - i1; j4 <= l2 + i1; j4++)
                {
                    if(j4 < 0 || j4 >= m)
                        continue;
                    for(int k4 = i3 - j1; k4 <= i3 + j1; k4++)
                        if(k4 >= 0 && k4 < n)
                        {
                            int l4 = A[j4 + m * k4];
                            j3 += l4 >> 16 & 0xff;
                            k3 += l4 >> 8 & 0xff;
                            l3 += l4 & 0xff;
                            i4++;
                        }

                }

                A[l2 + m * i3] = (j3 / i4 << 16) + (k3 / i4 << 8) + l3 / i4;
            }

        }

    }

    public static int b(int i1, int j1, int k1)
    {
        return (i1 << 16) + (j1 << 8) + k1;
    }

    public void e()
    {
        for(int i1 = 0; i1 < P.length; i1++)
        {
            P[i1] = null;
            B[i1] = 0;
            C[i1] = 0;
            g[i1] = null;
            Q[i1] = null;
        }

    }

    public void a(int i1, byte abyte0[], byte abyte1[], int j1)
    {
        int k1 = z;
        int l1 = m.a(abyte0, 0);
        int i2 = m.a(abyte1, l1);
        l1 += 2;
        int j2 = m.a(abyte1, l1);
        l1 += 2;
        int k2 = abyte1[l1++] & 0xff;
        int ai[] = new int[k2];
        ai[0] = 0xff00ff;
        for(int l2 = 0; l2 < k2 - 1; l2++)
        {
            ai[l2 + 1] = ((abyte1[l1] & 0xff) << 16) + ((abyte1[l1 + 1] & 0xff) << 8) + (abyte1[l1 + 2] & 0xff);
            l1 += 3;
        }

        int i3 = 2;
label0:
        for(int j3 = i1; j3 < i1 + j1; j3++)
        {
            D[j3] = abyte1[l1++] & 0xff;
            E[j3] = abyte1[l1++] & 0xff;
            B[j3] = m.a(abyte1, l1);
            l1 += 2;
            C[j3] = m.a(abyte1, l1);
            l1 += 2;
            int k3 = abyte1[l1++] & 0xff;
            int l3 = B[j3] * C[j3];
            g[j3] = new byte[l3];
            Q[j3] = ai;
            F[j3] = i2;
            G[j3] = j2;
            P[j3] = null;
            d[j3] = false;
            if(D[j3] != 0 || E[j3] != 0)
                d[j3] = true;
            if(k3 == 0)
            {
                int i4 = 0;
                do
                {
                    if(i4 >= l3)
                        continue label0;
                    g[j3][i4] = abyte0[i3++];
                    if(g[j3][i4] == 0)
                        d[j3] = true;
                    i4++;
                } while(true);
            }
            if(k3 != 1)
                continue;
            int j4 = 0;
            do
            {
                if(j4 >= B[j3])
                    continue label0;
                for(int k4 = 0; k4 < C[j3]; k4++)
                {
                    g[j3][j4 + k4 * B[j3]] = abyte0[i3++];
                    if(g[j3][j4 + k4 * B[j3]] == 0)
                        d[j3] = true;
                }

                j4++;
            } while(true);
        }

    }

    public void a(int i1, byte abyte0[])
    {
        int j1 = z;
        int ai[] = P[i1] = new int[10200];
        B[i1] = 255;
        C[i1] = 40;
        D[i1] = 0;
        E[i1] = 0;
        F[i1] = 255;
        G[i1] = 40;
        d[i1] = false;
        int k1 = 0;
        int l1 = 1;
        int i2;
        for(i2 = 0; i2 < 255;)
        {
            int j2 = abyte0[l1++] & 0xff;
            for(int l2 = 0; l2 < j2; l2++)
                ai[i2++] = k1;

            k1 = 0xffffff - k1;
        }

label0:
        for(int k2 = 1; k2 < 40; k2++)
        {
            int i3 = 0;
            do
            {
                if(i3 >= 255)
                    continue label0;
                int j3 = abyte0[l1++] & 0xff;
                for(int k3 = 0; k3 < j3; k3++)
                {
                    ai[i2] = ai[i2 - 255];
                    i2++;
                    i3++;
                }

                if(i3 < 255)
                {
                    ai[i2] = 0xffffff - ai[i2 - 255];
                    i2++;
                    i3++;
                }
            } while(true);
        }

    }

    public void a(int i1)
    {
        int j1 = z;
        int k1 = B[i1] * C[i1];
        int ai[] = P[i1];
        int ai1[] = new int[32768];
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = ai[l1];
            ai1[((i2 & 0xf80000) >> 9) + ((i2 & 0xf800) >> 6) + ((i2 & 0xf8) >> 3)]++;
        }

        int ai2[] = new int[256];
        ai2[0] = 0xff00ff;
        int ai3[] = new int[256];
        for(int j2 = 0; j2 < 32768; j2++)
        {
            int k2 = ai1[j2];
            if(k2 > ai3[255])
            {
                int i3 = 1;
                do
                {
                    if(i3 >= 256)
                        break;
                    if(k2 > ai3[i3])
                    {
                        for(int k3 = 255; k3 > i3; k3--)
                        {
                            ai2[k3] = ai2[k3 - 1];
                            ai3[k3] = ai3[k3 - 1];
                        }

                        ai2[i3] = ((j2 & 0x7c00) << 9) + ((j2 & 0x3e0) << 6) + ((j2 & 0x1f) << 3) + 0x40404;
                        ai3[i3] = k2;
                        break;
                    }
                    i3++;
                } while(true);
            }
            ai1[j2] = -1;
        }

        byte abyte0[] = new byte[k1];
        for(int l2 = 0; l2 < k1; l2++)
        {
            int j3 = ai[l2];
            int l3 = ((j3 & 0xf80000) >> 9) + ((j3 & 0xf800) >> 6) + ((j3 & 0xf8) >> 3);
            int i4 = ai1[l3];
            if(i4 == -1)
            {
                int j4 = 0x3b9ac9ff;
                int k4 = j3 >> 16 & 0xff;
                int l4 = j3 >> 8 & 0xff;
                int i5 = j3 & 0xff;
                for(int j5 = 0; j5 < 256; j5++)
                {
                    int k5 = ai2[j5];
                    int l5 = k5 >> 16 & 0xff;
                    int i6 = k5 >> 8 & 0xff;
                    int j6 = k5 & 0xff;
                    int k6 = (k4 - l5) * (k4 - l5) + (l4 - i6) * (l4 - i6) + (i5 - j6) * (i5 - j6);
                    if(k6 < j4)
                    {
                        j4 = k6;
                        i4 = j5;
                    }
                }

                ai1[l3] = i4;
            }
            abyte0[l2] = (byte)i4;
        }

        g[i1] = abyte0;
        Q[i1] = ai2;
        P[i1] = null;
    }

    public void b(int i1)
    {
        int j1 = z;
        if(g[i1] == null)
            return;
        int k1 = B[i1] * C[i1];
        byte abyte0[] = g[i1];
        int ai[] = Q[i1];
        int ai1[] = new int[k1];
        for(int l1 = 0; l1 < k1; l1++)
        {
            int i2 = ai[abyte0[l1] & 0xff];
            if(i2 == 0)
                i2 = 1;
            else
            if(i2 == 0xff00ff)
                i2 = 0;
            ai1[l1] = i2;
        }

        P[i1] = ai1;
        g[i1] = null;
        Q[i1] = null;
    }

    public void d(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = z;
        B[i1] = l1;
        C[i1] = i2;
        d[i1] = false;
        D[i1] = 0;
        E[i1] = 0;
        F[i1] = l1;
        G[i1] = i2;
        int k2 = l1 * i2;
        int l2 = 0;
        P[i1] = new int[k2];
        for(int i3 = j1; i3 < j1 + l1; i3++)
        {
            for(int j3 = k1; j3 < k1 + i2; j3++)
                P[i1][l2++] = A[i3 + j3 * m];

        }

    }

    public void e(int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = z;
        B[i1] = l1;
        C[i1] = i2;
        d[i1] = false;
        D[i1] = 0;
        E[i1] = 0;
        F[i1] = l1;
        G[i1] = i2;
        int k2 = l1 * i2;
        int l2 = 0;
        P[i1] = new int[k2];
        for(int i3 = k1; i3 < k1 + i2; i3++)
        {
            for(int j3 = j1; j3 < j1 + l1; j3++)
                P[i1][l2++] = A[j3 + i3 * m];

        }

    }

    public void c(int i1, int j1, int k1)
    {
        if(d[k1])
        {
            i1 += D[k1];
            j1 += E[k1];
        }
        int l1 = i1 + j1 * m;
        int i2 = 0;
        int j2 = C[k1];
        int k2 = B[k1];
        int l2 = m - k2;
        int i3 = 0;
        if(j1 < r)
        {
            int j3 = r - j1;
            j2 -= j3;
            j1 = r;
            i2 += j3 * k2;
            l1 += j3 * m;
        }
        if(j1 + j2 >= s)
            j2 -= ((j1 + j2) - s) + 1;
        if(i1 < t)
        {
            int k3 = t - i1;
            k2 -= k3;
            i1 = t;
            i2 += k3;
            l1 += k3;
            i3 += k3;
            l2 += k3;
        }
        if(i1 + k2 >= u)
        {
            int l3 = ((i1 + k2) - u) + 1;
            k2 -= l3;
            i3 += l3;
            l2 += l3;
        }
        if(k2 <= 0 || j2 <= 0)
            return;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            l2 += m;
            i3 += B[k1];
            if((j1 & 1) != 0)
            {
                l1 += m;
                j2--;
            }
        }
        if(P[k1] == null)
        {
            a(A, g[k1], Q[k1], i2, l1, k2, j2, l2, i3, byte0);
            return;
        } else
        {
            a(A, P[k1], 0, i2, l1, k2, j2, l2, i3, byte0);
            return;
        }
    }

    public void f(int i1, int j1, int k1, int l1, int i2)
    {
        try
        {
            int j2 = B[i2];
            int k2 = C[i2];
            int l2 = 0;
            int i3 = 0;
            int j3 = (j2 << 16) / k1;
            int k3 = (k2 << 16) / l1;
            if(d[i2])
            {
                int l3 = F[i2];
                int j4 = G[i2];
                j3 = (l3 << 16) / k1;
                k3 = (j4 << 16) / l1;
                i1 += ((D[i2] * k1 + l3) - 1) / l3;
                j1 += ((E[i2] * l1 + j4) - 1) / j4;
                if((D[i2] * k1) % l3 != 0)
                    l2 = (l3 - (D[i2] * k1) % l3 << 16) / k1;
                if((E[i2] * l1) % j4 != 0)
                    i3 = (j4 - (E[i2] * l1) % j4 << 16) / l1;
                k1 = (k1 * (B[i2] - (l2 >> 16))) / l3;
                l1 = (l1 * (C[i2] - (i3 >> 16))) / j4;
            }
            int i4 = i1 + j1 * m;
            int k4 = m - k1;
            if(j1 < r)
            {
                int l4 = r - j1;
                l1 -= l4;
                j1 = 0;
                i4 += l4 * m;
                i3 += k3 * l4;
            }
            if(j1 + l1 >= s)
                l1 -= ((j1 + l1) - s) + 1;
            if(i1 < t)
            {
                int i5 = t - i1;
                k1 -= i5;
                i1 = 0;
                i4 += i5;
                l2 += j3 * i5;
                k4 += i5;
            }
            if(i1 + k1 >= u)
            {
                int j5 = ((i1 + k1) - u) + 1;
                k1 -= j5;
                k4 += j5;
            }
            byte byte0 = 1;
            if(b)
            {
                byte0 = 2;
                k4 += m;
                k3 += k3;
                if((j1 & 1) != 0)
                {
                    i4 += m;
                    l1--;
                }
            }
            a(A, P[i2], 0, l2, i3, i4, k4, k1, l1, j3, k3, j2, byte0);
            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[0]);
        }
    }

    public void d(int i1, int j1, int k1, int l1)
    {
        if(d[k1])
        {
            i1 += D[k1];
            j1 += E[k1];
        }
        int i2 = i1 + j1 * m;
        int j2 = 0;
        int k2 = C[k1];
        int l2 = B[k1];
        int i3 = m - l2;
        int j3 = 0;
        if(j1 < r)
        {
            int k3 = r - j1;
            k2 -= k3;
            j1 = r;
            j2 += k3 * l2;
            i2 += k3 * m;
        }
        if(j1 + k2 >= s)
            k2 -= ((j1 + k2) - s) + 1;
        if(i1 < t)
        {
            int l3 = t - i1;
            l2 -= l3;
            i1 = t;
            j2 += l3;
            i2 += l3;
            j3 += l3;
            i3 += l3;
        }
        if(i1 + l2 >= u)
        {
            int i4 = ((i1 + l2) - u) + 1;
            l2 -= i4;
            j3 += i4;
            i3 += i4;
        }
        if(l2 <= 0 || k2 <= 0)
            return;
        byte byte0 = 1;
        if(b)
        {
            byte0 = 2;
            i3 += m;
            j3 += B[k1];
            if((j1 & 1) != 0)
            {
                i2 += m;
                k2--;
            }
        }
        if(P[k1] == null)
        {
            a(A, g[k1], Q[k1], j2, i2, l2, k2, i3, j3, byte0, l1);
            return;
        } else
        {
            a(A, P[k1], 0, j2, i2, l2, k2, i3, j3, byte0, l1);
            return;
        }
    }

    public void d(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        try
        {
            int k2 = B[i2];
            int l2 = C[i2];
            int i3 = 0;
            int j3 = 0;
            int k3 = (k2 << 16) / k1;
            int l3 = (l2 << 16) / l1;
            if(d[i2])
            {
                int i4 = F[i2];
                int k4 = G[i2];
                k3 = (i4 << 16) / k1;
                l3 = (k4 << 16) / l1;
                i1 += ((D[i2] * k1 + i4) - 1) / i4;
                j1 += ((E[i2] * l1 + k4) - 1) / k4;
                if((D[i2] * k1) % i4 != 0)
                    i3 = (i4 - (D[i2] * k1) % i4 << 16) / k1;
                if((E[i2] * l1) % k4 != 0)
                    j3 = (k4 - (E[i2] * l1) % k4 << 16) / l1;
                k1 = (k1 * (B[i2] - (i3 >> 16))) / i4;
                l1 = (l1 * (C[i2] - (j3 >> 16))) / k4;
            }
            int j4 = i1 + j1 * m;
            int l4 = m - k1;
            if(j1 < r)
            {
                int i5 = r - j1;
                l1 -= i5;
                j1 = 0;
                j4 += i5 * m;
                j3 += l3 * i5;
            }
            if(j1 + l1 >= s)
                l1 -= ((j1 + l1) - s) + 1;
            if(i1 < t)
            {
                int j5 = t - i1;
                k1 -= j5;
                i1 = 0;
                j4 += j5;
                i3 += k3 * j5;
                l4 += j5;
            }
            if(i1 + k1 >= u)
            {
                int k5 = ((i1 + k1) - u) + 1;
                k1 -= k5;
                l4 += k5;
            }
            byte byte0 = 1;
            if(b)
            {
                byte0 = 2;
                l4 += m;
                l3 += l3;
                if((j1 & 1) != 0)
                {
                    j4 += m;
                    l1--;
                }
            }
            a(A, P[i2], 0, i3, j3, j4, l4, k1, l1, k3, l3, k2, byte0, j2);
            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[0]);
        }
    }

    public void e(int i1, int j1, int k1, int l1, int i2, int j2)
    {
        try
        {
            int k2 = B[i2];
            int l2 = C[i2];
            int i3 = 0;
            int j3 = 0;
            int k3 = (k2 << 16) / k1;
            int l3 = (l2 << 16) / l1;
            if(d[i2])
            {
                int i4 = F[i2];
                int k4 = G[i2];
                k3 = (i4 << 16) / k1;
                l3 = (k4 << 16) / l1;
                i1 += ((D[i2] * k1 + i4) - 1) / i4;
                j1 += ((E[i2] * l1 + k4) - 1) / k4;
                if((D[i2] * k1) % i4 != 0)
                    i3 = (i4 - (D[i2] * k1) % i4 << 16) / k1;
                if((E[i2] * l1) % k4 != 0)
                    j3 = (k4 - (E[i2] * l1) % k4 << 16) / l1;
                k1 = (k1 * (B[i2] - (i3 >> 16))) / i4;
                l1 = (l1 * (C[i2] - (j3 >> 16))) / k4;
            }
            int j4 = i1 + j1 * m;
            int l4 = m - k1;
            if(j1 < r)
            {
                int i5 = r - j1;
                l1 -= i5;
                j1 = 0;
                j4 += i5 * m;
                j3 += l3 * i5;
            }
            if(j1 + l1 >= s)
                l1 -= ((j1 + l1) - s) + 1;
            if(i1 < t)
            {
                int j5 = t - i1;
                k1 -= j5;
                i1 = 0;
                j4 += j5;
                i3 += k3 * j5;
                l4 += j5;
            }
            if(i1 + k1 >= u)
            {
                int k5 = ((i1 + k1) - u) + 1;
                k1 -= k5;
                l4 += k5;
            }
            byte byte0 = 1;
            if(b)
            {
                byte0 = 2;
                l4 += m;
                l3 += l3;
                if((j1 & 1) != 0)
                {
                    j4 += m;
                    l1--;
                }
            }
            b(A, P[i2], 0, i3, j3, j4, l4, k1, l1, k3, l3, k2, byte0, j2);
            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[0]);
        }
    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2)
    {
        int i3 = z;
        int j3 = -(l1 >> 2);
        l1 = -(l1 & 3);
        for(int k3 = -i2; k3 < 0; k3 += l2)
        {
            for(int l3 = j3; l3 < 0; l3++)
            {
                i1 = ai1[j1++];
                if(i1 != 0)
                    ai[k1++] = i1;
                else
                    k1++;
                i1 = ai1[j1++];
                if(i1 != 0)
                    ai[k1++] = i1;
                else
                    k1++;
                i1 = ai1[j1++];
                if(i1 != 0)
                    ai[k1++] = i1;
                else
                    k1++;
                i1 = ai1[j1++];
                if(i1 != 0)
                    ai[k1++] = i1;
                else
                    k1++;
            }

            for(int i4 = l1; i4 < 0; i4++)
            {
                i1 = ai1[j1++];
                if(i1 != 0)
                    ai[k1++] = i1;
                else
                    k1++;
            }

            k1 += j2;
            j1 += k2;
        }

    }

    private void a(int ai[], byte abyte0[], int ai1[], int i1, int j1, int k1, int l1, 
            int i2, int j2, int k2)
    {
        int l2 = z;
        int i3 = -(k1 >> 2);
        k1 = -(k1 & 3);
        for(int j3 = -l1; j3 < 0; j3 += k2)
        {
            for(int k3 = i3; k3 < 0; k3++)
            {
                byte byte0 = abyte0[i1++];
                if(byte0 != 0)
                    ai[j1++] = ai1[byte0 & 0xff];
                else
                    j1++;
                byte0 = abyte0[i1++];
                if(byte0 != 0)
                    ai[j1++] = ai1[byte0 & 0xff];
                else
                    j1++;
                byte0 = abyte0[i1++];
                if(byte0 != 0)
                    ai[j1++] = ai1[byte0 & 0xff];
                else
                    j1++;
                byte0 = abyte0[i1++];
                if(byte0 != 0)
                    ai[j1++] = ai1[byte0 & 0xff];
                else
                    j1++;
            }

            for(int l3 = k1; l3 < 0; l3++)
            {
                byte byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[j1++] = ai1[byte1 & 0xff];
                else
                    j1++;
            }

            j1 += i2;
            i1 += j2;
        }

    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3)
    {
        int l3 = z;
        try
        {
            int i4 = j1;
            for(int j4 = -k2; j4 < 0; j4 += k3)
            {
                int k4 = (k1 >> 16) * j3;
                for(int l4 = -j2; l4 < 0; l4++)
                {
                    i1 = ai1[(j1 >> 16) + k4];
                    if(i1 != 0)
                        ai[l1++] = i1;
                    else
                        l1++;
                    j1 += l2;
                }

                k1 += i3;
                j1 = i4;
                l1 += i2;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[3]);
        }
    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3)
    {
        int j3 = z;
        int k3 = 256 - i3;
        for(int l3 = -i2; l3 < 0; l3 += l2)
        {
            for(int i4 = -l1; i4 < 0; i4++)
            {
                i1 = ai1[j1++];
                if(i1 != 0)
                {
                    int j4 = ai[k1];
                    ai[k1++] = ((i1 & 0xff00ff) * i3 + (j4 & 0xff00ff) * k3 & 0xff00ff00) + ((i1 & 0xff00) * i3 + (j4 & 0xff00) * k3 & 0xff0000) >> 8;
                } else
                {
                    k1++;
                }
            }

            k1 += j2;
            j1 += k2;
        }

    }

    private void a(int ai[], byte abyte0[], int ai1[], int i1, int j1, int k1, int l1, 
            int i2, int j2, int k2, int l2)
    {
        int i3 = z;
        int j3 = 256 - l2;
        for(int k3 = -l1; k3 < 0; k3 += k2)
        {
            for(int l3 = -k1; l3 < 0; l3++)
            {
                int i4 = abyte0[i1++];
                if(i4 != 0)
                {
                    i4 = ai1[i4 & 0xff];
                    int j4 = ai[j1];
                    ai[j1++] = ((i4 & 0xff00ff) * l2 + (j4 & 0xff00ff) * j3 & 0xff00ff00) + ((i4 & 0xff00) * l2 + (j4 & 0xff00) * j3 & 0xff0000) >> 8;
                } else
                {
                    j1++;
                }
            }

            j1 += i2;
            i1 += j2;
        }

    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = z;
        int j4 = 256 - l3;
        try
        {
            int k4 = j1;
            for(int l4 = -k2; l4 < 0; l4 += k3)
            {
                int i5 = (k1 >> 16) * j3;
                for(int j5 = -j2; j5 < 0; j5++)
                {
                    i1 = ai1[(j1 >> 16) + i5];
                    if(i1 != 0)
                    {
                        int k5 = ai[l1];
                        ai[l1++] = ((i1 & 0xff00ff) * l3 + (k5 & 0xff00ff) * j4 & 0xff00ff00) + ((i1 & 0xff00) * l3 + (k5 & 0xff00) * j4 & 0xff0000) >> 8;
                    } else
                    {
                        l1++;
                    }
                    j1 += l2;
                }

                k1 += i3;
                j1 = k4;
                l1 += i2;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[2]);
        }
    }

    private void b(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3)
    {
        int i4 = z;
        int j4 = l3 >> 16 & 0xff;
        int k4 = l3 >> 8 & 0xff;
        int l4 = l3 & 0xff;
        try
        {
            int i5 = j1;
            for(int j5 = -k2; j5 < 0; j5 += k3)
            {
                int k5 = (k1 >> 16) * j3;
                for(int l5 = -j2; l5 < 0; l5++)
                {
                    i1 = ai1[(j1 >> 16) + k5];
                    if(i1 != 0)
                    {
                        int i6 = i1 >> 16 & 0xff;
                        int j6 = i1 >> 8 & 0xff;
                        int k6 = i1 & 0xff;
                        if(i6 == j6 && j6 == k6)
                            ai[l1++] = ((i6 * j4 >> 8) << 16) + ((j6 * k4 >> 8) << 8) + (k6 * l4 >> 8);
                        else
                            ai[l1++] = i1;
                    } else
                    {
                        l1++;
                    }
                    j1 += l2;
                }

                k1 += i3;
                j1 = i5;
                l1 += i2;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[3]);
        }
    }

    public void g(int i1, int j1, int k1, int l1, int i2)
    {
        int k2;
        int l2;
        int l7;
        int i8;
        int j8;
        int k8;
        int l8;
        int i9;
        int j9;
        int k9;
        boolean flag;
label0:
        {
            flag = R;
            int j2 = z;
            k2 = m;
            l2 = n;
            if(I == null)
            {
                I = new int[512];
                int i3 = 0;
                do
                {
                    if(i3 >= 256)
                        break;
                    I[i3] = (int)(Math.sin((double)i3 * 0.02454369D) * 32768D);
                    I[i3 + 256] = (int)(Math.cos((double)i3 * 0.02454369D) * 32768D);
                    i3++;
                } while(!flag);
            }
            int j3 = -F[k1] / 2;
            int l3 = -G[k1] / 2;
            if(d[k1])
            {
                j3 += D[k1];
                l3 += E[k1];
            }
            int j4 = j3 + B[k1];
            int l4 = l3 + C[k1];
            int j5 = j4;
            int l5 = l3;
            int j6 = j3;
            int l6 = l4;
            l1 &= 0xff;
            int j7 = I[l1] * i2;
            int k7 = I[l1 + 256] * i2;
            l7 = i1 + (l3 * j7 + j3 * k7 >> 22);
            i8 = j1 + (l3 * k7 - j3 * j7 >> 22);
            j8 = i1 + (l5 * j7 + j5 * k7 >> 22);
            k8 = j1 + (l5 * k7 - j5 * j7 >> 22);
            l8 = i1 + (l4 * j7 + j4 * k7 >> 22);
            i9 = j1 + (l4 * k7 - j4 * j7 >> 22);
            j9 = i1 + (l6 * j7 + j6 * k7 >> 22);
            k9 = j1 + (l6 * k7 - j6 * j7 >> 22);
            if(i2 == 192 && (l1 & 0x3f) == (x & 0x3f))
            {
                v++;
                if(!flag)
                    break label0;
            }
            if(i2 == 128)
            {
                x = l1;
                if(!flag)
                    break label0;
            }
            w++;
        }
        int l9;
        int i10;
label1:
        {
            l9 = i8;
            i10 = i8;
            if(k8 < l9)
            {
                l9 = k8;
                if(!flag)
                    break label1;
            }
            if(k8 > i10)
                i10 = k8;
        }
label2:
        {
            if(i9 < l9)
            {
                l9 = i9;
                if(!flag)
                    break label2;
            }
            if(i9 > i10)
                i10 = i9;
        }
label3:
        {
            if(k9 < l9)
            {
                l9 = k9;
                if(!flag)
                    break label3;
            }
            if(k9 > i10)
                i10 = k9;
        }
        int k3;
        int k4;
        int i5;
        int k5;
        int i6;
        int k6;
        int i7;
        int j10;
        int k10;
        int l10;
        int i11;
        int k11;
        int l11;
        int i12;
        int j12;
label4:
        {
            if(l9 < r)
                l9 = r;
            if(i10 > s)
                i10 = s;
            if(J == null || J.length != l2 + 1)
            {
                J = new int[l2 + 1];
                K = new int[l2 + 1];
                L = new int[l2 + 1];
                M = new int[l2 + 1];
                N = new int[l2 + 1];
                O = new int[l2 + 1];
            }
            j10 = l9;
            do
            {
                if(j10 > i10)
                    break;
                J[j10] = 0x5f5e0ff;
                K[j10] = 0xfa0a1f01;
                j10++;
            } while(!flag);
            j10 = 0;
            k10 = 0;
            l10 = 0;
            i11 = B[k1];
            int j11 = C[k1];
            k3 = 0;
            int i4 = 0;
            k5 = i11 - 1;
            i6 = 0;
            k4 = i11 - 1;
            i5 = j11 - 1;
            k6 = 0;
            i7 = j11 - 1;
            if(k9 != i8)
            {
                j10 = (j9 - l7 << 8) / (k9 - i8);
                l10 = (i7 - i4 << 8) / (k9 - i8);
            }
            if(i8 > k9)
            {
                i12 = j9 << 8;
                j12 = i7 << 8;
                k11 = k9;
                l11 = i8;
                if(!flag)
                    break label4;
            }
            i12 = l7 << 8;
            j12 = i4 << 8;
            k11 = i8;
            l11 = k9;
        }
        int k12;
label5:
        {
            if(k11 < 0)
            {
                i12 -= j10 * k11;
                j12 -= l10 * k11;
                k11 = 0;
            }
            if(l11 > l2 - 1)
                l11 = l2 - 1;
            k12 = k11;
            do
            {
                if(k12 > l11)
                    break;
                J[k12] = K[k12] = i12;
                i12 += j10;
                L[k12] = M[k12] = 0;
                N[k12] = O[k12] = j12;
                j12 += l10;
                k12++;
            } while(!flag);
            if(k8 != i8)
            {
                j10 = (j8 - l7 << 8) / (k8 - i8);
                k10 = (k5 - k3 << 8) / (k8 - i8);
            }
            if(i8 > k8)
            {
                i12 = j8 << 8;
                k12 = k5 << 8;
                k11 = k8;
                l11 = i8;
                if(!flag)
                    break label5;
            }
            i12 = l7 << 8;
            k12 = k3 << 8;
            k11 = i8;
            l11 = k8;
        }
label6:
        {
            if(k11 < 0)
            {
                i12 -= j10 * k11;
                k12 -= k10 * k11;
                k11 = 0;
            }
            if(l11 > l2 - 1)
                l11 = l2 - 1;
            int l12 = k11;
            do
            {
                if(l12 > l11)
                    break;
                if(i12 < J[l12])
                {
                    J[l12] = i12;
                    L[l12] = k12;
                    N[l12] = 0;
                }
                if(i12 > K[l12])
                {
                    K[l12] = i12;
                    M[l12] = k12;
                    O[l12] = 0;
                }
                i12 += j10;
                k12 += k10;
                l12++;
            } while(!flag);
            if(i9 != k8)
            {
                j10 = (l8 - j8 << 8) / (i9 - k8);
                l10 = (i5 - i6 << 8) / (i9 - k8);
            }
            if(k8 > i9)
            {
                i12 = l8 << 8;
                k12 = k4 << 8;
                j12 = i5 << 8;
                k11 = i9;
                l11 = k8;
                if(!flag)
                    break label6;
            }
            i12 = j8 << 8;
            k12 = k5 << 8;
            j12 = i6 << 8;
            k11 = k8;
            l11 = i9;
        }
label7:
        {
            if(k11 < 0)
            {
                i12 -= j10 * k11;
                j12 -= l10 * k11;
                k11 = 0;
            }
            if(l11 > l2 - 1)
                l11 = l2 - 1;
            int i13 = k11;
            do
            {
                if(i13 > l11)
                    break;
                if(i12 < J[i13])
                {
                    J[i13] = i12;
                    L[i13] = k12;
                    N[i13] = j12;
                }
                if(i12 > K[i13])
                {
                    K[i13] = i12;
                    M[i13] = k12;
                    O[i13] = j12;
                }
                i12 += j10;
                j12 += l10;
                i13++;
            } while(!flag);
            if(k9 != i9)
            {
                j10 = (j9 - l8 << 8) / (k9 - i9);
                k10 = (k6 - k4 << 8) / (k9 - i9);
            }
            if(i9 > k9)
            {
                i12 = j9 << 8;
                k12 = k6 << 8;
                j12 = i7 << 8;
                k11 = k9;
                l11 = i9;
                if(!flag)
                    break label7;
            }
            i12 = l8 << 8;
            k12 = k4 << 8;
            j12 = i5 << 8;
            k11 = i9;
            l11 = k9;
        }
        if(k11 < 0)
        {
            i12 -= j10 * k11;
            k12 -= k10 * k11;
            k11 = 0;
        }
        if(l11 > l2 - 1)
            l11 = l2 - 1;
        int j13 = k11;
        do
        {
            if(j13 > l11)
                break;
            if(i12 < J[j13])
            {
                J[j13] = i12;
                L[j13] = k12;
                N[j13] = j12;
            }
            if(i12 > K[j13])
            {
                K[j13] = i12;
                M[j13] = k12;
                O[j13] = j12;
            }
            i12 += j10;
            k12 += k10;
            j13++;
        } while(!flag);
        j13 = l9 * k2;
        int ai[] = P[k1];
        int k13 = l9;
label8:
        do
        {
label9:
            {
label10:
                {
                    if(k13 >= i10)
                        break label8;
                    int l13 = J[k13] >> 8;
                    int i14 = K[k13] >> 8;
                    if(i14 - l13 <= 0)
                    {
                        j13 += k2;
                        if(!flag)
                            break label9;
                    }
                    int j14 = L[k13] << 9;
                    int k14 = ((M[k13] << 9) - j14) / (i14 - l13);
                    int l14 = N[k13] << 9;
                    int i15 = ((O[k13] << 9) - l14) / (i14 - l13);
                    if(l13 < t)
                    {
                        j14 += (t - l13) * k14;
                        l14 += (t - l13) * i15;
                        l13 = t;
                    }
                    if(i14 > u)
                        i14 = u;
                    if(b && (k13 & 1) != 0)
                        break label10;
                    if(!d[k1])
                    {
                        b(A, ai, 0, j13 + l13, j14, l14, k14, i15, l13 - i14, i11);
                        if(!flag)
                            break label10;
                    }
                    c(A, ai, 0, j13 + l13, j14, l14, k14, i15, l13 - i14, i11);
                }
                j13 += k2;
            }
            k13++;
        } while(!flag);
        if(a.bb != 0)
            R = !flag;
    }

    private void b(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2)
    {
        for(i1 = k2; i1 < 0; i1++)
        {
            A[j1++] = ai1[(k1 >> 17) + (l1 >> 17) * l2];
            k1 += i2;
            l1 += j2;
        }

    }

    private void c(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2)
    {
        int i3 = z;
        for(int j3 = k2; j3 < 0; j3++)
        {
            i1 = ai1[(k1 >> 17) + (l1 >> 17) * l2];
            if(i1 != 0)
                A[j1++] = i1;
            else
                j1++;
            k1 += i2;
            l1 += j2;
        }

    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2)
    {
        f(i1, j1, k1, l1, i2);
    }

    public void a(int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, boolean flag)
    {
        int i3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int j5;
        int i6;
        if(j2 == 0)
            j2 = 0xffffff;
        if(k2 == 0)
            k2 = 0xffffff;
        i3 = B[i2];
        int j3 = C[i2];
        k3 = 0;
        l3 = 0;
        i4 = l2 << 16;
        j4 = (i3 << 16) / k1;
        k4 = (j3 << 16) / l1;
        l4 = -(l2 << 16) / l1;
        if(d[i2])
        {
            int i5 = F[i2];
            int k5 = G[i2];
            j4 = (i5 << 16) / k1;
            k4 = (k5 << 16) / l1;
            int j6 = D[i2];
            int k6 = E[i2];
            if(flag)
                j6 = i5 - B[i2] - j6;
            i1 += ((j6 * k1 + i5) - 1) / i5;
            int l6 = ((k6 * l1 + k5) - 1) / k5;
            j1 += l6;
            i4 += l6 * l4;
            if((j6 * k1) % i5 != 0)
                k3 = (i5 - (j6 * k1) % i5 << 16) / k1;
            if((k6 * l1) % k5 != 0)
                l3 = (k5 - (k6 * l1) % k5 << 16) / l1;
            k1 = ((((B[i2] << 16) - k3) + j4) - 1) / j4;
            l1 = ((((C[i2] << 16) - l3) + k4) - 1) / k4;
        }
        j5 = j1 * m;
        i4 += i1 << 16;
        if(j1 < r)
        {
            int l5 = r - j1;
            l1 -= l5;
            j1 = r;
            j5 += l5 * m;
            l3 += k4 * l5;
            i4 += l4 * l5;
        }
        if(j1 + l1 >= s)
            l1 -= ((j1 + l1) - s) + 1;
        i6 = j5 / m & 1;
        if(!b)
            i6 = 2;
        if(k2 != 0xffffff)
            break MISSING_BLOCK_LABEL_665;
        if(P[i2] == null)
            break MISSING_BLOCK_LABEL_552;
        if(!flag)
        {
            a(A, P[i2], 0, k3, l3, j5, k1, l1, j4, k4, i3, j2, i4, l4, i6);
            return;
        }
        try
        {
            a(A, P[i2], 0, (B[i2] << 16) - k3 - 1, l3, j5, k1, l1, -j4, k4, i3, j2, i4, l4, i6);
            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[0]);
        }
        break MISSING_BLOCK_LABEL_908;
        if(!flag)
        {
            a(A, g[i2], Q[i2], 0, k3, l3, j5, k1, l1, j4, k4, i3, j2, i4, l4, i6);
            return;
        }
        a(A, g[i2], Q[i2], 0, (B[i2] << 16) - k3 - 1, l3, j5, k1, l1, -j4, k4, i3, j2, i4, l4, i6);
        return;
        if(P[i2] == null)
            break MISSING_BLOCK_LABEL_778;
        if(!flag)
        {
            a(A, P[i2], 0, k3, l3, j5, k1, l1, j4, k4, i3, j2, k2, i4, l4, i6);
            return;
        }
        a(A, P[i2], 0, (B[i2] << 16) - k3 - 1, l3, j5, k1, l1, -j4, k4, i3, j2, k2, i4, l4, i6);
        return;
        if(!flag)
        {
            a(A, g[i2], Q[i2], 0, k3, l3, j5, k1, l1, j4, k4, i3, j2, k2, i4, l4, i6);
            return;
        }
        a(A, g[i2], Q[i2], 0, (B[i2] << 16) - k3 - 1, l3, j5, k1, l1, -j4, k4, i3, j2, k2, i4, l4, i6);
        return;
    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3, 
            int i4)
    {
        int j4 = z;
        int k4 = j3 >> 16 & 0xff;
        int l4 = j3 >> 8 & 0xff;
        int i5 = j3 & 0xff;
        try
        {
            int j5 = j1;
            for(int k5 = -j2; k5 < 0; k5++)
            {
                int l5 = (k1 >> 16) * i3;
                int i6 = k3 >> 16;
                int j6 = i2;
                if(i6 < t)
                {
                    int k6 = t - i6;
                    j6 -= k6;
                    i6 = t;
                    j1 += k2 * k6;
                }
                if(i6 + j6 >= u)
                {
                    int l6 = (i6 + j6) - u;
                    j6 -= l6;
                }
                i4 = 1 - i4;
                if(i4 != 0)
                {
                    for(int i7 = i6; i7 < i6 + j6; i7++)
                    {
                        i1 = ai1[(j1 >> 16) + l5];
                        if(i1 != 0)
                        {
                            int j7 = i1 >> 16 & 0xff;
                            int k7 = i1 >> 8 & 0xff;
                            int l7 = i1 & 0xff;
                            if(j7 == k7 && k7 == l7)
                                ai[i7 + l1] = ((j7 * k4 >> 8) << 16) + ((k7 * l4 >> 8) << 8) + (l7 * i5 >> 8);
                            else
                                ai[i7 + l1] = i1;
                        }
                        j1 += k2;
                    }

                }
                k1 += l2;
                j1 = j5;
                l1 += m;
                k3 += l3;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[1]);
        }
    }

    private void a(int ai[], int ai1[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2, int l2, int i3, int j3, int k3, int l3, 
            int i4, int j4)
    {
        int k4 = z;
        int l4 = j3 >> 16 & 0xff;
        int i5 = j3 >> 8 & 0xff;
        int j5 = j3 & 0xff;
        int k5 = k3 >> 16 & 0xff;
        int l5 = k3 >> 8 & 0xff;
        int i6 = k3 & 0xff;
        try
        {
            int j6 = j1;
            for(int k6 = -j2; k6 < 0; k6++)
            {
                int l6 = (k1 >> 16) * i3;
                int i7 = l3 >> 16;
                int j7 = i2;
                if(i7 < t)
                {
                    int k7 = t - i7;
                    j7 -= k7;
                    i7 = t;
                    j1 += k2 * k7;
                }
                if(i7 + j7 >= u)
                {
                    int l7 = (i7 + j7) - u;
                    j7 -= l7;
                }
                j4 = 1 - j4;
                if(j4 != 0)
                {
                    for(int i8 = i7; i8 < i7 + j7; i8++)
                    {
                        i1 = ai1[(j1 >> 16) + l6];
                        if(i1 != 0)
                        {
                            int j8 = i1 >> 16 & 0xff;
                            int k8 = i1 >> 8 & 0xff;
                            int l8 = i1 & 0xff;
                            if(j8 == k8 && k8 == l8)
                                ai[i8 + l1] = ((j8 * l4 >> 8) << 16) + ((k8 * i5 >> 8) << 8) + (l8 * j5 >> 8);
                            else
                            if(j8 == 255 && k8 == l8)
                                ai[i8 + l1] = ((j8 * k5 >> 8) << 16) + ((k8 * l5 >> 8) << 8) + (l8 * i6 >> 8);
                            else
                                ai[i8 + l1] = i1;
                        }
                        j1 += k2;
                    }

                }
                k1 += l2;
                j1 = j6;
                l1 += m;
                l3 += i4;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[1]);
        }
    }

    private void a(int ai[], byte abyte0[], int ai1[], int i1, int j1, int k1, int l1, 
            int i2, int j2, int k2, int l2, int i3, int j3, int k3, 
            int l3, int i4)
    {
        int j4 = z;
        int k4 = j3 >> 16 & 0xff;
        int l4 = j3 >> 8 & 0xff;
        int i5 = j3 & 0xff;
        try
        {
            int j5 = j1;
            for(int k5 = -j2; k5 < 0; k5++)
            {
                int l5 = (k1 >> 16) * i3;
                int i6 = k3 >> 16;
                int j6 = i2;
                if(i6 < t)
                {
                    int k6 = t - i6;
                    j6 -= k6;
                    i6 = t;
                    j1 += k2 * k6;
                }
                if(i6 + j6 >= u)
                {
                    int l6 = (i6 + j6) - u;
                    j6 -= l6;
                }
                i4 = 1 - i4;
                if(i4 != 0)
                {
                    for(int i7 = i6; i7 < i6 + j6; i7++)
                    {
                        i1 = abyte0[(j1 >> 16) + l5] & 0xff;
                        if(i1 != 0)
                        {
                            i1 = ai1[i1];
                            int j7 = i1 >> 16 & 0xff;
                            int k7 = i1 >> 8 & 0xff;
                            int l7 = i1 & 0xff;
                            if(j7 == k7 && k7 == l7)
                                ai[i7 + l1] = ((j7 * k4 >> 8) << 16) + ((k7 * l4 >> 8) << 8) + (l7 * i5 >> 8);
                            else
                                ai[i7 + l1] = i1;
                        }
                        j1 += k2;
                    }

                }
                k1 += l2;
                j1 = j5;
                l1 += m;
                k3 += l3;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[1]);
        }
    }

    private void a(int ai[], byte abyte0[], int ai1[], int i1, int j1, int k1, int l1, 
            int i2, int j2, int k2, int l2, int i3, int j3, int k3, 
            int l3, int i4, int j4)
    {
        int k4 = z;
        int l4 = j3 >> 16 & 0xff;
        int i5 = j3 >> 8 & 0xff;
        int j5 = j3 & 0xff;
        int k5 = k3 >> 16 & 0xff;
        int l5 = k3 >> 8 & 0xff;
        int i6 = k3 & 0xff;
        try
        {
            int j6 = j1;
            for(int k6 = -j2; k6 < 0; k6++)
            {
                int l6 = (k1 >> 16) * i3;
                int i7 = l3 >> 16;
                int j7 = i2;
                if(i7 < t)
                {
                    int k7 = t - i7;
                    j7 -= k7;
                    i7 = t;
                    j1 += k2 * k7;
                }
                if(i7 + j7 >= u)
                {
                    int l7 = (i7 + j7) - u;
                    j7 -= l7;
                }
                j4 = 1 - j4;
                if(j4 != 0)
                {
                    for(int i8 = i7; i8 < i7 + j7; i8++)
                    {
                        i1 = abyte0[(j1 >> 16) + l6] & 0xff;
                        if(i1 != 0)
                        {
                            i1 = ai1[i1];
                            int j8 = i1 >> 16 & 0xff;
                            int k8 = i1 >> 8 & 0xff;
                            int l8 = i1 & 0xff;
                            if(j8 == k8 && k8 == l8)
                                ai[i8 + l1] = ((j8 * l4 >> 8) << 16) + ((k8 * i5 >> 8) << 8) + (l8 * j5 >> 8);
                            else
                            if(j8 == 255 && k8 == l8)
                                ai[i8 + l1] = ((j8 * k5 >> 8) << 16) + ((k8 * l5 >> 8) << 8) + (l8 * i6 >> 8);
                            else
                                ai[i8 + l1] = i1;
                        }
                        j1 += k2;
                    }

                }
                k1 += l2;
                j1 = j6;
                l1 += m;
                l3 += i4;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[1]);
        }
    }

    public static void a(String s1, int i1, a a1)
    {
        int j1 = z;
        boolean flag = false;
        boolean flag1 = false;
        s1 = s1.toLowerCase();
        if(s1.startsWith(S[7]))
            s1 = s1.substring(9);
        if(s1.startsWith("h"))
            s1 = s1.substring(1);
        if(s1.startsWith("f"))
        {
            s1 = s1.substring(1);
            flag = true;
        }
        if(s1.startsWith("d"))
        {
            s1 = s1.substring(1);
            flag1 = true;
        }
        if(s1.endsWith(S[6]))
            s1 = s1.substring(0, s1.length() - 3);
        int k1 = 0;
        if(s1.endsWith("b"))
        {
            k1 = 1;
            s1 = s1.substring(0, s1.length() - 1);
        }
        if(s1.endsWith("p"))
            s1 = s1.substring(0, s1.length() - 1);
        int l1 = Integer.parseInt(s1);
        Font font = new Font(S[9], k1, l1);
        FontMetrics fontmetrics = a1.getFontMetrics(font);
        String s2 = S[8];
        y = 855;
        for(int i2 = 0; i2 < 95; i2++)
            a(font, fontmetrics, s2.charAt(i2), i2, a1, i1, flag1);

        h[i1] = new byte[y];
        for(int j2 = 0; j2 < y; j2++)
            h[i1][j2] = f[j2];

        if(k1 == 1 && e[i1])
        {
            e[i1] = false;
            a("f" + l1 + "p", i1, a1);
        }
        if(flag && !e[i1])
        {
            e[i1] = false;
            a("d" + l1 + "p", i1, a1);
        }
    }

    public static void a(Font font, FontMetrics fontmetrics, char c1, int i1, a a1, int j1, boolean flag)
    {
        int k1 = z;
        int l1 = fontmetrics.charWidth(c1);
        int i2 = l1;
        if(flag)
            try
            {
                if(c1 == '/')
                    flag = false;
                if(c1 == 'f' || c1 == 't' || c1 == 'w' || c1 == 'v' || c1 == 'k' || c1 == 'x' || c1 == 'y' || c1 == 'A' || c1 == 'V' || c1 == 'W')
                    l1++;
            }
            catch(Exception exception) { }
        int j2 = fontmetrics.getMaxAscent();
        int k2 = fontmetrics.getMaxAscent() + fontmetrics.getMaxDescent();
        int l2 = fontmetrics.getHeight();
        Image image = a1.createImage(l1, k2);
        Graphics g1 = image.getGraphics();
        g1.setColor(Color.black);
        g1.fillRect(0, 0, l1, k2);
        g1.setColor(Color.white);
        g1.setFont(font);
        g1.drawString(String.valueOf(c1), 0, j2);
        if(flag)
            g1.drawString(String.valueOf(c1), 1, j2);
        int ai[] = new int[l1 * k2];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l1, k2, ai, 0, l1);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
        image.flush();
        image = null;
        int i3 = 0;
        int j3 = 0;
        int k3 = l1;
        int l3 = k2;
label0:
        for(int i4 = 0; i4 < k2; i4++)
        {
            int j5 = 0;
            do
            {
                if(j5 >= l1)
                    continue label0;
                int k6 = ai[j5 + i4 * l1];
                if((k6 & 0xffffff) != 0)
                {
                    j3 = i4;
                    break label0;
                }
                j5++;
            } while(true);
        }

label1:
        for(int j4 = 0; j4 < l1; j4++)
        {
            int k5 = 0;
            do
            {
                if(k5 >= k2)
                    continue label1;
                int l6 = ai[j4 + k5 * l1];
                if((l6 & 0xffffff) != 0)
                {
                    i3 = j4;
                    break label1;
                }
                k5++;
            } while(true);
        }

label2:
        for(int k4 = k2 - 1; k4 >= 0; k4--)
        {
            int l5 = 0;
            do
            {
                if(l5 >= l1)
                    continue label2;
                int i7 = ai[l5 + k4 * l1];
                if((i7 & 0xffffff) != 0)
                {
                    l3 = k4 + 1;
                    break label2;
                }
                l5++;
            } while(true);
        }

label3:
        for(int l4 = l1 - 1; l4 >= 0; l4--)
        {
            int i6 = 0;
            do
            {
                if(i6 >= k2)
                    continue label3;
                int j7 = ai[l4 + i6 * l1];
                if((j7 & 0xffffff) != 0)
                {
                    k3 = l4 + 1;
                    break label3;
                }
                i6++;
            } while(true);
        }

        f[i1 * 9] = (byte)(y / 16384);
        f[i1 * 9 + 1] = (byte)(y / 128 & 0x7f);
        f[i1 * 9 + 2] = (byte)(y & 0x7f);
        f[i1 * 9 + 3] = (byte)(k3 - i3);
        f[i1 * 9 + 4] = (byte)(l3 - j3);
        f[i1 * 9 + 5] = (byte)i3;
        f[i1 * 9 + 6] = (byte)(j2 - j3);
        f[i1 * 9 + 7] = (byte)i2;
        f[i1 * 9 + 8] = (byte)l2;
        for(int i5 = j3; i5 < l3; i5++)
        {
            for(int j6 = i3; j6 < k3; j6++)
            {
                int k7 = ai[j6 + i5 * l1] & 0xff;
                if(k7 > 30 && k7 < 230)
                    e[j1] = true;
                f[y++] = (byte)k7;
            }

        }

    }

    public void a(String s1, int i1, int j1, int k1, int l1)
    {
        c(s1, i1 - a(s1, k1), j1, k1, l1);
    }

    public void b(String s1, int i1, int j1, int k1, int l1)
    {
        c(s1, i1 - a(s1, k1) / 2, j1, k1, l1);
    }

    public void a(String s1, int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = z;
        try
        {
            int k2 = 0;
            byte abyte0[] = h[k1];
            int l2 = 0;
            int i3 = 0;
            for(int j3 = 0; j3 < s1.length(); j3++)
            {
                if(s1.charAt(j3) == '@' && j3 + 4 < s1.length() && s1.charAt(j3 + 4) == '@')
                    j3 += 4;
                else
                if(s1.charAt(j3) == '~' && j3 + 4 < s1.length() && s1.charAt(j3 + 4) == '~')
                    j3 += 4;
                else
                    k2 += abyte0[H[s1.charAt(j3)] + 7];
                if(s1.charAt(j3) == ' ')
                    i3 = j3;
                if(s1.charAt(j3) == '%')
                {
                    i3 = j3;
                    k2 = 1000;
                }
                if(k2 <= i2)
                    continue;
                if(i3 <= l2)
                    i3 = j3;
                b(s1.substring(l2, i3), i1, j1, k1, l1);
                k2 = 0;
                l2 = j3 = i3 + 1;
                j1 += c(k1);
            }

            if(k2 > 0)
            {
                b(s1.substring(l2), i1, j1, k1, l1);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println(S[5] + exception);
            exception.printStackTrace();
        }
    }

    public void c(String s1, int i1, int j1, int k1, int l1)
    {
        int i2 = z;
        try
        {
            byte abyte0[] = h[k1];
            for(int j2 = 0; j2 < s1.length(); j2++)
            {
                if(s1.charAt(j2) == '@' && j2 + 4 < s1.length() && s1.charAt(j2 + 4) == '@')
                {
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[18]))
                        l1 = 0xff0000;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[11]))
                        l1 = 0xff9040;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[19]))
                        l1 = 0xffff00;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[16]))
                        l1 = 65280;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[29]))
                        l1 = 255;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[23]))
                        l1 = 65535;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[17]))
                        l1 = 0xff00ff;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[27]))
                        l1 = 0xffffff;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[26]))
                        l1 = 0;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[22]))
                        l1 = 0xc00000;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[15]))
                        l1 = 0xff9040;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[21]))
                        l1 = (int)(Math.random() * 16777215D);
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[20]))
                        l1 = 0xffb000;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[13]))
                        l1 = 0xff7000;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[12]))
                        l1 = 0xff3000;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[25]))
                        l1 = 0xc0ff00;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[14]))
                        l1 = 0x80ff00;
                    else
                    if(s1.substring(j2 + 1, j2 + 4).equalsIgnoreCase(S[24]))
                        l1 = 0x40ff00;
                    j2 += 4;
                    continue;
                }
                if(s1.charAt(j2) == '~' && j2 + 4 < s1.length() && s1.charAt(j2 + 4) == '~')
                {
                    char c1 = s1.charAt(j2 + 1);
                    char c2 = s1.charAt(j2 + 2);
                    char c3 = s1.charAt(j2 + 3);
                    if(c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9')
                        i1 = Integer.parseInt(s1.substring(j2 + 1, j2 + 4));
                    j2 += 4;
                    continue;
                }
                int k2 = H[s1.charAt(j2)];
                if(c && !e[k1] && l1 != 0)
                    a(k2, i1 + 1, j1, 0, abyte0, e[k1]);
                if(c && !e[k1] && l1 != 0)
                    a(k2, i1, j1 + 1, 0, abyte0, e[k1]);
                a(k2, i1, j1, l1, abyte0, e[k1]);
                i1 += abyte0[k2 + 7];
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[28] + exception);
            exception.printStackTrace();
            return;
        }
    }

    private void a(int i1, int j1, int k1, int l1, byte abyte0[], boolean flag)
    {
        int i2 = j1 + abyte0[i1 + 5];
        int j2 = k1 - abyte0[i1 + 6];
        int k2 = abyte0[i1 + 3];
        int l2 = abyte0[i1 + 4];
        int i3 = abyte0[i1] * 16384 + abyte0[i1 + 1] * 128 + abyte0[i1 + 2];
        int j3 = i2 + j2 * m;
        int k3 = m - k2;
        int l3 = 0;
        if(j2 < r)
        {
            int i4 = r - j2;
            l2 -= i4;
            j2 = r;
            i3 += i4 * k2;
            j3 += i4 * m;
        }
        if(j2 + l2 >= s)
            l2 -= ((j2 + l2) - s) + 1;
        if(i2 < t)
        {
            int j4 = t - i2;
            k2 -= j4;
            i2 = t;
            i3 += j4;
            j3 += j4;
            l3 += j4;
            k3 += j4;
        }
        if(i2 + k2 >= u)
        {
            int k4 = ((i2 + k2) - u) + 1;
            k2 -= k4;
            l3 += k4;
            k3 += k4;
        }
        if(k2 > 0 && l2 > 0)
        {
            if(flag)
            {
                b(A, abyte0, l1, i3, j3, k2, l2, k3, l3);
                return;
            }
            a(A, abyte0, l1, i3, j3, k2, l2, k3, l3);
        }
    }

    private void a(int ai[], byte abyte0[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2)
    {
        int l2 = z;
        try
        {
            int i3 = -(l1 >> 2);
            l1 = -(l1 & 3);
            for(int j3 = -i2; j3 < 0; j3++)
            {
                for(int k3 = i3; k3 < 0; k3++)
                {
                    if(abyte0[j1++] != 0)
                        ai[k1++] = i1;
                    else
                        k1++;
                    if(abyte0[j1++] != 0)
                        ai[k1++] = i1;
                    else
                        k1++;
                    if(abyte0[j1++] != 0)
                        ai[k1++] = i1;
                    else
                        k1++;
                    if(abyte0[j1++] != 0)
                        ai[k1++] = i1;
                    else
                        k1++;
                }

                for(int l3 = l1; l3 < 0; l3++)
                    if(abyte0[j1++] != 0)
                        ai[k1++] = i1;
                    else
                        k1++;

                k1 += j2;
                j1 += k2;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println(S[4] + exception);
            exception.printStackTrace();
            return;
        }
    }

    private void b(int ai[], byte abyte0[], int i1, int j1, int k1, int l1, int i2, 
            int j2, int k2)
    {
        int l2 = z;
        for(int i3 = -i2; i3 < 0; i3++)
        {
            for(int j3 = -l1; j3 < 0; j3++)
            {
                int k3 = abyte0[j1++] & 0xff;
                if(k3 > 30)
                {
                    if(k3 >= 230)
                    {
                        ai[k1++] = i1;
                    } else
                    {
                        int l3 = ai[k1];
                        ai[k1++] = ((i1 & 0xff00ff) * k3 + (l3 & 0xff00ff) * (256 - k3) & 0xff00ff00) + ((i1 & 0xff00) * k3 + (l3 & 0xff00) * (256 - k3) & 0xff0000) >> 8;
                    }
                } else
                {
                    k1++;
                }
            }

            k1 += j2;
            j1 += k2;
        }

    }

    public int c(int i1)
    {
        if(i1 == 0)
            return 12;
        if(i1 == 1)
            return 14;
        if(i1 == 2)
            return 14;
        if(i1 == 3)
            return 15;
        if(i1 == 4)
            return 15;
        if(i1 == 5)
            return 19;
        if(i1 == 6)
            return 24;
        if(i1 == 7)
            return 29;
        else
            return d(i1);
    }

    public int d(int i1)
    {
        if(i1 == 0)
            return h[i1][8] - 2;
        else
            return h[i1][8] - 1;
    }

    public int a(String s1, int i1)
    {
        int j1 = z;
        int k1 = 0;
        byte abyte0[] = h[i1];
        for(int l1 = 0; l1 < s1.length(); l1++)
        {
            if(s1.charAt(l1) == '@' && l1 + 4 < s1.length() && s1.charAt(l1 + 4) == '@')
            {
                l1 += 4;
                continue;
            }
            if(s1.charAt(l1) == '~' && l1 + 4 < s1.length() && s1.charAt(l1 + 4) == '~')
                l1 += 4;
            else
                k1 += abyte0[H[s1.charAt(l1)] + 7];
        }

        return k1;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        if(l == imageconsumer)
            l = null;
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
        System.out.println(S[10]);
    }

    public void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d[];
    private static boolean e[];
    private static byte f[];
    public byte g[][];
    static byte h[][];
    ColorModel i;
    private Component j;
    public Image k;
    ImageConsumer l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    private int r;
    private int s;
    private int t;
    private int u;
    public static int v;
    public static int w;
    public static int x;
    private static int y;
    public static int z;
    public int A[];
    public int B[];
    public int C[];
    public int D[];
    public int E[];
    public int F[];
    public int G[];
    static int H[];
    int I[];
    int J[];
    int K[];
    int L[];
    int M[];
    int N[];
    int O[];
    public int P[][];
    public int Q[][];
    public static boolean R;
    private static String S[];

    static 
    {
        String as[];
        as = new String[30];
        as[0] = "\bBenQMYy!P\035B~uFMS{hS\035Yyf\003\037_buJ\003U";
        as[1] = "\bBenQMYy!W\037QyrS\fBroWMCgsJ\031U7qO\002D7sL\030D~oF";
        as[2] = "\bBenQMYy!W\037Qy^P\016Q{d";
        as[3] = "\bBenQMYy!S\001_c^P\016Q{d";
        as[4] = "\035\\xuO\bDcdQW\020";
        as[5] = "\016UyuQ\b@vsBW\020";
        as[6] = "CZq";
        as[7] = "\005U{wF\031Yt`";
        as[8] = ",rTEf+w_Hi&|ZOl=aERw8f@Yz7QubG\bVpiJ\007[{lM\002@fsP\031Eav[\024J'0\021^\004\"7\024U\t6#\200I\025I'\tE\031:^\036Fkl\\^V\n0A\000\023\034+/\035B\017K}\003";
        as[9] = "%U{wF\031Yt`";
        as[10] = "9t[S";
        as[11] = "\001Br";
        as[12] = "\002B$";
        as[13] = "\002B%";
        as[14] = "\nB%";
        as[15] = "\002Bv";
        as[16] = "\nBr";
        as[17] = "\000Qp";
        as[18] = "\037Us";
        as[19] = "\024U{";
        as[20] = "\002B&";
        as[21] = "\037Qy";
        as[22] = "\tBr";
        as[23] = "\016Iv";
        as[24] = "\nB$";
        as[25] = "\nB&";
        as[26] = "\017\\v";
        as[27] = "\032X~";
        as[28] = "\tBvvP\031B~oDW\020";
        as[29] = "\017\\b";
        S = as;
        break MISSING_BLOCK_LABEL_391;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int k1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 369;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        k1;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(k1 % 5)
        {
        case 0: // '\0'
            byte0 = 0x6d;
            break;

        case 1: // '\001'
            byte0 = 48;
            break;

        case 2: // '\002'
            byte0 = 23;
            break;

        case 3: // '\003'
            byte0 = 1;
            break;

        default:
            byte0 = 35;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        k1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 369;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        k1;
        JVM INSTR icmpgt 291;
           goto _L5 _L1
_L5:
        JVM INSTR new #388 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 3;
        e = new boolean[12];
        f = new byte[0x186a0];
        h = new byte[50][];
        String s1 = S[8];
        H = new int[256];
        for(int i1 = 0; i1 < 256; i1++)
        {
            int j1 = s1.indexOf(i1);
            if(j1 == -1)
                j1 = 74;
            H[i1] = j1 * 9;
        }

    }
}
