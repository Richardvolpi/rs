import org.rscdaemon.client.*;
 
public class ProPickpocket extends Methods {
 
	public ProPickpocket(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			while (ScriptRunning()) {
 
				int FoodID = Integer.parseInt(Args[2]);
	        	int NpcID = Integer.parseInt(Args[1]);
	        	if (NpcID == -1 || FoodID == -1) {
	        		Display("Error, wrong arguments. use ::script 8 npcID foodID (eats on low health)");
	        		Finish();
	        	}
 
	        	while(ScriptRunning()) {
 
	        		int[] Npc = GetNpcById(NpcID);
	        		if(sleeping()) {
 
	        		} else if (InCombat()) {
	        			WalkTo(GetX(), GetY());
	        		} else if (playerStatCurrent(3) <= getMaxLvl(3) / 2) {
	        			if(invCount(FoodID) == 0) {
	        				Display("No food left, Stopping.");	        				
	        				Finish();
	        			}
	        			for(int i=0; i < invCount(FoodID); i++) {
	        				use(FoodID);
	        				Wait(800);
	        				if(playerStatCurrent(3) > getMaxLvl(3) / 2) {
	        					break;
	        				}
	        			}
	        		} else if (Npc[0] != -1 && !InCombat()) {
	        			 ThieveNpc(Npc[0]);        			
	        		}	        		
	        		Wait(500);
	        	} 
 
	        	Finish();
 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}