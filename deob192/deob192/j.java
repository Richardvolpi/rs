// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:25 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;

public class j
    implements ImageProducer, ImageObserver
{

    public j(int arg0, int arg1, int arg2, Component arg3)
    {
        bcj = false;
        bcm = false;
        bbh = arg3;
        bcg = arg1;
        bci = arg0;
        bbc = ban = arg0;
        bbd = bba = arg1;
        bbb = arg0 * arg1;
        bbf = new int[arg0 * arg1];
        bbj = new int[arg2][];
        bce = new boolean[arg2];
        bbk = new byte[arg2][];
        bbl = new int[arg2][];
        bbm = new int[arg2];
        bbn = new int[arg2];
        bcc = new int[arg2];
        bcd = new int[arg2];
        bca = new int[arg2];
        bcb = new int[arg2];
        if(arg0 > 1 && arg1 > 1 && arg3 != null)
        {
            bbe = new DirectColorModel(32, 0xff0000, 65280, 255);
            int i = ban * bba;
            for(int k = 0; k < i; k++)
                bbf[k] = 0;

            bbi = arg3.createImage(this);
            baf();
            arg3.prepareImage(bbi, arg3);
            baf();
            arg3.prepareImage(bbi, arg3);
            baf();
            arg3.prepareImage(bbi, arg3);
        }
    }

    public synchronized void addConsumer(ImageConsumer arg0)
    {
        bbg = arg0;
        arg0.setDimensions(ban, bba);
        arg0.setProperties(null);
        arg0.setColorModel(bbe);
        arg0.setHints(14);
    }

    public synchronized boolean isConsumer(ImageConsumer arg0)
    {
        return bbg == arg0;
    }

    public synchronized void removeConsumer(ImageConsumer arg0)
    {
        if(bbg == arg0)
            bbg = null;
    }

    public void startProduction(ImageConsumer arg0)
    {
        addConsumer(arg0);
    }

    public void requestTopDownLeftRightResend(ImageConsumer arg0)
    {
        System.out.println("TDLR");
    }

    public synchronized void baf()
    {
        if(bbg == null)
        {
            return;
        } else
        {
            bbg.setPixels(0, 0, ban, bba, bbe, bbf, 0, ban);
            bbg.imageComplete(2);
            return;
        }
    }

    public void bag(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg0 < 0)
            arg0 = 0;
        if(arg1 < 0)
            arg1 = 0;
        if(arg2 > ban)
            arg2 = ban;
        if(arg3 > bba)
            arg3 = bba;
        bch = arg0;
        bcf = arg1;
        bci = arg2;
        bcg = arg3;
    }

    public void bah()
    {
        bch = 0;
        bcf = 0;
        bci = ban;
        bcg = bba;
    }

    public void bai(Graphics arg0, int arg1, int arg2)
    {
        baf();
        arg0.drawImage(bbi, arg1, arg2, this);
    }

    public void baj()
    {
        int i = ban * bba;
        if(!bcj)
        {
            for(int k = 0; k < i; k++)
                bbf[k] = 0;

            return;
        }
        int l = 0;
        for(int i1 = -bba; i1 < 0; i1 += 2)
        {
            for(int j1 = -ban; j1 < 0; j1++)
                bbf[l++] = 0;

            l += ban;
        }

    }

    public void bak(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        int i = 256 - arg4;
        int k = (arg3 >> 16 & 0xff) * arg4;
        int l = (arg3 >> 8 & 0xff) * arg4;
        int i1 = (arg3 & 0xff) * arg4;
        int i2 = arg1 - arg2;
        if(i2 < 0)
            i2 = 0;
        int j2 = arg1 + arg2;
        if(j2 >= bba)
            j2 = bba - 1;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            if((i2 & 1) != 0)
                i2++;
        }
        for(int k2 = i2; k2 <= j2; k2 += byte0)
        {
            int l2 = k2 - arg1;
            int i3 = (int)Math.sqrt(arg2 * arg2 - l2 * l2);
            int j3 = arg0 - i3;
            if(j3 < 0)
                j3 = 0;
            int k3 = arg0 + i3;
            if(k3 >= ban)
                k3 = ban - 1;
            int l3 = j3 + k2 * ban;
            for(int i4 = j3; i4 <= k3; i4++)
            {
                int j1 = (bbf[l3] >> 16 & 0xff) * i;
                int k1 = (bbf[l3] >> 8 & 0xff) * i;
                int l1 = (bbf[l3] & 0xff) * i;
                int j4 = ((k + j1 >> 8) << 16) + ((l + k1 >> 8) << 8) + (i1 + l1 >> 8);
                bbf[l3++] = j4;
            }

        }

    }

    public void bal(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        if(arg0 < bch)
        {
            arg2 -= bch - arg0;
            arg0 = bch;
        }
        if(arg1 < bcf)
        {
            arg3 -= bcf - arg1;
            arg1 = bcf;
        }
        if(arg0 + arg2 > bci)
            arg2 = bci - arg0;
        if(arg1 + arg3 > bcg)
            arg3 = bcg - arg1;
        int i = 256 - arg5;
        int k = (arg4 >> 16 & 0xff) * arg5;
        int l = (arg4 >> 8 & 0xff) * arg5;
        int i1 = (arg4 & 0xff) * arg5;
        int i2 = ban - arg2;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            i2 += ban;
            if((arg1 & 1) != 0)
            {
                arg1++;
                arg3--;
            }
        }
        int j2 = arg0 + arg1 * ban;
        for(int k2 = 0; k2 < arg3; k2 += byte0)
        {
            for(int l2 = -arg2; l2 < 0; l2++)
            {
                int j1 = (bbf[j2] >> 16 & 0xff) * i;
                int k1 = (bbf[j2] >> 8 & 0xff) * i;
                int l1 = (bbf[j2] & 0xff) * i;
                int i3 = ((k + j1 >> 8) << 16) + ((l + k1 >> 8) << 8) + (i1 + l1 >> 8);
                bbf[j2++] = i3;
            }

            j2 += i2;
        }

    }

    public void bam(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        if(arg0 < bch)
        {
            arg2 -= bch - arg0;
            arg0 = bch;
        }
        if(arg0 + arg2 > bci)
            arg2 = bci - arg0;
        int i = arg5 >> 16 & 0xff;
        int k = arg5 >> 8 & 0xff;
        int l = arg5 & 0xff;
        int i1 = arg4 >> 16 & 0xff;
        int j1 = arg4 >> 8 & 0xff;
        int k1 = arg4 & 0xff;
        int l1 = ban - arg2;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            l1 += ban;
            if((arg1 & 1) != 0)
            {
                arg1++;
                arg3--;
            }
        }
        int i2 = arg0 + arg1 * ban;
        for(int j2 = 0; j2 < arg3; j2 += byte0)
            if(j2 + arg1 >= bcf && j2 + arg1 < bcg)
            {
                int k2 = ((i * j2 + i1 * (arg3 - j2)) / arg3 << 16) + ((k * j2 + j1 * (arg3 - j2)) / arg3 << 8) + (l * j2 + k1 * (arg3 - j2)) / arg3;
                for(int l2 = -arg2; l2 < 0; l2++)
                    bbf[i2++] = k2;

                i2 += l1;
            } else
            {
                i2 += ban;
            }

    }

    public void ban(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        if(arg0 < bch)
        {
            arg2 -= bch - arg0;
            arg0 = bch;
        }
        if(arg1 < bcf)
        {
            arg3 -= bcf - arg1;
            arg1 = bcf;
        }
        if(arg0 + arg2 > bci)
            arg2 = bci - arg0;
        if(arg1 + arg3 > bcg)
            arg3 = bcg - arg1;
        int i = ban - arg2;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            i += ban;
            if((arg1 & 1) != 0)
            {
                arg1++;
                arg3--;
            }
        }
        int k = arg0 + arg1 * ban;
        for(int l = -arg3; l < 0; l += byte0)
        {
            for(int i1 = -arg2; i1 < 0; i1++)
                bbf[k++] = arg4;

            k += i;
        }

    }

    public void bba(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        bbb(arg0, arg1, arg2, arg4);
        bbb(arg0, (arg1 + arg3) - 1, arg2, arg4);
        bbc(arg0, arg1, arg3, arg4);
        bbc((arg0 + arg2) - 1, arg1, arg3, arg4);
    }

    public void bbb(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg1 < bcf || arg1 >= bcg)
            return;
        if(arg0 < bch)
        {
            arg2 -= bch - arg0;
            arg0 = bch;
        }
        if(arg0 + arg2 > bci)
            arg2 = bci - arg0;
        int i = arg0 + arg1 * ban;
        for(int k = 0; k < arg2; k++)
            bbf[i + k] = arg3;

    }

    public void bbc(int arg0, int arg1, int arg2, int arg3)
    {
        if(arg0 < bch || arg0 >= bci)
            return;
        if(arg1 < bcf)
        {
            arg2 -= bcf - arg1;
            arg1 = bcf;
        }
        if(arg1 + arg2 > bci)
            arg2 = bcg - arg1;
        int i = arg0 + arg1 * ban;
        for(int k = 0; k < arg2; k++)
            bbf[i + k * ban] = arg3;

    }

    public void bbd(int arg0, int arg1, int arg2)
    {
        if(arg0 < bch || arg1 < bcf || arg0 >= bci || arg1 >= bcg)
        {
            return;
        } else
        {
            bbf[arg0 + arg1 * ban] = arg2;
            return;
        }
    }

    public void bbe()
    {
        int l = ban * bba;
        for(int k = 0; k < l; k++)
        {
            int i = bbf[k] & 0xffffff;
            bbf[k] = (i >>> 1 & 0x7f7f7f) + (i >>> 2 & 0x3f3f3f) + (i >>> 3 & 0x1f1f1f) + (i >>> 4 & 0xf0f0f);
        }

    }

    public void bbf(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        for(int i = arg2; i < arg2 + arg4; i++)
        {
            for(int k = arg3; k < arg3 + arg5; k++)
            {
                int l = 0;
                int i1 = 0;
                int j1 = 0;
                int k1 = 0;
                for(int l1 = i - arg0; l1 <= i + arg0; l1++)
                    if(l1 >= 0 && l1 < ban)
                    {
                        for(int i2 = k - arg1; i2 <= k + arg1; i2++)
                            if(i2 >= 0 && i2 < bba)
                            {
                                int j2 = bbf[l1 + ban * i2];
                                l += j2 >> 16 & 0xff;
                                i1 += j2 >> 8 & 0xff;
                                j1 += j2 & 0xff;
                                k1++;
                            }

                    }

                bbf[i + ban * k] = (l / k1 << 16) + (i1 / k1 << 8) + j1 / k1;
            }

        }

    }

    public static int bbg(int arg0, int arg1, int arg2)
    {
        return (arg0 << 16) + (arg1 << 8) + arg2;
    }

    public void bbh()
    {
        for(int i = 0; i < bbj.length; i++)
        {
            bbj[i] = null;
            bbm[i] = 0;
            bbn[i] = 0;
            bbk[i] = null;
            bbl[i] = null;
        }

    }

    public void bbi(int arg0, byte arg1[], byte arg2[], int arg3)
    {
        int i = t.amm(arg1, 0);
        int k = t.amm(arg2, i);
        i += 2;
        int l = t.amm(arg2, i);
        i += 2;
        int i1 = arg2[i++] & 0xff;
        int ai[] = new int[i1];
        ai[0] = 0xff00ff;
        for(int j1 = 0; j1 < i1 - 1; j1++)
        {
            ai[j1 + 1] = ((arg2[i] & 0xff) << 16) + ((arg2[i + 1] & 0xff) << 8) + (arg2[i + 2] & 0xff);
            i += 3;
        }

        int k1 = 2;
        for(int l1 = arg0; l1 < arg0 + arg3; l1++)
        {
            bca[l1] = arg2[i++] & 0xff;
            bcb[l1] = arg2[i++] & 0xff;
            bbm[l1] = t.amm(arg2, i);
            i += 2;
            bbn[l1] = t.amm(arg2, i);
            i += 2;
            int i2 = arg2[i++] & 0xff;
            int j2 = bbm[l1] * bbn[l1];
            bbk[l1] = new byte[j2];
            bbl[l1] = ai;
            bcc[l1] = k;
            bcd[l1] = l;
            bbj[l1] = null;
            bce[l1] = false;
            if(bca[l1] != 0 || bcb[l1] != 0)
                bce[l1] = true;
            if(i2 == 0)
            {
                for(int k2 = 0; k2 < j2; k2++)
                {
                    bbk[l1][k2] = arg1[k1++];
                    if(bbk[l1][k2] == 0)
                        bce[l1] = true;
                }

            } else
            if(i2 == 1)
            {
                for(int l2 = 0; l2 < bbm[l1]; l2++)
                {
                    for(int i3 = 0; i3 < bbn[l1]; i3++)
                    {
                        bbk[l1][l2 + i3 * bbm[l1]] = arg1[k1++];
                        if(bbk[l1][l2 + i3 * bbm[l1]] == 0)
                            bce[l1] = true;
                    }

                }

            }
        }

    }

    public void bbj(int arg0, byte arg1[])
    {
        int ai[] = bbj[arg0] = new int[10200];
        bbm[arg0] = 255;
        bbn[arg0] = 40;
        bca[arg0] = 0;
        bcb[arg0] = 0;
        bcc[arg0] = 255;
        bcd[arg0] = 40;
        bce[arg0] = false;
        int i = 0;
        int k = 1;
        int l;
        for(l = 0; l < 255;)
        {
            int i1 = arg1[k++] & 0xff;
            for(int k1 = 0; k1 < i1; k1++)
                ai[l++] = i;

            i = 0xffffff - i;
        }

        for(int j1 = 1; j1 < 40; j1++)
        {
            for(int l1 = 0; l1 < 255;)
            {
                int i2 = arg1[k++] & 0xff;
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

    public void bbk(int arg0)
    {
        int i = bbm[arg0] * bbn[arg0];
        int ai[] = bbj[arg0];
        int ai1[] = new int[32768];
        for(int k = 0; k < i; k++)
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

        byte abyte0[] = new byte[i];
        for(int l1 = 0; l1 < i; l1++)
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

        bbk[arg0] = abyte0;
        bbl[arg0] = ai2;
        bbj[arg0] = null;
    }

    public void bbl(int arg0)
    {
        if(bbk[arg0] == null)
            return;
        int i = bbm[arg0] * bbn[arg0];
        byte abyte0[] = bbk[arg0];
        int ai[] = bbl[arg0];
        int ai1[] = new int[i];
        for(int k = 0; k < i; k++)
        {
            int l = ai[abyte0[k] & 0xff];
            if(l == 0)
                l = 1;
            else
            if(l == 0xff00ff)
                l = 0;
            ai1[k] = l;
        }

        bbj[arg0] = ai1;
        bbk[arg0] = null;
        bbl[arg0] = null;
    }

    public void bbm(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        bbm[arg0] = arg3;
        bbn[arg0] = arg4;
        bce[arg0] = false;
        bca[arg0] = 0;
        bcb[arg0] = 0;
        bcc[arg0] = arg3;
        bcd[arg0] = arg4;
        int i = arg3 * arg4;
        int k = 0;
        bbj[arg0] = new int[i];
        for(int l = arg1; l < arg1 + arg3; l++)
        {
            for(int i1 = arg2; i1 < arg2 + arg4; i1++)
                bbj[arg0][k++] = bbf[l + i1 * ban];

        }

    }

    public void bbn(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        bbm[arg0] = arg3;
        bbn[arg0] = arg4;
        bce[arg0] = false;
        bca[arg0] = 0;
        bcb[arg0] = 0;
        bcc[arg0] = arg3;
        bcd[arg0] = arg4;
        int i = arg3 * arg4;
        int k = 0;
        bbj[arg0] = new int[i];
        for(int l = arg2; l < arg2 + arg4; l++)
        {
            for(int i1 = arg1; i1 < arg1 + arg3; i1++)
                bbj[arg0][k++] = bbf[i1 + l * ban];

        }

    }

    public void bca(int arg0, int arg1, int arg2)
    {
        if(bce[arg2])
        {
            arg0 += bca[arg2];
            arg1 += bcb[arg2];
        }
        int i = arg0 + arg1 * ban;
        int k = 0;
        int l = bbn[arg2];
        int i1 = bbm[arg2];
        int j1 = ban - i1;
        int k1 = 0;
        if(arg1 < bcf)
        {
            int l1 = bcf - arg1;
            l -= l1;
            arg1 = bcf;
            k += l1 * i1;
            i += l1 * ban;
        }
        if(arg1 + l >= bcg)
            l -= ((arg1 + l) - bcg) + 1;
        if(arg0 < bch)
        {
            int i2 = bch - arg0;
            i1 -= i2;
            arg0 = bch;
            k += i2;
            i += i2;
            k1 += i2;
            j1 += i2;
        }
        if(arg0 + i1 >= bci)
        {
            int j2 = ((arg0 + i1) - bci) + 1;
            i1 -= j2;
            k1 += j2;
            j1 += j2;
        }
        if(i1 <= 0 || l <= 0)
            return;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            j1 += ban;
            k1 += bbm[arg2];
            if((arg1 & 1) != 0)
            {
                i += ban;
                l--;
            }
        }
        if(bbj[arg2] == null)
        {
            bcg(bbf, bbk[arg2], bbl[arg2], k, i, i1, l, j1, k1, byte0);
            return;
        } else
        {
            bcf(bbf, bbj[arg2], 0, k, i, i1, l, j1, k1, byte0);
            return;
        }
    }

    public void bcb(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        try
        {
            int i = bbm[arg4];
            int k = bbn[arg4];
            int l = 0;
            int i1 = 0;
            int j1 = (i << 16) / arg2;
            int k1 = (k << 16) / arg3;
            if(bce[arg4])
            {
                int l1 = bcc[arg4];
                int j2 = bcd[arg4];
                j1 = (l1 << 16) / arg2;
                k1 = (j2 << 16) / arg3;
                arg0 += ((bca[arg4] * arg2 + l1) - 1) / l1;
                arg1 += ((bcb[arg4] * arg3 + j2) - 1) / j2;
                if((bca[arg4] * arg2) % l1 != 0)
                    l = (l1 - (bca[arg4] * arg2) % l1 << 16) / arg2;
                if((bcb[arg4] * arg3) % j2 != 0)
                    i1 = (j2 - (bcb[arg4] * arg3) % j2 << 16) / arg3;
                arg2 = (arg2 * (bbm[arg4] - (l >> 16))) / l1;
                arg3 = (arg3 * (bbn[arg4] - (i1 >> 16))) / j2;
            }
            int i2 = arg0 + arg1 * ban;
            int k2 = ban - arg2;
            if(arg1 < bcf)
            {
                int l2 = bcf - arg1;
                arg3 -= l2;
                arg1 = 0;
                i2 += l2 * ban;
                i1 += k1 * l2;
            }
            if(arg1 + arg3 >= bcg)
                arg3 -= ((arg1 + arg3) - bcg) + 1;
            if(arg0 < bch)
            {
                int i3 = bch - arg0;
                arg2 -= i3;
                arg0 = 0;
                i2 += i3;
                l += j1 * i3;
                k2 += i3;
            }
            if(arg0 + arg2 >= bci)
            {
                int j3 = ((arg0 + arg2) - bci) + 1;
                arg2 -= j3;
                k2 += j3;
            }
            byte byte0 = 1;
            if(bcj)
            {
                byte0 = 2;
                k2 += ban;
                k1 += k1;
                if((arg1 & 1) != 0)
                {
                    i2 += ban;
                    arg3--;
                }
            }
            bch(bbf, bbj[arg4], 0, l, i1, i2, k2, arg2, arg3, j1, k1, i, byte0);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void bcc(int arg0, int arg1, int arg2, int arg3)
    {
        if(bce[arg2])
        {
            arg0 += bca[arg2];
            arg1 += bcb[arg2];
        }
        int i = arg0 + arg1 * ban;
        int k = 0;
        int l = bbn[arg2];
        int i1 = bbm[arg2];
        int j1 = ban - i1;
        int k1 = 0;
        if(arg1 < bcf)
        {
            int l1 = bcf - arg1;
            l -= l1;
            arg1 = bcf;
            k += l1 * i1;
            i += l1 * ban;
        }
        if(arg1 + l >= bcg)
            l -= ((arg1 + l) - bcg) + 1;
        if(arg0 < bch)
        {
            int i2 = bch - arg0;
            i1 -= i2;
            arg0 = bch;
            k += i2;
            i += i2;
            k1 += i2;
            j1 += i2;
        }
        if(arg0 + i1 >= bci)
        {
            int j2 = ((arg0 + i1) - bci) + 1;
            i1 -= j2;
            k1 += j2;
            j1 += j2;
        }
        if(i1 <= 0 || l <= 0)
            return;
        byte byte0 = 1;
        if(bcj)
        {
            byte0 = 2;
            j1 += ban;
            k1 += bbm[arg2];
            if((arg1 & 1) != 0)
            {
                i += ban;
                l--;
            }
        }
        if(bbj[arg2] == null)
        {
            bcj(bbf, bbk[arg2], bbl[arg2], k, i, i1, l, j1, k1, byte0, arg3);
            return;
        } else
        {
            bci(bbf, bbj[arg2], 0, k, i, i1, l, j1, k1, byte0, arg3);
            return;
        }
    }

    public void bcd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        try
        {
            int i = bbm[arg4];
            int k = bbn[arg4];
            int l = 0;
            int i1 = 0;
            int j1 = (i << 16) / arg2;
            int k1 = (k << 16) / arg3;
            if(bce[arg4])
            {
                int l1 = bcc[arg4];
                int j2 = bcd[arg4];
                j1 = (l1 << 16) / arg2;
                k1 = (j2 << 16) / arg3;
                arg0 += ((bca[arg4] * arg2 + l1) - 1) / l1;
                arg1 += ((bcb[arg4] * arg3 + j2) - 1) / j2;
                if((bca[arg4] * arg2) % l1 != 0)
                    l = (l1 - (bca[arg4] * arg2) % l1 << 16) / arg2;
                if((bcb[arg4] * arg3) % j2 != 0)
                    i1 = (j2 - (bcb[arg4] * arg3) % j2 << 16) / arg3;
                arg2 = (arg2 * (bbm[arg4] - (l >> 16))) / l1;
                arg3 = (arg3 * (bbn[arg4] - (i1 >> 16))) / j2;
            }
            int i2 = arg0 + arg1 * ban;
            int k2 = ban - arg2;
            if(arg1 < bcf)
            {
                int l2 = bcf - arg1;
                arg3 -= l2;
                arg1 = 0;
                i2 += l2 * ban;
                i1 += k1 * l2;
            }
            if(arg1 + arg3 >= bcg)
                arg3 -= ((arg1 + arg3) - bcg) + 1;
            if(arg0 < bch)
            {
                int i3 = bch - arg0;
                arg2 -= i3;
                arg0 = 0;
                i2 += i3;
                l += j1 * i3;
                k2 += i3;
            }
            if(arg0 + arg2 >= bci)
            {
                int j3 = ((arg0 + arg2) - bci) + 1;
                arg2 -= j3;
                k2 += j3;
            }
            byte byte0 = 1;
            if(bcj)
            {
                byte0 = 2;
                k2 += ban;
                k1 += k1;
                if((arg1 & 1) != 0)
                {
                    i2 += ban;
                    arg3--;
                }
            }
            bck(bbf, bbj[arg4], 0, l, i1, i2, k2, arg2, arg3, j1, k1, i, byte0, arg5);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void bce(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        try
        {
            int i = bbm[arg4];
            int k = bbn[arg4];
            int l = 0;
            int i1 = 0;
            int j1 = (i << 16) / arg2;
            int k1 = (k << 16) / arg3;
            if(bce[arg4])
            {
                int l1 = bcc[arg4];
                int j2 = bcd[arg4];
                j1 = (l1 << 16) / arg2;
                k1 = (j2 << 16) / arg3;
                arg0 += ((bca[arg4] * arg2 + l1) - 1) / l1;
                arg1 += ((bcb[arg4] * arg3 + j2) - 1) / j2;
                if((bca[arg4] * arg2) % l1 != 0)
                    l = (l1 - (bca[arg4] * arg2) % l1 << 16) / arg2;
                if((bcb[arg4] * arg3) % j2 != 0)
                    i1 = (j2 - (bcb[arg4] * arg3) % j2 << 16) / arg3;
                arg2 = (arg2 * (bbm[arg4] - (l >> 16))) / l1;
                arg3 = (arg3 * (bbn[arg4] - (i1 >> 16))) / j2;
            }
            int i2 = arg0 + arg1 * ban;
            int k2 = ban - arg2;
            if(arg1 < bcf)
            {
                int l2 = bcf - arg1;
                arg3 -= l2;
                arg1 = 0;
                i2 += l2 * ban;
                i1 += k1 * l2;
            }
            if(arg1 + arg3 >= bcg)
                arg3 -= ((arg1 + arg3) - bcg) + 1;
            if(arg0 < bch)
            {
                int i3 = bch - arg0;
                arg2 -= i3;
                arg0 = 0;
                i2 += i3;
                l += j1 * i3;
                k2 += i3;
            }
            if(arg0 + arg2 >= bci)
            {
                int j3 = ((arg0 + arg2) - bci) + 1;
                arg2 -= j3;
                k2 += j3;
            }
            byte byte0 = 1;
            if(bcj)
            {
                byte0 = 2;
                k2 += ban;
                k1 += k1;
                if((arg1 & 1) != 0)
                {
                    i2 += ban;
                    arg3--;
                }
            }
            bcl(bbf, bbj[arg4], 0, l, i1, i2, k2, arg2, arg3, j1, k1, i, byte0, arg5);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void bcf(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9)
    {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 3);
        for(int k = -arg6; k < 0; k += arg9)
        {
            for(int l = i; l < 0; l++)
            {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }

            for(int i1 = arg5; i1 < 0; i1++)
            {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                    arg0[arg4++] = arg2;
                else
                    arg4++;
            }

            arg4 += arg7;
            arg3 += arg8;
        }

    }

    private void bcg(int arg0[], byte arg1[], int arg2[], int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9)
    {
        int i = -(arg5 >> 2);
        arg5 = -(arg5 & 3);
        for(int k = -arg6; k < 0; k += arg9)
        {
            for(int l = i; l < 0; l++)
            {
                byte byte0 = arg1[arg3++];
                if(byte0 != 0)
                    arg0[arg4++] = arg2[byte0 & 0xff];
                else
                    arg4++;
                byte0 = arg1[arg3++];
                if(byte0 != 0)
                    arg0[arg4++] = arg2[byte0 & 0xff];
                else
                    arg4++;
                byte0 = arg1[arg3++];
                if(byte0 != 0)
                    arg0[arg4++] = arg2[byte0 & 0xff];
                else
                    arg4++;
                byte0 = arg1[arg3++];
                if(byte0 != 0)
                    arg0[arg4++] = arg2[byte0 & 0xff];
                else
                    arg4++;
            }

            for(int i1 = arg5; i1 < 0; i1++)
            {
                byte byte1 = arg1[arg3++];
                if(byte1 != 0)
                    arg0[arg4++] = arg2[byte1 & 0xff];
                else
                    arg4++;
            }

            arg4 += arg7;
            arg3 += arg8;
        }

    }

    private void bch(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12)
    {
        try
        {
            int i = arg3;
            for(int k = -arg8; k < 0; k += arg12)
            {
                int l = (arg4 >> 16) * arg11;
                for(int i1 = -arg7; i1 < 0; i1++)
                {
                    arg2 = arg1[(arg3 >> 16) + l];
                    if(arg2 != 0)
                        arg0[arg5++] = arg2;
                    else
                        arg5++;
                    arg3 += arg9;
                }

                arg4 += arg10;
                arg3 = i;
                arg5 += arg6;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    private void bci(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10)
    {
        int i = 256 - arg10;
        for(int k = -arg6; k < 0; k += arg9)
        {
            for(int l = -arg5; l < 0; l++)
            {
                arg2 = arg1[arg3++];
                if(arg2 != 0)
                {
                    int i1 = arg0[arg4];
                    arg0[arg4++] = ((arg2 & 0xff00ff) * arg10 + (i1 & 0xff00ff) * i & 0xff00ff00) + ((arg2 & 0xff00) * arg10 + (i1 & 0xff00) * i & 0xff0000) >> 8;
                } else
                {
                    arg4++;
                }
            }

            arg4 += arg7;
            arg3 += arg8;
        }

    }

    private void bcj(int arg0[], byte arg1[], int arg2[], int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10)
    {
        int i = 256 - arg10;
        for(int k = -arg6; k < 0; k += arg9)
        {
            for(int l = -arg5; l < 0; l++)
            {
                int i1 = arg1[arg3++];
                if(i1 != 0)
                {
                    i1 = arg2[i1 & 0xff];
                    int j1 = arg0[arg4];
                    arg0[arg4++] = ((i1 & 0xff00ff) * arg10 + (j1 & 0xff00ff) * i & 0xff00ff00) + ((i1 & 0xff00) * arg10 + (j1 & 0xff00) * i & 0xff0000) >> 8;
                } else
                {
                    arg4++;
                }
            }

            arg4 += arg7;
            arg3 += arg8;
        }

    }

    private void bck(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        int i = 256 - arg13;
        try
        {
            int k = arg3;
            for(int l = -arg8; l < 0; l += arg12)
            {
                int i1 = (arg4 >> 16) * arg11;
                for(int j1 = -arg7; j1 < 0; j1++)
                {
                    arg2 = arg1[(arg3 >> 16) + i1];
                    if(arg2 != 0)
                    {
                        int k1 = arg0[arg5];
                        arg0[arg5++] = ((arg2 & 0xff00ff) * arg13 + (k1 & 0xff00ff) * i & 0xff00ff00) + ((arg2 & 0xff00) * arg13 + (k1 & 0xff00) * i & 0xff0000) >> 8;
                    } else
                    {
                        arg5++;
                    }
                    arg3 += arg9;
                }

                arg4 += arg10;
                arg3 = k;
                arg5 += arg6;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in tran_scale");
        }
    }

    private void bcl(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13)
    {
        int i = arg13 >> 16 & 0xff;
        int k = arg13 >> 8 & 0xff;
        int l = arg13 & 0xff;
        try
        {
            int i1 = arg3;
            for(int j1 = -arg8; j1 < 0; j1 += arg12)
            {
                int k1 = (arg4 >> 16) * arg11;
                for(int l1 = -arg7; l1 < 0; l1++)
                {
                    arg2 = arg1[(arg3 >> 16) + k1];
                    if(arg2 != 0)
                    {
                        int i2 = arg2 >> 16 & 0xff;
                        int j2 = arg2 >> 8 & 0xff;
                        int k2 = arg2 & 0xff;
                        if(i2 == j2 && j2 == k2)
                            arg0[arg5++] = ((i2 * i >> 8) << 16) + ((j2 * k >> 8) << 8) + (k2 * l >> 8);
                        else
                            arg0[arg5++] = arg2;
                    } else
                    {
                        arg5++;
                    }
                    arg3 += arg9;
                }

                arg4 += arg10;
                arg3 = i1;
                arg5 += arg6;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in plot_scale");
        }
    }

    public void bcm(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        int i = ban;
        int k = bba;
        if(bcn == null)
        {
            bcn = new int[512];
            for(int l = 0; l < 256; l++)
            {
                bcn[l] = (int)(Math.sin((double)l * 0.02454369D) * 32768D);
                bcn[l + 256] = (int)(Math.cos((double)l * 0.02454369D) * 32768D);
            }

        }
        int i1 = -bcc[arg2] / 2;
        int j1 = -bcd[arg2] / 2;
        if(bce[arg2])
        {
            i1 += bca[arg2];
            j1 += bcb[arg2];
        }
        int k1 = i1 + bbm[arg2];
        int l1 = j1 + bbn[arg2];
        int i2 = k1;
        int j2 = j1;
        int k2 = i1;
        int l2 = l1;
        arg3 &= 0xff;
        int i3 = bcn[arg3] * arg4;
        int j3 = bcn[arg3 + 256] * arg4;
        int k3 = arg0 + (j1 * i3 + i1 * j3 >> 22);
        int l3 = arg1 + (j1 * j3 - i1 * i3 >> 22);
        int i4 = arg0 + (j2 * i3 + i2 * j3 >> 22);
        int j4 = arg1 + (j2 * j3 - i2 * i3 >> 22);
        int k4 = arg0 + (l1 * i3 + k1 * j3 >> 22);
        int l4 = arg1 + (l1 * j3 - k1 * i3 >> 22);
        int i5 = arg0 + (l2 * i3 + k2 * j3 >> 22);
        int j5 = arg1 + (l2 * j3 - k2 * i3 >> 22);
        if(arg4 == 192 && (arg3 & 0x3f) == (bdi & 0x3f))
            bdg++;
        else
        if(arg4 == 128)
            bdi = arg3;
        else
            bdh++;
        int k5 = l3;
        int l5 = l3;
        if(j4 < k5)
            k5 = j4;
        else
        if(j4 > l5)
            l5 = j4;
        if(l4 < k5)
            k5 = l4;
        else
        if(l4 > l5)
            l5 = l4;
        if(j5 < k5)
            k5 = j5;
        else
        if(j5 > l5)
            l5 = j5;
        if(k5 < bcf)
            k5 = bcf;
        if(l5 > bcg)
            l5 = bcg;
        if(bda == null || bda.length != k + 1)
        {
            bda = new int[k + 1];
            bdb = new int[k + 1];
            bdc = new int[k + 1];
            bdd = new int[k + 1];
            bde = new int[k + 1];
            bdf = new int[k + 1];
        }
        for(int i6 = k5; i6 <= l5; i6++)
        {
            bda[i6] = 0x5f5e0ff;
            bdb[i6] = 0xfa0a1f01;
        }

        int i7 = 0;
        int k7 = 0;
        int i8 = 0;
        int j8 = bbm[arg2];
        int k8 = bbn[arg2];
        i1 = 0;
        j1 = 0;
        i2 = j8 - 1;
        j2 = 0;
        k1 = j8 - 1;
        l1 = k8 - 1;
        k2 = 0;
        l2 = k8 - 1;
        if(j5 != l3)
        {
            i7 = (i5 - k3 << 8) / (j5 - l3);
            i8 = (l2 - j1 << 8) / (j5 - l3);
        }
        int j6;
        int k6;
        int l6;
        int l7;
        if(l3 > j5)
        {
            l6 = i5 << 8;
            l7 = l2 << 8;
            j6 = j5;
            k6 = l3;
        } else
        {
            l6 = k3 << 8;
            l7 = j1 << 8;
            j6 = l3;
            k6 = j5;
        }
        if(j6 < 0)
        {
            l6 -= i7 * j6;
            l7 -= i8 * j6;
            j6 = 0;
        }
        if(k6 > k - 1)
            k6 = k - 1;
        for(int l8 = j6; l8 <= k6; l8++)
        {
            bda[l8] = bdb[l8] = l6;
            l6 += i7;
            bdc[l8] = bdd[l8] = 0;
            bde[l8] = bdf[l8] = l7;
            l7 += i8;
        }

        if(j4 != l3)
        {
            i7 = (i4 - k3 << 8) / (j4 - l3);
            k7 = (i2 - i1 << 8) / (j4 - l3);
        }
        int j7;
        if(l3 > j4)
        {
            l6 = i4 << 8;
            j7 = i2 << 8;
            j6 = j4;
            k6 = l3;
        } else
        {
            l6 = k3 << 8;
            j7 = i1 << 8;
            j6 = l3;
            k6 = j4;
        }
        if(j6 < 0)
        {
            l6 -= i7 * j6;
            j7 -= k7 * j6;
            j6 = 0;
        }
        if(k6 > k - 1)
            k6 = k - 1;
        for(int i9 = j6; i9 <= k6; i9++)
        {
            if(l6 < bda[i9])
            {
                bda[i9] = l6;
                bdc[i9] = j7;
                bde[i9] = 0;
            }
            if(l6 > bdb[i9])
            {
                bdb[i9] = l6;
                bdd[i9] = j7;
                bdf[i9] = 0;
            }
            l6 += i7;
            j7 += k7;
        }

        if(l4 != j4)
        {
            i7 = (k4 - i4 << 8) / (l4 - j4);
            i8 = (l1 - j2 << 8) / (l4 - j4);
        }
        if(j4 > l4)
        {
            l6 = k4 << 8;
            j7 = k1 << 8;
            l7 = l1 << 8;
            j6 = l4;
            k6 = j4;
        } else
        {
            l6 = i4 << 8;
            j7 = i2 << 8;
            l7 = j2 << 8;
            j6 = j4;
            k6 = l4;
        }
        if(j6 < 0)
        {
            l6 -= i7 * j6;
            l7 -= i8 * j6;
            j6 = 0;
        }
        if(k6 > k - 1)
            k6 = k - 1;
        for(int j9 = j6; j9 <= k6; j9++)
        {
            if(l6 < bda[j9])
            {
                bda[j9] = l6;
                bdc[j9] = j7;
                bde[j9] = l7;
            }
            if(l6 > bdb[j9])
            {
                bdb[j9] = l6;
                bdd[j9] = j7;
                bdf[j9] = l7;
            }
            l6 += i7;
            l7 += i8;
        }

        if(j5 != l4)
        {
            i7 = (i5 - k4 << 8) / (j5 - l4);
            k7 = (k2 - k1 << 8) / (j5 - l4);
        }
        if(l4 > j5)
        {
            l6 = i5 << 8;
            j7 = k2 << 8;
            l7 = l2 << 8;
            j6 = j5;
            k6 = l4;
        } else
        {
            l6 = k4 << 8;
            j7 = k1 << 8;
            l7 = l1 << 8;
            j6 = l4;
            k6 = j5;
        }
        if(j6 < 0)
        {
            l6 -= i7 * j6;
            j7 -= k7 * j6;
            j6 = 0;
        }
        if(k6 > k - 1)
            k6 = k - 1;
        for(int k9 = j6; k9 <= k6; k9++)
        {
            if(l6 < bda[k9])
            {
                bda[k9] = l6;
                bdc[k9] = j7;
                bde[k9] = l7;
            }
            if(l6 > bdb[k9])
            {
                bdb[k9] = l6;
                bdd[k9] = j7;
                bdf[k9] = l7;
            }
            l6 += i7;
            j7 += k7;
        }

        int l9 = k5 * i;
        int ai[] = bbj[arg2];
        for(int i10 = k5; i10 < l5; i10++)
        {
            int j10 = bda[i10] >> 8;
            int k10 = bdb[i10] >> 8;
            if(k10 - j10 <= 0)
            {
                l9 += i;
            } else
            {
                int l10 = bdc[i10] << 9;
                int i11 = ((bdd[i10] << 9) - l10) / (k10 - j10);
                int j11 = bde[i10] << 9;
                int k11 = ((bdf[i10] << 9) - j11) / (k10 - j10);
                if(j10 < bch)
                {
                    l10 += (bch - j10) * i11;
                    j11 += (bch - j10) * k11;
                    j10 = bch;
                }
                if(k10 > bci)
                    k10 = bci;
                if(!bcj || (i10 & 1) == 0)
                    if(!bce[arg2])
                        bcn(bbf, ai, 0, l9 + j10, l10, j11, i11, k11, j10 - k10, j8);
                    else
                        bda(bbf, ai, 0, l9 + j10, l10, j11, i11, k11, j10 - k10, j8);
                l9 += i;
            }
        }

    }

    private void bcn(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9)
    {
        for(arg2 = arg8; arg2 < 0; arg2++)
        {
            bbf[arg3++] = arg1[(arg4 >> 17) + (arg5 >> 17) * arg9];
            arg4 += arg6;
            arg5 += arg7;
        }

    }

    private void bda(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9)
    {
        for(int i = arg8; i < 0; i++)
        {
            arg2 = arg1[(arg4 >> 17) + (arg5 >> 17) * arg9];
            if(arg2 != 0)
                bbf[arg3++] = arg2;
            else
                arg3++;
            arg4 += arg6;
            arg5 += arg7;
        }

    }

    public void bdb(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        bcb(arg0, arg1, arg2, arg3, arg4);
    }

    public void bdc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, boolean arg8)
    {
        try
        {
            if(arg5 == 0)
                arg5 = 0xffffff;
            if(arg6 == 0)
                arg6 = 0xffffff;
            int i = bbm[arg4];
            int k = bbn[arg4];
            int l = 0;
            int i1 = 0;
            int j1 = arg7 << 16;
            int k1 = (i << 16) / arg2;
            int l1 = (k << 16) / arg3;
            int i2 = -(arg7 << 16) / arg3;
            if(bce[arg4])
            {
                int j2 = bcc[arg4];
                int l2 = bcd[arg4];
                k1 = (j2 << 16) / arg2;
                l1 = (l2 << 16) / arg3;
                int k3 = bca[arg4];
                int l3 = bcb[arg4];
                if(arg8)
                    k3 = j2 - bbm[arg4] - k3;
                arg0 += ((k3 * arg2 + j2) - 1) / j2;
                int i4 = ((l3 * arg3 + l2) - 1) / l2;
                arg1 += i4;
                j1 += i4 * i2;
                if((k3 * arg2) % j2 != 0)
                    l = (j2 - (k3 * arg2) % j2 << 16) / arg2;
                if((l3 * arg3) % l2 != 0)
                    i1 = (l2 - (l3 * arg3) % l2 << 16) / arg3;
                arg2 = ((((bbm[arg4] << 16) - l) + k1) - 1) / k1;
                arg3 = ((((bbn[arg4] << 16) - i1) + l1) - 1) / l1;
            }
            int k2 = arg1 * ban;
            j1 += arg0 << 16;
            if(arg1 < bcf)
            {
                int i3 = bcf - arg1;
                arg3 -= i3;
                arg1 = bcf;
                k2 += i3 * ban;
                i1 += l1 * i3;
                j1 += i2 * i3;
            }
            if(arg1 + arg3 >= bcg)
                arg3 -= ((arg1 + arg3) - bcg) + 1;
            int j3 = k2 / ban & 1;
            if(!bcj)
                j3 = 2;
            if(arg6 == 0xffffff)
            {
                if(bbj[arg4] != null)
                    if(!arg8)
                    {
                        bdd(bbf, bbj[arg4], 0, l, i1, k2, arg2, arg3, k1, l1, i, arg5, j1, i2, j3);
                        return;
                    } else
                    {
                        bdd(bbf, bbj[arg4], 0, (bbm[arg4] << 16) - l - 1, i1, k2, arg2, arg3, -k1, l1, i, arg5, j1, i2, j3);
                        return;
                    }
                if(!arg8)
                {
                    bdf(bbf, bbk[arg4], bbl[arg4], 0, l, i1, k2, arg2, arg3, k1, l1, i, arg5, j1, i2, j3);
                    return;
                } else
                {
                    bdf(bbf, bbk[arg4], bbl[arg4], 0, (bbm[arg4] << 16) - l - 1, i1, k2, arg2, arg3, -k1, l1, i, arg5, j1, i2, j3);
                    return;
                }
            }
            if(bbj[arg4] != null)
                if(!arg8)
                {
                    bde(bbf, bbj[arg4], 0, l, i1, k2, arg2, arg3, k1, l1, i, arg5, arg6, j1, i2, j3);
                    return;
                } else
                {
                    bde(bbf, bbj[arg4], 0, (bbm[arg4] << 16) - l - 1, i1, k2, arg2, arg3, -k1, l1, i, arg5, arg6, j1, i2, j3);
                    return;
                }
            if(!arg8)
            {
                bdg(bbf, bbk[arg4], bbl[arg4], 0, l, i1, k2, arg2, arg3, k1, l1, i, arg5, arg6, j1, i2, j3);
                return;
            } else
            {
                bdg(bbf, bbk[arg4], bbl[arg4], 0, (bbm[arg4] << 16) - l - 1, i1, k2, arg2, arg3, -k1, l1, i, arg5, arg6, j1, i2, j3);
                return;
            }
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void bdd(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, 
            int arg14)
    {
        int i1 = arg11 >> 16 & 0xff;
        int j1 = arg11 >> 8 & 0xff;
        int k1 = arg11 & 0xff;
        try
        {
            int l1 = arg3;
            for(int i2 = -arg7; i2 < 0; i2++)
            {
                int j2 = (arg4 >> 16) * arg10;
                int k2 = arg12 >> 16;
                int l2 = arg6;
                if(k2 < bch)
                {
                    int i3 = bch - k2;
                    l2 -= i3;
                    k2 = bch;
                    arg3 += arg8 * i3;
                }
                if(k2 + l2 >= bci)
                {
                    int j3 = (k2 + l2) - bci;
                    l2 -= j3;
                }
                arg14 = 1 - arg14;
                if(arg14 != 0)
                {
                    for(int k3 = k2; k3 < k2 + l2; k3++)
                    {
                        arg2 = arg1[(arg3 >> 16) + j2];
                        if(arg2 != 0)
                        {
                            int i = arg2 >> 16 & 0xff;
                            int k = arg2 >> 8 & 0xff;
                            int l = arg2 & 0xff;
                            if(i == k && k == l)
                                arg0[k3 + arg5] = ((i * i1 >> 8) << 16) + ((k * j1 >> 8) << 8) + (l * k1 >> 8);
                            else
                                arg0[k3 + arg5] = arg2;
                        }
                        arg3 += arg8;
                    }

                }
                arg4 += arg9;
                arg3 = l1;
                arg5 += ban;
                arg12 += arg13;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void bde(int arg0[], int arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, 
            int arg14, int arg15)
    {
        int i1 = arg11 >> 16 & 0xff;
        int j1 = arg11 >> 8 & 0xff;
        int k1 = arg11 & 0xff;
        int l1 = arg12 >> 16 & 0xff;
        int i2 = arg12 >> 8 & 0xff;
        int j2 = arg12 & 0xff;
        try
        {
            int k2 = arg3;
            for(int l2 = -arg7; l2 < 0; l2++)
            {
                int i3 = (arg4 >> 16) * arg10;
                int j3 = arg13 >> 16;
                int k3 = arg6;
                if(j3 < bch)
                {
                    int l3 = bch - j3;
                    k3 -= l3;
                    j3 = bch;
                    arg3 += arg8 * l3;
                }
                if(j3 + k3 >= bci)
                {
                    int i4 = (j3 + k3) - bci;
                    k3 -= i4;
                }
                arg15 = 1 - arg15;
                if(arg15 != 0)
                {
                    for(int j4 = j3; j4 < j3 + k3; j4++)
                    {
                        arg2 = arg1[(arg3 >> 16) + i3];
                        if(arg2 != 0)
                        {
                            int i = arg2 >> 16 & 0xff;
                            int k = arg2 >> 8 & 0xff;
                            int l = arg2 & 0xff;
                            if(i == k && k == l)
                                arg0[j4 + arg5] = ((i * i1 >> 8) << 16) + ((k * j1 >> 8) << 8) + (l * k1 >> 8);
                            else
                            if(i == 255 && k == l)
                                arg0[j4 + arg5] = ((i * l1 >> 8) << 16) + ((k * i2 >> 8) << 8) + (l * j2 >> 8);
                            else
                                arg0[j4 + arg5] = arg2;
                        }
                        arg3 += arg8;
                    }

                }
                arg4 += arg9;
                arg3 = k2;
                arg5 += ban;
                arg13 += arg14;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void bdf(int arg0[], byte arg1[], int arg2[], int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, 
            int arg14, int arg15)
    {
        int i1 = arg12 >> 16 & 0xff;
        int j1 = arg12 >> 8 & 0xff;
        int k1 = arg12 & 0xff;
        try
        {
            int l1 = arg4;
            for(int i2 = -arg8; i2 < 0; i2++)
            {
                int j2 = (arg5 >> 16) * arg11;
                int k2 = arg13 >> 16;
                int l2 = arg7;
                if(k2 < bch)
                {
                    int i3 = bch - k2;
                    l2 -= i3;
                    k2 = bch;
                    arg4 += arg9 * i3;
                }
                if(k2 + l2 >= bci)
                {
                    int j3 = (k2 + l2) - bci;
                    l2 -= j3;
                }
                arg15 = 1 - arg15;
                if(arg15 != 0)
                {
                    for(int k3 = k2; k3 < k2 + l2; k3++)
                    {
                        arg3 = arg1[(arg4 >> 16) + j2] & 0xff;
                        if(arg3 != 0)
                        {
                            arg3 = arg2[arg3];
                            int i = arg3 >> 16 & 0xff;
                            int k = arg3 >> 8 & 0xff;
                            int l = arg3 & 0xff;
                            if(i == k && k == l)
                                arg0[k3 + arg6] = ((i * i1 >> 8) << 16) + ((k * j1 >> 8) << 8) + (l * k1 >> 8);
                            else
                                arg0[k3 + arg6] = arg3;
                        }
                        arg4 += arg9;
                    }

                }
                arg5 += arg10;
                arg4 = l1;
                arg6 += ban;
                arg13 += arg14;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void bdg(int arg0[], byte arg1[], int arg2[], int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, 
            int arg14, int arg15, int arg16)
    {
        int i1 = arg12 >> 16 & 0xff;
        int j1 = arg12 >> 8 & 0xff;
        int k1 = arg12 & 0xff;
        int l1 = arg13 >> 16 & 0xff;
        int i2 = arg13 >> 8 & 0xff;
        int j2 = arg13 & 0xff;
        try
        {
            int k2 = arg4;
            for(int l2 = -arg8; l2 < 0; l2++)
            {
                int i3 = (arg5 >> 16) * arg11;
                int j3 = arg14 >> 16;
                int k3 = arg7;
                if(j3 < bch)
                {
                    int l3 = bch - j3;
                    k3 -= l3;
                    j3 = bch;
                    arg4 += arg9 * l3;
                }
                if(j3 + k3 >= bci)
                {
                    int i4 = (j3 + k3) - bci;
                    k3 -= i4;
                }
                arg16 = 1 - arg16;
                if(arg16 != 0)
                {
                    for(int j4 = j3; j4 < j3 + k3; j4++)
                    {
                        arg3 = arg1[(arg4 >> 16) + i3] & 0xff;
                        if(arg3 != 0)
                        {
                            arg3 = arg2[arg3];
                            int i = arg3 >> 16 & 0xff;
                            int k = arg3 >> 8 & 0xff;
                            int l = arg3 & 0xff;
                            if(i == k && k == l)
                                arg0[j4 + arg6] = ((i * i1 >> 8) << 16) + ((k * j1 >> 8) << 8) + (l * k1 >> 8);
                            else
                            if(i == 255 && k == l)
                                arg0[j4 + arg6] = ((i * l1 >> 8) << 16) + ((k * i2 >> 8) << 8) + (l * j2 >> 8);
                            else
                                arg0[j4 + arg6] = arg3;
                        }
                        arg4 += arg9;
                    }

                }
                arg5 += arg10;
                arg4 = k2;
                arg6 += ban;
                arg14 += arg15;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    public static void bdh(String arg0, int arg1, a arg2)
    {
        boolean flag = false;
        boolean flag1 = false;
        arg0 = arg0.toLowerCase();
        if(arg0.startsWith("helvetica"))
            arg0 = arg0.substring(9);
        if(arg0.startsWith("h"))
            arg0 = arg0.substring(1);
        if(arg0.startsWith("f"))
        {
            arg0 = arg0.substring(1);
            flag = true;
        }
        if(arg0.startsWith("d"))
        {
            arg0 = arg0.substring(1);
            flag1 = true;
        }
        if(arg0.endsWith(".jf"))
            arg0 = arg0.substring(0, arg0.length() - 3);
        int i = 0;
        if(arg0.endsWith("b"))
        {
            i = 1;
            arg0 = arg0.substring(0, arg0.length() - 1);
        }
        if(arg0.endsWith("p"))
            arg0 = arg0.substring(0, arg0.length() - 1);
        int k = Integer.parseInt(arg0);
        Font font = new Font("Helvetica", i, k);
        FontMetrics fontmetrics = arg2.getFontMetrics(font);
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        bdk = 855;
        for(int l = 0; l < 95; l++)
            bdi(font, fontmetrics, s.charAt(l), l, arg2, arg1, flag1);

        bck[arg1] = new byte[bdk];
        for(int i1 = 0; i1 < bdk; i1++)
            bck[arg1][i1] = bdl[i1];

        if(i == 1 && bdj[arg1])
        {
            bdj[arg1] = false;
            bdh("f" + k + "p", arg1, arg2);
        }
        if(flag && !bdj[arg1])
        {
            bdj[arg1] = false;
            bdh("d" + k + "p", arg1, arg2);
        }
    }

    public static void bdi(Font arg0, FontMetrics arg1, char arg2, int arg3, a arg4, int arg5, boolean arg6)
    {
        int i = arg1.charWidth(arg2);
        int k = i;
        if(arg6)
            i++;
        int l = arg1.getMaxAscent();
        int i1 = arg1.getMaxAscent() + arg1.getMaxDescent();
        int j1 = arg1.getHeight();
        Image image = arg4.ajl(i, i1);
        Graphics g = image.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, i, i1);
        g.setColor(Color.white);
        g.setFont(arg0);
        g.drawString(String.valueOf(arg2), 0, l);
        if(arg6)
            g.drawString(String.valueOf(arg2), 1, l);
        int ai[] = new int[i * i1];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i, i1, ai, 0, i);
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
        int k1 = 0;
        int l1 = 0;
        int i2 = i;
        int j2 = i1;
label0:
        for(int k2 = 0; k2 < i1; k2++)
        {
            for(int l2 = 0; l2 < i; l2++)
            {
                int j3 = ai[l2 + k2 * i];
                if((j3 & 0xffffff) == 0)
                    continue;
                l1 = k2;
                break label0;
            }

        }

label1:
        for(int i3 = 0; i3 < i; i3++)
        {
            for(int k3 = 0; k3 < i1; k3++)
            {
                int i4 = ai[i3 + k3 * i];
                if((i4 & 0xffffff) == 0)
                    continue;
                k1 = i3;
                break label1;
            }

        }

label2:
        for(int l3 = i1 - 1; l3 >= 0; l3--)
        {
            for(int j4 = 0; j4 < i; j4++)
            {
                int l4 = ai[j4 + l3 * i];
                if((l4 & 0xffffff) == 0)
                    continue;
                j2 = l3 + 1;
                break label2;
            }

        }

label3:
        for(int k4 = i - 1; k4 >= 0; k4--)
        {
            for(int i5 = 0; i5 < i1; i5++)
            {
                int k5 = ai[k4 + i5 * i];
                if((k5 & 0xffffff) == 0)
                    continue;
                i2 = k4 + 1;
                break label3;
            }

        }

        bdl[arg3 * 9] = (byte)(bdk / 16384);
        bdl[arg3 * 9 + 1] = (byte)(bdk / 128 & 0x7f);
        bdl[arg3 * 9 + 2] = (byte)(bdk & 0x7f);
        bdl[arg3 * 9 + 3] = (byte)(i2 - k1);
        bdl[arg3 * 9 + 4] = (byte)(j2 - l1);
        bdl[arg3 * 9 + 5] = (byte)k1;
        bdl[arg3 * 9 + 6] = (byte)(l - l1);
        bdl[arg3 * 9 + 7] = (byte)k;
        bdl[arg3 * 9 + 8] = (byte)j1;
        for(int j5 = l1; j5 < j2; j5++)
        {
            for(int l5 = k1; l5 < i2; l5++)
            {
                int i6 = ai[l5 + j5 * i] & 0xff;
                if(i6 > 30 && i6 < 230)
                    bdj[arg5] = true;
                bdl[bdk++] = (byte)i6;
            }

        }

    }

    public void bdj(String arg0, int arg1, int arg2, int arg3, int arg4)
    {
        bdm(arg0, arg1 - bee(arg0, arg3), arg2, arg3, arg4);
    }

    public void bdk(String arg0, int arg1, int arg2, int arg3, int arg4)
    {
        bdm(arg0, arg1 - bee(arg0, arg3) / 2, arg2, arg3, arg4);
    }

    public void bdl(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        try
        {
            int i = 0;
            byte abyte0[] = bck[arg3];
            int k = 0;
            int l = 0;
            for(int i1 = 0; i1 < arg0.length(); i1++)
            {
                if(arg0.charAt(i1) == '@' && i1 + 4 < arg0.length() && arg0.charAt(i1 + 4) == '@')
                    i1 += 4;
                else
                if(arg0.charAt(i1) == '~' && i1 + 4 < arg0.length() && arg0.charAt(i1 + 4) == '~')
                    i1 += 4;
                else
                    i += abyte0[bcl[arg0.charAt(i1)] + 7];
                if(arg0.charAt(i1) == ' ')
                    l = i1;
                if(arg0.charAt(i1) == '%')
                {
                    l = i1;
                    i = 1000;
                }
                if(i > arg5)
                {
                    if(l <= k)
                        l = i1;
                    bdk(arg0.substring(k, l), arg1, arg2, arg3, arg4);
                    i = 0;
                    k = i1 = l + 1;
                    arg2 += bec(arg3);
                }
            }

            if(i > 0)
            {
                bdk(arg0.substring(k), arg1, arg2, arg3, arg4);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println("centrepara: " + exception);
            exception.printStackTrace();
        }
    }

    public void bdm(String arg0, int arg1, int arg2, int arg3, int arg4)
    {
        try
        {
            byte abyte0[] = bck[arg3];
            for(int i = 0; i < arg0.length(); i++)
                if(arg0.charAt(i) == '@' && i + 4 < arg0.length() && arg0.charAt(i + 4) == '@')
                {
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("red"))
                        arg4 = 0xff0000;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("lre"))
                        arg4 = 0xff9040;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("yel"))
                        arg4 = 0xffff00;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("gre"))
                        arg4 = 65280;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("blu"))
                        arg4 = 255;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("cya"))
                        arg4 = 65535;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("mag"))
                        arg4 = 0xff00ff;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("whi"))
                        arg4 = 0xffffff;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("bla"))
                        arg4 = 0;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("dre"))
                        arg4 = 0xc00000;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("ora"))
                        arg4 = 0xff9040;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("ran"))
                        arg4 = (int)(Math.random() * 16777215D);
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("or1"))
                        arg4 = 0xffb000;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("or2"))
                        arg4 = 0xff7000;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("or3"))
                        arg4 = 0xff3000;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("gr1"))
                        arg4 = 0xc0ff00;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("gr2"))
                        arg4 = 0x80ff00;
                    else
                    if(arg0.substring(i + 1, i + 4).equalsIgnoreCase("gr3"))
                        arg4 = 0x40ff00;
                    i += 4;
                } else
                if(arg0.charAt(i) == '~' && i + 4 < arg0.length() && arg0.charAt(i + 4) == '~')
                {
                    char c = arg0.charAt(i + 1);
                    char c1 = arg0.charAt(i + 2);
                    char c2 = arg0.charAt(i + 3);
                    if(c >= '0' && c <= '9' && c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9')
                        arg1 = Integer.parseInt(arg0.substring(i + 1, i + 4));
                    i += 4;
                } else
                {
                    int k = bcl[arg0.charAt(i)];
                    if(bcm && !bdj[arg3] && arg4 != 0)
                        bdn(k, arg1 + 1, arg2, 0, abyte0, bdj[arg3]);
                    if(bcm && !bdj[arg3] && arg4 != 0)
                        bdn(k, arg1, arg2 + 1, 0, abyte0, bdj[arg3]);
                    bdn(k, arg1, arg2, arg4, abyte0, bdj[arg3]);
                    arg1 += abyte0[k + 7];
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

    private void bdn(int arg0, int arg1, int arg2, int arg3, byte arg4[], boolean arg5)
    {
        int i = arg1 + arg4[arg0 + 5];
        int k = arg2 - arg4[arg0 + 6];
        int l = arg4[arg0 + 3];
        int i1 = arg4[arg0 + 4];
        int j1 = arg4[arg0] * 16384 + arg4[arg0 + 1] * 128 + arg4[arg0 + 2];
        int k1 = i + k * ban;
        int l1 = ban - l;
        int i2 = 0;
        if(k < bcf)
        {
            int j2 = bcf - k;
            i1 -= j2;
            k = bcf;
            j1 += j2 * l;
            k1 += j2 * ban;
        }
        if(k + i1 >= bcg)
            i1 -= ((k + i1) - bcg) + 1;
        if(i < bch)
        {
            int k2 = bch - i;
            l -= k2;
            i = bch;
            j1 += k2;
            k1 += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + l >= bci)
        {
            int l2 = ((i + l) - bci) + 1;
            l -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(l > 0 && i1 > 0)
        {
            if(arg5)
            {
                beb(bbf, arg4, arg3, j1, k1, l, i1, l1, i2);
                return;
            }
            bea(bbf, arg4, arg3, j1, k1, l, i1, l1, i2);
        }
    }

    private void bea(int arg0[], byte arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8)
    {
        try
        {
            int i = -(arg5 >> 2);
            arg5 = -(arg5 & 3);
            for(int k = -arg6; k < 0; k++)
            {
                for(int l = i; l < 0; l++)
                {
                    if(arg1[arg3++] != 0)
                        arg0[arg4++] = arg2;
                    else
                        arg4++;
                    if(arg1[arg3++] != 0)
                        arg0[arg4++] = arg2;
                    else
                        arg4++;
                    if(arg1[arg3++] != 0)
                        arg0[arg4++] = arg2;
                    else
                        arg4++;
                    if(arg1[arg3++] != 0)
                        arg0[arg4++] = arg2;
                    else
                        arg4++;
                }

                for(int i1 = arg5; i1 < 0; i1++)
                    if(arg1[arg3++] != 0)
                        arg0[arg4++] = arg2;
                    else
                        arg4++;

                arg4 += arg7;
                arg3 += arg8;
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

    private void beb(int arg0[], byte arg1[], int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7, int arg8)
    {
        for(int i = -arg6; i < 0; i++)
        {
            for(int k = -arg5; k < 0; k++)
            {
                int l = arg1[arg3++] & 0xff;
                if(l > 30)
                {
                    if(l >= 230)
                    {
                        arg0[arg4++] = arg2;
                    } else
                    {
                        int i1 = arg0[arg4];
                        arg0[arg4++] = ((arg2 & 0xff00ff) * l + (i1 & 0xff00ff) * (256 - l) & 0xff00ff00) + ((arg2 & 0xff00) * l + (i1 & 0xff00) * (256 - l) & 0xff0000) >> 8;
                    }
                } else
                {
                    arg4++;
                }
            }

            arg4 += arg7;
            arg3 += arg8;
        }

    }

    public int bec(int arg0)
    {
        if(arg0 == 0)
            return 12;
        if(arg0 == 1)
            return 14;
        if(arg0 == 2)
            return 14;
        if(arg0 == 3)
            return 15;
        if(arg0 == 4)
            return 15;
        if(arg0 == 5)
            return 19;
        if(arg0 == 6)
            return 24;
        if(arg0 == 7)
            return 29;
        else
            return bed(arg0);
    }

    public int bed(int arg0)
    {
        if(arg0 == 0)
            return bck[arg0][8] - 2;
        else
            return bck[arg0][8] - 1;
    }

    public int bee(String arg0, int arg1)
    {
        int i = 0;
        byte abyte0[] = bck[arg1];
        for(int k = 0; k < arg0.length(); k++)
            if(arg0.charAt(k) == '@' && k + 4 < arg0.length() && arg0.charAt(k + 4) == '@')
                k += 4;
            else
            if(arg0.charAt(k) == '~' && k + 4 < arg0.length() && arg0.charAt(k + 4) == '~')
                k += 4;
            else
                i += abyte0[bcl[arg0.charAt(k)] + 7];

        return i;
    }

    public boolean imageUpdate(Image arg0, int arg1, int arg2, int i, int k, int l)
    {
        return true;
    }

    public int ban;
    public int bba;
    public int bbb;
    public int bbc;
    public int bbd;
    ColorModel bbe;
    public int bbf[];
    ImageConsumer bbg;
    private Component bbh;
    public Image bbi;
    public int bbj[][];
    public byte bbk[][];
    public int bbl[][];
    public int bbm[];
    public int bbn[];
    public int bca[];
    public int bcb[];
    public int bcc[];
    public int bcd[];
    public boolean bce[];
    private int bcf;
    private int bcg;
    private int bch;
    private int bci;
    public boolean bcj;
    static byte bck[][] = new byte[50][];
    static int bcl[];
    public boolean bcm;
    int bcn[];
    int bda[];
    int bdb[];
    int bdc[];
    int bdd[];
    int bde[];
    int bdf[];
    public static int bdg;
    public static int bdh;
    public static int bdi;
    private static boolean bdj[] = new boolean[12];
    private static int bdk;
    private static byte bdl[] = new byte[0x186a0];
    public static int bdm;

    static 
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        bcl = new int[256];
        for(int i = 0; i < 256; i++)
        {
            int k = s.indexOf(i);
            if(k == -1)
                k = 74;
            bcl[i] = k * 9;
        }

    }
}