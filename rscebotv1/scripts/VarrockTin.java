import bot.*;
public class VarrockTin extends Methods {
	long startTime;
	int oresMined, misses;
	
	public VarrockTin(Client mc) {super(mc);}
	public void main(String args[]) {
		startTime = System.currentTimeMillis();
		printMessage("@or2@Miner: @yel@Varrock tin miner started");
		while(running()) {
			// do the mining
			while(inventoryCount() < 30) {
				if(fatigue() == 100L && !sleeping()) {
					useItem(getItemSlot(1263));
					wait(1000);
					while(sleeping())
						wait(1000);
				}
				int[] rock = getObjectIndex(105);
				if(rock[0] != -1 && !sleeping() && fatigue() != 100L) {
					useObject(rock[1], rock[2]);
					wait(random(3000, 4000));
				}
				wait(50);
			}
			// walk to bank
			int x = random(76, 78);
			int y = random(535, 537);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = random(78, 80);
			y = random(520, 522);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = random(83, 85);
			y = random(508, 510);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = random(101, 104);
			y = random(510, 512);
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
			depositAll(202);
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
			x = random(83, 85);
			y = random(508, 510);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = random(78, 80);
			y = random(520, 522);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = random(76, 78);
			y = random(535, 537);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			x = 77;
			y = random(544, 547);
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(2000, 3000));
			}
			System.out.println("loop end");
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
