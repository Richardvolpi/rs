/*
 * deobfuscatorzed by saevion
 * thanks to the apache-jarkarta group for
 * the bcel and regexp libraries
 * decompiled by JAD
 */

import java.awt.Component;

public final class k extends j
{

    public k(int i, int l, int i1, Component component)
    {
        super(i, l, i1, component);
        boolean flag = false;
        if(flag)
            new j(i, l, i1, component);
    }

    public final void cdc(int i, int l, int i1, int j1, int k1, int l1, int i2)
    {
        if(k1 >= 50000)
        {
            dai.fde(i, l, i1, j1, k1 - 50000, l1, i2);
            return;
        }
        if(k1 >= 40000)
        {
            dai.fed(i, l, i1, j1, k1 - 40000, l1, i2);
            return;
        }
        if(k1 >= 20000)
        {
            dai.fab(i, l, i1, j1, k1 - 20000, l1, i2);
            return;
        }
        if(k1 >= 5000)
        {
            dai.fcf(i, l, i1, j1, k1 - 5000, l1, i2);
            return;
        } else
        {
            super.ccc(i, l, i1, j1, k1);
            return;
        }
    }

    
}
