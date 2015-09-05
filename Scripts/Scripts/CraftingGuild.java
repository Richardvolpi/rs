public class CraftingGuild extends Script
{
   public CraftingGuild(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"craftadoll"};
   }

   public void start(String command, String parameter[])
   {
     DisplayMessage("@gre@SBoT: @Ran@Crafter's guild - @ran@Made by Sa",3);
        while (Running())
      {
        { 
         while (Running()  == true && InvCount() < 30)
           {
            if (Fatigue() >= 80 && Running() == true)
              {
              while (Sleeping() == false)
                {
                 Use(FindInv(1263));
                     Wait(2500);
                }
              while (Sleeping() == true)
                 {
                  Wait(100);
                 }
              }
          AtObject(GetNearestObject(196));
            Wait(1000);
           AtObject(GetNearestObject(195));
            Wait(1000);
            }
            DisplayMessage("@gre@Banking...",3);
            Wait(1000);
            Walk(341,604);
            Wait(100);
            Walk(341,609);
            Wait(100);
            Walk(345,610);
            Wait(100);
            Walk(348,606);
            Wait(100);
            Walk(347,602);
            Wait(100);
            OpenDoor(347, 601, 0);
            Wait(2000);
            Walk(344,597);
            Wait(100);
            Walk(338,595);
            Wait(100);
            Walk(332,595);
            Wait(100);
            Walk(325,595);
            Wait(100);
            Walk(318,595);
            Wait(100);
            Walk(311,594);
            Wait(100);
            Walk(305,591);
            Wait(100);
            Walk(299,588);
            Wait(100);
            Walk(292,588);
            Wait(100);
            Walk(289,587);
            Wait(100);
            Walk(287,575);
            Wait(100);
            AtObject(287,571);
            Wait(2000);
            Walk(285,571);
            Wait(2000);
           {
              {
             while (QuestMenu() == false && Running() == true)
              {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(2000);
       }
        Answer(0);

            while (Bank() == false && Running() == true)
       {
                Wait(100);
       }


            while (Bank() == true && Running() == true)
       {
            DisplayMessage("@gre@Banking @ran@please @red@wait",3);
            Wait(1000);
            while(InvCount(383) > 0)
       {
                Deposit(383,1);
                Wait(100);
       }

         while (InvCount(157) > 0)
           {
            Deposit(157,1);
            Wait(100);
           }
         while (InvCount(158) > 0)
           {
            Deposit(158,1);
            Wait(100);
           }
         while (InvCount(159) > 0)
           {
            Deposit(159,1);
            Wait(100);
           }
         while (InvCount(160) > 0)
           {
            Deposit(160,1);
            Wait(100);
           }
         CloseBank();
           }
          Wait(3000);
           DisplayMessage("@gre@Walking back!",3);
          {
AtObject(287,571);
Wait(4000);
Walk(289,577);
Walk(290,581);
Wait(100);
Walk(293,583);
Wait(100);
Walk(298,586);
Wait(100);
Walk(303,589);
Wait(100);
Walk(307,589);
Wait(100);
Walk(311,590);
Wait(100);
Walk(314,593);
Wait(100);
Walk(320,595);
Wait(100);
Walk(327,595);
Wait(100);
Walk(333,594);
Wait(100);
Walk(340,596);
Wait(100);
Walk(344,598);
Wait(100);
Walk(347,600);
Wait(2000);
OpenDoor(347, 601, 0);
Wait(1000);
Walk(348,606);     
Wait(100);
Walk(343,610);
Wait(2000);   
      }
    }
}
}
}
}
} 