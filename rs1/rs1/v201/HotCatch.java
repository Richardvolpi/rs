// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HotCatch.java


public class HotCatch extends Script
{

    public HotCatch(mudclient mudclient)
    {
        super(mudclient);
        Attacking = false;
        SPray = false;
        APray = false;
        PPray = false;
        PlayerID = 0;
        Mode = 1;
    }

    public String[] getCommands()
    {
        return (new String[] {
            "cc"
        });
    }

    public void KeyReleased(int i)
    {
        if(i == 1010)
            Attacking = false;
    }

    public void KeyPressed(int i)
    {
        if(i == 1000 && !InCombat())
            if(InvCount(224) < 1)
            {
                if(InvCount(223) < 1)
                {
                    if(InvCount(222) < 1)
                    {
                        if(InvCount(221) < 1)
                        {
                            DisplayMessage("@Dre@No more potion left!!", 3);
                        } else
                        {
                            DisplayMessage("@Dre@Drank a dose, 3 doses remaining", 3);
                            Use(FindInv(221));
                            Wait(50);
                        }
                    } else
                    {
                        DisplayMessage("@Dre@Drank a dose, 2 doses remaining", 3);
                        Use(FindInv(222));
                        Wait(50);
                    }
                } else
                {
                    DisplayMessage("@Dre@Drank a dose, 1 dose remaining", 3);
                    Use(FindInv(223));
                    Wait(50);
                }
            } else
            {
                DisplayMessage("@Dre@Drank last dose", 3);
                Use(FindInv(224));
                Drop(0);
                Wait(0);
            }
        if(i == 1010 && !InCombat())
        {
            Attacking = true;
            DisplayMessage("@Dre@Attacking", 3);
            SetFightMode(Mode);
            AttackPlayer(PlayerID);
            AcceptTrade();
            ForceWalkNoWait(666, 666);
            TradePlayer(PlayerID);
            TakeItem(0, 1, 1);
            Use(5);
            Wait(0);
        }
        if(i == 1012)
            if(InvCount(370) < 99)
            {
                if(InvCount(373) > 10)
                {
                    DisplayMessage("@Dre@Eat A Lobster " + InvCount(373) + " Lobsters left", 3);
                    Use(FindInv(373));
                    Wait(0);
                } else
                {
                    DisplayMessage("@Dre@No more lobsters or swordfish!!!", 3);
                }
            } else
            {
                DisplayMessage("@Dre@Eat A SwordFish: " + InvCount(370) + " Swordfish left", 3);
                Use(FindInv(370));
                Wait(0);
            }
        if(i == 1015 && GetStat(5) >= 25)
            if(!PPray)
            {
                PPray = true;
                DisplayMessage("@Dre@Protect Items On", 3);
            } else
            if(PPray)
            {
                PPray = false;
                PrayerOff(8);
                DisplayMessage("@Dre@Protect Items Off", 3);
            }
        if(i == 1013 && GetStat(5) >= 4)
        {
            if(!SPray)
            {
                SPray = true;
                if(GetStat(5) >= 31)
                    PrayerOn(10);
                if(GetStat(5) >= 13 && GetStat(5) < 31)
                    PrayerOn(4);
                if(GetStat(5) >= 4 && GetStat(5) < 13)
                    PrayerOn(1);
                DisplayMessage("@Dre@Strength Prayer On", 3);
            } else
            if(SPray)
            {
                DisplayMessage("@Dre@Strength Prayer Off", 3);
                SPray = false;
            }
            Wait(50);
        }
        if(i == 1014 && GetStat(5) >= 7)
        {
            if(!APray)
            {
                APray = true;
                if(GetStat(5) >= 34)
                    PrayerOn(11);
                if(GetStat(5) >= 16 && GetStat(5) < 34)
                    PrayerOn(5);
                if(GetStat(5) >= 7 && GetStat(5) < 16)
                    PrayerOn(2);
                DisplayMessage("@Dre@Attack Prayer On", 3);
            } else
            if(APray)
            {
                PrayerOff(11);
                PrayerOff(5);
                PrayerOff(2);
                DisplayMessage("@Dre@Attack Prayer Off", 3);
                APray = false;
            }
            Wait(50);
        }
        if(i == 1011)
        {
            Mode++;
            if(Mode == 4)
            {
                Mode = 0;
                DisplayMessage("@Dre@Controlled", 3);
                SetFightMode(Mode);
            }
            if(Mode == 1)
            {
                DisplayMessage("@Dre@Agressive", 3);
                SetFightMode(Mode);
            }
            if(Mode == 2)
            {
                DisplayMessage("@Dre@Accurate", 3);
                SetFightMode(Mode);
            }
            if(Mode == 3)
            {
                DisplayMessage("@Dre@Defensive", 3);
                SetFightMode(Mode);
            }
        }
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@bla@HotCatcher ", 3);
        DisplayMessage("@gre@By: Davis Zanot", 3);
        PrayerOff(11);
        PrayerOff(10);
        PrayerOff(8);
        PrayerOff(5);
        PrayerOff(4);
        PrayerOff(2);
        PrayerOff(1);
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        PlayerID = Integer.parseInt(as[0]);
        while(Running()) 
        {
            SetFightMode(Mode);
            for(; !InCombat() && Running() && !Attacking; Wait(1))
            {
                ForceWalkNoWait(PlayerDestX(PlayerID), PlayerDestY(PlayerID));
                AcceptTrade();
                ForceWalkNoWait(666, 666);
                TradePlayer(PlayerID);
                TakeItem(0, 1, 1);
                SetFightMode(Mode);
            }

            for(; InCombat() && Running(); Wait(1))
                if(GetFightMode() != Mode)
                    SetFightMode(Mode);

            while(!InCombat() && Running() && Attacking) 
                Wait(0);
        }
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        SetFightMode(Mode);
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        SetFightMode(Mode);
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        SetFightMode(Mode);
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        SetFightMode(Mode);
        AcceptTrade();
        ForceWalkNoWait(666, 666);
        TradePlayer(PlayerID);
        TakeItem(0, 1, 1);
        SetFightMode(Mode);
        DisplayMessage("@red@STOPPED", 3);
    }

    public boolean Attacking;
    public boolean SPray;
    public boolean APray;
    public boolean PPray;
    public int PlayerID;
    public int Mode;
}
