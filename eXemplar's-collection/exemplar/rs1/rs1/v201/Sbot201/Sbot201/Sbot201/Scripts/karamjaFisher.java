/*
 * karamjaFisher - by eXemplar
 *
 * usage:
 *  /run karamjafisher fish@mode
 *
 *  fish = 0 = swordfish
 *  fish = 1 = tuna, will also do swordfish if it gets any
 *  fish = 2 = lobster
 *
 *  mode = 0 = power fish
 *  mode = 1 = fish + bank raw
 *  mode = 2 = fish + cook + bank cooked
 *
 * start at: karamja fishing docks
 *
 * start with:
 *  - lobster pot/harpoon
 *  - sleeping bag
 *  - enough money to get to bank
 *  - chat and trade blocks on
 *  - autologin on, shouldn't be necessary though
 *
 * features:
 *  - mod protection
 *  - teleport protection
 *
 */

/*
 * karamjaFisher.java
 *
 * Created on 31 December 2004, 13:03
 */

/**
 *
 * @author  isaac
 */
public class karamjaFisher extends Script {
    
    int karamja2shipX[] = new int[] { 371, 389, 365, 342, 336 };
    int karamja2shipY[] = new int[] { 686, 692, 708, 710, 713 };
    int sarim2bankX[] = new int[] { 268, 269, 261, 247, 230, 226 };
    int sarim2bankY[] = new int[] { 645, 636, 615, 610, 624, 630 };
    int sarim2rangeX[] = new int[] { 270 , 275 };
    int sarim2rangeY[] = new int[] { 645 , 635 };
    
    int fish;
    int mode;

    long start_time = 0;
    int slept = 0;
    int banked = 0;
    int fish_banked = 0;
    
    int fishing_exp = 0;
    int cooking_exp = 0;
    int fishing_lvl = 0;
    int cooking_lvl = 0;
    
    long start_fishxp;
    long start_cookxp;
    int start_fishlvl;
    int start_cooklvl;
    
    int karamja_ship_id = 161;
    int sarim_ship_id = 155;
    int banker_id = 95;
    int range_id = 11;
    int gold_id = 10;
    
    /** Creates a new instance of karamjaFisher */
    public karamjaFisher(mudclient rs) {
        super(rs);
    }
    
    public String[] getCommands() {
        return new String[]{"karamjafisher"};
    }
    
    public void start(String cmd, String params[]) {
        Msg("karamjaFisher - by by @ran@e@ran@X@ran@e@ran@m@ran@p@ran@l@ran@a@ran@r");
        
        if (params == null || params.length < 2) {
            ShowUsage();
            EndScript();
            return;
        }
        
        fish = Integer.parseInt(params[0]);
        mode = Integer.parseInt(params[1]);
        
        switch(fish) {
            case 0:
                Msg("Fishing: swordfish");
                break;
            case 1:
                Msg("Fishing: tuna");
                break;
            case 2:
                Msg("Fishing: lobster");
                break;
            default:
                ShowUsage();
                EndScript();
                return;
        }
        
        switch(mode) {
            case 0:
                Msg("Mode: power fish");
                break;
            case 1:
                Msg("Mode: fish + bank raw");
                break;
            case 2:
                Msg("Mode: fish + cook + bank cooked");
                break;
            default:
                ShowUsage();
                EndScript();
                return;
        }
        
        if (InvCountByName("Lobster Pot") <= 0 && InvCountByName("Harpoon") <= 0) {
            Msg("You must have a lobster pot or harpoon in your inventory!");
            EndScript();
            return;
        }
        if(InvCount(1263) <= 0) {
            Msg("You must have a sleeping bag in your inventory!");
            EndScript();
            return;
        }
        if(InvCount(gold_id) < 30) {
            Msg("You must have at least 30gp in your inventory!");
            EndScript();
            return;
        }
        
        if(!CanReach(371,684) && Distance(371,684) < 10) {
            Msg("You must start at karamja fishing spot!");
            EndScript();
            return;
        }
        
        start_fishxp = GetExperience(10);
        start_cookxp = GetExperience(7);
        start_fishlvl = GetStat(10);
        start_cooklvl = GetStat(7);
        start_time = TickCount();
        
        PrintStats(1);
        
        while (Running()) {
            
            int place = Rand(1,2);
            long stime = TickCount();
            Msg("Fishing at place " + place + "...");
            while(Running() && ((mode > 0 && InvCount() < 30) || (mode == 0))) {
                int numInv = InvCount();
                while(numInv == InvCount() && Running()) {
                    if (place == 1) {
                        if(fish < 2)
                            AtObject(370,678);
                        else
                            AtObject2(370,678);
                    } else {
                        if(fish < 2)
                            AtObject(368,684);
                        else
                            AtObject2(368,684);
                    }
                    long t = TickCount();
                    while(numInv == InvCount() && TickCount() - t < Rand(1500,2500) && Running())
                        Wait(1);
                    CheckSleep();
                    CheckTeleport();
                    if(mode > 0 && fish == 0 && Running()) // drop raw tuna if fishing swordies, but if fishing tuna, don't drop swordies
                            DropAll("Raw Tuna");
                    if(TickCount() - stime > Rand(50000,60000) * Rand(3,4)) { // switch spots every 3-4 minutes
                        stime = TickCount();
                        if(place == 1)
                            place = 2;
                        else
                            place = 1;
                        Msg("Fishing at place " + place + "...");
                    }
                    int id;
                    if(fish == 0) // swordie
                        id = 369;
                    else if(fish == 1) // tuna
                        id = 366;
                    else if (fish == 2) // lobbie
                        id = 372;
                    else
                        id = -1;
                    if(ItemAt(GetX(),GetY(),id) && id > 0) {
                        while(ItemAt(GetX(),GetY(),id) && Running()) {
                            ItemAt(GetX(),GetY(),id);
                            Wait(Rand(300,600));
                        }
                    }
                }
            }
            
            if(InvCount() == 30)
                Msg("Inventory full,");
            
            Msg("Walking to karamja ship...");
            WalkPath2(karamja2shipX,karamja2shipY);
            CheckTeleport();
            
            Msg("Boarding karamja ship...");
            while(!InArea(260,645,270,660) && Running()) {
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    AtObject(326,710);
                    long t = TickCount();
                    while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && TickCount() - t < Rand(500,700) && Running())
                        Wait(1);
                }
                long tt = TickCount();
                while(!QuestMenu() && TickCount() - tt < 5000 && Running())
                    Wait(1);
                Answer("Search");
                Wait(Rand(500,1000));
                long t = TickCount();
                while(!QuestMenu() && TickCount() - t < Rand(10000,12000) && Running())
                    Wait(1);
                Answer("Ok");
                long t1 = TickCount();
                while(!InArea(260,645,270,660) && TickCount() - t1 < Rand(12000,16000) && Running())
                    Wait(1);
                while(Loading() && Running())
                    Wait(1);
            }
            
            Wait(Rand(1000,2000));
            
            CheckTeleport();
            
            if(mode == 2) { // cooking fish
                
                Msg("Walking to range...");
                WalkPath2(sarim2rangeX,sarim2rangeY);
                CheckTeleport();
                
                if(ObjectAt(276, 637) == 2) {
                    Msg("Opening range house door...");
                    while(ObjectAt(276, 637) == 2 && Running()) {
                        OpenDoor(276, 637, 0);
                        Wait(Rand(500,1000));
                    }
                }
                ForceWalk(276,638);
                
                CheckTeleport();
                
                if(GetNearestObject(range_id)[0] < 0) {
                    Msg("Cannot find range!");
                    Quit();
                    EndScript();
                    return;
                }
                
                CookAll("Raw Swordfish", "Swordfish", "Burnt Swordfish");
                CookAll("Raw Lobster", "Lobster", "Burnt fish");
                CookAll("Raw Tuna", "Tuna", "Burnt Lobster");
                
                if(ObjectAt(276, 637) == 2) {
                    Msg("Opening range house door...");
                    while(ObjectAt(276, 637) == 2 && Running()) {
                        OpenDoor(276, 637, 0);
                        Wait(Rand(500,1000));
                    }
                }
                CheckTeleport();
                
            }
            
            Msg("Walking to bank...");
            WalkPath2(sarim2bankX,sarim2bankY,(mode == 2) ? 1 : 0);
            CheckTeleport();
            
            if(ObjectAt(219,633) == 64) {
                ForceWalk(220,633); // next to bank door
                Msg("Opening bank door...");
                while(ObjectAt(219,633) == 64 && Running()) {
                    AtObject(219,633);
                    Wait(Rand(500,1000));
                }
            }
            WalkRan(216,634,223,637);
            
            CheckTeleport();
            
            Msg("Banking fish...");
            fish_banked += InvCountByName("Lobster") + InvCountByName("Tuna") + InvCountByName("Swordfish") + InvCountByName("Raw Lobster") + InvCountByName("Raw Tuna") + InvCountByName("Raw Swordfish");
            while((InvCountByName("Lobster") > 0 || InvCountByName("Tuna") > 0 || InvCountByName("Swordfish") > 0 || InvCountByName("Raw Lobster") > 0 || InvCountByName("Raw Tuna") > 0 || InvCountByName("Raw Swordfish") > 0) && Running()) {
                while (!Bank() && Running()) {
                    ResetLastNPCMessage();
                    while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                        int BankerID = GetNearestNPC(banker_id);
                        TalkToNPC(BankerID);
                        long Time = TickCount();
                        while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running())
                            Wait(1);
                    }
                    long tt = TickCount();
                    while(!QuestMenu() && TickCount() - tt < 5000 && Running())
                        Wait(1);
                    Answer(0);
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(6000,8000) && !Bank() && Running())
                        Wait(1);
                }
                while (Bank() && Running()) {
                    while(InvCountByName("Lobster") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Lobster")),1);
                        Wait(Rand(100,400));
                    }
                    while(InvCountByName("Swordfish") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Swordfish")),1);
                        Wait(Rand(100,400));
                    }
                    while(InvCountByName("Tuna") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Tuna")),1);
                        Wait(Rand(100,400));
                    }
                    while(InvCountByName("Raw Lobster") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Raw Lobster")),1);
                        Wait(Rand(100,400));
                    }
                    while(InvCountByName("Raw Swordfish") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Raw Swordfish")),1);
                        Wait(Rand(100,400));
                    }
                    while(InvCountByName("Raw Tuna") > 0 && Bank()) {
                        Deposit(Inv(InvByName("Raw Tuna")),1);
                        Wait(Rand(100,400));
                    }
                    if(InvCount(gold_id) < 60) {
                        if(BankCount(gold_id) >= 60) {
                            while(InvCount(gold_id) < 60 && Running()) {
                                Withdraw(gold_id,5);
                                Wait(Rand(100,400));
                            }
                        } else {
                            Msg("You don't have enough gp for another trip to karamja!");
                            PrintStats(0);
                            Quit();
                            EndScript();
                            return;
                        }
                    }
                    Wait(Rand(800,1500));
                    CloseBank();
                    banked++;
                }
            }
            CheckTeleport();
            
            Msg("Walking to port sarim ship...");
            WalkPathReverse2(sarim2bankX,sarim2bankY);
            CheckTeleport();
            
            Msg("Boarding port sarim ship...");
            while(!InArea(320,710,340,720) && Running()) {
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    AtObject(265,645);
                    long t = TickCount();
                    while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && TickCount() - t < Rand(500,700) && Running())
                        Wait(1);
                }
                while(!QuestMenu() && Running())
                    Wait(1);
                Answer("Yes");
                long t = TickCount();
                while(!InArea(320,710,340,720) && TickCount() - t < Rand(12000,16000) && Running())
                    Wait(1);
                while(Loading() && Running())
                    Wait(1);
            }
            Wait(Rand(1000,2000));
            CheckTeleport();
            
            Msg("Walking to karamja fishing spot...");
            WalkPathReverse2(karamja2shipX,karamja2shipY);
            CheckTeleport();
            
            PrintStats(0);
        }
        
    }
    
    public void ChatMessage(String msg) {
        Msg("Chat recieved: " + msg);
        Msg("Mod protection activated.");
        Quit();
        EndScript();
    }
    
    public void TradeRequest(int playerId) {
        Msg("Trade recieved from: " + playerId);
        Msg("Mod protection activated.");
        Quit();
        EndScript();
    }
    
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
    
    private void ShowUsage() {
        Msg("karamjaFisher usage:");
        Msg("/run karamjafisher fish@mode");
        Msg("where fish = 0,1,2 mode = 0,1,2");
        Println(" - fish = 0 = swordfish");
        Println(" - fish = 1 = tuna");
        Println(" - fish = 2 = lobster");
        Println(" - mode = 0 = power fish");
        Println(" - mode = 1 = fish + bank raw");
        Println(" - mode = 2 = fish + cook + bank cooked");
    }
    
    private void CookAll(String rawName, String cookedName, String burntName) {
        if(InvCountByName(rawName) > 0) {
            Msg("Cooking " + rawName + "...");
            while(InvCountByName(rawName) > 0 && Running()) {
                int numinv = InvCountByName(cookedName);
                while(numinv == InvCountByName(cookedName) && Running()) {
                    if(InvByName(rawName) < 0)
                        return;
                    CheckTeleport();
                    UseOnObject(GetNearestObject(range_id)[0], GetNearestObject(range_id)[1], InvByName(rawName));
                    long t = TickCount();
                    while (numinv == InvCountByName(cookedName) && TickCount() - t <= 3000 && Running())
                        Wait(1);
                    CheckSleep();
                }
            }
        }
        DropAll(burntName);
    }
    
    private void DropAll(String invName) {
        if(InvCountByName(invName) > 0 && Running()) {
            Msg("Dropping " + invName + "...");
            int finv = InvCount();
            while(InvCountByName(invName) > 0 && Running()) {
                int pinv = InvCount();
                while(pinv == InvCount() && Running()) {
                    CheckTeleport();
                    if(InvCountByName(invName) > 0)
                        Drop(InvByName(invName));
                    long Time = TickCount();
                    while (pinv == InvCount() && TickCount() - Time <= 3000 && Running())
                        Wait(1);
                }
                Wait(Rand(100,400));
            }
        }
    }
    
    private void PrintStats(int start) {
        Msg("Printing start statistics to console...");
        Println("******* karamjaFisher Stats *******");
        if (start != 0) {
            Println("*** Start fishing exp: " + start_fishxp);
            Println("*** Start cooking exp: " + start_cookxp);
            Println("*** Start fishing level: " + start_fishlvl);
            Println("*** Start cooking level: " + start_cooklvl);
        } else {
            int minutes = (int)((TickCount() - start_time) / 60000);
            Println("*** Worked for " + minutes + " minutes");
            Println("*** Slept " + slept + " times");
            Println("*** Banked " + banked + " times");
            Println("*** Fished & Banked " + fish_banked + " fish" );
            Println("*** Gained " + (GetExperience(10) - start_fishxp) + " fishing exp");
            Println("*** Gained " + (GetExperience(7) - start_cookxp) + " cooking exp");
            Println("*** Gained " + (GetStat(10) - start_fishlvl) + " fishing levels");
            Println("*** Gained " + (GetStat(7) - start_cooklvl) + " cooking levels");
            if (minutes > 0) {
                Println("*** Averaging " + (((GetExperience(10) - start_fishxp) / minutes) * 60) + " fishing exp/hr");
                Println("*** Averaging " + (((GetExperience(7) - start_cookxp) / minutes) * 60) + " cooking exp/hr");
      double n = fish_banked / minutes * 60;
                Println("*** Averaging " + n + " fish banked/hr");
            }
        }
        Println("***********************************");
    }
    
    private void CheckSleep() {
        if(Fatigue() >= Rand(80,85) && Running()) {
            Msg("Pre sleep wait");
            Wait(Rand(1000,2500));
            Msg("Sleeping...");
            while(!Sleeping() && Running()) {
                Use(FindInv(1263));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Msg("Waiting for sleep word...");
            while(Sleeping() && Running()) {
                long T = TickCount();
                while(Sleeping() && Running() && TickCount() - T < Rand(50000,60000) * Rand(3,4)) { // change sleepword every 2 - 3 minutes
                    Wait(1);
                }
                if(Sleeping() && Running())
                    SleepWord();
            }
            Wait(Rand(1000,2000));
            Msg("Finished sleeping");
            slept++;
        }
    }
    
    private void Answer(String msg) {
        if(QuestMenu() && Running())
            for(int i = 0;i < GetAnswerCount();i++)
                if(InStr(GetAnswer(i),msg)) {
                    Answer(i);
                    while(QuestMenu() && Running())
                        Wait(1);
                    return;
                }
    }
    
    private void WalkRan(int x1, int y1, int x2, int y2) {
        while(IsWalking() && Running())
            Wait(1);
        int rx = Rand(x1,x2);
        int ry = Rand(y2,y2);
        int tries = 0;
        while(!CanReach(rx,ry) && tries < 10 && Running()) {
            rx = Rand(x1,x2);
            ry = Rand(y2,y2);
            tries++;
        }
        ForceWalk(rx,ry);
        while(IsWalking() && Running())
            Wait(1);
    }
    
    public void CheckTeleport() {
        
        // first check the areas between the walk paths
        
        while(IsWalking() && Running())
            Wait(1);
        
        int x1,y1,x2,y2;
        
        for(int i = 0;i < karamja2shipX.length - 1;i++) {
            if(karamja2shipX[i] > karamja2shipX[i+1]) {
                x1 = karamja2shipX[i+1];
                x2 = karamja2shipX[i];
            } else {
                x1 = karamja2shipX[i];
                x2 = karamja2shipX[i+1];
            }
            if(karamja2shipY[i] > karamja2shipY[i+1]) {
                y1 = karamja2shipY[i+1];
                y2 = karamja2shipY[i];
            } else {
                y1 = karamja2shipY[i];
                y2 = karamja2shipY[i+1];
            }
            if(InArea(x1 - 1,y1 - 1,x2 + 1,y2 + 1))
                return;
        }
        
        for(int i = 0;i < sarim2bankX.length - 1;i++) {
            if(sarim2bankX[i] > sarim2bankX[i+1]) {
                x1 = sarim2bankX[i+1];
                x2 = sarim2bankX[i];
            } else {
                x1 = sarim2bankX[i];
                x2 = sarim2bankX[i+1];
            }
            if(sarim2bankY[i] > sarim2bankY[i+1]) {
                y1 = sarim2bankY[i+1];
                y2 = sarim2bankY[i];
            } else {
                y1 = sarim2bankY[i];
                y2 = sarim2bankY[i+1];
            }
            if(InArea(x1 - 1,y1 - 1,x2 + 1,y2 + 1))
                return;
        }
        
        for(int i = 0;i < sarim2rangeX.length - 1;i++) {
            if(sarim2rangeX[i] > sarim2rangeX[i+1]) {
                x1 = sarim2rangeX[i+1];
                x2 = sarim2rangeX[i];
            } else {
                x1 = sarim2rangeX[i];
                x2 = sarim2rangeX[i+1];
            }
            if(sarim2rangeY[i] > sarim2rangeY[i+1]) {
                y1 = sarim2rangeY[i+1];
                y2 = sarim2rangeY[i];
            } else {
                y1 = sarim2rangeY[i];
                y2 = sarim2rangeY[i+1];
            }
            if(InArea(x1 - 1,y1 - 1,x2 + 1,y2 + 1))
                return;
        }
        
        // if we aren't in the walk paths areas, we are either in the bank, karamja fishing spot, range house, or randomly at docks
        
        int foundbanker = GetNearestNPC(banker_id);
        if(CanReach(NPCX(foundbanker),NPCY(foundbanker)) && Distance(NPCX(foundbanker),NPCY(foundbanker)) < 10) // bank
            return;
        
        if(CanReach(230,624) && Distance(230,624) < 10)
            return;
        
        if(CanReach(371,684) && Distance(371,684) < 10)
            return;
        
        if(CanReach(GetNearestObject(range_id)[0],GetNearestObject(range_id)[1]) && Distance(GetNearestObject(range_id)[0],GetNearestObject(range_id)[1]) < 6) // range house
            return;
        
        if(CanReach(276, 636) && Distance(276, 636) < 10) // outside range house
            return;
        
        if(InArea(320,710,340,720)) // karamja docks
            return;
        
        if(InArea(260,645,270,660)) // sarim docks
            return;
        
        //ok, since we aren't anywhere known, get the fuck outta here
        
        Msg("CheckTeleport(): Unknown location " + GetX() + "," + GetY());
        Msg("Mod protection activated.");
        Quit();
        EndScript();
    }
    
    private void WalkPath2(int[] x, int[] y) {
        if(x.length == y.length)
            for(int i = 0;i < x.length;i++)
                if(Running() && CanReach(x[i],y[i]))
                    ForceWalk(x[i],y[i]);
    }
    
    private void WalkPath2(int[] x, int[] y, int start) {
        if(x.length == y.length)
            for(int i = start;i < x.length;i++)
                if(Running() && CanReach(x[i],y[i]))
                    ForceWalk(x[i],y[i]);
    }
    
    private void WalkPathReverse2(int[] x, int[] y) {
        if(x.length == y.length)
            for(int i = x.length - 1;i > 0;i--)
                if(Running() && CanReach(x[i],y[i]))
                    ForceWalk(x[i],y[i]);
        while(IsWalking() && Running())
            Wait(1);
        ForceWalk(x[0],y[0]); // silly bug not walking the last step
        while(IsWalking() && Running())
            Wait(1);
    }
}