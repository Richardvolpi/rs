// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 10/11/2003 9:16:06 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   loader.java

import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.zip.ZipFile;

public class loader2 extends Applet
    implements Runnable
{

    public final void init()
    {
        try
        {
            if(getParameter("forcems").equals("1") && System.getProperties().getProperty("java.vendor").toLowerCase().indexOf("sun") != -1)
            {
                forcems = true;
                fms = getImage(new URL(getCodeBase(), "switch.gif"));
                return;
            }
        }
        catch(Exception _ex) { }
        socketthread = false;
        Thread thread = new Thread(this);
        thread.start();
        while(!socketthread) 
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }
        Thread thread1 = new Thread(this);
        thread1.start();
    }

    private final void socketrun()
    {
        do
        {
            if(link.socketport != 0)
            {
                try
                {
                    Socket socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), link.socketport);
                    socket.setSoTimeout(30000);
                    socket.setTcpNoDelay(true);
                    link.s = socket;
                }
                catch(Exception _ex)
                {
                    link.s = null;
                }
                link.socketport = 0;
            }
            if(link.runme != null)
            {
                Thread thread = new Thread(link.runme);
                thread.setDaemon(true);
                thread.start();
                link.runme = null;
            }
            if(link.iplookup != null)
            {
                String s = "unknown";
                try
                {
                    s = InetAddress.getByName(link.iplookup).getHostName();
                }
                catch(Exception _ex) { }
                link.host = s;
                link.iplookup = null;
            }
            try
            {
                Thread.sleep(100L);
            }
            catch(Exception _ex) { }
        } while(true);
    }
        public void loadMacros()
        {
            File f = new File(System.getProperty("user.dir"));
            String[] files = f.list();
            for(int i = 0; i < files.length;i++)
            {
                try
                {
                    if(files[i].startsWith("macro_") && files[i].endsWith(".class") && files[i].indexOf('$') == -1)
                    {
                        System.out.println(files[i]);
                        Class clazz = Class.forName(files[i].substring(0,files[i].length()-".class".length()));
                        Macro macro = (Macro)clazz.getConstructor(new Class[]{mudclient_Debug.class}).newInstance(new Object[]{inner});
                        String[] commands = macro.getCommands();
                        for(int j = 0; j < commands.length;j++)
                        {
                            System.out.println("command registered:"+commands[j]);
                            mudclient_Debug.macros.put(commands[j], macro);
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    public final void run()
    {
        if(socketthread)
        {
            socketrun();
            return;
        }
        socketthread = true;
        try
        {
            boolean flag = false;
            try
            {
                String s = getParameter("member");
                int i = Integer.parseInt(s);
                if(i == 1)
                    flag = true;
            }
            catch(Exception _ex) { }
            loading = getImage(new URL(getCodeBase(), "loading.jpg"));
            mt = new MediaTracker(this);
            mt.addImage(loading, 0);
            m = MessageDigest.getInstance("SHA");
            System.out.println(link.class);
            String s1 = ".file_store_32/";
            if(s1 == null)
                return;
            link.uid = getuid(s1);
            link.mainapp = this;
            link.numfile = 0;
            for(int j = 0; j < 14; j++)
                if(flag || !internetname[j].endsWith(".mem"))
                {
                    for(int k = 0; k < 4; k++)
                    {
                        if(k == 3)
                            return;
                        byte abyte0[] = loadfile(s1 + localname[j], sha[j]);
                        if(abyte0 != null)
                        {
                            if(j > 0)
                                link.putjag(internetname[j], abyte0);
                            break;
                        }
                        try
                        {
                            URL url = new URL(getCodeBase(), internetname[j]);
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            int l = size[j];
                            byte abyte1[] = new byte[l];
                            for(int i1 = 0; i1 < l; i1 += 1000)
                            {
                                int j1 = l - i1;
                                if(j1 > 1000)
                                    j1 = 1000;
                                datainputstream.readFully(abyte1, i1, j1);
                                showpercent(nicename[j], (i1 * 100) / l, barpos[j]);
                            }

                            datainputstream.close();
                            FileOutputStream fileoutputstream = new FileOutputStream(s1 + localname[j]);
                            fileoutputstream.write(abyte1);
                            fileoutputstream.close();
                        }
                        catch(Exception _ex) { }
                    }

                }
            System.out.println(cloader.class);
            cloader cloader1 = new cloader();
            cloader1.zip = new ZipFile(s1 + localname[0]);
            cloader1.link = Class.forName("link");
            inner = new mudclient_Debug();
            loadMacros();
            //inner = (Applet)cloader1.loadClass("mudclient").newInstance();
            inner.init();
            inner.start();
            return;
        }
        catch(Exception exception)
        {
            System.out.println(exception + " " + exception.getMessage());
            exception.printStackTrace();
            return;
        }
    }

    private final byte[] loadfile(String s, byte abyte0[])
    {
        try
        {
            File file = new File(s);
            System.out.println("trying to load:"+file);
            int i = (int)file.length();
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s));
            byte abyte1[] = new byte[i];
            datainputstream.readFully(abyte1, 0, i);
            datainputstream.close();
            m.reset();
            m.update(abyte1);
            byte abyte2[] = m.digest();
            for(int j = 0; j < 20; j++)
                if(abyte2[j] != abyte0[j])
                    return null;

            return abyte1;
        }
        catch(Exception _ex)
        {
            return null;
        }
    }

    private final String findcachedir()
    {
        System.out.println("here@!");
        String as[] = {
            "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", 
            ""
        };
        for(int i = 0; i < as.length; i++)
            try
            {
                String s = as[i];
                if(s.length() > 0)
                {
                    File file = new File(s);
                    if(!file.exists())
                        continue;
                }
                File file1 = new File(s + ".file_store_32");
                if(file1.exists() || file1.mkdir())
                    return s + ".file_store_32" + "/";
            }
            catch(Exception _ex) { }

        return null;
    }

    private final int getuid(String s)
    {
        try
        {
            File file = new File(s + "uid.dat");
            if(!file.exists() || file.length() < 4L)
            {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
                dataoutputstream.writeInt((int)(Math.random() * 99999999D));
                dataoutputstream.close();
            }
        }
        catch(Exception _ex) { }
        try
        {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
            int i = datainputstream.readInt();
            datainputstream.close();
            return i + 1;
        }
        catch(Exception _ex)
        {
            return 0;
        }
    }

    private final void showpercent(String s, int i, int j)
    {
        Graphics g = getGraphics();
        Font font = new Font("Helvetica", 1, 13);
        FontMetrics fontmetrics = getFontMetrics(font);
        Font font1 = new Font("Helvetica", 0, 13);
        FontMetrics fontmetrics1 = getFontMetrics(font1);
        if(all || !img && mt.checkAll(true))
        {
            all = false;
            if(img || mt.checkAll(true))
            {
                g.drawImage(loading, 0, 0, this);
                img = true;
            } else
            {
                g.setColor(Color.black);
                g.fillRect(0, 0, 512, 344);
            }
            g.setColor(Color.white);
            g.setFont(font);
            String s1 = "RuneScape has been updated!";
            g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 125);
            s1 = "Please wait - Fetching new files...";
            g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 140);
            g.setFont(font1);
            s1 = "This may take a few minutes, but only";
            g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 165);
            s1 = "needs to be done when the game is updated.";
            g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 180);
        }
        Color color = new Color(140, 17, 17);
        g.setColor(color);
        g.drawRect(104, 190, 304, 34);
        g.fillRect(106, 192, j * 3, 30);
        g.setColor(Color.black);
        g.fillRect(106 + j * 3, 192, 300 - j * 3, 30);
        String s2 = "Loading " + s + " - " + i + "%";
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString(s2, 256 - fontmetrics.stringWidth(s2) / 2, 212);
    }

    public final void update(Graphics g)
    {
        paint(g);
    }

    public final void paint(Graphics g)
    {
        all = true;
        if(inner != null)
            inner.paint(g);
        if(forcems)
            g.drawImage(fms, 0, 0, this);
    }

    public final void start()
    {
        if(inner != null)
            inner.start();
    }

    public final void stop()
    {
        if(inner != null)
            inner.stop();
    }

    public final void destroy()
    {
        if(inner != null)
            inner.destroy();
    }

    public final boolean mouseDrag(Event event, int i, int j)
    {
        if(inner != null)
            return inner.mouseDrag(event, i, j);
        else
            return true;
    }

    public final boolean mouseDown(Event event, int i, int j)
    {
        if(inner != null)
            return inner.mouseDown(event, i, j);
        else
            return true;
    }

    public final boolean mouseUp(Event event, int i, int j)
    {
        if(inner != null)
            return inner.mouseUp(event, i, j);
        else
            return true;
    }

    public final boolean mouseMove(Event event, int i, int j)
    {
        if(inner != null)
            return inner.mouseMove(event, i, j);
        else
            return true;
    }

    public final boolean keyUp(Event event, int i)
    {
        if(inner != null)
            return inner.keyUp(event, i);
        else
            return true;
    }

    public final boolean keyDown(Event event, int i)
    {
        if(inner != null)
            return inner.keyDown(event, i);
        else
            return true;
    }

    public loader2()
    {
        forcems = false;
        all = true;
        img = false;
    }

    private boolean forcems;
    private boolean all;
    private boolean img;
    private Image loading;
    private Image fms;
    private MediaTracker mt;
    private boolean socketthread;
    private Applet inner;
    private MessageDigest m;
    private final int width = 512;
    private final int height = 344;
    private final String cacheid = ".file_store_32";
    private final String nicename[] = {
        "main game", "config", "monster graphics", "jagex library", "landscape", "maps", "object graphics", "3d models", "textures", "chat system", 
        "members monsters", "members land", "members maps", "sound effects"
    };
    static String internetname[] = {
        "mudclient176.jar", "config84.jag", "entity23.jag", "jagex.jag", "land62.jag", "maps62.jag", "media57.jag", "models36.jag", "textures17.jag", "filter2.jag", 
        "entity23.mem", "land62.mem", "maps62.mem", "sounds1.mem"
    };
    private final String localname[] = {
        "g34zx", "1jfds", "94jfj", "k23lk", "mn24j", "k4o2n", "zko34", "plam3", "zn12n", "cht3f", 
        "lam3n", "zl3kp", "a2155", "zck35"
    };
    private final int barpos[] = {
        10, 20, 25, 35, 40, 50, 60, 70, 80, 82, 
        84, 88, 92, 96
    };
    private final int size[] = {
        0x1d60b, 58809, 0x3b31f, 15166, 0x22c2f, 37649, 0x18137, 0x46c1e, 63685, 15377, 
        48212, 0x25c3b, 59481, 0x1bec7
    };
    private final byte sha[][] = {
        {
            104, -24, 52, 50, -40, 1, -80, 56, -20, 23, 
            39, 21, -60, -110, 35, -5, 89, -114, 29, -60
        }, {
            51, -113, 64, 75, -60, -24, 89, -12, -122, 103, 
            113, -98, -43, -105, 124, 19, -89, -112, -11, -26
        }, {
            22, -66, 52, 14, -18, -39, 83, -3, -75, -79, 
            17, 96, 72, -80, 57, -106, -50, -117, -71, -96
        }, {
            -113, -52, -27, 31, -9, -74, 127, -21, -41, 61, 
            -98, 26, 124, 114, -127, 43, 50, -109, -34, -77
        }, {
            11, -122, -94, -86, -40, -99, -13, 13, 89, 28, 
            -12, 83, -83, 88, -39, 47, -65, -100, -32, -69
        }, {
            -128, -127, -57, -29, -107, -3, -119, 126, 45, -97, 
            8, -77, 93, -114, 36, -55, 41, 76, 66, -26
        }, {
            -18, -82, -102, -49, 104, -75, 2, -20, -108, 102, 
            -126, 95, 114, -20, 22, -126, 114, -78, 56, -87
        }, {
            118, -76, -86, -19, 2, 100, 126, -30, -85, -47, 
            39, -66, 29, 16, -50, -9, 43, 126, -87, 24
        }, {
            113, 67, -45, 6, -20, -22, 58, -100, 83, -82, 
            41, -112, 47, -47, 99, -58, 3, -42, -30, -46
        }, {
            41, -70, 22, -37, -42, -108, -78, -116, 46, -100, 
            -27, -4, 60, 94, 9, 59, -47, -33, -66, -44
        }, {
            -13, -105, -53, -4, -58, -111, 86, -94, -28, 84, 
            84, -60, 51, -26, -104, -87, 13, 106, -71, 18
        }, {
            77, -86, -66, -2, -91, -26, 9, 59, 6, 88, 
            -103, -104, 126, -113, -87, 111, 53, -86, -77, -2
        }, {
            -103, -99, 26, 101, 60, 113, -55, -57, -120, -87, 
            -20, -115, -24, -98, 22, 71, 99, -91, 112, 44
        }, {
            79, -114, 127, 101, 21, -104, 120, -49, -110, -43, 
            98, 30, -118, 125, 20, -97, 16, -116, 85, -65
        }
    };

}