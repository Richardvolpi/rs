import org.rscdaemon.client.*;
 
public class MonsterMasher extends Methods {
 
	public MonsterMasher(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			 int npcID = Integer.parseInt(Args[1]);
		        int itemID = Integer.parseInt(Args[2]);       	
	        	int itemsPickedup = 0;
	        	        	
	        	if (npcID == -1 || itemID == -1) {
	        		Display("Error, wrong arguments. use ::script 1 npcID itemID? itemID? etc (cause it takes items too)"	);
	        		Finish();
	        	}	        	
	        	Display("@gre@Monster Killer by xEnt! Picks up items too.");
	        		         
	        	while(ScriptRunning()) { 
	            
	        	  int[] Npc = GetNpcById(npcID); 
	        	  int[] Items = GetItemById(itemID);
	              SleepIfAt(99);        
	              if (sleeping())          
	              {                      
	        	      Wait(100);        
	        	          
	              }
	              
	              if(Items[0] != -1)                          
	               { 
	                 PickupItemById(itemID);
	                 Wait(200);
	               }
	              
	              if (Npc[0] != -1 && !InCombat()) 
	              {
	            	  AttackNpc(Npc[0]);  
	            	  Wait(300);          
	              } 
	                  Wait(200);                                   
	         }                         
	            Finish();                     
	                           					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}