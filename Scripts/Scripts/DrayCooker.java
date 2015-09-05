import java.awt.Toolkit;
public class DrayCooker extends Script
{
   public String owner = "Bruncle";
   public boolean Chopped = false;
   public int cooked = 0;
   public DrayCooker(mudclient rs)
   {
       super(rs);
   }
 
   public String[] getCommands()
   {
       return new String[]{"draycook"};
   }  
   public void ServerMessage(String message)
  {
     if (message.equals("@gam@You get some wood"))
        Chopped = true;
     if (message.equals("@gam@The lobster is now nicely cooked"))
        cooked++;
  }    
  public void SlowPrint(String message)
{
for (int i = 0; i < message.length(); i++)
{
 System.out.print(message.substring(i,i+1));
 Wait(150);
 }
System.out.println("");
}
   public void start(String command, String parameter[])
   {
    if (parameter.length != 1)
{
DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN draycook [report interval]", 3);
} else {
int reporttime = Integer.parseInt(parameter[0]);
     int xp = GetExperience(7);
     DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Draynor Lob Cooker! You rip it, I rip you.. @ran@=@ran@=@ran@=@ran@=@ran@=",3);
     int certs = 4;
     int slept = 0;
     long time = System.currentTimeMillis();
long starttime = System.currentTimeMillis();
     while (Running())
     {
      if (System.currentTimeMillis() - time > (reporttime * 60000))
      {
       int exper = GetExperience(7) - xp;
       time = System.currentTimeMillis();
       SlowPrint("--------------PROGRESS REPORT-----------------");
       SlowPrint("You have gained "+ exper+ " cooking experience..");
       SlowPrint("You have cooked "+cooked+" lobsters");
       SlowPrint("You have slept "+slept+" times");
       SlowPrint("You have been reported "+Rand(1,100)+" times (uh oh)");
       SlowPrint("You have been autoing for " + ((System.currentTimeMillis() - starttime) / 60000 ) + " minutes");
      }
        while (InvCount(373) < 5 && InvCount(372) == 0 && Running() && System.currentTimeMillis() - time < (reporttime * 60000))
        {
         DisplayMessage("Talking to certers",3);
         if (InvCount(373) > 0) certs = 3; else certs = 4;
         while (!QuestMenu() && Running())
         {
          int certer = GetNearestNPC(227);
          TalkToNPC(certer);
          Wait(1500);
         }
         Wait(1000);
         while (!QuestMenu() && Running()) Wait(1000);
         Wait(500);
         Answer(0);
         while (!QuestMenu() && Running()) Wait(1000);
         Wait(500);
         Answer(3);
         while (!QuestMenu() && Running()) Wait(1000);
         Wait(500);
         Answer(certs);
         Wait(2000);
        }
         while (InvCount(372) > 0 && Running()&& System.currentTimeMillis() - time < (reporttime * 60000))
         {
          DisplayMessage("Getting Ready to cook lobs..",3);
          if (GetNearestObject(97)[0] == -1 && Running())
          {
           while (Running() && Fatigue() < 100 && Chopped == false)
           {
            int tree[] = GetNearestObject(70);
            AtObject2(tree[0],tree[1]);
            Wait(1000);
           }
           while (GetNearestObject(97)[0] == -1 && Running() && Fatigue() < 100 && GetNearestItem(14) != null)
           {
            Chopped = false;
            int logs2[] = GetNearestItem(14);
            UseOnItem(logs2[0],logs2[1],14,FindInv(166));
            Wait(1000);
           }
          }
          while (GetNearestObject(97)[0] != -1 && Running() && InvCount(372) > 0 && Fatigue() < 100 && System.currentTimeMillis() - time < (reporttime * 60000))
          {
           int fire[] = GetNearestObject(97);
           UseOnObject(fire[0],fire[1],FindInv(372));
           Wait(1000);
          }
          if (Fatigue() >= 97 && Running() == true)
  {
   DisplayMessage("Sleeping",3);
   System.out.print("\007"); System.out.flush();
      while (Sleeping() == false && Running() == true)
     {
          Use(FindInv(1263));
          Wait(2500);
      }
      while (Sleeping() == true && Running() == true)
         { Wait(100);
          slept++;
        } }
       }
        if (InvCount(372) == 0 && Running() && System.currentTimeMillis() - time < (reporttime * 60000))
        {
         DisplayMessage("Talking to certers",3);
         if (InvCount(374) > 0 && Running())
         {
          Drop(FindInv(374));
          Wait(1500);
         }
         
         double lobs = InvCount(373) / 5;
         if (lobs == 5) certs = 4;
         if (lobs < 5 && lobs > 4) certs = 3;
         if (lobs < 4 && lobs > 3) certs = 2;
         if (lobs < 3 && lobs > 2) certs = 1;
         if (lobs < 2 && lobs > 1) certs = 0;
         if (lobs < 1 && lobs > 0) certs = -1;
         
         while(InvCount(373) > 0 && Running() && certs > -1)
         {
          while (!QuestMenu() && Running())
            {
             int certer = GetNearestNPC(227);
             TalkToNPC(certer);
             Wait(1500);
            }
            Wait(200);
            while (!QuestMenu() && Running()) Wait(1000);
            Wait(500);
            Answer(1);
            while (!QuestMenu() && Running()) Wait(1000);
            Wait(500);
            Answer(0);
            while (!QuestMenu() && Running()) Wait(1000);
            Wait(500);
            Answer(certs);
            Wait(2000);
            if (InvCount(373) > 0 && Running())
            {
             lobs = InvCount(373);
            }
            Wait(1500);
           }
          }
           
     }
     DisplayMessage("@red@STOPPED ", 3);
     
   }
}
}