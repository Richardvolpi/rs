public class drunkenmuzzsilver extends Script
{
   public drunkenmuzzsilver(mudclient rs)
   {
      super(rs);
   }
   public String[] getCommands()
   {
      return new String[]{"dsilver"};
   }
   public void start(String command, String parameter[])
   {
      DisplayMessage("dsilver - @gre@drunkenmuzz",3);
      while (Running())
      {
         //Walk(156,508);
   Walk(156,513);
   Walk(156,524);
   Walk(156,533);
   Walk(158,542);
   Walk(163,545);

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
   int RockCoords[] = GetNearestObject(196);
      AtObject(RockCoords[0], RockCoords[1]);
   Wait(2000);
   }
   {
   Walk(158,541);
   Walk(158,530);
   Walk(157,521);
   Walk(156,513);
   Walk(152,508);
   Walk(151,503);
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
   while (InvCount(383) > 0)
   {
   Deposit(383,1);
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