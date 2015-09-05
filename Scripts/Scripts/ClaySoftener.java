//This script has been requested by 0wn4g3. 
//Start in Varrock West Bank. 
public class ClaySoftener extends Script 
{ 
    public ClaySoftener(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"claysoft"}; 
    } 
    public void start(String command, String parameter[]) 

    { 
        DisplayMessage("@gre@SBoT: @whi@Clay Softener Varrock - @ran@Vegunks",3); 
        while (Running() == true) 
        { 
        
        //Banking 

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
            while(InvCount(243) > 0) 
            { 
                Deposit(243,1); 
                Wait(100); 
            } 

            while(InvCount(149) < 28) 
            { 
                Withdraw(149,1); 
                Wait(100); 
            }  
            CloseBank(); 
        
        } 
  


        //Walking To Sink 


        Walk(148,508); 
   Wait(100); 
        Walk(141,508); 
   Wait(100); 
        Walk(136,507); 
   Wait(100); 
        Walk(132,504); 
   Wait(100); 
        Walk(131,498); 
   Wait(100); 
        Walk(130,491); 
   Wait(100); 
        Walk(131,485); 
   Wait(100); 
        Walk(131,480); 
   Wait(100); 
        Walk(131,475); 
   Wait(100); 
        Walk(129,471); 
   Wait(100); 
        Walk(124,469); 
   Wait(100); 
        Walk(124,466); 
   Wait(100); 
        Walk(120,466); 
   Wait(100); 
        Walk(119,462); 
        Wait(1000); 

        //Softening 
   while (Running() == true && InvCount(149) > 0) 
        { 
            //Softening Part 
            UseOnObject(118, 461, FindInv(21)); 
            Wait(2500); 
       UseWithInventory(FindInv(149),FindInv(50)); 
       Wait(2500); 

            //Check for Sleep 
            if(Fatigue() > 97 && Running() == true) 
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
        //Walk to Bank 

        Walk(120,466); 
   Wait(100); 
        Walk(124,466); 
   Wait(100); 
        Walk(124,469); 
   Wait(100); 
        Walk(129,471); 
   Wait(100); 
        Walk(131,475); 
   Wait(100); 
        Walk(131,480); 
   Wait(100); 
        Walk(131,485); 
   Wait(100); 
        Walk(130,491); 
   Wait(100); 
        Walk(131,498); 
   Wait(100); 
        Walk(132,504); 
   Wait(100); 
        Walk(136,507); 
   Wait(100); 
        Walk(141,508); 
   Wait(100); 
        Walk(148,508); 
   Wait(1000); 
        } 
        DisplayMessage("@red@STOPPED", 3); 
    } 
} 
