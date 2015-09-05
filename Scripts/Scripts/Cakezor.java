public class Cakezor extends Script
{
   public Cakezor(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"Cakeplz"};
   }

   public void start(String command, String parameter[])
   {
     DisplayMessage("@yel@S@blu@A @red@- @ran@Cake thieving :D",3);
     DisplayMessage("@gre@Script @whi@Started",3);
        while (Running())
        {
        { 
         while (Running()  == true && InvCount() < 30)
           {
            if (Fatigue() >= 90 && Running() == true)
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
          AtObject2(544,599);
          Wait(750);
            }
             Walk(544,611);
             Walk(549,612);
             AtObject(550,612);
             Walk(551,612);
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
           Wait(1000);
            while(InvCount(330) > 0)
       {
            Deposit(330,1);
                Wait(100);
                }
                CloseBank();
                }
                Wait(2000);
               {
               Walk(551,612);
               AtObject(550,612);
               Walk(543,600);
               Walk(543,600);
                {
                Wait(500);   
      }
    }
 DisplayMessage("@red@poo", 3);
}
}
}
}
}
}