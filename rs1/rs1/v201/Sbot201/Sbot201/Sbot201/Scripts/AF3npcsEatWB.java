//MultiFighter with Eat/WalkBack ~ punKrockeR/Finn - Edited for 3 npc's By OWNED
//Command: /run fight3 <Fight Mode>@<Attack NPC1>@<Attack NPC2@<Attack NPC3>@<Food ID> 

public class AF3npcsEatWB extends Script 
{ 
    public AF3npcsEatWB(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"fight3"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      if (parameter.length != 5) 
      { 
         DisplayMessage("@gre@|SBoT|: @red@Wrong number of parameters. /@ran@RUN FIGHT3 FIGHTMODE@NPC1@NPC2@NPC3@FOODID", 3); 
      } else { 
    System.out.print("|SBoT|: MultiFighter started -Finn/punkrocker - Edited for 3 npc's by Owned"); 
         int FightMode = Integer.parseInt(parameter[0]); 
         int FightTime = (Rand(350,750));  
    int NPC1 = Integer.parseInt(parameter[1]); 
    int NPC2 = Integer.parseInt(parameter[2]); 
    int NPC3 = Integer.parseInt(parameter[3]);
    int Food = Integer.parseInt(parameter[4]); 
    int x = GetX(); 
    int y = GetY(); 
         CheckFighters(true); 
         DisplayMessage("@gre@|SBoT|: @whi@MultiFighter with Eat/WalkBack started", 3); 
         DisplayMessage("@gre@|SBoT|: @whi@Walking back to @cya@("+ x +", "+ y +")", 3); 
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
while (InCombat() == false && Sleeping() == false && GetCurrentStat(3) < 35) 
         {  
    Use(FindInv(Food)); 
         Wait(2000);                  
         } 
                  if (Sleeping() == false) 
                  {  
                        long T = System.currentTimeMillis(); 
                        int IDs[] = new int[] {NPC1, NPC2, NPC3}; 
                        int Monsters = GetNearestNPC(IDs); 
                        AttackNPC(Monsters); 
if(Monsters == -1 && GetX() != x && GetY() != y && Running() && !InCombat()) 
{ 
ForceWalkNoWait(x,y); 
} 

  

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
      DisplayMessage("@gre@|SBoT|: @whi@MultiFighter with Eat/WalkBack @red@STOPPED", 3); 
    } 
}


