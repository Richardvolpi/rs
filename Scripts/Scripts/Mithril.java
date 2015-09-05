public class Mithril extends Script 
{ 
    public Mithril(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"mithril"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@yel@Jake: @cya@Mining Mithril",3); 

      while (Running()) 
      { 
         while (Running()  == true && InvCount() < 30) 
         { 
            if (Fatigue() >= 92 && Running() == true) 
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
            int RockCoords[] = GetNearestObject(106); 
            if (RockCoords[0] < 111 && Running() == true) 
               AtObject(RockCoords[0],RockCoords[1]); 
            Wait(1000); 
         } 
         Walk(121,698); 
         Walk(127,693); 
         Walk(142,684); 
         Walk(163,671); 
         Walk(189,672); 
         Walk(194,668); 
         Walk(209,652); 
         Walk(214,641); 
         Walk(217,637);  
         while (QuestMenu() == false) 
         { 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            Wait(1000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(153) > 0) 
         { 
            Deposit(153,1); 
            Wait(50); 
         } 
         while (InvCount(157) > 0) 
         { 
            Deposit(157,1); 
            Wait(50); 
         } 
         while (InvCount(158) > 0) 
         { 
            Deposit(158,1); 
            Wait(50); 
         } 
         while (InvCount(159) > 0) 
         { 
            Deposit(159,1); 
            Wait(50); 
         } 
         while (InvCount(160) > 0) 
         { 
            Deposit(160,1); 
            Wait(50); 
         } 
          CloseBank(); 
         Walk(214,641); 
         Walk(209,652); 
         Walk(194,668); 
         Walk(189,672); 
         Walk(163,671); 
         Walk(142,684); 
         Walk(127,693); 
         Walk(121,698); 
      } 
      DisplayMessage("@yel@Jake: @red@Quiter....", 3); 
    } 
}