import org.rscdaemon.client.*;
 
public class ProFisher extends Methods {
 
	public ProFisher(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			 int fishID = -1;
          	 int objID = -1;
          	 int stage = 0;
          	 int npcID = -1;
          	 int [] CertOptions = {-1, -1, -1};
          	 boolean cert = false;
          	
          	 if (Args[1].equalsIgnoreCase("shark")) {
          		 fishID = 545;
          		 objID = 261;
          		 npcID = 370;
          		 CertOptions[0] = 1;
          		 CertOptions[1] = 1;
          		 CertOptions[2] = 4;
          	 } else if (Args[1].equalsIgnoreCase("lobster")) {
          		 fishID = 372;
          		 objID = 194;
          		 npcID = 369;
          		 CertOptions[0] = 1;
          		 CertOptions[1] = 1;
          		 CertOptions[2] = 4;
          	 } else {
          		 Display("Sorry, arguments must be lobster or shark");
          		 Finish();
          	 }
          	 
          	 if (Args[2].equalsIgnoreCase("true") || Args[2].equalsIgnoreCase("yes"))
          		 cert = true;
          	  else if (Args[2].equalsIgnoreCase("false") || Args[2].equalsIgnoreCase("no"))
          		 cert = false;
          	  else {
          		 Display("Sorry, last arguments must be true/yes or false/no. if you want to cert");
          		 Finish();
          	 }
          	 int temp = 125;
          	 //drawText("@whi@Caught: @cya@" + temp + "@whi@ Fish.    Certs Gained: @cya@" + temp / 5);
          	 Display("@gre@Running Universal Guild Fisher. Catching: @whi@" + Args[1] + " @gre@Certing: @whi@" + (cert ? "Yes" : "No"));
          	 
          		    	 
          	 while (ScriptRunning()) {
          		 SleepIfAt(99);
          		 if (sleeping()) {
          			 
          		 } 
          		 else if (stage == 0) { // Walk to fish spot.
          			 WalkToWait(595, 502);
          			 stage = stage + 1;
          		 } else if (stage == 1) { // Catch fish.
          			 if (invCount(fishID) >= 25 && cert) { 				
          				   stage = stage + 1;				 
          			 } else {
          			 int FishObj[] = GetObjectById(objID);
          			 if(FishObj[0] != -1)
          	            {
          	                AtObject2(FishObj[1], FishObj[2]);
          	            }
          			 }   			 
          		 } else if (stage == 2) { // Full of fish
          			WalkToWait(603, 506); 
          			stage = stage + 1;
          		 } else if (stage == 3) { // talk to certer
          			 int Certer[] = GetNpcById(npcID);
          		        if(Certer[0] != -1)
                          {
                              TalkToNpc(Certer[0]);
                              Wait(6500);
                              Answer(CertOptions[0]);
                              Wait(4700);
                              Answer(CertOptions[1]);
                              Wait(2000);
                              Answer(4);
                              Wait(1000);
                              stage = 0; // Walks back to where stage 1 is.
                          } 
          		 }
          		 Wait(550);
          	 }
          	 Finish();          
	                           					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}