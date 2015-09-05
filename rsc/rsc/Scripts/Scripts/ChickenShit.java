public class ChickenShit extends Script
{
    public ChickenShit(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"chicken"};
    }
    public void start(String command, String parameter[])
    {
int Mode = Integer.parseInt(parameter[0]);
int Goal = Integer.parseInt(parameter[1]);
int Rate = Integer.parseInt(parameter[2]);
int Pray = Integer.parseInt(parameter[3]);
int M = 0;
if (Mode == 1) { M = 2; } else if (Mode == 2) { M = 1; } else if (Mode == 3) { M = 3; }
String Modes[] = {"Error","Strength","Attack","Defence"};

DisplayMessage("@red@ChickenShit by rnyth starting...",3);
DisplayMessage("@red@Changing fight mode to " + Modes[Mode],3);
SetFightMode(Mode);

System.out.println("Auto fighting chickens");
System.out.println("     Mode: " + Modes[Mode]);
System.out.println("     Goal: " + Goal);
System.out.println("     Rate: " + Rate);
System.out.println("     Prayer: " + Pray);

while (Running() && GetStat(M) < Goal)
{
Wait(Rate);

if (GetX() > 273 || GetY() > 607) {
DisplayMessage("@red@Oops! You left the farm..",3); AtObject(274,603);
while (GetY() > 603)
{
while (ObjectAt(274,603) == 60) { AtObject(274,603); Wait(50); }
Wait(100); Walk(273,602);
}
while (ObjectAt(274,603) == 59) { AtObject2(274,603); Wait(50); }
AtObject2(274,603); }

if (GetY() < 603 && GetX() < 271) { DisplayMessage("@red@Oops! You walked into the house..",3); OpenDoor(271,602,1); Wait(100); Walk(273,602); }


while (InCombat()) { Wait(Rate); }

if (GetFightMode() != Mode) { SetFightMode(Mode); DisplayMessage("@red@Set fight mode to " + Modes[Mode],3); }
if (Fatigue() >=95)
{
Use(FindInv(1263));
while (Sleeping() && Running()) { Wait(100); }
}
if (GetNearestNPC(3) == -1 && Pray == 1) {
Wait(25);
int Bones[] = GetNearestItem(20);
if (Bones[0] < 274 && Bones[1] < 608 && Bones[0] > 268 && Bones[1] > 599) { TakeItem(Bones[0],Bones[1],20); }
Wait(25);
Use(FindInv(20));
} else {
AttackNPC(GetNearestNPC(3));
}

if (GetStat(M) == Goal) { DisplayMessage("@red@Congrats! Your goal of " + Goal + " " + Modes[Mode] + " has been reached!",3); }
}
DisplayMessage("@red@ChickenShit by rnyth finished",3);
      }
}