//Start in varrock west in bank 

public class BronzePlate extends Script 
{ 
    public BronzePlate(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{ "bronzeplate" }; 
    } 
   public void ServerMessage(String message) 
   { 
    
   } 

    public void start(String command, String parameter[]) 
  
   { 
        DisplayMessage("@red@S@or3@M@or2@I@ora@T@or1@H@yel@Y", 3); 
        DisplayMessage("By...[@Ran@N@Ran@s@Ran@o@Ran@m@Ran@n@Ran@i@Ran@A]", 3); 
          
    while (Running()) 

    { 
    Walk(150,503); 
    Wait(100); 

    while (QuestMenu() == false && Running() == true) 
        { 
            int BankerID = GetNearestNPC(95); 
            TalkToNPC(BankerID); 
            Wait(2000); 
        } 

        Answer(0); 

        while (Bank() == false && Running() == true) 
        { 
            Wait(50); 
        } 


        while (Bank() == true && Running() == true) 
        { 

       while(InvCount(117) > 0) 
            { 
                Deposit(117,1); 
                Wait(100); 
            } 
            while(InvCount(169) < 25) 
            { 
                Withdraw(169,1); 
                Wait(100); 
            }  

            CloseBank(); 
        } 
       Walk(150,503); 
            Wait(100); 
            Walk(150,507); 
             Wait(100); 
              Walk(148,512); 
       Wait(100); 
         while (Running() == true && InvCount(169) > 5 && Fatigue() < 100) 
         { 
         UseOnObject(148,513,FindInv(169)); 
        Wait(500); 
         for(; !QuestMenu(); Wait(10)); 
         Answer(1); 
         for(; !QuestMenu(); Wait(10)); 
         Answer(2); 
    for(; !QuestMenu(); Wait(10)); 
         Answer(1);  
         Wait(1000); 
         } 
          
     if(Fatigue() > 99 && Running() == true) 
            { 
                while (Sleeping() == false) 
                { 
                    Use(FindInv(1263)); 
                    Wait(3000); 
                } 

                while (Sleeping() == true) 
                { 
                    Wait(200); 
  
          
               } 
           }    
      } 

DisplayMessage("@Ran@N@Ran@s@Ran@o@Ran@m@Ran@n@Ran@i@Ran@A[omgranhaxkthnxbye]- @red@Stopped", 3); 
} 
}