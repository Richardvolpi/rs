// Warning: This script accesses methods/fields directly in the bot class which can change anytime!
// thus partly bypassing the scripting interface as specified in Script.jpp.
// This is not a real script for the public, but some extension to my bot which just makes
// use of the convenient scripting interface. Infact this one should be regarded as build-into 
// the bot.

public class pkBot2 extends Script
{

    public void init() { }

	public String[] getCommands()
	{
		return new String[]{"pkOld"};
	}

	boolean walkToEdgy = false;
	boolean testMode = false;
	public boolean start(String command, String parameters[])
	{
		DisableSuspension();
		DisableAutoRetreat();
		enableCustomSleeping();
		if(command.equalsIgnoreCase("pkOld")) {
			enablePKMode();			// turn on pkMode
			println("PK-mode enabled!");
			printMessage("@ran@ixBot: @whi@ PK mode enabled!");
			walkToEdgy = false;
			lastFollowPos = null;
			canAttack = false;
			wasInCombat = false;
			resetEatRequest();
			return true;
		}
		else {
			println("Unkn0wn b0t command");
			return false;
		}
	}

    public void stop() {
		if(inPKMode()) {
			disablePKMode();
			println("PK-mode disabled!");
			printMessage("@ran@ixBot: @whi@ PK mode disabled!");
		}
	}

	boolean isBusy = false;
	public void ServerMessage(String message)		// catch the server messages
	{
		if(message.equalsIgnoreCase("I can't get close enough")) {
			isBusy = true;
		}
		else if(message.regionMatches(true, 0, "@gam@You eat", 0, 12)) {
			decrementEatRequest();
		}
		else if(message.regionMatches(true, 0, "You have defeated ", 0, 18)) {
			String PkedGuy = message.substring(18, message.length()-1);
			println("Thou didst PK teh \"" + PkedGuy + "\"");
		}
		else if(message.regionMatches(true, 0, "Warning! ", 0, 9) && message.regionMatches(true, message.length()-20, " is shooting at you!", 0, 20)) {
			String shootingGuy = message.substring(9, message.length()-20);
			println("Dude \"" + shootingGuy + "\" is shooting à toi.");
		}
		else if(message.equalsIgnoreCase("Your opponent is retreating!")) {
			
		}
		else println("Message caught: " + message);
	}

	int EatTimeWait = 400;		// delay between two eat commands
	int FollowTimeWait = 500;		// delay between two walk commands
	int FollowAfterCombatModeDelay = 100;	// time to wait after foe ran from combat
	int CanAttackTimeWait = 100;		// delay between health bars disappear and we send attack commands
	int AttackTimeWait = 300;			// delay between two attack commands
	int attackRange = 1;

	long eatTicks = -1, followTicks = -1, canAttackTimer = -1, attackTicks = -1;
	boolean canAttack = false, wasInCombat = false;
	TileCoord lastFollowPos = null;

	long lastTicksy = -1;
	public long run(long ticks)
	{
		//if(!inPKMode()) return -1;

		if(eatTicks == -1) eatTicks = ticks-1;
		if(followTicks == -1) followTicks = ticks-1;

		int curHp = getSkillLevelCurrent(3), totalHp = getSkillLevelReal(3);
		if(curHp >= totalHp*90/100) resetEatRequest();	// reset on 95% hp
/*		if(curHp <= totalHp*100/175 && !isPrayerOn(8)) {
			if(prayerOn(8)) {
				println("Turning on protect items");
				return random(100, 50);
			}
		} */

		int targetPlayer = getSelectedPlayer();		// the player we want to autocatch
		boolean catchPlayer = (inCatchMode() && targetPlayer >= 0);		// in catchMode and target player selected
		if(!catchPlayer && eatRequest()) {
			if(eatTicks < ticks) {
				eatTicks = ticks+EatTimeWait;
				DoEat();
				printMessage("@ran@DEBUG: @whi@ AutoEat()");
				return 15;
			}
		}

		if(catchPlayer) {
			int playerIdx = searchPlayerById(targetPlayer);
			if(playerIdx < 0) {
				println("AutoCatch: Couldn't find player with ID " + targetPlayer);
				resetSelectedPlayer();
				lastFollowPos = null;
				return 15;
			}
			TileCoord enemyPos = getPlayerPos(playerIdx);
			int deltaX = playerX()-enemyPos.x, deltaY = playerY()-enemyPos.y;

			if(isPlayerInCombat(playerIdx)) {
				canAttack = false;
				followTicks = ticks+FollowAfterCombatModeDelay;
			}



/*			l enemy = yv[selectedPlayer];
			int deltaX = bw.fr-enemy.fr, deltaY = bw.gr-enemy.gr;
			if(enemy == null || enemy.dr != selectedPlayer) {
				java.lang.System.out.println("Error in masterPlayerList :-\\");
				catchMode = false;
				lastActionFollow = false;
			}
			else if(enemy.yr >= 61 && enemy.yr <= 61) {
				gk("@ran@evo: @ora@A strong wave emerging from " + enemy.cr + " disturbs your mind", 7);
				selectedPlayer = -10;
			}
			else if(eatReq == 0 && enemy.xr == 0 && deltaX <= 2*128 && deltaY <= 2*128 && deltaX >= -2*128 && deltaY >= -2*128) {
				if(!IsPlayerAttackable(enemy)) {
					gk("@ran@RBFX: @ora@ Catching aborted - player outside attack range!", 7);
					selectedPlayer = -10;
				}
				else {
					// that dude needs to be attacked!
					ez[cz-1] = "Attack";
					dz[cz-1] = "@whi@" + enemy.cr;
					fz[cz-1] = 805;
					gz[cz-1] = enemy.fr;
					hz[cz-1] = enemy.gr;
					iz[cz-1] = enemy.dr;
					cm(cz-1);
				}
				ticksToWait = ticksToWait = 200 + (java.lang.Math.abs(rnd.nextInt()) % 50);
				lastActionFollow = false;
			}
			else if(eatReq > 0 && (lastActionFollow || !newFollowPos)) {
				gk("@ran@DEBUG: @whi@ AutoEat()", 7);
				DoEat();
				ticksToWait = debugEatTime;
				eatReq--;
				lastActionFollow = false;
			}
			// myFollow routines....follow, eat and catch....try to click some tiles ahead in the right direction!
			else *//*if(newFollowPos && OKSendCommand) {
				int advX = followX, advY = followY;
				if(followFacing == 2 || followFacing == 1 || followFacing == 3) advX += 1;
				if(followFacing == 6 || followFacing == 5 || followFacing == 7) advX -= 1;
				if(followFacing == 4 || followFacing == 3 || followFacing == 5) advY += 1;
				if(followFacing == 0 || followFacing == 1 || followFacing == 7) advY -= 1;
//				if(cw+bv != queueWayPointX || dw+cv != queueWayPointY) java.lang.System.out.println("Lag Hack in action!;)");
//				java.lang.System.out.println("at " + (cw+bv) + "," + (dw+cv) + "  -- lag hack:P " + queueWayPointX + "," + queueWayPointY);
				int saveCW = cw, saveDW = dw;
				cw = queueWayPointX-bv; dw = queueWayPointY-cv;
				WalkTo(advX, advY);		// just walk there
				if(tu == 0) WalkTo(followX, followY);		// advancing waypoint blocked -> just walk there
				cw = saveCW; dw = saveDW;
				newFollowPos = false;
				followPosTime = -1;
				ticksToWait = debugWalkTime;
				lastActionFollow = true;
				gk("@ran@DEBUG: @whi@ Walk()", 7);
			} */
		}



/*
			// check health bars to see if we're allowed to attack
			if(!canAttack) {
				if(getPlayerHealthBarCounter(getThisPlayer()) <= 0 && getPlayerHealthBarCounter(playerIdx) <= 0) {
					if(canAttackTimer == -1) canAttackTimer = ticks+CanAttackTimeWait;		// wait some more time
					else if(canAttackTimer < ticks) {
						canAttack = true;	// finally can attack :)
						attackTicks = ticks-1;
						printMessage("@ran@DEBUG: @whi@ canAttack = true");
					}
				}
				else canAttackTimer = -1;	// reset
			}
			else canAttackTimer = -1;	// reset

			if(eatRequest() && eatTicks < ticks) {
				eatTicks = ticks+EatTimeWait;
				if(!DoEat()) return random(50, 50);		// out of food
				else {
					printMessage("@ran@DEBUG: @whi@ AutoEatCatch()");
					return random(20, 20);
				}
			}
			else if((isWalking() || !isPlayerWalking(playerIdx)) && !eatRequest() && attackTicks < ticks && canAttack && deltaX <= attackRange && deltaY <= attackRange && deltaX >= -attackRange && deltaY >= -attackRange) {
				if(!isPlayerAttackable(playerIdx)) {
					printMessage("@ran@ixBot: @ora@ Catching aborted - player outside attack range!");
					resetSelectedPlayer();
					lastFollowPos = null;
				}
				else if(followTicks < ticks) {
					//attackPlayer(playerIdx);
					attackPlayerMOD(playerIdx);
					println("AutoCatch(): Attack!!!");
					printMessage("@ran@DEBUG: @whi@ Attack!()");
					attackTicks = ticks+AttackTimeWait;
					return random(20, 20);
				}
			}
			else if(followTicks < ticks && attackTicks < ticks) {
				// pos player is travelling to (i.e. most uptodate known position - may not even be there:P)
				TileCoord destPos = getPlayerDestPos(playerIdx);
				if(distanceFrom(destPos.x, destPos.y) <= 2) {
					println("No reachable");
					return random(20, 20);
				}
				if(lastFollowPos == null || !lastFollowPos.equals(destPos)) {		// new destPoint
					lastFollowPos = destPos;
					//walkToMOD(destPos.x, destPos.y);
					walkTo(destPos.x, destPos.y);
					printMessage("@ran@DEBUG: @whi@ Walk()");
					followTicks = ticks+FollowTimeWait;
					println("AutoCatch(): walk to (" + destPos.x + ", " + destPos.y + ")");
					return random(20, 20);
				}
				else if(isPlayerInCombat(playerIdx) && !destPos.equals(playerX(), playerY())) {
					// stand on that spot where player is fighting
					//walkToMOD(destPos.x, destPos.y);
					walkTo(destPos.x, destPos.y);
					printMessage("@ran@DEBUG: @whi@ WalkFightingPlace()");
					followTicks = ticks+FollowTimeWait;
					println("AutoCatch(): walk to (" + destPos.x + ", " + destPos.y + ")");
					return 15;
				}
			}
		} */
		
		// idle time
/*		if(getSkillLevelReal(5) >= 31 && (isPrayerOn(10) || isPrayerOn(5))) {
			// switch off ultimate str and att prayers
			if(isPrayerOn(10)) {
				prayerOff(10);
				println("Turning off ultimate str");
				return random(350, 100);
			}
			else if(isPrayerOn(5)) {
				prayerOff(5);
				println("Turning off Improved reflexes");
				return random(350, 100);
			}
		} */

		return 15;
	}

	int foodWarning;
	public boolean DoEat()		// eats anything eatable in inventory
	{
		// search inventory for first eatable item
		for(int slot = 0; slot < numInvItems(); slot++) {
			if(getItemCommand(itemAtSlot(slot)).equals("Eat")) {
				foodWarning = 0;		// reset
				itemCommand(slot);
				return true;		// something was eaten
			}
		}
		println("DoEat() : Out of food");
		if(++foodWarning > 20) {
			printMessage("@ran@ixBot: @red@ Out of Food!!");
			foodWarning = 0;
		}
		return false;
	}

	public long runCombat(long ticks)
	{
		//println("runCombat("+ticks+")");
		canAttack = false;
		wasInCombat = true;
		followTicks = ticks+FollowAfterCombatModeDelay;

		int playerId = getFightingPlayer();
		int playerIdx = searchPlayerById(playerId);
		if(playerIdx != -1 && inFriendsList(playerIdx)) {		// check, if this player is in friends list
			return 50;		// don't wield anything while fighting with someone in friends list
		}
		if(CheckWieldedWeapon()) return random(1000, 500);		// something was wielded
		else return 50;
	}

	// well this method is lame, but since you don't want you're 1def pb to get messed up...
	public boolean CheckWieldedWeapon()
	{
		//[79]  name=Mithril 2-handed Sword; desc=A very large sword; cmd=; price = 2600; member=0
		//[80]  name=Adamantite 2-handed Sword; desc=A very large sword; cmd=; price = 6400; member=0
		//[81]  name=rune 2-handed Sword; desc=A very large sword; cmd=; price = 64000; member=0
		int attackLevel = getSkillLevelReal(0);
		int swordType = 0;
		if(attackLevel >= 40) swordType = 81;
		else if(attackLevel >= 30) swordType = 80;
		else if(attackLevel >= 20) swordType = 79;
		for(; swordType >= 79; swordType--) {		// try all types of 2h-swords
			int slot = getInvSlot(swordType);
			if(slot < 0) continue;		// none found
			if(itemBeingWorn(slot)) break;		// already worn
			else {
				println("Wielding " + getItemName(swordType));
				wearItem(slot);
				return true;
			}
		}
		//[316]  name=Ruby Amulet of strength; desc=It improves my damage; cmd=; price = 2025; member=0
		//[317]  name=Diamond Amulet of power; desc=A powerful amulet; cmd=; price = 3525; member=0
		for(int ammyType = 316; ammyType <= 317; ammyType++) {
			int slot = getInvSlot(ammyType);
			if(slot < 0) continue;		// none found
			if(itemBeingWorn(slot)) break;		// already worn
			else {
				println("Wearing " + getItemName(ammyType));
				wearItem(slot);
				return true;
			}
		}
		return false;			// nothing done
	}

};
