import org.rscdaemon.client.*;
 
public class GoldSmelter extends Methods {
 
	public GoldSmelter(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
				   Display("Al Kharid Gold Bar Smelter");
			while (ScriptRunning()) {
 
        WalkToWait(85, 694);
        WalkToWait(83, 686);
        WalkToWait(83, 679);
        while(CountInv(152) > 0)
		{
			UseOnObject(GetItemPos(152), 85, 679);
			Wait(800);
		}


	WalkToWait(83, 679);
            WalkToWait(83, 686);
	WalkToWait(85, 694);        
	while(!InBank())
		{ 
		int[] Npc = GetNpcById(268);
		if(Npc[0] != -1)
		TalkToNpc(Npc[0]);
		Wait(2200);
		}
	while(InBank()&& CountInv(152) < 29)
		{
		while (CountInv(172) > 0)
			{ 
			Deposit(172, 1); 
			Wait(300); 
			}
		while (CountInv(152) < 29) 
			{
			Withdraw(152, 1); 
			Wait(300); 
			}
			}
 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}