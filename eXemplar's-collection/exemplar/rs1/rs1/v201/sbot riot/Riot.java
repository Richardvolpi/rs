import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;

public class Riot extends Script {
    boolean IsBusy = false;
	public Riot(mudclient rs)
        {super(rs);}

	public String[] getCommands()
        	{return new String[]{"riot"};}

	public void ServerMessage(String message)
   		{}
	public void tut(){
		Say("Test");
	      WaitForNPCMessage(476,15,"Left click on");
	      WaitForQuestMenu();
	      Answer(0);
	      WaitForNPCMessage(10,"various aspects of the game");
	      while (GetX() < 222)
	      {
	         Walk(221,743);
	         OpenDoor(222, 743, 1);
	         Wait(2500);
	      }
	      WaitForNPCMessage(499,90,"speak to the combat instructor");
	      while (GetY() > 736)
	      {
	         Walk(224,737);
	         OpenDoor(224, 737, 0);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(474, 40, "Their box will go red");
	      Wield(FindInv(4));
	      Wait(1000);
	      Wield(FindInv(70));
	      ResetLastNPCMessage();
	      while (LastNPCMessage().indexOf("Now speak to the combat") < 0)
	      {
	         int ID = GetNearestNPC(473);
	         AttackNPC(ID);
	         Wait(2500);
	      }
	      WaitForNPCMessage(474,60,"northeast");
	      while (GetX() > 219)
	      {
	         Walk(220,727);
	         OpenDoor(220, 727, 1);
	         Wait(2500);
	      }
	      WaitForNPCMessage(478,60,"In this case use it on the range");
	      ResetLastNPCMessage();
	      while (LastNPCMessage().indexOf("speak to the cooking instructor again") < 0)
	      {
	         UseOnObject(216, 731, FindInv(503));
	         Wait(5000);
	      }
	      WaitForNPCMessage(478,60,"another piece of meat");
	      ResetLastNPCMessage();
	      while (LastNPCMessage().indexOf("speak to the cooking instructor again") < 0)
	      {
	         UseOnObject(216, 731, FindInv(503));
	         Wait(5000);
	      }
	      WaitForNPCMessage(478,90,"If the number on the left");
	      Wait(5000);
	      WaitForNPCMessage(478,60,"proceed through the next door");
	      while (GetX() > 211)
	      {
	         Walk(212,729);
	         OpenDoor(212, 729, 1);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(480,90,"the next door");
	      while (GetX() > 205)
	      {
	         Walk(206,730);
	         OpenDoor(206, 730, 1);
	         Wait(2500);
	      }
	      Wait(1000);
	      Walk(201,726);
	      WaitForNPCMessage(479,90,"you might catch some fish");
	      while (FindInv(349) == -1)
	      {
	         AtObject(196,726);
	         Wait(1000);
	      }
	      WaitForNPCMessage(479,90,"cook the shrimps");
	      while (GetY() < 734)
	      {
	         Walk(201,733);
	         OpenDoor(201, 734, 0);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(482,90,"select prospect");
	      Wait(2500);
	      while (LastNPCMessage().indexOf("increase") < 0)
	      {
	         AtObject2(203,740);
	         Wait(5000);
	      }
	      WaitForNPCMessage(482,90,"hit those rocks");
	      Wait(2500);
	      while (FindInv(202) == -1)
	      {
	         AtObject(203,740);
	         Wait(5000);
	      }
	      WaitForNPCMessage(482,90,"speak to the bankers");
	      while (GetY() < 746)
	      {
	         Walk(198,745);
	         OpenDoor(198, 746, 0);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(485,90,"Certainly");
	      while (GetX() < 204)
	      {
	         Walk(203,752);
	         OpenDoor(204, 752, 1);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(489,90,"each quest once");
	      WaitForQuestMenu();
	      Answer(0);
	      Wait(3000);
	      while (GetY() < 754)
	      {
	         Walk(209,753);
	         OpenDoor(209, 754, 0);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(493,90,"very rewarding");
	      WaitForQuestMenu();
	      Answer(1);
	      WaitForQuestMenu();
	      Answer(0);
	      WaitForNPCMessage(90,"next door");
	      while (GetX() < 217)
	      {
	         Walk(216,760);
	         OpenDoor(217, 760, 1);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(494,90,"definitely");
	      WaitForQuestMenu();
	      Answer(1);
	      WaitForNPCMessage(90,"checked this");
	      Wait(5000);
	      WaitForNPCMessage(494,90,"yellow in");
	      Wait(5000);
	      WaitForNPCMessage(494,90,"as a target");
	      while (LastServerMessage().indexOf("Cast spell successfully") < 0)
	      {
	         int chicken = GetNearestNPC(3);
	         MagicNPC(chicken,0);
	         Wait(5000);
	      }
	      WaitForNPCMessage(494,90,"next door");
	      while (GetX() < 222)
	      {
	         Walk(221,760);
	         OpenDoor(222, 760, 1);
	         Wait(2500);
	      }
	      Wait(1000);
	      WaitForNPCMessage(774,90,"talk to me again");
	      while (!Sleeping()){
	      	 AtObject(222,761);
	      	 Wait(1000);
	      }
	      while (Sleeping()) Wait(100);
	      Println("test");
	      WaitForNPCMessage(774,90,"next");
	      Println("Going through fatigue door");
	      Wait(1000);
	      while (!CanReach(226,760))
	      {
	      	 Println("Going through fatigue door");
	         WalkNoWait(226,760);
	         OpenDoor(226, 760, 1);
	         Wait(2500);
	      }	
	      Wait(1000);
	      WaitForNPCMessage(496,90,"other players");
	      while (!QuestMenu()) Wait(2000);
	      Answer(0);
	      WaitForNPCMessage(90,"send a message");
	      while (!QuestMenu()) Wait(2000);
	      Answer(1);	   
	      Wait(4000);
	      Println("Going through lady's door");
	      while (!CanReach(230,758))
	      {
	         WalkNoWait(230,758);
	         OpenDoor(230, 759, 0);
	         Wait(2500);
	      }	
	      Wait(1000);
	      while (!QuestMenu()) {
	      	TalkToNPC(GetNearestNPC(497));
	      	Wait(2000);
	      }
	      Answer(0);
	      while (GetX() != 120) Wait(100);
	      DisplayMessage("Finished tutorial, starting to train character",3);
	      aNewWorld();
	   }
	   
	   public String createUserName(){
	   	Random rnd = new Random();
	   	int rndo = rnd.nextInt(231230983);
        	return Integer.toString(rndo);
    	   }    	   
    	   	   
	   public void WaitForNPCMessage(int time, String message)
	   {
	      ResetLastNPCMessage();
	      while (LastNPCMessage().indexOf(message) < 0)
	      {
	         long T = TickCount();
	         if (LastNPCMessage() != null)
	            while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
	               Wait(100);
	         Wait(1000);
	      }
	   }
	   public void WaitForNPCMessage(int type, int time, String message)
	   {
	      ResetLastNPCMessage();
	      while (LastNPCMessage().indexOf(message) < 0)
	      {
	         ResetLastServerMessage();
	         ResetLastNPCMessage();
	         int id = GetNearestNPC(type);
	         long T = TickCount();
	         TalkToNPC(id);
	         while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == "")
	            Wait(100);
	         if (LastServerMessage().indexOf("busy") < 0)
	         {
	            T = TickCount();
	            if (LastNPCMessage() != null)
	               while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
	                  Wait(100);
	         }
	         Wait(1000);
	      }
	   }
	   public void WaitForQuestMenu()
	   {
	      while (!QuestMenu())
	         Wait(100);
	   }
	   
	   public void lumDray(){
	   	if (LoggedIn())
		   Walk(130,641);
		if (LoggedIn())
		   Walk(142,637);
		if (LoggedIn())
		   Walk(155,637);
		if (LoggedIn())
		   Walk(178,635);
		if (LoggedIn())
		   Walk(180,635);
		if (LoggedIn())
		   Walk(193,635);
		if (LoggedIn())
		   Walk(206,636);
		if (LoggedIn())
		   Walk(218,636);
	   }   
	   public void drayBarb(){
	   	if (LoggedIn())
	   	Walk(220,633);
	   	if (LoggedIn())
		Walk(234,623);
		if (LoggedIn())
		Walk(250,610);
		if (LoggedIn())
		Walk(266,610);
		if (LoggedIn())
		Walk(282,600);
		if (LoggedIn())
		Walk(290,583);
		if (LoggedIn())
		Walk(291,566);
	   }
	   public void barbFal(){
	   	if (LoggedIn())
	   	Walk(205,633);
	   	if (LoggedIn())
		Walk(192,634);
		if (LoggedIn())
		Walk(180,635);
		if (LoggedIn())
		Walk(165,635);
		if (LoggedIn())
		Walk(153,637);
		if (LoggedIn())
		Walk(134,638);
		if (LoggedIn())
		Walk(125,645);
		
	   }
	   public void falDray(){
	   if (LoggedIn())
	   	Walk(291,566);
	   	if (LoggedIn())
		Walk(290,583);
		if (LoggedIn())
		Walk(282,600);
		if (LoggedIn())
		Walk(266,610);
		if (LoggedIn())
		Walk(250,610);
		if (LoggedIn())
		Walk(234,623);
		if (LoggedIn())
		Walk(220,633);
		
	   }
	   public void drayEdge(){
	   if (LoggedIn())
	   	Walk(221,634);
	   	if (LoggedIn())
		Walk(231,623);
		if (LoggedIn())
		Walk(233,608);
		if (LoggedIn())
		Walk(236,594);
		if (LoggedIn())
		Walk(241,578);
		if (LoggedIn())
		Walk(239,559);
		if (LoggedIn())
		Walk(237,540);
		if (LoggedIn())
		Walk(238,525);
		if (LoggedIn())
		Walk(225,511);
		if (LoggedIn())
		Walk(218,492);
		if (LoggedIn())
		Walk(220,478);
		if (LoggedIn())
		Walk(224,463);
	   }
	   public void edgeVar(){
	   if (LoggedIn())
	   	Walk(224,460);
	   	if (LoggedIn())
		Walk(220,477);
		if (LoggedIn())
		Walk(218,487);
		if (LoggedIn())
		Walk(217,502);
		if (LoggedIn())
		Walk(216,511);
		if (LoggedIn())
		Walk(200,515);
		if (LoggedIn())
		Walk(183,515);
		if (LoggedIn())
		Walk(165,507);
		if (LoggedIn())
		Walk(152,509);
	   }
	   public void varLum(){
	   if (LoggedIn())
	   	Walk(131,510);
	   	if (LoggedIn())
		Walk(131,524);
		if (LoggedIn())
		Walk(129,542);
		if (LoggedIn())
		Walk(121,561);
		if (LoggedIn())
		Walk(106,572);
		if (LoggedIn())
		Walk(92,574);
		if (LoggedIn())
		Walk(91,574);
		if (LoggedIn())
		Walk(94,578);
		if (LoggedIn())
		Walk(108,594);
		if (LoggedIn())
		Walk(113,610);
		if (LoggedIn())
		Walk(106,630);
		if (LoggedIn())
		Walk(101,644);
		if (LoggedIn())
		Walk(103,655);
		if (LoggedIn())
		Walk(114,650);
	   }	
	   
	   public void talk(){
	   	new Thread
      		(
         		new Runnable()
         			{
            				public void run()
            				{
            					Println("Started abusing");
            					String riot[] = {"RSC sucks","Andrew Gower suck my dick","Down with feminism","Give me back my char","I need to go to the toilet",
	   						"Sbot is not dead!","I like camels","Sbot ownz"};
	   					Random rnd = new Random(riot.length);
               					while (Running())
               						{	
               							Println(riot[rnd.nextInt()]);
               							Say(riot[rnd.nextInt()]);
               							try{
               								Thread.sleep(2000);
               							}
               							catch (Exception e){}
               						}
               				}
               			}
               	);
           }
	   
	   public static boolean createAccount(String user, String pass) {
        if(user.length() > 12 || user.length() < 2 || pass.length() < 5 || pass.length() > 20)
            return false;
        try {
            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
            data += "&" + URLEncoder.encode("password1", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
            data += "&" + URLEncoder.encode("password2", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
            data += "&" + URLEncoder.encode("tandc", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
            
            URL url = new URL("https://create.runescape.com/aff/runescape/create.cgi");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String rdata = "";
            while ((line = rd.readLine()) != null) {
                rdata += line;
            }
            
            if(rdata.indexOf("Your account has now been created with the username and password you have chosen") > 0)
                return true;
            
            wr.close();
            rd.close();
        } catch (Exception e) { }
        return false;
    }
	   
	   public void aNewWorld(){
		while(Running() && LoggedIn()){
			lumDray();
			drayBarb();
			barbFal();
			falDray();
			drayEdge();
			edgeVar();
			varLum();
		}
	   }
	   
	   public void start(String command, String parameter[])
   	   {
   	   	DisplayMessage("Rioting",3);
   	   	talk();
   	   	while (Running()){
   	   		String name = createUserName();
   	   		Println("Creating account: "+name);
   	   		if (createAccount(name,"hello")){
   	   			Println("Created account: "+name);
	   	   		Logout();
	   	   		Wait(3000);
	   	   		Login(name,"hello");
	   	   		while (!CharDesignScreen()) Wait(1);
	   	   		if (CharDesignScreen()){
	   	   			Println("Designing char..");
	   	   			DesignChar();
	   	   			Wait(3500);
	   	   		}	
				tut();
			}
			else
				Println("Couldn't create account:S ");
		}
	   }
}