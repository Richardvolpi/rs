//Al Kharid Iron Smelter by fAcelEss 

public class IronSmelter extends Script 
{ 
    public IronSmelter(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"smeltiron"}; 
    } 
    public void start(String command, String parameter[]) 
   //You dont need to change the line above. 
    { 
      DisplayMessage("@gre@SBoT: @whi@Iron Smelter - @or2@smelting your iron bitch!",3); 
      while (Running()) 
      { 
         while (Fatigue() < 95 && Running()  == true && InvCount(151) > 0) 
         { 
            UseOnObject(85, 679, 1); 
            Wait(2000); 
         } 
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
    DisplayMessage("@or2@Walking to Bank...",3); 
    Walk(81,679); 
         Wait(100); 
         Walk(83,686); 
         Wait(100); 
         Walk(85,695); 
         Wait(100); 
    Walk(90,695); 
    Wait(1000); 

    DisplayMessage("@or2@Depositing Bars",3); 
         while (QuestMenu() == false) 
         { 
            int BankerID = GetNearestNPC(268); 
            TalkToNPC(BankerID); 
            Wait(1000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(170) > 0) 
         { 
            Deposit(170,1); 
            Wait(100); 
         } 
         CloseBank(); 

    DisplayMessage("@or2@Withdrawing Ores",3); 
         while (QuestMenu() == false) 
         { 
            int BankerID = GetNearestNPC(268); 
            TalkToNPC(BankerID); 
            Wait(1000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(151) < 29) 
         { 
            Withdraw(151,1); 
            Wait(100); 
         } 
         CloseBank(); 
  
    DisplayMessage("@or2@Walking to Furnace...",3); 
         Walk(86,695); 
         Wait(100); 
    Walk(84,690); 
         Wait(100);    
         Walk(83,684); 
         Wait(100); 
    Walk(81,679); 
    Wait(100); 
    Walk(84,679); 
    Wait(1000); 

         } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
}