public class BarbFish extends Script 
{ 
    public int Fishinglevels = 0, trout = 0, salmon = 0, exp = 0, cookexp = 0, cook = 0, Cookinglevels;    
   public BarbFish(mudclient rs) 
    { 
        super(rs);      
    } 
    public String[] getCommands() 
    { 
        return new String[]{"powerfish", "cookbank", "bankfish", "cookfish"};      
    } 
   public void ServerMessage(String message) 
   { 
      if (message.equals("@gam@You catch a trout")) 
      { 
         System.out.println("Obtained Trout. Trout Count: " + (trout + 1)); 
         trout++; 
    exp+=50; 
      } else 
      if (message.equals("@gre@You just advanced 1 fishing level!")) 
      { 
         Wait(1000); 
         System.out.println("Fishing Level! Current Fishing Level: " + GetStat(10)); 
         Fishinglevels++; 
      } else 
      if (message.equals("@gam@You catch a salmon")) 
      { 
         System.out.println("Obtained Salmon. Salmon Count: " + (salmon + 1)); 
         salmon++; 
    exp+=70; 
      } else 
      if (message.equals("@gam@The salmon is now nicely cooked")) 
      { 
         System.out.println("Cooked a Salmon. Cook Count: " + (cook + 1)); 
    cookexp+=90; 
    cook++; 
      } else 
      if (message.equals("@gam@The trout is now nicely cooked")) 
      { 
         System.out.println("Cooked a Trout. Cook Count: " + (cook + 1)); 
    cookexp+=70; 
    cook++; 
      } else 
      if (message.equals("@gre@You just advanced 1 cooking level!")) 
      { 
         Wait(1000); 
         System.out.println("Cooking Level! Current Cooking Level: " + GetStat(7)); 
         Cookinglevels++; 
   } 
     } 
    public void start(String command, String parameter[]) 
    { 
    
      DisplayMessage("@gre@Barb Fisher By @ran@S@ran@a@ran@g@ran@s",3); 
      System.out.println("     BarbFisher by Sags Started     "); 
      System.out.println("-------------------------------------"); 
      System.out.println("Current Fishing Level: " + GetStat(10)); 
      System.out.println("Current Cooking Level: " + GetStat(7)); 
    
        if (command.equalsIgnoreCase("powerfish")) 
             while (Running()) 
   { 
           while (Fatigue() >= 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. sleep time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
    
    if (Sleeping() == false) 
            { 
          AtObject(208,501); 
     Wait(100); 
            } 
        } 
      
           if (command.equalsIgnoreCase("cookfish")) 
            while (Running())        
       { 
         while (InvCount() < 30 && Running() == true) 
         { 
            while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
            while (Sleeping() == true && Running() == true) 
               Wait(1); 
          AtObject(208,501); 
     Wait(100); 
               } 
   Wait(100);    
   Walk(213,502); 
   Wait(200); 
   Walk(221,502); 
   Wait(200); 
   Walk(225,503); 
   Wait(200); 
   Walk(232,504); 
   Wait(200); 
         while (ObjectAt(232,503) == 64 && Running() == true) 
         { 
            System.out.println("Opened door."); 
            AtObject(232,503); 
            Wait(2000); 
         } 
   Walk(235,496); 
   Wait(200); 
   while (InvCount() == 30) 
   { 

   while (InvCount(358) > 0 && Running() == true && Sleeping() == false) 
           { 
            UseOnObject(234,495,FindInv(358)); 
            Wait(2600); 
            while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
                } 
       
        while (InvCount(356) > 0 && Running() == true && Sleeping() == false) 
           { 
            UseOnObject(234,495,FindInv(356)); 
            Wait(2600); 
            while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
      } 
     

   while (InvCount(360) > 0 && Running() == true && Sleeping() == false) 
   { 
   Drop(FindInv(360)); 
   Wait(100); 
   } 
        while (InvCount(357) > 0 && Running() == true && Sleeping() == false) 
      { 
   Use(FindInv(357)); 
   Wait(100); 
           } 
        while (InvCount(359) > 0 && Running() == true && Sleeping() == false) 
    { 
   Use(FindInv(359)); 
   Wait(100); 
          } 
        
   } 
   Walk(232,502); 
   Wait(100); 
         while (ObjectAt(232,503) == 64 && Running() == true) 
         { 
            System.out.println("Opened door."); 
            AtObject(232,503); 
            Wait(2000); 
         } 
   Walk(226,503); 
   Wait(100); 
   Walk(214,501); 
   Wait(100); 
   Walk(212,501); 
   Wait(100); 
     } 
       
       
      if (command.equalsIgnoreCase("bankfish")) 
         while (Running()) 
           { 
         while (InvCount() < 30 && Running() == true) 
         { 
            while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
            while (Sleeping() == true && Running() == true) 
               Wait(1); 
          AtObject(208,501); 
     Wait(100); 
               } 
               Walk(211,501); 
   Walk(211,501); 
   Wait(100); 
   Walk(213,497); 
   Wait(100); 
   Walk(215,493); 
   Wait(100); 
   Walk(217,488); 
   Wait(100); 
   Walk(218,483); 
   Wait(100); 
   Walk(220,478); 
   Wait(100); 
   Walk(221,470); 
   Wait(100); 
   Walk(224,466); 
   Wait(100); 
   Walk(224,458); 
   Wait(100); 
   Walk(222,449); 
   Wait(100); 
   Walk(217,447); 
   Wait(100); 
            while (ObjectAt(217,447) != 63 && Running() == true) 
         { 
            System.out.println("Opened Bank door."); 
            AtObject(217,447); 
            Wait(1000); 
         } 
                  while (Bank() == false && Running() == true) 
         { 
            while (QuestMenu() == false && Running() == true) 
            { 
               int BankerID = GetNearestNPC(95); 
               TalkToNPC(BankerID); 
               long Time = System.currentTimeMillis(); 
               while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true) 
                  Wait(1); 
            } 
            Answer(0); 
            long Time = System.currentTimeMillis(); 
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true) 
               Wait(1); 
         } 
         if (Running() == true) 
         while (InvCount(356) > 0 && Running() == true && Bank() == true) 
         { 
            System.out.println("Depositting " + InvCount(356) + " trout"); 
            Deposit(356,1); 
            Wait(100); 
         } 
         if (Running() == true) 
         while (InvCount(358) > 0 && Running() == true && Bank() == true) 
         { 
            System.out.println("Depositting " + InvCount(358) + " salmon"); 
            Deposit(358,1); 
            Wait(100); 
         } 
         Walk(217,448); 
         Wait(100); 
         while (ObjectAt(217,447) != 63 && Running() == true) 
         { 
            System.out.println("Opened Bank door."); 
            AtObject(217,447); 
            Wait(1000); 
         } 
   Walk(220,446); 
   Wait(100); 
   Walk(222,455); 
   Wait(100); 
   Walk(224,463); 
   Wait(100); 
   Walk(223,471); 
   Wait(100); 
   Walk(221,480); 
   Wait(100); 
   Walk(217,492); 
   Wait(100); 
   Walk(211,500); 
   Wait(100); 
   } 
    
         if (command.equalsIgnoreCase("cookbank")) 
         while (Running()) 
           { 
         while (InvCount() < 30 && Running() == true) 
         { 
            while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
            while (Sleeping() == true && Running() == true) 
               Wait(1); 
          AtObject(208,501); 
     Wait(100); 
               } 
               Walk(211,501); 
   Walk(211,501); 
   Wait(100); 
   Walk(213,497); 
   Wait(100); 
   Walk(215,493); 
   Wait(100); 
   Walk(217,488); 
   Wait(100); 
   Walk(218,483); 
   Wait(100); 
   Walk(220,478); 
   Wait(100); 
   Walk(221,470); 
   Wait(100); 
   Walk(224,466); 
   Wait(100); 
   Walk(224,458); 
   Wait(100); 
   Walk(222,449); 
   Wait(100); 
   Walk(225,445); 
   Wait(100); 
         while (DoorAt(225,444,0) == 2 && Running() == true) 
         { 
            System.out.println("Opened door."); 
            OpenDoor(225,444,0); 
            Wait(2000); 
         } 
        Walk(225,441); 
        Wait(100); 
                while(GetY() < 1000 && Running() == true) 
        { 
            AtObject(226,439); 
            Wait(1000); 
        } 

        Wait(2000); 
                while (InvCount(356) > 0 && Running() == true && Sleeping() == false) 
        { 
            UseOnObject(222,1385,FindInv(356)); 
            Wait(2600); 
                        while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
        } 
                        while (InvCount(358) > 0 && Running() == true && Sleeping() == false) 
        { 
            UseOnObject(222,1385,FindInv(358)); 
            Wait(2600); 
                        while (Fatigue() > 90 && Running() == true && Sleeping() == false) 
            { 
               System.out.println("Fatigue is at " + Fatigue() + "%. Sleep Time"); 
               Use(FindInv(1263)); 
               Wait(3000); 
            } 
        } 
   while (InvCount(360) > 0 && Running() == true && Sleeping() == false) 
        { 
        Drop(FindInv(360)); 
        Wait(100); 
        } 
                while(GetY() > 1000 && Running() == true) 
        { 
            AtObject(226,1383); 
            Wait(1000); 
        } 
                 while (DoorAt(225,444,0) == 2 && Running() == true) 
         { 
            System.out.println("Opened door."); 
            OpenDoor(225,444,0); 
            Wait(2000); 
         } 
        Walk(225,445); 
        Wait(100); 
        Walk(217,446); 
        Wait(100); 
                 while (ObjectAt(217,447) != 63 && Running() == true) 
         { 
            System.out.println("Opened Bank door."); 
            AtObject(217,447); 
            Wait(1000); 
         } 
                           while (Bank() == false && Running() == true) 
         { 
            while (QuestMenu() == false && Running() == true) 
            { 
               int BankerID = GetNearestNPC(95); 
               TalkToNPC(BankerID); 
               long Time = System.currentTimeMillis(); 
               while (System.currentTimeMillis() - Time <= 2000 && QuestMenu() == false && Running() == true) 
                  Wait(1); 
            } 
            Answer(0); 
            long Time = System.currentTimeMillis(); 
            while (System.currentTimeMillis() - Time <= 5000 && Bank() == false && Running() == true) 
               Wait(1); 
         } 
         if (Running() == true) 
         while (InvCount(357) > 0 && Running() == true && Bank() == true) 
         { 
            System.out.println("Depositting " + InvCount(357) + " trout"); 
            Deposit(357,1); 
            Wait(100); 
         } 
         if (Running() == true) 
         while (InvCount(359) > 0 && Running() == true && Bank() == true) 
         { 
            System.out.println("Depositting " + InvCount(359) + " salmon"); 
            Deposit(359,1); 
            Wait(100); 
         } 
                  Walk(217,448); 
         Wait(100); 
         while (ObjectAt(217,447) != 63 && Running() == true) 
         { 
            System.out.println("Opened Bank door."); 
            AtObject(217,447); 
            Wait(1000); 
         } 
   Walk(220,446); 
   Wait(100); 
   Walk(222,455); 
   Wait(100); 
   Walk(224,463); 
   Wait(100); 
   Walk(223,471); 
   Wait(100); 
   Walk(221,480); 
   Wait(100); 
   Walk(217,492); 
   Wait(100); 
   Walk(211,500); 
   Wait(100); 
   } 
          
        
  
      DisplayMessage("@Whi@PowerFisher @red@Stopped", 3); 
      System.out.println("     BarbFisher by Sags Stopped     "); 
      System.out.println("-------------------------------------"); 
      System.out.println("Fishing Levels Grown: " + Fishinglevels); 
      System.out.println("Trout Obtained:  " + trout); 
      System.out.println("Salmon Obtained:  " + salmon); 
      System.out.println("Fishing Experience Gained:  " + exp); 
      System.out.println("Cooking Levels Grown: " + Cookinglevels); 
      System.out.println("Fish Cooked:  " + cook); 
      System.out.println("Cooking Experience Gained:  " + cookexp); 
      
    } 
  }