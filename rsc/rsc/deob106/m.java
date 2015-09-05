// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import jagex.client.i;
import java.awt.Component;

public class m extends i
{

    public m(int j, int k, int l, Component component)
    {
        super(j, k, l, component);
        boolean flag = false;
        if(flag)
            new i(j, k, l, component);
    }

    public void jg(int j, int k, int l, int i1, int j1, int k1, int l1)
    {
        if(j1 >= 40000)
        {
            ns.zm(j, k, l, i1, j1 - 40000, k1, l1);
            return;
        }
        if(j1 >= 20000)
        {
            ns.en(j, k, l, i1, j1 - 20000, k1, l1);
            return;
        }
        if(j1 >= 5000)
        {
            ns.vl(j, k, l, i1, j1 - 5000, k1, l1);
            return;
        } else
        {
            super.uf(j, k, l, i1, j1);
            return;
        }
    }

    public mudclient ns;
}
