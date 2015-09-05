import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Goblins extends Commands
{
	private int mode = 0;
	
    public Goblins(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	boolean attack = true;
    	
    	while(isRunning())
    	{
    		scan();
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
			
			if(getMaxHits() - getCurHits() >= 12)
			{
				useItem(373);
				sleep(800, 1200);
			}
			
    		int idx = getNpcByAttackable();
    		if(idx != -1)
    		{
    			if(distanceTo(getNpcX(idx), getNpcY(idx)) > 0)
    			{
    				if(attack)
    					attackNpc(idx);
    				else
    					walkTo(getNpcX(idx), getNpcY(idx));
    					
    				attack = !attack;
    			} else
    				attackNpc(idx);
    		}
    			
    		sleep(random(1000, 1200));
    	}
    }
    
    private void scan()
    {
    	if(getPlayerCount() > 1)
    	{
    		//System.out.println("Enemy spotted. logged.");
    		//logout();
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
}