public class steelplate extends Script
{   
public steelplate(mudclient rs)
    {
        super(rs);

    }
    public String[] getCommands()
    {
        return new String[]{"dstplate"};

    }
    public void start(String command, String parameter[])

    {
    DisplayMessage("@ora@steel plate smither@ran@-By zues", 3);
    while (Running() == true)
    {
    Walk(150,503);
    Wait(100);

    while (QuestMenu() == false && Running() == true)
        {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(2000);
        }

        Answer(0);

        while (Bank() == false && Running() == true)
        {
            Wait(50);
        }


        while (Bank() == true && Running() == true)
        {
            while(InvCount(118) > 0)
            {
                Deposit(118,5);
                Wait(100);
            }

            while(InvCount(171) < 25)
            {
                Withdraw(171,1);
                Wait(100);
            }

            CloseBank();
        }
       Walk(150,503);
            Wait(100);
            Walk(150,507);
             Wait(100);
              Walk(148,512);
       Wait(100);
            while (Running() == true && InvCount(118) < 5)
            {
         UseOnObject(148,513,5);
    Wait(1000);

    for(; !QuestMenu(); Wait(10));
         Answer(1);
         for(; !QuestMenu(); Wait(10));
         Answer(2);
         for(; !QuestMenu(); Wait(10));
         Answer(1);
         Wait(1000);
         }
         
     if(Fatigue() > 90 && Running() == true)
            {
                while (Sleeping() == false)
                {
                    Use(FindInv(1263));
                    Wait(3000);
                }

                while (Sleeping() == true)
                {
                    Wait(200);
 
         
               }
           }   
      }

DisplayMessage("@red@STOPPED", 3);
}
} 