import bot.*;
public class GuildMiner extends Methods {
	public GuildMiner(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		long time = 0L;
		while(running()) {
			while(itemCount(153) > 0 && running()) {
				while(getDoorID(287, 571) == 64 && running()) {
					useDoor(287, 571);
					wait(random(2000, 3000));
				}
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
				if(itemCount(153) > 0) {
					depositAll(153);
					wait(random(500, 1000));
				}
				if(itemCount(154) > 0) {
					depositAll(154);
					wait(random(500, 1000));
				}
				if(itemCount(158) > 0) {
					depositAll(158);
					wait(random(500, 1000));
				}
				if(itemCount(159) > 0) {
					depositAll(159);
					wait(random(500, 1000));
				}
				if(itemCount(160) > 0) {
					depositAll(160);
					wait(random(500, 1000));
				}
				closeBank();
			}
			while(getDoorID(287, 571) == 64 && running()) {
				useDoor(287, 571);
				wait(random(2000, 3000));
			}
			while(getDoorID(274, 563) == 2 && running()) {
				useDoor(274, 563);
				wait(random(1000, 2000));
			}
			while(!inArea(262, 3381, 277, 3400) && running()) {
				useObject(274, 566);
				wait(random(2000, 3000));
			}
			while(inventoryCount() != 30 && running()) {
				if(sleeping())
					wait(100);
				else {
					int[] rock = getObjectIndex(107);
					if(rock[0] != -1) {
						useObject(rock[1], rock[2]);
						wait(random(3000, 4000));
					}
					else {
						int[] rock1 = getObjectIndex(108);
						if(rock1[0] != -1) {
							useObject(rock1[1], rock1[2]);
							wait(random(3000, 4000));
						}
					}
					wait(100);
				}
			}
			while(!inArea(272, 563, 277, 567) && running()) {
				useObject(274, 3398);
				wait(random(2000, 3000));
			}
			while(getDoorID(274, 563) == 2 && running()) {
				useDoor(274, 563);
				wait(random(1000, 2000));
			}
		}
	}
}