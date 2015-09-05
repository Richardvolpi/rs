import org.rscdaemon.client.*;
 
public class ArrowMaker extends Methods {
 
	public ArrowMaker(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			while (ScriptRunning()) {
 
  int Arrow = Integer.parseInt(Args[1]);
        
	if(CountInv(637) > 9 && CountInv(Arrow) > 9)
	   {
  	    UseItemWithItem(GetItemPos(637), GetItemPos(Arrow));
	    Wait(1000);
           }
	if(CountInv(637) < 9)
	   {
	    Finish();
	   }
	if(CountInv(Arrow) < 9)
	   {
	    Finish();
	   }

 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}