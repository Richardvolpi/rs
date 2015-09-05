// autofishing in fishing guild
// Currently only support for sharks
// get a sleepingbag + harpoon and start the script with ##guildfish
// have fun watching. report any errors or strange behaviour please
// make sure you can fish and cook sharks ;)
// -evo-
public class FishingGuild extends Script
{
	// some item IDs
	int HARPOON	= 379;
	final int RAWSHARK = 545, SHARK = 546, BURNTSHARK = 547;

	public String[] getCommands()
	{
		return new String[]{"guildfish"};
	}

	private Section CertHouse = null;
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();				// allow script to be autostopped
		EnableAutoRetreat();
		disableCustomSleeping(95);

		if(CertHouse == null) {
			CertHouse = new Section();
			CertHouse.AllocatePoints(7);
			CertHouse.pointArrayX[0] = 605; CertHouse.pointArrayY[0] = 506;
			CertHouse.pointArrayX[1] = 604; CertHouse.pointArrayY[1] = 506;
			CertHouse.pointArrayX[2] = 602; CertHouse.pointArrayY[2] = 504;
			CertHouse.pointArrayX[3] = 602; CertHouse.pointArrayY[3] = 501;
			CertHouse.pointArrayX[4] = 603; CertHouse.pointArrayY[4] = 500;
			CertHouse.pointArrayX[5] = 604; CertHouse.pointArrayY[5] = 500;
			CertHouse.pointArrayX[6] = 605; CertHouse.pointArrayY[6] = 501;
			if(!CertHouse.CreateMap()) {
				println("Failed to create map.");
				return false;
			}
		}
		talkedToCerter = false;

		return true;
	}

	// catch the server messages
	public void ServerMessage(String message)
	{
		if(message.regionMatches(true, 0, "@gam@You catch a ", 0, 17)) {
			println("Obtain " + message.substring(17) + " : " + numInvItems() + " Items in inventory (" + fatigueLevel() + "%)");
		}
		else if(message.equalsIgnoreCase("@gam@You exchange your fish for certificates")) {
			println("Certs exchanged!");
			talkedToCerter = false;
			EnableSuspension();
		}
	}

	public long run(long ticks)
	{
		EnableSuspension();
		int result;
		if((numInvItems() == 30 || inArea(583, 519, 588, 523)) && numInvItem(RAWSHARK) > 0) {
			// go to cook the raw sharks...
			if(inArea(583, 519, 588, 523)) {
				int slot = getInvSlot(RAWSHARK);
				if(slot < 0) {
					println("Fatal: No raw shark found but numInvItem() > 0!");
					return -1;
				}
				int range = getObjectAt(583, 520);
				if(range == -1 || !getObjectName(getObjectType(range)).equalsIgnoreCase("Range")) {
					println("Fatal: Range not found!");
					return -1;
				}
				useItemWithObject(slot, range);
				return random(2500, 500);
			}
			else {
				result = checkDoorOpen(586, 519);
				if(result > 0) return result;
				else if(result == 0) {
					if(isWalking()) return 200;
					if(walkToArea(583, 519, 588, 523)) return random(1000, 500);
				}
				if(isWalking()) return 200;
				if(walkToArea(586, 506, 587, 508)) return random(1000, 500);	// some point between range house and fishing spot
				if(walkToArea(595, 511, 598, 514)) return random(1000, 500);	// some point between range house and cert house

				println("Unable to find way to cooking range...");
				return -1;
			}
		}
		else if(numInvItem(BURNTSHARK) > 0) {
			// drop the burnt sharks
			int slot = getInvSlotBW(BURNTSHARK);
			if(slot < 0) {
				println("Fatal: No burnt shark found but numInvItem() > 0!");
				return -1;
			}
			println("dropping burnt shark at " + slot + " ...");
			dropItem(slot);
			return random(1000, 500);
		}
		else if(numInvItem(SHARK) >= 5) {
			if(CertHouse.Contains(playerX(), playerY())) {
				// cert the cooked sharks...
				return CertFish();
			}
			else {
				// walk to certing location
				result = checkDoorOpen(603, 506);
				if(result > 0) return result;
				else if(result == 0) {
					if(isWalking()) return 200;
					if(walkToArea(602, 500, 605, 506, CertHouse))
						return random(1000, 500);
				}
				if(isWalking()) return 200;
				if(walkToArea(595, 511, 598, 514)) return random(1000, 500);	// some point between range house and cert house
				if(walkToArea(586, 506, 587, 508)) return random(1000, 500);	// some point between range house and fishing spot
				// maybe we're trapped...
				result = checkDoorOpen(586, 519);	// try to open door of cooking house first
				if(result > 0) return result;
				result = tryToFree();	// try to open any other doors near
				if(result > 0) return result;

				println("Unable to find way to cert house...");
				return -1;
			}
		}
		else if(distanceFrom(593, 501) < 6*6) {
			// fish sharks
			if(isWalking()) return 200;
			int timeToWait;
			if((timeToWait=CheckMoveRequest(false)) > 0) return timeToWait;

			objectCommand2At(593, 501, "Harpoon");
			return random(1200, 700);
		}
		else {
			if(isWalking()) return 200;
			if(walkToArea(592, 502, 598, 503)) return random(1000, 500);	// fishin spot
			if(walkToArea(586, 506, 587, 508)) return random(1000, 500);	// some point between range house and fishing spot
			if(walkToArea(595, 511, 598, 514)) return random(1000, 500);	// some point between range house and cert house
			// maybe we're trapped...
			result = tryToFree();
			if(result > 0) return result;
			println("Unable to find way to fishing spot...");
			return -1;
		}
	}

	private boolean reactionTime = false;		// human reaction time on new event :P
	private int timeOutCounter = 0;
	private boolean talkedToCerter = false;

	public int CertFish()
	{
		DisableSuspension();		// do not suspend while in here
		if(isDialogShown()) {	// we're currently talking with certer
			if(reactionTime) { reactionTime = false; return random(500, 500); }

			String certAmount = "nix";
			int numSharks = numInvItem(SHARK);
			if(numSharks >= 25) certAmount = "Twentyfive";
			else if(numSharks >= 20) certAmount = "Twenty";
			else if(numSharks >= 15) certAmount = "Fifteen";
			else if(numSharks >= 10) certAmount = "ten";
			else if(numSharks >= 5) certAmount = "five";

			if(chooseDialogItem("I have some fish to trade in")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else if(chooseDialogItem("shark")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else if(chooseDialogItem(certAmount)) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else {
				println("CertFish(): Dialog item not found!");
				displayDialogItems();		// some debug information
				hideDialog();
				talkedToCerter = false;		// board ship again
				resetNpcBusy();
				return random(3000, 1000);
			}
		}
		if(!talkedToCerter) {
			println("Talk to certer...");

			for(int i = 0; i < numNpcs(); i++) {
				if(getNpcName(getNpcType(i)).equalsIgnoreCase("Padik")) {
					talkToNpc(i);
					reactionTime = true;
					talkedToCerter = true;
					timeOutCounter = 0;
					return random(400, 400);
				}
			}
			println("CertFish(): Certer Padik not found!");
			return -1;
		}
		else if(isNpcBusy()) {
			println("Certer is busy.");
			talkedToCerter = false;
			resetNpcBusy();
			return random(400, 400);
		}

		// we're waiting for next event being sent from server
		if(timeOutCounter++ > 12) {
			println("CertFish(): Timeout - retalk");
			talkedToCerter = false;
		}
		return random(400, 400);		// just wait some time
	}
//#0: I have some certificates to trade in
//#1: I have some fish to trade in
//#2: What is a fish exchange stall?
//@gam@what sort of fish do you wish to trade in?
//#0: bass
//#1: Raw bass
//#2: shark
//#3: Raw shark
//@gam@How many fishs do you wish to trade in?
//#0: five
//#1: ten
//#2: Fifteen
//#3: Twenty
//#4: Twentyfive

}
