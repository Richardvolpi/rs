// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   bb.java

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class bb
{

    public bb()
    {
        d = null;
        try
        {
            char c1 = '\u0FA1';
            a = new ServerSocket(c1);
            b = a.accept();
            if(b.isBound())
                System.out.println(z[1]);
        }
        catch(IOException ioexception) { }
        try
        {
            c = new BufferedReader(new InputStreamReader(b.getInputStream()));
            do
            {
                d = c.readLine();
                System.out.println(z[0] + d);
                mudclient.i(d);
            } while(true);
        }
        catch(IOException ioexception1)
        {
            return;
        }
    }

    ServerSocket a;
    Socket b;
    BufferedReader c;
    String d;
    private static String z[];

    static 
    {
        String as[];
        as = new String[2];
        as[0] = "\026u179";
        as[1] = "\026w179\007({\0139\036,\177\034|?iN\005w#,n\036|)";
        z = as;
        break MISSING_BLOCK_LABEL_139;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 118;
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
            byte0 = 0x4d;
            break;

        case 1: // '\001'
            byte0 = 73;
            break;

        case 2: // '\002'
            byte0 = 13;
            break;

        case 3: // '\003'
            byte0 = 106;
            break;

        default:
            byte0 = 25;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 118;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 41;
           goto _L5 _L1
_L5:
        JVM INSTR new #98  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
