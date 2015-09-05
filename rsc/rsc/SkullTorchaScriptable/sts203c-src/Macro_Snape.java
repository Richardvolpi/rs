public class Macro_Snape extends Methods {
    public Macro_Snape(mudclient mc) {
        super(mc);
    }
    private long l;

    public void run() {
        AutoLogin(true);
        StartScanForMods();
        while (Running()) {
            if (GetY() < 580 && Running()) {
                while (GetIdObject(287, 571) == 64 && Running()) {
                    AtObject(287, 571);
                    Wait(Rand(500, 1000));
                }
                WalkToWait(291, 581);
                WalkToWait(303, 596);
                WalkToWait(316, 603);
                WalkToWait(330, 611);
                WalkToWait(334, 621);
                WalkToWait(347, 619);
                WalkToWait(356, 617);
                WalkToWait(362, 607);
            }
            while (CountInv() < 30 && Running()) {
                int[] Snape = GetItemById(469);

                if (Snape[0] != -1 && Snape[2] < 604) {
                    PickupItem(Snape[1], Snape[2], Snape[0]);
                    Wait(Rand(600, 1200));
                } else {
                    Wait(100);
                }
            }
            WalkToWait(362, 607);
            WalkToWait(356, 617);
            WalkToWait(347, 619);
            WalkToWait(334, 621);
            WalkToWait(330, 611);
            WalkToWait(316, 603);
            WalkToWait(303, 596);
            WalkToWait(291, 581);
            WalkToWait(287, 572);
            while (GetIdObject(287, 571) == 64 && Running()) {
                AtObject(287, 571);
                Wait(Rand(500, 1000));
            }
            WalkToWait(285, 570);
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
                Wait(1000);
            }
            l = GetMillis();
            if (CountInv(469) > 24 && Running() && InBank()) {
                Deposit(469, 25);
                Wait(Rand(300, 400));
            }
            while (CountInv(469) > 0 && Running() && GetMillis() - l < 20000 && InBank()) {
                Deposit(469, 1);
                Wait(Rand(300, 400));
            }
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
