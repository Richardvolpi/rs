
public class cc extends Macro {
    
    public cc(slave rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"cc"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /cc, autocatchs last player"};
    }
    public void start(String command, String arg[]) {
	System.err.println("Rp's Autocatch Activated");
	long lastfight = -1;

            System.err.println("Player: " + PlayerRemembered());
            debugG("Ready to own that nig " + PlayerRemembered() + " up?");
            while(rs.Macro){
            wait(50);
            try{
                if((getMaxLevel(3) - getCurrentLevel(3)) > 32) {
		    while(inCombat()){
			WalkTo(myX(),myY());
			wait(600);
		    }
		    if(FindInv(373) != -1)
			UseItem(FindInv(373));
		    else
			{
			debugG("no lobsters!");
			debugG("Run NIGGA!");
			rs.Macro = false;
			}
		    wait(200);
                }
                
                String LastPlayer = PlayerRemembered();
                int end = -1;
                
                for(int g = 0; g < PlayerCount(); g++)
                {
                	if(PlayerName(g).equalsIgnoreCase(LastPlayer))
                		end = g;
                }
                
                if(end == -1)
                {
                	debugG("Player: " + LastPlayer + " not found!");
                	return;
                }
                

                int lpdist = PathLength(myX(),myY(),PlayerX(end), PlayerY(end));
                
                while(inCombat())
                {
                
                	lastfight = System.currentTimeMillis();
                	wait(50);
                	if((getMaxLevel(3) - getCurrentLevel(3)) > 32) {
					    while(inCombat()){
						WalkTo(myX(),myY());
						wait(600);
					    }
					    if(FindInv(373) != -1)
						UseItem(FindInv(373));
					    else
						{
						debugG("no lobsters!");
						debugG("Run NIGGA!");
						rs.Macro = false;
						}
					    wait(200);
                	}
               	}
                	
                long timesincelast;
                if(lastfight != -1)
                timesincelast = System.currentTimeMillis() - lastfight;
                else
                timesincelast = 3000;
                
                if(!inCombat() && lpdist <= 2 && !PlayerHPbar(end) && timesincelast >= 3000)
                {
                	for(int a = 0; a < 3; a++)
                	{
			AttackPlayer(end);
			wait(380 + random(30,60));
			}
		}
		else
                {
                	if(!inCombat())
                	{
                		if(isWalking())
                			wait(10);
				WalkTo(PlayerDestX1(end),PlayerDestY1(end));
                		wait(477);
                	}
                }
                

                }catch(Exception g){ g.printStackTrace(); }
            }
        
        
    }
}

