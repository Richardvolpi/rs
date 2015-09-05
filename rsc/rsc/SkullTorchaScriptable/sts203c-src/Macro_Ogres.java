public class Macro_Ogres extends Methods {
    public Macro_Ogres(mudclient mc) {
        super(mc);
    }
    private long l;
 
    public void run() {
        AutoLogin(true);
        LockMode(StrToInt(GetInput("Fightmode? Controlled 0, Strength 1, Attack 2, Defence 3.")));
        Display("Starting script at " + Time());
        StartScanForMods();
        while (Running()) {
            if (GetX() < 640 && Running()) {
                WalkToWait(583, 752);
                WalkToWait(590, 748);
                WalkToWait(603, 749);
                WalkToWait(617, 756);
                WalkToWait(628, 755);
                WalkToWait(640, 753);
                while (GetIdObject(642, 753) == 64 && Running()) {
                    AtObject(642, 753);
                    Wait(Rand(1000, 1500));
                }
                WalkToWait(646, 753);
                while (GetIdObject(647, 753) == 64 && Running()) {
                    AtObject(647, 753);
                    Wait(Rand(1000, 1500));
                }
                WalkToWait(652, 745);
                WalkToWait(657, 734);
                WalkToWait(661, 732);
            }
            while (CountInv(546) > 1 && Running()) {
                int Npc[] = GetNpcById(706);

                if (Npc[0] != -1 && !InCombat() && !Sleeping() && Running() && Npc[2] < 743) {
                    AttackNpc(Npc[0]);
                    Wait(Rand(600, 1000));
                } else {
                    Wait(10);
                }
                while (InCombat() && Running()) {
                    Wait(10);
                }
                if (GetFatigue() > 90 && Running() && !InCombat()) { 
                    while (!Sleeping() && Running()) {
                        if (CountInv(1263) == 0) {
                            End("Script stopped, no sleeping bag - " + Time());
                        }
                        UseItem(GetItemPos(1263)); 
                        Wait(3000); 
                    } 
                    while (Sleeping() && Running()) { 
                        Wait(100);
                    } 
                }
                if ((GetMaxLvl(3) - GetCurLvl(3)) > 25 && Running() && CountInv(546) > 0) {
                    UseItem(GetItemPos(546));
                    Wait(2000);
                }
                while (Running() && DistanceTo(661, 733) > 15 && !InCombat()) {
                    WalkToWait(661, 733);
                    Wait(2000);
                }
            }
            WalkToWait(657, 734);
            WalkToWait(652, 745);
            while (GetIdObject(647, 753) == 64 && Running()) {
                AtObject(647, 753);
                Wait(Rand(1000, 1500));
            }
            WalkToWait(645, 753);
            while (GetIdObject(642, 753) == 64 && Running()) {
                AtObject(642, 753);
                Wait(Rand(1000, 1500));
            }
            WalkToWait(640, 753);
            WalkToWait(628, 755);
            WalkToWait(617, 756);
            WalkToWait(603, 749);
            WalkToWait(590, 748);
            WalkToWait(583, 752);
            while (CountInv() < 30 && Running()) {
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
                while (CountInv() < 30 && Running() && InBank()) {
                    Withdraw(546, 1);
                    Wait(Rand(300, 600));
                }
                CloseBank();
                Wait(500);
            }
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
