// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 08/10/2004 7:35:49 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   UberThiev0r.java


public class ManThiever extends Script
{

    public ManThiever(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "thievemen"
        });
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@red@ManThiever started", 3);
        do
        {
            if(!Running())
                break;
            if(Fatigue() >= 95 && Running())
            {
                for(; !Sleeping() && Running(); Wait(2500))
                    Use(FindInv(1263));

                for(; Sleeping() && Running(); Wait(100));
            }
            for(; GetCurrentStat(3) < 55; Wait(2500))
            {
                int i = FindInv(330);
                Use(i);
            }
            if(GetFightMode() != 3)
            SetFightMode(3);
            if(!InCombat())
            {
                int j = GetNearestNPC(11);
                ThieveNPC(j);
                Wait(700);
            }
            if(InCombat() && Running())
            {
                WalkNoWait(GetX(),GetY());
                Wait(700);
            }

        } while(true);
        DisplayMessage("@red@ManThiever STOPPED", 3);
    }
}