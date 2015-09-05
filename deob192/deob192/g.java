// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:08 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class g
{

    public static int cba(byte arg0[], int arg1, byte arg2[], int arg3, int arg4)
    {
        o o1 = new o();
        o1.bff = arg2;
        o1.bfg = arg4;
        o1.bfk = arg0;
        o1.bfl = 0;
        o1.bfh = arg3;
        o1.bfm = arg1;
        o1.bgf = 0;
        o1.bge = 0;
        o1.bfi = 0;
        o1.bfj = 0;
        o1.bfn = 0;
        o1.bga = 0;
        o1.bgh = 0;
        cbc(o1);
        arg1 -= o1.bfm;
        return arg1;
    }

    private static void cbb(o arg0)
    {
        byte byte4 = arg0.bgb;
        int i = arg0.bgc;
        int j = arg0.bgm;
        int k = arg0.bgk;
        int ai[] = o.bhb;
        int l = arg0.bgj;
        byte abyte0[] = arg0.bfk;
        int i1 = arg0.bfl;
        int j1 = arg0.bfm;
        int k1 = j1;
        int l1 = arg0.bib + 1;
label0:
        do
        {
            if(i > 0)
            {
                do
                {
                    if(j1 == 0)
                        break label0;
                    if(i == 1)
                        break;
                    abyte0[i1] = byte4;
                    i--;
                    i1++;
                    j1--;
                } while(true);
                if(j1 == 0)
                {
                    i = 1;
                    break;
                }
                abyte0[i1] = byte4;
                i1++;
                j1--;
            }
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                if(j == l1)
                {
                    i = 0;
                    break label0;
                }
                byte4 = (byte)k;
                l = ai[l];
                byte byte0 = (byte)(l & 0xff);
                l >>= 8;
                j++;
                if(byte0 != k)
                {
                    k = byte0;
                    if(j1 == 0)
                    {
                        i = 1;
                    } else
                    {
                        abyte0[i1] = byte4;
                        i1++;
                        j1--;
                        flag = true;
                        continue;
                    }
                    break label0;
                }
                if(j != l1)
                    continue;
                if(j1 == 0)
                {
                    i = 1;
                    break label0;
                }
                abyte0[i1] = byte4;
                i1++;
                j1--;
                flag = true;
            }
            i = 2;
            l = ai[l];
            byte byte1 = (byte)(l & 0xff);
            l >>= 8;
            if(++j != l1)
                if(byte1 != k)
                {
                    k = byte1;
                } else
                {
                    i = 3;
                    l = ai[l];
                    byte byte2 = (byte)(l & 0xff);
                    l >>= 8;
                    if(++j != l1)
                        if(byte2 != k)
                        {
                            k = byte2;
                        } else
                        {
                            l = ai[l];
                            byte byte3 = (byte)(l & 0xff);
                            l >>= 8;
                            j++;
                            i = (byte3 & 0xff) + 4;
                            l = ai[l];
                            k = (byte)(l & 0xff);
                            l >>= 8;
                            j++;
                        }
                }
        } while(true);
        int i2 = arg0.bfn;
        arg0.bfn += k1 - j1;
        if(arg0.bfn < i2)
            arg0.bga++;
        arg0.bgb = byte4;
        arg0.bgc = i;
        arg0.bgm = j;
        arg0.bgk = k;
        o.bhb = ai;
        arg0.bgj = l;
        arg0.bfk = abyte0;
        arg0.bfl = i1;
        arg0.bfm = j1;
    }

    private static void cbc(o arg0)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        boolean flag10 = false;
        boolean flag11 = false;
        boolean flag12 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag15 = false;
        boolean flag16 = false;
        boolean flag17 = false;
        boolean flag18 = false;
        int k8 = 0;
        int ai[] = null;
        int ai1[] = null;
        int ai2[] = null;
        arg0.bgg = 1;
        if(o.bhb == null)
            o.bhb = new int[arg0.bgg * 0x186a0];
        boolean flag19 = true;
        while(flag19) 
        {
            byte byte0 = cbd(arg0);
            if(byte0 == 23)
                return;
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            arg0.bgh++;
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbd(arg0);
            byte0 = cbe(arg0);
            if(byte0 != 0)
                arg0.bgd = true;
            else
                arg0.bgd = false;
            if(arg0.bgd)
                System.out.println("PANIC! RANDOMISED BLOCK!");
            arg0.bgi = 0;
            byte0 = cbd(arg0);
            arg0.bgi = arg0.bgi << 8 | byte0 & 0xff;
            byte0 = cbd(arg0);
            arg0.bgi = arg0.bgi << 8 | byte0 & 0xff;
            byte0 = cbd(arg0);
            arg0.bgi = arg0.bgi << 8 | byte0 & 0xff;
            for(int j = 0; j < 16; j++)
            {
                byte byte1 = cbe(arg0);
                if(byte1 == 1)
                    arg0.bhe[j] = true;
                else
                    arg0.bhe[j] = false;
            }

            for(int k = 0; k < 256; k++)
                arg0.bhd[k] = false;

            for(int l = 0; l < 16; l++)
                if(arg0.bhe[l])
                {
                    for(int i3 = 0; i3 < 16; i3++)
                    {
                        byte byte2 = cbe(arg0);
                        if(byte2 == 1)
                            arg0.bhd[l * 16 + i3] = true;
                    }

                }

            cbg(arg0);
            int i4 = arg0.bhc + 2;
            int j4 = cbf(3, arg0);
            int k4 = cbf(15, arg0);
            for(int i1 = 0; i1 < k4; i1++)
            {
                int j3 = 0;
                do
                {
                    byte byte3 = cbe(arg0);
                    if(byte3 == 0)
                        break;
                    j3++;
                } while(true);
                arg0.bhj[i1] = (byte)j3;
            }

            byte abyte0[] = new byte[6];
            for(byte byte16 = 0; byte16 < j4; byte16++)
                abyte0[byte16] = byte16;

            for(int j1 = 0; j1 < k4; j1++)
            {
                byte byte17 = arg0.bhj[j1];
                byte byte15 = abyte0[byte17];
                for(; byte17 > 0; byte17--)
                    abyte0[byte17] = abyte0[byte17 - 1];

                abyte0[0] = byte15;
                arg0.bhi[j1] = byte15;
            }

            for(int k3 = 0; k3 < j4; k3++)
            {
                int l6 = cbf(5, arg0);
                for(int k1 = 0; k1 < i4; k1++)
                {
                    do
                    {
                        byte byte4 = cbe(arg0);
                        if(byte4 == 0)
                            break;
                        byte4 = cbe(arg0);
                        if(byte4 == 0)
                            l6++;
                        else
                            l6--;
                    } while(true);
                    arg0.bhk[k3][k1] = (byte)l6;
                }

            }

            for(int l3 = 0; l3 < j4; l3++)
            {
                byte byte8 = 32;
                int i = 0;
                for(int l1 = 0; l1 < i4; l1++)
                {
                    if(arg0.bhk[l3][l1] > i)
                        i = arg0.bhk[l3][l1];
                    if(arg0.bhk[l3][l1] < byte8)
                        byte8 = arg0.bhk[l3][l1];
                }

                cbh(arg0.bhl[l3], arg0.bhm[l3], arg0.bhn[l3], arg0.bhk[l3], byte8, i, i4);
                arg0.bia[l3] = byte8;
            }

            int l4 = arg0.bhc + 1;
            int l5 = 0x186a0 * arg0.bgg;
            int i5 = -1;
            int j5 = 0;
            for(int i2 = 0; i2 <= 255; i2++)
                arg0.bgl[i2] = 0;

            int j9 = 4095;
            for(int l8 = 15; l8 >= 0; l8--)
            {
                for(int i9 = 15; i9 >= 0; i9--)
                {
                    arg0.bhg[j9] = (byte)(l8 * 16 + i9);
                    j9--;
                }

                arg0.bhh[l8] = j9 + 1;
            }

            int i6 = 0;
            if(j5 == 0)
            {
                i5++;
                j5 = 50;
                byte byte12 = arg0.bhi[i5];
                k8 = arg0.bia[byte12];
                ai = arg0.bhl[byte12];
                ai2 = arg0.bhn[byte12];
                ai1 = arg0.bhm[byte12];
            }
            j5--;
            int i7 = k8;
            int l7;
            byte byte9;
            for(l7 = cbf(i7, arg0); l7 > ai[i7]; l7 = l7 << 1 | byte9)
            {
                i7++;
                byte9 = cbe(arg0);
            }

            for(int k5 = ai2[l7 - ai1[i7]]; k5 != l4;)
                if(k5 == 0 || k5 == 1)
                {
                    int j6 = -1;
                    int k6 = 1;
                    do
                    {
                        if(k5 == 0)
                            j6 += k6;
                        else
                        if(k5 == 1)
                            j6 += 2 * k6;
                        k6 *= 2;
                        if(j5 == 0)
                        {
                            i5++;
                            j5 = 50;
                            byte byte13 = arg0.bhi[i5];
                            k8 = arg0.bia[byte13];
                            ai = arg0.bhl[byte13];
                            ai2 = arg0.bhn[byte13];
                            ai1 = arg0.bhm[byte13];
                        }
                        j5--;
                        int j7 = k8;
                        int i8;
                        byte byte10;
                        for(i8 = cbf(j7, arg0); i8 > ai[j7]; i8 = i8 << 1 | byte10)
                        {
                            j7++;
                            byte10 = cbe(arg0);
                        }

                        k5 = ai2[i8 - ai1[j7]];
                    } while(k5 == 0 || k5 == 1);
                    j6++;
                    byte byte5 = arg0.bhf[arg0.bhg[arg0.bhh[0]] & 0xff];
                    arg0.bgl[byte5 & 0xff] += j6;
                    for(; j6 > 0; j6--)
                    {
                        o.bhb[i6] = byte5 & 0xff;
                        i6++;
                    }

                } else
                {
                    int j11 = k5 - 1;
                    byte byte6;
                    if(j11 < 16)
                    {
                        int j10 = arg0.bhh[0];
                        byte6 = arg0.bhg[j10 + j11];
                        for(; j11 > 3; j11 -= 4)
                        {
                            int k11 = j10 + j11;
                            arg0.bhg[k11] = arg0.bhg[k11 - 1];
                            arg0.bhg[k11 - 1] = arg0.bhg[k11 - 2];
                            arg0.bhg[k11 - 2] = arg0.bhg[k11 - 3];
                            arg0.bhg[k11 - 3] = arg0.bhg[k11 - 4];
                        }

                        for(; j11 > 0; j11--)
                            arg0.bhg[j10 + j11] = arg0.bhg[(j10 + j11) - 1];

                        arg0.bhg[j10] = byte6;
                    } else
                    {
                        int l10 = j11 / 16;
                        int i11 = j11 % 16;
                        int k10 = arg0.bhh[l10] + i11;
                        byte6 = arg0.bhg[k10];
                        for(; k10 > arg0.bhh[l10]; k10--)
                            arg0.bhg[k10] = arg0.bhg[k10 - 1];

                        arg0.bhh[l10]++;
                        for(; l10 > 0; l10--)
                        {
                            arg0.bhh[l10]--;
                            arg0.bhg[arg0.bhh[l10]] = arg0.bhg[(arg0.bhh[l10 - 1] + 16) - 1];
                        }

                        arg0.bhh[0]--;
                        arg0.bhg[arg0.bhh[0]] = byte6;
                        if(arg0.bhh[0] == 0)
                        {
                            int i10 = 4095;
                            for(int k9 = 15; k9 >= 0; k9--)
                            {
                                for(int l9 = 15; l9 >= 0; l9--)
                                {
                                    arg0.bhg[i10] = arg0.bhg[arg0.bhh[k9] + l9];
                                    i10--;
                                }

                                arg0.bhh[k9] = i10 + 1;
                            }

                        }
                    }
                    arg0.bgl[arg0.bhf[byte6 & 0xff] & 0xff]++;
                    o.bhb[i6] = arg0.bhf[byte6 & 0xff] & 0xff;
                    i6++;
                    if(j5 == 0)
                    {
                        i5++;
                        j5 = 50;
                        byte byte14 = arg0.bhi[i5];
                        k8 = arg0.bia[byte14];
                        ai = arg0.bhl[byte14];
                        ai2 = arg0.bhn[byte14];
                        ai1 = arg0.bhm[byte14];
                    }
                    j5--;
                    int k7 = k8;
                    int j8;
                    byte byte11;
                    for(j8 = cbf(k7, arg0); j8 > ai[k7]; j8 = j8 << 1 | byte11)
                    {
                        k7++;
                        byte11 = cbe(arg0);
                    }

                    k5 = ai2[j8 - ai1[k7]];
                }

            arg0.bgc = 0;
            arg0.bgb = 0;
            arg0.bgn[0] = 0;
            for(int j2 = 1; j2 <= 256; j2++)
                arg0.bgn[j2] = arg0.bgl[j2 - 1];

            for(int k2 = 1; k2 <= 256; k2++)
                arg0.bgn[k2] += arg0.bgn[k2 - 1];

            for(int l2 = 0; l2 < i6; l2++)
            {
                byte byte7 = (byte)(o.bhb[l2] & 0xff);
                o.bhb[arg0.bgn[byte7 & 0xff]] |= l2 << 8;
                arg0.bgn[byte7 & 0xff]++;
            }

            arg0.bgj = o.bhb[arg0.bgi] >> 8;
            arg0.bgm = 0;
            arg0.bgj = o.bhb[arg0.bgj];
            arg0.bgk = (byte)(arg0.bgj & 0xff);
            arg0.bgj >>= 8;
            arg0.bgm++;
            arg0.bib = i6;
            cbb(arg0);
            if(arg0.bgm == arg0.bib + 1 && arg0.bgc == 0)
                flag19 = true;
            else
                flag19 = false;
        }
    }

    private static byte cbd(o arg0)
    {
        return (byte)cbf(8, arg0);
    }

    private static byte cbe(o arg0)
    {
        return (byte)cbf(1, arg0);
    }

    private static int cbf(int arg0, o arg1)
    {
        int i;
        do
        {
            if(arg1.bgf >= arg0)
            {
                int j = arg1.bge >> arg1.bgf - arg0 & (1 << arg0) - 1;
                arg1.bgf -= arg0;
                i = j;
                break;
            }
            arg1.bge = arg1.bge << 8 | arg1.bff[arg1.bfg] & 0xff;
            arg1.bgf += 8;
            arg1.bfg++;
            arg1.bfh--;
            arg1.bfi++;
            if(arg1.bfi == 0)
                arg1.bfj++;
        } while(true);
        return i;
    }

    private static void cbg(o arg0)
    {
        arg0.bhc = 0;
        for(int i = 0; i < 256; i++)
            if(arg0.bhd[i])
            {
                arg0.bhf[arg0.bhc] = (byte)i;
                arg0.bhc++;
            }

    }

    private static void cbh(int arg0[], int arg1[], int arg2[], byte arg3[], int arg4, int arg5, int arg6)
    {
        int i = 0;
        for(int j = arg4; j <= arg5; j++)
        {
            for(int i2 = 0; i2 < arg6; i2++)
                if(arg3[i2] == j)
                {
                    arg2[i] = i2;
                    i++;
                }

        }

        for(int k = 0; k < 23; k++)
            arg1[k] = 0;

        for(int l = 0; l < arg6; l++)
            arg1[arg3[l] + 1]++;

        for(int i1 = 1; i1 < 23; i1++)
            arg1[i1] += arg1[i1 - 1];

        for(int j1 = 0; j1 < 23; j1++)
            arg0[j1] = 0;

        int j2 = 0;
        for(int k1 = arg4; k1 <= arg5; k1++)
        {
            j2 += arg1[k1 + 1] - arg1[k1];
            arg0[k1] = j2 - 1;
            j2 <<= 1;
        }

        for(int l1 = arg4 + 1; l1 <= arg5; l1++)
            arg1[l1] = (arg0[l1 - 1] + 1 << 1) - arg1[l1];

    }
}