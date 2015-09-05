import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Fletcher extends Commands
{
	private final int SLEEPING_BAG_ID = 1263;
	private final int TREE_IDS[] = new int[] { 0, 1 };
	private final int KNIFE_ID = 13;
	private final int LOG_ID = 14;
	private final int SHAFT_ID = 280;
	
    public Fletcher(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	long lastUse = 0L;
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 && isRunning())
    		{
    			while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(SLEEPING_BAG_ID);
					sleep(800, 1200);
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(500, 1000);
					
				int tree = getNearestObjectById(TREE_IDS);
    			atObject(getObjectX(tree), getObjectY(tree));
    			sleep(800, 1200);
    		}
    		
    		while(hasItem(LOG_ID) && isRunning())
    		{
    			while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(SLEEPING_BAG_ID);
					sleep(800, 1200);
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(500, 1000);
				
    			if(!inQuestMenu() && System.currentTimeMillis() - lastUse >= random(1000, 1100))
    			{
    				useItemOnItem(KNIFE_ID, LOG_ID);
    				lastUse = System.currentTimeMillis();
    			}
    			
    			if(inQuestMenu())
    			{
    				sendQuestMenuReply(0);
    				sleep(100, 250);
    				lastUse = 0L;
    			} else
    				sleep(10, 50);
    		}
    	}
    }
}