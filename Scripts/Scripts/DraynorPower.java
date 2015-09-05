//Have only sleeping bag and net in inventory. 
//Start near the fishing spots, drops fish 
public class DraynorPower extends Script 

{ 
    public DraynorPower(mudclient rs) 
    { 
        super(rs); 
        
    } 
    public String[] getCommands() 
    { 
        return new String[]{"powershrimp"}; 
        
    } 
    public void start(String command, String parameter[]) 

    { 
        DisplayMessage("@gre@SBoT: @cya@Draynor Power Shrimp and Anchovie Fisher - @gre@By Vegunks @red@Much <3", 3); 
   for(; Running(); 
   Walk(223, 659)) 
{ 

{ 
   Walk(223, 659); 
   AtObject(224, 659); 
   Wait(1000); 
if (Fatigue() > 95) 
{ 
while (Sleeping() == false) 
{ 
Use(FindInv(1263)); 
Wait(5000); 
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