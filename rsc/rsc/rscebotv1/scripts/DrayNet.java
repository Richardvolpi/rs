import bot.*;
public class DrayNet extends Methods {
	long startTime;
	int fishLured, fails;
	
	public DrayNet(Client mc) {super(mc);}
	public void main(String args[]) {
		startTime = System.currentTimeMillis();
		printMessage("@or2@Fisher: @yel@Draynor net fisher started");
		while(running()) {
			// do the mining
			try {
				while(inventoryCount() < 30) {
					int[] pool = getObjectIndex(193);
					if(pool[0] != -1 && !sleeping() && fatigue() != 100L) {
						useObject(pool[1], pool[2]);
						wait(random(3000, 4000));
					}
					wait(50);
				}
				// walk to bank
				int x = random(219, 222);
				int y = random(647, 650);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(217, 222);
				y = random(634, 638);
				while(!imAt(x, y))  {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				//do banking
				while(!questionMenu()) {
					talkToNPC(getNPCIndex(95)[0]);
					wait(random(2000, 3000));
				}
				answerQuestion(0);
				while(!inBank())
					wait(1000);
				depositAll(349);
				wait(random(500, 1500));
				if(mc.method58(351) > 0)
					depositAll(351);
				wait(500);
				closeBank();
				// walk back
				x = random(219, 222);
				y = random(647, 650);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(220, 222);
				y = random(658, 660);
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
