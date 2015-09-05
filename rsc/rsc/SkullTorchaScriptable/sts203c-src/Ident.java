public class Ident {
	
    public static int anj(String arg0) {
        if (arg0.equalsIgnoreCase("na")) {
            return 0;
        }
        for (int i = 0; i < aim; i++) {
            if (ahl[i].equalsIgnoreCase(arg0)) {
                return i;
            }
        }
        ahl[aim++] = arg0;
        return aim - 1;
    }

    public static int ank() {
        int i = anf[anh] & 0xff;
        anh++;
        return i;
    }

    public static int anl() {
        int i = t.fmi(anf, anh);
        anh += 2;
        return i;
    }

    public static int anm() {
        int i = t.fmj(anf, anh);
        anh += 4;
        if (i > 0x5f5e0ff) {
            i = 0x5f5e0ff - i;
        }
        return i;
    }

    public static String ann() {
        String s;
        for (s = ""; ane[ang] != 0; s = s + (char) ane[ang++]);
        ang++;
        return s;
    }

    public static void baa(byte arg0[], boolean arg1) {
        ane = t.Extract("string.dat", 0, arg0);
        ang = 0;
        anf = t.Extract("integer.dat", 0, arg0);
        anh = 0;
        ItemTotalCount = anl();
        ItemName = new String[ItemTotalCount];
        ItemDescription = new String[ItemTotalCount];
        ItemAction = new String[ItemTotalCount];
        PictureOffset = new int[ItemTotalCount];
        ItemValue = new int[ItemTotalCount];
        ItemStackableVar = new int[ItemTotalCount];
        aji = new int[ItemTotalCount];
        ItemWearableVar = new int[ItemTotalCount];
        ajk = new int[ItemTotalCount];
        TradeableVar = new int[ItemTotalCount];
        MembersObjectVar = new int[ItemTotalCount];
        for (int i = 0; i < ItemTotalCount; i++) {
            ItemName[i] = ann();
        }
        for (int j = 0; j < ItemTotalCount; j++) {
            ItemDescription[j] = ann();
        }
        for (int k = 0; k < ItemTotalCount; k++) {
            ItemAction[k] = ann();
        }
        for (int l = 0; l < ItemTotalCount; l++) {
            PictureOffset[l] = anl();
            if (PictureOffset[l] + 1 > aje) {
                aje = PictureOffset[l] + 1;
            }
        }
        for (int i1 = 0; i1 < ItemTotalCount; i1++) {
            ItemValue[i1] = anm();
        }
        for (int j1 = 0; j1 < ItemTotalCount; j1++) {
            ItemStackableVar[j1] = ank();
        }
        for (int k1 = 0; k1 < ItemTotalCount; k1++) {
            aji[k1] = ank();
        }
        for (int l1 = 0; l1 < ItemTotalCount; l1++) {
            ItemWearableVar[l1] = anl();
        }
        for (int i2 = 0; i2 < ItemTotalCount; i2++) {
            ajk[i2] = anm();
        }
        for (int j2 = 0; j2 < ItemTotalCount; j2++) {
            TradeableVar[j2] = ank();
        }
        for (int k2 = 0; k2 < ItemTotalCount; k2++) {
            MembersObjectVar[k2] = ank();
        }
        for (int l2 = 0; l2 < ItemTotalCount; l2++) {
            if (!arg1 && MembersObjectVar[l2] == 1) {
                ItemName[l2] = "Members object";
                ItemDescription[l2] = "You need to be a member to use this object";
                ItemValue[l2] = 0;
                ItemAction[l2] = "";
                aji[0] = 0;
                ItemWearableVar[l2] = 0;
                TradeableVar[l2] = 1;
            }
        }
        NpcTotalCount = anl();
        NpcName = new String[NpcTotalCount];
        NpcDescription = new String[NpcTotalCount];
        NpcAction = new String[NpcTotalCount];
        NpcAttackLevel = new int[NpcTotalCount];
        NpcDefenceLevel = new int[NpcTotalCount];
        NpcStrengthLevel = new int[NpcTotalCount];
        NpcHitsLevel = new int[NpcTotalCount];
        NpcAttackableVar = new int[NpcTotalCount];
        aig = new int[NpcTotalCount][12];
        ain = new int[NpcTotalCount];
        aja = new int[NpcTotalCount];
        ajb = new int[NpcTotalCount];
        ajc = new int[NpcTotalCount];
        ale = new int[NpcTotalCount];
        alf = new int[NpcTotalCount];
        akk = new int[NpcTotalCount];
        akl = new int[NpcTotalCount];
        akm = new int[NpcTotalCount];
        for (int i3 = 0; i3 < NpcTotalCount; i3++) {
            NpcName[i3] = ann();
        }
        for (int j3 = 0; j3 < NpcTotalCount; j3++) {
            NpcDescription[j3] = ann();
        }
        for (int k3 = 0; k3 < NpcTotalCount; k3++) {
            NpcAttackLevel[k3] = ank();
        }
        for (int l3 = 0; l3 < NpcTotalCount; l3++) {
            NpcDefenceLevel[l3] = ank();
        }
        for (int i4 = 0; i4 < NpcTotalCount; i4++) {
            NpcStrengthLevel[i4] = ank();
        }
        for (int j4 = 0; j4 < NpcTotalCount; j4++) {
            NpcHitsLevel[j4] = ank();
        }
        for (int k4 = 0; k4 < NpcTotalCount; k4++) {
            NpcAttackableVar[k4] = ank();
        }
        for (int l4 = 0; l4 < NpcTotalCount; l4++) {
            for (int i5 = 0; i5 < 12; i5++) {
                aig[l4][i5] = ank();
                if (aig[l4][i5] == 255) {
                    aig[l4][i5] = -1;
                }
            }
        }
        for (int j5 = 0; j5 < NpcTotalCount; j5++) {
            ain[j5] = anm();
        }
        for (int k5 = 0; k5 < NpcTotalCount; k5++) {
            aja[k5] = anm();
        }
        for (int l5 = 0; l5 < NpcTotalCount; l5++) {
            ajb[l5] = anm();
        }
        for (int i6 = 0; i6 < NpcTotalCount; i6++) {
            ajc[i6] = anm();
        }
        for (int j6 = 0; j6 < NpcTotalCount; j6++) {
            ale[j6] = anl();
        }
        for (int k6 = 0; k6 < NpcTotalCount; k6++) {
            alf[k6] = anl();
        }
        for (int l6 = 0; l6 < NpcTotalCount; l6++) {
            akk[l6] = ank();
        }
        for (int i7 = 0; i7 < NpcTotalCount; i7++) {
            akl[i7] = ank();
        }
        for (int j7 = 0; j7 < NpcTotalCount; j7++) {
            akm[j7] = ank();
        }
        for (int k7 = 0; k7 < NpcTotalCount; k7++) {
            NpcAction[k7] = ann();
        }
        amj = anl();
        alg = new String[amj];
        alh = new String[amj];
        for (int l7 = 0; l7 < amj; l7++) {
            alg[l7] = ann();
        }
        for (int i8 = 0; i8 < amj; i8++) {
            alh[i8] = ann();
        }
        ake = anl();
        akb = new String[ake];
        amn = new int[ake];
        ana = new int[ake];
        anb = new int[ake];
        anc = new int[ake];
        and = new int[ake];
        for (int j8 = 0; j8 < ake; j8++) {
            akb[j8] = ann();
        }
        for (int k8 = 0; k8 < ake; k8++) {
            amn[k8] = anm();
        }
        for (int l8 = 0; l8 < ake; l8++) {
            ana[l8] = ank();
        }
        for (int i9 = 0; i9 < ake; i9++) {
            anb[i9] = ank();
        }
        for (int j9 = 0; j9 < ake; j9++) {
            anc[j9] = ank();
        }
        for (int k9 = 0; k9 < ake; k9++) {
            and[k9] = ank();
        }
        ObjectTotalCount = anl();
        ObjectName = new String[ObjectTotalCount];
        ObjectDescription = new String[ObjectTotalCount];
        ObjectAction1 = new String[ObjectTotalCount];
        ObjectAction2 = new String[ObjectTotalCount];
        alk = new int[ObjectTotalCount];
        all = new int[ObjectTotalCount];
        alm = new int[ObjectTotalCount];
        aln = new int[ObjectTotalCount];
        ama = new int[ObjectTotalCount];
        for (int l9 = 0; l9 < ObjectTotalCount; l9++) {
            ObjectName[l9] = ann();
        }
        for (int i10 = 0; i10 < ObjectTotalCount; i10++) {
            ObjectDescription[i10] = ann();
        }
        for (int j10 = 0; j10 < ObjectTotalCount; j10++) {
            ObjectAction1[j10] = ann();
        }
        for (int k10 = 0; k10 < ObjectTotalCount; k10++) {
            ObjectAction2[k10] = ann();
        }
        for (int l10 = 0; l10 < ObjectTotalCount; l10++) {
            alk[l10] = anj(ann());
        }
        for (int i11 = 0; i11 < ObjectTotalCount; i11++) {
            all[i11] = ank();
        }
        for (int j11 = 0; j11 < ObjectTotalCount; j11++) {
            alm[j11] = ank();
        }
        for (int k11 = 0; k11 < ObjectTotalCount; k11++) {
            aln[k11] = ank();
        }
        for (int l11 = 0; l11 < ObjectTotalCount; l11++) {
            ama[l11] = ank();
        }
        WallObjectTotalCount = anl();
        WallObjectName = new String[WallObjectTotalCount];
        WallObjectDescription = new String[WallObjectTotalCount];
        WallObjectAction1 = new String[WallObjectTotalCount];
        WallObjectAction2 = new String[WallObjectTotalCount];
        akf = new int[WallObjectTotalCount];
        akg = new int[WallObjectTotalCount];
        akh = new int[WallObjectTotalCount];
        aki = new int[WallObjectTotalCount];
        akj = new int[WallObjectTotalCount];
        for (int i12 = 0; i12 < WallObjectTotalCount; i12++) {
            WallObjectName[i12] = ann();
        }
        for (int j12 = 0; j12 < WallObjectTotalCount; j12++) {
            WallObjectDescription[j12] = ann();
        }
        for (int k12 = 0; k12 < WallObjectTotalCount; k12++) {
            WallObjectAction1[k12] = ann();
        }
        for (int l12 = 0; l12 < WallObjectTotalCount; l12++) {
            WallObjectAction2[l12] = ann();
        }
        for (int i13 = 0; i13 < WallObjectTotalCount; i13++) {
            akf[i13] = anl();
        }
        for (int j13 = 0; j13 < WallObjectTotalCount; j13++) {
            akg[j13] = anm();
        }
        for (int k13 = 0; k13 < WallObjectTotalCount; k13++) {
            akh[k13] = anm();
        }
        for (int l13 = 0; l13 < WallObjectTotalCount; l13++) {
            aki[l13] = ank();
        }
        for (int i14 = 0; i14 < WallObjectTotalCount; i14++) {
            akj[i14] = ank();
        }
        ajn = anl();
        ali = new int[ajn];
        alj = new int[ajn];
        for (int j14 = 0; j14 < ajn; j14++) {
            ali[j14] = ank();
        }
        for (int k14 = 0; k14 < ajn; k14++) {
            alj[k14] = ank();
        }
        akc = anl();
        ahd = new int[akc];
        ahe = new int[akc];
        ahf = new int[akc];
        for (int l14 = 0; l14 < akc; l14++) {
            ahd[l14] = anm();
        }
        for (int i15 = 0; i15 < akc; i15++) {
            ahe[i15] = ank();
        }
        for (int j15 = 0; j15 < akc; j15++) {
            ahf[j15] = ank();
        }
        ahg = anl();
        SpellTotalCount = anl();
        SpellName = new String[SpellTotalCount];
        SpellDescription = new String[SpellTotalCount];
        SpellLevel = new int[SpellTotalCount];
        SpellRuneCount = new int[SpellTotalCount];
        SpellStatus = new int[SpellTotalCount];
        SpellRuneID = new int[SpellTotalCount][];
        SpellRuneAmount = new int[SpellTotalCount][];
        for (int k15 = 0; k15 < SpellTotalCount; k15++) {
            SpellName[k15] = ann();
        }
        for (int l15 = 0; l15 < SpellTotalCount; l15++) {
            SpellDescription[l15] = ann();
        }
        for (int i16 = 0; i16 < SpellTotalCount; i16++) {
            SpellLevel[i16] = ank();
        }
        for (int j16 = 0; j16 < SpellTotalCount; j16++) {
            SpellRuneCount[j16] = ank();
        }
        for (int k16 = 0; k16 < SpellTotalCount; k16++) {
            SpellStatus[k16] = ank();
        }
        for (int l16 = 0; l16 < SpellTotalCount; l16++) {
            int i17 = ank();

            SpellRuneID[l16] = new int[i17];
            for (int k17 = 0; k17 < i17; k17++) {
                SpellRuneID[l16][k17] = anl();
            }
        }
        for (int j17 = 0; j17 < SpellTotalCount; j17++) {
            int l17 = ank();

            SpellRuneAmount[j17] = new int[l17];
            for (int j18 = 0; j18 < l17; j18++) {
                SpellRuneAmount[j17][j18] = ank();
            }
        }
        PrayerTotalCount = anl();
        PrayerName = new String[PrayerTotalCount];
        PrayerDescription = new String[PrayerTotalCount];
        PrayerLevel = new int[PrayerTotalCount];
        PrayerDrain = new int[PrayerTotalCount];
        for (int i18 = 0; i18 < PrayerTotalCount; i18++) {
            PrayerName[i18] = ann();
        }
        for (int k18 = 0; k18 < PrayerTotalCount; k18++) {
            PrayerDescription[k18] = ann();
        }
        for (int l18 = 0; l18 < PrayerTotalCount; l18++) {
            PrayerLevel[l18] = ank();
        }
        for (int i19 = 0; i19 < PrayerTotalCount; i19++) {
            PrayerDrain[i19] = ank();
        }
        ane = null;
        anf = null;
    }

    public static String ahb[] = new String[5000];
    public static int PrayerTotalCount;
    public static int ahd[];
    public static int ahe[];
    public static int ahf[];
    public static int ahg;
    public static String ObjectName[];
    public static String ObjectDescription[];
    public static String ObjectAction1[];
    public static String ObjectAction2[];
    public static String ahl[] = new String[5000];
    public static int SpellTotalCount;
    public static String PrayerName[];
    public static String PrayerDescription[];
    public static int NpcAttackLevel[];
    public static int NpcDefenceLevel[];
    public static int NpcStrengthLevel[];
    public static int NpcHitsLevel[];
    public static int NpcAttackableVar[];
    public static int aig[][];
    public static int SpellLevel[];
    public static int SpellRuneCount[];
    public static int SpellStatus[];
    public static int SpellRuneID[][];
    public static int SpellRuneAmount[][];
    public static int aim;
    public static int ain[];
    public static int aja[];
    public static int ajb[];
    public static int ajc[];
    public static int ItemTotalCount;
    public static int aje;
    public static int PictureOffset[];
    public static int ItemValue[];
    public static int ItemStackableVar[];
    public static int aji[];
    public static int ItemWearableVar[];
    public static int ajk[];
    public static int TradeableVar[];
    public static int MembersObjectVar[];
    public static int ajn;
    public static int ObjectTotalCount;
    public static String akb[];
    public static int akc;
    public static int WallObjectTotalCount;
    public static int ake;
    public static int akf[];
    public static int akg[];
    public static int akh[];
    public static int aki[];
    public static int akj[];
    public static int akk[];
    public static int akl[];
    public static int akm[];
    public static String WallObjectName[];
    public static String WallObjectDescription[];
    public static String WallObjectAction1[];
    public static String WallObjectAction2[];
    public static int NpcTotalCount;
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
    public static String NpcName[];
    public static String NpcDescription[];
    public static String NpcAction[];
    public static String ItemName[];
    public static String ItemDescription[];
    public static String ItemAction[];
    public static int PrayerLevel[];
    public static int PrayerDrain[];
    public static int amj;
    public static String SpellName[];
    public static String SpellDescription[];
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
