public class Chickens extends Script 
{
    public Chickens(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"chickens"}; 
    }

	int HP = 0;
	int BagCount = 0;
	long StartTime = 0;
	int ChickenCount = 0;
	int FIGHTMODE = 1;
    public void start(String command, String parameter[])
    {
		FIGHTMODE = Integer.parseInt(parameter[0]);
		FightModeHax();
		DoorHax();
		StartTime = (long)((int)(TickCount() / 1000));
		Println("##### Start Attack Experience: " + GetExperience(0) + " (" + GetStat(0) + ")");
		Println("##### Start Defence Experience: " + GetExperience(1) + " (" + GetStat(1) + ")");
		Println("##### Start Strenth Experience: " + GetExperience(2) + " (" + GetStat(2) + ")");
		Println("##### Start Hits Experience: " + GetExperience(3) + " (" + GetStat(3) + ")");
		while (Running())
			FightChickens();
		Println("#### Script Ended ####");
    }
	public void FightChickens()
	{
		if (Fatigue() < 90 && !Sleeping())
		{
			if (!InCombat() && Fatigue() < 90)
			{
				int ID = GetNearestNPC(3);
				if (ID == -1 || GetY() > 502)
					ForceWalk(562,493);
				else {
					AttackNPC(ID);
					long T = TickCount();
					while (!InCombat() && TickCount() - T < Rand(2000,2500))
						Wait(1);
					ChickenCount++;
					Println("## Attacking chicken number: " + ChickenCount);
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
	public void DoorHax()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (GetY() >= 498 && !CanReach(562,497))
						{
							Println("### Opening Door");
							OpenDoor(562,498,0);
							Wait(2000);
						}
						if (GetY() <= 486 && !CanReach(560,487))
						{
							Println("### Opening 2nd Door");
							OpenDoor(560,487,0);
							Wait(2000);
						}
						Wait(1);	
					}
				}		
		}).start();
	}
}
