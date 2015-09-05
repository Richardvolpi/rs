public class smelt extends Script

{
    public smelt (mudclient rs)
    {
        super(rs);
       
    }

    public String[] getCommands()
    {
        return new String[]{"smelt"};
    }
public void start(String command, String parameter[])

    {
        DisplayMessage("@cya@Mod Mark has been added to your friends list.", 3);       
        DisplayMessage("@cya@Mod Mark says: Hi, I am currently checking for autoers, please respond.", 3);
        DisplayMessage("@cya@You tell Mod Mark: Fauck you", 3);
    while(Running() == true)
    {
   while(Bank() == false) {
            //Talk To Banker
            while(!QuestMenu())
            {
                long l = System.currentTimeMillis();
                int bankerID = GetNearestNPC(268);
                TalkToNPC(bankerID);
                while(System.currentTimeMillis() - l <= 2000L && !QuestMenu())
                Wait(1000);
            }
           
            Answer(0);
            Wait(5000);
         }

            while(InvCount(171) > 0)
            {
                Deposit(171,1);
                Wait(100);
            }
 
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                Withdraw(155,1);
                Withdraw(155,1);
                Withdraw(151,1);
                 
               
        CloseBank();
 
                 Walk(84, 690);
                 Walk(82, 683);
                 Walk(84, 681);
         while (InvCount(155) > 0 && Running() == true)
        {
            UseOnObject(85, 679,FindInv(155));
            Wait(2600);
                if (Fatigue() > 98 && Running() == true)
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
        }
                 Walk(84, 690);
                 Walk(82, 683);
                 Walk(84, 681);
    }
    DisplayMessage("@red@STOPPED", 3);
    }
}
