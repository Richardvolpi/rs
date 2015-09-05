public class thieve extends Script
{

    public thieve(mudclient mudclient)
    {
        super(mudclient);
    }

    public String[] getCommands()
    {
        return (new String[] {
            "thieve"
        });
    }

    public void start(String s, String as[])
    {
        int i = Integer.parseInt(as[0]);
		int i2 = Integer.parseInt(as[1]);
		boolean switchcake = false;

        if(i!=i2)
        DisplayMessage("@cya@Thieving NPC ID's " + i + " and " + i2 + " now.", 3);
        else
		DisplayMessage("@cya@Thieveing NPC ID " + i + " now.", 3);

        for(; Running(); Wait(100))
        {
			if(GetNearestNPC(i) <= 0)
			ThieveNPC(GetNearestNPC(i2));

			while(InCombat())
			{
				if(GetFightMode()!=1)
				SetFightMode(1);
				Wait(200);
				WalkNoWait(GetX(),GetY());
			}

			while((Fatigue() >= 97)&&(Sleeping()!=true))
			{
				Use(FindInv(1263));
				Wait(200);
				switchcake = true;
				Wait(20000);
			}

			if(switchcake)
			{
				Wait(1000);
				if(FindInv(330)>=0)
				Use(FindInv(330));
				else if(FindInv(333)>=0)
				Use(FindInv(333));
				else if(FindInv(335)>=0)
				Use(FindInv(335));
				switchcake = false;
			}
        }

        DisplayMessage("@gre@STOPPED", 3);
    }
}