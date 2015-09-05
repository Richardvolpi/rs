public class Vials extends Script 
{
    public Vials(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"vials"}; 
    }
	int Trips = 0;
	int Vials = 0;
	long StartTime = 0;
    public void start(String command, String parameter[])
    {
		Println("#### Filled Vial Buyer Script");
		StartTime = TickCount();
		while (Running())
		{
			Trips++;
			Println("### Filled Vial Buyer Script - RichyT");
			Println("### " + (int)((TickCount() - StartTime) / 1000) + " seconds have passed");
			Println("### Trip Number: " + Trips);
			Println("### Number of vials bought: " + Vials);
			Println("## Banking");
			DoBank();

			Println("## Going to shop");
			GoShop();

			Println("## Shopping 1");
			DoShop1();

			Println("## Shopping 2");
			DoShop2();

			Println("## Shopping 3");
			DoShop3();

			Println("## Going to bank with " + InvCount(464) + " vials");
			GoBank();
		}
		Println("#### Script Ended ####");
    }
	public void GoBank()
	{
		while (!CanReach(582,603))
		{
			Println("## Opening Shop Door");
			OpenDoor(582,603,0);
			Wait(Rand(2500,3000));
		}
		ForceWalk(582,603);
		ForceWalk(576,605);
		ForceWalk(570,606);
		ForceWalk(563,606);
		ForceWalk(556,607);
		ForceWalk(550,608);
		ForceWalk(550,611);
		while (!CanReach(551,612))
		{
			AtObject(550,612);
			Wait(Rand(2500,3000));
		}
		ForceWalk(551,612);
	}
	public void DoShop3()
	{
		while (!Shop() && Running())
		{
			int types[] = new int[] { 336, 337 };
			int ID = GetNearestNPC(types);
			TalkToNPC(ID);
			long T = TickCount();
			ResetLastServerMessage();
			while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0)
				Wait(10);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (!Shop() && TickCount() - T < 5000)
					Wait(10);
			}
		}
		if (Shop())
		{
			Println("## Buying " + ShopCount(464) + " vials");
			Vials += ShopCount(464);
			while (ShopCount(464) > 0 && InvCount() < 30)
			{
				Buy(464);
				Wait(50);
			}
			CloseShop();
			Wait(2000);
			SetWorld(52);
			Logout();
		}
	}
	public void DoShop2()
	{
		while (!Shop() && Running())
		{
			int types[] = new int[] { 336, 337 };
			int ID = GetNearestNPC(types);
			TalkToNPC(ID);
			long T = TickCount();
			ResetLastServerMessage();
			while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0)
				Wait(10);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (!Shop() && TickCount() - T < 5000)
					Wait(10);
			}
		}
		if (Shop())
		{
			Println("## Buying " + ShopCount(464) + " vials");
			Vials += ShopCount(464);
			while (ShopCount(464) > 0)
			{
				Buy(464);
				Wait(50);
			}
			CloseShop();
			Wait(2000);
			SetWorld(56);
			Logout();
		}
	}
	public void DoShop1()
	{
		while (!Shop() && Running())
		{
			int types[] = new int[] { 336, 337 };
			int ID = GetNearestNPC(types);
			TalkToNPC(ID);
			long T = TickCount();
			ResetLastServerMessage();
			while (!QuestMenu() && TickCount() - T < 6000 && LastServerMessage().indexOf("busy") < 0)
				Wait(10);
			if (QuestMenu())
			{
				Answer(0);
				T = TickCount();
				while (!Shop() && TickCount() - T < 5000)
					Wait(10);
			}
		}
		if (Shop())
		{
			Println("## Buying " + ShopCount(464) + " vials");
			Vials += ShopCount(464);
			while (ShopCount(464) > 0)
			{
				Buy(464);
				Wait(50);
			}
			CloseShop();
			Wait(2000);
			SetWorld(54);
			Logout();
		}
	}
	public void GoShop()
	{
		while (!CanReach(551,612))
		{
			Println("## Opening Bank Door");
			AtObject(550,612);
			Wait(Rand(2000,2500));
		}
		ForceWalk(550,612);
		ForceWalk(552,608);
		ForceWalk(559,607);
		ForceWalk(565,605);
		ForceWalk(572,604);
		ForceWalk(578,604);
		ForceWalk(582,603);
		while (!CanReach(582,602))
		{
			OpenDoor(582,603,0);
			Wait(Rand(2500,3000));
		}
		ForceWalk(582,602);
	}
	public void DoBank()
	{
		while (InvCount(464) > 0 && Running())
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
					for (int i = 0; i < InvCount(464); i++)
						Deposit(464,1);
					CloseBank();
					Wait(2500);
				}
			}
		}
	}

}
