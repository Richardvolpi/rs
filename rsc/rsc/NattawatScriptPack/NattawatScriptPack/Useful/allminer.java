public class allminer extends Methods
{
    public allminer(mudclient mc){super(mc);}
    public int RockID;

    public void MainBody(String Args[])
    {
        AutoLogin(true);
        Display("@ran@Allminer@gre@ -- Nattawat");
        int Start[] = new int[2];
        Start[0] = GetX();
        Start[1] = GetY();
        if(Args.length != 1)
           {
          Display("@whi@To run: type /start allminer(ore)");
    Wait(200);
      Display("@whi@Make sure it's all lowercase!!!");
    }
     else
     {
         if(Args[0].equalsIgnoreCase("copper"))
            RockID = 100;
         if(Args[0].equalsIgnoreCase("tin"))
            RockID = 104;
         if(Args[0].equalsIgnoreCase("iron"))
            RockID = 102;
         if(Args[0].equalsIgnoreCase("coal"))
            RockID = 110;
         if(Args[0].equalsIgnoreCase("gold"))
            RockID = 112;
         if(Args[0].equalsIgnoreCase("clay"))
            RockID = 114;
         if(Args[0].equalsIgnoreCase("silver"))
            RockID = 196;
         if(Args[0].equalsIgnoreCase("mithril"))
            RockID = 106;
         if(Args[0].equalsIgnoreCase("adamantite"))
            RockID = 108;
         if(Args[0].equalsIgnoreCase("rune"))
            RockID = 210;
    }
        while(Running())
       {
            if(GetFatigue() > 85 && Running())
            {
                while(!Sleeping() && Running())
                {
                    UseItem(GetItemPos(1263));
                    Wait(2000);
                }
                while(Sleeping() && Running())
                    Wait(1000);
            }
            int Rock[] = GetObjectById(RockID);
            if(Rock[0] != -1)
            {
                AtObject(Rock[1],Rock[2]);
                Wait(Rand(1200,1700));
            }
            else
                Wait(Rand(100,200));
            while(Running() && DistanceTo(Start[0],Start[1]) > 10)
            {
                 WalkToWait(Start[0],Start[1]);
                 Wait(1000);
            }
        }
        }
    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Hey everyone its " + sender + " ur all banned lol well cya i gtg!");
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