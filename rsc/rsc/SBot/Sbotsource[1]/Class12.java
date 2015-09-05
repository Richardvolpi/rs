// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 


public final class Class12
{

    public Class12(int ai[])
    {
        anIntArray516 = new int[256];
        anIntArray515 = new int[256];
        for(int i = 0; i < ai.length; i++)
            anIntArray515[i] = ai[i];

        method318();
    }

    public final int method316()
    {
        if(anInt514-- == 0)
        {
            method317();
            anInt514 = 255;
        }
        return anIntArray515[anInt514];
    }

    public final void method317()
    {
        int l = Class14.anInt553;
        anInt518 += ++anInt519;
        for(int i = 0; i < 256; i++)
        {
            int j = anIntArray516[i];
            switch(i & 3)
            {
            case 0: // '\0'
                anInt517 ^= anInt517 << 13;
                break;

            case 1: // '\001'
                anInt517 ^= anInt517 >>> 6;
                break;

            case 2: // '\002'
                anInt517 ^= anInt517 << 2;
                break;

            case 3: // '\003'
                anInt517 ^= anInt517 >>> 16;
                break;
            }
            anInt517 += anIntArray516[i + 128 & 0xff];
            int k;
            anIntArray516[i] = k = anIntArray516[(j & 0x3fc) >> 2] + anInt517 + anInt518;
            anIntArray515[i] = anInt518 = anIntArray516[(k >> 8 & 0x3fc) >> 2] + j;
        }

    }

    public final void method318()
    {
        int l2 = Class14.anInt553;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l = i1 = j1 = k1 = l1 = i2 = j2 = k2 = 0x9e3779b9;
        for(int i = 0; i < 4; i++)
        {
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
        }

        for(int j = 0; j < 256; j += 8)
        {
            l += anIntArray515[j];
            i1 += anIntArray515[j + 1];
            j1 += anIntArray515[j + 2];
            k1 += anIntArray515[j + 3];
            l1 += anIntArray515[j + 4];
            i2 += anIntArray515[j + 5];
            j2 += anIntArray515[j + 6];
            k2 += anIntArray515[j + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            anIntArray516[j] = l;
            anIntArray516[j + 1] = i1;
            anIntArray516[j + 2] = j1;
            anIntArray516[j + 3] = k1;
            anIntArray516[j + 4] = l1;
            anIntArray516[j + 5] = i2;
            anIntArray516[j + 6] = j2;
            anIntArray516[j + 7] = k2;
        }

        for(int k = 0; k < 256; k += 8)
        {
            l += anIntArray516[k];
            i1 += anIntArray516[k + 1];
            j1 += anIntArray516[k + 2];
            k1 += anIntArray516[k + 3];
            l1 += anIntArray516[k + 4];
            i2 += anIntArray516[k + 5];
            j2 += anIntArray516[k + 6];
            k2 += anIntArray516[k + 7];
            l ^= i1 << 11;
            k1 += l;
            i1 += j1;
            i1 ^= j1 >>> 2;
            l1 += i1;
            j1 += k1;
            j1 ^= k1 << 8;
            i2 += j1;
            k1 += l1;
            k1 ^= l1 >>> 16;
            j2 += k1;
            l1 += i2;
            l1 ^= i2 << 10;
            k2 += l1;
            i2 += j2;
            i2 ^= j2 >>> 4;
            l += i2;
            j2 += k2;
            j2 ^= k2 << 8;
            i1 += j2;
            k2 += l;
            k2 ^= l >>> 9;
            j1 += k2;
            l += i1;
            anIntArray516[k] = l;
            anIntArray516[k + 1] = i1;
            anIntArray516[k + 2] = j1;
            anIntArray516[k + 3] = k1;
            anIntArray516[k + 4] = l1;
            anIntArray516[k + 5] = i2;
            anIntArray516[k + 6] = j2;
            anIntArray516[k + 7] = k2;
        }

        method317();
        anInt514 = 256;
    }

    public int anInt514;
    public int anInt517;
    public int anInt518;
    public int anInt519;
    public int anIntArray515[];
    public int anIntArray516[];
}
