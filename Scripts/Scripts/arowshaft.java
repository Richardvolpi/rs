public class arowshaft extends Script
{

    public arowshaft(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "makeshafts"
        });
    }

    public void start(String s, String as[])
    {
        DisplayMessage("@dre@=@whi@=@dre@= @red@Arow Shaft Script Started - By @ran@Fert @dre@=@whi@=@dre@=", 3);
        while (Running())
        {

            while (InvCount() < 5)
            {
                if (Fatigue() > 95 && Sleeping() == false)
					{
				System.out.println(); 
                                      System.out.println("To Tired Sleeping...");
                                System.out.println();
				DisplayMessage("@Dre@SBoT: @whi@Sleeping", 3);
						Use(FindInv(1263));
						Wait(5000);
					}
                
                int ai[] = GetNearestObject(1);
                AtObject(ai[0], ai[1]);
            }
            
            if (InvCount() == 5)
            {
            UseWithInventory(FindInv(13), FindInv(14));
            Wait(1200);
            Answer(0);
            Wait(1000);
            }
             
        }

        DisplayMessage("@red@Shaft Maker STOPPED", 3);
    }
}