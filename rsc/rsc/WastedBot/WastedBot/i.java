// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   i.java


public final class i
{

    public i(int ai[])
    {
        f = new int[256];
        e = new int[256];
        for(int j = 0; j < ai.length; j++)
            e[j] = ai[j];

        c();
    }

    public final int a()
    {
        if(a-- == 0)
        {
            b();
            a = 255;
        }
        return e[a];
    }

    private final void b()
    {
        int j = k.A;
        c += ++d;
        for(int l = 0; l < 256; l++)
        {
            int i1 = f[l];
            switch(l & 3)
            {
            case 0: // '\0'
                b ^= b << 13;
                break;

            case 1: // '\001'
                b ^= b >>> 6;
                break;

            case 2: // '\002'
                b ^= b << 2;
                break;

            case 3: // '\003'
                b ^= b >>> 16;
                break;
            }
            b += f[l + 128 & 0xff];
            int j1;
            f[l] = j1 = f[(i1 & 0x3fc) >> 2] + b + c;
            e[l] = c = f[(j1 >> 8 & 0x3fc) >> 2] + i1;
        }

    }

    private final void c()
    {
        boolean flag = v.R;
        int j = k.A;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2 = l = i1 = j1 = k1 = l1 = i2 = j2 = 0x9e3779b9;
        int l2 = 0;
        do
        {
            if(l2 >= 4)
                break;
            k2 ^= l << 11;
            j1 += k2;
            l += i1;
            l ^= i1 >>> 2;
            k1 += l;
            i1 += j1;
            i1 ^= j1 << 8;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 >>> 16;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 << 10;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 >>> 4;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 << 8;
            l += i2;
            j2 += k2;
            j2 ^= k2 >>> 9;
            i1 += j2;
            k2 += l;
            l2++;
        } while(!flag);
        l2 = 0;
        do
        {
            if(l2 >= 256)
                break;
            k2 += e[l2];
            l += e[l2 + 1];
            i1 += e[l2 + 2];
            j1 += e[l2 + 3];
            k1 += e[l2 + 4];
            l1 += e[l2 + 5];
            i2 += e[l2 + 6];
            j2 += e[l2 + 7];
            k2 ^= l << 11;
            j1 += k2;
            l += i1;
            l ^= i1 >>> 2;
            k1 += l;
            i1 += j1;
            i1 ^= j1 << 8;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 >>> 16;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 << 10;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 >>> 4;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 << 8;
            l += i2;
            j2 += k2;
            j2 ^= k2 >>> 9;
            i1 += j2;
            k2 += l;
            f[l2] = k2;
            f[l2 + 1] = l;
            f[l2 + 2] = i1;
            f[l2 + 3] = j1;
            f[l2 + 4] = k1;
            f[l2 + 5] = l1;
            f[l2 + 6] = i2;
            f[l2 + 7] = j2;
            l2 += 8;
        } while(!flag);
        l2 = 0;
        do
        {
            if(l2 >= 256)
                break;
            k2 += f[l2];
            l += f[l2 + 1];
            i1 += f[l2 + 2];
            j1 += f[l2 + 3];
            k1 += f[l2 + 4];
            l1 += f[l2 + 5];
            i2 += f[l2 + 6];
            j2 += f[l2 + 7];
            k2 ^= l << 11;
            j1 += k2;
            l += i1;
            l ^= i1 >>> 2;
            k1 += l;
            i1 += j1;
            i1 ^= j1 << 8;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 >>> 16;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 << 10;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 >>> 4;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 << 8;
            l += i2;
            j2 += k2;
            j2 ^= k2 >>> 9;
            i1 += j2;
            k2 += l;
            f[l2] = k2;
            f[l2 + 1] = l;
            f[l2 + 2] = i1;
            f[l2 + 3] = j1;
            f[l2 + 4] = k1;
            f[l2 + 5] = l1;
            f[l2 + 6] = i2;
            f[l2 + 7] = j2;
            l2 += 8;
        } while(!flag);
        b();
        a = 256;
    }

    private int a;
    private int b;
    private int c;
    private int d;
    private int e[];
    private int f[];
}
