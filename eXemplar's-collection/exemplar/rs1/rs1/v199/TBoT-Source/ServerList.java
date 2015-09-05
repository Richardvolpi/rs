public class ServerList
{
	public static String worldname[] = { "http://uk1.runescape.com/client2/", "http://uk1.runescape.com/client2/", "http://ul3.runescape.com/client2/", "http://ul3.runescape.com/client2/", "http://cet3b.runescape.com/client2/", "http://cet3b.runescape.com/client2/" };
	public static String worldip[] = { "uk1.runescape.com", "uk1.runescape.com", "ul3.runescape.com", "ul3.runescape.com", "cet3b.runescape.com", "cet3b.runescape.com" };
	public static int world = 51;

	public static String getWorld()
	{
		return worldip[world - 51];
	}
	public static int getPort()
	{
		if (world == 51 || world == 53 || world == 55)
		{
			return 43594;
		} else {
			return 43595;
		}
	}
	public static void setWorld(int no)
	{
		if (no < 57 && no > 50)
			world = no;
	}
};