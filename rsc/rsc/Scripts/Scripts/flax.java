import org.rscdaemon.client.*;
 
public class flax extends Methods {
 
	public flax(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			while (ScriptRunning()) {
 
  int Rock[] = GetObjectById(313);
	      	            while(Rock[0] != -1 && !sleeping() && invCount(675) < 25)
	      	            {
	      	                AtObject2(Rock[1], Rock[2]);
	      	                Wait(200);
	      	            }
	    WalkToWait(489, 485);
	    WalkToWait(504, 468);
	    WalkToWait(502, 463);
	    while(!showQuestionMenu()) {
	        int Banker[] = GetNpcById(794);
	    	      	                            if(Banker[0] != -1)
	    	      	                            {
	    	      	                                TalkToNpc(Banker[0]);
	    	      	                                Wait(2500);
	    	      	                                }
	    	      	                                }
	                          Wait(4000);
	    	      	Answer(1);
	    	      	Wait(3000); 
	    	      	Answer(0);
	    	      	Wait(2000);
	    	      	Answer(4);
	    	      	Wait(1000);
	    	      	if(invCount(675) <= 25){
	    WalkToWait(504, 468);
	    	   WalkToWait(492, 485);
	    
	        }      
	    	                             
 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}