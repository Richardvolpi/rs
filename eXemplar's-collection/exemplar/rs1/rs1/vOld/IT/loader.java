// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 8/21/2003 10:36:15 AM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) fieldsfirst lnc 
// Source File Name:   loader.java

import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.zip.ZipFile;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.geom.*;
public class loader extends Applet implements MouseInputListener, Runnable,KeyListener
{

            private boolean forcems;
            private boolean all;
            private boolean img;
            private Image loading;
            private Image fms;
            private MediaTracker mt;
            private boolean socketthread;
            public Applet inner;
            private MessageDigest m;
            private final int width = 512;
            private final int height = 344;
            private final String cacheid = ".file_store_32";
            private final String nicename[] = {
/*  23*/        "main game", "config", "monster graphics", "jagex library", "landscape", "maps", "object graphics", "3d models", "textures", "chat system", 
/*  23*/        "members monsters", "members land", "members maps", "sound effects"
            };
            static String internetname[] = {
/*  24*/        "mudclient177.jar", "config85.jag", "entity24.jag", "jagex.jag", "land63.jag", "maps63.jag", "media58.jag", "models36.jag", "textures17.jag", "filter2.jag", 
/*  24*/        "entity24.mem", "land63.mem", "maps63.mem", "sounds1.mem"
            };
            private final String localname[] = {
        "g34zx", "1jfds", "94jfj", "k23lk", "mn24j", "k4o2n", "zko34", "plam3", "zn12n", "cht3f", 
        "lam3n", "zl3kp", "a2155", "zck35"
            };
            private final int barpos[] = {
/*  26*/        10, 20, 25, 35, 40, 50, 60, 70, 80, 82, 
/*  26*/        84, 88, 92, 96
            };
            private final int size[] = {
/*  28*/        0x1d60b, 58525, 0x3b2b2, 15166, 0x22baa, 37113, 0x18137, 0x4676b, 63685, 15377, 
/*  28*/        46636, 0x2567d, 59317, 0x1bec7
            };
            private final byte sha[][] = {
        {
            -26, -114, -4, -31, -58, -67, -73, 87, 92, 97, 
            117, -71, 16, -15, 104, 105, -70, -80, 102, 42
        }, {
            -59, 7, -76, -14, -125, 114, 77, 108, -122, -23, 
            -87, 118, 6, 66, -40, 49, -98, 33, 7, 49
        }, {
            -37, -90, -98, -88, 43, -125, -91, 122, 119, -54, 
            86, 114, 77, 67, 105, 48, 75, 114, 29, 80
        }, {
            -113, -52, -27, 31, -9, -74, 127, -21, -41, 61, 
            -98, 26, 124, 114, -127, 43, 50, -109, -34, -77
        }, {
            11, -122, -94, -86, -40, -99, -13, 13, 89, 28, 
            -12, 83, -83, 88, -39, 47, -65, -100, -32, -69
        }, {
            99, -102, -100, 107, 12, -50, -23, 99, 33, -41, 
            -78, -61, 95, 58, -86, -91, 119, 22, -86, 44
        }, {
            -87, 80, 62, 100, -80, -90, -52, 77, -3, -72, 
            -66, -87, -87, 22, 55, 33, -60, -82, -103, 22
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


            public final void init()
            {
/*  49*/        try
                {
/*  49*/            if(getParameter("forcems").equals("1") && System.getProperties().getProperty("java.vendor").toLowerCase().indexOf("sun") != -1)
                    {
/*  51*/                forcems = true;
/*  51*/                fms = getImage(new URL(getCodeBase(), "switch.gif"));
/*  52*/                return;
                    }
                }
/*  55*/        catch(Exception _ex) { }
/*  57*/        socketthread = false;
/*  58*/        Thread thread = new Thread(this);
/*  58*/        thread.start();
/*  59*/        while(!socketthread) 
/*  59*/            try
                    {
/*  59*/                Thread.sleep(100L);
                    }
/*  59*/            catch(Exception _ex) { }
/*  60*/        Thread thread1 = new Thread(this);
/*  60*/        thread1.start();
            }

            private final void socketrun()
            {
/*  66*/        do
                {
/*  66*/            if(link.socketport != 0)
                    {
/*  67*/                try
                        {
/*  67*/                    Socket socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), link.socketport)
                            {
                                public OutputStream getOutputStream() throws IOException
                                {
                                    //System.out.println("creating socketOut");
                                    final OutputStream outputStream = super.getOutputStream();
                                    if(!Main.DEBUG)
                                        return outputStream;
                                    else
                                        
                                    return new OutputStream()
                                    {
                                        public void write(int b) throws IOException
                                        {
                                            try
                                            {
                                                java.lang.reflect.Field f = a.e.class.getDeclaredField("f");
                                                f.setAccessible(true);
                                                //verbose the command type sent to the server every time *any* output is sent
                                                System.out.println(f.get(((mudclient)inner).Y)+":"+b);
                                            }
                                            catch(Exception e)
                                            {
                                                e.printStackTrace();
                                            }
                                            outputStream.write(b);
                                        }
                                    };
                                }
                            };
/*  69*/                    socket.setSoTimeout(30000);
/*  69*/                    socket.setTcpNoDelay(true);
/*  69*/                    link.s = socket;
                            System.out.println(socket);
                        }
/*  71*/                catch(Exception _ex)
                        {
/*  71*/                    link.s = null;
                        }
/*  72*/                link.socketport = 0;
                    }
/*  75*/            if(link.runme != null)
                    {
/*  76*/                Thread thread = new Thread(link.runme);
/*  76*/                thread.setDaemon(true);
/*  76*/                thread.start();
/*  77*/                link.runme = null;
                    }
/*  80*/            if(link.iplookup != null)
                    {
/*  81*/                String s = "unknown";
/*  82*/                try
                        {
/*  82*/                    s = InetAddress.getByName(link.iplookup).getHostName();
                        }
/*  83*/                catch(Exception _ex) { }
/*  84*/                link.host = s;
/*  84*/                link.iplookup = null;
                    }
/*  86*/            try
                    {
/*  86*/                Thread.sleep(100L);
                    }
/*  86*/            catch(Exception _ex) { }
                } while(true);
            }

            public final void run()
            {
/*  91*/        if(socketthread)
                {
/*  91*/            socketrun();
/*  91*/            return;
                }
/*  92*/        socketthread = true;
/*  93*/        try
                {
/*  93*/            boolean flag = false;
/*  96*/            try
                    {
/*  96*/                String s = getParameter("member");
/*  98*/                int i = Integer.parseInt(s);
/*  98*/                if(i == 1)
/*  98*/                    flag = true;
                    }
/* 100*/            catch(Exception _ex) { }
/* 102*/            loading = getImage(new URL(getCodeBase(), "loading.jpg"));
/* 103*/            mt = new MediaTracker(this);
/* 103*/            mt.addImage(loading, 0);
/* 105*/            m = MessageDigest.getInstance("SHA");
/* 107*/            String s1 = findcachedir();
/* 108*/            if(s1 == null)
/* 108*/                return;
/* 110*/            link.uid = getuid(s1);
/* 112*/            link.mainapp = this;
/* 114*/            link.numfile = 0;
/* 115*/            for(int j = 0; j < 14; j++)
/* 116*/                if(flag || !internetname[j].endsWith(".mem"))
                        {
/* 117*/                    for(int k = 0; k < 4; k++)
                            {
/* 119*/                        if(k == 3)
/* 119*/                            return;
/* 120*/                        byte abyte0[] = loadfile(s1 + localname[j], sha[j]);
/* 121*/                        if(abyte0 != null)
                                {
/* 122*/                            if(j > 0)
/* 122*/                                link.putjag(internetname[j], abyte0);
/* 123*/                            break;
                                }
/* 126*/                        try
                                {
/* 126*/                            URL url = new URL(getCodeBase(), internetname[j]);
/* 128*/                            DataInputStream datainputstream = new DataInputStream(url.openStream());
/* 129*/                            int l = size[j];
/* 129*/                            byte abyte1[] = new byte[l];
/* 130*/                            for(int i1 = 0; i1 < l; i1 += 1000)
                                    {
/* 131*/                                int j1 = l - i1;
/* 131*/                                if(j1 > 1000)
/* 131*/                                    j1 = 1000;
/* 132*/                                datainputstream.readFully(abyte1, i1, j1);
/* 133*/                                showpercent(nicename[j], (i1 * 100) / l, barpos[j]);
                                    }

/* 135*/                            datainputstream.close();
/* 136*/                            FileOutputStream fileoutputstream = new FileOutputStream(s1 + localname[j]);
/* 137*/                            fileoutputstream.write(abyte1);
/* 137*/                            fileoutputstream.close();
                                }
/* 139*/                        catch(Exception _ex) { }
                            }

                        }

/* 143*/            cloader cloader1 = new cloader();
/* 144*/            cloader1.zip = new ZipFile(s1 + localname[0]);
/* 145*/            cloader1.link = Class.forName("link");
                    
                    loadMacros();
                    //((mudclient)inner).bq = true;
/* 147*/            //inner = (Applet)cloader1.loadClass("mudclient").newInstance();
/* 148*/            inner.init();
/* 148*/            inner.start();
/*  93*/            return;
                }
/* 150*/        catch(Exception exception)
                {
/* 151*/            System.out.println(exception + " " + exception.getMessage());
/* 152*/            exception.printStackTrace();
/*  90*/            return;
                }
            }

            private final byte[] loadfile(String s, byte abyte0[])
            {
/* 157*/        try
                {
/* 157*/            File file = new File(s);
                    System.out.println("trying to load:"+file);
/* 157*/            int i = (int)file.length();
/* 160*/            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s));
/* 161*/            byte abyte1[] = new byte[i];
/* 161*/            datainputstream.readFully(abyte1, 0, i);
/* 161*/            datainputstream.close();
/* 163*/            m.reset();
/* 163*/            m.update(abyte1);
/* 163*/            byte abyte2[] = m.digest();
                /*for(int j = 0; j < 20; j++)
                    if(abyte2[j] != abyte0[j])
                        return null;*/

/* 166*/            return abyte1;
                }
/* 168*/        catch(Exception _ex)
                {
/* 169*/            return null;
                }
            }

            private final String findcachedir()
            {
/* 173*/        String as[] = {
            "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", 
            ""};
/* 174*/        for(int i = 0; i < as.length; i++)
/* 175*/            try
                    {
                        
/* 175*/                String s = as[i];
                        System.out.println("cache try:"+s);
/* 178*/                if(s.length() > 0)
                        {
/* 178*/                    File file = new File(s);
/* 178*/                    if(!file.exists())
/* 178*/                        continue;
                        }
/* 180*/                File file1 = new File(s + ".file_store_32");
/* 181*/                if(file1.exists() || file1.mkdir())
/* 183*/                    return s + ".file_store_32" + "/";
                    }
/* 185*/            catch(Exception _ex) { }

/* 187*/        return null;
            }

            private final int getuid(String s)
            {
/* 192*/        try
                {
/* 192*/            File file = new File(s + "uid.dat");
/* 194*/            if(!file.exists() || file.length() < 4L)
                    {
/* 195*/                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
/* 196*/                dataoutputstream.writeInt((int)(Math.random() * 99999999D));
/* 196*/                dataoutputstream.close();
                    }
                }
/* 199*/        catch(Exception _ex) { }
/* 201*/        try
                {
/* 201*/            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
/* 203*/            int i = datainputstream.readInt();
/* 203*/            datainputstream.close();
/* 204*/            return i + 1;
                }
/* 206*/        catch(Exception _ex)
                {
/* 207*/            return 0;
                }
            }

            private final void showpercent(String s, int i, int j)
            {
/* 211*/        Graphics g = getGraphics();
/* 213*/        Font font = new Font("Helvetica", 1, 13);
/* 213*/        FontMetrics fontmetrics = getFontMetrics(font);
/* 214*/        Font font1 = new Font("Helvetica", 0, 13);
/* 214*/        FontMetrics fontmetrics1 = getFontMetrics(font1);
/* 216*/        if(all || !img && mt.checkAll(true))
                {
/* 217*/            all = false;
/* 219*/            if(img || mt.checkAll(true))
                    {
/* 219*/                g.drawImage(loading, 0, 0, this);
/* 219*/                img = true;
                    } else
                    {
/* 220*/                g.setColor(Color.black);
/* 220*/                g.fillRect(0, 0, 512, 344);
                    }
/* 222*/            g.setColor(Color.white);
/* 222*/            g.setFont(font);
/* 223*/            String s1 = "RuneScape has been updated!";
/* 223*/            g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 125);
/* 224*/            s1 = "Please wait - Fetching new files...";
/* 224*/            g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 140);
/* 225*/            g.setFont(font1);
/* 226*/            s1 = "This may take a few minutes, but only";
/* 226*/            g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 165);
/* 227*/            s1 = "needs to be done when the game is updated.";
/* 227*/            g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 180);
                }
/* 230*/        Color color = new Color(140, 17, 17);
/* 231*/        g.setColor(color);
/* 231*/        g.drawRect(104, 190, 304, 34);
/* 231*/        g.fillRect(106, 192, j * 3, 30);
/* 232*/        g.setColor(Color.black);
/* 232*/        g.fillRect(106 + j * 3, 192, 300 - j * 3, 30);
/* 233*/        String s2 = "Loading " + s + " - " + i + "%";
/* 234*/        g.setFont(font);
/* 234*/        g.setColor(Color.white);
/* 234*/        g.drawString(s2, 256 - fontmetrics.stringWidth(s2) / 2, 212);
            }

            public final void update(Graphics g)
            {
/* 238*/        paint(g);
            }

            public final void paint(Graphics g)
            {
/* 240*/        all = true;
/* 241*/        if(inner != null)
/* 241*/            inner.paint(g);
/* 242*/        if(forcems)
/* 242*/            g.drawImage(fms, 0, 0, this);
            }

            public final void start()
            {
/* 244*/        if(inner != null)
/* 244*/            inner.start();
            }

            public final void stop()
            {
/* 245*/        if(inner != null)
/* 245*/            inner.stop();
            }

            public final void destroy()
            {
                if(inner != null)
                    inner.destroy();
            }


            int[] values = new int[40];
            int fatigue = 0;
            public Graphics getGraphics()
            {
                final java.awt.Graphics2D g2 = (java.awt.Graphics2D)super.getGraphics();
                javax.swing.DebugGraphics graphics = new javax.swing.DebugGraphics(super.getGraphics())
                {
                    public boolean drawImage(Image img, int x, int y, java.awt.image.ImageObserver observer)
                    {
                        mudclient client = (mudclient)inner;
                        //System.out.println("questPoints:"+((mudclient)inner).dL);
                        //System.out.println("equipement status:"+client.dK[0]+" "+client.dK[1]+" "+client.dK[2]);
                        for(int i = 0; i < client.dO.length;i++)
                        {
                            if(values[i] != client.dJ[i])
                            {
                                client.d("Your exp in "+client.dO[i]+" just went up "+(client.dJ[i]/4.0-values[i]/4.0)+" now "+(client.dJ[i]/4.0));
                                values[i] = client.dJ[i];
                            }
                        }
                        if(fatigue != client.dM)
                        {
                            client.d("Your fatigue went up "+((client.dM-fatigue)*100.0/750.0) + " now "+(client.dM*100.0/750.0));
                            fatigue = client.dM;
                        }
                        //System.out.println(""+client.bQ+client.il+client.ho+client.hK+client.gl);
                        //System.out.println(new String(client.Z,1,client.Z.length-1));
                        //System.out.println("location:"+client.cO+" "+client.cP);
//                        for(int i = 0; i < client.ds.length;i++)
//                        {
//                            System.out.print(client.ds[i]+" ");
//                        }
//                        System.out.println("");
                        //System.out.println(client.cd+" "+client.ce+" "+client.cf+" "+client.cg+" "+client.ch+" "+client.ci+" "+client.cj);
                        //System.out.println("Attack:"+client.dH[0]+'/'+client.dI[0]);
                        //System.out.println("fatigue:"+((mudclient)inner).dM);
                        //System.out.println("Money:"+((mudclient)inner).d(10));
                        //System.out.println(sun.reflect.Reflection.getCallerClass(3));
                        return g2.drawImage(img,0,0,observer);
                    }
                };
                //graphics.setDebugOptions(javax.swing.DebugGraphics.LOG_OPTION);
                return graphics;
            }
            
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            
            public void mouseDragged(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            
            public void mouseExited(java.awt.event.MouseEvent e)
            {
            }
            
            public void mouseMoved(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            
            public void mousePressed(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            
            public void mouseReleased(java.awt.event.MouseEvent e)
            {
                handelEvent(e);
            }
            public void handelEvent(java.awt.AWTEvent evt)
            {
                if(inner != null)
                    inner.dispatchEvent(evt);
            }
            
            public void keyPressed(KeyEvent e)
            {
                handelEvent(e);
            }
            
            public void keyReleased(KeyEvent e)
            {
                handelEvent(e);
            }
            
            public void keyTyped(KeyEvent e)
            {
                handelEvent(e);
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
            public loader()
            {
                System.out.println("loader");
/*  10*/        forcems = false;
/*  11*/        all = true;
/*  12*/        img = false;
                addMouseListener(this);
                addMouseMotionListener(this);
                addKeyListener(this);
                inner = new mudclient_Debug();
            }
            public static void main(String[] argv)
            {
                System.out.println("loader");
            }
}