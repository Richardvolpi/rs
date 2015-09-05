public class ogrebones extends Methods
{
    public ogrebones(mudclient mc){super(mc);}
    private int FMode = -1;
    private int FightMode = -1;
    private int food = -1;
    private int FoodID = -1;
    private int eat = -1;
    private int EatAt = -1;
    private String ModeName = "null";
    private String FoodName = "null";
    private String[] option1 = {"Controlled","Aggressive","Accurate","Defensive"};
    private String[] option2 = {"Trout","Salmon","Tuna","Lobster","Bass","Swordfish","Shark"};
    private String[] option3 = {"10","15","20","25","30","35","40","45","50","55","60","65","70","75","80","85","90"};
    
    public void MainBody(String Args[])
    {
        AutoLogin(true);
        FMode = GetOption("Choose the fight mode you wish to use.",option1);
        if(FMode == 0)
        {
           Display("@whi@You have chose to fight in @ora@Controlled@whi@ mode.");
           FightMode = 0;
           ModeName = "Controlled";
        }
        if(FMode == 1)
        {
           Display("@whi@You have chose to fight in @ora@Aggressive@whi@ mode.");
           FightMode = 1;
           ModeName = "Aggressive";
        }
        if(FMode == 2)
        {
           Display("@whi@You have chose to fight in @ora@Accurate@whi@ mode.");
           FightMode = 2;
           ModeName = "Accurate";
        }
        if(FMode == 3)
        {
           Display("@whi@You have chose to fight in @ora@Defensive@whi@ mode.");
           FightMode = 3;
           ModeName = "Defensive";
        }
        food = GetOption("Choose the food you wish to use.",option2);
        if(food == 0)
        {
           Display("@whi@You have chose to use @ora@Trout@whi@ as your food.");
           FoodID = 359;
           FoodName = "Trout";
        }
        if(food == 1)
        {
           Display("@whi@You have chose to use @ora@Salmon@whi@ as your food.");
           FoodID = 357;
           FoodName = "Salmon";
        }
        if(food == 2)
        {
           Display("@whi@You have chose to use @ora@Tuna@whi@ as your food.");
           FoodID = 367;
           FoodName = "Tuna";
        }
        if(food == 3)
        {
           Display("@whi@You have chose to use @ora@Lobster@whi@ as your food.");
           FoodID = 373;
           FoodName = "Lobster";
        }
        if(food == 4)
        {
           Display("@whi@You have chose to use @ora@Bass@whi@ as your food.");
           FoodID = 555;
           FoodName = "Bass";
        }
        if(food == 5)
        {
           Display("@whi@You have chose to use @ora@Swordfish@whi@ as your food.");
           FoodID = 370;
           FoodName = "Swordfish";
        }
        if(food == 6)
        {
           Display("@whi@You have chose to use @ora@Shark@whi@ as your food.");
           FoodID = 546;
           FoodName = "Shark";
        }
        eat = GetOption("At which HP level would you like to eat your " + FoodName + "?",option3);
        if(eat == 0)
        {
           Display("@whi@You have chose to eat at @ora@10 @whi@hitpoints.");
           EatAt = 10;
        }
        if(eat == 1)
        {
           Display("@whi@You have chose to eat at @ora@15 @whi@hitpoints.");
           EatAt = 15;
        }
        if(eat == 2)
        {
           Display("@whi@You have chose to eat at @ora@20 @whi@hitpoints.");
           EatAt = 20;
        }
        if(eat == 3)
        {
           Display("@whi@You have chose to eat at @ora@25 @whi@hitpoints.");
           EatAt = 25;
        }
        if(eat == 4)
        {
           Display("@whi@You have chose to eat at @ora@30 @whi@hitpoints.");
           EatAt = 30;
        }
        if(eat == 5)
        {
           Display("@whi@You have chose to eat at @ora@35 @whi@hitpoints.");
           EatAt = 35;
        }
        if(eat == 6)
        {
           Display("@whi@You have chose to eat at @ora@40 @whi@hitpoints.");
           EatAt = 40;
        }
        if(eat == 7)
        {
           Display("@whi@You have chose to eat at @ora@45 @whi@hitpoints.");
           EatAt = 45;
        }
        if(eat == 8)
        {
           Display("@whi@You have chose to eat at @ora@50 @whi@hitpoints.");
           EatAt = 50;
        }
        if(eat == 9)
        {
           Display("@whi@You have chose to eat at @ora@55 @whi@hitpoints.");
           EatAt = 55;
        }
        if(eat == 10)
        {
           Display("@whi@You have chose to eat at @ora@60 @whi@hitpoints.");
           EatAt = 60;
        }
        if(eat == 11)
        {
           Display("@whi@You have chose to eat at @ora@65 @whi@hitpoints.");
           EatAt = 65;
        }
        if(eat == 12)
        {
           Display("@whi@You have chose to eat at @ora@70 @whi@hitpoints.");
           EatAt = 70;
        }
        if(eat == 13)
        {
           Display("@whi@You have chose to eat at @ora@75 @whi@hitpoints.");
           EatAt = 75;
        }
        if(eat == 14)
        {
           Display("@whi@You have chose to eat at @ora@80 @whi@hitpoints.");
           EatAt = 80;
        }
        if(eat == 15)
        {
           Display("@whi@You have chose to eat at @ora@85 @whi@hitpoints.");
           EatAt = 85;
        }
        if(eat == 16)
        {
           Display("@whi@You have chose to eat at @ora@90 @whi@hitpoints.");
           EatAt = 90;
        }
        Display("@cya@Ogres Killer @red@[blood chest cave] @cya@+ big bones burier! -- @gre@Nattawat");
        Display("@ran@REVIEW: @whi@You will be fighting in @ora@" + ModeName + " @whi@mode, and eat @ora@ " + FoodName + " @whi@at@ora@ " + EatAt + " @whi@hitpoints.");
        LockMode(FightMode);
        while(Running())
        {
            if(GetY() < 3000 && Running())
            {
               banking();
            }
            bury();
        }
    }

    public void bury()
    {
    Display("@whi@Collecting + Burying Big Bones...");
    while(CountInv() == 30)
    {
      UseItem(GetItemPos(FoodID));
      Wait(Rand(1500,2000));
    }
    while(CountInv(FoodID) > 0 && Running())
      {
         if(GetMode() != FightMode) {SetMode(FightMode);}
         if(GetCurLvl(3) <= EatAt && InInv(FoodID))
         {
            Display("@whi@Eating " + FoodName + "...");
            UseItem(GetItemPos(FoodID));
            Wait(Rand(1000,2000));
         }
         if(InInv(413) && Running())
         {
            if(InCombat() && Running())
            {
               WalkTo(GetX(),GetY());
               Wait(Rand(600,800));
            }
            if(!InCombat() && Running())
            {
               Display("@whi@Burying...");
               UseItem(GetItemPos(413));
               Wait(Rand(900,1200));
            }
         }
         int[] bone = GetItemById(413);
         if(bone[1] != -1)
         {
            if(InCombat() && Running())
            {
               WalkTo(GetX(),GetY());
               Wait(Rand(600,800));
            }
            PickupItem(bone[1],bone[2],bone[0]);
            Wait(500);
         }
       else
         if(!InCombat() && Running())
         {
            if(GetFatigue() > 95 && Running())  {sleeping();}
            int [] Ogre = GetNpcById(525);
            if(Ogre[0] != -1 && !InCombat() && !Sleeping() && Running())
            {
               AttackNpc(Ogre[0]);
               Wait(Rand(700,900));
            }
         }
         else
         Wait(Rand(10,20));
       }
      while(CountInv(FoodID) == 0 && Running())
      {
         Display("@whi@Uh oh...ran out of " + FoodName + "...going to bank!");
         walktobank();
      }       
    }

    public void sleeping()
    {
      Display("@whi@Walking to safe place to sleep...");
      WalkToWait(618,3388);
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
      WalkToWait(618,3399);
    }

    public void walktobank()
    {
       if(IsReachable(614,3400))
       {
          WalkToWait(614,3400);
          WalkToWait(617,3394);
          while(GetY() > 3000 && Running())
          {
             AtObject(618,3383);
             Wait(2000);
          }
          while(GetY() < 556 && Running())
          {
             AtWallObject(617,556);
             Wait(2000);
          }
          WalkToWait(617,556);
          WalkToWait(609,566);
       }
       WalkToWait(611,576);
       WalkToWait(611,593);
       WalkToWait(603,594);
       WalkToWait(594,603);
       WalkToWait(588,600);
       WalkToWait(587,584);
       WalkToWait(587,571);
       WalkToWait(581,571);
       WalkToWait(581,574);
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
       while (!InBank() && CountInv() < 30)
          banking();
       while (InBank() && CountInv() < 30)
       {
           if(!ItemInBank(FoodID))
             End("@whi@You had ran out of @ora@" + FoodName + "@whi@...Script Stopped!");
           Withdraw(FoodID,1);
           Wait(Rand(400,600));
       }
       while (CountInv() < 30 && !InBank())  {banking();}
       CloseBank();
       walktobury();
    }

    public void walktobury()
    {
       Display("@whi@Walking back to bury again...");
       WalkToWait(581,571);
       WalkToWait(587,571);
       WalkToWait(587,584);
       WalkToWait(588,600);
       WalkToWait(594,603);
       WalkToWait(603,594);
       WalkToWait(611,593);
       WalkToWait(611,576);
       WalkToWait(609,566);
       WalkToWait(617,556);
       while(GetY() > 555 && Running())
       {
          AtWallObject2(617,556);
          Wait(2000);
       }
       while(GetY() < 3000 && Running())
       {
          AtObject(618,551);
          Wait(2000);
       }
       WalkToWait(617,3394);
       bury();
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