import org.rscdaemon.client.*;
 
public class IronMiner extends Methods {
 
	public IronMiner(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
		 Display("Al Kharid Iron miner + Smelter + Banker[Gems too]");
			while (ScriptRunning()) {
 WalkToWait(86, 696);
        WalkToWait(83, 686);
        WalkToWait(80, 675);
        WalkToWait(80, 661);
        WalkToWait(77, 651);
        WalkToWait(70, 639);
        WalkToWait(72, 627);
        WalkToWait(69, 617);
        WalkToWait(69, 605);
        WalkToWait(71, 592);
        WalkToWait(73, 585);
        while(CountInv(102) < 24)
		{
		int[] Rock = GetObjectById(102);
		if(Rock[0] != -1)
			{
			AtObject(Rock[1], Rock[2]);
			Wait(1200);
			}
		}
	WalkToWait(73, 600);
	WalkToWait(73, 615);
	WalkToWait(73, 630);
	WalkToWait(76, 645);
	WalkToWait(80, 660);
	WalkToWait(80, 675);
	WalkToWait(83, 679);
	while(CountInv(151) > 0)
               {
                    UseOnObject(GetItemPos(151), 85, 679);
                    Wait(2000);
               }
        WalkToWait(81, 679);
        WalkToWait(84, 694);
        WalkToWait(89, 695);
        while(!InBank())
		{ 
		int[] Npc = GetNpcById(268);
		if(Npc[0] != -1)
		TalkToNpc(Npc[0]);
		Wait(2200);
		}
	while(InBank())
		{
		while (CountInv(170) > 0)
			{ 
			Deposit(170, 1); 
			Wait(300); 
			}
		while (CountInv(157) > 0) 
			{ 
			Deposit(157, 1); 
			Wait(300); 
			}
		while (CountInv(158) > 0) 
			{ 
			Deposit(158, 1); 
			Wait(300); 
			}
		while (CountInv(159) > 0) 
			{ 
			Deposit(159, 1); 
			Wait(300); 
			}
		while (CountInv(160) > 0) 
			{ 
			Deposit(160, 1); 
			Wait(300); 
			}
		}
	CloseBank();
	Wait(1000);

 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}