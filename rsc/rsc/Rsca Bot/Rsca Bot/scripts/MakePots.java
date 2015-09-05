import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

//Makes pots...start in bank with 28 slots empty
public class MakePots extends Commands {
	
	public int herbId;
	public int secondId;
	public int vial = 464;
	public int unfinishId;
	public int finishId;
	public String[] pots = {"Prayer pot", "Super Attack Pot", "Super defense pot", "Super strength pot"};
	
	public MakePots(mudclient rs) { super(rs); }
	
	public void start(String[] args) {
		int potSelection = getSelection("Which type of pot do you wish to make?", pots);
		switch(potSelection) {
			case 0:
				herbId = 448;
				secondId = 469;
				unfinishId = 458;
				finishId = 483;
				break;
			case 1:
				herbId = 449;
				secondId = 270;
				unfinishId = 459;
				finishId = 486;
				break;
			case 2:
				herbId = 452;
				secondId = 471;
				unfinishId = 462;
				finishId = 495;
				break;
			case 3:
				herbId = 451;
				secondId = 220;
				unfinishId = 461;
				finishId = 492;
				break;
		}
		
		while (isRunning()) {
			while (getFatigue() >= 95 && isRunning()) {
				useItem(1263);
				sleep(random(1500, 2000));
			}
			
			while (countItem(herbId) > 0 && countItem(vial) > 0 && isRunning()) {
				useItemOnItem(herbId, vial);
				sleep(random(400, 800));
			}
			
			while (!inBank() && isRunning()) {
				System.out.println("NOT IN BANK SO TALKING TO BANKER");
				int banker = getNpcIndexById(95);
				talkToNpc(banker);
				sleep(random(3000, 5000));
			}
			
			while (inBank() && isRunning()) {
				System.out.println("IN BANK!");
			}
		}
	}
}