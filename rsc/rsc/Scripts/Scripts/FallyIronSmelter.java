public class FallyIronSmelter extends Script 
{ 
    public FallyIronSmelter(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"fallyiron"}; 
    } 
    public void start(String command, String parameter[]) 

    { 
        DisplayMessage("@gre@SBoT: @whi@Iron Smelter Falador - @ran@Vegunks",3); 
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
            while(InvCount(170) > 0) 
            { 
                Deposit(170,1); 
                Wait(1000); 
            } 
            while(InvCount(151) < 29) 
            { 
                Withdraw(151,1); 
                Wait(1000); 
            }  
            CloseBank(); 
        
        } 
  


        //Walking To Furnace 


        Walk(326,549); 
        Wait(50); 
        Walk(324,545); 
        Wait(50); 
        Walk(323,541); 
        Wait(50); 
        Walk(317,542); 
        Wait(50); 
        Walk(312,544); 
        Wait(50); 
        Walk(310,545); 
        Wait(1000); 

        //Smelting 
   while (Running() == true && InvCount(151) > 0) 
        { 
            //Smelting Part 
            UseOnObject(310, 546, FindInv(151)); 
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

        Walk(314,542); 
        Wait(50); 
        Walk(322,540); 
        Wait(50); 
        Walk(324,547); 
        Wait(50); 
        Walk(327,552); 
        Wait(50); 
        Walk(330,552);  
        Wait(1000); 


        } 
        DisplayMessage("@red@STOPPED", 3); 
    } 
} 
