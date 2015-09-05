public class Trader extends Script 
{
    public Trader(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"trade"}; 
    }
	public void ServerMessage(String message)
	{
	}
    public void start(String command, String parameter[])
    {
		TradeArray(10, Integer.parseInt(parameter[0]));
		UpdateTrade();
    }
}
