// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   cb.java

import java.io.PrintStream;

class cb extends Thread
{

    private cb()
    {
    }

    public void run()
    {
        System.out.println(z);
        a.b = new bb();
    }

    cb(e e1)
    {
        this();
    }

    private static String z;

    static 
    {
        z = "8;P\b\003)d\0324\0030`\036#F\021%?!B\021q\t1";
        break MISSING_BLOCK_LABEL_122;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 101;
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
            byte0 = 0x63;
            break;

        case 1: // '\001'
            byte0 = 5;
            break;

        case 2: // '\002'
            byte0 = 108;
            break;

        case 3: // '\003'
            byte0 = 85;
            break;

        default:
            byte0 = 35;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 101;
           goto _L3 _L2
_L3:
        JVM INSTR dup2 ;
        JVM INSTR swap ;
          goto _L4
_L2:
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        i;
        JVM INSTR icmpgt 26;
           goto _L5 _L1
_L5:
        JVM INSTR new #45  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
