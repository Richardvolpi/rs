 

import java.io.*;
import java.net.Socket;

public class Class14_Sub1 extends Class14
    implements Runnable
{

    public Class14_Sub1(Socket socket, Applet_Sub1 applet_sub1)
        throws IOException
    {
        aBoolean645 = false;
        aBoolean649 = true;
        aSocket644 = socket;
        anInputStream642 = socket.getInputStream();
        anOutputStream643 = socket.getOutputStream();
        aBoolean649 = false;
        applet_sub1.RunMoveable(this);
    }
    

    public void method329()
    {
	        super.method329();
	        aBoolean645 = true;
	        try
	        {
	            if(anInputStream642 != null)
	                anInputStream642.close();
	            if(anOutputStream643 != null)
	                anOutputStream643.close();
	            if(aSocket644 != null)
	                aSocket644.close();
	        }
	        catch(IOException _ex)
	        {
	            System.out.println("Error closing stream");
	        }
	        aBoolean649 = true;
	        synchronized(this)
	        {
	            notify();
	        }
	        aByteArray646 = null;
    }

    public int method337()
        throws IOException
    {
        if(aBoolean645)
            return 0;
        else
            return anInputStream642.available();
    }

    public int method338()
        throws IOException
    {
        if(aBoolean645)
            return 0;
        else
            return anInputStream642.read();
    }

    public void method345(byte abyte0[], int i, int j)
        throws IOException
    {
        if(aBoolean645)
            return;
        if(aByteArray646 == null)
            aByteArray646 = new byte[5000];
        synchronized(this)
        {
            for(int k = 0; k < j; k++)
            {
                aByteArray646[anInt648] = abyte0[k + i];
                anInt648 = (anInt648 + 1) % 5000;
                if(anInt648 == (anInt647 + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }

            notify();
        }
    }

    public void method350(int i, int j, byte abyte0[])
        throws IOException
    {
        if(aBoolean645)
            return;
        int k = 0;
        boolean flag = false;
        int l;
        for(; k < i; k += l)
            if((l = anInputStream642.read(abyte0, k + j, i - k)) <= 0)
                throw new IOException("EOF");

    }

    public void run()
    {
        int k = Class6.anInt352;
        while(!aBoolean649) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(anInt648 == anInt647)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException _ex) { }
                if(aBoolean649)
                    return;
                j = anInt647;
                if(anInt648 >= anInt647)
                    i = anInt648 - anInt647;
                else
                    i = 5000 - anInt647;
            }
            if(i > 0)
            {
                try
                {
                    anOutputStream643.write(aByteArray646, j, i);
                }
                catch(IOException ioexception)
                {
                    super.aBoolean551 = true;
                    super.aString552 = "Twriter:" + ioexception;
                }
                anInt647 = (anInt647 + i) % 5000;
                try
                {
                    if(anInt648 == anInt647)
                        anOutputStream643.flush();
                }
                catch(IOException ioexception1)
                {
                    super.aBoolean551 = true;
                    super.aString552 = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private boolean aBoolean645;
    private boolean aBoolean649;
    private byte aByteArray646[];
    private Socket aSocket644;
    private InputStream anInputStream642;
    private int anInt647;
    private int anInt648;
    private OutputStream anOutputStream643;
}
