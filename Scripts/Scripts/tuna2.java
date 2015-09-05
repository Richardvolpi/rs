public class tuna2 extends Script
{
   public tuna2(mudclient rs)
   {
       super(rs);
   }
   public String[] getCommands()
   {
       return new String[]{"tuna2"};
   }
   public void start(String command, String parameter[])
   {
    DisplayMessage("Start", 3);
    while(Running())
    {
      if(Fatigue() >= 85 && Running() && Sleeping() == false)
      {
          Use(FindInv(1263));
          Wait(400);
      }

      if(Running() && Sleeping() == false)
        {
           AtObject(368,684);
            Wait(1200);
        }

        if(InvCount() == 30 && Sleeping() == false)
        {
        Walk(369,688);
        Walk(371,703);
        Walk(366,710);
        while (QuestMenu() == false)
  {
        int npcs[] = {168,169};
        int ID = GetNearestNPC(npcs);
        TalkToNPC(ID);
        Wait(1300);
  }
        Answer(0);
        while (Shop() == false)
           Wait(2000);
        while (InvCount(366) > 0)
  {
           Sell(366);
           Wait(200);
  }
        while (InvCount(369) > 0)
  {
           Sell(369);
           Wait(200);
  }
        Walk(366,710);
        Walk(371,703);
        Walk(369,688);
        }
      }
      DisplayMessage("Done", 3);
   }
   
   }