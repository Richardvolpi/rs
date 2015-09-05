public class Gnomer extends Script 
{
    public Gnomer(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"gnomer"}; 
    }
    public void start(String command, String parameter[])
    {
		while (running())
		{
			while (!myPlayerInCombat() && running())
			{
				if(!sleeping() && fatigue() < 90)
				{
					if (fightMode() != strToInt(parameter[0]))
						setFightMode(strToInt(parameter[0]));
					int nearestNpc = -1;
					int nearestNpcDistance = 999;
					for (int i = 0; i < npcCount(); i++)
					{
						if (npcAttackable(i) && npcLevel(i) < 10 && canReachNpc(i) && !npcInCombat(i) && npcPathLength(i) < nearestNpcDistance)
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						} else if (npcAttackable(i) && npcLevel(i) < 10 && npcLevel(i) <= 9 && canReachNpc(i) && !npcInCombat(i) && nearestNpc == -1)
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						}
					}
					if (nearestNpc != -1)
					{
						println("Attacking npc " + nearestNpc);
						if(npcPathLength(nearestNpc) > 7)
						{
							walkNoWait(npcX(nearestNpc),npcY(nearestNpc));
							long t = tickCount();
							while(npcPathLength(nearestNpc) > 7 && !npcInCombat(nearestNpc) && running() && tickCount() - t < random(3000,4000))
								wait(1);
						}
						if (!attackNpc(nearestNpc))
							println("error attacking npc?");
						long t = tickCount();
						while (tickCount() - t < random(2000,4000) && !myPlayerInCombat())
							wait(1);
					} else {
						for(int i = 0; i < itemCount(); i++)
							if(itemName(itemType(i)).equals("Herb"))
							{
									int lastInvCount = invCount();
									if (!takeItem(i))
										println("error taking herb?");
									long t = tickCount();
									while(tickCount() - t < random(2000,3000) && lastInvCount == invCount())
										wait(1);
							}
						wait(1);
					}
				} else
					if(!sleeping() && running())
					{
						println("pre-sleep wait");
						wait(random(3000,4000));
						useByType(1263);
						wait(random(3000,4000));
					} else
						wait(1);
			}
			if (myPlayerHits() < 15)
			{
				if(invByCommand("Eat") == -1)
				{
					println("HITS ARE ONLY " + myPlayerHits() + " - QUITTING");
					disableAutoLogin();
					logout();
					endScript();
					return;
				} else {
					println("Eating at " + myPlayerHits());
					useByCommand("Eat");
					wait(random(2000,3000));
				}
			}
			while (myPlayerInCombat() && running())
			{
				if (fightMode() != strToInt(parameter[0]))
					setFightMode(strToInt(parameter[0]));
				wait(1);
			}
		}
		endScript();
    }
}
