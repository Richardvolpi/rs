import org.rscdaemon.client.*;
 
public class CatchSharkCatherby extends Methods {
 
	public CatchSharkCatherby(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			        	Display("@whi@Catherby Shark Fish + Bank");
	        	Display("@whi@Fuck you and have sleeping bag");
			while (ScriptRunning()) {
   	int Fish[] = GetObjectById(261);

	        	if(invCount(545) > 24)
	        	{
	        	WalkToWait(408, 500);
	        	WalkToWait(418, 496);
	        	WalkToWait(430, 497);
	        	WalkToWait(439, 498);
	        	WalkToWait(440, 494);
	        	Wait(1000);
	        	while(invCount(545) > 24){
	        	int Banker[] = GetNpcById(95);
	        	TalkToNpc(Banker[0]);
	        	Wait(6000);
	        	DepositItems(545, 25);
	        	Wait(3000);
	        	}
	        	WalkToWait(440, 494);
	        	WalkToWait(439, 498);
	        	WalkToWait(430, 497);
	        	WalkToWait(418, 496);
	        	WalkToWait(408, 500);
	        	}
	        	if(Fish[0] != -1 && !sleeping())
	        	{
	        	AtObject2(Fish[1], Fish[2]);
	        	Wait(1500);
	        	}

 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}