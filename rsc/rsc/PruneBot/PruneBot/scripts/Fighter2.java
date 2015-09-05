import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Fighter2 extends Commands
{
	private int mode = 0;
	
    public Fighter2(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 && isRunning())
    		{
	    		while(getItemById(20)[0] == -1 && isRunning())
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
						sleep(random(1000, 1200));
					}
					
		    		int idx = getNpcByAttackable();
		    		if(idx != -1)
		    		{
		    			if(getNpcX(idx) != 121 && getNpcY(idx) != 663)
		    			{
			    			if(distanceTo(getNpcX(idx), getNpcY(idx)) > 0)
			    			{
			    				walkTo(getNpcX(idx), getNpcY(idx));
			    			} else
			    				attackNpc(idx);
		    			}
		    		}
		    			
		    		sleep(random(1000, 1200));
	    		}
	    		
	    		int[] bones = getItemById(20);
				
				if(bones[0] != -1)
				{
					if(distanceTo(bones[1] + getAreaX(), bones[2] + getAreaY()) > 0)
						walkTo(bones[1] + getAreaX(), bones[2] + getAreaY());
					else
						take(bones[1], bones[2], 20);
					
					sleep(1200, 2000);
				}
    		}
    		
    		while(countItem(20) > 0 && isRunning())
			{
				while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
					
				if(getMaxStat(5) >= 70)
					exit("40 prayer reached.");
					
				useItem(20);
				
				if(countItem(20) < 4)
					sleep(1000, 2000);
				else
					sleep(800, 1200);
			}
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
}