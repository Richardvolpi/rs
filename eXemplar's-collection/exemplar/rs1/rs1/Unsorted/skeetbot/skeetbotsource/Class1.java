// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 


public class Class1
{

    public static int method124(String s)
    {
        if(s.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < anInt74; i++)
            if(aStringArray126[i].equalsIgnoreCase(s))
                return i;

        aStringArray126[anInt74++] = s;
        return anInt74 - 1;
    }

    public static int method125()
    {
        int i = aByteArray141[anInt143] & 0xff;
        anInt143++;
        return i;
    }

    public static int method126()
    {
        int i = Class15.method354(aByteArray141, anInt143);
        anInt143 += 2;
        return i;
    }

    public static int method127()
    {
        int i = Class15.method355(aByteArray141, anInt143);
        anInt143 += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String method128()
    {
        String s;
        for(s = ""; aByteArray140[anInt142] != 0; s = s + (char)aByteArray140[anInt142++]);
        anInt142++;
        return s;
    }

    public static void method129(byte abyte0[], boolean flag)
    {
        int j19 = anInt144;
        aByteArray140 = Class15.method366("string.dat", 0, abyte0);
        anInt142 = 0;
        aByteArray141 = Class15.method366("integer.dat", 0, abyte0);
        anInt143 = 0;
        anInt75 = method126();
        aStringArray109 = new String[anInt75];
        aStringArray110 = new String[anInt75];
        aStringArray111 = new String[anInt75];
        anIntArray53 = new int[anInt75];
        anIntArray54 = new int[anInt75];
        anIntArray55 = new int[anInt75];
        anIntArray56 = new int[anInt75];
        anIntArray57 = new int[anInt75];
        anIntArray58 = new int[anInt75];
        anIntArray59 = new int[anInt75];
        anIntArray60 = new int[anInt75];
        for(int i = 0; i < anInt75; i++)
            aStringArray109[i] = method128();

        for(int j = 0; j < anInt75; j++)
            aStringArray110[j] = method128();

        for(int k = 0; k < anInt75; k++)
            aStringArray111[k] = method128();

        for(int l = 0; l < anInt75; l++)
        {
            anIntArray53[l] = method126();
            if(anIntArray53[l] + 1 > anInt76)
                anInt76 = anIntArray53[l] + 1;
        }

        for(int i1 = 0; i1 < anInt75; i1++)
            anIntArray54[i1] = method127();

        for(int j1 = 0; j1 < anInt75; j1++)
            anIntArray55[j1] = method125();

        for(int k1 = 0; k1 < anInt75; k1++)
            anIntArray56[k1] = method125();

        for(int l1 = 0; l1 < anInt75; l1++)
            anIntArray57[l1] = method126();

        for(int i2 = 0; i2 < anInt75; i2++)
            anIntArray58[i2] = method127();

        for(int j2 = 0; j2 < anInt75; j2++)
            anIntArray59[j2] = method125();

        for(int k2 = 0; k2 < anInt75; k2++)
            anIntArray60[k2] = method125();

        for(int l2 = 0; l2 < anInt75; l2++)
            if(!flag && anIntArray60[l2] == 1)
            {
                aStringArray109[l2] = "Members object";
                aStringArray110[l2] = "You need to be a member to use this object";
                anIntArray54[l2] = 0;
                aStringArray111[l2] = "";
                anIntArray56[0] = 0;
                anIntArray57[l2] = 0;
                anIntArray59[l2] = 1;
            }

        anInt122 = method126();
        aStringArray127 = new String[anInt122];
        aStringArray128 = new String[anInt122];
        aStringArray129 = new String[anInt122];
        anIntArray112 = new int[anInt122];
        anIntArray113 = new int[anInt122];
        anIntArray114 = new int[anInt122];
        anIntArray115 = new int[anInt122];
        anIntArray116 = new int[anInt122];
        anIntArrayArray90 = new int[anInt122][12];
        anIntArray130 = new int[anInt122];
        anIntArray131 = new int[anInt122];
        anIntArray132 = new int[anInt122];
        anIntArray133 = new int[anInt122];
        anIntArray102 = new int[anInt122];
        anIntArray103 = new int[anInt122];
        anIntArray105 = new int[anInt122];
        anIntArray106 = new int[anInt122];
        anIntArray107 = new int[anInt122];
        for(int i3 = 0; i3 < anInt122; i3++)
            aStringArray127[i3] = method128();

        for(int j3 = 0; j3 < anInt122; j3++)
            aStringArray128[j3] = method128();

        for(int k3 = 0; k3 < anInt122; k3++)
            anIntArray112[k3] = method125();

        for(int l3 = 0; l3 < anInt122; l3++)
            anIntArray113[l3] = method125();

        for(int i4 = 0; i4 < anInt122; i4++)
            anIntArray114[i4] = method125();

        for(int j4 = 0; j4 < anInt122; j4++)
            anIntArray115[j4] = method125();

        for(int k4 = 0; k4 < anInt122; k4++)
            anIntArray116[k4] = method125();

        for(int l4 = 0; l4 < anInt122; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                anIntArrayArray90[l4][i5] = method125();
                if(anIntArrayArray90[l4][i5] == 255)
                    anIntArrayArray90[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < anInt122; j5++)
            anIntArray130[j5] = method127();

        for(int k5 = 0; k5 < anInt122; k5++)
            anIntArray131[k5] = method127();

        for(int l5 = 0; l5 < anInt122; l5++)
            anIntArray132[l5] = method127();

        for(int i6 = 0; i6 < anInt122; i6++)
            anIntArray133[i6] = method127();

        for(int j6 = 0; j6 < anInt122; j6++)
            anIntArray102[j6] = method126();

        for(int k6 = 0; k6 < anInt122; k6++)
            anIntArray103[k6] = method126();

        for(int l6 = 0; l6 < anInt122; l6++)
            anIntArray105[l6] = method125();

        for(int i7 = 0; i7 < anInt122; i7++)
            anIntArray106[i7] = method125();

        for(int j7 = 0; j7 < anInt122; j7++)
            anIntArray107[j7] = method125();

        for(int k7 = 0; k7 < anInt122; k7++)
            aStringArray129[k7] = method128();

        anInt61 = method126();
        aStringArray67 = new String[anInt61];
        aStringArray68 = new String[anInt61];
        for(int l7 = 0; l7 < anInt61; l7++)
            aStringArray67[l7] = method128();

        for(int i8 = 0; i8 < anInt61; i8++)
            aStringArray68[i8] = method128();

        anInt123 = method126();
        aStringArray77 = new String[anInt123];
        anIntArray83 = new int[anInt123];
        anIntArray84 = new int[anInt123];
        anIntArray85 = new int[anInt123];
        anIntArray86 = new int[anInt123];
        anIntArray87 = new int[anInt123];
        for(int j8 = 0; j8 < anInt123; j8++)
            aStringArray77[j8] = method128();

        for(int k8 = 0; k8 < anInt123; k8++)
            anIntArray83[k8] = method127();

        for(int l8 = 0; l8 < anInt123; l8++)
            anIntArray84[l8] = method125();

        for(int i9 = 0; i9 < anInt123; i9++)
            anIntArray85[i9] = method125();

        for(int j9 = 0; j9 < anInt123; j9++)
            anIntArray86[j9] = method125();

        for(int k9 = 0; k9 < anInt123; k9++)
            anIntArray87[k9] = method125();

        anInt104 = method126();
        aStringArray91 = new String[anInt104];
        aStringArray92 = new String[anInt104];
        aStringArray93 = new String[anInt104];
        aStringArray94 = new String[anInt104];
        anIntArray62 = new int[anInt104];
        anIntArray63 = new int[anInt104];
        anIntArray64 = new int[anInt104];
        anIntArray65 = new int[anInt104];
        anIntArray66 = new int[anInt104];
        for(int l9 = 0; l9 < anInt104; l9++)
            aStringArray91[l9] = method128();

        for(int i10 = 0; i10 < anInt104; i10++)
            aStringArray92[i10] = method128();

        for(int j10 = 0; j10 < anInt104; j10++)
            aStringArray93[j10] = method128();

        for(int k10 = 0; k10 < anInt104; k10++)
            aStringArray94[k10] = method128();

        for(int l10 = 0; l10 < anInt104; l10++)
            anIntArray62[l10] = method124(method128());

        for(int i11 = 0; i11 < anInt104; i11++)
            anIntArray63[i11] = method125();

        for(int j11 = 0; j11 < anInt104; j11++)
            anIntArray64[j11] = method125();

        for(int k11 = 0; k11 < anInt104; k11++)
            anIntArray65[k11] = method125();

        for(int l11 = 0; l11 < anInt104; l11++)
            anIntArray66[l11] = method125();

        anInt139 = method126();
        aStringArray70 = new String[anInt139];
        aStringArray71 = new String[anInt139];
        aStringArray72 = new String[anInt139];
        aStringArray73 = new String[anInt139];
        anIntArray78 = new int[anInt139];
        anIntArray79 = new int[anInt139];
        anIntArray80 = new int[anInt139];
        anIntArray81 = new int[anInt139];
        anIntArray82 = new int[anInt139];
        for(int i12 = 0; i12 < anInt139; i12++)
            aStringArray70[i12] = method128();

        for(int j12 = 0; j12 < anInt139; j12++)
            aStringArray71[j12] = method128();

        for(int k12 = 0; k12 < anInt139; k12++)
            aStringArray72[k12] = method128();

        for(int l12 = 0; l12 < anInt139; l12++)
            aStringArray73[l12] = method128();

        for(int i13 = 0; i13 < anInt139; i13++)
            anIntArray78[i13] = method126();

        for(int j13 = 0; j13 < anInt139; j13++)
            anIntArray79[j13] = method127();

        for(int k13 = 0; k13 < anInt139; k13++)
            anIntArray80[k13] = method127();

        for(int l13 = 0; l13 < anInt139; l13++)
            anIntArray81[l13] = method125();

        for(int i14 = 0; i14 < anInt139; i14++)
            anIntArray82[i14] = method125();

        anInt69 = method126();
        anIntArray124 = new int[anInt69];
        anIntArray125 = new int[anInt69];
        for(int j14 = 0; j14 < anInt69; j14++)
            anIntArray124[j14] = method125();

        for(int k14 = 0; k14 < anInt69; k14++)
            anIntArray125[k14] = method125();

        anInt121 = method126();
        anIntArray134 = new int[anInt121];
        anIntArray135 = new int[anInt121];
        anIntArray136 = new int[anInt121];
        for(int l14 = 0; l14 < anInt121; l14++)
            anIntArray134[l14] = method127();

        for(int i15 = 0; i15 < anInt121; i15++)
            anIntArray135[i15] = method125();

        for(int j15 = 0; j15 < anInt121; j15++)
            anIntArray136[j15] = method125();

        anInt108 = method126();
        anInt120 = method126();
        aStringArray118 = new String[anInt120];
        aStringArray119 = new String[anInt120];
        anIntArray96 = new int[anInt120];
        anIntArray97 = new int[anInt120];
        anIntArray98 = new int[anInt120];
        anIntArrayArray99 = new int[anInt120][];
        anIntArrayArray100 = new int[anInt120][];
        for(int k15 = 0; k15 < anInt120; k15++)
            aStringArray118[k15] = method128();

        for(int l15 = 0; l15 < anInt120; l15++)
            aStringArray119[l15] = method128();

        for(int i16 = 0; i16 < anInt120; i16++)
            anIntArray96[i16] = method125();

        for(int j16 = 0; j16 < anInt120; j16++)
            anIntArray97[j16] = method125();

        for(int k16 = 0; k16 < anInt120; k16++)
            anIntArray98[k16] = method125();

        for(int l16 = 0; l16 < anInt120; l16++)
        {
            int i17 = method125();
            anIntArrayArray99[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                anIntArrayArray99[l16][k17] = method126();

        }

        for(int j17 = 0; j17 < anInt120; j17++)
        {
            int l17 = method125();
            anIntArrayArray100[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                anIntArrayArray100[j17][j18] = method125();

        }

        anInt95 = method126();
        aStringArray137 = new String[anInt95];
        aStringArray138 = new String[anInt95];
        anIntArray88 = new int[anInt95];
        anIntArray89 = new int[anInt95];
        for(int i18 = 0; i18 < anInt95; i18++)
            aStringArray137[i18] = method128();

        for(int k18 = 0; k18 < anInt95; k18++)
            aStringArray138[k18] = method128();

        for(int l18 = 0; l18 < anInt95; l18++)
            anIntArray88[l18] = method125();

        for(int i19 = 0; i19 < anInt95; i19++)
            anIntArray89[i19] = method125();

        aByteArray140 = null;
        aByteArray141 = null;
        if(Class15.aBoolean556)
            anInt144 = ++j19;
    }

    static byte aByteArray140[];
    static byte aByteArray141[];
    public static String aStringArray101[] = new String[5000];
    public static String aStringArray109[];
    public static String aStringArray110[];
    public static String aStringArray111[];
    public static String aStringArray117[] = new String[5000];
    public static String aStringArray118[];
    public static String aStringArray119[];
    public static String aStringArray126[] = new String[5000];
    public static String aStringArray127[];
    public static String aStringArray128[];
    public static String aStringArray129[];
    public static String aStringArray137[];
    public static String aStringArray138[];
    public static String aStringArray67[];
    public static String aStringArray68[];
    public static String aStringArray70[];
    public static String aStringArray71[];
    public static String aStringArray72[];
    public static String aStringArray73[];
    public static String aStringArray77[];
    public static String aStringArray91[];
    public static String aStringArray92[];
    public static String aStringArray93[];
    public static String aStringArray94[];
    public static int anInt104;
    public static int anInt108;
    public static int anInt120;
    public static int anInt121;
    public static int anInt122;
    public static int anInt123;
    public static int anInt139;
    static int anInt142;
    static int anInt143;
    public static int anInt144;
    public static int anInt61;
    public static int anInt69;
    public static int anInt74;
    public static int anInt75;
    public static int anInt76;
    public static int anInt95;
    public static int anIntArray102[];
    public static int anIntArray103[];
    public static int anIntArray105[];
    public static int anIntArray106[];
    public static int anIntArray107[];
    public static int anIntArray112[];
    public static int anIntArray113[];
    public static int anIntArray114[];
    public static int anIntArray115[];
    public static int anIntArray116[];
    public static int anIntArray124[];
    public static int anIntArray125[];
    public static int anIntArray130[];
    public static int anIntArray131[];
    public static int anIntArray132[];
    public static int anIntArray133[];
    public static int anIntArray134[];
    public static int anIntArray135[];
    public static int anIntArray136[];
    public static int anIntArray53[];
    public static int anIntArray54[];
    public static int anIntArray55[];
    public static int anIntArray56[];
    public static int anIntArray57[];
    public static int anIntArray58[];
    public static int anIntArray59[];
    public static int anIntArray60[];
    public static int anIntArray62[];
    public static int anIntArray63[];
    public static int anIntArray64[];
    public static int anIntArray65[];
    public static int anIntArray66[];
    public static int anIntArray78[];
    public static int anIntArray79[];
    public static int anIntArray80[];
    public static int anIntArray81[];
    public static int anIntArray82[];
    public static int anIntArray83[];
    public static int anIntArray84[];
    public static int anIntArray85[];
    public static int anIntArray86[];
    public static int anIntArray87[];
    public static int anIntArray88[];
    public static int anIntArray89[];
    public static int anIntArray96[];
    public static int anIntArray97[];
    public static int anIntArray98[];
    public static int anIntArrayArray100[][];
    public static int anIntArrayArray90[][];
    public static int anIntArrayArray99[][];

}
