public class maceSeller extends Script {
    
    public maceSeller(mudclient mc) {
        super(mc);
    }
    
    public String[] getCommands() {
        return new String[]{"sellmace"};
    }
    
    public void start(String cmd, String params[]) {
        while(Running()) {
            Println("Banking");
            while (!Bank() && Running()) {
                if(GetNearestNPC(95) < 0) {
                    Println("Cannot find banker! PANIC MAENZ!!!");
                    Quit();
                    return;
                }
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    TalkToNPC(GetNearestNPC(95));
                    Wait(100);
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running())
                        Wait(100);
                }
                long tt = TickCount();
                while(!QuestMenu() && TickCount() - tt < 5000 && Running())
                    Wait(100);
                Answer(0);
                long Time = TickCount();
                while (TickCount() - Time <= Rand(6000,8000) && !Bank() && Running())
                    Wait(100);
            }
            while(InvCount() < 30 && Running() && Bank()) {
                if(BankCount(95) == 0) {
                    Println("No more maces");
                    return;
                }
                Withdraw(95,1);
                Wait(Rand(100,200));
            }
            Wait(500);
            CloseBank();
            Wait(500);
            Println("Walking to store");
            ForceWalk(325,545);
            if(ObjectAt(326, 540) == 2) {
                while(ObjectAt(326, 540) == 2 && Running()) {
                    OpenDoor(326, 540, 3);
                    Wait(Rand(500,1000));
                }
            }
            ForceWalk(326,539);
            Println("Selling");
            while(InvCount(95) > 0 && Running()) {
                while (!Shop() && Running()) {
                    if(GetNearestNPC(115) < 0) {
                        Println("Cannot find seller! PANIC MAENZ!!!");
                        Quit();
                        return;
                    }
                    ResetLastNPCMessage();
                    while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                        TalkToNPC(GetNearestNPC(115));
                        Wait(100);
                        long Time = TickCount();
                        while (TickCount() - Time <= Rand(500,1000) && (!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running())
                            Wait(100);
                    }
                    long tt = TickCount();
                    while(!QuestMenu() && TickCount() - tt < 5000 && Running())
                        Wait(100);
                    Answer(1);
                    long Time = TickCount();
                    while (TickCount() - Time <= Rand(6000,8000) && !Shop() && Running())
                        Wait(100);
                }
                while(InvCount(95) > 0 && Shop() && Running()) {
                    Sell(95);
                    Wait(Rand(100,200));
                }
                if(Shop() && Running()) {
                    Wait(500);
                    CloseShop();
                }
                Wait(500);
            }
            Println("Walking to bank");
            if(ObjectAt(326, 540) == 2) {
                while(ObjectAt(326, 540) == 2 && Running()) {
                    OpenDoor(326, 540, 3);
                    Wait(Rand(500,1000));
                }
            }
            ForceWalk(325,545);
            ForceWalk(329,552);
        }
    }
    
}
