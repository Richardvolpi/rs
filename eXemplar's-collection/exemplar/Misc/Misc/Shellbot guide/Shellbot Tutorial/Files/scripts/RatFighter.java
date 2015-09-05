// Autofighter at rats in melzars'
public class RatFighter extends AutoFighter
{

	public String[] getCommands()
	{
		return new String[]{"ratfight"};
	}

	private Section RatSection = null;		// the section we're fighting in
	public boolean start(String command, String parameters[])
	{
		if(!super.start(command, parameters)) return false;
		EnableSuspension();				// allow script to be autostopped
		DisableAutoRetreat();			// of course we don't want to retreat when autofighting
		disableCustomSleeping(99);		// automatic sleeping - needs sleeping bag in inventory

		if(RatSection == null) {
			// create section of the big room with the rats
			RatSection = new Section();
			RatSection.AllocatePoints(10);
			RatSection.pointArrayX[0] = 338; RatSection.pointArrayY[0] = 631;
			RatSection.pointArrayX[1] = 340; RatSection.pointArrayY[1] = 631;
			RatSection.pointArrayX[2] = 340; RatSection.pointArrayY[2] = 626;
			RatSection.pointArrayX[3] = 345; RatSection.pointArrayY[3] = 626;
			RatSection.pointArrayX[4] = 345; RatSection.pointArrayY[4] = 628;
			RatSection.pointArrayX[5] = 348; RatSection.pointArrayY[5] = 628;
			RatSection.pointArrayX[6] = 348; RatSection.pointArrayY[6] = 636;
			RatSection.pointArrayX[7] = 340; RatSection.pointArrayY[7] = 636;
			RatSection.pointArrayX[8] = 340; RatSection.pointArrayY[8] = 633;
			RatSection.pointArrayX[9] = 338; RatSection.pointArrayY[9] = 633;
			if(!RatSection.CreateMap()) {
				println("Failed to create map.");
				return false;
			}
		}
		
		return true;

/*
					players[curPlayer].NoCoolBot = true;
					players[curPlayer].CameFromOtherArea = 0;
					players[curPlayer].CrowdedPlace = 0;
					ExitRequest = 0;
					ForcedExit = false; */
	}

	public String FoeName()
	{
		return "Rat";
	}

	public boolean IsRetreating()
	{
		return true;
	}

	public int TypeMatches(int monId)
	{
		if(monId == 47 || monId == 177) return 0;		// these are rats in melzars'
		else return -1;
	}

	public boolean IsAggressive(int monId, int health)
	{
		if(health == 1) return false;
		else return true;
	}

	public int GetSector(int posX, int posY)
	{
		if(RatSection.Contains(posX, posY)) return 1;		// big room with rats
		else if(posX >= 345 && posY >= 637 && posX <= 348 && posY <= 638) return 10;		// the little room with da door
		else if(posX == 289 && posY == 632) return -10;		// at exit of maze, just in front of door => force change of scriptStep
		else if(posX == 301 && posY == 629) return -11;		// other side of door to ghosts => force change of scriptStep
		else return -1;
	}

	public boolean ValidateCoordinates(int posX, int posY)
	{
		 return GetSector(posX, posY) >= 1;
	}

	private int lastDist = -1;
	public void CancelAttack() { lastDist = -1; }		// called when monster was attacked by someone else

	public int CheckReachable(int mySector, int monSector, int dist, int foeX, int foeY)
	{
		if(monSector != mySector) {
			// player and foe are not in same sector...check for doors
			if(monSector == 10 || mySector == 10) {
				int timeWait = checkDoorOpen(346, 637);
				if(timeWait != 0) return timeWait;
			}
		}
		// all doors should be open now
		if(dist > 40) {
			boolean walkingWrongWay = (lastDist != -1 && lastDist < dist);
			lastDist = dist;
			if(isWalking() && !walkingWrongWay) return random(200, 200);
			if(!walkTo(foeX, foeY, 2, RatSection)) {		// need to walk near that npc
				println("Foe not reachable at (" + foeX + "," + foeY + "); thisPlayer=(" + playerX() + "," + playerY() + ")");
				return -1;		// was not reachable
			}
			return random(700, 500);
		}
		return 0;
	}

	public boolean IsInCenter(int posX, int posY)
	{
		return inArea(342, 632, 345, 634);
	}

	public int WalkCenter(int curSector)
	{
		// walk somewhere in the center
		if(curSector == 10) {
			int timeWait = checkDoorOpen(346, 637);
			if(timeWait != 0) return timeWait;
		}
		walkToArea(342, 632, 345, 634);
		return random(500, 500);
	}

	public int IdleAction()
	{
		//if(players[curPlayer].CameFromOtherArea > 0) players[curPlayer].CameFromOtherArea--;
		int randTest = random(0, 9);
		if(randTest < 2) {
			walkToArea(342, 632, 345, 634);		// walk around in center....
			return random(500, 500);
		}
		else if(randTest == 3 && getSkillLevelCurrent(3) < 20) {		// Hitpoints < 20
			DoEat();
			return random(500, 500);
		}
		return random(200, 200);
	}

	public int PreLookForNewMonster(int curSector)
	{
		lastDist = -1;
/*		if(curSector < 0) {		// we are in a special sector
			players[curPlayer].scriptStep = 6071;
			// we're leaving this fighting area...
			println("Leaving fighting area...killed " + players[curPlayer].numKilled + " " + FoeName() + "(s)");
			players[curPlayer].CameFromOtherArea = 20;		// count down every 5 secs in IdleAction()
			ExitRequest = 0;		// reset after leaving this fighting area
			return 100;		// to make caller happy:)
		}
		if(!players[curPlayer].NoCoolBot && !ForcedExit) {
			int numPPls = PeopleInArea();	// exit when there's a really massive amount of people
			if(players[curPlayer].attackMissed > 6) {
				println("missed too much attacks => ForcedExit");
				ForcedExit = true;
			}
			if(ExitRequest >= 4) {
				println("ExitRequest reached a value of " + ExitRequest + " => ForcedExit");
				ForcedExit = true;
			}
			if(numPPls >= 6) {
				println("Too many peoples around (" + numPPls + ") => ForcedExit");
				ForcedExit = true;
			}
		} */
		int hitPoints = getSkillLevelCurrent(3);		// current hp
		if(hitPoints <= 10/* || (hitPoints <= 20 && ForcedExit)*/) {
			// need to eat urgently
			if(!DoEat()) {
/*				if(isWalking) return 200 + (java.lang.Math.abs(rnd.nextInt()) % 200);
				// walk to bank!!! so use maze key on maze entrance door
				if(curSector == 10 && !CheckDoorOpen(298, 637)) {	// in sector with door
					OpenDoor(298, 637);
					return 1000 + (java.lang.Math.abs(rnd.nextInt()) % 700);
				}
				else if(curSector != 6) {
					WalkTo(290, 631, 291, 633);		// walk into sector 6 (just in from of exit door)
					return 500 + (java.lang.Math.abs(rnd.nextInt()) % 500);
				}
				else {		// use maze key on door
					int keySlot = GetInventorySlot(421);	// 421 = maze key!
					if(keySlot == -1) {
						println("FATAL: No maze key found - Halting");
						players[curPlayer].scriptStep = -1;
						return 100;
					}
					int doorObj = GetWallObjAtLoc(290, 632);
					if(doorObj != -1 && WALLOBJINDEX[doorObj] == 60) {		// door closed?
						USEWITH_WALLOBJ(keySlot, doorObj);
						return 2500 + (java.lang.Math.abs(rnd.nextInt()) % 1000);
					}
					else if(doorObj != -1 && WALLOBJINDEX[doorObj] == 11) {	// door opened - need to wait till it closes
						println("Waiting for maze door to close.....");
						return 500 + (java.lang.Math.abs(rnd.nextInt()) % 500);
					}
					else {
						println("FATAL: Maze entrance door at (290, 632) not found - Halting");
						players[curPlayer].scriptStep = -1;
						return 100;
					}
				} */
				println("Out of food - halting");
				return -1;
			}
			return random(400, 400);
		}
//		if(players[curPlayer].NoCoolBot) return 0;
/*		boolean walkToGhosts = false;
		// we can go to ghosts, since we just came from bank (or some1 else is taking too much rats)
		if(players[curPlayer].ComeFromBank || ForcedExit) {
			if(players[curPlayer].CameFromOtherArea > 0 && ForcedExit) {	// can go to ghosts?
				SuspendScript();		// force server change!
				return 1000;
			}
			if(ITEMS_IN_INV(390) >= 2) walkToGhosts = true;		// enough red keys?
			else if(INV_SIZE == 30) {
				// need to eat something to get some space
				DoEat();
				return 800 + (java.lang.Math.abs(rnd.nextInt()) % 800);
			}
			else {
				if(isWalking) return 200 + (java.lang.Math.abs(rnd.nextInt()) % 200);
				int redKey = GetNearestItem(390);	// check if there's a red key lying around
				if(redKey != -1) {
					int posX = ITEM_X[redKey]+REGIONX, posY = ITEM_Y[redKey]+REGIONY;
					int _deltaX = (curPosX-posX);
					int _deltaY = (curPosY-posY);
					int time = CheckReachable(curSector, GetSector(posX, posY), _deltaX*_deltaX + _deltaY*_deltaY, 0, 0);
					if(time != 0) return time;		// walked there.....
					TakeItem(redKey);		// pick it up
					return 700 + (java.lang.Math.abs(rnd.nextInt()) % 400);
				}
			}
		}
		if(walkToGhosts) {
			if(isWalking) return 200 + (java.lang.Math.abs(rnd.nextInt()) % 200);
			if(curSector == 10 && !CheckDoorOpen(298, 637)) {	// in sector with door
				OpenDoor(298, 637);
				return 1000 + (java.lang.Math.abs(rnd.nextInt()) % 700);
			}
			else if(curSector != 2) {
				WalkTo(298, 629, 299, 631);		// walk into sector 2 (near that door)
				return 500 + (java.lang.Math.abs(rnd.nextInt()) % 500);
			}
			else {		// use red key on door
				int keySlot = GetInventorySlot(390);	// 390 = red key!
				if(keySlot == -1) {
					println("FATAL: No \"red key\" found, but walkToGhosts == true - Halting");
					players[curPlayer].scriptStep = -1;
					return 100;
				}
				int doorObj = GetWallObjAtLoc(301, 629);
				if(doorObj != -1 && WALLOBJINDEX[doorObj] == 48) {		// door closed?
					USEWITH_WALLOBJ(keySlot, doorObj);
					players[curPlayer].ComeFromBank = true;		// go to rats (needed for "little room script" to know which way to go)
					return 2500 + (java.lang.Math.abs(rnd.nextInt()) % 1000);
				}
				else if(doorObj != -1 && WALLOBJINDEX[doorObj] == 11) {	// door opened - need to wait till it closes
					println("Waiting for ghost door to close.....");
					return 500 + (java.lang.Math.abs(rnd.nextInt()) % 500);
				}
				else {
					println("FATAL: Locked Door (to ghosts) at (301, 629) not found - Halting");
					players[curPlayer].scriptStep = -1;
					return 100;
				}
			}
		} */
		return 0;
	}

}
