public class AutoDuel extends Script
{
    public AutoDuel(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"mage"};
    }
    public void start(String command, String parameter[])
    {
      if (parameter.length != 1)
    {
      DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN MAGE [PLAYER ID]", 3);
    } else {
         int PlayerID = Integer.parseInt(parameter[0]);
         DisplayMessage("@gre@SBoT: @whi@AutoMageStake - yomama`", 3);
         while (Running())
         {
          {
           DisplayMessage("@Gre@SBoT: @whi@Set to defence",3);
           SetFightMode(3);
           Wait(75);           
          }
         { 
          DisplayMessage("@Gre@SBoT: @whi@Maging",3);
          MagicPlayer(PlayerID, 33);
//change that 17 for a diffrent spell^
          Wait(1000);
         }
        }
      }
      DisplayMessage("@gre@SBoT: @whi@AutoMager - @red@STOPPED", 3);
    }
} 