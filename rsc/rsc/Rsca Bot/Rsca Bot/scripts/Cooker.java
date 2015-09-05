import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Cooker extends Commands
{
    public Cooker(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		bank();
    		
    		while(getX() != 225 && getY() != 444 && isRunning())
    		{
    			while(getObjectId(217, 447) != 63 && isRunning())
	    		{
	    			atObject(217, 447);
	    			sleep(1500, 2000);
	    		}
	    		
    			walkTo(225, 444);
    			sleep(1000, 1200);
    		}
    		
    		while(getY() < 1000 && isRunning())
    		{
    			while(getDoorId(225, 444) != 1 && isRunning())
	    		{
	    			atDoor(225, 444);
	    			sleep(1000, 2000);
	    		}
	    		
    			atObject(226, 439);
    			sleep(1500, 2000);
    		}
    		
    		while(countItem(372) > 0 && isRunning())
    		{
    			while(getFatigue() > 90 && isRunning())
    			{
    				atObject(226, 1386);
    				sleep(3000, 4500);
    			}
    			
    			useOnObject(getSlot(372), 222, 1385);
    			sleep(500, 1000);
    		}
    		
    		while(getY() > 1000 && isRunning())
    		{
    			atObject(226, 1383);
    			sleep(1500, 2000);
    		}
    		
    		while(getX() != 218 && getY() != 447 && isRunning())
    		{
    			while(getDoorId(225, 444) != 1 && isRunning())
	    		{
	    			atDoor(225, 444);
	    			sleep(1000, 2000);
	    		}
	    		
    			walkTo(218, 447);
    			sleep(1000, 1200);
    		}
    		
    		while(getX() != 218 && getY() != 448 && isRunning())
    		{
	    		while(getObjectId(217, 447) != 63 && isRunning())
	    		{
	    			atObject(217, 447);
	    			sleep(1500, 2000);
	    		}
	    		
	    		walkTo(218, 448);
	    		sleep(1000, 1200);
    		}
    	}
    }
    
    private void bank()
    {
    	while(!inBank() && isRunning()) // Open bank
		{
			int banker = getNpcIndexById(95);
			
			if(banker == -1)
				exit("Banker can't be found lol");
				
			talkToNpc(banker);
			sleep(2000, 3000);
		}
		
		while(inBank() && isRunning()) // Bank lobs
		{
			while(countItem(373) > 0 && isRunning()) // cook id
			{
				deposit(373, countItem(373));
				sleep(1500, 2000);
			}
			
			while(countItem(374) > 0 && isRunning()) // burnt id
			{
				deposit(374, countItem(374));
				sleep(1500, 2000);
			}
			
			if(countBank(372) < 30) // raw id
			{
				withdraw(372, countBank(372));
				sleep(1500, 2000);
			} else
			{
				while(getInvCount() < 30 && isRunning())
				{
					withdraw(372, countBank(372));
					sleep(1500, 2000);
				}
			}
			
			closeBank();
		}
    }
}