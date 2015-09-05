// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import java.awt.*;

// Referenced classes of package jagex.client:
//            k

public class d extends Frame
{

    public d(k k1, int i, int j, String s, boolean flag, boolean flag1)
    {
        nc = 28;
        kc = i;
        lc = j;
        oc = k1;
        if(flag1)
            nc = 48;
        else
            nc = 28;
        setTitle(s);
        setResizable(flag);
        show();
        toFront();
        resize(kc, lc);
        pc = getGraphics();
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
        if(mc == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + nc);
    }

    public int c()
    {
        return size().width;
    }

    public int d()
    {
        return size().height - nc;
    }

    public boolean handleEvent(Event event)
    {
        if(event.id == 401)
            oc.keyDown(event, event.key);
        else
        if(event.id == 402)
            oc.keyUp(event, event.key);
        else
        if(event.id == 501)
            oc.mouseDown(event, event.x, event.y - 24);
        else
        if(event.id == 506)
            oc.mouseDrag(event, event.x, event.y - 24);
        else
        if(event.id == 502)
            oc.mouseUp(event, event.x, event.y - 24);
        else
        if(event.id == 503)
            oc.mouseMove(event, event.x, event.y - 24);
        else
        if(event.id == 201)
            oc.destroy();
        else
        if(event.id == 1001)
            oc.action(event, event.target);
        else
        if(event.id == 403)
            oc.keyDown(event, event.key);
        else
        if(event.id == 404)
            oc.keyUp(event, event.key);
        return true;
    }

    public final void paint(Graphics g)
    {
        oc.paint(g);
    }

    int kc;
    int lc;
    int mc;
    int nc;
    k oc;
    Graphics pc;
}
