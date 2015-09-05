// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 09/04/2005 1:49:37 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 

import java.applet.Applet;
import java.net.Socket;

public class link
{

    public static final void cag(String arg0, byte arg1[])
    {
        dig[dif] = arg0;
        dih[dif] = arg1;
        dif++;
    }

    public static final byte[] cah(String arg0)
    {
        for(int i = 0; i < dif; i++)
            if(dig[i].equals(arg0))
                return dih[i];

        return null;
    }

    public static final Socket cai(int arg0)
    {
        for(dia = arg0; dia != 0;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return dib;
    }

    public static final void caj(Runnable arg0)
    {
        for(dic = arg0; dic != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

    }

    public static final String cak(String arg0)
    {
        for(did = arg0; did != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return die;
    }

    public link()
    {
    }

    public static Applet dhm;
    public static int dhn;
    static int dia;
    static Socket dib;
    static Runnable dic = null;
    static String did = null;
    static String die;
    static int dif;
    private static String dig[] = new String[50];
    private static byte dih[][] = new byte[50][];

}