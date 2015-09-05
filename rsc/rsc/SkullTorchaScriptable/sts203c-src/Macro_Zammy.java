public class Macro_Zammy extends Methods {
    public Macro_Zammy(mudclient mc) {
        super(mc);
    }
    private long l;

    public void run() {
        if (GetMaxLvl(6) < 33 && Running()) {
            End("Magic level to low...");
        }
        AutoLogin(true);
        StartScanForMods();
        while (Running()) {
            if (CountInv(42) == 0) {
                End("Script stopped, out of law runes!");
            }
            if (GetY() > 505 && Running()) {
                while (GetIdObject(327, 552) == 64 && Running()) {
                    AtObject(327, 552);
                    Wait(Rand(500, 1000));
                }
                WalkToWait(327, 553);
                WalkToWait(324, 542);
                WalkToWait(321, 527);
                WalkToWait(312, 515);
                WalkToWait(299, 506);
                WalkToWait(306, 497);
                WalkToWait(311, 490);
                WalkToWait(316, 481);
                WalkToWait(312, 470);
                WalkToWait(308, 459);
                WalkToWait(304, 445);
                WalkToWait(310, 436);
                WalkToWait(326, 435);
                WalkToWait(331, 435);
            }
            while (CountInv() < 30 && Running() && CountInv(42) > 0) {
                if (GetFatigue() > 95 && Running() && !InCombat()) { 
                    while (!Sleeping() && Running()) {
                        if (CountInv(1263) == 0) {
                            End("Script stopped, no sleeping bag");
                        }
                        UseItem(GetItemPos(1263)); 
                        Wait(3000); 
                    } 
                    while (Sleeping() && Running()) { 
                        Wait(100);
                    } 
                }
                int[] Wine = GetItemById(501);

                if (Wine[0] != -1) {
                    CastOnGItem(16, Wine[0], Wine[1], Wine[2]);
                    Wait(Rand(1200, 1400));
                } else {
                    Wait(Rand(200, 400));
                }
            }
            WalkToWait(326, 435);
            WalkToWait(310, 436);
            WalkToWait(304, 445);
            WalkToWait(308, 459);
            WalkToWait(312, 470);
            WalkToWait(316, 481);
            WalkToWait(311, 490);
            WalkToWait(306, 497);
            WalkToWait(299, 506);
            WalkToWait(312, 515);
            WalkToWait(321, 527);
            WalkToWait(324, 542);
            while (GetIdObject(327, 552) == 64 && Running()) {
                AtObject(327, 552);
                Wait(Rand(500, 1000));
            }
            WalkToWait(330, 553);
            while (!QuestMenu() && Running()) {
                l = GetMillis();
                int Banker[] = GetNpcById(95);

                if (Banker[0] != -1) {
                    TalkToNpc(Banker[0]);
                }
                while (GetMillis() - l < 5000 && !QuestMenu() && Running()) { 
                    Wait(100);
                }
            }
            Answer(0);
            l = GetMillis();
            while (!InBank() && Running() && GetMillis() - l < 10000) {
                Wait(2000);
            }
            Deposit(501, CountInv(501));
            Wait(1000);
            CloseBank();
            Wait(1000);
        }
        End();
    }
    
    public void OnChatMessage(String sender, String message) {
        sender = sender.toLowerCase();
        if (sender.startsWith("mod ") || sender.equals("andrew") || sender.equals("paul")) {
            Display("A mod was detected!");
            Wait(Rand(2000, 5000));
            Speak("Hey " + sender + " back soon, dinner :P");
            Wait(Rand(2000, 5000));
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message) {
        sender = sender.toLowerCase();
        if (sender.startsWith("mod ") || sender.equals("andrew") || sender.equals("paul")) {
            Display("A mod was detected!");
            Wait(Rand(2000, 5000));
            Die();
        }
    }
    
    public void OnServerMessage(String message) {}
    
}
