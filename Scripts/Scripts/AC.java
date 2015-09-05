public class AC extends Script
{
public AC(mudclient rs)
{
super(rs);
}
public String[] getCommands()
{
return new String[]{"ac"};
}

public void start(String command, String parameter[])
{
DisplayMessage("@bla@AutoCatcher",3);
int PlayerID = Integer.parseInt(parameter[0]);
while (Running())
{
SetFightMode(1);

while (!InCombat() && Running() )
{
long Seconds = System.currentTimeMillis();
while (System.currentTimeMillis() - Seconds <= 3000 && !InCombat())
{
ForceWalkNoWait(PlayerDestX(PlayerID),PlayerDestY(PlayerID));
if (GetStat(3) - GetCurrentStat(3) > 12)
{
Use(FindInv(373));
}
}
SetFightMode(1);
if (Abs(PlayerX(PlayerID)-GetX()) <= 1 && Abs(PlayerY(PlayerID)-GetY()) <= 1)
AttackPlayer(PlayerID);
Wait(200);
}
while (InCombat() && Running())
{
if (GetFightMode() != 1)
{
SetFightMode(1);
}
Wait(100);
}
}
DisplayMessage("@red@STOPPED", 3);
}
public int Abs(int Value)
{
if (Value < 0)
Value = Value * -1;
return Value;
}
}