import bot.*;
public class LostCityCooker extends Methods {
	public LostCityCooker(Client mc){super(mc);}
	public String command() { return "lccook"; }
	public void main(String args[]) {
		int food = getOption("Which food would you like to cook?", new String[]{"Lobster", "Swordfish", "Shark"});
		if(food == -1) {
			printMessage("@or2@Cooker: @yel@You must choose a food");
			stop();
		}
		int RAW = -1;
		int COOKED = -1;
		int BURNT = -1;
		if(food == 0) {
			RAW = 372;
			COOKED = 373;
			BURNT = 374;
		}
		else if(food == 1) {
			RAW = 369;
			COOKED = 370;
			BURNT = 371;
		}
		else if(food == 2) {
			RAW = 545;
			COOKED = 546;
			BURNT = 547;
		}
		long time = 0L;
		while(running()) {
			while(itemCount(RAW) == 0 && running()) {
				while(!questionMenu() && running()) {
					time = System.currentTimeMillis();
					int banker[] = getNPCIndex(224);
					if(banker[0] != -1)
						talkToNPC(banker[0]);
					while(System.currentTimeMillis() - time < 5000 && !questionMenu() && running())
						wait(1000);
				}
				wait(500);
				answerQuestion(0);
				wait(1000);
				time = System.currentTimeMillis();
				while(!inBank() && running() && System.currentTimeMillis() - time < 5000)
					wait(100);
				if(itemCount(COOKED) > 0)
					depositAll(COOKED);
				wait(random(500, 1000));
				withdrawAll(RAW);
				wait(random(500, 1000));
				closeBank();
			}
			while(itemCount(RAW) > 0 && running()) {
				for(int i = 0; i < inventoryCount(); i++) {
					if(inventoryItem(i) != 1263 && inventoryItem(i) != RAW && inventoryItem(i) != COOKED) {
						dropItem(getItemSlot(inventoryItem(i)));
						wait(random(2000, 2500));
					}
				}
				if(sleeping())
					wait(100);
				else {
					useItemOnObject(getItemSlot(RAW), 172, 3534);
					wait(random(3000, 4000));
				}
			}
		}
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		if(s.contains("you cook the")) {
			return true;
		}
		else if(s.contains("is now nicely cooked"))
			return true;
		else if(s.contains("you accidently burn the")) {
			return true;
		}
		
		return false;
	}
	
	public void onStop() {
		printMessage("@or2@Cooker: @yel@stopped");
	}
	
	public char CHECKS = 0;
	public char COOK_FISH = 1;
	public char DROP_BURNT = 2;
	public char DO_BANKING = 3;
}
