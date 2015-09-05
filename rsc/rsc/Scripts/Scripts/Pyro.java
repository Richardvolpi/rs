public class Pyro extends Script 
{
	public boolean MustSleep = false;
    public Pyro(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"burn"}; 
    }
	public void ServerMessage(String message)
	{
		if (message.equals("@gam@You are too tired to cut the tree"))
			MustSleep = true;
		if (message.equals("@gre@You are too tired to gain experience, get some rest!"))
			MustSleep = true;
		if (message.equals("You wake up - feeling refreshed"))
			MustSleep = false;
		if (message.equals("@gam@Welcome to RuneScape!"))
			MustSleep = false;
	}
    public void start(String command, String parameter[])
    {
		while (Running())
		{
			int TreeTypes[] = new int [] { 0,1 };
			int TreeCoords[] = GetNearestObject(TreeTypes); 
			if (TreeCoords[0] != -1 && TreeCoords[1] != -1)
			{
				while (ObjectAt(TreeCoords[0],TreeCoords[1]) != 4 && Running() && Sleeping() == false && MustSleep == false)
				{
					AtObject(TreeCoords[0],TreeCoords[1]);
					Wait(Rand(2000,3000));
				}
				while(ObjectAt(GetX(),GetY()) != 97 && Running() && Sleeping() == false && MustSleep == false)
				{
					UseOnItem(GetX(),GetY(),14,FindInv(166));
					Wait(Rand(2000,3000));
				}

			}
			while (MustSleep)
			{
				Use(FindInv(1263));
				Wait(5000);
				long T = System.currentTimeMillis();
				while (Sleeping() && System.currentTimeMillis() - T <= 30000)
					Wait(1);
			}
			Wait(10);
		}
		DisplayMessage("@red@STOPPED", 3);
    }
}
