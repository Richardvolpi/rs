import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Magic extends Commands
{
	private final int MAX_LEVEL = 20;
	
    public Magic(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		if(getMaxStat(6) >= MAX_LEVEL)
    			exit("Max level " + MAX_LEVEL + " reached.");
    		
    		if(getFatigue() <= 90)
    		{
    			int npc = getNpcByAttackable();
    			
    			if(npc != -1)
    			{
    				castOnNpc(0, npc);
    				sleep(1300, 1400);
    			} else
    				sleep(100, 500);
    		} else
    		{
    			while(!isSleeping() && isRunning())
    			{
    				atObject(214, 2583);
    				sleep(4000, 5000);
    			}
    			
    			while(isSleeping() && isRunning())
    				sleep(100, 200);
    		}
    	}
    }
}