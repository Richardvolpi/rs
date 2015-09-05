import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class RuneBuyer extends Commands
{
    public RuneBuyer(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		while(!inShop() && isRunning())
    		{
    			while(!inQuestMenu() && isRunning())
    			{
    				int aubury = getNpcIndexById(54);
    				
    				if(aubury == -1)
    					exit("Lost aubury!");
    					
    				walkToNpc(aubury);
    				sleep(500, 800);
    				talkToNpc(aubury);
    				sleep(3000, 4000);
    			}
    			
    			sendQuestMenuReply("yes please");
    			
    			long timeout = System.currentTimeMillis();
    			
    			while(!inShop() && System.currentTimeMillis() - timeout <= 10000)
    				sleep(100);
    		}
    		
    		if(getShopStock(35) > 0)
    		{
    			buyItem(35);
    			sleep(20, 100);
    		} else
    		if(getShopStock(33) > 0)
    		{
    			buyItem(33);
    			sleep(20, 100);
    		} else
    		if(countItem(10) <= 15)
    			exit("Outa cash bro!");
    		else
    			sleep(500, 1000);
    	}
    }
}