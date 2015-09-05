public class HerberYanille extends Script
{

    public HerberYanille(mudclient mudclient)
    {
        super(mudclient);
        T = "Bruncle";
        maxX = 591;
        minX = 576;
        maxY = 3589;
        minY = 3582;
    }

    public String[] getCommands()
    {
        return (new String[] {
            "herb"
        });
    }

    public void start(String s, String as[])
    {
        if(as.length != 2)
        {
            DisplayMessage("@gre@Bruncle: @whi@Invalid number of parameters. /RUN herbmeupyanille [STYLE]", 3);
        } else
        {
            int i = Integer.parseInt(as[0]);
            int j = Integer.parseInt(as[1]);
            int k = 750;
            char c = '\u010E';
            CheckFighters(true);
            DisplayMessage("@gre@Bruncle: @whi@AutoFighter - RichyT", 3);
            do
            {
                if(!Running() || GetCurrentStat(3) <= 5)
                    break;
                if(GetFightMode() != i)
                {
                    SetFightMode(i);
                    DisplayMessage("@gre@SBoT: @whi@FightMode Changed To " + GetFightMode(), 3);
                }
                if(!InCombat())
                {
                    if(pT())
                        TalkBack(LastChatMessage());
                    if(j == 1 && Fatigue() > 97 && !Sleeping())
                    {
                        DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                        for(; !Sleeping(); Wait(5000))
                            Use(FindInv(1263));

                        for(; Sleeping(); Wait(2000));
                    }
                    if(!Sleeping())
                    {
                        int l = 0;
                        do
                        {
                            if(l >= herbs.length || !Running() || InvCount() >= 30)
                                break;
                            for(int i1 = herbs[l]; validCoOrd(GetNearestItem(i1)); Wait(500))
                                TakeItem(GetNearestItem(i1)[0], GetNearestItem(i1)[1], i1);

                            l++;
                            if(pT())
                                TalkBack(LastChatMessage());
                        } while(true);
                        if(pT())
                            TalkBack(LastChatMessage());
                        int j1 = GetNearestNPC(c);
                        if(j1 != -1)
                        {
                            if(pT())
                                TalkBack(LastChatMessage());
                            long l1 = System.currentTimeMillis();
                            SetFightMode(i);
                            AttackNPC(j1);
                            for(; System.currentTimeMillis() - l1 <= (long)k && !InCombat() && Running(); Wait(1));
                        }
                        if(InvCount() == 30)
                            WalkAndBank();
                        if(pT())
                            TalkBack(LastChatMessage());
                    }
                } else
                {
                    while(InCombat() && Running()) 
                        Wait(1);
                }
            } while(true);
            DisplayMessage("@gre@Bruncle: @whi@Herb Picker - @red@STOPPED", 3);
        }
    }

    public boolean validCoOrd(int ai[])
    {
        return ai[0] < maxX && ai[0] > minX && ai[1] < maxY && ai[1] > minY;
    }

    public boolean pT()
    {
        return LastChatMessage() != null;
    }

    public void WalkAndBank()
    {
        if(Running())
        {
            DisplayMessage("Banking", 3);
            Wait(2000);
            Walk(593, 3589);
            Wait(3000);
            for(; !CanReach(593, 3592) && Running(); Wait(1000))
                CloseDoor(593, 3590, 0);

            Wait(1000);
            for(; GetY() > 3000 && Running(); Wait(1000))
                AtObject(591, 3593);

            Wait(2000);
            Walk(586, 752);
            Wait(5000);
            while(!QuestMenu()) 
            {
                long l = System.currentTimeMillis();
                int j = GetNearestNPC(95);
                TalkToNPC(j);
                while(System.currentTimeMillis() - l <= 2000L && !QuestMenu()) 
                    Wait(1);
            }
            Wait(3000);
            Answer(0);
            for(; !Bank(); Wait(100));
            for(; Bank(); CloseBank())
            {
                for(int i = 0; i < herbs.length && Running(); i++)
                    for(; InvCount(herbs[i]) > 0; Wait(200))
                        Deposit(herbs[i], 1);


            }

            if(Running())
            {
                Wait(1500);
                Walk(590, 762);
                Wait(2000);
                for(; GetY() < 3000; Wait(2000))
                    AtObject(591, 761);

                Walk(593, 3590);
                Wait(2000);
            }
            for(; !CanReach(593, 3589) && Running(); Wait(1000))
                CloseDoor(593, 3590, 0);

            Wait(2000);
            ForceWalk(585, 3586);
            DisplayMessage("Killing druids..", 3);
        }
    }

    public void TalkBack(String s)
    {
        if(Running())
        {
            if(T.indexOf("Hi") >= 0)
            {
                Say("Hey");
                ResetLastChatMessage();
            }
            if(T.indexOf("sup") >= 0)
            {
                Say("nm");
                ResetLastChatMessage();
            }
            if(T.indexOf("autoing") >= 0)
            {
                Say("nah..fast connection");
                ResetLastChatMessage();
            }
            if(T.indexOf("sex") >= 0)
            {
                Say("I'd love some");
                ResetLastChatMessage();
            }
            if(T.indexOf("autoer") >= 0)
            {
                Say("fuck off i own you");
                ResetLastChatMessage();
            }
            if(T.indexOf("fuck you") >= 0)
            {
                Say("don't mind if i do..");
                ResetLastChatMessage();
            }
            if(T.indexOf("yo") >= 0)
            {
                Say("omg fre stfuf plz i is big nooby help me plzz");
                ResetLastChatMessage();
            }
            if(T.indexOf("cool") >= 0)
            {
                Say("awesome");
                ResetLastChatMessage();
            }
            if(T.indexOf("leave") >= 0)
            {
                Say("leaves are cool");
                ResetLastChatMessage();
            }
            if(T.indexOf("omg") >= 0)
            {
                Say("omfg wdf??");
                ResetLastChatMessage();
            }
            if(T.indexOf("dam") >= 0)
            {
                Say("your house burnt down? Too bad for you");
                ResetLastChatMessage();
            }
            if(T.indexOf("I'm a hot girl") >= 0)
            {
                Say("no you're not...");
                ResetLastChatMessage();
            }
            if(T.indexOf("lmao") >= 0)
            {
                Say("hohohoho");
                ResetLastChatMessage();
            }
            if(T.indexOf("lol autoer") >= 0)
            {
                Say("lol noob");
                ResetLastChatMessage();
            }
            if(T.indexOf("you do?") >= 0)
            {
                Say("i love beef");
                ResetLastChatMessage();
            }
            if(T.indexOf("lol!") >= 0)
            {
                Say("hohohoho");
                ResetLastChatMessage();
            }
            if(T.indexOf("lol") >= 0)
            {
                Say("haha..not funny..");
                ResetLastChatMessage();
            }
            if(T.indexOf("hello") >= 0)
            {
                Say("hi2u");
                ResetLastChatMessage();
            }
            if(T.indexOf("i use bots") >= 0)
            {
                Say("no i don't");
                ResetLastChatMessage();
            }
            if(T.indexOf("report him") >= 0)
            {
                Say("w00t ur a newb");
                ResetLastChatMessage();
            }
            if(T.indexOf("Autoing socks") >= 0)
            {
                Say("Yes, you make those socks");
                ResetLastChatMessage();
            }
            if(T.indexOf("noob") >= 0)
            {
                Say("It's allright, we all go through that phase..");
                ResetLastChatMessage();
            }
            if(T.indexOf("whats up autoer") >= 0)
            {
                Say("the roof");
                ResetLastChatMessage();
            }
            if(T.indexOf("plz") >= 0)
            {
                Say(":o you know the magic word");
                ResetLastChatMessage();
            }
            if(T.indexOf("??") >= 0)
            {
                Say("wah?");
                ResetLastChatMessage();
            }
            if(T.indexOf("Lol") >= 0)
            {
                Say("how amusing");
                ResetLastChatMessage();
            }
            if(T.indexOf("shutup") >= 0)
            {
                Say("how about no");
                ResetLastChatMessage();
            }
            if(T.indexOf("sdfu") >= 0)
            {
                Say("fhk off");
                ResetLastChatMessage();
            }
            if(T.indexOf("report you for autoing") >= 0)
            {
                Say("w00t ur a newb");
                ResetLastChatMessage();
            }
            if(T.indexOf("no") >= 0)
            {
                Say("yes");
                ResetLastChatMessage();
            }
            if(T.indexOf("rofl") >= 0)
            {
                Say("sdfu");
                ResetLastChatMessage();
            }
            ResetLastChatMessage();
        }
    }

    public String T;
    int herbs[] = {
        438, 439, 441, 442, 42, 33, 40, 1277, 526, 527
    };
    int maxX;
    int minX;
    int maxY;
    int minY;
}