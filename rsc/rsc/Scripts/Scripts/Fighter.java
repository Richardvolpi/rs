public class Fighter extends Script 
{ 
   public Fighter(mudclient rs) 
   { 
       super(rs); 
   } 
   public String[] getCommands() 
   { 
       return new String[]{"fighter"}; 
   } 
   public void start(String command, String parameter[]) 
   { 
  int Stat[] = new int[4]; 
  for(int h=0;h<Stat.length;h++) 
  { 
     Stat[h] = GetStat(h); 
  } 
  String Stats[] = new String[4]; 
  Stats[0] = "Attack"; 
  Stats[1] = "Defence"; 
  Stats[2] = "Strength"; 
  Stats[3] = "Hits"; 
  String FightMode; 
  String Food; 
  int FoodID = 359; 
  int FightModeID = 2; 
  int NPCID; 
  int Heals = 7; 
  int Count = 0; 
  int Count2 = 0; 
  int FightDelay = 1000; 
  // Change this depending upon computer specificiations 

  FoodID = Integer.parseInt(parameter[0]); 
  FightModeID = Integer.parseInt(parameter[1]); 
  NPCID = Integer.parseInt(parameter[2]); 
  switch(FightModeID) 
  { 
     case 0: FightMode = "Controlled"; 
     break; 
     case 1: FightMode = "Aggressive"; 
     break; 
     case 2: FightMode = "Accurate"; 
     break; 
     case 3: FightMode = "Defensive"; 
     break; 
     default: FightMode = "Incorrect"; 
  } 
  switch(FoodID) 
  { 
     case 373:   Food = "Lobster"; 
           Heals = 12; 
     break; 
     case 546:   Food = "Shark"; 
           Heals = 20; 
     break; 
     case 359:   Food = "Trout"; 
           Heals = 7; 
     break; 
     case 357:   Food = "Salmon"; 
           Heals = 8; 
     break; 
     case 330:   Food = "Cake"; 
           Heals = 4; 
     break; 
     default:   Food = "" + FoodID; 
  } 
  DisplayMessage("@yel@Notice: @whi@All information will be showed in DOS screen to reduce lag.",3); 
  for(int i=0;i<30;i++)    
     System.out.println(); 
  System.out.println("Ultimate Fight Script Started - Created by XRoader / TomX"); 
  System.out.println("---------------------------------------------------------"); 
  System.out.println("Fight Mode: " + FightMode); 
  System.out.println("Type of Food: " + Food + "(" + FoodID + ")"); 
  System.out.println("Quantity of " + Food + ": " + InvCount(FoodID) + "(" + (Heals*InvCount(FoodID)) + ")"); 
  System.out.println("NPC ID: " + NPCID); 
  System.out.println("Stats: " + Stat[0] + "-" + Stat[1] + "-" + Stat[2] + "-" + Stat[3]); 
  System.out.println(); 
  while ( (Running()) && ((FoodID!=330 && InvCount(FoodID)>0) || (FoodID==330 && (InvCount(330)>0 || InvCount(333)>0 || InvCount(335)>0)))) 
  { 
     while(   (GetStat(3) - GetCurrentStat(3) > Heals && 
        Running()) && 
        ((FoodID!=330 && InvCount(FoodID)>0) || (FoodID==330 && (InvCount(330)>0 || InvCount(333)>0 || InvCount(335)>0)))) 
     { 
        if(FoodID == 330) 
        { 
           if(InvCount(335) > 0) 
           { 
              Use(FindInv(335)); 
              Wait(FightDelay + 250); 
              System.out.println("Hits: " + GetCurrentStat(3) + "/" + GetStat(3) + " - Ate a slice of cake."); 
              break; 
           } else 
           if(InvCount(333) > 0) 
           { 
              Use(FindInv(333)); 
              Wait(FightDelay + 250); 
              System.out.println("Hits: " + GetCurrentStat(3) + "/" + GetStat(3) + " - Ate a piece of cake."); 
              break; 
           } else 
           if(InvCount(330) > 0) 
           { 
              Use(FindInv(330)); 
              Wait(FightDelay + 250);                
              System.out.println("Hits: " + GetCurrentStat(3) + "/" + GetStat(3) + " - Ate a cake."); 
              break; 
           } 
           System.out.println("Number of Cakes: " + ( (InvCount(330)) + (InvCount(333)*0.666) + (InvCount(335)*0.333) )); 
            
        } 
        else 
        { 
           Use(FindInv(FoodID)); 
           Wait(FightDelay+250); 
           System.out.println("Hits: " + GetCurrentStat(3) + "/" + GetStat(3) + " - Ate a " + Food + "."); 
           System.out.println("Number of " + Food + "s: " + InvCount(FoodID)); 
        } 
     } 
     if (Fatigue() >= 95 && Running()) 
     { 
        System.out.println("Fatigue is " + Fatigue() + "%"); 
           while (!Sleeping() && Running()) 
           { 
           System.out.println("Sleeping..."); 
                Use(FindInv(1263)); 
                 Wait(2500); 
           } 
           while (Sleeping() && Running()) 
        { 
                 Wait(100); 
        } 
        System.out.println("Successfully Slept"); 
     } 
     while(!Sleeping() && !InCombat()) 
     { 
        int ID = GetNearestNPC(NPCID); 
        if(ID != -1) 
        { 
           SetFightMode(FightModeID); 
           AttackNPC(ID); 
           Wait(FightDelay); 
        } 
     } 
     while(InCombat()) 
        Wait(1); 
     Count += 1; 
     System.out.println("Killed " + Count + " NPCs"); 
     for(int j=0;j<Stats.length;j++) 
     { 
        if(GetStat(j) > Stat[j]) 
           System.out.println("You have gained a " + Stats[j] + " level!"); 
     } 
     if(Count % 10 == 0) 
     { 
        System.out.println(); 
        System.out.println("Stats: " + GetStat(0) + "-" + GetStat(1) + "-" + GetStat(2) + "-" + GetStat(3)); 
        System.out.println("Number of " + Food + "s : " + InvCount(FoodID)); 
        System.out.println(); 
      
     } 
  } 
  System.out.println(); 
  System.out.println("Script Stopped"); 
  System.out.println("Stats: " + GetStat(0) + "-" + GetStat(1) +  "-" + GetStat(2) + "-" + GetStat(3)); 
  System.out.println("Killed " + Count + " NPCs"); 
  if( ((FoodID != 330) && InvCount(FoodID)==0) || ((FoodID == 330) && (InvCount(330)==0 && InvCount(333)==0 && InvCount(335)==0)) ) 
     System.out.println("Out of " + Food); 
  else if(FoodID == 330) 
     System.out.println("Number of Cakes left: " + (InvCount(330) + (InvCount(333)*.33) + (InvCount(335)*0.66))); 
  else 
     System.out.println("Number of " + Food + ": " + InvCount(FoodID)); 
   } 
} 