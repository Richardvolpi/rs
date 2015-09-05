public class Bronzesmelt extends Script
{
   public Bronzesmelt(mudclient rs)
   {
             super(rs);
}
   
   public String[] getCommands()
   {
   return new String[]{"Bronze"};
    }
   public void start(String command, String parameter[])
{
        DisplayMessage("Bronze Smither Edited By C4ught_y0u - Thanks Vegunks",3);
        while (Running() == true)
        {
       
        //Banking

        while (QuestMenu() == false && Running() == true)
        {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(2000);
        }

        Answer(0);

        while (Bank() == false && Running() == true)
        {
            Wait(1000);
   }


        while (Bank() == true && Running() == true)
        {
            while(InvCount(169) > 0)
            {
                Deposit(169,1);
                Wait(1500);
            }

            while(InvCount(202) < 13)
            {
                Withdraw(202,1);
                Wait(1500);
            }
   
            while(InvCount(202) > 13)
            {
                Deposit(202,1);   
                Wait(1500);
            }

            while(InvCount(150) < 13)
            {
                Withdraw(150,1);
                Wait(1500);
            }
            CloseBank();
       
        }
//walk to furnace
   Walk(326,549);
        Wait(100);
        Walk(324,545);
        Wait(100);
        Walk(323,541);
        Wait(100);
        Walk(317,542);
        Wait(100);
        Walk(312,544);
        Wait(100);
        Walk(310,545);
        Wait(1000);

//smelting
while (Running() == true && InvCount(169) < 12)
        {
            UseOnObject(310, 546, FindInv(150));
            Wait(2500);

            //Check for Sleep
            if(Fatigue() > 97 && Running() == true)
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
//Bank

        Walk(314,542);
        Wait(50);
        Walk(322,540);
        Wait(50);
        Walk(324,547);
        Wait(50);
        Walk(327,552);
        Wait(50);
        Walk(330,552);
        Wait(1000);


        }
        DisplayMessage("@ran@Finished", 3);
    }
} 