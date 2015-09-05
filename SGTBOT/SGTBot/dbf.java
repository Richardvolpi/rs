// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.Component;

public final class dbf extends blm
{

    public dbf(int i, int j, int k, Component component)
    {
        super(i, j, k, component);
        boolean flag = false;
    }

    public final void cdj(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        if(i1 >= 50000)
        {
            dbg.enk(i, j, k, l, i1 - 50000, j1, k1);
            return;
        }
        if(i1 >= 40000)
        {
            dbg.fcl(i, j, k, l, i1 - 40000, j1, k1);
            return;
        }
        if(i1 >= 20000)
        {
            dbg.fff(i, j, k, l, i1 - 20000, j1, k1);
            return;
        }
        if(i1 >= 5000)
        {
            dbg.fdj(i, j, k, l, i1 - 5000, j1, k1);
            return;
        } else
        {
            super.ccj(i, j, k, l, i1);
            return;
        }
    }

    public mudclient dbg;
}
