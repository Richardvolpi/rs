// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package jagex.client;

import jagex.f;
import java.applet.Applet;
import java.io.*;
import java.net.*;

public class a extends f
    implements Runnable
{

    public a(InputStream inputstream)
    {
        super(inputstream);
        e = true;
    }

    public a(Socket socket)
        throws IOException
    {
        super(socket);
        e = true;
    }

    public a(String s)
        throws IOException
    {
        super(s);
        e = true;
    }

    public a(byte abyte0[])
    {
        super(abyte0);
        e = true;
    }

    public static a b(String s, Applet applet, int i)
        throws IOException
    {
        Socket socket;
        if(applet != null)
            socket = new Socket(InetAddress.getByName(applet.getCodeBase().getHost()), i);
        else
            socket = new Socket(InetAddress.getByName(s), i);
        socket.setSoTimeout(30000);
        return new a(socket);
    }

    public void hb()
    {
        super.hb();
        if(d != null)
        {
            e = true;
            synchronized(this)
            {
                notify();
            }
            d = null;
        }
        a = null;
    }

    public void xb(byte abyte0[], int i, int j, boolean flag)
        throws IOException
    {
        if(super.ud)
            return;
        if(a == null)
            a = new byte[5000];
        synchronized(this)
        {
            for(int k = 0; k < j; k++)
            {
                a[c] = abyte0[k + i];
                c = (c + 1) % 5000;
                if(c == (b + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            if(flag)
            {
                if(d == null)
                {
                    e = false;
                    d = new Thread(this);
                    d.setDaemon(true);
                    d.setPriority(4);
                    d.start();
                }
                notify();
            }
        }
    }

    public void a()
    {
        synchronized(this)
        {
            if(c == b || a == null)
                return;
            if(d == null)
            {
                e = false;
                d = new Thread(this);
                d.setDaemon(true);
                d.setPriority(4);
                d.start();
            }
            notify();
        }
    }

    public void run()
    {
        while(d != null && !e) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(c == b)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(d == null || e)
                    return;
                j = b;
                if(c >= b)
                    i = c - b;
                else
                    i = 5000 - b;
            }
            if(i > 0)
            {
                try
                {
                    super.rd.write(a, j, i);
                }
                catch(IOException ioexception)
                {
                    super.xd = true;
                    super.yd = "Twriter:" + ioexception;
                }
                b = (b + i) % 5000;
                try
                {
                    if(c == b)
                        super.rd.flush();
                }
                catch(IOException ioexception1)
                {
                    super.xd = true;
                    super.yd = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private byte a[];
    private int b;
    private int c;
    private Thread d;
    private boolean e;
}
