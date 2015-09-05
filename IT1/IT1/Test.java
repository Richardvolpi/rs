/*
 * Test.java
 *
 * Created on August 28, 2003, 9:06 PM
 */
import javax.swing.*;
import java.awt.*;
import java.net.*;
import a.a.e;
import a.a.g;
import a.a.j;
import a.a.Accessor;
/**
 *
 * @author  harperart
 */
public class Test
{
    
    /** Creates a new instance of Test */
    public Test()
    {
    }
    //static a.a.g gHandler;
    public static void main3(String argv[])
    {
        a.e stream = new a.e();
        stream.a(205,655);
        stream.b(10);
        stream.b(1);
        stream.g();
        stream.a(205,655);
        stream.b(10);
        stream.b(1);
        stream.g();
        stream.a(205,655);
        stream.b(10);
        stream.b(1);
        stream.g();
        stream.a(205,655);
        stream.b(10);
        stream.b(1);
        stream.g();
    }
    public static void main(String argv[])
    {
        JFrame f = new JFrame();
        mudclient mud = new mudclient();
        f.getContentPane().add(mud);
        
                java.io.File dir = new java.io.File(".file_store_32");
        java.io.File[] files = dir.listFiles();
        try
        {
            for(int i = 0; i < files.length;i++)
            {
                if(files[i].getName().endsWith(".jag"))
                {
                    java.io.FileInputStream fis = new java.io.FileInputStream(files[i]);
                    java.io.DataInputStream dis = new java.io.DataInputStream(fis);
                    byte bytes[] = new byte[(int)files[i].length()];
                    dis.readFully(bytes);
                    link.putjag(files[i].getName(),bytes);
                    dis.close();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
        link.uid = 0;
        link.mainapp = new java.applet.Applet();
        d bO = new d(200, 200 + 12, 4000, mud)
        {
            public void c(int i1, int j1, int k1, int l1, int i2)
            {
                System.out.println("c");
                b(i1, j1, k1, i2);
                b(i1, (j1 + l1) - 1, k1, i2);
                c(i1, j1, l1, i2);
                c((i1 + k1) - 1, j1, l1, i2);
            }
            public void b(String s1, int i1, int j1, int k1, int l1)
            {
                System.out.println(Accessor.access_g_z(this)[0]);
                c(s1, i1 - a(s1, k1) / 2, j1, k1, l1);
            }
        };
        bO.b("Hi",0,0,40,40);
        f.setBounds(0,0, 400,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    public static void main2(String argv[])
    {
        JFrame f = new JFrame();
        /*mudclient panel = new mudclient()
        {
            public java.net.URL getCodeBase()
            {
                try
                {
                    return new URL("http://69.1.68.42/client2/");
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
         };*/
        //init_cm(panel);
        //panel.init();
        //System.out.println(panel.cm);
        //panel.v();
        //panel.bO.b("Hi",0,0,100,100);
        //panel.c(100,100);
        java.io.File dir = new java.io.File(".file_store_32");
        java.io.File[] files = dir.listFiles();
        try
        {
            for(int i = 0; i < files.length;i++)
            {
                if(files[i].getName().endsWith(".jag"))
                {
                    java.io.FileInputStream fis = new java.io.FileInputStream(files[i]);
                    java.io.DataInputStream dis = new java.io.DataInputStream(fis);
                    byte bytes[] = new byte[(int)files[i].length()];
                    dis.readFully(bytes);
                    link.putjag(files[i].getName(),bytes);
                    dis.close();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return;
        }
        link.uid = 0;
        mudclient panel = new mudclient();
        link.mainapp = new java.applet.Applet();
        panel.bO = new d(200, 200 + 12, 4000, panel){
            public int c(int i)
            {
                System.out.println(i);
                System.out.println("c called");
                return super.c(i);
                
            }
        };
        //a.a.g.a(new byte[9]);
        //a.a.g.a(new byte[9]);
        //a.a.g.a(new byte[9]);
        //a.a.g.a(new byte[9]);
        //a.a.g.a(new byte[9]);
        //a.a.g.a(new byte[9]);
        panel.bO.L = panel;
        panel.bO.a(0, 0, 200, 200 + 12);
        e.O = false;
        e.P = panel.bV;
        panel.dT = new e(panel.bO, 5);
        int k1 = ((g) (panel.bO)).a - 199;
        byte byte0 = 36;
        panel.dU = panel.dT.b(k1, byte0 + 24, 196, 90, 1, 500, true);
        panel.dX = new e(panel.bO, 5);
        panel.dY = panel.dX.b(k1, byte0 + 40, 196, 126, 1, 500, true);
        panel.eb = new e(panel.bO, 5);
        panel.ec = panel.eb.b(k1, byte0 + 24, 196, 251, 1, 500, true);
        panel.v();
        if(panel.bv)
            return;
        panel.w();
        if(panel.bv)
            return;
        panel.bN = new j(panel.bO, 15000, 15000, 1000);
        panel.bN.a(panel.bR / 2, panel.bS / 2, panel.bR / 2, panel.bS / 2, panel.bR, panel.bT);
        panel.bN.g = 2400;
        panel.bN.h = 2400;
        panel.bN.i = 1;
        panel.bN.j = 2300;
        panel.bN.c(-50, -10, -50);
        d graph = panel.bO;
        panel.b(100, "Starting game...");
        panel.B();
        panel.Q(); //create login screens
        panel.G(); //create sercurity questions screen
        panel.N(); //create design your character screen
        panel.J(); //create forget password screen
        panel.K(); //create contact details screen
        panel.D();
        panel.e();
        //panel.S();
        a.a.e parts = new a.a.e(graph,5);
        parts.a(10,10,"Test",5,false);
        parts.a();
        f.setVisible(true);
        //panel.start();
        f.getContentPane().add(panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0,0, 600, 400);
    }
    public static void init_cm(mudclient mud)
    {
            mud.bU = 2000;
            mud.bV = mud.bU + 100;
            mud.bW = mud.bV + 50;
            mud.ca = mud.bW + 1000;
            mud.bX = mud.ca + 10;
            mud.bY = mud.bX + 50;
            mud.bZ = mud.bY + 10;
            mud.bM = mud.getGraphics();
            ((a.a.a)mud).a(50);
            mud.bO = new d(mud.bR, mud.bS + 12, 4000, mud)
            {
                public void b(String s,int a,int b, int c, int d)
                {
                    System.out.println(s);
                    super.b(s,a,b,c,d);
                }
            };
            mud.bO.L = mud;
            mud.bO.a(0, 0, mud.bR, mud.bS + 12);
            e.O = false;
            e.P = mud.bV;
            mud.dT = new e(mud.bO, 5);
            int k1 = ((g) (mud.bO)).a - 199;
            byte byte0 = 36;
            mud.dU = mud.dT.b(k1, byte0 + 24, 196, 90, 1, 500, true);
            mud.dX = new e(mud.bO, 5);
            mud.dY = mud.dX.b(k1, byte0 + 40, 196, 126, 1, 500, true);
            mud.eb = new e(mud.bO, 5);
            mud.ec = mud.eb.b(k1, byte0 + 24, 196, 251, 1, 500, true);
            mud.v();
            if(mud.bv)
                return;
            mud.w();
            if(mud.bv)
                return;
            mud.bN = new j(mud.bO, 15000, 15000, 1000);
            mud.bN.a(mud.bR / 2, mud.bS / 2, mud.bR / 2, mud.bS / 2, mud.bR, mud.bT);
            mud.bN.g = 2400;
            mud.bN.h = 2400;
            mud.bN.i = 1;
            mud.bN.j = 2300;
            mud.bN.c(-50, -10, -50);
            mud.cm = new f(mud.bN, mud.bO);
            mud.cm.e = mud.bU;
            mud.x();
            if(mud.bv)
                return;
            mud.y();
            if(mud.bv)
                return;
            mud.z();
            if(mud.bv)
                return;
            if(mud.bq)
                mud.A();
            if(mud.bv)
            {
                return;
            } else
            {
                mud.b(100, "Starting game...");
                mud.B();
                mud.Q(); //create login screens
                mud.G(); //create sercurity questions screen
                mud.N(); //create design your character screen
                mud.J(); //create forget password screen
                mud.K(); //create contact details screen
                mud.D();
                mud.e();
                mud.S();
                return;
            }
    }
}
