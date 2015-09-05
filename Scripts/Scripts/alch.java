public class alch extends Script
{
    public alch(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"alch"};
    }
    public long StartTime = System.currentTimeMillis();
    public int Trips = 0;
    public int SpellCount = 0;
    public int SleepCount = 0; 
    public int LVL = 0;
    public void ServerMessage(String message)
    {
         if (message.startsWith("@gam@Alchemy")) SpellCount++;
         if(message.startsWith("@gre@You just advanced"))
         {
             LVL++;
         }
    }
    public void KeyPressed(int id)
    {
       if (id == 1012)
       {
         int XPGain = SpellCount * 130;
         long TotalTime = System.currentTimeMillis() - StartTime;
         long MinsWorked = TotalTime / 60000L;
         for(int i=0;i<25;i++)
           System.out.println();
         DisplayMessage("@gre@Working for "+ MinsWorked + " minutes",3);
         DisplayMessage("@gre@Gained "+XPGain +" magic experience",3);
         Println("------------------------");
         Println("Status Report: AnyItem High-Alcher");
         Println("------------------------");
         Println("Working for "+ MinsWorked + " minutes");
         Println("Alched "+ SpellCount + " items");
         Println("Gained "+ XPGain +" magic experience");
         Println("Slept "+ SleepCount +" times");
         id = 0;
       }
    }
    public void start(String command, String parameter[])
    {     
      int ITEM = Integer.parseInt(parameter[0]);
      DisplayMessage("@gre@SBoT: @whi@High-Alcher @gre@v2",3);
      while (Running() && InvCount(40) > 0)
      {
       SpellCount++;
       while(InvCount(ITEM) > 0 && InvCount(40) > 0 && Running())
       {
         if (Fatigue() >= 95)
         {
           while (!Sleeping())
           {
             Wait(500);
             Use(FindInv(1263));
             Wait(2000);
           }
           while (Sleeping())
            Wait(1);
           SleepCount++;
         }
         MagicInventory((FindInv(ITEM)), 28);
          Wait(500);
       }
       while (!QuestMenu() && Running())
       {
         int Bankers[] = new int[] {95, 268};
         int BankerIDs = GetNearestNPC(Bankers);
         TalkToNPC(BankerIDs);
         Wait(1000);
       }
       Answer(0);
       while (!Bank() && Running())
        Wait(1);
       while (InvCount() < 30 && Running())
       {
         Withdraw(ITEM,1);
         Wait(100);
       }
       CloseBank();
      }
         int XPGain = SpellCount * 130;
         long TotalTime = System.currentTimeMillis() - StartTime;
         long MinsWorked = TotalTime / 60000L;
         for(int i=0;i<25;i++)
           System.out.println();
         DisplayMessage("@whi@Jake: @red@Stopped High Alcher.",3);
         DisplayMessage("@gre@Working for "+ MinsWorked + " minutes",3);
         DisplayMessage("@gre@Gained "+XPGain +" magic experience",3);
         Println("------------------------");
         Println("Final Report: AnyItem High-Alcher");
         Println("------------------------");
         Println("Working for "+ MinsWorked + " minutes");
         Println("Alched "+ SpellCount + " items");
         Println("Gained "+ XPGain +" magic experience");
         Println("Slept "+ SleepCount +" times");
    }
}