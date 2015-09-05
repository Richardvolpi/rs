import bot.*;
public class BarbWallSpam extends Methods {
	public BarbWallSpam(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		printMessage("@or2@Agility trainer: @yel@started");
		startTime = System.currentTimeMillis();
		startExp = getStatExperience(16);
		while(running()) {
			useObject(497, 557);
			wait(random(500, 800));
		}
	}
	
	public void handleCommand(String s) {
		int index = s.indexOf(" ");
		String cmd = s;
		String args[] = new String[0];
		if(index != -1) {
			cmd = s.substring(0, index).trim();
			args = s.substring(index + 1).trim().split(" ");
		}
		
		if(cmd.equals("status")) {
			printMessage("@or2@Agility trainer: @yel@been running for @or2@" + timeSince(startTime) + "@yel@, experience gained: @or2@" + formatNumber(String.valueOf(getStatExperience(16) - startExp)) + "@yel@, levels gained: @or2@" + levels);
		}
	}
	
	public void debug(String s){
		if(debug)
			System.out.println("Agility trainer: " + s);
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		lastServerMessage = s;
		if(s.contains("you just advanced"))
			levels ++;
		if(s.contains("you jump over the wall"))
			return true;
		return false;
	}
	
	public void onStop() {
		printMessage("@or2@Agility trainer: @yel@stopped");
	}
	
	public String lastServerMessage = "";
	public boolean debug = true;
	public long startTime = 0L;
	public int startExp = 0;
	public int levels = 0;
}
