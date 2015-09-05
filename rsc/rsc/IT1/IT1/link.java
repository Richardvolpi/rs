// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 8/21/2003 10:41:23 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 
// Source File Name:   link.java

import java.applet.Applet;
import java.net.Socket;

public class link
{

            public static Applet mainapp;
            public static int uid = 0;
            static int socketport = 0;
            static Socket s;
            static Runnable runme = null;
            static String iplookup = null;
            static String host;
            static int numfile = 0;
            private static String name[] = new String[50];
            private static byte buf[][] = new byte[50][];

            public static final void putjag(String id, byte data[])
            {
/*  23*/        name[numfile] = id;
/*  23*/        buf[numfile] = data;
/*  23*/        numfile++;
            }

            public static final byte[] getjag(String id)
            {
/*  27*/        for(int n = 0; n < numfile; n++)
/*  28*/            if(name[n].equals(id))
/*  28*/                return buf[n];

/*  30*/        return null;
            }

            public static final Socket opensocket(int port)
            {
/*  34*/        for(socketport = port; socketport != 0;)
/*  35*/            try
                    {
/*  35*/                Thread.sleep(100L);
                    }
/*  35*/            catch(Exception e) { }

/*  36*/        return s;
            }

            public static final void startthread(Runnable r)
            {
/*  40*/        for(runme = r; runme != null;)
/*  41*/            try
                    {
/*  41*/                Thread.sleep(100L);
                    }
/*  41*/            catch(Exception e) { }

            }

            public link()
            {
            }

            public static final String gethostname(String ip)
            {
/*  45*/        for(iplookup = ip; iplookup != null;)
/*  46*/            try
                    {
/*  46*/                Thread.sleep(100L);
                    }
/*  46*/            catch(Exception e) { }

/*  47*/        return host;
            }

}