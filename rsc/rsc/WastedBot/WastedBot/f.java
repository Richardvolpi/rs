// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   f.java


public class f
{

    public static int a(String s1)
    {
        if(s1.equalsIgnoreCase(Ob[0]))
            return 0;
        for(int i1 = 0; i1 < M; i1++)
            if(j[i1].equalsIgnoreCase(s1))
                return i1;

        j[M++] = s1;
        return M - 1;
    }

    public static int a()
    {
        int i1 = b[I] & 0xff;
        I++;
        return i1;
    }

    public static int b()
    {
        int i1 = m.a(b, I);
        I += 2;
        return i1;
    }

    public static int c()
    {
        int i1 = m.b(b, I);
        I += 4;
        if(i1 > 0x5f5e0ff)
            i1 = 0x5f5e0ff - i1;
        return i1;
    }

    public static String d()
    {
        String s1;
        for(s1 = ""; a[H] != 0; s1 = s1 + (char)a[H++]);
        H++;
        return s1;
    }

    public static void a(byte abyte0[], boolean flag)
    {
        boolean flag1 = v.R;
        int i1 = J;
        a = m.a(Ob[3], 0, abyte0);
        H = 0;
        b = m.a(Ob[2], 0, abyte0);
        I = 0;
        N = b();
        d = new String[N];
        e = new String[N];
        f = new String[N];
        jb = new int[N];
        kb = new int[N];
        lb = new int[N];
        mb = new int[N];
        nb = new int[N];
        ob = new int[N];
        pb = new int[N];
        qb = new int[N];
        int j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            d[j1] = d();
            j1++;
            if(!flag1)
                continue;
            int l2 = a.bb;
            a.bb = ++l2;
            break;
        } while(true);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            e[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            f[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            jb[j1] = b();
            if(jb[j1] + 1 > O)
                O = jb[j1] + 1;
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            kb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            lb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            mb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            nb[j1] = b();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            ob[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            pb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            qb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= N)
                break;
            if(!flag && qb[j1] == 1)
            {
                d[j1] = Ob[4];
                e[j1] = Ob[1];
                kb[j1] = 0;
                f[j1] = "";
                mb[0] = 0;
                nb[j1] = 0;
                pb[j1] = 1;
            }
            j1++;
        } while(!flag1);
        E = b();
        k = new String[E];
        l = new String[E];
        m = new String[E];
        V = new int[E];
        W = new int[E];
        X = new int[E];
        Y = new int[E];
        Z = new int[E];
        Mb = new int[E][12];
        cb = new int[E];
        db = new int[E];
        eb = new int[E];
        fb = new int[E];
        Q = new int[E];
        R = new int[E];
        S = new int[E];
        T = new int[E];
        U = new int[E];
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            k[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            l[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            V[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            W[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            X[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            Y[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            Z[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            int k1 = 0;
            do
            {
                if(k1 >= 12)
                    break;
                Mb[j1][k1] = a();
                if(Mb[j1][k1] == 255)
                    Mb[j1][k1] = -1;
                k1++;
            } while(!flag1);
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            cb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            db[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            eb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            fb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            Q[j1] = b();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            R[j1] = b();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            S[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            T[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            U[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= E)
                break;
            m[j1] = d();
            j1++;
        } while(!flag1);
        K = b();
        p = new String[K];
        q = new String[K];
        j1 = 0;
        do
        {
            if(j1 >= K)
                break;
            p[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= K)
                break;
            q[j1] = d();
            j1++;
        } while(!flag1);
        F = b();
        v = new String[F];
        Bb = new int[F];
        Cb = new int[F];
        Db = new int[F];
        Eb = new int[F];
        Fb = new int[F];
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            v[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            Bb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            Cb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            Db[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            Eb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= F)
                break;
            Fb[j1] = a();
            j1++;
        } while(!flag1);
        A = b();
        w = new String[A];
        x = new String[A];
        y = new String[A];
        z = new String[A];
        rb = new int[A];
        sb = new int[A];
        tb = new int[A];
        ub = new int[A];
        vb = new int[A];
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            w[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            x[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            y[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            z[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            rb[j1] = a(d());
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            sb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            tb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            ub[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= A)
                break;
            vb[j1] = a();
            j1++;
        } while(!flag1);
        G = b();
        r = new String[G];
        s = new String[G];
        t = new String[G];
        u = new String[G];
        wb = new int[G];
        xb = new int[G];
        yb = new int[G];
        zb = new int[G];
        Ab = new int[G];
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            r[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            s[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            t[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            u[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            wb[j1] = b();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            xb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            yb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            zb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= G)
                break;
            Ab[j1] = a();
            j1++;
        } while(!flag1);
        L = b();
        ab = new int[L];
        bb = new int[L];
        j1 = 0;
        do
        {
            if(j1 >= L)
                break;
            ab[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= L)
                break;
            bb[j1] = a();
            j1++;
        } while(!flag1);
        D = b();
        gb = new int[D];
        hb = new int[D];
        ib = new int[D];
        j1 = 0;
        do
        {
            if(j1 >= D)
                break;
            gb[j1] = c();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= D)
                break;
            hb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= D)
                break;
            ib[j1] = a();
            j1++;
        } while(!flag1);
        B = b();
        C = b();
        h = new String[C];
        i = new String[C];
        Ib = new int[C];
        Jb = new int[C];
        Kb = new int[C];
        Nb = new int[C][];
        Lb = new int[C][];
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            h[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            i[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            Ib[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            Jb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            Kb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            int l1 = a();
            Nb[j1] = new int[l1];
            int j2 = 0;
            do
            {
                if(j2 >= l1)
                    break;
                Nb[j1][j2] = b();
                j2++;
            } while(!flag1);
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= C)
                break;
            int i2 = a();
            Lb[j1] = new int[i2];
            int k2 = 0;
            do
            {
                if(k2 >= i2)
                    break;
                Lb[j1][k2] = a();
                k2++;
            } while(!flag1);
            j1++;
        } while(!flag1);
        P = b();
        n = new String[P];
        o = new String[P];
        Gb = new int[P];
        Hb = new int[P];
        j1 = 0;
        do
        {
            if(j1 >= P)
                break;
            n[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= P)
                break;
            o[j1] = d();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= P)
                break;
            Gb[j1] = a();
            j1++;
        } while(!flag1);
        j1 = 0;
        do
        {
            if(j1 >= P)
                break;
            Hb[j1] = a();
            j1++;
        } while(!flag1);
        a = null;
        b = null;
        if(m.a)
            J = ++i1;
    }

    static byte a[];
    static byte b[];
    public static String c[];
    public static String d[];
    public static String e[];
    public static String f[];
    public static String g[];
    public static String h[];
    public static String i[];
    public static String j[];
    public static String k[];
    public static String l[];
    public static String m[];
    public static String n[];
    public static String o[];
    public static String p[];
    public static String q[];
    public static String r[];
    public static String s[];
    public static String t[];
    public static String u[];
    public static String v[];
    public static String w[];
    public static String x[];
    public static String y[];
    public static String z[];
    public static int A;
    public static int B;
    public static int C;
    public static int D;
    public static int E;
    public static int F;
    public static int G;
    static int H;
    static int I;
    public static int J;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q[];
    public static int R[];
    public static int S[];
    public static int T[];
    public static int U[];
    public static int V[];
    public static int W[];
    public static int X[];
    public static int Y[];
    public static int Z[];
    public static int ab[];
    public static int bb[];
    public static int cb[];
    public static int db[];
    public static int eb[];
    public static int fb[];
    public static int gb[];
    public static int hb[];
    public static int ib[];
    public static int jb[];
    public static int kb[];
    public static int lb[];
    public static int mb[];
    public static int nb[];
    public static int ob[];
    public static int pb[];
    public static int qb[];
    public static int rb[];
    public static int sb[];
    public static int tb[];
    public static int ub[];
    public static int vb[];
    public static int wb[];
    public static int xb[];
    public static int yb[];
    public static int zb[];
    public static int Ab[];
    public static int Bb[];
    public static int Cb[];
    public static int Db[];
    public static int Eb[];
    public static int Fb[];
    public static int Gb[];
    public static int Hb[];
    public static int Ib[];
    public static int Jb[];
    public static int Kb[];
    public static int Lb[][];
    public static int Mb[][];
    public static int Nb[][];
    private static String Ob[];

    static 
    {
        String as[];
        as = new String[5];
        as[0] = "\f`";
        as[1] = ";nP?\n\007dA?\020\r!GzD\003!Hz\t\000dW?\020\r!Pl\001BuMv\027BnGu\001\001u";
        as[2] = "\013oQz\003\007s\013{\005\026";
        as[3] = "\021uWv\n\005/A~\020";
        as[4] = "/dH}\001\020r\005p\006\bdFk";
        Ob = as;
        break MISSING_BLOCK_LABEL_162;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 141;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i1;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i1 % 5)
        {
        case 0: // '\0'
            byte0 = 0x62;
            break;

        case 1: // '\001'
            byte0 = 1;
            break;

        case 2: // '\002'
            byte0 = 37;
            break;

        case 3: // '\003'
            byte0 = 31;
            break;

        default:
            byte0 = 100;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 141;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i1;
        JVM INSTR icmpgt 65;
           goto _L5 _L1
_L5:
        JVM INSTR new #24  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        c = new String[5000];
        g = new String[5000];
        j = new String[5000];
    }
}
