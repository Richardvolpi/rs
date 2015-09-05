import bot.*;
public class GuildFisher extends Methods {
	public GuildFisher(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		printMessage("@or2@Fisher: @yel@started");
		int fish = getOption("What do you want to fish?", new String[]{"Lobster", "Swordfish", "Bass", "Shark"});
		if(fish == -1) {
			printMessage("@or2@Fisher: @yel@You must choose a fish");
			stop();
		}
		cook = getBoolean("Cook it?");
		int answerSequence[] = new int[] {1, fish == 0 || fish == 2 ? (cook ? 0 : 1) : (cook ? 2 : 3), 4};
		int certerID = 0;
		fishID = 0;
		certID = 0;
		cookedCertID = 0;
		int toolID = 0;
		boolean objectActionPrimary = false;
		int objectX = 0;
		int objectY = 0;
		if(fish == 0 || fish == 1) {
			certerID = 369;
			fishID = fish == 0 ? 372 : 369;
			cookedFishID = fish == 0 ? 373 : 370;
			certID = fish == 0 ? 534 : 536;
			cookedCertID = fish == 0 ? 533 : 535;
			toolID = fish == 0 ? 375 : 379;
			objectActionPrimary = fish == 0 ? false : true;
			objectX = 596;
			objectY = 501;
		}
		if(fish == 2 || fish == 3) {
			certerID = 370;
			fishID = fish == 2 ? 554 : 545;
			cookedFishID = fish == 0 ? 555 : 546;
			certID = fish == 2 ? 629 : 631;
			cookedCertID = fish == 2 ? 628 : 630;
			toolID = fish == 2 ? 548 : 379;
			objectActionPrimary = fish == 2 ? true : false;
			objectX = 593;
			objectY = 501;
		}
		if(getItemSlot(toolID) == -1) {
			printMessage("@or2@Fisher: @yel@You don't have a " + getItemName(toolID));
			stop();
		}
		if(getItemSlot(1263) == -1) {
			printMessage("@or2@Fisher: @yel@You don't have a " + getItemName(1263));
			stop();
		}
		startTime = System.currentTimeMillis();
		startExp = getStatExperience(10);
		long time = 0L;
		while(running()) {
			while(itemCount(fishID) < 25 && running()) {
				for(int i = 0; i < inventoryCount(); i++) {
					if(inventoryItem(i) != 1263 && inventoryItem(i) != fishID && inventoryItem(i) != certID
							&& inventoryItem(i) != toolID && inventoryItem(i) != cookedFishID
							&& inventoryItem(i) != cookedCertID && inventoryItem(i) != -1) {
						dropItem(getItemSlot(inventoryItem(i)));
						wait(random(2000, 2500));
					}
				}
				if(sleeping())
					wait(100);
				else {
					useObject(objectX, objectY, objectActionPrimary);
					wait(random(3000, 4000));
				}
			}
			if(cook) {
				int x = random(585, 588);
				int y = random(515, 518);
				walkToWait(x, y);
				while(getDoorID(586, 519) == 2) {
					useDoor(586, 519);
					wait(random(2000, 3000));
				}
				while(itemCount(fishID) > 0 && running()) {
					if(sleeping())
						wait(100);
					useItemOnObject(getItemSlot(fishID), 583, 520);
					wait(random(2000, 3000));
				}
				for(int i = 0; i < inventoryCount(); i++) {
					if(inventoryItem(i) != 1263 && inventoryItem(i) != fishID && inventoryItem(i) != certID
							&& inventoryItem(i) != toolID && inventoryItem(i) != cookedFishID
							&& inventoryItem(i) != cookedCertID && inventoryItem(i) != -1) {
						dropItem(getItemSlot(inventoryItem(i)));
						wait(random(2000, 2500));
					}
				}
				x = random(601, 603);
				y = random(506, 508);
				walkToWait(x, y);
			}
			while(itemCount(cook ? cookedFishID : fishID) >= 25 && running()) {
				while(getDoorID(603, 506) == 2 && running()) {
					useDoor(603, 506);
					wait(random(3000, 4000));
				}
				while(!questionMenu() && running()) {
					time = System.currentTimeMillis();
					int certer[] = getNPCIndex(certerID);
					if(certer[0] != -1)
						talkToNPC(certer[0]);
					while(System.currentTimeMillis() - time < 5000 && !questionMenu() && running())
						wait(1000);
				}
				wait(500);
				for(int i = 0; i < answerSequence.length; i++) {
					answerQuestion(answerSequence[i]);
					wait(1000);
					if(i != answerSequence.length - 1) {
						time = System.currentTimeMillis();
						while(!questionMenu() && running() && System.currentTimeMillis() - time < 5000)
							wait(1000);
					}
				}
			}
			while(getDoorID(603, 506) == 2 && running()) {
				useDoor(603, 506);
				wait(random(3000, 4000));
			}
		}
	}
	
	public void drawInfo(int x, int y) {
		drawString("@or2@Fishing level: @yel@" + getStatCurrent(10), x, y, 1, 0);
		y += 12;
		drawString("@or2@" + getItemName(cook ? cookedFishID : fishID) + ": @yel@" + itemCount(cook ? cookedFishID : fishID), x, y, 1, 0);
		y += 12;
		drawString("@or2@Certs: @yel@" + itemCount(cook ? cookedCertID : certID), x, y, 1, 0);
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
			printMessage("@or2@Fisher: @yel@been running for @or2@" + timeSince(startTime));
			printMessage("@or2@Fisher: @yel@, experience gained: @or2@" + formatNumber(String.valueOf(getStatExperience(10) - startExp)) + "@yel@, levels gained: @or2@" + levels);
		}
	}
	
	public void debug(String s){
		if(debug)
			System.out.println("Fisher: " + s);
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		lastServerMessage = s;
		if(s.contains("you just advanced"))
			levels ++;
		if(s.contains("you attempt to") || s.contains("you fail to") || s.contains("you catch a raw"))
			return true;
		return false;
	}
	
	public void onStop() {
		printMessage("@or2@Fisher: @yel@stopped");
	}
	
	public String lastServerMessage = "";
	public boolean debug = true;
	public long startTime = 0L;
	public int startExp = 0;
	public int levels = 0;
	public int fishID = 0;
	public int certID = 0;
	public int cookedFishID = 0;
	public int cookedCertID = 0;
	public boolean cook = false;
}
