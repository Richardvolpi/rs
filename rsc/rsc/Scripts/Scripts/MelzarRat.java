public class MelzarRat extends Script 
{ 
    public MelzarRat(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"melzar"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
    { 
         CheckFighters(true); 
    System.out.println(""); 
    System.out.println("-= Melzar's Maze Rat Slayer by MR_L337 =-"); 
    System.out.println(""); 
    System.out.println("= Features: ="); 
    System.out.println("-Attacking All The Rats In The Maze"); 
    System.out.println("-Auto-Eating A Lobster If You Lose 12hp"); 
    System.out.println("-Door-Opening So You Can't Get Locked In The Small Room"); 
    System.out.println("-Puts On ONLY Aggressive Fightmode"); 
    System.out.println(""); 
    System.out.println("Have Fun Autoing! :)"); 
    System.out.println(""); 
         while (Running() == true && InvCount(373) > 0) 
         { 
            if (GetFightMode() != 1) 

            { 
               SetFightMode(1); 
          System.out.println(""); 
               System.out.println("FightMode Set To Aggressive"); 
            } 

       if (Sleeping() == false && DoorAt(346, 637, 0) != 1 && GetY() > 636) 

      { 
         System.out.println(""); 
         System.out.println("Opening The Door At Coordinates (346, 637, 0)"); 
         OpenDoor(346, 637, 0); 
         Wait(3500); 
      } 

        if (InCombat() == false && Sleeping() == false && GetStat(3) - GetCurrentStat(3) > 12) 

      { 
         System.out.println(""); 
         System.out.println("Eating A Lobster (" + GetCurrentStat(3)+"/"+GetStat(3)+"hp), Still Got "+(InvCount(373) -1)+" Lobsters Left"); 
         Use(FindInv(373)); 
         Wait(3000); 
      } 

        if (InCombat() == false && Sleeping() == false && GetStat(3) - GetCurrentStat(3) > 12 && InvCount(373) == 0) 

      { 
         System.out.println(""); 
         System.out.println("Got No Lobsters Left, Autoing Stopped!"); 
      } 

            if (InCombat() == false) 
            { 
               if (Fatigue() >= 95 && Sleeping() == false) 
               { 
        System.out.println(""); 
                  System.out.println("Sleeping At" + Fatigue()+" Fatigue"); 
                  Use(FindInv(1263)); 
                  Wait(5000); 

               } else { 

                  if (Sleeping() == false && GetFightMode() == 1 && GetStat(3) - GetCurrentStat(3) < 13 && InvCount(373) > 0) 

                  { 
           int NPCTypes[] = new int [] {47, 177}; 
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