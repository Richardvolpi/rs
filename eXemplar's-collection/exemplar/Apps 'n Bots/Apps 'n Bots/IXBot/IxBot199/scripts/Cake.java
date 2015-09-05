public class Cake extends Script {
	public String[] getCommands()
	{
		return new String[]{"cake"};
	}

	public boolean start(String command, String parameters[])
	{
		return true;
	}
	public long run(long ticks)
	{
		int stallIndex = getObjectAt(544, 599);
		if(getObjectCommand2(getObjectType(stallIndex)).equals("steal from")) {
			objectCommand2(stallIndex);
			return random(1000, 500);		// wait 1-1,5 s
		}
		else return random(200, 200);		// wait for spawn
	}
}

