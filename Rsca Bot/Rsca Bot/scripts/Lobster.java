import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Lobster extends Commands
{
    public Lobster(mudclient client) 
    {
    	super(client);
    }
    
    public void start(String[] args)
    {
    	final int objectX = 370;
    	final int objectY = 678;
    	int loops = 0;
    	
    	System.out.println("Lobster script started (" + objectX + "," + objectY + ").");
    	
    	while(isRunning())
    	{
    		while(getInvCount() < 30 && isRunning())
			{
	    		if(getObjectIndex(objectX, objectY) != -1)
	    		{
	    			setAutologin(true); // It's safe to autologin
	    			atObject2(objectX, objectY);
	    			sleep(800, 1200);
	    		} else
	    		{
	    			setAutologin(false); // Be careful, object is missing.
	    			sleep(500, 1000);
	    		}
	    		
	    		while(getFatigue() >= 90 && isRunning() && !isSleeping())
	    		{
					useItem(1263);
					sleep(random(800, 1200));
	    		}
	    		
				while(isSleeping() && isRunning())
					sleep(random(500, 1000));
					
				scan();
			}
			
			walkToWait(370, 687);
			walkToWait(365, 700);
			walkToWait(355, 706);
			walkToWait(346, 709);
			walkToWait(338, 713);
			walkToWait(333, 713);
			
			scan();
			
			while(!inQuestMenu() && isRunning())
			{
				int npc = getNpcIndexById(163);
				
				if(npc == -1) // This would be very bad.
				{
					setAutologin(false);
					sleep(600, 1200);
				} else
				{
					talkToNpc(npc);
					sleep(2000, 3500);
				}
			}
			
			int choice = random(1, 2);
			sendQuestMenuReply(choice == 1 ? "Ardougne" : "Catherby");
			
			if(choice == 1) // Ardougne
			{
				setAutologin(false);
				while(getX() < 500 && isRunning()) // Wait for the ship to tele us
					sleep(500, 1200);
					
				setAutologin(true);
				
				walkToWait(544, 614);
				walkToWait(548, 613);
				
				while(getObjectIndex(550, 612) == -1 && isRunning()) // this would be very bad.
				{
					setAutologin(false);
					sleep(500, 1000);
				}
				
				while(getObjectId(550, 612) != 63 && isRunning())
				{
					atObject(550, 612);
					sleep(1500, 2000);
				}
				
				walkToWait(551, 613);
				
				bank();
				
				while(getObjectIndex(550, 612) == -1 && isRunning()) // this would be very bad.
				{
					setAutologin(false);
					sleep(500, 1000);
				}
				
				while(getObjectId(550, 612) != 63 && isRunning())
				{
					atObject(550, 612);
					sleep(1500, 2000);
				}
				
				walkToWait(545, 614);
				
				while(!inQuestMenu() && isRunning())
				{
					int npc = getNpcIndexById(316);
					
					if(npc == -1) // This would be very bad.
					{
						setAutologin(false);
						sleep(600, 1200);
					} else
					{
						talkToNpc(npc);
						sleep(3000, 4500);
					}
				}
				
				sendQuestMenuReply("Karamja");
			} else // Catherby
			{
				setAutologin(false);
				while(getX() < 400 && isRunning()) // Wait for the ship to tele us
					sleep(500, 1200);
					
				setAutologin(true);
				
				walkToWait(439, 500);
				
				while(getObjectIndex(439, 497) == -1 && isRunning()) // this would be very bad.
				{
					setAutologin(false);
					sleep(500, 1000);
				}
				
				while(getObjectId(439, 497) != 63 && isRunning())
				{
					atObject(439, 497);
					sleep(1500, 2000);
				}
				
				walkToWait(439, 496);
				
				bank();
	    		
	    		while(getObjectIndex(439, 497) == -1 && isRunning()) // this would be very bad.
				{
					setAutologin(false);
					sleep(500, 1000);
				}
				
				while(getObjectId(439, 497) != 63 && isRunning())
				{
					atObject(439, 497);
					sleep(1500, 2000);
				}
				
				walkToWait(439, 500);
				
				while(!inQuestMenu() && isRunning())
				{
					int npc = getNpcIndexById(280);
					
					if(npc == -1) // This would be very bad.
					{
						setAutologin(false);
						sleep(600, 1200);
					} else
					{
						talkToNpc(npc);
						sleep(3000, 4500);
					}
				}
				
				sendQuestMenuReply("Karamja");
			}
			
			setAutologin(false);
			while(getX() > 350 && isRunning())
				sleep(500, 1000);
				
			setAutologin(true);
			
			scan();
			
			walkToWait(333, 713);
			walkToWait(338, 713);
			walkToWait(346, 709);
			walkToWait(355, 706);
			walkToWait(365, 700);
			walkToWait(370, 687);
			
			if(loops++ > 5)
			{
				logout(true);
				setAutologin(true);
				loops = 0;
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
			sleep(3000, 4500);
		}
		
		while(inBank() && isRunning()) // Bank lobs
		{
			while(countItem(372) > 0 && isRunning())
			{
				deposit(372, countItem(372));
				sleep(1500, 2000);
			}
			
			closeBank();
		}
    }
    
    private void scan()
    {
    	if(getPlayerCount() > 1) // if a player comes into our area, hide for a moment.
		{
			setAutologin(false);
			logout();
			int sleepTime = random(190000, 300000);
			System.out.println("Enemy spotted! Hiding for " + sleepTime + " secs.");
			sleep(sleepTime);
			setAutologin(true);
		}
    }
}