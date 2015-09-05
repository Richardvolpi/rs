public class MageKnight extends Script 
{
    public MageKnight(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"mageknight"}; 
    }

	int BagCount = 0;
	int ShootCount = 0;
	int StartXP = 0;
	int StartLevel = 0;
	public void KeyPressed(int id)
	{
		if (id == 1014)
			Println("#### Magic Experience Gained: " + (GetExperience(6) - StartXP) + " (" + (GetStat(6) - StartLevel) + ")");
	}
	int spell = 0;
    public void start(String command, String parameter[])
    {
		spell = StrToInt(parameter[0]);
		StartXP = GetExperience(6);
		StartLevel = GetStat(6);
		fightModeHax();
		Println("##### Start Magic Experience: " + GetExperience(6) + " (" + GetStat(6) + ")");
		while (Running())
			FightGuards();
		Println("#### Script Ended ####");
    }
	public void FightGuards()
	{
		if (Fatigue() < 90 && !Sleeping())
		{
			if (!InCombat() && Fatigue() < 90)
			{
				if (InLastServerMessage("fail"))
					Wait(20000);
				if (InLastServerMessage("clear"))
				{
					Walk(281,665);
					Wait(1000);
				}
				if (InLastServerMessage("minutes"))
				{
					WalkNoWait(GetX()+1,GetY());
					Wait(Rand(1000,2000));
				}
				ResetLastServerMessage();
				int ID = GetNearestNPC(189);
				if (ID == -1)
				{
					Walk(281,665);
					Wait(10);
				}
				else {
					MagicNPC(ID,spell);
					long T = TickCount();
					while (!InCombat() && TickCount() - T < Rand(2000,2250))
						Wait(1);
					ShootCount++;
					Println("## Maging knight " + ShootCount + " times");
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
	public void fightModeHax()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (GetFightMode() != 3)
						{
							SetFightMode(3);
							Println("## Changed fight mode to " + 3 + "!");
						}
						Wait(1);
					}
				}		
		}).start();
	}
}
