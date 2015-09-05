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
    public void start(String command, String parameter)
    {
		if (parameter == null)
		{
			DisplayMessage("@gre@SBoT: @whi@No type specified, use /RUN FIGHT [type]", 3);
		} else {
			int FightMode = 1;
			int FightTime = 750;
			int FightType = Integer.parseInt(parameter);
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
					int ID = GetNearestNPC(FightType);
					if (ID != -1)
					{
						long T = System.currentTimeMillis();
						AttackNPC(ID);
						while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
							Wait(1);
					} else
						Wait(1); 
				} else {
					while (InCombat() == true && Running() == true)
						Wait(1);
				}
			}
		}
		DisplayMessage("@gre@SBoT: @whi@AutoFighter - @red@STOPPED", 3);
    }
}
