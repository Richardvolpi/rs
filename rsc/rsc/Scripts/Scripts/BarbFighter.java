public class BarbFighter extends Script
{
public BarbFighter(mudclient rs)
{
super(rs);
}
public String[] getCommands()
{
return new String[]{"fight"};
}
public void start(String command, String parameter[])
{
if (parameter.length != 2)
{
DisplayMessage("@whi@Ipod: @red@Wrong Syntax. /run [fight] [fightmode] [npc]", 3);
} else {
int FightMode = Integer.parseInt(parameter[0]);
int FightTime = 1000;
int FightType = Integer.parseInt(parameter[1]);
CheckFighters(true);
DisplayMessage("@whi@I-pod: @red@BarbFighter w/ anti lock-out - I-pod", 3);
while (Running() == true && GetCurrentStat(3) > 5)
{
if (GetFightMode() != FightMode)
{
SetFightMode(FightMode);
DisplayMessage("@whi@I-pod: @red@FightMode Changed To " + GetFightMode(), 3); 
while(DoorAt(235, 518, 2) == 2)
{
OpenDoor(235, 518, 2);
Wait(1000);
}
while(DoorAt(228, 521, 0) == 2)
{
OpenDoor(228, 521, 0);
Wait(1000);
}
while(DoorAt(230, 511, 0) == 2)
{
OpenDoor(230, 511, 0);
Wait(1000);
}
while(DoorAt(222, 625, 1) == 2)
{
OpenDoor(222, 625, 1);
Wait(1000);
}
while(ObjectAt(232, 503) == 64)
{
AtObject(232, 503);
Wait(1000);
}
}
if (InCombat() == false)
{
if (Fatigue() > 97 && Sleeping() == false)
{
DisplayMessage("@whi@I-pod: @red@Sleeping", 3);
Use(FindInv(1263));
Wait(5000);
} else {
if (Sleeping() == false)
{
int ID = GetNearestNPC(FightType);
if (ID != -1)
{
long T = System.currentTimeMillis();
AttackNPC(ID);
while (System.currentTimeMillis() - T <= FightTime && InCombat() == false && Running() == true)
Wait(1);
} else
Wait(1);
while(DoorAt(235, 518, 2) == 2)
{
OpenDoor(235, 518, 2);
Wait(1000);
}
while(DoorAt(228, 521, 0) == 2)
{
OpenDoor(228, 521, 0);
Wait(1000);
}
while(DoorAt(230, 511, 0) == 2)
{
OpenDoor(230, 511, 0);
Wait(1000);
}
while(DoorAt(222, 625, 1) == 2)
{
OpenDoor(222, 625, 1);
Wait(1000);
}
while(ObjectAt(232,503) == 64)
{
AtObject(232,503);
Wait(1000);
}
}
}
} else {
while (InCombat() == true && Running() == true)
Wait(1);
}
}
}
DisplayMessage("@red@STOPPED", 3);
}
}