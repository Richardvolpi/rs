import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

//For level 54 skeles, picks up GP and runes.
public class Skeletons extends Commands {
	
	public int[] pickupIds = {10, 38, 40, 42};

	public Skeletons(mudclient game) { super(game); }
	
	public void start(String[] args) {
		while (isRunning()) {
			while (getFatigue() >= 95 && isRunning() && !inCombat()) {
				useItem(1263);
				sleep(random(1200, 1800));
			}
			
			int[] drops = getItemById(pickupIds);
			drops[1] = drops[1] + getAreaX();
			drops[2] = drops[2] + getAreaY();
			while (drops[0] != -1 && !inCombat() && isRunning() && drops[1] <= 413 && drops[2] >= 3474) {
				take(drops);
				sleep(random(600, 800));
			}
			
			int skele = getNpcIndexById(195);
			if (skele != -1 && !inCombat()) {
				attackNpc(skele);
				sleep(random(500, 800));
			}
				
		}
	}
}