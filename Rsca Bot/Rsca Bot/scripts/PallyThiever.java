import org.rscdaemon.client.mudclient;
import org.rscdaemon.client.script.*;

public class PallyThiever extends Commands {
	
	public PallyThiever(mudclient rs) { super(rs); }
		
	public void start(String[] args) {
		while (isRunning()) {
			while (getFatigue() >= 95 && isRunning() && !inCombat() && !isSleeping()) {
				useItem(1263);
				sleep(random(2000, 3000));
			}
			
			while (isSleeping() && isRunning())
				sleep(random(500, 1000));
					
			while (inCombat()) {
				walkTo(getX(), getY());
				sleep(random(500, 800));
			}
				
			int pally = getNpcIndexById(323);
			if (pally != -1) {
				thieveNpc(pally);
			}
			sleep(random(1000, 1300));
		}
	}
}