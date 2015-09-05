// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:58 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 


public final class p
{

    public p(int arg0[])
    {
        adn = new int[256];
        adm = new int[256];
        for(int i = 0; i < arg0.length; i++)
            adm[i] = arg0[i];

        adh();
    }

    public final int adf()
    {
        if(adl-- == 0)
        {
            adg();
            adl = 255;
        }
        return adm[adl];
    }

    private final void adg()
    {
        aeb += ++aec;
        for(int i = 0; i < 256; i++)
        {
            int j = adn[i];
            switch(i & 3)
            {
            case 0: // '\0'
                aea ^= aea << 13;
                break;

            case 1: // '\001'
                aea ^= aea >>> 6;
                break;

            case 2: // '\002'
                aea ^= aea << 2;
                break;

            case 3: // '\003'
                aea ^= aea >>> 16;
                break;
            }
            aea += adn[i + 128 & 0xff];
            int k;
            adn[i] = k = adn[(j & 0x3fc) >> 2] + aea + aeb;
            adm[i] = aeb = adn[(k >> 8 & 0x3fc) >> 2] + j;
        }

    }

    private final void adh()
    {
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
            l += adm[j];
            i1 += adm[j + 1];
            j1 += adm[j + 2];
            k1 += adm[j + 3];
            l1 += adm[j + 4];
            i2 += adm[j + 5];
            j2 += adm[j + 6];
            k2 += adm[j + 7];
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
            adn[j] = l;
            adn[j + 1] = i1;
            adn[j + 2] = j1;
            adn[j + 3] = k1;
            adn[j + 4] = l1;
            adn[j + 5] = i2;
            adn[j + 6] = j2;
            adn[j + 7] = k2;
        }

        for(int k = 0; k < 256; k += 8)
        {
            l += adn[k];
            i1 += adn[k + 1];
            j1 += adn[k + 2];
            k1 += adn[k + 3];
            l1 += adn[k + 4];
            i2 += adn[k + 5];
            j2 += adn[k + 6];
            k2 += adn[k + 7];
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
            adn[k] = l;
            adn[k + 1] = i1;
            adn[k + 2] = j1;
            adn[k + 3] = k1;
            adn[k + 4] = l1;
            adn[k + 5] = i2;
            adn[k + 6] = j2;
            adn[k + 7] = k2;
        }

        adg();
        adl = 256;
    }

    private int adl;
    private int adm[];
    private int adn[];
    private int aea;
    private int aeb;
    private int aec;
}