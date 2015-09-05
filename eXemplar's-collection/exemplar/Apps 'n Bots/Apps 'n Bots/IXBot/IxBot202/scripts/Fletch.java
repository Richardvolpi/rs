// draynor: ##fletch x=197 y=662 range=100
// varrock: ##fletch x=129 y=437 range=100		// i hope this doesn't go into the wildy

public class Fletch extends Script
{

	final int LOGS = 14;
	public int workingRange = 50;		// the range our bot will operate in (in tile^2)

    public void init() { }	// do anything here upon class initialization
    
    public String[] getCommands()
	{
		return new String[]{"fletch"};
    }

	// remeber where we started out, so we don't move too far away and land who knows where...
	TileCoord startingPos = new TileCoord(-1, -1);
	int knifeSlot = -1;
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();				// allow script to be autostopped
		EnableAutoRetreat();			// really shouldn't be needed here
		disableCustomSleeping(98);

		workingRange = 50;		// default
		boolean useLastStartingPos = false;
		for(int i = 0; i < parameters.length; i++) {
			try {	// catch exceptions - if this wouldn't be here, the client would crash on bad parameters
				if(parameters[i].equalsIgnoreCase("last")) {	// usefull for autologin and for cmdline bot
					useLastStartingPos = true;
				}
				else if(parameters[i].regionMatches(true, 0, "x=", 0, 2)) {
					startingPos.x = Integer.parseInt(parameters[i].substring(2));
					useLastStartingPos = true;
				}
				else if(parameters[i].regionMatches(true, 0, "y=", 0, 2)) {
					startingPos.y = Integer.parseInt(parameters[i].substring(2));
					useLastStartingPos = true;
				}
				else if(parameters[i].regionMatches(true, 0, "range=", 0, 6)) {
					workingRange = Integer.parseInt(parameters[i].substring(6));
					if(workingRange < 4) workingRange = 50;
				}
				else {
					println("Warning: unknown parameter " + parameters[i]);
					println("Syntax: ##woody [last] [x=XXX y=XXX] [range=XX]");
					println("\tlast uses the last starting position");
					println("\tx=XXX y=XXX lets you specify a starting position");
					println("\trange=XX lets you specify a working range, only in which trees are chopped (default is 50)");
				}
			} catch(java.lang.NumberFormatException except) {	// string passed over to parseInt was not a number - just ignore it
			}
		}
		
		if(useLastStartingPos) {
			if(startingPos.x < 0 || startingPos.y < 0) {
				println("Warning: parameter last specified but no starting player position set yet - using current one");
				startingPos.x = playerX();
				startingPos.y = playerY();
			}
		}
		else {
			startingPos.x = playerX();		// save current position of player
			startingPos.y = playerY();
		}
		isBusy = false;
		println("Starting auto fletching at (" + startingPos.x + ", " + startingPos.y + ") with range=" + workingRange + "...");

		// search for knife in inventory
		knifeSlot = -1;
		for(int i = 0; i < numInvItems(); i++) {
			if(getItemName(itemAtSlot(i)).equalsIgnoreCase("knife")) {
				knifeSlot = i;
				break;		// break the for loop
			}
		}
		if(knifeSlot == -1) println("Note: no knife found!");
		doFletch = false;
		deadTree = -1;
		
		return true;
	}

    public void stop() { println("Stopped autowoodcutter."); }

	boolean isBusy = false;
	public void ServerMessage(String message)		// catch the server messages
	{
		// TODO: make this more general
		if(message.equalsIgnoreCase("@gam@You swing your bronze axe at the tree...") || 
		   message.equalsIgnoreCase("@gam@You swing your rune axe at the tree...")) {	// quick fix - change to your axe type
			isBusy = true;
		}
		else if(message.equalsIgnoreCase("@gam@You get some wood")) {
			isBusy = false;
		}
		else if(message.equalsIgnoreCase("@gam@You slip and fail to hit the tree")) {
			isBusy = false;
		}
		else if(message.equalsIgnoreCase("@que@What would you like to make?")) {
			isBusy = true;
		}
		else if(message.equalsIgnoreCase("@que@You carefully cut the wood into 10 arrow shafts")) {
			isBusy = false;
		}
	}

//#0: Make arrow shafts
//#1: Make shortbow
//#2: Make longbow

	// actual scriptprocessing here
	private boolean reactionTime = false;		// human reaction time on new event :P
	private int timeOutCounter;
	private boolean doFletch;
	private int deadTree = -1;
	public long run(long ticks)
	{
		int dist = distanceFrom(startingPos.x, startingPos.y);	// get distance from starting position
		if(isDialogShown()) {
			if(reactionTime) { reactionTime = false; return random(500, 500); }
			if(chooseDialogItem("Make arrow shafts")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(1000, 700);
			}
			else {
				println("Fletching: Dialog item not found!");
				displayDialogItems();		// some debug information
				hideDialog();
				return random(3000, 1000);
			}
		}
		if(timeOutCounter++ > 12) {
			println("Fletching: Action timeout...");
			isBusy = false;
		}
		if(isBusy) return random(200, 200);		// wait a bit...
		timeOutCounter = 0;
		if(dist < workingRange) {
			if(isWalking()) return random(200, 200);	// do nothing while we're walking

			if(numInvItems() >= 30 || (doFletch && numInvItem(LOGS) > 0)) {
				// fletch some stuff to make room
				doFletch = true;
				int logSlot = getInvSlotBW(LOGS);
				if(logSlot < 0) {
					println("Weired: we're full, but no logs found - Halting");
					return -1;
				}
				useItemWithItem(knifeSlot, logSlot);
				reactionTime = true;
				isBusy = true;
				return random(400, 400);
			}
			else doFletch = false;

			// look for nearest tree to chop (trees must be in a certain range)
			int nearestDist = 10000, nearestIdx = -1;
			for(int i = 0; i < numObjects(); i++) {
				if(i == deadTree) continue;
				if(getObjectCommand1(getObjectType(i)).equalsIgnoreCase("Chop") || 
				   getObjectCommand2(getObjectType(i)).equalsIgnoreCase("Chop")) {	// its a tree...
					TileCoord treePos = getObjectPos(i);
					dist = distanceFrom(treePos.x, treePos.y);
					if(treePos.distanceFrom(startingPos) < workingRange && dist < nearestDist) {
						nearestDist = dist;
						nearestIdx = i;
					}
				}
			}
			if(nearestIdx == -1) {		// no near tree found
				// fletch all logs in inventory
				if(numInvItem(LOGS) > 0) {
					int logSlot = getInvSlotBW(LOGS);
					if(logSlot < 0) {
						println("Weired: we're full, but no logs found - Halting");
						return -1;
					}
					useItemWithItem(knifeSlot, logSlot);
					reactionTime = true;
					isBusy = true;
					return random(400, 400);
				}

				println("Warning: no near tree found - Idle walking");
				if(!walkTo(startingPos.x, startingPos.y, 3)) {	// walk to starting location
					println("Starting location unreachable?!");
					return -1;		// stop script
				}
				else return random(1000, 1000);		// wait 1-2 seconds
			}
			else {
				// chop that tree
				TileCoord pos = getObjectPos(nearestIdx);
				// ugly!!!
				int pLen = pathLength(playerX(), playerY(), pos.x+1, pos.y+1);
				int temp = pathLength(playerX(), playerY(), pos.x-1, pos.y+1);
				if(temp >= 0 && temp < pLen) pLen = temp;
				temp = pathLength(playerX(), playerY(), pos.x+1, pos.y-1);
				if(temp >= 0 && temp < pLen) pLen = temp;
				temp = pathLength(playerX(), playerY(), pos.x-1, pos.y-1);
				if(temp >= 0 && temp < pLen) pLen = temp;
				if(temp < 0 || temp > 25) {
					println("Tree too far or not reachable...");
					deadTree = nearestIdx;
					return 10;
				}
				else {
					println("Chopping " + getObjectName(getObjectType(nearestIdx)) + "(idx=" + nearestIdx + ")");
					if(getObjectCommand1(getObjectType(nearestIdx)).equalsIgnoreCase("Chop")) objectCommand1(nearestIdx);
					else objectCommand2(nearestIdx);
					return random(1000, 100);
				}
			}
		}
		else {
			if(isWalking()) return random(200, 200);	// do nothing while we're walking
			// walk back near out starting position
			if(!walkTo(startingPos.x, startingPos.y, 3)) {
				println("Starting location unreachable?!");
				return -1;		// stop script
			}
			else return random(1000, 1000);		// wait 1-2 seconds
		}
	}

};
