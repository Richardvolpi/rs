public class bronzeminesmelt extends Methods
{
    public bronzeminesmelt(mudclient mc){super(mc);}
    private int Copper = 0;
    private int Tin = 0;
    private int Bronze = 0;
    private int amount = -1;
    
    public void MainBody(String Args[])
    {
        if((CountInv() != 2) || !InInv(1263) || (!InInv(156) && !InInv(1258) && !InInv(1259) && !InInv(1260) && !InInv(1261) && !InInv(1262)))
        {
            End("@whi@Make sure you have @red@ONLY 2 ITEMS@whi@!!! @red@SLEEPING BAG@whi@ and @red@PICKAXE@whi@ in your bag!");
        }
        amount = StrToInt(GetInput("How many bronze bars would you want to make?"));
        if(amount < 0) End("Invalid amount.");
        AutoLogin(true);
        Display("@ora@Copper + Tin Miner then Smelt for Bronze! --- @gre@Nattawat");
        while(Running())
        {
            if(GetY() < 580)
            {
                walktomine();
            }else
            if(GetY() > 630)
            {
                copper();
            }else
               End("You are not either at Falador South bank or Mining site, SCRIPT STOPPED");
        }
    }

    public void copper()
    {
        Display("@whi@Mining Copper Ores...");
        while (CountInv() < 30)
        {
            if(!SleepIfAt(95)) {End("No sleeping bag found, SCRIPTED STOPPED!");}
            int Rock[] = GetObjectById(100);
            if(Rock[0] != -1)
            {
                checkcopper();
                AtObject(Rock[1],Rock[2]);
                Wait(1000);
            }
        }
        walktobank();
    }

    public void checkcopper()
    {
        if(Copper >= amount)
        {
            Display("@whi@Copper ore reached @ora@" + amount + "@whi@. Now change to tin.");
            tin();
        }
    }

    public void tin()
    {
        Display("@whi@Mining Tin Ores...");
        while (CountInv() < 30)
        {
            if(!SleepIfAt(95)) {End("No sleeping bag found, SCRIPTED STOPPED!");}
            int Rock2[] = GetObjectById(104);
            if(Rock2[0] != -1)
            {
                checktin();
                AtObject(Rock2[1],Rock2[2]);
                Wait(1000);
            }
        }
        walktobank();
    }

    public void checktin()
    {
        if(Tin >= amount)
        {
            Display("@whi@Tin ore reached @ora@" + amount + "@whi@. Now change to smelting.");
            walktobank();
        }
    }

    public void walktobank()
    {
        Display("@whi@Going to bank...");
        WalkToWait(312,628);
        WalkToWait(311,619);
        WalkToWait(309,613);
        WalkToWait(307,605);
        WalkToWait(303,598);
        WalkToWait(298,589);
        WalkToWait(292,582);
        WalkToWait(290,573);
        WalkToWait(287,572);
        Wait(1000);
        checkbank();
    }

    public void checkbank()
    {
        if(Copper < amount && Tin < amount && Bronze < amount) {bankingcopper();}
        if(Copper >= amount && Tin < amount && Bronze < amount) {bankingtin();}
        if(Copper >= amount && Tin >= amount && Bronze < amount) {walktowest();}
        if(Copper >= amount && Tin >= amount && Bronze >= amount) {End("@ora@" + amount + "@whi@ Bronze bars reached.  Script Stopped!.");}
    }

    public void bankingcopper()
    {
        Display("@whi@Banking Copper Ores...");
        while(!QuestMenu() && Running())
        {
            int[] Npc = GetNpcById(95);
            if(Npc[0] != -1)
            TalkToNpc(Npc[0]);
            Wait(1500);
        }
        while(QuestMenu() && Running())
        {
            Answer(0);
            Wait(8000);
        }
        while (!InBank() && CountInv(150) > 0)
           bankingcopper();
        while (InBank() && CountInv(150) > 0)
        {
            while (CountInv(202) > 0 && InBank())
            {
                Deposit(202,1);
                Wait(Rand(200,500));
            }
            while (CountInv(169) > 0 && InBank())
            {
                Deposit(169,1);
                Wait(Rand(200,500));
            }
            while (CountInv(150) > 0 && InBank())
            {
                Deposit(150,1);
                Wait(Rand(200,500));
            }
            while (CountInv(157) > 0 && InBank())
            {
                Deposit(157,1);
                Wait(Rand(200,500));
            }
            while (CountInv(158) > 0 && InBank())
            {
                Deposit(158,1);
                Wait(Rand(200,500));
            }
            while (CountInv(159) > 0 && InBank())
            {
                Deposit(159,1);
                Wait(Rand(200,500));
            }
            while (CountInv(160) > 0 && InBank())
            {
                Deposit(160,1);
                Wait(Rand(200,500));
            }
            while (CountInv(150) > 0 && !InBank())
            {
                bankingcopper();
            }
            CloseBank();
        }
        checkafterbank();
    }

    public void bankingtin()
    {
        Display("@whi@Banking Tin Ores...");
        while(!QuestMenu() && Running())
        {
            int[] Npc = GetNpcById(95);
            if(Npc[0] != -1)
            TalkToNpc(Npc[0]);
            Wait(1500);
        }
        while(QuestMenu() && Running())
        {
            Answer(0);
            Wait(8000);
        }
        while (!InBank() && CountInv(202) > 0)
           bankingtin();
        while (InBank() && CountInv(202) > 0)
        {
            while (CountInv(150) > 0 && InBank())
            {
                Deposit(150,1);
                Wait(Rand(200,500));
            }
            while (CountInv(169) > 0 && InBank())
            {
                Deposit(169,1);
                Wait(Rand(200,500));
            }
            while (CountInv(202) > 0 && InBank())
            {
                Deposit(202,1);
                Wait(Rand(200,500));
            }
            while (CountInv(157) > 0 && InBank())
            {
                Deposit(157,1);
                Wait(Rand(200,500));
            }
            while (CountInv(158) > 0 && InBank())
            {
                Deposit(158,1);
                Wait(Rand(200,500));
            }
            while (CountInv(159) > 0 && InBank())
            {
                Deposit(159,1);
                Wait(Rand(200,500));
            }
            while (CountInv(160) > 0 && InBank())
            {
                Deposit(160,1);
                Wait(Rand(200,500));
            }
            while (CountInv(202) > 0 && !InBank())
            {
                bankingtin();
            }
            CloseBank();
        }
        checkafterbank();
    }

    public void bankingbronze()
    {
        Display("@whi@Banking...");
        while(!QuestMenu() && Running())
        {
            int[] Npc = GetNpcById(95);
            if(Npc[0] != -1)
            TalkToNpc(Npc[0]);
            Wait(1500);
        }
        while(QuestMenu() && Running())
        {
            Answer(0);
            Wait(8000);
        }
        while (!InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
           bankingbronze();
        while (InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
        {
            while (CountInv(202) < 14 && InBank())
            {
                Withdraw(202,1);
                Wait(Rand(600,800));
            }
            while (CountInv(169) > 0 && InBank())
            {
                Deposit(169,CountInv(169));
                Wait(Rand(600,800));
            }
            while (CountInv(150) < 14 && InBank())
            {
                Withdraw(150,1);
                Wait(Rand(600,800));
            }
            while (!InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
            {
                bankingbronze();
            }
            CloseBank();
        }
        walktosmelt();
    }

    public void walktowest()
    {
        Display("@whi@Walking to Falador West Bank for smelting...");
        WalkToWait(299,575);
        WalkToWait(315,578);
        WalkToWait(328,568);
        WalkToWait(326,553);
        getready();
    }

    public void getready()
    {
        Display("@whi@Getting ready for FIRST smelting trip...it will be slow, be patience...");
        while(!QuestMenu() && Running())
        {
            int[] Npc = GetNpcById(95);
            if(Npc[0] != -1)
            TalkToNpc(Npc[0]);
            Wait(1500);
        }
        while(QuestMenu() && Running())
        {
            Answer(0);
            Wait(8000);
        }
        while (!InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
           getready();
        while (InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
        {
            while (CountInv(202) < 14 && InBank())
            {
                Withdraw(202,1);
                Wait(Rand(1000,1500));
            }
            while (CountInv(202) > 14 && InBank())
            {
                Deposit(202,1);
                Wait(Rand(2000,2500));
            }
            while (CountInv(202) != 14 && InBank())
            {
                getready();
            }
            while (CountInv(150) < 14 && InBank())
            {
                Withdraw(150,1);
                Wait(Rand(1000,1500));
            }
            while (CountInv(150) > 14 && InBank())
            {
                Deposit(150,1);
                Wait(Rand(2000,2500));
            }
            while (CountInv(150) != 14 && InBank())
            {
                getready();
            }
            while (!InBank() && (CountInv(202) != 14 || CountInv(150) != 14))
            {
                getready();
            }
            CloseBank();
        }
        walktosmelt();
    }

    public void checkafterbank()
    {
        if(Copper < amount || Tin < amount) {walktomine();}
        if(Copper >= amount && Tin >= amount && Bronze < amount) {walktosmelt();}
        if(Copper >= amount && Tin >= amount && Bronze >= amount) {End("@ora@" + amount + "@whi@ Bronze bars reached.  Script Stopped!.");}
    }

    public void walktomine()
    {
        Display("@whi@Walking to mine again...");
        WalkToWait(287,572);
        WalkToWait(290,573);
        WalkToWait(292,582);
        WalkToWait(298,589);
        WalkToWait(303,598);
        WalkToWait(307,605);
        WalkToWait(309,613);
        WalkToWait(311,619);
        WalkToWait(312,628);
        WalkToWait(316,637);
        Wait(1000);
        checkmine();
    }

    public void checkmine()
    {
        if(Copper < amount) {copper();}
        if(Copper >= amount && Tin < amount) {tin();}
        if(Copper >= amount && Tin >= amount) {End("Uh oh...something fucked up...Script Stopped!");}
    }

    public void walktosmelt()
    {
        Display("@whi@Walking to smelt...");
        WalkToWait(326,552);
        WalkToWait(320,552);
        WalkToWait(314,545);
        smelting();
    }

    public void smelting()
    {
        Display("@whi@Smelting...");
        while(CountInv(150) > 1 && InInv(202))
        {
            checkbronze();
            if(!SleepIfAt(95)) {End("No sleeping bag found, SCRIPTED STOPPED!");}
            UseOnObject(GetItemPos(150),310,546);
            Wait(Rand(1000,1500));
        }
        walktobankbars();
    }

    public void checkbronze()
    {
        if(Bronze >= amount) {End("You had finally made @ora@" + amount + "@whi@ Bronze Bars.  Script Stopped!");}
    }

    public void walktobankbars()
    {
        Display("@whi@Walking to bank...");
        WalkToWait(314,545);
        WalkToWait(320,552);
        WalkToWait(326,552);
        bankingbronze();
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            Wait(Rand(4000,7000));
            Speak("Wow, you are really " + sender + "?!?");
            Wait(Rand(5000,6000));
            Speak("let me take a screenshot woopies!!");
            Wait(Rand(5000,6000));
            Speak("brb 1 sec, i gotta paste it in paint :)");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }
    
    public void OnPrivateMessage(String sender, String message)
    {
        if((sender.substring(0,4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")))
        {
            AddToFriends(sender);
            Wait(Rand(5000,8000));
            SendPM(sender, "Hey " + sender + " what do you need? :P");
            Wait(Rand(5000,6000));
            SendPM(sender, "hold on, my dad is coming, ill be dead if he caught me playing");
            Wait(Rand(5000,6000));
            LogOut();
            Die();
        }
    }
    
    public void OnServerMessage(String message)
    {
         if(IsInStr(message,"You manage to obtain some copper ore"))
            Copper = Copper + 1;
         if(IsInStr(message,"You manage to obtain some tin ore"))
            Tin = Tin + 1;
         if(IsInStr(message,"You retrieve a bar of bronze"))
            Bronze = Bronze + 1;
    }
}