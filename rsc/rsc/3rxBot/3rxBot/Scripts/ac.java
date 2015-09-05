public class ac extends Methods
{
	public ac(mudclient rs)
	{
		super(rs);
	}

	public void Main(String[] args)
	{
		long attackTimer = 0;
		while(Running())
		{
			int[] player = GetPlayerById(LastAttackedPlayer());
			if(InCombat() || PlayerInCombat(player[0]))
			{
				Wait(10);
			}
			else
			{
				if(!HealthBarShowing() && !PlayerHpBarShowing(player[0]) && HitsPercent() >= 90)
				{
					AttackPlayer(LastAttackedPlayer());
				}
				else
				{
					ForceWalkTo(PlayerDestX(player[0]), PlayerDestY(player[0]));
					if(HitsPercent() < 90)
					{
						if(getFoodPos() != -1)
							UseItem(getFoodPos());
						else
						{
							Display("FOOOOK! Outta food!");
							End();
						}
					}
				}
			}
			Wait(20);
		}
	}

	public int getFoodPos()
	{
		for(int i  = 0; i < CountInv(); i++)
		{
			if(CanEat(InvItemId(i)))
				return i;
		}
		return -1;
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
}