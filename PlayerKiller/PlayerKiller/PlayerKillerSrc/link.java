import java.applet.Applet;
import java.net.Socket;

public class link
{

    public static final void gae(String s, byte abyte0[])
    {
        gac[gab] = s;
        gad[gab] = abyte0;
        gab++;
    }

    public static final byte[] gaf(String arg0)
    {
        for(int i = 0; i < gab; i++)
            if(gac[i].equals(arg0))
                return gad[i];

        return null;
    }

    public static final Socket gag(int arg0)
    {
        for(fnk = arg0; fnk != 0;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return fnl;
    }

    public static final void gah(Runnable arg0)
    {
        for(fnm = arg0; fnm != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

    }

    public static final String gai(String arg0)
    {
        for(fnn = arg0; fnn != null;)
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }

        return gaa;
    }

    public link()
    {
    }

    public static Applet fni;
    public static int fnj;
    static int fnk;
    static Socket fnl;
    static Runnable fnm = null;
    static String fnn = null;
    static String gaa;
    static int gab;
    private static String gac[] = new String[50];
    private static byte gad[][] = new byte[50][];

}
