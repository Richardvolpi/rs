public class sell extends Script
{
    public sell(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"sell"};
    }
    public void start(String command, String parameter[])
    {     
      String word = parameter[0];
      String col[] = {"@gre@","@blu@","@cya@","@ran@","@yel@","@whi@"};
      while (Running())
      {
      int ah = (Rand(0,5));
      Say("" + col[ah] + word);
      Wait(10000);
      }
      DisplayMessage("@red@STOPPED", 3);
}
} 