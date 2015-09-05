public class Flax extends Script
{

	final int FLAX = 675;
	final int BOWSTRING = 676;
	public String[] getCommands()
	{
		return new String[]{"flax"};
	}

	private int bankItems[] = { BOWSTRING };	// deposit all bowstrings
	public boolean start(String command, String parameters[])
	{
		EnableSuspension();
		EnableAutoRetreat();
		enableCustomSleeping();
		setBankTypes(bankItems);
		println("Start bowstringing script");
		return true;
	}

    public void stop() { println("Stop bowstringing script"); }

	public long run(long ticks)
	{
		if(inArea(522, 1406, 526, 1411)) {
			if(isTooTired() || fatigueLevel() >= 99) {
				// need to rest
				if(!objectCommand1At(524, 1410, "rest")) {
					println("AutoFlaxer: No bed found...waiting");
					return random(500, 500);
				}
				else return random(3000, 1000);
			}
			if(numInvItem(FLAX) > 0) {
				if(isWalking()) return 200;
				// spin the flax
				int spinWheel = getObjectAt(522, 1411);
				if(spinWheel == -1 || getObjectType(spinWheel) != 121) {
					println("AutoFlaxer: spinning wheel not found yet...waiting");
					return random(500, 500);
				}
				int flaxSlot = getInvSlot(FLAX);
				if(flaxSlot < 0) {
					println("AutoFlaxer: couldn't find flax in inventory - Halting");
					return -1;
				}
				useItemWithObject(flaxSlot, spinWheel);
				return random(700, 500);
			}
			else {
				if(isWalking()) return 200;
				// go down ladder
				if(!objectCommand1At(525, 1406, "Climb-Down")) {
					println("AutoFlaxer: Ladder down not found - Halting");
					return -1;
				}
				else return random(2000, 1000);
			}
		}
		else if(numInvItem(BOWSTRING) > 0) {
			// go to bank and deposit bowstrings
			if(inArea(498, 447, 504, 453)) {		// in bank?
				println("Bank - starting bank acoount manager");
				openBankAccount();
				return 100;
			}
			else if(distanceFrom(500, 454) < 10*10) {	// near bank door
				int result = checkDoorOpen(500, 454);
				if(result > 0) return result;
				walkTo(501, 451, 1);		// walk inside bank
				return random(1500, 1000);
			}
			else {
				println("walk to bank...");
				runWalkingScript(SpinToBankX, SpinToBankY);
				return 100;
			}
		}
		else if(numInvItems() < 30) {
			// pick flax
			if(distanceFrom(489, 486) < 5*5) {
				int flaxObj = getObjectAt(489, 486);
				if(flaxObj != -1 && getObjectCommand2(getObjectType(flaxObj)).equals("pick")) {
					if(oneIn(15)) walkTo(489, 486, 1);
					else objectCommand2(flaxObj);
					return random(700, 500);
				}
				else {
					println("Flax plant not found");
					return -1;
				}
			}
			else if(distanceFrom(489, 486) < 15*15) {
				// walk near plant
				if(isWalking()) return 500;
				walkTo(489, 486, 3);
				return random(1000, 500);
			}
			else {
				println("Walk to flax plant");
				runWalkingScript(BankToFlaxX, BankToFlaxY);
				return 100;
			}
		}
		else if(inArea(522, 462, 525, 467)) {
			// go up ladder
			if(!objectCommand1At(525, 462, "Climb-Up")) {
				println("AutoFlaxer: Ladder up not found - Halting");
				return -1;
			}
			else return random(2000, 1000);
		}
		else {
			if(distanceFrom(522, 465) < 10*10) {	// near the door to the spinningwheel house
				int result = checkDoorOpen(522, 465);
				if(result > 0) return result;
				walkTo(523, 463, 1);		// walk inside that house
				return random(1500, 1000);
			}
			// go to spinning wheel
			println("walk to spinning wheel");
			runWalkingScript(FlaxToSpinX, FlaxToSpinY);
			return 100;
		}
	}

	int SpinToBankX[] = { 521, 501 };
	int SpinToBankY[] = { 465, 452 };

	int BankToFlaxX[] = { 501, 503, 503, 493 };
	int BankToFlaxY[] = { 453, 461, 474, 485 };

	int FlaxToSpinX[] = { 491, 511, 521 };
	int FlaxToSpinY[] = { 486, 470, 466 };

};
