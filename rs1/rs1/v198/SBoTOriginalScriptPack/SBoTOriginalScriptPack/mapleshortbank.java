public class mapleshortbank extends Script
{
    public mapleshortbank(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {"maplefletcher"});
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@dre@=@whi@=@dre@= @red@Maple Shortbow fletcher + bank Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3);
       

        while (Running())
        {

            while (InvCount() < 30)
            {
                while (InvCount(634) > 0)
            {
            UseWithInventory(FindInv(13), FindInv(634));
            Wait(1200);
            if (QuestMenu() == true && Running() == true)
            {
            Answer(0);
            Wait(1000);
            }
            }


                if (Fatigue() > 95 && Sleeping() == false)
               {
            System.out.println();
                                      System.out.println("To Tired Sleeping...");
                                System.out.println();
            DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
                  Use(FindInv(1263));
                  Wait(5000);
               }
               
                int ai[] = GetNearestObject(308);
                AtObject(ai[0], ai[1]);
                Wait(100);
            }
            if (InvCount() == 30)
             {
              Walk(502,455);
              Wait(100);
              Walk(501,451);
              Wait(100);
             if (QuestMenu() == false && Running() == true && InvCount() == 30)
                               {
                                 int BankerID = GetNearestNPC(95);
                                 TalkToNPC(BankerID);
                                 Wait(2000);
                               }
                                 
                                   

                   while (Bank() == false && Running() == true)
                               {
                                   Answer(0);
                                   Wait(100);
                               }


                   while (Bank() == true && Running() == true)
                               {
                   while(InvCount(663) > 0)
                               {
                                Deposit(663,1);
                                Wait(100);
                               }

                                CloseBank();
                               
                               }
              if (InvCount(663) == 0)
                {
                 Walk(504,455);
                 Wait(100);
                 Walk(506,451);
                 Wait(100);
                }
             }

           
           
       
    }
    DisplayMessage("@red@Maple Shortbow fletcher + bank STOPPED", 3);
}
}