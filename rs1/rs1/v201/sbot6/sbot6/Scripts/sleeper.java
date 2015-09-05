public class sleeper extends Script {
	public sleeper(mudclient rs) {
        super(rs);
    }
    
    public String[] getCommands() {
        return new String[]{"sleeper"};
    }
    
    public void start(String cmd, String params[]) {
		while(Running()) {
			while(!Sleeping() && Running()) {
				Use(FindInv(1263));
				long Time = TickCount();
				while(!Sleeping() && TickCount() - Time < 3000 && Running())
					Wait(1);
			}
			while(Sleeping() && Running()) {
				long T = TickCount();
				while(Sleeping() && Running() && TickCount() - T < (Rand(3,4) * 60000))
					Wait(1000);
				if(Sleeping() && Running())
					SleepWord();
			}
			Wait(Rand(1000,2000));
		}
    }
}