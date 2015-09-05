public class EdgeLimps extends Methods
{
    public EdgeLimps(mudclient mc){super(mc);}
    public int foodid;
    public int foodcount;
    public int fmode;
    public int identifies;
    public String FoodId;
    public String FoodCount;
    public String Fmode;
    public String Identifies;
    public void Main(String Args[])
    {
    FoodId = GetInput("Please type in Food Id");
    FoodCount = GetInput("How much food shall i take?");
    Fmode = GetInput("Please type in your Fight Mode");
    Identifies = GetInput("Shall i identify before i bank?(0 = no, 1 = yes)");
    foodid = Integer.parseInt(FoodId);
    foodcount = Integer.parseInt(FoodCount);
    fmode = Integer.parseInt(Fmode);
    identifies = Integer.parseInt(Identifies);
    int[] UnidedHerbs = {436,437,438,439,440,441,442,443,469,42,33,40,220,46};
    int[] IdedHerbs = {444,445,446,447,448,449,450,451,452,453};
    int[] Npcs = {61,67,68};
    LockMode(fmode);
    AutoLogin(true);
    while(Running())
        {
            while((CountInv(foodid) != foodcount || CountInv() != 6 + foodcount))
            {
            while(!QuestMenu())
                {
                int[] Npc = GetNpcById(95);
                if(Npc[0] != -1 && !QuestMenu())
                    {
                    Wait(500);
                    TalkToNpc(Npc[0]);
                    Wait(Rand(1300,2200));
                    }
                }
            if(QuestMenu())
                {
                Answer(0);
                }
            while(InBank() == false)
                {
                Wait(10);
                }
            while(InBank() == true && (CountInv() != 6 + foodcount || CountInv(foodid) != foodcount || CountInv(1263) != 1))
                {
                if(CountInv(46) > 0)
                    {
                    Deposit(46,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(40) > 0)
                    {
                    Deposit(40,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(220) > 0)
                    {
                    Deposit(220,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(42) > 0)
                    {
                    Deposit(42,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(33) > 0)
                    {
                    Deposit(33,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(436) > 0)
                    {
                    Deposit(436,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(437) > 0)
                    {
                    Deposit(437,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(438) > 0)
                    {
                    Deposit(438,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(439) > 0)
                    {
                    Deposit(439,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(440) > 0)
                    {
                    Deposit(440,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(441) > 0)
                    {
                    Deposit(441,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(442) > 0)
                    {
                    Deposit(442,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(443) > 0)
                    {
                    Deposit(443,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(444) > 0)
                    {
                    Deposit(444,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(445) > 0)
                    {
                    Deposit(445,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(446) > 0)
                    {
                    Deposit(446,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(447) > 0)
                    {
                    Deposit(447,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(448) > 0)
                    {
                    Deposit(448,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(449) > 0)
                    {
                    Deposit(449,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(450) > 0)
                    {
                    Deposit(450,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(451) > 0)
                    {
                    Deposit(451,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(452) > 0)
                    {
                    Deposit(452,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(453) > 0)
                    {
                    Deposit(453,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(444) > 0)
                    {
                    Deposit(444,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(445) > 0)
                    {
                    Deposit(445,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(446) > 0)
                    {
                    Deposit(446,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(447) > 0)
                    {
                    Deposit(447,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(448) > 0)
                    {
                    Deposit(448,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(449) > 0)
                    {
                    Deposit(449,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(450) > 0)
                    {
                    Deposit(450,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(451) > 0)
                    {
                    Deposit(451,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(452) > 0)
                    {
                    Deposit(452,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(453) > 0)
                    {
                    Deposit(453,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(469) > 0)
                    {
                    Deposit(469,1);
                    Wait(Rand(200,300));
                    }else
                if(CountInv(foodid) < foodcount)
                    {
                    Withdraw(foodid,1);
                    Wait(500);
                    }else
                if(CountInv(foodid) > foodcount)
                    {
                    Deposit(foodid,1);
                    Wait(1200);
                    }else
                if(CountInv(1263) < 1)
                    {
                    Withdraw(1263,1);
                    Wait(2000);
                    }
                }
            }
        WalkToWait(217,459);
        WalkToWait(216,468);
        while(GetX() != 216 && GetY() != 468)
            {
            WalkTo(216,468);
            Wait(500);
            }
        while(GetY() < 3298)
            {
            Wait(500);
            AtObject(215,468);
            Wait(3000);
            }
        WalkToWait(216,3280);
        while(!IsReachable(204,3273))
            {
            int[] Gate0 = GetObjectById(57);
            AtObject(Gate0[1],Gate0[2]);
            Wait(1000);
            }
        WalkToWait(204,3273);
        WalkToWait(196,3274);
        WalkToWait(184,3277);
        WalkToWait(179,3288);
        WalkToWait(179,3298);
        WalkToWait(185,3300);
        while(!IsReachable(186,3300))
            {
            int[] Gate1 = GetObjectById(57);
            AtObject(Gate1[1],Gate1[2]);
            Wait(1000);
            }
        WalkToWait(195,3299);
        WalkToWait(206,3300);
        WalkToWait(207,3309);
        WalkToWait(208,3317);
        while(CountInv() != 30 && CountInv(foodid) > 0)
            {
            if(GetFatigue() < 90 && GetMaxLvl(3) - GetCurLvl(3) < 14 && !IsReachable(120,648))
                {
                int[] Herb = GetItemById(UnidedHerbs);
                int[] NonPC = GetNpcById(Npcs);
                int[] TheGate = GetObjectById(57);
                if(TheGate[0] != -1)
                    {
                    AtObject(TheGate[1],TheGate[2]);
                    Wait(1000);
                    }
                if(Herb[0] != -1 && !InCombat() && IsReachable(Herb[1],Herb[2]) && Herb[1] > 185 && Herb[2] >= 3293)
                    {
                    PickupItem(Herb[1],Herb[2],Herb[0]);
                    Wait(200);
                    }
                else
                if(NonPC[0] != -1 && !InCombat() && NonPC[1] > 185 && NonPC[2] >= 3293 && IsReachable(NonPC[1],NonPC[2]))
                    {
                    AttackNpc(NonPC[0]);
                    Wait(1200);
                    }
                else
                if(InCombat())
                    {
                    Wait(50);
                    }
                else { Wait(10); }
                }
            if(GetMaxLvl(3) - GetCurLvl(3) > 14 && Running() && CountInv(foodid) > 0 && !InCombat())
                {
                           Display("Eating Pls?");
                           Wait(10);
                           UseItem(GetItemPos(foodid));
                           Wait(3000);
                }
            else
            if(GetFatigue() >= 90 && Running() && !InCombat())
                {
                while(!Sleeping() && Running())
                    {
                    WalkToWait(197,3259);
                    UseItem(GetItemPos(1263));
                    Wait(2000);
                    }
                while(Sleeping() && Running())
                    Wait(1000);
                }
            else
            if(InCombat()) { Wait(10); }
            }
        while(GetY() > 3318)
            {
            WalkTo(208,3318);
            Wait(1200);
            }
        while(!IsReachable(208,3317))
            {
            int[] Gate2 = GetObjectById(57);
            AtObject(Gate2[1],Gate2[2]);
            Wait(1000);
            }
        while(GetY() > 3307)
            {
            WalkTo(208,3307);
            Wait(1200);
            }
        while(GetY() > 3301)
            {
            WalkTo(208,3301);
            Wait(1200);
            }
        WalkToWait(199,3298);
        WalkToWait(189,3301);
        WalkToWait(186,3301);
        while(!IsReachable(185,3300))
            {
            int[] Gate1 = GetObjectById(57);
            AtObject(Gate1[1],Gate1[2]);
            Wait(1000);
            }
        WalkToWait(179,3300);
        WalkToWait(180,3292);
        WalkToWait(187,3284);
        WalkToWait(192,3275);
        WalkToWait(201,3273);
        WalkToWait(210,3273);
        while(!IsReachable(211,3272))
            {
            int[] Gate0 = GetObjectById(57);
            AtObject(Gate0[1],Gate0[2]);
            Wait(1000);
            }
        WalkToWait(217,3278);
        WalkToWait(216,3291);
        WalkToWait(215,3299);
        while(GetX() != 215 && GetY() != 3299)
            {
            WalkTo(215,3299);
            Wait(500);
            }
        while(GetY() > 500)
            {
            Wait(500);
            AtObject(215,3300);
            Wait(3000);
            }
        while((GetX() != 216 || GetY() != 450)) { WalkTo(216,450); Wait(1100); }
        if(identifies != 0)
            {
            while(CountInv(436) > 0 && GetMaxLvl(15) >= 10 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(436));
                Wait(500);
                }
            while(CountInv(437) > 0 && GetMaxLvl(15) >= 20 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(437));
                Wait(500);
                }
            while(CountInv(438) > 0 && GetMaxLvl(15) >= 25 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(438));
                Wait(500);
                }
            while(CountInv(439) > 0 && GetMaxLvl(15) >= 40 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(439));
                Wait(500);
                }
            while(CountInv(440) > 0 && GetMaxLvl(15) >= 48 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(440));
                Wait(500);
                }
            while(CountInv(441) > 0 && GetMaxLvl(15) >= 54 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(441));
                Wait(500);
                }
            while(CountInv(442) > 0 && GetMaxLvl(15) >= 65 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(442));
                Wait(500);
                }
            while(CountInv(443) > 0 && GetMaxLvl(15) >= 70 && GetFatigue() < 90)
                {
                UseItem(GetItemPos(443));
                Wait(500);
                }
            if(GetFatigue() >= 90 && Running())
                {
                while(!Sleeping() && Running())
                    {
                    UseItem(GetItemPos(1263));
                    Wait(2000);
                    }
                while(Sleeping() && Running())
                    Wait(1000);
                }
            }
    }
        End();
    }

    public void OnChatMessage(String sender, String message)
    {
    }

    public void OnServerMessage(String message)
    {
    }
}