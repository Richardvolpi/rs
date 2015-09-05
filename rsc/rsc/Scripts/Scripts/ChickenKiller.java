public class ChickenKiller extends Script 
{ 
public ChickenKiller(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"chickenkiller"}; 
} 
public void start(String command, String parameter[]) 
{ 
if (parameter.length != 4) 
{ 
DisplayMessage(" @whi@  it's /run chickenkiller mode ", 3); 
} else { 
int FightMode = Integer.parseInt(parameter[0]); 
int FightTime =750; 
int ID = (3); 
int ItemId = (381); 
CheckFighters(true); 
DisplayMessage("@gre@SBoT: @whi@ChickenKiller @ran@- @ran@j@or1@ustin@ran@s", 3); 
while (Running() == true && GetCurrentStat(3) > 5) 
{ 
if (GetFightMode() != FightMode) 
{ 
SetFightMode(FightMode); 
DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(), 3); 
} 
if (InCombat() == false) 
{ 
if (Fatigue() > 97 && Sleeping() == false) 
{ 
DisplayMessage("@gre@SBoT: @whi@Sleeping", 3); 
Use(FindInv(1263)); 
Wait(5000); 
} else { 
if (Sleeping() == false) 
{ 
ID = GetNearestNPC(ID); 
if (ID != -1) 
{ 
long T = System.currentTimeMillis(); 
AttackNPC(ID); 
while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true) 
Wait(1); 
} else { 
while ( Sleeping() == false && InCombat() == false && ID == -1) 

{ 
ID = GetNearestNPC(ID); 
while (ID == -1) 
{ 
ID = GetNearestNPC(ID); 
int Item [] = GetNearestItem(ItemId); 
if(Item != null) 
{ 
TakeItem(Item[0], Item[1], ItemId); 
Wait(150); 
} 
} 
} 

} 
} 
} 
} 
} 

} 
DisplayMessage("@gre@SBoT: @whi@ChickenKiller - @red@STOPPED", 3); 
} 
} 