import bot.*;
public class Agi1 extends Methods {
	public Agi1(Client mc){super(mc);this.mc=mc;}
	public void main(String args[]) {
		printMessage("@or2@Agility trainer: @yel@started");
		if(args.length > 1)
			if(args[1].equals("1"))
				debug = true;
		int stuckCounter = 0;
		while(running()) {
			while(!lastServerMessage.contains("you stand on the slippery log")) {//logs
				useObject(692, 495, true);
				wait(random(500, 1500));
			}
label0:
			while(!lastServerMessage.contains("and walk across")) {
				debug("waiting to get past log");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label0;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you climb the net")) {//net1
				useObject(692, 503, true);
				wait(random(500, 1500));
			}
label1:
			while(!lastServerMessage.contains("pull")) {
				debug("waiting to get past 1st nets");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label1;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you pull yourself up the tree")) {//watchtower1
				useObject(693, 1452, true);
				wait(random(500, 1500));
			}
label2:
			while(!lastServerMessage.contains("to the platform")) {
				debug("waiting to get past 1st watchtower");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label2;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you reach out and grab the rope swing")) {//ropeswing
				useObject(689, 2395, true);
				wait(random(500, 1500));
			}
label3:
			while(!lastServerMessage.contains("and swing to")) {
				debug("waiting to get past ropeswing");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label3;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you hang down from the tower")) {//watchtower2
				useObject(683, 2396, true);
				wait(random(500, 1500));
			}
label4:
			while(!lastServerMessage.contains("and drop")) {
				debug("waiting to get past 2nd watchtower");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label4;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you take a few steps back")) {//net2
				useObject(683, 502, true);
				wait(random(500, 1500));
			}
label5:
			while(!lastServerMessage.contains("and run")) {
				debug("waiting to get past 2nd nets");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label5;
				}
				stuckCounter ++;
				wait(1500);
			}
			
			while(!lastServerMessage.contains("you squeeze into the pipe")) {//pipe
				useObject(683, 497, true);
				wait(random(500, 1500));
			}
label6:
			while(!lastServerMessage.contains("down into")) {
				debug("waiting to get past pipe");
				if(stuckCounter > 6) {
					stuckCounter = 0;
					debug("got stuck, breaking loop");
					break label6;
				}
				stuckCounter ++;
				wait(1500);
			}
			
		}
	}
	
	public void debug(String s){
		if(debug)
			System.out.println("Agility trainer: " + s);
	}
	
	public boolean onServerMessage(String s) {
		s = s.toLowerCase();
		lastServerMessage = s;
		return false;
	}
	
	public void onStop() {
		printMessage("@or2@Agility trainer: @yel@stopped");
	}
	
	public String lastServerMessage = "";
	public boolean debug = false;
}