public class Macro_Mage extends Methods {
    public Macro_Mage(mudclient mudclient) {
        super(mudclient);
    }

    public void run() {
        AutoLogin(true);
        int NpcID = StrToInt(GetInput("What is the ID of the npc you want to mage?"));
        int Spell = StrToInt(GetInput("What spell number do you wish to use? Wind strike 0, Confuse 1 etc..."));

        LockMode(StrToInt(GetInput("Fightmode? Controlled 0, Strength 1, Attack 2, Defence 3.")));
        StartScanForMods();
        while (Running()) {
            if (GetFatigue() > 95 && Running()) {
                if (CountInv(1263) == 0) {
                    End("No sleeping bag...");
                }
                while (!Sleeping() && Running()) {
                    UseItem(GetItemPos(1263));
                    Wait(2500);
                }
                while (Sleeping() && Running()) {
                    Wait(100);
                }
            }
            if (!HasRunesForSpell(Spell)) {
                End("You no longer have all the reqquired runes.");
            }
            int[] Npc = GetAllNpcById(NpcID);

            if (Npc[0] != -1) {
                CastOnNpc(Spell, Npc[0]);
                Wait(Rand(2000, 2200));
            } else {
                Wait(10);
            }
            if (GetMaxLvl(3) - GetCurLvl(3) > 12 && Running() && CountInv(373) > 0 && !InCombat()) {
                Display("Eating a lobster");
                Wait(500);
                UseItem(GetItemPos(373));
                Wait(3000);
            }
        }
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
