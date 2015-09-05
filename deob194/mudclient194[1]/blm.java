// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;

public class blm
    implements ImageProducer, ImageObserver
{

    public blm(int i, int j, int k, Component component)
    {
        bnj = false;
        bnm = false;
        bmh = component;
        bng = j;
        bni = i;
        bmc = bln = i;
        bmd = bma = j;
        bmb = i * j;
        bmf = new int[i * j];
        bmj = new int[k][];
        bne = new boolean[k];
        bmk = new byte[k][];
        bml = new int[k][];
        bmm = new int[k];
        bmn = new int[k];
        bnc = new int[k];
        bnd = new int[k];
        bna = new int[k];
        bnb = new int[k];
        if(i > 1 && j > 1 && component != null)
        {
            bme = new DirectColorModel(32, 0xff0000, 65280, 255);
            int l = bln * bma;
            for(int i1 = 0; i1 < l; i1++)
                bmf[i1] = 0;

            bmi = component.createImage(this);
            can();
            component.prepareImage(bmi, component);
            can();
            component.prepareImage(bmi, component);
            can();
            component.prepareImage(bmi, component);
        }
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        bmg = imageconsumer;
        imageconsumer.setDimensions(bln, bma);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(bme);
        imageconsumer.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return bmg == imageconsumer;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        if(bmg == imageconsumer)
            bmg = null;
    }

    public void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
        System.out.println("TDLR");
    }

    public synchronized void can()
    {
        if(bmg == null)
        {
            return;
        } else
        {
            bmg.setPixels(0, 0, bln, bma, bme, bmf, 0, bln);
            bmg.imageComplete(2);
            return;
        }
    }

    public void cba(int i, int j, int k, int l)
    {
        if(i < 0)
            i = 0;
        if(j < 0)
            j = 0;
        if(k > bln)
            k = bln;
        if(l > bma)
            l = bma;
        bnh = i;
        bnf = j;
        bni = k;
        bng = l;
    }

    public void cbb()
    {
        bnh = 0;
        bnf = 0;
        bni = bln;
        bng = bma;
    }

    public void cbc(Graphics g, int i, int j)
    {
        can();
        g.drawImage(bmi, i, j, this);
    }

    public void cbd()
    {
        boolean flag = false;
        int i = bln * bma;
        if(!bnj)
        {
            for(int j = 0; j < i; j++)
                bmf[j] = 0;

            return;
        }
        int k = 0;
        for(int l = -bma; l < 0; l += 2)
        {
            for(int i1 = -bln; i1 < 0; i1++)
                bmf[k++] = 0;

            k += bln;
        }

    }

    public void cbe(int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        int j1 = 256 - i1;
        int k1 = (l >> 16 & 0xff) * i1;
        int l1 = (l >> 8 & 0xff) * i1;
        int i2 = (l & 0xff) * i1;
        int i3 = j - k;
        if(i3 < 0)
            i3 = 0;
        int j3 = j + k;
        if(j3 >= bma)
            j3 = bma - 1;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            if((i3 & 1) != 0)
                i3++;
        }
        for(int k3 = i3; k3 <= j3; k3 += byte0)
        {
            int l3 = k3 - j;
            int i4 = (int)Math.sqrt(k * k - l3 * l3);
            int j4 = i - i4;
            if(j4 < 0)
                j4 = 0;
            int k4 = i + i4;
            if(k4 >= bln)
                k4 = bln - 1;
            int l4 = j4 + k3 * bln;
            for(int i5 = j4; i5 <= k4; i5++)
            {
                int j2 = (bmf[l4] >> 16 & 0xff) * j1;
                int k2 = (bmf[l4] >> 8 & 0xff) * j1;
                int l2 = (bmf[l4] & 0xff) * j1;
                int j5 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
                bmf[l4++] = j5;
            }

        }

    }

    public void cbf(int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = false;
        if(i < bnh)
        {
            k -= bnh - i;
            i = bnh;
        }
        if(j < bnf)
        {
            l -= bnf - j;
            j = bnf;
        }
        if(i + k > bni)
            k = bni - i;
        if(j + l > bng)
            l = bng - j;
        int k1 = 256 - j1;
        int l1 = (i1 >> 16 & 0xff) * j1;
        int i2 = (i1 >> 8 & 0xff) * j1;
        int j2 = (i1 & 0xff) * j1;
        int j3 = bln - k;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            j3 += bln;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int k3 = i + j * bln;
        for(int l3 = 0; l3 < l; l3 += byte0)
        {
            for(int i4 = -k; i4 < 0; i4++)
            {
                int k2 = (bmf[k3] >> 16 & 0xff) * k1;
                int l2 = (bmf[k3] >> 8 & 0xff) * k1;
                int i3 = (bmf[k3] & 0xff) * k1;
                int j4 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
                bmf[k3++] = j4;
            }

            k3 += j3;
        }

    }

    public void cbg(int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = false;
        if(i < bnh)
        {
            k -= bnh - i;
            i = bnh;
        }
        if(i + k > bni)
            k = bni - i;
        int k1 = j1 >> 16 & 0xff;
        int l1 = j1 >> 8 & 0xff;
        int i2 = j1 & 0xff;
        int j2 = i1 >> 16 & 0xff;
        int k2 = i1 >> 8 & 0xff;
        int l2 = i1 & 0xff;
        int i3 = bln - k;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            i3 += bln;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int j3 = i + j * bln;
        for(int k3 = 0; k3 < l; k3 += byte0)
            if(k3 + j >= bnf && k3 + j < bng)
            {
                int l3 = ((k1 * k3 + j2 * (l - k3)) / l << 16) + ((l1 * k3 + k2 * (l - k3)) / l << 8) + (i2 * k3 + l2 * (l - k3)) / l;
                for(int i4 = -k; i4 < 0; i4++)
                    bmf[j3++] = l3;

                j3 += i3;
            } else
            {
                j3 += bln;
            }

    }

    public void cbh(int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        if(i < bnh)
        {
            k -= bnh - i;
            i = bnh;
        }
        if(j < bnf)
        {
            l -= bnf - j;
            j = bnf;
        }
        if(i + k > bni)
            k = bni - i;
        if(j + l > bng)
            l = bng - j;
        int j1 = bln - k;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            j1 += bln;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int k1 = i + j * bln;
        for(int l1 = -l; l1 < 0; l1 += byte0)
        {
            for(int i2 = -k; i2 < 0; i2++)
                bmf[k1++] = i1;

            k1 += j1;
        }

    }

    public void cbi(int i, int j, int k, int l, int i1)
    {
        cbj(i, j, k, i1);
        cbj(i, (j + l) - 1, k, i1);
        cbk(i, j, l, i1);
        cbk((i + k) - 1, j, l, i1);
    }

    public void cbj(int i, int j, int k, int l)
    {
        if(j < bnf || j >= bng)
            return;
        if(i < bnh)
        {
            k -= bnh - i;
            i = bnh;
        }
        if(i + k > bni)
            k = bni - i;
        int i1 = i + j * bln;
        for(int j1 = 0; j1 < k; j1++)
            bmf[i1 + j1] = l;

    }

    public void cbk(int i, int j, int k, int l)
    {
        if(i < bnh || i >= bni)
            return;
        if(j < bnf)
        {
            k -= bnf - j;
            j = bnf;
        }
        if(j + k > bni)
            k = bng - j;
        int i1 = i + j * bln;
        for(int j1 = 0; j1 < k; j1++)
            bmf[i1 + j1 * bln] = l;

    }

    public void cbl(int i, int j, int k)
    {
        if(i < bnh || j < bnf || i >= bni || j >= bng)
        {
            return;
        } else
        {
            bmf[i + j * bln] = k;
            return;
        }
    }

    public void cbm()
    {
        int k = bln * bma;
        for(int j = 0; j < k; j++)
        {
            int i = bmf[j] & 0xffffff;
            bmf[j] = (i >>> 1 & 0x7f7f7f) + (i >>> 2 & 0x3f3f3f) + (i >>> 3 & 0x1f1f1f) + (i >>> 4 & 0xf0f0f);
        }

    }

    public void cbn(int i, int j, int k, int l, int i1, int j1)
    {
        boolean flag = false;
        for(int k1 = k; k1 < k + i1; k1++)
        {
            for(int l1 = l; l1 < l + j1; l1++)
            {
                int i2 = 0;
                int j2 = 0;
                int k2 = 0;
                int l2 = 0;
                for(int i3 = k1 - i; i3 <= k1 + i; i3++)
                    if(i3 >= 0 && i3 < bln)
                    {
                        for(int j3 = l1 - j; j3 <= l1 + j; j3++)
                            if(j3 >= 0 && j3 < bma)
                            {
                                int k3 = bmf[i3 + bln * j3];
                                i2 += k3 >> 16 & 0xff;
                                j2 += k3 >> 8 & 0xff;
                                k2 += k3 & 0xff;
                                l2++;
                            }

                    }

                bmf[k1 + bln * l1] = (i2 / l2 << 16) + (j2 / l2 << 8) + k2 / l2;
            }

        }

    }

    public static int cca(int i, int j, int k)
    {
        return (i << 16) + (j << 8) + k;
    }

    public void ccb()
    {
        for(int i = 0; i < bmj.length; i++)
        {
            bmj[i] = null;
            bmm[i] = 0;
            bmn[i] = 0;
            bmk[i] = null;
            bml[i] = null;
        }

    }

    public void ccc(int i, byte abyte0[], byte abyte1[], int j)
    {
        boolean flag = false;
        int k = fnf.fnm(abyte0, 0);
        int l = fnf.fnm(abyte1, k);
        k += 2;
        int i1 = fnf.fnm(abyte1, k);
        k += 2;
        int j1 = abyte1[k++] & 0xff;
        int ai[] = new int[j1];
        ai[0] = 0xff00ff;
        for(int k1 = 0; k1 < j1 - 1; k1++)
        {
            ai[k1 + 1] = ((abyte1[k] & 0xff) << 16) + ((abyte1[k + 1] & 0xff) << 8) + (abyte1[k + 2] & 0xff);
            k += 3;
        }

        int l1 = 2;
        for(int i2 = i; i2 < i + j; i2++)
        {
            bna[i2] = abyte1[k++] & 0xff;
            bnb[i2] = abyte1[k++] & 0xff;
            bmm[i2] = fnf.fnm(abyte1, k);
            k += 2;
            bmn[i2] = fnf.fnm(abyte1, k);
            k += 2;
            int j2 = abyte1[k++] & 0xff;
            int k2 = bmm[i2] * bmn[i2];
            bmk[i2] = new byte[k2];
            bml[i2] = ai;
            bnc[i2] = l;
            bnd[i2] = i1;
            bmj[i2] = null;
            bne[i2] = false;
            if(bna[i2] != 0 || bnb[i2] != 0)
                bne[i2] = true;
            if(j2 == 0)
            {
                for(int l2 = 0; l2 < k2; l2++)
                {
                    bmk[i2][l2] = abyte0[l1++];
                    if(bmk[i2][l2] == 0)
                        bne[i2] = true;
                }

            } else
            if(j2 == 1)
            {
                for(int i3 = 0; i3 < bmm[i2]; i3++)
                {
                    for(int j3 = 0; j3 < bmn[i2]; j3++)
                    {
                        bmk[i2][i3 + j3 * bmm[i2]] = abyte0[l1++];
                        if(bmk[i2][i3 + j3 * bmm[i2]] == 0)
                            bne[i2] = true;
                    }

                }

            }
        }

    }

    public void ccd(int i, byte abyte0[])
    {
        boolean flag = false;
        int ai[] = bmj[i] = new int[10200];
        bmm[i] = 255;
        bmn[i] = 40;
        bna[i] = 0;
        bnb[i] = 0;
        bnc[i] = 255;
        bnd[i] = 40;
        bne[i] = false;
        int j = 0;
        int k = 1;
        int l;
        for(l = 0; l < 255;)
        {
            int i1 = abyte0[k++] & 0xff;
            for(int k1 = 0; k1 < i1; k1++)
                ai[l++] = j;

            j = 0xffffff - j;
        }

        for(int j1 = 1; j1 < 40; j1++)
        {
            for(int l1 = 0; l1 < 255;)
            {
                int i2 = abyte0[k++] & 0xff;
                for(int j2 = 0; j2 < i2; j2++)
                {
                    ai[l] = ai[l - 255];
                    l++;
                    l1++;
                }

                if(l1 < 255)
                {
                    ai[l] = 0xffffff - ai[l - 255];
                    l++;
                    l1++;
                }
            }

        }

    }

    public void cce(int i)
    {
        boolean flag = false;
        int j = bmm[i] * bmn[i];
        int ai[] = bmj[i];
        int ai1[] = new int[32768];
        for(int k = 0; k < j; k++)
        {
            int l = ai[k];
            ai1[((l & 0xf80000) >> 9) + ((l & 0xf800) >> 6) + ((l & 0xf8) >> 3)]++;
        }

        int ai2[] = new int[256];
        ai2[0] = 0xff00ff;
        int ai3[] = new int[256];
        for(int i1 = 0; i1 < 32768; i1++)
        {
            int j1 = ai1[i1];
            if(j1 > ai3[255])
            {
                for(int k1 = 1; k1 < 256; k1++)
                {
                    if(j1 <= ai3[k1])
                        continue;
                    for(int i2 = 255; i2 > k1; i2--)
                    {
                        ai2[i2] = ai2[i2 - 1];
                        ai3[i2] = ai3[i2 - 1];
                    }

                    ai2[k1] = ((i1 & 0x7c00) << 9) + ((i1 & 0x3e0) << 6) + ((i1 & 0x1f) << 3) + 0x40404;
                    ai3[k1] = j1;
                    break;
                }

            }
            ai1[i1] = -1;
        }

        byte abyte0[] = new byte[j];
        for(int l1 = 0; l1 < j; l1++)
        {
            int j2 = ai[l1];
            int k2 = ((j2 & 0xf80000) >> 9) + ((j2 & 0xf800) >> 6) + ((j2 & 0xf8) >> 3);
            int l2 = ai1[k2];
            if(l2 == -1)
            {
                int i3 = 0x3b9ac9ff;
                int j3 = j2 >> 16 & 0xff;
                int k3 = j2 >> 8 & 0xff;
                int l3 = j2 & 0xff;
                for(int i4 = 0; i4 < 256; i4++)
                {
                    int j4 = ai2[i4];
                    int k4 = j4 >> 16 & 0xff;
                    int l4 = j4 >> 8 & 0xff;
                    int i5 = j4 & 0xff;
                    int j5 = (j3 - k4) * (j3 - k4) + (k3 - l4) * (k3 - l4) + (l3 - i5) * (l3 - i5);
                    if(j5 < i3)
                    {
                        i3 = j5;
                        l2 = i4;
                    }
                }

                ai1[k2] = l2;
            }
            abyte0[l1] = (byte)l2;
        }

        bmk[i] = abyte0;
        bml[i] = ai2;
        bmj[i] = null;
    }

    public void ccf(int i)
    {
        boolean flag = false;
        if(bmk[i] == null)
            return;
        int j = bmm[i] * bmn[i];
        byte abyte0[] = bmk[i];
        int ai[] = bml[i];
        int ai1[] = new int[j];
        for(int k = 0; k < j; k++)
        {
            int l = ai[abyte0[k] & 0xff];
            if(l == 0)
                l = 1;
            else
            if(l == 0xff00ff)
                l = 0;
            ai1[k] = l;
        }

        bmj[i] = ai1;
        bmk[i] = null;
        bml[i] = null;
    }

    public void ccg(int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        bmm[i] = l;
        bmn[i] = i1;
        bne[i] = false;
        bna[i] = 0;
        bnb[i] = 0;
        bnc[i] = l;
        bnd[i] = i1;
        int j1 = l * i1;
        int k1 = 0;
        bmj[i] = new int[j1];
        for(int l1 = j; l1 < j + l; l1++)
        {
            for(int i2 = k; i2 < k + i1; i2++)
                bmj[i][k1++] = bmf[l1 + i2 * bln];

        }

    }

    public void cch(int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        bmm[i] = l;
        bmn[i] = i1;
        bne[i] = false;
        bna[i] = 0;
        bnb[i] = 0;
        bnc[i] = l;
        bnd[i] = i1;
        int j1 = l * i1;
        int k1 = 0;
        bmj[i] = new int[j1];
        for(int l1 = k; l1 < k + i1; l1++)
        {
            for(int i2 = j; i2 < j + l; i2++)
                bmj[i][k1++] = bmf[i2 + l1 * bln];

        }

    }

    public void cci(int i, int j, int k)
    {
        if(bne[k])
        {
            i += bna[k];
            j += bnb[k];
        }
        int l = i + j * bln;
        int i1 = 0;
        int j1 = bmn[k];
        int k1 = bmm[k];
        int l1 = bln - k1;
        int i2 = 0;
        if(j < bnf)
        {
            int j2 = bnf - j;
            j1 -= j2;
            j = bnf;
            i1 = 0 + j2 * k1;
            l += j2 * bln;
        }
        if(j + j1 >= bng)
            j1 -= ((j + j1) - bng) + 1;
        if(i < bnh)
        {
            int k2 = bnh - i;
            k1 -= k2;
            i = bnh;
            i1 += k2;
            l += k2;
            i2 = 0 + k2;
            l1 += k2;
        }
        if(i + k1 >= bni)
        {
            int l2 = ((i + k1) - bni) + 1;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
            return;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            l1 += bln;
            i2 += bmm[k];
            if((j & 1) != 0)
            {
                l += bln;
                j1--;
            }
        }
        if(bmj[k] == null)
        {
            cda(bmf, bmk[k], bml[k], i1, l, k1, j1, l1, i2, byte0);
            return;
        } else
        {
            ccn(bmf, bmj[k], 0, i1, l, k1, j1, l1, i2, byte0);
            return;
        }
    }

    public void ccj(int i, int j, int k, int l, int i1)
    {
        try
        {
            int j1 = bmm[i1];
            int k1 = bmn[i1];
            int l1 = 0;
            int i2 = 0;
            int j2 = (j1 << 16) / k;
            int k2 = (k1 << 16) / l;
            if(bne[i1])
            {
                int l2 = bnc[i1];
                int j3 = bnd[i1];
                j2 = (l2 << 16) / k;
                k2 = (j3 << 16) / l;
                i += ((bna[i1] * k + l2) - 1) / l2;
                j += ((bnb[i1] * l + j3) - 1) / j3;
                if((bna[i1] * k) % l2 != 0)
                    l1 = (l2 - (bna[i1] * k) % l2 << 16) / k;
                if((bnb[i1] * l) % j3 != 0)
                    i2 = (j3 - (bnb[i1] * l) % j3 << 16) / l;
                k = (k * (bmm[i1] - (l1 >> 16))) / l2;
                l = (l * (bmn[i1] - (i2 >> 16))) / j3;
            }
            int i3 = i + j * bln;
            int k3 = bln - k;
            if(j < bnf)
            {
                int l3 = bnf - j;
                l -= l3;
                j = 0;
                i3 += l3 * bln;
                i2 += k2 * l3;
            }
            if(j + l >= bng)
                l -= ((j + l) - bng) + 1;
            if(i < bnh)
            {
                int i4 = bnh - i;
                k -= i4;
                i = 0;
                i3 += i4;
                l1 += j2 * i4;
                k3 += i4;
            }
            if(i + k >= bni)
            {
                int j4 = ((i + k) - bni) + 1;
                k -= j4;
                k3 += j4;
            }
            byte byte0 = 1;
            if(bnj)
            {
                byte0 = 2;
                k3 += bln;
                k2 += k2;
                if((j & 1) != 0)
                {
                    i3 += bln;
                    l--;
                }
            }
            cdb(bmf, bmj[i1], 0, l1, i2, i3, k3, k, l, j2, k2, j1, byte0);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void cck(int i, int j, int k, int l)
    {
        if(bne[k])
        {
            i += bna[k];
            j += bnb[k];
        }
        int i1 = i + j * bln;
        int j1 = 0;
        int k1 = bmn[k];
        int l1 = bmm[k];
        int i2 = bln - l1;
        int j2 = 0;
        if(j < bnf)
        {
            int k2 = bnf - j;
            k1 -= k2;
            j = bnf;
            j1 = 0 + k2 * l1;
            i1 += k2 * bln;
        }
        if(j + k1 >= bng)
            k1 -= ((j + k1) - bng) + 1;
        if(i < bnh)
        {
            int l2 = bnh - i;
            l1 -= l2;
            i = bnh;
            j1 += l2;
            i1 += l2;
            j2 = 0 + l2;
            i2 += l2;
        }
        if(i + l1 >= bni)
        {
            int i3 = ((i + l1) - bni) + 1;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(l1 <= 0 || k1 <= 0)
            return;
        byte byte0 = 1;
        if(bnj)
        {
            byte0 = 2;
            i2 += bln;
            j2 += bmm[k];
            if((j & 1) != 0)
            {
                i1 += bln;
                k1--;
            }
        }
        if(bmj[k] == null)
        {
            cdd(bmf, bmk[k], bml[k], j1, i1, l1, k1, i2, j2, byte0, l);
            return;
        } else
        {
            cdc(bmf, bmj[k], 0, j1, i1, l1, k1, i2, j2, byte0, l);
            return;
        }
    }

    public void ccl(int i, int j, int k, int l, int i1, int j1)
    {
        try
        {
            int k1 = bmm[i1];
            int l1 = bmn[i1];
            int i2 = 0;
            int j2 = 0;
            int k2 = (k1 << 16) / k;
            int l2 = (l1 << 16) / l;
            if(bne[i1])
            {
                int i3 = bnc[i1];
                int k3 = bnd[i1];
                k2 = (i3 << 16) / k;
                l2 = (k3 << 16) / l;
                i += ((bna[i1] * k + i3) - 1) / i3;
                j += ((bnb[i1] * l + k3) - 1) / k3;
                if((bna[i1] * k) % i3 != 0)
                    i2 = (i3 - (bna[i1] * k) % i3 << 16) / k;
                if((bnb[i1] * l) % k3 != 0)
                    j2 = (k3 - (bnb[i1] * l) % k3 << 16) / l;
                k = (k * (bmm[i1] - (i2 >> 16))) / i3;
                l = (l * (bmn[i1] - (j2 >> 16))) / k3;
            }
            int j3 = i + j * bln;
            int l3 = bln - k;
            if(j < bnf)
            {
                int i4 = bnf - j;
                l -= i4;
                j = 0;
                j3 += i4 * bln;
                j2 += l2 * i4;
            }
            if(j + l >= bng)
                l -= ((j + l) - bng) + 1;
            if(i < bnh)
            {
                int j4 = bnh - i;
                k -= j4;
                i = 0;
                j3 += j4;
                i2 += k2 * j4;
                l3 += j4;
            }
            if(i + k >= bni)
            {
                int k4 = ((i + k) - bni) + 1;
                k -= k4;
                l3 += k4;
            }
            byte byte0 = 1;
            if(bnj)
            {
                byte0 = 2;
                l3 += bln;
                l2 += l2;
                if((j & 1) != 0)
                {
                    j3 += bln;
                    l--;
                }
            }
            cde(bmf, bmj[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void ccm(int i, int j, int k, int l, int i1, int j1)
    {
        try
        {
            int k1 = bmm[i1];
            int l1 = bmn[i1];
            int i2 = 0;
            int j2 = 0;
            int k2 = (k1 << 16) / k;
            int l2 = (l1 << 16) / l;
            if(bne[i1])
            {
                int i3 = bnc[i1];
                int k3 = bnd[i1];
                k2 = (i3 << 16) / k;
                l2 = (k3 << 16) / l;
                i += ((bna[i1] * k + i3) - 1) / i3;
                j += ((bnb[i1] * l + k3) - 1) / k3;
                if((bna[i1] * k) % i3 != 0)
                    i2 = (i3 - (bna[i1] * k) % i3 << 16) / k;
                if((bnb[i1] * l) % k3 != 0)
                    j2 = (k3 - (bnb[i1] * l) % k3 << 16) / l;
                k = (k * (bmm[i1] - (i2 >> 16))) / i3;
                l = (l * (bmn[i1] - (j2 >> 16))) / k3;
            }
            int j3 = i + j * bln;
            int l3 = bln - k;
            if(j < bnf)
            {
                int i4 = bnf - j;
                l -= i4;
                j = 0;
                j3 += i4 * bln;
                j2 += l2 * i4;
            }
            if(j + l >= bng)
                l -= ((j + l) - bng) + 1;
            if(i < bnh)
            {
                int j4 = bnh - i;
                k -= j4;
                i = 0;
                j3 += j4;
                i2 += k2 * j4;
                l3 += j4;
            }
            if(i + k >= bni)
            {
                int k4 = ((i + k) - bni) + 1;
                k -= k4;
                l3 += k4;
            }
            byte byte0 = 1;
            if(bnj)
            {
                byte0 = 2;
                l3 += bln;
                l2 += l2;
                if((j & 1) != 0)
                {
                    j3 += bln;
                    l--;
                }
            }
            cdf(bmf, bmj[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void ccn(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        boolean flag = false;
        int i2 = -(l >> 2);
        l = -(l & 3);
        for(int j2 = -i1; j2 < 0; j2 += l1)
        {
            for(int k2 = i2; k2 < 0; k2++)
            {
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            for(int l2 = l; l2 < 0; l2++)
            {
                i = ai1[j++];
                if(i != 0)
                    ai[k++] = i;
                else
                    k++;
            }

            k += j1;
            j += k1;
        }

    }

    private void cda(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1)
    {
        boolean flag = false;
        int l1 = -(k >> 2);
        k = -(k & 3);
        for(int i2 = -l; i2 < 0; i2 += k1)
        {
            for(int j2 = l1; j2 < 0; j2++)
            {
                byte byte0 = abyte0[i++];
                if(byte0 != 0)
                    ai[j++] = ai1[byte0 & 0xff];
                else
                    j++;
                byte0 = abyte0[i++];
                if(byte0 != 0)
                    ai[j++] = ai1[byte0 & 0xff];
                else
                    j++;
                byte0 = abyte0[i++];
                if(byte0 != 0)
                    ai[j++] = ai1[byte0 & 0xff];
                else
                    j++;
                byte0 = abyte0[i++];
                if(byte0 != 0)
                    ai[j++] = ai1[byte0 & 0xff];
                else
                    j++;
            }

            for(int k2 = k; k2 < 0; k2++)
            {
                byte byte1 = abyte0[i++];
                if(byte1 != 0)
                    ai[j++] = ai1[byte1 & 0xff];
                else
                    j++;
            }

            j += i1;
            i += j1;
        }

    }

    private void cdb(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2)
    {
        boolean flag = false;
        try
        {
            int l2 = j;
            for(int i3 = -k1; i3 < 0; i3 += k2)
            {
                int j3 = (k >> 16) * j2;
                for(int k3 = -j1; k3 < 0; k3++)
                {
                    i = ai1[(j >> 16) + j3];
                    if(i != 0)
                        ai[l++] = i;
                    else
                        l++;
                    j += l1;
                }

                k += i2;
                j = l2;
                l += i1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    private void cdc(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2)
    {
        boolean flag = false;
        int j2 = 256 - i2;
        for(int k2 = -i1; k2 < 0; k2 += l1)
        {
            for(int l2 = -l; l2 < 0; l2++)
            {
                i = ai1[j++];
                if(i != 0)
                {
                    int i3 = ai[k];
                    ai[k++] = ((i & 0xff00ff) * i2 + (i3 & 0xff00ff) * j2 & 0xff00ff00) + ((i & 0xff00) * i2 + (i3 & 0xff00) * j2 & 0xff0000) >> 8;
                } else
                {
                    k++;
                }
            }

            k += j1;
            j += k1;
        }

    }

    private void cdd(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1)
    {
        boolean flag = false;
        int i2 = 256 - l1;
        for(int j2 = -l; j2 < 0; j2 += k1)
        {
            for(int k2 = -k; k2 < 0; k2++)
            {
                int l2 = abyte0[i++];
                if(l2 != 0)
                {
                    l2 = ai1[l2 & 0xff];
                    int i3 = ai[j];
                    ai[j++] = ((l2 & 0xff00ff) * l1 + (i3 & 0xff00ff) * i2 & 0xff00ff00) + ((l2 & 0xff00) * l1 + (i3 & 0xff00) * i2 & 0xff0000) >> 8;
                } else
                {
                    j++;
                }
            }

            j += i1;
            i += j1;
        }

    }

    private void cde(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2)
    {
        boolean flag = false;
        int i3 = 256 - l2;
        try
        {
            int j3 = j;
            for(int k3 = -k1; k3 < 0; k3 += k2)
            {
                int l3 = (k >> 16) * j2;
                for(int i4 = -j1; i4 < 0; i4++)
                {
                    i = ai1[(j >> 16) + l3];
                    if(i != 0)
                    {
                        int j4 = ai[l];
                        ai[l++] = ((i & 0xff00ff) * l2 + (j4 & 0xff00ff) * i3 & 0xff00ff00) + ((i & 0xff00) * l2 + (j4 & 0xff00) * i3 & 0xff0000) >> 8;
                    } else
                    {
                        l++;
                    }
                    j += l1;
                }

                k += i2;
                j = j3;
                l += i1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in tran_scale");
        }
    }

    private void cdf(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2)
    {
        boolean flag = false;
        int i3 = l2 >> 16 & 0xff;
        int j3 = l2 >> 8 & 0xff;
        int k3 = l2 & 0xff;
        try
        {
            int l3 = j;
            for(int i4 = -k1; i4 < 0; i4 += k2)
            {
                int j4 = (k >> 16) * j2;
                for(int k4 = -j1; k4 < 0; k4++)
                {
                    i = ai1[(j >> 16) + j4];
                    if(i != 0)
                    {
                        int l4 = i >> 16 & 0xff;
                        int i5 = i >> 8 & 0xff;
                        int j5 = i & 0xff;
                        if(l4 == i5 && i5 == j5)
                            ai[l++] = ((l4 * i3 >> 8) << 16) + ((i5 * j3 >> 8) << 8) + (j5 * k3 >> 8);
                        else
                            ai[l++] = i;
                    } else
                    {
                        l++;
                    }
                    j += l1;
                }

                k += i2;
                j = l3;
                l += i1;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    public void cdg(int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        int j1 = bln;
        int k1 = bma;
        if(bnn == null)
        {
            bnn = new int[512];
            for(int l1 = 0; l1 < 256; l1++)
            {
                bnn[l1] = (int)(Math.sin((double)l1 * 0.02454369D) * 32768D);
                bnn[l1 + 256] = (int)(Math.cos((double)l1 * 0.02454369D) * 32768D);
            }

        }
        int i2 = -bnc[k] / 2;
        int j2 = -bnd[k] / 2;
        if(bne[k])
        {
            i2 += bna[k];
            j2 += bnb[k];
        }
        int k2 = i2 + bmm[k];
        int l2 = j2 + bmn[k];
        int i3 = k2;
        int j3 = j2;
        int k3 = i2;
        int l3 = l2;
        l &= 0xff;
        int i4 = bnn[l] * i1;
        int j4 = bnn[l + 256] * i1;
        int k4 = i + (j2 * i4 + i2 * j4 >> 22);
        int l4 = j + (j2 * j4 - i2 * i4 >> 22);
        int i5 = i + (j3 * i4 + i3 * j4 >> 22);
        int j5 = j + (j3 * j4 - i3 * i4 >> 22);
        int k5 = i + (l2 * i4 + k2 * j4 >> 22);
        int l5 = j + (l2 * j4 - k2 * i4 >> 22);
        int i6 = i + (l3 * i4 + k3 * j4 >> 22);
        int j6 = j + (l3 * j4 - k3 * i4 >> 22);
        if(i1 == 192 && (l & 0x3f) == (cai & 0x3f))
            cag++;
        else
        if(i1 == 128)
            cai = l;
        else
            cah++;
        int k6 = l4;
        int l6 = l4;
        if(j5 < k6)
            k6 = j5;
        else
        if(j5 > l6)
            l6 = j5;
        if(l5 < k6)
            k6 = l5;
        else
        if(l5 > l6)
            l6 = l5;
        if(j6 < k6)
            k6 = j6;
        else
        if(j6 > l6)
            l6 = j6;
        if(k6 < bnf)
            k6 = bnf;
        if(l6 > bng)
            l6 = bng;
        if(caa == null || caa.length != k1 + 1)
        {
            caa = new int[k1 + 1];
            cab = new int[k1 + 1];
            cac = new int[k1 + 1];
            cad = new int[k1 + 1];
            cae = new int[k1 + 1];
            caf = new int[k1 + 1];
        }
        for(int i7 = k6; i7 <= l6; i7++)
        {
            caa[i7] = 0x5f5e0ff;
            cab[i7] = 0xfa0a1f01;
        }

        int i8 = 0;
        int k8 = 0;
        int i9 = 0;
        int j9 = bmm[k];
        int k9 = bmn[k];
        i2 = 0;
        j2 = 0;
        i3 = j9 - 1;
        j3 = 0;
        k2 = j9 - 1;
        l2 = k9 - 1;
        k3 = 0;
        l3 = k9 - 1;
        if(j6 != l4)
        {
            i8 = (i6 - k4 << 8) / (j6 - l4);
            i9 = (l3 - 0 << 8) / (j6 - l4);
        }
        int j7;
        int k7;
        int l7;
        int l8;
        if(l4 > j6)
        {
            l7 = i6 << 8;
            l8 = l3 << 8;
            j7 = j6;
            k7 = l4;
        } else
        {
            l7 = k4 << 8;
            l8 = 0;
            j7 = l4;
            k7 = j6;
        }
        if(j7 < 0)
        {
            l7 -= i8 * j7;
            l8 -= i9 * j7;
            j7 = 0;
        }
        if(k7 > k1 - 1)
            k7 = k1 - 1;
        for(int l9 = j7; l9 <= k7; l9++)
        {
            caa[l9] = cab[l9] = l7;
            l7 += i8;
            cac[l9] = cad[l9] = 0;
            cae[l9] = caf[l9] = l8;
            l8 += i9;
        }

        if(j5 != l4)
        {
            i8 = (i5 - k4 << 8) / (j5 - l4);
            k8 = (i3 - 0 << 8) / (j5 - l4);
        }
        int j8;
        if(l4 > j5)
        {
            l7 = i5 << 8;
            j8 = i3 << 8;
            j7 = j5;
            k7 = l4;
        } else
        {
            l7 = k4 << 8;
            j8 = 0;
            j7 = l4;
            k7 = j5;
        }
        if(j7 < 0)
        {
            l7 -= i8 * j7;
            j8 -= k8 * j7;
            j7 = 0;
        }
        if(k7 > k1 - 1)
            k7 = k1 - 1;
        for(int i10 = j7; i10 <= k7; i10++)
        {
            if(l7 < caa[i10])
            {
                caa[i10] = l7;
                cac[i10] = j8;
                cae[i10] = 0;
            }
            if(l7 > cab[i10])
            {
                cab[i10] = l7;
                cad[i10] = j8;
                caf[i10] = 0;
            }
            l7 += i8;
            j8 += k8;
        }

        if(l5 != j5)
        {
            i8 = (k5 - i5 << 8) / (l5 - j5);
            i9 = (l2 - 0 << 8) / (l5 - j5);
        }
        if(j5 > l5)
        {
            l7 = k5 << 8;
            j8 = k2 << 8;
            l8 = l2 << 8;
            j7 = l5;
            k7 = j5;
        } else
        {
            l7 = i5 << 8;
            j8 = i3 << 8;
            l8 = 0;
            j7 = j5;
            k7 = l5;
        }
        if(j7 < 0)
        {
            l7 -= i8 * j7;
            l8 -= i9 * j7;
            j7 = 0;
        }
        if(k7 > k1 - 1)
            k7 = k1 - 1;
        for(int j10 = j7; j10 <= k7; j10++)
        {
            if(l7 < caa[j10])
            {
                caa[j10] = l7;
                cac[j10] = j8;
                cae[j10] = l8;
            }
            if(l7 > cab[j10])
            {
                cab[j10] = l7;
                cad[j10] = j8;
                caf[j10] = l8;
            }
            l7 += i8;
            l8 += i9;
        }

        if(j6 != l5)
        {
            i8 = (i6 - k5 << 8) / (j6 - l5);
            k8 = (0 - k2 << 8) / (j6 - l5);
        }
        if(l5 > j6)
        {
            l7 = i6 << 8;
            j8 = 0;
            l8 = l3 << 8;
            j7 = j6;
            k7 = l5;
        } else
        {
            l7 = k5 << 8;
            j8 = k2 << 8;
            l8 = l2 << 8;
            j7 = l5;
            k7 = j6;
        }
        if(j7 < 0)
        {
            l7 -= i8 * j7;
            j8 -= k8 * j7;
            j7 = 0;
        }
        if(k7 > k1 - 1)
            k7 = k1 - 1;
        for(int k10 = j7; k10 <= k7; k10++)
        {
            if(l7 < caa[k10])
            {
                caa[k10] = l7;
                cac[k10] = j8;
                cae[k10] = l8;
            }
            if(l7 > cab[k10])
            {
                cab[k10] = l7;
                cad[k10] = j8;
                caf[k10] = l8;
            }
            l7 += i8;
            j8 += k8;
        }

        int l10 = k6 * j1;
        int ai[] = bmj[k];
        for(int i11 = k6; i11 < l6; i11++)
        {
            int j11 = caa[i11] >> 8;
            int k11 = cab[i11] >> 8;
            if(k11 - j11 <= 0)
            {
                l10 += j1;
            } else
            {
                int l11 = cac[i11] << 9;
                int i12 = ((cad[i11] << 9) - l11) / (k11 - j11);
                int j12 = cae[i11] << 9;
                int k12 = ((caf[i11] << 9) - j12) / (k11 - j11);
                if(j11 < bnh)
                {
                    l11 += (bnh - j11) * i12;
                    j12 += (bnh - j11) * k12;
                    j11 = bnh;
                }
                if(k11 > bni)
                    k11 = bni;
                if(!bnj || (i11 & 1) == 0)
                    if(!bne[k])
                        cdh(bmf, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
                    else
                        cdi(bmf, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
                l10 += j1;
            }
        }

    }

    private void cdh(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        for(i = k1; i < 0; i++)
        {
            bmf[j++] = ai1[(k >> 17) + (l >> 17) * l1];
            k += i1;
            l += j1;
        }

    }

    private void cdi(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        boolean flag = false;
        for(int i2 = k1; i2 < 0; i2++)
        {
            i = ai1[(k >> 17) + (l >> 17) * l1];
            if(i != 0)
                bmf[j++] = i;
            else
                j++;
            k += i1;
            l += j1;
        }

    }

    public void cdj(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        ccj(i, j, k, l, i1);
    }

    public void cdk(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        try
        {
            if(j1 == 0)
                j1 = 0xffffff;
            if(k1 == 0)
                k1 = 0xffffff;
            int i2 = bmm[i1];
            int j2 = bmn[i1];
            int k2 = 0;
            int l2 = 0;
            int i3 = l1 << 16;
            int j3 = (i2 << 16) / k;
            int k3 = (j2 << 16) / l;
            int l3 = -(l1 << 16) / l;
            if(bne[i1])
            {
                int i4 = bnc[i1];
                int k4 = bnd[i1];
                j3 = (i4 << 16) / k;
                k3 = (k4 << 16) / l;
                int j5 = bna[i1];
                int k5 = bnb[i1];
                if(flag)
                    j5 = i4 - bmm[i1] - j5;
                i += ((j5 * k + i4) - 1) / i4;
                int l5 = ((k5 * l + k4) - 1) / k4;
                j += l5;
                i3 += l5 * l3;
                if((j5 * k) % i4 != 0)
                    k2 = (i4 - (j5 * k) % i4 << 16) / k;
                if((k5 * l) % k4 != 0)
                    l2 = (k4 - (k5 * l) % k4 << 16) / l;
                k = ((((bmm[i1] << 16) - k2) + j3) - 1) / j3;
                l = ((((bmn[i1] << 16) - l2) + k3) - 1) / k3;
            }
            int j4 = j * bln;
            i3 += i << 16;
            if(j < bnf)
            {
                int l4 = bnf - j;
                l -= l4;
                j = bnf;
                j4 += l4 * bln;
                l2 += k3 * l4;
                i3 += l3 * l4;
            }
            if(j + l >= bng)
                l -= ((j + l) - bng) + 1;
            int i5 = j4 / bln & 1;
            if(!bnj)
                i5 = 2;
            if(k1 == 0xffffff)
            {
                if(bmj[i1] != null)
                    if(!flag)
                    {
                        cdl(bmf, bmj[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
                        return;
                    } else
                    {
                        cdl(bmf, bmj[i1], 0, (bmm[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
                        return;
                    }
                if(!flag)
                {
                    cdn(bmf, bmk[i1], bml[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
                    return;
                } else
                {
                    cdn(bmf, bmk[i1], bml[i1], 0, (bmm[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
                    return;
                }
            }
            if(bmj[i1] != null)
                if(!flag)
                {
                    cdm(bmf, bmj[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
                    return;
                } else
                {
                    cdm(bmf, bmj[i1], 0, (bmm[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
                    return;
                }
            if(!flag)
            {
                cea(bmf, bmk[i1], bml[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
                return;
            } else
            {
                cea(bmf, bmk[i1], bml[i1], 0, (bmm[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
                return;
            }
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void cdl(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3)
    {
        boolean flag = false;
        int i4 = j2 >> 16 & 0xff;
        int j4 = j2 >> 8 & 0xff;
        int k4 = j2 & 0xff;
        try
        {
            int l4 = j;
            for(int i5 = -j1; i5 < 0; i5++)
            {
                int j5 = (k >> 16) * i2;
                int k5 = k2 >> 16;
                int l5 = i1;
                if(k5 < bnh)
                {
                    int i6 = bnh - k5;
                    l5 -= i6;
                    k5 = bnh;
                    j += k1 * i6;
                }
                if(k5 + l5 >= bni)
                {
                    int j6 = (k5 + l5) - bni;
                    l5 -= j6;
                }
                i3 = 1 - i3;
                if(i3 != 0)
                {
                    for(int k6 = k5; k6 < k5 + l5; k6++)
                    {
                        i = ai1[(j >> 16) + j5];
                        if(i != 0)
                        {
                            int j3 = i >> 16 & 0xff;
                            int k3 = i >> 8 & 0xff;
                            int l3 = i & 0xff;
                            if(j3 == k3 && k3 == l3)
                                ai[k6 + l] = ((j3 * i4 >> 8) << 16) + ((k3 * j4 >> 8) << 8) + (l3 * k4 >> 8);
                            else
                                ai[k6 + l] = i;
                        }
                        j += k1;
                    }

                }
                k += l1;
                j = l4;
                l += bln;
                k2 += l2;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void cdm(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3, int j3)
    {
        boolean flag = false;
        int j4 = j2 >> 16 & 0xff;
        int k4 = j2 >> 8 & 0xff;
        int l4 = j2 & 0xff;
        int i5 = k2 >> 16 & 0xff;
        int j5 = k2 >> 8 & 0xff;
        int k5 = k2 & 0xff;
        try
        {
            int l5 = j;
            for(int i6 = -j1; i6 < 0; i6++)
            {
                int j6 = (k >> 16) * i2;
                int k6 = l2 >> 16;
                int l6 = i1;
                if(k6 < bnh)
                {
                    int i7 = bnh - k6;
                    l6 -= i7;
                    k6 = bnh;
                    j += k1 * i7;
                }
                if(k6 + l6 >= bni)
                {
                    int j7 = (k6 + l6) - bni;
                    l6 -= j7;
                }
                j3 = 1 - j3;
                if(j3 != 0)
                {
                    for(int k7 = k6; k7 < k6 + l6; k7++)
                    {
                        i = ai1[(j >> 16) + j6];
                        if(i != 0)
                        {
                            int k3 = i >> 16 & 0xff;
                            int l3 = i >> 8 & 0xff;
                            int i4 = i & 0xff;
                            if(k3 == l3 && l3 == i4)
                                ai[k7 + l] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
                            else
                            if(k3 == 255 && l3 == i4)
                                ai[k7 + l] = ((k3 * i5 >> 8) << 16) + ((l3 * j5 >> 8) << 8) + (i4 * k5 >> 8);
                            else
                                ai[k7 + l] = i;
                        }
                        j += k1;
                    }

                }
                k += l1;
                j = l5;
                l += bln;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void cdn(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, int i3)
    {
        boolean flag = false;
        int i4 = j2 >> 16 & 0xff;
        int j4 = j2 >> 8 & 0xff;
        int k4 = j2 & 0xff;
        try
        {
            int l4 = j;
            for(int i5 = -j1; i5 < 0; i5++)
            {
                int j5 = (k >> 16) * i2;
                int k5 = k2 >> 16;
                int l5 = i1;
                if(k5 < bnh)
                {
                    int i6 = bnh - k5;
                    l5 -= i6;
                    k5 = bnh;
                    j += k1 * i6;
                }
                if(k5 + l5 >= bni)
                {
                    int j6 = (k5 + l5) - bni;
                    l5 -= j6;
                }
                i3 = 1 - i3;
                if(i3 != 0)
                {
                    for(int k6 = k5; k6 < k5 + l5; k6++)
                    {
                        i = abyte0[(j >> 16) + j5] & 0xff;
                        if(i != 0)
                        {
                            i = ai1[i];
                            int j3 = i >> 16 & 0xff;
                            int k3 = i >> 8 & 0xff;
                            int l3 = i & 0xff;
                            if(j3 == k3 && k3 == l3)
                                ai[k6 + l] = ((j3 * i4 >> 8) << 16) + ((k3 * j4 >> 8) << 8) + (l3 * k4 >> 8);
                            else
                                ai[k6 + l] = i;
                        }
                        j += k1;
                    }

                }
                k += l1;
                j = l4;
                l += bln;
                k2 += l2;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void cea(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, int i3, int j3)
    {
        boolean flag = false;
        int j4 = j2 >> 16 & 0xff;
        int k4 = j2 >> 8 & 0xff;
        int l4 = j2 & 0xff;
        int i5 = k2 >> 16 & 0xff;
        int j5 = k2 >> 8 & 0xff;
        int k5 = k2 & 0xff;
        try
        {
            int l5 = j;
            for(int i6 = -j1; i6 < 0; i6++)
            {
                int j6 = (k >> 16) * i2;
                int k6 = l2 >> 16;
                int l6 = i1;
                if(k6 < bnh)
                {
                    int i7 = bnh - k6;
                    l6 -= i7;
                    k6 = bnh;
                    j += k1 * i7;
                }
                if(k6 + l6 >= bni)
                {
                    int j7 = (k6 + l6) - bni;
                    l6 -= j7;
                }
                j3 = 1 - j3;
                if(j3 != 0)
                {
                    for(int k7 = k6; k7 < k6 + l6; k7++)
                    {
                        i = abyte0[(j >> 16) + j6] & 0xff;
                        if(i != 0)
                        {
                            i = ai1[i];
                            int k3 = i >> 16 & 0xff;
                            int l3 = i >> 8 & 0xff;
                            int i4 = i & 0xff;
                            if(k3 == l3 && l3 == i4)
                                ai[k7 + l] = ((k3 * j4 >> 8) << 16) + ((l3 * k4 >> 8) << 8) + (i4 * l4 >> 8);
                            else
                            if(k3 == 255 && l3 == i4)
                                ai[k7 + l] = ((k3 * i5 >> 8) << 16) + ((l3 * j5 >> 8) << 8) + (i4 * k5 >> 8);
                            else
                                ai[k7 + l] = i;
                        }
                        j += k1;
                    }

                }
                k += l1;
                j = l5;
                l += bln;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    public static void ceb(String s, int i, fjb fjb1)
    {
        boolean flag2 = false;
        boolean flag = false;
        boolean flag1 = false;
        s = s.toLowerCase();
        if(s.startsWith("helvetica"))
            s = s.substring(9);
        if(s.startsWith("h"))
            s = s.substring(1);
        if(s.startsWith("f"))
        {
            s = s.substring(1);
            flag = true;
        }
        if(s.startsWith("d"))
        {
            s = s.substring(1);
            flag1 = true;
        }
        if(s.endsWith(".jf"))
            s = s.substring(0, s.length() - 3);
        int j = 0;
        if(s.endsWith("b"))
        {
            j = 1;
            s = s.substring(0, s.length() - 1);
        }
        if(s.endsWith("p"))
            s = s.substring(0, s.length() - 1);
        int k = Integer.parseInt(s);
        Font font = new Font("Helvetica", j, k);
        FontMetrics fontmetrics = fjb1.getFontMetrics(font);
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        cak = 855;
        for(int l = 0; l < 95; l++)
            cec(font, fontmetrics, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(l), l, fjb1, i, flag1);

        bnk[i] = new byte[cak];
        for(int i1 = 0; i1 < cak; i1++)
            bnk[i][i1] = cal[i1];

        if(j == 1 && caj[i])
        {
            caj[i] = false;
            ceb("f" + k + "p", i, fjb1);
        }
        if(flag && !caj[i])
        {
            caj[i] = false;
            ceb("d" + k + "p", i, fjb1);
        }
    }

    public static void cec(Font font, FontMetrics fontmetrics, char c, int i, fjb fjb1, int j, boolean flag)
    {
        boolean flag1 = false;
        int k = fontmetrics.charWidth(c);
        int l = k;
        if(flag)
            try
            {
                if(c == '/')
                    flag = false;
                if(c == 'f' || c == 't' || c == 'w' || c == 'v' || c == 'k' || c == 'x' || c == 'y' || c == 'A' || c == 'V' || c == 'W')
                    k++;
            }
            catch(Exception _ex) { }
        int i1 = fontmetrics.getMaxAscent();
        int j1 = fontmetrics.getMaxAscent() + fontmetrics.getMaxDescent();
        int k1 = fontmetrics.getHeight();
        Image image = fjb1.createImage(k, j1);
        Graphics g = image.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, k, j1);
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(String.valueOf(c), 0, i1);
        if(flag)
            g.drawString(String.valueOf(c), 1, i1);
        int ai[] = new int[k * j1];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, j1, ai, 0, k);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex)
        {
            return;
        }
        image.flush();
        image = null;
        int l1 = 0;
        int i2 = 0;
        int j2 = k;
        int k2 = j1;
label0:
        for(int l2 = 0; l2 < j1; l2++)
        {
            for(int i3 = 0; i3 < k; i3++)
            {
                int k3 = ai[i3 + l2 * k];
                if((k3 & 0xffffff) == 0)
                    continue;
                i2 = l2;
                break label0;
            }

        }

label1:
        for(int j3 = 0; j3 < k; j3++)
        {
            for(int l3 = 0; l3 < j1; l3++)
            {
                int j4 = ai[j3 + l3 * k];
                if((j4 & 0xffffff) == 0)
                    continue;
                l1 = j3;
                break label1;
            }

        }

label2:
        for(int i4 = j1 - 1; i4 >= 0; i4--)
        {
            for(int k4 = 0; k4 < k; k4++)
            {
                int i5 = ai[k4 + i4 * k];
                if((i5 & 0xffffff) == 0)
                    continue;
                k2 = i4 + 1;
                break label2;
            }

        }

label3:
        for(int l4 = k - 1; l4 >= 0; l4--)
        {
            for(int j5 = 0; j5 < j1; j5++)
            {
                int l5 = ai[l4 + j5 * k];
                if((l5 & 0xffffff) == 0)
                    continue;
                j2 = l4 + 1;
                break label3;
            }

        }

        cal[i * 9] = (byte)(cak / 16384);
        cal[i * 9 + 1] = (byte)(cak / 128 & 0x7f);
        cal[i * 9 + 2] = (byte)(cak & 0x7f);
        cal[i * 9 + 3] = (byte)(j2 - l1);
        cal[i * 9 + 4] = (byte)(k2 - i2);
        cal[i * 9 + 5] = (byte)l1;
        cal[i * 9 + 6] = (byte)(i1 - i2);
        cal[i * 9 + 7] = (byte)l;
        cal[i * 9 + 8] = (byte)k1;
        for(int k5 = i2; k5 < k2; k5++)
        {
            for(int i6 = l1; i6 < j2; i6++)
            {
                int j6 = ai[i6 + k5 * k] & 0xff;
                if(j6 > 30 && j6 < 230)
                    caj[j] = true;
                cal[cak++] = (byte)j6;
            }

        }

    }

    public void ced(String s, int i, int j, int k, int l)
    {
        ceg(s, i - cem(s, k), j, k, l);
    }

    public void cee(String s, int i, int j, int k, int l)
    {
        ceg(s, i - cem(s, k) / 2, j, k, l);
    }

    public void cef(String s, int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        try
        {
            int j1 = 0;
            byte abyte0[] = bnk[k];
            int k1 = 0;
            int l1 = 0;
            for(int i2 = 0; i2 < s.length(); i2++)
            {
                if(s.charAt(i2) == '@' && i2 + 4 < s.length() && s.charAt(i2 + 4) == '@')
                    i2 += 4;
                else
                if(s.charAt(i2) == '~' && i2 + 4 < s.length() && s.charAt(i2 + 4) == '~')
                    i2 += 4;
                else
                    j1 += abyte0[bnl[s.charAt(i2)] + 7];
                if(s.charAt(i2) == ' ')
                    l1 = i2;
                if(s.charAt(i2) == '%')
                {
                    l1 = i2;
                    j1 = 1000;
                }
                if(j1 > i1)
                {
                    if(l1 <= k1)
                        l1 = i2;
                    cee(s.substring(k1, l1), i, j, k, l);
                    j1 = 0;
                    k1 = i2 = l1 + 1;
                    j += cek(k);
                }
            }

            if(j1 > 0)
            {
                cee(s.substring(k1), i, j, k, l);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println("centrepara: " + exception);
            exception.printStackTrace();
        }
    }

    public void ceg(String s, int i, int j, int k, int l)
    {
        boolean flag = false;
        try
        {
            byte abyte0[] = bnk[k];
            for(int i1 = 0; i1 < s.length(); i1++)
                if(s.charAt(i1) == '@' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '@')
                {
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("red"))
                        l = 0xff0000;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("lre"))
                        l = 0xff9040;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("yel"))
                        l = 0xffff00;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gre"))
                        l = 65280;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("blu"))
                        l = 255;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("cya"))
                        l = 65535;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("mag"))
                        l = 0xff00ff;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("whi"))
                        l = 0xffffff;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("bla"))
                        l = 0;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("dre"))
                        l = 0xc00000;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("ora"))
                        l = 0xff9040;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("ran"))
                        l = (int)(Math.random() * 16777215D);
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or1"))
                        l = 0xffb000;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or2"))
                        l = 0xff7000;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("or3"))
                        l = 0xff3000;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr1"))
                        l = 0xc0ff00;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr2"))
                        l = 0x80ff00;
                    else
                    if(s.substring(i1 + 1, i1 + 4).equalsIgnoreCase("gr3"))
                        l = 0x40ff00;
                    i1 += 4;
                } else
                if(s.charAt(i1) == '~' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '~')
                {
                    char c = s.charAt(i1 + 1);
                    char c1 = s.charAt(i1 + 2);
                    char c2 = s.charAt(i1 + 3);
                    if(c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9')
                        i = Integer.parseInt(s.substring(i1 + 1, i1 + 4));
                    i1 += 4;
                } else
                {
                    int j1 = bnl[s.charAt(i1)];
                    if(bnm && !caj[k] && l != 0)
                        ceh(j1, i + 1, j, 0, abyte0, caj[k]);
                    if(bnm && !caj[k] && l != 0)
                        ceh(j1, i, j + 1, 0, abyte0, caj[k]);
                    ceh(j1, i, j, l, abyte0, caj[k]);
                    i += abyte0[j1 + 7];
                }

            return;
        }
        catch(Exception exception)
        {
            System.out.println("drawstring: " + exception);
            exception.printStackTrace();
            return;
        }
    }

    private void ceh(int i, int j, int k, int l, byte abyte0[], boolean flag)
    {
        int i1 = j + abyte0[i + 5];
        int j1 = k - abyte0[i + 6];
        int k1 = abyte0[i + 3];
        int l1 = abyte0[i + 4];
        int i2 = abyte0[i] * 16384 + abyte0[i + 1] * 128 + abyte0[i + 2];
        int j2 = i1 + j1 * bln;
        int k2 = bln - k1;
        int l2 = 0;
        if(j1 < bnf)
        {
            int i3 = bnf - j1;
            l1 -= i3;
            j1 = bnf;
            i2 += i3 * k1;
            j2 += i3 * bln;
        }
        if(j1 + l1 >= bng)
            l1 -= ((j1 + l1) - bng) + 1;
        if(i1 < bnh)
        {
            int j3 = bnh - i1;
            k1 -= j3;
            i1 = bnh;
            i2 += j3;
            j2 += j3;
            l2 = 0 + j3;
            k2 += j3;
        }
        if(i1 + k1 >= bni)
        {
            int k3 = ((i1 + k1) - bni) + 1;
            k1 -= k3;
            l2 += k3;
            k2 += k3;
        }
        if(k1 > 0 && l1 > 0)
        {
            if(flag)
            {
                cej(bmf, abyte0, l, i2, j2, k1, l1, k2, l2);
                return;
            }
            cei(bmf, abyte0, l, i2, j2, k1, l1, k2, l2);
        }
    }

    private void cei(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        boolean flag = false;
        try
        {
            int l1 = -(l >> 2);
            l = -(l & 3);
            for(int i2 = -i1; i2 < 0; i2++)
            {
                for(int j2 = l1; j2 < 0; j2++)
                {
                    if(abyte0[j++] != 0)
                        ai[k++] = i;
                    else
                        k++;
                    if(abyte0[j++] != 0)
                        ai[k++] = i;
                    else
                        k++;
                    if(abyte0[j++] != 0)
                        ai[k++] = i;
                    else
                        k++;
                    if(abyte0[j++] != 0)
                        ai[k++] = i;
                    else
                        k++;
                }

                for(int k2 = l; k2 < 0; k2++)
                    if(abyte0[j++] != 0)
                        ai[k++] = i;
                    else
                        k++;

                k += j1;
                j += k1;
            }

            return;
        }
        catch(Exception exception)
        {
            System.out.println("plotletter: " + exception);
            exception.printStackTrace();
            return;
        }
    }

    private void cej(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        boolean flag = false;
        for(int l1 = -i1; l1 < 0; l1++)
        {
            for(int i2 = -l; i2 < 0; i2++)
            {
                int j2 = abyte0[j++] & 0xff;
                if(j2 > 30)
                {
                    if(j2 >= 230)
                    {
                        ai[k++] = i;
                    } else
                    {
                        int k2 = ai[k];
                        ai[k++] = ((i & 0xff00ff) * j2 + (k2 & 0xff00ff) * (256 - j2) & 0xff00ff00) + ((i & 0xff00) * j2 + (k2 & 0xff00) * (256 - j2) & 0xff0000) >> 8;
                    }
                } else
                {
                    k++;
                }
            }

            k += j1;
            j += k1;
        }

    }

    public int cek(int i)
    {
        if(i == 0)
            return 12;
        if(i == 1)
            return 14;
        if(i == 2)
            return 14;
        if(i == 3)
            return 15;
        if(i == 4)
            return 15;
        if(i == 5)
            return 19;
        if(i == 6)
            return 24;
        if(i == 7)
            return 29;
        else
            return cel(i);
    }

    public int cel(int i)
    {
        if(i == 0)
            return bnk[i][8] - 2;
        else
            return bnk[i][8] - 1;
    }

    public int cem(String s, int i)
    {
        boolean flag = false;
        int j = 0;
        byte abyte0[] = bnk[i];
        for(int k = 0; k < s.length(); k++)
            if(s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
                k += 4;
            else
            if(s.charAt(k) == '~' && k + 4 < s.length() && s.charAt(k + 4) == '~')
                k += 4;
            else
                j += abyte0[bnl[s.charAt(k)] + 7];

        return j;
    }

    public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1)
    {
        return true;
    }

    public int bln;
    public int bma;
    public int bmb;
    public int bmc;
    public int bmd;
    ColorModel bme;
    public int bmf[];
    ImageConsumer bmg;
    private Component bmh;
    public Image bmi;
    public int bmj[][];
    public byte bmk[][];
    public int bml[][];
    public int bmm[];
    public int bmn[];
    public int bna[];
    public int bnb[];
    public int bnc[];
    public int bnd[];
    public boolean bne[];
    private int bnf;
    private int bng;
    private int bnh;
    private int bni;
    public boolean bnj;
    static byte bnk[][] = new byte[50][];
    static int bnl[];
    public boolean bnm;
    int bnn[];
    int caa[];
    int cab[];
    int cac[];
    int cad[];
    int cae[];
    int caf[];
    public static int cag;
    public static int cah;
    public static int cai;
    private static boolean caj[] = new boolean[12];
    private static int cak;
    private static byte cal[] = new byte[0x186a0];
    public static int cam;

    static 
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        bnl = new int[256];
        for(int i = 0; i < 256; i++)
        {
            int j = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(i);
            if(j == -1)
                j = 74;
            bnl[i] = j * 9;
        }

    }
}
