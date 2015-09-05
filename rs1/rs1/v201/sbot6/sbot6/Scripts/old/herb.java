public class herb extends Script {
    public herb(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"herb"};
    }
    public void start(String command, String parameter[]) {
        int FightTime = 1000;
        int[] items = new int[]{ 436, 438, 439, 440, 441, 442, 446, 448, 449, 450, 451, 452, 42 };
        Msg("@ran@herb collector Created By G-unit, modded by eXemplar");
        while (Running()) {
            Msg("Picking herbs...");
            while(InvCount() < 30) {
                SetFightMode(2);
                for(int i = 0; i < items.length; i++) {
                    int theItem[] = GetNearestItem(items[i]);
                    if (theItem[0] != -1) {
                        TakeItem(theItem[0], theItem[1], theItem[2]);
                        Wait(Rand(500,2000));
                    }
                }
                int ID = GetNearestNPC(270);
                if (ID != -1) {
                    long T = System.currentTimeMillis();
                    AttackNPC(ID);
                    while (System.currentTimeMillis() - T <= 1000 && InCombat() == false && Running() == true)
                        Wait(1);
                }
                Wait(Rand(1500,2500));
                while(InCombat() && Running())
                    Wait(100);
            }
            if(Fatigue() >= Rand(90,95) && Running()) {
                Msg("Sleeping...");
                Wait(Rand(1000,2000));
                while(!Sleeping() && Running()) {
                    Use(FindInv(1263));
                    long Time = TickCount();
                    while(!Sleeping() && TickCount() - Time < 3000 && Running())
                        Wait(1);
                }
                Msg("Waiting for sleep word...");
                while(Sleeping() && Running()) {
                    long T = TickCount();
                    while(Sleeping() && Running() && TickCount() - T < (Rand(3,4) * 60000))
                        Wait(1000);
                    if(Sleeping() && Running())
                        SleepWord();
                }
                Wait(Rand(1000,2000));
                Msg("Finished sleeping");
            }
            Msg("Walking to bank...");
            while (DoorAt(617, 556, 0) == 2 && Running()) {
                OpenDoor(617, 556, 0);
                Wait(Rand(500,1500));
            }
            Walk(618,562);
            Walk(611,566);
            Walk(610,574);
            Walk(612,580);
            Walk(612,588);
            Walk(610,594);
            Walk(604,594);
            Walk(597,599);
            Walk(597,603);
            Walk(590,603);
            Walk(589,602);
            Walk(588,599);
            Walk(587,592);
            Walk(587,584);
            Walk(587,575);
            Walk(583,573);
            Wait(Rand(1000,1500));
            while (!Bank() && Running()) {
                if(GetNearestNPC(95) < 0) {
                    Msg("Cannot find banker!");
                    EndScript();
                    DisableAutoLogin();
                    Logout();
                    return;
                }
                ResetLastNPCMessage();
                while((!QuestMenu() && LastNPCMessage().trim().equalsIgnoreCase("")) && Running()) {
                    TalkToNPC(GetNearestNPC(95));
                    Wait(1);
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
            if (Bank() && Running()) {
                Msg("Banking...");
                for (int i = 0;i < items.length;i++) {
                    while(InvCount(items[i]) > 0 && Running() && Bank()) {
                        Deposit(items[i],1);
                        Wait(Rand(100,200));
                    }
                }
            }
            Wait(Rand(300,500));
            while(Bank() && Running()) {
                CloseBank();
                Wait(Rand(1000,1500));
            }
            Msg("Walking to herbs...");
            Walk(580,572);
            Walk(586,570);
            Walk(587,576);
            Walk(587,582);
            Walk(587,588);
            Walk(588,594);
            Walk(590,600);
            Walk(597,600);
            Walk(600,597);
            Walk(604,594);
            Walk(610,594);
            Walk(611,586);
            Walk(611,581);
            Walk(611,574);
            Walk(610,571);
            Walk(609,567);
            Walk(616,559);
            Walk(617,556);
            while (DoorAt(617, 556, 0) == 2 && Running()) {
                OpenDoor(617, 556, 0);
                Wait(Rand(500,1500));
            }
        }
        Msg("@red@herb collector STOPPED");
    }
    public void Msg(String msg) {
        DisplayMessage("@gre@SBoT: @whi@" + msg,3);
        Println("SBoT: " + msg.replaceAll("@...@",""));
    }
}