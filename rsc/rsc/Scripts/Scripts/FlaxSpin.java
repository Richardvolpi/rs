import org.rscdaemon.client.*;
 
public class FlaxSpin extends Methods {
 
	public FlaxSpin(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			while (ScriptRunning()) {
if(invCount(675) < 30){
	    	        	 Display("You Dont have enough Flax on You to Start - Must have 30");
	    	        	 Finish();
	    	        	 }
  int Wheel[] = GetObjectById(121);
            if(Wheel[0] != -1 && invCount(675) != 0)
            {
            while(invCount(675) != 0){
                UseOnObject(GetItemPos(675), Wheel[1], Wheel[2]);
                 if(GetFatigue() >= 90){
                AtObject(298, 579);
                               }
                Wait(333);
                }
            }
            WalkToWait(297, 577);
            WalkTo(297, 576);
            Wait(800);
             int Door1[] = GetObjectById(2);
            while(Door1[0] != -1 && GetY() != 576)
            {
		AtWallObject2(Door1[1], Door1[2]);
		Wait(300);
		WalkTo(297, 576);
		Wait(1000);
		}
		 WalkToWait(287, 572);
          		  WalkTo(286, 572);
          		  Wait(800);
          		   int Door2[] = GetObjectById(64);
         		   while(Door2[0] != -1 && GetX() != 286)
         		   {
	AtWallObject2(Door2[1], Door2[2]);
	Wait(300);
	WalkTo(286, 572);
	Wait(800);
	}
	WalkTo(284, 571);
	Wait(300);
	        	while(invCount(576) != 0 && !InBank()){
	        	int Banker[] = GetNpcById(95);
	        	TalkToNpc(Banker[0]);
	        	Wait(5000);
	        	}
	        	while(InBank() && CountInv(676) != 0){
			Deposit(676, 1); 
			Wait(300); 
			}
		while(InBank() && CountInv(675) != 30){
			Withdraw(675, 1); 
			Wait(300); 
			}
					CloseBank();
			Wait(600);
					WalkToWait(286, 572);
			WalkTo(287, 572);
			Wait(600);
			          		   int Door3[] = GetObjectById(64);
         		   while(Door3[0] != -1 && GetX() != 287)
         		   {
	AtWallObject2(Door3[1], Door3[2]);
	Wait(300);
	WalkTo(287, 572);
	Wait(800);
	}
	WalkToWait(297, 576);
	WalkTo(297, 577);
	Wait(800);
	             int Door4[] = GetObjectById(2);
            while(Door4[0] != -1 && GetY() != 577)
            {
		AtWallObject2(Door4[1], Door4[2]);
		Wait(300);
		WalkTo(297, 577);
		Wait(800);
		}

 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}