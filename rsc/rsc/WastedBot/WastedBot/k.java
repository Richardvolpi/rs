// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   k.java

import java.io.IOException;

public class k
{

    public k()
    {
        int i1 = A;
        k = 3;
        l = 8;
        y = 5000;
        a = false;
        f = "";
        if(m.a)
            A = ++i1;
    }

    public void a(int ai[])
    {
        d = new i(ai);
        e = new i(ai);
    }

    public void a()
    {
    }

    public int b()
        throws IOException
    {
        return f();
    }

    public void a(int i1)
    {
        if(j > (y * 4) / 5)
            try
            {
                d(0);
            }
            catch(IOException ioexception)
            {
                a = true;
                f = ioexception.getMessage();
            }
        if(b == null)
            b = new byte[y];
        b[j + 2] = (byte)i1;
        b[j + 3] = 0;
        k = j + 3;
        l = 8;
    }

    public void b(int i1)
    {
        b[k++] = (byte)(i1 >> 24);
        b[k++] = (byte)(i1 >> 16);
        b[k++] = (byte)(i1 >> 8);
        b[k++] = (byte)i1;
    }

    public long c()
        throws IOException
    {
        long l1 = g();
        long l2 = g();
        long l3 = g();
        long l4 = g();
        return (l1 << 48) + (l2 << 32) + (l3 << 16) + l4;
    }

    public int a(byte abyte0[])
    {
        h++;
        if(i <= 0 || h <= i)
            break MISSING_BLOCK_LABEL_55;
        a = true;
        f = E;
        i += i;
        return 0;
        int i1;
label0:
        {
            if(g == 0 && e() >= 2)
            {
                g = f();
                if(g >= 160)
                    g = (g - 160) * 256 + f();
            }
            if(g <= 0 || e() < g)
                break MISSING_BLOCK_LABEL_218;
            if(g >= 160)
            {
                a(g, abyte0);
                if(!v.R)
                    break label0;
            }
            abyte0[g - 1] = (byte)f();
            if(g > 1)
                a(g - 1, abyte0);
        }
        i1 = g;
        g = 0;
        h = 0;
        return i1;
        IOException ioexception;
        ioexception;
        a = true;
        f = ioexception.getMessage();
        return 0;
    }

    public boolean d()
    {
        return j > 0;
    }

    public void a(byte abyte0[], int i1, int j1)
    {
        int k1 = 0;
        do
        {
            if(k1 >= j1)
                break;
            b[k++] = abyte0[i1 + k1];
            k1++;
        } while(!v.R);
    }

    public int e()
        throws IOException
    {
        return 0;
    }

    public int f()
        throws IOException
    {
        return 0;
    }

    public int g()
        throws IOException
    {
        int i1 = b();
        int j1 = b();
        return i1 * 256 + j1;
    }

    public int c(int i1)
    {
        return i1 - d.a() & 0xff;
    }

    public void d(int i1)
        throws IOException
    {
        if(a)
        {
            j = 0;
            k = 3;
            a = false;
            throw new IOException(f);
        }
        z++;
        if(z < i1)
            return;
        if(j > 0)
        {
            z = 0;
            b(b, 0, j);
        }
        j = 0;
        k = 3;
    }

    public void a(long l1)
    {
        b((int)(l1 >> 32));
        b((int)(l1 & -1L));
    }

    public void e(int i1)
    {
        b[k++] = (byte)(i1 >> 8);
        b[k++] = (byte)i1;
    }

    public void h()
        throws IOException
    {
        i();
        d(0);
    }

    public void b(byte abyte0[], int i1, int j1)
        throws IOException
    {
    }

    public void i()
    {
label0:
        {
            if(e != null)
            {
                int i1 = b[j + 2] & 0xff;
                b[j + 2] = (byte)(i1 + e.a());
            }
            if(l != 8)
                k++;
            int j1 = k - j - 2;
            if(j1 >= 160)
            {
                b[j] = (byte)(160 + j1 / 256);
                b[j + 1] = (byte)(j1 & 0xff);
                if(!v.R)
                    break label0;
            }
            b[j] = (byte)j1;
            k--;
            b[j + 1] = b[k];
        }
        if(y <= 10000)
        {
            int k1 = b[j + 2] & 0xff;
            C[k1]++;
            D[k1] += k - j;
        }
        j = k;
    }

    public void a(String s1)
    {
        s1.getBytes(0, s1.length(), b, k);
        k += s1.length();
    }

    public void f(int i1)
    {
        b[k++] = (byte)i1;
    }

    public void a(int i1, byte abyte0[])
        throws IOException
    {
        a(i1, 0, abyte0);
    }

    public void a(int i1, int j1, byte abyte0[])
        throws IOException
    {
    }

    protected boolean a;
    public byte b[];
    static char c[];
    public i d;
    public i e;
    protected String f;
    protected int g;
    public int h;
    public int i;
    public int j;
    private int k;
    private int l;
    final int m = 61;
    final int n = 59;
    final int o = 42;
    final int p = 43;
    final int q = 44;
    final int r = 45;
    final int s = 46;
    final int t = 47;
    final int u = 92;
    final int v = 32;
    final int w = 124;
    final int x = 34;
    protected int y;
    protected int z;
    public static int A;
    private static int B[];
    public static int C[];
    public static int D[];
    private static String E;

    static 
    {
        E = "}\006=IGf\032$";
        break MISSING_BLOCK_LABEL_123;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int j1 = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        j1;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(j1 % 5)
        {
        case 0: // '\0'
            byte0 = 9;
            break;

        case 1: // '\001'
            byte0 = 111;
            break;

        case 2: // '\002'
            byte0 = 80;
            break;

        case 3: // '\003'
            byte0 = 44;
            break;

        default:
            byte0 = 106;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        j1++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        j1;
        JVM INSTR icmpgt 26;
           goto _L5 _L1
_L5:
        JVM INSTR new #190 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 1;
        B = (new int[] {
            0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 
            1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 
            0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 
            0x3fffffff, 0x7fffffff, -1
        });
        C = new int[256];
        D = new int[256];
        c = new char[256];
        for(int i1 = 0; i1 < 256; i1++)
            c[i1] = (char)i1;

        c[61] = '=';
        c[59] = ';';
        c[42] = '*';
        c[43] = '+';
        c[44] = ',';
        c[45] = '-';
        c[46] = '.';
        c[47] = '/';
        c[92] = '\\';
        c[124] = '|';
        c[33] = '!';
        c[34] = '"';
    }
}
