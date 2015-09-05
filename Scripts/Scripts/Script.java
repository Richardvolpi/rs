import org.rscdaemon.client.*;

public class Script extends Methods {
	
	public Script(mudclient mudclient) {
        super(mudclient);
    }
		
	public int fishCaught = 0;
	public int fishExp = 0;
	public int certed = 0;
	public String [] report = {" ", " ", " "};
		
		
	 public void MainBody(String Args[]) {

		 try {
			 		
		drawReport(report);		
		while (ScriptRunning()) {
			Wait(1000);
			fishCaught = fishCaught + 1;
			fishExp = fishExp + 43;
			certed = certed + 5;
			repaint();
			
		}
		Finish();
		} catch (Exception e) {
		System.out.println(e.getMessage());
		Display(e.getMessage());
		}
	}

		public void repaint() {

			report[0] = "Fish Caught: " + fishCaught;
			report[1] = "Exp Gained: " + fishExp;
			report[2] = "Certs Made: " + certed;
			updateReport(report);
}
	
}
