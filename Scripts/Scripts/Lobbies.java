/* Ultimate Lobbier, Maenz.
 *
 * - Usage /run lobbies type@quest
 *
 * Start on Karamja island jetty, with lobster pot, sleeping bag,
 *    and enough gold to get back for at least one trip.
 *
 * - MAKE SURE YOU TURN CHAT+TADE BLOCKS ON!!!
 */

/* type: 1,2,3,4
 * 1 = power fish
 * 2 = fish + bank raw
 * 3 = power fish + cook
 * 4 = fish + cook + bank cooked
 */

/* quest: 1,2
 * 1 = done dragon slayer
 * 2 = haven't done ds quest
 */

public class Lobbies extends Script {
   
    private int cook_lobbies = 0;
    private int bank_lobbies = 0;
    private int done_ds_quest = 0;
   
    private int raw_lobbie_id = 372;
    private int cooked_lobbie_id = 373;
    private int burnt_lobbie_id = 374;
    private int lobbiepot_id = 375;
    private int custom_officer_id = 163;
    private int captain_id = 166;
    private int range_id = 11;
    private int sleepingbag_id = 1263;
    private int gold_id = 10;
    private int banker_id = 95;
   
    private long start_time = 0;
    private int slept = 0;
    private int banked = 0;
    private int lobbies_fished = 0;
    private int lobbies_cooked = 0;
    private int lobbies_banked = 0;
    private int fishing_exp = 0;
    private int cooking_exp = 0;
    private int fishing_lvl = 0;
    private int cooking_lvl = 0;
   
    private long start_fishxp;
    private long start_cookxp;
    private int start_fishlvl;
    private int start_cooklvl;
   
    public Lobbies(mudclient poonscape) {
        super(poonscape);
    }
    public String[] getCommands() {
        return new String[]{"lobbies"};
    }
    public void start(String cmd, String params[]) {
        Msg("Ultimate Lobbier - by @ran@e@ran@X@ran@e@ran@m@ran@p@ran@l@ran@a@ran@r");
       
        if (params == null) {
            ShowUsage();
            return;
        }
       
        if (params.length < 1) {
            ShowUsage();
            return;
        }
        switch(Integer.parseInt(params[0])) {
            case 1:
                Msg("Power fishing lobbies");
                break;
            case 2:
                Msg("Fishing & Banking raw lobbies");
                bank_lobbies = 1;
                break;
            case 3:
                Msg("Fishing & Cooking lobbies");
                cook_lobbies = 1;
                break;
            case 4:
                Msg("Fishing & Cooking & Banking lobbies");
                cook_lobbies = 1;
                bank_lobbies = 1;
                break;
            default:
                ShowUsage();
                return;
        }
       
        if (Integer.parseInt(params[0]) != 1 && params.length == 2) {
            switch(Integer.parseInt(params[1])) {
                case 1:
                    Msg("Done Dragon Slayer Quest");
                    done_ds_quest = 1;
                    break;
                case 2:
                    Msg("Haven't done Dragon Slayer Quest");
                    done_ds_quest = 2;
                    break;
                default:
                    ShowUsage();
                    return;
            }
        }
        if (FindInv(lobbiepot_id) < 0) {
            Msg("You must have a lobster pot in your inventory!");
            return;
        }
        if(FindInv(sleepingbag_id) < 0) {
            Msg("You must have a sleeping bag in your inventory!");
            return;
        }
        start_fishxp = GetExperience(10);
        start_cookxp = GetExperience(7);
        start_fishlvl = GetStat(10);
        start_cooklvl = GetStat(7);
        start_time = TickCount();
        PrintStats(1);
        while (Running()) {
            FishLobbies();
            if (InvCount(raw_lobbie_id) > 0)
                lobbies_fished += InvCount(raw_lobbie_id);
            if (cook_lobbies == 1) {
                WalkToPortSarimFromKaramja();
                CookLobbies();
            }
            if (InvCount(cooked_lobbie_id) > 0)
                lobbies_cooked += InvCount(cooked_lobbie_id);
            DropLobbies(cook_lobbies);
            if (bank_lobbies == 1) {
                if (cook_lobbies == 1) {
                    WalkToDraynorFromPortSarim();
                    if (InvCount(cooked_lobbie_id) > 0)
                        lobbies_banked += InvCount(cooked_lobbie_id);
                    WalkRan(220,636);
                    DoBank(cooked_lobbie_id,1);
                } else {
                    WalkToDraynorFromKaramja();
                    if (InvCount(raw_lobbie_id) > 0)
                        lobbies_banked += InvCount(raw_lobbie_id);
                    WalkRan(220,636);
                    DoBank(raw_lobbie_id,1);
                }
                WalkToKaramjaFromDraynor();
            }
            else {
                WalkToKaramjaFromPortSarim();
            }
            if (Running() == true)
                PrintStats(0);
        }
        PrintStats(0);
        Wait(1000);
        Msg("Karamja Lobbie Powerfish+Cook+Bank Stopped.");
    }
    private void TalkToCaptain() {
        WaitForNPCMessage(captain_id,10,"Do you want to");
        WaitForQuestMenu();
        if (done_ds_quest == 1)
            Answer(0);
        else
            Answer(1);
        while(Loading() && Running())
            Wait(100);
        WaitForServerMessage(90,"The ship arrives");
    }
    private void TalkToCustomsOfficer() {
        ResetLastNPCMessage();
        while(LastNPCMessage().indexOf("You need to be") < 0 && Running()) {
            ResetLastNPCMessage();
            AtObject(326,710);
            Wait(500);
        }
        WaitForQuestMenu();
        Answer(1);
        WaitForNPCMessage(15,"Now you need to");
        WaitForQuestMenu();
        Answer(0);
        WaitForServerMessage(90,"The ship arrives");
    }
   
    private void WalkToKaramjaFromDraynor()  {
        Msg("Walking to Karamja from Draynor...");
        while(!CanReach(227,631) && Running()) {
            AtObject(219,633);
            Wait(500);
        }
        WalkRan(227,631);
        WalkRan(242,615);
        WalkRan(264,622);
        WalkRan(269,634);
        WalkRan(269,646);
        TalkToCaptain();
        WalkRan(341,710);
        WalkRan(354,710);
        WalkRan(354,710);
        WalkRan(371,703);
        WalkRan(370,683);
        WalkRan(371,685);
    }
    private void WalkToDraynorFromKaramja() {
        Msg("Walking to Draynor from Karamja...");
        WalkRan(371,692);
        WalkRan(369,703);
        WalkRan(353,710);
        WalkRan(339,712);
        Walk(334,713);
        TalkToCustomsOfficer();
        WalkRan(269,633);
        WalkRan(267,621);
        WalkRan(250,611);
        WalkRan(237,620);
        WalkRan(226,631);
        while(!CanReach(220,636) && Running()) {
            AtObject(219,633);
            Wait(500);
        }
    }
    private void WalkToPortSarimFromKaramja() {
        Msg("Walking to Port Sarim from Karamja...");
        WalkRan(371,692);
       
        WalkRan(369,703);
        WalkRan(353,710);
        WalkRan(339,712);
        Walk(334,713);
        TalkToCustomsOfficer();
        WalkRan(276,635);
        while(ObjectAt(276, 637) == 2 && Running()) {
            OpenDoor(276, 637, 0);
            Wait(500);
        }
        WalkRan(276,638);
    }
    private void WalkToKaramjaFromPortSarim() {
        Msg("Walking to Karamja from Port Sarim...");
        WalkRan(276,638);
        while(ObjectAt(276, 637) == 2 && Running()) {
            OpenDoor(276, 637, 0);
            Wait(500);
        }
        WalkRan(269,646);
        TalkToCaptain();
        WalkRan(334,713);
        WalkRan(339,712);
        WalkRan(345,710);
        WalkRan(353,710);
        WalkRan(369,703);
        WalkRan(371,692);
        WalkRan(371,685);
    }
    private void WalkToDraynorFromPortSarim() {
        Msg("Walking to Draynor from Port Sarim...");
        while(ObjectAt(276, 637) == 2 && Running()) {
            OpenDoor(276, 637, 0);
            Wait(500);
        }
        ForceWalk(276,635);
        Wait(200);
        WalkRan(267,621);
        WalkRan(250,611);
        WalkRan(237,620);
        WalkRan(226,631);
    }
   
    private void FishLobbies() {
        Msg("Fishing lobbies...");
        while(InvCount() < 30 && Running()) {
            int numInv = InvCount();
            int place = Rand(1,2);
            Msg("Caging at place " + place);
            while(numInv == InvCount() && Running()) {
                if (place == 1)
                    AtObject2(370,678);
                else
                    AtObject2(368,684);
                long Time = TickCount();
                while(numInv == InvCount() && TickCount() - Time < 3000 && Running())
                    Wait(100);
                CheckSleep();
            }
        }
        if (InvCount() == 30)
            Msg("Inventory full,");
    }
    private void CookLobbies() {
        Msg("Cooking lobbies...");
        while(InvCount(raw_lobbie_id) > 0 && Running() && GetNearestObject(range_id)[0] > 0) {
            if(FindInv(raw_lobbie_id) > 0) {
                UseOnObject(GetNearestObject(range_id)[0], GetNearestObject(range_id)[1], FindInv(raw_lobbie_id));
                Wait(1000);
            }
            Wait(500);
            CheckSleep();
        }
    }
    private void DropLobbies(int iscooking) {
        Msg("Dropping lobbiess...");
        if (Running()) {
            if (iscooking == 0 && bank_lobbies == 0) {
                DropAll(cooked_lobbie_id);
                DropAll(raw_lobbie_id);
            }
            DropAll(burnt_lobbie_id);
        }
    }
    private void DropAll(int id) {
        int finv = InvCount();
        while(InvCount(id) > 0 && Running()) {
            int pinv = InvCount();
            while(pinv == InvCount() && Running()) {
                Drop(FindInv(id));
                long Time = TickCount();
                while (pinv == InvCount() && TickCount() - Time <= 3000 && Running())
                    Wait(100);
                Wait(100);
            }
            Wait(100);
        }
    }
   
    private void ShowUsage() {
        Msg("Usage /run lobbies type@quest");
        Msg("Where type = 1,2,3,4");
        Println("type = 1, power fish.");
        Println("type = 2, fish + bank raw.");
        Println("type = 3, power fish + cook.");
        Println("type = 4, fish + cook + bank cooked.");
        Msg("Where quest = 1,2");
        Println("quest = 1, done dragon slayer quest.");
        Println("quest = 2, haven't dragon slayer quest.");
        Println("You don't have to enter quest if type = 1.");
    }
    private void Msg(String msg) {
        if (Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + msg,3);
            Println("SBoT: " + msg.replaceAll("@...@",""));
        }
    }
    private void CheckSleep() {
        if(Fatigue() >= 85 && Running()) {
            Msg("Sleeping...");
            while(!Sleeping() && Running()) {
                Use(FindInv(sleepingbag_id));
                long Time = TickCount();
                while(!Sleeping() && TickCount() - Time < 3000 && Running())
                    Wait(1);
            }
            Msg("Waiting for sleep word...");
            while(Sleeping() && Running()) {
                Beep();
                Wait(1000);
            }
            Wait(1000);
            Msg("Finished sleeping");
            slept++;
        }
    }
    public void WalkRan(int x, int y) {
        while(Loading() && Running())
            Wait(100);
        if (Running() == true) {
            Walk(x,y);
            //WalkEmpty(x - 1, y - 1, x + 1, y + 1);
            //ForceWalk(Rand(x - 1,x + 1),Rand(y - 1,y + 1));
            Wait(Rand(100,250));
        }
    }
    public void WaitForQuestMenu() {
        while (!QuestMenu() && Running())
            Wait(100);
    }
    private void DoBank(int id, int count) {
        Msg("Banking...");
        WaitForNPCMessage(banker_id,10,"Good day,");
        WaitForQuestMenu();
        Answer(0);
        while (!Bank() && Running())
            Wait(100);
        while (Bank() && Running()) {
            while(InvCount(id) > 0) {
                Deposit(id,count);
                Wait(Rand(100,200));
            }
            if (done_ds_quest == 2 && InvCount(gold_id) < 60) {
                Withdraw(gold_id,100);
                Wait(Rand(100,200));
            }
            Wait(1000);
            CloseBank();
        }
        banked++;
    }
    private void PrintStats(int start) {
        Msg("Printing start statistics to console...");
        Println("******* Karamja Lobbie Powerfish+Cook+Bank Stats *******");
        if (start == 1) {
            Println("*** Start fishing exp: " + start_fishxp);
            Println("*** Start cooking exp: " + start_cookxp);
            Println("*** Start fishing level: " + start_fishlvl);
            Println("*** Start cooking level: " + start_cooklvl);
        } else {
            int minutes = (int)((TickCount() - start_time) / 60000);
            Println("*** Worked for " + minutes + " minutes");
            Println("*** Slept " + slept + " times");
            Println("*** Banked " + banked + " times");
            Println("*** Fished " + lobbies_fished + " lobbies");
            Println("*** Cooked " + lobbies_cooked + " lobbies" );
            Println("*** Banked " + lobbies_banked + " lobbies" );
            Println("*** Gained " + (GetExperience(10) - start_fishxp) + " fishing exp");
            Println("*** Gained " + (GetExperience(7) - start_cookxp) + " cooking exp");
            Println("*** Gained " + (GetStat(10) - start_fishlvl) + " fishing levels");
            Println("*** Gained " + (GetStat(7) - start_cooklvl) + " cooking levels");
            if (minutes > 0) {
                Println("*** Averaging " + (((GetExperience(10) - start_fishxp) / minutes) * 60) + " fishing exp/hr");
                Println("*** Averaging " + (((GetExperience(7) - start_cookxp) / minutes) * 60) + " cooking exp/hr");
                Println("*** Averaging " + ((lobbies_fished / minutes) * 60) + " lobbies fished/hr");
                Println("*** Averaging " + ((lobbies_cooked / minutes) * 60) + " lobbies cooked/hr");
                Println("*** Averaging " + ((lobbies_banked / minutes) * 60) + " lobbies banked/hr");
               
            }
        }
        Println("********************************************************");
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
    public void WaitForServerMessage(int time, String message) {
        ResetLastServerMessage();
        while (LastServerMessage().indexOf(message) < 0) {
            long T = TickCount();
            T = TickCount();
            while (LastServerMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
                Wait(100);
        }
    }
    public void ChatMessage(String message) {
        if (Running() == true) {
            Msg("Anti-Mod protection activated");
            Msg("Chat recieved: " + message);
            PrintStats(0);
            Quit();
        }
    }
    public void TradeRequest(int PlayerID) {
        if (Running() == true) {
            Msg("Anti-Mod protection activated");
            Msg("Trade recieved from: " + PlayerID);
            PrintStats(0);
            Quit();
        }
    }
}