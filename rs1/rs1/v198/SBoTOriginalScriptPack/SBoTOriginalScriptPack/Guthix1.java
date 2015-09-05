public class Guthix1 extends Script
{
    public Guthix1(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"ownages"};
    }
    public void start(String command, String parameter[])
    {
     
    {
     
        int SPELL = Integer.parseInt(parameter[1]);
         DisplayMessage("@gre@SBoT: @blu@Goodluck ;)", 3);
     int PLAYER = Integer.parseInt(parameter[0]);   
      while (Running())
         {
         
         { 
         
          MagicPlayer(PLAYER, SPELL);
          Wait(1000);
         }
        }
      }
      DisplayMessage("@gre@Your welcome", 3);
    }
} 