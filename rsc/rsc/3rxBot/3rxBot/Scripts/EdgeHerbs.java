public class EdgeHerbs extends Methods
{
    public EdgeHerbs(mudclient mc){super(mc);}
    public int foodid;
    public int foodcount;
    public int fmode;
    public int where;
    public int identifies;
    public int displaywhere;
    public String FoodId;
    public String FoodCount;
    public String Fmode;
    public String Where;
    public String Identifies;

    public void Main(String Args[])
    {
    FoodId = GetInput("Please type in Food Id");
    FoodCount = GetInput("How much food shall i take?");
    Fmode = GetInput("Please type in your Fight Mode");
    Where = GetInput("Where shud i auto?(0 = Thugs, 1 = Chaos Druids)");
    Identifies = GetInput("Shall i identify before i bank?(0 = no, 1 = yes)");
    foodid = Integer.parseInt(FoodId);
    foodcount = Integer.parseInt(FoodCount);
    fmode = Integer.parseInt(Fmode);
    where = Integer.parseInt(Where);
    identifies = Integer.parseInt(Identifies);
    int[] UnidedHerbs = {436,437,438,439,440,441,442,443,469,42,33};
    int[] IdedHerbs = {444,445,446,447,448,449,450,451,452,453};
    LockMode(fmode);
    AutoLogin(true);
    Display("EdgeVille wild Herbs by @cya@OMFG");
    Display("Food ID: " + foodid + ", Food Count: " + foodcount + ", FightMode: " + fmode + ", Picking At: " + where + ", Identify: " + identifies + ".");
    while(Running())
        {
        while((CountInv(foodid) != foodcount || CountInv() != 4 + foodcount))
            {
            while(!QuestMenu())
                {
                int[] Npc = GetNpcById(95);
                if(Npc[0] != -1 && !QuestMenu())
                    {
                    Wait(500);
                    TalkToNpc(Npc[0]);
                    Wait(4000);
                    }
                }
            Wait(100);
            if(QuestMenu())
                {
                Answer(0);
                }
            while(InBank() == false)
                {
                Wait(10);
                }
            while(InBank() == true && (CountInv() != 4 + foodcount || CountInv(foodid) != foodcount || CountInv(1263) != 1))
                {
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
        WalkToWait(204,3273);
        WalkToWait(197,3266);
        while(GetX() != 197 && GetY() != 3266)
            {
            WalkTo(197,3266);
            Wait(500);
            }
        while(GetY() > 3265)
            {
            int[] Gate = GetObjectById(305);
            if(Gate[0] != -1) { AtObject(Gate[1],Gate[2]); }
            Wait(3000);
            }
        if(where == 0)
            {
            WalkToWait(198,3259);
            }
        if(where == 1)
            {
            WalkToWait(201,3254);
            WalkToWait(210,3254);
            WalkToWait(213,3246);
            }
        while(CountInv() != 30 && CountInv(foodid) > 0)
            {
            if(where == 0)
                {
                if(GetFatigue() < 90 && GetMaxLvl(3) - GetCurLvl(3) < 14 && !IsReachable(120,648))
                    {
                    int[] Herb = GetItemById(UnidedHerbs);
                    int[] Thug = GetNpcById(251);
                    if(Herb[0] != -1 && !InCombat() && IsReachable(Herb[1],Herb[2]) && Herb[2] > 3240)
                        {
                        PickupItem(Herb[1],Herb[2],Herb[0]);
                        Wait(200);
                        }
                    else
                    if(Thug[0] != -1 && !InCombat())
                        {
                        AttackNpc(Thug[0]);
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
                if(GetFatigue() >= 90 && Running())
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
                }
            if(where == 1 && !IsReachable(120,648))
                {
                if(GetFatigue() < 90 && GetMaxLvl(3) - GetCurLvl(3) < 14)
                    {
                    int[] Herb = GetItemById(UnidedHerbs);
                    int[] Thug = GetNpcById(270);
                    if(Herb[0] != -1 && !InCombat() && IsReachable(Herb[1],Herb[2]) && Herb[2] > 3240)
                        {
                        PickupItem(Herb[1],Herb[2],Herb[0]);
                        Wait(200);
                        }
                    else
                    if(Thug[0] != -1 && !InCombat())
                        {
                        AttackNpc(Thug[0]);
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
                if(GetFatigue() >= 90 && Running())
                    {
                    WalkToWait(214,3257);
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
        Wait(3000);
        if(!IsReachable(130,640))
            {
            if(where == 0 && !IsReachable(130,640))
                {
                while((GetX() != 197 || GetY() != 3259) && !IsReachable(130,640)) { WalkTo(197,3259); Wait(1100); }
                }
            if(where == 1 && !IsReachable(130,640))
                {
                while((GetX() != 210 || GetY() != 3254) && !IsReachable(130,640)) { WalkTo(210,3254); Wait(1100); }
                while((GetX() != 201 || GetY() != 3254) && !IsReachable(130,640)) { WalkTo(201,3254); Wait(1100); }
                while((GetX() != 197 || GetY() != 3259) && !IsReachable(130,640)) { WalkTo(197,3259); Wait(1100); }
                }
            WalkToWait(197,3265);
            while(GetX() != 197 && GetY() != 3265 && !IsReachable(130,640))
                {
                WalkTo(197,3265);
                Wait(500);
                }
            while(GetY() < 3266 && !IsReachable(130,640))
                {
                int[] Gate = GetObjectById(305);
                if(Gate[0] != -1) { AtObject(Gate[1],Gate[2]); }
                Wait(3000);
                }
            Wait(1000);
            WalkToWait(203,3273);
            WalkToWait(215,3274);
            WalkToWait(216,3286);
            WalkToWait(215,3296);
            WalkToWait(216,3300);
            while(GetX() != 216 && GetY() != 3300 && !IsReachable(130,640))
                {
                WalkTo(216,3300);
                Wait(500);
                }
            while(GetY() > 468 && !IsReachable(130,640))
                {
                Wait(500);
                AtObject(215,3300);
                Wait(3000);
                }
            WalkToWait(216,450);
            }
        if(IsReachable(130,640))
            {
            while((GetX() != 121 || GetY() != 646)) { WalkTo(121,646); Wait(1100); }
            while((GetX() != 128 || GetY() != 641)) { WalkTo(128,641); Wait(1100); }
            while((GetX() != 135 || GetY() != 631)) { WalkTo(135,631); Wait(1100); }
            while((GetX() != 135 || GetY() != 621)) { WalkTo(135,621); Wait(1100); }
            while((GetX() != 142 || GetY() != 617)) { WalkTo(142,617); Wait(1100); }
            while((GetX() != 151 || GetY() != 615)) { WalkTo(151,615); Wait(1100); }
            while((GetX() != 156 || GetY() != 607)) { WalkTo(156,607); Wait(1100); }
            while((GetX() != 157 || GetY() != 599)) { WalkTo(157,599); Wait(1100); }
            while((GetX() != 163 || GetY() != 595)) { WalkTo(163,595); Wait(1100); }
            while((GetX() != 174 || GetY() != 594)) { WalkTo(174,594); Wait(1100); }
            while((GetX() != 178 || GetY() != 585)) { WalkTo(178,585); Wait(1100); }
            while((GetX() != 183 || GetY() != 579)) { WalkTo(183,579); Wait(1100); }
            while((GetX() != 184 || GetY() != 572)) { WalkTo(184,572); Wait(1100); }
            while((GetX() != 188 || GetY() != 564)) { WalkTo(188,564); Wait(1100); }
            while((GetX() != 192 || GetY() != 552)) { WalkTo(192,552); Wait(1100); }
            while((GetX() != 196 || GetY() != 542)) { WalkTo(196,542); Wait(1100); }
            while((GetX() != 203 || GetY() != 524)) { WalkTo(203,524); Wait(1100); }
            while((GetX() != 212 || GetY() != 525)) { WalkTo(212,525); Wait(1100); }
            while((GetX() != 215 || GetY() != 517)) { WalkTo(215,517); Wait(1100); }
            while((GetX() != 215 || GetY() != 504)) { WalkTo(215,504); Wait(1100); }
            while((GetX() != 216 || GetY() != 493)) { WalkTo(216,493); Wait(1100); }
            while((GetX() != 217 || GetY() != 483)) { WalkTo(217,483); Wait(1100); }
            while((GetX() != 221 || GetY() != 474)) { WalkTo(221,474); Wait(1100); }
            while((GetX() != 224 || GetY() != 469)) { WalkTo(224,469); Wait(1100); }
            while((GetX() != 223 || GetY() != 458)) { WalkTo(223,458); Wait(1100); }
            while((GetX() != 221 || GetY() != 447)) { WalkTo(221,447); Wait(1100); }
            while((GetX() != 216 || GetY() != 450)) { WalkTo(216,450); Wait(1100); }
            }
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