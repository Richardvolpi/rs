// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   db.java

import java.io.PrintStream;

class db extends Thread
{

    private db()
    {
    }

    public void run()
    {
        System.out.println(z);
        a.a = new ab();
    }

    db(e e1)
    {
        this();
    }

    private static String z;

    static 
    {
        z = "9&*w\0165ye^K&Zy~\016!t\177O@\0268E^O\020lsN";
        break MISSING_BLOCK_LABEL_123;
        local;
        toCharArray();
        JVM INSTR dup ;
        JVM INSTR arraylength .length;
        JVM INSTR swap ;
        int i = 0;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        1;
        JVM INSTR icmpgt 102;
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
            byte0 = 0x62;
            break;

        case 1: // '\001'
            byte0 = 24;
            break;

        case 2: // '\002'
            byte0 = 22;
            break;

        case 3: // '\003'
            byte0 = 42;
            break;

        default:
            byte0 = 46;
            break;
        }
        byte0;
        JVM INSTR ixor ;
        (char);
        JVM INSTR castore ;
        i++;
        JVM INSTR swap ;
        JVM INSTR dup_x1 ;
        JVM INSTR ifne 102;
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
        JVM INSTR new #44  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
