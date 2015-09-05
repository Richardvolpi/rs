public class BattleStaffBuyer extends Script {
    
    public int Trips = 0;
    public int Items = 0;
    public int Item = 614;
    public long StartTime = 0;
    public int World = 82;
    public int Npc = 69;
    
    public BattleStaffBuyer(mudclient rs) {
        super(rs);
    }
    
    public String[] getCommands() {
        return new String[]{"bstaffbuyer"};
    }
    
    public void start(String command, String parameter[]) {
        Println("#### Battle Staff Buyer - by eXemplar");
        StartTime = TickCount();
        EnableAutoLogin();
        while (Running()) {
            Trips++;
            Println("### " + (long)((TickCount() - StartTime) / 1000) + " seconds have passed");
            Println("### Trip Number: " + Trips);
            Println("### Number of items bought: " + Items);
            if(InvCount(10) < 8000) {
                Println("### Out of money in inv, stopping script.");
                EndScript();
                DisableAutoLogin();
                return;
            }
            
            Println("## Banking");
            DoBank();
            
            Println("## Going to shop");
            while (!CanReach(140,504) && Running()) {
                while(!CanReach(151,500) && Running()) {
                    Println("## Opening Bank Door");
                    AtObject(150,507);
                    Wait(Rand(2500,3000));
                }
                ForceWalk(140, 507);
                Wait(Rand(300,500));
                while (!CanReach(140,504) && Running()) {
                    Println("## Opening Shop Door");
                    OpenDoor(140, 507, 0);
                    Wait(Rand(2500,3000));
                }
            }
            if(Running())
                ForceWalk(140,504);
            
            Println("## Shopping");
            DoShop();
            
            Println("## Going to bank with " + InvCount(Item) + " items");
            Items += InvCount(Item);
            while(!CanReach(151,500) && Running()) {
                while (!CanReach(142,507) && Running()) {
                    Println("## Opening Shop Door");
                    OpenDoor(140, 507, 0);
                    Wait(Rand(2500,3000));
                }
                ForceWalk(150,507);
                Wait(Rand(300,500));
                while(!CanReach(151,500) && Running()) {
                    Println("## Opening Bank Door");
                    AtObject(150,507);
                    Wait(Rand(2500,3000));
                }
            }
            if(Running())
                ForceWalk(151,500);
        }
        Println("#### Script Ended ####");
    }
    public void DoShop() {
        while(InvCount() < 30 && InvCount(10) >= 8000 && Running()) {
            while (!Shop() && Running()) {
                int tries = 0;
                while(GetNearestNPC(Npc) < 0 && Running()) {
                    if(tries > 5) {
                        Println("### Cannot find seller! PANIC MAENZ!!!");
                        Quit();
                    }
                    tries++;
                    Wait(Rand(1000,2000));
                }
                TalkToNPC(GetNearestNPC(Npc));
                long T = TickCount();
                ResetLastServerMessage();
                while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0 && Running())
                    Wait(10);
                if (QuestMenu()) {
                    Answer(0);
                    T = TickCount();
                    while (!Shop() && TickCount() - T < 5000 && Running())
                        Wait(10);
                }
            }
            if (Shop()) {
                Println("## Buying " + ShopCount(Item) + " items");
                while (ShopCount(Item) > 0 && Running() && Shop() && InvCount() < 30 && InvCount(10) >= 8000) {
                    Buy(Item);
                    Wait(Rand(100,200));
                }
                if(Shop()) {
                    Wait(Rand(300,500));
                    CloseShop();
                }
                Wait(Rand(1000,2000));
                if(InvCount() < 30 && InvCount(10) >= 8000) {
                    if (World < 86)
                        World += 2;
                    else
                        World = 82;
                    Println("## Changing to world " + World);
                    SetWorld(World);
                    Logout();
                    Wait(Rand(2000,5000));
                }
            }
        }
    }
    public void DoBank() {
        while (!Bank() && Running()) {
            int tries = 0;
            while(GetNearestNPC(95) < 0 && Running()) {
                if(tries > 5) {
                    Println("### Cannot find seller! PANIC MAENZ!!!");
                    Quit();
                }
                tries++;
                Wait(Rand(1000,2000));
            }
            ResetLastNPCMessage();
            while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                TalkToNPC(GetNearestNPC(95));
                Wait(1);
                long Time = TickCount();
                while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running() && LastNPCMessage().indexOf("busy") < 0)
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
        if (Bank() && Running()) {
            while(InvCount(Item) > 0 && Running() && Bank()) {
                Deposit(Item,1);
                Wait(Rand(100,200));
            }
        }
        Wait(Rand(300,500));
        CloseBank();
        Wait(Rand(1000,2000));
    }   
}
