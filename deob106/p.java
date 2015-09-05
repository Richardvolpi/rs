// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import jagex.client.*;
import jagex.o;
import java.io.IOException;

public class p
{

    public p(j j1, i k)
    {
        zfb = true;
        agb = false;
        dgb = 750;
        ggb = new int[256];
        mgb = new byte[4][2304];
        ngb = new byte[4][2304];
        ogb = new byte[4][2304];
        pgb = new byte[4][2304];
        qgb = new byte[4][2304];
        rgb = new byte[4][2304];
        sgb = new byte[4][2304];
        tgb = new int[4][2304];
        ugb = 96;
        vgb = 96;
        wgb = new int[ugb * vgb * 2];
        xgb = new int[ugb * vgb * 2];
        ygb = new int[ugb][vgb];
        zgb = new int[ugb][vgb];
        ahb = new int[ugb][vgb];
        bhb = false;
        chb = new h[64];
        dhb = new h[4][64];
        ehb = new h[4][64];
        cgb = j1;
        bgb = k;
        for(int l = 0; l < 64; l++)
            ggb[l] = j.li(255 - l * 4, 255 - (int)((double)l * 1.75D), 255 - l * 4);

        for(int i1 = 0; i1 < 64; i1++)
            ggb[i1 + 64] = j.li(i1 * 3, 144, 0);

        for(int k1 = 0; k1 < 64; k1++)
            ggb[k1 + 128] = j.li(192 - (int)((double)k1 * 1.5D), 144 - (int)((double)k1 * 1.5D), 0);

        for(int l1 = 0; l1 < 64; l1++)
            ggb[l1 + 192] = j.li(96 - (int)((double)l1 * 1.5D), 48 + (int)((double)l1 * 1.5D), 0);

    }

    public int io(int k, int l, int i1, int j1, int k1, int l1, int ai[], 
            int ai1[], boolean flag)
    {
        for(int i2 = 0; i2 < ugb; i2++)
        {
            for(int j2 = 0; j2 < vgb; j2++)
                ygb[i2][j2] = 0;

        }

        int k2 = 0;
        int l2 = 0;
        int i3 = k;
        int j3 = l;
        ygb[k][l] = 99;
        ai[k2] = k;
        ai1[k2++] = l;
        int k3 = ai.length;
        boolean flag1 = false;
        while(l2 != k2) 
        {
            i3 = ai[l2];
            j3 = ai1[l2];
            l2 = (l2 + 1) % k3;
            if(i3 >= i1 && i3 <= k1 && j3 >= j1 && j3 <= l1)
            {
                flag1 = true;
                break;
            }
            if(flag)
            {
                if(i3 > 0 && i3 - 1 >= i1 && i3 - 1 <= k1 && j3 >= j1 && j3 <= l1 && (zgb[i3 - 1][j3] & 8) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(i3 < ugb - 1 && i3 + 1 >= i1 && i3 + 1 <= k1 && j3 >= j1 && j3 <= l1 && (zgb[i3 + 1][j3] & 2) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(j3 > 0 && i3 >= i1 && i3 <= k1 && j3 - 1 >= j1 && j3 - 1 <= l1 && (zgb[i3][j3 - 1] & 4) == 0)
                {
                    flag1 = true;
                    break;
                }
                if(j3 < vgb - 1 && i3 >= i1 && i3 <= k1 && j3 + 1 >= j1 && j3 + 1 <= l1 && (zgb[i3][j3 + 1] & 1) == 0)
                {
                    flag1 = true;
                    break;
                }
            }
            if(i3 > 0 && ygb[i3 - 1][j3] == 0 && (zgb[i3 - 1][j3] & 0x78) == 0)
            {
                ai[k2] = i3 - 1;
                ai1[k2] = j3;
                k2 = (k2 + 1) % k3;
                ygb[i3 - 1][j3] = 2;
            }
            if(i3 < ugb - 1 && ygb[i3 + 1][j3] == 0 && (zgb[i3 + 1][j3] & 0x72) == 0)
            {
                ai[k2] = i3 + 1;
                ai1[k2] = j3;
                k2 = (k2 + 1) % k3;
                ygb[i3 + 1][j3] = 8;
            }
            if(j3 > 0 && ygb[i3][j3 - 1] == 0 && (zgb[i3][j3 - 1] & 0x74) == 0)
            {
                ai[k2] = i3;
                ai1[k2] = j3 - 1;
                k2 = (k2 + 1) % k3;
                ygb[i3][j3 - 1] = 1;
            }
            if(j3 < vgb - 1 && ygb[i3][j3 + 1] == 0 && (zgb[i3][j3 + 1] & 0x71) == 0)
            {
                ai[k2] = i3;
                ai1[k2] = j3 + 1;
                k2 = (k2 + 1) % k3;
                ygb[i3][j3 + 1] = 4;
            }
            if(i3 > 0 && j3 > 0 && (zgb[i3][j3 - 1] & 0x74) == 0 && (zgb[i3 - 1][j3] & 0x78) == 0 && (zgb[i3 - 1][j3 - 1] & 0x7c) == 0 && ygb[i3 - 1][j3 - 1] == 0)
            {
                ai[k2] = i3 - 1;
                ai1[k2] = j3 - 1;
                k2 = (k2 + 1) % k3;
                ygb[i3 - 1][j3 - 1] = 3;
            }
            if(i3 < ugb - 1 && j3 > 0 && (zgb[i3][j3 - 1] & 0x74) == 0 && (zgb[i3 + 1][j3] & 0x72) == 0 && (zgb[i3 + 1][j3 - 1] & 0x76) == 0 && ygb[i3 + 1][j3 - 1] == 0)
            {
                ai[k2] = i3 + 1;
                ai1[k2] = j3 - 1;
                k2 = (k2 + 1) % k3;
                ygb[i3 + 1][j3 - 1] = 9;
            }
            if(i3 > 0 && j3 < vgb - 1 && (zgb[i3][j3 + 1] & 0x71) == 0 && (zgb[i3 - 1][j3] & 0x78) == 0 && (zgb[i3 - 1][j3 + 1] & 0x79) == 0 && ygb[i3 - 1][j3 + 1] == 0)
            {
                ai[k2] = i3 - 1;
                ai1[k2] = j3 + 1;
                k2 = (k2 + 1) % k3;
                ygb[i3 - 1][j3 + 1] = 6;
            }
            if(i3 < ugb - 1 && j3 < vgb - 1 && (zgb[i3][j3 + 1] & 0x71) == 0 && (zgb[i3 + 1][j3] & 0x72) == 0 && (zgb[i3 + 1][j3 + 1] & 0x73) == 0 && ygb[i3 + 1][j3 + 1] == 0)
            {
                ai[k2] = i3 + 1;
                ai1[k2] = j3 + 1;
                k2 = (k2 + 1) % k3;
                ygb[i3 + 1][j3 + 1] = 12;
            }
        }
        if(!flag1)
            return -1;
        l2 = 0;
        ai[l2] = i3;
        ai1[l2++] = j3;
        int i4;
        for(int l3 = i4 = ygb[i3][j3]; i3 != k || j3 != l; l3 = ygb[i3][j3])
        {
            if(l3 != i4)
            {
                i4 = l3;
                ai[l2] = i3;
                ai1[l2++] = j3;
            }
            if((l3 & 2) != 0)
                i3++;
            else
            if((l3 & 8) != 0)
                i3--;
            if((l3 & 1) != 0)
                j3++;
            else
            if((l3 & 4) != 0)
                j3--;
        }

        return l2;
    }

    public void hp(int k, int l, int i1)
    {
        zgb[k][l] |= i1;
    }

    public void ap(int k, int l, int i1)
    {
        zgb[k][l] &= 65535 - i1;
    }

    public void ip(int k, int l, int i1, int j1)
    {
        if(k < 0 || l < 0 || k >= ugb - 1 || l >= vgb - 1)
            return;
        if(r.ykb[j1] == 1)
        {
            if(i1 == 0)
            {
                zgb[k][l] |= 1;
                if(l > 0)
                    hp(k, l - 1, 4);
            } else
            if(i1 == 1)
            {
                zgb[k][l] |= 2;
                if(k > 0)
                    hp(k - 1, l, 8);
            } else
            if(i1 == 2)
                zgb[k][l] |= 0x10;
            else
            if(i1 == 3)
                zgb[k][l] |= 0x20;
            oo(k, l, 1, 1);
        }
    }

    public void go(int k, int l, int i1, int j1)
    {
        if(k < 0 || l < 0 || k >= ugb - 1 || l >= vgb - 1)
            return;
        if(r.ykb[j1] == 1)
        {
            if(i1 == 0)
            {
                zgb[k][l] &= 0xfffe;
                if(l > 0)
                    ap(k, l - 1, 4);
            } else
            if(i1 == 1)
            {
                zgb[k][l] &= 0xfffd;
                if(k > 0)
                    ap(k - 1, l, 8);
            } else
            if(i1 == 2)
                zgb[k][l] &= 0xffef;
            else
            if(i1 == 3)
                zgb[k][l] &= 0xffdf;
            oo(k, l, 1, 1);
        }
    }

    public void wo(int k, int l, int i1)
    {
        if(k < 0 || l < 0 || k >= ugb - 1 || l >= vgb - 1)
            return;
        if(r.nkb[i1] == 1 || r.nkb[i1] == 2)
        {
            int j1 = jo(k, l);
            int k1;
            int l1;
            if(j1 == 0 || j1 == 4)
            {
                k1 = r.lkb[i1];
                l1 = r.mkb[i1];
            } else
            {
                l1 = r.lkb[i1];
                k1 = r.mkb[i1];
            }
            for(int i2 = k; i2 < k + k1; i2++)
            {
                for(int j2 = l; j2 < l + l1; j2++)
                    if(r.nkb[i1] == 1)
                        zgb[i2][j2] |= 0x40;
                    else
                    if(j1 == 0)
                    {
                        zgb[i2][j2] |= 2;
                        if(i2 > 0)
                            hp(i2 - 1, j2, 8);
                    } else
                    if(j1 == 2)
                    {
                        zgb[i2][j2] |= 4;
                        if(j2 < vgb - 1)
                            hp(i2, j2 + 1, 1);
                    } else
                    if(j1 == 4)
                    {
                        zgb[i2][j2] |= 8;
                        if(i2 < ugb - 1)
                            hp(i2 + 1, j2, 2);
                    } else
                    if(j1 == 6)
                    {
                        zgb[i2][j2] |= 1;
                        if(j2 > 0)
                            hp(i2, j2 - 1, 4);
                    }

            }

            oo(k, l, k1, l1);
        }
    }

    public void gp(int k, int l, int i1)
    {
        if(k < 0 || l < 0 || k >= ugb - 1 || l >= vgb - 1)
            return;
        if(r.nkb[i1] == 1 || r.nkb[i1] == 2)
        {
            int j1 = jo(k, l);
            int k1;
            int l1;
            if(j1 == 0 || j1 == 4)
            {
                k1 = r.lkb[i1];
                l1 = r.mkb[i1];
            } else
            {
                l1 = r.lkb[i1];
                k1 = r.mkb[i1];
            }
            for(int i2 = k; i2 < k + k1; i2++)
            {
                for(int j2 = l; j2 < l + l1; j2++)
                    if(r.nkb[i1] == 1)
                        zgb[i2][j2] &= 0xffbf;
                    else
                    if(j1 == 0)
                    {
                        zgb[i2][j2] &= 0xfffd;
                        if(i2 > 0)
                            ap(i2 - 1, j2, 8);
                    } else
                    if(j1 == 2)
                    {
                        zgb[i2][j2] &= 0xfffb;
                        if(j2 < vgb - 1)
                            ap(i2, j2 + 1, 1);
                    } else
                    if(j1 == 4)
                    {
                        zgb[i2][j2] &= 0xfff7;
                        if(i2 < ugb - 1)
                            ap(i2 + 1, j2, 2);
                    } else
                    if(j1 == 6)
                    {
                        zgb[i2][j2] &= 0xfffe;
                        if(j2 > 0)
                            ap(i2, j2 - 1, 4);
                    }

            }

            oo(k, l, k1, l1);
        }
    }

    public void oo(int k, int l, int i1, int j1)
    {
        if(k < 1 || l < 1 || k + i1 >= ugb || l + j1 >= vgb)
            return;
        for(int k1 = k; k1 <= k + i1; k1++)
        {
            for(int l1 = l; l1 <= l + j1; l1++)
                if((mp(k1, l1) & 0x63) != 0 || (mp(k1 - 1, l1) & 0x59) != 0 || (mp(k1, l1 - 1) & 0x56) != 0 || (mp(k1 - 1, l1 - 1) & 0x6c) != 0)
                    uo(k1, l1, 35);
                else
                    uo(k1, l1, 0);

        }

    }

    public void uo(int k, int l, int i1)
    {
        int j1 = k / 12;
        int k1 = l / 12;
        int l1 = (k - 1) / 12;
        int i2 = (l - 1) / 12;
        jp(j1, k1, k, l, i1);
        if(j1 != l1)
            jp(l1, k1, k, l, i1);
        if(k1 != i2)
            jp(j1, i2, k, l, i1);
        if(j1 != l1 && k1 != i2)
            jp(l1, i2, k, l, i1);
    }

    public void jp(int k, int l, int i1, int j1, int k1)
    {
        h h1 = chb[k + l * 8];
        for(int l1 = 0; l1 < h1.ng; l1++)
            if(h1.ii[l1] == i1 * 128 && h1.ki[l1] == j1 * 128)
            {
                h1.ee(l1, k1);
                return;
            }

    }

    public int mp(int k, int l)
    {
        if(k < 0 || l < 0 || k >= ugb || l >= vgb)
            return 0;
        else
            return zgb[k][l];
    }

    public int po(int k, int l)
    {
        int i1 = k >> 7;
        int j1 = l >> 7;
        int k1 = k & 0x7f;
        int l1 = l & 0x7f;
        if(i1 < 0 || j1 < 0 || i1 >= ugb - 1 || j1 >= vgb - 1)
            return 0;
        int i2;
        int j2;
        int k2;
        if(k1 <= 128 - l1)
        {
            i2 = vo(i1, j1);
            j2 = vo(i1 + 1, j1) - i2;
            k2 = vo(i1, j1 + 1) - i2;
        } else
        {
            i2 = vo(i1 + 1, j1 + 1);
            j2 = vo(i1, j1 + 1) - i2;
            k2 = vo(i1 + 1, j1) - i2;
            k1 = 128 - k1;
            l1 = 128 - l1;
        }
        int l2 = i2 + (j2 * k1) / 128 + (k2 * l1) / 128;
        return l2;
    }

    public int vo(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return (mgb[byte0][k * 48 + l] & 0xff) * 3;
    }

    public int ho(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return ngb[byte0][k * 48 + l] & 0xff;
    }

    public int xo(int k, int l, int i1)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return rgb[byte0][k * 48 + l] & 0xff;
    }

    public void to(int k, int l, int i1)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        rgb[byte0][k * 48 + l] = (byte)i1;
    }

    public int dp(int k, int l, int i1)
    {
        int j1 = xo(k, l, i1);
        if(j1 == 0)
            return -1;
        int k1 = r.jlb[j1 - 1];
        return k1 != 2 ? 0 : 1;
    }

    public int no(int k, int l, int i1, int j1)
    {
        int k1 = xo(k, l, i1);
        if(k1 == 0)
            return j1;
        else
            return r.ilb[k1 - 1];
    }

    public int mo(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return tgb[byte0][k * 48 + l];
    }

    public int cp(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return qgb[byte0][k * 48 + l];
    }

    public int jo(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return sgb[byte0][k * 48 + l];
    }

    public boolean fp(int k, int l)
    {
        return cp(k, l) > 0 || cp(k - 1, l) > 0 || cp(k - 1, l - 1) > 0 || cp(k, l - 1) > 0;
    }

    public boolean ep(int k, int l)
    {
        return cp(k, l) > 0 && cp(k - 1, l) > 0 && cp(k - 1, l - 1) > 0 && cp(k, l - 1) > 0;
    }

    public int qo(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return pgb[byte0][k * 48 + l] & 0xff;
    }

    public int zo(int k, int l)
    {
        if(k < 0 || k >= 96 || l < 0 || l >= 96)
            return 0;
        byte byte0 = 0;
        if(k >= 48 && l < 48)
        {
            byte0 = 1;
            k -= 48;
        } else
        if(k < 48 && l >= 48)
        {
            byte0 = 2;
            l -= 48;
        } else
        if(k >= 48 && l >= 48)
        {
            byte0 = 3;
            k -= 48;
            l -= 48;
        }
        return ogb[byte0][k * 48 + l] & 0xff;
    }

    public void fo(int k, int l, int i1, int j1)
    {
        String s = "m" + i1 + k / 10 + k % 10 + l / 10 + l % 10;
        int k1;
        try
        {
            byte abyte0[];
            if(zfb)
            {
                abyte0 = o.ln(s + ".jm", 0, lgb);
                if(abyte0 == null || abyte0.length == 0)
                    throw new IOException("Map not defined");
            } else
            {
                abyte0 = new byte[20736];
                o.in("../gamedata/maps/" + s + ".jm", abyte0, 20736);
            }
            int l1 = 0;
            int i2 = 0;
            for(int j2 = 0; j2 < 2304; j2++)
            {
                l1 = l1 + abyte0[i2++] & 0xff;
                mgb[j1][j2] = (byte)l1;
            }

            l1 = 0;
            for(int k2 = 0; k2 < 2304; k2++)
            {
                l1 = l1 + abyte0[i2++] & 0xff;
                ngb[j1][k2] = (byte)l1;
            }

            for(int l2 = 0; l2 < 2304; l2++)
                ogb[j1][l2] = abyte0[i2++];

            for(int i3 = 0; i3 < 2304; i3++)
                pgb[j1][i3] = abyte0[i2++];

            for(int j3 = 0; j3 < 2304; j3++)
            {
                tgb[j1][j3] = (abyte0[i2] & 0xff) * 256 + (abyte0[i2 + 1] & 0xff);
                i2 += 2;
            }

            for(int k3 = 0; k3 < 2304; k3++)
                qgb[j1][k3] = abyte0[i2++];

            for(int l3 = 0; l3 < 2304; l3++)
                rgb[j1][l3] = abyte0[i2++];

            for(int i4 = 0; i4 < 2304; i4++)
                sgb[j1][i4] = abyte0[i2++];

            return;
        }
        catch(IOException _ex)
        {
            k1 = 0;
        }
        for(; k1 < 2304; k1++)
        {
            mgb[j1][k1] = 0;
            ngb[j1][k1] = 0;
            ogb[j1][k1] = 0;
            pgb[j1][k1] = 0;
            tgb[j1][k1] = 0;
            qgb[j1][k1] = 0;
            rgb[j1][k1] = 0;
            if(i1 == 0)
                rgb[j1][k1] = -6;
            if(i1 == 3)
                rgb[j1][k1] = 8;
            sgb[j1][k1] = 0;
        }

    }

    public void lp()
    {
        cgb.zi();
        for(int k = 0; k < 64; k++)
        {
            chb[k] = null;
            for(int l = 0; l < 4; l++)
                dhb[l][k] = null;

            for(int i1 = 0; i1 < 4; i1++)
                ehb[i1][k] = null;

        }

        System.gc();
    }

    public void yo(int k, int l, int i1)
    {
        lp();
        int j1 = (k + 24) / 48;
        int k1 = (l + 24) / 48;
        lo(k, l, i1, true);
        if(i1 == 0)
        {
            lo(k, l, 1, false);
            lo(k, l, 2, false);
            fo(j1 - 1, k1 - 1, i1, 0);
            fo(j1, k1 - 1, i1, 1);
            fo(j1 - 1, k1, i1, 2);
            fo(j1, k1, i1, 3);
            so();
        }
    }

    public void so()
    {
        for(int k = 0; k < 96; k++)
        {
            for(int l = 0; l < 96; l++)
                if(xo(k, l, 0) == 250)
                    if(k == 47 && xo(k + 1, l, 0) != 250 && xo(k + 1, l, 0) != 2)
                        to(k, l, 9);
                    else
                    if(l == 47 && xo(k, l + 1, 0) != 250 && xo(k, l + 1, 0) != 2)
                        to(k, l, 9);
                    else
                        to(k, l, 2);

        }

    }

    public void ko(int k, int l, int i1, int j1, int k1)
    {
        int l1 = k * 3;
        int i2 = l * 3;
        int j2 = cgb.aj(j1);
        int k2 = cgb.aj(k1);
        j2 = j2 >> 1 & 0x7f7f7f;
        k2 = k2 >> 1 & 0x7f7f7f;
        if(i1 == 0)
        {
            bgb.xg(l1, i2, 3, j2);
            bgb.xg(l1, i2 + 1, 2, j2);
            bgb.xg(l1, i2 + 2, 1, j2);
            bgb.xg(l1 + 2, i2 + 1, 1, k2);
            bgb.xg(l1 + 1, i2 + 2, 2, k2);
            return;
        }
        if(i1 == 1)
        {
            bgb.xg(l1, i2, 3, k2);
            bgb.xg(l1 + 1, i2 + 1, 2, k2);
            bgb.xg(l1 + 2, i2 + 2, 1, k2);
            bgb.xg(l1, i2 + 1, 1, j2);
            bgb.xg(l1, i2 + 2, 2, j2);
        }
    }

    public void lo(int k, int l, int i1, boolean flag)
    {
        int j1 = (k + 24) / 48;
        int k1 = (l + 24) / 48;
        fo(j1 - 1, k1 - 1, i1, 0);
        fo(j1, k1 - 1, i1, 1);
        fo(j1 - 1, k1, i1, 2);
        fo(j1, k1, i1, 3);
        so();
        if(fhb == null)
            fhb = new h(ugb * vgb * 2 + 256, ugb * vgb * 2 + 256, true, true, false, false, true);
        if(flag)
        {
            bgb.sf();
            for(int l1 = 0; l1 < 96; l1++)
            {
                for(int j2 = 0; j2 < 96; j2++)
                    zgb[l1][j2] = 0;

            }

            h h1 = fhb;
            h1.ef();
            for(int l2 = 0; l2 < 96; l2++)
            {
                for(int k3 = 0; k3 < 96; k3++)
                {
                    int k4 = -vo(l2, k3);
                    if(xo(l2, k3, i1) > 0 && r.jlb[xo(l2, k3, i1) - 1] == 4)
                        k4 = 0;
                    if(xo(l2 - 1, k3, i1) > 0 && r.jlb[xo(l2 - 1, k3, i1) - 1] == 4)
                        k4 = 0;
                    if(xo(l2, k3 - 1, i1) > 0 && r.jlb[xo(l2, k3 - 1, i1) - 1] == 4)
                        k4 = 0;
                    if(xo(l2 - 1, k3 - 1, i1) > 0 && r.jlb[xo(l2 - 1, k3 - 1, i1) - 1] == 4)
                        k4 = 0;
                    int l5 = h1.ve(l2 * 128, k4, k3 * 128);
                    int l7 = (int)(Math.random() * 10D) - 5;
                    h1.ee(l5, l7);
                }

            }

            for(int l3 = 0; l3 < 95; l3++)
            {
                for(int l4 = 0; l4 < 95; l4++)
                {
                    int i6 = ho(l3, l4);
                    int i8 = ggb[i6];
                    int k10 = i8;
                    int i13 = i8;
                    int j15 = 0;
                    if(i1 == 1 || i1 == 2)
                    {
                        i8 = 0xbc614e;
                        k10 = 0xbc614e;
                        i13 = 0xbc614e;
                    }
                    if(xo(l3, l4, i1) > 0)
                    {
                        int j17 = xo(l3, l4, i1);
                        int j6 = r.jlb[j17 - 1];
                        int k19 = dp(l3, l4, i1);
                        i8 = k10 = r.ilb[j17 - 1];
                        if(j6 == 4)
                        {
                            i8 = 1;
                            k10 = 1;
                        }
                        if(j6 == 5)
                        {
                            if(mo(l3, l4) > 0 && mo(l3, l4) < 24000)
                                if(no(l3 - 1, l4, i1, i13) != 0xbc614e && no(l3, l4 - 1, i1, i13) != 0xbc614e)
                                {
                                    i8 = no(l3 - 1, l4, i1, i13);
                                    j15 = 0;
                                } else
                                if(no(l3 + 1, l4, i1, i13) != 0xbc614e && no(l3, l4 + 1, i1, i13) != 0xbc614e)
                                {
                                    k10 = no(l3 + 1, l4, i1, i13);
                                    j15 = 0;
                                } else
                                if(no(l3 + 1, l4, i1, i13) != 0xbc614e && no(l3, l4 - 1, i1, i13) != 0xbc614e)
                                {
                                    k10 = no(l3 + 1, l4, i1, i13);
                                    j15 = 1;
                                } else
                                if(no(l3 - 1, l4, i1, i13) != 0xbc614e && no(l3, l4 + 1, i1, i13) != 0xbc614e)
                                {
                                    i8 = no(l3 - 1, l4, i1, i13);
                                    j15 = 1;
                                }
                        } else
                        if(j6 != 2 || mo(l3, l4) > 0 && mo(l3, l4) < 24000)
                            if(dp(l3 - 1, l4, i1) != k19 && dp(l3, l4 - 1, i1) != k19)
                            {
                                i8 = i13;
                                j15 = 0;
                            } else
                            if(dp(l3 + 1, l4, i1) != k19 && dp(l3, l4 + 1, i1) != k19)
                            {
                                k10 = i13;
                                j15 = 0;
                            } else
                            if(dp(l3 + 1, l4, i1) != k19 && dp(l3, l4 - 1, i1) != k19)
                            {
                                k10 = i13;
                                j15 = 1;
                            } else
                            if(dp(l3 - 1, l4, i1) != k19 && dp(l3, l4 + 1, i1) != k19)
                            {
                                i8 = i13;
                                j15 = 1;
                            }
                        if(r.klb[j17 - 1] != 0)
                            zgb[l3][l4] |= 0x40;
                        if(r.jlb[j17 - 1] == 2)
                            zgb[l3][l4] |= 0x80;
                    }
                    ko(l3, l4, j15, i8, k10);
                    int k17 = ((vo(l3 + 1, l4 + 1) - vo(l3 + 1, l4)) + vo(l3, l4 + 1)) - vo(l3, l4);
                    if(i8 != k10 || k17 != 0)
                    {
                        int ai[] = new int[3];
                        int ai7[] = new int[3];
                        if(j15 == 0)
                        {
                            if(i8 != 0xbc614e)
                            {
                                ai[0] = l4 + l3 * ugb + ugb;
                                ai[1] = l4 + l3 * ugb;
                                ai[2] = l4 + l3 * ugb + 1;
                                int j22 = h1.ue(3, ai, 0xbc614e, i8);
                                wgb[j22] = l3;
                                xgb[j22] = l4;
                                h1.uh[j22] = 0x30d40 + j22;
                            }
                            if(k10 != 0xbc614e)
                            {
                                ai7[0] = l4 + l3 * ugb + 1;
                                ai7[1] = l4 + l3 * ugb + ugb + 1;
                                ai7[2] = l4 + l3 * ugb + ugb;
                                int k22 = h1.ue(3, ai7, 0xbc614e, k10);
                                wgb[k22] = l3;
                                xgb[k22] = l4;
                                h1.uh[k22] = 0x30d40 + k22;
                            }
                        } else
                        {
                            if(i8 != 0xbc614e)
                            {
                                ai[0] = l4 + l3 * ugb + 1;
                                ai[1] = l4 + l3 * ugb + ugb + 1;
                                ai[2] = l4 + l3 * ugb;
                                int l22 = h1.ue(3, ai, 0xbc614e, i8);
                                wgb[l22] = l3;
                                xgb[l22] = l4;
                                h1.uh[l22] = 0x30d40 + l22;
                            }
                            if(k10 != 0xbc614e)
                            {
                                ai7[0] = l4 + l3 * ugb + ugb;
                                ai7[1] = l4 + l3 * ugb;
                                ai7[2] = l4 + l3 * ugb + ugb + 1;
                                int i23 = h1.ue(3, ai7, 0xbc614e, k10);
                                wgb[i23] = l3;
                                xgb[i23] = l4;
                                h1.uh[i23] = 0x30d40 + i23;
                            }
                        }
                    } else
                    if(i8 != 0xbc614e)
                    {
                        int ai1[] = new int[4];
                        ai1[0] = l4 + l3 * ugb + ugb;
                        ai1[1] = l4 + l3 * ugb;
                        ai1[2] = l4 + l3 * ugb + 1;
                        ai1[3] = l4 + l3 * ugb + ugb + 1;
                        int j20 = h1.ue(4, ai1, 0xbc614e, i8);
                        wgb[j20] = l3;
                        xgb[j20] = l4;
                        h1.uh[j20] = 0x30d40 + j20;
                    }
                }

            }

            for(int i5 = 1; i5 < 95; i5++)
            {
                for(int k6 = 1; k6 < 95; k6++)
                    if(xo(i5, k6, i1) > 0 && r.jlb[xo(i5, k6, i1) - 1] == 4)
                    {
                        int j8 = r.ilb[xo(i5, k6, i1) - 1];
                        int l10 = h1.ve(i5 * 128, -vo(i5, k6), k6 * 128);
                        int j13 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6), k6 * 128);
                        int k15 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6 + 1), (k6 + 1) * 128);
                        int l17 = h1.ve(i5 * 128, -vo(i5, k6 + 1), (k6 + 1) * 128);
                        int ai2[] = {
                            l10, j13, k15, l17
                        };
                        int k20 = h1.ue(4, ai2, j8, 0xbc614e);
                        wgb[k20] = i5;
                        xgb[k20] = k6;
                        h1.uh[k20] = 0x30d40 + k20;
                        ko(i5, k6, 0, j8, j8);
                    } else
                    if(xo(i5, k6, i1) == 0 || r.jlb[xo(i5, k6, i1) - 1] != 3)
                    {
                        if(xo(i5, k6 + 1, i1) > 0 && r.jlb[xo(i5, k6 + 1, i1) - 1] == 4)
                        {
                            int k8 = r.ilb[xo(i5, k6 + 1, i1) - 1];
                            int i11 = h1.ve(i5 * 128, -vo(i5, k6), k6 * 128);
                            int k13 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6), k6 * 128);
                            int l15 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6 + 1), (k6 + 1) * 128);
                            int i18 = h1.ve(i5 * 128, -vo(i5, k6 + 1), (k6 + 1) * 128);
                            int ai3[] = {
                                i11, k13, l15, i18
                            };
                            int l20 = h1.ue(4, ai3, k8, 0xbc614e);
                            wgb[l20] = i5;
                            xgb[l20] = k6;
                            h1.uh[l20] = 0x30d40 + l20;
                            ko(i5, k6, 0, k8, k8);
                        }
                        if(xo(i5, k6 - 1, i1) > 0 && r.jlb[xo(i5, k6 - 1, i1) - 1] == 4)
                        {
                            int l8 = r.ilb[xo(i5, k6 - 1, i1) - 1];
                            int j11 = h1.ve(i5 * 128, -vo(i5, k6), k6 * 128);
                            int l13 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6), k6 * 128);
                            int i16 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6 + 1), (k6 + 1) * 128);
                            int j18 = h1.ve(i5 * 128, -vo(i5, k6 + 1), (k6 + 1) * 128);
                            int ai4[] = {
                                j11, l13, i16, j18
                            };
                            int i21 = h1.ue(4, ai4, l8, 0xbc614e);
                            wgb[i21] = i5;
                            xgb[i21] = k6;
                            h1.uh[i21] = 0x30d40 + i21;
                            ko(i5, k6, 0, l8, l8);
                        }
                        if(xo(i5 + 1, k6, i1) > 0 && r.jlb[xo(i5 + 1, k6, i1) - 1] == 4)
                        {
                            int i9 = r.ilb[xo(i5 + 1, k6, i1) - 1];
                            int k11 = h1.ve(i5 * 128, -vo(i5, k6), k6 * 128);
                            int i14 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6), k6 * 128);
                            int j16 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6 + 1), (k6 + 1) * 128);
                            int k18 = h1.ve(i5 * 128, -vo(i5, k6 + 1), (k6 + 1) * 128);
                            int ai5[] = {
                                k11, i14, j16, k18
                            };
                            int j21 = h1.ue(4, ai5, i9, 0xbc614e);
                            wgb[j21] = i5;
                            xgb[j21] = k6;
                            h1.uh[j21] = 0x30d40 + j21;
                            ko(i5, k6, 0, i9, i9);
                        }
                        if(xo(i5 - 1, k6, i1) > 0 && r.jlb[xo(i5 - 1, k6, i1) - 1] == 4)
                        {
                            int j9 = r.ilb[xo(i5 - 1, k6, i1) - 1];
                            int l11 = h1.ve(i5 * 128, -vo(i5, k6), k6 * 128);
                            int j14 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6), k6 * 128);
                            int k16 = h1.ve((i5 + 1) * 128, -vo(i5 + 1, k6 + 1), (k6 + 1) * 128);
                            int l18 = h1.ve(i5 * 128, -vo(i5, k6 + 1), (k6 + 1) * 128);
                            int ai6[] = {
                                l11, j14, k16, l18
                            };
                            int k21 = h1.ue(4, ai6, j9, 0xbc614e);
                            wgb[k21] = i5;
                            xgb[k21] = k6;
                            h1.uh[k21] = 0x30d40 + k21;
                            ko(i5, k6, 0, j9, j9);
                        }
                    }

            }

            h1.ze(true, 40, 48, -50, -10, -50);
            chb = fhb.be(0, 0, 1536, 1536, 8, 64, 233, false);
            for(int l6 = 0; l6 < 64; l6++)
                cgb.bi(chb[l6]);

            for(int k9 = 0; k9 < 96; k9++)
            {
                for(int i12 = 0; i12 < 96; i12++)
                    ahb[k9][i12] = vo(k9, i12);

            }

        }
        fhb.ef();
        int i2 = 0x606060;
        for(int k2 = 0; k2 < 95; k2++)
        {
            for(int i3 = 0; i3 < 95; i3++)
            {
                int i4 = qo(k2, i3);
                if(i4 > 0 && (r.alb[i4 - 1] == 0 || agb))
                {
                    kp(fhb, i4 - 1, k2, i3, k2 + 1, i3);
                    if(flag && r.ykb[i4 - 1] != 0)
                    {
                        zgb[k2][i3] |= 1;
                        if(i3 > 0)
                            hp(k2, i3 - 1, 4);
                    }
                    if(flag)
                        bgb.xg(k2 * 3, i3 * 3, 3, i2);
                }
                i4 = zo(k2, i3);
                if(i4 > 0 && (r.alb[i4 - 1] == 0 || agb))
                {
                    kp(fhb, i4 - 1, k2, i3, k2, i3 + 1);
                    if(flag && r.ykb[i4 - 1] != 0)
                    {
                        zgb[k2][i3] |= 2;
                        if(k2 > 0)
                            hp(k2 - 1, i3, 8);
                    }
                    if(flag)
                        bgb.ch(k2 * 3, i3 * 3, 3, i2);
                }
                i4 = mo(k2, i3);
                if(i4 > 0 && i4 < 12000 && (r.alb[i4 - 1] == 0 || agb))
                {
                    kp(fhb, i4 - 1, k2, i3, k2 + 1, i3 + 1);
                    if(flag && r.ykb[i4 - 1] != 0)
                        zgb[k2][i3] |= 0x20;
                    if(flag)
                    {
                        bgb.rg(k2 * 3, i3 * 3, i2);
                        bgb.rg(k2 * 3 + 1, i3 * 3 + 1, i2);
                        bgb.rg(k2 * 3 + 2, i3 * 3 + 2, i2);
                    }
                }
                if(i4 > 12000 && i4 < 24000 && (r.alb[i4 - 12001] == 0 || agb))
                {
                    kp(fhb, i4 - 12001, k2 + 1, i3, k2, i3 + 1);
                    if(flag && r.ykb[i4 - 12001] != 0)
                        zgb[k2][i3] |= 0x10;
                    if(flag)
                    {
                        bgb.rg(k2 * 3 + 2, i3 * 3, i2);
                        bgb.rg(k2 * 3 + 1, i3 * 3 + 1, i2);
                        bgb.rg(k2 * 3, i3 * 3 + 2, i2);
                    }
                }
            }

        }

        if(flag)
            bgb.rf(dgb - 1, 0, 0, 285, 285);
        fhb.ze(false, 60, 24, -50, -10, -50);
        dhb[i1] = fhb.be(0, 0, 1536, 1536, 8, 64, 338, true);
        for(int j3 = 0; j3 < 64; j3++)
            cgb.bi(dhb[i1][j3]);

        for(int j4 = 0; j4 < 95; j4++)
        {
            for(int j5 = 0; j5 < 95; j5++)
            {
                int i7 = qo(j4, j5);
                if(i7 > 0)
                    bp(i7 - 1, j4, j5, j4 + 1, j5);
                i7 = zo(j4, j5);
                if(i7 > 0)
                    bp(i7 - 1, j4, j5, j4, j5 + 1);
                i7 = mo(j4, j5);
                if(i7 > 0 && i7 < 12000)
                    bp(i7 - 1, j4, j5, j4 + 1, j5 + 1);
                if(i7 > 12000 && i7 < 24000)
                    bp(i7 - 12001, j4 + 1, j5, j4, j5 + 1);
            }

        }

        for(int k5 = 1; k5 < 95; k5++)
        {
            for(int j7 = 1; j7 < 95; j7++)
            {
                int l9 = cp(k5, j7);
                if(l9 > 0)
                {
                    int j12 = k5;
                    int k14 = j7;
                    int l16 = k5 + 1;
                    int i19 = j7;
                    int l19 = k5 + 1;
                    int l21 = j7 + 1;
                    int j23 = k5;
                    int l23 = j7 + 1;
                    int j24 = 0;
                    int l24 = ahb[j12][k14];
                    int j25 = ahb[l16][i19];
                    int l25 = ahb[l19][l21];
                    int j26 = ahb[j23][l23];
                    if(l24 > 0x13880)
                        l24 -= 0x13880;
                    if(j25 > 0x13880)
                        j25 -= 0x13880;
                    if(l25 > 0x13880)
                        l25 -= 0x13880;
                    if(j26 > 0x13880)
                        j26 -= 0x13880;
                    if(l24 > j24)
                        j24 = l24;
                    if(j25 > j24)
                        j24 = j25;
                    if(l25 > j24)
                        j24 = l25;
                    if(j26 > j24)
                        j24 = j26;
                    if(j24 >= 0x13880)
                        j24 -= 0x13880;
                    if(l24 < 0x13880)
                        ahb[j12][k14] = j24;
                    else
                        ahb[j12][k14] -= 0x13880;
                    if(j25 < 0x13880)
                        ahb[l16][i19] = j24;
                    else
                        ahb[l16][i19] -= 0x13880;
                    if(l25 < 0x13880)
                        ahb[l19][l21] = j24;
                    else
                        ahb[l19][l21] -= 0x13880;
                    if(j26 < 0x13880)
                        ahb[j23][l23] = j24;
                    else
                        ahb[j23][l23] -= 0x13880;
                }
            }

        }

        fhb.ef();
        for(int k7 = 1; k7 < 95; k7++)
        {
            for(int i10 = 1; i10 < 95; i10++)
            {
                int k12 = cp(k7, i10);
                if(k12 > 0)
                {
                    int l14 = k7;
                    int i17 = i10;
                    int j19 = k7 + 1;
                    int i20 = i10;
                    int i22 = k7 + 1;
                    int k23 = i10 + 1;
                    int i24 = k7;
                    int k24 = i10 + 1;
                    int i25 = k7 * 128;
                    int k25 = i10 * 128;
                    int i26 = i25 + 128;
                    int k26 = k25 + 128;
                    int l26 = i25;
                    int i27 = k25;
                    int j27 = i26;
                    int k27 = k26;
                    int l27 = ahb[l14][i17];
                    int i28 = ahb[j19][i20];
                    int j28 = ahb[i22][k23];
                    int k28 = ahb[i24][k24];
                    int l28 = r.dlb[k12 - 1];
                    if(ep(l14, i17) && l27 < 0x13880)
                    {
                        l27 += l28 + 0x13880;
                        ahb[l14][i17] = l27;
                    }
                    if(ep(j19, i20) && i28 < 0x13880)
                    {
                        i28 += l28 + 0x13880;
                        ahb[j19][i20] = i28;
                    }
                    if(ep(i22, k23) && j28 < 0x13880)
                    {
                        j28 += l28 + 0x13880;
                        ahb[i22][k23] = j28;
                    }
                    if(ep(i24, k24) && k28 < 0x13880)
                    {
                        k28 += l28 + 0x13880;
                        ahb[i24][k24] = k28;
                    }
                    if(l27 >= 0x13880)
                        l27 -= 0x13880;
                    if(i28 >= 0x13880)
                        i28 -= 0x13880;
                    if(j28 >= 0x13880)
                        j28 -= 0x13880;
                    if(k28 >= 0x13880)
                        k28 -= 0x13880;
                    byte byte0 = 16;
                    if(!fp(l14 - 1, i17))
                        i25 -= byte0;
                    if(!fp(l14 + 1, i17))
                        i25 += byte0;
                    if(!fp(l14, i17 - 1))
                        k25 -= byte0;
                    if(!fp(l14, i17 + 1))
                        k25 += byte0;
                    if(!fp(j19 - 1, i20))
                        i26 -= byte0;
                    if(!fp(j19 + 1, i20))
                        i26 += byte0;
                    if(!fp(j19, i20 - 1))
                        i27 -= byte0;
                    if(!fp(j19, i20 + 1))
                        i27 += byte0;
                    if(!fp(i22 - 1, k23))
                        j27 -= byte0;
                    if(!fp(i22 + 1, k23))
                        j27 += byte0;
                    if(!fp(i22, k23 - 1))
                        k26 -= byte0;
                    if(!fp(i22, k23 + 1))
                        k26 += byte0;
                    if(!fp(i24 - 1, k24))
                        l26 -= byte0;
                    if(!fp(i24 + 1, k24))
                        l26 += byte0;
                    if(!fp(i24, k24 - 1))
                        k27 -= byte0;
                    if(!fp(i24, k24 + 1))
                        k27 += byte0;
                    k12 = r.flb[k12 - 1];
                    l27 = -l27;
                    i28 = -i28;
                    j28 = -j28;
                    k28 = -k28;
                    if(mo(k7, i10) > 12000 && mo(k7, i10) < 24000 && cp(k7 - 1, i10 - 1) == 0)
                    {
                        int ai8[] = new int[3];
                        ai8[0] = fhb.ve(j27, j28, k26);
                        ai8[1] = fhb.ve(l26, k28, k27);
                        ai8[2] = fhb.ve(i26, i28, i27);
                        fhb.ue(3, ai8, k12, 0xbc614e);
                    } else
                    if(mo(k7, i10) > 12000 && mo(k7, i10) < 24000 && cp(k7 + 1, i10 + 1) == 0)
                    {
                        int ai9[] = new int[3];
                        ai9[0] = fhb.ve(i25, l27, k25);
                        ai9[1] = fhb.ve(i26, i28, i27);
                        ai9[2] = fhb.ve(l26, k28, k27);
                        fhb.ue(3, ai9, k12, 0xbc614e);
                    } else
                    if(mo(k7, i10) > 0 && mo(k7, i10) < 12000 && cp(k7 + 1, i10 - 1) == 0)
                    {
                        int ai10[] = new int[3];
                        ai10[0] = fhb.ve(l26, k28, k27);
                        ai10[1] = fhb.ve(i25, l27, k25);
                        ai10[2] = fhb.ve(j27, j28, k26);
                        fhb.ue(3, ai10, k12, 0xbc614e);
                    } else
                    if(mo(k7, i10) > 0 && mo(k7, i10) < 12000 && cp(k7 - 1, i10 + 1) == 0)
                    {
                        int ai11[] = new int[3];
                        ai11[0] = fhb.ve(i26, i28, i27);
                        ai11[1] = fhb.ve(j27, j28, k26);
                        ai11[2] = fhb.ve(i25, l27, k25);
                        fhb.ue(3, ai11, k12, 0xbc614e);
                    } else
                    if(l27 == i28 && j28 == k28)
                    {
                        int ai12[] = new int[4];
                        ai12[0] = fhb.ve(i25, l27, k25);
                        ai12[1] = fhb.ve(i26, i28, i27);
                        ai12[2] = fhb.ve(j27, j28, k26);
                        ai12[3] = fhb.ve(l26, k28, k27);
                        fhb.ue(4, ai12, k12, 0xbc614e);
                    } else
                    if(l27 == k28 && i28 == j28)
                    {
                        int ai13[] = new int[4];
                        ai13[0] = fhb.ve(l26, k28, k27);
                        ai13[1] = fhb.ve(i25, l27, k25);
                        ai13[2] = fhb.ve(i26, i28, i27);
                        ai13[3] = fhb.ve(j27, j28, k26);
                        fhb.ue(4, ai13, k12, 0xbc614e);
                    } else
                    {
                        boolean flag1 = true;
                        if(cp(k7 - 1, i10 - 1) > 0)
                            flag1 = false;
                        if(cp(k7 + 1, i10 + 1) > 0)
                            flag1 = false;
                        if(!flag1)
                        {
                            int ai14[] = new int[3];
                            ai14[0] = fhb.ve(i26, i28, i27);
                            ai14[1] = fhb.ve(j27, j28, k26);
                            ai14[2] = fhb.ve(i25, l27, k25);
                            fhb.ue(3, ai14, k12, 0xbc614e);
                            int ai16[] = new int[3];
                            ai16[0] = fhb.ve(l26, k28, k27);
                            ai16[1] = fhb.ve(i25, l27, k25);
                            ai16[2] = fhb.ve(j27, j28, k26);
                            fhb.ue(3, ai16, k12, 0xbc614e);
                        } else
                        {
                            int ai15[] = new int[3];
                            ai15[0] = fhb.ve(i25, l27, k25);
                            ai15[1] = fhb.ve(i26, i28, i27);
                            ai15[2] = fhb.ve(l26, k28, k27);
                            fhb.ue(3, ai15, k12, 0xbc614e);
                            int ai17[] = new int[3];
                            ai17[0] = fhb.ve(j27, j28, k26);
                            ai17[1] = fhb.ve(l26, k28, k27);
                            ai17[2] = fhb.ve(i26, i28, i27);
                            fhb.ue(3, ai17, k12, 0xbc614e);
                        }
                    }
                }
            }

        }

        fhb.ze(true, 50, 50, -50, -10, -50);
        ehb[i1] = fhb.be(0, 0, 1536, 1536, 8, 64, 169, true);
        for(int j10 = 0; j10 < 64; j10++)
            cgb.bi(ehb[i1][j10]);

        for(int l12 = 0; l12 < 96; l12++)
        {
            for(int i15 = 0; i15 < 96; i15++)
                if(ahb[l12][i15] >= 0x13880)
                    ahb[l12][i15] -= 0x13880;

        }

    }

    public void ro(h ah[])
    {
        for(int k = 0; k < ugb - 2; k++)
        {
            for(int l = 0; l < vgb - 2; l++)
                if(mo(k, l) > 48000 && mo(k, l) < 60000)
                {
                    int i1 = mo(k, l) - 48001;
                    int j1 = jo(k, l);
                    int k1;
                    int l1;
                    if(j1 == 0 || j1 == 4)
                    {
                        k1 = r.lkb[i1];
                        l1 = r.mkb[i1];
                    } else
                    {
                        l1 = r.lkb[i1];
                        k1 = r.mkb[i1];
                    }
                    wo(k, l, i1);
                    h h1 = ah[r.kkb[i1]].bf(false, true, false, false);
                    int i2 = ((k + k + k1) * 128) / 2;
                    int k2 = ((l + l + l1) * 128) / 2;
                    h1.ge(i2, -po(i2, k2), k2);
                    h1.re(0, jo(k, l) * 32, 0);
                    cgb.bi(h1);
                    h1.ie(48, 48, -50, -10, -50);
                    if(k1 > 1 || l1 > 1)
                    {
                        for(int i3 = k; i3 < k + k1; i3++)
                        {
                            for(int j3 = l; j3 < l + l1; j3++)
                                if((i3 > k || j3 > l) && mo(i3, j3) - 48001 == i1)
                                {
                                    int j2 = i3;
                                    int l2 = j3;
                                    byte byte0 = 0;
                                    if(j2 >= 48 && l2 < 48)
                                    {
                                        byte0 = 1;
                                        j2 -= 48;
                                    } else
                                    if(j2 < 48 && l2 >= 48)
                                    {
                                        byte0 = 2;
                                        l2 -= 48;
                                    } else
                                    if(j2 >= 48 && l2 >= 48)
                                    {
                                        byte0 = 3;
                                        j2 -= 48;
                                        l2 -= 48;
                                    }
                                    tgb[byte0][j2 * 48 + l2] = 0;
                                }

                        }

                    }
                }

        }

    }

    public void kp(h h1, int k, int l, int i1, int j1, int k1)
    {
        uo(l, i1, 40);
        uo(j1, k1, 40);
        int l1 = r.vkb[k];
        int i2 = r.wkb[k];
        int j2 = r.xkb[k];
        int k2 = l * 128;
        int l2 = i1 * 128;
        int i3 = j1 * 128;
        int j3 = k1 * 128;
        int k3 = h1.ve(k2, -ahb[l][i1], l2);
        int l3 = h1.ve(k2, -ahb[l][i1] - l1, l2);
        int i4 = h1.ve(i3, -ahb[j1][k1] - l1, j3);
        int j4 = h1.ve(i3, -ahb[j1][k1], j3);
        int ai[] = {
            k3, l3, i4, j4
        };
        int k4 = h1.ue(4, ai, i2, j2);
        if(r.alb[k] == 5)
        {
            h1.uh[k4] = 30000 + k;
            return;
        } else
        {
            h1.uh[k4] = 0;
            return;
        }
    }

    public void bp(int k, int l, int i1, int j1, int k1)
    {
        int l1 = r.vkb[k];
        if(ahb[l][i1] < 0x13880)
            ahb[l][i1] += 0x13880 + l1;
        if(ahb[j1][k1] < 0x13880)
            ahb[j1][k1] += 0x13880 + l1;
    }

    boolean zfb;
    boolean agb;
    i bgb;
    j cgb;
    int dgb;
    final int egb = 0xbc614e;
    final int fgb = 128;
    int ggb[];
    int hgb;
    int igb[];
    int jgb[];
    int kgb[];
    byte lgb[];
    byte mgb[][];
    byte ngb[][];
    byte ogb[][];
    byte pgb[][];
    byte qgb[][];
    byte rgb[][];
    byte sgb[][];
    int tgb[][];
    int ugb;
    int vgb;
    int wgb[];
    int xgb[];
    int ygb[][];
    int zgb[][];
    int ahb[][];
    boolean bhb;
    h chb[];
    h dhb[][];
    h ehb[][];
    h fhb;
}
