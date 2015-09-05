public class Attacher extends Script {
    
    public int bankers[] = new int[]{ 95 };
    
    public Attacher(mudclient rs) {
        super(rs);
    }
    
    public String[] getCommands() {
        return new String[]{"attach"};
    }
    
    public void start(String cmd, String params[]) {
        if(params == null) {
            showUsage();
            return;
        }
        if(params.length != 2) {
            showUsage();
            return;
        }
        
        System.out.println("Item attacher - by eXemplar - Needs sleeping bag in first inv slot!");
        
        int item1 = Integer.parseInt(params[0]);
        int item2 = Integer.parseInt(params[1]);
        
        System.out.println("Attaching " + GetItemName(item1) + " to " + GetItemName(item2));
        
        while(Running()) {
            if(InvCount() > 0)
                while (!Bank() && Running()) {
                    int tries = 0;
                    while(GetNearestNPC(bankers) < 0 && Running()) {
                        if(tries > 5) {
                            Println("Error: Cannot find banker!");
                            Quit();
                        }
                        tries++;
                        Wait(Rand(1000,2000));
                    }
                    ResetLastNPCMessage();
                    while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                        TalkToNPC(GetNearestNPC(bankers));
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
                while(InvCount() > 1 && Running() && Bank()) {
                    int amm = 1;
                    if(InvCount(Inv(1)) >= 2500)
                        amm = 2500;
                    if(InvCount(Inv(1)) >= 500)
                        amm = 500;
                    if(InvCount(Inv(1)) >= 100)
                        amm = 100;
                    if(InvCount(Inv(1)) >= 25)
                        amm = 25;
                    if(InvCount(Inv(1)) >= 5)
                        amm = 5;
                    Deposit(Inv(1),amm);
                    Wait(Rand(100,200));
                }
                int count = (30 - InvCount()) / 2;
                while(InvCount(item1) != count && Running() && Bank()) {
                    int i = InvCount();
                    if(InvCount(item1) < count)
                        Withdraw(item1,1);
                    if(InvCount(item1) > count)
                        Deposit(item1,1);
                    if(InvCount(item1) == count)
                        break;
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(1000,2000) && InvCount() == i && Running())
                        Wait(1);
                    Wait(Rand(100,200));
                }
                while(InvCount(item2) != count && Running() && Bank()) {
                    int i = InvCount();
                    if(InvCount(item2) < count)
                        Withdraw(item2,1);
                    if(InvCount(item2) > count)
                        Deposit(item2,1);
                    if(InvCount(item2) == count)
                        break;
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(1000,2000) && InvCount() == i && Running())
                        Wait(1);
                    Wait(Rand(100,200));
                }
                Wait(Rand(300,500));
                CloseBank();
            }
            Wait(Rand(300,500));
            
            while(InvCount(item1) > 0 && InvCount(item2) > 0 && Running()) {
                int i = InvCount(item1);
                UseWithInventory(FindInv(item1),FindInv(item2));
                long Time = TickCount();
                while (TickCount() - Time <= Rand(1000,2000) && InvCount(item1) == i && Running())
                    Wait(1);
                Wait(Rand(100,200));
                CheckSleep();
            }
        }
    }
    
    public void CheckSleep() {
        if(Fatigue() >= 85 && Running()) {
            Println("Sleeping...");
            Wait(Rand(1000,2000));
            while(!Sleeping() && Running()) {
                Use(FindInv(1263));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Println("Waiting for sleep word...");
            while(Sleeping() && Running()) {
                long T = TickCount();
                while(Sleeping() && Running() && TickCount() - T < (Rand(3,4) * 60000))
                    Wait(1000);
                if(Sleeping() && Running())
                    SleepWord();
            }
            Wait(Rand(1000,2000));
            Println("Finished sleeping");
        }
    }
    
    public void showUsage() {
        Println("Usage - /run attach item1@item2");
    }
}