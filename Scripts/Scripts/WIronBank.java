public class WIronBank extends Script
{
    public WIronBank(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"minewiron"};
    }
    public void start(String command, String parameter[])
    {
      DisplayMessage("@or2@SBoT: @ran@93dcthugs93", 3);
      while (Running())
       {
System.out.println("Current mining level is: " + GetStat(14));
        { 
         while (Running()  == true && InvCount() < 30)
           {
            if (Fatigue() >= 80 && Running() == true)
              {
               while (Sleeping() == false)
                 {
                  Use(FindInv(1263));
               Wait(2500);
                 }
               while (Sleeping() == true)
                 {
                  Wait(100);
                 }
              }
            int RockCoords[] = GetNearestObject(103);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(2000);
           }
         Walk(164,546);
         Wait(200);
         Walk(156,538);
         Wait(200);
         Walk(156,528);
         Wait(200);
         Walk(156,518);
         Wait(200);
         Walk(152,507);
         Wait(200);
         Walk(152,506);
         Wait(200);
         Walk(151,502);
         Wait(200);
         while (QuestMenu() == false)
           {
            int BankerID = GetNearestNPC(95);
            TalkToNPC(BankerID);
            Wait(1000);
           }
         Answer(0);
         while (Bank() == false)
            Wait(1);
         while (InvCount(151) > 0)
           {
            Deposit(151,1);
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
         Walk(151,502);
         Wait(200);
         Walk(152,506);
         Wait(200);
         Walk(158,507);
         Wait(200);
         Walk(156,518);
         Wait(200);
         Walk(156,528);
         Wait(200);
         Walk(156,538);
         Wait(200);
         Walk(164,546);
         Wait(200);
        }
      DisplayMessage("@or2@SBoT:@red@STOPPED", 3);
      }
}
}