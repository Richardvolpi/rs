public class ServerList
{
	public static String worldname[] = { "http://ph3.runescape.com/client2/", "http://ph3.runescape.com/client2/", "http://uk1.runescape.com/client2/", "http://uk1.runescape.com/client2/", "http://ul3.runescape.com/client2/", "http://ul3.runescape.com/client2/", "http://cet3.runescape.com/client2/", "http://cet3.runescape.com/client2/" };
	public static int world = 29;

	public static String getWorld()
	{
		return worldname[world - 29];
	}
	public static int getPort()
	{
		if (world == 29 || world == 31 || world == 33 || world == 37)
		{
			return 0;
		} else {
			return 1;
		}
	}
	public static void setWorld(int no)
	{
		world = no;
	}
};