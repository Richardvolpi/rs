public class chaosedgeherb extends Methods
{
    public chaosedgeherb(mudclient mc){super(mc);}
    int herb[] = {165,435,436,437,438,439,440,441,442,443,815,817,819,821,823,933};
    
    public void MainBody(String Args[])
    {
    AutoLogin(true);
        int FightMode = StrToInt(GetInput("Which fight mode do you want? Controlled=0, Str=1, Atk=2, Def=3"));
        Display("@dre@Chaos Druids Edge Dungeon Herb Collector -- @gre@Nattawat");
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
        if(GetX() == 120)
        {
            Display("@whi@Uh oh...you are dead while training, walking back!!!");
            while(GetX() != 132 && GetY() != 638) WalkToWait (132,638);
            while(GetX() != 135 && GetY() != 627) WalkToWait (135,627);
            while(GetX() != 136 && GetY() != 616) WalkToWait (136,616);
            while(GetX() != 155 && GetY() != 613) WalkToWait (155,613);
            while(GetX() != 172 && GetY() != 610) WalkToWait (172,610);
            while(GetX() != 188 && GetY() != 605) WalkToWait (188,605);
            while(GetX() != 200 && GetY() != 594) WalkToWait (200,594);
            while(GetX() != 210 && GetY() != 584) WalkToWait (210,584);
            while(GetX() != 226 && GetY() != 575) WalkToWait (226,575);
            while(GetX() != 239 && GetY() != 565) WalkToWait (239,565);
            while(GetX() != 239 && GetY() != 547) WalkToWait (239,547);
            while(GetX() != 239 && GetY() != 530) WalkToWait (239,530);
            while(GetX() != 239 && GetY() != 515) WalkToWait (239,515);
            while(GetX() != 224 && GetY() != 508) WalkToWait (224,508);
            while(GetX() != 219 && GetY() != 497) WalkToWait (219,497);
            while(GetX() != 218 && GetY() != 482) WalkToWait (218,482);
            while(GetX() != 220 && GetY() != 471) WalkToWait (220,471);
            while(GetX() != 226 && GetY() != 459) WalkToWait (226,459);
            while(GetX() != 223 && GetY() != 449) WalkToWait (223,449);
            while(GetX() != 216 && GetY() != 449) WalkToWait (216,449);
            getBag();
        }   
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
        int [] Npc = GetNpcById(270);
            if(Npc[0] != -1 && !InCombat() && !Sleeping() && Running())
            {
               AttackNpc(Npc[0]);
               Wait(Rand(700,900));
            }
         }
         else
         Wait(Rand(10,20));
       }
       walktobank();
    }

    public void getBag()
    {
        Display("@whi@Getting Sleeping Bag...");
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
        while (!InBank() && CountInv(1263) < 1)
           banking();
        while (InBank() && CountInv(1263) < 1)
        {
            if(!ItemInBank(1263))
               End("@red@Ran out of sleeping bag...SCRIPT STOPPED!");
            while (CountInv(1263) < 1 && InBank())
            {
               Withdraw(1263,1);
               Wait(Rand(2000,3000));
            }
        }
        CloseBank();
        Wait(1000);
        walktocollect();
    }

    public void walktobank()
    {
        Display("@whi@Walking back to bank...");
        while(GetX() != 209 && GetY() != 3254) WalkToWait (209,3254);
        while(GetX() != 198 && GetY() != 3254) WalkToWait (198,3254);
        while(GetX() != 196 && GetY() != 3265) WalkToWait (196,3265);
        while(GetY() < 3266)
        {
            AtObject(196,3266);
            Wait(1500);
        }
        while(GetX() != 197 && GetY() != 3273) WalkToWait (197,3273);
        while(GetX() != 206 && GetY() != 3273) WalkToWait (206,3273);
        while(GetX() != 216 && GetY() != 3273) WalkToWait (216,3273);
        while(GetX() != 217 && GetY() != 3283) WalkToWait (217,3283);
        while(GetX() != 215 && GetY() != 3292) WalkToWait (215,3292);
        while(GetX() != 215 && GetY() != 3299) WalkToWait (215,3299);
        while(GetY() > 3000)
        {
            AtObject(215,3300);
            Wait(1500);
        }        
        while(GetX() != 219 && GetY() != 456) WalkToWait (219,456);
        while(GetX() != 221 && GetY() != 446) WalkToWait (221,446);
        while(GetX() != 216 && GetY() != 451) WalkToWait (216,451);
        banking();
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
         while (CountInv(165) > 0 && InBank())
         {
            Deposit(165,1);
            Wait(Rand(200,500));
         }
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
      walktocollect();
    }

    public void walktocollect()
    {
        while(GetX() != 221 && GetY() != 446) WalkToWait (221,446);
        while(GetX() != 221 && GetY() != 445) WalkToWait (221,445);
        while(GetX() != 216 && GetY() != 468) WalkToWait (216,468);
        while(GetY() < 3000)
        {
           AtObject(215,468);
           Wait(1500);
        }
        while(GetX() != 215 && GetY() != 3292) WalkToWait (215,3292);
        while(GetX() != 217 && GetY() != 3283) WalkToWait (217,3283);
        while(GetX() != 216 && GetY() != 3273) WalkToWait (216,3273);
        while(GetX() != 206 && GetY() != 3273) WalkToWait (206,3273);
        while(GetX() != 197 && GetY() != 3273) WalkToWait (197,3273);
        while(GetX() != 196 && GetY() != 3266) WalkToWait (196,3266);
        while(GetY() > 3265)
        {
           AtObject(196,3266);
           Wait(1500);
        }
        while(GetX() != 198 && GetY() != 3254) WalkToWait (198,3254);
        while(GetX() != 209 && GetY() != 3254) WalkToWait (209,3254);
        collect();
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
    }
}