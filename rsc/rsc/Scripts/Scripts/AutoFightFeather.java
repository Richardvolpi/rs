public class AutoFightFeather extends Script 
{ 
    public AutoFightFeather(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"fightfeather"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 2) 
      { 
         DisplayMessage("@yel@Mod Mark: Invalid number of parameters. /RUN FIGHT [STYLE] [NPC TYPE]", 3); 
      } else { 
         int FightMode = Integer.parseInt(parameter[0]); 
         int FightTime = 750; 
         int FightType = Integer.parseInt(parameter[1]); 
         CheckFighters(true); 
         DisplayMessage("@yel@Mod Mark: Autofighter N' Picker started - ri**** (richyt and curtis)", 3); 
         while (Running() == true && GetCurrentStat(3) > 8) 
         { 
            if (GetFightMode() != FightMode) 
            { 
               SetFightMode(FightMode); 
               DisplayMessage("@yel@Mod Mark: Your new fight mode is: " + GetFightMode(),  3); 
            } 
            if (InCombat() == false) 
            { 
               if (Fatigue() > 97 && Sleeping() == false) 
               { 
                  DisplayMessage("@yel@Mod Mark: Sleeping...", 3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 
               } else  
    
                  if (Sleeping() == false) 
                  { 
                        while(GetNearestItem(381) != null && Running() == true && InCombat() == false && Sleeping() == false) { 
                        int ItemPos[] = GetNearestItem(381); 

                        TakeItem(ItemPos[0], ItemPos[1],381); 
                        Wait(2500); 
      { 
                     int ID = GetNearestNPC(FightType); 
                     if (ID != -1) 
                     { 
                        long T = System.currentTimeMillis(); 
                        AttackNPC(ID); 
                        while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true) 
                           Wait(1); 
                     } else 
                        Wait(1); 
                  } 
               } 
             } 
            } else { 
               while (InCombat() == true && Running() == true) 
                  Wait(1); 
            } 
         } 
      } 
      DisplayMessage("@yel@Mod Mark: Autofighter\feather picker stopped.", 3); 
    } 
}