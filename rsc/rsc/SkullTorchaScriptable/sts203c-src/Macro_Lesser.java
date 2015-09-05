public class Macro_Lesser extends Methods {
    public Macro_Lesser(mudclient mc) {
        super(mc);
    }
    private int[] Npc;

    public void run() {
        AutoLogin(true);
        int SpellID = StrToInt(GetInput("What spell number do you wish to cast?"));

        StartScanForMods();
        while (Running()) {
            if (GetFatigue() > 95 && Running()) {
                while (!Sleeping() && Running()) {
                    if (!InInv(1263)) {
                        End("Stopping script, no sleeping bag.");
                    }
                    UseItem(GetItemPos(1263));
                    Wait(2500);
                }
                while (Sleeping() && Running()) {
                    Wait(100);
                }
            }
            if (!HasRunesForSpell(SpellID)) {
                End("Ran out of runes, stopping script.");
            }
            if (DistanceTo(212, 2582) > 0) {
                WalkToWait(212, 2582);
            } else if ((Npc = GetAllNpcById(22))[0] != -1) {
                CastOnNpc(SpellID, Npc[0]);
                Wait(Rand(2000, 2100));
            } else {
                HopServer(true);
                Wait(1000);
                WalkToWait(212, 2582);
                Wait(1000);
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
    
    public void OnServerMessage(String message) {
        if (IsInStr(message, "standing")) {
            WalkToWait(212, 2581);
        }
    }
}
