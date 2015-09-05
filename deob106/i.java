// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;

public class i
    implements ImageProducer, ImageObserver
{

    public i(int j, int k, int l, Component component)
    {
        rk = true;
        wk = false;
        al = false;
        fk = component;
        tk = k;
        vk = j;
        ak = xj = j;
        bk = yj = k;
        zj = j * k;
        dk = new int[j * k];
        hk = new int[l][];
        qk = new boolean[l];
        ik = new byte[l][];
        jk = new int[l][];
        kk = new int[l];
        lk = new int[l];
        ok = new int[l];
        pk = new int[l];
        mk = new int[l];
        nk = new int[l];
        if(j > 1 && k > 1 && component != null)
        {
            ck = new DirectColorModel(32, 0xff0000, 65280, 255);
            int i1 = xj * yj;
            for(int j1 = 0; j1 < i1; j1++)
                dk[j1] = 0;

            gk = component.createImage(this);
            bg();
            component.prepareImage(gk, component);
            bg();
            component.prepareImage(gk, component);
            bg();
            component.prepareImage(gk, component);
        }
    }

    public synchronized void dh(int j, int k)
    {
        if(xj > ak)
            xj = ak;
        if(yj > bk)
            yj = bk;
        xj = j;
        yj = k;
        zj = j * k;
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        ek = imageconsumer;
        imageconsumer.setDimensions(xj, yj);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(ck);
        imageconsumer.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return ek == imageconsumer;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        if(ek == imageconsumer)
            ek = null;
    }

    public void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
        System.out.println("TDLR");
    }

    public synchronized void bg()
    {
        if(ek == null)
        {
            return;
        } else
        {
            ek.setPixels(0, 0, xj, yj, ck, dk, 0, xj);
            ek.imageComplete(2);
            return;
        }
    }

    public void yf(int j, int k, int l, int i1)
    {
        if(j < 0)
            j = 0;
        if(k < 0)
            k = 0;
        if(l > xj)
            l = xj;
        if(i1 > yj)
            i1 = yj;
        uk = j;
        sk = k;
        vk = l;
        tk = i1;
    }

    public void zf()
    {
        uk = 0;
        sk = 0;
        vk = xj;
        tk = yj;
    }

    public void qf(Graphics g, int j, int k)
    {
        bg();
        g.drawImage(gk, j, k, this);
    }

    public void sf()
    {
        int j = xj * yj;
        if(!wk)
        {
            for(int k = 0; k < j; k++)
                dk[k] = 0;

            return;
        }
        int l = 0;
        for(int i1 = -yj; i1 < 0; i1 += 2)
        {
            for(int j1 = -xj; j1 < 0; j1++)
                dk[l++] = 0;

            l += xj;
        }

    }

    public void fg(int j, int k, int l, int i1, int j1)
    {
        int k1 = 256 - j1;
        int l1 = (i1 >> 16 & 0xff) * j1;
        int i2 = (i1 >> 8 & 0xff) * j1;
        int j2 = (i1 & 0xff) * j1;
        int j3 = k - l;
        if(j3 < 0)
            j3 = 0;
        int k3 = k + l;
        if(k3 >= yj)
            k3 = yj - 1;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            if((j3 & 1) != 0)
                j3++;
        }
        for(int l3 = j3; l3 <= k3; l3 += byte0)
        {
            int i4 = l3 - k;
            int j4 = (int)Math.sqrt(l * l - i4 * i4);
            int k4 = j - j4;
            if(k4 < 0)
                k4 = 0;
            int l4 = j + j4;
            if(l4 >= xj)
                l4 = xj - 1;
            int i5 = k4 + l3 * xj;
            for(int j5 = k4; j5 <= l4; j5++)
            {
                int k2 = (dk[i5] >> 16 & 0xff) * k1;
                int l2 = (dk[i5] >> 8 & 0xff) * k1;
                int i3 = (dk[i5] & 0xff) * k1;
                int k5 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
                dk[i5++] = k5;
            }

        }

    }

    public void ag(int j, int k, int l, int i1, int j1, int k1)
    {
        if(j < uk)
        {
            l -= uk - j;
            j = uk;
        }
        if(k < sk)
        {
            i1 -= sk - k;
            k = sk;
        }
        if(j + l > vk)
            l = vk - j;
        if(k + i1 > tk)
            i1 = tk - k;
        int l1 = 256 - k1;
        int i2 = (j1 >> 16 & 0xff) * k1;
        int j2 = (j1 >> 8 & 0xff) * k1;
        int k2 = (j1 & 0xff) * k1;
        int k3 = xj - l;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            k3 += xj;
            if((k & 1) != 0)
            {
                k++;
                i1--;
            }
        }
        int l3 = j + k * xj;
        for(int i4 = 0; i4 < i1; i4 += byte0)
        {
            for(int j4 = -l; j4 < 0; j4++)
            {
                int l2 = (dk[l3] >> 16 & 0xff) * l1;
                int i3 = (dk[l3] >> 8 & 0xff) * l1;
                int j3 = (dk[l3] & 0xff) * l1;
                int k4 = ((i2 + l2 >> 8) << 16) + ((j2 + i3 >> 8) << 8) + (k2 + j3 >> 8);
                dk[l3++] = k4;
            }

            l3 += k3;
        }

    }

    public void mg(int j, int k, int l, int i1, int j1, int k1)
    {
        if(j < uk)
        {
            l -= uk - j;
            j = uk;
        }
        if(j + l > vk)
            l = vk - j;
        int l1 = k1 >> 16 & 0xff;
        int i2 = k1 >> 8 & 0xff;
        int j2 = k1 & 0xff;
        int k2 = j1 >> 16 & 0xff;
        int l2 = j1 >> 8 & 0xff;
        int i3 = j1 & 0xff;
        int j3 = xj - l;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            j3 += xj;
            if((k & 1) != 0)
            {
                k++;
                i1--;
            }
        }
        int k3 = j + k * xj;
        for(int l3 = 0; l3 < i1; l3 += byte0)
            if(l3 + k >= sk && l3 + k < tk)
            {
                int i4 = ((l1 * l3 + k2 * (i1 - l3)) / i1 << 16) + ((i2 * l3 + l2 * (i1 - l3)) / i1 << 8) + (j2 * l3 + i3 * (i1 - l3)) / i1;
                for(int j4 = -l; j4 < 0; j4++)
                    dk[k3++] = i4;

                k3 += j3;
            } else
            {
                k3 += xj;
            }

    }

    public void eg(int j, int k, int l, int i1, int j1)
    {
        if(j < uk)
        {
            l -= uk - j;
            j = uk;
        }
        if(k < sk)
        {
            i1 -= sk - k;
            k = sk;
        }
        if(j + l > vk)
            l = vk - j;
        if(k + i1 > tk)
            i1 = tk - k;
        int k1 = xj - l;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            k1 += xj;
            if((k & 1) != 0)
            {
                k++;
                i1--;
            }
        }
        int l1 = j + k * xj;
        for(int i2 = -i1; i2 < 0; i2 += byte0)
        {
            for(int j2 = -l; j2 < 0; j2++)
                dk[l1++] = j1;

            l1 += k1;
        }

    }

    public void xf(int j, int k, int l, int i1, int j1)
    {
        xg(j, k, l, j1);
        xg(j, (k + i1) - 1, l, j1);
        ch(j, k, i1, j1);
        ch((j + l) - 1, k, i1, j1);
    }

    public void xg(int j, int k, int l, int i1)
    {
        if(k < sk || k >= tk)
            return;
        if(j < uk)
        {
            l -= uk - j;
            j = uk;
        }
        if(j + l > vk)
            l = vk - j;
        int j1 = j + k * xj;
        for(int k1 = 0; k1 < l; k1++)
            dk[j1 + k1] = i1;

    }

    public void ch(int j, int k, int l, int i1)
    {
        if(j < uk || j >= vk)
            return;
        if(k < sk)
        {
            l -= sk - k;
            k = sk;
        }
        if(k + l > vk)
            l = tk - k;
        int j1 = j + k * xj;
        for(int k1 = 0; k1 < l; k1++)
            dk[j1 + k1 * xj] = i1;

    }

    public void rg(int j, int k, int l)
    {
        if(j < uk || k < sk || j >= vk || k >= tk)
        {
            return;
        } else
        {
            dk[j + k * xj] = l;
            return;
        }
    }

    public void mf()
    {
        int l = xj * yj;
        for(int k = 0; k < l; k++)
        {
            int j = dk[k] & 0xffffff;
            dk[k] = (j >>> 1 & 0x7f7f7f) + (j >>> 2 & 0x3f3f3f) + (j >>> 3 & 0x1f1f1f) + (j >>> 4 & 0xf0f0f);
        }

    }

    public void yg(int j, int k, int l, int i1, int j1, int k1)
    {
        for(int l1 = l; l1 < l + j1; l1++)
        {
            for(int i2 = i1; i2 < i1 + k1; i2++)
            {
                int j2 = 0;
                int k2 = 0;
                int l2 = 0;
                int i3 = 0;
                for(int j3 = l1 - j; j3 <= l1 + j; j3++)
                    if(j3 >= 0 && j3 < xj)
                    {
                        for(int k3 = i2 - k; k3 <= i2 + k; k3++)
                            if(k3 >= 0 && k3 < yj)
                            {
                                int l3 = dk[j3 + xj * k3];
                                j2 += l3 >> 16 & 0xff;
                                k2 += l3 >> 8 & 0xff;
                                l2 += l3 & 0xff;
                                i3++;
                            }

                    }

                dk[l1 + xj * i2] = (j2 / i3 << 16) + (k2 / i3 << 8) + l2 / i3;
            }

        }

    }

    public static int qg(int j, int k, int l)
    {
        return (j << 16) + (k << 8) + l;
    }

    public void og()
    {
        for(int j = 0; j < hk.length; j++)
        {
            hk[j] = null;
            kk[j] = 0;
            lk[j] = 0;
            ik[j] = null;
            jk[j] = null;
        }

    }

    public void pg(byte abyte0[], int j, int k, boolean flag, boolean flag1)
    {
        ng(abyte0, j, k, flag, 1, 1, flag1);
    }

    public void ug(byte abyte0[], int j, int k, boolean flag, int l, boolean flag1)
    {
        ng(abyte0, j, k, flag, l, 1, flag1);
    }

    public void ng(byte abyte0[], int j, int k, boolean flag, int l, int i1, boolean flag1)
    {
        int j1 = (abyte0[13 + j] & 0xff) * 256 + (abyte0[12 + j] & 0xff);
        int k1 = (abyte0[15 + j] & 0xff) * 256 + (abyte0[14 + j] & 0xff);
        int l1 = -1;
        int ai[] = new int[256];
        for(int i2 = 0; i2 < 256; i2++)
        {
            ai[i2] = 0xff000000 + ((abyte0[j + 20 + i2 * 3] & 0xff) << 16) + ((abyte0[j + 19 + i2 * 3] & 0xff) << 8) + (abyte0[j + 18 + i2 * 3] & 0xff);
            if(ai[i2] == -65281)
                l1 = i2;
        }

        if(l1 == -1)
            flag = false;
        if(flag1 && flag)
            ai[l1] = ai[0];
        int j2 = j1 / l;
        int k2 = k1 / i1;
        int ai1[] = new int[j2 * k2];
        for(int l2 = 0; l2 < i1; l2++)
        {
            for(int i3 = 0; i3 < l; i3++)
            {
                int j3 = 0;
                for(int k3 = k2 * l2; k3 < k2 * (l2 + 1); k3++)
                {
                    for(int l3 = j2 * i3; l3 < j2 * (i3 + 1); l3++)
                        if(flag1)
                            ai1[j3++] = abyte0[j + 786 + l3 + (k1 - k3 - 1) * j1] & 0xff;
                        else
                            ai1[j3++] = ai[abyte0[j + 786 + l3 + (k1 - k3 - 1) * j1] & 0xff];

                }

                if(flag1)
                    of(ai1, j2, k2, k++, flag, ai, l1);
                else
                    of(ai1, j2, k2, k++, flag, null, -65281);
            }

        }

    }

    private void of(int ai[], int j, int k, int l, boolean flag, int ai1[], int i1)
    {
        int j1 = 0;
        int k1 = 0;
        int l1 = j;
        int i2 = k;
        if(flag && rk)
        {
label0:
            for(int j2 = 0; j2 < k; j2++)
            {
                for(int i3 = 0; i3 < j; i3++)
                {
                    int i4 = ai[i3 + j2 * j];
                    if(i4 == i1)
                        continue;
                    k1 = j2;
                    break label0;
                }

            }

label1:
            for(int j3 = 0; j3 < j; j3++)
            {
                for(int j4 = 0; j4 < k; j4++)
                {
                    int j5 = ai[j3 + j4 * j];
                    if(j5 == i1)
                        continue;
                    j1 = j3;
                    break label1;
                }

            }

label2:
            for(int k4 = k - 1; k4 >= 0; k4--)
            {
                for(int k5 = 0; k5 < j; k5++)
                {
                    int k6 = ai[k5 + k4 * j];
                    if(k6 == i1)
                        continue;
                    i2 = k4 + 1;
                    break label2;
                }

            }

label3:
            for(int l5 = j - 1; l5 >= 0; l5--)
            {
                for(int l6 = 0; l6 < k; l6++)
                {
                    int i7 = ai[l5 + l6 * j];
                    if(i7 == i1)
                        continue;
                    l1 = l5 + 1;
                    break label3;
                }

            }

        }
        kk[l] = l1 - j1;
        lk[l] = i2 - k1;
        qk[l] = flag;
        mk[l] = j1;
        nk[l] = k1;
        ok[l] = j;
        pk[l] = k;
        if(ai1 == null)
        {
            hk[l] = new int[(l1 - j1) * (i2 - k1)];
            int k2 = 0;
            for(int k3 = k1; k3 < i2; k3++)
            {
                for(int l4 = j1; l4 < l1; l4++)
                {
                    int i6 = ai[l4 + k3 * j];
                    if(flag)
                    {
                        if(i6 == i1)
                            i6 = 0;
                        if(i6 == 0xff000000)
                            i6 = 0xff010101;
                    }
                    hk[l][k2++] = i6 & 0xffffff;
                }

            }

            return;
        }
        ik[l] = new byte[(l1 - j1) * (i2 - k1)];
        jk[l] = ai1;
        int l2 = 0;
        for(int l3 = k1; l3 < i2; l3++)
        {
            for(int i5 = j1; i5 < l1; i5++)
            {
                int j6 = ai[i5 + l3 * j];
                if(flag)
                    if(j6 == i1)
                        j6 = 0;
                    else
                    if(j6 == 0)
                        j6 = i1;
                ik[l][l2++] = (byte)j6;
            }

        }

    }

    public void bh(int j, int k, int l, int i1, int j1)
    {
        int ai[] = new int[32768];
        int k1 = k + l * xj;
        for(int l1 = l; l1 < l + j1; l1++)
        {
            for(int i2 = k; i2 < k + i1; i2++)
            {
                int j2 = dk[k1++];
                ai[((j2 & 0xf80000) >> 9) + ((j2 & 0xf800) >> 6) + ((j2 & 0xf8) >> 3)]++;
            }

            k1 += xj - i1;
        }

        int ai1[] = new int[256];
        int ai2[] = new int[256];
        for(int k2 = 0; k2 < 32768; k2++)
        {
            int l2 = ai[k2];
            if(l2 > ai2[255])
            {
                for(int j3 = 1; j3 < 256; j3++)
                {
                    if(l2 <= ai2[j3])
                        continue;
                    for(int k3 = 255; k3 > j3; k3--)
                    {
                        ai1[k3] = ai1[k3 - 1];
                        ai2[k3] = ai2[k3 - 1];
                    }

                    ai1[j3] = ((k2 & 0x7c00) << 9) + ((k2 & 0x3e0) << 6) + ((k2 & 0x1f) << 3) + 0x40404;
                    ai2[j3] = l2;
                    break;
                }

            }
            ai[k2] = 0;
        }

        int i3 = i1 * j1;
        k1 = 0;
        byte abyte0[] = new byte[i3];
        for(int l3 = l; l3 < l + j1; l3++)
        {
            for(int i4 = k; i4 < k + i1; i4++)
            {
                int j4 = dk[i4 + l3 * xj];
                int k4 = ((j4 & 0xf80000) >> 9) + ((j4 & 0xf800) >> 6) + ((j4 & 0xf8) >> 3);
                int l4 = ai[k4];
                if(l4 == 0)
                {
                    int i5 = 0x3b9ac9ff;
                    int j5 = j4 >> 16 & 0xff;
                    int k5 = j4 >> 8 & 0xff;
                    int l5 = j4 & 0xff;
                    for(int i6 = 1; i6 < 256; i6++)
                    {
                        int j6 = ai1[i6];
                        int k6 = j6 >> 16 & 0xff;
                        int l6 = j6 >> 8 & 0xff;
                        int i7 = j6 & 0xff;
                        int j7 = (j5 - k6) * (j5 - k6) + (k5 - l6) * (k5 - l6) + (l5 - i7) * (l5 - i7);
                        if(j7 < i5)
                        {
                            i5 = j7;
                            l4 = i6;
                        }
                    }

                    ai[k4] = l4;
                }
                abyte0[k1++] = (byte)l4;
            }

        }

        kk[j] = i1;
        lk[j] = j1;
        qk[j] = false;
        mk[j] = 0;
        nk[j] = 0;
        ok[j] = i1;
        pk[j] = j1;
        ik[j] = abyte0;
        jk[j] = ai1;
        hk[j] = null;
    }

    public void rf(int j, int k, int l, int i1, int j1)
    {
        kk[j] = i1;
        lk[j] = j1;
        qk[j] = false;
        mk[j] = 0;
        nk[j] = 0;
        ok[j] = i1;
        pk[j] = j1;
        int k1 = i1 * j1;
        int l1 = 0;
        hk[j] = new int[k1];
        for(int i2 = k; i2 < k + i1; i2++)
        {
            for(int j2 = l; j2 < l + j1; j2++)
                hk[j][l1++] = dk[i2 + j2 * xj];

        }

    }

    public void eh(int j, int k, int l)
    {
        if(qk[l])
        {
            j += mk[l];
            k += nk[l];
        }
        int i1 = j + k * xj;
        int j1 = 0;
        int k1 = lk[l];
        int l1 = kk[l];
        int i2 = xj - l1;
        int j2 = 0;
        if(k < sk)
        {
            int k2 = sk - k;
            k1 -= k2;
            k = sk;
            j1 += k2 * l1;
            i1 += k2 * xj;
        }
        if(k + k1 >= tk)
            k1 -= ((k + k1) - tk) + 1;
        if(j < uk)
        {
            int l2 = uk - j;
            l1 -= l2;
            j = uk;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if(j + l1 >= vk)
        {
            int i3 = ((j + l1) - vk) + 1;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(l1 <= 0 || k1 <= 0)
            return;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            i2 += xj;
            j2 += kk[l];
            if((k & 1) != 0)
            {
                i1 += xj;
                k1--;
            }
        }
        if(hk[l] == null)
        {
            ig(dk, ik[l], jk[l], j1, i1, l1, k1, i2, j2, byte0);
            return;
        } else
        {
            nf(dk, hk[l], wj, j1, i1, l1, k1, i2, j2, byte0);
            return;
        }
    }

    public void uf(int j, int k, int l, int i1, int j1)
    {
        try
        {
            int k1 = kk[j1];
            int l1 = lk[j1];
            int i2 = 0;
            int j2 = 0;
            int k2 = (k1 << 16) / l;
            int l2 = (l1 << 16) / i1;
            if(qk[j1])
            {
                int i3 = ok[j1];
                int k3 = pk[j1];
                k2 = (i3 << 16) / l;
                l2 = (k3 << 16) / i1;
                j += ((mk[j1] * l + i3) - 1) / i3;
                k += ((nk[j1] * i1 + k3) - 1) / k3;
                if((mk[j1] * l) % i3 != 0)
                    i2 = (i3 - (mk[j1] * l) % i3 << 16) / l;
                if((nk[j1] * i1) % k3 != 0)
                    j2 = (k3 - (nk[j1] * i1) % k3 << 16) / i1;
                l = (l * (kk[j1] - (i2 >> 16))) / i3;
                i1 = (i1 * (lk[j1] - (j2 >> 16))) / k3;
            }
            int j3 = j + k * xj;
            int l3 = xj - l;
            if(k < sk)
            {
                int i4 = sk - k;
                i1 -= i4;
                k = 0;
                j3 += i4 * xj;
                j2 += l2 * i4;
            }
            if(k + i1 >= tk)
                i1 -= ((k + i1) - tk) + 1;
            if(j < uk)
            {
                int j4 = uk - j;
                l -= j4;
                j = 0;
                j3 += j4;
                i2 += k2 * j4;
                l3 += j4;
            }
            if(j + l >= vk)
            {
                int k4 = ((j + l) - vk) + 1;
                l -= k4;
                l3 += k4;
            }
            byte byte0 = 1;
            if(wk)
            {
                byte0 = 2;
                l3 += xj;
                l2 += l2;
                if((k & 1) != 0)
                {
                    j3 += xj;
                    i1--;
                }
            }
            wf(dk, hk[j1], wj, i2, j2, j3, l3, l, i1, k2, l2, k1, byte0);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void wg(int j, int k, int l, int i1)
    {
        if(qk[l])
        {
            j += mk[l];
            k += nk[l];
        }
        int j1 = j + k * xj;
        int k1 = 0;
        int l1 = lk[l];
        int i2 = kk[l];
        int j2 = xj - i2;
        int k2 = 0;
        if(k < sk)
        {
            int l2 = sk - k;
            l1 -= l2;
            k = sk;
            k1 += l2 * i2;
            j1 += l2 * xj;
        }
        if(k + l1 >= tk)
            l1 -= ((k + l1) - tk) + 1;
        if(j < uk)
        {
            int i3 = uk - j;
            i2 -= i3;
            j = uk;
            k1 += i3;
            j1 += i3;
            k2 += i3;
            j2 += i3;
        }
        if(j + i2 >= vk)
        {
            int j3 = ((j + i2) - vk) + 1;
            i2 -= j3;
            k2 += j3;
            j2 += j3;
        }
        if(i2 <= 0 || l1 <= 0)
            return;
        byte byte0 = 1;
        if(wk)
        {
            byte0 = 2;
            j2 += xj;
            k2 += kk[l];
            if((k & 1) != 0)
            {
                j1 += xj;
                l1--;
            }
        }
        if(hk[l] == null)
        {
            ih(dk, ik[l], jk[l], k1, j1, i2, l1, j2, k2, byte0, i1);
            return;
        } else
        {
            lg(dk, hk[l], wj, k1, j1, i2, l1, j2, k2, byte0, i1);
            return;
        }
    }

    public void vg(int j, int k, int l, int i1, int j1, int k1)
    {
        try
        {
            int l1 = kk[j1];
            int i2 = lk[j1];
            int j2 = 0;
            int k2 = 0;
            int l2 = (l1 << 16) / l;
            int i3 = (i2 << 16) / i1;
            if(qk[j1])
            {
                int j3 = ok[j1];
                int l3 = pk[j1];
                l2 = (j3 << 16) / l;
                i3 = (l3 << 16) / i1;
                j += ((mk[j1] * l + j3) - 1) / j3;
                k += ((nk[j1] * i1 + l3) - 1) / l3;
                if((mk[j1] * l) % j3 != 0)
                    j2 = (j3 - (mk[j1] * l) % j3 << 16) / l;
                if((nk[j1] * i1) % l3 != 0)
                    k2 = (l3 - (nk[j1] * i1) % l3 << 16) / i1;
                l = (l * (kk[j1] - (j2 >> 16))) / j3;
                i1 = (i1 * (lk[j1] - (k2 >> 16))) / l3;
            }
            int k3 = j + k * xj;
            int i4 = xj - l;
            if(k < sk)
            {
                int j4 = sk - k;
                i1 -= j4;
                k = 0;
                k3 += j4 * xj;
                k2 += i3 * j4;
            }
            if(k + i1 >= tk)
                i1 -= ((k + i1) - tk) + 1;
            if(j < uk)
            {
                int k4 = uk - j;
                l -= k4;
                j = 0;
                k3 += k4;
                j2 += l2 * k4;
                i4 += k4;
            }
            if(j + l >= vk)
            {
                int l4 = ((j + l) - vk) + 1;
                l -= l4;
                i4 += l4;
            }
            byte byte0 = 1;
            if(wk)
            {
                byte0 = 2;
                i4 += xj;
                i3 += i3;
                if((k & 1) != 0)
                {
                    k3 += xj;
                    i1--;
                }
            }
            dg(dk, hk[j1], wj, j2, k2, k3, i4, l, i1, l2, i3, l1, byte0, k1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void sg(int j, int k, int l, int i1, int j1, int k1)
    {
        try
        {
            int l1 = kk[j1];
            int i2 = lk[j1];
            int j2 = 0;
            int k2 = 0;
            int l2 = (l1 << 16) / l;
            int i3 = (i2 << 16) / i1;
            if(qk[j1])
            {
                int j3 = ok[j1];
                int l3 = pk[j1];
                l2 = (j3 << 16) / l;
                i3 = (l3 << 16) / i1;
                j += ((mk[j1] * l + j3) - 1) / j3;
                k += ((nk[j1] * i1 + l3) - 1) / l3;
                if((mk[j1] * l) % j3 != 0)
                    j2 = (j3 - (mk[j1] * l) % j3 << 16) / l;
                if((nk[j1] * i1) % l3 != 0)
                    k2 = (l3 - (nk[j1] * i1) % l3 << 16) / i1;
                l = (l * (kk[j1] - (j2 >> 16))) / j3;
                i1 = (i1 * (lk[j1] - (k2 >> 16))) / l3;
            }
            int k3 = j + k * xj;
            int i4 = xj - l;
            if(k < sk)
            {
                int j4 = sk - k;
                i1 -= j4;
                k = 0;
                k3 += j4 * xj;
                k2 += i3 * j4;
            }
            if(k + i1 >= tk)
                i1 -= ((k + i1) - tk) + 1;
            if(j < uk)
            {
                int k4 = uk - j;
                l -= k4;
                j = 0;
                k3 += k4;
                j2 += l2 * k4;
                i4 += k4;
            }
            if(j + l >= vk)
            {
                int l4 = ((j + l) - vk) + 1;
                l -= l4;
                i4 += l4;
            }
            byte byte0 = 1;
            if(wk)
            {
                byte0 = 2;
                i4 += xj;
                i3 += i3;
                if((k & 1) != 0)
                {
                    k3 += xj;
                    i1--;
                }
            }
            kh(dk, hk[j1], wj, j2, k2, k3, i4, l, i1, l2, i3, l1, byte0, k1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void nf(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2)
    {
        int j2 = -(i1 >> 2);
        i1 = -(i1 & 3);
        for(int k2 = -j1; k2 < 0; k2 += i2)
        {
            for(int l2 = j2; l2 < 0; l2++)
            {
                j = ai1[k++];
                if(j != 0)
                    ai[l++] = j;
                else
                    l++;
                j = ai1[k++];
                if(j != 0)
                    ai[l++] = j;
                else
                    l++;
                j = ai1[k++];
                if(j != 0)
                    ai[l++] = j;
                else
                    l++;
                j = ai1[k++];
                if(j != 0)
                    ai[l++] = j;
                else
                    l++;
            }

            for(int i3 = i1; i3 < 0; i3++)
            {
                j = ai1[k++];
                if(j != 0)
                    ai[l++] = j;
                else
                    l++;
            }

            l += k1;
            k += l1;
        }

    }

    private void ig(int ai[], byte abyte0[], int ai1[], int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        int i2 = -(l >> 2);
        l = -(l & 3);
        for(int j2 = -i1; j2 < 0; j2 += l1)
        {
            for(int k2 = i2; k2 < 0; k2++)
            {
                byte byte0 = abyte0[j++];
                if(byte0 != 0)
                    ai[k++] = ai1[byte0 & 0xff];
                else
                    k++;
                byte0 = abyte0[j++];
                if(byte0 != 0)
                    ai[k++] = ai1[byte0 & 0xff];
                else
                    k++;
                byte0 = abyte0[j++];
                if(byte0 != 0)
                    ai[k++] = ai1[byte0 & 0xff];
                else
                    k++;
                byte0 = abyte0[j++];
                if(byte0 != 0)
                    ai[k++] = ai1[byte0 & 0xff];
                else
                    k++;
            }

            for(int l2 = l; l2 < 0; l2++)
            {
                byte byte1 = abyte0[j++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
            }

            k += j1;
            j += k1;
        }

    }

    private void wf(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        try
        {
            int i3 = k;
            for(int j3 = -l1; j3 < 0; j3 += l2)
            {
                int k3 = (l >> 16) * k2;
                for(int l3 = -k1; l3 < 0; l3++)
                {
                    j = ai1[(k >> 16) + k3];
                    if(j != 0)
                        ai[i1++] = j;
                    else
                        i1++;
                    k += i2;
                }

                l += j2;
                k = i3;
                i1 += j1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    private void lg(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2)
    {
        int k2 = 256 - j2;
        for(int l2 = -j1; l2 < 0; l2 += i2)
        {
            for(int i3 = -i1; i3 < 0; i3++)
            {
                j = ai1[k++];
                if(j != 0)
                {
                    int j3 = ai[l];
                    ai[l++] = ((j & 0xff00ff) * j2 + (j3 & 0xff00ff) * k2 & 0xff00ff00) + ((j & 0xff00) * j2 + (j3 & 0xff00) * k2 & 0xff0000) >> 8;
                } else
                {
                    l++;
                }
            }

            l += k1;
            k += l1;
        }

    }

    private void ih(int ai[], byte abyte0[], int ai1[], int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2)
    {
        int j2 = 256 - i2;
        for(int k2 = -i1; k2 < 0; k2 += l1)
        {
            for(int l2 = -l; l2 < 0; l2++)
            {
                int i3 = abyte0[j++];
                if(i3 != 0)
                {
                    i3 = ai1[i3 & 0xff];
                    int j3 = ai[k];
                    ai[k++] = ((i3 & 0xff00ff) * i2 + (j3 & 0xff00ff) * j2 & 0xff00ff00) + ((i3 & 0xff00) * i2 + (j3 & 0xff00) * j2 & 0xff0000) >> 8;
                } else
                {
                    k++;
                }
            }

            k += j1;
            j += k1;
        }

    }

    private void dg(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        int j3 = 256 - i3;
        try
        {
            int k3 = k;
            for(int l3 = -l1; l3 < 0; l3 += l2)
            {
                int i4 = (l >> 16) * k2;
                for(int j4 = -k1; j4 < 0; j4++)
                {
                    j = ai1[(k >> 16) + i4];
                    if(j != 0)
                    {
                        int k4 = ai[i1];
                        ai[i1++] = ((j & 0xff00ff) * i3 + (k4 & 0xff00ff) * j3 & 0xff00ff00) + ((j & 0xff00) * i3 + (k4 & 0xff00) * j3 & 0xff0000) >> 8;
                    } else
                    {
                        i1++;
                    }
                    k += i2;
                }

                l += j2;
                k = k3;
                i1 += j1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in tran_scale");
        }
    }

    private void kh(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        int j3 = i3 >> 16 & 0xff;
        int k3 = i3 >> 8 & 0xff;
        int l3 = i3 & 0xff;
        try
        {
            int i4 = k;
            for(int j4 = -l1; j4 < 0; j4 += l2)
            {
                int k4 = (l >> 16) * k2;
                for(int l4 = -k1; l4 < 0; l4++)
                {
                    j = ai1[(k >> 16) + k4];
                    if(j != 0)
                    {
                        int i5 = j >> 16 & 0xff;
                        int j5 = j >> 8 & 0xff;
                        int k5 = j & 0xff;
                        if(i5 == j5 && j5 == k5)
                            ai[i1++] = ((i5 * j3 >> 8) << 16) + ((j5 * k3 >> 8) << 8) + (k5 * l3 >> 8);
                        else
                            ai[i1++] = j;
                    } else
                    {
                        i1++;
                    }
                    k += i2;
                }

                l += j2;
                k = i4;
                i1 += j1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    public void vf(int j, int k, int l, int i1, int j1)
    {
        int k1 = xj;
        int l1 = yj;
        if(bl == null)
        {
            bl = new int[512];
            for(int i2 = 0; i2 < 256; i2++)
            {
                bl[i2] = (int)(Math.sin((double)i2 * 0.02454369D) * 32768D);
                bl[i2 + 256] = (int)(Math.cos((double)i2 * 0.02454369D) * 32768D);
            }

        }
        int j2 = -ok[l] / 2;
        int k2 = -pk[l] / 2;
        if(qk[l])
        {
            j2 += mk[l];
            k2 += nk[l];
        }
        int l2 = j2 + kk[l];
        int i3 = k2 + lk[l];
        int j3 = l2;
        int k3 = k2;
        int l3 = j2;
        int i4 = i3;
        i1 &= 0xff;
        int j4 = bl[i1] * j1;
        int k4 = bl[i1 + 256] * j1;
        int l4 = j + (k2 * j4 + j2 * k4 >> 22);
        int i5 = k + (k2 * k4 - j2 * j4 >> 22);
        int j5 = j + (k3 * j4 + j3 * k4 >> 22);
        int k5 = k + (k3 * k4 - j3 * j4 >> 22);
        int l5 = j + (i3 * j4 + l2 * k4 >> 22);
        int i6 = k + (i3 * k4 - l2 * j4 >> 22);
        int j6 = j + (i4 * j4 + l3 * k4 >> 22);
        int k6 = k + (i4 * k4 - l3 * j4 >> 22);
        int l6 = i5;
        int i7 = i5;
        if(k5 < l6)
            l6 = k5;
        else
        if(k5 > i7)
            i7 = k5;
        if(i6 < l6)
            l6 = i6;
        else
        if(i6 > i7)
            i7 = i6;
        if(k6 < l6)
            l6 = k6;
        else
        if(k6 > i7)
            i7 = k6;
        if(l6 < sk)
            l6 = sk;
        if(i7 > tk)
            i7 = tk;
        if(cl == null || cl.length != l1 + 1)
        {
            cl = new int[l1 + 1];
            dl = new int[l1 + 1];
            el = new int[l1 + 1];
            fl = new int[l1 + 1];
            gl = new int[l1 + 1];
            hl = new int[l1 + 1];
        }
        for(int j7 = l6; j7 <= i7; j7++)
        {
            cl[j7] = 0x5f5e0ff;
            dl[j7] = 0xfa0a1f01;
        }

        int j8 = 0;
        int l8 = 0;
        int j9 = 0;
        int k9 = kk[l];
        int l9 = lk[l];
        j2 = 0;
        k2 = 0;
        j3 = k9 - 1;
        k3 = 0;
        l2 = k9 - 1;
        i3 = l9 - 1;
        l3 = 0;
        i4 = l9 - 1;
        if(k6 != i5)
        {
            j8 = (j6 - l4 << 8) / (k6 - i5);
            j9 = (i4 - k2 << 8) / (k6 - i5);
        }
        int k7;
        int l7;
        int i8;
        int i9;
        if(i5 > k6)
        {
            i8 = j6 << 8;
            i9 = i4 << 8;
            k7 = k6;
            l7 = i5;
        } else
        {
            i8 = l4 << 8;
            i9 = k2 << 8;
            k7 = i5;
            l7 = k6;
        }
        if(k7 < 0)
        {
            i8 -= j8 * k7;
            i9 -= j9 * k7;
            k7 = 0;
        }
        if(l7 > l1 - 1)
            l7 = l1 - 1;
        for(int i10 = k7; i10 <= l7; i10++)
        {
            cl[i10] = dl[i10] = i8;
            i8 += j8;
            el[i10] = fl[i10] = 0;
            gl[i10] = hl[i10] = i9;
            i9 += j9;
        }

        if(k5 != i5)
        {
            j8 = (j5 - l4 << 8) / (k5 - i5);
            l8 = (j3 - j2 << 8) / (k5 - i5);
        }
        int k8;
        if(i5 > k5)
        {
            i8 = j5 << 8;
            k8 = j3 << 8;
            k7 = k5;
            l7 = i5;
        } else
        {
            i8 = l4 << 8;
            k8 = j2 << 8;
            k7 = i5;
            l7 = k5;
        }
        if(k7 < 0)
        {
            i8 -= j8 * k7;
            k8 -= l8 * k7;
            k7 = 0;
        }
        if(l7 > l1 - 1)
            l7 = l1 - 1;
        for(int j10 = k7; j10 <= l7; j10++)
        {
            if(i8 < cl[j10])
            {
                cl[j10] = i8;
                el[j10] = k8;
                gl[j10] = 0;
            }
            if(i8 > dl[j10])
            {
                dl[j10] = i8;
                fl[j10] = k8;
                hl[j10] = 0;
            }
            i8 += j8;
            k8 += l8;
        }

        if(i6 != k5)
        {
            j8 = (l5 - j5 << 8) / (i6 - k5);
            j9 = (i3 - k3 << 8) / (i6 - k5);
        }
        if(k5 > i6)
        {
            i8 = l5 << 8;
            k8 = l2 << 8;
            i9 = i3 << 8;
            k7 = i6;
            l7 = k5;
        } else
        {
            i8 = j5 << 8;
            k8 = j3 << 8;
            i9 = k3 << 8;
            k7 = k5;
            l7 = i6;
        }
        if(k7 < 0)
        {
            i8 -= j8 * k7;
            i9 -= j9 * k7;
            k7 = 0;
        }
        if(l7 > l1 - 1)
            l7 = l1 - 1;
        for(int k10 = k7; k10 <= l7; k10++)
        {
            if(i8 < cl[k10])
            {
                cl[k10] = i8;
                el[k10] = k8;
                gl[k10] = i9;
            }
            if(i8 > dl[k10])
            {
                dl[k10] = i8;
                fl[k10] = k8;
                hl[k10] = i9;
            }
            i8 += j8;
            i9 += j9;
        }

        if(k6 != i6)
        {
            j8 = (j6 - l5 << 8) / (k6 - i6);
            l8 = (l3 - l2 << 8) / (k6 - i6);
        }
        if(i6 > k6)
        {
            i8 = j6 << 8;
            k8 = l3 << 8;
            i9 = i4 << 8;
            k7 = k6;
            l7 = i6;
        } else
        {
            i8 = l5 << 8;
            k8 = l2 << 8;
            i9 = i3 << 8;
            k7 = i6;
            l7 = k6;
        }
        if(k7 < 0)
        {
            i8 -= j8 * k7;
            k8 -= l8 * k7;
            k7 = 0;
        }
        if(l7 > l1 - 1)
            l7 = l1 - 1;
        for(int l10 = k7; l10 <= l7; l10++)
        {
            if(i8 < cl[l10])
            {
                cl[l10] = i8;
                el[l10] = k8;
                gl[l10] = i9;
            }
            if(i8 > dl[l10])
            {
                dl[l10] = i8;
                fl[l10] = k8;
                hl[l10] = i9;
            }
            i8 += j8;
            k8 += l8;
        }

        int i11 = l6 * k1;
        int ai[] = hk[l];
        for(int j11 = l6; j11 < i7; j11++)
        {
            int k11 = cl[j11] >> 8;
            int l11 = dl[j11] >> 8;
            if(l11 - k11 <= 0)
            {
                i11 += k1;
            } else
            {
                int i12 = el[j11] << 9;
                int j12 = ((fl[j11] << 9) - i12) / (l11 - k11);
                int k12 = gl[j11] << 9;
                int l12 = ((hl[j11] << 9) - k12) / (l11 - k11);
                if(k11 < uk)
                {
                    i12 += (uk - k11) * j12;
                    k12 += (uk - k11) * l12;
                    k11 = uk;
                }
                if(l11 > vk)
                    l11 = vk;
                if(!wk || (j11 & 1) == 0)
                    if(!qk[l])
                        gg(dk, ai, wj, i11 + k11, i12, k12, j12, l12, k11 - l11, k9);
                    else
                        kg(dk, ai, wj, i11 + k11, i12, k12, j12, l12, k11 - l11, k9);
                i11 += k1;
            }
        }

    }

    private void gg(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2)
    {
        for(j = l1; j < 0; j++)
        {
            dk[k++] = ai1[(l >> 17) + (i1 >> 17) * i2];
            l += j1;
            i1 += k1;
        }

    }

    private void kg(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2)
    {
        for(int j2 = l1; j2 < 0; j2++)
        {
            j = ai1[(l >> 17) + (i1 >> 17) * i2];
            if(j != 0)
                dk[k++] = j;
            else
                k++;
            l += j1;
            i1 += k1;
        }

    }

    public void jg(int j, int k, int l, int i1, int j1, int k1, int l1)
    {
        uf(j, k, l, i1, j1);
    }

    public void cg(int j, int k, int l, int i1, int j1, int k1, int l1, 
            int i2, boolean flag)
    {
        try
        {
            if(k1 == 0)
                k1 = 0xffffff;
            if(l1 == 0)
                l1 = 0xffffff;
            int j2 = kk[j1];
            int k2 = lk[j1];
            int l2 = 0;
            int i3 = 0;
            int j3 = i2 << 16;
            int k3 = (j2 << 16) / l;
            int l3 = (k2 << 16) / i1;
            int i4 = -(i2 << 16) / i1;
            if(qk[j1])
            {
                int j4 = ok[j1];
                int l4 = pk[j1];
                k3 = (j4 << 16) / l;
                l3 = (l4 << 16) / i1;
                int k5 = mk[j1];
                int l5 = nk[j1];
                if(flag)
                    k5 = j4 - kk[j1] - k5;
                j += ((k5 * l + j4) - 1) / j4;
                int i6 = ((l5 * i1 + l4) - 1) / l4;
                k += i6;
                j3 += i6 * i4;
                if((k5 * l) % j4 != 0)
                    l2 = (j4 - (k5 * l) % j4 << 16) / l;
                if((l5 * i1) % l4 != 0)
                    i3 = (l4 - (l5 * i1) % l4 << 16) / i1;
                l = ((((kk[j1] << 16) - l2) + k3) - 1) / k3;
                i1 = ((((lk[j1] << 16) - i3) + l3) - 1) / l3;
            }
            int k4 = k * xj;
            j3 += j << 16;
            if(k < sk)
            {
                int i5 = sk - k;
                i1 -= i5;
                k = sk;
                k4 += i5 * xj;
                i3 += l3 * i5;
                j3 += i4 * i5;
            }
            if(k + i1 >= tk)
                i1 -= ((k + i1) - tk) + 1;
            int j5 = k4 / xj & 1;
            if(!wk)
                j5 = 2;
            if(l1 == 0xffffff)
            {
                if(hk[j1] != null)
                    if(!flag)
                    {
                        jh(dk, hk[j1], wj, l2, i3, k4, l, i1, k3, l3, j2, k1, j3, i4, j5);
                        return;
                    } else
                    {
                        jh(dk, hk[j1], wj, (kk[j1] << 16) - l2 - 1, i3, k4, l, i1, -k3, l3, j2, k1, j3, i4, j5);
                        return;
                    }
                if(!flag)
                {
                    pf(dk, ik[j1], jk[j1], wj, l2, i3, k4, l, i1, k3, l3, j2, k1, j3, i4, j5);
                    return;
                } else
                {
                    pf(dk, ik[j1], jk[j1], wj, (kk[j1] << 16) - l2 - 1, i3, k4, l, i1, -k3, l3, j2, k1, j3, i4, j5);
                    return;
                }
            }
            if(hk[j1] != null)
                if(!flag)
                {
                    hg(dk, hk[j1], wj, l2, i3, k4, l, i1, k3, l3, j2, k1, l1, j3, i4, j5);
                    return;
                } else
                {
                    hg(dk, hk[j1], wj, (kk[j1] << 16) - l2 - 1, i3, k4, l, i1, -k3, l3, j2, k1, l1, j3, i4, j5);
                    return;
                }
            if(!flag)
            {
                hh(dk, ik[j1], jk[j1], wj, l2, i3, k4, l, i1, k3, l3, j2, k1, l1, j3, i4, j5);
                return;
            } else
            {
                hh(dk, ik[j1], jk[j1], wj, (kk[j1] << 16) - l2 - 1, i3, k4, l, i1, -k3, l3, j2, k1, l1, j3, i4, j5);
                return;
            }
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void jh(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3, 
            int j3)
    {
        int j4 = k2 >> 16 & 0xff;
        int k4 = k2 >> 8 & 0xff;
        int l4 = k2 & 0xff;
        try
        {
            int i5 = k;
            for(int j5 = -k1; j5 < 0; j5++)
            {
                int k5 = (l >> 16) * j2;
                int l5 = l2 >> 16;
                int i6 = j1;
                if(l5 < uk)
                {
                    int j6 = uk - l5;
                    i6 -= j6;
                    l5 = uk;
                    k += l1 * j6;
                }
                if(l5 + i6 >= vk)
                {
                    int k6 = (l5 + i6) - vk;
                    i6 -= k6;
                }
                j3 = 1 - j3;
                if(j3 != 0)
                {
                    for(int l6 = l5; l6 < l5 + i6; l6++)
                    {
                        j = ai1[(k >> 16) + k5];
                        if(j != 0)
                        {
                            int k3 = j >> 16 & 0xff;
                            int l3 = j >> 8 & 0xff;
                            int i4 = j & 0xff;
                            if(k3 == l3 && l3 == i4)
                                ai[l6 + i1] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
                            else
                                ai[l6 + i1] = j;
                        }
                        k += l1;
                    }

                }
                l += i2;
                k = i5;
                i1 += xj;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void hg(int ai[], int ai1[], int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3, 
            int j3, int k3)
    {
        int k4 = k2 >> 16 & 0xff;
        int l4 = k2 >> 8 & 0xff;
        int i5 = k2 & 0xff;
        int j5 = l2 >> 16 & 0xff;
        int k5 = l2 >> 8 & 0xff;
        int l5 = l2 & 0xff;
        try
        {
            int i6 = k;
            for(int j6 = -k1; j6 < 0; j6++)
            {
                int k6 = (l >> 16) * j2;
                int l6 = i3 >> 16;
                int i7 = j1;
                if(l6 < uk)
                {
                    int j7 = uk - l6;
                    i7 -= j7;
                    l6 = uk;
                    k += l1 * j7;
                }
                if(l6 + i7 >= vk)
                {
                    int k7 = (l6 + i7) - vk;
                    i7 -= k7;
                }
                k3 = 1 - k3;
                if(k3 != 0)
                {
                    for(int l7 = l6; l7 < l6 + i7; l7++)
                    {
                        j = ai1[(k >> 16) + k6];
                        if(j != 0)
                        {
                            int l3 = j >> 16 & 0xff;
                            int i4 = j >> 8 & 0xff;
                            int j4 = j & 0xff;
                            if(l3 == i4 && i4 == j4)
                                ai[l7 + i1] = ((l3 * k4 >> 8) << 16) + ((i4 * l4 >> 8) << 8) + (j4 * i5 >> 8);
                            else
                            if(l3 == 255 && i4 == j4)
                                ai[l7 + i1] = ((l3 * j5 >> 8) << 16) + ((i4 * k5 >> 8) << 8) + (j4 * l5 >> 8);
                            else
                                ai[l7 + i1] = j;
                        }
                        k += l1;
                    }

                }
                l += i2;
                k = i6;
                i1 += xj;
                i3 += j3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void pf(int ai[], byte abyte0[], int ai1[], int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3, int j3)
    {
        int j4 = k2 >> 16 & 0xff;
        int k4 = k2 >> 8 & 0xff;
        int l4 = k2 & 0xff;
        try
        {
            int i5 = k;
            for(int j5 = -k1; j5 < 0; j5++)
            {
                int k5 = (l >> 16) * j2;
                int l5 = l2 >> 16;
                int i6 = j1;
                if(l5 < uk)
                {
                    int j6 = uk - l5;
                    i6 -= j6;
                    l5 = uk;
                    k += l1 * j6;
                }
                if(l5 + i6 >= vk)
                {
                    int k6 = (l5 + i6) - vk;
                    i6 -= k6;
                }
                j3 = 1 - j3;
                if(j3 != 0)
                {
                    for(int l6 = l5; l6 < l5 + i6; l6++)
                    {
                        j = abyte0[(k >> 16) + k5] & 0xff;
                        if(j != 0)
                        {
                            j = ai1[j];
                            int k3 = j >> 16 & 0xff;
                            int l3 = j >> 8 & 0xff;
                            int i4 = j & 0xff;
                            if(k3 == l3 && l3 == i4)
                                ai[l6 + i1] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
                            else
                                ai[l6 + i1] = j;
                        }
                        k += l1;
                    }

                }
                l += i2;
                k = i5;
                i1 += xj;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void hh(int ai[], byte abyte0[], int ai1[], int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3, int j3, int k3)
    {
        int k4 = k2 >> 16 & 0xff;
        int l4 = k2 >> 8 & 0xff;
        int i5 = k2 & 0xff;
        int j5 = l2 >> 16 & 0xff;
        int k5 = l2 >> 8 & 0xff;
        int l5 = l2 & 0xff;
        try
        {
            int i6 = k;
            for(int j6 = -k1; j6 < 0; j6++)
            {
                int k6 = (l >> 16) * j2;
                int l6 = i3 >> 16;
                int i7 = j1;
                if(l6 < uk)
                {
                    int j7 = uk - l6;
                    i7 -= j7;
                    l6 = uk;
                    k += l1 * j7;
                }
                if(l6 + i7 >= vk)
                {
                    int k7 = (l6 + i7) - vk;
                    i7 -= k7;
                }
                k3 = 1 - k3;
                if(k3 != 0)
                {
                    for(int l7 = l6; l7 < l6 + i7; l7++)
                    {
                        j = abyte0[(k >> 16) + k6] & 0xff;
                        if(j != 0)
                        {
                            j = ai1[j];
                            int l3 = j >> 16 & 0xff;
                            int i4 = j >> 8 & 0xff;
                            int j4 = j & 0xff;
                            if(l3 == i4 && i4 == j4)
                                ai[l7 + i1] = ((l3 * k4 >> 8) << 16) + ((i4 * l4 >> 8) << 8) + (j4 * i5 >> 8);
                            else
                            if(l3 == 255 && i4 == j4)
                                ai[l7 + i1] = ((l3 * j5 >> 8) << 16) + ((i4 * k5 >> 8) << 8) + (j4 * l5 >> 8);
                            else
                                ai[l7 + i1] = j;
                        }
                        k += l1;
                    }

                }
                l += i2;
                k = i6;
                i1 += xj;
                i3 += j3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    public static int lf(byte abyte0[])
    {
        xk[zk] = abyte0;
        return zk++;
    }

    public void fh(String s, int j, int k, int l, int i1)
    {
        tf(s, j - kf(s, l), k, l, i1);
    }

    public void ah(String s, int j, int k, int l, int i1)
    {
        tf(s, j - kf(s, l) / 2, k, l, i1);
    }

    public void gh(String s, int j, int k, int l, int i1, int j1)
    {
        int k1 = 0;
        byte abyte0[] = xk[l];
        int l1 = 0;
        int i2 = 0;
        for(int j2 = 0; j2 < s.length(); j2++)
        {
            if(s.charAt(j2) == '@' && j2 + 4 < s.length() && s.charAt(j2 + 4) == '@')
                j2 += 4;
            else
            if(s.charAt(j2) == '~' && j2 + 4 < s.length() && s.charAt(j2 + 4) == '~')
                j2 += 4;
            else
                k1 += abyte0[yk[s.charAt(j2)] + 7];
            if(s.charAt(j2) == ' ')
                i2 = j2;
            if(k1 > j1)
            {
                if(i2 <= l1)
                    i2 = j2;
                ah(s.substring(l1, i2), j, k, l, i1);
                k1 = 0;
                l1 = j2 = i2 + 1;
                k += tg(l);
            }
        }

        if(k1 > 0)
            ah(s.substring(l1), j, k, l, i1);
    }

    public void tf(String s, int j, int k, int l, int i1)
    {
        byte abyte0[] = xk[l];
        for(int j1 = 0; j1 < s.length(); j1++)
            if(s.charAt(j1) == '@' && j1 + 4 < s.length() && s.charAt(j1 + 4) == '@')
            {
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("red"))
                    i1 = 0xff0000;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("lre"))
                    i1 = 0xff9040;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("yel"))
                    i1 = 0xffff00;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("gre"))
                    i1 = 65280;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("blu"))
                    i1 = 255;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("cya"))
                    i1 = 65535;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("mag"))
                    i1 = 0xff00ff;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("whi"))
                    i1 = 0xffffff;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("bla"))
                    i1 = 0;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("dre"))
                    i1 = 0xc00000;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("ora"))
                    i1 = 0xff9040;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("ran"))
                    i1 = (int)(Math.random() * 16777215D);
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("or1"))
                    i1 = 0xffb000;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("or2"))
                    i1 = 0xff7000;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("or3"))
                    i1 = 0xff3000;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("gr1"))
                    i1 = 0xc0ff00;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("gr2"))
                    i1 = 0x80ff00;
                else
                if(s.substring(j1 + 1, j1 + 4).equalsIgnoreCase("gr3"))
                    i1 = 0x40ff00;
                j1 += 4;
            } else
            if(s.charAt(j1) == '~' && j1 + 4 < s.length() && s.charAt(j1 + 4) == '~')
            {
                char c = s.charAt(j1 + 1);
                char c1 = s.charAt(j1 + 2);
                char c2 = s.charAt(j1 + 3);
                if(c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9')
                    j = Integer.parseInt(s.substring(j1 + 1, j1 + 4));
                j1 += 4;
            } else
            {
                int k1 = yk[s.charAt(j1)];
                if(al && i1 != 0)
                    zg(k1, j + 1, k, 0, abyte0);
                if(al && i1 != 0)
                    zg(k1, j, k + 1, 0, abyte0);
                zg(k1, j, k, i1, abyte0);
                j += abyte0[k1 + 7];
            }

    }

    private void zg(int j, int k, int l, int i1, byte abyte0[])
    {
        int j1 = k + abyte0[j + 5];
        int k1 = l - abyte0[j + 6];
        int l1 = abyte0[j + 3];
        int i2 = abyte0[j + 4];
        int j2 = abyte0[j] * 16384 + abyte0[j + 1] * 128 + abyte0[j + 2];
        int k2 = j1 + k1 * xj;
        int l2 = xj - l1;
        int i3 = 0;
        if(k1 < sk)
        {
            int j3 = sk - k1;
            i2 -= j3;
            k1 = sk;
            j2 += j3 * l1;
            k2 += j3 * xj;
        }
        if(k1 + i2 >= tk)
            i2 -= ((k1 + i2) - tk) + 1;
        if(j1 < uk)
        {
            int k3 = uk - j1;
            l1 -= k3;
            j1 = uk;
            j2 += k3;
            k2 += k3;
            i3 += k3;
            l2 += k3;
        }
        if(j1 + l1 >= vk)
        {
            int l3 = ((j1 + l1) - vk) + 1;
            l1 -= l3;
            i3 += l3;
            l2 += l3;
        }
        if(l1 > 0 && i2 > 0)
            jf(dk, abyte0, i1, j2, k2, l1, i2, l2, i3);
    }

    private void jf(int ai[], byte abyte0[], int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        int i2 = -(i1 >> 2);
        i1 = -(i1 & 3);
        for(int j2 = -j1; j2 < 0; j2++)
        {
            for(int k2 = i2; k2 < 0; k2++)
            {
                if(abyte0[k++] != 0)
                    ai[l++] = j;
                else
                    l++;
                if(abyte0[k++] != 0)
                    ai[l++] = j;
                else
                    l++;
                if(abyte0[k++] != 0)
                    ai[l++] = j;
                else
                    l++;
                if(abyte0[k++] != 0)
                    ai[l++] = j;
                else
                    l++;
            }

            for(int l2 = i1; l2 < 0; l2++)
                if(abyte0[k++] != 0)
                    ai[l++] = j;
                else
                    l++;

            l += k1;
            k += l1;
        }

    }

    public int tg(int j)
    {
        if(j == 0)
            return xk[j][8] - 2;
        else
            return xk[j][8] - 1;
    }

    public int kf(String s, int j)
    {
        int k = 0;
        byte abyte0[] = xk[j];
        for(int l = 0; l < s.length(); l++)
            if(s.charAt(l) == '@' && l + 4 < s.length() && s.charAt(l + 4) == '@')
                l += 4;
            else
            if(s.charAt(l) == '~' && l + 4 < s.length() && s.charAt(l + 4) == '~')
                l += 4;
            else
                k += abyte0[yk[s.charAt(l)] + 7];

        return k;
    }

    public boolean imageUpdate(Image image, int j, int k, int l, int i1, int j1)
    {
        return true;
    }

    int wj;
    public int xj;
    public int yj;
    public int zj;
    public int ak;
    public int bk;
    ColorModel ck;
    public int dk[];
    ImageConsumer ek;
    private Component fk;
    public Image gk;
    private int hk[][];
    private byte ik[][];
    private int jk[][];
    public int kk[];
    public int lk[];
    public int mk[];
    public int nk[];
    public int ok[];
    public int pk[];
    public boolean qk[];
    private boolean rk;
    private int sk;
    private int tk;
    private int uk;
    private int vk;
    public boolean wk;
    static byte xk[][] = new byte[50][];
    static int yk[];
    static int zk;
    public boolean al;
    int bl[];
    int cl[];
    int dl[];
    int el[];
    int fl[];
    int gl[];
    int hl[];
    public static final int il = 0;
    public static final int jl = 0xffffff;
    public static final int kl = 0xff0000;
    public static final int ll = 0xc00000;
    public static final int ml = 65280;
    public static final int nl = 255;
    public static final int ol = 0xffff00;
    public static final int pl = 65535;
    public static final int ql = 0xff00ff;
    public static final int rl = 0xc0c0c0;
    public static final int sl = 0x808080;
    public static final int tl = 0x404040;
    public static final int ul = 0;
    public static final int vl = 1;
    public static final int wl = 2;
    public static final int xl = 3;
    public static final int yl = 4;
    public static final int zl = 5;
    public static final int am = 6;
    public static final int bm = 7;

    static 
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        yk = new int[256];
        for(int j = 0; j < 256; j++)
        {
            int k = s.indexOf(j);
            if(k == -1)
                k = 74;
            yk[j] = k * 9;
        }

    }
}
