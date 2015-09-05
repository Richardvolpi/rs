import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class ModScanner extends Commands
{
	private String[] response1 = new String[]
	{
		"Fucking hate my dad. one sec",
		"Hey man",
		"Hey dude, what's doing",
		"hey thurr my fuzzy little man peach",
		"come to have a beer with me?",
		"whatever it is, i didn't do it."
	};
	
	private String[] response2 = new String[]
	{
		"one minute %mod%, lagging hardcore",
		"fucking lag!",
		"ffs lag..",
		"so, mr mod man, can you fix the lag?",
		"just a warning, i dc alot lol, so dont just ban me if i do",
		"please dont ban me if i dc like the other mods do"
	};
	
	private String[] modroom1 = new String[]
	{
		"come on man, i'm here...",
		"dude i responded to you",
		"lol sweet, jailed",
		"i need a screenshot this haha",
		"what do i need to do to prove i'm not autoing?",
		"dude, put me back please??"
	};
	
	private String[] modroom2 = new String[]
	{
		"i was just about to leave bro",
		"whatever man, clearly i'm not autoing..",
		"what is this, an interrogation?",
		"im not evn smart enough to no how to auto!",
		"can i hav a beer from the bar?",
		"can i at least come out of this cage?"
	};
	
	private String[] modroom3 = new String[]
	{
		"sorry mate but i really gotta go",
		"oh shit man i gtg, dad's home",
		"fuck sorry, mum's home im not sposed to be on",
		"lol gtg my gf's here, im dead if she sees me playing this shit",
		"oh fuck,brb. someones home",
		"shit someones home, im supposed to be in bed sick lol"
	};
	
    public ModScanner(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	int errors = 0;

    	while(isRunning())
    	{
    		if(inModRoom())
    		{
    			getFrame().toFront();
		    	org.rscdaemon.client.util.Audio.loop("mod_detected.wav");
		    				
    			getScriptManager().stopAllScriptsExcept(this.getClass().getName());
    			System.out.println("IN MOD ROOM!");
    			display("@red@IN MOD ROOM!");
    			
    			int sq = random(1, 2);
    			
    			sleep(1000, 2000);
    			if(sq == 1)
    				walkTo(random(77, 79), random(1642, 1643));
    			else
    				walkTo(random(78, 80), random(1641, 1642));
    			
    			sleep(5000, 8000);
    			say(modroom1[random(0, modroom1.length-1)]);
    			sleep(15000, 18000);
    			say(modroom2[random(0, modroom2.length-1)]);
    			sleep(20000, 22000);
    			say(modroom3[random(0, modroom3.length-1)]);
    			sleep(10000, 12000);
    			exit("Man, you were in mod room way too long.");
    		} else
    		if(getPlayerCount() > 1)
    		{
	    		for(int i = 0; i < getPlayerCount(); i++)
	    		{
	    			if(getPlayer(i).serverIndex == getOurPlayer().serverIndex)
	    				continue;
	    			
	    			try
	    			{
		    			if(getPlayer(i).admin >= 1) // mod and above
		    			{
		    				getScriptManager().stopAllScriptsExcept(this.getClass().getName());
		    				System.out.println("Mod found: " + getPlayer(i).name);
		    				getFrame().toFront();
		    				org.rscdaemon.client.util.Audio.loop("mod_detected.wav");
		    				sleep(random(10000, 12000));
		    				
		    				if(!isRunning())
		    					return;
		    					
		    				if(inModRoom())
		    					continue;
		    				
		    				say(response1[random(0, response1.length-1)]);
		    				sleep(random(10000, 12000));
		    				say(response2[random(0, response2.length-1)].replaceAll("%mod%", getPlayer(i).name));
		    				sleep(random(10000, 12000));
		    				
		    				if(!isRunning() || inModRoom())
		    					continue;
		    				
		    				exit("You were too late to take manual control!");
		    			}
	    			} catch(Exception e)
	    			{
	    				errors++;
	    				e.printStackTrace();
	    				
	    				if(errors >= 12)
	    					exit("Too many errors! (" + errors + ")");
	    			}
	    		}
    		}
    		
    		sleep(100);
    	}
    }
    
    public void stop()
    {
    	org.rscdaemon.client.util.Audio.stopAll();
    }
    
    private boolean inModRoom()
    {
    	return getX() >= 64 && getY() >= 1639 && getX() <= 80 && getY() <= 1643;
    }
}