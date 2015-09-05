public class ZamorakPrayer extends Script {
    public ZamorakPrayer(mudclient rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"ZamFight"};
    }
    public void start(String command, String parameter[]) {
        if (parameter.length !=1)
            DisplayMessage("Incorrect. Command is /run ZamFight [fightmode]",3);
        int mode = Integer.parseInt(parameter[0]);
        int fightTime = 750;
        int startx = GetX();
        int starty = GetY();
        CheckFighters(true);
        DisplayMessage("@gr1@Zamorak fighter and prayer recharger, by @cya@Cyrus @whi mod by eXemplar",3);
        while (Running() && GetCurrentStat(3) >=5) {
            if (GetFightMode() != mode) {
                SetFightMode(mode);
                DisplayMessage("Fight mode changed to " + mode,3);
            }
            if (Fatigue() >= 95 && Sleeping() == false) {
                Use(FindInv(1263));
                Wait(1500);
                
                while (Sleeping() == true)
                    Wait(1);
            }
            while (Sleeping() == false && Fatigue() <95 && Running()==true && GetCurrentStat(5) > 5) {
                int zamorak = GetNearestNPC(new int[]{139,140});
                if (zamorak != -1 && NPCInCombat(zamorak) == false) {
                    long tick = System.currentTimeMillis();
                    TalkToNPC(zamorak);
                    while (System.currentTimeMillis() - tick <= fightTime && InCombat() == false && Running() == true && NPCInCombat(zamorak) == false)
                        Wait(1);
                    while(InCombat())
                        Wait(1);
                }
                else
                    Wait(1);
            }
            if (GetCurrentStat(5) < 5) {
                DisplayMessage("Recharging prayer",3);
                while(GetCurrentStat(5) < 5 && Running()) {
                    AtObject(334,435);
                    Wait(Rand(1000,2000));
                }
            }
            if(Distance(startx,starty) > 10) 
                Walk(startx,starty);
            Wait(Rand(500,1000));
        }
    }
}