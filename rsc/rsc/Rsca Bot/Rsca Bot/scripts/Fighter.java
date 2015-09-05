import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Fighter extends Commands
{
	private int mode = 0;
	
    public Fighter(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	boolean att = false;
    	int fightStyle = showOptions("What script style?", new String[]{"Fight any NPC", "Specify ID"});
    	int[] npcIds = new int[0];
    	int[] itemIds = new int[0];
    	
    	if(fightStyle == 1)
    	{
    		String[] ids = getInput("Enter the desired NPC ID(s) (separated by commas)").trim().split(",");
    		npcIds = new int[ids.length];
    		for(int i = 0; i < npcIds.length; i++)
    			npcIds[i] = Integer.parseInt(ids[i]);
    	}
    	
    	boolean prayer = showYesNo("Do you want to bury bones?");
    	int maxPrayerLvl = 99;
    	
    	if(prayer)
    		maxPrayerLvl = Integer.parseInt(getInput("What prayer level do you want?"));
    		
    	boolean pickup = showYesNo("Do you want to pickup any items?");
    	
    	if(pickup)
    	{
    		String[] ids = getInput("Enter the desired item ID(s) (separated by commas)").trim().split(",");
    		itemIds = new int[ids.length];
    		for(int i = 0; i < itemIds.length; i++)
    			itemIds[i] = Integer.parseInt(ids[i]);
    	}
    	
    	while(isRunning())
    	{
    		checkMode();
    		
    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
    		{
				useItem(1263);
				sleep(random(800, 1200));
    		}
    		
			while(isSleeping() && isRunning())
				sleep(random(500, 1000));

			while(inCombat())
			{
				checkMode();
				att = true;
				sleep(random(1000, 1200));
			}
			
    		int idx = fightStyle == 0 ? getNpcByAttackable() : getNpcIndexById(npcIds);
    		if(idx != -1)
    		{
    			if(distanceTo(getNpcX(idx), getNpcY(idx)) > 0)
    			{
    				if(att)
    					attackNpc(idx);
    				else
    					walkTo(getNpcX(idx), getNpcY(idx));
    					
    				att = !att;
    				sleep(800, 1200);
    			} else
    			{
    				attackNpc(idx);
    				sleep(800, 1200);
    			}
    		} else
    		{
    			if(prayer)
    			{
	    			if(getInvCount() < 30)
					{
						int[] bones = getItemById(new int[]{20,413,604,814});
						
						if(bones[0] != -1)
						{
							if(distanceTo(bones[1] + getAreaX(), bones[2] + getAreaY()) > 0)
								walkTo(bones[1] + getAreaX(), bones[2] + getAreaY());
							else
								take(bones);
							
							sleep(400, 800);
						} else
							sleep(300, 600);
					} else
					{
						while(countItem(20) > 0 && isRunning())
						{
							while(getFatigue() >= 90 && isRunning() && !isSleeping())
				    		{
								useItem(1263);
								sleep(random(800, 1200));
				    		}
				    		
							while(isSleeping() && isRunning())
								sleep(random(500, 1000));
								
							if(getMaxStat(5) >= maxPrayerLvl)
								exit("40 prayer reached.");
								
							useItem(20);
							
							if(countItem(20) < 4)
								sleep(1000, 2000);
							else
								sleep(800, 1200);
						}
					}
					
					sleep(random(250, 500));
    			}
    			
    			if(pickup)
    			{
    				if(getInvCount() < 30)
					{
						int[] item = getItemById(itemIds);
						
						if(item[0] != -1)
						{
							if(distanceTo(item[1] + getAreaX(), item[2] + getAreaY()) > 0)
								walkTo(item[1] + getAreaX(), item[2] + getAreaY());
							else
								take(item);
							
							sleep(400, 800);
						} else
							sleep(300, 600);
					}
    			}
    			
    			if(!prayer && !pickup)
    				sleep(800, 1200);
    		}
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
    
    public void getInfo()
    {
    	String[] info = new String[]
    	{
    		"This script will fight ANY attackable NPC in your area."
    	};
    	
    	displayInfoBox("Fighter", info);
    }
}