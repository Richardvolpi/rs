// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.IOException;

public class gig
{

    public void gkl(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(ahd.anf[l] == 1)
        {
            if(k == 0)
            {
                gkb[i][j] |= 1;
                if(j > 0)
                    gmk(i, j - 1, 4);
            } else
            if(k == 1)
            {
                gkb[i][j] |= 2;
                if(i > 0)
                    gmk(i - 1, j, 8);
            } else
            if(k == 2)
                gkb[i][j] |= 0x10;
            else
            if(k == 3)
                gkb[i][j] |= 0x20;
            gmn(i, j, 1, 1);
        }
    }

    public boolean gkm(int i, int j)
    {
        return gll(i, j) > 0 && gll(i - 1, j) > 0 && gll(i - 1, j - 1) > 0 && gll(i, j - 1) > 0;
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
        return gke[byte0][i * 48 + j] & 0xff;
    }

    public int gla(int i, int j, int k, int l, int i1, int j1, int ai[], 
            int ai1[], boolean flag)
    {
        boolean flag2 = false;
        for(int k1 = 0; k1 < 96; k1++)
        {
            for(int l1 = 0; l1 < 96; l1++)
                gkf[k1][l1] = 0;

        }

        int i2 = 0;
        int j2 = 0;
        int k2 = i;
        int l2 = j;
        gkf[i][j] = 99;
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
                if(k2 > 0 && k2 - 1 >= k && k2 - 1 <= i1 && l2 >= l && l2 <= j1 && (gkb[k2 - 1][l2] & 8) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(k2 < 95 && k2 + 1 >= k && k2 + 1 <= i1 && l2 >= l && l2 <= j1 && (gkb[k2 + 1][l2] & 2) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(l2 > 0 && k2 >= k && k2 <= i1 && l2 - 1 >= l && l2 - 1 <= j1 && (gkb[k2][l2 - 1] & 4) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(l2 < 95 && k2 >= k && k2 <= i1 && l2 + 1 >= l && l2 + 1 <= j1 && (gkb[k2][l2 + 1] & 1) == 0)
                {
                    flag1 = true;
                    break;
                }
            }
            if(k2 > 0 && gkf[k2 - 1][l2] == 0 && (gkb[k2 - 1][l2] & 0x78) == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2;
                i2 = (i2 + 1) % i3;
                gkf[k2 - 1][l2] = 2;
            }
            if(k2 < 95 && gkf[k2 + 1][l2] == 0 && (gkb[k2 + 1][l2] & 0x72) == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2;
                i2 = (i2 + 1) % i3;
                gkf[k2 + 1][l2] = 8;
            }
            if(l2 > 0 && gkf[k2][l2 - 1] == 0 && (gkb[k2][l2 - 1] & 0x74) == 0)
            {
                ai[i2] = k2;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkf[k2][l2 - 1] = 1;
            }
            if(l2 < 95 && gkf[k2][l2 + 1] == 0 && (gkb[k2][l2 + 1] & 0x71) == 0)
            {
                ai[i2] = k2;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkf[k2][l2 + 1] = 4;
            }
            if(k2 > 0 && l2 > 0 && (gkb[k2][l2 - 1] & 0x74) == 0 && (gkb[k2 - 1][l2] & 0x78) == 0 && (gkb[k2 - 1][l2 - 1] & 0x7c) == 0 && gkf[k2 - 1][l2 - 1] == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkf[k2 - 1][l2 - 1] = 3;
            }
            if(k2 < 95 && l2 > 0 && (gkb[k2][l2 - 1] & 0x74) == 0 && (gkb[k2 + 1][l2] & 0x72) == 0 && (gkb[k2 + 1][l2 - 1] & 0x76) == 0 && gkf[k2 + 1][l2 - 1] == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2 - 1;
                i2 = (i2 + 1) % i3;
                gkf[k2 + 1][l2 - 1] = 9;
            }
            if(k2 > 0 && l2 < 95 && (gkb[k2][l2 + 1] & 0x71) == 0 && (gkb[k2 - 1][l2] & 0x78) == 0 && (gkb[k2 - 1][l2 + 1] & 0x79) == 0 && gkf[k2 - 1][l2 + 1] == 0)
            {
                ai[i2] = k2 - 1;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkf[k2 - 1][l2 + 1] = 6;
            }
            if(k2 < 95 && l2 < 95 && (gkb[k2][l2 + 1] & 0x71) == 0 && (gkb[k2 + 1][l2] & 0x72) == 0 && (gkb[k2 + 1][l2 + 1] & 0x73) == 0 && gkf[k2 + 1][l2 + 1] == 0)
            {
                ai[i2] = k2 + 1;
                ai1[i2] = l2 + 1;
                i2 = (i2 + 1) % i3;
                gkf[k2 + 1][l2 + 1] = 12;
            }
        }
        if(!flag1)
            return -1;
        j2 = 0;
        ai[0] = k2;
        j2++;
        ai1[0] = l2;
        int k3;
        for(int j3 = k3 = gkf[k2][l2]; k2 != i || l2 != j; j3 = gkf[k2][l2])
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

    public int glb(int i, int j)
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
        return gkh[byte0][i * 48 + j];
    }

    public void glc(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(ahd.akm[k] == 1 || ahd.akm[k] == 2)
        {
            int l = glb(i, j);
            int i1;
            int j1;
            if(l == 0 || l == 4)
            {
                i1 = ahd.akk[k];
                j1 = ahd.akl[k];
            } else
            {
                j1 = ahd.akk[k];
                i1 = ahd.akl[k];
            }
            for(int k1 = i; k1 < i + i1; k1++)
            {
                for(int l1 = j; l1 < j + j1; l1++)
                    if(ahd.akm[k] == 1)
                        gkb[k1][l1] &= 0xffbf;
                    else
                    if(l == 0)
                    {
                        gkb[k1][l1] &= 0xfffd;
                        if(k1 > 0)
                            gmm(k1 - 1, l1, 8);
                    } else
                    if(l == 2)
                    {
                        gkb[k1][l1] &= 0xfffb;
                        if(l1 < 95)
                            gmm(k1, l1 + 1, 1);
                    } else
                    if(l == 4)
                    {
                        gkb[k1][l1] &= 0xfff7;
                        if(k1 < 95)
                            gmm(k1 + 1, l1, 2);
                    } else
                    if(l == 6)
                    {
                        gkb[k1][l1] &= 0xfffe;
                        if(l1 > 0)
                            gmm(k1, l1 - 1, 4);
                    }

            }

            gmn(i, j, i1, j1);
        }
    }

    public int gld(int i, int j, int k)
    {
        int l = gmj(i, j, k);
        if(l == 0)
            return -1;
        int i1 = ahd.ajc[l - 1];
        return i1 != 2 ? 0 : 1;
    }

    public gig(bbe bbe1, blm blm1)
    {
        super();
        boolean flag = false;
        gij = new int[4][2304];
        gin = new cgc[4][64];
        gja = new cgc[64];
        gjb = false;
        gjc = new byte[4][2304];
        gjf = 750;
        gjg = true;
        gjh = new byte[4][2304];
        gji = new int[256];
        gjj = false;
        gjk = new int[18432];
        gjl = new byte[4][2304];
        gka = new byte[4][2304];
        gkb = new int[96][96];
        gkc = new byte[4][2304];
        gkd = new int[96][96];
        gke = new byte[4][2304];
        gkf = new int[96][96];
        gkg = new cgc[4][64];
        gkh = new byte[4][2304];
        gki = new int[18432];
        gkk = bbe1;
        gkj = blm1;
        for(int i = 0; i < 64; i++)
            gji[i] = bbe.bkd(255 - i * 4, 255 - (int)((double)i * 1.75D), 255 - i * 4);

        for(int j = 0; j < 64; j++)
            gji[j + 64] = bbe.bkd(j * 3, 144, 0);

        for(int k = 0; k < 64; k++)
            gji[k + 128] = bbe.bkd(192 - (int)((double)k * 1.5D), 144 - (int)((double)k * 1.5D), 0);

        for(int l = 0; l < 64; l++)
            gji[l + 192] = bbe.bkd(96 - (int)((double)l * 1.5D), 48 + (int)((double)l * 1.5D), 0);

    }

    public void gle(int i, int j, int k, int l, int i1)
    {
        int j1 = i * 3;
        int k1 = j * 3;
        int l1 = gkk.bka(l);
        int i2 = gkk.bka(i1);
        l1 = l1 >> 1 & 0x7f7f7f;
        i2 = i2 >> 1 & 0x7f7f7f;
        if(k == 0)
        {
            gkj.cbj(j1, k1, 3, l1);
            gkj.cbj(j1, k1 + 1, 2, l1);
            gkj.cbj(j1, k1 + 2, 1, l1);
            gkj.cbj(j1 + 2, k1 + 1, 1, i2);
            gkj.cbj(j1 + 1, k1 + 2, 2, i2);
            return;
        }
        if(k == 1)
        {
            gkj.cbj(j1, k1, 3, i2);
            gkj.cbj(j1 + 1, k1 + 1, 2, i2);
            gkj.cbj(j1 + 2, k1 + 2, 1, i2);
            gkj.cbj(j1, k1 + 1, 1, l1);
            gkj.cbj(j1, k1 + 2, 2, l1);
        }
    }

    public int glf(int i, int j)
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
        return gka[byte0][i * 48 + j] & 0xff;
    }

    public void glg(cgc cgc1, int i, int j, int k, int l, int i1)
    {
        gml(j, k, 40);
        gml(l, i1, 40);
        int j1 = ahd.anc[i];
        int k1 = ahd.and[i];
        int l1 = ahd.ane[i];
        int i2 = j * 128;
        int j2 = k * 128;
        int k2 = l * 128;
        int l2 = i1 * 128;
        int i3 = cgc1.cmj(i2, -gkd[j][k], j2);
        int j3 = cgc1.cmj(i2, -gkd[j][k] - j1, j2);
        int k3 = cgc1.cmj(k2, -gkd[l][i1] - j1, l2);
        int l3 = cgc1.cmj(k2, -gkd[l][i1], l2);
        int ai[] = {
            i3, j3, k3, l3
        };
        int i4 = cgc1.cml(4, ai, k1, l1);
        if(ahd.ang[i] == 5)
        {
            cgc1.cih[i4] = 30000 + i;
            return;
        } else
        {
            cgc1.cih[i4] = 0;
            return;
        }
    }

    public int glh(int i, int j, int k, int l)
    {
        int i1 = gmj(i, j, k);
        if(i1 == 0)
            return l;
        else
            return ahd.ajb[i1 - 1];
    }

    public void gli(int i, int j, int k, int l, int i1)
    {
        cgc cgc1 = gja[i + j * 8];
        for(int j1 = 0; j1 < cgc1.cgd; j1++)
            if(cgc1.cjh[j1] == k * 128 && cgc1.cjj[j1] == l * 128)
            {
                cgc1.cnd(j1, i1);
                return;
            }

    }

    public int glj(int i, int j)
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
        return (gjh[byte0][i * 48 + j] & 0xff) * 3;
    }

    public void glk(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(ahd.anf[l] == 1)
        {
            if(k == 0)
            {
                gkb[i][j] &= 0xfffe;
                if(j > 0)
                    gmm(i, j - 1, 4);
            } else
            if(k == 1)
            {
                gkb[i][j] &= 0xfffd;
                if(i > 0)
                    gmm(i - 1, j, 8);
            } else
            if(k == 2)
                gkb[i][j] &= 0xffef;
            else
            if(k == 3)
                gkb[i][j] &= 0xffdf;
            gmn(i, j, 1, 1);
        }
    }

    public int gll(int i, int j)
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
        return gjc[byte0][i * 48 + j];
    }

    public int glm(int i, int j)
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
        return gkc[byte0][i * 48 + j] & 0xff;
    }

    public void gln(int i, int j, int k)
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
        gjl[byte0][i * 48 + j] = (byte)k;
    }

    public void gma()
    {
        boolean flag = false;
        for(int i = 0; i < 96; i++)
        {
            for(int j = 0; j < 96; j++)
                if(gmj(i, j, 0) == 250)
                    if(i == 47 && gmj(i + 1, j, 0) != 250 && gmj(i + 1, j, 0) != 2)
                        gln(i, j, 9);
                    else
                    if(j == 47 && gmj(i, j + 1, 0) != 250 && gmj(i, j + 1, 0) != 2)
                        gln(i, j, 9);
                    else
                        gln(i, j, 2);

        }

    }

    public void gmb(int i, int j, int k, int l, int i1)
    {
        int j1 = ahd.anc[i];
        if(gkd[j][k] < 0x13880)
            gkd[j][k] += 0x13880 + j1;
        if(gkd[l][i1] < 0x13880)
            gkd[l][i1] += 0x13880 + j1;
    }

    public boolean gmc(int i, int j)
    {
        return gll(i, j) > 0 || gll(i - 1, j) > 0 || gll(i - 1, j - 1) > 0 || gll(i, j - 1) > 0;
    }

    public int gmd(int i, int j)
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
        return gij[byte0][i * 48 + j];
    }

    public int gme(int i, int j)
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
            k1 = glj(k, l);
            l1 = glj(k + 1, l) - k1;
            i2 = glj(k, l + 1) - k1;
        } else
        {
            k1 = glj(k + 1, l + 1);
            l1 = glj(k, l + 1) - k1;
            i2 = glj(k + 1, l) - k1;
            i1 = 128 - i1;
            j1 = 128 - j1;
        }
        int j2 = k1 + (l1 * i1) / 128 + (i2 * j1) / 128;
        return j2;
    }

    public void gmf()
    {
        boolean flag = false;
        if(gjg)
            gkk.bhf();
        for(int i = 0; i < 64; i++)
        {
            gja[i] = null;
            for(int j = 0; j < 4; j++)
                gin[j][i] = null;

            for(int k = 0; k < 4; k++)
                gkg[k][i] = null;

        }

        System.gc();
    }

    public void gmg(int i, int j, int k, int l)
    {
        boolean flag = false;
        String s = "m" + k + i / 10 + i % 10 + j / 10 + j % 10;
        int i1;
        try
        {
            if(gjd != null)
            {
                byte abyte0[] = fnf.gak(s + ".hei", 0, gjd);
                if(abyte0 == null && gjm != null)
                    abyte0 = fnf.gak(s + ".hei", 0, gjm);
                if(abyte0 != null && abyte0.length > 0)
                {
                    int j1 = 0;
                    int k2 = 0;
                    for(int j3 = 0; j3 < 2304;)
                    {
                        int i4 = abyte0[j1++] & 0xff;
                        if(i4 < 128)
                        {
                            gjh[l][j3++] = (byte)i4;
                            k2 = i4;
                        }
                        if(i4 >= 128)
                        {
                            for(int i5 = 0; i5 < i4 - 128; i5++)
                                gjh[l][j3++] = (byte)k2;

                        }
                    }

                    k2 = 64;
                    for(int j4 = 0; j4 < 48; j4++)
                    {
                        for(int j5 = 0; j5 < 48; j5++)
                        {
                            k2 = gjh[l][j5 * 48 + j4] + k2 & 0x7f;
                            gjh[l][j5 * 48 + j4] = (byte)(k2 * 2);
                        }

                    }

                    k2 = 0;
                    for(int k5 = 0; k5 < 2304;)
                    {
                        int j6 = abyte0[j1++] & 0xff;
                        if(j6 < 128)
                        {
                            gkc[l][k5++] = (byte)j6;
                            k2 = j6;
                        }
                        if(j6 >= 128)
                        {
                            for(int k7 = 0; k7 < j6 - 128; k7++)
                                gkc[l][k5++] = (byte)k2;

                        }
                    }

                    k2 = 35;
                    for(int k6 = 0; k6 < 48; k6++)
                    {
                        for(int l7 = 0; l7 < 48; l7++)
                        {
                            k2 = gkc[l][l7 * 48 + k6] + k2 & 0x7f;
                            gkc[l][l7 * 48 + k6] = (byte)(k2 * 2);
                        }

                    }

                } else
                {
                    for(int k1 = 0; k1 < 2304; k1++)
                    {
                        gjh[l][k1] = 0;
                        gkc[l][k1] = 0;
                    }

                }
                abyte0 = fnf.gak(s + ".dat", 0, gje);
                if(abyte0 == null && gjn != null)
                    abyte0 = fnf.gak(s + ".dat", 0, gjn);
                if(abyte0 == null || abyte0.length == 0)
                    throw new IOException();
                int l1 = 0;
                for(int l2 = 0; l2 < 2304; l2++)
                    gka[l][l2] = abyte0[l1++];

                for(int k3 = 0; k3 < 2304; k3++)
                    gke[l][k3] = abyte0[l1++];

                for(int k4 = 0; k4 < 2304; k4++)
                    gij[l][k4] = abyte0[l1++] & 0xff;

                for(int l5 = 0; l5 < 2304; l5++)
                {
                    int l6 = abyte0[l1++] & 0xff;
                    if(l6 > 0)
                        gij[l][l5] = l6 + 12000;
                }

                for(int i7 = 0; i7 < 2304;)
                {
                    int i8 = abyte0[l1++] & 0xff;
                    if(i8 < 128)
                    {
                        gjc[l][i7++] = (byte)i8;
                    } else
                    {
                        for(int l8 = 0; l8 < i8 - 128; l8++)
                            gjc[l][i7++] = 0;

                    }
                }

                int j8 = 0;
                for(int i9 = 0; i9 < 2304;)
                {
                    int k9 = abyte0[l1++] & 0xff;
                    if(k9 < 128)
                    {
                        gjl[l][i9++] = (byte)k9;
                        j8 = k9;
                    } else
                    {
                        for(int j10 = 0; j10 < k9 - 128; j10++)
                            gjl[l][i9++] = (byte)j8;

                    }
                }

                for(int l9 = 0; l9 < 2304;)
                {
                    int k10 = abyte0[l1++] & 0xff;
                    if(k10 < 128)
                    {
                        gkh[l][l9++] = (byte)k10;
                    } else
                    {
                        for(int j11 = 0; j11 < k10 - 128; j11++)
                            gkh[l][l9++] = 0;

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
                            gij[l][l10++] = k11 + 48000;
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
                    gjh[l][l3] = (byte)j2;
                }

                j2 = 0;
                for(int l4 = 0; l4 < 2304; l4++)
                {
                    j2 = j2 + abyte1[i3++] & 0xff;
                    gkc[l][l4] = (byte)j2;
                }

                for(int i6 = 0; i6 < 2304; i6++)
                    gka[l][i6] = abyte1[i3++];

                for(int j7 = 0; j7 < 2304; j7++)
                    gke[l][j7] = abyte1[i3++];

                for(int k8 = 0; k8 < 2304; k8++)
                {
                    gij[l][k8] = (abyte1[i3] & 0xff) * 256 + (abyte1[i3 + 1] & 0xff);
                    i3 += 2;
                }

                for(int j9 = 0; j9 < 2304; j9++)
                    gjc[l][j9] = abyte1[i3++];

                for(int i10 = 0; i10 < 2304; i10++)
                    gjl[l][i10] = abyte1[i3++];

                for(int i11 = 0; i11 < 2304; i11++)
                    gkh[l][i11] = abyte1[i3++];

            }
            return;
        }
        catch(IOException _ex)
        {
            i1 = 0;
        }
        for(; i1 < 2304; i1++)
        {
            gjh[l][i1] = 0;
            gkc[l][i1] = 0;
            gka[l][i1] = 0;
            gke[l][i1] = 0;
            gij[l][i1] = 0;
            gjc[l][i1] = 0;
            gjl[l][i1] = 0;
            if(k == 0)
                gjl[l][i1] = -6;
            if(k == 3)
                gjl[l][i1] = 8;
            gkh[l][i1] = 0;
        }

    }

    public void gmh(cgc acgc[])
    {
        boolean flag = false;
        for(int i = 0; i < 94; i++)
        {
            for(int j = 0; j < 94; j++)
                if(gmd(i, j) > 48000 && gmd(i, j) < 60000)
                {
                    int k = gmd(i, j) - 48001;
                    int l = glb(i, j);
                    int i1;
                    int j1;
                    if(l == 0 || l == 4)
                    {
                        i1 = ahd.akk[k];
                        j1 = ahd.akl[k];
                    } else
                    {
                        j1 = ahd.akk[k];
                        i1 = ahd.akl[k];
                    }
                    gna(i, j, k);
                    cgc cgc1 = acgc[ahd.akj[k]].dag(false, true, false, false);
                    int k1 = ((i + i + i1) * 128) / 2;
                    int i2 = ((j + j + j1) * 128) / 2;
                    cgc1.cng(k1, -gme(k1, i2), i2);
                    cgc1.cnf(0, glb(i, j) * 32, 0);
                    gkk.bhd(cgc1);
                    cgc1.cnb(48, 48, -50, -10, -50);
                    if(i1 > 1 || j1 > 1)
                    {
                        for(int k2 = i; k2 < i + i1; k2++)
                        {
                            for(int l2 = j; l2 < j + j1; l2++)
                                if((k2 > i || l2 > j) && gmd(k2, l2) - 48001 == k)
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
                                    gij[byte0][l1 * 48 + j2] = 0;
                                }

                        }

                    }
                }

        }

    }

    public void gmi(int i, int j, int k, boolean flag)
    {
        boolean flag2 = false;
        int l = (i + 24) / 48;
        int i1 = (j + 24) / 48;
        gmg(l - 1, i1 - 1, k, 0);
        gmg(l, i1 - 1, k, 1);
        gmg(l - 1, i1, k, 2);
        gmg(l, i1, k, 3);
        gma();
        if(gim == null)
            gim = new cgc(18688, 18688, true, true, false, false, true);
        if(flag)
        {
            gkj.cbd();
            for(int j1 = 0; j1 < 96; j1++)
            {
                for(int l1 = 0; l1 < 96; l1++)
                    gkb[j1][l1] = 0;

            }

            cgc cgc1 = gim;
            cgc1.cmg();
            for(int j2 = 0; j2 < 96; j2++)
            {
                for(int i3 = 0; i3 < 96; i3++)
                {
                    int i4 = -glj(j2, i3);
                    if(gmj(j2, i3, k) > 0 && ahd.ajc[gmj(j2, i3, k) - 1] == 4)
                        i4 = 0;
                    if(gmj(j2 - 1, i3, k) > 0 && ahd.ajc[gmj(j2 - 1, i3, k) - 1] == 4)
                        i4 = 0;
                    if(gmj(j2, i3 - 1, k) > 0 && ahd.ajc[gmj(j2, i3 - 1, k) - 1] == 4)
                        i4 = 0;
                    if(gmj(j2 - 1, i3 - 1, k) > 0 && ahd.ajc[gmj(j2 - 1, i3 - 1, k) - 1] == 4)
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
                    int k5 = glm(j3, j4);
                    int k7 = gji[k5];
                    int i10 = k7;
                    int k12 = k7;
                    int l14 = 0;
                    if(k == 1 || k == 2)
                    {
                        k7 = 0xbc614e;
                        i10 = 0xbc614e;
                        k12 = 0xbc614e;
                    }
                    if(gmj(j3, j4, k) > 0)
                    {
                        int l16 = gmj(j3, j4, k);
                        int l5 = ahd.ajc[l16 - 1];
                        int i19 = gld(j3, j4, k);
                        k7 = i10 = ahd.ajb[l16 - 1];
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
                            if(gmd(j3, j4) > 0 && gmd(j3, j4) < 24000)
                                if(glh(j3 - 1, j4, k, k12) != 0xbc614e && glh(j3, j4 - 1, k, k12) != 0xbc614e)
                                {
                                    k7 = glh(j3 - 1, j4, k, k12);
                                    l14 = 0;
                                } else
                                if(glh(j3 + 1, j4, k, k12) != 0xbc614e && glh(j3, j4 + 1, k, k12) != 0xbc614e)
                                {
                                    i10 = glh(j3 + 1, j4, k, k12);
                                    l14 = 0;
                                } else
                                if(glh(j3 + 1, j4, k, k12) != 0xbc614e && glh(j3, j4 - 1, k, k12) != 0xbc614e)
                                {
                                    i10 = glh(j3 + 1, j4, k, k12);
                                    l14 = 1;
                                } else
                                if(glh(j3 - 1, j4, k, k12) != 0xbc614e && glh(j3, j4 + 1, k, k12) != 0xbc614e)
                                {
                                    k7 = glh(j3 - 1, j4, k, k12);
                                    l14 = 1;
                                }
                        } else
                        if(l5 != 2 || gmd(j3, j4) > 0 && gmd(j3, j4) < 24000)
                            if(gld(j3 - 1, j4, k) != i19 && gld(j3, j4 - 1, k) != i19)
                            {
                                k7 = k12;
                                l14 = 0;
                            } else
                            if(gld(j3 + 1, j4, k) != i19 && gld(j3, j4 + 1, k) != i19)
                            {
                                i10 = k12;
                                l14 = 0;
                            } else
                            if(gld(j3 + 1, j4, k) != i19 && gld(j3, j4 - 1, k) != i19)
                            {
                                i10 = k12;
                                l14 = 1;
                            } else
                            if(gld(j3 - 1, j4, k) != i19 && gld(j3, j4 + 1, k) != i19)
                            {
                                k7 = k12;
                                l14 = 1;
                            }
                        if(ahd.ajd[l16 - 1] != 0)
                            gkb[j3][j4] |= 0x40;
                        if(ahd.ajc[l16 - 1] == 2)
                            gkb[j3][j4] |= 0x80;
                    }
                    gle(j3, j4, l14, k7, i10);
                    int i17 = ((glj(j3 + 1, j4 + 1) - glj(j3 + 1, j4)) + glj(j3, j4 + 1)) - glj(j3, j4);
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
                                gjk[l21] = j3;
                                gki[l21] = j4;
                                cgc1.cih[l21] = 0x30d40 + l21;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 1;
                                ai7[1] = j4 + j3 * 96 + 96 + 1;
                                ai7[2] = j4 + j3 * 96 + 96;
                                int i22 = cgc1.cml(3, ai7, 0xbc614e, i10);
                                gjk[i22] = j3;
                                gki[i22] = j4;
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
                                gjk[j22] = j3;
                                gki[j22] = j4;
                                cgc1.cih[j22] = 0x30d40 + j22;
                            }
                            if(i10 != 0xbc614e)
                            {
                                ai7[0] = j4 + j3 * 96 + 96;
                                ai7[1] = j4 + j3 * 96;
                                ai7[2] = j4 + j3 * 96 + 96 + 1;
                                int k22 = cgc1.cml(3, ai7, 0xbc614e, i10);
                                gjk[k22] = j3;
                                gki[k22] = j4;
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
                        gjk[l19] = j3;
                        gki[l19] = j4;
                        cgc1.cih[l19] = 0x30d40 + l19;
                    }
                }

            }

            for(int k4 = 1; k4 < 95; k4++)
            {
                for(int i6 = 1; i6 < 95; i6++)
                    if(gmj(k4, i6, k) > 0 && ahd.ajc[gmj(k4, i6, k) - 1] == 4)
                    {
                        int l7 = ahd.ajb[gmj(k4, i6, k) - 1];
                        int j10 = cgc1.cmj(k4 * 128, -glj(k4, i6), i6 * 128);
                        int l12 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6), i6 * 128);
                        int i15 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6 + 1), (i6 + 1) * 128);
                        int j17 = cgc1.cmj(k4 * 128, -glj(k4, i6 + 1), (i6 + 1) * 128);
                        int ai2[] = {
                            j10, l12, i15, j17
                        };
                        int i20 = cgc1.cml(4, ai2, l7, 0xbc614e);
                        gjk[i20] = k4;
                        gki[i20] = i6;
                        cgc1.cih[i20] = 0x30d40 + i20;
                        gle(k4, i6, 0, l7, l7);
                    } else
                    if(gmj(k4, i6, k) == 0 || ahd.ajc[gmj(k4, i6, k) - 1] != 3)
                    {
                        if(gmj(k4, i6 + 1, k) > 0 && ahd.ajc[gmj(k4, i6 + 1, k) - 1] == 4)
                        {
                            int i8 = ahd.ajb[gmj(k4, i6 + 1, k) - 1];
                            int k10 = cgc1.cmj(k4 * 128, -glj(k4, i6), i6 * 128);
                            int i13 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6), i6 * 128);
                            int j15 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int k17 = cgc1.cmj(k4 * 128, -glj(k4, i6 + 1), (i6 + 1) * 128);
                            int ai3[] = {
                                k10, i13, j15, k17
                            };
                            int j20 = cgc1.cml(4, ai3, i8, 0xbc614e);
                            gjk[j20] = k4;
                            gki[j20] = i6;
                            cgc1.cih[j20] = 0x30d40 + j20;
                            gle(k4, i6, 0, i8, i8);
                        }
                        if(gmj(k4, i6 - 1, k) > 0 && ahd.ajc[gmj(k4, i6 - 1, k) - 1] == 4)
                        {
                            int j8 = ahd.ajb[gmj(k4, i6 - 1, k) - 1];
                            int l10 = cgc1.cmj(k4 * 128, -glj(k4, i6), i6 * 128);
                            int j13 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6), i6 * 128);
                            int k15 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int l17 = cgc1.cmj(k4 * 128, -glj(k4, i6 + 1), (i6 + 1) * 128);
                            int ai4[] = {
                                l10, j13, k15, l17
                            };
                            int k20 = cgc1.cml(4, ai4, j8, 0xbc614e);
                            gjk[k20] = k4;
                            gki[k20] = i6;
                            cgc1.cih[k20] = 0x30d40 + k20;
                            gle(k4, i6, 0, j8, j8);
                        }
                        if(gmj(k4 + 1, i6, k) > 0 && ahd.ajc[gmj(k4 + 1, i6, k) - 1] == 4)
                        {
                            int k8 = ahd.ajb[gmj(k4 + 1, i6, k) - 1];
                            int i11 = cgc1.cmj(k4 * 128, -glj(k4, i6), i6 * 128);
                            int k13 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6), i6 * 128);
                            int l15 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int i18 = cgc1.cmj(k4 * 128, -glj(k4, i6 + 1), (i6 + 1) * 128);
                            int ai5[] = {
                                i11, k13, l15, i18
                            };
                            int l20 = cgc1.cml(4, ai5, k8, 0xbc614e);
                            gjk[l20] = k4;
                            gki[l20] = i6;
                            cgc1.cih[l20] = 0x30d40 + l20;
                            gle(k4, i6, 0, k8, k8);
                        }
                        if(gmj(k4 - 1, i6, k) > 0 && ahd.ajc[gmj(k4 - 1, i6, k) - 1] == 4)
                        {
                            int l8 = ahd.ajb[gmj(k4 - 1, i6, k) - 1];
                            int j11 = cgc1.cmj(k4 * 128, -glj(k4, i6), i6 * 128);
                            int l13 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6), i6 * 128);
                            int i16 = cgc1.cmj((k4 + 1) * 128, -glj(k4 + 1, i6 + 1), (i6 + 1) * 128);
                            int j18 = cgc1.cmj(k4 * 128, -glj(k4, i6 + 1), (i6 + 1) * 128);
                            int ai6[] = {
                                j11, l13, i16, j18
                            };
                            int i21 = cgc1.cml(4, ai6, l8, 0xbc614e);
                            gjk[i21] = k4;
                            gki[i21] = i6;
                            cgc1.cih[i21] = 0x30d40 + i21;
                            gle(k4, i6, 0, l8, l8);
                        }
                    }

            }

            cgc1.cna(true, 40, 48, -50, -10, -50);
            gja = gim.cmm(0, 0, 1536, 1536, 8, 64, 233, false);
            for(int j6 = 0; j6 < 64; j6++)
                gkk.bhd(gja[j6]);

            for(int i9 = 0; i9 < 96; i9++)
            {
                for(int k11 = 0; k11 < 96; k11++)
                    gkd[i9][k11] = glj(i9, k11);

            }

        }
        gim.cmg();
        int k1 = 0x606060;
        for(int i2 = 0; i2 < 95; i2++)
        {
            for(int k2 = 0; k2 < 95; k2++)
            {
                int k3 = gkn(i2, k2);
                if(k3 > 0 && ahd.ang[k3 - 1] == 0)
                {
                    glg(gim, k3 - 1, i2, k2, i2 + 1, k2);
                    if(flag && ahd.anf[k3 - 1] != 0)
                    {
                        gkb[i2][k2] |= 1;
                        if(k2 > 0)
                            gmk(i2, k2 - 1, 4);
                    }
                    if(flag)
                        gkj.cbj(i2 * 3, k2 * 3, 3, 0x606060);
                }
                k3 = glf(i2, k2);
                if(k3 > 0 && ahd.ang[k3 - 1] == 0)
                {
                    glg(gim, k3 - 1, i2, k2, i2, k2 + 1);
                    if(flag && ahd.anf[k3 - 1] != 0)
                    {
                        gkb[i2][k2] |= 2;
                        if(i2 > 0)
                            gmk(i2 - 1, k2, 8);
                    }
                    if(flag)
                        gkj.cbk(i2 * 3, k2 * 3, 3, 0x606060);
                }
                k3 = gmd(i2, k2);
                if(k3 > 0 && k3 < 12000 && ahd.ang[k3 - 1] == 0)
                {
                    glg(gim, k3 - 1, i2, k2, i2 + 1, k2 + 1);
                    if(flag && ahd.anf[k3 - 1] != 0)
                        gkb[i2][k2] |= 0x20;
                    if(flag)
                    {
                        gkj.cbl(i2 * 3, k2 * 3, 0x606060);
                        gkj.cbl(i2 * 3 + 1, k2 * 3 + 1, 0x606060);
                        gkj.cbl(i2 * 3 + 2, k2 * 3 + 2, 0x606060);
                    }
                }
                if(k3 > 12000 && k3 < 24000 && ahd.ang[k3 - 12001] == 0)
                {
                    glg(gim, k3 - 12001, i2 + 1, k2, i2, k2 + 1);
                    if(flag && ahd.anf[k3 - 12001] != 0)
                        gkb[i2][k2] |= 0x10;
                    if(flag)
                    {
                        gkj.cbl(i2 * 3 + 2, k2 * 3, 0x606060);
                        gkj.cbl(i2 * 3 + 1, k2 * 3 + 1, 0x606060);
                        gkj.cbl(i2 * 3, k2 * 3 + 2, 0x606060);
                    }
                }
            }

        }

        if(flag)
            gkj.ccg(gjf - 1, 0, 0, 285, 285);
        gim.cna(false, 60, 24, -50, -10, -50);
        gin[k] = gim.cmm(0, 0, 1536, 1536, 8, 64, 338, true);
        for(int l2 = 0; l2 < 64; l2++)
            gkk.bhd(gin[k][l2]);

        for(int l3 = 0; l3 < 95; l3++)
        {
            for(int l4 = 0; l4 < 95; l4++)
            {
                int k6 = gkn(l3, l4);
                if(k6 > 0)
                    gmb(k6 - 1, l3, l4, l3 + 1, l4);
                k6 = glf(l3, l4);
                if(k6 > 0)
                    gmb(k6 - 1, l3, l4, l3, l4 + 1);
                k6 = gmd(l3, l4);
                if(k6 > 0 && k6 < 12000)
                    gmb(k6 - 1, l3, l4, l3 + 1, l4 + 1);
                if(k6 > 12000 && k6 < 24000)
                    gmb(k6 - 12001, l3 + 1, l4, l3, l4 + 1);
            }

        }

        for(int i5 = 1; i5 < 95; i5++)
        {
            for(int l6 = 1; l6 < 95; l6++)
            {
                int j9 = gll(i5, l6);
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
                    int j24 = gkd[l11][i14];
                    int l24 = gkd[j16][k18];
                    int j25 = gkd[j19][j21];
                    int l25 = gkd[l22][j23];
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
                        gkd[l11][i14] = l23;
                    else
                        gkd[l11][i14] -= 0x13880;
                    if(l24 < 0x13880)
                        gkd[j16][k18] = l23;
                    else
                        gkd[j16][k18] -= 0x13880;
                    if(j25 < 0x13880)
                        gkd[j19][j21] = l23;
                    else
                        gkd[j19][j21] -= 0x13880;
                    if(l25 < 0x13880)
                        gkd[l22][j23] = l23;
                    else
                        gkd[l22][j23] -= 0x13880;
                }
            }

        }

        gim.cmg();
        for(int i7 = 1; i7 < 95; i7++)
        {
            for(int k9 = 1; k9 < 95; k9++)
            {
                int i12 = gll(i7, k9);
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
                    int j27 = gkd[j14][k16];
                    int k27 = gkd[l18][k19];
                    int l27 = gkd[k21][i23];
                    int i28 = gkd[k23][i24];
                    int j28 = ahd.amb[i12 - 1];
                    if(gkm(j14, k16) && j27 < 0x13880)
                    {
                        j27 += j28 + 0x13880;
                        gkd[j14][k16] = j27;
                    }
                    if(gkm(l18, k19) && k27 < 0x13880)
                    {
                        k27 += j28 + 0x13880;
                        gkd[l18][k19] = k27;
                    }
                    if(gkm(k21, i23) && l27 < 0x13880)
                    {
                        l27 += j28 + 0x13880;
                        gkd[k21][i23] = l27;
                    }
                    if(gkm(k23, i24) && i28 < 0x13880)
                    {
                        i28 += j28 + 0x13880;
                        gkd[k23][i24] = i28;
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
                    if(!gmc(j14 - 1, k16))
                        k24 -= 16;
                    if(!gmc(j14 + 1, k16))
                        k24 += 16;
                    if(!gmc(j14, k16 - 1))
                        i25 -= 16;
                    if(!gmc(j14, k16 + 1))
                        i25 += 16;
                    if(!gmc(l18 - 1, k19))
                        k25 -= 16;
                    if(!gmc(l18 + 1, k19))
                        k25 += 16;
                    if(!gmc(l18, k19 - 1))
                        k26 -= 16;
                    if(!gmc(l18, k19 + 1))
                        k26 += 16;
                    if(!gmc(k21 - 1, i23))
                        l26 -= 16;
                    if(!gmc(k21 + 1, i23))
                        l26 += 16;
                    if(!gmc(k21, i23 - 1))
                        i26 -= 16;
                    if(!gmc(k21, i23 + 1))
                        i26 += 16;
                    if(!gmc(k23 - 1, i24))
                        j26 -= 16;
                    if(!gmc(k23 + 1, i24))
                        j26 += 16;
                    if(!gmc(k23, i24 - 1))
                        i27 -= 16;
                    if(!gmc(k23, i24 + 1))
                        i27 += 16;
                    i12 = ahd.amc[i12 - 1];
                    j27 = -j27;
                    k27 = -k27;
                    l27 = -l27;
                    i28 = -i28;
                    if(gmd(i7, k9) > 12000 && gmd(i7, k9) < 24000 && gll(i7 - 1, k9 - 1) == 0)
                    {
                        int ai8[] = new int[3];
                        ai8[0] = gim.cmj(l26, l27, i26);
                        ai8[1] = gim.cmj(j26, i28, i27);
                        ai8[2] = gim.cmj(k25, k27, k26);
                        gim.cml(3, ai8, i12, 0xbc614e);
                    } else
                    if(gmd(i7, k9) > 12000 && gmd(i7, k9) < 24000 && gll(i7 + 1, k9 + 1) == 0)
                    {
                        int ai9[] = new int[3];
                        ai9[0] = gim.cmj(k24, j27, i25);
                        ai9[1] = gim.cmj(k25, k27, k26);
                        ai9[2] = gim.cmj(j26, i28, i27);
                        gim.cml(3, ai9, i12, 0xbc614e);
                    } else
                    if(gmd(i7, k9) > 0 && gmd(i7, k9) < 12000 && gll(i7 + 1, k9 - 1) == 0)
                    {
                        int ai10[] = new int[3];
                        ai10[0] = gim.cmj(j26, i28, i27);
                        ai10[1] = gim.cmj(k24, j27, i25);
                        ai10[2] = gim.cmj(l26, l27, i26);
                        gim.cml(3, ai10, i12, 0xbc614e);
                    } else
                    if(gmd(i7, k9) > 0 && gmd(i7, k9) < 12000 && gll(i7 - 1, k9 + 1) == 0)
                    {
                        int ai11[] = new int[3];
                        ai11[0] = gim.cmj(k25, k27, k26);
                        ai11[1] = gim.cmj(l26, l27, i26);
                        ai11[2] = gim.cmj(k24, j27, i25);
                        gim.cml(3, ai11, i12, 0xbc614e);
                    } else
                    if(j27 == k27 && l27 == i28)
                    {
                        int ai12[] = new int[4];
                        ai12[0] = gim.cmj(k24, j27, i25);
                        ai12[1] = gim.cmj(k25, k27, k26);
                        ai12[2] = gim.cmj(l26, l27, i26);
                        ai12[3] = gim.cmj(j26, i28, i27);
                        gim.cml(4, ai12, i12, 0xbc614e);
                    } else
                    if(j27 == i28 && k27 == l27)
                    {
                        int ai13[] = new int[4];
                        ai13[0] = gim.cmj(j26, i28, i27);
                        ai13[1] = gim.cmj(k24, j27, i25);
                        ai13[2] = gim.cmj(k25, k27, k26);
                        ai13[3] = gim.cmj(l26, l27, i26);
                        gim.cml(4, ai13, i12, 0xbc614e);
                    } else
                    {
                        boolean flag1 = true;
                        if(gll(i7 - 1, k9 - 1) > 0)
                            flag1 = false;
                        if(gll(i7 + 1, k9 + 1) > 0)
                            flag1 = false;
                        if(!flag1)
                        {
                            int ai14[] = new int[3];
                            ai14[0] = gim.cmj(k25, k27, k26);
                            ai14[1] = gim.cmj(l26, l27, i26);
                            ai14[2] = gim.cmj(k24, j27, i25);
                            gim.cml(3, ai14, i12, 0xbc614e);
                            int ai16[] = new int[3];
                            ai16[0] = gim.cmj(j26, i28, i27);
                            ai16[1] = gim.cmj(k24, j27, i25);
                            ai16[2] = gim.cmj(l26, l27, i26);
                            gim.cml(3, ai16, i12, 0xbc614e);
                        } else
                        {
                            int ai15[] = new int[3];
                            ai15[0] = gim.cmj(k24, j27, i25);
                            ai15[1] = gim.cmj(k25, k27, k26);
                            ai15[2] = gim.cmj(j26, i28, i27);
                            gim.cml(3, ai15, i12, 0xbc614e);
                            int ai17[] = new int[3];
                            ai17[0] = gim.cmj(l26, l27, i26);
                            ai17[1] = gim.cmj(j26, i28, i27);
                            ai17[2] = gim.cmj(k25, k27, k26);
                            gim.cml(3, ai17, i12, 0xbc614e);
                        }
                    }
                }
            }

        }

        gim.cna(true, 50, 50, -50, -10, -50);
        gkg[k] = gim.cmm(0, 0, 1536, 1536, 8, 64, 169, true);
        for(int l9 = 0; l9 < 64; l9++)
            gkk.bhd(gkg[k][l9]);

        if(gkg[k][0] == null)
            throw new RuntimeException("null roof!");
        for(int j12 = 0; j12 < 96; j12++)
        {
            for(int k14 = 0; k14 < 96; k14++)
                if(gkd[j12][k14] >= 0x13880)
                    gkd[j12][k14] -= 0x13880;

        }

    }

    public int gmj(int i, int j, int k)
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
        return gjl[byte0][i * 48 + j] & 0xff;
    }

    public void gmk(int i, int j, int k)
    {
        gkb[i][j] |= k;
    }

    public void gml(int i, int j, int k)
    {
        int l = i / 12;
        int i1 = j / 12;
        int j1 = (i - 1) / 12;
        int k1 = (j - 1) / 12;
        gli(l, i1, i, j, k);
        if(l != j1)
            gli(j1, i1, i, j, k);
        if(i1 != k1)
            gli(l, k1, i, j, k);
        if(l != j1 && i1 != k1)
            gli(j1, k1, i, j, k);
    }

    public void gmm(int i, int j, int k)
    {
        gkb[i][j] &= 65535 - k;
    }

    public void gmn(int i, int j, int k, int l)
    {
        boolean flag = false;
        if(i < 1 || j < 1 || i + k >= 96 || j + l >= 96)
            return;
        for(int i1 = i; i1 <= i + k; i1++)
        {
            for(int j1 = j; j1 <= j + l; j1++)
                if((gnc(i1, j1) & 0x63) != 0 || (gnc(i1 - 1, j1) & 0x59) != 0 || (gnc(i1, j1 - 1) & 0x56) != 0 || (gnc(i1 - 1, j1 - 1) & 0x6c) != 0)
                    gml(i1, j1, 35);
                else
                    gml(i1, j1, 0);

        }

    }

    public void gna(int i, int j, int k)
    {
        boolean flag = false;
        if(i < 0 || j < 0 || i >= 95 || j >= 95)
            return;
        if(ahd.akm[k] == 1 || ahd.akm[k] == 2)
        {
            int l = glb(i, j);
            int i1;
            int j1;
            if(l == 0 || l == 4)
            {
                i1 = ahd.akk[k];
                j1 = ahd.akl[k];
            } else
            {
                j1 = ahd.akk[k];
                i1 = ahd.akl[k];
            }
            for(int k1 = i; k1 < i + i1; k1++)
            {
                for(int l1 = j; l1 < j + j1; l1++)
                    if(ahd.akm[k] == 1)
                        gkb[k1][l1] |= 0x40;
                    else
                    if(l == 0)
                    {
                        gkb[k1][l1] |= 2;
                        if(k1 > 0)
                            gmk(k1 - 1, l1, 8);
                    } else
                    if(l == 2)
                    {
                        gkb[k1][l1] |= 4;
                        if(l1 < 95)
                            gmk(k1, l1 + 1, 1);
                    } else
                    if(l == 4)
                    {
                        gkb[k1][l1] |= 8;
                        if(k1 < 95)
                            gmk(k1 + 1, l1, 2);
                    } else
                    if(l == 6)
                    {
                        gkb[k1][l1] |= 1;
                        if(l1 > 0)
                            gmk(k1, l1 - 1, 4);
                    }

            }

            gmn(i, j, i1, j1);
        }
    }

    public void gnb(int i, int j, int k)
    {
        gmf();
        int l = (i + 24) / 48;
        int i1 = (j + 24) / 48;
        gmi(i, j, k, true);
        if(k == 0)
        {
            gmi(i, j, 1, false);
            gmi(i, j, 2, false);
            gmg(l - 1, i1 - 1, k, 0);
            gmg(l, i1 - 1, k, 1);
            gmg(l - 1, i1, k, 2);
            gmg(l, i1, k, 3);
            gma();
        }
    }

    public int gnc(int i, int j)
    {
        if(i < 0 || j < 0 || i >= 96 || j >= 96)
            return 0;
        else
            return gkb[i][j];
    }

    final int gih = 96;
    final int gii = 96;
    int gij[][];
    final int gik = 0xbc614e;
    final int gil = 128;
    cgc gim;
    cgc gin[][];
    cgc gja[];
    boolean gjb;
    byte gjc[][];
    byte gjd[];
    byte gje[];
    int gjf;
    boolean gjg;
    byte gjh[][];
    int gji[];
    boolean gjj;
    int gjk[];
    byte gjl[][];
    byte gjm[];
    byte gjn[];
    byte gka[][];
    int gkb[][];
    byte gkc[][];
    int gkd[][];
    byte gke[][];
    int gkf[][];
    cgc gkg[][];
    byte gkh[][];
    int gki[];
    blm gkj;
    bbe gkk;
}
