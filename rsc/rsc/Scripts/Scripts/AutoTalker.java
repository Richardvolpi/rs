public class AutoTalker extends Script 
{ 
   public AutoTalker(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"say"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
      String SayMe = parameter[0]; 
      int WaitTime = Integer.parseInt(parameter[1]); 
      DisplayMessage("@bla@Auto Talker",3); 
      DisplayMessage("@gre@By: Davis Zanot",3); 
      while (Running()) 
      { 
          Say(SayMe); 
     Wait(WaitTime);      
      } 
      DisplayMessage("@red@STOPPED", 3); 
   } 
}