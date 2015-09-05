public class autoFight extends Methods
{
	public autoFight(mudclient rs)
	{
		super(rs);
	}

	public void Main(String[] args)
	{
		try
		{
			LockMode(Integer.parseInt(args[0]));
		}
		catch(Exception e)
		{
			Display("You have forgotten to specify a fight mode, Or you entered an invalid one.");
			Display("usage: \"/run autofight (fightmode)\" where fightmode is a number(0-3)");
			End();
		}
		AutoLogin(true);
		int count = 0;
		int[] temp = new int[794];
		for(int i = 0; i <= 793; i++)
		{
			if(NpcAttackable(i))
			{
				temp[count] = i;
				count++;
			}
		}
		System.out.println(count + " attackable npcs exists!");
		ids = new int[count];
		for(int i = 0; i < count; i++)
		{
			//System.out.println(i + " - " + temp[i] + ": " + NpcName(i));
			ids[i] = temp[i];
			//Wait(1000);
		}
		temp = null;
		while(Running())
		{
			long l = System.currentTimeMillis() + getDelay();
			while(System.currentTimeMillis() - l < 0 && Running())
			{
				Wait(5);
			}
		}
	}

	public void OnServerMessage(String message)
	{
		//When there is a server message, This void is triggered.
	}

	public void OnChatMessage(String sender, String message)
	{
		//When there is a chat message, This void is triggered.
	}

	public void OnKeyPress(long keycode)
	{
	}

	public int[] getNearestNpc()
	{
		return GetNpcById(ids);
	}

	public long getDelay()
	{
		if(InCombat() || Sleeping())
		{
			return(10);
		}
		if(GetFatigue() >= 90)
		{
			UseItem(GetItemPos(1263));
			return(Rand(1000,3000));
		}
		if(getNearestNpc()[0] != -1)
		{
			AttackNpc(getNearestNpc()[0]);
			if(!IsWalking())
				return(Rand(100,1000));
			else
				return(Rand(1000,5000));
		}
		return(10);
	}

	public int ids[];
	public int pIds = 1289;
}