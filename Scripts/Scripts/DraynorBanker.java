//Have only sleeping bag and net in inventory. 
//Start near the fishing spots, banks anchovie and shrimp 
public class DraynorBanker extends Script 

{ 
    public DraynorBanker(mudclient rs) 
    { 
        super(rs); 
        
    } 
    public String[] getCommands() 
    { 
        return new String[]{"bankshrimp"}; 
        
    } 
    public void start(String command, String parameter[]) 

    { 
        DisplayMessage("@gre@SBoT: @cya@Draynor Shrimp & Anchovie banker- By CrAZyJ <3", 3); 
   for(; Running(); 
   Walk(223, 659)) 
{ 
   while (InvCount() < 30 && Running() == true) 

{ 
   Walk(223, 659); 
   AtObject(224, 659); 
   Wait(3400); 
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
{ 
   Walk(215, 649); 
   Walk(214, 640); 
   Walk(220, 637); 
} 

{ 
            while(!QuestMenu()) 
            { 
                long l = System.currentTimeMillis(); 
                int x = GetNearestNPC(95); 
                TalkToNPC(x); 
                while(System.currentTimeMillis() - l <= 6000L && !QuestMenu()) 
                    Wait(100); 
            } 
            Answer(0); 
            for(; !Bank(); Wait(100)); 
} 
       while (InvCount(351) > 0) 
{ 
       Deposit(351,1); 
       Wait(50); 
} 
       while (InvCount(349) > 0) 
{ 
       Deposit(349,1); 
       Wait(50); 
} 
{ 
        CloseBank(); 
       Walk(222, 658); 

} 
} 
} 
}  