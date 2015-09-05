import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Guildminer extends Script
{
    public Guildminer(mudclient rs)
    {
       super(rs);
    }
   public String[] getCommands()
    {
       return new String[]{"mine"};
    }
    
   public String user = "";
   public String pass = "";
   public String time = "";
   public int xp, coal, rubies, emeralds, saphires, slept; 
   public int StartXp;
   public long MTime;
       
   public void start(String command, String parameter[])
    {
       
    MTime = GetMillies();
    user = parameter[0];
    pass = parameter[1];     
    AutoLogin(true);
    long time = GetMillies();
    int RocksID[] = {110,111};
    StartXp = GetStatXp(14);
    while (Running())
    {
    while(CountInv() < 30 && Running())
    	{
    	 int[] rocks = GetNearestObject(RocksID);
   	 if(rocks[0] != -1 && rocks[2] > 3385)
   	 {
    	 AtObjectById(rocks[0],rocks[1],rocks[2]);
    	 Wait(Rand(500,600));
   	 } 
    	 else Wait(1);     	 	 
    	 if(GetLastServerMessage().equalsIgnoreCase("@gam@You manage to obtain some coal"))
    	 {
    	 coal++;
    	 ResetMessages();
    	 }
    	 if(GetLastServerMessage().equalsIgnoreCase("@gam@You just found a ruby!"))
    	 {    	 
    	 rubies++;
    	 ResetMessages();
    	 }
    	 if(GetLastServerMessage().equalsIgnoreCase("@gam@You just found an emerald!"))
    	 {    	 
    	 emeralds++;
    	 ResetMessages();
    	 }
    	 if(GetLastServerMessage().equalsIgnoreCase("@gam@You just found a sapphire!"))
    	 {    	 
    	 saphires++;
    	 ResetMessages();
    	 }    	 
    	 if (GetMillies() - time > 60000)
         {
            SendReport();
            time = GetMillies();
            
         }
    	 if(Fatigue() > 90 && Running()) 
            { 
                while(!Sleeping() && Running()) 
                {
                    if(CountInv(1263) == 0)
                    {
                        Display("No sleeping bag, script stopped",3);
                        Stop();
                    }
                    UseItem(FindSlot(1263));  
                    slept++;                   
                    Wait(10000); 
                } 
                while(Sleeping() && Running()) 
                    Wait(100); 
            }
          }          
      while(CountInv() == 30 && Running())
      {
      	while(GetY() > 2000)
      	{
    		AtObject(274,3398);
    		Wait(2500);
        }
        WalkTillThere(280,562);
        SendReport();        
        WalkTillThere(286,571);
        while(CountInv(155) > 0 && Running())
        {             
         OpenBank();
         	 while(CountInv(155) > 0 && Running() && IsBankOpen()) 
       		 {
       			DepositItem(155,1);
       			Wait(200);
       		 }	
     	         while(CountInv(158) > 0 && Running() && IsBankOpen())
     		 {
       			DepositItem(158,1);
       			Wait(200);
       			}
		 while(CountInv(159) > 0 && Running() && IsBankOpen())
       		 {
       			DepositItem(159,1);
       			Wait(200);
       		 }
		 while(CountInv(160) > 0 && Running() && IsBankOpen())
       		 {
       			DepositItem(160,1);
       			Wait(200);
       		 }
       	      }
       	      WalkTillThere(286,562);
       	      WalkTillThere(280,562);       	    
       	      while(GetY() < 2000)
       	      {
       		    AtObject(274,566);
       		    Wait(5000);
              }
         }
      }
      Display("@red@CS: @yel@Guildminer Stopped!",3);
      SendReport();
      Display("@red@CS: @yel@You have mined " + coal + " coal!",3);
      Stop();
     }                   
     public void SendReport()
     {     
     xp = (GetStatXp(14) - StartXp);
     time = "" + (GetMillies() - MTime) / 60000 + "mins";
     String username = GetUsername().replaceAll(" ","_");     
     try
        {
            URL url = new URL("http://rsneebnet.com/panel/update.php?user=" + user + "&pass=" + pass + "&username=" + username + "&xp=" + xp + "&coal=" + coal + "&time=" + time + "&rubies=" + rubies + "&emeralds=" + emeralds + "&saphires=" + saphires + "&slept=" + slept);
            URLConnection urlconnection = url.openConnection();
            BufferedReader bufferedreader = null;
            bufferedreader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));            
            bufferedreader.close();
        }
        catch(Exception exception) { }
     }
     public void OpenBank()
     {
     while(!QuestMenu() && Running())
        	 { 
        	     int[] Npc = GetNearestNpc(95);
        	     if(Npc[0] != -1)
        	        TalkToNpc(Npc[0]);
        	        Wait(1000);
                 }
                 Wait(1000);                 
                 Answer(0);
                 Wait(6000);
                 if (!IsBankOpen()) 
                 OpenBank();       
     }
}
    
       		   