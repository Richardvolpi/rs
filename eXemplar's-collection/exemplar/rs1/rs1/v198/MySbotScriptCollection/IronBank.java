
public class IronBank extends Script {
    
    public IronBank(mudclient mudclient) {
        super(mudclient);
    }
    
    public String[] getCommands() {
        return new String[]{"mineiron"};
    }
    
    public void start(String s, String as[]) {
        DisplayMessage("@or2@SBoT: @whi@Iron Miner + Banker", 3);
        
        while(Running() == true) {
            DisplayMessage("@or2@SBoT: @whi@Mining...",3);
            while(Running() == true && InvCount() < 30) {
                if(Fatigue() >= 95 && Running() == true) {
                    DisplayMessage("@or2@SBoT: @whi@Sleeping",3);
                    while(Sleeping() == false) {
                        Use(FindInv(1263));
                        Wait(100);
                    }
                    while(Sleeping() == true)
                        Wait(1000);
                }
                int ai[] = GetNearestObject(102);
                AtObject(ai[0], ai[1]);
                Wait(1000);
            }
            DisplayMessage("@or2@SBoT: @whi@Walking to bank...",3);
            WalkRan(72,539, 1, 100);
            WalkRan(73,528, 1, 100);
            WalkRan(80,519, 1, 100);
            WalkRan(85,510, 1, 100);
            WalkRan(95,509, 1, 100);
            Walk(99,508);
            Wait(1000);
            OpenBankDoor(102,509);
            DisplayMessage("@or2@SBoT: @whi@Depositing...",3);
            DoBank();
            DisplayMessage("@or2@SBoT: @whi@Walking to mining spot...",3);
            Walk(99,508);
            WalkRan(95,509, 1, 100);
            WalkRan(85,510, 1, 100);
            WalkRan(80,519, 1, 100);
            WalkRan(73,528, 1, 100);
            WalkRan(72,539, 1, 100);
            WalkRan(76,545, 1, 100);
        }
        
        DisplayMessage("@or2@SBoT: @whi@Tin Miner + Banker - @red@STOPPED", 3);
    }
    public void DoBank() {
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
            while(InvCount(151) > 0 && Running() == true) {
                Deposit(151,1);
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
    }
    public void OpenBankDoor(int x,int y) {
        if (Running() == true) {
            Walk(x,y);
            while (ObjectAt(x,y) == 64 && Running() == true) {
                DisplayMessage("@gre@SBoT: @whi@Opening bank door",3);
                AtObject(x,y);
                Wait(1000);
            }
            Walk(x,y);
        }
    }
    public void WalkRan(int x, int y, int diff, int endwait) {
        if (Running() == true) {
            Walk(Rand(x - diff,x + diff),Rand(y - diff,y + diff));
            Wait(endwait);
        }
    }
}
