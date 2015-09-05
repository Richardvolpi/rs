import bot.*;
public class Agi2 extends Methods {
	public Agi2(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		printMessage("@or2@Agility trainer: @yel@started");
		startTime = System.currentTimeMillis();
		startExp = getStatExperience(16);
		int stuckCounter = 0;
		int food = 373;
		try {
			if(args.length > 1)
				food = Integer.parseInt(args[1]);
		}
		catch(Exception e) {
			printMessage("@or2@Agility trainer: @yel@invalid food id (-1 for no food)");
		}
		if(food != -1)
			printMessage("@or2@Agility trainer: @yel@eating food: " + pack11.Class3.method236(food).method292());
		while(running()) {
			if(!sleeping() && food != -1 && getStatCurrent(3) < 20) {
				if(itemCount(food) > 0) {
					debug("HP: " + getStatCurrent(3) + " - eating " + pack11.Class3.method236(food).method292());
					useItem(getItemSlot(food));
					wait(random(500, 1000));
				}
				else {
					debug("HP: " + getStatCurrent(3) + " and no food, stopping");
					stop();
				}
			}
			while(!sleeping() && inArea(496, 1506, 501, 1508)) {
				useObject(500, 1506);
				wait(random(1000, 2000));
			}
			while(!sleeping() && inArea(493, 560, 504, 567)) {
				useObject(501, 564);
				wait(random(1000, 2000));
			}
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
		if(s.contains("you just advanced 1 agility level"))
			levels ++;
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
