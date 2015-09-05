// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:18 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;

public class i
{

    public i(int arg0, int arg1)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        ael(arg0, arg1);
        aih = new int[arg1][1];
        for(int k = 0; k < arg1; k++)
            aih[k][0] = k;

    }

    public i(int arg0, int arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        ahc = arg2;
        ahd = arg3;
        ahe = arg4;
        ahf = arg5;
        ahg = arg6;
        ael(arg0, arg1);
    }

    private void ael(int arg0, int arg1)
    {
        aia = new int[arg0];
        aib = new int[arg0];
        aic = new int[arg0];
        afc = new int[arg0];
        afd = new byte[arg0];
        aff = new int[arg1];
        afg = new int[arg1][];
        afh = new int[arg1];
        afi = new int[arg1];
        afl = new int[arg1];
        afk = new int[arg1];
        afj = new int[arg1];
        if(!ahg)
        {
            ael = new int[arg0];
            aem = new int[arg0];
            aen = new int[arg0];
            afa = new int[arg0];
            afb = new int[arg0];
        }
        if(!ahf)
        {
            ahb = new byte[arg1];
            aha = new int[arg1];
        }
        if(ahc)
        {
            aid = aia;
            aie = aib;
            aif = aic;
        } else
        {
            aid = new int[arg0];
            aie = new int[arg0];
            aif = new int[arg0];
        }
        if(!ahe || !ahd)
        {
            afm = new int[arg1];
            afn = new int[arg1];
            aga = new int[arg1];
        }
        if(!ahd)
        {
            aii = new int[arg1];
            aij = new int[arg1];
            aik = new int[arg1];
            ail = new int[arg1];
            aim = new int[arg1];
            ain = new int[arg1];
        }
        afe = 0;
        aek = 0;
        ahn = arg0;
        aig = arg1;
        aja = ajb = ajc = 0;
        ajd = aje = ajf = 0;
        ajg = ajh = aji = 256;
        ajj = ajk = ajl = ajm = ajn = aka = 256;
        akb = 0;
    }

    public void aem()
    {
        ael = new int[aek];
        aem = new int[aek];
        aen = new int[aek];
        afa = new int[aek];
        afb = new int[aek];
    }

    public void aen()
    {
        afe = 0;
        aek = 0;
    }

    public void afa(int arg0, int arg1)
    {
        afe -= arg0;
        if(afe < 0)
            afe = 0;
        aek -= arg1;
        if(aek < 0)
            aek = 0;
    }

    public i(byte arg0[], int arg1, boolean arg2)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        int k = t.amm(arg0, arg1);
        arg1 += 2;
        int l = t.amm(arg0, arg1);
        arg1 += 2;
        ael(k, l);
        aih = new int[l][1];
        for(int i1 = 0; i1 < k; i1++)
        {
            aia[i1] = t.anb(arg0, arg1);
            arg1 += 2;
        }

        for(int j1 = 0; j1 < k; j1++)
        {
            aib[j1] = t.anb(arg0, arg1);
            arg1 += 2;
        }

        for(int k1 = 0; k1 < k; k1++)
        {
            aic[k1] = t.anb(arg0, arg1);
            arg1 += 2;
        }

        aek = k;
        for(int l1 = 0; l1 < l; l1++)
            aff[l1] = arg0[arg1++] & 0xff;

        for(int i2 = 0; i2 < l; i2++)
        {
            afh[i2] = t.anb(arg0, arg1);
            arg1 += 2;
            if(afh[i2] == 32767)
                afh[i2] = ahm;
        }

        for(int j2 = 0; j2 < l; j2++)
        {
            afi[j2] = t.anb(arg0, arg1);
            arg1 += 2;
            if(afi[j2] == 32767)
                afi[j2] = ahm;
        }

        for(int k2 = 0; k2 < l; k2++)
        {
            int l2 = arg0[arg1++] & 0xff;
            if(l2 == 0)
                afl[k2] = 0;
            else
                afl[k2] = ahm;
        }

        for(int i3 = 0; i3 < l; i3++)
        {
            afg[i3] = new int[aff[i3]];
            for(int j3 = 0; j3 < aff[i3]; j3++)
                if(k < 256)
                {
                    afg[i3][j3] = arg0[arg1++] & 0xff;
                } else
                {
                    afg[i3][j3] = t.amm(arg0, arg1);
                    arg1 += 2;
                }

        }

        afe = l;
        agc = 1;
    }

    public i(String arg0)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        boolean flag = false;
        boolean flag1 = false;
        byte abyte0[] = null;
        try
        {
            java.io.InputStream inputstream = t.amj(arg0);
            DataInputStream datainputstream = new DataInputStream(inputstream);
            abyte0 = new byte[3];
            akj = 0;
            akk = 0;
            for(int k = 0; k < 3; k += datainputstream.read(abyte0, k, 3 - k));
            int i1 = ahf(abyte0);
            abyte0 = new byte[i1];
            akj = 0;
            akk = 0;
            for(int l = 0; l < i1; l += datainputstream.read(abyte0, l, i1 - l));
            datainputstream.close();
        }
        catch(IOException _ex)
        {
            aek = 0;
            afe = 0;
            return;
        }
        int j1 = ahf(abyte0);
        int k1 = ahf(abyte0);
        boolean flag2 = false;
        ael(j1, k1);
        aih = new int[k1][];
        for(int l3 = 0; l3 < j1; l3++)
        {
            int l1 = ahf(abyte0);
            int i2 = ahf(abyte0);
            int j2 = ahf(abyte0);
            afg(l1, i2, j2);
        }

        for(int i4 = 0; i4 < k1; i4++)
        {
            int k2 = ahf(abyte0);
            int l2 = ahf(abyte0);
            int i3 = ahf(abyte0);
            int j3 = ahf(abyte0);
            akh = ahf(abyte0);
            aki = ahf(abyte0);
            int k3 = ahf(abyte0);
            int ai[] = new int[k2];
            for(int j4 = 0; j4 < k2; j4++)
                ai[j4] = ahf(abyte0);

            int ai1[] = new int[j3];
            for(int k4 = 0; k4 < j3; k4++)
                ai1[k4] = ahf(abyte0);

            int l4 = afi(k2, ai, l2, i3);
            aih[i4] = ai1;
            if(k3 == 0)
                afl[l4] = 0;
            else
                afl[l4] = ahm;
        }

        agc = 1;
    }

    public i(i arg0[], int arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        ahc = arg2;
        ahd = arg3;
        ahe = arg4;
        ahf = arg5;
        aff(arg0, arg1, false);
    }

    public i(i arg0[], int arg1)
    {
        agc = 1;
        agd = true;
        agk = true;
        agl = false;
        agm = false;
        agn = -1;
        ahc = false;
        ahd = false;
        ahe = false;
        ahf = false;
        ahg = false;
        ahl = 4;
        ahm = 0xbc614e;
        akc = 0xbc614e;
        akd = 180;
        ake = 155;
        akf = 95;
        akg = 256;
        akh = 512;
        aki = 32;
        aff(arg0, arg1, true);
    }

    public void aff(i arg0[], int arg1, boolean arg2)
    {
        int k = 0;
        int l = 0;
        for(int i1 = 0; i1 < arg1; i1++)
        {
            k += arg0[i1].afe;
            l += arg0[i1].aek;
        }

        ael(l, k);
        if(arg2)
            aih = new int[k][];
        for(int j1 = 0; j1 < arg1; j1++)
        {
            i k1 = arg0[j1];
            k1.ahb();
            aki = k1.aki;
            akh = k1.akh;
            akd = k1.akd;
            ake = k1.ake;
            akf = k1.akf;
            akg = k1.akg;
            for(int l1 = 0; l1 < k1.afe; l1++)
            {
                int ai[] = new int[k1.aff[l1]];
                int ai1[] = k1.afg[l1];
                for(int i2 = 0; i2 < k1.aff[l1]; i2++)
                    ai[i2] = afg(k1.aia[ai1[i2]], k1.aib[ai1[i2]], k1.aic[ai1[i2]]);

                int j2 = afi(k1.aff[l1], ai, k1.afh[l1], k1.afi[l1]);
                afl[j2] = k1.afl[l1];
                afk[j2] = k1.afk[l1];
                afj[j2] = k1.afj[l1];
                if(arg2)
                    if(arg1 > 1)
                    {
                        aih[j2] = new int[k1.aih[l1].length + 1];
                        aih[j2][0] = j1;
                        for(int k2 = 0; k2 < k1.aih[l1].length; k2++)
                            aih[j2][k2 + 1] = k1.aih[l1][k2];

                    } else
                    {
                        aih[j2] = new int[k1.aih[l1].length];
                        for(int l2 = 0; l2 < k1.aih[l1].length; l2++)
                            aih[j2][l2] = k1.aih[l1][l2];

                    }
            }

        }

        agc = 1;
    }

    public int afg(int arg0, int arg1, int arg2)
    {
        for(int k = 0; k < aek; k++)
            if(aia[k] == arg0 && aib[k] == arg1 && aic[k] == arg2)
                return k;

        if(aek >= ahn)
        {
            return -1;
        } else
        {
            aia[aek] = arg0;
            aib[aek] = arg1;
            aic[aek] = arg2;
            return aek++;
        }
    }

    public int afh(int arg0, int arg1, int arg2)
    {
        if(aek >= ahn)
        {
            return -1;
        } else
        {
            aia[aek] = arg0;
            aib[aek] = arg1;
            aic[aek] = arg2;
            return aek++;
        }
    }

    public int afi(int arg0, int arg1[], int arg2, int arg3)
    {
        if(afe >= aig)
        {
            return -1;
        } else
        {
            aff[afe] = arg0;
            afg[afe] = arg1;
            afh[afe] = arg2;
            afi[afe] = arg3;
            agc = 1;
            return afe++;
        }
    }

    public i[] afj(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, 
            boolean arg7)
    {
        ahb();
        int ai[] = new int[arg5];
        int ai1[] = new int[arg5];
        for(int k = 0; k < arg5; k++)
        {
            ai[k] = 0;
            ai1[k] = 0;
        }

        for(int l = 0; l < afe; l++)
        {
            int i1 = 0;
            int j1 = 0;
            int l1 = aff[l];
            int ai3[] = afg[l];
            for(int l2 = 0; l2 < l1; l2++)
            {
                i1 += aia[ai3[l2]];
                j1 += aic[ai3[l2]];
            }

            int j3 = i1 / (l1 * arg2) + (j1 / (l1 * arg3)) * arg4;
            ai[j3] += l1;
            ai1[j3]++;
        }

        i ai2[] = new i[arg5];
        for(int k1 = 0; k1 < arg5; k1++)
        {
            if(ai[k1] > arg6)
                ai[k1] = arg6;
            ai2[k1] = new i(ai[k1], ai1[k1], true, true, true, arg7, true);
            ai2[k1].akh = akh;
            ai2[k1].aki = aki;
        }

        for(int i2 = 0; i2 < afe; i2++)
        {
            int j2 = 0;
            int i3 = 0;
            int k3 = aff[i2];
            int ai4[] = afg[i2];
            for(int l3 = 0; l3 < k3; l3++)
            {
                j2 += aia[ai4[l3]];
                i3 += aic[ai4[l3]];
            }

            int i4 = j2 / (k3 * arg2) + (i3 / (k3 * arg3)) * arg4;
            afk(ai2[i4], ai4, k3, i2);
        }

        for(int k2 = 0; k2 < arg5; k2++)
            ai2[k2].aem();

        return ai2;
    }

    public void afk(i arg0, int arg1[], int arg2, int arg3)
    {
        int ai[] = new int[arg2];
        for(int k = 0; k < arg2; k++)
        {
            int l = ai[k] = arg0.afg(aia[arg1[k]], aib[arg1[k]], aic[arg1[k]]);
            arg0.afc[l] = afc[arg1[k]];
            arg0.afd[l] = afd[arg1[k]];
        }

        int i1 = arg0.afi(arg2, ai, afh[arg3], afi[arg3]);
        if(!arg0.ahf && !ahf)
            arg0.aha[i1] = aha[arg3];
        arg0.afl[i1] = afl[arg3];
        arg0.afk[i1] = afk[arg3];
        arg0.afj[i1] = afj[arg3];
    }

    public void afl(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        aki = 256 - arg1 * 4;
        akh = (64 - arg2) * 16 + 128;
        if(ahe)
            return;
        for(int k = 0; k < afe; k++)
            if(arg0)
                afl[k] = ahm;
            else
                afl[k] = 0;

        akd = arg3;
        ake = arg4;
        akf = arg5;
        akg = (int)Math.sqrt(arg3 * arg3 + arg4 * arg4 + arg5 * arg5);
        agl();
    }

    public void afm(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        aki = 256 - arg0 * 4;
        akh = (64 - arg1) * 16 + 128;
        if(ahe)
        {
            return;
        } else
        {
            akd = arg2;
            ake = arg3;
            akf = arg4;
            akg = (int)Math.sqrt(arg2 * arg2 + arg3 * arg3 + arg4 * arg4);
            agl();
            return;
        }
    }

    public void afn(int arg0, int arg1, int arg2)
    {
        if(ahe)
        {
            return;
        } else
        {
            akd = arg0;
            ake = arg1;
            akf = arg2;
            akg = (int)Math.sqrt(arg0 * arg0 + arg1 * arg1 + arg2 * arg2);
            agl();
            return;
        }
    }

    public void aga(int arg0, int arg1)
    {
        afd[arg0] = (byte)arg1;
    }

    public void agb(int arg0, int arg1, int arg2)
    {
        ajd = ajd + arg0 & 0xff;
        aje = aje + arg1 & 0xff;
        ajf = ajf + arg2 & 0xff;
        agf();
        agc = 1;
    }

    public void agc(int arg0, int arg1, int arg2)
    {
        ajd = arg0 & 0xff;
        aje = arg1 & 0xff;
        ajf = arg2 & 0xff;
        agf();
        agc = 1;
    }

    public void agd(int arg0, int arg1, int arg2)
    {
        aja += arg0;
        ajb += arg1;
        ajc += arg2;
        agf();
        agc = 1;
    }

    public void age(int arg0, int arg1, int arg2)
    {
        aja = arg0;
        ajb = arg1;
        ajc = arg2;
        agf();
        agc = 1;
    }

    private void agf()
    {
        if(ajj != 256 || ajk != 256 || ajl != 256 || ajm != 256 || ajn != 256 || aka != 256)
        {
            akb = 4;
            return;
        }
        if(ajg != 256 || ajh != 256 || aji != 256)
        {
            akb = 3;
            return;
        }
        if(ajd != 0 || aje != 0 || ajf != 0)
        {
            akb = 2;
            return;
        }
        if(aja != 0 || ajb != 0 || ajc != 0)
        {
            akb = 1;
            return;
        } else
        {
            akb = 0;
            return;
        }
    }

    private void agg(int arg0, int arg1, int arg2)
    {
        for(int k = 0; k < aek; k++)
        {
            aid[k] += arg0;
            aie[k] += arg1;
            aif[k] += arg2;
        }

    }

    private void agh(int arg0, int arg1, int arg2)
    {
        for(int l2 = 0; l2 < aek; l2++)
        {
            if(arg2 != 0)
            {
                int k = ahh[arg2];
                int j1 = ahh[arg2 + 256];
                int i2 = aie[l2] * k + aid[l2] * j1 >> 15;
                aie[l2] = aie[l2] * j1 - aid[l2] * k >> 15;
                aid[l2] = i2;
            }
            if(arg0 != 0)
            {
                int l = ahh[arg0];
                int k1 = ahh[arg0 + 256];
                int j2 = aie[l2] * k1 - aif[l2] * l >> 15;
                aif[l2] = aie[l2] * l + aif[l2] * k1 >> 15;
                aie[l2] = j2;
            }
            if(arg1 != 0)
            {
                int i1 = ahh[arg1];
                int l1 = ahh[arg1 + 256];
                int k2 = aif[l2] * i1 + aid[l2] * l1 >> 15;
                aif[l2] = aif[l2] * l1 - aid[l2] * i1 >> 15;
                aid[l2] = k2;
            }
        }

    }

    private void agi(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        for(int k = 0; k < aek; k++)
        {
            if(arg0 != 0)
                aid[k] += aie[k] * arg0 >> 8;
            if(arg1 != 0)
                aif[k] += aie[k] * arg1 >> 8;
            if(arg2 != 0)
                aid[k] += aif[k] * arg2 >> 8;
            if(arg3 != 0)
                aie[k] += aif[k] * arg3 >> 8;
            if(arg4 != 0)
                aif[k] += aid[k] * arg4 >> 8;
            if(arg5 != 0)
                aie[k] += aid[k] * arg5 >> 8;
        }

    }

    private void agj(int arg0, int arg1, int arg2)
    {
        for(int k = 0; k < aek; k++)
        {
            aid[k] = aid[k] * arg0 >> 8;
            aie[k] = aie[k] * arg1 >> 8;
            aif[k] = aif[k] * arg2 >> 8;
        }

    }

    private void agk()
    {
        age = agg = agi = 0xf423f;
        akc = agf = agh = agj = 0xfff0bdc1;
        for(int k = 0; k < afe; k++)
        {
            int ai[] = afg[k];
            int i1 = ai[0];
            int k1 = aff[k];
            int l1;
            int i2 = l1 = aid[i1];
            int j2;
            int k2 = j2 = aie[i1];
            int l2;
            int i3 = l2 = aif[i1];
            for(int l = 0; l < k1; l++)
            {
                int j1 = ai[l];
                if(aid[j1] < l1)
                    l1 = aid[j1];
                else
                if(aid[j1] > i2)
                    i2 = aid[j1];
                if(aie[j1] < j2)
                    j2 = aie[j1];
                else
                if(aie[j1] > k2)
                    k2 = aie[j1];
                if(aif[j1] < l2)
                    l2 = aif[j1];
                else
                if(aif[j1] > i3)
                    i3 = aif[j1];
            }

            if(!ahd)
            {
                aii[k] = l1;
                aij[k] = i2;
                aik[k] = j2;
                ail[k] = k2;
                aim[k] = l2;
                ain[k] = i3;
            }
            if(i2 - l1 > akc)
                akc = i2 - l1;
            if(k2 - j2 > akc)
                akc = k2 - j2;
            if(i3 - l2 > akc)
                akc = i3 - l2;
            if(l1 < age)
                age = l1;
            if(i2 > agf)
                agf = i2;
            if(j2 < agg)
                agg = j2;
            if(k2 > agh)
                agh = k2;
            if(l2 < agi)
                agi = l2;
            if(i3 > agj)
                agj = i3;
        }

    }

    public void agl()
    {
        if(ahe)
            return;
        int k = akh * akg >> 8;
        for(int l = 0; l < afe; l++)
            if(afl[l] != ahm)
                afl[l] = (afm[l] * akd + afn[l] * ake + aga[l] * akf) / k;

        int ai[] = new int[aek];
        int ai1[] = new int[aek];
        int ai2[] = new int[aek];
        int ai3[] = new int[aek];
        for(int i1 = 0; i1 < aek; i1++)
        {
            ai[i1] = 0;
            ai1[i1] = 0;
            ai2[i1] = 0;
            ai3[i1] = 0;
        }

        for(int j1 = 0; j1 < afe; j1++)
            if(afl[j1] == ahm)
            {
                for(int k1 = 0; k1 < aff[j1]; k1++)
                {
                    int i2 = afg[j1][k1];
                    ai[i2] += afm[j1];
                    ai1[i2] += afn[j1];
                    ai2[i2] += aga[j1];
                    ai3[i2]++;
                }

            }

        for(int l1 = 0; l1 < aek; l1++)
            if(ai3[l1] > 0)
                afc[l1] = (ai[l1] * akd + ai1[l1] * ake + ai2[l1] * akf) / (k * ai3[l1]);

    }

    public void agm()
    {
        if(ahe && ahd)
            return;
        for(int k = 0; k < afe; k++)
        {
            int ai[] = afg[k];
            int l = aid[ai[0]];
            int i1 = aie[ai[0]];
            int j1 = aif[ai[0]];
            int k1 = aid[ai[1]] - l;
            int l1 = aie[ai[1]] - i1;
            int i2 = aif[ai[1]] - j1;
            int j2 = aid[ai[2]] - l;
            int k2 = aie[ai[2]] - i1;
            int l2 = aif[ai[2]] - j1;
            int i3 = l1 * l2 - k2 * i2;
            int j3 = i2 * j2 - l2 * k1;
            int k3;
            for(k3 = k1 * k2 - j2 * l1; i3 > 8192 || j3 > 8192 || k3 > 8192 || i3 < -8192 || j3 < -8192 || k3 < -8192; k3 >>= 1)
            {
                i3 >>= 1;
                j3 >>= 1;
            }

            int l3 = (int)(256D * Math.sqrt(i3 * i3 + j3 * j3 + k3 * k3));
            if(l3 <= 0)
                l3 = 1;
            afm[k] = (i3 * 0x10000) / l3;
            afn[k] = (j3 * 0x10000) / l3;
            aga[k] = (k3 * 65535) / l3;
            afk[k] = -1;
        }

        agl();
    }

    public void agn()
    {
        if(agc == 2)
        {
            agc = 0;
            for(int k = 0; k < aek; k++)
            {
                aid[k] = aia[k];
                aie[k] = aib[k];
                aif[k] = aic[k];
            }

            age = agg = agi = 0xff676981;
            akc = agf = agh = agj = 0x98967f;
            return;
        }
        if(agc == 1)
        {
            agc = 0;
            for(int l = 0; l < aek; l++)
            {
                aid[l] = aia[l];
                aie[l] = aib[l];
                aif[l] = aic[l];
            }

            if(akb >= 2)
                agh(ajd, aje, ajf);
            if(akb >= 3)
                agj(ajg, ajh, aji);
            if(akb >= 4)
                agi(ajj, ajk, ajl, ajm, ajn, aka);
            if(akb >= 1)
                agg(aja, ajb, ajc);
            agk();
            agm();
        }
    }

    public void aha(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, 
            int arg7)
    {
        agn();
        if(agi > n.egc || agj < n.egb || age > n.efm || agf < n.efl || agg > n.ega || agh < n.efn)
        {
            agd = false;
            return;
        }
        agd = true;
        int j1 = 0;
        int k1 = 0;
        int l1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        if(arg5 != 0)
        {
            j1 = ahi[arg5];
            k1 = ahi[arg5 + 1024];
        }
        if(arg4 != 0)
        {
            j2 = ahi[arg4];
            k2 = ahi[arg4 + 1024];
        }
        if(arg3 != 0)
        {
            l1 = ahi[arg3];
            i2 = ahi[arg3 + 1024];
        }
        for(int l2 = 0; l2 < aek; l2++)
        {
            int i3 = aid[l2] - arg0;
            int j3 = aie[l2] - arg1;
            int k3 = aif[l2] - arg2;
            if(arg5 != 0)
            {
                int k = j3 * j1 + i3 * k1 >> 15;
                j3 = j3 * k1 - i3 * j1 >> 15;
                i3 = k;
            }
            if(arg4 != 0)
            {
                int l = k3 * j2 + i3 * k2 >> 15;
                k3 = k3 * k2 - i3 * j2 >> 15;
                i3 = l;
            }
            if(arg3 != 0)
            {
                int i1 = j3 * i2 - k3 * l1 >> 15;
                k3 = j3 * l1 + k3 * i2 >> 15;
                j3 = i1;
            }
            if(k3 >= arg7)
                afa[l2] = (i3 << arg6) / k3;
            else
                afa[l2] = i3 << arg6;
            if(k3 >= arg7)
                afb[l2] = (j3 << arg6) / k3;
            else
                afb[l2] = j3 << arg6;
            ael[l2] = i3;
            aem[l2] = j3;
            aen[l2] = k3;
        }

    }

    public void ahb()
    {
        agn();
        for(int k = 0; k < aek; k++)
        {
            aia[k] = aid[k];
            aib[k] = aie[k];
            aic[k] = aif[k];
        }

        aja = ajb = ajc = 0;
        ajd = aje = ajf = 0;
        ajg = ajh = aji = 256;
        ajj = ajk = ajl = ajm = ajn = aka = 256;
        akb = 0;
    }

    public i ahc()
    {
        i ai[] = new i[1];
        ai[0] = this;
        i k = new i(ai, 1);
        k.agb = agb;
        k.agm = agm;
        return k;
    }

    public i ahd(boolean arg0, boolean arg1, boolean arg2, boolean arg3)
    {
        i ai[] = new i[1];
        ai[0] = this;
        i k = new i(ai, 1, arg0, arg1, arg2, arg3);
        k.agb = agb;
        return k;
    }

    public void ahe(i arg0)
    {
        ajd = arg0.ajd;
        aje = arg0.aje;
        ajf = arg0.ajf;
        aja = arg0.aja;
        ajb = arg0.ajb;
        ajc = arg0.ajc;
        agf();
        agc = 1;
    }

    public int ahf(byte arg0[])
    {
        for(; arg0[akj] == 10 || arg0[akj] == 13; akj++);
        int k = ahk[arg0[akj++] & 0xff];
        int l = ahk[arg0[akj++] & 0xff];
        int i1 = ahk[arg0[akj++] & 0xff];
        int j1 = (k * 4096 + l * 64 + i1) - 0x20000;
        if(j1 == 0x1e240)
            j1 = ahm;
        return j1;
    }

    public int aek;
    public int ael[];
    public int aem[];
    public int aen[];
    public int afa[];
    public int afb[];
    public int afc[];
    public byte afd[];
    public int afe;
    public int aff[];
    public int afg[][];
    public int afh[];
    public int afi[];
    public int afj[];
    public int afk[];
    public int afl[];
    public int afm[];
    public int afn[];
    public int aga[];
    public int agb;
    public int agc;
    public boolean agd;
    public int age;
    public int agf;
    public int agg;
    public int agh;
    public int agi;
    public int agj;
    public boolean agk;
    public boolean agl;
    public boolean agm;
    public int agn;
    public int aha[];
    public byte ahb[];
    private boolean ahc;
    public boolean ahd;
    public boolean ahe;
    public boolean ahf;
    public boolean ahg;
    private static int ahh[];
    private static int ahi[];
    private static byte ahj[];
    private static int ahk[];
    private int ahl;
    private int ahm;
    public int ahn;
    public int aia[];
    public int aib[];
    public int aic[];
    public int aid[];
    public int aie[];
    public int aif[];
    private int aig;
    private int aih[][];
    private int aii[];
    private int aij[];
    private int aik[];
    private int ail[];
    private int aim[];
    private int ain[];
    private int aja;
    private int ajb;
    private int ajc;
    private int ajd;
    private int aje;
    private int ajf;
    private int ajg;
    private int ajh;
    private int aji;
    private int ajj;
    private int ajk;
    private int ajl;
    private int ajm;
    private int ajn;
    private int aka;
    private int akb;
    private int akc;
    private int akd;
    private int ake;
    private int akf;
    private int akg;
    protected int akh;
    protected int aki;
    private int akj;
    private int akk;

    static 
    {
        ahh = new int[512];
        ahi = new int[2048];
        ahj = new byte[64];
        ahk = new int[256];
        for(int k = 0; k < 256; k++)
        {
            ahh[k] = (int)(Math.sin((double)k * 0.02454369D) * 32768D);
            ahh[k + 256] = (int)(Math.cos((double)k * 0.02454369D) * 32768D);
        }

        for(int l = 0; l < 1024; l++)
        {
            ahi[l] = (int)(Math.sin((double)l * 0.00613592315D) * 32768D);
            ahi[l + 1024] = (int)(Math.cos((double)l * 0.00613592315D) * 32768D);
        }

        for(int i1 = 0; i1 < 10; i1++)
            ahj[i1] = (byte)(48 + i1);

        for(int j1 = 0; j1 < 26; j1++)
            ahj[j1 + 10] = (byte)(65 + j1);

        for(int k1 = 0; k1 < 26; k1++)
            ahj[k1 + 36] = (byte)(97 + k1);

        ahj[62] = -93;
        ahj[63] = 36;
        for(int l1 = 0; l1 < 10; l1++)
            ahk[48 + l1] = l1;

        for(int i2 = 0; i2 < 26; i2++)
            ahk[65 + i2] = i2 + 10;

        for(int j2 = 0; j2 < 26; j2++)
            ahk[97 + j2] = j2 + 36;

        ahk[163] = 62;
        ahk[36] = 63;
    }
}