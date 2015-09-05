// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 

import java.awt.*;

public class Frame_Sub1 extends Frame
{

    public Frame_Sub1(Applet_Sub1 applet_sub1, int i, int j, String s, boolean flag, boolean flag1)
    {
        anInt47 = 28;
        anInt44 = i;
        anInt45 = j;
        anApplet_Sub1_48 = applet_sub1;
        if(flag1)
            anInt47 = 48;
        else
            anInt47 = 28;
        setTitle(s);
        setResizable(flag);
        show();
        toFront();
        resize(anInt44, anInt45);
        aGraphics49 = getGraphics();
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
if(anInt46 == 0)
            g.translate(0, 29);
        else
            g.translate(-1, 0);
        return g;
    }

    public boolean handleEvent(Event event)
    {
        int i = Class6.anInt352;
        if(event.id == 401)
            anApplet_Sub1_48.keyDown(event, event.key);
        else
        if(event.id == 402)
            anApplet_Sub1_48.keyUp(event, event.key);
        else
        if(event.id == 501)
            anApplet_Sub1_48.mouseDown(event, event.x, event.y - 24);
        else
        if(event.id == 506)
            anApplet_Sub1_48.mouseDrag(event, event.x, event.y - 24);
        else
        if(event.id == 502)
            anApplet_Sub1_48.mouseUp(event, event.x, event.y - 24);
        else
        if(event.id == 503)
            anApplet_Sub1_48.mouseMove(event, event.x, event.y - 24);
        else
        if(event.id == 201)
            anApplet_Sub1_48.destroy();
        else
        if(event.id == 1001)
            anApplet_Sub1_48.action(event, event.target);
        else
        if(event.id == 403)
            anApplet_Sub1_48.keyDown(event, event.key);
        else
        if(event.id == 404)
            anApplet_Sub1_48.keyUp(event, event.key);
        return true;
    }

    public final void paint(Graphics g)
    {
        anApplet_Sub1_48.paint(g);
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + anInt47);
    }

    Graphics aGraphics49;
    Applet_Sub1 anApplet_Sub1_48;
    int anInt44;
    int anInt45;
    int anInt46;
    int anInt47;
}
