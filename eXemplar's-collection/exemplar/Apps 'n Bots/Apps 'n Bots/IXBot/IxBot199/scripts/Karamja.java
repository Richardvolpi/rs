// autofishing in karamja - the type of fish being fished depends on whether there's harpoon or lobster pot 
// in inventory
// Jan-18-2004 -evo-
public class Karamja extends Script
{
	// some item IDs
	int LOBSTERPOT = 375;
	int HARPOON	= 379;
	int CASH = 10;
	int RAWTUNA = 366, RAWSWORD = 369, RAWLOBSTER = 372;

	public String[] getCommands()
	{
		return new String[]{"karamja"};
	}

	// bank all kinds of fish
	private int bankItems[] = { RAWTUNA, RAWSWORD, RAWLOBSTER };
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();				// allow script to be autostopped
		EnableAutoRetreat();
		enableCustomSleeping();			// no automatic sleeping - do this in fallador
		boardedShip = false;
		captainBusy = false;
		wokeUpRest = false;
		startedToRest = false;
		setBankTypes(bankItems);	// initialize standard implementation of banking
		return true;
	}

	boolean captainBusy = false;
	boolean startedToRest = false;
	boolean wokeUpRest = false;
	// catch the server messages
	public void ServerMessage(String message)
	{
		if(message.regionMatches(true, 0, "@gam@You catch", 0, 14)) {
			println("Obtain Fish: " + numInvItems() + " Items in inventory (" + fatigueLevel() + "%)");
		}
		else if(message.equalsIgnoreCase("@que@The ship arrives at Port Sarim")) {
			println("Arrived in Port Sarim.");
			boardedShip = false;
			captainBusy = false;
			EnableSuspension();
		}
		else if(message.equalsIgnoreCase("@que@The ship arrives at Karamja")) {
			println("Arrived in Karamja.");
			boardedShip = false;
			captainBusy = false;
			EnableSuspension();
		}
		else if(message.regionMatches(true, 0, "@que@You need to talk to", 0, 24))
			captainBusy = true;
		else if(message.regionMatches(true, 0, "@gam@I need to speak to the", 0, 27))
			captainBusy = true;
		else if(message.equalsIgnoreCase("@que@You rest on the bed"))
			startedToRest = true;
		else if(message.equalsIgnoreCase("@que@You feel much less tired now"))
			wokeUpRest = true;
	}

	public long run(long ticks)
	{
		EnableSuspension();
		int result;			// some misc variable
		boolean goBankSleep = isTooTired() || numInvItems() > 15;	// do sleeping/banking trip to fally...
		if(inArea(369, 679, 372, 691)) {	// karamja fishing docks
			int timeToWait;
			if(isTooTired() || numInvItems() == 30) {		// need to go rest or inventory is full
				if(isTooTired()) println("Too tired to fish...looking for bed (" + fatigueLevel() + "%)");
				else println("Inventory full while fishing - walk back to falador");
				runWalkingScriptBack(wayPointsXKarm, wayPointsYKarm);
				return 100;
			}
			else if((timeToWait=CheckMoveRequest(false)) > 0) return timeToWait;

			if(numInvItem(LOBSTERPOT) > 0) objectCommand2At(368, 684, "Cage");
			else if(numInvItem(HARPOON) > 0) objectCommand1At(368, 684, "Harpoon");
			else {
				println("Uhm dunno what to fish:/ - gimme a lobster pot or harpoon");
				return -1;
			}
			return random(1200, 700);
		}
		else if(distanceFrom(326, 710) < 12*12) {		// (near) karamja port
			// wait till objects are loaded.....
			if((result=getObjectAt(326, 710)) == -1 || getObjectType(result) != 161) {
				println("Warning: Objects not loaded yet!");
				return random(400, 400);
			}
			if(goBankSleep) {
				if(distanceFrom(326, 710) > 8*8) {		// need to walk a bit nearer...
					if(isWalking()) return random(200, 200);
					walkToArea(328, 713, 333, 713);
					return random(1000, 1000);
				}
				else {	// board boat, etc...
					return BoardShipToPortSarim();
				}
			}
			else {		// walk back to fishing docks
				runWalkingScript(wayPointsXKarm, wayPointsYKarm);
				return 100;		// just wait 100 ms
			}
		}
		else if(inArea(332, 690, 377, 719)) {		// somewhere on karamja
			if(goBankSleep) runWalkingScriptBack(wayPointsXKarm, wayPointsYKarm);
			else runWalkingScript(wayPointsXKarm, wayPointsYKarm);
			return 100;
		}
		else if(distanceFrom(265, 650) < 12*12) {		// (near) port sarim ship to karamja
			// wait till objects are loaded.....
			if((result=getObjectAt(265, 650)) == -1 || getObjectType(result) != 156) {
				println("Warning: Objects not loaded yet!");
				return random(400, 400);
			}
			if(goBankSleep) {	// walk to fally
				runWalkingScriptBack(wayPointsXPort, wayPointsYPort);
				return 100;		// just wait 100 ms
			}
			else {
				if(distanceFrom(265, 650) > 8*8) {		// need to walk a bit nearer...
					if(isWalking()) return random(200, 200);
					walkToArea(268, 646, 270, 651);
					return random(1000, 1000);
				}
				else {	// board boat, etc...
					return BoardShipToKaramja();
				}
			}
		}
		else if(inArea(280, 564, 286, 573)) {		// in bank, south fally
			if(numInvItems() > 3) {		// anything to deposit?
				println("Bank - starting bank acoount manager");
				openBankAccount();
				return 100;
			}
			if(isWalking()) return random(200, 200);		// refuse further commands while walking
			else if((result=checkDoorOpen(287, 571)) != 0) return result;	// check if bank door is open
			else {	// walk outside of bank
				if(!walkTo(289, 578, 2)) {
					println("Error: area outside of bank not reachable");
					return -1;
				}
				return random(1000, 1000);		// wait 1-2 seconds
			}
		}
		else if(inArea(295, 577, 299, 580)) {		// we are in house with bed!
			if(fatigueLevel() > 0) {
				if(!startedToRest) {
					println("Going to sleep......");
					if(!objectCommand1At(298, 579, "rest")) {
						println("Error using bed - Halting");
						return -1;
					}
					else return random(1000, 1000);
				}
				else if(wokeUpRest) {
					println("Woke up again...");
					wokeUpRest = false;
					startedToRest = false;
					return random(500, 500);
				}
				else return random(200, 200);		// wait for next action of server
			}
			else {
				println("Fatigue = 0 -> back to work.");
				wokeUpRest = false;	// reset for next use
				startedToRest = false;
				if(isWalking()) return random(200, 200);
				else if((result=checkDoorOpen(297, 577)) != 0) return result;
				else if(numInvItems() > 3) {	// walk into bank
					println("Walk into Bank...");
					if((result=checkDoorOpen(287, 571)) != 0) return result;	// bank door open?
					else if(!walkToArea(283, 568, 286, 572)) {	// walk directly in bank
						println("Error: area outside of bed house not reachable");
						return -1;
					}
					return random(1000, 1000);		// wait 1-2 seconds
				}
				else {
					// walk somewhere outside
					if(!walkTo(290, 584, 2)) {
						println("Error: area outside of bed house not reachable");
						return -1;
					}
					else return random(1000, 1000);		// wait 1-2 seconds
				}
			}
		}
		else if(inArea(280, 564, 300, 585)) {		// in south fally
			if(isWalking()) return random(200, 200);		// refuse further commands while walking
			if(fatigueLevel() > 0) {	// go sleep
				if((result=checkDoorOpen(297, 577)) != 0) return result;	// check if door is open
				else if(walkToArea(296, 577, 297, 580)) return random(1000, 1000);	// walk into bed house
				else {
					println("Unable to reach bed house :-/");
					return -1;
				}
			}
			else if(numInvItems() > 3) {		// walk into bank
				if((result=checkDoorOpen(287, 571)) != 0) return result;	// check if bank door is open
				else if(walkToArea(280, 564, 286, 573)) return random(1000, 1000);	// walk into bank
				else {
					println("Unable to reach Bank :-/");
					return -1;
				}
			}
			else {		// walk back to karamja
				runWalkingScript(wayPointsXPort, wayPointsYPort);
				return 100;
			}
		}
		else if(inArea(264, 581, 296, 657)) {		// somewhere between port sarim and south fally
			if(goBankSleep) {	// walk to southFally
				runWalkingScriptBack(wayPointsXPort, wayPointsYPort);
			}
			else {		// try to find a way back to karamja
				runWalkingScript(wayPointsXPort, wayPointsYPort);
			}
			return 100;
		}
		else {
			println("Karamja Autofish: unknown location (" + playerX() + ", " + playerY() + ")");
			return -1;
		}
	}

	private boolean reactionTime = false;		// human reaction time on new event :P
	private int timeOutCounter = 0;
	private boolean boardedShip = false;

	public int BoardShipToPortSarim()
	{
		DisableSuspension();		// do not suspend while in here
		if(isDialogShown()) {	// we're currently talking with customer
			if(reactionTime) { reactionTime = false; return random(500, 500); }
			if(chooseDialogItem("Search away I have nothing to hide")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else if(chooseDialogItem("Ok")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else {
				println("BoardShipToPortSarim(): Dialog item not found!");
				displayDialogItems();		// some debug information
				hideDialog();
				boardedShip = false;		// board ship again
				captainBusy = false;
				return random(3000, 1000);
			}
		}
		if(!boardedShip) {
			// check if enough money
			if(numInvItem(CASH) < 100) {
				println("BoardShipToPortSarim(): Not enough money for trip to port sarim!");
				return -1;
			}
			// randomly select ship to board (either at (326, 710) or at (324, 710))
			int shipX;
			if(oneIn(2)) shipX = 326;
			else shipX = 324;
			println("Boarding ship...");
			if(!objectCommand1At(shipX, 710, "board")) {
				println("BoardShipToPortSarim(): Boarding ship failed! - Halting");
				return -1;		// halt script
			}

			captainBusy = false;
			reactionTime = true;
			boardedShip = true;
			timeOutCounter = 0;
			return random(400, 400);
		}
		if(captainBusy) {
			println("Customer is busy.");
			boardedShip = false;
			return random(400, 400);
		}

		// we're waiting for next event being sent from server
		if(timeOutCounter++ > 12) {
			println("BoardShipToPortSarim(): Timeout - reboard");
			boardedShip = false;
		}
		return random(400, 400);		// just wait some time
	}

	public int BoardShipToKaramja()		// must be in port sarim near the ship to karamja
	{
		DisableSuspension();		// do not suspend while in here
		if(isDialogShown()) {	// we're currently talking with captain
			if(reactionTime) { reactionTime = false; return random(500, 500); }
			if(chooseDialogItem("Yes please")) {
				timeOutCounter = 0;
				reactionTime = true;
				return random(700, 500);
			}
			else {
				println("BoardShipToKaramja(): Dialog item not found!");
				displayDialogItems();		// some debug information
				hideDialog();
				boardedShip = false;		// board ship again
				captainBusy = false;
				return random(3000, 1000);
			}
		}
		if(!boardedShip) {
			// check if enough money
			if(numInvItem(CASH) < 100) {
				println("BoardShipToKaramja(): Not enough money for trip to port sarim!");
				return -1;
			}
			// randomly select ship to board (either at (265, 645) or at (265, 650))
			int shipY;
			if(oneIn(2)) shipY = 645;
			else shipY = 650;
			println("Boarding ship...");
			if(!objectCommand1At(265, shipY, "board")) {
				println("BoardShipToKaramja(): Boarding ship failed! - Halting");
				return -1;		// halt script
			}

			captainBusy = false;
			resetNpcBusy();
			reactionTime = true;
			boardedShip = true;
			timeOutCounter = 0;
			return random(400, 400);
		}
		if(captainBusy) {
			println("Captain is busy (board).");
			boardedShip = false;
			// search for (alternative) seaman we can talk to
			for(int i = 0; i < numNpcs(); i++) {
				if(getNpcName(getNpcType(i)).regionMatches(true, 0, "Seaman ", 0, 7) && getNpcPos(i).inArea(268, 645, 272, 656)) {
					talkToNpc(i);
					captainBusy = false;
					reactionTime = true;
					boardedShip = true;
					timeOutCounter = 0;
					break;
				}
			}
			return random(400, 400);
		}
		else if(isNpcBusy()) {
			println("Captain is busy (direct talk).");
			boardedShip = false;
			captainBusy = false;
			resetNpcBusy();
			return random(400, 400);
		}

		// we're waiting for next event being sent from server
		if(timeOutCounter++ > 12) {
			println("BoardShipToKaramja(): Timeout - reboard");
			boardedShip = false;
		}
		return random(400, 400);		// just wait some time
	}

	// way from bank south falador to docks at port sarim
	int wayPointsXPort[] =	{ 290, 280, 270, 269, 269 };
	int wayPointsYPort[] =	{ 580, 609, 624, 637, 644 };

	// way from harbour to fishing docks on karamaja isle
	int wayPointsXKarm[] =	{ 334, 341, 352, 365, 370 };
	int wayPointsYKarm[] =	{ 713, 711, 704, 699, 687 };

}
