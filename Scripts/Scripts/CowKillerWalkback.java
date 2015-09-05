import org.rscdaemon.client.*;
 
public class CowKillerWalkback extends Methods {
 
	public CowKillerWalkback(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
		   Display("@cya@Cow Killing Fighter");
    Display("@cya@With Walk Back");
            int StartX = GetX();
        int StartY = GetY();
			while (ScriptRunning()) {
 
 int[] Npc = GetNpcById(6);
            if(Npc[0] != -1)
            {
                AttackNpc(Npc[0]);
                Wait(Rand(400,700));
            }
            if(GetFatigue() > 95 && ScriptRunning())
            {
                while(!sleeping() && ScriptRunning())
                {
                    UseItem(GetItemPos(1263));
                    Wait(Rand(1000,2000));
                }
                while(sleeping() && ScriptRunning())
                    Wait(1000);
            }
        
        if(GetX() == 120)
        {
            Wait(2000);
            WalkToWait(127, 643);
            WalkToWait(135, 636);
            WalkToWait(135, 622);
            WalkToWait(135, 612);
            WalkToWait(135, 601);
            WalkToWait(141, 595);
            WalkToWait(151, 595);
            WalkToWait(156, 590);
            WalkToWait(157, 582);
           
        }
    if(!InCombat() & ScriptRunning() & Npc[0] == -1 & (GetX() != StartX || GetY() != StartY || GetX() != 120))
        {
            WalkTo(StartX,StartY);
            Wait(500);   
        }
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}