//Flax Spinner by ElusioN 
//Start at Falador East bank with 1 sleeping bag and nothing in inventory! 
//Enjoy (*-*) 

public class FlaxSpinner extends Script 
{ 
    public FlaxSpinner(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"spinflax"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
    DisplayMessage("@whi@*ElusioN* @gr2@: ..:: Flax Spinner At City of Falador @whi@*ElusioN*", 3); 
    while (Running() == true) 
    {            
    Walk(286,571); 
    Wait(200); 

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
            while(InvCount(676) > 0) 
                { 
                Deposit(676,1); 
                Wait(100); 
                } 

            while(InvCount(675) < 29) 
                { 
                Withdraw(675,1); 
                Wait(100); 
                } 
              
            CloseBank(); 
       { 
            if (Fatigue() >= 90 && Running() == true ) 
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
            Walk(286,571); 
            Wait(200); 
            Walk(292,576); 
            Wait(200); 
            Walk(297,577); 
            Wait(200); 
            } 
            
            while (Running() == true && Sleeping() == false && InvCount(676) < 29) 
            { 
            int spinningwheelCoords[] = GetNearestObject(121); 
            UseOnObject(295, 579, 1); 
            Wait(300); 
        }        
            Walk(297,577); 
            Wait(200); 
            Walk(292,576); 
            Wait(200); 
            Walk(286,571); 
            Wait(200); 
              } 
             } 
           } 
            
DisplayMessage("@red@Stopped", 3); 
} 
} 