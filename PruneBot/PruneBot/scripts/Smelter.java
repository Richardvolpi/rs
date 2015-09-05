import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Smelter extends Commands
{
    public Smelter(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	display("Steel smelter");
    	
    	while(isRunning())
    	{
    		while(countItem(155) < 9 && countItem(151) < 18 && isRunning())
    		{
	    		// bank
				while(!inBank() && isRunning()) // Open bank
	    		{
	    			int banker = getNpcIndexById(95);
	    			
	    			if(banker == -1)
	    				exit("Banker can't be found lol");
	    			
	    			talkToNpc(banker);
	    			sleep(2500, 4000);
	    		}
	    		
	    		while(inBank() && isRunning()) // Bank items
	    		{
	    			if(countItem(155) < 18)
	    				withdraw(155, 18);
	    			else
	    			if(countItem(151) < 9)
	    				withdraw(151, 9);
	    			else
	    			if(countItem(155) > 18)
	    				deposit(155, 1);
	    			else
	    			if(countItem(151) > 9)
	    				deposit(151, 1);
	    			else
	    				closeBank();
	    				
	    			sleep(2000, 4000);
	    		}
    		}
    		
    		while(getX() != 327 && getY() != 552)
			{
			  	while(getObjectId(327, 552) != 63)
			  	{
			    	atObject(327, 552);
			    	sleep(1000, 1500);
			  	}
				
			  	walkTo(327, 552);
			  	sleep(800, 1200);
			}
			
			walkToWait(322, 551);
			walkToWait(314, 549);
			walkToWait(312, 544);
			
			while(getX() != 311 && getY() != 544 && isRunning())
			{
				if(getDoorId(312, 544) != 1)
					atDoor(312, 544);
				else
					walkTo(311, 544);
				
				sleep(1000, 2000);
			}
			
			while(countItem(169) > 0 && isRunning())
			{
				while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
				
				useOnObject(getSlot(169), 310, 546);
				sleep(800, 1200);
			}
			
			while(getX() != 312 && getY() != 544)
			{
			  	while(getDoorId(312, 544) != 1)
			  	{
			    	atDoor(312, 543);
			    	sleep(1000, 1500);
			  	}
				
			  	walkTo(312, 544);
			  	sleep(800, 1200);
			}
			
			walkToWait(319, 551);
			walkToWait(327, 552);
			
			while(getX() != 328 && getY() != 552)
			{
			  	while(getObjectId(327, 552) != 63)
			  	{
			    	atObject(327, 552);
			    	sleep(1000, 1500);
			  	}
				
			  	walkTo(328, 552);
			  	sleep(800, 1200);
			}
    	}
    }
}