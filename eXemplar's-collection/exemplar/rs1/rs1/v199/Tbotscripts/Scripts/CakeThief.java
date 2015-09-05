public class CakeThief extends Script 
{
    public CakeThief(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"cakethief"}; 
    }
    public void start(String command, String parameter[])
    {
		println("### CakeThief - RichyT");
		while (running())
		{
			while (invCount() < 30 && running())
			{
				while (!sleeping() && invCount() < 30 && fatigue() < 90 && running())
				{
					while (!myPlayerInCombat() && invCount() < 30 && running())
					{
						int stall = -1;
						for (int i = 0; i < objectCount(); i++)
							if (objectType(i) == 322)
								stall = i;
						if (stall != -1)
						{
							println("Thieving stall!");
							if (!atObject2(stall))
								println("error thieving stall?");
							long t = tickCount();
							while (tickCount() - t < random(2000,3000) && !myPlayerInCombat())
								wait(1);
						} else
							wait(1);
					}
					while (myPlayerInCombat() && running())
					{
						if (fightMode() != 2)
							setFightMode(2);
						wait(1);
					}
				}
				if (!sleeping() && fatigue() >= 90 && running())
				{
					wait(random(2000,3000));
					useByType(1263);
					wait(random(3000,4000));
				} else
					wait(10);
			}
			walk(548,610);
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
						while(!canReachNpc(banker))
						{
							tryToFree();
							wait(random(2500,4000));
						}
						println("Talking to banker " + banker);
						resetLastQuestMessage();
						talkToNpc(banker);
						long t = tickCount();
						while (tickCount() - t < random(6000,8000) && !inLastQuestMessage("busy") &&!questMenu())
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
			while (invCount(330) > 0 && bank() && running())
			{
				deposit(330);
				wait(random(10,100));
			}
			wait(random(600,1200));
			closeBank();
			while(!canReach(543,600))
			{
				tryToFree();
				wait(random(2500,4000));
				walkNoWait(543,600);
				wait(random(2500,4000));
			}
			walk(543,600);
			wait(random(500,1000));
		}
		endScript();
    }
}
