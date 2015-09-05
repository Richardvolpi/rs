import bot.*;
public class CathFish extends Methods {
	long startTime;
	int fishLured, fails;
	
	public CathFish(Client mc) {super(mc);}
	public void main(String args[]) {
		if(args.length < 2) {
			printMessage("@or2@Fisher: @yel@Usage: cathfish lob/sword");
			stop();
			return;
		}
		startTime = System.currentTimeMillis();
		printMessage("@or2@Fisher: @yel@Catherby fisher started");
		while(running()) {
			try {
				while(inventoryCount() < 30) {
					int[] pool = getObjectIndex(194);
					if(pool[0] != -1 && !sleeping() && fatigue() != 100L) {
						if(args[1].equals("lob"))
							useObject2(pool[1], pool[2]);
						else
							useObject(pool[1], pool[2]);
						wait(random(3000, 4000));
					}
					wait(50);
				}
				// walk to bank
				int x = random(420, 423);
				int y = random(494, 497);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(437, 443);
				y = random(494, 496);
				while(!imAt(x, y))  {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				//do banking
				while(!questionMenu()) {
					talkToNPC(getNPCIndex(95)[0]);
					wait(random(3000, 4000));
				}
				answerQuestion(0);
				while(!inBank())
					wait(1000);
				if(mc.method58(369) > 0) {
					depositAll(369);
					wait(random(500, 1500));
				}
				if(mc.method58(366) > 0) {
					depositAll(366);
					wait(random(500, 1500));
				}
				if(mc.method58(372) > 0) {
					depositAll(372);
					wait(random(500, 1500));
				}
				if(mc.method58(545) > 0) {
					depositAll(545);
					wait(random(500, 1500));
				}
				wait(random(500, 1500));
				closeBank();
				// walk back
				x = random(420, 423);
				y = random(494, 497);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(409, 413);
				y = random(499, 502);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
			}
			catch(Exception e) {}
		}
	}
	
	public void onStop() {
		handleCommand("status");
		printMessage("@or2@Fisher: @yel@stopped");
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		if(s.contains("you catch a")) {
			fishLured ++;
			return true;
		}
		else if(s.contains("you attempt to catch some"))
			return true;
		else if(s.contains("you fail to catch anything")) {
			fails ++;
			return true;
		}
		
		return false;
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
			printMessage("@or2@Fisher: @yel@been running for: @or2@" + timeSince(startTime) + " @yel@fish lured: @or2@" + fishLured + " @yel@fails: @or2@" + fails);
		}
	}
}
