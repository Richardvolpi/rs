/* 
command - /run ac PLAYERID 
PK help script and psuedo autocatcher 
What it does - basically it follows, you control everything else with hotkeys 
f3 - stops the chasing and attacks, timing is critical, wait till your one square away and hp bar is 
gone/or time has passed, then BAM press and hold, not for too long (1-2 seconds) untill you attack, if you fall behind 
let it follow again, but remember, timing is critical, if you got good timing you can catch most all of the time 
f4 - toggles fightmodes, default is agressive 
f5 - eats swordfish, but when no more swordfish in invetory, it eats lobster. Eats both but basically swordies have priority 
f6 - turns highest possible str prayer on/off, if you are not high enough level for a str prayer it will not respond 
f7 - turns highest possible att prayer on/off, if you are not high enough level for a att prayer it will not respond 
f8 - turns Protect items prayer on, if you are not high enough lvl for protect it will not respond 
home key - drinks all doses of str potions, drinks one with less doses with priority over others 
Well thats about it, if you have any questions contact me on irc "zanot" or on email/msn dzanot@gmail.com 
*/ 
public class HotCatch extends Script 
{ 
public HotCatch(mudclient rs) 
{ 
super(rs); 
} 
public String[] getCommands() 
{ 
return new String[]{"ac"}; 
} 
public boolean Attacking = false; 
public boolean SPray = false; 
public boolean APray = false; 
public boolean PPray = false; 
public int PlayerID = 0; 
public int Mode = 1; 
public void KeyReleased(int key) 
{ 
if(key == 1010) 
{ 
Attacking = false; 
} 
} 
public void KeyPressed(int key) 
{ 
if(key == 1000 && !InCombat()) 
{ 
if (InvCount(224) < 1) 
{ 
if (InvCount(223) < 1) 
{    
if (InvCount(222) < 1)        
{ 
if (InvCount(221) < 1) 
{ 
DisplayMessage("@Dre@No more potion left!!",3);                              
} 
else 
{ 
DisplayMessage("@Dre@Drank a dose, 3 doses remaining",3);          
Use(FindInv(221)); 
Wait(50); 
} 
} 
else 
{ 
DisplayMessage("@Dre@Drank a dose, 2 doses remaining",3);          
Use(FindInv(222)); 
Wait(50);    
} 
} 
else 
{ 
DisplayMessage("@Dre@Drank a dose, 1 dose remaining",3); 
Use(FindInv(223)); 
Wait(50); 
} 
} 
else 
{ 
DisplayMessage("@Dre@Drank last dose",3); 
Use(FindInv(224)); 
Wait(50); 
}} 
if(key == 1010 && !InCombat()) 
{ 
Attacking = true; 
DisplayMessage("@Dre@Attacking",3); 
SetFightMode(Mode); 
AttackPlayer(PlayerID); 
Wait(50); 
} 
if(key == 1012) 
{ 
if (InvCount(370) < 1) 
{ 
if (InvCount(373) > 0) 
{    
DisplayMessage("@Dre@Eat A Lobster " +InvCount(373)+ " Lobsters left",3);          
Use(FindInv(373)); 
Wait(50); 
} 
else 
{ 
DisplayMessage("@Dre@No more lobsters or swordfish!!!",3);  
} 
} 
else 
{ 
DisplayMessage("@Dre@Eat A SwordFish: " +InvCount(370)+ " Swordfish left",3);          
Use(FindInv(370)); 
Wait(50);  
}                
} 
if(key == 1015 && GetStat(5) >= 25) 
{ 
if(!PPray) 
{ 
PPray = true; 
PrayerOn(8); 
DisplayMessage("@Dre@Protect Items On",3); 
} 
else if(PPray) 
{ 
PPray = false; 
PrayerOff(8); 
DisplayMessage("@Dre@Protect Items Off",3); 
} 

} 
if(key == 1013 && GetStat(5) >= 4) 
{ 
if(!SPray) 
{ 
SPray = true; 
if (GetStat(5) >= 31) 
PrayerOn(10); 
if (GetStat(5) >= 13 && GetStat(5) < 31) 
PrayerOn(4); 
if (GetStat(5) >= 4 && GetStat(5) < 13) 
PrayerOn(1); 
DisplayMessage("@Dre@Strength Prayer On",3); 
} 
else if(SPray) 
{ 
PrayerOff(10); 
PrayerOff(4); 
PrayerOff(1); 
DisplayMessage("@Dre@Strength Prayer Off",3); 
SPray = false; 
} 
Wait(50); 
} 
if(key == 1014 && GetStat(5) >= 7) 
{ 
if(!APray) 
{ 
APray = true; 
if (GetStat(5) >= 34) 
PrayerOn(11); 
if (GetStat(5) >= 16 && GetStat(5) < 34) 
PrayerOn(5); 
if (GetStat(5) >= 7 && GetStat(5) < 16) 
PrayerOn(2); 
DisplayMessage("@Dre@Attack Prayer On",3); 
} 
else if(APray) 
{ 
PrayerOff(11); 
PrayerOff(5); 
PrayerOff(2); 
DisplayMessage("@Dre@Attack Prayer Off",3); 
APray = false; 
} 
Wait(50); 
} 
if(key == 1011) 
{ 
Mode++; 
if(Mode == 4) 
{ 
Mode = 0; 
DisplayMessage("@Dre@Controlled",3); 
SetFightMode(Mode); 
} 
if(Mode == 1) 
{ 
DisplayMessage("@Dre@Agressive",3); 
SetFightMode(Mode); 
} 
if(Mode == 2) 
{ 
DisplayMessage("@Dre@Accurate",3); 
SetFightMode(Mode); 
} 
if(Mode == 3) 
{ 
DisplayMessage("@Dre@Defensive",3); 
SetFightMode(Mode); 
} 
} 

} 
public void start(String command, String parameter[]) 
{ 
DisplayMessage("@bla@HotCatcher",3); 
DisplayMessage("@gre@By: Davis Zanot",3); 
PrayerOff(11); 
PrayerOff(10); 
PrayerOff(8); 
PrayerOff(5); 
PrayerOff(4); 
PrayerOff(2); 
PrayerOff(1); 
PlayerID = Integer.parseInt(parameter[0]); 
while (Running()) 
{ 
SetFightMode(Mode); 
while (!InCombat() && Running() && !Attacking) 
{ 
ForceWalkNoWait(PlayerDestX(PlayerID),PlayerDestY(PlayerID)); 
SetFightMode(Mode); 
Wait(50);} 
while (InCombat() && Running()) 
{ 
if (GetFightMode() != Mode) 
{ 
SetFightMode(Mode); 
} 
Wait(10); 
} 
while (!InCombat() && Running() && Attacking) 
Wait(25); 
} 
DisplayMessage("@red@STOPPED", 3); 
} 
}