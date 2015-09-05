public class BoneCollector extends Script 
{
    public BoneCollector(mudclient rs)
    {
        super(rs); 
    }
    public String[] getCommands()
    {
        return new String[]{"bones"}; 
    }
	int TotalStartXP = 0;
	int StartLevel = 0;
	int BagCount = 0;
	long StartTime = 0;
	int Bones = 0;
    public void start(String command, String parameter[])
    {
		StartSleeper();
		TotalStartXP = GetExperience(5);
		StartLevel = GetStat(5);
		StartTime = (long)((int)(TickCount() / 1000));
		Println("##### Start Prayer Experience: " + TotalStartXP + " (" + StartLevel + ")");
		while (Running())
		{
			Println("#### Bone Collector - RichyT");
			Println("### " + ((long)((int)(TickCount() / 1000)) - StartTime) + " seconds have passed");
			Println("### Prayer Experience Gained So Far: " + (GetExperience(5) - TotalStartXP));
			Println("### Prayer Levels Gained So Far: " + (GetStat(5) - StartLevel));
			Println("### Bones Buried So Far: " + Bones);
			Println("### Number of times used the sleeping bag so far: " + BagCount);
			
			Println("## Collecting Bones");
			CollectBones();

			Println("## Burying Bones");
			BuryBones();
		}
		Println("#### Script Ended ####");
    }
	public void CollectBones()
	{
		while (InvCount() < 30)
		{
			int types[] = new int[] { 20 , 413 };
			int pos[] = GetNearestItem(types);
			if (pos[0] > 20)
			{
				TakeItem(pos[0],pos[1],pos[2]);
				Wait(Rand(1000,2000));
				Println("## Taking " + pos[2] + " at: " + pos[0] + ", " + pos[1]);
			} else 
				return;
			Wait(50);
		}
	}
	public void BuryBones()
	{
		while (InvCount(413) + InvCount(20) > 0)
		{
			if (InvCount(413) > 0)
			{
				Use(FindInv(413));
				Println("## Burying Big Bones");
				Wait(Rand(1000,2000));
				Bones++;
			}
			if (InvCount(20) > 0)
			{
				Use(FindInv(20));
				Println("## Burying Bones");
				Wait(Rand(1000,2000));
				Bones++;
			}
		}
	}
	public void StartSleeper()
	{
		new Thread
		(
			new Runnable()
			{
				public void run()
				{
					while (Running())
					{
						if (Fatigue() > 95 && !Sleeping())
						{
							Println("Fatigue is " + Fatigue() + ", using sleeping bag");
							Use(FindInv(1263));
							BagCount++;
							Wait(5000);
						}
						Wait(250);
					}
				}		
		}).start();
	}
}
