import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Thiever extends Commands
{
	private int mode = 0;
	
    public Thiever(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	
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
				walkTo(getX(), getY());
				sleep(random(1000, 1200));
			}
			
    		int idx = getNpcIndexById(11);
    		if(idx != -1)
    		{
    			if(distanceTo(getNpcX(idx), getNpcY(idx)) > 0)
    			{
    				walkTo(getNpcX(idx), getNpcY(idx));
    			} else
    				thieveNpc(idx);
    		}
    			
    		sleep(random(1000, 1200));
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
}