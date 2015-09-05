import bot.*;
public class EdgeLobCooker extends Methods {
	public EdgeLobCooker(Client c){super(c);}
	public String command(){return "edgelobs";}
	
	public String lastServerMessage = "";
	
	public void main(String args[]) {
		int RAW = 372;
		int COOKED = 373;
		int BURNT = 374;
		while(running()) {
			while(!questionMenu()) {
				int npc = getNPCIndex(95)[0];
				if(lastServerMessage.contains("banker is currently busy"))
					npc = getNPCIndex(95, npc)[0];
				talkToNPC(npc);
				wait(random(3000, 4000));
			}
			while(getDoorID(225, 444) == 2) {
				useDoor(225, 444);
				wait(random(1000, 2000));
			}
			while(getDoorID(217, 447) == 2) {
				useDoor(217, 447);
				wait(random(1000, 2000));
			}
			answerQuestion(0);
			while(!inBank())
				wait(500);
			depositAll(COOKED);
			wait(random(500, 1000));
			if(haveItemInBank(RAW))
				withdrawAll(RAW);
			wait(500);
			closeBank();
			while(!inArea(222, 1383, 227, 1387)) {
				if(getDoorID(217, 447) == 64)
					useDoor(217, 447);
				else if(getDoorID(225, 444) == 2)
					useDoor(225, 444);
				else
					useObject(226, 439);
				wait(random(1000, 2000));
			}
			while(itemCount(RAW) > 0) {
				useItemOnObject(getItemSlot(RAW), 222, 1385);
				wait(random(2500, 3300));
			}
			while(itemCount(BURNT) > 0) {
				dropItem(getItemSlot(BURNT));
				wait(random(1000, 2000));
			}
			while(!inArea(222, 439, 227, 443)) {
				useObject(226, 1383);
				wait(random(1000, 2000));
			}
		}
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		lastServerMessage = s;
		return false;
	}
}
