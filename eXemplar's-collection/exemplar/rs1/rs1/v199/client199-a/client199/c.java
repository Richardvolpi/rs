// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

public class c extends Frame
{

    public c(a arg0, int arg1, int arg2, String arg3, boolean arg4, boolean arg5)
    {
        fek = 28;
        feh = arg1;
        fei = arg2;
        fel = arg0;
        if(arg5)
            fek = 48;
        else
            fek = 28;
        setTitle(arg3);
        setResizable(arg4);
        show();
        toFront();
        resize(feh, fei);
        fem = getGraphics();
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
        if(fej == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + fek);
    }

    public boolean handleEvent(Event arg0)
    {
        if(arg0.id == 401)
            fel.keyDown(arg0, arg0.key);
        else
        if(arg0.id == 402)
            fel.keyUp(arg0, arg0.key);
        else
        if(arg0.id == 501)
            fel.mouseDown(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 506)
            fel.mouseDrag(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 502)
            fel.mouseUp(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 503)
            fel.mouseMove(arg0, arg0.x, arg0.y - 24);
        else
        if(arg0.id == 201)
            fel.destroy();
        else
        if(arg0.id == 1001)
            fel.action(arg0, arg0.target);
        else
        if(arg0.id == 403)
            fel.keyDown(arg0, arg0.key);
        else
        if(arg0.id == 404)
            fel.keyUp(arg0, arg0.key);
        return true;
    }

    public final void paint(Graphics g)
    {
        fel.paint(g);
    }

    int feh;
    int fei;
    int fej;
    int fek;
    a fel;
    Graphics fem;
}
