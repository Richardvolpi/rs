public class ServerMessage extends Script
{
    public ServerMessage(mudclient rs)
    {
       super(rs);
    }
   public String[] getCommands()
    {
       return new String[]{"server"};
    }
    public void start(String command, String parameter[])
    {
    while(Running())
    {
    	if(!GetLastServerMessage().equals(""))
    	{
    	PrintLine(GetLastServerMessage());
    	ResetMessages();
    	}
    	else
    	Wait(1);
    }
    Stop();
    }
}