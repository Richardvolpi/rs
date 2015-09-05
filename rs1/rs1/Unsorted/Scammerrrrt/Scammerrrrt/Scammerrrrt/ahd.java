// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 


public class ahd
{

    public static int anm(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < ake; i++)
            if(amj[i].equalsIgnoreCase(s))
                return i;

        amj[ake++] = s;
        return ake - 1;
    }

    public static int ann()
    {
        int i = ani[ank] & 0xff;
        ank++;
        return i;
    }

    public static int baa()
    {
        int i = fnf.fnm(ani, ank);
        ank += 2;
        return i;
    }

    public static int bab()
    {
        int i = fnf.fnn(ani, ank);
        ank += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String bac()
    {
        String s;
        for(s = ""; anh[anj] != 0; s = s + (char)anh[anj++]);
        anj++;
        return s;
    }

    public static void bad(byte abyte0[], boolean flag)
    {
        boolean flag1 = false;
        anh = fnf.gak("string.dat", 0, abyte0);
        anj = 0;
        ani = fnf.gak("integer.dat", 0, abyte0);
        ank = 0;
        akc = baa();
        alm = new String[akc];
        aln = new String[akc];
        ama = new String[akc];
        ahj = new int[akc];
        ahk = new int[akc];
        ahl = new int[akc];
        ahm = new int[akc];
        ahn = new int[akc];
        aia = new int[akc];
        aib = new int[akc];
        aic = new int[akc];
        for(int i = 0; i < akc; i++)
            alm[i] = bac();

        for(int j = 0; j < akc; j++)
            aln[j] = bac();

        for(int k = 0; k < akc; k++)
            ama[k] = bac();

        for(int l = 0; l < akc; l++)
        {
            ahj[l] = baa();
            if(ahj[l] + 1 > akd)
                akd = ahj[l] + 1;
        }

        for(int i1 = 0; i1 < akc; i1++)
            ahk[i1] = bab();

        for(int j1 = 0; j1 < akc; j1++)
            ahl[j1] = ann();

        for(int k1 = 0; k1 < akc; k1++)
            ahm[k1] = ann();

        for(int l1 = 0; l1 < akc; l1++)
            ahn[l1] = baa();

        for(int i2 = 0; i2 < akc; i2++)
            aia[i2] = bab();

        for(int j2 = 0; j2 < akc; j2++)
            aib[j2] = ann();

        for(int k2 = 0; k2 < akc; k2++)
            aic[k2] = ann();

        for(int l2 = 0; l2 < akc; l2++)
            if(!flag && aic[l2] == 1)
            {
                alm[l2] = "Members object";
                aln[l2] = "You need to be a member to use this object";
                ahk[l2] = 0;
                ama[l2] = "";
                ahm[0] = 0;
                ahn[l2] = 0;
                aib[l2] = 1;
            }

        ajn = baa();
        akg = new String[ajn];
        akh = new String[ajn];
        aki = new String[ajn];
        ahe = new int[ajn];
        ahf = new int[ajn];
        ahg = new int[ajn];
        ahh = new int[ajn];
        ahi = new int[ajn];
        aii = new int[ajn][12];
        ajg = new int[ajn];
        ajh = new int[ajn];
        aji = new int[ajn];
        ajj = new int[ajn];
        ain = new int[ajn];
        aja = new int[ajn];
        aik = new int[ajn];
        ail = new int[ajn];
        aim = new int[ajn];
        for(int i3 = 0; i3 < ajn; i3++)
            akg[i3] = bac();

        for(int j3 = 0; j3 < ajn; j3++)
            akh[j3] = bac();

        for(int k3 = 0; k3 < ajn; k3++)
            ahe[k3] = ann();

        for(int l3 = 0; l3 < ajn; l3++)
            ahf[l3] = ann();

        for(int i4 = 0; i4 < ajn; i4++)
            ahg[i4] = ann();

        for(int j4 = 0; j4 < ajn; j4++)
            ahh[j4] = ann();

        for(int k4 = 0; k4 < ajn; k4++)
            ahi[k4] = ann();

        for(int l4 = 0; l4 < ajn; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                aii[l4][i5] = ann();
                if(aii[l4][i5] == 255)
                    aii[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < ajn; j5++)
            ajg[j5] = bab();

        for(int k5 = 0; k5 < ajn; k5++)
            ajh[k5] = bab();

        for(int l5 = 0; l5 < ajn; l5++)
            aji[l5] = bab();

        for(int i6 = 0; i6 < ajn; i6++)
            ajj[i6] = bab();

        for(int j6 = 0; j6 < ajn; j6++)
            ain[j6] = baa();

        for(int k6 = 0; k6 < ajn; k6++)
            aja[k6] = baa();

        for(int l6 = 0; l6 < ajn; l6++)
            aik[l6] = ann();

        for(int i7 = 0; i7 < ajn; i7++)
            ail[i7] = ann();

        for(int j7 = 0; j7 < ajn; j7++)
            aim[j7] = ann();

        for(int k7 = 0; k7 < ajn; k7++)
            aki[k7] = bac();

        akf = baa();
        aje = new String[akf];
        ajf = new String[akf];
        for(int l7 = 0; l7 < akf; l7++)
            aje[l7] = bac();

        for(int i8 = 0; i8 < akf; i8++)
            ajf[i8] = bac();

        alh = baa();
        all = new String[alh];
        aml = new int[alh];
        amm = new int[alh];
        amn = new int[alh];
        ana = new int[alh];
        anb = new int[alh];
        for(int j8 = 0; j8 < alh; j8++)
            all[j8] = bac();

        for(int k8 = 0; k8 < alh; k8++)
            aml[k8] = bab();

        for(int l8 = 0; l8 < alh; l8++)
            amm[l8] = ann();

        for(int i9 = 0; i9 < alh; i9++)
            amn[i9] = ann();

        for(int j9 = 0; j9 < alh; j9++)
            ana[j9] = ann();

        for(int k9 = 0; k9 < alh; k9++)
            anb[k9] = ann();

        ali = baa();
        amd = new String[ali];
        ame = new String[ali];
        amf = new String[ali];
        amg = new String[ali];
        akj = new int[ali];
        akk = new int[ali];
        akl = new int[ali];
        akm = new int[ali];
        akn = new int[ali];
        for(int l9 = 0; l9 < ali; l9++)
            amd[l9] = bac();

        for(int i10 = 0; i10 < ali; i10++)
            ame[i10] = bac();

        for(int j10 = 0; j10 < ali; j10++)
            amf[j10] = bac();

        for(int k10 = 0; k10 < ali; k10++)
            amg[k10] = bac();

        for(int l10 = 0; l10 < ali; l10++)
            akj[l10] = anm(bac());

        for(int i11 = 0; i11 < ali; i11++)
            akk[i11] = ann();

        for(int j11 = 0; j11 < ali; j11++)
            akl[j11] = ann();

        for(int k11 = 0; k11 < ali; k11++)
            akm[k11] = ann();

        for(int l11 = 0; l11 < ali; l11++)
            akn[l11] = ann();

        aka = baa();
        aie = new String[aka];
        aif = new String[aka];
        aig = new String[aka];
        aih = new String[aka];
        anc = new int[aka];
        and = new int[aka];
        ane = new int[aka];
        anf = new int[aka];
        ang = new int[aka];
        for(int i12 = 0; i12 < aka; i12++)
            aie[i12] = bac();

        for(int j12 = 0; j12 < aka; j12++)
            aif[j12] = bac();

        for(int k12 = 0; k12 < aka; k12++)
            aig[k12] = bac();

        for(int l12 = 0; l12 < aka; l12++)
            aih[l12] = bac();

        for(int i13 = 0; i13 < aka; i13++)
            anc[i13] = baa();

        for(int j13 = 0; j13 < aka; j13++)
            and[j13] = bab();

        for(int k13 = 0; k13 < aka; k13++)
            ane[k13] = bab();

        for(int l13 = 0; l13 < aka; l13++)
            anf[l13] = ann();

        for(int i14 = 0; i14 < aka; i14++)
            ang[i14] = ann();

        ajm = baa();
        amb = new int[ajm];
        amc = new int[ajm];
        for(int j14 = 0; j14 < ajm; j14++)
            amb[j14] = ann();

        for(int k14 = 0; k14 < ajm; k14++)
            amc[k14] = ann();

        ajk = baa();
        ajb = new int[ajk];
        ajc = new int[ajk];
        ajd = new int[ajk];
        for(int l14 = 0; l14 < ajk; l14++)
            ajb[l14] = bab();

        for(int i15 = 0; i15 < ajk; i15++)
            ajc[i15] = ann();

        for(int j15 = 0; j15 < ajk; j15++)
            ajd[j15] = ann();

        amk = baa();
        aid = baa();
        amh = new String[aid];
        ami = new String[aid];
        ala = new int[aid];
        alb = new int[aid];
        alc = new int[aid];
        ald = new int[aid][];
        ale = new int[aid][];
        for(int k15 = 0; k15 < aid; k15++)
            amh[k15] = bac();

        for(int l15 = 0; l15 < aid; l15++)
            ami[l15] = bac();

        for(int i16 = 0; i16 < aid; i16++)
            ala[i16] = ann();

        for(int j16 = 0; j16 < aid; j16++)
            alb[j16] = ann();

        for(int k16 = 0; k16 < aid; k16++)
            alc[k16] = ann();

        for(int l16 = 0; l16 < aid; l16++)
        {
            int i17 = ann();
            ald[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                ald[l16][k17] = baa();

        }

        for(int j17 = 0; j17 < aid; j17++)
        {
            int l17 = ann();
            ale[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                ale[j17][j18] = ann();

        }

        aij = baa();
        alf = new String[aij];
        alg = new String[aij];
        alj = new int[aij];
        alk = new int[aij];
        for(int i18 = 0; i18 < aij; i18++)
            alf[i18] = bac();

        for(int k18 = 0; k18 < aij; k18++)
            alg[k18] = bac();

        for(int l18 = 0; l18 < aij; l18++)
            alj[l18] = ann();

        for(int i19 = 0; i19 < aij; i19++)
            alk[i19] = ann();

        anh = null;
        ani = null;
    }

    public static int ahe[];
    public static int ahf[];
    public static int ahg[];
    public static int ahh[];
    public static int ahi[];
    public static int ahj[];
    public static int ahk[];
    public static int ahl[];
    public static int ahm[];
    public static int ahn[];
    public static int aia[];
    public static int aib[];
    public static int aic[];
    public static int aid;
    public static String aie[];
    public static String aif[];
    public static String aig[];
    public static String aih[];
    public static int aii[][];
    public static int aij;
    public static int aik[];
    public static int ail[];
    public static int aim[];
    public static int ain[];
    public static int aja[];
    public static int ajb[];
    public static int ajc[];
    public static int ajd[];
    public static String aje[];
    public static String ajf[];
    public static int ajg[];
    public static int ajh[];
    public static int aji[];
    public static int ajj[];
    public static int ajk;
    public static String ajl[] = new String[5000];
    public static int ajm;
    public static int ajn;
    public static int aka;
    public static String akb[] = new String[5000];
    public static int akc;
    public static int akd;
    public static int ake;
    public static int akf;
    public static String akg[];
    public static String akh[];
    public static String aki[];
    public static int akj[];
    public static int akk[];
    public static int akl[];
    public static int akm[];
    public static int akn[];
    public static int ala[];
    public static int alb[];
    public static int alc[];
    public static int ald[][];
    public static int ale[][];
    public static String alf[];
    public static String alg[];
    public static int alh;
    public static int ali;
    public static int alj[];
    public static int alk[];
    public static String all[];
    public static String alm[];
    public static String aln[];
    public static String ama[];
    public static int amb[];
    public static int amc[];
    public static String amd[];
    public static String ame[];
    public static String amf[];
    public static String amg[];
    public static String amh[];
    public static String ami[];
    public static String amj[] = new String[5000];
    public static int amk;
    public static int aml[];
    public static int amm[];
    public static int amn[];
    public static int ana[];
    public static int anb[];
    public static int anc[];
    public static int and[];
    public static int ane[];
    public static int anf[];
    public static int ang[];
    static byte anh[];
    static byte ani[];
    static int anj;
    static int ank;
    public static int anl;

}
