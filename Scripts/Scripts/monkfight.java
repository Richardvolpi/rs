public class monkfight extends Script 
{ 
    public monkfight(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{ "monkfight" }; 
    } 
   public void ServerMessage(String message) 
   { 

   } 
    public void start(String command, String parameter[]) 
    { 
    DisplayMessage("@ran@ Monk fighter by @cya@ 0wn4g3",3); 
    int FightMode = Integer.parseInt(parameter[0]); 
    while(Running()) 
     { 
        if(Fatigue() > 96 && Running() == true) 
        { 
          while (Sleeping() == false) 
          { 
           Use(FindInv(1263)); 
           Wait(3000); 
          } 
          while (Sleeping() == true) 
          { 
            Wait(200); 
          } 
   } 
   if (InCombat() == false && Sleeping() == false && GetStat(3) - GetCurrentStat(3) > 10) 
         {        

                  long T = System.currentTimeMillis(); 
                  int HealID = GetNearestNPC(93); 
                  TalkToNPC(HealID); 
                  while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false) 
                        Wait(1); 
         } 
         Answer(0); 
    Wait(2000); 
         while (DoorAt(251,1408,0) == 2) 
         { 
          OpenDoor(251,1408,0); 
          Wait(1000); 
         } 
         while (DoorAt(251,1405,0) == 2) 
         { 
          OpenDoor(251,1405,0); 
          Wait(1000); 
         }                
         while (DoorAt(253,1403,1) == 2) 
         { 
          OpenDoor(253,1403,1); 
          Wait(1000); 
         } 
         while (DoorAt(259,1403,1) == 2) 
         { 
          OpenDoor(259,1403,1); 
          Wait(1000); 
         } 
       while (DoorAt(260,1406,0) == 2) 
         { 
           OpenDoor(260,1406,0); 
           Wait(1000); 
         } 
         SetFightMode(FightMode); 
         int MonkID = GetNearestNPC(93); 
         AttackNPC(MonkID); 
         Wait(200);                  
}            
} 
}