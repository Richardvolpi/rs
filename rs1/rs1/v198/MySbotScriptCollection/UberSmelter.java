//version 3.3.2b
public class UberSmelter extends Script {
    public UberSmelter(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"ubersmelt"};
    }
    public void SmeltSteel() {
        while (InvCount(151) > 0 && InvCount(155) > 0) {
            UseOnObject(310, 546, FindInv(155));
            Wait(2500);            
        }
    }
    public void BankForSteel(int PickAxe) {
        while (!Bank() && Running()) {
            while (!QuestMenu() && Running()) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu() && Running())
                    Wait(1);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && !Bank() && Running())
                Wait(1);
        }
        Deposit(PickAxe, 1);
        while (InvCount(157) > 0) {
            Deposit(157,1);
            Wait(100);
        }
        while (InvCount(158) > 0) {
            Deposit(158,1);
            Wait(100);
        }
        while (InvCount(159) > 0) {
            Deposit(159,1);
            Wait(100);
        }
        while (InvCount(160) > 0) {
            Deposit(160,1);
            Wait(100);
        }
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
        Withdraw(151, 1);
    }
    public void BankToFurnace() {
        if (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        Walk(286,571);
        Walk(287,572);
        Walk(290,561);
        Walk(293,553);
        Walk(299,547);
        if (ObjectAt(306,544) == 2) {
            OpenDoor(306,544,1);
            Wait(200);
        }
        ForceWalkNoWait(307,545);
    }
    public void BankWalk() {
        Walk(274,3397);
        AtObject(274,3398);
        Walk(274,563);
        while (ObjectAt(274, 563) == 2) {
            OpenDoor(274, 563, 0);
            Wait(300);
        }
        Walk(274,562);
        Walk(287,571);
        if (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        ForceWalkNoWait(286,571);
    }
    public void RimmingtonToBank() {
        Walk(312,628,250);
        Walk(311,619,250);
        Walk(309,613,250);
        Walk(307,605,250);
        Walk(303,598,250);
        Walk(298,589,250);
        Walk(292,582,250);
        Walk(290,573,250);
        Walk(287,572,250);
        if (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        ForceWalkNoWait(284,569);
    }
    public void Mine20Coal() {
        while (Running() && InvCount(155) < 20) {
            int FindCoal[] = GetNearestObject(110);
            AtObject(FindCoal[0],FindCoal[1]);
            Wait(1000);
        }
    }
    public void GuildWalk() {
        Walk(286,571);
        if (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        Walk(287,571);
        Walk(274,562);
        while (ObjectAt(274, 563) == 2) {
            OpenDoor(274, 563, 0);
            Wait(300);
        }
        Walk(274,563);
        AtObject(274,566);
    }
    public void SmeltIron() {
        while (InvCount(151) > 0) {
            UseOnObject(310, 546, FindInv(151));
            Wait(2500);
        }
    }
    public void BankSteelBars(int FatLVL, int PickAxe) {
        while (!Bank() && Running()) {
            while (!QuestMenu() && Running()) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu() && Running())
                    Wait(1);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && !Bank() && Running())
                Wait(1);
        }
        while (InvCount(171) > 0) {
            Deposit(171,1);
            Wait(100);
        }
        Withdraw(PickAxe,1);
        if (Fatigue() > FatLVL) {
            Withdraw(1263,1);
            Wait(100);
        }
        CloseBank();
    }
    public void BankBars(int FatLVL, int BarID) {
        while (!Bank() && Running()) {
            while (!QuestMenu() && Running()) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu() && Running())
                    Wait(1);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && !Bank() && Running())
                Wait(1);
        }
        while (InvCount(BarID) > 0) {
            Deposit(BarID,1);
            Wait(100);
        }
        while (InvCount(157) > 0) {
            Deposit(157,1);
            Wait(100);
        }
        while (InvCount(158) > 0) {
            Deposit(158,1);
            Wait(100);
        }
        while (InvCount(159) > 0) {
            Deposit(159,1);
            Wait(100);
        }
        while (InvCount(160) > 0) {
            Deposit(160,1);
            Wait(100);
        }
        if (Fatigue() > FatLVL) {
            Withdraw(1263,1);
            Wait(100);
        }
        CloseBank();
    }
    public void BankBag() {
        if (InvCount(1263) > 0) {
            while (!Bank() && Running()) {
                while (!QuestMenu() && Running()) {
                    int BankerID = GetNearestNPC(95);
                    TalkToNPC(BankerID);
                    long Time = System.currentTimeMillis();
                    while (System.currentTimeMillis() - Time <= 2000 && !QuestMenu() && Running())
                        Wait(1);
                }
                Answer(0);
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 5000 && !Bank() && Running())
                    Wait(1);
            }
            while (InvCount(1263) > 0) {
                Deposit(1263,1);
                Wait(100);
            }
            CloseBank();
        }
    }
    public void SmeltBronze() {
        while (InvCount(150) > 0 && InvCount(202) > 0) {
            UseOnObject(310, 546, FindInv(150));
            Wait(2500);
        }
    }
    public void MineBronze() {
        while(InvCount(202) < 14 && Running() == true) {
            int TinCoords[] = GetNearestObject(104);
            if (TinCoords[0] != -1 && TinCoords[1] != -1) {
                AtObject(TinCoords[0],TinCoords[1]);
            }
            if (InvCount(157) > 0) {
                Drop(FindInv(157));
                Wait(100);
            }
            if (InvCount(158) > 0) {
                Drop(FindInv(158));
                Wait(100);
            }
            if (InvCount(159) > 0) {
                Drop(FindInv(159));
                Wait(100);
            }
            if (InvCount(160) > 0) {
                Drop(FindInv(160));
                Wait(100);
            }
            Wait(2500);
        }
        while(InvCount(150) < 14 && Running() == true) {
            int CopperCoords[] = GetNearestObject(100);
            if (CopperCoords[0] != -1 && CopperCoords[1] != -1) {
                AtObject(CopperCoords[0],CopperCoords[1]);
            }
            if (InvCount(157) > 0) {
                Drop(FindInv(157));
                Wait(100);
            }
            if (InvCount(158) > 0) {
                Drop(FindInv(158));
                Wait(100);
            }
            if (InvCount(159) > 0) {
                Drop(FindInv(159));
                Wait(100);
            }
            if (InvCount(160) > 0) {
                Drop(FindInv(160));
                Wait(100);
            }
            Wait(2500);
        }
    }
    public void RimmingtonToFurnace() {
        Walk(312,628,250);
        Walk(311,619,250);
        Walk(309,613,250);
        Walk(307,605,250);
        Walk(303,598,250);
        Walk(298,589,250);
        Walk(292,582,250);
        Walk(290,573,250);
        Walk(291,564,250);
        Walk(293,556,250);
        Walk(299,551,250);
        Walk(303,544,250);
        Walk(309,542,250);
        while (ObjectAt(309,543) == 2) {
            OpenDoor(309,543,0);
            Wait(200);
            WalkNoWait(307, 545);
        }
        Walk(307,545,250);
    }
    public void FurnaceToBank() {
        while (ObjectAt(309,543) == 2) {
            OpenDoor(309,543,0);
            Wait(200);
        }
        Walk(307,545,250);
        Walk(299,547,250);
        Walk(293,553,250);
        Walk(290,561,250);
        Walk(287,572,250);
        while (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        ForceWalkNoWait(286,571);
    }
    public void BankToRimmington() {
        Walk(286,571,250);
        while (ObjectAt(287,571) == 64) {
            AtObject(287,571);
            Wait(300);
        }
        Walk(287,572,250);
        Walk(291,581,250);
        Walk(297,588,250);
        Walk(304,591,250);
        Walk(305,599,250);
        Walk(307,606,250);
        Walk(303,614,250);
        Walk(301,622,250);
        Walk(307,628,250);
        Walk(309,636,250);
        Walk(317,641,250);
    }
    public void MineRimmingtonIron() {
        int IronLoc[] = GetNearestObject(102);
        if (IronLoc[1] < 643 && IronLoc[1] != -1 && IronLoc[0] != -1) {
            AtObject(IronLoc[0],IronLoc[1]);
            Wait(1000);
        }
    }
    public void SleepIfOver(int FatLVL) {
        if (Fatigue() > FatLVL && Running()) {
            while (!Sleeping() && Running()) {
                Use(FindInv(1263));
                Wait(2000);
            }
            while (Sleeping() && Running()) {
                System.out.print("\007"); System.out.flush();
                Wait(700);
            }
        }
    }
    public void start(String command, String parameter[]) {
        int SteelBarCount = 0;
        int CoalCount = 0;
        int OreCount = 0;
        int BronzeOreCount = 0;
        int BarCount = 0;
        int IronOreCount = 0;
        int BronzeBarCount = 0;
        int DiamondCount = 0;
        int RubyCount = 0;
        int EmeraldCount = 0;
        int SapphireCount = 0;
        int TripCount = 0;
        int SleepCount = 0;
        int FatigueSum = 0;
        int FatigueStart = 0;
        int FatigueDifference = 0;
        int FatLVL = 0;
        int PickAxe = Integer.parseInt(parameter[0]);
        int SmithingEXP = 0;
        int MiningEXP = 0;
        int MiningEXPStart = GetExperience(14);
        int SmithingEXPStart = GetExperience(13);
        int MiningEXPCurrent = 0;
        int SmithingEXPCurrent = 0;
        int MiningEXPGained = 0;
        int SmithingEXPGained = 0;
        DisplayMessage("@bla@Super Smelter",3);
        DisplayMessage("@gre@By: Davis Zanot",3);
        while (Running()) {
            while (GetStat(14) < 15 || GetStat(13) < 15 && Running()) {
                FatigueStart = Fatigue();
                MineBronze();
                BronzeOreCount = InvCount(150) + InvCount(202)+ BronzeOreCount;
                MiningEXPCurrent = GetExperience(14);
                MiningEXP = MiningEXPCurrent - MiningEXPStart;
                if (Running())
                    RimmingtonToFurnace();
                if (Running())
                    SmeltBronze();
                BronzeBarCount = InvCount(169) + BronzeBarCount;
                SmithingEXPCurrent = GetStat(13);
                SmithingEXP = SmithingEXPCurrent - SmithingEXPStart;
                if (Running())
                    FurnaceToBank();
                FatigueDifference = Fatigue() - FatigueStart;
                FatigueSum = FatigueSum + FatigueDifference;
                TripCount = TripCount + 1;
                DiamondCount = InvCount(157) + DiamondCount;
                RubyCount = InvCount(158) + RubyCount;
                EmeraldCount = InvCount(159) + EmeraldCount;
                SapphireCount = InvCount(160) + SapphireCount;
                FatLVL = 93 - (FatigueSum / TripCount);
                BankBars(FatLVL,169);
                SleepIfOver(FatLVL);
                SleepCount = InvCount(1263) + SleepCount;
                BankBag();
                System.out.println("===========================================================");
                System.out.println("                    Trip #" +TripCount);
                System.out.println("===========================================================");
                System.out.println("Bronze Ores Mined: " +BronzeOreCount);
                System.out.println("Bronze Bars Smelted: " +BronzeBarCount);
                System.out.println("Times Slept: " +SleepCount);
                System.out.println("Mining Experience Gained " +MiningEXP);
                System.out.println("Smithing Experience Gained " +SmithingEXP);
                System.out.println("Average Fatigue Per Trip: " +FatigueSum / TripCount);
                BankToRimmington();
            }
            while (GetStat(14) >= 15 && GetStat(13) >= 15 && Running() && GetStat(13) < 30) {
                FatigueStart = Fatigue();
                while (InvCount() < 30 && Running()) {
                    MineRimmingtonIron();
                }
                OreCount = InvCount(151) + OreCount;
                MiningEXPCurrent = GetExperience(14);
                MiningEXP = MiningEXPCurrent - MiningEXPStart;
                if (Running())
                    RimmingtonToFurnace();
                if (Running())
                    SmeltIron();
                BarCount = InvCount(170) + BarCount;
                SmithingEXPCurrent = GetStat(13);
                SmithingEXP = SmithingEXPCurrent - SmithingEXPStart;
                if (Running())
                    FurnaceToBank();
                FatigueDifference = Fatigue() - FatigueStart;
                FatigueSum = FatigueSum + FatigueDifference;
                TripCount = TripCount + 1;
                DiamondCount = InvCount(157) + DiamondCount;
                RubyCount = InvCount(158) + RubyCount;
                EmeraldCount = InvCount(159) + EmeraldCount;
                SapphireCount = InvCount(160) + SapphireCount;
                FatLVL = 93 - (FatigueSum / TripCount);
                BankBars(FatLVL,170);
                SleepIfOver(FatLVL);
                SleepCount = InvCount(1263) + SleepCount;
                BankBag();
                System.out.println("===========================================================");
                System.out.println("                    Trip #" +TripCount);
                System.out.println("===========================================================");
                System.out.println("Ores Mined: " +OreCount);
                System.out.println("Bars Smelted: " +BarCount);
                System.out.println("Diamonds Banked: " +DiamondCount);
                System.out.println("Rubys Banked: " +RubyCount);
                System.out.println("Emeralds Banked: " +EmeraldCount);
                System.out.println("Saphires Banked: " +SapphireCount);
                System.out.println("Times Slept: " +SleepCount);
                System.out.println("Mining Experience Gained " +MiningEXP);
                System.out.println("Smithing Experience Gained " +SmithingEXP);
                System.out.println("Success Rate: " +100 * BarCount / OreCount+ "%");
                System.out.println("Average Fatigue Per Trip: " +FatigueSum / TripCount);
                BankToRimmington();
            }
            while (GetStat(13) >= 30 && GetStat(14) >= 60 && Running()) {
                FatigueStart = Fatigue();
                while (InvCount(151) < 10 && Running()) {
                    MineRimmingtonIron();
                }
                OreCount = InvCount(151) + OreCount;
                MiningEXPCurrent = GetExperience(13);
                MiningEXP = MiningEXPCurrent - MiningEXPStart;
                if (Running())
                    RimmingtonToBank();
                if (Running())
                    DiamondCount = InvCount(157) + DiamondCount;
                RubyCount = InvCount(158) + RubyCount;
                EmeraldCount = InvCount(159) + EmeraldCount;
                SapphireCount = InvCount(160) + SapphireCount;
                BankBars(0,151);
                SleepIfOver(FatLVL);
                SleepCount = InvCount(1263) + SleepCount;
                BankBag();
                GuildWalk();
                if (Running())
                    Mine20Coal();
                CoalCount = InvCount(155) + CoalCount;
                if (Running())
                    BankWalk();
                TripCount = TripCount + 1;
                if (Running()) {
                    DiamondCount = InvCount(157) + DiamondCount;
                    RubyCount = InvCount(158) + RubyCount;
                    EmeraldCount = InvCount(159) + EmeraldCount;
                    SapphireCount = InvCount(160) + SapphireCount;
                    BankForSteel(PickAxe);
                }
                if (Running()) {
                    BankToFurnace();
                }
                if (Running())
                    SmeltSteel();
                if (Running())
                    FurnaceToBank();
                MiningEXPCurrent = GetExperience(14);
                MiningEXP = MiningEXPCurrent - MiningEXPStart;
                SmithingEXPCurrent = GetStat(13);
                SmithingEXP = SmithingEXPCurrent - SmithingEXPStart;
                SteelBarCount = InvCount(171) + SteelBarCount;
                if (Running()) {
                    FatigueDifference = Fatigue() - FatigueStart;
                    FatigueSum = FatigueSum + FatigueDifference;
                    FatLVL = 93 - (FatigueSum / TripCount);
                    BankSteelBars(FatLVL,PickAxe);
                }
                SleepIfOver(FatLVL);
                SleepCount = InvCount(1263) + SleepCount;
                BankBag();
                System.out.println("===========================================================");
                System.out.println("                    Trip #" +TripCount);
                System.out.println("===========================================================");
                System.out.println("Iron Ores Mined: " +OreCount);
                System.out.println("Coal Mined: " +CoalCount);
                System.out.println("Steel Bars Smelted: " +SteelBarCount);
                System.out.println("Diamonds Banked: " +DiamondCount);
                System.out.println("Rubys Banked: " +RubyCount);
                System.out.println("Emeralds Banked: " +EmeraldCount);
                System.out.println("Saphires Banked: " +SapphireCount);
                System.out.println("Times Slept: " +SleepCount);
                System.out.println("Mining Experience Gained " +MiningEXP);
                System.out.println("Smithing Experience Gained " +SmithingEXP);
                System.out.println("Average Fatigue Per Trip: " +FatigueSum / TripCount);
                if (Running())
                    BankToRimmington();
            }
        }
        DisplayMessage("@red@STOPPED", 3);
    }
}