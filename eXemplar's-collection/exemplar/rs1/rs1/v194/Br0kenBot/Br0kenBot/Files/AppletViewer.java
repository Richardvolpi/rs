/*
 * AppletViewer.java
 *
 * Created on January 23, 2004, 1:12 PM
 */
import java.awt.*;
import java.applet.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author  harperart
 */
public class AppletViewer extends Frame implements AppletContext,AppletStub
{
    public Applet inner;
    public static String codeBase;
    public static String serverOffset;
    public static boolean members;
    /** Creates a new instance of AppletViewer */
    public AppletViewer() throws java.net.MalformedURLException,ClassNotFoundException,InstantiationException,IllegalAccessException
    {
        super("Runescape");
        //RunescapeClassLoader clazzLoader = new RunescapeClassLoader(new java.net.URL[]
        //{new java.net.URL(getCodeBase()+"loader181.jar")});
        //Class innerClass = clazzLoader.loadClass("loader");
        //inner = (Applet)innerClass.newInstance();
        inner = new loader();
        inner.setStub(this);
        inner.init();
        add(inner);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent e) 
            {
                System.exit(0);
            }

        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        codeBase = args[0];
        serverOffset = args[1];
        members = args[2].equalsIgnoreCase("true");
        AppletViewer viewer = new AppletViewer();
        viewer.setSize(520,375);
        viewer.setLocation(10,10);
        //or for the center of the screen
        //viewer.setLocationRelativeTo(null)
        System.out.println("setting visible to true");
        viewer.setVisible(true);
        viewer.inner.start();
    }
    
    public Applet getApplet(String name)
    {
        return null;
    }
    
    public java.util.Enumeration getApplets()
    {
        return null;
    }
    
    public AudioClip getAudioClip(java.net.URL url)
    {
        return null;
    }
    
    public Image getImage(java.net.URL url)
    {
        return Toolkit.getDefaultToolkit().getImage(url);
    }
    
    public java.io.InputStream getStream(String key)
    {
        return null;
    }
    
    public java.util.Iterator getStreamKeys()
    {
        return null;
    }
    
    public void setStream(String key, java.io.InputStream stream) throws java.io.IOException
    {
    }
    
    public void showDocument(java.net.URL url)
    {
    }
    
    public void showDocument(java.net.URL url, String target)
    {
    }
    
    public void showStatus(String status)
    {
    }
    
    public void appletResize(int width, int height)
    {
    }
    
    public AppletContext getAppletContext()
    {
        return this;
    }
    
    public java.net.URL getCodeBase()
    {
        try
        {
            return new java.net.URL(codeBase);
        }
        catch(java.net.MalformedURLException e)
        {
            return null;
        }
    }
    
    public java.net.URL getDocumentBase()
    {
        try
        {
            return new java.net.URL("http://www.runescape.com");
        }
        catch(java.net.MalformedURLException e)
        {
            return null;
        }
    }
    
    public String getParameter(String name)
    {
        if(name.equals("poff"))
            return serverOffset;
        if(name.equals("members"))
            return members?"1":null;
        return null;
    }
    public static class RunescapeClassLoader extends ClassLoader
    {
        URL[] urls;
        /** Creates a new instance of RunescapeClassLoader */
        public RunescapeClassLoader(URL[] urls)
        {
            this.urls = urls;
        }
        protected Class findClass(String name) throws ClassNotFoundException
        {
            String formatedName = name.replace('.', '/')+".class";
            for(int i = 0; i < urls.length;i++)
            {
                try
                {
                    if(urls[i].getFile().endsWith(".jar"))
                    {
                        URL url = new URL("jar:"+urls[i].toExternalForm()+"!/"+formatedName);
                        JarURLConnection connection = (JarURLConnection)url.openConnection();
                        DataInputStream stream = new DataInputStream(connection.getInputStream());
                        byte[] classBytes = new byte[(int)connection.getJarEntry().getSize()];
                        stream.readFully(classBytes);
                        return defineClass(name,classBytes,0,classBytes.length);
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            throw new ClassNotFoundException("Class "+name+" not found");
        }
    }
}
