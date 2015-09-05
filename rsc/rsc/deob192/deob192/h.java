// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:13 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


public class h
{

    public h(j arg0, int arg1)
    {
        abm = -1;
        acm = true;
        aab = arg0;
        aad = arg1;
        aae = new boolean[arg1];
        aaf = new boolean[arg1];
        aag = new boolean[arg1];
        aah = new boolean[arg1];
        aam = new boolean[arg1];
        aai = new int[arg1];
        aaj = new int[arg1];
        aak = new int[arg1];
        aal = new int[arg1];
        aan = new int[arg1];
        aba = new int[arg1];
        abb = new int[arg1];
        abc = new int[arg1];
        abd = new int[arg1];
        abe = new int[arg1];
        abf = new int[arg1];
        abg = new String[arg1];
        abh = new String[arg1][];
        aca = aad(114, 114, 176);
        acb = aad(14, 14, 62);
        acc = aad(200, 208, 232);
        acd = aad(96, 129, 184);
        ace = aad(53, 95, 115);
        acf = aad(117, 142, 171);
        acg = aad(98, 122, 158);
        ach = aad(86, 100, 136);
        aci = aad(135, 146, 179);
        acj = aad(97, 112, 151);
        ack = aad(88, 102, 136);
        acl = aad(84, 93, 120);
    }

    public int aad(int arg0, int arg1, int arg2)
    {
        return j.bbg((adb * arg0) / 114, (adc * arg1) / 114, (add * arg2) / 176);
    }

    public void aae(int arg0, int arg1, int arg2, int arg3)
    {
        abi = arg0;
        abj = arg1;
        abl = arg3;
        if(arg2 != 0)
            abk = arg2;
        if(arg2 == 1)
        {
            for(int i = 0; i < aac; i++)
            {
                if(aae[i] && abb[i] == 10 && abi >= aan[i] && abj >= aba[i] && abi <= aan[i] + abc[i] && abj <= aba[i] + abd[i])
                    aah[i] = true;
                if(aae[i] && abb[i] == 14 && abi >= aan[i] && abj >= aba[i] && abi <= aan[i] + abc[i] && abj <= aba[i] + abd[i])
                    aak[i] = 1 - aak[i];
            }

        }
        if(arg3 == 1)
            abn++;
        else
            abn = 0;
        if(arg2 == 1 || abn > 20)
        {
            for(int k = 0; k < aac; k++)
                if(aae[k] && abb[k] == 15 && abi >= aan[k] && abj >= aba[k] && abi <= aan[k] + abc[k] && abj <= aba[k] + abd[k])
                    aah[k] = true;

            abn -= 5;
        }
    }

    public boolean aaf(int arg0)
    {
        if(aae[arg0] && aah[arg0])
        {
            aah[arg0] = false;
            return true;
        } else
        {
            return false;
        }
    }

    public void aag(int arg0)
    {
        if(arg0 == 0)
            return;
        if(abm != -1 && abg[abm] != null && aae[abm])
        {
            int i = abg[abm].length();
            if(arg0 == 8 && i > 0)
                abg[abm] = abg[abm].substring(0, i - 1);
            if((arg0 == 10 || arg0 == 13) && i > 0)
                aah[abm] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(i < abe[abm])
            {
                for(int k = 0; k < s.length(); k++)
                    if(arg0 == s.charAt(k))
                        abg[abm] += (char)arg0;

            }
            if(arg0 == 9)
                do
                    abm = (abm + 1) % aac;
                while(abb[abm] != 5 && abb[abm] != 6);
        }
    }

    public void aah()
    {
        for(int i = 0; i < aac; i++)
            if(aae[i])
                if(abb[i] == 0)
                    aaj(i, aan[i], aba[i], abg[i], abf[i]);
                else
                if(abb[i] == 1)
                    aaj(i, aan[i] - aab.bee(abg[i], abf[i]) / 2, aba[i], abg[i], abf[i]);
                else
                if(abb[i] == 2)
                    aam(aan[i], aba[i], abc[i], abd[i]);
                else
                if(abb[i] == 3)
                    abb(aan[i], aba[i], abc[i]);
                else
                if(abb[i] == 4)
                    abc(i, aan[i], aba[i], abc[i], abd[i], abf[i], abh[i], aaj[i], aai[i]);
                else
                if(abb[i] == 5 || abb[i] == 6)
                    aal(i, aan[i], aba[i], abc[i], abd[i], abg[i], abf[i]);
                else
                if(abb[i] == 7)
                    abe(i, aan[i], aba[i], abf[i], abh[i]);
                else
                if(abb[i] == 8)
                    abf(i, aan[i], aba[i], abf[i], abh[i]);
                else
                if(abb[i] == 9)
                    abg(i, aan[i], aba[i], abc[i], abd[i], abf[i], abh[i], aaj[i], aai[i]);
                else
                if(abb[i] == 11)
                    aan(aan[i], aba[i], abc[i], abd[i]);
                else
                if(abb[i] == 12)
                    aba(aan[i], aba[i], abf[i]);
                else
                if(abb[i] == 14)
                    aai(i, aan[i], aba[i], abc[i], abd[i]);

        abk = 0;
    }

    protected void aai(int arg0, int arg1, int arg2, int arg3, int arg4)
    {
        aab.ban(arg1, arg2, arg3, arg4, 0xffffff);
        aab.bbb(arg1, arg2, arg3, aci);
        aab.bbc(arg1, arg2, arg4, aci);
        aab.bbb(arg1, (arg2 + arg4) - 1, arg3, acl);
        aab.bbc((arg1 + arg3) - 1, arg2, arg4, acl);
        if(aak[arg0] == 1)
        {
            for(int i = 0; i < arg4; i++)
            {
                aab.bbb(arg1 + i, arg2 + i, 1, 0);
                aab.bbb((arg1 + arg3) - 1 - i, arg2 + i, 1, 0);
            }

        }
    }

    protected void aaj(int arg0, int arg1, int arg2, String arg3, int arg4)
    {
        int i = arg2 + aab.bec(arg4) / 3;
        aak(arg0, arg1, i, arg3, arg4);
    }

    protected void aak(int arg0, int arg1, int arg2, String arg3, int arg4)
    {
        int i;
        if(aam[arg0])
            i = 0xffffff;
        else
            i = 0;
        aab.bdm(arg3, arg1, arg2, arg4, i);
    }

    protected void aal(int arg0, int arg1, int arg2, int arg3, int arg4, String arg5, int arg6)
    {
        if(aag[arg0])
        {
            int i = arg5.length();
            arg5 = "";
            for(int l = 0; l < i; l++)
                arg5 = arg5 + "X";

        }
        if(abb[arg0] == 5)
        {
            if(abk == 1 && abi >= arg1 && abj >= arg2 - arg4 / 2 && abi <= arg1 + arg3 && abj <= arg2 + arg4 / 2)
                abm = arg0;
        } else
        if(abb[arg0] == 6)
        {
            if(abk == 1 && abi >= arg1 - arg3 / 2 && abj >= arg2 - arg4 / 2 && abi <= arg1 + arg3 / 2 && abj <= arg2 + arg4 / 2)
                abm = arg0;
            arg1 -= aab.bee(arg5, arg6) / 2;
        }
        if(abm == arg0)
            arg5 = arg5 + "*";
        int k = arg2 + aab.bec(arg6) / 3;
        aak(arg0, arg1, k, arg5, arg6);
    }

    public void aam(int arg0, int arg1, int arg2, int arg3)
    {
        aab.bag(arg0, arg1, arg0 + arg2, arg1 + arg3);
        aab.bam(arg0, arg1, arg2, arg3, acl, aci);
        if(acn)
        {
            for(int i = arg0 - (arg1 & 0x3f); i < arg0 + arg2; i += 128)
            {
                for(int k = arg1 - (arg1 & 0x1f); k < arg1 + arg3; k += 128)
                    aab.bcc(i, k, 6 + ada, 128);

            }

        }
        aab.bbb(arg0, arg1, arg2, aci);
        aab.bbb(arg0 + 1, arg1 + 1, arg2 - 2, aci);
        aab.bbb(arg0 + 2, arg1 + 2, arg2 - 4, acj);
        aab.bbc(arg0, arg1, arg3, aci);
        aab.bbc(arg0 + 1, arg1 + 1, arg3 - 2, aci);
        aab.bbc(arg0 + 2, arg1 + 2, arg3 - 4, acj);
        aab.bbb(arg0, (arg1 + arg3) - 1, arg2, acl);
        aab.bbb(arg0 + 1, (arg1 + arg3) - 2, arg2 - 2, acl);
        aab.bbb(arg0 + 2, (arg1 + arg3) - 3, arg2 - 4, ack);
        aab.bbc((arg0 + arg2) - 1, arg1, arg3, acl);
        aab.bbc((arg0 + arg2) - 2, arg1 + 1, arg3 - 2, acl);
        aab.bbc((arg0 + arg2) - 3, arg1 + 2, arg3 - 4, ack);
        aab.bah();
    }

    public void aan(int arg0, int arg1, int arg2, int arg3)
    {
        aab.ban(arg0, arg1, arg2, arg3, 0);
        aab.bba(arg0, arg1, arg2, arg3, acf);
        aab.bba(arg0 + 1, arg1 + 1, arg2 - 2, arg3 - 2, acg);
        aab.bba(arg0 + 2, arg1 + 2, arg2 - 4, arg3 - 4, ach);
        aab.bca(arg0, arg1, 2 + ada);
        aab.bca((arg0 + arg2) - 7, arg1, 3 + ada);
        aab.bca(arg0, (arg1 + arg3) - 7, 4 + ada);
        aab.bca((arg0 + arg2) - 7, (arg1 + arg3) - 7, 5 + ada);
    }

    protected void aba(int arg0, int arg1, int arg2)
    {
        aab.bca(arg0, arg1, arg2);
    }

    protected void abb(int arg0, int arg1, int arg2)
    {
        aab.bbb(arg0, arg1, arg2, 0);
    }

    protected void abc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8)
    {
        int i = arg4 / aab.bec(arg5);
        if(arg8 > arg7 - i)
            arg8 = arg7 - i;
        if(arg8 < 0)
            arg8 = 0;
        aai[arg0] = arg8;
        if(i < arg7)
        {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(abl == 1 && abi >= k && abi <= k + 12)
            {
                if(abj > arg2 && abj < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(abj > (arg2 + arg4) - 12 && abj < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                aai[arg0] = arg8;
            }
            if(abl == 1 && (abi >= k && abi <= k + 12 || abi >= k - 12 && abi <= k + 24 && aaf[arg0]))
            {
                if(abj > arg2 + 12 && abj < (arg2 + arg4) - 12)
                {
                    aaf[arg0] = true;
                    int i2 = abj - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    if(arg8 < 0)
                        arg8 = 0;
                    aai[arg0] = arg8;
                }
            } else
            {
                aaf[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            abd(arg1, arg2, arg3, arg4, k1, i1);
        }
        int l = arg4 - i * aab.bec(arg5);
        int j1 = arg2 + (aab.bec(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++)
        {
            aak(arg0, arg1 + 2, j1, arg6[l1], arg5);
            j1 += aab.bec(arg5) - ade;
            if(j1 >= arg2 + arg4)
                return;
        }

    }

    protected void abd(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5)
    {
        int i = (arg0 + arg2) - 12;
        aab.bba(i, arg1, 12, arg3, 0);
        aab.bca(i + 1, arg1 + 1, ada);
        aab.bca(i + 1, (arg1 + arg3) - 12, 1 + ada);
        aab.bbb(i, arg1 + 13, 12, 0);
        aab.bbb(i, (arg1 + arg3) - 13, 12, 0);
        aab.bam(i + 1, arg1 + 14, 11, arg3 - 27, aca, acb);
        aab.ban(i + 3, arg4 + arg1 + 14, 7, arg5, acd);
        aab.bbc(i + 2, arg4 + arg1 + 14, arg5, acc);
        aab.bbc(i + 2 + 8, arg4 + arg1 + 14, arg5, ace);
    }

    protected void abe(int arg0, int arg1, int arg2, int arg3, String arg4[])
    {
        int i = 0;
        int k = arg4.length;
        for(int l = 0; l < k; l++)
        {
            i += aab.bee(arg4[l], arg3);
            if(l < k - 1)
                i += aab.bee("  ", arg3);
        }

        int i1 = arg1 - i / 2;
        int j1 = arg2 + aab.bec(arg3) / 3;
        for(int k1 = 0; k1 < k; k1++)
        {
            int l1;
            if(aam[arg0])
                l1 = 0xffffff;
            else
                l1 = 0;
            if(abi >= i1 && abi <= i1 + aab.bee(arg4[k1], arg3) && abj <= j1 && abj > j1 - aab.bec(arg3))
            {
                if(aam[arg0])
                    l1 = 0x808080;
                else
                    l1 = 0xffffff;
                if(abk == 1)
                {
                    aak[arg0] = k1;
                    aah[arg0] = true;
                }
            }
            if(aak[arg0] == k1)
                if(aam[arg0])
                    l1 = 0xff0000;
                else
                    l1 = 0xc00000;
            aab.bdm(arg4[k1], i1, j1, arg3, l1);
            i1 += aab.bee(arg4[k1] + "  ", arg3);
        }

    }

    protected void abf(int arg0, int arg1, int arg2, int arg3, String arg4[])
    {
        int i = arg4.length;
        int k = arg2 - (aab.bec(arg3) * (i - 1)) / 2;
        for(int l = 0; l < i; l++)
        {
            int i1;
            if(aam[arg0])
                i1 = 0xffffff;
            else
                i1 = 0;
            int j1 = aab.bee(arg4[l], arg3);
            if(abi >= arg1 - j1 / 2 && abi <= arg1 + j1 / 2 && abj - 2 <= k && abj - 2 > k - aab.bec(arg3))
            {
                if(aam[arg0])
                    i1 = 0x808080;
                else
                    i1 = 0xffffff;
                if(abk == 1)
                {
                    aak[arg0] = l;
                    aah[arg0] = true;
                }
            }
            if(aak[arg0] == l)
                if(aam[arg0])
                    i1 = 0xff0000;
                else
                    i1 = 0xc00000;
            aab.bdm(arg4[l], arg1 - j1 / 2, k, arg3, i1);
            k += aab.bec(arg3);
        }

    }

    protected void abg(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, String arg6[], 
            int arg7, int arg8)
    {
        int i = arg4 / aab.bec(arg5);
        if(i < arg7)
        {
            int k = (arg1 + arg3) - 12;
            int i1 = ((arg4 - 27) * i) / arg7;
            if(i1 < 6)
                i1 = 6;
            int k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            if(abl == 1 && abi >= k && abi <= k + 12)
            {
                if(abj > arg2 && abj < arg2 + 12 && arg8 > 0)
                    arg8--;
                if(abj > (arg2 + arg4) - 12 && abj < arg2 + arg4 && arg8 < arg7 - i)
                    arg8++;
                aai[arg0] = arg8;
            }
            if(abl == 1 && (abi >= k && abi <= k + 12 || abi >= k - 12 && abi <= k + 24 && aaf[arg0]))
            {
                if(abj > arg2 + 12 && abj < (arg2 + arg4) - 12)
                {
                    aaf[arg0] = true;
                    int i2 = abj - arg2 - 12 - i1 / 2;
                    arg8 = (i2 * arg7) / (arg4 - 24);
                    if(arg8 < 0)
                        arg8 = 0;
                    if(arg8 > arg7 - i)
                        arg8 = arg7 - i;
                    aai[arg0] = arg8;
                }
            } else
            {
                aaf[arg0] = false;
            }
            k1 = ((arg4 - 27 - i1) * arg8) / (arg7 - i);
            abd(arg1, arg2, arg3, arg4, k1, i1);
        } else
        {
            arg8 = 0;
            aai[arg0] = 0;
        }
        aal[arg0] = -1;
        int l = arg4 - i * aab.bec(arg5);
        int j1 = arg2 + (aab.bec(arg5) * 5) / 6 + l / 2;
        for(int l1 = arg8; l1 < arg7; l1++)
        {
            int j2;
            if(aam[arg0])
                j2 = 0xffffff;
            else
                j2 = 0;
            if(abi >= arg1 + 2 && abi <= arg1 + 2 + aab.bee(arg6[l1], arg5) && abj - 2 <= j1 && abj - 2 > j1 - aab.bec(arg5))
            {
                if(aam[arg0])
                    j2 = 0x808080;
                else
                    j2 = 0xffffff;
                aal[arg0] = l1;
                if(abk == 1)
                {
                    aak[arg0] = l1;
                    aah[arg0] = true;
                }
            }
            if(aak[arg0] == l1 && acm)
                j2 = 0xff0000;
            aab.bdm(arg6[l1], arg1 + 2, j1, arg5, j2);
            j1 += aab.bec(arg5);
            if(j1 >= arg2 + arg4)
                return;
        }

    }

    public int abh(int arg0, int arg1, String arg2, int arg3, boolean arg4)
    {
        abb[aac] = 1;
        aae[aac] = true;
        aah[aac] = false;
        abf[aac] = arg3;
        aam[aac] = arg4;
        aan[aac] = arg0;
        aba[aac] = arg1;
        abg[aac] = arg2;
        return aac++;
    }

    public int abi(int arg0, int arg1, int arg2, int arg3)
    {
        abb[aac] = 2;
        aae[aac] = true;
        aah[aac] = false;
        aan[aac] = arg0 - arg2 / 2;
        aba[aac] = arg1 - arg3 / 2;
        abc[aac] = arg2;
        abd[aac] = arg3;
        return aac++;
    }

    public int abj(int arg0, int arg1, int arg2, int arg3)
    {
        abb[aac] = 11;
        aae[aac] = true;
        aah[aac] = false;
        aan[aac] = arg0 - arg2 / 2;
        aba[aac] = arg1 - arg3 / 2;
        abc[aac] = arg2;
        abd[aac] = arg3;
        return aac++;
    }

    public int abk(int arg0, int arg1, int arg2)
    {
        int i = aab.bbm[arg2];
        int k = aab.bbn[arg2];
        abb[aac] = 12;
        aae[aac] = true;
        aah[aac] = false;
        aan[aac] = arg0 - i / 2;
        aba[aac] = arg1 - k / 2;
        abc[aac] = i;
        abd[aac] = k;
        abf[aac] = arg2;
        return aac++;
    }

    public int abl(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6)
    {
        abb[aac] = 4;
        aae[aac] = true;
        aah[aac] = false;
        aan[aac] = arg0;
        aba[aac] = arg1;
        abc[aac] = arg2;
        abd[aac] = arg3;
        aam[aac] = arg6;
        abf[aac] = arg4;
        abe[aac] = arg5;
        aaj[aac] = 0;
        aai[aac] = 0;
        abh[aac] = new String[arg5];
        return aac++;
    }

    public int abm(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        abb[aac] = 5;
        aae[aac] = true;
        aag[aac] = arg6;
        aah[aac] = false;
        abf[aac] = arg4;
        aam[aac] = arg7;
        aan[aac] = arg0;
        aba[aac] = arg1;
        abc[aac] = arg2;
        abd[aac] = arg3;
        abe[aac] = arg5;
        abg[aac] = "";
        return aac++;
    }

    public int abn(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6, 
            boolean arg7)
    {
        abb[aac] = 6;
        aae[aac] = true;
        aag[aac] = arg6;
        aah[aac] = false;
        abf[aac] = arg4;
        aam[aac] = arg7;
        aan[aac] = arg0;
        aba[aac] = arg1;
        abc[aac] = arg2;
        abd[aac] = arg3;
        abe[aac] = arg5;
        abg[aac] = "";
        return aac++;
    }

    public int aca(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6)
    {
        abb[aac] = 9;
        aae[aac] = true;
        aah[aac] = false;
        abf[aac] = arg4;
        aam[aac] = arg6;
        aan[aac] = arg0;
        aba[aac] = arg1;
        abc[aac] = arg2;
        abd[aac] = arg3;
        abe[aac] = arg5;
        abh[aac] = new String[arg5];
        aaj[aac] = 0;
        aai[aac] = 0;
        aak[aac] = -1;
        aal[aac] = -1;
        return aac++;
    }

    public int acb(int arg0, int arg1, int arg2, int arg3)
    {
        abb[aac] = 10;
        aae[aac] = true;
        aah[aac] = false;
        aan[aac] = arg0 - arg2 / 2;
        aba[aac] = arg1 - arg3 / 2;
        abc[aac] = arg2;
        abd[aac] = arg3;
        return aac++;
    }

    public void acc(int arg0)
    {
        aaj[arg0] = 0;
    }

    public void acd(int arg0)
    {
        aai[arg0] = 0;
        aal[arg0] = -1;
    }

    public void ace(int arg0, int arg1, String arg2)
    {
        abh[arg0][arg1] = arg2;
        if(arg1 + 1 > aaj[arg0])
            aaj[arg0] = arg1 + 1;
    }

    public void acf(int arg0, String arg1, boolean arg2)
    {
        int i = aaj[arg0]++;
        if(i >= abe[arg0])
        {
            i--;
            aaj[arg0]--;
            for(int k = 0; k < i; k++)
                abh[arg0][k] = abh[arg0][k + 1];

        }
        abh[arg0][i] = arg1;
        if(arg2)
            aai[arg0] = 0xf423f;
    }

    public void acg(int arg0, String arg1)
    {
        abg[arg0] = arg1;
    }

    public String ach(int arg0)
    {
        if(abg[arg0] == null)
            return "null";
        else
            return abg[arg0];
    }

    public void aci(int arg0)
    {
        aae[arg0] = true;
    }

    public void acj(int arg0)
    {
        aae[arg0] = false;
    }

    public void ack(int arg0)
    {
        abm = arg0;
    }

    public int acl(int arg0)
    {
        int i = aal[arg0];
        return i;
    }

    protected j aab;
    int aac;
    int aad;
    public boolean aae[];
    public boolean aaf[];
    public boolean aag[];
    public boolean aah[];
    public int aai[];
    public int aaj[];
    public int aak[];
    public int aal[];
    boolean aam[];
    int aan[];
    int aba[];
    int abb[];
    int abc[];
    int abd[];
    int abe[];
    int abf[];
    String abg[];
    String abh[][];
    int abi;
    int abj;
    int abk;
    int abl;
    int abm;
    int abn;
    int aca;
    int acb;
    int acc;
    int acd;
    int ace;
    int acf;
    int acg;
    int ach;
    int aci;
    int acj;
    int ack;
    int acl;
    public boolean acm;
    public static boolean acn = true;
    public static int ada;
    public static int adb = 114;
    public static int adc = 114;
    public static int add = 176;
    public static int ade;

}