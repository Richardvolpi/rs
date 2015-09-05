import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Shrimp extends Commands
{
	private static final int MAX_PLAYER_RADIUS = 10;
	
    public Shrimp(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	final int objectX = 311;
    	final int objectY = 686;
    	int loops = 0;
    	
    	System.out.println("Shrimp script started (" + objectX + "," + objectY + ").");
    	
    	while(isRunning())
    	{
			while(getInvCount() < 30 && isRunning())
			{
	    		if(getObjectIndex(objectX, objectY) != -1)
	    		{
	    			setAutologin(true); // It's safe to autologin
	    			atObject(objectX, objectY);
	    			sleep(800, 1200);
	    		} else
	    		{
	    			setAutologin(false); // Be careful, object is missing.
	    			sleep(500, 1000);
	    		}
	    		
	    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
					
				//scan();
			}
			
			while(countItem(349) > 0 || countItem(351) > 0 && isRunning())
			{
				//scan();
    		
				int fireIdx = getNearestObjectById(97);
				
				if(fireIdx != -1)
					if(distanceTo(getObjectX(fireIdx), getObjectY(fireIdx), objectX, objectY) > 10)
						fireIdx = -1;
				
				while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
				
				if(fireIdx == -1)
				{
					fireIdx = getNearestObjectById(97);
					
					if(distanceTo(getObjectX(fireIdx), getObjectY(fireIdx), objectX, objectY) > 10)
						fireIdx = -1;
					
					int[] item = getItemById(14);
					
					if(item[0] == -1 || (distanceTo(item[1] + getAreaX(), item[2] + getAreaY(), objectX, objectY) > 10))
					{
						int treeIdx = getNearestObjectById(new int[]{0,1});
						
						item = getItemById(14);
						if(distanceTo(item[1] + getAreaX(), item[2] + getAreaY(), objectX, objectY) > 10)
							item[0] = -1;
						
						if(treeIdx == -1)
						{
							setAutologin(false);
							sleep(500, 800);
						}
						
						setAutologin(true);
						atObject(getObjectX(treeIdx), getObjectY(treeIdx));
						sleep(2000, 3000);
					} else
					{
						useItemGround(getSlot(166), item);
						sleep(2000, 3000);
					}
				} else
				{
					useOnObject(getSlot(countItem(349) > 0 ? 349 : 351), getObjectX(fireIdx), getObjectY(fireIdx));
					sleep(800, 1200);
				}
			}
			
			atObject(objectX, objectY);
			
			// drop cooked shrimp
			while(countItem(350) > 0 && isRunning())
			{
				//scan();
				dropItem(350);
				
				if(getInvCount() > 3)
					sleep(300, 800);
				else
					sleep(1000, 1500);
			}
			
			// drop cooked anchovies
			while(countItem(352) > 0 && isRunning())
			{
				//scan();
				dropItem(352);
				sleep(300, 800);
				
				if(getInvCount() > 3)
					sleep(300, 800);
				else
					sleep(1000, 1500);
			}
			
			// drop burnt fish
			while(countItem(353) > 0 && isRunning())
			{
				//scan();
				dropItem(353);
				sleep(300, 800);
				
				if(getInvCount() > 3)
					sleep(300, 800);
				else
					sleep(1000, 1500);
			}
			
			if(loops++ > 5)
			{
				loops = 0;
				logout(true); // clear potential suspicion
				setAutologin(true);
			}
    	}
    }
    
    private void scan()
    {
    	if(getPlayerCount() > 1) // if a player comes into our area, hide for a moment.
		{
			for(int i = 0; i < getPlayerCount(); i++)
			{
				if(getPlayer(i) == getOurPlayer())
					continue;
				
				if(distanceTo(getPlayerX(i), getPlayerY(i)) < MAX_PLAYER_RADIUS)
				{
					System.out.println(getPlayer(i).name + " dist (" + distanceTo(getPlayerX(i), getPlayerY(i)) + ")");
					
					setAutologin(false);
					logout();
					int sleepTime = random(190000, 300000);
					System.out.println("Enemy spotted! Hiding for " + sleepTime + " secs.");
					sleep(sleepTime);
					setAutologin(true);
				}
			}
		}
    }
}