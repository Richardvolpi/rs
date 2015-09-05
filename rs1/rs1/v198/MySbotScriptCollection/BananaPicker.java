public class BananaPicker extends Script {
    
    private long bananas = 0;
    private long startgp = 0;
    private long changedworlds = 0;
    private long starttime;
    private int world = 51;
    
    public BananaPicker(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"banana"};
    }
    public void start(String command, String parameter[]) {
        starttime = TickCount();
        startgp = InvCount(10);
        Msg("Banana Picker by @ran@eXemplar");
        Msg("@yel@MAKE SURE YOU PRESS F12 FOR AUTO-LOGIN!!!");
        Msg("@red@MAKE SURE YOU HAVE TURNED ON CHAT+PUBLIC+TRADE+DUEL BLOCKS!!!");
        TalkLuthas();
        while(Running()) {
            if (InvCount(249) <= 0 && Running()) {
                Msg("Walking to bananas...");
                while(!CanReach(346,708) && Running()) {
                    OpenDoor(339, 708, 0);
                    Wait(100);
                }
                WalkWait(346,708);
                Msg("Picking bananas...");
                boolean waited = false;
                while(InvCount() < 30 && Running()) {
                    if(GetNearestObject(183)[0] > 0) {
                        AtObject2AndWaitForServerMessage(GetNearestObject(183),10,"you pick a", "there are no");
                    } else {
                        if(waited == true) {
                            Msg("No bananas found,");
                            NextWorld();
                        } else {
                            Msg("Waiting for bananas to respawn...");
                            Wait(10000);
                            waited = true;
                        }
                    }
                }
                Msg("Inventory full, walking to crate...");
                WalkWait(338,711);
            }
            Msg("Putting bananas in crate...");
            while(!CanReach(338,711) && Running()) {
                OpenDoor(339, 708, 0);
                Wait(100);
            }
            while(InvCount(249) > 0  && Running()) {
                WalkWait(338,711);
                int retval = UseOnObjectAndWaitForServerMessage(337,711,249,90,"you put a ", "the crate is ");
                bananas++;
                if (retval == 2 && Running()) {
                    Msg("Crate is full,");
                    TalkLuthas();
                    if(InvCount(249) > 0)
                        Msg("Putting more bananas in crate...");
                }
            }
            PrintStatus();
        }
    }
    private void TalkLuthas() {
        Msg("Talking to Luthas...");
        WalkWait(339,709);
        while(!CanReach(339,705)  && Running()) {
            OpenDoor(339, 708, 0);
            Wait(100);
        }
        int retval = 0;
        while(retval <= 0 && Running()) {
            retval = WaitForNPCMessage(164, 10, "Well done ", "Have you completed ", "Hello i'm ");
            if (retval == 1) {
                WaitForQuestMenu();
                Answer(0);
                WaitForNPCMessage(20,"And there is ");
            }
            if(retval == 2) {
                WaitForQuestMenu();
                Answer(1);
                WaitForNPCMessage(10,"Well come back ");
            }
            if(retval == 3) {
                WaitForQuestMenu();
                Answer(0);
                WaitForNPCMessage(90,"I'll pay you 30 gold");
            }
        }
    }
    private void WalkWait(int x, int y) {
        if (Running()) {
            Walk(x,y);
            Wait(Rand(100,200));
        }
    }
    private void PrintStatus() {
        int minutes = (int)((TickCount() - starttime) / 60000);
        long avg_bananas;
        long avg_gp;
        long gainedgp = InvCount(10) - startgp;
        if (minutes != 0) {
            avg_bananas = (int)((bananas / minutes) * 60);
            avg_gp = (int)((gainedgp / minutes) * 60);
        } else {
            avg_bananas = bananas * 60;
            avg_gp = gainedgp * 60;
        }
        
        Println("*******************************");
        Println("*** Banana Picker Status:");
        Println("*** Worked for " + minutes + " minutes");
        Println("*** Crated " + bananas + " bananas");
        Println("*** Gained " + gainedgp + "gp");
        Println("*** Changed worlds " + changedworlds + " times");
        Println("*** Averaging " + avg_bananas + " bananas/hr");
        Println("*** Averaging " + avg_gp + " gp/hr");
        Println("*******************************");
    }
    private void Msg(String str) {
        if(Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + str,3);
            str = str.replaceAll("@...@", "");
            Println("SBoT: " + str);
        }
    }
    private void NextWorld() {
        Logout();
        while (LoggedIn() && Running())
            Wait(100);
        while(!LoggedIn() && Running()) {
            SelectWorld();
            SetWorld(world);
            Msg("Changing world to " + world + " waiting for autologin...");
            long T = TickCount();
            while ((!LoggedIn() && Running()) || TickCount() - T < 10000)
                Wait(1);
        }
        while(Loading() && Running())
            Wait(100);
        Msg("World changed successfully to " + world);
        changedworlds++;
        Wait(1000);
    }
    private void SelectWorld() {
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
    public void WaitForNPCMessage(int type, int time, String message) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message) < 0  && Running()) {
            ResetLastServerMessage();
            ResetLastNPCMessage();
            int id = GetNearestNPC(type);
            long T = TickCount();
            TalkToNPC(id);
            while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == ""  && Running())
                Wait(100);
            if (LastServerMessage().indexOf("busy") < 0) {
                T = TickCount();
                if (LastNPCMessage() != null)
                    while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000)  && Running())
                        Wait(100);
            }
            Wait(1000);
        }
    }
    public int WaitForNPCMessage(int type, int time, String message1, String message2, String message3) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0 && LastNPCMessage().indexOf(message3) < 0 && Running()) {
            ResetLastServerMessage();
            ResetLastNPCMessage();
            int id = GetNearestNPC(type);
            long T = TickCount();
            TalkToNPC(id);
            while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == ""  && Running())
                Wait(100);
            if (LastServerMessage().indexOf("busy") < 0) {
                T = TickCount();
                if (LastNPCMessage() != null)
                    while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0 && LastNPCMessage().indexOf(message3) < 0 && TickCount() - T < (time * 1000)  && Running())
                        Wait(100);
            }
            Wait(1000);
        }
        if (LastNPCMessage().indexOf(message1) > 0)
            return 1;
        if (LastNPCMessage().indexOf(message2) > 0)
            return 2;
        if (LastNPCMessage().indexOf(message3) > 0)
            return 3;
        else return -1;
    }
    public int WaitForNPCMessage(int type, int time, String message1, String message2) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0  && Running()) {
            ResetLastServerMessage();
            ResetLastNPCMessage();
            int id = GetNearestNPC(type);
            long T = TickCount();
            TalkToNPC(id);
            while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == ""  && Running())
                Wait(100);
            if (LastServerMessage().indexOf("busy") < 0) {
                T = TickCount();
                if (LastNPCMessage() != null)
                    while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0 && TickCount() - T < (time * 1000)  && Running())
                        Wait(100);
            }
            Wait(1000);
        }
        if (LastNPCMessage().indexOf(message1) > 0)
            return 1;
        if (LastNPCMessage().indexOf(message2) > 0)
            return 2;
        else return -1;
    }
    public void WaitForNPCMessage(int time, String message) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message) < 0  && Running()) {
            long T = TickCount();
            if (LastNPCMessage() != null)
                while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000) && Running())
                    Wait(100);
            Wait(1000);
        }
    }
    public void WaitForNPCMessage(int time, String message1, String message2) {
        ResetLastNPCMessage();
        while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0 && Running()) {
            long T = TickCount();
            if (LastNPCMessage() != null)
                while (LastNPCMessage().indexOf(message1) < 0 && LastNPCMessage().indexOf(message2) < 0 && TickCount() - T < (time * 1000) && Running())
                    Wait(100);
            Wait(1000);
        }
    }
    public int UseOnObjectAndWaitForServerMessage(int x, int y, int item, int time, String message1, String message2) {
        ResetLastServerMessage();
        while (LastServerMessage().indexOf(message1) < 0 && LastServerMessage().indexOf(message2) < 0 && LastServerMessage().indexOf("Nothing interesting ") < 0) {
            UseOnObject(x,y,FindInv(item));
            long T = TickCount();
            if (LastServerMessage() != null)
                while (LastServerMessage().indexOf(message1) < 0 && LastServerMessage().indexOf(message2) < 0 && LastServerMessage().indexOf("Nothing interesting ") < 0 &&  TickCount() - T < (time * 1000) && Running())
                    Wait(100);
            Wait(500);
        }
        if (LastServerMessage().indexOf(message1) > 0)
            return 1;
        if (LastServerMessage().indexOf(message2) > 0)
            return 2;
        else return -1;
    }
    public void AtObject2AndWaitForServerMessage(int obj[], int time, String message1, String message2) {
        ResetLastServerMessage();
        while (LastServerMessage().indexOf(message1) < 0 && LastServerMessage().indexOf(message2) < 0 && Running()) {
            AtObject2(obj);
            long T = TickCount();
            if (LastServerMessage() != null)
                while (LastServerMessage().indexOf(message1) < 0 && LastServerMessage().indexOf(message2) < 0 && TickCount() - T < (time * 1000) && Running())
                    Wait(100);
            Wait(500);
        }
    }
    public void WaitForQuestMenu() {
        while (!QuestMenu() && Running())
            Wait(100);
    }
    public void ChatMessage(String message) {
        if (Running() == true) {
            Msg("Anti-Mod protection activated");
            Msg("Chat recieved: " + message);
            PrintStatus();
            Quit();
        }
    }
    
    public void TradeRequest(int PlayerID) {
        if (Running() == true) {
            Msg("Anti-Mod protection activated");
            Msg("Trade recieved from: " + PlayerID);
            PrintStatus();
            Quit();
        }
    }
}