public class DrayNetBank extends Script {
    
    private int fish_anch = 0;
    private int fish_shrimp = 0;
    private long start_time;
    private int start_anch;
    private int start_shrimp;
    private long start_fishxp;
    private long start_cookxp;
    private long start_woodcutxp;
    private long start_firemakexp;
    private int burnt_fish = 0;
    private int start_fishlvl;
    private int start_cooklvl;
    private int start_woodcutlvl;
    private int start_firemakelvl;
    private int bank_anch = 0;
    private int bank_shrimp = 0;
    private int bank_times = 0;
    private int slept = 0;
    private int raw_shrimpid = 349;
    private int shrimpid = 350;
    private int raw_anchid = 351;
    private int anchid = 352;
    private int burntfishid = 353;
    private int fishspotid = 193;
    private int fireid = 97;
    private int sleepbagid = 1263;
    private int tinderboxid = 166;
    private int netid = 376;
    
    public DrayNetBank(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"draynetbank"};
    }
    public void start(String command, String parameter[]) {
        Msg("Draynor Powerfish+Cook+Bank script, by @ran@eXemplar");
        
        if (ObjectAt(221,664) != fishspotid) {
            Msg("You must start near Draynor fishing spots!");
            return;
        }
        
        if (FindInv(sleepbagid) < 0) {
            Msg("You must have a sleeping bag in your inv!");
            return;
        }
        if (FindInv(tinderboxid) < 0) {
            Msg("You must have a tinderbox in your inv!");
            return;
        }
        if (FindInv(netid) < 0) {
            Msg("You must have a net in your inv!");
            return;
        }
        
        Msg("Make sure you have an axe in your inv.");
        
        start_time = TickCount();
        start_anch = 0;
        start_shrimp = 0;
        if (InvCount(raw_anchid) > 0)
            start_anch = start_anch + InvCount(raw_anchid);
        if (InvCount(anchid) > 0)
            start_anch = start_anch + InvCount(anchid);
        if (InvCount(raw_shrimpid) > 0)
            start_shrimp = start_shrimp + InvCount(raw_shrimpid);
        if (InvCount(shrimpid) > 0)
            start_shrimp = start_shrimp + InvCount(shrimpid);
        
        start_fishxp = GetExperience(10);
        start_cookxp = GetExperience(7);
        start_woodcutxp = GetExperience(8);
        start_firemakexp = GetExperience(11);
        
        start_fishlvl = GetStat(10);
        start_cooklvl = GetStat(7);
        start_woodcutlvl = GetStat(8);
        start_firemakelvl = GetStat(11);
        
        PrintStats(1);
        
        while(Running() == true) {
            
            while(InvCount() < 30 && Running()) {
                int rand = Rand(1,3);
                int pinv = InvCount();
                Msg("Fishing at spot " + rand);
                while(pinv == InvCount() && Running()) {
                    switch(rand) {
                        case 1:
                            AtObject(224,659);
                            break;
                        case 2:
                            AtObject(224,661);
                            break;
                        case 3:
                            AtObject(221,664);
                            break;
                        default:
                            AtObject(224,659);
                            break;
                    }
                    Wait(1000);
                    CheckSleep();
                    CheckCombat();
                }
                Wait(1000);
            }
            Msg("Inventory full");
            
            if (InvCount(raw_shrimpid) > 0)
                fish_shrimp = fish_shrimp + InvCount(raw_shrimpid) - start_shrimp;
            if (InvCount(raw_anchid) > 0)
                fish_anch = fish_anch + InvCount(raw_anchid) - start_anch;
            
            while((InvCount(raw_shrimpid) > 0 || InvCount(raw_anchid) > 0) && Running()) {
                // while we have raw fish in inv
                
                CheckCombat();
                
                // if there is a fire, and it is withing about 1 map square away
                if (GetNearestObject(fireid)[0] > 0 && Distance(GetNearestObject(fireid)[0],GetNearestObject(fireid)[1]) < 12) {
                    
                    Msg("Found a fire, not woodcutting+firemaking");
                    CookFish();
                    
                } else {
                    // otherwise, try and make a fire
                    
                    // while it can't find a fire or a tree, wait
                    while((GetNearestObject(1)[0] < 0 && GetNearestObject(fireid)[0] < 0) && Running())
                        Wait(100);
                    
                    // while we can't find a tree, go and cut one
                    while(GetNearestObject(fireid)[0] < 0 && Running()) {
                        
                        Msg("Moving near trees...");
                        WalkRan(216,658);
                        Msg("Cutting tree...");
                        int tree[] = GetNearestObject(1);
                        //while the tree is there and we can't find a fire, cut tree
                        while(ObjectAt(tree[0],tree[1]) == 1 && Running() && GetNearestObject(fireid)[0] < 0) {
                            CheckCombat();
                            AtObject(tree);
                            long Time = TickCount();
                            while (ObjectAt(tree[0],tree[1]) == 1 && TickCount() - Time <= 2000 && Running() && GetNearestObject(fireid)[0] < 0)
                                Wait(100);
                        }
                        
                        // if we can find a fire, cook fishes
                        if (GetNearestObject(fireid)[0] > 0) {
                            
                            CheckCombat();
                            CookFish();
                            
                        } else {
                            // there must be no fire, so try and light logs until a fire appears
                            
                            Msg("Lighting fire...");
                            while((ObjectAt(GetX(),GetY()) != fireid && GetNearestObject(fireid)[0] < 0) && Running() ) {
                                CheckCombat();
                                UseOnItem(GetX(),GetY(),14,FindInv(tinderboxid));
                                long Time = TickCount();
                                while ((ObjectAt(GetX(),GetY()) != fireid && GetNearestObject(fireid)[0] < 0) && TickCount() - Time <= 2000 && Running())
                                    Wait(100);
                                Wait(500);
                            }
                            
                        }
                        
                    }
                    
                    // assume it'll only get this far if it finds a fire
                    
                    CheckCombat();
                    CookFish();
                    
                }
            }
            
            if (InvCount(burntfishid) > 0)  {
                Msg("Dropping burnt fishies...");
                int finv = InvCount();
                burnt_fish = burnt_fish + InvCount(burntfishid);
                while(InvCount(burntfishid) > 0 && Running()) {
                    int pinv = InvCount();
                    while(pinv == InvCount() && Running()) {
                        Drop(FindInv(burntfishid));
                        long Time = TickCount();
                        while (pinv == InvCount() && TickCount() - Time <= 3000 && Running())
                            Wait(100);
                        Wait(500);
                    }
                    Wait(500);
                }
            }
            
            Msg("Walking to bank...");
            WalkRan(219,647);
            WalkRan(215,645);
            WalkRan(212,631);
            while(!CanReach(220,635) && Running()) {
                AtObject(219,633);
                Wait(500);
            }
            WalkRan(220,635);
            Msg("Banking fishies...");
            if (InvCount(anchid) > 0)
                bank_anch = bank_anch + InvCount(anchid);
            if (InvCount(shrimpid) > 0)
                bank_shrimp = bank_shrimp + InvCount(shrimpid);
            DoBank(shrimpid,anchid,1);
            bank_times++;
            start_anch = 0;
            start_shrimp = 0;
            Msg("Walking back...");
            while(!CanReach(212,631) && Running()) {
                AtObject(219,633);
                Wait(500);
            }
            WalkRan(212,631);
            WalkRan(215,645);
            WalkRan(219,647);
            WalkRan(221,656);
            WalkRan(218,659);
            PrintStats(0);
        }
        Msg("@red@Stopped Draynor Powerfisher.");
    }
    private void CookFish() {
        Msg("Cooking fishies...");
        while((InvCount(raw_shrimpid) > 0 || InvCount(raw_anchid) > 0) && Running() && GetNearestObject(fireid)[0] > 0) {
            if(FindInv(raw_shrimpid) > 0) {
                UseOnObject(GetNearestObject(fireid)[0], GetNearestObject(fireid)[1], FindInv(raw_shrimpid));
                Wait(1000);
            }
            if(FindInv(raw_anchid) > 0) {
                UseOnObject(GetNearestObject(fireid)[0], GetNearestObject(fireid)[1], FindInv(raw_anchid));
                Wait(1000);
            }
            Wait(500);
            CheckSleep();
        }
    }
    private void WalkWait(int x, int y) {
        while(Loading() && Running())
            Wait(100);
        if (Running()) {
            ForceWalk(x,y);
            Wait(Rand(100,200));
        }
    }
    private void WalkRan(int x, int y) {
        while(Loading() && Running())
            Wait(100);
        if (Running()) {
            ForceWalk(Rand(x - 2,x + 2),Rand(y - 2,y + 2));
            Wait(Rand(100,200));
        }
        return;
    }
    private void CheckSleep() {
        if(Fatigue() >= 95 && Running()) {
            Msg("Sleeping...");
            while(!Sleeping() && Running()) {
                Use(FindInv(sleepbagid));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Msg("Waiting for sleepword...");
            while(Sleeping() && Running()) {
                Beep();
                Wait(1000);
            }
            Wait(1000);
            Msg("Finished sleeping");
            slept++;
        }
    }
    private void Msg(String str) {
        if(Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + str,3);
            str = str.replaceAll("@...@", "");
            Println("SBoT: " + str);
        }
    }
    private void DoBank(int id1, int id2 ,int count) {
        while (!Bank() && Running()) {
            while (!QuestMenu() && Running()) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
                long Time = TickCount();
                while (TickCount() - Time <= 3000 && !QuestMenu() && Running())
                    Wait(1);
            }
            Answer(0);
            long Time = TickCount();
            while (TickCount() - Time <= 8000 && !Bank() && Running())
                Wait(1);
        }
        while (Bank() && Running()) {
            while(InvCount(id1) > 0) {
                Deposit(id1,count);
                Wait(100);
            }
            while(InvCount(id2) > 0) {
                Deposit(id2,count);
                Wait(100);
            }
            Wait(1000);
            CloseBank();
        }
    }
    private void PrintStats(int start) {
        if (start == 1) {
            Msg("Printing start statistics to console...");
            Println("******* Draynor Powerfish+Cook+Bank Stats *******");
            Println("*** Start fishing exp: " + start_fishxp);
            Println("*** Start cooking exp: " + start_cookxp);
            Println("*** Start woodcutting exp: " + start_woodcutxp);
            Println("*** Start firemaking exp: " + start_firemakexp);
            Println("*** Start fishing level: " + start_fishlvl);
            Println("*** Start cooking level: " + start_cooklvl);
            Println("*** Start woodcutting level: " + start_woodcutlvl);
            Println("*** Start firemaking level: " + start_firemakelvl);
            Println("*** Starting with " + start_shrimp + " shrimp in inv");
            Println("*** Starting with " + start_anch + " anchovies in inv");
            Println("*************************************************");
        } else {
            Msg("Printing statistics to console...");
            int minutes = (int)((TickCount() - start_time) / 60000);
            Println("******* Draynor Powerfish+Cook+Bank Stats *******");
            Println("*** Worked for " + minutes + " minutes");
            Println("*** Fished " + fish_shrimp + " shrimps");
            Println("*** Fished " + fish_anch + " anchovies");
            Println("*** Banked " + bank_times + " times");
            Println("*** Slept " + slept + " times");
            Println("*** Cooked+Banked " + bank_shrimp + " shrimps" );
            Println("*** Cooked+Banked " + bank_anch + " anchovies" );
            Println("*** Dropped " + burnt_fish + " burnt fish" );
            Println("*** Gained " + (GetExperience(10) - start_fishxp) + " fishing exp");
            Println("*** Gained " + (GetExperience(7) - start_cookxp) + " cooking exp");
            Println("*** Gained " + (GetExperience(8) - start_woodcutxp) + " woodcutting exp");
            Println("*** Gained " + (GetExperience(11) - start_firemakexp) + " firemaking exp");
            Println("*** Gained " + (GetStat(10) - start_fishlvl) + " fishing levels");
            Println("*** Gained " + (GetStat(7) - start_cooklvl) + " cooking levels");
            Println("*** Gained " + (GetStat(8) - start_woodcutlvl) + " woodcutting levels");
            Println("*** Gained " + (GetStat(11) - start_firemakelvl) + " firemaking levels");
            if (minutes > 0) {
                Println("*** Averaging " + (((GetExperience(10) - start_fishxp) / minutes) * 60) + " fishing exp/hr");
                Println("*** Averaging " + (((GetExperience(7) - start_cookxp) / minutes) * 60) + " cooking exp/hr");
                Println("*** Averaging " + (((GetExperience(8) - start_woodcutxp) / minutes) * 60) + " woodcutting exp/hr");
                Println("*** Averaging " + (((GetExperience(11) - start_firemakexp) / minutes) * 60) + " firemaking exp/hr");
            }
            Println("*************************************************");
        }
    }
    private void CheckCombat() {
        while(InCombat() && Running()) {
            int oldx = GetX();
            int oldy = GetY();
            Msg("In combat, running back to fishing area!");
            WalkRan(218,659);
            Wait(1000);
            Walk(oldx,oldy);
        }
    }
}
