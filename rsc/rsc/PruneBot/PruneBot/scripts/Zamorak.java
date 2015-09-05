import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Zamorak extends Commands
{
	private int mode = 0;
	
    public Zamorak(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	boolean recharge = true;
    	boolean attack = false;
    	
    	while(isRunning())
    	{
    		while(getCurPrayer() > 10 && isRunning() && !recharge)
    		{
	    		checkMode();
	    		
	    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
				
				if(!isPrayerOn(10)) // str
				{
					setPrayer(10, true);
					sleep(600, 1000);
				}
				
				if(!isPrayerOn(11)) // att
				{
					setPrayer(11, true);
					sleep(600, 1000);
				}
				
				if(!isPrayerOn(12)) // paralyze
				{
					setPrayer(12, true);
					sleep(600, 1000);
				}
				
				while(inCombat() && isRunning())
				{
					checkMode();
					sleep(random(500, 800));
				}
				
	    		int idx = getNpcIndexById(new int[]{139,140});
	    		if(idx != -1 && distanceTo(getNpcX(idx), getNpcY(idx), 700, 650) <= 9)
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
	    		} else
	    			recharge = true;
	    			
	    		sleep(random(600, 1200));
    		}
    		
    		while(getCurPrayer() <= 10 || recharge && isRunning())
    		{
    			atObject(699, 650);
    			sleep(1000, 2000);
    			recharge = false;
    		}
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
}