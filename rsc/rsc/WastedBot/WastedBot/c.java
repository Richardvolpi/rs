// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   c.java

import java.awt.*;

public class c extends Frame
{

    public c(a a1, int i, int j, String s, boolean flag, boolean flag1)
    {
        f = 28;
        c = i;
        d = j;
        b = a1;
        if(flag1)
            f = 48;
        else
            f = 28;
        setTitle(s);
        setResizable(flag);
        show();
        toFront();
        resize(c, d);
        a = getGraphics();
    }

    public Graphics getGraphics()
    {
        Graphics g = super.getGraphics();
        if(e == 0)
            g.translate(0, 24);
        else
            g.translate(-5, 0);
        return g;
    }

    public boolean handleEvent(Event event)
    {
label0:
        {
            boolean flag = v.R;
            int i = v.z;
            if(event.id == 401)
            {
                b.keyDown(event, event.key);
                if(!flag)
                    break label0;
            }
            if(event.id == 402)
            {
                b.keyUp(event, event.key);
                if(!flag)
                    break label0;
            }
            if(event.id == 501)
            {
                b.mouseDown(event, event.x, event.y - 24);
                if(!flag)
                    break label0;
            }
            if(event.id == 506)
            {
                b.mouseDrag(event, event.x, event.y - 24);
                if(!flag)
                    break label0;
            }
            if(event.id == 502)
            {
                b.mouseUp(event, event.x, event.y - 24);
                if(!flag)
                    break label0;
            }
            if(event.id == 503)
            {
                b.mouseMove(event, event.x, event.y - 24);
                if(!flag)
                    break label0;
            }
            if(event.id == 201)
            {
                b.destroy();
                if(!flag)
                    break label0;
            }
            if(event.id == 1001)
            {
                b.action(event, event.target);
                if(!flag)
                    break label0;
            }
            if(event.id == 403)
            {
                b.keyDown(event, event.key);
                if(!flag)
                    break label0;
            }
            if(event.id == 404)
                b.keyUp(event, event.key);
        }
        return true;
    }

    public final void paint(Graphics g)
    {
        if(!b.j)
            b.paint(g);
        else
            return;
    }

    public void resize(int i, int j)
    {
        super.resize(i, j + f);
    }

    Graphics a;
    a b;
    int c;
    int d;
    int e;
    int f;
}
