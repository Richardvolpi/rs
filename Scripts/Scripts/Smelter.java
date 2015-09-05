public class Smelter extends Script 
{
    public Smelter(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"smelt"}; 
    }

    public void start(String command, String parameter[])
    {
		Println("##### Al Khadrid Smelter");
		while (Running())
		{
			Println("## Talking to Banker");
			DoBank();

			Println("## Moving to Furnace");
			GoSmelt();

			Println("## Smelting");
			DoSmelt();

			Println("## Moving to Bank");
			GoBank();
		}
		Println("#### Script Ended ####");
    }
	public void GoBank()
	{
		ForceWalk(84,680);
		ForceWalk(83,681);
		ForceWalk(84,686);
		ForceWalk(85,690);
		ForceWalk(86,695);
	}
	public void DoSmelt()
	{
		while (InvCount(155) > 0 && InvCount(151) > 0 && Running())
		{
			if (!Sleeping() && Fatigue() > 80)
			{
				Println("#### Wait before sleep");
				Wait(Rand(4000,5000));
				Use(FindInv(1263));
			} else {
				if (!Sleeping())
				{
					UseOnObject(85, 679, FindInv(155));
					Wait(Rand(1000,1500));
				}
			}
			Wait(Rand(10,50));
		}
	}
	public void GoSmelt()
	{
		ForceWalk(86,695);
		ForceWalk(85,690);
		ForceWalk(84,686);
		ForceWalk(83,681);
		ForceWalk(84,680);
	}
	public void DoBank()
	{
		while (InvCount(155) == 0)
		{
			int ID = GetNearestNPC(268);
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
					for (int i = 0; i < InvCount() - 1; i++)
						Deposit(171,1);
					for (int i = 0; i < 18; i++)
						Withdraw(155,1);
					for (int i = 0; i < 9; i++)
						Withdraw(151,1);
					CloseBank();
					Wait(2500);
				}
			}
		}
		if (InvCount(155) < 2 || InvCount(151) < 1)
		{
			Println("OUT OF COALS?");
			Quit();
		}
	}
}
