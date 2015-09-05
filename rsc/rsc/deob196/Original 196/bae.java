// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

import java.io.*;
import java.net.Socket;

public class bae extends hcg
    implements Runnable
{

    public bae(Socket socket, fjb fjb1)
        throws IOException
    {
        bai = false;
        bam = true;
        bah = socket;
        baf = socket.getInputStream();
        bag = socket.getOutputStream();
        bam = false;
        fjb1.fde(this);
    }

    public void ban()
    {
        super.ban();
        bai = true;
        try
        {
            if(baf != null)
                baf.close();
            if(bag != null)
                bag.close();
            if(bah != null)
                bah.close();
        }
        catch(IOException _ex)
        {
            System.out.println("Error closing stream");
        }
        bam = true;
        synchronized(this)
        {
            notify();
        }
        baj = null;
    }

    public int bba()
        throws IOException
    {
        if(bai)
            return 0;
        else
            return baf.read();
    }

    public int bbb()
        throws IOException
    {
        if(bai)
            return 0;
        else
            return baf.available();
    }

    public void bbc(int i, int j, byte abyte0[])
        throws IOException
    {
        if(bai)
            return;
        int k = 0;
        boolean flag = false;
        int l;
        for(; k < i; k += l)
            if((l = baf.read(abyte0, k + j, i - k)) <= 0)
                throw new IOException("EOF");

    }

    public void bbd(byte abyte0[], int i, int j)
        throws IOException
    {
        if(bai)
            return;
        if(baj == null)
            baj = new byte[5000];
        synchronized(this)
        {
            for(int k = 0; k < j; k++)
            {
                baj[bal] = abyte0[k + i];
                bal = (bal + 1) % 5000;
                if(bal == (bak + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            notify();
        }
    }

    public void run()
    {
        boolean flag = false;
        while(!bam) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(bal == bak)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(bam)
                    return;
                j = bak;
                if(bal >= bak)
                    i = bal - bak;
                else
                    i = 5000 - bak;
            }
            if(i > 0)
            {
                try
                {
                    bag.write(baj, j, i);
                }
                catch(IOException ioexception)
                {
                    super.hed = true;
                    super.heh = "Twriter:" + ioexception;
                }
                bak = (bak + i) % 5000;
                try
                {
                    if(bal == bak)
                        bag.flush();
                }
                catch(IOException ioexception1)
                {
                    super.hed = true;
                    super.heh = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private InputStream baf;
    private OutputStream bag;
    private Socket bah;
    private boolean bai;
    private byte baj[];
    private int bak;
    private int bal;
    private boolean bam;
}
