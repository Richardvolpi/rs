// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:30 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.awt.Component;

public final class k extends j
{

    public k(int arg0, int arg1, int arg2, Component arg3)
    {
        super(arg0, arg1, arg2, arg3);
        boolean flag = false;
        if(flag)
            new j(arg0, arg1, arg2, arg3);
    }

    public final void bdb(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6)
    {
        if(arg4 >= 50000)
        {
            aaa.bmi(arg0, arg1, arg2, arg3, arg4 - 50000, arg5, arg6);
            return;
        }
        if(arg4 >= 40000)
        {
            aaa.bhk(arg0, arg1, arg2, arg3, arg4 - 40000, arg5, arg6);
            return;
        }
        if(arg4 >= 20000)
        {
            aaa.bja(arg0, arg1, arg2, arg3, arg4 - 20000, arg5, arg6);
            return;
        }
        if(arg4 >= 5000)
        {
            aaa.bjd(arg0, arg1, arg2, arg3, arg4 - 5000, arg5, arg6);
            return;
        } else
        {
            super.bcb(arg0, arg1, arg2, arg3, arg4);
            return;
        }
    }

    public mudclient aaa;
}