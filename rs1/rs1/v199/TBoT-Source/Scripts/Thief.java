public class Thief extends Script 
{
    public Thief(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"thief"}; 
    }
    public void start(String command, String parameter[])
    {
		int startX, startY;
		startX = myPlayerX();
		startY = myPlayerY();
		println("### Thief - RichyT");
		while (running())
		{
			while (!sleeping() && fatigue() < 90 && running())
			{
				while (!myPlayerInCombat() && running())
				{
					int nearestNpc = -1;
					int nearestNpcDistance = 999;
					for (int i = 0; i < npcCount(); i++)
					{
						if (npcType(i) == strToInt(parameter[0]) && canReachNpc(i) && !npcInCombat(i) && npcPathLength(i) < nearestNpcDistance)
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						} else if (npcType(i) == strToInt(parameter[0]) && canReachNpc(i) && !npcInCombat(i) && nearestNpc == -1)
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						}
					}
					if (nearestNpc != -1)
					{
						println("Thieving npc " + nearestNpc);
						if(npcPathLength(nearestNpc) > 7)
						{
							walkNoWait(npcX(nearestNpc),npcY(nearestNpc));
							while(npcPathLength(nearestNpc) > 7 && !npcInCombat(nearestNpc))
								wait(1);
						}
						if (!thieveNpc(nearestNpc))
							println("error attacking npc?");
						long t = tickCount();
						while (tickCount() - t < random(1000,2500) && !myPlayerInCombat())
							wait(1);
					} else
					{
						if(!canReach(startX,startY))
							if(tryToFree() == -1)
								wait(10);
						else 
						{
							walkNoWait(startX,startY);
							wait(random(2000,4000));
						}
						wait(1);
					}
				}
				while (myPlayerInCombat() && running())
				{
					if (fightMode() != 2)
						setFightMode(2);
					wait(1);
				}
			}
			if (!sleeping() && running())
			{
				println("## Pre-Sleep wait");
				wait(random(2000,3000));
				useByType(1263);
				wait(random(3000,4000));
			} else
				wait(10);
		}
		endScript();
    }
}
