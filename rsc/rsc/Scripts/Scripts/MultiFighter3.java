
public class MultiFighter3 extends Script 
{ 
    public MultiFighter3(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"multi3"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 5) 
      { 
         DisplayMessage("@mag@invalid number of parameters. /@ran@RUN MULTI FIGHTMODE@NPC1@NPC2", 3); 
      } else { 
    System.out.print("Multi Fighter started"); 
         int FightMode = Integer.parseInt(parameter[0]); 
         int FightTime = (Rand(350,750));  
         int NPC1 = Integer.parseInt(parameter[1]); 
         int NPC2 = Integer.parseInt(parameter[2]); 
         int NPC3 = Integer.parseInt(parameter[3]); 
         int ItemId =  Integer.parseInt(parameter[4]);
         CheckFighters(true); 
         DisplayMessage("@gre@Multi Fighter", 3); 
         while (Running() == true && GetCurrentStat(3) > 5) 
         { 
            if (GetFightMode() != FightMode) 
            { 
      { 
                SetFightMode(FightMode); 
      } 

      if(GetFightMode() == 0) 
      { 
      DisplayMessage("@yel@CONTROLLED", 3); 
      } 

      if(GetFightMode() == 1) 
      { 
      DisplayMessage("@yel@STRENGTH", 3); 
      }    

      if(GetFightMode() == 2) 
      { 
      DisplayMessage("@yel@ATTACK", 3); 
      } 

      if(GetFightMode() == 3) 
      { 
      DisplayMessage("@yel@DEFENSE", 3); 
      }    
            } 
            if (InCombat() == false) 
            { 
               if (Fatigue() > 97 && Sleeping() == false) 
               { 
                  DisplayMessage("@ora@ Sleeping", 3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 
               } else { 
                  if (Sleeping() == false) 
                  {  

            if (GetStat(3) - GetCurrentStat(3) > 12 && Sleeping() == false) 
            { 
                  Println("SBoT: Eating a lobster."); 
                  Use(FindInv(373)); 
                  Wait(500); 
            } 

                        long T = System.currentTimeMillis(); 
                        int Item [] = GetNearestItem(ItemId); 
                            if(Item != null) 
                               { 
                                TakeItem(Item[0], Item[1], ItemId); 
                                Wait(500); 
                               }
                        int IDs[] = new int[] {NPC1, NPC2, NPC3}; 
                        int Monsters = GetNearestNPC(IDs); 
                        AttackNPC(Monsters); 
                         
                           



                        while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true) 
                            Wait(Rand(250,650)); 
                     } else 
                        Wait(Rand(250,650)); 
               } 
            } else { 
               while (InCombat() == true && Running() == true) 
                  Wait(Rand(250,650)); 
            } 
         } 
      } 
      DisplayMessage("@gre@ STOPPED", 3); 
    } 
} 
