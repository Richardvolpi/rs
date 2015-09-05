// A general autofighter in RBfx style (it has gone *slightly* more advanced by now :P)
// that should work on any foe by just starting this script. It automatically 
// selects the closest attackable Npc, unless specified other.
// Update:
//     - some bug fixes
//     - opens doors now!
//     - path-finder is more intelligent, e.g. when a npc is close to a wall, walkcommands are
//		 no longer sent to the wrong site of the wall (walks to npc-dest within range 3!)
//	     same with walking back to starting point location...
//     - parameters went too complicated...but you'll find out ;P
//     - autopickup stuff (+XXX parameter)
//     - auto-prayer (pray parameter)
//     - autoeat (logout on out-of-food)
//     - autobank when full (only draynor right now - parameter "bank")
//
// example for autofighting in draynor at lvl 2 rats: ##fight x=216 y=616 name=Rat
// alternatively, specify the types of npc to attack with "cap=MaxLevel" and "range=Range" in order to
// attack any npc with combat level <= MaxLeven within a range "Range" from startpoint
//			 -evo-

// bone collector in draynor: ##fight x=216 y=616 cap=13 range=100 +20 bank
// herb collector at chaos druids: ##fight x=211 y=3252 cap=19 range=400 +herb bank

public class Fight extends Script
{

	public String[] getCommands()
	{
		return new String[]{"fight"};
	}

	String NpcName = null;		// name of the NPC we're going to attack
	TileCoord startingPos = new TileCoord(-1, -1);
	int workingRange = 30*30;		// the range our bot will operate in (in tile^2)
	int combatCap = 0;			// maxlevel of Npc's we're going to attack
	boolean autoPray = false;
	boolean doAutoBank = false;
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();				// allow script to be autostopped
		DisableAutoRetreat();			// of course we don't want to retreat when autofighting
		disableCustomSleeping(98);

		// set default values
		NpcName = null;
		workingRange = 30*30;
		combatCap = 0;
		startingPos.x = playerX();		// current position of player
		startingPos.y = playerY();
		autoPray = false;
		itemList.clear();
		pickItems = false;
		doAutoBank = false;
		for(int i = 0; i < parameters.length; i++) {
			try {	// catch exceptions - if this wouldn't be here, the client would crash on bad parameters
				if(parameters[i].regionMatches(true, 0, "x=", 0, 2)) {
					startingPos.x = Integer.parseInt(parameters[i].substring(2));
				}
				else if(parameters[i].regionMatches(true, 0, "y=", 0, 2)) {
					startingPos.y = Integer.parseInt(parameters[i].substring(2));
				}
				else if(parameters[i].regionMatches(true, 0, "name=", 0, 2)) {		// name of the npc we want to attack
					NpcName = parameters[i].substring(5);
					// get rest of parameter string as this name
					for(i++; i < parameters.length; i++) NpcName += " " + parameters[i];
				}
				else if(parameters[i].regionMatches(true, 0, "range=", 0, 6)) {
					workingRange = Integer.parseInt(parameters[i].substring(6));
					if(workingRange <= 0) workingRange = 0;
				}
				else if(parameters[i].regionMatches(true, 0, "cap=", 0, 4)) {
					combatCap = Integer.parseInt(parameters[i].substring(4));
					if(combatCap < 1) combatCap = 1;
				}
				else if(parameters[i].equalsIgnoreCase("pray")) {
					autoPray = true;
				}
				else if(parameters[i].equalsIgnoreCase("bank")) {
					doAutoBank = true;
				}
				else if(parameters[i].charAt(0) == '+') {
					pickItems = true;
					try {
						itemList.add(new Integer(parameters[i].substring(1)));
					} catch(java.lang.NumberFormatException except) {
						String itemName = parameters[i].substring(1);
						print("Adding all items with name \"" + itemName + "\": ");
						String delim = "";
						for(int itm = 0; itm < 1290; itm++) { // that's the current total amount of items
							if(getItemName(itm).equalsIgnoreCase(itemName)) {
								print(delim + itm);
								delim = ";";
								itemList.add(new Integer(itm));
							}
						}
						println("");		// end of line
					}
				}
				else {
					println("Warning: unknown parameter " + parameters[i]);
					println("Syntax: ##fight [pray] [+XXX] [x=XXX y=XXX] [cap=XXX] [range=XX] [name=XXX]");
					println("\tNote: name MUST be last parameter, if specified");
					println("\tx=XXX y=XXX lets you specify a starting position");
					println("\tpray: autopickup and bury any bones");
					println("\t+XXX: XXX denoting the item id of items to autopickup");
					println("\tname=XXX lets you specify a npcname to attack (name till end of line)");
					println("\tcap=XXX Maximum combatlevel of Npc's we want to attack");
					println("\trange=XX lets you specify a working range, only in which npcs are attacked (default is 50)");
				}
			} catch(java.lang.NumberFormatException except) {	// string passed over to parseInt was not a number - just ignore it
			}
		}
		if(doAutoBank && !itemList.isEmpty()) {
			int bankItems[] = new int[itemList.size()];
			java.util.Iterator it = itemList.iterator();
			int i = 0;
			while(it.hasNext()) {
				int itemId = ((Integer)it.next()).intValue();
				println("["+i+"]: banking item " + getItemName(itemId) + " (" + itemId + ")");
				bankItems[i++] = itemId;
			}
			setBankTypes(bankItems);	// initialize standard implementation of banking
		}

		lastNpcId = -1;
		lastPathLen = -1;
		lastItemPos = null;
		isBusy = false;
		didRetreat = false;
		attackOnlyReachable = false;

		if(NpcName == null || NpcName.length() <= 0) {
			if(combatCap > 0) {
				if(workingRange > 0)
					printMessage("@ran@ixBot: @ora@Attacking any Npc with combat <= " + combatCap + " and within range " + workingRange);
				else printMessage("@ran@ixBot: @ora@Attacking any Npc with combat <= " + combatCap);
			}
			else if(workingRange > 0)
				printMessage("@ran@ixBot: @ora@Attacking any Npc within range " + workingRange);
			else printMessage("@ran@ixBot: @ora@Attacking ANY Npc");
		}
		else {
			if(combatCap > 0) {
				if(workingRange > 0)
					printMessage("@ran@ixBot: @ora@Attacking any Npc with combat <= " + combatCap + " and within range " + workingRange + " or npcs of type " + NpcName);
				else printMessage("@ran@ixBot: @ora@Attacking any Npc with combat <= " + combatCap + " or npcs of type " + NpcName);
			}
			else if(workingRange > 0)
				printMessage("@ran@ixBot: @ora@Attacking any Npc within range " + workingRange + " or npcs of type " + NpcName);
			else printMessage("@ran@ixBot: @ora@Attacking ANY Npc");
		}
		return true;
	}

    public void stop()
	{
		printMessage("@ran@ixBot: @ora@stopped autofighting");
	}

	boolean isBusy = false, didRetreat = false;
	public void ServerMessage(String message)		// catch the server messages
	{
		if(message.equalsIgnoreCase("I can't get close enough")) {
			isBusy = true;
			didRetreat = false;
		}
		else if(message.equalsIgnoreCase("Your opponent is retreating")) {
			didRetreat = true;
		}
	}

	// don't do anything in there, just there to clear didRetreat flag
	boolean combCheck = true;
	public long runCombat(long ticks)
	{
		if(combCheck) didRetreat = false;		// only set once on entering combat mode
		combCheck = false;
		return 1000;		// call once a sec
	}

	// returns true, if this is a npc of the type we want to attack
	public boolean ValidateNpc(int idx, TileCoord pos)
	{
		if(NpcName != null && getNpcName(getNpcType(idx)).equalsIgnoreCase(NpcName))	// select by name
			return true;

		if(workingRange > 0 && pos.distanceFrom(startingPos) > workingRange) return false;		// out of range
		if(combatCap > 0 && getNpcCombatLevel(getNpcType(idx)) > combatCap) return false;	// too high combat

		return true;		// seems to be ok, everything
	}

	public int DoBury()
	{
		// look for bones to bury at 5 random slots
		for(int i = 0; i < 5; i++) {
			int slot = random(0, numInvItems()-1);
			if(getItemCommand(itemAtSlot(slot)).equalsIgnoreCase("Bury")) {
				itemCommand(slot);
				return random(700, 500);
			}
		}
		return 0;		// did nothing
	}

	public boolean DoEat()		// eats anything eatable in inventory
	{
		// first do random search in inventory
		int counter = 0;
		int slot = -1;
		do {
			slot = random(0, numInvItems()-1);			// choose a random inventory slot
		}
		while(!getItemCommand(itemAtSlot(slot)).equals("Eat") && ++counter < 200);

		if(counter >= 200) {
			slot = -1;
			// issue an accurate search!
			for(int i = 0; i < numInvItems(); i++) {
				if(getItemCommand(itemAtSlot(i)).equals("Eat")) {
					slot = i;
					break;
				}
			}
		}
		if(slot == -1) {	// out of food?
			println("DoEat() : Out of food");
			return false;
		}
		itemCommand(slot);
		return true;
	}

	// returns true, if this is a usefull item
	private java.util.HashSet itemList = new java.util.HashSet();
	private boolean pickItems = false;
	public boolean validateItem(int itemId)
	{
		if(autoPray && getItemCommand(itemId).equalsIgnoreCase("Bury")) return true;
		if(pickItems && itemList.contains(new Integer(itemId))) return true;
		return false;
	}

	int HelperWalkX[] = { 0, 0 };	// needs to be initialized
	int HelperWalkY[] = { 0, 0 };
	int lastNpcId = -1;
	long lastPathLen = -1;
	boolean attackOnlyReachable = false;
	TileCoord lastItemPos = null;
	public long run(long ticks)
	{
		// first off, check if we need to eat
		int hitPoints = getSkillLevelCurrent(3);		// current hp
		int totalHits = getSkillLevelReal(3);			// total hp
		if(hitPoints <= totalHits*100/175) {
			// need to eat...
			if(!DoEat()) {
				println("Out of food - halting");
				return -1;
			}
			return random(400, 400);
		}
		if(pickItems && doAutoBank && numInvItems() >= 30) {
			if(inArea(216, 634, 223, 638)) {
				println("Starting bank account manager...");
				openBankAccount();
				return 100;
			}
			else if(walkToArea(216, 634, 223, 638)) return random(1000, 500);
			else {		// try find way into bank
				HelperWalkX[0] = playerX(); HelperWalkY[0] = playerY();
				HelperWalkX[1] = 219; HelperWalkY[1] = 636;
				runWalkingScript(HelperWalkX, HelperWalkY);
				return 100;
			}
		}

		boolean pickItem = false;
		int closestDist = 9999;
		int closestPathLength = 9999;	// this is different from closestDist, sine we must walk around obstacles
										// Thus, this is the better choice to determine the nearest npc, since
										// this gives us the actual number of walking steps
		int closestIdx = -1;
		TileCoord closestPos = null;
		// browse through all npcs
		for(int idx = 0; idx < numNpcs(); idx++) {
			TileCoord pos = getNpcPos(idx);
			if(ValidateNpc(idx, pos) && isNpcAttackable(idx) && (!isNpcInCombat(idx) || (didRetreat && lastNpcId == getNpcId(idx)))) {
				int pathLen = pathLength(playerX(), playerY(), pos.x, pos.y);	// returns -1 if not reachable
				int dist = distanceFrom(pos.x, pos.y);
				if(attackOnlyReachable && pathLen < 0) continue;
				if((pathLen >= 0 && pathLen < closestPathLength) || (pathLen < 0 && dist < closestDist)) {
					closestIdx = idx;
					closestDist = dist;
					if(pathLen < 0) closestPathLength = 9999;
					else closestPathLength = pathLen;
					closestPos = pos;
				}
			}
		}
		if((autoPray||pickItems) && numInvItems() < 30) {
			// check if bone is closer
			for(int i = 0; i < numGroundItems(); i++) {
				TileCoord pos = getGroundItemPos(i);
				int dist = distanceFrom(pos.x, pos.y);
				if(validateItem(getGroundItemType(i)) && dist < 10*10 && (workingRange <= 0 || pos.distanceFrom(startingPos) <= workingRange)) {
					int pathLen = pathLength(playerX(), playerY(), pos.x, pos.y);
					if(attackOnlyReachable && pathLen < 0) continue;
					if((pathLen >= 0 && pathLen < closestPathLength) || (pathLen < 0 && dist < closestDist)) {
						closestIdx = i;
						if(pathLen < 0) closestPathLength = 9999;
						else closestPathLength = pathLen;
						closestDist = dist;
						closestPos = pos;
						pickItem = true;
					}
				}
			}
		}

/*		if(closestIdx == -1) println("[2]: closestIdx = -1");
		else if(pickItem) {
			int itype = getGroundItemType(closestIdx);
			println("[2] Picking item "+getItemName(itype)+"("+itype+ ") at (" + closestPos.x + "," + closestPos.y + ")");
		}
		else {
			println("[2] Attacking " + getNpcName(getNpcType(closestIdx)) + " at (" + closestPos.x + "," + closestPos.y + ") - " + (getSkillXP(0)/4) + ";" + (getSkillXP(1)/4) + ";" + (getSkillXP(2)/4));
		} */


		if(closestIdx == -1) {
			// check if there's something to bury
			if(autoPray) {
				int result = DoBury();
				if(result > 0) return result;		// action was taken
			}
			// walk near starting position
			// Note: if we're trapped and cannot reach it, just wait till next respawn
			// and it will be done automatically. So there's no need to do it here
			int dist = distanceFrom(startingPos.x, startingPos.y);	// get distance from starting position
			if(dist > 4*4 || oneIn(5)) {
				if(isWalking()) return random(200, 200);	// do nothing while we're walking
				// walk back near out starting position
				if(dist >= 16*16 || !areaReachable(startingPos.x-3, startingPos.y-3, startingPos.x+3, startingPos.y+3)) {
					// setup a helper walking script to that location
					// Update: Walking script algorithm now checks for closed doors
					HelperWalkX[0] = playerX(); HelperWalkY[0] = playerY();
					HelperWalkX[1] = startingPos.x; HelperWalkY[1] = startingPos.y;
					runWalkingScript(HelperWalkX, HelperWalkY);
					return 100;
				}
				else if(!walkToEx(startingPos.x, startingPos.y, 3)) {
					println("Starting location unreachable?!");
					return -1;		// stop script
				}
				else return random(1000, 1000);		// wait 1-2 seconds
			}
			else return random(500, 500);			// wait some time for next respawn
		}

		if(!tileReachable(closestPos.x, closestPos.y)) {		// maybe we're locked. look for closed doors near and open them
			println("Dammit, we're locked in at (" + playerX() + ", " + playerY() + ") going to (" + closestPos.x + ", " + closestPos.y + "). Looking for doors...");
			int result = tryToFree();
			if(result > 0) return result;		// some action was taken...

			println("We seem to be trapped somewhere... Only going to attack reachable npcs as of now");
			attackOnlyReachable = true;
			//ForcedScriptSuspension();
			return 1000;
		}
		// handle very large distances with walking script algorithm
		if(closestDist >= 16*16) {
			// setup a helper walking script to that location
			HelperWalkX[0] = playerX(); HelperWalkY[0] = playerY();
			HelperWalkX[1] = closestPos.x; HelperWalkY[1] = closestPos.y;
			runWalkingScript(HelperWalkX, HelperWalkY);
			return 100;
		}

		if(!pickItem && lastNpcId != getNpcId(closestIdx)) {		// a new npc?
			println("Attacking " + getNpcName(getNpcType(closestIdx)) + " at (" + closestPos.x + "," + closestPos.y + ") - " + (getSkillXP(0)/4) + ";" + (getSkillXP(1)/4) + ";" + (getSkillXP(2)/4));
			lastNpcId = getNpcId(closestIdx);
			lastPathLen = closestPathLength;
		}
		else if(pickItem && (lastItemPos == null || !closestPos.equals(lastItemPos))) {
			int itype = getGroundItemType(closestIdx);
			println("Picking item "+getItemName(itype)+"("+itype+ ") at (" + closestPos.x + "," + closestPos.y + ")");
			lastItemPos = closestPos;
			lastPathLen = closestPathLength;
		}
		if(isWalking() && closestPathLength <= lastPathLen) {
			lastPathLen = closestPathLength;
			if(autoPray) {
				int result = DoBury();
				if(result > 0) return result;		// action was taken
			}
			return 200;	// still walking, so there's no need to do anything right now
		}
		lastPathLen = closestPathLength;

		if(closestDist > 9*9) {		// npc/item/object to far away, walk near it
			walkToEx(closestPos.x, closestPos.y, 2);
			return random(1000, 1000);
		}
		if(pickItem) {
			takeGroundItem(closestIdx);
		}
		else {
			combCheck = true;
			attackNpc(closestIdx);
		}
		return random(1000, 500);		// wait a bit longer after sending an attack/take/etc command
	}

};
