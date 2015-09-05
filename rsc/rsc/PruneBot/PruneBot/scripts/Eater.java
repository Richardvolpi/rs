import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Eater extends Commands
{
    public Eater(mudclient client) 
    {
    	super(client);
    }
    
    public boolean runStartupScripts()
    {
    	return false;
    }
    
    public Info getDisplayInfo()
    {
    	String[] info = new String[]
    	{
    		"Our hits %: " + getHitsPercent()
    	};
    	
    	return new Info(info, 35, 200);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		if(countItem(373) <= 0)
    			exit("No food left.");
    		
    		if(getMaxHits() - getCurHits() >= 12 && !inCombat() && !isSleeping())
    			useItem(373);
    		
    		sleep(random(1000, 1200));
    	}
    }
}