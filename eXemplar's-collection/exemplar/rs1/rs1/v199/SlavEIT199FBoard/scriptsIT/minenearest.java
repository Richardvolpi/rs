public class minenearest extends Macro {
    public minenearest(slave rs) {
        super(rs);
    }
    public String[] getCommands() {
        return new String[]{"minenearest"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /minenearest - Mines nearest rocks"};
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
    public int NearestRockType() {
        int Dist = 999;
        int curDist = 999;
        int end = -1;
        int type = -1;
        for(int t = 0; t < ObjCount(); t++) {
            curDist = Distance(ObjX(t),ObjY(t));
            if(curDist != -1 && curDist < Dist && getObjCmd1(t).toLowerCase().equalsIgnoreCase("mine")) {
                Dist = curDist;
                end = t;
                type = ObjType(t);
            }
        }
        return type;
    }
    public void start(String command, String arg[]) {
        int savedOne = NearestRockType();
        if(savedOne == -1) {
            debugG("No Rocks found!");
            rs.Macro = false;
            return;
        }
        else {
            while(rs.Macro){
                if(getFatigue() > 96 && !Sleeping()) {
                    sleep();
                }
                
                int rock = getNearestObject(savedOne);
                
                if(rock != -1) {
                    ObjCmd1(ObjX(rock),ObjX(rock));
                    wait(800 + random(100,130));
                }
                wait(30);
            }
        }
    }
}