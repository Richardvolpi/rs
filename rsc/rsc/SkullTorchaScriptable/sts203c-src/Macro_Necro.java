public class Macro_Necro extends Methods {
    public Macro_Necro(mudclient mc) {
        super(mc);
    }

    public void run() {
        AutoLogin(true);
        int FightMode = StrToInt(GetInput("Fightmode? Controlled 0, Strength 1, Attack 2, Defence 3."));
        int WalkLimit = StrToInt(GetInput("What antiwander limit do you want to use? 0 to disable."));

        Display("Starting NecroFighter");
        int Start[] = new int[2];

        Start[0] = GetX();
        Start[1] = GetY();
        LockMode(FightMode);
        int NpcID[] = { 358, 359};

        StartScanForMods();
        while (Running() && HitsPercent() > 50) {
            while (GetIdWallObject(562, 649) == 2 && Running()) {
                Display("Some nigga closed teh door?");
                AtWallObject(562, 649);
                Wait(1500);
            }
            int Npc[] = GetNpcById(NpcID);

            if (Npc[0] != -1 && !InCombat() && !Sleeping() && Running()) {
                AttackNpc(Npc[0]);
                Wait(Rand(600, 1000));
            } else {
                Wait(10);
            }
            if (GetFatigue() > 90 && Running()) { 
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
            while (InCombat() && Running()) {
                Wait(10);
            }
            while (WalkLimit > 0 && Running() && DistanceTo(Start[0], Start[1]) >= WalkLimit && !InCombat()) {
                WalkToWait(Start[0], Start[1]);
                Wait(2000);
            }
            if (GetMaxLvl(3) - GetCurLvl(3) > 12 && Running() && CountInv(373) > 0 && !InCombat()) {
                Display("Eating a lobster");
                Wait(500);
                UseItem(GetItemPos(373));
                Wait(3000);
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
