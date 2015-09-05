import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Keys extends Commands
{
	private final static int MIN_SLEEP = 500;
	private final static int MAX_SLEEP = 800;
	private boolean toggle = false;
	private final static int F2 = 1009;
    private final static int F3 = 1010;
    private final static int F4 = 1011;
    private final static int F5 = 1012;
    private final static int F6 = 1013;
    private final static int F7 = 1014;
	
    public Keys(mudclient client) 
    {
    	super(client);
    }
    
    public boolean runStartupScripts()
    {
    	return false;
    }
    
    public void start(String[] args)
    {
    	while(isRunning()){sleep(100);};
    }
    
    public void handleKeyPress(int key)
    {
    	switch(key)
    	{
    		case F2:
    			toggle = !toggle;
    			boolean what = toggle ? true : false;
    			setPrayer(8, what);
    			setPrayer(10, what);
    			setPrayer(11, what);
    			setPrayer(13, what);
    			display("Prayer is now " + toggle);
    			break;
    		case F3:
    			int towield = isWearing(81) ? 656 : 81;
    			wieldItem(towield);
    			break;
    	}	
    }
}