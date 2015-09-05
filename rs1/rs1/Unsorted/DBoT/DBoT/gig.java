// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;

public class gig
{

    public void gkl(int i, int j, int k, boolean flag)
    {
        boolean flag2 = false;
        int l = (i + 24) / 48;
        int i1 = (j + 24) / 48;
        gmj(l - 1, i1 - 1, k, 0);
        gmj(l, i1 - 1, k, 1);
        gmj(l - 1, i1, k, 2);
        gmj(l, i1, k, 3);
        glk();
        if(gke == null)
            gke = new cgc(18688, 18688, true, true, false, false, true);
        if(flag)
        {
            gkh.cbd();
            for(int j1 = 0; j1 < 96; j1++)
            {
                for(int l1 = 0; l1 < 96; l1++)
                    gka[j1][l1] = 0;

            }

            cgc cgc1 = gke;
            cgc1.cmg();
            for(int j2 = 0; j2 < 96; j2++)
            {
                for(int i3 = 0; i3 < 96; i3++)
                {
                    int i4 = -glh(j2, i3);
                    if(gkm(j2, i3, k) > 0 && identify.alc[gkm(j2, i3, k) - 1] == 4)
                        i4 = 0;
                    if(gkm(j2 - 1, i3, k) > 0 && identify.alc[gkm(j2 - 1, i3, k) - 1] == 4)
                        i4 = 0;
                    if(gkm(j2, i3 - 1, k) > 0 && identify.alc[gkm(j2, i3 - 1, k) - 1] == 4)
                        i4 = 0;
                    if(gkm(j2 - 1, i3 - 1, k) > 0 && identify.alc[gkm(j2 - 1, i3 - 1, k) - 1] == 4)
                        i4 = 0;
                    int j5 = cgc1.cmj(j2 * 128, i4, i3 * 128);
                    int j7 = (int)(Math.random() * 10D) - 5;
                    cgc1.cnd(j5, j7);
                }

            }

            for(int j3 = 0; j3 < 95; j3++)
            {
                for(int j4 = 0; j4 < 95; j4++)
                {
                    int k5 = gmg(j3, j4);
                    int k7 = gil[k5];
                    int i10 = k7;
                    int k12 = k7;
                    int l14 = 0;
                    if(k == 1 || k == 2)
                    {
                        k7 = 0xbc614e;
                        i10 = 0xbc614e;
                        k12 = 0xbc614e;
                    }
                    if(gkm(j3, j4, k) > 0)
                    {
                        int l16 = gkm(j3, j4, k);
                        int l5 = identify.alc[l16 - 1];
                        int i19 = glj(j3, j4, k);
                        k7 = i10 = identify.alb[l16 - 1];
                        if(l5 == 4)
                        {
                            k7 = 1;
                            i10 = 1;
                            if(l16 == 12)
                            {
                                k7 = 31;
                                i10 = 31;
                            }
                        }
                        if(l5 == 5)
                        {
                            if(gna(j3, j4) > 0 && gna(j3, j4) < 24000)
                                if(gme(j3 - 1, j4, k, k12) != 0xbc614e && gme(j3, j4 - 1, k, k12) != 0xbc614e)
                                {
                                    k7 = gme(j3 - 1, j4, k, k12);
                                    l14 = 0;
                                } else
                                if(gme(j3 + 1, j4, k, k12) != 0xbc614e && gme(j3, j4 + 1, k, k12) != 0xbc614e)
                                {
                                    i10 = gme(j3 + 1, j4, k, k12);
                                    l14 = 0;
                                } else
                                if(gme(j3 + 1, j4, k, k12) != 0xbc614e && gme(j3, j4 - 1, k, k12) != 0xbc614e)
                                {
                                    i10 = gme(j3 + 1, j4, k, k12);
                                    l14 = 1;
                                } else
                                if(gme(j3 - 1, j4, k, k12) != 0xbc614e && gme(j3, j4 + 1, k, k12) != 0xbc614e)
                                {
                                    k7 = gme(j3 - 1, j4, k, k12);
                                    l14 = 1;
                                }
                        } else
                        if(l5 != 2 || gna(j3, j4) > 0 && gna(j3, j4) < 24000)
                            if(glj(j3 - 1, j4, k) != i19 && glj(j3, j4 - 1, k) != i19)
                            {
                                k7 = k12;
                                l14 = 0;
                            } else
                            if(glj(j3 + 1, j4, k) != i19 && glj(j3, j4 + 1, k) != i19)
                            {
                                i10 = k12;
                                l14 = 0;
                            } else
                            if(glj(j3 + 1, j4, k) != i19 && glj(j3, j4 - 1, k) != i19)
                            {
                                i10 = k12;
                                l14 = 1;
                            } else
                            if(glj(j3 - 1, j4, k) != i19 && glj(j3, j4 + 1, k) != i19)
                            {
                                k7 = k12;
                                l14 = 1;
                            }
                        if(identify.ald[l16 - 1] != 0)
                            gka[j3][j4] |= 0x40;
                        if(identify.alc[l16 - 1] == 2)
                            gka[j3][j4] |= 0x80;
                    }
                    gmk(j3, j4, l14, k7, i10);
                    int i17 = ((glh(j3 + 1, j4 + 1) - glh(j3 + 1, j4)) + glh(j3, j4 + 1)) - glh(j3, j4);
                    if(k7 != i10 || i17 != 0)
                    {
                        int ai[] = new int[3];
                        int ai7[] = new int[3];
                        if(l14 == 0)
                        {
                            if(k7 != 0xbc614e)
                            {
                                ai[0] = j4 + j3 * 96 + 96;
                                ai[1] = j4 + j3 * 96;
                                ai[2] = j4 + j3 * 96 + 1;
                                int l21 = cgc1.cml(3, ai, 0xbc614e, k7);
                                x[l21] = j3;
                                y[l21] = j4;
                                cgc1.cih[l21] = 0x30d40 + l21;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 1;
                                ai7[1] = j4 + j3 * 96 + 96 + 1;
                                ai7[2] = j4 + j3 * 96 + 96;
                                int i22 = cgc1.cml(3, ai7, 0xbc614e, i10);
                                x[i22] = j3;
                                y[i22] = j4;
                                cgc1.cih[i22] = 0x30d40 + i22;
                            }
                        } else
                        {
                            if(k7 != 0xbc614e)
                            {
                                ai[0] = j4 + j3 * 96 + 1;
                                ai[1] = j4 + j3 * 96 + 96 + 1;
                                ai[2] = j4 + j3 * 96;
                                int j22 = cgc1.cml(3, ai, 0xbc614e, k7);
                                x[j22] = j3;
                                y[j22] = j4;
                                cgc1.cih[j22] = 0x30d40 + j22;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 96;
                                ai7[1] = j4 + j3 * 96;
                                ai7[2] = j4 + j3 * 96 + 96 + 1;
                                int k22 = cgc1.cml(3, ai7, 0xbc614e, i10);
                                x[k22] = j3;
                                y[k22] = j4;
                                cgc1.cih[k22] = 0x30d40 + k22;
                            }
                        }
                    } else
                    if(k7 != 0xbc614e)
                    {
                        int ai1[] = new int[4];
                        ai1[0] = j4 + j3 * 96 + 96;
                        ai1[1] = j4 + j3 * 96;
                        ai1[2] = j4 + j3 * 96 + 1;
                        ai1[3] = j4 + j3 * 96 + 96 + 1;
                        int l19 = cgc1.cml(4, ai1, 0xbc614e, k7);
                        x[l19] = j3;
                        y[l19] = j4;
                        cgc1.cih[l19] = 0x30d40 + l19;
                    }
                }

            }

            for(int k4 = 1; k4 < 95; k4++)
            {
                for(int i6 = 1; i6 < 95; i6++)
                    if(gkm(k4, i6, k) > 0 && identify.alc[gkm(k4, i6, k) - 1] == 4)
                    {
                        int l7 = identify.alb[gkm(k4, i6, k) - 1];
                        int j10 = cgc1.cmj(k4 * 128, -glh(k4, i6), i6 * 128);
                        int l12 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6), i6 * 128);
                        int i15 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6 + 1), (i6 + 1) * 128);
                        int j17 = cgc1.cmj(k4 * 128, -glh(k4, i6 + 1), (i6 + 1) * 128);
                        int ai2[] = {
                            j10, l12, i15, j17
                        };
                        int i20 = cgc1.cml(4, ai2, l7, 0xbc614e);
                        x[i20] = k4;
                        y[i20] = i6;
                        cgc1.cih[i20] = 0x30d40 + i20;
                        gmk(k4, i6, 0, l7, l7);
                    } else
                    if(gkm(k4, i6, k) == 0 || identify.alc[gkm(k4, i6, k) - 1] != 3)
                    {
                        if(gkm(k4, i6 + 1, k) > 0 && identify.alc[gkm(k4, i6 + 1, k) - 1] == 4)
                        {
                            int i8 = identify.alb[gkm(k4, i6 + 1, k) - 1];
                            int k10 = cgc1.cmj(k4 * 128, -glh(k4, i6), i6 * 128);
                            int i13 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6), i6 * 128);
                            int j15 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int k17 = cgc1.cmj(k4 * 128, -glh(k4, i6 + 1), (i6 + 1) * 128);
                            int ai3[] = {
                                k10, i13, j15, k17
                            };
                            int j20 = cgc1.cml(4, ai3, i8, 0xbc614e);
                            x[j20] = k4;
                            y[j20] = i6;
                            cgc1.cih[j20] = 0x30d40 + j20;
                            gmk(k4, i6, 0, i8, i8);
                        }
                        if(gkm(k4, i6 - 1, k) > 0 && identify.alc[gkm(k4, i6 - 1, k) - 1] == 4)
                        {
                            int j8 = identify.alb[gkm(k4, i6 - 1, k) - 1];
                            int l10 = cgc1.cmj(k4 * 128, -glh(k4, i6), i6 * 128);
                            int j13 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6), i6 * 128);
                            int k15 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int l17 = cgc1.cmj(k4 * 128, -glh(k4, i6 + 1), (i6 + 1) * 128);
                            int ai4[] = {
                                l10, j13, k15, l17
                            };
                            int k20 = cgc1.cml(4, ai4, j8, 0xbc614e);
                            x[k20] = k4;
                            y[k20] = i6;
                            cgc1.cih[k20] = 0x30d40 + k20;
                            gmk(k4, i6, 0, j8, j8);
                        }
                        if(gkm(k4 + 1, i6, k) > 0 && identify.alc[gkm(k4 + 1, i6, k) - 1] == 4)
                        {
                            int k8 = identify.alb[gkm(k4 + 1, i6, k) - 1];
                            int i11 = cgc1.cmj(k4 * 128, -glh(k4, i6), i6 * 128);
                            int k13 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6), i6 * 128);
                            int l15 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int i18 = cgc1.cmj(k4 * 128, -glh(k4, i6 + 1), (i6 + 1) * 128);
                            int ai5[] = {
                                i11, k13, l15, i18
                            };
                            int l20 = cgc1.cml(4, ai5, k8, 0xbc614e);
                            x[l20] = k4;
                            y[l20] = i6;
                            cgc1.cih[l20] = 0x30d40 + l20;
                            gmk(k4, i6, 0, k8, k8);
                        }
                        if(gkm(k4 - 1, i6, k) > 0 && identify.alc[gkm(k4 - 1, i6, k) - 1] == 4)
                        {
                            int l8 = identify.alb[gkm(k4 - 1, i6, k) - 1];
                            int j11 = cgc1.cmj(k4 * 128, -glh(k4, i6), i6 * 128);
                            int l13 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6), i6 * 128);
                            int i16 = cgc1.cmj((k4 + 1) * 128, -glh(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int j18 = cgc1.cmj(k4 * 128, -glh(k4, i6 + 1), (i6 + 1) * 128);
                            int ai6[] = {
                                j11, l13, i16, j18
                            };
                            int i21 = cgc1.cml(4, ai6, l8, 0xbc614e);
                            x[i21] = k4;
                            y[i21] = i6;
                            cgc1.cih[i21] = 0x30d40 + i21;
                            gmk(k4, i6, 0, l8, l8);
                        }
                    }

            }

            cgc1.cna(true, 40, 48, -50, -10, -50);
            gja = gke.cmm(0, 0, 1536, 1536, 8, 64, 233, false);
            for(int j6 = 0; j6 < 64; j6++)
                gki.bhd(gja[j6]);

            for(int i9 = 0; i9 < 96; i9++)
            {
                for(int k11 = 0; k11 < 96; k11++)
                    gkc[i9][k11] = glh(i9, k11);

            }

        }
        gke.cmg();
        int k1 = 0x606060;
        for(int i2 = 0; i2 < 95; i2++)
        {
            for(int k2 = 0; k2 < 95; k2++)
            {
                int k3 = gla(i2, k2);
                if(k3 > 0 && identify.akg[k3 - 1] == 0)
                {
                    gmf(gke, k3 - 1, i2, k2, i2 + 1, k2);
                    if(flag && identify.akf[k3 - 1] != 0)
                    {
                        gka[i2][k2] |= 1;
                        if(k2 > 0)
                            gmn(i2, k2 - 1, 4);
                    }
                    if(flag)
                        gkh.cbj(i2 * 3, k2 * 3, 3, 0x606060);
                }
                k3 = gkn(i2, k2);
                if(k3 > 0 && identify.akg[k3 - 1] == 0)
                {
                    gmf(gke, k3 - 1, i2, k2, i2, k2 + 1);
                    if(flag && identify.akf[k3 - 1] != 0)
                    {
                        gka[i2][k2] |= 2;
                        if(i2 > 0)
                            gmn(i2 - 1, k2, 8);
                    }
                    if(flag)
                        gkh.cbk(i2 * 3, k2 * 3, 3, 0x606060);
                }
                k3 = gna(i2, k2);
                if(k3 > 0 && k3 < 12000 && identify.akg[k3 - 1] == 0)
                {
                    gmf(gke, k3 - 1, i2, k2, i2 + 1, k2 + 1);
                    if(flag && identify.akf[k3 - 1] != 0)
                        gka[i2][k2] |= 0x20;
                    if(flag)
                    {
                        gkh.cbl(i2 * 3, k2 * 3, 0x606060);
                        gkh.cbl(i2 * 3 + 1, k2 * 3 + 1, 0x606060);
                        gkh.cbl(i2 * 3 + 2, k2 * 3 + 2, 0x606060);
                    }
                }
                if(k3 > 12000 && k3 < 24000 && identify.akg[k3 - 12001] == 0)
                {
                    gmf(gke, k3 - 12001, i2 + 1, k2, i2, k2 + 1);
                    if(flag && identify.akf[k3 - 12001] != 0)
                        gka[i2][k2] |= 0x10;
                    if(flag)
                    {
                        gkh.cbl(i2 * 3 + 2, k2 * 3, 0x606060);
                        gkh.cbl(i2 * 3 + 1, k2 * 3 + 1, 0x606060);
                        gkh.cbl(i2 * 3, k2 * 3 + 2, 0x606060);
                    }
                }
            }

        }

        if(flag)
            gkh.ccg(gij - 1, 0, 0, 285, 285);
        gke.cna(false, 60, 24, -50, -10, -50);
        gjb[k] = gke.cmm(0, 0, 1536, 1536, 8, 64, 338, true);
        for(int l2 = 0; l2 < 64; l2++)
            gki.bhd(gjb[k][l2]);

        for(int l3 = 0; l3 < 95; l3++)
        {
            for(int l4 = 0; l4 < 95; l4++)
            {
                int k6 = gla(l3, l4);
                if(k6 > 0)
                    gmi(k6 - 1, l3, l4, l3 + 1, l4);
                k6 = gkn(l3, l4);
                if(k6 > 0)
                    gmi(k6 - 1, l3, l4, l3, l4 + 1);
                k6 = gna(l3, l4);
                if(k6 > 0 && k6 < 12000)
                    gmi(k6 - 1, l3, l4, l3 + 1, l4 + 1);
                if(k6 > 12000 && k6 < 24000)
                    gmi(k6 - 12001, l3 + 1, l4, l3, l4 + 1);
            }

        }

        for(int i5 = 1; i5 < 95; i5++)
        {
            for(int l6 = 1; l6 < 95; l6++)
            {
                int j9 = gmb(i5, l6);
                if(j9 > 0)
                {
                    int l11 = i5;
                    int i14 = l6;
                    int j16 = i5 + 1;
                    int k18 = l6;
                    int j19 = i5 + 1;
                    int j21 = l6 + 1;
                    int l22 = i5;
                    int j23 = l6 + 1;
                    int l23 = 0;
                    int j24 = gkc[l11][i14];
                    int l24 = gkc[j16][k18];
                    int j25 = gkc[j19][j21];
                    int l25 = gkc[l22][j23];
                    if(j24 > 0x13880)
                        j24 -= 0x13880;
                    if(l24 > 0x13880)
                        l24 -= 0x13880;
                    if(j25 > 0x13880)
                        j25 -= 0x13880;
                    if(l25 > 0x13880)
                        l25 -= 0x13880;
                    if(j24 > 0)
                        l23 = j24;
                    if(l24 > l23)
                        l23 = l24;
                    if(j25 > l23)
                        l23 = j25;
                    if(l25 > l23)
                        l23 = l25;
                    if(l23 >= 0x13880)
                        l23 -= 0x13880;
                    if(j24 < 0x13880)
                        gkc[l11][i14] = l23;
                    else
                        gkc[l11][i14] -= 0x13880;
                    if(l24 < 0x13880)
                        gkc[j16][k18] = l23;
                    else
                        gkc[j16][k18] -= 0x13880;
                    if(j25 < 0x13880)
                        gkc[j19][j21] = l23;
                    else
                        gkc[j19][j21] -= 0x13880;
                    if(l25 < 0x13880)
                        gkc[l22][j23] = l23;
                    else
                        gkc[l22][j23] -= 0x13880;
                }
            }

        }

        gke.cmg();
        for(int i7 = 1; i7 < 95; i7++)
        {
            for(int k9 = 1; k9 < 95; k9++)
            {
                int i12 = gmb(i7, k9);
                if(i12 > 0)
                {
                    int j14 = i7;
                    int k16 = k9;
                    int l18 = i7 + 1;
                    int k19 = k9;
                    int k21 = i7 + 1;
                    int i23 = k9 + 1;
                    int k23 = i7;
                    int i24 = k9 + 1;
                    int k24 = i7 * 128;
                    int i25 = k9 * 128;
                    int k25 = k24 + 128;
                    int i26 = i25 + 128;
                    int j26 = k24;
                    int k26 = i25;
                    int l26 = k25;
                    int i27 = i26;
                    int j27 = gkc[j14][k16];
                    int k27 = gkc[l18][k19];
                    int l27 = gkc[k21][i23];
                    int i28 = gkc[k23][i24];
                    int j28 = identify.alg[i12 - 1];
                    if(gmd(j14, k16) && j27 < 0x13880)
                    {
                        j27 += j28 + 0x13880;
                        gkc[j14][k16] = j27;
                    }
                    if(gmd(l18, k19) && k27 < 0x13880)
                    {
                        k27 += j28 + 0x13880;
                        gkc[l18][k19] = k27;
                    }
                    if(gmd(k21, i23) && l27 < 0x13880)
                    {
                        l27 += j28 + 0x13880;
                        gkc[k21][i23] = l27;
                    }
                    if(gmd(k23, i24) && i28 < 0x13880)
                    {
                        i28 += j28 + 0x13880;
                        gkc[k23][i24] = i28;
                    }
                    if(j27 >= 0x13880)
                        j27 -= 0x13880;
                    if(k27 >= 0x13880)
                        k27 -= 0x13880;
                    if(l27 >= 0x13880)
                        l27 -= 0x13880;
                    if(i28 >= 0x13880)
                        i28 -= 0x13880;
                    byte byte0 = 16;
                    if(!gll(j14 - 1, k16))
                        k24 -= 16;
                    if(!gll(j14 + 1, k16))
                        k24 += 16;
                    if(!gll(j14, k16 - 1))
                        i25 -= 16;
                    if(!gll(j14, k16 + 1))
                        i25 += 16;
                    if(!gll(l18 - 1, k19))
                        k25 -= 16;
                    if(!gll(l18 + 1, k19))
                        k25 += 16;
                    if(!gll(l18, k19 - 1))
                        k26 -= 16;
                    if(!gll(l18, k19 + 1))
                        k26 += 16;
                    if(!gll(k21 - 1, i23))
                        l26 -= 16;
                    if(!gll(k21 + 1, i23))
                        l26 += 16;
                    if(!gll(k21, i23 - 1))
                        i26 -= 16;
                    if(!gll(k21, i23 + 1))
                        i26 += 16;
                    if(!gll(k23 - 1, i24))
                        j26 -= 16;
                    if(!gll(k23 + 1, i24))
                        j26 += 16;
                    if(!gll(k23, i24 - 1))
                        i27 -= 16;
                    if(!gll(k23, i24 + 1))
                        i27 += 16;
                    i12 = identify.alh[i12 - 1];
                    j27 = -j27;
                    k27 = -k27;
                    l27 = -l27;
                    i28 = -i28;
                    if(gna(i7, k9) > 12000 && gna(i7, k9) < 24000 && gmb(i7 - 1, k9 - 1) == 0)
                    {
                        int ai8[] = new int[3];
                        ai8[0] = gke.cmj(l26, l27, i26);
                        ai8[1] = gke.cmj(j26, i28, i27);
                        ai8[2] = gke.cmj(k25, k27, k26);
                        gke.cml(3, ai8, i12, 0xbc614e);
                    } else
                    if(gna(i7, k9) > 12000 && gna(i7, k9) < 24000 && gmb(i7 + 1, k9 + 1) == 0)
                    {
                        int ai9[] = new int[3];
                        ai9[0] = gke.cmj(k24, j27, i25);
                        ai9[1] = gke.cmj(k25, k27, k26);
                        ai9[2] = gke.cmj(j26, i28, i27);
                        gke.cml(3, ai9, i12, 0xbc614e);
                    } else
                    if(gna(i7, k9) > 0 && gna(i7, k9) < 12000 && gmb(i7 + 1, k9 - 1) == 0)
                    {
                        int ai10[] = new int[3];
                        ai10[0] = gke.cmj(j26, i28, i27);
                        ai10[1] = gke.cmj(k24, j27, i25);
                        ai10[2] = gke.cmj(l26, l27, i26);
                        gke.cml(3, ai10, i12, 0xbc614e);
                    } else
                    if(gna(i7, k9) > 0 && gna(i7, k9) < 12000 && gmb(i7 - 1, k9 + 1) == 0)
                    {
                        int ai11[] = new int[3];
                        ai11[0] = gke.cmj(k25, k27, k26);
                        ai11[1] = gke.cmj(l26, l27, i26);
                        ai11[2] = gke.cmj(k24, j27, i25);
                        gke.cml(3, ai11, i12, 0xbc614e);
                    } else
                    if(j27 == k27 && l27 == i28)
                    {
                        int ai12[] = new int[4];
                        ai12[0] = gke.cmj(k24, j27, i25);
                        ai12[1] = gke.cmj(k25, k27, k26);
                        ai12[2] = gke.cmj(l26, l27, i26);
                        ai12[3] = gke.cmj(j26, i28, i27);
                        gke.cml(4, ai12, i12, 0xbc614e);
                    } else
                    if(j27 == i28 && k27 == l27)
                    {
                        int ai13[] = new int[4];
                        ai13[0] = gke.cmj(j26, i28, i27);
                        ai13[1] = gke.cmj(k24, j27, i25);
                        ai13[2] = gke.cmj(k25, k27, k26);
                        ai13[3] = gke.cmj(l26, l27, i26);
                        gke.cml(4, ai13, i12, 0xbc614e);
                    } else
                    {
                        boolean flag1 = true;
                        if(gmb(i7 - 1, k9 - 1) > 0)
                            flag1 = false;
                        if(gmb(i7 + 1, k9 + 1) > 0)
                            flag1 = false;
                        if(!flag1)
                        {
                            int ai14[] = new int[3];
                            ai14[0] = gke.cmj(k25, k27, k26);
                            ai14[1] = gke.cmj(l26, l27, i26);
                            ai14[2] = gke.cmj(k24, j27, i25);
                            gke.cml(3, ai14, i12, 0xbc614e);
                            int ai16[] = new int[3];
                            ai16[0] = gke.cmj(j26, i28, i27);
                            ai16[1] = gke.cmj(k24, j27, i25);
                            ai16[2] = gke.cmj(l26, l27, i26);
                            gke.cml(3, ai16, i12, 0xbc614e);
                        } else
                        {
                            int ai15[] = new int[3];
                            ai15[0] = gke.cmj(k24, j27, i25);
                            ai15[1] = gke.cmj(k25, k27, k26);
                            ai15[2] = gke.cmj(j26, i28, i27);
                            gke.cml(3, ai15, i12, 0xbc614e);
                            int ai17[] = new int[3];
                            ai17[0] = gke.cmj(l26, l27, i26);
                            ai17[1] = gke.cmj(j26, i28, i27);
                            ai17[2] = gke.cmj(k25, k27, k26);
                            gke.cml(3, ai17, i12, 0xbc614e);
                        }
                    }
                }
            }

        }

        gke.cna(true, 50, 50, -50, -10, -50);
        gkd[k] = gke.cmm(0, 0, 1536, 1536, 8, 64, 169, true);
        for(int l9 = 0; l9 < 64; l9++)
            gki.bhd(gkd[k][l9]);

        if(gkd[k][0] == null)
            throw new RuntimeException("null roof!");
        for(int j12 = 0; j12 < 96; j12++)
        {
            for(int k14 = 0; k14 < 96; k14++)
                if(gkc[j12][k14] >= 0x13880)
                    gkc[j12][k14] -= 0x13880;

        }

    }

    public int gkm(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gkf[byte0][i * 48 + j] & 0xff;
    }

    public int gkn(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gjm[byte0][i * 48 + j] & 0xff;
    }

    public int gla(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gkj[byte0][i * 48 + j] & 0xff;
    }

    public void glb(int i, int j, int k, int l, int i1)
    {
        cgc cgc1 = gja[i + j * 8];
        for(int j1 = 0; j1 < cgc1.cgd; j1++)
            if(cgc1.cjh[j1] == k * 128 && cgc1.cjj[j1] == l * 128)
            {
                cgc1.cnd(j1, i1);
                return;
            }

    }

    public void glc(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(identify.amk[k] == 1 || identify.amk[k] == 2)
        {
            int l = glg(i, j);
            int i1;
            int j1;
            if(l == 0 || l == 4)
            {
                i1 = identify.ami[k];
                j1 = identify.amj[k];
            } else
            {
                j1 = identify.ami[k];
                i1 = identify.amj[k];
            }
            for(int k1 = i; k1 < i + i1; k1++)
            {
                for(int l1 = j; l1 < j + j1; l1++)
                    if(identify.amk[k] == 1)
                        gka[k1][l1] |= 0x40;
                    else
                    if(l == 0)
                    {
                        gka[k1][l1] |= 2;
                        if(k1 > 0)
                            gmn(k1 - 1, l1, 8);
                    } else
                    if(l == 2)
                    {
                        gka[k1][l1] |= 4;
                        if(l1 < 95)
                            gmn(k1, l1 + 1, 1);
                    } else
                    if(l == 4)
                    {
                        gka[k1][l1] |= 8;
                        if(k1 < 95)
                            gmn(k1 + 1, l1, 2);
                    } else
                    if(l == 6)
                    {
                        gka[k1][l1] |= 1;
                        if(l1 > 0)
                            gmn(k1, l1 - 1, 4);
                    }

            }

            gma(i, j, i1, j1);
        }
    }

    public void gld(int i, int j, int k)
    {
        gka[i][j] &= 65535 - k;
    }

    public void gle(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(identify.akf[l] == 1)
        {
            if(k == 0)
            {
                gka[i][j] &= 0xfffe;
                if(j > 0)
                    gld(i, j - 1, 4);
            } else
            if(k == 1)
            {
                gka[i][j] &= 0xfffd;
                if(i > 0)
                    gld(i - 1, j, 8);
            } else
            if(k == 2)
                gka[i][j] &= 0xffef;
            else
            if(k == 3)
                gka[i][j] &= 0xffdf;
            gma(i, j, 1, 1);
        }
    }

    public void glf()
    {
        boolean flag = false;
        if(gim)
            gki.bhf();
        for(int i = 0; i < 64; i++)
        {
            gja[i] = null;
            for(int j = 0; j < 4; j++)
                gjb[j][i] = null;

            for(int k = 0; k < 4; k++)
                gkd[k][i] = null;

        }

        System.gc();
    }

    public int glg(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gjl[byte0][i * 48 + j];
    }

    public int glh(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return (gjc[byte0][i * 48 + j] & 0xff) * 3;
    }

    public void gli(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(identify.akf[l] == 1)
        {
            if(k == 0)
            {
                gka[i][j] |= 1;
                if(j > 0)
                    gmn(i, j - 1, 4);
            } else
            if(k == 1)
            {
                gka[i][j] |= 2;
                if(i > 0)
                    gmn(i - 1, j, 8);
            } else
            if(k == 2)
                gka[i][j] |= 0x10;
            else
            if(k == 3)
                gka[i][j] |= 0x20;
            gma(i, j, 1, 1);
        }
    }

    public gig(bbe bbe1, blm blm1)
    {
        super();
        boolean flag = false;
        gij = 750;
        gik = new int[4][2304];
        gil = new int[256];
        gim = true;
        gin = false;
        gja = new cgc[64];
        gjb = new cgc[4][64];
        gjc = new byte[4][2304];
        y = new int[18432];
        gjk = new byte[4][2304];
        gjl = new byte[4][2304];
        gjm = new byte[4][2304];
        x = new int[18432];
        gka = new int[96][96];
        gkb = new byte[4][2304];
        gkc = new int[96][96];
        gkd = new cgc[4][64];
        gkf = new byte[4][2304];
        gkg = false;
        gkj = new byte[4][2304];
        gkk = new int[96][96];
        gki = bbe1;
        gkh = blm1;
        for(int i = 0; i < 64; i++)
            gil[i] = bbe.bkd(255 - i * 4, 255 - (int)((double)i * 1.75D), 255 - i * 4);

        for(int j = 0; j < 64; j++)
            gil[j + 64] = bbe.bkd(j * 3, 144, 0);

        for(int k = 0; k < 64; k++)
            gil[k + 128] = bbe.bkd(192 - (int)((double)k * 1.5D), 144 - (int)((double)k * 1.5D), 0);

        for(int l = 0; l < 64; l++)
            gil[l + 192] = bbe.bkd(96 - (int)((double)l * 1.5D), 48 + (int)((double)l * 1.5D), 0);

    }

    public int glj(int i, int j, int k)
    {
        int l = gkm(i, j, k);
        if(l == 0)
            return -1;
        int i1 = identify.alc[l - 1];
        return i1 != 2 ? 0 : 1;
    }

    public void glk()
    {
        boolean flag = false;
        for(int i = 0; i < 96; i++)
        {
            for(int j = 0; j < 96; j++)
                if(gkm(i, j, 0) == 250)
                    if(i == 47 && gkm(i + 1, j, 0) != 250 && gkm(i + 1, j, 0) != 2)
                        glm(i, j, 9);
                    else
                    if(j == 47 && gkm(i, j + 1, 0) != 250 && gkm(i, j + 1, 0) != 2)
                        glm(i, j, 9);
                    else
                        glm(i, j, 2);

        }

    }

    public boolean gll(int i, int j)
    {
        return gmb(i, j) > 0 || gmb(i - 1, j) > 0 || gmb(i - 1, j - 1) > 0 || gmb(i, j - 1) > 0;
    }

    public void glm(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        gkf[byte0][i * 48 + j] = (byte)k;
    }

    public int gln(int i, int j, int k, int l, int i1, int j1, int ai[], 
            int ai1[], boolean flag)
    {
        boolean flag2 = false;
        for(int k1 = 0; k1 < 96; k1++)
        {
            for(int l1 = 0; l1 < 96; l1++)
                gkk[k1][l1] = 0;

        }

        int i2 = 0;
        int j2 = 0;
        int k2 = i;
        int l2 = j;
        gkk[i][j] = 99;
        ai[0] = i;
        i2++;
        ai1[0] = j;
        int i3 = ai.length;
        boolean flag1 = false;
        while(j2 != i2) 
        {
            k2 = ai[j2];
            l2 = ai1[j2];
            j2 = (j2 + 1) % i3;
            if(k2 >= k && k2 <= i1 && l2 >= l && l2 <= j1)
            {
                flag1 = true;
                break;
            }
            if(flag)
            {
                if(k2 > 0 && k2 - 1 >= k && k2 - 1 <= i1 && l2 >= l && l2 <= j1 && (gka[k2 - 1][l2] & 8) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(k2 < 95 && k2 + 1 >= k && k2 + 1 <= i1 && l2 >= l && l2 <= j1 && (gka[k2 + 1][l2] & 2) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(l2 > 0 && k2 >= k && k2 <= i1 && l2 - 1 >= l && l2 - 1 <= j1 && (gka[k2][l2 - 1] & 4) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(l2 < 95 && k2 >= k && k2 <= i1 && l2 + 1 >= l && l2 + 1 <= j1 && (gka[k2][l2 + 1] & 1) == 0)
                {
                    flag1 = true;
                    break;
                }
            }
            if(k2 > 0 && gkk[k2 - 1][l2] == 0 && (gka[k2 - 1][l2] & 0x78) == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2;
                i2 = (i2 + 1) % i3;
                gkk[k2 - 1][l2] = 2;
            }
            if(k2 < 95 && gkk[k2 + 1][l2] == 0 && (gka[k2 + 1][l2] & 0x72) == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2;
                i2 = (i2 + 1) % i3;
                gkk[k2 + 1][l2] = 8;
            }
            if(l2 > 0 && gkk[k2][l2 - 1] == 0 && (gka[k2][l2 - 1] & 0x74) == 0)
            {
                ai[i2] = k2;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkk[k2][l2 - 1] = 1;
            }
            if(l2 < 95 && gkk[k2][l2 + 1] == 0 && (gka[k2][l2 + 1] & 0x71) == 0)
            {
                ai[i2] = k2;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkk[k2][l2 + 1] = 4;
            }
            if(k2 > 0 && l2 > 0 && (gka[k2][l2 - 1] & 0x74) == 0 && (gka[k2 - 1][l2] & 0x78) == 0 && (gka[k2 - 1][l2 - 1] & 0x7c) == 0 && gkk[k2 - 1][l2 - 1] == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkk[k2 - 1][l2 - 1] = 3;
            }
            if(k2 < 95 && l2 > 0 && (gka[k2][l2 - 1] & 0x74) == 0 && (gka[k2 + 1][l2] & 0x72) == 0 && (gka[k2 + 1][l2 - 1] & 0x76) == 0 && gkk[k2 + 1][l2 - 1] == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkk[k2 + 1][l2 - 1] = 9;
            }
            if(k2 > 0 && l2 < 95 && (gka[k2][l2 + 1] & 0x71) == 0 && (gka[k2 - 1][l2] & 0x78) == 0 && (gka[k2 - 1][l2 + 1] & 0x79) == 0 && gkk[k2 - 1][l2 + 1] == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkk[k2 - 1][l2 + 1] = 6;
            }
            if(k2 < 95 && l2 < 95 && (gka[k2][l2 + 1] & 0x71) == 0 && (gka[k2 + 1][l2] & 0x72) == 0 && (gka[k2 + 1][l2 + 1] & 0x73) == 0 && gkk[k2 + 1][l2 + 1] == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkk[k2 + 1][l2 + 1] = 12;
            }
        }
        if(!flag1)
            return -1;
        j2 = 0;
        ai[0] = k2;
        j2++;
        ai1[0] = l2;
        int k3;
        for(int j3 = k3 = gkk[k2][l2]; k2 != i || l2 != j; j3 = gkk[k2][l2])
        {
            if(j3 != k3)
            {
                k3 = j3;
                ai[j2] = k2;
                ai1[j2++] = l2;
            }
            if((j3 & 2) != 0)
                k2++;
            else
            if((j3 & 8) != 0)
                k2--;
            if((j3 & 1) != 0)
                l2++;
            else
            if((j3 & 4) != 0)
                l2--;
        }

        return j2;
    }

    public void gma(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 1 || j < 1 || i + k >= 96 || j + l >= 96)
            return;
        for(int i1 = i; i1 <= i + k; i1++)
        {
            for(int j1 = j; j1 <= j + l; j1++)
                if((gml(i1, j1) & 0x63) != 0 || (gml(i1 - 1, j1) & 0x59) != 0 || (gml(i1, j1 - 1) & 0x56) != 0 || (gml(i1 - 1, j1 - 1) & 0x6c) != 0)
                    gnc(i1, j1, 35);
                else
                    gnc(i1, j1, 0);

        }

    }

    public int gmb(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gkb[byte0][i * 48 + j];
    }

    public void gmc(int i, int j, int k)
    {
        glf();
        int l = (i + 24) / 48;
        int i1 = (j + 24) / 48;
        gkl(i, j, k, true);
        if(k == 0)
        {
            gkl(i, j, 1, false);
            gkl(i, j, 2, false);
            gmj(l - 1, i1 - 1, k, 0);
            gmj(l, i1 - 1, k, 1);
            gmj(l - 1, i1, k, 2);
            gmj(l, i1, k, 3);
            glk();
        }
    }

    public boolean gmd(int i, int j)
    {
        return gmb(i, j) > 0 && gmb(i - 1, j) > 0 && gmb(i - 1, j - 1) > 0 && gmb(i, j - 1) > 0;
    }

    public int gme(int i, int j, int k, int l)
    {
        int i1 = gkm(i, j, k);
        if(i1 == 0)
            return l;
        else
            return identify.alb[i1 - 1];
    }

    public void gmf(cgc cgc1, int i, int j, int k, int l, int i1)
    {
        gnc(j, k, 40);
        gnc(l, i1, 40);
        int j1 = identify.akc[i];
        int k1 = identify.akd[i];
        int l1 = identify.ake[i];
        int i2 = j * 128;
        int j2 = k * 128;
        int k2 = l * 128;
        int l2 = i1 * 128;
        int i3 = cgc1.cmj(i2, -gkc[j][k], j2);
        int j3 = cgc1.cmj(i2, -gkc[j][k] - j1, j2);
        int k3 = cgc1.cmj(k2, -gkc[l][i1] - j1, l2);
        int l3 = cgc1.cmj(k2, -gkc[l][i1], l2);
        int ai[] = {
            i3, j3, k3, l3
        };
        int i4 = cgc1.cml(4, ai, k1, l1);
        if(identify.akg[i] == 5)
        {
            cgc1.cih[i4] = 30000 + i;
            return;
        } else
        {
            cgc1.cih[i4] = 0;
            return;
        }
    }

    public int gmg(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gjk[byte0][i * 48 + j] & 0xff;
    }

    public void gmh(cgc acgc[])
    {
        boolean flag = false;
        for(int i = 0; i < 94; i++)
        {
            for(int j = 0; j < 94; j++)
                if(gna(i, j) > 48000 && gna(i, j) < 60000)
                {
                    int k = gna(i, j) - 48001;
                    int l = glg(i, j);
                    int i1;
                    int j1;
                    if(l == 0 || l == 4)
                    {
                        i1 = identify.ami[k];
                        j1 = identify.amj[k];
                    } else
                    {
                        j1 = identify.ami[k];
                        i1 = identify.amj[k];
                    }
                    glc(i, j, k);
                    cgc cgc1 = acgc[identify.amh[k]].dag(false, true, false, false);
                    int k1 = ((i + i + i1) * 128) / 2;
                    int i2 = ((j + j + j1) * 128) / 2;
                    cgc1.cng(k1, -gnb(k1, i2), i2);
                    cgc1.cnf(0, glg(i, j) * 32, 0);
                    gki.bhd(cgc1);
                    cgc1.cnb(48, 48, -50, -10, -50);
                    if(i1 > 1 || j1 > 1)
                    {
                        for(int k2 = i; k2 < i + i1; k2++)
                        {
                            for(int l2 = j; l2 < j + j1; l2++)
                                if((k2 > i || l2 > j) && gna(k2, l2) - 48001 == k)
                                {
                                    int l1 = k2;
                                    int j2 = l2;
                                    byte byte0 = 0;
                                    if(l1 >= 48 && j2 < 48)
                                    {
                                        byte0 = 1;
                                        l1 -= 48;
                                    } else
                                    if(l1 < 48 && j2 >= 48)
                                    {
                                        byte0 = 2;
                                        j2 -= 48;
                                    } else
                                    if(l1 >= 48 && j2 >= 48)
                                    {
                                        byte0 = 3;
                                        l1 -= 48;
                                        j2 -= 48;
                                    }
                                    gik[byte0][l1 * 48 + j2] = 0;
                                }

                        }

                    }
                }

        }

    }

    public void gmi(int i, int j, int k, int l, int i1)
    {
        int j1 = identify.akc[i];
        if(gkc[j][k] < 0x13880)
            gkc[j][k] += 0x13880 + j1;
        if(gkc[l][i1] < 0x13880)
            gkc[l][i1] += 0x13880 + j1;
    }

    public void gmj(int i, int j, int k, int l)
    {
        boolean flag = false;
        String s = "m" + k + i / 10 + i % 10 + j / 10 + j % 10;
        int i1;
        try
        {
            if(gjd != null)
            {
                byte abyte0[] = fnf.gak(s + ".hei", 0, gjd);
                if(abyte0 == null && gji != null)
                    abyte0 = fnf.gak(s + ".hei", 0, gji);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int j1 = 0;
                    int k2 = 0;
                    for(int j3 = 0; j3 < 2304;)
                    {
                        int i4 = abyte0[j1++] & 0xff;
                        if(i4 < 128)
                        {
                            gjc[l][j3++] = (byte)i4;
                            k2 = i4;
                        }
                        if(i4 >= 128)
                        {
                            for(int i5 = 0; i5 < i4 - 128; i5++)
                                gjc[l][j3++] = (byte)k2;

                        }
                    }

                    k2 = 64;
                    for(int j4 = 0; j4 < 48; j4++)
                    {
                        for(int j5 = 0; j5 < 48; j5++)
                        {
                            k2 = gjc[l][j5 * 48 + j4] + k2 & 0x7f;
                            gjc[l][j5 * 48 + j4] = (byte)(k2 * 2);
                        }

                    }

                    k2 = 0;
                    for(int k5 = 0; k5 < 2304;)
                    {
                        int j6 = abyte0[j1++] & 0xff;
                        if(j6 < 128)
                        {
                            gjk[l][k5++] = (byte)j6;
                            k2 = j6;
                        }
                        if(j6 >= 128)
                        {
                            for(int k7 = 0; k7 < j6 - 128; k7++)
                                gjk[l][k5++] = (byte)k2;

                        }
                    }

                    k2 = 35;
                    for(int k6 = 0; k6 < 48; k6++)
                    {
                        for(int l7 = 0; l7 < 48; l7++)
                        {
                            k2 = gjk[l][l7 * 48 + k6] + k2 & 0x7f;
                            gjk[l][l7 * 48 + k6] = (byte)(k2 * 2);
                        }

                    }

                } else
                {
                    for(int k1 = 0; k1 < 2304; k1++)
                    {
                        gjc[l][k1] = 0;
                        gjk[l][k1] = 0;
                    }

                }
                abyte0 = fnf.gak(s + ".dat", 0, gje);
                if(abyte0 == null && gjj != null)
                    abyte0 = fnf.gak(s + ".dat", 0, gjj);
                if(abyte0 == null || abyte0.length == 0)
                    throw new IOException();
                int l1 = 0;
                for(int l2 = 0; l2 < 2304; l2++)
                    gjm[l][l2] = abyte0[l1++];

                for(int k3 = 0; k3 < 2304; k3++)
                    gkj[l][k3] = abyte0[l1++];

                for(int k4 = 0; k4 < 2304; k4++)
                    gik[l][k4] = abyte0[l1++] & 0xff;

                for(int l5 = 0; l5 < 2304; l5++)
                {
                    int l6 = abyte0[l1++] & 0xff;
                    if(l6 > 0)
                        gik[l][l5] = l6 + 12000;
                }

                for(int i7 = 0; i7 < 2304;)
                {
                    int i8 = abyte0[l1++] & 0xff;
                    if(i8 < 128)
                    {
                        gkb[l][i7++] = (byte)i8;
                    } else
                    {
                        for(int l8 = 0; l8 < i8 - 128; l8++)
                            gkb[l][i7++] = 0;

                    }
                }

                int j8 = 0;
                for(int i9 = 0; i9 < 2304;)
                {
                    int k9 = abyte0[l1++] & 0xff;
                    if(k9 < 128)
                    {
                        gkf[l][i9++] = (byte)k9;
                        j8 = k9;
                    } else
                    {
                        for(int j10 = 0; j10 < k9 - 128; j10++)
                            gkf[l][i9++] = (byte)j8;

                    }
                }

                for(int l9 = 0; l9 < 2304;)
                {
                    int k10 = abyte0[l1++] & 0xff;
                    if(k10 < 128)
                    {
                        gjl[l][l9++] = (byte)k10;
                    } else
                    {
                        for(int j11 = 0; j11 < k10 - 128; j11++)
                            gjl[l][l9++] = 0;

                    }
                }

                abyte0 = fnf.gak(s + ".loc", 0, gje);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int i2 = 0;
                    for(int l10 = 0; l10 < 2304;)
                    {
                        int k11 = abyte0[i2++] & 0xff;
                        if(k11 < 128)
                            gik[l][l10++] = k11 + 48000;
                        else
                            l10 += k11 - 128;
                    }

                    return;
                }
            } else
            {
                byte abyte1[] = new byte[20736];
                fnf.fnk("../gamedata/maps/" + s + ".jm", abyte1, 20736);
                int j2 = 0;
                int i3 = 0;
                for(int l3 = 0; l3 < 2304; l3++)
                {
                    j2 = j2 + abyte1[i3++] & 0xff;
                    gjc[l][l3] = (byte)j2;
                }

                j2 = 0;
                for(int l4 = 0; l4 < 2304; l4++)
                {
                    j2 = j2 + abyte1[i3++] & 0xff;
                    gjk[l][l4] = (byte)j2;
                }

                for(int i6 = 0; i6 < 2304; i6++)
                    gjm[l][i6] = abyte1[i3++];

                for(int j7 = 0; j7 < 2304; j7++)
                    gkj[l][j7] = abyte1[i3++];

                for(int k8 = 0; k8 < 2304; k8++)
                {
                    gik[l][k8] = (abyte1[i3] & 0xff) * 256 + (abyte1[i3 + 1] & 0xff);
                    i3 += 2;
                }

                for(int j9 = 0; j9 < 2304; j9++)
                    gkb[l][j9] = abyte1[i3++];

                for(int i10 = 0; i10 < 2304; i10++)
                    gkf[l][i10] = abyte1[i3++];

                for(int i11 = 0; i11 < 2304; i11++)
                    gjl[l][i11] = abyte1[i3++];

            }
            return;
        }
        catch(IOException _ex)
        {
            i1 = 0;
        }
        for(; i1 < 2304; i1++)
        {
            gjc[l][i1] = 0;
            gjk[l][i1] = 0;
            gjm[l][i1] = 0;
            gkj[l][i1] = 0;
            gik[l][i1] = 0;
            gkb[l][i1] = 0;
            gkf[l][i1] = 0;
            if(k == 0)
                gkf[l][i1] = -6;
            if(k == 3)
                gkf[l][i1] = 8;
            gjl[l][i1] = 0;
        }

    }

    public void gmk(int i, int j, int k, int l, int i1)
    {
        int j1 = i * 3;
        int k1 = j * 3;
        int l1 = gki.bka(l);
        int i2 = gki.bka(i1);
        l1 = l1 >> 1 & 0x7f7f7f;
        i2 = i2 >> 1 & 0x7f7f7f;
        if(k == 0)
        {
            gkh.cbj(j1, k1, 3, l1);
            gkh.cbj(j1, k1 + 1, 2, l1);
            gkh.cbj(j1, k1 + 2, 1, l1);
            gkh.cbj(j1 + 2, k1 + 1, 1, i2);
            gkh.cbj(j1 + 1, k1 + 2, 2, i2);
            return;
        }
        if(k == 1)
        {
            gkh.cbj(j1, k1, 3, i2);
            gkh.cbj(j1 + 1, k1 + 1, 2, i2);
            gkh.cbj(j1 + 2, k1 + 2, 1, i2);
            gkh.cbj(j1, k1 + 1, 1, l1);
            gkh.cbj(j1, k1 + 2, 2, l1);
        }
    }

    public int gml(int i, int j)
    {
        if(i < 0 || j < 0 || i >= 96 || j >= 96)
            return 0;
        else
            return gka[i][j];
    }

    public void gmm(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(identify.amk[k] == 1 || identify.amk[k] == 2)
        {
            int l = glg(i, j);
            int i1;
            int j1;
            if(l == 0 || l == 4)
            {
                i1 = identify.ami[k];
                j1 = identify.amj[k];
            } else
            {
                j1 = identify.ami[k];
                i1 = identify.amj[k];
            }
            for(int k1 = i; k1 < i + i1; k1++)
            {
                for(int l1 = j; l1 < j + j1; l1++)
                    if(identify.amk[k] == 1)
                        gka[k1][l1] &= 0xffbf;
                    else
                    if(l == 0)
                    {
                        gka[k1][l1] &= 0xfffd;
                        if(k1 > 0)
                            gld(k1 - 1, l1, 8);
                    } else
                    if(l == 2)
                    {
                        gka[k1][l1] &= 0xfffb;
                        if(l1 < 95)
                            gld(k1, l1 + 1, 1);
                    } else
                    if(l == 4)
                    {
                        gka[k1][l1] &= 0xfff7;
                        if(k1 < 95)
                            gld(k1 + 1, l1, 2);
                    } else
                    if(l == 6)
                    {
                        gka[k1][l1] &= 0xfffe;
                        if(l1 > 0)
                            gld(k1, l1 - 1, 4);
                    }

            }

            gma(i, j, i1, j1);
        }
    }

    public void gmn(int i, int j, int k)
    {
        gka[i][j] |= k;
    }

    public int gna(int i, int j)
    {
        boolean flag = false;
        if(i < 0 || i >= 96 || j < 0 || j >= 96)
            return 0;
        byte byte0 = 0;
        if(i >= 48 && j < 48)
        {
            byte0 = 1;
            i -= 48;
        } else
        if(i < 48 && j >= 48)
        {
            byte0 = 2;
            j -= 48;
        } else
        if(i >= 48 && j >= 48)
        {
            byte0 = 3;
            i -= 48;
            j -= 48;
        }
        return gik[byte0][i * 48 + j];
    }

    public int gnb(int i, int j)
    {
        int k = i >> 7;
        int l = j >> 7;
        int i1 = i & 0x7f;
        int j1 = j & 0x7f;
        if(k < 0 || l < 0 || k >= 95 || l >= 95)
            return 0;
        int k1;
        int l1;
        int i2;
        if(i1 <= 128 - j1)
        {
            k1 = glh(k, l);
            l1 = glh(k + 1, l) - k1;
            i2 = glh(k, l + 1) - k1;
        } else
        {
            k1 = glh(k + 1, l + 1);
            l1 = glh(k, l + 1) - k1;
            i2 = glh(k + 1, l) - k1;
            i1 = 128 - i1;
            j1 = 128 - j1;
        }
        int j2 = k1 + (l1 * i1) / 128 + (i2 * j1) / 128;
        return j2;
    }

    public void gnc(int i, int j, int k)
    {
        int l = i / 12;
        int i1 = j / 12;
        int j1 = (i - 1) / 12;
        int k1 = (j - 1) / 12;
        glb(l, i1, i, j, k);
        if(l != j1)
            glb(j1, i1, i, j, k);
        if(i1 != k1)
            glb(l, k1, i, j, k);
        if(l != j1 && i1 != k1)
            glb(j1, k1, i, j, k);
    }

    final int gih = 96;
    final int gii = 96;
    int gij;
    int gik[][];
    int gil[];
    boolean gim;
    boolean gin;
    cgc gja[];
    cgc gjb[][];
    byte gjc[][];
    byte gjd[];
    byte gje[];
    final int gjf = 0xbc614e;
    final int gjg = 128;
    int y[];
    byte gji[];
    byte gjj[];
    byte gjk[][];
    byte gjl[][];
    byte gjm[][];
    int x[];
    int gka[][];
    byte gkb[][];
    int gkc[][];
    cgc gkd[][];
    cgc gke;
    byte gkf[][];
    boolean gkg;
    blm gkh;
    bbe gki;
    byte gkj[][];
    int gkk[][];
}
