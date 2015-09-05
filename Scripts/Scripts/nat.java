public class nat extends Script 

{ 
    public nat(mudclient rs) 
    { 
        super(rs); 
        
    } 
    public String[] getCommands() 
    { 
        return new String[]{"nat"}; 
        
    } 
    public void start(String command, String parameter[]) 

    { 
         DisplayMessage("@whi@SBoT: @mag@nature thiever by shaodwhunter", 3); 
   for(; Running(); 
   ) 
{ 

{ 
   AtObject2(582,1527); 
   Wait(25); 
if (Fatigue() > 98) 
{ 
while (Sleeping() == false) 
{ 
Use(FindInv(1263)); 
Wait(2000); 
} 
while (Sleeping() == true && Running() == true) 
{ 
Wait(100); 
} 
} 

} 

} 

   } 
  } 