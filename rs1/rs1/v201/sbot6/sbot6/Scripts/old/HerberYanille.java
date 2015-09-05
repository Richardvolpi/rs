//435:Herb Marrentil unid
//436:Herb Tarromin unid
//437:Herb Harralander unid
//438:Herb Ranarr unid
//439:Herb Irit unid
//440:Herb Avantoe unid
//441:Herb Kwuarm unid
//442:Herb Cadantine unid
//443:Herb Dwarf weed unid

public class HerberYanille extends Script {
    int herbs[] = {438,439,440,441,442,443,42,33,40};
    public HerberYanille(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"herb"};
    }
    public void start(String command, String parameter[]) {
        if (parameter.length != 1) {
            DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN herb [STYLE]", 3);
        } else {
            int FightMode = Integer.parseInt(parameter[0]);
            int FightTime = 750;
            int FightType = 270;
            CheckFighters(true);
            DisplayMessage("@gre@Bruncle: @whi@AutoFighter - RichyT", 3);
            while (Running() == true) {
                if (GetCurrentStat(3) / GetStat(3) < 50)
                    eatCakes();
                if (GetFightMode() != FightMode) {
                    SetFightMode(FightMode);
                    DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
                }
                if (InCombat() == false) {
                    if (Fatigue() > 97 && Sleeping() == false) {
                        DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                        while (!Sleeping()){
                            Use(FindInv(1263));
                            Wait(5000);
                        }
                        while (Sleeping())
                            Wait(2000);
                    }
                    if (Sleeping() == false) {
                        int loop = 0;
                        while (loop < herbs.length && Running() && InvCount() < 30){
                            int id = herbs[loop];
                            while (validCoOrd(GetNearestItem(id))){
                                TakeItem(GetNearestItem(id)[0],GetNearestItem(id)[1],id);
                                Wait(500);
                            }
                            loop ++;
                        }
                        int ID = GetNearestNPC(FightType);
                        if (ID != -1) {
                            long T = System.currentTimeMillis();
                            SetFightMode(FightMode);
                            AttackNPC(ID);
                            while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
                                Wait(1);
                        }
                        if (InvCount() == 30) {
                            WalkAndBank();
                        }
                    }
                    
                } else {
                    while (InCombat() == true && Running() == true)
                        Wait(1);
                }
            }
            DisplayMessage("@gre@Bruncle: @whi@Herb Picker - @red@STOPPED", 3);
        }
    }
    
    int maxX = 591;
    int minX = 576;
    int maxY = 3589;
    int minY = 3582;
    
    public boolean validCoOrd(int[] coords){
        return (coords[0] < maxX && coords[0] > minX && coords[1] < maxY && coords[1] > minY);
    }
    
    public void WalkAndBank(){
        if (Running()) {
            DisplayMessage("Banking",3);
            Wait(2000);
            Walk(593,3589);
            Wait(3000);
            while(!CanReach(593,3592) && Running()) {
                CloseDoor(593,3590,0);
                Wait(1000);
            }
            Wait(1000);
            while (GetY() > 3000 && Running()) {
                AtObject(591,3593);
                Wait(1000);
            }
            Wait(2000);
            while (!CanReach(586,752)){
                OpenDoor(591, 765, 0);
                Wait(500);
                ForceWalkNoWait(586,752);
                Wait(500);
            }
            Walk(586,752);
            Wait(5000);
            while(!QuestMenu()) {
                long l = System.currentTimeMillis();
                int bankerID = GetNearestNPC(95);
                TalkToNPC(bankerID);
                while(System.currentTimeMillis() - l <= 2000 && !QuestMenu())
                    Wait(1);
            }
            Wait(3000);
            Answer(0);
            while (! Bank())
                Wait(100);
            while (Bank()) {
                int loop = 0;
                while(loop < herbs.length && Running()){
                    while (InvCount(herbs[loop]) > 0) {
                        Deposit(herbs[loop],1);
                        Wait(200);
                    }
                    loop++;
                }
                if (BankCount(330)>=3)
                    while (InvCount(303) < 3){
                        Withdraw(330,1);
                        Wait(100);
                    }
                CloseBank();
            }
            if (Running()){
                Wait(1500);
                while (!CanReach(590,762)){
                    OpenDoor(591, 765, 0);
                    Wait(500);
                    ForceWalkNoWait(590,762);
                    Wait(500);
                }
                Walk(590,762);
                Wait(2000);
                while (GetY() < 3000){
                    AtObject(591,761);
                    Wait(2000);
                }
                Walk(593,3590);
                Wait(2000);
            }
            while(!CanReach(593,3589) && Running()){
                CloseDoor(593,3590,0);
                Wait(1000);
            }
            Wait(2000);
            ForceWalk(585,3586);
            DisplayMessage("Killing druids..",3);
        }
    }
    int foodID[] = {330,333,335};
    int food;
    public void eatCakes(){
        while(GetCurrentStat(3) / GetStat(3) < 50){
            if (InvCount(foodID[0]) > 0) {
                food = FindInv(foodID[0]);
            }
            if (InvCount(foodID[1]) > 0) {
                food = FindInv(foodID[1]);
            }
            if (InvCount(foodID[2]) > 0) {
                food = FindInv(foodID[2]);
            }
            Use(food);
            Wait(1000);
        }
    }
}