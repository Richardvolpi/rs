public class AutoPK0Rpublic extends Script 
{ 
    public AutoPK0Rpublic(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"magepk"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 2) 
    { 
      DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN MAGE [PLAYER ID]@[SPELL ID]", 3); 
    } else { 
         int PlayerID = Integer.parseInt(parameter[0]); 
         int SpellID = Integer.parseInt(parameter[1]); 
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
          MagicPlayer(PlayerID, SpellID); 
          Wait(1000); 
         } 
        } 
      } 
      DisplayMessage("@gre@SBoT: @whi@AutoMager - @red@STOPPED", 3); 
    } 
} 
