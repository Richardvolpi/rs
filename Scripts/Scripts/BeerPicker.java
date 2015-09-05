public class BeerPicker extends Script {
    private int world = 0;
    public BeerPicker(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"beer"};
    }
    public void start(String command, String parameter[]) {
        Msg("Beer Picker by eXemplar");
        Msg("Press F12 to turn auto-login on");
        while(Running() == true) {
            Msg("Picking beers, lololol...");
            PickBeers();
            Msg("Inventory full,");
            Msg("Walking to bank...");
            OpenBankDoor(233,503);
            WalkWait(232,504);
            WalkWait(223,483);
            WalkWait(224,461);
            WalkWait(219,445);
            OpenBankDoor(217,447);
            WalkWait(215,451);
            DoBank(193,1);
            Msg("Walking back...");
            OpenBankDoor(217,447);
            WalkWait(219,445);
            WalkWait(224,461);
            WalkWait(220,471);
            WalkWait(223,483);
            WalkWait(232,504);
            OpenBankDoor(233,503);
            WalkWait(232,501);
        }
    }
    private void PickBeers() {
        while (Running() == true && InvCount() < 30) {
            Wait(1000);            
            if (GetNearestItem(193)[0] > 0) {
                int beerpos[] = GetNearestItem(193);
                TakeItem(beerpos[0], beerpos[1], 193);
            } else {
                NextWorld();
                Wait(2000);
            }
        }
    }
    private void WalkWait(int x, int y) {
        if (Running() == true) {
            Walk(x,y);
            Wait(Rand(100,500));
        }
    }
    public void NextWorld() {
        Msg("Changing world...");
        ChangeWorld();
        Logout();
        SetWorld(world);
        Msg("Changed world to " + world);
        while (LoggedIn() == false && Running() == true)
            Wait(1000);
        Wait(2000);
    }
    private void ChangeWorld() {
        switch(world) {
            case 51:
                world = 53;
                return;
            case 53:
                world = 55;
                return;
            case 55:
                world = 51;
                return;
        }
        world = 51;
        return;
    }
    private void Msg(String str) {
        if(Running() == true) {
            DisplayMessage("@gre@SBoT: @whi@" + str,3);
            Println("SBoT: " + str);
        }
    }
    public void DoBank(int id,int count) {
        while (Bank() == false && Running() == true) {
            while (QuestMenu() == false && Running() == true) {
                int BankerID = GetNearestNPC(95);
                TalkToNPC(BankerID);
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
            CloseBank();
        }
        return;
    }
    public void OpenBankDoor(int x,int y) {
        if (Running() == true) {
            Walk(x,y);
            while (ObjectAt(x,y) == 64 && Running() == true) {
                AtObject(x,y);
                Wait(1000);
                Msg("Opening door");
            }
            Walk(x,y);
        }
        return;
    }
    public boolean isin(int xmin, int ymin, int xmax, int ymax) {
        for(int i = xmin;i < xmax;i++) {
            for(int j = ymin;j < ymax;j++) {
                if(GetX() == i && GetY() == j)
                    return true;
            }
        }
        return false;
    }
}
