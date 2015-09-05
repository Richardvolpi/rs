public class Herblaw extends Script 
{
    public Herblaw(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"herblaw"}; 
    }
	int walkPathX[] = new int[] { 581, 586, 587, 587, 587, 587, 587, 587, 597, 602, 610, 611, 611, 610, 611, 616 };
	int walkPathY[] = new int[] { 571, 571, 575, 580, 585, 590, 595, 600, 601, 595, 593, 586, 579, 571, 565, 558 };
    public void start(String command, String parameter[])
    {
		while (running())
		{
			while(invByCommand("Identify") != -1 && running())
			{
				while (!bank() && running())
				{
					while (!questMenu() && running())
					{
						int banker = -1;
						for (int i = 0; i < npcCount(); i++)
							if (npcType(i) == 95)
								banker = i;
						if (banker != -1)
						{
							println("Talking to banker " + banker);
							talkToNpc(banker);
							long t = tickCount();
							while (tickCount() - t < random(6000,8000) && !questMenu())
								wait(1);
						}
					}
					while (!bank() && running())
					{
						println("Answering banker...");
						answerQuestMenu(0);
						long t = tickCount();
						while (tickCount() - t < random(6000,8000) && !bank())
							wait(1);
					}
				}
				while(invByCommand("Identify") != -1 && running())
				{
					deposit(inv(invByCommand("Identify")));
					wait(random(50,200));
				}
				closeBank();
			}
			walkPath(walkPathX,walkPathY);
			while (myPlayerX() != 617 || myPlayerY() != 555 && running())
			{
				closeDoor(findDoor(617,556));
				wait(random(1000,2500));
			}
			while (invCount() < 30 && running())
			{
				while (!myPlayerInCombat() && running())
				{
					if(!sleeping() && fatigue() < 90)
					{
						if(!canReach(618,554))
							while (myPlayerX() != 617 && myPlayerY() != 555 && running())
							{
								closeDoor(findDoor(617,556));
								wait(random(1000,2500));
							}
						int nearestNpc = -1;
						int nearestNpcDistance = 999;
						for (int i = 0; i < npcCount(); i++)
						{
							if (npcType(i) == 270 && canReachNpc(i) && !npcInCombat(i) && npcPathLength(i) < nearestNpcDistance)
							{
								nearestNpc = i;
								nearestNpcDistance = npcPathLength(i);
							} else if (npcType(i) == 270 && canReachNpc(i) && !npcInCombat(i) && nearestNpc == -1)
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
								while(npcPathLength(nearestNpc) > 7 && !npcInCombat(nearestNpc))
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
				while (myPlayerInCombat() && running())
				{
					if (fightMode() != 2)
						setFightMode(2);
					wait(1);
				}
				if(!canReach(618,554))
					while (myPlayerX() != 617 && myPlayerY() != 555 && running())
					{
						closeDoor(findDoor(617,556));
						wait(random(1000,2500));
					}
				wait(random(100,200));
				for(int i = 0; i < itemCount(); i++)
					if(itemName(itemType(i)).equals("Herb") && itemX(i) == myPlayerX() && itemY(i) == myPlayerY() && running())
					{
							int lastInvCount = invCount();
							if (!takeItem(i))
								println("error taking herb?");
							long t = tickCount();
							while(tickCount() - t < random(2000,3000) && lastInvCount == invCount() && running())
								wait(1);
					}
			}
			while (myPlayerX() != 617 && myPlayerY() != 556 && running())
			{
				openDoor(findDoor(617,556));
				wait(random(1000,2500));
			}
			walkPathReverse(walkPathX,walkPathY);
		}
		endScript();
    }
}
