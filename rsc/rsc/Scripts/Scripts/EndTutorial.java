public class EndTutorial extends Script 
{
    public EndTutorial(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"endtut"}; 
    }
	public void ServerMessage(String message)
	{
	}
    public void start(String command, String parameter[])
    {
		WaitForNPCMessage(774,40,"talk to me again");
		Wait(Rand(1000,2000));
		while (!Sleeping())
		{
			AtObject(222,761);
			while (!Sleeping())
				Wait(10);
		}
		WaitForNPCMessage(774,40,"next door");
		Walk(225,760);
		while (GetX() != 226)
		{
			OpenDoor(226,760,1);
			Wait(Rand(2000,3000));
		}
		WaitForNPCMessage(496,40,"thousands");
		WaitForQuestMenu();
		Answer(0);
		WaitForNPCMessage(40,"send a message");
		WaitForQuestMenu();
		Answer(1);
		WaitForNPCMessage(40,"luck");
		Wait(Rand(1000,2000));
		Walk(230,759);
		while (GetY() != 758)
		{
			OpenDoor(230,759,0);
			Wait(Rand(2000,3000));
		}
		WaitForNPCMessage(497,40,"kingdom");
		WaitForQuestMenu();
		Answer(0);
		while (GetX() != 120 || GetY() !=648)
			Wait(1);
		Println("COMPELTED!!!1");
		Quit();
	}
	public void WaitForNPCMessage(int time, String message)
	{
		ResetLastNPCMessage();
		while (LastNPCMessage().indexOf(message) < 0)
		{
			long T = TickCount();
			if (LastNPCMessage() != null)
				while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
					Wait(100);
			Wait(1000);
		}
	}
	public void WaitForNPCMessage(int type, int time, String message)
	{
		ResetLastNPCMessage();
		while (LastNPCMessage().indexOf(message) < 0)
		{
			ResetLastServerMessage();
			ResetLastNPCMessage();
			int id = GetNearestNPC(type);
			long T = TickCount();
			TalkToNPC(id);
			while (TickCount() - T < 8000 && LastServerMessage().indexOf("busy") < 0 && LastNPCMessage() == "")
				Wait(100);
			if (LastServerMessage().indexOf("busy") < 0)
			{
				T = TickCount();
				if (LastNPCMessage() != null)
					while (LastNPCMessage().indexOf(message) < 0 && TickCount() - T < (time * 1000))
						Wait(100);
			}
			Wait(1000);
		}
	}
	public void WaitForQuestMenu()
	{
		while (!QuestMenu())
			Wait(100);
	}
}
