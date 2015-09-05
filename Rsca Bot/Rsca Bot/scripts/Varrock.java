import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;
import org.rscdaemon.client.entityhandling.EntityHandler;

// Written for ZZGame RSCD.
public class Varrock extends Commands
{
	private int mode = 0;
	
    public Varrock(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	mode = getFightMode();
    	boolean att = false;
    	int npcId = 45;
    	int[] itemIds = new int[] { 11, 435, 165, 438, 436, 20 };
    	
    	while(isRunning())
    	{
    		checkMode();
    		
    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
    		{
				useItem(1263);
				sleep(random(1000, 3000));
    		}
    		
			while(isSleeping() && isRunning())
				sleep(random(500, 1000));

			while(inCombat())
			{
				checkMode();
				sleep(random(1000, 1200));
			}
			
    		int idx = getNpcIndexById(npcId);
    		if(idx != -1)
    		{
    			if(distanceTo(getNpcX(idx), getNpcY(idx)) > 0)
    			{
    				if(att)
    					attackNpc(idx);
    				else
    					walkTo(getNpcX(idx), getNpcY(idx));
    					
    				att = !att;
    			} else
    				attackNpc(idx);
    		} else
    		{
    			int[] item = getItemById(itemIds);
    			
    			if(item[0] != -1 && getInvCount() < 30)
    			{
    				take(item);
    				sleep(400, 800);
    			} else
    			{
    				for(int i = 0; i < getInvCount(); i++)
    				{
    					if(inCombat())
    						break;
    					
    					if(EntityHandler.getItemDef(getSlotId(i)).getName().indexOf("Muddy") > -1 || EntityHandler.getItemDef(getSlotId(i)).getName().indexOf("Bones") > -1)
    					{
    						useSlot(i);
    						sleep(600, 1000);
    					} else
    					if(getSlotId(i) == 447 || getSlotId(i) == 446 || getSlotId(i) == 445 || getSlotId(i) == 444 || getSlotId(i) == 448)
    					{
    						drop(i);
    						sleep(400, 500);
    					}
    				}
    			}
    		}
    			
    		sleep(random(1000, 1200));
    	}
    }
    
    private void checkMode()
    {
    	if(getFightMode() != mode)
    		setFightMode(mode);
    }
    
    public void getInfo()
    {
    	String[] info = new String[]
    	{
    		"This script was written for ZZGame RSCD.",
    		"It is to be run in Varrock dungeon, at skellies",
    		"near the red spiders/moss giant area."
    	};
    	
    	displayInfoBox("Varrock dungeon fighter", info);
    }
}