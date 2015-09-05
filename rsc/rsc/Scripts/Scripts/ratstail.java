public class ratstail extends Script 
{ 
    public ratstail(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{ "ratss" }; 
    } 
   public void ServerMessage(String message) 
   { 

   } 
    public void start(String command, String parameter[]) 
    { 
    DisplayMessage("@dre@ lvl 2 rat fighter @blu@dropping bronze long",3);    
    int FightMode = Integer.parseInt(parameter[0]);    
    while(Running()) 
     { 
        if(Fatigue() > 97 && Running() == true) 
        { 
          while (Sleeping() == false) 
          { 
           Use(FindInv(1263)); 
           Wait(2000); 
          } 
          while (Sleeping() == true) 
          { 
            Wait(200); 
          } 
   } 
  
         while (DoorAt(215,613,0) == 2) 
         { 
          OpenDoor(215,613,0); 
          Wait(1000); 
         } 
         while (DoorAt(220,620,0) == 2) 
         { 
          OpenDoor(220,620,0); 
          Wait(1000); 
         }        
         while (DoorAt(215,618,0) == 2) 
         { 
          OpenDoor(215,618,0); 
          Wait(1000); 
         } 
         SetFightMode(FightMode); 
         int RatID = GetNearestNPC(29); 
         AttackNPC(RatID); 
         Wait(1000); 
} 
} 
}