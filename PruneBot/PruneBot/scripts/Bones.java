import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Bones extends Commands
{
    public Bones(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{	
			while(getInvCount() < 30 && isRunning())
			{
				int[] bones = getItemById(20);
				
				if(bones[0] != -1)
				{
					if(distanceTo(bones[1] + getAreaX(), bones[2] + getAreaY()) > 0)
						walkTo(bones[1] + getAreaX(), bones[2] + getAreaY());
					else
						take(bones);
					
					sleep(500, 1000);
				} else
					sleep(300, 600);
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
					
				if(getMaxStat(5) >= 40)
					exit("40 prayer reached.");
					
				useItem(20);
				
				if(countItem(20) < 4)
					sleep(1000, 2000);
				else
					sleep(800, 1200);
			}
    	}
    }
}