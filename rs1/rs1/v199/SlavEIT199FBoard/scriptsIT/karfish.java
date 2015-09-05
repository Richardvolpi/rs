import java.awt.*;
public class karfish extends Macro {
    public boolean didDragon = false;
    public karfish(slave rs) {
        super(rs);
        
    }
    public String[] getCommands() {
        return new String[]{"karfish"};
    }
    public String[] getComments() {
        return new String[]{"Usage: /karfish   Start at docks"};
    }
    public void kill() 
    {
	    while(loggedin()) {
	    rs.autologin = false;
		LogOut();
		wait(3000);
	    }
    }
    public void sleep()
    {
	wait(2000);
	if(FindInv(1263) != -1)
	    UseItem(FindInv(1263));
	else {
	    rs.Macro = false;
	    System.err.println("no sleeping bag!");
	    kill();
	}
	wait(2000);
	int time = 28;
	time = time * 1000;
	int curtime = 0;
	while(Sleeping()) {
	    wait(10);
	    curtime += 10;
	    if(!Sleeping())
		break;
	    if(curtime >= time)
		break;
	}
    }
    public void start(String command, String arg[]) 
    {
	Frame frame = new Frame("Karamja Fisher");
        Label labl = new Label("test");
        frame.add(labl);
        //frame.setSize(200,100);
        //frame.setVisible(true);
        if(arg.length != 1)
        {
        debugG("Usage: /karfish true/false");
        debugG("true if dragonslayer done/ false if not");
        rs.Macro = false;
        }
        else
        {
        	if(arg[0].equalsIgnoreCase("true"))
        	didDragon = true;
        	else
        	didDragon = false;
        }
	    final MessageListener l = new MessageListener()
	    {
		public void messageRecieved(String msg,int filter)
		{
		    System.err.println(msg);
		}
	    };
            rs.addMessageListener(l);
        while(rs.Macro)
        {
             wait(50);
             
             if(CoordsIn(369, 691, 372, 679)) //at docks
             {
             System.err.println(getFatigue());
             	if(getFatigue() < 80 && InvCount() != 30)
             	{
			ObjCmd2(368,684);
			wait(300 + random(100,120));
             	}
             	else if(getFatigue() >= 80)
             	{
             		sleep();
             	}
             	else if(InvCount() == 30)
             	{
            		WalkToWait(337,712);
			WalkToWait(329,713);
			port:
			while(!CoordsIn(270,645,268,654))
			{
				while(!isQuestMenu()) {
					if(CoordsIn(270,645,268,654))
						break port;
					ObjCmd1(326,710);
					wait(2400);
				}
				wait(1000);
				if(isQuestMenu()) {
					Answer(1);
					WaitForQuestMenu(6000);
					Answer(0);
					wait(3000 + random(120,190));
				}
                        }
                        
                        
                        WalkToWait(268,639);
                        WalkToWait(260,631);
                        WalkToWait(251,614);
                        WalkToWait(245,610);
                        WalkToWait(238,615);
                        WalkToWait(230,625);
                        while(InvCount() == 30)
                        {
                        	while(!isQuestMenu()) {
					TalkNearest(227);
					wait(2400);
				}
				wait(1000);
				if(isQuestMenu()) {
					Answer(1);
					WaitForQuestMenu(3000);
					Answer(1);
					WaitForQuestMenu(3000);
					Answer(4);
					wait(3000 + random(120,190));
				}
                        }
                        WalkToWait(234,622);
                        WalkToWait(239,617);
                        WalkToWait(246,610);
                        WalkToWait(258,624);
                        WalkToWait(268,636);
                        WalkToWait(268,643);
                        WalkToWait(268,648);
                        kar:
                        while(CoordsIn(270,645,268,654))
			{
				while(!isQuestMenu()) {
					if(!CoordsIn(270,645,268,654))
						break kar;
					ObjCmd1(265,645);
					wait(3400);
				}
				wait(1000);
				if(isQuestMenu()) {
					if(didDragon)
					Answer(0);
					else
					Answer(1);
					wait(3000 + random(120,190));
				}
                        }
                        
                        WalkToWait(333,713);
                        WalkToWait(345,709);
                        WalkToWait(354,702);
                        WalkToWait(368,696);
                        WalkToWait(370,686);
             	}
             }
             //else if
        }
    }
}

