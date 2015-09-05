import bot.*;
public class FalaBronzeSmelter extends Methods {
	public FalaBronzeSmelter(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		int x, y;
		printMessage("@or2@Smelter: @yel@Falador bronze smelter started");
		while(running()) {
			while(!questionMenu()) {
				talkToNPC(getNPCIndex(95)[0]);
				wait(random(3000, 4000));
			}
			answerQuestion(0);
			while(!inBank())
				wait(1000);
			wait(random(500, 1500));
			if(itemCount(169) > 0) {
				depositAll(169);
				wait(random(500, 1000));
			}
			withdraw(150, 14);
			wait(random(500, 1000));
			withdraw(202, 14);
			wait(random(500, 1000));
			closeBank();
			x = 324;
			y = 552;
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(1000, 2000));
			}
			x = 313;
			y = 545;
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(1000, 2000));
			}
			while(itemCount(150) > 0 && itemCount(202) > 0) {
				if(sleeping())
					wait(100);
				useItemOnObject(getItemSlot(150), 118);
				wait(random(1000, 2000));
			}
			x = 313;
			y = 545;
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(1000, 2000));
			}
			x = 324;
			y = 552;
			while(!imAt(x, y)) {
				walkTo(x, y);
				wait(random(1000, 2000));
			}
			wait(1000);
		}
	}
}