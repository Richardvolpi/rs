// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   w.java

import java.awt.Component;

public final class w extends v
{

    public w(int i, int j, int k, Component component)
    {
        super(i, j, k, component);
        boolean flag = false;
        if(flag)
            new v(i, j, k, component);
    }

    public final void a(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        if(i1 >= 50000)
        {
            S.a(i, j, k, l, i1 - 50000, j1, k1);
            return;
        }
        if(i1 >= 40000)
        {
            S.b(i, j, k, l, i1 - 40000, j1, k1);
            return;
        }
        if(i1 >= 20000)
        {
            S.c(i, j, k, l, i1 - 20000, j1, k1);
            return;
        }
        if(i1 >= 5000)
        {
            S.d(i, j, k, l, i1 - 5000, j1, k1);
            return;
        } else
        {
            super.f(i, j, k, l, i1);
            return;
        }
    }

    public mudclient S;
}
