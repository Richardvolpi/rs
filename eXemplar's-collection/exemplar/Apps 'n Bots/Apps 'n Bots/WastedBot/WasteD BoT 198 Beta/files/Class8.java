 

import java.applet.Applet;
import java.net.Socket;

public class Class8
{

    public Class8()
    {
    }

    public static final void method264(String s, byte abyte0[])
    {
        aStringArray378[anInt377] = s;
        aByteArrayArray379[anInt377] = abyte0;
        anInt377++;
    }

    public static final byte[] method265(String s)
    {
        for(int i = 0; i < anInt377; i++)
            if(aStringArray378[i].equals(s))
                return aByteArrayArray379[i];

        return null;
    }

    public static final Socket method266(int i)
    {
        for(anInt372 = i; anInt372 != 0;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return aSocket373;
    }

    public static final void method267(Runnable runnable)
    {
        for(aRunnable374 = runnable; aRunnable374 != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

    }

    public static final String method268(String s)
    {
        for(aString375 = s; aString375 != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return aString376;
    }

    private static byte aByteArrayArray379[][] = new byte[50][];
    static Runnable aRunnable374 = null;
    static Socket aSocket373;
    static String aString375 = null;
    static String aString376;
    private static String aStringArray378[] = new String[50];
    public static Applet anApplet370;
    public static int anInt371;
    static int anInt372;
    static int anInt377;

}
