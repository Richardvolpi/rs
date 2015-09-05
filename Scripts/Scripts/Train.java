public class Train extends Script 
{
    public Train(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"train"}; 
    }
	int trainID = 0;
	public void ChatMessage(String message)
	{
		System.out.println(LastChatterName() + ": " + message);
		trainID = StrToInt(Username().substring(Username().indexOf(" ") + 1).trim());
		if (LastChatterName().trim().equalsIgnoreCase("Train Leader"))
		{
			System.out.println("* Leader * " + message);
			if (message.startsWith(":Regroup"))
				WalkNoWait(PlayerX(PlayerByName("Train leader")),PlayerY(PlayerByName("Train Leader")));
			if (message.startsWith(":Trade"))
				TradePlayer(PlayerByName(message.substring(7).trim()));
			if (message.startsWith(":Follow"))
				FollowPlayer(PlayerByName(message.substring(8).trim()));
			if (message.startsWith(":Relog"))
				Logout();
			if (message.startsWith(":Say"))
				Say(message.substring(5));
			if (message.startsWith(":Left"))
				WalkNoWait(GetX() - 1, GetY());
			if (message.startsWith(":Right"))
				WalkNoWait(GetX() + 1, GetY());
			if (message.startsWith(":Up"))
				WalkNoWait(GetX(), GetY() - 1);
			if (message.startsWith(":Down"))
				WalkNoWait(GetX(), GetY() + 1);
			if (message.startsWith(":Train"))
			{
				System.out.println("I am train " + trainID);
				if (trainID == 1)
					FollowPlayer(PlayerByName("Train Leader"));
				else {
					int lowestFound = trainID;
					for (int i = trainID; i > 0; i--)
						if (i < trainID)
							if (PlayerByName("Train " + i) != -1)
							{
								System.out.println("I found the nearest lower to be " + i);
								lowestFound = i;
								i = 1;
							}
					FollowPlayer(PlayerByName("Train " + lowestFound));
				}
			}
			if (message.startsWith(":Quit"))
				Quit();
		}
	}
    public void start(String command, String parameter[])
    {
		Println("### TRAIN SCRIPT STARTED");
		while (Running())
		{
			Wait(1);
		}
    }

}
