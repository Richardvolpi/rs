//Hulkkii's Jailguard
public class JailGuard extends Script {
    private int died = -1;
    private int killed = -1;
    private int FMode;
    private int FTime = 200;
    public JailGuard(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"jguard"};
    }
    public void start(String command, String parameter[]) {
        CheckFighters(true);
        FMode = Integer.parseInt(parameter[0]);
        Msg("JailGuard killing script by Hulkkii");
        DoFightMode();
        while (Running() == true  && GetCurrentStat(1) < 10) {
            DoFightMode();
            if (InCombat() == false) {
                if (GetX() < 170 && Sleeping() == false) {
                    died++;
                    Msg("@dre@back to jail!!");
                    Wait(5000);
                    Walk(126,645);
                    Walk(135,636);
                    Walk(140,636);
                    Walk(155,639);
                    Walk(161,639);
                    Walk(167,639);
                    Walk(174,634);
                    Walk(180,631);
                    Walk(187,633);
                    Walk(195,633);
                    Wait(5000);
                    PrayerOn(10);
                    DoFightMode();
                }
                if (GetX() > 209 && Sleeping() == false) {
                    Msg("@dre@back to jail!!");
                    Wait(500);
                    Walk(208,631);
                    Walk(204,632);
                    Walk(196,633);
                    Wait(5000);
                    DoFightMode();
                } else {
                    if (Fatigue() > 97 && Sleeping() == false) {
                        Msg("Sleeping");
                        Use(FindInv(1263));
                        Wait(10000);
                    } else {
                        if (Sleeping() == false) {
                            int ID = GetNearestNPC(127);
                            if (ID != -1) {
                                DoFightMode();
                                AttackNPC(ID);
                                killed++;
                                long T = System.currentTimeMillis();
                                while (System.currentTimeMillis() - T <= FTime && InCombat() == false && Running() == true)
                                    Wait(1);
                            } else
                                Wait(1);
                        }
                    }
                }
            } else {
                while (InCombat() == true && Running() == true)
                    Wait(1);
            }
            Msg("******* STATUS *******");
            Msg("Killed: " + killed);
            Msg("Died: " + died);
            Msg("**********************");
        }
        DisplayMessage("@red@STOPPED", 3);
    }
    private void Msg(String str) {
        if(Running()) {
            DisplayMessage("@gre@SBoT: @whi@" + str,3);
            Println("SBoT: " + str);
        }
    }
    private void DoFightMode() {
        if (GetFightMode() != FMode) {
            SetFightMode(FMode);
            Msg("FightMode Changed To " + GetFightMode());
        }
    }
}