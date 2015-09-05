public class lumbflyfisher extends Methods
{
   public lumbflyfisher(mudclient mc){super(mc);}
   private String[] DoWhat = {"Power Fly Fishing","Fishing and Sell Raw Fish","Fishing, Cooking, and Sell Cooked Fish"};
   private String[] Cooking = {"Cut tree and light fire","Go to Lumbridge Castle and cook [Cook Assistance complete required]"};
   private long l;
   private int intDoWhat = -1;
   private int intCooking = -1;
   private int FeatherAmount = -1;
   private int Level = -1;
   private int[] Shop = {83,55};
   private int[] Axe = {405,204,203,88,12,87};
   private int[] Tree = {0,1};

   public void MainBody(String args[])
   {
       Display("@dre@Lumbridge Fly Fisher --- @gre@Nattawat");
       intDoWhat = GetOption("What would you like to do?",DoWhat);
       if(intDoWhat == 2)
       {
           intCooking = GetOption("Which cooking method would you want to use?",Cooking);
       }
       FeatherAmount = StrToInt(GetInput("How many feathers you want to buy at a time when you ran out of them?"));
       Level = StrToInt(GetInput("Which fishing level you want to stop? HINT: 100 or more for unlimit"));
       AutoLogin(true);
       StartScanForMods();
       while(Running() && UnderLevel())
       {
           if(intDoWhat == 0 && Running() && UnderLevel())
           {
               CheckValid();
               if(!IsInShop() && !IsInFishing() && Running() && UnderLevel())
               {
                   End("You must be IN Fishing Shop, or close to the fishing spot in Lumbridge.");
               }
               if(IsInShop() && Running() && UnderLevel())
               {
                   ShopToFish();
               }
               while(IsInFishing() && InInv(378) && InInv(1263) && InInv(381) && Running() && UnderLevel())
               {
                   Fishing();                       
               }
           }
           if(intDoWhat == 1 && Running() && UnderLevel())
           {
               CheckValid();
               if(!IsInFishing() && !IsInStore() && Running() && UnderLevel())
               {
                   End("You must be either in Lumbridge General Store or near Lumbridge fishing spot.");
               }
               if(IsInStore() && InInv(378) && InInv(1263) && InInv(381) && CountInv() < 30 && Running() && UnderLevel())
               {
                   StoreToFish();
               }
               while(IsInFishing() && InInv(378) && InInv(1263) && InInv(381) && CountInv() < 30 && Running() && UnderLevel())
               {
                   Fishing();
               }
               if(CountInv() == 30 && !IsInStore() && Running() && UnderLevel())
               {
                   FishToStore();
               }
               while(InInv(358) && InInv(356) && Running() && UnderLevel())
               {
                   Sell(358,356);
               }
               if(IsInStore() && !InInv(358) && !InInv(356) && Running() && UnderLevel())
               {
                   StoreToFish();
               }
           }
           if(intDoWhat == 2 && Running() && UnderLevel())
           {
               CheckValid();
               if(!IsInFishing() && !IsInStore() && Running() && UnderLevel())
               {
                   End("You must be either in Lumbridge General Store or near Lumbridge fishing spot.");
               }
               if(IsInStore() && InInv(378) && InInv(1263) && InInv(381) && CountInv() < 30 && Running() && UnderLevel())
               {
                   StoreToFish();
               }
               while(IsInFishing() && InInv(378) && InInv(1263) && InInv(381) && CountInv() < 30 && Running() && UnderLevel())
               {
                   Fishing();
               }
               if(CountInv() == 30 && Running() && UnderLevel())
               {
                   if(intCooking == 0 && Running() && UnderLevel())
                   {
                       if(!InInv(166) || (!InInv(87) && !InInv(12) && !InInv(88) && !InInv(203) && !InInv(204) && !InInv(405)) && Running() && UnderLevel())
                       {
                           End("You must have tinderbox AND hatchet in your inventory");
                       }
                       while(GetItemById(14)[1] != GetX() && GetItemById(14)[2] != GetY() && Running() && UnderLevel())
                       {
                           int[] trees = GetObjectById(Tree);
                           if(trees[1] != -1 && Running() && UnderLevel())
                           {
                               SleepIfAt(95);
                               AtObject(trees[1],trees[2]);
                               Wait(3000);
                           }
                       }
                       int[] log = GetItemById(14);
                       while(GetObjectById(97)[1] != GetX() && GetObjectById(97)[2] != GetY() && Running() && UnderLevel())
                       {
                           UseItemOnGItem(GetItemPos(166),log[1],log[2],14);
                           Wait(1500);
                       }
                       int[] fire = GetObjectById(97);
                       while(fire[1] == GetX() && fire[2] == GetY() && InInv(358) && Running() && UnderLevel())
                       {
                           SleepIfAt(95);
                           UseOnObject(GetItemPos(358),fire[1],fire[2]);
                           Wait(Rand(1000,1200));
                       }
                       while(fire[1] == GetX() && fire[2] == GetY() && InInv(356) && Running() && UnderLevel())
                       {
                           SleepIfAt(95);
                           UseOnObject(GetItemPos(356),fire[1],fire[2]);
                           Wait(Rand(1000,1200));
                       }
                       if(!InInv(356) && !InInv(358) && InInv(360) && Running() && UnderLevel())
                       {
                               DropItem(GetItemPos(360));
                               Wait(Rand(800,1000));
                       }
                       WalkToWait(124,630);
                       if(IsInFishing() && !InInv(356) && !InInv(358) && Running() && UnderLevel())
                       {
                           FishToStore();
                       }
                       while(IsInStore() && InInv(359) && InInv(357) && Running() && UnderLevel())
                       {
                           Sell(359,357);
                       }
                       if(IsInStore() && !InInv(359) && !InInv(357) && Running() && UnderLevel())
                       {
                           StoreToFish();
                       }
                   }
                   if(intCooking == 1 && Running() && UnderLevel())
                   {
                       if(!QuestDone(1) && Running() && UnderLevel())
                       { 
                           End("Cook's Assistant quest is NOT complete, you need to complete it first.");
                       }
                       if(!IsInFishing() && !IsInCastle() && Running() && UnderLevel())
                       {
                           End("Make sure you are near Lumbridge's fishing spot or inside Lumbridge Castle [1st floor]");
                       }
                       if(IsInFishing() && Running() && UnderLevel())
                       {
                           WalkToWait(119,637);
                           WalkToWait(108,644);
                           WalkToWait(104,656);
                           WalkToWait(116,658);
                           WalkToWait(127,658);
                           while(GetIdObject(128,658) == 64)
                           {
                               AtObject(128,658);
                               Wait(1500);
                           }
                           WalkToWait(132,660);
                       }
                       if(IsInCastle() && Running() && UnderLevel())
                       {
                           int[] range = GetObjectById(119);
                           while(range[1] != -1 && InInv(358) && Running() && UnderLevel())
                           {
                               SleepIfAt(95);
                               UseOnObject(GetItemPos(358),range[1],range[2]);
                               Wait(Rand(1000,1200));
                           }
                           while(range[1] != -1 && InInv(356) && Running() && UnderLevel())
                           {
                               SleepIfAt(95);
                               UseOnObject(GetItemPos(356),range[1],range[2]);
                               Wait(Rand(1000,1200));
                           }
                           if(!InInv(356) && !InInv(358) && InInv(360) && Running() && UnderLevel())
                           {
                               DropItem(GetItemPos(360));
                               Wait(Rand(800,1000));
                           }                       
                           WalkToWait(130,658);
                           while(GetIdObject(128,658) == 64)
                           {
                               AtObject(128,658);
                               Wait(1500);
                           }
                           WalkToWait(121,658);
                       }
                       WalkToWait(118,648);
                       WalkToWait(131,640);
                       while(GetIdWallObject(132,641) == 2)
                       {
                           AtObject(132,641);
                           Wait(1000);
                       }
                       WalkToWait(134,642);
                       while(IsInStore() && InInv(359) && InInv(357) && Running() && UnderLevel())
                       {
                           Sell(359,357);
                       }
                   }
                   if(IsInStore() && !InInv(359) && !InInv(357) && Running() && UnderLevel())
                   {
                       StoreToFish();
                   }
               }
           }
       }
       while(Running() && !UnderLevel())
       {
           End("You had reached your wanted fishing level.  Script Stopped!");
       }
   }
   
   public boolean UnderLevel()
   {
       if(GetMaxLvl(10) < Level)
           return true;
       else
           return false;
   }

   public boolean IsInFishing()
   {
       if(GetX() >= 120 && GetX() <= 129 && GetY() >= 623 && GetY() <= 638)
           return true;
       else
           return false;
   }

   public boolean IsInShop()
   {
       if(GetX() >= 276 && GetX() <= 280 && GetY() >= 645 && GetY() <= 650)
           return true;
       else
           return false;
   }

   public boolean IsInStore()
   {
       if(GetX() >= 132 && GetX() <= 137 && GetY() >= 639 && GetY() <= 644)
           return true;
       else
           return false;
   }

   public boolean IsInCastle()
   {
       if(GetX() >= 129 && GetX() <= 137 && GetY() >= 650 && GetY() <= 665)
           return true;
       else
           return false;
   }

   public void FishToShop()
   {
       WalkToWait(123,625);
       WalkToWait(135,625);
       WalkToWait(135,637);
       WalkToWait(148,639);
       WalkToWait(163,644);
       WalkToWait(179,642);
       WalkToWait(193,644);
       WalkToWait(209,644);
       WalkToWait(222,640);
       WalkToWait(232,627);
       WalkToWait(244,610);
       WalkToWait(261,610);
       WalkToWait(270,624);
       WalkToWait(270,640);
       WalkToWait(270,651);
       WalkToWait(277,651);
       while(GetIdWallObject(277,651) == 2)
       {
           AtObject(277,651);
           Wait(1000);
       }
       WalkToWait(277,648);
   }

   public void ShopToFish()
   {
       WalkToWait(276,646);
       while(GetIdWallObject(277,651) == 2)
       {
           AtObject(277,651);
           Wait(1000);
       }
       WalkToWait(269,650);
       WalkToWait(269,635);
       WalkToWait(269,620);
       WalkToWait(252,609);
       WalkToWait(236,619);
       WalkToWait(229,624);
       WalkToWait(225,637);
       WalkToWait(212,647);
       WalkToWait(195,653);
       WalkToWait(179,652);
       WalkToWait(161,645);
       WalkToWait(144,639);
       WalkToWait(130,632);
       WalkToWait(124,630);
   }
   
   public void FishToStore()
   {
       WalkToWait(123,629);
       WalkToWait(129,625);	
       WalkToWait(131,640);
       while(GetIdWallObject(132,641) == 2)
       {
           AtObject(132,641);
           Wait(1000);
       }
       WalkToWait(134,642);
   }
   
   public void StoreToFish()
   {
       WalkToWait(131,634);
       WalkToWait(128,625);
       WalkToWait(123,630);
   }

   public void Sell(int ID1, int ID2)
   {
       while(!QuestMenu() && Running() && UnderLevel()) 
       {
           l = GetMillis();
           int shop[] = GetNpcById(Shop);
           if(shop[0] != -1)
               TalkToNpc(shop[0]);
           while(GetMillis() - l < 5000 && !QuestMenu() && Running() && UnderLevel()) 
               Wait(1000);
       }
       Answer(0);
       l = GetMillis();
       while(!InShop() && Running() && UnderLevel() && GetMillis() - l < 10000 && Running() && UnderLevel())
       {
           Wait(500);
       }
       if(!InShop() && Running() && UnderLevel())
       {
           Sell(ID1,ID2);
       }
       while(InShop() && InInv(ID1) && Running() && UnderLevel())
       {
           SellShopItem(ID1);
           Wait(Rand(400,600));
       }
       while(InShop() && InInv(ID2) && Running() && UnderLevel())
       {
           SellShopItem(ID2);
           Wait(Rand(400,600));
       }
       CloseShop();
   }
   
   public void CheckValid()
   {   
       if(!InInv(378) && Running() && UnderLevel())
       {
           End("You did not have @ora@Fly Fishing Rod@whi@. Script Stopped!");
       }
       if(!InInv(1263) && Running() && UnderLevel())
       {
           End("You did not have @ora@Sleeping Bag@whi@. Script Stopped!");
       }
       if(!InInv(381) && Running() && UnderLevel())
       {
           if(CountInv(10) < 100 && Running() && UnderLevel())
           {
                End("Your money is too low, not worth walking to buy feathers. Script Stopped!");
           }
           if(!IsInFishing() && !IsInShop() && Running() && UnderLevel())
           {
                End("You must be IN Fishing Shop, or close to the fishing spot in Lumbridge.");
           }
           if(IsInFishing() && Running() && UnderLevel())
           {
                FishToShop();
           }
           while(IsInShop() && CountInv(381) < FeatherAmount && Running() && UnderLevel())
           {
                BuyFeathers();
           }
           ShopToFish();
       }
   }
  
   public void BuyFeathers()
   {
       while(!QuestMenu() && Running() && UnderLevel()) 
       {
           l = GetMillis();
           int shop[] = GetNpcById(167);
           if(shop[0] != -1)
               TalkToNpc(shop[0]);
           while(GetMillis() - l < 5000 && !QuestMenu() && Running() && UnderLevel()) 
               Wait(1000);
       }
       Answer(0);
       l = GetMillis();
       while(!InShop() && Running() && UnderLevel() && GetMillis() - l < 10000)
       {
           Wait(500);
       }
       if(!InShop() && Running() && UnderLevel())
       {
           BuyFeathers();
       }
       while(InShop() && CountInv(10) > 0 && CountInv(381) < FeatherAmount && Running() && UnderLevel())
       {
           if(CountInv(10) < ShopBuyPrice(381))
               End("You had ran out of money");
           BuyShopItem(381);
           Wait(Rand(400,600));
       }
       CloseShop();
   }
   
   public void Fishing()
   {
       SleepIfAt(95);
       int[] fish = GetObjectById(192);
       if(fish[0] != -1)
       {
           AtObject(fish[1],fish[2]);
           Wait(1500);
       }
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