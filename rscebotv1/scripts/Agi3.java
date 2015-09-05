import bot.*;
public class Agi3 extends Methods {
	public Agi3(Client mc){super(mc);this.mc=mc;}
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
		int _goto = 0;
		int _oldgoto = 0;
		while(running()) {
			switch(_goto) {
				case 0:
					while(!lastServerMessage.contains("the pipe")) {
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						if(!sleeping() && food != -1 && getStatCurrent(3) < 40) {
							if(itemCount(food) > 0) {
								debug("HP: " + getStatCurrent(3) + " - eating " + pack11.Class3.method236(food).method292());
								useItem(getItemSlot(food));
								wait(random(500, 1000));
							}
						}
						if(died()) {
							_goto = 20;
							break;
						}
						debug("the pipe");
						useObject(294, 119);
						wait(random(1000, 2000));
					}
					while(!imAt(294, 112))
						wait(500);
					_goto = 1;
					break;
				case 1:
					while(!droppedDown() && !lastServerMessage.contains("grab the rope")) {
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						if(!sleeping() && food != -1 && getStatCurrent(3) < 40) {
							if(itemCount(food) > 0) {
								debug("HP: " + getStatCurrent(3) + " - eating " + pack11.Class3.method236(food).method292());
								useItem(getItemSlot(food));
								wait(random(500, 1000));
							}
						}
						if(died()) {
							_goto = 20;
							break;
						}
						debug("grab the rope");
						useObject(292, 110);
						wait(random(1000, 2000));
					}
					while(_goto == 1 && !droppedDown() && !imAt(292, 108))
						wait(500);
					if(droppedDown())
						_goto = 10;
					else
						_goto = 2;
					break;
				case 2:
					while(!droppedDown() && !lastServerMessage.contains("stepping stones")) {
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						if(!sleeping() && food != -1 && getStatCurrent(3) < 40) {
							if(itemCount(food) > 0) {
								debug("HP: " + getStatCurrent(3) + " - eating " + pack11.Class3.method236(food).method292());
								useItem(getItemSlot(food));
								wait(random(500, 1000));
							}
						}
						if(died()) {
							_goto = 20;
							break;
						}
						debug("stepping stones");
						useObject(293, 105);
						wait(random(1000, 2000));
					}
					while(_goto == 2 && !droppedDown() && !imAt(297, 105) && !lastServerMessage.contains("lose your foot"))
						wait(500);
					if(droppedDown())
						_goto = 10;
					else if(lastServerMessage.contains("lose your foot"))
						_goto = 2;
					else
						_goto = 3;
					break;
				case 3:
					while(!droppedDown() && !lastServerMessage.contains("on the ledge")) {
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						if(!sleeping() && food != -1 && getStatCurrent(3) < 40) {
							if(itemCount(food) > 0) {
								debug("HP: " + getStatCurrent(3) + " - eating " + pack11.Class3.method236(food).method292());
								useItem(getItemSlot(food));
								wait(random(500, 1000));
							}
						}
						if(died()) {
							_goto = 20;
							break;
						}
						debug("on the ledge");
						useObject(296, 111);
						wait(random(1000, 2000));
					}
					while(_goto == 3 && !droppedDown() && !inArea(301, 110, 305, 115)) {// && !lastServerMessage.contains("and walk across")) {
						wait(500);
					}
					if(droppedDown())
						_goto = 10;
					else
						_goto = 4;
					break;
				case 4:
					while(!droppedDown() && !lastServerMessage.contains("climb up")) {
						debug(lastServerMessage);
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						if(getStatCurrent(3) < 40 && itemCount(food) > 0) {
							_oldgoto = 4;
							_goto = 11;
							break;
						}
						if(died()) {
							_goto = 20;
							break;
						}
						debug("you climb up");
						useObject(305, 118);
						wait(random(1000, 2000));
					}
					while(_goto == 4 && !inArea(302, 119, 305, 122))
						wait(500);
					_goto = 0;
					break;
				case 10:
					while(!backUp() && !lastServerMessage.contains("the ladder")) {
						while(inCombat(ourPlayer())) {
							walkTo(sectionX() + areaX(), sectionY() + areaY());
							wait(random(300, 800));
						}
						useObject(289, 2933);
						wait(random(3000, 4000));
					}
					_goto = 2;
					break;
				case 20:
					while(!imAt(135, 636)) {
						walkTo(135, 636);
						wait(random(1000, 2000));
					}
					while(!questionMenu()) {
						useObject(140, 636);
						wait(random(4000, 5000));
					}
					answerQuestion(9);
					while(!inArea(310, 324, 195, 211))
						wait(100);
					while(!imAt(313, 193)) {
						debug("walkback3");
						walkTo(313, 193);
						wait(random(1000, 2000));
					}
					while(!imAt(308, 179)) {
						debug("walkback 4");
						walkTo(308, 179);
						wait(random(1000, 2000));
					}
					while(!imAt(296, 169)) {
						debug("walkback 5");
						walkTo(296, 169);
						wait(random(1000, 2000));
					}
					while(!imAt(293, 155)) {
						debug("walkback 6");
						walkTo(293, 155);
						wait(random(1000, 2000));
					}
					while(!imAt(298, 140)) {
						debug("walkback 7");
						walkTo(298, 140);
						wait(random(1000, 2000));
					}
					while(!imAt(298, 133)) {
						debug("walkback 8");
						useObject(297, 134);
						wait(random(1000, 2000));
					}
					while(!imAt(298, 125)) {
						debug("walkback 9");
						useObject(297, 125);
						wait(random(1000, 2000));
					}
					while(!imAt(298, 133)) {
						debug("walkback 10");
						useObject(297, 134);
						wait(random(1000, 2000));
					}
					_goto = 0;
					break;
			}
		}
	}
	
	public boolean died() {
		return inArea(120, 645, 124, 649);
	}
	
	public boolean backUp() {
		return inArea(288, 100, 290, 102);
	}
	
	public boolean droppedDown() {
		return inArea(288, 2932, 302, 2947);
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
			printMessage("@or2@Agility trainer: @yel@been running for @or2@" + timeSince(startTime) + "@yel@, experience gained: @or2@" + formatNumber(String.valueOf(getStatExperience(16) - startExp)));
		}
	}
	
	public void debug(String s){
		if(debug)
			System.out.println("Agility trainer: " + s);
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		lastServerMessage = s;
		return false;
	}
	
	public void onStop() {
		printMessage("@or2@Agility trainer: @yel@stopped");
	}
	
	public String lastServerMessage = "";
	public boolean debug = true;
	public long startTime = 0L;
	public int startExp = 0;
}