public class SuperThiever extends Script 
{ 
public SuperThiever(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"thievefarmer","thieveman","thieveguard","thieveknight","thievetowerguard","thievepaladin","thievehero","thievecakestall","thievesilverstall","thievefurstall","thievespicesstall","thievegemstall"}; 
} 
public void start(String command, String parameter[]) 
{ 
DisplayMessage("@whi@SBoT: @mag@SuperThiever by shaodwhunter", 3); 
{ 
{ 

if (command.equalsIgnoreCase("thievecakestall")) 
while (Running()) 

{ 
AtObject2(544,599); 
Wait(1000); 
Walk(544,601); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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


if (command.equalsIgnoreCase("thievesilverstall")) 
while (Running()) 
{ 
AtObject2(555,593); 
Wait(1000); 
Walk(556,592); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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


if (command.equalsIgnoreCase("thievefurstall")) 
while (Running()) 
{ 
AtObject2(551,583); 
Wait(1000); 
Walk(552,582); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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

if (command.equalsIgnoreCase("thievespicesstall")) 
while (Running()) 
{ 
AtObject2(544,590); 
Wait(1000); 
Walk(543,590); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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

if (command.equalsIgnoreCase("thievegemstall")) 
while (Running()) 
{ 
AtObject2(551,599); 
Wait(1000); 
Walk(552,601); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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

if (command.equalsIgnoreCase("thieveman")) 
while (Running()) 
{ 
int man = GetNearestNPC(11); 
ThieveNPC(GetNearestNPC(11)); 
Wait(500); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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

if (command.equalsIgnoreCase("thievefarmer")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(1); 

if(InCombat() && Running()) 
{ 
SetFightMode(3); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(InCombat()== true && Running()) 

{ 
int farmer = GetNearestNPC(63); 
ThieveNPC(GetNearestNPC(63)); 
Wait(500); 
} 
} 
} 
} 


if (command.equalsIgnoreCase("thievewarrior")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(1); 

if(InCombat() && Running()) 
{ 
SetFightMode(2); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(InCombat()== true && Running()) 
{ 
int warrior = GetNearestNPC(86); 
ThieveNPC(GetNearestNPC(86)); 
Wait(500); 
} 
} 
} 
} 

if (command.equalsIgnoreCase("thieveguard")) 
while (Running()) 
{ 
int guard = GetNearestNPC(321); 
ThieveNPC(GetNearestNPC(321)); 
Wait(500); 
if(InCombat()) 
{ 
SetFightMode(1); 
WalkNoWait(GetX(), GetY()); 
Wait(666); 
} 
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


if (command.equalsIgnoreCase("thieveknight")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(2); 

if(InCombat() && Running()) 
{ 
SetFightMode(2); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(!InCombat()) 
{ 
int knight = GetNearestNPC(322); 
ThieveNPC(GetNearestNPC(322)); 
Wait(500); 
} 
} 
} 
} 

if (command.equalsIgnoreCase("thievetowerguard")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(2); 

if(InCombat() && Running()) 
{ 
SetFightMode(2); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(!InCombat()) 
{ 
int towerguard = GetNearestNPC(325); 
ThieveNPC(GetNearestNPC(325)); 
Wait(500); 
} 
} 
} 
} 

if (command.equalsIgnoreCase("thievepaladin")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(2); 

if(InCombat() && Running()) 
{ 
SetFightMode(3); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(!InCombat()) 
{ 
int paladin = GetNearestNPC(323); 
ThieveNPC(GetNearestNPC(323)); 
Wait(500); 
} 
} 
} 
} 
} 

if (command.equalsIgnoreCase("thievehero")) 
while (Running()) 
{ 
if (Fatigue() > 95 && Sleeping() == false) 
{ 
DisplayMessage("@ran@Sleepy Time",3); 
Use(FindInv(1263)); 
Wait(5000); 
} 
else { 
if (Sleeping() == false); 
{ 
Wait(500); 
SetFightMode(2); 

if(InCombat() && Running()) 
{ 
SetFightMode(2); 
WalkNoWait(GetX(), GetY() -2); 
Wait(300); 
if(!InCombat()) 
Wait(500); 
} 
if(!InCombat()) 
{ 
int hero = GetNearestNPC(324); 
ThieveNPC(GetNearestNPC(324)); 
Wait(500); 
} 
} 
} 
} 
} while(true); 
} 
} 
