// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.PrintStream;

public class gnd
{

    public static int gne(byte abyte0[], int i, byte abyte1[], int j, int k)
    {
        adk adk1 = new adk();
        adk1.aeg = abyte1;
        adk1.aeh = k;
        adk1.ael = abyte0;
        adk1.aem = 0;
        adk1.aei = j;
        adk1.aen = i;
        adk1.afg = 0;
        adk1.aff = 0;
        adk1.aej = 0;
        adk1.aek = 0;
        adk1.afa = 0;
        adk1.afb = 0;
        adk1.afi = 0;
        gng(adk1);
        i -= adk1.aen;
        return i;
    }

    private static void gnf(adk adk1)
    {
        boolean flag1 = false;
        byte byte4 = adk1.afc;
        int i = adk1.afd;
        int j = adk1.afn;
        int k = adk1.afl;
        int ai[] = adk.agc;
        int l = adk1.afk;
        byte abyte0[] = adk1.ael;
        int i1 = adk1.aem;
        int j1 = adk1.aen;
        int k1 = j1;
        int l1 = adk1.ahc + 1;
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
        int i2 = adk1.afa;
        adk1.afa += k1 - j1;
        if(adk1.afa < i2)
            adk1.afb++;
        adk1.afc = byte4;
        adk1.afd = i;
        adk1.afn = j;
        adk1.afl = k;
        adk.agc = ai;
        adk1.afk = l;
        adk1.ael = abyte0;
        adk1.aem = i1;
        adk1.aen = j1;
    }

    private static void gng(adk adk1)
    {
        boolean flag21 = false;
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
        boolean flag19 = false;
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        adk1.afh = 1;
        if(adk.agc == null)
            adk.agc = new int[adk1.afh * 0x186a0];
        boolean flag20 = true;
        while(flag20) 
        {
            byte byte0 = gnh(adk1);
            if(byte0 == 23)
                return;
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            adk1.afi++;
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gnh(adk1);
            byte0 = gni(adk1);
            if(byte0 != 0)
                adk1.afe = true;
            else
                adk1.afe = false;
            if(adk1.afe)
                System.out.println("PANIC! RANDOMISED BLOCK!");
            adk1.afj = 0;
            byte0 = gnh(adk1);
            adk1.afj = adk1.afj << 8 | byte0 & 0xff;
            byte0 = gnh(adk1);
            adk1.afj = adk1.afj << 8 | byte0 & 0xff;
            byte0 = gnh(adk1);
            adk1.afj = adk1.afj << 8 | byte0 & 0xff;
            for(int j = 0; j < 16; j++)
            {
                byte byte1 = gni(adk1);
                if(byte1 == 1)
                    adk1.agf[j] = true;
                else
                    adk1.agf[j] = false;
            }

            for(int k = 0; k < 256; k++)
                adk1.age[k] = false;

            for(int l = 0; l < 16; l++)
                if(adk1.agf[l])
                {
                    for(int i3 = 0; i3 < 16; i3++)
                    {
                        byte byte2 = gni(adk1);
                        if(byte2 == 1)
                            adk1.age[l * 16 + i3] = true;
                    }

                }

            gnk(adk1);
            int i4 = adk1.agd + 2;
            int j4 = gnj(3, adk1);
            int k4 = gnj(15, adk1);
            for(int i1 = 0; i1 < k4; i1++)
            {
                int j3 = 0;
                do
                {
                    byte byte3 = gni(adk1);
                    if(byte3 == 0)
                        break;
                    j3++;
                } while(true);
                adk1.agk[i1] = (byte)j3;
            }

            byte abyte0[] = new byte[6];
            for(byte byte16 = 0; byte16 < j4; byte16++)
                abyte0[byte16] = byte16;

            for(int j1 = 0; j1 < k4; j1++)
            {
                byte byte17 = adk1.agk[j1];
                byte byte15 = abyte0[byte17];
                for(; byte17 > 0; byte17--)
                    abyte0[byte17] = abyte0[byte17 - 1];

                abyte0[0] = byte15;
                adk1.agj[j1] = byte15;
            }

            for(int k3 = 0; k3 < j4; k3++)
            {
                int l6 = gnj(5, adk1);
                for(int k1 = 0; k1 < i4; k1++)
                {
                    do
                    {
                        byte byte4 = gni(adk1);
                        if(byte4 == 0)
                            break;
                        byte4 = gni(adk1);
                        if(byte4 == 0)
                            l6++;
                        else
                            l6--;
                    } while(true);
                    adk1.agl[k3][k1] = (byte)l6;
                }

            }

            for(int l3 = 0; l3 < j4; l3++)
            {
                byte byte8 = 32;
                int i = 0;
                for(int l1 = 0; l1 < i4; l1++)
                {
                    if(adk1.agl[l3][l1] > i)
                        i = adk1.agl[l3][l1];
                    if(adk1.agl[l3][l1] < byte8)
                        byte8 = adk1.agl[l3][l1];
                }

                gnl(adk1.agm[l3], adk1.agn[l3], adk1.aha[l3], adk1.agl[l3], byte8, i, i4);
                adk1.ahb[l3] = byte8;
            }

            int l4 = adk1.agd + 1;
            int l5 = 0x186a0 * adk1.afh;
            int i5 = -1;
            int j5 = 0;
            for(int i2 = 0; i2 <= 255; i2++)
                adk1.afm[i2] = 0;

            int j9 = 4095;
            for(int l8 = 15; l8 >= 0; l8--)
            {
                for(int i9 = 15; i9 >= 0; i9--)
                {
                    adk1.agh[j9] = (byte)(l8 * 16 + i9);
                    j9--;
                }

                adk1.agi[l8] = j9 + 1;
            }

            int i6 = 0;
            i5++;
            j5 = 50;
            byte byte12 = adk1.agj[0];
            int k8 = adk1.ahb[byte12];
            int ai[] = adk1.agm[byte12];
            int ai2[] = adk1.aha[byte12];
            int ai1[] = adk1.agn[byte12];
            j5--;
            int i7 = k8;
            int l7;
            byte byte9;
            for(l7 = gnj(i7, adk1); l7 > ai[i7]; l7 = l7 << 1 | byte9)
            {
                i7++;
                byte9 = gni(adk1);
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
                            byte byte13 = adk1.agj[i5];
                            k8 = adk1.ahb[byte13];
                            ai = adk1.agm[byte13];
                            ai2 = adk1.aha[byte13];
                            ai1 = adk1.agn[byte13];
                        }
                        j5--;
                        int j7 = k8;
                        int i8;
                        byte byte10;
                        for(i8 = gnj(j7, adk1); i8 > ai[j7]; i8 = i8 << 1 | byte10)
                        {
                            j7++;
                            byte10 = gni(adk1);
                        }

                        k5 = ai2[i8 - ai1[j7]];
                    } while(k5 == 0 || k5 == 1);
                    j6++;
                    byte byte5 = adk1.agg[adk1.agh[adk1.agi[0]] & 0xff];
                    adk1.afm[byte5 & 0xff] += j6;
                    for(; j6 > 0; j6--)
                    {
                        adk.agc[i6] = byte5 & 0xff;
                        i6++;
                    }

                } else
                {
                    int j11 = k5 - 1;
                    byte byte6;
                    if(j11 < 16)
                    {
                        int j10 = adk1.agi[0];
                        byte6 = adk1.agh[j10 + j11];
                        for(; j11 > 3; j11 -= 4)
                        {
                            int k11 = j10 + j11;
                            adk1.agh[k11] = adk1.agh[k11 - 1];
                            adk1.agh[k11 - 1] = adk1.agh[k11 - 2];
                            adk1.agh[k11 - 2] = adk1.agh[k11 - 3];
                            adk1.agh[k11 - 3] = adk1.agh[k11 - 4];
                        }

                        for(; j11 > 0; j11--)
                            adk1.agh[j10 + j11] = adk1.agh[(j10 + j11) - 1];

                        adk1.agh[j10] = byte6;
                    } else
                    {
                        int l10 = j11 / 16;
                        int i11 = j11 % 16;
                        int k10 = adk1.agi[l10] + i11;
                        byte6 = adk1.agh[k10];
                        for(; k10 > adk1.agi[l10]; k10--)
                            adk1.agh[k10] = adk1.agh[k10 - 1];

                        adk1.agi[l10]++;
                        for(; l10 > 0; l10--)
                        {
                            adk1.agi[l10]--;
                            adk1.agh[adk1.agi[l10]] = adk1.agh[(adk1.agi[l10 - 1] + 16) - 1];
                        }

                        adk1.agi[0]--;
                        adk1.agh[adk1.agi[0]] = byte6;
                        if(adk1.agi[0] == 0)
                        {
                            int i10 = 4095;
                            for(int k9 = 15; k9 >= 0; k9--)
                            {
                                for(int l9 = 15; l9 >= 0; l9--)
                                {
                                    adk1.agh[i10] = adk1.agh[adk1.agi[k9] + l9];
                                    i10--;
                                }

                                adk1.agi[k9] = i10 + 1;
                            }

                        }
                    }
                    adk1.afm[adk1.agg[byte6 & 0xff] & 0xff]++;
                    adk.agc[i6] = adk1.agg[byte6 & 0xff] & 0xff;
                    i6++;
                    if(j5 == 0)
                    {
                        i5++;
                        j5 = 50;
                        byte byte14 = adk1.agj[i5];
                        k8 = adk1.ahb[byte14];
                        ai = adk1.agm[byte14];
                        ai2 = adk1.aha[byte14];
                        ai1 = adk1.agn[byte14];
                    }
                    j5--;
                    int k7 = k8;
                    int j8;
                    byte byte11;
                    for(j8 = gnj(k7, adk1); j8 > ai[k7]; j8 = j8 << 1 | byte11)
                    {
                        k7++;
                        byte11 = gni(adk1);
                    }

                    k5 = ai2[j8 - ai1[k7]];
                }

            adk1.afd = 0;
            adk1.afc = 0;
            adk1.aga[0] = 0;
            for(int j2 = 1; j2 <= 256; j2++)
                adk1.aga[j2] = adk1.afm[j2 - 1];

            for(int k2 = 1; k2 <= 256; k2++)
                adk1.aga[k2] += adk1.aga[k2 - 1];

            for(int l2 = 0; l2 < i6; l2++)
            {
                byte byte7 = (byte)(adk.agc[l2] & 0xff);
                adk.agc[adk1.aga[byte7 & 0xff]] |= l2 << 8;
                adk1.aga[byte7 & 0xff]++;
            }

            adk1.afk = adk.agc[adk1.afj] >> 8;
            adk1.afn = 0;
            adk1.afk = adk.agc[adk1.afk];
            adk1.afl = (byte)(adk1.afk & 0xff);
            adk1.afk >>= 8;
            adk1.afn++;
            adk1.ahc = i6;
            gnf(adk1);
            if(adk1.afn == adk1.ahc + 1 && adk1.afd == 0)
                flag20 = true;
            else
                flag20 = false;
        }
    }

    private static byte gnh(adk adk1)
    {
        return (byte)gnj(8, adk1);
    }

    private static byte gni(adk adk1)
    {
        return (byte)gnj(1, adk1);
    }

    private static int gnj(int i, adk adk1)
    {
        int j;
        do
        {
            if(adk1.afg >= i)
            {
                int k = adk1.aff >> adk1.afg - i & (1 << i) - 1;
                adk1.afg -= i;
                j = k;
                break;
            }
            adk1.aff = adk1.aff << 8 | adk1.aeg[adk1.aeh] & 0xff;
            adk1.afg += 8;
            adk1.aeh++;
            adk1.aei--;
            adk1.aej++;
            if(adk1.aej == 0)
                adk1.aek++;
        } while(true);
        return j;
    }

    private static void gnk(adk adk1)
    {
        adk1.agd = 0;
        for(int i = 0; i < 256; i++)
            if(adk1.age[i])
            {
                adk1.agg[adk1.agd] = (byte)i;
                adk1.agd++;
            }

    }

    private static void gnl(int ai[], int ai1[], int ai2[], byte abyte0[], int i, int j, int k)
    {
        boolean flag = false;
        int l = 0;
        for(int i1 = i; i1 <= j; i1++)
        {
            for(int l2 = 0; l2 < k; l2++)
                if(abyte0[l2] == i1)
                {
                    ai2[l] = l2;
                    l++;
                }

        }

        for(int j1 = 0; j1 < 23; j1++)
            ai1[j1] = 0;

        for(int k1 = 0; k1 < k; k1++)
            ai1[abyte0[k1] + 1]++;

        for(int l1 = 1; l1 < 23; l1++)
            ai1[l1] += ai1[l1 - 1];

        for(int i2 = 0; i2 < 23; i2++)
            ai[i2] = 0;

        int i3 = 0;
        for(int j2 = i; j2 <= j; j2++)
        {
            i3 += ai1[j2 + 1] - ai1[j2];
            ai[j2] = i3 - 1;
            i3 <<= 1;
        }

        for(int k2 = i + 1; k2 <= j; k2++)
            ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];

    }
}
