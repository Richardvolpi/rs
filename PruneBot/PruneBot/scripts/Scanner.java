import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Scanner extends Commands
{
    public Scanner(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{
    		boolean dontQuit = false;
    		
			if(getPlayerCount() > 1)
			{
				for(int i = 0; i < getPlayerCount(); i++)
				{
					if(getPlayer(i) == getOurPlayer())
						continue;
						
					if(getPlayer(i).name.equals("Wicked 1"))
					{
						if(distanceTo(getPlayer(i).currentX + getAreaX(), getPlayer(i).currentY + getAreaY()) < 5)
							exit("Wicked came to close");
						else
						{
							dontQuit = true;
							continue;
						}
					}
					
					System.out.println("PLAYER SPOTTED: \"" + getPlayer(i).name + "\"");
				}
				
				if(!dontQuit)
					exit((getPlayerCount() - 1) + " players spotted.");
			}
	
			sleep(100);
	    }
    }
}