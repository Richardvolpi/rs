// abstract autominer class
public abstract class AutoMine extends Script
{
	private boolean miningSuccess, miningFailed, isMining;

	protected java.util.HashSet rockTypes = new java.util.HashSet();
	protected int MineRockX[];
	protected int MineRockY[];
	private int curMiningRock;		// index into MineRockX/Y
	private int swings, pickSwings;

	// these 2 functions can be overridden
	protected boolean IsRockSpawned(int rockType)
	{
		return rockTypes.contains(new Integer(rockType));
	}
	protected int RockPriority(int rockType) { return 0; /* disabled by default */ }

	protected void AddRocks(int rocksX[], int rocksY[])
	{
		if(rocksX == null || rocksY == null) return;
		if(rocksX.length != rocksY.length) return;		// refuse to add different sized arrays
		if(MineRockX == null) MineRockX = rocksX;
		else {
			int a[] = new int[MineRockX.length + rocksX.length];
			System.arraycopy(MineRockX, 0, a, 0, MineRockX.length);
			System.arraycopy(rocksX, 0, a, MineRockX.length, rocksX.length);
			MineRockX = a;
		}
		if(MineRockY == null) MineRockY = rocksY;
		else {
			int a[] = new int[MineRockY.length + rocksY.length];
			System.arraycopy(MineRockY, 0, a, 0, MineRockY.length);
			System.arraycopy(rocksY, 0, a, MineRockY.length, rocksY.length);
			MineRockY = a;
		}
	}

	protected void AddRockType(int value)
	{
		rockTypes.add(new Integer(value));
	}

	// a list of itemIDs of all kinds of ores and gems
	private int bankItems[] = { 149, 150, 151, 152, 153, 154, 155, 157, 158, 159, 160, 202, 383, 409 };
	public boolean start(String command, String parameters[])
	{
		rockTypes.clear();
		MineRockX = null;
		MineRockY = null;
		miningSuccess = false;
		isMining = false;
		miningFailed = false;
		curMiningRock = -1;
		setBankTypes(bankItems);	// initialize standard implementation of banking
		// initialize pickaxe type
		swings = 0;
		pickSwings = 0;
		if(numInvItem(156) > 0) pickSwings = 1;		// Bronze Pickaxe
		if(numInvItem(1258) > 0) pickSwings = 2;	// Iron Pickaxe
		if(numInvItem(1259) > 0) pickSwings = 4;	// Steel Pickaxe
		if(numInvItem(1260) > 0) pickSwings = 6;	// Mithril Pickaxe
		if(numInvItem(1261) > 0) pickSwings = 8;	// Adamantite Pickaxe
		if(numInvItem(1262) > 0) pickSwings = 12;	// Rune Pickaxe
		if(pickSwings == 0) {
			println("Need pickaxe to mine here.");
			return false;
		}
		else return true;
	}

	// catch the server messages
	public void ServerMessage(String message)
	{
		if(message.regionMatches(true, 0, "@gam@You manage to obtain some", 0, 25)) {
			miningSuccess = true;
			isMining = false;
			swings++;
		}
		else if(message.equalsIgnoreCase("@gam@There is currently no ore available in this rock")) {
			miningFailed = true;
			isMining = false;
			swings++;
		}
		else if(message.regionMatches(true, 0, "@gam@You just found a", 0, 21)) {
			println(message);
			isMining = false;
			swings++;
		}
		else if(message.equalsIgnoreCase("@gam@You only succeed in scratching the rock") ||
		        message.equalsIgnoreCase("@gam@A few lumps of uninteresting rock break off") ||
		        message.equalsIgnoreCase("@gam@You fail to make any real impact on the rock") ||
		        message.equalsIgnoreCase("@gam@You slip and fail to hit the rock")) {
			miningFailed = true;
			isMining = false;
			swings++;
		}
		else if(message.equalsIgnoreCase("@gam@You swing your pick at the rock...")) {
			miningFailed = false;
			isMining = true;
		}
	}

	protected int MineRock()
	{
		if(getObjectType(MineRockX[0], MineRockY[0]) == -1) {
			println("Warning: Objects not loaded yet!");		// can be caused by lag
			return random(500, 500);		// wait between 0.5 and 1 sec
		}
		int justMined = -1;		// the rock we just mined and that is empty now
		if(miningSuccess) {
			println("Obtain Ore after " + swings + " swings. " + numInvItems() + " Items in inventory (" + fatigueLevel() + "%)");
			miningSuccess = false;
			miningFailed = false;
			isMining = false;
			swings = 0;
			justMined = curMiningRock;
			curMiningRock = -1;
		}
		else if(miningFailed) {
			//println("Failed to obtain ore after " + swings + " swings. " + numInvItems() + " Items in inventory (" + fatigueLevel() + "%)");
			miningSuccess = false;
			miningFailed = false;
			isMining = false;
			swings = 0;
		}
		else if(isMining && swings < pickSwings) return 0;	// wait till mining that rock finished before clicking again

		boolean foundRock = false;
		int rockX=0, rockY=0;
		int rockType;
		if(curMiningRock != -1 && curMiningRock != justMined) {
			rockX = MineRockX[curMiningRock];
			rockY = MineRockY[curMiningRock];
			rockType = getObjectType(rockX, rockY);
			if(IsRockSpawned(rockType)) foundRock = true;
		}

		boolean selectedNewRock = false;
		int nearestDist = 99*99;
		int nearestIdx = -1;
		int highestPrio = -1;
		if(!foundRock) {
			// search for nearest rock with spawn
			for(int i = 0; i < MineRockX.length; i++) {
				if(i == justMined) continue;	// ignore this one
				rockX = MineRockX[i];
				rockY = MineRockY[i];
				rockType = getObjectType(rockX, rockY);
				if(IsRockSpawned(rockType)) {
					int deltaX = (playerX()-rockX), deltaY = (playerY()-rockY);
					int dist = deltaX*deltaX + deltaY*deltaY;
					int rockPrio = RockPriority(rockType);
					if(rockPrio > highestPrio) {
						// higher priority rock found
						nearestDist = dist;
						nearestIdx = i;
						highestPrio = rockPrio;
					}
					else if(rockPrio == highestPrio) {
						// choose nearest
						if(dist < nearestDist) {	// found a better target
							nearestDist = dist;
							nearestIdx = i;
						}
					}
				}
			}
			if(nearestIdx != -1) {
				foundRock = true;
				rockX = MineRockX[nearestIdx];
				rockY = MineRockY[nearestIdx];
				curMiningRock = nearestIdx;
				selectedNewRock = true;
			}
		}
		else {
			int deltaX = (playerX()-rockX), deltaY = (playerY()-rockY);
			nearestDist = deltaX*deltaX + deltaY*deltaY;
		}
		if(!foundRock) return 0;	// wait till spawn appears.....
		if(nearestDist > 4*4) {
			if(!selectedNewRock && isWalking()) return 0;	// walk to new rock when selected a new mining rock
			// we are too far - walk near Rock
			if(!walkTo(rockX, rockY, 1)) {
				println("MineRock(): failed to reach rock (" + rockX + ", " + rockY + ")");
				return -1;
			}
			return random(800, 700);
		}
		if(!MineRock(rockX, rockY)) {
			println("MineRock(): Error: no rock at (" + rockX + ", " + rockY + ")");
			return -1;
		}
		return random(800, 500);
	}

	private boolean MineRock(int x, int y)
	{
		int index = getObjectAt(x, y);
		if(index == -1) return false;	// nothing found where that rock should be

		if(!getObjectCommand1(getObjectType(index)).equalsIgnoreCase("Mine"))		// check if it's really a mining rock
			return false;				// not a mining rock

		objectCommand1(index);

		return true;	// success
	}

};
