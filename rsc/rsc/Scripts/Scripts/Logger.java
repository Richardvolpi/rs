public class Logger extends Script 
{
    public Logger(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"logged"}; 
    }
	public void ServerMessage(String message)
	{
	}
    public void start(String command, String parameter[])
    {
		Println("Started <3");
		long T = TickCount();
		int startX = GetX();
		int startY = GetY();
		while (Running())
		{
			int goingX = startX + Rand(-5,5);
			int goingY = startY + Rand(-5,5);
			while (!CanReach(goingX,goingY))
			{
				goingX = startX + Rand(-5,5);
				goingY = startY + Rand(-5,5);
			}
			WalkNoWait(goingX,goingY);
			Wait(Rand(10000,30000));
			Println("Running for " + (int)((TickCount() - T) / 1000) + " seconds!");
		}
    }
}
