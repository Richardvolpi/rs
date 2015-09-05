public class cellherbs extends Script 
{ 
    public cellherbs(mudclient rs) 
    { 
        super(rs); 
    } 
    public String[] getCommands() 
    { 
        return new String[]{"cellgmherbs"}; 
    } 
    public void start(String command, String parameter[]) 
    { 
int Food = Integer.parseInt(parameter[0]); 
int Mode = Integer.parseInt(parameter[1]); 
String Modes[] = {"Controlled","Strength","Attack","Defence"}; 

SetFightMode(Mode); 
DisplayMessage("@ran@[[@ran@   cellherbs by time4u2di3jr started!",3); 
DisplayMessage("@ran@]]@ran@   PM any bugs to: cell",3); 

/* 
 
UNid ??? = 165 
UNid ??? = 438 
UNid ??? = 439
*/ 
int HerbID[] = {165,438,439}; 
int x = 0; 
String Location = "inside"; 

      while (Running()) 
      { 
Wait(100); 

if (Bank() == true) { Location = "bank"; } 

if (InvCount() < 30 && GetX() == 617 && GetY() == 556) { CloseDoor(617,556,0); } 
if (GetX() == 617 && GetY() == 555){ Location = "inside"; } 

while (InvCount() < 30 && Location == "inside" && Running()) 
{ 
Wait(100); 

if (GetFightMode() != Mode) { SetFightMode(Mode); DisplayMessage("@gre@[[ Set fight mode: " + Modes[Mode],3); } 
if (Fatigue() >= 90) { Use(FindInv(1263)); while(Sleeping()) { Wait(500); } } 
if (GetCurrentStat(3) < (GetStat(3) - 15)) { Use(FindInv(Food)); Wait(2000); } 


String Herbage = "a"; 
x = 0; 
while (x < (HerbID.length - 1)) { 
int herb[] = GetNearestItem(HerbID[x]); 
if (herb[0] > -1) { TakeItem(herb[0],herb[1],HerbID[x]); Wait(2000); Herbage = "b";} 
x=x+1; 
} 

if (Herbage == "a") { AttackNPC(GetNearestNPC(270)); } 
x = 0; 

 while (InCombat()) { Wait(250); } 
} 

if (InvCount() == 30 && Location == "inside") 
{ 
OpenDoor(617,556,0); 
Walk(596,603);         // to bridge 
Wait (500); 
Walk(593,603);             // mid bridge 
Wait(500); 
Walk(581,571);         // outside bank 
Location = "bank"; 
} 


if (InvCount() == 30 && Location == "bank" && Bank() == false) 
{ 
for(TalkToNPC(GetNearestNPC(95)); !QuestMenu() && Running() && Bank() == false; Wait(5000)); 
for(Answer(0); QuestMenu() && Running() && Bank() == false; Answer(0)); 
} 

if (Bank()) 
{ 
x = -1; 
while (x < (HerbID.length - 1) && Running()) { Wait(75); x=x+1;while (InvCount(HerbID[x]) != 0) { Deposit(HerbID[x],1); Wait(75); } 
if (InvCount(Food) == 0) { Withdraw(Food,1); Withdraw(Food,1); Withdraw(Food,1); } 
} 
CloseBank(); 
Walk(581,571);    // to the doors 
Walk(590,603);   // to bridge 
Wait(100); 
Walk(593,603);   // mid bridge 
Wait(100); 
Walk(596,603);   // across bridge 
Wait(100); 
Walk(617,556);   // to building 
} 
      } 
DisplayMessage("@gre@[[@ran@   GetHerbs by time4u2di3jr stopped!",3); 
    } 
}