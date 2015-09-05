// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 9/17/04 9:38:42 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PlateSmither.java


public class PlateSmither extends Script
{

    public PlateSmither(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "smithplates"
        });
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Steel Plate Smither Activated! @ran@=@ran@=@ran@=@ran@=@ran@=", 3);
        DisplayMessage("@ran@=@ran@=@ran@=@ran@=@ran@= @whi@Created by SaladFork! @ran@=@ran@=@ran@=@ran@=@ran@=", 3);
        for(; !QuestMenu(); Wait(1000))
        {
            int i = GetNearestNPC(95);
            TalkToNPC(i);
        }

        Answer(0);
        for(; !Bank(); Wait(1));
        while(Running()) 
        {
            for(; InvCount() < 30; Wait(100))
                Withdraw(171, 1);

            CloseBank();
            Walk(102, 508);
            Walk(108, 511);
            Walk(108, 517);
            Walk(105, 519);
            for(; Running() && InvCount(171) > 5; Wait(2000))
            {
                if(Fatigue() >= 95 && Running())
                {
                    for(; !Sleeping(); Wait(2500))
                        Use(FindInv(1263));

                    for(; Sleeping(); Wait(100));
                }
                UseOnObject(105, 518, FindInv(171));
                for(; !QuestMenu(); Wait(10));
                Answer(1);
                Wait(1000);
                for(; !QuestMenu(); Wait(10));
                Answer(2);
                Wait(1000);
                for(; !QuestMenu(); Wait(10));
                Answer(1);
            }

            Walk(105, 519);
            Walk(108, 517);
            Walk(108, 511);
            Walk(102, 508);
            Walk(102, 511);
            for(; !QuestMenu(); Wait(1000))
            {
                int j = GetNearestNPC(95);
                TalkToNPC(j);
            }

            Answer(0);
            for(; !Bank(); Wait(1));
            while(InvCount(118) > 0) 
            {
                Deposit(118, 1);
                Wait(100);
            }
        }
        DisplayMessage("@red@STOPPED", 3);
    }
}