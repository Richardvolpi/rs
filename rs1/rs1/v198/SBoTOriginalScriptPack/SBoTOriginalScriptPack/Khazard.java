public class Khazard extends Script 
{
    public Khazard(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"khazard"}; 
    }

	int HP = 0;
	int BagCount = 0;
	long StartTime = 0;
	int GuardCount = 0;
	int FIGHTMODE = 1;
    public void start(String command, String parameter[])
    {
		FIGHTMODE = Integer.parseInt(parameter[0]);
		FightModeHax();
		StartTime = (long)((int)(TickCount() / 1000));
		Println("##### Start Attack Experience: " + GetExperience(0) + " (" + GetStat(0) + ")");
		Println("##### Start Defence Experience: " + GetExperience(1) + " (" + GetStat(1) + ")");
		Println("##### Start Strenth Experience: " + GetExperience(2) + " (" + GetStat(2) + ")");
		Println("##### Start Hits Experience: " + GetExperience(3) + " (" + GetStat(3) + ")");
		FightGuards();
		Println("#### Script Ended ####");
    }
	public void FightGuards()
	{
		if (Fatigue() < 90 && !Sleeping())
		{
			if (!InCombat() && Fatigue() < 90)
			{
				int ID = GetNearestNPC(407);
				if (ID == -1)
					ForceWalk(658,642);
				else {
					AttackNPC(ID);
					long T = TickCount();
					while (!InCombat() && TickCount() - T < Rand(2000,2500))
						Wait(1);
					GuardCount++;
					Println("## Attacking guard number: " + GuardCount);
				}
			} else
				Wait(1);
		} else {
			if (!Sleeping())
			{
				Println("#### Fatigue is " + Fatigue() + ", using sleeping bag");
				Use(FindInv(1263));
				BagCount++;
				Wait(5000);
			}
			Wait(1);
		}
	}	
	public void FightModeHax()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (GetFightMode() != FIGHTMODE)
						{
							SetFightMode(FIGHTMODE);
							Println("##### Changing fight mode to: " + FIGHTMODE);
						}
						Wait(1);						
					}
				}		
		}).start();
	}
}
