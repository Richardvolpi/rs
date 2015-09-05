// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 


public class identify
{

    public static int anj(String arg0)
    {
        if(arg0.equalsIgnoreCase("na"))
            return 0;
        for(int i = 0; i < aim; i++)
            if(ahl[i].equalsIgnoreCase(arg0))
                return i;

        ahl[aim++] = arg0;
        return aim - 1;
    }

    public static int ank()
    {
        int i = anf[anh] & 0xff;
        anh++;
        return i;
    }

    public static int anl()
    {
        int i = t.fmi(anf, anh);
        anh += 2;
        return i;
    }

    public static int anm()
    {
        int i = t.fmj(anf, anh);
        anh += 4;
        if(i > 0x5f5e0ff)
            i = 0x5f5e0ff - i;
        return i;
    }

    public static String ann()
    {
        String s;
        for(s = ""; ane[ang] != 0; s = s + (char)ane[ang++]);
        ang++;
        return s;
    }

    public static void baa(byte arg0[], boolean arg1)
    {
        ane = t.fng("string.dat", 0, arg0);
        ang = 0;
        anf = t.fng("integer.dat", 0, arg0);
        anh = 0;
        ajd = anl();
        itemName = new String[ajd];
        itemDesc = new String[ajd];
        itemCommand = new String[ajd];
        ajf = new int[ajd];
        itemPrice = new int[ajd];
        stackable = new int[ajd];
        aji = new int[ajd];
        wieldable = new int[ajd];
        ajk = new int[ajd];
        ajl = new int[ajd];
        ajm = new int[ajd];
        for(int i = 0; i < ajd; i++)
            itemName[i] = ann();

        for(int j = 0; j < ajd; j++)
            itemDesc[j] = ann();

        for(int k = 0; k < ajd; k++)
            itemCommand[k] = ann();

        for(int l = 0; l < ajd; l++)
        {
            ajf[l] = anl();
            if(ajf[l] + 1 > aje)
                aje = ajf[l] + 1;
        }

        for(int i1 = 0; i1 < ajd; i1++)
            itemPrice[i1] = anm();

        for(int j1 = 0; j1 < ajd; j1++)
            stackable[j1] = ank();

        for(int k1 = 0; k1 < ajd; k1++)
            aji[k1] = ank();

        for(int l1 = 0; l1 < ajd; l1++)
            wieldable[l1] = anl();

        for(int i2 = 0; i2 < ajd; i2++)
            ajk[i2] = anm();

        for(int j2 = 0; j2 < ajd; j2++)
            ajl[j2] = ank();

        for(int k2 = 0; k2 < ajd; k2++)
            ajm[k2] = ank();

        for(int l2 = 0; l2 < ajd; l2++)
            if(!arg1 && ajm[l2] == 1)
            {
                itemName[l2] = "Members object";
                itemDesc[l2] = "You need to be a member to use this object";
                itemPrice[l2] = 0;
                itemCommand[l2] = "";
                aji[0] = 0;
                wieldable[l2] = 0;
                ajl[l2] = 1;
            }

        ald = anl();
        npcName = new String[ald];
        npcDesc = new String[ald];
        npcCommand = new String[ald];
        npcAttack = new int[ald];
        npcStrength = new int[ald];
        npcHits = new int[ald];
        npcDefence = new int[ald];
        npcAttackable = new int[ald];
        aig = new int[ald][12];
        ain = new int[ald];
        aja = new int[ald];
        ajb = new int[ald];
        ajc = new int[ald];
        ale = new int[ald];
        alf = new int[ald];
        akk = new int[ald];
        akl = new int[ald];
        akm = new int[ald];
        for(int i3 = 0; i3 < ald; i3++)
            npcName[i3] = ann();

        for(int j3 = 0; j3 < ald; j3++)
            npcDesc[j3] = ann();

        for(int k3 = 0; k3 < ald; k3++)
            npcAttack[k3] = ank();

        for(int l3 = 0; l3 < ald; l3++)
            npcStrength[l3] = ank();

        for(int i4 = 0; i4 < ald; i4++)
            npcHits[i4] = ank();

        for(int j4 = 0; j4 < ald; j4++)
            npcDefence[j4] = ank();

        for(int k4 = 0; k4 < ald; k4++)
            npcAttackable[k4] = ank();

        for(int l4 = 0; l4 < ald; l4++)
        {
            for(int i5 = 0; i5 < 12; i5++)
            {
                aig[l4][i5] = ank();
                if(aig[l4][i5] == 255)
                    aig[l4][i5] = -1;
            }

        }

        for(int j5 = 0; j5 < ald; j5++)
            ain[j5] = anm();

        for(int k5 = 0; k5 < ald; k5++)
            aja[k5] = anm();

        for(int l5 = 0; l5 < ald; l5++)
            ajb[l5] = anm();

        for(int i6 = 0; i6 < ald; i6++)
            ajc[i6] = anm();

        for(int j6 = 0; j6 < ald; j6++)
            ale[j6] = anl();

        for(int k6 = 0; k6 < ald; k6++)
            alf[k6] = anl();

        for(int l6 = 0; l6 < ald; l6++)
            akk[l6] = ank();

        for(int i7 = 0; i7 < ald; i7++)
            akl[i7] = ank();

        for(int j7 = 0; j7 < ald; j7++)
            akm[j7] = ank();

        for(int k7 = 0; k7 < ald; k7++)
            npcCommand[k7] = ann();

        amj = anl();
        alg = new String[amj];
        alh = new String[amj];
        for(int l7 = 0; l7 < amj; l7++)
            alg[l7] = ann();

        for(int i8 = 0; i8 < amj; i8++)
            alh[i8] = ann();

        ake = anl();
        akb = new String[ake];
        amn = new int[ake];
        ana = new int[ake];
        anb = new int[ake];
        anc = new int[ake];
        and = new int[ake];
        for(int j8 = 0; j8 < ake; j8++)
            akb[j8] = ann();

        for(int k8 = 0; k8 < ake; k8++)
            amn[k8] = anm();

        for(int l8 = 0; l8 < ake; l8++)
            ana[l8] = ank();

        for(int i9 = 0; i9 < ake; i9++)
            anb[i9] = ank();

        for(int j9 = 0; j9 < ake; j9++)
            anc[j9] = ank();

        for(int k9 = 0; k9 < ake; k9++)
            and[k9] = ank();

        aka = anl();
        objectName = new String[aka];
        objectDesc = new String[aka];
        objectCommand = new String[aka];
        objectCommand2 = new String[aka];
        alk = new int[aka];
        all = new int[aka];
        alm = new int[aka];
        aln = new int[aka];
        ama = new int[aka];
        for(int l9 = 0; l9 < aka; l9++)
            objectName[l9] = ann();

        for(int i10 = 0; i10 < aka; i10++)
            objectDesc[i10] = ann();

        for(int j10 = 0; j10 < aka; j10++)
            objectCommand[j10] = ann();

        for(int k10 = 0; k10 < aka; k10++)
            objectCommand2[k10] = ann();

        for(int l10 = 0; l10 < aka; l10++)
            alk[l10] = anj(ann());

        for(int i11 = 0; i11 < aka; i11++)
            all[i11] = ank();

        for(int j11 = 0; j11 < aka; j11++)
            alm[j11] = ank();

        for(int k11 = 0; k11 < aka; k11++)
            aln[k11] = ank();

        for(int l11 = 0; l11 < aka; l11++)
            ama[l11] = ank();

        akd = anl();
        doorName = new String[akd];
        doorDesc = new String[akd];
        doorCommand = new String[akd];
        doorCommand2 = new String[akd];
        akf = new int[akd];
        akg = new int[akd];
        akh = new int[akd];
        aki = new int[akd];
        akj = new int[akd];
        for(int i12 = 0; i12 < akd; i12++)
            doorName[i12] = ann();

        for(int j12 = 0; j12 < akd; j12++)
            doorDesc[j12] = ann();

        for(int k12 = 0; k12 < akd; k12++)
            doorCommand[k12] = ann();

        for(int l12 = 0; l12 < akd; l12++)
            doorCommand2[l12] = ann();

        for(int i13 = 0; i13 < akd; i13++)
            akf[i13] = anl();

        for(int j13 = 0; j13 < akd; j13++)
            akg[j13] = anm();

        for(int k13 = 0; k13 < akd; k13++)
            akh[k13] = anm();

        for(int l13 = 0; l13 < akd; l13++)
            aki[l13] = ank();

        for(int i14 = 0; i14 < akd; i14++)
            akj[i14] = ank();

        ajn = anl();
        ali = new int[ajn];
        alj = new int[ajn];
        for(int j14 = 0; j14 < ajn; j14++)
            ali[j14] = ank();

        for(int k14 = 0; k14 < ajn; k14++)
            alj[k14] = ank();

        akc = anl();
        ahd = new int[akc];
        ahe = new int[akc];
        ahf = new int[akc];
        for(int l14 = 0; l14 < akc; l14++)
            ahd[l14] = anm();

        for(int i15 = 0; i15 < akc; i15++)
            ahe[i15] = ank();

        for(int j15 = 0; j15 < akc; j15++)
            ahf[j15] = ank();

        ahg = anl();
        spellCount = anl();
        spellName = new String[spellCount];
        aml = new String[spellCount];
        spellLevel = new int[spellCount];
        aii = new int[spellCount];
        spellType = new int[spellCount];
        aik = new int[spellCount][];
        ail = new int[spellCount][];
        for(int k15 = 0; k15 < spellCount; k15++)
            spellName[k15] = ann();

        for(int l15 = 0; l15 < spellCount; l15++)
            aml[l15] = ann();

        for(int i16 = 0; i16 < spellCount; i16++)
            spellLevel[i16] = ank();

        for(int j16 = 0; j16 < spellCount; j16++)
            aii[j16] = ank();

        for(int k16 = 0; k16 < spellCount; k16++)
            spellType[k16] = ank();

        for(int l16 = 0; l16 < spellCount; l16++)
        {
            int i17 = ank();
            aik[l16] = new int[i17];
            for(int k17 = 0; k17 < i17; k17++)
                aik[l16][k17] = anl();

        }

        for(int j17 = 0; j17 < spellCount; j17++)
        {
            int l17 = ank();
            ail[j17] = new int[l17];
            for(int j18 = 0; j18 < l17; j18++)
                ail[j17][j18] = ank();

        }

        ahc = anl();
        ahn = new String[ahc];
        aia = new String[ahc];
        amh = new int[ahc];
        ami = new int[ahc];
        for(int i18 = 0; i18 < ahc; i18++)
            ahn[i18] = ann();

        for(int k18 = 0; k18 < ahc; k18++)
            aia[k18] = ann();

        for(int l18 = 0; l18 < ahc; l18++)
            amh[l18] = ank();

        for(int i19 = 0; i19 < ahc; i19++)
            ami[i19] = ank();

        ane = null;
        anf = null;
    }

    public static String ahb[] = new String[5000];
    public static int ahc;
    public static int ahd[];
    public static int ahe[];
    public static int ahf[];
    public static int ahg;
    public static String objectName[];
    public static String objectDesc[];
    public static String objectCommand[];
    public static String objectCommand2[];
    public static String ahl[] = new String[5000];
    public static int spellCount;
    public static String ahn[];
    public static String aia[];
    public static int npcAttack[];
    public static int npcStrength[];
    public static int npcHits[];
    public static int npcDefence[];
    public static int npcAttackable[];
    public static int aig[][];
    public static int spellLevel[];
    public static int aii[];
    public static int spellType[];
    public static int aik[][];
    public static int ail[][];
    public static int aim;
    public static int ain[];
    public static int aja[];
    public static int ajb[];
    public static int ajc[];
    public static int ajd;
    public static int aje;
    public static int ajf[];
    public static int itemPrice[];
    public static int stackable[];
    public static int aji[];
    public static int wieldable[];
    public static int ajk[];
    public static int ajl[];
    public static int ajm[];
    public static int ajn;
    public static int aka;
    public static String akb[];
    public static int akc;
    public static int akd;
    public static int ake;
    public static int akf[];
    public static int akg[];
    public static int akh[];
    public static int aki[];
    public static int akj[];
    public static int akk[];
    public static int akl[];
    public static int akm[];
    public static String doorName[];
    public static String doorDesc[];
    public static String doorCommand[];
    public static String doorCommand2[];
    public static int ald;
    public static int ale[];
    public static int alf[];
    public static String alg[];
    public static String alh[];
    public static int ali[];
    public static int alj[];
    public static int alk[];
    public static int all[];
    public static int alm[];
    public static int aln[];
    public static int ama[];
    public static String npcName[];
    public static String npcDesc[];
    public static String npcCommand[];
    public static String itemName[];
    public static String itemDesc[];
    public static String itemCommand[];
    public static int amh[];
    public static int ami[];
    public static int amj;
    public static String spellName[];
    public static String aml[];
    public static String amm[] = new String[5000];
    public static int amn[];
    public static int ana[];
    public static int anb[];
    public static int anc[];
    public static int and[];
    static byte ane[];
    static byte anf[];
    static int ang;
    static int anh;
    public static int ani;

}
