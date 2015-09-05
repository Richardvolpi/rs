public class Deeiron extends Script
{
    public long StartTime = System.currentTimeMillis();
    public int Trips = 0;
    public int RockCount = 0;
    public Deeiron(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"deeiron"};
    }
    public void start(String command, String parameter[])
    {
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Dee's iron miner@ran@=@ran@.@ran@=@ran@.@ran@=", 3);
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
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Stopped@ran@=@ran@.@ran@=@ran@.@ran@=", 3);
    }

//MINING PROCEDURE
    public void DoMining()
    {
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Dee's miner: @gre@Mining iron...", 3);
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
            if (ObjectAt(318,640) == 102 && Running() == true) AtObject(318,640);
            if (ObjectAt(318,642) == 102 && Running() == true) AtObject(318,642);
            if (ObjectAt(318,640) == 102 && Running() == true) AtObject(318,640);
            if (ObjectAt(318,642) == 102 && Running() == true) AtObject(318,642);           
            Wait(200);
        }
    }
//WALK TO BANK
    public void GoToBank()
    {
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Dee's miner @gre@Walking to Bank...", 3);
        while(GetX() != 312 && GetY() != 628) Walk(312,628);
        Wait(100);
        while(GetX() != 311 && GetY() != 619) Walk(311,619);
        Wait(100);
        while(GetX() != 309 && GetY() != 613) Walk(309,613);
        Wait(100);
        while(GetX() != 307 && GetY() != 605) Walk(307,605);
        Wait(100);
        while(GetX() != 303 && GetY() != 598) Walk(303,598);
        Wait(100);
        while(GetX() != 298 && GetY() != 589) Walk(298,589);
        Wait(100);
        while(GetX() != 292 && GetY() != 582) Walk(292,582);
        Wait(100);
        while(GetX() != 290 && GetY() != 573) Walk(290,573);
        Wait(100);
        while(GetX() != 287 && GetY() != 572) Walk(287,572);
        Wait(100);
        while(GetX() != 284 && GetY() != 569) Walk(284,569);
        Wait(1000);
    }
//BANKING PROCEDURE
    public void DoBanking()
    {
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Dee's miner @gre@Banking...", 3);
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
    }
//WALK TO IRON ROCKS
    public void GoToRocks()
    {
        DisplayMessage("@ran@=@ran@.@ran@=@ran@.@ran@=@ora@Dee's Miner: @gre@Walking to rocks...", 3);
        while(GetX() != 284 && GetY() != 569) Walk(284,569);
        Wait(100);
        while(GetX() != 287 && GetY() != 572) Walk(287,572);
        Wait(100);
        while(GetX() != 290 && GetY() != 573) Walk(290,573);
        Wait(100);
        while(GetX() != 292 && GetY() != 582) Walk(292,582);
        Wait(100);
        while(GetX() != 298 && GetY() != 589) Walk(298,589);
        Wait(100);
        while(GetX() != 303 && GetY() != 598) Walk(303,598);
        Wait(100);
        while(GetX() != 307 && GetY() != 605) Walk(307,605);
        Wait(100);
        while(GetX() != 309 && GetY() != 613) Walk(309,613);
        Wait(100);
        while(GetX() != 311 && GetY() != 619) Walk(311,619);
        Wait(100);
        while(GetX() != 312 && GetY() != 628) Walk(312,628);
        Wait(1000);
    }
    public void ServerMessage(String message)
    {
         if (message.equals("@gam@You manage to obtain some iron ore")) RockCount++;
    }
    public void ProgressRepert()
    {
         long TotalTime = System.currentTimeMillis() - StartTime;
         long MinsWorked = TotalTime / 60000L;
         int XPGain = RockCount * 35;
         Println("PROGRESS REPORT:");
         Println("Working for "+ MinsWorked + " minutes");
         Println("Mined a total of "+ RockCount + " iron ores");
         Println("Gained "+ XPGain +" mining experience");
    }
} 