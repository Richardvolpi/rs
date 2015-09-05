import bot.*;
public class Caster extends Methods {
	public Caster(Client mc) {
		super(mc);
	}
	public String command() { return "caster"; }
	
	public void main(String args[]) {
		printMessage("Autocaster started");
		while(running()) {
			while(itemCount(373) > 0 && !inCombat(ourPlayer()) && running()) {
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
					castOnNPC(0, npc[0]);
				}
			}
			while(itemCount(373) == 0 && !inCombat(ourPlayer()) && running()) {
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
			while(inCombat(ourPlayer())) {
				walkTo(myPos()[0], myPos()[1]);
				wait(random(300, 800));
			}
		}
	}
	
	public void onStop() {
		printMessage("Autocaster stopped");
	}
}
