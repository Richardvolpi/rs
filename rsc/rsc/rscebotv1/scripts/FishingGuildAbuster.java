import bot.*;
public class FishingGuildAbuster extends Methods {
	public FishingGuildAbuster(Client c){super(c);}
	public String command(){return "lobhax";}
	public void main(String args[]) {
		// master fisherman
		while(running()) {
			int npc[] = getNPCIndex(368);
			if(npc[0] == -1)
				continue;
			if(inventoryCount() != 30) {
				while(!questionMenu()) {
					talkToNPC(npc[0]);
					wait(random(3000, 4000));
				}
				answerQuestion(0);
				wait(500);
			}
			while(!imAt(586, 523)) {
				useDoor(586, 524);
				wait(random(2000, 3000));
			}
			while(getDoorID(586, 519) == 2) {
				useDoor(586, 519);
				wait(random(1000, 2000));
			}
			while(!imAt(601, 508)) {
				walkTo(601, 508);
				wait(random(2000, 3000));
			}
			while(getDoorID(603, 506) == 2) {
				useDoor(603, 506);
				wait(random(1000, 2000));
			}
			npc = getNPCIndex(369);
			while(npc[0] == -1)
				npc = getNPCIndex(369);
			while(npc[3] != 369)
				npc = getNPCIndex(369, npc[0]);
			while(!questionMenu()) {
				talkToNPC(npc[0]);
				wait(random(3000, 4000));
			}
			answerQuestion(1);
			while(!lastServerMessage.contains("what sort of fish"))
				wait(500);
			wait(500);
			answerQuestion(0);
			while(!lastServerMessage.contains("how many fish"))
				wait(500);
			wait(500);
			answerQuestion(4);
			int oldcount = itemCount(533);
			while(oldcount == itemCount(533))
				wait(500);
			wait(500);
			while(!imAt(589, 516)) {
				walkTo(589, 516);
				wait(random(2000, 3000));
			}
			while(getDoorID(586, 519) == 2) {
				useDoor(586, 519);
				wait(random(1000, 2000));
			}
			while(!imAt(586, 524)) {
				useDoor(586, 524);
				wait(random(2000, 3000));
			}
		}
	}
	public String lastServerMessage = "";
	public boolean onServerMessage(String s) {
		lastServerMessage = s.toLowerCase();
		return false;
	}
}
