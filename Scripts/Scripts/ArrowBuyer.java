public class ArrowBuyer extends Script 
{
    public ArrowBuyer(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"arrows"}; 
    }
    public void start(String command, String parameter[])
    {

		while (Running())
		{
			StartBuy(51);
			//StartBuy(52);
			StartBuy(53);
			//StartBuy(54);
			StartBuy(55);
			//StartBuy(56);
		}
		DisplayMessage("@red@STOPPED", 3);
    }
	public void StartBuy(int world)
	{
		SetWorld(world);
		while (LoggedIn() && Running())
		{
			Logout();
			long T = TickCount();
			while (LoggedIn() && TickCount() - T < 5000)
				Wait(10);
		}
		while (!LoggedIn() && Running())
			Wait(10);
		Println("Starting To Buy");
		Wait(1000);
		BuyArrows();
	}
	public void BuyArrows()
	{
		while (!Shop() && Running())
		{
			while (!QuestMenu() && Running())
			{
				TalkToNPC(142);
				long T = TickCount();
				ResetLastServerMessage();
				while (TickCount() - T < 6000 && !QuestMenu() && Running() && !InLastServerMessage("busy"))
					Wait(10);
			}
			Answer(0);
			long T = TickCount();
			while (!Shop() && TickCount() - T < 5000 && Running())
				Wait(10);
			while (ShopCount(11) > 0 && Running())
			{
				Buy(11);
				Wait(Rand(50,100));
			}
			while (ShopCount(190) > 0 && Running())
			{
				Buy(190);
				Wait(Rand(50,100));
			}
		}
	}
}
