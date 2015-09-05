public class Nature extends Script 
{ 
    public Nature(mudclient mudclient) 
    { 
        super(mudclient); 
    } 

    public String[] getCommands() 
    { 
        return new String[] {"nature"}; 
    } 
   public void start(String command, String parameter[]) 
   { 
   if (Fatigue() > 97 && Sleeping() == false) 
             { 
                DisplayMessage("@gre@INFO: @whi@Time to sleep!", 3); 

               int SleepingBagLocation = FindInv(1263); 

               if(SleepingBagLocation == -1) 
               { 
                  Println("There is no sleepingbag with you!"); 
                  Println("Stopping auto!"); 
               } 
               else 
               { 
                     Use(SleepingBagLocation); 
                     Wait(1000); 
                    } 
             } 

          while(Sleeping() == true) 
          { 
                Wait(10); 
          } 
  
    { 
        DisplayMessage("@cya@Kennii's Thieving Natures Now", 3); 
        for(; Running(); Wait(100)) 
            AtObject2(539,1547); 

        DisplayMessage("@gre@STOPPED", 3); 
    } 
} 
}