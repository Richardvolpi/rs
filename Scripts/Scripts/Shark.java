public class Shark extends Script 
{ 
    public Shark(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"cookedshark"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@red@Uncerting Shark", 3); 
      while (Running()) 
      {              
                Walk(426,485); 
          
         while (QuestMenu() == false) 
         { 
            long T = System.currentTimeMillis(); 
            int CerterID = GetNearestNPC(1217); 
            TalkToNPC(1217); 
            while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false) 
               Wait(1); 
         } 
            Answer(0); 
          Wait(1000); 
            Answer(0); 
           Wait(1000); 
            Answer(4); 
           Wait(1000); 
            Walk(439,496); 
         while (QuestMenu() == false) 
         { 
            long T = System.currentTimeMillis(); 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            while (System.currentTimeMillis() - T <= 6000 && QuestMenu() == false) 
               Wait(1); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
            Deposit(546,25); 
         Wait(100); 
         CloseBank();    
      } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
} 
