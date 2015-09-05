public class BarbCoal extends Script {
    private int coalrockid = 110;
    private int coalid = 155;
    private int sleepbag = 1263;
    public BarbCoal(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"barbcoal"};
    }
    public void start(String command, String parameter[]) {
        Msg("Barb coal miner by @ran@eXemplar");
        while(Running() == true) {
            Msg("Mining...");
            DoMine(coalrockid);
            Msg("Walking to bank...");
            WalkWait(227,503);
            WalkWait(222,481);
            WalkWait(221,471);
            WalkWait(221,456);
            OpenBankDoor(217,447);
            WalkWait(216,450);
            Msg("Banking...");
            DoBank(coalid,1);
            Msg("Walking back...");
            OpenBankDoor(217,447);
            WalkWait(221,446);
            WalkWait(222,455);
            WalkWait(220,471);
            WalkWait(223,492);
            WalkWait(227,503);
        }
    }
    private void WalkWait(int x, int y) {
        Walk(x,y);
        Wait(Rand(100,500));
    }
    private void OpenBankDoor(int x,int y) {
        if (Running() == true) {
            Walk(x,y);
            while (ObjectAt(x,y) == 64 && Running() == true) {
                AtObject(x,y);
                Wait(1000);
                DisplayMessage("@gre@SBoT: @whi@Opening bank door...",3);
            }
            Walk(x,y);
        }
        return;
    }
    private void DoBank(int id, int count) {
        while (Bank() == false && Running() == true) {
            while (QuestMenu() == false && Running() == true) {
                TalkToNPC(GetNearestNPC(95));
                long Time = System.currentTimeMillis();
                while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true)
                    Wait(100);
            }
            Answer(0);
            long Time = System.currentTimeMillis();
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true)
                Wait(100);
        }
        while (Bank() == true && Running() == true) {
            while(InvCount(id) > 0) {
                Deposit(id,count);
                Wait(100);
            }
            while(InvCount(157) > 0 && Running() == true) {
                Deposit(157,1);
                Wait(100);
            }
            while(InvCount(158) > 0 && Running() == true) {
                Deposit(158,1);
                Wait(100);
            }
            while(InvCount(159) > 0 && Running() == true) {
                Deposit(159,1);
                Wait(100);
            }
            while(InvCount(160) > 0 && Running() == true) {
                Deposit(160,1);
                Wait(100);
            }
            CloseBank();
        }
        return;
    }
    private void DoMine(int id) {
        while(Running() == true && InvCount() < 30) {
            if(Fatigue() >= 95 && Running() == true) {
                Msg("Sleeping...");
                while(Sleeping() == false && Running() == true) {
                    Use(FindInv(sleepbag));
                    Wait(1000);
                }
                while(Sleeping() == true && Running() == true) {
                    Beep();
                    Wait(1000);
                }
            }
            if(GetNearestObject(id) != null && Running() == true) {
                int rock[] = GetNearestObject(id);
                AtObject(rock[0], rock[1]);
                Wait(1000);
            }
        }
    }
    private void Msg(String str) {
        if(Running() == true) {
            DisplayMessage("@gre@SBoT: @whi@" + str,3);
            Println("SBoT: " + str);
        }
    }
}
