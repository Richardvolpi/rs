public class drunkenmuzzgold extends Script
{
   public drunkenmuzzgold(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"dgold"};
   }
   public void start(String command, String parameter[])
   {
      DisplayMessage("dGold miner+banker - @gre@Drunkenmuzz",3);
      while (Running())
   if (command.equalsIgnoreCase("dgold"))     
{
   Walk(304,594);
   Wait(200);
   Walk(311,613);
   Wait(200);
   Walk(310,626);
   Wait(200);
   Walk(315,637);
   Wait(200);
   Walk(314,645);
   Wait(200);
   
{
         while (Running() == true && InvCount() < 30)
   {
   if (Fatigue() >= 90 && Running() == true)
   {
   while (Sleeping() == false)
   {
      Use(FindInv(1263));
      Wait(2000);
   }
   while (Sleeping() == true)
   {
   Wait(200);
   }
   }
   int RockCoords[] = GetNearestObject(112);
      AtObject(RockCoords[0], RockCoords[1]);
   Wait(2000);
   }
   {
   Walk(323,626);
   Wait(200);
   Walk(322,606);
   Wait(200);
   Walk(306,589);
   Wait(200);
   Walk(290,582);
   Wait(200);
   Walk(283,568);
   Wait(200);
   }
   while (QuestMenu() == false)
   {
   int BankerID = GetNearestNPC(95);
   TalkToNPC(BankerID);
   Wait(1000);
   }
   Answer(0);
   while (Bank() == false)
      Wait(1);
   while (InvCount(152) > 0)
   {
   Deposit(152,1);
   Wait(100);
   }
   while (InvCount(157) > 0)
   {
   Deposit(157,1);
   Wait(100);
   }
   while (InvCount(158) > 0)
         {
            Deposit(158,1);
            Wait(100);
         }
         while (InvCount(159) > 0)
         {
            Deposit(159,1);
            Wait(100);
         }
         while (InvCount(160) > 0)
         {
            Deposit(160,1);
            Wait(100);
         }
         CloseBank();
   }
      
      }
      DisplayMessage("@red@STOPPED", 3);
   }
}