import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Mine extends Commands
{
    public Mine(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	int mineStyle = showOptions("What do you want to mine?", new String[]{"Iron", "Copper/tin"});
    	boolean bank = showYesNo("Do you want to bank your ores?");
    	
    	if(getX() >= 328 && getY() >= 549 && getX() <= 334 && getY() <= 557)
    		walkToMine();
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 || !bank && isRunning())
    		{
	    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
	
				if(mineStyle == 0)
				{
					int rockId = getNearestObjectById(103);
					
					if(rockId != -1)
					{
						atObject(getObjectX(rockId), getObjectY(rockId));
						sleep(800, 1200);
					} else
						sleep(400, 800);
				} else
				if(mineStyle == 1)
				{
					if(countItem(202) < 14 || !bank)
	    			{
	    				if(getObjectId(362, 550) != 98)
	    				{
	    					atObject(362, 550);
	    					sleep(800, 1200);
	    				}
	    			}
	    			
	    			if(countItem(150) < 14 || !bank)
	    			{
	    				if(getObjectId(361, 549) != 98)
	    				{
	    					atObject(361, 549);
	    					sleep(800, 1200);
	    				}
	    			}
				}
    		}
    		
    		if(bank)
    		{
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
	    		walkToWait(322, 526);
	    		walkToWait(323, 537);
	    		walkToWait(326, 548);
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
	    			while(countItem(151) > 0 && isRunning()) // Iron
	    			{
	    				deposit(151, countItem(151));
	    				sleep(1500, 2000);
	    			}
	    			
	    			while(countItem(202) > 0 && isRunning()) // Tin
	    			{
	    				deposit(202, countItem(202));
	    				sleep(1500, 2000);
	    			}
	    			
	    			while(countItem(150) > 0 && isRunning()) // Copper
	    			{
	    				deposit(150, countItem(150));
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
}