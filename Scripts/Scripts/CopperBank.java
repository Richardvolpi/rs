public class CopperBank extends Script 
{ 
    public CopperBank(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"minecopper"};    
   } 
   public void start(String command, String parameter[]) 
    { 
    
      DisplayMessage("@ran@SmokY: @whi@Started",3); 
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("SmokY"); 
      System.out.println("m"); 
      System.out.println("o"); 
      System.out.println("k"); 
      System.out.println("Y"); 
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("-----Copper Miner has been started-----"); 
      System.out.println("Current mining level is: " + GetStat(14)); 
      System.out.println("==============================="); 
      
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
           int RockCoords[] = GetNearestObject(100); 
            AtObject(RockCoords[0],RockCoords[1]); 
            Wait(2000); 
         } 
         Walk(73,543); 
         Wait(200); 
         Walk(73,537); 
         Wait(200); 
         Walk(75,529); 
         Wait(200); 
         Walk(79,519); 
         Wait(200); 
         Walk(85,509); 
         Wait(200); 
         Walk(95,509); 
         Wait(200); 
         Walk(102,512); 
         Wait(200); 
         while (QuestMenu() == false) 
         { 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            Wait(1000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(202) > 0) 
         { 
            Deposit(150,1); 
            Wait(100); 
         } 
         while (InvCount(157) > 0) 
         { 
            Deposit(157,1); 
            Wait(100); 
         } 
         while (InvCount(158) > 0) 
         { 
            Deposit(158,1); 
            Wait(100); 
         } 
         while (InvCount(159) > 0) 
         { 
            Deposit(159,1); 
            Wait(100); 
         } 
         while (InvCount(160) > 0) 
         { 
            Deposit(160,1); 
            Wait(100); 
         } 
         CloseBank(); 
         Walk(94,509); 
         Wait(200); 
         Walk(84,511); 
         Wait(200); 
         Walk(79,518); 
         Wait(200); 
         Walk(75,527); 
         Wait(200); 
         Walk(73,548); 
         Wait(200); 
      } 
      DisplayMessage("@or2@SBoT: @whi@Copper Miner + Banker by @ran@SmokY- @red@STOPPED", 3); 
    } 
}