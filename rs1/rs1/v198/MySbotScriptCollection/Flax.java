public class Flax extends Script {
    
    public Flax(mudclient mudclient) {
        super(mudclient);
    }
    
    public String[] getCommands() {
        return (new String[] {
            "flax"
        });
    }
    
    public void start(String s, String as[]) {
        DisplayMessage("XRoaders Flax Spinning Scripting started...", 3);
        while(Running()) {
            while(InvCount() < 30) {
                AtObject2(693, 524);
                Wait(500);
            }
            
            AtObject(692, 525);
            Wait(1500);
            do {
                if(InvCount(675) <= 0)
                    break;
                UseOnObject(694, 1469, FindInv(675));
                Wait(500);
                if(Fatigue() >= 95 && Running()) {
                    for(; !Sleeping() && Running(); Wait(2500))
                        Use(FindInv(1263));
                    
                    while(Sleeping() && Running())
                        Wait(100);
                }
            } while(true);
            for(; InvCount(676) > 0; Wait(500))
                Drop(FindInv(676));
            
            AtObject(692, 1469);
        }
        
        DisplayMessage("Script Finished", 3);
    }
}