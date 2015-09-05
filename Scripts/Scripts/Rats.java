public class Rats extends Script 
{ 
   public Rats(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"rats"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
         int FM = Integer.parseInt(parameter[0]); 
         int FT = 500; 
         CheckFighters(true); 
      DisplayMessage("@Whi@RimmingtonRats - @gre@Made By @yel@X@mag@p@red@j@cya@X @whi@- @bla@Started",3); 
      while (Running()) 
   { 
      { 
            if (GetFightMode() != FM) 
            { 
               SetFightMode(FM); 
               DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(),  3); 
            } 

   { 
                    if (Fatigue() > 97 && Sleeping() == false) 
                      { 
                         DisplayMessage("@gre@SBoT: @whi@Sleeping", 3); 
                         Use(FindInv(1263)); 
                         Wait(10000); 
                      }else { 
                       if (Sleeping() == false) 
                    { 
                        int ID = GetNearestNPC(29); 
                        if (ID != -1) 
                         { 
                           long T = System.currentTimeMillis(); 
                           AttackNPC(ID); 
                          while (System.currentTimeMillis() - T <= FT && InCombat() == false && Running() == true) 
                              Wait(500); 
                         } else 
                        Wait(500); 
                  } 
               } 
            }  { 
               while (InCombat() == true && Running() == true) 
                  Wait(500); 
  
             if (GetNearestItem(81) != null) 
         { 
            int ItemPos[] = GetNearestItem(81); 

            TakeItem(ItemPos[0], ItemPos[1],81); 
            Wait(10000); 
         }      
      } 
} 
      } 

      DisplayMessage("@Whi@RimmingtonRats - @gre@Made By @yel@X@mag@p@red@j@cya@X @whi@- @bla@Stopped", 3); 
    } 
} 