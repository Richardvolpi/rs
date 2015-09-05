public class uncertsteelbar extends Methods
{
    public uncertsteelbar(mudclient mc){super(mc);}
    private long l;

    public void MainBody(String as[])
    {
	AutoLogin(true);
	  Display("@mag@Draynor Steel Bar Uncerter script -- @gre@Nattawat");
	  Display("@whi@Make sure you already have @red@20 @whi@certs in your bag and no bars!");
        while(Running())
        {
	 uncert();
	 Wait(200);
	 banking();
	 Wait(200);
        }
    }
    public void uncert()
	{
            while(!QuestMenu() && Running()) 
            {
                l = GetMillis();
                int i[] = GetNpcById(226);
                if(i[0] != -1)
                    TalkToNpc(i[0]);
                while(GetMillis() - l < 5000 && !QuestMenu() && Running()) 
                    Wait(100);
            }
            Answer(0);
            l = GetMillis();
            while(!QuestMenu() && Running() && GetMillis() - l < 10000)
                Wait(100);
            Answer(1);
            l = GetMillis();
            while(!QuestMenu() && Running() && GetMillis() - l < 10000)
                Wait(100);
            Answer(4);
            Wait(3000);
	}

    public void banking()
    {
	while(!QuestMenu() && Running())
	{
          int[] Npc = GetNpcById(95);
          if(Npc[0] != -1)
          TalkToNpc(Npc[0]);
          Wait(1000);
	}
	while(QuestMenu() && Running())
	{
	Answer(0);
	Wait(5000);
	}
	while (!InBank() && CountInv(171) > 0)
	  banking();
	while (InBank() && CountInv(171) > 0)
	{
            while (CountInv(529) < 20 && InBank())
            {
              Withdraw(529,5);
              Wait(Rand(1500,2000));
            }
	    while (CountInv(171) > 0 && InBank())
	    {
	      Deposit(171,1);
              Wait(Rand(200,500));
            }
            while (CountInv(171) > 0 && !InBank())
            {
              banking();
            }
            CloseBank();
         }
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Hey " + sender + " back soon, dinner :P");
            Wait(Rand(2000,5000));
            LogOut();
            End();
        }
    }

    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            LogOut();
            End();
        }
    }

    public void OnServerMessage(String message)
    {
    }
}