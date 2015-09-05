public class SteelSmelter extends Script
{
    public SteelSmelter(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"smeltsteel"};
    }
    public void start(String command, String parameter[])

    {
        DisplayMessage("@gre@SBoT: @whi@Steel Smelter - @ran@Vegunks",3);
        while (Running() == true)
        {
       
        //Banking

        while (QuestMenu() == false && Running() == true)
        {
            int BankerID = GetNearestNPC(268);
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
            while(InvCount(171) > 0)
            {
                Deposit(171,1);
                Wait(100);
            }

            while(InvCount(151) < 9)
            {
                Withdraw(151,1);
                Wait(1000);
            }
   
            while(InvCount(151) > 9)
            {
                Deposit(151,1);   
                Wait(1000);
            }

            while(InvCount(155) < 18)
            {
                Withdraw(155,1);
                Wait(1000);
            }
            CloseBank();
       
        }
 


        //Walking To Furnace


        Walk(85,695);
        Wait(50);
        Walk(83,688);
        Wait(50);
        Walk(81,683);
        Wait(50);
        Walk(81,679);
        Wait(50);
        Walk(82,679);
        Wait(1000);

        //Smelting
   while (Running() == true && InvCount(171) < 9)
        {
            //Smelting Part
            UseOnObject(85, 679, FindInv(155));
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
        //Walk to Bank

        Walk(82,679);
        Wait(50);
        Walk(81,679);
        Wait(50);
        Walk(81,683);
        Wait(50);
        Walk(83,688);
        Wait(50);
        Walk(85,695);
        Wait(50);
        Walk(88,695);
        Wait(1000);


        }
        DisplayMessage("@red@STOPPED", 3);
    }
} 