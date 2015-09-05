import bot.*;
public class BarbCoal extends Methods {
	long startTime;
	int oresMined, misses;
	
	public BarbCoal(Client mc) {super(mc);}
	public void main(String args[]) {
		startTime = System.currentTimeMillis();
		printMessage("@or2@Miner: @yel@Barbarian Village coal miner started");
		while(running()) {
			// do the mining
			try {
				while(inventoryCount() < 30) {
					if(fatigue() == 100L && !sleeping()) {
						useItem(getItemSlot(1263));
						wait(1000);
						while(sleeping())
							wait(1000);
					}
					int[] rock = getObjectIndex(110);
					if(rock[0] != -1 && !sleeping() && fatigue() != 100L) {
						useObject(rock[1], rock[2]);
						wait(random(3000, 4000));
					}
					wait(50);
				}
				// walk to bank
				int x = random(223, 225);
				int y = random(490, 492);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(219, 221);
				y = random(473, 475);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(220, 222);
				y = random(455, 457);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(216, 218);
				y = random(450, 452);
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
				depositAll(155);
				wait(random(500, 1500));
				if(mc.method58(157) > 0)
					depositAll(157);
				if(mc.method58(158) > 0)
					depositAll(158);
				if(mc.method58(159) > 0)
					depositAll(159);
				if(mc.method58(160) > 0)
					depositAll(160);
				wait(500);
				closeBank();
				// walk back
				x = random(220, 222);
				y = random(455, 457);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(219, 221);
				y = random(473, 475);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(223, 225);
				y = random(490, 492);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				x = random(223, 226);
				y = random(502, 504);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 3000));
				}
				System.out.println("loop end");
			}
			catch(Exception e) {}
		}
	}
	
	public void onStop() {
		handleCommand("status");
		printMessage("@or2@Miner: @yel@stopped");
	}
	
	public boolean onServerMessage(String s) {
		//You swing your pick at the rock...
		//You manage to obtain some <ore>.
		//You only succeed in scratching the rock.
		//There is currently no ore available in this rock.
		s = s.toLowerCase();
		if(s.contains("you manage to obtain some")) {
			oresMined ++;
			return true;
		}
		else if(s.contains("you swing your pick") || s.contains("there is currently no ore available"))
			return true;
		else if(s.contains("you only succeed in scratching")) {
			misses ++;
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
			printMessage("@or2@Miner: @yel@been running for: @or2@" + timeSince(startTime) + " @yel@ores mined: @or2@" + oresMined + " @yel@misses: @or2@" + misses);
		}
	}
}
