public class UnCert extends Script 
{
    public UnCert(mudclient rs)
    {
        super(rs); 
		//Change nothing here but 'EXAMPLE'.
    }
    public String[] getCommands()
    {
        return new String[]{"uncert"}; 
    }
	public void ServerMessage(String message)
	{
	}
    public void start(String command, String parameter[])
    {
		long T;
		DisplayMessage("@gre@Coal UnCert - Lost City - @whi@RichyT", 3);
		while (Running() && InvCount(518) > 0)
		{
			Walk(176,3533,5000);
			while (InvCount(155) < 1)
			{
				int id = GetNearestNPC(466);
				T = TickCount();
				TalkToNPC(id);
				while (!QuestMenu() && TickCount() - T < 5000 && Running())
					Wait(10);
				if (QuestMenu())
				{
					Answer(0);
					T = TickCount();
					while (!QuestMenu() && TickCount() - T < 5000 && Running())
						Wait(10);
					if (QuestMenu())
					{
						Answer(1);
						T = TickCount();
						while (!QuestMenu() && TickCount() - T < 5000 && Running())
							Wait(10);
						if (QuestMenu())
						{
							Answer(4);
							Wait(2500);
						}
					}
				}
			}
			WalkEmpty(173,3526,174,3528);
			while (InvCount(155) > 0)
			{
				while (!QuestMenu() && Running())
				{
					int id = GetNearestNPC(224);
					T = TickCount();
					TalkToNPC(id);			
					while (!QuestMenu() && TickCount() - T < 6000)
						Wait(100);
				}
				if (QuestMenu())
				{
					Answer(0);
					Wait(100);
					T = TickCount();
					while (!Bank() && TickCount() - T < 8000)
						Wait(100);
					if (Bank())
					{
						while (Running() && InvCount(155) > 0)
						{
							Deposit(155,1);
							Wait(10);
						}
					}
				}
				Wait(10);
			}
		}
		DisplayMessage("@red@STOPPED", 3);
    }
}
