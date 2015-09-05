/*

Falador steel smither by - Unknown Idiot.
Start at Falador furnace
You need 10 iron and 20 coal in your backpack
Script withdraws sleeping bag and sleeps when needed
Thanks again to Bruncle for Path walking procedure.

*/

public class SteelSmelter extends Script
{
    public long StartTime = System.currentTimeMillis();
    public int Trips = 0;
    public int SteelCount = 0;
    public int Path[][];
    public SteelSmelter(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"steelsm"};
    }
    public void start(String command, String parameter[])
    {
        DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@Falador Steel Smelter By Unknown Idiot started@ran@:@ran@=@ran@=@ran@-", 3);
        Path = new int[][]{{329,321,314,312,311},{553,552,550,544,544}};
        while(Running())
        {   
            if(Running())DoSmelting();
            Wait(500);
            if(Running())WalkPath(Path, 1, "To Bank");
            Wait(500);
            if(Running())DoBanking();
            Wait(500);
            if(Running())WalkPath(Path, 0, "To Furnace");
            Wait(500);
            Trips++;
            if(Trips == 2)
            {
                ProgressReport();
                Trips = 0;
            }
        }
        DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@Falador Steel Smelter By Unknown Idiot stopped@ran@:@ran@=@ran@=@ran@-", 3);
    }

//SMELTING PROCEDURE
    public void DoSmelting()
    {
        DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@UI Smelter: @gre@Smelting...", 3);
        while(InvCount(155) > 0 && Running())
        {
            UseOnObject(310, 546,FindInv(155));
            Wait(2600);
        }
    }

//BANKING PROCEDURE
    public void DoBanking()
    {
        DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@UI Smelter: @gre@Banking...", 3);
        while (QuestMenu() == false)
        {
           int BankerID = GetNearestNPC(95);
           TalkToNPC(BankerID);
           WaitForQuestMenu(4000);
        }
        Answer(0);
        Wait(200);
        for (int i = 0; i < 500; i++)
        {
            Wait(10);
            if(Bank())i = 501;
        }
        Wait(200);
        if(Fatigue() >= 95)
        {
            Withdraw(1263,1);
            Wait(500);
            for (int i = 0; i < 500; i++)
            {
                Use(FindInv(1263));
                Wait(10);
                if(Sleeping())i = 501;
            }
            while (Sleeping()) Wait(500);
            Wait(100); DoBanking();
        }
        DepositTillEmpty(1263); Wait(100);
        WithDrawAmount(155,20); Wait(100);
        DepositTillEmpty(171); Wait(100);
        WithDrawAmount(151,10); Wait(400);
        if(InvCount(171) > 0) DoBanking();
    }

//Walking Procedure Developed by Bruncle
    public void WalkPath(int walkPath[][],int direction, String DebugMsg)
    {
        DisplayMessage("@ran@-@ran@=@ran@=@ran@:@ora@UI Smelter: @gre@Going via path: @cya@"+DebugMsg, 3);
        if (direction == 0)
        {
            for (int i = 0; i < walkPath[0].length; i++)
            {
                Walk(walkPath[0][i],walkPath[1][i]);
            }
        }
        if (direction == 1 && Running())
        {
            for (int j = 0; j < walkPath[0].length; j++)
            {
                try
                {
                    Walk(walkPath[0][(walkPath[0].length) - (j+1)],walkPath[1][(walkPath[0].length) - (j+1)]);
                }
                catch(Exception e){
       System.out.println("Exception: "+e);
  }
            
            }
        }
    }
//Wait For Quest Menu, TimeOut = Milliseconds.
    public void WaitForQuestMenu(int TimeOut)
    {
        for (int i = 0; i < TimeOut / 10; i++)
        {
            Wait(10);
            if(QuestMenu()) i = TimeOut;
        }
    }

    public void WithDrawAmount(int ItemID, int Amount)
    {
        for(int i = 0; i < Amount; i++)
        {
            Withdraw(ItemID,1);
            Wait(100);
        }
    }

//Deposit Till Empty Void
    public void DepositTillEmpty(int ItemID)
    {
        while (InvCount(ItemID) > 0 && Bank())
        {
            Deposit(ItemID,1);
            Wait(100);
        }
    }
//Progress Report
    public void ServerMessage(String message)
    {
         if (message.equals("@gam@You retrieve a bar of steel")) SteelCount++;
    }
    public void ProgressReport()
    {
         long TotalTime = System.currentTimeMillis() - StartTime;
         long MinsWorked = TotalTime / 60000L;
         double XPGain = SteelCount * 17.5;
         System.out.println("PROGRESS REPORT:");
         System.out.println("Working for "+ MinsWorked + " minutes");
         System.out.println("Smelted a total of "+ SteelCount + " Steel bars");
         System.out.println("Gained "+ (int)XPGain +" mining experience");
    }
}

