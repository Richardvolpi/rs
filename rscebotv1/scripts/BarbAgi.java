import bot.*;
public class BarbAgi extends Methods {
	public BarbAgi(Client mc){super(mc);this.mc=mc;}
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
				case 0://CHECKS
					if(loading())
						break;
					if(inArea(486, 553, 494, 559) || imAt(489, 560) || imAt(490, 560)) {
						_goto = ROPESWING;
						break;
					}
					else if(inArea(485, 3388, 489, 3391)) {
						_goto = FELL_ON_ROPE;
						break;
					}
					else if(inArea(486, 559, 487, 564)) {
						_goto = LOG;
						break;
					}
					else if(inArea(492, 561, 494, 564)) {
						_goto = NET;
						break;
					}
					else if(inArea(496, 1506, 497, 1508)) {
						_goto = LEDGE;
						break;
					}
					else if(inArea(496, 562, 500, 564)) {
						_goto = FELL_ON_LEDGE;
						break;
					}
					else if(inArea(501, 1506, 501, 1507)) {
						_goto = GO_DOWN_FROM_HUT;
						break;
					}
					else if(inArea(501, 556, 502, 563)) {
						_goto = WALL1;
						break;
					}
					else if(inArea(495, 556, 496, 559)) {
						_goto = WALL2;
						break;
					}
					else {
						break;
					}
				case 1://ROPESWING
					if(loading())
						break;
					if(lastServerMessage.contains("you skillfully swing"))
						break;
					useObject(486, 556);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 10://FELL_ON_ROPE
					if(loading())
						break;
					useObject(490, 3389);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 2://LOG
					if(loading())
						break;
					if(lastServerMessage.contains("an walk across"))
						break;
					useObject(488, 563);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 3://NET
					if(loading())
						break;
					if(lastServerMessage.contains("you climb up the"))
						break;
					useObject(495, 563);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 4://LEDGE
					if(loading())
						break;
					if(lastServerMessage.contains("balance across"))
						break;
					useObject(498, 1506);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 12://FELL_ON_LEDGE
					if(loading())
						break;
					while(!lastServerMessage.contains("you climb up the")) {
						useObject(495, 563);
						wait(random(1000, 2000));
					}
					_goto = 0;
					break;
				case 15://GO_DOWN_FROM_HUT
					if(loading())
						break;
					if(lastServerMessage.contains("you go down the"))
						break;
					useObject(501, 1508);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 5://WALL1
					if(loading())
						break;
					if(lastServerMessage.contains("you jump over the"))
						break;
					useObject(497, 557);
					wait(random(1000, 2000));
					_goto = 0;
					break;
				case 6://WALL2
					if(loading())
						break;
					if(lastServerMessage.contains("you jump over the"))
						break;
					useObject(495, 557);
					wait(random(1000, 2000));
					_goto = 0;
					break;
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
			printMessage("@or2@Agility trainer: @yel@been running for @or2@" + timeSince(startTime));
			printMessage("@or2@Agility trainer: @yel@, experience gained: @or2@" + formatNumber(String.valueOf(getStatExperience(16) - startExp)));
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
	
	public int CHECKS = 0;
	public int ROPESWING = 1;
	public int LOG = 2;
	public int NET = 3;
	public int LEDGE = 4;
	public int WALL1 = 5;
	public int WALL2 = 6;
	public int FELL_ON_ROPE = 10;
	public int FELL_ON_LOGS = 11;
	public int FELL_ON_LEDGE = 12;
	public int GO_DOWN_FROM_HUT = 15;
	public int EAT = 20;
}