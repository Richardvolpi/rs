public class PWNZ extends Script 
{ 
    public PWNZ(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"pwnz"}; 
    } 
     public void ServerMessage(String message) 
     { 
     if (InLastServerMessage("You eat the lobster ")) 
        { 
      LobsterCount++; 
   } 
     if (InLastServerMessage("You wake up - feeling refreshed")) 
        { 
      BagCount++;; 
   } 
     if(InLastServerMessage("You just advanced 1")) 
       { 
           LVL++; 
       } 

     } 
    int StartAttXP = 0; 
    int StartDefXP = 0; 
    int StartStrXP = 0; 
    int StartHitsXP = 0; 
    int StartAttLevel = 0; 
    int StartDefLevel = 0; 
    int StartStrLevel = 0; 
    int StartHitsLevel = 0; 
    int LVL = 0; 
    int BagCount = 0; 
    int LobsterCount = 0; 
    long StartTime = 0; 
    public void KeyPressed(int id) 
    { 
       if (id == 1012) // F5, Shows starting stats and xp 
       { 
           DisplayMessage("@gre@***  STARTING STATS AND EXP !!  ***", 3); 
           DisplayMessage("@cya@ Attack: " + StartAttXP + " xp (" + StartAttLevel + "lvl) ", 3);  
           DisplayMessage("@cya@ Defence: " + StartDefXP + " xp (" + StartDefLevel + "lvl) ", 3); 
           DisplayMessage("@cya@ Strenght: " + StartStrXP + " xp (" + StartStrLevel + "lvl) ", 3); 
           DisplayMessage("@cya@ Hits: " + StartHitsXP + " xp (" + StartHitsLevel + "lvl) ", 3); 
      System.out.println("**********  STARTING STATS AND EXP !!  **********"); 
      System.out.println("***** ATTACK: " + StartAttXP + " xp (" + StartAttLevel + "lvl) *****"); 
      System.out.println("***** DEFENCE: " + StartDefXP + " xp (" + StartDefLevel + "lvl) *****"); 
      System.out.println("***** STRENGHT: " + StartStrXP + " xp (" + StartStrLevel + "lvl) *****"); 
      System.out.println("***** Hits: " + StartHitsXP + " xp (" + StartHitsLevel + "lvl) *****"); 
           id = 0; 
       } 
       if (id == 1013) // F6, Shows curently stats and xp 
       { 
           DisplayMessage("@gre@***  CURRENTLY STATS AND EXP !!  ***", 3);  
           DisplayMessage("@cya@ Attack: " + GetExperience(0) + " xp (" + GetStat(0) + "lvl) ", 3);  
           DisplayMessage("@cya@ Defence: " + GetExperience(1) + " xp (" + GetStat(1) + "lvl) ", 3); 
           DisplayMessage("@cya@ Strenght: " + GetExperience(2) + " xp (" + GetStat(2) + "lvl) ", 3); 
           DisplayMessage("@cya@ Hits: " + GetExperience(3) + " xp (" + GetStat(3) + "lvl) ", 3); 
      System.out.println("**********  CURRENT STATS AND EXP !!  **********"); 
      System.out.println("***** ATTACK: " + GetExperience(0) + " xp (" + GetStat(0) + "lvl) *****"); 
      System.out.println("***** DEFENCE: " + GetExperience(1) + " xp (" + GetStat(1) + "lvl) *****"); 
      System.out.println("***** STRENGHT: " + GetExperience(2) + " xp (" + GetStat(2) + "lvl) *****"); 
      System.out.println("***** Hits: " + GetExperience(3) + " xp (" + GetStat(3) + "lvl) *****"); 
           id = 0; 
       } 
       if (id == 1014) // F7, Shows Gained XP and LVL(s) 
       {  
           DisplayMessage("@gre@*** GAINED EXP AND LVL !!  ***", 3);  
           DisplayMessage("@cya@ Gained Attack: " + (GetExperience(0) - StartAttXP) + " xp (" + (GetStat(0) - StartAttLevel) + "lvl) ", 3);  
           DisplayMessage("@cya@ Gained Defence: " + (GetExperience(1) - StartDefXP) + " xp (" + (GetStat(1) - StartDefLevel) + "lvl) ", 3); 
           DisplayMessage("@cya@ Gained Strenght: " + (GetExperience(2) - StartStrXP) + " xp (" + (GetStat(2) - StartStrLevel) + "lvl) ", 3); 
           DisplayMessage("@cya@ Gained Hits: " + (GetExperience(3) - StartHitsXP) + " xp (" + (GetStat(3) - StartHitsLevel) + "lvl) ", 3); 
      System.out.println("**********  CURRENT STATS AND EXP !!  **********"); 
      System.out.println("***** Gained ATTACK: " + (GetExperience(0) - StartAttXP) + " xp (" + (GetStat(0) - StartAttLevel) + "lvl) *****"); 
      System.out.println("***** Gained DEFENCE: " + (GetExperience(1) - StartDefXP) + " xp (" + (GetStat(1) - StartDefLevel) + "lvl) *****"); 
      System.out.println("***** Gained STRENGHT: " + (GetExperience(2) - StartStrXP) + " xp (" + (GetStat(2) - StartStrLevel) + "lvl) *****"); 
      System.out.println("***** Gained Hits: " + (GetExperience(3) - StartHitsXP) + " xp (" + (GetStat(3) - StartHitsLevel) + "lvl) *****"); 
           id = 0; 
       } 
       if (id == 1015) // F8, Shows Info 
       { 
           DisplayMessage("@gre@***  INFO  ***", 3);  
           DisplayMessage("@cya@ Level(s) Gained: " + LVL + "(s)", 3);  
           DisplayMessage("@cya@ Eat " + LobsterCount + " Lobster(s) ", 3); 
           DisplayMessage("@cya@ Sleeped " + BagCount + " Time(s)", 3); 
           DisplayMessage("@cya@ Time Have Passed: " + ((long)((int)(TickCount() / 1000)) - StartTime) / 60 + "min" , 3); 
      System.out.println("**********  INFO  **********"); 
      System.out.println("***** Level(s) Gained: " + LVL + " *****"); 
      System.out.println("***** Eat " + LobsterCount + " Lobster(s) *****"); 
      System.out.println("***** Sleeped " + BagCount + " Time(s) *****"); 
      System.out.println("***** Time Have Passed: " + ((long)((int)(TickCount() / 1000)) - StartTime) / 60 + "min *****"); 
           id = 0; 
       } 
    } 
    public void start(String command, String parameter[]) 
    { 
      StartAttXP = GetExperience(0); 
      StartAttLevel = GetStat(0); 
      StartDefXP = GetExperience(1); 
      StartDefLevel = GetStat(1); 
      StartStrXP = GetExperience(2); 
      StartStrLevel = GetStat(2); 
      StartHitsXP = GetExperience(3); 
      StartHitsLevel = GetStat(3); 
      StartTime = (long)((int)(TickCount() / 1000)); 
      if (parameter.length != 2) 
      { 
         DisplayMessage("@gre@SBoT: @whi@Invalid number of parameters. /RUN pwnz [STYLE] @ [NPC]", 3); 
      } else { 
         int FightMode = Integer.parseInt(parameter[0]); 
    int FightType = Integer.parseInt(parameter[1]);  
         CheckFighters(true); 
    System.out.println(""); 
    System.out.println("-= pepsi1's PWNZ AutoFighter =-"); 
    System.out.println(""); 
    System.out.println(" Hotkeys F5 F6 F7 F8 ");  
    System.out.println(" -F5 = Starting Stats / XP"); 
    System.out.println(" -F6 = Current Stats / XP"); 
    System.out.println(" -F7 = Gained XP / LVL(s)"); 
    System.out.println(""); 
    System.out.println(" Auto-Eating A Lobster If You Lose 12hp");    
    System.out.println(""); 
    System.out.println(" You Have Started To Autoing! :o"); 
    System.out.println(""); 
    DisplayMessage("@gre@SBoT: @ora@pepsi1's PWNZ AutoFighter",  3); 
         while (Running() == true && InvCount(373) > 0) 
         { 
            if (GetFightMode() != FightMode) 

            { 
               SetFightMode(FightMode); 
               System.out.println(""); 
               System.out.println("FightMode Set To " + GetFightMode()); 
          DisplayMessage("@gre@SBoT: @cya@FightMode Changed To " + GetFightMode(),  3); 
            } 

        if (InCombat() == false && Sleeping() == false && GetStat(3) - GetCurrentStat(3) > 12) 

      { 
         System.out.println(""); 
         System.out.println("Eating A Lobster (" + GetCurrentStat(3)+"/"+GetStat(3)+"hp), Still Got "+(InvCount(373) -1)+" Lobsters Left"); 
    DisplayMessage("@gre@SBoT: @cya@Eating A Lobster (" + GetCurrentStat(3)+"/"+GetStat(3)+"hp), Still Got "+(InvCount(373) -1)+" Lobsters Left",  3); 
         Use(FindInv(373)); 
         Wait(3000); 
      } 

        if (InCombat() == false && Sleeping() == false && GetStat(3) - GetCurrentStat(3) > 12 && InvCount(373) == 0) 

      { 
         System.out.println(""); 
         System.out.println("Got No Lobsters Left, Autoing Stopped!"); 
    DisplayMessage("@gre@SBoT: @cya@OMG!!! No Lobsters Anymore, Autoing Atopped!",  3); 
      } 

            if (InCombat() == false) 
            { 
               if (Fatigue() >= 98 && Sleeping() == false) 
               { 
             System.out.println(""); 
                  System.out.println("Sleeping At" + Fatigue()+" Fatigue"); 
        DisplayMessage("@gre@SBoT: @cya@Sleeping At" + Fatigue()+" Fatigue",  3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 

               } else { 

                  if (Sleeping() == false && GetFightMode() == FightMode && GetStat(3) - GetCurrentStat(3) < 13 && InvCount(373) > 0) 

                  { 
                   int NPCTypes[] = new int [] {FightType}; 
                     int NPCID = GetNearestNPC(NPCTypes); 
                     if (NPCID != -1) 
                     { 
                        AttackNPC(NPCID);  
                        Wait(1000); 

                     } 
                  } 

               } 
            } 
         } 
      } 
    } 
} 