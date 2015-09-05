public class edgeherb extends Methods
{
    public edgeherb(mudclient mc){super(mc);}
    int herb[] = {435,436,437,438,439,440,441,442,443,815,817,819,821,823,933};
    
    public void MainBody(String Args[])
    {
    AutoLogin(true);
        int FightMode = StrToInt(Args[0]);
        Display("@dre@Edge Village Herb Collector -- @gre@Nattawat");
        LockMode(FightMode);
        while(Running())
        {
      collect();
      Wait(500);
      walktobank();
      Wait(500);
      banking();
      Wait(500);
      walktocollect();
      Wait(500);
        }
    }

    public void collect()
    {
    Display("@whi@Collecting Herbs...");
    while(CountInv() < 30 && Running())
      {
         int[] herbs = GetItemById(herb);
         if(herbs[1] != -1)
         {
            PickupItem(herbs[1],herbs[2],herbs[0]);
            Wait(700);
         }
       else
         if(!InCombat() && Running())
         {
            if(GetFatigue() > 95 && Running())
            {
               while(!Sleeping() && Running())
               {
                  UseItem(GetItemPos(1263));
                  Wait(Rand(1000,2000));
               }
               while(Sleeping() && Running())
               Wait(1000);
            }
        int [] Npc = GetNpcById(11);
            if(Npc[0] != -1 && !InCombat() && !Sleeping() && Running())
            {
               AttackNpc(Npc[0]);
               Wait(Rand(700,900));
            }
         }
         else
         Wait(Rand(10,20));
       }
    }

    public void walktobank()
    {
        while(GetX() != 208 && GetY() != 443) WalkToWait (208,443);
        while(GetX() != 212 && GetY() != 446) WalkToWait (212,446);
        while(GetX() != 217 && GetY() != 449) WalkToWait (217,449);
    }

    public void banking()
    {
    Display("@whi@Banking...");
    while(!QuestMenu() && Running())
    {
          int[] Banker = GetNpcById(95);
          if(Banker[0] != -1)
          TalkToNpc(Banker[0]);
          Wait(1500);
    }
    while(QuestMenu() && Running())
    {
    Answer(0);
    Wait(8000);
    }
    while (!InBank() && CountInv(herb[0]) > 0)
       banking();
    while (InBank() && CountInv(herb[0]) > 0)
    {
       while (CountInv(435) > 0 && InBank())
       {
        Deposit(435,1);
        Wait(Rand(200,500));
       }
       while (CountInv(436) > 0 && InBank())
       {
        Deposit(436,1);
        Wait(Rand(200,500));
       }
       while (CountInv(437) > 0 && InBank())
       {
        Deposit(437,1);
        Wait(Rand(200,500));
       }
       while (CountInv(438) > 0 && InBank())
       {
        Deposit(438,1);
        Wait(Rand(200,500));
       }
       while (CountInv(439) > 0 && InBank())
       {
        Deposit(439,1);
        Wait(Rand(200,500));
       }
       while (CountInv(440) > 0 && InBank())
       {
        Deposit(440,1);
        Wait(Rand(200,500));
       }
       while (CountInv(441) > 0 && InBank())
       {
        Deposit(441,1);
        Wait(Rand(200,500));
       }
       while (CountInv(442) > 0 && InBank())
       {
        Deposit(442,1);
        Wait(Rand(200,500));
       }
       while (CountInv(443) > 0 && InBank())
       {
        Deposit(443,1);
        Wait(Rand(200,500));
       }
       while (CountInv(815) > 0 && InBank())
       {
        Deposit(815,1);
        Wait(Rand(200,500));
       }
       while (CountInv(817) > 0 && InBank())
       {
        Deposit(817,1);
        Wait(Rand(200,500));
       }
       while (CountInv(819) > 0 && InBank())
       {
        Deposit(819,1);
        Wait(Rand(200,500));
       }
       while (CountInv(821) > 0 && InBank())
       {
        Deposit(821,1);
        Wait(Rand(200,500));
       }
       while (CountInv(823) > 0 && InBank())
       {
        Deposit(823,1);
        Wait(Rand(200,500));
       }
       while (CountInv(933) > 0 && InBank())
       {
        Deposit(933,1);
        Wait(Rand(200,500));
       }
       while (CountInv(herb[0]) > 0 && !InBank())
       {
       banking();
       }
    CloseBank();
    }
    }

    public void walktocollect()
    {
        while(GetX() != 216 && GetY() != 446) WalkToWait (216,446);
        while(GetX() != 208 && GetY() != 443) WalkToWait (208,443);
        while(GetX() != 213 && GetY() != 442) WalkToWait (213,442);
    }

    public void OnChatMessage(String sender, String message)
    {
        if((sender.substring(4).equalsIgnoreCase("mod ") || sender.equalsIgnoreCase("andrew") || sender.equalsIgnoreCase("paul")) && Running())
        {
            Display("A mod was detected!");
            Wait(Rand(2000,5000));
            Speak("Ooh, hey! " + sender + " nice to see you here :P");
            Wait(Rand(3000,6000));
            Speak("Well sorry I have to go now, see you later " + sender + ".");
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