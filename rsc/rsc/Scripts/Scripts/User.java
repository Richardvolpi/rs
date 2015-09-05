public class User extends Script 
{
    public User(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"user"}; 
    }
	int ID1;
	int ID2;
	int ID3;
    public void start(String command, String parameter[])
    {
		if (parameter.length < 3)
			Println("#### Parameter must be: FIGHTMODE@HP@LOBSTERS");
		else {
			StartSleeper();
			ID1 = Integer.parseInt(parameter[0]);
			ID2 = Integer.parseInt(parameter[1]);
			ID3 = Integer.parseInt(parameter[2]);
			Println("#### Filler script started");
			while (Running())
			{
				Println("## Banking");
				DoBank();

				Println("## Starting to mix");
				DoMix();
			}
			Println("#### Script Ended ####");
		}
    }

	public void DoMix()
	{
		while (InvCount(ID1) > 0 && Running())
		{
			if (!Sleeping())
			{
				UseWithInventory(FindInv(ID1),FindInv(ID2));
				Wait(1000);
			} else
				Wait(1);
		}
	}
		
	public void DoBank()
	{
		while (InvCount(ID1) == 0 || InvCount(ID2) == 0 || InvCount(ID3) > 0 && Running())
		{
			int ID = GetNearestNPC(95);
			long T = TickCount();
			TalkToNPC(ID);
			ResetLastServerMessage();
			while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0 && Running())
				Wait(10);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (!Bank() && TickCount() - T < 6000 && Running())
					Wait(10);
				if (Bank())
				{
					for (int i = 0; i < InvCount(ID3); i++)
						Deposit(ID3,1);
					for (int i = 0; i < 14; i++)
						Withdraw(ID1,1);
					for (int i = 0; i < 14; i++)
						Withdraw(ID2,1);
					CloseBank();
					Wait(2500);
				}
			}
		}
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
						if (Fatigue() > 95 && !Sleeping())
						{
							Println("### Fatigue is " + Fatigue() + ", using sleeping bag");
							Use(FindInv(1263));
							Wait(5000);
						}
						Wait(250);
					}
				}		
		}).start();
	}

}
