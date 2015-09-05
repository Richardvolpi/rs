import java.io.*;
import java.net.Socket;

public class Connect extends runConnect implements Runnable
{

    public Connect(Socket socket)throws IOException
    {
        bai = true;
        RSinStream = socket.getInputStream();
        RSoutStream = socket.getOutputStream();
        bai = false;
        Shell.newThread(this);
    }

    public int read() throws IOException
    {
        try {
            return RSinStream.read();
        } catch(Exception e) {
            return -1;
        }
    }

    public int avaliable()throws IOException
    {
        return RSinStream.available();
    }

    public void bam(int arg0, int arg1, byte arg2[])throws IOException
    {
        int j;
        for(int i = 0; i < arg0; i += j)
            if((j = RSinStream.read(arg2, i + arg1, arg0 - i)) <= 0)
                throw new IOException("EOF");
    }

    public void ban(byte arg0[], int arg1, int arg2)throws IOException
    {
        if(baf == null)
            baf = new byte[5000];
        synchronized(this)
        {
            for(int i = 0; i < arg2; i++)
            {
                baf[bah] = arg0[i + arg1];
                bah = (bah + 1) % 5000;
                if(bah == (bag + 4900) % 5000)
                    throw new IOException("buffer overflow");
            }
            notify();
        }
    }

    public void run()
    {
        while(!bai) 
        {
            int i;
            int j;
            synchronized(this)
            {
                if(bah == bag)
                    try{wait();}
                    catch(InterruptedException _ex) {}
                if(bai)
                    return;
                j = bag;
                if(bah >= bag)
                    i = bah - bag;
                else
                    i = 5000 - bag;
            }
            if(i > 0)
            {
                try{RSoutStream.write(baf, j, i);}
                catch(IOException ioexception)
                {
                    super.hcg = true;
                    super.errorMessage = "Twriter:" + ioexception;
                }
                bag = (bag + i) % 5000;
                try
                {
                    if(bah == bag)
                        RSoutStream.flush();
                }
                catch(IOException ioexception1)
                {
                    super.hcg = true;
                    super.errorMessage = "Twriter:" + ioexception1;
                }
            }
        }
    }

    private InputStream RSinStream;
    private OutputStream RSoutStream;
    private byte baf[];
    private int bag;
    private int bah;
    private boolean bai;
}
