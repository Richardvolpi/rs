//Edgeville Lobster Cooker by fAcelEss 

public class LobsterCooker extends Script 
{ 
    public LobsterCooker(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"cooklobster"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
      DisplayMessage("@gre@SBoT: @whi@Edgeville Lobster Cooker - @or2@fAcelEss",3); 
      while (Running()) 
      { 
         while (Fatigue() < 99 && Running() == true && InvCount(372) > 0) 
         { 
       DisplayMessage("@or2@Cooking Lobsters...",3); 
            UseOnObject(222,1385,FindInv(372)); 
            Wait(2600); 

                if (Fatigue() >= 97 && Running() == true) 
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
         } 
    Wait(1000); 
    while (InvCount(374) >= 1) 
      { 
        Wait(500); 
           DisplayMessage("@or2@Dropping burned Lobsters...",3); 
          Drop(FindInv(374)); 
         Wait(1000); 
      } 

    DisplayMessage("@or2@Walking to Bank...",3); 
    while(GetY() > 1000 && Running() == true) 
         { 
             AtObject(226,1383); 
             Wait(1000); 
         } 
    if(DoorAt(225,444,0) == 2) 
         { 
             OpenDoor(225,444,0); 
             Wait(100); 
         } 
         Walk(224,444); 
         Wait(50); 
         Walk(220,447); 
         Wait(50); 
         if(ObjectAt(217,447) == 64) 
         { 
             AtObject(217,447); 
         } 
         Walk(217,450); 

    DisplayMessage("@or2@Banking...",3); 
         while (QuestMenu() == false) 
         { 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            Wait(4000); 
         } 
         Answer(0); 
         while (Bank() == false) 
            Wait(1); 
         while (InvCount(373) > 0) 
         { 
            Deposit(373,1); 
            Wait(100); 
         } 
    while (InvCount() < 30) 
    { 
       Withdraw(372,1); 
       Wait(100); 
    } 
         CloseBank(); 
  
    if (Fatigue() >= 96 && Running() == true) 
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

    DisplayMessage("@or2@Walking to Range...",3); 
    if(ObjectAt(217,447) == 64) 
         { 
             AtObject(217,447); 
         } 
         Wait(1000); 
         Walk(220,445); 
         Wait(50); 
         Walk(225,444); 
         Wait(50); 
    if(DoorAt(225,444,0) == 2) 
         { 
             OpenDoor(225,444,0); 
             Wait(100); 
         } 
         Walk(225,441); 
         while(GetY() < 1000 && Running() == true) 
         { 
             AtObject(226,439); 
             Wait(1000); 
         } 
         Wait(2000); 

         } 
      DisplayMessage("@red@STOPPED", 3); 
    } 
}