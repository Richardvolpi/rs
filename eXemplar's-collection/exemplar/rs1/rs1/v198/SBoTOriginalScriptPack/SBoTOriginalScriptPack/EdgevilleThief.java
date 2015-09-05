public class EdgevilleThief extends Script 
{
    public EdgevilleThief(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"edgethief"}; 
    }

	int HP = 0;
	int LOBSTERS = 0;
	int FIGHTMODE = 0;
	int TotalStartXP0 = 0;
	int TotalStartXP1 = 0;
	int TotalStartXP2 = 0;
	int TotalStartXP3 = 0;
	int StartLevel0 = 0;
	int StartLevel1 = 0;
	int StartLevel2 = 0;
	int StartLevel3 = 0;
	int TripStartXP0 = 0;
	int TripStartXP1 = 0;
	int TripStartXP2 = 0;
	int TripStartXP3 = 0;
	int LobstersEaten = 0;
	int BagCount = 0;
	int Trips = 1;
	long StartTime = 0;
	long TripTime = 0;
	int GuardCount = 0;
    public void start(String command, String parameter[])
    {
		if (parameter.length < 3)
			Println("#### Parameter must be: FIGHTMODE@HP@LOBSTERS");
		else {
			FIGHTMODE = Integer.parseInt(parameter[0]);
			HP = Integer.parseInt(parameter[1]);
			LOBSTERS = Integer.parseInt(parameter[2]);
			FightModeHax();
			TotalStartXP0 = GetExperience(0);
			TotalStartXP1 = GetExperience(1);
			TotalStartXP2 = GetExperience(2);
			TotalStartXP3 = GetExperience(3);
			StartLevel0 = GetStat(0);
			StartLevel1 = GetStat(1);
			StartLevel2 = GetStat(2);
			StartLevel3 = GetStat(3);
			StartTime = (long)((int)(TickCount() / 1000));
			Println("##### Start Attack Experience: " + TotalStartXP0 + " (" + StartLevel0 + ")");
			Println("##### Start Defence Experience: " + TotalStartXP1 + " (" + StartLevel1 + ")");
			Println("##### Start Strenth Experience: " + TotalStartXP2 + " (" + StartLevel2 + ")");
			Println("##### Start Hits Experience: " + TotalStartXP3 + " (" + StartLevel3 + ")");
			while (Running())
			{
				
				Println("#### Edgeville Guard Trainer / Banker - RichyT");
				Println("### " + ((long)((int)(TickCount() / 1000)) - StartTime) + " seconds have passed");
				Println("### Trip Number: " + Trips);
				Println("### Attack Experience Gained Last Trip: " + (GetExperience(0) - TripStartXP0));
				Println("### Attack Experience Gained So Far: " + (GetExperience(0) - TotalStartXP0));
				Println("### Defence Experience Gained Last Trip: " + (GetExperience(1) - TripStartXP1));
				Println("### Defence Experience Gained So Far: " + (GetExperience(1) - TotalStartXP1));
				Println("### Strength Experience Gained Last Trip: " + (GetExperience(2) - TripStartXP2));
				Println("### Strength Experience Gained So Far: " + (GetExperience(2) - TotalStartXP2));
				Println("### Hits Experience Gained Last Trip: " + (GetExperience(3) - TripStartXP3));
				Println("### Hits Experience Gained So Far: " + (GetExperience(3) - TotalStartXP3));
				Println("### Attack Levels Gained So Far: " + (GetStat(0) - StartLevel0));
				Println("### Defence Levels Gained So Far: " + (GetStat(1) - StartLevel1));
				Println("### Strength Levels Gained So Far: " + (GetStat(2) - StartLevel2));
				Println("### Hits Levels Gained So Far: " + (GetStat(3) - StartLevel3));
				Println("### Guards Attacked So Far: " + GuardCount);
				Println("### Lobsters Munched: " + LobstersEaten);
				Println("### Number of times used the sleeping bag so far: " + BagCount);
				TripStartXP0 = GetExperience(0);
				TripStartXP1 = GetExperience(1);
				TripStartXP2 = GetExperience(2);
				TripStartXP3 = GetExperience(3);
				Trips++;
				Println("## Attacking Guards");
				while (InvCount(373) > 0)
					FightGuards();
					
				if (LOBSTERS - LobstersEaten == 0)
					Quit();

				Println("## No food left, Moving to bank");
				GoBank();

				Println("## Talking to Banker");
				DoBank();

				Println("## Moving back to guards");
				GoGuards();
			}
			Println("#### Script Ended ####");
		}
    }
	public void GoGuards()
	{
		ForceWalk(217,448);

		while (!CanReach(217,447))
		{
			AtObject(217,448);
			Wait(1000);
		}
		ForceWalk(217,447);
		ForceWalk(210,446);
		ForceWalk(207,442);
		ForceWalk(203,436);
	}
	public void DoBank()
	{
		while (InvCount(373) == 0)
		{
			int ID = GetNearestNPC(95);
			long T = TickCount();
			TalkToNPC(ID);
			ResetLastServerMessage();
			while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0)
				Wait(10);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (!Bank() && TickCount() - T < 6000)
					Wait(10);
				if (Bank())
				{
					for (int i = 0; i < 30 - InvCount(); i++)
						Withdraw(373,1);
					CloseBank();
					Wait(2500);
				}
			}
		}
	}
	public void GoBank()
	{
		while (!CanReach(203,436))
		{
			AtObject(204,435);
			Wait(1000);
		}
		ForceWalk(203,436);
		ForceWalk(207,442);
		ForceWalk(210,446);
		ForceWalk(217,447);
		while (!CanReach(217,448))
		{
			AtObject(217,447);
			Wait(1000);
		}
		ForceWalk(217,448);
	}
	public void FightGuards()
	{
		if (Fatigue() < 90 && !Sleeping())
		{
			if (!InCombat() && Fatigue() < 90)
			{
				if (GetCurrentStat(3) > HP)
				{
					int ID = GetNearestNPC(65);
					if (ID == -1)
						ForceWalk(203,436);
					else {
						while (!CanReach(NPCX(ID),NPCY(ID)))
						{
							AtObject(204,435);
							Wait(1000);
						}
						ThieveNPC(ID);
						long T = TickCount();
						while (!InCombat() && TickCount() - T < Rand(2000,2500))
							Wait(1);
						GuardCount++;
						Println("## Attacking guard number: " + GuardCount);
					}
				} else {
					if (LOBSTERS - LobstersEaten == 0)
						Quit();
					LobstersEaten++;
					Println("## Eating lobster number: " + LobstersEaten);
					Use(FindInv(373));
					Wait(1000);
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
