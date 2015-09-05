// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;
import java.awt.image.*;
import java.io.PrintStream;

public class Class6
    implements ImageProducer, ImageObserver
{

    public Class6(int i, int j, int k, Component component)
    {
        aBoolean335 = false;
        aBoolean338 = false;
        aComponent319 = component;
        anInt332 = j;
        anInt334 = i;
        anInt314 = anInt311 = i;
        anInt315 = anInt312 = j;
        anInt313 = i * j;
        anIntArray317 = new int[i * j];
        anIntArrayArray321 = new int[k][];
        aBooleanArray330 = new boolean[k];
        aByteArrayArray322 = new byte[k][];
        anIntArrayArray323 = new int[k][];
        anIntArray324 = new int[k];
        anIntArray325 = new int[k];
        anIntArray328 = new int[k];
        anIntArray329 = new int[k];
        anIntArray326 = new int[k];
        anIntArray327 = new int[k];
        if(i > 1 && j > 1 && component != null)
        {
            aColorModel316 = new DirectColorModel(32, 0xff0000, 65280, 255);
            int l = anInt311 * anInt312;
            for(int i1 = 0; i1 < l; i1++)
                anIntArray317[i1] = 0;

            anImage320 = component.createImage(this);
            method208();
            component.prepareImage(anImage320, component);
            method208();
            component.prepareImage(anImage320, component);
            method208();
            component.prepareImage(anImage320, component);
        }
    }

    public synchronized void addConsumer(ImageConsumer imageconsumer)
    {
        anImageConsumer318 = imageconsumer;
        imageconsumer.setDimensions(anInt311, anInt312);
        imageconsumer.setProperties(null);
        imageconsumer.setColorModel(aColorModel316);
        imageconsumer.setHints(14);
    }

    public boolean imageUpdate(Image image, int i, int j, int k, int l, int i1)
    {
        return true;
    }

    public synchronized boolean isConsumer(ImageConsumer imageconsumer)
    {
        return anImageConsumer318 == imageconsumer;
    }

    public synchronized void method208()
    {
        if(anImageConsumer318 == null)
        {
            return;
        } else
        {
            anImageConsumer318.setPixels(0, 0, anInt311, anInt312, aColorModel316, anIntArray317, 0, anInt311);
            anImageConsumer318.imageComplete(2);
            return;
        }
    }

    public void method209(int i, int j, int k, int l)
    {
        if(i < 0)
            i = 0;
        if(j < 0)
            j = 0;
        if(k > anInt311)
            k = anInt311;
        if(l > anInt312)
            l = anInt312;
        anInt333 = i;
        anInt331 = j;
        anInt334 = k;
        anInt332 = l;
    }

    public void method210()
    {
        anInt333 = 0;
        anInt331 = 0;
        anInt334 = anInt311;
        anInt332 = anInt312;
    }

    public void method211(Graphics g, int i, int j)
    {
        method208();
        g.drawImage(anImage320, i, j, this);
    }

    public void method212()
    {
        int j1 = anInt352;
        int i = anInt311 * anInt312;
        if(!aBoolean335)
        {
            for(int j = 0; j < i; j++)
                anIntArray317[j] = 0;

            return;
        }
        int k = 0;
        for(int l = -anInt312; l < 0; l += 2)
        {
            for(int i1 = -anInt311; i1 < 0; i1++)
                anIntArray317[k++] = 0;

            k += anInt311;
        }

    }

    public void method213(int i, int j, int k, int l, int i1)
    {
        int k5 = anInt352;
        int j1 = 256 - i1;
        int k1 = (l >> 16 & 0xff) * i1;
        int l1 = (l >> 8 & 0xff) * i1;
        int i2 = (l & 0xff) * i1;
        int i3 = j - k;
        if(i3 < 0)
            i3 = 0;
        int j3 = j + k;
        if(j3 >= anInt312)
            j3 = anInt312 - 1;
        byte byte0 = 1;
        if(aBoolean335)
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
            if(k4 >= anInt311)
                k4 = anInt311 - 1;
            int l4 = j4 + k3 * anInt311;
            for(int i5 = j4; i5 <= k4; i5++)
            {
                int j2 = (anIntArray317[l4] >> 16 & 0xff) * j1;
                int k2 = (anIntArray317[l4] >> 8 & 0xff) * j1;
                int l2 = (anIntArray317[l4] & 0xff) * j1;
                int j5 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
                anIntArray317[l4++] = j5;
            }

        }

    }

    public void method214(int i, int j, int k, int l, int i1, int j1)
    {
        int k4 = anInt352;
        if(i < anInt333)
        {
            k -= anInt333 - i;
            i = anInt333;
        }
        if(j < anInt331)
        {
            l -= anInt331 - j;
            j = anInt331;
        }
        if(i + k > anInt334)
            k = anInt334 - i;
        if(j + l > anInt332)
            l = anInt332 - j;
        int k1 = 256 - j1;
        int l1 = (i1 >> 16 & 0xff) * j1;
        int i2 = (i1 >> 8 & 0xff) * j1;
        int j2 = (i1 & 0xff) * j1;
        int j3 = anInt311 - k;
        byte byte0 = 1;
        if(aBoolean335)
        {
            byte0 = 2;
            j3 += anInt311;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int k3 = i + j * anInt311;
        for(int l3 = 0; l3 < l; l3 += byte0)
        {
            for(int i4 = -k; i4 < 0; i4++)
            {
                int k2 = (anIntArray317[k3] >> 16 & 0xff) * k1;
                int l2 = (anIntArray317[k3] >> 8 & 0xff) * k1;
                int i3 = (anIntArray317[k3] & 0xff) * k1;
                int j4 = ((l1 + k2 >> 8) << 16) + ((i2 + l2 >> 8) << 8) + (j2 + i3 >> 8);
                anIntArray317[k3++] = j4;
            }

            k3 += j3;
        }

    }

    public void method215(int i, int j, int k, int l, int i1, int j1)
    {
        int j4 = anInt352;
        if(i < anInt333)
        {
            k -= anInt333 - i;
            i = anInt333;
        }
        if(i + k > anInt334)
            k = anInt334 - i;
        int k1 = j1 >> 16 & 0xff;
        int l1 = j1 >> 8 & 0xff;
        int i2 = j1 & 0xff;
        int j2 = i1 >> 16 & 0xff;
        int k2 = i1 >> 8 & 0xff;
        int l2 = i1 & 0xff;
        int i3 = anInt311 - k;
        byte byte0 = 1;
        if(aBoolean335)
        {
            byte0 = 2;
            i3 += anInt311;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int j3 = i + j * anInt311;
        for(int k3 = 0; k3 < l; k3 += byte0)
            if(k3 + j >= anInt331 && k3 + j < anInt332)
            {
                int l3 = ((k1 * k3 + j2 * (l - k3)) / l << 16) + ((l1 * k3 + k2 * (l - k3)) / l << 8) + (i2 * k3 + l2 * (l - k3)) / l;
                for(int i4 = -k; i4 < 0; i4++)
                    anIntArray317[j3++] = l3;

                j3 += i3;
            } else
            {
                j3 += anInt311;
            }

    }

    public void method216(int i, int j, int k, int l, int i1)
    {
        int j2 = anInt352;
        if(i < anInt333)
        {
            k -= anInt333 - i;
            i = anInt333;
        }
        if(j < anInt331)
        {
            l -= anInt331 - j;
            j = anInt331;
        }
        if(i + k > anInt334)
            k = anInt334 - i;
        if(j + l > anInt332)
            l = anInt332 - j;
        int j1 = anInt311 - k;
        byte byte0 = 1;
        if(aBoolean335)
        {
            byte0 = 2;
            j1 += anInt311;
            if((j & 1) != 0)
            {
                j++;
                l--;
            }
        }
        int k1 = i + j * anInt311;
        for(int l1 = -l; l1 < 0; l1 += byte0)
        {
            for(int i2 = -k; i2 < 0; i2++)
                anIntArray317[k1++] = i1;

            k1 += j1;
        }

    }

    public void method217(int i, int j, int k, int l, int i1)
    {
        method218(i, j, k, i1);
        method218(i, (j + l) - 1, k, i1);
        method219(i, j, l, i1);
        method219((i + k) - 1, j, l, i1);
    }

    public void method218(int i, int j, int k, int l)
    {
        if(j < anInt331 || j >= anInt332)
            return;
        if(i < anInt333)
        {
            k -= anInt333 - i;
            i = anInt333;
        }
        if(i + k > anInt334)
            k = anInt334 - i;
        int i1 = i + j * anInt311;
        for(int j1 = 0; j1 < k; j1++)
            anIntArray317[i1 + j1] = l;

    }

    public void method219(int i, int j, int k, int l)
    {
        if(i < anInt333 || i >= anInt334)
            return;
        if(j < anInt331)
        {
            k -= anInt331 - j;
            j = anInt331;
        }
        if(j + k > anInt334)
            k = anInt332 - j;
        int i1 = i + j * anInt311;
        for(int j1 = 0; j1 < k; j1++)
            anIntArray317[i1 + j1 * anInt311] = l;

    }

    public void method220(int i, int j, int k)
    {
        if(i < anInt333 || j < anInt331 || i >= anInt334 || j >= anInt332)
        {
            return;
        } else
        {
            anIntArray317[i + j * anInt311] = k;
            return;
        }
    }

    public void method221()
    {
        int k = anInt311 * anInt312;
        for(int j = 0; j < k; j++)
        {
            int i = anIntArray317[j] & 0xffffff;
            anIntArray317[j] = (i >>> 1 & 0x7f7f7f) + (i >>> 2 & 0x3f3f3f) + (i >>> 3 & 0x1f1f1f) + (i >>> 4 & 0xf0f0f);
        }

    }

    public void method222(int i, int j, int k, int l, int i1, int j1)
    {
        int l3 = anInt352;
        for(int k1 = k; k1 < k + i1; k1++)
        {
            for(int l1 = l; l1 < l + j1; l1++)
            {
                int i2 = 0;
                int j2 = 0;
                int k2 = 0;
                int l2 = 0;
                for(int i3 = k1 - i; i3 <= k1 + i; i3++)
                    if(i3 >= 0 && i3 < anInt311)
                    {
                        for(int j3 = l1 - j; j3 <= l1 + j; j3++)
                            if(j3 >= 0 && j3 < anInt312)
                            {
                                int k3 = anIntArray317[i3 + anInt311 * j3];
                                i2 += k3 >> 16 & 0xff;
                                j2 += k3 >> 8 & 0xff;
                                k2 += k3 & 0xff;
                                l2++;
                            }

                    }

                anIntArray317[k1 + anInt311 * l1] = (i2 / l2 << 16) + (j2 / l2 << 8) + k2 / l2;
            }

        }

    }

    public static int method223(int i, int j, int k)
    {
        return (i << 16) + (j << 8) + k;
    }

    public void method224()
    {
        for(int i = 0; i < anIntArrayArray321.length; i++)
        {
            anIntArrayArray321[i] = null;
            anIntArray324[i] = 0;
            anIntArray325[i] = 0;
            aByteArrayArray322[i] = null;
            anIntArrayArray323[i] = null;
        }

    }

    public void method225(int i, byte abyte0[], byte abyte1[], int j)
    {
        int k3 = anInt352;
        int k = Class15.method354(abyte0, 0);
        int l = Class15.method354(abyte1, k);
        k += 2;
        int i1 = Class15.method354(abyte1, k);
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
            anIntArray326[i2] = abyte1[k++] & 0xff;
            anIntArray327[i2] = abyte1[k++] & 0xff;
            anIntArray324[i2] = Class15.method354(abyte1, k);
            k += 2;
            anIntArray325[i2] = Class15.method354(abyte1, k);
            k += 2;
            int j2 = abyte1[k++] & 0xff;
            int k2 = anIntArray324[i2] * anIntArray325[i2];
            aByteArrayArray322[i2] = new byte[k2];
            anIntArrayArray323[i2] = ai;
            anIntArray328[i2] = l;
            anIntArray329[i2] = i1;
            anIntArrayArray321[i2] = null;
            aBooleanArray330[i2] = false;
            if(anIntArray326[i2] != 0 || anIntArray327[i2] != 0)
                aBooleanArray330[i2] = true;
            if(j2 == 0)
            {
                for(int l2 = 0; l2 < k2; l2++)
                {
                    aByteArrayArray322[i2][l2] = abyte0[l1++];
                    if(aByteArrayArray322[i2][l2] == 0)
                        aBooleanArray330[i2] = true;
                }

            } else
            if(j2 == 1)
            {
                for(int i3 = 0; i3 < anIntArray324[i2]; i3++)
                {
                    for(int j3 = 0; j3 < anIntArray325[i2]; j3++)
                    {
                        aByteArrayArray322[i2][i3 + j3 * anIntArray324[i2]] = abyte0[l1++];
                        if(aByteArrayArray322[i2][i3 + j3 * anIntArray324[i2]] == 0)
                            aBooleanArray330[i2] = true;
                    }

                }

            }
        }

    }

    public void method226(int i, byte abyte0[])
    {
        int k2 = anInt352;
        int ai[] = anIntArrayArray321[i] = new int[10200];
        anIntArray324[i] = 255;
        anIntArray325[i] = 40;
        anIntArray326[i] = 0;
        anIntArray327[i] = 0;
        anIntArray328[i] = 255;
        anIntArray329[i] = 40;
        aBooleanArray330[i] = false;
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

    public void method227(int i)
    {
        int k5 = anInt352;
        int j = anIntArray324[i] * anIntArray325[i];
        int ai[] = anIntArrayArray321[i];
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

        aByteArrayArray322[i] = abyte0;
        anIntArrayArray323[i] = ai2;
        anIntArrayArray321[i] = null;
    }

    public void method228(int i)
    {
        int i1 = anInt352;
        if(aByteArrayArray322[i] == null)
            return;
        int j = anIntArray324[i] * anIntArray325[i];
        byte abyte0[] = aByteArrayArray322[i];
        int ai[] = anIntArrayArray323[i];
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

        anIntArrayArray321[i] = ai1;
        aByteArrayArray322[i] = null;
        anIntArrayArray323[i] = null;
    }

    public void method229(int i, int j, int k, int l, int i1)
    {
        int j2 = anInt352;
        anIntArray324[i] = l;
        anIntArray325[i] = i1;
        aBooleanArray330[i] = false;
        anIntArray326[i] = 0;
        anIntArray327[i] = 0;
        anIntArray328[i] = l;
        anIntArray329[i] = i1;
        int j1 = l * i1;
        int k1 = 0;
        anIntArrayArray321[i] = new int[j1];
        for(int l1 = j; l1 < j + l; l1++)
        {
            for(int i2 = k; i2 < k + i1; i2++)
                anIntArrayArray321[i][k1++] = anIntArray317[l1 + i2 * anInt311];

        }

    }

    public void method230(int i, int j, int k, int l, int i1)
    {
        int j2 = anInt352;
        anIntArray324[i] = l;
        anIntArray325[i] = i1;
        aBooleanArray330[i] = false;
        anIntArray326[i] = 0;
        anIntArray327[i] = 0;
        anIntArray328[i] = l;
        anIntArray329[i] = i1;
        int j1 = l * i1;
        int k1 = 0;
        anIntArrayArray321[i] = new int[j1];
        for(int l1 = k; l1 < k + i1; l1++)
        {
            for(int i2 = j; i2 < j + l; i2++)
                anIntArrayArray321[i][k1++] = anIntArray317[i2 + l1 * anInt311];

        }

    }

    public void method231(int i, int j, int k)
    {
        if(aBooleanArray330[k])
        {
            i += anIntArray326[k];
            j += anIntArray327[k];
        }
        int l = i + j * anInt311;
        int i1 = 0;
        int j1 = anIntArray325[k];
        int k1 = anIntArray324[k];
        int l1 = anInt311 - k1;
        int i2 = 0;
        if(j < anInt331)
        {
            int j2 = anInt331 - j;
            j1 -= j2;
            j = anInt331;
            i1 += j2 * k1;
            l += j2 * anInt311;
        }
        if(j + j1 >= anInt332)
            j1 -= ((j + j1) - anInt332) + 1;
        if(i < anInt333)
        {
            int k2 = anInt333 - i;
            k1 -= k2;
            i = anInt333;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 >= anInt334)
        {
            int l2 = ((i + k1) - anInt334) + 1;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
            return;
        byte byte0 = 1;
        if(aBoolean335)
        {
            byte0 = 2;
            l1 += anInt311;
            i2 += anIntArray324[k];
            if((j & 1) != 0)
            {
                l += anInt311;
                j1--;
            }
        }
        if(anIntArrayArray321[k] == null)
        {
            method237(anIntArray317, aByteArrayArray322[k], anIntArrayArray323[k], i1, l, k1, j1, l1, i2, byte0);
            return;
        } else
        {
            method236(anIntArray317, anIntArrayArray321[k], 0, i1, l, k1, j1, l1, i2, byte0);
            return;
        }
    }

    public void method232(int i, int j, int k, int l, int i1)
    {
        try
        {
            int j1 = anIntArray324[i1];
            int k1 = anIntArray325[i1];
            int l1 = 0;
            int i2 = 0;
            int j2 = (j1 << 16) / k;
            int k2 = (k1 << 16) / l;
            if(aBooleanArray330[i1])
            {
                int l2 = anIntArray328[i1];
                int j3 = anIntArray329[i1];
                j2 = (l2 << 16) / k;
                k2 = (j3 << 16) / l;
                i += ((anIntArray326[i1] * k + l2) - 1) / l2;
                j += ((anIntArray327[i1] * l + j3) - 1) / j3;
                if((anIntArray326[i1] * k) % l2 != 0)
                    l1 = (l2 - (anIntArray326[i1] * k) % l2 << 16) / k;
                if((anIntArray327[i1] * l) % j3 != 0)
                    i2 = (j3 - (anIntArray327[i1] * l) % j3 << 16) / l;
                k = (k * (anIntArray324[i1] - (l1 >> 16))) / l2;
                l = (l * (anIntArray325[i1] - (i2 >> 16))) / j3;
            }
            int i3 = i + j * anInt311;
            int k3 = anInt311 - k;
            if(j < anInt331)
            {
                int l3 = anInt331 - j;
                l -= l3;
                j = 0;
                i3 += l3 * anInt311;
                i2 += k2 * l3;
            }
            if(j + l >= anInt332)
                l -= ((j + l) - anInt332) + 1;
            if(i < anInt333)
            {
                int i4 = anInt333 - i;
                k -= i4;
                i = 0;
                i3 += i4;
                l1 += j2 * i4;
                k3 += i4;
            }
            if(i + k >= anInt334)
            {
                int j4 = ((i + k) - anInt334) + 1;
                k -= j4;
                k3 += j4;
            }
            byte byte0 = 1;
            if(aBoolean335)
            {
                byte0 = 2;
                k3 += anInt311;
                k2 += k2;
                if((j & 1) != 0)
                {
                    i3 += anInt311;
                    l--;
                }
            }
            method238(anIntArray317, anIntArrayArray321[i1], 0, l1, i2, i3, k3, k, l, j2, k2, j1, byte0);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void method233(int i, int j, int k, int l)
    {
        if(aBooleanArray330[k])
        {
            i += anIntArray326[k];
            j += anIntArray327[k];
        }
        int i1 = i + j * anInt311;
        int j1 = 0;
        int k1 = anIntArray325[k];
        int l1 = anIntArray324[k];
        int i2 = anInt311 - l1;
        int j2 = 0;
        if(j < anInt331)
        {
            int k2 = anInt331 - j;
            k1 -= k2;
            j = anInt331;
            j1 += k2 * l1;
            i1 += k2 * anInt311;
        }
        if(j + k1 >= anInt332)
            k1 -= ((j + k1) - anInt332) + 1;
        if(i < anInt333)
        {
            int l2 = anInt333 - i;
            l1 -= l2;
            i = anInt333;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if(i + l1 >= anInt334)
        {
            int i3 = ((i + l1) - anInt334) + 1;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if(l1 <= 0 || k1 <= 0)
            return;
        byte byte0 = 1;
        if(aBoolean335)
        {
            byte0 = 2;
            i2 += anInt311;
            j2 += anIntArray324[k];
            if((j & 1) != 0)
            {
                i1 += anInt311;
                k1--;
            }
        }
        if(anIntArrayArray321[k] == null)
        {
            method240(anIntArray317, aByteArrayArray322[k], anIntArrayArray323[k], j1, i1, l1, k1, i2, j2, byte0, l);
            return;
        } else
        {
            method239(anIntArray317, anIntArrayArray321[k], 0, j1, i1, l1, k1, i2, j2, byte0, l);
            return;
        }
    }

    public void method234(int i, int j, int k, int l, int i1, int j1)
    {
        try
        {
            int k1 = anIntArray324[i1];
            int l1 = anIntArray325[i1];
            int i2 = 0;
            int j2 = 0;
            int k2 = (k1 << 16) / k;
            int l2 = (l1 << 16) / l;
            if(aBooleanArray330[i1])
            {
                int i3 = anIntArray328[i1];
                int k3 = anIntArray329[i1];
                k2 = (i3 << 16) / k;
                l2 = (k3 << 16) / l;
                i += ((anIntArray326[i1] * k + i3) - 1) / i3;
                j += ((anIntArray327[i1] * l + k3) - 1) / k3;
                if((anIntArray326[i1] * k) % i3 != 0)
                    i2 = (i3 - (anIntArray326[i1] * k) % i3 << 16) / k;
                if((anIntArray327[i1] * l) % k3 != 0)
                    j2 = (k3 - (anIntArray327[i1] * l) % k3 << 16) / l;
                k = (k * (anIntArray324[i1] - (i2 >> 16))) / i3;
                l = (l * (anIntArray325[i1] - (j2 >> 16))) / k3;
            }
            int j3 = i + j * anInt311;
            int l3 = anInt311 - k;
            if(j < anInt331)
            {
                int i4 = anInt331 - j;
                l -= i4;
                j = 0;
                j3 += i4 * anInt311;
                j2 += l2 * i4;
            }
            if(j + l >= anInt332)
                l -= ((j + l) - anInt332) + 1;
            if(i < anInt333)
            {
                int j4 = anInt333 - i;
                k -= j4;
                i = 0;
                j3 += j4;
                i2 += k2 * j4;
                l3 += j4;
            }
            if(i + k >= anInt334)
            {
                int k4 = ((i + k) - anInt334) + 1;
                k -= k4;
                l3 += k4;
            }
            byte byte0 = 1;
            if(aBoolean335)
            {
                byte0 = 2;
                l3 += anInt311;
                l2 += l2;
                if((j & 1) != 0)
                {
                    j3 += anInt311;
                    l--;
                }
            }
            method241(anIntArray317, anIntArrayArray321[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    public void method235(int i, int j, int k, int l, int i1, int j1)
    {
        try
        {
            int k1 = anIntArray324[i1];
            int l1 = anIntArray325[i1];
            int i2 = 0;
            int j2 = 0;
            int k2 = (k1 << 16) / k;
            int l2 = (l1 << 16) / l;
            if(aBooleanArray330[i1])
            {
                int i3 = anIntArray328[i1];
                int k3 = anIntArray329[i1];
                k2 = (i3 << 16) / k;
                l2 = (k3 << 16) / l;
                i += ((anIntArray326[i1] * k + i3) - 1) / i3;
                j += ((anIntArray327[i1] * l + k3) - 1) / k3;
                if((anIntArray326[i1] * k) % i3 != 0)
                    i2 = (i3 - (anIntArray326[i1] * k) % i3 << 16) / k;
                if((anIntArray327[i1] * l) % k3 != 0)
                    j2 = (k3 - (anIntArray327[i1] * l) % k3 << 16) / l;
                k = (k * (anIntArray324[i1] - (i2 >> 16))) / i3;
                l = (l * (anIntArray325[i1] - (j2 >> 16))) / k3;
            }
            int j3 = i + j * anInt311;
            int l3 = anInt311 - k;
            if(j < anInt331)
            {
                int i4 = anInt331 - j;
                l -= i4;
                j = 0;
                j3 += i4 * anInt311;
                j2 += l2 * i4;
            }
            if(j + l >= anInt332)
                l -= ((j + l) - anInt332) + 1;
            if(i < anInt333)
            {
                int j4 = anInt333 - i;
                k -= j4;
                i = 0;
                j3 += j4;
                i2 += k2 * j4;
                l3 += j4;
            }
            if(i + k >= anInt334)
            {
                int k4 = ((i + k) - anInt334) + 1;
                k -= k4;
                l3 += k4;
            }
            byte byte0 = 1;
            if(aBoolean335)
            {
                byte0 = 2;
                l3 += anInt311;
                l2 += l2;
                if((j & 1) != 0)
                {
                    j3 += anInt311;
                    l--;
                }
            }
            method242(anIntArray317, anIntArrayArray321[i1], 0, i2, j2, j3, l3, k, l, k2, l2, k1, byte0, j1);
            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void method236(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        int i3 = anInt352;
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

    private void method237(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1)
    {
        int l2 = anInt352;
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

    private void method238(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2)
    {
        int l3 = anInt352;
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

    private void method239(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2)
    {
        int j3 = anInt352;
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

    private void method240(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1)
    {
        int j3 = anInt352;
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

    private void method241(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int k4 = anInt352;
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

    private void method242(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int k5 = anInt352;
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

    public void method243(int i, int j, int k, int l, int i1)
    {
        int l12 = anInt352;
        int j1 = anInt311;
        int k1 = anInt312;
        if(anIntArray339 == null)
        {
            anIntArray339 = new int[512];
            for(int l1 = 0; l1 < 256; l1++)
            {
                anIntArray339[l1] = (int)(Math.sin((double)l1 * 0.02454369D) * 32768D);
                anIntArray339[l1 + 256] = (int)(Math.cos((double)l1 * 0.02454369D) * 32768D);
            }

        }
        int i2 = -anIntArray328[k] / 2;
        int j2 = -anIntArray329[k] / 2;
        if(aBooleanArray330[k])
        {
            i2 += anIntArray326[k];
            j2 += anIntArray327[k];
        }
        int k2 = i2 + anIntArray324[k];
        int l2 = j2 + anIntArray325[k];
        int i3 = k2;
        int j3 = j2;
        int k3 = i2;
        int l3 = l2;
        l &= 0xff;
        int i4 = anIntArray339[l] * i1;
        int j4 = anIntArray339[l + 256] * i1;
        int k4 = i + (j2 * i4 + i2 * j4 >> 22);
        int l4 = j + (j2 * j4 - i2 * i4 >> 22);
        int i5 = i + (j3 * i4 + i3 * j4 >> 22);
        int j5 = j + (j3 * j4 - i3 * i4 >> 22);
        int k5 = i + (l2 * i4 + k2 * j4 >> 22);
        int l5 = j + (l2 * j4 - k2 * i4 >> 22);
        int i6 = i + (l3 * i4 + k3 * j4 >> 22);
        int j6 = j + (l3 * j4 - k3 * i4 >> 22);
        if(i1 == 192 && (l & 0x3f) == (anInt348 & 0x3f))
            anInt346++;
        else
        if(i1 == 128)
            anInt348 = l;
        else
            anInt347++;
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
        if(k6 < anInt331)
            k6 = anInt331;
        if(l6 > anInt332)
            l6 = anInt332;
        if(anIntArray340 == null || anIntArray340.length != k1 + 1)
        {
            anIntArray340 = new int[k1 + 1];
            anIntArray341 = new int[k1 + 1];
            anIntArray342 = new int[k1 + 1];
            anIntArray343 = new int[k1 + 1];
            anIntArray344 = new int[k1 + 1];
            anIntArray345 = new int[k1 + 1];
        }
        for(int i7 = k6; i7 <= l6; i7++)
        {
            anIntArray340[i7] = 0x5f5e0ff;
            anIntArray341[i7] = 0xfa0a1f01;
        }

        int i8 = 0;
        int k8 = 0;
        int i9 = 0;
        int j9 = anIntArray324[k];
        int k9 = anIntArray325[k];
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
            i9 = (l3 - j2 << 8) / (j6 - l4);
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
            l8 = j2 << 8;
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
            anIntArray340[l9] = anIntArray341[l9] = l7;
            l7 += i8;
            anIntArray342[l9] = anIntArray343[l9] = 0;
            anIntArray344[l9] = anIntArray345[l9] = l8;
            l8 += i9;
        }

        if(j5 != l4)
        {
            i8 = (i5 - k4 << 8) / (j5 - l4);
            k8 = (i3 - i2 << 8) / (j5 - l4);
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
            j8 = i2 << 8;
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
            if(l7 < anIntArray340[i10])
            {
                anIntArray340[i10] = l7;
                anIntArray342[i10] = j8;
                anIntArray344[i10] = 0;
            }
            if(l7 > anIntArray341[i10])
            {
                anIntArray341[i10] = l7;
                anIntArray343[i10] = j8;
                anIntArray345[i10] = 0;
            }
            l7 += i8;
            j8 += k8;
        }

        if(l5 != j5)
        {
            i8 = (k5 - i5 << 8) / (l5 - j5);
            i9 = (l2 - j3 << 8) / (l5 - j5);
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
            l8 = j3 << 8;
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
            if(l7 < anIntArray340[j10])
            {
                anIntArray340[j10] = l7;
                anIntArray342[j10] = j8;
                anIntArray344[j10] = l8;
            }
            if(l7 > anIntArray341[j10])
            {
                anIntArray341[j10] = l7;
                anIntArray343[j10] = j8;
                anIntArray345[j10] = l8;
            }
            l7 += i8;
            l8 += i9;
        }

        if(j6 != l5)
        {
            i8 = (i6 - k5 << 8) / (j6 - l5);
            k8 = (k3 - k2 << 8) / (j6 - l5);
        }
        if(l5 > j6)
        {
            l7 = i6 << 8;
            j8 = k3 << 8;
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
            if(l7 < anIntArray340[k10])
            {
                anIntArray340[k10] = l7;
                anIntArray342[k10] = j8;
                anIntArray344[k10] = l8;
            }
            if(l7 > anIntArray341[k10])
            {
                anIntArray341[k10] = l7;
                anIntArray343[k10] = j8;
                anIntArray345[k10] = l8;
            }
            l7 += i8;
            j8 += k8;
        }

        int l10 = k6 * j1;
        int ai[] = anIntArrayArray321[k];
        for(int i11 = k6; i11 < l6; i11++)
        {
            int j11 = anIntArray340[i11] >> 8;
            int k11 = anIntArray341[i11] >> 8;
            if(k11 - j11 <= 0)
            {
                l10 += j1;
            } else
            {
                int l11 = anIntArray342[i11] << 9;
                int i12 = ((anIntArray343[i11] << 9) - l11) / (k11 - j11);
                int j12 = anIntArray344[i11] << 9;
                int k12 = ((anIntArray345[i11] << 9) - j12) / (k11 - j11);
                if(j11 < anInt333)
                {
                    l11 += (anInt333 - j11) * i12;
                    j12 += (anInt333 - j11) * k12;
                    j11 = anInt333;
                }
                if(k11 > anInt334)
                    k11 = anInt334;
                if(!aBoolean335 || (i11 & 1) == 0)
                    if(!aBooleanArray330[k])
                        method244(anIntArray317, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
                    else
                        method245(anIntArray317, ai, 0, l10 + j11, l11, j12, i12, k12, j11 - k11, j9);
                l10 += j1;
            }
        }

    }

    private void method244(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        for(i = k1; i < 0; i++)
        {
            anIntArray317[j++] = ai1[(k >> 17) + (l >> 17) * l1];
            k += i1;
            l += j1;
        }

    }

    private void method245(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1)
    {
        int j2 = anInt352;
        for(int i2 = k1; i2 < 0; i2++)
        {
            i = ai1[(k >> 17) + (l >> 17) * l1];
            if(i != 0)
                anIntArray317[j++] = i;
            else
                j++;
            k += i1;
            l += j1;
        }

    }

    public void method246(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        method232(i, j, k, l, i1);
    }

    public void method247(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        try
        {
            if(j1 == 0)
                j1 = 0xffffff;
            if(k1 == 0)
                k1 = 0xffffff;
            int i2 = anIntArray324[i1];
            int j2 = anIntArray325[i1];
            int k2 = 0;
            int l2 = 0;
            int i3 = l1 << 16;
            int j3 = (i2 << 16) / k;
            int k3 = (j2 << 16) / l;
            int l3 = -(l1 << 16) / l;
            if(aBooleanArray330[i1])
            {
                int i4 = anIntArray328[i1];
                int k4 = anIntArray329[i1];
                j3 = (i4 << 16) / k;
                k3 = (k4 << 16) / l;
                int j5 = anIntArray326[i1];
                int k5 = anIntArray327[i1];
                if(flag)
                    j5 = i4 - anIntArray324[i1] - j5;
                i += ((j5 * k + i4) - 1) / i4;
                int l5 = ((k5 * l + k4) - 1) / k4;
                j += l5;
                i3 += l5 * l3;
                if((j5 * k) % i4 != 0)
                    k2 = (i4 - (j5 * k) % i4 << 16) / k;
                if((k5 * l) % k4 != 0)
                    l2 = (k4 - (k5 * l) % k4 << 16) / l;
                k = ((((anIntArray324[i1] << 16) - k2) + j3) - 1) / j3;
                l = ((((anIntArray325[i1] << 16) - l2) + k3) - 1) / k3;
            }
            int j4 = j * anInt311;
            i3 += i << 16;
            if(j < anInt331)
            {
                int l4 = anInt331 - j;
                l -= l4;
                j = anInt331;
                j4 += l4 * anInt311;
                l2 += k3 * l4;
                i3 += l3 * l4;
            }
            if(j + l >= anInt332)
                l -= ((j + l) - anInt332) + 1;
            int i5 = j4 / anInt311 & 1;
            if(!aBoolean335)
                i5 = 2;
            if(k1 == 0xffffff)
            {
                if(anIntArrayArray321[i1] != null)
                    if(!flag)
                    {
                        method248(anIntArray317, anIntArrayArray321[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
                        return;
                    } else
                    {
                        method248(anIntArray317, anIntArrayArray321[i1], 0, (anIntArray324[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
                        return;
                    }
                if(!flag)
                {
                    method250(anIntArray317, aByteArrayArray322[i1], anIntArrayArray323[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, i3, l3, i5);
                    return;
                } else
                {
                    method250(anIntArray317, aByteArrayArray322[i1], anIntArrayArray323[i1], 0, (anIntArray324[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, i3, l3, i5);
                    return;
                }
            }
            if(anIntArrayArray321[i1] != null)
                if(!flag)
                {
                    method249(anIntArray317, anIntArrayArray321[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
                    return;
                } else
                {
                    method249(anIntArray317, anIntArrayArray321[i1], 0, (anIntArray324[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
                    return;
                }
            if(!flag)
            {
                method251(anIntArray317, aByteArrayArray322[i1], anIntArrayArray323[i1], 0, k2, l2, j4, k, l, j3, k3, i2, j1, k1, i3, l3, i5);
                return;
            } else
            {
                method251(anIntArray317, aByteArrayArray322[i1], anIntArrayArray323[i1], 0, (anIntArray324[i1] << 16) - k2 - 1, l2, j4, k, l, -j3, k3, i2, j1, k1, i3, l3, i5);
                return;
            }
        }
        catch(Exception _ex)
        {
            System.out.println("error in sprite clipping routine");
        }
    }

    private void method248(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3)
    {
        int l6 = anInt352;
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
                if(k5 < anInt333)
                {
                    int i6 = anInt333 - k5;
                    l5 -= i6;
                    k5 = anInt333;
                    j += k1 * i6;
                }
                if(k5 + l5 >= anInt334)
                {
                    int j6 = (k5 + l5) - anInt334;
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
                l += anInt311;
                k2 += l2;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void method249(int ai[], int ai1[], int i, int j, int k, int l, int i1, 
            int j1, int k1, int l1, int i2, int j2, int k2, int l2, 
            int i3, int j3)
    {
        int l7 = anInt352;
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
                if(k6 < anInt333)
                {
                    int i7 = anInt333 - k6;
                    l6 -= i7;
                    k6 = anInt333;
                    j += k1 * i7;
                }
                if(k6 + l6 >= anInt334)
                {
                    int j7 = (k6 + l6) - anInt334;
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
                l += anInt311;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void method250(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, int i3)
    {
        int l6 = anInt352;
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
                if(k5 < anInt333)
                {
                    int i6 = anInt333 - k5;
                    l5 -= i6;
                    k5 = anInt333;
                    j += k1 * i6;
                }
                if(k5 + l5 >= anInt334)
                {
                    int j6 = (k5 + l5) - anInt334;
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
                l += anInt311;
                k2 += l2;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    private void method251(int ai[], byte abyte0[], int ai1[], int i, int j, int k, int l, 
            int i1, int j1, int k1, int l1, int i2, int j2, int k2, 
            int l2, int i3, int j3)
    {
        int l7 = anInt352;
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
                if(k6 < anInt333)
                {
                    int i7 = anInt333 - k6;
                    l6 -= i7;
                    k6 = anInt333;
                    j += k1 * i7;
                }
                if(k6 + l6 >= anInt334)
                {
                    int j7 = (k6 + l6) - anInt334;
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
                l += anInt311;
                l2 += i3;
            }

            return;
        }
        catch(Exception _ex)
        {
            System.out.println("error in transparent sprite plot routine");
        }
    }

    public static void method252(String s, int i, Applet_Sub1 applet_sub1)
    {
        int j1 = anInt352;
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
        FontMetrics fontmetrics = applet_sub1.getFontMetrics(font);
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        anInt350 = 855;
        for(int l = 0; l < 95; l++)
            method253(font, fontmetrics, s1.charAt(l), l, applet_sub1, i, flag1);

        aByteArrayArray336[i] = new byte[anInt350];
        for(int i1 = 0; i1 < anInt350; i1++)
            aByteArrayArray336[i][i1] = aByteArray351[i1];

        if(j == 1 && aBooleanArray349[i])
        {
            aBooleanArray349[i] = false;
            method252("f" + k + "p", i, applet_sub1);
        }
        if(flag && !aBooleanArray349[i])
        {
            aBooleanArray349[i] = false;
            method252("d" + k + "p", i, applet_sub1);
        }
    }

    public static void method253(Font font, FontMetrics fontmetrics, char c, int i, Applet_Sub1 applet_sub1, int j, boolean flag)
    {
        int k6 = anInt352;
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
        Image image = applet_sub1.createImage(k, j1);
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

        aByteArray351[i * 9] = (byte)(anInt350 / 16384);
        aByteArray351[i * 9 + 1] = (byte)(anInt350 / 128 & 0x7f);
        aByteArray351[i * 9 + 2] = (byte)(anInt350 & 0x7f);
        aByteArray351[i * 9 + 3] = (byte)(j2 - l1);
        aByteArray351[i * 9 + 4] = (byte)(k2 - i2);
        aByteArray351[i * 9 + 5] = (byte)l1;
        aByteArray351[i * 9 + 6] = (byte)(i1 - i2);
        aByteArray351[i * 9 + 7] = (byte)l;
        aByteArray351[i * 9 + 8] = (byte)k1;
        for(int k5 = i2; k5 < k2; k5++)
        {
            for(int i6 = l1; i6 < j2; i6++)
            {
                int j6 = ai[i6 + k5 * k] & 0xff;
                if(j6 > 30 && j6 < 230)
                    aBooleanArray349[j] = true;
                aByteArray351[anInt350++] = (byte)j6;
            }

        }

    }

    public void method254(String s, int i, int j, int k, int l)
    {
        method257(s, i - method263(s, k), j, k, l);
    }

    public void method255(String s, int i, int j, int k, int l)
    {
        method257(s, i - method263(s, k) / 2, j, k, l);
    }

    public void method256(String s, int i, int j, int k, int l, int i1)
    {
        int j2 = anInt352;
        try
        {
            int j1 = 0;
            byte abyte0[] = aByteArrayArray336[k];
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
                    j1 += abyte0[anIntArray337[s.charAt(i2)] + 7];
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
                    method255(s.substring(k1, l1), i, j, k, l);
                    j1 = 0;
                    k1 = i2 = l1 + 1;
                    j += method261(k);
                }
            }

            if(j1 > 0)
            {
                method255(s.substring(k1), i, j, k, l);
                return;
            }
        }
        catch(Exception exception)
        {
            System.out.println("centrepara: " + exception);
            exception.printStackTrace();
        }
    }

    public void method257(String s, int i, int j, int k, int l)
    {
        int k1 = anInt352;
        try
        {
            byte abyte0[] = aByteArrayArray336[k];
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
                    int j1 = anIntArray337[s.charAt(i1)];
                    if(aBoolean338 && !aBooleanArray349[k] && l != 0)
                        method258(j1, i + 1, j, 0, abyte0, aBooleanArray349[k]);
                    if(aBoolean338 && !aBooleanArray349[k] && l != 0)
                        method258(j1, i, j + 1, 0, abyte0, aBooleanArray349[k]);
                    method258(j1, i, j, l, abyte0, aBooleanArray349[k]);
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

    private void method258(int i, int j, int k, int l, byte abyte0[], boolean flag)
    {
        int i1 = j + abyte0[i + 5];
        int j1 = k - abyte0[i + 6];
        int k1 = abyte0[i + 3];
        int l1 = abyte0[i + 4];
        int i2 = abyte0[i] * 16384 + abyte0[i + 1] * 128 + abyte0[i + 2];
        int j2 = i1 + j1 * anInt311;
        int k2 = anInt311 - k1;
        int l2 = 0;
        if(j1 < anInt331)
        {
            int i3 = anInt331 - j1;
            l1 -= i3;
            j1 = anInt331;
            i2 += i3 * k1;
            j2 += i3 * anInt311;
        }
        if(j1 + l1 >= anInt332)
            l1 -= ((j1 + l1) - anInt332) + 1;
        if(i1 < anInt333)
        {
            int j3 = anInt333 - i1;
            k1 -= j3;
            i1 = anInt333;
            i2 += j3;
            j2 += j3;
            l2 += j3;
            k2 += j3;
        }
        if(i1 + k1 >= anInt334)
        {
            int k3 = ((i1 + k1) - anInt334) + 1;
            k1 -= k3;
            l2 += k3;
            k2 += k3;
        }
        if(k1 > 0 && l1 > 0)
        {
            if(flag)
            {
                method260(anIntArray317, abyte0, l, i2, j2, k1, l1, k2, l2);
                return;
            }
            method259(anIntArray317, abyte0, l, i2, j2, k1, l1, k2, l2);
        }
    }

    private void method259(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        int l2 = anInt352;
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

    private void method260(int ai[], byte abyte0[], int i, int j, int k, int l, int i1, 
            int j1, int k1)
    {
        int l2 = anInt352;
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

    public int method261(int i)
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
            return method262(i);
    }

    public int method262(int i)
    {
        if(i == 0)
            return aByteArrayArray336[i][8] - 2;
        else
            return aByteArrayArray336[i][8] - 1;
    }

    public int method263(String s, int i)
    {
        int l = anInt352;
        int j = 0;
        byte abyte0[] = aByteArrayArray336[i];
        for(int k = 0; k < s.length(); k++)
            if(s.charAt(k) == '@' && k + 4 < s.length() && s.charAt(k + 4) == '@')
                k += 4;
            else
            if(s.charAt(k) == '~' && k + 4 < s.length() && s.charAt(k + 4) == '~')
                k += 4;
            else
                j += abyte0[anIntArray337[s.charAt(k)] + 7];

        return j;
    }

    public synchronized void removeConsumer(ImageConsumer imageconsumer)
    {
        if(anImageConsumer318 == imageconsumer)
            anImageConsumer318 = null;
    }

    public void requestTopDownLeftRightResend(ImageConsumer imageconsumer)
    {
        System.out.println("TDLR");
    }

    public void startProduction(ImageConsumer imageconsumer)
    {
        addConsumer(imageconsumer);
    }

    public boolean aBoolean335;
    public boolean aBoolean338;
    public boolean aBooleanArray330[];
    private static boolean aBooleanArray349[] = new boolean[12];
    private static byte aByteArray351[] = new byte[0x186a0];
    public byte aByteArrayArray322[][];
    static byte aByteArrayArray336[][] = new byte[50][];
    ColorModel aColorModel316;
    private Component aComponent319;
    public Image anImage320;
    ImageConsumer anImageConsumer318;
    public int anInt311;
    public int anInt312;
    public int anInt313;
    public int anInt314;
    public int anInt315;
    private int anInt331;
    private int anInt332;
    private int anInt333;
    private int anInt334;
    public static int anInt346;
    public static int anInt347;
    public static int anInt348;
    private static int anInt350;
    public static int anInt352;
    public int anIntArray317[];
    public int anIntArray324[];
    public int anIntArray325[];
    public int anIntArray326[];
    public int anIntArray327[];
    public int anIntArray328[];
    public int anIntArray329[];
    static int anIntArray337[];
    int anIntArray339[];
    int anIntArray340[];
    int anIntArray341[];
    int anIntArray342[];
    int anIntArray343[];
    int anIntArray344[];
    int anIntArray345[];
    public int anIntArrayArray321[][];
    public int anIntArrayArray323[][];

    static 
    {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
        anIntArray337 = new int[256];
        for(int i = 0; i < 256; i++)
        {
            int j = s.indexOf(i);
            if(j == -1)
                j = 74;
            anIntArray337[i] = j * 9;
        }

    }
}
