import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Coal extends Commands
{
	private final int PICKAXE_ID = 156;
	private final int SLEEPING_BAG_ID = 1263;
	private final int[] COAL_ROCK_IDS = new int[] { 110, 111 };
	private int loops = 0;
	
    public Coal(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	if(getX() >= 577 && getY() >= 572 && getX() <= 585 && getY() <= 576)
    		walkToMine();
    	
    	while(isRunning())
    	{
    		if(!hasItem(PICKAXE_ID) || !hasItem(SLEEPING_BAG_ID))
    			exit("No pickaxe or sleeping bag");
    		
    		while(getInvCount() < 30 && isRunning()) // Mine coal
    		{
	    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(SLEEPING_BAG_ID);
					sleep(800, 1200);
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(500, 1000);
	
	    		int i = getNearestObjectById(COAL_ROCK_IDS);
	    		
	    		if(i != -1)
	    		{
	    			atObject(getObjectX(i), getObjectY(i));
	    			sleep(800, 1200);
	    		} else
	    			sleep(500, 1000);
    		}
    		
    		// Walk to bank
    		walkToWait(610, 466);
    		walkToWait(612, 472);
    		walkToWait(614, 483);
    		walkToWait(614, 491);
    		walkToWait(613, 498);
    		walkToWait(617, 507);
    		walkToWait(618, 518);
    		walkToWait(615, 526);
    		walkToWait(614, 533);
    		walkToWait(609, 540);
    		walkToWait(603, 548);
    		walkToWait(598, 555);
    		walkToWait(593, 561);
    		walkToWait(589, 565);
    		
    		walkTo(random(572, 577), random(576, 585)); // bank
    		sleep(2000, 3000);
    		
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
    			while(countItem(155) > 0 && isRunning()) // Coal
    			{
    				deposit(155, countItem(155));
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
    			
    			while(countItem(542) > 0 && isRunning()) // Dragon stone (doesnt exist i dont think)
    			{
    				deposit(542, countItem(542));
    				sleep(1500, 2000);
    			}
    			
    			closeBank();
    		}
    		
    		// Walk to mine
    		walkToMine();	
    			
    		if(loops++ > 5)
    		{
    			logout(true);
    			setAutologin(true);
    			loops = 0;
    		}
    	}
    }
    
    private void walkToMine()
    {
    	walkToWait(589, 565);
		walkToWait(593, 561);
		walkToWait(598, 555);
		walkToWait(603, 548);
		walkToWait(609, 540);
		walkToWait(614, 533);
		walkToWait(615, 526);
		walkToWait(618, 518);
		walkToWait(617, 507);
		walkToWait(613, 498);
		walkToWait(614, 491);
		walkToWait(614, 483);
		walkToWait(612, 472);
		walkToWait(610, 466);
    }
    
    public void getInfo()
    {
    	String[] info = new String[]
    	{
    		"This script runs at the Digsite Quest coal mines",
    		"north of the Ardougne bank, near the fishing guild.",
    		"Or you can start it in the bank and it will walk there for you.",
    		"",
    		"It mines, banks and repeats."
    	};
    	
    	displayInfoBox("Coal miner", info);
    }
}