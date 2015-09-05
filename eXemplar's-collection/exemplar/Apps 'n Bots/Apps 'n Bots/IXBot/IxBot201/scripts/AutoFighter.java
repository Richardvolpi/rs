// abstract AutoFighter class
public abstract class AutoFighter extends Script
{
	// AutoFighter interface
	public abstract String FoeName();
	public abstract boolean IsRetreating();
	public abstract int TypeMatches(int monId);		// checks if monster is of right type and return attacking priority (based on various types of monsters, or location,...)
	public abstract boolean IsAggressive(int monId, int health);		// returns true, if monster autoattacks
	public boolean ValidateCoordinates(int posX, int posY) { return true; }		// can validate the position of a monster

	public void CancelAttack() { }		// called when monster was attacked by someone else

	public abstract int GetSector(int posX, int posY);		// return -1, if not a valid sector

	public abstract boolean IsInCenter(int posX, int posY);

	// returns time to wait, or 0 if monster reachable (foeX, foeY: coordinates of monster), or -1 if not reachable
	public abstract int CheckReachable(int mySector, int monSector, int dist, int foeX, int foeY);

	// called to walk to the center, returns time to wait (or -1 on error)
	public abstract int WalkCenter(int curSector);

	// called every 5 secs to do misc things, like walking around; returns time to wait (or -1 on error)
	public abstract int IdleAction();
	
	// called while waiting for monster to appear - returns time to wait or 0 if didnt do anything, or -1 on error
	public int DoWhileNotFighting() { return 0; }

	// called just before looking for a new monster; returns time to wait or -1 on error
	public abstract int PreLookForNewMonster(int curSector);

	// number of people currently in fighting area
	public int PeopleInArea()
	{
		int numPeople = 0;
		// now browse through all players
		for(int i = 0; i < numPlayers(); i++) {	// start counting from 1 since 0 is ThisPlayer
			TileCoord pos = getPlayerPos(i);
			if(GetSector(pos.x, pos.y) > 0) numPeople++;
		}
		return numPeople;
	}

	// number of monsters currently in fighting area
	public int MonsterInArea()
	{
		int numMon = 0;
		// now browse through all players
		for(int i = 0; i < numNpcs(); i++) {
			TileCoord pos = getNpcPos(i);
			if(GetSector(pos.x, pos.y) > 0) numMon++;
		}
		return numMon;
	}

	
	// the actual scripting here - no need to edit anything here
	public boolean start(String command, String parameters[])
	{
		busyChecks = 0;
		monsterId = -1;
		commandSend = 0;
		commandCount = 0;
		attackMissed = 0;
		numKilled = 0;
		wasAttacked = false;
		idleTimerTicks = 0;
		resetWasFighting();
		return true;
	}

	public void ServerMessage(String message)		// catch the server messages
	{
		if(message.equalsIgnoreCase("Your opponent is retreating")) {
		}
		else if(message.equalsIgnoreCase("You are under attack!")) {
			println("I am under attack!");
			monsterId = -1;
		}
	}

	private int busyChecks = 0;
	private int monsterId;
	private int commandSend, commandCount;
	private int attackMissed, numKilled;
	private boolean wasAttacked;		// attack was sent
	private int lastHP_XP;				// to determine if we actually kille tha foe
	private long idleTimerTicks;		// timer for invokation of IdleAction()

	public long run(long ticks)
	{
		long timeToWait;
		// check current location
		int curSector = GetSector(playerX(), playerY());
		boolean isWalking = isWalking();
		if(curSector != -1) {
			// we are at correct training area
			int lastMonsterId = -1;
			if(wasAttacked && monsterId != -1 && (isNpcBusy() || busyChecks >= 6)) {
				if(isNpcBusy()) attackMissed += 2;
				println("Monster with id=" + monsterId + " busy");
				lastMonsterId = monsterId;	// not to select same again
				monsterId = -1;
				wasAttacked = false;
				CancelAttack();
				isWalking = false;			// abort any walking commands
			}
			if(wasFighting()) idleTimerTicks = ticks;	// reset idle timer
			if(monsterId == -1) {
				commandSend = 0;
				commandCount = 0;
				resetWasFighting();
				lastHP_XP = getSkillXP(3);		// hitpoint xp!
				if(attackMissed < -10) attackMissed = -10;	// set a min value of this one!
				busyChecks = 0;
				if((timeToWait=PreLookForNewMonster(curSector)) != 0) return timeToWait;	// did something in here
				// look for nearest monsters to attack (thats not already fighting)
				int nearestDist = 1000;
				int nearestIdx = -1;
				int highestPrio = 0;
				int nearestX = -1, nearestY = -1;
				for(int i = 0; i < numNpcs(); i++) {
					// search for monsters only (that are not busy)
					if(!isNpcInCombat(i) && getNpcId(i) != lastMonsterId) {
						int monPrio = TypeMatches(getNpcType(i));
						TileCoord pos = getNpcPos(i);
						if(monPrio >= highestPrio && ValidateCoordinates(pos.x, pos.y)) {
							int deltaX = (playerX()-pos.x), deltaY = (playerY()-pos.y);
							int dist = deltaX*deltaX + deltaY*deltaY;
							if(monPrio > highestPrio) {
								// higher priority monster found
								nearestDist = dist;
								nearestIdx = i;
								highestPrio = monPrio;
								nearestX = pos.x;
								nearestY = pos.y;
							}
							else if(monPrio == highestPrio) {
								if(dist < nearestDist) {	// found a better target
									nearestDist = dist;
									nearestIdx = i;
									nearestX = pos.x;
									nearestY = pos.y;
								}
							}
						}
					}
				}
				
				if(nearestIdx != -1) {
					println("Chosen to fight " + getNpcName(getNpcType(nearestIdx)) + ", id=" + getNpcId(nearestIdx) +
						" ;@dist=" + nearestDist + " ;@pos=(" + nearestX + ", " + nearestY + ")");
					monsterId = getNpcId(nearestIdx);
					return random(500, 500);
				}
				else if((!IsInCenter(playerX(), playerY()) && !isWalking) || lastMonsterId != -1) {
					return WalkCenter(curSector);		// walk to center
				}
				else if((timeToWait=DoWhileNotFighting()) == 0) {
					if((ticks-idleTimerTicks) > 5000) {
						idleTimerTicks = ticks;		// reset
						return IdleAction();
					}
					else return random(200, 200);		// wait some time for next monster to spawn
				}
				idleTimerTicks = ticks;		// reset
				return timeToWait;
			}
			
			if(CheckWieldedWeapon()) {	// CombatStyle related weapon wielding/removing
				return random(1000, 500);
			}
			
			// recheck selected Npc (someone else might have attacked or even killed it)
			int npcIndex = searchNpcById(monsterId);
			if(npcIndex < 0) {
				// this thing has obviously been killed
				if(lastHP_XP != getSkillXP(3)) {
					println("Monster killed by me - " + (getSkillXP(0)/4) + ";" + (getSkillXP(1)/4) + ";" + (getSkillXP(2)/4));
					numKilled++;
					attackMissed--;
				}
				else {
					println("Monster killed by someone else");
					attackMissed += 2;
				}
				resetWasFighting();
				monsterId = -1;
				return random(200, 200);
			}
			int npcType = getNpcType(npcIndex);
			if(TypeMatches(npcType) == -1) {
				println("FATAL: monster is no " + FoeName() + "! - refusing to attack");
				monsterId = -1;
				return random(200, 200);
			}
			TileCoord pos = getNpcPos(npcIndex);
			if(!ValidateCoordinates(pos.x, pos.y)) {
				println(getNpcName(npcType) + " with id=" + monsterId + " is leaving fighting area - abort attack");
				busyChecks = 6;			// for check above in next cycle
				wasAttacked = true;		// is needed in cases where we didn't send attack command yet when foe was too far away
				return random(200, 200);
			}
			int deltaX = (playerX()-pos.x), deltaY = (playerY()-pos.y);
			int dist = deltaX*deltaX + deltaY*deltaY;
			int npcSector = GetSector(pos.x, pos.y);	// sector, npc we want to attack, is in
			if(npcSector < 0) {
				println("FATAL: " + getNpcName(npcType) + " in unknown area (" + pos.x + "," + pos.y + "=>sector=" + npcSector + ") - Halting");
				return -1;
			}
			int npcLevel = getNpcCombatLevel(npcType);	// combat level of Npc we're about to attack
			if(IsAggressive(npcType, npcCurrentHealth(npcIndex)) && AutoAttackPlayerNear(pos.x, pos.y, npcLevel)) {
				println("Aggressive " + getNpcName(npcType) + " with id=" + monsterId + " is attacking near player");
				attackMissed += 1;
				monsterId = -1;
				return random(200, 200);
			}

			if(isNpcInCombat(npcIndex)) {
				busyChecks++;
				if(busyChecks >= 6 || dist >= 2*2) {	// now we arent the one who did att for sure
					busyChecks = 6;			// for check above in next cycle
					wasAttacked = true;		// is needed in cases where we didn't send attack command yet when foe was too far away
					println(getNpcName(npcType) + " with id=" + monsterId + " has been attacked by someone else");
					attackMissed += 2;
				}
				return random(200, 200);
			}

			if(wasFighting()) {
				if(!IsRetreating()) println(getNpcName(npcType) + "(" + monsterId + ") killed, but still in list");
				else println(getNpcName(npcType) + " did reatreat....");
			}

			if((timeToWait=CheckReachable(curSector, npcSector, dist, pos.x, pos.y)) != 0) {
				// doors were opened, or walked near that npc, so we need to wait...
				commandSend = 0;
				return timeToWait;
			}
			if(isWalking && commandSend > 0) return random(200, 200);
			if(commandSend > 0) {
				commandSend--;	// resend countdown
				return random(200, 200);
			}
			if(commandCount > 3) {
				println("Warning: commandCount exceeded - looking for another foe.");
				monsterId = -1;
				return random(200, 200);
			}
			// all checks done - we can send attack command now
			attackNpc(npcIndex);
			wasAttacked = true;
			resetWasFighting();
			commandSend = 5;		// attack command has been sent
			commandCount++;			// count number of sent commands...if it exceeds a certain value look for another foe
			busyChecks = 0;
			println("Sent attack command to " + getNpcName(npcType) + " with id=" + monsterId);
			return random(400, 400);
		}
		else {
			println("AutoFighter (at " + FoeName() + "): i'm lost at (" + playerX() + ", " + playerY() + ") - Halting...");
			return -1;
		}
	}

	public long runCombat(long ticks)
	{
		if(CheckWieldedWeapon()) return random(1000, 500);
		else return 0;
	}

	public boolean AutoAttackPlayerNear(int tileX, int tileY, int npcLevel)
	{
		// browse through all players
		for(int i = 1; i < numPlayers(); i++) {	// start counting from 1 since 0 is ThisPlayer
			TileCoord pos = getPlayerPos(i);
			if(getPlayerCombatLevel(i) <= npcLevel*2 && GetSector(pos.x, pos.y) > 0 && !isPlayerInCombat(i)) {		// do we need to consider this player?
				// check if in autoAttackRange
				if(pos.x >= tileX-1 && pos.y >= tileY-1 && pos.x <= tileX+1 && pos.y <= tileY+1) return true;
			}
		}
		return false;	// no potential player found
	}

	// well this method is lame, but since you don't want you're 1def pb to get messed up...
	public boolean CheckWieldedWeapon()
	{
		boolean removeWeap;
		if(combatStyle() != requestedCombatStyle()) removeWeap = true;
		else removeWeap = false;
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
			if(removeWeap) {
				if(itemBeingWorn(slot)) {
					println("Removing " + getItemName(swordType));
					removeItem(slot);
					return true;
				}
			}
			else if(itemBeingWorn(slot)) break;		// already worn
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
			if(removeWeap) {
				if(itemBeingWorn(slot)) {
					println("Removing " + getItemName(ammyType));
					removeItem(slot);
					return true;
				}
			}
			else if(itemBeingWorn(slot)) break;		// already worn
			else {
				println("Wearing " + getItemName(ammyType));
				wearItem(slot);
				return true;
			}
		}
		return false;			// nothing done
	}
	// well this method is lame, but since you don't want you're 1def pb to get messed up...
	public boolean CheckWieldedWeaponOld()
	{
		int idx;
		// check for combatStyle - if its not set to the one we want, remove r2h and amulet
		if(combatStyle() != requestedCombatStyle()) {
			// remove that dam r2h and ammy, so we dont 1hit anything
			for(idx = 0; idx < numInvItems(); idx++) {
				int itemType = itemAtSlot(idx);
				if(itemType == 81 || itemType == 317 || itemType == 316) {	// rune 2-handed sword(81) || Diamond/Ruby Amulet(316,317)
					if(itemBeingWorn(idx)) {
						println("Removing " + getItemName(itemType));
						removeItem(idx);
						return true;
					}
				}				
			}
			return false;		// everything unwielded...
		}
		else {
			boolean ammyWorn = false;		// to ensure, not to try wearing more than one ammy
			// check if weapon/ammy is being wield
			for(idx = 0; idx < numInvItems(); idx++) {
				int itemType = itemAtSlot(idx);
				if(itemType == 81 || ((itemType == 317 || itemType == 316) && !ammyWorn)) {
					if(!itemBeingWorn(idx)) {
						println("Wielding " + getItemName(itemType));
						wearItem(idx);
						return true;
					}
					else if(itemType == 317 || itemType == 316) {
						ammyWorn = true;
					}
				}
			}
			return false;
		}
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

	public int NumFood()		// returns amount of food in inventory
	{
		int num = 0;
		for(int i = 0; i < numInvItems(); i++) {
			if(getItemCommand(itemAtSlot(i)).equals("Eat")) num++;
		}
		return num;
	}

}
