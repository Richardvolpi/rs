// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 


public class ahd
{

    public static int anm(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < ail; i++)
            if(alm[i].equalsIgnoreCase(s))
                return i;

        alm[ail++] = s;
        return ail - 1;
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
        ali = baa();
        amb = new String[ali];
        amc = new String[ali];
        amd = new String[ali];
        ajd = new int[ali];
        aje = new int[ali];
        ajf = new int[ali];
        ajg = new int[ali];
        ajh = new int[ali];
        aji = new int[ali];
        ajj = new int[ali];
        ajk = new int[ali];
        for(int i = 0; i < ali; i++)
            amb[i] = bac();

        for(int j = 0; j < ali; j++)
            amc[j] = bac();

        for(int k = 0; k < ali; k++)
            amd[k] = bac();

        for(int l = 0; l < ali; l++)
        {
            ajd[l] = baa();
            if(ajd[l] + 1 > alj)
                alj = ajd[l] + 1;
        }

        for(int i1 = 0; i1 < ali; i1++)
            aje[i1] = bab();

        for(int j1 = 0; j1 < ali; j1++)
            ajf[j1] = ann();

        for(int k1 = 0; k1 < ali; k1++)
            ajg[k1] = ann();

        for(int l1 = 0; l1 < ali; l1++)
            ajh[l1] = baa();

        for(int i2 = 0; i2 < ali; i2++)
            aji[i2] = bab();

        for(int j2 = 0; j2 < ali; j2++)
            ajj[j2] = ann();

        for(int k2 = 0; k2 < ali; k2++)
            ajk[k2] = ann();

        for(int l2 = 0; l2 < ali; l2++)
            if(!flag && ajk[l2] == 1)
            {
                amb[l2] = "Members object";
                amc[l2] = "You need to be a member to use this object";
                aje[l2] = 0;
                amd[l2] = "";
                ajg[0] = 0;
                ajh[l2] = 0;
                ajj[l2] = 1;
            }

        ang = baa();
        amn = new String[ang];
        ana = new String[ang];
        anb = new String[ang];
        ahj = new int[ang];
        ahk = new int[ang];
        ahl = new int[ang];
        ahm = new int[ang];
        ahn = new int[ang];
        aja = new int[ang][12];
        anc = new int[ang];
        and = new int[ang];
        ane = new int[ang];
        anf = new int[ang];
        aid = new int[ang];
        aie = new int[ang];
        aif = new int[ang];
        aig = new int[ang];
        aih = new int[ang];
        for(int i3 = 0; i3 < ang; i3++)
            amn[i3] = bac();

        for(int j3 = 0; j3 < ang; j3++)
            ana[j3] = bac();

        for(int k3 = 0; k3 < ang; k3++)
            ahj[k3] = ann();

        for(int l3 = 0; l3 < ang; l3++)
            ahk[l3] = ann();

        for(int i4 = 0; i4 < ang; i4++)
            ahl[i4] = ann();

        for(int j4 = 0; j4 < ang; j4++)
            ahm[j4] = ann();

        for(int k4 = 0; k4 < ang; k4++)
            ahn[k4] = ann();

        for(int l4 = 0; l4 < ang; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                aja[l4][i5] = ann();
                if(aja[l4][i5] == 255)
                    aja[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < ang; j5++)
            anc[j5] = bab();

        for(int k5 = 0; k5 < ang; k5++)
            and[k5] = bab();

        for(int l5 = 0; l5 < ang; l5++)
            ane[l5] = bab();

        for(int i6 = 0; i6 < ang; i6++)
            anf[i6] = bab();

        for(int j6 = 0; j6 < ang; j6++)
            aid[j6] = baa();

        for(int k6 = 0; k6 < ang; k6++)
            aie[k6] = baa();

        for(int l6 = 0; l6 < ang; l6++)
            aif[l6] = ann();

        for(int i7 = 0; i7 < ang; i7++)
            aig[i7] = ann();

        for(int j7 = 0; j7 < ang; j7++)
            aih[j7] = ann();

        for(int k7 = 0; k7 < ang; k7++)
            anb[k7] = bac();

        amm = baa();
        amf = new String[amm];
        amg = new String[amm];
        for(int l7 = 0; l7 < amm; l7++)
            amf[l7] = bac();

        for(int i8 = 0; i8 < amm; i8++)
            amg[i8] = bac();

        all = baa();
        alk = new String[all];
        ajl = new int[all];
        ajm = new int[all];
        ajn = new int[all];
        aka = new int[all];
        akb = new int[all];
        for(int j8 = 0; j8 < all; j8++)
            alk[j8] = bac();

        for(int k8 = 0; k8 < all; k8++)
            ajl[k8] = bab();

        for(int l8 = 0; l8 < all; l8++)
            ajm[l8] = ann();

        for(int i9 = 0; i9 < all; i9++)
            ajn[i9] = ann();

        for(int j9 = 0; j9 < all; j9++)
            aka[j9] = ann();

        for(int k9 = 0; k9 < all; k9++)
            akb[k9] = ann();

        ale = baa();
        akh = new String[ale];
        aki = new String[ale];
        akj = new String[ale];
        akk = new String[ale];
        amh = new int[ale];
        ami = new int[ale];
        amj = new int[ale];
        amk = new int[ale];
        aml = new int[ale];
        for(int l9 = 0; l9 < ale; l9++)
            akh[l9] = bac();

        for(int i10 = 0; i10 < ale; i10++)
            aki[i10] = bac();

        for(int j10 = 0; j10 < ale; j10++)
            akj[j10] = bac();

        for(int k10 = 0; k10 < ale; k10++)
            akk[k10] = bac();

        for(int l10 = 0; l10 < ale; l10++)
            amh[l10] = anm(bac());

        for(int i11 = 0; i11 < ale; i11++)
            ami[i11] = ann();

        for(int j11 = 0; j11 < ale; j11++)
            amj[j11] = ann();

        for(int k11 = 0; k11 < ale; k11++)
            amk[k11] = ann();

        for(int l11 = 0; l11 < ale; l11++)
            aml[l11] = ann();

        ajc = baa();
        akl = new String[ajc];
        akm = new String[ajc];
        akn = new String[ajc];
        ala = new String[ajc];
        akc = new int[ajc];
        akd = new int[ajc];
        ake = new int[ajc];
        akf = new int[ajc];
        akg = new int[ajc];
        for(int i12 = 0; i12 < ajc; i12++)
            akl[i12] = bac();

        for(int j12 = 0; j12 < ajc; j12++)
            akm[j12] = bac();

        for(int k12 = 0; k12 < ajc; k12++)
            akn[k12] = bac();

        for(int l12 = 0; l12 < ajc; l12++)
            ala[l12] = bac();

        for(int i13 = 0; i13 < ajc; i13++)
            akc[i13] = baa();

        for(int j13 = 0; j13 < ajc; j13++)
            akd[j13] = bab();

        for(int k13 = 0; k13 < ajc; k13++)
            ake[k13] = bab();

        for(int l13 = 0; l13 < ajc; l13++)
            akf[l13] = ann();

        for(int i14 = 0; i14 < ajc; i14++)
            akg[i14] = ann();

        aln = baa();
        alg = new int[aln];
        alh = new int[aln];
        for(int j14 = 0; j14 < aln; j14++)
            alg[j14] = ann();

        for(int k14 = 0; k14 < aln; k14++)
            alh[k14] = ann();

        ame = baa();
        alb = new int[ame];
        alc = new int[ame];
        ald = new int[ame];
        for(int l14 = 0; l14 < ame; l14++)
            alb[l14] = bab();

        for(int i15 = 0; i15 < ame; i15++)
            alc[i15] = ann();

        for(int j15 = 0; j15 < ame; j15++)
            ald[j15] = ann();

        alf = baa();
        aii = baa();
        aij = new String[aii];
        aik = new String[aii];
        ahe = new int[aii];
        ahf = new int[aii];
        ahg = new int[aii];
        ahh = new int[aii][];
        ahi = new int[aii][];
        for(int k15 = 0; k15 < aii; k15++)
            aij[k15] = bac();

        for(int l15 = 0; l15 < aii; l15++)
            aik[l15] = bac();

        for(int i16 = 0; i16 < aii; i16++)
            ahe[i16] = ann();

        for(int j16 = 0; j16 < aii; j16++)
            ahf[j16] = ann();

        for(int k16 = 0; k16 < aii; k16++)
            ahg[k16] = ann();

        for(int l16 = 0; l16 < aii; l16++)
        {
            int i17 = ann();
            ahh[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                ahh[l16][k17] = baa();

        }

        for(int j17 = 0; j17 < aii; j17++)
        {
            int l17 = ann();
            ahi[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                ahi[j17][j18] = ann();

        }

        ajb = baa();
        aia = new String[ajb];
        aib = new String[ajb];
        aim = new int[ajb];
        ain = new int[ajb];
        for(int i18 = 0; i18 < ajb; i18++)
            aia[i18] = bac();

        for(int k18 = 0; k18 < ajb; k18++)
            aib[k18] = bac();

        for(int l18 = 0; l18 < ajb; l18++)
            aim[l18] = ann();

        for(int i19 = 0; i19 < ajb; i19++)
            ain[i19] = ann();

        anh = null;
        ani = null;
    }

    public static int ahe[];
    public static int ahf[];
    public static int ahg[];
    public static int ahh[][];
    public static int ahi[][];
    public static int ahj[];
    public static int ahk[];
    public static int ahl[];
    public static int ahm[];
    public static int ahn[];
    public static String aia[];
    public static String aib[];
    public static String aic[] = new String[5000];
    public static int aid[];
    public static int aie[];
    public static int aif[];
    public static int aig[];
    public static int aih[];
    public static int aii;
    public static String aij[];
    public static String aik[];
    public static int ail;
    public static int aim[];
    public static int ain[];
    public static int aja[][];
    public static int ajb;
    public static int ajc;
    public static int ajd[];
    public static int aje[];
    public static int ajf[];
    public static int ajg[];
    public static int ajh[];
    public static int aji[];
    public static int ajj[];
    public static int ajk[];
    public static int ajl[];
    public static int ajm[];
    public static int ajn[];
    public static int aka[];
    public static int akb[];
    public static int akc[];
    public static int akd[];
    public static int ake[];
    public static int akf[];
    public static int akg[];
    public static String akh[];
    public static String aki[];
    public static String akj[];
    public static String akk[];
    public static String akl[];
    public static String akm[];
    public static String akn[];
    public static String ala[];
    public static int alb[];
    public static int alc[];
    public static int ald[];
    public static int ale;
    public static int alf;
    public static int alg[];
    public static int alh[];
    public static int ali;
    public static int alj;
    public static String alk[];
    public static int all;
    public static String alm[] = new String[5000];
    public static int aln;
    public static String ama[] = new String[5000];
    public static String amb[];
    public static String amc[];
    public static String amd[];
    public static int ame;
    public static String amf[];
    public static String amg[];
    public static int amh[];
    public static int ami[];
    public static int amj[];
    public static int amk[];
    public static int aml[];
    public static int amm;
    public static String amn[];
    public static String ana[];
    public static String anb[];
    public static int anc[];
    public static int and[];
    public static int ane[];
    public static int anf[];
    public static int ang;
    static byte anh[];
    static byte ani[];
    static int anj;
    static int ank;
    public static int anl;

}
