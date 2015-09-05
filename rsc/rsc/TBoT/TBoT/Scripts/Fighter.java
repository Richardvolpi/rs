public class Fighter extends Script 
{
    public Fighter(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"fight"}; 
    }
	int style;
	int npc[];
	int pickup[];
	boolean bones;
    public void start(String command, String parameter[])
    {
		if(parameter == null || parameter.length < 4)
		{
			println("Must run script as: ##fight [style] [type1/type2/type3/...] [pickup1/pickup2/pickup3/...] [bury bones yes/no]");
			endScript();
			return;
		}
		style = strToInt(parameter[0]);				
		if(parameter[1].indexOf("/") >= 0)
		{
			String tempNpc[] = parameter[1].split("/");
			npc = new int[tempNpc.length];
			for (int i = 0; i < tempNpc.length; i++)
				npc[i] = strToInt(tempNpc[i].trim());
		} else
			npc = new int[] { strToInt(parameter[2]) };

		if(parameter[2].indexOf("/") >= 0)
		{
			String tempNpc[] = parameter[2].split("/");
			pickup = new int[tempNpc.length];
			for (int i = 0; i < tempNpc.length; i++)
				pickup[i] = strToInt(tempNpc[i].trim());
		} else
			pickup = new int[] { strToInt(parameter[3]) };

		if(parameter[3].equals("yes"))
			bones = true;
		else
			bones = false;
		
		while (running())
		{
			while (!myPlayerInCombat() && running())
			{
				if(!sleeping() && fatigue() < 90)
				{
					if (fightMode() != strToInt(parameter[0]))
						setFightMode(strToInt(parameter[0]));
					int nearestNpc = -1;
					int nearestNpcDistance = -1;
					for (int i = 0; i < npcCount(); i++)
					{
						if (npcAttackable(i) && canReachNpc(i) && !npcInCombat(i) && npcPathLength(i) < nearestNpcDistance && rightNpc(i))
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						} else if (npcAttackable(i) && canReachNpc(i) && !npcInCombat(i) && nearestNpc == -1 && rightNpc(i))
						{
							nearestNpc = i;
							nearestNpcDistance = npcPathLength(i);
						}
					}
					if (nearestNpc != -1)
					{
						println("attacking npc (" + npcName(nearestNpc) + ") " + nearestNpc);
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
						boolean foundMatch = false;
						for (int i = 0; i < npcCount(); i++)
						{
							if(rightNpc(i))
							{
								println("found an npc that fits, but can't reach");
								foundMatch = true;
								int triedToFree = tryToFree();
								println("tryToFree() returned: " + triedToFree);
								if(triedToFree != -1)
									wait(random(3000,6000));
								break;
							}
						}
						if(!foundMatch)
							for(int i = 0; i < itemCount(); i++)
								if(rightItem(i))
								{
									int lastInvCount = invCount();
									if (!takeItem(i))
										println("error taking item?");
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
			if (myPlayerHitsPercentage() < 25)
			{
				if(invByCommand("Eat") == -1)
				{
					println("hits are only " + myPlayerHits() + ", no food - quitting");
					disableAutoLogin();
					logout();
					endScript();
					return;
				} else {
					println("eating at " + myPlayerHits());
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
			if(running())
				for(int i = 0; i < itemCount(); i++)
					if(rightItem(i))
					{
						int lastInvCount = invCount();
						if (!takeItem(i))
							println("error taking item?");
						long t = tickCount();
						while(tickCount() - t < random(2000,3000) && lastInvCount == invCount())
							wait(1);
					}
		}
		endScript();
    }

	public boolean rightNpc(int pos)
	{
		for (int i = 0; i < npc.length; i++)
			if(npcType(pos) == npc[i])
				return true;
		return false;
	}

	public boolean rightItem(int pos)
	{
		for (int i = 0; i < pickup.length; i++)
			if(itemType(pos) == pickup[i])
				return true;
		return false;
	}
}
