public class CopperTinSmelt extends Script 
{ 

    public CopperTinSmelt(mudclient mudclient) 
    { 
        super(mudclient); 
    } 

    public String[] getCommands() 
    { 
        return (new String[] { 
            "coppertinsmelt" 
        }); 
    } 

    public void start(String s, String as[]) 
    { 
        DisplayMessage("@ran@N@ran@S@ran@O@ran@M@ran@N@ran@I@ran@A@ran@: Mining tin+copper and smelting bronze bars  Hahahah", 3); 
while (Running())
{
               if (Fatigue() > 97 && Sleeping() == false) 
               { 
                  DisplayMessage("@yel@Mod Mark: Sleeping...", 3); 
                  Use(FindInv(1263)); 
                  Wait(5000); 
               } else  
    
                  if (Sleeping() == false) 

	while(InvCount(150) < 14 && Running() == true) 
{
		AtObject(310,635); 
		Wait(5000); 
		AtObject(309,635); 
		Wait(5000);  
{ 
}
}
{
	while(InvCount(202) < 14 && Running() == true)  
{ 
		AtObject(308,641); 
		Wait(5000); 
} 
} 
{ 
	while (Running()  == true && InvCount() == 30) 
{ 
		Walk(307,632); 
		Walk(306,622); 
		Walk(305,612); 
		Walk(300,606); 
		Walk(292,602); 
		Walk(291,595); 
		Walk(292,586); 
		Walk(291,577); 
		Walk(292,567); 
		Walk(291,559); 
		Walk(294,551); 
		Walk(303,547); 
		Walk(306,544); 
		Wait(200); 
	while(InvCount(150) > 0 && Running() == true) 
{ 
		UseOnObject(306, 546, 2); 
		Wait(2600); 
} 
} 
} 
{ 
	while(InvCount(169) == 14) 
{ 
		Walk(294,551); 
		Walk(291,563); 
		Walk(287,571); 
		Walk(284,569); 

while(Bank() == false) { 
while(!QuestMenu()) 
{ 
	long l = System.currentTimeMillis(); 
	int bankerID = GetNearestNPC(95); 
	TalkToNPC(bankerID); 
	while(System.currentTimeMillis() - l <= 2000L && 	!QuestMenu()) 
	Wait(1000); 
} 
            
		Answer(0); 
		Wait(5000); 
} 

	while(InvCount(169) > 0) 
{ 
		Deposit(169,1); 
		Wait(100); 
} 

		CloseBank(); 
} 
}
{
		Walk(289,571);
		Walk(290,582);
		Walk(291,593);
		Walk(291,603);
		Walk(294,609);
		Walk(299,612);
		Walk(298,621);
		Walk(302,631);
		Walk(308,634);
}
DisplayMessage("@red@OVERDOSED Hahahahahah", 3); 
} 
} 
}