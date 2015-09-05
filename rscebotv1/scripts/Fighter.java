import bot.*;
public class Fighter extends Methods {
	public Fighter(Client mc) {
		super(mc);
	}
	public String command() { return "fighter"; }
	
	public void main(String args[]) {
		printMessage("Fighter started");
		int x[] = new int[5];
		int y[] = new int[5];
		int pointer = 0;
		while(running()) {
			while(itemCount(373) > 0) {
				while(sleeping() && running())
					wait(100);
				if(getStatCurrent(3) < getStatBase(3) - 20) {
					useItem(getItemSlot(373));
					wait(random(1000, 2000));
				}
				while(inCombat(ourPlayer()) && running())
					wait(500);
				int npc[] = getAttackableNPCIndex();
				if(npc[0] != -1) {
					walkToWait(npc[1], npc[2]);
					attackNPCWait(npc[0]);
				}
			}
			while(itemCount(373) == 0) {
				walkToWait(324, 550);
				while(!questionMenu() && running()) {
					talkToNPC(getNPCIndex(95)[0]);
					wait(random(3000, 4000));
				}
				answerQuestion(0);
				while(!inBank() && running())
					wait(1000);
				if(bankItemCount(373) == 0)
					stop();
				if(bankItemCount(373) > 0) {
					withdrawAll(373);
				}
				wait(random(1000, 2000));
			}
		}
	}
	
	public void onStop() {
		printMessage("Fighter stopped");
	}
}
