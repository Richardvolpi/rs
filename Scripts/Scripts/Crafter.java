public class Crafter extends Script {
    public Crafter(mudclient rs) {
        super(rs);
        
    }
    public String[] getCommands() {
        return new String[]{"crafter"};
    }
    public void start(String command, String parameter[]) {
        Msg("F2P Cow Tanning@bla@-@RED@By@bla@:@GRE@3nvy");
        while (Running()) {
            Msg("Picking up hides");
            while (InvCount() < 30 && Running()) {
                if (GetNearestItem(147) != null) {
                    if(GetNearestItem(147)[0] > 0)
                        TakeItem(GetNearestItem(147),147);
                    Wait(500);
                }
            }
            
            Msg("Walking to border guard");
            OpenThing(105,619,60);
            ForceWalk(102,633);
            ForceWalk(96,649);
            
            Msg("Talking to border guard");
            WaitForNPCMessage(161,25,"You must");
            WaitForQuestMenu();
            Answer(2);
            WaitForServerMessage("The gate");
            Wait(1000);
            
            Msg("Walking to tanner");
            ForceWalk(90,659);
            ForceWalk(85,667);
            ForceWalk(81,673);
            OpenTheDoor(83,674);
            ForceWalk(84,674);
            
            Msg("Talking to tanner");
            WaitForNPCMessage(172,25,"Greetings");
            WaitForQuestMenu();
            Answer(1);
            while (InvCount(147) > 0) {
                Wait(100);
            }
            
            Msg("Making armour");
            while (InvCount(148) > 0 && Running()) {
                UseWithInventory(FindInv(39),FindInv(148));
                WaitForQuestMenu();
                Answer(0);
                WaitForServerMessage("You make");
                Wait(Rand(200,500));
                CheckSleep();
            }
            
            Msg("Walking to bank");
            OpenTheDoor(86,695);
            ForceWalk(80,677);
            ForceWalk(84,691);
            OpenThing(86,695,64);
            ForceWalk(88,695);
            
            Msg("Banking armour");
            BankAll(15,1);
            
            Msg("Walking to border guard");
            OpenThing(86,695,64);
            ForceWalk(84,691);
            ForceWalk(90,677);
            ForceWalk(89,650);
            
            Msg("Talking to border guard");
            WaitForNPCMessage(161,25,"You must");
            WaitForQuestMenu();
            Answer(2);
            WaitForServerMessage("The gate");
            Wait(1000);
            
            Msg("Walking to cow paddock");
            ForceWalk(105,636);
            ForceWalk(105,630);
            ForceWalk(105,619);
            OpenThing(105,619,60);
        }
        
        Msg("F2P Cow Tanning@bla@-@RED@By@bla@:@GRE@3nvy@whi@ STOPPED!");
    }
    public void WaitForNPCMessage(int time, String message) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message) < 0) {
            long T = TickCount();
            if (LastNPCMessage() != null)
                while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
                    Wait(100);
            Wait(1000);
        }
    }
    public void WaitForNPCMessage(int type, int time, String message) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message) < 0) {
            ResetLastServerMessage();
            ResetLastNPCMessage();
            int id = GetNearestNPC(type);
            long T = TickCount();
            TalkToNPC(id);
            while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == "")
                Wait(100);
            if (LastServerMessage().indexOf("busy") < 0) {
                T = TickCount();
                if (LastNPCMessage() != null)
                    while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
                        Wait(100);
            }
            Wait(1000);
        }
    }
    public void WaitForServerMessage(String message) {
        ResetLastServerMessage();
        while (LastServerMessage().indexOf(message) < 0)
            Wait(100);
    }
    public void WaitForQuestMenu() {
        while (!QuestMenu() && Running())
            Wait(100);
    }
    private void BankAll(int id, int count) {
        WaitForNPCMessage(268,10,"Good day,");
        WaitForQuestMenu();
        Answer(0);
        while (!Bank() && Running())
            Wait(100);
        while (Bank() && Running()) {
            while(InvCount(id) > 0) {
                Deposit(id,count);
                Wait(Rand(100,200));
            }
            Wait(1000);
            CloseBank();
        }
    }
    public void OpenThing(int x,int y,int thing) {
        if (Running() == true) {
            while (ObjectAt(x,y) == thing && Running() == true) {
                AtObject(x,y);
                Wait(500);
                Msg("Opening thing");
            }
            ForceWalk(x,y);
        }
    }
    private void OpenTheDoor(int x, int y) {
        while (ObjectAt(x,y) <= 2 && ObjectAt(x,y) >= 1 && Running() == true) {
            OpenDoor(x,y,1);
            Wait(500);
            Msg("Opening door");
        }
        ForceWalk(x,y);
    }
    private void CheckSleep() {
        if(Fatigue() >= 85 && Running()) {
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
                while(Sleeping() && Running() && TickCount() - T < 30000) {
                    Beep();
                    Wait(1000);
                }
                if(Sleeping() && Running())
                    SleepWord();
            }
            Wait(1000);
            Msg("Finished sleeping");
        }
    }
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
}