// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 8/22/2003 3:55:48 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 

import a.f;

public class b
{

    public static int a;
    public static int b;
    public static String c[]; //names of the items in Runescape
    public static String d[]; //description of the items
    public static String e[]; //Special actions if you can 'eat' or 'drink' it
    public static int f[]; //graphcis lookup for item?
    public static int g[]; //prices of items (must modify)
    public static int h[]; //is item stackable
    public static int i[];
    public static int j[];
    public static int k[];
    public static int l[];
    public static int m[];
    public static int n;
    public static String o[]; //npc names
    public static String p[]; //npc descriptions
    public static String q[]; //"pickpocket" command if you can pickpocket them
    public static int r[]; //npc stat?
    public static int s[]; //npc hp
    public static int t[]; //npc stat?
    public static int u[]; //npc stat?
    public static int v[];
    public static int w[][];
    public static int x[];
    public static int y[];
    public static int z[];
    public static int A[];
    public static int B[];
    public static int C[];
    public static int D[];
    public static int E[];
    public static int F[];
    public static int G;
    public static String H[]; //terain names e.g. wall
    public static String I[];
    public static int J;
    public static String K[];
    public static int L[];
    public static int M[];
    public static int N[];
    public static int O[];
    public static int P[];
    public static int Q;
    public static String R[]; //object names e.g. Rock
    public static String S[];
    public static String T[];
    public static String U[];
    public static int V[];
    public static int W[];
    public static int X[];
    public static int Y[];
    public static int Z[];
    public static int ba;
    public static String bb[];
    public static String bc[];
    public static String bd[];
    public static String be[];
    public static int bf[];
    public static int bg[];
    public static int bh[];
    public static int bi[];
    public static int bj[];
    public static int bk;
    public static int bl[];
    public static int bm[];
    public static int bn;
    public static int bo[];
    public static int bp[];
    public static int bq[];
    public static int br;
    public static int bs;
    public static String bt[]; //spells
    public static String bu[];
    public static int bv[];
    public static int bw[];
    public static int bx[];
    public static int by[][];
    public static int bz[][];
    public static int bA;
    public static String bB[];
    public static String bC[];
    public static int bD[];
    public static int bE[];
    public static String bF[] = new String[5000];
    public static String bG[] = new String[5000];
    public static int bH;
    public static String bI[] = new String[5000];
    static byte bJ[];
    static byte bK[];
    static int bL;
    static int bM;
    public static int bN;

    public static int a(String s1)
    {
        int i1;
        if(s1.equalsIgnoreCase("na"))
            return 0;
        i1 = 0;
        if(bN == 0) goto _L2; else goto _L1
_L1:
        if(bI[i1].equalsIgnoreCase(s1))
            return i1;
        i1++;
_L2:
        if(i1 >= bH)
        {
            bI[bH++] = s1;
            return bH - 1;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static int a()
    {
        int i1 = bK[bM] & 0xff;
        bM++;
        return i1;
    }

    public static int b()
    {
        int i1 = a.f.a(bK, bM);
        bM += 2;
        return i1;
    }

    public static int c()
    {
        int i1 = a.f.b(bK, bM);
        bM += 4;
        if(i1 > 0x5f5e0ff)
            i1 = 0x5f5e0ff - i1;
        return i1;
    }

    public static String d() //get the next String
    {
        String s1 = "";
        if(bN == 0) goto _L2; else goto _L1
_L1:
        s1 = s1 + (char)bJ[bL++];
_L2:
        if(bJ[bL] == 0)
        {
            bL++;
            return s1;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void a(byte abyte0[], boolean flag)
    {
        int i1;
        int i19;
        i19 = bN;
        bJ = a.f.a("string.dat", 0, abyte0);
        bL = 0;
        bK = a.f.a("integer.dat", 0, abyte0);
        bM = 0;
        a = b();
        c = new String[a];
        d = new String[a];
        e = new String[a];
        f = new int[a];
        g = new int[a];
        h = new int[a];
        i = new int[a];
        j = new int[a];
        k = new int[a];
        l = new int[a];
        m = new int[a];
        i1 = 0;
        if(i19 == 0) goto _L2; else goto _L1
_L1:
        c[i1] = d();
        i1++;
_L2:
        if(i1 < a) goto _L1; else goto _L3
_L3:
        int j1 = 0;
        if(i19 == 0) goto _L5; else goto _L4
_L4:
        d[j1] = d();
        j1++;
_L5:
        if(j1 < a) goto _L4; else goto _L6
_L6:
        int k1 = 0;
        if(i19 == 0) goto _L8; else goto _L7
_L7:
        e[k1] = d();
        k1++;
_L8:
        if(k1 < a) goto _L7; else goto _L9
_L9:
        int l1 = 0;
        if(i19 == 0) goto _L11; else goto _L10
_L10:
        f[l1] = b();
        if(f[l1] + 1 > b)
            b = f[l1] + 1;
        l1++;
_L11:
        if(l1 < a) goto _L10; else goto _L12
_L12:
        int i2 = 0;
        if(i19 == 0) goto _L14; else goto _L13
_L13:
        g[i2] = c();
        i2++;
_L14:
        if(i2 < a) goto _L13; else goto _L15
_L15:
        int j2 = 0;
        if(i19 == 0) goto _L17; else goto _L16
_L16:
        h[j2] = a();
        j2++;
_L17:
        if(j2 < a) goto _L16; else goto _L18
_L18:
        int k2 = 0;
        if(i19 == 0) goto _L20; else goto _L19
_L19:
        i[k2] = a();
        k2++;
_L20:
        if(k2 < a) goto _L19; else goto _L21
_L21:
        int l2 = 0;
        if(i19 == 0) goto _L23; else goto _L22
_L22:
        j[l2] = b();
        l2++;
_L23:
        if(l2 < a) goto _L22; else goto _L24
_L24:
        int i3 = 0;
        if(i19 == 0) goto _L26; else goto _L25
_L25:
        k[i3] = c();
        i3++;
_L26:
        if(i3 < a) goto _L25; else goto _L27
_L27:
        int j3 = 0;
        if(i19 == 0) goto _L29; else goto _L28
_L28:
        l[j3] = a();
        j3++;
_L29:
        if(j3 < a) goto _L28; else goto _L30
_L30:
        int k3 = 0;
        if(i19 == 0) goto _L32; else goto _L31
_L31:
        m[k3] = a();
        k3++;
_L32:
        if(k3 < a) goto _L31; else goto _L33
_L33:
        int l3 = 0;
        if(i19 == 0) goto _L35; else goto _L34
_L34:
        if(!flag && m[l3] == 1)
        {
            c[l3] = "Members object";
            d[l3] = "You need to be a member to use this object";
            g[l3] = 0;
            e[l3] = "";
            i[0] = 0;
            j[l3] = 0;
            l[l3] = 1;
        }
        l3++;
_L35:
        if(l3 < a) goto _L34; else goto _L36
_L36:
        int i4;
        n = b();
        o = new String[n];
        p = new String[n];
        q = new String[n];
        r = new int[n];
        s = new int[n];
        t = new int[n];
        u = new int[n];
        v = new int[n];
        w = new int[n][12];
        x = new int[n];
        y = new int[n];
        z = new int[n];
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        E = new int[n];
        F = new int[n];
        i4 = 0;
        if(i19 == 0) goto _L38; else goto _L37
_L37:
        o[i4] = d();
        i4++;
_L38:
        if(i4 < n) goto _L37; else goto _L39
_L39:
        int j4 = 0;
        if(i19 == 0) goto _L41; else goto _L40
_L40:
        p[j4] = d();
        j4++;
_L41:
        if(j4 < n) goto _L40; else goto _L42
_L42:
        int k4 = 0;
        if(i19 == 0) goto _L44; else goto _L43
_L43:
        r[k4] = a();
        k4++;
_L44:
        if(k4 < n) goto _L43; else goto _L45
_L45:
        int l4 = 0;
        if(i19 == 0) goto _L47; else goto _L46
_L46:
        s[l4] = a();
        l4++;
_L47:
        if(l4 < n) goto _L46; else goto _L48
_L48:
        int i5 = 0;
        if(i19 == 0) goto _L50; else goto _L49
_L49:
        t[i5] = a();
        i5++;
_L50:
        if(i5 < n) goto _L49; else goto _L51
_L51:
        int j5 = 0;
        if(i19 == 0) goto _L53; else goto _L52
_L52:
        u[j5] = a();
        j5++;
_L53:
        if(j5 < n) goto _L52; else goto _L54
_L54:
        int k5 = 0;
        if(i19 == 0) goto _L56; else goto _L55
_L55:
        v[k5] = a();
        k5++;
_L56:
        if(k5 < n) goto _L55; else goto _L57
_L57:
        int l5 = 0;
        if(i19 == 0) goto _L59; else goto _L58
_L58:
        int i6 = 0;
        if(i19 == 0) goto _L61; else goto _L60
_L60:
        w[l5][i6] = a();
        if(w[l5][i6] == 255)
            w[l5][i6] = -1;
        i6++;
_L61:
        if(i6 < 12) goto _L60; else goto _L62
_L62:
        l5++;
_L59:
        if(l5 < n) goto _L58; else goto _L63
_L63:
        i6 = 0;
        if(i19 == 0) goto _L65; else goto _L64
_L64:
        x[i6] = c();
        i6++;
_L65:
        if(i6 < n) goto _L64; else goto _L66
_L66:
        int j6 = 0;
        if(i19 == 0) goto _L68; else goto _L67
_L67:
        y[j6] = c();
        j6++;
_L68:
        if(j6 < n) goto _L67; else goto _L69
_L69:
        int k6 = 0;
        if(i19 == 0) goto _L71; else goto _L70
_L70:
        z[k6] = c();
        k6++;
_L71:
        if(k6 < n) goto _L70; else goto _L72
_L72:
        int l6 = 0;
        if(i19 == 0) goto _L74; else goto _L73
_L73:
        A[l6] = c();
        l6++;
_L74:
        if(l6 < n) goto _L73; else goto _L75
_L75:
        int i7 = 0;
        if(i19 == 0) goto _L77; else goto _L76
_L76:
        B[i7] = b();
        i7++;
_L77:
        if(i7 < n) goto _L76; else goto _L78
_L78:
        int j7 = 0;
        if(i19 == 0) goto _L80; else goto _L79
_L79:
        C[j7] = b();
        j7++;
_L80:
        if(j7 < n) goto _L79; else goto _L81
_L81:
        int k7 = 0;
        if(i19 == 0) goto _L83; else goto _L82
_L82:
        D[k7] = a();
        k7++;
_L83:
        if(k7 < n) goto _L82; else goto _L84
_L84:
        int l7 = 0;
        if(i19 == 0) goto _L86; else goto _L85
_L85:
        E[l7] = a();
        l7++;
_L86:
        if(l7 < n) goto _L85; else goto _L87
_L87:
        int i8 = 0;
        if(i19 == 0) goto _L89; else goto _L88
_L88:
        F[i8] = a();
        i8++;
_L89:
        if(i8 < n) goto _L88; else goto _L90
_L90:
        int j8 = 0;
        if(i19 == 0) goto _L92; else goto _L91
_L91:
        q[j8] = d();
        j8++;
_L92:
        if(j8 < n) goto _L91; else goto _L93
_L93:
        int k8;
        G = b();
        H = new String[G];
        I = new String[G];
        k8 = 0;
        if(i19 == 0) goto _L95; else goto _L94
_L94:
        H[k8] = d();
        k8++;
_L95:
        if(k8 < G) goto _L94; else goto _L96
_L96:
        int l8 = 0;
        if(i19 == 0) goto _L98; else goto _L97
_L97:
        I[l8] = d();
        l8++;
_L98:
        if(l8 < G) goto _L97; else goto _L99
_L99:
        int i9;
        J = b();
        K = new String[J];
        L = new int[J];
        M = new int[J];
        N = new int[J];
        O = new int[J];
        P = new int[J];
        i9 = 0;
        if(i19 == 0) goto _L101; else goto _L100
_L100:
        K[i9] = d();
        i9++;
_L101:
        if(i9 < J) goto _L100; else goto _L102
_L102:
        int j9 = 0;
        if(i19 == 0) goto _L104; else goto _L103
_L103:
        L[j9] = c();
        j9++;
_L104:
        if(j9 < J) goto _L103; else goto _L105
_L105:
        int k9 = 0;
        if(i19 == 0) goto _L107; else goto _L106
_L106:
        M[k9] = a();
        k9++;
_L107:
        if(k9 < J) goto _L106; else goto _L108
_L108:
        int l9 = 0;
        if(i19 == 0) goto _L110; else goto _L109
_L109:
        N[l9] = a();
        l9++;
_L110:
        if(l9 < J) goto _L109; else goto _L111
_L111:
        int i10 = 0;
        if(i19 == 0) goto _L113; else goto _L112
_L112:
        O[i10] = a();
        i10++;
_L113:
        if(i10 < J) goto _L112; else goto _L114
_L114:
        int j10 = 0;
        if(i19 == 0) goto _L116; else goto _L115
_L115:
        P[j10] = a();
        j10++;
_L116:
        if(j10 < J) goto _L115; else goto _L117
_L117:
        int k10;
        Q = b();
        R = new String[Q];
        S = new String[Q];
        T = new String[Q];
        U = new String[Q];
        V = new int[Q];
        W = new int[Q];
        X = new int[Q];
        Y = new int[Q];
        Z = new int[Q];
        k10 = 0;
        if(i19 == 0) goto _L119; else goto _L118
_L118:
        R[k10] = d();
        k10++;
_L119:
        if(k10 < Q) goto _L118; else goto _L120
_L120:
        int l10 = 0;
        if(i19 == 0) goto _L122; else goto _L121
_L121:
        S[l10] = d();
        l10++;
_L122:
        if(l10 < Q) goto _L121; else goto _L123
_L123:
        int i11 = 0;
        if(i19 == 0) goto _L125; else goto _L124
_L124:
        T[i11] = d();
        i11++;
_L125:
        if(i11 < Q) goto _L124; else goto _L126
_L126:
        int j11 = 0;
        if(i19 == 0) goto _L128; else goto _L127
_L127:
        U[j11] = d();
        j11++;
_L128:
        if(j11 < Q) goto _L127; else goto _L129
_L129:
        int k11 = 0;
        if(i19 == 0) goto _L131; else goto _L130
_L130:
        V[k11] = a(d());
        k11++;
_L131:
        if(k11 < Q) goto _L130; else goto _L132
_L132:
        int l11 = 0;
        if(i19 == 0) goto _L134; else goto _L133
_L133:
        W[l11] = a();
        l11++;
_L134:
        if(l11 < Q) goto _L133; else goto _L135
_L135:
        int i12 = 0;
        if(i19 == 0) goto _L137; else goto _L136
_L136:
        X[i12] = a();
        i12++;
_L137:
        if(i12 < Q) goto _L136; else goto _L138
_L138:
        int j12 = 0;
        if(i19 == 0) goto _L140; else goto _L139
_L139:
        Y[j12] = a();
        j12++;
_L140:
        if(j12 < Q) goto _L139; else goto _L141
_L141:
        int k12 = 0;
        if(i19 == 0) goto _L143; else goto _L142
_L142:
        Z[k12] = a();
        k12++;
_L143:
        if(k12 < Q) goto _L142; else goto _L144
_L144:
        int l12;
        ba = b();
        bb = new String[ba];
        bc = new String[ba];
        bd = new String[ba];
        be = new String[ba];
        bf = new int[ba];
        bg = new int[ba];
        bh = new int[ba];
        bi = new int[ba];
        bj = new int[ba];
        l12 = 0;
        if(i19 == 0) goto _L146; else goto _L145
_L145:
        bb[l12] = d();
        l12++;
_L146:
        if(l12 < ba) goto _L145; else goto _L147
_L147:
        int i13 = 0;
        if(i19 == 0) goto _L149; else goto _L148
_L148:
        bc[i13] = d();
        i13++;
_L149:
        if(i13 < ba) goto _L148; else goto _L150
_L150:
        int j13 = 0;
        if(i19 == 0) goto _L152; else goto _L151
_L151:
        bd[j13] = d();
        j13++;
_L152:
        if(j13 < ba) goto _L151; else goto _L153
_L153:
        int k13 = 0;
        if(i19 == 0) goto _L155; else goto _L154
_L154:
        be[k13] = d();
        k13++;
_L155:
        if(k13 < ba) goto _L154; else goto _L156
_L156:
        int l13 = 0;
        if(i19 == 0) goto _L158; else goto _L157
_L157:
        bf[l13] = b();
        l13++;
_L158:
        if(l13 < ba) goto _L157; else goto _L159
_L159:
        int i14 = 0;
        if(i19 == 0) goto _L161; else goto _L160
_L160:
        bg[i14] = c();
        i14++;
_L161:
        if(i14 < ba) goto _L160; else goto _L162
_L162:
        int j14 = 0;
        if(i19 == 0) goto _L164; else goto _L163
_L163:
        bh[j14] = c();
        j14++;
_L164:
        if(j14 < ba) goto _L163; else goto _L165
_L165:
        int k14 = 0;
        if(i19 == 0) goto _L167; else goto _L166
_L166:
        bi[k14] = a();
        k14++;
_L167:
        if(k14 < ba) goto _L166; else goto _L168
_L168:
        int l14 = 0;
        if(i19 == 0) goto _L170; else goto _L169
_L169:
        bj[l14] = a();
        l14++;
_L170:
        if(l14 < ba) goto _L169; else goto _L171
_L171:
        int i15;
        bk = b();
        bl = new int[bk];
        bm = new int[bk];
        i15 = 0;
        if(i19 == 0) goto _L173; else goto _L172
_L172:
        bl[i15] = a();
        i15++;
_L173:
        if(i15 < bk) goto _L172; else goto _L174
_L174:
        int j15 = 0;
        if(i19 == 0) goto _L176; else goto _L175
_L175:
        bm[j15] = a();
        j15++;
_L176:
        if(j15 < bk) goto _L175; else goto _L177
_L177:
        int k15;
        bn = b();
        bo = new int[bn];
        bp = new int[bn];
        bq = new int[bn];
        k15 = 0;
        if(i19 == 0) goto _L179; else goto _L178
_L178:
        bo[k15] = c();
        k15++;
_L179:
        if(k15 < bn) goto _L178; else goto _L180
_L180:
        int l15 = 0;
        if(i19 == 0) goto _L182; else goto _L181
_L181:
        bp[l15] = a();
        l15++;
_L182:
        if(l15 < bn) goto _L181; else goto _L183
_L183:
        int i16 = 0;
        if(i19 == 0) goto _L185; else goto _L184
_L184:
        bq[i16] = a();
        i16++;
_L185:
        if(i16 < bn) goto _L184; else goto _L186
_L186:
        int j16;
        br = b();
        bs = b();
        bt = new String[bs];
        bu = new String[bs];
        bv = new int[bs];
        bw = new int[bs];
        bx = new int[bs];
        by = new int[bs][];
        bz = new int[bs][];
        j16 = 0;
        if(i19 == 0) goto _L188; else goto _L187
_L187:
        bt[j16] = d();
        j16++;
_L188:
        if(j16 < bs) goto _L187; else goto _L189
_L189:
        int k16 = 0;
        if(i19 == 0) goto _L191; else goto _L190
_L190:
        bu[k16] = d();
        k16++;
_L191:
        if(k16 < bs) goto _L190; else goto _L192
_L192:
        int l16 = 0;
        if(i19 == 0) goto _L194; else goto _L193
_L193:
        bv[l16] = a();
        l16++;
_L194:
        if(l16 < bs) goto _L193; else goto _L195
_L195:
        int i17 = 0;
        if(i19 == 0) goto _L197; else goto _L196
_L196:
        bw[i17] = a();
        i17++;
_L197:
        if(i17 < bs) goto _L196; else goto _L198
_L198:
        int j17 = 0;
        if(i19 == 0) goto _L200; else goto _L199
_L199:
        bx[j17] = a();
        j17++;
_L200:
        if(j17 < bs) goto _L199; else goto _L201
_L201:
        int k17 = 0;
        if(i19 == 0) goto _L203; else goto _L202
_L202:
        int l17;
        int i18;
        l17 = a();
        by[k17] = new int[l17];
        i18 = 0;
        if(i19 == 0) goto _L205; else goto _L204
_L204:
        by[k17][i18] = b();
        i18++;
_L205:
        if(i18 < l17) goto _L204; else goto _L206
_L206:
        k17++;
_L203:
        if(k17 < bs) goto _L202; else goto _L207
_L207:
        l17 = 0;
        if(i19 == 0) goto _L209; else goto _L208
_L208:
        int j18;
        i18 = a();
        bz[l17] = new int[i18];
        j18 = 0;
        if(i19 == 0) goto _L211; else goto _L210
_L210:
        bz[l17][j18] = a();
        j18++;
_L211:
        if(j18 < i18) goto _L210; else goto _L212
_L212:
        l17++;
_L209:
        if(l17 < bs) goto _L208; else goto _L213
_L213:
        bA = b();
        bB = new String[bA];
        bC = new String[bA];
        bD = new int[bA];
        bE = new int[bA];
        i18 = 0;
        if(i19 == 0) goto _L215; else goto _L214
_L214:
        bB[i18] = d();
        i18++;
_L215:
        if(i18 < bA) goto _L214; else goto _L216
_L216:
        j18 = 0;
        if(i19 == 0) goto _L218; else goto _L217
_L217:
        bC[j18] = d();
        j18++;
_L218:
        if(j18 < bA) goto _L217; else goto _L219
_L219:
        int k18 = 0;
        if(i19 == 0) goto _L221; else goto _L220
_L220:
        bD[k18] = a();
        k18++;
_L221:
        if(k18 < bA) goto _L220; else goto _L222
_L222:
        int l18 = 0;
        if(i19 == 0) goto _L224; else goto _L223
_L223:
        bE[l18] = a();
        l18++;
_L224:
        if(l18 >= bA)
        {
            bJ = null;
            bK = null;
            if(f.c != 0)
                bN = ++i19;
            return;
        }
        if(true) goto _L223; else goto _L225
_L225:
    }

}