public class karamjaf1sher extends Script
{
       public karamjaf1sher(mudclient rs)
       {
           super(rs);
   }
      public String[] getCommands()
       {
           return new String[]{"karamjaf1sher"};
   }
   public void start(String command, String parameter[])
       {   
          DisplayMessage("@gre@SBoT: @whi@Karamjaf1sher - Laurent",3) ;
      
      int SwordfishCount = 0;
      int TripCount = 0;
      int BurntCount = 0;
      int FishingXPCount = 0;
      int CookingXPCount = 0;
      int TunaDropt = 0;
      int FishingStart = GetExperience(10);
      int CookingStart = GetExperience(7);
      int Burnt = 0;
      int TimesSlept = 0;
      int CookingLvlStart = GetStat(7);
      int FishingLvlStart = GetStat(10);
      int FishingLvlsGained = 0;
      int CookingLvlsGained = 0;

      while (Running())
          {
         while (Running() && InvCount() < 30)   
               {
            AtObject(368,684);
                      Wait(1000);
              if (Fatigue() > 84)
            {
               TimesSlept = TimesSlept + 1;
               while (Sleeping() == false)
               {
                  Use(FindInv(1263));
                  Wait(2500);
               }
               while (Sleeping() && Running())
               {
                  Wait(100);
               }
            }
         
            while(Running() && InvCount(366)>0)   
            {
               Drop(FindInv(366));
               Wait(750);      
            }
             }   
         if(Running() && InvCount() == 30)
         {
            Walk(371,694);
            Walk(370,702);
            Walk(364,708);
            Walk(355,710);
            Walk(347,711);
            Walk(339,712);
            Walk(331,713);
            while(QuestMenu() == false)
            {
               int CustomsID = GetNearestNPC(163);
               long CurrentTime = System.currentTimeMillis();
               TalkToNPC(CustomsID);
               while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
               {
                  Wait(100);
               }
               Wait(1000);
            }
            Answer(0);
                 while(QuestMenu() == false)
                 {
                        Wait(1);
                 }
            Answer(1);
            while(QuestMenu() == false)
            {
               Wait(1);
            }
            Answer(0);
            while (GetX() != 268 && GetY() != 651)
            {
               Wait(1);
            }
            ResetLastServerMessage();
            while(InLastServerMessage("The ship arrives") == false)
            {
               Wait(1);
            }       
            Walk(269,640);
            Walk(269,635);
            Walk(276,636);
            Walk(277,639);
            Wait(100);         
            }
         while(InvCount(369) != 0)
         {
                  UseOnObject(275,638,FindInv(369));
                  Wait(1000);
                  if (Fatigue() == 100)
            {
                           TimesSlept = TimesSlept + 1;
               while (Sleeping() == false)
                           {
                  DisplayMessage("@gre@SBoT: @whi@Sleeping", 3);
                             Use(FindInv(1263));
                              Wait(2500);
                          }
                           while (Sleeping() == true)
               {
                              Wait(100);
    
                         }
                     } 
           }
            while(InvCount(371) > 0)
            {
              Drop(FindInv(371));
               Wait(1000);
            }
         SwordfishCount = SwordfishCount + InvCount(370);
         BurntCount = BurntCount + 27 - InvCount(370);

Walk(276,636);
         Walk(270,622);
         Walk(254,617);
         Walk(233,627);
         Walk(219,637);
         while(QuestMenu() == false)
         {
            int ClosestBankerID = GetNearestNPC(95);
            long CurrentTime = System.currentTimeMillis();
            TalkToNPC(ClosestBankerID);   
            while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
            {
               Wait(1);
            }
            Wait(100);
         }
         Answer(0);
         while(Bank() == false)
         {
            Wait(1);
         }
         Wait(100);
         while(InvCount(370) != 0)
         {
            Deposit(370,1);
            Wait(100);
         }
         Wait(100);
         Withdraw(10,25);
         Withdraw(10,25);
         Withdraw(10,10);
         CloseBank();
         while (ObjectAt(219, 633) == 64)
         {
            AtObject(219, 633);
            Wait(5000);
         }
         Walk(240,620);
         Walk(245,610);
         Walk(259,625);
         Walk(259,639);
         Walk(269,650);
         while (QuestMenu() == false)
         {
            int SeamanID = GetNearestNPC(166);
            long CurrentTime = System.currentTimeMillis();
            TalkToNPC(SeamanID);
            AtObject(265, 645);
            while(System.currentTimeMillis() - CurrentTime <= 5000 && QuestMenu() == false)
            {
               Wait(1);
            }
            Wait(100);
         }
         Answer(1);
         while (GetX() != 324 && GetY() != 713)
         {
            Wait(1);
         }
         ResetLastServerMessage();
         while(InLastServerMessage("The ship arrives") == false)
         {
            Wait(1);
         }
         Walk(338,713);
         Walk(362,710);
         Walk(370,694);   
         WalkNoWait(369, 684);                     

         
         TripCount = TripCount + 1;
         FishingXPCount =  GetExperience(10) - FishingStart;
         CookingXPCount = GetExperience(7) - CookingStart;
         Burnt = (100*BurntCount)/(27*TripCount);
         FishingLvlsGained = GetStat(10) - FishingLvlStart;
         CookingLvlsGained = GetStat(7) - CookingLvlStart;
         TunaDropt = (FishingXPCount - (SwordfishCount*100))/80;

         System.out.println("===========================================================");
               System.out.println("                    Trip #" +TripCount);
              System.out.println("===========================================================");
         System.out.println("Swordfishes cooked: " + SwordfishCount);
         System.out.println("Swordfishes burnt: " + BurntCount);
         System.out.println("Average burnt: " + Burnt + "%");
         System.out.println(" ");
         System.out.println("Fishing experience gained: " + FishingXPCount);
         System.out.println("Cooking experience gained: " + CookingXPCount);
         System.out.println(" ");
         System.out.println("Tuna dropt: " + TunaDropt);
         System.out.println("Times slept: " + TimesSlept);
         System.out.println(" ");
         System.out.println("Gained " + FishingLvlsGained + " fishinglevels and " + CookingLvlsGained + " cookinglevels so far");
      }
      DisplayMessage("@red@STOPPED",3);
       }
} 