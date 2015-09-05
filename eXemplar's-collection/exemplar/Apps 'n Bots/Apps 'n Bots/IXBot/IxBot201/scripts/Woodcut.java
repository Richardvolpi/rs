// Autowoodcutting script
// last Update 2004-01-13	~evo
// Sidenote: (203, 760) is a good starting position at wildy guid on tut island
public class Woodcut extends Script
{
	public int workingRange = 50;		// the range our bot will operate in (in tile^2)

    public void init() { }	// do anything here upon class initialization
    
    public String[] getCommands()
	{
		return new String[]{"woody"};
    }

	// remeber where we started out, so we don't move too far away and land who knows where...
	TileCoord startingPos = new TileCoord(-1, -1);
	int thinderBoxSlot = -1;
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();				// allow script to be autostopped
		DisableAutoRetreat();			// really shouldn't be needed here
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
		println("Starting auto woodcutting at (" + startingPos.x + ", " + startingPos.y + ") with range=" + workingRange + "...");

		// search for tinderbox in inventory
		thinderBoxSlot = -1;
		for(int i = 0; i < numInvItems(); i++) {
			if(getItemName(itemAtSlot(i)).equals("tinderbox")) {
				thinderBoxSlot = i;
				break;		// break the for loop
			}
		}
		if(thinderBoxSlot == -1) println("Note: no tinderbox found");
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
		else if(message.equalsIgnoreCase("@gam@You attempt to light the logs")) {
			isBusy = true;
		}
		else if(message.equalsIgnoreCase("@gam@You get some wood")) {
			isBusy = false;
		}
		else if(message.equalsIgnoreCase("@gam@You fail to light a fire")) {
			isBusy = false;
		}
		else if(message.equalsIgnoreCase("@gam@The fire catches and the logs begin to burn")) {
			isBusy = false;
		}
		else if(message.equalsIgnoreCase("@gam@You slip and fail to hit the tree")) {
			isBusy = false;
		}
	}

	// actual scriptprocessing here
	public long run(long ticks)
	{
		int dist = distanceFrom(startingPos.x, startingPos.y);	// get distance from starting position
		if(isBusy) return random(200, 200);		// wait a bit...
		if(dist < workingRange) {
			if(isWalking()) return random(200, 200);	// do nothing while we're walking
			// if we have a pile of logs below us on the ground light it
			if(thinderBoxSlot != -1 && getObjectAt(playerX(), playerY()) == -1) {	// can only light a fire when there is none yet
				int logs = -1;
				for(int i = 0; i < numGroundItems(); i++) {
					if(getGroundItemPos(i).equals(playerX(), playerY()) && getItemName(getGroundItemType(i)).equals("Logs")) {
						logs = i;
						break;		// break the loop
					}
				}
				if(logs != -1) {		// there's some logs below me => light it
					useItemWithGroundItem(thinderBoxSlot, logs);
					return random(1000, 100);
				}
			}
			// look for nearest tree to chop (trees must be in a certain range)
			int nearestDist = 10000, nearestIdx = -1;
			for(int i = 0; i < numObjects(); i++) {
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
				// look out for logs on the ground that we can light (only in operating range)
				nearestDist = 10000;
				nearestIdx = -1;
				for(int i = 0; i < numGroundItems(); i++) {
					if(getItemName(getGroundItemType(i)).equals("Logs")) {
						TileCoord pos = getGroundItemPos(i);
						dist = distanceFrom(pos.x, pos.y);
						if(getObjectAt(pos.x, pos.y) == -1 && pos.distanceFrom(startingPos) < workingRange && dist < nearestDist) {
							nearestDist = dist;
							nearestIdx = i;
						}
					}
				}
				if(nearestIdx != -1) {		// found some logs
					useItemWithGroundItem(thinderBoxSlot, nearestIdx);
					return random(1000, 100);
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
				println("Chopping " + getObjectName(getObjectType(nearestIdx)) + "(idx=" + nearestIdx + ")");
				if(getObjectCommand1(getObjectType(nearestIdx)).equalsIgnoreCase("Chop")) objectCommand1(nearestIdx);
				else objectCommand2(nearestIdx);
				return random(1000, 100);
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
