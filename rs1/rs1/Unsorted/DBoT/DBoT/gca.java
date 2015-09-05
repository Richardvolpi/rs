// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
public class gca
{
    public gca(blm blm1, int i)
    {
        gdm = -1;
        gem = true;
        gcb = blm1;
        gcd = i;
        gce = new boolean[i];
        gcf = new boolean[i];
        gcg = new boolean[i];
        gch = new boolean[i];
        gcm = new boolean[i];
        gci = new int[i];
        gcj = new int[i];
        gck = new int[i];
        gcl = new int[i];
        gcn = new int[i];
        gda = new int[i];
        gdb = new int[i];
        gdc = new int[i];
        gdd = new int[i];
        gde = new int[i];
        gdf = new int[i];
        gdg = new String[i];
        gdh = new String[i][];
        gea = gff(114, 114, 176);
        geb = gff(14, 14, 62);
        gec = gff(200, 208, 232);
        ged = gff(96, 129, 184);
        gee = gff(53, 95, 115);
        gef = gff(117, 142, 171);
        geg = gff(98, 122, 158);
        geh = gff(86, 100, 136);
        gei = gff(135, 146, 179);
        gej = gff(97, 112, 151);
        gek = gff(88, 102, 136);
        gel = gff(84, 93, 120);
    }
    public int gff(int i, int j, int k)
    {
        return blm.cca((gfb * i) / 114, (gfc * j) / 114, (gfd * k) / 176);
    }
    public void gfg(int i, int j, int k, int l)
    {
        boolean flag = false;
        gdi = i;
        gdj = j;
        gdl = l;
        if(k != 0)
            gdk = k;
        if(k == 1)
        {
            for(int i1 = 0; i1 < gcc; i1++)
            {
                if(gce[i1] && gdb[i1] == 10 && gdi >= gcn[i1] && gdj >= gda[i1] && gdi <= gcn[i1] + gdc[i1] && gdj <= gda[i1] + gdd[i1])
                    gch[i1] = true;
                if(gce[i1] && gdb[i1] == 14 && gdi >= gcn[i1] && gdj >= gda[i1] && gdi <= gcn[i1] + gdc[i1] && gdj <= gda[i1] + gdd[i1])
                    gck[i1] = 1 - gck[i1];
            }
        }
        if(l == 1)
            gdn++;
        else
            gdn = 0;
        if(k == 1 || gdn > 20)
        {
            for(int j1 = 0; j1 < gcc; j1++)
                if(gce[j1] && gdb[j1] == 15 && gdi >= gcn[j1] && gdj >= gda[j1] && gdi <= gcn[j1] + gdc[j1] && gdj <= gda[j1] + gdd[j1])
                    gch[j1] = true;
            gdn -= 5;
        }
    }
    public boolean gfh(int i)
    {
        if(gce[i] && gch[i])
        {
            gch[i] = false;
            return true;
        } else
        {
            return false;
        }
    }
    public void gfi(int i)
    {
        if(i == 0)
            return;
        if(gdm != -1 && gdg[gdm] != null && gce[gdm])
        {
            int j = gdg[gdm].length();
            if(i == 8 && j > 0)
                gdg[gdm] = gdg[gdm].substring(0, j - 1);
            if((i == 10 || i == 13) && j > 0)
                gch[gdm] = true;
            String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if(j < gde[gdm])
            {
                for(int k = 0; k < 95; k++)
                    if(i == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(k))
                        gdg[gdm] += (char)i;
            }
            if(i == 9)
            {
                do
                    gdm = (gdm + 1) % gcc;
                while(gdb[gdm] != 5 && gdb[gdm] != 6);
                return;
            }
        }
    }
    public void gfj()
    {
        boolean flag = false;
        for(int i = 0; i < gcc; i++)
            if(gce[i])
                if(gdb[i] == 0)
                    gfl(i, gcn[i], gda[i], gdg[i], gdf[i]);
                else
                if(gdb[i] == 1)
                    gfl(i, gcn[i] - gcb.cem(gdg[i], gdf[i]) / 2, gda[i], gdg[i], gdf[i]);
                else
                if(gdb[i] == 2)
                    gga(gcn[i], gda[i], gdc[i], gdd[i]);
                else
                if(gdb[i] == 3)
                    ggd(gcn[i], gda[i], gdc[i]);
                else
                if(gdb[i] == 4)
                    gge(i, gcn[i], gda[i], gdc[i], gdd[i], gdf[i], gdh[i], gcj[i], gci[i]);
                else
                if(gdb[i] == 5 || gdb[i] == 6)
                    gfn(i, gcn[i], gda[i], gdc[i], gdd[i], gdg[i], gdf[i]);
                else
                if(gdb[i] == 7)
                    ggg(i, gcn[i], gda[i], gdf[i], gdh[i]);
                else
                if(gdb[i] == 8)
                    ggh(i, gcn[i], gda[i], gdf[i], gdh[i]);
                else
                if(gdb[i] == 9)
                    ggi(i, gcn[i], gda[i], gdc[i], gdd[i], gdf[i], gdh[i], gcj[i], gci[i]);
                else
                if(gdb[i] == 11)
                    ggb(gcn[i], gda[i], gdc[i], gdd[i]);
                else
                if(gdb[i] == 12)
                    ggc(gcn[i], gda[i], gdf[i]);
                else
                if(gdb[i] == 14)
                    gfk(i, gcn[i], gda[i], gdc[i], gdd[i]);
        gdk = 0;
    }
    protected void gfk(int i, int j, int k, int l, int i1)
    {
        gcb.drawbox(j, k, l, i1, 0xffffff);
        gcb.cbj(j, k, l, gei);
        gcb.cbk(j, k, i1, gei);
        gcb.cbj(j, (k + i1) - 1, l, gel);
        gcb.cbk((j + l) - 1, k, i1, gel);
        if(gck[i] == 1)
        {
            for(int j1 = 0; j1 < i1; j1++)
            {
                gcb.cbj(j + j1, k + j1, 1, 0);
                gcb.cbj((j + l) - 1 - j1, k + j1, 1, 0);
            }
        }
    }
    protected void gfl(int i, int j, int k, String s, int l)
    {
        int i1 = k + gcb.cek(l) / 3;
        gfm(i, j, i1, s, l);
    }
    protected void gfm(int i, int j, int k, String s, int l)
    {
        int i1;
        if(gcm[i])
            i1 = 0xffffff;
        else
            i1 = 0;
        gcb.drawtext(s, j, k, l, i1);
    }
    protected void gfn(int i, int j, int k, int l, int i1, String s, int j1)
    {
        boolean flag = false;
        if(gcg[i])
        {
            int k1 = s.length();
            s = "";
            for(int i2 = 0; i2 < k1; i2++)
                s = s + "X";
        }
        if(gdb[i] == 5)
        {
            if(gdk == 1 && gdi >= j && gdj >= k - i1 / 2 && gdi <= j + l && gdj <= k + i1 / 2)
                gdm = i;
        } else
        if(gdb[i] == 6)
        {
            if(gdk == 1 && gdi >= j - l / 2 && gdj >= k - i1 / 2 && gdi <= j + l / 2 && gdj <= k + i1 / 2)
                gdm = i;
            j -= gcb.cem(s, j1) / 2;
        }
        if(gdm == i)
            s = s + "*";
        int l1 = k + gcb.cek(j1) / 3;
        gfm(i, j, l1, s, j1);
    }
    public void gga(int i, int j, int k, int l)
    {
        boolean flag = false;
        gcb.cba(i, j, i + k, j + l);
        gcb.cbg(i, j, k, l, gel, gei);
        if(gen)
        {
            for(int i1 = i - (j & 0x3f); i1 < i + k; i1 += 128)
            {
                for(int j1 = j - (j & 0x1f); j1 < j + l; j1 += 128)
                    gcb.cck(i1, j1, 6 + gfa, 128);
            }
        }
        gcb.cbj(i, j, k, gei);
        gcb.cbj(i + 1, j + 1, k - 2, gei);
        gcb.cbj(i + 2, j + 2, k - 4, gej);
        gcb.cbk(i, j, l, gei);
        gcb.cbk(i + 1, j + 1, l - 2, gei);
        gcb.cbk(i + 2, j + 2, l - 4, gej);
        gcb.cbj(i, (j + l) - 1, k, gel);
        gcb.cbj(i + 1, (j + l) - 2, k - 2, gel);
        gcb.cbj(i + 2, (j + l) - 3, k - 4, gek);
        gcb.cbk((i + k) - 1, j, l, gel);
        gcb.cbk((i + k) - 2, j + 1, l - 2, gel);
        gcb.cbk((i + k) - 3, j + 2, l - 4, gek);
        gcb.cbb();
    }
    public void ggb(int i, int j, int k, int l)
    {
        gcb.drawbox(i, j, k, l, 0);
        gcb.drawboxedge(i, j, k, l, gef);
        gcb.drawboxedge(i + 1, j + 1, k - 2, l - 2, geg);
        gcb.drawboxedge(i + 2, j + 2, k - 4, l - 4, geh);
        gcb.drawpic(i, j, 2 + gfa);
        gcb.drawpic((i + k) - 7, j, 3 + gfa);
        gcb.drawpic(i, (j + l) - 7, 4 + gfa);
        gcb.drawpic((i + k) - 7, (j + l) - 7, 5 + gfa);
    }
    protected void ggc(int i, int j, int k)
    {
        gcb.drawpic(i, j, k);
    }
    protected void ggd(int i, int j, int k)
    {
        gcb.cbj(i, j, k, 0);
    }
    protected void gge(int i, int j, int k, int l, int i1, int j1, String as[], 
            int k1, int l1)
    {
        boolean flag = false;
        int i2 = i1 / gcb.cek(j1);
        if(l1 > k1 - i2)
            l1 = k1 - i2;
        if(l1 < 0)
            l1 = 0;
        gci[i] = l1;
        if(i2 < k1)
        {
            int j2 = (j + l) - 12;
            int l2 = ((i1 - 27) * i2) / k1;
            if(l2 < 6)
                l2 = 6;
            int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            if(gdl == 1 && gdi >= j2 && gdi <= j2 + 12)
            {
                if(gdj > k && gdj < k + 12 && l1 > 0)
                    l1--;
                if(gdj > (k + i1) - 12 && gdj < k + i1 && l1 < k1 - i2)
                    l1++;
                gci[i] = l1;
            }
            if(gdl == 1 && (gdi >= j2 && gdi <= j2 + 12 || gdi >= j2 - 12 && gdi <= j2 + 24 && gcf[i]))
            {
                if(gdj > k + 12 && gdj < (k + i1) - 12)
                {
                    gcf[i] = true;
                    int l3 = gdj - k - 12 - l2 / 2;
                    l1 = (l3 * k1) / (i1 - 24);
                    if(l1 > k1 - i2)
                        l1 = k1 - i2;
                    if(l1 < 0)
                        l1 = 0;
                    gci[i] = l1;
                }
            } else
            {
                gcf[i] = false;
            }
            j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            ggf(j, k, l, i1, j3, l2);
        }
        int k2 = i1 - i2 * gcb.cek(j1);
        int i3 = k + (gcb.cek(j1) * 5) / 6 + k2 / 2;
        for(int k3 = l1; k3 < k1; k3++)
        {
            gfm(i, j + 2, i3, as[k3], j1);
            i3 += gcb.cek(j1) - gfe;
            if(i3 >= k + i1)
                return;
        }
    }
    protected void ggf(int i, int j, int k, int l, int i1, int j1)
    {
        int k1 = (i + k) - 12;
        gcb.drawboxedge(k1, j, 12, l, 0);
        gcb.drawpic(k1 + 1, j + 1, gfa);
        gcb.drawpic(k1 + 1, (j + l) - 12, 1 + gfa);
        gcb.cbj(k1, j + 13, 12, 0);
        gcb.cbj(k1, (j + l) - 13, 12, 0);
        gcb.cbg(k1 + 1, j + 14, 11, l - 27, gea, geb);
        gcb.drawbox(k1 + 3, i1 + j + 14, 7, j1, ged);
        gcb.cbk(k1 + 2, i1 + j + 14, j1, gec);
        gcb.cbk(k1 + 2 + 8, i1 + j + 14, j1, gee);
    }
    protected void ggg(int i, int j, int k, int l, String as[])
    {
        boolean flag = false;
        int i1 = 0;
        int j1 = as.length;
        for(int k1 = 0; k1 < j1; k1++)
        {
            i1 += gcb.cem(as[k1], l);
            if(k1 < j1 - 1)
                i1 += gcb.cem("  ", l);
        }
        int l1 = j - i1 / 2;
        int i2 = k + gcb.cek(l) / 3;
        for(int j2 = 0; j2 < j1; j2++)
        {
            int k2;
            if(gcm[i])
                k2 = 0xffffff;
            else
                k2 = 0;
            if(gdi >= l1 && gdi <= l1 + gcb.cem(as[j2], l) && gdj <= i2 && gdj > i2 - gcb.cek(l))
            {
                if(gcm[i])
                    k2 = 0x808080;
                else
                    k2 = 0xffffff;
                if(gdk == 1)
                {
                    gck[i] = j2;
                    gch[i] = true;
                }
            }
            if(gck[i] == j2)
                if(gcm[i])
                    k2 = 0xff0000;
                else
                    k2 = 0xc00000;
            gcb.drawtext(as[j2], l1, i2, l, k2);
            l1 += gcb.cem(as[j2] + "  ", l);
        }
    }
    protected void ggh(int i, int j, int k, int l, String as[])
    {
        boolean flag = false;
        int i1 = as.length;
        int j1 = k - (gcb.cek(l) * (i1 - 1)) / 2;
        for(int k1 = 0; k1 < i1; k1++)
        {
            int l1;
            if(gcm[i])
                l1 = 0xffffff;
            else
                l1 = 0;
            int i2 = gcb.cem(as[k1], l);
            if(gdi >= j - i2 / 2 && gdi <= j + i2 / 2 && gdj - 2 <= j1 && gdj - 2 > j1 - gcb.cek(l))
            {
                if(gcm[i])
                    l1 = 0x808080;
                else
                    l1 = 0xffffff;
                if(gdk == 1)
                {
                    gck[i] = k1;
                    gch[i] = true;
                }
            }
            if(gck[i] == k1)
                if(gcm[i])
                    l1 = 0xff0000;
                else
                    l1 = 0xc00000;
            gcb.drawtext(as[k1], j - i2 / 2, j1, l, l1);
            j1 += gcb.cek(l);
        }
    }
    protected void ggi(int i, int j, int k, int l, int i1, int j1, String as[], 
            int k1, int l1)
    {
        boolean flag = false;
        int i2 = i1 / gcb.cek(j1);
        if(i2 < k1)
        {
            int j2 = (j + l) - 12;
            int l2 = ((i1 - 27) * i2) / k1;
            if(l2 < 6)
                l2 = 6;
            int j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            if(gdl == 1 && gdi >= j2 && gdi <= j2 + 12)
            {
                if(gdj > k && gdj < k + 12 && l1 > 0)
                    l1--;
                if(gdj > (k + i1) - 12 && gdj < k + i1 && l1 < k1 - i2)
                    l1++;
                gci[i] = l1;
            }
            if(gdl == 1 && (gdi >= j2 && gdi <= j2 + 12 || gdi >= j2 - 12 && gdi <= j2 + 24 && gcf[i]))
            {
                if(gdj > k + 12 && gdj < (k + i1) - 12)
                {
                    gcf[i] = true;
                    int l3 = gdj - k - 12 - l2 / 2;
                    l1 = (l3 * k1) / (i1 - 24);
                    if(l1 < 0)
                        l1 = 0;
                    if(l1 > k1 - i2)
                        l1 = k1 - i2;
                    gci[i] = l1;
                }
            } else
            {
                gcf[i] = false;
            }
            j3 = ((i1 - 27 - l2) * l1) / (k1 - i2);
            ggf(j, k, l, i1, j3, l2);
        } else
        {
            l1 = 0;
            gci[i] = 0;
        }
        gcl[i] = -1;
        int k2 = i1 - i2 * gcb.cek(j1);
        int i3 = k + (gcb.cek(j1) * 5) / 6 + k2 / 2;
        for(int k3 = l1; k3 < k1; k3++)
        {
            int i4;
            if(gcm[i])
                i4 = 0xffffff;
            else
                i4 = 0;
            if(gdi >= j + 2 && gdi <= j + 2 + gcb.cem(as[k3], j1) && gdj - 2 <= i3 && gdj - 2 > i3 - gcb.cek(j1))
            {
                if(gcm[i])
                    i4 = 0x808080;
                else
                    i4 = 0xffffff;
                gcl[i] = k3;
                if(gdk == 1)
                {
                    gck[i] = k3;
                    gch[i] = true;
                }
            }
            if(gck[i] == k3 && gem)
                i4 = 0xff0000;
            gcb.drawtext(as[k3], j + 2, i3, j1, i4);
            i3 += gcb.cek(j1);
            if(i3 >= k + i1)
                return;
        }
    }
    public int ggj(int i, int j, String s, int k, boolean flag)
    {
        gdb[gcc] = 1;
        gce[gcc] = true;
        gch[gcc] = false;
        gdf[gcc] = k;
        gcm[gcc] = flag;
        gcn[gcc] = i;
        gda[gcc] = j;
        gdg[gcc] = s;
        return gcc++;
    }
    public int ggk(int i, int j, int k, int l)
    {
        gdb[gcc] = 2;
        gce[gcc] = true;
        gch[gcc] = false;
        gcn[gcc] = i - k / 2;
        gda[gcc] = j - l / 2;
        gdc[gcc] = k;
        gdd[gcc] = l;
        return gcc++;
    }
    public int ggl(int i, int j, int k, int l)
    {
        gdb[gcc] = 11;
        gce[gcc] = true;
        gch[gcc] = false;
        gcn[gcc] = i - k / 2;
        gda[gcc] = j - l / 2;
        gdc[gcc] = k;
        gdd[gcc] = l;
        return gcc++;
    }
    public int ggm(int i, int j, int k)
    {
        int l = gcb.bmm[k];
        int i1 = gcb.bmn[k];
        gdb[gcc] = 12;
        gce[gcc] = true;
        gch[gcc] = false;
        gcn[gcc] = i - l / 2;
        gda[gcc] = j - i1 / 2;
        gdc[gcc] = l;
        gdd[gcc] = i1;
        gdf[gcc] = k;
        return gcc++;
    }
    public int ggn(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        gdb[gcc] = 4;
        gce[gcc] = true;
        gch[gcc] = false;
        gcn[gcc] = i;
        gda[gcc] = j;
        gdc[gcc] = k;
        gdd[gcc] = l;
        gcm[gcc] = flag;
        gdf[gcc] = i1;
        gde[gcc] = j1;
        gcj[gcc] = 0;
        gci[gcc] = 0;
        gdh[gcc] = new String[j1];
        return gcc++;
    }
    public int gha(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        gdb[gcc] = 5;
        gce[gcc] = true;
        gcg[gcc] = flag;
        gch[gcc] = false;
        gdf[gcc] = i1;
        gcm[gcc] = flag1;
        gcn[gcc] = i;
        gda[gcc] = j;
        gdc[gcc] = k;
        gdd[gcc] = l;
        gde[gcc] = j1;
        gdg[gcc] = "";
        return gcc++;
    }
    public int ghb(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
        gdb[gcc] = 6;
        gce[gcc] = true;
        gcg[gcc] = flag;
        gch[gcc] = false;
        gdf[gcc] = i1;
        gcm[gcc] = flag1;
        gcn[gcc] = i;
        gda[gcc] = j;
        gdc[gcc] = k;
        gdd[gcc] = l;
        gde[gcc] = j1;
        gdg[gcc] = "";
        return gcc++;
    }
    public int ghc(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        gdb[gcc] = 9;
        gce[gcc] = true;
        gch[gcc] = false;
        gdf[gcc] = i1;
        gcm[gcc] = flag;
        gcn[gcc] = i;
        gda[gcc] = j;
        gdc[gcc] = k;
        gdd[gcc] = l;
        gde[gcc] = j1;
        gdh[gcc] = new String[j1];
        gcj[gcc] = 0;
        gci[gcc] = 0;
        gck[gcc] = -1;
        gcl[gcc] = -1;
        return gcc++;
    }
    public int ghd(int i, int j, int k, int l)
    {
        gdb[gcc] = 10;
        gce[gcc] = true;
        gch[gcc] = false;
        gcn[gcc] = i - k / 2;
        gda[gcc] = j - l / 2;
        gdc[gcc] = k;
        gdd[gcc] = l;
        return gcc++;
    }
    public void ghe(int i)
    {
        gcj[i] = 0;
    }
    public void ghf(int i)
    {
        gci[i] = 0;
        gcl[i] = -1;
    }
    public void ghg(int i, int j, String s)
    {
        gdh[i][j] = s;
        if(j + 1 > gcj[i])
            gcj[i] = j + 1;
    }
    public void ghh(int i, String s, boolean flag)
    {
        int j = gcj[i]++;
        if(j >= gde[i])
        {
            j--;
            gcj[i]--;
            for(int k = 0; k < j; k++)
                gdh[i][k] = gdh[i][k + 1];
        }
        gdh[i][j] = s;
        if(flag)
            gci[i] = 0xf423f;
    }
    public void ghi(int i, String s)
    {
        gdg[i] = s;
    }
    public String ghj(int i)
    {
        if(gdg[i] == null)
            return "null";
        else
            return gdg[i];
    }
    public void ghk(int i)
    {
        gce[i] = true;
    }
    public void ghl(int i)
    {
        gce[i] = false;
    }
    public void ghm(int i)
    {
        gdm = i;
    }
    public int ghn(int i)
    {
        int j = gcl[i];
        return j;
    }
    protected blm gcb;
    int gcc;
    int gcd;
    public boolean gce[];
    public boolean gcf[];
    public boolean gcg[];
    public boolean gch[];
    public int gci[];
    public int gcj[];
    public int gck[];
    public int gcl[];
    boolean gcm[];
    int gcn[];
    int gda[];
    int gdb[];
    int gdc[];
    int gdd[];
    int gde[];
    int gdf[];
    String gdg[];
    String gdh[][];
    int gdi;
    int gdj;
    int gdk;
    int gdl;
    int gdm;
    int gdn;
    int gea;
    int geb;
    int gec;
    int ged;
    int gee;
    int gef;
    int geg;
    int geh;
    int gei;
    int gej;
    int gek;
    int gel;
    public boolean gem;
    public static boolean gen = true;
    public static int gfa;
    public static int gfb = 114;
    public static int gfc = 114;
    public static int gfd = 176;
    public static int gfe;
}
