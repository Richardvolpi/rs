import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class Zammy extends Commands {
	public Zammy(mudclient game) { super(game); }
	
	public void start(String[] args) {
		while (isRunning()) {
			doSleep();
			if (!isPrayerOn(10)) {
				setPrayer(10, true);
				sleep(600, 1000);
			}
				
			if (!isPrayerOn(11)) {
				setPrayer(11, true);
				sleep(600, 1000);
			}
				
			if (!isPrayerOn(12)) {
				setPrayer(12, true);
				sleep(600, 1000);
			}
			while (getCurPrayer() <= 15 && !inCombat() && isRunning()) {
				int altar = getNearestObjectById(144);
				if (altar != -1) {
					atObject(getObjectX(altar), getObjectY(altar));
					sleep(random(1200, 1500));
				}
			}
			
			int monk = getNpcIndexById(140);
			if (monk != -1 && !inCombat()) {
				attackNpc(monk);
				sleep(random(600, 800));
			} else if (monk == -1) {
				walkToWait(331, 435);
			}
		}
	}
	
	public void doSleep() {
		while (getFatigue() >= 95 && !inCombat() && isRunning()) {
			useItem(1263);
			sleep(random(2000, 2500));
		}
	}
}