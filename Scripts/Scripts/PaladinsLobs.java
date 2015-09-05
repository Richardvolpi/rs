public class PaladinsLobs extends Script 
{
    public PaladinsLobs(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"paladinslobs"}; 
    }

	int HP = 0;
	int CAKES = 0;
	int FIGHTMODE = 0;
	int TotalStartXP0 = 0;
	int TotalStartXP1 = 0;
	int TotalStartXP2 = 0;
	int TotalStartXP3 = 0;
	int TotalStartXP4 = 0;
	int StartLevel0 = 0;
	int StartLevel1 = 0;
	int StartLevel2 = 0;
	int StartLevel3 = 0;
	int StartLevel4 = 0;
	int TripStartXP0 = 0;
	int TripStartXP1 = 0;
	int TripStartXP2 = 0;
	int TripStartXP3 = 0;
	int TripStartXP4 = 0;
	int BagCount = 0;
	int Trips = 1;
	long StartTime = 0;
	long TripTime = 0;
	int PaladinCount = 0;
	int GoldStart = 0;
	int ChaosStart = 0;
	int LobsEaten = 0;
    public void start(String command, String parameter[])
    {
		if (parameter.length < 2)
			Println("#### Parameter must be: FIGHTMODE@HP");
		else {
			FIGHTMODE = Integer.parseInt(parameter[0]);
			HP = Integer.parseInt(parameter[1]);
			FightModeHax();
			TotalStartXP0 = GetExperience(0);
			TotalStartXP1 = GetExperience(1);
			TotalStartXP2 = GetExperience(2);
			TotalStartXP3 = GetExperience(3);
			TotalStartXP4 = GetExperience(17);
			StartLevel0 = GetStat(0);
			StartLevel1 = GetStat(1);
			StartLevel2 = GetStat(2);
			StartLevel3 = GetStat(3);
			StartLevel4 = GetStat(17);
			GoldStart = InvCount(10);
			ChaosStart = InvCount(41);
			StartTime = (long)((int)(TickCount() / 1000));
			Println("##### Start Attack Experience: " + TotalStartXP0 + " (" + StartLevel0 + ")");
			Println("##### Start Defence Experience: " + TotalStartXP1 + " (" + StartLevel1 + ")");
			Println("##### Start Strenth Experience: " + TotalStartXP2 + " (" + StartLevel2 + ")");
			Println("##### Start Hits Experience: " + TotalStartXP3 + " (" + StartLevel3 + ")");
			Println("##### Start Thieving Experience: " + TotalStartXP4 + " (" + StartLevel4 + ")");
			while (Running())
			{
				TripStartXP0 = GetExperience(0);
				TripStartXP1 = GetExperience(1);
				TripStartXP2 = GetExperience(2);
				TripStartXP3 = GetExperience(3);
				TripStartXP4 = GetExperience(17);
				Println("#### Paladin Thiever With Lobs");
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
				Println("### Thieving Experience Gained Last Trip: " + (GetExperience(17) - TripStartXP4));
				Println("### Thieving Experience Gained So Far: " + (GetExperience(17) - TotalStartXP4));
				Println("### Attack Levels Gained So Far: " + (GetStat(0) - StartLevel0));
				Println("### Defence Levels Gained So Far: " + (GetStat(1) - StartLevel1));
				Println("### Strength Levels Gained So Far: " + (GetStat(2) - StartLevel2));
				Println("### Hits Levels Gained So Far: " + (GetStat(3) - StartLevel3));
				Println("### Thieving Levels Gained So Far: " + (GetStat(17) - StartLevel4));
				Println("### Paladins Thieved: " + PaladinCount);
				Println("### Chaos Runes Snatched: " + (InvCount(41) - ChaosStart));
				Println("### Gold Burgled: " + (InvCount(10) - GoldStart));
				Println("### Lobs Munched: " + LobsEaten);
				Println("### Number of times used the sleeping bag so far: " + BagCount);
				Trips++;

				Println("## Banking");
				while (InvCount(373) == 0)
					DoBank();

				Println("## Moving To Castle");
					GoCastle();

				Println("## Going Up-Stairs");
					UpStairs();

				Println("## Entering Tower");
					EnterDoor();

				while (InvCount(373) > 0)
					Thieve();

				Println("## Going Down-Stairs");
					DownStairs();

				Println("## Moving To Bank");
					ToBank();
			}

			Println("#### Script Ended ####");
		}
    }
	public void ToBank()
	{
		ForceWalk(608,603);
		while (!CanReach(607,603))
		{
			Println("## Opening Castle Door");
			AtObject(607,603);
			Wait(Rand(2000,2500));
		}
		ForceWalk(607,603);
		ForceWalk(599,603);
		while (!CanReach(598,603))
		{
			Println("## Opening Castle Gate");
			AtObject(598,603);
			Wait(Rand(2000,2500));
		}
		ForceWalk(598,603);
		ForceWalk(589,603);
		ForceWalk(581,604);
		ForceWalk(572,605);
		ForceWalk(565,606);
		ForceWalk(557,608);
		ForceWalk(550,608);
		ForceWalk(550,612);
		while (!CanReach(551,612))
		{
			Println("## Opening Bank Door");
			AtObject(550,612);
			ForceWalk(551,612);
		}
	}
	public void DownStairs()
	{
		while (GetX() != 609 || GetY() != 1547)
		{
			OpenDoor(609, 1548, 0);
			Wait(Rand(1000,1500));
		}
		ForceWalk(611,1544);
		while (GetY() > 700)
		{
			AtObject(611,1545);
			Wait(Rand(1000,1500));
		}
	}
	public void EnterDoor()
	{
		ForceWalk(609,1547);
		while (!CanReach(610,1548))
		{
			CloseDoor(609, 1548, 0);
			Wait(Rand(2000,3000));
		}
	}
	public void UpStairs()
	{
		while (GetY() < 700 && Running())
		{
			if (!InCombat())
				AtObject(611,601);
			Wait(Rand(2000,3000));
		}
	}
	public void GoCastle()
	{
		ForceWalk(551,612);

		while (!CanReach(550,612))
		{
			Println("## Opening Bank Door");
			AtObject(550,612);
			Wait(Rand(1000,1500));
		}
		ForceWalk(550,608);
		ForceWalk(556,608);
		ForceWalk(563,606);
		ForceWalk(572,606);
		ForceWalk(577,606);
		ForceWalk(584,604);
		ForceWalk(591,604);
		ForceWalk(598,603);
		while (!CanReach(599,603))
		{
			Println("## Opening Castle Gate");
			AtObject(598,603);
			Wait(Rand(1000,1500));
		}
		ForceWalk(599,603);
		ForceWalk(607,603);
		while (!CanReach(608,603))
		{
			Println("## Opening Castle Door");
			AtObject(607,603);
			Wait(Rand(1000,1500));
		}
		ForceWalk(608,603);
	}
	public void DoBank()
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
				if (FindInv(10) == -1)
					Deposit(10,1);
				if (FindInv(41) == -1)
					Deposit(41,1);					
				CloseBank();
				Wait(2500);
			}
		}
	}
	public void Thieve()
	{
		if (Fatigue() < 90 && !Sleeping())
		{
			if (Fatigue() < 90)
			{
				if (InCombat())
				{
					while (InCombat())
					{
						WalkNoWait(GetX(),GetY());
						Wait(Rand(250,500));
					}
				}
				if (GetCurrentStat(3) > HP)
				{
					int ID = GetNearestNPC(323);
					if (ID != -1)
					{
						ThieveNPC(ID);
						PaladinCount++;
						long T = TickCount();
						while (!InCombat() && TickCount() - T < Rand(2000,2500))
							Wait(1);
					}
				} else {
					LobsEaten++;
					Println("## Eating Lob Number: " + LobsEaten);
					int pos = FindInv(373);
					if (pos == -1)
						return;
					Use(pos);
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
