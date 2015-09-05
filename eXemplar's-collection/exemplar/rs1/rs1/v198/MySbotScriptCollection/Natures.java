public class Natures extends Script {
    public Natures(mudclient mudclient) {
        super(mudclient);
    }
    public String[] getCommands() {
        return new String[]{"natures"};
    }
    public void start(String s, String as[]) {
        while(Running() == true) {
            AtObject2(582, 1527);
            Wait(500);
            if(Fatigue() > 95 && Running() == true) {
                while (Sleeping() == false && Running() == true) {
                    Use(FindInv(1263));
                    Wait(1000);
                }
                while (Sleeping() == true && Running() == true) {
                    Wait(200);
                }
            }
        }
    }
}