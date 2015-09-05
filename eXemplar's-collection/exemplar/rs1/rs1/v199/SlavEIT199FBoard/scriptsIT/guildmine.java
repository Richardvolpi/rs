
public class guildmine extends Macro {
    
    public guildmine(slave rs) {
        super(rs);
        
    }
    public String[] getCommands() {
        return new String[]{"guildmine"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /guildmine   Start in bank or mines"};
    }
    public void kill() {
        while(loggedin()) {
            rs.autologin = false;
            LogOut();
            wait(3000);
        }
    }
    public void OpenBank() {
        while(!isBank()) {
            start:
                while(!isQuestMenu()) {
                    if(isQuestMenu())
                        break start;
                    TalkNearest(95);
                    wait(2400);
                }
                if(isQuestMenu()) {
                    Answer(0);
                    WaitForBank(8000);
                }
                
        }
        
    }
    public void sleep() {
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
    public void start(String command, String arg[]) {
        
        while(rs.Macro) {
            if(CoordsIn(264,3400,277,3386)) {
                while(InvCount() < 30) {
                    MineNearest(110,111);
                    wait(700 + random(70,110));
                    
                    if(getFatigue() > 95) {
                        sleep();
                    }
                }
                if(InvCount() == 30) {
                    upladder();
                    minetobank();
                }
            }
            if(CoordsIn(286,573,280,564)) {
                if(InvCount() == 30) {
                    OpenBank();
                    int types[] = { 155, 157, 158, 159, 160 };
                    for(int i = 0; i < types.length; i++) {
                        while(InvCount(types[i]) > 0) {
                            Deposit(types[i],1);
                            wait(100);
                        }
                    }
                }
                else {
                    banktomine();
                    downladder();
                }
            }
        }
        
    }
    public void MineNearest(int type1, int type2) {
        int Dist = 999;
        int curDist = 999;
        int end = -1;
        for(int t = 0; t < ObjCount(); t++) {
            curDist = Distance(ObjX(t),ObjY(t));
            if(curDist != -1 && curDist < Dist && getObjCmd1(t).toLowerCase().equalsIgnoreCase("mine") && (ObjType(t) == type1 || ObjType(t) == type2)) {
                Dist = curDist;
                end = t;
            }
        }
        if(end != -1) {
            ObjCmd1(ObjX(end),ObjY(end));
        }
    }
    public void minetobank() {
        
        WalkToWait(274,563);
        while(!CoordsIn(272,562,277,559)) {
            while(!smallDoorOpen(274,563)) {
                wallObjCommand1(274,563);
                wait(1000);
            }
            WalkToWait(275,562);
        }
        WalkToWait(286,563);
        WalkToWait(287,571);
        while(!CoordsIn(286,573,280,564)) {
            while(!bigDoorOpen(287,571)) {
                ObjCmd1(287,571);
                wait(1000);
            }
            WalkToWait(285,571);
        }
        
        
    }
    public void upladder() {
        while(!CoordsIn(272,563,277,567)) {
            ObjCmd1(274,3398);
            wait(2000);
        }
    }
    public void banktomine() {
        
        WalkToWait(286,571);
        while(!CoordsIn(287,569,289,573)) {
            while(!bigDoorOpen(287,571)) {
                ObjCmd1(287,571);
                wait(1000);
            }
            WalkToWait(287,570);
        }
        WalkToWait(287,564);
        WalkToWait(274,562);
        while(!CoordsIn(272,563,277,567)) {
            while(!smallDoorOpen(274,563)) {
                wallObjCommand1(274,563);
                wait(1000);
            }
            WalkToWait(274,564);
        }
        
        
    }
    public void downladder() {
        while(!CoordsIn(264,3400,277,3386)) {
            ObjCmd1(274,566);
            wait(2000);
        }
    }
    public boolean bigDoorOpen(int x, int y) {
        for(int g = 0; g < ObjCount(); g++) {
            if(ObjX(g) == x && ObjY(g) == y) {
                if(getObjCmd1(g).toLowerCase().equals("open")) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean smallDoorOpen(int x, int y) {
        for(int g = 0; g < wallObjCount(); g++) {
            if(wallObjX(g) == x && wallObjY(g) == y) {
                if(getwallObjCommand1(g).toLowerCase().equals("open")) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
    public void wallObjCommand1(int x, int y) {
        for(int g = 0; g < wallObjCount(); g++) {
            if(wallObjX(g) == x && wallObjY(g) == y) {
                wallObjCommand1(g);
            }
        }
    }
}