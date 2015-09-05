// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class Class10
{

    public Class10(Class6 class6, int i, int j, int k)
    {
        super();
        int k1 = Class6.anInt352;
        anInt384 = 50;
        anIntArray385 = new int[anInt384];
        anIntArrayArray386 = new int[anInt384][256];
        anInt389 = 5;
        anInt390 = 1000;
        anInt391 = 1000;
        anInt392 = 20;
        anInt393 = 10;
        aBoolean396 = false;
        aDouble397 = 1.1000000000000001D;
        anInt398 = 1;
        aBoolean399 = false;
        anInt403 = 100;
        aClass5Array404 = new Class5[anInt403];
        anIntArray405 = new int[anInt403];
        anInt406 = 512;
        anInt407 = 256;
        anInt408 = 192;
        anInt409 = 256;
        anInt410 = 256;
        anInt411 = 8;
        anInt412 = 4;
        anIntArray451 = new int[40];
        anIntArray452 = new int[40];
        anIntArray453 = new int[40];
        anIntArray454 = new int[40];
        anIntArray455 = new int[40];
        anIntArray456 = new int[40];
        aBoolean457 = false;
        aClass6_446 = class6;
        anInt407 = class6.anInt311 / 2;
        anInt408 = class6.anInt312 / 2;
        anIntArray447 = class6.anIntArray317;
        anInt419 = 0;
        anInt420 = i;
        aClass5Array421 = new Class5[anInt420];
        anIntArray422 = new int[anInt420];
        anInt423 = 0;
        aClass7Array424 = new Class7[j];
        for(int l = 0; l < j; l++)
            aClass7Array424[l] = new Class7();

        anInt425 = 0;
        aClass5_433 = new Class5(k * 2, k);
        anIntArray426 = new int[k];
        anIntArray430 = new int[k];
        anIntArray431 = new int[k];
        anIntArray427 = new int[k];
        anIntArray428 = new int[k];
        anIntArray429 = new int[k];
        anIntArray432 = new int[k];
        if(aByteArray444 == null)
            aByteArray444 = new byte[17691];
        anInt413 = 0;
        anInt414 = 0;
        anInt415 = 0;
        anInt416 = 0;
        anInt417 = 0;
        anInt418 = 0;
        for(int i1 = 0; i1 < 256; i1++)
        {
            anIntArray395[i1] = (int)(Math.sin((double)i1 * 0.02454369D) * 32768D);
            anIntArray395[i1 + 256] = (int)(Math.cos((double)i1 * 0.02454369D) * 32768D);
        }

        for(int j1 = 0; j1 < 1024; j1++)
        {
            anIntArray394[j1] = (int)(Math.sin((double)j1 * 0.00613592315D) * 32768D);
            anIntArray394[j1 + 1024] = (int)(Math.cos((double)j1 * 0.00613592315D) * 32768D);
        }

        if(fnf.aBoolean556)
            Class6.anInt352 = ++k1;
    }

    public void method269(Class5 class5)
    {
        if(class5 == null)
            System.out.println("Warning tried to add null object!");
        if(anInt419 < anInt420)
        {
            anIntArray422[anInt419] = 0;
            aClass5Array421[anInt419++] = class5;
        }
    }

    public void method270(Class5 class5)
    {
        int k = Class6.anInt352;
        for(int i = 0; i < anInt419; i++)
            if(aClass5Array421[i] == class5)
            {
                anInt419--;
                for(int j = i; j < anInt419; j++)
                {
                    aClass5Array421[j] = aClass5Array421[j + 1];
                    anIntArray422[j] = anIntArray422[j + 1];
                }

            }

    }

    public void method271()
    {
        method272();
        for(int i = 0; i < anInt419; i++)
            aClass5Array421[i] = null;

        anInt419 = 0;
    }

    public void method272()
    {
        anInt425 = 0;
        aClass5_433.method177();
    }

    public void method273(int i)
    {
        anInt425 -= i;
        aClass5_433.method178(i, i * 2);
        if(anInt425 < 0)
            anInt425 = 0;
    }

    public int method274(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        anIntArray426[anInt425] = i;
        anIntArray427[anInt425] = j;
        anIntArray428[anInt425] = k;
        anIntArray429[anInt425] = l;
        anIntArray430[anInt425] = i1;
        anIntArray431[anInt425] = j1;
        anIntArray432[anInt425] = 0;
        int l1 = aClass5_433.method181(j, k, l);
        int i2 = aClass5_433.method181(j, k - j1, l);
        int ai[] = {
            l1, i2
        };
        aClass5_433.method182(2, ai, 0, 0);
        aClass5_433.anIntArray258[anInt425] = k1;
        aClass5_433.aByteArray259[anInt425++] = 0;
        return anInt425 - 1;
    }

    public void method275(int i)
    {
        aClass5_433.aByteArray259[i] = 1;
    }

    public void method276(int i, int j)
    {
        anIntArray432[i] = j;
    }

    public void method277(int i, int j)
    {
        anInt400 = i - anInt409;
        anInt401 = j;
        anInt402 = 0;
        aBoolean399 = true;
    }

    public int method278()
    {
        return anInt402;
    }

    public int[] method279()
    {
        return anIntArray405;
    }

    public Class5[] method280()
    {
        return aClass5Array404;
    }

    public void method281(int i, int j, int k, int l, int i1, int j1)
    {
        anInt407 = k;
        anInt408 = l;
        anInt409 = i;
        anInt410 = j;
        anInt406 = i1;
        anInt411 = j1;
        aClass9Array448 = new Class9[l + j];
        for(int k1 = 0; k1 < l + j; k1++)
            aClass9Array448[k1] = new Class9();

    }

    public void method282(Class7 aclass7[], int i, int j)
    {
        if(i < j)
        {
            int k = i - 1;
            int l = j + 1;
            int i1 = (i + j) / 2;
            Class7 class7 = aclass7[i1];
            aclass7[i1] = aclass7[i];
            aclass7[i] = class7;
            int j1 = class7.anInt361;
            while(k < l) 
            {
                do
                    l--;
                while(aclass7[l].anInt361 < j1);
                do
                    k++;
                while(aclass7[k].anInt361 > j1);
                if(k < l)
                {
                    Class7 class7_1 = aclass7[k];
                    aclass7[k] = aclass7[l];
                    aclass7[l] = class7_1;
                }
            }
            method282(aclass7, i, l);
            method282(aclass7, l + 1, j);
        }
    }

    public void method283(int i, Class7 aclass7[], int j)
    {
        int l1 = Class6.anInt352;
        for(int k = 0; k <= j; k++)
        {
            aclass7[k].aBoolean367 = false;
            aclass7[k].anInt368 = k;
            aclass7[k].anInt369 = -1;
        }

        int l = 0;
        do
        {
            while(aclass7[l].aBoolean367) 
                l++;
            if(l == j)
                return;
            Class7 class7 = aclass7[l];
            class7.aBoolean367 = true;
            int i1 = l;
            int j1 = l + i;
            if(j1 >= j)
                j1 = j - 1;
            for(int k1 = j1; k1 >= i1 + 1; k1--)
            {
                Class7 class7_1 = aclass7[k1];
                if(class7.anInt353 < class7_1.anInt355 && class7_1.anInt353 < class7.anInt355 && class7.anInt354 < class7_1.anInt356 && class7_1.anInt354 < class7.anInt356 && class7.anInt368 != class7_1.anInt369 && !method301(class7, class7_1) && method302(class7_1, class7))
                {
                    method284(aclass7, i1, k1);
                    if(aclass7[k1] != class7_1)
                        k1++;
                    i1 = anInt464;
                    class7_1.anInt369 = class7.anInt368;
                }
            }

        } while(true);
    }

    public boolean method284(Class7 aclass7[], int i, int j)
    {
        int i1 = Class6.anInt352;
        do
        {
            Class7 class7 = aclass7[i];
            for(int k = i + 1; k <= j; k++)
            {
                Class7 class7_1 = aclass7[k];
                if(!method301(class7_1, class7))
                    break;
                aclass7[i] = class7_1;
                aclass7[k] = class7;
                i = k;
                if(i == j)
                {
                    anInt464 = i;
                    anInt465 = i - 1;
                    return true;
                }
            }

            Class7 class7_2 = aclass7[j];
            for(int l = j - 1; l >= i; l--)
            {
                Class7 class7_3 = aclass7[l];
                if(!method301(class7_2, class7_3))
                    break;
                aclass7[j] = class7_3;
                aclass7[l] = class7_2;
                j = l;
                if(i == j)
                {
                    anInt464 = j + 1;
                    anInt465 = j;
                    return true;
                }
            }

            if(i + 1 >= j)
            {
                anInt464 = i;
                anInt465 = j;
                return false;
            }
            if(!method284(aclass7, i + 1, j))
            {
                anInt464 = i;
                return false;
            }
            j = anInt465;
        } while(true);
    }

    public void method285(int i, int j, int k)
    {
        int l = -anInt416 + 1024 & 0x3ff;
        int i1 = -anInt417 + 1024 & 0x3ff;
        int j1 = -anInt418 + 1024 & 0x3ff;
        if(j1 != 0)
        {
            int k1 = anIntArray394[j1];
            int j2 = anIntArray394[j1 + 1024];
            int i3 = j * k1 + i * j2 >> 15;
            j = j * j2 - i * k1 >> 15;
            i = i3;
        }
        if(l != 0)
        {
            int l1 = anIntArray394[l];
            int k2 = anIntArray394[l + 1024];
            int j3 = j * k2 - k * l1 >> 15;
            k = j * l1 + k * k2 >> 15;
            j = j3;
        }
        if(i1 != 0)
        {
            int i2 = anIntArray394[i1];
            int l2 = anIntArray394[i1 + 1024];
            int k3 = k * i2 + i * l2 >> 15;
            k = k * l2 - i * i2 >> 15;
            i = k3;
        }
        if(i < anInt458)
            anInt458 = i;
        if(i > anInt459)
            anInt459 = i;
        if(j < anInt460)
            anInt460 = j;
        if(j > anInt461)
            anInt461 = j;
        if(k < anInt462)
            anInt462 = k;
        if(k > anInt463)
            anInt463 = k;
    }

    public void method286()
    {
        int k12 = Class6.anInt352;
        aBoolean457 = aClass6_446.aBoolean335;
        int i3 = anInt407 * anInt390 >> anInt411;
        int j3 = anInt408 * anInt390 >> anInt411;
        anInt458 = 0;
        anInt459 = 0;
        anInt460 = 0;
        anInt461 = 0;
        anInt462 = 0;
        anInt463 = 0;
        method285(-i3, -j3, anInt390);
        method285(-i3, j3, anInt390);
        method285(i3, -j3, anInt390);
        method285(i3, j3, anInt390);
        method285(-anInt407, -anInt408, 0);
        method285(-anInt407, anInt408, 0);
        method285(anInt407, -anInt408, 0);
        method285(anInt407, anInt408, 0);
        anInt458 += anInt413;
        anInt459 += anInt413;
        anInt460 += anInt414;
        anInt461 += anInt414;
        anInt462 += anInt415;
        anInt463 += anInt415;
        aClass5Array421[anInt419] = aClass5_433;
        aClass5_433.anInt246 = 2;
        for(int i = 0; i < anInt419; i++)
            aClass5Array421[i].method202(anInt413, anInt414, anInt415, anInt416, anInt417, anInt418, anInt411, anInt389);

        aClass5Array421[anInt419].method202(anInt413, anInt414, anInt415, anInt416, anInt417, anInt418, anInt411, anInt389);
        anInt423 = 0;
        for(int k3 = 0; k3 < anInt419; k3++)
        {
            Class5 class5 = aClass5Array421[k3];
            if(class5.aBoolean247)
            {
                for(int j = 0; j < class5.anInt234; j++)
                {
                    int l3 = class5.anIntArray235[j];
                    int ai1[] = class5.anIntArrayArray236[j];
                    boolean flag = false;
                    for(int k4 = 0; k4 < l3; k4++)
                    {
                        int i1 = class5.anIntArray229[ai1[k4]];
                        if(i1 <= anInt389 || i1 >= anInt390)
                            continue;
                        flag = true;
                        break;
                    }

                    if(flag)
                    {
                        int l1 = 0;
                        for(int k5 = 0; k5 < l3; k5++)
                        {
                            int j1 = class5.anIntArray230[ai1[k5]];
                            if(j1 > -anInt407)
                                l1 |= 1;
                            if(j1 < anInt407)
                                l1 |= 2;
                            if(l1 == 3)
                                break;
                        }

                        if(l1 == 3)
                        {
                            int i2 = 0;
                            for(int l6 = 0; l6 < l3; l6++)
                            {
                                int k1 = class5.anIntArray231[ai1[l6]];
                                if(k1 > -anInt408)
                                    i2 |= 1;
                                if(k1 < anInt408)
                                    i2 |= 2;
                                if(i2 == 3)
                                    break;
                            }

                            if(i2 == 3)
                            {
                                Class7 class7_1 = aClass7Array424[anInt423];
                                class7_1.aClass5_359 = class5;
                                class7_1.anInt360 = j;
                                method299(anInt423);
                                int l8;
                                if(class7_1.anInt365 < 0)
                                    l8 = class5.anIntArray237[j];
                                else
                                    l8 = class5.anIntArray238[j];
                                if(l8 != 0xbc614e)
                                {
                                    int j2 = 0;
                                    for(int l9 = 0; l9 < l3; l9++)
                                        j2 += class5.anIntArray229[ai1[l9]];

                                    int l2;
                                    class7_1.anInt361 = l2 = j2 / l3 + class5.anInt245;
                                    class7_1.anInt366 = l8;
                                    anInt423++;
                                }
                            }
                        }
                    }
                }

            }
        }

        Class5 class5_1 = aClass5_433;
        if(class5_1.aBoolean247)
        {
            for(int k = 0; k < class5_1.anInt234; k++)
            {
                int ai[] = class5_1.anIntArrayArray236[k];
                int j4 = ai[0];
                int l4 = class5_1.anIntArray230[j4];
                int l5 = class5_1.anIntArray231[j4];
                int i7 = class5_1.anIntArray229[j4];
                if(i7 > anInt389 && i7 < anInt391)
                {
                    int i8 = (anIntArray430[k] << anInt411) / i7;
                    int i9 = (anIntArray431[k] << anInt411) / i7;
                    if(l4 - i8 / 2 <= anInt407 && l4 + i8 / 2 >= -anInt407 && l5 - i9 <= anInt408 && l5 >= -anInt408)
                    {
                        Class7 class7_2 = aClass7Array424[anInt423];
                        class7_2.aClass5_359 = class5_1;
                        class7_2.anInt360 = k;
                        method300(anInt423);
                        class7_2.anInt361 = (i7 + class5_1.anIntArray229[ai[1]]) / 2;
                        anInt423++;
                    }
                }
            }

        }
        if(anInt423 == 0)
            return;
        anInt388 = anInt423;
        method282(aClass7Array424, 0, anInt423 - 1);
        method283(100, aClass7Array424, anInt423);
        for(int i4 = 0; i4 < anInt423; i4++)
        {
            Class7 class7 = aClass7Array424[i4];
            Class5 class5_2 = class7.aClass5_359;
            int l = class7.anInt360;
            if(class5_2 == aClass5_433)
            {
                int ai2[] = class5_2.anIntArrayArray236[l];
                int i6 = ai2[0];
                int j7 = class5_2.anIntArray230[i6];
                int j8 = class5_2.anIntArray231[i6];
                int j9 = class5_2.anIntArray229[i6];
                int i10 = (anIntArray430[l] << anInt411) / j9;
                int k10 = (anIntArray431[l] << anInt411) / j9;
                int i11 = j8 - class5_2.anIntArray231[ai2[1]];
                int j11 = ((class5_2.anIntArray230[ai2[1]] - j7) * i11) / k10;
                j11 = class5_2.anIntArray230[ai2[1]] - j7;
                int l11 = j7 - i10 / 2;
                int j12 = (anInt410 + j8) - k10;
                aClass6_446.method246(l11 + anInt409, j12, i10, k10, anIntArray426[l], j11, (256 << anInt411) / j9);
                if(aBoolean399 && anInt402 < anInt403)
                {
                    l11 += (anIntArray432[l] << anInt411) / j9;
                    if(anInt401 >= j12 && anInt401 <= j12 + k10 && anInt400 >= l11 && anInt400 <= l11 + i10 && !class5_2.aBoolean263 && class5_2.aByteArray259[l] == 0)
                    {
                        aClass5Array404[anInt402] = class5_2;
                        anIntArray405[anInt402] = l;
                        anInt402++;
                    }
                }
            } else
            {
                int k8 = 0;
                int j10 = 0;
                int l10 = class5_2.anIntArray235[l];
                int ai3[] = class5_2.anIntArrayArray236[l];
                if(class5_2.anIntArray241[l] != 0xbc614e)
                    if(class7.anInt365 < 0)
                        j10 = class5_2.anInt308 - class5_2.anIntArray241[l];
                    else
                        j10 = class5_2.anInt308 + class5_2.anIntArray241[l];
                for(int k11 = 0; k11 < l10; k11++)
                {
                    int k2 = ai3[k11];
                    anIntArray454[k11] = class5_2.anIntArray227[k2];
                    anIntArray455[k11] = class5_2.anIntArray228[k2];
                    anIntArray456[k11] = class5_2.anIntArray229[k2];
                    if(class5_2.anIntArray241[l] == 0xbc614e)
                        if(class7.anInt365 < 0)
                            j10 = (class5_2.anInt308 - class5_2.anIntArray232[k2]) + class5_2.aByteArray233[k2];
                        else
                            j10 = class5_2.anInt308 + class5_2.anIntArray232[k2] + class5_2.aByteArray233[k2];
                    if(class5_2.anIntArray229[k2] >= anInt389)
                    {
                        anIntArray451[k8] = class5_2.anIntArray230[k2];
                        anIntArray452[k8] = class5_2.anIntArray231[k2];
                        anIntArray453[k8] = j10;
                        if(class5_2.anIntArray229[k2] > anInt393)
                            anIntArray453[k8] += (class5_2.anIntArray229[k2] - anInt393) / anInt392;
                        k8++;
                    } else
                    {
                        int k9;
                        if(k11 == 0)
                            k9 = ai3[l10 - 1];
                        else
                            k9 = ai3[k11 - 1];
                        if(class5_2.anIntArray229[k9] >= anInt389)
                        {
                            int k7 = class5_2.anIntArray229[k2] - class5_2.anIntArray229[k9];
                            int i5 = class5_2.anIntArray227[k2] - ((class5_2.anIntArray227[k2] - class5_2.anIntArray227[k9]) * (class5_2.anIntArray229[k2] - anInt389)) / k7;
                            int j6 = class5_2.anIntArray228[k2] - ((class5_2.anIntArray228[k2] - class5_2.anIntArray228[k9]) * (class5_2.anIntArray229[k2] - anInt389)) / k7;
                            anIntArray451[k8] = (i5 << anInt411) / anInt389;
                            anIntArray452[k8] = (j6 << anInt411) / anInt389;
                            anIntArray453[k8] = j10;
                            k8++;
                        }
                        if(k11 == l10 - 1)
                            k9 = ai3[0];
                        else
                            k9 = ai3[k11 + 1];
                        if(class5_2.anIntArray229[k9] >= anInt389)
                        {
                            int l7 = class5_2.anIntArray229[k2] - class5_2.anIntArray229[k9];
                            int j5 = class5_2.anIntArray227[k2] - ((class5_2.anIntArray227[k2] - class5_2.anIntArray227[k9]) * (class5_2.anIntArray229[k2] - anInt389)) / l7;
                            int k6 = class5_2.anIntArray228[k2] - ((class5_2.anIntArray228[k2] - class5_2.anIntArray228[k9]) * (class5_2.anIntArray229[k2] - anInt389)) / l7;
                            anIntArray451[k8] = (j5 << anInt411) / anInt389;
                            anIntArray452[k8] = (k6 << anInt411) / anInt389;
                            anIntArray453[k8] = j10;
                            k8++;
                        }
                    }
                }

                for(int i12 = 0; i12 < l10; i12++)
                {
                    if(anIntArray453[i12] < 0)
                        anIntArray453[i12] = 0;
                    else
                    if(anIntArray453[i12] > 255)
                        anIntArray453[i12] = 255;
                    if(class7.anInt366 >= 0)
                        if(anIntArray437[class7.anInt366] == 1)
                            anIntArray453[i12] <<= 9;
                        else
                            anIntArray453[i12] <<= 6;
                }

                method287(0, 0, 0, 0, k8, anIntArray451, anIntArray452, anIntArray453, class5_2, l);
                if(anInt450 > anInt449)
                    method288(0, 0, l10, anIntArray454, anIntArray455, anIntArray456, class7.anInt366, class5_2);
            }
        }

        aBoolean399 = false;
    }

    public void method287(int i, int j, int k, int l, int i1, int ai[], int ai1[], 
            int ai2[], Class5 class5, int j1)
    {
        int k24 = Class6.anInt352;
        if(i1 == 3)
        {
            int k1 = ai1[0] + anInt410;
            int k2 = ai1[1] + anInt410;
            int k3 = ai1[2] + anInt410;
            int k4 = ai[0];
            int l5 = ai[1];
            int j7 = ai[2];
            int l8 = ai2[0];
            int j10 = ai2[1];
            int j11 = ai2[2];
            int j12 = (anInt410 + anInt408) - 1;
            int l12 = 0;
            int j13 = 0;
            int l13 = 0;
            int j14 = 0;
            int l14 = 0xbc614e;
            int j15 = 0xff439eb2;
            if(k3 != k1)
            {
                j13 = (j7 - k4 << 8) / (k3 - k1);
                j14 = (j11 - l8 << 8) / (k3 - k1);
                if(k1 < k3)
                {
                    l12 = k4 << 8;
                    l13 = l8 << 8;
                    l14 = k1;
                    j15 = k3;
                } else
                {
                    l12 = j7 << 8;
                    l13 = j11 << 8;
                    l14 = k3;
                    j15 = k1;
                }
                if(l14 < 0)
                {
                    l12 -= j13 * l14;
                    l13 -= j14 * l14;
                    l14 = 0;
                }
                if(j15 > j12)
                    j15 = j12;
            }
            int l15 = 0;
            int j16 = 0;
            int l16 = 0;
            int j17 = 0;
            int l17 = 0xbc614e;
            int j18 = 0xff439eb2;
            if(k2 != k1)
            {
                j16 = (l5 - k4 << 8) / (k2 - k1);
                j17 = (j10 - l8 << 8) / (k2 - k1);
                if(k1 < k2)
                {
                    l15 = k4 << 8;
                    l16 = l8 << 8;
                    l17 = k1;
                    j18 = k2;
                } else
                {
                    l15 = l5 << 8;
                    l16 = j10 << 8;
                    l17 = k2;
                    j18 = k1;
                }
                if(l17 < 0)
                {
                    l15 -= j16 * l17;
                    l16 -= j17 * l17;
                    l17 = 0;
                }
                if(j18 > j12)
                    j18 = j12;
            }
            int l18 = 0;
            int j19 = 0;
            int l19 = 0;
            int j20 = 0;
            int l20 = 0xbc614e;
            int j21 = 0xff439eb2;
            if(k3 != k2)
            {
                j19 = (j7 - l5 << 8) / (k3 - k2);
                j20 = (j11 - j10 << 8) / (k3 - k2);
                if(k2 < k3)
                {
                    l18 = l5 << 8;
                    l19 = j10 << 8;
                    l20 = k2;
                    j21 = k3;
                } else
                {
                    l18 = j7 << 8;
                    l19 = j11 << 8;
                    l20 = k3;
                    j21 = k2;
                }
                if(l20 < 0)
                {
                    l18 -= j19 * l20;
                    l19 -= j20 * l20;
                    l20 = 0;
                }
                if(j21 > j12)
                    j21 = j12;
            }
            anInt449 = l14;
            if(l17 < anInt449)
                anInt449 = l17;
            if(l20 < anInt449)
                anInt449 = l20;
            anInt450 = j15;
            if(j18 > anInt450)
                anInt450 = j18;
            if(j21 > anInt450)
                anInt450 = j21;
            int l21 = 0;
            for(k = anInt449; k < anInt450; k++)
            {
                if(k >= l14 && k < j15)
                {
                    i = j = l12;
                    l = l21 = l13;
                    l12 += j13;
                    l13 += j14;
                } else
                {
                    i = 0xa0000;
                    j = 0xfff60000;
                }
                if(k >= l17 && k < j18)
                {
                    if(l15 < i)
                    {
                        i = l15;
                        l = l16;
                    }
                    if(l15 > j)
                    {
                        j = l15;
                        l21 = l16;
                    }
                    l15 += j16;
                    l16 += j17;
                }
                if(k >= l20 && k < j21)
                {
                    if(l18 < i)
                    {
                        i = l18;
                        l = l19;
                    }
                    if(l18 > j)
                    {
                        j = l18;
                        l21 = l19;
                    }
                    l18 += j19;
                    l19 += j20;
                }
                Class9 class9_6 = aClass9Array448[k];
                class9_6.anInt380 = i;
                class9_6.anInt381 = j;
                class9_6.anInt382 = l;
                class9_6.anInt383 = l21;
            }

            if(anInt449 < anInt410 - anInt408)
                anInt449 = anInt410 - anInt408;
        } else
        if(i1 == 4)
        {
            int l1 = ai1[0] + anInt410;
            int l2 = ai1[1] + anInt410;
            int l3 = ai1[2] + anInt410;
            int l4 = ai1[3] + anInt410;
            int i6 = ai[0];
            int k7 = ai[1];
            int i9 = ai[2];
            int k10 = ai[3];
            int k11 = ai2[0];
            int k12 = ai2[1];
            int i13 = ai2[2];
            int k13 = ai2[3];
            int i14 = (anInt410 + anInt408) - 1;
            int k14 = 0;
            int i15 = 0;
            int k15 = 0;
            int i16 = 0;
            int k16 = 0xbc614e;
            int i17 = 0xff439eb2;
            if(l4 != l1)
            {
                i15 = (k10 - i6 << 8) / (l4 - l1);
                i16 = (k13 - k11 << 8) / (l4 - l1);
                if(l1 < l4)
                {
                    k14 = i6 << 8;
                    k15 = k11 << 8;
                    k16 = l1;
                    i17 = l4;
                } else
                {
                    k14 = k10 << 8;
                    k15 = k13 << 8;
                    k16 = l4;
                    i17 = l1;
                }
                if(k16 < 0)
                {
                    k14 -= i15 * k16;
                    k15 -= i16 * k16;
                    k16 = 0;
                }
                if(i17 > i14)
                    i17 = i14;
            }
            int k17 = 0;
            int i18 = 0;
            int k18 = 0;
            int i19 = 0;
            int k19 = 0xbc614e;
            int i20 = 0xff439eb2;
            if(l2 != l1)
            {
                i18 = (k7 - i6 << 8) / (l2 - l1);
                i19 = (k12 - k11 << 8) / (l2 - l1);
                if(l1 < l2)
                {
                    k17 = i6 << 8;
                    k18 = k11 << 8;
                    k19 = l1;
                    i20 = l2;
                } else
                {
                    k17 = k7 << 8;
                    k18 = k12 << 8;
                    k19 = l2;
                    i20 = l1;
                }
                if(k19 < 0)
                {
                    k17 -= i18 * k19;
                    k18 -= i19 * k19;
                    k19 = 0;
                }
                if(i20 > i14)
                    i20 = i14;
            }
            int k20 = 0;
            int i21 = 0;
            int k21 = 0;
            int i22 = 0;
            int j22 = 0xbc614e;
            int k22 = 0xff439eb2;
            if(l3 != l2)
            {
                i21 = (i9 - k7 << 8) / (l3 - l2);
                i22 = (i13 - k12 << 8) / (l3 - l2);
                if(l2 < l3)
                {
                    k20 = k7 << 8;
                    k21 = k12 << 8;
                    j22 = l2;
                    k22 = l3;
                } else
                {
                    k20 = i9 << 8;
                    k21 = i13 << 8;
                    j22 = l3;
                    k22 = l2;
                }
                if(j22 < 0)
                {
                    k20 -= i21 * j22;
                    k21 -= i22 * j22;
                    j22 = 0;
                }
                if(k22 > i14)
                    k22 = i14;
            }
            int l22 = 0;
            int i23 = 0;
            int j23 = 0;
            int k23 = 0;
            int l23 = 0xbc614e;
            int i24 = 0xff439eb2;
            if(l4 != l3)
            {
                i23 = (k10 - i9 << 8) / (l4 - l3);
                k23 = (k13 - i13 << 8) / (l4 - l3);
                if(l3 < l4)
                {
                    l22 = i9 << 8;
                    j23 = i13 << 8;
                    l23 = l3;
                    i24 = l4;
                } else
                {
                    l22 = k10 << 8;
                    j23 = k13 << 8;
                    l23 = l4;
                    i24 = l3;
                }
                if(l23 < 0)
                {
                    l22 -= i23 * l23;
                    j23 -= k23 * l23;
                    l23 = 0;
                }
                if(i24 > i14)
                    i24 = i14;
            }
            anInt449 = k16;
            if(k19 < anInt449)
                anInt449 = k19;
            if(j22 < anInt449)
                anInt449 = j22;
            if(l23 < anInt449)
                anInt449 = l23;
            anInt450 = i17;
            if(i20 > anInt450)
                anInt450 = i20;
            if(k22 > anInt450)
                anInt450 = k22;
            if(i24 > anInt450)
                anInt450 = i24;
            int j24 = 0;
            for(k = anInt449; k < anInt450; k++)
            {
                if(k >= k16 && k < i17)
                {
                    i = j = k14;
                    l = j24 = k15;
                    k14 += i15;
                    k15 += i16;
                } else
                {
                    i = 0xa0000;
                    j = 0xfff60000;
                }
                if(k >= k19 && k < i20)
                {
                    if(k17 < i)
                    {
                        i = k17;
                        l = k18;
                    }
                    if(k17 > j)
                    {
                        j = k17;
                        j24 = k18;
                    }
                    k17 += i18;
                    k18 += i19;
                }
                if(k >= j22 && k < k22)
                {
                    if(k20 < i)
                    {
                        i = k20;
                        l = k21;
                    }
                    if(k20 > j)
                    {
                        j = k20;
                        j24 = k21;
                    }
                    k20 += i21;
                    k21 += i22;
                }
                if(k >= l23 && k < i24)
                {
                    if(l22 < i)
                    {
                        i = l22;
                        l = j23;
                    }
                    if(l22 > j)
                    {
                        j = l22;
                        j24 = j23;
                    }
                    l22 += i23;
                    j23 += k23;
                }
                Class9 class9_7 = aClass9Array448[k];
                class9_7.anInt380 = i;
                class9_7.anInt381 = j;
                class9_7.anInt382 = l;
                class9_7.anInt383 = j24;
            }

            if(anInt449 < anInt410 - anInt408)
                anInt449 = anInt410 - anInt408;
        } else
        {
            anInt450 = anInt449 = ai1[0] += anInt410;
            for(k = 1; k < i1; k++)
            {
                int i2;
                if((i2 = ai1[k] += anInt410) < anInt449)
                    anInt449 = i2;
                else
                if(i2 > anInt450)
                    anInt450 = i2;
            }

            if(anInt449 < anInt410 - anInt408)
                anInt449 = anInt410 - anInt408;
            if(anInt450 >= anInt410 + anInt408)
                anInt450 = (anInt410 + anInt408) - 1;
            if(anInt449 >= anInt450)
                return;
            for(k = anInt449; k < anInt450; k++)
            {
                Class9 class9 = aClass9Array448[k];
                class9.anInt380 = 0xa0000;
                class9.anInt381 = 0xfff60000;
            }

            int j2 = i1 - 1;
            int i3 = ai1[0];
            int i4 = ai1[j2];
            if(i3 < i4)
            {
                int i5 = ai[0] << 8;
                int j6 = (ai[j2] - ai[0] << 8) / (i4 - i3);
                int l7 = ai2[0] << 8;
                int j9 = (ai2[j2] - ai2[0] << 8) / (i4 - i3);
                if(i3 < 0)
                {
                    i5 -= j6 * i3;
                    l7 -= j9 * i3;
                    i3 = 0;
                }
                if(i4 > anInt450)
                    i4 = anInt450;
                for(k = i3; k <= i4; k++)
                {
                    Class9 class9_2 = aClass9Array448[k];
                    class9_2.anInt380 = class9_2.anInt381 = i5;
                    class9_2.anInt382 = class9_2.anInt383 = l7;
                    i5 += j6;
                    l7 += j9;
                }

            } else
            if(i3 > i4)
            {
                int j5 = ai[j2] << 8;
                int k6 = (ai[0] - ai[j2] << 8) / (i3 - i4);
                int i8 = ai2[j2] << 8;
                int k9 = (ai2[0] - ai2[j2] << 8) / (i3 - i4);
                if(i4 < 0)
                {
                    j5 -= k6 * i4;
                    i8 -= k9 * i4;
                    i4 = 0;
                }
                if(i3 > anInt450)
                    i3 = anInt450;
                for(k = i4; k <= i3; k++)
                {
                    Class9 class9_3 = aClass9Array448[k];
                    class9_3.anInt380 = class9_3.anInt381 = j5;
                    class9_3.anInt382 = class9_3.anInt383 = i8;
                    j5 += k6;
                    i8 += k9;
                }

            }
            for(k = 0; k < j2; k++)
            {
                int k5 = k + 1;
                int j3 = ai1[k];
                int j4 = ai1[k5];
                if(j3 < j4)
                {
                    int l6 = ai[k] << 8;
                    int j8 = (ai[k5] - ai[k] << 8) / (j4 - j3);
                    int l9 = ai2[k] << 8;
                    int l10 = (ai2[k5] - ai2[k] << 8) / (j4 - j3);
                    if(j3 < 0)
                    {
                        l6 -= j8 * j3;
                        l9 -= l10 * j3;
                        j3 = 0;
                    }
                    if(j4 > anInt450)
                        j4 = anInt450;
                    for(int l11 = j3; l11 <= j4; l11++)
                    {
                        Class9 class9_4 = aClass9Array448[l11];
                        if(l6 < class9_4.anInt380)
                        {
                            class9_4.anInt380 = l6;
                            class9_4.anInt382 = l9;
                        }
                        if(l6 > class9_4.anInt381)
                        {
                            class9_4.anInt381 = l6;
                            class9_4.anInt383 = l9;
                        }
                        l6 += j8;
                        l9 += l10;
                    }

                } else
                if(j3 > j4)
                {
                    int i7 = ai[k5] << 8;
                    int k8 = (ai[k] - ai[k5] << 8) / (j3 - j4);
                    int i10 = ai2[k5] << 8;
                    int i11 = (ai2[k] - ai2[k5] << 8) / (j3 - j4);
                    if(j4 < 0)
                    {
                        i7 -= k8 * j4;
                        i10 -= i11 * j4;
                        j4 = 0;
                    }
                    if(j3 > anInt450)
                        j3 = anInt450;
                    for(int i12 = j4; i12 <= j3; i12++)
                    {
                        Class9 class9_5 = aClass9Array448[i12];
                        if(i7 < class9_5.anInt380)
                        {
                            class9_5.anInt380 = i7;
                            class9_5.anInt382 = i10;
                        }
                        if(i7 > class9_5.anInt381)
                        {
                            class9_5.anInt381 = i7;
                            class9_5.anInt383 = i10;
                        }
                        i7 += k8;
                        i10 += i11;
                    }

                }
            }

            if(anInt449 < anInt410 - anInt408)
                anInt449 = anInt410 - anInt408;
        }
        if(aBoolean399 && anInt402 < anInt403 && anInt401 >= anInt449 && anInt401 < anInt450)
        {
            Class9 class9_1 = aClass9Array448[anInt401];
            if(anInt400 >= class9_1.anInt380 >> 8 && anInt400 <= class9_1.anInt381 >> 8 && class9_1.anInt380 <= class9_1.anInt381 && !class5.aBoolean263 && class5.aByteArray259[j1] == 0)
            {
                aClass5Array404[anInt402] = class5;
                anIntArray405[anInt402] = j1;
                anInt402++;
            }
        }
    }

    public void method288(int i, int j, int k, int ai[], int ai1[], int ai2[], int l, 
            Class5 class5)
    {
        int i25 = Class6.anInt352;
        if(l == -2)
            return;
        if(l >= 0)
        {
            if(l >= anInt434)
                l = 0;
            method305(l);
            int i1 = ai[0];
            int k1 = ai1[0];
            int j2 = ai2[0];
            int i3 = i1 - ai[1];
            int k3 = k1 - ai1[1];
            int i4 = j2 - ai2[1];
            k--;
            int i6 = ai[k] - i1;
            int j7 = ai1[k] - k1;
            int k8 = ai2[k] - j2;
            if(anIntArray437[l] == 1)
            {
                int l9 = i6 * k1 - j7 * i1 << 12;
                int k10 = j7 * j2 - k8 * k1 << (5 - anInt411) + 7 + 4;
                int i11 = k8 * i1 - i6 * j2 << (5 - anInt411) + 7;
                int k11 = i3 * k1 - k3 * i1 << 12;
                int i12 = k3 * j2 - i4 * k1 << (5 - anInt411) + 7 + 4;
                int k12 = i4 * i1 - i3 * j2 << (5 - anInt411) + 7;
                int i13 = k3 * i6 - i3 * j7 << 5;
                int k13 = i4 * j7 - k3 * k8 << (5 - anInt411) + 4;
                int i14 = i3 * k8 - i4 * i6 >> anInt411 - 5;
                int k14 = k10 >> 4;
                int i15 = i12 >> 4;
                int k15 = k13 >> 4;
                int i16 = anInt449 - anInt410;
                int k16 = anInt406;
                int i17 = anInt409 + anInt449 * k16;
                byte byte1 = 1;
                l9 += i11 * i16;
                k11 += k12 * i16;
                i13 += i14 * i16;
                if(aBoolean457)
                {
                    if((anInt449 & 1) == 1)
                    {
                        anInt449++;
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    }
                    i11 <<= 1;
                    k12 <<= 1;
                    i14 <<= 1;
                    k16 <<= 1;
                    byte1 = 2;
                }
                if(class5.aBoolean255)
                {
                    for(i = anInt449; i < anInt450; i += byte1)
                    {
                        Class9 class9_3 = aClass9Array448[i];
                        j = class9_3.anInt380 >> 8;
                        int k17 = class9_3.anInt381 >> 8;
                        int k20 = k17 - j;
                        if(k20 <= 0)
                        {
                            l9 += i11;
                            k11 += k12;
                            i13 += i14;
                            i17 += k16;
                        } else
                        {
                            int i22 = class9_3.anInt382;
                            int k23 = (class9_3.anInt383 - i22) / k20;
                            if(j < -anInt407)
                            {
                                i22 += (-anInt407 - j) * k23;
                                j = -anInt407;
                                k20 = k17 - j;
                            }
                            if(k17 > anInt407)
                            {
                                int l17 = anInt407;
                                k20 = l17 - j;
                            }
                            method290(anIntArray447, anIntArrayArray439[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, k20, i17 + j, i22, k23 << 2);
                            l9 += i11;
                            k11 += k12;
                            i13 += i14;
                            i17 += k16;
                        }
                    }

                    return;
                }
                if(!aBooleanArray440[l])
                {
                    for(i = anInt449; i < anInt450; i += byte1)
                    {
                        Class9 class9_4 = aClass9Array448[i];
                        j = class9_4.anInt380 >> 8;
                        int i18 = class9_4.anInt381 >> 8;
                        int l20 = i18 - j;
                        if(l20 <= 0)
                        {
                            l9 += i11;
                            k11 += k12;
                            i13 += i14;
                            i17 += k16;
                        } else
                        {
                            int j22 = class9_4.anInt382;
                            int l23 = (class9_4.anInt383 - j22) / l20;
                            if(j < -anInt407)
                            {
                                j22 += (-anInt407 - j) * l23;
                                j = -anInt407;
                                l20 = i18 - j;
                            }
                            if(i18 > anInt407)
                            {
                                int j18 = anInt407;
                                l20 = j18 - j;
                            }
                            method289(anIntArray447, anIntArrayArray439[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, l20, i17 + j, j22, l23 << 2);
                            l9 += i11;
                            k11 += k12;
                            i13 += i14;
                            i17 += k16;
                        }
                    }

                    return;
                }
                for(i = anInt449; i < anInt450; i += byte1)
                {
                    Class9 class9_5 = aClass9Array448[i];
                    j = class9_5.anInt380 >> 8;
                    int k18 = class9_5.anInt381 >> 8;
                    int i21 = k18 - j;
                    if(i21 <= 0)
                    {
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    } else
                    {
                        int k22 = class9_5.anInt382;
                        int i24 = (class9_5.anInt383 - k22) / i21;
                        if(j < -anInt407)
                        {
                            k22 += (-anInt407 - j) * i24;
                            j = -anInt407;
                            i21 = k18 - j;
                        }
                        if(k18 > anInt407)
                        {
                            int l18 = anInt407;
                            i21 = l18 - j;
                        }
                        method291(anIntArray447, 0, 0, 0, anIntArrayArray439[l], l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, i21, i17 + j, k22, i24);
                        l9 += i11;
                        k11 += k12;
                        i13 += i14;
                        i17 += k16;
                    }
                }

                return;
            }
            int i10 = i6 * k1 - j7 * i1 << 11;
            int l10 = j7 * j2 - k8 * k1 << (5 - anInt411) + 6 + 4;
            int j11 = k8 * i1 - i6 * j2 << (5 - anInt411) + 6;
            int l11 = i3 * k1 - k3 * i1 << 11;
            int j12 = k3 * j2 - i4 * k1 << (5 - anInt411) + 6 + 4;
            int l12 = i4 * i1 - i3 * j2 << (5 - anInt411) + 6;
            int j13 = k3 * i6 - i3 * j7 << 5;
            int l13 = i4 * j7 - k3 * k8 << (5 - anInt411) + 4;
            int j14 = i3 * k8 - i4 * i6 >> anInt411 - 5;
            int l14 = l10 >> 4;
            int j15 = j12 >> 4;
            int l15 = l13 >> 4;
            int j16 = anInt449 - anInt410;
            int l16 = anInt406;
            int j17 = anInt409 + anInt449 * l16;
            byte byte2 = 1;
            i10 += j11 * j16;
            l11 += l12 * j16;
            j13 += j14 * j16;
            if(aBoolean457)
            {
                if((anInt449 & 1) == 1)
                {
                    anInt449++;
                    i10 += j11;
                    l11 += l12;
                    j13 += j14;
                    j17 += l16;
                }
                j11 <<= 1;
                l12 <<= 1;
                j14 <<= 1;
                l16 <<= 1;
                byte2 = 2;
            }
            if(class5.aBoolean255)
            {
                for(i = anInt449; i < anInt450; i += byte2)
                {
                    Class9 class9_6 = aClass9Array448[i];
                    j = class9_6.anInt380 >> 8;
                    int i19 = class9_6.anInt381 >> 8;
                    int j21 = i19 - j;
                    if(j21 <= 0)
                    {
                        i10 += j11;
                        l11 += l12;
                        j13 += j14;
                        j17 += l16;
                    } else
                    {
                        int l22 = class9_6.anInt382;
                        int j24 = (class9_6.anInt383 - l22) / j21;
                        if(j < -anInt407)
                        {
                            l22 += (-anInt407 - j) * j24;
                            j = -anInt407;
                            j21 = i19 - j;
                        }
                        if(i19 > anInt407)
                        {
                            int j19 = anInt407;
                            j21 = j19 - j;
                        }
                        method293(anIntArray447, anIntArrayArray439[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, j21, j17 + j, l22, j24);
                        i10 += j11;
                        l11 += l12;
                        j13 += j14;
                        j17 += l16;
                    }
                }

                return;
            }
            if(!aBooleanArray440[l])
            {
                for(i = anInt449; i < anInt450; i += byte2)
                {
                    Class9 class9_7 = aClass9Array448[i];
                    j = class9_7.anInt380 >> 8;
                    int k19 = class9_7.anInt381 >> 8;
                    int k21 = k19 - j;
                    if(k21 <= 0)
                    {
                        i10 += j11;
                        l11 += l12;
                        j13 += j14;
                        j17 += l16;
                    } else
                    {
                        int i23 = class9_7.anInt382;
                        int k24 = (class9_7.anInt383 - i23) / k21;
                        if(j < -anInt407)
                        {
                            i23 += (-anInt407 - j) * k24;
                            j = -anInt407;
                            k21 = k19 - j;
                        }
                        if(k19 > anInt407)
                        {
                            int l19 = anInt407;
                            k21 = l19 - j;
                        }
                        method292(anIntArray447, anIntArrayArray439[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, k21, j17 + j, i23, k24);
                        i10 += j11;
                        l11 += l12;
                        j13 += j14;
                        j17 += l16;
                    }
                }

                return;
            }
            for(i = anInt449; i < anInt450; i += byte2)
            {
                Class9 class9_8 = aClass9Array448[i];
                j = class9_8.anInt380 >> 8;
                int i20 = class9_8.anInt381 >> 8;
                int l21 = i20 - j;
                if(l21 <= 0)
                {
                    i10 += j11;
                    l11 += l12;
                    j13 += j14;
                    j17 += l16;
                } else
                {
                    int j23 = class9_8.anInt382;
                    int l24 = (class9_8.anInt383 - j23) / l21;
                    if(j < -anInt407)
                    {
                        j23 += (-anInt407 - j) * l24;
                        j = -anInt407;
                        l21 = i20 - j;
                    }
                    if(i20 > anInt407)
                    {
                        int j20 = anInt407;
                        l21 = j20 - j;
                    }
                    method294(anIntArray447, 0, 0, 0, anIntArrayArray439[l], i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, l21, j17 + j, j23, l24);
                    i10 += j11;
                    l11 += l12;
                    j13 += j14;
                    j17 += l16;
                }
            }

            return;
        }
        for(int j1 = 0; j1 < anInt384; j1++)
        {
            if(anIntArray385[j1] == l)
            {
                anIntArray387 = anIntArrayArray386[j1];
                break;
            }
            if(j1 == anInt384 - 1)
            {
                int l1 = (int)(Math.random() * (double)anInt384);
                anIntArray385[l1] = l;
                l = -1 - l;
                int k2 = (l >> 10 & 0x1f) * 8;
                int j3 = (l >> 5 & 0x1f) * 8;
                int l3 = (l & 0x1f) * 8;
                for(int j4 = 0; j4 < 256; j4++)
                {
                    int j6 = j4 * j4;
                    int k7 = (k2 * j6) / 0x10000;
                    int l8 = (j3 * j6) / 0x10000;
                    int j10 = (l3 * j6) / 0x10000;
                    anIntArrayArray386[l1][255 - j4] = (k7 << 16) + (l8 << 8) + j10;
                }

                anIntArray387 = anIntArrayArray386[l1];
            }
        }

        int i2 = anInt406;
        int l2 = anInt409 + anInt449 * i2;
        byte byte0 = 1;
        if(aBoolean457)
        {
            if((anInt449 & 1) == 1)
            {
                anInt449++;
                l2 += i2;
            }
            i2 <<= 1;
            byte0 = 2;
        }
        if(class5.aBoolean256)
        {
            for(i = anInt449; i < anInt450; i += byte0)
            {
                Class9 class9 = aClass9Array448[i];
                j = class9.anInt380 >> 8;
                int k4 = class9.anInt381 >> 8;
                int k6 = k4 - j;
                if(k6 <= 0)
                {
                    l2 += i2;
                } else
                {
                    int l7 = class9.anInt382;
                    int i9 = (class9.anInt383 - l7) / k6;
                    if(j < -anInt407)
                    {
                        l7 += (-anInt407 - j) * i9;
                        j = -anInt407;
                        k6 = k4 - j;
                    }
                    if(k4 > anInt407)
                    {
                        int l4 = anInt407;
                        k6 = l4 - j;
                    }
                    method296(anIntArray447, -k6, l2 + j, 0, anIntArray387, l7, i9);
                    l2 += i2;
                }
            }

            return;
        }
        if(aBoolean396)
        {
            for(i = anInt449; i < anInt450; i += byte0)
            {
                Class9 class9_1 = aClass9Array448[i];
                j = class9_1.anInt380 >> 8;
                int i5 = class9_1.anInt381 >> 8;
                int l6 = i5 - j;
                if(l6 <= 0)
                {
                    l2 += i2;
                } else
                {
                    int i8 = class9_1.anInt382;
                    int j9 = (class9_1.anInt383 - i8) / l6;
                    if(j < -anInt407)
                    {
                        i8 += (-anInt407 - j) * j9;
                        j = -anInt407;
                        l6 = i5 - j;
                    }
                    if(i5 > anInt407)
                    {
                        int j5 = anInt407;
                        l6 = j5 - j;
                    }
                    method295(anIntArray447, -l6, l2 + j, 0, anIntArray387, i8, j9);
                    l2 += i2;
                }
            }

            return;
        }
        for(i = anInt449; i < anInt450; i += byte0)
        {
            Class9 class9_2 = aClass9Array448[i];
            j = class9_2.anInt380 >> 8;
            int k5 = class9_2.anInt381 >> 8;
            int i7 = k5 - j;
            if(i7 <= 0)
            {
                l2 += i2;
            } else
            {
                int j8 = class9_2.anInt382;
                int k9 = (class9_2.anInt383 - j8) / i7;
                if(j < -anInt407)
                {
                    j8 += (-anInt407 - j) * k9;
                    j = -anInt407;
                    i7 = k5 - j;
                }
                if(k5 > anInt407)
                {
                    int l5 = anInt407;
                    i7 = l5 - j;
                }
                method297(anIntArray447, -i7, l2 + j, 0, anIntArray387, j8, k9);
                l2 += i2;
            }
        }

    }

    public static void method289(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int l4 = Class6.anInt352;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        int i4 = 0;
        if(i1 != 0)
        {
            i = k / i1 << 7;
            j = l / i1 << 7;
        }
        if(i < 0)
            i = 0;
        else
        if(i > 16256)
            i = 16256;
        k += j1;
        l += k1;
        i1 += l1;
        if(i1 != 0)
        {
            i3 = k / i1 << 7;
            j3 = l / i1 << 7;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 16256)
            i3 = 16256;
        int k3 = i3 - i >> 4;
        int l3 = j3 - j >> 4;
        for(int j4 = i2 >> 4; j4 > 0; j4--)
        {
            i += k2 & 0x600000;
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i = i3;
            j = j3;
            k += j1;
            l += k1;
            i1 += l1;
            if(i1 != 0)
            {
                i3 = k / i1 << 7;
                j3 = l / i1 << 7;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 16256)
                i3 = 16256;
            k3 = i3 - i >> 4;
            l3 = j3 - j >> 4;
        }

        for(int k4 = 0; k4 < (i2 & 0xf); k4++)
        {
            if((k4 & 3) == 0)
            {
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
            }
            ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
            i += k3;
            j += l3;
        }

    }

    public static void method290(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int l4 = Class6.anInt352;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        int i4 = 0;
        if(i1 != 0)
        {
            i = k / i1 << 7;
            j = l / i1 << 7;
        }
        if(i < 0)
            i = 0;
        else
        if(i > 16256)
            i = 16256;
        k += j1;
        l += k1;
        i1 += l1;
        if(i1 != 0)
        {
            i3 = k / i1 << 7;
            j3 = l / i1 << 7;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 16256)
            i3 = 16256;
        int k3 = i3 - i >> 4;
        int l3 = j3 - j >> 4;
        for(int j4 = i2 >> 4; j4 > 0; j4--)
        {
            i += k2 & 0x600000;
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            i = (i & 0x3fff) + (k2 & 0x600000);
            i4 = k2 >> 23;
            k2 += l2;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i = i3;
            j = j3;
            k += j1;
            l += k1;
            i1 += l1;
            if(i1 != 0)
            {
                i3 = k / i1 << 7;
                j3 = l / i1 << 7;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 16256)
                i3 = 16256;
            k3 = i3 - i >> 4;
            l3 = j3 - j >> 4;
        }

        for(int k4 = 0; k4 < (i2 & 0xf); k4++)
        {
            if((k4 & 3) == 0)
            {
                i = (i & 0x3fff) + (k2 & 0x600000);
                i4 = k2 >> 23;
                k2 += l2;
            }
            ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
            i += k3;
            j += l3;
        }

    }

    public static void method291(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        int i5 = Class6.anInt352;
        if(j2 <= 0)
            return;
        int j3 = 0;
        int k3 = 0;
        i3 <<= 2;
        if(j1 != 0)
        {
            j3 = l / j1 << 7;
            k3 = i1 / j1 << 7;
        }
        if(j3 < 0)
            j3 = 0;
        else
        if(j3 > 16256)
            j3 = 16256;
        for(int j4 = j2; j4 > 0; j4 -= 16)
        {
            l += k1;
            i1 += l1;
            j1 += i2;
            j = j3;
            k = k3;
            if(j1 != 0)
            {
                j3 = l / j1 << 7;
                k3 = i1 / j1 << 7;
            }
            if(j3 < 0)
                j3 = 0;
            else
            if(j3 > 16256)
                j3 = 16256;
            int l3 = j3 - j >> 4;
            int i4 = k3 - k >> 4;
            int k4 = l2 >> 23;
            j += l2 & 0x600000;
            l2 += i3;
            if(j4 < 16)
            {
                for(int l4 = 0; l4 < j4; l4++)
                {
                    if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                        ai[k2] = i;
                    k2++;
                    j += l3;
                    k += i4;
                    if((l4 & 3) == 3)
                    {
                        j = (j & 0x3fff) + (l2 & 0x600000);
                        k4 = l2 >> 23;
                        l2 += i3;
                    }
                }

            } else
            {
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0x3fff) + (l2 & 0x600000);
                k4 = l2 >> 23;
                l2 += i3;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
            }
        }

    }

    public static void method292(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int l4 = Class6.anInt352;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        l2 <<= 2;
        if(i1 != 0)
        {
            i3 = k / i1 << 6;
            j3 = l / i1 << 6;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 4032)
            i3 = 4032;
        for(int i4 = i2; i4 > 0; i4 -= 16)
        {
            k += j1;
            l += k1;
            i1 += l1;
            i = i3;
            j = j3;
            if(i1 != 0)
            {
                i3 = k / i1 << 6;
                j3 = l / i1 << 6;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 4032)
                i3 = 4032;
            int k3 = i3 - i >> 4;
            int l3 = j3 - j >> 4;
            int j4 = k2 >> 20;
            i += k2 & 0xc0000;
            k2 += l2;
            if(i4 < 16)
            {
                for(int k4 = 0; k4 < i4; k4++)
                {
                    ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                    i += k3;
                    j += l3;
                    if((k4 & 3) == 3)
                    {
                        i = (i & 0xfff) + (k2 & 0xc0000);
                        j4 = k2 >> 20;
                        k2 += l2;
                    }
                }

            } else
            {
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
                i += k3;
                j += l3;
                ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
            }
        }

    }

    public static void method293(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2)
    {
        int l4 = Class6.anInt352;
        if(i2 <= 0)
            return;
        int i3 = 0;
        int j3 = 0;
        l2 <<= 2;
        if(i1 != 0)
        {
            i3 = k / i1 << 6;
            j3 = l / i1 << 6;
        }
        if(i3 < 0)
            i3 = 0;
        else
        if(i3 > 4032)
            i3 = 4032;
        for(int i4 = i2; i4 > 0; i4 -= 16)
        {
            k += j1;
            l += k1;
            i1 += l1;
            i = i3;
            j = j3;
            if(i1 != 0)
            {
                i3 = k / i1 << 6;
                j3 = l / i1 << 6;
            }
            if(i3 < 0)
                i3 = 0;
            else
            if(i3 > 4032)
                i3 = 4032;
            int k3 = i3 - i >> 4;
            int l3 = j3 - j >> 4;
            int j4 = k2 >> 20;
            i += k2 & 0xc0000;
            k2 += l2;
            if(i4 < 16)
            {
                for(int k4 = 0; k4 < i4; k4++)
                {
                    ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                    i += k3;
                    j += l3;
                    if((k4 & 3) == 3)
                    {
                        i = (i & 0xfff) + (k2 & 0xc0000);
                        j4 = k2 >> 20;
                        k2 += l2;
                    }
                }

            } else
            {
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                i = (i & 0xfff) + (k2 & 0xc0000);
                j4 = k2 >> 20;
                k2 += l2;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
                i += k3;
                j += l3;
                ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
            }
        }

    }

    public static void method294(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3)
    {
        int i5 = Class6.anInt352;
        if(j2 <= 0)
            return;
        int j3 = 0;
        int k3 = 0;
        i3 <<= 2;
        if(j1 != 0)
        {
            j3 = l / j1 << 6;
            k3 = i1 / j1 << 6;
        }
        if(j3 < 0)
            j3 = 0;
        else
        if(j3 > 4032)
            j3 = 4032;
        for(int j4 = j2; j4 > 0; j4 -= 16)
        {
            l += k1;
            i1 += l1;
            j1 += i2;
            j = j3;
            k = k3;
            if(j1 != 0)
            {
                j3 = l / j1 << 6;
                k3 = i1 / j1 << 6;
            }
            if(j3 < 0)
                j3 = 0;
            else
            if(j3 > 4032)
                j3 = 4032;
            int l3 = j3 - j >> 4;
            int i4 = k3 - k >> 4;
            int k4 = l2 >> 20;
            j += l2 & 0xc0000;
            l2 += i3;
            if(j4 < 16)
            {
                for(int l4 = 0; l4 < j4; l4++)
                {
                    if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                        ai[k2] = i;
                    k2++;
                    j += l3;
                    k += i4;
                    if((l4 & 3) == 3)
                    {
                        j = (j & 0xfff) + (l2 & 0xc0000);
                        k4 = l2 >> 20;
                        l2 += i3;
                    }
                }

            } else
            {
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                j = (j & 0xfff) + (l2 & 0xc0000);
                k4 = l2 >> 20;
                l2 += i3;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
                j += l3;
                k += i4;
                if((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
                    ai[k2] = i;
                k2++;
            }
        }

    }

    public static void method295(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        int i2 = Class6.anInt352;
        if(i >= 0)
            return;
        i1 <<= 1;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 8;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 8);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k;
            if((l1 & 1) == 1)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
            }
        }

    }

    public static void method296(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        int i2 = Class6.anInt352;
        if(i >= 0)
            return;
        i1 <<= 2;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 16;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 16);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
            if((l1 & 3) == 3)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
                l += i1;
            }
        }

    }

    public static void method297(int ai[], int i, int j, int k, int ai1[], int l, int i1)
    {
        int i2 = Class6.anInt352;
        if(i >= 0)
            return;
        i1 <<= 2;
        k = ai1[l >> 8 & 0xff];
        l += i1;
        int j1 = i / 16;
        for(int k1 = j1; k1 < 0; k1++)
        {
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            ai[j++] = k;
            k = ai1[l >> 8 & 0xff];
            l += i1;
        }

        j1 = -(i % 16);
        for(int l1 = 0; l1 < j1; l1++)
        {
            ai[j++] = k;
            if((l1 & 3) == 3)
            {
                k = ai1[l >> 8 & 0xff];
                l += i1;
            }
        }

    }

    public void method298(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        l &= 0x3ff;
        i1 &= 0x3ff;
        j1 &= 0x3ff;
        anInt416 = 1024 - l & 0x3ff;
        anInt417 = 1024 - i1 & 0x3ff;
        anInt418 = 1024 - j1 & 0x3ff;
        int l1 = 0;
        int i2 = 0;
        int j2 = k1;
        if(l != 0)
        {
            int k2 = anIntArray394[l];
            int j3 = anIntArray394[l + 1024];
            int i4 = i2 * j3 - j2 * k2 >> 15;
            j2 = i2 * k2 + j2 * j3 >> 15;
            i2 = i4;
        }
        if(i1 != 0)
        {
            int l2 = anIntArray394[i1];
            int k3 = anIntArray394[i1 + 1024];
            int j4 = j2 * l2 + l1 * k3 >> 15;
            j2 = j2 * k3 - l1 * l2 >> 15;
            l1 = j4;
        }
        if(j1 != 0)
        {
            int i3 = anIntArray394[j1];
            int l3 = anIntArray394[j1 + 1024];
            int k4 = i2 * i3 + l1 * l3 >> 15;
            i2 = i2 * l3 - l1 * i3 >> 15;
            l1 = k4;
        }
        anInt413 = i - l1;
        anInt414 = j - i2;
        anInt415 = k - j2;
    }

    public void method299(int i)
    {
        int i6 = Class6.anInt352;
        Class7 class7 = aClass7Array424[i];
        Class5 class5 = class7.aClass5_359;
        int j = class7.anInt360;
        int ai[] = class5.anIntArrayArray236[j];
        int k = class5.anIntArray235[j];
        int l = class5.anIntArray240[j];
        int j1 = class5.anIntArray227[ai[0]];
        int k1 = class5.anIntArray228[ai[0]];
        int l1 = class5.anIntArray229[ai[0]];
        int i2 = class5.anIntArray227[ai[1]] - j1;
        int j2 = class5.anIntArray228[ai[1]] - k1;
        int k2 = class5.anIntArray229[ai[1]] - l1;
        int l2 = class5.anIntArray227[ai[2]] - j1;
        int i3 = class5.anIntArray228[ai[2]] - k1;
        int j3 = class5.anIntArray229[ai[2]] - l1;
        int k3 = j2 * j3 - i3 * k2;
        int l3 = k2 * l2 - j3 * i2;
        int i4 = i2 * i3 - l2 * j2;
        if(l == -1)
        {
            l = 0;
            for(; k3 > 25000 || l3 > 25000 || i4 > 25000 || k3 < -25000 || l3 < -25000 || i4 < -25000; i4 >>= 1)
            {
                l++;
                k3 >>= 1;
                l3 >>= 1;
            }

            class5.anIntArray240[j] = l;
            class5.anIntArray239[j] = (int)((double)anInt412 * Math.sqrt(k3 * k3 + l3 * l3 + i4 * i4));
        } else
        {
            k3 >>= l;
            l3 >>= l;
            i4 >>= l;
        }
        class7.anInt365 = j1 * k3 + k1 * l3 + l1 * i4;
        class7.anInt362 = k3;
        class7.anInt363 = l3;
        class7.anInt364 = i4;
        int j4 = class5.anIntArray229[ai[0]];
        int k4 = j4;
        int l4 = class5.anIntArray230[ai[0]];
        int i5 = l4;
        int j5 = class5.anIntArray231[ai[0]];
        int k5 = j5;
        for(int l5 = 1; l5 < k; l5++)
        {
            int i1 = class5.anIntArray229[ai[l5]];
            if(i1 > k4)
                k4 = i1;
            else
            if(i1 < j4)
                j4 = i1;
            i1 = class5.anIntArray230[ai[l5]];
            if(i1 > i5)
                i5 = i1;
            else
            if(i1 < l4)
                l4 = i1;
            i1 = class5.anIntArray231[ai[l5]];
            if(i1 > k5)
                k5 = i1;
            else
            if(i1 < j5)
                j5 = i1;
        }

        class7.anInt357 = j4;
        class7.anInt358 = k4;
        class7.anInt353 = l4;
        class7.anInt355 = i5;
        class7.anInt354 = j5;
        class7.anInt356 = k5;
    }

    public void method300(int i)
    {
        int l3 = Class6.anInt352;
        Class7 class7 = aClass7Array424[i];
        Class5 class5 = class7.aClass5_359;
        int j = class7.anInt360;
        int ai[] = class5.anIntArrayArray236[j];
        int l = 0;
        int i1 = 0;
        int j1 = 1;
        int k1 = class5.anIntArray227[ai[0]];
        int l1 = class5.anIntArray228[ai[0]];
        int i2 = class5.anIntArray229[ai[0]];
        class5.anIntArray239[j] = 1;
        class5.anIntArray240[j] = 0;
        class7.anInt365 = k1 * l + l1 * i1 + i2 * j1;
        class7.anInt362 = l;
        class7.anInt363 = i1;
        class7.anInt364 = j1;
        int j2 = class5.anIntArray229[ai[0]];
        int k2 = j2;
        int l2 = class5.anIntArray230[ai[0]];
        int i3 = l2;
        if(class5.anIntArray230[ai[1]] < l2)
            l2 = class5.anIntArray230[ai[1]];
        else
            i3 = class5.anIntArray230[ai[1]];
        int j3 = class5.anIntArray231[ai[1]];
        int k3 = class5.anIntArray231[ai[0]];
        int k = class5.anIntArray229[ai[1]];
        if(k > k2)
            k2 = k;
        else
        if(k < j2)
            j2 = k;
        k = class5.anIntArray230[ai[1]];
        if(k > i3)
            i3 = k;
        else
        if(k < l2)
            l2 = k;
        k = class5.anIntArray231[ai[1]];
        if(k > k3)
            k3 = k;
        else
        if(k < j3)
            j3 = k;
        class7.anInt357 = j2;
        class7.anInt358 = k2;
        class7.anInt353 = l2 - 20;
        class7.anInt355 = i3 + 20;
        class7.anInt354 = j3;
        class7.anInt356 = k3;
    }

    public boolean method301(Class7 class7, Class7 class7_1)
    {
        int k6 = Class6.anInt352;
        if(class7.anInt353 >= class7_1.anInt355)
            return true;
        if(class7_1.anInt353 >= class7.anInt355)
            return true;
        if(class7.anInt354 >= class7_1.anInt356)
            return true;
        if(class7_1.anInt354 >= class7.anInt356)
            return true;
        if(class7.anInt357 >= class7_1.anInt358)
            return true;
        if(class7_1.anInt357 > class7.anInt358)
            return false;
        Class5 class5 = class7.aClass5_359;
        Class5 class5_1 = class7_1.aClass5_359;
        int i = class7.anInt360;
        int j = class7_1.anInt360;
        int ai[] = class5.anIntArrayArray236[i];
        int ai1[] = class5_1.anIntArrayArray236[j];
        int k = class5.anIntArray235[i];
        int l = class5_1.anIntArray235[j];
        int k2 = class5_1.anIntArray227[ai1[0]];
        int l2 = class5_1.anIntArray228[ai1[0]];
        int i3 = class5_1.anIntArray229[ai1[0]];
        int j3 = class7_1.anInt362;
        int k3 = class7_1.anInt363;
        int l3 = class7_1.anInt364;
        int i4 = class5_1.anIntArray239[j];
        int j4 = class7_1.anInt365;
        boolean flag = false;
        for(int k4 = 0; k4 < k; k4++)
        {
            int i1 = ai[k4];
            int i2 = (k2 - class5.anIntArray227[i1]) * j3 + (l2 - class5.anIntArray228[i1]) * k3 + (i3 - class5.anIntArray229[i1]) * l3;
            if((i2 >= -i4 || j4 >= 0) && (i2 <= i4 || j4 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        k2 = class5.anIntArray227[ai[0]];
        l2 = class5.anIntArray228[ai[0]];
        i3 = class5.anIntArray229[ai[0]];
        j3 = class7.anInt362;
        k3 = class7.anInt363;
        l3 = class7.anInt364;
        i4 = class5.anIntArray239[i];
        j4 = class7.anInt365;
        flag = false;
        for(int l4 = 0; l4 < l; l4++)
        {
            int j1 = ai1[l4];
            int j2 = (k2 - class5_1.anIntArray227[j1]) * j3 + (l2 - class5_1.anIntArray228[j1]) * k3 + (i3 - class5_1.anIntArray229[j1]) * l3;
            if((j2 >= -i4 || j4 <= 0) && (j2 <= i4 || j4 >= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        int ai2[];
        int ai3[];
        if(k == 2)
        {
            ai2 = new int[4];
            ai3 = new int[4];
            int i5 = ai[0];
            int k1 = ai[1];
            ai2[0] = class5.anIntArray230[i5] - 20;
            ai2[1] = class5.anIntArray230[k1] - 20;
            ai2[2] = class5.anIntArray230[k1] + 20;
            ai2[3] = class5.anIntArray230[i5] + 20;
            ai3[0] = ai3[3] = class5.anIntArray231[i5];
            ai3[1] = ai3[2] = class5.anIntArray231[k1];
        } else
        {
            ai2 = new int[k];
            ai3 = new int[k];
            for(int j5 = 0; j5 < k; j5++)
            {
                int i6 = ai[j5];
                ai2[j5] = class5.anIntArray230[i6];
                ai3[j5] = class5.anIntArray231[i6];
            }

        }
        int ai4[];
        int ai5[];
        if(l == 2)
        {
            ai4 = new int[4];
            ai5 = new int[4];
            int k5 = ai1[0];
            int l1 = ai1[1];
            ai4[0] = class5_1.anIntArray230[k5] - 20;
            ai4[1] = class5_1.anIntArray230[l1] - 20;
            ai4[2] = class5_1.anIntArray230[l1] + 20;
            ai4[3] = class5_1.anIntArray230[k5] + 20;
            ai5[0] = ai5[3] = class5_1.anIntArray231[k5];
            ai5[1] = ai5[2] = class5_1.anIntArray231[l1];
        } else
        {
            ai4 = new int[l];
            ai5 = new int[l];
            for(int l5 = 0; l5 < l; l5++)
            {
                int j6 = ai1[l5];
                ai4[l5] = class5_1.anIntArray230[j6];
                ai5[l5] = class5_1.anIntArray231[j6];
            }

        }
        return !method315(ai2, ai3, ai4, ai5);
    }

    public boolean method302(Class7 class7, Class7 class7_1)
    {
        int k4 = Class6.anInt352;
        Class5 class5 = class7.aClass5_359;
        Class5 class5_1 = class7_1.aClass5_359;
        int i = class7.anInt360;
        int j = class7_1.anInt360;
        int ai[] = class5.anIntArrayArray236[i];
        int ai1[] = class5_1.anIntArrayArray236[j];
        int k = class5.anIntArray235[i];
        int l = class5_1.anIntArray235[j];
        int i2 = class5_1.anIntArray227[ai1[0]];
        int j2 = class5_1.anIntArray228[ai1[0]];
        int k2 = class5_1.anIntArray229[ai1[0]];
        int l2 = class7_1.anInt362;
        int i3 = class7_1.anInt363;
        int j3 = class7_1.anInt364;
        int k3 = class5_1.anIntArray239[j];
        int l3 = class7_1.anInt365;
        boolean flag = false;
        for(int i4 = 0; i4 < k; i4++)
        {
            int i1 = ai[i4];
            int k1 = (i2 - class5.anIntArray227[i1]) * l2 + (j2 - class5.anIntArray228[i1]) * i3 + (k2 - class5.anIntArray229[i1]) * j3;
            if((k1 >= -k3 || l3 >= 0) && (k1 <= k3 || l3 <= 0))
                continue;
            flag = true;
            break;
        }

        if(!flag)
            return true;
        i2 = class5.anIntArray227[ai[0]];
        j2 = class5.anIntArray228[ai[0]];
        k2 = class5.anIntArray229[ai[0]];
        l2 = class7.anInt362;
        i3 = class7.anInt363;
        j3 = class7.anInt364;
        k3 = class5.anIntArray239[i];
        l3 = class7.anInt365;
        flag = false;
        for(int j4 = 0; j4 < l; j4++)
        {
            int j1 = ai1[j4];
            int l1 = (i2 - class5_1.anIntArray227[j1]) * l2 + (j2 - class5_1.anIntArray228[j1]) * i3 + (k2 - class5_1.anIntArray229[j1]) * j3;
            if((l1 >= -k3 || l3 <= 0) && (l1 <= k3 || l3 >= 0))
                continue;
            flag = true;
            break;
        }

        return !flag;
    }

    public void method303(int i, int j, int k)
    {
        anInt434 = i;
        aByteArrayArray435 = new byte[i][];
        anIntArrayArray436 = new int[i][];
        anIntArray437 = new int[i];
        aLongArray438 = new long[i];
        aBooleanArray440 = new boolean[i];
        anIntArrayArray439 = new int[i][];
        aLong441 = 0L;
        anIntArrayArray442 = new int[j][];
        anIntArrayArray443 = new int[k][];
    }

    public void method304(int i, byte abyte0[], int ai[], int j)
    {
        aByteArrayArray435[i] = abyte0;
        anIntArrayArray436[i] = ai;
        anIntArray437[i] = j;
        aLongArray438[i] = 0L;
        aBooleanArray440[i] = false;
        anIntArrayArray439[i] = null;
        method305(i);
    }

    public void method305(int i)
    {
        int j2 = Class6.anInt352;
        if(i < 0)
            return;
        aLongArray438[i] = aLong441++;
        if(anIntArrayArray439[i] != null)
            return;
        if(anIntArray437[i] == 0)
        {
            for(int j = 0; j < anIntArrayArray442.length; j++)
                if(anIntArrayArray442[j] == null)
                {
                    anIntArrayArray442[j] = new int[16384];
                    anIntArrayArray439[i] = anIntArrayArray442[j];
                    method306(i);
                    return;
                }

            long l = 1L << 30;
            int i1 = 0;
            for(int k1 = 0; k1 < anInt434; k1++)
                if(k1 != i && anIntArray437[k1] == 0 && anIntArrayArray439[k1] != null && aLongArray438[k1] < l)
                {
                    l = aLongArray438[k1];
                    i1 = k1;
                }

            anIntArrayArray439[i] = anIntArrayArray439[i1];
            anIntArrayArray439[i1] = null;
            method306(i);
            return;
        }
        for(int k = 0; k < anIntArrayArray443.length; k++)
            if(anIntArrayArray443[k] == null)
            {
                anIntArrayArray443[k] = new int[0x10000];
                anIntArrayArray439[i] = anIntArrayArray443[k];
                method306(i);
                return;
            }

        long l1 = 1L << 30;
        int j1 = 0;
        for(int i2 = 0; i2 < anInt434; i2++)
            if(i2 != i && anIntArray437[i2] == 1 && anIntArrayArray439[i2] != null && aLongArray438[i2] < l1)
            {
                l1 = aLongArray438[i2];
                j1 = i2;
            }

        anIntArrayArray439[i] = anIntArrayArray439[j1];
        anIntArrayArray439[j1] = null;
        method306(i);
    }

    public void method306(int i)
    {
        int l1 = Class6.anInt352;
        char c;
        if(anIntArray437[i] == 0)
            c = '@';
        else
            c = '\200';
        int ai[] = anIntArrayArray439[i];
        int j = 0;
        for(int k = 0; k < c; k++)
        {
            for(int l = 0; l < c; l++)
            {
                int j1 = anIntArrayArray436[i][aByteArrayArray435[i][l + k * c] & 0xff];
                j1 &= 0xf8f8ff;
                if(j1 == 0)
                    j1 = 1;
                else
                if(j1 == 0xf800ff)
                {
                    j1 = 0;
                    aBooleanArray440[i] = true;
                }
                ai[j++] = j1;
            }

        }

        for(int i1 = 0; i1 < j; i1++)
        {
            int k1 = ai[i1];
            ai[j + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
            ai[j * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
            ai[j * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
        }

    }

    public void method307(int i)
    {
        int l1 = Class6.anInt352;
        if(anIntArrayArray439[i] == null)
            return;
        int ai[] = anIntArrayArray439[i];
        for(int j = 0; j < 64; j++)
        {
            int k = j + 4032;
            int l = ai[k];
            for(int j1 = 0; j1 < 63; j1++)
            {
                ai[k] = ai[k - 64];
                k -= 64;
            }

            anIntArrayArray439[i][k] = l;
        }

        char c = '\u1000';
        for(int i1 = 0; i1 < c; i1++)
        {
            int k1 = ai[i1];
            ai[c + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
            ai[c * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
            ai[c * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
        }

    }

    public int method308(int i)
    {
        if(i == 0xbc614e)
            return 0;
        method305(i);
        if(i >= 0)
            return anIntArrayArray439[i][0];
        if(i < 0)
        {
            i = -(i + 1);
            int j = i >> 10 & 0x1f;
            int k = i >> 5 & 0x1f;
            int l = i & 0x1f;
            return (j << 19) + (k << 11) + (l << 3);
        } else
        {
            return 0;
        }
    }

    public void method309(int i, int j, int k)
    {
        if(i == 0 && j == 0 && k == 0)
            i = 32;
        for(int l = 0; l < anInt419; l++)
            aClass5Array421[l].method187(i, j, k);

    }

    public void method310(int i, int j, int k, int l, int i1)
    {
        if(k == 0 && l == 0 && i1 == 0)
            k = 32;
        for(int j1 = 0; j1 < anInt419; j1++)
            aClass5Array421[j1].method186(i, j, k, l, i1);

    }

    public static int method311(int i, int j, int k)
    {
        return -1 - (i / 8) * 1024 - (j / 8) * 32 - k / 8;
    }

    public int method312(int i, int j, int k, int l, int i1)
    {
        if(l == j)
            return i;
        else
            return i + ((k - i) * (i1 - j)) / (l - j);
    }

    public boolean method313(int i, int j, int k, int l, boolean flag)
    {
        if(flag && i <= k || i < k)
        {
            if(i > l)
                return true;
            if(j > k)
                return true;
            if(j > l)
                return true;
            return !flag;
        }
        if(i < l)
            return true;
        if(j < k)
            return true;
        if(j < l)
            return true;
        else
            return flag;
    }

    public boolean method314(int i, int j, int k, boolean flag)
    {
        if(flag && i <= k || i < k)
        {
            if(j > k)
                return true;
            return !flag;
        }
        if(j < k)
            return true;
        else
            return flag;
    }

    public boolean method315(int ai[], int ai1[], int ai2[], int ai3[])
    {
        int k21 = Class6.anInt352;
        int i = ai.length;
        int j = ai2.length;
        byte byte0 = 0;
        int i20;
        int k20 = i20 = ai1[0];
        int k = 0;
        int j20;
        int l20 = j20 = ai3[0];
        int i1 = 0;
        for(int i21 = 1; i21 < i; i21++)
            if(ai1[i21] < i20)
            {
                i20 = ai1[i21];
                k = i21;
            } else
            if(ai1[i21] > k20)
                k20 = ai1[i21];

        for(int j21 = 1; j21 < j; j21++)
            if(ai3[j21] < j20)
            {
                j20 = ai3[j21];
                i1 = j21;
            } else
            if(ai3[j21] > l20)
                l20 = ai3[j21];

        if(j20 >= k20)
            return false;
        if(i20 >= l20)
            return false;
        int l;
        int j1;
        boolean flag;
        if(ai1[k] < ai3[i1])
        {
            for(l = k; ai1[l] < ai3[i1]; l = (l + 1) % i);
            for(; ai1[k] < ai3[i1]; k = ((k - 1) + i) % i);
            int k1 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
            int k6 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
            int l10 = ai2[i1];
            flag = (k1 < l10) | (k6 < l10);
            if(method314(k1, k6, l10, flag))
                return true;
            j1 = (i1 + 1) % j;
            i1 = ((i1 - 1) + j) % j;
            if(k == l)
                byte0 = 1;
        } else
        {
            for(j1 = i1; ai3[j1] < ai1[k]; j1 = (j1 + 1) % j);
            for(; ai3[i1] < ai1[k]; i1 = ((i1 - 1) + j) % j);
            int l1 = ai[k];
            int i11 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
            int l15 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
            flag = (l1 < i11) | (l1 < l15);
            if(method314(i11, l15, l1, !flag))
                return true;
            l = (k + 1) % i;
            k = ((k - 1) + i) % i;
            if(i1 == j1)
                byte0 = 2;
        }
        while(byte0 == 0) 
            if(ai1[k] < ai1[l])
            {
                if(ai1[k] < ai3[i1])
                {
                    if(ai1[k] < ai3[j1])
                    {
                        int i2 = ai[k];
                        int l6 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
                        int j11 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                        int i16 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                        if(method313(i2, l6, j11, i16, flag))
                            return true;
                        k = ((k - 1) + i) % i;
                        if(k == l)
                            byte0 = 1;
                    } else
                    {
                        int j2 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                        int i7 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                        int k11 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                        int j16 = ai2[j1];
                        if(method313(j2, i7, k11, j16, flag))
                            return true;
                        j1 = (j1 + 1) % j;
                        if(i1 == j1)
                            byte0 = 2;
                    }
                } else
                if(ai3[i1] < ai3[j1])
                {
                    int k2 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                    int j7 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                    int l11 = ai2[i1];
                    int k16 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                    if(method313(k2, j7, l11, k16, flag))
                        return true;
                    i1 = ((i1 - 1) + j) % j;
                    if(i1 == j1)
                        byte0 = 2;
                } else
                {
                    int l2 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                    int k7 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                    int i12 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                    int l16 = ai2[j1];
                    if(method313(l2, k7, i12, l16, flag))
                        return true;
                    j1 = (j1 + 1) % j;
                    if(i1 == j1)
                        byte0 = 2;
                }
            } else
            if(ai1[l] < ai3[i1])
            {
                if(ai1[l] < ai3[j1])
                {
                    int i3 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                    int l7 = ai[l];
                    int j12 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                    int i17 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                    if(method313(i3, l7, j12, i17, flag))
                        return true;
                    l = (l + 1) % i;
                    if(k == l)
                        byte0 = 1;
                } else
                {
                    int j3 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                    int i8 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                    int k12 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                    int j17 = ai2[j1];
                    if(method313(j3, i8, k12, j17, flag))
                        return true;
                    j1 = (j1 + 1) % j;
                    if(i1 == j1)
                        byte0 = 2;
                }
            } else
            if(ai3[i1] < ai3[j1])
            {
                int k3 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                int j8 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                int l12 = ai2[i1];
                int k17 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                if(method313(k3, j8, l12, k17, flag))
                    return true;
                i1 = ((i1 - 1) + j) % j;
                if(i1 == j1)
                    byte0 = 2;
            } else
            {
                int l3 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int k8 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int i13 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int l17 = ai2[j1];
                if(method313(l3, k8, i13, l17, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 2;
            }
        while(byte0 == 1) 
            if(ai1[k] < ai3[i1])
            {
                if(ai1[k] < ai3[j1])
                {
                    int i4 = ai[k];
                    int j13 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                    int i18 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                    return method314(j13, i18, i4, !flag);
                }
                int j4 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int l8 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int k13 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int j18 = ai2[j1];
                if(method313(j4, l8, k13, j18, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 0;
            } else
            if(ai3[i1] < ai3[j1])
            {
                int k4 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                int i9 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                int l13 = ai2[i1];
                int k18 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
                if(method313(k4, i9, l13, k18, flag))
                    return true;
                i1 = ((i1 - 1) + j) % j;
                if(i1 == j1)
                    byte0 = 0;
            } else
            {
                int l4 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
                int j9 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
                int i14 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
                int l18 = ai2[j1];
                if(method313(l4, j9, i14, l18, flag))
                    return true;
                j1 = (j1 + 1) % j;
                if(i1 == j1)
                    byte0 = 0;
            }
        while(byte0 == 2) 
            if(ai3[i1] < ai1[k])
            {
                if(ai3[i1] < ai1[l])
                {
                    int i5 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
                    int k9 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
                    int j14 = ai2[i1];
                    return method314(i5, k9, j14, flag);
                }
                int j5 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                int l9 = ai[l];
                int k14 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                int i19 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                if(method313(j5, l9, k14, i19, flag))
                    return true;
                l = (l + 1) % i;
                if(k == l)
                    byte0 = 0;
            } else
            if(ai1[k] < ai1[l])
            {
                int k5 = ai[k];
                int i10 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
                int l14 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
                int j19 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
                if(method313(k5, i10, l14, j19, flag))
                    return true;
                k = ((k - 1) + i) % i;
                if(k == l)
                    byte0 = 0;
            } else
            {
                int l5 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
                int j10 = ai[l];
                int i15 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
                int k19 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
                if(method313(l5, j10, i15, k19, flag))
                    return true;
                l = (l + 1) % i;
                if(k == l)
                    byte0 = 0;
            }
        if(ai1[k] < ai3[i1])
        {
            int i6 = ai[k];
            int j15 = method312(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
            int l19 = method312(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
            return method314(j15, l19, i6, !flag);
        }
        int j6 = method312(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
        int k10 = method312(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
        int k15 = ai2[i1];
        return method314(j6, k10, k15, flag);
    }

    public boolean aBoolean396;
    public boolean aBoolean399;
    boolean aBoolean457;
    boolean aBooleanArray440[];
    public static byte aByteArray444[];
    byte aByteArrayArray435[][];
    public Class5 aClass5Array404[];
    public Class5 aClass5Array421[];
    public Class5 aClass5_433;
    Class6 aClass6_446;
    public Class7 aClass7Array424[];
    Class9 aClass9Array448[];
    public double aDouble397;
    public static long aLong441;
    long aLongArray438[];
    int anInt384;
    public int anInt388;
    public int anInt389;
    public int anInt390;
    public int anInt391;
    public int anInt392;
    public int anInt393;
    public int anInt398;
    public int anInt400;
    public int anInt401;
    public int anInt402;
    public int anInt403;
    public int anInt406;
    public int anInt407;
    public int anInt408;
    public int anInt409;
    public int anInt410;
    public int anInt411;
    public int anInt412;
    public int anInt413;
    public int anInt414;
    public int anInt415;
    public int anInt416;
    public int anInt417;
    public int anInt418;
    public int anInt419;
    public int anInt420;
    public int anInt423;
    public int anInt425;
    int anInt434;
    int anInt449;
    int anInt450;
    static int anInt458;
    static int anInt459;
    static int anInt460;
    static int anInt461;
    static int anInt462;
    static int anInt463;
    int anInt464;
    int anInt465;
    int anIntArray385[];
    int anIntArray387[];
    public static int anIntArray394[] = new int[2048];
    public static int anIntArray395[] = new int[512];
    public int anIntArray405[];
    public int anIntArray422[];
    public int anIntArray426[];
    public int anIntArray427[];
    public int anIntArray428[];
    public int anIntArray429[];
    public int anIntArray430[];
    public int anIntArray431[];
    public int anIntArray432[];
    int anIntArray437[];
    public static int anIntArray445[] = new int[256];
    public int anIntArray447[];
    int anIntArray451[];
    int anIntArray452[];
    int anIntArray453[];
    int anIntArray454[];
    int anIntArray455[];
    int anIntArray456[];
    int anIntArrayArray386[][];
    int anIntArrayArray436[][];
    int anIntArrayArray439[][];
    int anIntArrayArray442[][];
    int anIntArrayArray443[][];

}
