// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

public class ffg extends Frame
{

    public ffg(fjb fjb1, int i, int j, String s, boolean flag, boolean flag1)
    {
        ffk = 28;
        ffh = i;
        ffi = j;
        ffl = fjb1;
        if(flag1)
            ffk = 48;
        else
            ffk = 28;
        setTitle(s);
        setResizable(flag);
        show();
        toFront();
        resize(ffh, ffi);
        ffm = getGraphics();
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
        g.translate(0, 24);
        return g;
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + ffk);
    }

    public boolean handleEvent(Event event)
    {
        boolean flag = false;
        if(event.id == 401)
            ffl.keyDown(event, event.key);
        else
        if(event.id == 402)
            ffl.keyUp(event, event.key);
        else
        if(event.id == 501)
            ffl.mouseDown(event, event.x, event.y - 24);
        else
        if(event.id == 506)
            ffl.mouseDrag(event, event.x, event.y - 24);
        else
        if(event.id == 502)
            ffl.mouseUp(event, event.x, event.y - 24);
        else
        if(event.id == 503)
            ffl.mouseMove(event, event.x, event.y - 24);
        else
        if(event.id == 201)
            ffl.destroy();
        else
        if(event.id == 1001)
            ffl.action(event, event.target);
        else
        if(event.id == 403)
            ffl.keyDown(event, event.key);
        else
        if(event.id == 404)
            ffl.keyUp(event, event.key);
        return true;
    }

    public final void paint(Graphics g)
    {
        ffl.paint(g);
    }

    int ffh;
    int ffi;
    int ffj;
    int ffk;
    fjb ffl;
    Graphics ffm;
}
