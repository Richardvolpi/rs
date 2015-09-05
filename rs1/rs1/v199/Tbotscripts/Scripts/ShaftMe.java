public class ShaftMe extends Script 
{
    public ShaftMe(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"shaft"}; 
    }
    public void start(String command, String parameter[])
    {
		int startXP, startLevel, bagCount, shaftCount;
		long startTime = tickCount();
		startXP = experience(9);
		startLevel = playerStat(9);
		bagCount = 0;
		shaftCount = invCount(280);
		while (running())
		{
			while(invCount() < 30 && running())
			{
				if(!sleeping() && !inLastServerMessage("too tired") && running())
				{
					resetLastServerMessage();
					println("## Shafter - RichyT");
					println("# Running for " + (int)((tickCount() - startTime) / 1000) + " seconds");
					println("# Gained " + (experience(9) - startXP) + " experience, " + (playerStat(9) - startLevel) + " levels");
					println("# Slept " + bagCount + " times");
					int nearestObject = -1;
					int nearestObjectDistance = 9999;
					for(int i = 0; i < objectCount(); i++)
						if(objectType(i) == 0 || objectType(i) == 1)
							if(objectDistance(i) < nearestObjectDistance)
							{
								nearestObject = i;
								nearestObjectDistance = objectDistance(i);
							}
					if(nearestObject == -1)
						println("no tree found?");
					else
					{
						println("cutting tree " + nearestObject);
						atObject(nearestObject);
						long t = tickCount();
						while((objectType(nearestObject) == 0 || objectType(nearestObject) == 1) && tickCount() - t < random(2500,3000) && !inLastServerMessage("too tired") && running())
							wait(1);
					}
				} else
					if(!sleeping())
					{
						println("pre-sleep wait");
						wait(random(3000,4000));
						useByType(1263);
						bagCount++;
						wait(random(3000,4000));
					} else
						wait(1);
			}
			while(invCount(14) > 0 && running())
			{
				while(!questMenu() && running())
				{
					useOnInvByName("Knife","Logs");
					long t = tickCount();
					while(!questMenu() && tickCount() - t < random(3000,4000) && running())
						wait(1);
				}
				answerQuestMenu("Make longbow");
				long t = tickCount();
				int lastInvCount = invCount();
				while(lastInvCount == invCount() && tickCount() - t < random(2000,3000) && running())
					wait(1);				
			}
			while(invCount(276) > 0 && running())
			{
				dropByName("unstrung Longbow");
				long t = tickCount();
				int lastInvCount = invCount();
				while(lastInvCount == invCount() && tickCount() - t < random(1000,2000) && running())
					wait(1);				
			}
		}
		println("## script was stopped");
		endScript();
	}
}
