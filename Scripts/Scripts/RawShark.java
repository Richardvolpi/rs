public class RawShark extends Script 
{ 
    public RawShark(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"raw"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@red@ Uncerting Raw Shark", 3); 
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
          Wait(3000); 
            Answer(1); 
           Wait(3000); 
            Answer(4); 
           Wait(3000); 
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
            Deposit(545,25); 
         Wait(200); 
         CloseBank();    
      } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
}