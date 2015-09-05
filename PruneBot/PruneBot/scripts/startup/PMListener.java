import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;
import org.rscdaemon.client.util.Audio;

public class PMListener extends Commands
{
	private long lastReply = 0L;
	private String[] reply = { "One sec dude",
							   "Hold on, brb",
							   "Just gimme a sec man",
							   "1 sec, busy",
							   "sorry man, brb",
							   "hey dude, just give me a minute"
							 };
	
	private String sender = "";
	private String msg = "";
	private boolean gotPm = false;
	
    public PMListener(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	while(isRunning())
    	{ // keep alive
    		sleep(100);
    		
    		if(gotPm)
    		{
    			sleep(5000, 8000);
    	
		    	if(System.currentTimeMillis() - lastReply >= 30000)
		    	{
		    		sendPM(sender, reply[random(0, reply.length-1)]);
		    		lastReply = System.currentTimeMillis();
		    	}
		    	
		    	gotPm = false;
    		}
    	}
    }
    
    public void handleLogin(String user, boolean login)
    {
    }
    
    public void handlePM(String sender, String msg)
    {
    	System.out.println("[PM] " + sender + ": " + msg);
    	Audio.play("pm_received.wav");
    	this.sender = sender;
    	this.msg = msg;
    	gotPm = true;
    	getFrame().toFront();
    }
}