import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Catherby extends Commands
{
	private float version = 1.1F;
	
    public Catherby(mudclient client)
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	int loops = 0;
    	
    	int type = showOptions("What do you want to fish?", new String[]{"Lobs","Sharks"});
    	boolean cook = showYesNo("Do you want to cook your " + (type == 0 ? "Lobsters" : "Sharks") + "?");
    	
    	final int objectX = type == 0 ? 409 : 398;
    	final int objectY = type == 0 ? 504 : 505;
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 && isRunning())
			{
	    		if(getObjectIndex(objectX, objectY) != -1)
	    		{
	    			setAutologin(true); // It's safe to autologin
	    			atObject2(objectX, objectY);
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
			}
			
			setAutologin(false);
			
			if(cook)
			{
				if(type == 0)
				{
					walkToWait(415, 499);
					walkToWait(421, 497);
					walkToWait(431, 490);
				} else
				{
					walkToWait(401, 497);
					walkToWait(415, 484);
					walkToWait(424, 484);
					walkToWait(430, 486);
				}
				
				walkToWait(435, 486);
				
				while (getDoorId(435, 486) != 1 && isRunning()) {
					atDoor(435, 486);
					sleep(random(1200, 1500));
				}
				
				while(countItem(type == 0 ? 372 : 545) > 0 && isRunning())
				{
					while(getFatigue() >= 90 && isRunning() && !isSleeping())
		    			{
						useItem(1263);
						sleep(random(800, 1200));
		    			}
		    		
					while(isSleeping() && isRunning())
						sleep(random(500, 1000));
						
					useOnObject(type == 0 ? getSlot(372) : getSlot(545), 432, 480);
	    				sleep(500, 1000);
				}
				
				while (countItem(374) > 0 && isRunning()) {
					dropItem(374);
					sleep(random(1200, 1500));
				}
				
				while(countItem(547) > 0 && isRunning())
				{
					dropItem(547);
					
					if(countItem(547) > 3)
						sleep(400, 1000);
					else
						sleep(800, 1500);
				}
					
				while (getDoorId(435, 486) != 1 && isRunning()) {
					atDoor(435, 486);
					sleep(random(1200, 1500));
				}
				
				walkToWait(436, 492);
				walkToWait(439, 497);
			} else
			{
				walkToWait(409, 503);
				walkToWait(417, 499);
				walkToWait(427, 498);
				walkToWait(439, 497);
			}
			
			while(getX() != 439 && getY() != 496)
			{
				while(getObjectId(439, 497) != 63 && isRunning())
				{
					atObject(439, 497);
					sleep(1500, 2000);
				}
				
				walkTo(439, 496);
				sleep(800, 1200);
			}
			
			while(!inBank() && isRunning()) // Open bank
			{
				int banker = getNpcIndexById(95);
				
				if(banker == -1)
					exit("Banker can't be found lol");
					
				talkToNpc(banker);
				sleep(3000, 4500);
			}
			
			while(inBank() && isRunning()) // Bank sharkies
			{
				while(countItem(546) > 0 && isRunning())
				{
					deposit(546, countItem(546));
					sleep(1500, 2000);
				}
				
				while(countItem(373) > 0 && isRunning())
				{
					deposit(373, countItem(373));
					sleep(1500, 2000);
				}
				
				while(countItem(545) > 0 && isRunning())
				{
					deposit(545, countItem(545));
					sleep(1500, 2000);
				}
				
				while(countItem(372) > 0 && isRunning())
				{
					deposit(372, countItem(372));
					sleep(1500, 2000);
				}
				
				closeBank();
			}
			
			while(getX() != 439 && getY() != 497)
			{
				while(getObjectId(439, 497) != 63 && isRunning())
				{
					atObject(439, 497);
					sleep(1500, 2000);
				}
				
				walkTo(439, 497);
				sleep(800, 1200);
			}
			
			walkToWait(430, 498);
			walkToWait(422, 499);
			walkToWait(409, 503);
			
			if(type == 1)
				walkToWait(399, 505);
    	}
    }
    
    private void bank()
    {
    	
    }
    
    private void scan()
    {
    	if(getPlayerCount() > 1) // if a player comes into our area, hide for a moment.
		{
			setAutologin(false);
			logout();
			int sleepTime = random(190000, 300000);
			System.out.println("Enemy spotted! Hiding for " + sleepTime + " secs.");
			sleep(sleepTime);
			setAutologin(true);
		}
    }
    
    public void getInfo()
    {
    	String[] info = new String[]
    	{
    		"This script runs at catherby.",
    		"",
    		"You specify what to fish and whether to cook it."
    	};
    	
    	displayInfoBox("Catherby script v" + version, info);
    }
}