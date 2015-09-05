// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   l.java

import java.io.*;
import java.net.Socket;

public class l extends k
    implements Runnable
{

    public l(Socket socket, a a1)
        throws IOException
    {
        E = false;
        F = true;
        H = socket;
        I = socket.getInputStream();
        L = socket.getOutputStream();
        F = false;
        a1.a(this);
    }

    public void a()
    {
        super.a();
        E = true;
        try
        {
            if(I != null)
                I.close();
            if(L != null)
                L.close();
            if(H != null)
                H.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(M[3]);
        }
        F = true;
        synchronized(this)
        {
            notify();
        }
        G = null;
    }

    public int e()
        throws IOException
    {
        if(E)
            return 0;
        else
            return I.available();
    }

    public int f()
        throws IOException
    {
        if(E)
            return 0;
        else
            return I.read();
    }

    public void b(byte abyte0[], int i, int j)
        throws IOException
    {
        if(E)
            return;
        if(G == null)
            G = new byte[5000];
        synchronized(this)
        {
            int i1 = 0;
            do
            {
                if(i1 >= j)
                    break;
                G[K] = abyte0[i1 + i];
                K = (K + 1) % 5000;
                if(K == (J + 4900) % 5000)
                    throw new IOException(M[2]);
                i1++;
            } while(!v.R);
            notify();
        }
    }

    public void a(int i, int j, byte abyte0[])
        throws IOException
    {
        if(E)
            return;
        int i1 = 0;
        boolean flag = false;
        int j1;
        for(; i1 < i; i1 += j1)
            if((j1 = I.read(abyte0, i1 + j, i - i1)) <= 0)
                throw new IOException(M[0]);

    }

    public void run()
    {
        boolean flag;
        flag = v.R;
        int i = v.z;
_L3:
label0:
        {
            if(F)
                break; /* Loop/switch isn't completed */
            synchronized(this)
            {
                if(K == J)
                    try
                    {
                        wait();
                    }
                    catch(InterruptedException interruptedexception) { }
                if(!F)
                    break label0;
            }
            return;
        }
        int j;
        int i1;
label1:
        {
            i1 = J;
            if(K >= J)
            {
                j = K - J;
                if(!flag)
                    break label1;
            }
            j = 5000 - J;
        }
        l1;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        if(j <= 0) goto _L3; else goto _L2
_L2:
        try
        {
            L.write(G, i1, j);
        }
        catch(IOException ioexception)
        {
            super.a = true;
            super.f = M[1] + ioexception;
        }
        J = (J + j) % 5000;
        if(K != J) goto _L3; else goto _L4
_L4:
        L.flush();
          goto _L3
        IOException ioexception1;
        ioexception1;
        super.a = true;
        super.f = M[1] + ioexception1;
        if(!flag) goto _L3; else goto _L5
_L5:
    }

    private boolean E;
    private boolean F;
    private byte G[];
    private Socket H;
    private InputStream I;
    private int J;
    private int K;
    private OutputStream L;
    private static String M[];

    static 
    {
        String as[];
        as = new String[4];
        as[0] = "y+T";
        as[1] = "h\023`BLY\026(";
        as[2] = "^\021tM]ND}]]N\002~DO";
        as[3] = "y\026`DJ\034\007~DKU\nu\013KH\026wJU";
        M = as;
        break MISSING_BLOCK_LABEL_155;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 134;
           goto _L1 _L2
_L1:
        JVM INSTR dup ;
        i;
_L4:
        JVM INSTR dup2 ;
        JVM INSTR caload ;
        byte byte0;
        switch(i % 5)
        {
        case 0: // '\0'
            byte0 = 0x3c;
            break;

        case 1: // '\001'
            byte0 = 100;
            break;

        case 2: // '\002'
            byte0 = 18;
            break;

        case 3: // '\003'
            byte0 = 43;
            break;

        default:
            byte0 = 56;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 134;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 57;
           goto _L5 _L1
_L5:
        JVM INSTR new #158 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
