public class CowHider extends Script 
{
    public CowHider(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"hide"}; 
    }
	int startXP = 0;
	int startLevel = 0;
	int startGold = 0;
	int trips = 0;
	int making = 0;


	int gateTannerX[] = new int[] { 89, 88, 85, 82, 82 };
	int gateTannerY[] = new int[] { 652, 656, 660, 669, 674 };

	int cowGateX[] = new int[] { 105, 105, 103, 98, 96, 94 };
	int cowGateY[] = new int[] { 620, 624, 631, 636, 641, 646 };

	int dropID = 0;

	int hideID = 147;
	int needleID = 39;
	int closedGateID = 60;
	int leatherID = 148;
    public void start(String command, String parameter[])
    {
		try
		{
			if (parameter.length != 1)
			{
				DisplayMessage("@gre@SBoT: @whi@Invalid Parameter Length! /run hide [tanneroption]", 3);
				return;
			} else
				making = StrToInt(parameter[0]);
			if (making == 0)
				dropID = 15;
			else if (making == 1)
				dropID = 16;
			else if (making == 2)
				dropID = 17;
			else
				return;
			startXP = GetExperience(12);
			startLevel = GetStat(12);
			startGold = InvCount(10);
			while (Running())
			{
				trips++;
				Debug();
				if (GetY() < 645)
				{
					while (InvCount() < 30 && Running())
					{
						int hidePos[] = GetNearestItem(hideID);
						TakeItem(hidePos[0],hidePos[1],hideID);
						int hideCount = InvCount(hideID);
						long T = TickCount();
						while (TickCount() - T < Rand(750,1250) && InvCount(hideID) == hideCount && Running())
							Wait(1);
					}
					Walk(104,620,Rand(8000,10000));
					/*if (ObjectAt(105,619) != closedGateID)
						Walk(105,620);
					else
						while (!CoordsAt(105,620) && Running())
						{
							while (ObjectAt(105,619) == closedGateID && Running())
							{
								AtObject(105,619);
								long T = TickCount();
								while (TickCount() - T < Rand(4000,5000) && ObjectAt(105,619) == closedGateID && Running())
									Wait(1);
								if (ObjectAt(105,619) != closedGateID)
								{
									Wait(Rand(4000,6000));
									WalkNoWait(105,620);
									T = TickCount();
									while (TickCount() - T < Rand(3000,4000) && !CoordsAt(105,620) && Running())
										Wait(1);
								}
							}
						}*/
					WalkPath(cowGateX,cowGateY);
					if (InvCount(10) < 1000)
					{
						Println("#### Cash left: " + InvCount(10));
						Quit();
					}
				}
				while (GetX() != 91 && Running())
				{
					while (!QuestMenu() && Running())
					{
						TalkToNPC(GetNearestNPC(161));
						long T = TickCount();
						ResetLastServerMessage();
						while (TickCount() - T < Rand(4000,6000) && !QuestMenu() && !InLastServerMessage("busy") && Running())
							Wait(1);
						if (QuestMenu())
						{
							Wait(Rand(100,250));
							Answer(2);
							T = TickCount();
							while (TickCount() - T < Rand(7000,9000) && GetX() != 91)
								Wait(1);
						}
						if (GetX() == 91)
							break;
					}
					Wait(1000);
				}
				Println("Through gate!");
				WalkPath(gateTannerX,gateTannerY);
				while (!CoordsAt(83,674) && Running())
				{
					OpenDoor(83,674,1);
					long T = TickCount();
					while (TickCount() - T < Rand(4000,5000) && DoorAt(83,674,1) == 2 && Running())
						Wait(1);
					Wait(Rand(3000,4000));
					WalkNoWait(83,674);
					T = TickCount();
					while (TickCount() - T < Rand(3000,4000) && !CoordsAt(83,674) && Running())
						Wait(1);
				}
				while (InvCount(hideID) > 0 && Running())
				{
					while (!QuestMenu() && Running())
					{
						TalkToNPC(GetNearestNPC(172));
						long T = TickCount();
						while (TickCount() - T < Rand(4000,6000) && !InLastServerMessage("busy") && !QuestMenu() && Running())
							Wait(1);
					}
					if (QuestMenu())
					{
						Answer(1);
						long T = TickCount();
						while (TickCount() - T < Rand(40000,60000) && InvCount(hideID) > 0 && Running())
							Wait(1);
					}
				}
				while (InvCount(leatherID) > 0 && Running())
				{
					if (Fatigue() < 90 && !Sleeping())
					{
						UseWithInventory(FindInv(needleID),FindInv(leatherID));
						long T = TickCount();
						while (TickCount() - T < Rand(4000,5000) && !QuestMenu() && Running())
							Wait(1);
						if (QuestMenu())
						{
							Answer(making);
							int leatherCount = InvCount(leatherID);
							T = TickCount();
							while (TickCount() - T < Rand(4000,5000) && InvCount(leatherID) == leatherCount && Running())
								Wait(1);
						}
					} else if (!Sleeping())
					{
						Wait(Rand(3000,4000));
						Use(FindInv(1263));
						Wait(Rand(4000,5000));
					} else
						Wait(1);
				}
				while (InvCount(dropID) > 0)
				{
					Drop(FindInv(dropID));
					int dropCount = InvCount(dropID);
					long T = TickCount();
					while (TickCount() - T < Rand(1500,2500) && InvCount(dropID) == dropCount && Running())
						Wait(1);
				}
				while (!CoordsAt(82,674) && Running())
				{
					OpenDoor(83,674,1);
					long T = TickCount();
					while (TickCount() - T < Rand(4000,5000) && DoorAt(83,674,1) == 2 && Running())
						Wait(1);
					Wait(Rand(3000,4000));
					WalkNoWait(82,674);
					T = TickCount();
					while (TickCount() - T < Rand(3000,4000) && !CoordsAt(82,674) && Running())
						Wait(1);
				}
				WalkPathReverse(gateTannerX,gateTannerY);
				while (GetX() != 92 && Running())
				{
					while (!QuestMenu() && Running())
					{
						TalkToNPC(GetNearestNPC(162));
						long T = TickCount();
						ResetLastServerMessage();
						while (TickCount() - T < Rand(4000,6000) && !QuestMenu() && !InLastServerMessage("busy") && Running())
							Wait(1);
						if (QuestMenu())
						{
							Wait(Rand(100,250));
							Answer(2);
							T = TickCount();
							while (TickCount() - T < Rand(7000,9000) && GetX() != 92)
								Wait(1);
						}
						if (GetX() == 92)
							break;
					}
					Wait(1000);
				}
				Println("Back through gate!");
				Walk(99,637);
				Walk(105,620);
				/*while (!CoordsAt(104,619) && Running())
				{
					while (ObjectAt(105,619) == closedGateID && Running())
					{
						AtObject(105,619);
						long T = TickCount();
						while (TickCount() - T < Rand(4000,5000) && ObjectAt(104,619) == closedGateID && Running())
							Wait(1);
						if (ObjectAt(105,619) != closedGateID)
						{
							Wait(Rand(4000,6000));
							WalkNoWait(104,619);
							T = TickCount();
							while (TickCount() - T < Rand(3000,4000) && !CoordsAt(104,619) && Running())
								Wait(1);
						}
					}
				}*/
			}
			Println("#### Cow Hider - Stopped");
			Debug();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
    }
	public void Debug()
	{
		Println("##### Cow Hider - RichyT");
		Println("#### Trip number " + trips);
		Println("### Crafting Experience Gained: " + (GetExperience(12) - startXP));
		Println("### Crafting Levels Gained: " + (GetStat(12) - startLevel));
		Println("### Gold Spent: " + (startGold - InvCount(10)));
	}
}