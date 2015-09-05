package bot;
import pack11.Class3;
import pack12.*;

public abstract class Methods {
	public Client mc;
	
	public Methods(Client mc) {
		this.mc = mc;
	}
	
	public String command() { return this.getClass().getName().toUpperCase(); }
	
	public void main(String args[]) { }
	
	public void onKeyPress(int key) { }
	
	public void onStop() { }
	public boolean onServerMessage(String s) { return false; }
	public void handleCommand(String s) { }
	public void onNPCMessage(int id, String name, String message) { }
	public void onChatMessage(int modstatus, String name, String message) { }
	public void drawInfo(int baseX, int baseY) { }
	public void drawString(String text, int x, int y, int size, int color) { mc.method80(text, x, y, size, color); }
	
	public boolean running() { return mc.running; }
	
	public void stop() { mc.stopMacro(); }
	
	public int areaX() { return mc.anInt1035; }
	public int areaY() { return mc.anInt1036; }
	public int sectionX() { return mc.anInt1157; }
	public int sectionY() { return mc.anInt1158; }
	
	public int npcCount() { return mc.anInt1003; }
	public int playerCount() { return mc.anInt976; }
	public int objectCount() { return mc.anInt1242; }
	public int groundItemCount() { return mc.anInt1163; }
	public int doorCount() { return mc.anInt1220; }
	public boolean questionMenu() { return mc.aBoolean1013; }
	public boolean inBank() { return mc.aBoolean985; }
	public int inventoryCount() { return mc.anInt979; }
	public int inventoryItem(int slot) { return mc.anIntArray980[slot]; }
	public String getNPCName(int id) { return Class3.method235(id).method292(); }
	
	public boolean loading() { return mc.loading; }
	
	public boolean sleeping() { return mc.aBoolean1289; }
	public long fatigue() { return mc.aLong1276; }
	public long experienceGained() { return mc.aLong1284; }
	
	public int getStatCurrent(int i) { return mc.anIntArray1034[i]; }
	public int getStatBase(int i) { return mc.anIntArray1112[i]; }
	public int getStatExperience(int i) { return mc.anIntArray1189[i]; }
	
	public Class9_Sub2 getItem(int i) { return Class3.method236(i); }
	public int getItemBySlot(int slot) { return mc.anIntArray980[slot]; }
	
	public void walkToWait(int x, int y) {
		while(!imAt(x, y) && running() && !inCombat(ourPlayer())) {
			walkTo(x, y);
			wait(random(2000, 3000));
		}
	}
	
	public String getItemName(int id) {
		for(int i = 0; i < Class3.items.size(); i++) {
			Class9_Sub2 itemDef = (Class9_Sub2)Class3.items.get(i);
			if(i == id)
				return itemDef.method292();
		}
		return null;
	}
	
	public boolean getBoolean(String title) {
		mc.menuOption = -1;
		mc.menuTitle = title;
		mc.showYesNoMenu = true;
		while(mc.showYesNoMenu)
			wait(100);
		return mc.menuOption == 1 ? true : false;
	}
	
	public int getOption(String title, String options[]) {
		mc.menuOption = -1;
		mc.menuStart = 0;
		mc.menuTitle = title;
		mc.menuOptions = options;
		mc.showOptionMenu = true;
		while(mc.showOptionMenu)
			wait(100);
		return mc.menuOption;
	}
	
	public int getNPCIndexInArea(int x1, int y1, int x2, int y2) {
		try {
			for(int i = 0; i < npcCount(); i++) {
				int npcX = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
				int npcY = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
				if(inArea(npcX, npcY, x1, y1, x2, y2))
					return mc.aClass31Array991[i].anInt295;
			}
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public int getNPCIndexAt(int x, int y) {
		try {
			for(int i = 0; i < npcCount(); i++) {
				int npcX = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
				int npcY = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
					System.out.println(x+","+y+" found npc at " + npcX + "," + npcY + "," + mc.aClass31Array991[i].anInt295);
				if(npcX == x && npcY == x) {
					return mc.aClass31Array991[i].anInt295;
				}
			}
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public int getDoorIndex(int x, int y) {
		try {
			for(int i = 0; i < doorCount(); i++) {
				if(mc.anIntArray1207[i] == (x - areaX()) && mc.anIntArray1208[i] == (y - areaY())) {
					return i;
				}
			}
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public int getDoorID(int x, int y) {
		try {
			for(int i = 0; i < doorCount(); i++)
				if(mc.anIntArray1207[i] == (x - areaX()) && mc.anIntArray1208[i] == (y - areaY()))
					return mc.anIntArray1222[i];
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public void useDoor(int x, int y) {
		int idx = getDoorIndex(x, y);
		if(idx == -1)
			return;
		mc.anIntArray1054[0] = 320;
		mc.anIntArray1154[0] = mc.anIntArray1207[idx];
		mc.anIntArray1155[0] = mc.anIntArray1208[idx];
		mc.anIntArray1117[0] = mc.anIntArray1221[idx];
		mc.method88(0);
	}
	
	public int getObjectID(int x, int y) {
		try {
			for(int i = 0; i < objectCount(); i++)
				if(mc.anIntArray1150[i] == (x - areaX()) && mc.anIntArray1151[i] == (y - areaY()))
					return mc.anIntArray1152[i];
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public String formatNumber(String s) {
		if(s.length() < 4)
			return s;
		else
			return formatNumber(s.substring(0, s.length() - 3)) + "," + s.substring(s.length() - 3, s.length());
	}

	public boolean inArea(int x1, int y1, int x2, int y2) {
		return inArea(areaX() + sectionX(), areaY() + sectionY(), x1, y1, x2, y2);
	}
	
	public boolean inArea(int x, int y, int x1, int y1, int x2, int y2) {
		return x >= x1 && x <= x2 && y >= y1 && y <= y2;
	}
	
	public boolean reachable(int x, int y) {
		return mc.aClass17_1170.method363(sectionX(), sectionY(), x - areaX(), y - areaY(), x - areaX(), y - areaY(), mc.anIntArray1041, mc.anIntArray1042, false) != -1;
	}
	
	public int itemCount(int id) { return mc.method58(id); }
	public int bankItemCount(int id) {
		for(int i = 0; i < mc.anInt1123; i++)
			if(mc.anIntArray1177[i] == id)
				return mc.anIntArray1178[i];
		return -1;
	}
	
	public void dropItem(int slot) {
		mc.anIntArray1054[0] = 660;
		mc.anIntArray1117[0] = slot;
		mc.method88(0);
	}
	
	public int getItemID(String name) {
		for(int i = 0; i < Class3.items.size(); i++) {
			Class9_Sub2 itemDef = (Class9_Sub2)Class3.items.get(i);
			if(itemDef.method292().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean haveItemInBank(int id) {
		for(int i = 0; i < mc.anIntArray1177.length; i++) {
			if(mc.anIntArray1177[i] == id)
				return true;
		}
		return false;
	}
	
	public int getBankSlot(int id) {
		for(int i = 0; i < mc.anIntArray1177.length; i++) {
			if(mc.anIntArray1177[i] == id)
				return i;
		}
		return -1;
	}
	
	public String getObjectAction(int id, boolean primary) {
		if(primary)
			return Class3.method247(id).method295();
		else
			return Class3.method247(id).method296();
	}
	
	public boolean objectHasAction(int id, String action) {
		if(Class3.method247(id).method295().equalsIgnoreCase(action)
				|| Class3.method247(id).method296().equalsIgnoreCase(action))
			return true;
		return false;
	}
	public int getObjectID(int index) { return mc.anIntArray1152[index]; }
	public int getObjectX(int index) { return mc.anIntArray1150[index]; }
	public int getObjectY(int index) { return mc.anIntArray1151[index]; }
	
	public String timeSince(long time) {
		int seconds = (int)((System.currentTimeMillis() - time) / 1000);
		int minutes = (int)(seconds / 60);
		int hours = (int)(minutes / 60);
		int days = (int)(hours / 24);
		return (hours % 24) + " hours " + (minutes % 60) + " mins";
	}
	
	public int[] getObjectIndex(int id) {
		try {
			int distance = 50000;
			int r[] = {-1, -1, -1};
			for(int i = 0; i < objectCount(); i++)
				if(mc.anIntArray1152[i] == id) {
					int temp = distanceTo(myPos()[0], myPos()[1], mc.anIntArray1150[i] + areaX(), mc.anIntArray1151[i] + areaX());
					if(temp < distance) {
						r[0] = i;
						r[1] = mc.anIntArray1150[i] + areaX();
						r[2] = mc.anIntArray1151[i] + areaY();
						distance = temp;
					}
				}
			return r;
		}
		catch(Exception e) { return new int[]{-1}; }
	}
	
	public void withdraw(int id, int amount) {
		try {
			mc.aClass33_Sub1_767.method558(24);
			mc.aClass33_Sub1_767.method546(id);
			mc.aClass33_Sub1_767.method544(amount);
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public void withdrawAll(int id) {
		try {
			mc.aClass33_Sub1_767.method558(24);
			mc.aClass33_Sub1_767.method546(id);
			mc.aClass33_Sub1_767.method544(bankItemCount(id));
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public void deposit(int id, int amount) {
		try {
			mc.aClass33_Sub1_767.method558(25);
			mc.aClass33_Sub1_767.method546(id);
			mc.aClass33_Sub1_767.method544(amount);
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public void depositAll(int id) {
		try {
			mc.aClass33_Sub1_767.method558(25);
			mc.aClass33_Sub1_767.method546(id);
			mc.aClass33_Sub1_767.method544(mc.method58(id));
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public void closeBank() {
		try {
			if(inBank()) {
				mc.aClass33_Sub1_767.method558(26);
				mc.aClass33_Sub1_767.method541();
				mc.aBoolean985 = false;
			}
		}
		catch(Exception e) { }
	}
	
	public void talkToNPC(int index, int x, int y) {
		try {
			walkTo(x, y);
			mc.aClass33_Sub1_767.method558(8);
            mc.aClass33_Sub1_767.method546(mc.aClass31Array991[index].anInt295);
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public void talkToNPC(int index) {
		try {
			mc.anIntArray1054[0] = 720;
			mc.anIntArray1154[0] = mc.aClass31Array991[index].anInt298;
			mc.anIntArray1155[0] = mc.aClass31Array991[index].anInt299;
			mc.anIntArray1117[0] = mc.aClass31Array991[index].anInt295;
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void answerQuestion(int i) {
		try {
			mc.aClass33_Sub1_767.method558(17);
			mc.aClass33_Sub1_767.method542(i);
			mc.aClass33_Sub1_767.method541();
		}
		catch(Exception e) { }
	}
	
	public pack5.pack6.pack7.Class31 ourPlayer() { return mc.aClass31_1156; }
	public pack5.pack6.pack7.Class31[] playerArray() { return mc.aClass31Array1171; }
	
	public int getItemSlot(int id) {
		try {
			for(int i = 0; i < mc.anInt979; i++)
				if(mc.anIntArray980[i] == id)
					return i;
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public void useItemOnObject(int slot, int x, int y) {
		try {
			int idx = getObjectIndex(x, y);
			if(idx == -1)
				return;
			mc.anIntArray1054[0] = 410;
			mc.anIntArray1154[0] = mc.anIntArray1150[idx];
			mc.anIntArray1155[0] = mc.anIntArray1151[idx];
			mc.anIntArray1117[0] = mc.anIntArray1153[idx];
			mc.anIntArray1118[0] = mc.anIntArray1152[idx];
			mc.anIntArray1119[0] = slot;
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void useItemOnObject(int slot, int id) {
		try {
			int object[] = getObjectIndex(id);
			if(object[0] == -1)
				return;
			mc.anIntArray1054[0] = 410;
			mc.anIntArray1154[0] = mc.anIntArray1150[object[0]];
			mc.anIntArray1155[0] = mc.anIntArray1151[object[0]];
			mc.anIntArray1117[0] = mc.anIntArray1153[object[0]];
			mc.anIntArray1118[0] = mc.anIntArray1152[object[0]];
			mc.anIntArray1119[0] = slot;
			mc.method88(0);
			
		}
		catch(Exception e) { }
	}
	
	public void useItem(int slot) {
		try {
			mc.anIntArray1054[0] = 640;
			mc.anIntArray1117[0] = slot;
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void wait(int min, int max) {
		wait(random(min, max));
	}
	
	public void wait(int i) {
		try {
			Thread.sleep(i);
		}
		catch(Exception e) { }
	}
	
	public int[] myPos() {
		try {
			return new int[] {mc.anInt1157 + mc.anInt1035, mc.anInt1158 + mc.anInt1036};
		}
		catch(Exception e) { return new int[]{-1}; }
	}
	
	public int random(int min, int max) {
		try {
			return (int) (min + Math.random() * (max - min));
		}
		catch(Exception e) { return -1; }
	}
	
	public void printMessage(Object message) {
		try {
			String msg = String.valueOf(message);
			String colors[] = {"red", "lre", "yel", "gre", "blu", "cya", "mag", "whi", "bla", "dre",
				"ora", "ran", "or1", "or2", "or3", "gr1", "gr2", "gr3"};
			for(int i = 0; i < colors.length; i++)
				msg = msg.replaceAll("@" + colors[i] + "@", "");
			System.out.println(msg);
			mc.method121(String.valueOf(message), 3, 0);
		}
		catch(Exception e) { }
	}
	
	public int distanceTo(int x, int y, int x2, int y2) {
		try {
			double dx = Math.pow(Math.abs(x - x2), 2);
			double dy = Math.pow(Math.abs(y - y2), 2);
			return (int) Math.sqrt(dx + dy);
		}
		catch(Exception e) { return -1; }
	}
	
	public int getObjectIndex(int x, int y) {
		try {
			for(int i = 0; i < objectCount(); i++) {
				if(mc.anIntArray1150[i] == (x - areaX()) && mc.anIntArray1151[i] == (y - areaY())) {
					return i;
				}
			}
			return -1;
		}
		catch(Exception e) { return -1; }
	}
	
	public void useObject2(int x, int y) {
		useObject(x, y, false);
	}
	
	public void useObject(int x, int y) {
		useObject(x, y, true);
	}
	
	public void useObject(int x, int y, boolean primary) {
		try {
			int idx = getObjectIndex(x, y);
			if(idx == -1)
				return;
			mc.anIntArray1054[0] = primary ? 420 : 2400;	// menuID
			mc.anIntArray1154[0] = mc.anIntArray1150[idx];		// menuActionX		objectX
			mc.anIntArray1155[0] = mc.anIntArray1151[idx];		// menuActionY		objectY
			mc.anIntArray1117[0] = mc.anIntArray1153[idx];	// menuActionType	objectID
			mc.anIntArray1118[0] = mc.anIntArray1152[idx];//menuActionVariable	objectType
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void attackNPCWait(int idx) {
		try {
			while(!inCombat(ourPlayer()) || !inCombat(mc.aClass31Array991[idx]) && !sleeping() && running()) {
				attackNPC(idx);
				wait(random(2000, 3000));
			}
		}
		catch(Exception e) { }
	}
	
	public void attackNPC(int idx) {
		try {
			mc.anIntArray1054[0] = 715;
			mc.anIntArray1154[0] = mc.aClass31Array991[idx].anInt298;	// npcArray	currentX
			mc.anIntArray1155[0] = mc.aClass31Array991[idx].anInt299;	// 			currentY
			mc.anIntArray1117[0] = mc.aClass31Array991[idx].anInt295;//			serverIndex
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void castOnNPC(int spell, int idx) {
		try {
			mc.anIntArray1054[0] = 700;
			mc.anIntArray1154[0] = mc.aClass31Array991[idx].anInt298;
			mc.anIntArray1155[0] = mc.aClass31Array991[idx].anInt299;
			mc.anIntArray1117[0] = mc.aClass31Array991[idx].anInt295;
			mc.anIntArray1118[0] = spell;
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public void walkTo(int x, int y) {
		try {
			mc.anIntArray1054[0] = 920;
			mc.anIntArray1154[0] = x - areaX();
			mc.anIntArray1155[0] = y - areaY();
			mc.method88(0);
		}
		catch(Exception e) { }
	}
	
	public boolean imAt(int x, int y) {
		if(myPos()[0] == x && myPos()[1] == y)
			return true;
		return false;
	}
	
	public pack5.pack6.pack7.Class31 getNPC(int index) {
		return mc.aClass31Array991[index];
	}
	
	public int[] getNPCIndex(String name) {
		name = name.toLowerCase();
		for(int i = 0; i < npcCount(); i++) {
			int type = mc.aClass31Array991[i].anInt310;
			System.out.println(name + "," + getNPCName(type) + "," + type + "," + i);
			if(getNPCName(type).toLowerCase().equals(name))
				return getNPCIndex(type);
		}
		return new int[] {-1, -1, -1, -1};
	}
	
	public int[] getNPCIndexRandom(int id) {
        int min[] = { -1, -1, -1, -1};
        for (int j = 0; j < npcCount(); j++) {
            if (mc.aClass31Array991[j].anInt310 == id && mc.aClass31Array991[j].anInt301 != 8 && mc.aClass31Array991[j].anInt301 != 9) {
                int NpcX = ((mc.aClass31Array991[j].anInt298 - 64) / 128) + areaX();
                int NpcY = ((mc.aClass31Array991[j].anInt299 - 64) / 128) + areaY();
				min[0] = j;
				min[1] = NpcX;
				min[2] = NpcY;
				min[3] = mc.aClass31Array991[j].anInt310;
            }
        }
        return min;
	}
	
	public int[] getNPCIndex(int id) {
		/*try {
			int distance = 50000;
			int r[] = {-1, -1, -1, -1};
			for(int i = 0; i < npcCount(); i++)
				if(mc.aClass31Array991[i].anInt310 == id && !inCombat(mc.aClass31Array991[i])) {	// anInt310 = type
					int temp = distanceTo(myPos()[0], myPos()[1], ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX(), ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY());
					if(temp < distance) {
						r[0] = i;
						r[1] = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
						r[2] = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
						r[3] = mc.aClass31Array991[i].anInt310;
						distance = temp;
					}
				}
			return r;
		}
		catch(Exception e) { return new int[]{-1}; }*/
        int min[] = { -1, -1, -1, -1};
        int mint = 50000;

        for (int j = 0; j < npcCount(); j++) {
            if (mc.aClass31Array991[j].anInt310 == id && mc.aClass31Array991[j].anInt301 != 8 && mc.aClass31Array991[j].anInt301 != 9) {
                int NpcX = ((mc.aClass31Array991[j].anInt298 - 64) / 128) + areaX();
                int NpcY = ((mc.aClass31Array991[j].anInt299 - 64) / 128) + areaY();
                int temp = distanceTo(NpcX, NpcY, myPos()[0], myPos()[1]);

                if (temp < mint) {
                    min[0] = j;
                    min[1] = NpcX;
                    min[2] = NpcY;
					min[3] = mc.aClass31Array991[j].anInt310;
                    mint = temp;
                }
            }
        }
        return min;
	}
	
	public int[] getAttackableNPCIndex() {try{
		int min[] = {-1, -1, -1, -1};
		int mint = 50000;
		for(int i = 0; i < npcCount(); i++) {
			Class9_Sub3 mob = Class3.method235(mc.aClass31Array991[i].anInt310);
			if(mob.method322()) {
                int NpcX = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
                int NpcY = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
                int temp = distanceTo(NpcX, NpcY, myPos()[0], myPos()[1]);
				if(temp < mint) {
					min[0] = i;
					min[1] = NpcX;
					min[2] = NpcY;
					min[3] = mc.aClass31Array991[i].anInt310;
					mint = temp;
				}
			}
		}
		return min;}catch(Exception e){return new int[]{-1};}
	}
	
	public int[] getAttackableNPCIndex(int not) {try{
		int min[] = {-1, -1, -1, -1};
		int mint = 50000;
		for(int i = 0; i < npcCount(); i++) {
			if(i == not)
				continue;
			Class9_Sub3 mob = Class3.method235(mc.aClass31Array991[i].anInt310);
			if(mob.method322()) {
                int NpcX = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
                int NpcY = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
                int temp = distanceTo(NpcX, NpcY, myPos()[0], myPos()[1]);
				if(temp < mint) {
					min[0] = i;
					min[1] = NpcX;
					min[2] = NpcY;
					min[3] = mc.aClass31Array991[i].anInt310;
					mint = temp;
				}
			}
		}
		return min;}catch(Exception e){return new int[]{-1};}
	}
	
	public int[] getNPCIndex(int id, int cantbe) {
		try {
			int distance = 50000;
			int r[] = {-1, -1, -1, -1};
			for(int i = 0; i < npcCount(); i++) {
				if(i == cantbe)
					continue;
				if(mc.aClass31Array991[i].anInt310 == id && !inCombat(mc.aClass31Array991[i])) {	// anInt310 = type
					int temp = distanceTo(myPos()[0], myPos()[1], ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX(), ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY());
					if(temp < distance) {
						r[0] = i;
						r[1] = ((mc.aClass31Array991[i].anInt298 - 64) / 128) + areaX();
						r[2] = ((mc.aClass31Array991[i].anInt299 - 64) / 128) + areaY();
						r[3] = mc.aClass31Array991[i].anInt310;
						distance = temp;
					}
				}
			}
			return r;
		}
		catch(Exception e) { return new int[]{-1}; }
	}
	
	public boolean inCombat(pack5.pack6.pack7.Class31 mob) {
		try {
			if(mob.anInt301 == 8 || mob.anInt301 == 9)
				return true;
			return false;
		}
		catch(Exception e) { return false; }
	}
}
