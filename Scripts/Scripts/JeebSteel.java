public class JeebSteel extends Script 

{ 
   public JeebSteel(mudclient rs) 
   { 
      super(rs); 
   } 
   public String[] getCommands() 
   { 
      return new String[]{"smelt"}; 
   } 
   public long StartS = (long)((int)(System.currentTimeMillis() / 1000)); 
   public int SteelBars = 0; 
   public int Trips = 0; 
   public int LVL = 0; 
   public void ServerMessage(String message) 
   { 
       if(message.equals("@gam@You retrieve a bar of steel")) 
       { 
           SteelBars++; 
       } 
       if(message.equals("@gre@You just advanced 1 smithing level!")) 
       { 
           LVL++; 
       } 
        
} 
       public void start(String command, String parameter[]) 

    { 
        DisplayMessage("@ran@S@ran@teel @ran@S@ran@melter @ran@B@ran@y @ran@J@ran@eeb",3); 
        while (Running() == true) 
        { 
        
         OpenBank(); 
      
        
    while (Bank() == true && Running() == true) 
        { 
            while(InvCount(171) > 0) 
            { 
                Deposit(171,1); 
                Wait(100); 
            } 

            while(InvCount(151) < 9) 
            { 
                Withdraw(151,1); 
                Wait(1000); 
            } 
    
            while(InvCount(151) > 9) 
            { 
                Deposit(151,1);    
                Wait(1000); 
            } 

            while(InvCount(155) < 18) 
            { 
                Withdraw(155,1); 
                Wait(1000); 
            } 
            CloseBank(); 
            
        while(ObjectAt(327,552) == 64) 
          { 
             AtObject2(327,552); 
              Wait(1000); 
          } 
        } 
        
        Walk(327,553); 
        Walk(324,553); 
        Walk(321,552); 
        Walk(318,552); 
        Walk(314,549); 
        Walk(313,545); 
        Walk(311,545); 
        Wait(1000); 
        
         while(DoorAt(309, 543, 0) == 2) 
          {          
              OpenDoor(309, 543, 0); 
              Wait(1000); 
          } 
        
        while (Running() == true && InvCount(171) < 9) 
        { 
            
            UseOnObject(310, 546, FindInv(155)); 
            Wait(2400); 

            if(Fatigue() > 97 && Running() == true) 
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
        } 
        

        Walk(315,550); 
        Walk(321,551); 
        Walk(327,552); 
        Walk(329,553); 
        Wait(1000); 
        Trips++; 
        
        while(ObjectAt(327,552) == 64) 
          { 
             AtObject(327,552); 
              Wait(1000); 
          } 
          float Minutes = (float)((((float)System.currentTimeMillis() / 1000) - (float)StartS) / 60); 
          Println("====================Progress Report===================="); 
          Println("Levels Gained: " +LVL); 
          Println("Exp Gained: " +SteelBars*17.5); 
          Println("Number of Trips: " +Trips); 
          Println("Minutes Running: " +Minutes); 
          Println("Steel Bars Made: " +SteelBars); 
          Println("====================End of Progress Report============="); 

        } 
        DisplayMessage("@red@STOPPED", 3); 
    } 
} 