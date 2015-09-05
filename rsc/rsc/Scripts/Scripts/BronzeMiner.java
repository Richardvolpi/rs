//Start in Rimmington Mine with Sleeping Bag and a Pick Axe. 
//This script will mine 14 tin ore and 14 copper ore. 
//It will then walk up to the furnace. It will smelt all bars possible. Then it will walk to bank and deposit all bars and gems. 
public class BronzeMiner extends Script 
{ 
    public BronzeMiner(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"minebronze"}; 
    } 
    public void start(String command, String parameter[]) 
   //You dont need to change the line above. 
    { 
      DisplayMessage("@cya@Copper/Tin Miner/Smelter started! Created by Veggy! @red@ <3",3); 
      while (Running()) 
      { 
         while (Running()  == true && InvCount() < 30) 
         { 
            if (Fatigue() >= 95 && Running() == true) 
            { 
               while (Sleeping() == false) 
               { 
                  Use(FindInv(1263)); 
               Wait(2500); 
               } 
               while (Sleeping() == true) 
               { 
                  Wait(100); 
               } 
            } 
   //Mining part 
         while(InvCount(202) > 14 && Running() == true) 
   { 
            int RockCoords[] = GetNearestObject(104); 
            AtObject(RockCoords[0],RockCoords[1]); 
            Wait(8000); 
   } 
         while(InvCount(150) > 14 && Running() == true) 
   { 
            int RockCoords[] = GetNearestObject(100); 
            AtObject(RockCoords[0],RockCoords[1]); 
            Wait(8000); 
   } 
       if (InvCount(157) > 0) 
       { 
          Drop(FindInv(157)); 
          Wait(300); 
       } 
       if (InvCount(158) > 0) 
       { 
          Drop(FindInv(158)); 
          Wait(300); 
       } 
       if (InvCount(159) > 0) 
       { 
          Drop(FindInv(159)); 
          Wait(300); 
       } 
       if (InvCount(160) > 0) 
       { 
          Drop(FindInv(160)); 
          Wait(300); 
       } 
   //Walking to Furnace 

         Walk(313,637); 
         Wait(100); 
         Walk(316,634); 
         Wait(100); 
         Walk(316,631); 
         Wait(100); 
         Walk(312,627); 
         Wait(100); 
         Walk(309,623); 
         Wait(100); 
         Walk(306,620); 
         Wait(100); 
         Walk(304,618); 
         Wait(100); 
         Walk(301,613); 
         Wait(100); 
         Walk(299,600); 
         Wait(100); 
         Walk(293,601); 
         Wait(100); 
         Walk(292,596); 
         Wait(100); 
         Walk(291,591); 
         Wait(100); 
         Walk(291,586); 
         Wait(100); 
         Walk(291,579); 
         Wait(100); 
         Walk(290,573); 
         Wait(100); 
    Walk(289,566); 
    Wait(100); 
    Walk(291,560); 
    Wait(100); 
    Walk(296,552); 
    Wait(100); 
    Walk(300,548); 
    Wait(100); 
    Walk(304,545); 
    Wait(100); 
         Walk(306,544); 
         Wait(100); 
         while (ObjectAt(306,544) == 2 && Running() == true) 
         { 
            System.out.println("Opened Smelting door"); 
            AtObject(306,544); 
            Wait(1000); 
         } 
         if (Running() == true) 
         Walk(306,544); 
    Wait(100); 
    Walk(309,545); 
    Wait(1000);    
        while (Running() == true && (InvCount(150)/InvCount(202)) == 1) 
            //Smelting Part 
      { 
            UseOnObject(306, 546, FindInv(202)); 
            Wait(2500); 
            System.out.println("Smithed 1 bronze bar!"); 
      } 
    Walk(307,544); 
    Wait(100); 
         while (ObjectAt(306,544) == 2 && Running() == true) 
         { 
            System.out.println("Opened Smelting door"); 
            AtObject(306,544); 
            Wait(1000); 
         } 
         if (Running() == true) 
         Walk(306,544); 
    Wait(100);    
    Walk(301,546); 
    Wait(100); 
    Walk(296,549); 
    Wait(100); 
    Walk(292,557); 
    Wait(100); 
    Walk(289,565); 
    Wait(100); 
    Walk(288,570); 
    Wait(100); 
         Walk(286,571); 
         Wait(100); 
         while (ObjectAt(287,571) == 64 && Running() == true) 
         { 
            System.out.println("Opened Bank door"); 
            AtObject(287,571); 
            Wait(1000); 
         } 
         if (Running() == true) 
            Walk(286,571); 
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
            System.out.println("Depositting " + InvCount(169) + " bronze bars..."); 
         while (InvCount(169) > 0 && Running() == true && Bank() == true) 
         { 
            Deposit(169,1); 
            Wait(100); 
         } 
         if (Running() == true && Bank() == true) 
            CloseBank(); 
    Wait(500); 

         Walk(286,571); 
         Wait(100); 
         Walk(290,573); 
         Wait(100); 
         Walk(291,579); 
         Wait(100); 
         Walk(291,586); 
         Wait(100); 
         Walk(291,591); 
         Wait(100); 
         Walk(292,596); 
         Wait(100); 
         Walk(293,601); 
         Wait(100); 
         Walk(299,600); 
         Wait(100); 
         Walk(301,613); 
         Wait(100); 
         Walk(304,618); 
         Wait(100); 
         Walk(306,620); 
         Wait(100); 
         Walk(309,623); 
         Wait(100); 
         Walk(312,627); 
         Wait(100); 
         Walk(316,631); 
         Wait(100); 
         Walk(316,634); 
         Wait(100); 
         Walk(310,639); 
         Wait(100); 
      } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
} 
}