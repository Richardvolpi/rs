// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ab.java

import java.io.*;
import java.net.*;

public class ab
{

    public ab()
    {
        e = z[1];
        g = false;
        try
        {
            a = InetAddress.getByName(e);
            char c1 = '\u0FA2';
            b = new Socket(a, c1);
            if(b.isBound())
            {
                System.out.println(z[2]);
                g = true;
            }
        }
        catch(UnknownHostException unknownhostexception) { }
        catch(IOException ioexception) { }
        catch(NullPointerException nullpointerexception) { }
        try
        {
            c = new BufferedWriter(new OutputStreamWriter(b.getOutputStream()));
            d = new BufferedReader(new InputStreamReader(System.in));
            do
            {
                if((f = d.readLine()) == null)
                    break;
                c.write(f);
                c.flush();
            } while(!v.R);
        }
        catch(IOException ioexception1) { }
        catch(NullPointerException nullpointerexception1)
        {
            System.out.println(z[0]);
        }
    }

    public static void a(String s)
    {
        try
        {
            c.write(s + ";");
            c.write("");
            c.flush();
            System.out.println(z[3] + s + ";");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void b(String s)
    {
        try
        {
            c.write(s + ";");
            c.write("");
            c.flush();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    InetAddress a;
    Socket b;
    public static BufferedWriter c;
    BufferedReader d;
    String e;
    String f;
    public boolean g;
    private static String z[];

    static 
    {
        String as[];
        as = new String[4];
        as[0] = "*\036JqL9=VQ\t>\020LiM]\021Vq\t\036\020WkL\036\013\031u[\022\017\\wE\004";
        as[1] = "LM\016+\031SO\0274";
        as[2] = "&A\005X\t7\036Od\t.\032KsL\017_zjG\023\032ZqL\031";
        as[3] = "&A\007X\t";
        z = as;
        break MISSING_BLOCK_LABEL_154;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 133;
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
            byte0 = 0x7d;
            break;

        case 1: // '\001'
            byte0 = 127;
            break;

        case 2: // '\002'
            byte0 = 57;
            break;

        case 3: // '\003'
            byte0 = 5;
            break;

        default:
            byte0 = 41;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 133;
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
        JVM INSTR new #150 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
