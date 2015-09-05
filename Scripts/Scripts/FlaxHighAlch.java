//Casts High level Alchemy on Steel Plates 
//in inventory. Made by fAcelEss 
//Run in a bank. 

public class FlaxHighAlch extends Script 
{ 
    public FlaxHighAlch(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"alchflax"}; 
    } 
    public void start(String command, String parameter[])  
    { 
      DisplayMessage("@gre@SBoT: @whi@Steel Plate High-Alcher - @or2@fAcelEss",3); 
      while (Running()) 
      { 
    if (Fatigue() >= 95 && Running() == true) 
         { 
            while (Sleeping() == false) 
            { 
          DisplayMessage("@or2@Time for a sleep... ZZZzzz",3); 
               Use(FindInv(1263)); 
               Wait(2500); 
            } 
            while (Sleeping() == true) 
            { 
               Wait(100); 
            } 
         } 
         while (Fatigue() < 95 && Running()  == true && InvCount(675) > 1 && InvCount(40) > 1) 
         { 
       DisplayMessage("@or2@Let's get alching!",3); 

      { 
               MagicInventory((FindInv(675)), 28); 
      Wait(2000); 
      } 
         } 
    DisplayMessage("@or2@Banking...",3); 
         while (QuestMenu() == false) 
         { 
       int Bankers[] = new int[] {95, 268}; 
       int BankerIDs = GetNearestNPC(Bankers); 
            TalkToNPC(BankerIDs); 
            Wait(1000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(675) < 26) 
         { 
            Withdraw(675,1); 
            Wait(100); 
         } 
         CloseBank(); 
         } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
} 