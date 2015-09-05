import org.rscdaemon.client.*;
 
public class example extends Methods {
 
	public example(mudclient mudclient) {
        super(mudclient);
    }
	 public void MainBody(String Args[]) {
		try {
			while (ScriptRunning()) {
 
				Display("Hey");
				Wait(1000);
 
 
			}					
		} catch (Exception e) {
			Display("@red@Error: @whi@" + e.getMessage());
			Finish();
		}
	}
 
}