public class Macro_Spiders extends Methods {
    public Macro_Spiders(mudclient mc) {
        super(mc);
    }
    private long l;
    private long Exp;
    private int ID;
    private int heal;
 
    public void run() {
        String s = GetInput("What type of food do you want to use? [lobster/shark]");

        if (s.equalsIgnoreCase("lobster")) {
            ID = 373;
            heal = 12;
        } else if (s.equalsIgnoreCase("shark")) {
            ID = 546;
            heal = 20;
        } else {
            End("Invalid food type");
        }
        AutoLogin(true);
        int Fmode = StrToInt(GetInput("Fightmode? Controlled 0, Strength 1, Attack 2, Defence 3."));

        LockMode(Fmode);
        int[] Start = { 536, 759};
        int Limit = 7;
        int num = 3;

        switch (Fmode) {
        case 0:
            num = 3;
            break;

        case 1:
            num = 2;
            break;

        case 2:
            num = 0;
            break;

        case 3:
            num = 1;
            break;
        }
        Exp = GetExp(num);
        StartScanForMods();
        while (Running()) {
            if (GetX() > 579 && Running()) {
                WalkToWait(587, 753);
                WalkToWait(579, 745);
                WalkToWait(562, 747);
                WalkToWait(547, 748);
                WalkToWait(539, 750);
            }
            WalkToWait(Start[0], Start[1]);
            while (CountInv(ID) > 0 && Running()) {
                int Npc[] = GetNpcById(521);

                if (Npc[0] != -1 && !InCombat() && !Sleeping() && Running()
                        && DistanceTo(Npc[1], Npc[2], Start[0], Start[1]) < Limit + 2) {
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
                if ((GetMaxLvl(3) - GetCurLvl(3)) > heal && Running() && CountInv(ID) > 0) {
                    UseItem(GetItemPos(ID));
                    Wait(2000);
                }
                while (Running() && DistanceTo(Start[0], Start[1]) > Limit && !InCombat()) {
                    WalkToWait(Start[0], Start[1]);
                    Wait(2000);
                }
            }
            WalkToWait(539, 750);
            WalkToWait(547, 748);
            WalkToWait(562, 747);
            WalkToWait(579, 745);
            WalkToWait(587, 753);
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
            while (CountInv() < 30 && Running()) {
                Withdraw(ID, 1);
                Wait(300);
            }
            CloseBank();
            Wait(500);
            Display("Exp gained so far ( " + Time() + " ): " + IntToStr((GetExp(num) - Exp) * (num == 3 ? 3 : 1)));
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
