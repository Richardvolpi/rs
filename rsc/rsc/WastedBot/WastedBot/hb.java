// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   hb.java


public class hb extends Thread
{

    public void run()
    {
        if(a.Qc != -1 && a.Rc != -1 && a.b(a.Qc, a.Rc))
            a.a(a.Qc, a.Rc);
    }

    hb(mudclient mudclient1)
    {
        a = mudclient1;
        start();
    }

    private final mudclient a;
}
