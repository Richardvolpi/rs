public class SteelMacePicker extends Script {
    
    int[] zamToBankX = { 330,315,308,316,317,306,309,314,325 };
    int[] zamToBankY = { 436,435,450,471,489,497,514,534,543 };
    int[] items = { 95 };

    public SteelMacePicker(mudclient rs) {
        super(rs);
    }
    
    public String[] getCommands() {
        return new String[]{"smpick"};
    }
    
    public void start(String cmd, String params[]) {
        Println("Chaos steel mace picker - eXemplar");
        while(Running()) {
            Println("Picking maces");
            while(InvCount() < 30 && Running()) {
                if(Distance(330,436) > 16 && Running()) {
                    if(!CanReach(330,436) && Running()) {
                        Println("Error: Greater than 16 spots from mace spot");
                        Quit();
                    }
                    Println("Walking back to chaos altar");
                    while(Distance(330,436) > 16 && Running()) {
                        ForceWalk(330,436);
                        Wait(Rand(500,1000));
                    }
                }
                int[] theItem = GetNearestItem(items);
                if(Distance(theItem[0],theItem[1]) < 16) {
                    TakeItem(theItem[0], theItem[1], theItem[2]);
                    Wait(Rand(1000,2000));
                }
                Wait(100);
            }
            if(Running())
                Println("Walking to bank");
            if(Running()) {
                WalkPath2(zamToBankX,zamToBankY);
                Wait(Rand(300,500));
            }
            if(!CanReach(331,554) && Running()) {
                Println("Opening bank door 1");
                while(!CanReach(331,554) && Running()) {
                    AtObject(327,552);
                    Wait(Rand(500,1000));
                }
            }
            if(Running())
                ForceWalk(331,554);
            if(Running())
                Println("Banking maces...");
            while (!Bank() && Running()) {
                if(GetNearestNPC(95) < 0) {
                    Println("Cannot find banker! PANIC MAENZ!!!");
                    Quit();
                    return;
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
            while(InvCount() > 1 && Running() && Bank()) {
                int amm = 1;
                if(InvCount(Inv(0)) >= 25)
                    amm = 25;
                if(InvCount(Inv(0)) >= 5)
                    amm = 5;
                Deposit(Inv(0),amm);
                Wait(Rand(100,200));
            }
            if(Running()) {
                Wait(Rand(300,500));
                CloseBank();
                Wait(Rand(300,500));
            }
            if(!CanReach(325,543) && Running()) {
                Println("Opening bank door 2");
                while(!CanReach(325,543) && Running()) {
                    AtObject(327,552);
                    Wait(Rand(500,1000));
                }
            }
            if(Running())
                Println("Walking to chaos altar");
            if(Running()) {
                WalkPathReverse2(zamToBankX,zamToBankY);
                Wait(Rand(300,500));
            }
        }
        Println("Picker Stopped");
    }
    private void WalkPath2(int[] x, int[] y) {
        if(x.length == y.length)
            for(int i = 0;i < x.length;i++) {
                if(Running())
                    ForceWalk(x[i],y[i]);
            }
        while(IsWalking() && Running())
            Wait(1);
    }
    
    private void WalkPathReverse2(int[] x, int[] y) {
        if(x.length == y.length) {
            for(int i = x.length - 1;i > 0;i--)
                if(Running())
                    ForceWalk(x[i],y[i]);
            while(IsWalking() && Running())
                Wait(1);
            if(Running())
                ForceWalk(x[0],y[0]);
            while(IsWalking() && Running())
                Wait(1);
        }
    }
}
