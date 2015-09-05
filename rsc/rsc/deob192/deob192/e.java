// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:47:38 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


public class e
{

    public static int cji(String arg0)
    {
        if(arg0.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < emn; i++)
            if(ejf[i].equalsIgnoreCase(arg0))
                return i;

        ejf[emn++] = arg0;
        return emn - 1;
    }

    public static int cjj()
    {
        int i = fan[fbb] & 0xff;
        fbb++;
        return i;
    }

    public static int cjk()
    {
        int i = t.amm(fan, fbb);
        fbb += 2;
        return i;
    }

    public static int cjl()
    {
        int i = t.amn(fan, fbb);
        fbb += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String cjm()
    {
        String s;
        for(s = ""; fam[fba] != 0; s = s + (char)fam[fba++]);
        fba++;
        return s;
    }

    public static void cjn(byte arg0[], boolean arg1)
    {
        fam = t.ank("string.dat", 0, arg0);
        fba = 0;
        fan = t.ank("integer.dat", 0, arg0);
        fbb = 0;
        ena = cjk();
        ekj = new String[ena];
        ekk = new String[ena];
        ekl = new String[ena];
        ejh = new int[ena];
        eji = new int[ena];
        ejj = new int[ena];
        ejk = new int[ena];
        ejl = new int[ena];
        ejm = new int[ena];
        ejn = new int[ena];
        eka = new int[ena];
        for(int i = 0; i < ena; i++)
            ekj[i] = cjm();

        for(int j = 0; j < ena; j++)
            ekk[j] = cjm();

        for(int k = 0; k < ena; k++)
            ekl[k] = cjm();

        for(int l = 0; l < ena; l++)
        {
            ejh[l] = cjk();
            if(ejh[l] + 1 > enb)
                enb = ejh[l] + 1;
        }

        for(int i1 = 0; i1 < ena; i1++)
            eji[i1] = cjl();

        for(int j1 = 0; j1 < ena; j1++)
            ejj[j1] = cjj();

        for(int k1 = 0; k1 < ena; k1++)
            ejk[k1] = cjj();

        for(int l1 = 0; l1 < ena; l1++)
            ejl[l1] = cjk();

        for(int i2 = 0; i2 < ena; i2++)
            ejm[i2] = cjl();

        for(int j2 = 0; j2 < ena; j2++)
            ejn[j2] = cjj();

        for(int k2 = 0; k2 < ena; k2++)
            eka[k2] = cjj();

        for(int l2 = 0; l2 < ena; l2++)
            if(!arg1 && eka[l2] == 1)
            {
                ekj[l2] = "Members object";
                ekk[l2] = "You need to be a member to use this object";
                eji[l2] = 0;
                ekl[l2] = "";
                ejk[0] = 0;
                ejl[l2] = 0;
                ejn[l2] = 1;
            }

        emm = cjk();
        eij = new String[emm];
        eik = new String[emm];
        eil = new String[emm];
        eim = new int[emm];
        ein = new int[emm];
        eja = new int[emm];
        ejb = new int[emm];
        ejc = new int[emm];
        ekg = new int[emm][12];
        emh = new int[emm];
        emi = new int[emm];
        emj = new int[emm];
        emk = new int[emm];
        eme = new int[emm];
        emf = new int[emm];
        ekb = new int[emm];
        ekc = new int[emm];
        ekd = new int[emm];
        for(int i3 = 0; i3 < emm; i3++)
            eij[i3] = cjm();

        for(int j3 = 0; j3 < emm; j3++)
            eik[j3] = cjm();

        for(int k3 = 0; k3 < emm; k3++)
            eim[k3] = cjj();

        for(int l3 = 0; l3 < emm; l3++)
            ein[l3] = cjj();

        for(int i4 = 0; i4 < emm; i4++)
            eja[i4] = cjj();

        for(int j4 = 0; j4 < emm; j4++)
            ejb[j4] = cjj();

        for(int k4 = 0; k4 < emm; k4++)
            ejc[k4] = cjj();

        for(int l4 = 0; l4 < emm; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                ekg[l4][i5] = cjj();
                if(ekg[l4][i5] == 255)
                    ekg[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < emm; j5++)
            emh[j5] = cjl();

        for(int k5 = 0; k5 < emm; k5++)
            emi[k5] = cjl();

        for(int l5 = 0; l5 < emm; l5++)
            emj[l5] = cjl();

        for(int i6 = 0; i6 < emm; i6++)
            emk[i6] = cjl();

        for(int j6 = 0; j6 < emm; j6++)
            eme[j6] = cjk();

        for(int k6 = 0; k6 < emm; k6++)
            emf[k6] = cjk();

        for(int l6 = 0; l6 < emm; l6++)
            ekb[l6] = cjj();

        for(int i7 = 0; i7 < emm; i7++)
            ekc[i7] = cjj();

        for(int j7 = 0; j7 < emm; j7++)
            ekd[j7] = cjj();

        for(int k7 = 0; k7 < emm; k7++)
            eil[k7] = cjm();

        eml = cjk();
        ele = new String[eml];
        elf = new String[eml];
        for(int l7 = 0; l7 < eml; l7++)
            ele[l7] = cjm();

        for(int i8 = 0; i8 < eml; i8++)
            elf[i8] = cjm();

        ekh = cjk();
        end = new String[ekh];
        ell = new int[ekh];
        elm = new int[ekh];
        eln = new int[ekh];
        ema = new int[ekh];
        emb = new int[ekh];
        for(int j8 = 0; j8 < ekh; j8++)
            end[j8] = cjm();

        for(int k8 = 0; k8 < ekh; k8++)
            ell[k8] = cjl();

        for(int l8 = 0; l8 < ekh; l8++)
            elm[l8] = cjj();

        for(int i9 = 0; i9 < ekh; i9++)
            eln[i9] = cjj();

        for(int j9 = 0; j9 < ekh; j9++)
            ema[j9] = cjj();

        for(int k9 = 0; k9 < ekh; k9++)
            emb[k9] = cjj();

        ejd = cjk();
        fai = new String[ejd];
        faj = new String[ejd];
        fak = new String[ejd];
        fal = new String[ejd];
        enk = new int[ejd];
        enl = new int[ejd];
        enm = new int[ejd];
        enn = new int[ejd];
        faa = new int[ejd];
        for(int l9 = 0; l9 < ejd; l9++)
            fai[l9] = cjm();

        for(int i10 = 0; i10 < ejd; i10++)
            faj[i10] = cjm();

        for(int j10 = 0; j10 < ejd; j10++)
            fak[j10] = cjm();

        for(int k10 = 0; k10 < ejd; k10++)
            fal[k10] = cjm();

        for(int l10 = 0; l10 < ejd; l10++)
            enk[l10] = cji(cjm());

        for(int i11 = 0; i11 < ejd; i11++)
            enl[i11] = cjj();

        for(int j11 = 0; j11 < ejd; j11++)
            enm[j11] = cjj();

        for(int k11 = 0; k11 < ejd; k11++)
            enn[k11] = cjj();

        for(int l11 = 0; l11 < ejd; l11++)
            faa[l11] = cjj();

        ene = cjk();
        enf = new String[ene];
        eng = new String[ene];
        enh = new String[ene];
        eni = new String[ene];
        elg = new int[ene];
        elh = new int[ene];
        eli = new int[ene];
        elj = new int[ene];
        elk = new int[ene];
        for(int i12 = 0; i12 < ene; i12++)
            enf[i12] = cjm();

        for(int j12 = 0; j12 < ene; j12++)
            eng[j12] = cjm();

        for(int k12 = 0; k12 < ene; k12++)
            enh[k12] = cjm();

        for(int l12 = 0; l12 < ene; l12++)
            eni[l12] = cjm();

        for(int i13 = 0; i13 < ene; i13++)
            elg[i13] = cjk();

        for(int j13 = 0; j13 < ene; j13++)
            elh[j13] = cjl();

        for(int k13 = 0; k13 < ene; k13++)
            eli[k13] = cjl();

        for(int l13 = 0; l13 < ene; l13++)
            elj[l13] = cjj();

        for(int i14 = 0; i14 < ene; i14++)
            elk[i14] = cjj();

        eki = cjk();
        fab = new int[eki];
        fac = new int[eki];
        for(int j14 = 0; j14 < eki; j14++)
            fab[j14] = cjj();

        for(int k14 = 0; k14 < eki; k14++)
            fac[k14] = cjj();

        enj = cjk();
        ekm = new int[enj];
        ekn = new int[enj];
        ela = new int[enj];
        for(int l14 = 0; l14 < enj; l14++)
            ekm[l14] = cjl();

        for(int i15 = 0; i15 < enj; i15++)
            ekn[i15] = cjj();

        for(int j15 = 0; j15 < enj; j15++)
            ela[j15] = cjj();

        ejg = cjk();
        enc = cjk();
        elb = new String[enc];
        elc = new String[enc];
        fad = new int[enc];
        fae = new int[enc];
        faf = new int[enc];
        fag = new int[enc][];
        fah = new int[enc][];
        for(int k15 = 0; k15 < enc; k15++)
            elb[k15] = cjm();

        for(int l15 = 0; l15 < enc; l15++)
            elc[l15] = cjm();

        for(int i16 = 0; i16 < enc; i16++)
            fad[i16] = cjj();

        for(int j16 = 0; j16 < enc; j16++)
            fae[j16] = cjj();

        for(int k16 = 0; k16 < enc; k16++)
            faf[k16] = cjj();

        for(int l16 = 0; l16 < enc; l16++)
        {
            int i17 = cjj();
            fag[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                fag[l16][k17] = cjk();

        }

        for(int j17 = 0; j17 < enc; j17++)
        {
            int l17 = cjj();
            fah[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                fah[j17][j18] = cjj();

        }

        eje = cjk();
        emc = new String[eje];
        emd = new String[eje];
        eke = new int[eje];
        ekf = new int[eje];
        for(int i18 = 0; i18 < eje; i18++)
            emc[i18] = cjm();

        for(int k18 = 0; k18 < eje; k18++)
            emd[k18] = cjm();

        for(int l18 = 0; l18 < eje; l18++)
            eke[l18] = cjj();

        for(int i19 = 0; i19 < eje; i19++)
            ekf[i19] = cjj();

        fam = null;
        fan = null;
    }

    public static String eij[];
    public static String eik[];
    public static String eil[];
    public static int eim[];
    public static int ein[];
    public static int eja[];
    public static int ejb[];
    public static int ejc[];
    public static int ejd;
    public static int eje;
    public static String ejf[] = new String[5000];
    public static int ejg;
    public static int ejh[];
    public static int eji[];
    public static int ejj[];
    public static int ejk[];
    public static int ejl[];
    public static int ejm[];
    public static int ejn[];
    public static int eka[];
    public static int ekb[];
    public static int ekc[];
    public static int ekd[];
    public static int eke[];
    public static int ekf[];
    public static int ekg[][];
    public static int ekh;
    public static int eki;
    public static String ekj[];
    public static String ekk[];
    public static String ekl[];
    public static int ekm[];
    public static int ekn[];
    public static int ela[];
    public static String elb[];
    public static String elc[];
    public static String eld[] = new String[5000];
    public static String ele[];
    public static String elf[];
    public static int elg[];
    public static int elh[];
    public static int eli[];
    public static int elj[];
    public static int elk[];
    public static int ell[];
    public static int elm[];
    public static int eln[];
    public static int ema[];
    public static int emb[];
    public static String emc[];
    public static String emd[];
    public static int eme[];
    public static int emf[];
    public static String emg[] = new String[5000];
    public static int emh[];
    public static int emi[];
    public static int emj[];
    public static int emk[];
    public static int eml;
    public static int emm;
    public static int emn;
    public static int ena;
    public static int enb;
    public static int enc;
    public static String end[];
    public static int ene;
    public static String enf[];
    public static String eng[];
    public static String enh[];
    public static String eni[];
    public static int enj;
    public static int enk[];
    public static int enl[];
    public static int enm[];
    public static int enn[];
    public static int faa[];
    public static int fab[];
    public static int fac[];
    public static int fad[];
    public static int fae[];
    public static int faf[];
    public static int fag[][];
    public static int fah[][];
    public static String fai[];
    public static String faj[];
    public static String fak[];
    public static String fal[];
    static byte fam[];
    static byte fan[];
    static int fba;
    static int fbb;
    public static int fbc;

}