public class ClayBank extends Script 
{ 
    public ClayBank(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"mineclay"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@or2@SBoT: @whi@Clay Miner + Banker - by Veggy", 3); 
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
            int RockCoords[] = GetNearestObject(115); 
            AtObject(RockCoords[0],RockCoords[1]); 
            Wait(4000); 
         } 
         Walk(156,530); 
         Wait(500); 
         Walk(156,518); 
         Wait(500); 
         Walk(154,509); 
         Wait(500); 
         Walk(149,503); 
         Wait(500); 
         while (ObjectAt(150,507) == 64 && Running() == true) 
         { 
            System.out.println("Opened Bank door"); 
            AtObject(150,507); 
            Wait(1000); 
         } 
         if (Running() == true) 
            Walk(150,507); 
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
         System.out.println("Depositting " + InvCount(149) + " clay ores..."); 
         while (InvCount(149) > 0 && Running() == true && Bank() == true) 
         { 
            Deposit(149,1); 
            Wait(100); 
         } 
         if (Running() == true && Bank() == true) 
            CloseBank(); 
         if (Running() == true) 
            Walk(150,507); 
         while (ObjectAt(150,507) == 64 && Running() == true) 
         { 
            System.out.println("Opened Bank door"); 
            AtObject(150,507); 
            Wait(1000); 
         } 
         if (Running() == true) 
            Walk(150,507); 
         Walk(156,511); 
         Wait(500); 
         Walk(157,529); 
         Wait(500); 
         Walk(162,535); 
         Wait(500); 
      } 
      DisplayMessage("@or2@SBoT: @whi@Clay Miner + Banker - @red@STOPPED", 3); 
    } 
} 