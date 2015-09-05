public abstract class Script
{
    protected mudclient rs;

    public Script(mudclient rs)
    {
        this.rs = rs;
    }
    public void start(String command, String parameters[])
    {
    }
    public String[] getCommands()
    {
        return new String[0];
    }
	public void endScript() { rs.runCommand("##stop"); }
	public boolean autoLogin() { return rs.autoLogin; }
	public void enableAutoLogin() { rs.autoLogin = true; }
	public void disableAutoLogin() { rs.autoLogin = false; }
	public boolean loggedIn() { if (rs.loggedIn == 1) return true; return false; }
	public void login(String username, String password) { if(!loggedIn()) rs.login(username,password,false); }
	public void displayMessage(String message) { rs.displayMessage(message,3); }
	public boolean running() { return rs.running; }
	public void wait(int ticks) { try { Thread.sleep(ticks); } catch (Exception e) { } }
	public void logout() { rs.logout(); }
	public boolean isIn(String text, String locate) { if(text.indexOf(locate) >= 0) return true; return false; }

	public void waitForShit() { while(!loggedIn()) wait(100); while(rs.loading) wait(100); }
	public boolean coordsAt(int x, int y) { waitForShit(); if(myPlayerX() == x && myPlayerY() == y) return true; return false; }

	public int distance(int x, int y, int distX, int distY) { int farX = Math.abs(Math.abs(x) - Math.abs(distX)); int farY = Math.abs(Math.abs(y) - Math.abs(distY)); return farX + farY; }
	public void println(String message) { System.out.println(message); }
	public void println(int message) { System.out.println(String.valueOf(message)); }
	public long tickCount() { return System.currentTimeMillis(); }
	public String intToStr(int convert) { return String.valueOf(convert); }
	public int strToInt(String convert) { return Integer.parseInt(convert); }
	public int random(int base, int limit) { return base + (int)(Math.random() * limit); }
	public int questMenuCount() { waitForShit(); return rs.questMenuCount; }
	public String questMenuAnswer(int pos) { return rs.questMenuAnswer[pos]; }
	public boolean questMenu() { waitForShit(); return rs.questMenu; }
	public boolean answerQuestMenu(int pos) { waitForShit(); if (pos >= rs.questMenuCount) return false; rs.connection.newID(QUESTMENUID); rs.connection.addVar(pos); rs.connection.complete(); rs.questMenu = false; return true; }
	public boolean answerQuestMenu(String message) { waitForShit(); for (int i = 0; i < rs.questMenuCount; i++) if (rs.questMenuAnswer[i].equals(message)) return answerQuestMenu(i);	return false; }
	public int fightMode() { waitForShit(); return rs.fightMode; }
	public boolean setFightMode(int mode) { waitForShit(); if (mode > 3) return false; rs.connection.newID(FIGHTMODEID); rs.connection.addVar(mode); rs.connection.complete(); rs.fightMode = mode; return true; }
	public int playerCount() { waitForShit(); return rs.playerCount; }
	public String playerName(int pos) { waitForShit(); return rs.player[pos].name; }
	public int playerID(int pos) { waitForShit(); return rs.player[pos].id; }
	public int playerX(int pos) { waitForShit(); return ((rs.player[pos].x - 64) / rs.magicLoc) + rs.bigX; }
	public int playerY(int pos) { waitForShit(); return ((rs.player[pos].y - 64) / rs.magicLoc) + rs.bigY; }
	public int playerLevel(int pos) { waitForShit(); return rs.player[pos].level; }
	public int playerDistance(int pos) { waitForShit(); return distance(playerX(pos),playerY(pos),myPlayerX(),myPlayerY()); }
	public int playerPathLength(int pos) { waitForShit(); return getPathLength(playerX(pos),playerY(pos)); }
	public boolean playerInCombat(int pos) { waitForShit(); if (rs.player[pos].sprite == 8 || rs.player[pos].sprite == 9) return true; return false; }
	public String playerLastSaid(int pos) { waitForShit(); return rs.npc[pos].lastSaid; }
	public int playerLastSaidTimeout(int pos) { waitForShit(); return rs.npc[pos].lastSaidTimeout; }
	public int myPlayerX() { waitForShit(); return rs.smallX + rs.bigX; }
	public int myPlayerY() { waitForShit(); return rs.smallY + rs.bigY; }
	public int myPlayerLevel() { waitForShit(); return rs.myPlayer.level; }
	public int myPlayerID() { waitForShit(); return rs.myPlayer.id; }
	public boolean myPlayerInCombat() { waitForShit(); if (rs.myPlayer.sprite == 8 || rs.myPlayer.sprite == 9) return true; return false; }
	public String myPlayerLastSaid() { waitForShit(); return rs.myPlayer.lastSaid; }
	public int myPlayerLastSaidTimeout() { waitForShit(); return rs.myPlayer.lastSaidTimeout; }
	public int fatigue() { waitForShit(); return (rs.fatigue * 100) / 750; }
	public boolean sleeping() { waitForShit(); return rs.sleeping; }
	public int questPoints() { waitForShit(); return rs.questPoints; }
	public int playerStat(int stat) { waitForShit(); return rs.playerStat[stat]; }
	public int currentStat(int stat) { waitForShit(); return rs.currentStat[stat]; }
	public int experience(int stat) { waitForShit(); return rs.statExperience[stat] / 4; }
	public int myPlayerHits() { waitForShit(); return rs.currentStat[3]; }
	public int myPlayerHitsPercentage() { waitForShit(); return (int)((rs.currentStat[3] / rs.playerStat[3]) * 100); }
	public boolean bank() { waitForShit(); return rs.bank; }
	public boolean shop() { waitForShit(); return rs.shop; }
	public void closeBank() { waitForShit(); rs.connection.newID(CLOSEBANKID); rs.connection.complete(); rs.bank = false; }
	public String lastServerMessage() { waitForShit(); return rs.lastServerMessage; }
	public void resetLastServerMessage() { waitForShit(); rs.lastServerMessage = ""; } 
	public boolean inLastServerMessage(String st) { waitForShit(); if(rs.lastServerMessage.indexOf(st) >= 0) return true; return false; }

	public int npcCount() { waitForShit(); return rs.npcCount; }
	public String npcName(int pos) { waitForShit(); return identify.npcName[rs.npc[pos].type]; }
	public int npcID(int pos) { waitForShit(); return rs.npc[pos].id; }
	public int npcType(int pos) { waitForShit(); return rs.npc[pos].type; }
	public int npcX(int pos) { waitForShit(); return ((rs.npc[pos].x - 64) / rs.magicLoc) + rs.bigX; }
	public int npcY(int pos) { waitForShit(); return ((rs.npc[pos].y - 64) / rs.magicLoc) + rs.bigY; }
	public int npcLevel(int pos) { waitForShit(); return (identify.npcAttack[rs.npc[pos].type] + identify.npcDefence[rs.npc[pos].type] + identify.npcStrength[rs.npc[pos].type] + identify.npcHits[rs.npc[pos].type]) / 4; }
	public int npcDistance(int pos) { waitForShit(); return distance(npcX(pos),npcY(pos),myPlayerX(),myPlayerY()); }
	public int npcPathLength(int pos) { waitForShit(); return getPathLength(npcX(pos),npcY(pos)); }
	public String npcCommand(int pos) { waitForShit(); return identify.npcCommand[rs.npc[pos].type]; }
	public String npcDesc(int pos) { waitForShit(); return identify.npcDesc[rs.npc[pos].type]; }
	public boolean npcInCombat(int pos) { waitForShit(); if (rs.npc[pos].sprite == 8 || rs.npc[pos].sprite == 9) return true; return false; }
	public boolean npcAttackable(int pos) { waitForShit(); if (identify.npcAttackable[rs.npc[pos].type] > 0) return true; return false; }
	public String npcLastSaid(int pos) { waitForShit(); return rs.npc[pos].lastSaid; }
	public int npcLastSaidTimeout(int pos) { waitForShit(); return rs.npc[pos].lastSaidTimeout; }

	public int doorCount() { waitForShit(); return rs.doorCount; }
	public String doorName(int pos) { waitForShit(); return identify.doorName[rs.doorType[pos]]; }
	public int doorDir(int pos) { waitForShit(); return rs.doorDir[pos]; }
	public int doorType(int pos) { waitForShit(); return rs.doorType[pos]; }
	public int doorX(int pos) { waitForShit(); return rs.doorX[pos] + rs.bigX; }
	public int doorY(int pos) { waitForShit(); return rs.doorY[pos] + rs.bigY; }
	public int doorDistance(int pos) { waitForShit(); return distance(doorX(pos),doorY(pos),myPlayerX(),myPlayerY()); }
	public int doorPathLength(int pos) { waitForShit(); return getPathLength(doorX(pos),doorY(pos)); }
	public String doorCommand(int pos) { waitForShit(); return identify.doorCommand[rs.doorType[pos]]; }
	public String doorCommand2(int pos) { waitForShit(); return identify.doorCommand2[rs.doorType[pos]]; }
	public String doorDesc(int pos) { waitForShit(); return identify.doorDesc[rs.doorType[pos]]; }
	public boolean door(int x, int y) { waitForShit(); for(int i = 0; i < rs.doorCount; i++) if(doorX(i) == x && doorY(i) == y) return true; return false; }
	public int findDoor(int x, int y) { waitForShit(); for(int i = 0; i < rs.doorCount; i++) if(doorX(i) == x && doorY(i) == y) return i; return -1; }

	public int objectCount() { waitForShit(); return rs.objectCount; }
	public String objectName(int pos) { waitForShit(); return identify.objectName[rs.objectType[pos]]; }
	public int objectID(int pos) { waitForShit(); return rs.objectID[pos]; }
	public int objectType(int pos) { waitForShit(); return rs.objectType[pos]; }
	public int objectX(int pos) { waitForShit(); return rs.objectX[pos] + rs.bigX; }
	public int objectY(int pos) { waitForShit(); return rs.objectY[pos] + rs.bigY; }
	public int objectDistance(int pos) { waitForShit(); return distance(myPlayerX(),myPlayerY(),objectX(pos),objectY(pos)); }
	public int objectPathLength(int pos) { waitForShit(); return getPathLength(objectX(pos),objectY(pos)); }
	public String objectCommand(int pos) { waitForShit(); return identify.objectCommand[rs.objectType[pos]]; }
	public String objectCommand2(int pos) { waitForShit(); return identify.objectCommand2[rs.objectType[pos]]; }
	public String objectDesc(int pos) { waitForShit(); return identify.objectDesc[rs.doorType[pos]]; }
	public boolean object(int x, int y) { waitForShit(); for(int i = 0; i < rs.objectCount; i++) if(objectX(i) == x && objectY(i) == y) return true; return false; }
	public int findObject(int x, int y) { waitForShit(); for(int i = 0; i < rs.objectCount; i++) if(objectX(i) == x && objectY(i) == y) return i; return -1; }

	public boolean canReach(int x, int y) { waitForShit(); if(rs.gameHandle.gkb(rs.smallX,rs.smallY,x-rs.bigX,y-rs.bigY,x-rs.bigX,y-rs.bigY,rs.djk,rs.djl,false) == -1) return false; return true; }
	public boolean canReachObject(int pos) { waitForShit(); if(rs.gameHandle.gkb(rs.smallX,rs.smallY,rs.objectX[pos],rs.objectY[pos],rs.objectX[pos],rs.objectY[pos],rs.djk,rs.djl,false) == -1) return false; return true; }
	public boolean canReachNpc(int pos)	{ waitForShit(); if(rs.gameHandle.gkb(rs.smallX,rs.smallY,npcX(pos)-rs.bigX,npcY(pos)-rs.bigY,npcX(pos)-rs.bigX,npcY(pos)-rs.bigY,rs.djk,rs.djl,false) == -1) return false; return true; }
	public boolean canReachPlayer(int pos) { waitForShit(); if(rs.gameHandle.gkb(rs.smallX,rs.smallY,playerX(pos)-rs.bigX,playerY(pos)-rs.bigX,playerX(pos)-rs.bigX,playerY(pos)-rs.bigX,rs.djk,rs.djl,false) == -1) return false; return true; }
	public boolean canReachDoor(int pos) { waitForShit(); if(rs.gameHandle.gkb(rs.smallX,rs.smallY,rs.doorX[pos],rs.doorY[pos],rs.doorX[pos],rs.doorY[pos],rs.djk,rs.djl,false) == -1) return false; return true; }

	public boolean openDoor(int pos) { waitForShit(); if(rs.doorCount < pos) return false; rs.fcd(rs.doorX[pos],rs.doorY[pos],rs.doorDir[pos]); rs.connection.newID(OPENDOORID); rs.connection.addInt(doorX(pos)); rs.connection.addInt(doorY(pos)); rs.connection.addVar(rs.doorDir[pos]); rs.connection.complete(); return true; }
	public boolean closeDoor(int pos) { waitForShit(); if(rs.doorCount < pos) return false; rs.fcd(rs.doorX[pos],rs.doorY[pos],rs.doorDir[pos]); rs.connection.newID(CLOSEDOORID); rs.connection.addInt(doorX(pos)); rs.connection.addInt(doorY(pos)); rs.connection.addVar(rs.doorDir[pos]); rs.connection.complete(); return true; }
	public boolean useOnDoor(int slot, int pos) { waitForShit(); if(rs.doorCount < pos) return false; if(rs.invCount < slot) return false; rs.fcd(rs.doorX[pos],rs.doorY[pos],rs.doorDir[pos]); rs.connection.newID(USEONDOORID); rs.connection.addInt(doorX(pos)); rs.connection.addInt(doorY(pos)); rs.connection.addVar(rs.doorDir[pos]); rs.connection.addInt(slot); rs.connection.complete(); return true; }
	public boolean useOnDoorByType(int type, int pos) { waitForShit(); if(rs.doorCount < pos) return false; if(invByType(type) == -1) return false; rs.fcd(rs.doorX[pos],rs.doorY[pos],rs.doorDir[pos]); rs.connection.newID(USEONDOORID); rs.connection.addInt(doorX(pos)); rs.connection.addInt(doorY(pos)); rs.connection.addVar(rs.doorDir[pos]); rs.connection.addInt(invByType(type)); rs.connection.complete(); return true; }

	public boolean atObject(int pos) { waitForShit(); if(rs.objectCount < pos) return false; rs.fba(rs.objectX[pos],rs.objectY[pos],rs.objectID[pos],rs.objectType[pos]); rs.connection.newID(ATOBJECTID); rs.connection.addInt(objectX(pos)); rs.connection.addInt(objectY(pos)); rs.connection.complete(); return true; }
	public boolean atObject2(int pos) { waitForShit(); if(rs.objectCount < pos) return false; rs.fba(rs.objectX[pos],rs.objectY[pos],rs.objectID[pos],rs.objectType[pos]); rs.connection.newID(ATOBJECT2ID); rs.connection.addInt(objectX(pos)); rs.connection.addInt(objectY(pos)); rs.connection.complete(); return true; }
	public boolean useOnObject(int slot, int pos) { waitForShit(); if(rs.objectCount < pos) return false; if(rs.invCount < slot) return false; rs.fba(rs.objectX[pos],rs.objectY[pos],rs.objectID[pos],rs.objectType[pos]); rs.connection.newID(USEONOBJECTID); rs.connection.addInt(objectX(pos)); rs.connection.addInt(objectY(pos)); rs.connection.addVar(rs.objectID[pos]); rs.connection.addInt(slot); rs.connection.complete(); return true; }
	public boolean useOnObjectByType(int type, int pos) { waitForShit(); if(rs.objectCount < pos) return false; if(invByType(type) == -1) return false; rs.fba(rs.objectX[pos],rs.objectY[pos],rs.objectID[pos],rs.objectType[pos]); rs.connection.newID(USEONOBJECTID); rs.connection.addInt(objectX(pos)); rs.connection.addInt(objectY(pos)); rs.connection.addVar(rs.objectID[pos]); rs.connection.addInt(invByType(type)); rs.connection.complete(); return true; }

	public boolean attackNpc(int pos) { waitForShit(); if(rs.npcCount < pos) return false; rs.ena(rs.smallX,rs.smallY,(rs.npc[pos].x - 64) / rs.magicLoc,(rs.npc[pos].y - 64) / rs.magicLoc,true); rs.connection.newID(ATTACKNPCID); rs.connection.addInt(rs.npc[pos].id); rs.connection.complete(); return true; }
	public boolean talkToNpc(int pos) { waitForShit(); if(rs.npcCount < pos) return false; rs.ena(rs.smallX,rs.smallY,(rs.npc[pos].x - 64) / rs.magicLoc,(rs.npc[pos].y - 64) / rs.magicLoc,true); rs.connection.newID(TALKTONPCID); rs.connection.addInt(rs.npc[pos].id); rs.connection.complete(); return true; }
	public boolean thieveNpc(int pos) { waitForShit(); if(rs.npcCount < pos) return false; rs.ena(rs.smallX,rs.smallY,(rs.npc[pos].x - 64) / rs.magicLoc,(rs.npc[pos].y - 64) / rs.magicLoc,true); rs.connection.newID(ALTNPCID); rs.connection.addInt(rs.npc[pos].id); rs.connection.complete(); return true; }

	public void walk(int x, int y) { waitForShit(); while((myPlayerX() != x || myPlayerY() != y) && running()) { waitForShit(); rs.ena(rs.smallX,rs.smallY,x-rs.bigX,y-rs.bigY,false); rs.eak = 24; long t = tickCount(); while(tickCount() - t < random(6000,9000) && (myPlayerX() != x || myPlayerY() != y) && running()) wait(1); } }
	public void walkNoWait(int x, int y) { waitForShit(); rs.ena(rs.smallX,rs.smallY,x-rs.bigX,y-rs.bigY,false); rs.eak = 24; }
	public void walkRandom(int x, int y, int x2, int y2) { walk(random(x,x2),random(y,y2)); }
	public void walkRandomNoWait(int x, int y, int x2, int y2) { walkNoWait(random(x,x2),random(y,y2)); }

	public boolean walkPath(int x[], int y[]) { waitForShit(); if(x.length != y.length) return false; for(int i = 0; i < x.length; i++) walk(x[i],y[i]); return true; }
	public boolean walkPathReverse(int x[], int y[]) { waitForShit(); if(x.length != y.length) return false; for(int i = 0; i < x.length; i++) { walk(x[x.length-1-i],y[y.length-1-i]); println("waypoint " + (y.length-1-i) + " " + x[x.length-1-i] + " " + y[y.length-1-i]); } return true; }

	public boolean isPlayerWalking(int pos) { waitForShit(); if((rs.player[pos].miniWalk + 1) % 10 != rs.player[pos].gmn) return true; return false; }
	public boolean isMyPlayerWalking() { waitForShit(); if((rs.myPlayer.miniWalk + 1) % 10 != rs.myPlayer.gmn) return true; return false; }

	public int invCount() { waitForShit(); return rs.invCount; } 
	public int invCount(int item) { waitForShit(); return rs.invCount(item); }
	public int inv(int pos) { waitForShit(); return rs.inv[pos]; }
	public boolean inInv(int type) { waitForShit(); for(int i = 0; i < rs.invCount; i++) if(rs.inv[i] == type) return true; return false; }
	public int invByType(int type) { waitForShit(); for(int i = 0; i < rs.invCount; i++) if(rs.inv[i] == type) return i; return -1; }
	public int invByName(String name) { waitForShit(); for(int i = 0; i < rs.invCount; i++) if(itemName(rs.inv[i]).equals(name)) return i; return -1; }
	public int invByCommand(String name) { waitForShit(); for(int i = 0; i < rs.invCount; i++) if(itemCommand(rs.inv[i]).equals(name)) return i; return -1; }
	public boolean wearing(int pos) { waitForShit(); if (rs.wearing[pos] == 1) return true; return false; }

	public int spellByName(String name) { waitForShit(); for(int i = 0; i < identify.spellCount; i++) if(identify.spellName[i].equals(name)) return i; return -1; }
	public int spellLevel(int pos) { waitForShit(); return identify.spellLevel[pos]; }

	public boolean use(int pos) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(USEID); rs.connection.addInt(pos); rs.connection.complete(); return true; }
	public boolean useByType(int type) { waitForShit(); if(invByType(type) == -1) return false; return use(invByType(type)); }
	public boolean useByName(String name) { waitForShit(); if(invByName(name) == -1) return false; return use(invByName(name)); }
	public boolean useByCommand(String command) { waitForShit(); if(invByCommand(command) == -1) return false; return use(invByCommand(command)); }

	public boolean useOnInv(int pos, int pos2) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(USEONINVID); rs.connection.addInt(pos); rs.connection.addInt(pos2); rs.connection.complete(); return true; }
	public boolean useOnInvByType(int type, int type2) { waitForShit(); if(invByType(type) == -1 || invByType(type2) == -1) return false; return useOnInv(invByType(type),invByType(type2)); }
	public boolean useOnInvByName(String name, String name2) { waitForShit(); if(invByName(name) == -1 || invByName(name2) == -1) return false; return useOnInv(invByName(name),invByName(name2)); }
	public boolean useOnInvByCommand(String command, String command2) { waitForShit(); if(invByCommand(command) == -1 || invByCommand(command2) == -1) return false; return useOnInv(invByCommand(command),invByCommand(command2)); }

	public boolean castOnInv(int pos, int pos2) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(USEONINVID); rs.connection.addInt(pos); rs.connection.addInt(pos2); rs.connection.complete(); return true; }
	public boolean castOnInvByName(String name, String name2) { waitForShit(); if(invByName(name) == -1 || spellByName(name2) == -1) return false; return useOnInv(invByName(name),spellByName(name2)); }

	public boolean drop(int pos) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(DROPID); rs.connection.addInt(pos); rs.connection.complete(); return true; }
	public boolean dropByType(int type) { waitForShit(); if(invByType(type) == -1) return false; return drop(invByType(type)); }
	public boolean dropByName(String name) { waitForShit(); if(invByName(name) == -1) return false; return drop(invByName(name)); }
	public boolean dropByCommand(String command) { waitForShit(); if(invByCommand(command) == -1) return false; return drop(invByCommand(command)); }

	public boolean wield(int pos) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(WIELDID); rs.connection.addInt(pos); rs.connection.complete(); return true; }
	public boolean wieldByType(int type) { waitForShit(); if(invByType(type) == -1) return false; return wield(invByType(type)); }
	public boolean wieldByName(String name) { waitForShit(); if(invByName(name) == -1) return false; return wield(invByName(name)); }
	public boolean wieldByCommand(String command) { waitForShit(); if(invByCommand(command) == -1) return false; return wield(invByCommand(command)); }

	public boolean remove(int pos) { waitForShit(); if(rs.invCount < pos) return false; rs.connection.newID(REMOVEID); rs.connection.addInt(pos); rs.connection.complete(); return true; }
	public boolean removeByType(int type) { waitForShit(); if(invByType(type) == -1) return false; return remove(invByType(type)); }
	public boolean removeByName(String name) { waitForShit(); if(invByName(name) == -1) return false; return remove(invByName(name)); }
	public boolean removeByCommand(String command) { waitForShit(); if(invByCommand(command) == -1) return false; return remove(invByCommand(command)); }

	public int itemCount() { waitForShit(); return rs.itemCount; }
	public int itemType(int pos) { waitForShit(); return rs.itemType[pos]; }
	public int itemX(int pos) { waitForShit(); return rs.itemX[pos] + rs.bigX; }
	public int itemY(int pos) { waitForShit(); return rs.itemY[pos] + rs.bigY; }
	public boolean itemStackable(int type) { waitForShit(); if (identify.stackable[type] != 1) return true; return false; }
	public String itemName(int type) { waitForShit(); return identify.itemName[type]; }
	public String itemCommand(int type) { waitForShit(); return identify.itemCommand[type]; }
	public String itemDesc(int type) { waitForShit(); return identify.itemDesc[type]; }
	public boolean wearable(int type) { waitForShit(); if(identify.wieldable[type] != 0) return true; return false; }

	public boolean takeItem(int pos) { waitForShit(); if(rs.itemCount < pos) return false; rs.fdn(rs.smallX, rs.smallY, rs.itemX[pos], rs.itemY[pos], true); rs.connection.newID(TAKEITEMID); rs.connection.addInt(rs.itemX[pos] + rs.bigX); rs.connection.addInt(rs.itemY[pos] + rs.bigY); rs.connection.addInt(rs.itemType[pos]); rs.connection.addInt(0); rs.connection.complete(); return true; }
	public boolean useOnItem(int pos2, int pos) { waitForShit(); if(rs.invCount < pos2) return false; rs.fdn(rs.smallX, rs.smallY, rs.itemX[pos2], rs.itemY[pos2], true); rs.connection.newID(USEONINVID);  rs.connection.addInt(rs.itemX[pos] + rs.bigX); rs.connection.addInt(rs.itemY[pos] + rs.bigY); rs.connection.addInt(rs.itemType[pos]); rs.connection.addInt(pos2); rs.connection.complete(); return true; }

	public void withdraw(int item, int amount) { waitForShit(); rs.connection.newID(WITHDRAWID); rs.connection.addInt(item); rs.connection.addInt(amount); rs.connection.complete(); }
	public void withdraw(int item) { waitForShit(); rs.connection.newID(WITHDRAWID); rs.connection.addInt(item); rs.connection.addInt(1); rs.connection.complete(); }

	public void deposit(int item, int amount) { waitForShit(); rs.connection.newID(DEPOSITID); rs.connection.addInt(item); rs.connection.addInt(amount); rs.connection.complete(); }
	public void deposit(int item) { waitForShit(); rs.connection.newID(DEPOSITID); rs.connection.addInt(item); rs.connection.addInt(1); rs.connection.complete(); }

	public int bankCount(int item) { waitForShit(); for(int i = 0; i < rs.bankTotal; i++) if(rs.bankType[i] == item) return rs.bankCount[i]; return 0; }

	public int findShop(int item) { waitForShit(); for(int i = 0; i < 40; i++) if(rs.shopItem[i] == item) return i; return -1; }
	public boolean inShop(int item) { waitForShit(); for(int i = 0; i < 40; i++) if(rs.shopItem[i] == item) return true; return false; }
	public int buyPrice(int item) { waitForShit(); int j2 = rs.shopItem[findShop(item)]; int i3 = rs.dni + rs.dka[findShop(item)]; if(i3 < 10) i3 = 10; return (i3 * identify.itemPrice[j2]) / 100;	}
	public int sellPrice(int item) { waitForShit(); int j2 = rs.shopItem[findShop(item)]; int i3 = rs.dnh + rs.dka[findShop(item)]; if(i3 < 10) i3 = 10; return (i3 * identify.itemPrice[j2]) / 100; }
	public int shopCount(int item) { waitForShit(); if(findShop(item) == -1) return 0; return rs.shopItemCount[findShop(item)]; }
	public boolean buy(int item) { waitForShit(); if(!inShop(item)) return false; rs.connection.newID(BUYID); rs.connection.addInt(item); rs.connection.addLongInt(buyPrice(item)); rs.connection.complete(); return true; }
	public boolean sell(int item) { waitForShit(); if(!inShop(item)) return false; rs.connection.newID(SELLID); rs.connection.addInt(item); rs.connection.addLongInt(sellPrice(item)); rs.connection.complete(); return true; }

	public boolean duelPlayer(int pos) { waitForShit(); if(rs.playerCount < pos) return false; rs.connection.newID(DUELID); rs.connection.addInt(rs.player[pos].id); rs.connection.complete(); return true; }
	public boolean myItemArray(int item[], int amount[]) { waitForShit(); if(item.length != amount.length) return false; rs.myDuelItem = item; rs.myDuelItemValue = amount; rs.myDuelItemCount = item.length; return true; }
	public boolean updateMyDuelItems() { waitForShit(); if(!rs.duel) return false; rs.connection.newID(DUELUPDATEID); rs.connection.addVar(rs.myDuelItemCount); for (int i = 0; i < rs.myDuelItemCount; i++) { rs.connection.addInt(rs.myDuelItem[i]); rs.connection.addLongInt(rs.myDuelItemValue[i]); } rs.connection.complete(); rs.duelAccepted = false; rs.myPlayerAcceptedDuel = false; return true;}
	public boolean acceptDuel() { waitForShit(); if(!rs.duel) return false; rs.myPlayerAcceptedDuel = true; rs.connection.newID(ACCEPTDUELID); rs.connection.complete(); return true; }
	public boolean duel() { waitForShit(); return rs.duel; }
	public boolean setDuelOptions(boolean noRetreat, boolean noMagic, boolean noPrayer, boolean noWeapons) { if(!rs.duel) return false; rs.connection.newID(SETDUELOPTIONSID); rs.connection.addVar(noRetreat ? 1 : 0); rs.connection.addVar(noMagic ? 1 : 0); rs.connection.addVar(noPrayer ? 1 : 0); rs.connection.addVar(noWeapons ? 1 : 0); rs.connection.complete(); rs.duelAccepted = false; rs.myPlayerAcceptedDuel = false; return true; }
	public boolean duelSecondScreen() { waitForShit(); return rs.duelSecondScreen; }
	public boolean myPlayerAcceptedDuelSecondScreen() { waitForShit(); return rs.myPlayerAcceptedDuelSecondScreen; }
	public boolean acceptDuelSecondScreen() { waitForShit(); if(!rs.duelSecondScreen) return false; rs.myPlayerAcceptedDuelSecondScreen = true; rs.connection.newID(ACCEPTSECONDDUELSCREENID); rs.connection.complete(); return true; }
	public boolean declineDuel() { waitForShit(); if(!rs.duelSecondScreen) return false; rs.duelSecondScreen = false; rs.connection.newID(DECLINEDUELID); rs.connection.complete(); return true; }

	public boolean tradePlayer(int pos) { waitForShit(); if(rs.playerCount < pos) return false; rs.connection.newID(TRADEID); rs.connection.addInt(rs.player[pos].id); rs.connection.complete(); return true; }
	public boolean myTradeArray(int item[], int amount[]) { waitForShit(); if(item.length != amount.length) return false; rs.myTradeItem = item; rs.myTradeItemValue = amount; rs.myTradeItemCount = item.length; return true; }
	public boolean updateMyTradeItems() { waitForShit(); if(!rs.trade) return false; rs.connection.newID(TRADEUPDATEID); rs.connection.addVar(rs.myTradeItemCount); for (int i = 0; i < rs.myTradeItemCount; i++) { rs.connection.addInt(rs.myTradeItem[i]); rs.connection.addLongInt(rs.myTradeItemValue[i]); } rs.connection.complete(); rs.tradeAccepted = false; rs.myPlayerAcceptedTrade = false; return true;}
	public boolean acceptTrade() { waitForShit(); if(!rs.trade) return false; rs.myPlayerAcceptedTrade = true; rs.connection.newID(ACCEPTTRADEID); rs.connection.complete(); return true; }
	public boolean trade() { waitForShit(); return rs.trade; }
	public boolean tradeSecondScreen() { waitForShit(); return rs.tradeSecondScreen; }
	public boolean myPlayerAcceptedTradeSecondScreen() { waitForShit(); return rs.myPlayerAcceptedTradeSecondScreen; }
	public boolean acceptTradeSecondScreen() { waitForShit(); if(!rs.tradeSecondScreen) return false; rs.myPlayerAcceptedTradeSecondScreen = true; rs.connection.newID(ACCEPTSECONDTRADESCREENID); rs.connection.complete(); return true; }
	public boolean declineTrade() { waitForShit(); if(!rs.tradeSecondScreen) return false; rs.tradeSecondScreen = false; rs.connection.newID(DECLINETRADEID); rs.connection.complete(); return true; }

	public int getPathLength(int x, int y) { waitForShit(); int x1 = rs.smallX;	int y1 = rs.smallY; x -= rs.bigX; y -= rs.bigY; int i = (rs.gameHandle.gkb(x1,y1,x,y,x,y,rs.djk,rs.djl,false)); if(i < 0) return -1; int len = 0; for(i--; i >= 0; i--) { int dx = x1 - rs.djk[i]; int dy = y1 - rs.djl[i]; x1 = rs.djk[i]; y1 = rs.djl[i]; if(dx < 0) dx = -dx; if(dy < 0) dy = -dy; if(dx > dy) len += dx; else len += dy; } return len; }

	public int tryToFree() 
	{ 
		int nearestDoor = -1; 
		int nearestDoorDistance = -1; 
		for(int i = 0; i < rs.doorCount; i++) 
			if(rs.doorType[i] == 2) if(nearestDoor == -1 || (doorPathLength(i) < nearestDoorDistance && canReachDoor(i))) 
				nearestDoor = i; 
		if (nearestDoor != -1) 
		{
			println("Trying to open door " + nearestDoor); openDoor(nearestDoor);
			return nearestDoor; 
		}
		nearestDoor = -1; 
		nearestDoorDistance = -1; 
		for(int i = 0; i < rs.objectCount; i++) 
			if(rs.objectType[i] == 60 || rs.objectType[i] == 64)	
				if(nearestDoor == -1 || (objectPathLength(i) < nearestDoorDistance && canReachObject(i))) 
					nearestDoor = i; if (nearestDoor != -1) 
					{	
						println("Trying to open object " + nearestDoor); 
						atObject(nearestDoor);	
						return nearestDoor;	
					} 
		return -1; 
	}

	public void say(String message) { waitForShit(); int j4 = v.cek(message); rs.acm(v.ceg, j4); message = v.cej(v.ceg, 0, j4); message = u.fgd(message); rs.myPlayer.lastSaidTimeout = 150; rs.myPlayer.lastSaid = message; rs.displayMessage(rs.myPlayer.name + ": " + message, 2); }

	public int playerByName(String name) { waitForShit(); for(int i = 0; i < rs.playerCount; i++) if(rs.player[i].name.equals(name)) return i; return -1; }
	public boolean playerNameExists(String name) { waitForShit(); for(int i = 0; i < rs.playerCount; i++) if(rs.player[i].name.equals(name)) return true; return false; }
	public String lastChatMessage() { waitForShit(); return rs.lastChatMessage; }
	public String lastChatter() { waitForShit(); return rs.lastChatter; }
	public boolean inLastChatMessage(String str) { waitForShit(); if(rs.lastChatMessage.indexOf(str) >= 0) return true; return false; }
	public String lastQuestMeessage() { waitForShit(); return rs.lastQuestMessage; }
	public int lastQuestNpcId() { waitForShit(); return rs.lastQuestNpcId; }
	public boolean inLastQuestMessage(String str) { waitForShit(); if(rs.lastQuestMessage.indexOf(str) >= 0) return true; return false; }
	public void resetLastQuestMessage() { waitForShit(); rs.lastQuestMessage = ""; rs.lastQuestNpcId = -1; }
	public String lastPM() { waitForShit(); return rs.lastPM; }
	public String lastPMer() { waitForShit(); return rs.lastPMer; }
	public void resetLastPM() { waitForShit(); rs.lastPM = ""; rs.lastPMer = ""; }

	public void serverMessage(String message) { }
	public void questMessage(String message, int npcId) { }
	public void tradeRequest(String playerName) { }
	public void duelRequest(String playerName) { }
	public void newNpc() { } 

	/*public void addToFriends(String name) { waitForShit(); if(!onFriendsList(name)) return; rs.addFriend(name); }
	public void removeFromFriends(String name) { waitForShit(); if(findFriend(name) == -1) return; rs.ack(findFriend(name)); }
	public void sendToFriend(String name, String message) { waitForShit(); int j1 = v.cek(message); rs.acl(findFriend(name), v.ceg, j1); s2 = v.cej(v.ceg, 0, j1); s2 = u.fgd(message); }
	public boolean onFriendsList(String name) { waitForShit(); if(findFriend(name)) return true; return false; }
	public boolean friendOnline(String name) { waitForShit(); return false; }
	public int friendWorld(String name) { waitForShit(); if(!onFriendsList(name)) return 0;  }
	public int friendCount() { waitForShit(); return rs.friendCount; }
	public int findFriend(String name) { waitForShit(); for(int i = 0; i < rs.friendCount; i++) if(t.grabFriendName(super.friendID[i]).equals(name)) return i; return -1; }
*/

	public final int TRADEID = 39;
	public final int ACCEPTTRADEID = 145;
	public final int TRADEUPDATEID = 24;
	public final int DECLINETRADEID = 216;
	public final int ACCEPTSECONDTRADESCREENID = 145;
	public final int DECLINEDUELID = 92;
	public final int ACCEPTSECONDDUELSCREENID = 125;
	public final int SETDUELOPTIONSID = 128;
	public final int ACCEPTDUELID = 208;
	public final int DUELUPDATEID = 153;
	public final int DUELID = 170;
	public final int BUYID = 76;
	public final int SELLID = 139;
	public final int CLOSEBANKID = 64;
	public final int ATOBJECTID = 171;
	public final int ATOBJECT2ID = 67;
	public final int OPENDOORID = 151;
	public final int CLOSEDOORID = 50;
	public final int USEONOBJECTID = 150;
	public final int USEONDOORID = 157;
	public final int DEPOSITID = 179;
	public final int WITHDRAWID = 152;
	public final int ALTNPCID = 83;
	public final int TALKTONPCID = 207;
	public final int ATTACKNPCID = 142;
	public final int USEONITEMID = 199;
	public final int TAKEITEMID = 43;
	public final int CASTONINVID = 192;
	public final int USEONINVID = 60;
	public final int REMOVEID = 130;
	public final int WIELDID = 105;
	public final int DROPID = 45;
	public final int USEID = 137;
	public final int FIGHTMODEID = 148;
	public final int QUESTMENUID = 68;
}