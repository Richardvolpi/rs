// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 9/2/04 11:17:37 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Herber.java


public class Herber extends Script
{

    public Herber(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "herbmeup"
        });
    }

    public void start(String s, String as[])
    {
        if(as.length != 1)
        {
            DisplayMessage(" @whi@ Bruncle:Bad syntax fool: it's /RUN herbmeup StYLe ", 3);
        } else
        {
            int i = Integer.parseInt(as[0]);
            int j = 700;
            char c = '\u010E';
            int ai[] = {
                270
            };
            CheckFighters(true);
            DisplayMessage("@gre@Bruncle: @whi@Herb Collector Started", 3);
            do
            {
                if(!Running() || GetCurrentStat(3) <= 5)
                    break;
                if(GetFightMode() != i)
                {
                    SetFightMode(i);
                    DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(), 3);
                }
                if(!InCombat())
                    if(Fatigue() > 97 && !Sleeping())
                    {
                        DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                        Use(FindInv(1263));
                        Wait(5000);
                    } else
                    if(!Sleeping())
                    {
                        int k = GetNearestNPC(c);
                        if(k != -1)
                        {
                            long l = System.currentTimeMillis();
                            AttackNPC(k);
                            while(System.currentTimeMillis() - l <= (long)j && !InCombat() && Running()) 
                                Wait(1);
                        } else
                        {
                            do
                            {
                                if(Sleeping() || InCombat() || k != -1)
                                    break;
                                k = GetNearestNPC(c);
                                do
                                {
                                    if(k != -1 || !Running())
                                        break;
                                    int ai1[] = GetNearestItem(165);
                                    if(ai1[0] != -1 && ai1[1] != -1 && Running())
                                    {
                                        TakeItem(ai1[0], ai1[1], 165);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai2[] = GetNearestItem(435);
                                    if(ai2[0] != -1 && ai2[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai2[0], ai2[1], 435);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai3[] = GetNearestItem(436);
                                    if(ai3[0] != -1 && ai3[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai3[0], ai3[1], 436);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai4[] = GetNearestItem(437);
                                    if(ai4[0] != -1 && ai4[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai4[0], ai4[1], 437);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai5[] = GetNearestItem(438);
                                    if(ai5[0] != -1 && ai5[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai5[0], ai5[1], 438);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai6[] = GetNearestItem(439);
                                    if(ai6[0] != -1 && ai6[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai6[0], ai6[1], 439);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai7[] = GetNearestItem(440);
                                    if(ai7[0] != -1 && ai7[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai7[0], ai7[1], 440);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai8[] = GetNearestItem(441);
                                    if(ai8[0] != -1 && ai8[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai8[0], ai8[1], 441);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai9[] = GetNearestItem(442);
                                    if(ai9[0] != -1 && ai9[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai9[0], ai9[1], 442);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai10[] = GetNearestItem(443);
                                    if(ai10[0] != -1 && ai10[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai10[0], ai10[1], 443);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai11[] = GetNearestItem(815);
                                    if(ai11[0] != -1 && ai11[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai11[0], ai11[1], 815);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai12[] = GetNearestItem(817);
                                    if(ai12[0] != -1 && ai12[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai12[0], ai12[1], 817);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai13[] = GetNearestItem(819);
                                    if(ai13[0] != -1 && ai13[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai13[0], ai13[1], 819);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai14[] = GetNearestItem(821);
                                    if(ai14[0] != -1 && ai14[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai14[0], ai14[1], 821);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai15[] = GetNearestItem(823);
                                    if(ai15[0] != -1 && ai15[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai15[0], ai15[1], 823);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai16[] = GetNearestItem(933);
                                    if(ai16[0] != -1 && ai16[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai16[0], ai16[1], 933);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai17[] = GetNearestItem(42);
                                    if(ai17[0] != -1 && ai17[1] != -1 && Running())
                                    {
                                        TakeItem(ai17[0], ai17[1], 42);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                    int ai18[] = GetNearestItem(33);
                                    if(ai18[0] != -1 && ai18[1] != -1 && Running() && k == -1)
                                    {
                                        TakeItem(ai18[0], ai18[1], 33);
                                        Wait(150);
                                        k = GetNearestNPC(c);
                                    }
                                } while(true);
                                if(InvCount() == 30)
                                    WalkAndBank();
                            } while(true);
                        }
                    }
            } while(true);
        }
    }

    public void WalkAndBank()
    {
        OpenDoor(617, 556, 0);
        Wait(1000);
        Walk(609, 569);
        Walk(612, 590);
        Walk(593, 603);
        Walk(593, 588);
        Walk(581, 572);
        Walk(580, 573);
        Wait(2000);
        for(; !QuestMenu(); Wait(100))
        {
            int i = GetNearestNPC(95);
            TalkToNPC(i);
        }

        Answer(0);
        for(; !Bank(); Wait(100));
        for(; Bank(); CloseBank())
        {
            for(; InvCount(165) > 0; Wait(200))
                Deposit(165, 1);

            for(; InvCount(435) > 0; Wait(200))
                Deposit(435, 1);

            for(; InvCount(436) > 0; Wait(200))
                Deposit(436, 1);

            for(; InvCount(437) > 0; Wait(200))
                Deposit(437, 1);

            for(; InvCount(438) > 0; Wait(200))
                Deposit(438, 1);

            for(; InvCount(439) > 0; Wait(200))
                Deposit(439, 1);

            for(; InvCount(440) > 0; Wait(200))
                Deposit(440, 1);

            for(; InvCount(441) > 0; Wait(200))
                Deposit(441, 1);

            for(; InvCount(442) > 0; Wait(200))
                Deposit(442, 1);

            for(; InvCount(443) > 0; Wait(200))
                Deposit(443, 1);

            for(; InvCount(815) > 0; Wait(200))
                Deposit(815, 1);

            for(; InvCount(817) > 0; Wait(200))
                Deposit(817, 1);

            for(; InvCount(819) > 0; Wait(200))
                Deposit(819, 1);

            for(; InvCount(821) > 0; Wait(200))
                Deposit(821, 1);

            for(; InvCount(823) > 0; Wait(200))
                Deposit(823, 1);

            for(; InvCount(933) > 0; Wait(200))
                Deposit(933, 1);

            for(; InvCount(42) > 0; Wait(200))
                Deposit(42, 1);

            for(; InvCount(33) > 0; Wait(200))
                Deposit(33, 1);

        }

        Walk(587, 587);
        Walk(591, 603);
        Walk(607, 594);
        Walk(609, 568);
        Walk(617, 556);
        for(; DoorAt(617, 556, 0) == 96; Wait(1000))
            CloseDoor(617, 556, 0);

    }
}