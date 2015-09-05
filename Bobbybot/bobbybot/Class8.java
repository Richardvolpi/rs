// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nonlb 

import java.applet.Applet;
import java.net.Socket;

public class Class8 {

    public static void method263(String s, byte abyte0[]) {
        aStringArray378[anInt377] = s;
        aByteArrayArray379[anInt377] = abyte0;
        anInt377++;
    }

    public static byte[] method264(String s) {
        for(int i = 0; i < anInt377; i++)
            if(aStringArray378[i].equals(s))
                return aByteArrayArray379[i];

        return null;
    }

    public static Socket method265(int i) {
        for(anInt372 = i; anInt372 != 0;)
            try {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return aSocket373;
    }

    public static void method266(Runnable runnable) {
        for(aRunnable374 = runnable; aRunnable374 != null;)
            try {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

    }

    public static String method267(String s) {
        for(aString375 = s; aString375 != null;)
            try {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return aString376;
    }

    public Class8() {
    }

    public static Applet anApplet370;
    public static int anInt371;
    public static int anInt372;
    public static Socket aSocket373;
    public static Runnable aRunnable374 = null;
    public static String aString375 = null;
    public static String aString376;
    public static int anInt377;
    public static String aStringArray378[] = new String[50];
    public static byte aByteArrayArray379[][] = new byte[50][];

}
