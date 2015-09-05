//This script has been requested by 0wn4g3. 
//Start in Varrock West Bank. 
public class BowlMaker extends Script 
{ 
public BowlMaker(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"makebowls"}; 
} 
public void start(String command, String parameter[]) 

{ 
DisplayMessage("@gre@SBoT: @whi@Bowl Maker Barb/Varrock - @ran@Vegunks",3); 
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
while(InvCount(341) > 0) 
{ 
Deposit(341,1); 
Wait(100); 
} 

while(InvCount(243) < 29) 
{ 
Withdraw(243,1); 
Wait(100); 
} 
CloseBank(); 

} 



//Walking To Barbarian Village 


Walk(151,508); 
Wait(100); 
Walk(157,507); 
Wait(100); 
Walk(166,507); 
Wait(100); 
Walk(174,511); 
Wait(100); 
Walk(180,515); 
Wait(100); 
Walk(186,515); 
Wait(100); 
Walk(191,515); 
Wait(100); 
Walk(197,515); 
Wait(100); 
Walk(204,512); 
Wait(100); 
Walk(211,512); 
Wait(100); 
Walk(217,512); 
Wait(100); 
Walk(224,513); 
Wait(100); 
Walk(228,519); 
Wait(100); 
Walk(229,522); 
Wait(1000); 

//Crafting 
while (Running() == true && InvCount(243) > 0) 
{ 
//Firing Part 
UseOnObject(228, 524, FindInv(243)); 
Wait(2500); 
while (QuestMenu() == false && Running() == true) 
{ 
Wait(100); 
} 

Answer(2); 
Wait(2500); 
UseOnObject(229, 523, FindInv(340)); 
Wait(5000); 

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

Walk(229,522); 
Wait(100); 
Walk(228,519); 
Wait(100); 
Walk(224,513); 
Wait(100); 
Walk(217,512); 
Wait(100); 
Walk(211,512); 
Wait(100); 
Walk(204,512); 
Wait(100); 
Walk(197,515); 
Wait(100); 
Walk(191,515); 
Wait(100); 
Walk(186,515); 
Wait(100); 
Walk(180,515); 
Wait(100); 
Walk(174,511); 
Wait(100); 
Walk(166,507); 
Wait(100); 
Walk(157,507); 
Wait(100); 
Walk(151,508); 
Wait(1000); 
} 
DisplayMessage("@red@STOPPED", 3); 
} 
}
