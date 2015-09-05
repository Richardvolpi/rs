public class Macro_STFighter extends Methods {
    public Macro_STFighter(mudclient mc) {
        super(mc);
    }

    private int CountArgs(String s) {
        int count = 1;

        while (s.indexOf(",") > -1) {
            count++;
            s = s.substring(s.indexOf(",") + 1);
        }
        return count;
    }
    
    private String Args(String s, int pos) {
        if (pos == 1) {
            String temp = s.substring(s.indexOf("(") + 1);

            if (temp.indexOf(",") > -1) {
                return temp.substring(0, temp.indexOf(","));
            } else {
                return temp.substring(0, temp.indexOf(")"));
            }
        } else if (pos == 2) {
            String temp = s.substring(s.indexOf(",") + 1);

            if (temp.indexOf(",") > -1) {
                return temp.substring(0, temp.indexOf(","));
            } else {
                return temp.substring(0, temp.indexOf(")"));
            }
        } else if (pos >= 3) {
            String temp = s.substring(s.indexOf(",") + 1);

            for (int a = 2; a < pos; a++) {
                temp = temp.substring(temp.indexOf(",") + 1);
            }
            if (temp.indexOf(",") > -1) {
                return temp.substring(0, temp.indexOf(","));
            } else {
                return temp.substring(0, temp.indexOf(")"));
            }
        }
        return null;
    }
    
    private int[] Split(String s) {
        String temp = "(" + s + ")";
        int len = CountArgs(temp);
        int[] t = new int[len];

        for (int x = 0; x < len; x++) {
            t[x] = StrToInt(Args(temp, x + 1));
        }
        return t;
    }

    public void run() {
        Display("Starting STFighter");
        String s = GetInput("Please enter the NPC IDs you wish to fighter, seperated by commas.");
        int[] NpcID = Split(s);
        int FightMode = StrToInt(GetInput("Fightmode? Controlled 0, Strength 1, Attack 2, Defence 3."));
        int WalkLimit = StrToInt(GetInput("What antiwander limit would you like to use? 0 to disable."));

        AutoLogin(true);
        int Start[] = new int[2];

        Start[0] = GetX();
        Start[1] = GetY();
        LockMode(FightMode);
        StartScanForMods();
        while (Running() && HitsPercent() > 50) {
            int Npc[] = GetNpcById(NpcID);

            if (Npc[0] != -1 && !InCombat() && !Sleeping() && Running()) {
                AttackNpc(Npc[0]);
                Wait(Rand(800, 1000));
            } else if (WalkLimit > 0 && !InCombat() && DistanceTo(Start[0], Start[1]) > 0) {
                WalkToWait(Start[0], Start[1]);
            } else {
                Wait(10);
            }
            while (GetFatigue() > 90 && Running()) { 
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
                Wait(100);
            }
            if (GetMaxLvl(3) - GetCurLvl(3) > 12 && Running() && CountInv(373) > 0 && !InCombat()) {
                Display("Eating lobster");
                Wait(500);
                UseItem(GetItemPos(373));
                Wait(3000);
            }
        }
        End("Hits dropped below 50%");
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
