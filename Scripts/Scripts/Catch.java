public class Catch extends Script 
{ 
   public Catch(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"catch"}; 
   } 

   public void start(String command, String parameter[]) 
   { 
      DisplayMessage("@bla@AutoCatcher",3); 
      DisplayMessage("@gre@By: Davis Zanot",3); 
      int PlayerID = Integer.parseInt(parameter[0]); 
      int HPDifference = 0; 
      while (Running()) 
      { 
	  SetFightMode(1); 
          HPDifference = GetStat(3) - GetCurrentStat(3); 
          while (!InCombat() && Running() && HPDifference < 12) 
          { 
	      AttackPlayer(PlayerID);
 	      SetFightMode(1);  
              Wait(50);              
          }
          HPDifference = GetStat(3) - GetCurrentStat(3); 
          while (!InCombat() && Running() && HPDifference > 12) 
          { 
	      ForceWalkNoWait(PlayerDestX(PlayerID),PlayerDestY(PlayerID));
	      PrayerOff(10);
	      Use(FindInv(373)); 
              Wait(100); 
          } 
          while (InCombat() && Running()) 
          { 
              if (GetFightMode() != 1) 
              { 
                  PrayerOn(10);
		  SetFightMode(1); 
                  Wait(10); 
              } 
          } 
      } 
      DisplayMessage("@red@STOPPED", 3); 
   } 

} 