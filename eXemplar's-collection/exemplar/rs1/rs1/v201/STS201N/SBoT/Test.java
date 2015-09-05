public class Test extends Script 
{
    public Test(mudclient rs){super(rs);}
    
    public String[] getCommands()
    {
        return new String[]{"test"}; 
    }

    public void start(String command, String parameter[])
    {
        while(Running())
        {
            DisplayMessage("Test",3);
            Wait(2000);
        }
    }
}
