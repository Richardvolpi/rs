import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Fatigue extends Commands
{
    public Fatigue(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		while(getFatigue() < 100 && isRunning())
    		{
    			int tree = getNearestObjectById(new int[]{0,1});
    			atObject(getObjectX(tree), getObjectY(tree));
    			sleep(800, 1200);
    		}
    	}
    }
}