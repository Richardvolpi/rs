// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:50:09 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;

public class s extends r
    implements Runnable
{

    public s(Socket arg0, a arg1)
        throws IOException
    {
        bec = false;
        beg = true;
        beb = arg0;
        bdn = arg0.getInputStream();
        bea = arg0.getOutputStream();
        beg = false;
        arg1.akc(this);
    }

    public void bfi()
    {
        super.bfi();
        bec = true;
        try
        {
            if(bdn != null)
                bdn.close();
            if(bea != null)
                bea.close();
            if(beb != null)
                beb.close();
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
        beg = true;
        synchronized(this)
        {
            notify();
        }
        bed = null;
    }

    public int bfl()
        throws IOException
    {
        if(bec)
            return 0;
        else
            return bdn.read();
    }

    public int bga()
        throws IOException
    {
        if(bec)
            return 0;
        else
            return bdn.available();
    }

    public void bfk(int arg0, int arg1, byte arg2[])
        throws IOException
    {
        if(bec)
            return;
        int i = 0;
        boolean flag = false;
        int k;
        for(; i < arg0; i += k)
            if((k = bdn.read(arg2, i + arg1, arg0 - i)) <= 0)
                throw new IOException("EOF");

    }

    public void bgg(byte arg0[], int arg1, int arg2)
        throws IOException
    {
        if(bec)
            return;
        if(bed == null)
            bed = new byte[5000];
        synchronized(this)
        {
            for(int i = 0; i < arg2; i++)
            {
                bed[bef] = arg0[i + arg1];
                bef = (bef + 1) % 5000;
                if(bef == (bee + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            notify();
        }
    }

    public void run()
    {
        while(!beg) 
        {
            int i;
            int k;
            synchronized(this)
            {
                if(bef == bee)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(beg)
                    return;
                k = bee;
                if(bef >= bee)
                    i = bef - bee;
                else
                    i = 5000 - bee;
            }
            if(i > 0)
            {
                try
                {
                    bea.write(bed, k, i);
                }
                catch(IOException ioexception)
                {
                    super.bkl = true;
                    super.bkk = "Twriter:" + ioexception;
                }
                bee = (bee + i) % 5000;
                try
                {
                    if(bef == bee)
                        bea.flush();
                }
                catch(IOException ioexception1)
                {
                    super.bkl = true;
                    super.bkk = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private InputStream bdn;
    private OutputStream bea;
    private Socket beb;
    private boolean bec;
    private byte bed[];
    private int bee;
    private int bef;
    private boolean beg;
}