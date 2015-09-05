import org.rscdaemon.client.*;

public class Pallykiller extends Methods {
	
	public Pallykiller(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {

		Display("Pro Attacker, (TestScript) by xEnt");
		while (ScriptRunning()) {
if(sleeping()) { }
						
			int[] Npc = GetNpcById(323);
			if (Npc[0] != -1 && !InCombat())
             {
           	  AttackNpc(Npc[0]);  
           	  Wait(500);          
             }
			Wait(300);
		}
		Finish();
	}

}
