// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 9/17/04 9:30:44 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   LobFishSell.java


public class LobFishSell extends Script
{

    public LobFishSell(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "selllobs"
        });
    }

    public void start(String s, String as[])
    {
        while(Running()) 
        {
            while(Running() && InvCount() < 30) 
            {
                if(Fatigue() >= 80 && Running())
                {
                    for(; !Sleeping(); Wait(2500))
                        Use(FindInv(1263));

                    for(; Sleeping(); Wait(100));
                }
                AtObject2(368, 684);
                Wait(500);
            }
            Wait(100);
            Walk(371, 684);
            Walk(371, 687);
            Walk(371, 692);
            Walk(371, 695);
            Walk(371, 699);
            Walk(371, 704);
            Walk(368, 707);
            Walk(365, 710);
            Walk(361, 711);
            Wait(200);
            OpenDoor(361, 712, 0);
            Wait(10);
            Walk(361, 712);
            if(InvCount(372) > 0 || InvCount(245) > 0 || InvCount(158) > 0 || InvCount(159) > 0 || InvCount(160) > 0)
            {
                while(!QuestMenu()) 
                {
                    long l = System.currentTimeMillis();
                    int i = GetNearestNPC(168);
                    TalkToNPC(i);
                    Wait(1000);
                    for(; System.currentTimeMillis() - l <= 7000L && !QuestMenu(); Wait(200));
                }
                Answer(0);
                Wait(200);
                for(; InvCount(372) > 0; Wait(10))
                    Sell(372);

                Walk(361, 712);
                Wait(200);
                OpenDoor(361, 712, 0);
                Wait(10);
                Walk(361, 710);
                Walk(366, 710);
                Walk(367, 708);
                Walk(368, 705);
                Walk(370, 701);
                Walk(370, 697);
                Walk(370, 693);
                Walk(369, 689);
                Walk(369, 685);
            }
        }
    }
}