//MultiFighter ~ punKrockeR 
//Command: /run multi <Fight Mode>@<Attack NPC1>@<Attack NPC2> 

public class MultiFighter extends Script 
{ 
    public MultiFighter(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"multi"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 3) 
      { 
         DisplayMessage("@gre@|SBoT|: @ran@I@whi@nvalid @ran@n@whi@umbe@ran@r @whi@of parameters. /@ran@RUN MULTI FIGHTMODE@NPC1@NPC2", 3); 
      } else { 
    System.out.print("|SBoT|: MultiFighter started -punKrockeR"); 
         int FightMode = Integer.parseInt(parameter[0]); 
         int FightTime = (Rand(350,750));  
    int NPC1 = Integer.parseInt(parameter[1]); 
    int NPC2 = Integer.parseInt(parameter[2]); 
         CheckFighters(true); 
         DisplayMessage("@gre@|SBoT|: @ran@M@whi@ulti@ran@F@whi@ighter - pun@ran@K@whi@rocke@ran@R", 3); 
         while (Running() == true && GetCurrentStat(3) > 5) 
         { 
            if (GetFightMode() != FightMode) 
            { 
      { 
                SetFightMode(FightMode); 
      } 

      if(GetFightMode() == 0) 
      { 
      DisplayMessage("@gre@|SBoT|: @ran@F@whi@ight@ran@M@whi@ode @ran@S@whi@et @ran@T@whi@o @red@|CAUTION| @yel@CONTROLLED", 3); 
      } 

      if(GetFightMode() == 1) 
      { 
      DisplayMessage("@gre@|SBoT|: @ran@F@whi@ight@ran@M@whi@ode @ran@S@whi@et @ran@T@whi@o @yel@STRENGTH", 3); 
      }    

      if(GetFightMode() == 2) 
      { 
      DisplayMessage("@gre@|SBoT|: @ran@F@whi@ight@ran@M@whi@ode @ran@S@whi@et @ran@T@whi@o @yel@ATTACK", 3); 
      } 

      if(GetFightMode() == 3) 
      { 
      DisplayMessage("@gre@|SBoT|: @ran@F@whi@ight@ran@M@whi@ode @ran@S@whi@et @ran@T@whi@o @red@|CAUTION| @yel@DEFENSE", 3); 
      }    
            } 
            if (InCombat() == false) 
            { 
               if (Fatigue() > 99 && Sleeping() == false) 
               { 
                  DisplayMessage("@gre@|SBoT|: @ran@S@whi@leeping", 3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 
               } else { 
                  if (Sleeping() == false) 
                  {  
                        long T = System.currentTimeMillis(); 
                        int IDs[] = new int[] {NPC1, NPC2}; 
                        int Monsters = GetNearestNPC(IDs); 
                        AttackNPC(Monsters); 

                        while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true) 
                           Wait(1); 
                     } else 
                        Wait(1); 
               } 
            } else { 
               while (InCombat() == true && Running() == true) 
                  Wait(1); 
            } 
         } 
      } 
      DisplayMessage("@gre@|SBoT|: @ran@M@whi@ulti@ran@F@whi@ighter - @red@*-* @yel@STOPPED @red@*-*", 3); 
    } 
}