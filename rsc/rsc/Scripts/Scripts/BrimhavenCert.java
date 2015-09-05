public class BrimhavenCert extends Script 
{
    public BrimhavenCert(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"fishlob"}; 
    }
	public void ServerMessage(String message)
	{
	}
	int TotalStartXP = 0;
	int StartLevel = 0;
	int TripStartXP = 0;

	int TotalStartXP2 = 0;
	int StartLevel2 = 0;
	int TripStartXP2 = 0;

	int CertsMade = 0;
	int LobstersFished = 0;
	int LobstersCooked = 0;
	int LobstersBurnt = 0;

	int BagCount = 0;
	int Trips = 1;
	long StartTime = 0;
    public void start(String command, String parameter[])
    {
		StartSleeper();
		TotalStartXP = GetExperience(10);
		StartLevel = GetStat(10);
		TotalStartXP2 = GetExperience(7);
		StartLevel2 = GetStat(7);
		StartTime = (long)((int)(TickCount() / 1000));
		Println("##### Start Fishing Experience: " + TotalStartXP + " (" + StartLevel + ")");
		Println("##### Start Cooking Experience: " + TotalStartXP2 + " (" + StartLevel2 + ")");
		while (Running())
		{
			Beep();
			
			Println("#### Brimhaven Cooked Lobster Fish and Cert - RichyT");
			Println("### " + ((long)((int)(TickCount() / 1000)) - StartTime) + " seconds have passed");
			Println("### Trip Number: " + Trips);
			Println("### Fishing Experience Gained Last Trip: " + (GetExperience(10) - TripStartXP));
			Println("### Cooking Experience Gained Last Trip: " + (GetExperience(7) - TripStartXP2));
			Println("### Fishing Experience Gained So Far: " + (GetExperience(10) - TotalStartXP));
			Println("### Cooking Experience Gained So Far: " + (GetExperience(7) - TotalStartXP2));
			Println("### Fishing Levels Gained So Far: " + (GetStat(10) - StartLevel));
			Println("### Cooking Levels Gained So Far: " + (GetStat(7) - StartLevel2));
			Println("### Lobsters Fished: " + LobstersFished);
			Println("### Lobsters Cooked: " + LobstersCooked);
			Println("### Lobsters Burnt: "+ LobstersBurnt);
			Println("### Lobster Certs Made: " + CertsMade);
			try
			{
				double c = LobstersBurnt / LobstersCooked;
				c = c * 100;
				Println("### Your estimated burning percentage is: " + c + "%");
			}
			catch (Exception e) {}
			Println("### Number of times used the sleeping bag so far: " + BagCount);
			TripStartXP = GetExperience(10);
			TripStartXP2 = GetExperience(7);
			Trips++;

			Println("## Fishing");
			while (InvCount(372) + InvCount(373) < 25)
				Fish();
			LobstersFished += InvCount(372);

			Println("## Moving To Range");
			ForceWalk(448,708);
			ForceWalk(445,705);
			ForceWalk(444,700);
			while (!CanReach(443,700))
			{
				OpenDoor(444, 700, 1);
				Wait(3000);
			}
			ForceWalk(439,701);

			Println("## Cooking");
			while (InvCount(372) > 0)
				Cook();
			Println("## Dropping " + InvCount(374) + " burnt lobsters");
			LobstersCooked += InvCount(373);
			LobstersBurnt += InvCount(374);
			DropBurnt();

			Println("## Moving To Seth - " + InvCount(373) + " cooked lobsters");
			ForceWalk(443,700);
			while (!CanReach(444,700))
			{
				OpenDoor(444, 700, 1);
				Wait(3000);
			}
			ForceWalk(444,700);
			ForceWalk(446,691);
			ForceWalk(446,684);
			ForceWalk(446,677);

			Println("## Certing");

			int Certs = LobsterQuestion();

			while (InvCount(373) >= 5)
			{
				TalkToNPC(1381);
				long T = TickCount();
				ResetLastServerMessage();
				while (!QuestMenu() && TickCount() - T < 4000 && LastServerMessage().indexOf("busy") < 0)
					Wait(10);				
				if (QuestMenu())
				{
					Answer(1);
					T = TickCount();
					while (!QuestMenu() && TickCount() - T < 4000)
						Wait(10);
					if (QuestMenu())
					{
						Answer(0);
						T = TickCount();
						while (!QuestMenu() && TickCount() - T < 4000)
						{
							if (QuestMenu())
							{
								Answer(Certs);
								Wait(2500);
							}
						}
					}
				}
			}

			if (Certs < 5)
				CertsMade += Certs + 1;
			
			Println("## " + Certs + " More Certs Made, Moving Back To Lobsters");
			ForceWalk(445,680);
			ForceWalk(445,686);
			ForceWalk(445,695);
			ForceWalk(446,701);
			ForceWalk(448,707);
			ForceWalk(453,709);
		}
		Println("#### Script Ended ####");
    }
	public void DropBurnt()
	{
		while (InvCount(374) > 0)
		{
			Drop(FindInv(374));
			Wait(500);
		}
	}
	public int LobsterQuestion()
	{
		if (InvCount(373) < 25)
			if (InvCount(373) < 20)
				if (InvCount(373) < 15)
					if (InvCount(373) < 10)
						if (InvCount(373) < 5)
							return 5;
						else
							return 0;
					else
						return 1;
				else
					return 2;
			else
				return 3;							
		else
			return 4;
	}
	public void Cook()
	{
		if (!Sleeping())
			UseOnObject(438, 701, FindInv(372));
		Wait(Rand(2000,3000));
	}
	public void Fish()
	{
		if (!Sleeping())
			AtObject2(453,710);
		Wait(Rand(1500,3000));
	}
	public void StartSleeper()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (Fatigue() > 85 && !Sleeping())
						{
							Println("#### Fatigue is " + Fatigue() + ", using sleeping bag");
							Use(FindInv(1263));
							BagCount++;
							Wait(5000);
						}
						Wait(250);
					}
				}		
		}).start();
	}
}
