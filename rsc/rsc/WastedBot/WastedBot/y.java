// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   y.java

import java.applet.Applet;
import java.net.Socket;

public class y
{

    public static final byte[] a(String s)
    {
        int i = 0;
        do
        {
            if(i >= h)
                break;
            if(e[i].equals(s))
                return a[i];
            i++;
        } while(!v.R);
        return null;
    }

    public static final Socket a(int i)
    {
        g = i;
_L1:
        if(g == 0)
            break; /* Loop/switch isn't completed */
        Thread.sleep(100L);
          goto _L1
        Exception exception;
        exception;
        if(!v.R) goto _L1; else goto _L2
_L2:
        return c;
    }

    public static final void a(Runnable runnable)
    {
        b = runnable;
_L1:
        if(b == null)
            break; /* Loop/switch isn't completed */
        Thread.sleep(100L);
          goto _L1
        Exception exception;
        exception;
        if(!v.R) goto _L1; else goto _L2
_L2:
    }

    private static byte a[][] = new byte[50][];
    static Runnable b = null;
    static Socket c;
    static String d = null;
    private static String e[] = new String[50];
    public static Applet f;
    static int g;
    static int h;

}
