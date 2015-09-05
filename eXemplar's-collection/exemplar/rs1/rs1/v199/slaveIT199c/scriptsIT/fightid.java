
public class fightid extends Macro {
    
    public fightid(slave rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"fightid"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /fightid id fightmode healathp   Start at walkback location"};
    }
        public void kill() {
            while(loggedin()) {
            rs.autologin = false;
                LogOut();
                wait(3000);
            }
    }
    public void start(String command, String arg[]) {
    if (arg.length != 3)
    {
    rs.Macro = false;
    debugG("Incorrect argument count");
    debugG("usage: /fight npcname fightmode healathp");
    debugG("specify 0 as healat to not eat");
    }
    else
    {
    	
        int startX = myX();
        int startY = myY();
	int nN = Integer.parseInt(arg[0]);
	
	int fmode = Integer.parseInt(arg[1]);
	int hptoheal = Integer.parseInt(arg[2]);
	
            boolean healing = false;
            debugG("@cya@-@whi@Rp's autofighter@cya@-");
    	    debugG("@whi@Attacking npc: @cya@" + nN + " @whi@fmode: @cya@" + fmode + "@whi@ healing: @cya@" + healing + " @whi@healing at: @cya@" + hptoheal);
    	    debugG("@whi@Walking back to @cya@(@whi@" + startX + "@cya@,@whi@" + startY + "@cya@)@whi@ on no Npc's");
            if(hptoheal == 0)
            	healing = false;
            	else
            	healing = true;
            while(rs.Macro){
            	wait(50);
                if(getFightMode() != fmode) {
                    setFightMode(fmode);
                    wait(100);
                }
                if(!inCombat() && getFatigue() <= 99)
                {
			int Dist = 999;
			int curDist;
			int fin = -1;
			try{
			    for(int g = 0; g < NpcCount(); g++) {
				curDist = PathLength(NpcX(g), NpcY(g));
				System.err.println(curDist + " " + NpcType(g) + " " + isNpcInCombat(g) + " " + isNpcAttackable(g));
				if(curDist < Dist && NpcType(g) == nN && !isNpcInCombat(g) && isNpcAttackable(g) && isNpcReachable(g)) {
				    Dist = curDist;
				    fin = g;
				}
			    }
			}
			catch(Exception e) {
			    e.printStackTrace();
			}
			
			if(fin != -1) {
			    if(isNpcReachable(fin) && !inCombat() && getFatigue() <= 99) {
				AttackNpc(fin);
				wait(300 + random(30,60));
			    }
			    if(!isNpcReachable(fin) && !inCombat() && getFatigue() <= 99) {

				Dist = 999;
				curDist = 999;
				int end = -1;
				for(int t = 0; t < wallObjCount(); t++) {
				    curDist = Distance(wallObjX(t),wallObjY(t));
				    //System.err.println(curDist + " " + getwallObjCommand1(t));
				    if(curDist < Dist && getwallObjCommand1(t).equalsIgnoreCase("open")) {
					Dist = curDist;
					end = t;
				    }

				}
				if(end != -1) {
					wallObjCommand1(end);
					wait(1000 + random(70,150));
				}
			    }

                }
                
                if(!inCombat() && !isNpcNear(nN) && (myX() != startX || myY() != startY)) {
                    WalkTo(startX,startY);
                    wait(1300);
                }
                }

                if(getCurrentLevel(3) <= hptoheal && healing) {
                    while(inCombat()){
                        WalkTo(myX(),myY());
                        wait(600);
                    }
                    int loc = -1;
                    for(int f = 0; f < InvCount(); f++)
                    {
                    	if(itemCommand(f).equalsIgnoreCase("eat"))
                    	loc = f;
                    }
                    if(loc != -1)
                        UseItem(loc);
                    else
                    {
                        debugG("No food remaining!");
                        kill();
                    }    
                    wait(2000);
                }
                if(getFatigue() > 99){
                    
                    wait(2000);
                    if(FindInv(1263) != -1)
                        UseItem(FindInv(1263));
                    else {
                        rs.Macro = false;
                        debugG("No sleeping bag!");
                        wait(2000);
                        LogOut();
                    }
                    wait(2000);
                    int time = 20;
                    time = time * 1000;
                    int curtime = 0;
                    while(Sleeping()) {
                        wait(10);
                        curtime += 10;
                        if(!Sleeping())
                            break;
                        if(curtime >= time)
                            break;
                    }
                    
                }
            }
        }
        
    }
}

