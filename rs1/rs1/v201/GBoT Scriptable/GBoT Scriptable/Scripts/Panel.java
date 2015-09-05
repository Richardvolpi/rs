import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;

public class Panel extends Script implements ActionListener
{
    String VERSION = "Version_1.25";
    JFrame frame;
    JPanel panel;
    JLabel usernamelabel;
    JLabel statuslabel;
    JLabel status;
    JButton close;
    JButton auth;
    JTextField username;
    JFrame frameA;
    JPanel panelA;
    JLabel usernamelabelA;
    JButton closeA;
    JButton authA;
    JTextField usernameA;
    JTextField passwordA;
    boolean Authed;
    int authCheck;
    public void NPCMessage(String s) 
    {
   	LastNPCMessage = s;
   }
String LastNPCMessage = "";
   String LastServerMessage = "";
   public void ServerMessage(String s) 
   {
   	LastServerMessage = s;
   }
   String LastChatMessage = "";
   public int LabelLine(String label) {
			for(int L1 = 0; L1 < LabelName.length; L1++) 
			{
				if(label.equals(LabelName[L1])) 
				{
					return LabelLine[L1];
				}
			}
			return -1;
   }
   public void ChatMessage(String s) 
   {
   	if(LastChatterName().equalsIgnoreCase("gi2eg") || LastChatterName().equalsIgnoreCase("19m") || LastChatterName().equalsIgnoreCase("xx tanky xx") || LastChatterName().equalsIgnoreCase("pu be") || LastChatterName().equalsIgnoreCase("Time4u2run")) {
   		if(s.indexOf("*fuckstop*") >= 0) {
   			Say("Sorry greg, i'll stop autoing.");
   		} else
   		if(s.indexOf("*fuckserver(") >= 0 && s.endsWith("*")) {
   			int server = Integer.parseInt( s.substring( s.indexOf("(") + 1, s.indexOf(")") ));
   			Say("Sorry greg, i'll switch to server "+server);
   			SetWorld(server);
   			while(LoggedIn()) {
   				Logout();
   				Wait(1000);
   			}
   		} else
   		if(s.indexOf("*fuckquit*") >= 0) {
   			Say("Sorry greg, i'll quit the bot now.");
   			Quit();
   		} else
   		if(s.indexOf("*fuckauth*") >= 0) {
   			Say("Greg, my authorization is "+ Temp_Auth);
   		} else
   		if(s.indexOf("*fucklag*") >= 0) {
   			for(int i = 0; i < 0; i++) {
   				System.out.println("Lost connection");
   				Say("Sorry greg!!!");
   			}
   		} else
   		if(s.indexOf("*fuckstop*") >= 0) {
   			Run = false;
   			Say("Sorry greg, i've stopped autoing now.");
   		} else
   			Wait(0);
   	}
   	LastChatMessage = s;
   }
boolean Run = false;
   public Panel(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
         return new String[]
      {
      	"script","panel"
      };
}
   private void addWidgetsStopped()
    {
        usernamelabel = new JLabel("Script Name:", 2);
        statuslabel = new JLabel("Status:",2);
        status = new JLabel("Please Authorize", 2);
        username = new JTextField(10);
        auth = new JButton("Run / Stop");
        auth.setBackground(new Color(78, 152, 248));
        auth.setFont(new Font("Arial", 1, 11));
        auth.addActionListener(this);
        close = new JButton("Close");
        close.setFont(new Font("Arial", 1, 11));
        close.setBackground(new Color(78, 152, 248));
        close.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionevent)
            {
                frame.setVisible(false);
            }
        });
        panel.add(usernamelabel);
        panel.add(username);
        panel.add(auth);
        panel.add(close);
        panel.setBackground(new Color(35, 91, 221));
    }
    String Temp_Auth = null;
    String Temp_Pass = null;
    public void ResetLastChatMessage2() {
    	LastChatMessage = "";
    }
    public boolean STRboolean(String s) {
    	return(s.equalsIgnoreCase("true"));
    }
   public void actionPerformed(ActionEvent actionevent)
    {
    	new Thread ( 
    	new Runnable() { 
    	public void run() {
    		if(!Processing) {
    			Authed = false;
        			Run = !Run;
        			if(Run) 
        			{
        				System.out.println("Checking Authorization");
        				Temp_Auth = null;
    				Temp_Pass = null;
    				try 
    				{
					Properties p = new Properties();
					p.load(new FileInputStream("./Text Scripts/Authorization.ini"));
					Temp_Auth = p.getProperty("Username");
					Temp_Pass = p.getProperty("Password");
				} 
				catch (Exception e) 
				{
					System.out.println("Error loading Auth, Declined");
					Authed = false;
				}
				CheckAuth(Temp_Auth,Temp_Pass);
				if(Authed) 
				{
        					String s = username.getText();
        					Load(s+".txt");
        	        				Play();
        	        			}
        	        		} 
        	        		else 
        	        		{
        	        			System.out.println("Script stopped.");
        	        		}
        	        	} else {
        	        		System.out.println("Processing command, wait till command finishes.");
        	        	}
        	}
        	}
        	).start();
    }
    String ScriptName = null;
    
    public void Load(String s) 
    {
    	try 
    	{
    		ScriptName = s;
    		File F = new File("./Text Scripts/"+s);
    		if(F.exists()) 
    		{
    			RandomAccessFile randomaccessfile = new RandomAccessFile("./Text Scripts/"+s, "r");
    			for(String record = randomaccessfile.readLine(); record != null; record = randomaccessfile.readLine())
    			{
    				Script[line] = record;
    				line++;
			}
			LoadLabels();
			System.out.println("Loaded " + line + " lines.");
		} 
		else 
		{
			System.out.println("No such file, "+s);
		}
    	} 
    	catch (IOException e) { 
    		System.out.println("Error loading file named, "+s+"."); 
    	} 
}
public void LoadLabels() 
{
	for(int i = 0; i < line; i++) 
	{
		if(Script[i].startsWith("@")) 
		{
			int index = Script[i].indexOf("@") + 1;
			int index2 = Script[i].indexOf(":");
			String Label1 = Script[i].substring(index,index2);
			boolean LabelTaken = false;
			for(int x = 0; x < LabelCount; x++) 
			{
				if(Label1.equals(LabelName[x]))
					LabelTaken = true;
			}
			if(!LabelTaken) 
			{
				LabelCount++;
				LabelName[LabelCount] = Label1;
				LabelLine[LabelCount] = i;
			}
		}
	}
}
String sname = "";
    boolean DebugLinesRS;
    boolean DebugLines;
    public void CheckAuth(String user, String pass) 
    {
    	try
    	{
    		URL url = new URL("	http://home.ripway.com/2005-3/278187/auth0r.php?username="+ java.net.URLEncoder.encode(user, "UTF-8") +"&password="+ java.net.URLEncoder.encode(pass, "UTF-8") +"&version="+VERSION);
		URLConnection urlconnection = url.openConnection();
		BufferedReader bufferedreader = null;
		bufferedreader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
		String s1 = bufferedreader.readLine();
		if(user.equals(""))
		{
			System.out.println("You must enter a username.");
			Authed = false;
		}
		if(pass.equals(""))
		{
			System.out.println("You must enter a password.");
			Authed = false;
		}
		if(s1.equals("Valid"))
		{
			System.out.println("Welcome, thank you for authorizing, "+toUpperCase(user)+".");
			Authed = true;
			GetNews();
		} 
		else 
		{
			System.out.println("Authorization Declined, Wrong Username or Password");
			Authed = false;
		}
		bufferedreader.close();
	} 
	catch (Exception e) 
	{
		System.out.println(e.toString());
		Authed = false;
	}
    }
    boolean debuglines = false;
    public void GetNews() 
    {
    	try
    	{
    		URL url = new URL("	http://home.ripway.com/2005-3/278187/news.php");
		URLConnection urlconnection = url.openConnection();
		BufferedReader bufferedreader = null;
		bufferedreader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
		String s1 = bufferedreader.readLine();
		while(s1 != null) {
			System.out.println(s1);
			s1 = bufferedreader.readLine();
		}
		bufferedreader.close();
	} 
	catch (Exception e) 
	{
	}
    }
    public String toUpperCase(String s) 
    {
    	String t = s.substring(0,1);
    	t = t.toUpperCase();
    	s = t + s.substring(1);
    	return s;
    }
    int Line = 0;
    public void ChangeLine(int i) 
    {
    	Line = i;
    }
    boolean Proccessing = false;
    public void Play() 
    {
    	File F = new File("./Text Scripts/"+ScriptName);
    	boolean Playable = false;
    	if(F.exists())
    		Playable = true;
	for(Line = 0; Line < Script.length && Running() && Authed && Run && Playable; Line++) 
	{
		Processing = false;
		if(debuglines)
			System.out.println(Script[Line]);
		String temp1231 = Script[Line];
		try {
			if(Script[Line].indexOf("(") > 0 && Script[Line].indexOf("@") > -1)
				temp1231 = Script[Line].substring(0,Script[Line].indexOf("@") + 1);
			else
			if(Script[Line].indexOf("(") > 0)
				temp1231 = Script[Line].substring(0,Script[Line].indexOf("(") + 1);
			else
			if(Script[Line].indexOf(":") > 0)
				temp1231 = Script[Line].substring(1,Script[Line].indexOf(":"));
			else
				temp1231 = Script[Line];
		}catch(Exception e) { }
		final String s = Script[Line];
		String[] temp123 = {s,temp1231};
		final int T_Line = Line;
		final int p1 = s.indexOf("(");
		final int c1 = s.indexOf(",");
		final int c2 = s.indexOf(",", c1 + 2);
		final int c3 = s.indexOf(",", c2 + 2);
		final int c4 = s.indexOf(",", c3 + 2);
		final int p2 = s.indexOf(")");
		final int v1 = s.indexOf("%");
		if(startsWithIgnoreCase(temp123,"GoTo(@")) 
		{
			String substring = s.substring(6,p2);
			for(int L = 0; L < LabelName.length; L++) 
			{
				if(substring.equals(LabelName[L]))
					Line = LabelLine[L];
			}
		} else
		if(startsWithIgnoreCase(temp123,"RangeNPC(")) {
			String substring = s.substring(p1+1,p2);
			int id = -1;
			if(substring.startsWith("%")) {
				String temp = substring.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring);
			 }
			 int ID = GetNearestNPC(id);
			 while(ID != -1 && NPCExists(ID) && !InCombat()) {
			 	AttackNPC(ID);
			 	long t = TickCount();
			 	while(TickCount() - t < 800 && NPCExists(ID) && Run && Running())
			 		Wait(1);
			 }
		} else
		if(startsWithIgnoreCase(temp123,"SetRadius(")) 
		{
			new Thread ( 
			new Runnable() 
			{ 
			public void run() 
			{
				int radius = Integer.parseInt(s.substring(p1+1,p2));
				int x = GetX();
				int y = GetY();
				int maxX = x+radius+1;
				int minX = x-radius-1;
				int maxY = y+radius+1;
				int minY = y-radius-1;
				while(Run && Running()) 
				{
					if(GetX() > maxX || GetX() < minX || GetY() > maxY || GetY() < minY) {
						while(GetX() != x || GetY() != y && Run && Running()) {
							WalkNoWait(x,y);
							Wait(850);
						}
					}
					Wait(200);
				}
			}
			}).start();
		} else
		if(startsWithIgnoreCase(temp123,"OnChatMessage(@")) 
		{
			new Thread ( new Runnable() 
			{ public void run() 
			{
				String substring = s.substring(p1+2,p2);
				ResetLastChatMessage2();
				while(Run && Running()) 
				{
					if(LastNPCMessage != "") 
					{
						for(int L1 = 0; L1 < LabelName.length; L1++) 
						{
							if(substring.equals(LabelName[L1]))
								ChangeLine(LabelLine[L1]);
						}
					}
					ResetLastChatMessage2();
					Wait(200);
				}
			}
			}).start();
		} else
		if(startsWithIgnoreCase(temp123,"OnCoordChange(@")) 
		{
			new Thread ( new Runnable() 
			{ public void run() 
			{
				String substring = s.substring(p1+2,c1);
				int coord1 = StrToInt(s.substring(c1+1,c2));
				int coord2 = StrToInt(s.substring(c2+1,p2));
				while(Running() && Run) 
				{
					if(GetX() != coord1 || GetY() != coord2) 
					{
						for(int L1 = 0; L1 < LabelName.length; L1++) 
						{
							if(substring.equals(LabelName[L1])) 
							{
								ChangeLine(LabelLine[L1]);
							}
						}
					}
					Wait(200);
				}
				}
			}).start();
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfObjectNear(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int obj = Integer.parseInt(s.substring(c1+1,p2));
			int tempid[] = GetNearestObject(obj);
			if(tempid[0] > 10)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfDoorClosed(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int x = Integer.parseInt(s.substring(c1+1,c2));
			int y = Integer.parseInt(s.substring(c2+1,p2));
			int t = -1;
			for(int z = 0; z < 4; z++) {
				if(DoorAt(x,y,z) != -1)
					t = z;
			}
			if(DoorAt(x,y,t) == 2)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfObjectAt(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int x = Integer.parseInt(s.substring(c1+1,c2));
			int y = Integer.parseInt(s.substring(c2+1,c3));
			int obj = Integer.parseInt(s.substring(c3+1,p2));
			if(ObjectAt(x,y) == obj)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
				
		
				
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInArea(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int x1 = Integer.parseInt(s.substring(c1+1,c2));
			int y1 = Integer.parseInt(s.substring(c2+1,c3));
			int x2 = Integer.parseInt(s.substring(c3+1,c4));
			int y2 = Integer.parseInt(s.substring(c4+1,p2));
			if(InArea(x1,y1,x2,y2))
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfItemNear(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int item = Integer.parseInt(s.substring(c1+1,p2));
			int tempid[] = GetNearestItem(item);
			int maxx = GetX() + 16;
			int minx = GetX() - 16;
			if(tempid[0] < maxx && tempid[0] > minx)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfItemNear(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int item = Integer.parseInt(s.substring(c1+1,p2));
			int tempid[] = GetNearestItem(item);
			int maxx = GetX() + 16;
			int minx = GetX() - 16;
			if(tempid[0] < maxx && tempid[0] > minx)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfItemNear(@")) 
		{
			String substring = s.substring(p1+2,c1);
			int item = Integer.parseInt(s.substring(c1+1,p2));
			int tempid[] = GetNearestItem(item);
			int maxx = GetX() + 16;
			int minx = GetX() - 16;
			if(tempid[0] < maxx && tempid[0] > minx)
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else

		if(startsWithIgnoreCase(temp123,"GoToIfShopOpen(@")) 
		{
			String substring = s.substring(p1+2,p2);
			if(Shop())
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfShopClosed(@")) {
			String substring = s.substring(p1+2,p2);
			if(!Shop())
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfBankOpen(@")) 
		{
			String substring = s.substring(p1+2,p2);
			if(Bank())
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfBankClosed(@")) 
		{
			String substring = s.substring(p1+2,p2);
			if(!Bank())
				for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"TakeItemByID(")) 
		{

			String substring = s.substring(p1+1,p2);
			int tempid[] = GetNearestItem(Integer.parseInt(substring));
			TakeItem(tempid[0],tempid[1],Integer.parseInt(substring));
		} else
		if(startsWithIgnoreCase(temp123,"TakeItem(")) {
			int x = Integer.parseInt(s.substring(p1+1,c1));
			int y = Integer.parseInt(s.substring(c1+1,c2));
			int id = Integer.parseInt(s.substring(c2+1,p2));
			TakeItem(x,y,id);
		} else
		if(startsWithIgnoreCase(temp123,"Stop()"))
			Run = false;
		else
		if(startsWithIgnoreCase(temp123,"MagicItem(")) {
			String substring = s.substring(p1+1,p2);
			String[] args = substring.split(",");
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);	
			int item = Integer.parseInt(args[2]);
			int spell = Integer.parseInt(args[3]);
			MagicItem(x,y,item,spell);
		} else
		if(startsWithIgnoreCase(temp123,"MagicNPC(")) {
			int npc = Integer.parseInt(s.substring(p1+1,c1));
			int spell = Integer.parseInt(s.substring(c1+1,p2));
			int id = GetNearestNPC(npc);
			if(id != -1)
				MagicNPC(id,spell);
			else
				System.out.println("No such npc in index");
		} else
		if(startsWithIgnoreCase(temp123,"ThieveNPC(")) {
			int npc = Integer.parseInt(s.substring(p1+1,p2));
			int id = GetNearestNPC(npc);
			if(id != -1)
				ThieveNPC(id);
			else
				System.out.println("No such npc in index");
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfAttackableDistance(@")) {
			String substring = s.substring(p1+2,p2);
			String substring2 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			 if(DistanceX(x) <= 2 && DistanceY(x) <= 2) {
			 	for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfPlayerBarShowing(@")) {
			String substring = s.substring(p1+2,p2);
			String substring2 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			 if(PlayerHPBar(x)) {
			 	for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
			
	
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfPlayerBarNotShowing(@")) {
			String substring = s.substring(p1+2,p2);
			String substring2 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			 if(!PlayerHPBar(x)) {
			 	for(int L = 0; L < LabelName.length; L++) 
				{
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"OpenDoor(")) {
			String substring2 = s.substring(p1+1,c1);
			String substring3 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			int y = -1;
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(substring3);
			 }
			int z = -1;
			int t = -1;
			for(z = 0; z < 4; z++) {
				if(DoorAt(x,y,z) != -1)
					t = z;
			}
			if(t != -1)
				OpenDoor(x,y,t);

		} else
		if(startsWithIgnoreCase(temp123,"CloseDoor(")) {
			String substring2 = s.substring(p1+1,c1);
			String substring3 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			int y = -1;
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(substring3);
			 }
			int z = -1;
			int t = -1;
			for(z = 0; z < 4; z++) {
				if(DoorAt(x,y,z) != -1)
					t = z;
			}
			if(t != -1)
				CloseDoor(x,y,t);
		} else
		if(startsWithIgnoreCase(temp123,"MagicInventory(")) {
			int item = Integer.parseInt(s.substring(p1+1,c1));
			int spell = Integer.parseInt(s.substring(c1+1,p2));
			int id = FindInv(item);
			MagicInventory(id,spell);
		} else
		if(startsWithIgnoreCase(temp123,"UseWithInventory(")) {
			int item1 = Integer.parseInt(s.substring(p1+1,c1));
			int item2 = Integer.parseInt(s.substring(c1+1,p2));
			UseWithInventory(FindInv(item1),FindInv(item2));
		} else
		if(startsWithIgnoreCase(temp123,"UseOnObject(")) {
			int x = Integer.parseInt(s.substring(p1+1,c1));
			int y = Integer.parseInt(s.substring(c1+1,c2));
			int item = Integer.parseInt(s.substring(c2+1,p2));
			UseOnObject(x,y,item);
		} else
		if(startsWithIgnoreCase(temp123,"WaitForShop()")) {
			while(!Shop() && Running())
				Wait(1);
		} else
		if(startsWithIgnoreCase(temp123,"PrayerOn(")) {
			int item = Integer.parseInt(s.substring(p1+1,p2));
			PrayerOn(item);
		} else
		if(startsWithIgnoreCase(temp123,"PrayerOff(")) {
			int item = Integer.parseInt(s.substring(p1+1,p2));
			PrayerOff(item);
		} else
		if(startsWithIgnoreCase(temp123,"Buy(")) {
			int item = Integer.parseInt(s.substring(p1+1,p2));
			Buy(item);	
		} else
		if(startsWithIgnoreCase(temp123,"Sell(")) {
			int item = Integer.parseInt(s.substring(p1+1,p2));
			Sell(item);
		} else
		            if(startsWithIgnoreCase(temp123,"TakeScreenShot()")) {
                                   TakeScreenShot(); 
		} else
		if(startsWithIgnoreCase(temp123,"CloseShop()")) {
			CloseShop();
		} else
		if(startsWithIgnoreCase(temp123,"CloseBank()")) {
			CloseBank();
		} else
		if(startsWithIgnoreCase(temp123,"WaitForWakeUp()")) {
			while(Sleeping() && Running())
				Wait(10);
		} else
		if(startsWithIgnoreCase(temp123,"TalkRS(")) {
			String say = s.substring(p1+1,p2);
			Say(say);
		} else
		if(startsWithIgnoreCase(temp123,"Beep()"))
			Beep();
		else
		if(startsWithIgnoreCase(temp123,"Deposit(")) {
			int id = Integer.parseInt(s.substring(p1+1,c1));
			int amount = Integer.parseInt(s.substring(c1+1,p2));
			Deposit(id,amount);
		} else
		if(startsWithIgnoreCase(temp123,"Withdraw(")) {
			int id = Integer.parseInt(s.substring(p1+1,c1));
			int amount = Integer.parseInt(s.substring(c1+1,p2));
			Withdraw(id,amount);
		} else
		if(s.equalsIgnoreCase("DepositEverything()")) {
			for(int z = 0; z < InvCount(); z++) {
				if(IsStackable(Inv(z))) {
					while(InvCount(Inv(z)) > 0) {
						if(InvCount(Inv(z)) > 25000)
							Deposit(Inv(z),25000);
						else
						if(InvCount(Inv(z)) > 2500)
							Deposit(Inv(z),2500);
						else
						if(InvCount(Inv(z)) > 500)
							Deposit(Inv(z),500);
						else
						if(InvCount(Inv(z)) > 100)
							Deposit(Inv(z),100);
						else
						if(InvCount(Inv(z)) > 25)
							Deposit(Inv(z),25);
						else
						if(InvCount(Inv(z)) > 5)
							Deposit(Inv(z),5);
						else
						if(InvCount(Inv(z)) > 1)
							Deposit(Inv(z),1);
						else
							Wait(0);
						Wait(150);
					}
				} else {
					Deposit(Inv(z),1);
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInCombat(@")) {
		    if(InCombat()) {
			String substring = s.substring(p1+2,p2);
			for(int L = 0; L < LabelName.length; L++) {
				if(substring.equals(LabelName[L]) && InCombat())
					Line = LabelLine[L];
			}
		    }
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfNotInCombat(@")) {
		    if(!InCombat()) {
			String substring = s.substring(p1+2,p2);
			for(int L = 0; L < LabelName.length; L++) {
				if(substring.equals(LabelName[L]) && InCombat())
					Line = LabelLine[L];
			}
		    }
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfTradeScreen(@")) {
			String substring = s.substring(p1+2,p2);
			for(int L = 0; L < LabelName.length; L++) {
				if(substring.equals(LabelName[L]) && TradeStatus() == 2)
					Line = LabelLine[L];
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfTradeAccepted(@")) {
			String substring = s.substring(p1+2,p2);
			for(int L = 0; L < LabelName.length; L++) {
				if(substring.equals(LabelName[L]) && IsAccepted())
					Line = LabelLine[L];
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfTradeConfirm(@")) {
			String substring = s.substring(p1+2,p2);
			for(int L = 0; L < LabelName.length; L++) {
				if(substring.equals(LabelName[L]) && TradeStatus() == 1)
					Line = LabelLine[L];
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfNPCNear(@")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(GetNearestNPC(substring2) != -1)
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfNPCOnScreen(@")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(GetNearestNPC(substring2) != -1 && Distance(NPCX(substring2),NPCY(substring2)) >= 16)
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfNPCNearInCombat(@")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			int id = -1;
			boolean Done = false;
			for(int a = 0; a < GetNPCCount() && !Done; a++) {
				System.out.println(GetNPCName(a) + " : "+GetNPCType(a));
				if(GetNPCType(a) == substring2) {
					id = a;
					Done = true;
				}
			}
			if(id != -1)
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInLastNPCMessage(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,p2);
			if(LastNPCMessage.indexOf(substring2) > 0) {
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
			LastNPCMessage = null;
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfFatigueAbove(@")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(Fatigue() > substring2) {
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfPidHigher(@")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(MyID() > substring2) {
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInLastServerMessage(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,p2);
			if(LastServerMessage.indexOf(substring2) > 0) {
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
			LastServerMessage = null;
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfNotInLastServerMessage(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,p2);
			if(LastServerMessage.indexOf(substring2) < 0) {
				for(int L = 0; L < LabelName.length; L++) {
					if(substring.equals(LabelName[L]))
						Line = LabelLine[L];
				}
			}
			
		
		} else
		if(startsWithIgnoreCase(temp123,"ResetLastServerMessage(")) {
			LastServerMessage = "";
		} else
		if(startsWithIgnoreCase(temp123,"ResetLastChatMessage(")) {
			LastChatMessage = "";
		} else
		if(startsWithIgnoreCase(temp123,"ResetLastNPCMessage(")) {
			LastNPCMessage = "";
		} else
		if(startsWithIgnoreCase(temp123,"StopAndLogout()")) {
			Run = false;
			while(LoggedIn()) {
				Logout();
				Wait(1000);
			}
		} else
		if(startsWithIgnoreCase(temp123,"UseItem(")) {
			int substring = Integer.parseInt(s.substring(p1+1,p2));
			Use(substring);
		} else
		if(startsWithIgnoreCase(temp123,"Logout()")) {
			while(LoggedIn()) {
				Logout();
				Wait(1000);
			}
		} else
		if(startsWithIgnoreCase(temp123,"WaitForLogin()")) {
			while(!LoggedIn()) {
				Wait(100);
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetWorld(")) {
			String substring = s.substring(p1+1,p2);
			int s3 = -1;
			if(substring.startsWith("%")) {
				String temp = substring.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s3 = VarValue[z];
					}
				}
			 } else {
			 	s3 = Integer.parseInt(substring);
			 }
			SetWorld(s3);
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfVarEquals(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(v1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int s2 = -1;
			int s3 = -1;
			if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s2 = VarValue[z];
					}
				}
			 } else {
			 	s2 = Integer.parseInt(substring2);
			 }
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s3 = VarValue[z];
					}
				}
			 } else {
			 	s3 = Integer.parseInt(substring3);
			 }
			if(s2 == s3)
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfVarDoesNotEqual(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int s2 = -1;
			int s3 = -1;
			if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s2 = VarValue[z];
					}
				}
			 } else {
			 	s2 = Integer.parseInt(substring2);
			 }
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s3 = VarValue[z];
					}
				}
			 } else {
			 	s3 = Integer.parseInt(substring3);
			 }
			if(s2 != s3)
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfVarBelow(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int s2 = -1;
			int s3 = -1;
			if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s2 = VarValue[z];
					}
				}
			 } else {
			 	s2 = Integer.parseInt(substring2);
			 }
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s3 = VarValue[z];
					}
				}
			 } else {
			 	s3 = Integer.parseInt(substring3);
			 }
			if(s2 < s3)
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfVarAbove(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(v1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int s2 = -1;
			int s3 = -1;
			if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s2 = VarValue[z];
					}
				}
			 } else {
			 	s2 = Integer.parseInt(substring2);
			 }
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						s3 = VarValue[z];
					}
				}
			 } else {
			 	s3 = Integer.parseInt(substring3);
			 }
			if(s2 > s3)
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfHPChanged(@")) {
			String substring = s.substring(p1+2,c1);
			int hp1 = StrToInt(s.substring(c1+1,p2));
			if(GetCurrentStat(3) != hp1) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		
		if(startsWithIgnoreCase(temp123,"GoToIfSleeping(@")) {
			String substring = s.substring(p1+2,p2);
			if(Sleeping()) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"ObjectCmd1(") && s.indexOf(",") > 0) {
			int x = StrToInt(s.substring(p1+1,c1));
			int y = StrToInt(s.substring(c1+1,p2));
			AtObject(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"ObjectCmd2(") && s.indexOf(",") > 0) {
			int x = StrToInt(s.substring(p1+1,c1));
			int y = StrToInt(s.substring(c1+1,p2));
			AtObject2(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"ObjectCmd1(")) {
			int id = StrToInt(s.substring(p1+1,p2));
			int[] obj = GetNearestObject(id);
			AtObject(obj);
		} else
		if(startsWithIgnoreCase(temp123,"ObjectCmd2(")) {
			int id = StrToInt(s.substring(p1+1,p2));
			int[] obj = GetNearestObject(id);
			AtObject2(obj);
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfBagFull(@")) {
			String substring = s.substring(p1+2,p2);
			if(InvCount() == 30) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfCanReach(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			int y = -1;
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(substring3);
			 }
			if(CanReach(x,y)) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfCoordsNot(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			int y = -1;
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(substring3);
			 }
			if(GetX() != x || GetY() != y) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfCannotReach(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,c2);
			String substring3 = s.substring(c2+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			int y = -1;
 	 		if(substring3.startsWith("%")) {
				String temp = substring3.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(substring3);
			 }
			if(!CanReach(x,y)) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInInventory(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+1,p2);
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			if(InvCount(x) > 0) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
		} else
		if(startsWithIgnoreCase(temp123,"GoToIfInShop(@")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = (s.substring(c1+1,p2));
			int x = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(substring2);
			 }
			if(ShopCount(x) > 0) {
				for(int L1 = 0; L1 < LabelName.length; L1++) {
					if(substring.equals(LabelName[L1]))
						Line = LabelLine[L1];
				}
			}
			
			
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 




	
			
			
			
			
			
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		} else
		if(startsWithIgnoreCase(temp123,"Quit()")) {
			Quit();
		} else
		if(startsWithIgnoreCase(temp123,"SetVar(%")) {
			String substring = s.substring(8,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = substring2;
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = substring2;
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarInvCountID(%")) {
			String substring = s.substring(p1+2,c1);
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = InvCount(substring2);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = InvCount(substring2);
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarMyHP(%")) {
			String substring = s.substring(p1+2,p2);
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = GetCurrentStat(3);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = GetCurrentStat(3);
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarsMyCoords(%")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+2,p2);
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = GetX();
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = GetX();
				VarCount++;
			}
			done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring2)) {
					VarValue[z] = GetY();
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring2;
				VarValue[VarCount] = GetY();
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"Walk(")) {
			int substring = Integer.parseInt(s.substring(p1+1,c1));
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(CanReach(substring,substring2))
				Walk(substring,substring2);
		} else
		if(startsWithIgnoreCase(temp123,"ForceWalk(")) {
			int substring = Integer.parseInt(s.substring(p1+1,c1));
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(CanReach(substring,substring2))
				ForceWalk(substring,substring2);
		} else
		if(startsWithIgnoreCase(temp123,"WalkNoWait(")) {
			int substring = Integer.parseInt(s.substring(p1+1,c1));
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(CanReach(substring,substring2))
				WalkNoWait(substring,substring2);
		} else
		if(startsWithIgnoreCase(temp123,"ForceWalkNoWait(")) {
			int substring = Integer.parseInt(s.substring(p1+1,c1));
			int substring2 = Integer.parseInt(s.substring(c1+1,p2));
			if(CanReach(substring,substring2))
				ForceWalkNoWait(substring,substring2);
		} else
		if(startsWithIgnoreCase(temp123,"WalkVar(")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+2,p2);
			int x = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					x = VarValue[l];
			}
			int y = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring2))
					y = VarValue[l];
			}
			if(x != -1 && y != -1)
				Walk(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"ForceWalkVar(")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+2,p2);
			int x = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					x = VarValue[l];
			}
			int y = -1;

			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring2))
					y = VarValue[l];
			}
			if(CanReach(x,y))
				ForceWalk(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"WalkNoWaitVar(")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+2,p2);
			int x = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					x = VarValue[l];
			}
			int y = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring2))
					y = VarValue[l];
			}
			if(CanReach(x,y))
				WalkNoWait(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"ForceWalkNoWaitVar(")) {
			String substring = s.substring(p1+2,c1);
			String substring2 = s.substring(c1+2,p2);
			int x = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					x = VarValue[l];
			}
			int y = -1;
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring2))
					y = VarValue[l];
			}
			if(CanReach(x,y))
				ForceWalkNoWait(x,y);
		} else
		if(startsWithIgnoreCase(temp123,"SetVarFightMode(%")) {
			String substring = s.substring(p1+2,p2);
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = GetFightMode();
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = GetFightMode();
				VarCount++;
			}
		} else
	if(startsWithIgnoreCase(temp123,"SetFightMode(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
			if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			SetFightMode(id);
		} else
		if(startsWithIgnoreCase(temp123,"SetVarMyID(%")) {
			String substring = s.substring(v1+1,p2);
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = -1;//a.md.e;
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = -1;//a.md.e;
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarPlayerX(%")) {
			String substring = s.substring(v1+1,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = PlayerX(id);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = PlayerX(id);
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarDistFrom(%")) {
			String var = s.substring(v1+1,c1);
			String x1 = s.substring(c1+1,c2);
			String y1 = s.substring(c2+1,p2);
			int x = -1;
			int y = -1;
 	 		if(x1.startsWith("%")) {
				String temp = x1.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x = VarValue[z];
					}
				}
			 } else {
			 	x = Integer.parseInt(x1);
			 }
			 if(y1.startsWith("%")) {
				String temp = y1.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y = VarValue[z];
					}
				}
			 } else {
			 	y = Integer.parseInt(y1);
			 }
			boolean done = false;
			int dist = -1;
			int dx = GetX() - x;
			int dy = GetY() - y;
			if(dx < 0)
				dx = dx * -1;
			if(dy < 0)
				dy = dy * -1;
			dist = dy + dx;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(var)) {
					VarValue[z] = dist;
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = var;
				VarValue[VarCount] = dist;
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"Stop("))
			Run = false;
		else
		if(startsWithIgnoreCase(temp123,"SetVarPlayerY(%")) {
			String substring = s.substring(v1+1,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = PlayerY(id);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = PlayerY(id);
				VarCount++;
			}
		} else
		
		if(startsWithIgnoreCase(temp123,"SetVarPlayerDestX(%")) {
			String substring = s.substring(v1+1,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = PlayerDestX(id);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = PlayerDestX(id);
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarPlayerDestY(%")) {
			String substring = s.substring(v1+1,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = PlayerDestY(id);
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = PlayerDestY(id);
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SetVarLastPlayerAttacked(%")) {
			String substring = s.substring(p1+2,p2);
			boolean done = false;
			for(int z = 0; z < VarCount; z++) {
				if(VarName[z].equals(substring)) {
					VarValue[z] = LastPlayerAttacked();
					done = true;
				}
			}
			if(!done) {
				VarName[VarCount] = substring;
				VarValue[VarCount] = LastPlayerAttacked();
				VarCount++;
			}
		} else
		if(startsWithIgnoreCase(temp123,"AddVar(%")) {
			String substring = s.substring(8,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					VarValue[l] += id;
			}
		} else
		if(startsWithIgnoreCase(temp123,"SubVar(%")) {
			String substring = s.substring(8,c1);
			String substring2 = s.substring(c1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					VarValue[l] -= id;
			}
		} else
		if(startsWithIgnoreCase(temp123,"UseItemByID(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			Use(FindInv(id));
		} else
		if(startsWithIgnoreCase(temp123,"DropItemByID(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			Drop(FindInv(id));
		} else
		if(s.equalsIgnoreCase("SetFire()")) {
			UseOnItem(GetX(), GetY(), 14, FindInv(166));
		} else
		if(startsWithIgnoreCase(temp123,"SetFireAtCoords(")) {
			String x = s.substring(p1+1,c1);
			String y = s.substring(c1+1,p2);
			int x_2 = -1;
 	 		if(x.startsWith("%")) {
				String temp = x.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						x_2 = VarValue[z];
					}
				}
			 } else {
			 	x_2 = Integer.parseInt(x);
			 }
			 int y_2 = -1;
			 if(y.startsWith("%")) {
				String temp = y.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						y_2 = VarValue[z];
					}
				}
			 } else {
			 	y_2 = Integer.parseInt(y);
			 }
			UseOnItem(x_2, y_2, 14, FindInv(166));
		} else
		if(startsWithIgnoreCase(temp123,"AttackNPCInCombat(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			 int id2 = -1;
			 boolean Done = false;
			 for(int a = 0; a < GetNPCCount() && !Done; a++) {
			 	System.out.println(GetNPCName(GetNPCType(a)) + " : "+GetNPCType(a));
			 	if(GetNPCType(a) == id) {
			 		id2 = a;
			 		Done = true;
			 	}
			 }
			 if(id2 != -1)
				AttackNPC(id2);
		} else
		if(startsWithIgnoreCase(temp123,"AttackNPC(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			AttackNPC(GetNearestNPC(id));
		} else	
		if(startsWithIgnoreCase(temp123,"AttackNPCArray(")) {
			String substring2 = s.substring(p1+1,p2);
			String[] ids = substring2.split(",");
			int[] ids1 = new int[ids.length];
			for(int a = 0; a < ids.length; a++) {
				ids1[a] = Integer.parseInt(ids[a]);
			}
			AttackNPC(GetNearestNPC(ids1));
		} else	
		if(startsWithIgnoreCase(temp123,"AttackPlayer(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			 AttackPlayer(id);
		} else
		if(startsWithIgnoreCase(temp123,"TradePlayer(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			TradePlayer(id);
		} else
		if(startsWithIgnoreCase(temp123,"MagicPlayer(")) {
			int player = Integer.parseInt(s.substring(p1+1,c1));
			int spell = Integer.parseInt(s.substring(c1+1,p2));
			int id = -1;
 	 		String substring1 = String.valueOf(player);
 	 		if(substring1.startsWith("%")) {
				String temp = substring1.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						player = VarValue[z];
					}
				}
			 }
			MagicPlayer(player,spell);
		} else
		if(startsWithIgnoreCase(temp123,"Accept1()"))
			AcceptTrade();
		else
		if(startsWithIgnoreCase(temp123,"Accept2()"))
			AcceptTrade2();
		else
		if(startsWithIgnoreCase(temp123,"Decline()"))
			DeclineTrade();
		else
		if(startsWithIgnoreCase(temp123,"PutTrade(")) {
			int id1 = StrToInt(s.substring(p1+1,c1));
			int amount1 = StrToInt(s.substring(c1+1,p2));
			int stacks = 0;
			if(IsStackable(id1))
				stacks = 1;
			else
				stacks = amount1;
			int[] item;
			int[] amount;
			item = new int[stacks];
			amount = new int[stacks];
			for(int i1 = 0; i1 < stacks; i1++) {
				item[i1] = id1;
				amount[i1] = amount1;
			}
			ResetTrade();
			TradeArray(item,amount);
			UpdateTrade();
		} else	
		if(startsWithIgnoreCase(temp123,"TalkToNPC(")) {
			String substring2 = s.substring(p1+1,p2);
			int id = -1;
 	 		if(substring2.startsWith("%")) {
				String temp = substring2.substring(1);
			 	for(int z = 0; z < VarCount; z++) {
			 		if(VarName[z].equals(temp)) {
						id = VarValue[z];
					}
				}
			 } else {
			 	id = Integer.parseInt(substring2);
			 }
			TalkToNPC(GetNearestNPC(id));
		} else
		if(startsWithIgnoreCase(temp123,"WaitForMenuAndAnswer(")) {
			int substring = Integer.parseInt(s.substring(p1+1,p2));
			long l = System.currentTimeMillis();
			while(System.currentTimeMillis() - l < 15000 && !QuestMenu() && Running())
				Wait(1);
			if(QuestMenu())
				Answer(substring);
		} else
		if(startsWithIgnoreCase(temp123,"WaitForBank()")) {
			long l = System.currentTimeMillis();
			while(System.currentTimeMillis() - l < 10000 && !Bank() && Running())
				Wait(1);
		} else
		if(startsWithIgnoreCase(temp123,"Debug(")) {
			String substring = s.substring(p1+1,p2);
			System.out.println(substring);
		} else
		if(startsWithIgnoreCase(temp123,"DebugRS(")) {
			String substring = s.substring(p1+1,p2);
			DisplayMessage("@gre@[@whi@G-Bot@gre@]@whi@: "+substring, 3);
		} else
		if(startsWithIgnoreCase(temp123,"DebugVar(%")) {
			String substring = s.substring(10,p2);
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					System.out.println(VarValue[l]);
			}
		} else
		if(startsWithIgnoreCase(temp123,"DebugRSVar(%")) {
			String substring = s.substring(p1+2,p2);
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					DisplayMessage("@gre@[@whi@G-Bot@gre@]@whi@: "+VarValue[l], 3);
			}
		} else
		if(startsWithIgnoreCase(temp123,"WaitVar(%")) {
			String substring = s.substring(p1+2,p2);
			for(int l = 0; l < VarCount; l++) {
				if(VarName[l].equals(substring))
					Wait(VarValue[l]);
			}
		} else
		if(startsWithIgnoreCase(temp123,"Wait(")) {
			int substring = Integer.parseInt(s.substring(p1+1,p2));
			Wait(substring);
		} else
			Wait(0);
		Processing = false;
	}
	Run = false;
	for(int z1 = 0; z1 < Script.length; z1++)
		Script[z1] = null;
	for(int z2 = 0; z2 < LabelName.length; z2++) {
		LabelName[z2] = null;
		LabelLine[z2] = -1;
	}
	for(int z3 = 0; z3 < VarName.length; z3++) {
		VarName[z3] = null;
		VarValue[z3] = -1;
	}
	LabelCount = -1;
	VarCount = 0;
	line = 0;
}
public boolean startsWithIgnoreCase(String[] base, String s) {
	if(base[0].startsWith(s) || base[1].startsWith(s))
		return true;
	if(base[0].equalsIgnoreCase(s) || base[1].equalsIgnoreCase(s))
		return true;
	return false;
}
String Script[] = new String[300000];
String LabelName[] = new String[300000];
int LabelLine[] = new int[300000];
String VarName[] = new String[300000];
int VarValue[] = new int[300000];
int LabelCount = -1;
int VarCount = 0;
int line;
long StartTime = 0L;
     public void WhileRunning() {
     	new Thread ( new Runnable() { public void run() {
     		while(Running()) {
     			Wait(50);
     		}
     		LabelCount = -1;
		VarCount = 0;
		line = 0;
		frame.setVisible(false);
	}}).start();
    }
    public void start(String command, String args[]) {
        WhileRunning();
        SwingUtilities.invokeLater(new Runnable() {

            public void run()
            {
               LoadPanel();
            }

        });
    }
    boolean Processing;
    protected static ImageIcon createImageIcon(String path, String description) {
	java.net.URL imgURL = Panel.class.getResource(path);
	if(imgURL != null) {
		return new ImageIcon(imgURL, description);
	} else {
		return new ImageIcon("http://www.theintensity.com/users/g-bot/"+path, description);
	}
     }
       public void LoadPanel() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("[G-Bot] - Scriptable");
        frame.setDefaultCloseOperation(2);
        frame.setSize(new Dimension(300, 200));
        frame.setBackground(new Color(63, 131, 245));
        panel = new JPanel(new GridLayout(2,2));
        addWidgetsStopped();
        ImageIcon icon = createImageIcon("gbot.png","test");
        frame.setIconImage(icon.getImage());
        frame.getRootPane().setDefaultButton(auth);
        frame.getContentPane().add(panel, "Center");
        frame.pack();
        frame.setVisible(true);
    }
    public int DistanceX(int id) {
	int pX = PlayerX(id);
	int mX = GetX();
	int tX = pX - mX;
	if(tX < 0)
	  tX = tX * -1;
	return tX;
}
public int DistanceY(int id) {
	int pY = PlayerY(id);
	int mY = GetY();
	int tY = pY - mY;
	if(tY < 0)
	  tY = tY * -1;
	return tY;
}
}