public class allarrows extends Methods
{
    public allarrows(mudclient mc){super(mc);}
 
    public void MainBody(String Args[])
    {
       AutoLogin(true);
	int head = 0;
        if(Args.length != 1)
        {
           Display("@red@Invalid parameter");
	   Display("@red@@To run: @whi@/start allarrows(type)");
	   Display("@red@Type: @whi@bronze / iron / steel / mith / adam / rune");
        }
        else
        {
         if(Args[0].equalsIgnoreCase("bronze"))
            head = 669;
         if(Args[0].equalsIgnoreCase("iron"))
            head = 670;
         if(Args[0].equalsIgnoreCase("steel"))
            head = 671;
         if(Args[0].equalsIgnoreCase("mith"))
            head = 672;
         if(Args[0].equalsIgnoreCase("adam"))
            head = 673;
         if(Args[0].equalsIgnoreCase("rune"))
            head = 674;
    }
       Display("@cya@Any Arrows Maker -- @gre@Nattawat");
       while(Running())
         {
	   if(GetFatigue() > 75 && Running())
            {
                while(!Sleeping() && Running())
                {
                    if(CountInv(1263) < 1)
                    {
            		Display("@red@OMG!!! No sleeping bag!!!!!");
            		Display("@red@Stopping script");
                        End();
                    }
                    UseItem(GetItemPos(1263));
                    Wait(2500);
                }
                while(Sleeping() && Running())
                    Wait(100);
	    }
	while(GetFatigue() < 80 && CountInv(637) > 9 && CountInv(head) > 9)
	   {
  	    UseItemWithItem(GetItemPos(637),GetItemPos(head));
	    Wait(1000);
           }
	while(CountInv(637) < 9)
	   {
	    End();
	   }
	while(CountInv(head) < 9)
	   {
	    End();
	   }
	}
    }
public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Hey " + sender + ", gotta go see ya later!");
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