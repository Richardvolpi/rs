// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   n.java


public class n
{

    public static void a(j j1, j j2, j j3, j j4)
    {
        b(j2);
        c(j3);
        d(j1);
        a(j4);
    }

    public static void a(j j1)
    {
        int l = k.A;
        int i1 = j1.c();
        f = new char[i1][];
        j = new int[i1];
        for(int k1 = 0; k1 < i1; k1++)
        {
            j[k1] = j1.a();
            char ac[] = new char[j1.a()];
            for(int l1 = 0; l1 < ac.length; l1++)
                ac[l1] = (char)j1.a();

            f[k1] = ac;
        }

    }

    public static void b(j j1)
    {
        int l = j1.c();
        d = new char[l][];
        b = new byte[l][][];
        a(j1, d, b);
    }

    public static void c(j j1)
    {
        int l = j1.c();
        e = new char[l][];
        c = new byte[l][][];
        a(j1, e, c);
    }

    public static void d(j j1)
    {
        i = new int[j1.c()];
        for(int l = 0; l < i.length; l++)
            i[l] = j1.b();

    }

    public static void a(j j1, char ac[][], byte abyte0[][][])
    {
        boolean flag = v.R;
        int l = k.A;
        int i1 = 0;
        do
        {
            if(i1 >= ac.length)
                break;
            char ac1[] = new char[j1.a()];
            int k1 = 0;
            do
            {
                if(k1 >= ac1.length)
                    break;
                ac1[k1] = (char)j1.a();
                k1++;
            } while(!flag);
            ac[i1] = ac1;
            byte abyte1[][] = new byte[j1.c()][2];
            int l1 = 0;
            do
            {
                if(l1 >= abyte1.length)
                    break;
                abyte1[l1][0] = (byte)j1.a();
                abyte1[l1][1] = (byte)j1.a();
                l1++;
            } while(!flag);
            if(abyte1.length > 0)
                abyte0[i1] = abyte1;
            i1++;
        } while(!flag);
    }

    public static String a(String s)
    {
        return s;
    }

    static boolean a;
    static byte b[][][];
    static byte c[][][];
    static char d[][];
    static char e[][];
    static char f[][];
    static String g[];
    static int h;
    static int i[];
    static int j[];

    static 
    {
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int l = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 94;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        l;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(l % 5)
        {
        case 0: // '\0'
            byte0 = 0x4a;
            break;

        case 1: // '\001'
            byte0 = 81;
            break;

        case 2: // '\002'
            byte0 = 99;
            break;

        case 3: // '\003'
            byte0 = 101;
            break;

        default:
            byte0 = 52;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        l++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 94;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        l;
        JVM INSTR icmpgt 18;
           goto _L5 _L1
_L5:
        JVM INSTR new #19  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
        a = true;
        String as[] = new String[5];
        as[0] = ")>\f\016";
        as[1] = ")>\f\016\0239";
        as[2] = ")>\f\016G";
        as[3] = "94\006\016G";
        as[4] = "99\006\000@";
        g = as;
        h = 3;
    }
}
