// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:47:30 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.awt.*;

public class c extends Frame
{

    public c(a arg0, int arg1, int arg2, String arg3, boolean arg4, boolean arg5)
    {
        adi = 28;
        adf = arg1;
        adg = arg2;
        adj = arg0;
        if(arg5)
            adi = 48;
        else
            adi = 28;
        setTitle(arg3);
        setResizable(arg4);
        show();
        toFront();
        adb(adf, adg);
        adk = ada();
    }

    public Graphics ada()
    {
        Graphics g = super.getGraphics();
        if(adh == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void adb(int arg0, int arg1)
    {
        super.resize(arg0, arg1 + adi);
    }

    public boolean adc(Event arg0)
    {
        if(arg0.id == 401)
            adj.aic(arg0, arg0.key);
        else
        if(arg0.id == 402)
            adj.aie(arg0, arg0.key);
        else
        if(arg0.id == 501)
            adj.aih(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 506)
            adj.aij(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 502)
            adj.aig(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 503)
            adj.aif(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 201)
            adj.destroy();
        else
        if(arg0.id == 1001)
            adj.action(arg0, arg0.target);
        else
        if(arg0.id == 403)
            adj.aic(arg0, arg0.key);
        else
        if(arg0.id == 404)
            adj.aie(arg0, arg0.key);
        return true;
    }

    public final void add(Graphics arg0)
    {
        adj.ajd(arg0);
    }

    int adf;
    int adg;
    int adh;
    int adi;
    a adj;
    Graphics adk;
}