public class AutoFight extends Script
{
    public AutoFight(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"fight"};
    }
    public void start(String command)
    {
		int FightMode = 1;
		int FightTime = 750;
		CheckFighters(true);
		DisplayMessage("@gre@SBoT: @whi@AutoFighter - RichyT", 3);
		while (Running() == true && GetCurrentStat(3) > 5)
		{
			if (GetFightMode() != FightMode)
			{
				SetFightMode(FightMode);
				DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3);
			}
			if (InCombat() == false)
			{
				int ID = GetNearestNPC(3);
				if (ID != -1)
				{
					long T = System.currentTimeMillis();
					AttackNPC(ID);
					while (System.currentTimeMillis() - T <= FightTime && InCombat() == false)
						Wait(1);
				} else
					Wait(1); 
			} else {
				while (InCombat() == true)
					Wait(1);
			}
		}
		DisplayMessage("@gre@SBoT: @whi@AutoFighter - @red@STOPPED", 3);
    }
}
