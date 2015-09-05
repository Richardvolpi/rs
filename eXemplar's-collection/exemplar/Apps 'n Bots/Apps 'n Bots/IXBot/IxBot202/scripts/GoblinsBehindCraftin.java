// AutoFighter at hobogoblins behind crafting guild
// This is what your bots should look like, anything else is crap
//  -evo-
public class GoblinsBehindCraftin extends AutoFighter
{

	public String[] getCommands()
	{
		return new String[]{"hobs"};
	}

	String EchoPlayerName = null, EchoText = null;
	int messageType = 0;
	public void PrivateChat(String playerName, String chatText)
	{
		println("Dude " + playerName + " told me " + chatText);
		if(EchoPlayerName == null && EchoText == null) {
			messageType++;
			if(messageType == 1) {
				EchoPlayerName = playerName;
				if(playerName.regionMatches(true, 0, "Mod", 0, 3)) EchoText = "Hy " + playerName.substring(4);
				else EchoText = "Hi " + playerName;
			}
			else if(messageType == 2) {
				EchoPlayerName = playerName;
				EchoText = "lol heh";
			}
			else if(messageType == 3) {
				EchoPlayerName = playerName;
				EchoText = "doh";
			}
		}
	}

	public void PlayerChat(int playerId, String chatText, boolean playerReferred)
	{
		int playerIndex = searchPlayerById(playerId);
		if(playerIndex < 0) {
			println("Is there a ghost talking ?!");
			return;
		}
		chatText = chatText.toLowerCase();
		if(playerReferred && (chatText.indexOf("auto") != -1 || chatText.indexOf("report") != -1 || chatText.indexOf("bot") != -1 || chatText.indexOf("macro") != -1 )) {
			String playerName = getPlayerName(playerIndex);
			println("Dude " + playerName + " is bothering me => forcedExit");
			ForcedScriptSuspension();
		}
	}

	private int eatingThreshold = 20;
	private boolean ForcedExit = false;
	private int wantsToPickupItem = -1;
	private Section BigSection = null;		// the section we're fighting in
	public boolean start(String command, String parameters[])
	{
		if(!super.start(command, parameters)) return false;
		EnableSuspension();				// allow script to be autostopped
		DisableAutoRetreat();			// of course we don't want to retreat when autofighting
		enableCustomSleeping();

		if(BigSection == null) {
			// create section of hobogoblin isle
			BigSection = new Section();
			BigSection.AllocatePoints(32);
			BigSection.pointArrayX[0] = 353; BigSection.pointArrayY[0] = 625;
			BigSection.pointArrayX[1] = 350; BigSection.pointArrayY[1] = 625;
			BigSection.pointArrayX[2] = 350; BigSection.pointArrayY[2] = 618;
			BigSection.pointArrayX[3] = 351; BigSection.pointArrayY[3] = 617;
			BigSection.pointArrayX[4] = 353; BigSection.pointArrayY[4] = 617;
			BigSection.pointArrayX[5] = 354; BigSection.pointArrayY[5] = 616;
			BigSection.pointArrayX[6] = 355; BigSection.pointArrayY[6] = 616;
			BigSection.pointArrayX[7] = 356; BigSection.pointArrayY[7] = 615;
			BigSection.pointArrayX[8] = 358; BigSection.pointArrayY[8] = 615;
			BigSection.pointArrayX[9] = 360; BigSection.pointArrayY[9] = 613;
			BigSection.pointArrayX[10] = 360; BigSection.pointArrayY[10] = 612;
			BigSection.pointArrayX[11] = 361; BigSection.pointArrayY[11] = 611;
			BigSection.pointArrayX[12] = 361; BigSection.pointArrayY[12] = 608;
			BigSection.pointArrayX[13] = 362; BigSection.pointArrayY[13] = 607;
			BigSection.pointArrayX[14] = 362; BigSection.pointArrayY[14] = 605;
			BigSection.pointArrayX[15] = 361; BigSection.pointArrayY[15] = 604;
			BigSection.pointArrayX[16] = 361; BigSection.pointArrayY[16] = 602;
			BigSection.pointArrayX[17] = 362; BigSection.pointArrayY[17] = 601;
			BigSection.pointArrayX[18] = 365; BigSection.pointArrayY[18] = 601;
			BigSection.pointArrayX[19] = 367; BigSection.pointArrayY[19] = 603;
			BigSection.pointArrayX[20] = 367; BigSection.pointArrayY[20] = 606;
			BigSection.pointArrayX[21] = 366; BigSection.pointArrayY[21] = 607;
			BigSection.pointArrayX[22] = 366; BigSection.pointArrayY[22] = 608;
			BigSection.pointArrayX[23] = 361; BigSection.pointArrayY[23] = 613;
			BigSection.pointArrayX[24] = 361; BigSection.pointArrayY[24] = 615;
			BigSection.pointArrayX[25] = 359; BigSection.pointArrayY[25] = 617;
			BigSection.pointArrayX[26] = 359; BigSection.pointArrayY[26] = 619;
			BigSection.pointArrayX[27] = 358; BigSection.pointArrayY[27] = 620;
			BigSection.pointArrayX[28] = 356; BigSection.pointArrayY[28] = 620;
			BigSection.pointArrayX[29] = 354; BigSection.pointArrayY[29] = 622;
			BigSection.pointArrayX[30] = 354; BigSection.pointArrayY[30] = 623;
			BigSection.pointArrayX[31] = 353; BigSection.pointArrayY[31] = 624;
			if(!BigSection.CreateMap()) {
				println("Failed to create map.");
				return false;
			}
		}
		wantsToPickupItem = -1;
		ForcedExit = false;
		pickUpWait = false;
		preSleepingWait = false;
		forcedRanFromEnemy = false;
		stuckCounter = 0;
		messageType = 0;
		EchoPlayerName = null; EchoText = null;
		messageWaitTicks = -1;
		
		eatingThreshold = 20;

		fishType = COOKEDTUNA;

		for(int i = 0; i < parameters.length; i++) {
			if(parameters[i].regionMatches(true, 0, "hp=", 0, 3)) {	// eating threshold
				eatingThreshold = Integer.parseInt(parameters[i].substring(3));
				println("Eating threshold at " + eatingThreshold + " hitpoints");
			}
			else println("Skipping unknown parameter " + parameters[i]);
		}

		return true;
	}

	public String FoeName()
	{
		return "Hobgoblin";
	}

	public boolean IsRetreating()
	{
		return true;
	}

	public int TypeMatches(int monId)
	{
		if(monId == 67) return 0;
		else return -1;
	}

	public boolean IsAggressive(int monId, int health)
	{
		if(health == 1) return false;
		else return true;
	}

	TileCoord somePoint = new TileCoord(352, 622);
	public int GetSector(int posX, int posY)
	{
		if(BigSection.Contains(posX, posY)) return 1;		// big room with rats
		else if(somePoint.distanceFrom(new TileCoord(posX, posY)) < 100) return 10;		// somewhere near hobo place
		else if(inArea(354, 601, 367, 621)) return 100;		// big box around fighting area, since hobos CAN! go one step into forbidden areas
		else return -1;
	}

	public boolean ValidateCoordinates(int posX, int posY)
	{
		int sector = GetSector(posX, posY);
		return sector >= 1 && sector <= 100;
	}

	private int lastDist = -1;
	public void CancelAttack() { lastDist = -1; }		// called when monster was attacked by someone else

	int stuckCounter = 0;
	public int CheckReachable(int mySector, int monSector, int dist, int foeX, int foeY)
	{
		if(monSector == 100 || mySector == 100) println("Note: entered forbidden area!!");
		if(!isWalking()) {
			stuckCounter++;
			if(stuckCounter > 7) {
				println("I'm stuck - trying to free myself ...");
				walkTo(playerX(), playerY(), 2);
				stuckCounter = 0;
				return random(700, 500);
			}
		}
		else stuckCounter = 0;		// reset
		if(dist > 40) {
			boolean walkingWrongWay = (lastDist != -1 && lastDist < dist);
			lastDist = dist;
			if(isWalking() && !walkingWrongWay) return random(200, 200);
			if(!walkTo(foeX, foeY, 2, BigSection)) {		// need to walk near that npc
				// not reachable => walk somewhere into the "center" where we can reach either side
				if(!walkToArea(358, 615, 359, 618)) {
					println("Foe not reachable at (" + foeX + "," + foeY + "); thisPlayer=(" + playerX() + "," + playerY() + ")");
					return -1;		// was not reachable
				}
			}
			return random(700, 500);
		}
		return 0;
	}

	public boolean IsInCenter(int posX, int posY)
	{
		return wantsToPickupItem != -1 || inArea(363, 602, 366, 607);
	}

	public int WalkCenter(int curSector)
	{
		// walk somewhere in the center
		if(!walkToArea(363, 602, 366, 607)) {
			walkToArea(358, 615, 359, 618);
		}
		return random(500, 500);
	}

	public int IdleAction()
	{
		int randTest = random(0, 9);
		if(randTest < 2) {
			walkToArea(363, 602, 366, 607);		// walk around in center....
			return random(500, 500);
		}
		else if(randTest == 3 && getSkillLevelCurrent(3) < eatingThreshold+10) {
			DoEat();
			return random(500, 500);
		}
		return random(200, 200);
	}

	public boolean goodItem(int itemType)
	{
		// coins, law runes, chaos rune, nature runes, cosmic runes, death rune
		if(itemType == 10 || itemType == 46 || itemType == 40 || itemType == 41 || itemType == 42 || itemType == 38) {
			if(numInvItems() < 30 || numInvItem(itemType) > 0) {	// for stackable items!
				return true;
			}
			else return false;
		}
		else if(numInvItems() < 30 && (itemType == 157 || itemType == 158)) {		// uncut ruby or diamond
			return true;
		}
		else if(numInvItems() < 28 && itemType == 220) return true;		// limpwurt root and we have lots of space
		else return false;
	}

	boolean pickUpWait = false;
	public int PreLookForNewMonster(int curSector)
	{
		if(SuspensionRequested()) {
			println("A higher force told me to stop => ForceExit");
			ForcedExit = true;
			return random(200, 200);
		}
		if(fatigueLevel() >= 99) {
			println("Meh needs some sleep (" + fatigueLevel() + "%) => ForcedExit");
			ForcedExit = true;
			return random(200, 200);
		}
		if(wantsToPickupItem != -1) return 0;		// wait till we happily picked up that item
		lastDist = -1;

		int hitPoints = getSkillLevelCurrent(3);		// current hp
		if(hitPoints <= eatingThreshold || (hitPoints <= eatingThreshold+10 && ForcedExit)) {
			// need to eat urgently
			pickUpWait = false;
			if(!DoEat()) {
				println("Out of food => ForcedExit");
				ForcedExit = true;
				return random(200, 200);
			}
			return random(400, 400);
		}
		if(pickUpWait) {
			pickUpWait = false;
			return 450;
		}

		// pick up all stuff that lies below me
		int itemIdx = -1;
		for(int i = 0; i < numGroundItems(); i++) {
			if(getGroundItemPos(i).equals(playerX(), playerY())) {	// just lying below us?
				int itemType = getGroundItemType(i);
				if(goodItem(itemType)) {
					itemIdx = i;
					break;
				}
			}
		}
		if(itemIdx == -1) return 0;		// found none
		takeGroundItem(itemIdx);
		return random(700, 700);
	}

	public int DoWhileNotFighting()
	{
		// idle action: pick up near items
		if(isWalking()) return random(200, 200);
		if(wantsToPickupItem != -1) {
			// pick up all stuff that lies below me
			int itemIdx = -1;
			for(int i = 0; i < numGroundItems(); i++) {
				if(getGroundItemPos(i).equals(playerX(), playerY())) {	// just lying below us?
					int itemType = getGroundItemType(i);
					if(goodItem(itemType)) {
						itemIdx = i;
						break;
					}
				}
			}
			if(itemIdx == -1) {
				wantsToPickupItem = -1;
				return 0;		// found none
			}
			takeGroundItem(itemIdx);
			return random(700, 700);
		}
		// search for nearest item
		int nearstDist = 100;
		int nearstIdx = -1;
		for(int i = 0; i < numGroundItems(); i++) {
			TileCoord pos = getGroundItemPos(i);
			if(GetSector(pos.x, pos.y) == 1) {
				int itemType = getGroundItemType(i);
				if(goodItem(itemType)) {
					int dist = pos.distanceFrom(new TileCoord(playerX(), playerY()));
					if(dist < nearstDist) {
						nearstIdx = i;
						nearstDist = dist;
					}
				}
			}
		}
		if(nearstIdx != -1) {
			wantsToPickupItem = nearstIdx;
			takeGroundItem(nearstIdx);
			return random(700, 700);
		}
		return 0;
	}

	// hook for our own routines
	boolean forcedRanFromEnemy = false;
	public long runCombat(long ticks)
	{
		if(SuspensionRequested()) {
			println("runCombat(): A higher force told me to stop => ForceExit");
			ForcedExit = true;
		}
		pickUpWait = true;
		wantsToPickupItem = -1;		// prolly were autoattacked
		long ttwait = super.runCombat(ticks);
		if(ttwait != 0) return ttwait;
		// can do our own stuff here...
		if(ForcedExit) {
			// try to run away from them
			if(!walkToArea(350, 619, 353, 623)) {
				if(!walkToArea(358, 615, 359, 618)) {
					println("Fatal: Couln't reach destination on retreat! playerPos=(" + playerX() + "," + playerY() + ")");
					return -1;
				}
			}
			forcedRanFromEnemy = true;
			return random(500, 500);
		}
		else forcedRanFromEnemy = false;
		return 0;
	}

	public final int SLEEPINGBAG = 1263;
	public boolean UseSleepingBag()
	{
		// issue an accurate search!
		for(int i = 0; i < numInvItems(); i++) {
			if(itemAtSlot(i) == SLEEPINGBAG) {
				itemCommand(i);
				return true;
			}
		}
		return false;	// no sleeping bag found
	}

	boolean preSleepingWait = false;
	long messageWaitTicks = -1;
	public long run(long ticks)
	{
		if(EchoPlayerName != null) {
			if(messageWaitTicks == -1) {
				messageWaitTicks = ticks+2000;
			}
			else if(messageWaitTicks < ticks) {
				if(isPlayerOnline(EchoPlayerName)) {
					PrivateMessage(EchoPlayerName, EchoText);
					EchoPlayerName = null;		// read to accept new message
					EchoText = null;
					messageWaitTicks = -1;
					return random(500, 500);
				}
				else {
					AddPlayerToList(EchoPlayerName);
					messageWaitTicks = -1;
					return random(500, 500);
				}
			}
		}
		int result;
		// do sleeping here first
		if(ForcedExit) {
			if(inArea(350, 619, 353, 623)) {		// we're in secure area
				if(fatigueLevel() >= 99) {
					if(!preSleepingWait) {
						EnableSuspension();
						CheckExitRequest();
						preSleepingWait = true;
						println("GobFighter: preSleepingWait....");
						if(forcedRanFromEnemy) {
							forcedRanFromEnemy = false;
							return random(5000, 2000);		// wait a little longer...
						}
					}
					else {
						DisableSuspension();
						preSleepingWait = false;		// reset
						println("GobFighter: use sleepingBag....");
						if(!UseSleepingBag()) {
							println("GobFighter: No sleeping bag found - Halting");
							return -1;
						}
					}
					return random(2000, 1000);
				}
				else if(NumFood() == 0) {		// walk to fally and bank...
					EnableSuspension();
					ForcedExit = false;			// reset
					println("Walk to fally...");
					runWalkingScriptBack(FaladorToHobsX, FaladorToHobsY);
					return 100;		// just wait 100 ms
				}
				else if(SuspensionRequested()) {
					// waiting for toplayer script to terminate this
					EnableSuspension();
					return random(500, 500);
				}
				else ForcedExit = false;		// no need to stay there anymore...
			}
			else {		// walk into secure area
				DisableSuspension();
				if(isWalking()) return random(200, 200);
				if(!walkToArea(350, 619, 353, 623)) {
					if(!walkToArea(358, 615, 359, 618)) {
						println("Fatal: Couln't reach destination on retreat! playerPos=(" + playerX() + "," + playerY() + ")");
						return -1;
					}
				}
				return random(500, 500);
			}
		}
		EnableSuspension();
		if(GetSector(playerX(), playerY()) >= 1) {
			DisableSuspension();			// disable when autofighting
			return super.run(ticks);		// let AutoFighter do the work
		}
		else if(inArea(280, 564, 286, 573)) {	// in bank, fally south
			if(numInvItems() < 30 || NumFood() == 0) {		// not full yet (with food) or none food at all
				println("Bank - starting bank acoount manager");
				openBankAccount();
				return 100;
			}
			if(isWalking()) return random(200, 200);		// refuse further commands while walking
			else if((result=checkDoorOpen(287, 571)) != 0) return result;	// check if bank door is open
			else {	// walk outside of bank
				if(!walkTo(291, 578, 2)) {
					println("Error: area outside of bank not reachable");
					return -1;
				}
				return random(1000, 1000);		// wait 1-2 seconds
			}
		}
		// anywhere between bank and the hobogobs
		else if(NumFood() == 0) {		// need food, so travel to fally bank
			if(isWalking()) return random(200, 200);		// refuse further commands while walking
			else if((result=checkDoorOpen(287, 571)) != 0) return result;	// check if bank door is open
			else if(walkToArea(280, 564, 286, 573)) return random(1000, 1000);		// walk into bank
			else if((result=findWayTo(287, 571, 290, 574)) > 0) return result;		// still too far from bank...
			else if(result == 0) {
				println("Fatal: just infront of bank but couldn't enter it :-/");
				return -1;
			}
			else {			// our last possibility we have to is to ask the leet walkingscript algorithm
				runWalkingScriptBack(FaladorToHobsX, FaladorToHobsY);
				return 100;		// just wait 100 ms
			}
		}
		else {		// walk back to hobogobs
			if((result=findWayTo(350, 619, 353, 623)) > 0) return result;	// can reach it?
			else if(result == 0) {
				println("Fatal: findWayTo said we're in that area, but getSector said no! :S");
				return -1;
			}
			else {		// ask teh walkingscript b0t
				runWalkingScript(FaladorToHobsX, FaladorToHobsY);
				return 100;		// just wait 100 ms
			}

		}
	}

	// ******** Banking script here (most of it was copied from Script.jpp) *********
	private int bankTypes[] = { 157, 158, 220 };		// rubies and diamonds and limpwurt root
	private int lastDeposit = -1;
	private java.util.HashSet bankItems = new java.util.HashSet();	// keep track of all the items we're about to bank - just to display some stats
	int COOKEDTUNA = 367, COOKEDSWORD = 370, COOKEDLOBSTER = 373;
	int fishType = COOKEDTUNA;		// the fish we're using...
	public int bankRun() {
		// deposit all types of items specified in bankTypes
		for(int i = 0; i < bankTypes.length; i++) {
			if(numInvItem(bankTypes[i]) > 0) {		// do we have items of this type in our inventory
				bankItems.add(new Integer(bankTypes[i]));
				if(lastDeposit != -1 && lastDeposit != i) {
					lastDeposit = i;
					return random(1000, 500);			// "simulate" selecting another item
				}
				int result = depositItem(bankTypes[i]);
				if(result < 0) return -1;		// something went wrong
				if(result > 0) return random(150, 150);	// wait a lil time before next command is sent
			}
		}
		// now withdraw the fishes...
		if(numInvItems() < 30) {
			if(lastDeposit != -1) {
				lastDeposit = -1;		// reset!
				return random(1000, 500);		// wait some time before withdrawing
			}
			if(withdrawItem(fishType) <= 0) {
				println("Failed to withdraw " + getItemName(fishType) + " - maybe no more left ...");
				if(fishType == COOKEDTUNA) fishType = COOKEDLOBSTER;
				else if(fishType == COOKEDLOBSTER) fishType = COOKEDSWORD;
				else {
					println("Halting - no cooked food found");
					closeBankAccount();
					return -1;
				}
			}
			return random(150, 150);
		}
		// obviously we're done
		closeBankAccount();
		// now print some info about items in bank, since we want to know whats going on ;-)
		java.util.Calendar tim = java.util.Calendar.getInstance();
		print("Bankmgr finished [" + tim.get(tim.HOUR_OF_DAY) + ":" + tim.get(tim.MINUTE) + ":" + tim.get(tim.SECOND) + "]: ");
		for(int i = 0; i < bankTypes.length+1; i++) {
			int itemType;
			if(i < bankTypes.length) itemType = bankTypes[i];
			else itemType = fishType;
			if(bankItems.contains(new Integer(itemType)) || itemType == fishType) {
				int bankSlot = findBankItem(itemType);
				if(bankSlot < 0) continue;		// item was not found in bank
				int numItems = bankItemAmount(bankSlot);		// number of items in bank
				if(numItems > 0) print(numItems + " " + getItemName(itemType) + "; ");
			}
		}
		println("");		// new line
		CheckExitRequest();
		return random(500, 300);
	}

	// way from bank south falador to hobos behind crafting guild
	int FaladorToHobsX[] = { 287, 291, 325, 337, 348 };
	int FaladorToHobsY[] = { 572, 583, 613, 621, 622 };

}
