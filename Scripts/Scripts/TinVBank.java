public class TinVBank extends Script
{
    public TinVBank(mudclient rs)
    {
        super(rs);
    }
    public String[] getCommands()
    {
        return new String[]{"minetinv"};
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
            int RockCoords[] = GetNearestObject(105);
            AtObject(RockCoords[0],RockCoords[1]);
            Wait(2000);
           }
        Walk(73,542);
         Wait(200);
          Walk(75,531);
         Wait(200);
         Walk(84,509);
         Wait(200);
         Walk(92,508);
         Wait(200);
         Walk(99,508);
         Wait(200);
         Walk(103,510);
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
         while (InvCount(202) > 0)
           {
            Deposit(202,1);
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
         Walk(103,510);
         Wait(200);
         Walk(99,508);
         Wait(200);
         Walk(92,508);
         Wait(200);
         Walk(84,509);
         Wait(200);
         Walk(75,531);
         Wait(200);
         Walk(73,542);
         Wait(200);
         Walk(72,548);
         Wait(200);
        }
      DisplayMessage("@or2@SBoT:@red@STOPPED", 3);
      }
}
}