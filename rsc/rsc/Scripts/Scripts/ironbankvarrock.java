public class ironbankvarrock extends Script
{
    public long StartTime = System.currentTimeMillis();
    public int Trips = 0;
    public int RockCount = 0;
    public ironbankvarrock(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"minetheiron"};
    }
    public void start(String command, String parameter[])
    {
        DisplayMessage("@cya@Mod Mark says:I've notice you are using the auto miner", 3);
        DisplayMessage("@blu@Whoodiestyle's iron miner", 3);
        while(Running())
        {   
            DoMining();
            Wait(500);
            GoToBank();
            Wait(500);
            DoBanking();
            Wait(500);
            GoToRocks();
            Wait(500);
            Trips++;
            if(Trips == 2)
            {
                ProgressRepert();
                Trips = 0;
            }

        }
        DisplayMessage("@ora@Stopped", 3);
    }

//MINING PROCEDURE
    public void DoMining()
    {
        DisplayMessage("@blu@whoodiestyle's miner: @ora@Mining iron...", 3);
        while(InvCount() < 30)
        {
            if (Fatigue() >= 95 && Running() == true)
            {
                while (Sleeping() == false)
                {
                    Use(FindInv(1263));
                    Wait(2500);
                }
                while (Sleeping() == true)
                {
                    Wait(500);
                    Beep();
                }
            }
            if (ObjectAt(75,543) == 102 && Running() == true) AtObject(75,543);
            if (ObjectAt(76,543) == 102 && Running() == true) AtObject(76,543);
            if (ObjectAt(76,544) == 102 && Running() == true) AtObject(76,544);                   
            Wait(1000);
        }
    }
//WALK TO BANK
    public void GoToBank()
    {
        DisplayMessage("@blu@whoodiestyle's miner @ora@Walking to Bank...", 3);
         Walk(74,538);
         Wait(100);
         Walk(78,524);
         Wait(100);
         Walk(84,511);
         Wait(100);
         Walk(100,507);
         Wait(100);
         Walk(98,515);
         Wait(100);
   
    }
//BANKING PROCEDURE
    public void DoBanking()
    {
        DisplayMessage("@blu@whoodiestyle's miner @ora@Banking...", 3);
        while (QuestMenu() == false)
        {
           int BankerID = GetNearestNPC(95);
           TalkToNPC(BankerID);
           Wait(2000);
        }
        Answer(0);
        while (Bank() == false)
        Wait(10);
        while (InvCount(151) > 0)
        {
           Deposit(151,1);
           Wait(100);
        }
        while (InvCount(151) > 0)
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
    }
//WALK TO IRON ROCKS
    public void GoToRocks()
    {
        DisplayMessage("@blu@whoodiestyle's Miner: @ora@Walking to the rocks...", 3);
         Walk(100,508);
         Wait(100);
         Walk(87,509);
         Wait(100);
         Walk(80,523);
         Wait(100);
         Walk(75,533);
         Wait(100);
         Walk(75,541);
         Wait(100);
    }
    public void ServerMessage(String message)
    {
         if (message.equals("@gam@You manage to obtain some iron ore")) RockCount++;
    }
    public void ProgressRepert()
    {
         long TotalTime = System.currentTimeMillis() - StartTime;
         long MinsWorked = TotalTime / 60000L;
         int XPGain = RockCount * (35/2);
         Println("PROGRESS REPORT:");
         Println("Working for "+ MinsWorked + " minutes");
         Println("Mined a total of "+ RockCount + " iron ores");
         Println("Gained "+ XPGain +" mining experience");
    }
}