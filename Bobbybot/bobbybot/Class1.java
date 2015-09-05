// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 


public class Class1 {

    public static int method123(String s) {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < anInt109; i++)
            if(aStringArray98[i].equalsIgnoreCase(s))
                return i;

        aStringArray98[anInt109++] = s;
        return anInt109 - 1;
    }

    public static int method124() {
        int i = aByteArray141[anInt143] & 0xff;
        anInt143++;
        return i;
    }

    public static int method125() {
        int i = Class15.method353(aByteArray141, anInt143);
        anInt143 += 2;
        return i;
    }

    public static int method126() {
        int i = Class15.method354(aByteArray141, anInt143);
        anInt143 += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String method127() {
        String s;
        for(s = ""; aByteArray140[anInt142] != 0; s = s + (char)aByteArray140[anInt142++]);
        anInt142++;
        return s;
    }

    public static void method128(byte abyte0[], boolean flag) {
        aByteArray140 = Class15.method365("string.dat", 0, abyte0);
        anInt142 = 0;
        aByteArray141 = Class15.method365("integer.dat", 0, abyte0);
        anInt143 = 0;
        anInt104 = method125();
        aStringArray112 = new String[anInt104];
        aStringArray113 = new String[anInt104];
        aStringArray114 = new String[anInt104];
        anIntArray71 = new int[anInt104];
        anIntArray72 = new int[anInt104];
        anIntArray73 = new int[anInt104];
        anIntArray74 = new int[anInt104];
        anIntArray75 = new int[anInt104];
        anIntArray76 = new int[anInt104];
        anIntArray77 = new int[anInt104];
        anIntArray78 = new int[anInt104];
        for(int i = 0; i < anInt104; i++)
            aStringArray112[i] = method127();

        for(int j = 0; j < anInt104; j++)
            aStringArray113[j] = method127();

        for(int k = 0; k < anInt104; k++)
            aStringArray114[k] = method127();

        for(int l = 0; l < anInt104; l++) {
            anIntArray71[l] = method125();
            if(anIntArray71[l] + 1 > anInt105)
                anInt105 = anIntArray71[l] + 1;
        }

        for(int i1 = 0; i1 < anInt104; i1++)
            anIntArray72[i1] = method126();

        for(int j1 = 0; j1 < anInt104; j1++)
            anIntArray73[j1] = method124();

        for(int k1 = 0; k1 < anInt104; k1++)
            anIntArray74[k1] = method124();

        for(int l1 = 0; l1 < anInt104; l1++)
            anIntArray75[l1] = method125();

        for(int i2 = 0; i2 < anInt104; i2++)
            anIntArray76[i2] = method126();

        for(int j2 = 0; j2 < anInt104; j2++)
            anIntArray77[j2] = method124();

        for(int k2 = 0; k2 < anInt104; k2++)
            anIntArray78[k2] = method124();

        for(int l2 = 0; l2 < anInt104; l2++)
            if(!flag && anIntArray78[l2] == 1) {
                aStringArray112[l2] = "Members object";
                aStringArray113[l2] = "You need to be a member to use this object";
                anIntArray72[l2] = 0;
                aStringArray114[l2] = "";
                anIntArray74[0] = 0;
                anIntArray75[l2] = 0;
                anIntArray77[l2] = 1;
            }

        anInt57 = method125();
        aStringArray123 = new String[anInt57];
        aStringArray124 = new String[anInt57];
        aStringArray125 = new String[anInt57];
        anIntArray126 = new int[anInt57];
        anIntArray127 = new int[anInt57];
        anIntArray128 = new int[anInt57];
        anIntArray129 = new int[anInt57];
        anIntArray130 = new int[anInt57];
        anIntArrayArray136 = new int[anInt57][12];
        anIntArray132 = new int[anInt57];
        anIntArray133 = new int[anInt57];
        anIntArray134 = new int[anInt57];
        anIntArray135 = new int[anInt57];
        anIntArray59 = new int[anInt57];
        anIntArray60 = new int[anInt57];
        anIntArray106 = new int[anInt57];
        anIntArray107 = new int[anInt57];
        anIntArray108 = new int[anInt57];
        for(int i3 = 0; i3 < anInt57; i3++)
            aStringArray123[i3] = method127();

        for(int j3 = 0; j3 < anInt57; j3++)
            aStringArray124[j3] = method127();

        for(int k3 = 0; k3 < anInt57; k3++)
            anIntArray126[k3] = method124();

        for(int l3 = 0; l3 < anInt57; l3++)
            anIntArray127[l3] = method124();

        for(int i4 = 0; i4 < anInt57; i4++)
            anIntArray128[i4] = method124();

        for(int j4 = 0; j4 < anInt57; j4++)
            anIntArray129[j4] = method124();

        for(int k4 = 0; k4 < anInt57; k4++)
            anIntArray130[k4] = method124();

        for(int l4 = 0; l4 < anInt57; l4++) {
            for(int i5 = 0; i5 < 12; i5++) {
                anIntArrayArray136[l4][i5] = method124();
                if(anIntArrayArray136[l4][i5] == 255)
                    anIntArrayArray136[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < anInt57; j5++)
            anIntArray132[j5] = method126();

        for(int k5 = 0; k5 < anInt57; k5++)
            anIntArray133[k5] = method126();

        for(int l5 = 0; l5 < anInt57; l5++)
            anIntArray134[l5] = method126();

        for(int i6 = 0; i6 < anInt57; i6++)
            anIntArray135[i6] = method126();

        for(int j6 = 0; j6 < anInt57; j6++)
            anIntArray59[j6] = method125();

        for(int k6 = 0; k6 < anInt57; k6++)
            anIntArray60[k6] = method125();

        for(int l6 = 0; l6 < anInt57; l6++)
            anIntArray106[l6] = method124();

        for(int i7 = 0; i7 < anInt57; i7++)
            anIntArray107[i7] = method124();

        for(int j7 = 0; j7 < anInt57; j7++)
            anIntArray108[j7] = method124();

        for(int k7 = 0; k7 < anInt57; k7++)
            aStringArray125[k7] = method127();

        anInt53 = method125();
        aStringArray55 = new String[anInt53];
        aStringArray56 = new String[anInt53];
        for(int l7 = 0; l7 < anInt53; l7++)
            aStringArray55[l7] = method127();

        for(int i8 = 0; i8 < anInt53; i8++)
            aStringArray56[i8] = method127();

        anInt103 = method125();
        aStringArray54 = new String[anInt103];
        anIntArray89 = new int[anInt103];
        anIntArray90 = new int[anInt103];
        anIntArray91 = new int[anInt103];
        anIntArray92 = new int[anInt103];
        anIntArray93 = new int[anInt103];
        for(int j8 = 0; j8 < anInt103; j8++)
            aStringArray54[j8] = method127();

        for(int k8 = 0; k8 < anInt103; k8++)
            anIntArray89[k8] = method126();

        for(int l8 = 0; l8 < anInt103; l8++)
            anIntArray90[l8] = method124();

        for(int i9 = 0; i9 < anInt103; i9++)
            anIntArray91[i9] = method124();

        for(int j9 = 0; j9 < anInt103; j9++)
            anIntArray92[j9] = method124();

        for(int k9 = 0; k9 < anInt103; k9++)
            anIntArray93[k9] = method124();

        anInt95 = method125();
        aStringArray79 = new String[anInt95];
        aStringArray80 = new String[anInt95];
        aStringArray81 = new String[anInt95];
        aStringArray82 = new String[anInt95];
        anIntArray66 = new int[anInt95];
        anIntArray67 = new int[anInt95];
        anIntArray68 = new int[anInt95];
        anIntArray69 = new int[anInt95];
        anIntArray70 = new int[anInt95];
        for(int l9 = 0; l9 < anInt95; l9++)
            aStringArray79[l9] = method127();

        for(int i10 = 0; i10 < anInt95; i10++)
            aStringArray80[i10] = method127();

        for(int j10 = 0; j10 < anInt95; j10++)
            aStringArray81[j10] = method127();

        for(int k10 = 0; k10 < anInt95; k10++)
            aStringArray82[k10] = method127();

        for(int l10 = 0; l10 < anInt95; l10++)
            anIntArray66[l10] = method123(method127());

        for(int i11 = 0; i11 < anInt95; i11++)
            anIntArray67[i11] = method124();

        for(int j11 = 0; j11 < anInt95; j11++)
            anIntArray68[j11] = method124();

        for(int k11 = 0; k11 < anInt95; k11++)
            anIntArray69[k11] = method124();

        for(int l11 = 0; l11 < anInt95; l11++)
            anIntArray70[l11] = method124();

        anInt131 = method125();
        aStringArray99 = new String[anInt131];
        aStringArray100 = new String[anInt131];
        aStringArray101 = new String[anInt131];
        aStringArray102 = new String[anInt131];
        anIntArray118 = new int[anInt131];
        anIntArray119 = new int[anInt131];
        anIntArray120 = new int[anInt131];
        anIntArray121 = new int[anInt131];
        anIntArray122 = new int[anInt131];
        for(int i12 = 0; i12 < anInt131; i12++)
            aStringArray99[i12] = method127();

        for(int j12 = 0; j12 < anInt131; j12++)
            aStringArray100[j12] = method127();

        for(int k12 = 0; k12 < anInt131; k12++)
            aStringArray101[k12] = method127();

        for(int l12 = 0; l12 < anInt131; l12++)
            aStringArray102[l12] = method127();

        for(int i13 = 0; i13 < anInt131; i13++)
            anIntArray118[i13] = method125();

        for(int j13 = 0; j13 < anInt131; j13++)
            anIntArray119[j13] = method126();

        for(int k13 = 0; k13 < anInt131; k13++)
            anIntArray120[k13] = method126();

        for(int l13 = 0; l13 < anInt131; l13++)
            anIntArray121[l13] = method124();

        for(int i14 = 0; i14 < anInt131; i14++)
            anIntArray122[i14] = method124();

        anInt139 = method125();
        anIntArray87 = new int[anInt139];
        anIntArray88 = new int[anInt139];
        for(int j14 = 0; j14 < anInt139; j14++)
            anIntArray87[j14] = method124();

        for(int k14 = 0; k14 < anInt139; k14++)
            anIntArray88[k14] = method124();

        anInt58 = method125();
        anIntArray115 = new int[anInt58];
        anIntArray116 = new int[anInt58];
        anIntArray117 = new int[anInt58];
        for(int l14 = 0; l14 < anInt58; l14++)
            anIntArray115[l14] = method126();

        for(int i15 = 0; i15 < anInt58; i15++)
            anIntArray116[i15] = method124();

        for(int j15 = 0; j15 < anInt58; j15++)
            anIntArray117[j15] = method124();

        anInt84 = method125();
        anInt85 = method125();
        aStringArray110 = new String[anInt85];
        aStringArray111 = new String[anInt85];
        anIntArray61 = new int[anInt85];
        anIntArray62 = new int[anInt85];
        anIntArray63 = new int[anInt85];
        anIntArrayArray64 = new int[anInt85][];
        anIntArrayArray65 = new int[anInt85][];
        for(int k15 = 0; k15 < anInt85; k15++)
            aStringArray110[k15] = method127();

        for(int l15 = 0; l15 < anInt85; l15++)
            aStringArray111[l15] = method127();

        for(int i16 = 0; i16 < anInt85; i16++)
            anIntArray61[i16] = method124();

        for(int j16 = 0; j16 < anInt85; j16++)
            anIntArray62[j16] = method124();

        for(int k16 = 0; k16 < anInt85; k16++)
            anIntArray63[k16] = method124();

        for(int l16 = 0; l16 < anInt85; l16++) {
            int i17 = method124();
            anIntArrayArray64[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                anIntArrayArray64[l16][k17] = method125();

        }

        for(int j17 = 0; j17 < anInt85; j17++) {
            int l17 = method124();
            anIntArrayArray65[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                anIntArrayArray65[j17][j18] = method124();

        }

        anInt94 = method125();
        aStringArray96 = new String[anInt94];
        aStringArray97 = new String[anInt94];
        anIntArray137 = new int[anInt94];
        anIntArray138 = new int[anInt94];
        for(int i18 = 0; i18 < anInt94; i18++)
            aStringArray96[i18] = method127();

        for(int k18 = 0; k18 < anInt94; k18++)
            aStringArray97[k18] = method127();

        for(int l18 = 0; l18 < anInt94; l18++)
            anIntArray137[l18] = method124();

        for(int i19 = 0; i19 < anInt94; i19++)
            anIntArray138[i19] = method124();

        aByteArray140 = null;
        aByteArray141 = null;
    }

    public static int anInt53;
    public static String aStringArray54[];
    public static String aStringArray55[];
    public static String aStringArray56[];
    public static int anInt57;
    public static int anInt58;
    public static int anIntArray59[];
    public static int anIntArray60[];
    public static int anIntArray61[];
    public static int anIntArray62[];
    public static int anIntArray63[];
    public static int anIntArrayArray64[][];
    public static int anIntArrayArray65[][];
    public static int anIntArray66[];
    public static int anIntArray67[];
    public static int anIntArray68[];
    public static int anIntArray69[];
    public static int anIntArray70[];
    public static int anIntArray71[];
    public static int anIntArray72[];
    public static int anIntArray73[];
    public static int anIntArray74[];
    public static int anIntArray75[];
    public static int anIntArray76[];
    public static int anIntArray77[];
    public static int anIntArray78[];
    public static String aStringArray79[];
    public static String aStringArray80[];
    public static String aStringArray81[];
    public static String aStringArray82[];
    public static String aStringArray83[] = new String[5000];
    public static int anInt84;
    public static int anInt85;
    public static String aStringArray86[] = new String[5000];
    public static int anIntArray87[];
    public static int anIntArray88[];
    public static int anIntArray89[];
    public static int anIntArray90[];
    public static int anIntArray91[];
    public static int anIntArray92[];
    public static int anIntArray93[];
    public static int anInt94;
    public static int anInt95;
    public static String aStringArray96[];
    public static String aStringArray97[];
    public static String aStringArray98[] = new String[5000];
    public static String aStringArray99[];
    public static String aStringArray100[];
    public static String aStringArray101[];
    public static String aStringArray102[];
    public static int anInt103;
    public static int anInt104;
    public static int anInt105;
    public static int anIntArray106[];
    public static int anIntArray107[];
    public static int anIntArray108[];
    public static int anInt109;
    public static String aStringArray110[];
    public static String aStringArray111[];
    public static String aStringArray112[];
    public static String aStringArray113[];
    public static String aStringArray114[];
    public static int anIntArray115[];
    public static int anIntArray116[];
    public static int anIntArray117[];
    public static int anIntArray118[];
    public static int anIntArray119[];
    public static int anIntArray120[];
    public static int anIntArray121[];
    public static int anIntArray122[];
    public static String aStringArray123[];
    public static String aStringArray124[];
    public static String aStringArray125[];
    public static int anIntArray126[];
    public static int anIntArray127[];
    public static int anIntArray128[];
    public static int anIntArray129[];
    public static int anIntArray130[];
    public static int anInt131;
    public static int anIntArray132[];
    public static int anIntArray133[];
    public static int anIntArray134[];
    public static int anIntArray135[];
    public static int anIntArrayArray136[][];
    public static int anIntArray137[];
    public static int anIntArray138[];
    public static int anInt139;
    public static byte aByteArray140[];
    public static byte aByteArray141[];
    public static int anInt142;
    public static int anInt143;
    public static int anInt144;

}
