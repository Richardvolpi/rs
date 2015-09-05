public class Smelterz extends Script
{
   public Smelterz(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"smeltal","smeltfal"};
   }
   public boolean Sleep = false;
   public boolean Smelting = false;
   public int Trips = 0;
   public long StartS = (long)((int)(System.currentTimeMillis() / 1000));
   public int BarCount = 0;
   public int PotentialBars = 0;
   public int BarID = 0;
   public int OreID = 0;
   public int CoalAmount = 0;
   public int OreAmount = 0;
   public int LVL = 0;
   public String Type = "";
   public double TotalEXP = 0;
   public double EXP = 0;
   public void KeyPressed(int id)
   {
       if (id == 1010)
       {
           DisplayMessage("@dre@Exp Gained: " +TotalEXP,3); 
           DisplayMessage("@dre@Bars Smelted: " +BarCount,3);
           DisplayMessage("@dre@Minutes Passed " +(((long)((int)(System.currentTimeMillis() / 1000)) - StartS) / 60),3);
           id = 0;
       }
   }
   public void ServerMessage(String message)
   {
       if(message.indexOf("@gre@You just advanced") > 0)
       {
           LVL++;
       }
       if(message.indexOf("You are too tired") > 0)
       {
           Sleep = true;
           ResetLastServerMessage();
       }
       if(message.equals("You wake up - feeling refreshed") || message.equals("@gam@Welcome to RuneScape!"))
       {
           Sleep = false;
           ResetLastServerMessage();
       }
       if(message.indexOf("@gam@You Place") >= 0)
       {
           Smelting = true;   
           ResetLastServerMessage();
       }
       if(message.indexOf("@gam@You retrieve") >= 0)
       {
           TotalEXP += EXP;
           Smelting = false;
           BarCount++;
           ResetLastServerMessage();
       }
   }
   public void FalFurnaceWalk()
   {
       ForceWalk(328,553);
       Wait(250); 
       while(ObjectAt(327,552) == 64)

       {
           AtObject(327,552);
           Wait(500);   
       }
       ForceWalk(327,553);
       ForceWalk(312,544);
       Wait(250); 
       while(DoorAt(312,544,1) == 2)
       {
           OpenDoor(312, 544, 1);
           Wait(500);   
       }
       ForceWalk(311,544);
       ForceWalkNoWait(310,545);
   }
   public void FalBankWalk()
   {
       ForceWalk(311,544);
       Wait(250); 
       while(ObjectAt(312,544) == 2)
       {
           AtObject(312,544);
           Wait(500);   
       }
       ForceWalk(312,544);
       ForceWalk(327,553);
       Wait(250); 
       while(ObjectAt(327,552) == 64)
       {
           AtObject(327,552);
           Wait(500);   
       }
       ForceWalkNoWait(328,553); 
   }
   public void FalSmelt(int OreType)
   {
       while(InvCount(OreType) > 0)
       {
           if (Sleep)
      {
          while(!Sleeping() && Running())
          {
          Use(FindInv(1263));
          Wait(2000);
          }
          while(Sleeping() && Running())
          {
          Wait(50);
          }
      }
           UseOnObject(310,546,FindInv(OreType));
           Wait(50);
           while(Smelting)
               Wait(5);
       }
   }
   public void AlFurnaceWalk()
   {
       ForceWalk(87,695); 
       while(ObjectAt(86,695) == 64)
       {
           AtObject(86,695);
           Wait(500);   
       }
       ForceWalk(86,695);
       ForceWalk(82,679);       
       ForceWalkNoWait(84,679);
   }
   public void AlBankWalk()
   {
       ForceWalk(82,679);
       ForceWalk(86,695);
       while(ObjectAt(86,695) == 64)
       {
           AtObject(86,695);
           Wait(500);   
       }
       ForceWalkNoWait(87,695);
   }
   public void AlSmelt(int OreType)
   {
       while(InvCount(OreType) > 0)
       {
           if (Sleep)
      {
          while(!Sleeping() && Running())
          {
          Use(FindInv(1263));
          Wait(2000);
          }
          while(Sleeping() && Running())
          {
          Wait(50);
          }
      }
           UseOnObject(85,679,FindInv(OreType));
           Wait(50);
           while(Smelting)
               Wait(5);
       }
   }
   public void DepositBars(int BarID)
   {
       while(InvCount(BarID) > 0)
       {
           Deposit(BarID,1);
           Wait(10); 
       } 
   }
   public void WithdrawOres(int CoalAmount, int OreAmount, int OreID)
   {
           for(int i=0; i<CoalAmount; i++)
           {
               Withdraw(155,1); 
           }
           for(int i=0; i<OreAmount; i++)
           {
               Withdraw(OreID,1); 
           }
   }
   //}
   public void start(String command, String parameter[])
   {
      if(parameter[0].equalsIgnoreCase("silver")){ OreID = 383; CoalAmount = 0; OreAmount = 29; BarID = 384; Type = "Silver"; EXP = 13.5;}
      if(parameter[0].equalsIgnoreCase("gold")){ OreID = 152; CoalAmount = 0; OreAmount = 29; BarID = 172; Type = "Gold"; EXP = 22.5;}
      if(parameter[0].equalsIgnoreCase("iron")){ OreID = 151; CoalAmount = 0; OreAmount = 29; BarID = 170; Type = "Iron"; EXP = 12.5;}
      if(parameter[0].equalsIgnoreCase("steel")){ OreID = 151; CoalAmount = 18; OreAmount = 9; BarID = 171; Type = "Steel"; EXP = 18.75;}
      if(parameter[0].equalsIgnoreCase("mith")){ OreID = 153; CoalAmount = 20; OreAmount = 5; BarID = 173; Type = "Mith"; EXP = 25;}
      if(parameter[0].equalsIgnoreCase("addy")){ OreID = 154; CoalAmount = 24; OreAmount = 4; BarID = 174; Type = "Addy"; EXP = 33.75;}
      if(parameter[0].equalsIgnoreCase("rune")){ OreID = 409; CoalAmount = 24; OreAmount = 3; BarID = 171; Type = "Rune"; EXP = 37.5;}
      DisplayMessage("@bla@Smelter",3);
      DisplayMessage("@gre@By: Davis Zanot",3);
      OpenBank();
      DepositBars(BarID);
      WithdrawOres(CoalAmount,OreAmount,OreID);
      while (Running())
      {
          if(command.equalsIgnoreCase("smeltfal"))
          {             
              FalFurnaceWalk();
              FalSmelt(OreID);
              FalBankWalk();
          }
          else
          {             
              AlFurnaceWalk();
              AlSmelt(OreID);
              AlBankWalk();
          }
          OpenBank();
          DepositBars(BarID);
          WithdrawOres(CoalAmount,OreAmount,OreID);
          Trips++;

          float Minutes = (float)((((float)System.currentTimeMillis() / 1000) - (float)StartS) / 60);
          double EXPHour = ((double)TotalEXP / ((double)Minutes / (double)60) );
          double BarsHour = ((double)BarCount / ((double)Minutes / (double)60) );
          if((BankCount(155)/CoalAmount) >= BankCount(OreID))
          {
              PotentialBars = BankCount(155)/BankCount(OreID);
          }
          else
          {
              PotentialBars = BankCount(OreID)/BankCount(155);
          }
          Println("====================Trip " +Trips+"====================");
          Println("Levels Gained: " +LVL);
          Println("Exp Gained: " +TotalEXP);
          Println("Minutes Running: " +Minutes);
          Println("Exp Per Hour: " +EXPHour);
          Println("Bars Smelted: " +BarCount);
          Println("Bars Per Hour: " +BarsHour);
          Println("Bars In Bank: " +BankCount(BarID));
          Println("Coal Remaining: " +BankCount(155));
          Println(Type+" Ore Remaining: " +BankCount(OreID));
          Println("Enough materials left for " +PotentialBars+ " bars.");
      }
      DisplayMessage("@red@STOPPED", 3);
   }
}