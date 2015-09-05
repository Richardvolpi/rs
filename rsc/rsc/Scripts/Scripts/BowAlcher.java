public class BowAlcher extends Script
{
   public BowAlcher(mudclient rs)
   {
             super(rs);
   }
   
   public String[] getCommands()
   {
      return new String[]{"alchbow"};
   }
   
   public boolean Message = false;
   public boolean Sleep = false;
   public int BowCount = 0;
   public int StartXp;
   public int StartLvl;
   public int BagCount;
   public int Trips = 0;
   public String BowName;

   public void ServerMessage(String message)
   {
      if(message.indexOf("Alchemy spell") > 0)
      {
      Message = true;
      BowCount++;
      }
      if(message.indexOf("refreshed") > 0)
      Sleep = false;
   }

   public void start(String command, String parameter[])
   {
      String Bow = parameter[0];
      StartXp = GetExperience(6);
      StartLvl = GetStat(6);
      BowCount = 0;
      int BowID = 0;
      BowName = "null";
      
      if (Bow.equalsIgnoreCase("normalshort"))
      {
         BowID = 189;
         BowName = "Normal shortbow";
      }
      if (Bow.equalsIgnoreCase("normallong"))
      {
         BowID = 188;
         BowName = "Normal longbow";
      }
      if (Bow.equalsIgnoreCase("oakshort"))
      {
         BowID = 649;
         BowName = "Oak shortbow";
      }
      if (Bow.equalsIgnoreCase("oaklong"))
      {
         BowID = 648;
         BowName = "Oak longbow";
      }
      if (Bow.equalsIgnoreCase("willowshort"))
      {
         BowID = 651;
         BowName = "Willow shortbow";
      }
      if (Bow.equalsIgnoreCase("willowlong"))
      {
         BowID = 650;
         BowName = "Willow longbow";
      }
      if (Bow.equalsIgnoreCase("mapleshort"))
      {
         BowID = 653;
         BowName = "Maple shortbow";
      }
      if (Bow.equalsIgnoreCase("maplelong"))
      {
         BowID = 652;
         BowName = "Maple longbow";
      }
      if (Bow.equalsIgnoreCase("yewshort"))
      {
         BowID = 655;
         BowName = "Yew shortbow";
      }
      if (Bow.equalsIgnoreCase("yewlong"))
      {
         BowID = 654;
         BowName = "Yew longbow";
      }
      if (Bow.equalsIgnoreCase("magicshort"))
      {
         BowID = 656;
         BowName = "Magic shortbow";
      }
      if (Bow.equalsIgnoreCase("magiclong"))
      {
         BowID = 657;
         BowName = "Magic longbow";
      }
      if(parameter.length != 1)
      {
         DisplayMessage("@red@Invalid parameters! /run alchbow type", 3);
      }
      else
      {                                   
      DisplayMessage("@red@DamnMx BowAlcher", 3);
      DisplayMessage("@red@Start in a bank with runes, bows of 1 sort and a sleepingbag.", 3);
      DisplayMessage("@red@HighAlching: @whi@ "+ BowName, 3);
      while(Running())
      {
      Println("####### BowAlcher - DamnMx - Progress Report");
      Println("####### ");
      Println("####### Spells: " + Trips);
      Println("####### Used sleepingbag: " + BagCount + " times");
      Println("####### HighAlched: " + BowCount + " " + BowName);
      Println("####### Gained: " + (GetExperience(6) - StartXp) + " xp");
      Println("####### Gained: " + (GetStat(6) - StartLvl) + " levels");
      Trips++;
      
         while(InvCount(BowID) > 0 && Running())
         {
            while(!Sleep && InvCount(BowID) > 0 && Running())
            {
               Message = false;
               while(!Message && Running() && InvCount(BowID) > 0)
               {
                  MagicInventory(FindInv(BowID), 28);
                  Wait(200);
                  if(Fatigue() >= 75)
                  Sleep = true;
               }
               if(Message)
               {
                  WaitForServerMessage(3000);
               }
            }
            if(Sleep && Running())
            {
               Use(FindInv(1263));
               Wait(3000);
               BagCount++;
               while(Sleeping() && Running() && Sleep)
               {
                  Wait(100);
               }
               Sleep = false;
            }
         }
         OpenBank();
         Wait(1000);
         
         while(Bank() && Running())
         {
            while(InvCount() != 30)
            {
               Withdraw(BowID,1);
               Wait(100);
            }
            while(Bank() && Running() && InvCount() > 0)
            {
               CloseBank();
            }
         }
      }
      }
   }
}