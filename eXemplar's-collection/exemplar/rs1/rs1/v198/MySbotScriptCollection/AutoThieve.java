public class AutoThieve extends Script {
    public AutoThieve(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"thieve"};
    }
    public void start(String command, String parameter[]) {
        if (parameter.length != 2) {
            DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN THIEVE [FIGHT STYLE] [NPC TYPE]", 3);
        } else {
            int FightMode = Integer.parseInt(parameter[0]);
            int ThieveType = Integer.parseInt(parameter[1]);
            CheckFighters(true);
            int X = GetX();
            int Y = GetY();
            DisplayMessage("@gre@SBoT: @whi@AutoThiever - HipyHop", 3);
            while (Running() == true && GetCurrentStat(3) > 5) {
                if (GetFightMode() != FightMode) {
                    SetFightMode(FightMode);
                    DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
                }
                if (InCombat() == false) {
                    if (Fatigue() > 97 && Sleeping() == false) {
                        DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                        Use(FindInv(1263));
                        Wait(1000);
                    } else {
                        if (Sleeping() == false) {
                            int ID = GetNearestNPC(ThieveType);
                            if (ID != -1) {
                                ThieveNPC(ID);
                                Wait(Rand(750,1000));
                            } else {
                                WalkNoWait(X,Y);
                                Wait(Rand(1000,1500));
                            }
                        } else {
                            Beep();
                        }
                    }
                } else {
                    // WalkNoWait(GetX(),GetY());
                    Wait(Rand(1000,1500));
                }
            }
        }
        DisplayMessage("@gre@SBoT: @whi@AutoThiever - @red@STOPPED", 3);
    }
}