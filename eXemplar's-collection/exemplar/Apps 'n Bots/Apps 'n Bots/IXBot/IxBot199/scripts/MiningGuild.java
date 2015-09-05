// Not working! - use the internal script ##newgd !

public class MiningGuild extends AutoMine
{

	public String[] getCommands()
	{
		return new String[]{"guild"};
	}

	public void init() { }

	int CoalX[] = {  273,  272,  271,  275,  275,  273,  272,  272,  272,  270,  269,  269,  267,  266,  265,  265,  265,  266,  267,  268 };
	int CoalY[] = { 3396, 3397, 3397, 3396, 3395, 3394, 3394, 3392, 3391, 3390, 3391, 3390, 3389, 3387, 3387, 3391, 3394, 3394, 3396, 3396 };
	int MithX[] = {  265,  267,  268 };
	int MithY[] = { 3397, 3399, 3399 };

	public int RockPriority(int rockType) {
		if(rockType == 107) return 10;	// give mithril rocks a higher priority
		else return 0;		// normal priority
	}

	public boolean start(String command, String parameters[])
	{
		if(!super.start(command, parameters)) return false;
		EnableSuspension();				// allow script to be autostopped
		// setup mining rocks to mine from
		if(parameters.length == 0) {
			println("Parameter expected for command guild: coal, mith");
			return false;
		}
		for(int i = 0; i < parameters.length; i++) {
			if(parameters[i].equalsIgnoreCase("coal")) {
				AddRockType(110);
				AddRockType(111);
				AddRocks(CoalX, CoalY);
			}
			else if(parameters[i].equalsIgnoreCase("mith")) {
				AddRockType(107);
				AddRocks(MithX, MithY);
			}
			else println("Skipping unknown parameter " + parameters[i]);
		}
		println("Mining from " + MineRockX.length + " rocks of " + rockTypes.size() + " different types.");
		return true;
/*
					players[curPlayer].customSleeping = true;
					players[curPlayer].bankAccountActionStep = 2000 + 3;	// that is: deposit all types of ores
					players[curPlayer].scriptStep = 7100;
					tooTired = false;
					wokeUpRest = false;	// reset for first use
					startedToRest = false;
*/
	}

    public void stop() { }

	// catch the server messages
	public void ServerMessage(String message)
	{
		super.ServerMessage(message);
	}

	public long run(long ticks)
	{
		if(inArea(263, 3384, 277, 3400)) {		// downstairs in mining guild
			int timeToWait;
/*			if(isTooTired() || numInvItems() == 30) {		// need to go rest or inventory is full
					if(isWalking) {	// already walking to ladder???
						ticksToWait = 200 + (java.lang.Math.abs(rnd.nextInt()) % 200);
						break;
					}
					if(tooTired) println("Too tired to mine....looking for bed (" + FATIGUE + "%)");
					else if(INV_SIZE == 30) println("Inventory full while mining - walk back");
					// near enough???
					if(curPosX >= 269 && curPosY >= 3393) {
						// now we are ready to climb up ladder :)
						ClimbLadder(274, 3398);
						ticksToWait = 2000 + (java.lang.Math.abs(rnd.nextInt()) % 1000);
						players[curPlayer].curMiningRock = -1;
					}
					else {
						// walk in direction of ladder
						WalkTo(271, 3395, 273, 3397);
						ticksToWait = 1000 + (java.lang.Math.abs(rnd.nextInt()) % 1000);
					}
					break;
				//if(numInvItems() == 30) println("Inventory full while mining - walking back");
				//else println("Too tired to mine...looking for bed (" + fatigueLevel() + "%)");
//					players[curPlayer].scriptStep = 2;			// walk back
//					players[curPlayer].stepAfterWalk = 7111;	// banking and sleeping....
				return 100;		// just wait 100 ms
			}
			else */if((timeToWait=CheckMoveRequest(false)) > 0) return timeToWait;

			timeToWait = MineRock();
			if(timeToWait == -1) return -1;		// halt
			else if(timeToWait == 0) return random(300, 200);	// nothing was done in MineRock(), so just wait some time
			else return timeToWait;			// return the time MineRocks() wants to wait
		}
		else {
			println("Not at mining site (" + playerX() + ";" + playerY() + ") - Aborting...");
			return -1;		// negative values means to halt the script
		}
	}

};
