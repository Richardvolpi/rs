import bot.*;
public class Chickens extends Methods {
	public Chickens(Client mc) {
		super(mc);
	}
	
	public void main(String args[]) {
		int imAtX[] = new int[5];
		int imAtY[] = new int[5];
		int imAtC = 0;
		while(running()) {
			while(sleeping())
				wait(500);
			int index = getNPCIndex(3)[0];
			if(running() && imAt(122, 647) && !sleeping() && fatigue() < 100L) {
				int x = random(133, 135);
				int y = random(633, 635);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 5000));
				}
				x = random(147, 149);
				y = random(620, 622);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 5000));
				}
				x = random(120, 122);
				y = random(625, 627);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 5000));
				}
				x = random(106, 108);
				y = random(618, 620);
				while(!imAt(x, y)) {
					walkTo(x, y);
					wait(random(2000, 5000));
				}
			}
			if(running() && index != -1 && !inCombat(ourPlayer()) && !sleeping() && fatigue() < 100L) {
				if(imAtC == 4)
					imAtC = 0;
				imAtX[imAtC] = myPos()[0];
				imAtY[imAtC] = myPos()[1];
				imAtC ++;
				attackNPC(index);
				wait(200, 800);
			}
			if(fatigue() == 100L) {
				useItem(getItemSlot(1263));
				wait(500);
			}
			wait(200, 800);
		}
	}
	
	public void onStop() {
		printMessage("Chickens stopped, maybe fatigue is 100?");
	}
}
