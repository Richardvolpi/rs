import java.awt.*;
public class netfish extends Macro {
    public boolean didDragon = false;
    public netfish(slave rs) {
        super(rs);
        
    }
    public String[] getCommands() {
        return new String[]{"netfish"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /netfish   Start at dray fish spot"};
    }
    public void kill() {
        while(loggedin()) {
            rs.autologin = false;
            LogOut();
            wait(3000);
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
            while(InvCount() < 30) {
                ObjCmd1(224,659);
                wait(1000);
                
                if(getFatigue() > 95) {
                    sleep();
                }
            }
            WalkToWait(220,657);
            WalkToWait(215,640);
            
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
                    wait(100);
                }
                while(InvCount(349) > 0) {
                    Deposit(349,1);
                    wait(100);
                }
                while(InvCount(351) > 0) {
                    Deposit(351,1);
                    wait(100);
                }
                WalkToWait(215,640);
                WalkToWait(220,657);
            }
        }
        
    }
}