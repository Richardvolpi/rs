
public class alk extends Macro {
    
    public alk(slave rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"alk"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /alk fightmode"};
    }
    public void start(String command, String arg[]) {
        int startX = 51;
        int startY = 717;
        String nN = "Man";
        String nN2 = "spider";
        
            int fmode = Integer.parseInt(arg[0]);
            
            while(rs.Macro){
            try{
                try
                {
                Thread.currentThread().sleep(10);
                }
                catch(Exception g)
                {
                }
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

				if(curDist < Dist && (NpcName(g).equalsIgnoreCase(nN) || NpcName(g).equalsIgnoreCase(nN2)) && !isNpcInCombat(g) && isNpcAttackable(g)) {
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
				wait(500 + random(70,150));
			    }
			    if(!isNpcReachable(fin) && !inCombat() && getFatigue() <= 99) {

				Dist = 999;
				curDist = 999;
				int end = -1;
				for(int t = 0; t < wallObjCount(); t++) {
				    curDist = Distance(wallObjX(t),wallObjY(t));
				    System.err.println(curDist + " " + getwallObjCommand1(t));
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
                
                if(!inCombat() && !isNpcNearByName("spider") && !isNpcNearByName("Witch") && (myX() != startX || myY() != startY)) {
                    WalkTo(startX,startY);
                    wait(1300);
                }
                }
                if((getMaxLevel(3) - getMaxLevel(3)) > 12) {
                    while(inCombat()){
                        WalkTo(myX(),myY());
                        wait(600);
                    }
                    if(FindInv(373) != -1)
                        UseItem(FindInv(373));
                    else
                        debugG("no lobsters!");
                    wait(2000);
                }
                if(getFatigue() > 99){
                    
                    wait(2000);
                    if(FindInv(1263) != -1)
                        UseItem(FindInv(1263));
                    else {
                        rs.Macro = false;
                        debugG("no sleeping bag!");
                        wait(2000);
                        LogOut();
                    }
                    wait(2000);
                    int time = 28;
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
                }catch(Exception g){ g.printStackTrace(); }
            
        }
        
    }
}

