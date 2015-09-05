import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class MineSmelt extends Commands
{
    public MineSmelt(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	if(getX() >= 328 && getY() >= 549 && getX() <= 334 && getY() <= 557)
    		walkToMine();
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 && isRunning())
    		{
    			while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
					
				clearGems();
    			
    			if(countItem(202) < 14)
    			{
    				if(getObjectId(362, 550) != 98)
    				{
    					atObject(362, 550);
    					sleep(800, 1200);
    				}
    			}
    			
    			if(countItem(150) < 14)
    			{
    				if(getObjectId(361, 549) != 98)
    				{
    					atObject(361, 549);
    					sleep(800, 1200);
    				}
    			}
    			
    			sleep(400, 600);
    		}
    		
    		walkToWait(357, 540);
    		walkToWait(366, 530);
    		walkToWait(363, 517);
    		walkToWait(353, 508);
    		walkToWait(346, 495);
    		walkToWait(342, 488);
    		
    		while(getX() >= 342 && isRunning())
    		{
    			atObject(341, 487);
    			sleep(800, 1200);
    		}
    		
    		walkToWait(337, 491);
    		walkToWait(331, 501);
    		walkToWait(318, 511);
    		walkToWait(314, 524);
    		walkToWait(314, 536);
    		walkToWait(309, 542);
    		
    		while(getX() != 310 && getY() != 545)
			{
			  	while(getDoorId(309, 543) != 1)
			  	{
			  		atDoor(309, 543);
			  		sleep(1000, 1500);
				}
				
				walkTo(310, 545);
				sleep(800, 1200);
			}
			
			while(hasItem(150) && isRunning()) // smelt
			{
				while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
					
				useOnObject(getSlot(150), 310, 546);
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
    			while(countItem(169) > 0 && isRunning()) // Coal
    			{
    				deposit(169, countItem(169));
    				sleep(1500, 2000);
    			}
    			
    			while(countItem(160) > 0 && isRunning()) // Sap
    			{
    				deposit(160, countItem(160));
    				sleep(1500, 2000);
    			}
    			
    			while(countItem(159) > 0 && isRunning()) // Em
    			{
    				deposit(159, countItem(159));
    				sleep(1500, 2000);
    			}
    			
    			while(countItem(158) > 0 && isRunning()) // Ruby
    			{
    				deposit(158, countItem(158));
    				sleep(1500, 2000);
    			}
    			
    			while(countItem(157) > 0 && isRunning()) // Diam
    			{
    				deposit(157, countItem(157));
    				sleep(1500, 2000);
    			}
    			
    			while(countItem(542) > 0 && isRunning()) // Dragon stone
    			{
    				deposit(542, countItem(542));
    				sleep(1500, 2000);
    			}
    			
    			closeBank();
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
			
			walkToMine();
    	}
    }
    
    private void walkToMine()
    {
    	walkToWait(326, 542);
		walkToWait(323, 527);
		walkToWait(335, 499);
		walkToWait(341, 488);
		
		while(getX() <= 341 && isRunning())
		{
			atObject(341, 487);
			sleep(1000, 1500);
		}
		
		walkToWait(344, 493);
		walkToWait(354, 507);
		walkToWait(365, 517);
		walkToWait(366, 533);
		walkToWait(359, 544);
		walkToWait(361, 550);
    }
    
    /**
     * 157 - diam
     * 158 - ruby
     * 159 - em
     * 160 - sap
     * 542 - drag
     */
    private void clearGems()
    {
    	while(isRunning() && hasItem(157) || hasItem(158) || hasItem(159) || hasItem(160) || hasItem(542))
    	{
    		if(hasItem(157))
    		{
    			dropItem(157);
    			sleep(1000, 1500);
    		} else
    		if(hasItem(158))
    		{
    			dropItem(158);
    			sleep(1000, 1500);
    		} else
    		if(hasItem(159))
    		{
    			dropItem(159);
    			sleep(1000, 1500);
    		} else
    		if(hasItem(160))
    		{
    			dropItem(160);
    			sleep(1000, 1500);
    		} else
    		if(hasItem(542))
    		{
    			dropItem(542);
    			sleep(1000, 1500);
    		}
    	}
    }
}