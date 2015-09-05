// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

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
            dai.fam(i, l, i1, j1, k1 - 50000, l1, i2);
            return;
        }
        if(k1 >= 40000)
        {
            dai.fcl(i, l, i1, j1, k1 - 40000, l1, i2);
            return;
        }
        if(k1 >= 20000)
        {
            dai.fca(i, l, i1, j1, k1 - 20000, l1, i2);
            return;
        }
        if(k1 >= 5000)
        {
            dai.fdk(i, l, i1, j1, k1 - 5000, l1, i2);
            return;
        } else
        {
            super.ccc(i, l, i1, j1, k1);
            return;
        }
    }

    public mudclient dai;
}
