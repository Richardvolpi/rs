public class MineSouthFally extends AutoMine
{

	public String[] getCommands()
	{
		return new String[]{"fallymine"};
	}

	public void init() { }

	// clay rocks
	int ClayX[] = { 306 };
	int ClayY[] = { 639 };
	// iron ore
	int IronX[] = { 318, 318 };
	int IronY[] = { 642, 640 };
	// tin
	int TinX[] = { 308 };
	int TinY[] = { 641 };
	// copper ore
	int CopperX[] = { 309, 310, 311, 312 };
	int CopperY[] = { 635, 635, 636, 636 };
	// gold
	int GoldX[] = { 315 };
	int GoldY[] = { 645 };

	public boolean PowerMine = false;
	public boolean start(String command, String parameters[])
	{
		if(!super.start(command, parameters)) return false;
		EnableSuspension();				// allow script to be autostopped
		EnableAutoRetreat();
		disableCustomSleeping(98);		// automatic sleeping - needs sleeping bag in inventory
		// setup mining rocks to mine from
		if(parameters.length == 0) {
			println("Parameter expected for command fallymine: clay, iron, copper, tin, gold");
			return false;
		}
		PowerMine = false;
		for(int i = 0; i < parameters.length; i++) {
			if(parameters[i].equalsIgnoreCase("clay")) {
				AddRockType(114);	// spawned clay rockType
				AddRocks(ClayX, ClayY);
			}
			else if(parameters[i].equalsIgnoreCase("tin")) {
				AddRockType(104);
				AddRocks(TinX, TinY);
			}
			else if(parameters[i].equalsIgnoreCase("copper")) {
				AddRockType(100);
				AddRocks(CopperX, CopperY);
			}
			else if(parameters[i].equalsIgnoreCase("iron")) {
				AddRockType(102);
				AddRocks(IronX, IronY);
			}
			else if(parameters[i].equalsIgnoreCase("gold")) {
				AddRockType(112);
				AddRocks(GoldX, GoldY);
			}
			else if(parameters[i].equalsIgnoreCase("power")) {
				PowerMine = true;		// don't bank
			}
			else println("Skipping unknown parameter " + parameters[i]);
		}
		println("Mining from " + MineRockX.length + " rocks of " + rockTypes.size() + " different types.");
		return true;
	}

    public void stop() { }

	// catch the server messages
	public void ServerMessage(String message)
	{
		super.ServerMessage(message);	// call method from superclass
	}

	public long run(long ticks)
	{
		int result;
		if(inArea(305, 634, 319, 646)) {	// at south fally mining site
			int timeToWait;
			if(!PowerMine && numInvItems() == 30) {		// need to go rest or inventory is full
				runWalkingScriptBack(FaladorToMineX, FaladorToMineY);
				return 100;		// just wait 100 ms
			}
			else if((timeToWait=CheckMoveRequest(false)) > 0) return timeToWait;

			timeToWait = MineRock();		// mine teh rocks
			if(timeToWait == -1) return -1;		// halt
			else if(timeToWait == 0) return random(300, 200);	// nothing was done in MineRock(), so just wait some time
			else return timeToWait;			// return the time MineRocks() wants to wait
		}
		else if(inArea(280, 564, 286, 573)) {	// in bank, fally south
			if(numInvItems() > 3) {		// anything to deposit?
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
		// anywhere between bank and mining site
		else if(!PowerMine && numInvItems() == 30) {		// we're full, so travel to fally bank
			if(isWalking()) return random(200, 200);		// refuse further commands while walking
			else if((result=checkDoorOpen(287, 571)) != 0) return result;	// check if bank door is open
			else if(walkToArea(280, 564, 286, 573)) return random(1000, 1000);		// walk into bank
			else if((result=findWayTo(287, 571, 290, 574)) > 0) return result;		// still too far from bank...
			else if(result == 0) {
				println("Fatal: just infront of bank but couldn't enter it :-/");
				return -1;
			}
			else {			// our last possibility we have to is to ask the leet walkingscript algorithm
				runWalkingScriptBack(FaladorToMineX, FaladorToMineY);
				return 100;		// just wait 100 ms
			}
		}
		else {		// walk back to mining site
			if((result=findWayTo(305, 634, 319, 646)) > 0) return result;	// can reach the mining site ?
			else if(result == 0) {
				println("Fatal: findWayTo said we're in that area, but inArea said no!");
				return -1;
			}
			else {		// ask teh walkingscript b0t
				runWalkingScript(FaladorToMineX, FaladorToMineY);
				return 100;		// just wait 100 ms
			}

		}
	}

	// way from bank south falador to mine south of falador
	int FaladorToMineX[] = { 287, 291, 306 };
	int FaladorToMineY[] = { 572, 583, 631 };
};
