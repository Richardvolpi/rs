public class AnyFight extends Script 
{
    public AnyFight(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"anyfight"}; 
    }
	int npc[];
	int fightMode = 1;
	int sleepCount = 0;
	int lastNpcX, lastNpcY, npcId;
	int startX, startY, range, minHp;
	int startAttack, startDefence, startStrength, startHits;
	int startAttackXP, startDefenceXP, startStrengthXP, startHitsXP;
	long startTime;
	boolean buryBones, debug;
    public void start(String command, String parameter[])
    {
		if (parameter == null || parameter.length != 5)
		{
			Println("##### Invalid parameters: /run anyfight [style] [range] [hp] [1/0 (show debugging)] [id1#id2#id3#..]");
			Println("#### Script Ended ####");
			EndScript();
			return;
		}
		try
		{
			fightMode = StrToInt(parameter[0]);
			range = StrToInt(parameter[1]);
			minHp = StrToInt(parameter[2]);
			if (parameter[3].equalsIgnoreCase("1"))
				debug = true;
			else
				debug = false;
			String tempNpc[] = parameter[4].split("#");
			npc = new int[tempNpc.length];
			for (int i = 0; i < tempNpc.length; i++)
				npc[i] = StrToInt(tempNpc[i].trim());
		}
		catch (Exception e)
		{
			Println("#### Error parsing parameters...");
			Println("#### Script Ended ####");
			EndScript();
			return;
		}
		startDebug();
		fightModeHax();
		while (Running())
		{
			while (!InLastServerMessage("tired") && Fatigue() < 90 && !Sleeping() && GetHP() > minHp && Running())
			{
				if (Distance(startX,startY) > range)
				{
					Println("### It seems that we have wandered out of range, attempting to move back");
					int midPointX,midPointY;
					while (Distance(startX,startY) > 15)
					{
						midPointX = startX;
						midPointY = startY;
						while (Distance(midPointX,midPointY) > 15)
						{
							midPointX = GetX() + (GetX() - midPointX);
							midPointY = GetY() + (GetY() - midPointY);
						}
						WalkNoWait(midPointX,midPointY);
						Println("### Walking back to midpoint at " + midPointX + "/" + midPointY);
						long T = TickCount();
						while (TickCount() - T < 5000 && CanReach(midPointX,midPointY))
							Wait(1);
						if (!CanReach(midPointX,midPointY))
							Println("## Something just trapped us!");
					}
					int walkBackX = startX + Rand(0,6) - 3;
					int walkBackY = startY + Rand(0,6) - 3;
					while (!CanReach(walkBackX,walkBackY) && CanReach(startX,startY) && Running())
					{
						walkBackX = Rand(0,6) - 3;
						walkBackY = Rand(0,6) - 3;
					}
					if (!CanReach(startX,startY))
					{
						Println("### Something has stopped us from reaching start point!");
						Wait(Rand(5000,10000));
					} else {
						WalkNoWait(walkBackX,walkBackY);
						long T = TickCount();
						while (TickCount() - T < 5000 && CanReach(walkBackX,walkBackY) && Running())
							Wait(10);
						if (!CanReach(walkBackX,walkBackY))
							Println("## Something is blocking us from getting back, probably a gate or door - cancelled wait");
					}
				}
				while (!InCombat() && Running())
				{
					npcId = GetNearestNPC(npc);
					if (npcId == -1 || !CanReach(NPCX(npcId),NPCY(npcId)))
					{
						Println("## No NPC's found, " + Distance(startX,startY) + " from start point");
						if (!CanReach(startX,startY))
						{
							Println("### Something has stopped us from reaching start point!");
							Wait(Rand(5000,10000));
						} else {
							int walkBackX = startX + Rand(0,6) - 3;
							int walkBackY = startY + Rand(0,6) - 3;
							while (!CanReach(walkBackX,walkBackY) && CanReach(startX,startY) && Running())
							{
								walkBackX = startX + Rand(0,6) - 3;
								walkBackY = startY + Rand(0,6) - 3;
							}
							if (!CanReach(startX,startY))
							{
								Println("### Something has stopped us from reaching start point!");
								Wait(Rand(5000,10000));
							} else {
								Println("## Walking to " + walkBackX + "/" + walkBackY);
								WalkNoWait(walkBackX,walkBackY);
								long T = TickCount();
								while (GetNearestNPC(npc) == -1 && TickCount() - T < 5000 && CanReach(walkBackX,walkBackY) && Running())
									Wait(10);
								if (!CanReach(walkBackX,walkBackY))
									Println("## Something is blocking us from getting back, probably a gate or door - cancelled wait");
								if (GetNearestNPC(npc) != -1)
									Println("## NPC appeared while walking back, cancelling wait");
							}
						}
					} else {
						if (GetDistance(startX,startY,NPCX(npcId),NPCY(npcId)) > range)
						{
							Println("## Nearest monster is out of range, we are " + Distance(startX,startY) + " from start point");
							int midPointX,midPointY;
							while (Distance(startX,startY) > 15)
							{
								midPointX = startX;
								midPointY = startY;
								while (Distance(midPointX,midPointY) > 15)
								{
									midPointX = GetX() + (GetX() - midPointX);
									midPointY = GetY() + (GetY() - midPointY);
								}
								WalkNoWait(midPointX,midPointY);
								Println("### Walking back to midpoint at " + midPointX + "/" + midPointY);
								long T = TickCount();
								while (TickCount() - T < 5000 && CanReach(midPointX,midPointY))
									Wait(1);
								if (!CanReach(midPointX,midPointY))
									Println("## Something just trapped us!");
							}
							int walkBackX = startX + Rand(0,6) - 3;
							int walkBackY = startY + Rand(0,6) - 3;
							while (!CanReach(walkBackX,walkBackY) && CanReach(startX,startY) && Running())
							{
								walkBackX = startX + Rand(0,6) - 3;
								walkBackY = startY + Rand(0,6) - 3;
							}
							Println("## Walking to " + walkBackX + "/" + walkBackY);
							if (!CanReach(startX,startY))
							{
								Println("### Something has stopped us from reaching start point!");
								Wait(Rand(5000,10000));
							} else {
								WalkNoWait(walkBackX,walkBackY);
								long T = TickCount();
								while (TickCount() - T < 5000 && CanReach(walkBackX,walkBackY) && Running())
									Wait(10);
								if (!CanReach(walkBackX,walkBackY))
									Println("## Something is blocking us from getting back, probably a gate or door - cancelled wait");
							}
						} else {
							Println("### Found NPC in range, " + npcId + " [" + GetNPCName(GetNPCType(npcId)) + "] - level " + GetNPCLevel(GetNPCType(npcId)));
							if (NPCExists(npcId))
							{
								if (Distance(NPCX(npcId),NPCY(npcId)) > 4)
								{
									Println("## NPC is " + Distance(NPCX(npcId),NPCY(npcId)) + " tiles away, walking closer");
									WalkNoWait(NPCX(npcId),NPCY(npcId));
									long T = TickCount();
									while (TickCount() - T < 2000 && GetNearestNPC(npc) == npcId && Distance(NPCX(npcId),NPCY(npcId)) > 4 && Running())
										Wait(1);
								}
								AttackNPC(npcId);
								Println("# Attacked " + GetNPCName(GetNPCType(npcId)) + " at " + NPCX(npcId) + "/" + NPCY(npcId));
								lastNpcX = NPCX(npcId);
								lastNpcY = NPCY(npcId);
								long T = TickCount();
								while (TickCount() - T < Rand(2000,3000) && !InCombat() && Running() && NPCExists(npcId) && !NPCInCombat(npcId))
									Wait(1);
							} else
								Println("## It vanished!");
						}
					}
				}
				while (InCombat() && Running())
				{
					while (GetHP() < minHp)
					{
						Println("### Player hp has just gone under, attempting to retreat");
						WalkNoWait(GetX(),GetY());
						Wait(Rand(1000,2500));
					}
					Wait(1);
				}
			}
			ResetLastServerMessage();
			while (GetHP() < minHp && Running())
			{
				Println("##### Player hp is " + GetHP() + ", " + (GetHP() - minHp) + " under the limit! Trying to find some food now");
				int eaten = 0;
				for (int i = InvCount() - 1; i >= 0; i--)
					if (GetItemCommand(Inv(i)).equalsIgnoreCase("eat") && GetHP() < minHp)
					{
						Println("### Eating " + GetItemName(Inv(i)) + " in slot " + i);
						Use(i);
						Wait(Rand(500,2000));
						eaten = 40;
					}
				if (eaten != 40)
				{
					Println("#### No food left in inventory!");
					debug();
					Println("#### Script Ended ####");
					DisableAutoLogin();
					Logout();
					EndScript();
					return;
				}
				Wait(10);
			}
			if (!Sleeping() && Running())
			{
				Println("### Fatigue is: " + Fatigue() + ", starting pre-sleep wait");
				Wait(Rand(3000,4000));
				if (FindInv(1263) == -1)
				{
					Println("## Cannot find sleeping bag!");
					debug();
					Println("#### Script Ended ####");
					DisableAutoLogin();
					Logout();
					EndScript();
					return;
				}
				Use(FindInv(1263));
				Println("## Used sleeping bag...");
				sleepCount++;
				Wait(Rand(3000,4000));
			}
			Wait(10);
		}
		Println("#### Script Ended ####");
		EndScript();
    }
	public void KeyPressed(int id)
	{
		if (id == 1014)
			debug();
		if (id == 1010)
		{
			Println("Setting fight mode to Controlled!");
			fightMode = 0;
		}
		if (id == 1011)
		{
			Println("Setting fight mode to Aggressive!");
			fightMode = 1;
		}
		if (id == 1012)
		{
			Println("Setting fight mode to Accurate!");
			fightMode = 2;
		}
		if (id == 1013)
		{
			Println("Setting fight mode to Defensive!");
			fightMode = 3;
		}
	}
	public void startDebug()
	{
		startTime = TickCount();
		startAttackXP = GetExperience(0);
		startDefenceXP = GetExperience(1);
		startStrengthXP = GetExperience(2);
		startHitsXP = GetExperience(3);
		startAttack = GetStat(0);
		startDefence = GetStat(1);
		startStrength = GetStat(2);
		startHits = GetStat(3);
		startX = GetX();
		startY = GetY();
		Println("##### SBoT AnyFight Script Started - RichyT");
		Println("#### Fight mode locked to " + fightMode);
		Println("#### Attacking all: " + getNpcs() + " within a range of " + range + " of " + startX + "/" + startY);
		Println("#### Eating food when HP is below " + minHp);
		Println("### F7 to see debug information");
		Println("### F3 through F6 to change fightmode");
		Println("## Happy Fighting :)");
	}
	public String getNpcs()
	{
		String retVal = "";
		for (int i = 0; i < npc.length - 1; i++)
			retVal = retVal + npc[i] + ",";
		return retVal + npc[npc.length-1];
	}
	public void debug()
	{
		Println("##### AnyFighter - Running for: " + ((TickCount() - startTime) / 1000) + " seconds");
		Println("##### Attack Experience gained: " + (GetExperience(0) - startAttackXP) + " (" + (GetStat(0) - startAttack) + ")");
		Println("##### Defence Experience gained: " + (GetExperience(1) - startDefenceXP) + " (" + (GetStat(1) - startDefence) + ")");
		Println("##### Strenth Experience gained: " + (GetExperience(2) - startStrengthXP) + " (" + (GetStat(2) - startStrength) + ")");
		Println("##### Hits Experience gained: " + (GetExperience(3) - startHitsXP) + " (" + (GetStat(3) - startHits) + ")");
	}
	public void Println(String message)
	{
		if (debug)
			super.Println(message);
	}
	public void fightModeHax()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (GetFightMode() != fightMode)
						{
							SetFightMode(fightMode);
							Println("## Changed fight mode to " + fightMode + "!");
						}
						Wait(1);
					}
				}		
		}).start();
	}
}