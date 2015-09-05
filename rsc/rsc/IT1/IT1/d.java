// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 8/22/2003 12:52:19 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 

import a.a.g;
import java.awt.Component;

public class d extends g
{

    public mudclient L;

    public d(int i, int j, int k, Component component)
    {
        super(i, j, k, component);
        boolean flag = false;
        if(flag)
            new g(i, j, k, component);
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        if(i1 >= 50000)
        {
            L.a(i, j, k, l, i1 - 50000, j1, k1);
            return;
        }
        if(i1 >= 40000)
        {
            L.b(i, j, k, l, i1 - 40000, j1, k1);
            return;
        }
        if(i1 >= 20000) //npcs drawing
        {
            L.c(i, j, k, l, i1 - 20000, j1, k1);
            return;
        }
        if(i1 >= 5000) //pc drawing
        {
            L.d(i, j, k, l, i1 - 5000, j1, k1);
            return;
        } else
        {
            super.f(i, j, k, l, i1);
            return;
        }
    }
}