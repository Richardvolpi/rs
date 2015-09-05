public class pk extends Methods
{
	public pk(mudclient rs)
	{
		super(rs);
	}

	public void Main(String[] args)
	{
		eatingThread.start();
		while(Running())
		{
			if(increaseZoom == true)
			{
				IncreaseZoom(2);
			}
			else
			if(decreaseZoom == true)
			{
				DecreaseZoom(2);
			}
			if(GetMillis() - zoomTimer >= 100 && (increaseZoom || decreaseZoom))
			{
				increaseZoom = false;
				decreaseZoom = false;
			}
			Wait(5);
		}
	}

	public int eatCount = 0;

	public void OnServerMessage(String message)
	{
		message = message.toLowerCase();
		if(message.indexOf("you eat") != -1)
			if(eatCount > 0)
				eatCount--;
	}

	public void OnChatMessage(String sender, String message)
	{
	}

	public boolean fog = true;

	public boolean fog()
	{
		fog = !fog;
		return fog;
	}

	public boolean increaseZoom = false;
	public boolean decreaseZoom = false;
	public long zoomTimer = 0;

	public void OnKeyPress(long keycode)
	{
		if(keycode == 1019)
		{
			eatCount++;
		}
		if(keycode == 1005)
		{
			increaseZoom = true;
			zoomTimer = GetMillis();
		}
		if(keycode == 1004)
		{
			decreaseZoom = true;
			zoomTimer = GetMillis();
		}
		if(keycode == 1001)
			SetZoom(0);
		if(keycode == 1000)
			SetFog(fog());

	}

	Thread eatingThread = new Thread(new Runnable()
	{
		public void run()
		{
			while(Running())
			{
				if(eatCount > 0)
				{
					int old = eatCount;
					if(getFoodPos() != -1)
					{
						UseItem(getFoodPos());
					}
					else
					{
						eatCount = 0;
						Display("Outta food!");
					}
					long waitTime = System.currentTimeMillis();
					while(eatCount == old)
					{
						Wait(10);
						if(System.currentTimeMillis() - waitTime >= 1000)
							break;
					}
				}
				Wait(10);
			}
		}
	});

	public int getFoodPos()
	{
		for(int i = 0; i < CountInv(); i++)
		{
			if(CanEat(InvItemId(i)))
				return i;
		}
		return -1;
	}
}