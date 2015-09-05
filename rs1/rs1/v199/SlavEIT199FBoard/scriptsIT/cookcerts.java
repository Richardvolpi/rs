
public class cookcerts extends Macro {
    
    public cookcerts(slave rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"cookcerts"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /cookcerts, Start with tinder, rune axe, certs and bag"};
    }
    public void kill() {
        while(loggedin()) {
            LogOut();
            wait(3000);
        }
    }
    public void start(String command) {
        while(rs.Macro) {
            wait(10);
            try{
                if((InvCount(FindInv("tinderbox"))==-1) || (InvCount(FindInv("rune Axe")) == -1) || (InvCount(FindInv("Sleeping Bag")) == -1) || (InvCount(FindInv("Lobster certificate")) == -1) || (InvCount(FindInv("Raw lobster certificate")) == -1))
                    kill();
                if(getFatigue() == 100) {
                    wait(2000);
                    if(FindInv(1263) != -1)
                        UseItem(FindInv(1263));
                    else {
                        rs.Macro = false;
                        System.err.println("no sleeping bag!");
                        kill();
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
                if(InvCount()==5) {
                    while(!isQuestMenu()) {
                        TalkNearest(227);
                        wait(2400);
                    }
                    wait(1000);
                    if(isQuestMenu()) {
                        Answer(0);
                        WaitForQuestMenu(3000);
                        Answer(3);
                        WaitForQuestMenu(3000);
                        Answer(4);
                        wait(1000 + random(120,190));
                    }
                }
                if(InvCount(373) == 25) {
                    while(!isQuestMenu()) {
                        TalkNearest(227);
                        wait(2300);
                    }
                    wait(1000);
                    if(isQuestMenu()) {
                        Answer(1);
                        WaitForQuestMenu(3000);
                        Answer(0);
                        WaitForQuestMenu(3000);
                        Answer(4);
                        wait(1000 + random(120,190));
                    }
                }
                if(InvCount(372) > 0 && getFatigue() < 100) {
                    int fire = getNearestObject(97);
                    if(fire != -1) {
                        int x = ObjX(fire);
                        int y = ObjY(fire);
                        
                        int Dist = Distance(x,y);
                        if(Dist <= 5 && fire != -1) {
                            UseItemWithObject(getNearestObject(97),FindInv(372));
                            wait(400 + random(120,190));
                        }
                    }
                    else if(getNearestObject(70) != -1) {
                        int tree = getNearestObject(70);
                        if(tree != -1) {
                            int x = ObjX(tree);
                            int y = ObjY(tree);
                            ObjCmd2(x,y);
                            wait(400 + random(120,190));
                        }
                    }
                    
                    int logs = getNearestItem(14);
                    int Dist;
                    if(logs != -1) {
                        Dist = Distance(groundItemX(getNearestItem(14)),groundItemY(getNearestItem(14)));
                        
                        if(Dist < 4) {
                            UseItemwithGroundItem(logs, FindInv("tinderbox"));
                            wait(1000);
                        }
                    }
                    if(getNearestObject(97) == -1 || Distance(ObjX(getNearestObject(97)),ObjY(getNearestObject(97))) > 5) {
                        logs = getNearestItem(14);
                        Dist = Distance(groundItemX(getNearestItem(14)),groundItemY(getNearestItem(14)));
                        
                        if(Dist < 4) {
                            UseItemwithGroundItem(logs, FindInv("tinderbox"));
                            wait(400 + random(120,190));
                        }
                        else {
                            int tree = getNearestObject(70);
                            if(tree != -1) {
                                int x = ObjX(tree);
                                int y = ObjY(tree);
                                ObjCmd2(x,y);
                                wait(1000 + random(120,190));
                            }
                        }
                    }
                    
                }
                
            }
            catch(Exception g) {
            g.printStackTrace();
            }
        }
    }
}
