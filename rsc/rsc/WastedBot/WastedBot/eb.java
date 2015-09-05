// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   eb.java


public class eb extends Thread
{

    public void run()
    {
        boolean flag;
        flag = v.R;
        a.Gc = a.oj[2];
_L1:
        if(!a.Cc)
            break; /* Loop/switch isn't completed */
label0:
        {
            int i = a.Z(a.Dc);
            if(a.Cg != a.Ic)
            {
                a.ab(a.Ic);
                a.d(z);
                if(!flag)
                    break label0;
            }
            if(!a.F())
            {
                int j = a.Z(a.Dc);
                if(a.G() > 99 && !a.Fc && a.db(1263) > 0)
                {
                    a.V(1263);
                    if(!flag)
                        break label0;
                }
                if(a.Cg != a.Ic)
                {
                    a.ab(a.Ic);
                    a.d(z);
                    if(!flag)
                        break label0;
                }
                if(j != -1)
                {
                    a.Y(j);
                    try
                    {
                        Thread.sleep(1000L);
                        break label0;
                    }
                    catch(Exception exception1) { }
                    if(!flag)
                        break label0;
                }
                try
                {
                    Thread.sleep(10L);
                    break label0;
                }
                catch(Exception exception2) { }
                if(!flag)
                    break label0;
            }
            if(!a.F())
                break label0;
            if(a.Cg != a.Ic)
            {
                a.ab(a.Ic);
                a.d(z);
                if(!flag)
                    break label0;
            }
            try
            {
                Thread.sleep(300L);
            }
            catch(Exception exception3) { }
        }
        a.B();
          goto _L1
        Exception exception;
        exception;
        if(!flag) goto _L1; else goto _L2
_L2:
    }

    eb(mudclient mudclient1)
    {
        a = mudclient1;
        start();
    }

    private final mudclient a;
    private static String z;

    static 
    {
        z = "T\002&cKR\t1~es@\017~l|\024$xoq@=x+X\017*|np-&sn";
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
            byte0 = 0x14;
            break;

        case 1: // '\001'
            byte0 = 96;
            break;

        case 2: // '\002'
            byte0 = 73;
            break;

        case 3: // '\003'
            byte0 = 23;
            break;

        default:
            byte0 = 11;
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
        JVM INSTR new #101 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
        intern();
        JVM INSTR swap ;
        JVM INSTR pop ;
        JVM INSTR ret 0;
    }
}
