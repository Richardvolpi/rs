/*
 * Main.java
 *
 * Created on August 21, 2003, 10:54 AM
 */
import javax.swing.*;
import java.applet.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;
import org.jibble.pircbot.*;
/**
 *
 * @author  harperart
 */
public class Main extends JFrame implements AppletStub, AppletContext
{
    mudclient_Debug rs;
    public static final boolean DEBUG = false;
    static loader runescapeLoader;
    static boolean fullscreen = false;
    private boolean topWindow = true;
    JMenuBar menubar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem sleepMenu;
    JMenuItem debugMenu;
    static int rsWidth = 800;
    static int rsHeight = 600;
    String userName = null;
    String password = null;
    boolean noTimeout = true;
    public static Hashtable worldIpLookup = new Hashtable();
    public static Hashtable worldOffLookup = new Hashtable();
    public static Hashtable worldMemberLookup = new Hashtable();
    IrcBot ircBot;
    public static final String world1 = "World 1";
    public static final String world2 = "World 2";
    public static final String world3 = "World 3";
    public static final String world4 = "World 4";
    public static final String world5 = "World 5";
    public static final String world6 = "World 6 (members)";
    public static final String world7 = "World 7";
    public static final String world8 = "World 8 (members)";
    public static final String world9 = "World 9";
    public static final String world10 = "World 10";
    public static final String world11 = "World 11 (members)";
    public static final String world12 = "World 12";
    public static final String world13 = "World 13";
    public static final String world14 = "World 14 (members)";
    public static final String world15 = "World 15";
    public static final String world16 = "World 16";
    public static final String world17 = "World 17";
    public static final String world18 = "World 18 (members)";
    public static final String world19 = "World 19";
    public static final String world20 = "World 20 (members)";
    public static final String worldL = "Proxy through local host";
    public static final String worldLM = "Proxy through local host (members)";
    static
    {
        worldIpLookup.put(world1, "http://209.120.137.226/client2/");
        worldOffLookup.put(world1,"0");
        worldIpLookup.put(world2, "http://209.120.137.226/client2/");
        worldOffLookup.put(world2,"1");
        worldIpLookup.put(world3, "http://209.120.137.227/client2/");
        worldOffLookup.put(world3,"0");
        worldIpLookup.put(world4,"http://209.120.137.227/client2/");
        worldOffLookup.put(world4,"1");
        worldIpLookup.put(world5,"http://209.120.137.228/client2/");
        worldOffLookup.put(world5,"0");
        worldIpLookup.put(world6,"http://209.120.137.228/client2/");
        worldOffLookup.put(world6,"1");
        worldMemberLookup.put(world6, "1");
        worldIpLookup.put(world7, "http://217.138.31.250/client2/");
        worldOffLookup.put(world7,"0");
        worldMemberLookup.put(world7, "1");
        worldIpLookup.put(world8, "http://217.138.31.250/client2/");
        worldOffLookup.put(world8,"1");
        worldMemberLookup.put(world8, "1");
        worldIpLookup.put(world9, "http://217.138.31.251/client2/");
        worldOffLookup.put(world9,"0");
        worldIpLookup.put(world10, "http://217.138.31.251/client2/");
        worldOffLookup.put(world10,"1");
        worldIpLookup.put(world11, "http://217.138.31.252/client2/");
        worldOffLookup.put(world11,"0");
        worldMemberLookup.put(world11, "1");
        worldIpLookup.put(world12, "http://217.138.31.252/client2/");
        worldOffLookup.put(world12,"1");
        worldIpLookup.put(world13,"http://69.1.68.42/client2/");
        worldOffLookup.put(world13,"0");
        worldIpLookup.put(world14,"http://69.1.68.42/client2/");
        worldOffLookup.put(world14,"1");
        worldMemberLookup.put(world14, "1");
        worldIpLookup.put(world15,"http://69.1.68.74/client2/");
        worldOffLookup.put(world15,"0");
        worldIpLookup.put(world16,"http://69.1.68.74/client2/");
        worldOffLookup.put(world16,"1");
        worldIpLookup.put(world17,"http://69.1.68.75/client2/");
        worldOffLookup.put(world17,"0");
        worldIpLookup.put(world18,"http://69.1.68.75/client2/");
        worldOffLookup.put(world18,"1");
        worldMemberLookup.put(world18, "1");
        worldIpLookup.put(world19,"http://65.39.134.89/client2/");
        worldOffLookup.put(world19,"0");
        worldIpLookup.put(world20,"http://65.39.134.89/client2/");
        worldOffLookup.put(world20,"1");
        worldMemberLookup.put(world20, "1");
        worldIpLookup.put(worldL,"http://localhost");
        worldOffLookup.put(worldL,"0");
        worldIpLookup.put(worldLM,"http://localhost");
        worldOffLookup.put(worldLM,"0");
        worldMemberLookup.put(worldLM, "1");
    }
    /** Creates a new instance of Main */
    public Main(GraphicsConfiguration gc)
    {
        super(gc);
    }
    public Main()
    {
        this("");
    }
    public Main(String frameTitle)
    {
        super(frameTitle);
        if(!fullscreen)
        {
            debugMenu = new JMenuItem(new AbstractAction("debug")
            {
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        mudclient mud = ((mudclient)runescapeLoader.inner);
                        //mud.gw = true;
                        //mud.O = "";
                        //System.out.println(mud.bO.n[mud.bY+1]+" "+mud.bO.o[mud.bY+1]);
                        //System.out.println(BitmapConverter.EncodeBitmapToString2(mud.bO.k[mud.bY+1], 256,40));
                    /*for(int i = 0; i < mud.bO.k[mud.bY+1].length;i++)
                    {
                        System.out.print((mud.bO.k[mud.bY+1][i])==0?0:1);
                        if(i%255 == 0)
                            System.out.println();
                    }*/
                    /*for(int i = 0; i < b.h.length;i++)
                        System.out.println(i+":"+b.R[i]);*/
                    /*java.lang.reflect.Field[] fields = c.class.getFields();
                    for(int i = 0; i < fields.length;i++)
                    {
                        System.out.println(fields[i]+":"+fields[i].get(mud.cL[0]));
                    }*/
                        //dumps npcs stats
                    for(int i = 0; i < b.c.length;i++)
                    {
                        System.out.println(i+":"+b.c[i]/*+" "+b.u[i]+" "+b.s[i]+" "+b.t[i]*/);
                    }
                        
                        //((mudclient)runescapeLoader.inner)
                        //((mudclient)runescapeLoader.inner).bq = true;
                        //                    System.out.println(((mudclient)runescapeLoader.inner).dz);
                        //                    System.out.println("");
                    /*for (int i = 0; i < ((mudclient)runescapeLoader.inner).dd.length;i++)
                    {
                        System.out.println(((mudclient)runescapeLoader.inner).dd[i]);
                    }*/
                        //((mudclient)runescapeLoader.inner).e("test");
                        //System.out.println(Arrays.asList(a.a.b.class.getDeclaredFields()));
                        //a.a.b.class.getDeclaredFields()[7].setAccessible(true);
                        //byte[] Z = (byte[])mudclient.class.getDeclaredFields()[7].get(runescapeLoader.inner);
                        //System.out.println(new String(Z,1,Z.length-1));
                    }
                    catch(Exception e2)
                    {
                        e2.printStackTrace();
                    }
                }
            });
            sleepMenu = new JMenuItem(new AbstractAction("sleep")
            {
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        ((mudclient)runescapeLoader.inner).N = JOptionPane.showInputDialog(this,"Enter the word");
                    /*for(int i = 0; i < b.R.length;i++)
                    {
                        System.out.println(i+":"+b.S[i]);
                    }*/
                        //((mudclient)runescapeLoader.inner).e("test");
                        //System.out.println(Arrays.asList(a.a.b.class.getDeclaredFields()));
                        //a.a.b.class.getDeclaredFields()[7].setAccessible(true);
                        //byte[] Z = (byte[])mudclient.class.getDeclaredFields()[7].get(runescapeLoader.inner);
                        //System.out.println(new String(Z,1,Z.length-1));
                    }
                    catch(Exception e2)
                    {
                        e2.printStackTrace();
                    }
                }
            });
            menubar.add(fileMenu);
            fileMenu.add(sleepMenu);
            fileMenu.add(debugMenu);
            setJMenuBar(menubar);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        String frameTitle = "Runescape";
        Main main = new Main();
        for(int i = 0; i < args.length;i++)
        {
            if(args[i].startsWith("/T"))
            {
                i++;
                frameTitle = "";
                frameTitle += args[i];
                i++;
            }
            if(i < args.length && args[i].equals("/fs"))
            {
                fullscreen = true;
                i++;
                rsWidth = Integer.parseInt(args[i]);
                i++;
                rsHeight = Integer.parseInt(args[i]);
            }
            if(i < args.length && args[i].equals("/notop"))
            {
                main.topWindow = false;
            }
        }
        main.setTitle(frameTitle);
        if(fullscreen)
        {
            main.setUndecorated(true);
        }
        RunescapeOptions optionDialog = new RunescapeOptions(main, true);
        if(fullscreen)
        {
            DisplayMode[] dismodes = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayModes();
            GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(optionDialog);
            java.awt.DisplayMode gdc= null;
            for(int i = 0; i < dismodes.length;i++)
            {
                System.out.println(dismodes[i].getWidth()+" "+dismodes[i].getHeight());
                if(dismodes[i].getWidth() == rsWidth && dismodes[i].getHeight() == rsHeight)
                {
                    System.out.println(dismodes[i]);
                    if(gdc == null)
                        gdc = dismodes[i];
                    else if(dismodes[i].getBitDepth() > gdc.getBitDepth())
                        gdc = dismodes[i];
                }
            }
            GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setDisplayMode(gdc);
        }
        if(!fullscreen)
        {
            optionDialog.setVisible(true);
        }
        if(fullscreen)
        {
            optionDialog.dispose();
            GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].setFullScreenWindow(main);
        }
        //optionDialog.setVisible(true);
        main.noTimeout = optionDialog.isNoTimeout();
        main.getContentPane().setLayout(null);
        loader runescapeLoader = new loader();
        main.runescapeLoader = runescapeLoader;
        main.rs = (mudclient_Debug)runescapeLoader.inner;
        main.rs.params.put("codebase", worldIpLookup.get(optionDialog.getSelectedWorld()));
        main.rs.params.put("poff", worldOffLookup.get(optionDialog.getSelectedWorld()));
        if(worldMemberLookup.get(optionDialog.getSelectedWorld()) != null)
            main.rs.params.put("member",worldMemberLookup.get(optionDialog.getSelectedWorld()));
        if(optionDialog.isAutoLogin())
        {
            main.rs.userName = optionDialog.getUserName();
            main.rs.password = optionDialog.getPassword();
        }
        runescapeLoader.setSize(rsHeight,rsWidth);
        runescapeLoader.setLocation(0, 0);
        runescapeLoader.setStub(main);
        //ImageIcon icon = new ImageIcon(new URL("http://www.jagex.com/rsimg/worldmap/map11.gif"));
        //ImageIcon icon2 = new ImageIcon(new URL("http://www.jagex.com/rsimg/worldmap/mapkey5.gif"));
        //JLabel map = new JLabel(icon);
        //JLabel mapKey = new JLabel(icon2);
        //JScrollPane mapPane = new JScrollPane(map);
        //JScrollPane keyPane = new JScrollPane(mapKey);
        //main.getContentPane().add(mapPane);
        //main.getContentPane().add(keyPane);
        //mapPane.setBounds(0, 350, 512,250);
        //keyPane.setBounds(512,0,171,550);
        runescapeLoader.init();
        main.getContentPane().add(runescapeLoader);
        if(!fullscreen)
            main.setBounds(0,0,512/*+171*/,344+50/*600+30*/);
        main.setVisible(true);
        if(main.topWindow && System.getProperty("os.name").startsWith("Win"))
        {
            System.loadLibrary("jawt");
            System.load(new File(new java.net.URI(Main.class.getClassLoader().getResource("win32.dll").toString())).toString());
            setTopWindow(main);
        }
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        runescapeLoader.start();
    }
    public static native void setTopWindow(java.awt.Window window);
    /*public Graphics getGraphics()
    {
        System.out.println("geting graphics");
        Graphics2D g = (Graphics2D)getContentPane().getGraphics();
        g.scale(2,2);
        return g;
    }*/
    public void appletResize(int width, int height)
    {
        
    }
    protected void processMouseEvent(MouseEvent e)
    {
        super.processMouseEvent(e);
    }
    public AppletContext getAppletContext()
    {
        return this;
    }
    
    public java.net.URL getCodeBase()
    {
        try
        {
            return new URL((String)rs.params.get("codebase"));
        }
        catch(MalformedURLException e)
        {
            return null;
        }
    }
    
    public java.net.URL getDocumentBase()
    {
        try
        {
            return new URL("http://runescape.com");
        }
        catch(MalformedURLException e)
        {
            return null;
        }
    }
    
    public String getParameter(String name)
    {
        Object param = rs.params.get(name);
        if(name == null)
            return "";
        else
            return param.toString();
    }
    
    public Applet getApplet(String name)
    {
        return null;
    }
    
    public java.util.Enumeration getApplets()
    {
        return null;
    }
    
    public AudioClip getAudioClip(URL url)
    {
        return null;
    }
    
    public java.awt.Image getImage(URL url)
    {
        return Toolkit.getDefaultToolkit().createImage(url);
    }
    
    public InputStream getStream(String key)
    {
        return null;
    }
    
    public java.util.Iterator getStreamKeys()
    {
        return null;
    }
    
    public void setStream(String key, InputStream stream) throws IOException
    {
    }
    
    public void showDocument(URL url)
    {
        
    }
    
    public void showDocument(URL url, String target)
    {
    }
    
    public void showStatus(String status)
    {
    }
    
    public void mouseClicked(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mouseDragged(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mouseEntered(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mouseExited(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mouseMoved(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mousePressed(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
    public void mouseReleased(MouseEvent e)
    {
        runescapeLoader.dispatchEvent(e);
    }
    
}
