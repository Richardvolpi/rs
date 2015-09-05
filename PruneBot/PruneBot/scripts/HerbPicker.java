import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class HerbPicker extends Commands {
	public HerbPicker(mudclient rs) { super(rs); }
	
	public int[] walkX = {582,589,589,594,598,609,611,610,618};
	public int[] walkY = {570,583,597,603,599,594,582,571,559};
	public int[] pickup = {619, 38, 439, 441, 442, 443, 438, 220};
	public void start(String[] args) {
		while (isRunning()) {
			
			if (getX() < 600) {
				walkToWait(582,570);
				walkToWait(589,583);
				walkToWait(589,597);
				walkToWait(594,603);
				walkToWait(598,599);
				walkToWait(609,594);
				walkToWait(611,582);
				walkToWait(610,571);
				walkToWait(618,559);
			}
			
			while (getInvCount() < 30 && isRunning()) {
				int[] gItem = getItemById(pickup);
				int itemX = gItem[1] + getAreaX();
				int itemY = gItem[2] + getAreaY();
				
				if (gItem[0] != -1 && !inCombat()) {
					take(itemX, itemY, gItem[0]);
					sleep(random(1200, 1500));
				}
				
				while(getFatigue() >= 95 && isRunning()) {
					useItem(1263);
					sleep(random(2000,2500));
				}
				
				int druid = getNpcIndexById(270);
				if (druid != -1 && gItem[0] == -1 && !inCombat()) {
					if (distanceTo(getNpcX(druid), getNpcY(druid)) > 0)
						walkTo(getNpcX(druid), getNpcY(druid));
					else
						attackNpc(druid);
						
					sleep(random(800, 1300));
				}
			}
			
			walkToWait(618,559);
			walkToWait(610,571);
			walkToWait(611,582);
			walkToWait(609,594);
			walkToWait(598,599);
			walkToWait(594,603);
			walkToWait(589,597);
			walkToWait(589,583);
			walkToWait(582,570);
			
			while (!inBank() && isRunning()) {
				int banker = getNpcIndexById(95);
				if (banker != -1) {
					talkToNpc(banker);
					sleep(random(5000, 6000));
				}
			}
			
			while (inBank() && isRunning()) {
				for (int i = 0; i < pickup.length; i++) {
					while (countItem(pickup[i]) > 0 && isRunning()) {
						deposit(pickup[i], countItem(pickup[i]));
						sleep(random(500, 800));
					}
				}
				closeBank();
			}
			
		}
	}
}