import org.rscdaemon.client.*;
 
public class Yanillebank extends Methods {
 
	public Yanillebank(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
		Display("@whi@Yanille iron miner+banker By Maiki");
		Display("@whi@Start this near iron rocks at yanile. Have sleeping bag");
			while (ScriptRunning()) {
 	int Rock[] = GetObjectById(102);
	        	        	
	        	              	SleepIfAt(85);
	        	              	if (sleeping()) {                      
	        				Wait(500);
	        			}
	        	              		
	        	            	if(invCount(151) > 24) {
	    	        				WalkToWait(569,731);
	    	        				WalkToWait(581,743);
	    	        				WalkToWait(588,753);
	    	        				Wait(1000);
	    	        				int Banker[] = GetNpcById(95);
	    	        					TalkToNpc(Banker[0]);
	    	        					Wait(6000);
	    	        				DepositItems(151, 25);

	    	        				Wait(3000);
	    	        				WalkToWait(571,738);
	    	        				WalkToWait(565,722);
	    	        				WalkToWait(560,713);
	    	        			}
	        	            	
	        			if(Rock[0] != -1 && !sleeping()) {
	                        		
	                            		AtObject(Rock[1], Rock[2]);
	                            		Wait(1500);
	                        	}	        	
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}