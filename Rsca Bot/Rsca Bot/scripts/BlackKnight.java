import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class BlackKnight extends Commands {
        public final int walkX = 273;
        public final int walkY = 2333;
        public boolean att = true;
	public BlackKnight(mudclient rs) { super(rs); }
	
	public void start(String[] args) {
	
		while (isRunning()) {
			while(getFatigue() >= 90 && isRunning() && !isSleeping()) {
				useItem(1263);
				sleep(random(800, 1200));
    			}
    		
			while(isSleeping() && isRunning())
				sleep(random(500, 1000));
				
			if (!isPrayerOn(10) || !isPrayerOn(11) || !isPrayerOn(12)) {
				setPrayer(10, true);
				setPrayer(11, true);
				setPrayer(12, true);
			}
			
			while (getCurPrayer() <= 15 && !inCombat() && isRunning()) {
				int altar = getNearestObjectById(144);
				if (altar != -1) {
					atObject(getObjectX(altar), getObjectY(altar));
					sleep(2200, 2700);
				}
			}
			
			int knight = getNpcIndexById(66);
			if (knight != -1 && !inCombat()) {
				if (distanceTo(getNpcX(knight), getNpcY(knight)) > 0) {
					walkTo(getNpcX(knight), getNpcY(knight));
					sleep(1200, 1500);
				} else {
					attackNpc(knight);
					sleep(1500, 2000);
				}
			}
			sleep(500, 800);
		}
	}
}